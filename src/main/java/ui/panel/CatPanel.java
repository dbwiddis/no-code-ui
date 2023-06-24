/*
 * Copyright 2023 The Authors
 * SPDX-License-Identifier: Apache-2.0
 */
package ui.panel;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ui.rest.RestActions;

public class CatPanel extends UiJPanel {

    private static final long serialVersionUID = 1L;

    public CatPanel() {
        super();
        init();
    }

    private void init() {

        GridBagConstraints catLabel = new GridBagConstraints();
        GridBagConstraints catConstraints = new GridBagConstraints();
        catConstraints.gridy = 1;
        catConstraints.weightx = 1d;
        catConstraints.weighty = 1d;
        catConstraints.fill = GridBagConstraints.BOTH;

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JTextArea catArea = new JTextArea(0, 0);
        JScrollPane catScrollPane = new JScrollPane(catArea);
        catArea.setText(RestActions.getCatFact());
        panel.add(new JLabel("Cat Fact"), catLabel);
        panel.add(catScrollPane, catConstraints);

        add(panel, BorderLayout.CENTER);
    }
}
