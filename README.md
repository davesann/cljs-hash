# cljs-hash

various hash functions for clojurescript

Wrapping js libs

supports:
 
 * md5
 * sha1
 * sha256

## Usage

* clojars [cljs-hash "0.0.1"]

```clojure

(ns examples.hash
  (:use 
    [cljs-hash.md5    :only [md5]]
    [cljs-hash.sha1   :only [sha1]]
    [cljs-hash.sha256 :only [sha256]]
    )
  )

(defn log-str 
  ([x]   (do (.log js/console (pr-str x)) x))
  ([m x] (do (log-str {:msg m :data x})   x)))

(log-str "hello" (md5    "hello"))
(log-str "hello" (sha1   "hello"))
(log-str "hello" (sha256 "hello"))
```

## License

Copyright (C) 2012 Dave Sann

Distributed under the Eclipse Public License, the same as Clojure.
