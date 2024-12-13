
# Projet : Dice Roller

C'est un projet de lancer de dés fait avec Spring Boot. On peut faire des lancés de dés, sauvegarder les résultats et consulter l'historique.

## Fonctionnalités

1. Lancer un seul dé.
2. Lancer plusieurs dés.
3. Sauvegarder les résultats des lancés dans une base de données.
4. Consulter l'historique des lancés.

## Endpoints REST

- **GET** `/api/dice/rollDice` : Lance un dé.
- **GET** `/api/dice/rollDices/{X}` : Lance X dés.
- **GET** `/api/diceLogs` : Affiche l'historique des lancés.

## Structure du projet

- **Dice** : Classe pour un dé. Gère le nombre de faces et le lancé.
- **DiceRollLog** : Entité JPA pour les logs des lancés.
- **DiceRollLogRepository** : Repository pour interagir avec la base.
- **DiceService** : Service pour gérer la logique métier.
- **DiceController** : Contrôleur REST pour lancer les dés.
- **DiceLogController** : Contrôleur REST pour consulter les historiques.

## Base de données

- Une table pour les logs des lancés.
- Une table pour stocker les résultats (lié aux logs).

## Prérequis

- Java 17+
- Maven
- Une base de données (H2, MySQL, etc.)

## Commandes Maven

- `mvn spring-boot:run` : Démarrer le projet.
- `mvn clean install` : Construire le projet.

## Exemple d'utilisation

Pour lancer 5 dés, appelez l'URL suivante :  
`GET http://localhost:8080/api/dice/rollDices/5`

Réponse :  
`[1, 4, 6, 3, 2]`
