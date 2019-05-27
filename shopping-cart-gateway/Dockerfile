FROM openjdk:8
ADD shopping-cart-gateway/target/shopping-cart-gateway-0.0.1-SNAPSHOT.jar shopping-cart-gateway.jar
EXPOSE 8080
ENV PATH $PATH:/usr/bin/
ENTRYPOINT ["java", "-jar", "shopping-cart-gateway.jar"]