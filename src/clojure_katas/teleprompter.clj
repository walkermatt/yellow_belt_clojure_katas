(ns clojure-katas.teleprompter
  (:use [midje.sweet]))

(defn translate [input-string dictionary]
  (loop [s input-string d dictionary]
    (if-let [[match replacement] (first d)]
      (recur (clojure.string/replace s match replacement) (rest d))
      s)))

(def dict-1 {"hizzle" "house"})
(def dict-2 {"hizzle" "house"
             "brainspin" "insomnia"})

(facts "Given an input text string and a list of slang words
and their translations, return a string cleansed of the slang words,
by replacing them with their translations."

 (translate "In the hizzle" dict-1) => "In the house"
 (translate "In the hizzle, hizzle" dict-1) => "In the house, house"
 (translate "In the hizzle, suffering from brainspin" dict-2)
    => "In the house, suffering from insomnia")
