        } catch (SearchPhaseExecutionException e) {  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
import org.opensearch.search.SearchHits;  
        // vip's have a 50% discount  
        req.setQuery(QueryBuilders.matchAllQuery())
        OpenSearchAssertions.assertAcked(prepareCreate("test").setMapping("date0", "type=date", "date1", "type=date"));  
        assertSearchResponse(rsp);
            .addSort(SortBuilders.fieldSort("id").order(SortOrder.ASC).unmappedType("long"))  
                            "totalSum",  
    }
        assertEquals(0, rsp.getHits().getAt(0).field("foo").getValue(), 1.0D);
                e.toString() + "should have contained a missing specific field error",  
            true,
        }
            // shards that don't have docs with the "text" field will not fail,
import org.opensearch.index.query.functionscore.ScoreFunctionBuilders;
import org.opensearch.common.settings.Settings;  
        assertSearchResponse(rsp);  
            .startObject("properties")  
            message = e.getCause().getMessage();
        }  
        assertEquals(0.0D, rsp.getHits().getAt(0).field("foo").getValue(), 1.0D);
 */  
import org.opensearch.test.hamcrest.OpenSearchAssertions;
        client().prepareIndex("test").setId("1").setSource("foo", 4).setRefreshPolicy(IMMEDIATE).get();  
 * The OpenSearch Contributors require contributions made to  
    }  
        client().prepareIndex("test").setId("1").setSource("foo", 5).setRefreshPolicy(IMMEDIATE).get();
            client().prepareIndex("test").setId("1").setSource("id", 1, "x", 10),  
        assertEquals(1, rsp.getHits().getTotalHits().value());
                        bucketScript(
                fail("Incorrect number of documents in a bucket in the histogram.");
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        assertSearchResponse(rsp);
            client().prepareIndex("test").setId("2").setSource("id", 2, "date0", "2013-12-25T11:56:45Z", "date1", "1983-10-13T23:15:00Z")
        rsp = buildRequest("doc['double0'].avg() + doc['double1'].avg()").get();
            assertThat(
        SearchHits hits = rsp.getHits();  
        assertEquals(5.0, hits.getAt(0).field("foo").getValue(), 0.0D);  
        );
    }
        // i.e. _value for aggregations
            SearchResponse rsp = req.get();
        assertEquals(2, rsp.getHits().getTotalHits().value());
            client().prepareIndex("test").setId("1").setSource("text", "hello goodbye"),
        assertSearchResponse(rsp);
        }
        assertEquals(1, rsp.getHits().getTotalHits().value());
        Script script = new Script(ScriptType.INLINE, "expression", "doc['foo'].value", Collections.emptyMap());  
        ensureGreen("test");
        assertSearchResponse(rsp);
            client().prepareIndex("test").setId("1").setSource("id", 1, "date0", "2015-04-28T04:02:07Z", "date1", "1985-09-01T23:11:01Z"),
    public void testDocWithoutField() {
                    .field("name", "test")
    public void testNonNumericParam() {
        SearchResponse rsp = buildRequest("doc['date0'].date.secondOfMinute - doc['date0'].date.minuteOfHour").get();
    public void testFilterScript() throws Exception {  
            assertThat(
        assertEquals(0.7, stats.getMax(), 0.0001);
import static org.hamcrest.Matchers.greaterThan;
            client().prepareIndex("test").setId("3").setSource("id", 3, "price", 2.0, "vip", false)
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(e.toString() + "should have contained ScriptException", e.toString().contains("ScriptException"), equalTo(true));
            client().prepareIndex("test").setId("1").setSource("id", 1, "date0", "2015-04-28T04:02:07Z", "date1", "1985-09-01T23:11:01Z"),
    public void testMissingField() throws Exception {
        assertEquals(0.0, hits.getAt(1).field("foo").getValue(), 0.0D);  
            buildRequest("a", "a", "astring").get();
/*
    }
                    .subAggregation(sum("fourSum").field("four"))  
        OpenSearchAssertions.assertAcked(prepareCreate("test").setMapping("x", "type=long", "y", "type=long"));
import static org.hamcrest.Matchers.notNullValue;  
                            "threeSum",
        indexRandom(  
 * license agreements. See the NOTICE file distributed with
        // make sure count() works for missing  
            )
        SearchHits hits = rsp.getHits();  
 * compatible open source license.
        assertEquals(1, rsp.getHits().getTotalHits().value());
/*  
        SearchHits hits = rsp.getHits();
            );  
        assertEquals(2, rsp.getHits().getTotalHits().value());
                                ExpressionScriptEngine.NAME,  
            .startObject()
    }  
            String message = e.getMessage();
        ensureGreen("test");
            client().prepareIndex("agg_index").setId("3").setSource("one", 3.0, "two", 2.0, "three", 3.0, "four", 4.0),
    public void testParams() throws Exception {
                AggregationBuilders.stats("const_agg")
    }
 */
    public void testInvalidFieldMember() {
        assertEquals(61.5240, rsp.getHits().getAt(0).field("foo").getValue(), 1.0D);  
        );
        }  
        );  
        assertEquals(3, hits.getTotalHits().value());
        assertThat(histogram.getName(), equalTo("histogram"));  
    }  
        hits = rsp.getHits();
        super(staticSettings);  
        List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                            new Script(
            .actionGet();
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
        assertEquals(1.5, hits.getAt(0).field("foo").getValue(), 0.0D);
        assertEquals(3, hits.getTotalHits().value());
        createIndex("test");
            // so we may or may not get a total failure  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            fail("Expected expression compilation failure");  
        } catch (SearchPhaseExecutionException e) {
        assertEquals(1.0D, rsp.getHits().getAt(0).field("foo").getValue(), 1.0D);
        ensureGreen("test");
            .startObject("properties")  
        assertEquals(5.0, hits.getAt(1).field("foo").getValue(), 0.0D);  
        createIndex("agg_index");
 * GitHub history for details.
        assertEquals(3, hits.getTotalHits().value());
            )  
        indexRandom(  
import static org.opensearch.search.aggregations.AggregationBuilders.sum;  
        String message;  
        );  
        doc2.put("double0", 5.0d);
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
            );
        ensureGreen();
            .addAggregation(
        stats = rsp.getAggregations().get("const_agg");
        req.setQuery(QueryBuilders.matchAllQuery())
    }
        Map<String, Object> doc2 = new HashMap<>();
import org.opensearch.action.search.SearchType;  
        hits = rsp.getHits();
                            "fourSum"  
        assertSearchResponse(rsp);
            true,
                    )
                e.toString().contains("must be a numeric type"),
        client().prepareIndex("test").setId("1").setSource("x", 1).setRefreshPolicy(IMMEDIATE).get();
        // ternary operator
        assertEquals(1.0, hits.getAt(0).field("foo").getValue(), 0.0D);
                double seriesArithmeticValue = seriesArithmetic.value();
        SearchResponse rsp = buildRequest("doc['location'].lat").get();  
    }  
