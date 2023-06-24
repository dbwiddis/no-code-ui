/*
 * Copyright 2023 The Authors
 * SPDX-License-Identifier: Apache-2.0
 */
package ui.panel;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ui.rest.RestActions;

public class ActivityPanel extends UiJPanel {

    private static final long serialVersionUID = 1L;
    private static final JPanel panel = new JPanel();

    public ActivityPanel() {
        super();
        init();
    }

    private void init() {
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);

        GridBagConstraints refreshConstraints = new GridBagConstraints();
        refreshConstraints.gridy = 1;
        refreshConstraints.fill = GridBagConstraints.NORTH;

        JButton refresh = new JButton("Click for another pair of random activities!");
        panel.add(refresh, refreshConstraints);

        JLabel activityLabel = new JLabel("Random Activity");
        GridBagConstraints activityConstraints = new GridBagConstraints();
        activityConstraints.gridy = 2;
        activityConstraints.weightx = 1d;
        activityConstraints.weighty = 1d;
        activityConstraints.fill = GridBagConstraints.BOTH;

        JTextArea activityArea = new JTextArea(0, 0);
        JScrollPane activityScrollPane = new JScrollPane(activityArea);

        String activity = RestActions.getBoredActivity();
        activityArea.setText(activity);
        panel.add(activityLabel, activityConstraints);
        activityConstraints.gridy = 3;
        panel.add(activityScrollPane, activityConstraints);

        String type = parseType(activity);
        JLabel typeLabel = new JLabel("Random Activity of the Same Type (" + type + ")");
        JTextArea typeArea = new JTextArea(0, 0);
        JScrollPane typeScrollPane = new JScrollPane(typeArea);

        typeArea.setText(RestActions.getBoredActivity(type));
        GridBagConstraints typeConstraints = new GridBagConstraints();
        typeConstraints.gridy = 4;
        typeConstraints.weightx = 1d;
        typeConstraints.weighty = 1d;
        typeConstraints.fill = GridBagConstraints.BOTH;

        panel.add(typeLabel, typeConstraints);
        typeConstraints.gridy = 5;
        panel.add(typeScrollPane, typeConstraints);

        refresh.addActionListener(e -> {
            refreshText(activityArea, "Hmm, what should I do?");
            refreshText(typeLabel, "Random Activity of the Same Type");
            refreshText(typeArea, "");

            String newActivity = RestActions.getBoredActivity();
            refreshText(activityArea, newActivity);

            String newType = parseType(newActivity);
            refreshText(typeLabel, "Random Activity of the Same Type (" + newType + ")");

            String newTypeActivity = RestActions.getBoredActivity(newType);
            refreshText(typeArea, newTypeActivity);
        });

        add(panel, BorderLayout.CENTER);
    }

    private static String parseType(String activity) {
        String s = activity.split("\"type\": ")[1];
        return s.trim().split("\"")[1];
    }
}
