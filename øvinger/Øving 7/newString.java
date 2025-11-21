import java.util.*;

class newString{

    private final String text;

    public newString(String text){
        this.text = text;
        
    }

    public String getText(){
        return text;
    }

    public String abbreviateString(){
        String abbreviatedString = "";
        String[] textSeperated = text.split(" ");
        for (int i = 0; i < textSeperated.length; i++) {
            abbreviatedString = abbreviatedString + textSeperated[i].charAt(0);
        }
        return abbreviatedString;
    }

    public String removeChars(String chars){
        String reducedString = text;
        String charToReplace = "";
        for (int i = 0; i < chars.length(); i++) {
            charToReplace = "" + chars.charAt(i);
            reducedString = reducedString.replaceAll(charToReplace, "");
        }
        return reducedString;

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
        System.out.println("Input characters to remove");
        System.out.print(">");
        String charsToRemove = scanner.nextLine();
        

        newString A = new newString(textToEdit);


        System.out.println("\nOriginal text: " + A);
        System.out.println("Abbreviated text: " + A.abbreviateString());
        System.out.println("Text with removed chars: " + A.removeChars(charsToRemove));

    }

}