(ns events-poc.application.controllers
  (:require [events-poc.logic :refer [calculate-limit]]
            [events-poc.gateways.credit-evaluation-event-producer :refer :all]))

(defn calculate-and-emit [invested event-producer]
  (emit-limit-defined-event event-producer "xxx" (calculate-limit invested))
  )