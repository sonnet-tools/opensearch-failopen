        assertFalse(requestListeners.getListeners().get(0).isEnabled());
            testListener1,
            @Override  
    }
        SearchSourceBuilder source = SearchSourceBuilder.searchSource().query(QueryBuilders.matchAllQuery());
    public void testStandardListenersEnabled() {
        SearchRequestOperationsListener testListener1 = createTestSearchRequestOperationsListener();  
    }
        SearchRequestOperationsListener testListener2 = createTestSearchRequestOperationsListener();
        assertEquals(1, listeners.size());
            searchRequest,
            protected void onPhaseEnd(SearchPhaseContext context, SearchRequestContext searchRequestContext) {}
        SearchRequestOperationsListener testListener2 = createTestSearchRequestOperationsListener();
        assertEquals(testListener1, requestListeners.getListeners().get(0));
    public void testStandardListenerAndPerRequestListenerDisabled() {
        testListener1.setEnabled(false);
        );  
        List<SearchRequestOperationsListener> listeners = compositeListener.getListeners();
        SearchRequestOperationsCompositeListenerFactory requestListeners = new SearchRequestOperationsCompositeListenerFactory(  
        );
            testListener2
    public SearchRequestOperationsListener createTestSearchRequestOperationsListener() {
            logger
            logger,
        assertEquals(2, listeners.size());
            testListener2
        SearchRequestOperationsCompositeListenerFactory requestListeners = new SearchRequestOperationsCompositeListenerFactory(  
    }  
        SearchRequest searchRequest = new SearchRequest().source(source);
    public void testStandardListenersAndPerRequestListener() {  
        SearchRequestOperationsListener testListener2 = createTestSearchRequestOperationsListener();  
        SearchRequestOperationsListener.CompositeListener compositeListener = requestListeners.buildCompositeListener(
            logger,  
        SearchRequest searchRequest = new SearchRequest().source(source);
        SearchRequestOperationsCompositeListenerFactory requestListeners = new SearchRequestOperationsCompositeListenerFactory(
        assertEquals(1, listeners.size());
        );
            searchRequest,
        searchRequest.setPhaseTook(false);  
        assertEquals(testListener1, listeners.get(0));  
    }
import org.opensearch.search.builder.SearchSourceBuilder;
            testListener2
        assertEquals(testListener2, listeners.get(1));
        assertEquals(testListener1, listeners.get(0));
        );  
        SearchRequestOperationsListener.CompositeListener compositeListener = requestListeners.buildCompositeListener(  
        SearchRequestOperationsListener testListener2 = createTestSearchRequestOperationsListener();
        SearchRequestOperationsListener.CompositeListener compositeListener = requestListeners.buildCompositeListener(  
        assertEquals(testListener2, listeners.get(0));
        SearchRequestOperationsListener.CompositeListener compositeListener = requestListeners.buildCompositeListener(
    }  
}
        );  
        SearchRequestOperationsCompositeListenerFactory requestListeners = new SearchRequestOperationsCompositeListenerFactory(  
        testListener1.setEnabled(true);  
        assertEquals(1, requestListeners.getListeners().size());  
        );
        );  
        SearchRequest searchRequest = new SearchRequest().source(source);
        List<SearchRequestOperationsListener> listeners = compositeListener.getListeners();
        );
        SearchRequestOperationsListener testListener1 = createTestSearchRequestOperationsListener();
            searchRequest,  
 * this file be licensed under the Apache-2.0 license or a
        );
            testListener1
        assertEquals(testListener, requestListeners.getListeners().get(0));
        SearchSourceBuilder source = SearchSourceBuilder.searchSource().query(QueryBuilders.matchAllQuery());
        List<SearchRequestOperationsListener> listeners = compositeListener.getListeners();  
        assertEquals(testListener2, listeners.get(0));  
        return new SearchRequestOperationsListener() {
    public void testAddAndGetListeners() {
            @Override  
    }
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        };
        SearchSourceBuilder source = SearchSourceBuilder.searchSource().query(QueryBuilders.matchAllQuery());
            protected void onPhaseFailure(SearchPhaseContext context, Throwable cause) {}
            logger,
            protected void onPhaseStart(SearchPhaseContext context) {}
package org.opensearch.action.search;
        searchRequest.setPhaseTook(true);
            testListener
        assertEquals(testListener1, requestListeners.getListeners().get(0));
 * The OpenSearch Contributors require contributions made to  
        assertEquals(1, requestListeners.getListeners().size());
        List<SearchRequestOperationsListener> listeners = compositeListener.getListeners();
public class SearchRequestOperationsCompositeListenerFactoryTests extends OpenSearchTestCase {
 *
            testListener1
        SearchRequest searchRequest = new SearchRequest().source(source);  
        assertEquals(testListener1, requestListeners.getListeners().get(0));  
import org.opensearch.test.OpenSearchTestCase;  
        SearchRequestOperationsListener testListener1 = createTestSearchRequestOperationsListener();
        assertEquals(1, listeners.size());  
        testListener1.setEnabled(false);
        SearchRequestOperationsCompositeListenerFactory requestListeners = new SearchRequestOperationsCompositeListenerFactory(
 */  
        assertEquals(testListener1, requestListeners.getListeners().get(0));  
            testListener1  
            @Override  
        SearchRequestOperationsListener testListener = createTestSearchRequestOperationsListener();  
/*  
            searchRequest,
        assertEquals(1, requestListeners.getListeners().size());
        testListener2.setEnabled(false);
        assertEquals(1, requestListeners.getListeners().size());
        assertEquals(testListener2, requestListeners.getListeners().get(1));  
            testListener2  
        SearchSourceBuilder source = SearchSourceBuilder.searchSource().query(QueryBuilders.matchAllQuery());
    public void testStandardListenersDisabledAndPerRequestListener() {  
import org.opensearch.index.query.QueryBuilders;
        testListener1.setEnabled(true);  
        assertEquals(2, requestListeners.getListeners().size());
        SearchRequestOperationsListener testListener1 = createTestSearchRequestOperationsListener();
        testListener2.setEnabled(true);
