import java.util.Scanner;

import utils.WordGenerator;
import utils.SentenceComparator;

public class Main {
    public static void main(String[] args) {
        WordGenerator wordGenerator = new WordGenerator();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество слов в предложении: ");
        int wordCount = scanner.nextInt();
        scanner.nextLine();

        String generatedSentence = wordGenerator.generateSentence(wordCount);
        System.out.println("Сгенерированное предложение: " + generatedSentence);

        System.out.print("Введите ваше предложение: ");
        String userSentence = scanner.nextLine();

        SentenceComparator sentenceComparator = new SentenceComparator(generatedSentence, userSentence);
        sentenceComparator.compareSentences();

        System.out.println("Результаты:");
        System.out.println(sentenceComparator);

        scanner.close();
    }
}
