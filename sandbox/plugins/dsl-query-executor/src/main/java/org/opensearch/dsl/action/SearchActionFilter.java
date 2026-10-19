import org.opensearch.action.support.ActionFilterChain;  
import org.opensearch.action.admin.indices.validate.query.ValidateQueryAction;
 * SPDX-License-Identifier: Apache-2.0
        }  
import org.opensearch.action.support.ActionRequestMetadata;
 * this file be licensed under the Apache-2.0 license or a
    ) {  
    public <Request extends ActionRequest, Response extends ActionResponse> void apply(
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;  
}
            client.execute(ValidateAction.INSTANCE, validateRequest, (ActionListener<ValidateQueryResponse>) listener);  
import org.opensearch.action.search.SearchRequest;  
    private final NodeClient client;
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.core.action.ActionResponse;  
            client.execute(ExecuteAction.INSTANCE, searchRequest, (ActionListener<SearchResponse>) listener);
        ActionListener<Response> listener,
        if (SearchAction.NAME.equals(action)) {  
    /**
 * compatible open source license.
     */
    }
        Task task,  
    @SuppressWarnings("unchecked")
     *  
        String action,
 * The OpenSearch Contributors require contributions made to  
 *
        return FILTER_ORDER;  
        ActionRequestMetadata<Request, Response> actionRequestMetadata,  
import org.opensearch.action.ActionRequest;
import org.opensearch.tasks.Task;
/*  
    @Override  
        ActionFilterChain<Request, Response> chain
 * Intercepts all {@code _search} requests (dispatched to {@link ExecuteAction}) and
    static final int FILTER_ORDER = 1;  
     * Creates a filter that dispatches intercepted searches via the given client.
     * @param client node client for dispatching to {@link ExecuteAction}
import org.opensearch.action.search.SearchAction;
        } else {
    }
    public SearchActionFilter(NodeClient client) {  
            chain.proceed(task, action, request, listener);
    public int order() {
 */
    @Override
import org.opensearch.core.action.ActionListener;
    /** Runs after the Security plugin's authorization filter (order 0). */
            SearchRequest searchRequest = (SearchRequest) request;
    }
        // TODO: add support for other search-related APIs (_msearch, _count, _search_shards, etc.).
        Request request,
        this.client = client;
            ValidateQueryRequest validateRequest = (ValidateQueryRequest) request;
package org.opensearch.dsl.action;
 * {@code _validate/query} requests (dispatched to {@link ValidateAction}) for handling  
 */  
public class SearchActionFilter implements ActionFilter {  
 * through the Calcite pipeline. Other actions pass through unchanged.
/**
import org.opensearch.action.search.SearchResponse;
        // Consider two categories: APIs that execute search vs APIs that only explain/validate.
import org.opensearch.action.support.ActionFilter;
            // Cast is safe: the action name identifies the request/listener types.
import org.opensearch.action.admin.indices.validate.query.ValidateQueryResponse;
        } else if (ValidateQueryAction.NAME.equals(action)) {  
