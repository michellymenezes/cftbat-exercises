; 1. You used (comp :intelligence :attributes) to create a function that returns
; a character’s intelligence. Create a new function, attr, that you can call like
; (attr :intelligence) and that does the same thing.

(defn attr
  [attribute]
  (comp attribute :attributes))


; 2. Implement the comp function.

(defn comp-function
  ([function]
    function)
  ([function & functions]
  (fn [& args]
    (function (apply (apply comp-function functions) args)))))


; 3. Implement the assoc-in function. Hint: use the assoc function and define
; its parameters as [m [k & ks] v].

(defn assoc-in-function
  ([m [k & ks] v]
  (if (empty? ks)
  (assoc m k v)
  (assoc m k (assoc-in-function {} ks v)))))

; 4. Look up and use the update-in function.

(def character
  {:name "Smooches McCutes"
   :attributes {:intelligence 10
                :strength 4
                :dexterity 5}})

(update-in character [:attributes :intelligence] + 10)
(update-in character [:attributes] assoc :speed 1)
