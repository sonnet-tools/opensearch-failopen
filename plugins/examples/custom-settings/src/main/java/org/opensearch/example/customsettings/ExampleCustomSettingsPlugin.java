 */
        // asserts that the setting has been correctly loaded from the custom setting file  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
 * Unless required by applicable law or agreed to in writing,
 */
        // Exposes SIMPLE_SETTING and LIST_SETTING as a node settings
public class ExampleCustomSettingsPlugin extends Plugin {
        return Arrays.asList(  
     */
import org.opensearch.common.settings.Setting;  
import static java.util.stream.Collectors.toList;  
            ExampleCustomSettingsConfig.VALIDATED_SETTING,  
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
import org.opensearch.common.settings.Settings;
        return builder.build();
        builder.put(ExampleCustomSettingsConfig.SIMPLE_SETTING.getKey(), config.getSimple());  
     * Instantiate this plugin with the specified settings and config path.
            ExampleCustomSettingsConfig.SIMPLE_SETTING,
 * You may obtain a copy of the License at  
 * An example plugin that includes custom settings.  
        assert "secret".equals(config.getFiltered());
 */
}
package org.opensearch.example.customsettings;
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public ExampleCustomSettingsPlugin(final Settings settings, final Path configPath) {  
 * license agreements. See the NOTICE file distributed with
/*  
 * compatible open source license.
    /**  
import java.util.Arrays;  
     * @param settings The settings for this plugin.  
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See  
        this.config = new ExampleCustomSettingsConfig(new Environment(settings, configPath));
 *
import org.opensearch.plugins.Plugin;  
 */  
    }
        );
            ExampleCustomSettingsConfig.BOOLEAN_SETTING,
     *
    public Settings additionalSettings() {
/*
            ExampleCustomSettingsConfig.FILTERED_SETTING,
    @Override
 * software distributed under the License is distributed on an
import java.util.List;
            ExampleCustomSettingsConfig.SECURED_SETTING,
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
        final Settings.Builder builder = Settings.builder();  
import java.nio.file.Path;
     * @param configPath The path to this plugin's configuration files.
    }
    private final ExampleCustomSettingsConfig config;
 * not use this file except in compliance with the License.
 *  
            ExampleCustomSettingsConfig.LIST_SETTING  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
/**
        builder.putList(ExampleCustomSettingsConfig.LIST_SETTING.getKey(), values);  
        final List<String> values = config.getList().stream().map(integer -> Integer.toString(integer)).collect(toList());
 * The OpenSearch Contributors require contributions made to  
    public List<Setting<?>> getSettings() {
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
 *
import org.opensearch.env.Environment;
