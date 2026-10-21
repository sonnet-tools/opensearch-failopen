import org.opensearch.action.index.IndexResponse;
        commonStatsFlags.setLevels(level_arg.toArray(new String[0]));
                    () -> client().index(new IndexRequest(INDEX).id("missing_pipeline").setPipeline("missing").source(SOURCE)).actionGet()
 * SPDX-License-Identifier: Apache-2.0
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
                assertDocStatusStats();
                } else {
        assertEquals("Level provided is not supported by NodeIndicesStats", response.failures().get(0).getCause().getCause().getMessage());
    }
        );
        NODE(NodeIndicesStats.StatsLevel.NODE.getRestName()),
                        .toXContent(
                } else {
                }
                final String docId = "version_conflict";
            response = client().admin().cluster().prepareNodesStats().setIndices(commonStatsFlags).get();
            response = client().bulk(bulkRequest).actionGet();
        MockStatsLevel testLevel = MockStatsLevel.UNKNOWN;
            )
            MatcherAssert.assertThat(response.hasFailures(), equalTo(false));
                updateExpectedDocStatusCounter(client().index(new IndexRequest(INDEX).id(docId).source(SOURCE)).actionGet());
        }
                    LinkedHashMap indicesStats = (LinkedHashMap) indicesStatsMap.get(NodeIndicesStats.StatsLevel.INDICES.getRestName());
                    assertFalse(shardStats.isEmpty());
    public void testNodeIndicesStatsDocStatusStatsIndexBulk() {
                    LinkedHashMap indicesStatsMap = (LinkedHashMap) xContentMap.get(NodeIndicesStats.StatsLevel.INDICES.getRestName());
                assertDocStatusStats();
                updateExpectedDocStatusCounter(itemResponse.getResponse());
                .cluster()
                assertDocStatusStats();
                Settings.builder().put("number_of_shards", 2).put("number_of_replicas", clusterService().state().getNodes().getSize() - 1)
            {  // Testing Not Found
import java.util.LinkedHashMap;
                        AssertionError.class,
        }
                response = client().admin().cluster().prepareNodesStats().get();
            }
                LinkedHashMap indicesStatsMap = (LinkedHashMap) xContentMap.get(NodeIndicesStats.StatsLevel.INDICES.getRestName());
                    expectThrows(
        String indexName = "test1";
            for (int i = 0; i < sizeOfDeleteRequests; ++i) {
import org.opensearch.common.settings.Settings;
                        new ToXContent.MapParams(Collections.singletonMap("level", NodeIndicesStats.StatsLevel.INDICES.getRestName()))
                    LinkedHashMap shardStats = (LinkedHashMap) indicesStatsMap.get(NodeIndicesStats.StatsLevel.SHARDS.getRestName());
            }
                docStatusStats.getDocStatusCounter(),
import java.util.ArrayList;
import org.opensearch.action.DocWriteResponse;
        {  // Testing Index
                .actionGet()
            {  // Testing Deletion
                level_arg.add(testLevel.getRestName());
    private Map<String, Object> xContentBuilderToMap(XContentBuilder xContentBuilder) {
            .getDocStatusStats();
                        () -> client().index(new IndexRequest(INDEX).id("missing_alias").setRequireAlias(true).source(SOURCE)).actionGet()
    /**
            final String ID = "id";
            }
                .execute()
import org.opensearch.ExceptionsHelper;
            DocStatusStats docStatusStats = client().admin()
            if (!testLevel.equals("null")) {
                updateExpectedDocStatusCounter(
            bulkRequest.requests().clear();
                }
                throw new RuntimeException(e);
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
                updateExpectedDocStatusCounter(response);
                        () -> client().update(new UpdateRequest(INDEX, ID).setRequireAlias(true).doc(new IndexRequest().source(SOURCE)))
                        IndexNotFoundException.class,
import org.opensearch.action.delete.DeleteResponse;
            try {
                assertDocStatusStats();
                builder.startObject();
import org.opensearch.index.IndexNotFoundException;
                MatcherAssert.assertThat(response.getResult(), equalTo(DocWriteResponse.Result.UPDATED));
                indexName,
                indexName,
                updateExpectedDocStatusCounter(
            final String INDEX = "create_index";
/*
                DeleteResponse deleteResponse = client().delete(new DeleteRequest(INDEX, ID)).actionGet();
                // With param containing level as 'indices', the indices stats are returned
                        () -> client().update(new UpdateRequest(INDEX, ID).doc(SOURCE)).actionGet()
                builder.endObject();
        testLevels.add(MockStatsLevel.NULL);
                        );
            .getIndices()
                builder = nodeStats.getIndices()
            int sizeOfNotFoundRequests = scaledRandomIntBetween(5, sizeOfIndexRequests);
            }
                    assertThrows(
        testLevels.forEach(testLevel -> {
            commonStatsFlags.setIncludeIndicesStatsByLevel(true);
    }
                    assertThrows(
            NodeStats nodeStats = response.getNodes().get(0);
import org.opensearch.action.index.IndexRequest;
    }
                IndexResponse response = client().index(new IndexRequest(INDEX).id(ID).source(SOURCE).create(true)).actionGet();
                assertTrue(shardLevelStats.containsKey(indexName));
                        new ToXContent.MapParams(Collections.singletonMap("level", NodeIndicesStats.StatsLevel.SHARDS.getRestName()))
                        VersionConflictEngineException.class,
                    builder.endObject();
import static org.hamcrest.Matchers.equalTo;
        ensureGreen();
            MatcherAssert.assertThat(response.getItems().length, equalTo(sizeOfDeleteRequests + sizeOfNotFoundRequests));
        List<MockStatsLevel> testLevels = new ArrayList<>();
                    switch (testLevel) {
    private void updateExpectedDocStatusCounter(Exception e) {
            }
                );
                    IllegalArgumentException.class,
            )
            MatcherAssert.assertThat(response.hasFailures(), equalTo(false));
            }
                updateExpectedDocStatusCounter(deleteResponse);
        testLevels.add(MockStatsLevel.NODE);
        ArrayList<String> level_arg = new ArrayList<>();
            for (int i = 0; i < sizeOfIndexRequests; ++i) {
                updateExpectedDocStatusCounter(
import org.opensearch.core.common.bytes.BytesReference;
                UpdateResponse response = client().update(new UpdateRequest(INDEX, ID).doc(singletonMap(FIELD, UPDATED_VALUE))).actionGet();
        testLevels.add(NodeIndicesStats.StatsLevel.NODE.getRestName());
                builder = nodeStats.getIndices().toXContent(builder, ToXContent.EMPTY_PARAMS);
            assertDocStatusStats();
                MatcherAssert.assertThat(response.getSeqNo(), greaterThanOrEqualTo(0L));
                .setIndices(commonStatsFlags)
                            )
            final String INDEX = "test_index";
            final String ID = "id";
    private static final Map<String, Object> SOURCE = singletonMap(FIELD, VALUE);
                MatcherAssert.assertThat(response.getResult(), equalTo(DocWriteResponse.Result.CREATED));
                        () -> client().delete(new DeleteRequest(INDEX, docId).setIfSeqNo(2L).setIfPrimaryTerm(99L)).actionGet()
            expectedDocStatusStats.inc(response.status());
import org.opensearch.action.update.UpdateRequest;
                    expectThrows(
                    expectThrows(
                    .toXContent(
            prepareCreate(
                            new ToXContent.MapParams(Collections.singletonMap("level", NodeIndicesStats.StatsLevel.SHARDS.getRestName()))
                final String docId = "version_conflict";
                                new ToXContent.MapParams(
                    )
            int sizeOfDeleteRequests = scaledRandomIntBetween(5, sizeOfIndexRequests);
            }
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
                CommonStatsFlags commonStatsFlags = new CommonStatsFlags();
        }
 *
                        "Expected shard stats or index stats in response for generating INDICES field",
            {  // Testing Missing Alias
            .getStatusCounterStats()
                    Map<String, Object> xContentMap = xContentBuilderToMap(builder);
            }
        String indexName = "test1";
            {  // Testing Version Conflict
                // Test Missing Pipeline: Ingestion failure, not Indexing failure
                            new ToXContent.MapParams(Collections.singletonMap("level", NodeIndicesStats.StatsLevel.INDICES.getRestName()))
                updateExpectedDocStatusCounter(response);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.bulk.BulkRequest;
                xContentMap = xContentBuilderToMap(builder);
                updateExpectedDocStatusCounter(response);
    }
            }
                    )
                Map<String, Object> xContentMap = xContentBuilderToMap(builder);
                throw new RuntimeException(e);
        SHARDS(NodeIndicesStats.StatsLevel.SHARDS.getRestName()),
                builder = XContentFactory.jsonBuilder();
            .prepareNodesStats()
            {  // Testing Normal Index
            }
                            .toXContent(
                        DocumentMissingException.class,
        assertTrue(
            {  // Testing Version Conflict
                    );
            }
            }
                level_arg.add(testLevel);
                MatcherAssert.assertThat(response.getResult(), equalTo(DocWriteResponse.Result.CREATED));
            }
     * Default behavior - without consideration of request level param on level, the NodeStatsRequest always
                        VersionConflictEngineException.class,
            BulkResponse response = client().bulk(bulkRequest).actionGet();
import org.opensearch.cluster.ClusterState;
            )
                assertFalse(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.SHARDS.getRestName()));
import org.opensearch.action.bulk.BulkItemResponse;
        }
                // With param containing level as 'shards', the shard stats are returned
     */
                    Map<String, Object> xContentMap = xContentBuilderToMap(builder);
import org.opensearch.index.engine.VersionConflictEngineException;
        );
import java.util.Arrays;
        assertAcked(
                );
        expectedDocStatusStats.inc(r.status());
            DocStatusStats expectedDocStatusStats = new DocStatusStats();
                IndexResponse response = client().index(new IndexRequest(INDEX).id(ID).source(SOURCE)).actionGet();
        List<String> testLevels = new ArrayList<>();
            }
        );
                            .actionGet()
                commonStatsFlags.setLevels(level_arg.toArray(new String[0]));
                    LinkedHashMap indicesStats = (LinkedHashMap) indicesStatsMap.get(NodeIndicesStats.StatsLevel.INDICES.getRestName());
        {  // Testing Bulk
            final String INDEX = "delete_index";
                LinkedHashMap indexLevelStats = (LinkedHashMap) indicesStatsMap.get(NodeIndicesStats.StatsLevel.INDICES.getRestName());
            .cluster()
    private final DocStatusStats expectedDocStatusStats = new DocStatusStats();
                builder.startObject();
        UNKNOWN("unknown");
    }
                builder = XContentFactory.jsonBuilder();
                assertTrue(indexLevelStats.containsKey(indexName));
            for (BulkItemResponse itemResponse : response.getItems()) {
                assertDocStatusStats();
                assertDocStatusStats();
import java.util.Comparator;
                                    Collections.singletonMap("level", NodeIndicesStats.StatsLevel.SHARDS.getRestName())
                assertDocStatusStats();
        String indexName = "test1";
                            builder,
                final String docId = "version_conflict";
                updateExpectedDocStatusCounter(
        INDICES(NodeIndicesStats.StatsLevel.INDICES.getRestName()),
                // Without any param - default is level = nodes
     * Aggregated behavior - to avoid unnecessary IO in the form of shard-stats when not required, we not honor the levels on the
                updateExpectedDocStatusCounter(response);
                builder.startObject();
            {  // Testing Missing Alias
            commonStatsFlags.setIncludeIndicesStatsByLevel(true);
                            )
                clusterService().state().getNodes().getSize(),
                    assertNull(indicesStats);
            final String ID = "id";
    }
                    }
 * The OpenSearch Contributors require contributions made to
                bulkRequest.add(new DeleteRequest(INDEX, String.valueOf(25 + i)));
                            .toXContent(
            refresh(INDEX);
        assertAcked(
                assertDocStatusStats();
            {  // Testing Non-Existing Doc
                updateExpectedDocStatusCounter(client().delete(new DeleteRequest(INDEX, "does_not_exist")).actionGet());
        NULL("null"),
    public void testNodeIndicesStatsXContentWithoutAggregationOnNodes() {
            final String ID = "id";
    public void testNodeIndicesStatsUnknownLevelThrowsException() {
            try {
import org.opensearch.index.engine.DocumentMissingException;
                );
        testLevels.add("unknown");
                    expectThrows(
                    );
    private static final String FIELD = "dummy_field";
                        case SHARDS:
                )
                        .toXContent(
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import org.hamcrest.MatcherAssert;
                .get(0)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        });
                assertDocStatusStats();
            )
        ensureGreen();
                expectThrows(
                assertFalse(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.SHARDS));
                            assertNull(shardStats);
                assertDocStatusStats();
        testLevels.add(NodeIndicesStats.StatsLevel.SHARDS.getRestName());
            {  // Testing Creation
                Arrays.equals(
            }
        ensureGreen();
                    )
            for (int i = 0; i < sizeOfNotFoundRequests; ++i) {
                        builder,
                    docStatusStats.getDocStatusCounter(),
                updateExpectedDocStatusCounter(client().index(new IndexRequest(INDEX).id(ID).source(SOURCE)).actionGet());
                UpdateResponse response = client().update(new UpdateRequest(INDEX, ID).doc(SOURCE)).actionGet();
            int sizeOfIndexRequests = scaledRandomIntBetween(10, 20);
                final String docId = "version_conflict";
                    expectThrows(
        testLevels.add(NodeIndicesStats.StatsLevel.INDICES.getRestName());
import org.opensearch.action.update.UpdateResponse;
import org.opensearch.action.delete.DeleteRequest;
                IndexResponse response = client().index(new IndexRequest(INDEX).id(ID).source(SOURCE)).actionGet();
import java.util.concurrent.atomic.LongAdder;
    public void testNodeIndicesStatsDocStatusStatsCreateDeleteUpdate() {
        testLevels.add("null");
            assertNotNull(nodeStats.getIndices().getShardStats(clusterState.metadata().index(indexName).getIndex()));
            CommonStatsFlags commonStatsFlags = new CommonStatsFlags();
                updateExpectedDocStatusCounter(client().index(new IndexRequest(INDEX).id(docId).source(SOURCE)).actionGet());
                    builder.endObject();
import java.util.List;
    public void testNodeIndicesStatsXContentWithAggregationOnNodes() {
        {  // Testing Create
            NodesStatsResponse response;
                assertTrue(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.SHARDS.getRestName()));
                    );
                assertTrue(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.INDICES.getRestName()));
                ArrayList<String> level_arg = new ArrayList<>();
        ensureGreen();
            {  // Testing NoOp Update
                Settings.builder().put("number_of_shards", 2).put("number_of_replicas", clusterService().state().getNodes().getSize() - 1)
            prepareCreate(
                    final XContentBuilder failedBuilder = builder;
                .prepareNodesStats()
                    expectThrows(
                            break;
            CommonStatsFlags commonStatsFlags = new CommonStatsFlags();
                ArrayList<String> level_arg = new ArrayList<>();
                    LinkedHashMap indicesStatsMap = (LinkedHashMap) xContentMap.get(NodeIndicesStats.StatsLevel.INDICES.getRestName());
        }
package org.opensearch.nodestats;
            Arrays.equals(
                        VersionConflictEngineException.class,
import org.opensearch.action.admin.indices.stats.DocStatusStats;
        commonStatsFlags.setIncludeIndicesStatsByLevel(true);
                .getStatusCounterStats()
import org.opensearch.common.xcontent.XContentHelper;
                builder = nodeStats.getIndices()
                                failedBuilder,
    private void updateExpectedDocStatusCounter(DocWriteResponse r) {
        assertTrue(response.hasFailures());
        return XContentHelper.convertToMap(BytesReference.bytes(xContentBuilder), true, xContentBuilder.contentType()).v2();
                updateExpectedDocStatusCounter(response);
                final String UPDATED_VALUE = "updated_value";
                    )
                        () -> nodeStats.getIndices()
                );
                Comparator.comparingLong(LongAdder::longValue)
                    final XContentBuilder failedBuilder = builder;
            }
                            builder,
    }
import org.opensearch.core.xcontent.ToXContent;
                                )
                            .actionGet()
                indexName,
public class NodeStatsIT extends OpenSearchIntegTestCase {
        }
            {  // Testing Version Conflict
                XContentBuilder builder = XContentFactory.jsonBuilder();
        testLevels.add(MockStatsLevel.INDICES);
                    )
        CommonStatsFlags commonStatsFlags = new CommonStatsFlags();
                assertFalse(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.INDICES.getRestName()));
                        builder,
            MatcherAssert.assertThat(response.getItems().length, equalTo(sizeOfIndexRequests));
                builder.startObject();
        internalCluster().startNode();
        {  // Testing Create
            {
        }
                bulkRequest.add(new DeleteRequest(INDEX, String.valueOf(i)));
        DocStatusStats docStatusStats = client().admin()
        private final String restName;
                );
            } else {
                        );
            );
                    Comparator.comparingLong(LongAdder::longValue)
                builder.startObject();
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
    }
                MatcherAssert.assertThat(deleteResponse.getResult(), equalTo(DocWriteResponse.Result.DELETED));
 */
                    )
    private enum MockStatsLevel {
                        IndexNotFoundException.class,
                xContentMap = xContentBuilderToMap(builder);
            {  // Testing Update
                    expectedDocStatusStats.getDocStatusCounter(),
            .getNodes()
import java.util.Map;
                updateExpectedDocStatusCounter(
            } catch (IOException e) {
}
            .get(0)
                bulkRequest.add(new IndexRequest(INDEX).id(String.valueOf(i)).source(SOURCE));
                                new ToXContent.MapParams(
                expectedDocStatusStats.getDocStatusCounter(),
                updateExpectedDocStatusCounter(itemResponse.getResponse());
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
                assertDocStatusStats();
                    expectThrows(
import org.opensearch.test.OpenSearchIntegTestCase;
                assertDocStatusStats();
            .actionGet()
        });
            }
            final String ID = "id";
                .getIndices()
            }
