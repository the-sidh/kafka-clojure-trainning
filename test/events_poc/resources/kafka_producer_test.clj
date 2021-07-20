(ns events-poc.resources.kafka-producer-test
  (:use midje.sweet)
  (:use [events-poc.resources.kafka-producer])
  (:require [clojure.test :refer :all]
            [clojure.data.json :as json]
            [events-poc.gateways.credit-evaluation-event-producer :refer [LimitDefinedEventProducer emit-limit-defined-event]])
  (:import (events_poc.resources.kafka_producer LimitDefinedEventKafkaProducer)))

(facts "about kafka-producer"
       (fact "should call producer! with the right arguments"
             (emit-limit-defined-event (LimitDefinedEventKafkaProducer.) "xxx" 10000) => irrelevant
             (provided (producer! "xxx" (json/write-str {:credit 10000})) => irrelevant :times 1)
             ))