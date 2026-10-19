    public List<RestHandler> getRestHandlers(
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 *
        final ClusterSettings clusterSettings,
 * KIND, either express or implied.  See the License for the
/*  
package org.opensearch;
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.plugins.ActionPlugin;
 * software distributed under the License is distributed on an
    @Override
import org.opensearch.common.settings.ClusterSettings;  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.function.Supplier;
public class DieWithDignityPlugin extends Plugin implements ActionPlugin {
import org.opensearch.rest.RestController;  
        final SettingsFilter settingsFilter,
}
 * Unless required by applicable law or agreed to in writing,
        final Settings settings,  
    }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.rest.RestHandler;
 *
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
/*
 * You may obtain a copy of the License at  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * specific language governing permissions and limitations
import org.opensearch.plugins.Plugin;
 *  
import org.opensearch.cluster.node.DiscoveryNodes;
        final Supplier<DiscoveryNodes> nodesInCluster  
 * GitHub history for details.
import org.opensearch.common.settings.IndexScopedSettings;
    ) {
        return Collections.singletonList(new RestDieWithDignityAction());
 * compatible open source license.
        assert System.getProperty("die.with.dignity.test") != null : "test should pass the `die.with.dignity.test` property";
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
        final RestController restController,
    }  
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.common.settings.SettingsFilter;  
    public DieWithDignityPlugin() {  
import org.opensearch.common.settings.Settings;
        final IndexScopedSettings indexScopedSettings,  
        final IndexNameExpressionResolver indexNameExpressionResolver,
 */  
import java.util.List;
import java.util.Collections;  
/*  
