import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        ToysLotteryMachine machine = new ToysLotteryMachine();
        machine.play(5);

        Optional<Toy> toy = machine.getToyIfPossible();
        if (toy != null) {
            System.out.println("Вы выиграли " + toy.get().getTitle());
        }

        while (toy != null) {
            toy = machine.getToyIfPossible();
            if (toy != null) {
                System.out.println("Вы выиграли " + toy.get().getTitle());
            }
        }
    }
}
