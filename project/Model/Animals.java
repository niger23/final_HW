package Model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Animals {
    private int idPets;
    private String name;
    private LocalDate birthday;
    private List <String> skills;

    public Animals(int idPets, String name, LocalDate birthday) {
        this.idPets = idPets;
        this.name = name;
        this.birthday = birthday;
    }

    public int getIdPets() {
        return this.idPets;
    }

    public void setIdPets(int idPets) {
        this.idPets = idPets;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSkills(String skill) {
        if (this.skills == null) {
            List <String> skills = new ArrayList<>();
            this.skills = skills;
        }
        this.skills.add(skill);
    }

    public List<String> getSkills() {
        return this.skills;
    }

    public String getBirthday() {
        DateTimeFormatter newDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return newDate.format(birthday);
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getClassName(int num) {
        if (num == 1) return "cat";
        else if (num == 2) return "dog";
        else if (num == 3) return "hamster";
        else if (num == 4) return "horse";
        else if (num == 5) return "donkey";
        else if (num == 6) return "camel";
        else return null;
    }

    @Override
    public String toString() {
        return " class= " +  getClassName(getIdPets()) + 
            ", name= " + getName() + 
            ", birthday= " + getBirthday();
    }
    
}
