package Presenter;
import java.time.LocalDate;
import java.util.Scanner;

import Model.*;
import View.Counter;
import View.Registry;
import View.View;

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
        int num = Integer.parseInt(in.nextLine());
        if (num >= 0 & num <= 6) registry.addAnimal(createAnimal(num));
        else view.BadIndex();

    }
    public Animals createAnimal(int id) {
        try {
            view.startCreate();
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            String [] name_data = input.split(" ");
            String [] data = name_data[1].split("-");
            if (id == 1) return new Cat(1, name_data[0], LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
            else if (id == 2) return new Dog(2, name_data[0], LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
            else if (id == 3) return new Hamster(3, name_data[0], LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
            else if (id == 4) return new Horse(4, name_data[0], LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
            else if (id == 5) return new Donkey(5, name_data[0], LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
            else return new Camel(6, name_data[0], LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
        } catch (Exception e) {
            System.out.println("Введены данные не в нужном формате, создаём тестового питомца");
            return new Dog(2, "Jack", LocalDate.of(2022,4,25));
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
                System.out.println("Нет умений");
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
