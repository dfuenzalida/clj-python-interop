(ns appcompany.funapp
    (:require [libpython-clj.python :as py :refer [py. py.- py.. py* py**]]
              appcompany.python
              [libpython-clj.require :refer [require-python import-python]]))

(import-python)

(require-python '[builtins :as python])
(require-python '[base64 :as pybase64])
(require-python '[funniest :as pyfunniest])

(defn encode-python [s]
  (let [bytes   (python/bytearray s "ascii")  ;; bytes = bytearray(s, "ascii")
        encoded (pybase64/b64encode bytes)    ;; encoded = base64.b64encode(bytes)
        b64enc  (py. encoded decode "utf-8")] ;; b64enc = encoded.decode("utf-8")
    b64enc))

(defn decode-java [s]
  (-> (.decode (java.util.Base64/getDecoder) s)
      (String. "UTF-8")))

;; Test the expressions below in the REPL:
(comment

  ;; Encode base 64 in Python and decode in java
  (-> "IT WORKS!" encode-python decode-java)

  ;; See https://python-packaging.readthedocs.io/en/latest/minimal.html
  ;; >>> import funniest
  ;; >>> funniest.joke()

  ;; Evaluating this expression should return a string
  (let [pyjoke (py/from-import funniest joke)]
       (pyjoke))

  ) ;; end comment

