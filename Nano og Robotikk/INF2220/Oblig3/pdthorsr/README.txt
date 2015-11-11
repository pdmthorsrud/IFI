1. The only real deviation from the Boyer Moore solution at slide 17 from the lecture is the underscore special cases.
In my code I had to make sure that I never jump over any underscores, which is why the if sentences are there to take care
of these special cases. For example if the mismatched letter has a shorter shift length (it occurs (starting at last index)
before the underscore) and so on. Other than that I have the badCharShift array with information of how many indexes I can
shift whenever I mismatch with a certain character, and use that to modify my offset which is what keeps track of where in the
haystack I compare the needle.

2. make all
make run
OUTPUT:
The indexes at which 'a_' occur are as follows:
0 || String: ab
4 || String: a"
11 || String: ab
14 || String: a'
19 || String: ac
22 || String: ah
26 || String: aa
27 || String: ad
36 || String: as
44 || String: ad

make runEmptyN
OUTPUT:
The file is empty. Exiting program

make runEmptyH
OUTPUT:
The file is empty. Exiting program

make runOneU
OUTPUT:
There are no strings in haystack that matches 'b_c'

make runManyU
OUTPUT:
The indexes at which 'f___ad' occur are as follows:
40 || String: fuyiad

make runLastU
OUTPUT:
The indexes at which 'bas_' occur are as follows:
35 || String: basd

3. Oblig3.java
4. I've made the assumption that if I have a file with several lines, I can read them all in and handle it like one huge String
5. Just what I mentioned above
6. Everything works
7. Influenced by the lecture on Boyer Moore
