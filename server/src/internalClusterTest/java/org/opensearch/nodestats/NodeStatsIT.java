import java.util.LinkedHashMap;
     * individual data nodes instead and pre-compute information as required.
                    )
                expectedDocStatusStats.getDocStatusCounter(),
import java.util.Map;  
                UpdateResponse response = client().update(new UpdateRequest(INDEX, ID).doc(SOURCE)).actionGet();
import org.hamcrest.MatcherAssert;  
            )
                        VersionConflictEngineException.class,
        testLevels.add("unknown");  
     * Default behavior - without consideration of request level param on level, the NodeStatsRequest always  
import org.opensearch.common.xcontent.XContentFactory;  
 * The OpenSearch Contributors require contributions made to  
                    Map<String, Object> xContentMap = xContentBuilderToMap(builder);
        ensureGreen();  
        UNKNOWN("unknown");
            }
                level_arg.add(testLevel.getRestName());
                Comparator.comparingLong(LongAdder::longValue)
import org.opensearch.action.delete.DeleteRequest;
            final String ID = "id";  
import org.opensearch.action.DocWriteResponse;
     * Aggregated behavior - to avoid unnecessary IO in the form of shard-stats when not required, we not honor the levels on the  
                            builder,  
    }  
import org.opensearch.action.update.UpdateRequest;
                updateExpectedDocStatusCounter(itemResponse.getResponse());  
                            )
                assertDocStatusStats();  
                    .toXContent(
    private static final String FIELD = "dummy_field";  
import org.opensearch.index.engine.VersionConflictEngineException;
                MatcherAssert.assertThat(response.getResult(), equalTo(DocWriteResponse.Result.CREATED));  
import org.opensearch.action.delete.DeleteResponse;
                updateExpectedDocStatusCounter(itemResponse.getResponse());
                    )  
                );  
        testLevels.forEach(testLevel -> {
                assertTrue(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.INDICES.getRestName()));  
        MockStatsLevel(String restName) {  
                Map<String, Object> xContentMap = xContentBuilderToMap(builder);
            assertDocStatusStats();
                    expectedDocStatusStats.getDocStatusCounter(),
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    );
            .getDocStatusStats();
            try {  
                bulkRequest.add(new DeleteRequest(INDEX, String.valueOf(i)));  
            }  
            BulkResponse response = client().bulk(bulkRequest).actionGet();
        {  // Testing Index
        }  
                builder = nodeStats.getIndices()  
                assertDocStatusStats();
            }
                            builder,  
                } else {  
            commonStatsFlags.setIncludeIndicesStatsByLevel(true);
            } else {  
import java.util.List;
        testLevels.forEach(testLevel -> {  
            final String INDEX = "create_index";  
            }
            MatcherAssert.assertThat(response.hasFailures(), equalTo(false));
        List<String> testLevels = new ArrayList<>();
                XContentBuilder builder = XContentFactory.jsonBuilder();
            .execute()
                                new ToXContent.MapParams(
                    LinkedHashMap indicesStatsMap = (LinkedHashMap) xContentMap.get(NodeIndicesStats.StatsLevel.INDICES.getRestName());  
                );
            int sizeOfNotFoundRequests = scaledRandomIntBetween(5, sizeOfIndexRequests);  
        assertEquals("Level provided is not supported by NodeIndicesStats", response.failures().get(0).getCause().getCause().getMessage());  
                        VersionConflictEngineException.class,
                updateExpectedDocStatusCounter(
                    )
                Arrays.equals(
        );
            }  
                    IllegalArgumentException.class,  
                builder = XContentFactory.jsonBuilder();
    private void assertDocStatusStats() {
            .actionGet()  
                docStatusStats.getDocStatusCounter(),  
                IndexResponse response = client().index(new IndexRequest(INDEX).id(ID).source(SOURCE).create(true)).actionGet();
                        () -> client().update(new UpdateRequest(INDEX, ID).doc(SOURCE)).actionGet()
                updateExpectedDocStatusCounter(  
        });  
                    Comparator.comparingLong(LongAdder::longValue)
            final String INDEX = "update_index";
            final String ID = "id";
    public void testNodeIndicesStatsDocStatusStatsIndexBulk() {
                    )  
                        new ToXContent.MapParams(Collections.singletonMap("level", NodeIndicesStats.StatsLevel.SHARDS.getRestName()))  
                builder = XContentFactory.jsonBuilder();
 * SPDX-License-Identifier: Apache-2.0
                        () -> client().delete(new DeleteRequest(INDEX, docId).setIfSeqNo(2L).setIfPrimaryTerm(99L)).actionGet()  
                MatcherAssert.assertThat(response.getResult(), equalTo(DocWriteResponse.Result.CREATED));
                updateExpectedDocStatusCounter(client().index(new IndexRequest(INDEX).id(docId).source(SOURCE)).actionGet());
                    Map<String, Object> xContentMap = xContentBuilderToMap(builder);
                updateExpectedDocStatusCounter(client().index(new IndexRequest(INDEX).id(ID).source(SOURCE)).actionGet());
                            )
            DocStatusStats docStatusStats = client().admin()
            );
                assertFalse(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.INDICES.getRestName()));  
        public String getRestName() {
                DeleteResponse deleteResponse = client().delete(new DeleteRequest(INDEX, ID)).actionGet();  
            for (int i = 0; i < sizeOfNotFoundRequests; ++i) {
 */  
                } else {  
                builder = nodeStats.getIndices().toXContent(builder, ToXContent.EMPTY_PARAMS);
                            break;  
                final String docId = "version_conflict";
                    () -> client().index(new IndexRequest(INDEX).id("missing_pipeline").setPipeline("missing").source(SOURCE)).actionGet()
                        () -> client().update(new UpdateRequest(INDEX, ID).setRequireAlias(true).doc(new IndexRequest().source(SOURCE)))
        );
                                    Collections.singletonMap("level", NodeIndicesStats.StatsLevel.INDICES.getRestName())
                builder.startObject();
                        AssertionError.class,  
            }
    private void updateExpectedDocStatusCounter(DocWriteResponse r) {
                indicesStatsMap = (LinkedHashMap) xContentMap.get(NodeIndicesStats.StatsLevel.INDICES.getRestName());
            expectedDocStatusStats.inc(response.status());
            for (BulkItemResponse itemResponse : response.getItems()) {
            prepareCreate(  
            {  
        assertAcked(
            final String INDEX = "create_index";
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
                    assertThrows(
import org.opensearch.indices.NodeIndicesStats;
            }  
                assertFalse(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.INDICES));  
                clusterService().state().getNodes().getSize(),
    }
import org.opensearch.action.admin.cluster.node.stats.NodeStats;  
import org.opensearch.common.xcontent.XContentHelper;
        internalCluster().startNode();
                throw new RuntimeException(e);  
        });
                if (!(testLevel.equals(MockStatsLevel.SHARDS) || testLevel.equals(MockStatsLevel.INDICES))) {
                assertDocStatusStats();
import org.opensearch.action.bulk.BulkResponse;  
            Arrays.equals(
            commonStatsFlags.setIncludeIndicesStatsByLevel(true);
                        "Expected shard stats or index stats in response for generating INDICES field",
            {  // Testing Creation  
            int sizeOfDeleteRequests = scaledRandomIntBetween(5, sizeOfIndexRequests);
                );
                                failedBuilder,  
                .setIndices(commonStatsFlags)
    private void updateExpectedDocStatusCounter(Exception e) {
                            .toXContent(
            refresh(INDEX);
            {  // Testing NoOp Update
     */
        commonStatsFlags.setLevels(level_arg.toArray(new String[0]));
                // Test Missing Pipeline: Ingestion failure, not Indexing failure
                updateExpectedDocStatusCounter(client().index(new IndexRequest(INDEX).id(docId).source(SOURCE)).actionGet());
                            .actionGet()
                    assertThrows(
            MatcherAssert.assertThat(response.getItems().length, equalTo(sizeOfIndexRequests));
    }  
                .get(0)
public class NodeStatsIT extends OpenSearchIntegTestCase {  
    private enum MockStatsLevel {  
                CommonStatsFlags commonStatsFlags = new CommonStatsFlags();  
    public void testNodeIndicesStatsDocStatusStatsCreateDeleteUpdate() {
                builder.startObject();  
                        case SHARDS:
            }
        assertAcked(
            }
            }  
            final String ID = "id";
        NULL("null"),
                .getNodes()
                        );
            {  // Testing Normal Index
                    }
            }
                ArrayList<String> level_arg = new ArrayList<>();  
    private static final String VALUE = "dummy_value";
                // Without any param - default is level = nodes
                builder.endObject();
            }
        CommonStatsFlags commonStatsFlags = new CommonStatsFlags();  
                assertDocStatusStats();
                        "Expected shard stats in response for generating [SHARDS] field",
        ensureGreen();  
import org.opensearch.action.update.UpdateResponse;  
        String indexName = "test1";
}  
            response = client().admin().cluster().prepareNodesStats().setIndices(commonStatsFlags).get();  
    }  
    private static final Map<String, Object> SOURCE = singletonMap(FIELD, VALUE);
                assertTrue(indexLevelStats.containsKey(indexName));
                assertDocStatusStats();
        {  // Testing Delete
                final String UPDATED_VALUE = "updated_value";
        testLevels.add(NodeIndicesStats.StatsLevel.SHARDS.getRestName());
                    final XContentBuilder failedBuilder = builder;  
        }
    public void testNodeIndicesStatsUnknownLevelThrowsException() {  
        commonStatsFlags.setIncludeIndicesStatsByLevel(true);
import org.opensearch.common.settings.Settings;
            }
                expectThrows(
                updateExpectedDocStatusCounter(
            DocStatusStats expectedDocStatusStats = new DocStatusStats();
        NodesStatsResponse response;
        }
                assertDocStatusStats();
                indexName,
    public void testNodeIndicesStatsDocStatsWithAggregations() {
            }  
                        .toXContent(
                builder.endObject();
        testLevels.add("null");
            NodeStats nodeStats = response.getNodes().get(0);
                    docStatusStats.getDocStatusCounter(),  
            final String ID = "id";
            {  // Testing Deletion
                indexName,
                    builder.endObject();  
import java.util.concurrent.atomic.LongAdder;
    }
                builder.endObject();
                assertDocStatusStats();
                    final XContentBuilder failedBuilder = builder;  
                updateExpectedDocStatusCounter(
    }  
    private final DocStatusStats expectedDocStatusStats = new DocStatusStats();
                MatcherAssert.assertThat(response.getSeqNo(), greaterThanOrEqualTo(0L));  
                .execute()
            refresh(INDEX);  
            )  
@ClusterScope(scope = Scope.TEST, numDataNodes = 1, numClientNodes = 0, supportsDedicatedMasters = false)
                assertDocStatusStats();
                updateExpectedDocStatusCounter(response);
        ArrayList<String> level_arg = new ArrayList<>();
                updateExpectedDocStatusCounter(response);
                Settings.builder().put("number_of_shards", 2).put("number_of_replicas", clusterService().state().getNodes().getSize() - 1)  
            MatcherAssert.assertThat(response.hasFailures(), equalTo(false));
                            new ToXContent.MapParams(Collections.singletonMap("level", NodeIndicesStats.StatsLevel.INDICES.getRestName()))
                    expectThrows(
                );
import org.opensearch.action.bulk.BulkItemResponse;
        expectedDocStatusStats.inc(r.status());
        testLevels.add(MockStatsLevel.SHARDS);  
    }
import org.opensearch.index.engine.DocumentMissingException;  
                        IndexNotFoundException.class,  
        ensureGreen();  
                        );
                    LinkedHashMap shardStats = (LinkedHashMap) indicesStatsMap.get(NodeIndicesStats.StatsLevel.SHARDS.getRestName());
                assertDocStatusStats();
        List<MockStatsLevel> testLevels = new ArrayList<>();
    }
                        () -> client().index(new IndexRequest(INDEX).id(docId).source(SOURCE).create(true)).actionGet()
                builder = XContentFactory.jsonBuilder();
                updateExpectedDocStatusCounter(client().index(new IndexRequest(INDEX).id(docId).source(SOURCE)).actionGet());
                assertDocStatusStats();
                MatcherAssert.assertThat(response.getResult(), equalTo(DocWriteResponse.Result.UPDATED));  
                    );
            NodesStatsResponse response;  
