            return streamTransport;
    }
        );  
                threadPool,
    private MockNode(
 */  
import org.opensearch.cluster.MockInternalClusterInfoService;  
import org.opensearch.transport.Transport;
    }
    private final Collection<PluginInfo> classpathPlugins;  
        // builds will see the same wrapper, so handlers registered on
                pluginProfilers,
            clusterService.addListener(service);
import org.opensearch.test.transport.StubbableTransport;  
                        "classpath plugin",
    ) {
            indicesService,
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.fetch.FetchPhase;  
                taskHeaders,  
        final Path configPath,
 * Modifications Copyright OpenSearch Contributors. See
/*  
            );
        if (getPluginsService().filterPlugins(MockSearchService.TestPlugin.class).isEmpty()) {
    }  
                taskHeaders,  
        // both this wrapped instance and the StreamTransportService Node  
                circuitBreakerService,  
            threadPool,
            queryPhase,
                localNodeFactory,
import java.util.concurrent.Executor;
            workloadGroupService
        );
    }
        // the regular transport stays unwrapped and we shouldn't wrap stream
        this(
    protected void configureNodeAndClusterIdStateListener(ClusterService clusterService) {
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
        }
        BigArrays bigArrays,  
        return new StubbableTransport(streamTransport);
    public Collection<PluginInfo> getClasspathPlugins() {
                settings,
        ThreadPool threadPool,
    /**
            return super.newSearchService(  
            forbidPrivateIndexSettings
        // up sharing the same stub-discovery semantics. Wrapping here means
import org.opensearch.wlm.WorkloadGroupService;  
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,  
import org.opensearch.script.ScriptEngine;
 * compatible open source license.
package org.opensearch.node;
            );
        // do not configure this in tests as this is causing SetOnce to throw exceptions when jvm is used for multiple tests  
import org.opensearch.common.util.BigArrays;
import org.opensearch.common.settings.ClusterSettings;
import java.util.Set;
import org.opensearch.plugins.PluginInfo;  
    }
        @Nullable Transport streamTransport,  
import java.util.Collection;  
    ) {
        Settings settings,
 * software distributed under the License is distributed on an
        ClusterService clusterService,
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.query.QueryPhase;
            InternalSettingsPreparer.prepareEnvironment(settings, Collections.emptyMap(), configPath, () -> "mock_ node"),  
                clusterService,
                        p.getName(),  
        }  
                tracer
    ) {
        return new MockBigArrays(pageCacheRecycler, circuitBreakerService);
        if (getPluginsService().filterPlugins(MockTransportService.TestPlugin.class).isEmpty()) {
 *   <li>Overriding Version.CURRENT</li>  
        return namedWriteableRegistry;
 */  
    @Override
        ScriptService scriptService,
        // request-handler registry — which addRequestHandlingBehavior can  
        // then see.
import org.opensearch.threadpool.ThreadPool;
        Settings settings,
            clusterService,  
    PageCacheRecycler createPageCacheRecycler(Settings settings) {
        Tracer tracer  
                .map(
    @Override
            taskResourceTrackingService,  
        // StreamTransportService land in StubbableTransport's delegate
        List<SearchPlugin.ProfileMetricsProvider> pluginProfilers,
import org.opensearch.test.MockHttpTransport;
    ) {  
        FetchPhase fetchPhase,
import org.opensearch.common.util.MockPageCacheRecycler;  
import org.opensearch.indices.IndicesService;
            fetchPhase,  
        );
        // we don't allow to plug it in from plugins or anything. this is a test-only override and
 * </ul>
/**  
        }
import org.opensearch.telemetry.tracing.Tracer;  
        Set<String> taskHeaders,
            scriptService,  
                settings,
        final Collection<PluginInfo> classpathPlugins,
        return classpathPlugins;
import java.util.Map;  
                localNodeFactory,
import org.opensearch.search.deciders.ConcurrentSearchRequestDecider;
    }
        if (getPluginsService().filterPlugins(NodeMocksPlugin.class).isEmpty()) {  
        this(
                clusterSettings,
                fetchPhase,
                workloadGroupService
import org.opensearch.cluster.node.DiscoveryNode;
        }
    public MockNode(
public class MockNode extends Node {
                        "1.8",
    public NamedWriteableRegistry getNamedWriteableRegistry() {  
            return super.newTransportService(
        } else {  
            true  
            InternalSettingsPreparer.prepareEnvironment(settings, Collections.emptyMap(), null, () -> "mock_ node"),
                streamTransport,
 *
    protected ClusterInfoService newClusterInfoService(
 *
 * not use this file except in compliance with the License.
                bigArrays,
import org.opensearch.plugins.SearchPlugin;
        Executor indexSearcherExecutor,
 * The OpenSearch Contributors require contributions made to  
            return super.newClusterInfoService(settings, clusterService, threadPool, client);
                indicesService,
import java.util.Collections;
        final Settings settings,  
    }
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        CircuitBreakerService circuitBreakerService,
            return super.createBigArrays(pageCacheRecycler, circuitBreakerService);
    ) {  
import org.opensearch.common.network.NetworkModule;
            bigArrays,
        Collection<ConcurrentSearchRequestDecider.Factory> concurrentSearchDeciderFactories,
    protected Transport wrapStreamTransport(@Nullable Transport streamTransport) {
    protected ScriptService newScriptService(Settings settings, Map<String, ScriptEngine> engines, Map<String, ScriptContext<?>> contexts) {  
 */  
                scriptService,
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.indices.breaker.CircuitBreakerService;
 * specific language governing permissions and limitations
        TransportInterceptor interceptor,
 * Licensed to Elasticsearch under one or more contributor  
    }
                .collect(Collectors.toList()),
        }  
            return super.newHttpTransport(networkModule);
                clusterSettings,
    }  
 * this work for additional information regarding copyright
        }  
                queryPhase,  
        if (getPluginsService().filterPlugins(NodeMocksPlugin.class).isEmpty()) {
import org.opensearch.cluster.ClusterInfoService;
import org.opensearch.plugins.Plugin;
import java.nio.file.Path;
 * under the License.  
        ClusterService clusterService,  
                        p.getName(),
            classpathPlugins.stream()  
        if (getPluginsService().filterPlugins(MockScriptService.TestPlugin.class).isEmpty()) {
        final Collection<PluginInfo> classpathPlugins,
                        Collections.emptyList(),
            return service;  
    @Override
    @Override
                threadPool,
                        false
        super(environment, classpathPlugins, forbidPrivateIndexSettings);
import java.util.List;
        ResponseCollectorService responseCollectorService,  
            return super.newScriptService(settings, engines, contexts);
                concurrentSearchDeciderFactories,  
    }
        final boolean forbidPrivateIndexSettings
        // module with this MockNetworkService. NetworkService is such an integral part of the systme  
                        Version.CURRENT,  
                transport,  
import org.opensearch.script.MockScriptService;
import org.opensearch.tasks.TaskResourceTrackingService;
import org.opensearch.transport.TransportService;
        QueryPhase queryPhase,
                    )  
