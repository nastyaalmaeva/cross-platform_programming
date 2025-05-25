package utils;

import java.util.List;
import java.util.ArrayList;

public class SentenceComparator {
    private String generatedSentence;
    private String userSentence;
    private int correctWordsCount = 0;
    private List<String> generatedWordsList;
    private List<String> userWordsList;

    public SentenceComparator(String generatedSentence, String userSentence) {
        setGeneratedSentence(generatedSentence);
        setUserSentence(userSentence);
        this.generatedWordsList = extractWords(generatedSentence);
        this.userWordsList = extractWords(userSentence);
    }

    private List<String> extractWords(String sentence) {
        List<String> words = new ArrayList<>();

        String[] parts = sentence.split("\\s+");
        for (String part : parts) {
            if (!part.isEmpty()) {
                words.add(part.toLowerCase());
            }
        }
        return words;
    }

    public void compareSentences() {
        int minLength = Math.min(generatedWordsList.size(), userWordsList.size());
        correctWordsCount = 0;

        for (int i = 0; i < minLength; i++) {
            if (generatedWordsList.get(i).equals(userWordsList.get(i))) {
                correctWordsCount++;
            }
        }
    }

    public double getCorrectPercentage() {
        if (generatedWordsList.isEmpty()) {
            return 0.0;
        }
        return (double) correctWordsCount / generatedWordsList.size() * 100;
    }

    @Override
    public String toString() {
        return "Сгенерированное предложение:    " + generatedSentence + "\n" +
                "Ввод пользователя:              " + userSentence + "\n" +
                "Корректные слова: " + correctWordsCount + "/" + generatedWordsList.size() + "\n" +
                "Корректный процент: " + String.format("%.2f", getCorrectPercentage()) + "%";
    }

    public String getGeneratedSentence() {
        return generatedSentence;
    }

    public void setGeneratedSentence(String generatedSentence) {
        if (generatedSentence == null) {
            throw new IllegalArgumentException("Сгенерированное предложение не может быть null");
        }
        this.generatedSentence = generatedSentence;
    }

    public String getUserSentence() {
        return userSentence;
    }

    public void setUserSentence(String userSentence) {
        if (userSentence == null) {
            throw new IllegalArgumentException("Ввод пользователя не может быть null");
        }
        this.userSentence = userSentence;
    }
}
