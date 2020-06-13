package lab7;

import java.io.IOException;

public class CrawlerApp {
    public static void main(String[] args) throws IOException {
        if(args.length == 2){
            Crawler crawler = new Crawler(args[0], Integer.parseInt(args[1]));
            crawler.search();
            crawler.printAllLinks();
        } else
            System.out.println("Wrong args! usage: <start URL> <depth>");
    }
}
