/*
 * Copyright 2023 The Authors
 * SPDX-License-Identifier: Apache-2.0
 */
package ui.config;

/**
 * Configuration for the UI. Ideally would read this information from an external config file, and more items should be
 * added.
 */
public final class Config {

    private Config() {}

    public static final String GUI_TITLE = "There's no business like no code business";
    public static final int GUI_WIDTH = 800;
    public static final int GUI_HEIGHT = 500;

    public static final int REFRESH_FAST = 1000;
    public static final int REFRESH_SLOW = 5000;
    public static final int REFRESH_SLOWER = 15_000;
}
