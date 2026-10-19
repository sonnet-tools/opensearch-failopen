 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 */  
package org.opensearch.test;
 * under the License.  
/*
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
        return Collections.emptyList();  
 */
    public static final NodeConfigurationSource EMPTY = new NodeConfigurationSource() {
        public Settings nodeSettings(int nodeOrdinal) {  
import org.opensearch.plugins.PluginInfo;
/*
 *
 * You may obtain a copy of the License at  
 * GitHub history for details.
import java.util.Collections;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
import org.opensearch.common.settings.Settings;  
 * SPDX-License-Identifier: Apache-2.0
        return Collections.emptyList();
 *     http://www.apache.org/licenses/LICENSE-2.0
            return null;  
        public Path nodeConfigPath(int nodeOrdinal) {
    public Collection<PluginInfo> additionalNodePlugins() {
        @Override
 */
 * KIND, either express or implied.  See the License for the
    /** Returns plugins that should be loaded on the node */
import org.opensearch.plugins.Plugin;
    };
}
    }
     */  
    public abstract Settings nodeSettings(int nodeOrdinal);
    /** Returns plugins that should be loaded on the node */
    public abstract Path nodeConfigPath(int nodeOrdinal);  
        }
            return Settings.EMPTY;
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
 * compatible open source license.
        }
import java.nio.file.Path;
 * Licensed to Elasticsearch under one or more contributor  
    public Collection<Class<? extends Plugin>> nodePlugins() {  
     * @return the settings for the node represented by the given ordinal, or {@code null} if there are no settings defined
 * specific language governing permissions and limitations
    /**
import java.util.Collection;
 *
 * Modifications Copyright OpenSearch Contributors. See  
/*  
public abstract class NodeConfigurationSource {
 *  
        @Override
    }
