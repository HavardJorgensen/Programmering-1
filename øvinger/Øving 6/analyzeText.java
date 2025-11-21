import java.util.*;

class analyzeText{

    private final int[] charCount = new int[30];
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyzæøå";

    public analyzeText(String text) {
        if(text == null){
            text = "";
        }


        for(int i = 0; i < text.length();i++){
            char letter = Character.toLowerCase(text.charAt(i));
            int index = indexForLetter(letter);
            if(index >= 0){
                charCount[index] += 1;
            } else {
                charCount[29] += 1;
            }
        }
    }

    public static int indexForLetter(char letter){
        int index = alphabet.indexOf(letter);
        return index;
    }

    public int totalLetters(){
        int totalLetters = 0;
        for (int i = 0; i < (charCount.length - 1); i++) {
            totalLetters += charCount[i];
        }
        return totalLetters;
    }

    public int totalSymbols(){
        int totalSymbols = 0;
        for (int i = 0; i < charCount.length; i++) {
            totalSymbols += charCount[i];
        }
        return totalSymbols;
    }

    public double percentLetters(){
        double percentLetters = (totalLetters() * 100 ) / totalSymbols();
        return percentLetters;
    }

    public int letterOccurence(char letter){
        return charCount[indexForLetter(letter)];
    }

    public List<Character> highestOccurence() {
        int max = 0;
        for (int i = 0; i < 29; i++){
            max = Math.max(max, charCount[i]);
        }

        List<Character> maxList = new ArrayList<>();

        if (max == 0){
            return maxList;
        }

        for (int i = 0; i < 29; i++) {
            if (charCount[i] == max){
                maxList.add(alphabet.charAt(i));
            }
        }
        return maxList;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the text analyzer");
        boolean run = true;
        while(run == true){
            System.out.println("Input text to analyse (empty line to exit)");
            System.out.print("> ");
            String stringToAnalyze = scanner.nextLine();

            if(stringToAnalyze.trim().isEmpty()){
                run = false;
                break;
            }

            analyzeText myText = new analyzeText(stringToAnalyze);

            System.out.println("Check for number of occurences of a specific letter? y/n");
            int choiceOne = 0;
            do{
                System.out.print("> ");
                String temp = scanner.nextLine();
                if(temp.toLowerCase().charAt(0) == 'y'){
                    choiceOne = 1;
                } else if (temp.toLowerCase().charAt(0) == 'n'){
                    break;
                } else {
                    System.out.println("Try again");
                }
            }while(choiceOne == 0); 

            if(choiceOne == 1){
                System.out.println("Select letter to analyse, only the first is read");
                System.out.print("> ");
                String temp = scanner.nextLine();
                char chosenLetter = temp.toLowerCase().charAt(0);
                System.out.println("The letter " + chosenLetter + " occured " + myText.letterOccurence(chosenLetter) + " time(s)");

            }

            System.out.println("Total amount of letters: " + myText.totalLetters()); 
            System.out.println("Percentage of text that was letters: " + myText.percentLetters() + "%"); 
            System.out.println("The letters with the most occurences are: " + myText.highestOccurence());

        }
        System.out.println("Goodbye");
    }
}
