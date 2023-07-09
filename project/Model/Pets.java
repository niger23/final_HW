package Model;
import java.time.LocalDate;

public abstract class Pets extends Animals{

    public Pets(int idPets, String name, LocalDate birthday) {
        super(idPets, name, birthday);
    }
    
}
