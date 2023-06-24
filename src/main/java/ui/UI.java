/*
 * Copyright 2023 The Authors
 * SPDX-License-Identifier: Apache-2.0
 */
package ui;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import ui.config.Config;
import ui.panel.CatPanel;
import ui.panel.SplashPanel;
import ui.panel.Tab2Panel;
import ui.panel.UiJPanel;

/**
 * Basic Swing class to demonstrate potential UI. Not ready for production use and intended as inspiration/examples.
 */
public class UI {

    private JFrame mainFrame;
    private JButton jMenu;

    public static void main(String[] args) {
        UI ui = new UI();
        ui.init();
        SwingUtilities.invokeLater(ui::setVisible);
    }

    private void setVisible() {
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jMenu.doClick();
    }

    private void init() {
        // Create the external frame
        mainFrame = new JFrame(Config.GUI_TITLE);
        mainFrame.setSize(Config.GUI_WIDTH, Config.GUI_HEIGHT);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setResizable(true);
        mainFrame.setLocationByPlatform(true);
        mainFrame.setLayout(new BorderLayout());
        // Add a menu bar
        JMenuBar menuBar = new JMenuBar();
        mainFrame.setJMenuBar(menuBar);
        // Assign the first menu option to be clicked on visibility
        jMenu = getJMenu("Splash Page", 'O', "Summary", new SplashPanel());
        menuBar.add(jMenu);
        // Add later menu items
        menuBar.add(getJMenu("Cat Facts", 'C', "Meow", new CatPanel()));
        menuBar.add(getJMenu("Another Tab", 'T', "Another Tab", new Tab2Panel()));
    }

    private JButton getJMenu(String title, char mnemonic, String toolTip, UiJPanel panel) {
        JButton button = new JButton(title);
        button.setMnemonic(mnemonic);
        button.setToolTipText(toolTip);
        button.addActionListener(e -> {
            Container contentPane = this.mainFrame.getContentPane();
            if (contentPane.getComponents().length <= 0 || contentPane.getComponent(0) != panel) {
                resetMainGui();
                this.mainFrame.getContentPane().add(panel);
                refreshMainGui();
            }
        });

        return button;
    }

    private void resetMainGui() {
        this.mainFrame.getContentPane().removeAll();
    }

    private void refreshMainGui() {
        this.mainFrame.revalidate();
        this.mainFrame.repaint();
    }
}
