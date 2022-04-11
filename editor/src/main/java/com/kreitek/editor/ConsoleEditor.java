package com.kreitek.editor;

import com.kreitek.editor.commands.CommandFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleEditor<JSONObject> implements Editor {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_WHITE = "\u001B[37m";

    private final CommandFactory commandFactory = new CommandFactory();
    private final String viewMode;
    private ArrayList<String> documentLines = new ArrayList<String>();

    public ConsoleEditor(String viewMode) {
        this.viewMode = viewMode;
    }

    @Override
    public void run() {
        boolean exit = false;
        while (!exit) {
            String commandLine = waitForNewCommand();
            try {
                Command command = commandFactory.getCommand(commandLine);
                command.execute(documentLines);
            } catch (BadCommandException e) {
                printErrorToConsole("Bad command");
            } catch (ExitException e) {
                exit = true;
            }
            showDocumentLines(documentLines);
            showHelp();
        }
    }

    private void printDocumentInText(ArrayList<String> textLines) {
        printLnToConsole("START DOCUMENT ==>");
        for (int index = 0; index < textLines.size(); index++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append(index);
            stringBuilder.append("] ");
            stringBuilder.append(textLines.get(index));
            printLnToConsole(stringBuilder.toString());
        }
        printLnToConsole("<== END DOCUMENT");
    }

    private void printDocumentInJson(ArrayList<String> textLines) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        stringBuilder.append(" \"doc\":[\n");
        for (int index = 0; index < textLines.size(); index++) {
            stringBuilder.append("  {\"line\":\"").append(index);
            stringBuilder.append("\",\"text\":\"").append(textLines.get(index)).append("\"},\n");
        }
        stringBuilder.append(" ]\n");
        stringBuilder.append("}");
        printLnToConsole(stringBuilder.toString());
    }

    private void showDocumentLines(ArrayList<String> textLines) {
        if (textLines.size() > 0){
            setTextColor(TEXT_YELLOW);
            if (viewMode.equalsIgnoreCase("text")) { printDocumentInText(textLines); }
            if (viewMode.equalsIgnoreCase("json")) { printDocumentInJson(textLines); }
            setTextColor(TEXT_RESET);
        }
    }

    private String waitForNewCommand() {
        printToConsole("Enter a command : ");
        Scanner scanner = new Scanner(System. in);
        return scanner.nextLine();
    }

    private void showHelp() {
        printLnToConsole("To add new line -> a \"your text\"");
        printLnToConsole("To update line  -> u [line number] \"your text\"");
        printLnToConsole("To delete line  -> d [line number]");
    }

    private void printErrorToConsole(String message) {
        setTextColor(TEXT_RED);
        printToConsole(message);
        setTextColor(TEXT_RESET);
    }

    private void setTextColor(String color) {
        System.out.println(color);
    }

    private void printLnToConsole(String message) {
        System.out.println(message);
    }

    private void printToConsole(String message) {
        System.out.print(message);
    }

}
