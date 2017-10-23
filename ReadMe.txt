Kenzan Employee RESTful Services
===========================
A Simple Employee REST server providing CRUD operations on Employee. 
High level summary of requirements being 
 - Needs to ba persistant/Cache storage
 - Employee Unique ID generation
 -Soft Delete of the employee ( Mark as Inactive)

Building and running the demo using Maven and eclipse tomcat
-----------------------------------------
The git repo consists full Eclipse project set up. After cloning or dowloading the repo
- import the project to eclipse as a maven project 
Run below to generate the KenzanAPI.war in the target directory

If need to add employee details during the startup , please refer to the \src\main\resources\initLoad.json file and update the json for new records

mvn clean install

tomcat deployment
=================
- Mandatory System properties to be added in the catalina.bat
set JAVA_OPTS=-DNodeID="CP1" -DbulkLoad="N"
NodeID: The server ID - used for creation of the unique employee ID
bulkLoad: governs whether the bulk load process is triggered or not

Database:
===========
Application is already configured to connect and work with CouchdDB deployed as docker app in ec2 server.
If this needs to be changed please edit src\main\resources\couchdb.properties
Please make sure the db name "kaizenemployee" is created before 

Log details:
================
application log is available at ${catalina.home}/logs/applicationlog.log
log4j.properties is available at src\main\resources\log4j.properties for any log enhancements
slf4j is used for logging framework with log4j as provider

User Info coded in the Service 
User ID :Pavan, Roles :ROLE_ADMIN,ROLE_USER , password : Pavan
User ID :Isaac, Roles :ROLE_ADMIN,ROLE_EMPLOYEE, password : ISAAC
User ID:newIsaac Roles:ROLE_EMPLOYEE, Password :ISAAC1

Services exposed & Test Results are attached in excel 
---------------------------------

Features considered for next steps and Open Items
------------------------------------------------
- Containerised Micro service Deployment architecture (Not in scope)- Dockerize tomcat with application deployed +Couch DB .  Couch DB runs in the same docker instance, MultiAZ would be achieved with CouchBD cluster replication syncronization between each Docker instance , while application 
- Server less deployment (Not in scope)- AWS lambda integration with JAX-RS services built via an adapter, CouchDB cluster deployed externally . API Gateway provides gateway façade for REST integration API
- Authentication and Authorization info is still internal and needs to be externalized
-the bulk load file can be made to load from external classpath instead of loaded as war bundled file
 