package hu.radio;

import hu.radio.Controller.MessageService;
import hu.radio.domain.service.Console;
import hu.radio.domain.service.DataApi;
import hu.radio.domain.service.DataParser;
import hu.radio.domain.service.FileReader;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {

    private final Console console;
    private final FileWriter fileWriter;
    private final MessageService messageService;


    private App() throws IOException {
        console = new Console(new Scanner(System.in));
        fileWriter = new FileWriter("adaas.txt");
        DataApi dataApi = new DataApi(new FileReader(), new DataParser());
        messageService = new MessageService(dataApi.getData("veetel.txt"));

    }

    public static void main(String[] args) throws IOException {
        new App().run();
    }

    private void run() {
        System.out.println("2. feladat");
    }
}
