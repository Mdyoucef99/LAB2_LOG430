# ADR2 : Utilisation du patron MVC                                                                 

## CONTEXTE
Dans le contexte du labo 2, nous avons besoin de séparer les données, la logique de traitement et l’interface, qui, dans notre cas, représente la console CLI. En utilisant le patron MVC, nous pouvons diviser les parties de notre projet, ce qui facilite les tests et permettra, à l’avenir, d’améliorer le projet sans trop de difficulté.

## Décision
Organiser l’application en **MVC** :
- **Model** (`model`): entités ORMLite pures.  
- **View** (`View`): Interface CLI. 
- **Controller** (`controller`): traduit les requêtes de l'interface utilisateur en consigne dans le cas de RepportController et DashbaordController 
- **Service** (`service`): Logique offrant les service nécessaire pour les stocks et la caisse 


## Status
Accepté

## Conséquences
- **+** Code découplé : UI, logique et Entité isolées.  
- **+** Tests unitaires plus simples sur chaque couche.    
- **–** Beaucoup de classe vu que la logique est réparties sur plusieurs classes.


Référence template : Decision record template by Michael Nygard (https://github.com/joelparkerhenderson/architecture-decision-record/tree/main/locales/en/templates/decision-record-template-by-michael-nygard)

