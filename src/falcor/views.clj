(ns falcor.views
  "the views"
  (:require [hiccup.core :refer :all]
            [hiccup.page :refer :all]
            [hiccup.bootstrap.page :refer :all]))

(defn index-page [request]
  (template-base [:h2 "Welcome."]))

(defn about-page [request]
  (template-base
      [:h2 "Content"]))

(def index-content
  [
   [:div
    {:class "jumbotron"}
    [:h1 {} "Sam. I. Am."]
    [:p
     {:class "lead"}
     "Welcome. Here's where you'll find most of my stuff. Thougts, musings, social media, open source code, and all that jazz."]
    ]
   [:div
    {:class "row marketing"}
    [:div
     {:class "col-lg-6"}
     [:h4 {} "Blog"]
     [:p
      {}
      "Technical blog about operations, Clojure, functional programming, and AWS"]
     [:h4 {} "Code"]
     [:p
      {}
      "Open source-y things."]
     [:h4 {} "Social"]
     [:p
      {}
      "Links to various social profiles and whatnot."]]
    [:div
     {:class "col-lg-6"}
     [:h4 {} "Work"]
     [:p
      {}
      "Where I'm currently working, LinkedIn, and resume."]
     [:h4 {} "Community"]
     [:p
      {}
      "Meetups I'm active in, hackerspaces, etc."]
     [:h4 {} "Charity"]
     [:p
      {}
      "If you're looking for a cause, here are some worthy ones."]]]

   ])

(defn template-base
  ""
  [content & opts]
   (html5
   [:html
    {:lang "en"}
    [:head
     {}
     [:meta {:charset "utf-8"}]
     [:meta
      {:name "viewport",
       :content "width=device-width, initial-scale=1.0"}]
     [:meta {:name "description", :content ""}]
     [:meta {:name "author", :content ""}]
     [:link {:rel "shortcut icon", :href "/ico/favicon.png"}]
     [:title {} "Narrow Jumbotron Template for Bootstrap"]
     (include-bootstrap)
     (use-bootswatch-theme "slate")
     [:link {:href "/css/jumbotron-narrow.css", :rel "stylesheet"}]
     "<!--[if lt IE 9]><script src=\"/js/html5shiv.js\"></script><script src=\"/js/respond.min.js\"></script><![endif]-->"]
    [:body
     {}
     [:div
      {:class "container"}
      [:div
       {:class "header"}
       [:ul
        {:class "nav nav-pills pull-right"}
        [:li {:class "active"} [:a {:href "#"} "Home"]]
        [:li {} [:a {:href "#"} "About"]]
        [:li {} [:a {:href "#"} "Contact"]]]
       [:h3 {:class "text-muted"} "Sam Halicke"]]
      [:div
       {:class "jumbotron"}
       [:h1 {} "Sam. I. Am."]
       [:p
        {:class "lead"}
        "Welcome. Here's where you'll find most of my stuff. Thougts, musings, social media, open source code, and all that jazz."]
       ]
      [:div.container.content content]
      [:div
       {:class "row marketing"}
       [:div
        {:class "col-lg-6"}
        [:h4 {} "Blog"]
        [:p
         {}
         "Technical blog about operations, Clojure, functional programming, and AWS"]
        [:h4 {} "Code"]
        [:p
         {}
         "Open source-y things."]
        [:h4 {} "Social"]
        [:p
         {}
         "Links to various social profiles and whatnot."]]
       [:div
        {:class "col-lg-6"}
        [:h4 {} "Work"]
        [:p
         {}
         "Where I'm currently working, LinkedIn, and resume."]
        [:h4 {} "Community"]
        [:p
         {}
         "Meetups I'm active in, hackerspaces, etc."]
        [:h4 {} "Charity"]
        [:p
         {}
         "If you're looking for a cause, here are some worthy ones."]]]
      [:div {:class "footer"} [:p {} "© Samuel Halicke 2013"]]]
     "<!-- /container -->"]]))
