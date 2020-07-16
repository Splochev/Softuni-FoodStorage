package FoodStorage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        HashMap<Person,Buyer> buyers = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            if (tokens.length == 4) {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];
                String birthDate = tokens[3];
                Citizen c = new Citizen(name, age, id, birthDate);
                buyers.put(c,c);
            } else if (tokens.length == 3) {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String group = tokens[2];
                Rebel r = new Rebel(name, age, group);
                buyers.put(r,r);
            }
        }

        String input = sc.nextLine();
        while (!input.equals("End")) {
            for (Map.Entry<Person, Buyer> buyer : buyers.entrySet()) {
                if(buyer.getKey().getName().equals(input)){
                    buyer.getValue().buyFood();
                }
            }
            input = sc.nextLine();
        }

        int totalFood = 0;
        for (Buyer buyer : buyers.values()) {
            totalFood+= buyer.getFood();
        }

        System.out.println(totalFood);

    }
}
