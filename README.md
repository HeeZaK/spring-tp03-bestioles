# Spring TP03 – Bestioles

Projet Spring Boot pour le TP03 – Spring Data JPA avec repositories.

## Prérequis

- Java 17+
- Maven 3.8+
- MySQL ou MariaDB en local (port 3306)

## Setup BDD

1. Dans votre gestionnaire BDD (HeidiSQL, DBeaver, MySQL Workbench...), créer la base **bestioles**
2. Importer le dump SQL fourni :
```bash
mysql -u root -p bestioles < src/main/resources/dump-bestioles.sql
```

## Configuration

Modifier `src/main/resources/application.properties` si besoin :
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bestioles
spring.datasource.username=root
spring.datasource.password=root
```

## Lancer le projet

```bash
mvn spring-boot:run
```

Ou depuis IntelliJ / Eclipse : lancer la classe `BestiolesApplication.java`.

Le `CommandLineRunner` s'exécute automatiquement au démarrage et affiche les résultats des tests dans la console.

## Structure du projet

```
src/main/java/com/example/bestioles/
├── BestiolesApplication.java       <- Point d'entrée + tests CommandLineRunner
├── model/
│   ├── Species.java
│   ├── Animal.java
│   ├── Person.java
│   └── Role.java
└── repository/
    ├── SpeciesRepository.java
    ├── AnimalRepository.java
    ├── PersonRepository.java
    └── RoleRepository.java
```
