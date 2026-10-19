                    .get()
        client().prepareIndex("index1").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
            });
                try {
        CreatePitResponse pitResponse = execute.get();
            assertSegments(true, client());  
        service.doClose();
                    .getHits()  
            assertThat(
        service.doClose(); // this kills the keep-alive reaper we have to reset the node after this test
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
    public void testPitSearchOnDeletedIndex() throws ExecutionException, InterruptedException {  
        assertHitCount(searchResponse, 1);
        request.setIndices(new String[] { "index" });
                    .setSize(0)  
            assertThat(
            service.doClose();
        request.setIndices(new String[] { "index" });  
    }
        ExecutionException ex = expectThrows(ExecutionException.class, execute::get);
                    "Trying to create too many Point In Time contexts. "
import org.opensearch.index.IndexService;
    public void testCreatePITWithMultipleIndicesSuccess() throws ExecutionException, InterruptedException {
                .setSize(0)
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
                client().prepareSearch().setSize(0).setQuery(termQuery("message", "test")).get().getHits().getTotalHits().value(),
        try {
        Thread[] threads = new Thread[randomIntBetween(2, 8)];
                client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get().getHits().getTotalHits().value(),
        validatePitStats("index", 0, 1, 1);
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();  
                .setSize(0)  
        validatePitStats("index", 0, 1, 0);  
            );
            .get();  
            assertThat(  
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();  
        service.doClose();
        validatePitStats("index", maxPitContexts, 0, 0);  
                            + "]. "
            assertThat(
        for (DeletePitInfo deletePitInfo : deletePITResponse.getDeletePitResults()) {  
                Matchers.equalTo(50L)
        assertEquals(0, service.getActiveContexts());
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
                    .setQuery(termQuery("message", "update"))  
            .put(SearchService.KEEPALIVE_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(1))
                        .endObject()
            }  
                .setSize(2)
        );
                Matchers.equalTo(50L)  
        request.setIndices(new String[] { "index" });
        validatePitStats("index", maxPitContexts, 0, 0);  
                            + "This limit can be set by changing the [search.max_open_pit_context] setting."  
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
            assertThat(deletePitInfo.getPitId(), not(blankOrNullString()));
        assertHitCount(searchResponse, 1);
import org.opensearch.common.action.ActionFuture;  
                .setQuery(matchAllQuery())
import org.opensearch.indices.IndicesService;  
                .getTotalHits()
                    .getTotalHits()
                                            + SearchService.MAX_OPEN_PIT_CONTEXT.getKey()  
        Thread[] threads = new Thread[5];
            .build();
import org.opensearch.search.sort.SortOrder;
        validatePitStats("index", 1, 0, 0);
                }  
                    .setSize(0)
            client().execute(CreatePitAction.INSTANCE, request).get();
        assertEquals(0, service.getActiveContexts());  
        assertTrue(ex.shardFailures()[0].reason().contains("SearchContextMissingException"));  
        SearchService service = getInstanceFromNode(SearchService.class);  
        client().admin().indices().prepareDelete("index").get();
import org.opensearch.action.search.DeletePitRequest;
            validatePitStats("test", 1, 0, 0);  
        validatePitStats("index", 1, 0, 1);  
                    .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
            /*
                        + "Must be less than or equal to: ["
        } catch (Exception ex) {
              using point in time id will have the same search results as ones before update
        PitTestsUtil.assertUsingGetAllPits(client(), response.getId(), response.getCreationTime(), TimeValue.timeValueDays(1));  
import org.hamcrest.Matchers;
                .get();
import java.util.Map;  
                            client().execute(CreatePitAction.INSTANCE, request).get();
        });  
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
            client().prepareSearch()
            Matchers.equalTo(50L)
         */  
/**  
        createIndex("index", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());
        for (int i = 0; i < threads.length; i++) {
                        client().prepareSearch()
import org.opensearch.action.search.CreatePitAction;
            .put(CreatePitController.PIT_INIT_KEEP_ALIVE.getKey(), TimeValue.timeValueSeconds(1))  
            .get();  
        CreatePitResponse pitResponse = execute.get();
        );
            client().prepareSearch()
        request.setIndices(new String[] { "index" });
import org.opensearch.index.IndexNotFoundException;  
                .getHits()
                    .setSize(0)
        request.setIndices(new String[] { "index" });  
        assertSegments(false, client(), pitResponse.getId());
                client().prepareSearch().setSize(0).setQuery(termQuery("message", "update")).get().getHits().getTotalHits().value(),
        }
                Matchers.equalTo(50L)  
              assert without point in time  
        // update index
        );
        client().admin().indices().prepareCreate("test").setSettings(Settings.builder().put("index.number_of_shards", 5)).get();  
        request.setIndices(new String[] { "index" });  
                .value(),  
        assertSegments(false, client(), response.getId());
                        + "]. "
            );
            IllegalArgumentException.class,
import static org.opensearch.action.search.PitTestsUtil.assertSegments;
                    .contains(
        return Settings.builder()  
        validatePitStats("index1", 0, 1, 0);
 */
            threads[i] = new Thread(() -> {  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
            assertTrue(deletePitInfo.isSuccessful());
                                        "Trying to create too many Point In Time contexts. "
        validatePitStats("index", 1, 0, 1);  
        createIndex("index", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());
                    .value(),
    public void testCreatePITWithNonExistentIndex() {
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
import static org.opensearch.index.query.QueryBuilders.termQuery;  
                searchResponse = client().prepareSearch().setSize(0).setQuery(termQuery("message", "test")).get();
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();  
        validatePitStats("index", 1, 0, 1);
            Matchers.equalTo(0L)
                    .get()
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        });
        assertEquals(0, service.getActiveContexts());
        String id = encodedContext.substring(0, encodedContext.length() - 1);  
        assertThat(service.getActiveContexts(), equalTo(maxPitContexts));
        assertSegments(true, client());
                try {
                    .getHits()
                .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))  
    /**
        assertThat(
                    .value(),
            client().prepareSearch()
                .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))  
                    for (;;) {  
import org.opensearch.action.search.PitTestsUtil;
import java.util.concurrent.CountDownLatch;
        SearchService service = getInstanceFromNode(SearchService.class);  
                .get();
        validatePitStats("index", 0, 1, 1);
/*  
        createIndex("index", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());  
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);  
                .setSize(0)
        PitTestsUtil.assertGetAllPitsEmpty(client());  
        client().prepareIndex("index").setId("2").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
        SearchService service = getInstanceFromNode(SearchService.class);
                        }
            Matchers.equalTo(0L)
        client().admin().indices().prepareOpen("index").get();
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
    }  
                .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
import static org.hamcrest.CoreMatchers.equalTo;
import org.opensearch.common.unit.TimeValue;
            validatePitStats("test", 0, 1, 0);
                    .getHits()
        createIndex("index", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());
                client().prepareSearch()  
        String encodedContext = SearchContextId.encode(Collections.emptyList(), Collections.emptyMap(), Version.CURRENT);
                        try {
        // PIT reader contexts are lost after close, verifying it with open index api
                    client().prepareIndex("test").setId(searchHit.getId()).setSource(map).get();  
    @Override  
        assertEquals(2, service.getActiveContexts());
                .value(),  
            assertThat(  
    }
            );
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex(index));  
        assertSegments(false, client(), pitResponse.getId());
        validatePitStats("index", 1, 0, 0);
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
     * Point in time search should return the same results as creation time and index updates should not affect the PIT search results  
                                e.getMessage()
import org.opensearch.action.search.CreatePitController;  
        service.doClose();  
                .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))  
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
        validatePitStats("index", 1, maxPitContexts, 0);  
        assertSegments(true, client());  
                .getHits()
        for (Thread thread : threads) {
                .get()  
        client().execute(CreatePitAction.INSTANCE, request).get();
        SearchService service = getInstanceFromNode(SearchService.class);
                            .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
                Matchers.equalTo(0L)
    public void testInvalidPitId() {  
                            .execute()
            );  
        PitTestsUtil.assertGetAllPitsEmpty(client());
                    .setQuery(termQuery("message", "test"))
public class CreatePitSingleNodeTests extends OpenSearchSingleNodeTestCase {  
        assertEquals(4, response.getSuccessfulShards());
                .setSize(2)
    }
        CreatePitResponse pitResponse = execute.get();  
        /*  
import org.opensearch.action.search.CreatePitRequest;
    protected Settings nodeSettings() {
        validatePitStats("index", 0, maxPitContexts, 0);
        SearchPhaseExecutionException ex = expectThrows(SearchPhaseExecutionException.class, () -> {  
        }
        service.doClose();
        PitTestsUtil.assertUsingGetAllPits(client(), pitResponse.getId(), pitResponse.getCreationTime(), TimeValue.timeValueDays(1));  
                if (cpr.getId() != null) pitIds.add(cpr.getId());
        CountDownLatch latch = new CountDownLatch(threads.length);  
            );
        SearchService service = getInstanceFromNode(SearchService.class);  
            for (int i = 0; i < 1000; i++) {  
                    .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
                Matchers.equalTo(50L)
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);  
                .value(),
    public void testCreatePITSuccess() throws ExecutionException, InterruptedException {
                )  
        SearchResponse searchResponse = client().prepareSearch()
            );  
        assertEquals(expectedPitCurrent, indexShard.searchStats().getTotal().getPitCurrent());
        assertEquals(0, service.getActiveContexts());
            do {
                .value(),  
        try {
            .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
                client().prepareSearch()
                        .field("user", "foobar")
        createIndex("index1", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());
                            + SearchService.MAX_OPEN_PIT_CONTEXT.get(Settings.EMPTY)
            assertThat(
        }  
            thread.join();  
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);  
        validatePitStats("index", maxPitContexts, 0, 0);
            threads[i].setName("opensearch[node_s_0][search]");
import org.opensearch.common.settings.Settings;
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
        }
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
             */  
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
            assertThat(  
        );  
                            .get();  
                .setSize(2)  
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);  
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
                    latch.await();  
        });
import java.util.ArrayList;  
            .setSize(50)
        IndexShard indexShard = indexService.getShard(shardId);
        PitTestsUtil.assertUsingGetAllPits(client(), pitResponse.getId(), pitResponse.getCreationTime(), TimeValue.timeValueMinutes(2));
                client().prepareSearch()
            .addSort("postDate", SortOrder.ASC)
    }
        assertTrue(ex.getMessage().contains("IndexClosedException"));  
        assertEquals(4, service.getActiveContexts());  
    }
                .setQuery(termQuery("message", "test"))
                .getHits()
                    map.put("message", "update");
        final int maxPitContexts = SearchService.MAX_OPEN_PIT_CONTEXT.get(Settings.EMPTY);
        validatePitStats("index", 1, 0, 0);
                .getTotalHits()
        assertTrue(ex.getMessage().contains("no such index [index]"));
        service.doClose();
                        + SearchService.MAX_OPEN_PIT_CONTEXT.get(Settings.EMPTY)  
        client().admin().indices().prepareClose("index").get();
