            prepareCreate("test").setMapping(
import static org.opensearch.index.query.QueryBuilders.termQuery;
            scripts.put("get min double", vars -> getMinValueScript(vars, Double.MAX_VALUE, "dvalue", d -> (Double) d));
            .addScriptField("id", scripField)
            .addSort("svalue", SortOrder.DESC)
        for (int i = 0; i < 10; i++) {
import static org.opensearch.search.sort.SortBuilders.scriptSort;
        // a query with docs just with null values
            .field("type", "geo_point")
            .setQuery(matchAllQuery())
        for (int i = 0; i < 10; i++) {
                        .array("svalue", new String[] { "" + i, "" + (i + 1), "" + (i + 2) })
        assertThat(searchResponse.getHits().getAt(0).field("id").getValue(), equalTo("1"));
                        .endObject()
                    .endObject()
            .endObject()
                return ((ScriptDocValues.Strings) doc.get("id")).get(0);
            .startObject("properties")
        }
                    .field("type", "short")
            .setSize(10)
            .setQuery(matchAllQuery())
        assertNoFailures(searchResponse);
                Map<?, ?> doc = (Map) vars.get("doc");
        Random random = random();
        flush();
import org.opensearch.search.SearchHit;
                retval = (value.compareTo(retval) < 0) ? value : retval;
                        .array("dvalue", new double[] { i, i + 1, i + 2 })
                            .field("double_value", 0.1 * i)
        // test the long values
                    .setId(Integer.toString(i))
            .get();
            scripts.put(DOUBLE_APOSTROPHE, vars -> DOUBLE_APOSTROPHE);
            .setSize(10)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
                    .startObject("short_value")
import java.io.IOException;
    }
            builder.get();
        assertHitCount(searchResponse, 20L);
        String mapping = jsonBuilder().startObject()
            }
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            .setQuery(matchAllQuery())
            .endObject()
 */
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(size).addSort("str_value", SortOrder.DESC).get();
            .addSort(SortBuilders.fieldSort("ord").order(SortOrder.ASC).unmappedType("long"))
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            client().prepareIndex("test")
        client().prepareIndex("test").setSource(jsonBuilder().startObject().field("id", "2").nullField("svalue").endObject()).get();
            .field("type", "long")
