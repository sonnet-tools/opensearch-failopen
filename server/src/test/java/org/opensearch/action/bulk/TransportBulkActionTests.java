 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
        clusterService.close();
    public void testProhibitAppendWritesInBackingIndices() throws Exception {
import org.opensearch.index.IndexingPressureService;
        for (int i = 0; i < shardCount; i++) {
        // if IndexRoutingTable is null, we should return null
 * software distributed under the License is distributed on an
        // test custom routing is allowed when the index request targets the backing index
        indicesLookup.put(
    @Before
        ExtraFieldValues efv = new ExtraFieldValues(Map.of("foo", new BytesValue(new BytesArray(new byte[] { 1, 2, 3 }))));
    }
        nodeMetricsCollector.addNodeStatistics(dataNodes[2], DEFAULT_QUEUE_SIZE, 300000000, DEFAULT_SERVICE_TIME_IN_NANOS);
            emptyMap(),
                new AutoCreateIndex(Settings.EMPTY, clusterService.getClusterSettings(), new Resolver(), new SystemIndices(emptyMap())),
        out.setVersion(Version.V_3_4_0);
        assertTrue(bulkAction.indexCreated);
import org.opensearch.action.support.ActionTestUtils;
 *
import org.opensearch.cluster.routing.TestShardRouting;
        assertTrue(bulkAction.isOnlySystem(buildBulkRequest(onlySystem), indicesLookup, systemIndices));
        super.setUp();
        Exception e = expectThrows(
import org.opensearch.index.VersionType;
        assertTrue(bulkAction.includesSystem(buildBulkRequest(onlySystem), indicesLookup, systemIndices));
    private TransportService transportService;
    @After
        assertFalse(ir.extraFieldValues().isEmpty());
                case 3:
        shardId = TransportBulkAction.bulkAdaptiveSelectShard(createIndexRoutingTable(2, 1), nodeMetricsCollector, clientConnections);
        assertEquals(primaryShardId, shardInfos.v1().get(0).shardId());
        Metadata metadata = clusterState.metadata();
        );
        PlainActionFuture<BulkResponse> future = PlainActionFuture.newFuture();
        assertFalse(bulkAction.includesSystem(buildBulkRequest(nonSystem), indicesLookup, systemIndices));
        }
import org.opensearch.cluster.service.ClusterService;
    private IndexRoutingTable createIndexRoutingTable(int nodeCount, int shardCount) {
            clusterService.getSettings(),
        StreamInput in = out.bytes().streamInput();
        assertEquals(TransportBulkAction.getIndexWriteRequest(scriptedUpsert), indexRequest);
import org.opensearch.core.common.bytes.BytesArray;
            () -> TransportBulkAction.prohibitAppendWritesInBackingIndices(invalidRequest2, metadata)
            );
 * Unless required by applicable law or agreed to in writing,
            clientConnections
        // Append only for a backing index that doesn't exist is allowed:
        IndexRequest indexRequest = new IndexRequest("index").id("id1").source(emptyMap());
                    + "target corresponding data stream [logs-foobar] instead"
        }
 * GitHub history for details.
}
        assertNull(TransportBulkAction.getIndexWriteRequest(deleteRequest));
        indicesLookup.put(
import org.opensearch.threadpool.ThreadPool;
        assertNull(shardId);
import org.opensearch.ResourceAlreadyExistsException;
        TransportBulkAction.prohibitAppendWritesInBackingIndices(validRequest, metadata);
        );
                "index request targeting data stream [logs-foobar] specifies a custom routing. target the "
        UpdateRequest badUpsertRequest = new UpdateRequest("index", "id1");
            )
        assertFalse(bulkAction.isOnlySystem(buildBulkRequest(nonSystem), indicesLookup, systemIndices));
 * You may obtain a copy of the License at