import org.opensearch.action.search.SearchResponse;
                Matchers.equalTo(0L)
                Matchers.equalTo(0L)
            .setSize(2)
        SearchService service = getInstanceFromNode(SearchService.class);
        SearchResponse searchResponse = client().prepareSearch("index")  
import org.opensearch.search.builder.PointInTimeBuilder;
            /*
    }
        createIndex("index", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());
            threads[i].start();
    public void testConcurrentSearches() throws Exception {
    public void testPitSearchOnCloseIndex() throws ExecutionException, InterruptedException {
        SearchService service = getInstanceFromNode(SearchService.class);  
     */
                .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))  
import static org.hamcrest.Matchers.not;
                .getTotalHits()
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();
 * SPDX-License-Identifier: Apache-2.0
        client().prepareIndex("index").setId("2").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();  
                client().prepareSearch()
                } catch (Exception e) {
        validatePitStats("index", 0, maxPitContexts + 1, 0);
    }  
        client().admin().indices().prepareRefresh().get();  
        CountDownLatch latch = new CountDownLatch(threads.length);  
                    .getTotalHits()  
                    .setSize(0)
                    .get()  
        assertEquals(0, service.getActiveContexts());
        client().admin().indices().prepareClose("index").get();
                            return;
        }
        SearchService service = getInstanceFromNode(SearchService.class);
                                            + "] setting."
        validatePitStats("index", 1, 0, 0);  
                    }  
                .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))  
    public void validatePitStats(String index, long expectedPitCurrent, long expectedPitCount, int shardId) throws ExecutionException,  
          When we invoke delete again, returns success after clearing the remaining readers. Asserting reader context
                .get();
        validatePitStats("index", 0, maxPitContexts, 0);
        ex = expectThrows(SearchPhaseExecutionException.class, () -> {  
        request.setIndices(new String[] { "index" });  
        PitTestsUtil.assertGetAllPitsEmpty(client());
                                            + "]. "
                client().prepareSearch().setSize(0).setQuery(termQuery("message", "update")).get().getHits().getTotalHits().value(),  
                    throw new AssertionError(e);  
            } while (searchResponse.getHits().getHits().length > 0);
        for (Thread thread : threads) {  
                    for (int j = 0; j < 50; j++) {
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
    }
        service.doClose();
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
                .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
        assertThat(
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();  
        }
    public void testCreatePitMoreThanMaxOpenPitContexts() throws Exception {
        final int maxPitContexts = SearchService.MAX_OPEN_PIT_CONTEXT.get(Settings.EMPTY);
        validatePitStats("index", 0, 1, 0);  
        }
                    .setQuery(termQuery("message", "update"))
}
                                            + SearchService.MAX_OPEN_PIT_CONTEXT.get(Settings.EMPTY)  
            assertThat(
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
                .setSize(0)
        SearchService service = getInstanceFromNode(SearchService.class);
        createIndex("index", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 1).build());
        createIndex("index");  
        ExecutionException ex = expectThrows(ExecutionException.class, execute::get);
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);  
                .getTotalHits()  
            .setQuery(queryStringQuery("user:foobar"))  
                            + "Must be less than or equal to: ["  
        request.setIndices(new String[] { "index" });
                .getHits()
        validatePitStats("index", 0, maxPitContexts, 0);
                            assertTrue(
 *
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
                        .field("postDate", System.currentTimeMillis())  
                    .value(),  
    }
        service.doClose();
                        "Trying to create too many Point In Time contexts. "
                client().prepareSearch().setSize(0).setQuery(termQuery("message", "test")).get().getHits().getTotalHits().value(),
            });
                .get()
        assertSegments(true, client());
            );
        );
