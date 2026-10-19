        client().index(indexRequest("test").id("3").source(jsonBuilder().startObject().field("some_long", -666).endObject())).actionGet();  
    public void testSimpleMoreLikeThisIds() throws Exception {  
        assertHitCount(mltResponse, 3L);
                .endObject()  
    public void testMoreLikeThisUnlike() throws ExecutionException, InterruptedException, IOException {
        logger.info("Running moreLikeThis");
        List<IndexRequestBuilder> builders = new ArrayList<>();
                    .minimumShouldMatch("0%")
            prepareCreate("test").setMapping(
            .get();  
    }
                jsonBuilder().startObject()
            prepareCreate("test").setMapping(  
import static org.opensearch.transport.client.Requests.indexRequest;
        indexRandom(true, builders);
            )
            );
        createIndex("test");
        logger.info("Create a document that has all the fields.");  
            .setQuery(
        logger.info("Running moreLikeThis on alias with node client");
 */  
        client().prepareIndex("index").setId("1").setRouting("3").setSource("text", "this is a document").get();  
    }
            .get();
                        ).minTermFreq(1).minDocFreq(1)
        response = client().prepareSearch("test").setQuery(mltQuery).get();  
                .endObject()
            client().prepareSearch()
        createIndex("test");  
                    .setQuery(
        ensureGreen();
            prepareCreate("test").setMapping("text", "type=text,analyzer=keyword")
        super(staticSettings);
        String mapping = XContentFactory.jsonBuilder().startObject().startObject("properties").endObject().endObject().toString();  
        ensureGreen();  
                .startObject("string_value")
                    .include(true)  
                    .startObject("text")
            assertSearchResponse(response);  
            .minimumShouldMatch("1%");  
        client().index(indexRequest("test").id("4").source(jsonBuilder().startObject().field("text", "opensearch release").endObject()))  
        );  
                    .startObject("properties")  
                    .minDocFreq(1)
    public MoreLikeThisIT(Settings staticSettings) {
        client().admin().indices().refresh(refreshRequest()).actionGet();
            int max_query_terms = randomIntBetween(1, values.length);
            prepareCreate("test").setMapping(
            .addAlias("test", "beta", termQuery("text", "beta"))
        response = client().prepareSearch("release")
                .maxQueryTerms(100)  
        client().index(indexRequest("test").id("3").source(jsonBuilder().startObject().field("text", "opensearch beta").endObject()))
                assertHitCount(response, 10);
            .startObject("text")
            .maxQueryTerms(100)  
        assertSearchHits(response, "2");  
        );
                    .endObject()
            MoreLikeThisQueryBuilder mltQuery = moreLikeThisQuery(new String[] { "text" }, null, new Item[] { new Item(null, "0") })  
                    .endObject()  
        final String[] numericTypes = new String[] { "byte", "short", "integer", "long" };  
        ).actionGet();
 * not use this file except in compliance with the License.
        }
        assertHitCount(response, 2L);  
        );
        XContentBuilder normalDoc = jsonBuilder().startObject()
                .minTermFreq(1)
                .setSource(jsonBuilder().startObject().field("text", "goodby moon").field("text1", "opensearch").endObject())  
            SearchPhaseExecutionException exception = expectThrows(
            .setId("1")  
import java.util.concurrent.ExecutionException;
        moreLikeThisQueryBuilder.minTermFreq(1);  
            .minDocFreq(0)
import org.opensearch.index.query.QueryBuilders;  
        assertHitCount(searchResponse, 2L);  
    // Issue #3252
            .get();
        // mlt query with at least a numeric field -> fail by default
        int numFields = randomIntBetween(5, 10);
 * The OpenSearch Contributors require contributions made to  
        logger.info("Running Cluster Health");  
        assertHitCount(response, 1);
        }
        }
        );
                    .minimumShouldMatch("0%")
            .include(true)
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    .field("type", "text")
public class MoreLikeThisIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        assertThat(response, notNullValue());
        );
            .get();
                jsonBuilder().startObject()
        indexRandomForConcurrentSearch("index");
            prepareCreate("test").setMapping(
        client().admin().indices().prepareCreate("foo").setMapping(mapping).get();  
    }
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "1") }).minTermFreq(1).minDocFreq(1))
        client().admin().indices().refresh(refreshRequest()).actionGet();
        {  
            .endObject()
        XContentBuilder doc = jsonBuilder().startObject();
            new String[] { "text" },
        for (int i = 0; i < 10; i++) {  
            )
import org.opensearch.test.InternalSettingsPlugin;
                    .include(true)
        client().prepareIndex("foo")
    }
        logger.info("Checking the document matches otherwise ...");  
        logger.info("Running Cluster Health");  
            client().prepareSearch()
        client().index(  
    public void testMoreLikeThisIssueRoutingNotSerialized() throws Exception {
            logger.info("Testing with minimum_should_match = {}", minimumShouldMatch);
    }
        indexRandomForConcurrentSearch("test");  
        ensureGreen();
            .actionGet();
            assertThat(cause, instanceOf(RoutingMissingException.class));
        indexRandomForConcurrentSearch("foo");
            .startObject("properties")
        assertHitCount(searchResponse, 0L);
                text += j + " ";  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertOrderedSearchHits;
            SearchResponse response = client().prepareSearch("test").setQuery(mltQuery).get();
        assertThat(ensureGreen(), equalTo(ClusterHealthStatus.GREEN));  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
            .get();
                    .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "1") }).minTermFreq(1).minDocFreq(1))
                .setId("1")
            builders.add(client().prepareIndex("test").setId(i + "").setSource("field" + i, i + ""));
        assertAcked(createIndexRequestBuilder);
                () -> client().prepareSearch()  
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;
        SearchResponse response = client().prepareSearch()  
        client().index(indexRequest(indexName).id("1").source(jsonBuilder().startObject().field("text", "opensearch index").endObject()))  
        assertHitCount(searchResponse, 1L);  
            )
                )
        );
            SearchResponse response = client().prepareSearch("test").setQuery(mltQuery).get();
        }
        logger.info("Creating aliases alias release");  
                    .failOnUnsupportedField(false)  
        ).actionGet();
                    .minDocFreq(1)
        assertAcked(
            .maxQueryTerms(100)
        logger.info("Running Cluster Health");
    }
 * under the License.  
        indexRandomForConcurrentSearch("test");  
        Item item = new Item("index", "2").routing("1");  
        SearchResponse response = client().prepareSearch()
                moreLikeThisQuery(new String[] { "myField", "empty" }, null, new Item[] { new Item("test", "1") }).minTermFreq(1)  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
        XContentBuilder malformedFieldDoc = jsonBuilder().startObject()  
    public void testMoreLikeThisWithFieldAlias() throws Exception {
        doc.endObject();
        client().admin().indices().refresh(refreshRequest()).actionGet();
                    .endObject()
            .field("path", "text")
            .field("text", "Hello World!")
        ensureGreen("test");  
                        .minTermFreq(1)
        SearchResponse searchResponse = client().prepareSearch("index").setQuery(moreLikeThisQueryBuilder).get();
            )
                jsonBuilder().startObject()
        response = client().prepareSearch("test").setQuery(mltQuery).get();
    public void testMoreLikeThisMalformedArtificialDocs() throws Exception {
                    .minimumShouldMatch("0%")  
        logger.info("Running Cluster Health");
        logger.info("Running MoreLikeThis");  
        assertThat(ensureGreen(), equalTo(ClusterHealthStatus.GREEN));
            assertThat(cause.getMessage(), equalTo("routing is required for [test]/[1]"));
                    .minDocFreq(1)  
                    .minDocFreq(1)
            .indices()
            Throwable cause = exception.getCause();  
                .endObject()
        assertAcked(
            .setSource(jsonBuilder().startObject().startObject("foo").field("bar", "boz").endObject().endObject())  
                    .get()
/*  
        logger.info("Checking the document matches ...");
                    .endObject()
            .endObject();
            docs.add(new Item("test", i + ""));
            null,  
        MoreLikeThisQueryBuilder mltQuery = moreLikeThisQuery(new Item[] { new Item("test", doc) }).minTermFreq(0)  
        logger.info("Testing each minimum_should_match from 0% - 100% with 10% increment ...");  
        QueryBuilder query = QueryBuilders.moreLikeThisQuery(new String[] { "alias" }, null, new Item[] { item })  
                .endObject()  
                    new MoreLikeThisQueryBuilder(new String[] { "string_value", "int_value" }, null, new Item[] { new Item("test", "1") })  
    @Override
                    .field("type", "text")  
        response = client().prepareSearch()  
                .endObject()
    public void testMoreLikeThisForZeroTokensInOneOfTheAnalyzedFields() throws Exception {  
            .field("text", "Hello World!")
            )
    }
            assertSearchResponse(response);
            .setQuery(moreLikeThisQuery(new String[] { "string_value" }, new String[] { "index" }, null).minTermFreq(1).minDocFreq(1))  
                .minimumShouldMatch("0%");
        }  
        client().index(indexRequest("test").id("1").source(jsonBuilder().startObject().field("text", "lucene").endObject())).actionGet();
            assertSearchResponse(response);  
            .minDocFreq(0)
        String mapping = XContentFactory.jsonBuilder().startObject().startObject("properties").endObject().endObject().toString();
                .setQuery(moreLikeThisQuery(new String[] { "int_value" }, new String[] { "42" }, null).minTermFreq(1).minDocFreq(1)),
            .actionGet();
        client().admin().indices().prepareCreate(indexName).setMapping(mapping).get();
import org.opensearch.action.RoutingMissingException;  
        builders.add(client().prepareIndex("test").setSource("text", "apache lucene").setId("3"));  
import org.opensearch.index.query.MoreLikeThisQueryBuilder.Item;
            .minDocFreq(0)
        indexRandom(true, builders);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        ensureGreen();
            .include(true)
        SearchResponse response = client().prepareSearch()  
        assertThat(response, notNullValue());
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.xcontent.XContentFactory;
        indexRandom(
            .actionGet();
        for (int i = 0; i < values.length; i++) {  
            Throwable cause = exception.getCause();
                .setSource(jsonBuilder().startObject().field("text", "hello world").field("text1", "opensearch").endObject()),  
        assertHitCount(response, numFields);  
            .setId("1")
        assertThat(response.getHits().getAt(0).getId(), equalTo("2"));
            .actionGet();
        }
    }  
            client().prepareIndex("test")
        assertSearchResponse(response);  
            .field("date", "1000-01-01") // should be properly parsed but ignored ...  
        List<IndexRequestBuilder> builders = new ArrayList<>();
                .setQuery(
        logger.info("Indexing...");  
            doc.field("field" + i, i + "");  
        indexRandomForConcurrentSearch("foo");
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("foo", "1").routing("4000") }))
                jsonBuilder().startObject()
            )  
        assertAcked(prepareCreate("test").setMapping("text", "type=text,analyzer=whitespace", "date", "type=date"));  
        assertRequestBuilderThrows(
            .actionGet();  
        client().index(indexRequest(indexName).id("3").source(jsonBuilder().startObject().field("text", "opensearch index").endObject()))
                .setQuery(  
    }
        assertSearchResponse(response);
 * GitHub history for details.
                    .endObject()
            SearchPhaseExecutionException.class
            assertHitCount(response, numFields - (i + 1));  
        // index one document with all the values  
            prepareCreate("foo", 2, Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 2).put(SETTING_NUMBER_OF_REPLICAS, 0)).setMapping(
 *
        );
        indexRandom(true, builders);  
            .get();  
        assertHitCount(response, 1);
                        new MoreLikeThisQueryBuilder(
                    .endObject()  
                        .endObject()  
            .get();
    }
        client().prepareIndex("index").setId("3").setRouting("4").setSource("text", "this is yet another document").get();
        response = internalCluster().coordOnlyNodeClient()
        assertHitCount(response, 1);
    }
 * software distributed under the License is distributed on an
                .minDocFreq(1)
        for (int i = 0; i < numFields; i++) {
        assertHitCount(searchResponse, 1L);
        logger.info("Indexing...");
                .minimumShouldMatch("0%");
        indexRandom(true, builders);  
            .setSource(jsonBuilder().startObject().startObject("foo").field("bar", "boz").endObject().endObject())
        ensureGreen();
        MoreLikeThisQueryBuilder mltQuery = moreLikeThisQuery(new Item[] { new Item("test", malformedFieldDoc) }).minTermFreq(0)
                .endObject()  
import org.opensearch.cluster.health.ClusterHealthStatus;
        assertSearchResponse(response);
        client().prepareIndex("test")  
        client().prepareIndex("foo")
    public void testSimpleMoreLikeThisWithTypes() throws Exception {
        assertThat(response, notNullValue());
            .minDocFreq(1);
        index("test", "_doc", "1", "text", "lucene");  
            logger.info("Running More Like This with max_query_terms = {}", max_query_terms);
        ensureGreen();  
        logger.info("Running moreLikeThis on index");
            .get();
    public void testMinimumShouldMatch() throws ExecutionException, InterruptedException {
 * this work for additional information regarding copyright
            String minimumShouldMatch = (10 * i) + "%";
        // routing to ensure we hit the shard with the doc  
    }  
        client().admin().indices().prepareRefresh("foo").get();
        CreateIndexRequestBuilder createIndexRequestBuilder = prepareCreate("test").setMapping(
            assertThat(cause, instanceOf(RoutingMissingException.class));
        assertThat(ensureGreen(), equalTo(ClusterHealthStatus.GREEN));
                    .startObject("text")  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "1") }).minTermFreq(1).minDocFreq(1))
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1))
        client().prepareIndex("foo")
        refresh();
                .setSource(jsonBuilder().startObject().field("text", "Hello World!").field("date", "2009-01-01").endObject())
            .get();  
    public void testWithRouting() throws IOException, InterruptedException {
import java.util.List;
        client().index(indexRequest("test").id("2").source(jsonBuilder().startObject().field("text", "lucene release").endObject()))
            .field("date", "this is not a date!")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            .setQuery(
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("foo", "1") }))
        builders.add(client().prepareIndex("test").setId("0").setSource("text", values));
        refresh("index");  
        ).actionGet();
            .setId("2")
                .field("type", "text")
                    .startObject("properties")
        List<IndexRequestBuilder> builders = new ArrayList<>();  
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(response.getHits().getAt(0).getId(), equalTo("3"));
        client().index(indexRequest("test").id("2").source(jsonBuilder().startObject().field("some_long", 0).endObject())).actionGet();
            client().prepareSearch()  
        indexRandomForConcurrentSearch(indexName);
        for (int i = 0; i < numFields; i++) {
            .startObject()  
        for (int i = 0; i < maxIters; i++) {  
            .get();  
        return Arrays.asList(
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item(aliasName, "1") }).minTermFreq(1).minDocFreq(1))
                () -> client().prepareSearch()
        assertThat(response, notNullValue());
                ),  
        assertNoFailures(response);  
            indexRequest("test").id("1")
            .setSource(jsonBuilder().startObject().startObject("foo").field("bar", "boz").endObject().endObject())  
            )  
    // Issue #3039
        // mlt field query on a numeric field -> failure by command  
                .startObject("properties")  
                mapping  
            .minimumShouldMatch("1%");
        logger.info("Checking with a malformed field value ...");
        SearchResponse response = client().prepareSearch()  
                SearchPhaseExecutionException.class,  
    public void testMoreLikeThisMultiValueFields() throws Exception {
                .setQuery(
        client().index(indexRequest("test").id("2").source(jsonBuilder().startObject().field("text", "lucene release").endObject()))
        SearchResponse response = client().prepareSearch()
        }
        ensureGreen();
            .setId("1")
        logger.info("First check the document matches all indexed docs.");
import static org.hamcrest.Matchers.instanceOf;
                    )  
        client().index(indexRequest("test").id("2").source(jsonBuilder().startObject().field("text", "lucene release").endObject()))
 *  
        logger.info("Creating the index ...");  
        moreLikeThisQueryBuilder.minDocFreq(1);
        SearchResponse response = client().prepareSearch()
        indexRandom(true, client().prepareIndex("test").setId("0").setSource(doc));  
            .setSource(jsonBuilder().startObject().field("string_value", "lucene index").field("int_value", 1).endObject())
        Item[] items = new Item[] { new Item(null, "1") };
        int numFields = randomIntBetween(5, 10);
        logger.info("Creating an index with a single document ...");  
        // Explicit list of fields including numeric fields -> fail
            .setQuery(
                .startObject("int_value")
                    moreLikeThisQuery(new String[] { "int_value" }, new String[] { "42" }, null).minTermFreq(1)
                    .startObject("properties")
            .minimumShouldMatch("100%");  // strict all terms must match but date is ignored
            .minDocFreq(0)  
            .endObject();  
                .setId("2")
        assertSearchResponse(response);
            .actionGet();  
        Item item = new Item("test", "1");
        assertNoFailures(response);  
import org.opensearch.action.index.IndexRequestBuilder;
            .endObject()  
            SearchPhaseExecutionException.class
        client().admin().indices().refresh(refreshRequest()).actionGet();  
    public void testMoreLikeThisWithAliasesInLikeDocuments() throws Exception {
        );
        assertAcked(  
        assertOrderedSearchHits(response, "1", "2");
            doc.field("field" + i, generateRandomStringArray(5, 10, false) + "a"); // make sure they are not all empty  
            .get();  
        assertSearchResponse(response);
                    .field("type", "text")
                    .failOnUnsupportedField(false)
                .minDocFreq(0)
            .setRouting("2")
    public void testMoreLikeThisWithAliases() throws Exception {
        client().admin().indices().prepareAliases().addAlias(indexName, aliasName).get();
        logger.info("Indexing...");
        logger.info("Running More Like This with include true");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;  
        SearchResponse response = client().prepareSearch()
        assertNoFailures(response);  
        );  
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            )
                        true
        ensureGreen();
}  
                moreLikeThisQuery(new String[] { "int_value" }, new String[] { "42" }, null).minTermFreq(1)
            MoreLikeThisQueryBuilder mltQuery = moreLikeThisQuery(new String[] { "text" }, new String[] { "1 2 3 4 5 6 7 8 9 10" }, null)  
                .setQuery(moreLikeThisQuery(new String[] { "string_value", "int_value" }, new String[] { "index" }, null)),
            .minTermFreq(1)
        assertHitCount(response, 1L);
                .field("type", randomFrom(numericTypes))
            .minDocFreq(1);
            )
                    .startObject("_routing")
        logger.info("Indexing...");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // mlt query with at least a numeric field but fail_on_unsupported_field set to false
        logger.info("Creating index test with routing required for type1");
        MoreLikeThisQueryBuilder queryBuilder = QueryBuilders.moreLikeThisQuery(new String[] { "text" }, null, items)
            .get();
        // index each document with only one of the values
            .setSource(jsonBuilder().startObject().field("string_value", "opensearch index").field("int_value", 42).endObject())
            client().prepareIndex("test")  
        List<Item> docs = new ArrayList<>(numFields);  
            );
            response = client().prepareSearch("test").setQuery(mltQuery).get();
            prepareCreate("test").setMapping(  
                            null,  
    }
 * Unless required by applicable law or agreed to in writing,
        indexRandomForConcurrentSearch("test");
        logger.info("Running Cluster Health");
        searchResponse = client().prepareSearch()
                .endObject()  
                    .field("required", true)  
        }  
                    .endObject()
/*  
            )
            } else {  
        prepareCreate("test").setMapping(
            .endObject()
        assertThat(ensureGreen(), equalTo(ClusterHealthStatus.GREEN));  
            if (minimumShouldMatch.equals("0%")) {
        ).get();  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
 * specific language governing permissions and limitations
                    .minDocFreq(1)  
        response = client().prepareSearch().setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("foo", "1") })).get();
        // mlt query with at least a numeric field -> fail by command
                .startObject("properties")  
        assertAcked(  
    public void testSimpleMoreLikeThis() throws Exception {  
                new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "1") }).minTermFreq(1)
        {
        );
    // Issue #14944
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "1") }).minTermFreq(1).minDocFreq(1))
        response = client().prepareSearch("beta")  
        indexRandomForConcurrentSearch("foo");
            SearchPhaseExecutionException exception = expectThrows(
                    .field("type", "text")
                .minDocFreq(1)
        assertHitCount(response, 2);  
        assertHitCount(response, 2L);  
        logger.info("Running Cluster Health");
            client().prepareSearch()
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
            .minimumShouldMatch("0%");  
            .prepareAliases()  
        client().admin().indices().refresh(refreshRequest()).actionGet();
        );
import static org.opensearch.index.query.QueryBuilders.moreLikeThisQuery;
                    .endObject()
        response = client().prepareSearch()
                    .startObject("text")
                        .field("text", "Apache Lucene is a free/open source information retrieval software library")
    public void testMoreLikeThisIssue2197() throws Exception {
            assertThat(cause.getMessage(), equalTo("routing is required for [test]/[2]"));  
        assertThat(ensureGreen(), equalTo(ClusterHealthStatus.GREEN));  
        SearchResponse mltResponse = client().prepareSearch().setQuery(queryBuilder).get();  
        assertAcked(
    public void testSimpleMoreLikeOnLongField() throws Exception {
 * You may obtain a copy of the License at  
        for (int i = 0; i <= 10; i++) {
                    )
        assertRequestBuilderThrows(  
            true,  
 * ownership. Elasticsearch licenses this file to you under  
            jsonBuilder().startObject()
        SearchResponse response = client().prepareSearch("test").setQuery(mltQuery).get();
import org.opensearch.index.query.QueryBuilder;
                    .endObject()
        searchResponse = client().prepareSearch()  
        // mlt query with no field -> exception because _all is not enabled)
        client().index(indexRequest("test").id("1").source(jsonBuilder().startObject().field("text", "lucene beta").endObject()))  
            .get();
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
            true,
        indexRandomForConcurrentSearch("test");
                    .endObject()  
            .minDocFreq(0)  
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1))  
import static org.opensearch.index.query.QueryBuilders.termQuery;
        SearchResponse searchResponse = client().prepareSearch()  
    }
                .field("type", "text")
    @ParametersFactory
                    .endObject()  
            mltQuery = moreLikeThisQuery(null, new Item[] { new Item("test", doc) }).unlike(docs.toArray(new Item[0]))  
            .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
 *
        client().index(
        client().admin().indices().prepareCreate("foo").setMapping(mapping).get();
        logger.info("Creating the index ...");
        List<IndexRequestBuilder> builders = new ArrayList<>(values.length + 1);
            .setId("1")  
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;
            .field("type", "text")  
            .get();  
    // Issue #29678  
    // Issue #30148
        for (int i = 0; i < numFields; i++) {  
                    .field("type", "text")
        client().index(indexRequest(indexName).id("2").source(jsonBuilder().startObject().field("text", "lucene index").endObject()))
                    .endObject()
            .get();
            new Item[] { item }
        logger.info("Running moreLikeThis on beta shard");
                .minimumShouldMatch(minimumShouldMatch);  
                .setId("1")
        assertRequestBuilderThrows(
import org.opensearch.common.settings.Settings;  
            SearchPhaseExecutionException.class
        mltQuery = moreLikeThisQuery(null, new Item[] { new Item("test", normalDoc) }).minTermFreq(0)
        assertAcked(  
        logger.info("Creating index test");
        client().admin().indices().prepareRefresh("foo").get();
                    .endObject()
        MoreLikeThisQueryBuilder mltQuery = moreLikeThisQuery(new Item[] { new Item("test", doc).routing("0") }).minTermFreq(0)
                ),
        logger.info("Indexing each field value of this document as a single document.");
        }
            .get();  
        assertNoFailures(response);  
            .get();  
            client().prepareSearch().setQuery(moreLikeThisQuery(new String[] { "index" }).minTermFreq(1).minDocFreq(1)),  
            client().prepareSearch()
        assertSearchResponse(response);  
        builders.add(client().prepareIndex("test").setSource("text", "lucene release").setId("2"));
        client().admin().indices().prepareRefresh("foo").get();  
                moreLikeThisQuery(new String[] { "string_value", "int_value" }, new String[] { "index" }, null).minTermFreq(1)
import org.opensearch.action.search.SearchResponse;
        assertHitCount(response, 0);  
        assertRequestBuilderThrows(  
                    .startObject("properties")
        String mapping = XContentFactory.jsonBuilder().startObject().startObject("properties").endObject().endObject().toString();  
                    moreLikeThisQuery(new String[] { "string_value", "int_value" }, new String[] { "index" }, null).failOnUnsupportedField(  
        assertThat(response.getHits().getAt(0).getId(), equalTo("3"));
    }
            indexRequest("test").id("2")
                        .minDocFreq(1)
        SearchResponse response = client().prepareSearch("test").setQuery(mltQuery).get();
                    .startObject("text")
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("foo", "1").routing("2") }))
        doc.endObject();
        assertHitCount(response, 1L);
    // Issue #2489
            SearchPhaseExecutionException.class
        logger.info("Indexing with each doc having one less term ...");
                    .field("type", "text")
                .minTermFreq(1)
        client().admin()
        mltQuery = moreLikeThisQuery(null, new Item[] { new Item("test", emptyDoc) }).minTermFreq(0).minDocFreq(0).minimumShouldMatch("0%");
            for (int j = 1; j <= 10 - i; j++) {
        logger.info("Running Cluster Health");  
        index("test", "_doc", "2", "text", "lucene release");
                    .minDocFreq(1)
        );  
        // mlt field query on a numeric field -> failure by default
        );
        SearchResponse response = client().prepareSearch()  
                .startObject("empty")
                .include(true)
                .field("type", "text")
                    .startObject("properties")  
        int maxIters = randomIntBetween(10, 20);
            .include(true)  
 */  
            builders.add(client().prepareIndex("test").setId(i + "").setSource("text", text));
            prepareCreate("test").setMapping("text", "type=text,analyzer=whitespace")
        builders.add(client().prepareIndex("test").setSource("text", "lucene").setId("1"));
        );  
import org.opensearch.plugins.Plugin;
        String indexName = "foo";  
        ).actionGet();  
            .minimumShouldMatch("0%");  
        logger.info("Creating index test");
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "1") }).minTermFreq(1).minDocFreq(1))  
            .actionGet();  
            indexRequest("test").id("2").source(jsonBuilder().startObject().field("myField", "and_foo").field("empty", "").endObject())
        logger.info("Indexing...");  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertHitCount(response, 1L);
        assertThat(ensureGreen(), equalTo(ClusterHealthStatus.GREEN));
