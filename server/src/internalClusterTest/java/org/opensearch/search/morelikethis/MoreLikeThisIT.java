        searchResponse = client().prepareSearch()
        SearchResponse response = client().prepareSearch("test").setQuery(mltQuery).get();
            .get();
        logger.info("Creating index test with routing required for type1");
        client().index(indexRequest("test").id("2").source(jsonBuilder().startObject().field("text", "lucene release").endObject()))
        assertOrderedSearchHits(response, "2", "1");
                    moreLikeThisQuery(new String[] { "string_value", "int_value" }, new String[] { "index" }, null).failOnUnsupportedField(
        assertAcked(prepareCreate("test").setMapping("some_long", "type=long"));
                    .field("type", "text")
        assertRequestBuilderThrows(
                new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "1") }).minTermFreq(1)
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item(aliasName, "1") }).minTermFreq(1).minDocFreq(1))
            );
        indexRandomForConcurrentSearch("foo");
        for (int i = 0; i < numFields; i++) {
            .actionGet();
        logger.info("Running moreLikeThis on index");
        logger.info("Checking the document matches otherwise ...");
        return Arrays.asList(
                .field("type", "text")
}
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertAcked(
                .setId("2")
        assertThat(ensureGreen(), equalTo(ClusterHealthStatus.GREEN));
    public void testMoreLikeWithCustomRouting() throws Exception {
        client().index(indexRequest("test").id("3").source(jsonBuilder().startObject().field("some_long", -666).endObject())).actionGet();
            SearchPhaseExecutionException.class
        assertThat(ensureGreen(), equalTo(ClusterHealthStatus.GREEN));
                moreLikeThisQuery(new String[] { "myField", "empty" }, null, new Item[] { new Item("test", "1") }).minTermFreq(1)
        logger.info("Running moreLikeThis");
            .field("type", "text")
                SearchPhaseExecutionException.class,
            )
        final String[] numericTypes = new String[] { "byte", "short", "integer", "long" };
import static org.hamcrest.Matchers.instanceOf;
        assertOrderedSearchHits(response, "1", "2");
            .get();
        ensureGreen();
        assertNoFailures(response);
            .minDocFreq(0)
                moreLikeThisQuery(new String[] { "string_value", "int_value" }, new String[] { "index" }, null).minTermFreq(1)
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "1") }).minTermFreq(1).minDocFreq(1))
            .setSource(jsonBuilder().startObject().startObject("foo").field("bar", "boz").endObject().endObject())
        SearchResponse searchResponse = client().prepareSearch()
import static org.opensearch.transport.client.Requests.refreshRequest;
        builders.add(client().prepareIndex("test").setSource("text", "apache lucene").setId("3"));
        logger.info("Creating index test");
            SearchPhaseExecutionException.class
        logger.info("Running moreLikeThis on beta shard");
            )
        client().index(indexRequest("test").id("2").source(jsonBuilder().startObject().field("text", "lucene release").endObject()))
        logger.info("Indexing each field value of this document as a single document.");
        for (int i = 0; i < numFields; i++) {
        assertNoFailures(response);
                    .get()
        assertThat(ensureGreen(), equalTo(ClusterHealthStatus.GREEN));
        client().admin().indices().prepareCreate("foo").setMapping(mapping).get();
        assertRequestBuilderThrows(
            .actionGet();
        );
            new Item[] { item }
        response = client().prepareSearch("beta")
import org.opensearch.action.search.SearchResponse;
        for (int i = 0; i < 10; i++) {
import org.opensearch.action.index.IndexRequestBuilder;
        List<IndexRequestBuilder> builders = new ArrayList<>(values.length + 1);
            .get();
 * this file be licensed under the Apache-2.0 license or a
    public void testNumericField() throws Exception {
        );
                )
            .get();
            .setId("2")
        refresh();
            Throwable cause = exception.getCause();
        return Collections.singleton(InternalSettingsPlugin.class);
                .setQuery(
        assertRequestBuilderThrows(
            jsonBuilder().startObject()
    public void testWithMissingRouting() throws IOException {
    }
        assertHitCount(response, 1);
        logger.info("Creating index test");
            .setSource(jsonBuilder().startObject().field("string_value", "lucene index").field("int_value", 1).endObject())
        String mapping = XContentFactory.jsonBuilder().startObject().startObject("properties").endObject().endObject().toString();
        );
    // Issue #30148
        logger.info("Creating an index with a single document ...");
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1))
            doc.field("field" + i, i + "");
            .get();
                    .endObject()
        logger.info("Indexing...");
            .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
            )
        assertAcked(
        assertHitCount(response, 0);
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;
 * You may obtain a copy of the License at
        assertHitCount(searchResponse, 0L);
            .field("date", "1000-01-01") // should be properly parsed but ignored ...
        refresh("index");
            indexRequest("test").id("2")
        indexRandomForConcurrentSearch("test");
            .indices()
        client().index(indexRequest("test").id("3").source(jsonBuilder().startObject().field("text", "opensearch beta").endObject()))
        logger.info("Indexing a single document ...");
 *    http://www.apache.org/licenses/LICENSE-2.0
                .minimumShouldMatch("0%");
            SearchPhaseExecutionException exception = expectThrows(
        );
            SearchResponse response = client().prepareSearch("test").setQuery(mltQuery).get();
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            logger.info("Running moreLikeThis with one item with routing attribute and two items without routing attribute");
        client().admin().indices().refresh(refreshRequest()).actionGet();
    }
                .startObject("properties")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                    .startObject("properties")
    }
        logger.info("Running Cluster Health");
    }
                    .startObject("text")
