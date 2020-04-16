(ns interop.core
  (:require [libpython-clj.require :refer [require-python]]
            [libpython-clj.python :as py :refer [py. py.. py.-]]))
;; See
;; https://github.com/gigasquid/libpython-clj-examples/blob/master/src/gigasquid/_configure.clj

(require-python '[builtins :as python])
(require-python '[base64 :as pybase64])

(defn encode-python [s]
  (let [bytes   (python/bytearray s "ascii")  ;; bytes = bytearray(s, "ascii")
        encoded (pybase64/b64encode bytes)    ;; encoded = base64.b64encode(bytes)
        b64enc  (py. encoded decode "utf-8")] ;; b64enc = encoded.decode("utf-8")
    b64enc))

(defn decode-java [s]
  (-> (.decode (java.util.Base64/getDecoder) s)
      (String. "UTF-8")))

;; Try these in the REPL:
;; (encode-python "it works!")
;; (decode-java "aXQgd29ya3Mh")

;; See https://python-packaging.readthedocs.io/en/latest/minimal.html
;; >>> import funniest
;; >>> funniest.joke()

;; (require-python '[funniest :as funniest])
;; (funniest/joke)

(defn -main [& _args]
  (py/initialize! :python-executable "./env/bin/python3.6" :library-path "./env/bin/lib")
  (-> "IT WORKS!" encode-python decode-java println)
  (shutdown-agents))

