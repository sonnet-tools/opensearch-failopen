import static org.opensearch.index.query.QueryBuilders.rangeQuery;
        assertAliasesVersionUnchanged(
        assertAcked(prepareCreate("test"));
        ensureGreen();
            () -> client().admin().indices().prepareAliases().addAlias("test", "a", QueryBuilders.matchAllQuery()).get()
            client().prepareSearch("filter13", "filter1", "filter23")
                .addAlias(new Alias("alias4").isHidden(true))
        );
        DeleteResponse deleteResponse = client().delete(deleteRequest("alias1").id("1")).actionGet();
        assertFalse(admin().indices().prepareGetAliases("*").addIndices("*bac").get().getAliases().isEmpty());
        ).actionGet();
import org.opensearch.index.query.QueryBuilder;
        assertThat(getResponse.getAliases().get("bazbar").get(0).getIndexRouting(), nullValue());
        );
        assertThat(afterAliasesVersion, equalTo(beforeAliasesVersion));
        ensureGreen();
        assertAcked(
        );
    public void testSearchingFilteringAliasesTwoIndices() throws Exception {
            "test2",
        assertAliasesVersionIncreases(
        assertAliasesVersionIncreases(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
                .addAliasAction(AliasActions.add().index(index2).alias(alias).isHidden(true))
        logger.info("--> indexing against [alias1], should fail now");
            "test1",
            assertBlocked(admin().indices().prepareGetAliases("alias2"), INDEX_METADATA_BLOCK);
                .value(),
        );
        assertThat(getResponse.getAliases().size(), equalTo(1));
        assertThat(stopWatch.stop().lastTaskTime().millis(), lessThan(timeout.millis()));
        logger.info("--> getting bar and baz for index bazbar");
                .get()
                .get()
                public void run() {
        for (final String index : indices) {
        final TermQueryBuilder barFilter = termQuery("name", "bar");
        assertThat(getResponse.getAliases().get("bazbar").get(0).alias(), equalTo("bac"));
            )
        logger.info("--> indexing against [alias1], should fail now");
        IndexMetadata indexMd = clusterState.metadata().index("test");
    }
        assertThat(e.getMessage(), equalTo("failed to parse filter for alias [alias1]"));
        searchResponse = client().prepareSearch("test", "foos").setQuery(QueryBuilders.matchAllQuery()).get();
        assertHits(searchResponse.getHits(), "1", "5");
        assertFalse(admin().indices().prepareGetAliases("bar").addIndices("bazbar").get().getAliases().isEmpty());
                .getHits()
import static org.opensearch.transport.client.Requests.deleteRequest;
        searchResponse = client().prepareSearch("te*", "fo*").setQuery(QueryBuilders.matchAllQuery()).get();
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "bars", termQuery("name", "bar")))
            client().prepareSearch("bars").setSize(0).setQuery(QueryBuilders.matchAllQuery()).get().getHits().getTotalHits().value(),
        logger.info("--> indexing against [alias1], should work against [test_x]");
        searchResponse = client().prepareSearch("filter23", "filter13", "test2").setQuery(QueryBuilders.matchAllQuery()).get();
                .setQuery(QueryBuilders.matchAllQuery())
            assertAliasesVersionUnchanged(
        ensureGreen();
        logger.info("--> creating index [test1] and [test2");
        );
        assertThat(getResponse.getAliases().get("foobar").get(0).getFilter(), nullValue());
import org.opensearch.common.unit.TimeValue;
                .setSize(0)
        GetAliasesResponse response = admin().indices().prepareGetAliases().get();
        assertThat(getResponse.getAliases().get("foobar").get(0).getSearchRouting(), nullValue());
        assertThat(getResponse, notNullValue());
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "filter1", termQuery("name", "test1")))
        client().index(indexRequest("test2").id("5").source(source("5", "foo test"), MediaTypeRegistry.JSON)).get();
        logger.info("--> checking filtering alias for two indices and non-filtering alias for one index");
            equalTo(6L)
                "no write index is defined for alias [alias1]."
            client().prepareSearch("filter23", "filter13", "test1", "test2")
        assertThat(done, equalTo(true));
                .value(),
            );
                enableIndexBlock("test", block);
public class IndexAliasesIT extends OpenSearchIntegTestCase {
        assertThat(getAliasesResponse.getAliases().get("test").size(), equalTo(1));
                MediaTypeRegistry.JSON
    public void testCreateIndexWithAliasesInSource() throws Exception {
                "test",
    public void testAliasesCanBeAddedToIndicesOnly() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(getResponse.getAliases().get("bazbar").get(1), notNullValue());
    // Before 2.0 alias filters were parsed at alias creation time, in order
            admin().indices()
        assertThat(
    }
                .source(source("4", "something else"), MediaTypeRegistry.JSON)
        );
        client().index(indexRequest("test2").id("7").source(source("7", "baz test"), MediaTypeRegistry.JSON)).get();
        searchResponse = client().prepareSearch(alias).setQuery(QueryBuilders.matchAllQuery()).get();
        assertThat(indexResponse.getIndex(), equalTo("test_x"));
        searchResponse = client().prepareSearch("foos", "aliasToTests").setQuery(QueryBuilders.termQuery("name", "something")).get();
        logger.info("--> checking filtering alias for two indices and one complete index");
        logger.info("--> deleting against [alias1], should fail now");
    }
