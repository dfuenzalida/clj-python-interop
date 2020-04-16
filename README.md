# interop

A simple example of using libpython-clj with built-in and custom modules

## Usage

```
sudo apt-get install virtualenv

lein new app interop
cd interop
add [clj-python/libpython-clj "1.38"] to dependencies
lein deps
virtualenv --python=python3 env # creates an 'env' dir

./env/bin/pip3 install ./funniest
```

Validate with

```
./env/bin/python
Python 3.6.9 (default, Nov  7 2019, 10:44:02) 
[GCC 8.3.0] on linux
Type "help", "copyright", "credits" or "license" for more information.
>>> import funniest
>>> funniest.joke()
```

## License

Copyright © 2020 Denis Fuenzalida

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
