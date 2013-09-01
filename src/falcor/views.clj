(ns falcor.views
  "the views"
  (:require [hiccup.core :refer :all]
            [hiccup.page :refer :all]
            [hiccup.bootstrap.page :refer :all]
))

(declare template-base)

(defn index-page [request]
  (template-base
   [:h2 "Index"]))

(defn about-page [request]
  (template-base
   [:h2 "About"]))

(defn contact-page [request]
  (template-base
   [:h2 "Contact"]))

(defn template-base
  ""
  [content & opts]
  (html5
    [:head
     [:meta {:charset "utf-8"}]
     [:meta
      {:name "viewport",
       :content "width=device-width, initial-scale=1.0"}]
     [:meta {:name "description", :content "neuros.es is the home of Sam Halicke on the web. Thoughts on functional programming, web operations, projects, social and contact info."}]
     [:meta {:name "author", :content "Sam Halicke"}]
     [:link {:rel "shortcut icon", :href "/ico/favicon.png"}]
     [:title {} "neuros.es - the home of Sam Halicke on the web"]
     (include-js "//code.jquery.com/jquery.min.js")
     (include-bootstrap)
     (use-bootswatch-theme "functor")
     [:link {:href "/css/jumbotron-narrow.css", :rel "stylesheet"}]
     "<!--[if lt IE 9]><script src=\"/js/html5shiv.js\"></script><script src=\"/js/respond.min.js\"></script><![endif]-->"]
    [:body
     {}
     [:div.container
      [:nav.navbar.navbar-defaultnavbar-static-top
       {:role "navigation"}
       [:div.navbar-header
        [:button.navbar-toggle
         {:type "button" :data-toggle "collapse" :data-target "navbar-home-collapse"}
         [:span.sr-only "Toggle navigation"]
         [:span.icon-bar]
         [:span.icon-bar]
         [:span.icon-bar]
         ]
        [:a.navbar-brand {:href "/#"} "neuroses"]
        ]
       [:div.collapse.navbar-collapse.navbar-home-collapse
        [:ul.nav.navbar-nav
         [:li.active [:a {:href "/"} "home"]]
         [:li [:a {:href "/about"} "about"]]
         [:li [:a {:href "/contact"} "contact"]]
         [:li [:a {:href "/blog"} "blog"]]]]
       ]
      [:div.jumbotron
       [:h1.lead "Sam. I. Am."]
       [:p.lead
        "thoughts, musings, open source, and all that jazz."]
       ]
      [:div.row.marketing
       [:div.col-lg-6
        [:h4 "Blog"]
        [:p "Technical blog about a wide variety of topics: web operations, configuration management, web application architectures, Clojure, functional programming, and " [:abbr.initialism {:title "Amazon Web Services"} "AWS"]]
        [:h4 "Resources & Code"]
        [:p
         "My open source work, book reviews, documentation and community resources for FP/Clojure, current projects, and everything else."]
        [:ul.list-inline
         [:li [:a {:href "https://github.com/shalicke"} "Github"]]]
        ]
       [:div.col-lg-6
        [:h4 "Firehose"]
        [:p "A stream of updates from various sources."]
        [:a {:href "/firehose"} "Drink"]
        [:h4 "Distractions"]
        [:p "Other stuff I enjoy: Photography, dogs, silly gifs, language, literature, thought work, miniature things, and random life experiences."]
        [:ul.list-inline
         [:li
          [:a {:href "http://hipsterops.tumblr.com/"} "hipsterops, a tumblr"]]]
        [:h4 "Community & Social"]
        [:p "Meetups I'm active in, hackerspaces, etc."]
        [:ul.list-inline
         [:li [:a {:href "https://linkedin.com/in/samhalicke"} "LinkedIn"]]
         "|"
         [:li [:a {:href "/resume"} "Resume"]]
         "|"
         [:li [:a {:href "http://meetup.com/members/60698782"} "Meetup"]]
         "|"
         [:li [:a {:href "http://buildcibola.com/"} "Cibola"]]]
        ]]
      [:div.footer
       [:blockquote.text-muted "Il semble que la perfection soit atteinte non quand il n'y a plus rien à ajouter, mais quand il n'y a plus rien à retrancher."]
       [:p.text-muted.pull-right "- Antoine de Saint Exupery"]
       ]]]))
