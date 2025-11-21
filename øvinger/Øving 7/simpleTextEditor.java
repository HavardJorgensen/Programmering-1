import java.util.*;

class simpleTextEditor{
    private final String text;

    public simpleTextEditor(String text) {
        this.text = text;
    }

    public int wordCount(){
        String[] seperatedString = text.split("[ ,.!:?]");
        int wordCount = 0;

        //skip if array is empty ("." followed by " ")
        for (int i = 0; i < seperatedString.length; i++) {
            if(!(seperatedString[i].equals(""))){
                wordCount += 1;
            }
            
        }

        return wordCount;
    }

    public String getText(){
        return text;
    }

    public float averageWordLength(){
        String[] seperatedString = text.split("[ ,.!:?]");
        float totalLength = 0;

        for (int i = 0; i < seperatedString.length; i++) {
            totalLength = totalLength + seperatedString[i].length();
        }

        return (totalLength / wordCount());
    }

    public float averageSentenceLength(){
        String[] seperateSentences = text.split("[,.!:?]");
        float totalLength = 0;
        for (int i = 0; i < seperateSentences.length; i++) {
            String seperateSentence = seperateSentences[i];
            String[] seperatedWords = seperateSentence.split("[ ,.!:?]");

            //skip if array is empty ("." followed by " ")
            for (int j = 0; j < seperatedWords.length; j++) {
                if(!(seperatedWords[j].equals(""))){
                    totalLength += 1;
                }
            }

        }

        return (totalLength / seperateSentences.length);
    }

    public String replaceString(String toBeReplaced, String replaceWith){
        String replacedString = text;
        String regex = "(?i)" + toBeReplaced;
        return replacedString.replaceAll(regex, replaceWith);
    }

    public String toUpperCase(){
        return text.toUpperCase();
    }


    @Override
    public String toString(){
        return getText();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input text to edit.");
        System.out.print(">");
        String textToEdit = scanner.nextLine();
        

        simpleTextEditor A = new simpleTextEditor(textToEdit);


        System.out.println("\nOriginal text: " + A);
        System.out.println("Wordcount: " + A.wordCount());
        System.out.println("Average word length: " + A.averageWordLength());
        System.out.println("Average sentence length: " + A.averageSentenceLength());

        System.out.println("\nSelect text to replace.");
        System.out.print(">");
        String toBeReplaced = scanner.nextLine();
        System.out.println("Select what to replace it with.");
        System.out.print(">");
        String replaceWith = scanner.nextLine();
        System.out.println("Text with replacements: " + A.replaceString(toBeReplaced, replaceWith));
        System.out.println("Original text: " + A);
        System.out.println("Uppercase text: " + A.toUpperCase());
    }


} 