import org.opensearch.common.xcontent.XContentType;
                            BytesReference.bytes(jsonBuilder().startObject().field("field1", "d").endObject()),
            .setId("2")
            .setSource(jsonBuilder().startObject().field(queryFieldName, matchQuery("field", "value")).endObject())
            );
            .get();
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));
            .addSort("id", SortOrder.ASC)
                            .startObject()
        // doesn't match
        SearchResponse response = client().prepareSearch()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    }
    @Override
            equalTo("The quick <em>brown</em> <em>fox</em> jumps over the lazy dog")
            .startObject("properties")
                        .startObject("properties")
                        )
        assertHitCount(response, 1);
            .get();
                    .field("query", boolQuery().must(rangeQuery("field2").from(10).to(12)).must(rangeQuery("field2").from(12).to(14)))
            .setQuery(new PercolateQueryBuilder("object_field." + queryFieldName, source, MediaTypeRegistry.JSON))
        assertAcked(
            jsonBuilder().startObject().field("field1", "The quick brown fox jumps").endObject()
                    .indices()
            .setId("3")
                jsonBuilder().startObject()
        );
        source = BytesReference.bytes(jsonBuilder().startObject().field("field3", "192.168.1.5").endObject());
                .setMapping("id", "type=keyword", "field1", "type=keyword", "field2", "type=keyword", "query", "type=percolator")
                        new PercolateQueryBuilder(
                    MediaTypeRegistry.JSON
            .endObject()
                        .endArray()
                    "query",
                            "query",
                                .startObject()
            .setId("1")
                .prepareCreate("test")
                        ).setName("query2")
                .setSource(
            equalTo("<em>brown</em> <em>fox</em>")
        client().prepareIndex("test")
    }
            assertThat(response.getHits().getAt(0).getFields().get("_percolator_document_slot").getValue(), equalTo(0));
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .prepareCreate("test")
                            .endObject()
            .get();
                            MediaTypeRegistry.JSON
        client().admin().indices().prepareRefresh().get();
        source = BytesReference.bytes(jsonBuilder().startObject().field("field4", "2016-05-15").endObject());
        );
                        geoPolygonQuery("field1", Arrays.asList(new GeoPoint(52.1, 4.4), new GeoPoint(52.3, 4.5), new GeoPoint(52.1, 4.6)))
        client().prepareIndex("test")
            .setSource(jsonBuilder().startObject().field("id", "2").field("query", matchQuery("field1", "value")).endObject())
        BytesReference source = BytesReference.bytes(jsonBuilder().startObject().field("field1", 12).endObject());
                    .field(
        assertThat(item.getFailureMessage(), nullValue());
                            .addClause(spanTermQuery("field1", "fox"))
            .get();
            .add(
            .get();
        );
            .setSource(
        );
            .highlighter(new HighlightBuilder().field("field1"))
            .get();
                            .startObject()
                .indices()
                            .endObject()
            searchResponse.getHits().getAt(3).getHighlightFields().get("field1").fragments()[0].string(),
import org.opensearch.plugins.Plugin;
                .setId("1")
            .setQuery(
        SearchResponse response = client().prepareSearch()
            .setSource(jsonBuilder().startObject().field("query", new MatchPhraseQueryBuilder("field", "brown fox").slop(5)).endObject())
import static org.opensearch.index.query.QueryBuilders.spanNotQuery;
            .get();
            .setId("2")
                        .field(queryFieldName, matchQuery("field", "value"))
        assertThat(response.getHits().getAt(1).getFields().get("_percolator_document_slot").getValue(), equalTo(0));
            .actionGet();
 * not use this file except in compliance with the License.
            .addSort("id", SortOrder.ASC)
                    )
            searchResponse.getHits().getAt(1).getHighlightFields().get("query1_0_field1").fragments()[0].string(),
                .setMapping("id", "type=keyword", "field1", fieldMapping.toString(), "query", "type=percolator")
        client().admin().indices().prepareRefresh().get();
            .setSource(jsonBuilder().startObject().field("id", "q3").field("query", QueryBuilders.matchAllQuery()).endObject())
                    jsonBuilder().startObject()
                            XContentFactory.jsonBuilder()
        assertHitCount(item.getResponse(), 1L);
import static org.opensearch.index.query.QueryBuilders.spanNearQuery;
        assertSearchHits(response, "7");
        assertThat(response.getHits().getAt(2).getId(), equalTo("3"));
                )
            .highlighter(new HighlightBuilder().field("field1"))
            .setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON))
import static org.hamcrest.Matchers.instanceOf;
            .actionGet();
                    ),
            )
            .get();
        client().admin().indices().prepareRefresh().get();
            client().prepareIndex("test2")
import static org.opensearch.index.query.QueryBuilders.commonTermsQuery;
            .setId("1")
