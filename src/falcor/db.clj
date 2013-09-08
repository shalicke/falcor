(ns falcor.db
  "The databasey things"
  (:require [monger.core :as mg]
            [clojure.string :as str]
            [monger.collection :as mc]))

(def db-uri (get (System/getenv "MONGOLAB_URI" "mongodb://localhost/testdb")))

(def db-name (peek (str/split db-uri #"/")))

(def default-collection "posts")

(defn initialize
  "Initializes the database connection."
  []
  (mg/connect-via-uri! db-uri)
  (mg/set-db! (mg/get-db db-name)))

(defn insert
  [str & coll]
  (let [coll (or coll
                 default-collection)
        body-map {:body str}]
    (mc/insert-and-return coll body-map)))

(initialize)
