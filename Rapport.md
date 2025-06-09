- Nom : Youcef mekki daouadji  LOG430-02 
- Code permanent : MEKY03039908
- URL github : mdyoucef99/LAB2_LOG430

# Rapport pour le LABO2 LOG430 :  
## Évolution d’une architecture logicielle plus scalable et flexible

---

## Explication de ce projet

Ce laboratoire représente le cumul des LAB0, LAB1 et LAB2.

- **LAB0** : Création du squelette du projet, mise en place d’un pipeline CI/CD avec GitHub Actions, et configuration de la machine virtuelle servant d’environnement de production.
- **LAB1** : Implémentation d’un système de vente assurant la persistance des données, même avec plusieurs caisses fonctionnant simultanément.
- **LAB2** : Amélioration de la scalabilité du projet en intégrant la gestion de plusieurs magasins, d’une maison mère et d’un centre logistique, chacun ayant des fonctionnalités spécifiques.

---

## Instructions d'exécution

- Pour les instructions d’exécution du projet, veuillez consulter le fichier [`README`](.github/README).
- Pour les instructions d’exécution des tests, veuillez également consulter le fichier [`README`](.github/README).

---

## Justification des choix technologiques retenus

- **Langage de programmation** : Java — stable, bien documenté, facile à implémenter.
- **Abstraction de la couche de persistance** : ORMLite — simple d’utilisation, adaptée à un projet de cette taille.
- **Base de données** : PostgreSQL — robuste, conforme aux propriétés ACID.
- **Tests** : JUnit — outil de référence pour les tests unitaires en Java.
- **CI/CD** : GitHub Actions — pipeline facilement configurable avec Java.

---

## Décisions d’architecture (ADRs)

Les ADRs sont disponibles dans le dossier `docs/ADR`.

- [ADR 1](docs/ADR/ADR1.md)
- [ADR 2](docs/ADR/ADR2.md)

---

## Diagrammes UML 4+1

Les diagrammes UML sont disponibles dans le dossier `docs/UML`.

### Diagramme de cas d'utilisation

![Cas d'utilisation](docs/UML/cas_d'utilisation.png)

### Diagramme de déploiement

![Vue de déploiement](docs/UML/Vue_deploiement.png)

### Vue d'implémentation

![Vue d'implémentation](docs/UML/Vue_implementation.png)

### Vue logique

![Vue logique](docs/UML/Vue_logique.png)

### Vue processus

![Vue processus](docs/UML/Vue_processus.png)








