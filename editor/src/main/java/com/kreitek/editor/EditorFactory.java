package com.kreitek.editor;

public class EditorFactory {
    public Editor getEditor(String viewMode) {
        return new ConsoleEditor(viewMode);
    }
}
