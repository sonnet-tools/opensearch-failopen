            equalTo(0L)
        assertThat(propertiesCounts[1], equalTo(12.0));
            .get();
        Map<String, Object> params = new HashMap<>();
        assertThat(bucket.getFromAsString(), equalTo("3.0"));
    }
        assertThat(bucket.getToAsString(), equalTo("3.0"));
public class RangeIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
     */
    public RangeIT(Settings staticSettings) {
        assertThat(bucket.getToAsString(), equalTo("3.0"));
                .getRequestCache()
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
        Range range = response.getAggregations().get("range");
                .get()
        assertThat(bucket, notNullValue());
        assertThat(bucket.getToAsString(), nullValue());
            });
        ensureSearchable();
        assertThat(terms, notNullValue());
        assertThat(bucket.getKey(), equalTo("*-3.0"));
            .addAggregation(
        Range.Bucket bucket = buckets.get(0);
                            .value(i + 1)
                .getRequestCache()
        assertThat(bucket.getKey(), equalTo("4.0-5.0"));
        assertThat(
import java.util.Map;
            .addAggregation(
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            .get();
import org.opensearch.search.aggregations.bucket.terms.Terms;
    static int numDocs;
        assertThat(bucket.getKey(), equalTo("3.0-6.0"));
            if (i == 1 || i == 3) {
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
                            .endObject()
        super(staticSettings);
        );
        assertThat(bucket.getFromAsString(), equalTo("6.0"));
                .indices()
        assertThat(range.getName(), equalTo("range"));
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            .setSize(0)
        assertThat(bucket.getFromAsString(), equalTo("3.0"));
        assertThat(bucket.getToAsString(), nullValue());
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));
            .get();
                .prepareStats("cache_test_idx")
                        jsonBuilder().startObject()
        bucket = buckets.get(1);
        assertThat(bucket.getDocCount(), equalTo(3L));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                assertThat(rangeBucket.getDocCount(), equalTo(0L));
    [4, 5]
            Range range = bucket.getAggregations().get("range");
        assertThat(bucket.getKey(), equalTo("*-3.0"));
        List<? extends Bucket> buckets = range.getBuckets();
    public void testSingleValueFieldWithCustomKey() throws Exception {
    r2: 3, 3, 4, 4, 5, 5
                .setRequestCache(true)
        );
        );
        assertThat(range.getBuckets().size(), equalTo(3));
        assertThat(
                range("range").field(SINGLE_VALUED_FIELD_NAME)
                assertThat(rangeBucket.getDocCount(), equalTo(0L));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));
        assertThat(bucket.getKey(), equalTo("*-3.0"));
        assertThat(bucket.getToAsString(), equalTo("6.0"));
        assertThat(bucket, notNullValue());
import java.util.function.Function;
        assertThat(bucket, notNullValue());
                assertThat(rangeBucket.getDocCount(), equalTo(1L));
        assertThat(propertiesKeys[0], equalTo("*-3.0"));
        indexRandom(
    }
                .getMissCount(),
            client().prepareIndex("cache_test_idx").setId("2").setSource(jsonBuilder().startObject().field("i", 2).endObject())
                .getRequestCache()
        assertThat(range, notNullValue());
        assertThat(range.getName(), equalTo("range"));
        assertThat(bucket.getFromAsString(), equalTo("6.0"));
        bucket = buckets.get(1);
            List<? extends Bucket> buckets = range.getBuckets();
        assertThat(bucket.getDocCount(), equalTo(4L));
        assertThat(bucket.getFromAsString(), equalTo("6.0"));
    }
