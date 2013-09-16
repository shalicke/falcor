(ns falcor.views
  "the views"
  (:require [hiccup.core :refer :all]
            [hiccup.page :refer :all]
            [hiccup.element :refer :all]
            [hiccup.bootstrap.element :refer :all]
            [hiccup.bootstrap.page :refer :all]
            [falcor.blog :as blog]
            [falcor.content :as content :refer :all]))

(defn template-base
  [content-map & opts]
  (html5
    [:head
     [:meta {:charset "utf-8"}]
     [:meta
      {:name "viewport"
       :content "width=device-width, initial-scale=1.0"}]
     [:meta {:name "description", :content "neuros.es is the home of Sam Halicke on the web. Thoughts on functional programming, web operations, projects, social and contact info."}]
     [:meta {:name "author", :content "Sam Halicke"}]
     [:link {:rel "shortcut icon", :href "/ico/favicon.png"}]
     [:script {:type "text/javascript"}
      "(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-41196500-1', 'neuros.es');
  ga('send', 'pageview');"
      ]
     [:title {} "neuros.es - the home of Sam Halicke on the web"]
     (include-js "//code.jquery.com/jquery.min.js")
     (include-bootstrap)
     (include-css "/css/fonts.css")
     (use-bootswatch-theme "functor")
     (include-css "/css/jumbotron-narrow.css")
     (include-css "//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css")
     (include-css "/css/falcor.css")
     "<!--[if lt IE 9]><script src=\"/js/html5shiv.js\"></script><script src=\"/js/respond.min.js\"></script><![endif]-->"]
    [:body
     [:div#wrap
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
         [:span.text-muted.navbar-brand "neuros.es"]
         ]
        [:div.collapse.navbar-collapse.navbar-home-collapse
         [:ul.nav.navbar-nav
          [:li.active [:a {:href "/"} "home"]]
          [:li [:a {:href "/about"} "about"]]
          [:li [:a {:href "/contact"} "contact"]]
          [:li [:a {:href "/blog/"} [:strike "blog"]]]]]
        ]
       [:div#content
       (for [frag (:pre content-map)] frag)
       (for [frag (:main content-map)] frag)
       (for [frag (:post content-map)] frag)
       (for [frag (:disqus content-map)] frag)]]]
     [:div#footer.container
      [:blockquote.text-muted "Il semble que la perfection soit atteinte non quand il n'y a plus rien à ajouter, mais quand il n'y a plus rien à retrancher."]
      [:p.text-muted.pull-right "- Antoine de Saint Exupery"]]]))

(defn index-page [_]
  (template-base
   {:main content/index}))

(defn about-page [_]
  (template-base
   {:main content/about}))

(defn contact-page [_]
  (template-base
   {:main content/contact}))

(defn blog-index-page []
  (template-base
   {:pre content/blog-pre
    :main (blog/blog-index)}))

(defn blog-post [& {:keys [slug timestamp]}]
  (template-base
   {:main (blog/retrieve-content :slug slug)
    :disqus content/disqus}))

(defn firehose-page []
  (template-base
   {:main (blog/firehose)}))
