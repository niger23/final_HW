package Presenter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import Model.*;
import View.Counter;
import View.Registry;
import View.View;
import Presenter.InputData;
import Presenter.ParseData;

public class Presenter {
    private View view;
    private Registry registry;

    public Presenter(View view, Registry registry) {
        this.view = view;
        this.registry = registry;
    }

    public void Open() {
        try (Scanner in = new Scanner(System.in); Counter count = new Counter()) {
            boolean flag = true;
            while(flag) {
                view.Menu();
                int menu = Integer.parseInt(in.nextLine());
                if (menu == 1) view.PrintAnimals(registry.getReestrAnimals());
                else if (menu == 2) getAddAnimal();
                else if (menu == 3) getSkillAnimal();
                else if (menu == 4) setSkillAnimal();
                else if (menu == 5) deleteAnimal();
            }
        } catch (Exception e) {
            System.out.println("");
        }
    }
    public int getInt() {
        this.view.ChoiseAnimalMsg();
        try {
            Scanner in = new Scanner(System.in);
            int num = Integer.parseInt(in.nextLine());
            if (!(num >= registry.getReestrAnimals().size()) && !(num < 0)) return num;
            else throw new Exception(); 
        } catch (Exception e) {
            return -1;
        }
    }
    public String getString() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        return str;
    }
    public void getAddAnimal () {
        view.ChoiseAnimalList();
        Scanner in = new Scanner(System.in);
        try {
            int num = Integer.parseInt(in.nextLine());
            if (num >= 0 & num <= 6) registry.addAnimal(createAnimal(num));
            else view.BadIndex();
        } catch (Exception e) {
            view.Bad16();
        }

    }
    public Animals createAnimal(int id) {
        try {
            InputData newData = new InputData();
            String[] data = newData.enterData();
            if(data != null) {
                String[] newAnimal = ParseData.parsUserInfo(data);
                LocalDate dateB = LocalDate.of(Integer.parseInt(newAnimal[3]), Integer.parseInt(newAnimal[2]), Integer.parseInt(newAnimal[1]));
                if (id == 1) return new Cat(1, newAnimal[0], dateB);
                else if (id == 2) return new Dog(2, newAnimal[0], dateB);
                else if (id == 3) return new Hamster(3, newAnimal[0], dateB);
                else if (id == 4) return new Horse(4, newAnimal[0], dateB);
                else if (id == 5) return new Donkey(5, newAnimal[0], dateB);
                else return new Camel(6, newAnimal[0], dateB);
            } else {
                view.Bad();
                return null;
            }

        } catch (Exception e) {
            System.out.println(e);
            view.Bad();
            return null;
        }
    }

    public void getSkillAnimal() {
        int index = getInt();
        if (index >= 0) {
            Animals animal = registry.getAnimal(index);
            view.SkillAnimal(animal);
            if (animal.getSkills() != null) {
                System.out.println(animal.getSkills());
            } else {
                System.out.println((char)27 + "[31mУ этого животного нет умений!" + (char)27 + "[0m");
            }
        } else {
            view.BadIndex();
        }
    }
    public void setSkillAnimal() {
        int index = getInt();
        if (index >= 0) {
            Animals animal = registry.getAnimal(index);
            view.ChoiseSkill();
            animal.setSkills(getString());
            view.Successfully();
        } else {
            view.BadIndex();
        }
    }
    public void deleteAnimal() {
        int index = getInt();
        if (index >= 0) {
            registry.removeAnimal(index);
            view.Successfully();
        } else {
            view.BadIndex();
        }
        Open();
    }
}
