(ns clojure-katas.fib
  (:use [midje.sweet]))

;; Simple recursive version which consumes a lot of stack for "large" values
; (defn fib[n]
;   (if (< n 2) n
;       (+ (fib (dec n)) (fib (- n 2)))))

;; loop/recur version which can handle calculating much larger values and
;; is faster. Builds a vector of fibonacci numbers which it uses to calculate
;; successive values
(defn fib[n]
  (loop [nums []]
    (let [c (count nums)
          nums (conj nums (if (< c 2)
                            c
                            (reduce + (take-last 2 nums))))]
      (if (= c n)
        ; We're done, return the last value
        (last nums)
        ; Loop back passing the vector of values we've calculated so far
        (recur nums)))))

(facts "Calculate the fibonacci sequence
f(0) = 0, f(1) = 1
f(n) = f(n-1) + f(n-2)"
         (fib 0) => 0
         (fib 1) => 1
         (fib 3) => 2
         (fib 7) => 13
         (fib 10) => 55
         (fib 16) => 987
         (fib 20) => 6765)