/*  
    }  
    public MockNode(final Settings settings, final Collection<Class<? extends Plugin>> classpathPlugins) {  
import org.opensearch.cluster.service.ClusterService;
        // either (no one will look up the wrapped registry).  
 *   <li>Adding test plugins that exist on the classpath</li>
                interceptor,  
import org.opensearch.common.settings.Settings;  
                responseCollectorService,
import org.opensearch.Version;
                    p -> new PluginInfo(
import java.util.stream.Collectors;
import org.opensearch.search.MockSearchService;  
import org.opensearch.common.util.PageCacheRecycler;
    protected SearchService newSearchService(
     */  
                transport,  
                taskResourceTrackingService,
        return new MockScriptService(settings, engines, contexts);
    }
                )
    }  
    protected TransportService newTransportService(  
        // Only wrap when MockTransportService is actually in use; otherwise
                        null,  
     * The classpath plugins this node was constructed with.
                threadPool,  
    @Override
 * <ul>
            return new MockTransportService(
import org.opensearch.transport.client.node.NodeClient;
import java.util.function.Function;  
        ClusterSettings clusterSettings,
        if (getPluginsService().filterPlugins(MockTransportService.TestPlugin.class).isEmpty()) {  
        } else {  
import org.opensearch.common.util.MockBigArrays;
            return new MockHttpTransport();  
import org.opensearch.common.Nullable;  
        Transport transport,
            classpathPlugins,
        }  
 * GitHub history for details.
import org.opensearch.script.ScriptService;
import org.opensearch.search.SearchService;
import org.opensearch.env.Environment;
    @Override  
import org.opensearch.script.ScriptContext;  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
}  
import org.opensearch.test.transport.MockTransportService;
            indexSearcherExecutor,
        this.classpathPlugins = classpathPlugins;
    protected BigArrays createBigArrays(PageCacheRecycler pageCacheRecycler, CircuitBreakerService circuitBreakerService) {  
import org.opensearch.transport.TransportInterceptor;  
        WorkloadGroupService workloadGroupService  
            );  
        final Environment environment,  
                        "NA",
                tracer
    @Override
        if (getPluginsService().filterPlugins(MockHttpTransport.TestPlugin.class).isEmpty()) {  
        ThreadPool threadPool,
        if (getPluginsService().filterPlugins(MockInternalClusterInfoService.TestPlugin.class).isEmpty()) {
                indexSearcherExecutor,
        // we use the MockTransportService.TestPlugin class as a marker to create a network
 *  
 * A node for testing which allows:
        // Same StubbableTransport used for the regular transport — both end
/*
 * ownership. Elasticsearch licenses this file to you under  
        NodeClient client
import org.opensearch.http.HttpServerTransport;  
    protected HttpServerTransport newHttpTransport(NetworkModule networkModule) {
            final MockInternalClusterInfoService service = new MockInternalClusterInfoService(settings, clusterService, threadPool, client);
        } else {
        // can't be done in a production env.
import org.opensearch.core.common.transport.BoundTransportAddress;  
 */
        if (streamTransport == null) return null;  
        ThreadPool threadPool,
        IndicesService indicesService,  
    @Override
    }
        final boolean forbidPrivateIndexSettings  
            circuitBreakerService,
                interceptor,  
    @Override  
        }
        return new MockPageCacheRecycler(settings);  
        return new MockSearchService(
            return super.createPageCacheRecycler(settings);
        TaskResourceTrackingService taskResourceTrackingService,  
                streamTransport,