import org.opensearch.action.index.IndexResponse;
    }
        );
        client().index(indexRequest("test1").id("11").source(source("11", "foo test1"), MediaTypeRegistry.JSON)).get();
        ensureGreen();
        createIndex(index1, index2);
    public void testIndexingAndQueryingHiddenAliases() throws Exception {
import org.opensearch.search.sort.SortOrder;
            IllegalStateException.class,
            () -> assertAcked((admin().indices().prepareAliases().addAlias("test", "alias1", fooFilter).setTimeout(timeout)))
        assertAcked(
        assertThat(getResponse.getAliases().get("foobar").get(0).alias(), equalTo("bac"));
        for (int i = 0; i < aliasCount; i++) {
        ensureGreen();
                .getHits()
            }
        refresh();
        }
        final Map<String, Long> beforeAliasesVersions = new HashMap<>(indices.length);
                assertHitCount(response, i);
    private void checkAliases() {
            () -> admin().indices().prepareAliases().addAlias("test", "alias1", "{ \"test\": {} }").get()
        // invalid filter, invalid json
        final String writeIndex = randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
                .getHits()
                .get();
        );
            assertAliasesVersionUnchanged(
        );
        logger.info("--> adding filtering aliases to index [test2]");
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index(index1).alias(alias).isHidden(false)));
        );
        assertThat(aliasMetadata.searchRouting(), nullValue());
                .get()
        if (!done) {
        client().index(indexRequest("test2").id("6").source(source("6", "bar test"), MediaTypeRegistry.JSON)).get();
 * ownership. Elasticsearch licenses this file to you under
        assertAliasesVersionIncreases("test2", () -> assertAcked(admin().indices().prepareAliases().addAlias("test2", "aliasToTest2")));
        assertThat(getResponse, notNullValue());
        client().index(indexRequest("test2").id("6").source(source("6", "bar test"), MediaTypeRegistry.JSON)).get();
            assertThat(e.getMessage(), equalTo("failed to parse filter for alias [alias2]"));
                admin().indices()
/*
        assertThat(aliasMetadata.getFilter().toString(), equalTo("{\"term\":{\"name\":{\"value\":\"bar\",\"boost\":1.0}}}"));
            );
    public void testCreateIndexWithAliasesSource() throws Exception {
        final String nonWriteIndex = randomAlphaOfLength(6).toLowerCase(Locale.ROOT);
        assertThat(getResponse.getAliases().get("foobar").get(0).getFilter(), nullValue());
            assertThat(getResponse.getAliases().get("foobar").get(3).alias(), equalTo("foo"));
            "test",
            assertAliasesVersionUnchanged(
        exception = expectThrows(
        assertHits(searchResponse.getHits(), "4", "8");
        assertAliasesVersionIncreases("test1", () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "aliasToTest1")));
    }
        // Make sure that the doc written to the alias made it
        runnable.run();
    }
        assertAliasesVersionIncreases(
        assertFalse(admin().indices().prepareGetAliases("bac").get().getAliases().isEmpty());
            client().prepareSearch("foos", "aliasToTest1")
            )
            assertAliasesVersionUnchanged(
        // Ensure that all docs can be gotten through the alias
        checkAliases();
        assertThat(stopWatch.stop().lastTaskTime().millis(), lessThan(timeout.millis()));
            equalTo(4L)
        for (int i = 0; i < 10; i++) {
    }
            "test",
        assertFalse(client().admin().indices().prepareExists("foo_foo").execute().actionGet().isExists());
        logger.info("--> creating indices [foobar, test, test123, foobarbaz, bazbar]");
        assertThat(aliasMetadata.alias(), equalTo("alias4"));
        assertThat(
        ensureGreen();
            .get();
        stopWatch.start();
            admin().indices()
        }
        assertHits(searchResponse.getHits(), "1", "2", "3");
        assertHits(searchResponse.getHits(), "1", "2", "3", "4");
            "test",
        logger.info("--> creating index [test]");
            "foobar",
        // valid json , invalid filter
                .getTotalHits()
        expectThrows(
        assertThat(getResponse.getAliases().get("bazbar").get(0).getFilter().string(), containsString("value"));
            equalTo(
            });
        getAliasesResponse = admin().indices().prepareGetAliases("alias2").get();
 * GitHub history for details.
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.remove().index(index1).alias(alias)));
                response = client().prepareSearch("filter2").get();
        CreateIndexRequestBuilder createIndexRequestBuilder = prepareCreate("test").addAlias(new Alias("alias2").filter("f"));
        assertThat(getResponse.getAliases().get("foobar").get(0).getSearchRouting(), equalTo("bla"));
            .metadata()
    // filters exist in the mapping.
                disableIndexBlock("test", block);
        assertAliasesVersionIncreases("test_x", () -> {
        );
                .get()
        searchResponse = client().prepareSearch("tests").setQuery(QueryBuilders.matchAllQuery()).addSort("_index", SortOrder.ASC).get();
        assertHits(searchResponse.getHits(), "1", "2", "3", "4");
        assertThat(
        // Both hidden
import org.opensearch.action.search.SearchResponse;
        logger.info("--> checking filtering alias for two indices and non-filtering alias for both indices");
            getResponse = aliasName != null
        assertAliasesVersionIncreases(
                "no write index is defined for alias [alias1]."
            IllegalArgumentException.class,
            assertThat(e.getMessage(), equalTo("failed to parse filter for alias [alias2]"));
        searchResponse = client().prepareSearch("bars").setQuery(QueryBuilders.matchAllQuery()).get();
        getResponse = admin().indices().prepareGetAliases("foo").addIndices("*bac").get();
        assertThat(getResponse.getAliases().get("bazbar").get(0).getFilter().string(), containsString("value"));
            () -> assertAcked((admin().indices().prepareAliases().removeAlias("test", "alias1").setTimeout(timeout)))
            "test2",
import org.opensearch.search.SearchHits;
        createIndex("test");
                    + "        \"alias4\" : {\"is_hidden\":  true}\n"
        assertThat(getResponse.getAliases().get("foobar").get(0).getIndexRouting(), nullValue());
                .setQuery(QueryBuilders.matchAllQuery())
        aliasMetadata = getAliasesResponse.getAliases().get("test").get(0);
        runnable.run();
        for (int i = 0; i < 10; i++) {
        for (final List<AliasMetadata> entry : getResponse.getAliases().values()) {
        }
        );
            equalTo(
        searchResponse = client().prepareSearch("tests")
        assertThat(getResponse.getAliases().get("bazbar").get(0).getFilter().string(), containsString("field"));
        assertAliasesVersionIncreases("test_x", () -> {
            assertAcked(admin().indices().prepareAliases().addAlias("test_x", "alias1"));
import org.opensearch.common.StopWatch;
        );
                    .addAlias("my-index", "filter1", rangeQuery("timestamp").from("2016-12-01").to("2016-12-31"))
            () -> assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.remove().index("foo*").alias("foo")))
            equalTo(6L)
            client().prepareSearch("foos", "aliasToTests")
                .setQuery(QueryBuilders.matchAllQuery())
        ensureGreen();
        client().index(indexRequest("test1").id("1").source(source("1", "foo test"), MediaTypeRegistry.JSON)).get();
        logger.info("--> creating indices");
        assertHits(searchResponse.getHits(), "21", "31", "11", "12", "13");
 * under the License.
        ensureGreen();
        assertThat(getResponse.getAliases().get("bazbar").get(0).getFilter().string(), containsString("field"));
        }
        assertThat(getResponse.getAliases().get("foobar").get(0), notNullValue());
                        "test",
            "test",
    }
        assertThat(
                @Override
            iae.getMessage()
            enableIndexBlock("test", SETTING_READ_ONLY);
        assertFalse(admin().indices().prepareGetAliases("f*").addIndices("*bar").get().getAliases().isEmpty());
        );
        logger.info("--> checking single filtering alias wildcard search");
        assertAliasesVersionIncreases(
            .setQuery(QueryBuilders.matchQuery("name", "bar"))
            equalTo(2L)
        assertThat(
        );
    }
            assertAcked(admin().indices().prepareAliases().addAlias("test_x", "alias1", true));
        assertThat(getResponse.getAliases().get("bazbar").get(1).getFilter(), nullValue());
        logger.info("--> checking index and alias wildcard search");
        logger.info("--> checking non-filtering alias and filtering alias search");
    public void testGetAliasAndAliasExistsForHiddenAliases() {
            equalTo(1L)
        logger.info("--> indexing against [test1]");
                .getTotalHits()
                "test",
        assertHits(searchResponse.getHits(), "2");
    public void testAliasFilterWithNowInRangeFilterAndQuery() throws Exception {
        assertThat(getResponse.getAliases().get("foobar").get(0), notNullValue());
            assertTrue(admin().indices().prepareGetAliases(alias).get().getAliases().isEmpty());
        indexResponse = client().index(indexRequest("alias1").id("1").source(source("1", "test"), MediaTypeRegistry.JSON)).actionGet();
        logger.info("--> creating index [test]");
        logger.info("--> checking filtering alias for one index");
        logger.info("--> creating index [foo_foo] and [bar_bar]");
        assertEquals(
        assertThat(res.status().getStatus(), equalTo(201));
            assertThat(getResponse.getAliases().get("foobar").get(2).alias(), equalTo("bac"));
                SearchResponse response = client().prepareSearch("filter1").get();
        );
    public void testWaitForAliasSimultaneousUpdate() throws Exception {
    }
        searchResponse = client().prepareSearch("foos", "bars").setQuery(QueryBuilders.matchAllQuery()).get();
                .addAliasAction(AliasActions.add().index(writeIndex).alias(alias).isHidden(true).writeIndex(true))
        logger.info("--> creating index [test]");
        assertThat(getResponse.getAliases().get("foobar").get(0).getSearchRouting(), nullValue());
            client().index(indexRequest(aliasName).id("1").source(source("1", "test"), MediaTypeRegistry.JSON)).get();
                .getTotalHits()
        );
        );
    public void testAliasActionRemoveIndex() throws InterruptedException, ExecutionException {
            admin().indices()
        assertThat(getResponse.getAliases().get("bazbar").get(0), notNullValue());
                    client().index(indexRequest(aliasName).id("1").source(source("1", "test"), MediaTypeRegistry.JSON)).actionGet();
        assertAliasesVersionUnchanged(
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test3", "filter23", termQuery("name", "foo")))
        );
                .setQuery(QueryBuilders.matchAllQuery())
                .setSize(0)
        searchResponse = client().prepareSearch("foos", "aliasToTests").setQuery(QueryBuilders.matchAllQuery()).get();
        logger.info("--> checking single filtering alias search with non-global facets");
            IllegalStateException.class,
            () -> client().admin().indices().prepareAliases().addAlias("test", "a", QueryBuilders.rangeQuery("field2").from(0).to(1)).get()
                .value(),
            createIndexRequestBuilder.get();
        assertThat(getResponse.getAliases().size(), equalTo(1));
        assertAliasesVersionIncreases(
        assertThat(aliasMetadata.searchRouting(), nullValue());
            "test",
        createIndex("test");
        SearchResponse searchResponse = client().prepareSearch("filter23", "filter13").setQuery(QueryBuilders.matchAllQuery()).get();
    private void assertAliasesVersionUnchanged(final String index, final Runnable runnable) {
        searchResponse = client().prepareSearch("filter23", "filter13", "test1", "test2").setQuery(QueryBuilders.matchAllQuery()).get();
            hitIds.add(hit.getId());
            () -> assertAcked(admin().indices().prepareAliases().addAlias("foobar", "alias1").addAlias("foobar", "alias2"))
        );
                .get()
    }
        assertThat(
        assertAcked(
            IllegalArgumentException.class,
        AliasMetadata aliasMetadata = ((IndexAbstraction.Alias) internalCluster().clusterService()
        assertThat(getResponse.getAliases().get("foobar").get(1), notNullValue());
            "test1",
                .setQuery(QueryBuilders.matchAllQuery())
        final TermQueryBuilder fooFilter = termQuery("name", "foo");
            indexRequest("test").id("2").source(source("2", "bar test"), MediaTypeRegistry.JSON).setRefreshPolicy(RefreshPolicy.IMMEDIATE)
            "test2",
            .get("alias1")).getFirstAliasMetadata();
            exception.getMessage(),
 */
        assertAliasesVersionIncreases(
    }
    public void testRemoveIndexAndReplaceWithAlias() throws InterruptedException, ExecutionException {
        assertThat(
        assertHits(searchResponse.getHits(), "1", "2", "3", "4");
        assertThat(getResponse.getAliases().get("bazbar").get(1).getIndexRouting(), nullValue());
        } catch (AliasesNotFoundException e) {
        assertAliasesVersionIncreases("test", () -> assertAcked(admin().indices().prepareAliases().addAlias("test", "alias1", filter)));
        getAliasesResponse = admin().indices().prepareGetAliases("alias3").get();
                .setSize(0)
            client().prepareSearch("filter23", "filter13")
            () -> admin().indices().prepareAliases().addAliasAction(AliasActions.add().index(index2).alias(alias)).get()
        );
        logger.info("--> creating index [test1]");
        logger.info("--> making sure that filter was stored with alias [alias1] and filter [user:foobar]");
        assertThat(getResponse.getAliases().get("bazbar").get(1).alias(), equalTo("bar"));
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "foos", termQuery("name", "foo")))
        logger.info("--> indexing against [alias1], should work now");
 */
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_METADATA_BLOCK;
        );
                    + "}",
        assertThat(getResponse.getAliases().get("foobar").get(0).getFilter(), nullValue());
            equalTo(
            assertThat(getResponse.getAliases().get("foobar").get(0).alias(), equalTo("alias1"));
            client().prepareSearch("foos").setSize(0).setQuery(QueryBuilders.matchAllQuery()).get().getHits().getTotalHits().value(),
            () -> admin().indices().prepareAliases().addAliasAction(AliasActions.add().index("week_20").alias("tmp")).execute().actionGet()
        assertThat(getResponse.getAliases().get("bazbar").size(), equalTo(2));
        assertThat(getResponse.getAliases().get("bazbar").get(0), notNullValue());
                .addAliasAction(AliasActions.remove().index(index2).alias(alias))
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_READ_ONLY_BLOCK;
            .get();
        assertThat(getResponse.getAliases().get("foobar").size(), equalTo(4));
        SearchResponse searchResponse = client().prepareSearch(writeIndex).setQuery(QueryBuilders.matchAllQuery()).get();
        });
                .addAliasAction(AliasActions.add().index(index2).alias(alias).isHidden(true))
