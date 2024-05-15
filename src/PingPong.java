class PingPong extends Thread{
    String word;
    int delay;
    PingPong(String s, int d){
        word = s;
        delay = d;
    }
    public void run() {
        try{
            for(;;) {
                System.out.print(word + " ");
                Thread.sleep(delay);
            }
        } catch(InterruptedException e) {
            return;
        }
    }
    public static void main(String[] args) {
        new PingPong("ping", 33).start();
        new PingPong("PONG", 100).start();
    }
}