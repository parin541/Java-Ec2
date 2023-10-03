********************************************************************************************************
********************************************************************************************************
Dockerize Spring Boot App using Maven Plugin and Deploy Spring Boot Application with Docker into AWS EC2 
********************************************************************************************************
********************************************************************************************************

Prerequisites:

1. Already installed Docker Desktop and requierd in runnnig mode.
2. Already signup for docker hub account. (https://hub.docker.com/)
3. Already signup AWS Free Tier account with already running one EC2 instance with Amazon linux


Steps

1. Open any Jaava spring boot applcation.


			
			
2. Create Dockerfile in Project's home redirecty.
	
	ex. awsdemo/Dockerfile
	
	
3. Add Docker command in as Dockerfile.
	
FROM openjdk:11              // It wi

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]                  // It will start applcation

	
4. Go to pom.xml and add required dependacny for 'dockerfile-maven-plugin' in build section.

			<plugin>
				<!-- https://mvnrepository.com/artifact/com.spotify/dockerfile-maven-plugin -->
					<groupId>com.spotify</groupId>
					<artifactId>dockerfile-maven-plugin</artifactId>
					<version>1.4.3</version>
				<executions>
					<execution>
						<id>default</id>
						<goals>
							<goal>build</goal>
							<goal>push</goal>
						</goals>
					</execution>
				</executions>
				<configuration>
					<repository>{DockerhubRepositoryname/imagename}</repository>
					<username>{dockerhub username}</username>
					<password>{dockerhub password}</password>
					<tag>${project.version}</tag>
				</configuration>
				<dependencies>
					<!-- To make this work on JDK 9+ -->
					<dependency>
						<groupId>javax.activation</groupId>
						<artifactId>javax.activation-api</artifactId>
						<version>1.2.0</version>
					</dependency>
				</dependencies>
			</plugin>
	
		Note : provide your username and password for dockerhub account for above dependencies and also give unique tag
				name when you upload the same image with new changes.
		
5. 	Go to Docker Desktop and click on setting then set checkmark for checkbox option 
    'Expose demon on tcp://localhost:2375 without TLS'.
	
	Note : 'dockerfile-maven-plugin' will only work if option is checked.

6. Click on 'Appy & Restart' button.


7. Go to dockerhub and do login.
	https://hub.docker.com/

8. Click on repository.

9. go to your IDE and move to Maven terminal and type below command.
	command : 
	         mvn clean package dockefile:push
			 
	Note : Above command will clean,package the project and make docker image and then dockfile:push will push the
			image on dockerhub.
			
10. After succesully exection of command go to dockerhub refresh the page and check that new docker image is uploaded or not.

11. Go to Linux system and connect it using SSH

12. Go to Root directory by type below command.
	sudo -i
	
13  Update the sytem by type below commnad
	sudo yum update -y
	
14 Install the docker by type below command
	sudo yum install docker                
	
	Note : Type Y when it ask for permission to install
	
15 Start docker service by type below commad
	sudo service docker start
	
16	Type below commnad to check docker version
		
		docker -v
		
		
17 Go to AWS and make sure that for Inbound rules added for all ports
	
	Steps to modify current security group for EC2 instace.
	
	step 1 - Select EC2 intance and click on 'Security' tab
	Step 2 - Go to Inbount rules section 'click on launch wizard'
	Step 3 - Click on 'Edit Inbound rule' 
	step 3 - Click on  'Add rule'
	Step 4 - select Type as HTTP, Source as 'Anywhere-IPV4'
	Step 5 - Again click on on 'Add rule'
	Step 6 - select Type as HTTPS, Source as 'Anywhere-IPV4'
	
20 	Click on 'Save Rules'

21 Move to dockerhub portal in web browser and click on repository, 
    select image , click on 'Tags' tab.


22 copy the docker pull command from there. 
	ex.  
	docker pull parin541/awsdemo:0.0.1 
	
23 go to Terminal for linux system paste there.

	Note : use with 'sudo' if permission denied
	
24 To check docker image is downloaded or not check with below command.

	command = docker images
25 Now run the docker images with below command.

	command =  sudo docker run -d -p 8080:9091 --name spring-boot-docker parin541/awsdemo:0.0.1
	
	Note :  -d = it is for detached mode.
			8080 : docker is mapped application port.
			9091 : it is the application port.
			--name : name of container (you can give any name)
			parin541/awsdemo:0.0.1 : this is docker image name.
			
26. Type below command to check container is running or not for image.

	Command : sudo docker ps
	
	Note : it should display current running docker image in result.
	
27. Go to AWS console, go to EC2,select that linux sytem instance , In 'Descrption' tab
	click on 'Public IPv4 DNS' and copy that url and paste it in browser.
		
		URL : http://ec2-18-204-196-182.compute-1.amazonaws.com/
		
	
	Note : Try to reload this url in web browser for few times till around 5 mintues.
			then it will display the result.



		Other url of project for testing
		http://ec2-18-204-196-182.compute-1.amazonaws.com/greet/{name}
		
		http://ec2-18-204-196-182.compute-1.amazonaws.com/greet/{firstname}/and/{lastname}
		
