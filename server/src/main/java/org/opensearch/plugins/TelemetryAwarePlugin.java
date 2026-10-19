        ClusterService clusterService,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        Client client,  
     * @param resourceWatcherService A service to watch for changes to node local files
import org.opensearch.threadpool.ThreadPool;
     * @param environment the environment for path and setting configurations
        ScriptService scriptService,
        ResourceWatcherService resourceWatcherService,  
     * @param threadPool A service to allow retrieving an executor to run an async action
     *
        MetricsRegistry metricsRegistry  
     */
import java.util.Collections;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
/*  
import org.opensearch.env.NodeEnvironment;  
import org.opensearch.core.common.io.stream.NamedWriteable;
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
import java.util.Collection;  
     * @param client A client to make requests to the system
     * @param repositoriesServiceSupplier A supplier for the service that manages snapshot repositories; will return null when this method  
        Environment environment,  
 * Plugin that provides the telemetry registries to build component with telemetry and also provide a way to
     * @param xContentRegistry the registry for extensible xContent parsing
import org.opensearch.telemetry.tracing.Tracer;
    }  
        Tracer tracer,
 *
    ) {
import org.opensearch.common.annotation.ExperimentalApi;  
     * <p>  
 */  
package org.opensearch.plugins;
     * @param indexNameExpressionResolver A service that resolves expression to index and alias names
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.script.ScriptService;
        Supplier<RepositoriesService> repositoriesServiceSupplier,
import java.util.function.Supplier;
public interface TelemetryAwarePlugin {
     * @param namedWriteableRegistry the registry for {@link NamedWriteable} object parsing
import org.opensearch.common.lifecycle.LifecycleComponent;
     * @param nodeEnvironment the node environment used coordinate access to the data paths  
        IndexNameExpressionResolver indexNameExpressionResolver,  
    /**
     * Note: To aid in the migration away from guice, all objects returned as components will be bound in guice
import org.opensearch.env.Environment;
        NodeEnvironment nodeEnvironment,
        NamedXContentRegistry xContentRegistry,
/**
     * @param metricsRegistry the registry for metrics instrumentation.  
        return Collections.emptyList();
import org.opensearch.watcher.ResourceWatcherService;
     * @param tracer the tracer to add tracing instrumentation.
@ExperimentalApi
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.NamedXContentRegistry;
     *                                   is called, but will return the repositories service once the node is initialized.
    default Collection<Object> createComponents(
        ThreadPool threadPool,
 * pass telemetry registries to the implementing plugins for adding instrumentation in the code.  
 * @opensearch.experimental
     * Any components returned that implement {@link LifecycleComponent} will have their lifecycle managed.
     * Returns components added by this plugin.
 *
import org.opensearch.telemetry.metrics.MetricsRegistry;  
     * @param clusterService A service to allow watching and updating cluster state  
     * to themselves.  
        NamedWriteableRegistry namedWriteableRegistry,
}
import org.opensearch.cluster.service.ClusterService;
 */  
     * @param scriptService A service to allow running scripts on the local node  
import org.opensearch.repositories.RepositoriesService;
import org.opensearch.transport.client.Client;  
