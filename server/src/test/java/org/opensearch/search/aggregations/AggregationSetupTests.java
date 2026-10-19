        }
    }
        + "\"avg_price\": {\"avg\": { \"field\": \"f\"}}}";
}  
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
 * SPDX-License-Identifier: Apache-2.0
    protected final String globalNonGlobalAggs = "{ \"my_terms\": {\"terms\": {\"field\": \"f\"}}, "
public class AggregationSetupTests extends OpenSearchSingleNodeTestCase {
import org.opensearch.index.IndexService;
    protected IndexService index;  
import java.io.IOException;  
            aggParser.nextToken();
 * compatible open source license.
        context = createSearchContext(index);  
    protected SearchContext context;
    @Override  
        ((TestSearchContext) context).setConcurrentSegmentSearchEnabled(true);
        + "\"all_products\": {\"global\": {}, \"aggs\": {\"avg_price\": {\"avg\": { \"field\": \"f\"}}}}}";
/*  
        client().admin().indices().prepareRefresh("idx").get();
    public void setUp() throws Exception {
package org.opensearch.search.aggregations;
        context.setTask(task);  
import org.opensearch.test.TestSearchContext;
        index = createIndex("idx");  
import org.opensearch.action.search.SearchShardTask;
import org.opensearch.common.xcontent.json.JsonXContent;
import org.opensearch.core.xcontent.XContentParser;  
    protected AggregatorFactories getAggregationFactories(String agg) throws IOException {  
    }
 * The OpenSearch Contributors require contributions made to  
        super.setUp();
        client().prepareIndex("idx").setId("1").setSource("f", 5).execute().get();
        SearchShardTask task = new SearchShardTask(0, "n/a", "n/a", "test-kind", null, null);
 */  
 *
            return AggregatorFactories.parseAggregators(aggParser).build(context.getQueryShardContext(), null);  
        try (XContentParser aggParser = createParser(JsonXContent.jsonXContent, agg)) {
    protected final String multipleNonGlobalAggs = "{ \"my_terms\": {\"terms\": {\"field\": \"f\"}}, "
 * this file be licensed under the Apache-2.0 license or a
    protected final String globalAgg = "{ \"all_products\": {\"global\": {}, \"aggs\": {\"avg_price\": {\"avg\": { \"field\": \"f\"}}}}}";
import org.opensearch.search.internal.SearchContext;