import java.util.List;
            .setSource(jsonBuilder().startObject().field("string_value", "opensearch index").field("int_value", 42).endObject())
    }
        ensureGreen();
            .setQuery(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertOrderedSearchHits;
        searchResponse = client().prepareSearch()
 * software distributed under the License is distributed on an
    // Issue #3039
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "1") }).minTermFreq(1).minDocFreq(1))
                .startObject("int_value")
            indexRequest("test").id("2").source(jsonBuilder().startObject().field("myField", "and_foo").field("empty", "").endObject())
                new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "1") }).minTermFreq(1)
        );
        logger.info("Checking with a malformed field value ...");
import static org.hamcrest.Matchers.equalTo;
            assertThat(cause, instanceOf(RoutingMissingException.class));
            .startObject("properties")
    public void testMoreLikeThisUnlike() throws ExecutionException, InterruptedException, IOException {
        client().index(
            client().prepareIndex("test")
        }
        assertAcked(
    }
        SearchResponse response = client().prepareSearch()
                    .endObject()
            )
        logger.info("Running MoreLikeThis");
    public void testMoreLikeThisWithAliases() throws Exception {
import org.opensearch.index.query.QueryBuilders;
 * license agreements. See the NOTICE file distributed with
            prepareCreate("test").setMapping(
                    .startObject("text")
        logger.info("Now check like this doc, but ignore one doc in the index, then two and so on...");
        response = internalCluster().coordOnlyNodeClient()
        indexRandom(true, builders);
        index("test", "_doc", "1", "text", "lucene");
        client().index(indexRequest(indexName).id("3").source(jsonBuilder().startObject().field("text", "opensearch index").endObject()))
            SearchPhaseExecutionException.class
    }
        client().index(indexRequest("test").id("1").source(jsonBuilder().startObject().field("text", "lucene").endObject())).actionGet();
        assertAcked(createIndexRequestBuilder);
                .minimumShouldMatch("0%");
        Item item = new Item("test", "1");
        logger.info("Creating index test");
        assertSearchResponse(response);
        int numFields = randomIntBetween(5, 10);
 *
                ),
            .minTermFreq(1)
        );
 * KIND, either express or implied.  See the License for the
                () -> client().prepareSearch()
                jsonBuilder().startObject()
        indexRandomForConcurrentSearch(indexName);
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "1") }).minTermFreq(1).minDocFreq(1))
        MoreLikeThisQueryBuilder mltQuery = moreLikeThisQuery(new Item[] { new Item("test", "1") }).minTermFreq(0)
                            new Item[] { new Item("test", "1").routing("1"), new Item("test", "2"), new Item("test", "3") }
        response = client().prepareSearch("test").setQuery(mltQuery).get();
            .get();
        client().admin().indices().refresh(refreshRequest()).actionGet();
        }
