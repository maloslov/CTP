package lab8;

import java.net.*;
import java.io.*;

public class CrawlerTask implements Runnable {
    private URLPool pool;

    public CrawlerTask(URLPool pool, int maxDepth) {
        this.pool = pool;
    }

    private void process(URLDepthPair pair) throws IOException {
        final String URL_START = "a href=\"",
                PREFIX = "http";
        URL url = new URL(pair.getURL());
        URLConnection urlConnection = url.openConnection();
        String redirect,
                input,
                link;
        BufferedReader reader;

        try {
            redirect = urlConnection.getHeaderField("Location");
            if (redirect != null) {
                urlConnection = new URL(redirect).openConnection();
            }
            pool.addProcessed(pair);
            reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        } catch (IOException e){
            return;
        }

        while ((input = reader.readLine()) != null) {
            while (input.contains(URL_START + PREFIX)) {
                input = input.substring(input.indexOf(URL_START + PREFIX) + 8);
                link = input.substring(0, input.indexOf('\"'));
                //

                if(link.contains(" ")) {
                    link = link.replace(" ", "%20");
                }
                // if same links
                if (pool.getPending().contains(new URLDepthPair(link, 0)) ||
                        pool.getProcessed().contains(new URLDepthPair(link,0))) {
                    continue;
                }
                pool.addPending(new URLDepthPair(link, pair.getDepth() + 1));
            }
        }
        reader.close();
    }

    @Override
    public void run() {
        try {
            while (true) {
                process(pool.get());
            }
        } catch(IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}


