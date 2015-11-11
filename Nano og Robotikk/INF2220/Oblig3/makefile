JC = javac
JD = javadoc
JDFLAGS =
JFLAGS =
RM = rm -f
NEEDLE = needle.txt
ONEUNEEDLE = oneUnderscore.txt
EMPTYNEEDLE = emptyNeedle.txt
MANYUNEEDLE = manyUnderscores.txt
LASTUNEEDLE = lastUNeedle.txt
HAYSTACK = haystack.txt
EMPTYHAYSTACK = emptyHaystack.txt


all: Oblig3.class Boyer.class

run: Oblig3.class Boyer.class
	java Oblig3 $(NEEDLE) $(HAYSTACK)

runEmptyN: Oblig3.class Boyer.class
	java Oblig3 $(EMPTYNEEDLE) $(HAYSTACK)

runLastU: Oblig3.class Boyer.class
	java Oblig3 $(LASTUNEEDLE) $(HAYSTACK)

runManyU: Oblig3.class Boyer.class
	java Oblig3 $(MANYUNEEDLE) $(HAYSTACK)

runOneU: Oblig3.class Boyer.class
	java Oblig3 $(ONEUNEEDLE) $(HAYSTACK)

runEmptyH: Oblig3.class Boyer.class
	java Oblig3 $(NEEDLE) $(EMPTYHAYSTACK)

Oblig3.class: Oblig3.java
	$(JC) $(JFLAGS) $<

Boyer.class: Boyer.java
	$(JC) $(JFLAGS) $<

doc: Oblig3.java
	$(JD) $(JDFLAGS) $<

clean:
	$(RM) *.class *.html *.css *.js package-list
