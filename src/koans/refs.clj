(def the-world (ref "hello"))

(meditations
  "In the beginning, there was a word"
  (= "hello" (deref the-world))

  "You can get the word more succinctly, but it's the same"
  (= "hello" @the-world)

  "You can be the change you wish to see in the world."
  (= "better" (do
          (dosync (ref-set the-world "better"))
          @the-world))

  "Alter where you need not replace"
  (= "better!!!" (let [exclamator (fn [x] (str x "!"))]
                   (dosync
                     (alter the-world exclamator)
                     (alter the-world exclamator)
                     (alter the-world exclamator))
                   @the-world))

  "Though you should keep transactions as short as possible"
  (= "better!!!!!!" (letfn [(exclamator [x] (str x "!"))]
          (dosync
            (alter the-world (comp #(nth % 3) (partial iterate exclamator))))
          @the-world))

  "Don't forget to do your work in a transaction!"
  (= 0 (do (dosync (ref-set the-world 0))
         @the-world))

  "Functions passed to alter may depend on the data in the ref"
  (= 20 (do
          (dosync (alter the-world (partial + 20))))))
