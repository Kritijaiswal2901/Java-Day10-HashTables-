public class Main {
    public static void main(String[] args) {
        HashTable<String, Integer> frequencyTable = new HashTable<>(20);
        String str = "To be or not to be";
        updateFrequency(frequencyTable, str);
        // Display Frequency Table
        System.out.println("Frequency Table for Sentence: \"" + str + "\"");
        displayFrequencyTable(frequencyTable);
        System.out.println();


        String str2 = "Paranoids are not paranoid because they are paranoid " +
                "but because they keep putting themselves deliberately into paranoid avoidable situations";
        updateFrequency(frequencyTable, str2);
        System.out.println("Frequency Table of str2:");
        displayFrequencyTable(frequencyTable);

    }
    // updateFrequency method to process a sentence and update the frequency table
    private static void updateFrequency(HashTable<String, Integer> frequencyTable, String sentence) {
        String[] words = sentence.toLowerCase().split(" ");
        for (String word : words) {
            Integer frequency = frequencyTable.get(word);
            if (frequency == null) {
                frequencyTable.put(word, 1);
            } else {
                frequencyTable.put(word, frequency + 1);
            }
        }
    }
    // displayFrequencyTable method to display the frequency table
    private static void displayFrequencyTable(HashTable<String, Integer> frequencyTable) {
        for (int i = 0; i < frequencyTable.size; i++) {
            MyMapNode<String, Integer> current = frequencyTable.table[i];
            while (current != null) {
                System.out.print("(" + current.key + ": " + current.value + ") ");
                current = current.next;
            }
        }
        System.out.println();
    }
}