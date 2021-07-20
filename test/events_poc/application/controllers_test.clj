(ns events-poc.application.controllers-test
  (:use midje.sweet)
  (:use [events-poc.application.controllers])
  (:require [clojure.test :refer :all]
            [events-poc.logic :refer :all]
            [events-poc.resources.kafka-producer :refer :all]
            [events-poc.gateways.credit-evaluation-event-producer :refer :all]))

(defn mock-emit-credit-event [invested])

(defrecord MockProducer []
  LimitDefinedEventProducer
  (emit-limit-defined-event [_ id invested]
    (mock-emit-credit-event invested)))


(facts "about limit definition controller"
       (fact "should emit a limit defined event"
             (let [mock-producer (MockProducer.)]
               (calculate-and-emit 1000 mock-producer) => irrelevant
               (provided (mock-emit-credit-event 10000) => irrelevant :times 1)
               )
             )
       )