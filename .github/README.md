# Lab2 –  Evolution d’une architecture logicielle plus scalable et flexible

## Description : 

## Exécution de l’application
Dans la VM, le dossier racine ce trouve dans le fichier projects/LAB2_LOG430 .Assurez vous de faire un git -pull pour avoir la derniere version du repo : mdyoucef99/LAB2_LOG430

## Tests unitaires

Les bibliothèques JUnit se trouvent dans le dossier `lib` (`junit-4.13.2.jar` et `hamcrest-core-1.3.jar`). Depuis le dossier racine :

```bash
# Compiler le test
javac -d javac -d LABO2/lab/bin -cp "lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" LABO2/lab/tests/lab/tests/AppTest.java

# Exécuter le test
java -cp "LABO2/lab/bin:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore lab.tests.AppTest
```

## Conteneurisation

Construisez et testez l’image Docker :

```bash
docker build -t lab2_api .
docker run --rm -it --network host lab2_api
```

## Orchestration avec Docker Compose

Il existe un `docker-compose.yaml` à la racine, lancez :

```bash
docker-compose build
docker-compose up -d 
docker-compose run --rm api
```

**Résultat attendu :** 

Vous devriez maintenant être capable de lancer l'application et d'accéder aux options dans la base de données qui est conteneurisée. 

Pour arrêter les services :

```bash
docker-compose down
```

La pipeline CI/CD est configurée via **GitHub Actions** et se déclenche à chaque push ou merge request. Elle exécute dans l’ordre :

1. **Lint** (Checkstyle)
2. **Tests unitaires** (JUnit)
3. **Build & publication** de l’image Docker 

Pour suivre l’exécution, ouvrez le dépôt et consultez la section **Actions**.


