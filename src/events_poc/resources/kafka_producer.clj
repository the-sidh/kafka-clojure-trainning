(ns events-poc.resources.kafka-producer
  ;(:gen-class)
  (:require
    [clojure.data.json :as json]
    [clojure.java.io :as jio]
    [events-poc.gateways.credit-evaluation-event-producer :refer [LimitDefinedEventProducer emit-limit-defined-event]]
    )
  (:import
    (java.util Properties)
    (org.apache.kafka.clients.producer Callback KafkaProducer ProducerConfig ProducerRecord)
    ))

(defn- build-properties [config-fname]
  (with-open [config (jio/reader config-fname)]
    (doto (Properties.)
      (.putAll {ProducerConfig/KEY_SERIALIZER_CLASS_CONFIG   "org.apache.kafka.common.serialization.StringSerializer"
                ProducerConfig/VALUE_SERIALIZER_CLASS_CONFIG "org.apache.kafka.common.serialization.StringSerializer"})
      (.load config))))

(defn producer! [id content]
  (let [topic "ch7y7yv7-events"
        props (build-properties "resources/kafka.config")
        create-msg #(let [k id
                          v content]
                      (printf "Producing record: %s\t%s\n" k v)
                      (ProducerRecord. topic k v))]
    (with-open [producer (KafkaProducer. props)]
      (let [;; We can use callbacks to handle the result of a send, like this:
            callback (reify Callback
                       (onCompletion [this metadata exception]))]
        (.send producer (create-msg) callback)
        (.flush producer))
      )))

(defrecord LimitDefinedEventKafkaProducer []
  LimitDefinedEventProducer
  (emit-limit-defined-event [_ id credit-value]
    (producer! id (json/write-str {:credit credit-value}))
    ))