(ns clojure-katas.gcd
  (:use [midje.sweet])
  (:require [clojure.math.numeric-tower :as math]))

(defn gcd [a b]
  (loop [x (min a b)
         y (max a b)]
    (let [r (rem x y)]
      (if (zero? r) y
        (recur y r)))))

; Worked example from http://en.wikipedia.org/wiki/Greatest_common_divisor
; * To compute gcd(48,18), divide 48 by 18 to get a quotient of 2 and a
;   remainder of 12.
; * Then divide 18 by 12 to get a quotient of 1 and a remainder of 6.
; * Then divide 12 by 6 to get a remainder of 0, which means that 6 is the gcd.
; * Note that we ignored the quotient in each step except to notice when the
;   remainder reached 0, signalling that we had arrived at the answer.

(facts "Greatest Common divisor:
gcd(a,0) = a
gcd(b, a mod b)"
              (gcd 3 0) => 3
              (gcd 48 180) => 12
              (gcd 9 28) => 1)
