(defproject falcor "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://falcor.herokuapp.com"
  :license {:name "FIXME: choose"
            :url "http://example.com/FIXME"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojars.samhalicke/compojure "1.2.1-SNAPSHOT"]
                 [ring/ring-jetty-adapter "1.2.0"]
                 [ring/ring-devel "1.2.0"]
                 [ring-basic-authentication "1.0.2"]
                 [environ "0.4.0"]
                 [org.clojars.samhalicke/hiccup-bootstrap "0.2.5"]
                 [com.cemerick/drawbridge "0.0.6"]
                 [hiccup "1.0.4"]
                 [clj-time "0.6.0"]
                 [com.novemberain/monger "1.6.0"]
                 ]
  :min-lein-version "2.0.0"
  :plugins [[environ/environ.lein "0.2.1"]]
  :hooks [environ.leiningen.hooks]
  :profiles {:production {:env {:production true}}})
