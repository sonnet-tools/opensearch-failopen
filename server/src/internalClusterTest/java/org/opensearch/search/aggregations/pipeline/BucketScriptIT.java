        assertThat(range.getName(), equalTo("range"));
                        bucketScript(
    public void testStoredScript() {
import org.opensearch.common.settings.Settings;
            } else {
                            "seriesArithmetic",
                double field4SumValue = field4Sum.getValue();
    public void testArrayBucketPathAgg() throws Exception {
                    .subAggregation(sum("field4Sum").field(FIELD_4_NAME))
        BucketScriptPipelineAggregationBuilder bucketScriptAgg = BucketScriptPipelineAggregationBuilder.PARSER.parse(
    }
                double value1 = (double) vars.get("_value1");
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .addAggregation(
    public void testInlineScriptReturnNull() {
        interval = randomIntBetween(1, 50);
                            "seriesArithmetic",
                )
                    .interval(interval)
import org.opensearch.action.search.SearchResponse;
        List<IndexRequestBuilder> builders = new ArrayList<>();
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
                assertThat(field4Sum, notNullValue());
        Range range = response.getAggregations().get("range");
                    .subAggregation(
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
                    .subAggregation(sum("field4Sum").field(FIELD_4_NAME))
        jsonBuilder.field(FIELD_4_NAME, randomIntBetween(minNumber, maxNumber));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
                Sum field3Sum = bucket.getAggregations().get("field3Sum");
    public static class CustomScriptPlugin extends MockScriptPlugin {
            .field("source", "_value0 + _value1 + _value2")
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
                double seriesArithmeticValue = seriesArithmetic.value();
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
                assertThat(seriesArithmetic, notNullValue());
                Sum field2Sum = bucket.getAggregations().get("field2Sum");
        assertThat(deriv.getBuckets().size(), equalTo(0));
import java.util.ArrayList;
    public void testUnmapped() throws Exception {
        SearchResponse response = client().prepareSearch("idx")
        assertThat(histo, notNullValue());
                    )
            .endObject();
            Histogram.Bucket bucket = buckets.get(i);
    public void setupSuiteScopeCluster() throws Exception {
        assertThat(histo.getName(), equalTo("histo"));
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "(_value0 + _value1 + _value2) * factor", params);
                assertThat(seriesArithmeticValue, equalTo(field2SumValue + field3SumValue + field4SumValue));
                            new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value0 + _value1 + _value2", Collections.emptyMap()),
        XContentBuilder content = XContentFactory.jsonBuilder()
                double seriesArithmeticValue = seriesArithmetic.value();
            .get();
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
            .startObject()
 */
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
            .endObject();
                            "field2Sum",
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
                assertThat(field2Sum, notNullValue());
    }
            scripts.put("(_value0 + _value1 + _value2) * factor", vars -> {
                assertThat(field4Sum, notNullValue());
        numDocs = randomIntBetween(10, 500);
            });
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                    .subAggregation(
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
                            "seriesArithmetic",
            } else {
                assertThat(field4Sum, notNullValue());
        for (int i = 0; i < buckets.size(); ++i) {
                Sum field3Sum = bucket.getAggregations().get("field3Sum");
                    .subAggregation(bucketScriptAgg)
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
                            "field4Sum"
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
                assertThat(seriesArithmetic, notNullValue());
                Sum field4Sum = bucket.getAggregations().get("field4Sum");
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
                histogram("histo").field(FIELD_1_NAME)
            scripts.put("my_script", vars -> {
                            "field2Sum",
import java.io.IOException;
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
                assertThat(field4Sum, notNullValue());
                            "seriesArithmetic",
import org.opensearch.core.xcontent.XContentBuilder;
                Sum field2Sum = bucket.getAggregations().get("field2Sum");
        assertThat(histo, notNullValue());
                assertThat(field3Sum, notNullValue());
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
            createParser(content),
        assertThat(histo.getName(), equalTo("histo"));
                assertThat(seriesArithmetic, nullValue());
        jsonBuilder.field(FIELD_5_NAME, date);
                double value2 = (double) vars.get("_value2");
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
                            bucketsPathsMap,
        }
        Histogram histo = response.getAggregations().get("histo");
            .field("lang", CustomScriptPlugin.NAME)
        }
        Histogram histo = response.getAggregations().get("histo");
            "seriesArithmetic"
            client().admin()
                            new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value0", Collections.emptyMap()),
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
        assertSearchResponse(response);
    }
                assertThat(seriesArithmetic, nullValue());
                assertThat(field2Sum, notNullValue());
                .setId("my_script")
        }
                Sum field2Sum = bucket.getAggregations().get("field2Sum");
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
                assertThat(field2Sum, notNullValue());
    }
                    .subAggregation(sum("field4Sum").field(FIELD_4_NAME))
                histogram("histo").field(FIELD_1_NAME)
                assertThat(seriesArithmetic, nullValue());
                return value0 + value1 / value2;
        assertThat(deriv.getName(), equalTo("histo"));
/*
    private static final String FIELD_4_NAME = "field4";
            )
                Sum field3Sum = bucket.getAggregations().get("field3Sum");
                assertThat(field3Sum, notNullValue());
            .addAggregation(
import org.opensearch.search.aggregations.metrics.Sum;
                    )
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
            if (bucket.getDocCount() == 0) {
                    new BytesArray("{ \"script\": {\"lang\": \"" + CustomScriptPlugin.NAME + "\"," + " \"source\": \"my_script\" } }"),
                assertThat(seriesArithmetic, notNullValue());
                    .interval(interval)
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
            }
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
    public static Collection<Object[]> parameters() {
import org.opensearch.test.OpenSearchIntegTestCase;
                        bucketScript(
            if (bucket.getDocCount() == 0) {
            .field("_value1", "field3Sum")
        jsonBuilder.startObject();
 */
                assertThat(seriesArithmetic, nullValue());
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
import java.util.Map;
            .array("buckets_path", "field2Sum", "field3Sum", "field4Sum")
    public void testInlineScriptWithDateRange() {
            .addAggregation(
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
            Histogram.Bucket bucket = buckets.get(i);
            )
                assertThat(field4Sum, notNullValue());
                assertThat(seriesArithmetic, nullValue());
                double field2SumValue = field2Sum.getValue();
            Histogram.Bucket bucket = buckets.get(i);
                assertThat(seriesArithmetic, notNullValue());
            .startObject("buckets_path")
            Histogram.Bucket bucket = buckets.get(i);
                    )
                    .subAggregation(
            )
                double seriesArithmeticValue = seriesArithmetic.value();
            "seriesArithmetic"
        Map<String, String> bucketsPathsMap = new HashMap<>();
            });
                        )
                            "field2Sum"
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
 * this file be licensed under the Apache-2.0 license or a
    }
                        bucketScript(
                histogram("histo").field(FIELD_1_NAME)
    public void testObjectBucketPathAgg() throws Exception {
                histogram("histo").field(FIELD_1_NAME)
                assertThat(field3Sum, notNullValue());
            new Object[] {
        jsonBuilder.field(FIELD_3_NAME, randomIntBetween(minNumber, maxNumber));
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
                    .interval(interval)
        assertSearchResponse(response);
            }
            )
                assertThat(field4Sum, notNullValue());
                assertThat(field3Sum, notNullValue());
    private XContentBuilder newDocBuilder() throws IOException {
            .get();
                double field4SumValue = field4Sum.getValue();
                Sum field3Sum = bucket.getAggregations().get("field3Sum");
 */
                    .subAggregation(
        return Collections.singleton(CustomScriptPlugin.class);
            .endObject()
        assertSearchResponse(response);
            .field("_value0", "field2Sum")
        XContentBuilder content = XContentFactory.jsonBuilder()
    }
                double value = (double) vars.get("_value");
            Histogram.Bucket bucket = buckets.get(i);
                    .interval(interval)
                double value1 = (double) vars.get("_value1");
 *
        );
 * Licensed to Elasticsearch under one or more contributor
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
                double field2SumValue = field2Sum.getValue();
                            new Script(ScriptType.STORED, null, "my_script", Collections.emptyMap()),
                double foo = (double) vars.get("foo");
    }
        SearchResponse response = client().prepareSearch("idx")
                double seriesArithmeticValue = seriesArithmetic.value();
            if (bucket.getDocCount() == 0) {
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
                double field4SumValue = field4Sum.getValue();
            builders.add(client().prepareIndex("idx").setSource(newDocBuilder()));
            } else {
                        bucketScript(
                double value1 = (double) vars.get("_value1");
            createParser(content),
                .cluster()
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
            .field("_value2", "field4Sum")
            )
    }
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        Histogram histo = response.getAggregations().get("histo");
        return jsonBuilder;
            )
                            "field4Sum"
            .field("buckets_path", "field2Sum")
        }
                        )
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
                assertThat(seriesArithmetic, notNullValue());
                assertThat(seriesArithmeticValue, equalTo(field2SumValue + field3SumValue + field4SumValue));
 * compatible open source license.
                histogram("histo").field(FIELD_1_NAME)
