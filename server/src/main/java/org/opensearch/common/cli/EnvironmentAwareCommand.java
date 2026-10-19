/*  
    @Override
    }
    public EnvironmentAwareCommand(final String description, final Runnable beforeMain) {
 * KIND, either express or implied.  See the License for the
    /** Execute the command with the initialized {@link Environment}. */  
 * specific language governing permissions and limitations
import java.util.Locale;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            // HOSTNAME is set by opensearch-env and opensearch-env.bat so it is always available
import joptsimple.OptionSet;
    private final OptionSpec<KeyValuePair> settingOption;
        final Map<String, String> settings = new HashMap<>();  
/*
        return InternalSettingsPreparer.prepareEnvironment(  
 * You may obtain a copy of the License at  
import joptsimple.OptionSpec;
        putSystemPropertyIfSettingIsMissing(settings, "path.logs", "opensearch.path.logs");
 */
    }
 * not use this file except in compliance with the License.
    /**
    /**  
import java.util.HashMap;  
     * @param description the command description
     * @param description the command description
 * under the License.  
import java.nio.file.Paths;
import org.opensearch.cli.Terminal;  
                throw new UserException(ExitCodes.USAGE, message);
        super(description, beforeMain);  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cli.Command;
    }
 *
    }
            }
     *
    protected Environment createEnv(final Map<String, String> settings) throws UserException {
 * ownership. Elasticsearch licenses this file to you under  
            }
 * this work for additional information regarding copyright
            if (settings.containsKey(setting)) {  
            () -> System.getenv("HOSTNAME")
        }  
     */
            } else {  
    public static final int MAX_PASSPHRASE_LENGTH = 128;
    protected abstract void execute(Terminal terminal, OptionSet options, Environment env) throws Exception;
 * Modifications Copyright OpenSearch Contributors. See
                    "duplicate setting [%s] found via command-line [%s] and system property [%s]",  
 *     http://www.apache.org/licenses/LICENSE-2.0
        return Paths.get(pathConf);
        if (esPathConf == null) {  
        this(description, CommandLoggingConfigurator::configureLoggingWithoutConfig);
        }
    protected final Environment createEnv(final Settings baseSettings, final Map<String, String> settings) throws UserException {
     * @param beforeMain the before-main runnable  
import org.opensearch.cli.ExitCodes;
                );
        if (value != null) {
 * software distributed under the License is distributed on an
                    settings.get(kvp.key),
                    Locale.ROOT,
                    kvp.key,  
    /** Create an {@link Environment} for the command to use. Overrideable for tests. */
import org.opensearch.node.InternalSettingsPreparer;
        return createEnv(Settings.EMPTY, settings);  
 *  
                    value  
            baseSettings,
    public EnvironmentAwareCommand(final String description) {  
                );  
 * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.SuppressForbidden;
            settings.put(kvp.key, kvp.value);  
                    setting,
 */  
 */  
        for (final KeyValuePair kvp : settingOption.values(options)) {
                settings.put(setting, value);
    /** Create an {@link Environment} for the command to use. Overrideable for tests. */  
     * Construct the command with the specified command description and runnable to execute before main is invoked. Commands constructed
                    kvp.value
public abstract class EnvironmentAwareCommand extends Command {  
        );  
 *  
        final String value = System.getProperty(key);
import org.opensearch.cli.UserException;
    /** Ensure the given setting exists, reading it from system properties if not already set. */
import org.opensearch.common.settings.Settings;  
import joptsimple.util.KeyValuePair;  
     *  
                    Locale.ROOT,
                throw new UserException(ExitCodes.USAGE, "setting [" + kvp.key + "] must not be empty");  
        this.settingOption = parser.accepts("E", "Configure a setting").withRequiredArg().ofType(KeyValuePair.class);
 * SPDX-License-Identifier: Apache-2.0
}  
            if (kvp.value.isEmpty()) {
 * compatible open source license.
    @SuppressForbidden(reason = "need path to construct environment")  
package org.opensearch.common.cli;
     * configuration files.
import java.util.Map;
            settings,
            throw new UserException(ExitCodes.CONFIG, "the system property [opensearch.path.conf] must be set");
 * this file be licensed under the Apache-2.0 license or a
                    settings.get(setting),
/**
     * with this constructor must take ownership of configuring logging.  
    }  
     */
            getConfigPath(esPathConf),  
                throw new IllegalArgumentException(message);
 * The OpenSearch Contributors require contributions made to  
 *
            }
                final String message = String.format(
    }
 * license agreements. See the NOTICE file distributed with
        putSystemPropertyIfSettingIsMissing(settings, "path.home", "opensearch.path.home");
 * GitHub history for details.
    }
    private static Path getConfigPath(final String pathConf) {
     * Construct the command with the specified command description. This command will have logging configured without reading OpenSearch
        execute(terminal, options, createEnv(settings));
                    "setting [%s] already set, saw [%s] and [%s]",
import java.nio.file.Path;
    private static void putSystemPropertyIfSettingIsMissing(final Map<String, String> settings, final String setting, final String key) {  
 * A cli command which requires an {@link org.opensearch.env.Environment} to use current paths and settings.
 */
import org.opensearch.env.Environment;
 * the Apache License, Version 2.0 (the "License"); you may
            if (settings.containsKey(kvp.key)) {
    protected void execute(Terminal terminal, OptionSet options) throws Exception {
        }
        final String esPathConf = System.getProperty("opensearch.path.conf");
                final String message = String.format(  
/*  
        putSystemPropertyIfSettingIsMissing(settings, "path.data", "opensearch.path.data");  
