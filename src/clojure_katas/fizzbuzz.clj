(ns clojure-katas.fizzbuzz
  (:use [midje.sweet]))

(defn fizzbuzz [n]
  (let [s (str (when (zero? (mod n 3)) "fizz")
               (when (zero? (mod n 5)) "buzz"))]
    (if (empty? s) n s)))

(facts "Fizzbuzz returns \"fizz\" when the number is divisible
by 3, and \"buzz\" when the number is divisible by 5.  If divisible by
3 AND 5, return \"fizzbuzz\".  Otherwise, return the number."

              (fizzbuzz 3) => "fizz"
              (fizzbuzz 5) => "buzz"
              (fizzbuzz 15) => "fizzbuzz"
              (fizzbuzz 7) => 7
              (fizzbuzz 7) =not=> "fizz")
