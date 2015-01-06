(ns risk.core
 (:require [clojure.pprint :as pp]))

(defn battle
  [attack-defense]
  (let [[attack defense] attack-defense]
    (if (> attack defense)
      :attack
      :defense)))

(defn attack!
  [num-attack num-defense]
  (let [roll-fn (fn [] (+ (rand-int 6) 1))
        attacks (sort > (take num-attack (repeatedly roll-fn)))
        defenses (sort > (take num-defense (repeatedly roll-fn)))
        comparisons (interleave attacks defenses)
        results (map battle (partition 2 comparisons))]
    [(count (filter #(= :defense %) results))
     (count (filter #(= :attack %) results))]))

(defn determine-size
  [num-attack num-defense]
  [(if (> num-attack 3) 3 num-attack)
   (if (> num-defense 2) 2 num-defense)])

(defn assault
  [num-attack num-defense]
  (loop [attack num-attack defense num-defense]
    (if (or (= attack 0) (= defense 0))
      (list attack defense)
      (let [result (apply attack! (determine-size attack defense))]
        (recur (- attack (first result))
               (- defense (last result)))))))

(defn chances
  [num-attack num-defense]
  (let [tries 10000
        results (repeatedly (fn [] (assault num-attack num-defense)))
        win-fn (fn [x] (let [[a d] x] (> a d)))
        wins (filter win-fn (take tries results))
        num-wins (count wins)]
    (format "%.2f" (* 100 (float (/ num-wins tries))) 2)))

(defn run-attack
  [defense]
  (loop [attack 10 results {}]
    (if (= attack 0)
      results
      (recur (dec attack)
             (assoc results attack (chances attack defense))))))

(defn build-table
  []
  (loop [defense 1 results []]
    (if (= defense 11)
      results
      (recur (inc defense) (conj results (run-attack defense) )))))

(defn print-table [] (pp/print-table (build-table)))
