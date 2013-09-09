(ns falcor.blog
  "Blog functionality"
  (:import [java.lang Exception])
  (:require [markdown.core :as md]
            [clojure.string :as str]
            [monger.collection :as mc]
            [falcor.db :as db :only [initialize!]]
            [monger.result :only [ok?]]
            [monger.query :as q]))

(defn connected? []
  (if (bound? (var monger.core/*mongodb-connection*))
    true
    (do (try
          (db/initialize!)
          (catch Exception e (str "Exception connecting to MongoDB: " (.getMessage e)))
          (finally true)))))


(comment
  (defmacro m-try [mongo-function & _]
    (when (connected?)
      `(let [result# ~mongo-function]
         (if-not (true? (monger.result/ok? (first result#)))
           result#
           (throw (new Exception) (format "Mongo operation failed: %s with %s"
                                          ~mongo-function
                                          result#)))))))

(defn slugify
  [slug-name]
  (doall
   (map
    #(-> (str/join "-" (str/split % #"\s")) (str/lower-case)) slug-name)))

(defn retrieve-content
  [& {:keys [slug timestamp]}]
  (if (connected?)
    (->
     (q/with-collection "posts"
       (q/find {:slug slug})
       (q/fields [:timestamp :content ])
       (q/sort (array-map :timestamp -1))
       (q/limit 1))
     (first)
     :content
     (md/md-to-html-string)
     )
    (retrieve-content slug timestamp)))

(defn- post-content
  "for repl use"
  [slug-name filename]
  (let [slug (slugify (vector slug-name))
        content (slurp filename)
        id (System/currentTimeMillis)
        tags []
        categories []
        doc {:slug slug
             :content content
             :_id id
             :timestamp id
             :tags tags
             :categories categories}]
    (mc/insert "posts" doc)))

(defn- add-tag [])
(defn- add-category [])
