package Model;
import java.time.LocalDate;

public abstract class PackAnimals extends Animals{

    public PackAnimals(int idPets, String name, LocalDate birthday) {
        super(idPets, name, birthday);
    }
    
}
