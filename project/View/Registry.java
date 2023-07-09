package View;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Model.*;

public class Registry {
    private List<Animals> reestrAnimals;

    public Registry(List<Animals> reestrAnimals) {
        this.reestrAnimals = reestrAnimals;
    }

    public Registry() {
        List<Animals> reestrAnimals = new ArrayList <Animals>();
        Dog dog = new Dog(2, "Jack", LocalDate.of(2022,4,25));
        reestrAnimals.add(dog);

        
        this.reestrAnimals = reestrAnimals;
    }

    public List<Animals> getReestrAnimals() {
        return this.reestrAnimals;
    }

    public Animals getAnimal(int index) {
        return this.reestrAnimals.get(index);
    }

    public void addAnimal(Animals animal) {
        this.reestrAnimals.add(animal);
    }

    public void removeAnimal(int index) {
        this.reestrAnimals.remove(index);
    }

}
