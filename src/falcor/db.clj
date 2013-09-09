(ns falcor.db
  "The databasey things"
  (:import [java.lang Exception])
  (:require [monger.core :as mg]
            [clojure.string :as str]
            [environ.core :refer [env]]
            [monger.collection :as mc]))

(def db-uri (env :mongolab-uri))
(def db-name (peek (str/split db-uri #"/")))
(def default-collection "posts")

(defn initialize!
  "Initializes the database connection."
  []
  (try
    (mg/connect-via-uri! db-uri)
    (mg/set-db! (mg/get-db db-name))
    (catch Exception e (str "Exception while initializing: " (.getMessage e)))
    (finally true)))
