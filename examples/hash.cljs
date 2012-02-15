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
(log-str "政 md5"    (md5    "政"))
(log-str "政 sha1"   (sha1   "政"))
(log-str "政 sha256" (sha256 "政"))
(log-str "goog - 政 md5hex"  (gh/md5-hex  "政"))
(log-str "goog - 政 sha1hex" (gh/sha1-hex  "政"))
(log-str "goog - 政 :md5"    (gh/hash :md5  "政"))