import org.opensearch.plugins.Plugin;
 * not use this file except in compliance with the License.
        Histogram deriv = response.getAggregations().get("histo");
        Histogram histo = response.getAggregations().get("histo");
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
                assertThat(field2Sum, notNullValue());
                double value2 = (double) vars.get("_value2");
                        )
                double field4SumValue = field4Sum.getValue();
            }
                double seriesArithmeticValue = seriesArithmetic.value();
                    .interval(interval)
                assertThat(field4Sum, notNullValue());
            .addAggregation(
            .get();
                    .subAggregation(
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
            }
        SearchResponse response = client().prepareSearch("idx")
            .addAggregation(
            Histogram.Bucket bucket = buckets.get(i);
        XContentBuilder jsonBuilder = jsonBuilder();
                Sum field4Sum = bucket.getAggregations().get("field4Sum");
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
                        )
            }
                double field3SumValue = field3Sum.getValue();
            Histogram.Bucket bucket = buckets.get(i);
            scripts.put("return null", vars -> null);
            )
                assertThat(seriesArithmeticValue, equalTo(field2SumValue + field3SumValue + field4SumValue));
    }
                histogram("histo").field(FIELD_1_NAME)
                assertThat(field4Sum, notNullValue());
        Histogram histo = response.getAggregations().get("histo");
            Histogram.Bucket bucket = buckets.get(i);
        }
            .addAggregation(
            scripts.put("_value0 + _value1 + _value2", vars -> {
        SearchResponse response = client().prepareSearch("idx")
                double seriesArithmeticValue = seriesArithmetic.value();
            .get();
            )
 * ownership. Elasticsearch licenses this file to you under
                return value0 + value1 + value2;
                assertThat(seriesArithmetic, notNullValue());
            )
                assertThat(seriesArithmetic, notNullValue());
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
        jsonBuilder.endObject();
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        assertSearchResponse(response);
            Range.Bucket bucket = buckets.get(i);
                            "field3Sum",
                double field2SumValue = field2Sum.getValue();
                            new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value0 + _value1 / _value2", Collections.emptyMap()),
                double field2SumValue = field2Sum.getValue();
        for (int i = 0; i < buckets.size(); ++i) {
            });
        assertSearchResponse(response);
                            "field3Sum",
    public void testInlineScriptSingleVariable() {
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
 * under the License.
        }
                double seriesArithmeticValue = seriesArithmetic.value();
                histogram("histo").field(FIELD_1_NAME)
            }
    private static long date;
            assertNull(bucket.getAggregations().get("nullField"));
                            "field2Sum",
                Sum field4Sum = bucket.getAggregations().get("field4Sum");
        }
        }
                            new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value0 + _value1 + _value2", Collections.emptyMap()),
                double seriesArithmeticValue = seriesArithmetic.value();
            return scripts;
                    .subAggregation(sum("field4Sum").field(FIELD_4_NAME))
        params.put("factor", 3);
                return foo + bar + baz;
                            "field2Sum",
        createIndex("idx_unmapped");
    private static int minNumber;
    @Override
        assertSearchResponse(response);
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
            if (bucket.getDocCount() == 0) {
                assertThat(seriesArithmeticValue, equalTo(field2SumValue + field3SumValue + field4SumValue));
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
                    )
                double value0 = (double) vars.get("_value0");
        SearchResponse response = client().prepareSearch("idx")
            }
                assertThat(field2Sum, notNullValue());
        for (int i = 0; i < buckets.size(); ++i) {
                Sum field3Sum = bucket.getAggregations().get("field3Sum");
                    .subAggregation(
        SearchResponse response = client().prepareSearch("idx_unmapped")
    private static int maxNumber;
                            "field4Sum"
                    .subAggregation(
        }
            if (bucket.getDocCount() == 0) {
        indexRandom(true, builders);
                    .subAggregation(bucketScript("seriesArithmetic", script, "field2Sum", "field3Sum", "field4Sum"))
                        bucketScript(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
import static org.hamcrest.Matchers.notNullValue;
            .addAggregation(
            createParser(content),
    }
            .get();
        super(staticSettings);
            )
                double field4SumValue = field4Sum.getValue();
        bucketsPathsMap.put("bar", "field3Sum");
            .get();
                assertThat(seriesArithmetic, notNullValue());
                .setContent(
import org.opensearch.common.xcontent.XContentFactory;
                // Script source is not interpreted but it references a pre-defined script from CustomScriptPlugin
}
            if (bucket.getDocCount() == 0) {
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
import java.util.HashMap;
                            "field3Sum",
        SearchResponse response = client().prepareSearch("idx")
                        )
                double field4SumValue = field4Sum.getValue();
                        bucketScript(
                assertThat(seriesArithmeticValue, equalTo(field2SumValue + field3SumValue + field4SumValue));
        minNumber = -200;
    public void testInlineScript2() {
                histogram("histo").field(FIELD_1_NAME)
            Histogram.Bucket bucket = buckets.get(i);
            scripts.put("single_input", vars -> {
            }
                double value0 = (double) vars.get("_value0");
                Sum field2Sum = bucket.getAggregations().get("field2Sum");
        assertThat(histo.getName(), equalTo("histo"));
                assertThat(seriesArithmeticValue, equalTo(field2SumValue));
                assertThat(seriesArithmetic, nullValue());
                double value2 = (double) vars.get("_value2");
            .endObject()
                double field2SumValue = field2Sum.getValue();
                            "seriesArithmetic",
                assertThat(field4Sum, notNullValue());
            .startObject("script")
                    )
                    )
            .addAggregation(
import static org.opensearch.search.aggregations.AggregationBuilders.dateRange;
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
    private static int numDocs;
                Sum field4Sum = bucket.getAggregations().get("field4Sum");
            scripts.put("_value0 + _value1 / _value2", vars -> {
        );
    public void testInlineScriptInsertZeros() {
        createIndex("idx");
                            new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "return null", Collections.emptyMap())
                assertThat(field2Sum, notNullValue());
                            new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value0 + _value1 + _value2", Collections.emptyMap()),
            )
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
        ensureSearchable();
        assertThat(histo, notNullValue());
            .endObject()
            "seriesArithmetic"
 *
        Histogram histo = response.getAggregations().get("histo");
import java.util.function.Function;
                double field3SumValue = field3Sum.getValue();
            if (bucket.getDocCount() == 0) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
        );
                assertThat(field4Sum, notNullValue());
                Sum field2Sum = bucket.getAggregations().get("field2Sum");
        date = randomLong();
@OpenSearchIntegTestCase.SuiteScopeTestCase
                double field3SumValue = field3Sum.getValue();
            .startObject()
                Sum field2Sum = bucket.getAggregations().get("field2Sum");
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
        );
        assertThat(histo.getName(), equalTo("histo"));
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
            }
                double field3SumValue = field3Sum.getValue();
        assertThat(histo.getName(), equalTo("histo"));
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
            } else {
        }
    private static final String FIELD_1_NAME = "field1";
    }
    }
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
        assertThat(histo, notNullValue());
            if (bucket.getDocCount() == 0) {
                    .interval(interval)
        for (int i = 0; i < buckets.size(); ++i) {
                double field2SumValue = field2Sum.getValue();
            .field("lang", CustomScriptPlugin.NAME)
        Histogram histo = response.getAggregations().get("histo");
                double field3SumValue = field3Sum.getValue();
            if (bucket.getDocCount() == 0) {
        assertThat(histo.getName(), equalTo("histo"));
            Histogram.Bucket bucket = buckets.get(i);
 * GitHub history for details.
                Sum field3Sum = bucket.getAggregations().get("field3Sum");
    public void testInlineScriptWithParams() {
            new Object[] {
            .addAggregation(
        assertAcked(
    }
                            "field3Sum",
        assertThat(histo, notNullValue());
                    )
 * The OpenSearch Contributors require contributions made to
        Histogram histo = response.getAggregations().get("histo");
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
        assertSearchResponse(response);
        assertThat(histo.getName(), equalTo("histo"));
            )
            if (bucket.getDocCount() == 0) {
            .get();
 * the Apache License, Version 2.0 (the "License"); you may
        for (int i = 0; i < buckets.size(); ++i) {
                assertThat(field3Sum, notNullValue());
                    )
            }
                double field2SumValue = field2Sum.getValue();
        return Arrays.asList(
                assertThat(seriesArithmetic, nullValue());
            .field("source", "_value0 + _value1 + _value2")
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
 * this work for additional information regarding copyright
                    .subAggregation(bucketScriptAgg)
                            "nullField",
                Sum field2Sum = bucket.getAggregations().get("field2Sum");
    }
                assertThat(field2Sum, notNullValue());
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
                assertThat(field3Sum, notNullValue());
                assertThat(seriesArithmetic, nullValue());
            if (bucket.getDocCount() == 0) {
                            "field2Sum",
                assertThat(field2Sum, notNullValue());
            .addAggregation(
            }
                        )
    private static int interval;
            });
                    .subAggregation(sum("field4Sum").field(FIELD_4_NAME))
                .preparePutStoredScript()
        SearchResponse response = client().prepareSearch("idx")
                            "field3Sum",
                histogram("histo").field(FIELD_1_NAME)
        @Override
        maxNumber = 200;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    public BucketScriptIT(Settings staticSettings) {
        assertThat(deriv, notNullValue());
        bucketsPathsMap.put("baz", "field4Sum");
                histogram("histo").field(FIELD_1_NAME)
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
        }
package org.opensearch.search.aggregations.pipeline;
            .get();
                assertThat(seriesArithmeticValue, equalTo(field2SumValue + field3SumValue + field4SumValue));
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            scripts.put("foo + bar + baz", vars -> {
        );
            .addAggregation(
                histogram("histo").field(FIELD_1_NAME)
                double seriesArithmeticValue = seriesArithmetic.value();
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
import org.opensearch.script.ScriptType;
        }
                double value0 = (double) vars.get("_value0");
                        bucketScript(
            .endObject()
        bucketsPathsMap.put("foo", "field2Sum");
                assertThat(field3Sum, notNullValue());
                    .subAggregation(
        for (int docs = 0; docs < numDocs; docs++) {
                return value;
    public void testInlineScript() {
                        )
                            "field2Sum",
    public void testSingleBucketPathAgg() throws Exception {
import static org.hamcrest.Matchers.equalTo;
        for (int i = 0; i < buckets.size(); ++i) {
                double field2SumValue = field2Sum.getValue();
                return value0 + value1 + value2;
                assertThat(seriesArithmetic, notNullValue());
                    .interval(interval)
import java.util.Arrays;
                double field3SumValue = field3Sum.getValue();
                            new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value0 + _value1 + _value2", Collections.emptyMap()),
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
                Sum field2Sum = bucket.getAggregations().get("field2Sum");
        BucketScriptPipelineAggregationBuilder bucketScriptAgg = BucketScriptPipelineAggregationBuilder.PARSER.parse(
    @ParametersFactory
            } else {
        for (int i = 0; i < buckets.size(); ++i) {
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
            } else {
                return (value0 + value1 + value2) * (int) vars.get("factor");
                Sum field2Sum = bucket.getAggregations().get("field2Sum");
                    .subAggregation(sum("field4Sum").field(FIELD_4_NAME))
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
    }
            });
                Sum field3Sum = bucket.getAggregations().get("field3Sum");
            .addAggregation(
        for (int i = 0; i < buckets.size(); ++i) {
            .field("source", "single_input")
        XContentBuilder content = XContentFactory.jsonBuilder()
        SearchResponse response = client().prepareSearch("idx")
                    .subAggregation(sum("field4Sum").field(FIELD_4_NAME))
                    .addUnboundedFrom(date)
                double seriesArithmeticValue = seriesArithmetic.value();
        List<? extends Range.Bucket> buckets = range.getBuckets();
            )
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
            .field("lang", CustomScriptPlugin.NAME)
            .addAggregation(
                    .interval(interval)
    @Override
                Sum field3Sum = bucket.getAggregations().get("field3Sum");
            } else {
                double field4SumValue = field4Sum.getValue();
                assertThat(field3Sum, notNullValue());
    }
                double baz = (double) vars.get("baz");
                double seriesArithmeticValue = seriesArithmetic.value();
                double field3SumValue = field3Sum.getValue();
            scripts.put("_value0", vars -> vars.get("_value0"));
                double field2SumValue = field2Sum.getValue();
                    .interval(interval)
            .addAggregation(
            Histogram.Bucket bucket = buckets.get(i);
    private static final String FIELD_3_NAME = "field3";
        assertThat(histo, notNullValue());
        assertThat(histo, notNullValue());
 * software distributed under the License is distributed on an
                assertThat(seriesArithmeticValue, equalTo((field2SumValue + field3SumValue + field4SumValue) * 3));
        Histogram histo = response.getAggregations().get("histo");
                    .interval(interval)
        assertThat(histo, notNullValue());
                double field3SumValue = field3Sum.getValue();
                double field2SumValue = field2Sum.getValue();
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
                assertThat(seriesArithmeticValue, equalTo(field2SumValue + field3SumValue / field4SumValue));
                assertThat(seriesArithmetic, notNullValue());
                assertThat(field2Sum, notNullValue());
        SearchResponse response = client().prepareSearch("idx")
                        bucketScript(
                    )
                    .subAggregation(sum("field4Sum").field(FIELD_4_NAME))
                assertThat(field3Sum, notNullValue());
        for (int i = 0; i < buckets.size(); ++i) {
import org.opensearch.search.aggregations.bucket.range.Range;
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
                            new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value0 + _value1 + _value2", Collections.emptyMap()),
                    MediaTypeRegistry.JSON
 * Unless required by applicable law or agreed to in writing,
        assertThat(histo, notNullValue());
            new Object[] {
            .startObject()
        assertThat(range, notNullValue());
                double field4SumValue = field4Sum.getValue();
        assertThat(histo.getName(), equalTo("histo"));
                double field2SumValue = field2Sum.getValue();
        }
            });
    public void testPartiallyUnmapped() throws Exception {
                            "field4Sum"
                assertThat(seriesArithmeticValue, equalTo(field2SumValue + field3SumValue + field4SumValue));
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
import java.util.Collections;
            .startObject("script")
        }
        for (int i = 0; i < buckets.size(); ++i) {
                            "field2Sum",
                assertThat(field2Sum, notNullValue());
            .get();
            .get();
                double seriesArithmeticValue = seriesArithmetic.value();
                    )
        assertThat(histo, notNullValue());
import static org.hamcrest.Matchers.nullValue;
import java.util.List;
                Sum field4Sum = bucket.getAggregations().get("field4Sum");
                Sum field3Sum = bucket.getAggregations().get("field3Sum");
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
                double field3SumValue = field3Sum.getValue();
            } else {
 * You may obtain a copy of the License at
                            "field4Sum"
        assertSearchResponse(response);
                Sum field4Sum = bucket.getAggregations().get("field4Sum");
                        )
                Sum field4Sum = bucket.getAggregations().get("field4Sum");
                double field2SumValue = field2Sum.getValue();
 * specific language governing permissions and limitations
                        bucketScript(
                Sum field4Sum = bucket.getAggregations().get("field4Sum");
                    .interval(interval)
                            "field3Sum",
                double value0 = (double) vars.get("_value0");
                            "seriesArithmetic",
                assertThat(seriesArithmetic, nullValue());
            .endObject();
                    .subAggregation(sum("field4Sum").field(FIELD_4_NAME))
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
/*
        assertSearchResponse(response);
        jsonBuilder.field(FIELD_2_NAME, randomIntBetween(minNumber, maxNumber));
import org.opensearch.action.index.IndexRequestBuilder;
                    .interval(interval)
                    .subAggregation(sum("field4Sum").field(FIELD_4_NAME))
        assertThat(histo, notNullValue());
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
        BucketScriptPipelineAggregationBuilder bucketScriptAgg = BucketScriptPipelineAggregationBuilder.PARSER.parse(
import org.opensearch.script.MockScriptPlugin;
    private static final String FIELD_5_NAME = "field5";
import java.util.Collection;
        assertSearchResponse(response);
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
                assertThat(seriesArithmetic, notNullValue());
            .get();
                double field4SumValue = field4Sum.getValue();
    }
            if (bucket.getDocCount() == 0) {
                double field3SumValue = field3Sum.getValue();
            .get();
                assertThat(seriesArithmetic, nullValue());
                        )
 * license agreements. See the NOTICE file distributed with
        assertSearchResponse(response);
        assertThat(histo.getName(), equalTo("histo"));
                            "field4Sum"
        assertSearchResponse(response);
                Sum field4Sum = bucket.getAggregations().get("field4Sum");
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
        }
                assertThat(seriesArithmeticValue, equalTo(field2SumValue));
        assertSearchResponse(response);
                    .subAggregation(sum("field4Sum").field(FIELD_4_NAME))
                assertThat(seriesArithmetic, nullValue());
import org.opensearch.script.Script;
            .startObject("script")
                            "seriesArithmetic",
        assertThat(histo, notNullValue());
                assertThat(seriesArithmeticValue, equalTo(0.0));
                    .subAggregation(
    }
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
        Histogram histo = response.getAggregations().get("histo");
    }
                Sum field2Sum = bucket.getAggregations().get("field2Sum");
                assertThat(seriesArithmetic, notNullValue());
            Histogram.Bucket bucket = buckets.get(i);
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
                            new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "foo + bar + baz", Collections.emptyMap())
 *
                double bar = (double) vars.get("bar");
        assertThat(histo.getName(), equalTo("histo"));
            } else {
        for (int i = 0; i < buckets.size(); ++i) {
                double value2 = (double) vars.get("_value2");
        Histogram histo = response.getAggregations().get("histo");
        assertThat(histo.getName(), equalTo("histo"));
                            "field4Sum"
                double seriesArithmeticValue = seriesArithmetic.value();
                Sum field2Sum = bucket.getAggregations().get("field2Sum");
            } else {
        for (int i = 0; i < buckets.size(); ++i) {
                dateRange("range").field(FIELD_5_NAME)
                            "seriesArithmetic",
                double field4SumValue = field4Sum.getValue();
        assertThat(histo.getName(), equalTo("histo"));
                        bucketScript(
        Map<String, Object> params = new HashMap<>();
                histogram("histo").field(FIELD_1_NAME)
            )
            } else {
/*
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.bucketScript;
    private static final String FIELD_2_NAME = "field2";
    }
                SimpleValue seriesArithmetic = bucket.getAggregations().get("seriesArithmetic");
                        ).gapPolicy(GapPolicy.INSERT_ZEROS)
            .get();
                    .interval(interval)
                double value1 = (double) vars.get("_value1");
import org.opensearch.core.common.bytes.BytesArray;
                    .subAggregation(
                            "seriesArithmetic",
                    .subAggregation(bucketScriptAgg)
                Sum field2Sum = bucket.getAggregations().get("field2Sum");
        jsonBuilder.field(FIELD_1_NAME, randomIntBetween(minNumber, maxNumber));
                assertThat(field3Sum, notNullValue());
                assertThat(field2Sum, notNullValue());
                histogram("histo").field(FIELD_1_NAME)
            .get();
public class BucketScriptIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                assertThat(field2Sum, notNullValue());
    public void testInlineScriptNamedVars() {
                assertThat(seriesArithmeticValue, equalTo(field2SumValue + field3SumValue + field4SumValue));
                assertThat(seriesArithmetic, notNullValue());
        for (int i = 0; i < buckets.size(); ++i) {
        Histogram histo = response.getAggregations().get("histo");
            } else {
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
                Sum field3Sum = bucket.getAggregations().get("field3Sum");
                Sum field4Sum = bucket.getAggregations().get("field4Sum");
                            "field3Sum",
            }
        assertSearchResponse(response);
