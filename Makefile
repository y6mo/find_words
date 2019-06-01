JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Node.java \
	Trie.java \
	Words.java

TEST = \
    TrieTest.java \
    WordsTest.java

default: classes test

classes: $(CLASSES:.java=.class)

test: TrieTest.java WordsTest.java
	javac -cp junit-4.12.jar:hamcrest-core-1.3.jar:. TrieTest.java
	javac -cp junit-4.12.jar:hamcrest-core-1.3.jar:. WordsTest.java
clean:
	rm *.class
