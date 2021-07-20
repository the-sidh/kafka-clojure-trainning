(ns events-poc.application.interceptors
  (:require [events-poc.application.controllers :as c]
            [events-poc.resources.kafka-producer :refer :all])
  (:import (events_poc.resources.kafka_producer LimitDefinedEventKafkaProducer)))

(def define-limit
  {:name  :calculate
   :enter (fn [context]
            (let [user-id (get-in context [:request :query-params :user-id])
                  credit (get-in context [:request :query-params :credit])]
              (c/calculate-and-emit (BigDecimal. credit) (LimitDefinedEventKafkaProducer.))))})