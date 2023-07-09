package View;
import java.util.List;

import Model.*;

public class View {

    public View() {
    }
    
    public void Menu() {
        System.out.println("Введите: \n1 - увидеть всех животных\n2 - добавить в реестр новое животное\n3 - посмотреть умения животного\n4 - добавить новое умение\n5 - удалить животное\n любой другой символ - выход");
    }
    public void ChoiseAnimalMsg() {
        System.out.println("Животное с каким номером выбираем?");
    }
    public void ChoiseAnimalList() {
        System.out.println("Кого создаём?\n 1 - кот, 2 - собака, 3 - хомяк, \n4 - лощадь, 5 - осёл, 6 - верблюд");
    }
    public void BadIndex() {
        System.out.println("Нет такого животного");
    }
    public void BadMenu() {
        System.out.println("Нет такого функционала");
    }
    public void startCreate() {
        System.out.println("Введите имя и дату рождения(ГГГГ-ММ-ДД), через пробел");
    }
    public void Successfully() {
        System.out.println("Выполнено успешно!");
    }
    public void ChoiseSkill() {
        System.out.println("Напишите навык, который добавляем");
    }
    public String SkillAnimal(Animals animal) {
        return "Умения животного " + animal.toString();
    }
    public void PrintAnimals (List<Animals> animals) {
        if (animals.size() >= 1) {

            System.out.printf("Всего животных в реестре: %d\n", animals.size());
            for (int i = 0; i < animals.size(); i++) {
                System.out.printf("%d %s\n", i, animals.get(i));  
            }
        } else System.out.println("Список пуст");
    }
}
