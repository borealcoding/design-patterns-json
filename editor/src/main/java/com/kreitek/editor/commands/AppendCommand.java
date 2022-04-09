package com.kreitek.editor.commands;

import com.kreitek.editor.Command;

import java.util.ArrayList;

public class AppendCommand implements Command {
    private final String text;

    public AppendCommand(String text) {
        this.text = text;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        documentLines.add(text);
    }
}
