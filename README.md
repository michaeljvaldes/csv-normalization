# Requirements
* Java (14+)
* Maven

# [Download maven 3](https://maven.apache.org/download.cgi)

[follow installation instructions](https://maven.apache.org/install.html)

* tl;dr add mvn to path
* export PATH=/opt/apache-maven-3.8.1/bin:$PATH
		
# [Download open jdk](https://jdk.java.net/)

set environment variables

* JAVA_HOME=g:\JDK\OpenJDK\jdk-14
* PATH= g:\JDK\OpenJDK\jdk-14\bin;…

this program was built with openjdk 14

# To Run:
Execute the following commands in the root directory:
* mvn clean package
* java -jar target/csv-normalization-1.0.0-SNAPSHOT.jar < [input_file.csv] > [output_file.csv] 
		
