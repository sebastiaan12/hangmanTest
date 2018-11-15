import java.util.Scanner;
import java.util.ArrayList;

public class hangman {


    static public void guess (String word, int life) {
    System.out.println("Welkom bij de Hangman game!");
    System.out.println("Raad het woord om te winnen!");



        char[] filler= new char[word.length()];
        int i=0;
        while(i<word.length()) {
            filler[i]='-';
            if(word.charAt(i)==' ') {
                filler[i]=' ';
            }
            i++;
        }
        System.out.print(filler);
        System.out.println("     life remaining=" + life);

        Scanner s=new Scanner(System.in);   //om character te lezen
        String input =  s.next();
        if (input.equals("exit")) {
            System.exit(1);
        }
        ArrayList<Character> l= new ArrayList<Character>();

        while(life>0){
            char x=s.next().charAt(0);   //characters input bij gebruiker

            if(l.contains(x)){
                System.out.println("already entered");
                continue;        //while loop continues

            }

            l.add(x);

            if(word.contains(x+"")){
                for(int y=0;y<word.length();y++){
                    if(word.charAt(y)==x){
                        filler[y]=x;
                    }
                }
            }
            else{
                life--;     //life gaat naar benden als character entered daar niet is
            }

            if(word.equals(String.valueOf(filler))){  //checkt of filler gelijk staat aan word
                System.out.println(filler);
                System.out.println("you won!!!");
                break;
            }

            System.out.print(filler);
            System.out.println("     life remaining = " + life);
        }

        if(life==0){
            System.out.println("You lose");
        }
    }

    public static void main(String[] args){

        String word="hangman game"; //het woord dat geraden moet worden
        int life=5;  //leven of nummer kansen
        guess(word,life);

    }
}