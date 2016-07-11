(ns tom.hashmap-test
  (:require [clojure.test :refer :all]
            [tom.hashmap :refer :all]))

(deftest replace-in-test1
  (let [input     {:a 10 :b 20}
        keys               [:a]
        value                20
        expected  {:a 20 :b 20}]
    (testing "Test replace-in."
      (is (= expected (replace-in input keys value))))))

(deftest replace-in-test2
  (let [input     {:a 10 :b 20}
        keys               [:b]
        value                30
        expected  {:a 10 :b 30}]
    (testing "Test replace-in."
      (is (= expected (replace-in input keys value))))))

(deftest replace-in-test3
  (let [input           {:a 10 :b 20}
        keys                     [:c]
        value                      30
        expected  {:a 10 :b 20 :c 30}]
    (testing "Test replace-in."
      (is (= expected (replace-in input keys value))))))

(deftest replace-in-test4
  (let [input          {:a nil :b 20}
        keys                  [:a :c]
        value                      30
        expected   {:a {:c 30} :b 20}]
    (testing "Test replace-in."
      (is (= expected (replace-in input keys value))))))

(deftest replace-in-test5
  (let [input                  {:a 420 :b 69}
        keys                          [:c :x]
        value                            1337
        expected  {:a 420 :b 69 :c {:x 1337}}]
    (testing "Test replace-in."
      (is (= expected (replace-in input keys value))))))

(deftest >>replace-test1
  (let [input                  {:a 420 :b 69}
        keys1                         [:c :x]
        value1                           1337
        expected  {:a 420 :b 69 :c {:x 1337}}]
    (testing "Test >>replace."
      (is (= expected (>>replace input keys1 value1))))))

(deftest >>replace-test2
  (let [input                                {:a 420 :b 69}
        keys1                                       [:c :x]
        value1                                         1337
        keys2                                       [:c :y]
        value2                                   'over-9000
        expected  {:a 420 :b 69 :c {:x 1337 :y 'over-9000}}]
    (testing "Test >>replace."
      (is (= expected (>>replace input
                          keys1 value1
                          keys2 value2))))))

(deftest >>update-test1
  (let [input                  {:a 420 :b 69}
        keys1                         [:c :x]
        value1              (constantly 1337)
        expected  {:a 420 :b 69 :c {:x 1337}}]
    (testing "Test >>update."
      (is (= expected (>>update input keys1 value1))))))

(deftest >>update-test2
  (let [input                           {:a {:c 420} :b 69}
        keys1                                       [:c :x]
        value1                            (constantly 1337)
        keys2                                       [:a :c]
        value2                                          inc
        expected  {:a {:c 421} :b 69 :c {:x 1337}}]
    (testing "Test >>update."
      (is (= expected (>>update input
                          keys1 value1
                          keys2 value2))))))
