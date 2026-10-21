    protected Settings nodeSettings() {
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
                client().prepareSearch().setSize(0).setQuery(termQuery("message", "update")).get().getHits().getTotalHits().value(),
                        + SearchService.MAX_OPEN_PIT_CONTEXT.get(Settings.EMPTY)
import java.util.Map;
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
import static org.hamcrest.Matchers.blankOrNullString;
        service.doClose();
                Matchers.equalTo(0L)
        assertSegments(true, client());
                client().prepareSearch()
        createIndex("index", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());
        client().admin().indices().prepareClose("index").get();
                    for (int j = 0; j < 50; j++) {
            client().prepareIndex("test")
                                            + "]. "
import org.opensearch.action.search.SearchResponse;
                                            + SearchService.MAX_OPEN_PIT_CONTEXT.get(Settings.EMPTY)
        assertSegments(false, client(), pitResponse.getId());
    }
        service.doClose();
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
        assertTrue(ex.shardFailures()[0].reason().contains("SearchContextMissingException"));
                    jsonBuilder().startObject()
                }
                            assertTrue(
        client().prepareIndex("index").setId("2").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
 * Single node integration tests for various PIT use cases such as create pit, search etc
    public void testCreatePITOnCloseIndex() throws ExecutionException, InterruptedException {
        createIndex("index");
                .get()
                        try {
import org.opensearch.common.unit.TimeValue;
            Matchers.equalTo(0L)
        SearchService service = getInstanceFromNode(SearchService.class);
        for (DeletePitInfo deletePitInfo : deletePITResponse.getDeletePitResults()) {
                            .get();
        assertSegments(true, client());
        validatePitStats("index", 0, 1, 1);
                .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
            thread.join();
                            .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
    }
            );
    public void testOpenPitContextsConcurrently() throws Exception {
            );
                            + "This limit can be set by changing the [search.max_open_pit_context] setting."
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
    public void testPitSearchOnDeletedIndex() throws ExecutionException, InterruptedException {
        validatePitStats("index", 1, 0, 0);
                .setQuery(matchAllQuery())
            assertThat(deletePitInfo.getPitId(), not(blankOrNullString()));
import org.opensearch.search.builder.PointInTimeBuilder;
        SearchService service = getInstanceFromNode(SearchService.class);
                    map.put("message", "update");
            service.doClose();
                    .getHits()
import org.opensearch.common.action.ActionFuture;
import org.opensearch.action.search.CreatePitResponse;
        IndexShard indexShard = indexService.getShard(shardId);
                .setSource(
        PitTestsUtil.assertUsingGetAllPits(client(), response.getId(), response.getCreationTime(), TimeValue.timeValueDays(1));
                .setQuery(termQuery("message", "test"))
/**
            for (int i = 0; i < 1000; i++) {
            );
        SearchService service = getInstanceFromNode(SearchService.class);
            validatePitStats("test", 0, 1, 0);
    }
        CreatePitResponse pitResponse = execute.get();
            assertThat(
                .setQuery(termQuery("message", "test"))
import org.opensearch.action.search.DeletePitRequest;
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        request.setIndices(new String[] { "index" });
        );
    protected boolean resetNodeAfterTest() {
                    .getTotalHits()
        // create pit
        return Settings.builder()
              assert without point in time
        request.setIndices(new String[] { "index" });
import org.hamcrest.Matchers;
                    throw new AssertionError(e);
 */
        PitTestsUtil.assertUsingGetAllPits(client(), pitResponse.getId(), pitResponse.getCreationTime(), TimeValue.timeValueDays(1));
        CountDownLatch latch = new CountDownLatch(threads.length);
        SearchService service = getInstanceFromNode(SearchService.class);
        assertEquals(2, service.getActiveContexts());
        Thread[] threads = new Thread[randomIntBetween(2, 8)];
                                    )
                .getHits()
                    .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
                .getHits()
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
        service.doClose();
import org.opensearch.common.Priority;
        validatePitStats("index", maxPitContexts, 0, 0);
          When we invoke delete again, returns success after clearing the remaining readers. Asserting reader context
            PitTestsUtil.assertGetAllPitsEmpty(client());
        assertSegments(false, client(), pitResponse.getId());
                                            + "Must be less than or equal to: ["
                try {
                ((SearchPhaseExecutionException) ex).getDetailedMessage()
            threads[i] = new Thread(() -> {
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
    public void testCreatePITSuccess() throws ExecutionException, InterruptedException {
        }
        createIndex("index", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());
                }
        service.doClose(); // this kills the keep-alive reaper we have to reset the node after this test
                    .value(),
                }
                .value(),
import org.opensearch.action.search.CreatePitRequest;
        }
    public void testConcurrentSearches() throws Exception {
        SearchService service = getInstanceFromNode(SearchService.class);
        ActionFuture<DeletePitResponse> execute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);
    public void testCreatePITWithShardReplicasSuccess() throws ExecutionException, InterruptedException {
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
                .get()
        validatePitStats("index", 0, 1, 1);
            IllegalArgumentException.class,
            validatePitStats("test", 1, 0, 0);
            assertEquals(0, service.getActiveContexts());
        validatePitStats("index", 0, maxPitContexts, 0);
        );
                .get()
                latch.countDown();
            assertThat(
        validatePitStats("index", 1, 0, 1);
            /*
        request.setIndices(new String[] { "index" });
                .setSize(0)
    }
                    .getHits()
        }
                            return;
    public void validatePitStats(String index, long expectedPitCurrent, long expectedPitCount, int shardId) throws ExecutionException,
        assertThat(
                                    .contains(
            assertThat(
            Matchers.equalTo(50L)
        SearchService service = getInstanceFromNode(SearchService.class);
            thread.join();
        // PIT reader contexts are lost after close, verifying it with open index api
                .setSize(0)
        assertThat(
            threads[i].setName("opensearch[node_s_0][search]");
                    client().prepareIndex("test").setId(searchHit.getId()).setSource(map).get();
        SearchService service = getInstanceFromNode(SearchService.class);
import org.opensearch.index.IndexNotFoundException;
        );
                                        "Trying to create too many Point In Time contexts. "
        validatePitStats("index1", 0, 1, 0);
            Matchers.equalTo(50L)
            } while (searchResponse.getHits().getHits().length > 0);
                    throw new AssertionError(e);
                    .value(),
                Matchers.equalTo(0L)
                                e.getMessage()
            assertThat(
                .value(),
        assertThat(
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
                    .get()
             */
        validatePitStats("index", 0, maxPitContexts + 1, 0);
                .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
                            + SearchService.MAX_OPEN_PIT_CONTEXT.get(Settings.EMPTY)
        validatePitStats("index", 0, 1, 0);
                    .setQuery(termQuery("message", "test"))
                .setSize(0)
        assertEquals(0, service.getActiveContexts());
            threads[i].start();
            threads[i].start();
                    .setQuery(termQuery("message", "update"))
                    }
            .setQuery(queryStringQuery("user:foobar"))
            client().prepareSearch()
        DeletePitResponse deletePITResponse = execute.get();
        });
                    .setSize(0)
                .value(),
         */
        assertEquals(expectedPitCurrent, indexShard.searchStats().getTotal().getPitCurrent());
import org.opensearch.action.search.DeletePitResponse;
 *
        SearchService service = getInstanceFromNode(SearchService.class);
                Matchers.equalTo(50L)
            assertSegments(true, client());
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
                .setSize(0)
            .setSize(50)
        assertEquals(0, service.getActiveContexts());
        CreatePitResponse pitResponse = execute.get();
    public void testPitSearchOnCloseIndex() throws ExecutionException, InterruptedException {
            assertTrue(
        for (Thread thread : threads) {
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
    }
                .getTotalHits()
        service.doClose();
        assertTrue(ex.shardFailures()[0].reason().contains("SearchContextMissingException"));
    public void testCreatePITWithNonExistentIndex() {
                    .setQuery(termQuery("message", "update"))
    @Override
                if (cpr.getId() != null) pitIds.add(cpr.getId());
        assertSegments(true, client());
    public void testPitAfterUpdateIndex() throws Exception {
                .get();
                    "Trying to create too many Point In Time contexts. "
        for (int i = 0; i < 50; i++) {
                    Map<String, Object> map = searchHit.getSourceAsMap();
    }
            .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
        try {
                .get();
            }
        assertSegments(true, client());
                    .setQuery(termQuery("message", "test"))
import org.opensearch.indices.IndicesService;
        createIndex("index");
import org.opensearch.search.sort.SortOrder;
                client().prepareSearch().setSize(0).setQuery(termQuery("message", "test")).get().getHits().getTotalHits().value(),
    public void testInvalidPitId() {
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                    .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
                .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
                        client().prepareSearch()
                CreatePitResponse cpr = client().execute(CreatePitAction.INSTANCE, request).actionGet();
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
        assertEquals(4, response.getSuccessfulShards());
                client().prepareSearch().setSize(0).setQuery(termQuery("message", "test")).get().getHits().getTotalHits().value(),
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();
import org.opensearch.common.settings.Settings;
                        + "Must be less than or equal to: ["
        CreatePitResponse response = execute.get();
        validatePitStats("index", 1, 0, 1);
                .getTotalHits()
        Thread[] threads = new Thread[5];
                Matchers.equalTo(0L)
        CreatePitResponse pitResponse = execute.get();
        assertTrue(ex.getMessage().contains("IndexClosedException"));
        validatePitStats("index", 1, 0, 0);
        request.setIndices(new String[] { "index" });
            Matchers.equalTo(50L)
                .setQuery(termQuery("message", "update"))
                client().prepareSearch().setSize(0).setQuery(termQuery("message", "update")).get().getHits().getTotalHits().value(),
    /**
import org.opensearch.Version;
        service.doClose();
                .setPointInTime(new PointInTimeBuilder(id).setKeepAlive(TimeValue.timeValueDays(1)))
        SearchService service = getInstanceFromNode(SearchService.class);
                latch.countDown();
                for (SearchHit searchHit : searchResponse.getHits().getHits()) {
          not found exceptions don't result in failures ( as deletion in one node is successful )
                    .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
            .setSize(2)
        assertThat(service.getActiveContexts(), equalTo(maxPitContexts));
import org.opensearch.action.search.DeletePitAction;
        assertEquals(2, service.getActiveContexts());
        ExecutionException ex = expectThrows(ExecutionException.class, execute::get);
        ex = expectThrows(SearchPhaseExecutionException.class, () -> {
                    latch.await();
            client().prepareSearch()
            client().prepareSearch()
                .get()
            .setSize(2)
import org.opensearch.index.shard.IndexShard;
                    .get()
                .setId(Integer.toString(i))
package org.opensearch.search;
        createIndex("idx");
        validatePitStats("index", 0, 1, 0);
                    )
        assertSegments(true, client());
            threads[i].setName("opensearch[node_s_0][search]");
        );
        PitTestsUtil.assertGetAllPitsEmpty(client());
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
        List<String> pitIds = new ArrayList<>();
        CreatePitResponse pitResponse = execute.get();
        IndexNotFoundException ex = expectThrows(IndexNotFoundException.class, () -> {
        client().prepareIndex("index1").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
        validatePitStats("index", 0, maxPitContexts, 0);
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
        validatePitStats("index", 1, 0, 0);
        assertTrue(ex.getMessage().contains("no such index [index1]"));
        createIndex("index", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 1).build());
        assertThat(
                            );
                try {
            client().prepareSearch()
                            .execute()
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
                        .field("user", "foobar")
        request.setIndices(new String[] { "index" });
                .getHits()
        validatePitStats("index", 0, 1, 1);
                                            + "This limit can be set by changing the ["
        // deleteall
                .value(),
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
import org.opensearch.action.search.DeletePitInfo;
    }
            assertThat(
        createIndex("index");
        SearchResponse searchResponse = client().prepareSearch("index")
                .get()
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
        ExecutionException ex = expectThrows(ExecutionException.class, execute::get);
        final int maxPitContexts = SearchService.MAX_OPEN_PIT_CONTEXT.get(Settings.EMPTY);
        client().admin().indices().prepareClose("index").get();
    public void testMaxOpenPitContexts() throws Exception {
import org.opensearch.index.IndexService;
        PitTestsUtil.assertUsingGetAllPits(client(), pitResponse.getId(), pitResponse.getCreationTime(), TimeValue.timeValueDays(1));
        CreatePitResponse pitResponse = execute.get();
        service.doClose();
            );
            .put(CreatePitController.PIT_INIT_KEEP_ALIVE.getKey(), TimeValue.timeValueSeconds(1))
        InterruptedException {
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
        request.setIndices(new String[] { "index" });
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                        .field("message", "test")
                .get()
        SearchService service = getInstanceFromNode(SearchService.class);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
            .addSort("postDate", SortOrder.ASC)
                .getHits()
        validatePitStats("index", 0, 1, 0);
                    .setSize(0)
        createIndex("index", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());
import java.util.concurrent.CountDownLatch;
        assertSegments(true, client());
            );
        );
                        .endObject()
import static org.hamcrest.CoreMatchers.equalTo;
                        "Trying to create too many Point In Time contexts. "
                        }
        String id = encodedContext.substring(0, encodedContext.length() - 1);
                        + "]. "
                    latch.await();
        CreatePitResponse pitResponse = execute.get();
        assertEquals("invalid id: [" + id + "]", e.getMessage());
                    .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
            client().admin().indices().prepareRefresh().get();
        service.doClose();
                    .get()
            });
        request.setIndices(new String[] { "index" });
                    .get()
            assertThat(
    }
        validatePitStats("index1", 1, 0, 0);
            );
                            .setSize(2)
        assertThat(
        assertEquals(0, service.getActiveContexts());
    }
            () -> client().prepareSearch()
            .get();
                .setSize(2)
                .setSize(2)
        validatePitStats("index", 1, 0, 0);
            .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
        assertSegments(false, client(), pitResponse.getId());
            threads[i] = new Thread(() -> {
        assertSegments(false, client(), pitResponse.getId());
import org.opensearch.action.search.PitTestsUtil;
                        .field("postDate", System.currentTimeMillis())
            ex.getMessage()
            .build();
    }
                .get();
        client().execute(CreatePitAction.INSTANCE, request).get();
        SearchResponse searchResponse = client().prepareSearch("index")
                            + "Must be less than or equal to: ["
                .get();
        }
        }
            .get();
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
        for (int i = 0; i < threads.length; i++) {
            .put(super.nodeSettings())
import org.opensearch.action.search.SearchContextId;
        });
                )
        PitTestsUtil.assertGetAllPitsEmpty(client());
                client().prepareSearch()
        }
                )
        PitTestsUtil.assertUsingGetAllPits(client(), pitResponse.getId(), pitResponse.getCreationTime(), TimeValue.timeValueMinutes(2));
            });
        createIndex("index1", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());
                Matchers.equalTo(50L)
                .setSize(2)
        validatePitStats("index", 1, 0, 1);
        service.doClose();
                searchResponse = client().prepareSearch().setSize(0).setQuery(termQuery("message", "test")).get();
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
                    .getHits()
        ExecutionException ex = expectThrows(ExecutionException.class, execute::get);
        for (Thread thread : threads) {
            client().prepareSearch()
     */
        }
            assertThat(
        request.setIndices(new String[] { "test" });
        PitTestsUtil.assertUsingGetAllPits(client(), pitResponse.getId(), pitResponse.getCreationTime(), TimeValue.timeValueDays(1));
        assertSegments(false, client(), response.getId());
            .put(SearchService.KEEPALIVE_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(1))
        validatePitStats("index", 1, 0, 0);
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
            );
        client().prepareIndex("index").setId("2").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
import java.util.Collections;
                    .getTotalHits()
                    .getTotalHits()
        SearchService service = getInstanceFromNode(SearchService.class);
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < threads.length; i++) {
        assertHitCount(searchResponse, 1);
                        + "This limit can be set by changing the [search.max_open_pit_context] setting."
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
                .value(),
              using point in time id will have the same search results as ones before update
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
        request.setIndices(new String[] { "index" });
    public void testCreatePITWithMultipleIndicesSuccess() throws ExecutionException, InterruptedException {
            client().execute(CreatePitAction.INSTANCE, request).get();
                Matchers.equalTo(50L)
                .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
        final int maxPitContexts = SearchService.MAX_OPEN_PIT_CONTEXT.get(Settings.EMPTY);
        // very frequent checks
        client().prepareIndex("index").setId("2").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
            SearchResponse searchResponse = client().prepareSearch()
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
                                            + SearchService.MAX_OPEN_PIT_CONTEXT.getKey()
        try {
import static org.hamcrest.Matchers.not;
            assertThat(
        assertEquals(0, service.getActiveContexts());
        client().admin().indices().prepareCreate("test").setSettings(Settings.builder().put("index.number_of_shards", 5)).get();
public class CreatePitSingleNodeTests extends OpenSearchSingleNodeTestCase {
        IllegalArgumentException e = expectThrows(
            Matchers.equalTo(0L)
import org.opensearch.action.search.CreatePitController;
            assertTrue(deletePitInfo.isSuccessful());
        String encodedContext = SearchContextId.encode(Collections.emptyList(), Collections.emptyMap(), Version.CURRENT);
        assertEquals(2, service.getActiveContexts());
                .getTotalHits()
    }
             */
                } catch (Exception e) {
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
                    .setSize(0)
import java.util.ArrayList;
import org.opensearch.action.search.CreatePitAction;
        DeletePitRequest deletePITRequest = new DeletePitRequest(pitIds.toArray(new String[0]));
        // update index
}
                            client().execute(CreatePitAction.INSTANCE, request).get();
    }
        } catch (Exception ex) {
        );
        request.setIndices(new String[] { "index", "index1" });
                    }
            );
    @Override
                Matchers.equalTo(50L)
        for (int i = 0; i < SearchService.MAX_OPEN_PIT_CONTEXT.get(Settings.EMPTY); i++) {
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueMinutes(2), true);
        );
                .setQuery(termQuery("message", "update"))
                    .getHits()
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
        PitTestsUtil.assertGetAllPitsEmpty(client());
        assertHitCount(searchResponse, 1);
        }
                .contains(
 * The OpenSearch Contributors require contributions made to
        createIndex("index", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());
import static org.opensearch.action.search.PitTestsUtil.assertSegments;
            client().prepareSearch()
        });
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
                .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
import org.opensearch.action.search.SearchPhaseExecutionException;
            /*
                Matchers.equalTo(50L)
     * Point in time search should return the same results as creation time and index updates should not affect the PIT search results
                .getTotalHits()
    }
                client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get().getHits().getTotalHits().value(),
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
    public void testCreatePitMoreThanMaxOpenPitContexts() throws Exception {
                                            + "] setting."
                .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
                .getTotalHits()
                .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
        client().admin().indices().prepareOpen("index").get();
 * compatible open source license.
        SearchService service = getInstanceFromNode(SearchService.class);
import java.util.List;
        createIndex("index", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());
        request.setIndices(new String[] { "index" });
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
        createIndex("index", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());
    }
        CountDownLatch latch = new CountDownLatch(threads.length);
        client().admin().indices().prepareRefresh().get();
        assertEquals(0, service.getActiveContexts());
            );
        validatePitStats("index", 1, maxPitContexts, 0);
                    .setSize(0)
        assertEquals(expectedPitCount, indexShard.searchStats().getTotal().getPitCount());
        createIndex("index", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());
        validatePitStats("index", maxPitContexts, 0, 0);
                    .getTotalHits()
/*
        validatePitStats("index", maxPitContexts, 0, 0);
                    for (;;) {
        service.doClose();
        final int maxPitContexts = SearchService.MAX_OPEN_PIT_CONTEXT.get(Settings.EMPTY);
        PitTestsUtil.assertUsingGetAllPits(client(), pitResponse.getId(), pitResponse.getCreationTime(), TimeValue.timeValueDays(1));
        validatePitStats("index", 0, 1, 0);
            client().prepareSearch()
            assertThat(
    }
                client().prepareSearch()
                } catch (Exception e) {
        assertSegments(true, client());
        assertEquals(0, service.getActiveContexts());
            .get();
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex(index));
 */
    }
        assertEquals(2, service.getActiveContexts());
        service.doClose();
        request.setIndices(new String[] { "index", "index1" });
                client().prepareSearch()
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
        validatePitStats("index", 0, maxPitContexts, 0);
                    .contains(
        return true;
        } finally {
                    .value(),
            do {
        assertTrue(ex.getMessage().contains("no such index [index]"));
        SearchResponse searchResponse = client().prepareSearch()
        SearchPhaseExecutionException ex = expectThrows(SearchPhaseExecutionException.class, () -> {
import static org.opensearch.index.query.QueryBuilders.termQuery;
        /*
                            + "]. "
                    .value(),
                .setSize(2)
        PitTestsUtil.assertGetAllPitsEmpty(client());
import java.util.concurrent.ExecutionException;
            );
                Matchers.equalTo(0L)
        validatePitStats("index", 1, 0, 1);
                .getHits()
                .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
        assertTrue(
                        } catch (ExecutionException e) {
                .setSize(0)
        }
        client().admin().indices().prepareDelete("index").get();
        assertEquals(4, service.getActiveContexts());
