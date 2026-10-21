    ) {
package org.opensearch.node;
        // module with this MockNetworkService. NetworkService is such an integral part of the systme
            queryPhase,
import org.opensearch.threadpool.ThreadPool;
                threadPool,
    }
import org.opensearch.cluster.ClusterInfoService;
 */
        }
    ) {
        if (getPluginsService().filterPlugins(MockTransportService.TestPlugin.class).isEmpty()) {
        if (getPluginsService().filterPlugins(MockInternalClusterInfoService.TestPlugin.class).isEmpty()) {
                clusterSettings,
                fetchPhase,
            bigArrays,
            classpathPlugins,
        if (getPluginsService().filterPlugins(NodeMocksPlugin.class).isEmpty()) {
import org.opensearch.search.fetch.FetchPhase;
    protected BigArrays createBigArrays(PageCacheRecycler pageCacheRecycler, CircuitBreakerService circuitBreakerService) {
    }
    @Override
        List<SearchPlugin.ProfileMetricsProvider> pluginProfilers,
        BigArrays bigArrays,
                interceptor,
    public MockNode(
        CircuitBreakerService circuitBreakerService,
                        "1.8",
        }
            clusterService,
import org.opensearch.common.Nullable;
        }
import org.opensearch.script.ScriptContext;
import java.util.Map;
            );
import org.opensearch.transport.TransportInterceptor;
    @Override
    @Override
/**
        } else {
            );
    protected SearchService newSearchService(
                clusterSettings,
import org.opensearch.env.Environment;
 * </ul>
 * this work for additional information regarding copyright
        this(
                clusterService,
                indicesService,
            return super.newTransportService(
import org.opensearch.http.HttpServerTransport;
            return service;
    }
        Settings settings,
        Transport transport,
 *
        // both this wrapped instance and the StreamTransportService Node
    @Override
        TaskResourceTrackingService taskResourceTrackingService,
            indicesService,
 * under the License.
                .map(
        WorkloadGroupService workloadGroupService
                settings,
        }
import java.util.stream.Collectors;
import org.opensearch.telemetry.tracing.Tracer;
    }
            scriptService,
        // StreamTransportService land in StubbableTransport's delegate
import org.opensearch.cluster.service.ClusterService;
                )
            return new MockHttpTransport();
 * You may obtain a copy of the License at
            classpathPlugins.stream()
        }
        ThreadPool threadPool,
    }
import org.opensearch.common.settings.Settings;
        return new MockBigArrays(pageCacheRecycler, circuitBreakerService);
import java.util.function.Function;
                interceptor,
        // Only wrap when MockTransportService is actually in use; otherwise
        if (getPluginsService().filterPlugins(MockHttpTransport.TestPlugin.class).isEmpty()) {
 * specific language governing permissions and limitations
        Settings settings,
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.transport.TransportService;
public class MockNode extends Node {
    ) {
        ClusterService clusterService,
            circuitBreakerService,
                settings,
                tracer
        this.classpathPlugins = classpathPlugins;
                tracer
import org.opensearch.test.transport.StubbableTransport;
                taskHeaders,
            return streamTransport;
                transport,
import org.opensearch.core.common.transport.BoundTransportAddress;
        final Path configPath,
            return super.newScriptService(settings, engines, contexts);
        Set<String> taskHeaders,
        final Environment environment,
    public NamedWriteableRegistry getNamedWriteableRegistry() {
        NodeClient client
        IndicesService indicesService,
import java.nio.file.Path;
import org.opensearch.common.util.PageCacheRecycler;
import org.opensearch.common.util.MockBigArrays;
        return new StubbableTransport(streamTransport);
        final Settings settings,
 * <ul>
    ) {
                streamTransport,
                        "NA",
 * GitHub history for details.
import org.opensearch.common.util.BigArrays;
import org.opensearch.search.deciders.ConcurrentSearchRequestDecider;
    public MockNode(final Settings settings, final Collection<Class<? extends Plugin>> classpathPlugins) {
            workloadGroupService
        return namedWriteableRegistry;
                queryPhase,
        // then see.
        return classpathPlugins;
 */
     */
                indexSearcherExecutor,
     * The classpath plugins this node was constructed with.
                circuitBreakerService,
    @Override
import org.opensearch.wlm.WorkloadGroupService;
import org.opensearch.core.indices.breaker.CircuitBreakerService;
import org.opensearch.transport.client.node.NodeClient;
    ) {
 * Licensed to Elasticsearch under one or more contributor
            InternalSettingsPreparer.prepareEnvironment(settings, Collections.emptyMap(), null, () -> "mock_ node"),
            return super.newSearchService(
    protected HttpServerTransport newHttpTransport(NetworkModule networkModule) {
        ClusterSettings clusterSettings,
        final boolean forbidPrivateIndexSettings
        QueryPhase queryPhase,
    }
        Collection<ConcurrentSearchRequestDecider.Factory> concurrentSearchDeciderFactories,
                workloadGroupService
import org.opensearch.test.MockHttpTransport;
                concurrentSearchDeciderFactories,
 * KIND, either express or implied.  See the License for the
import org.opensearch.script.ScriptEngine;
            return new MockTransportService(
import org.opensearch.common.network.NetworkModule;
import java.util.concurrent.Executor;
        TransportInterceptor interceptor,
                transport,
            return super.newClusterInfoService(settings, clusterService, threadPool, client);
        ResponseCollectorService responseCollectorService,
                        "classpath plugin",
            true
/*
    @Override
                localNodeFactory,
 * Modifications Copyright OpenSearch Contributors. See
        super(environment, classpathPlugins, forbidPrivateIndexSettings);
 *
 * compatible open source license.
        // the regular transport stays unwrapped and we shouldn't wrap stream
                        p.getName(),
    }
        }
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
                        null,
            clusterService.addListener(service);
        // builds will see the same wrapper, so handlers registered on
import org.opensearch.search.query.QueryPhase;
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,
        return new MockPageCacheRecycler(settings);
    public Collection<PluginInfo> getClasspathPlugins() {
                        Collections.emptyList(),
import org.opensearch.search.SearchService;
    }
    PageCacheRecycler createPageCacheRecycler(Settings settings) {
                localNodeFactory,
                pluginProfilers,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                    )
    }
import org.opensearch.plugins.Plugin;
                responseCollectorService,
    }
        Tracer tracer
import org.opensearch.script.ScriptService;
import org.opensearch.Version;
 *   <li>Adding test plugins that exist on the classpath</li>
        if (getPluginsService().filterPlugins(MockScriptService.TestPlugin.class).isEmpty()) {
                threadPool,
                taskResourceTrackingService,
        } else {
import java.util.Collection;
            final MockInternalClusterInfoService service = new MockInternalClusterInfoService(settings, clusterService, threadPool, client);
        }
import org.opensearch.test.transport.MockTransportService;
    }
        this(
                streamTransport,
        if (getPluginsService().filterPlugins(MockSearchService.TestPlugin.class).isEmpty()) {
    private MockNode(
        );
    }
                        false
                bigArrays,
    }
        ClusterService clusterService,
/*
import org.opensearch.script.MockScriptService;
            return super.newHttpTransport(networkModule);
 */
        // do not configure this in tests as this is causing SetOnce to throw exceptions when jvm is used for multiple tests
            forbidPrivateIndexSettings
        @Nullable Transport streamTransport,
            );
    protected Transport wrapStreamTransport(@Nullable Transport streamTransport) {
        ThreadPool threadPool,
            fetchPhase,
import org.opensearch.plugins.SearchPlugin;
        // we don't allow to plug it in from plugins or anything. this is a test-only override and
        final boolean forbidPrivateIndexSettings
import org.opensearch.tasks.TaskResourceTrackingService;
        }
 * the Apache License, Version 2.0 (the "License"); you may
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
                threadPool,
        FetchPhase fetchPhase,
            InternalSettingsPreparer.prepareEnvironment(settings, Collections.emptyMap(), configPath, () -> "mock_ node"),
            threadPool,
    private final Collection<PluginInfo> classpathPlugins;
    protected ScriptService newScriptService(Settings settings, Map<String, ScriptEngine> engines, Map<String, ScriptContext<?>> contexts) {
                .collect(Collectors.toList()),
    @Override
    @Override
        // either (no one will look up the wrapped registry).
 * The OpenSearch Contributors require contributions made to
        return new MockSearchService(
                        Version.CURRENT,
    }
            indexSearcherExecutor,
        );
            return super.createPageCacheRecycler(settings);
    protected void configureNodeAndClusterIdStateListener(ClusterService clusterService) {
        ThreadPool threadPool,
                scriptService,
        ScriptService scriptService,
import java.util.Set;
        } else {
                    p -> new PluginInfo(
import org.opensearch.search.MockSearchService;
}
        // we use the MockTransportService.TestPlugin class as a marker to create a network
import org.opensearch.transport.Transport;
 *
    @Override
        // up sharing the same stub-discovery semantics. Wrapping here means
import org.opensearch.cluster.node.DiscoveryNode;
    protected ClusterInfoService newClusterInfoService(
        // Same StubbableTransport used for the regular transport — both end
            return super.createBigArrays(pageCacheRecycler, circuitBreakerService);
import java.util.Collections;
 * Unless required by applicable law or agreed to in writing,
                taskHeaders,
        final Collection<PluginInfo> classpathPlugins,
        final Collection<PluginInfo> classpathPlugins,
        Executor indexSearcherExecutor,
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
    protected TransportService newTransportService(
        // request-handler registry — which addRequestHandlingBehavior can
 * SPDX-License-Identifier: Apache-2.0
        // can't be done in a production env.
import org.opensearch.plugins.PluginInfo;
/*
 */
 *   <li>Overriding Version.CURRENT</li>
 * ownership. Elasticsearch licenses this file to you under
 * A node for testing which allows:
import org.opensearch.common.util.MockPageCacheRecycler;
import java.util.List;
        if (streamTransport == null) return null;
            taskResourceTrackingService,
import org.opensearch.indices.IndicesService;
 * this file be licensed under the Apache-2.0 license or a
        if (getPluginsService().filterPlugins(MockTransportService.TestPlugin.class).isEmpty()) {
import org.opensearch.cluster.MockInternalClusterInfoService;
        return new MockScriptService(settings, engines, contexts);
        if (getPluginsService().filterPlugins(NodeMocksPlugin.class).isEmpty()) {
                        p.getName(),
