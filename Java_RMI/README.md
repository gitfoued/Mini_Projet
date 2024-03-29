# Java RMI: Gestion d'une liste de tâches

Ce service Java RMI permet de gérer une liste de tâches en offrant les fonctionnalités suivantes :
- Ajouter une nouvelle tâche à la liste.
- Supprimer une tâche existante de la liste.
- Récupérer la liste complète des tâches.

## Déploiement

### Prérequis
- Java Development Kit (JDK) 21
- RMI Registry 
- environnement de développement vscode

### Étapes de déploiement

1. **Cloner le dépôt :** Clonez ce dépôt sur votre machine locale en utilisant la commande suivante :
    ```bash
  git clone https://git@github.com:gitfoued/Mini_Projet.git
    ```

2. **Compilation du code :** Compilez les fichiers source Java en exécutant les commandes suivantes à la racine du projet :
    ```bash
    javac Java_RMI/*.java
    ```

3. **Démarrer le serveur :** Lancez le serveur en exécutant la classe `Server` avec la commande suivante :
    ```bash
    java Java_RMI.Server
    ```

4. **Démarrer le client :** Lancez le client en exécutant la classe `Client` avec la commande suivante dans un autre terminal ou une autre fenêtre :
    ```bash
    java Java_RMI.Client
    ```

## Tester l'Application

1. Une fois le serveur et le client en cours d'exécution, vous pouvez interagir avec le client pour ajouter, supprimer ou afficher des tâches dans la liste.
2. Suivez les instructions affichées dans le terminal du client pour sélectionner les différentes options disponibles.
3. Les modifications apportées à la liste des tâches seront reflétées en temps réel sur le client.

