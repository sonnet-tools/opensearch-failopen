        verify(chain).proceed(task, BulkAction.NAME, request, listener);
import org.opensearch.action.search.SearchAction;  
import org.opensearch.action.search.SearchRequest;
        SearchRequest request = new SearchRequest("test-index");  
 *
    private final ActionFilterChain<ActionRequest, ActionResponse> chain = mock(ActionFilterChain.class);
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;  
    private final ActionRequestMetadata<ActionRequest, ActionResponse> metadata = mock(ActionRequestMetadata.class);
/*  
@SuppressWarnings("unchecked")
import org.opensearch.transport.client.node.NodeClient;
        verify(chain, never()).proceed(any(), any(), any(), any());
    public void testOrderRunsAfterSecurityFilter() {
import static org.mockito.Mockito.any;
    }
    }  
    private final Task task = mock(Task.class);
        verify(client).execute(eq(ExecuteAction.INSTANCE), eq(request), any());
        filter.apply(task, BulkAction.NAME, request, metadata, listener, chain);  
import org.opensearch.action.support.ActionRequestMetadata;  
import org.opensearch.test.OpenSearchTestCase;
    public void testPassesThroughNonSearchAction() {  
import static org.mockito.Mockito.eq;
        ValidateQueryRequest request = new ValidateQueryRequest("test-index");  
 * compatible open source license.
        verify(client, never()).execute(any(), any(), any());  
import org.opensearch.action.admin.indices.validate.query.ValidateQueryAction;
import org.opensearch.action.support.ActionFilterChain;
import static org.mockito.Mockito.never;
    private final NodeClient client = mock(NodeClient.class);
 * this file be licensed under the Apache-2.0 license or a
        BulkRequest request = new BulkRequest();
package org.opensearch.dsl.action;
import org.opensearch.action.ActionRequest;
        filter.apply(task, ValidateQueryAction.NAME, request, metadata, listener, chain);
        verify(client).execute(eq(ValidateAction.INSTANCE), eq(request), any());
        verify(chain, never()).proceed(any(), any(), any(), any());
import org.opensearch.tasks.Task;  
    }
public class SearchActionFilterTests extends OpenSearchTestCase {
    private final ActionListener<ActionResponse> listener = mock(ActionListener.class);  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.action.ActionResponse;
    // TODO: add tests to verify reroute only happens when the target index has the setting enabled  
import org.opensearch.core.action.ActionListener;
 * SPDX-License-Identifier: Apache-2.0
 */  
import org.opensearch.action.bulk.BulkAction;
import static org.mockito.Mockito.mock;  
        filter.apply(task, SearchAction.NAME, request, metadata, listener, chain);
    private final SearchActionFilter filter = new SearchActionFilter(client);  
    }  
import static org.mockito.Mockito.verify;
}
import org.opensearch.action.bulk.BulkRequest;
        assertEquals(SearchActionFilter.FILTER_ORDER, filter.order());  
    public void testReroutesValidateQueryAction() {
    public void testReroutesSearchAction() {
