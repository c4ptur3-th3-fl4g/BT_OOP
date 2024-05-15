class RunPingPong implements Runnable {
    String word;
    int delay;
    RunPingPong(String w, int d){
        word = w;
        delay = d;
    }
    public void run() {
        try {
            for(;;) {
                System.out.print(word + " ");
                Thread.sleep(delay);
            }
        } catch(InterruptedException e) {
            return;
        }
    }
    public static void main(String[] args) {
        Runnable ping = new RunPingPong("ping", 33);
        Runnable pong = new RunPingPong("PONG", 100);
        new Thread(ping).start();
        new Thread(pong).start();
    }
}