import org.opensearch.common.geo.GeoPoint;
                    .field("type", "float")
                if (random.nextInt(5) != 0) {
                .get();
 * Modifications Copyright OpenSearch Contributors. See
            builders.add(
        int size = 1 + random.nextInt(10);
            .setSize(10)
                            .field("long_value", i)
            .get();
                            .field("short_value", i)
            .addSort(SortBuilders.fieldSort("ord").order(SortOrder.ASC).unmappedType("long"))
            scripts.put("doc['str_value'].value", vars -> {
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(searchHit.getSortValues()[0].toString(), equalTo(expected));
        assertNoFailures(searchResponse);
import org.opensearch.index.fielddata.ScriptDocValues;
 * KIND, either express or implied.  See the License for the
            .addSort(scriptSort(sortScript, ScriptSortType.STRING))
            .startObject("dvalue")
            .startObject("lvalue")
                    .endObject()
            SearchHit searchHit = searchResponse.getHits().getAt(i);
            T retval = initialValue;
        Script sortScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "\u0027\u0027", Collections.emptyMap());
 * not use this file except in compliance with the License.
            .addSort("svalue", SortOrder.ASC)
            SearchHit searchHit = searchResponse.getHits().getAt(i);
        }
                    .field("type", "byte")
import org.opensearch.script.Script;
            .setSize(size)
                .get();
        searchResponse = client().prepareSearch()
            assertThat(searchHit.getId(), equalTo(Integer.toString(i)));
                Map<?, ?> doc = (Map) vars.get("doc");
 * You may obtain a copy of the License at
        assertNoFailures(searchResponse);
            scripts.put("get min long", vars -> getMinValueScript(vars, Long.MAX_VALUE, "lvalue", l -> (Long) l));
            .setQuery(matchAllQuery())
            .startObject("id")
    public void testDocumentsWithNullValue() throws Exception {
            .addSort("svalue", SortOrder.ASC)
            )
        static <T extends Comparable<T>> T getMinValueScript(
import java.util.HashMap;
        }
                    .startObject("properties")
            .endObject()
        assertAcked(prepareCreate("test").setMapping(mapping));
                    .field("type", "keyword")
        ensureGreen();
                    .endObject()
        searchResponse = client().prepareSearch()
 *
        Collections.shuffle(builders, random);
            Map<String, Object> vars,
import org.opensearch.plugins.Plugin;
            .endObject()
                    .endObject()
        searchResponse = client().prepareSearch()
                    .endObject()
        // test the string values
        ensureGreen();
            .get();
        }
import java.util.function.Function;
                        .endObject()
        assertHitCount(searchResponse, 20L);
    public void testSortMinValueScript() throws IOException {
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        if (searchResponse.getFailedShards() > 0) {
    public static Collection<Object[]> parameters() {
            .startObject("gvalue")
        assertThat(searchResponse.getHits().getAt(1).field("id").getValue(), equalTo("3"));
            .setQuery(matchAllQuery())
            return scripts;
        // test the double values
    @Override
        }
        );
        }
        refresh();
            client().prepareIndex("test").setId("" + i).setSource(jsonBuilder().startObject().field("ord", i).endObject()).get();
        assertAcked(
                    .setSource(
        // STRING script
 * Licensed to Elasticsearch under one or more contributor
            SearchHit searchHit = searchResponse.getHits().getAt(i);
        SearchResponse searchResponse = client().prepareSearch()
                logger.warn("-> {}", shardSearchFailure);
                .setSource(
import org.opensearch.script.MockScriptPlugin;
 * this file be licensed under the Apache-2.0 license or a
         */
 * SPDX-License-Identifier: Apache-2.0
        }
        for (int i = 0; i < size; i++) {
        // test the geopoint values
import java.util.Arrays;
        assertThat(searchResponse.getHits().getAt(2).field("id").getValue(), equalTo("2"));
            .toString();
        SearchResponse searchResponse = client().prepareSearch()
 * ownership. Elasticsearch licenses this file to you under
import java.util.Random;
import org.opensearch.common.geo.GeoUtils;
        assertThat(searchResponse.getHits().getAt(1).field("id").getValue(), equalTo("3"));
        assertAcked(
        assertNoFailures(searchResponse);
 *
import org.opensearch.test.InternalSettingsPlugin;
            .get();
                    client().admin().indices().prepareFlush().get();
            .field("type", "keyword")
                        jsonBuilder().startObject()
            scripts.put("get min string", vars -> getMinValueScript(vars, Integer.MAX_VALUE, "svalue", s -> Integer.parseInt((String) s)));
        assertHitCount(searchResponse, 20L);
        assertThat(searchResponse.getHits().getAt(0).field("id").getValue(), equalTo("1"));
                    .startObject("value")
        assertNoFailures(searchResponse);
            SearchHit searchHit = searchResponse.getHits().getAt(i);
        String mapping = jsonBuilder().startObject()
                    .startObject("properties")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .setQuery(matchAllQuery())
        for (int i = 0; i < 10; i++) {
    @ParametersFactory
            .field("type", "double")
                return ((ScriptDocValues.Strings) doc.get("id")).getValue();
                        .startObject("gvalue")
                client().prepareIndex("test")
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
 * specific language governing permissions and limitations
                            .endObject()
            assertThat(searchHit.getSortValues()[0].toString(), equalTo(expected));
            });
                    .endObject()
        assertThat(searchResponse.getHits().getAt(2).field("id").getValue(), equalTo("2"));
        for (int i = 0; i < 10; i++) {
                    .field("type", "boolean")
            assertThat("res: " + i + " id: " + searchHit.getId(), searchHit.field("min").getValue(), equalTo(i));
            scripts.put("doc['id'][0]", vars -> {
import java.util.ArrayList;
        for (int i = 0; i < size; i++) {
                .setId("" + i)
/*
 */
                        .array("lvalue", new long[] { i, i + 1, i + 2 })
 */
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            for (Object v : values) {
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        assertThat(searchResponse.getHits().getAt(0).field("id").getValue(), equalTo("3"));
import static org.hamcrest.Matchers.closeTo;
        ensureGreen();
        assertThat(searchResponse.getHits().getAt(1).field("id").getValue(), equalTo("1"));
    }
                Map<?, ?> doc = (Map) vars.get("doc");
                } else {
        }
            .get();
            .endObject()
        ) {
        assertHitCount(searchResponse, 10);
            .get();
            .get();
                .setSource(jsonBuilder().startObject().field("value", "" + i).endObject())
        SearchResponse searchResponse = client().prepareSearch()
                    .field("type", "long")
 * The OpenSearch Contributors require contributions made to
                jsonBuilder().startObject()
                        .field("lon", (double) i)
        searchResponse = client().prepareSearch()
            .addScriptField("id", scripField)
 *    http://www.apache.org/licenses/LICENSE-2.0
            )
        // We have to specify mapping explicitly because by the time search is performed dynamic mapping might not
        for (int i = 0; i < 10; i++) {
            .endObject()
 *
        assertThat(searchResponse.getHits().getAt(0).field("id").getValue(), equalTo("2"));
        assertNoFailures(searchResponse);
            .toString();
                    .endObject()
/*
        );
            String expected = new String(new char[] { (char) (97 + i), (char) (97 + i) });
 * compatible open source license.
 * software distributed under the License is distributed on an
            SearchHit searchHit = searchResponse.getHits().getAt(i);
        }
 * GitHub history for details.
        super(staticSettings);
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
                    .endObject()
        return Arrays.asList(CustomScriptPlugin.class, InternalSettingsPlugin.class);
                    .startObject("double_value")
                    jsonBuilder().startObject()
            scripts.put("get min geopoint lon", vars -> getMinValueScript(vars, Double.MAX_VALUE, "gvalue", g -> ((GeoPoint) g).getLon()));
        searchResponse = client().prepareSearch()
    }
        }
        assertThat(searchResponse.getHits().getAt(2).field("id").getValue(), equalTo("2"));
            logger.warn("Failed shards:");
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
            );
            .endObject()
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
            .addScriptField("min", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "get min long", Collections.emptyMap()))
    }
            .startObject("properties")
        assertThat(searchResponse.getFailedShards(), equalTo(0));
            assertThat("res: " + i + " id: " + searchHit.getId(), searchHit.field("min").getValue(), closeTo(i, GeoUtils.TOLERANCE));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            .startObject("svalue")
                    .endObject()
            return retval;
            .addScriptField("min", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "get min geopoint lon", Collections.emptyMap()))
                            .field("boolean_value", true)
    public void test2920() throws IOException {
        assertHitCount(searchResponse, 20L);
        // be propagated to all nodes yet and sort operation fail when the sort field is not defined
            prepareCreate("test").setMapping(
    public SimpleSortIT(Settings staticSettings) {
    public static class CustomScriptPlugin extends MockScriptPlugin {
        );
import static org.hamcrest.Matchers.not;
            ScriptDocValues<?> values = (ScriptDocValues<?>) doc.get(fieldName);
                jsonBuilder().startObject()
                T value = converter.apply(v);
            for (ShardSearchFailure shardSearchFailure : searchResponse.getShardFailures()) {
 * under the License.
                    .startObject("boolean_value")
import java.util.List;
            .get();
                            .field("integer_value", i)
import static org.hamcrest.Matchers.equalTo;
            .get();
                }
            assertThat("res: " + i + " id: " + searchHit.getId(), searchHit.field("min").getValue(), equalTo((double) i));
            .setQuery(matchAllQuery())
package org.opensearch.search.sort;
        // TODO: sort shouldn't fail when sort field is mapped dynamically
import org.opensearch.common.settings.Settings;
            assertThat("res: " + i + " id: " + searchHit.getId(), searchHit.field("min").getValue(), equalTo((long) i));
import java.util.Collection;
        assertNoFailures(searchResponse);
                        .field("ord", i)
        return Arrays.asList(
/*
import static org.hamcrest.Matchers.containsString;
                    .endObject()
        ensureGreen();
            .setSize(10)
    }
            }
            .addSort(SortBuilders.fieldSort("ord").order(SortOrder.ASC).unmappedType("long"))
                    refresh();
                    .startObject("float_value")
            .startObject("svalue")
                            .field("str_value", new String(new char[] { (char) (97 + i), (char) (97 + i) }))
        if (searchResponse.getFailedShards() > 0) {
            scripts.put("doc['id'].value", vars -> {
            .endObject()
            .setQuery(matchAllQuery())
        refresh();
                    .field("type", "integer")
            }
            logger.warn("Failed shards:");
        List<IndexRequestBuilder> builders = new ArrayList<>();
    }
        /**
            assertThat(searchHit.getId(), equalTo(Integer.toString(9 - i)));
         * Return the minimal value from a set of values.
            T initialValue,
            .field("type", "keyword")
            String expected = new String(new char[] { (char) (97 + (9 - i)), (char) (97 + (9 - i)) });
    }
        for (IndexRequestBuilder builder : builders) {
            .endObject()
                    .startObject("byte_value")
        for (int i = 0; i < 10; i++) {
import org.opensearch.script.ScriptType;
                logger.warn("-> {}", shardSearchFailure);
import java.util.Map;
                .setId(Integer.toString(i))
        assertThat(searchResponse.toString(), not(containsString("error")));
                    .endObject()
import java.util.Collections;
        SearchResponse searchResponse = client().prepareSearch()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        @Override
            .addSort(new ScriptSortBuilder(script, ScriptSortType.STRING))
            if (random.nextBoolean()) {
import org.opensearch.search.sort.ScriptSortBuilder.ScriptSortType;
    }
        }
import org.opensearch.action.search.SearchResponse;
            .addScriptField("id", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['id'][0]", Collections.emptyMap()))
            for (ShardSearchFailure shardSearchFailure : searchResponse.getShardFailures()) {
            Function<Object, T> converter
        assertThat(searchResponse.getFailedShards(), equalTo(0));
                        .field("lat", (double) i + 1)
                            .field("float_value", 0.1 * i)
        }
 * Unless required by applicable law or agreed to in writing,
                    )
            .addScriptField("id", scripField)
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
 * this work for additional information regarding copyright
            client().prepareIndex("test")
    public void testSimpleSorts() throws Exception {
                    .field("type", "double")
        client().prepareIndex("test").setSource(jsonBuilder().startObject().field("id", "3").field("svalue", "bbb").endObject()).get();
import org.opensearch.action.search.ShardSearchFailure;
        size = 1 + random.nextInt(10);
        refresh();
        }
                            .field("byte_value", i)
        client().admin().indices().prepareRefresh("test").get();
            .setQuery(matchAllQuery())
        assertHitCount(searchResponse, 10);
            .addScriptField("min", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "get min double", Collections.emptyMap()))
            .field("type", "keyword")
                return ((ScriptDocValues.Strings) doc.get("str_value")).getValue();
    private static final String DOUBLE_APOSTROPHE = "\u0027\u0027";
        client().prepareIndex("test").setSource(jsonBuilder().startObject().field("id", "1").field("svalue", "aaa").endObject()).get();
public class SimpleSortIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        assertAcked(prepareCreate("test").setMapping(mapping));
                    .field("type", "keyword")
            .endObject()
import org.opensearch.action.index.IndexRequestBuilder;
            }
 * license agreements. See the NOTICE file distributed with
        searchResponse = client().prepareSearch()
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
                    .startObject("str_value")
            .addSort("svalue", SortOrder.DESC)
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            .addScriptField("min", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "get min string", Collections.emptyMap()))
            SearchHit searchHit = searchResponse.getHits().getAt(i);
        for (int i = 10; i < 20; i++) { // add some docs that don't have values in those fields
            .setSize(10)
        assertNoFailures(searchResponse);
        assertThat(searchResponse.getHits().getHits().length, equalTo(size));
            });
}
            .addSort(SortBuilders.fieldSort("ord").order(SortOrder.ASC).unmappedType("long"))
            });
        }
                    .endObject()
                )
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['str_value'].value", Collections.emptyMap());
                    .endObject()
                    .startObject("integer_value")
                    .startObject("long_value")
            String fieldName,
            .setQuery(termQuery("id", "2"))
        for (int i = 0; i < 10; i++) {
            Map<?, ?> doc = (Map) vars.get("doc");
        Script scripField = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['id'].value", Collections.emptyMap());
            .get();
        }