/*
                    .endObject()
        List<IndexRequestBuilder> builders = new ArrayList<>();
        assertSearchHits(response, "2");
                .startObject("string_value")
    // Issue #3252
        response = client().prepareSearch()
        assertSearchResponse(response);
        String aliasName = "foo_name";
                            null,
            prepareCreate("test").setMapping(
        ).actionGet();
            assertSearchResponse(response);
                        .minDocFreq(1)
        assertHitCount(response, 0L);
                SearchPhaseExecutionException.class,
        logger.info("Running More Like This with include true");
            prepareCreate("foo", 2, Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 2).put(SETTING_NUMBER_OF_REPLICAS, 0)).setMapping(
            null,
                () -> client().prepareSearch()
        client().prepareIndex("test")
        mltQuery = moreLikeThisQuery(null, new Item[] { new Item("test", normalDoc) }).minTermFreq(0)
        client().prepareIndex("foo")
        builders.add(client().prepareIndex("test").setSource("text", "lucene").setId("1"));
                    .include(true)
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("foo", "1").routing("2") }))
        assertThat(ensureGreen(), equalTo(ClusterHealthStatus.GREEN));
                .startObject("empty")
    public void testMoreLikeThisForZeroTokensInOneOfTheAnalyzedFields() throws Exception {
        logger.info("Checking with an empty document ...");
 */
    }
            .setSource(jsonBuilder().startObject().startObject("foo").field("bar", "boz").endObject().endObject())
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertHitCount(searchResponse, 2L);
        assertThat(ensureGreen(), equalTo(ClusterHealthStatus.GREEN));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
    }
        assertAcked(
                .minDocFreq(0)
                jsonBuilder().startObject()
        assertNoFailures(response);
            .minimumShouldMatch("1%");
                .startObject("properties")
        logger.info("Checking the document matches ...");
    }
            .include(true)
                        .endObject()
            .prepareSearch("beta")
                .endObject()
        );
    public void testMoreLikeThisWithFieldAlias() throws Exception {
    // Issue #14944
        refresh(indexName);
            .get();
/*
        logger.info("Creating the index ...");
 * The OpenSearch Contributors require contributions made to
                .setSource(jsonBuilder().startObject().field("text", "Hello World!").field("date", "2009-01-01").endObject())
            .startObject()
        logger.info("Indexing...");
            )
        doc.endObject();
                mapping
            .actionGet();
        indexRandom(true, client().prepareIndex("test").setId("0").setSource(doc));
        logger.info("Creating index test");
        SearchResponse response = client().prepareSearch("test").setQuery(mltQuery).get();
                .minTermFreq(1)
    }
 *
        moreLikeThisQueryBuilder.minDocFreq(1);
        client().prepareIndex("foo")
            assertThat(cause.getMessage(), equalTo("routing is required for [test]/[1]"));
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(ensureGreen(), equalTo(ClusterHealthStatus.GREEN));
            .endObject()
            )
                .endObject()
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    .failOnUnsupportedField(false)
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1))
        QueryBuilder query = QueryBuilders.moreLikeThisQuery(new String[] { "alias" }, null, new Item[] { item })
            new String[] { "text" },
        response = client().prepareSearch("test").setQuery(mltQuery).get();
    public void testMoreLikeThisIssue2197() throws Exception {
            .minimumShouldMatch("0%");
                moreLikeThisQuery(new String[] { "int_value" }, new String[] { "42" }, null).minTermFreq(1)
            .maxQueryTerms(100)
import java.util.ArrayList;
        int maxIters = randomIntBetween(10, 20);
        assertEquals(2, searchResponse.getHits().getTotalHits().value());
                    .endObject()
 * compatible open source license.
                .endObject()
        client().admin()
            .addAlias("test", "release", termQuery("text", "release"))
                    .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "1") }).minTermFreq(1).minDocFreq(1))
        assertAcked(
 * Modifications Copyright OpenSearch Contributors. See
            prepareCreate("test").setMapping(
        logger.info("Running Cluster Health");
                        .failOnUnsupportedField(true)
        client().prepareIndex("index").setId("3").setRouting("4").setSource("text", "this is yet another document").get();
        ).actionGet();
        createIndex("test");
            .get();
import org.opensearch.common.xcontent.XContentFactory;
import org.opensearch.test.InternalSettingsPlugin;
            .endObject();
        assertAcked(prepareCreate("test").setMapping("text", "type=text,analyzer=whitespace", "date", "type=date"));
        XContentBuilder malformedFieldDoc = jsonBuilder().startObject()
        assertThat(response.getHits().getAt(0).getId(), equalTo("3"));
                .endObject()
        assertHitCount(response, 1L);
import java.util.Collections;
        client().admin().indices().refresh(refreshRequest()).actionGet();
        // routing to ensure we hit the shard with the doc
        );
            .setId("1")
                .setId("1")
                        .minDocFreq(1)
            .setQuery(
        XContentBuilder doc = jsonBuilder().startObject();
import java.io.IOException;
        client().admin().indices().prepareAliases().addAlias(indexName, aliasName).get();
    public void testSimpleMoreLikeOnLongField() throws Exception {
                    .startObject("properties")
 * Unless required by applicable law or agreed to in writing,
                    .field("type", "text")
                .endObject()
        prepareCreate("test").setMapping(
            .field("type", "alias")
        searchResponse = client().prepareSearch()
import org.opensearch.common.settings.Settings;
        client().index(indexRequest("test").id("4").source(jsonBuilder().startObject().field("text", "opensearch release").endObject()))
            assertSearchResponse(response);
                    .endObject()
            .endObject()
            .minDocFreq(0)
        logger.info("Creating index test");
        logger.info("Testing each minimum_should_match from 0% - 100% with 10% increment ...");
 */
            .get();
            MoreLikeThisQueryBuilder mltQuery = moreLikeThisQuery(new String[] { "text" }, null, new Item[] { new Item(null, "0") })
            .get();
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "1") }).minTermFreq(1).minDocFreq(1))
 * not use this file except in compliance with the License.
        for (int i = 0; i < maxIters; i++) {
            builders.add(client().prepareIndex("test").setId(String.valueOf(i + 1)).setSource("text", values[i]));
        assertRequestBuilderThrows(
            client().prepareSearch()
public class MoreLikeThisIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            .prepareAliases()
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
                .minDocFreq(1)
        for (int i = 0; i < numFields; i++) {
    public MoreLikeThisIT(Settings staticSettings) {
    }
                .field("type", randomFrom(numericTypes))
        assertAcked(
            .startObject("alias")
                .source(
    }
            .minimumShouldMatch("100%");  // strict all terms must match but date is ignored
        createIndex("test");
        for (int i = 0; i < numFields; i++) {
            client().prepareSearch()
        mltQuery = moreLikeThisQuery(null, new Item[] { new Item("test", emptyDoc) }).minTermFreq(0).minDocFreq(0).minimumShouldMatch("0%");
        client().index(indexRequest("test").id("2").source(jsonBuilder().startObject().field("some_long", 0).endObject())).actionGet();
        ensureGreen();
            )
            assertThat(cause.getMessage(), equalTo("routing is required for [test]/[2]"));
            .minDocFreq(0)
        indexRandomForConcurrentSearch("test");
        assertHitCount(searchResponse, 2L);
        // mlt field query on a numeric field but fail_on_unsupported_field set to false
        logger.info("Creating aliases alias release");
                    .endObject()
                    .minDocFreq(1)
                    .endObject()
                assertHitCount(response, 10);
 * SPDX-License-Identifier: Apache-2.0
        moreLikeThisQueryBuilder.minTermFreq(1);
import org.opensearch.action.search.SearchPhaseExecutionException;
        // mlt field query on a numeric field -> failure by command
                    .minDocFreq(1)
import java.util.concurrent.ExecutionException;
    public void testMinimumShouldMatch() throws ExecutionException, InterruptedException {
            .include(true)
        MoreLikeThisQueryBuilder mltQuery = moreLikeThisQuery(new Item[] { new Item("test", malformedFieldDoc) }).minTermFreq(0)
            .endObject();
                .minTermFreq(1)
        // index one document with all the values
            .get();
import static org.opensearch.index.query.QueryBuilders.termQuery;
import org.opensearch.cluster.health.ClusterHealthStatus;
            .get();
    // Issue #29678
            .field("text", "Hello World!")
        SearchResponse response = client().prepareSearch()
        assertThat(response, notNullValue());
            SearchPhaseExecutionException exception = expectThrows(
            .minDocFreq(1);
import org.opensearch.index.query.MoreLikeThisQueryBuilder.Item;
            jsonBuilder().startObject()
        ensureGreen();
                    .endObject()
        assertHitCount(response, 1L);
        logger.info("Creating the index ...");
        assertHitCount(response, 2);
        indexRandomForConcurrentSearch("index");
                        .field("text", "Apache Lucene is a free/open source information retrieval software library")
        indexRandomForConcurrentSearch("test");
        // mlt query with no field -> exception because _all is not enabled)
            .minimumShouldMatch("0%");
            .setRouting("4000")
            if (minimumShouldMatch.equals("0%")) {
            .setQuery(moreLikeThisQuery(new String[] { "string_value" }, new String[] { "index" }, null).minTermFreq(1).minDocFreq(1))
        XContentBuilder normalDoc = jsonBuilder().startObject()
        for (int i = 0; i < values.length; i++) {
            .get();
                    .endObject()
import org.opensearch.core.xcontent.XContentBuilder;
    @Override
                    .endObject()
            .minTermFreq(1)
            .maxQueryTerms(100)
        List<Item> docs = new ArrayList<>(numFields);
import static org.hamcrest.Matchers.notNullValue;
        // mlt query with string fields
        logger.info("Running moreLikeThis");
                    .endObject()
            client().prepareIndex("test")
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "1") }).minTermFreq(1).minDocFreq(1))
 * ownership. Elasticsearch licenses this file to you under
            )
                        new MoreLikeThisQueryBuilder(
            .field("path", "text")
            prepareCreate("test").setMapping("text", "type=text,analyzer=keyword")
                    .setQuery(
        response = client().prepareSearch("release")
        MoreLikeThisQueryBuilder moreLikeThisQueryBuilder = new MoreLikeThisQueryBuilder(
            .startObject("text")
        logger.info("Running moreLikeThis");
        assertSearchResponse(response);
                        .minTermFreq(1)
        ).actionGet();
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                .setQuery(moreLikeThisQuery(new String[] { "int_value" }, new String[] { "42" }, null).minTermFreq(1).minDocFreq(1)),
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        logger.info("First check the document matches all indexed docs.");
        response = client().prepareSearch()
        XContentBuilder mapping = XContentFactory.jsonBuilder()
                    .minDocFreq(1)
                        ).minTermFreq(1).minDocFreq(1)
        client().admin().indices().prepareRefresh("foo").get();
        }
        client().index(
            .minDocFreq(0)
    public static Collection<Object[]> parameters() {
        indexRandomForConcurrentSearch("foo");
        assertAcked(prepareCreate("test").setMapping(mapping));
 * specific language governing permissions and limitations
            SearchPhaseExecutionException.class
        client().admin().indices().prepareCreate(indexName).setMapping(mapping).get();
        client().admin().indices().prepareRefresh("foo").get();
        ensureGreen();
        List<IndexRequestBuilder> builders = new ArrayList<>();
        assertThat(response, notNullValue());
/*
            builders.add(client().prepareIndex("test").setId(i + "").setSource("text", text));
            .field("date", "this is not a date!")
        SearchResponse mltResponse = client().prepareSearch().setQuery(queryBuilder).get();
        // mlt field query on a numeric field -> failure by default
            .actionGet();
        Item[] items = new Item[] { new Item(null, "1") };
        assertThat(response.getHits().getAt(0).getId(), equalTo("3"));
            .minimumShouldMatch("100%"); // strict all terms must match!
        logger.info("Indexing with each doc having one less term ...");
                        true
    public void testMoreLikeThisMalformedArtificialDocs() throws Exception {
                    .minDocFreq(1)
                    .startObject("text")
            .endObject();
        SearchResponse response = client().prepareSearch()
import org.opensearch.action.RoutingMissingException;
        SearchResponse searchResponse = client().prepareSearch()
            .actionGet();
                .setQuery(
                jsonBuilder().startObject()
            indexRequest("test").id("1").source(jsonBuilder().startObject().field("myField", "and_foo").field("empty", "").endObject())
                    .field("type", "text")
        assertHitCount(response, 1);
        client().admin().indices().prepareRefresh("foo").get();
 * under the License.
        );
        ensureGreen("test");
            indexRequest("test").id("1")
        logger.info("Indexing...");
    public void testMoreLikeThisWithAliasesInLikeDocuments() throws Exception {
 * GitHub history for details.
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        client().prepareIndex("test")
                    .startObject("_routing")
            );
            prepareCreate("test").setMapping(
        assertSearchResponse(response);
            .setId("1")
                .source(jsonBuilder().startObject().field("text", "Lucene has been ported to other programming languages").endObject())
                text += j + " ";
        index("test", "_doc", "2", "text", "lucene release");
        logger.info("Running moreLikeThis on release shard");
                    .field("type", "text")
        );
        client().admin().indices().refresh(refreshRequest()).actionGet();
        );
                    new MoreLikeThisQueryBuilder(new String[] { "string_value", "int_value" }, null, new Item[] { new Item("test", "1") })
                    .minimumShouldMatch("0%")
        assertNoFailures(response);
        assertThat(ensureGreen(), equalTo(ClusterHealthStatus.GREEN));
            .minDocFreq(1);
            logger.info("Running More Like This with max_query_terms = {}", max_query_terms);
        indexRandomForConcurrentSearch("test");
        indexRandomForConcurrentSearch("foo");
        MoreLikeThisQueryBuilder mltQuery = moreLikeThisQuery(new Item[] { new Item("test", doc) }).minTermFreq(0)
        // mlt query with at least a numeric field but fail_on_unsupported_field set to false
            .get();
        logger.info("Running Cluster Health");
                    .endObject()
        logger.info("Running Cluster Health");
        SearchResponse response = client().prepareSearch().setQuery(query).get();
        client().index(
        String mapping = XContentFactory.jsonBuilder().startObject().startObject("properties").endObject().endObject().toString();
            .setSource(jsonBuilder().startObject().startObject("foo").field("bar", "boz").endObject().endObject())
        mltQuery = moreLikeThisQuery(new String[] { "text" }, null, new Item[] { new Item("test", "1") }).minTermFreq(0)
        assertHitCount(response, 1L);
                .minDocFreq(1)
            .actionGet();
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "1") }).minTermFreq(1).minDocFreq(1))
                .setSource(jsonBuilder().startObject().field("text", "hello world").field("text1", "opensearch").endObject()),
        assertThat(response, notNullValue());
                    jsonBuilder().startObject()
        assertHitCount(response, 1L);
        assertHitCount(searchResponse, 1L);
            assertThat(cause, instanceOf(RoutingMissingException.class));
import org.opensearch.plugins.Plugin;
        logger.info("Create a document that has all the fields.");
        SearchResponse response = client().prepareSearch()
        assertHitCount(response, 2L);
            .minDocFreq(0)
                .include(true)
        String indexName = "foo";
                    .minDocFreq(1)
        client().prepareIndex("index").setId("1").setRouting("3").setSource("text", "this is a document").get();
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("foo", "1").routing("4000") }))
    // Issue #2489
            client().prepareSearch()
                .setQuery(moreLikeThisQuery(new String[] { "string_value", "int_value" }, new String[] { "index" }, null)),
            } else {
                ),
        logger.info("Running Cluster Health");
        assertHitCount(response, 1L);
    public void testSimpleMoreLikeThisWithTypes() throws Exception {
            prepareCreate("test").setMapping(
        logger.info("Running moreLikeThis on alias with node client");
        indexRandom(true, builders);
            .get();
                .setId("1")
        }
        }
        logger.info("Running Cluster Health");
        client().index(indexRequest(indexName).id("1").source(jsonBuilder().startObject().field("text", "opensearch index").endObject()))
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "1") }).minTermFreq(1).minDocFreq(1))
            .setQuery(
                .startObject("myField")
    }
    public void testSimpleMoreLikeInclude() throws Exception {
                .field("type", "text")
        List<IndexRequestBuilder> builders = new ArrayList<>();
                    .endObject()
            )
                    .startObject("properties")
            doc.field("field" + i, generateRandomStringArray(5, 10, false) + "a"); // make sure they are not all empty
 *
            .setId("1")
            logger.info("Testing with minimum_should_match = {}", minimumShouldMatch);
        assertRequestBuilderThrows(
    }
        SearchResponse response = client().prepareSearch("test").setQuery(mltQuery).get();
 */
        assertHitCount(mltResponse, 3L);
            assertHitCount(response, max_query_terms);
            .addAlias("test", "beta", termQuery("text", "beta"))
import java.util.Arrays;
                    .minimumShouldMatch("0%")
        client().prepareIndex("index").setId("2").setRouting("1").setSource("text", "this is another document").get();
        MoreLikeThisQueryBuilder queryBuilder = QueryBuilders.moreLikeThisQuery(new String[] { "text" }, null, items)
    public void testSelectFields() throws IOException, ExecutionException, InterruptedException {
        // Explicit list of fields including numeric fields -> fail
            .get();
            int max_query_terms = randomIntBetween(1, values.length);
import static org.opensearch.index.query.QueryBuilders.moreLikeThisQuery;
        client().index(indexRequest("test").id("1").source(jsonBuilder().startObject().field("text", "lucene").endObject())).actionGet();
        ensureGreen();
        client().admin().indices().refresh(refreshRequest()).actionGet();
        logger.info("Creating the index ...");
    public void testMoreLikeThisIssueRoutingNotSerialized() throws Exception {
        Item item = new Item("index", "2").routing("1");
    @ParametersFactory
        logger.info("Running Cluster Health");
        assertAcked(
        SearchResponse response = client().prepareSearch()
            .actionGet();
            )
                    )
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("foo", "1") }))
                    .field("type", "text")
    }
            String text = "";
    public void testSimpleMoreLikeThis() throws Exception {
        indexRandomForConcurrentSearch("test");
        // mlt query with at least a numeric field -> fail by command
            true,
        indexRandom(
 * this work for additional information regarding copyright
            .get();
        assertAcked(prepareCreate("test").setMapping("text", "type=text,analyzer=whitespace", "text1", "type=text,analyzer=whitespace"));
        ensureGreen();
                .endObject()
        client().index(indexRequest("test").id("2").source(jsonBuilder().startObject().field("text", "lucene release").endObject()))
                .setSource(jsonBuilder().startObject().field("text", "goodby moon").field("text1", "opensearch").endObject())
    }
                    .get()
            .get();
        assertThat(response, notNullValue());
        assertThat(response.getHits().getAt(0).getId(), equalTo("3"));
            Throwable cause = exception.getCause();
        logger.info("Indexing...");
        SearchResponse response = client().prepareSearch()
            docs.add(new Item("test", i + ""));
                    .field("required", true)
import java.util.Collection;
            .actionGet();
        );
        int numFields = randomIntBetween(5, 10);
        }
        );
        }
        // index each document with only one of the values
        assertHitCount(response, 0);
    }
        doc.endObject();
            String minimumShouldMatch = (10 * i) + "%";
    }
                    .endObject()
        );
            .field("text", "Hello World!")
            SearchPhaseExecutionException.class
                    .endObject()
        }
        SearchResponse response = client().prepareSearch()
        indexRandom(true, builders);
        ).actionGet();
            client().prepareSearch().setQuery(moreLikeThisQuery(new String[] { "index" }).minTermFreq(1).minDocFreq(1)),
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import org.opensearch.index.query.MoreLikeThisQueryBuilder;
            .get();
        super(staticSettings);
