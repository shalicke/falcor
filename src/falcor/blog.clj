(ns falcor.blog
  "Blog functionality"
  (:import [java.lang Exception])
  (:require [markdown.core :as md]
            [clojure.string :as str]
            [monger.collection :as mc]
            [monger.result :only [ok?]]
            [monger.query :as q]))

(defmacro m-try [mongo-function]
  `(if-let [result# (monger.result/ok? ~mongo-function)]
     result#
     (throw (new Exception) (format "Mongo operation failed: %s with %s"
                               ~mongo-function
                               result#))))

(defn retrieve-content
  [& {:keys [slug timestamp]}]
  (->
   (q/with-collection "posts"
     (q/find {:slug slug})
     (q/fields [:timestamp :content ])
     (q/sort (array-map :timestamp -1))
     (q/limit 1))
   (first)
   :content
   (md/md-to-html-string)
   ))

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
    (m-try (mc/insert "posts" doc))))

(defn- add-tag [])
(defn- add-category [])

(defn slugify
  "doc-string"
  [slug-name]
  (doall
   (map
    #(-> (str/join "-" (str/split % #"\s")) (str/lower-case)) slug-name)))
