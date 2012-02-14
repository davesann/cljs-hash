(ns 
  ^{:doc 
    "simple wrappers for easy use of goog hash functions"}
  cljs-hash.goog
  (:refer-clojure :exclude [hash])
  (:require 
     [goog.crypt     :as gcrypt]
     [goog.crypt.Md5 :as Md5]
     [goog.crypt.Sha1 :as Sha1])
  )

(defn string->bytes [s]
  (gcrypt/stringToUtf8ByteArray s))  ;; must be utf8 byte array

(defn bytes->hex 
  "convert bytes to hex"
  [bytes-in]
  (gcrypt/byteArrayToHex bytes-in))

(defn hash-bytes [digester bytes-in]
  (do 
    (.update digester bytes-in)
    (.digest digester)))
  



(defn md5- 
  "convert bytes to md5 bytes"
  [bytes-in] 
  (hash-bytes (goog.crypt.Md5.) bytes-in))

(defn md5-bytes
  "convert utf8 string to md5 byte array"
  [string]
  (md5- (string->bytes string)))

(defn md5-hex [string]
  "convert utf8 string to md5 hex string"
  (bytes->hex (md5-bytes string)))




(defn sha1- 
  "convert bytes to sha1 bytes"
  [bytes-in]
  (hash-bytes (goog.crypt.Sha1.) bytes-in))

(defn sha1-bytes
  "convert utf8 string to md5 byte array"
  [string]
  (sha1- (string->bytes string)))

(defn sha1-hex [string]
  "convert utf8 string to sha1 hex string"
  (bytes->hex (sha1-bytes string)))


(defn hash [algorithm string]
  (cond 
    (= :md5  algorithm) (md5-hex  string)
    (= :sha1 algorithm) (sha1-hex string)
    ))