/*
        internalCluster().wipeIndices("cache_test_idx");
        for (int i = 0; i < numDocs; i++) {
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));
            client().admin()
        assertThat(range.getName(), equalTo("range"));
                range("range").field(SINGLE_VALUED_FIELD_NAME).addUnboundedTo("r1", 3).addRange("r2", 3, 6).addUnboundedFrom("r3", 6)
        assertThat(bucket.getFromAsString(), nullValue());
        assertThat(bucket.getFromAsString(), nullValue());
                range("range").field("route_length_miles").missing(0.0).addUnboundedTo(50.0).addRange(50.0, 150.0).addUnboundedFrom(150.0)
    [2, 3]
        assertThat(
            client().admin()
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(3.0));
    [3, 4]
                    .setSource(
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));
        }
        Histogram.Bucket bucket = histo.getBuckets().get(1);
        }
        bucket = buckets.get(2);
        List<IndexRequestBuilder> builders = new ArrayList<>();
        assertThat(bucket.getKey(), equalTo("50.0-150.0"));
        assertThat(bucket.getFromAsString(), equalTo("3.0"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    .addUnboundedFrom(6)
    [10, 11]
                .getHitCount(),
        assertThat(bucket.getKey(), equalTo("3.0-6.0"));
        assertThat(bucket.getDocCount(), equalTo(1L));
        assertThat(range, notNullValue());
    [3, 4]
        assertThat(bucket.getFromAsString(), nullValue());
            )
import java.util.Collection;
import java.util.List;
    }
        assertThat(bucket.getFromAsString(), equalTo("6.0"));
    r3: 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11
            }
        assertThat(range.getBuckets().size(), equalTo(3));
            .addAggregation(
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
            client().admin()
        assertThat(bucket.getToAsString(), equalTo("5.0"));
            )
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));
    }
        assertThat(bucket.getKey(), equalTo("3.0-6.0"));
        List<? extends Bucket> buckets = range.getBuckets();
        Histogram histo = searchResponse.getAggregations().get("histo");
    }
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        }
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "Math.random()", Collections.emptyMap()))
            } else {
        assertThat(range, notNullValue());
        assertThat(range.getName(), equalTo("range"));
     */
        assertThat(bucket.getKey(), equalTo("3.0-6.0"));
        Range range = response.getAggregations().get("range");
        assertSearchResponse(response);
            assertThat(rangeBucket.getToAsString(), nullValue());
        Range range = response.getAggregations().get("range");
                    .addRange(3, 6)
        assertThat(range, notNullValue());
        assertThat(bucket, notNullValue());
        SearchResponse response = client().prepareSearch("idx")
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(4.0));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(3.0));
    [6, 7]
        assertSearchResponse(response);
                .indices()
        assertThat(bucket.getDocCount(), equalTo(4L));
        prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer").get();
            Collections.emptyMap()
        Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) range).getProperty("_count");
        assertThat(bucket.getFromAsString(), nullValue());
        assertThat(bucket.getToAsString(), nullValue());
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));
        assertThat(bucket.getDocCount(), equalTo(numDocs - 4L));
        );
        assertAcked(
import org.opensearch.test.OpenSearchIntegTestCase;
                .setRequestCache(true)
                    .addUnboundedTo(3)
import java.util.ArrayList;
        List<? extends Range.Bucket> buckets = range.getBuckets();
    r3: 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12
 *    http://www.apache.org/licenses/LICENSE-2.0
                .prepareStats("cache_test_idx")
            .setQuery(matchAllQuery())
        assertThat(bucket, notNullValue());
        Range.Bucket bucket = buckets.get(0);
        assertThat(buckets.size(), is(1));
 * this work for additional information regarding copyright
        SearchResponse response = client().prepareSearch("idx")
        assertThat(bucket.getKey(), equalTo("*-3.0"));
 * under the License.
        assertThat(bucket.getKey(), equalTo("3.0-6.0"));
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));
import static org.hamcrest.Matchers.is;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));
import org.opensearch.search.aggregations.InternalAggregation;
                .getMissCount(),
        List<? extends Bucket> buckets = range.getBuckets();
        bucket = buckets.get(1);
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(bucket.getFromAsString(), nullValue());
    public void testFieldAlias() {
        assertThat(bucket.getKey(), equalTo("*-3.0"));
    public void testRangeAsSubAggregation() throws Exception {
import java.util.Arrays;
        Range.Bucket bucket = buckets.get(0);
        Range.Bucket bucket = buckets.get(0);
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
        indexRandom(true, builders);
            assertThat(rangeBucket.getKeyAsString(), equalTo("6.0-*"));
        assertThat(bucket.getToAsString(), equalTo("3.0"));
        assertThat(((Number) buckets.get(0).getTo()).doubleValue(), equalTo(2.0));
        assertThat(range, notNullValue());
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
            assertThat(rangeBucket.getKeyAsString(), equalTo("3.0-6.0"));
                .setRequestCache(true)
        bucket = buckets.get(2);
                assertThat(rangeBucket.getDocCount(), equalTo(1L));
    }
    [5, 6]
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
            client().admin()
        }
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
    public void testFieldAliasWithMissingValue() {
        assertThat(bucket.getDocCount(), equalTo(numDocs - 5L));
        assertSearchResponse(response);
            scripts.put("doc['" + SINGLE_VALUED_FIELD_NAME + "'].value", vars -> {
        assertThat(bucket.getDocCount(), equalTo(2L));
                .prepareStats("cache_test_idx")
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            if (i == 6 || i == numDocs + 1) {
        assertThat(bucket.getKey(), equalTo("150.0-*"));
        Range.Bucket bucket = buckets.get(0);
        assertThat(range, notNullValue());
}
        SearchResponse response = client().prepareSearch("idx")
            .addAggregation(range("range").field(SINGLE_VALUED_FIELD_NAME).addUnboundedTo(3).addRange(3, 6).addUnboundedFrom(6))
        bucket = buckets.get(1);
    [2, 3]
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));
            )
        assertThat(bucket.getKey(), equalTo("6.0-*"));
        assertThat(bucket, notNullValue());
                Map<?, ?> doc = (Map) vars.get("doc");
        assertThat(bucket.getKey(), equalTo("r1"));
    public static Collection<Object[]> parameters() {
            assertThat(rootCause, instanceOf(IllegalArgumentException.class));
        assertThat(range, notNullValue());
            builders.add(
        assertThat(propertiesCounts[0], equalTo(3.0));
    public void testMultiValuedFieldWithValueScript() throws Exception {
        Range range = response.getAggregations().get("range");
            scripts.put("Math.random()", vars -> RangeIT.randomDouble());
        assertThat(bucket.getFromAsString(), equalTo("3.0"));
                range("foo").field("i")
        assertThat(bucket.getToAsString(), nullValue());
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
                .getHitCount(),
        assertThat(bucket.getToAsString(), equalTo("3.0"));
        SearchResponse response = client().prepareSearch("old_index", "new_index")
        assertThat(bucket.getKey(), equalTo("6.0-*"));
            builders.add(
        assertThat(bucket.getFromAsString(), equalTo("3.0"));
        assertThat(bucket, Matchers.notNullValue());
        assertThat(bucket.getDocCount(), equalTo(numDocs - 2L));
    r2: 3, 3, 4, 4, 5, 5
 * SPDX-License-Identifier: Apache-2.0
        try {
        assertThat(propertiesKeys[1], equalTo("3.0-6.0"));
        Range.Bucket bucket = buckets.get(0);
        assertThat(bucket.getDocCount(), equalTo(numDocs - 3L));
        assertThat(buckets.size(), equalTo(3));
            .addAggregation(
        assertThat(range.getName(), equalTo("range"));
        );
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
            Map<String, Function<Map<String, Object>, Object>> scripts = super.pluginScripts();
        assertThat(bucket, notNullValue());
        assertThat(bucket.getDocCount(), equalTo(0L));
        assertThat(bucket.getKey(), equalTo("*-3"));
                        jsonBuilder().startObject()
            equalTo(2L)
            .addAggregation(
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));
        Range range = response.getAggregations().get("range");
    [8, 9]
        assertThat(bucket.getToAsString(), equalTo("6.0"));
/*
                ScriptDocValues.Longs value = (ScriptDocValues.Longs) doc.get(SINGLE_VALUED_FIELD_NAME);
                .getRequestCache()
        assertThat(bucket.getDocCount(), equalTo(2L));
    [9, 10]
            equalTo(0L)
        assertThat(bucket.getToAsString(), nullValue());
        assertThat(bucket.getKey(), equalTo("3.0-6.0"));
        Object[] propertiesKeys = (Object[]) ((InternalAggregation) range).getProperty("_key");
        assertThat(bucket.getFromAsString(), equalTo("6.0"));
                    .interval(1L)
    }
            client().admin()
        assertThat(bucket.getToAsString(), equalTo("3.0"));
        assertThat(bucket, notNullValue());
            assertThat(rangeBucket, notNullValue());
        assertThat(bucket.getDocCount(), equalTo(0L));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
        assertThat(bucket.getKey(), equalTo("*-50.0"));
        bucket = buckets.get(2);
        assertThat(bucket.getFromAsString(), equalTo("6.0"));
        Script script = new Script(
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        assertThat(sum.getValue(), equalTo(3.0)); // 1 + 2
            .setSize(0)
        );
        // one, and a concrete field in the other.
                assertThat(rangeBucket.getDocCount(), equalTo(2L));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));
            )
        assertThat(range.getName(), equalTo("range"));
                .get()
        assertThat(bucket, notNullValue());
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(3.0));
    [7, 8j
    /*
        assertThat(bucket.getDocCount(), equalTo(0L));
        // Test that a request using a deterministic script gets cached
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
        assertThat(bucket.getFromAsString(), equalTo("6.0"));
            } else {
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(3.0));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));
        assertThat(range.getName(), equalTo("range"));
        assertThat(bucket.getDocCount(), equalTo(2L));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            }
        Script script = new Script(
            } else if (i == 2) {
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));
    [9, 10]
        assertSearchResponse(r);
    }
        assertSearchResponse(r);
        assertThat(bucket, notNullValue());
            .get();
        assertThat(sum.getValue(), equalTo(12.0)); // 3 + 4 + 5
        client().admin().cluster().prepareHealth("idx_unmapped").setWaitForYellowStatus().get();
        Range.Bucket bucket = buckets.get(0);
        assertThat(bucket, notNullValue());
        Range.Bucket bucket = buckets.get(0);
    public void testSingleValueField() throws Exception {
        assertThat(bucket.getKey(), equalTo("*--1.0"));
    /**
        assertThat(bucket.getKey(), equalTo("3.0-6.0"));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(-1.0));
        assertThat(bucket.getToAsString(), nullValue());
        bucket = buckets.get(2);
        assertThat(bucket.getKey(), equalTo("*-3.0"));
        assertThat(propertiesCounts[2], equalTo((double) total));
        sum = bucket.getAggregations().get("sum");
        assertThat(bucket.getFromAsString(), nullValue());
            .get();
                    )
            )
                client().prepareIndex("idx")
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(3.0));
            assertThat(rangeBucket, notNullValue());
                .indices()
        bucket = buckets.get(2);
        List<? extends Bucket> buckets = range.getBuckets();
        builders.add(client().prepareIndex("new_index").setSource(Collections.emptyMap()));
        assertThat(range.getBuckets().size(), equalTo(3));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
        List<? extends Range.Bucket> buckets = range.getBuckets();
    }
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
            final long docCount = i == 1 || i == numDocs + 1 ? 1 : 2;
        // Make sure we are starting with a clear cache
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(range.getName(), equalTo("range"));
                client().prepareIndex("empty_bucket_idx")
                .get()
        Range range = response.getAggregations().get("range");
        assertThat(bucket.getDocCount(), equalTo(0L));
        assertThat(bucket.getDocCount(), equalTo(0L));
        assertThat(bucket.getToAsString(), equalTo("6.0"));
                range("foo").field("i")
        assertThat(bucket.getKey(), equalTo("r3"));
        assertThat(bucket.getDocCount(), equalTo(3L));
        Range range = response.getAggregations().get("range");
        assertThat(bucket.getKey(), equalTo("6.0-*"));
 */
        createIndex("idx_unmapped");
        bucket = buckets.get(2);
        assertThat(
        assertThat(bucket.getToAsString(), equalTo("6.0"));
        assertThat(bucket.getToAsString(), equalTo("-1.0"));
    @Override
    }
                .get()
        SearchResponse response = client().prepareSearch("idx")
        bucket = buckets.get(2);
                    .subAggregation(range("range").field(SINGLE_VALUED_FIELD_NAME).addRange("0-2", 0.0, 2.0))
            .get();
        assertThat(buckets.size(), equalTo(3));
        assertThat(bucket.getToAsString(), nullValue());
        assertThat(bucket, notNullValue());
        assertThat(
        assertThat(bucket.getFromAsString(), equalTo("3.0"));
            assertThat(rangeBucket.getToAsString(), equalTo("3.0"));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
        assertThat(bucket.getFromAsString(), nullValue());
        assertThat(terms.getBuckets().size(), equalTo(numDocs + 1));
        assertThat(bucket.getKey(), equalTo("6.0-*"));
        assertThat(sum, notNullValue());
        assertThat(bucket, notNullValue());
        assertThat(bucket.getKey(), equalTo("6-*"));
    }
                .getRequestCache()
    [6, 7]
        assertThat(bucket.getFromAsString(), equalTo("3.0"));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));
    [11, 12]
        SearchResponse response = client().prepareSearch("idx")
        assertThat(bucket, notNullValue());
        assertSearchResponse(r);
        // Create two indices and add the field 'route_length_miles' as an alias in
import org.opensearch.script.Script;
            .get();
    [3, 4]
            .addAggregation(range("range").field(SINGLE_VALUED_FIELD_NAME).addUnboundedTo(3).addRange(3, 6).addUnboundedFrom(6))
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));
        assertThat(bucket.getKey(), equalTo("3-6"));
    public void testEmptyRange() throws Exception {
        assertThat(bucket.getDocCount(), equalTo(2L));
                .indices()
        assertThat(bucket.getKey(), equalTo("6.0-*"));
            CustomScriptPlugin.NAME,
        assertThat(histo, Matchers.notNullValue());
        assertThat(bucket.getFromAsString(), equalTo("6.0"));
        Range.Bucket bucket = buckets.get(0);
        assertThat(bucket, notNullValue());
        assertThat(bucket.getToAsString(), nullValue());
        assertThat(bucket, notNullValue());
    public void testPartiallyUnmapped() throws Exception {
                .getRequestCache()
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));
            ScriptType.INLINE,
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;
    private static final String MULTI_VALUED_FIELD_NAME = "l_values";
        assertThat(bucket, notNullValue());
    [7, 8j
        assertThat(bucket.getDocCount(), equalTo(numDocs - 4L));
        assertSearchResponse(response);
            );
        assertThat(bucket, notNullValue());
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(4.0));
    public void testSingleValuedFieldWithSubAggregation() throws Exception {
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
import org.opensearch.action.search.SearchResponse;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));
    @ParametersFactory
        assertThat(buckets.get(0).getKey(), equalTo("0-2"));
        assertThat(range.getBuckets().size(), equalTo(3));
            true,
            .get();
        assertThat(bucket.getDocCount(), equalTo(2L));
        bucket = buckets.get(1);
    }
        bucket = buckets.get(1);
            )
        }
            .get();
        assertThat(bucket.getFromAsString(), nullValue());
        Range.Bucket bucket = buckets.get(0);
        assertThat(range.getBuckets().size(), equalTo(3));
        assertThat(bucket.getToAsString(), equalTo("6.0"));
                .getHitCount(),
        assertThat(bucket.getDocCount(), equalTo(numDocs - 5L));
        );
    [3, 4]
    }
     * Make sure that a request using a deterministic script or not using a script get cached.
        Range.Bucket bucket = buckets.get(0);
        List<? extends Bucket> buckets = range.getBuckets();
 * ownership. Elasticsearch licenses this file to you under
        assertThat(propertiesDocCounts[0], equalTo(2L));
        assertThat(bucket.getToAsString(), nullValue());
        assertThat(bucket.getKey(), equalTo("150.0-*"));
        Terms terms = response.getAggregations().get("terms");
                range("range").field(SINGLE_VALUED_FIELD_NAME)
        assertThat(bucket.getKey(), equalTo("3.0-6.0"));
            client().admin()
        assertThat(bucket.getDocCount(), equalTo(numDocs - 5L));
 * specific language governing permissions and limitations
    }
                .getTotal()
        assertThat(range, notNullValue());
        assertSearchResponse(response);
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(5.0));
        @Override
        assertThat(bucket.getToAsString(), equalTo("6"));
        assertThat(range.getBuckets().size(), equalTo(2));
            .addAggregation(range("range").field(MULTI_VALUED_FIELD_NAME).addUnboundedTo(-1).addUnboundedFrom(1000))
     */
        Range range = response.getAggregations().get("range");
        assertSearchResponse(response);
            .addAggregation(range("range").field("route_length_miles").addUnboundedTo(50.0).addRange(50.0, 150.0).addUnboundedFrom(150.0))
                    .addUnboundedTo(3)
        long total = 0;
        assertThat(bucket, notNullValue());
    public void testUnmapped() throws Exception {
        } catch (SearchPhaseExecutionException spee) {
                assertThat(rangeBucket.getDocCount(), equalTo(0L));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
        return Collections.singleton(CustomScriptPlugin.class);
    [5, 6]
import org.opensearch.script.ScriptType;
                    .addUnboundedFrom(6)
import org.opensearch.search.aggregations.bucket.range.Range;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));
        assertThat(bucket, notNullValue());
        }
                            .field(SINGLE_VALUED_FIELD_NAME, i * 2 - 1)
    [8, 9]
        );
        Range range = response.getAggregations().get("range");
        assertThat(bucket.getKey(), equalTo("r2"));
        prepareCreate("new_index").setMapping("route_length_miles", "type=double").get();
        assertSearchResponse(response);
        SearchResponse response = client().prepareSearch("idx")
            )
        Object[] propertiesCounts = (Object[]) ((InternalAggregation) range).getProperty("sum.value");
            scripts.put("doc['" + MULTI_VALUED_FIELD_NAME + "']", vars -> {
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));
import java.util.Collections;
    }
        assertThat(bucket.getFromAsString(), equalTo("3.0"));
        assertThat(bucket.getFromAsString(), equalTo("3.0"));
        bucket = buckets.get(3);
    [4, 5]
            equalTo(1L)
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        assertThat(bucket.getKey(), equalTo("3.0-6.0"));
        assertThat(bucket, notNullValue());
            Throwable rootCause = spee.getCause().getCause();
        builders.add(client().prepareIndex("old_index").setSource("distance", 42.0));
        assertSearchResponse(response);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            assertThat(bucket, notNullValue());
                            .value(i + 2)
 * Licensed to Elasticsearch under one or more contributor
        assertThat(buckets.size(), equalTo(3));
        bucket = buckets.get(1);
        assertThat(range, notNullValue());
    public void testNoRangesInQuery() {
        assertThat(bucket.getDocCount(), equalTo(numDocs - 5L));
import static org.hamcrest.Matchers.instanceOf;
    [8, 9]
            ScriptType.INLINE,
            assertThat(rangeBucket.getFromAsString(), nullValue());
    [6, 7]
        assertThat(range.getBuckets().size(), equalTo(3));
    [9, 10]
                .setRequestCache(true)
        for (int i = 0; i < 2; i++) {
            if (i == 3 || i == 6) {
        assertThat(bucket, notNullValue());
        r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(range("foo").field("i").addRange(0, 10)).get();
            )
                .getRequestCache()
        List<? extends Bucket> buckets = range.getBuckets();
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value + 1", Collections.emptyMap()))
import org.opensearch.action.index.IndexRequestBuilder;
        assertThat(range, notNullValue());
                .getHitCount(),
                .get()
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));
    public void testScriptSingleValue() throws Exception {
                .get()
 *
        assertThat(bucket.getKey(), equalTo("*-3.0"));
        assertThat(bucket.getFromAsString(), equalTo("6"));
        assertThat(bucket.getDocCount(), equalTo(3L));
        assertThat(buckets.get(0).getDocCount(), equalTo(0L));
import static org.hamcrest.core.IsNull.nullValue;
        assertThat(bucket, notNullValue());
                Map<?, ?> doc = (Map) vars.get("doc");
        assertThat(bucket.getToAsString(), equalTo("6.0"));
    @Override
        assertThat(
    [8, 9]
import static org.opensearch.search.aggregations.AggregationBuilders.range;
        assertThat(bucket.getDocCount(), equalTo(numDocs - 4L));
            .get();
/*
        assertThat(bucket.getToAsString(), equalTo("3"));
        assertThat(bucket.getDocCount(), equalTo(4L));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));
        assertThat(bucket.getFromAsString(), nullValue());
            equalTo(0L)
            prepareCreate("cache_test_idx").setMapping("i", "type=integer")
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
        assertThat(bucket.getToAsString(), equalTo("6.0"));
                .indices()
        bucket = buckets.get(1);
        assertThat(bucket.getKey(), equalTo("*-3.0"));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));
        assertSearchResponse(response);
        List<? extends Bucket> buckets = range.getBuckets();
        List<? extends Bucket> buckets = range.getBuckets();
        );
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(bucket.getKey(), equalTo("6.0-*"));
    }
        assertThat(bucket, notNullValue());
    [1, 2]
        assertThat(bucket.getToAsString(), nullValue());
                .getTotal()
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";
        assertThat(bucket.getDocCount(), equalTo(3L));
            .get();
        assertThat(bucket, notNullValue());
        Range range = response.getAggregations().get("range");
    [5, 6]
    public void setupSuiteScopeCluster() throws Exception {
        assertThat(bucket.getToAsString(), equalTo("3.0"));
     */
        assertThat(bucket.getDocCount(), equalTo(4L));
            equalTo(0L)
        assertSearchResponse(response);
        assertSearchResponse(response);
        assertThat(range.getName(), equalTo("range"));
    public static class CustomScriptPlugin extends AggregationTestScriptsPlugin {
            .addAggregation(range("range").field(SINGLE_VALUED_FIELD_NAME).addUnboundedTo(3).addRange(3, 6).addUnboundedFrom(6).format("#"))
        assertThat(bucket, notNullValue());
    }
            )
        params.put("fieldname", "date");
        assertThat(bucket.getToAsString(), equalTo("6.0"));
        // TODO: use diamond once JI-9019884 is fixed
    /*
        assertThat(bucket.getKey(), equalTo("*-5.0"));
        for (int i = 1; i < numDocs + 2; ++i) {
        assertThat(bucket.getDocCount(), equalTo(numDocs - 5L));
            .get();
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
        List<? extends Bucket> buckets = range.getBuckets();
        assertThat(range.getBuckets().size(), equalTo(3));
        bucket = buckets.get(2);
    }
        bucket = buckets.get(2);
        sum = bucket.getAggregations().get("sum");
        assertThat(bucket, notNullValue());
        assertThat(propertiesDocCounts[2], equalTo(numDocs - 5L));
        assertThat(
        r = client().prepareSearch("cache_test_idx")
            client().admin()
            } else if (i == 4 || i == 5) {
        // Test that a request using a nondeterministic script does not get cached
                .prepareStats("cache_test_idx")
@OpenSearchIntegTestCase.SuiteScopeTestCase
        );
        List<? extends Bucket> buckets = range.getBuckets();
            .addAggregation(range("range").script(script).addUnboundedTo(3).addRange(3, 6).addUnboundedFrom(6))
            return scripts;
    /*
        assertThat(bucket.getFromAsString(), equalTo("4.0"));
                .getTotal()
                .indices()
    [2, 3]
        assertThat(bucket.getKey(), equalTo("50.0-150.0"));
            .get();
        assertThat(bucket, notNullValue());
            equalTo(0L)
        assertThat(bucket.getToAsString(), equalTo("3.0"));
                .prepareStats("cache_test_idx")
            "doc['" + MULTI_VALUED_FIELD_NAME + "']",
        assertThat(range, notNullValue());
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
        Range range = response.getAggregations().get("range");
        assertThat(range.getBuckets().size(), equalTo(3));
import org.opensearch.plugins.Plugin;
                .getMissCount(),
import org.opensearch.search.aggregations.metrics.Sum;
        assertThat(bucket, notNullValue());
 * GitHub history for details.
        assertThat(range, notNullValue());
                .setRequestCache(true)
            assertThat(bucket.getDocCount(), equalTo(docCount));
    r1: 1, 2, 2
            rangeBucket = buckets.get(1);
        SearchResponse response = client().prepareSearch("idx")
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));
import org.opensearch.search.aggregations.bucket.range.Range.Bucket;
        assertThat(bucket.getFromAsString(), nullValue());
        assertThat(bucket.getDocCount(), equalTo(3L)); // 3, 4, 5
        List<? extends Bucket> buckets = range.getBuckets();
    [1, 2]
        assertThat(bucket.getDocCount(), equalTo(2L));
        bucket = buckets.get(1);
                .get()
        Range range = response.getAggregations().get("range");
        List<? extends Bucket> buckets = range.getBuckets();
        bucket = buckets.get(1);
            .addAggregation(range("range").script(script).addUnboundedTo(3).addRange(3, 6).addUnboundedFrom(6))
        builders.add(client().prepareIndex("new_index").setSource("route_length_miles", 100.2));
                .get()
                return value.getValue();
        indexRandomForConcurrentSearch("empty_bucket_idx");
            });
    [10, 11]
    [10, 11]
            }
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(3.0));
        assertThat(bucket, notNullValue());
            .addAggregation(range("range").field(SINGLE_VALUED_FIELD_NAME).addUnboundedTo(3).addRange(3, 6).addUnboundedFrom(6))
 * this file be licensed under the Apache-2.0 license or a
        assertThat(sum, notNullValue());
import org.opensearch.index.fielddata.ScriptDocValues;
    [11, 12]
    r1: 2
        assertThat(bucket, notNullValue());
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
                .getTotal()
            .addAggregation(
        List<Range.Bucket> buckets = new ArrayList<>(range.getBuckets());
        assertThat(bucket.getFromAsString(), nullValue());
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));
        assertThat(bucket, notNullValue());
 * the Apache License, Version 2.0 (the "License"); you may
                .prepareStats("cache_test_idx")
        assertThat(((Number) buckets.get(0).getFrom()).doubleValue(), equalTo(0.0));
        Range.Bucket bucket = buckets.get(0);
    [7, 8j
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
    }
    [7, 8j
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
                .setRequestCache(true)
            .get();
                    .addUnboundedTo(3)
        bucket = buckets.get(2);
        bucket = buckets.get(1);
        assertThat(bucket.getDocCount(), equalTo(4L));
        assertThat(bucket.getKey(), equalTo("6.0-*"));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));
            CustomScriptPlugin.NAME,
            .get();
        );
            .get();
        );
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(3.0));
        bucket = buckets.get(1);
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
 *
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
    public void testSingleValuedFieldWithValueScript() throws Exception {
                terms("terms").field(MULTI_VALUED_FIELD_NAME)
                range("range").field(MULTI_VALUED_FIELD_NAME)
        assertThat(bucket.getDocCount(), equalTo(2L));
            .get();
            client().prepareSearch("idx").addAggregation(range("foobar").field(SINGLE_VALUED_FIELD_NAME)).get();
        Sum sum = bucket.getAggregations().get("sum");
        bucket = buckets.get(2);
                return value;
    public void testMultiValuedField() throws Exception {
        assertThat(range.getName(), equalTo("range"));
        assertThat(propertiesDocCounts[1], equalTo(3L));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(3.0));
        assertThat(bucket.getDocCount(), equalTo(1L)); // 2
 * Unless required by applicable law or agreed to in writing,
        assertThat(bucket.getFromAsString(), equalTo("3"));
                            .endObject()
    public void testOverlappingRanges() throws Exception {
        SearchResponse response = client().prepareSearch("old_index", "new_index")
            return scripts;
        assertThat(range, notNullValue());
        assertThat(sum.getValue(), equalTo((double) total));
                .getTotal()
import static org.hamcrest.core.IsNull.notNullValue;
            .addAggregation(range("range").field(MULTI_VALUED_FIELD_NAME).addUnboundedTo(3).addRange(3, 6).addUnboundedFrom(6))
            rangeBucket = buckets.get(2);
        assertThat(bucket, notNullValue());
                    .setSource(
        assertThat(bucket.getFromAsString(), equalTo("1000.0"));
                .getTotal()
    [6, 7]
            assertThat(rangeBucket.getKey(), equalTo("*-3.0"));
        assertThat(bucket.getToAsString(), nullValue());
        assertThat(range.getName(), equalTo("range"));
        assertThat(bucket.getToAsString(), nullValue());
            client().prepareIndex("cache_test_idx").setId("1").setSource(jsonBuilder().startObject().field("i", 1).endObject()),
        builders.add(client().prepareIndex("old_index").setSource("distance", 50.5));
            assertThat(rangeBucket.getKeyAsString(), equalTo("*-3.0"));
        assertThat(range, notNullValue());
import org.hamcrest.Matchers;
            } else {
import static org.hamcrest.Matchers.equalTo;
    [2, 3]
            .addAggregation(
        assertThat(bucket.getToAsString(), nullValue());
import org.opensearch.action.search.SearchPhaseExecutionException;
 * software distributed under the License is distributed on an
        assertThat(bucket.getFromAsString(), nullValue());
        assertThat(bucket.getKey(), equalTo("4.0-*"));
        );
        assertThat(bucket.getDocCount(), equalTo(0L));
        numDocs = randomIntBetween(10, 20);
        assertSearchResponse(response);
                .setRequestCache(true)
        assertThat(bucket, notNullValue());
    public void testScriptCaching() throws Exception {
        assertSearchResponse(response);
        createIndex("idx");
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));
        List<? extends Bucket> buckets = range.getBuckets();
                    .addRange(0, 10)
    public void testSingleValueFieldWithFormat() throws Exception {
        assertThat(bucket.getToAsString(), equalTo("6.0"));
            assertThat(rangeBucket, notNullValue());
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));
            Terms.Bucket bucket = terms.getBucketByKey("" + i);
        bucket = buckets.get(1);
            assertEquals(rootCause.getMessage(), "No [ranges] specified for the [foobar] aggregation");
        indexRandomForMultipleSlices("idx", "old_index", "new_index");
            .get();
        assertThat(bucket, notNullValue());
    }
                            // shift sequence by 1, to ensure we have negative values, and value 3 on the edge of the tested ranges
        protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {
        assertThat(range.getName(), equalTo("range"));
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(range.getName(), equalTo("range"));
        assertThat(bucket, notNullValue());
        }
        assertThat(bucket, notNullValue());
            .addAggregation(
        assertThat(range.getName(), equalTo("range"));
        Range range = response.getAggregations().get("range");
        SearchResponse response = client().prepareSearch("idx")
        assertThat(bucket.getKey(), equalTo("*-50.0"));
        Range.Bucket bucket = buckets.get(0);
    [4, 5]
        assertThat(bucket, notNullValue());
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));
                .getRequestCache()
        SearchResponse response = client().prepareSearch("idx")
        assertThat(buckets.get(0).getToAsString(), equalTo("2.0"));
        assertThat(bucket, notNullValue());
            )
        assertThat(bucket.getFromAsString(), equalTo("6.0"));
                            .field(SINGLE_VALUED_FIELD_NAME, i + 1)
 * The OpenSearch Contributors require contributions made to
    }
        assertThat(bucket.getDocCount(), equalTo(3L));
        assertSearchResponse(response);
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value + 1", Collections.emptyMap()))
        assertThat(bucket, notNullValue());
                            .startArray(MULTI_VALUED_FIELD_NAME)
                range("range").field(MULTI_VALUED_FIELD_NAME).addUnboundedTo(5).addRange(3, 6).addRange(4, 5).addUnboundedFrom(4)
            .addAggregation(
        assertThat(bucket, notNullValue());
        bucket = buckets.get(2);
            "doc['" + SINGLE_VALUED_FIELD_NAME + "'].value",
        bucket = buckets.get(2);
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));
        assertThat(bucket.getToAsString(), equalTo("6.0"));
            );
    [5, 6]
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(3.0));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
        assertThat(bucket, notNullValue());
 *
        assertThat(buckets.get(0).getFromAsString(), equalTo("0.0"));
            assertThat(rangeBucket.getFromAsString(), equalTo("3.0"));
                assertThat(rangeBucket.getDocCount(), equalTo(2L));
        assertThat(bucket.getToAsString(), equalTo("5.0"));
                assertThat(rangeBucket.getDocCount(), equalTo(2L));
                .setRequestCache(true)
                .indices()
        assertThat(range.getBuckets().size(), equalTo(3));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
                .get()
        bucket = buckets.get(2);
                .prepareStats("cache_test_idx")
            assertThat(rangeBucket.getToAsString(), equalTo("6.0"));
                .getMissCount(),
        assertThat(bucket.getKey(), equalTo("1000.0-*"));
            } else if (i < 6) {
        assertSearchResponse(response);
 * You may obtain a copy of the License at
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));
     */
        assertThat(bucket.getDocCount(), equalTo(0L));
            .addAggregation(
                    .setId("" + i)
    }
    /*
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value + 1", Collections.emptyMap()))
        assertThat(bucket.getKey(), equalTo("6.0-*"));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(3.0));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
        // Ensure that non-scripted requests are cached as normal
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
                    .subAggregation(range("range").field(SINGLE_VALUED_FIELD_NAME).addUnboundedTo(3).addRange(3, 6).addUnboundedFrom(6))
                    .size(100)
                    .addRange(3, 6)
        assertThat(range, notNullValue());
            fail();
        assertThat(range.getBuckets().size(), equalTo(4));
        assertThat(bucket.getFromAsString(), nullValue());
        return Arrays.asList(
        assertThat(bucket.getFromAsString(), equalTo("6.0"));
        assertThat(range.getName(), equalTo("range"));
        assertThat(bucket.getToAsString(), equalTo("6.0"));
 */
        assertThat(bucket.getToAsString(), equalTo("3.0"));
                    .addRange(3, 6)
                .prepareStats("cache_test_idx")
        Range.Bucket bucket = buckets.get(0);
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
import java.util.HashMap;
        assertThat(bucket, notNullValue());
        bucket = buckets.get(1);
 * KIND, either express or implied.  See the License for the
        for (int i = 5; i < numDocs; ++i) {
        assertThat(bucket.getFromAsString(), equalTo("3.0"));
                .indices()
        SearchResponse response = client().prepareSearch("idx")
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
        bucket = buckets.get(1);
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(3.0));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(5.0));
    }
                    .addRange(0, 10)
        SearchResponse response = client().prepareSearch("idx")
    [9, 10]
        assertThat(bucket.getKey(), equalTo("3.0-6.0"));
        assertThat(bucket.getDocCount(), equalTo(3L));
 */
                .getTotal()
 * not use this file except in compliance with the License.
        @Override
                    .minDocCount(0)
        assertThat(bucket, notNullValue());
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
            assertThat(rangeBucket.getFromAsString(), equalTo("6.0"));
        assertThat(bucket.getKey(), equalTo("*-3.0"));
     * Ensure requests using nondeterministic scripts do not get cached.
                    .addUnboundedFrom(6)
            Range.Bucket rangeBucket = buckets.get(0);
        assertThat(bucket.getToAsString(), equalTo("3.0"));
        assertThat(propertiesKeys[2], equalTo("6.0-*"));
        assertThat(range.getBuckets().size(), equalTo(3));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(1000d));
            total += i + 1;
                ScriptDocValues.Longs value = (ScriptDocValues.Longs) doc.get(MULTI_VALUED_FIELD_NAME);
        Range.Bucket bucket = buckets.get(0);
        Range range = response.getAggregations().get("range");
    [10, 11]
                    )
        assertThat(
package org.opensearch.search.aggregations.bucket;
                            .endArray()
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertThat(range, Matchers.notNullValue());
        assertThat(sum, notNullValue());
        assertThat(range.getName(), equalTo("range"));
        prepareCreate("old_index").setMapping("distance", "type=double", "route_length_miles", "type=alias,path=distance").get();
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
        assertThat(bucket.getToAsString(), equalTo("3.0"));
            Collections.emptyMap()
    [4, 5]
        assertThat(bucket.getKey(), equalTo("6.0-*"));
            equalTo(0L)
import org.opensearch.common.settings.Settings;
        Range range = response.getAggregations().get("range");
            assertThat(rangeBucket.getKey(), equalTo("3.0-6.0"));
            .get();
        SearchResponse response = client().prepareSearch("idx")
        SearchResponse r = client().prepareSearch("cache_test_idx")
                .getTotal()
        assertThat(bucket, notNullValue());
 * compatible open source license.
    public void testScriptMultiValued() throws Exception {
        assertThat(bucket.getFromAsString(), equalTo("3.0"));
                assertThat(rangeBucket.getDocCount(), equalTo(1L));
        assertThat(bucket.getDocCount(), equalTo(numDocs - 5L));
        assertThat(bucket.getDocCount(), equalTo(1L));
    public void testEmptyAggregation() throws Exception {
        SearchResponse response = client().prepareSearch("idx_unmapped")
            client().admin()
 * license agreements. See the NOTICE file distributed with
        assertThat(bucket.getFromAsString(), equalTo("4.0"));
            assertThat(rangeBucket.getKey(), equalTo("6.0-*"));
        Range range = bucket.getAggregations().get("range");
        assertSearchResponse(response);
