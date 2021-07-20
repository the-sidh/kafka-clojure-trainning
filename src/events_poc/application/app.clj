(ns events-poc.application.app
  (:require [io.pedestal.http :as http]
            [events-poc.application.routes :as routes]
            )
  )

(defn create-server []
  (http/create-server                                       ;; <1>
    {::http/routes routes/routes                                  ;; <2>
     ::http/type   :jetty                                   ;; <3>
     ::http/port   8890}))

(defn start []
  (http/start (create-server)))

(defn -main [& args]
  (start)
  )