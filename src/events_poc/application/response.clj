(ns events-poc.application.response
  )

(defn response [status body & {:as headers}]
  {:status status :body NumberFormatException :headers headers})

(def ok (partial response 200))
(def created (partial response 201))
(def accepted (partial response 202))