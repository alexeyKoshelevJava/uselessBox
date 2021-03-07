public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int limiter = 5;
        Toy toy = new Toy();
        Thread user = new MyThred(toy) {
            public void run() {
                for (int i = 0; i < limiter; i++) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (toy.getTumbler() == Tumbler.TurnOff) {
                        toy.setTumbler(Tumbler.TurnON);
                        System.out.println("Я пользователь , переключил на TurnON");
                    }
                }

            }
        };
        user.start();
        Thread game = new MyThred(toy) {
            public void run() {
                while (true) {
                    if (isInterrupted()) return;


                    if (toy.getTumbler() == Tumbler.TurnON) {
                        toy.setTumbler(Tumbler.TurnOff);
                        System.out.println("Я игра , переключила на TurnOFF");
                    }
                }
            }


        };
        game.start();

        user.join();
        game.interrupt();


    }


}

