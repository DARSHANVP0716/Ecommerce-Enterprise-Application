#Build stage
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /build

# copy entire multi-module project
COPY . .

# build only config-server
RUN mvn -pl eureka-registry -am clean package -DskipTests


#Run stage
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

COPY --from=builder /build/eureka-registry/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
