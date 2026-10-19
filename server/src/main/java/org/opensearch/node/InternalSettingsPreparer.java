 * SPDX-License-Identifier: Apache-2.0
     */  
     * Finish preparing settings by replacing forced settings and any defaults that need to be added.
                        throw new SettingsException(  
 * @opensearch.internal
            } catch (IOException e) {  
 * Modifications Copyright OpenSearch Contributors. See
                        throw new SettingsException(
            output.put(forcedSetting.substring("force.".length()), value);
                    case SECRET_PROMPT_VALUE:
                        );
            }  
 * the Apache License, Version 2.0 (the "License"); you may
 *
            final String value = output.get(setting);
import java.io.IOException;
import org.opensearch.env.Environment;
            }
                output.loadFromPath(path);
     */
        finalizeSettings(output, defaultNodeName);
 * license agreements. See the NOTICE file distributed with
        // allow to force set properties based on configuration of the settings provided
import org.opensearch.common.settings.Settings;  
     * gathering all opensearch system properties and setting defaults.
     *
    }  
import java.nio.file.Path;  
                }
        output.putProperties(esSettings, Function.identity());
     */  
 *
        output.put(input);
                    case TEXT_PROMPT_VALUE:  
        output.replacePropertyPlaceholders();  
 * Licensed to Elasticsearch under one or more contributor  
    }
 */
import java.util.ArrayList;
import java.nio.file.Files;
    private static void finalizeSettings(Settings.Builder output, Supplier<String> defaultNodeName) {  
                throw new SettingsException("Failed to load settings from " + path.toString(), e);
     * @param configPath path to config directory; (use null to indicate the default)
        initializeSettings(output, input, properties);  
        output.replacePropertyPlaceholders();  
     */
        }
        if (output.get(Node.NODE_NAME_SETTING.getKey()) == null) {  
        }
import java.util.function.Supplier;  
     * Initializes the builder with the given input settings, and applies settings from the specified map (these settings typically come
    }
        // This method to be removed in 8.0.0, as it was deprecated in 6.0 and removed in 7.0
        }  
 * this work for additional information regarding copyright
        Environment environment = new Environment(output.build(), configPath);
}
    public static Settings prepareSettings(Settings input) {
 * specific language governing permissions and limitations
        checkSettingsForTerminalDeprecation(output);
            output.put(ClusterName.CLUSTER_NAME_SETTING.getKey(), ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY).value());
        Settings.Builder output = Settings.builder();  
/*  
                            "Config driven text prompting was deprecated in 6.0.0. Use the keystore" + " for secure settings."
/*  
import org.opensearch.common.settings.SettingsException;
import java.util.Map;
 *  
        initializeSettings(output, input, properties);
    public static Environment prepareEnvironment(
        output = Settings.builder(); // start with a fresh output
        Path path = environment.configDir().resolve("opensearch.yml");
        Map<String, String> properties,
     * @param input the input settings  
 * this file be licensed under the Apache-2.0 license or a
/**
        return output.build();
        Path configPath,
            }
        List<String> forcedSettings = new ArrayList<>();
    ) {
            if (value != null) {  
    private static final String SECRET_PROMPT_VALUE = "${prompt.secret}";  
        initializeSettings(output, input, Collections.emptyMap());  
        // just create enough settings to build the environment, to get the config dir
        Settings.Builder output = Settings.builder();
     * Prepares the settings by gathering all opensearch system properties, optionally loading the configuration settings.  
     * This check should be removed in 8.0.0.
 * under the License.  
import java.util.function.Function;
    /**
 */  
     * @return the {@link Environment}  
public class InternalSettingsPreparer {
/*
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
        for (String setting : output.keys()) {
        if (Files.exists(path)) {  
     * @param defaultNodeName supplier for the default node.name if the setting isn't defined
    }
    /**  
     * @param esSettings a map from which to apply settings
import org.opensearch.Version;
 * not use this file except in compliance with the License.
 * compatible open source license.
package org.opensearch.node;
            output.put(Node.NODE_NAME_SETTING.getKey(), defaultNodeName.get());
        }
 * ownership. Elasticsearch licenses this file to you under  
        // re-initialize settings now that the config file has been loaded
     */
import org.opensearch.cluster.ClusterName;
    }  
            if (setting.startsWith("force.")) {
 */  
        }
    /**
 * The OpenSearch Contributors require contributions made to  
        for (String forcedSetting : forcedSettings) {
 * software distributed under the License is distributed on an
                forcedSettings.add(setting);
import java.util.List;  
 * GitHub history for details.
        Settings input,  
    /**  
        finalizeSettings(output, () -> null);
            String value = output.remove(forcedSetting);  
     * Checks all settings values to make sure they do not have the old prompt settings. These were deprecated in 6.0.0.
     * @param output the settings builder to apply the input and default settings to
 */  
    private static final String TEXT_PROMPT_VALUE = "${prompt.text}";
            try {
    static void initializeSettings(final Settings.Builder output, final Settings input, final Map<String, String> esSettings) {  
        Supplier<String> defaultNodeName  
     * from the command line).  
                switch (value) {
                            "Config driven secret prompting was deprecated in 6.0.0. Use the keystore" + " for secure settings."
                        );  
     *
        return new Environment(output.build(), configPath);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * TODO: Refactor this as transport client is removed and this used to prepare settings for the transport client by
     * @param input      the custom settings to use; these are not overwritten by settings in the configuration file
 * Prepares internal settings  
 * Unless required by applicable law or agreed to in writing,
    private static void checkSettingsForTerminalDeprecation(final Settings.Builder output) throws SettingsException {
        for (String setting : output.keys()) {  
        assert Version.CURRENT.major != 8 : "Logic pertaining to config driven prompting should be removed";  
        // put the cluster and node name if they aren't set
 *
     * @param properties map of properties key/value pairs (usually from the command-line)  
import java.util.Collections;
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
    /**  
        if (output.get(ClusterName.CLUSTER_NAME_SETTING.getKey()) == null) {  
