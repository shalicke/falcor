(ns falcor.web
  (:require [compojure.core :refer [defroutes GET PUT POST DELETE ANY]]
            [compojure.handler :refer [site]]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [ring.middleware.stacktrace :as trace]
            [ring.middleware.session :as session]
            [ring.middleware.session.cookie :as cookie]
            [ring.util.response :refer [response]]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.basic-authentication :as basic]
            [falcor.views :as views]
            [falcor.config :as cfg]
            [falcor.db :as db]
            [cemerick.drawbridge :as drawbridge]
            [hiccup.bootstrap.middleware :as mw]
            [environ.core :refer [env]]))

(defn- authenticated? [user pass]
  ;; TODO: heroku config:add REPL_USER=[...] REPL_PASSWORD=[...]
  (= [user pass] [(env :repl-user false) (env :repl-password false)]))

(def ^:private drawbridge
  (-> (drawbridge/ring-handler)
      (session/wrap-session)
      (basic/wrap-basic-authentication authenticated?)))

(defroutes app
  (route/resources "/")
  (route/resources "/bootstrap" {:root "bootstrap/public"})

  (ANY "/repl" {:as req}
                (drawbridge req))
  (ANY "/" {:as req}
       (views/index-page req))
  (ANY "/about" []
       views/about-page)
  (ANY "/contact" []
       views/contact-page)
  (ANY "/blog/" []
       (views/blog-index-page))
  (ANY "/blog/posts/:slug/" [slug]
       (views/blog-post :slug slug))
  (ANY "/blog/posts/:slug/:timestamp/" [slug timestamp]
       (views/blog-post :slug slug :timestamp timestamp))
  (ANY "/firehose" []
       (views/firehose-page))
  (ANY "*" []
       (route/not-found (slurp (io/resource "404.html")))))

(defn wrap-error-page [handler]
  (fn [req]
    (try (handler req)
         (catch Exception e
           {:status 500
            :headers {"Content-Type" "text/html"}
            :body (slurp (io/resource "500.html"))}))))

(defn -main [_]
  "run with immutant")
