            scripts.put("_value0 + _value1 > 100", vars -> {
                    .subAggregation(bucketSelector("bucketSelector", script, "field2Sum", "field3Sum"))
 * under the License.
                double value0 = (double) vars.get("_value0");
import static org.hamcrest.Matchers.notNullValue;
        assertThat(innerBuckets, notNullValue());
        return Arrays.asList(
                .cluster()
        innerBuckets = innerHisto.getBuckets();
            ScriptType.INLINE,
            client().admin()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                    .subAggregation(bucketSelector("bucketSelector", script, "field2Sum", "field3Sum"))
            .addAggregation(
        assertThat(histo.getName(), equalTo("histo"));
import org.opensearch.script.Script;
        }
        assertThat(histo, notNullValue());
 * compatible open source license.
        );
            )
 * The OpenSearch Contributors require contributions made to
        );
        jsonBuilder.field(FIELD_2_NAME, field2Value);
        assertSearchResponse(response);
            Collections.emptyMap()
            double field2SumValue = field2Sum.getValue();
            assertThat(field3Sum, notNullValue());
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
            Sum field3Sum = bucket.getAggregations().get("field3Sum");
        bucketPathsMap.put("my_value1", "field2Sum");
                double value1 = (double) vars.get("_value1");
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
            randomIntBetween(minNumber, maxNumber),
            .get();
            randomIntBetween(minNumber, maxNumber)
            Histogram.Bucket innerBucket = innerBuckets.get(i);
                    .interval(interval)
                double value0 = (double) vars.get("_value0");
    public void testPartiallyUnmapped() throws Exception {
            Sum field3Sum = bucket.getAggregations().get("field3Sum");
            ScriptType.INLINE,
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.bucketSelector;
            .addAggregation(
        interval = randomIntBetween(1, 50);
            Sum field3Sum = bucket.getAggregations().get("field3Sum");
            } else {
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
                            + CustomScriptPlugin.NAME
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
    }
            double field3SumValue = field3Sum.getValue();
                    .subAggregation(bucketSelector("bucketSelector", bucketPathsMap, script))
        assertThat(histo, notNullValue());
        SearchResponse response = client().prepareSearch("idx")
                return Double.isNaN(myValue1) ? false : (myValue1 + myValue2 > 100);
                    .subAggregation(bucketSelector("bucketSelector", script, "field2Sum"))
            )
        assertThat(innerBuckets, notNullValue());
    public void testInlineScriptInsertZeros() {
            ScriptType.INLINE,
                    .interval(1)
        }
            randomIntBetween(minNumber, maxNumber),
        assertThat(histo.getName(), equalTo("histo"));
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
        assertSearchResponse(response);
            builders.add(client().prepareIndex("idx").setSource(newDocBuilder()));
        for (int i = 0; i < buckets.size(); ++i) {
        innerHisto = bucket.getAggregations().get("inner_histo");
            .get();
        for (int i = 0; i < buckets.size(); ++i) {
 * specific language governing permissions and limitations
            double field2SumValue = field2Sum.getValue();
                return Double.isNaN(value0) ? false : (value0 < value1);
import java.util.HashMap;
        Histogram histo = response.getAggregations().get("histo");
            Histogram.Bucket innerBucket = innerBuckets.get(i);
                            .extendedBounds(1L, 4L)
        Script script = new Script(
import static org.hamcrest.Matchers.lessThan;
 *
                    .interval(interval)
            )
        assertThat(deriv, notNullValue());
        assertThat(bucket, notNullValue());
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value0 + _value1 > 100", Collections.emptyMap());
        List<? extends Histogram.Bucket> innerBuckets = innerHisto.getBuckets();
            ScriptType.INLINE,
    public void setupSuiteScopeCluster() throws Exception {
        assertThat(histo.getName(), equalTo("histo"));
        Script script = new Script(
        }
        assertThat(histo, notNullValue());
import java.util.ArrayList;
    @ParametersFactory
            Histogram.Bucket bucket = buckets.get(i);
        Histogram histo = response.getAggregations().get("histo");
            )
        for (int i = 0; i < innerBuckets.size(); i++) {
        assertThat(histo.getName(), equalTo("histo"));
        assertThat(histo, notNullValue());
import static org.hamcrest.Matchers.nullValue;
                    .subAggregation(bucketSelector("bucketSelector", script, "field2Sum", "field3Sum").gapPolicy(GapPolicy.INSERT_ZEROS))
            double field3SumValue = field3Sum.getValue();
    private static int minNumber;
        Histogram histo = response.getAggregations().get("histo");
        }
        assertThat(deriv.getName(), equalTo("histo"));
import java.util.Arrays;
            Histogram.Bucket bucket = buckets.get(i);
        assertSearchResponse(response);
        assertThat(histo, notNullValue());
        assertThat(histo, notNullValue());
            assertThat(field3Sum, notNullValue());
                            .interval(1)
        for (int i = 0; i < buckets.size(); ++i) {
            )
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        Histogram histo = response.getAggregations().get("histo");
            "Double.isNaN(_value0) ? false : (_value0 + _value1 > 100)",
                double value1 = (double) vars.get("_value1");
        assertThat(histo, notNullValue());
            double field2SumValue = field2Sum.getValue();
                    ),
 * the Apache License, Version 2.0 (the "License"); you may
                return Double.isNaN(value0) ? false : (value0 > 10000);
            CustomScriptPlugin.NAME,
        assertAcked(
        assertThat(histo.getName(), equalTo("histo"));
            ScriptType.INLINE,
            Collections.emptyMap()
import java.util.function.Function;
        for (int i = 0; i < buckets.size(); ++i) {
        jsonBuilder.field(FIELD_3_NAME, field3Value);
        assertThat(histo, notNullValue());
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
                    .subAggregation(bucketSelector("bucketSelector", script, "field2Sum", "field3Sum"))
        Histogram.Bucket bucket = buckets.get(0);
 */
    public void testInlineScriptNamedVars() {
            Collections.emptyMap()
        Histogram innerHisto = bucket.getAggregations().get("inner_histo");
            .addAggregation(
 * software distributed under the License is distributed on an
        );
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
            } else {
        Histogram histo = response.getAggregations().get("histo");
    private static final String FIELD_2_NAME = "field2";
                    .interval(interval)
            CustomScriptPlugin.NAME,
        assertThat(histo, notNullValue());
        return Collections.singleton(CustomScriptPlugin.class);
        List<? extends Bucket> buckets = histo.getBuckets();
        );
            Collections.emptyMap()
            Sum field3Sum = bucket.getAggregations().get("field3Sum");
    private XContentBuilder newDocBuilder() throws IOException {
                            .subAggregation(derivative("derivative", "_count").gapPolicy(GapPolicy.INSERT_ZEROS))
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
import org.opensearch.core.xcontent.XContentBuilder;
        Script script = new Script(
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
            randomIntBetween(minNumber, maxNumber),
                double value1 = (double) vars.get("_value1");
            if (i == 0) {
            Sum field3Sum = bucket.getAggregations().get("field3Sum");
        builders.add(client().prepareIndex("idx_with_gaps").setSource(newDocBuilder(3, 3, 0, 0)));
            .get();
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
    }
        assertThat(histo, notNullValue());
    @Override
        assertThat(buckets.size(), equalTo(3));
                    .interval(interval)
            .addAggregation(
        indexRandom(true, builders);
        for (int i = 0; i < buckets.size(); ++i) {
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
                    .subAggregation(
            double field3SumValue = field3Sum.getValue();
    }
            Sum field2Sum = bucket.getAggregations().get("field2Sum");
            .get();
            double field2SumValue = field2Sum.getValue();
            new Object[] {
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
            Sum field2Sum = bucket.getAggregations().get("field2Sum");
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
        }
            assertThat(field2SumValue + field3SumValue, greaterThan(100.0));
            )
        }
        SearchResponse response = client().prepareSearch("idx")
            });
import org.opensearch.search.aggregations.metrics.Sum;
        @Override
            assertThat(field2SumValue + field3SumValue, lessThan(10000.0));
        return jsonBuilder;
        SearchResponse response = client().prepareSearch("idx_with_gaps")
import java.util.Collections;
            .addAggregation(
            assertThat(field3SumValue - field2SumValue, greaterThan(0.0));
        assertSearchResponse(response);
        jsonBuilder.endObject();
            scripts.put("Double.isNaN(_value0) ? false : (_value0 < _value1)", vars -> {
            .addAggregation(
        jsonBuilder.startObject();
import org.opensearch.core.common.bytes.BytesArray;
            )
 *
            assertThat(field3Sum, notNullValue());
                        histogram("inner_histo").field(FIELD_1_NAME)
            CustomScriptPlugin.NAME,
            Sum field2Sum = bucket.getAggregations().get("field2Sum");
        Histogram histo = response.getAggregations().get("histo");
            new Object[] {
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
    private static int maxNumber;
                    new BytesArray(
        SearchResponse response = client().prepareSearch("idx")
        bucket = buckets.get(1);
import java.io.IOException;
@OpenSearchIntegTestCase.SuiteScopeTestCase
            double field2SumValue = field2Sum.getValue();
            "Double.isNaN(_value0) ? false : (_value0 + _value1 > threshold)",
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
                double myValue2 = (double) vars.get("my_value2");
            Sum field2Sum = bucket.getAggregations().get("field2Sum");
            Collections.emptyMap()
 * ownership. Elasticsearch licenses this file to you under
            .get();
                    .interval(interval)
        assertThat(buckets.size(), equalTo(0));
            CustomScriptPlugin.NAME,
import org.opensearch.script.ScriptType;
            Sum field2Sum = bucket.getAggregations().get("field2Sum");
            assertThat(field3Sum, notNullValue());
        assertThat(bucket.getKeyAsString(), equalTo("1.0"));
    }
                histogram("histo").field(FIELD_1_NAME)
            CustomScriptPlugin.NAME,
            double field3SumValue = field3Sum.getValue();
        assertThat(innerHisto, notNullValue());
                            + "\", "
            ScriptType.INLINE,
                    )
            assertThat(field2Sum, notNullValue());
        List<? extends Bucket> buckets = histo.getBuckets();
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
            }
        }
    }
                    .subAggregation(bucketSelector("bucketSelector", script, "field2Sum", "field3Sum"))
            Sum field3Sum = bucket.getAggregations().get("field3Sum");
 * GitHub history for details.
                    MediaTypeRegistry.JSON
        innerBuckets = innerHisto.getBuckets();
        }
    public static Collection<Object[]> parameters() {
        assertThat(histo.getName(), equalTo("histo"));
import org.opensearch.core.xcontent.MediaTypeRegistry;
                assertThat(innerBucket.getAggregations().get("derivative"), nullValue());
                    .interval(interval)
                double value1 = (double) vars.get("_value1");
            Collections.emptyMap()
        for (int docs = 0; docs < numDocs; docs++) {
            double field3SumValue = field3Sum.getValue();
            .get();
            assertThat(field2SumValue + field3SumValue, greaterThan(100.0));
    }
        assertSearchResponse(response);
            "Double.isNaN(_value0) ? false : (_value0 < _value1)",
    }
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
        List<IndexRequestBuilder> builders = new ArrayList<>();
            .addAggregation(
                histogram("histo").field(FIELD_1_NAME)
 * You may obtain a copy of the License at
            assertThat(field2Sum, notNullValue());
        Script script = new Script(ScriptType.STORED, null, "my_script", Collections.emptyMap());
        assertSearchResponse(response);
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
            assertThat(field2Sum, notNullValue());
        Script script = new Script(
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
        );
            });
            double field3SumValue = field3Sum.getValue();
                assertThat(innerBucket.getAggregations().get("derivative"), notNullValue());
        List<? extends Bucket> buckets = histo.getBuckets();
    public void testStoredScript() {
                histogram("histo").field(FIELD_1_NAME)
        List<? extends Bucket> buckets = histo.getBuckets();
                histogram("histo").field(FIELD_1_NAME)
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
/*
            scripts.put("Double.isNaN(_value0) ? true : (_value0 < 10000)", vars -> {
public class BucketSelectorIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                            .minDocCount(0)
            assertThat(field2SumValue + field3SumValue, greaterThan(100.0));
                return Double.isNaN(value0) ? true : (value0 < 10000);
                return Double.isNaN(value0) ? false : (value0 + value1 > threshold);
        builders.add(client().prepareIndex("idx_with_gaps").setSource(newDocBuilder(1, 2, 0, 0)));
                histogram("histo").field(FIELD_1_NAME)
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        XContentBuilder jsonBuilder = jsonBuilder();
        for (int i = 0; i < buckets.size(); ++i) {
/*
        createIndex("idx_with_gaps");
        Script script = new Script(
                // Source is not interpreted but my_script is defined in CustomScriptPlugin
    @Override
            double field2SumValue = field2Sum.getValue();
                    .interval(interval)
            Histogram.Bucket bucket = buckets.get(i);
            )
            assertThat(field2SumValue + field3SumValue, greaterThan(100.0));
            Sum field2Sum = bucket.getAggregations().get("field2Sum");
        assertThat(histo.getName(), equalTo("histo"));
            assertThat(field2SumValue + field3SumValue, greaterThan(100.0));
        Histogram histo = response.getAggregations().get("histo");
}
            assertThat(field2Sum, notNullValue());
        }
    }
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
    private static int interval;
        assertThat(innerBuckets.size(), equalTo(4));
    private XContentBuilder newDocBuilder(int field1Value, int field2Value, int field3Value, int field4Value) throws IOException {
/*
        SearchResponse response = client().prepareSearch("idx")
            Sum field2Sum = bucket.getAggregations().get("field2Sum");
        for (int i = 0; i < buckets.size(); ++i) {
            .addAggregation(
        minNumber = -200;
                            + "\"source\": \"Double.isNaN(_value0) ? false : (_value0 + _value1 > 100)\" } }"
            CustomScriptPlugin.NAME,
            )
        );
        createIndex("idx");
    }
        Script script = new Script(
import org.opensearch.action.search.SearchResponse;
    }
    }
        List<? extends Bucket> buckets = histo.getBuckets();
    }
            Sum field3Sum = bucket.getAggregations().get("field3Sum");
 * Licensed to Elasticsearch under one or more contributor
                    .subAggregation(bucketSelector("bucketSelector", script, "field2Sum", "field3Sum"))
            scripts.put("Double.isNaN(_value0) ? false : (_value0 > 10000)", vars -> {
        jsonBuilder.field(FIELD_1_NAME, field1Value);
                double value0 = (double) vars.get("_value0");
 *
            Histogram.Bucket innerBucket = innerBuckets.get(i);
                int threshold = (int) vars.get("threshold");
        assertThat(histo, notNullValue());
                double value0 = (double) vars.get("_value0");
            Histogram.Bucket bucket = buckets.get(i);
        assertThat(histo.getName(), equalTo("histo"));
            scripts.put("Double.isNaN(_value0) ? false : (_value0 + _value1 > 100)", vars -> {
                    .interval(interval)
            Collections.emptyMap()
            Histogram.Bucket bucket = buckets.get(i);
import java.util.Collection;
        assertThat(innerBuckets.size(), equalTo(4));
        Histogram histo = response.getAggregations().get("histo");
            double field3SumValue = field3Sum.getValue();
        Histogram histo = response.getAggregations().get("histo");
            double field2SumValue = field2Sum.getValue();
            .addAggregation(
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
        for (int i = 0; i < buckets.size(); ++i) {
        assertThat(innerBuckets, notNullValue());
        assertSearchResponse(response);
                    .subAggregation(bucketSelector("bucketSelector", script, "field2Sum", "field3Sum"))
                .setContent(
            Collections.singletonMap("threshold", 100)
            scripts.put("Double.isNaN(_value0) ? false : (_value0 > 100)", vars -> {
            ScriptType.INLINE,
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertThat(innerHisto, notNullValue());
        Histogram histo = response.getAggregations().get("histo");
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
                assertThat(innerBucket.getAggregations().get("derivative"), nullValue());
        numDocs = randomIntBetween(10, 500);
import org.opensearch.common.settings.Settings;
        super(staticSettings);
import org.opensearch.script.MockScriptPlugin;
            assertThat(field2Sum, notNullValue());
                return Double.isNaN(value0) ? false : (value0 + value1 > 100);
            .addAggregation(
        jsonBuilder.field(FIELD_4_NAME, field4Value);
                    .subAggregation(bucketSelector("bucketSelector", script, "field2Sum", "field3Sum"))
    private static int numDocs;
        assertThat(bucket, notNullValue());
        Histogram histo = response.getAggregations().get("histo");
 * Modifications Copyright OpenSearch Contributors. See
                    .interval(interval)
        assertThat(histo.getName(), equalTo("histo"));
        bucketPathsMap.put("my_value2", "field3Sum");
            .get();
            "Double.isNaN(_value0) ? false : (_value0 > 100)",
            "Double.isNaN(_value0) ? true : (_value0 < 10000)",
        Script script = new Script(
        Histogram deriv = response.getAggregations().get("histo");
import org.opensearch.action.index.IndexRequestBuilder;
                assertThat(innerBucket.getAggregations().get("derivative"), notNullValue());
    public BucketSelectorIT(Settings staticSettings) {
            ScriptType.INLINE,
            Histogram.Bucket bucket = buckets.get(i);
                return Double.isNaN(value0) ? false : (value0 + value1 > 100);
        SearchResponse response = client().prepareSearch("idx")
    public void testInlineScript() {
import java.util.List;
            assertThat(field3Sum, notNullValue());
        List<? extends Bucket> buckets = histo.getBuckets();
        }
            assertThat(field2Sum, notNullValue());
        }
            });
            scripts.put("Double.isNaN(my_value1) ? false : (my_value1 + my_value2 > 100)", vars -> {
        Script script = new Script(
        assertSearchResponse(response);
        List<? extends Bucket> buckets = histo.getBuckets();
            double field2SumValue = field2Sum.getValue();
        maxNumber = 200;
                histogram("histo").field(FIELD_1_NAME)
            });
                histogram("histo").field(FIELD_1_NAME)
                    .interval(interval)
            CustomScriptPlugin.NAME,
            CustomScriptPlugin.NAME,
        assertSearchResponse(response);
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
            "Double.isNaN(_value0) ? false : (_value0 > 10000)",
            assertThat(field2Sum, notNullValue());
        SearchResponse response = client().prepareSearch("idx")
    public void testUnmapped() throws Exception {
        assertThat(histo.getName(), equalTo("histo"));
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
    public void testInlineScriptSingleVariable() {
    private static final String FIELD_4_NAME = "field4";
 * this file be licensed under the Apache-2.0 license or a
                double value1 = (double) vars.get("_value1");
    public void testInlineScript2() {
    }
                histogram("histo").field(FIELD_1_NAME)
            .addAggregation(
        return newDocBuilder(
    }
                return Double.isNaN(value0) ? false : (value0 > 10000);
            )
        SearchResponse response = client().prepareSearch("idx_unmapped")
        );
            assertThat(field2Sum, notNullValue());
        builders.add(client().prepareIndex("idx_with_gaps").setSource(newDocBuilder(3, 1, 0, 0)));
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.derivative;
    public static class CustomScriptPlugin extends MockScriptPlugin {
                assertThat(innerBucket.getAggregations().get("derivative"), notNullValue());
    private static final String FIELD_1_NAME = "field1";
                        "{ \"script\": { \"lang\": \""
                double value0 = (double) vars.get("_value0");
            double field3SumValue = field3Sum.getValue();
            }
        );
    }
            scripts.put("Double.isNaN(_value0) ? false : (_value0 + _value1 > threshold)", vars -> {
            assertThat(field2Sum, notNullValue());
            });
                )
        Map<String, String> bucketPathsMap = new HashMap<>();
import static org.hamcrest.Matchers.greaterThan;
            Sum field3Sum = bucket.getAggregations().get("field3Sum");
            } else {
package org.opensearch.search.aggregations.pipeline;
            Sum field2Sum = bucket.getAggregations().get("field2Sum");
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
        assertSearchResponse(response);
        List<? extends Bucket> buckets = histo.getBuckets();
            });
            )
    public void testInlineScriptNoBucketsLeft() {
        ensureSearchable();
 * KIND, either express or implied.  See the License for the
        );
        List<? extends Bucket> buckets = histo.getBuckets();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        bucket = buckets.get(2);
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
            Collections.emptyMap()
            .get();
 */
            .get();
    private static final String FIELD_3_NAME = "field3";
        assertThat(innerHisto, notNullValue());
                return (value0 + value1 > 100);
            "Double.isNaN(_value0) ? false : (_value0 + _value1 > 100)",
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
                double value0 = (double) vars.get("_value0");
                double value0 = (double) vars.get("_value0");
import static org.hamcrest.Matchers.equalTo;
            assertThat(field3Sum, notNullValue());
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
    public void testInlineScriptWithParams() {
        assertThat(bucket.getKeyAsString(), equalTo("3.0"));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    public void testInlineScriptNoBucketsPruned() {
            scripts.put("my_script", vars -> {
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
            return scripts;
                .setId("my_script")
            });
            .get();
            Histogram.Bucket bucket = buckets.get(i);
        createIndex("idx_unmapped");
    }
            });
        assertSearchResponse(response);
                histogram("histo").field(FIELD_1_NAME)
        innerHisto = bucket.getAggregations().get("inner_histo");
            assertThat(field3Sum, notNullValue());
        for (int i = 0; i < buckets.size(); ++i) {
    }
            )
        );
            "Double.isNaN(_value0) ? false : (_value0 + _value1 > 100)",
        builders.add(client().prepareIndex("idx_with_gaps").setSource(newDocBuilder(1, 1, 0, 0)));
        }
        assertThat(histo.getName(), equalTo("histo"));
            .get();
            double field2SumValue = field2Sum.getValue();
        assertSearchResponse(response);
        assertThat(bucket, notNullValue());
            .get();
            Histogram.Bucket bucket = buckets.get(i);
                double value0 = (double) vars.get("_value0");
    public void testEmptyBuckets() {
            assertThat(field2SumValue, greaterThan(100.0));
        assertThat(innerBuckets.size(), equalTo(4));
        SearchResponse response = client().prepareSearch("idx")
                double myValue1 = (double) vars.get("my_value1");
            new Object[] {
            if (i == 0) {
    }
                .preparePutStoredScript()
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
            .addAggregation(
        assertThat(bucket.getKeyAsString(), equalTo("2.0"));
                assertThat(innerBucket.getAggregations().get("derivative"), nullValue());
        );
            ScriptType.INLINE,
        for (int i = 0; i < innerBuckets.size(); i++) {
            assertThat(field2SumValue + field3SumValue, greaterThan(100.0));
import java.util.Map;
        SearchResponse response = client().prepareSearch("idx")
        Script script = new Script(
                histogram("histo").field(FIELD_1_NAME)
                histogram("histo").field(FIELD_1_NAME)
 * this work for additional information regarding copyright
                    .interval(interval)
import org.opensearch.test.OpenSearchIntegTestCase;
            if (i == 0) {
            }
            assertThat(field3Sum, notNullValue());
            Sum field2Sum = bucket.getAggregations().get("field2Sum");
import org.opensearch.plugins.Plugin;
        List<? extends Bucket> buckets = histo.getBuckets();
        }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        List<? extends Bucket> buckets = histo.getBuckets();
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
            Histogram.Bucket bucket = buckets.get(i);
        );
        }
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
            "Double.isNaN(my_value1) ? false : (my_value1 + my_value2 > 100)",
 * license agreements. See the NOTICE file distributed with
        for (int i = 0; i < innerBuckets.size(); i++) {
                histogram("histo").field(FIELD_1_NAME)
        SearchResponse response = client().prepareSearch("idx")
            CustomScriptPlugin.NAME,
            });
 */
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
                    .subAggregation(bucketSelector("bucketSelector", script, "field2Sum", "field3Sum"))
 * SPDX-License-Identifier: Apache-2.0
        assertThat(deriv.getBuckets().size(), equalTo(0));
