/*
 * Copyright 2023 The Authors
 * SPDX-License-Identifier: Apache-2.0
 */
package ui.panel;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.Instant;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import ui.config.Config;

public class SplashPanel extends UiJPanel {

    private static final long serialVersionUID = 1L;

    public SplashPanel() {
        super();
        init();
    }

    private void init() {

        GridBagConstraints s1Label = new GridBagConstraints();
        GridBagConstraints s1Constraints = new GridBagConstraints();
        s1Constraints.gridy = 1;
        s1Constraints.fill = GridBagConstraints.BOTH;
        s1Constraints.insets = new Insets(0, 0, 15, 15); // T,L,B,R

        GridBagConstraints s2Label = (GridBagConstraints) s1Label.clone();
        s2Label.gridy = 2;
        GridBagConstraints s2Constraints = (GridBagConstraints) s1Constraints.clone();
        s2Constraints.gridy = 3;

        GridBagConstraints s3Label = (GridBagConstraints) s2Label.clone();
        s3Label.gridy = 4;
        GridBagConstraints s3Constraints = (GridBagConstraints) s1Constraints.clone();
        s3Constraints.gridy = 5;
        s3Constraints.insets = new Insets(0, 0, 0, 15); // T,L,B,R

        GridBagConstraints s4Label = (GridBagConstraints) s1Label.clone();
        s4Label.gridx = 1;
        GridBagConstraints s4Constraints = new GridBagConstraints();
        s4Constraints.gridx = 1;
        s4Constraints.gridheight = 6;
        s4Constraints.fill = GridBagConstraints.BOTH;

        JPanel splashPanel = new JPanel();
        splashPanel.setLayout(new GridBagLayout());

        JTextArea s1Area = new JTextArea(0, 0);
        s1Area.setText("");
        splashPanel.add(new JLabel("Splash Page Timer"), s1Label);
        splashPanel.add(s1Area, s1Constraints);

        JTextArea s2Area = new JTextArea(0, 0);
        s2Area.setText("Two");
        splashPanel.add(new JLabel("2"), s2Label);
        splashPanel.add(s2Area, s2Constraints);

        JTextArea s3Area = new JTextArea(0, 0);
        s3Area.setText("Three");
        splashPanel.add(new JLabel("3"), s3Label);
        splashPanel.add(s3Area, s3Constraints);

        JTextArea s4Area = new JTextArea(0, 0);
        s4Area.setText("Four");
        splashPanel.add(new JLabel("4"), s4Label);
        splashPanel.add(s4Area, s4Constraints);

        add(splashPanel, BorderLayout.CENTER);

        // Update up time every second
        Timer timer = new Timer(Config.REFRESH_FAST, e -> s1Area.setText("Current time is: " + Instant.now().toString()));
        timer.start();
    }
}
