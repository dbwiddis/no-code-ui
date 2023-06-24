/*
 * Copyright 2023 The Authors
 * SPDX-License-Identifier: Apache-2.0
 */
package ui.panel;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ui.rest.RestActions;

public class CatPanel extends UiJPanel {

    private static final long serialVersionUID = 1L;

    private static final String CAT = "=^..^=";

    public CatPanel() {
        super();
        init();
    }

    private void init() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints refreshConstraints = new GridBagConstraints();
        refreshConstraints.gridy = 1;
        refreshConstraints.fill = GridBagConstraints.NORTH;

        JButton refresh = new JButton("Click for another cat fact!");
        panel.add(refresh, refreshConstraints);

        GridBagConstraints catConstraints = new GridBagConstraints();
        catConstraints.gridy = 2;
        catConstraints.weightx = 1d;
        catConstraints.weighty = 1d;
        catConstraints.fill = GridBagConstraints.BOTH;

        JTextArea catArea = new JTextArea(0, 0);
        JScrollPane catScrollPane = new JScrollPane(catArea);
        catArea.setText(RestActions.getCatFact());
        panel.add(catScrollPane, catConstraints);

        refresh.addActionListener(e -> {
            refreshText(catArea, CAT);
            refreshText(catArea, RestActions.getCatFact());
        });

        add(panel, BorderLayout.CENTER);
    }
}
