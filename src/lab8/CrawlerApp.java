package lab8;

import java.io.IOException;

public class CrawlerApp {
    public static void main(String[] args) throws IOException {
        if(args.length == 3){
            int depth = Integer.parseInt(args[1]);
            int threads = Integer.parseInt(args[2]);

            URLPool pool = new URLPool(args[0], depth, threads);
            for (int i = 0; i < threads; i++) {
                CrawlerTask search = new CrawlerTask(pool,depth);
                new Thread(search).start();
                System.out.println("Task " + i +" is running.");
            }
        }
        else
            System.out.println("Wrong args! usage: <start URL> <depth> <threads>");
    }
}
