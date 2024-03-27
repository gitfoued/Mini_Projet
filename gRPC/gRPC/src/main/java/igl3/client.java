package gRPC.gRPC.src.main.java.igl3;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class client {
    public static void main(String[] args) {
        // Création du canal gRPC
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        // Création du stub du service de messagerie
        MessagingServiceGrpc.MessagingServiceStub stub = MessagingServiceGrpc.newStub(channel);

        // Envoi d'un message
        Message messageToSend = Message.newBuilder()
                .setSender("Alice")
                .setRecipient("Bob")
                .setText("Hello, Bob!")
                .build();
        stub.sendMessage(messageToSend, new StreamObserver<Message>() {
            @Override
            public void onNext(Message message) {
                System.out.println("Message sent successfully");
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error sending message: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Message sending completed");
            }
        });

        // Récupération des messages pour un utilisateur
        User user = User.newBuilder()
                .setUsername("Bob")
                .build();
        stub.getMessagesForUser(user, new StreamObserver<Message>() {
            @Override
            public void onNext(Message message) {
                System.out.println("Received message: " + message.getText());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error retrieving messages: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Message retrieval completed");
            }
        });

        // Fermeture du canal gRPC
        channel.shutdown();
    }
}

