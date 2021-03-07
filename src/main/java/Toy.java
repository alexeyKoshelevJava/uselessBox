public class Toy {
    private static volatile Tumbler tumbler = Tumbler.TurnON;

    public Tumbler getTumbler() {
        return tumbler;
    }

    public void setTumbler(Tumbler tumbler) {
        this.tumbler = tumbler;
    }
}
