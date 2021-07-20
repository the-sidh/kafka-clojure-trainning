(ns events-poc.application.routes
  (:require
    [io.pedestal.http.route :as route]
    [events-poc.application.interceptors :refer [define-limit]]))

(def routes
  (route/expand-routes
    #{["/limit" :post [define-limit]]}
    )
  )
