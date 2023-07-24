import java.util.Objects;
import java.util.Random;

public class Toy implements Comparable {

    private int id;
    private String title;
    private int count;
    private int dropPercentage;

    public Toy(int id, String title, int count, int dropPercentage) {
        this.id = id;
        this.title = title;
        this.count = count;
        this.dropPercentage = dropPercentage;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public int getCount() {
        return this.count;
    }

    public void setDropPercentage(int dropPercentage) {
        this.dropPercentage = dropPercentage;
    }

    public void decreaseCount() {
        if (this.count > 1) {
            this.count--;
        }
    }

    public void increaseCount(int value) {
        this.count += value;
    }

    public boolean isWin() {
        Random random = new Random();
        int i = random.nextInt(101);
        return i >= dropPercentage && count != 0;
    }

    @Override
    public int compareTo(Object o) {
        Toy toy = (Toy) o;
        return this.id - toy.getId();
    }
}