import java.util.Arrays;
            )  
        SearchResponse response = client().prepareSearch().setQuery(query).get();  
        assertRequestBuilderThrows(  
            .get();
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "1") }).minTermFreq(1).minDocFreq(1))
                    .endObject()  
        ensureGreen();
            String text = "";
            .get();
                .endObject()
        );
            assertHitCount(response, max_query_terms);
            .actionGet();
        MoreLikeThisQueryBuilder moreLikeThisQueryBuilder = new MoreLikeThisQueryBuilder(
        assertAcked(prepareCreate("test").setMapping("text", "type=text,analyzer=whitespace", "text1", "type=text,analyzer=whitespace"));
    }
        // mlt field query on a numeric field but fail_on_unsupported_field set to false
            .actionGet();
            .actionGet();
            .get();
            }
import org.opensearch.core.xcontent.XContentBuilder;
                .startObject("myField")
        for (int i = 0; i < numFields; i++) {
        assertSearchResponse(response);  
        XContentBuilder doc = jsonBuilder().startObject();
            .minimumShouldMatch("100%"); // strict all terms must match!
        assertThat(ensureGreen(), equalTo(ClusterHealthStatus.GREEN));  
        SearchResponse response = client().prepareSearch("test").setQuery(mltQuery).get();
                .minTermFreq(0)
        assertHitCount(response, 1L);  
            }
            .endObject();
        );  
        ensureGreen("test");
            logger.info("Running moreLikeThis with one item without routing attribute");
                jsonBuilder().startObject()
                new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "1") }).minTermFreq(1)
        SearchResponse response = client().prepareSearch()  
            SearchPhaseExecutionException.class  
 * SPDX-License-Identifier: Apache-2.0
        client().index(indexRequest("test").id("1").source(jsonBuilder().startObject().field("some_long", 1367484649580L).endObject()))  
            .minTermFreq(1)
        logger.info("Checking with an empty document ...");
 * license agreements. See the NOTICE file distributed with
