(meditations
  "You will face many decisions"
  (= :a (if (false? (= 4 5))
            :a
            :b))

  "Some of them leave you no alternative"
  (= [] (if (> 4 3)
            []))

  "And in such a case you may have nothing"
  (= nil (if (nil? true)
             [:a :b :c]))

  "In others your alternative may be interesting"
  (= :glory (if (not (empty? ()))
                :doom
                :glory))

  "You may have a multitude of possible paths"
  (let [x 5]
    (= :your_road (cond (= x 6) :road_not_taken
                        (= x 7) :another_road_not_taken
                        :else :your_road)))

  "Or your fate may be sealed"
  (= 'doom (if-not (zero? 1)
                'doom
                'doom)))

