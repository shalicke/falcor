(ns falcor.blog
  "Blog functionality"
  (:import [java.lang Exception])
  (:require [markdown.core :as md]
            [clojure.string :as str]
            [monger.collection :as mc]
            [monger.operators :refer [$gt $lt]]
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

(defn titlefy
  [title-name]
  (doall
    (map
      #(-> (str/join " " (str/split % #"-"))
           (str/capitalize))
      title-name)))

(defn slugify
  [slug-name]
  (doall
   (map
    #(-> (str/join "-" (str/split % #"\s")) (str/lower-case)) slug-name)))

(defn blog-index []
  (if (connected?)
    (let [recent-posts
          (q/with-collection "posts"
            (q/find {:published {$gt 0}})
            (q/fields [:_id :slug])
            (q/sort (array-map :_id -1))
            (q/limit 10))]
      [[:ul.post-list
        (for [post recent-posts]
          [:li [:a {:href (str "/blog/posts/" (first (:slug post)) "/")} (first (titlefy (:slug post)))]])]])))

(defn retrieve-content
  [& {:keys [slug timestamp]}]
  (if (connected?)
    (->
     (q/with-collection "posts"
       (q/find {:slug slug})
       (q/fields [:_id :content ])
       (q/sort (array-map :_id -1))
       (q/limit 1))
     (first)
     :content)
    (retrieve-content slug timestamp)))


(defn twitter
  []
  ["<a class='twitter-timeline' href='https://twitter.com/samhalicke' data-widget-id='377303783291633664'>Tweets by @samhalicke</a>
<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document,'script','twitter-wjs');</script>"])


(defn firehose []
  (twitter))

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
             :tags tags
             :published 1
             :categories categories}]
    (mc/insert "posts" doc)))

(defn- publish-content [slug-name]
  (let [slug (slugify (vector slug-name))]
    (when (connected?)
      (mc/update "posts" {:slug slug} {:published 1}))))

(defn- add-tag [])
(defn- add-category [])

(comment
  (post-content "hiccup notes" "/Users/shalicke/Documents/hiccup_notes.html")
)