import java.util.Collection;
                    .endObject()
    }
        // mlt query with string fields
            )
                        .failOnUnsupportedField(true)  
                jsonBuilder().startObject()  
import static org.hamcrest.Matchers.notNullValue;  
                .source(jsonBuilder().startObject().field("text", "Lucene has been ported to other programming languages").endObject())
            indexRequest("test").id("1").source(jsonBuilder().startObject().field("myField", "and_foo").field("empty", "").endObject())
                .source(  
            .get();
        );
    }
            prepareCreate("test").setMapping(
    public void testSelectFields() throws IOException, ExecutionException, InterruptedException {
        assertThat(ensureGreen(), equalTo(ClusterHealthStatus.GREEN));  
                SearchPhaseExecutionException.class,
                .maxQueryTerms(max_query_terms)  
        }  
import static org.opensearch.transport.client.Requests.refreshRequest;  
    public void testMoreLikeThisArtificialDocs() throws Exception {  
        client().index(  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertHitCount(response, 1L);  
        indexRandom(
        logger.info("Creating index test");
        logger.info("Creating index test");  
        String[] values = { "aaaa", "bbbb", "cccc", "dddd", "eeee", "ffff", "gggg", "hhhh", "iiii", "jjjj" };
        assertHitCount(response, 0);
 */
                    .startObject("text")  
package org.opensearch.search.morelikethis;
 *    http://www.apache.org/licenses/LICENSE-2.0
            .setQuery(  
                    .startObject("text")
        response = client().prepareSearch("test").setQuery(mltQuery).get();
        );  
                    .endObject()
                    .endObject()
        logger.info("Creating index test");  
import static org.hamcrest.Matchers.equalTo;
        logger.info("Now check like this doc, but ignore one doc in the index, then two and so on...");
            .setQuery(  
    }
            builders.add(client().prepareIndex("test").setId(String.valueOf(i + 1)).setSource("text", values[i]));
            .minDocFreq(0)
import java.util.Collections;  
    public void testMoreLikeWithCustomRouting() throws Exception {
            jsonBuilder().startObject()
        client().index(indexRequest("test").id("1").source(jsonBuilder().startObject().field("text", "lucene").endObject())).actionGet();  
        indexRandomForConcurrentSearch("test");
        indexRandomForConcurrentSearch("test");  
            client().prepareIndex("test")
        client().prepareIndex("test")
                    .endObject()  
        assertHitCount(searchResponse, 2L);
        assertThat(response.getHits().getAt(0).getId(), equalTo("3"));
            .startObject("alias")
    }  
        indexRandomForConcurrentSearch("test");
        refresh(indexName);  
    public static Collection<Object[]> parameters() {  
                assertHitCount(response, 11 - i);
            .prepareSearch("beta")  
        logger.info("Running moreLikeThis");  
    }  
    public void testSimpleMoreLikeInclude() throws Exception {
                    .get()  
        client().index(  
    }
                    jsonBuilder().startObject()
        String mapping = XContentFactory.jsonBuilder().startObject().startObject("properties").endObject().endObject().toString();  
        );
        assertAcked(prepareCreate("test").setMapping("some_long", "type=long"));
        return Collections.singleton(InternalSettingsPlugin.class);  
        logger.info("Running moreLikeThis on release shard");  
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "1") }).minTermFreq(1).minDocFreq(1))  
        logger.info("Creating the index ...");
        logger.info("Indexing a single document ...");  
        refresh();
            .setRouting("4000")
            .get();
        SearchResponse response = client().prepareSearch("test").setQuery(mltQuery).get();
        SearchResponse searchResponse = client().prepareSearch()
        client().admin().indices().refresh(refreshRequest()).actionGet();
        assertAcked(  
        logger.info("Indexing...");
    }  
        searchResponse = client().prepareSearch()
        assertAcked(prepareCreate("test").setMapping(mapping));  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.query.MoreLikeThisQueryBuilder;  
                ),  
        MoreLikeThisQueryBuilder mltQuery = moreLikeThisQuery(new Item[] { new Item("test", "1") }).minTermFreq(0)  
    public void testWithMissingRouting() throws IOException {
        assertHitCount(response, 1L);
import org.opensearch.action.search.SearchPhaseExecutionException;  
        mltQuery = moreLikeThisQuery(new String[] { "text" }, null, new Item[] { new Item("test", "1") }).minTermFreq(0)
        logger.info("Running More Like This with include false");
 * KIND, either express or implied.  See the License for the
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "1") }).minTermFreq(1).minDocFreq(1))
                new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "2") }).minTermFreq(1)
        assertAcked(
        logger.info("Running moreLikeThis");
        );  
