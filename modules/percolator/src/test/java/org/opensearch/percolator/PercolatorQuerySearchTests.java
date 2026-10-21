                .addSort("_doc", SortOrder.ASC)
import org.opensearch.plugins.Plugin;
        // memory for BitsetCache in case of percolator
 */
/*
                                .startObject()
 *    http://www.apache.org/licenses/LICENSE-2.0
            )
import org.opensearch.test.OpenSearchSingleNodeTestCase;
                    MediaTypeRegistry.JSON
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {
                                .endArray()
import org.opensearch.core.xcontent.MediaTypeRegistry;
                        "query",
            )
import java.util.Collections;
            long[] currentTime = new long[] { System.currentTimeMillis() };
    public void testPercolateQueryWithNestedDocuments_doNotLeakBitsetCacheEntries() throws Exception {
        // Index a document that triggers a dynamic mapping update
 *
            .setId("q1")
                    .field(
        assertHitCount(response, 1);
        client().prepareIndex("test")
            .get();
                        "query",
    public void testRangeQueriesWithNow() throws Exception {
                mapping.field("type", "text");
        doc.endObject();
 * ownership. Elasticsearch licenses this file to you under
            )
import org.opensearch.action.search.SearchResponse;
                                .endObject()
                    "query",
            .startObject("name")
                        boolQuery().filter(termQuery("field1", "value")).filter(rangeQuery("field2").from("now-1h").to("now+1h"))
                    MediaTypeRegistry.JSON
    public void testPercolateScriptQuery() throws IOException {
    }
        }
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
                    mapping.endObject();
import static org.opensearch.index.query.QueryBuilders.scriptQuery;
 */
                mapping.endObject();
                    BytesReference.bytes(jsonBuilder().startObject().field("unmapped_field", "value").endObject()),
                )
            .setId("2")
                        mapping.field("fielddata", true);
            assertThat(searcher.count(query), equalTo(3));
import java.util.Collection;
        XContentBuilder mapping = XContentFactory.jsonBuilder();
                                .field("name", "tony stark")
                )
        createIndex("test", client().admin().indices().prepareCreate("test").setMapping(mapping));
                LeafDocLookup leafDocLookup = (LeafDocLookup) vars.get("_doc");
        SearchResponse response = client().prepareSearch("index")
import static org.opensearch.index.query.QueryBuilders.termQuery;
    }
        assertEquals("The percolator works with in-memory index and therefor shouldn't use field-data cache", 0L, fieldDataSize);
                        mapping.field("type", "text");
            .setSource(jsonBuilder().startObject().field("query", matchQuery("unmapped_field", "value")).endObject())
import java.util.Arrays;
        SearchResponse response = client().prepareSearch("test")
        );
            )
            "type=percolator"
            SearchResponse response = client().prepareSearch()
            "test",
            )
            Settings.builder().put("index.number_of_shards", 1).build(),
                        mapping.startObject("name");
                jsonBuilder().startObject()
                mapping.startObject("companyname");
            )
                    )
            .setId("1")
