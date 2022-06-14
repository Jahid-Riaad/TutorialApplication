# TutorialApplication
Assigment of Spring Boot application
Spring Boot + PostgreSQL + Rest CRUD API for a Tutorial application
Building a Spring Boot + PostgreSQL + Rest CRUD API for a Tutorial application in that:
•	Each Tutotial contains id, title, description, published status.
•	Apis help to create, retrieve, update, delete Tutorials.
•	Apis also support custom finder methods such as find by published status or by title.
These are APIs that I have provided with the application as you already mentioned:
Methods	Urls	Actions
POST	/api/tutorials	To create new Tutorial
GET	/api/tutorials	To retrieve all Tutorials
GET	/api/tutorials/:id	To retrieve a Tutorial by :id
PUT	/api/tutorials/:id	To update a Tutorial by :id
DELETE	/api/tutorials/:id	To delete a Tutorial by :id
DELETE	/api/tutorials	To delete all Tutorials
GET	/api/tutorials/published	To find all published Tutorials
GET	/api/tutorials/[keyword]	To find all Tutorials which title contains keyword
 I made CRUD operations & finder methods with Spring Data JPA’s JpaRepository,
And The database is PostgreSQL by configuring project dependency & datasources.


Technology Used:
•	Java 8
•	Spring Boot 
•	PostgreSQL
•	Maven 
Please do as below:
1) Make sure you have the right PostgreSQl environment to integrate this project.
2) By default this project will book 8080 port of your client machine.
3) Run the project as it is after cloning.





