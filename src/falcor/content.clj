(ns falcor.content
  "Short package description."
  (:require [hiccup.bootstrap.element :refer :all]
            [hiccup.bootstrap.page :refer :all]
            [hiccup.page :refer :all]
            [hiccup.element :refer :all]
            ))

(def about
  [[:div.container.marketing
    [:h3 "About Me"]
    [:p "I was born in Chicago, IL. Having moved about the country and worked with some amazing people in amazing places, I have a pretty positive outlook on life. Currently, I live in Chicago's diverse Pilsen neighborhood with my boxer, Beau."]
    [:p "I'm pretty much all self-taught. I've spent many years in the operations world automating everything I can think of -- via homegrown tools, Puppet, Ruby/Python, Ansible, or some combination of all of those."]
    [:p "Currently looking for interesting Clojure-related projects to work on."]
    [:p.lead "tl;dr I'm always hacking on something, reading, learning, or making."]
    [:hr.featurette-divider]
    [:div.row.featurette
     [:div.col-lg-6
      [:h2.featurette-heading
       "Native Chicagoan."]
      [:p.lead "I've lived all over the US, but I keep coming back to my roots."]]
     [:div.col-lg-5.col-lg-push-1
      [:img.img-responsive.featurette-image.img-rounded {:src "/img/chicago_skyline.png"}]]]
    [:hr.featurette-divider]
    [:div.row.featurette
     [:div.col-lg-5
      [:img.img-responsive.featurette-image {:src "/img/flux_capacitor.png"}]]
     [:div.col-lg-6.pull-right
      [:h2.featurette-heading
       "Insatiable Hacker."]
      [:p.lead "If it's new, I want to do something with it."]]]
    [:hr.featurette-divider]
    [:div.row.featurette
     [:div.col-lg-6
      [:h2.featurette-heading
       "Voracious Reader."]
      [:p.lead "I relish the words of Yeats, Tolstoy, and Tolkien. I hear Paul Graham's a good read as well."]]
     [:div.col-lg-5.col-lg-push-1
      [:img.img-responsive.featurette-image {:src "/img/sicp.png"}]]]
    [:hr.featurette-divider]
    [:div.row.featurette
     [:div.col-lg-5
      [:img.img-responsive.featurette-image {:src "/img/open_sorceror.png"}]]
     [:div.col-lg-6.pull-right
      [:h2.featurette-heading
       "Open Sorceror"]
      [:p.lead "I advocate open source use and principles everywhere. I need to make more contributions."]]]

    ]])

(def contact
  [[:div.container.marketing
    [:h3 "Contacting Me"]
    [:p "Feel free to use any medium you choose, although Twitter and email are probably best."]
    [:ul.list-unstyled
     [:li (fa-icon "envelope") " " (mail-to "sam@halicke.com" "Shoot me an email.")]
     [:li (fa-icon "twitter")  " " (link-to "https://twitter.com/samhalicke" "Or maybe you're a twitter person.")]
     [:li (fa-icon "linkedin") " " (link-to "https://linkedin.com/in/samhalicke" "Connect on LinkedIn, perhaps?")]
     [:li (fa-icon "github-sign") " " (link-to "https://github.com/shalicke" "Ah, so GitHub's your bag.")]
     ]
    ]])

(def index
  [
   [:div.jumbotron
    [:h1.lead "Sam. I. Am."]
    [:p.lead
     "thoughts, musings, open source, and all that jazz."]
    ]
   [:div.row.marketing
    [:div.col-lg-6
     [:h4 "Blog"]
     [:em "coming soon, folks"]
     [:p "Technical blog about a wide variety of topics: web operations, configuration management, web application architectures, Clojure, functional programming, and " [:abbr.initialism {:title "Amazon Web Services"} "AWS"]]
     [:h4 "Resources & Code"]
     [:p
      "My open source stuff, book reviews, documentation and community resources for FP/Clojure, current projects, and everything else."]
     [:ul.list-inline
      [:li [:a {:href "https://github.com/shalicke"} "Github"]]]
     ]
    [:div.col-lg-6
     [:h4 "Firehose"]
     [:em "coming soon, folks"]
     [:p "A stream of updates from various sources."]
     [:a.text-muted {:href "/#"} [:strike "Drink"]]
     [:h4 "Distractions"]
     [:p "Other stuff I enjoy: Photography, dogs, silly gifs, language, literature, thought work, miniature things, and random life experiences."]
     [:ul.list-inline
      [:li
       [:a {:href "http://hipsterops.tumblr.com/"} "hipsterops, a tumblr"]]]
     [:h4 "Socialize"]
     [:p "Online profiles, meetups I'm active in, etc."]
     [:ul.list-inline
      [:li [:a {:href "https://linkedin.com/in/samhalicke"} "LinkedIn"]]
      "|"
      [:li [:a {:href "http://meetup.com/members/60698782"} "Meetup"]]
      "|"
      [:li [:a {:href "http://quora.com/Sam-Halicke"} "Quora"]]
      ]]]])

(def disqus
  [
   [:div {:id "disqus-thread"}]
   (javascript-tag
    "var disqus_shortname = 'neurosesblog';
    (function() {
        var dsq = document.createElement('script'); dsq.type = 'text/javascript'; dsq.async = true;
        dsq.src = '//' + disqus_shortname + '.disqus.com/embed.js';
        (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq);
    })();")
   [:noscript "Please enable JavaScript to view the comments powered by Disqus."]
   ])
