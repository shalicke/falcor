(ns falcor.db
  "The databasey things"
  (:import [java.lang Exception])
  (:require [monger.core :as mg]
            [clojure.string :as str]
            [environ.core :refer [env]]
            [monger.collection :as mc]))


(defn initialize!
  "Initializes the database connection."
  []
  (let [db-uri  (env :mongolab-uri)
        db-name (peek (str/split db-uri #"/"))]
    (try
      (mg/connect-via-uri! db-uri)
      (mg/set-db! (mg/get-db db-name))
      (catch Exception e (str "Exception while initializing: " (.getMessage e)))
      (finally true))))
