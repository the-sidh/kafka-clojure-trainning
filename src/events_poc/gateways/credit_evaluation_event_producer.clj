(ns events-poc.gateways.credit-evaluation-event-producer)
(defprotocol LimitDefinedEventProducer
  (emit-limit-defined-event [this id credit-value])
  )