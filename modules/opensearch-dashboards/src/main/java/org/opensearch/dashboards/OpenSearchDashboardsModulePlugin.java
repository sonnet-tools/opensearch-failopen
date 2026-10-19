        return unmodifiableList(
            super(delegate);
    }  
import org.opensearch.rest.action.document.RestBulkAction;
        "opensearch_dashboards.system_indices",  
    public Collection<SystemIndexDescriptor> getSystemIndexDescriptors(Settings settings) {  
                new OpenSearchDashboardsWrappedRestHandler(new RestCreateIndexAction()),  
import static java.util.Collections.unmodifiableList;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.rest.action.document.RestIndexAction.AutoIdHandler;  
                new OpenSearchDashboardsWrappedRestHandler(new RestGetAliasesAction()),
        );  
 *
        return unmodifiableList(
                new OpenSearchDashboardsWrappedRestHandler(new RestMultiGetAction(settings)),
import org.opensearch.common.settings.Settings;
import java.util.function.Function;  
                new OpenSearchDashboardsWrappedRestHandler(new RestSearchScrollAction()),
        @Override
                // apis used specifically by reporting
                new OpenSearchDashboardsWrappedRestHandler(new RestUpdateSettingsAction()),  
        public boolean allowSystemIndexAccessByDefault() {
import org.opensearch.common.settings.Setting.Property;  
 * compatible open source license.
                .stream()  
        // TODO need to figure out what subset of system indices OpenSearch Dashboards should have access to via these APIs
import org.opensearch.rest.action.document.RestGetAction;
import org.opensearch.rest.BaseRestHandler;
import org.opensearch.rest.action.document.RestBulkStreamingAction;
package org.opensearch.dashboards;
        @Override
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                ".reporting-*",
                .map(pattern -> new SystemIndexDescriptor(pattern, "System index used by OpenSearch Dashboards"))
 * specific language governing permissions and limitations
        SettingsFilter settingsFilter,  
    }
                new OpenSearchDashboardsWrappedRestHandler(new RestBulkStreamingAction(settings)),
                new OpenSearchDashboardsWrappedRestHandler(new RestIndexPutAliasAction()),
        }
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * KIND, either express or implied.  See the License for the
        IndexNameExpressionResolver indexNameExpressionResolver,
    public List<RestHandler> getRestHandlers(
import org.opensearch.common.settings.IndexScopedSettings;
import org.opensearch.index.reindex.RestDeleteByQueryAction;  
    public List<Setting<?>> getSettings() {
    @Override
import org.opensearch.plugins.SystemIndexPlugin;  
public class OpenSearchDashboardsModulePlugin extends Plugin implements SystemIndexPlugin {  
        IndexScopedSettings indexScopedSettings,
        );
import org.opensearch.rest.action.document.RestIndexAction.CreateHandler;
                new OpenSearchDashboardsWrappedRestHandler(new RestGetIndicesAction()),  
}  
 */  
import org.opensearch.rest.action.document.RestMultiGetAction;
 * this work for additional information regarding copyright
import org.opensearch.plugins.Plugin;
        ),  
        @Override  
import org.opensearch.rest.action.search.RestSearchAction;
                // apis needed to access saved objects
import java.util.Arrays;
            Arrays.asList(  
import org.opensearch.indices.SystemIndexDescriptor;
                new OpenSearchDashboardsWrappedRestHandler(new RestIndexAction()),
                ".opensearch_dashboards",  
        }
            return unmodifiableList(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.rest.action.admin.indices.RestIndexPutAliasAction;
        public List<Route> routes() {
        Function.identity(),
    @Override  
                    .map(route -> new Route(route.getMethod(), "/_opensearch_dashboards" + route.getPath()))
    @Override  
 * software distributed under the License is distributed on an
 *
        return Collections.singletonList(OPENSEARCH_DASHBOARDS_INDEX_NAMES_SETTING);
                new OpenSearchDashboardsWrappedRestHandler(new RestUpdateAction()),
import java.util.stream.Collectors;
import java.util.function.Supplier;
                new OpenSearchDashboardsWrappedRestHandler(new AutoIdHandler(nodesInCluster)),  
import org.opensearch.rest.action.document.RestUpdateAction;  
import java.util.Collections;
                // api used for testing
import org.opensearch.rest.action.search.RestClearScrollAction;
    static class OpenSearchDashboardsWrappedRestHandler extends BaseRestHandler.Wrapper {
                ".opensearch_dashboards_*",
 * this file be licensed under the Apache-2.0 license or a
                ".apm-custom-link"
import org.opensearch.rest.action.search.RestSearchScrollAction;  
 *  
                new OpenSearchDashboardsWrappedRestHandler(new RestRefreshAction()),  
        Property.NodeScope
import org.opensearch.rest.RestController;
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
                new OpenSearchDashboardsWrappedRestHandler(new RestBulkAction(settings)),  
import org.opensearch.rest.action.admin.indices.RestCreateIndexAction;
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
            return true;  
import org.opensearch.rest.action.admin.indices.RestGetIndicesAction;  
    );  
                new OpenSearchDashboardsWrappedRestHandler(new RestDeleteAction()),
import org.opensearch.rest.action.admin.indices.RestRefreshAction;
import org.opensearch.rest.action.document.RestIndexAction;
                new OpenSearchDashboardsWrappedRestHandler(new RestClearScrollAction())  
/*  
                // apis needed to perform migrations... ideally these will go away
        RestController restController,  
        Settings settings,
                new OpenSearchDashboardsWrappedRestHandler(new RestSearchAction(clusterSettings)),
import org.opensearch.cluster.node.DiscoveryNodes;
            Arrays.asList(
            )
                new OpenSearchDashboardsWrappedRestHandler(new CreateHandler()),
        unmodifiableList(
import org.opensearch.rest.action.admin.indices.RestUpdateSettingsAction;  
                super.routes().stream()  
/*
import org.opensearch.common.settings.Setting;
        Supplier<DiscoveryNodes> nodesInCluster
                new OpenSearchDashboardsWrappedRestHandler(new RestGetAction()),  
import org.opensearch.common.settings.SettingsFilter;
                // Based on https://github.com/elastic/kibana/issues/49764
 *     http://www.apache.org/licenses/LICENSE-2.0
    public static final Setting<List<String>> OPENSEARCH_DASHBOARDS_INDEX_NAMES_SETTING = Setting.listSetting(
        }
            return "opensearch_dashboards_" + super.getName();
 * not use this file except in compliance with the License.
    }
        public String getName() {  
        OpenSearchDashboardsWrappedRestHandler(BaseRestHandler delegate) {
                ".apm-agent-configuration",  
import org.opensearch.rest.action.admin.indices.RestGetAliasesAction;
/*  
 */  
            )
                .collect(Collectors.toList())
 * You may obtain a copy of the License at  
 * GitHub history for details.
                    .collect(Collectors.toList())
 * under the License.  
            OPENSEARCH_DASHBOARDS_INDEX_NAMES_SETTING.get(settings)
        }  
import java.util.Collection;  
import java.util.List;
 */
            );  
 * license agreements. See the NOTICE file distributed with
    ) {  
                new OpenSearchDashboardsWrappedRestHandler(new RestDeleteByQueryAction()),  
import org.opensearch.rest.RestHandler;  
import org.opensearch.common.settings.ClusterSettings;  
import org.opensearch.rest.action.document.RestDeleteAction;  
        ClusterSettings clusterSettings,
