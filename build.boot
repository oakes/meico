(set-env!
  :source-paths #{"src"}
  :dependencies '[[info.debatty/java-string-similarity "1.1.0"]
                  [com.thaiopensource/jing "20091111"]
                  [com.miglayout/miglayout "3.7.4"]
                  [com.io7m.xom/xom "1.2.10"]]
  :repositories (conj (get-env :repositories)
                  ["clojars" {:url "https://clojars.org/repo/"
                              :username (System/getenv "CLOJARS_USER")
                              :password (System/getenv "CLOJARS_PASS")}]))

(task-options!
  pom {:project 'org.clojars.oakes/meico
       :version "0.3.5-1"
       :description "A converter framework with support for MEI, MSM, MIDI, WAV, MP3, chroma, and XSLT"
       :url "https://github.com/oakes/meico"
       :license {"Public Domain" "http://unlicense.org/UNLICENSE"}}
  push {:repo "clojars"})

(deftask local []
  (comp (javac) (pom) (jar) (install)))

(deftask deploy []
  (comp (javac) (pom) (jar) (push)))