import org.opensearch.index.query.QueryBuilder;
            .setQuery(
        assertSearchResponse(response);
        );
        ensureGreen();
            client().prepareSearch()
            .setQuery(
            assertHitCount(response, numFields - (i + 1));
        );
        assertSearchResponse(response);
                    )
                jsonBuilder().startObject()
        logger.info("Indexing...");
        builders.add(client().prepareIndex("test").setId("0").setSource("text", values));
                .maxQueryTerms(100)
    }
        XContentBuilder doc = jsonBuilder().startObject();
                .endObject()
            }
                    .startObject("text")
            )
            MoreLikeThisQueryBuilder mltQuery = moreLikeThisQuery(new String[] { "text" }, new String[] { "1 2 3 4 5 6 7 8 9 10" }, null)
        SearchResponse searchResponse = client().prepareSearch("index").setQuery(moreLikeThisQueryBuilder).get();
                    .include(true)
            .actionGet();
        for (int i = 0; i <= 10; i++) {
            .get();
package org.opensearch.search.morelikethis;
        indexRandomForConcurrentSearch("test");
                .maxQueryTerms(max_query_terms)
        assertAcked(
                new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "2") }).minTermFreq(1)
                    .endObject()
        indexRandom(true, builders);
            )
            .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
            .get();
        );
            mltQuery = moreLikeThisQuery(null, new Item[] { new Item("test", doc) }).unlike(docs.toArray(new Item[0]))
                    .startObject("properties")
        assertHitCount(searchResponse, 1L);
    public void testSimpleMoreLikeThisIds() throws Exception {
        assertThat(response.getHits().getAt(0).getId(), equalTo("2"));
        {
            .minimumShouldMatch("1%");
        SearchResponse response = client().prepareSearch("test").setQuery(mltQuery).get();
                assertHitCount(response, 11 - i);
        assertHitCount(response, numFields);
    public void testWithRouting() throws IOException, InterruptedException {
        SearchResponse response = client().prepareSearch()
        client().admin().indices().prepareCreate("foo").setMapping(mapping).get();
        assertRequestBuilderThrows(
        assertHitCount(response, 2L);
            prepareCreate("test").setMapping(
        client().index(indexRequest("test").id("1").source(jsonBuilder().startObject().field("text", "lucene beta").endObject()))
import static org.opensearch.transport.client.Requests.indexRequest;
            prepareCreate("test").setMapping("text", "type=text,analyzer=whitespace")
        // mlt query with at least a numeric field -> fail by default
        refresh();
                jsonBuilder().startObject()
        SearchResponse response = client().prepareSearch()
                    .failOnUnsupportedField(false)
            .setId("1")
        );
            .setQuery(
                    .minimumShouldMatch("0%")
                jsonBuilder().startObject()
                    .endObject()
        logger.info("Indexing...");
            SearchPhaseExecutionException.class
        );
        logger.info("Indexing ...");
                    .startObject("properties")
    }
        assertThat(ensureGreen(), equalTo(ClusterHealthStatus.GREEN));
                    .endObject()
            .get();
            client().prepareIndex("test")
        indexRandomForConcurrentSearch("test");
            .setRouting("2")
            builders.add(client().prepareIndex("test").setId(i + "").setSource("field" + i, i + ""));
        // Implicit list of fields -> ignore numeric fields
                    .startObject("text")
        assertSearchResponse(response);
        assertHitCount(response, 1L);
            }
                    .minDocFreq(1)
        );
            .minDocFreq(0)
        client().prepareIndex("foo")
                .setQuery(
        assertAcked(
        client().admin().indices().refresh(refreshRequest()).actionGet();
        ).get();
        assertHitCount(response, 1);
        assertThat(ensureGreen(), equalTo(ClusterHealthStatus.GREEN));
    public void testMoreLikeThisMultiValueFields() throws Exception {
        }
            .endObject()
                .endObject()
        String[] values = { "aaaa", "bbbb", "cccc", "dddd", "eeee", "ffff", "gggg", "hhhh", "iiii", "jjjj" };
        MoreLikeThisQueryBuilder mltQuery = moreLikeThisQuery(new Item[] { new Item("test", doc).routing("0") }).minTermFreq(0)
                .minTermFreq(0)
        indexRandom(
            client().prepareSearch()
                .minimumShouldMatch(minimumShouldMatch);
                    .startObject("properties")
        ensureGreen("test");
        String mapping = XContentFactory.jsonBuilder().startObject().startObject("properties").endObject().endObject().toString();
            )
            .setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("test", "1") }).minTermFreq(1).minDocFreq(1))
                    .startObject("text")
        String mapping = XContentFactory.jsonBuilder().startObject().startObject("properties").endObject().endObject().toString();
            for (int j = 1; j <= 10 - i; j++) {
                ),
                    .field("type", "text")
        XContentBuilder emptyDoc = jsonBuilder().startObject().endObject();
            response = client().prepareSearch("test").setQuery(mltQuery).get();
        logger.info("Running More Like This with include false");
            .actionGet();
        response = client().prepareSearch("test").setQuery(mltQuery).get();
    }
        client().index(indexRequest(indexName).id("2").source(jsonBuilder().startObject().field("text", "lucene index").endObject()))
        logger.info("Creating index test");
        {
            .include(true)
            true,
 * Licensed to Elasticsearch under one or more contributor
    public void testMoreLikeThisArtificialDocs() throws Exception {
            assertSearchResponse(response);
        CreateIndexRequestBuilder createIndexRequestBuilder = prepareCreate("test").setMapping(
                .field("type", "text")
        }
        ensureGreen();
            .get();
            logger.info("Running moreLikeThis with one item without routing attribute");
        builders.add(client().prepareIndex("test").setSource("text", "lucene release").setId("2"));
    }
                    moreLikeThisQuery(new String[] { "int_value" }, new String[] { "42" }, null).minTermFreq(1)
        response = client().prepareSearch().setQuery(new MoreLikeThisQueryBuilder(null, new Item[] { new Item("foo", "1") })).get();
            SearchResponse response = client().prepareSearch("test").setQuery(mltQuery).get();
                    .endObject()
        client().index(indexRequest("test").id("1").source(jsonBuilder().startObject().field("some_long", 1367484649580L).endObject()))
        client().index(
