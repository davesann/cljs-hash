# cljs-hash

various hash functions for clojurescript

Wrapping js libs

supports:
 
 * md5
 * sha1
 * sha256

## Usage

* clojars [cljs-hash "0.0.1"]

* clojars [cljs-hash "0.0.2"]

added wrappers for goog md5 and sha1 for easy usage.

Note that these need a more recent version of the google closure library 
(because this defines some of the functions, including md5)

(you can find one here - https://github.com/davesann/clojurescript-goog-jar)

Your build will fail if you require cljs-hash.goog and do not have the newer version

```clojure
(ns examples.hash
  (:use 
    [cljs-hash.md5    :only [md5]]
    [cljs-hash.sha1   :only [sha1]]
    [cljs-hash.sha256 :only [sha256]])
  (:require
    [cljs-hash.goog :as gh]
    ))

(defn log-str 
  ([x]   (do (.log js/console (pr-str x)) x))
  ([m x] (do (log-str {:msg m :data x})   x)))

(log-str "hello" (md5    "hello"))
(log-str "hello" (sha1   "hello"))
(log-str "hello" (sha256 "hello"))
(log-str "政"    (md5 (js* "'政'")))
(log-str "政"    (gh/sha1-hex   "政"))
(log-str "goog - 政 md5hex"  (gh/md5-hex  "政"))
(log-str "goog - 政 sha1hex" (gh/sha1-hex  "政"))
(log-str "goog - 政 :md5"    (gh/hash :md5  "政"))
```

## License

Copyright (C) 2012 Dave Sann

Distributed under the Eclipse Public License, the same as Clojure.
