    }  
    }  
    @Override
 * SPDX-License-Identifier: Apache-2.0
 */  
    @Override
    public boolean validate() {
        return rewriteContext.getWriteableRegistry();
        return rewriteContext.nowInMillis();  
    }
@PublicApi(since = "2.19.0")  
/*  
    public void registerAsyncAction(BiConsumer<Client, ActionListener<?>> asyncAction) {
        rewriteContext.executeAsyncActions(listener);
    public Map<String, Object> getContextVariables() {
        this.searchRequest = searchRequest;
    public boolean hasAsyncActions() {
    public QueryShardContext convertToShardContext() {  
        return rewriteContext.validate();  
import java.util.Map;  
    public IndicesRequest getSearchRequest() {
    @Override
    @Override  
        return rewriteContext.hasAsyncActions();
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        return this;
import org.opensearch.action.IndicesRequest;
        return searchRequest;
    @Override
 *  
        this.rewriteContext = rewriteContext;
import java.util.function.BiConsumer;
 * This class acts as a wrapper around a QueryRewriteContext instance and a PipelinedRequest,
    private final QueryRewriteContext rewriteContext;
 * compatible open source license.
    }
    @Override
    public void executeAsyncActions(ActionListener listener) {  
    }
    @Override  
/**  
 * The QueryCoordinatorContext class implements the QueryRewriteContext interface and provides
    }
public class QueryCoordinatorContext implements QueryRewriteContext {
}
    public NamedWriteableRegistry getWriteableRegistry() {
 * additional functionality for coordinating query rewriting in OpenSearch.
import org.opensearch.search.pipeline.PipelinedRequest;
 * @since 2.19.0
import java.util.HashMap;
    public long nowInMillis() {
package org.opensearch.index.query;
        return rewriteContext.convertToShardContext();
            return new HashMap<>(((PipelinedRequest) searchRequest).getPipelineProcessingContext().getAttributes());
        if (searchRequest instanceof PipelinedRequest) {  
            return Collections.emptyMap();  
    }  
    @InternalApi
    public QueryCoordinatorContext(QueryRewriteContext rewriteContext, IndicesRequest searchRequest) {  
    }
    }
        }
 */
 * The OpenSearch Contributors require contributions made to  
    }  
    private final IndicesRequest searchRequest;  
    @Override
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.action.ActionListener;
    @Override  
    public NamedXContentRegistry getXContentRegistry() {  
 *  
    }
        rewriteContext.registerAsyncAction(asyncAction);  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * allowing access to both rewrite context methods and pass over search request information.
import org.opensearch.transport.client.Client;
import org.opensearch.common.annotation.PublicApi;  
        return rewriteContext.getXContentRegistry();
 *
import org.opensearch.common.annotation.InternalApi;
    }  
    public QueryCoordinatorContext convertToCoordinatorContext() {
        } else {
import java.util.Collections;
