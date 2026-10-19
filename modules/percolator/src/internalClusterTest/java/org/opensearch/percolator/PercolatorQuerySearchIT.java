                                .startArray("employee")
                    .endObject()
                    BytesReference.bytes(
        assertAcked(client().admin().indices().prepareCreate("test").setMapping(mapping));
            .setSource(jsonBuilder().startObject().field("query", new MatchPhraseQueryBuilder("field", "brown fox").slop(5)).endObject())
            .setId("2")
                    ),
            .get();
            .setId("8")
            .setSource(jsonBuilder().startObject().field("id", "1").field("query", matchAllQuery()).endObject())
                OpenSearchException.class,
            .startObject("companyname")  
                boolQuery().should(new PercolateQueryBuilder("query", document1, MediaTypeRegistry.JSON).setName("query1"))  
            .setId("1")
            .addSort("id", SortOrder.ASC)
                            .field("name", "tony stark")
            .setSource(jsonBuilder().startObject().field("query", matchQuery("field1", "c")).endObject())
import java.io.IOException;  
                client().prepareSearch("test")
            .actionGet();
                new PercolateQueryBuilder(
        );
                                .startObject()
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
 * this file be licensed under the Apache-2.0 license or a
            )
                        .field("type", "percolator")  
                .endObject()
            .addSort("id", SortOrder.ASC)
            .startObject("query")  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                        ),  
        // doesn't match  
                        .endObject()
            .setId("1")  
            .actionGet();
                    .field("query", boolQuery().must(matchQuery("field1", "value")).must(matchQuery("field2", "value")))  
        assertThat(  
                        .startObject(queryFieldName)  
                                .field("companyname", "stark")
                                .startArray("employee")  
        assertHitCount(response, 2);  
                    Arrays.asList(
                new PercolateQueryBuilder(  
        client().prepareIndex("test")
                .indices()
                        .endObject()
                            BytesReference.bytes(jsonBuilder().startObject().field("field1", "b").endObject()),
            .setSource(jsonBuilder().startObject().field("query", matchAllQuery()).endObject())  
            searchResponse.getHits().getAt(4).getHighlightFields().get("query1_1_field1").fragments()[0].string(),  
            .setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON))
                    BytesReference.bytes(jsonBuilder().startObject().field("d", "2020-02-01T15:00:00.000+11:00").endObject()),  
            .get();
        client().prepareIndex("test")
        client().prepareIndex("test")
            )  
}  
                        .endObject()
            .highlighter(new HighlightBuilder().field("field1"))
            .setSource(jsonBuilder().startObject().field("id", "2").field("query", matchQuery("field1", "lazy dog")).endObject())  
        BytesReference document = BytesReference.bytes(
 * ownership. Elasticsearch licenses this file to you under  
        client().prepareIndex("test")
            .setSource(
        client().admin().indices().prepareRefresh().get();  
        assertHitCount(response, 4);
            .field("type", "keyword")
        assertHitCount(response, 1);  
                        MediaTypeRegistry.JSON
            );
                            .field("name", "tony stark")
            client().admin()  
        );
        response = client().prepareSearch().setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON)).get();
        client().prepareIndex("test")
            client().admin()
        response = client().prepareSearch()  
            .setIndices("test1")
            )
            client().admin()  
import static org.opensearch.index.query.QueryBuilders.multiMatchQuery;  
            .setId("3")
                            ),  
        assertThat(response.getHits().getAt(1).getId(), equalTo("q3"));
            jsonBuilder().startObject().field("field1", "The quick brown fox jumps over the lazy dog").endObject()  
        } else if (randomBoolean()) {
            .setSource(jsonBuilder().startObject().field("field1", "c").endObject())
            .get();
                        BytesReference.bytes(jsonBuilder().startObject().field("field1", "value").field("field2", "value").endObject())  
                    Arrays.asList(
            .add(client().prepareSearch("test").setQuery(new PercolateQueryBuilder("query", "test", "5", null, null, null)))  
import static org.hamcrest.core.IsNull.notNullValue;
            .addSort("id", SortOrder.ASC)  
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));  
        assertHitCount(response, 2);  
            .get();
                    )  
                                .endObject()
        source = BytesReference.bytes(jsonBuilder().startObject().field("field3", "192.168.1.4").endObject());
        response = client().prepareSearch()  
            .actionGet();
        );  
            equalTo("The quick brown fox jumps over the <em>lazy</em> <em>dog</em>")  
            searchResponse.getHits().getAt(0).getHighlightFields().get("query1_field1").fragments()[0].string(),
 */
        );  
            .get();
            .setId("5")
        assertSearchHits(item.getResponse(), "2", "4");
            .setId("2")  
            client().admin()
                jsonBuilder().startObject()
                            XContentFactory.jsonBuilder()  
            .addSort("id", SortOrder.ASC)
    public void testPercolatorRangeQueries() throws Exception {
            .get();
            BytesReference source = BytesReference.bytes(jsonBuilder().startObject().field("field1", "value").endObject());  
            .setId("1")
            equalTo("<em>fox</em>")
                client().prepareSearch("test")  
                                .endObject()  
import org.opensearch.core.xcontent.XContentBuilder;  
        assertAcked(
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
            .setId("1")
            .get();  
                        QueryBuilders.nestedQuery(  
                .field("field2", "the quick brown fox falls down into the well")
        response = client().prepareSearch().setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON)).get();
        );
                    BytesReference.bytes(jsonBuilder().startObject().field("d", "2020-02-01T15:00:00.000+11:00").endObject()),
        XContentBuilder mapping = XContentFactory.jsonBuilder();  
        assertAcked(
            .setQuery(
        assertHitCount(response, 3);
                    .endObject()  
        // Unacceptable:
                    jsonBuilder().startObject()  
        assertThat(
        response = client().prepareSearch()  
                                .endObject()
            .actionGet();  
                .setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON))
                            MediaTypeRegistry.JSON
            )
            .setId("1")
            .endObject()
                    .endObject()
                jsonBuilder().startObject()  
        );  
        client().prepareIndex("test")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;  
        );  
            updateSettingsRequest = new ClusterUpdateSettingsRequest();
                            BytesReference.bytes(jsonBuilder().startObject().field("field1", "fox").endObject())
            searchResponse.getHits().getAt(0).getFields().get("_percolator_document_slot_query2").getValues(),  
            equalTo(Arrays.asList(1, 3))
            .execute()
                jsonBuilder().startObject()  
            equalTo(Collections.singletonList(0))
        assertThat(response.getHits().getAt(2).getScore(), equalTo(Float.NaN));
                    "query",
            )
