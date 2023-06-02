(ns http-simple-server.core-test
  (:require [clojure.test :refer :all]
            [http-simple-server.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (not= 0 1)))
  (is (= 50 (count_sum ( load-csv "./test.csv"))))
  (is (= 0 (count_sum ( load-csv "./empty.csv"))))


  )
