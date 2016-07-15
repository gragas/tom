(ns tom.queue-test
  (:require [clojure.test :refer :all]
            [tom.queue :refer :all]))

(deftest new-queue-test1
  (let [queue (new-queue)]
    (testing "Test new-queue."
      (is (= clojure.lang.PersistentQueue/EMPTY queue)))))

(deftest new-queue-test2
  (let [queue (new-queue)]
    (testing "Test new-queue."
      (is (empty? queue)))))

(deftest push-test1
  (let [queue (push (new-queue) 1)]
    (testing "Test push."
      (is (= [1] queue)))))

(deftest push-test2
  (let [queue (push (new-queue) 1 2 3)]
    (testing "Test push."
      (is (= [1 2 3] queue)))))

(deftest pop-test1
  (let [queue (pop (push (new-queue) 1))]
    (testing "Test pop."
      (is (= [] queue)))))

(deftest pop-test2
  (let [queue (pop (push (new-queue) 1 2 3))]
    (testing "Test pop."
      (is (= [2 3] queue)))))

(deftest peek-test1
  (let [value (peek (push (new-queue) 1))]
    (testing "Test peek."
      (is (= 1 value)))))

(deftest peek-test2
  (let [value (peek (push (new-queue) 3 2 1))]
    (testing "Test peek."
      (is (= 3 value)))))
