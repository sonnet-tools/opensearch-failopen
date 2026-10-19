            "test2",
 */  
        assertAliasesVersionIncreases(
import java.util.Arrays;
import static org.hamcrest.Matchers.emptyArray;
        assertAcked(prepareCreate("test1").setMapping("name", "type=text"));
            final String aliasName = "alias" + i;
            client().prepareSearch("bars").setSize(0).setQuery(QueryBuilders.matchAllQuery()).get().getHits().getTotalHits().value(),
                response = client().prepareSearch("filter2").get();
        logger.info("--> creating aliases [alias1, alias2]");  
                .addAliasAction(AliasActions.add().index(index2).alias(alias).isHidden(true))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                .get()
        for (int i = 0; i < aliasCount; i++) {
        searchResponse = client().prepareSearch(alias).setQuery(QueryBuilders.matchAllQuery()).get();
                .getTotalHits()  
            () -> assertAcked((admin().indices().prepareAliases().addAlias("test", "alias1", barFilter).setTimeout(timeout)))
        IllegalArgumentException iae = expectThrows(
        assertFalse(client().admin().indices().prepareExists("bar_bar").execute().actionGet().isExists());
        logger.info("--> indexing against [test1]");  
        assertThat(getResponse.getAliases().get("bazbar").get(1).alias(), equalTo("bar"));
            client().prepareSearch("filter23", "filter13", "test1", "test2")  
            assertThat(getResponse.getAliases().get("foobar").get(2).alias(), equalTo("bac"));
    }  
        assertAcked(  
        assertAliasesVersionIncreases(
        createIndex(writeIndex, nonWriteIndex);  
        logger.info("--> creating alias1 ");  
        assertThat(getResponse.getAliases().get("bazbar").get(0).getIndexRouting(), nullValue());  
        assertThat(getResponse.getAliases().get("foobar").get(0).getSearchRouting(), nullValue());
                        + "        \"alias3\" : { \"index_routing\" : \"index\", \"search_routing\" : \"search\"},\n"  
        assertAcked(  
        assertAliasesVersionIncreases("test1", () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "aliasToTests")));  
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test3", "filter23", termQuery("name", "foo")))  
                .getTotalHits()
    }  
            assertAcked(admin().indices().prepareAliases().addAlias("test_x", "alias1"));
        assertThat(getResponse.getAliases().size(), equalTo(1));  
                "test",
import org.opensearch.action.support.WriteRequest.RefreshPolicy;  
        assertThat(getResponse.getAliases().get("bazbar").get(0).getSearchRouting(), nullValue());
        ensureGreen();
        assertThat(hits.getTotalHits().value(), equalTo((long) ids.length));
        terms = global.getAggregations().get("test");  
        QueryBuilder filter = termQuery("user", "foobar");  
        assertThat(getResponse, notNullValue());
    // Before 2.0 alias filters were parsed at alias creation time, in order
            .setQuery(QueryBuilders.matchAllQuery())  
        client().index(indexRequest("test2").id("8").source(source("8", "something else"), MediaTypeRegistry.JSON)).get();
        getAliasesResponse = admin().indices().prepareGetAliases("alias4").get();
        DeleteResponse deleteResponse = client().delete(deleteRequest("alias1").id("1")).actionGet();  
        logger.error("exception: {}", ex.getMessage());
import org.opensearch.cluster.metadata.IndexAbstraction;
        assertAcked(prepareCreate("2017-05-20"));  
                    .addAlias("test2", "aliasToTest2")
import static org.hamcrest.Matchers.notNullValue;
            "test",  
        assertAliasesVersionIncreases(  
        assertThat(getResponse.getAliases().get("bazbar").get(1).getSearchRouting(), nullValue());
        assertThat(getResponse.getAliases().get("foobar").get(0), notNullValue());  
        );
        logger.info("--> creating index [test]");
        assertThat(getResponse, notNullValue());
        assertAcked(prepareCreate("foo_foo"));
        logger.info("--> indexing against [test2]");  
        assertAliasesVersionIncreases("test", () -> assertAcked(admin().indices().prepareAliases().addAlias("test", "alias1")));
        stopWatch.start();
                .getHits()
            client().prepareSearch("foos", "test1")
            () -> admin().indices().prepareAliases().addAliasAction(AliasActions.add().index("week_20").alias("tmp")).execute().actionGet()
        );
            assertThat(e.getMessage(), equalTo("failed to parse filter for alias [alias2]"));  
        searchResponse = client().prepareSearch("alias1").setQuery(QueryBuilders.matchAllQuery()).get();
                .value(),
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
package org.opensearch.aliases;
        assertThat(ex.getMessage(), containsString("has is_hidden set to true on indices"));
        assertSearchResponse(searchResponse);  
        logger.info("--> checking single filtering alias search with sort");
        assertEquals(
        assertThat(
        assertHits(searchResponse.getHits(), "1", "2", "3", "4", "5");
        );
    public void testWaitForAliasCreationMultipleShards() throws Exception {  
        Terms terms = global.getAggregations().get("test");
import java.util.Map;
            () -> assertAcked(
 *    http://www.apache.org/licenses/LICENSE-2.0
        );  
        logger.info("--> checking single filtering alias search with global facets and sort");
            equalTo(1L)  
            disableIndexBlock("test", SETTING_BLOCKS_METADATA);
            IllegalArgumentException.class,  
    public void testRemoveIndexAndReplaceWithAlias() throws InterruptedException, ExecutionException {
        logger.info("--> checking single filtering alias search with global facets");  
            () -> client().index(indexRequest("alias1").id("1").source(source("2", "test"), MediaTypeRegistry.JSON)).actionGet()
        });
            logger.info("--> add index [test_x] with [alias1] as write-index");  
        assertAliasesVersionIncreases("test", () -> {
            () -> admin().indices().prepareAliases().addAliasAction(AliasActions.add().index(index2).alias(alias).isHidden(false)).get()  
    public void testDeletingByQueryFilteringAliases() throws Exception {
                disableIndexBlock("test", block);  
import org.opensearch.search.sort.SortOrder;
                .value(),
                .getTotalHits()
        assertHits(searchResponse.getHits(), "1");  
        logger.info("--> checking filtering alias for two indices and non-filtering alias for one index");
        );  
            .setQuery(QueryBuilders.matchQuery("name", "bar"))
import java.util.concurrent.TimeUnit;  
    public void testAliasesWithBlocks() {
        client().index(indexRequest("test2").id("23").source(source("23", "baz test2"), MediaTypeRegistry.JSON)).get();
            assertThat(afterMetadata.index(index).getAliasesVersion(), equalTo(1 + beforeAliasesVersions.get(index)));
        createIndex("test");
        assertThat(aliasMetadata.isHidden(), nullValue());  
        assertFalse(admin().indices().prepareGetAliases("foo").setIndices("bar_bar").get().getAliases().isEmpty());  
    }
            .setQuery(QueryBuilders.matchQuery("name", "bar"))
        assertThat(getResponse.getAliases().get("bazbar").get(0).getFilter().string(), containsString("field"));
                .addAliasAction(AliasActions.remove().index(index1).alias(alias))
    public void testIndexingAndQueryingHiddenAliases() throws Exception {
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test", "alias1", fooFilter).setTimeout(timeout))
        for (final String index : indices) {
        );  
        client().index(indexRequest("test1").id("2").source(source("2", "bar test"), MediaTypeRegistry.JSON)).get();
            "test1",
        assertThat(getResponse, notNullValue());
import org.opensearch.search.aggregations.bucket.terms.Terms;
        ensureGreen();
        assertAcked(prepareCreate("test").setMapping("id", "type=text", "name", "type=text,fielddata=true"));
            .setIndicesOptions(IndicesOptions.fromOptions(false, false, true, false, true, true, true, false, false))
        assertAliasesVersionIncreases(  
        assertThat(
        assertAcked(client().admin().indices().prepareAliases().removeIndex("bar_bar"));
        IllegalArgumentException iae = expectThrows(
        logger.info("--> creating index [test]");
 *
        );  
    }
        final long beforeAliasesVersion = admin().cluster().prepareState().get().getState().metadata().index(index).getAliasesVersion();
        assertTrue(admin().indices().prepareGetAliases("foo").addIndices("foobar").get().getAliases().isEmpty());  
        createIndex("test");  
        assertHits(searchResponse.getHits(), "11", "12", "13", "21", "22", "23", "31", "33");
            .get();
        stopWatch.start();
        final String writeIndex = randomAlphaOfLength(5).toLowerCase(Locale.ROOT);  
            "test",
        // Visible on one, then update it to hidden & add to a second as hidden simultaneously
            equalTo(
            "The provided expression [foo] matches an alias, specify the corresponding concrete indices instead.",
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;  
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
        assertThat(getResponse.getAliases().get("foobar").get(1).alias(), equalTo("alias2"));
        assertThat(getResponse.getAliases().get("bazbar").get(0).getFilter().string(), containsString("field"));
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_READ_ONLY_BLOCK;  
            "test",  
 * GitHub history for details.
                assertAliasesVersionIncreases(
                .setSize(0)
        assertThat(indexResponse.getIndex(), equalTo("test"));  
        try {
    // From 2.0 and higher alias filters are parsed at request time and therefor
        }
            indexMd.getAliases().get("alias1").filter().string(),
        searchResponse = client().prepareSearch("tests")
            () -> assertAcked(  
    private void assertHits(SearchHits hits, String... ids) {  
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;
                admin().indices()
        assertThat(getResponse.getAliases().get("foobar").get(1).getIndexRouting(), nullValue());
        logger.info("--> creating index [test1] and [test2]");
        createIndex("foobarbaz");
        }
            .addAggregation(AggregationBuilders.global("global").subAggregation(AggregationBuilders.terms("test").field("name")))
                .addAlias(new Alias("alias4").isHidden(true))
            assertThat(getResponse.getAliases().get("foobar").size(), equalTo(4));
        for (int i = 1; i <= numDocs; i++) {
        logger.info("--> getting *b* for index *bar");
        getResponse = admin().indices().prepareGetAliases("bar", "bac").addIndices("bazbar").get();
                .getTotalHits()
        assertThat(afterAliasesVersion, equalTo(beforeAliasesVersion));
                "test",
        }
        assertThat(aliasMetadata.searchRouting(), nullValue());
/*  
            iae.getMessage()
        logger.info("--> checking filtering alias for two indices and non-filtering alias for both indices");
        e = expectThrows(
            () -> admin().indices().prepareAliases().addAliasAction(AliasActions.remove().index("foo").alias("foo")).execute().actionGet()
        searchResponse = client().prepareSearch("alias*").setQuery(QueryBuilders.matchAllQuery()).get();  
        assertHits(searchResponse.getHits(), "11", "12", "13", "21", "31", "33");
    public void testIndicesRemoveNonExistingAliasResponds404() throws Exception {
        }
            logger.info("--> add index [test_x] with [alias1]");  
            client().prepareSearch("filter23", "filter13")
        client().index(indexRequest("test2").id("5").source(source("5", "foo test"), MediaTypeRegistry.JSON)).get();
                .value(),
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test2", "foos", termQuery("name", "foo")))  
            () -> admin().indices().prepareAliases().addAlias("test", "alias1", "{}").get()
        assertHits(searchResponse.getHits(), "1");
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "tests", termQuery("name", "test")))  
        Global global = searchResponse.getAggregations().get("global");  
                assertHitCount(response, i);  
import org.opensearch.common.settings.Settings;
            () -> assertAcked((admin().indices().prepareAliases().removeAlias("test", "alias1").setTimeout(timeout)))
            "test2",
        // Put a couple docs in each index directly
        logger.info("--> getting bar and baz for index bazbar");  
            assertAcked(admin().indices().prepareAliases().addAlias("bar_bar", "foo"));
                assertAliasesVersionIncreases("test", () -> assertAcked(admin().indices().prepareAliases().removeAlias("test", "alias1")));
            }
                .getHits()
        assertThat(getResponse.getAliases().get("bazbar").get(0).getFilter().string(), containsString("term"));
        assertThat(getResponse.getAliases().get("foobar").get(0).getFilter(), nullValue());
        // And querying using a wildcard with indices options set to expand hidden
            }
            client().prepareSearch("filter23", "filter13", "test2")
    }  
        assertThat(  
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "filter13", termQuery("name", "baz")))
        final TermQueryBuilder fooFilter = termQuery("name", "foo");
        assertThat(getResponse, notNullValue());
        assertAliasesVersionIncreases("test1", () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "aliasToTests")));
            assertBlocked(admin().indices().prepareGetAliases("alias2"), INDEX_METADATA_BLOCK);
        assertEquals("failed to parse filter for alias [alias1]", iae.getMessage());  
            "foobar",  
        assertThat(getResponse.getAliases().get("bazbar").get(1).getFilter(), nullValue());
        createIndex("test");
                "no write index is defined for alias [alias1]."
        client().index(indexRequest("test2").id("7").source(source("7", "baz test"), MediaTypeRegistry.JSON)).get();  
        assertAcked(client().admin().indices().prepareCreate("test"));
            equalTo(6L)
                refresh();
        logger.info("--> checking single filtering alias search");  
        createIndex("test");  
        // valid json , invalid filter  
        }
            .get();
    public void testWaitForAliasSimultaneousUpdate() throws Exception {
 * Licensed to Elasticsearch under one or more contributor  
        final Map<String, Long> beforeAliasesVersions = new HashMap<>(indices.length);  
        logger.info("--> getting f* for index *bar");
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "bars", termQuery("name", "bar")))
        assertAliasesVersionIncreases(
    }  
        assertThat(getResponse.getAliases().get("foobar").get(0).getFilter(), nullValue());  
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index(index1).alias(alias).isHidden(false)));  
        assertHits(searchResponse.getHits(), "1", "2", "3");  
        assertAliasesVersionIncreases(
            IllegalStateException.class,  
                .setRefreshPolicy(RefreshPolicy.IMMEDIATE)  
        logger.info("--> verify that filter was updated");
    public void testWaitForAliasCreationSingleShard() throws Exception {
        try {
        assertFalse(admin().indices().prepareGetAliases("bar").addIndices("bazbar").get().getAliases().isEmpty());
        assertAliasesVersionIncreases(  
        });
        res = client().index(indexRequest(alias).id("3").source(source("3", "through alias"), MediaTypeRegistry.JSON)).get();  
            () -> client().admin().indices().prepareAliases().removeIndex("foo").execute().actionGet()
        logger.info("--> creating index [test2]");  
        assertAcked(client().admin().indices().prepareAliases().removeIndex("foo*"));
        IndexResponse indexResponse = client().index(indexRequest("alias1").id("1").source(source("1", "test"), MediaTypeRegistry.JSON))
    }
            executor.submit(new Runnable() {  
        assertAliasesVersionIncreases(
        assertThat(getResponse.getAliases().get("foobar").size(), equalTo(2));
            assertAliasesVersionIncreases("test", () -> assertAcked(admin().indices().prepareAliases().addAlias("test", aliasName)));
        assertAcked(admin().indices().prepareAliases().removeAlias("foobar", "foo"));  
        assertThat(getResponse.getAliases().get("foobar").get(0).alias(), equalTo("foo"));
        );
            "test1",
                .setSize(0)
        );
        assertThat(getResponse.getAliases().get("foobar").get(0), notNullValue());
        assertAliasesVersionIncreases("test_x", () -> {
        assertAcked(prepareCreate("test2").setMapping("name", "type=text"));  
            equalTo(4L)
            IllegalArgumentException.class,
        assertThat(aliasMetadata.isHidden(), nullValue());  
        assertFalse(admin().indices().prepareGetAliases("b*").addIndices("*bar").get().getAliases().isEmpty());  
import org.opensearch.index.query.QueryBuilders;  
            fail("create index should have failed due to invalid alias filter");  
        client().index(  
        logger.info("--> adding filtering aliases to index [test2]");
            client().prepareSearch("bars").setSize(0).setQuery(QueryBuilders.matchAllQuery()).get().getHits().getTotalHits().value(),
        searchResponse = client().prepareSearch("bars").setQuery(QueryBuilders.matchAllQuery()).get();
        );  
            equalTo(6L)  
        );
                    .addAlias("my-index", "filter1", rangeQuery("timestamp").from("2016-12-01").to("2016-12-31"))  
        assertAliasesVersionIncreases("test2", () -> assertAcked(admin().indices().prepareAliases().addAlias("test2", "alias12")));
        assertHits(searchResponse.getHits(), "21", "31", "13", "33");
        assertThat(getResponse.getAliases().get("bazbar").get(0).alias(), equalTo("bac"));
        logger.info("--> modifying alias1 to have a filter");  
                .addAliasAction(AliasActions.add().index(nonWriteIndex).alias(alias).isHidden(true))  
                .addAlias(new Alias("alias3").indexRouting("index").searchRouting("search"))
                admin().indices()
        assertThat(getResponse.getAliases().get("bazbar").get(0).getFilter().string(), containsString("value"));
        assertAliasesVersionIncreases(  
        );
        logger.info("--> indexing against [test1]");  
    public void testDeleteAliases() throws Exception {  
        createIndex("test_x");
            equalTo(1L)
                    + "    \"aliases\" : {\n"  
        assertThat(getResponse.getAliases().get("foobar").get(0).getSearchRouting(), nullValue());
            assertTrue(admin().indices().prepareGetAliases(alias).get().getAliases().isEmpty());  
        assertThat(res.status().getStatus(), equalTo(201));
            client().prepareSearch("filter23", "filter1")
            () -> client().admin().indices().prepareAliases().addAlias("test", "a", QueryBuilders.rangeQuery("field2").from(0).to(1)).get()  
                .addAliasAction(AliasActions.add().index(index1).alias(alias).isHidden(true))  
        assertHits(searchResponse.getHits(), "1", "5");
/*
                .getHits()
            });  
        );  
import org.opensearch.common.StopWatch;
        assertAcked(  
        assertThat(aliasMetadata.isHidden(), equalTo(true));  
        assertFalse(admin().indices().prepareGetAliases("foo").get().getAliases().isEmpty());
        }
            equalTo(8L)  
                .get()  
        StopWatch stopWatch = new StopWatch();
import org.opensearch.common.unit.TimeValue;  
        assertThat(e.getMessage(), equalTo("failed to parse filter for alias [alias1]"));
            "test3",
        assertAliasesVersionIncreases(
            assertAcked(admin().indices().prepareAliases().addAlias("foo_foo", "foo"));
        logger.info("--> checking index and alias wildcard search");
    public void testCreateIndexWithAliasesInSource() throws Exception {
        );
        logger.info("--> checking filtering alias for two indices and one complete index");  
            equalTo(2L)
        assertAcked(
        logger.info("--> adding [week_20] alias to [2017-05-20]");  
import static org.opensearch.transport.client.Requests.indexRequest;
        assertThat(indexResponse.getIndex(), equalTo("test"));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(8L));  
            .addAggregation(AggregationBuilders.global("global").subAggregation(AggregationBuilders.terms("test").field("name")))  
            "foobar",
        stopWatch.start();
                    + " The write index may be explicitly disabled using is_write_index=false or the alias points to multiple"  
                    .prepareAliases()
        assertThat(getResponse.getAliases().get("bazbar").get(1).getSearchRouting(), nullValue());
        assertThat(getResponse.getAliases().get("foobar").get(0), notNullValue());
                .setSize(0)
        );
        assertHits(searchResponse.getHits(), "1", "2", "3", "4");  
                .addAlias(new Alias("alias2").filter(QueryBuilders.boolQuery().mustNot(QueryBuilders.existsQuery("field"))))  
        assertThat(getResponse.getAliases().get("bazbar").get(1).getIndexRouting(), nullValue());  
        logger.info("--> indexing against [alias1], should fail now");  
                }
        assertThat(aliasMetadata.filter(), nullValue());  
    }
        logger.info("--> getting f* for index *bac");
        );
            fail("create index should have failed due to invalid alias filter");
        );
        assertAliasesVersionIncreases("test_x", () -> {
        });
        assertThat(getResponse.getAliases().size(), equalTo(2));
        assertThat(done, equalTo(true));
        assertAliasesVersionIncreases(
        assertThat(
                .source(source("4", "something else"), MediaTypeRegistry.JSON)
                .setQuery(QueryBuilders.matchAllQuery())
            equalTo(8L)
                    .addAlias("test2", "foos", termQuery("name", "foo"))
        client().index(indexRequest("test1").id("12").source(source("12", "bar test1"), MediaTypeRegistry.JSON)).get();
                .get()  
        searchResponse = client().prepareSearch("filter13", "filter1").setQuery(QueryBuilders.matchAllQuery()).get();  
    }
        );
        ensureGreen();
        refresh();  
    }
import org.opensearch.search.SearchHits;
            assertAliasesVersionUnchanged(
        assertThat(getResponse.getAliases().get("bazbar").get(1).getIndexRouting(), nullValue());
        assertSearchResponse(searchResponse);
                .setQuery(QueryBuilders.matchAllQuery())
import java.util.Set;
        assertAliasesVersionIncreases(
        assertAliasesVersionIncreases("test2", () -> assertAcked(admin().indices().prepareAliases().addAlias("test2", "aliasToTest2")));
        searchResponse = client().prepareSearch("filter23", "filter13", "test2").setQuery(QueryBuilders.matchAllQuery()).get();
        } finally {
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index("2017-05-20").alias("tmp")).execute().get());
                .get()
        searchResponse = client().prepareSearch("tests").setQuery(QueryBuilders.matchAllQuery()).get();
                enableIndexBlock("test", block);
                    .addAlias("test1", "aliasToTest1")  
            .metadata()
        client().index(  
        assertThat(stopWatch.stop().lastTaskTime().millis(), lessThan(timeout.millis()));  
                .setSize(0)
        assertThat(getResponse, notNullValue());
            "test1",  
        assertFalse(admin().indices().prepareGetAliases("bar").get().getAliases().isEmpty());
                    .addAlias("test1", "aliasToTests")
        );
        final Metadata beforeMetadata = admin().cluster().prepareState().get().getState().metadata();
        final String alias = randomAlphaOfLength(7).toLowerCase(Locale.ROOT);
            "The provided expression [foo] matches an alias, specify the corresponding concrete indices instead.",
        );
        indexResponse = client().index(indexRequest("alias1").id("1").source(source("1", "test"), MediaTypeRegistry.JSON)).actionGet();
        assertAliasesVersionIncreases("bar_bar", () -> assertAcked(admin().indices().prepareAliases().addAlias("bar_bar", "foo")));
            assertBlocked(admin().indices().prepareGetAliases("alias2"), INDEX_METADATA_BLOCK);  
        assertThat(getAliasesResponse.getAliases().get("test").size(), equalTo(1));  
        logger.info("--> checking single filtering alias search with non-global facets");  
        assertThat(getResponse.getAliases().get("bazbar").get(0).getFilter().string(), containsString("term"));
        IllegalArgumentException iae = expectThrows(
        assertThat(aliasMetadata.alias(), equalTo("alias1"));
        boolean done = executor.awaitTermination(20, TimeUnit.SECONDS);  
        assertThat(aliasMetadata.searchRouting(), nullValue());
        );
        client().index(indexRequest("test1").id("2").source(source("2", "bar test"), MediaTypeRegistry.JSON)).get();
import org.opensearch.action.search.SearchResponse;
 * SPDX-License-Identifier: Apache-2.0
        assertThat(getResponse.getAliases().get("foobar").get(0).getIndexRouting(), nullValue());
        logger.info("--> adding filtering aliases to index [test2]");  
    // for filters to work correctly ES required that fields mentioned in those  
import org.opensearch.action.index.IndexResponse;  
        assertThat(getResponse.getAliases().get("foobar").get(0).getIndexRouting(), nullValue());
        assertAcked(prepareCreate("test").setMapping("name", "type=text"));  
                    "{\n"  
        } finally {
        assertThat(getResponse.getAliases().get("foobar").get(1).getSearchRouting(), nullValue());
import org.opensearch.action.support.IndicesOptions;
                .get()
import java.util.HashSet;
                    .addAlias("my-index", "filter2", rangeQuery("timestamp").from("2016-01-01").to("2016-12-31"))
        assertThat(
                );
            client().prepareSearch("foos", "aliasToTests")
        );
import org.opensearch.cluster.ClusterState;
import static org.opensearch.transport.client.Requests.createIndexRequest;
    }
            prepareCreate("test").setMapping("field", "type=text")
        checkAliases();
            equalTo(
        indexRandom(true, client().prepareIndex("test_2").setId("test").setSource("test", "test"));  
        assertThat(getResponse.getAliases().get("bazbar").get(0).getFilter().string(), containsString("value"));  
                    .addAlias("test1", "bars", termQuery("name", "bar"))  
        assertThat(getResponse.getAliases().get("foobar").get(0), notNullValue());
        assertThat(getResponse.getAliases().get("bazbar").get(1).alias(), equalTo("bar"));  
        try {  
        assertHits(searchResponse.getHits(), "11", "12", "13", "33");
        assertThat(getResponse.getAliases().get("bazbar").get(1), notNullValue());  
        searchResponse = client().prepareSearch("foos", "aliasToTests").setQuery(QueryBuilders.matchAllQuery()).get();
        assertThat(getResponse.getAliases().size(), equalTo(1));
        assertThat(getResponse.getAliases().get("foobar").get(0).getSearchRouting(), equalTo("bla"));
        );
            "my-index",
        logger.info("--> making sure that filter was stored with alias [alias1] and filter [user:foobar]");
        assertThat(getResponse.getAliases().get("bazbar").get(1).alias(), equalTo("bar"));
    }  
        Exception e = expectThrows(  
        assertThat(getResponse.getAliases().get("foobar").get(0).alias(), equalTo("foo"));
        assertThat(getResponse.getAliases().get("bazbar").size(), equalTo(2));  
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.remove().index(index1).alias(alias)));
        logger.info("--> creating index [test1]");
        assertThat(getResponse.getAliases().get("bazbar").get(0).getSearchRouting(), nullValue());
        return "{ \"id\" : \"" + id + "\", \"name\" : \"" + nameValue + "\" }";
        assertThat(indexResponse.getIndex(), equalTo("test_x"));
            createIndexRequestBuilder.get();  
        expectThrows(  
        assertThat(getResponse.getAliases().get("bazbar").get(1).getFilter(), nullValue());
            IllegalArgumentException.class,
        assertAliasesVersionIncreases("test1", () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "aliasToTest1")));  
        ensureGreen();
            fail("Expected AliasesNotFoundException");
                .setSize(0)
                    + " The write index may be explicitly disabled using is_write_index=false or the alias points to multiple"  
 * ownership. Elasticsearch licenses this file to you under  
        ensureGreen();  
        assertThat(getResponse, notNullValue());  
        );
}
import org.opensearch.action.admin.indices.alias.Alias;
        ExecutorService executor = Executors.newFixedThreadPool(aliasCount);  
    public void testHiddenAliasesMustBeConsistent() {
        client().index(  
        );
        assertHits(searchResponse.getHits(), "1", "2", "3", "4");
                    .addAlias("test2", "aliasToTests")  
            () -> assertAcked((admin().indices().prepareAliases().addAlias("test", "alias1").setTimeout(timeout)))
                .create(
                .addAliasAction(AliasActions.add().index(index2).alias(alias).isHidden(true))
import org.opensearch.test.OpenSearchIntegTestCase;  
                .getTotalHits()
        );
        );
                .getTotalHits()
        client().index(indexRequest("test1").id("1").source(source("1", "foo test"), MediaTypeRegistry.JSON)).get();
        assertThat(getResponse, notNullValue());  
            admin().indices()
        assertAliasesVersionIncreases(
            IllegalArgumentException.class,  
        assertThat(getResponse.getAliases().get("bazbar").get(1).getSearchRouting(), nullValue());  
                    createIndexRequest("test").settings(  
                .setAliases(
        logger.info("--> creating index [foo_foo] and [bar_bar]");  
        assertThat(getResponse, notNullValue());
        assertThat(getResponse.getAliases().get("bazbar").get(0).getFilter().string(), containsString("value"));
        assertThat(getResponse.getAliases().get("foobar").get(0).getSearchRouting(), nullValue());
            .setQuery(QueryBuilders.matchQuery("name", "bar"))  
        SearchResponse searchResponse = client().prepareSearch("foos").setQuery(QueryBuilders.matchAllQuery()).get();
        assertThat(
        }
        searchResponse = client().prepareSearch("foos", "bars").setQuery(QueryBuilders.matchAllQuery()).get();
        logger.info("--> checking filtering alias for one index");
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_METADATA_BLOCK;
        assertThat(getResponse.getAliases().get("bazbar").get(0), notNullValue());
        client().index(indexRequest("test3").id("33").source(source("33", "baz test3"), MediaTypeRegistry.JSON)).get();
        assertThat(  
 * specific language governing permissions and limitations
        assertThat(getResponse.getAliases().get("foobar").get(0), notNullValue());
                "test",  
            assertThat(e.getMessage(), equalTo("failed to parse filter for alias [alias2]"));
        for (SearchHit hit : hits.getHits()) {  
import org.opensearch.search.aggregations.bucket.global.Global;  
        logger.info("--> creating index [test]");  
            new String[] { "bazbar", "foobar" },
        assertAcked(prepareCreate("bar_bar"));
        IllegalArgumentException exception = expectThrows(
        assertTrue(admin().indices().prepareGetAliases("foo").get().getAliases().isEmpty());  
        assertAliasesVersionIncreases("test", () -> {
            beforeAliasesVersions.put(index, beforeMetadata.index(index).getAliasesVersion());  
        logger.info("--> checking filtering alias for multiple indices");  
            IllegalStateException.class,
        createIndex("test");
        IllegalArgumentException iae = expectThrows(  
        assertAliasesVersionIncreases(  
            () -> assertAcked(  
        logger.info("--> adding filtering aliases to index [test1]");  
                "no write index is defined for alias [alias1]."
        ensureGreen();
 * not use this file except in compliance with the License.
                        "test",
        );  
        final String writeIndex = randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
 * this work for additional information regarding copyright
        );  
 * software distributed under the License is distributed on an
        assertAliasesVersionIncreases(new String[] { "foo_foo", "bar_bar" }, () -> {  
import org.opensearch.search.SearchHit;  
    public void testIndicesGetAliases() throws Exception {
        client().index(indexRequest("test2").id("6").source(source("6", "bar test"), MediaTypeRegistry.JSON)).get();
                        + "}"
                .getTotalHits()  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertThat(
        assertHits(searchResponse.getHits(), "1", "2", "3");  
            () -> admin().indices().prepareAliases().addAliasAction(AliasActions.add().index(index2).alias(alias)).get()
        assertAliasesVersionIncreases("test2", () -> assertAcked(admin().indices().prepareAliases().addAlias("test2", "aliasToTest2")));
                .setQuery(QueryBuilders.termQuery("name", "something"))  
        logger.info("--> aliasing index [test] with [alias1] and empty filter");
import java.util.concurrent.Executors;
        stopWatch.start();  
        createIndex("test123");  
                    .addAlias("foobar", "foo")
            assertThat(getResponse, notNullValue());  
            equalTo(
            () -> admin().indices().prepareAliases().addAlias("test", "alias1", "abcde").get()
        assertThat(getResponse.getAliases().size(), equalTo(1));
    public void testAliasFilterWithNowInRangeFilterAndQuery() throws Exception {
            assertThat(getResponse.getAliases().get("foobar").get(0).alias(), equalTo("alias1"));  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
import static org.hamcrest.Matchers.nullValue;  
        assertThat(aliasMetadata.isHidden(), nullValue());  
        }  
        );  
                    assertAliasesVersionIncreases(  
        searchResponse = client().prepareSearch("filter23", "filter13", "test1", "test2").setQuery(QueryBuilders.matchAllQuery()).get();  
            IllegalArgumentException.class,
    public void testGetAliasAndAliasExistsForHiddenAliases() {
                        + "        \"alias4\" : {\"is_hidden\":  true}\n"
        assertAcked(prepareCreate("test"));
        aliasMetadata = getAliasesResponse.getAliases().get("test").get(0);
        assertAliasesVersionIncreases("test", () -> assertAcked((admin().indices().prepareAliases().addAlias("test", "alias1"))));
            IllegalStateException.class,
        );
            iae.getMessage()
        });
            );
        assertAliasesVersionIncreases(
        executor.shutdown();
        assertThat(aliasMetadata.searchRouting(), nullValue());
        aliasMetadata = getAliasesResponse.getAliases().get("test").get(0);
        createIndex("test");  
        for (String alias : aliases) {
            getResponse = aliasName != null  
            client().prepareIndex("my-index").setSource("timestamp", "2016-12-12").get();
                .prepareAliases()
        assertThat(getResponse.getAliases().get("bazbar").size(), equalTo(2));
        expectThrows(
                .getHits()
            assertAliasesVersionIncreases("test", () -> assertAcked(admin().indices().prepareAliases().addAlias("test", aliasName)));
    public void testFilteringAliases() throws Exception {
            .getIndicesLookup()  
                )  
            "test1",
                SearchResponse response = client().prepareSearch("filter1").get();
        logger.info("--> adding filtering aliases to index [test1]");
 * license agreements. See the NOTICE file distributed with
        assertThat(getAliasesResponse.getAliases().get("test").size(), equalTo(1));  
            indexRequest("test").id("2").source(source("2", "bar test"), MediaTypeRegistry.JSON).setRefreshPolicy(RefreshPolicy.IMMEDIATE)
import java.util.HashMap;  
        refresh();
                .setSize(0)
        }
            () -> assertAcked(admin().indices().prepareAliases().addAlias("foobar", "alias1").addAlias("foobar", "alias2"))  
            assertThat(getResponse.getAliases().get("foobar").get(3).alias(), equalTo("foo"));  
        assertAliasesVersionIncreases(
            assertFalse(admin().indices().prepareGetAliases("alias2").get().getAliases().isEmpty());
                admin().indices()  
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "foos", termQuery("name", "foo")))
        assertAliasesVersionIncreases("foo_foo", () -> assertAcked(admin().indices().prepareAliases().addAlias("foo_foo", "foo")));  
        GetAliasesResponse getAliasesResponse = admin().indices().prepareGetAliases("alias1").get();
import org.opensearch.cluster.metadata.IndexMetadata;
        logger.info("--> aliasing index [test] with [alias1] and filter [user:foobar]");
        assertThat(getResponse.getAliases().get("bazbar").get(1).getFilter(), nullValue());  
        runnable.run();
    }
        assertAliasesVersionIncreases("test2", () -> assertAcked(admin().indices().prepareAliases().addAlias("test2", "aliasToTests")));  
 *
                () -> assertBlocked(admin().indices().prepareAliases().removeAlias("test", "alias2"), INDEX_METADATA_BLOCK)  
            "test",
            );
        AliasMetadata aliasMetadata = getAliasesResponse.getAliases().get("test").get(0);
                .prepareAliases()  
        assertThat(getAliasesResponse.getAliases().get("test").size(), equalTo(1));  
        );  
        getResponse = admin().indices().prepareGetAliases("b*").addIndices("*bar").get();  
            indexRequest("test").id("3").source(source("3", "baz test"), MediaTypeRegistry.JSON).setRefreshPolicy(RefreshPolicy.IMMEDIATE)
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index(index1).alias(alias).isHidden(true)));
        assertAliasesVersionIncreases(  
import org.opensearch.action.delete.DeleteResponse;
        assertThat(getResponse.getAliases().get("bazbar").get(0), notNullValue());  
        ensureGreen();
        for (String aliasName : new String[] { null, "_all", "*" }) {
 * The OpenSearch Contributors require contributions made to  
            () -> assertAcked(
        assertFalse(client().admin().indices().prepareExists("foo_foo").execute().actionGet().isExists());  
        assertThat(getResponse.getAliases().get("foobar").get(0).getSearchRouting(), nullValue());  
                    .addAlias("test1", "foos", termQuery("name", "foo"))
                .get()
            () -> assertAcked(admin().indices().prepareAliases().addAlias("index1", "alias1").addAlias("index2", "alias2"))  
            assertThat(e.getMessage(), containsString("[alias1] missing"));
                    + " indices without one being designated as a write index"
        assertThat(
            () -> assertAcked(
            enableIndexBlock("test", SETTING_READ_ONLY);
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.remove().index(index1).alias(alias)));
        assertThat(getResponse.getAliases().get("foobar").get(0).getFilter(), nullValue());
            indexRequest("test").id("1").source(source("1", "foo test"), MediaTypeRegistry.JSON).setRefreshPolicy(RefreshPolicy.IMMEDIATE)
                .getHits()
    private void assertAliasesVersionUnchanged(final String index, final Runnable runnable) {  
        createIndex("bazbar");
                    + "        \"alias2\" : {\"filter\" : {\"match_all\": {}}},\n"
                    .prepareAliases()
        GetAliasesResponse response = admin().indices().prepareGetAliases().get();  
                "test",
            if (i % 2 == 0) {  
                "no write index is defined for alias [alias1]."  
                .addAliasAction(AliasActions.add().index(writeIndex).alias(alias).isHidden(true).writeIndex(true))
            );
        );  
        logger.info("--> deleting alias1");
        createIndex("index2");
        // Make sure that the doc written to the alias made it
        checkAliases();
            IllegalArgumentException.class,  
        getResponse = admin().indices().prepareGetAliases("foo").addIndices("*bac").get();  
        }
            "test",  
            () -> assertAcked(
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test3", "filter13", termQuery("name", "baz")))  
                () -> assertBlocked(admin().indices().prepareAliases().addAlias("test", "alias3"), INDEX_READ_ONLY_BLOCK)  
        assertThat(
        client().index(indexRequest("test2").id("8").source(source("8", "something else"), MediaTypeRegistry.JSON)).get();
import org.opensearch.action.admin.indices.alias.get.GetAliasesResponse;  
                .getTotalHits()
            .get();
        assertThat(aliasMetadata.searchRouting(), equalTo("search"));
            () -> admin().indices().prepareAliases().addAliasAction(AliasActions.add().index(index2).alias(alias).isHidden(true)).get()
        } catch (IllegalArgumentException e) {
                assertThat(admin().indices().prepareGetAliases("alias2").execute().actionGet().getAliases().get("test").size(), equalTo(1));  
            assertAliasesVersionUnchanged(
            indexRequest("test").id("4")
        assertHits(searchResponse.getHits(), "21", "31", "11", "12", "13");  
        assertThat(
        logger.info("--> indexing against [alias1], should work now");
        assertThat(terms.getBuckets().size(), equalTo(4));
        logger.info("--> checking filtering alias for two indices and non-filtering alias for both indices");  
        // valid json but non valid filter
    public void testCreateIndexWithAliasesSource() throws Exception {
        assertThat(getResponse.getAliases().get("bazbar").get(0), notNullValue());
        createIndex("foobar");
        logger.info("--> creating index [test]");  
                assertFalse(admin().indices().prepareGetAliases("alias2").get().getAliases().isEmpty());
    }  
        ensureGreen();
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index(index2).alias(alias).isHidden(false)));
                    + " indices without one being designated as a write index"
            () -> assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.remove().index("foo*").alias("foo")))
        assertFalse(admin().indices().prepareGetAliases("f*").addIndices("*bar").get().getAliases().isEmpty());
        logger.info("--> creating index [test]");
                .value(),
import org.opensearch.rest.action.admin.indices.AliasesNotFoundException;
            client().prepareSearch("filter13", "filter1")  
        assertThat(stopWatch.stop().lastTaskTime().millis(), lessThan(timeout.millis()));
            client().prepareSearch("foos", "aliasToTest1")  
        assertThat(aliasMetadata.indexRouting(), equalTo("index"));
    public void testCreateIndexWithAliases() throws Exception {
        assertThat(aliasMetadata.alias(), equalTo("alias3"));
        logger.info("--> adding filtering aliases to index [test2]");
                .setSize(0)  
            equalTo(5L)  
        createIndex("test1", "test2", "test3");
        );  
        assertFalse(admin().indices().prepareGetAliases("alias*").get().getAliases().isEmpty());  
 */  
import static org.hamcrest.Matchers.hasKey;  
import static org.opensearch.index.query.QueryBuilders.termQuery;  
                public void run() {
            admin().indices()
        );
        client().index(indexRequest("test2").id("5").source(source("5", "foo test"), MediaTypeRegistry.JSON)).get();
        createIndex("index1");
        String[] aliases = { "aliasToTest1", "foos", "bars", "tests", "aliasToTest2", "aliasToTests" };
                    )
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test", "foos", termQuery("name", "foo")))  
        assertThat(deleteResponse.getIndex(), equalTo("test_x"));
                .value(),
    }  
        logger.info("--> adding aliases to indices");
        ensureGreen();
import org.opensearch.index.query.TermQueryBuilder;
                .setSize(0)  
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "bars", termQuery("name", "bar")))
        searchResponse = client().prepareSearch("foos", "test1").setQuery(QueryBuilders.matchAllQuery()).get();
        );
                .prepareAliases()  
    // fields mentioned in filters don't need to exist in the mapping.  
        assertFalse(admin().indices().prepareGetAliases("*").addIndices("*bac").get().getAliases().isEmpty());
        assertThat(getResponse.getAliases().get("bazbar").get(0).getFilter().string(), containsString("term"));  
        }
        assertAliasesVersionIncreases(new String[] { index }, runnable);
        assertThat(getResponse.getAliases().get("foobar").get(0).getFilter(), nullValue());
        assertThat(aliasMetadata.filter(), nullValue());  
import org.opensearch.index.query.QueryBuilder;
        logger.info("--> creating indices [foobar, test, test123, foobarbaz, bazbar]");  
            logger.info("--> remove aliasing index [test_x] with [alias1]");  
            equalTo("{\"term\":{\"user\":{\"value\":\"foobar\",\"boost\":1.0}}}")  
    private void assertAliasesVersionIncreases(final String index, final Runnable runnable) {
            .addAggregation(AggregationBuilders.terms("test").field("name"))  
            admin().indices()
            createIndexRequestBuilder.get();
        );  
        ensureGreen();
        assertFalse(admin().indices().prepareGetAliases("bac").addIndices("bazbar").get().getAliases().isEmpty());
        for (final String index : indices) {
            )  
                .getHits()  
            "test",
                .get();
        logger.info("--> creating index [test_x]");  
        Set<String> hitIds = new HashSet<>();
    }
        assertHitCount(client().prepareSearch("test").get(), 1);
            executor.shutdownNow();  
            IllegalArgumentException.class,  
 * Modifications Copyright OpenSearch Contributors. See
        );  
            "test3",
        assertAliasesVersionIncreases(
 * compatible open source license.
                .get()
        assertSearchResponse(searchResponse);
    }
                MediaTypeRegistry.JSON
        assertAcked(
        getResponse = admin().indices().prepareGetAliases("*b*").addIndices("baz*").get();
                .addAliasAction(AliasActions.remove().index(index2).alias(alias))  
        assertAliasesVersionIncreases(
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.remove().index(index1).alias(alias)));
import org.opensearch.search.aggregations.AggregationBuilders;
 * Unless required by applicable law or agreed to in writing,
        IndexResponse res = client().index(indexRequest(nonWriteIndex).id("1").source(source("1", "nonwrite"), MediaTypeRegistry.JSON))  
            )
                .setQuery(QueryBuilders.matchAllQuery())  
            )
        assertAcked(prepareCreate("test").setMapping("user", "type=text"));
        ).actionGet();
                .getHits()  
            "test2",
        logger.info("--> indexing against [alias1], should work now");
                () -> assertBlocked(admin().indices().prepareAliases().removeAlias("test", "alias2"), INDEX_READ_ONLY_BLOCK)
        refresh();  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_METADATA;
        logger.info("--> deleting against [alias1], should fail now");  
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index(index1).alias(alias)));
        createIndexRequestBuilder = prepareCreate("test").addAlias(new Alias("alias2").filter("{ \"test\": {} }"));  
                        () -> assertAcked(admin().indices().prepareAliases().addAlias("test", aliasName))
        logger.info("--> deleting alias1 which does not exist");
        logger.info("--> recreating alias1 with the same filter");  
        client().index(indexRequest("test1").id("1").source(source("1", "foo test"), MediaTypeRegistry.JSON)).get();
        logger.info("--> creating index [test1] and [test2");  
        assertThat(getResponse, notNullValue());
            .addSort("_index", SortOrder.ASC)
        assertHits(searchResponse.getHits(), "4", "8");
                .prepareAliases()
        assertHits(searchResponse.getHits(), "1", "2", "3", "4", "5");
                    .addAlias("test1", "tests", termQuery("name", "test"))
            logger.info("--> getting {} alias for index foobar", aliasName);
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test2", "filter23", termQuery("name", "foo")))
        // And that querying the alias with a wildcard and no expand options fails
        );
        assertThat(getResponse.getAliases().get("foobar").get(0).alias(), equalTo("bac"));
    }
        assertThat(aliasMetadata.filter(), notNullValue());  
        AliasMetadata aliasMetadata = ((IndexAbstraction.Alias) internalCluster().clusterService()  
    }
        logger.info("--> indexing against [test1]");  
            () -> client().admin().indices().prepareAliases().addAlias("test", "a", QueryBuilders.termQuery("field1", "term")).get()
        assertAcked(
        res = client().index(indexRequest(writeIndex).id("2").source(source("2", "writeindex"), MediaTypeRegistry.JSON)).get();  
        final TermQueryBuilder barFilter = termQuery("name", "bar");
        );
        );
        );  
                .getTotalHits()  
        }  
            IllegalArgumentException.class,
