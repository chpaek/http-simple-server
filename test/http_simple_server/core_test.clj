(ns http-simple-server.core-test
  (:require [clojure.test :refer :all]
            [http-simple-server.core :refer :all]))
(def test_whole [["post_id" "user_id" "title" "description"]["1001" "user0001" "title 1001" "description 1001"]["1002" "user0002" "title 1002" "description 1002"]["1003" "user0003" "title 1003" "description 1003"]["1004" "user0003" "title 1004" "description 1004"]["1005" "user0004" "title 1005" "description 1005"]["1006" "user0005" "title 1006" "description 1006"]["1007" "user0001" "title 1007" "description 1007"]["1008" "user0006" "title 1008" "description 1008"]["1009" "user0002" "title 1009" "description 1009"]["1010" "user0008" "title 1010" "description 1010"]["1011" "user0005" "title 1011" "description 1011"]["1012" "user0003" "title 1012" "description 1012"]["1013" "user0001" "title 1013" "description 1013"]["1014" "user0008" "title 1014" "description 1014"]["1015" "user0009" "title 1015" "description 1015"]["1016" "user0005" "title 1016" "description 1016"]["1017" "user0002" "title 1017" "description 1017"]["1018" "user0008" "title 1018" "description 1018"]["1019" "user0001" "title 1019" "description 1019"]["1020" "user0009" "title 1020" "description 1020"]["1021" "user0010" "title 1021" "description 1021"]["1022" "user0004" "title 1022" "description 1022"]["1023" "user0003" "title 1023" "description 1023"]["1024" "user0008" "title 1024" "description 1024"]["1025" "user0010" "title 1025" "description 1025"]["1026" "user0001" "title 1026" "description 1026"]["1027" "user0010" "title 1027" "description 1027"]["1028" "user0002" "title 1028" "description 1028"]["1029" "user0010" "title 1029" "description 1029"]["1030" "user0005" "title 1030" "description 1030"]["1031" "user0001" "title 1031" "description 1031"]["1032" "user0010" "title 1032" "description 1032"]["1033" "user0010" "title 1033" "description 1033"]["1034" "user0008" "title 1034" "description 1034"]["1035" "user0008" "title 1035" "description 1035"]["1036" "user0002" "title 1036" "description 1036"]["1037" "user0005" "title 1037" "description 1037"]["1038" "user0006" "title 1038" "description 1038"]["1039" "user0008" "title 1039" "description 1039"]["1040" "user0001" "title 1040" "description 1040"]["1041" "user0008" "title 1041" "description 1041"]["1042" "user0002" "title 1042" "description 1042"]["1043" "user0005" "title 1043" "description 1043"]["1044" "user0004" "title 1044" "description 1044"]["1045" "user0001" "title 1045" "description 1045"]["1046" "user0006" "title 1046" "description 1046"]["1047" "user0002" "title 1047" "description 1047"]["1048" "user0001" "title 1048" "description 1048"]["1049" "user0004" "title 1049" "description 1049"]["1050" "user0001" "title 1050" "description 1050"]])
(def test_empty [])
(def test_w_headers [["post_id" "user_id" "title" "description"]["1001" "user0001" "title 1001" "description 1001"]["1002" "user0002" "title 1002" "description 1002"]])
(def test_wo_headers [ ["1001" "user0001" "title 1001" "description 1001"]["1002" "user0002" "title 1002" "description 1002"]])

(deftest a-test
  (testing "FIXME, I fail."
    (is (not= 0 1)))
  (is (= test_wo_headers (remove_header test_w_headers "post_id")))
  (is (not= test_wo_headers (remove_header test_w_headers "user_id")))
  (is (= 50 (count_sum test_whole)))
  (is (= 0 (count_sum test_empty)))
  (is (= 2 (count_sum test_wo_headers)))




  )
