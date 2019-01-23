package com.flow.management;

import com.flow.management.gui.Window;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            com.flow.management.gui.Window window = new Window();
            window.setVisible(true);
        });
    }
}
