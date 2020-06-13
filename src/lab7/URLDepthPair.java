package lab7;

import java.net.*;
import java.util.Objects;

public class URLDepthPair {
    private String currentURL;
    private int currentDepth;

    public URLDepthPair(String URL, int depth) {
        currentURL = URL;
        currentDepth = depth;
    }
    public String getURL() {
        return currentURL;
    }
    public int getDepth() {
        return currentDepth;
    }
    public String toString() {
        String stringDepth = Integer.toString(currentDepth);
        return stringDepth + '\t' + currentURL;
    }

    @Override
    public boolean equals(Object o) {
        boolean res = false;
        if (o instanceof URLDepthPair){
            URLDepthPair obj = (URLDepthPair) o;
            res = currentURL.equals(obj.getURL());
        }
        return res;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentURL, currentDepth);
    }
}