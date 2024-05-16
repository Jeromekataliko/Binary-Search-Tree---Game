import java.util.Random;
import java.util.Scanner;

public class QuestionTree {
    private QuestionNode overallRoot;

    // Array of randomized responses
    private static final String[] RANDOM_RESPONSES = {
            "I passed!",
            "I got it!",
            "YAYYYY!",
            "I'm right!",
            "Bravo!",
            "I'm so smart..lol!"
    };

    // Random object for selecting responses
    private static final Random RANDOM = new Random();

    public QuestionTree() {
        overallRoot = initialTree();
    }

    private QuestionNode initialTree() {
        String animals = "Lion, Leopard, Giraffe, Hippopotamus, Elephant, Kangaroo, Polar bear, Penguin, Albatross, Fish";
        System.out.println("\nI'm thinking of one of these animals: \n" + animals + "\n");

        return new QuestionNode("Does the animal live on land?",
                new QuestionNode("Is the animal a carnivore?",
                        new QuestionNode("Does the animal have a mane?",
                                new QuestionNode("Is the animal a big cat species?",
                                        new QuestionNode("Lion"),
                                        new QuestionNode("Leopard")),
                                new QuestionNode("Is the animal taller than a human?",
                                        new QuestionNode("Giraffe"),
                                        new QuestionNode("Hippopotamus"))),
                        new QuestionNode("Does the animal have a trunk?",
                                new QuestionNode("Elephant"),
                                new QuestionNode("Is the animal a vegetarian?",
                                        new QuestionNode("Kangaroo"),
                                        new QuestionNode("Polar bear")))),
                new QuestionNode("Is the animal flightless?",
                        new QuestionNode("Penguin"),
                        new QuestionNode("Is the animal a bird?",
                                new QuestionNode("Albatross"),
                                new QuestionNode("Fish"))));
    }

    public void askQuestions() {
        overallRoot = askQuestions(overallRoot, new Scanner(System.in));
    }

    private QuestionNode askQuestions(QuestionNode root, Scanner scanner) {
        if (root.yes == null && root.no == null) {
            System.out.println(root.data + "? ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("yes")) {
                System.out.println(getRandomResponse());
            } else {
                System.out.println("I failed. Maybe next time.");
            }
            return root;
        } else {
            System.out.println(root.data + "? ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("yes")) {
                root.yes = askQuestions(root.yes, scanner);
            } else {
                root.no = askQuestions(root.no, scanner);
            }
            return root;
        }
    }

    // Method to get a random response from the pool
    private String getRandomResponse() {
        return RANDOM_RESPONSES[RANDOM.nextInt(RANDOM_RESPONSES.length)];
    }

    public static void main(String[] args) {
        QuestionTree qt = new QuestionTree();
        qt.askQuestions();
    }
}

