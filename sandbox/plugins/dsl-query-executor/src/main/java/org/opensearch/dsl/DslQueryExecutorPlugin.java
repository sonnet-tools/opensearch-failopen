import org.opensearch.script.ScriptService;  
        ResourceWatcherService resourceWatcherService,  
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
 * and {@link TransportExecuteAction} to handle DSL-to-Calcite conversion and execution.
        );  
import org.opensearch.dsl.action.ValidateAction;  
        ClusterService clusterService,
        ScriptService scriptService,
import org.opensearch.dsl.action.TransportValidateAction;
 */  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.watcher.ResourceWatcherService;
import java.util.List;
import org.opensearch.env.Environment;
    ) {
        this.searchActionFilter = new SearchActionFilter((NodeClient) client);  
    /** Creates a new plugin instance. */
import org.opensearch.plugins.Plugin;
}
        Environment environment,  
    public DslQueryExecutorPlugin() {}
    @Override  
        ThreadPool threadPool,
        return searchActionFilter != null ? List.of(searchActionFilter) : List.of();
 *
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
import java.util.function.Supplier;  
import org.opensearch.action.ActionRequest;
/*  
import org.opensearch.transport.client.Client;
import org.opensearch.core.xcontent.NamedXContentRegistry;
import java.util.Collection;  
            new ActionHandler<>(ValidateAction.INSTANCE, TransportValidateAction.class)
            new ActionHandler<>(ExecuteAction.INSTANCE, TransportExecuteAction.class),
        NamedWriteableRegistry namedWriteableRegistry,
    }
import org.opensearch.threadpool.ThreadPool;
    public List<ActionFilter> getActionFilters() {
import org.opensearch.dsl.action.TransportExecuteAction;
        return List.of(  
import org.opensearch.core.action.ActionResponse;
import java.util.Collections;
import org.opensearch.repositories.RepositoriesService;
        Supplier<RepositoriesService> repositoriesServiceSupplier
import org.opensearch.transport.client.node.NodeClient;  
import org.opensearch.env.NodeEnvironment;
import org.opensearch.dsl.action.SearchActionFilter;  
/**
    public Collection<Object> createComponents(
    @Override
        Client client,  
import org.opensearch.cluster.service.ClusterService;
 * compatible open source license.
package org.opensearch.dsl;
        return Collections.emptyList();
 * The OpenSearch Contributors require contributions made to  
public class DslQueryExecutorPlugin extends Plugin implements ActionPlugin {  
        NamedXContentRegistry xContentRegistry,
 */
import org.opensearch.dsl.action.ExecuteAction;
 * this file be licensed under the Apache-2.0 license or a
    }  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
    private SearchActionFilter searchActionFilter;
        NodeEnvironment nodeEnvironment,
import org.opensearch.action.support.ActionFilter;
 * Plugin entry point. Registers {@link SearchActionFilter} to intercept _search requests  
    @Override
    }
import org.opensearch.plugins.ActionPlugin;  
        IndexNameExpressionResolver indexNameExpressionResolver,  