/*
                .endObject()
        );
        assertThat(searchResponse.getHits().getAt(1).getHighlightFields().get("0_field1").fragments()[0].string(), equalTo("<em>dog</em>"));
            .setId("2")
            )
                client().prepareSearch("test")
        );
            .add(
        // Test IP range:
        );
            .actionGet();
                    .field("query", multiMatchQuery("quick brown fox", "field1", "field2").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS))
            .setId("10")
        assertHitCount(response, 1);
            .setSource(jsonBuilder().startObject().field("id", "1").field("query", matchAllQuery()).endObject())
        client().prepareIndex("test").setId("1").setSource(jsonBuilder().startObject().field("query", matchAllQuery()).endObject()).get();
            .setId("5")
                    )
                                .startObject()
                    .endObject()
            equalTo(Collections.singletonList(0))
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            equalTo(Collections.singletonList(1))
        }
                "[percolate] queries cannot be executed when 'search.allow_expensive_queries' is set to false.",
            .get();
                    .endObject()
        assertThat(response.getHits().getAt(1).getId(), equalTo("q3"));
        );
 * You may obtain a copy of the License at
        client().prepareIndex("test")
                            .field("name", "virginia stark")
        client().admin().indices().prepareRefresh().get();
                jsonBuilder().startObject()
        );
        );
                boolQuery().should(
        assertAcked(
            .execute()
                                .addClause(spanTermQuery("field1", "fox"))
                        BytesReference.bytes(
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
                    .field("id", "2")
                                .startObject()
        BytesReference source = BytesReference.bytes(jsonBuilder().startObject().field("field", "value").endObject());
            .setSource(
            .actionGet();
                .setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON))
            .setQuery(
import org.opensearch.index.query.Operator;
            .get();
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));
            assertEquals(
        assertThat(
        assertThat(
    }
                    )
            .get();
        );
            )
                .setMapping("field", "type=text,position_increment_gap=5", "query", "type=percolator")
                        .startObject("object_field")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                            .startObject()
            searchResponse.getHits().getAt(0).getHighlightFields().get("3_field1").fragments()[0].string(),
                        "query",
        );
            .get();
                    "type=date",
                        spanNotQuery(
        item = response.getResponses()[4];
        logger.info("searchResponse={}", searchResponse);
        );
                .setMapping(
        item = response.getResponses()[5];
        assertHitCount(response, 2);
    }
            )
            )
 *
            .execute()
                            MediaTypeRegistry.JSON
 * ownership. Elasticsearch licenses this file to you under
            .setSource(
            .get();
                jsonBuilder().startObject()
        assertHitCount(response, 2);
                    .field("id", "q2")
            .add(
            .get();
        source = BytesReference.bytes(jsonBuilder().startObject().field("field2", 12).endObject());
import org.opensearch.action.search.SearchResponse;
        client().prepareIndex("test")
        SearchResponse response = client().prepareSearch()
                .indices()
    public void testManyPercolatorFields() throws Exception {
        BytesReference source = BytesReference.bytes(jsonBuilder().startObject().endObject());
        assertThat(response.getHits().getAt(3).getScore(), equalTo(Float.NaN));
            .setSource(jsonBuilder().startObject().field("id", "5").field("query", termQuery("field1", "fox")).endObject())
 */
            )
                .indices()
        client().prepareIndex("test")
                        .endObject()
                .setMapping(queryFieldName, "type=percolator", "second_query_field", "type=percolator", "field", "type=keyword")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
                jsonBuilder().startObject()
            .actionGet();
                constantScoreQuery(
            .setSource(jsonBuilder().startObject().field("query", new MatchPhraseQueryBuilder("field", "brown fox").slop(4)).endObject())
            .get();
        logger.info("response={}", response);
        assertThat(
 * KIND, either express or implied.  See the License for the
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
                    .endObject()
                    BytesReference.bytes(
            .setId("6")
            .get();
                    .endObject()
import org.opensearch.geo.GeoModulePlugin;
            .setId("1")
 * specific language governing permissions and limitations
                        boolQuery().must(rangeQuery("field3").from("192.168.1.0").to("192.168.1.5"))
                .indices()
        client().prepareIndex("test")
        assertSearchHits(item.getResponse(), "2", "4");
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", false));
        if (randomBoolean()) {
            .get();
        logger.info("percolating empty doc");
    public void testDisallowExpensiveQueries() throws IOException {
            .addSort("id", SortOrder.ASC)
import static org.opensearch.index.query.QueryBuilders.matchQuery;
                                .endArray()
            .setId("1")
        return Arrays.asList(
            .actionGet();
        assertThat(response.getHits().getAt(2).getFields().get("_percolator_document_slot").getValues(), equalTo(Arrays.asList(1)));
            .setQuery(new PercolateQueryBuilder(queryFieldName, source, MediaTypeRegistry.JSON))
}
                                .field("name", "peter parker")
            .addSort("id", SortOrder.ASC)
            .setQuery(
        } finally {
            .execute()
            .setId("1")
            .get();
        assertAcked(client().admin().indices().prepareCreate("test").setMapping(mapping));
                                BytesReference.bytes(jsonBuilder().startObject().field("field1", "brown fox").endObject())
            .actionGet();
        logger.info("percolating doc with 2 fields");
                    .endObject()
                    MediaTypeRegistry.JSON
        );
                        .endObject()
                )
                        .endObject()
                new PercolateQueryBuilder(
            .setSource(
        );
        );
            .get();
            .setId("2")
            .addSort("id", SortOrder.ASC)
        client().prepareIndex("test")
            )
                        .endObject()
                            "query",
            .setSource(jsonBuilder().startObject().field("id", "3").field("query", termQuery("field1", "jumps")).endObject())
            searchResponse.getHits().getAt(0).getFields().get("_percolator_document_slot_query1").getValues(),
            equalTo("The quick brown fox jumps over the <em>lazy</em> <em>dog</em>")
        );
        assertHitCount(response, 3);
        assertHitCount(response, 4);
                .field("field1", "the quick brown fox jumps over the lazy dog")
                        .startObject(queryFieldName)
            )
    }
                )
                .prepareCreate("test")
                jsonBuilder().startObject()
                jsonBuilder().startObject()
                .setMapping(
        BytesReference source = BytesReference.bytes(
        assertEquals(1, response.getHits().getTotalHits().value());
        assertHitCount(item.getResponse(), 2L);
        source = BytesReference.bytes(jsonBuilder().startObject().field("field1", 11).endObject());
            searchResponse.getHits().getAt(4).getFields().get("_percolator_document_slot_query1").getValues(),
                        spanNotQuery(
            equalTo(Collections.singletonList(0))
                .get();
                                .endArray()
                    .field("query", geoBoundingBoxQuery("field1").setCorners(52.3, 4.4, 52.1, 4.6))
        return Arrays.asList(PercolatorModulePlugin.class, GeoModulePlugin.class);
                    .endObject()
 * Licensed to Elasticsearch under one or more contributor
            .highlighter(new HighlightBuilder().field("field1"))
        assertAcked(
                    Arrays.asList(
        StringBuilder fieldMapping = new StringBuilder("type=text").append(",store=").append(randomBoolean());
        SearchResponse response = client().prepareSearch()
            client().admin()
            .execute()
            searchResponse.getHits().getAt(0).getHighlightFields().get("query1_1_field1").fragments()[0].string(),
                new PercolateQueryBuilder(
                        MediaTypeRegistry.JSON
            .get();
        client().admin().indices().prepareRefresh().get();
                    jsonBuilder().startObject()
                        .startObject()
import static org.opensearch.index.query.QueryBuilders.geoBoundingBoxQuery;
            equalTo(Collections.singletonList(1))
            .setSource(
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .setId("3")
                client().prepareSearch("test")
                            BytesReference.bytes(jsonBuilder().startObject().field("field1", "dog").endObject()),
            .setSource(jsonBuilder().startObject().field("query", rangeQuery("field3").from("192.168.1.20").to("192.168.1.30")).endObject())
        client().prepareIndex("test")
import org.opensearch.index.mapper.MapperParsingException;
                    .field(
        client().prepareIndex("test")
            .addSort("id", SortOrder.ASC)
            .get();
            BytesReference source = BytesReference.bytes(jsonBuilder().startObject().field("field1", "value").endObject());
                        ).dist(2)
                    )
        assertThat(
            .addSort("id", SortOrder.ASC)
                    .field(
            .addSort("id", SortOrder.ASC)
        assertThat(response.getHits().getAt(0).getId(), equalTo("2"));
                        QueryBuilders.nestedQuery(
        client().admin().indices().prepareRefresh().get();
        mapping.startObject()
            .get();
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));
        client().prepareIndex("test")
        assertThat(response.getHits().getAt(0).getIndex(), equalTo("test1"));
                    .endObject()
        assertThat(response.getHits().getAt(2).getId(), equalTo("3"));
    public void testPercolatorSpecificQueries() throws Exception {
        response = client().prepareSearch().setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON)).get();
            .setQuery(
            )
        client().admin().indices().prepareRefresh().get();
        source = BytesReference.bytes(jsonBuilder().startObject().field("field1", "value").endObject());
            OpenSearchException e = expectThrows(
                        .startObject(queryFieldName)
            client().admin()
                .setMapping("id", "type=keyword", "field1", "type=keyword", "field2", "type=keyword", "query", "type=percolator")
                        new PercolateQueryBuilder(
            .setSource(
            .setSource(
            searchResponse.getHits().getAt(2).getHighlightFields().get("2_field1").fragments()[0].string(),
                    .endObject()
            .setId("3")
                .setMapping("_source", "enabled=false", "field1", "type=keyword", "query", "type=percolator")
    }
                                .addClause(spanTermQuery("field1", "dog"))
        assertThat(item.getFailureMessage(), nullValue());
        item = response.getResponses()[2];
                            .startObject()
            // Set search.allow_expensive_queries to "false" => assert failure
                            .must(rangeQuery("field3").from("192.168.1.5").to("192.168.1.10"))
            client().admin()
import org.opensearch.common.settings.Settings;
    @Override
        client().prepareIndex("test1")
            .setId("2")
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
                                .inOrder(true),
        client().prepareIndex("test")
        assertHitCount(item.getResponse(), 2L);
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
                    MediaTypeRegistry.JSON
        client().prepareIndex("test")
import org.opensearch.OpenSearchException;
            .get();
            .setSource(jsonBuilder().startObject().field("id", "1").field("query", matchQuery("field1", "brown fox")).endObject())
    }
    }
        client().admin().indices().prepareRefresh().get();
import org.opensearch.index.query.QueryBuilders;
        );
            .actionGet();
import static org.opensearch.index.query.QueryBuilders.geoDistanceQuery;
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> {
        );
            )
                            .field("companyname", "stark")
            .setSource(
        assertThat(searchResponse.getHits().getAt(4).getHighlightFields().get("1_field1").fragments()[0].string(), equalTo("<em>fox</em>"));
        client().prepareIndex("test")
                    .field("query", boolQuery().must(matchQuery("field1", "value")).must(matchQuery("field2", "value")))
            fieldMapping.append(",term_vector=with_positions_offsets");
                            .startArray("employee")
                    .endObject()
            .setId("q3")
                                .startArray("employee")
    }
public class PercolatorQuerySearchIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                        "query",
    public PercolatorQuerySearchIT(Settings staticSettings) {
            .get();
        assertThat(
                jsonBuilder().startObject()
import java.util.Collections;
        assertThat(
                    )
                        BytesReference.bytes(
import org.opensearch.core.common.bytes.BytesArray;
            .startObject("query")
    public void testPercolatorGeoQueries() throws Exception {
        // Test double range:
                        .field("type", "object")
            searchResponse.getHits().getAt(1).getFields().get("_percolator_document_slot_query1").getValues(),
                        .endObject()
            searchResponse.getHits().getAt(4).getHighlightFields().get("query2_1_field1").fragments()[0].string(),
                    .field("id", "3")
                new PercolateQueryBuilder(
                        MediaTypeRegistry.JSON
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
                    .field(
        client().prepareIndex("test")
        assertThat(e.getMessage(), containsString("source disabled"));
        assertHitCount(response, 1);
            .setQuery(new PercolateQueryBuilder("query", "test", "1", null, null, null))
            assertHitCount(response, 1);
        assertThat(response.getHits().getAt(0).getScore(), equalTo(Float.NaN));
        response = client().prepareSearch()
            .setSource(
            response = client().prepareSearch().setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON)).get();
                )
                    new PercolateQueryBuilder(
            .setSource(
                            XContentType.YAML
            equalTo("The quick brown fox <em>jumps</em> over the lazy dog")
        BytesReference document2 = BytesReference.bytes(jsonBuilder().startObject().field("field1", "over the lazy dog").endObject());
                    .setQuery(
            .get();
                    ),
                jsonBuilder().startObject()
            searchResponse.getHits().getAt(0).getHighlightFields().get("query2_1_field1").fragments()[0].string(),
        );
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
            // Set search.allow_expensive_queries setting to "true" ==> success
                    new PercolateQueryBuilder(
            equalTo(Collections.singletonList(1))
            )
        response = client().prepareSearch().setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON)).get();
            .get();
            .get();
                    .field("id", 2)
        assertThat(response.getHits().getAt(2).getId(), equalTo("3"));
            .execute()
                        new PercolateQueryBuilder(
                        .endObject()
        assertAcked(
        client().admin().indices().prepareRefresh().get();
            .get();
            )
        });
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            .setId("9")
                )
        );
            )
                jsonBuilder().startObject()
            equalTo("<em>fox</em>")
                        .endObject()
                    Arrays.asList(
        assertHitCount(response, 1);
                jsonBuilder().startObject()
            )
            .setSource(
            )
                                .endArray()
        assertAcked(
        refresh();
                    MediaTypeRegistry.JSON
                jsonBuilder().startObject()
            .startObject("employee")
                        BytesReference.bytes(
        );
            .setId("2")
                        .field("type", "percolator")
        client().prepareIndex("test")
                                .startObject()
        assertHitCount(response, 2);
        assertThat(response.getHits().getAt(2).getId(), equalTo("3"));
            .setId("1")
        response = client().prepareSearch()
                    )
            )
                    jsonBuilder().startObject()
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
                        "query",
        assertHitCount(response, 2);
            searchResponse.getHits().getAt(4).getHighlightFields().get("query1_1_field1").fragments()[0].string(),
                        BytesReference.bytes(jsonBuilder().startObject().field("field1", "dog").endObject()),
                            spanNearQuery(spanTermQuery("field1", "the"), 0).addClause(spanTermQuery("field1", "lazy"))
                        Arrays.asList(
                .indices()
        response = client().prepareSearch().setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON)).get();
            .setSource(
 * software distributed under the License is distributed on an
        client().prepareIndex("test")
                    .field("id", "3")
                .setId("1")
                        .startObject()
                    "query",
        response = client().prepareSearch()
            .setIndices("test2")
            .setQuery(
            .setSource(jsonBuilder().startObject().field("query", rangeQuery("field3").from("192.168.1.0").to("192.168.1.5")).endObject())
            .endObject()
            searchResponse.getHits().getAt(3).getHighlightFields().get("query1_0_field1").fragments()[0].string(),
                )
 * SPDX-License-Identifier: Apache-2.0
            .actionGet();
        );
    public void testTakePositionOffsetGapIntoAccount() throws Exception {
    public void testWithMultiplePercolatorFields() throws Exception {
 * license agreements. See the NOTICE file distributed with
                                .endObject()
        assertAcked(
        // this query should never match as it doesn't use nested query:
                                .startObject()
        client().prepareIndex("test")
            .setSource(jsonBuilder().startObject().field("query", matchQuery("field1", "c")).endObject())
        client().admin().indices().prepareRefresh().get();
                )
        // Test long range:
                new PercolateQueryBuilder(
        assertHitCount(response, 3);
        );
            client().admin().indices().prepareCreate("test1").setMapping(queryFieldName, "type=percolator", "field", "type=keyword")
                    "query",
            .get();
            .setSource(jsonBuilder().startObject().field("query", rangeQuery("field2").from(20).to(22)).endObject())
        assertThat(response.getHits().getAt(1).getId(), equalTo("q3"));
            .get();
            client().admin()
            equalTo(Collections.singletonList(2))
            .endObject()
        assertThat(response.getHits().getAt(0).getId(), equalTo("q3"));
            .setId("3")
                        new PercolateQueryBuilder(
        client().prepareIndex("test")
        assertAcked(
            searchResponse.getHits().getAt(0).getHighlightFields().get("query1_field1").fragments()[0].string(),
            searchResponse.getHits().getAt(4).getFields().get("_percolator_document_slot_query2").getValues(),
            searchResponse.getHits().getAt(3).getFields().get("_percolator_document_slot").getValues(),
            .get();
 */
        client().prepareIndex("test")
            .setQuery(new PercolateQueryBuilder("query", "test", "5", null, null, null))
        } else if (randomBoolean()) {
                        )
                    .prepareCreate("test")
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            .setQuery(
                )
            searchResponse.getHits().getAt(4).getFields().get("_percolator_document_slot").getValues(),
import org.opensearch.index.query.MultiMatchQueryBuilder;
        assertHitCount(response, 2);
                                .endObject()
                    Arrays.asList(
    public void testWrappedWithConstantScore() throws Exception {
                    "type=percolator"
        assertThat(item.getFailureMessage(), nullValue());
            .get();
            searchResponse.getHits().getAt(1).getHighlightFields().get("field1").fragments()[0].string(),
                        .field("type", "percolator")
                .indices()
        super(staticSettings);
                )
                                .endObject()
                    MediaTypeRegistry.JSON
                    .startObject("object_field")
            client().admin()
                    .field("id", 5)
        );
                    "type=double",
            .setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON))
            .setId("8")
        String queryFieldName = randomAlphaOfLength(8);
                    .setQuery(
            )
            // Execute with search.allow_expensive_queries = null => default value = false => success
                    "field2",
        );
 *
            equalTo("The quick brown fox <em>jumps</em>")
        assertThat(response.getHits().getAt(0).getFields().get("_percolator_document_slot").getValues(), equalTo(Arrays.asList(0, 1)));
        assertThat(response.getHits().getAt(2).getScore(), equalTo(Float.NaN));
            .execute()
            .addSort("id", SortOrder.ASC)
        client().admin().indices().prepareRefresh().get();
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
                    .field(queryFieldName, matchQuery("field", "value"))
        logger.info("percolating empty doc with source disabled");
        assertThat(
                    .field(
        assertEquals(1, response.getHits().getTotalHits().value());
        response = client().prepareSearch("test")
            .actionGet();
        assertSearchHits(item.getResponse(), "1", "4");
            client().admin()
            assertAcked(
        client().admin().indices().prepareRefresh().get();
                            .endArray()
        assertThat(
            .get();
                        ),
        assertThat(
            .setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON))
import static org.opensearch.index.query.QueryBuilders.geoPolygonQuery;
                    )
            .setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON))
            assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
                        "query",
            .get();
                    .endObject()
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", true));
            )
    }
        assertSearchHits(item.getResponse(), "4");
        assertThat(
        assertThat(searchResponse.getHits().getAt(0).getHighlightFields().get("1_field1").fragments()[0].string(), equalTo("<em>fox</em>"));
        );
        response = client().prepareSearch()
            .setQuery(new PercolateQueryBuilder("query", new BytesArray("{\"field\" : [\"brown\", \"fox\"]}"), MediaTypeRegistry.JSON))
                                .field("name", "virginia potts")
                    )
                client().prepareSearch("test")
                .field("field2", "the quick brown fox falls down into the well")
 * this work for additional information regarding copyright
                    .field("query", boolQuery().must(rangeQuery("field1").from(10).to(12)).must(rangeQuery("field1").from(12).to(14)))
        client().prepareIndex("test")
            )
            .execute()
            .setId("4")
                jsonBuilder().startObject()
                            .startArray("employee")
            searchResponse.getHits().getAt(2).getHighlightFields().get("field1").fragments()[0].string(),
                        .startObject("field")
        client().prepareIndex("test")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                jsonBuilder().startObject()
                                .startArray("employee")
            fieldMapping.append(",index_options=offsets");
        client().prepareIndex("test")
        assertSearchHits(response, "3", "1");
            .setId("3")
 * Unless required by applicable law or agreed to in writing,
            searchResponse.getHits().getAt(3).getHighlightFields().get("query2_field1").fragments()[0].string(),
                            .endObject()
                .setMapping("id", "type=keyword", "field1", "type=text", "field2", "type=text", "query", "type=percolator")
                        .startObject("properties")
            .addSort("id", SortOrder.ASC)
            equalTo(Collections.singletonList(0))
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
            .add(
        client().prepareIndex("test")
            .actionGet();
        logger.info("percolating doc with 2 fields");
 * compatible open source license.
            )
            searchResponse.getHits().getAt(1).getHighlightFields().get("query2_field1").fragments()[0].string(),
        });
        assertThat(response.getHits().getAt(1).getScore(), equalTo(Float.NaN));
            )
            .setSource(jsonBuilder().startObject().field("query", matchQuery("field1", "b")).field("a", "b").endObject())
        assertHitCount(response, 2);
            equalTo(Collections.singletonList(1))
        assertThat(
            .setSource(
                        .field("type", "keyword")
                            QueryBuilders.matchQuery("employee.name", "virginia potts").operator(Operator.AND),
                                .field("name", "virginia potts")
        assertHitCount(searchResponse, 5);
        SearchResponse response = client().prepareSearch()
                    .endObject()
            .field("type", "keyword")
                .setMapping("id", "type=keyword", "field1", "type=geo_point", "field2", "type=geo_shape", "query", "type=percolator")
            equalTo("The quick brown fox jumps over the lazy <em>dog</em>")
        assertThat(item.getFailureMessage(), notNullValue());
                            MediaTypeRegistry.JSON
        source = BytesReference.bytes(jsonBuilder().startObject().field("field1", "value").field("field2", "value").endObject());
        logger.info("searchResponse={}", searchResponse);
        client().prepareIndex("test")
        assertThat(response.getHits().getAt(1).getFields().get("_percolator_document_slot").getValues(), equalTo(Arrays.asList(0, 1, 2)));
 *
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
            .execute()
                    .field("id", "q1")
            searchResponse.getHits().getAt(2).getHighlightFields().get("query1_field1").fragments()[0].string(),
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
                client().admin()
import static org.hamcrest.Matchers.equalTo;
                            BytesReference.bytes(jsonBuilder().startObject().field("field1", "b c").endObject()),
            )
                                .inOrder(true)
                    BytesReference.bytes(
                        .endObject()
        assertHitCount(response, 1);
                )
                        .startObject("properties")
        assertHitCount(response, 1);
            .get();
                        BytesReference.bytes(jsonBuilder().startObject().field("d", "2020-02-01T15:00:00.000+11:00").endObject()),
                .indices()
        assertThat(
                        new PercolateQueryBuilder(
                )
            client().admin()
            equalTo("brown <em>fox</em>")
            .get();
                            "query",
        assertThat(response.getHits().getAt(0).getIndex(), equalTo("test2"));
            );
    @ParametersFactory
        MultiSearchResponse response = client().prepareMultiSearch()
                    "query",
            )
