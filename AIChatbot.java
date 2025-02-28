import java.util.HashMap;
import java.util.Scanner;

public class AIChatbot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> responses = new HashMap<>();

        responses.put("hello", "Hello! How can I assist you?");
        responses.put("hi", "Hi there! What do you need help with?");
        responses.put("how are you", "I'm just a bot, but I'm doing great! How about you?");
        responses.put("bye", "Goodbye! Have a great day!");
        responses.put("your name", "I am a chatbot built using Java.");
        responses.put("what is java", "Java is a high-level, object-oriented programming language.");

        System.out.println("Chatbot: Hello! Type 'bye' to exit.");
        
        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("bye")) {
                System.out.println("Chatbot: Goodbye! Have a great day!");
                break;
            }

            boolean found = false;
            for (String key : responses.keySet()) {
                if (userInput.contains(key)) {
                    System.out.println("Chatbot: " + responses.get(key));
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Chatbot: I'm not sure how to respond to that.");
            }
        }
        scanner.close();
    }
}
