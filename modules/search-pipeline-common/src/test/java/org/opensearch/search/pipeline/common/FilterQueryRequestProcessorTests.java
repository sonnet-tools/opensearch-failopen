    public void testFilterQuery() throws Exception {
import org.opensearch.index.query.TermQueryBuilder;
        );  
        SearchRequest transformedRequest = filterQueryRequestProcessor.processRequest(request);
    }  
        request = new SearchRequest();  
import org.opensearch.search.builder.SearchSourceBuilder;
        assertEquals(new BoolQueryBuilder().must(incomingQuery).filter(filterQuery), transformedRequest.source().query());  
 */  
import java.util.Map;
        FilterQueryRequestProcessor processor = factory.create(Collections.emptyMap(), null, null, false, configMap, null);
        FilterQueryRequestProcessor filterQueryRequestProcessor = new FilterQueryRequestProcessor(null, null, false, filterQuery);
import org.opensearch.test.AbstractBuilderTestCase;  
            IllegalArgumentException.class,
    public void testFactory() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
}
public class FilterQueryRequestProcessorTests extends AbstractBuilderTestCase {  
 *
    }
        assertEquals(new TermQueryBuilder("field", "value"), processor.filterQuery);  
import org.opensearch.index.query.QueryBuilder;  
        // Test missing incoming query
        SearchRequest request = new SearchRequest().source(source);
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(new BoolQueryBuilder().filter(filterQuery), transformedRequest.source().query());
/*  
        FilterQueryRequestProcessor.Factory factory = new FilterQueryRequestProcessor.Factory(this.xContentRegistry());  
 * compatible open source license.
        expectThrows(  
package org.opensearch.search.pipeline.common;
        QueryBuilder filterQuery = new TermQueryBuilder("field", "value");  
        SearchSourceBuilder source = new SearchSourceBuilder().query(incomingQuery);  
 * The OpenSearch Contributors require contributions made to  
        QueryBuilder incomingQuery = new TermQueryBuilder("text", "foo");
import java.util.HashMap;  
import org.opensearch.index.query.BoolQueryBuilder;
        Map<String, Object> configMap = new HashMap<>(Map.of("query", Map.of("term", Map.of("field", "value"))));
import org.opensearch.action.search.SearchRequest;
        transformedRequest = filterQueryRequestProcessor.processRequest(request);
import java.util.Collections;
        // Missing "query" parameter:
            () -> factory.create(Collections.emptyMap(), null, null, false, Collections.emptyMap(), null)
