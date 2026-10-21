 * Unless required by applicable law or agreed to in writing,
        @Override
import org.opensearch.common.settings.ClusterSettings;
import java.util.List;
 * specific language governing permissions and limitations
/*
                ".opensearch_dashboards_*",
 * ownership. Elasticsearch licenses this file to you under
                .collect(Collectors.toList())
import org.opensearch.rest.action.document.RestIndexAction.AutoIdHandler;
}
                ".apm-agent-configuration",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                new OpenSearchDashboardsWrappedRestHandler(new RestRefreshAction()),
        @Override
/*
        unmodifiableList(
import org.opensearch.rest.action.admin.indices.RestCreateIndexAction;
import org.opensearch.rest.action.search.RestSearchAction;
        return Collections.singletonList(OPENSEARCH_DASHBOARDS_INDEX_NAMES_SETTING);
                new OpenSearchDashboardsWrappedRestHandler(new RestIndexAction()),
    @Override
public class OpenSearchDashboardsModulePlugin extends Plugin implements SystemIndexPlugin {
import org.opensearch.plugins.SystemIndexPlugin;
    static class OpenSearchDashboardsWrappedRestHandler extends BaseRestHandler.Wrapper {
        ClusterSettings clusterSettings,
                new OpenSearchDashboardsWrappedRestHandler(new RestIndexPutAliasAction()),
import org.opensearch.rest.action.admin.indices.RestRefreshAction;
    }
    public List<Setting<?>> getSettings() {
import org.opensearch.rest.action.document.RestBulkAction;
                new OpenSearchDashboardsWrappedRestHandler(new CreateHandler()),
 */
                // api used for testing
        Property.NodeScope
import org.opensearch.rest.action.admin.indices.RestIndexPutAliasAction;
        // TODO need to figure out what subset of system indices OpenSearch Dashboards should have access to via these APIs
import org.opensearch.common.settings.Settings;
                new OpenSearchDashboardsWrappedRestHandler(new RestUpdateSettingsAction()),
import org.opensearch.rest.RestHandler;
                // apis needed to perform migrations... ideally these will go away
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 *
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.rest.action.admin.indices.RestGetIndicesAction;
        );
import org.opensearch.index.reindex.RestDeleteByQueryAction;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.rest.action.document.RestIndexAction.CreateHandler;
 */
import org.opensearch.common.settings.Setting.Property;
        }
import org.opensearch.rest.action.admin.indices.RestGetAliasesAction;
import org.opensearch.plugins.Plugin;
import java.util.Arrays;
import org.opensearch.rest.action.document.RestDeleteAction;
import java.util.Collection;
 * license agreements. See the NOTICE file distributed with
    public Collection<SystemIndexDescriptor> getSystemIndexDescriptors(Settings settings) {
 * Licensed to Elasticsearch under one or more contributor
        }
        public List<Route> routes() {
                new OpenSearchDashboardsWrappedRestHandler(new RestGetAliasesAction()),
                super.routes().stream()
    public List<RestHandler> getRestHandlers(
        return unmodifiableList(
        );
package org.opensearch.dashboards;
import org.opensearch.common.settings.SettingsFilter;
 * The OpenSearch Contributors require contributions made to
import org.opensearch.common.settings.Setting;
 *     http://www.apache.org/licenses/LICENSE-2.0
            super(delegate);
            )
import java.util.stream.Collectors;
                    .collect(Collectors.toList())
 * not use this file except in compliance with the License.
    }
        }
 * You may obtain a copy of the License at
                    .map(route -> new Route(route.getMethod(), "/_opensearch_dashboards" + route.getPath()))
 * under the License.
        }
                new OpenSearchDashboardsWrappedRestHandler(new RestMultiGetAction(settings)),
 * GitHub history for details.
        @Override
import org.opensearch.rest.action.admin.indices.RestUpdateSettingsAction;
                new OpenSearchDashboardsWrappedRestHandler(new RestSearchAction(clusterSettings)),
                new OpenSearchDashboardsWrappedRestHandler(new RestGetIndicesAction()),
            return true;
import java.util.Collections;
        public String getName() {
                ".opensearch_dashboards",
        IndexNameExpressionResolver indexNameExpressionResolver,
import org.opensearch.common.settings.IndexScopedSettings;
 * software distributed under the License is distributed on an
    ) {
import org.opensearch.rest.action.document.RestUpdateAction;
        SettingsFilter settingsFilter,
import org.opensearch.rest.action.document.RestMultiGetAction;
    }
    @Override
        public boolean allowSystemIndexAccessByDefault() {
            Arrays.asList(
                new OpenSearchDashboardsWrappedRestHandler(new RestUpdateAction()),
    }
        Supplier<DiscoveryNodes> nodesInCluster
                new OpenSearchDashboardsWrappedRestHandler(new RestSearchScrollAction()),
                // Based on https://github.com/elastic/kibana/issues/49764
        Settings settings,
        "opensearch_dashboards.system_indices",
                new OpenSearchDashboardsWrappedRestHandler(new RestGetAction()),
import java.util.function.Function;
                .stream()
                // apis used specifically by reporting
 */
        ),
import org.opensearch.rest.action.document.RestGetAction;
            return "opensearch_dashboards_" + super.getName();
 * compatible open source license.
import org.opensearch.rest.action.search.RestClearScrollAction;
                new OpenSearchDashboardsWrappedRestHandler(new AutoIdHandler(nodesInCluster)),
            );
import java.util.function.Supplier;
 *
 * SPDX-License-Identifier: Apache-2.0
                // apis needed to access saved objects
import org.opensearch.rest.RestController;
 * KIND, either express or implied.  See the License for the
        IndexScopedSettings indexScopedSettings,
import static java.util.Collections.unmodifiableList;
        OpenSearchDashboardsWrappedRestHandler(BaseRestHandler delegate) {
 * Modifications Copyright OpenSearch Contributors. See
    @Override
                new OpenSearchDashboardsWrappedRestHandler(new RestDeleteByQueryAction()),
                new OpenSearchDashboardsWrappedRestHandler(new RestBulkAction(settings)),
            Arrays.asList(
                ".apm-custom-link"
import org.opensearch.indices.SystemIndexDescriptor;
                new OpenSearchDashboardsWrappedRestHandler(new RestClearScrollAction())
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.rest.action.document.RestIndexAction;
                .map(pattern -> new SystemIndexDescriptor(pattern, "System index used by OpenSearch Dashboards"))
        RestController restController,
            )
        Function.identity(),
    );
                new OpenSearchDashboardsWrappedRestHandler(new RestDeleteAction()),
                new OpenSearchDashboardsWrappedRestHandler(new RestCreateIndexAction()),
import org.opensearch.rest.action.search.RestSearchScrollAction;
import org.opensearch.rest.action.document.RestBulkStreamingAction;
                ".reporting-*",
 *
            OPENSEARCH_DASHBOARDS_INDEX_NAMES_SETTING.get(settings)
        return unmodifiableList(
    public static final Setting<List<String>> OPENSEARCH_DASHBOARDS_INDEX_NAMES_SETTING = Setting.listSetting(
            return unmodifiableList(
 * this work for additional information regarding copyright
                new OpenSearchDashboardsWrappedRestHandler(new RestBulkStreamingAction(settings)),
/*
import org.opensearch.rest.BaseRestHandler;
