# Service de Messagerie gRPC

Ce projet est un exemple d'implémentation d'un service de messagerie utilisant gRPC.

## Table des matières
- [Introduction](#introduction)
- [Fonctionnalités](#fonctionnalités)
- [Déploiement](#déploiement)
- [Test de l'Application](#test-de-lapplication)

## Introduction

Ce service de messagerie permet d'envoyer des messages texte à un destinataire spécifié et de récupérer les messages reçus pour un utilisateur donné.
Il utilise le protocole gRPC pour la communication client-serveur.

## Fonctionnalités

- Envoi de messages texte à un destinataire spécifié.
- Récupération des messages reçus pour un utilisateur donné.

## Déploiement

### Prérequis
- Java JDK 21 ou version ultérieure
- Apache Maven 3.9.6
- Protoc (le compilateur de protocole buffer)

### Étapes de déploiement

1. Clonez ce dépôt sur votre machine locale :git clone https://github.com/git@github.com:gitfoued/Mini_Projet.git
2. Accédez au répertoire du projet :cd gRPC/gRPC
3. Compilez le projet à l'aide de Maven :mvn clean install
4. protoc --java_out=<destination_java_dir> messaging_service.proto
5. protoc --java_out=<destination_java_dir> messaging_client.proto
6. Exécutez le serveur de messagerie :java -jar messaging-server.jar
7.Exécutez le client de messagerie :java -jar messaging-client.jar 



