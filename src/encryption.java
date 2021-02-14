import java.util.*;

public class encryption {


    private Scanner input ;
    private Random random ;
    private ArrayList<Character> list ;
    private ArrayList<Character> shuffledlist ;
    char character ;
    private String line ;
    private char[] letters ;
    private char[] secretletters  ;



    public encryption() {

        input  = new Scanner(System.in) ;
        random = new Random();
        list = new ArrayList<>() ;
        shuffledlist = new ArrayList<>() ;
         character = ' ';

        newkey();
        askQuestion();


    }

    private void askQuestion(){

        while (true){
            System.out.println("*************************************************");
            System.out.println("what do  you want to do ?!");
            System.out.println("(N)ewkey , (G)etkey , (E)ncrypt , (D)ecrypt , (Q)uit");

            char respons = Character.toUpperCase(input.next().charAt(0)) ;

            switch (respons){
                case 'N' :
                    newkey();
                    break;
                case 'G' :
                    getkey();
                    break;
                case 'E' :
                    encrypt();
                    break;

                case 'D' :
                    decrypt();
                    break;
                case 'Q' :
                    quit();
                    break;

                default:
                    System.out.println("not  a  valid answer :( ");

            }
        }

    }



    private void newkey(){

      character = ' ' ;
      list.clear();
      shuffledlist.clear();

        for (int i = 32; i <127 ; i++) {
            list.add(Character.valueOf(character)) ;
            character++  ;
        }

        shuffledlist = new ArrayList<>(list) ;
        Collections.shuffle(shuffledlist);
        System.out.println("A new key has been generated.");


    }



    private void getkey(){

        System.out.println("key : ");

        for (Character x : list){
            System.out.print(x);
        }
        System.out.println();

        for (Character x : shuffledlist){
            System.out.print(x);
        }

    }


    private void encrypt(){

        System.out.println("Enter a message to be encrypted  :  ");
        String message  = input.next()  ;

        letters = message.toCharArray();

        for (int i = 0; i < letters.length; i++) {

            for (int j = 0; j <list.size() ; j++) {
                if (letters[i] == list.get(j)){
                    letters[i] = shuffledlist.get(j) ;
                    break;


                }
            }
        }
        System.out.println("encrypted  :");
        for (char x : letters){
            System.out.print(x);
        }
        System.out.println();

    }


    private void decrypt(){


        System.out.println("Enter a message to be decrypted  :  ");
        String message  = input.next()  ;

        letters = message.toCharArray();

        for (int i = 0; i < letters.length; i++) {

            for (int j = 0; j <shuffledlist.size() ; j++) {
                if (letters[i] == shuffledlist.get(j)){
                    letters[i] = list.get(j) ;
                    break;


                }
            }
        }
        System.out.println("decrypted  :");
        for (char x : letters){
            System.out.print(x);
        }
        System.out.println();

    }



    private void quit(){

        System.out.println("Thank you  , have a nice day !!");
        System.exit(0);

    }






}
