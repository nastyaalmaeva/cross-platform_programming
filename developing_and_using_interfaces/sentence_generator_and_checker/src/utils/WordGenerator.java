package utils;

import java.util.Random;

public class WordGenerator {
    private static final String[] words = {
            "яблоко", "банан", "кот", "собака", "слон", "рыба", "виноград", "дом", "остров", "прыжок", "воздушный змей", "лев",
            "гора", "океан", "пианино", "королева", "кролик", "солнце", "дерево", "зонтик", "гриф", "окно", "ксилофон", "яхта", "зебра"
    };

    private Random random = new Random();

    public String generateWord() {
        return words[random.nextInt(words.length)];
    }

    public String generateSentence(int wordCount) {
        StringBuilder sentence = new StringBuilder();
        for (int i = 0; i < wordCount; i++) {
            sentence.append(generateWord()).append(" ");
        }

        sentence.setLength(sentence.length() - 1);
        return sentence.toString();
    }
}