import org.opensearch.action.index.IndexResponse;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
import org.opensearch.action.bulk.BulkRequest;
            int sizeOfIndexRequests = scaledRandomIntBetween(10, 20);
            {  // Testing Version Conflict
                    LinkedHashMap indicesStatsMap = (LinkedHashMap) xContentMap.get(NodeIndicesStats.StatsLevel.INDICES.getRestName());  
            for (int i = 0; i < sizeOfIndexRequests; ++i) {
                        new ToXContent.MapParams(Collections.singletonMap("level", NodeIndicesStats.StatsLevel.INDICES.getRestName()))  
                        case INDICES:  
                assertDocStatusStats();
            }  
            if (!testLevel.equals(MockStatsLevel.NULL)) {  
            .getIndices()  
                assertDocStatusStats();
import org.opensearch.action.index.IndexRequest;  
                        () -> nodeStats.getIndices()
                IndexResponse response = client().index(new IndexRequest(INDEX).id(ID).source(SOURCE)).actionGet();  
                response = client().admin().cluster().prepareNodesStats().setIndices(commonStatsFlags).get();
                        () -> nodeStats.getIndices()
        testLevels.add(NodeIndicesStats.StatsLevel.INDICES.getRestName());
                .prepareNodesStats()  
                    );
        String indexName = "test1";
                clusterService().state().getNodes().getSize(),
                assertFalse(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.SHARDS.getRestName()));
