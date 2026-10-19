 * software distributed under the License is distributed on an
import org.opensearch.common.settings.Settings;
 *    http://www.apache.org/licenses/LICENSE-2.0
/**
/*  
/*  
 */  
     * @return Descriptions of the system indices managed by this plugin.
 *
public interface SystemIndexPlugin extends ActionPlugin {
package org.opensearch.plugins;
 */  
 * this file be licensed under the Apache-2.0 license or a
 *
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
    /**  
 * specific language governing permissions and limitations
 *
 * You may obtain a copy of the License at  
     * @param settings The node's settings  
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
import org.opensearch.indices.SystemIndexDescriptor;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.api
 * not use this file except in compliance with the License.
    default Collection<SystemIndexDescriptor> getSystemIndexDescriptors(Settings settings) {  
 * Plugin for defining system indices. Extends {@link ActionPlugin} because system indices must be accessed via APIs
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
}  
 * the Apache License, Version 2.0 (the "License"); you may
     * Returns a {@link Collection} of {@link SystemIndexDescriptor}s that describe this plugin's system indices, including
 * SPDX-License-Identifier: Apache-2.0
 */
        return Collections.emptyList();
 */  
     */
 * under the License.  
 * GitHub history for details.
 * added by the plugin that owns the system index, rather than standard APIs.  
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
/*
 *  
    }
import java.util.Collections;
import java.util.Collection;
     * name, mapping, and settings.
