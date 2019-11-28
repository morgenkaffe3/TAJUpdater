package Updater;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.update4j.Configuration;

public class App {
    public static void main(String[] args) throws IOException {
    	SplashScreen splash = new SplashScreen();
    	
    	URL url = new URL("https://morgenkaffe3.github.io/TeaseAIJava/releases/update");
    	
    	Configuration config = null;
    	try(InputStreamReader in = new InputStreamReader(url.openStream())) {
    	    config = Configuration.read(in);
    	}

    	config.update(splash);
    	
    	config.launch();
    }
}