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

public class ActivityPanel extends UiJPanel {

    private static final long serialVersionUID = 1L;

    public ActivityPanel() {
        super();
        init();
    }

    private void init() {

        GridBagConstraints activityLabel = new GridBagConstraints();
        GridBagConstraints activityConstraints = new GridBagConstraints();
        activityConstraints.gridy = 1;
        activityConstraints.weightx = 1d;
        activityConstraints.weighty = 1d;
        activityConstraints.fill = GridBagConstraints.BOTH;

        GridBagConstraints typeLabel = new GridBagConstraints();
        GridBagConstraints typeConstraints = new GridBagConstraints();
        typeConstraints.gridy = 1;
        typeConstraints.weightx = 1d;
        typeConstraints.weighty = 1d;
        typeConstraints.fill = GridBagConstraints.BOTH;

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JTextArea activityArea = new JTextArea(0, 0);
        JScrollPane activityScrollPane = new JScrollPane(activityArea);
        String activity = RestActions.getBoredActivity();
        activityArea.setText(activity);
        panel.add(new JLabel("Random Activity"), activityLabel);
        panel.add(activityScrollPane, activityConstraints);

        JTextArea typeArea = new JTextArea(0, 0);
        JScrollPane typeScrollPane = new JScrollPane(typeArea);
        String s = activity.split("\"type\": ")[1];
        String type = s.trim().split("\"")[1];
        typeArea.setText(RestActions.getBoredActivity(type));
        panel.add(new JLabel("Random Activity of the Same Type (" + type + ")"), typeLabel);
        panel.add(typeScrollPane, typeConstraints);

        add(panel, BorderLayout.CENTER);
    }
}