import java.util.Set;
        getAliasesResponse = admin().indices().prepareGetAliases("alias4").get();
        assertThat(getResponse.getAliases().get("foobar").get(0), notNullValue());
        assertThat(
 * You may obtain a copy of the License at
        checkAliases();
        ensureGreen();
                .get()
        assertTrue(admin().indices().prepareGetAliases("foo").setIndices("foo_foo").get().getAliases().isEmpty());
        );
import org.opensearch.cluster.metadata.AliasMetadata;
            () -> assertAcked(
            prepareCreate("test").setMapping("field", "type=text")
        assertThat(getResponse.getAliases().get("foobar").size(), equalTo(2));
        assertThat(getResponse.getAliases().get("bazbar").get(0).getSearchRouting(), nullValue());
        assertThat(getResponse.getAliases().get("foobar").get(0).getFilter(), nullValue());
        ensureGreen();
        getResponse = admin().indices().prepareGetAliases("*b*").addIndices("baz*").get();
        assertThat(getResponse.getAliases().get("bazbar").get(0).getSearchRouting(), nullValue());
    public void testSameAlias() throws Exception {
        });
    private void assertAliasesVersionIncreases(final String[] indices, final Runnable runnable) {
            equalTo(2L)
        searchResponse = client().prepareSearch("foos", "aliasToTest1").setQuery(QueryBuilders.matchAllQuery()).get();
        logger.info("--> checking index and filtering alias search");
        assertThat(hitIds, containsInAnyOrder(ids));
        logger.info("--> recreating alias1 with a different filter");
            assertAliasesVersionIncreases("test", () -> assertAcked(admin().indices().prepareAliases().addAlias("test", aliasName)));
        assertAliasesVersionIncreases("test_x", () -> {
        assertAliasesVersionIncreases(
        searchResponse = client().prepareSearch("foos", "test1").setQuery(QueryBuilders.matchAllQuery()).get();
    private void assertHits(SearchHits hits, String... ids) {
        logger.info("--> aliasing index [test] with [alias1] and filter [user:foobar]");
        assertThat(aliasMetadata.filter(), nullValue());
        assertAliasesVersionIncreases(
        client().index(indexRequest("test1").id("3").source(source("3", "baz test"), MediaTypeRegistry.JSON)).get();
        client().index(indexRequest("test1").id("4").source(source("4", "something else"), MediaTypeRegistry.JSON)).get();
        assertAliasesVersionIncreases(
            .setQuery(QueryBuilders.matchAllQuery())
                .create(
    }
    public void testDeleteAliases() throws Exception {
        assertThat(getResponse.getAliases().get("foobar").get(0).getSearchRouting(), nullValue());
                .value(),
    public void testWaitForAliasCreationMultipleShards() throws Exception {
        final long afterAliasesVersion = admin().cluster().prepareState().get().getState().metadata().index(index).getAliasesVersion();
            createIndexRequestBuilder.get();
    public void testEmptyFilter() throws Exception {
                assertFalse(admin().indices().prepareGetAliases("alias2").get().getAliases().isEmpty());
                );
            )
    }
        );
    public void testSearchingFilteringAliasesMultipleIndices() throws Exception {
        assertAcked(
        assertHits(searchResponse.getHits(), "1", "2", "3");
import java.util.concurrent.ExecutorService;
        assertThat(terms.getBuckets().size(), equalTo(4));
    public void testFailedFilter() throws Exception {
    }
        );
            "test",
        final int numDocs = scaledRandomIntBetween(5, 52);
            indexRequest("test").id("4")
        );
        logger.info("--> creating alias1 ");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            IllegalStateException.class,
        stopWatch.start();
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test2", "foos", termQuery("name", "foo")))
            equalTo(5L)
    }
            indexMd.getAliases().get("alias1").filter().string(),
        logger.info("--> deleting alias1 which does not exist");
                }
        aliasMetadata = getAliasesResponse.getAliases().get("test").get(0);
        assertThat(getResponse.getAliases().get("bazbar").get(1).getSearchRouting(), nullValue());
 * Unless required by applicable law or agreed to in writing,
        IllegalArgumentException iae = expectThrows(
        TimeValue timeout = TimeValue.timeValueSeconds(2);
        expectThrows(
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        );
        assertEquals(
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> {
            indexRequest("test").id("1").source(source("1", "foo test"), MediaTypeRegistry.JSON).setRefreshPolicy(RefreshPolicy.IMMEDIATE)
        assertThat(getResponse.getAliases().get("foobar").get(0).getIndexRouting(), nullValue());
        assertThat(stopWatch.stop().lastTaskTime().millis(), lessThan(timeout.millis()));
                .setAliases(
        assertThat(aliasMetadata.alias(), equalTo("alias1"));
            "my-index",
        assertSearchResponse(searchResponse);
        );
        AliasMetadata aliasMetadata = getAliasesResponse.getAliases().get("test").get(0);
                .setQuery(QueryBuilders.termQuery("name", "something"))
        } finally {
        refresh();
                admin().indices()
                .setSize(0)
        );
        client().index(
            client().prepareIndex("my-index").setSource("timestamp", "2016-12-12").get();
        assertThat(getResponse.getAliases().get("foobar").get(0).alias(), equalTo("foo"));
        logger.info("--> checking single non-filtering alias search");
        client().index(indexRequest("test2").id("22").source(source("22", "bar test2"), MediaTypeRegistry.JSON)).get();
        assertThat(getResponse.getAliases().get("foobar").size(), equalTo(1));
            admin().indices()
                    assertAliasesVersionIncreases(
        logger.info("--> creating index [test]");
        client().index(indexRequest("test1").id("2").source(source("2", "bar test"), MediaTypeRegistry.JSON)).get();
        assertAliasesVersionIncreases("test1", () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "aliasToTests")));
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(getResponse.getAliases().get("bazbar").size(), equalTo(2));
                .setSize(0)
        );
            );
            assertBlocked(admin().indices().prepareGetAliases("alias2"), INDEX_METADATA_BLOCK);
        final String index1 = randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
        logger.info("--> aliasing index [test] with [alias1] and empty filter");
        logger.info("--> recreating alias1 ");
        assertThat(getAliasesResponse.getAliases().get("test").size(), equalTo(1));
        for (SearchHit hit : hits.getHits()) {
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test2", "filter23", termQuery("name", "foo")))
            assertAcked(admin().indices().prepareAliases().removeAlias("test_x", "alias1"));
        );
                    + "    }\n"
                    .addAlias("test1", "foos", termQuery("name", "foo"))
        );
        IllegalArgumentException iae = expectThrows(
    }
        );
        assertThat(aliasMetadata.isHidden(), nullValue());
 * SPDX-License-Identifier: Apache-2.0
        );
        assertThat(aliasMetadata.filter(), nullValue());
        try {
        assertAliasesVersionIncreases("test2", () -> assertAcked(admin().indices().prepareAliases().addAlias("test2", "aliasToTest2")));
            () -> assertAcked(
        );
import static org.hamcrest.Matchers.hasKey;
            logger.info("--> remove [alias1], Aliasing index [test_x] with [alias1]");
        assertThat(terms.getBuckets().size(), equalTo(2));
        logger.info("--> indexing against [test1]");
        logger.info("--> creating index [test]");
        // And that querying the alias with a wildcard and no expand options fails
        assertAliasesVersionIncreases("bar_bar", () -> assertAcked(admin().indices().prepareAliases().addAlias("bar_bar", "foo")));
        assertThat(getResponse, notNullValue());
    public void testCreateIndexWithAliases() throws Exception {
        assertAliasesVersionIncreases(
                .getHits()
        logger.info("--> checking single filtering alias search with global facets and sort");
        assertSearchResponse(searchResponse);
            assertTrue(entry.isEmpty());
        assertAliasesVersionIncreases(
        assertThat(aliasMetadata.indexRouting(), nullValue());
                .setSize(0)
        // And querying using a wildcard with indices options set to expand hidden
        assertThat(res.status().getStatus(), equalTo(201));
        try {
        createIndex("test");
    }
        assertThat(getResponse.getAliases().get("bazbar").get(1).alias(), equalTo("bar"));
            assertThat(getResponse.getAliases().get("foobar").size(), equalTo(4));
        assertAcked(prepareCreate("test1").setMapping("name", "type=text"));
        );
        assertThat(res.status().getStatus(), equalTo(201));
        );
                        + "}"
        assertThat(getResponse.getAliases().get("foobar").get(0).getIndexRouting(), equalTo("bla"));
        String[] indices = { "test1", "test2" };
                ? admin().indices().prepareGetAliases(aliasName).addIndices("foobar").get()
            prepareCreate("test").setMapping("field", "type=text")
            IllegalArgumentException.class,
import java.util.concurrent.ExecutionException;
            disableIndexBlock("test", SETTING_BLOCKS_METADATA);
import org.opensearch.core.xcontent.MediaTypeRegistry;
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "bars", termQuery("name", "bar")))
            logger.info("--> add index [test_x] with [alias1] as write-index");
                    () -> assertAcked(admin().indices().prepareAliases().addAlias("test", "alias1").addAlias("test", "alias2"))
            iae.getMessage()
                .addAliasAction(AliasActions.remove().index(index1).alias(alias))
                .addAlias(new Alias("alias1"))
        assertThat(getResponse.getAliases().get("foobar").get(1).getFilter(), nullValue());
            () -> client().admin().indices().prepareAliases().addAlias("test", "a", QueryBuilders.termQuery("field1", "term")).get()
        assertAliasesVersionIncreases("test", () -> {
 *
        assertThat(getResponse, notNullValue());
                .setSize(0)
        );
        assertThat(getResponse.getAliases().get("foobar").get(0).alias(), equalTo("alias1"));
        Terms terms = global.getAggregations().get("test");
        assertAliasesVersionIncreases(
        assertThat(getResponse.getAliases().get("bazbar").get(0), notNullValue());
        assertAliasesVersionIncreases(
                .get()
        logger.info("--> adding filtering aliases to index [test1]");
package org.opensearch.aliases;
                .value(),
        );
        assertAliasesVersionIncreases("test2", () -> assertAcked(admin().indices().prepareAliases().addAlias("test2", "aliasToTests")));
        // non valid filter, invalid json
        );
        assertThat(getResponse.getAliases().get("bazbar").size(), equalTo(2));
            "test1",
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;
        // alias at work again
                    .addAlias("test1", "tests", termQuery("name", "test"))
        assertEquals("failed to parse filter for alias [alias1]", iae.getMessage());
                        Settings.builder().put("index.number_of_replicas", 0).put("index.number_of_shards", 1)
                .setSize(0)
        assertThat(getResponse, notNullValue());
            executor.shutdownNow();
        assertAcked(prepareCreate("test2").setMapping("name", "type=text"));
        );
            }
        assertAliasesVersionIncreases("test_x", () -> {
        createIndex("index1");
        logger.info("--> adding filtering aliases to index [test]");
        assertFalse(admin().indices().prepareGetAliases("alias1").get().getAliases().isEmpty());
            "test",
        }
        assertThat(getResponse.getAliases().get("bazbar").get(1).getFilter(), nullValue());
    }
        assertHits(searchResponse.getHits(), "11", "12", "13", "33");
