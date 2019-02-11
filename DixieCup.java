//package dixiecupproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package dixiecupproeject;

import java.util.Scanner;
import java.util.Arrays;

/**
 *  
 * @author Kye Nam
 */
public class DixieCup {

    private String items[];
    private int itemNumber = 0;

    public DixieCup(int i){
        items = new String[i];
    }

    public void addItem(String n)
    {
        if(itemNumber < items.length) //Checks if the current item count is less than the array length
        {
            items[itemNumber] = n; //Adds item
            itemNumber ++; //Increases itemNumber
            System.out.println("Your item, " + n + ", has been added to DixieCup");
        }
        else
        {
            System.out.println("The cup is already full");
        }
    }


    public void removeItem(String n){
        for(int i = 0; i < items.length; i++){
            if(items[i].equals(n)){
                items[i] = null;
            }
        }
    }


    public String getItem(int i){
        return items[i];
    }

    public String toString(){
        String contents = "";
        for(int i = 0; i < items.length; i ++){
            contents = contents + items[i] + ", ";
        }
        return contents.substring(0, contents.length() - 2);
    }


    public void setItem(int index, String newItem){ 
        items[index] = newItem;
    }

    public void swapItem(DixieCup b, int i1, int i2)
    {
        String temp = items[i1]; //Saves item[i1] so it can be replaced

        items[i1] = b.items[i2]; //puts i2 into the i1 slot

        b.items[i2] = temp; //puts i1 into the i2 slot
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCups = 0;
        int numPlaces = 0;

        while (numCups < 1 || numCups > 4)
        {
            System.out.println("How many cups would you like? Please choose a number in between 1 and 4");
            numCups = in.nextInt();
        }
        DixieCup[] cupsArray = new DixieCup[numCups];

        while (numPlaces < 1)
        {
            System.out.println("How many places would you like in each cup? Please choose a number greater than 1");
            numPlaces = in.nextInt();
        }

        for (int i = 0; i < numCups; i ++)
        {
            cupsArray[i] = new DixieCup(numPlaces);
        }

        int n = 0;
        int input = 10;
        while (input != 7)
        {
            System.out.println("\n" + "Please choose an action");
            System.out.println("1. Add an Item");
            System.out.println("2. Change an Item");
            System.out.println("3. Remove an Item");
            System.out.println("4. Swap Items");
            System.out.println("5. Display the contents of a DixieCup");
            System.out.println("6. Summary of all Dixie Cups");
            System.out.println("7. Quit");

            input = in.nextInt();

            switch(input)
            {
                case 1: // Adding Items in specific cups
                System.out.println("\n" + "What Item would you like to add?");
                String s = in.next();
                int addition = -1;
                while(addition > numCups - 1 || addition < 0)
                {
                    System.out.println("To which cup?");
                    addition = in.nextInt();
                }
                cupsArray[addition].addItem(s);
                break;
                
                //---------------------------------------------------------------
                
                case 2: // Changing Items
                int removal = -1;
                while (removal < 0 || removal > numPlaces - 1)
                {
                    System.out.println("\n" + "What object number would you like to remove?");
                    removal = in.nextInt();
                }
                int cupNum = -1;
                while(cupNum > numCups - 1 || cupNum < 0)
                {
                    System.out.println("From which cup?");
                    cupNum = in.nextInt();
                }
                cupsArray[cupNum].removeItem(cupsArray[cupNum].getItem(removal));
                System.out.println("What would you like to replace it with?");
                String replacer = in.next();
                cupsArray[cupNum].setItem(removal, replacer);  
                break;

                
                //---------------------------------------------------------------
                
                case 3: // Removing Items from specific cup
                    System.out.println("\n"+ "What item would you like to remove?");
                    String remove = in.next();
                    int subtraction = -1;
                    while(subtraction > numCups - 1 || subtraction < 0)
                    {
                        System.out.println("From which Cup?");
                        subtraction = in.nextInt();
                    }
                    cupsArray[subtraction].removeItem(remove);
                break;
                
                //---------------------------------------------------------------
                
                case 4: // Swapping Items in different cups or within the same cup
                int placeA = -1;
                int placeB = -1;
                
                while (placeA < 0 || placeA > numPlaces - 1)
                {
                    System.out.println("\n" + "What object number would you like to remove?");
                    placeA = in.nextInt();
                }
                int cupA = -1;
                int cupB = -1;
                
                while(cupA > numCups - 1 || cupA < 0)
                {
                    System.out.println("From which cup?");
                    cupA = in.nextInt();
                }
                
                while (placeB < 0 || placeB > numPlaces - 1)
                {
                    System.out.println("\n" + "What object number would you like to remove?");
                    placeB = in.nextInt();
                }
                
                while(cupB > numCups - 1 || cupB < 0)
                {
                    System.out.println("From which cup?");
                    cupB = in.nextInt();
                }
                String aThing = cupsArray[cupA].getItem(placeA);
                String bThing = cupsArray[cupB].getItem(placeB);
                
                cupsArray[cupA].swapItem(cupsArray[cupB], placeA, placeB);
                
                System.out.println(aThing + " has been swapped with " + bThing);
                break;

                //---------------------------------------------------------------
                
                case 5: // displaying the contents
                System.out.println("What cup would you like to see?");
                int view = in.nextInt();
                System.out.println(cupsArray[view].toString());
                break;
                
                //---------------------------------------------------------------
                
                case 6: // Summary of Dixie Cups 
                int firstCup = 0;
                int secondCup = 0;
                int thirdCup = 0;

                for(int i = 0; i < numPlaces; i ++) 
                {
                    if (cupsArray[0].getItem(i) == null)
                    {
                            firstCup ++;
                    }

                        if (cupsArray[1].getItem(i) == null)
                    {
                            secondCup ++;
                    }

                        if (cupsArray[2].getItem(i) == null)
                    {
                            thirdCup ++;
                    }
                }
                int large = 0;
                int small = 0;
                int medium = 0;

                int[] sorter = {firstCup, secondCup, thirdCup};

                for(int i = 1; i < 3; i ++)
                { 
                        if (large < sorter [i])
                            large = i;
                }

                for(int i = 1; i < 3; i ++)
                { 
                        if (small > sorter [i])
                            small = i;
                }

                for(int i = 0; i < 3; i ++)
                { 
                        if (i !=  small || i != large)
                                medium = i;
                }

                System.out.println("\n" + "--------------------------------------------" + "\n" + "Cup With the Most Items : Cup " + large + "\n" + "Cup With the Least Items : Cup " + small + "\n" + "--------------------------------------------" + "\n" + "Cup                            Number of Items" + "\n" + "--------------------------------------------" + "\n" + "Cup " + small + "                               " + sorter[small] + "\n" + "Cup " + large + "                               " + sorter[large]); 
                break;
                
                //---------------------------------------------------------------
                
                case 7: //Quitting the Program
		System.out.println("\n" + "Thank you for using the program.");
                break;

                //---------------------------------------------------------------
                
                default: System.out.println("Invalid choice. Please type a valid option");
                break;
            }
        }

    }
}