import java.util.Collections;
                );
        ensureGreen();
                indicesStatsMap = (LinkedHashMap) xContentMap.get(NodeIndicesStats.StatsLevel.INDICES.getRestName());
     * returns ShardStats which is aggregated on the coordinator node when creating the XContent.
@ClusterScope(scope = Scope.TEST, numDataNodes = 1, numClientNodes = 0, supportsDedicatedMasters = false)
                            assertFalse(indicesStats.isEmpty());
                assertDocStatusStats();
            {  // Testing Version Conflict
                );
                                    Collections.singletonMap("level", NodeIndicesStats.StatsLevel.INDICES.getRestName())
            }
            final String INDEX = "bulk_index";
            final String INDEX = "create_index";
            for (BulkItemResponse itemResponse : response.getItems()) {
    }
                                )
                if (!(testLevel.equals(MockStatsLevel.SHARDS) || testLevel.equals(MockStatsLevel.INDICES))) {
            BulkRequest bulkRequest = new BulkRequest();
 * compatible open source license.
            return restName;
                assertDocStatusStats();
        level_arg.add(testLevel.getRestName());
                response = client().admin().cluster().prepareNodesStats().setIndices(commonStatsFlags).get();
                        "Expected shard stats in response for generating [SHARDS] field",
                Settings.builder().put("number_of_shards", 2).put("number_of_replicas", clusterService().state().getNodes().getSize() - 1)
                                failedBuilder,
            assertTrue(
            }
                .getDocStatusStats();
                XContentBuilder builder = XContentFactory.jsonBuilder();
                builder.endObject();
     */
                        case INDICES:
        MockStatsLevel(String restName) {
                builder = XContentFactory.jsonBuilder();
                    builder = nodeStats.getIndices()
                clusterService().state().getNodes().getSize(),
                        () -> client().index(new IndexRequest(INDEX).id(docId).source(SOURCE).create(true)).actionGet()
import org.opensearch.common.xcontent.XContentFactory;
                    LinkedHashMap shardStats = (LinkedHashMap) indicesStatsMap.get(NodeIndicesStats.StatsLevel.SHARDS.getRestName());
                if (!testLevel.equals(MockStatsLevel.SHARDS)) {
            .execute()
        testLevels.add(MockStatsLevel.SHARDS);
        {  // Testing Delete
    public void testNodeIndicesStatsDocStatsWithAggregations() {
                    builder = nodeStats.getIndices()
        response = client().admin().cluster().prepareNodesStats().setIndices(commonStatsFlags).get();
    }
                builder.endObject();
            refresh(INDEX);
            NodesStatsResponse response;
        assertAcked(
                indicesStatsMap = (LinkedHashMap) xContentMap.get(NodeIndicesStats.StatsLevel.INDICES.getRestName());
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
                    );
        NodesStatsResponse response;
        );
            NodeStats nodeStats = response.getNodes().get(0);
        internalCluster().startNode();
                LinkedHashMap shardLevelStats = (LinkedHashMap) indicesStatsMap.get(NodeIndicesStats.StatsLevel.SHARDS.getRestName());
import java.io.IOException;
                updateExpectedDocStatusCounter(
    private static final String VALUE = "dummy_value";
                commonStatsFlags.setLevels(level_arg.toArray(new String[0]));
                        VersionConflictEngineException.class,
        }
            }
            final String INDEX = "update_index";
                    )
            if (!testLevel.equals(MockStatsLevel.NULL)) {
                clusterService().state().getNodes().getSize(),
                );
        expectedDocStatusStats.inc(ExceptionsHelper.status(e));
        ensureGreen();
                        () -> client().index(new IndexRequest(INDEX).id(docId).source(SOURCE).setIfSeqNo(1L).setIfPrimaryTerm(99L))
                .getNodes()
        testLevels.forEach(testLevel -> {
            } catch (IOException e) {
                updateExpectedDocStatusCounter(client().index(new IndexRequest(INDEX).id(docId).source(SOURCE)).actionGet());
                updateExpectedDocStatusCounter(client().index(new IndexRequest(INDEX).id(docId).source(SOURCE)).actionGet());
            }
        public String getRestName() {
    /**
                updateExpectedDocStatusCounter(
     * individual data nodes instead and pre-compute information as required.
    }
        internalCluster().startNode();
                        () -> nodeStats.getIndices()
import org.opensearch.indices.NodeIndicesStats;
                        AssertionError.class,
    private void assertDocStatusStats() {
import org.opensearch.core.xcontent.XContentBuilder;
            IndexResponse response = client().index(new IndexRequest(INDEX).id(ID).source(SOURCE).create(true)).actionGet();
            prepareCreate(
import static java.util.Collections.singletonMap;
                        () -> client().update(new UpdateRequest(INDEX, docId).doc(SOURCE).setIfSeqNo(2L).setIfPrimaryTerm(99L)).actionGet()
        {  // Testing Update
import org.opensearch.action.bulk.BulkResponse;
                    .toXContent(
            }
            this.restName = restName;
                assertFalse(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.INDICES));
                MatcherAssert.assertThat(response.getResult(), equalTo(DocWriteResponse.Result.NOOP));