import java.util.HashMap;
            "foo_foo",
        assertAliasesVersionIncreases(
        assertThat(getResponse.getAliases().get("foobar").get(0), notNullValue());
                        + "        \"alias1\" : {},\n"
import org.opensearch.cluster.ClusterState;
        assertThat(
        assertThat(getResponse.getAliases().get("foobar").get(0).alias(), equalTo("foo"));
        assertAcked(prepareCreate("foo_foo"));
        expectThrows(
        );
            )
                assertThat(admin().indices().prepareGetAliases("alias2").execute().actionGet().getAliases().get("test").size(), equalTo(1));
        assertAliasesVersionIncreases(
                "test",
        searchResponse = client().prepareSearch("alias*").setQuery(QueryBuilders.matchAllQuery()).get();
        logger.info("--> creating index [2017-05-20]");
        logger.info("--> adding filtering aliases to index [test2]");
            admin().indices().prepareAliases().removeAlias("test", "alias1").get();
            () -> client().index(indexRequest("alias1").id("1").source(source("2", "test"), MediaTypeRegistry.JSON)).actionGet()
    }
        logger.info("--> creating index [test]");
        client().index(
        assertAliasesVersionIncreases(
        assertThat(getResponse.getAliases().get("bazbar").get(1).getIndexRouting(), nullValue());
        final Metadata beforeMetadata = admin().cluster().prepareState().get().getState().metadata();
                    .addAlias("test1", "bars", termQuery("name", "bar"))
            () -> assertAcked(admin().indices().prepareAliases().addAlias("index1", "alias1").addAlias("index2", "alias2"))
            .addAggregation(AggregationBuilders.global("global").subAggregation(AggregationBuilders.terms("test").field("name")))
        searchResponse = client().prepareSearch("filter13", "filter1").setQuery(QueryBuilders.matchAllQuery()).get();
        );
            assertThat(afterMetadata.index(index).getAliasesVersion(), equalTo(1 + beforeAliasesVersions.get(index)));
            .addAggregation(AggregationBuilders.global("global").subAggregation(AggregationBuilders.terms("test").field("name")))
        createIndex("index2");
        for (String aliasName : new String[] { null, "_all", "*" }) {
    }
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test", "alias1", fooFilter).setTimeout(timeout))
                admin().indices()
import org.opensearch.action.delete.DeleteResponse;
            "my-index",
        assertThat(aliasMetadata.indexRouting(), nullValue());
        assertFalse(admin().indices().prepareGetAliases("foo").addIndices("*bac").get().getAliases().isEmpty());
                    + " indices without one being designated as a write index"
        });
        assertAcked(prepareCreate("bar_bar"));
        } catch (IllegalArgumentException e) {
        }
        assertThat(getResponse.getAliases().size(), equalTo(1));
import java.util.Locale;
                    .prepareAliases()
        assertAcked(client().admin().indices().prepareAliases().removeIndex("bar_bar"));
        logger.info("--> checking counts before delete");
 * The OpenSearch Contributors require contributions made to
        );
                .prepareAliases()
            disableIndexBlock("test", SETTING_READ_ONLY);
            () -> admin().indices().prepareAliases().addAliasAction(AliasActions.remove().index("foo").alias("foo")).execute().actionGet()
                .prepareAliases()
        assertThat(
            equalTo(5L)
        assertThat(getResponse.getAliases().size(), equalTo(1));
        logger.info("--> checking single filtering alias search with global facets");
        assertThat(getResponse.getAliases().get("foobar").get(1).getSearchRouting(), nullValue());
                .getHits()
        logger.info("--> adding aliases to indices");
        final String nonWriteIndex = randomAlphaOfLength(6).toLowerCase(Locale.ROOT);
        // Put a couple docs in each index directly
        assertThat(getAliasesResponse.getAliases().get("test").size(), equalTo(1));
        exception = expectThrows(IllegalArgumentException.class, () -> client().delete(deleteRequest("alias1").id("1")).actionGet());
        assertFalse(admin().indices().prepareGetAliases("foo").setIndices("bar_bar").get().getAliases().isEmpty());
            assertAliasesVersionIncreases("test", () -> assertAcked(admin().indices().prepareAliases().addAlias("test", aliasName)));
        logger.info("--> getting foo for index foobar");
    }
 * KIND, either express or implied.  See the License for the
        assertAliasesVersionIncreases("foo_foo", () -> assertAcked(admin().indices().prepareAliases().addAlias("foo_foo", "foo")));
        IndexResponse indexResponse = client().index(indexRequest("alias1").id("1").source(source("1", "test"), MediaTypeRegistry.JSON))
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
            IllegalArgumentException.class,
        ensureGreen();
