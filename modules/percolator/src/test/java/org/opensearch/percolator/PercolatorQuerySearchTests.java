        doc.startObject();
        // Index a document that triggers a dynamic mapping update  
            );
                    {
    }  
            BytesReference source = BytesReference.bytes(  
                .addSort("_doc", SortOrder.ASC)
            "type=date",  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                                .endObject()
            Settings.builder().put("index.number_of_shards", 1).build(),
            source = BytesReference.bytes(jsonBuilder().startObject().field("field1", "value").field("field2", currentTime[0]).endObject());
            {
                jsonBuilder().startObject()  
        assertSearchHits(response, "1");
        }  
 * Licensed to Elasticsearch under one or more contributor  
            .get();
            client().admin()  
                doc.endObject();  
                ScriptDocValues<?> scriptDocValues = leafDocLookup.get("employees.name");  
    }
    }  
import org.opensearch.plugins.Plugin;
                .get();
            SearchResponse response = client().prepareSearch()
                    mapping.startObject("properties");  
    public static class CustomScriptPlugin extends MockScriptPlugin {
                    MediaTypeRegistry.JSON  
        @Override  
                .setQuery(new PercolateQueryBuilder("query", BytesReference.bytes(doc), MediaTypeRegistry.JSON))  
            )
import org.opensearch.core.common.bytes.BytesReference;  
                            XContentFactory.jsonBuilder()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
        client().admin().indices().prepareRefresh().get();  
        // memory for BitsetCache in case of percolator  
            assertHitCount(response, 1);
        client().prepareIndex("test")
    }
                mapping.endObject();  
            .get();  
    }  
        mapping.startObject()
            doc.endArray();
        XContentBuilder doc = jsonBuilder();
        long fieldDataSize = client().admin().cluster().prepareClusterStats().get().getIndicesStats().getFieldData().getMemorySizeInBytes();  
        );  
                .get();  
import org.opensearch.index.fielddata.ScriptDocValues;
            .startObject("properties")
 * license agreements. See the NOTICE file distributed with
                    BytesReference.bytes(jsonBuilder().startObject().field("unmapped_field", "value").endObject()),
                    .endObject()  
                doc.endObject();
                mapping.field("type", "percolator");  
            "query",
            .endObject();  
            .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
 * Modifications Copyright OpenSearch Contributors. See  
        SearchResponse response = client().prepareSearch("test")
