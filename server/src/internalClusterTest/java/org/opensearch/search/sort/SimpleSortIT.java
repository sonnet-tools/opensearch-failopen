                    .endObject()  
    public void testDocumentsWithNullValue() throws Exception {  
        }  
            scripts.put("get min long", vars -> getMinValueScript(vars, Long.MAX_VALUE, "lvalue", l -> (Long) l));
        ensureGreen();
        assertAcked(
            .endObject()
            .field("type", "keyword")
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
 *  
            .addSort("svalue", SortOrder.ASC)
        // be propagated to all nodes yet and sort operation fail when the sort field is not defined  
        assertThat(searchResponse.getHits().getAt(1).field("id").getValue(), equalTo("3"));  
                    .endObject()
            .addScriptField("min", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "get min geopoint lon", Collections.emptyMap()))
            .toString();  
        assertNoFailures(searchResponse);  
            prepareCreate("test").setMapping(
                    .startObject("float_value")
                .setSource(jsonBuilder().startObject().field("value", "" + i).endObject())
                        .array("dvalue", new double[] { i, i + 1, i + 2 })
                jsonBuilder().startObject()
}
            .get();  
        assertHitCount(searchResponse, 20L);
            assertThat(searchHit.getId(), equalTo(Integer.toString(9 - i)));  
                        .field("lat", (double) i + 1)  
                    .startObject("short_value")
            assertThat(searchHit.getId(), equalTo(Integer.toString(i)));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                }  
            client().prepareIndex("test").setId("" + i).setSource(jsonBuilder().startObject().field("ord", i).endObject()).get();  
                    .startObject("value")
            for (ShardSearchFailure shardSearchFailure : searchResponse.getShardFailures()) {
import java.util.ArrayList;
                Map<?, ?> doc = (Map) vars.get("doc");
            .addScriptField("id", scripField)
        }  
import org.opensearch.search.sort.ScriptSortBuilder.ScriptSortType;  
        assertHitCount(searchResponse, 10);
        assertThat(searchResponse.toString(), not(containsString("error")));  
            for (ShardSearchFailure shardSearchFailure : searchResponse.getShardFailures()) {  
            .endObject()  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        for (int i = 0; i < 10; i++) {
import org.opensearch.action.index.IndexRequestBuilder;  
        String mapping = jsonBuilder().startObject()
        assertThat(searchResponse.getHits().getAt(0).field("id").getValue(), equalTo("1"));
import java.util.List;
        }
    @Override
        assertNoFailures(searchResponse);
        searchResponse = client().prepareSearch()
                    refresh();  
    }
            .field("type", "keyword")
        size = 1 + random.nextInt(10);
            .field("type", "keyword")
 *    http://www.apache.org/licenses/LICENSE-2.0
        ensureGreen();  
 */  
import org.opensearch.common.settings.Settings;
        }  
 * compatible open source license.
                jsonBuilder().startObject()  
import org.opensearch.common.geo.GeoPoint;  
        assertThat(searchResponse.getFailedShards(), equalTo(0));  