import org.opensearch.index.query.Operator;
    public void testTakePositionOffsetGapIntoAccount() throws Exception {  
            )
        client().prepareIndex("test")
        assertHitCount(response, 1);  
                .indices()  
                .setId("1")
            .setId("q3")
                        BytesReference.bytes(jsonBuilder().startObject().field("field1", "value").endObject()),
 * Modifications Copyright OpenSearch Contributors. See  
                )
        response = client().prepareSearch("test")
            client().admin()
            client().admin()  
            )  
                            .startObject()  
        );
            )
            assertEquals(
        client().prepareIndex("test")
import org.opensearch.index.query.MultiMatchQueryBuilder;
            .setId("3")
                        "query",  
        response = client().prepareSearch().setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON)).get();
        client().prepareIndex("test")  
                new PercolateQueryBuilder(
                    .field("id", "3")
 * software distributed under the License is distributed on an
        client().prepareIndex("test")
            searchResponse.getHits().getAt(4).getHighlightFields().get("query1_field1").fragments()[0].string(),
                                .field("name", "peter parker")
                .get();
                    .field(  
                .setMapping("id", "type=keyword", "field1", "type=keyword", "field2", "type=keyword", "query", "type=percolator")
                            spanNearQuery(spanTermQuery("field1", "quick"), 0).addClause(spanTermQuery("field1", "brown"))  
            .setQuery(
            equalTo("<em>jumps</em>")  
            .setQuery(
import static org.opensearch.index.query.QueryBuilders.spanNearQuery;
        logger.info("percolating empty doc with source disabled");
                )
            equalTo("over the <em>lazy</em> <em>dog</em>")  
        BytesReference source = BytesReference.bytes(jsonBuilder().startObject().field("field", "value").endObject());
                            XContentFactory.jsonBuilder()
                    "type=ip",  
        SearchResponse response = client().prepareSearch("test")
            .setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON))  
                        boolQuery().must(rangeQuery("field4").from("2010-01-01").to("2018-01-01"))
            .setSource(  
        assertAcked(
            searchResponse.getHits().getAt(0).getHighlightFields().get("3_field1").fragments()[0].string(),
                            .endArray()  
        });  
                    .field("id", 4)
                    .field("query", geoDistanceQuery("field1").point(52.18, 4.38).distance(50, DistanceUnit.KILOMETERS))
            // Set search.allow_expensive_queries to "false" => assert failure
        assertThat(item.getFailureMessage(), nullValue());  
                )
        refresh();  
    public void testManyPercolatorFields() throws Exception {  
        );  
                        BytesReference.bytes(jsonBuilder().startObject().field("field1", "jumps").endObject()),
                    "q",
        assertThat(item.getFailureMessage(), containsString("[test/6] couldn't be found"));
                            Arrays.asList(  
                            .endObject()
                                .startObject()
                        BytesReference.bytes(jsonBuilder().startObject().field("field1", "brown fox").endObject())
import java.util.Collections;  
            .endObject()
            .add(  
import org.opensearch.common.xcontent.XContentFactory;
                    MediaTypeRegistry.JSON
            .get();
        );
            searchResponse.getHits().getAt(0).getFields().get("_percolator_document_slot_query1").getValues(),
                    "field2",  
import org.opensearch.search.sort.SortOrder;  
                jsonBuilder().startObject()
        item = response.getResponses()[4];  
                    jsonBuilder().startObject()  
                        "query",
            .get();
            equalTo(Collections.singletonList(0))
            assertThat(response.getHits().getAt(0).getFields().get("_percolator_document_slot").getValue(), equalTo(0));  
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));  
            )
                .indices()
            .actionGet();  
                        .startObject("properties")
        SearchResponse response = client().prepareSearch()  
            .actionGet();
                        .startObject()
                    .field("id", "3")
                .get();  
                jsonBuilder().startObject()
        );
    protected boolean addMockGeoShapeFieldMapper() {
 */
                    MediaTypeRegistry.JSON
        // Test date range:
        assertThat(
            .setQuery(  
        source = BytesReference.bytes(jsonBuilder().startObject().field("field3", "192.168.1.5").endObject());  
            .get();  
                        spanNotQuery(
        assertThat(
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        client().prepareIndex("test1")
        response = client().prepareSearch()  
        return Arrays.asList(  
            .setSource(  
                .setMapping("id", "type=keyword", "field1", "type=text", "field2", "type=text", "query", "type=percolator")
            .setId("2")  
            searchResponse.getHits().getAt(1).getFields().get("_percolator_document_slot_query1").getValues(),
                            QueryBuilders.matchQuery("employee.name", "virginia potts").operator(Operator.AND),
            .setQuery(  
            .setId("4")
        response = client().prepareSearch().setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON)).get();
            )  
                )  
        source = BytesReference.bytes(jsonBuilder().startObject().field("field4", "2016-05-15").endObject());
            .setQuery(new PercolateQueryBuilder(queryFieldName, source, MediaTypeRegistry.JSON))
                        "query",
            .setSource(jsonBuilder().startObject().field("id", "2").field("query", matchQuery("field1", "value")).endObject())  
                    MediaTypeRegistry.JSON
                .prepareCreate("test2")
        client().prepareIndex("test")  
                        new PercolateQueryBuilder(
            assertAcked(
                jsonBuilder().startObject()
        client().admin().indices().prepareRefresh().get();  
                        )
                    "field1",
                    MediaTypeRegistry.JSON  
 * license agreements. See the NOTICE file distributed with
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
        );
        assertSearchHits(response, "10");
                        .endObject()
            .startObject("employee")  
import org.opensearch.core.common.bytes.BytesArray;  
            // Execute with search.allow_expensive_queries = null => default value = false => success
            )
            equalTo("brown <em>fox</em>")  
                    ).setName("query1")
        searchResponse = client().prepareSearch()  
            .get();
        assertThat(
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", false));
        client().prepareIndex("test").setId("1").setSource(jsonBuilder().startObject().field("query", matchAllQuery()).endObject()).get();  
        assertHitCount(response, 1);
                            .startObject()  
            .add(
            )
                            spanNearQuery(spanTermQuery("field1", "the"), 0).addClause(spanTermQuery("field1", "lazy"))  
                        .startObject("properties")
            )
import org.opensearch.index.query.MatchPhraseQueryBuilder;  
                        spanNotQuery(
            client().admin()
            .setId("2")
        assertThat(
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {  
            )  
        );
            .get();
        assertThat(response.getHits().getAt(1).getFields().get("_percolator_document_slot").getValues(), equalTo(Arrays.asList(0, 1)));
                    .field(queryFieldName, matchQuery("field", "value"))
                        ),
        assertThat(searchResponse.getHits().getAt(0).getHighlightFields().get("1_field1").fragments()[0].string(), equalTo("<em>fox</em>"));  
        assertThat(response.getHits().getAt(2).getId(), equalTo("3"));  
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));
                .setMapping("field", "type=text,position_increment_gap=5", "query", "type=percolator")
        client().prepareIndex("test")  
 *
            .actionGet();
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("d", "type=date", "q", "type=percolator"));
                    .endObject()  
                                .inOrder(true),
        assertThat(response.getHits().getAt(2).getFields().get("_percolator_document_slot").getValue(), equalTo(0));  
        logger.info("percolating empty doc");
            .setId("3")
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));  
        assertThat(response.getHits().getAt(3).getId(), equalTo("4"));  
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));
                        Arrays.asList(
        assertHitCount(item.getResponse(), 4L);  
        assertThat(response.getHits().getAt(1).getFields().get("_percolator_document_slot").getValue(), equalTo(0));
                    .field("id", 5)
 *
            .setSource(jsonBuilder().startObject().field(queryFieldName, matchQuery("field", "value")).endObject())  
        assertHitCount(response, 1);
        SearchResponse response = client().prepareSearch()
                                .field("name", "virginia potts")
        assertThat(  
        source = BytesReference.bytes(jsonBuilder().startObject().field("field1", 11).endObject());
                        .startObject("object_field")
            .setId("1")  
            .field("type", "nested")
                    .field("query", boolQuery().must(rangeQuery("field1").from(10).to(12)).must(rangeQuery("field1").from(12).to(14)))
            jsonBuilder().startObject().startObject("field1").field("lat", 52.20).field("lon", 4.51).endObject().endObject()  
            .get();
        assertThat(
            .addSort("id", SortOrder.ASC)
                    ),
        client().prepareIndex("test")  
            .setId("1")
                    Arrays.asList(
                    )  
        assertThat(
            equalTo(Collections.singletonList(0))
            .startObject("properties")
        assertThat(  
            .execute()
                                .field("name", "virginia potts")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                                .endObject()
        client().prepareIndex("test")
        );
                    )
 * KIND, either express or implied.  See the License for the
        BytesReference document1 = BytesReference.bytes(  
            .setId("5")
            .setSource(  
            .get();
                    .endObject()  
        assertHitCount(response, 1);
                .setMapping("_source", "enabled=false", "field1", "type=keyword", "query", "type=percolator")  
                jsonBuilder().startObject()
import org.opensearch.core.xcontent.MediaTypeRegistry;
        // Test double range:  
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
            .setId("5")
    public void testPercolatorGeoQueries() throws Exception {
                        .endArray()
import static org.hamcrest.Matchers.containsString;
        assertHitCount(searchResponse, 5);
            equalTo(Collections.singletonList(0))
                            .endObject()
                    .endObject()
        client().prepareIndex("test2")
                .indices()  
            .endObject()
        // Test long range:
import org.opensearch.common.settings.Settings;
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> {
                jsonBuilder().startObject()  
 * this work for additional information regarding copyright
            .execute()  
            .get();
        source = BytesReference.bytes(jsonBuilder().startObject().field("field2", 12).endObject());
                                .addClause(spanTermQuery("field1", "fox"))
        assertAcked(  
            .setId("2")
import static org.hamcrest.Matchers.instanceOf;  
                        "query",
            .setSource(jsonBuilder().startObject().field("id", "4").field("query", termQuery("field1", "dog")).endObject())
            .get();
            )  
        client().prepareIndex("test")
                    .field(  
        client().admin().indices().prepareRefresh().get();
                        .endObject()  
import static org.opensearch.index.query.QueryBuilders.spanTermQuery;
                    "query",  
                            BytesReference.bytes(jsonBuilder().startObject().field("field1", "dog").endObject()),  
        );
            .get();
            .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                            .addClause(spanTermQuery("field1", "fox"))
                                .startObject()
                        ).dist(2)  
            .addSort("id", SortOrder.ASC)  
        assertThat(response.getHits().getAt(1).getFields().get("_percolator_document_slot").getValues(), equalTo(Arrays.asList(0, 1, 2)));  
                    )
            client().admin().indices().prepareCreate("test1").setMapping(queryFieldName, "type=percolator", "field", "type=keyword")  
            .setId("9")  
                    .endObject()
        client().prepareIndex("test")
            searchResponse.getHits().getAt(4).getFields().get("_percolator_document_slot_query1").getValues(),
        SearchResponse response = client().prepareSearch()  
            equalTo("<em>dog</em>")  
                    )
            equalTo(Collections.singletonList(1))  
            equalTo("<em>brown</em> <em>fox</em>")  
            .setSource(jsonBuilder().startObject().field("id", "2").field("query", matchQuery("field1", "value")).endObject())
            .addSort("id", SortOrder.ASC)
        client().admin().indices().prepareRefresh().get();
                        new PercolateQueryBuilder(  
            .actionGet();
        );
        client().prepareIndex("test")  
                        new PercolateQueryBuilder(
                        .field("type", "percolator")
                            .must(rangeQuery("field4").from("2010-01-01").to("now"))  
            .setId("3")
            .endObject()  
                        .startObject("object_field")  
            client().prepareIndex("test")
        source = BytesReference.bytes(jsonBuilder().startObject().field("field1", "value").endObject());  
            searchResponse.getHits().getAt(3).getFields().get("_percolator_document_slot_query1").getValues(),
 * compatible open source license.
        assertThat(response.getHits().getAt(2).getId(), equalTo("3"));
            .actionGet();  
            .setId("4")  
    }
            .add(
                        .field(queryFieldName, matchQuery("field", "value"))  
            .setSource(jsonBuilder().startObject().field("id", "q3").field("query", QueryBuilders.matchAllQuery()).endObject())
        );
                    "field3",
            .get();
        SearchResponse response = client().prepareSearch()
        );
                            .endArray()  
                    .field("id", "q1")  
                        "query",
            )  
        response = client().prepareSearch()
            .setId("2")
                            .startObject()  
import static org.opensearch.index.query.QueryBuilders.termQuery;
                        new PercolateQueryBuilder(
        client().prepareIndex("test")
        assertSearchHits(item.getResponse(), "4");  
            .setId("10")  
                                BytesReference.bytes(jsonBuilder().startObject().field("field1", "brown fox").endObject())
                .setMapping("id", "type=keyword", "field1", "type=geo_point", "field2", "type=geo_shape", "query", "type=percolator")
    public void testPercolatorQuery() throws Exception {
                )
            .addSort("id", SortOrder.ASC)
                        )
        assertThat(item.getFailureMessage(), nullValue());
        try {  
            .setSource(
    }  
        mapping.startObject()
            .setId("1")  
                            .startArray("employee")
        response = client().prepareSearch()
        );  
                    "q",
                    MediaTypeRegistry.JSON  
                    .field(  
        item = response.getResponses()[3];
        client().admin().indices().prepareRefresh().get();
                            MediaTypeRegistry.JSON
        client().prepareIndex("test")
        return false;
                    .should(  
                                .startObject()  
                .prepareCreate("test")
                        .endObject()
        logger.info("percolating doc with 2 fields");
        assertThat(
                        .field(queryFieldName, matchQuery("field", "value"))  
                client().admin()
        }
            equalTo(Collections.singletonList(0))
            .setQuery(new PercolateQueryBuilder("query", "test", "5", null, null, null))
        assertSearchHits(item.getResponse(), "1", "4");  
        assertEquals(1, response.getHits().getTotalHits().value());
                            .field("companyname", "stark")
                    MediaTypeRegistry.JSON
        assertHitCount(item.getResponse(), 1L);
            .get();
            .add(
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("companyname", "notstark").endObject()),  
        assertThat(item.getFailureMessage(), nullValue());
            .addSort("id", SortOrder.ASC)  
                                BytesReference.bytes(jsonBuilder().startObject().field("field1", "jumps").endObject()),
            )
            .get();
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("field1", "type=text", "query", "type=percolator"));
                () -> client().prepareSearch().setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON)).get()  
            .setId("1")
                            .startArray("employee")
