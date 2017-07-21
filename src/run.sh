javac -encoding UTF-8 -classpath "stanford-segmenter-3.4.1.jar:stanford-postagger-3.3.1.jar:." edu/pku/sa/Main.java

echo 'run feature extract...'
java -classpath "stanford-segmenter-3.4.1.jar:stanford-postagger-3.3.1.jar:." edu.pku.sa.Main ../data/train.xml ../data/movies.xml ../data/test.xml ../data/train_xy.txt ../data/test_xy.txt 