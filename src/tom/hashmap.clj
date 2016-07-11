(ns tom.hashmap)

(defn replace-in
  "Replaces the value mapped to by the given collection of keys."
  [hm keys value]
  (update-in hm keys (constantly value)))

(defn- >>
  "Reduces args into hm with f."
  [f hm & args]
  (if (empty? args)
    hm
    (let [keys                  (first args)
          value                (second args)
          remaining-args  (rest (rest args))]
      (apply (partial >> f (f hm keys value)) remaining-args))))

(def >>update
  "Reduces args into hm with update-in."
  (partial >> update-in))

(def >>replace
  "Reduces args into hm with replace-in."
  (partial >> replace-in))
