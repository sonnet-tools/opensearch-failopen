/**
        SearchResponse conSearchResp = client().prepareSearch("test")
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                    .endObject()
                    .endObject()  
            .cluster()
        assertThat(conSearchExplain.getValue(), equalTo(conSearchResp.getHits().getHits()[0].getScore()));
        assertEquals(nonConSearchExplain, conSearchExplain);
                    .field("type", "nested")
            .cluster()
            .setId("2")  
import org.opensearch.action.search.SearchResponse;  
        client().admin()
                    .startObject()
        // Turn off the concurrent search setting to test search with non-concurrent search
                    .startObject("nested1")
            .setExplain(true)  
        // assert that the explanation for concurrent search should be equal to the non-concurrent search's explanation
            .setQuery(nestedQuery("nested1", termQuery("nested1.n_field1", "n_value1"), ScoreMode.Total))
                    .endObject()
            .get();
 * compatible open source license.
import org.opensearch.common.settings.Settings;
                    .startObject()
            .get();
/*  
            .setSource(
     * Tests the explain output for multiple docs. Concurrent search with multiple slices is tested
import static org.hamcrest.Matchers.equalTo;
            .get();  
                    .endObject()  
        ensureGreen();  
            .setExplain(true)
            )
        assertNoFailures(nonConSearchResp);
            )
        SearchResponse nonConSearchResp = client().prepareSearch("test")  
                    .endObject()
     * case in concurrent search, refer {@link SimpleExplainIT#testExplainWithSingleDoc}
                    .field("n_field1", "n_value2")  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
                    .endObject()
                jsonBuilder().startObject()
     * For more details, refer: https://github.com/opensearch-project/OpenSearch/issues/11413  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
     * */
        client().admin()  
                    .endArray()
                    .startArray("nested1")
            .get();
                    .field("n_field1", "n_value1")  
 * The OpenSearch Contributors require contributions made to  
        assertAcked(  
                    .startObject()
            .prepareUpdateSettings()  
import org.apache.lucene.search.join.ScoreMode;
import static org.opensearch.index.query.QueryBuilders.nestedQuery;  
            .prepareUpdateSettings()
                    .field("n_field1", "n_value2")  
 */  
        Explanation conSearchExplain = conSearchResp.getHits().getHits()[0].getExplanation();
                    .endArray()
            .setPersistentSettings(Settings.builder().putNull(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey()).build())  
 * Creating a separate class with no parameterization to create and index documents in a single
            .cluster()
            prepareCreate("test").setMapping(
        // Turn on the concurrent search setting to test search with concurrent search  
                    .endObject()  
        assertThat(nonConSearchResp.getHits().getTotalHits().value(), equalTo(1L));
package org.opensearch.search.nested;
                jsonBuilder().startObject()
        client().prepareIndex("test")
        return 1;
            .setSource(
 * SPDX-License-Identifier: Apache-2.0
                jsonBuilder().startObject()
 * refer: https://github.com/opensearch-project/OpenSearch/issues/11413
    }
                    .endObject()
            .get();  
import org.opensearch.test.OpenSearchIntegTestCase;
                    .field("n_field1", "n_value1")  
            .setRefreshPolicy(IMMEDIATE)
    protected int numberOfShards() {  
import static org.opensearch.index.query.QueryBuilders.termQuery;
            .setPersistentSettings(Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build())  
            .prepareUpdateSettings()
            .setId("1")  
}  
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
 *
 */
    @Override
                    .field("field1", "value2")  
        );
            .setQuery(nestedQuery("nested1", termQuery("nested1.n_field1", "n_value1"), ScoreMode.Total))
import org.apache.lucene.search.Explanation;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            .setRefreshPolicy(IMMEDIATE)
        client().prepareIndex("test")
        client().admin()  
        Explanation nonConSearchExplain = nonConSearchResp.getHits().getHits()[0].getExplanation();  
        assertThat(nonConSearchExplain.getValue(), equalTo(nonConSearchResp.getHits().getHits()[0].getScore()));
 * test run and compare search responses across concurrent and non-concurrent search. For more details,  
            .setPersistentSettings(Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build())
            )  
            .get();  
     * non-concurrent search use-case. Separate test class is created to test explain for 1 slice
    }
    /*
                    .startArray("nested1")
                    .startObject("properties")  
 * this file be licensed under the Apache-2.0 license or a
    public void testExplainMultipleDocs() throws Exception {
public class SimpleNestedExplainIT extends OpenSearchIntegTestCase {  
                    .endObject()
                    .startObject()
        assertNoFailures(conSearchResp);
        assertThat(conSearchResp.getHits().getTotalHits().value(), equalTo(1L));  
            .get();
                    .field("field1", "value1")  
     * here as call to indexRandomForMultipleSlices is made and compared with explain output for  
