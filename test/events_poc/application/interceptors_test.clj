(ns events-poc.application.interceptors-test
  (:use midje.sweet)
  (:use [events-poc.application.interceptors])
  (:require [clojure.test :refer :all]
            [events-poc.application.controllers :refer :all]
            [events-poc.resources.kafka-producer :refer :all]))

(def context (hash-map :request (hash-map :query-params (hash-map :user-id "xxx" :credit 1000)))
  )
(fact "about interceptors"
      (fact "given a credit evaluation should call the logic to calculate the limit and emit an event"
            ((define-limit :enter) context) => irrelevant
            (provided (calculate-and-emit (BigDecimal. 1000) anything) => irrelevant :times 1)
            )
      )
