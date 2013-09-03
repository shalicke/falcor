(ns falcor.content
  "Short package description.")

(def contact
  [[:div.container
    [:h3 "Contacting Me"]
    [:p "Feel free to use any medium you choose, although Twitter and email are probably best."]
    [:ul.list-unstyled
     [:li (fa-icon "envelope") " " (mail-to "sam@halicke.com" "Shoot me an email.")]
     [:li (fa-icon "twitter")  " " (link-to "https://twitter.com/samhalicke" "Or maybe you're a twitter person.")]
     [:li (fa-icon "linkedin") " " (link-to "https://linkedin.com/in/samhalicke" "Connect on LinkedIn, perhaps?")]
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
      [:li [:a {:href "http://buildcibola.com/"} "Cibola"]]]]]])

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