import org.opensearch.action.support.WriteRequest;  
        Script script = new Script(ScriptType.INLINE, MockScriptPlugin.NAME, "use_fielddata_please", Collections.emptyMap());  
            .setId("doc1")
        Settings.Builder settings = Settings.builder().put("index.percolator.map_unmapped_fields_as_text", true);  
 * not use this file except in compliance with the License.
            "field1",  
    public void testRangeQueriesWithNow() throws Exception {
import org.opensearch.script.ScriptType;
            .actionGet();  
                                .endObject()
                    .field(
        SearchResponse response = client().prepareSearch("index")
                // to avoid normal document from being cached by BitsetFilterCache  
            .setSource(  
                    Settings.builder().put(IndicesBitsetFilterCache.INDEX_LOAD_RANDOM_ACCESS_FILTERS_EAGERLY_SETTING.getKey(), false)
 * under the License.  
import static org.hamcrest.Matchers.equalTo;
                .setMapping(mapping)
        mapping.startObject();
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
                                .startObject()  
 * compatible open source license.
                    .endObject()  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.join.ScoreMode;
 * this file be licensed under the Apache-2.0 license or a
            .endObject()
            .get();
            mapping.startObject("properties");  
        return Arrays.asList(PercolatorModulePlugin.class, CustomScriptPlugin.class);
                mapping.startObject("query");
/*
                        mapping.field("fielddata", true);
 */  
            .endObject()
        Settings.Builder settings = Settings.builder().put("index.percolator.map_unmapped_fields_as_text", true);
    public void testPercolateScriptQuery() throws IOException {
                                .field("name", "virginia potts")
            .setSource(
            .setId("1")  
                                .startObject()  
/*
            .endObject()
        long bitsetSize = client().admin().cluster().prepareClusterStats().get().getIndicesStats().getSegments().getBitsetMemoryInBytes();
            .setId("3")
                        "query",
            mapping.endObject();
            .endObject()  
                .setSettings(
                jsonBuilder().startObject()  
            .setQuery(
        );
 * SPDX-License-Identifier: Apache-2.0
        }
        client().admin().indices().prepareRefresh().get();  
            assertThat(searcher.count(query), equalTo(3));
            currentTime[0] = currentTime[0] + 10800000; // + 3 hours
            .startObject("properties")
/*  
            queryBuilder = new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON);  
        assertSearchHits(response, "1");
            )
                    MediaTypeRegistry.JSON  
        for (int i = 0; i < 32; i++) {
import java.util.function.Function;
            "test",
        assertHitCount(response, 1);
            )
            QueryBuilder queryBuilder = new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON);  
                    new PercolateQueryBuilder(
            long[] currentTime = new long[] { System.currentTimeMillis() };  
import org.opensearch.index.query.QueryShardContext;  
import java.util.Collections;
                doc.startObject();  
                                .startArray("employee")
        client().prepareIndex("test")
        client().admin().indices().prepareRefresh().get();
                        ),
                mapping.startObject("companyname");
                .prepareCreate("test")
            .field("type", "nested")
            .field("type", "text")
 *
                jsonBuilder().startObject()
                                .field("companyname", "stark")
                        )
                        "query",
            )
                doc.field("name", "virginia_potts");
 *    http://www.apache.org/licenses/LICENSE-2.0
        SearchResponse response = client().prepareSearch("test")
 *
import static org.opensearch.index.query.QueryBuilders.matchQuery;
                .addSort("_doc", SortOrder.ASC)  
                doc.field("name", "tony_stark");
        // Now index a percolator query referencing an unmapped field — this should still work  
            .get();
                            "employee",
                jsonBuilder().startObject()
                    )
    public void testPercolateQueryWithNestedDocuments_doLeakFieldDataCacheEntries() throws Exception {
                new PercolateQueryBuilder(  
    }  
            .get();
            .get();  
            )  
                    "query",
                .setSize(0)
import java.io.IOException;
                        "query",  
            )  
                    .field("query", boolQuery().filter(scriptQuery(script)).filter(rangeQuery("field2").from("now-1h").to("now+1h")))
            .field("type", "text")
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            .setId("q1")
                    )
        assertEquals("The percolator works with in-memory index and therefor shouldn't use bitset cache", 0L, bitsetSize);
                                .endObject()
 */
import static org.opensearch.index.query.QueryBuilders.rangeQuery;  
                jsonBuilder().startObject().field("field1", "value").field("field2", currentTime[0]).endObject()
                    }  
}  
import org.opensearch.common.settings.Settings;
                mapping.startObject("employees");  
        client().prepareIndex("test")  
        client().prepareIndex("test")
                        BytesReference.bytes(
        {  
import org.opensearch.index.query.QueryBuilders;
        XContentBuilder mapping = XContentFactory.jsonBuilder();  
            QueryShardContext queryShardContext = indexService.newQueryShardContext(0, searcher, () -> currentTime[0], null);
            .get();
        {
import java.util.HashMap;
                }
import org.opensearch.index.engine.Engine;
            }
            .setSource(
            .setSource(
            .endObject()
                )
                .setQuery(
import org.opensearch.indices.IndicesBitsetFilterCache;
        client().prepareIndex("test")
import org.opensearch.index.IndexService;  
            .startObject("employee")  
            Query query = queryBuilder.toQuery(queryShardContext);
            .setSource(jsonBuilder().startObject().field("query", rangeQuery("field2").from("now-1h").to("now+1h")).endObject())
        doc.endObject();  
        createIndexWithSimpleMappings("test", settings.build(), "query", "type=percolator", "title", "type=text");
                    BytesReference.bytes(jsonBuilder().startObject().field("field1", "value").endObject()),
                        "query",
            )
 * You may obtain a copy of the License at  
        client().prepareIndex("index")  
        createIndex("test", client().admin().indices().prepareCreate("test").setMapping(mapping));
    protected Collection<Class<? extends Plugin>> getPlugins() {
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {
                    )
import org.opensearch.index.query.QueryBuilder;
            .setSource(  
            .field("type", "percolator")
            {
 * this work for additional information regarding copyright
            }  
        assertSearchHits(response, "1");
                return "virginia_potts".equals(scriptDocValues.get(0));
    @Override  
                {
            "type=keyword",
        }  
                    "query",
            .setId("2")
            .get();
import java.util.Arrays;
            doc.field("companyname", "stark");
                    "query",
            }
import org.opensearch.script.MockScriptPlugin;  
                new PercolateQueryBuilder(  
            .get();  
            {  
            .startObject("name")  
    public void testPercolateQueryWithNestedDocuments_doNotLeakBitsetCacheEntries() throws Exception {
                        MediaTypeRegistry.JSON  
        }
 * Unless required by applicable law or agreed to in writing,
                    .field(
        createIndexWithSimpleMappings("test", settings.build(), "query", "type=percolator");  
            .startObject("companyname")  
        client().admin().indices().prepareRefresh().get();
                )
            .setQuery(
import static org.opensearch.index.query.QueryBuilders.scriptQuery;
        }
            .get();
                )
                )
            .setId("1")
                                .startObject()  
                mapping.field("type", "text");
            )
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.search.Query;  
            "type=percolator"
            .startObject("query")  
        mapping.endObject();
            .setId("q1")
                mapping.endObject();
        for (int i = 0; i < 32; i++) {
 * KIND, either express or implied.  See the License for the
            SearchResponse response = client().prepareSearch()  
                jsonBuilder().startObject().field("title", "some document").field("new_dynamic_field", "triggers mapping").endObject()
 *  
                        QueryBuilders.scriptQuery(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "1==1", Collections.emptyMap()))  
        assertHitCount(response, 1);
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    MediaTypeRegistry.JSON  
                LeafDocLookup leafDocLookup = (LeafDocLookup) vars.get("_doc");
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
                        boolQuery().filter(termQuery("field1", "value")).filter(rangeQuery("field2").from("now-1h").to("now+1h"))  
                )  
 */
            }
    public void testMapUnmappedFieldAsTextAfterDynamicMappingUpdate() throws IOException {
            scripts.put("1==1", vars -> Boolean.TRUE);  
        IndexService indexService = createIndexWithSimpleMappings(  
        // We can't check via api... because BitsetCacheListener requires that it can extract shardId from index reader
        client().prepareIndex("test")
        client().prepareIndex("test")
            doc.startArray("employees");
            .setId("1")
    public void testMapUnmappedFieldAsText() throws IOException {
            .endObject()
                    mapping.endObject();
        createIndex(
            .setQuery(
import java.util.Map;  
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
import org.opensearch.core.xcontent.XContentBuilder;
                        mapping.startObject("name");
            });
import org.opensearch.search.lookup.LeafDocLookup;  
import org.opensearch.search.sort.SortOrder;
            return scripts;  
            .setSource(jsonBuilder().startObject().field("query", matchQuery("field1", "value")).endObject())  
            scripts.put("use_fielddata_please", vars -> {
            .setSource(  
 * the Apache License, Version 2.0 (the "License"); you may
                        QueryBuilders.nestedQuery(  
 * software distributed under the License is distributed on an
        assertHitCount(response, 1);
import static org.opensearch.index.query.QueryBuilders.boolQuery;
        XContentBuilder mapping = XContentFactory.jsonBuilder();  
            assertHitCount(response, 1);  
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
    }  
            }
                    BytesReference.bytes(jsonBuilder().startObject().field("field1", "b").endObject()),
public class PercolatorQuerySearchTests extends OpenSearchSingleNodeTestCase {
import org.opensearch.script.Script;
                jsonBuilder().startObject()  
import org.opensearch.common.xcontent.XContentFactory;
                    )
        }
            .setSource(jsonBuilder().startObject().field("query", matchQuery("unmapped_field", "value")).endObject())  
            assertThat(searcher.count(query), equalTo(3));
            {  
            .setId("1")
import static org.opensearch.index.query.QueryBuilders.termQuery;
                doc.startObject();
 * GitHub history for details.
                mapping.field("type", "nested");
            query = queryBuilder.toQuery(queryShardContext);
            {
                                .endArray()  
        client().admin().indices().prepareCreate("index").setMapping("query", "type=percolator").get();
                mapping.endObject();  
        Script script = new Script(ScriptType.INLINE, MockScriptPlugin.NAME, "1==1", Collections.emptyMap());  
                    .endObject()
            .execute()
import org.opensearch.index.query.Operator;  
                    .endObject()
            "test",
            )
                            ScoreMode.Avg  
                            matchQuery("employee.name", "virginia potts").operator(Operator.AND),
        // and for percolator it can't do that, but that means we don't keep track of
package org.opensearch.percolator;
    }
                                .field("name", "tony stark")
                        mapping.field("type", "text");  
        assertEquals("The percolator works with in-memory index and therefor shouldn't use field-data cache", 0L, fieldDataSize);
                    .endObject()  
                new PercolateQueryBuilder(  
        client().prepareIndex("test")  
                    .field("query", QueryBuilders.nestedQuery("employees", QueryBuilders.scriptQuery(script), ScoreMode.Avg))
        client().admin().indices().prepareRefresh().get();  
                        mapping.endObject();
                // size 0, because other wise load bitsets for normal document in FetchPhase#findRootDocumentIfNested(...)
                    .field(
import org.opensearch.action.search.SearchResponse;
                .indices()
 * specific language governing permissions and limitations
            "field2",
import java.util.Collection;  