import java.util.Collection;
            updateSettingsRequest = new ClusterUpdateSettingsRequest();
        BytesReference source = BytesReference.bytes(
            equalTo("brown <em>fox</em>")
                    .field("query", boolQuery().must(matchQuery("field1", "value")).must(matchQuery("field2", "value")))
                .indices()
            .setId("4")
                        .endObject()
        assertThat(
                    ).setName("query1")
                new PercolateQueryBuilder(
                    .endObject()
                    .endObject()
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            .startObject("id")
                            Arrays.asList(
                        .endObject()
            .startObject("name")
            .get();
                            XContentFactory.jsonBuilder()
            .setIndices("test1")
            .setQuery(
    public void testPercolatorRangeQueries() throws Exception {
        client().prepareIndex("test")
                                .startObject()
            .get();
                    .field("query", QueryBuilders.matchQuery("employee.name", "virginia"))
    public void testPercolateQueryWithNestedDocuments() throws Exception {
                        .endObject()
            )
            .setSource(jsonBuilder().startObject().field("field1", "c").endObject())
        assertThat(
        );
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
                )
        XContentBuilder mapping = XContentFactory.jsonBuilder();
                    "type=ip",
 * the Apache License, Version 2.0 (the "License"); you may
            .get();
        searchResponse = client().prepareSearch()
        assertThat(
        response = client().prepareSearch()
 * under the License.
                    .endObject()
                                .field("companyname", "stark")
                                .startObject()
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        assertThat(response.getHits().getAt(1).getFields().get("_percolator_document_slot").getValue(), equalTo(0));
            jsonBuilder().startObject().startObject("field1").field("lat", 52.20).field("lon", 4.51).endObject().endObject()
            searchResponse.getHits().getAt(1).getFields().get("_percolator_document_slot").getValues(),
            .get();
        assertThat(
                .indices()
                                .startArray("employee")
        assertThat(item.getResponse(), nullValue());
            .execute()
            equalTo(Collections.singletonList(0))
        );
            .get();
                        XContentFactory.jsonBuilder()
                jsonBuilder().startObject()
            .setSource(jsonBuilder().startObject().field("query", rangeQuery("field1").from(10).to(12)).endObject())
                    "query",
        client().admin().indices().prepareRefresh().get();
                        ).dist(3)
        client().prepareIndex("test")
            .setSource(jsonBuilder().startObject().field("query", rangeQuery("field1").from(20).to(22)).endObject())
import java.io.IOException;
                OpenSearchException.class,
        );
                        .endObject()
        assertHitCount(searchResponse, 5);
                    "q",
            .setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON))
        assertSearchHits(item.getResponse(), "2", "4");
        BytesReference document1 = BytesReference.bytes(
        client().prepareIndex("test")
                            "query",
        assertHitCount(response, 1);
            searchResponse.getHits().getAt(0).getFields().get("_percolator_document_slot").getValues(),
                        .endObject()
            .setQuery(
        assertThat(
            jsonBuilder().startObject()
                                .inOrder(true)
            client().admin()
        MultiSearchResponse.Item item = response.getResponses()[0];
            .setSource(
                    .field("query", boolQuery().must(matchQuery("field1", "b")).must(matchQuery("field1", "c")))
            .endObject()
                .prepareCreate("test3")
            .endObject()
import org.apache.lucene.search.join.ScoreMode;
                .prepareCreate("test")
        // Test date range:
                            "employee",
                            .field("name", "virginia potts")
                        BytesReference.bytes(jsonBuilder().startObject().field("field1", "fox").endObject()),
                                .endObject()
            equalTo("<em>dog</em>")
                        )
    public void testPercolatorQueryExistingDocumentSourceDisabled() throws Exception {
            .endObject();
            .setId("7")
        client().prepareIndex("test")
                                .inOrder(true),
            equalTo("The quick brown <em>fox</em> jumps over the lazy dog")
import static org.opensearch.index.query.QueryBuilders.constantScoreQuery;
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));
                    .should(new PercolateQueryBuilder("query", document2, MediaTypeRegistry.JSON).setName("query2"))
    public static Collection<Object[]> parameters() {
                            ScoreMode.Avg
        client().prepareIndex("test")
            equalTo(Collections.singletonList(0))
                            .endObject()
import org.opensearch.common.unit.DistanceUnit;
        );
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("field1", "type=text", "query", "type=percolator"));
                    .endObject()
            searchResponse.getHits().getAt(2).getFields().get("_percolator_document_slot_query2").getValues(),
                            .startObject()
        assertThat(response.getHits().getAt(2).getId(), equalTo("3"));
    protected boolean addMockGeoShapeFieldMapper() {
                    .should(
                            XContentFactory.jsonBuilder()
                .prepareCreate("test")
                    )
            .startObject("companyname")
                            BytesReference.bytes(jsonBuilder().startObject().field("field1", "fox").endObject())
        response = client().prepareSearch()
            equalTo("<em>fox</em>")
                                .addClause(spanTermQuery("field1", "fox"))
                    "type=long",
            .setId("1")
            .addSort("id", SortOrder.ASC)
                        ),
                    )
            client().admin()
                    .setMapping("id", "type=keyword", "field1", "type=keyword", "query", "type=percolator")
            .get();
        }
                        .field("type", "object")
                                .addClause(spanTermQuery("field1", "dog"))
                    MediaTypeRegistry.JSON
            .highlighter(new HighlightBuilder().field("field1"))
                            .must(rangeQuery("field4").from("2010-01-01").to("now"))
        client().prepareIndex("test")
        assertAcked(
                    )
 * Modifications Copyright OpenSearch Contributors. See
            )