import java.util.Arrays;
                builder.startObject();  
                Settings.builder().put("number_of_shards", 2).put("number_of_replicas", clusterService().state().getNodes().getSize() - 1)  
                        builder,
        {  // Testing Bulk
                    )  
                    builder = nodeStats.getIndices()
                    LinkedHashMap shardStats = (LinkedHashMap) indicesStatsMap.get(NodeIndicesStats.StatsLevel.SHARDS.getRestName());
            assertNotNull(nodeStats.getIndices().getShardStats(clusterState.metadata().index(indexName).getIndex()));
import org.opensearch.action.admin.indices.stats.DocStatusStats;  
                        () -> client().update(new UpdateRequest(INDEX, docId).doc(SOURCE).setIfSeqNo(2L).setIfPrimaryTerm(99L)).actionGet()
import static java.util.Collections.singletonMap;  
import org.opensearch.cluster.ClusterState;
            prepareCreate(  
                commonStatsFlags.setLevels(level_arg.toArray(new String[0]));
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
    /**
import org.opensearch.core.xcontent.ToXContent;  
                        VersionConflictEngineException.class,
                xContentMap = xContentBuilderToMap(builder);
    }
                        AssertionError.class,  
        assertTrue(
            for (int i = 0; i < sizeOfDeleteRequests; ++i) {
                    expectThrows(  
                xContentMap = xContentBuilderToMap(builder);
                    )
                updateExpectedDocStatusCounter(client().delete(new DeleteRequest(INDEX, "does_not_exist")).actionGet());
    public void testNodeIndicesStatsXContentWithoutAggregationOnNodes() {  
                    )  
            }
            )
            response = client().bulk(bulkRequest).actionGet();  
                        VersionConflictEngineException.class,
                );
                                new ToXContent.MapParams(
            }  
                        builder,
                    .toXContent(
import java.util.Comparator;  
        }
import org.opensearch.index.IndexNotFoundException;
                );
        testLevels.add(MockStatsLevel.INDICES);
                updateExpectedDocStatusCounter(deleteResponse);
        }  
import org.opensearch.test.OpenSearchIntegTestCase;  
            this.restName = restName;
            final String INDEX = "test_index";  
                assertTrue(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.SHARDS.getRestName()));
                .getIndices()  
import org.opensearch.ExceptionsHelper;
            {  // Testing Version Conflict
        String indexName = "test1";
        NODE(NodeIndicesStats.StatsLevel.NODE.getRestName()),  
                    builder = nodeStats.getIndices()
import org.opensearch.core.xcontent.XContentBuilder;
        );
                                failedBuilder,  
                updateExpectedDocStatusCounter(client().index(new IndexRequest(INDEX).id(docId).source(SOURCE)).actionGet());
        testLevels.add(MockStatsLevel.NULL);  
        MockStatsLevel testLevel = MockStatsLevel.UNKNOWN;
                            .toXContent(
                        .toXContent(
            CommonStatsFlags commonStatsFlags = new CommonStatsFlags();
                clusterService().state().getNodes().getSize(),
        ensureGreen();  
                }
                .getDocStatusStats();
                .actionGet()  
                                )  
            try {  
        private final String restName;
        }  
        assertAcked(
                UpdateResponse response = client().update(new UpdateRequest(INDEX, ID).doc(singletonMap(FIELD, UPDATED_VALUE))).actionGet();  
            {  // Testing Not Found
    /**
import static org.hamcrest.Matchers.equalTo;
import java.util.ArrayList;  
                updateExpectedDocStatusCounter(response);
        );
                    LinkedHashMap indicesStats = (LinkedHashMap) indicesStatsMap.get(NodeIndicesStats.StatsLevel.INDICES.getRestName());
            bulkRequest.requests().clear();  
            {  // Testing Update
                    expectThrows(  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
            {  // Testing Non-Existing Doc
            BulkRequest bulkRequest = new BulkRequest();
import java.io.IOException;
                IndexResponse response = client().index(new IndexRequest(INDEX).id(ID).source(SOURCE)).actionGet();  
                    expectThrows(
            }
                bulkRequest.add(new IndexRequest(INDEX).id(String.valueOf(i)).source(SOURCE));
            if (!testLevel.equals("null")) {
        {  // Testing Create
                LinkedHashMap shardLevelStats = (LinkedHashMap) indicesStatsMap.get(NodeIndicesStats.StatsLevel.SHARDS.getRestName());  
                final String docId = "version_conflict";  
                        IndexNotFoundException.class,  
        SHARDS(NodeIndicesStats.StatsLevel.SHARDS.getRestName()),
                ArrayList<String> level_arg = new ArrayList<>();
        INDICES(NodeIndicesStats.StatsLevel.INDICES.getRestName()),
        internalCluster().startNode();
import org.opensearch.core.common.bytes.BytesReference;
 * this file be licensed under the Apache-2.0 license or a
                            .actionGet()
package org.opensearch.nodestats;
    }
            prepareCreate(  
                indexName,
                );
                    assertFalse(shardStats.isEmpty());
                indicesStatsMap = (LinkedHashMap) xContentMap.get(NodeIndicesStats.StatsLevel.INDICES.getRestName());
                    LinkedHashMap indicesStats = (LinkedHashMap) indicesStatsMap.get(NodeIndicesStats.StatsLevel.INDICES.getRestName());
                LinkedHashMap indicesStatsMap = (LinkedHashMap) xContentMap.get(NodeIndicesStats.StatsLevel.INDICES.getRestName());
            assertTrue(
                // With param containing level as 'indices', the indices stats are returned  
        return XContentHelper.convertToMap(BytesReference.bytes(xContentBuilder), true, xContentBuilder.contentType()).v2();
                    expectThrows(
        {  // Testing Create  
    }
            }
            {  // Testing Missing Alias  
            final String ID = "id";
        testLevels.add(NodeIndicesStats.StatsLevel.NODE.getRestName());  
     */
                            new ToXContent.MapParams(Collections.singletonMap("level", NodeIndicesStats.StatsLevel.SHARDS.getRestName()))
                response = client().admin().cluster().prepareNodesStats().get();
                    switch (testLevel) {
                level_arg.add(testLevel);
                    );
        testLevels.add(MockStatsLevel.NODE);
                .getStatusCounterStats()
            }
            {  // Testing Version Conflict
            .getNodes()
                commonStatsFlags.setLevels(level_arg.toArray(new String[0]));
        expectedDocStatusStats.inc(ExceptionsHelper.status(e));  
                updateExpectedDocStatusCounter(
                                    Collections.singletonMap("level", NodeIndicesStats.StatsLevel.SHARDS.getRestName())
                final String docId = "version_conflict";
            for (BulkItemResponse itemResponse : response.getItems()) {
/*  
    private Map<String, Object> xContentBuilderToMap(XContentBuilder xContentBuilder) {  
                );  
                builder.startObject();
                throw new RuntimeException(e);
            {  // Testing Version Conflict
                if (!testLevel.equals(MockStatsLevel.SHARDS)) {
            final String INDEX = "delete_index";  
                updateExpectedDocStatusCounter(response);
                    expectThrows(
            } catch (IOException e) {
            NodesStatsResponse response;
                updateExpectedDocStatusCounter(  
        internalCluster().startNode();
                updateExpectedDocStatusCounter(response);
 * compatible open source license.
                builder.startObject();  
            .get(0)
                    expectThrows(  
                assertDocStatusStats();  
        level_arg.add(testLevel.getRestName());  
            } catch (IOException e) {  
                bulkRequest.add(new DeleteRequest(INDEX, String.valueOf(25 + i)));  
        }
                LinkedHashMap indexLevelStats = (LinkedHashMap) indicesStatsMap.get(NodeIndicesStats.StatsLevel.INDICES.getRestName());  
            .cluster()  
        ensureGreen();  
import java.util.Collections;
                assertTrue(shardLevelStats.containsKey(indexName));
        response = client().admin().cluster().prepareNodesStats().setIndices(commonStatsFlags).get();  
            return restName;
                // With param containing level as 'shards', the shard stats are returned  
                        () -> client().index(new IndexRequest(INDEX).id(docId).source(SOURCE).setIfSeqNo(1L).setIfPrimaryTerm(99L))  
                            assertFalse(indicesStats.isEmpty());
                assertDocStatusStats();
            CommonStatsFlags commonStatsFlags = new CommonStatsFlags();
                .cluster()
                Settings.builder().put("number_of_shards", 2).put("number_of_replicas", clusterService().state().getNodes().getSize() - 1)  
 *
            MatcherAssert.assertThat(response.getItems().length, equalTo(sizeOfDeleteRequests + sizeOfNotFoundRequests));  
                        () -> client().index(new IndexRequest(INDEX).id("missing_alias").setRequireAlias(true).source(SOURCE)).actionGet()
    public void testNodeIndicesStatsXContentWithAggregationOnNodes() {  
            }
                builder = nodeStats.getIndices()  
                updateExpectedDocStatusCounter(
                }  
                assertFalse(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.SHARDS));
                                )  
                final String docId = "version_conflict";  
            {  // Testing Missing Alias  
            IndexResponse response = client().index(new IndexRequest(INDEX).id(ID).source(SOURCE).create(true)).actionGet();
            .getStatusCounterStats()
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
            .prepareNodesStats()
                XContentBuilder builder = XContentFactory.jsonBuilder();
            final String INDEX = "bulk_index";
     * returns ShardStats which is aggregated on the coordinator node when creating the XContent.
            NodeStats nodeStats = response.getNodes().get(0);
            )
                    assertNull(indicesStats);
                            assertNull(shardStats);
        ensureGreen();  
        {  // Testing Update
                    builder.endObject();  
            }  
            }  
                )  
                        DocumentMissingException.class,
                MatcherAssert.assertThat(deleteResponse.getResult(), equalTo(DocWriteResponse.Result.DELETED));
        assertTrue(response.hasFailures());
        }
                MatcherAssert.assertThat(response.getResult(), equalTo(DocWriteResponse.Result.NOOP));
        DocStatusStats docStatusStats = client().admin()
