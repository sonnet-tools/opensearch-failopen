import java.util.HashMap;
            double field3SumValue = field3Sum.getValue();
    }
            Sum field3Sum = bucket.getAggregations().get("field3Sum");  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
            assertThat(field2SumValue + field3SumValue, greaterThan(100.0));  
                    )  
            double field2SumValue = field2Sum.getValue();
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
    }  
        List<? extends Histogram.Bucket> innerBuckets = innerHisto.getBuckets();
        );
            .get();
        List<? extends Bucket> buckets = histo.getBuckets();
            )  
        assertThat(innerBuckets.size(), equalTo(4));  
import org.opensearch.core.common.bytes.BytesArray;  
            )  
            )
        );
        );  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
                            .subAggregation(derivative("derivative", "_count").gapPolicy(GapPolicy.INSERT_ZEROS))
        );
        bucketPathsMap.put("my_value2", "field3Sum");
            "Double.isNaN(_value0) ? false : (_value0 > 10000)",
        List<? extends Bucket> buckets = histo.getBuckets();
                double value0 = (double) vars.get("_value0");
                )  
            });
        assertThat(deriv, notNullValue());
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
            scripts.put("Double.isNaN(_value0) ? false : (_value0 + _value1 > 100)", vars -> {  
    }
        bucket = buckets.get(1);
            Histogram.Bucket bucket = buckets.get(i);
    public void setupSuiteScopeCluster() throws Exception {  
                histogram("histo").field(FIELD_1_NAME)
            assertThat(field3Sum, notNullValue());  
    public void testEmptyBuckets() {
            CustomScriptPlugin.NAME,  
        assertThat(histo, notNullValue());
            Collections.emptyMap()  
                    .interval(interval)  
    }
            new Object[] {
            scripts.put("Double.isNaN(_value0) ? false : (_value0 > 10000)", vars -> {
        assertThat(deriv.getBuckets().size(), equalTo(0));  
            assertThat(field2Sum, notNullValue());
                            + "\"source\": \"Double.isNaN(_value0) ? false : (_value0 + _value1 > 100)\" } }"  
 * ownership. Elasticsearch licenses this file to you under  
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
                    .subAggregation(bucketSelector("bucketSelector", script, "field2Sum"))
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
        assertSearchResponse(response);  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 *
import java.util.Collections;  
        Histogram histo = response.getAggregations().get("histo");
 *
            scripts.put("Double.isNaN(_value0) ? true : (_value0 < 10000)", vars -> {  
}
            new Object[] {  
        jsonBuilder.startObject();
        assertThat(bucket.getKeyAsString(), equalTo("2.0"));
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
                .cluster()  
        assertThat(histo.getName(), equalTo("histo"));
            Histogram.Bucket bucket = buckets.get(i);
            });  
import static org.hamcrest.Matchers.nullValue;  
        assertSearchResponse(response);  
                double value0 = (double) vars.get("_value0");
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))  
            if (i == 0) {  
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
            CustomScriptPlugin.NAME,  
        assertThat(innerBuckets.size(), equalTo(4));
            return scripts;
                double value1 = (double) vars.get("_value1");
 * KIND, either express or implied.  See the License for the
            )
            assertThat(field2SumValue + field3SumValue, greaterThan(100.0));
        assertThat(histo.getName(), equalTo("histo"));  
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))  
                    .interval(interval)
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.bucketSelector;
        assertThat(innerBuckets, notNullValue());
import java.util.Arrays;
                histogram("histo").field(FIELD_1_NAME)
import java.util.Collection;
            randomIntBetween(minNumber, maxNumber),  
        );
                    .interval(interval)
                return Double.isNaN(value0) ? false : (value0 > 10000);  
            assertThat(field3Sum, notNullValue());
            )
        Histogram innerHisto = bucket.getAggregations().get("inner_histo");  
        ensureSearchable();
            new Object[] {
                double value1 = (double) vars.get("_value1");  
            Sum field2Sum = bucket.getAggregations().get("field2Sum");
    }
            .addAggregation(
            Sum field3Sum = bucket.getAggregations().get("field3Sum");
            randomIntBetween(minNumber, maxNumber),
            .addAggregation(  
            .addAggregation(
                histogram("histo").field(FIELD_1_NAME)
 *  
            });
            assertThat(field2Sum, notNullValue());
        assertThat(bucket, notNullValue());  
    public void testInlineScriptNamedVars() {
        Histogram deriv = response.getAggregations().get("histo");  
        assertThat(histo.getName(), equalTo("histo"));  
            double field3SumValue = field3Sum.getValue();
        assertSearchResponse(response);
        }
            )  
 * not use this file except in compliance with the License.
            });
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
    private static final String FIELD_4_NAME = "field4";
                            + CustomScriptPlugin.NAME
        return newDocBuilder(  
            scripts.put("Double.isNaN(_value0) ? false : (_value0 > 100)", vars -> {
    public void testInlineScriptNoBucketsPruned() {
            CustomScriptPlugin.NAME,
        assertThat(histo.getName(), equalTo("histo"));
            randomIntBetween(minNumber, maxNumber)
            randomIntBetween(minNumber, maxNumber),
    }
                    MediaTypeRegistry.JSON
 * specific language governing permissions and limitations
            ScriptType.INLINE,
        assertThat(histo.getName(), equalTo("histo"));
 */
        for (int i = 0; i < buckets.size(); ++i) {
import java.util.ArrayList;  
    private static final String FIELD_1_NAME = "field1";
    @ParametersFactory
                double value0 = (double) vars.get("_value0");
                    .interval(1)
                    .subAggregation(bucketSelector("bucketSelector", script, "field2Sum", "field3Sum"))
            });
    private static int maxNumber;
        for (int docs = 0; docs < numDocs; docs++) {
        Histogram histo = response.getAggregations().get("histo");
            .get();
            assertThat(field3Sum, notNullValue());  
            double field2SumValue = field2Sum.getValue();
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value0 + _value1 > 100", Collections.emptyMap());
                int threshold = (int) vars.get("threshold");  
        assertThat(innerBuckets.size(), equalTo(4));
            Sum field2Sum = bucket.getAggregations().get("field2Sum");  
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))  
        Map<String, String> bucketPathsMap = new HashMap<>();  
        );
        assertThat(innerHisto, notNullValue());  
        for (int i = 0; i < innerBuckets.size(); i++) {
            )  
        List<? extends Bucket> buckets = histo.getBuckets();
    }
        builders.add(client().prepareIndex("idx_with_gaps").setSource(newDocBuilder(3, 3, 0, 0)));
        }  
    }
