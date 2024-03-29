package igl3;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import igl3.MessagingServiceProto;
import igl3.MessagingServiceGrpc;

import java.util.concurrent.TimeUnit;

public class MessagingClient {
    private final ManagedChannel channel;
    private final MessagingServiceGrpc.MessagingServiceBlockingStub blockingStub;

    public MessagingClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = MessagingServiceGrpc.newBlockingStub(channel);
    }

    public void sendMessage(String id, String sender, String recipient, String text) {
        MessagingServiceProto.Message request = MessagingServiceProto.Message.newBuilder()
                .setId(id)
                .setSender(sender)
                .setRecipient(recipient)
                .setText(text)
                .build();

        MessagingServiceProto.Message response = blockingStub.sendMessage(request);
        System.out.println("Message sent: " + response);
    }

    public void getMessagesForUser(String username) {
        MessagingServiceProto.GetMessagesRequest request = MessagingServiceProto.GetMessagesRequest.newBuilder()
                .setUsername(username)
                .build();

        blockingStub.getMessagesForUser(request)
                .forEachRemaining(message -> System.out.println("Received message: " + message));
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws Exception {
        MessagingClient client = new MessagingClient("localhost", 50051);

        // Send a message
        client.sendMessage("1", "sender", "recipient", "Hello from client!");

        // Get messages for user
        client.getMessagesForUser("recipient");

        client.shutdown();
    }
}
