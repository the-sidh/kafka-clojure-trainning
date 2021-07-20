(defproject events-poc "0.0.1-SNAPSHOT"
  :description "Cool new project to do things and stuff"
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :profiles {:dev {:dependencies [
                                  [midje "1.10.3"]
                                  [io.pedestal/pedestal.service       "0.5.9"]
                                  [io.pedestal/pedestal.jetty         "0.5.9"]
                                  [io.pedestal/pedestal.route       "0.5.9"] ;; Efficient routing algorithms and data structures
                                  [org.slf4j/slf4j-simple "1.7.28"]
                                  [org.clojure/data.json "0.2.6"]
                                  [org.apache.kafka/kafka-clients "2.1.0"]
                                  ]
                   }
             }
  )
  