import org.opensearch.action.search.MultiSearchResponse;
                            .startObject()
            searchResponse.getHits().getAt(4).getHighlightFields().get("query1_field1").fragments()[0].string(),
            .setId("1")
                    "field1",
            .get();
            equalTo("The quick <em>brown</em> <em>fox</em> jumps")
        client().admin().indices().prepareRefresh().get();
import org.opensearch.core.xcontent.XContentBuilder;
            equalTo("over the <em>lazy</em> <em>dog</em>")
    public void testPercolatorQueryViaMultiSearch() throws Exception {
    public void testPercolatorQuery() throws Exception {
            .setSource(jsonBuilder().startObject().field("id", "2").field("query", matchQuery("field1", "lazy dog")).endObject())
        assertAcked(
        assertThat(searchResponse.getHits().getAt(3).getHighlightFields().get("0_field1").fragments()[0].string(), equalTo("<em>dog</em>"));
        assertThat(
import org.opensearch.index.query.MatchPhraseQueryBuilder;
/*
                            .endArray()
                .setSource(jsonBuilder().startObject().field("id", "1").field("query", matchQuery("field1", "value")).endObject())
        assertHitCount(searchResponse, 5);
                        )
        );
                client().prepareSearch("test") // non existing doc, so error element
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));
            equalTo("The quick brown <em>fox</em> jumps")
        assertSearchHits(response, "10");
        assertThat(
        assertThat(response.getHits().getAt(0).getId(), equalTo("q1"));
        response = client().prepareSearch().setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON)).get();
            .setSource(jsonBuilder().startObject().field("id", "1").field("query", matchAllQuery()).endObject())
                            BytesReference.bytes(jsonBuilder().startObject().field("field1", "b").endObject()),
        );
                        BytesReference.bytes(jsonBuilder().startObject().field("field1", "jumps").endObject()),
        assertThat(
                        spanNearQuery(spanTermQuery("field1", "quick"), 0).addClause(spanTermQuery("field1", "brown"))
        response = client().prepareSearch()
        response = client().prepareSearch("test")
/*
            .startObject("properties")
            .field("type", "nested")
        assertThat(
            .add(
        assertSearchHits(response, "4");
            .get();
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            equalTo(Arrays.asList(1, 3))
        client().prepareIndex("test").setId("6").setSource(MediaTypeRegistry.JSON, "id", "6", "field1", "value", "field2", "value").get();
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", (String) null));
            .field("type", "percolator")
        );
import static org.opensearch.index.query.QueryBuilders.rangeQuery;
            .execute()
                    .field("id", 3)
        );
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        response = client().prepareSearch().setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON)).get();
            )
        client().prepareIndex("test").setId("5").setSource(MediaTypeRegistry.JSON, "id", "5", "field1", "value").get();
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));
                new PercolateQueryBuilder(
            .setId("3")
        );
        client().prepareIndex("test")
package org.opensearch.percolator;
                                .field("companyname", "stark")
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
            )
        client().prepareIndex("test").setId("2").setSource("{}", MediaTypeRegistry.JSON).get();
        // Unacceptable:
        BytesReference document = BytesReference.bytes(
                            .field("name", "tony stark")
        assertHitCount(item.getResponse(), 4L);
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));
            )
            searchResponse.getHits().getAt(2).getHighlightFields().get("query2_0_field1").fragments()[0].string(),
                    "query",
                .get();
            searchResponse.getHits().getAt(2).getFields().get("_percolator_document_slot").getValues(),
                            .field("companyname", "notstark")
        );
        logger.info("percolating doc with 1 field");
            .setQuery(
        SearchResponse response = client().prepareSearch()
        logger.info("percolating doc with 2 fields");
            .get();
        response = client().prepareSearch()
        logger.info("percolating doc with 1 field");
            .get();
        assertThat(
                            .endObject()
import static org.opensearch.index.query.QueryBuilders.boolQuery;
                        boolQuery().must(rangeQuery("field4").from("2010-01-01").to("2018-01-01"))
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
        assertThat(item.getFailureMessage(), nullValue());
                                BytesReference.bytes(jsonBuilder().startObject().field("field1", "jumps").endObject()),
            .get();
 */
        assertThat(item.getFailureMessage(), nullValue());
                            MediaTypeRegistry.JSON
                                .endObject()
            equalTo("<em>dog</em>")
                boolQuery().should(new PercolateQueryBuilder("query", document1, MediaTypeRegistry.JSON).setName("query1"))
        );
        assertThat(response.getHits().getAt(3).getId(), equalTo("4"));
                    ),
        assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));
                        "query",
        SearchResponse response = client().prepareSearch()
                        "query",
                        BytesReference.bytes(jsonBuilder().startObject().field("field1", "brown fox").endObject())
            .addSort("id", SortOrder.ASC)
                    )