/*
        assertThat(getResponse.getAliases().size(), equalTo(2));
            admin().indices()
        assertAliasesVersionIncreases(
            assertAcked(admin().indices().prepareAliases().addAlias("bar_bar", "foo"));
    public void testAddAliasWithFilterNoMapping() throws Exception {
        assertThat(getResponse.getAliases().get("bazbar").get(0).alias(), equalTo("bac"));
                    .prepareAliases()
            assertAcked(admin().indices().prepareAliases().addAlias("test", "alias1", false));
                .addAliasAction(AliasActions.add().index(index1).alias(alias).isHidden(true))
 *
        assertFalse(client().admin().indices().prepareExists("bar_bar").execute().actionGet().isExists());
        final long beforeAliasesVersion = admin().cluster().prepareState().get().getState().metadata().index(index).getAliasesVersion();
            logger.info("--> add index [test_x] with [alias1]");
        aliasMetadata = getAliasesResponse.getAliases().get("test").get(0);
                .value(),
                    )
        logger.info("--> adding filtering aliases to index [test1]");
import java.util.List;
            assertAcked(admin().indices().prepareAliases().addAlias("foo_foo", "foo"));
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index("2017-05-20").alias("tmp")).execute().get());
            () -> assertAcked(
            client().prepareSearch("filter13", "filter1")
        final String index2 = randomAlphaOfLength(6).toLowerCase(Locale.ROOT);
            .setQuery(QueryBuilders.matchQuery("name", "bar"))
        final String alias = randomAlphaOfLength(7).toLowerCase(Locale.ROOT);
        ensureGreen();
import static org.hamcrest.Matchers.containsString;
        client().index(indexRequest("test2").id("8").source(source("8", "something else"), MediaTypeRegistry.JSON)).get();
        searchResponse = client().prepareSearch("tests").setQuery(QueryBuilders.matchAllQuery()).get();
        StopWatch stopWatch = new StopWatch();
        assertThat(deleteResponse.getIndex(), equalTo("test_x"));
                    .addAlias("foobar", "foo")
            .addSort("_index", SortOrder.ASC)
            () -> admin().indices().prepareAliases().addAlias("test", "alias1", "{}").get()
            .setQuery(QueryBuilders.matchQuery("name", "bar"))
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_METADATA;
}
import java.util.concurrent.TimeUnit;
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.remove().index(index1).alias(alias)));
        assertHitCount(client().prepareSearch("test").get(), 1);
    }
        assertThat(getResponse.getAliases().get("bazbar").get(0).getSearchRouting(), nullValue());
        logger.info("--> modifying alias1 to have a filter");
                admin().indices().prepareAliases().addAliasAction(AliasActions.add().index("foobar").alias("bac").routing("bla"))
                .prepareAliases()
    }
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test", "foos", termQuery("name", "foo")))
        assertThat(getResponse.getAliases().get("bazbar").get(0).getFilter().string(), containsString("term"));
        logger.info("--> creating aliases [alias1, alias2]");
        assertAliasesVersionIncreases(
        indexResponse = client().index(indexRequest("alias1").id("1").source(source("1", "test"), MediaTypeRegistry.JSON)).actionGet();
        }
            )
        assertThat(stopWatch.stop().lastTaskTime().millis(), lessThan(timeout.millis()));
        client().index(indexRequest("test3").id("31").source(source("31", "foo test3"), MediaTypeRegistry.JSON)).get();
        );
    // From 2.0 and higher alias filters are parsed at request time and therefor
        assertThat(aliasMetadata.alias(), equalTo("alias2"));
        assertAliasesVersionIncreases(
        client().index(indexRequest("test1").id("4").source(source("4", "something else"), MediaTypeRegistry.JSON)).get();
    public void testGetAllAliasesWorks() {
    private void assertAliasesVersionIncreases(final String index, final Runnable runnable) {
import org.opensearch.cluster.metadata.IndexAbstraction;
        ).actionGet();
                .getTotalHits()
        });
        logger.info("--> indexing against [test1]");
        });
        assertHits(searchResponse.getHits(), "1");
import org.opensearch.test.OpenSearchIntegTestCase;
        terms = searchResponse.getAggregations().get("test");
 * Modifications Copyright OpenSearch Contributors. See
        GetAliasesResponse getAliasesResponse = admin().indices().prepareGetAliases("alias1").get();
        logger.info("--> getting alias1");
import java.util.Map;
        logger.info("--> getting * for index *bac");
            () -> admin().indices().prepareAliases().addAliasAction(AliasActions.add().index(index2).alias(alias).isHidden(true)).get()
                .value(),
        );
        ExecutorService executor = Executors.newFixedThreadPool(aliasCount);
        assertFalse(admin().indices().prepareGetAliases("b*").addIndices("*bar").get().getAliases().isEmpty());
                    .addAlias("bazbar", "bac", termQuery("field", "value"))
        createIndex("test");
                    .prepareAliases()
        assertFalse(admin().indices().prepareGetAliases("bar").get().getAliases().isEmpty());
        Exception e = expectThrows(
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;
        assertThat(searchResponse.getHits().getHits(), emptyArray());
        client().index(indexRequest("test1").id("1").source(source("1", "foo test"), MediaTypeRegistry.JSON)).get();
        IndexResponse res = client().index(indexRequest(nonWriteIndex).id("1").source(source("1", "nonwrite"), MediaTypeRegistry.JSON))
        try {
                () -> assertBlocked(admin().indices().prepareAliases().removeAlias("test", "alias2"), INDEX_METADATA_BLOCK)
        searchResponse = client().prepareSearch("alias*")
            client().prepareSearch("bars").setSize(0).setQuery(QueryBuilders.matchAllQuery()).get().getHits().getTotalHits().value(),
        createIndex("foobarbaz");
            if (i % 2 == 0) {
        assertThat(aliasMetadata.filter(), notNullValue());
        assertThat(getResponse.getAliases().get("foobar").get(0), notNullValue());
        assertThat(getResponse.getAliases().get("foobar").get(0).getSearchRouting(), nullValue());
        assertThat(aliasMetadata.isHidden(), equalTo(true));
                refresh();
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
                .getTotalHits()
        indexResponse = client().index(indexRequest("alias1").id("1").source(source("1", "test"), MediaTypeRegistry.JSON)).actionGet();
        refresh();
            assertThat(e.getMessage(), containsString("[alias1] missing"));
        ensureGreen();
import static org.hamcrest.Matchers.equalTo;
        assertSearchResponse(searchResponse);
        );
            () -> assertAcked(
            equalTo(1L)
import static org.opensearch.transport.client.Requests.indexRequest;
import org.opensearch.search.aggregations.AggregationBuilders;
                .getHits()
                )
            new String[] { "index1", "index2" },
        );
        logger.error("exception: {}", ex.getMessage());
        assertThat(getResponse.getAliases().get("bazbar").get(1).getSearchRouting(), nullValue());
        assertHits(searchResponse.getHits(), "2", "3");
        logger.info("--> creating index [test]");
        client().index(indexRequest("test2").id("23").source(source("23", "baz test2"), MediaTypeRegistry.JSON)).get();
        assertAliasesVersionIncreases(
    public void testAliases() throws Exception {
                    .addAlias("test1", "aliasToTests")
        e = expectThrows(
        searchResponse = client().prepareSearch("tests")
        ).actionGet();
            .get();
        assertAliasesVersionIncreases("test", () -> assertAcked(admin().indices().prepareAliases().addAlias("test", "alias1")));
 * specific language governing permissions and limitations
        assertHits(searchResponse.getHits(), "1", "2", "3", "4", "5");
        assertFalse(admin().indices().prepareGetAliases("alias*").get().getAliases().isEmpty());
        assertHits(searchResponse.getHits(), "1", "2", "3");
            "test3",
    }
                .value(),
                    .addAlias("test2", "aliasToTest2")
        assertThat(getResponse.getAliases().get("bazbar").get(0).getFilter().string(), containsString("value"));
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index(index1).alias(alias).isHidden(true)));
        assertThat(getResponse.getAliases().get("foobar").get(1).alias(), equalTo("alias2"));
            "test",
                    .addAlias("bazbar", "bar")
            assertThat(getResponse, notNullValue());
    // for filters to work correctly ES required that fields mentioned in those
        assertThat(getResponse.getAliases().get("bazbar").get(0).getIndexRouting(), nullValue());
        assertThat(aliasMetadata.isHidden(), nullValue());
        IllegalArgumentException exception = expectThrows(
        QueryBuilder filter = termQuery("user", "foobar");
        assertThat(getResponse, notNullValue());
        ensureGreen();
            logger.info("--> getting {} alias for index foobar", aliasName);
    // fields mentioned in filters don't need to exist in the mapping.
        try {
        SearchResponse searchResponse = client().prepareSearch("foos").setQuery(QueryBuilders.matchAllQuery()).get();
        searchResponse = client().prepareSearch("alias1").setQuery(QueryBuilders.matchAllQuery()).get();
            )
        assertThat(aliasMetadata.searchRouting(), equalTo("search"));
                    + "        \"alias1\" : {},\n"
        final String alias = "alias-" + randomAlphaOfLength(7).toLowerCase(Locale.ROOT);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
        assertAliasesVersionIncreases("test2", () -> assertAcked(admin().indices().prepareAliases().addAlias("test2", "alias12")));
        getResponse = admin().indices().prepareGetAliases("b*").addIndices("*bar").get();
        logger.info("--> getting f* for index *bac");
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index(index2).alias(alias).isHidden(true)));
        client().index(
            .state()
        getResponse = admin().indices().prepareGetAliases("foo").addIndices("foobar").get();
        Global global = searchResponse.getAggregations().get("global");
                "no write index is defined for alias [alias1]."
            "test",
        res = client().index(indexRequest(writeIndex).id("2").source(source("2", "writeindex"), MediaTypeRegistry.JSON)).get();
            .setIndicesOptions(IndicesOptions.fromOptions(false, false, true, false, true, true, true, false, false))
            beforeAliasesVersions.put(index, beforeMetadata.index(index).getAliasesVersion());
        assertHits(searchResponse.getHits(), "21", "31", "13", "33");
        assertAcked(
 * software distributed under the License is distributed on an
    }
        assertThat(response.getAliases(), hasKey("index1"));
        logger.info("--> verify that filter was updated");
        assertThat(getResponse.getAliases().get("bazbar").size(), equalTo(2));
        );
                    .prepareAliases()
            "The provided expression [foo] matches an alias, specify the corresponding concrete indices instead.",
            enableIndexBlock("test", SETTING_BLOCKS_METADATA);
        createIndexRequestBuilder = prepareCreate("test").addAlias(new Alias("alias2").filter("{ \"test\": {} }"));
        assertThat(aliasMetadata.filter(), nullValue());
        logger.info("--> adding filtering aliases to index [test1]");
        assertFalse(admin().indices().prepareGetAliases("foo").addIndices("foobar").get().getAliases().isEmpty());
        assertHits(searchResponse.getHits(), "11", "12", "13", "21", "31", "33");
                .getHits()
        logger.info("--> getting all aliases that start with alias*");
            "test1",
            "test3",
        assertAliasesVersionIncreases(indices, () -> admin().indices().prepareAliases().removeAlias(indices, aliases).get());
                    );
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index(index1).alias(alias)));
                assertAliasesVersionIncreases("test", () -> assertAcked(admin().indices().prepareAliases().removeAlias("test", "alias1")));
        assertFalse(admin().indices().prepareGetAliases("foo").get().getAliases().isEmpty());
            assertThat(getResponse.getAliases().get("foobar").get(1).alias(), equalTo("alias2"));
        );
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                    .addAlias("test2", "aliasToTests")
        logger.info("--> adding [foo] alias to [foo_foo] and [bar_bar]");
import static org.hamcrest.Matchers.notNullValue;
        assertAcked(client().admin().indices().prepareCreate("test"));
        createIndex("foobar");
        global = searchResponse.getAggregations().get("global");
        );
            () -> admin().indices().prepareAliases().addAlias("test", "alias1", "abcde").get()
        assertAliasesVersionIncreases(
        assertThat(getResponse.getAliases().get("bazbar").get(0).getIndexRouting(), nullValue());
        assertThat(indexResponse.getIndex(), equalTo("test_x"));
        GetAliasesResponse getResponse = admin().indices().prepareGetAliases("alias1").get();
        // valid json but non valid filter
    public void testHiddenAliasesMustBeConsistent() {
                    + "    \"aliases\" : {\n"
        );
                .getHits()
        assertAcked(
 * the Apache License, Version 2.0 (the "License"); you may
    public void testIndicesRemoveNonExistingAliasResponds404() throws Exception {
import org.opensearch.rest.action.admin.indices.AliasesNotFoundException;
import java.util.concurrent.Executors;
        assertAliasesVersionIncreases(
            final String aliasName = "alias" + i;
        );
        for (final String index : indices) {
                .get()
        assertThat(getResponse, notNullValue());
        assertThat(getResponse.getAliases().get("bazbar").get(0).getFilter().string(), containsString("term"));
        assertAliasesVersionIncreases(
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test2", "tests", termQuery("name", "test")))
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test3", "filter13", termQuery("name", "baz")))
import org.opensearch.index.query.TermQueryBuilder;
                .setSize(0)
                .getTotalHits()
        assertAliasesVersionIncreases(
            assertFalse(admin().indices().prepareGetAliases("alias2").get().getAliases().isEmpty());
        logger.info("--> indexing against [test]");
                .setQuery(QueryBuilders.matchAllQuery())
            () -> assertAcked((admin().indices().prepareAliases().addAlias("test", "alias1").setTimeout(timeout)))
 * license agreements. See the NOTICE file distributed with
        assertAcked(
        );
        assertThat(getResponse.getAliases().get("foobar").get(1).getIndexRouting(), nullValue());
        assertAliasesVersionIncreases("test", () -> {
            )
        );
                () -> assertBlocked(admin().indices().prepareAliases().removeAlias("test", "alias2"), INDEX_READ_ONLY_BLOCK)
        logger.info("--> indexing against [test2]");
        assertThat(getResponse.getAliases().get("foobar").get(0).getFilter(), nullValue());
        try {
            equalTo("{\"term\":{\"user\":{\"value\":\"foobar\",\"boost\":1.0}}}")
 * not use this file except in compliance with the License.
            fail("create index should have failed due to invalid alias filter");
        getResponse = admin().indices().prepareGetAliases("*").addIndices("*bac").get();
        });
        assertThat(getResponse.getAliases().get("bazbar").get(1), notNullValue());
        assertThat(getResponse.getAliases().get("foobar").get(0).getIndexRouting(), nullValue());
        assertTrue(admin().indices().prepareGetAliases("foo").get().getAliases().isEmpty());
        assertAcked(client().admin().indices().prepareAliases().removeIndex("foo*"));
 */
        searchResponse = client().prepareSearch("fo*").setQuery(QueryBuilders.matchAllQuery()).get();
                .value(),
            )
        );
        );
        );
            logger.info("--> aliasing index [test] with [alias1]");
        createIndex("test");
        logger.info("--> creating index [test1] and [test2]");