import org.opensearch.index.fielddata.ScriptDocValues;
                    mapping.startObject("properties");
                .setSize(0)
        createIndexWithSimpleMappings("test", settings.build(), "query", "type=percolator");
            .endObject()
            "field2",
        client().admin().indices().prepareRefresh().get();
                        BytesReference.bytes(
                .setQuery(
        createIndexWithSimpleMappings("test", settings.build(), "query", "type=percolator", "title", "type=text");
import java.util.HashMap;
    }
            query = queryBuilder.toQuery(queryShardContext);
                        MediaTypeRegistry.JSON
        client().admin().indices().prepareCreate("index").setMapping("query", "type=percolator").get();
    @Override
        );
            }
            .setId("1")
                                .startArray("employee")
 * the Apache License, Version 2.0 (the "License"); you may
        Script script = new Script(ScriptType.INLINE, MockScriptPlugin.NAME, "use_fielddata_please", Collections.emptyMap());
                // to avoid normal document from being cached by BitsetFilterCache
        assertHitCount(response, 1);
        // and for percolator it can't do that, but that means we don't keep track of
            .setId("1")
            QueryShardContext queryShardContext = indexService.newQueryShardContext(0, searcher, () -> currentTime[0], null);
            client().admin()
            assertHitCount(response, 1);
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            .field("type", "text")
import org.opensearch.indices.IndicesBitsetFilterCache;
 *
        long fieldDataSize = client().admin().cluster().prepareClusterStats().get().getIndicesStats().getFieldData().getMemorySizeInBytes();
        SearchResponse response = client().prepareSearch("test")
                        "query",
                new PercolateQueryBuilder(
    public static class CustomScriptPlugin extends MockScriptPlugin {
            .setId("1")
            {
            .startObject("employee")
 * Unless required by applicable law or agreed to in writing,
                )
package org.opensearch.percolator;
            }
            }
    public void testPercolateQueryWithNestedDocuments_doLeakFieldDataCacheEntries() throws Exception {
        client().prepareIndex("test")
                jsonBuilder().startObject()
            BytesReference source = BytesReference.bytes(
                    new PercolateQueryBuilder(
import org.opensearch.search.lookup.LeafDocLookup;
 * KIND, either express or implied.  See the License for the
                    )
        assertEquals("The percolator works with in-memory index and therefor shouldn't use bitset cache", 0L, bitsetSize);
            .get();
    }
                    )
            )
    protected Collection<Class<? extends Plugin>> getPlugins() {
                    .endObject()
                            ScoreMode.Avg
        return Arrays.asList(PercolatorModulePlugin.class, CustomScriptPlugin.class);
import org.apache.lucene.search.join.ScoreMode;
                    "query",
            source = BytesReference.bytes(jsonBuilder().startObject().field("field1", "value").field("field2", currentTime[0]).endObject());
public class PercolatorQuerySearchTests extends OpenSearchSingleNodeTestCase {
        Settings.Builder settings = Settings.builder().put("index.percolator.map_unmapped_fields_as_text", true);
import org.opensearch.search.sort.SortOrder;
                                .field("name", "virginia potts")
            .get();
            assertHitCount(response, 1);
                mapping.startObject("query");
import static org.hamcrest.Matchers.equalTo;
 * Licensed to Elasticsearch under one or more contributor
 */
        for (int i = 0; i < 32; i++) {
import org.opensearch.common.xcontent.XContentFactory;
                jsonBuilder().startObject()
            .setSource(jsonBuilder().startObject().field("query", matchQuery("field1", "value")).endObject())
        long bitsetSize = client().admin().cluster().prepareClusterStats().get().getIndicesStats().getSegments().getBitsetMemoryInBytes();
 * software distributed under the License is distributed on an
            .field("type", "text")
            {
        client().admin().indices().prepareRefresh().get();
        client().prepareIndex("test")
            doc.startArray("employees");
                        mapping.endObject();
                    .field(
 *
            SearchResponse response = client().prepareSearch()
                mapping.endObject();
 * compatible open source license.
            .setSource(
        IndexService indexService = createIndexWithSimpleMappings(
                    .endObject()
                .setMapping(mapping)
                new PercolateQueryBuilder(
            .get();
            .setQuery(
 * The OpenSearch Contributors require contributions made to
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.script.MockScriptPlugin;
        client().admin().indices().prepareRefresh().get();
            {
 * Modifications Copyright OpenSearch Contributors. See
                        ),
 * specific language governing permissions and limitations
                    BytesReference.bytes(jsonBuilder().startObject().field("field1", "b").endObject()),
            currentTime[0] = currentTime[0] + 10800000; // + 3 hours
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                    BytesReference.bytes(jsonBuilder().startObject().field("field1", "value").endObject()),
            .setSource(
    public void testMapUnmappedFieldAsText() throws IOException {
        client().prepareIndex("test")
            "type=date",
                            "employee",
import org.opensearch.index.query.QueryBuilder;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .startObject("query")
                    .field("query", QueryBuilders.nestedQuery("employees", QueryBuilders.scriptQuery(script), ScoreMode.Avg))
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
                    .endObject()
            "query",
            mapping.endObject();
                jsonBuilder().startObject()
 * license agreements. See the NOTICE file distributed with
        for (int i = 0; i < 32; i++) {
        createIndex(
    }
                doc.endObject();
/*
                )
import org.opensearch.core.xcontent.XContentBuilder;
                mapping.startObject("employees");
            );
                    .endObject()
                            XContentFactory.jsonBuilder()
        mapping.startObject();
            scripts.put("1==1", vars -> Boolean.TRUE);
            .field("type", "nested")
                mapping.field("type", "percolator");
/*
import org.opensearch.index.query.QueryShardContext;
        }
                            matchQuery("employee.name", "virginia potts").operator(Operator.AND),
        client().prepareIndex("index")
                                .endObject()
import org.opensearch.index.IndexService;
                    MediaTypeRegistry.JSON
                }
import static org.opensearch.index.query.QueryBuilders.rangeQuery;
                doc.endObject();
        assertSearchHits(response, "1");
                        )
                    "query",
        client().prepareIndex("test")
            .setQuery(
        assertSearchHits(response, "1");
                .setQuery(new PercolateQueryBuilder("query", BytesReference.bytes(doc), MediaTypeRegistry.JSON))
}
            .get();
import org.opensearch.index.query.QueryBuilders;
import static org.opensearch.index.query.QueryBuilders.boolQuery;
        XContentBuilder doc = jsonBuilder();
            .endObject()
import org.opensearch.script.ScriptType;
            )
        }
 * this work for additional information regarding copyright
                .prepareCreate("test")
        @Override
            .get();
                doc.field("name", "tony_stark");
        client().admin().indices().prepareRefresh().get();
                // size 0, because other wise load bitsets for normal document in FetchPhase#findRootDocumentIfNested(...)
            .endObject()
        }
            )
        mapping.startObject()
        client().prepareIndex("test")
        client().prepareIndex("test")
                    .field(
            {
        // Now index a percolator query referencing an unmapped field — this should still work
import org.opensearch.action.support.WriteRequest;
                                .startObject()
            "type=keyword",
            queryBuilder = new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON);
                doc.startObject();
                mapping.field("type", "nested");
            Query query = queryBuilder.toQuery(queryShardContext);
                    .endObject()
        // We can't check via api... because BitsetCacheListener requires that it can extract shardId from index reader
            scripts.put("use_fielddata_please", vars -> {
        }
                {
            QueryBuilder queryBuilder = new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON);
                .get();
                new PercolateQueryBuilder(
            .get();
        client().admin().indices().prepareRefresh().get();
        XContentBuilder mapping = XContentFactory.jsonBuilder();
                doc.field("name", "virginia_potts");
                                .startObject()
            }
 * not use this file except in compliance with the License.
        mapping.endObject();
                    Settings.builder().put(IndicesBitsetFilterCache.INDEX_LOAD_RANDOM_ACCESS_FILTERS_EAGERLY_SETTING.getKey(), false)
            .get();
import org.opensearch.common.settings.Settings;
                                .endObject()
        Settings.Builder settings = Settings.builder().put("index.percolator.map_unmapped_fields_as_text", true);
                .indices()
 * this file be licensed under the Apache-2.0 license or a
                jsonBuilder().startObject().field("title", "some document").field("new_dynamic_field", "triggers mapping").endObject()
            .setSource(
                        QueryBuilders.scriptQuery(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "1==1", Collections.emptyMap()))
            .endObject()
        assertHitCount(response, 1);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
        {
            .setId("q1")
            mapping.startObject("properties");
            return scripts;
                .addSort("_doc", SortOrder.ASC)
                .setSettings(
 * You may obtain a copy of the License at
        }
    public void testMapUnmappedFieldAsTextAfterDynamicMappingUpdate() throws IOException {
            .get();
                jsonBuilder().startObject().field("field1", "value").field("field2", currentTime[0]).endObject()
            doc.endArray();
                    .field("query", boolQuery().filter(scriptQuery(script)).filter(rangeQuery("field2").from("now-1h").to("now+1h")))
            assertThat(searcher.count(query), equalTo(3));
            .field("type", "percolator")
import java.io.IOException;
import java.util.function.Function;
            doc.field("companyname", "stark");
            .setSource(
 * GitHub history for details.
        {
 * under the License.
    }
                )
            "field1",
            .setId("doc1")
            });
            .get();
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
import org.apache.lucene.search.Query;
                        QueryBuilders.nestedQuery(
import java.util.Map;
            .startObject("properties")
        Script script = new Script(ScriptType.INLINE, MockScriptPlugin.NAME, "1==1", Collections.emptyMap());
            .setId("3")
import org.opensearch.index.engine.Engine;
import org.opensearch.core.common.bytes.BytesReference;
import static org.opensearch.index.query.QueryBuilders.matchQuery;
            .setSource(
    }
                doc.startObject();
        client().prepareIndex("test")
            "test",
            .setSource(jsonBuilder().startObject().field("query", rangeQuery("field2").from("now-1h").to("now+1h")).endObject())
                    )
                ScriptDocValues<?> scriptDocValues = leafDocLookup.get("employees.name");
                    {
import org.opensearch.index.query.Operator;
        doc.startObject();
                .get();
            .get();
            .execute()
                mapping.endObject();
                        "query",
            .endObject()
                    }
            }
            .endObject()
                                .field("companyname", "stark")
            .actionGet();
            .startObject("properties")
    }
            .endObject();
            .setQuery(
import org.opensearch.script.Script;
                return "virginia_potts".equals(scriptDocValues.get(0));
            {
            .setSource(
        assertSearchHits(response, "1");
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            .startObject("companyname")
                jsonBuilder().startObject()