import org.opensearch.cluster.ClusterState;
        );
        StreamInput in = out.bytes().streamInput();
            IllegalArgumentException.class,
        assertEquals(TransportBulkAction.getIndexWriteRequest(upsertRequest), indexRequest);
        validRequest = new IndexRequest(dataStreamName).opType(DocWriteRequest.OpType.CREATE);
        DocWriteRequest<?> validRequest = new IndexRequest(backingIndexName).opType(DocWriteRequest.OpType.INDEX)
                "index request with op_type=index and no if_primary_term and if_seq_no set "
import org.opensearch.indices.IndicesService;
        );
                        new ShardId(index, i),
                case 1:
        Settings settings = Settings.builder().put("index.version.created", Version.CURRENT).build();
        assertTrue(bulkAction.includesSystem(buildBulkRequest(onlySystem), indicesLookup, systemIndices));
        // Testing append only write via ds name
        shardId = TransportBulkAction.bulkAdaptiveSelectShard(routingTable, nodeMetricsCollector, clientConnections);
        assertEquals(TransportBulkAction.getIndexWriteRequest(docAsUpsertRequest), indexRequest);
            new Index(IndexMetadata.builder(".bar").settings(settings).system(true).numberOfShards(1).numberOfReplicas(0).build())
        indexRoutingTable.addShard(TestShardRouting.newShardRouting(new ShardId(index, 2), "node-2", true, ShardRoutingState.INITIALIZING));
        ).routing("custom");
        CapturingTransport capturingTransport = new CapturingTransport();
                TransportBulkActionTests.this.threadPool,
        UpdateRequest docAsUpsertRequest = new UpdateRequest("index", "id2").doc(indexRequest).docAsUpsert(true);
    }
        for (String index : indices) {
                null,
        TransportBulkAction.prohibitAppendWritesInBackingIndices(validRequest, metadata);
                createIngestServiceWithProcessors(Collections.emptyMap()),
import static org.opensearch.action.bulk.BulkShardResponse.DEFAULT_SERVICE_TIME_IN_NANOS;
    }
        nodeMetricsCollector.addNodeStatistics(dataNodes[0], DEFAULT_QUEUE_SIZE, 299999999, DEFAULT_SERVICE_TIME_IN_NANOS);
 * not use this file except in compliance with the License.
        assertEquals(primaryShardId, shardInfos.v2().get("node-0").get(0).shardId());
import static org.opensearch.cluster.metadata.MetadataCreateDataStreamServiceTests.createDataStream;
        nodeMetricsCollector.addNodeStatistics(dataNodes[2], DEFAULT_QUEUE_SIZE, 300000000, DEFAULT_SERVICE_TIME_IN_NANOS);
            createSearchOnlyIndexRoutingTable(2),
            IllegalArgumentException.class,
        );
        TransportBulkAction.prohibitAppendWritesInBackingIndices(validRequest, metadata);
        IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(index);
                clusterService,
        assertTrue(bulkAction.indexCreated);
        // custom routing requests against the data stream are prohibited
import org.opensearch.action.DocWriteRequest;
            IllegalArgumentException.class,
        List<String> nonSystem = List.of("foo", "bar");
        boolean indexCreated = false; // set when the "real" index is created
        );
            createSearchOnlyIndexRoutingTable(1),
