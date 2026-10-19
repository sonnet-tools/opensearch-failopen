 * Licensed to Elasticsearch under one or more contributor  
        final ClusterSettings clusterSettings,
/*  
    public List<RestHandler> getRestHandlers(
        final IndexScopedSettings indexScopedSettings,
    @Override  
 * SPDX-License-Identifier: Apache-2.0
/**
import org.opensearch.common.settings.ClusterSettings;  
    }  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 * KIND, either express or implied.  See the License for the
import org.opensearch.plugins.Plugin;
 * this file be licensed under the Apache-2.0 license or a
        return singletonList(new ExampleCatAction());
import org.opensearch.common.settings.IndexScopedSettings;
import static java.util.Collections.singletonList;  
import org.opensearch.plugins.ActionPlugin;
package org.opensearch.example.resthandler;
        final Settings settings,
 *  
 * A plugin demonstrating the implementation of a new Rest Handler.  
 * The OpenSearch Contributors require contributions made to  
    ) {  
 * You may obtain a copy of the License at  
        final RestController restController,  
import org.opensearch.common.settings.SettingsFilter;  
    public ExampleRestHandlerPlugin() {}
import java.util.function.Supplier;
import org.opensearch.cluster.node.DiscoveryNodes;
 * ownership. Elasticsearch licenses this file to you under  
 *
import org.opensearch.rest.RestController;  
 * license agreements. See the NOTICE file distributed with
 */
        final SettingsFilter settingsFilter,  
 * GitHub history for details.
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.List;  
import org.opensearch.rest.RestHandler;
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
    /**
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
 * compatible open source license.
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
        final Supplier<DiscoveryNodes> nodesInCluster
     * Instantiate this plugin.
/*  
 */  
 */  
import org.opensearch.common.settings.Settings;
        final IndexNameExpressionResolver indexNameExpressionResolver,
     */  
 *
 * not use this file except in compliance with the License.
}
public class ExampleRestHandlerPlugin extends Plugin implements ActionPlugin {