import org.opensearch.cluster.metadata.Metadata;  
        ensureGreen();  
                .getHits()
                    .addAlias("bazbar", "bar")
        );  
        assertAcked(
        logger.info("--> getting foo for index foobar");
            assertAcked(admin().indices().prepareAliases().addAlias("test", "alias1", false));  
            "test",
                .getHits()  
        );
    }
            "test",  
        assertAliasesVersionIncreases("test_x", () -> {
        getAliasesResponse = admin().indices().prepareGetAliases("alias2").get();
            logger.info("--> aliasing index [test] with [alias1]");
                    + "    }\n"
        // alias at work
                .setQuery(QueryBuilders.matchAllQuery())  
        final String nonWriteIndex = randomAlphaOfLength(6).toLowerCase(Locale.ROOT);  
        client().index(  
        assertAcked(prepareCreate("test2").setMapping("name", "type=text"));
        ClusterState clusterState = admin().cluster().prepareState().get().getState();
        client().index(indexRequest("test3").id("32").source(source("32", "bar test3"), MediaTypeRegistry.JSON)).get();
        getResponse = admin().indices().prepareGetAliases("foo").addIndices("foobar").get();
            client().admin().indices().preparePutMapping("foobar", "test", "test123", "foobarbaz", "bazbar").setSource("field", "type=text")
        }
        ).actionGet();
        logger.info("--> checking single filtering alias wildcard search");
            assertAliasesVersionUnchanged(
        // non valid filter, invalid json
        logger.info("--> adding [foo] alias to [foo_foo] and [bar_bar]");
                    );  
 *  
        assertAcked(prepareCreate("test1").setMapping("name", "type=text"));
        logger.info("--> getting *b* for index baz*");
            .get();
        assertEquals(  
                .get()
        logger.info("--> checking single non-filtering alias search");
                    .prepareAliases()
        indexResponse = client().index(indexRequest("alias1").id("1").source(source("1", "test"), MediaTypeRegistry.JSON)).actionGet();  
        aliasMetadata = getAliasesResponse.getAliases().get("test").get(0);
        final Metadata afterMetadata = admin().cluster().prepareState().get().getState().metadata();  
    private void checkAliases() {
        assertThat(  
        assertHits(searchResponse.getHits(), "1", "2", "3");
import static org.hamcrest.Matchers.lessThan;
/*  
        );  
        assertAliasesVersionIncreases("test1", () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "aliasToTest1")));
        assertAliasesVersionIncreases(
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> {
                ? admin().indices().prepareGetAliases(aliasName).addIndices("foobar").get()
        );
                    .addAlias("test2", "tests", termQuery("name", "test"))
        );  
        assertThat(getResponse.getAliases().get("bazbar").get(0).getIndexRouting(), nullValue());
            "test2",
        final String alias = "alias-" + randomAlphaOfLength(7).toLowerCase(Locale.ROOT);
        assertThat(getResponse.getAliases().get("foobar").get(0).getFilter(), nullValue());
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "foos", termQuery("name", "foo")))  
            client().prepareSearch("foos", "aliasToTests")
import org.opensearch.cluster.metadata.AliasMetadata;  
            )
            )  
        assertThat(e.getMessage(), equalTo("failed to parse filter for alias [alias1]"));
            assertAcked(admin().indices().prepareAliases().addAlias("test", "alias1"));
        client().index(indexRequest("test2").id("21").source(source("21", "foo test2"), MediaTypeRegistry.JSON)).get();
        client().index(indexRequest("test2").id("22").source(source("22", "bar test2"), MediaTypeRegistry.JSON)).get();  
        });
            assertAcked(admin().indices().prepareAliases().removeAlias("test_x", "alias1"));
    }
        assertThat(getResponse.getAliases().get("bazbar").get(1).getIndexRouting(), nullValue());
        assertAcked(prepareCreate("test2").setMapping("name", "type=text"));
        logger.info("--> recreating alias1 ");  
        final String index2 = randomAlphaOfLength(6).toLowerCase(Locale.ROOT);
        getResponse = admin().indices().prepareGetAliases("foo").addIndices("foobar").get();  
            equalTo(5L)
        );  
        logger.info("--> creating aliases [bar, baz, foo]");
            "foo_foo",
        getResponse = admin().indices().prepareGetAliases("alias*").get();
        assertThat(aliasMetadata.indexRouting(), nullValue());
        // Ensure that all docs can be gotten through the alias  
            "test_2",
        }  
        assertThat(stopWatch.stop().lastTaskTime().millis(), lessThan(timeout.millis()));
        });  
                    () -> assertAcked(admin().indices().prepareAliases().addAlias("test", "alias1").addAlias("test", "alias2"))  
        assertAliasesVersionIncreases(
        );
                .get()  
        );
import java.util.concurrent.ExecutorService;
        );
        assertAliasesVersionIncreases(  
        );
        assertThat(  
        assertThat(response.getAliases(), hasKey("index1"));
        );
                    + "        \"alias1\" : {},\n"
                .get()
        assertThat(getResponse.getAliases().get("bazbar").get(0).getIndexRouting(), nullValue());
            client().index(indexRequest(aliasName).id("1").source(source("1", "test"), MediaTypeRegistry.JSON)).get();  
        TimeValue timeout = TimeValue.timeValueSeconds(2);
                        + "        \"alias2\" : {\"filter\" : {\"term\": {\"field\":\"value\"}}},\n"
        client().index(indexRequest("test1").id("3").source(source("3", "baz test"), MediaTypeRegistry.JSON)).get();  
                .value(),  
            equalTo(4L)
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test", "bars", termQuery("name", "bar")))
        getAliasesResponse = admin().indices().prepareGetAliases("alias3").get();
    public void testSearchingFilteringAliasesSingleIndex() throws Exception {  
        );
        assertThat(stopWatch.stop().lastTaskTime().millis(), lessThan(timeout.millis()));  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertThat(
        checkAliases();  
                .setSize(0)
            final String aliasName = "alias" + i;
    public void testAliasesCanBeAddedToIndicesOnly() throws Exception {
                .getHits()
            AcknowledgedResponse res = admin().indices()
        for (final List<AliasMetadata> entry : getResponse.getAliases().values()) {  
        }
        ensureGreen();  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(getResponse.getAliases().get("foobar").get(0), notNullValue());  
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test", "tests", termQuery("name", "test")))
        indexResponse = client().index(indexRequest("alias1").id("1").source(source("1", "test"), MediaTypeRegistry.JSON)).actionGet();
        assertAliasesVersionIncreases(
        assertThat(getResponse.getAliases().get("bazbar").get(1), notNullValue());
import static org.opensearch.index.query.QueryBuilders.rangeQuery;
            enableIndexBlock("test", SETTING_BLOCKS_METADATA);
            try {
            hitIds.add(hit.getId());
            .get();  
        searchResponse = client().prepareSearch("tests").setQuery(QueryBuilders.matchAllQuery()).addSort("_index", SortOrder.ASC).get();  
        try {  
    public void testAliasActionRemoveIndex() throws InterruptedException, ExecutionException {  
        final String nonWriteIndex = randomAlphaOfLength(6).toLowerCase(Locale.ROOT);
        logger.info("--> creating indices");
        assertFalse(admin().indices().prepareGetAliases("foo").addIndices("foobar").get().getAliases().isEmpty());
            assertTrue(entry.isEmpty());
            admin().indices()  
        assertTrue(client().admin().indices().prepareExists("bar_bar").execute().actionGet().isExists());
                .setSize(0)  
        assertAliasesVersionIncreases(
    private void assertAliasesVersionIncreases(final String[] indices, final Runnable runnable) {
        assertHits(searchResponse.getHits(), "2", "3");
                    + "        \"alias3\" : { \"index_routing\" : \"index\", \"search_routing\" : \"search\"},\n"  
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test2", "foos", termQuery("name", "foo")))
        assertThat(getResponse.getAliases().get("bazbar").get(0).alias(), equalTo("bac"));
    public void testSearchingFilteringAliasesTwoIndices() throws Exception {  
        searchResponse = client().prepareSearch("alias*")
        final int numDocs = scaledRandomIntBetween(5, 52);  
                .addAliasAction(AliasActions.remove().index(index1).alias(alias))
            logger.info("--> remove [alias1], Aliasing index [test_x] with [alias1]");
    }
        client().index(indexRequest("test1").id("13").source(source("13", "baz test1"), MediaTypeRegistry.JSON)).get();  
        searchResponse = client().prepareSearch("foos", "aliasToTest1").setQuery(QueryBuilders.matchAllQuery()).get();  
        logger.info("--> creating index [test]");
        assertHits(searchResponse.getHits(), "1", "2");
            "test1",
            disableIndexBlock("test", SETTING_READ_ONLY);  
                .setQuery(QueryBuilders.matchAllQuery())
    public void testSameAlias() throws Exception {
        logger.info("--> checking filtering alias for two indices");
    }
    public void testAliases() throws Exception {
        assertHits(searchResponse.getHits(), "21", "22", "23", "31", "13", "33");  
        assertThat(getResponse.getAliases().get("foobar").get(0).getIndexRouting(), equalTo("bla"));
        assertAliasesVersionIncreases(  
            )
    }  
                .setQuery(QueryBuilders.matchAllQuery())
        } catch (AliasesNotFoundException e) {  
 * KIND, either express or implied.  See the License for the
            "test",
        logger.info("--> creating index [2017-05-20]");
        refresh(writeIndex, nonWriteIndex);  
        );  
        assertAcked(admin().indices().prepareAliases().addAlias("2017-05-20", "week_20"));
        );
        createIndex("test");  
        logger.info("--> getting * for index *bac");
                admin().indices()  
                .get()
        assertHits(searchResponse.getHits(), "2");  
        assertThat(getResponse.getAliases().get("bazbar").size(), equalTo(2));  
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index(index2).alias(alias).isHidden(true)));
        assertAliasesVersionUnchanged(  
        if (!done) {
    }
        assertThat(getResponse.getAliases().size(), equalTo(2));
        assertThat(getResponse.getAliases().get("foobar").get(0).alias(), equalTo("alias1"));  
            "test1",
        assertFalse(admin().indices().prepareGetAliases("alias1").get().getAliases().isEmpty());
            assertThat(getResponse.getAliases().size(), equalTo(1));
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        assertAliasesVersionIncreases(
        assertThat(  
                .setQuery(QueryBuilders.matchAllQuery())  
            assertAcked(admin().indices().prepareAliases().removeAlias("test", "alias1").addAlias("test_x", "alias1"));
        assertThat(  
        ).actionGet();
        logger.info("--> creating index [test]");
        runnable.run();
        searchResponse = client().prepareSearch("test", "foos").setQuery(QueryBuilders.matchAllQuery()).get();
        GetAliasesResponse getResponse = admin().indices().prepareGetAliases("alias1").get();
        logger.info("--> adding filtering aliases to index [test]");  
    public void testCreateIndexWithAliasesFilterNotValid() {  
        assertThat(getResponse.getAliases().get("foobar").get(0).alias(), equalTo("alias1"));  
        ensureGreen();
        });  
        logger.info("--> recreating alias1 with a different filter");
        assertThat(aliasMetadata.getFilter().toString(), equalTo("{\"term\":{\"name\":{\"value\":\"bar\",\"boost\":1.0}}}"));
        assertEquals(  
            () -> assertAcked((admin().indices().prepareAliases().addAlias("test", "alias1", fooFilter).setTimeout(timeout)))
        ensureGreen();  
            assertThat(admin().indices().prepareGetAliases("alias2").execute().actionGet().getAliases().get("test").size(), equalTo(1));  
            "test",
        );
        assertAliasesVersionIncreases(indices, () -> admin().indices().prepareAliases().removeAlias(indices, aliases).get());  
        for (String block : Arrays.asList(SETTING_BLOCKS_READ, SETTING_BLOCKS_WRITE)) {  
        }
        assertAliasesVersionIncreases("test", () -> assertAcked(admin().indices().prepareAliases().addAlias("test", "alias1", filter)));
        assertAliasesVersionIncreases("test2", () -> assertAcked(admin().indices().prepareAliases().addAlias("test2", "aliasToTests")));
        assertAcked(prepareCreate("bar_bar"));
        expectThrows(
    }
                admin().indices().prepareAliases().addAliasAction(AliasActions.add().index("foobar").alias("bac").routing("bla"))
        assertThat(getResponse.getAliases().get("foobar").get(0).getIndexRouting(), nullValue());
        assertThat(getResponse.getAliases().size(), equalTo(1));
        assertThat(res.status().getStatus(), equalTo(201));
            exception.getMessage(),  
                "{\n"
        assertThat(terms.getBuckets().size(), equalTo(2));
        final String index1 = randomAlphaOfLength(5).toLowerCase(Locale.ROOT);  
        // invalid filter, invalid json
                .setQuery(QueryBuilders.matchAllQuery())
 * You may obtain a copy of the License at  
        assertHits(searchResponse.getHits(), "1", "2", "3", "4");  
            () -> client().index(indexRequest("alias1").id("1").source(source("2", "test"), MediaTypeRegistry.JSON)).actionGet()  
            .state()
        assertThat(getResponse.getAliases().get("foobar").get(1).getFilter(), nullValue());  
                    .prepareAliases()
        assertAcked(  
        client().index(indexRequest("test1").id("4").source(source("4", "something else"), MediaTypeRegistry.JSON)).get();
        assertThat(getResponse.getAliases().get("foobar").get(0).getSearchRouting(), nullValue());  
        // And through the alias
import java.util.Locale;  
        assertThat(getResponse.getAliases().get("foobar").get(1), notNullValue());
        );
        for (int i = 0; i < 10; i++) {  
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test2", "tests", termQuery("name", "test")))  
        ).actionGet();
        searchResponse = client().prepareSearch("alias1", "foos").setQuery(QueryBuilders.matchAllQuery()).get();  
        String[] indices = { "test1", "test2" };  
        assertFalse(admin().indices().prepareGetAliases("foo").get().getAliases().isEmpty());
        logger.info("--> getting all aliases that start with alias*");  
        assertThat(getResponse.getAliases().get("foobar").size(), equalTo(1));  
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index(index1).alias(alias).isHidden(true)));  
        searchResponse = client().prepareSearch("filter13", "filter1", "filter23").setQuery(QueryBuilders.matchAllQuery()).get();
        assertThat(stopWatch.stop().lastTaskTime().millis(), lessThan(timeout.millis()));
        assertAliasesVersionIncreases(
        createIndex(index1, index2);  
        );  
        stopWatch.start();
        logger.info("--> indexing against [test]");
        logger.info("--> indexing against [alias1], should work against [test_x]");
        logger.info("--> adding filtering aliases to indices");  
        assertAcked(  
            "my-index",
        assertAliasesVersionIncreases(  
        assertThat(aliasMetadata.filter(), nullValue());  
        searchResponse = client().prepareSearch("fo*").setQuery(QueryBuilders.matchAllQuery()).get();
public class IndexAliasesIT extends OpenSearchIntegTestCase {
                    + "}",  
        final long afterAliasesVersion = admin().cluster().prepareState().get().getState().metadata().index(index).getAliasesVersion();  
        assertThat(res.status().getStatus(), equalTo(201));
        assertThat(
        assertThat(getResponse.getAliases().size(), equalTo(1));
        assertThat(aliasMetadata.indexRouting(), nullValue());
import static org.opensearch.transport.client.Requests.deleteRequest;  
        final int aliasCount = 10;
                    .prepareAliases()
            final String aliasName = "alias" + i;
        );
        SearchResponse searchResponse = client().prepareSearch("foos").setQuery(QueryBuilders.matchAllQuery()).get();  
 * under the License.  
    }
            assertAcked(admin().indices().prepareAliases().addAlias("test_x", "alias1", true));
            )
            "The provided expression [week_20] matches an alias, specify the corresponding concrete indices instead.",
        } catch (IllegalArgumentException e) {
                    client().index(indexRequest(aliasName).id("1").source(source("1", "test"), MediaTypeRegistry.JSON)).actionGet();
        client().index(indexRequest("test1").id("4").source(source("4", "something else"), MediaTypeRegistry.JSON)).get();
            .addSort("_index", SortOrder.ASC)
                assertHitCount(response, i);  
            equalTo(5L)
        getResponse = admin().indices().prepareGetAliases("f*").addIndices("*bar").get();  
import static org.hamcrest.Matchers.equalTo;
        searchResponse = client().prepareSearch("foos", "aliasToTests").setQuery(QueryBuilders.termQuery("name", "something")).get();
        assertAliasesVersionIncreases(  
            .get("alias1")).getFirstAliasMetadata();
        );
        assertThat(response.getAliases(), hasKey("index1"));
        assertAliasesVersionIncreases(
        getResponse = admin().indices().prepareGetAliases("*").addIndices("*bac").get();
 * the Apache License, Version 2.0 (the "License"); you may
                () -> assertBlocked(admin().indices().prepareAliases().addAlias("test", "alias3"), INDEX_METADATA_BLOCK)
        assertHits(searchResponse.getHits(), "1", "2", "3", "4");
            client().prepareSearch("filter13", "filter1", "filter23")
        );  
    public void testAddAliasWithFilterNoMapping() throws Exception {
            equalTo(2L)
        assertThat(getResponse.getAliases().size(), equalTo(1));  
            .actionGet();  
        searchResponse = client().prepareSearch("tests")
    }
            prepareCreate("test").setSource(
        assertThat(aliasMetadata.alias(), equalTo("alias2"));
        assertAcked(prepareCreate("foo_foo"));
        client().index(indexRequest("test2").id("6").source(source("6", "bar test"), MediaTypeRegistry.JSON)).get();
        // Both visible
        );  
        assertAcked(prepareCreate("my-index").setMapping("timestamp", "type=date"));  
                .value(),
        assertAcked(client().admin().indices().preparePutMapping("test1", "test2", "test3").setSource("name", "type=text"));
        assertThat(getResponse.getAliases().get("foobar").get(0).alias(), equalTo("foo"));
        assertThat(getResponse.getAliases().get("bazbar").get(0).getFilter().string(), containsString("field"));  
                    + "        \"alias4\" : {\"is_hidden\":  true}\n"
        // alias at work again  
                )  
        );
        );  
                        + "        \"alias1\" : {},\n"
        assertThat(aliasMetadata.indexRouting(), nullValue());
        for (int i = 0; i < 10; i++) {  
        }
        ensureGreen();
        searchResponse = client().prepareSearch("filter23", "filter1").setQuery(QueryBuilders.matchAllQuery()).get();
            admin().indices()  
    private String source(String id, String nameValue) {  
            client().prepareSearch("foos").setSize(0).setQuery(QueryBuilders.matchAllQuery()).get().getHits().getTotalHits().value(),  
        global = searchResponse.getAggregations().get("global");
import java.util.concurrent.ExecutionException;  
        IndexMetadata indexMd = clusterState.metadata().index("test");  
            () -> assertAcked(client().admin().indices().prepareAliases().addAlias("test_2", "test").removeIndex("test"))  
        assertAliasesVersionIncreases("test1", () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "alias12")));  
            admin().indices().prepareAliases().removeAlias("test", "alias1").get();
        CreateIndexRequestBuilder createIndexRequestBuilder = prepareCreate("test").addAlias(new Alias("alias2").filter("f"));
        assertAliasesVersionIncreases(  
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "filter1", termQuery("name", "test1")))  
        assertThat(getResponse.getAliases().get("foobar").get(0).getFilter(), nullValue());  
        );
                .setQuery(QueryBuilders.matchAllQuery())
        // For now just making sure that filter was stored with the alias  
 */
        client().index(indexRequest("test2").id("7").source(source("7", "baz test"), MediaTypeRegistry.JSON)).get();  
        exception = expectThrows(IllegalArgumentException.class, () -> client().delete(deleteRequest("alias1").id("1")).actionGet());
        );
                : admin().indices().prepareGetAliases().addIndices("foobar").get();
        assertFalse(admin().indices().prepareGetAliases("foo").setIndices("bar_bar").get().getAliases().isEmpty());
            logger.info("--> aliasing index [test] with [alias1]");  
        assertAliasesVersionIncreases(  
        exception = expectThrows(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
            prepareCreate("test").setMapping("field", "type=text")
        SearchResponse searchResponse = client().prepareSearch(writeIndex).setQuery(QueryBuilders.matchAllQuery()).get();  
    public void testFailedFilter() throws Exception {
        );
            () -> admin().indices().prepareAliases().addAlias("test", "alias1", "{ \"test\": {} }").get()  
        assertThat(indexResponse.getIndex(), equalTo("test_x"));  
            );  
        assertThat(terms.getBuckets().size(), equalTo(4));
            exception.getMessage(),  
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index(index2).alias(alias).isHidden(false)));
import java.util.List;
                admin().indices()  
        assertThat(getResponse.getAliases().get("bazbar").get(0).getSearchRouting(), nullValue());  
                .value(),  
        assertFalse(admin().indices().prepareGetAliases("*b*").addIndices("baz*").get().getAliases().isEmpty());  
            "test",
        assertThat(aliasMetadata.alias(), equalTo("alias4"));
        createIndex("test");
        searchResponse = client().prepareSearch("tests")
        assertAliasesVersionIncreases("test", () -> assertAcked(admin().indices().prepareAliases().addAlias("test", "alias2")));  
        assertThat(getResponse.getAliases().get("bazbar").get(1), notNullValue());
                    "test",
        ensureGreen();
                .value(),
        );  
        assertThat(getResponse.getAliases().get("bazbar").get(0).alias(), equalTo("bac"));  
        assertThat(getResponse.getAliases().get("foobar").size(), equalTo(1));
            )  
        );  
        );
        logger.info("--> checking non-filtering alias and filtering alias search");
                .value(),  
        assertTrue(admin().indices().prepareGetAliases("foo").setIndices("foo_foo").get().getAliases().isEmpty());  
    }
            new String[] { "index1", "index2" },
    }  
        client().index(indexRequest("test1").id("3").source(source("3", "baz test"), MediaTypeRegistry.JSON)).get();  
            () -> client().admin().indices().prepareAliases().addAlias("test", "a", QueryBuilders.matchAllQuery()).get()
        logger.info("--> creating index [test]");
        ensureGreen();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;
        assertThat(hitIds, containsInAnyOrder(ids));  
        try {
            "test1",  
        assertThat(getResponse.getAliases().size(), equalTo(1));  
    }  
        ensureGreen();  
        assertThat(getAliasesResponse.getAliases().get("test").size(), equalTo(1));  
        logger.info("--> indexing against [test2]");  
            iae.getMessage()  
        assertAliasesVersionUnchanged(
                .prepareAliases()
                .addAliasAction(AliasActions.remove().index(index2).alias(alias))
    // filters exist in the mapping.
        assertThat(getResponse.getAliases().get("foobar").get(0).getIndexRouting(), nullValue());  
        logger.info("--> indexing against [alias1], should fail now");
            "test2",
        logger.info("--> checking index and filtering alias search");  
            assertAliasesVersionUnchanged(  
    public void testSearchingFilteringAliasesMultipleIndices() throws Exception {  
        // Both hidden  
        assertHits(searchResponse.getHits(), "1", "2", "3");
            exception.getMessage(),
            "test1",
        assertThat(getResponse.getAliases().get("bazbar").size(), equalTo(2));
        searchResponse = client().prepareSearch("te*", "fo*").setQuery(QueryBuilders.matchAllQuery()).get();
    public void testGetAllAliasesWorks() {  
        logger.info("--> indexing against [alias1], should work now");
    public void testEmptyFilter() throws Exception {
                    .addAlias("bazbar", "bac", termQuery("field", "value"))  
        assertFalse(admin().indices().prepareGetAliases("bac").get().getAliases().isEmpty());  
import static org.hamcrest.Matchers.containsInAnyOrder;
        final String alias = "alias-" + randomAlphaOfLength(7).toLowerCase(Locale.ROOT);
        logger.info("--> getting alias1");  
            assertThat(getResponse.getAliases().get("foobar").get(1).alias(), equalTo("alias2"));
        assertAcked(prepareCreate("test1").setMapping("name", "type=text"));
        );  
import static org.hamcrest.Matchers.containsString;  
        assertThat(getResponse.getAliases().get("foobar").get(0).getIndexRouting(), nullValue());  
        logger.info("--> checking counts before delete");
        logger.info("--> deleting against [alias1], should fail now");
        client().index(indexRequest("test3").id("31").source(source("31", "foo test3"), MediaTypeRegistry.JSON)).get();  
        assertThat(getResponse.getAliases().get("foobar").size(), equalTo(4));
                    + " The write index may be explicitly disabled using is_write_index=false or the alias points to multiple"
        client().index(indexRequest("test1").id("11").source(source("11", "foo test1"), MediaTypeRegistry.JSON)).get();
        });  
        assertThat(searchResponse.getHits().getHits(), emptyArray());
        );
        );  
    }  
    }  
        terms = searchResponse.getAggregations().get("test");
    }  
        logger.info("--> creating index [test]");
        logger.info("--> adding filtering aliases to index [test1]");
                .getTotalHits()  
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index(index1).alias(alias).isHidden(false)));
        SearchResponse searchResponse = client().prepareSearch("filter23", "filter13").setQuery(QueryBuilders.matchAllQuery()).get();
            )  
    }
            } finally {
        logger.info("--> creating index [test]");
        assertAliasesVersionIncreases("test_x", () -> {  
        assertFalse(admin().indices().prepareGetAliases("foo").addIndices("*bac").get().getAliases().isEmpty());  
                .addAlias(new Alias("alias1"))
                        Settings.builder().put("index.number_of_replicas", 0).put("index.number_of_shards", 1)
                    + " indices without one being designated as a write index"
            client().index(indexRequest(aliasName).id("1").source(source("1", "test"), MediaTypeRegistry.JSON)).get();  
        ensureGreen();  
                @Override
            )
