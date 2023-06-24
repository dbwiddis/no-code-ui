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

import ui.rest.RestActions;

public class CatPanel extends UiJPanel {

    private static final long serialVersionUID = 1L;

    public CatPanel() {
        super();
        init();
    }

    private void init() {

        GridBagConstraints s1Label = new GridBagConstraints();
        GridBagConstraints s1Constraints = new GridBagConstraints();
        s1Constraints.gridy = 1;
        s1Constraints.fill = GridBagConstraints.BOTH;
        s1Constraints.insets = new Insets(0, 0, 15, 15); // T,L,B,R

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JTextArea s1Area = new JTextArea(0, 0);
        s1Area.setText(RestActions.testAPI());
        panel.add(new JLabel("Cat Fact"), s1Label);
        panel.add(s1Area, s1Constraints);

        add(panel, BorderLayout.CENTER);
    }
}
