# ADR1 : Choix de l’ORM léger (ORMLite)

## CONTEXTE
Nous devons persister nos entités Java (`Store`, `Produit`, `Stock`, `Sale`) dans une base PostgreSQL avec un minimum de code de mapping. 

## Décision
Adopter **ORMLite** pour :
- Annoter directement les classes avec `@DatabaseTable`/`@DatabaseField`.  
- Générer automatiquement DAOs via `DaoManager`.  

## Status
Accepté

## Conséquences
- **+** Très rapide à mettre en place, peu de configuration.  
- **+** Réduit la quantité de code SQL. 
- **–** Fonctionnalités limitées par rapport à d'autre ORM mais dans notre cas celui-ci sera correct.


Référence template : Decision record template by Michael Nygard (https://github.com/joelparkerhenderson/architecture-decision-record/tree/main/locales/en/templates/decision-record-template-by-michael-nygard)




