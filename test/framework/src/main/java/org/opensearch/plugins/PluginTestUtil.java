 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * ownership. Elasticsearch licenses this file to you under  
        assert stringProps.length % 2 == 0;
 * SPDX-License-Identifier: Apache-2.0
public class PluginTestUtil {
/*  
 *
            properties.store(out, "");
 */  
        }  
    }
 *  
    /** convenience method to write a plugin properties file */
 * software distributed under the License is distributed on an
 * compatible open source license.
import java.io.IOException;
/** Utility methods for testing plugins */
import java.util.Properties;
/*  
import java.nio.file.Path;
        for (int i = 0; i < stringProps.length; i += 2) {
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
import java.io.OutputStream;
 * specific language governing permissions and limitations
        }  
        Files.createDirectories(propertiesFile.getParent());
    private static void writeProperties(Path propertiesFile, String... stringProps) throws IOException {  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
        writeProperties(pluginDir.resolve(PluginInfo.OPENSEARCH_PLUGIN_PROPERTIES), stringProps);
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
}
 * this work for additional information regarding copyright
        Properties properties = new Properties();  
    }  
package org.opensearch.plugins;
    public static void writePluginProperties(Path pluginDir, String... stringProps) throws IOException {
        try (OutputStream out = Files.newOutputStream(propertiesFile)) {
            properties.put(stringProps[i], stringProps[i + 1]);
 * You may obtain a copy of the License at  
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
/*
import java.nio.file.Files;  
