package com.kreitek.editor.commands;

import com.kreitek.editor.BadCommandException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser {

    public String[] parse(String commandLine) throws BadCommandException {
        if (isValidCommand(commandLine)) {
            return getArguments(commandLine);
        } else {
            throw new BadCommandException();
        }
    }

    private boolean isValidCommand(String commandLine) {
        final String regex = "a \\\"([a-zA-ZÀ-ÿ\\u00f1\\u00d1]|[.,\\s\\/#!$%\\^&\\*;:{}=\\-_`~()”“\"…]|\\s])*\\\"|d ([0-9])*|u ([0-9])* \\\"([[a-zA-ZÀ-ÿ\\u00f1\\u00d1]|[.,\\s\\/#!$%\\^&\\*;:{}=\\-_`~()”“\"…]|\\s])*\\\"|undo|exit";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(commandLine);

        if (matcher.matches())
            return true;

        return false;
    }

    private String[] getArguments(String commandLine) {
        if (commandLine.startsWith("a ")) {
            String[] args = commandLine.split("a \"");
            return new String[]{"a", args[1].substring(0,args[1].length()-1)};
        }
        if (commandLine.startsWith("d ")) {
            return new String[]{"d", commandLine.split(" ")[1]};
        }
        if (commandLine.startsWith("u ")) {
            commandLine = commandLine.split("u \"")[0];
            int index = commandLine.indexOf(" \"");
            String arg2 = commandLine.substring(2, index);
            String arg3 = commandLine.substring(index+2, commandLine.length() - 1);

            return new String[]{"u", arg2, arg3};
        }
        return new String[]{commandLine};
    }
    
}
