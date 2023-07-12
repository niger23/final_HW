package Exception;

public class DataException extends Exception{
    private String n;

    public DataException (String message, int e) {
        super(message);
        if (e == 112) n = (char)27 + "[31mДата только в формате dd.mm.yyyy" + (char)27 + "[0m";
        else if (e == 114) n = (char)27 + "[31mОшибка в наборе данных" + (char)27 + "[0m";
        
    }
    public String getInfo() {
        return n;
    }
}