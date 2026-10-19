            assertThat(retrievedIds.size(), equalTo(numDocs));  
import org.opensearch.common.settings.Settings;
 */  
        }  
                    assertTrue("Duplicate document id: " + hit.getId(), retrievedIds.add(hit.getId()));
                assertNoFailures(searchResponse);  
        }
 * this file be licensed under the Apache-2.0 license or a
            for (int i = 0; i < docsPerSegment; i++) {
                    // Verify no duplicate documents
    public void testScrollAcrossMultipleSegments() throws Exception {
                    assertNotNull(hit.getSourceAsMap());
        } finally {
import java.util.Arrays;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                for (SearchHit hit : searchResponse.getHits().getHits()) {
import static org.hamcrest.Matchers.equalTo;
                .setSource(jsonBuilder().startObject().field("field", i).field("text", "document " + i).endObject())
@LuceneTestCase.SuppressCodecs("*")
    }
import org.opensearch.search.SearchHit;
        ensureGreen("test");  
        int totalDocs = docsPerSegment * numSegments;
    /**
                for (SearchHit hit : searchResponse.getHits().getHits()) {
            assertThat(batchCount, equalTo(expectedBatches));
                }
        }
            }
            .addSort("field", SortOrder.ASC)
package org.opensearch.search.scroll;
    public static Collection<Object[]> parameters() {  
            assertNoFailures(searchResponse);
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        Set<String> retrievedIds = new HashSet<>();  
                int docId = seg * docsPerSegment + i;  
            .setScroll(TimeValue.timeValueMinutes(2))
            .setSize(scrollSize)  
        int expectedBatches = (totalDocs + scrollSize - 1) / scrollSize;  
            .setQuery(matchAllQuery())
                .setId(Integer.toString(i))
            client().prepareIndex("test")  
                .get();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
                searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
}  
            refresh("test");  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
        );
 * the sequential reader cache optimization for stored fields.
        createIndex("test", Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0).build());
                    assertEquals(Integer.parseInt(hit.getId()), hit.getSourceAsMap().get("field"));  
 * Tests verify that scroll queries correctly return all documents when using
                    assertTrue("Duplicate document id: " + hit.getId(), retrievedIds.add(hit.getId()));  
        try {  
            .setScroll(TimeValue.timeValueMinutes(2))
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) numDocs));
    public void testScrollWithSequentialReaderCache() throws Exception {
 * compatible open source license.
                    .get();
     * trigger the sequential reader optimization (>= 10 docs).
            .get();
        for (int i = 0; i < numDocs; i++) {
            .setSize(scrollSize)
 * Integration tests for scroll query StoredFieldsReader caching optimization.
            .setQuery(matchAllQuery())  
        super(settings);
 *
        indexRandomForConcurrentSearch("test");
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
/**
                searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
        Set<String> retrievedIds = new HashSet<>();
            // Verify exact batch count  
     * Tests that scroll queries with sequential document access correctly utilize
        for (int seg = 0; seg < numSegments; seg++) {
        int scrollSize = randomIntBetween(10, 50);
import java.util.Collection;  
     * the StoredFieldsReader cache and return all documents without data corruption.  
        indexRandomForConcurrentSearch("test");  
                batchCount++;  
            } while (searchResponse.getHits().getHits().length > 0);
            assertThat(retrievedIds.size(), equalTo(totalDocs));
 */  
        int numDocs = randomIntBetween(100, 500);  
        SearchResponse searchResponse = client().prepareSearch("test")
/*  
import org.apache.lucene.tests.util.LuceneTestCase;  
    public ScrollStoredFieldsCacheIT(Settings settings) {
                    .setId(Integer.toString(docId))
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) totalDocs));  
import org.opensearch.action.search.SearchResponse;
            clearScroll(searchResponse.getScrollId());
    }
        }
        // Index documents in batches to create multiple segments  
 * SPDX-License-Identifier: Apache-2.0
                    // Verify document content is correct _source field
 * The OpenSearch Contributors require contributions made to  
            // Verify all documents retrieved
import org.opensearch.search.sort.SortOrder;
            .get();  
        try {
            .addSort("field", SortOrder.ASC)  
        } finally {
     * Tests scroll queries across multiple segments with batch sizes that
        refresh("test");
 *  
    }  
        return Arrays.asList(
    @ParametersFactory
public class ScrollStoredFieldsCacheIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            do {
import java.util.Set;
            } while (searchResponse.getHits().getHits().length > 0);  
        int numSegments = randomIntBetween(3, 5);  
                    .setSource(jsonBuilder().startObject().field("field", docId).field("segment", seg).endObject())  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        createIndex("test", Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0).build());
        // Index documents
import java.util.HashSet;
            int batchCount = 0;
            assertNoFailures(searchResponse);
import org.opensearch.common.unit.TimeValue;  
        SearchResponse searchResponse = client().prepareSearch("test")
     */  
     */
        int docsPerSegment = randomIntBetween(20, 50);
                client().prepareIndex("test")
        ensureGreen("test");
            // Verify all documents were retrieved
                }  
                assertNoFailures(searchResponse);
    }
    /**  
            do {  
        int scrollSize = randomIntBetween(10, 50);
            clearScroll(searchResponse.getScrollId());  
