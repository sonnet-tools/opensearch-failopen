 * <p>
     * Wires the push-telemetry bridge that mirrors the pull-path ({@code NodeStats}) metrics via the  
package org.opensearch.concurrency;
        // Propagate the tier header from REST into the transport ThreadContext so the
     * @param clusterService the cluster service
 * The OpenSearch Contributors require contributions made to  
 *   }}
    @Override  
     * reads; it is not configurable.  
        ThreadPool threadPool,
        return List.of(new RestHeaderDefinition(TIER_HEADER, false));
 *       "concurrency_limit.action.search.action_name": "indices:data/read/search",
import org.opensearch.plugins.TelemetryAwarePlugin;
        Supplier<RepositoriesService> repositoriesServiceSupplier
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
 * Any OpenSearch action can be limited — no code change is required.  
 * Module plugin that enables adaptive per-action concurrency limiting.
    @Override
        NodeEnvironment nodeEnvironment,
     * @param environment the node environment settings
    }
    public ActionConcurrencyLimiterStats getConcurrencyLimiterStats() {
        Supplier<RepositoriesService> repositoriesServiceSupplier,  
        Tracer tracer,
    private volatile ActionConcurrencyLimiterRegistry registry;
import org.opensearch.env.Environment;
import org.opensearch.transport.client.Client;
public class ActionConcurrencyLimitPlugin extends Plugin implements ActionPlugin, ConcurrencyLimiterStatsPlugin, TelemetryAwarePlugin {
import java.util.function.Supplier;
     * @param tracer the tracer  
     * @param indexNameExpressionResolver the index name expression resolver
    public List<ActionFilter> getActionFilters() {
     * @param nodeEnvironment the node environment
     * Telemetry-aware component creation. Invoked after the standard {@link #createComponents}  
     *  
            clusterService.getClusterSettings(),
    }
import org.opensearch.telemetry.tracing.Tracer;  
 */  
        ScriptService scriptService,  
     * HTTP request header that the {@code byHeader} partition resolver reads to determine a
        );
        NamedWriteableRegistry namedWriteableRegistry,
import org.opensearch.core.xcontent.NamedXContentRegistry;
        ConcurrencyLimiterMetricsPublisher publisher = new ConcurrencyLimiterMetricsPublisher(metricsRegistry);
        Environment environment,
 *       "concurrency_limit.action.search.algorithm": "vegas"  
import org.opensearch.cluster.service.ClusterService;
    /** Creates a new {@link ActionConcurrencyLimitPlugin}. */
import org.opensearch.threadpool.ThreadPool;
        ScriptService scriptService,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.rest.RestHeaderDefinition;  
        Client client,
import org.opensearch.watcher.ResourceWatcherService;  
     * @param repositoriesServiceSupplier the repositories service supplier
     * request's partition. Registered via {@link #getRestHeaders()} so it is copied from the  
import org.opensearch.repositories.RepositoriesService;
        // byHeader partition resolver can read it during the action filter.  
     */
            threadPool.getThreadContext()  
    public ActionConcurrencyLimitPlugin() {}
     * REST request into the transport {@link org.opensearch.common.util.concurrent.ThreadContext},
    public static final String TIER_HEADER = "X-Request-Tier";
    public Collection<Object> createComponents(
    }
     * publisher is inert.
import org.opensearch.plugins.ActionPlugin;
 * SPDX-License-Identifier: Apache-2.0
        Environment environment,  
}  
        ThreadPool threadPool,
import org.opensearch.action.ActionConcurrencyLimiterStats;
        IndexNameExpressionResolver indexNameExpressionResolver,  
     * {@code TelemetryAwarePlugin.createComponents}), so {@link #registry} is already initialized.
/**  
     * @param namedWriteableRegistry the named writeable registry  
     * @param client the node client
        return r != null ? r.getStats() : null;
 *   { "persistent": {  
 * compatible open source license.
        registry.setMetricsListener(publisher);
        Client client,  
    public Collection<Object> createComponents(
        NamedXContentRegistry xContentRegistry,
        IndexNameExpressionResolver indexNameExpressionResolver,
    /**
            clusterService.getSettings(),
     * {@link MetricsRegistry}. When telemetry is disabled the node supplies a no-op registry, so the
    }  
     * @param threadPool the thread pool  
import java.util.Collection;
        ResourceWatcherService resourceWatcherService,  
import org.opensearch.plugins.ConcurrencyLimiterStatsPlugin;
 */
    ) {
     * where the action filter can read it. This is the only header the {@code byHeader} resolver
import org.opensearch.env.NodeEnvironment;  
        MetricsRegistry metricsRegistry
    @Override  
    @Override
 * Operators configure limiters via cluster settings using an alias as the namespace key:  
        return ConcurrencyLimitSettings.ALL_SETTINGS;
 * </pre>
    }
        return List.of(new ActionConcurrencyLimitFilter(registry));
        return List.of(publisher);  
    }  
        ActionConcurrencyLimiterRegistry r = this.registry;  
    public List<Setting<?>> getSettings() {  
        registry = new ActionConcurrencyLimiterRegistry(  
        NamedXContentRegistry xContentRegistry,
import org.opensearch.plugins.Plugin;  
import org.opensearch.telemetry.metrics.MetricsRegistry;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
     * (see {@code Node.java}, which runs {@code Plugin.createComponents} before
        return List.of(registry);
     */
import org.opensearch.script.ScriptService;
    @Override  
 *       "concurrency_limit.action.search.mode": "enforced",
     * @param xContentRegistry the XContent registry  
        NodeEnvironment nodeEnvironment,  
    ) {  
     * @param metricsRegistry the metrics registry
 * <pre>
    /**
    @Override
 *
        ClusterService clusterService,
        ResourceWatcherService resourceWatcherService,
/*  
    public Collection<RestHeaderDefinition> getRestHeaders() {
        NamedWriteableRegistry namedWriteableRegistry,
import org.opensearch.action.support.ActionFilter;
        ClusterService clusterService,  
     * @param resourceWatcherService the resource watcher service
import java.util.List;  
     * @param scriptService the script service
 *   PUT /_cluster/settings
import org.opensearch.common.settings.Setting;