import org.opensearch.common.geo.GeoPoint;
        assertThat(
                .setMapping(
        logger.info("percolating empty doc");
            .setSource(
                                .startObject()
        client().prepareIndex("test").setId("4").setSource("{\"id\": \"4\"}", MediaTypeRegistry.JSON).get();
            .get();
                .get();
        try {
                        .endObject()
    public void testPercolatorQueryExistingDocument() throws Exception {
        );
                    MediaTypeRegistry.JSON
                    .field("id", "1")
                            .field("name", "tony stark")
            .execute()
                        .startObject("properties")
        client().prepareIndex("test")
import static org.opensearch.index.query.QueryBuilders.multiMatchQuery;
        assertAcked(
            )
        assertThat(
            .setId("2")
            assertThat(response.getHits().getAt(0).getFields().get("_percolator_document_slot").getValue(), equalTo(0));
        assertThat(response.getHits().getAt(0).getId(), equalTo("q3"));
            searchResponse.getHits().getAt(0).getHighlightFields().get("field1").fragments()[0].string(),
        );
            client().admin()
            .actionGet();
                jsonBuilder().startObject()
        assertHitCount(response, 1);
            assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
            client().admin().indices().prepareCreate("test1").setMapping(queryFieldName, "type=percolator", "field", "type=keyword")
                        XContentFactory.jsonBuilder()
                    "field4",
        assertThat(
            client().admin()
                    BytesReference.bytes(jsonBuilder().startObject().field("d", "2020-02-01T15:00:00.000+11:00").endObject()),
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        );
        assertThat(response.getHits().getAt(0).getFields().get("_percolator_document_slot").getValue(), equalTo(0));
        );
                .prepareCreate("test2")
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("d", "type=date", "q", "type=percolator"));
        response = client().prepareSearch()
            .setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON))
                jsonBuilder().startObject()
                    "q",
        assertThat(response.getHits().getAt(0).getFields().get("_percolator_document_slot").getValue(), equalTo(0));
                new PercolateQueryBuilder(
        SearchResponse searchResponse = client().prepareSearch()
            .get();
        assertThat(
                new PercolateQueryBuilder(
            client().prepareIndex("test")
            .execute()
            .setId("1")
        client().prepareIndex("test")
        assertHitCount(searchResponse, 5);
    public void testPercolatorQueryWithHighlighting() throws Exception {
        assertEquals(1, response.getHits().getTotalHits().value());
        String queryFieldName = randomAlphaOfLength(8);
        client().prepareIndex("test")
import static org.hamcrest.Matchers.nullValue;
            .addSort("_doc", SortOrder.ASC)
                        .field(queryFieldName, matchQuery("field", "value"))
                    MediaTypeRegistry.JSON
            )
    }
import org.opensearch.core.common.bytes.BytesReference;
                    )
    }
        assertAcked(
            .get();
                        BytesReference.bytes(jsonBuilder().startObject().field("field1", "value").endObject()),
                    .endObject()
    }
                            "query",
            .setQuery(
        client().prepareIndex("test")
                        )
            .setQuery(new PercolateQueryBuilder("query", document, MediaTypeRegistry.JSON))
                    .field(
            .addSort("id", SortOrder.ASC)
                        .field("type", "keyword")
        assertThat(e.getCause().getMessage(), equalTo("a document can only contain one percolator query"));
                        ),
            .setId("1")
            .field("type", "text")
                .prepareCreate("test")
                .indices()
        assertThat(
                .prepareCreate("test2")
import org.opensearch.common.xcontent.XContentFactory;
                client().prepareSearch("test")
        item = response.getResponses()[1];
            assertHitCount(response, 1);
    }
