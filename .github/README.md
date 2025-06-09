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

Construisez et testez l’image Docker localement :

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

### Lancement de l'application

L'application se présente sous forme de console offrant trois options principales au démarrage :

1. **Caisse (magasin)**
2. **Centre logistique** (UC2)
3. **Maison-Mère** (UC1 & UC3)

---

### 1. Caisse (magasin)

Après avoir sélectionné cette option, il vous sera demandé de choisir l'**ID du magasin** (valide de 1 à 5). Une fois sélectionné, vous accéderez au système de caisse, où vous pouvez :

- Rechercher un produit par ID
- Enregistrer une vente
- Annuler une vente
- Consulter l'inventaire du magasin

Suivez simplement les instructions affichées dans la console pour chaque action.

---

### 2. Centre logistique (UC2)

Cette option vous donne accès au **centre logistique**, responsable du **réapprovisionnement** des magasins. Vous pouvez consulter les stocks centraux et initier une demande d'approvisionnement si un produit est insuffisant dans un magasin.

---

### 3. Maison-Mère (UC1 & UC3)

La Maison-Mère permet de :

- Générer un **rapport consolidé** des ventes par magasin
- Visualiser les **stocks de tous les magasins**
- Identifier les **produits en rupture de stock**
- Afficher les **chiffres d’affaires** et autres indicateurs de performance

> Le rapport est généré et affiché directement dans la console à l’aide de `System.out.println`, contenant les informations essentielles.

Pour arrêter les services :

```bash
docker-compose down
```

La pipeline CI/CD est configurée via **GitHub Actions** et se déclenche à chaque push ou merge request. Elle exécute dans l’ordre :

1. **Lint** (Checkstyle)
2. **Tests unitaires** (JUnit)
3. **Build & publication** de l’image Docker 

Pour suivre l’exécution, ouvrez le dépôt et consultez la section **Actions**.


