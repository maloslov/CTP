package lab7;

import java.net.*;
import java.util.*;
import java.io.*;

public class Crawler {
    public static void main(String[] arg) {
        String[] args = new String[]{"http://www.wikidot.com/","4"};
        int depth = 0;

        if (args.length != 2) {
            System.out.println("Wrong args! use: java Crawler <URL> <depth>");
            System.exit(1);
        }
        else {
            try {
                depth = Integer.parseInt(args[1]);
            }
            catch (NumberFormatException nfe) {
                System.out.println("Wrong args! use: java Crawler <URL> <depth>");
                System.exit(1);
            }
        }

        LinkedList<URLDepthPair> processedURLs = new LinkedList<URLDepthPair>(),
                pendingURLs = new LinkedList<URLDepthPair>();

        URLDepthPair currentDepthPair = new URLDepthPair(args[0], 0);
        pendingURLs.add(currentDepthPair);
        ArrayList<String> seenURLs = new ArrayList<String>();
        seenURLs.add(currentDepthPair.getURL());

        while (pendingURLs.size() != 0) {
            URLDepthPair depthPair = pendingURLs.pop();
            processedURLs.add(depthPair);

            int curDepth = depthPair.getDepth();
            LinkedList<String> linksList = new LinkedList<String>();
            linksList = Crawler.getAllLinks(depthPair);

            if (curDepth < depth) {
                for (int i = 0; i < linksList.size(); i++) {

                    String newURL = linksList.get(i);

                    if (seenURLs.contains(newURL)) {
                        continue;
                    }
                    else {
                        URLDepthPair newPair = new URLDepthPair(newURL, curDepth + 1);
                        pendingURLs.add(newPair);
                        seenURLs.add(newURL);
                    }
                }
            }
        }
        Iterator<URLDepthPair> iter = processedURLs.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    private static LinkedList<String> getAllLinks(URLDepthPair pairs) {
        Socket sock;
        OutputStream out;
        InputStream in;
        LinkedList<String> URLs = new LinkedList<String>();
        String line;
        int beginIndex = 0,
                endIndex = 0,
                index = 0;
        final String URL_START = "a href=\"",
                URL_END = "\"";

        try {
            sock = new Socket(pairs.getWebHost(), 80);
        }
        catch (UnknownHostException e) {
            //    System.err.println("UnknownHostException1: " + e.getMessage());
            return URLs;
        }
        catch (IOException ee) {
            //    System.err.println("IOException2: " + ee.getMessage());
            return URLs;
        }
        try {
            sock.setSoTimeout(3000);
        }
        catch (SocketException eee) {
            //    System.err.println("SocketException3: " + eee.getMessage());
            return URLs;
        }

        String webHost = pairs.getWebHost(),
                docPath = pairs.getDocPath();

        try {
            out = sock.getOutputStream();
        }
        catch (IOException eeee) {
            //    System.err.println("IOException4: " + eeee.getMessage());
            return URLs;
        }

        PrintWriter myWriter = new PrintWriter(out, true);
        myWriter.println("GET " + docPath + " HTTP/1.1");
        myWriter.println("Host: " + webHost);
        myWriter.println("Connection: close");
        myWriter.println();

        try {
            in = sock.getInputStream();
        }
        catch (IOException eeeee){
            //   System.err.println("IOException5: " + eeeee.getMessage());
            return URLs;
        }
        BufferedReader BuffReader = new BufferedReader(new InputStreamReader(in));

        // Try to read
        while (true) {
            try {
                line = BuffReader.readLine();
            }
            catch (IOException except) {
                //    System.err.println("IOException6: " + except.getMessage());
                return URLs;
            }
            if (line == null)
                break;

            while (true) {
                index = line.indexOf(URL_START, index);
                if (index == -1)
                    break;

                index += URL_START.length();
                beginIndex = index;
                endIndex = line.indexOf(URL_END, index);
                index = endIndex;
                String newLine = "";
                try{
                    newLine = line.substring(beginIndex, endIndex);
                    URLs.add(newLine);
                } catch(StringIndexOutOfBoundsException ignored) { break; }
            }
        }
        return URLs;
    }
}