import static org.opensearch.index.query.QueryBuilders.geoPolygonQuery;  
import static org.hamcrest.Matchers.equalTo;
        assertThat(  
import static org.opensearch.index.query.QueryBuilders.geoBoundingBoxQuery;
                        "query",
                    .indices()  
                            .field("name", "virginia potts")
            .setId("3")
                    .field(
                        .startObject()
            );  
        assertThat(response.getHits().getAt(2).getFields().get("_percolator_document_slot").getValues(), equalTo(Arrays.asList(1)));
        client().prepareIndex("test")
            )
 * GitHub history for details.
        SearchResponse response = client().prepareSearch()
            searchResponse.getHits().getAt(3).getHighlightFields().get("query2_field1").fragments()[0].string(),
            .setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON))
        assertHitCount(response, 2);
            .highlighter(new HighlightBuilder().field("field1"))
        assertThat(response.getHits().getAt(0).getIndex(), equalTo("test2"));
 * You may obtain a copy of the License at  
            .setQuery(
                        .startObject("field")  
        SearchResponse response = client().prepareSearch()
    }
        );
                                .endArray()
        }
    @Override
                .prepareCreate("test")  
                    new PercolateQueryBuilder(  
                    ),
                .get();
                .indices()
            searchResponse.getHits().getAt(3).getHighlightFields().get("field1").fragments()[0].string(),
                                .field("name", "tony stark")
        String queryFieldName = randomAlphaOfLength(8);  
        client().prepareIndex("test")  
                    "field4",
