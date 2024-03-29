package igl3;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import igl3.MessagingServiceProto;
import igl3.Message;
import igl3.GetMessagesRequest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class MessagingServer {
    private static final Logger logger = Logger.getLogger(MessagingServer.class.getName());
    private final int port;
    private final Server server;

    public MessagingServer(int port) {
        this.port = port;
        this.server = ServerBuilder.forPort(port)
                .addService(new MessagingServiceImpl())
                .build();
    }

    static class MessagingServiceImpl extends MessagingServiceGrpc.MessagingServiceImplBase {
        @Override
        public void sendMessage(Message request, StreamObserver<Message> responseObserver) {
            // Logic for sending message
            System.out.println("Message sent: " + request);
            responseObserver.onNext(request);
            responseObserver.onCompleted();
        }

        @Override
        public void getMessagesForUser(GetMessagesRequest request,
                                        StreamObserver<Message> responseObserver) {
            // Logic for getting messages for user
            // For demonstration, we'll just send a dummy message
            Message message = Message.newBuilder()
                    .setId("1")
                    .setSender("sender")
                    .setRecipient(request.getUsername())
                    .setText("Hello from server!")
                    .build();

            responseObserver.onNext(message);
            responseObserver.onCompleted();
        }
    }

    public void start() throws IOException {
        server.start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            try {
                MessagingServer.this.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
            System.err.println("*** server shut down");
        }));
    }

    public void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        MessagingServer server = new MessagingServer(50051);
        server.start();
        server.blockUntilShutdown();
    }
}
