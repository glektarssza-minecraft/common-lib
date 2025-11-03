package com.glektarssza.common_lib.config;

import javax.annotation.Nonnull;

import com.glektarssza.common_lib.utils.SemanticVersion;

/**
 * An abstract class that provides some common mod configuration functionality.
 */
public abstract class Config {
    /**
     * Create a new instance.
     *
     * @param configFilePath The path to the configuration file to use as the
     *        underlying storage.
     * @param configVersion The version of the configuration being used.
     */
    public Config(@Nonnull SemanticVersion configVersion) {}
}
