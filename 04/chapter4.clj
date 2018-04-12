; 1. Turn the result of your glitter filter into a list of names.

(def records [{:name "Edward Cullen", :glitter-index 10}
 {:name "Bella Swan", :glitter-index 0}
 {:name "Charlie Swan", :glitter-index 0}
 {:name "Jacob Black", :glitter-index 3}
 {:name "Carlisle Cullen", :glitter-index 6}])

(defn glitter-filter
  [minimum-glitter records]
  (map :name (filter #(>= (:glitter-index %) minimum-glitter) records)))


; 2. Write a function, append, which will append a new suspect to your list of
; suspects.

(defn append
  [suspects name glitter-index]
  (conj suspects {:name name :glitter-index glitter-index}))


; 3. Write a function, validate, which will check that :name and :glitter-index
; are present when you append. The validate function should accept two arguments:
; a map of keywords to validating functions, similar to conversions, and the
; record to be validated.

(defn validate
  [functions record]
  (and ((:name functions) record) ((:glitter-index functions) record)))


; 4. Write a function that will take your list of maps and convert it back to a
; CSV string. You’ll need to use the clojure.string/join function.

(defn str->csv
  [suspects]
  (clojure.string/join "\n" (map #(clojure.string/join "," [(:name %) (:glitter-index %)]) suspects)))
