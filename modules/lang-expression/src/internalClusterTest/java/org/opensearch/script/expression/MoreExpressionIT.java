        assertEquals(5.0, rsp.getHits().getAt(0).field("foo").getValue(), 0.0D);
                e.toString() + "should have contained a missing specific field error",
            .startObject()
        doc1.put("double0", new Double[] { 5.0d, 1.0d, 1.5d });
            buildRequest("garbage%@#%@").get();
                assertEquals(18.0, seriesArithmeticValue, 0.001);
 */
            );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            client().prepareIndex("test").setId("2").setSource("id", 2, "y", 2)
        hits = rsp.getHits();
import java.util.HashMap;
        rsp = buildRequest("haversin(38.9072, 77.0369, doc['location'].lat, doc['location'].lon)").get();
        SearchResponse rsp = buildRequest("doc['date0'].date.secondOfMinute - doc['date0'].date.minuteOfHour").get();
        ensureGreen();
        } catch (SearchPhaseExecutionException e) {
        } catch (SearchPhaseExecutionException e) {
import org.opensearch.test.hamcrest.OpenSearchAssertions;
        createIndex("test");
        SearchResponse rsp = buildRequest("doc['vip'].value").get();
    }
    public void testDateObjectMethods() throws Exception {
                    .script(new Script(ScriptType.INLINE, ExpressionScriptEngine.NAME, "_value", Collections.emptyMap()))
import org.opensearch.index.query.functionscore.ScoreFunctionBuilders;
        // make sure count() works for missing
                equalTo(true)
            .addAggregation(
        assertEquals(0.0D, rsp.getHits().getAt(1).field("foo").getValue(), 1.0D);
        assertEquals(2.0, hits.getAt(1).field("foo").getValue(), 0.0D);
        assertEquals(2.5, hits.getAt(0).field("foo").getValue(), 0.0D);
        assertSearchResponse(rsp);
                                "_value0 + _value1 + _value2",
                    )
    }
            true,
    public void testBasicUsingDotValue() throws Exception {
        assertEquals(-11.0, hits.getAt(1).field("foo").getValue(), 0.0D);
                    .field("x") // specifically to test a script w/o _value
        ensureGreen("test");
        client().prepareIndex("test").setId("1").setSource("foo", 4).setRefreshPolicy(IMMEDIATE).get();
        assertSearchResponse(rsp);
        assertEquals(5.0, hits.getAt(1).field("foo").getValue(), 0.0D);
            assertThat(
                e.toString().contains("does not exist in mappings"),
        assertEquals(2.0D, rsp.getHits().getAt(1).field("foo").getValue(), 1.0D);
    public void testNonNumericField() {
                e.toString().contains("does not exist for numeric field"),
            message = e.getCause().getMessage();
        OpenSearchAssertions.assertAcked(prepareCreate("test").setMapping("x", "type=long", "y", "type=long"));
        // ternary operator
        assertEquals(2, rsp.getHits().getTotalHits().value());
        assertEquals(61.5240, rsp.getHits().getAt(0).field("foo").getValue(), 1.0D);
            client().prepareIndex("test").setId("3").setSource("x", 13, "y", 1.8)
                assertThat(seriesArithmetic, notNullValue());
            client().prepareIndex("test").setId("1").setSource("id", 1, "date0", "2015-04-28T04:02:07Z", "date1", "1985-09-01T23:11:01Z"),
        ensureGreen("test");
            client().prepareIndex("test").setId("1").setSource("id", 1, "price", 1.0, "vip", true),
                e.toString().contains("must be used with a specific field"),
}
        // vip's have a 50% discount
        );
        try {
        );
    }
        SearchResponse response = client().prepareSearch("agg_index")
    public void testParams() throws Exception {
    public void testFunction() throws Exception {
        indexRandom(
import org.opensearch.action.search.SearchPhaseExecutionException;
        doc2.put("double0", 5.0d);
    public void testInvalidDateMethodCall() throws Exception {
            UpdateRequestBuilder urb = client().prepareUpdate().setIndex("test_index");
        return req;
        assertThat(message + "should have contained ScriptException", message.contains("ScriptException"), equalTo(true));
        );
        assertEquals(1.0D, rsp.getHits().getAt(2).field("foo").getValue(), 1.0D);
        client().prepareIndex("test").setId("1").setSource("foo", 4).setRefreshPolicy(IMMEDIATE).get();
            createIndex("test_index");
 * license agreements. See the NOTICE file distributed with
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
            // shards that don't have docs with the "text" field will not fail,
    public MoreExpressionIT(Settings staticSettings) {
import org.opensearch.search.SearchHits;
        Histogram histogram = response.getAggregations().get("histogram");
        xContentBuilder.endObject().endObject().endObject();
        assertEquals("1", hits.getAt(0).getId());
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
        builder.setQuery(QueryBuilders.boolQuery().filter(QueryBuilders.scriptQuery(script)));
 * not use this file except in compliance with the License.
    public void testMissingField() throws Exception {
        assertThat(stats.getAvg(), equalTo(3.0));
        assertEquals(3, hits.getTotalHits().value());
        doc1.put("id", 1);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
/*
            client().prepareIndex("test").setId("1").setSource("id", 1, "date0", "2015-04-28T04:02:07Z", "date1", "1985-09-01T23:11:01Z"),
                e.toString().contains("Member variable [bogus] does not exist"),
        assertEquals(5.0, hits.getAt(2).field("foo").getValue(), 0.0D);
        Map<String, Object> paramsMap = new HashMap<>();
                e.toString().contains("must be a numeric type"),
        SearchResponse rsp = buildRequest("doc['x'] + 1").get();
        Stats stats = rsp.getAggregations().get("int_agg");
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
            fail("Expected string parameter to cause failure");
 */
        String script = "doc['x'] * a + b + ((c + doc['x']) > 5000000009 ? 1 : 0)";
                        )
        assertEquals(5.0, hits.getAt(1).field("foo").getValue(), 0.0D);
            buildRequest("doc").get();
        assertEquals(1985.0, hits.getAt(0).field("foo").getValue(), 0.0D);
import org.opensearch.script.Script;
                    .field("x")
    public void testCompileFailure() {
 * this file be licensed under the Apache-2.0 license or a
            buildRequest("a", "a", "astring").get();
        SearchHits hits = rsp.getHits();
 * You may obtain a copy of the License at
        ensureGreen("test");
        assertEquals(2, rsp.getHits().getTotalHits().value());
        indexRandom(
        assertEquals(24.5, hits.getAt(0).field("foo").getValue(), 0.0D);
        SearchResponse rsp = builder.get();
        }
    public void testMultiValueMethods() throws Exception {
        assertEquals(0, rsp.getHits().getAt(0).field("foo").getValue(), 1.0D);
        ensureGreen("test");
            );
 *
 * The OpenSearch Contributors require contributions made to
            // so we may or may not get a total failure
            .startObject("properties")
        assertEquals(105.3188, rsp.getHits().getAt(0).field("foo").getValue(), 1.0D);
        // a = int, b = double, c = long
                equalTo(true)
            client().prepareIndex("agg_index").setId("2").setSource("one", 2.0, "two", 2.0, "three", 3.0, "four", 4.0),
            client().prepareIndex("test").setId("1").setSource("text", "hello"),
        rsp = buildRequest("doc['double0'].avg() + doc['double1'].avg()").get();
                fail("Incorrect number of documents in a bucket in the histogram.");
            client().prepareIndex("test").setId("3").setSource("id", 3, "price", 2.0, "vip", false)
        assertEquals(5.0, hits.getAt(2).field("foo").getValue(), 0.0D);
        hits = rsp.getHits();
        );
        assertSearchResponse(rsp);
import org.opensearch.action.search.SearchRequestBuilder;
        assertSearchResponse(rsp);
        SearchResponse rsp = req.get();
        client().prepareIndex("test").setId("1").setSource("foo", 5).setRefreshPolicy(IMMEDIATE).get();
        SearchResponse rsp = buildRequest("doc['foo'].value + 1").get();
            true,
                                ScriptType.INLINE,
        assertEquals(2.0D, rsp.getHits().getAt(2).field("foo").getValue(), 1.0D);
        ensureGreen("test");
            )
        assertEquals("2", hits.getAt(2).getId());
        rsp = buildRequest("doc['date1'].getMonth() + 1").get();
            assertThat(rsp.getShardFailures().length, greaterThan(0)); // at least the shards containing the docs should have failed
        req.setQuery(QueryBuilders.matchAllQuery())
        assertEquals(4.3, hits.getAt(0).field("foo").getValue(), 0.0D);
                SimpleValue seriesArithmetic = bucket.getAggregations().get("totalSum");
        );
        hits = rsp.getHits();
        assertEquals(0.5D, rsp.getHits().getAt(0).field("foo").getValue(), 1.0D);
        Map<String, Object> doc3 = new HashMap<>();
    }
        try {
            buildRequest("doc['foo'].bogus").get();
        SearchResponse rsp = buildRequest("doc['date0'].getSeconds() - doc['date0'].getMinutes()").get();
        indexRandom(true, client().prepareIndex("test").setId("1").setSource("double", "178000000.0"));
 * Licensed to Elasticsearch under one or more contributor
        } catch (SearchPhaseExecutionException e) {
import org.opensearch.search.sort.SortBuilders;
        assertThat(stats.getMax(), equalTo(3.0));
        }
        createIndex("test");
            assertThat(
        );
        assertEquals(3, hits.getTotalHits().value());
        assertSearchResponse(rsp);
                AggregationBuilders.terms("term_agg")
        assertEquals(5.0, hits.getAt(0).field("foo").getValue(), 0.0D);
                AggregationBuilders.stats("const_agg")
                e.toString() + "should have contained IllegalArgumentException",
        assertEquals(1.25, hits.getAt(2).field("foo").getValue(), 0.0D);
        rsp = buildRequest("doc['date1'].date.year").get();
        assertEquals(10.0, hits.getAt(0).field("foo").getValue(), 0.0D);
        assertEquals(0.7, stats.getMax(), 0.0001);
 */
 * the Apache License, Version 2.0 (the "License"); you may
    }
                equalTo(true)
            assertThat(
        // make sure .empty works in the same way
        Map<String, Object> doc1 = new HashMap<>();
                        bucketScript(
        assertEquals(15.0, stats.getMin(), 0.0001);
                double seriesArithmeticValue = seriesArithmetic.value();
        assertSearchResponse(rsp);
            client().prepareIndex("test").setId("1").setSource("x", 5, "y", 1.2),
            .startObject("properties")
        hits = rsp.getHits();
 *
        assertEquals(5.0, hits.getAt(0).field("foo").getValue(), 0.0D);
            client().prepareIndex("test").setId("3").setSource("text", "hello")
import org.opensearch.index.query.functionscore.ScriptScoreFunctionBuilder;
        try {
        try {
        assertEquals(2.0, hits.getAt(0).field("foo").getValue(), 0.0D);
        ScriptScoreFunctionBuilder score = ScoreFunctionBuilders.scriptFunction(
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.bucketScript;
        assertSearchResponse(rsp);
        assertEquals(10.0, hits.getAt(1).field("foo").getValue(), 0.0D);
            true,
        hits = rsp.getHits();
        assertEquals(3, hits.getTotalHits().value());
        assertSearchResponse(rsp);
                equalTo(true)
        client().prepareIndex("test").setId("1").setSource("foo", 5).setRefreshPolicy(IMMEDIATE).get();
            assertThat(
            } else {
    }
            client().prepareIndex("test").setId("2").setSource("text", "hello hello hello goodbye"),
        createIndex("agg_index");
        assertEquals(2, rsp.getHits().getTotalHits().value());
            assertThat(e.toString() + "should have contained ScriptException", e.toString().contains("ScriptException"), equalTo(true));
        assertEquals(8.0, hits.getAt(1).field("foo").getValue(), 0.0D);
        assertEquals(5.0, hits.getAt(0).field("foo").getValue(), 0.0D);
            buildRequest("doc['double'].getYear()").get();
        assertEquals(0.0D, rsp.getHits().getAt(2).field("foo").getValue(), 1.0D);
                            "threeSum",
        assertEquals(3170D, rsp.getHits().getAt(0).field("foo").getValue(), 50D);
        SearchRequestBuilder req = client().prepareSearch().setIndices("test");
            client().prepareIndex("test").setId("1").setSource("id", 1, "foo", 1.0),
        req.setQuery(QueryBuilders.matchAllQuery())
            client().prepareIndex("test").setId("2").setSource("x", 10, "y", 1.4),
        assertSearchResponse(rsp);
        rsp = buildRequest("doc['double0'].sum()").get();
        );
            );
            assertThat(e.toString() + "should have contained ScriptException", e.toString().contains("ScriptException"), equalTo(true));
        Map<String, Object> doc2 = new HashMap<>();
        assertThat(message + "should have contained text variable error", message.contains("text variable"), equalTo(true));
        stats = rsp.getAggregations().get("const_agg");
            fail("Expected bogus variable to cause execution failure");
    public void testInvalidGlobalVariable() {
        assertEquals(0.0D, rsp.getHits().getAt(0).field("foo").getValue(), 1.0D);
            .execute()
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
        // access .lat
            client().prepareIndex("test").setId("3").setSource("id", 3, "x", 5)
                    .script(new Script(ScriptType.INLINE, ExpressionScriptEngine.NAME, "3.0", Collections.emptyMap()))
package org.opensearch.script.expression;
    }
                e.toString() + "should have contained does not exist for numeric field",
        assertEquals(2, rsp.getHits().getTotalHits().value());
        }
        assertThat(histogram.getName(), equalTo("histogram"));
        indexRandom(
    public void testNonNumericParam() {
        client().prepareIndex("test").setId("1").setSource("x", 1).setRefreshPolicy(IMMEDIATE).get();
    // test to make sure expressions are not allowed to be used as update scripts
        SearchRequestBuilder builder = buildRequest("doc['foo'].value");
import org.opensearch.search.sort.SortOrder;
    @ParametersFactory
                SimpleValue seriesArithmetic = bucket.getAggregations().get("totalSum");
        assertEquals(3, hits.getTotalHits().value());
        assertEquals(1985.0, hits.getAt(0).field("foo").getValue(), 0.0D);
                e.toString().contains("must be numeric"),
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        rsp = buildRequest("doc['date1'].date.monthOfYear + 1").get();
            urb.setId("1");
    }
        assertEquals(2, rsp.getHits().getTotalHits().value());
            .startObject("vip")
        ensureGreen("test");
    }
    }
        rsp = buildRequest("doc['double2'].count()").get();
        doc2.put("id", 2);
        indexRandom(
        assertSearchResponse(rsp);
        assert (params.length % 2 == 0);
            .setId("1")
        SearchRequestBuilder req = client().prepareSearch().setIndices("test");
            client().prepareIndex("test").setId("2").setSource(doc2),
        assertEquals(1.0, hits.getAt(1).field("foo").getValue(), 0.0D);
        assertEquals(3, rsp.getHits().getTotalHits().value());
            );
        SearchRequestBuilder req = client().prepareSearch().setIndices("test");
            assertThat(message, equalTo("Failed to compile inline script [0] using lang [expression]"));
                    .field("y")
        SearchHits hits = rsp.getHits();
        OpenSearchAssertions.assertAcked(
        hits = rsp.getHits();
        assertEquals(3, hits.getTotalHits().value());
        refresh();
                    .script(new Script(ScriptType.INLINE, ExpressionScriptEngine.NAME, "_value - 1.1", Collections.emptyMap()))
            client().prepareIndex("test").setId("2").setSource("id", 2, "date0", "2013-12-25T11:56:45Z", "date1", "1983-10-13T23:15:00Z")
            .field("type", "geo_point");
    public void testBasic() throws Exception {
                            "twoSum",
        assertEquals(5.0, rsp.getHits().getAt(0).field("foo").getValue(), 0.0D);
    }
            true,
        assertEquals(1.5, hits.getAt(0).field("foo").getValue(), 0.0D);
        doc3.put("double0", new Double[] { 5.0d, 1.0d, 1.5d, -1.5d });
        assertEquals(13.5, hits.getAt(2).field("foo").getValue(), 0.0D);
        assertEquals(24.0, hits.getAt(1).field("foo").getValue(), 0.0D);
        return Arrays.asList(
                e.toString().contains("Unknown variable"),
        assertEquals(1983.0, hits.getAt(1).field("foo").getValue(), 0.0D);
 * KIND, either express or implied.  See the License for the
        try {
import java.util.Collection;
        }
    // test to make sure expressions are allowed to be used for reduce in pipeline aggregations
        req = client().prepareSearch().setIndices("test");
        req.setQuery(QueryBuilders.functionScoreQuery(QueryBuilders.termQuery("text", "hello"), score).boostMode(CombineFunction.REPLACE));
import org.opensearch.common.settings.Settings;
        super(staticSettings);
        rsp = buildRequest("doc['double0'].max()").get();
    public void testScore() throws Exception {
        } catch (SearchPhaseExecutionException e) {
            assertThat(e.toString() + "should have contained compilation failure", e.toString().contains("compile error"), equalTo(true));
import java.util.Map;
            )
        doc1.put("double1", new Double[] { 1.2d, 2.4d });
        OpenSearchAssertions.assertAcked(prepareCreate("test").setMapping("date0", "type=date", "date1", "type=date"));
        for (int i = 0; i < params.length; i += 2) {
        SearchHits hits = rsp.getHits();
            );
        rsp = buildRequest("doc['location'].empty ? 1 : 0").get();
        doc3.put("double1", 4.0d);
            );
                    .field("lon", 105.3188)
        rsp = buildRequest("doc['vip'].empty ? 1 : 0").get();
            true,
        // i.e. _value for aggregations
        assertEquals(6.0, hits.getAt(2).field("foo").getValue(), 0.0D);
                equalTo(true)
                double seriesArithmeticValue = seriesArithmetic.value();
        List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
        rsp = buildRequest("doc['date0'].getHourOfDay() + doc['date1'].getDayOfMonth()").get();
            urb.get();
            assertThat(e.toString() + "should have contained ScriptException", e.toString().contains("ScriptException"), equalTo(true));
        req.setQuery(QueryBuilders.matchAllQuery())
        }
        client().prepareIndex("test").setId("1").setSource("x", 1).setRefreshPolicy(IMMEDIATE).get();
        indexRandom(
        hits = rsp.getHits();
            .addAggregation(
        ensureGreen("test");
            true,
 * SPDX-License-Identifier: Apache-2.0
            assertThat(
        assertEquals("3", hits.getAt(1).getId());
            prepareCreate("test").setMapping("double0", "type=double", "double1", "type=double", "double2", "type=double")
        assertEquals(0.0, hits.getAt(2).field("foo").getValue(), 0.0D);
import org.opensearch.action.update.UpdateRequestBuilder;
            .addScriptField("foo", new Script(ScriptType.INLINE, "expression", script, paramsMap));
        client().prepareIndex("test").setId("1").setSource("text", "this is not a number").setRefreshPolicy(IMMEDIATE).get();
        rsp = req.get();
        try {
        ensureGreen("test");
            .addAggregation(
            client().prepareIndex("test").setId("2").setSource("id", 2, "date0", "2013-12-25T11:56:45Z", "date1", "1983-10-13T23:15:00Z")
        assertEquals(5.0, hits.getAt(0).field("foo").getValue(), 0.0D);
                assertEquals(9.0, seriesArithmeticValue, 0.001);
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("text", "type=keyword").get());
            assertThat(message + " should have contained failed to execute", message.contains("failed to execute"), equalTo(true));
            .startObject("location")
        try {
        indexRandom(
            .addAggregation(
        rsp = buildRequest("doc['date0'].date.getHourOfDay() + doc['date1'].date.dayOfMonth").get();
        rsp = buildRequest("doc['date1'].getYear()").get();
        createIndex("test");
    }
            true,
        ensureGreen("test");
        );
        rsp = buildRequest("doc['double0'].min()").get();
// TODO: please convert to unit tests!
        assertEquals(2, rsp.getHits().getTotalHits().value());
import org.opensearch.action.search.SearchResponse;
        OpenSearchAssertions.assertAcked(prepareCreate("test").setMapping("double", "type=double"));
        ensureGreen("test");
        assertEquals(3, rsp.getHits().getTotalHits().value());
            indexRandom(true, client().prepareIndex("test_index").setId("1").setSource("text_field", "text"));
                e.toString() + "should have contained member variable [bogus] does not exist",
    }
        );
    }
        assertEquals(5.0, hits.getAt(1).field("foo").getValue(), 0.0D);
                    .interval(2)
        ensureGreen("test");
        createIndex("test");
        );
            client().prepareIndex("agg_index").setId("4").setSource("one", 4.0, "two", 2.0, "three", 3.0, "four", 4.0),
        createIndex("test");
        indexRandom(
            .addAggregation(
        );
        req.setQuery(QueryBuilders.functionScoreQuery(QueryBuilders.termQuery("text", "hello"), score).boostMode(CombineFunction.REPLACE));
        assertEquals(24.0, hits.getAt(1).field("foo").getValue(), 0.0D);
            if (bucket.getDocCount() == 1) {
import org.opensearch.common.lucene.search.function.CombineFunction;
    public void testInvalidUpdateScript() throws Exception {
        } catch (Exception e) {
        assertSearchResponse(rsp);
            SearchResponse rsp = req.get();
    }
        ensureGreen("test");
    public void testFilterScript() throws Exception {
        indexRandom(
        createIndex("test");
public class MoreExpressionIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
 * specific language governing permissions and limitations
        ensureGreen("agg_index");
        doc2.put("double1", 3.0d);
import static org.hamcrest.Matchers.equalTo;
        try {
        assertEquals(1, rsp.getHits().getTotalHits().value());
                e.toString().contains("IllegalArgumentException"),
        createIndex("test");
    }
                    .endObject()
            client().prepareIndex("test").setId("1").setSource("id", 1, "x", 4),
            client().prepareIndex("agg_index").setId("3").setSource("one", 3.0, "two", 2.0, "three", 3.0, "four", 4.0),
    }
        assertSearchResponse(rsp);
import org.opensearch.common.xcontent.XContentFactory;
            fail("Expression scripts should not be allowed to run as update scripts.");
        indexRandom(
        rsp = buildRequest("doc['double0'].median()").get();
            }
    }
        assertEquals(1.0, hits.getAt(0).field("foo").getValue(), 0.0D);
    }
        assertEquals(3, hits.getTotalHits().value());
            .setSource(
import org.opensearch.action.search.SearchType;
        );
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            );
        }
        assertEquals(11.0, hits.getAt(1).field("foo").getValue(), 0.0D);
        // i.e. expression script for term aggregations, which is not allowed
            ensureGreen("test_index");
import static org.hamcrest.Matchers.notNullValue;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                    .subAggregation(sum("threeSum").field("three"))
            client().prepareIndex("test").setId("1").setSource(doc1),
        req.setSearchType(SearchType.DFS_QUERY_THEN_FETCH); // make sure DF is consistent
import static org.hamcrest.Matchers.greaterThan;
        rsp = buildRequest("doc['double2'].empty ? 5.0 : 2.0").get();
        assertEquals(5.5, hits.getAt(2).field("foo").getValue(), 0.0D);
        }
        assertSearchResponse(rsp);
        // access .value
        assertSearchResponse(rsp);
            urb.setScript(new Script(ScriptType.INLINE, ExpressionScriptEngine.NAME, "0", Collections.emptyMap()));
                jsonBuilder().startObject()
        createIndex("test");
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        assertSearchResponse(rsp);
    }
        assertAcked(prepareCreate("test").setMapping(xContentBuilder));
        );
        client().prepareIndex("test")
 * ownership. Elasticsearch licenses this file to you under
    private SearchRequestBuilder buildRequest(String script, Object... params) {
import java.util.List;
        assertEquals(2, rsp.getHits().getTotalHits().value());
            assertThat(e.toString() + "should have contained ScriptException", e.toString().contains("ScriptException"), equalTo(true));
        rsp = buildRequest("doc['vip'] ? doc['price']/2 : doc['price']").get();
        rsp = buildRequest("doc['double0'].sum()/doc['double0'].count()").get();
        assertAcked(prepareCreate("test").setMapping(xContentBuilder));
            buildRequest("doc['bogus']").get();
                                ExpressionScriptEngine.NAME,
 * compatible open source license.
        client().prepareIndex("test").setId("1").setSource("foo", 4).setRefreshPolicy(IMMEDIATE).get();
        assertEquals(1, rsp.getHits().getTotalHits().value());
import org.opensearch.plugins.Plugin;
        SearchHits hits = rsp.getHits();
            buildRequest("bogus").get();
                e.toString() + "should have contained non-numeric field error",
                            "totalSum",
        assertEquals(1, rsp.getHits().getTotalHits().value());
        assertSearchResponse(rsp);
        }
 * this work for additional information regarding copyright
        assertEquals(3, hits.getTotalHits().value());
        ensureGreen("test");
    public void testStringSpecialValueVariable() throws Exception {
    }
        assertEquals(2, rsp.getHits().getTotalHits().value());
        hits = rsp.getHits();
        score = ScoreFunctionBuilders.scriptFunction(new Script(ScriptType.INLINE, "expression", "1 / _score", Collections.emptyMap()));
            fail("Expected bogus field member to cause execution failure");
        rsp = buildRequest("doc['location'].lon").get();
        assertEquals(1.0, hits.getAt(0).field("foo").getValue(), 0.0D);
                    .field("text")
        OpenSearchAssertions.assertSearchResponse(rsp);
            );
                equalTo(true)
            fail("Expected missing field to cause failure");
        for (int bucketCount = 0; bucketCount < buckets.size(); ++bucketCount) {
        } catch (SearchPhaseExecutionException e) {
    }
                AggregationBuilders.stats("double_agg")
                            ),
        assertEquals(3, hits.getTotalHits().value());
        }
        assertEquals(3, hits.getTotalHits().value());
            fail("Expected doc variable without field to cause execution failure");
        }
                e.toString() + "should have contained missing field error",
        ensureGreen("test");
 * software distributed under the License is distributed on an
        assertEquals(-1.5, hits.getAt(2).field("foo").getValue(), 0.0D);
                    .subAggregation(sum("twoSum").field("two"))
                e.toString() + "should have contained non-numeric parameter error",
        req.addAggregation(AggregationBuilders.max("max_score").script((score).getScript()));
                    .subAggregation(
        assertThat(histogram, notNullValue());
        SearchResponse rsp = req.get();
            buildRequest("doc['text.keyword']").get();
        return Collections.singleton(ExpressionModulePlugin.class);
        client().prepareIndex("test").setId("1").setSource("foo", 5).setRefreshPolicy(IMMEDIATE).get();
            .startObject()
            client().prepareIndex("test").setId("2").setSource("id", 2, "price", 2.0, "vip", false),
        } catch (SearchPhaseExecutionException e) {
        assertEquals(3, hits.getTotalHits().value());
        } catch (SearchPhaseExecutionException e) {
                e.toString() + "should have contained unknown variable error",
        assertEquals(1, rsp.getHits().getTotalHits().value());
    public void testInvalidFieldMember() {
        assertEquals(3, rsp.getHits().getTotalHits().value());
            assertThat(
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            );
            fail("Expected expression compilation failure");
            assertThat(
                    .field("lat", 61.5240)
        SearchResponse rsp = buildRequest("doc['foo'] + 1").get();
                    .endObject()
                                Collections.emptyMap()
        SearchResponse rsp = buildRequest("doc['double0'].count() + doc['double1'].count()").get();
        ensureGreen("test");
            )
 * Unless required by applicable law or agreed to in writing,
        assertEquals(1, rsp.getHits().getTotalHits().value());
        hits = rsp.getHits();
            true,
        try {
        ensureGreen();
 * under the License.
                equalTo(true)
        assertEquals(0.0D, rsp.getHits().getAt(1).field("foo").getValue(), 1.0D);
        indexRandom(
                            new Script(
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
            .actionGet();
        assertEquals(1, rsp.getHits().getTotalHits().value());
            );
    }
    public void testBoolean() throws Exception {
            client().prepareIndex("agg_index").setId("5").setSource("one", 5.0, "two", 2.0, "three", 3.0, "four", 4.0)
        } catch (SearchPhaseExecutionException e) {
        hits = rsp.getHits();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        Script script = new Script(ScriptType.INLINE, "expression", "doc['foo'].value", Collections.emptyMap());
        req.setSearchType(SearchType.DFS_QUERY_THEN_FETCH); // make sure DF is consistent
            assertThat(e.toString() + "should have contained ScriptException", e.toString().contains("ScriptException"), equalTo(true));
            client().prepareIndex("test").setId("3").setSource(doc3)
        assertEquals(0.1, stats.getMin(), 0.0001);
        try {
    }
            true,
        assertSearchResponse(rsp);
        assertEquals(1.5, hits.getAt(2).field("foo").getValue(), 0.0D);
                    .field("name", "test")
            paramsMap.put(params[i].toString(), params[i + 1]);
    @Override
        assertEquals(5.0, hits.getAt(1).field("foo").getValue(), 0.0D);
                    .startObject("location")
import org.opensearch.search.aggregations.pipeline.SimpleValue;
        hits = rsp.getHits();
        // access .lon
import org.opensearch.script.ScriptType;
        doc1.put("double2", 3.0d);
        }
        }
        assertEquals(-11.0, hits.getAt(1).field("foo").getValue(), 0.0D);
        // access .empty
        indexRandom(
    public void testSpecialValueVariable() throws Exception {
            message = e.toString();
        SearchHits hits = rsp.getHits();
        assertEquals(5.0, hits.getAt(1).field("foo").getValue(), 0.0D);
            assertThat(e.toString() + "should have contained ScriptException", e.toString().contains("ScriptException"), equalTo(true));
    }
 *
import org.opensearch.search.aggregations.metrics.Stats;
        stats = rsp.getAggregations().get("double_agg");
    }
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
            true,
        assertEquals(5.0, hits.getAt(0).field("foo").getValue(), 0.0D);
    }
 * GitHub history for details.
        // access .empty
        assertEquals(7.5, hits.getAt(0).field("foo").getValue(), 0.0D);
            assertThat(e.toString() + "should have contained ScriptException", e.toString().contains("ScriptException"), equalTo(true));
            .actionGet();
        hits = rsp.getHits();
    public void testPipelineAggregationScript() throws Exception {
            String message = e.getMessage();
        assertSearchResponse(rsp);
        String message;
    public void testDocWithoutField() {
        SearchRequestBuilder req = client().prepareSearch().setIndices("test");
            client().prepareIndex("agg_index").setId("1").setSource("one", 1.0, "two", 2.0, "three", 3.0, "four", 4.0),
        assertSearchResponse(rsp);
            client().prepareIndex("test").setId("2").setSource("text", "goodbye"),
                    .subAggregation(sum("fourSum").field("four"))
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        assertEquals(5.0, hits.getAt(0).field("foo").getValue(), 0.0D);
        assertEquals(0.0, hits.getAt(1).field("foo").getValue(), 0.0D);
            assertThat(
        assertEquals(9.0, hits.getAt(0).field("foo").getValue(), 0.0D);
        assertEquals(5.0, hits.getAt(0).field("foo").getValue(), 0.0D);
            client().prepareIndex("test").setId("3").setSource("text", "hello hello goodebye")
            client().prepareIndex("test").setId("2").setSource("id", 2, "foo", 0.0)
        hits = rsp.getHits();
                equalTo(true)
import java.util.Arrays;
        assertEquals(5.0, rsp.getHits().getAt(0).field("foo").getValue(), 0.0D);
        xContentBuilder.endObject().endObject().endObject();
import org.opensearch.core.xcontent.XContentBuilder;
                histogram("histogram").field("one")
        doc3.put("id", 3);
        assertEquals(5.0, hits.getAt(2).field("foo").getValue(), 0.0D);
        assertEquals(2, rsp.getHits().getTotalHits().value());
        );
        assertEquals(5.0, hits.getAt(1).field("foo").getValue(), 0.0D);
            message = rsp.getShardFailures()[0].reason();
        assertEquals(39.0, stats.getMax(), 0.0001);
    public void testDateMethods() throws Exception {
            client().prepareIndex("test").setId("1").setSource("id", 1, "x", 10),
                AggregationBuilders.stats("int_agg")
            fail();
        assertEquals(3, rsp.getHits().getTotalHits().value());
    }
            } else if (bucket.getDocCount() == 2) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(1, rsp.getHits().getTotalHits().value());
        OpenSearchAssertions.assertAcked(prepareCreate("test").setMapping("date0", "type=date", "date1", "type=date"));
        SearchResponse rsp = buildRequest("doc['foo'] + abs(1)").get();
        assertSearchResponse(rsp);
/*
        assertThat(stats.getMin(), equalTo(3.0));
            client().prepareIndex("test").setId("1").setSource("text", "hello goodbye"),
            fail("Expected text field to cause execution failure");
            new Script(ScriptType.INLINE, "expression", "1 / _score", Collections.emptyMap())
    public void testGeo() throws Exception {
        SearchResponse rsp = buildRequest("doc['location'].lat").get();
        // call haversin
        assertEquals(1983.0, hits.getAt(1).field("foo").getValue(), 0.0D);
            .addSort(SortBuilders.fieldSort("id").order(SortOrder.ASC).unmappedType("long"))
        SearchResponse rsp = buildRequest(script, "a", 2, "b", 3.5, "c", 5000000000L).get();
    public static Collection<Object[]> parameters() {
        assertEquals(3, hits.getTotalHits().value());
        SearchHits hits = rsp.getHits();
        client().prepareIndex("test").setId("1").setSource("x", 4).setRefreshPolicy(IMMEDIATE).get();
        assertEquals(1.0D, rsp.getHits().getAt(0).field("foo").getValue(), 1.0D);
import java.util.Collections;
        assertEquals(1, rsp.getHits().getTotalHits().value());
import org.opensearch.index.query.QueryBuilders;
            .field("type", "boolean");
        hits = rsp.getHits();
            .execute()
        assertEquals(1.0D, rsp.getHits().getAt(0).field("foo").getValue(), 0.0D);
                assertThat(seriesArithmetic, notNullValue());
/*
        assertEquals(9.5, hits.getAt(1).field("foo").getValue(), 0.0D);
                    .script(new Script(ScriptType.INLINE, ExpressionScriptEngine.NAME, "_value * 3", Collections.emptyMap()))
import org.opensearch.search.aggregations.AggregationBuilders;
    public void testSparseField() throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
            )
            true,
        } catch (SearchPhaseExecutionException e) {
                            "fourSum"
            Histogram.Bucket bucket = buckets.get(bucketCount);
            client().prepareIndex("test").setId("2").setSource("id", 2, "x", 3),
