FROM openjdk:17

WORKDIR /usr/app

COPY target/virtual-bookstore-0.0.1-SNAPSHOT.war /usr/app

ENTRYPOINT ["java","-war","virtual-bookstore-0.0.1-SNAPSHOT.war"]