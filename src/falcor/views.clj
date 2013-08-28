(ns falcor.views
  "the views"
  (:require [hiccup.core :refer :all]
            [hiccup.page :refer :all]
            [hiccup.bootstrap.page :refer :all]))

(defn template-base [& content]
  (html5
   [:head
    [:title "Odin"]
    (include-bootstrap)]
   [:body
    [:div.navbar-wrapper
     [:div.container
      [:div.navbar.navbar-inverse
       [:div.navbar-inner
        [:a.brand {:href "#"} "Odin"]
        [:ul.nav
         [:li
          [:a {:href "#"} "Instances"]]
         [:li
          [:a {:href "#"} "Statistics"]]]]]]]
    [:div.container.content content]
    ]))

(defn index-page [request]
  (template-base
      [:h2 "Content"]))

(defn info-page [request]
  (template-base
   [:h3 "info"]))
