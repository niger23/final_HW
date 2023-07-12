package Presenter;

import java.util.Scanner;

import View.View;

public class InputData {
    public String[] enterData() {
        View view = new View();
        Scanner in = new Scanner(System.in);
        try {
            while (true){
                view.startCreate();
                String data = in.nextLine();
                String[] arrayData = data.split(" ");
                if (arrayData.length == 2) {
                    return arrayData;
                } else if (arrayData.length < 6){
                    System.out.println((char)27 + "[31mДанных не хватает, попробуйте снова!" + (char)27 + "[0m");
                } else System.out.println((char)27 + "[31mДанных больше, чем нужно, повторим!" + (char)27 + "[0m");
            }
        } catch (Exception e) {
            return null;
        }
    }
}
