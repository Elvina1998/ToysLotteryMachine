import java.util.ArrayList;
import java.util.Optional;
import java.util.PriorityQueue;

public class ToysLotteryMachine {

    private ArrayList<Toy> store;
    private PriorityQueue<Toy> deliveryQueue;
    private int lastUsedId;

    public ToysLotteryMachine() {
        this.store = new ArrayList<Toy>();
        this.deliveryQueue = new PriorityQueue<Toy>();
        this.lastUsedId = 0;
        this.fillInitialToys();
    }

    private void fillInitialToys() {
        addToy("Кот", 5, 50);
        addToy("Заяц", 3, 20);
        addToy("Воробей", 10, 70);
    }

    public void addToy(String title, int count, int dropPercentage) {
        Toy toy = new Toy(lastUsedId, title, count, dropPercentage);
        store.add(toy);
        lastUsedId++;
    }

    public void play(int count) {
        for (int i = 0; i < count; i++) {
            int index = i % store.size();
            Toy toy = this.store.get(index);
            if (toy.isWin()) {
                toy.decreaseCount();
                this.deliveryQueue.add(toy);
            }
            if (toy.getCount() == 0) {
                store.remove(index);
            }
        }
    }

    public Optional<Toy> getToyIfPossible() {
        if (deliveryQueue.isEmpty()) {
            return null;
        } else {
            return Optional.of(deliveryQueue.poll());
        }
    }
}