import org.opensearch.action.search.DeletePitAction;  
        assertEquals(2, service.getActiveContexts());
        // very frequent checks
        client().prepareIndex("index").setId("2").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
                                    .contains(  
            Matchers.equalTo(50L)
        validatePitStats("index", 0, 1, 0);  
    public void testCreatePITOnCloseIndex() throws ExecutionException, InterruptedException {  
        validatePitStats("index", 0, 1, 1);
            .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
                        } catch (ExecutionException e) {  
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
        assertTrue(
        request.setIndices(new String[] { "index", "index1" });
                .setId(Integer.toString(i))
                    .getTotalHits()
            Matchers.equalTo(50L)  
        validatePitStats("index1", 1, 0, 0);  
        request.setIndices(new String[] { "test" });
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
 * Single node integration tests for various PIT use cases such as create pit, search etc
                                            + "This limit can be set by changing the ["
        createIndex("idx");
import org.opensearch.action.search.DeletePitInfo;
            assertTrue(
        for (int i = 0; i < 50; i++) {  
            );
                    .value(),  
        for (int i = 0; i < SearchService.MAX_OPEN_PIT_CONTEXT.get(Settings.EMPTY); i++) {
        );
                .getTotalHits()
        assertTrue(ex.shardFailures()[0].reason().contains("SearchContextMissingException"));  
                                            + "Must be less than or equal to: ["
        );
                .get();
        request.setIndices(new String[] { "index" });
                .setQuery(termQuery("message", "test"))
            .setSize(2)
        }  
            client().prepareSearch()
            client().prepareSearch()
                    )
            threads[i] = new Thread(() -> {
                .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
            .put(super.nodeSettings())
        IllegalArgumentException e = expectThrows(
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
                latch.countDown();
        assertTrue(ex.getMessage().contains("no such index [index1]"));  
        InterruptedException {
import org.opensearch.index.shard.IndexShard;
        SearchResponse searchResponse = client().prepareSearch("index")  
        IndexNotFoundException ex = expectThrows(IndexNotFoundException.class, () -> {
                    throw new AssertionError(e);
        // create pit
            client().prepareIndex("test")
            threads[i].start();  
    }
import org.opensearch.action.search.SearchPhaseExecutionException;  
        createIndex("index", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());
    }
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
        } finally {
        validatePitStats("index", 0, 1, 0);
        final int maxPitContexts = SearchService.MAX_OPEN_PIT_CONTEXT.get(Settings.EMPTY);
            SearchResponse searchResponse = client().prepareSearch()
    }  
            assertEquals(0, service.getActiveContexts());  
        validatePitStats("index", 1, 0, 1);  
            PitTestsUtil.assertGetAllPitsEmpty(client());
        assertEquals(2, service.getActiveContexts());
            client().prepareSearch()  
                CreatePitResponse cpr = client().execute(CreatePitAction.INSTANCE, request).actionGet();
        assertSegments(true, client());
                .setPointInTime(new PointInTimeBuilder(id).setKeepAlive(TimeValue.timeValueDays(1)))
            assertThat(
            () -> client().prepareSearch()  
import org.opensearch.Version;
        PitTestsUtil.assertGetAllPitsEmpty(client());  
        CreatePitResponse response = execute.get();
        assertThat(
            ex.getMessage()
                .get()  
        PitTestsUtil.assertUsingGetAllPits(client(), pitResponse.getId(), pitResponse.getCreationTime(), TimeValue.timeValueDays(1));
        assertEquals("invalid id: [" + id + "]", e.getMessage());
import org.opensearch.common.Priority;
    protected boolean resetNodeAfterTest() {
        service.doClose();  
        assertThat(  
        SearchService service = getInstanceFromNode(SearchService.class);
                Matchers.equalTo(0L)  
 * The OpenSearch Contributors require contributions made to  
        assertSegments(true, client());
                    .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))  
                .value(),
        for (int i = 0; i < threads.length; i++) {
 */  
            client().prepareSearch()
        CreatePitResponse pitResponse = execute.get();
                .setSize(2)
                }
                                    )
                latch.countDown();  
import static org.hamcrest.Matchers.blankOrNullString;  
 * compatible open source license.
            thread.join();
                )  
import org.opensearch.action.search.CreatePitResponse;
                    .setQuery(termQuery("message", "test"))
        DeletePitRequest deletePITRequest = new DeletePitRequest(pitIds.toArray(new String[0]));
        SearchService service = getInstanceFromNode(SearchService.class);
                            .setSize(2)  
                .setSource(  
        PitTestsUtil.assertUsingGetAllPits(client(), pitResponse.getId(), pitResponse.getCreationTime(), TimeValue.timeValueDays(1));  
                Matchers.equalTo(50L)
        PitTestsUtil.assertUsingGetAllPits(client(), pitResponse.getId(), pitResponse.getCreationTime(), TimeValue.timeValueDays(1));  
                .get()  
    }  
            );  
        List<String> pitIds = new ArrayList<>();  
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
    public void testOpenPitContextsConcurrently() throws Exception {
                    latch.await();
        SearchService service = getInstanceFromNode(SearchService.class);
 * this file be licensed under the Apache-2.0 license or a
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);  
    @Override
        assertEquals(0, service.getActiveContexts());  
                for (SearchHit searchHit : searchResponse.getHits().getHits()) {  
import org.opensearch.action.search.DeletePitResponse;  
                .contains(  
          not found exceptions don't result in failures ( as deletion in one node is successful )
        CreatePitResponse pitResponse = execute.get();
        ExecutionException ex = expectThrows(ExecutionException.class, execute::get);
        createIndex("index", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());
                    jsonBuilder().startObject()
import java.util.Collections;
                .setSize(0)
        service.doClose();
package org.opensearch.search;
                            );  
        assertSegments(false, client(), pitResponse.getId());
        assertSegments(false, client(), pitResponse.getId());
import java.util.concurrent.ExecutionException;
                ((SearchPhaseExecutionException) ex).getDetailedMessage()  
                        .field("message", "test")
            threads[i].setName("opensearch[node_s_0][search]");  
        assertSegments(true, client());
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();  
                .getHits()  
    public void testPitAfterUpdateIndex() throws Exception {
        return true;  
    }
import java.util.List;
        // deleteall  
                    .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))  
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueMinutes(2), true);  
    public void testMaxOpenPitContexts() throws Exception {
        assertEquals(2, service.getActiveContexts());
        request.setIndices(new String[] { "index", "index1" });
        service.doClose();  
        }  
                        + "This limit can be set by changing the [search.max_open_pit_context] setting."
        createIndex("index");  
            client().admin().indices().prepareRefresh().get();  
                    Map<String, Object> map = searchHit.getSourceAsMap();
            .get();  
        validatePitStats("index", 1, 0, 0);
             */
                .setQuery(termQuery("message", "update"))
        DeletePitResponse deletePITResponse = execute.get();
                .setQuery(termQuery("message", "update"))  
                } catch (Exception e) {
                .get()  
        assertSegments(true, client());
        assertThat(
                    }
                }
    }  
import org.opensearch.action.search.SearchContextId;
                    .get()  
        createIndex("index");  
                    .getTotalHits()
    public void testCreatePITWithShardReplicasSuccess() throws ExecutionException, InterruptedException {
        ActionFuture<DeletePitResponse> execute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);
        assertEquals(expectedPitCount, indexShard.searchStats().getTotal().getPitCount());  
        CreatePitResponse pitResponse = execute.get();  
                .get()
            );
                    .getHits()