import static org.opensearch.search.aggregations.AggregationBuilders.sum;  
            assertThat(field2Sum, notNullValue());  
        super(staticSettings);
    public void testPartiallyUnmapped() throws Exception {  
        assertSearchResponse(response);  
            double field2SumValue = field2Sum.getValue();
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
            Collections.emptyMap()  
        }  
    private static final String FIELD_2_NAME = "field2";  
                    .subAggregation(bucketSelector("bucketSelector", script, "field2Sum", "field3Sum"))
        Script script = new Script(
        assertThat(histo, notNullValue());  
    public void testInlineScriptInsertZeros() {
        assertThat(histo, notNullValue());  
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
            scripts.put("Double.isNaN(_value0) ? false : (_value0 < _value1)", vars -> {
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
            .addAggregation(
                return (value0 + value1 > 100);
/*  
        Histogram.Bucket bucket = buckets.get(0);  
            CustomScriptPlugin.NAME,
        assertThat(bucket, notNullValue());
        for (int i = 0; i < buckets.size(); ++i) {
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
                        histogram("inner_histo").field(FIELD_1_NAME)
import org.opensearch.action.search.SearchResponse;
 * SPDX-License-Identifier: Apache-2.0
            });
    }  
                histogram("histo").field(FIELD_1_NAME)
            assertThat(field2SumValue + field3SumValue, greaterThan(100.0));
                    new BytesArray(
            Collections.singletonMap("threshold", 100)
        assertThat(bucket.getKeyAsString(), equalTo("1.0"));
 */  
    }
        }  
        }
                return Double.isNaN(value0) ? true : (value0 < 10000);
                    ),
            Collections.emptyMap()
        innerBuckets = innerHisto.getBuckets();
                assertThat(innerBucket.getAggregations().get("derivative"), nullValue());
        }
    }  
        assertThat(histo.getName(), equalTo("histo"));  
 * GitHub history for details.
                histogram("histo").field(FIELD_1_NAME)  
        return jsonBuilder;
        for (int i = 0; i < buckets.size(); ++i) {
        assertThat(innerBuckets, notNullValue());  
        );
            "Double.isNaN(_value0) ? false : (_value0 + _value1 > threshold)",
        assertThat(histo.getName(), equalTo("histo"));
            double field3SumValue = field3Sum.getValue();  
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
                            .extendedBounds(1L, 4L)  
        assertThat(histo, notNullValue());
        assertSearchResponse(response);  
                histogram("histo").field(FIELD_1_NAME)
            .addAggregation(  
        assertThat(histo.getName(), equalTo("histo"));
        assertSearchResponse(response);  
            assertThat(field3Sum, notNullValue());
                assertThat(innerBucket.getAggregations().get("derivative"), nullValue());
            assertThat(field2Sum, notNullValue());
import org.opensearch.script.MockScriptPlugin;
            CustomScriptPlugin.NAME,  
            "Double.isNaN(my_value1) ? false : (my_value1 + my_value2 > 100)",
            .get();
            ScriptType.INLINE,  
        createIndex("idx_unmapped");
                .setContent(
        Histogram histo = response.getAggregations().get("histo");  
                    .interval(interval)
            Collections.emptyMap()
                double value0 = (double) vars.get("_value0");
        List<? extends Bucket> buckets = histo.getBuckets();
            scripts.put("Double.isNaN(my_value1) ? false : (my_value1 + my_value2 > 100)", vars -> {  
            .get();
            Histogram.Bucket innerBucket = innerBuckets.get(i);  
            assertThat(field2Sum, notNullValue());
        jsonBuilder.endObject();  
            double field3SumValue = field3Sum.getValue();
    public BucketSelectorIT(Settings staticSettings) {  
        }
            if (i == 0) {
    }
        assertSearchResponse(response);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        );  
    public void testInlineScriptWithParams() {  
        SearchResponse response = client().prepareSearch("idx")
            .addAggregation(
        Histogram histo = response.getAggregations().get("histo");
    @Override
        assertThat(histo, notNullValue());
                    .subAggregation(  
        SearchResponse response = client().prepareSearch("idx")
 * Modifications Copyright OpenSearch Contributors. See
                return Double.isNaN(value0) ? false : (value0 + value1 > 100);  
 * Unless required by applicable law or agreed to in writing,
        assertAcked(
 * this work for additional information regarding copyright
        List<? extends Bucket> buckets = histo.getBuckets();  
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {  
        bucket = buckets.get(2);  
            .get();
        SearchResponse response = client().prepareSearch("idx")  
            if (i == 0) {
                double value1 = (double) vars.get("_value1");
        );
                    .interval(interval)
            "Double.isNaN(_value0) ? false : (_value0 > 100)",
        List<IndexRequestBuilder> builders = new ArrayList<>();
            assertThat(field2SumValue + field3SumValue, lessThan(10000.0));
        for (int i = 0; i < buckets.size(); ++i) {  
        assertSearchResponse(response);
            Histogram.Bucket bucket = buckets.get(i);
        );
            assertThat(field2SumValue, greaterThan(100.0));  
            Collections.emptyMap()  
        Histogram histo = response.getAggregations().get("histo");
 */  
        );  
/*  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.derivative;
            CustomScriptPlugin.NAME,
            assertThat(field3SumValue - field2SumValue, greaterThan(0.0));  
            Histogram.Bucket bucket = buckets.get(i);
        Script script = new Script(
            Sum field2Sum = bucket.getAggregations().get("field2Sum");  
                    .interval(interval)  
                double value1 = (double) vars.get("_value1");  
        assertThat(bucket.getKeyAsString(), equalTo("3.0"));
import org.opensearch.script.ScriptType;  
        jsonBuilder.field(FIELD_1_NAME, field1Value);
            double field2SumValue = field2Sum.getValue();  
            "Double.isNaN(_value0) ? false : (_value0 + _value1 > 100)",
        Script script = new Script(
        return Arrays.asList(  
        SearchResponse response = client().prepareSearch("idx_with_gaps")
        assertThat(histo, notNullValue());
        }
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))  
                histogram("histo").field(FIELD_1_NAME)  
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
 * license agreements. See the NOTICE file distributed with
        assertSearchResponse(response);  
        }  
            CustomScriptPlugin.NAME,
        assertThat(innerHisto, notNullValue());
import org.opensearch.test.OpenSearchIntegTestCase;
        createIndex("idx_with_gaps");  
            }
        builders.add(client().prepareIndex("idx_with_gaps").setSource(newDocBuilder(1, 1, 0, 0)));
        assertThat(buckets.size(), equalTo(0));  
        innerHisto = bucket.getAggregations().get("inner_histo");  
        SearchResponse response = client().prepareSearch("idx")
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
    public void testInlineScriptSingleVariable() {
            CustomScriptPlugin.NAME,  
        SearchResponse response = client().prepareSearch("idx")
            double field2SumValue = field2Sum.getValue();
 * The OpenSearch Contributors require contributions made to  
        minNumber = -200;
            ScriptType.INLINE,  
    public static Collection<Object[]> parameters() {
            Histogram.Bucket bucket = buckets.get(i);
        assertThat(bucket, notNullValue());
        Histogram histo = response.getAggregations().get("histo");
            }
                return Double.isNaN(myValue1) ? false : (myValue1 + myValue2 > 100);  
import org.opensearch.core.xcontent.MediaTypeRegistry;
            }
                // Source is not interpreted but my_script is defined in CustomScriptPlugin  
import java.util.List;
            Collections.emptyMap()  
        Script script = new Script(
                    .subAggregation(bucketSelector("bucketSelector", script, "field2Sum", "field3Sum"))
            ScriptType.INLINE,  
            double field3SumValue = field3Sum.getValue();
        Script script = new Script(ScriptType.STORED, null, "my_script", Collections.emptyMap());  
    public static class CustomScriptPlugin extends MockScriptPlugin {  
        Script script = new Script(  
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
import java.util.function.Function;
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
        for (int i = 0; i < buckets.size(); ++i) {  
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
            "Double.isNaN(_value0) ? false : (_value0 + _value1 > 100)",
 * software distributed under the License is distributed on an
                histogram("histo").field(FIELD_1_NAME)
        jsonBuilder.field(FIELD_4_NAME, field4Value);
        SearchResponse response = client().prepareSearch("idx")
        assertThat(histo.getName(), equalTo("histo"));
import org.opensearch.action.index.IndexRequestBuilder;  
        List<? extends Bucket> buckets = histo.getBuckets();  
            assertThat(field2Sum, notNullValue());
        for (int i = 0; i < buckets.size(); ++i) {
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))
            assertThat(field2SumValue + field3SumValue, greaterThan(100.0));  
            double field2SumValue = field2Sum.getValue();
    @Override
        for (int i = 0; i < buckets.size(); ++i) {
            });
        assertThat(histo, notNullValue());  
import org.opensearch.script.Script;
        indexRandom(true, builders);
        numDocs = randomIntBetween(10, 500);  
                    .subAggregation(bucketSelector("bucketSelector", bucketPathsMap, script))
            Sum field3Sum = bucket.getAggregations().get("field3Sum");  
            .get();
            assertThat(field2Sum, notNullValue());  
            });
        jsonBuilder.field(FIELD_3_NAME, field3Value);
    }
    }
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))  
            Sum field3Sum = bucket.getAggregations().get("field3Sum");  
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))  
            Histogram.Bucket innerBucket = innerBuckets.get(i);  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
public class BucketSelectorIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
        assertThat(buckets.size(), equalTo(3));
                return Double.isNaN(value0) ? false : (value0 < value1);
                    .subAggregation(sum("field3Sum").field(FIELD_3_NAME))  
                    .subAggregation(bucketSelector("bucketSelector", script, "field2Sum", "field3Sum"))  
            Sum field3Sum = bucket.getAggregations().get("field3Sum");  
            Histogram.Bucket bucket = buckets.get(i);
        maxNumber = 200;
                double value0 = (double) vars.get("_value0");
    public void testInlineScript() {
            double field2SumValue = field2Sum.getValue();
 * compatible open source license.
    private XContentBuilder newDocBuilder() throws IOException {
            ScriptType.INLINE,
        Histogram histo = response.getAggregations().get("histo");
        for (int i = 0; i < innerBuckets.size(); i++) {
        builders.add(client().prepareIndex("idx_with_gaps").setSource(newDocBuilder(1, 2, 0, 0)));  
                .preparePutStoredScript()
                        "{ \"script\": { \"lang\": \""  
            ScriptType.INLINE,
        builders.add(client().prepareIndex("idx_with_gaps").setSource(newDocBuilder(3, 1, 0, 0)));
            )
        }
            .addAggregation(  
            assertThat(field3Sum, notNullValue());
import org.opensearch.search.aggregations.metrics.Sum;  
        Histogram histo = response.getAggregations().get("histo");
                return Double.isNaN(value0) ? false : (value0 > 10000);
            assertThat(field3Sum, notNullValue());
import static org.hamcrest.Matchers.equalTo;
        innerHisto = bucket.getAggregations().get("inner_histo");
            .addAggregation(  
                            .interval(1)
                double value0 = (double) vars.get("_value0");
                            + "\", "
    }
            double field3SumValue = field3Sum.getValue();
        interval = randomIntBetween(1, 50);
            });
import static org.hamcrest.Matchers.lessThan;
                    .interval(interval)
            Histogram.Bucket bucket = buckets.get(i);
@OpenSearchIntegTestCase.SuiteScopeTestCase
            Sum field2Sum = bucket.getAggregations().get("field2Sum");  
        assertThat(deriv.getName(), equalTo("histo"));
/*
            ScriptType.INLINE,
            "Double.isNaN(_value0) ? true : (_value0 < 10000)",  
        assertThat(innerHisto, notNullValue());
            Histogram.Bucket bucket = buckets.get(i);
            )  
    private static int numDocs;
        assertThat(innerBuckets, notNullValue());  
            ScriptType.INLINE,  
                histogram("histo").field(FIELD_1_NAME)
            scripts.put("_value0 + _value1 > 100", vars -> {
 * You may obtain a copy of the License at  
            .get();
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
            .addAggregation(  
                            .minDocCount(0)
        for (int i = 0; i < buckets.size(); ++i) {
    private XContentBuilder newDocBuilder(int field1Value, int field2Value, int field3Value, int field4Value) throws IOException {
            assertThat(field2SumValue + field3SumValue, greaterThan(100.0));  
                assertThat(innerBucket.getAggregations().get("derivative"), notNullValue());  
            Sum field2Sum = bucket.getAggregations().get("field2Sum");
        List<? extends Bucket> buckets = histo.getBuckets();
        innerBuckets = innerHisto.getBuckets();
                .setId("my_script")
                    .subAggregation(bucketSelector("bucketSelector", script, "field2Sum", "field3Sum"))  
        );  
import org.opensearch.common.settings.Settings;
        List<? extends Bucket> buckets = histo.getBuckets();
        Histogram histo = response.getAggregations().get("histo");  
        createIndex("idx");
        for (int i = 0; i < innerBuckets.size(); i++) {
            Sum field2Sum = bucket.getAggregations().get("field2Sum");  
            scripts.put("my_script", vars -> {
 * this file be licensed under the Apache-2.0 license or a
    }  
                    .subAggregation(bucketSelector("bucketSelector", script, "field2Sum", "field3Sum").gapPolicy(GapPolicy.INSERT_ZEROS))
            Histogram.Bucket innerBucket = innerBuckets.get(i);
            assertThat(field2Sum, notNullValue());
                double value0 = (double) vars.get("_value0");  
            )
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
            .addAggregation(  
            double field3SumValue = field3Sum.getValue();
        assertThat(histo, notNullValue());  
            assertThat(field2SumValue + field3SumValue, greaterThan(100.0));
                return Double.isNaN(value0) ? false : (value0 + value1 > threshold);
                    .interval(interval)  
                    .interval(interval)
import static org.hamcrest.Matchers.greaterThan;  
        assertThat(histo, notNullValue());
                    .interval(interval)
            Collections.emptyMap()
                histogram("histo").field(FIELD_1_NAME)
            .get();
            scripts.put("Double.isNaN(_value0) ? false : (_value0 + _value1 > threshold)", vars -> {  
            } else {
            Sum field2Sum = bucket.getAggregations().get("field2Sum");  
 * under the License.  
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
            .get();  
 * the Apache License, Version 2.0 (the "License"); you may
        }
        Script script = new Script(
        assertThat(histo, notNullValue());  
            assertThat(field3Sum, notNullValue());
        List<? extends Bucket> buckets = histo.getBuckets();
            } else {  
        }
            builders.add(client().prepareIndex("idx").setSource(newDocBuilder()));  
                    .subAggregation(bucketSelector("bucketSelector", script, "field2Sum", "field3Sum"))
        Script script = new Script(
            double field2SumValue = field2Sum.getValue();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            "Double.isNaN(_value0) ? false : (_value0 + _value1 > 100)",
package org.opensearch.search.aggregations.pipeline;
                    .interval(interval)
        Histogram histo = response.getAggregations().get("histo");
import java.util.Map;  
                    .subAggregation(bucketSelector("bucketSelector", script, "field2Sum", "field3Sum"))
        List<? extends Bucket> buckets = histo.getBuckets();
            Sum field3Sum = bucket.getAggregations().get("field3Sum");
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }  
            Sum field3Sum = bucket.getAggregations().get("field3Sum");
                assertThat(innerBucket.getAggregations().get("derivative"), nullValue());
        }
            Sum field2Sum = bucket.getAggregations().get("field2Sum");
            assertThat(field2Sum, notNullValue());  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;  
        assertSearchResponse(response);
        SearchResponse response = client().prepareSearch("idx")
                return Double.isNaN(value0) ? false : (value0 + value1 > 100);
    public void testStoredScript() {  
    public void testInlineScript2() {  
            Collections.emptyMap()
            double field3SumValue = field3Sum.getValue();
    }
 * Licensed to Elasticsearch under one or more contributor  
    private static final String FIELD_3_NAME = "field3";
import java.io.IOException;
            Sum field3Sum = bucket.getAggregations().get("field3Sum");
            ScriptType.INLINE,
        @Override
                double myValue1 = (double) vars.get("my_value1");
        assertThat(histo.getName(), equalTo("histo"));
                histogram("histo").field(FIELD_1_NAME)
        jsonBuilder.field(FIELD_2_NAME, field2Value);  
import org.opensearch.plugins.Plugin;  
    private static int minNumber;  
        assertThat(histo, notNullValue());  
    private static int interval;
import static org.hamcrest.Matchers.notNullValue;
        assertSearchResponse(response);
        SearchResponse response = client().prepareSearch("idx")  
            .addAggregation(
                assertThat(innerBucket.getAggregations().get("derivative"), notNullValue());
                assertThat(innerBucket.getAggregations().get("derivative"), notNullValue());
            CustomScriptPlugin.NAME,
 *    http://www.apache.org/licenses/LICENSE-2.0
                double myValue2 = (double) vars.get("my_value2");
            .addAggregation(
        List<? extends Bucket> buckets = histo.getBuckets();
        Script script = new Script(
            assertThat(field3Sum, notNullValue());  
        SearchResponse response = client().prepareSearch("idx")
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))
        assertThat(histo.getName(), equalTo("histo"));
        Histogram histo = response.getAggregations().get("histo");
        Script script = new Script(
    public void testUnmapped() throws Exception {
                double value0 = (double) vars.get("_value0");
            )
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return Collections.singleton(CustomScriptPlugin.class);  
            Histogram.Bucket bucket = buckets.get(i);  
            .get();
                    .subAggregation(bucketSelector("bucketSelector", script, "field2Sum", "field3Sum"))
                histogram("histo").field(FIELD_1_NAME)  
                double value1 = (double) vars.get("_value1");  
    }
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
            double field2SumValue = field2Sum.getValue();
            .get();  
        assertSearchResponse(response);
            )  
            Sum field2Sum = bucket.getAggregations().get("field2Sum");
        XContentBuilder jsonBuilder = jsonBuilder();  
    }
            "Double.isNaN(_value0) ? false : (_value0 < _value1)",
            .get();  
        }  
        bucketPathsMap.put("my_value1", "field2Sum");
import org.opensearch.core.xcontent.XContentBuilder;
            } else {  
        SearchResponse response = client().prepareSearch("idx_unmapped")  
        for (int i = 0; i < buckets.size(); ++i) {  
    public void testInlineScriptNoBucketsLeft() {  
                    .subAggregation(sum("field2Sum").field(FIELD_2_NAME))  
            client().admin()
