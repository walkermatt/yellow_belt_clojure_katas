(ns clojure-katas.reverseword
  (:use [midje.sweet]))

(defn reverse-word [word]
  (apply str (reverse word)))

(fact "Reverse a given input word"
 (reverse-word "looc") => "cool")
