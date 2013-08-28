(ns falcor.post
  "The post record and associated functions"
  (:require [clj-time.local :as t]
            [falcor.db :as db]
            [monger.core :as mc]))

(defrecord Post [])

(defn insert-post
  "inserts a new post into the database from timestamp, body, and additional arguments"
  [body & ts args]
  (let [time (or (t/to-local-date-time ts)
                 (t/local-now))
        coll "posts"
        record-body (map->Post {:timestamp ts :body body})
        ]
    (when (mc/ok?
           (db/insert coll record-body))
      [record-body]
      (throw (Exception. "Insert failed")))))

(defn retrieve-post
  "retrieves a post object from the database."
  [id]
  (let [post-id (str id)]



    )
  )
