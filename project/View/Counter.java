package View;
public class Counter implements AutoCloseable{
    public int count;
    {
        count = 0;
    }

    public void add() {
        count++;
    }
    @Override
    public void close() {
        System.out.println("Counter close");
    }
    public int getCount() {
        return this.count;
    }

}
