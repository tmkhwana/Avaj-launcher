
find . -name *.java > sources.txt
javac -sourcepath . @sources.txt
java com.tmkhwana.transport.Simulator scenario.txt