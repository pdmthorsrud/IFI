1. Compile the source code by running 'javac *.java'
2. Main.java includes the main-method
3. I've made the assumption that EOF is not something I have to take care of when text is received from terminal
4. No real peculiarities. The only thing to mention would be the fact that none of my methods took into account
the fact I had to write to file. This resulted in a few duplicated methods where 'System.out.println' is replaced
with 'writer.println'. (sorry about that)
EDIT: Realised now that I could just use 'java main -> utskrift.txt' to get everything from terminal straight into
the .txt. I did however leave the rest of the methods in there, but I commented them out.
5. Everything works as it should
6. My remove method has been heavily influenced by the remove method written in the book
