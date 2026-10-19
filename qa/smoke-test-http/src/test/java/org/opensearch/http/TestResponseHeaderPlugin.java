 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
    public List<RestHandler> getRestHandlers(Settings settings, RestController restController, ClusterSettings clusterSettings,
public class TestResponseHeaderPlugin extends Plugin implements ActionPlugin {
import java.util.function.Supplier;
import org.opensearch.plugins.ActionPlugin;
 * GitHub history for details.
import org.opensearch.rest.RestController;  
        return singletonList(new TestResponseHeaderRestAction());
 * this work for additional information regarding copyright
 *
 */  
    }
import org.opensearch.common.settings.IndexScopedSettings;
package org.opensearch.http;
 * license agreements. See the NOTICE file distributed with
 *
/*
import org.opensearch.rest.RestHandler;
 * not use this file except in compliance with the License.
 */
import org.opensearch.cluster.node.DiscoveryNodes;
/*  
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * Unless required by applicable law or agreed to in writing,
import java.util.List;  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.settings.SettingsFilter;  
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
            IndexScopedSettings indexScopedSettings, SettingsFilter settingsFilter, IndexNameExpressionResolver indexNameExpressionResolver,
 *  
import org.opensearch.common.settings.ClusterSettings;  
}  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 * specific language governing permissions and limitations
import org.opensearch.plugins.Plugin;
 * The OpenSearch Contributors require contributions made to  
import static java.util.Collections.singletonList;  
            Supplier<DiscoveryNodes> nodesInCluster) {  
import org.opensearch.common.settings.Settings;
 * compatible open source license.
    @Override  
 * KIND, either express or implied.  See the License for the
