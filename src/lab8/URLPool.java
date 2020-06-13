package lab8;

import java.util.LinkedList;

public class URLPool {
    private LinkedList<URLDepthPair> processed = new LinkedList<>();
    private LinkedList<URLDepthPair> pending = new LinkedList<>();
    private int depth;
    private int Waiting;
    private int Threads;

    public URLPool(String url, int depth, int threads) {
        pending.add(new URLDepthPair(url, 0));
        this.depth = depth;
        Threads = threads;
    }

    public synchronized URLDepthPair get() throws InterruptedException {
        if (isEmpty()) {
            Waiting++;
            if (Waiting == Threads) {
                getSites();
                System.exit(0);
            }
            wait();
        }

        URLDepthPair pair = pending.removeFirst();
        if(/* pending.size() > 0 && */ pair.getDepth() > 3) {
            System.out.println("Number of links: " + processed.size());
            System.exit(0);
        }
        return pair;
    }

    private boolean isEmpty() {
        return (pending.size() == 0);
    }

    public void getSites() {
        System.out.println("Глубина поиска: " + depth);
        for (URLDepthPair elem : getProcessed()) {
            System.out.println(elem.toString());
        }
        System.out.println("Посещённые ссылки: " + processed.size());
    }

    public void addProcessed(URLDepthPair pair) {
            processed.add(pair);
            System.out.println(pair.toString());
    }

    public synchronized void addPending(URLDepthPair pair) {
        pending.add(pair);
        if (Waiting > 0) {
            Waiting--;
            notify();
        }
    }

    public LinkedList<URLDepthPair> getProcessed() {
        return processed;
    }

    public LinkedList<URLDepthPair> getPending() {
        return pending;
    }
}