package igl3;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

// Importez les classes générées à partir du fichier proto
import messaging.Messaging.Message;
import messaging.Messaging;


public class server {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50051)
                .addService(new MessagingServiceImpl())
                .build();
        server.start();
        System.out.println("Server started");
        server.awaitTermination();
    }

    static class MessagingServiceImpl extends MessagingServiceGrpc.MessagingServiceImplBase {
        @Override
        public void sendMessage(Message request, StreamObserver<Message> responseObserver) {
            // Implémentez la logique d'envoi de message ici
            System.out.println("Received message from: " + request.getSender());
            System.out.println("Message to: " + request.getRecipient());
            System.out.println("Message text: " + request.getText());

            // Simule l'envoi du message en renvoyant le message reçu
            responseObserver.onNext(request);
            responseObserver.onCompleted();
        }

        @Override
        public void getMessagesForUser(GetMessagesRequest request, StreamObserver<Message> responseObserver) {
            // Implémentez la logique de récupération de message ici
            System.out.println("Récupération des messages pour l'utilisateur: " + request.getUsername());

            // Simule la récupération des messages en envoyant quelques messages fictifs
            for (int i = 0; i < 5; i++) {
                Message message = Message.newBuilder()
                        .setId(String.valueOf(i))
                        .setSender("Sender" + i)
                        .setRecipient(request.getUsername())
                        .setText("Message " + i)
                        .build();
                responseObserver.onNext(message);
            }

            responseObserver.onCompleted();
        }
    }
}
