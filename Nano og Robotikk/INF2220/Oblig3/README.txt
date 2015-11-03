1. The only real deviation from the Boyer Moore solution at slide 17 from the lecture is the underscore special cases.
In my code I had to make sure that I never jump over any underscores, which is why the if sentences are there to take care
of these special cases. Foe example if the mismatched letter has a shorter shift length (it occurs (starting at last index)
before the underscore) and so on. Other than that I have the badCharShift array with information of how many indexes I can
shift whenever I mismatch with a certain character, and use that to modify my offset which is what keeps track of where in the
haystack I compare the needle.

2. javac *.java
3. Oblig3.java
4. I've made the assumption that if I have a file with several lines, I can read them all in and handle it like one huge String
5. Just what I mentioned above
6. Everything works
7. Influenced by the lecture on Boyer Moore