import org.junit.Before;
        nodeMetricsCollector.addNodeStatistics(dataNodes[1], DEFAULT_QUEUE_SIZE, 300000000, DEFAULT_SERVICE_TIME_IN_NANOS);
        BulkRequest bulkRequest = new BulkRequest().add(new DeleteRequest("index", "id"));
    public void testGetIndexWriteRequest() throws Exception {
        SortedMap<String, IndexAbstraction> indicesLookup = new TreeMap<>();
import java.util.TreeMap;
    public void testDeleteNonExistingDocDoesNotCreateIndex() throws Exception {
    }
            DocWriteRequest.OpType.INDEX
import org.opensearch.action.support.PlainActionFuture;
                NoopTracer.INSTANCE
        assertEquals(bulkResponses.length, 1);
        threadPool = null;
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        shardId = TransportBulkAction.bulkAdaptiveSelectShard(routingTable, nodeMetricsCollector, clientConnections);
        ActionTestUtils.execute(bulkAction, null, bulkRequest, future);
        Map<String, Long> clientConnections = new HashMap<>();
    }
        // Testing index op against backing index fails:
        StreamInput in = out.bytes().streamInput();
        assertNotEquals(dataNodes[0], routingTable.shard(shardId.getId()).primaryShard().currentNodeId());
    public void tearDown() throws Exception {
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under
        assertEquals(dataNodes[0], routingTable.shard(shardId.getId()).primaryShard().currentNodeId());
    public void testBulkAdaptiveSelectShardWithMultipleShardsWithoutActivePrimary() {
        List<String> onlySystem = Arrays.asList(".foo", ".bar");
        indexRoutingTable.addShard(TestShardRouting.newShardRouting(primaryShardId, "node-0", true, ShardRoutingState.STARTED));
        assertThat(
                        ShardRoutingState.STARTED
import org.opensearch.action.support.AutoCreateIndex;
 * SPDX-License-Identifier: Apache-2.0
            .setIfSeqNo(1)
import static org.opensearch.action.bulk.TransportBulkAction.prohibitCustomRoutingOnDataStream;
        String[] dataNodes = TransportBulkAction.getIndexPrimaryShards(routingTable).v2().keySet().toArray(new String[0]);
        nodeMetricsCollector.addNodeStatistics(dataNodes[0], DEFAULT_QUEUE_SIZE, 300000000, DEFAULT_SERVICE_TIME_IN_NANOS);
import static java.util.Collections.singletonMap;
        transportService.start();
            .setIfPrimaryTerm(1);
    }
        ResponseCollectorService nodeMetricsCollector = new ResponseCollectorService(clusterService);
import org.opensearch.core.index.shard.ShardId;
        validRequest = new IndexRequest("foobar").opType(DocWriteRequest.OpType.CREATE);
import org.opensearch.action.update.UpdateRequest;
            request.add(subRequest);
    }
        } finally {
import static java.util.Collections.emptyMap;
        String backingIndexName = DataStream.getDefaultBackingIndexName(dataStreamName, 1);
        );
            equalTo(
    }
        assertNull(TransportBulkAction.getIndexWriteRequest(badUpsertRequest));
    public void testSerializationBeforeExtraFieldValuesDropsField() throws Exception {
import org.opensearch.cluster.metadata.Metadata;
        try {
        assertTrue(bulkAction.isOnlySystem(buildBulkRequest(onlySystem), indicesLookup, systemIndices));
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        DeleteRequest deleteRequest = new DeleteRequest("index", "id");
import org.opensearch.action.bulk.TransportBulkActionTookTests.Resolver;
        shardId = TransportBulkAction.bulkAdaptiveSelectShard(routingTable, nodeMetricsCollector, clientConnections);
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        assertTrue(shardInfos.v2().containsKey("node-0"));
        validRequest = new UpdateRequest(backingIndexName, "_id");
        assertEquals(TransportBulkAction.getIndexWriteRequest(indexRequest), indexRequest);
                transportService,
        in.setVersion(out.getVersion());
    private BulkRequest buildBulkRequest(List<String> indices) {
        BulkRequest request = new BulkRequest();
        }
    }
        );
            nodeMetricsCollector,
        BulkRequest deserializedRequest = new BulkRequest(in);
        onlySystem = Arrays.asList(".foo", ".bar", ".test");
                );
        PlainActionFuture<BulkResponse> future = PlainActionFuture.newFuture();