import java.util.ArrayList;  
            SearchPhaseExecutionException.class
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
                    .startObject("properties")  
/*
        assertEquals(2, searchResponse.getHits().getTotalHits().value());  
        assertOrderedSearchHits(response, "2", "1");
    public void testNumericField() throws Exception {
        // Implicit list of fields -> ignore numeric fields
    }  
            .addAlias("test", "release", termQuery("text", "release"))
            .field("type", "alias")  
        client().prepareIndex("index").setId("2").setRouting("1").setSource("text", "this is another document").get();
        assertRequestBuilderThrows(
                    .endObject()
        XContentBuilder emptyDoc = jsonBuilder().startObject().endObject();  
        assertAcked(
        String aliasName = "foo_name";
                        .minDocFreq(1)
 * compatible open source license.
            .get();
            )  
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "1") }).minTermFreq(1).minDocFreq(1))
            .get();
        logger.info("Creating index test");
                            new Item[] { new Item("test", "1").routing("1"), new Item("test", "2"), new Item("test", "3") }
            .setQuery(  
        assertHitCount(response, 0L);
        assertThat(ensureGreen(), equalTo(ClusterHealthStatus.GREEN));
            logger.info("Running moreLikeThis with one item with routing attribute and two items without routing attribute");  
        logger.info("Indexing ...");  