import java.util.HashSet;
            () -> assertAcked(
                .prepareAliases()
        assertFalse(admin().indices().prepareGetAliases("foo").setIndices("bar_bar").get().getAliases().isEmpty());
            final String aliasName = "alias" + i;
        assertThat(getResponse.getAliases().get("bazbar").get(1).getIndexRouting(), nullValue());
        assertThat(e.getMessage(), equalTo("failed to parse filter for alias [alias1]"));
        logger.info("--> deleting against [alias1], should fail now");
            "test2",
            "test",
        createIndex("test123");
            "test_2",
        assertAliasesVersionIncreases("test1", () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "aliasToTest1")));
            assertAcked(admin().indices().prepareAliases().removeAlias("test", "alias1").addAlias("test_x", "alias1"));
import static org.opensearch.transport.client.Requests.createIndexRequest;
        );
                    + " indices without one being designated as a write index"
    }
        // For now just making sure that filter was stored with the alias
        createIndex("test_x");
        assertAcked(
        });
        ensureGreen();
import org.opensearch.action.admin.indices.alias.get.GetAliasesResponse;
        logger.info("--> getting *b* for index *bar");
            () -> assertAcked(
        assertAliasesVersionIncreases(
        assertThat(getResponse.getAliases().size(), equalTo(1));
        logger.info("--> checking filtering alias for multiple indices");
        assertAliasesVersionIncreases("test2", () -> assertAcked(admin().indices().prepareAliases().addAlias("test2", "aliasToTests")));
        getResponse = admin().indices().prepareGetAliases("foo").addIndices("foobar").get();
                    + "        \"alias3\" : { \"index_routing\" : \"index\", \"search_routing\" : \"search\"},\n"
        }
        assertThat(getResponse, notNullValue());
                .getHits()
import org.opensearch.action.support.IndicesOptions;
            "test",
        terms = global.getAggregations().get("test");
        assertThat(stopWatch.stop().lastTaskTime().millis(), lessThan(timeout.millis()));
        assertThat(indexResponse.getIndex(), equalTo("test"));
                assertAliasesVersionIncreases(
        );
            client().admin().indices().preparePutMapping("foobar", "test", "test123", "foobarbaz", "bazbar").setSource("field", "type=text")
        });