import org.opensearch.index.query.functionscore.ScriptScoreFunctionBuilder;
        );
            fail("Expression scripts should not be allowed to run as update scripts.");  
            client().prepareIndex("test").setId("1").setSource("x", 5, "y", 1.2),
        hits = rsp.getHits();  
 */  
}
            );  
                    .interval(2)  
        SearchResponse rsp = buildRequest("doc['vip'].value").get();
                SimpleValue seriesArithmetic = bucket.getAggregations().get("totalSum");
        ensureGreen("test");  
        req.setSearchType(SearchType.DFS_QUERY_THEN_FETCH); // make sure DF is consistent  
    }
    }  
        assertEquals(1.0, hits.getAt(1).field("foo").getValue(), 0.0D);
        assertEquals(5.0, hits.getAt(2).field("foo").getValue(), 0.0D);
            fail("Expected bogus variable to cause execution failure");
        assertEquals(-11.0, hits.getAt(1).field("foo").getValue(), 0.0D);
                        )
        ensureGreen("test");  
        assertSearchResponse(rsp);
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("text", "type=keyword").get());
        doc1.put("double0", new Double[] { 5.0d, 1.0d, 1.5d });
        ensureGreen("test");
        rsp = buildRequest("doc['double0'].median()").get();
import org.opensearch.search.sort.SortBuilders;
                AggregationBuilders.stats("int_agg")  
        assertEquals(5.0, hits.getAt(1).field("foo").getValue(), 0.0D);
    }  
        assertEquals(3, rsp.getHits().getTotalHits().value());  
    }
            .execute()
            assertThat(rsp.getShardFailures().length, greaterThan(0)); // at least the shards containing the docs should have failed
                e.toString().contains("Unknown variable"),
            client().prepareIndex("test").setId("1").setSource("id", 1, "x", 4),  
        rsp = req.get();
    public void testFunction() throws Exception {
            fail("Expected doc variable without field to cause execution failure");
        assertEquals(3, rsp.getHits().getTotalHits().value());
            true,
            )  
        rsp = buildRequest("doc['double2'].empty ? 5.0 : 2.0").get();
            fail("Expected string parameter to cause failure");
                equalTo(true)
        assertEquals(6.0, hits.getAt(2).field("foo").getValue(), 0.0D);  
        SearchResponse rsp = buildRequest("doc['foo'] + abs(1)").get();  
 * software distributed under the License is distributed on an
        assertEquals(1985.0, hits.getAt(0).field("foo").getValue(), 0.0D);
        assertEquals(5.0, hits.getAt(0).field("foo").getValue(), 0.0D);
                    .subAggregation(sum("twoSum").field("two"))
        assertEquals(24.0, hits.getAt(1).field("foo").getValue(), 0.0D);
        assertEquals(1.0D, rsp.getHits().getAt(2).field("foo").getValue(), 1.0D);
        req.addAggregation(AggregationBuilders.max("max_score").script((score).getScript()));
        SearchResponse rsp = buildRequest("doc['foo'] + 1").get();  
        SearchRequestBuilder req = client().prepareSearch().setIndices("test");
        }
        assertEquals(2, rsp.getHits().getTotalHits().value());
        rsp = buildRequest("doc['date1'].getMonth() + 1").get();
        doc2.put("id", 2);  
            buildRequest("doc['foo'].bogus").get();
        createIndex("test");  
        SearchResponse rsp = buildRequest("doc['foo'].value + 1").get();
        SearchRequestBuilder req = client().prepareSearch().setIndices("test");  
            buildRequest("bogus").get();
                equalTo(true)
            .addScriptField("foo", new Script(ScriptType.INLINE, "expression", script, paramsMap));
        assertSearchResponse(rsp);
        assertEquals(5.0, rsp.getHits().getAt(0).field("foo").getValue(), 0.0D);  
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
        assertEquals(0.0D, rsp.getHits().getAt(1).field("foo").getValue(), 1.0D);
        try {  
        indexRandom(
        assertSearchResponse(rsp);  
 * You may obtain a copy of the License at  
import org.opensearch.plugins.Plugin;  
                    .field("lon", 105.3188)
        assertEquals(2, rsp.getHits().getTotalHits().value());  
        assertEquals(11.0, hits.getAt(1).field("foo").getValue(), 0.0D);  
            client().prepareIndex("test").setId("2").setSource(doc2),  
        indexRandom(true, client().prepareIndex("test").setId("1").setSource("double", "178000000.0"));
import org.opensearch.search.aggregations.AggregationBuilders;
                    .endObject()  
    public void testStringSpecialValueVariable() throws Exception {
                AggregationBuilders.terms("term_agg")
        assertThat(stats.getMin(), equalTo(3.0));
        assertEquals(5.0, hits.getAt(1).field("foo").getValue(), 0.0D);
    }
        );
        assertEquals(2.5, hits.getAt(0).field("foo").getValue(), 0.0D);
        assertSearchResponse(rsp);  
        indexRandom(  
        assertEquals(5.0, hits.getAt(0).field("foo").getValue(), 0.0D);
            .addAggregation(  
        assertEquals(1, rsp.getHits().getTotalHits().value());
    // test to make sure expressions are not allowed to be used as update scripts
        try {  
            assertThat(e.toString() + "should have contained ScriptException", e.toString().contains("ScriptException"), equalTo(true));
        );  
                SimpleValue seriesArithmetic = bucket.getAggregations().get("totalSum");  
        }
        assertSearchResponse(rsp);
        createIndex("test");  
        client().prepareIndex("test").setId("1").setSource("foo", 5).setRefreshPolicy(IMMEDIATE).get();
        hits = rsp.getHits();  
        rsp = buildRequest("doc['vip'].empty ? 1 : 0").get();
            } else {  
                double seriesArithmeticValue = seriesArithmetic.value();
        indexRandom(
 * this work for additional information regarding copyright
            client().prepareIndex("test").setId("2").setSource("id", 2, "price", 2.0, "vip", false),  
                    .endObject()
import org.opensearch.script.Script;
                    .script(new Script(ScriptType.INLINE, ExpressionScriptEngine.NAME, "_value - 1.1", Collections.emptyMap()))
        assertEquals(7.5, hits.getAt(0).field("foo").getValue(), 0.0D);
        assertEquals(2, rsp.getHits().getTotalHits().value());  
    }  
    @Override
            );  
    }
        String script = "doc['x'] * a + b + ((c + doc['x']) > 5000000009 ? 1 : 0)";
            );  
            ensureGreen("test_index");  
    public void testSparseField() throws Exception {
            true,
            client().prepareIndex("test").setId("1").setSource(doc1),
            client().prepareIndex("test").setId("3").setSource("text", "hello hello goodebye")
        assertThat(stats.getAvg(), equalTo(3.0));
            assertThat(e.toString() + "should have contained ScriptException", e.toString().contains("ScriptException"), equalTo(true));
        ensureGreen("test");
import static org.hamcrest.Matchers.equalTo;
                e.toString() + "should have contained IllegalArgumentException",
        client().prepareIndex("test").setId("1").setSource("x", 1).setRefreshPolicy(IMMEDIATE).get();  
        } catch (SearchPhaseExecutionException e) {  
        hits = rsp.getHits();
            .startObject()
        assertEquals(1, rsp.getHits().getTotalHits().value());
import org.opensearch.search.aggregations.pipeline.SimpleValue;
        indexRandom(  
        OpenSearchAssertions.assertAcked(prepareCreate("test").setMapping("double", "type=double"));
    public void testSpecialValueVariable() throws Exception {
        SearchResponse response = client().prepareSearch("agg_index")  
            urb.get();
import org.opensearch.index.query.QueryBuilders;  
        stats = rsp.getAggregations().get("double_agg");
        ensureGreen("agg_index");  
        req.setSearchType(SearchType.DFS_QUERY_THEN_FETCH); // make sure DF is consistent
        SearchResponse rsp = buildRequest(script, "a", 2, "b", 3.5, "c", 5000000000L).get();  
        assertEquals(2, rsp.getHits().getTotalHits().value());  
import java.util.Collection;
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
            client().prepareIndex("agg_index").setId("2").setSource("one", 2.0, "two", 2.0, "three", 3.0, "four", 4.0),
        assertEquals(10.0, hits.getAt(1).field("foo").getValue(), 0.0D);  
        } catch (SearchPhaseExecutionException e) {  
        try {
        assertEquals(3, hits.getTotalHits().value());  
            buildRequest("doc['bogus']").get();
        SearchHits hits = rsp.getHits();
        assertEquals(8.0, hits.getAt(1).field("foo").getValue(), 0.0D);
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
            .field("type", "geo_point");
        }  
        } catch (SearchPhaseExecutionException e) {  
        assertEquals("2", hits.getAt(2).getId());  
            client().prepareIndex("test").setId("3").setSource("id", 3, "x", 5)
            message = rsp.getShardFailures()[0].reason();  
import org.opensearch.action.search.SearchResponse;
                e.toString() + "should have contained unknown variable error",  
        assertEquals(5.0, hits.getAt(0).field("foo").getValue(), 0.0D);  
 *  
                e.toString().contains("IllegalArgumentException"),
            .addAggregation(
            client().prepareIndex("test").setId("2").setSource("id", 2, "date0", "2013-12-25T11:56:45Z", "date1", "1983-10-13T23:15:00Z")
        hits = rsp.getHits();
import org.opensearch.search.aggregations.metrics.Stats;  
        SearchResponse rsp = buildRequest("doc['x'] + 1").get();  
        assertEquals(2.0D, rsp.getHits().getAt(2).field("foo").getValue(), 1.0D);  
    }
            client().prepareIndex("test").setId("1").setSource("id", 1, "price", 1.0, "vip", true),
                equalTo(true)
        // i.e. expression script for term aggregations, which is not allowed  
            client().prepareIndex("test").setId("2").setSource("id", 2, "x", 3),
    public static Collection<Object[]> parameters() {
        client().prepareIndex("test").setId("1").setSource("foo", 5).setRefreshPolicy(IMMEDIATE).get();
            client().prepareIndex("agg_index").setId("4").setSource("one", 4.0, "two", 2.0, "three", 3.0, "four", 4.0),  
 * SPDX-License-Identifier: Apache-2.0
        );
    @ParametersFactory  
        rsp = buildRequest("doc['double0'].max()").get();
/*  
        // make sure .empty works in the same way  
    public void testBasic() throws Exception {
    public void testMultiValueMethods() throws Exception {
    public void testNonNumericField() {
            client().prepareIndex("test").setId("3").setSource("text", "hello")
        assertEquals(5.5, hits.getAt(2).field("foo").getValue(), 0.0D);
            );  
            fail();
            } else if (bucket.getDocCount() == 2) {
        return Arrays.asList(
        } catch (SearchPhaseExecutionException e) {
                    .startObject("location")
        hits = rsp.getHits();
                assertThat(seriesArithmetic, notNullValue());
        assertEquals(3, hits.getTotalHits().value());
 * specific language governing permissions and limitations
        OpenSearchAssertions.assertAcked(prepareCreate("test").setMapping("date0", "type=date", "date1", "type=date"));  
            buildRequest("garbage%@#%@").get();
        hits = rsp.getHits();  
    public void testDateMethods() throws Exception {
import org.opensearch.common.xcontent.XContentFactory;
        hits = rsp.getHits();  
        assert (params.length % 2 == 0);
                    .field("y")  
        assertEquals(5.0, hits.getAt(0).field("foo").getValue(), 0.0D);
        assertSearchResponse(rsp);
        doc1.put("id", 1);  
                e.toString() + "should have contained member variable [bogus] does not exist",  
        assertSearchResponse(rsp);
        createIndex("test");  
        assertThat(histogram, notNullValue());
        } catch (SearchPhaseExecutionException e) {  
        try {
                            "twoSum",
            assertThat(
        }
            .startObject("vip")
        assertEquals(1, rsp.getHits().getTotalHits().value());
import java.util.Map;  
            assertThat(message + " should have contained failed to execute", message.contains("failed to execute"), equalTo(true));  
        assertEquals(5.0, hits.getAt(1).field("foo").getValue(), 0.0D);  
        req.setQuery(QueryBuilders.matchAllQuery())
        assertEquals(2.0, hits.getAt(1).field("foo").getValue(), 0.0D);  
    public void testDateObjectMethods() throws Exception {
                    .field("x")
        assertEquals(15.0, stats.getMin(), 0.0001);
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.bucketScript;
        try {  
            createIndex("test_index");
        assertSearchResponse(rsp);  
        Map<String, Object> doc3 = new HashMap<>();
        assertEquals(0.0D, rsp.getHits().getAt(1).field("foo").getValue(), 1.0D);  
import org.opensearch.core.xcontent.XContentBuilder;
        // access .empty
        xContentBuilder.endObject().endObject().endObject();  
        assertEquals("1", hits.getAt(0).getId());
        rsp = buildRequest("doc['double2'].count()").get();
        client().prepareIndex("test").setId("1").setSource("x", 4).setRefreshPolicy(IMMEDIATE).get();
        try {
                    .subAggregation(sum("threeSum").field("three"))
    public void testInvalidGlobalVariable() {
import org.opensearch.action.search.SearchPhaseExecutionException;  
    }
    public void testGeo() throws Exception {  
        assertEquals(24.5, hits.getAt(0).field("foo").getValue(), 0.0D);  
        assertEquals(10.0, hits.getAt(0).field("foo").getValue(), 0.0D);
 * not use this file except in compliance with the License.
        assertEquals(5.0, hits.getAt(1).field("foo").getValue(), 0.0D);  
                    .script(new Script(ScriptType.INLINE, ExpressionScriptEngine.NAME, "_value * 3", Collections.emptyMap()))
        return req;
        );
        indexRandom(
                equalTo(true)
    public void testBoolean() throws Exception {  
            assertThat(e.toString() + "should have contained ScriptException", e.toString().contains("ScriptException"), equalTo(true));
        assertEquals(9.0, hits.getAt(0).field("foo").getValue(), 0.0D);
            true,
    }  
        // access .value  
        req.setQuery(QueryBuilders.functionScoreQuery(QueryBuilders.termQuery("text", "hello"), score).boostMode(CombineFunction.REPLACE));  
        // access .empty  
    }  
        assertEquals(3, hits.getTotalHits().value());  
        assertThat(stats.getMax(), equalTo(3.0));  
import org.opensearch.search.sort.SortOrder;  
        ensureGreen("test");
        ensureGreen("test");
        createIndex("test");  
            true,
            .startObject("location")
        assertEquals(1.25, hits.getAt(2).field("foo").getValue(), 0.0D);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
        try {
            assertThat(message, equalTo("Failed to compile inline script [0] using lang [expression]"));
            }
            paramsMap.put(params[i].toString(), params[i + 1]);
        assertEquals(3, rsp.getHits().getTotalHits().value());  
                equalTo(true)
    }
    public void testInvalidDateMethodCall() throws Exception {
            assertThat(
        assertEquals("3", hits.getAt(1).getId());
        assertEquals(3, hits.getTotalHits().value());
            urb.setScript(new Script(ScriptType.INLINE, ExpressionScriptEngine.NAME, "0", Collections.emptyMap()));
            assertThat(e.toString() + "should have contained compilation failure", e.toString().contains("compile error"), equalTo(true));  
            fail("Expected bogus field member to cause execution failure");
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                equalTo(true)
            client().prepareIndex("test").setId("2").setSource("text", "goodbye"),  
            );  
        rsp = buildRequest("doc['vip'] ? doc['price']/2 : doc['price']").get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertSearchResponse(rsp);
                assertEquals(9.0, seriesArithmeticValue, 0.001);  
        doc1.put("double1", new Double[] { 1.2d, 2.4d });
                e.toString() + "should have contained missing field error",  
 * ownership. Elasticsearch licenses this file to you under  
            client().prepareIndex("test").setId("1").setSource("text", "hello"),
        SearchHits hits = rsp.getHits();  
                e.toString() + "should have contained does not exist for numeric field",  
 * Licensed to Elasticsearch under one or more contributor  
            .actionGet();  
                            ),  
    }
import java.util.List;
    private SearchRequestBuilder buildRequest(String script, Object... params) {
    }
        );
        try {  
        client().prepareIndex("test").setId("1").setSource("foo", 4).setRefreshPolicy(IMMEDIATE).get();
 * under the License.  
        assertEquals(0.1, stats.getMin(), 0.0001);  
                    .field("x") // specifically to test a script w/o _value
        // access .lon
        // a = int, b = double, c = long
                e.toString().contains("must be used with a specific field"),
                e.toString().contains("must be numeric"),
        assertEquals(5.0, rsp.getHits().getAt(0).field("foo").getValue(), 0.0D);  
 *
public class MoreExpressionIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
        indexRandom(
            true,
                assertEquals(18.0, seriesArithmeticValue, 0.001);
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
        client().prepareIndex("test").setId("1").setSource("foo", 4).setRefreshPolicy(IMMEDIATE).get();
            client().prepareIndex("agg_index").setId("5").setSource("one", 5.0, "two", 2.0, "three", 3.0, "four", 4.0)
        doc1.put("double2", 3.0d);  
        assertEquals(2, rsp.getHits().getTotalHits().value());
        assertEquals(24.0, hits.getAt(1).field("foo").getValue(), 0.0D);
        }
        assertEquals(13.5, hits.getAt(2).field("foo").getValue(), 0.0D);
 *
        } catch (SearchPhaseExecutionException e) {
            UpdateRequestBuilder urb = client().prepareUpdate().setIndex("test_index");
        assertSearchResponse(rsp);
import org.opensearch.action.update.UpdateRequestBuilder;
            client().prepareIndex("agg_index").setId("1").setSource("one", 1.0, "two", 2.0, "three", 3.0, "four", 4.0),  
                    .field("lat", 61.5240)  
                                "_value0 + _value1 + _value2",
        SearchRequestBuilder req = client().prepareSearch().setIndices("test");
        assertEquals(105.3188, rsp.getHits().getAt(0).field("foo").getValue(), 1.0D);
            fail("Expected text field to cause execution failure");
            assertThat(e.toString() + "should have contained ScriptException", e.toString().contains("ScriptException"), equalTo(true));
        assertSearchResponse(rsp);
 * this file be licensed under the Apache-2.0 license or a
        );
import org.opensearch.common.lucene.search.function.CombineFunction;
            indexRandom(true, client().prepareIndex("test_index").setId("1").setSource("text_field", "text"));
        assertEquals(4.3, hits.getAt(0).field("foo").getValue(), 0.0D);  
        xContentBuilder.endObject().endObject().endObject();  
import java.util.HashMap;
        assertEquals(1983.0, hits.getAt(1).field("foo").getValue(), 0.0D);
            new Script(ScriptType.INLINE, "expression", "1 / _score", Collections.emptyMap())
        assertEquals(3, hits.getTotalHits().value());  
            true,  
        SearchHits hits = rsp.getHits();
                e.toString().contains("does not exist in mappings"),
    public void testPipelineAggregationScript() throws Exception {
        assertEquals(39.0, stats.getMax(), 0.0001);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
            .execute()
                e.toString() + "should have contained non-numeric parameter error",  
        // access .lat
        }
        rsp = buildRequest("doc['date1'].getYear()").get();
            prepareCreate("test").setMapping("double0", "type=double", "double1", "type=double", "double2", "type=double")
            Histogram.Bucket bucket = buckets.get(bucketCount);
        client().prepareIndex("test").setId("1").setSource("text", "this is not a number").setRefreshPolicy(IMMEDIATE).get();
        );
        doc3.put("id", 3);
        ensureGreen("test");
        SearchResponse rsp = builder.get();
import org.opensearch.script.ScriptType;
        SearchResponse rsp = buildRequest("doc['date0'].getSeconds() - doc['date0'].getMinutes()").get();
        assertEquals(2.0, hits.getAt(0).field("foo").getValue(), 0.0D);
        for (int bucketCount = 0; bucketCount < buckets.size(); ++bucketCount) {  
            .field("type", "boolean");
                e.toString().contains("does not exist for numeric field"),
        assertAcked(prepareCreate("test").setMapping(xContentBuilder));
    public void testScore() throws Exception {  
        Stats stats = rsp.getAggregations().get("int_agg");  
            )
        SearchRequestBuilder builder = buildRequest("doc['foo'].value");
                assertThat(seriesArithmetic, notNullValue());  
        ensureGreen("test");
        rsp = buildRequest("haversin(38.9072, 77.0369, doc['location'].lat, doc['location'].lon)").get();  
        assertEquals(1.5, hits.getAt(2).field("foo").getValue(), 0.0D);
            );
        rsp = buildRequest("doc['date1'].date.monthOfYear + 1").get();
                equalTo(true)
        ensureGreen();
            );
import java.util.Arrays;
        rsp = buildRequest("doc['double0'].min()").get();  
            .setId("1")
        ensureGreen("test");
        assertEquals(1.0D, rsp.getHits().getAt(0).field("foo").getValue(), 0.0D);
 * Modifications Copyright OpenSearch Contributors. See
    }  
        assertEquals(5.0, hits.getAt(0).field("foo").getValue(), 0.0D);
            .addAggregation(  
        assertThat(message + "should have contained text variable error", message.contains("text variable"), equalTo(true));
        refresh();
            client().prepareIndex("test").setId("1").setSource("id", 1, "foo", 1.0),
        return Collections.singleton(ExpressionModulePlugin.class);
            assertThat(
                histogram("histogram").field("one")
        SearchResponse rsp = buildRequest("doc['double0'].count() + doc['double1'].count()").get();
            assertThat(e.toString() + "should have contained ScriptException", e.toString().contains("ScriptException"), equalTo(true));
            client().prepareIndex("test").setId("2").setSource("id", 2, "foo", 0.0)  
        assertSearchResponse(rsp);  
        assertEquals(-1.5, hits.getAt(2).field("foo").getValue(), 0.0D);  
        score = ScoreFunctionBuilders.scriptFunction(new Script(ScriptType.INLINE, "expression", "1 / _score", Collections.emptyMap()));
    public void testCompileFailure() {
            assertThat(e.toString() + "should have contained ScriptException", e.toString().contains("ScriptException"), equalTo(true));
        try {  
            );  
        assertEquals(5.0, hits.getAt(0).field("foo").getValue(), 0.0D);  
                    .field("text")
        client().prepareIndex("test")  
    }
            buildRequest("doc['text.keyword']").get();
    public void testInvalidUpdateScript() throws Exception {  
        assertEquals(1985.0, hits.getAt(0).field("foo").getValue(), 0.0D);
        assertEquals(3, hits.getTotalHits().value());
        assertEquals(3, rsp.getHits().getTotalHits().value());
                                Collections.emptyMap()
        assertEquals(3, hits.getTotalHits().value());
        assertSearchResponse(rsp);
        ScriptScoreFunctionBuilder score = ScoreFunctionBuilders.scriptFunction(  
        assertEquals(5.0, hits.getAt(2).field("foo").getValue(), 0.0D);
        OpenSearchAssertions.assertSearchResponse(rsp);
    public MoreExpressionIT(Settings staticSettings) {
        assertEquals(0.0, hits.getAt(2).field("foo").getValue(), 0.0D);
        rsp = buildRequest("doc['double0'].sum()").get();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );
            true,  
                e.toString().contains("Member variable [bogus] does not exist"),
        rsp = buildRequest("doc['double0'].sum()/doc['double0'].count()").get();
        SearchResponse rsp = req.get();  
                e.toString() + "should have contained non-numeric field error",  
                                ScriptType.INLINE,
        );
    }
        hits = rsp.getHits();
    public void testBasicUsingDotValue() throws Exception {  
        doc2.put("double1", 3.0d);
        assertEquals(5.0, rsp.getHits().getAt(0).field("foo").getValue(), 0.0D);
        } catch (Exception e) {
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        }
            .addAggregation(
        builder.setQuery(QueryBuilders.boolQuery().filter(QueryBuilders.scriptQuery(script)));
    // test to make sure expressions are allowed to be used for reduce in pipeline aggregations  
        hits = rsp.getHits();
            true,
        SearchResponse rsp = req.get();  
        assertThat(message + "should have contained ScriptException", message.contains("ScriptException"), equalTo(true));
            buildRequest("doc['double'].getYear()").get();  
        assertEquals(3, hits.getTotalHits().value());
        assertEquals(1, rsp.getHits().getTotalHits().value());
        hits = rsp.getHits();
        ensureGreen("test");  
            true,  
                AggregationBuilders.stats("double_agg")
        rsp = buildRequest("doc['location'].empty ? 1 : 0").get();
        hits = rsp.getHits();  
 * KIND, either express or implied.  See the License for the
            buildRequest("doc").get();
        assertEquals(5.0, hits.getAt(2).field("foo").getValue(), 0.0D);
        assertEquals(0.5D, rsp.getHits().getAt(0).field("foo").getValue(), 1.0D);
        doc3.put("double0", new Double[] { 5.0d, 1.0d, 1.5d, -1.5d });  
            assertThat(
                    .subAggregation(
            client().prepareIndex("test").setId("2").setSource("x", 10, "y", 1.4),
        assertEquals(2.0D, rsp.getHits().getAt(1).field("foo").getValue(), 1.0D);
                    .script(new Script(ScriptType.INLINE, ExpressionScriptEngine.NAME, "_value", Collections.emptyMap()))  
        Map<String, Object> doc1 = new HashMap<>();
        indexRandom(
            assertThat(
        hits = rsp.getHits();  
        assertSearchResponse(rsp);
        indexRandom(  
                    .script(new Script(ScriptType.INLINE, ExpressionScriptEngine.NAME, "3.0", Collections.emptyMap()))  
    }  
            urb.setId("1");  
        assertEquals(1983.0, hits.getAt(1).field("foo").getValue(), 0.0D);
        rsp = buildRequest("doc['date1'].date.year").get();
 * Unless required by applicable law or agreed to in writing,
// TODO: please convert to unit tests!
import java.util.Collections;  
            assertThat(  
        assertAcked(prepareCreate("test").setMapping(xContentBuilder));
            fail("Expected missing field to cause failure");
        assertEquals(9.5, hits.getAt(1).field("foo").getValue(), 0.0D);
            client().prepareIndex("test").setId("3").setSource("x", 13, "y", 1.8)  
            .setSource(
        Histogram histogram = response.getAggregations().get("histogram");
        rsp = buildRequest("doc['location'].lon").get();
        SearchRequestBuilder req = client().prepareSearch().setIndices("test");  
        }
import org.opensearch.action.search.SearchRequestBuilder;
        } catch (SearchPhaseExecutionException e) {  
        assertEquals(3170D, rsp.getHits().getAt(0).field("foo").getValue(), 50D);  
        assertEquals(1, rsp.getHits().getTotalHits().value());  
        rsp = buildRequest("doc['date0'].date.getHourOfDay() + doc['date1'].date.dayOfMonth").get();  
package org.opensearch.script.expression;
        assertEquals(0.0D, rsp.getHits().getAt(2).field("foo").getValue(), 1.0D);  
            if (bucket.getDocCount() == 1) {
        OpenSearchAssertions.assertAcked(  
        // call haversin
        rsp = buildRequest("doc['date0'].getHourOfDay() + doc['date1'].getDayOfMonth()").get();  
        req = client().prepareSearch().setIndices("test");
        assertEquals(-11.0, hits.getAt(1).field("foo").getValue(), 0.0D);
        assertEquals(2, rsp.getHits().getTotalHits().value());
        createIndex("test");
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                jsonBuilder().startObject()  
        ensureGreen("test");  
        createIndex("test");
            client().prepareIndex("test").setId("2").setSource("text", "hello hello hello goodbye"),  
        ensureGreen("test");
        Map<String, Object> paramsMap = new HashMap<>();
        for (int i = 0; i < params.length; i += 2) {  
            client().prepareIndex("test").setId("2").setSource("id", 2, "y", 2)
        assertEquals(2, rsp.getHits().getTotalHits().value());
            client().prepareIndex("test").setId("3").setSource(doc3)
        doc3.put("double1", 4.0d);
        indexRandom(
        createIndex("test");
        req.setQuery(QueryBuilders.functionScoreQuery(QueryBuilders.termQuery("text", "hello"), score).boostMode(CombineFunction.REPLACE));
        try {  
                equalTo(true)  
        assertEquals(5.0, hits.getAt(1).field("foo").getValue(), 0.0D);
        assertEquals(1.0, hits.getAt(0).field("foo").getValue(), 0.0D);
            message = e.toString();