import static org.opensearch.index.query.QueryBuilders.termQuery;
            jsonBuilder().startObject().field("field1", "The quick brown fox jumps over the lazy dog").endObject()
                                .field("name", "tony stark")
            .setSource(jsonBuilder().startObject().field("query", rangeQuery("field2").from(10).to(12)).endObject())
            .setSource(jsonBuilder().startObject().field("q", boolQuery().must(rangeQuery("d").gt("now"))).endObject())
        assertHitCount(response, 2);
            searchResponse.getHits().getAt(0).getFields().get("_percolator_document_slot_query2").getValues(),
        client().prepareIndex("test")
        item = response.getResponses()[3];
        assertSearchHits(response, "9", "7");
            .addSort("id", SortOrder.ASC)
        client().prepareIndex("test")
                    "field3",
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to
            .setQuery(
            .setId("2")
    }
            .addSort("id", SortOrder.ASC)
            .setSource(
                            .endObject()
import static org.opensearch.index.query.QueryBuilders.spanTermQuery;
                            ),
        SearchResponse response = client().prepareSearch("test")
            refresh();
            .setId("2")
            .setId("4")
        );
                () -> client().prepareSearch().setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON)).get()
        assertHitCount(response, 3);
                )
                            spanNearQuery(spanTermQuery("field1", "the"), 0).addClause(spanTermQuery("field1", "lazy"))
        client().prepareIndex("test")
            .setSource(jsonBuilder().startObject().field("id", 1).field("query", commonTermsQuery("field1", "quick brown fox")).endObject())
        assertThat(
            .setSource(
        client().prepareIndex("test2")
                    BytesReference.bytes(jsonBuilder().startObject().field("d", "2020-02-01T15:00:00.000+11:00").endObject()),
    }
        searchResponse = client().prepareSearch()
                        "query",
                    .field("id", 4)
                )
        );
            .setSource(jsonBuilder().startObject().field("id", "4").field("query", termQuery("field1", "dog")).endObject())
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("companyname", "notstark").endObject()),
            )
        client().prepareIndex("test")
                            spanNearQuery(spanTermQuery("field1", "quick"), 0).addClause(spanTermQuery("field1", "brown"))
        assertThat(response.getHits().getAt(2).getFields().get("_percolator_document_slot").getValue(), equalTo(0));
                    ),
                        BytesReference.bytes(jsonBuilder().startObject().field("field1", "value").field("field2", "value").endObject())