import org.opensearch.cluster.node.DiscoveryNode;
        validRequest = new DeleteRequest(backingIndexName);
            ".foo",
            NoopTracer.INSTANCE
        future.actionGet();
        // Testing create op against backing index fails:
            OpenSearchTestCase.buildNewFakeTransportAddress(),
        assertThat(
import org.opensearch.cluster.metadata.IndexAbstraction.Index;
    public void testDeleteNonExistingDocExternalGteVersionCreatesIndex() throws Exception {
        TransportBulkAction.prohibitAppendWritesInBackingIndices(validRequest, metadata);
        }
                listener.onFailure(new ResourceAlreadyExistsException("index already exists"));
        BulkRequest deserializedRequest = new BulkRequest(in);
        clientConnections.put(dataNodes[2], 2L);
    }
        volatile boolean failIndexCreation = false;
        Tuple<List<ShardRouting>, Map<String, List<ShardRouting>>> shardInfos = TransportBulkAction.getIndexPrimaryShards(
 * The OpenSearch Contributors require contributions made to
        ShardId shardId = TransportBulkAction.bulkAdaptiveSelectShard(
            expectThrows(OpenSearchRejectedExecutionException.class, future::actionGet);
            null,
        return request;
    }
        org.opensearch.core.index.Index index = new org.opensearch.core.index.Index("test", "1");
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        e = expectThrows(
        );
            new IndexRequest("index").id("id").source(Collections.emptyMap()).extraFieldValues(efv)
            threadPool.stopForcingRejections();
 */
        in.setVersion(out.getVersion());
    public void testProhibitCustomRoutingOnDataStream() throws Exception {
        );
            is(
        ShardId shardId = TransportBulkAction.bulkAdaptiveSelectShard(null, nodeMetricsCollector, clientConnections);
import org.opensearch.test.OpenSearchTestCase;
        BulkRequest bulkRequest = new BulkRequest().add(new DeleteRequest("index", "id").versionType(VersionType.EXTERNAL).version(0));
import org.opensearch.common.collect.Tuple;
/*
 * this file be licensed under the Apache-2.0 license or a
        TransportBulkAction.prohibitAppendWritesInBackingIndices(validRequest, metadata);
            }
        org.opensearch.core.index.Index index = new org.opensearch.core.index.Index("test", "1");
import org.opensearch.transport.TransportService;
        ActionTestUtils.execute(bulkAction, null, bulkRequest, future);
 */
import org.opensearch.test.VersionUtils;
import org.opensearch.indices.SystemIndices;
    }
import java.util.concurrent.TimeUnit;
        BulkRequest bulkRequest = new BulkRequest().add(
        );
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.index.IndexNotFoundException;
                listener.onResponse(null);
            e.getMessage(),
            () -> TransportBulkAction.prohibitAppendWritesInBackingIndices(invalidRequest1, metadata)
 */
                new SystemIndices(emptyMap()),
public class TransportBulkActionTests extends OpenSearchTestCase {
import java.util.Set;
 * the Apache License, Version 2.0 (the "License"); you may
        bulkAction = new TestTransportBulkAction();
            new IndexRequest("index").id("id").source(Collections.emptyMap()).extraFieldValues(efv)
import java.util.List;
/*
    }
            VersionUtils.randomCompatibleVersion(random(), Version.CURRENT)
        void createIndex(String index, TimeValue timeout, Version minNodeVersion, ActionListener<CreateIndexResponse> listener) {
        future.actionGet();
        IndexRoutingTable routingTable = createIndexRoutingTable(3, 100);
            "node",
    public void testOnlySystem() {
        BytesStreamOutput out = new BytesStreamOutput();
            clientConnections
        ClusterState clusterState = createDataStream(dataStreamName);
        validRequest = new IndexRequest(dataStreamName).opType(DocWriteRequest.OpType.INDEX);
import org.opensearch.cluster.metadata.IndexMetadata;
import org.junit.After;
    private TestTransportBulkAction bulkAction;
            .routing("custom");
        prohibitCustomRoutingOnDataStream(writeRequestAgainstIndex, metadata);
        DocWriteRequest<?> writeRequestAgainstDataStream = new IndexRequest(dataStreamName).opType(DocWriteRequest.OpType.INDEX)
        Map<String, Long> clientConnections = new HashMap<>();
                    )
            ".bar",
            new Index(IndexMetadata.builder(".bar").settings(settings).system(true).numberOfShards(1).numberOfReplicas(0).build())
        assertTrue(ir.extraFieldValues().isEmpty());
        return indexRoutingTable.build();
        indexRoutingTable.addShard(
import org.opensearch.cluster.routing.ShardRouting;
 * specific language governing permissions and limitations
        SystemIndices systemIndices = new SystemIndices(singletonMap("plugin", singletonList(new SystemIndexDescriptor(".test", ""))));
            ".foo",
import org.opensearch.test.transport.CapturingTransport;
        // check the less count of connection will be chosen
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
                    break;
        IndexRequest invalidRequest2 = new IndexRequest(backingIndexName).opType(DocWriteRequest.OpType.INDEX);
            )
        UpdateRequest upsertRequest = new UpdateRequest("index", "id1").upsert(indexRequest).script(mockScript("1"));
import static java.util.Collections.singletonList;
        );
        for (int i = 0; i < shardCount; i++) {
    }
                new Resolver(),
        TransportBulkAction.prohibitAppendWritesInBackingIndices(validRequest, metadata);
            indexRoutingTable.addShard(
            if (failIndexCreation) {
        nodeMetricsCollector.addNodeStatistics(dataNodes[1], DEFAULT_QUEUE_SIZE, 300000000, DEFAULT_SERVICE_TIME_IN_NANOS);
            threadPool.startForcingRejections();
import org.opensearch.action.support.ActionFilters;
import org.opensearch.index.mapper.extrasource.BytesValue;
            indexRoutingTable.build()
        assertFalse(bulkAction.isOnlySystem(buildBulkRequest(mixed), indicesLookup, systemIndices));
        assertEquals(1, shardInfos.v1().size());
        validRequest = new IndexRequest("my-index").opType(DocWriteRequest.OpType.CREATE);
        assertEquals("index", bulkResponses[0].getFailure().getIndex());
            Collections.emptySet(),
                    subRequest = new IndexRequest(index);
                new IndexingPressureService(Settings.EMPTY, clusterService),
                    subRequest = new DeleteRequest(index).id("0");
    /** Services needed by bulk action */
    }
    public void testDeleteNonExistingDocExternalVersionCreatesIndex() throws Exception {
        bulkAction.failIndexCreation = randomBoolean();
        BulkItemResponse[] bulkResponses = ((BulkResponse) response).getItems();
        TransportBulkAction.prohibitAppendWritesInBackingIndices(validRequest, metadata);
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
import static org.hamcrest.Matchers.is;
                    break;
import org.opensearch.index.mapper.extrasource.ExtraFieldValues;
    public void setUp() throws Exception {
            } else {
 * this work for additional information regarding copyright
            )
                    break;
    }
            () -> prohibitCustomRoutingOnDataStream(writeRequestAgainstDataStream, metadata)
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
            indexRoutingTable.addShard(
import org.opensearch.action.index.IndexRequest;
        IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(index);
        );
                new ActionFilters(Collections.emptySet()),
            }
        // check non-nulls after null values
        Metadata metadata = clusterState.metadata();
        BulkResponse response = future.actionGet();
        IndexRequest ir = (IndexRequest) deserializedRequest.requests().get(0);
        BytesStreamOutput out = new BytesStreamOutput();
        ResponseCollectorService nodeMetricsCollector = new ResponseCollectorService(clusterService);
