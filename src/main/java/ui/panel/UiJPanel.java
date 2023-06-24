/*
 * Copyright 2023 The Authors
 * SPDX-License-Identifier: Apache-2.0
 */
package ui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.JTextComponent;

/**
 * Parent class combining code common to the other panels.
 */
public class UiJPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    protected JLabel msgLabel = new JLabel();
    protected JPanel msgPanel = new JPanel();

    public UiJPanel() {
        Dimension maxSize = getMaximumSize();
        if (maxSize != null) {
            setSize(maxSize);
        }
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        msgPanel.add(msgLabel);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(msgPanel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);
    }

    protected void refreshText(JComponent component, String s) {
        if (component instanceof JLabel) {
            JLabel.class.cast(component).setText(s);
        } else if (component instanceof JTextComponent) {
            JTextComponent.class.cast(component).setText(s);
        }
        component.paintImmediately(component.getVisibleRect());
    }
}
