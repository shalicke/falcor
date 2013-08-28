(ns falcor.db
  "The databasey things"
  (:require [monger.core :as mg]
            [monger.collection :as mc]))

(def default-database "blog")
(def default-collection "posts")

(defn initialize
  "Initializes the database connection."
  []
  (mg/connect!)
  (mg/set-db! (mg/get-db default-database)))

(defn insert
  [str & coll]
  (let [coll (or coll
                 default-collection)
        body-map {:body str}]
    (mc/insert-and-return coll body-map)))
