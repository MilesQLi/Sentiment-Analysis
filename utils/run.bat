:: running script in Windows OS
::javac -encoding UTF-8 -classpath "seg.jar;stanford-postagger-3.2.0.jar;." edu/pku/sa/Main.java
:: 1100m is the largest memory my poor computer can afford...
::java -Xmx5100m -classpath "seg.jar;stanford-postagger-3.2.0.jar;." edu.pku.sa.Main
python regressor2.py ../src/train_xy.txt ../src/test_xy.txt ../result.txt