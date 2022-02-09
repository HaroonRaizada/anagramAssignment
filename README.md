#Anagram Assignment

1. This program will output the group of all analgrams together seperated by new line and within group by comma.
2. For considering production memory limitaion, Scanner with checking each line of the file, instead of loading complete file in one go . That complete
loading will load the file in memory and will create outOfMemory error in production.
3. Data structures that are used for this program are mainly Map and List.
  a. Map is used to ensure that we do not to loop twice to check anagrams. We are storing all words one by one in hashmap as key by sorting them, so that
   key is unique and value is List of possible anagrams.
   b. List to capture all the groups of anagrams.
   
   4. Usage of Map ensured that loop will be done only for file contents and it will help in improvement of Big O complexity.
   
   5. Test junit cases are written to check below scenarios:
       a. First test to test the sample files shared for this assignment.
       b. One Test to check what happen if filepath is incorrect.
       c. Test to see if junk data is passed in file.
	  	d. Test to check if there is no data in file.

6. To run this program below are some prequisites:
	java 8, maven
	
7. To test, we can use AnagramAssignment.jar (that I have manually added to test), run below command:
		#java -jar AnagramAssignment.jar  "filePath".
	Or if we want to generate new jar after modification follow below steps:

		Run mvn clean install at root path of the project(alongside pom.xml)
		After that insided Target folder "anagramGroupings-0.0.1-SNAPSHOT-jar-with-dependencies.jar" will be generated.Run command 
			#java -jar anagramGroupings-0.0.1-SNAPSHOT-jar-with-dependencies.jar  "filePath"
8. Lastly to run only test cases, run #mvn test




