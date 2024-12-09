package com.nuclearcrackhead.serverboss.api.gcp.dot;

import com.google.common.util.concurrent.AtomicDouble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GcpDotAPI {

    protected static final AtomicDouble INDEX = new AtomicDouble(0);

    protected static final URI GCP_DOT_INDEX_URL = URI.create("https://gcpdot.com/gcpindex.php");
    protected static final Pattern INDEX_PATTERN = Pattern.compile("'>(.*?)<");

    protected static boolean STARTED = false;

    public static void start() {
        if (STARTED) return;

        GcpDotFetcher fetcher = new GcpDotFetcher();
        Thread thread = new Thread(fetcher);
        thread.setName("gcp_dot_fetcher_service");
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
        STARTED = true;
    }

    public static Double getIndex() {
        return INDEX.get();
    }

    public static class GcpDotFetcher implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    URL oracle = GCP_DOT_INDEX_URL.toURL();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(oracle.openStream()));
                    String text = reader.lines().collect(Collectors.joining());
                    Matcher matcher = INDEX_PATTERN.matcher(text);
                    while (matcher.find()) {
                        String rawIndex = matcher.group().split("'>")[1].split("<")[0];
                        double index = Double.parseDouble(rawIndex);
                        INDEX.set(index);
                        TimeUnit.SECONDS.sleep(1);
                    }
                }
            } catch (InterruptedException | IOException ignored) {}
        }

    }

}
