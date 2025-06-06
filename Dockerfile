# Utilise une image de base Java
FROM openjdk:17-jdk-slim

# Crée un dossier pour l'application
WORKDIR /app

# Copie le JAR dans l'image Docker
COPY Lab2_LOG430.jar app.jar

# Commande à exécuter quand le conteneur démarre
ENTRYPOINT ["java", "-jar", "app.jar"]