import java.util.Arrays;  
            .addSort(SortBuilders.fieldSort("ord").order(SortOrder.ASC).unmappedType("long"))
        assertNoFailures(searchResponse);
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));  
            .addSort(SortBuilders.fieldSort("ord").order(SortOrder.ASC).unmappedType("long"))
            .get();
                    .startObject("long_value")
    @ParametersFactory  
        );
        }  
        assertNoFailures(searchResponse);
            .setQuery(matchAllQuery())
                        .array("lvalue", new long[] { i, i + 1, i + 2 })  
                return ((ScriptDocValues.Strings) doc.get("str_value")).getValue();  
        refresh();
            scripts.put("get min geopoint lon", vars -> getMinValueScript(vars, Double.MAX_VALUE, "gvalue", g -> ((GeoPoint) g).getLon()));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
                )
        flush();  
            .setQuery(matchAllQuery())
            client().prepareIndex("test")
        static <T extends Comparable<T>> T getMinValueScript(
                    .endObject()
                            .field("long_value", i)  
import java.util.Collection;
                    .endObject()
                    .endObject()
        assertThat(searchResponse.getHits().getAt(0).field("id").getValue(), equalTo("2"));  
            .setQuery(matchAllQuery())
                .get();
                retval = (value.compareTo(retval) < 0) ? value : retval;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .addSort("svalue", SortOrder.DESC)  
                        .field("ord", i)
                Map<?, ?> doc = (Map) vars.get("doc");
        assertThat(searchResponse.getHits().getAt(1).field("id").getValue(), equalTo("3"));
            }
            .setQuery(matchAllQuery())
            .setSize(10)  
        }
            });
    public void test2920() throws IOException {  
            .toString();
        assertThat(searchResponse.getHits().getAt(0).field("id").getValue(), equalTo("1"));  
            .addScriptField("id", scripField)  
            .get();  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
import org.opensearch.action.search.ShardSearchFailure;
        /**
        // test the string values  
    public static Collection<Object[]> parameters() {
        }
            SearchHit searchHit = searchResponse.getHits().getAt(i);
                    .field("type", "boolean")
            .addSort("svalue", SortOrder.DESC)
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            assertThat("res: " + i + " id: " + searchHit.getId(), searchHit.field("min").getValue(), closeTo(i, GeoUtils.TOLERANCE));
            .get();
            String expected = new String(new char[] { (char) (97 + (9 - i)), (char) (97 + (9 - i)) });
        }
                        .field("lon", (double) i)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
 * Unless required by applicable law or agreed to in writing,
            SearchHit searchHit = searchResponse.getHits().getAt(i);
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("str_value", SortOrder.DESC).get();  
            .setQuery(matchAllQuery())
        for (int i = 0; i < 10; i++) {  
        }  
import org.opensearch.action.search.SearchResponse;
import static org.hamcrest.Matchers.not;
            .addScriptField("id", scripField)
        ensureGreen();
                client().prepareIndex("test")  
            assertThat("res: " + i + " id: " + searchHit.getId(), searchHit.field("min").getValue(), equalTo(i));
            prepareCreate("test").setMapping(
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
                    client().admin().indices().prepareFlush().get();
 */  
        super(staticSettings);  
                .get();
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        client().prepareIndex("test").setSource(jsonBuilder().startObject().field("id", "2").nullField("svalue").endObject()).get();
        for (int i = 0; i < size; i++) {
            SearchHit searchHit = searchResponse.getHits().getAt(i);  
        return Arrays.asList(
        // TODO: sort shouldn't fail when sort field is mapped dynamically
        assertThat(searchResponse.getHits().getAt(2).field("id").getValue(), equalTo("2"));
    public SimpleSortIT(Settings staticSettings) {
    public void testSortMinValueScript() throws IOException {
        searchResponse = client().prepareSearch()  
    }  
            builders.add(
            scripts.put("doc['id'][0]", vars -> {
                            .field("short_value", i)
            }
    private static final String DOUBLE_APOSTROPHE = "\u0027\u0027";  
        searchResponse = client().prepareSearch()
 * license agreements. See the NOTICE file distributed with
        for (int i = 0; i < size; i++) {  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                return ((ScriptDocValues.Strings) doc.get("id")).get(0);
import org.opensearch.script.Script;  
                    .field("type", "double")
        for (int i = 10; i < 20; i++) { // add some docs that don't have values in those fields
        List<IndexRequestBuilder> builders = new ArrayList<>();  
                        .endObject()  
        ) {
                            .field("double_value", 0.1 * i)
        if (searchResponse.getFailedShards() > 0) {
        searchResponse = client().prepareSearch()  
    public static class CustomScriptPlugin extends MockScriptPlugin {
        SearchResponse searchResponse = client().prepareSearch()
                    jsonBuilder().startObject()  
        // We have to specify mapping explicitly because by the time search is performed dynamic mapping might not
                    .endObject()  
            ScriptDocValues<?> values = (ScriptDocValues<?>) doc.get(fieldName);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.plugins.Plugin;
            .addSort(SortBuilders.fieldSort("ord").order(SortOrder.ASC).unmappedType("long"))
 * ownership. Elasticsearch licenses this file to you under  
        for (int i = 0; i < 10; i++) {
            .endObject()
            .endObject()  
        assertThat(searchResponse.getHits().getAt(2).field("id").getValue(), equalTo("2"));  
                    .field("type", "integer")
                    .field("type", "short")
 * specific language governing permissions and limitations
                    .startObject("double_value")
        assertAcked(prepareCreate("test").setMapping(mapping));
            String fieldName,
import org.opensearch.common.geo.GeoUtils;
import java.util.Random;  
            scripts.put("get min string", vars -> getMinValueScript(vars, Integer.MAX_VALUE, "svalue", s -> Integer.parseInt((String) s)));  
         */
import java.io.IOException;
    }
            T initialValue,
            .addSort(scriptSort(sortScript, ScriptSortType.STRING))  
            SearchHit searchHit = searchResponse.getHits().getAt(i);
                    .endObject()  
                            .field("byte_value", i)  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
/*  
            .field("type", "long")
        assertNoFailures(searchResponse);  
                            .field("str_value", new String(new char[] { (char) (97 + i), (char) (97 + i) }))
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
 *
public class SimpleSortIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                T value = converter.apply(v);  
    public void testSimpleSorts() throws Exception {
import org.opensearch.test.InternalSettingsPlugin;
                    .field("type", "keyword")  
                    .startObject("properties")  
        int size = 1 + random.nextInt(10);  
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
            );
import static org.hamcrest.Matchers.closeTo;
            .startObject("properties")
            .setQuery(matchAllQuery())  
        assertThat(searchResponse.getHits().getAt(1).field("id").getValue(), equalTo("1"));
        if (searchResponse.getFailedShards() > 0) {  
        return Arrays.asList(CustomScriptPlugin.class, InternalSettingsPlugin.class);
        refresh();  
 *
        for (int i = 0; i < 10; i++) {  
                    .startObject("byte_value")
            Function<Object, T> converter  
package org.opensearch.search.sort;
import static org.hamcrest.Matchers.equalTo;
            if (random.nextBoolean()) {
        Script scripField = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['id'].value", Collections.emptyMap());  
            .addSort(new ScriptSortBuilder(script, ScriptSortType.STRING))
            .addScriptField("min", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "get min long", Collections.emptyMap()))
        }
                    .setSource(
            scripts.put(DOUBLE_APOSTROPHE, vars -> DOUBLE_APOSTROPHE);  
                        .endObject()
                    .field("type", "float")
            });
                            .field("float_value", 0.1 * i)
                    .setId(Integer.toString(i))
        // test the long values
                    .endObject()  
        for (int i = 0; i < 10; i++) {
            .addScriptField("min", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "get min string", Collections.emptyMap()))  
            .get();
            .endObject()
        Script sortScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "\u0027\u0027", Collections.emptyMap());  
        assertThat(searchResponse.getHits().getAt(0).field("id").getValue(), equalTo("3"));
                    .startObject("properties")
                    .endObject()  
 * Licensed to Elasticsearch under one or more contributor  
            .field("type", "geo_point")
            .endObject()
            .setQuery(matchAllQuery())
        // test the geopoint values
                .setSource(
                logger.warn("-> {}", shardSearchFailure);
import static org.opensearch.search.sort.SortBuilders.scriptSort;
 * Modifications Copyright OpenSearch Contributors. See
        SearchResponse searchResponse = client().prepareSearch()
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
 * SPDX-License-Identifier: Apache-2.0
import java.util.HashMap;  
 * GitHub history for details.
            scripts.put("get min double", vars -> getMinValueScript(vars, Double.MAX_VALUE, "dvalue", d -> (Double) d));
        SearchResponse searchResponse = client().prepareSearch()
        assertAcked(prepareCreate("test").setMapping(mapping));  
                        jsonBuilder().startObject()  
        assertNoFailures(searchResponse);  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        client().prepareIndex("test").setSource(jsonBuilder().startObject().field("id", "1").field("svalue", "aaa").endObject()).get();  
        assertHitCount(searchResponse, 20L);  
            scripts.put("doc['id'].value", vars -> {  
            assertThat(searchHit.getSortValues()[0].toString(), equalTo(expected));
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
                    .startObject("boolean_value")
            Map<?, ?> doc = (Map) vars.get("doc");  
/*
                } else {
import org.opensearch.index.fielddata.ScriptDocValues;  
                    )
            .get();
        assertThat(searchResponse.getHits().getAt(2).field("id").getValue(), equalTo("2"));
 * the Apache License, Version 2.0 (the "License"); you may
        for (IndexRequestBuilder builder : builders) {
import org.opensearch.script.ScriptType;
 * software distributed under the License is distributed on an
        @Override  
    }
            .setSize(size)  
        assertThat(searchResponse.getFailedShards(), equalTo(0));
        SearchResponse searchResponse = client().prepareSearch()
                        .array("svalue", new String[] { "" + i, "" + (i + 1), "" + (i + 2) })
            .endObject()
            .setQuery(matchAllQuery())  
        for (int i = 0; i < 10; i++) {
        }  
        client().admin().indices().prepareRefresh("test").get();
 * You may obtain a copy of the License at  
        assertNoFailures(searchResponse);  
            .setSize(10)
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
        // STRING script
            .addSort(SortBuilders.fieldSort("ord").order(SortOrder.ASC).unmappedType("long"))  
            T retval = initialValue;
            .setSize(10)
        String mapping = jsonBuilder().startObject()
        assertNoFailures(searchResponse);
                    .endObject()  
            String expected = new String(new char[] { (char) (97 + i), (char) (97 + i) });
 * KIND, either express or implied.  See the License for the
            .setQuery(termQuery("id", "2"))
        ensureGreen();  
            logger.warn("Failed shards:");
            assertThat("res: " + i + " id: " + searchHit.getId(), searchHit.field("min").getValue(), equalTo((long) i));
            .startObject("id")  
 * not use this file except in compliance with the License.
                    .startObject("str_value")
            .setSize(10)  
            assertThat("res: " + i + " id: " + searchHit.getId(), searchHit.field("min").getValue(), equalTo((double) i));  
            .get();
        searchResponse = client().prepareSearch()
                            .field("integer_value", i)
        // a query with docs just with null values
                    .startObject("integer_value")
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['str_value'].value", Collections.emptyMap());
            for (Object v : values) {
 */
            .startObject("dvalue")
         * Return the minimal value from a set of values.  
            .startObject("svalue")
        refresh();
                .setId(Integer.toString(i))  
            }
                    .field("type", "long")
            SearchHit searchHit = searchResponse.getHits().getAt(i);
                    .field("type", "byte")
 * this work for additional information regarding copyright
                    .endObject()  
import static org.opensearch.index.query.QueryBuilders.termQuery;
            .startObject("svalue")  
            .get();
    }
                logger.warn("-> {}", shardSearchFailure);  
import java.util.function.Function;
            )  
        }
            scripts.put("doc['str_value'].value", vars -> {
                    .endObject()  
        }
    }
            .startObject("lvalue")
import static org.hamcrest.Matchers.containsString;  
            return scripts;
                Map<?, ?> doc = (Map) vars.get("doc");  
            .endObject()  
                    .endObject()  
                return ((ScriptDocValues.Strings) doc.get("id")).getValue();
        );
        // test the double values
import org.opensearch.script.MockScriptPlugin;
            .get();
        }  
        }  
        for (int i = 0; i < 10; i++) {
            .field("type", "double")
        client().prepareIndex("test").setSource(jsonBuilder().startObject().field("id", "3").field("svalue", "bbb").endObject()).get();
        );
                            .field("boolean_value", true)
    }
import org.opensearch.search.SearchHit;
            .endObject()  
        searchResponse = client().prepareSearch()  
            logger.warn("Failed shards:");
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        Random random = random();
                .setId("" + i)
        assertHitCount(searchResponse, 20L);
import java.util.Map;
                            .endObject()  
            SearchHit searchHit = searchResponse.getHits().getAt(i);
            .addSort("svalue", SortOrder.ASC)  
            .setQuery(matchAllQuery())  
import java.util.Collections;
        assertAcked(  
        assertHitCount(searchResponse, 20L);
                        .startObject("gvalue")
                    .field("type", "keyword")
    }
            .addScriptField("min", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "get min double", Collections.emptyMap()))
            .setSize(10)
            )
            .get();
            builder.get();  
            }
            assertThat(searchHit.getSortValues()[0].toString(), equalTo(expected));  
            .startObject("gvalue")
            Map<String, Object> vars,  
        assertHitCount(searchResponse, 10);
/*  
            .addScriptField("id", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['id'][0]", Collections.emptyMap()))
            client().prepareIndex("test")  
        Collections.shuffle(builders, random);
                if (random.nextInt(5) != 0) {
            .startObject("properties")  
            return retval;  
            });  
            .endObject()  
