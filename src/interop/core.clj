(ns interop.core
  (:require [libpython-clj.require :refer [require-python]]
            [libpython-clj.python :as py :refer [py. py.. py.-]]))
;; See
;; https://github.com/gigasquid/libpython-clj-examples/blob/master/src/gigasquid/_configure.clj

(require-python '[builtins :as python])
(require-python '[base64 :as pybase64])

(defn encode-python [s]
  (-> (python/bytearray s "ascii")
      pybase64/b64encode
      (py. decode "utf-8")))

(defn decode-java [s]
  (-> (.decode (java.util.Base64/getDecoder) s)
      (String. "UTF-8")))

;; Try these in the REPL:
;; (encode-python "it works!")
;; (decode-java "aXQgd29ya3Mh")

(defn -main [& _args]
  (py/initialize! :python-executable "env/bin/python3.6")
  (-> "IT WORKS!" encode-python decode-java println)
  (shutdown-agents))

