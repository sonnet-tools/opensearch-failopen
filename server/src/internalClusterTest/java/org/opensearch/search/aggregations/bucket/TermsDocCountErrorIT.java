    }
        shard0DocsPerTerm.put("E", 2);  
                    .order(BucketOrder.aggregation("sortAgg", true))
                    .order(BucketOrder.aggregation("sortAgg", false))
                            .field(STRING_FIELD_NAME, "val" + randomInt(numUniqueTerms))
import org.opensearch.search.aggregations.bucket.terms.Terms.Bucket;
            );
                    client().prepareIndex("idx_fixed_docs_0")
                    .field(LONG_FIELD_NAME)
        }  
                    .field(DOUBLE_FIELD_NAME)  
 * ownership. Elasticsearch licenses this file to you under  
        assertNoDocCountError(size, accurateResponse, testResponse);
                    .field(LONG_FIELD_NAME)
        assertThat(accurateTerms, notNullValue());  
            )  
                    .shardSize(shardSize)
                    .field(LONG_FIELD_NAME)
import java.util.ArrayList;  
                    .field(LONG_FIELD_NAME)
                    .shardSize(10000)  
            for (int i = 0; i < entry.getValue(); i++) {  
        ensureSearchable();
            .addAggregation(
                    .field(STRING_FIELD_NAME)  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                terms("terms").executionHint(randomExecutionHint())
            assertThat(testBucket.getDocCountError(), equalTo(0L));
                terms("terms").executionHint(randomExecutionHint())
import org.opensearch.search.aggregations.bucket.terms.Terms;  
                    .showTermDocCountError(true)  
                    )
        // See https://github.com/opensearch-project/OpenSearch/issues/11680"  
                    .showTermDocCountError(true)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
                    .size(10000)
                    .showTermDocCountError(true)
        assertThat(bucket.getDocCount(), equalTo(50L));
                    .field(STRING_FIELD_NAME)
                    .order(BucketOrder.count(true))
                    .order(BucketOrder.key(true))
        assertThat(testTerms.getDocCountError(), greaterThanOrEqualTo(0L));
    }
    @ParametersFactory  
                    .size(10000)
 *  
            .addAggregation(  
            )  
                            .field(DOUBLE_FIELD_NAME, 1.0 * randomInt(numUniqueTerms))
                    .showTermDocCountError(true)
    }  
                    .shardSize(shardSize)  
                );  
        int size = randomIntBetween(1, 20);  
            .get();  
            assertThat(testBucket.getDocCount() + testBucket.getDocCountError(), greaterThanOrEqualTo(accurateBucket.getDocCount()));
                    .field(STRING_FIELD_NAME)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
    }
    public static Collection<Object[]> parameters() {
        int size = randomIntBetween(1, 20);  
        shard2DocsPerTerm.put("H", 28);
        // doc_counts, and doc_count_errors may be returned. This test serves to verify that the doc_count_error is the same between  
        int size = randomIntBetween(1, 20);
    private static final String DOUBLE_FIELD_NAME = "d_value";  
        assertSearchResponse(accurateResponse);  
                    .showTermDocCountError(true)
                    .size(size)  
        List<? extends Bucket> testBuckets = testTerms.getBuckets();
        int shardSize = randomIntBetween(size, size * 2);
        assertAcked(client().admin().indices().prepareCreate("idx").setMapping(STRING_FIELD_NAME, "type=keyword").get());
        }  
        assertThat(bucket.getKey(), equalTo("C"));  
                    .field(STRING_FIELD_NAME)
        assertThat(testBuckets.size(), lessThanOrEqualTo(size));
    }
                    .size(size)
        assertThat(accurateTerms, notNullValue());
        assertNoDocCountError(size, accurateResponse, testResponse);
        assertSearchResponse(accurateResponse);
                    .shardSize(10000)
                terms("terms").executionHint(randomExecutionHint())  
        assertUnboundedDocCountError(size, accurateResponse, testResponse);
                    .order(BucketOrder.key(true))  
            assertThat(testBucket, notNullValue());
        assertSearchResponse(accurateResponse);
                    .field(DOUBLE_FIELD_NAME)  
        assertUnboundedDocCountError(size, accurateResponse, testResponse);
                    .size(size)
        assertThat(buckets, notNullValue());
        shard1DocsPerTerm.put("C", 4);
        int shardSize = randomIntBetween(size, size * 2);
                    .shardSize(10000)
    public void testDoubleValueFieldSingleShard() throws Exception {
        assertAcked(  
    }
            .addAggregation(
                    .size(5)
 * this file be licensed under the Apache-2.0 license or a
        int shardSize = randomIntBetween(size, size * 2);
            .addAggregation(
                terms("terms").executionHint(randomExecutionHint())  
                    .order(BucketOrder.aggregation("sortAgg", false))  
                terms("terms").executionHint(randomExecutionHint())  
            .addAggregation(  
            .addAggregation(  
            .get();
                    .order(BucketOrder.key(false))
                    .showTermDocCountError(true)
                    .showTermDocCountError(true)  
                    client().prepareIndex("idx_fixed_docs_1")  
        assertSearchResponse(accurateResponse);
        assertSearchResponse(accurateResponse);
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
                    .field(LONG_FIELD_NAME)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .setId("" + i)
/*  
                    )  
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
                            .endObject()
                builders.add(
        shard1DocsPerTerm.put("Q", 6);
        int size = randomIntBetween(1, 20);
        int shardSize = randomIntBetween(size, size * 2);
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
            .addAggregation(
            )  
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")  
        assertNoDocCountError(size, accurateResponse, testResponse);  
     * 3 one-shard indices.  
            )
            )
                builders.add(
            )
    public void testLongValueFieldSingleShard() throws Exception {  
                    .field(STRING_FIELD_NAME)
                    .size(10000)
        assertSearchResponse(accurateResponse);
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
    public void testDoubleValueFieldTermSortAsc() throws Exception {
        shard1DocsPerTerm.put("J", 8);  
        assertThat(accurateTerms.getBuckets().size(), greaterThanOrEqualTo(testBuckets.size()));  
        int size = randomIntBetween(1, 20);  
        assertSearchResponse(testResponse);
            .addAggregation(
                    .size(10000)  
                    .field(STRING_FIELD_NAME)  
                    .order(BucketOrder.key(true))  
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")  
            assertThat(testBucket, notNullValue());
        assertSearchResponse(testResponse);  
    public void testFixedDocs() throws Exception {
            .addAggregation(
                    .size(size)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            .get();  
        // concurrent and non-concurrent search in the 1 slice case. TermsFixedDocCountErrorIT verifies that the doc count error is
        Bucket bucket = buckets.get(0);
        assertThat(accurateTerms.getDocCountError(), equalTo(0L));  
    public void testLongValueFieldDocCountAsc() throws Exception {
                    .showTermDocCountError(true)  
        int size = randomIntBetween(1, 20);
                    .field(LONG_FIELD_NAME)
                    .setId("" + i)
        assertThat(bucket.getDocCountError(), equalTo(29L));
                    .size(10000)
    public void testLongValueFieldTermSortAsc() throws Exception {  
    }
                    .size(size)  
                    .showTermDocCountError(true)  
            )
                terms("terms").executionHint(randomExecutionHint())
        shard2DocsPerTerm.put("G", 30);  
        int shardSize = randomIntBetween(size, size * 2);  
    }  
            .addAggregation(
                    .size(size)
            .get();  
                    .size(10000)
    public void testDoubleValueField() throws Exception {
        assertThat(bucket, notNullValue());
        assertThat(bucket.getDocCountError(), equalTo(15L));
        shard1DocsPerTerm.put("H", 14);  
            )
        shard0DocsPerTerm.put("J", 1);
            .get();
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .shardSize(shardSize)  
        }
    private void assertNoDocCountError(int size, SearchResponse accurateResponse, SearchResponse testResponse) {  
        int shardSize = randomIntBetween(size, size * 2);
    }
                    .showTermDocCountError(true)
            )
            .get();
        assertSearchResponse(testResponse);
                    .order(BucketOrder.key(false))  
        int size = randomIntBetween(1, 20);
import static org.opensearch.search.aggregations.AggregationBuilders.sum;  
        Terms accurateTerms = accurateResponse.getAggregations().get("terms");
    }
            .addAggregation(
                    .field(DOUBLE_FIELD_NAME)
 * compatible open source license.
                    .subAggregation(sum("sortAgg").field(LONG_FIELD_NAME))
                    .field(LONG_FIELD_NAME)  
                    .size(10000)
    }  
        assertSearchResponse(accurateResponse);  
import java.util.HashMap;  
                    .shardSize(shardSize)
        assertSearchResponse(accurateResponse);
                    .order(BucketOrder.aggregation("sortAgg", true))  
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
        assertThat(bucket, notNullValue());
        Map<String, Integer> shard1DocsPerTerm = new HashMap<>();  
                    .size(10000)  
        assertSearchResponse(accurateResponse);
                    .size(size)
                    .field(DOUBLE_FIELD_NAME)
            )
                    .shardSize(shardSize)  
    private void assertNoDocCountErrorSingleResponse(int size, SearchResponse testResponse) {
            )
                    .showTermDocCountError(true)
            .get();
            );
                    .field(STRING_FIELD_NAME)
     * Test a case where we know exactly how many of each term is on each shard
        assertSearchResponse(testResponse);  
                terms("terms").executionHint(randomExecutionHint())
                    .shardSize(shardSize)  
            assertThat(testBucket, notNullValue());  
            prepareCreate("idx_fixed_docs_2").setMapping(STRING_FIELD_NAME, "type=keyword")
            .addAggregation(
            .get();  
        assertSearchResponse(testResponse);
                    .shardSize(10000)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
        SearchResponse accurateResponse = client().prepareSearch("idx")  
                    .shardSize(shardSize)  
                            .field(STRING_FIELD_NAME, "val" + randomInt(numUniqueTerms))
                    .field(DOUBLE_FIELD_NAME)  
                terms("terms").executionHint(randomExecutionHint())  
            )
                    .size(size)
                    .showTermDocCountError(true)  
        assertSearchResponse(accurateResponse);
        shard0DocsPerTerm.put("B", 18);  
                    .field(STRING_FIELD_NAME)
        assertThat(bucket.getDocCount(), equalTo(100L));
                terms("terms").executionHint(randomExecutionHint())
                    .size(size)
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")  
            .addAggregation(
                    .field(STRING_FIELD_NAME)  
                    .shardSize(shardSize)
                            .field(LONG_FIELD_NAME, randomInt(numUniqueTerms))
            )  
    }
                    .shardSize(shardSize)
import org.opensearch.action.index.IndexRequestBuilder;  
                    .order(BucketOrder.count(true))  
        SearchResponse testResponse = client().prepareSearch("idx_with_routing")  
            )  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
    public void testDoubleValueFieldSubAggDesc() throws Exception {  
        int shardSize = randomIntBetween(size, size * 2);
            .setRouting(String.valueOf(between(1, numRoutingValues)))
                    client().prepareIndex("idx_fixed_docs_2")  
        assertSearchResponse(accurateResponse);  
import java.util.List;
        );  
            )
        assertThat(testTerms.getName(), equalTo("terms"));
            )
        assertThat(testBuckets.size(), lessThanOrEqualTo(size));  
            )
                    .showTermDocCountError(true)
                terms("terms").executionHint(randomExecutionHint())  
            )
                    .subAggregation(sum("sortAgg").field(LONG_FIELD_NAME))  
        assertSearchResponse(testResponse);
                    .field(DOUBLE_FIELD_NAME)
            .get();  
                    .size(size)
        assertUnboundedDocCountError(size, accurateResponse, testResponse);  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .order(BucketOrder.count(true))
                            .endObject()
            .addAggregation(
                    .size(10000)  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .field(STRING_FIELD_NAME)  
            .get();  
        int size = randomIntBetween(1, 20);  
        assertThat(accurateTerms.getBuckets().size(), greaterThanOrEqualTo(testBuckets.size()));
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
                terms("terms").executionHint(randomExecutionHint())  
                    .showTermDocCountError(true)  
        }
                    .showTermDocCountError(true)  
        assertThat(bucket.getDocCountError(), equalTo(2L));
        // Force merge each shard down to 1 segment to verify results are the same between concurrent and non-concurrent search paths, else
                    .size(size)
    }
                    .shardSize(10000)
 * under the License.  
            .get();
        int shardSize = randomIntBetween(size, size * 2);
                    )  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            )
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
     */
import static org.hamcrest.core.IsNull.notNullValue;
                    .subAggregation(sum("sortAgg").field(DOUBLE_FIELD_NAME))
        int shardSize = randomIntBetween(size, size * 2);
                client().prepareIndex("idx_single_shard")  
    public void setupSuiteScopeCluster() throws Exception {  
 * this work for additional information regarding copyright
        assertThat(buckets.size(), equalTo(5));
            .get();  
            .addAggregation(
                terms("terms").executionHint(randomExecutionHint())
        bucket = buckets.get(3);
                terms("terms").executionHint(randomExecutionHint())
            .addAggregation(
                        jsonBuilder().startObject()
                    .size(size)  
        Terms testTerms = testResponse.getAggregations().get("terms");
            Terms.Bucket accurateBucket = accurateTerms.getBucketByKey(testBucket.getKeyAsString());
                    .order(BucketOrder.aggregation("sortAgg", true))
        assertSearchResponse(accurateResponse);  
                    .field(LONG_FIELD_NAME)
 */  
                    .shardSize(5)  
 * Unless required by applicable law or agreed to in writing,
                    .shardSize(10000)
        assertSearchResponse(accurateResponse);
        assertThat(accurateTerms, notNullValue());
@OpenSearchIntegTestCase.SuiteScopeTestCase
                    .showTermDocCountError(true)
            Terms.Bucket testBucket = accurateTerms.getBucketByKey(accurateBucket.getKeyAsString());
        assertSearchResponse(accurateResponse);  
                );  
        shard0DocsPerTerm.put("D", 3);
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                        .setId(term + "-" + i)
        assertThat(accurateTerms.getDocCountError(), equalTo(0L));
        assertThat(bucket.getKey(), equalTo("A"));  
                    .order(BucketOrder.aggregation("sortAgg", false))
            )
                    .field(STRING_FIELD_NAME)  
        SearchResponse testResponse = client().prepareSearch("idx")
    public void testStringValueFieldSubAggAsc() throws Exception {
            }
            .get();
        int shardSize = randomIntBetween(size, size * 2);  
                    .size(size)
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")  
        );
                    .showTermDocCountError(true)
        shard0DocsPerTerm.put("F", 2);
            .addAggregation(  
                terms("terms").executionHint(randomExecutionHint())
            .get();
            .get();
                    .order(BucketOrder.aggregation("sortAgg", false))
        shard1DocsPerTerm.put("I", 10);
    }
                    .subAggregation(sum("sortAgg").field(DOUBLE_FIELD_NAME))
    }
                    .size(10000)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        shard1DocsPerTerm.put("A", 30);
            .get();
    public void testStringValueFieldWithRouting() throws Exception {
                    .shardSize(10000)  
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
                builders.add(  
 * Modifications Copyright OpenSearch Contributors. See
        assertSearchResponse(response);
            .addAggregation(
        numRoutingValues = between(1, 40);
        assertNoDocCountErrorSingleResponse(size, testResponse);  
    public TermsDocCountErrorIT(Settings staticSettings) {
        assertThat(testTerms.getName(), equalTo("terms"));
            )  
        int shardSize = randomIntBetween(size, size * 2);  
    public void testLongValueFieldSubAggAsc() throws Exception {
                assertThat(accurateBucket.getDocCount(), lessThanOrEqualTo(testTerms.getDocCountError()));  
        shard2DocsPerTerm.put("Z", 36);
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                    .showTermDocCountError(true)
                    .shardSize(shardSize)
                    .shardSize(shardSize)
        for (Terms.Bucket testBucket : testBuckets) {
        assertThat(testBuckets.size(), lessThanOrEqualTo(size));
        shard1DocsPerTerm.put("Z", 16);
        assertThat(bucket, notNullValue());
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                terms("terms").executionHint(randomExecutionHint())  
        assertThat(terms.getDocCountError(), equalTo(46L));
        }
                    .shardSize(shardSize)  
        int size = randomIntBetween(1, 20);
        int shardSize = randomIntBetween(size, size * 2);
                terms("terms").executionHint(randomExecutionHint())
            builders.add(  
                    .field(DOUBLE_FIELD_NAME)  
            .get();
            .addAggregation(
        assertDocCountErrorWithinBounds(size, accurateResponse, testResponse);  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        int size = randomIntBetween(1, 20);
            )
        for (int i = 0; i < numDocs; i++) {
        assertUnboundedDocCountError(size, accurateResponse, testResponse);  
                    .shardSize(shardSize)
import org.opensearch.test.OpenSearchIntegTestCase;  
    private static int numRoutingValues;  
        assertThat(bucket.getDocCount(), equalTo(52L));
public class TermsDocCountErrorIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                terms("terms").executionHint(randomExecutionHint())
                    .showTermDocCountError(true)
        assertSearchResponse(testResponse);  
                terms("terms").executionHint(randomExecutionHint())  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    .showTermDocCountError(true)
                    .shardSize(10000)  
                    .subAggregation(sum("sortAgg").field(LONG_FIELD_NAME))
            .addAggregation(
        assertThat(bucket.getKey(), equalTo("Z"));  
 * the Apache License, Version 2.0 (the "License"); you may
        int size = randomIntBetween(1, 20);
                    .order(BucketOrder.aggregation("sortAgg", true))
            .get();
        assertSearchResponse(testResponse);
                    .subAggregation(sum("sortAgg").field(LONG_FIELD_NAME))
        for (Map.Entry<String, Integer> entry : shard1DocsPerTerm.entrySet()) {
        assertNoDocCountErrorSingleResponse(size, testResponse);
        assertThat(testTerms, notNullValue());
        bucket = buckets.get(1);
                terms("terms").executionHint(randomExecutionHint())
                    .size(size)
                    .order(BucketOrder.aggregation("sortAgg", true))
    }  
        int numDocs = between(10, 200);  
        assertSearchResponse(accurateResponse);  
        int shardSize = randomIntBetween(size, size * 2);  
                    .size(size)  
        assertAcked(
    public void testLongValueField() throws Exception {
        assertThat(accurateTerms.getName(), equalTo("terms"));
                    .shardSize(10000)  
        assertSearchResponse(testResponse);
                    .field(DOUBLE_FIELD_NAME)  
        int size = randomIntBetween(1, 20);  
        assertAcked(prepareCreate("idx_with_routing").setMapping("{ \"_routing\" : { \"required\" : true } }"));  
                    .showTermDocCountError(true)
            .get();
            }
                    .size(size)  
            assertThat(accurateBucket.getDocCountError(), equalTo(0L));  
            .get();
        for (int i = 0; i < numDocs; i++) {
                    .showTermDocCountError(true)
        int numUniqueTerms = between(2, numDocs / 2);
        assertSearchResponse(testResponse);
    }  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
            .addAggregation(
            .addAggregation(
        for (Terms.Bucket testBucket : testBuckets) {
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertSearchResponse(testResponse);  
        int size = randomIntBetween(1, 20);
            builders.add(
                    .setId("" + i)
        assertThat(bucket.getKey(), equalTo("B"));  
        int shardSize = randomIntBetween(size, size * 2);  
                    .shardSize(shardSize)
                        jsonBuilder().startObject()  
                terms("terms").executionHint(randomExecutionHint())
            .get();
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
                    .showTermDocCountError(true)  
                    .setSource(  
        assertSearchResponse(testResponse);
        assertThat(testTerms.getDocCountError(), equalTo(0L));  
        for (Terms.Bucket testBucket : testBuckets) {  
    public void testStringValueFieldSubAggDesc() throws Exception {
                    .shardSize(10000)
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")  
        int shardSize = randomIntBetween(size, size * 2);
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
                            .field(LONG_FIELD_NAME, randomInt(numUniqueTerms))  
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")  
                    .showTermDocCountError(true)  
        assertUnboundedDocCountError(size, accurateResponse, testResponse);
                String term = entry.getKey();
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
    public void testDoubleValueFieldSubAggAsc() throws Exception {  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertNoDocCountErrorSingleResponse(size, testResponse);
        SearchResponse testResponse = client().prepareSearch("idx")  
                    .size(10000)
        assertThat(testBuckets.size(), lessThanOrEqualTo(size));
                        .setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, term).field("shard", 1).endObject())
        assertAcked(
        int shardSize = randomIntBetween(size, size * 2);
                    .shardSize(10000)  
                client().prepareIndex("idx")
            .get();  
        assertUnboundedDocCountError(size, accurateResponse, testResponse);
            if (testBucket == null) {
        assertThat(testTerms.getName(), equalTo("terms"));  
import org.opensearch.common.settings.Settings;  
    }
            .get();
                    .showTermDocCountError(true)
            prepareCreate("idx_single_shard").setMapping(STRING_FIELD_NAME, "type=keyword")
        assertSearchResponse(accurateResponse);  
        assertThat(accurateTerms.getName(), equalTo("terms"));
                    .shardSize(10000)  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
        Terms testTerms = testResponse.getAggregations().get("terms");  
 */
            )
package org.opensearch.search.aggregations.bucket;
            assertThat(accurateBucket, notNullValue());
            assertThat(accurateBucket, notNullValue());  
        for (Map.Entry<String, Integer> entry : shard2DocsPerTerm.entrySet()) {
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
                    .size(10000)
            .get();
            .addAggregation(  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        bucket = buckets.get(4);
        assertThat(terms, notNullValue());
            .addAggregation(
            .get();
        int shardSize = randomIntBetween(size, size * 2);
        assertSearchResponse(testResponse);
        assertThat(bucket, notNullValue());
                terms("terms").executionHint(randomExecutionHint())  
        refresh();
        assertSearchResponse(testResponse);
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
                    .showTermDocCountError(true)
                            .field(STRING_FIELD_NAME, "val" + randomInt(numUniqueTerms))
        int shardSize = randomIntBetween(size, size * 2);
                terms("terms").executionHint(randomExecutionHint())
                    .shardSize(10000)
                    .shardSize(shardSize)
        assertDocCountErrorWithinBounds(size, accurateResponse, testResponse);
                    .size(size)
                    .order(BucketOrder.count(true))  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                terms("terms").executionHint(randomExecutionHint())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .get();
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
            )
            .addAggregation(
                    .field(LONG_FIELD_NAME)  
            .get();  
        List<? extends Bucket> buckets = terms.getBuckets();  
            .get();  
            )  
            .get();
                terms("terms").executionHint(randomExecutionHint())  
            .get();  
        shard0DocsPerTerm.put("C", 6);
                    .shardSize(10000)  
 */  
 * KIND, either express or implied.  See the License for the
        }
            )  
            .addAggregation(  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                terms("terms").executionHint(randomExecutionHint())
        for (Terms.Bucket accurateBucket : accurateTerms.getBuckets()) {
                    .size(10000)
    /**  
            );  
        assertThat(accurateTerms.getBuckets().size(), greaterThanOrEqualTo(testBuckets.size()));
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
                    .order(BucketOrder.key(false))
    public void testLongValueFieldSubAggDesc() throws Exception {
            .get();
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
        assertUnboundedDocCountError(size, accurateResponse, testResponse);
            )  
            assertThat(testBucket.getDocCountError(), anyOf(equalTo(-1L), equalTo(0L)));
    private static final String LONG_FIELD_NAME = "l_value";
                    .showTermDocCountError(true)
import org.opensearch.search.aggregations.bucket.terms.TermsAggregatorFactory.ExecutionMode;
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
                    .showTermDocCountError(true)  
                    .shardSize(10000)
            .get();
     * so we know the exact error value for each term. To do this we search over
                    .shardSize(shardSize)
    public void testStringValueFieldSingleShard() throws Exception {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
    public void testStringValueField() throws Exception {  
        assertSearchResponse(testResponse);
            .addAggregation(
        shard0DocsPerTerm.put("I", 1);
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")  
        assertThat(testTerms.getDocCountError(), anyOf(equalTo(-1L), equalTo(0L)));
            )
                terms("terms").executionHint(randomExecutionHint())
                    .showTermDocCountError(true)  
        assertSearchResponse(testResponse);
        assertThat(testTerms, notNullValue());  
        assertThat(bucket, notNullValue());
            )
import java.util.Arrays;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    }  
            assertThat(accurateBucket.getDocCountError(), equalTo(0L));
        assertNoDocCountError(size, accurateResponse, testResponse);
        assertSearchResponse(accurateResponse);
                    .size(size)
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")  
        int size = randomIntBetween(1, 20);
        SearchResponse testResponse = client().prepareSearch("idx")
                    .showTermDocCountError(true)
        assertThat(testTerms.getName(), equalTo("terms"));
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
                    .field(DOUBLE_FIELD_NAME)  
        );
            )  
            .get();  
    }
        int shardSize = randomIntBetween(size, size * 2);  
                terms("terms").executionHint(randomExecutionHint())
                    .showTermDocCountError(true)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")  
                    .order(BucketOrder.count(true))
 *
        SearchResponse testResponse = client().prepareSearch("idx_with_routing")
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1))
    private void assertUnboundedDocCountError(int size, SearchResponse accurateResponse, SearchResponse testResponse) {
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")  
                terms("terms").executionHint(randomExecutionHint())
    }  
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
    }
import java.util.Map;
    }
                    .setSource(  
            .get();
                    .showTermDocCountError(true)  
                terms("terms").executionHint(randomExecutionHint())  
        shard1DocsPerTerm.put("G", 15);
        assertDocCountErrorWithinBounds(size, accurateResponse, testResponse);
    @Override
                    .shardSize(shardSize)
                    .shardSize(shardSize)  
        assertThat(testTerms, notNullValue());
        shard0DocsPerTerm.put("G", 2);
                    .showTermDocCountError(true)  
                    .size(size)  
            for (int i = 0; i < entry.getValue(); i++) {
            Terms.Bucket accurateBucket = accurateTerms.getBucketByKey(testBucket.getKeyAsString());  
 * SPDX-License-Identifier: Apache-2.0
        SearchResponse accurateResponse = client().prepareSearch("idx")
                    .shardSize(10000)
                String term = entry.getKey();
                    .order(BucketOrder.aggregation("sortAgg", false))  
            .get();
            prepareCreate("idx_fixed_docs_0").setMapping(STRING_FIELD_NAME, "type=keyword")
                    .setSource(
                    .size(10000)
        }
        List<? extends Bucket> testBuckets = testTerms.getBuckets();
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
        assertThat(bucket.getDocCountError(), equalTo(0L));
        List<IndexRequestBuilder> builders = new ArrayList<>();
        assertSearchResponse(testResponse);  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            )
            .addAggregation(  
        forceMerge(1);
 * specific language governing permissions and limitations
                    .order(BucketOrder.key(false))  
            for (int i = 0; i < entry.getValue(); i++) {  
            assertThat(accurateBucket, notNullValue());  
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")  
            )
                    .field(DOUBLE_FIELD_NAME)  
            }
                    .field(LONG_FIELD_NAME)  
                    .subAggregation(sum("sortAgg").field(LONG_FIELD_NAME))
            .addAggregation(
            .addAggregation(
        assertThat(bucket.getDocCountError(), equalTo(2L));
                terms("terms").executionHint(randomExecutionHint())  
        int size = randomIntBetween(1, 20);  
            .get();
                    .shardSize(10000)
            .get();
                terms("terms").executionHint(randomExecutionHint())
                terms("terms").executionHint(randomExecutionHint())
                terms("terms").executionHint(randomExecutionHint())  
        int shardSize = randomIntBetween(size, size * 2);  
        for (int i = 0; i < numDocs; i++) {
        }  
            )
        shard2DocsPerTerm.put("A", 45);  
                    .showTermDocCountError(true)  
            Terms.Bucket accurateBucket = accurateTerms.getBucketByKey(testBucket.getKeyAsString());
        shard2DocsPerTerm.put("C", 44);
            .addAggregation(
    public void testLongValueFieldWithRouting() throws Exception {
        return randomBoolean() ? null : randomFrom(ExecutionMode.values()).toString();  
                    .order(BucketOrder.key(true))
        int size = randomIntBetween(1, 20);  
                    .subAggregation(sum("sortAgg").field(LONG_FIELD_NAME))
        shard2DocsPerTerm.put("E", 29);
        indexRandom(true, builders);
                    .showTermDocCountError(true)
        assertThat(bucket.getDocCount(), equalTo(45L));
        }  
                        .setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, term).endObject())  
                    .showTermDocCountError(true)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            )
            .get();  
    }  
        int shardSize = randomIntBetween(size, size * 2);  
 * You may obtain a copy of the License at  
        shard2DocsPerTerm.put("D", 1);
                terms("terms").executionHint(randomExecutionHint())
    public void testLongValueFieldTermSortDesc() throws Exception {
        for (Terms.Bucket testBucket : testBuckets) {
            .get();  
                    .order(BucketOrder.count(true))
        SearchResponse response = client().prepareSearch("idx_fixed_docs_0", "idx_fixed_docs_1", "idx_fixed_docs_2")  
                        .setId(term + "-" + i)
 * license agreements. See the NOTICE file distributed with
        // correctly calculated for concurrent segment search at the slice level.
        assertThat(testTerms.getDocCountError(), equalTo(0L));  
                    .showTermDocCountError(true)
        SearchResponse testResponse = client().prepareSearch("idx_with_routing")
            )
        assertNoDocCountError(size, accurateResponse, testResponse);
        assertSearchResponse(accurateResponse);
                    .field(DOUBLE_FIELD_NAME)
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
                    .showTermDocCountError(true)
        int shardSize = randomIntBetween(size, size * 2);
                    .showTermDocCountError(true)
            )
            assertThat(testBucket, notNullValue());
        int size = randomIntBetween(1, 20);
            .addAggregation(
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
    }
                    .field(LONG_FIELD_NAME)
            prepareCreate("idx_fixed_docs_1").setMapping(STRING_FIELD_NAME, "type=keyword")  
        int size = randomIntBetween(1, 20);  
    public void testStringValueFieldDocCountAsc() throws Exception {
                terms("terms").executionHint(randomExecutionHint())
        assertUnboundedDocCountError(size, accurateResponse, testResponse);  
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")  
        assertSearchResponse(testResponse);
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .shardSize(10000)
        assertSearchResponse(testResponse);
                terms("terms").executionHint(randomExecutionHint())
            assertThat(accurateBucket.getDocCountError(), equalTo(0L));
        int size = randomIntBetween(1, 20);
        int size = randomIntBetween(1, 20);
                    .shardSize(shardSize)  
        assertSearchResponse(testResponse);  
    }
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
                    .size(size)
                    .field(LONG_FIELD_NAME)
                    .order(BucketOrder.aggregation("sortAgg", false))
                    .order(BucketOrder.aggregation("sortAgg", true))  
                    .shardSize(shardSize)
            .addAggregation(
        int size = randomIntBetween(1, 20);
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
                terms("terms").executionHint(randomExecutionHint())
        shard0DocsPerTerm.put("A", 25);
        assertSearchResponse(accurateResponse);
            .addAggregation(  
            .addAggregation(  
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
            )  
                    .size(10000)
        Terms accurateTerms = accurateResponse.getAggregations().get("terms");  
            .get();
                    .size(size)
        return Arrays.asList(
import org.opensearch.cluster.metadata.IndexMetadata;
    }  
                        jsonBuilder().startObject()
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1))
            .addAggregation(
        assertAcked(  
    public void testDoubleValueFieldTermSortDesc() throws Exception {
            }
    public void testDoubleValueFieldDocCountAsc() throws Exception {  
        );  
            .addAggregation(  
        assertSearchResponse(accurateResponse);
                    .field(STRING_FIELD_NAME)
    }  
        // for concurrent segment search there will be additional error introduced during the slice level reduce and thus different buckets,
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .shardSize(10000)
                terms("terms").executionHint(randomExecutionHint())
            assertThat(testBucket.getDocCountError(), equalTo(0L));  
    private void assertDocCountErrorWithinBounds(int size, SearchResponse accurateResponse, SearchResponse testResponse) {
    public void testStringValueFieldTermSortDesc() throws Exception {  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            .addAggregation(
                    .showTermDocCountError(true)
                    .shardSize(shardSize)
        Terms testTerms = testResponse.getAggregations().get("terms");
import java.util.Collection;
            assertThat(accurateBucket, notNullValue());
            .setRouting(String.valueOf(between(1, numRoutingValues)))  
            )  
        Map<String, Integer> shard2DocsPerTerm = new HashMap<>();
                    .size(size)  
        assertNoDocCountError(size, accurateResponse, testResponse);
        assertThat(bucket.getKey(), equalTo("G"));  
}
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 * not use this file except in compliance with the License.
        int size = randomIntBetween(1, 20);
/*  
            )  
                    .shardSize(shardSize)
        for (Map.Entry<String, Integer> entry : shard0DocsPerTerm.entrySet()) {  
            .addAggregation(  
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
                    .size(size)
                    .showTermDocCountError(true)  
                    .field(DOUBLE_FIELD_NAME)
            .get();
                            .field(DOUBLE_FIELD_NAME, 1.0 * randomInt(numUniqueTerms))  
        assertThat(bucket.getDocCount(), equalTo(43L));
                    .shardSize(10000)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
                terms("terms").executionHint(randomExecutionHint())
                    .field(LONG_FIELD_NAME)
        List<? extends Bucket> testBuckets = testTerms.getBuckets();
 *
        bucket = buckets.get(2);
                    .field(STRING_FIELD_NAME)  
    }  
                        .setId(term + "-" + i)
                    .field(STRING_FIELD_NAME)
        Map<String, Integer> shard0DocsPerTerm = new HashMap<>();
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
                    .size(10000)  
        SearchResponse accurateResponse = client().prepareSearch("idx")
                terms("terms").executionHint(randomExecutionHint())  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
    public void testDoubleValueFieldWithRouting() throws Exception {  
                            .endObject()
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1))
                    .showTermDocCountError(true)
            builders.add(
        List<? extends Bucket> testBuckets = testTerms.getBuckets();  
                    .size(10000)  
                    .size(10000)
                    .field(LONG_FIELD_NAME)
                            .field(DOUBLE_FIELD_NAME, 1.0 * randomInt(numUniqueTerms))
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                    .shardSize(shardSize)
            )
        assertThat(testTerms, notNullValue());
                terms("terms").executionHint(randomExecutionHint())
            )  
            .addAggregation(  
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
        assertSearchResponse(accurateResponse);
        shard2DocsPerTerm.put("Q", 2);  
            )
                    .field(DOUBLE_FIELD_NAME)
                    .subAggregation(sum("sortAgg").field(LONG_FIELD_NAME))
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
                );
                    .subAggregation(sum("sortAgg").field(LONG_FIELD_NAME))  
            assertThat(testBucket.getDocCount() - testBucket.getDocCountError(), lessThanOrEqualTo(accurateBucket.getDocCount()));
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        int size = randomIntBetween(1, 20);
        }
                    .order(BucketOrder.key(true))
                    .subAggregation(sum("sortAgg").field(LONG_FIELD_NAME))  
        int size = randomIntBetween(1, 20);
    }  
import static org.hamcrest.Matchers.equalTo;
        assertSearchResponse(testResponse);
                    .showTermDocCountError(true)
            .get();
                    .size(10000)
            .get();  
                String term = entry.getKey();
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
                    .field(STRING_FIELD_NAME)
 * GitHub history for details.
        int shardSize = randomIntBetween(size, size * 2);
                terms("terms").executionHint(randomExecutionHint())
                    .size(10000)  
        );
                terms("terms").executionHint(randomExecutionHint())
                    .order(BucketOrder.key(false))
            )
        Terms accurateTerms = accurateResponse.getAggregations().get("terms");
                    .field(STRING_FIELD_NAME)
        assertSearchResponse(testResponse);
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1))  
                    .showTermDocCountError(true)
            .addAggregation(  
                    .showTermDocCountError(true)
        assertThat(accurateTerms.getName(), equalTo("terms"));  
                    .setRouting(String.valueOf(randomInt(numRoutingValues)))
                    .field(DOUBLE_FIELD_NAME)
        super(staticSettings);  
            .addAggregation(
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertNoDocCountError(size, accurateResponse, testResponse);
                    .size(size)  
    }
                            .field(LONG_FIELD_NAME, randomInt(numUniqueTerms))  
                    .field(LONG_FIELD_NAME)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .field(DOUBLE_FIELD_NAME)
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
        assertSearchResponse(testResponse);  
                    .order(BucketOrder.key(false))
            )
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
                    .order(BucketOrder.key(true))
                    .size(10000)  
    }
            .addAggregation(
                    .subAggregation(sum("sortAgg").field(LONG_FIELD_NAME))  
                        .setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, term).field("shard", 2).endObject())
        shard1DocsPerTerm.put("B", 25);
            assertThat(testBucket.getDocCountError(), lessThanOrEqualTo(testTerms.getDocCountError()));  
        Terms terms = response.getAggregations().get("terms");  
        int shardSize = randomIntBetween(size, size * 2);
            .addAggregation(  
    private static final String STRING_FIELD_NAME = "s_value";
        assertNoDocCountError(size, accurateResponse, testResponse);  
            )  
        assertThat(accurateTerms.getDocCountError(), equalTo(0L));
    }
            .addAggregation(  
            .setRouting(String.valueOf(between(1, numRoutingValues)))
    public void testStringValueFieldTermSortAsc() throws Exception {
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
                    .showTermDocCountError(true)
                client().prepareIndex("idx_single_shard")  
                    .shardSize(10000)
/*
        shard0DocsPerTerm.put("H", 2);  
                    .shardSize(shardSize)
 * The OpenSearch Contributors require contributions made to  
                terms("terms").executionHint(randomExecutionHint())  
        Terms testTerms = testResponse.getAggregations().get("terms");  
        assertNoDocCountError(size, accurateResponse, testResponse);  
            .get();
            )
    public static String randomExecutionHint() {
            .addAggregation(
        assertSearchResponse(testResponse);  
                terms("terms").executionHint(randomExecutionHint())
import static org.hamcrest.Matchers.anyOf;
import org.opensearch.search.aggregations.BucketOrder;
        assertUnboundedDocCountError(size, accurateResponse, testResponse);
                terms("terms").executionHint(randomExecutionHint())
            .get();
        shard1DocsPerTerm.put("F", 17);  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .get();  
import org.opensearch.action.search.SearchResponse;
 * Licensed to Elasticsearch under one or more contributor  
        }
