; 1. Use the str, vector, list, hash-map, and hash-set functions.

(str "using " "str " "function")

(vector 1 2 3)
[1 2 3]

(list 1 2 3)
'(1 2 3)

(hash-map :1 1 :2 2 :3 3)
{:1 1 :2 2 :3 3}

(hash-set 1 1 2 2 3 3)


; 2. Write a function that takes a number and adds 100 to it.

(defn add-100
  [n]
  (+ 100 n))


; 3. Write a function, dec-maker, that works exactly like the function inc-maker
; except with subtraction:

(defn dec-maker
  [dec-by]
  #(- % dec-by))


; 4. Write a function, mapset, that works like map except the return value is a set:

(defn mapset
  [f coll]
  (loop [result (sorted-set)
    resto coll]
    (if (empty? resto)
      result
      (recur (conj result (f (first resto))) (rest resto)))))


; 5. Create a function that’s similar to symmetrize-body-parts except that it
; has to work with weird space aliens with radial symmetry. Instead of two eyes,
; arms, legs, and so on, they have five.

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])


(defn matching-parts
  [part n]
  (if (re-find #"^left-" (:name part))
    (multiply-parts part n)
    [part]))

(defn multiply-parts
  ([part n]
    (multiply-parts part n []))
  ([part n parts]
    (if (= 0 n)
    parts
    (multiply-parts part (dec n) (conj parts {:name (clojure.string/replace (:name part) #"^left" (str n))
                 :size (:size part)})))))

(defn better-symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set (matching-parts part 5))))
          []
          asym-body-parts))

; 6. Create a function that generalizes symmetrize-body-parts and the function
; you created in Exercise 5. The new function should take a collection of body
; parts and the number of matching body parts to add. If you’re completely new
; to Lisp languages and functional programming, it probably won’t be obvious how
; to do this. If you get stuck, just move on to the next chapter and revisit the
; problem later.


(defn general-symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts n]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set (matching-parts part n))))
          []
          asym-body-parts))
