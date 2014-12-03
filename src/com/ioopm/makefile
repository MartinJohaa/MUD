JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
        $(JC) $(JFLAGS) $*.java

CLASSES = \
        Avatar.java \
        Book.java \
        Course.java \
	Creature.java\
	Item.java\
	Key.java\
	ReadFile.java\
	Room.java\
	Sphinx.java\
	Student.java\
	Teacher.java\
        Main.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
        $(RM) *.class
