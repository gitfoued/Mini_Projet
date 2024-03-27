package gRPC.gRPC.src.main.java.igl3;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

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
            // Implement message sending logic here
            System.out.println("Received message from: " + request.getSender());
            System.out.println("Message to: " + request.getRecipient());
            System.out.println("Message text: " + request.getText());

            // Simulate sending the message by returning the received message
            responseObserver.onNext(request);
            responseObserver.onCompleted();
        }

        @Override
        public void getMessagesForUser(User request, StreamObserver<Message> responseObserver) {
            // Implement message retrieval logic here
            System.out.println("Retrieving messages for user: " + request.getUsername());

            // Simulate retrieving messages by sending some dummy messages
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
