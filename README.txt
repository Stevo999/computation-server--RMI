Instructions
Follow the steps below to run the code:

Ensure that you have Java Development Kit (JDK) installed on your machine.

Open a terminal or command prompt and navigate to the directory containing the source code files.

Compile the Java source files. Run the following command:


1.javac ComputationServer.java
2.javac ComputationClient.java

Start the server. Run the following command:
java ComputationServer

The server will start and bind the ComputationService object to the RMI registry.

Start the client. Open a new terminal or command prompt and run the following command:
java ComputationClient

The client will connect to the server and perform synchronous and asynchronous RMI calls.
Observe the output in the client and server terminals. The results of the synchronous and asynchronous operations will be displayed.