import org.opensearch.cluster.metadata.IndexMetadata;
        assertThat(getResponse.getAliases().get("bazbar").get(0).getFilter().string(), containsString("term"));
                .prepareAliases()
        searchResponse = client().prepareSearch("alias1", "foos").setQuery(QueryBuilders.matchAllQuery()).get();
            .addSort("_index", SortOrder.ASC)
    public void testWaitForAliasCreationSingleShard() throws Exception {
    }
        // Both visible
        assertEquals(
    }
                    .addAlias("my-index", "filter2", rangeQuery("timestamp").from("2016-01-01").to("2016-12-31"))
        assertThat(aliasMetadata.indexRouting(), nullValue());
        searchResponse = client().prepareSearch("filter13", "filter1", "filter23").setQuery(QueryBuilders.matchAllQuery()).get();
        assertThat(getResponse.getAliases().get("foobar").get(0).getIndexRouting(), nullValue());
            .actionGet();
        assertThat(getResponse.getAliases().get("foobar").get(0).getIndexRouting(), nullValue());
        logger.info("--> recreating alias1 with the same filter");
import static org.hamcrest.Matchers.lessThan;
            "The provided expression [foo] matches an alias, specify the corresponding concrete indices instead.",
        assertThat(aliasMetadata.alias(), equalTo("alias3"));
            client().prepareSearch("filter23", "filter13", "test2")
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "foos", termQuery("name", "foo")))
        assertThat(aliasMetadata.indexRouting(), equalTo("index"));
        }
    public void testSearchingFilteringAliasesSingleIndex() throws Exception {
        logger.info("--> creating index [test]");
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "filter13", termQuery("name", "baz")))
        logger.info("--> creating index [test]");
        client().index(indexRequest("test2").id("5").source(source("5", "foo test"), MediaTypeRegistry.JSON)).get();
            "foobar",
