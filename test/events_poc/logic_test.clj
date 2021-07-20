(ns events-poc.logic-test
  (:use midje.sweet)
  (:use [events-poc.logic])
  (:require [clojure.test :refer :all])
  )

(facts "about the domain logic"
       (fact "given a credit evaluation should return the limit"
             (calculate-limit 10) => 100
             )
       )