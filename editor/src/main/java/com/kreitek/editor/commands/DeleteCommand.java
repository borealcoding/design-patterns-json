package com.kreitek.editor.commands;

import com.kreitek.editor.Command;

import java.util.ArrayList;

public class DeleteCommand implements Command {
    private final int lineNumber;

    public DeleteCommand(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        documentLines.remove(lineNumber);
    }
}
