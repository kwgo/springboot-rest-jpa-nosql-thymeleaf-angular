# springboot-rest-jpa-nosql-thymeleaf-angular
The demo project with Springboot, Java, JPA, REST, NoSQL and Angular

# Home project by Jiang Chang
This is the repository for a demo project

### Skills
	1. Maven, Spring, SpringMVC and Springboot
	2. Hibernate, JPA and CSVJDBC
	3. Thymeleaf
	4. Log4j2
	5. AoP exception handler
	6. AJAX, JSON, REST and Lambda
	7. JUNIT, Mockito and Spring MockMvc
	8. HTML, CSS, Bootstrap, JavaScript and AngularJS
	9. Page navigation and error page


### Environment (Window)
* Add Java home
	1. Change "JAVA_HOME" system environment variable,
			mine is "c:\Program Files\Java\java-1.8.0-openjdk-1.8.0.265-3.b01.redhat.windows.x86_64"
	2. Check command: ***java -version***,
			expect: Java version: 1.8
	
* Install Maven
	1. Download: https://maven.apache.org/download.cgi
	2. Unpack to any folder,
			mine is "c:\apache-maven-3.6.3" 
	3. Add "Path" system environment variable,
			mine is "c:\apache-maven-3.6.3\bin" 
	4. Check command: ***mvn -version***,
			expect: Maven version, Maven home and Java version: 1.8

### Install project
* Install demo project
	1. Download: https://github.com/kwgo/springboot-rest-jpa-nosql-thymeleaf-angular
	2. Unzip to any folder,
			like "c:\demo-master"
			
* Build project and run test cases
	1. Build project,
			command: ***mvn clean package***
			
	2. Run test cases,
			command: ***mvn test***
			
### Start and test project
* Start project
	1. Goto unzip folder, start Springboot,
			command: ***mvn spring-boot:run***
	2. Open browser,
			type in url: http://localhost:8080
			
* Normal test steps:
	1. Select from date (January 01 2015)
	2. Select to date  (December 31 2020)
	3. Click "Query" button,
			expect: all of climate data shown up.
	4. Click "Page Navigation" buttons on the bottom,
			expect: page navigation button works.
	5. Click "Mean Temp" field of any row in the table,
			expect: a detail page shown up.
	
* Test steps with wrong date range selection:
	1. Select from date(January 01 2019) and to date(December 31 2016), click "Query" button,
			expect: a message shown up: The To date should be later than the From date.
	2. Select from or to date(February 30 2019), click "Query" button,
			expect: a message shown up: Please select a valid date.

* Page not found test steps:
	1. Type in any wrong url,
			expect: an error page shown up with message "Page not found, please check the URL".

			
### Contact
jiangchang@gmail.com

