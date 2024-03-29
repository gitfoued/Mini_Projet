# Service de Chat

## Description
Ce service de chat permet aux utilisateurs d'envoyer des messages texte à un salon de discussion commun et de recevoir les messages envoyés par d'autres utilisateurs.


### Prérequis
- Java 21 jdk
- environnement de développement vscode.

### Étapes de déploiement
1. **Cloner le dépôt :** Clonez ce dépôt sur votre machine locale en utilisant la commande suivante :
    

2. **Importer le projet (facultatif) :** Si vous utilisez un IDE comme IntelliJ IDEA ou Eclipse, importez le projet dans votre IDE en sélectionnant le dossier du projet cloné.

3. **Compiler le code :** Compilez le code en exécutant les commandes suivantes à la racine du projet :
    ```bash
    javac Sockets/*.java
    ```

4. **Exécuter le serveur :** Lancez le serveur en exécutant la classe `ChatServer` avec la commande suivante :
    ```bash
    java Sockets.ChatServer
    ```

5. **Exécuter le client :** Lancez le client en exécutant la classe `chatClient` avec la commande suivante dans un autre terminal ou une autre fenêtre :
    ```bash
    java Sockets.chatClient
    ```

## Tester l'Application

1. Une fois le serveur et le client en cours d'exécution, vous pouvez envoyer des messages texte à partir du client. Les messages seront diffusés à tous les clients connectés au serveur.
2. Envoyez des messages à partir de plusieurs clients pour observer la fonctionnalité de communication en temps réel.
