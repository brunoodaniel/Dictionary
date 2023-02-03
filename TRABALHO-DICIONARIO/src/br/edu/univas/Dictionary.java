package br.edu.univas;

import java.util.Scanner;

public class Dictionary {
    public static void main(String[] args) {
        String[] BrList = new String[100];
        String[] EnglishList = new String[100];

        while (true) {

            int operation = Menu();

            if (operation == 9) {
                System.out.println("Until next time. :)");
                break;
            } else if (operation == 1) {
                Register(BrList, EnglishList);
            } else if (operation == 2) {
                Edit(BrList, EnglishList);
            } else if (operation == 3) {
                Exclude(BrList, EnglishList);
            } else if (operation == 4) {
                SearchMeaning(BrList, EnglishList);
            } else {
                System.out.println("\nInvalid option, try again.\n");
            }
        }
    }

    public static int Menu() {
        Scanner read = new Scanner(System.in);
        System.out.println("""
                What do you wanna do?
                1: Register a word.
                2: Edit a word.
                3: Exclude a word.
                4: Search for the meaning of a word.
                9: leave.""");

        return read.nextInt();
    }

    public static void Register(String[] BrList, String[] EnglishList) {
        Scanner read = new Scanner(System.in);

        for (int i = 0; i < 100; i++) {
            boolean validation = true;
            if (EnglishList[i] == null) {
                System.out.println("Type a english word: ");
                String EnglishWord = read.next();
                System.out.println("Type a portuguese word: ");
                String BrWord = read.next();

                for (int j = 0; j < 100; j++) {
                    if (EnglishWord.equalsIgnoreCase(EnglishList[j]) || BrWord.equalsIgnoreCase(BrList[j])) {
                        validation = false;
                        break;
                    }
                }

                if (validation) {
                    EnglishList[i] = EnglishWord.toLowerCase();
                    BrList[i] = BrWord.toLowerCase();

                    System.out.println("""
                            Do you wanna register another word??
                            1: Yes.
                            2: No.""");

                    int keep_On = read.nextInt();

                    if (keep_On == 2) {
                        break;
                    }
                } else {
                    System.out.println("\nThis word is already registered, try again.\n");
                    i--;
                }
            }
        }
    }

    public static void Edit (String[] BrList, String[] EnglishList) {
        Scanner read = new Scanner(System.in);

        for (int i = 0; i < 100; i ++) {

            boolean emptyArray = true;
            for (int a = 0; a < 100; a ++) {
                if (EnglishList[a] != null) {
                    emptyArray = false;
                    break;
                }
            }

            if (!emptyArray) {
                String newBrWord;
                String newEnglishWord;

                System.out.println("Which word do you wanna edit?");
                String editedWord = read.next();

                boolean validation = false;
                for (int j = 0; j < 100; j ++) {
                    if (editedWord.equalsIgnoreCase(EnglishList[j]) || editedWord.equalsIgnoreCase(BrList[j])) {
                        i = j;
                        validation = true;
                        break;
                    }
                }

                if(validation) {
                    boolean repeatedWord = false;
                    System.out.println("Type a new english word:");
                    newEnglishWord = read.next();

                    System.out.println("type a new portuguese word: ");
                    newBrWord = read.next();


                    for (int a = 0; a < 100; a ++) {
                        if (newEnglishWord.equalsIgnoreCase(EnglishList[a]) || newBrWord.equalsIgnoreCase(BrList[a])) {
                            repeatedWord = true;
                            break;
                        }
                    }

                    if (!repeatedWord){
                        EnglishList[i] = newEnglishWord;
                        BrList[i] = newBrWord;

                        i = 0;

                        System.out.println("""
                                Do you wanna edit another word?
                                1: Yes.
                                2: No.""");

                        int keep_On = read.nextInt();

                        if (keep_On == 2) {
                            break;
                        }
                    }
                    else {
                        System.out.println("\nThis word is already registered, try again. \n");
                    }
                }
                else {
                    System.out.println("\nThis word isn't registered, try again. \n");
                    i = 0;
                }
            }
            else {
                System.out.println("\nNo one word registered.\n");
                break;
            }
        }
    }

    public static void Exclude (String[] BrList, String[] EnglishList) {
        Scanner read = new Scanner(System.in);

        for (int i = 0; i < 100; i ++) {

            boolean emptyArray = true;
            for (int a = 0; a < 100; a ++) {
                if (EnglishList[a] != null) {
                    emptyArray = false;
                    break;
                }
            }

            if (!emptyArray) {
                System.out.println("Which word do you wanna exclude?");
                String deletedWord = read.next();

                boolean registeredWord = false;
                for (int j = 0; j < 100; j ++) {
                    if (deletedWord.equalsIgnoreCase(BrList[j]) || deletedWord.equalsIgnoreCase(EnglishList[j])) {
                        i = j;
                        registeredWord = true;
                        break;
                    }
                }

                if(registeredWord) {
                    EnglishList[i] = null;
                    BrList[i] = null;

                    i = 0;

                    System.out.println("""
                            Do you wanna exclude another word?
                            1: Yes.
                            2: No.""");

                    int keep_On = read.nextInt();

                    if (keep_On == 2) {
                        break;
                    }

                }
                else {
                    System.out.println("\nThis word isn't registered, try again.\n");
                    i = 0;
                }
            }
            else {
                System.out.println("\nNo one word registered.\n");
                break;
            }
        }
    }

    public static void SearchMeaning (String[] BrList, String[] EnglishList) {
        Scanner read = new Scanner(System.in);

        boolean emptyArray = true;
        for (int a = 0; a < 100; a ++) {
            if (EnglishList[a] != null) {
                emptyArray = false;
                break;
            }
        }

        if (!emptyArray) {
            for (int i =0; i < 100; i ++) {
                boolean registeredWord = false;
                System.out.println("Which word do you wanna know the meaning?");
                String word = read.next();

                for (int j = 0; j < 100; j ++) {
                    if (word.equalsIgnoreCase(BrList[j]) || word.equalsIgnoreCase(EnglishList[j])) {
                        i = j;
                        registeredWord = true;
                        break;
                    }
                }

                if (registeredWord) {
                    if (word.equalsIgnoreCase(BrList[i])) {
                        System.out.println("\nThe meaning of " + BrList[i] + " is " + EnglishList[i] + ".\n");
                    }
                    else if (word.equalsIgnoreCase(EnglishList[i])) {
                        System.out.println("\nThe meaning of " + EnglishList[i] + " is " + BrList[i] + ".\n");
                    }

                    i = 0;

                    System.out.println("""
                            Search for the meaning of another word?
                            1: Yes.
                            2: No.""");

                    int keep_On = read.nextInt();

                    if (keep_On == 2) {
                        break;
                    }

                }

                else {
                    System.out.println("\nThis word isn't registered, try again.\n");
                    i = 0;
                }

            }
        }

        else {
            System.out.println("\nNo one word registered.\n");
        }
    }
}