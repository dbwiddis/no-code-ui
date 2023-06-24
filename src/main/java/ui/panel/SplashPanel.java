/*
 * Copyright 2023 The Authors
 * SPDX-License-Identifier: Apache-2.0
 */
package ui.panel;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SplashPanel extends UiJPanel {

    private static final long serialVersionUID = 1L;

    public SplashPanel() {
        super();
        init();
    }

    private void init() {

        GridBagConstraints timerLabel = new GridBagConstraints();
        GridBagConstraints timerConstraints = new GridBagConstraints();
        timerConstraints.gridy = 1;
        timerConstraints.fill = GridBagConstraints.BOTH;
        timerConstraints.insets = new Insets(0, 0, 15, 15); // T,L,B,R

        JPanel splashPanel = new JPanel();
        splashPanel.setLayout(new GridBagLayout());

        JTextArea timerArea = new JTextArea(0, 0);
        timerArea.setText("Welcome to this demo of automating a series of REST calls based on responses.\n\n"
                + "Select Cat Facts to get a random cat fact via REST API.\n\n"
                + "Select Random Activities to do this workflow:\n" + "  1. Generate a random activity via REST API\n"
                + "  2. Parse the type of the activity\n"
                + "  3. Generate another random activity of the same type via new REST API\n");

        splashPanel.add(new JLabel("Introduction"), timerLabel);
        splashPanel.add(timerArea, timerConstraints);

        add(splashPanel, BorderLayout.CENTER);
    }
}