import java.util.Arrays;
/*
    }
                .addAliasAction(AliasActions.remove().index(index1).alias(alias))
            exception.getMessage(),
            fail("create index should have failed due to invalid alias filter");
                "test",
        assertThat(getResponse.getAliases().size(), equalTo(1));
    public void testAliasesWithBlocks() {
            equalTo(4L)
        client().index(indexRequest("test2").id("7").source(source("7", "baz test"), MediaTypeRegistry.JSON)).get();
        assertAcked(prepareCreate("2017-05-20"));
    }
        assertAcked(prepareCreate("test").setMapping("name", "type=text"));
            .get();
            } finally {
        createIndex("test");
        assertAliasesVersionIncreases(
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index(index2).alias(alias).isHidden(false)));
        assertThat(getResponse.getAliases().get("bazbar").get(1).alias(), equalTo("bar"));
            assertAcked(admin().indices().prepareAliases().addAlias("test", "alias1"));
        createIndex("test");
        Set<String> hitIds = new HashSet<>();
                        + "        \"alias3\" : { \"index_routing\" : \"index\", \"search_routing\" : \"search\"},\n"
        assertAcked(prepareCreate("my-index").setMapping("timestamp", "type=date"));
        assertThat(getResponse.getAliases().get("foobar").size(), equalTo(1));
            IllegalArgumentException.class,
        final int aliasCount = 10;
        assertThat(getResponse.getAliases().get("foobar").get(0).getFilter(), nullValue());
            .getIndicesLookup()
        assertAcked(prepareCreate("bar_bar"));
        assertAcked(prepareCreate("test1").setMapping("name", "type=text"));
            logger.info("--> aliasing index [test] with [alias1]");
                    .addAlias("test2", "foos", termQuery("name", "foo"))
import static org.hamcrest.Matchers.nullValue;
        ).actionGet();
        logger.info("--> checking filtering alias for two indices");
                : admin().indices().prepareGetAliases().addIndices("foobar").get();
        assertThat(
        boolean done = executor.awaitTermination(20, TimeUnit.SECONDS);
        assertAliasesVersionIncreases("test1", () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "alias12")));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                .getHits()
        client().index(
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "tests", termQuery("name", "test")))
                    .prepareAliases()
import static org.opensearch.index.query.QueryBuilders.termQuery;
                    + " The write index may be explicitly disabled using is_write_index=false or the alias points to multiple"
            new String[] { "bazbar", "foobar" },
                    + " The write index may be explicitly disabled using is_write_index=false or the alias points to multiple"
        client().index(indexRequest("test1").id("3").source(source("3", "baz test"), MediaTypeRegistry.JSON)).get();
    }
        } catch (IllegalArgumentException e) {
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.remove().index(index1).alias(alias)));
        }
        assertAliasesVersionIncreases("test1", () -> assertAcked(admin().indices().prepareAliases().addAlias("test1", "aliasToTests")));
        stopWatch.start();
        assertThat(
import org.opensearch.action.admin.indices.alias.Alias;
        searchResponse = client().prepareSearch("filter23", "filter1").setQuery(QueryBuilders.matchAllQuery()).get();
        );
            logger.info("--> remove aliasing index [test_x] with [alias1]");
                    + " The write index may be explicitly disabled using is_write_index=false or the alias points to multiple"
        client().index(indexRequest("test3").id("32").source(source("32", "bar test3"), MediaTypeRegistry.JSON)).get();
        getResponse = admin().indices().prepareGetAliases("f*").addIndices("*bar").get();
            equalTo(8L)
        assertThat(terms.getBuckets().size(), equalTo(4));
        assertAcked(
        assertAliasesVersionIncreases("test", () -> assertAcked((admin().indices().prepareAliases().addAlias("test", "alias1"))));
        assertAcked(client().admin().indices().preparePutMapping("test1", "test2", "test3").setSource("name", "type=text"));
                .addAliasAction(AliasActions.add().index(nonWriteIndex).alias(alias).isHidden(true))
            try {
        stopWatch.start();
                )
                .value(),
        logger.info("--> adding [week_20] alias to [2017-05-20]");
        client().index(indexRequest("test2").id("21").source(source("21", "foo test2"), MediaTypeRegistry.JSON)).get();
        IllegalArgumentException iae = expectThrows(
        logger.info("--> creating aliases [bar, baz, foo]");
import org.opensearch.index.query.QueryBuilders;
        assertThat(getResponse, notNullValue());
        final Metadata afterMetadata = admin().cluster().prepareState().get().getState().metadata();
    public void testFilteringAliases() throws Exception {
        createIndex(writeIndex, nonWriteIndex);
        );
            equalTo(5L)
            .addAggregation(AggregationBuilders.terms("test").field("name"))
        assertThat(
        IllegalArgumentException iae = expectThrows(
            equalTo(8L)
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test2", "foos", termQuery("name", "foo")))
        logger.info("--> indexing against [alias1], should work now");
        res = client().index(indexRequest(alias).id("3").source(source("3", "through alias"), MediaTypeRegistry.JSON)).get();
            assertThat(admin().indices().prepareGetAliases("alias2").execute().actionGet().getAliases().get("test").size(), equalTo(1));
                .addAlias(new Alias("alias3").indexRouting("index").searchRouting("search"))
            assertThat(getResponse.getAliases().size(), equalTo(1));
                    .addAlias("test2", "tests", termQuery("name", "test"))
            fail("Expected AliasesNotFoundException");
            () -> assertAcked((admin().indices().prepareAliases().addAlias("test", "alias1", barFilter).setTimeout(timeout)))
import org.opensearch.search.aggregations.bucket.global.Global;
        assertThat(getAliasesResponse.getAliases().get("test").size(), equalTo(1));
        assertHits(searchResponse.getHits(), "1", "2", "3", "4");
        return "{ \"id\" : \"" + id + "\", \"name\" : \"" + nameValue + "\" }";
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(8L));
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test", "tests", termQuery("name", "test")))
        ensureGreen();
        // Visible on one, then update it to hidden & add to a second as hidden simultaneously
 * this file be licensed under the Apache-2.0 license or a
        assertAcked(prepareCreate("test2").setMapping("name", "type=text"));
        logger.info("--> checking single filtering alias search with sort");
        executor.shutdown();
        ensureGreen();
        assertHits(searchResponse.getHits(), "1", "2");
            exception.getMessage(),
        getResponse = admin().indices().prepareGetAliases("alias*").get();
        logger.info("--> adding filtering aliases to indices");
        assertThat(getResponse.getAliases().get("bazbar").get(1).getSearchRouting(), nullValue());
            executor.submit(new Runnable() {
            client().prepareSearch("filter23", "filter1")
        assertThat(
import org.opensearch.search.aggregations.bucket.terms.Terms;
        stopWatch.start();
    private String source(String id, String nameValue) {
    }
        assertHits(searchResponse.getHits(), "1");
        refresh(writeIndex, nonWriteIndex);
        }
 * compatible open source license.
        assertFalse(admin().indices().prepareGetAliases("bac").addIndices("bazbar").get().getAliases().isEmpty());
 * Licensed to Elasticsearch under one or more contributor
        assertThat(getResponse.getAliases().get("bazbar").get(0).getFilter().string(), containsString("field"));
        logger.info("--> getting f* for index *bar");
            "test1",
        assertThat(getResponse.getAliases().size(), equalTo(2));
        assertHits(searchResponse.getHits(), "1", "2", "3");
        for (String alias : aliases) {
        assertAcked(prepareCreate("test2").setMapping("name", "type=text"));
        createIndex("test");
        assertAcked(admin().indices().prepareAliases().addAlias("2017-05-20", "week_20"));
                .addAliasAction(AliasActions.remove().index(index2).alias(alias))
        client().index(indexRequest("test2").id("8").source(source("8", "something else"), MediaTypeRegistry.JSON)).get();
        createIndex("bazbar");
            "test1",
        assertAcked(admin().indices().prepareAliases().removeAlias("foobar", "foo"));
    }
            IllegalArgumentException.class,
            )
        logger.info("--> adding filtering aliases to index [test2]");
        );
            "test1",
        assertAliasesVersionIncreases(
                .get()
 * this work for additional information regarding copyright
            client().prepareSearch("foos", "test1")
        );
            iae.getMessage()
        assertFalse(admin().indices().prepareGetAliases("*b*").addIndices("baz*").get().getAliases().isEmpty());
        );
                .getTotalHits()
                .addAlias(new Alias("alias2").filter(QueryBuilders.boolQuery().mustNot(QueryBuilders.existsQuery("field"))))
        }
                        + "        \"alias4\" : {\"is_hidden\":  true}\n"
import org.opensearch.common.settings.Settings;
                () -> assertBlocked(admin().indices().prepareAliases().addAlias("test", "alias3"), INDEX_METADATA_BLOCK)
        logger.info("--> deleting alias1");
                    "test",
                admin().indices()
                .setSize(0)
    public void testCreateIndexWithAliasesFilterNotValid() {
                        () -> assertAcked(admin().indices().prepareAliases().addAlias("test", aliasName))
        );
        assertAliasesVersionIncreases(new String[] { "foo_foo", "bar_bar" }, () -> {
        for (int i = 1; i <= numDocs; i++) {
        assertThat(getResponse.getAliases().get("bazbar").get(1).getFilter(), nullValue());
            "The provided expression [week_20] matches an alias, specify the corresponding concrete indices instead.",
 *
        searchResponse = client().prepareSearch("tests")
        assertAliasesVersionIncreases(
        logger.info("--> creating index [test]");
        }
        assertThat(getResponse.getAliases().get("foobar").get(0), notNullValue());
            final String aliasName = "alias" + i;
                    .addAlias("test1", "aliasToTest1")
            indexRequest("test").id("3").source(source("3", "baz test"), MediaTypeRegistry.JSON).setRefreshPolicy(RefreshPolicy.IMMEDIATE)
        logger.info("--> getting *b* for index baz*");
                    createIndexRequest("test").settings(
        } finally {
import static org.hamcrest.Matchers.containsInAnyOrder;
                .getTotalHits()
        assertThat(
                .setQuery(QueryBuilders.matchAllQuery())
                        + "        \"alias2\" : {\"filter\" : {\"term\": {\"field\":\"value\"}}},\n"
        );
        }
        );
        assertThat(getResponse.getAliases().get("foobar").get(0).getSearchRouting(), nullValue());
        );
            client().index(indexRequest(aliasName).id("1").source(source("1", "test"), MediaTypeRegistry.JSON)).get();
            .get();
            () -> assertAcked(client().admin().indices().prepareAliases().addAlias("test_2", "test").removeIndex("test"))
        final String alias = "alias-" + randomAlphaOfLength(7).toLowerCase(Locale.ROOT);
        logger.info("--> checking single filtering alias search");
        }
        assertThat(getResponse.getAliases().get("foobar").get(0).alias(), equalTo("alias1"));
            () -> assertAcked(admin().indices().prepareAliases().addAlias("test", "bars", termQuery("name", "bar")))
            )
        getResponse = admin().indices().prepareGetAliases("bar", "bac").addIndices("bazbar").get();
        );
        String[] aliases = { "aliasToTest1", "foos", "bars", "tests", "aliasToTest2", "aliasToTests" };
        // alias at work
        assertTrue(client().admin().indices().prepareExists("bar_bar").execute().actionGet().isExists());
        assertAliasesVersionIncreases(
        indexRandom(true, client().prepareIndex("test_2").setId("test").setSource("test", "test"));
            prepareCreate("test").setSource(
        logger.info("--> indexing against [alias1], should work now");
import org.opensearch.cluster.metadata.Metadata;
        client().index(indexRequest("test3").id("33").source(source("33", "baz test3"), MediaTypeRegistry.JSON)).get();
        assertAcked(prepareCreate("test").setMapping("user", "type=text"));
                "{\n"
        );
        assertHits(searchResponse.getHits(), "1", "2", "3", "4", "5");
                () -> assertBlocked(admin().indices().prepareAliases().addAlias("test", "alias3"), INDEX_READ_ONLY_BLOCK)
        SearchResponse searchResponse = client().prepareSearch("foos").setQuery(QueryBuilders.matchAllQuery()).get();
            () -> admin().indices().prepareAliases().addAliasAction(AliasActions.add().index(index2).alias(alias).isHidden(false)).get()
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;
        assertThat(response.getAliases(), hasKey("index1"));
        assertThat(getResponse.getAliases().get("bazbar").get(0).alias(), equalTo("bac"));
        createIndex("test1", "test2", "test3");
        client().index(indexRequest("test1").id("13").source(source("13", "baz test1"), MediaTypeRegistry.JSON)).get();
                    + "        \"alias2\" : {\"filter\" : {\"match_all\": {}}},\n"
            IllegalArgumentException.class,
        client().index(indexRequest("test1").id("2").source(source("2", "bar test"), MediaTypeRegistry.JSON)).get();
        logger.info("--> creating index [test2]");
        assertAcked(prepareCreate("test").setMapping("id", "type=text", "name", "type=text,fielddata=true"));
        logger.info("--> indexing against [test2]");
            () -> client().admin().indices().prepareAliases().removeIndex("foo").execute().actionGet()
        assertThat(getResponse.getAliases().get("foobar").get(0).alias(), equalTo("foo"));
        );
        assertAliasesVersionIncreases(new String[] { index }, runnable);
        for (String block : Arrays.asList(SETTING_BLOCKS_READ, SETTING_BLOCKS_WRITE)) {
import static org.hamcrest.Matchers.emptyArray;
            AcknowledgedResponse res = admin().indices()
        assertTrue(admin().indices().prepareGetAliases("foo").addIndices("foobar").get().getAliases().isEmpty());
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index(index1).alias(alias).isHidden(false)));
            "test2",
        checkAliases();
        assertThat(indexResponse.getIndex(), equalTo("test"));
                    "{\n"
        assertThat(aliasMetadata.searchRouting(), nullValue());
        assertAcked(prepareCreate("foo_foo"));
                assertHitCount(response, i);
        assertAliasesVersionIncreases("test", () -> assertAcked(admin().indices().prepareAliases().addAlias("test", "alias2")));
            () -> client().index(indexRequest("alias1").id("1").source(source("2", "test"), MediaTypeRegistry.JSON)).actionGet()
        assertThat(aliasMetadata.isHidden(), nullValue());
        assertThat(ex.getMessage(), containsString("has is_hidden set to true on indices"));
        logger.info("--> creating index [test_x]");
                    + " indices without one being designated as a write index"
        logger.info("--> checking filtering alias for two indices and non-filtering alias for both indices");
            IllegalArgumentException.class,
        assertThat(hits.getTotalHits().value(), equalTo((long) ids.length));
                .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
                .setQuery(QueryBuilders.matchAllQuery())
        assertHits(searchResponse.getHits(), "11", "12", "13", "21", "22", "23", "31", "33");
        ClusterState clusterState = admin().cluster().prepareState().get().getState();
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index(index1).alias(alias).isHidden(true)));
        assertThat(
                .setQuery(QueryBuilders.matchAllQuery())
        }
                .get()
        client().index(indexRequest("test1").id("12").source(source("12", "bar test1"), MediaTypeRegistry.JSON)).get();
        assertHits(searchResponse.getHits(), "21", "22", "23", "31", "13", "33");
    }
    public void testDeletingByQueryFilteringAliases() throws Exception {
        assertFalse(admin().indices().prepareGetAliases("foo").get().getAliases().isEmpty());
        );
                admin().indices()
        ensureGreen();
            );
                .getTotalHits()
            "test1",
        assertAliasesVersionIncreases(
        assertThat(getResponse.getAliases().get("bazbar").get(1), notNullValue());
        final String writeIndex = randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index(index2).alias(alias).isHidden(false)));
        assertAliasesVersionIncreases(
        ensureGreen();
import org.opensearch.search.SearchHit;
    public void testIndicesGetAliases() throws Exception {
                .get()
        assertThat(getResponse.getAliases().size(), equalTo(1));
        assertThat(
        assertAcked(prepareCreate("test1").setMapping("name", "type=text"));
        // And through the alias
        }
                .getTotalHits()
            client().prepareSearch("foos", "aliasToTests")
