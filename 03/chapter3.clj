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
