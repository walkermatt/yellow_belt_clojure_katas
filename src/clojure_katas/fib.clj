(ns clojure-katas.fib
  (:use [midje.sweet]))

(defn fib[n]
  (if (< n 2) n
      (+ (fib (dec n)) (fib (- n 2)))))

; F0 	 F1 	 F2 	 F3 	 F4 	 F5 	 F6 	 F7 	 F8
; 0  	 1  	 1  	 2  	 3  	 5  	 8  	 13 	 21

(facts "Calculate the fibonacci sequence
f(0) = 0, f(1) = 1
f(n) = f(n-1) + f(n-2)"
         (fib 0) => 0
         (fib 1) => 1
         (fib 3) => 2
         (fib 10) => 55)