import org.opensearch.common.unit.DistanceUnit;  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
                client().prepareSearch("test")  
                        XContentFactory.jsonBuilder()
        assertThat(
                        .endObject()
                        BytesReference.bytes(jsonBuilder().startObject().field("field1", "fox").endObject()),  
                                .endObject()
                .indices()
        SearchResponse response = client().prepareSearch()  
            )  
            searchResponse.getHits().getAt(4).getHighlightFields().get("query2_1_field1").fragments()[0].string(),
                        "query",
import java.util.Collection;
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
        super(staticSettings);
                    BytesReference.bytes(
                            .startObject()  
        assertAcked(
            fieldMapping.append(",term_vector=with_positions_offsets");
            searchResponse.getHits().getAt(0).getHighlightFields().get("field1").fragments()[0].string(),
                    "query",  
                        )
                                .endObject()  
            searchResponse.getHits().getAt(1).getHighlightFields().get("query2_field1").fragments()[0].string(),
            assertThat(response.getHits().getAt(0).getFields().get("_percolator_document_slot").getValue(), equalTo(0));  
                                .endObject()
            .get();
            client().admin().indices().prepareCreate("test1").setMapping(queryFieldName, "type=percolator", "field", "type=keyword")
        assertAcked(
                        .endObject()  
        assertThat(
    @Override  
        assertHitCount(response, 2);
                new PercolateQueryBuilder(
                    "query",  
package org.opensearch.percolator;
                )
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        assertThat(
        assertThat(response.getHits().getAt(0).getIndex(), equalTo("test1"));  
            .setId("5")  
        assertThat(  
                jsonBuilder().startObject()
    public PercolatorQuerySearchIT(Settings staticSettings) {  
            .setQuery(new PercolateQueryBuilder("query", document, MediaTypeRegistry.JSON))  
            .add(
            .setSource(jsonBuilder().startObject().field("q", boolQuery().must(rangeQuery("d").lt("now"))).endObject())
import org.opensearch.action.search.MultiSearchResponse;
        assertThat(response.getHits().getAt(3).getScore(), equalTo(Float.NaN));
                "[percolate] queries cannot be executed when 'search.allow_expensive_queries' is set to false.",  
        );  
                                .startObject()  
            assertHitCount(response, 1);
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            .setId("4")
                client().prepareSearch("test")
                        .field("type", "keyword")  
            .addSort("id", SortOrder.ASC)  
        client().prepareIndex("test")  
                .indices()  
            .endObject()
            .execute()
        assertThat(item.getFailureMessage(), nullValue());
            .setQuery(
            searchResponse.getHits().getAt(4).getHighlightFields().get("field1").fragments()[0].string(),
        response = client().prepareSearch()
import static org.opensearch.common.xcontent.XContentFactory.yamlBuilder;  
                    "type=percolator"
                                .addClause(spanTermQuery("field1", "dog"))
        assertHitCount(searchResponse, 5);
        );
            .setId("7")
                    .field(  
        assertHitCount(searchResponse, 5);  
            .execute()
            fieldMapping.append(",index_options=offsets");  
        client().admin().indices().prepareRefresh().get();
                    .endObject()
                jsonBuilder().startObject()
        client().admin().indices().prepareRefresh().get();
                            spanNearQuery(spanTermQuery("field1", "the"), 0).addClause(spanTermQuery("field1", "lazy"))  
                            XContentType.YAML  
                        "q",
        assertThat(
            response = client().prepareSearch().setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON)).get();  
        assertThat(response.getHits().getAt(2).getId(), equalTo("3"));
                        .startArray("object_field")
        assertSearchHits(item.getResponse(), "2", "4");
            equalTo("over the lazy <em>dog</em>")
 *    http://www.apache.org/licenses/LICENSE-2.0
        client().prepareIndex("test")  
                )
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            searchResponse.getHits().getAt(4).getHighlightFields().get("3_field1").fragments()[0].string(),
                        .startObject("field")
                        .endObject()  
            .execute()
                            .inOrder(true)  
            .setSource(jsonBuilder().startObject().field("id", "1").field("query", matchQuery("field1", "brown fox")).endObject())
                            "query",
                    )
            equalTo("<em>jumps</em>")
        assertHitCount(item.getResponse(), 2L);
        client().admin().indices().prepareRefresh().get();  
            assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
                jsonBuilder().startObject()
        );  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
 * specific language governing permissions and limitations
        logger.info("percolating doc with 1 field");
import org.opensearch.index.mapper.MapperParsingException;
                jsonBuilder().startObject()
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
        assertSearchHits(response, "1");
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));
        assertThat(response.getHits().getAt(0).getId(), equalTo("q1"));  
            .setSource(jsonBuilder().startObject().field("q", boolQuery().must(rangeQuery("d").gt("now"))).endObject())
                )
                    .endObject()
            searchResponse.getHits().getAt(2).getFields().get("_percolator_document_slot").getValues(),
            )
            searchResponse.getHits().getAt(1).getHighlightFields().get("query1_0_field1").fragments()[0].string(),
        assertThat(
            .get();
    public void testPercolatorQueryExistingDocumentSourceDisabled() throws Exception {
        );  
            equalTo(Collections.singletonList(1))  
        assertHitCount(item.getResponse(), 2L);
            .setSource(
                )
            .setSource(jsonBuilder().startObject().field("id", "3").field("query", termQuery("field1", "jumps")).endObject())
            searchResponse.getHits().getAt(0).getFields().get("_percolator_document_slot").getValues(),  
        client().prepareIndex("test")  
                                .field("name", "peter parker")  
            .get();
        client().prepareIndex("test").setId("6").setSource(MediaTypeRegistry.JSON, "id", "6", "field1", "value", "field2", "value").get();
            equalTo("The quick brown fox <em>jumps</em> over the lazy dog")
        BytesReference source = BytesReference.bytes(jsonBuilder().startObject().field("field1", 12).endObject());
                            .startObject()  
        response = client().prepareSearch()  
            .addSort("id", SortOrder.ASC)
                .indices()
            .startObject("id")  
                .setSource(
            .setId("6")
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
        item = response.getResponses()[5];
                .field("field1", "the quick brown fox jumps over the lazy dog")  
        assertThat(
        assertHitCount(response, 3);
                .prepareCreate("test")
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        source = BytesReference.bytes(jsonBuilder().startObject().field("field2", 11).endObject());  
            equalTo("<em>dog</em>")  
            searchResponse.getHits().getAt(0).getHighlightFields().get("query1_1_field1").fragments()[0].string(),
        client().prepareIndex("test")  
                    .endObject()  
                    .field("id", "3")  
                        BytesReference.bytes(jsonBuilder().startObject().field("d", "2020-02-01T15:00:00.000+11:00").endObject()),  
        // Acceptable:  
            client().admin()
            equalTo("The quick <em>brown</em> <em>fox</em> jumps")
            .setSource(jsonBuilder().startObject().field("query", rangeQuery("field3").from("192.168.1.0").to("192.168.1.5")).endObject())
            .get();  
                )
                            ScoreMode.Avg  
                new PercolateQueryBuilder(
        assertAcked(
        );
        client().admin().indices().prepareRefresh().get();  
                        XContentFactory.jsonBuilder()
                    .endObject()
        assertThat(response.getHits().getAt(0).getScore(), equalTo(Float.NaN));
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
                .setMapping(  
                    .setQuery(  
            .get();
        logger.info("percolating doc with 1 field");
                    "type=double",
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.query.QueryBuilders;  
                boolQuery().should(
        logger.info("percolating doc with 2 fields");
                    .setMapping("id", "type=keyword", "field1", "type=keyword", "query", "type=percolator")
        );  
        );
                        )  
        assertHitCount(response, 1);
import static org.opensearch.index.query.QueryBuilders.constantScoreQuery;  
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();  
        client().prepareIndex("test")  
        searchResponse = client().prepareSearch()  
                    .endObject()
            .get();
            .setId("2")
            .addSort("id", SortOrder.ASC)  
            searchResponse.getHits().getAt(1).getFields().get("_percolator_document_slot").getValues(),  
        assertThat(
            )
        );
            .setId("2")  
            .get();  
                        .startObject("properties")
    public void testWithMultiplePercolatorFields() throws Exception {
            equalTo(Collections.singletonList(2))  
            .addSort("id", SortOrder.ASC)
        assertThat(response.getHits().getAt(0).getId(), equalTo("2"));  
        assertThat(item.getFailureMessage(), nullValue());  
        assertThat(
            .startObject("name")  
            searchResponse.getHits().getAt(2).getHighlightFields().get("field1").fragments()[0].string(),  
    }
                        new PercolateQueryBuilder(
                .prepareCreate("test")
            .setSource(
        assertThat(  
        logger.info("percolating empty doc");
            .execute()  
                .setMapping(
                            "query",  
                    "query",  
            .setSource(jsonBuilder().startObject().field("query", rangeQuery("field1").from(20).to(22)).endObject())
            equalTo("The quick <em>brown</em> <em>fox</em> jumps over the lazy dog")
            searchResponse.getHits().getAt(1).getHighlightFields().get("field1").fragments()[0].string(),
                            .must(rangeQuery("field3").from("192.168.1.5").to("192.168.1.10"))  
                .setMapping(  
            )
            .actionGet();  
            )
                        .field("type", "object")  
        client().prepareIndex("test")
        client().admin().indices().prepareRefresh().get();
                    "type=long",
                    .field("query", boolQuery().must(matchQuery("field1", "value")).must(matchQuery("field2", "value")))
                    .field("query", boolQuery().must(rangeQuery("field2").from(10).to(12)).must(rangeQuery("field2").from(12).to(14)))
    public void testPercolatorQueryExistingDocument() throws Exception {  
        assertAcked(
            )
            equalTo(Collections.singletonList(1))
            )
                                .endArray()
                    "type=date",
                            .endObject()
        assertAcked(
                                .startObject()
        assertThat(searchResponse.getHits().getAt(1).getHighlightFields().get("0_field1").fragments()[0].string(), equalTo("<em>dog</em>"));  
            .execute()
        logger.info("searchResponse={}", searchResponse);
            .setSource(jsonBuilder().startObject().field("id", "5").field("query", termQuery("field1", "fox")).endObject())  
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
            equalTo("The quick brown fox <em>jumps</em>")
    public void testWrappedWithConstantScore() throws Exception {
        logger.info("response={}", response);  
            .get();
            .execute()
            searchResponse.getHits().getAt(2).getHighlightFields().get("query2_0_field1").fragments()[0].string(),
        assertAcked(
        );
        assertThat(searchResponse.getHits().getAt(3).getHighlightFields().get("0_field1").fragments()[0].string(), equalTo("<em>dog</em>"));
        assertHitCount(searchResponse, 5);
            .addSort("_doc", SortOrder.ASC)  
            .setSource(
                            MediaTypeRegistry.JSON
    public void testPercolateQueryWithNestedDocuments() throws Exception {
                new PercolateQueryBuilder(
                    .field(
        response = client().prepareSearch().setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON)).get();  
            equalTo("The quick brown <em>fox</em> jumps")  
                    "query",  
        );
                .setMapping(queryFieldName, "type=percolator", "second_query_field", "type=percolator", "field", "type=keyword")  
        assertThat(e.getMessage(), containsString("source disabled"));  
                    )
            searchResponse.getHits().getAt(4).getFields().get("_percolator_document_slot").getValues(),  
        item = response.getResponses()[2];
            equalTo("<em>fox</em>")
import org.opensearch.plugins.Plugin;
                        .endObject()
    }
                            .field("name", "virginia stark")
                    MediaTypeRegistry.JSON  
        response = client().prepareSearch("test")
        searchResponse = client().prepareSearch()
        );
        assertThat(response.getHits().getAt(2).getId(), equalTo("3"));  
                    .field("id", 2)
                jsonBuilder().startObject()
            searchResponse.getHits().getAt(3).getFields().get("_percolator_document_slot").getValues(),
                            "query",
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", (String) null));  
            .setId("4")
                        BytesReference.bytes(jsonBuilder().startObject().field("field1", "dog").endObject()),
        assertSearchHits(response, "3", "1");
        assertHitCount(response, 3);  
        );
    }
    }
        assertThat(response.getHits().getAt(0).getFields().get("_percolator_document_slot").getValue(), equalTo(0));
        );
                            "employee",
        assertThat(response.getHits().getAt(2).getId(), equalTo("3"));
        assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));
                    new PercolateQueryBuilder(
        assertHitCount(response, 2);
        assertThat(e.getCause().getMessage(), equalTo("a document can only contain one percolator query"));
        SearchResponse searchResponse = client().prepareSearch()
            .get();
        StringBuilder fieldMapping = new StringBuilder("type=text").append(",store=").append(randomBoolean());
            .setId("1")  
            )
                .indices()
            assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
        );
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));  
        response = client().prepareSearch().setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON)).get();  
        client().prepareIndex("test")
                            MediaTypeRegistry.JSON
                        )  
        client().prepareIndex("test")
        BytesReference source = BytesReference.bytes(
            .execute()  
        );  
            SearchResponse response = client().prepareSearch()
            );
        assertThat(response.getHits().getAt(0).getId(), equalTo("q3"));  
            .setSource(jsonBuilder().startObject().field("query", rangeQuery("field2").from(20).to(22)).endObject())
        assertThat(  
                                .field("companyname", "stark")  
                .indices()
            .actionGet();
    public void testPercolatorQueryWithHighlighting() throws Exception {
            searchResponse.getHits().getAt(0).getHighlightFields().get("query2_1_field1").fragments()[0].string(),
            .get();
            .setId("1")  
                .setId("1")  
import static org.opensearch.index.query.QueryBuilders.boolQuery;
            equalTo("brown <em>fox</em>")
import static org.hamcrest.Matchers.nullValue;
        assertThat(  
                    .field("query", geoBoundingBoxQuery("field1").setCorners(52.3, 4.4, 52.1, 4.6))  
        assertThat(item.getFailureMessage(), notNullValue());
        );
    }
            .get();
                    .endObject()
            .setQuery(
 */  
import org.opensearch.geo.GeoModulePlugin;
        assertThat(item.getResponse(), nullValue());  
            .get();
        });
            .execute()  
            .get();  
            .get();
            .setSource(jsonBuilder().startObject().field("id", "1").field("query", matchAllQuery()).endObject())
                    .setQuery(
        );
            searchResponse.getHits().getAt(4).getFields().get("_percolator_document_slot_query2").getValues(),
                        .field("type", "object")
        client().admin().indices().prepareRefresh().get();  
            )  
        assertHitCount(response, 1);
