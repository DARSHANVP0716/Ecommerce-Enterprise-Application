#Build stage
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /build

# copy entire multi-module project
COPY . .

# build only product-service
RUN mvn -pl product-service -am clean package -DskipTests


#Run stage
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

COPY --from=builder /build/product-service/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","app.jar"]
