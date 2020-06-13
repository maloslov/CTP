package lab7;

import java.net.*;
import java.io.*;
import java.util.*;

public class Crawler {
    private int maxDepth;
    private LinkedList<URLDepthPair> pending = new LinkedList<>();
    private LinkedList<URLDepthPair> processed = new LinkedList<>();

    public Crawler(String startLink, int maxDepth) {
        this.maxDepth = maxDepth;
        pending.add(new URLDepthPair(startLink, 0));
    }

    public void start() throws IOException {
        while (pending.size() > 0) {
            process(pending.removeFirst());
        }
    }

    private void process(URLDepthPair pair) throws IOException {
        final String URL_START = "a href=\"",
                PREFIX = "http";
        URL url = new URL(pair.getURL());
        URLConnection urlConnection = url.openConnection();
        String redirect = urlConnection.getHeaderField("Location"),
                input,
                link;

        if (redirect != null) {
            urlConnection = new URL(redirect).openConnection();
        }
        processed.add(pair);
        System.out.println(pair.toString());

        if (pair.getDepth() == maxDepth) {
            return;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        while ((input = reader.readLine()) != null) {
            while (input.contains(URL_START + PREFIX)) {
                input = input.substring(input.indexOf(URL_START + PREFIX) + 8);
                link = input.substring(0, input.indexOf('\"'));
                if(link.contains(" ")) {
                    link = link.replace(" ", "%20");
                }
                // if same links
                if (pending.contains(new URLDepthPair(link, 0)) ||
                        processed.contains(new URLDepthPair(link, 0))) {
                    continue;
                }
                pending.add(new URLDepthPair(link, pair.getDepth() + 1));
            }
        }
        reader.close();
    }

    /*
    public String getAllLinks() {
        String res = "";
        for (URLDepthPair elem : processed){
            res += elem.toString() + "\r\n";
        }
        res += "Number of links: " + processed.size();
        return res;
    }
    */
}