/*
                    .field("query", multiMatchQuery("quick brown fox", "field1", "field2").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS))
            jsonBuilder().startObject()
            .get();
            .get();  
        assertThat(response.getHits().getAt(1).getScore(), equalTo(Float.NaN));  
            .setQuery(new PercolateQueryBuilder("query", new BytesArray("{\"field\" : [\"brown\", \"fox\"]}"), MediaTypeRegistry.JSON))  
        assertThat(response.getHits().getAt(0).getId(), equalTo("q3"));
                                .endArray()  
            .setSource(jsonBuilder().startObject().field("query", new MatchPhraseQueryBuilder("field", "brown fox").slop(4)).endObject())  
        response = client().prepareSearch()
                        boolQuery().must(rangeQuery("field3").from("192.168.1.0").to("192.168.1.5"))
    public void testPercolatorSpecificQueries() throws Exception {  
            .setSource(jsonBuilder().startObject().field("query", rangeQuery("field3").from("192.168.1.20").to("192.168.1.30")).endObject())  
                    .field("id", "2")
                    )
        client().prepareIndex("test")
            .setSource(  
                    .field("id", 3)
        return Arrays.asList(PercolatorModulePlugin.class, GeoModulePlugin.class);
                            spanNearQuery(spanTermQuery("field1", "quick"), 0).addClause(spanTermQuery("field1", "brown"))  
            client().admin()  
        // Test IP range:
    public void testPercolatorQueryViaMultiSearch() throws Exception {  
    @ParametersFactory
                        geoPolygonQuery("field1", Arrays.asList(new GeoPoint(52.1, 4.4), new GeoPoint(52.3, 4.5), new GeoPoint(52.1, 4.6)))  
                    )
                    ),
                    .setQuery(new PercolateQueryBuilder("query", "test", "6", null, null, null))  
                )  
            .endObject()
            .setQuery(new PercolateQueryBuilder("query", "test", "1", null, null, null))  
            .field("type", "text")
        SearchResponse response = client().prepareSearch()  
        source = BytesReference.bytes(jsonBuilder().startObject().field("field1", "value").field("field2", "value").endObject());  
                            .field("companyname", "notstark")
            .setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON))  
        client().prepareIndex("test").setId("4").setSource("{\"id\": \"4\"}", MediaTypeRegistry.JSON).get();
                e.getCause().getMessage()
        assertThat(response.getHits().getAt(0).getFields().get("_percolator_document_slot").getValues(), equalTo(Arrays.asList(0, 1)));  
        assertThat(  
                    .field(
        );  
            .setId("3")  
        );  
                        .endObject()
import static org.opensearch.index.query.QueryBuilders.spanNotQuery;  
            searchResponse.getHits().getAt(2).getHighlightFields().get("2_field1").fragments()[0].string(),  
    public void testDisallowExpensiveQueries() throws IOException {
                    .should(new PercolateQueryBuilder("query", document2, MediaTypeRegistry.JSON).setName("query2"))
            .setSource(
    }  
/*
                            .endObject()
            .endObject();  
            .setSource(  
                        .startObject(queryFieldName)
            .get();
                jsonBuilder().startObject()
                                .inOrder(true)
        );
            .get();
            .setSource(jsonBuilder().startObject().field("query", rangeQuery("field1").from(10).to(12)).endObject())
    }  
                            BytesReference.bytes(jsonBuilder().startObject().field("field1", "b c").endObject()),  
        );
            searchResponse.getHits().getAt(2).getFields().get("_percolator_document_slot_query2").getValues(),
                    )
            .setSource(
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", true));  
        client().prepareIndex("test")  
                )
        assertSearchHits(response, "4");  
        assertThat(  
    }
                    .field("query", QueryBuilders.matchQuery("employee.name", "virginia"))  
                    MediaTypeRegistry.JSON  
                jsonBuilder().startObject()
        logger.info("searchResponse={}", searchResponse);  
            OpenSearchException e = expectThrows(
            .setQuery(new PercolateQueryBuilder("object_field." + queryFieldName, source, MediaTypeRegistry.JSON))  
                    .setQuery(
                            BytesReference.bytes(yamlBuilder().startObject().field("field1", "c").endObject()),
        MultiSearchResponse response = client().prepareMultiSearch()
                )
        );
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.index.query.QueryBuilders.rangeQuery;
            .setSource(  
            equalTo(Arrays.asList(1, 3))
                .setMapping("id", "type=keyword", "field1", "type=keyword", "field2", "type=keyword", "query", "type=percolator")  
                        ).setName("query2")
                        MediaTypeRegistry.JSON  
        assertThat(
        BytesReference source = BytesReference.bytes(jsonBuilder().startObject().endObject());
            .get();
        );  
                    jsonBuilder().startObject()
                    ),  
            )  
                    .field("id", "1")  
                        .endObject()
        client().prepareIndex("test")
            equalTo("The quick brown <em>fox</em> jumps over the lazy dog")  
import org.apache.lucene.search.join.ScoreMode;
import org.opensearch.action.search.SearchResponse;  
/*  
                    .field("query", boolQuery().must(matchQuery("field1", "b")).must(matchQuery("field1", "c")))
                .setMapping("id", "type=keyword", "field1", fieldMapping.toString(), "query", "type=percolator")  
                constantScoreQuery(  
 * not use this file except in compliance with the License.
        client().prepareIndex("test")
                .indices()  
        );  
                    .endObject()
            .get();  
                        .endObject()
        client().prepareIndex("test")
            .setSource(jsonBuilder().startObject().field("query", matchQuery("field1", "b")).field("a", "b").endObject())
            .get();
        assertThat(response.getHits().getAt(0).getFields().get("_percolator_document_slot").getValue(), equalTo(0));
        assertThat(response.getHits().getAt(1).getId(), equalTo("q3"));
                        spanNearQuery(spanTermQuery("field1", "quick"), 0).addClause(spanTermQuery("field1", "brown"))
            client().admin()  
            searchResponse.getHits().getAt(3).getHighlightFields().get("query1_0_field1").fragments()[0].string(),
        item = response.getResponses()[1];  
import java.util.Arrays;
                            BytesReference.bytes(jsonBuilder().startObject().field("field1", "d").endObject()),
            .setSource(  
                    .setQuery(
            .get();
                .setSource(jsonBuilder().startObject().field("id", "1").field("query", matchQuery("field1", "value")).endObject())
            .setId("q1")  
        );  
        client().prepareIndex("test").setId("5").setSource(MediaTypeRegistry.JSON, "id", "5", "field1", "value").get();  
            .setIndices("test2")
        assertThat(  
            .get();  
            .get();  
            .setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON))  
            .setId("3")
    public static Collection<Object[]> parameters() {
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        assertAcked(
        assertSearchHits(response, "7");
                client().prepareSearch("test") // non existing doc, so error element
                                .inOrder(true),
                        )
        client().prepareIndex("test")
import static org.opensearch.index.query.QueryBuilders.commonTermsQuery;
        client().prepareIndex("test").setId("2").setSource("{}", MediaTypeRegistry.JSON).get();
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                        "query",
        client().prepareIndex("test")
import static org.opensearch.index.query.QueryBuilders.geoDistanceQuery;
        assertThat(searchResponse.getHits().getAt(4).getHighlightFields().get("1_field1").fragments()[0].string(), equalTo("<em>fox</em>"));  
        assertHitCount(response, 3);  
            )  
 * under the License.  
                            .startObject()  
                jsonBuilder().startObject()
                jsonBuilder().startObject()  
            .startObject("properties")
        assertThat(
            .setId("2")
                    .prepareCreate("test")
            equalTo(Collections.singletonList(1))
        assertAcked(
        assertSearchHits(item.getResponse(), "1", "2", "3", "4");
        assertSearchHits(response, "9", "7");  
import static org.opensearch.index.query.QueryBuilders.matchQuery;
import org.opensearch.common.geo.GeoPoint;
        client().prepareIndex("test")
                                .addClause(spanTermQuery("field1", "fox"))
            .get();  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(response.getHits().getAt(1).getFields().get("_percolator_document_slot").getValue(), equalTo(0));
        client().prepareIndex("test")
                        ).dist(3)  
                    )
                            "query",  
            .get();
            .highlighter(new HighlightBuilder().field("field1"))
                    .endObject()  
                        .endObject()
    }
        assertEquals(1, response.getHits().getTotalHits().value());
        client().admin().indices().prepareRefresh().get();
            .get();  
                )  
                .prepareCreate("test3")
 * Unless required by applicable law or agreed to in writing,
        assertThat(response.getHits().getAt(0).getId(), equalTo("q1"));  
                        .field("type", "keyword")
                    "query",  
public class PercolatorQuerySearchIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                                .startObject()
            equalTo("The quick brown fox jumps over the lazy <em>dog</em>")
                                .field("companyname", "stark")
        );
        );
                        .startObject("properties")
        BytesReference source = BytesReference.bytes(
                .prepareCreate("test")
                    .endObject()
            client().prepareSearch().setQuery(new PercolateQueryBuilder("query", "test", "1", null, null, null)).get();
        assertEquals(1, response.getHits().getTotalHits().value());  
                .prepareCreate("test")
        assertSearchHits(response, "6", "4");
                new PercolateQueryBuilder(
        assertHitCount(response, 1);  
            .get();  
        MultiSearchResponse.Item item = response.getResponses()[0];
        assertAcked(
                    )
        client().admin().indices().prepareRefresh().get();  
            .setQuery(new PercolateQueryBuilder("query", "test", "6", null, null, null))
        client().prepareIndex("test")
            .actionGet();
            .setQuery(
            .setSource(
                    .endObject()  
            )
            jsonBuilder().startObject().field("field1", "The quick brown fox jumps").endObject()
        // this query should never match as it doesn't use nested query:  
        assertHitCount(response, 2);
        );  
            searchResponse.getHits().getAt(2).getHighlightFields().get("query1_field1").fragments()[0].string(),  
                .prepareCreate("test2")
            equalTo("<em>brown</em> <em>fox</em>")  
    }
            .setSource(jsonBuilder().startObject().field("query", rangeQuery("field2").from(10).to(12)).endObject())  
        assertThat(
                    .startObject("object_field")  
                                .addClause(spanTermQuery("field1", "dog"))
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));  
                    .endObject()
            .field("type", "text")
            client().prepareIndex("test2")  
            .highlighter(new HighlightBuilder().field("field1"))  
            )  
import org.opensearch.OpenSearchException;  
    }
                            XContentFactory.jsonBuilder()
        client().prepareIndex("test")  
            .get();
        );  
        String queryFieldName = randomAlphaOfLength(8);
            .get();  
    }  
                                .startArray("employee")
                new PercolateQueryBuilder(
            .execute()  
        assertThat(
            .setSource(jsonBuilder().startObject().field("id", 1).field("query", commonTermsQuery("field1", "quick brown fox")).endObject())
                                .startObject()  
            )
                        .endObject()  
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.common.xcontent.XContentType;
                        ),
            client().admin()  
            // Set search.allow_expensive_queries setting to "true" ==> success
                .prepareCreate("test")
        assertHitCount(response, 1);
                    .field("id", "q2")
            assertHitCount(response, 1);
        );
            .addSort("id", SortOrder.ASC)
                        BytesReference.bytes(
        client().admin().indices().prepareRefresh().get();
            .setQuery(new PercolateQueryBuilder("query", source, MediaTypeRegistry.JSON))
            .get();
            .setSource(
            refresh();  
            .addSort("id", SortOrder.ASC)
                        BytesReference.bytes(  
                .prepareCreate("test")
                            "query",
    }  
        assertThat(
                    )
            .endObject()
            .get();
        assertThat(response.getHits().getAt(0).getFields().get("_percolator_document_slot").getValues(), equalTo(Arrays.asList(0, 1)));
            .setQuery(
        assertHitCount(response, 1);  
        client().admin().indices().prepareRefresh().get();
            )  
        assertHitCount(response, 2);
            .setSource(
            .get();
                                .endObject()  
            .get();  
        if (randomBoolean()) {  
    }
    }  
            .get();
        logger.info("percolating doc with 2 fields");
                                .inOrder(true)
            .setQuery(
        } finally {
            .field("type", "percolator")
        client().prepareIndex("test")  
            .setId("q2")
 * Licensed to Elasticsearch under one or more contributor  
                            .endObject()
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        BytesReference document2 = BytesReference.bytes(jsonBuilder().startObject().field("field1", "over the lazy dog").endObject());  
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));  
        assertHitCount(response, 1);
                            .endObject()
        assertHitCount(item.getResponse(), 2L);
                        BytesReference.bytes(
