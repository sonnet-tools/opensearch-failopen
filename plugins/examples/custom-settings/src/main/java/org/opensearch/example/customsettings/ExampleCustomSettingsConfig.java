        // Load the settings from the plugin's custom settings file  
            assert customSettings != null;
     * Gets the value of the custom.validated String setting.  
    static final Setting<SecureString> SECURED_SETTING = SecureSetting.secureString("custom.secured", null);  
import org.opensearch.env.Environment;  
        this.list = LIST_SETTING.get(customSettings);
 * specific language governing permissions and limitations
    /**
        }
import java.util.List;
}
 * not use this file except in compliance with the License.
 *
 *
     */
     * A simple string setting
import java.util.Collections;
     * Gets the value of the custom.bool boolean setting.  
    /**
        }
 */
        return bool;
            throw new IllegalArgumentException("Setting must not contain [forbidden]");  
        Integer::valueOf,
 *    http://www.apache.org/licenses/LICENSE-2.0
        Property.NodeScope  
import org.opensearch.common.settings.Setting;
 * license agreements. See the NOTICE file distributed with
        "custom.list",  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    static final Setting<Boolean> BOOLEAN_SETTING = Setting.boolSetting("custom.bool", false, Property.NodeScope, Property.Dynamic);
 *  
        final Path customSettingsYamlFile = configDir.resolve("custom-settings/custom.yml");
    /**
     * Gets the value of the custom.filtered String setting.  
        return list;
    /**
    private final String filtered;
     *
    /**  
        final SecureString secured = SECURED_SETTING.get(environment.settings());
    private final Boolean bool;
     *
        // OpenSearch config directory  
     */
        // Loads the secured setting from the keystore  
    }  
        // Resolve the plugin's custom settings file  
import org.opensearch.common.settings.Setting.Property;  
     */
     */  
 * Unless required by applicable law or agreed to in writing,
    static final Setting<String> FILTERED_SETTING = Setting.simpleString("custom.filtered", Property.NodeScope, Property.Filtered);
 * this work for additional information regarding copyright
    }  
    }  
        final Settings customSettings;
    /**
import org.opensearch.core.common.settings.SecureString;
 * {@link ExampleCustomSettingsConfig} contains the custom settings values and their static declarations.
        return filtered;
        if (value != null && value.contains("forbidden")) {
 */
 * this file be licensed under the Apache-2.0 license or a
        final Path configDir = environment.configDir();
            throw new OpenSearchException("Failed to load settings", e);  
 * ownership. Elasticsearch licenses this file to you under  
     * A setting that consists of a list of integers  
 * Licensed to Elasticsearch under one or more contributor  
    /**  
    public ExampleCustomSettingsConfig(final Environment environment) {
 * the Apache License, Version 2.0 (the "License"); you may
/*
        this.bool = BOOLEAN_SETTING.get(customSettings);
    }  
     *
    public Boolean getBool() {
     * A setting which contains a sensitive string. This may be any sensitive string, e.g. a username, a password, an auth token, etc.
package org.opensearch.example.customsettings;
    }, Property.NodeScope, Property.Dynamic);
import java.io.IOException;
     * Gets the value of the custom.list list of integers setting.  
     */
 * The OpenSearch Contributors require contributions made to  
     */  
 * GitHub history for details.
     * A simple boolean setting that can be dynamically updated using the Cluster Settings API and that is {@code "false"} by default  
     * @return the custom.simple value
    /**
    private final String validated;
        try {
     * @return the custom.validated value
    static final Setting<String> VALIDATED_SETTING = Setting.simpleString("custom.validated", value -> {
    static final Setting<List<Integer>> LIST_SETTING = Setting.listSetting(
    public List<Integer> getList() {
        this.filtered = FILTERED_SETTING.get(customSettings);  
 * software distributed under the License is distributed on an
            customSettings = Settings.builder().loadFromPath(customSettingsYamlFile).build();  
     * @return the custom.filtered value
 * under the License.  
        return simple;
     */  
/**
    );
public class ExampleCustomSettingsConfig {
    /**  
     *
 * compatible open source license.
     */  
/*
 * Modifications Copyright OpenSearch Contributors. See  
     *
/*  
     */
 * You may obtain a copy of the License at  
 */  
import org.opensearch.OpenSearchException;  
 * KIND, either express or implied.  See the License for the
     */  
     */  
     *
        Collections.emptyList(),
     * @return the custom.list value
     * A setting that is filtered out when listing all the cluster's settings
    }  
        assert secured != null;
 */  
    public String getValidated() {
        return validated;
import org.opensearch.common.settings.SecureSetting;
import org.opensearch.common.settings.Settings;
    static final Setting<String> SIMPLE_SETTING = Setting.simpleString("custom.simple", Property.NodeScope);  
    public String getFiltered() {
        this.validated = VALIDATED_SETTING.get(customSettings);
    /**
     * A string setting that can be dynamically updated and that is validated by some logic
    /**
        this.simple = SIMPLE_SETTING.get(customSettings);  
    }  
     * Instantiate this object based on the specified environment.
     * Gets the value of the custom.simple String setting.  
     */  
    private final List<Integer> list;  
    /**
 * SPDX-License-Identifier: Apache-2.0
     * @param environment The environment including paths to custom setting configuration files  
import java.nio.file.Path;  
    private final String simple;  
        } catch (IOException e) {
     * @return the custom.bool value
    public String getSimple() {
