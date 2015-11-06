JC = javac
JD = javadoc
JDFLAGS =
JFLAGS =
RM = rm -f
NEEDLE = needle.txt
HAYSTACK = haystack.txt

all: Oblig3.class Boyer.class

run: Oblig3.class Boyer.class
	java Oblig3 $(NEEDLE) $(HAYSTACK)

Oblig3.class: Oblig3.java
	$(JC) $(JFLAGS) $<

Boyer.class: Boyer.java
	$(JC) $(JFLAGS) $<

doc: Oblig3.java
	$(JD) $(JDFLAGS) $<

clean:
	$(RM) *.class *.html *.css *.js package-list
