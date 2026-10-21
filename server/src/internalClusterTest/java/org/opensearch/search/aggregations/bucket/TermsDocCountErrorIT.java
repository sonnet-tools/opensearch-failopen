        shard0DocsPerTerm.put("A", 25);
        shard1DocsPerTerm.put("J", 8);
            )
                    .shardSize(10000)
        for (Terms.Bucket testBucket : testBuckets) {
                            .field(DOUBLE_FIELD_NAME, 1.0 * randomInt(numUniqueTerms))
                    .shardSize(shardSize)
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
                    .order(BucketOrder.aggregation("sortAgg", false))
                    .shardSize(shardSize)
        assertSearchResponse(accurateResponse);
                    .subAggregation(sum("sortAgg").field(LONG_FIELD_NAME))
                terms("terms").executionHint(randomExecutionHint())
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
                    .shardSize(10000)
                            .field(STRING_FIELD_NAME, "val" + randomInt(numUniqueTerms))
            )
                    .order(BucketOrder.aggregation("sortAgg", true))
        shard1DocsPerTerm.put("H", 14);
                    .field(LONG_FIELD_NAME)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .field(STRING_FIELD_NAME)
        Map<String, Integer> shard0DocsPerTerm = new HashMap<>();
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1))
            .setRouting(String.valueOf(between(1, numRoutingValues)))
                        jsonBuilder().startObject()
            }
        assertThat(bucket, notNullValue());
                terms("terms").executionHint(randomExecutionHint())
            .addAggregation(
            .addAggregation(
                    .field(LONG_FIELD_NAME)
        int size = randomIntBetween(1, 20);
 * under the License.
                    .order(BucketOrder.key(true))
            )
        for (Map.Entry<String, Integer> entry : shard1DocsPerTerm.entrySet()) {
        assertThat(testTerms.getDocCountError(), anyOf(equalTo(-1L), equalTo(0L)));
    public void testDoubleValueFieldSingleShard() throws Exception {
                    .shardSize(shardSize)
        assertSearchResponse(testResponse);
        }
        assertNoDocCountError(size, accurateResponse, testResponse);
 * Licensed to Elasticsearch under one or more contributor
        assertSearchResponse(testResponse);
                    .size(size)
                    .shardSize(10000)
            )
        }
                    .showTermDocCountError(true)
                    .setSource(
            .addAggregation(
                    .size(10000)
    }
            for (int i = 0; i < entry.getValue(); i++) {
                    .field(STRING_FIELD_NAME)
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
        assertThat(accurateTerms.getName(), equalTo("terms"));
            )
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
                    .field(LONG_FIELD_NAME)
        shard0DocsPerTerm.put("E", 2);
            .get();
 * license agreements. See the NOTICE file distributed with
                    .field(LONG_FIELD_NAME)
            )
        List<? extends Bucket> testBuckets = testTerms.getBuckets();
                    .field(DOUBLE_FIELD_NAME)
                terms("terms").executionHint(randomExecutionHint())
        // correctly calculated for concurrent segment search at the slice level.
                    .shardSize(shardSize)
            )
    }
    public void testLongValueFieldSingleShard() throws Exception {
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .size(10000)
        assertThat(bucket.getDocCount(), equalTo(45L));
                    .field(DOUBLE_FIELD_NAME)
        assertThat(accurateTerms, notNullValue());
                    .size(size)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(accurateTerms, notNullValue());
                    .showTermDocCountError(true)
        shard0DocsPerTerm.put("H", 2);
        SearchResponse testResponse = client().prepareSearch("idx_with_routing")
@OpenSearchIntegTestCase.SuiteScopeTestCase
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
                terms("terms").executionHint(randomExecutionHint())
    public void testLongValueFieldSubAggAsc() throws Exception {
                    .order(BucketOrder.aggregation("sortAgg", true))
        int shardSize = randomIntBetween(size, size * 2);
            .addAggregation(
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            .addAggregation(
        for (Map.Entry<String, Integer> entry : shard0DocsPerTerm.entrySet()) {
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
                terms("terms").executionHint(randomExecutionHint())
        assertThat(bucket.getDocCountError(), equalTo(15L));
            }
                        .setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, term).field("shard", 1).endObject())
            .addAggregation(
                        .setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, term).endObject())
                    .size(size)
            )
        return Arrays.asList(
            )
    public void testDoubleValueFieldWithRouting() throws Exception {
                    .size(size)
        List<IndexRequestBuilder> builders = new ArrayList<>();
                    .showTermDocCountError(true)
                    .size(size)
        int shardSize = randomIntBetween(size, size * 2);
                    .shardSize(10000)
            .addAggregation(
                    .showTermDocCountError(true)
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
            .addAggregation(
                    .size(size)
                    .shardSize(10000)
        bucket = buckets.get(2);
                terms("terms").executionHint(randomExecutionHint())
                    .field(STRING_FIELD_NAME)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        int shardSize = randomIntBetween(size, size * 2);
                    .shardSize(10000)
                    .shardSize(10000)
                client().prepareIndex("idx")
        List<? extends Bucket> testBuckets = testTerms.getBuckets();
            )
                    .field(LONG_FIELD_NAME)
                    .showTermDocCountError(true)
    }
                    .showTermDocCountError(true)
            .get();
                    .subAggregation(sum("sortAgg").field(LONG_FIELD_NAME))
    }
            .get();
            .addAggregation(
                    .size(10000)
        int numDocs = between(10, 200);
        // Force merge each shard down to 1 segment to verify results are the same between concurrent and non-concurrent search paths, else
        assertUnboundedDocCountError(size, accurateResponse, testResponse);
                    .field(DOUBLE_FIELD_NAME)
            )
                    .showTermDocCountError(true)
    public void testStringValueFieldDocCountAsc() throws Exception {
                            .endObject()
                    .showTermDocCountError(true)
                terms("terms").executionHint(randomExecutionHint())
        }
                    .field(DOUBLE_FIELD_NAME)
                    .subAggregation(sum("sortAgg").field(LONG_FIELD_NAME))
                    .setId("" + i)
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
            .addAggregation(
                    .order(BucketOrder.key(true))
        assertAcked(
        SearchResponse testResponse = client().prepareSearch("idx")
                            .field(LONG_FIELD_NAME, randomInt(numUniqueTerms))
    private static final String LONG_FIELD_NAME = "l_value";
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                    .shardSize(10000)
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertThat(testTerms, notNullValue());
        int shardSize = randomIntBetween(size, size * 2);
                    client().prepareIndex("idx_fixed_docs_2")
                terms("terms").executionHint(randomExecutionHint())
                    .size(size)
        shard2DocsPerTerm.put("H", 28);
        shard0DocsPerTerm.put("F", 2);
                    .showTermDocCountError(true)
        assertThat(testBuckets.size(), lessThanOrEqualTo(size));
            }
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertAcked(
                String term = entry.getKey();
        for (Terms.Bucket testBucket : testBuckets) {
                    .subAggregation(sum("sortAgg").field(LONG_FIELD_NAME))
            .get();
    }
            )
                builders.add(
                terms("terms").executionHint(randomExecutionHint())
    }
        assertSearchResponse(accurateResponse);
                client().prepareIndex("idx_single_shard")
                    .showTermDocCountError(true)
            )
                terms("terms").executionHint(randomExecutionHint())
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            .addAggregation(
                    .field(DOUBLE_FIELD_NAME)
        int shardSize = randomIntBetween(size, size * 2);
            .get();
            .addAggregation(
        int shardSize = randomIntBetween(size, size * 2);
                    .showTermDocCountError(true)
                    .showTermDocCountError(true)
        assertUnboundedDocCountError(size, accurateResponse, testResponse);
        shard2DocsPerTerm.put("G", 30);
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1))
        }
        int size = randomIntBetween(1, 20);
 * The OpenSearch Contributors require contributions made to
                    .size(10000)
                    .field(LONG_FIELD_NAME)
    }
    public void testStringValueFieldTermSortDesc() throws Exception {
    public void testStringValueField() throws Exception {
        int shardSize = randomIntBetween(size, size * 2);
                    .size(10000)
                    .order(BucketOrder.count(true))
            .addAggregation(
    public void testDoubleValueFieldTermSortAsc() throws Exception {
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
        int shardSize = randomIntBetween(size, size * 2);
                terms("terms").executionHint(randomExecutionHint())
        refresh();
        );
                        jsonBuilder().startObject()
                    .size(10000)
        shard2DocsPerTerm.put("C", 44);
        // doc_counts, and doc_count_errors may be returned. This test serves to verify that the doc_count_error is the same between
                terms("terms").executionHint(randomExecutionHint())
                    .order(BucketOrder.aggregation("sortAgg", true))
            .get();
        bucket = buckets.get(4);
            .addAggregation(
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
import static org.hamcrest.Matchers.equalTo;
                    .field(LONG_FIELD_NAME)
import java.util.Collection;
                    .field(DOUBLE_FIELD_NAME)
        assertSearchResponse(testResponse);
                    .size(size)
                    .size(10000)
                    .size(10000)
        Terms terms = response.getAggregations().get("terms");
    public void testStringValueFieldTermSortAsc() throws Exception {
            .get();
                );
        assertSearchResponse(testResponse);
                    .order(BucketOrder.aggregation("sortAgg", false))
        assertThat(bucket.getDocCountError(), equalTo(2L));
    public void testLongValueFieldTermSortDesc() throws Exception {
                    .shardSize(shardSize)
            assertThat(accurateBucket.getDocCountError(), equalTo(0L));
    }
                    .field(DOUBLE_FIELD_NAME)
                terms("terms").executionHint(randomExecutionHint())
                    .size(10000)
    /**
            .get();
            prepareCreate("idx_fixed_docs_0").setMapping(STRING_FIELD_NAME, "type=keyword")
                    .showTermDocCountError(true)
                    .order(BucketOrder.key(false))
                    .shardSize(shardSize)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                terms("terms").executionHint(randomExecutionHint())
                            .field(DOUBLE_FIELD_NAME, 1.0 * randomInt(numUniqueTerms))
                    .showTermDocCountError(true)
        for (int i = 0; i < numDocs; i++) {
        ensureSearchable();
            .addAggregation(
        assertThat(testTerms, notNullValue());
    private void assertNoDocCountError(int size, SearchResponse accurateResponse, SearchResponse testResponse) {
                            .field(LONG_FIELD_NAME, randomInt(numUniqueTerms))
            .get();
 */
                terms("terms").executionHint(randomExecutionHint())
        assertSearchResponse(accurateResponse);
        assertSearchResponse(testResponse);
                    .shardSize(shardSize)
        Terms accurateTerms = accurateResponse.getAggregations().get("terms");
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                terms("terms").executionHint(randomExecutionHint())
    public TermsDocCountErrorIT(Settings staticSettings) {
        assertUnboundedDocCountError(size, accurateResponse, testResponse);
                    .subAggregation(sum("sortAgg").field(DOUBLE_FIELD_NAME))
        int size = randomIntBetween(1, 20);
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
    private static int numRoutingValues;
import static org.hamcrest.Matchers.anyOf;
}
        assertSearchResponse(accurateResponse);
                terms("terms").executionHint(randomExecutionHint())
        assertSearchResponse(testResponse);
                terms("terms").executionHint(randomExecutionHint())
        SearchResponse testResponse = client().prepareSearch("idx_with_routing")
                    .order(BucketOrder.count(true))
            )
                            .field(LONG_FIELD_NAME, randomInt(numUniqueTerms))
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1))
 * ownership. Elasticsearch licenses this file to you under
    public void testStringValueFieldSingleShard() throws Exception {
                terms("terms").executionHint(randomExecutionHint())
            )
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
        shard2DocsPerTerm.put("D", 1);
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            assertThat(testBucket.getDocCountError(), lessThanOrEqualTo(testTerms.getDocCountError()));
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
 * specific language governing permissions and limitations
            .get();
            );
                    client().prepareIndex("idx_fixed_docs_1")
                    .field(DOUBLE_FIELD_NAME)
            )
                terms("terms").executionHint(randomExecutionHint())
            )
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
    }
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .shardSize(10000)
        assertThat(accurateTerms.getDocCountError(), equalTo(0L));
        assertSearchResponse(response);
                terms("terms").executionHint(randomExecutionHint())
        assertThat(testBuckets.size(), lessThanOrEqualTo(size));
            assertThat(testBucket.getDocCountError(), equalTo(0L));
 */
                    .showTermDocCountError(true)
                    .shardSize(shardSize)
    }
            .addAggregation(
import org.opensearch.action.index.IndexRequestBuilder;
        shard1DocsPerTerm.put("Z", 16);
                builders.add(
        int size = randomIntBetween(1, 20);
                terms("terms").executionHint(randomExecutionHint())
                    .shardSize(10000)
        shard0DocsPerTerm.put("I", 1);
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
                    .order(BucketOrder.count(true))
     */
        assertThat(testTerms.getName(), equalTo("terms"));
            .addAggregation(
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
            assertThat(testBucket, notNullValue());
                    .shardSize(10000)
        assertNoDocCountError(size, accurateResponse, testResponse);
        assertSearchResponse(testResponse);
 *
            )
            assertThat(testBucket.getDocCountError(), anyOf(equalTo(-1L), equalTo(0L)));
    }
        int size = randomIntBetween(1, 20);
        int shardSize = randomIntBetween(size, size * 2);
                terms("terms").executionHint(randomExecutionHint())
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .size(10000)
            .get();
            .addAggregation(
        assertSearchResponse(testResponse);
            .get();
        SearchResponse testResponse = client().prepareSearch("idx")
        assertThat(testTerms.getName(), equalTo("terms"));
/*
        int size = randomIntBetween(1, 20);
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            )
            )
                    .showTermDocCountError(true)
                terms("terms").executionHint(randomExecutionHint())
                terms("terms").executionHint(randomExecutionHint())
            )
    public static Collection<Object[]> parameters() {
                terms("terms").executionHint(randomExecutionHint())
                    .showTermDocCountError(true)
            )
        assertUnboundedDocCountError(size, accurateResponse, testResponse);
                    .setRouting(String.valueOf(randomInt(numRoutingValues)))
            .addAggregation(
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            .get();
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        // for concurrent segment search there will be additional error introduced during the slice level reduce and thus different buckets,
                terms("terms").executionHint(randomExecutionHint())
        assertThat(testBuckets.size(), lessThanOrEqualTo(size));
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .showTermDocCountError(true)
                    .field(DOUBLE_FIELD_NAME)
 * software distributed under the License is distributed on an
                assertThat(accurateBucket.getDocCount(), lessThanOrEqualTo(testTerms.getDocCountError()));
    public void testLongValueFieldWithRouting() throws Exception {
import org.opensearch.common.settings.Settings;
    }
                    .size(10000)
                    .shardSize(shardSize)
            .get();
import org.opensearch.test.OpenSearchIntegTestCase;
                    )
                terms("terms").executionHint(randomExecutionHint())
    }
     * 3 one-shard indices.
        int numUniqueTerms = between(2, numDocs / 2);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    .field(LONG_FIELD_NAME)
                    .order(BucketOrder.key(false))
            assertThat(accurateBucket, notNullValue());
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1))
                    .showTermDocCountError(true)
        int size = randomIntBetween(1, 20);
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertSearchResponse(testResponse);
                        .setId(term + "-" + i)
                    .subAggregation(sum("sortAgg").field(LONG_FIELD_NAME))
        assertSearchResponse(accurateResponse);
 * KIND, either express or implied.  See the License for the
        assertThat(bucket.getKey(), equalTo("C"));
        }
            .get();
        shard0DocsPerTerm.put("D", 3);
     * Test a case where we know exactly how many of each term is on each shard
            )
                    .size(10000)
                    .size(10000)
        assertSearchResponse(testResponse);
            )
                terms("terms").executionHint(randomExecutionHint())
                    .field(DOUBLE_FIELD_NAME)
 * GitHub history for details.
            )
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
                    .order(BucketOrder.aggregation("sortAgg", true))
                    .order(BucketOrder.aggregation("sortAgg", false))
        assertSearchResponse(accurateResponse);
        assertThat(bucket.getDocCount(), equalTo(100L));
            .get();
                terms("terms").executionHint(randomExecutionHint())
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        }
            if (testBucket == null) {
        assertUnboundedDocCountError(size, accurateResponse, testResponse);
        assertNoDocCountErrorSingleResponse(size, testResponse);
import java.util.Map;
    }
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            .get();
    }
                    .subAggregation(sum("sortAgg").field(LONG_FIELD_NAME))
            .get();
    }
    private static final String DOUBLE_FIELD_NAME = "d_value";
                        .setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, term).field("shard", 2).endObject())
        assertThat(bucket, notNullValue());
            )
            .addAggregation(
                terms("terms").executionHint(randomExecutionHint())
                    .order(BucketOrder.key(true))
            )
    public void testLongValueFieldSubAggDesc() throws Exception {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                    .field(LONG_FIELD_NAME)
        assertUnboundedDocCountError(size, accurateResponse, testResponse);
        assertSearchResponse(testResponse);
            .addAggregation(
                    .showTermDocCountError(true)
                    .size(10000)
        assertThat(testBuckets.size(), lessThanOrEqualTo(size));
    private void assertNoDocCountErrorSingleResponse(int size, SearchResponse testResponse) {
        super(staticSettings);
    public void testLongValueFieldDocCountAsc() throws Exception {
    }
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        shard2DocsPerTerm.put("Z", 36);
        assertNoDocCountError(size, accurateResponse, testResponse);
                terms("terms").executionHint(randomExecutionHint())
        int size = randomIntBetween(1, 20);
        assertSearchResponse(testResponse);
        shard1DocsPerTerm.put("B", 25);
/*
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(buckets.size(), equalTo(5));
                        jsonBuilder().startObject()
    public void testDoubleValueField() throws Exception {
    public void testLongValueFieldTermSortAsc() throws Exception {
            .get();
            assertThat(testBucket.getDocCount() - testBucket.getDocCountError(), lessThanOrEqualTo(accurateBucket.getDocCount()));
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
                terms("terms").executionHint(randomExecutionHint())
        assertThat(bucket.getKey(), equalTo("B"));
    }
            .get();
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
 *
                );
        assertSearchResponse(accurateResponse);
        SearchResponse accurateResponse = client().prepareSearch("idx")
        int shardSize = randomIntBetween(size, size * 2);
                    .shardSize(shardSize)
    public void testStringValueFieldSubAggDesc() throws Exception {
import java.util.ArrayList;
        }
            )
            .addAggregation(
        Terms testTerms = testResponse.getAggregations().get("terms");
                    .field(STRING_FIELD_NAME)
            .get();
                    .showTermDocCountError(true)
                    .size(size)
                    .shardSize(10000)
                    .showTermDocCountError(true)
            )
            .get();
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
public class TermsDocCountErrorIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
        int shardSize = randomIntBetween(size, size * 2);
        bucket = buckets.get(3);
        assertSearchResponse(testResponse);
        assertThat(bucket.getDocCount(), equalTo(50L));
        int shardSize = randomIntBetween(size, size * 2);
    public void testDoubleValueFieldSubAggAsc() throws Exception {
            prepareCreate("idx_fixed_docs_1").setMapping(STRING_FIELD_NAME, "type=keyword")
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
    public void testFixedDocs() throws Exception {
                    .size(size)
                    .size(size)
        for (int i = 0; i < numDocs; i++) {
            assertThat(accurateBucket, notNullValue());
        Terms testTerms = testResponse.getAggregations().get("terms");
        assertSearchResponse(accurateResponse);
    public void testStringValueFieldSubAggAsc() throws Exception {
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
        int size = randomIntBetween(1, 20);
                    .setId("" + i)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                    .order(BucketOrder.aggregation("sortAgg", true))
        assertThat(terms, notNullValue());
        // concurrent and non-concurrent search in the 1 slice case. TermsFixedDocCountErrorIT verifies that the doc count error is
        SearchResponse accurateResponse = client().prepareSearch("idx")
                    .showTermDocCountError(true)
            .addAggregation(
        shard0DocsPerTerm.put("C", 6);
                    .field(STRING_FIELD_NAME)
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertUnboundedDocCountError(size, accurateResponse, testResponse);
        int size = randomIntBetween(1, 20);
        assertThat(testTerms.getDocCountError(), equalTo(0L));
            )
            .get();
            .addAggregation(
        );
        int size = randomIntBetween(1, 20);
                terms("terms").executionHint(randomExecutionHint())
            .addAggregation(
                terms("terms").executionHint(randomExecutionHint())
                    .order(BucketOrder.aggregation("sortAgg", false))
            .addAggregation(
     * so we know the exact error value for each term. To do this we search over
            assertThat(testBucket, notNullValue());
                    .field(STRING_FIELD_NAME)
                    .shardSize(10000)
 */
            .addAggregation(
                    .shardSize(shardSize)
                    .order(BucketOrder.key(true))
            .get();
                        .setId(term + "-" + i)
                    .showTermDocCountError(true)
                    .field(STRING_FIELD_NAME)
        Terms testTerms = testResponse.getAggregations().get("terms");
            .get();
                terms("terms").executionHint(randomExecutionHint())
        for (Map.Entry<String, Integer> entry : shard2DocsPerTerm.entrySet()) {
import org.opensearch.search.aggregations.bucket.terms.Terms;
        assertSearchResponse(testResponse);
                    .size(10000)
        assertSearchResponse(testResponse);
        forceMerge(1);
 *
                    .subAggregation(sum("sortAgg").field(LONG_FIELD_NAME))
            prepareCreate("idx_fixed_docs_2").setMapping(STRING_FIELD_NAME, "type=keyword")
        assertThat(bucket.getDocCountError(), equalTo(2L));
    @Override
            )
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
    }
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
                    .field(STRING_FIELD_NAME)
                    .shardSize(10000)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(bucket, notNullValue());
            builders.add(
                    .size(size)
            .addAggregation(
        assertNoDocCountErrorSingleResponse(size, testResponse);
            .addAggregation(
        int shardSize = randomIntBetween(size, size * 2);
                    .size(size)
                    .shardSize(10000)
            .get();
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(bucket.getKey(), equalTo("A"));
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
        assertThat(bucket, notNullValue());
            .addAggregation(
                terms("terms").executionHint(randomExecutionHint())
                    .field(STRING_FIELD_NAME)
        int size = randomIntBetween(1, 20);
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
    }
                    .showTermDocCountError(true)
        assertSearchResponse(accurateResponse);
            prepareCreate("idx_single_shard").setMapping(STRING_FIELD_NAME, "type=keyword")
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
                    .subAggregation(sum("sortAgg").field(LONG_FIELD_NAME))
                terms("terms").executionHint(randomExecutionHint())
    private void assertDocCountErrorWithinBounds(int size, SearchResponse accurateResponse, SearchResponse testResponse) {
            .get();
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
                    .order(BucketOrder.count(true))
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
/*
            assertThat(testBucket, notNullValue());
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
                    .shardSize(shardSize)
        List<? extends Bucket> testBuckets = testTerms.getBuckets();
            assertThat(testBucket.getDocCount() + testBucket.getDocCountError(), greaterThanOrEqualTo(accurateBucket.getDocCount()));
import org.opensearch.cluster.metadata.IndexMetadata;
                terms("terms").executionHint(randomExecutionHint())
                    .subAggregation(sum("sortAgg").field(LONG_FIELD_NAME))
                    .shardSize(shardSize)
package org.opensearch.search.aggregations.bucket;
        assertThat(testTerms.getName(), equalTo("terms"));
            .get();
            .get();
        assertThat(bucket, notNullValue());
                    .order(BucketOrder.key(false))
        indexRandom(true, builders);
        assertNoDocCountErrorSingleResponse(size, testResponse);
                    .shardSize(10000)
                client().prepareIndex("idx_single_shard")
 * the Apache License, Version 2.0 (the "License"); you may
                    .shardSize(shardSize)
        assertDocCountErrorWithinBounds(size, accurateResponse, testResponse);
            .addAggregation(
    public void setupSuiteScopeCluster() throws Exception {
    }
        int shardSize = randomIntBetween(size, size * 2);
        assertSearchResponse(testResponse);
                    .shardSize(shardSize)
                            .endObject()
                    .shardSize(10000)
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
        assertNoDocCountError(size, accurateResponse, testResponse);
                    .showTermDocCountError(true)
                    .field(STRING_FIELD_NAME)
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
                    .showTermDocCountError(true)
        List<? extends Bucket> testBuckets = testTerms.getBuckets();
        assertSearchResponse(accurateResponse);
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertNoDocCountError(size, accurateResponse, testResponse);
        Map<String, Integer> shard2DocsPerTerm = new HashMap<>();
        assertThat(accurateTerms.getBuckets().size(), greaterThanOrEqualTo(testBuckets.size()));
                    .size(size)
        bucket = buckets.get(1);
                terms("terms").executionHint(randomExecutionHint())
            Terms.Bucket accurateBucket = accurateTerms.getBucketByKey(testBucket.getKeyAsString());
                terms("terms").executionHint(randomExecutionHint())
                );
            assertThat(testBucket, notNullValue());
import java.util.List;
            .addAggregation(
                    .size(10000)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
 * SPDX-License-Identifier: Apache-2.0
    public void testLongValueField() throws Exception {
        int size = randomIntBetween(1, 20);
            }
        for (Terms.Bucket accurateBucket : accurateTerms.getBuckets()) {
            .get();
        assertNoDocCountError(size, accurateResponse, testResponse);
    }
        shard2DocsPerTerm.put("Q", 2);
    }
        numRoutingValues = between(1, 40);
                    .showTermDocCountError(true)
        int size = randomIntBetween(1, 20);
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(bucket.getDocCountError(), equalTo(29L));
        shard1DocsPerTerm.put("I", 10);
            )
        assertThat(bucket.getDocCountError(), equalTo(0L));
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            )
        assertDocCountErrorWithinBounds(size, accurateResponse, testResponse);
        assertAcked(
                    .order(BucketOrder.aggregation("sortAgg", true))
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
            .get();
        assertUnboundedDocCountError(size, accurateResponse, testResponse);
        assertThat(accurateTerms.getBuckets().size(), greaterThanOrEqualTo(testBuckets.size()));
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
    }
        assertSearchResponse(accurateResponse);
import java.util.HashMap;
        assertThat(accurateTerms, notNullValue());
                terms("terms").executionHint(randomExecutionHint())
                    .order(BucketOrder.aggregation("sortAgg", false))
        assertSearchResponse(testResponse);
                    )
                    .showTermDocCountError(true)
        );
            for (int i = 0; i < entry.getValue(); i++) {
            );
        Terms accurateTerms = accurateResponse.getAggregations().get("terms");
        assertThat(bucket.getKey(), equalTo("G"));
        SearchResponse testResponse = client().prepareSearch("idx")
import static org.hamcrest.core.IsNull.notNullValue;
                    .size(5)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .shardSize(10000)
    }
                    .size(size)
            assertThat(accurateBucket.getDocCountError(), equalTo(0L));
                    .shardSize(shardSize)
        int size = randomIntBetween(1, 20);
        Map<String, Integer> shard1DocsPerTerm = new HashMap<>();
                builders.add(
        assertSearchResponse(accurateResponse);
                    .size(10000)
                terms("terms").executionHint(randomExecutionHint())
                    .field(DOUBLE_FIELD_NAME)
        assertAcked(
                    .field(STRING_FIELD_NAME)
        shard1DocsPerTerm.put("G", 15);
        assertThat(testTerms, notNullValue());
            .get();
            .get();
            .addAggregation(
            .addAggregation(
        SearchResponse response = client().prepareSearch("idx_fixed_docs_0", "idx_fixed_docs_1", "idx_fixed_docs_2")
        int size = randomIntBetween(1, 20);
                    client().prepareIndex("idx_fixed_docs_0")
    }
        assertThat(testTerms.getDocCountError(), greaterThanOrEqualTo(0L));
                    .order(BucketOrder.count(true))
                    .order(BucketOrder.count(true))
                    .subAggregation(sum("sortAgg").field(LONG_FIELD_NAME))
                    .shardSize(shardSize)
    public static String randomExecutionHint() {
                    .field(STRING_FIELD_NAME)
            assertThat(accurateBucket, notNullValue());
                    .field(STRING_FIELD_NAME)
    }
        return randomBoolean() ? null : randomFrom(ExecutionMode.values()).toString();
            )
            )
        }
            assertThat(testBucket.getDocCountError(), equalTo(0L));
    public void testDoubleValueFieldTermSortDesc() throws Exception {
            assertThat(accurateBucket.getDocCountError(), equalTo(0L));
        shard1DocsPerTerm.put("F", 17);
        int shardSize = randomIntBetween(size, size * 2);
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
                    .shardSize(10000)
            .addAggregation(
            .addAggregation(
                    .shardSize(5)
                    .showTermDocCountError(true)
                    .field(STRING_FIELD_NAME)
                    .order(BucketOrder.key(false))
                    .showTermDocCountError(true)
    @ParametersFactory
    private static final String STRING_FIELD_NAME = "s_value";
        assertSearchResponse(testResponse);
        List<? extends Bucket> buckets = terms.getBuckets();
                terms("terms").executionHint(randomExecutionHint())
        int size = randomIntBetween(1, 20);
            assertThat(accurateBucket, notNullValue());
        int shardSize = randomIntBetween(size, size * 2);
        assertThat(accurateTerms.getName(), equalTo("terms"));
                    .showTermDocCountError(true)
        int size = randomIntBetween(1, 20);
            .addAggregation(
        assertAcked(prepareCreate("idx_with_routing").setMapping("{ \"_routing\" : { \"required\" : true } }"));
import org.opensearch.search.aggregations.bucket.terms.TermsAggregatorFactory.ExecutionMode;
        for (int i = 0; i < numDocs; i++) {
                    .field(LONG_FIELD_NAME)
        assertSearchResponse(accurateResponse);
        shard1DocsPerTerm.put("C", 4);
                terms("terms").executionHint(randomExecutionHint())
                    .showTermDocCountError(true)
                            .field(STRING_FIELD_NAME, "val" + randomInt(numUniqueTerms))
                    .field(LONG_FIELD_NAME)
            builders.add(
        int size = randomIntBetween(1, 20);
        assertSearchResponse(testResponse);
                    .shardSize(shardSize)
        for (Terms.Bucket testBucket : testBuckets) {
                    .showTermDocCountError(true)
    }
        int size = randomIntBetween(1, 20);
        Terms accurateTerms = accurateResponse.getAggregations().get("terms");
        SearchResponse testResponse = client().prepareSearch("idx_with_routing")
 * compatible open source license.
        );
import org.opensearch.action.search.SearchResponse;
import org.opensearch.search.aggregations.BucketOrder;
            builders.add(
            .get();
                    .setId("" + i)
                    .size(10000)
        int shardSize = randomIntBetween(size, size * 2);
        int shardSize = randomIntBetween(size, size * 2);
            )
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        shard0DocsPerTerm.put("J", 1);
                    .setSource(
                    .showTermDocCountError(true)
            .get();
 * You may obtain a copy of the License at
        assertThat(accurateTerms.getDocCountError(), equalTo(0L));
                    .showTermDocCountError(true)
        assertSearchResponse(accurateResponse);
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
        int shardSize = randomIntBetween(size, size * 2);
            )
        assertSearchResponse(accurateResponse);
    }
                    .size(10000)
                    .showTermDocCountError(true)
        int shardSize = randomIntBetween(size, size * 2);
        shard2DocsPerTerm.put("A", 45);
                    .field(STRING_FIELD_NAME)
                    .showTermDocCountError(true)
    public void testStringValueFieldWithRouting() throws Exception {
        int shardSize = randomIntBetween(size, size * 2);
 * this work for additional information regarding copyright
        for (Terms.Bucket testBucket : testBuckets) {
                    .size(size)
 *    http://www.apache.org/licenses/LICENSE-2.0
                    .showTermDocCountError(true)
 * Unless required by applicable law or agreed to in writing,
    private void assertUnboundedDocCountError(int size, SearchResponse accurateResponse, SearchResponse testResponse) {
                    .order(BucketOrder.key(true))
                    .size(size)
            .addAggregation(
        Bucket bucket = buckets.get(0);
        int size = randomIntBetween(1, 20);
            .get();
        assertThat(testTerms.getName(), equalTo("terms"));
        assertSearchResponse(accurateResponse);
        }
                    .size(size)
            .setRouting(String.valueOf(between(1, numRoutingValues)))
        assertNoDocCountError(size, accurateResponse, testResponse);
        shard1DocsPerTerm.put("Q", 6);
            );
                    .showTermDocCountError(true)
                        .setId(term + "-" + i)
        assertSearchResponse(testResponse);
            .addAggregation(
        int size = randomIntBetween(1, 20);
                    .showTermDocCountError(true)
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
            .addAggregation(
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .size(size)
            for (int i = 0; i < entry.getValue(); i++) {
        assertThat(accurateTerms.getName(), equalTo("terms"));
                    .shardSize(10000)
        }
        assertAcked(client().admin().indices().prepareCreate("idx").setMapping(STRING_FIELD_NAME, "type=keyword").get());
                            .endObject()
        assertSearchResponse(testResponse);
        assertSearchResponse(accurateResponse);
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
                    .field(LONG_FIELD_NAME)
        assertThat(accurateTerms.getBuckets().size(), greaterThanOrEqualTo(testBuckets.size()));
                    )
                    .shardSize(shardSize)
        assertThat(terms.getDocCountError(), equalTo(46L));
            )
                    .order(BucketOrder.key(true))
            .get();
        assertSearchResponse(accurateResponse);
import org.opensearch.search.aggregations.bucket.terms.Terms.Bucket;
                    .size(size)
            )
                    .shardSize(shardSize)
        int shardSize = randomIntBetween(size, size * 2);
            .get();
                    .size(size)
            .get();
            .addAggregation(
        assertDocCountErrorWithinBounds(size, accurateResponse, testResponse);
                    .field(DOUBLE_FIELD_NAME)
                    .setSource(
        assertSearchResponse(testResponse);
 * not use this file except in compliance with the License.
        shard0DocsPerTerm.put("G", 2);
        SearchResponse accurateResponse = client().prepareSearch("idx")
                    .field(LONG_FIELD_NAME)
        // See https://github.com/opensearch-project/OpenSearch/issues/11680"
        );
    public void testDoubleValueFieldDocCountAsc() throws Exception {
                    .showTermDocCountError(true)
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
    }
                    .showTermDocCountError(true)
 * Modifications Copyright OpenSearch Contributors. See
    }
                    .showTermDocCountError(true)
                    .shardSize(shardSize)
            .get();
        assertNoDocCountError(size, accurateResponse, testResponse);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Terms testTerms = testResponse.getAggregations().get("terms");
                    .size(10000)
    }
        assertThat(bucket.getDocCount(), equalTo(43L));
        assertThat(buckets, notNullValue());
                    .field(LONG_FIELD_NAME)
            .addAggregation(
                    .order(BucketOrder.key(false))
            Terms.Bucket testBucket = accurateTerms.getBucketByKey(accurateBucket.getKeyAsString());
            )
                    .shardSize(10000)
        assertSearchResponse(accurateResponse);
                    .shardSize(shardSize)
        int shardSize = randomIntBetween(size, size * 2);
                String term = entry.getKey();
            .setRouting(String.valueOf(between(1, numRoutingValues)))
        assertNoDocCountError(size, accurateResponse, testResponse);
                    .size(size)
                            .field(STRING_FIELD_NAME, "val" + randomInt(numUniqueTerms))
                    .order(BucketOrder.aggregation("sortAgg", false))
        shard1DocsPerTerm.put("A", 30);
        assertThat(testTerms.getDocCountError(), equalTo(0L));
            .addAggregation(
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
        int shardSize = randomIntBetween(size, size * 2);
        assertThat(testTerms, notNullValue());
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                    .subAggregation(sum("sortAgg").field(DOUBLE_FIELD_NAME))
            .get();
        int size = randomIntBetween(1, 20);
            )
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                terms("terms").executionHint(randomExecutionHint())
            .get();
        assertSearchResponse(accurateResponse);
            )
            Terms.Bucket accurateBucket = accurateTerms.getBucketByKey(testBucket.getKeyAsString());
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            Terms.Bucket accurateBucket = accurateTerms.getBucketByKey(testBucket.getKeyAsString());
        assertThat(bucket.getDocCount(), equalTo(52L));
        SearchResponse accurateResponse = client().prepareSearch("idx_single_shard")
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        shard0DocsPerTerm.put("B", 18);
            .addAggregation(
                            .field(DOUBLE_FIELD_NAME, 1.0 * randomInt(numUniqueTerms))
            )
                    .shardSize(shardSize)
                    .showTermDocCountError(true)
                    .field(LONG_FIELD_NAME)
        }
 * this file be licensed under the Apache-2.0 license or a
            .addAggregation(
                    .size(size)
        SearchResponse testResponse = client().prepareSearch("idx_single_shard")
                    .field(DOUBLE_FIELD_NAME)
        assertSearchResponse(testResponse);
        assertSearchResponse(accurateResponse);
                    .shardSize(shardSize)
        assertThat(bucket.getKey(), equalTo("Z"));
            .get();
            .get();
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
    public void testDoubleValueFieldSubAggDesc() throws Exception {
    }
            )
            )
            .get();
            .get();
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertUnboundedDocCountError(size, accurateResponse, testResponse);
                    .order(BucketOrder.key(false))
                    .size(10000)
import java.util.Arrays;
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .field(DOUBLE_FIELD_NAME)
                    .showTermDocCountError(true)
        int size = randomIntBetween(1, 20);
                String term = entry.getKey();
        assertSearchResponse(testResponse);
                    .size(size)
        assertThat(accurateTerms.getDocCountError(), equalTo(0L));
            )
                    .field(STRING_FIELD_NAME)
        shard2DocsPerTerm.put("E", 29);
            .addAggregation(
                    .field(DOUBLE_FIELD_NAME)