import java.util.SortedMap;
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        IllegalArgumentException exception = expectThrows(
import java.util.Arrays;
                default:
        IndexRequest ir = (IndexRequest) deserializedRequest.requests().get(0);
        String dataStreamName = "logs-foobar";
import org.opensearch.cluster.metadata.IndexAbstraction;
            DiscoveryNodeRole.BUILT_IN_ROLES,
import org.opensearch.common.io.stream.BytesStreamOutput;
        indicesLookup.put(
package org.opensearch.action.bulk;
        ShardId shardId = TransportBulkAction.bulkAdaptiveSelectShard(
        validRequest = new IndexRequest(DataStream.getDefaultBackingIndexName("logs-barbaz", 1)).opType(DocWriteRequest.OpType.CREATE);
    private IndexRoutingTable createSearchOnlyIndexRoutingTable(int shardCount) {
        TestTransportBulkAction() {
                case 2:
import org.opensearch.cluster.node.DiscoveryNodeRole;
        @Override
        BulkRequest deserializedRequest = new BulkRequest(in);
        PlainActionFuture<BulkResponse> future = PlainActionFuture.newFuture();
        assertEquals(0, shardId.id());
        transportService.acceptIncomingRequests();
import org.opensearch.node.ResponseCollectorService;
        List<String> mixed = Arrays.asList(".foo", ".test", "other");
        );
            final DocWriteRequest<?> subRequest;
        }
        );
        assertNotNull(shardId);
    public void testBulkAdaptiveSelectShard() {
            PlainActionFuture<BulkResponse> future = PlainActionFuture.newFuture();
            switch (randomIntBetween(1, 3)) {
import java.util.Map;
        IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(index);
        Settings settings = Settings.builder().put("index.version.created", Version.CURRENT).build();
        );
import org.opensearch.cluster.metadata.DataStream;
        }
                    + "backing indices directly or remove the custom routing."
 * license agreements. See the NOTICE file distributed with
        BulkRequest bulkRequest = new BulkRequest().add(new DeleteRequest("index2", "id").versionType(VersionType.EXTERNAL_GTE).version(0));
    }
        assertTrue(bulkResponses[0].isFailed());
 * Licensed to Elasticsearch under one or more contributor
                TestShardRouting.newShardRouting(new ShardId(index, i), "node" + i, false, true, ShardRoutingState.STARTED, null)
        Map<String, Long> clientConnections = new HashMap<>();
        protected boolean needToCheck() {
        out.setVersion(Version.V_3_5_0); // before ExtraFieldValues introduction
        assertEquals(Set.of("index"), deserializedRequest.getIndices());
import org.opensearch.indices.SystemIndexDescriptor;
            nodeMetricsCollector,
            ActionTestUtils.execute(bulkAction, null, bulkRequest, future);
    private TestThreadPool threadPool;
        out.setVersion(Version.V_3_7_0);
        assertFalse(bulkAction.indexCreated);
import java.util.HashMap;
    public void testIncludesSystem() {
import org.opensearch.common.unit.TimeValue;
        org.opensearch.core.index.Index index = new org.opensearch.core.index.Index("test", "1");
        threadPool = new TestThreadPool(getClass().getName());
        String dataStreamName = "logs-foobar";
        IndexRequest invalidRequest1 = new IndexRequest(backingIndexName).opType(DocWriteRequest.OpType.CREATE);
            new Index(IndexMetadata.builder(".foo").settings(settings).system(true).numberOfShards(1).numberOfReplicas(0).build())
import org.opensearch.common.settings.Settings;
    }
import org.opensearch.threadpool.TestThreadPool;
        );
        assertThat(
    public void testRejectionAfterCreateIndexIsPropagated() throws Exception {
        @Override
import static org.mockito.Mockito.mock;
        }
import org.opensearch.Version;
                    TestShardRouting.newShardRouting(
 * under the License.
import static org.opensearch.action.bulk.BulkShardResponse.DEFAULT_QUEUE_SIZE;
            );
        // Testing valid writes ops against a backing index:
        transportService = capturingTransport.createTransportService(
    class TestTransportBulkAction extends TransportBulkAction {
        ActionTestUtils.execute(bulkAction, null, bulkRequest, future);
    }
                        "node" + ((i + 1) % nodeCount),
        bulkRequest.writeTo(out);
        assertNull(shardId);
            e.getMessage(),
        ShardId primaryShardId = new ShardId(index, 0);
        bulkRequest.writeTo(out);
        BulkRequest bulkRequest = new BulkRequest().add(new IndexRequest("index").id("id").source(Collections.emptyMap()));
    public void testSerializationDeserializationWithExtraFieldValues() throws Exception {
        super.tearDown();
        clusterService = createClusterService(threadPool, discoveryNode);
            new Index(IndexMetadata.builder(".foo").settings(settings).system(true).numberOfShards(1).numberOfReplicas(0).build())
        BytesStreamOutput out = new BytesStreamOutput();
                null,
        ResponseCollectorService nodeMetricsCollector = new ResponseCollectorService(clusterService);
        UpdateRequest scriptedUpsert = new UpdateRequest("index", "id2").upsert(indexRequest).script(mockScript("1")).scriptedUpsert(true);
import org.opensearch.cluster.routing.IndexRoutingTable;
        ClusterState clusterState = createDataStream(dataStreamName);
        TransportBulkAction.prohibitAppendWritesInBackingIndices(validRequest, metadata);
    public void testBulkAdaptiveSelectShardWithSingleShard() {
        assertEquals(3, dataNodes.length);
        // check the less request time will be chosen.
                    + "targeting backing indices is disallowed, target corresponding data stream [logs-foobar] instead"
        clientConnections.clear();
        BulkRequest bulkRequest = new BulkRequest().add(
import static org.opensearch.ingest.IngestServiceTests.createIngestServiceWithProcessors;
        assertEquals(dataNodes[0], routingTable.shard(shardId.getId()).primaryShard().currentNodeId());
            TestShardRouting.newShardRouting(new ShardId(index, 1), "search-node", false, true, ShardRoutingState.STARTED, null)
import static org.hamcrest.Matchers.equalTo;
        assertTrue(ir.extraFieldValues().values().containsKey("foo"));
            threadPool,
                TestShardRouting.newShardRouting(new ShardId(index, i), "node" + (i % nodeCount), true, ShardRoutingState.STARTED)
    private ClusterService clusterService;
            return true;
 *
import org.opensearch.core.action.ActionListener;
        // Some other index names:
            indexCreated = true;
        nodeMetricsCollector = new ResponseCollectorService(clusterService);
        DocWriteRequest<?> writeRequestAgainstIndex = new IndexRequest(DataStream.getDefaultBackingIndexName(dataStreamName, 1L)).opType(
    public void testSerializationDeserialization() throws Exception {
import org.opensearch.cluster.routing.ShardRoutingState;
        List<String> mixed = List.of(".foo", ".test", "other");
 *
        ExtraFieldValues efv = new ExtraFieldValues(Map.of("foo", new BytesValue(new BytesArray(new byte[] { 1, 2, 3 }))));
            boundAddress -> clusterService.localNode(),
        bulkRequest.writeTo(out);
            equalTo(
            ".bar",
/*
        List<String> nonSystem = Arrays.asList("foo", "bar");
                .addShard(
        indicesLookup.put(
        assertEquals(1, shardInfos.v2().size());
            super(
        onlySystem = List.of(".foo", ".bar", ".test");
import java.util.Collections;
                        false,
        DiscoveryNode discoveryNode = new DiscoveryNode(
        return indexRoutingTable.build();
        List<String> onlySystem = List.of(".foo", ".bar");
            exception.getMessage(),
    }
        assertTrue(bulkResponses[0].getFailure().getCause() instanceof IndexNotFoundException);
        assertTrue(bulkAction.includesSystem(buildBulkRequest(mixed), indicesLookup, systemIndices));
        clientConnections.put(dataNodes[1], 2L);
import org.opensearch.action.delete.DeleteRequest;
        SortedMap<String, IndexAbstraction> indicesLookup = new TreeMap<>();
                    throw new IllegalStateException("only have 3 cases");
        in.setVersion(out.getVersion());
            )
                    subRequest = new UpdateRequest(index, "0");
                mock(IndicesService.class),
        assertEquals(1, shardInfos.v2().get("node-0").size());
        BulkRequest bulkRequest = new BulkRequest().add(new IndexRequest("index").id("id").source(Collections.emptyMap()));
        assertNull(shardId);
        SystemIndices systemIndices = new SystemIndices(Map.of("plugin", List.of(new SystemIndexDescriptor(".test", ""))));
                "index request with op_type=create targeting backing indices is disallowed, "
