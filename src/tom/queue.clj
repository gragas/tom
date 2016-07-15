(ns tom.queue)

(defn new-queue
  "Returns a new empty queue."
  []
  (clojure.lang.PersistentQueue/EMPTY))

(def push
  "
  Takes a queue and any number of elements to be pushed onto the queue.
  Returns a queue with the elements pushed on.
  This has the exact same functionality as conj for queues.
  "
  conj)
