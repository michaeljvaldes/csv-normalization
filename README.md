# Csv Normalizer
We gonna normalize some csv files to*day*.

Get rid of your invalid utf8 and make some simple data transformations, hassle-free!


## Requirements
* Java (14+, 16 works)
* Maven
		
## Download Java
* [...from open jdk from jdk.java.net](https://jdk.java.net/16/)
* [...or with homebrew](https://mkyong.com/java/how-to-install-java-on-mac-osx/#homebrew-install-latest-java-on-macos)


<em>this program was built with openjdk 14 and runs with higher versions like 16</em>
## Install Maven
[Download maven 3](https://maven.apache.org/download.cgi)

[Follow installation instructions](https://maven.apache.org/install.html)

* tl;dr add mvn to path
* export PATH=/opt/apache-maven-3.8.1/bin:$PATH

## To Run:
You can execute the following commands in the root directory:
* build jar: `mvn clean package`
* execute jar: `java -jar target/csv-normalization-1.0.0-SNAPSHOT.jar < [input_file.csv] > [output_file.csv] `
* execute jar and also print errors: `java -jar target/csv-normalization-1.0.0-SNAPSHOT.jar < [input_file.csv] > [output_file.csv] 2> [err.log]`
* just run tests: `mvn test`

<em>Some input csv files are included in src/test/resources for testing various scenarios</em>
		