import org.opensearch.search.sort.SortOrder;
                    .setQuery(
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                e.getCause().getMessage()
        assertHitCount(response, 1);
        source = BytesReference.bytes(jsonBuilder().startObject().field("field2", 11).endObject());
                .prepareCreate("test")
                        "query",
            .setSource(jsonBuilder().startObject().field("q", boolQuery().must(rangeQuery("d").lt("now"))).endObject())
import static org.hamcrest.core.IsNull.notNullValue;
                            BytesReference.bytes(yamlBuilder().startObject().field("field1", "c").endObject()),
            .endObject()
        assertThat(response.getHits().getAt(1).getFields().get("_percolator_document_slot").getValues(), equalTo(Arrays.asList(0, 1)));
                                .field("name", "peter parker")
        assertHitCount(response, 1);
        assertThat(response.getHits().getAt(0).getFields().get("_percolator_document_slot").getValues(), equalTo(Arrays.asList(0, 1)));
            .get();
            searchResponse.getHits().getAt(4).getHighlightFields().get("3_field1").fragments()[0].string(),
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        client().prepareIndex("test")
import java.util.Arrays;
                .prepareCreate("test")
            .setId("5")
            .get();
                        .startArray("object_field")
                                .field("companyname", "stark")
            searchResponse.getHits().getAt(4).getHighlightFields().get("field1").fragments()[0].string(),
        );
            .field("type", "text")
                                .endObject()
        assertThat(item.getFailureMessage(), containsString("[test/6] couldn't be found"));
            .setQuery(new PercolateQueryBuilder("query", "test", "6", null, null, null))
            .setSource(jsonBuilder().startObject().field("id", "2").field("query", matchQuery("field1", "value")).endObject())
            equalTo(Arrays.asList(1, 3))
                .indices()
                        "q",
        client().prepareIndex("test")
            .add(client().prepareSearch("test").setQuery(new PercolateQueryBuilder("query", "test", "5", null, null, null)))
        assertThat(
            equalTo("<em>jumps</em>")
import static org.hamcrest.Matchers.containsString;
        assertThat(
            equalTo("<em>jumps</em>")
                            .inOrder(true)
        assertHitCount(item.getResponse(), 2L);
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                    .endObject()
            .endObject()
            .get();
            .setSource(jsonBuilder().startObject().field("query", matchAllQuery()).endObject())
        );
            SearchResponse response = client().prepareSearch()
        source = BytesReference.bytes(jsonBuilder().startObject().field("field3", "192.168.1.4").endObject());
        assertThat(response.getHits().getAt(0).getId(), equalTo("q1"));
                jsonBuilder().startObject()
import static org.opensearch.common.xcontent.XContentFactory.yamlBuilder;
                            spanNearQuery(spanTermQuery("field1", "quick"), 0).addClause(spanTermQuery("field1", "brown"))
            .setId("q1")
            client().prepareSearch().setQuery(new PercolateQueryBuilder("query", "test", "1", null, null, null)).get();
        assertThat(
        assertHitCount(response, 3);
        assertSearchHits(response, "1");
                    .field("query", geoDistanceQuery("field1").point(52.18, 4.38).distance(50, DistanceUnit.KILOMETERS))
        );
        searchResponse = client().prepareSearch()
            equalTo("<em>brown</em> <em>fox</em>")
                        .startObject("object_field")
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
            equalTo("over the lazy <em>dog</em>")
    }
        assertSearchHits(item.getResponse(), "1", "2", "3", "4");
                        )
            .setId("1")
        assertHitCount(response, 1);
        );
            searchResponse.getHits().getAt(3).getFields().get("_percolator_document_slot_query1").getValues(),
        SearchResponse response = client().prepareSearch()
        );
        assertAcked(
                                .endObject()
        assertThat(
            .setId("q2")
            .setId("5")
        // Acceptable:
                    "query",
        return false;
        assertSearchHits(response, "6", "4");
                        .startObject("field")
            .get();
            .setId("4")
        response = client().prepareSearch().setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON)).get();
        client().admin().indices().prepareRefresh().get();
            )
                    .setQuery(
            )
                                .endObject()
                    .field("id", "3")
            .setId("5")
            .get();
            .setId("3")
            );
                    .field(
            .get();
                    .endObject()
        );
                    ),
        assertAcked(
                        .endObject()
                    .setQuery(new PercolateQueryBuilder("query", "test", "6", null, null, null))
