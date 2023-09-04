import java.util.*;

public class Turn { // code to assign random turn order

    public static void turnOrder(String[] arr) {
        
        System.out.println("Deciding turn order, please wait...\n");

        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
			int randomIndex = rand.nextInt(arr.length);
			String temp = arr[randomIndex];
			arr[randomIndex] = arr[i];
			arr[i] = temp;
		}
       
        System.out.println("Turn Order:");
        
        for(int i = 0; i < arr.length; i++) {
            System.out.println((i + 1) + ". " + arr[i]);
        }

    }

}