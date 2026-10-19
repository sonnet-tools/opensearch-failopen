            "node",
 * the Apache License, Version 2.0 (the "License"); you may
import org.junit.Before;
import org.opensearch.indices.SystemIndexDescriptor;
        PlainActionFuture<BulkResponse> future = PlainActionFuture.newFuture();
        assertTrue(bulkAction.indexCreated);
        assertEquals(bulkResponses.length, 1);
        assertEquals(1, shardInfos.v1().size());
        );  
        String dataStreamName = "logs-foobar";
        ShardId shardId = TransportBulkAction.bulkAdaptiveSelectShard(
        // check non-nulls after null values
        shardId = TransportBulkAction.bulkAdaptiveSelectShard(createIndexRoutingTable(2, 1), nodeMetricsCollector, clientConnections);
 *
                    throw new IllegalStateException("only have 3 cases");
        );
        ExtraFieldValues efv = new ExtraFieldValues(Map.of("foo", new BytesValue(new BytesArray(new byte[] { 1, 2, 3 }))));
            threadPool.startForcingRejections();
/*  
            null,
        assertThat(
        assertEquals(3, dataNodes.length);
        // Testing valid writes ops against a backing index:
        assertFalse(bulkAction.isOnlySystem(buildBulkRequest(mixed), indicesLookup, systemIndices));
import org.opensearch.transport.TransportService;
import java.util.Map;
        assertNull(shardId);
import static java.util.Collections.singletonList;
            request.add(subRequest);  
            new Index(IndexMetadata.builder(".bar").settings(settings).system(true).numberOfShards(1).numberOfReplicas(0).build())
                clusterService,
 * Unless required by applicable law or agreed to in writing,
    }
        return request;
        }
            nodeMetricsCollector,
import org.opensearch.common.collect.Tuple;
        validRequest = new IndexRequest("foobar").opType(DocWriteRequest.OpType.CREATE);
        IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(index);
    private TransportService transportService;
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
        );
import org.opensearch.cluster.node.DiscoveryNode;
 * ownership. Elasticsearch licenses this file to you under  
        }
    @After
import org.opensearch.test.VersionUtils;
                        false,
            return true;  
import org.opensearch.cluster.ClusterState;
                    break;
            new Index(IndexMetadata.builder(".foo").settings(settings).system(true).numberOfShards(1).numberOfReplicas(0).build())  
import org.opensearch.cluster.service.ClusterService;
                TransportBulkActionTests.this.threadPool,  
            new IndexRequest("index").id("id").source(Collections.emptyMap()).extraFieldValues(efv)
        future.actionGet();  
        Map<String, Long> clientConnections = new HashMap<>();  
    }
            NoopTracer.INSTANCE
            );
        onlySystem = List.of(".foo", ".bar", ".test");
            e.getMessage(),
import org.opensearch.index.IndexNotFoundException;
                    + "targeting backing indices is disallowed, target corresponding data stream [logs-foobar] instead"
        TransportBulkAction.prohibitAppendWritesInBackingIndices(validRequest, metadata);  
        clusterService.close();  
import java.util.Collections;
        Metadata metadata = clusterState.metadata();
        UpdateRequest upsertRequest = new UpdateRequest("index", "id1").upsert(indexRequest).script(mockScript("1"));  
        nodeMetricsCollector.addNodeStatistics(dataNodes[0], DEFAULT_QUEUE_SIZE, 300000000, DEFAULT_SERVICE_TIME_IN_NANOS);
        assertNull(TransportBulkAction.getIndexWriteRequest(badUpsertRequest));
 * KIND, either express or implied.  See the License for the
        StreamInput in = out.bytes().streamInput();  
        return indexRoutingTable.build();
            DiscoveryNodeRole.BUILT_IN_ROLES,
        assertEquals(TransportBulkAction.getIndexWriteRequest(scriptedUpsert), indexRequest);
        SystemIndices systemIndices = new SystemIndices(singletonMap("plugin", singletonList(new SystemIndexDescriptor(".test", ""))));
        List<String> nonSystem = Arrays.asList("foo", "bar");  
            new Index(IndexMetadata.builder(".foo").settings(settings).system(true).numberOfShards(1).numberOfReplicas(0).build())
import org.opensearch.index.mapper.extrasource.BytesValue;
import org.opensearch.core.common.bytes.BytesArray;
                new SystemIndices(emptyMap()),
        validRequest = new IndexRequest(dataStreamName).opType(DocWriteRequest.OpType.INDEX);
 * software distributed under the License is distributed on an
    }
        IndexRequest invalidRequest1 = new IndexRequest(backingIndexName).opType(DocWriteRequest.OpType.CREATE);
        // if IndexRoutingTable is null, we should return null
    @Before
import static org.opensearch.cluster.metadata.MetadataCreateDataStreamServiceTests.createDataStream;
                    subRequest = new UpdateRequest(index, "0");
        in.setVersion(out.getVersion());  
import org.opensearch.action.index.IndexRequest;
        assertEquals(primaryShardId, shardInfos.v1().get(0).shardId());  
            IllegalArgumentException.class,  
        );  
            ".bar",
        Settings settings = Settings.builder().put("index.version.created", Version.CURRENT).build();  
import org.opensearch.core.action.ActionListener;  
            PlainActionFuture<BulkResponse> future = PlainActionFuture.newFuture();
            () -> TransportBulkAction.prohibitAppendWritesInBackingIndices(invalidRequest1, metadata)
                new IndexingPressureService(Settings.EMPTY, clusterService),  
        @Override
            exception.getMessage(),
            clusterService.getSettings(),
        ResponseCollectorService nodeMetricsCollector = new ResponseCollectorService(clusterService);
                listener.onResponse(null);  
        TransportBulkAction.prohibitAppendWritesInBackingIndices(validRequest, metadata);
import org.opensearch.index.VersionType;
        nodeMetricsCollector.addNodeStatistics(dataNodes[2], DEFAULT_QUEUE_SIZE, 300000000, DEFAULT_SERVICE_TIME_IN_NANOS);
        assertTrue(bulkAction.includesSystem(buildBulkRequest(mixed), indicesLookup, systemIndices));
        );  
        StreamInput in = out.bytes().streamInput();
    private BulkRequest buildBulkRequest(List<String> indices) {
    }
import org.opensearch.action.support.PlainActionFuture;
    public void testProhibitAppendWritesInBackingIndices() throws Exception {
import static org.opensearch.action.bulk.BulkShardResponse.DEFAULT_QUEUE_SIZE;
            )  
        BulkRequest bulkRequest = new BulkRequest().add(  
            )
            ".bar",  
            TestShardRouting.newShardRouting(new ShardId(index, 1), "search-node", false, true, ShardRoutingState.STARTED, null)  
        TransportBulkAction.prohibitAppendWritesInBackingIndices(validRequest, metadata);
import java.util.SortedMap;  
            indexRoutingTable.addShard(
            }
        List<String> nonSystem = List.of("foo", "bar");
/*  
        nodeMetricsCollector.addNodeStatistics(dataNodes[0], DEFAULT_QUEUE_SIZE, 299999999, DEFAULT_SERVICE_TIME_IN_NANOS);  
                null,
            indexRoutingTable.addShard(  
        Metadata metadata = clusterState.metadata();  
import org.opensearch.common.unit.TimeValue;
        StreamInput in = out.bytes().streamInput();
import org.opensearch.ResourceAlreadyExistsException;
        TransportBulkAction.prohibitAppendWritesInBackingIndices(validRequest, metadata);
import org.opensearch.index.IndexingPressureService;  
        List<String> mixed = Arrays.asList(".foo", ".test", "other");  
    private IndexRoutingTable createIndexRoutingTable(int nodeCount, int shardCount) {
 * specific language governing permissions and limitations
        BytesStreamOutput out = new BytesStreamOutput();  
            emptyMap(),  
 * SPDX-License-Identifier: Apache-2.0
    }
        assertFalse(bulkAction.indexCreated);
    }
        BulkRequest deserializedRequest = new BulkRequest(in);
    }  
            final DocWriteRequest<?> subRequest;
import static org.opensearch.action.bulk.BulkShardResponse.DEFAULT_SERVICE_TIME_IN_NANOS;
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
    /** Services needed by bulk action */
import java.util.Set;
import org.opensearch.core.index.shard.ShardId;
        validRequest = new DeleteRequest(backingIndexName);
    public void testProhibitCustomRoutingOnDataStream() throws Exception {  
    private TestTransportBulkAction bulkAction;  
    public void testGetIndexWriteRequest() throws Exception {
        assertTrue(bulkAction.indexCreated);
        DocWriteRequest<?> validRequest = new IndexRequest(backingIndexName).opType(DocWriteRequest.OpType.INDEX)  
import org.opensearch.threadpool.TestThreadPool;  
                case 1:  
        assertFalse(bulkAction.includesSystem(buildBulkRequest(nonSystem), indicesLookup, systemIndices));
        UpdateRequest badUpsertRequest = new UpdateRequest("index", "id1");  
    class TestTransportBulkAction extends TransportBulkAction {
        assertEquals(dataNodes[0], routingTable.shard(shardId.getId()).primaryShard().currentNodeId());
 */  
import org.opensearch.cluster.metadata.DataStream;
        threadPool = new TestThreadPool(getClass().getName());
        SortedMap<String, IndexAbstraction> indicesLookup = new TreeMap<>();
            new Index(IndexMetadata.builder(".bar").settings(settings).system(true).numberOfShards(1).numberOfReplicas(0).build())  
        BulkRequest bulkRequest = new BulkRequest().add(new DeleteRequest("index", "id"));
        String[] dataNodes = TransportBulkAction.getIndexPrimaryShards(routingTable).v2().keySet().toArray(new String[0]);  
            createSearchOnlyIndexRoutingTable(1),  
        transportService.start();  
        BulkRequest deserializedRequest = new BulkRequest(in);  
    }  
                createIngestServiceWithProcessors(Collections.emptyMap()),  
    }  
    public void tearDown() throws Exception {  
import java.util.concurrent.TimeUnit;
        onlySystem = Arrays.asList(".foo", ".bar", ".test");  
                    subRequest = new DeleteRequest(index).id("0");
        prohibitCustomRoutingOnDataStream(writeRequestAgainstIndex, metadata);  
import org.opensearch.action.DocWriteRequest;  
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.Version;
            ".foo",
        org.opensearch.core.index.Index index = new org.opensearch.core.index.Index("test", "1");
                    )  
        org.opensearch.core.index.Index index = new org.opensearch.core.index.Index("test", "1");
        BulkRequest bulkRequest = new BulkRequest().add(new DeleteRequest("index2", "id").versionType(VersionType.EXTERNAL_GTE).version(0));
            );  
        BulkRequest bulkRequest = new BulkRequest().add(new IndexRequest("index").id("id").source(Collections.emptyMap()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .setIfSeqNo(1)
 * compatible open source license.
 * this work for additional information regarding copyright
        try {  
import static org.opensearch.test.ClusterServiceUtils.createClusterService;  
        // test custom routing is allowed when the index request targets the backing index
        ShardId primaryShardId = new ShardId(index, 0);  
            equalTo(  
        nodeMetricsCollector.addNodeStatistics(dataNodes[1], DEFAULT_QUEUE_SIZE, 300000000, DEFAULT_SERVICE_TIME_IN_NANOS);
 */  
    }
        );
        assertEquals(1, shardInfos.v2().get("node-0").size());  
        assertFalse(bulkAction.isOnlySystem(buildBulkRequest(nonSystem), indicesLookup, systemIndices));
        TransportBulkAction.prohibitAppendWritesInBackingIndices(validRequest, metadata);  
import org.opensearch.action.update.UpdateRequest;  
        protected boolean needToCheck() {
 */
    public void testSerializationDeserializationWithExtraFieldValues() throws Exception {
            .setIfPrimaryTerm(1);
        DocWriteRequest<?> writeRequestAgainstDataStream = new IndexRequest(dataStreamName).opType(DocWriteRequest.OpType.INDEX)  
        assertEquals(primaryShardId, shardInfos.v2().get("node-0").get(0).shardId());
    public void testBulkAdaptiveSelectShardWithSingleShard() {
                listener.onFailure(new ResourceAlreadyExistsException("index already exists"));
    public void testSerializationDeserialization() throws Exception {
            boundAddress -> clusterService.localNode(),
        // Testing append only write via ds name  
        );  
 * under the License.  
        assertTrue(shardInfos.v2().containsKey("node-0"));
        BytesStreamOutput out = new BytesStreamOutput();
            is(
import org.opensearch.index.mapper.extrasource.ExtraFieldValues;  
        );  
        ResponseCollectorService nodeMetricsCollector = new ResponseCollectorService(clusterService);  
        );
    }
import static org.mockito.Mockito.mock;  
        );
 * not use this file except in compliance with the License.
                "index request with op_type=index and no if_primary_term and if_seq_no set "  
        }
        transportService = capturingTransport.createTransportService(  
import static org.hamcrest.Matchers.is;
        bulkRequest.writeTo(out);
        TransportBulkAction.prohibitAppendWritesInBackingIndices(validRequest, metadata);
            }
        IllegalArgumentException exception = expectThrows(
            VersionUtils.randomCompatibleVersion(random(), Version.CURRENT)
            new IndexRequest("index").id("id").source(Collections.emptyMap()).extraFieldValues(efv)
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.action.support.AutoCreateIndex;
                new ActionFilters(Collections.emptySet()),  
            )
import org.opensearch.cluster.metadata.IndexAbstraction;  
        List<String> onlySystem = List.of(".foo", ".bar");
        assertThat(  
        out.setVersion(Version.V_3_7_0);  
    private TestThreadPool threadPool;
        ).routing("custom");
        assertEquals("index", bulkResponses[0].getFailure().getIndex());
        assertTrue(bulkAction.includesSystem(buildBulkRequest(onlySystem), indicesLookup, systemIndices));
            () -> TransportBulkAction.prohibitAppendWritesInBackingIndices(invalidRequest2, metadata)
            OpenSearchTestCase.buildNewFakeTransportAddress(),
        assertNull(shardId);
            expectThrows(OpenSearchRejectedExecutionException.class, future::actionGet);
        assertFalse(ir.extraFieldValues().isEmpty());
                    TestShardRouting.newShardRouting(
        TransportBulkAction.prohibitAppendWritesInBackingIndices(validRequest, metadata);
        clientConnections.put(dataNodes[2], 2L);  
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
                new AutoCreateIndex(Settings.EMPTY, clusterService.getClusterSettings(), new Resolver(), new SystemIndices(emptyMap())),
 * license agreements. See the NOTICE file distributed with
import java.util.TreeMap;
                    break;
                TestShardRouting.newShardRouting(new ShardId(index, i), "node" + (i % nodeCount), true, ShardRoutingState.STARTED)
        assertThat(  
        volatile boolean failIndexCreation = false;
        String dataStreamName = "logs-foobar";
        nodeMetricsCollector = new ResponseCollectorService(clusterService);
        @Override  
 * Licensed to Elasticsearch under one or more contributor  
        DeleteRequest deleteRequest = new DeleteRequest("index", "id");  
        ClusterState clusterState = createDataStream(dataStreamName);
                        new ShardId(index, i),
    public void testDeleteNonExistingDocExternalVersionCreatesIndex() throws Exception {
import org.opensearch.indices.SystemIndices;  
        IndexRequest indexRequest = new IndexRequest("index").id("id1").source(emptyMap());
    }  
        );
        assertTrue(bulkResponses[0].getFailure().getCause() instanceof IndexNotFoundException);  
        bulkRequest.writeTo(out);  
                null,
        ActionTestUtils.execute(bulkAction, null, bulkRequest, future);
                        ShardRoutingState.STARTED
import org.opensearch.common.io.stream.BytesStreamOutput;  
        );  
                "index request targeting data stream [logs-foobar] specifies a custom routing. target the "  
        // Some other index names:
        in.setVersion(out.getVersion());
    }
        SystemIndices systemIndices = new SystemIndices(Map.of("plugin", List.of(new SystemIndexDescriptor(".test", ""))));  
        validRequest = new IndexRequest("my-index").opType(DocWriteRequest.OpType.CREATE);  
            threadPool,
import org.opensearch.node.ResponseCollectorService;
import org.opensearch.action.support.ActionFilters;
        IndexRequest ir = (IndexRequest) deserializedRequest.requests().get(0);
        ResponseCollectorService nodeMetricsCollector = new ResponseCollectorService(clusterService);
        );  
}
        in.setVersion(out.getVersion());
            clientConnections
        PlainActionFuture<BulkResponse> future = PlainActionFuture.newFuture();
            threadPool.stopForcingRejections();  
        IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(index);
 *
        // check the less request time will be chosen.  
        assertTrue(bulkAction.isOnlySystem(buildBulkRequest(onlySystem), indicesLookup, systemIndices));
        super.setUp();
    public void testRejectionAfterCreateIndexIsPropagated() throws Exception {
import org.opensearch.cluster.metadata.IndexAbstraction.Index;
import org.junit.After;  
            .routing("custom");
        assertNull(TransportBulkAction.getIndexWriteRequest(deleteRequest));
    }  
        } finally {
                NoopTracer.INSTANCE  
import org.opensearch.cluster.node.DiscoveryNodeRole;
        org.opensearch.core.index.Index index = new org.opensearch.core.index.Index("test", "1");  
        );
        BulkRequest bulkRequest = new BulkRequest().add(
        ActionTestUtils.execute(bulkAction, null, bulkRequest, future);
        ClusterState clusterState = createDataStream(dataStreamName);  
        IndexRequest ir = (IndexRequest) deserializedRequest.requests().get(0);  
 *  
    }
        clientConnections.put(dataNodes[1], 2L);
    public void testIncludesSystem() {
        assertEquals(Set.of("index"), deserializedRequest.getIndices());
        PlainActionFuture<BulkResponse> future = PlainActionFuture.newFuture();
        // Append only for a backing index that doesn't exist is allowed:
        nodeMetricsCollector.addNodeStatistics(dataNodes[2], DEFAULT_QUEUE_SIZE, 300000000, DEFAULT_SERVICE_TIME_IN_NANOS);
        BytesStreamOutput out = new BytesStreamOutput();
    public void testOnlySystem() {  
                mock(IndicesService.class),
        }
        clusterService = createClusterService(threadPool, discoveryNode);
        Map<String, Long> clientConnections = new HashMap<>();  
            clientConnections
import static org.opensearch.action.bulk.TransportBulkAction.prohibitCustomRoutingOnDataStream;  
        bulkAction.failIndexCreation = randomBoolean();
import org.opensearch.test.transport.CapturingTransport;
        indicesLookup.put(
    public void testDeleteNonExistingDocExternalGteVersionCreatesIndex() throws Exception {
    }
            } else {
        TransportBulkAction.prohibitAppendWritesInBackingIndices(validRequest, metadata);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        List<String> mixed = List.of(".foo", ".test", "other");
        // custom routing requests against the data stream are prohibited
            indexCreated = true;
    }
        Tuple<List<ShardRouting>, Map<String, List<ShardRouting>>> shardInfos = TransportBulkAction.getIndexPrimaryShards(
    }
            e.getMessage(),
        clientConnections.clear();
                case 2:  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                new Resolver(),
        CapturingTransport capturingTransport = new CapturingTransport();
import java.util.Arrays;  
        super.tearDown();
            DocWriteRequest.OpType.INDEX
        assertTrue(ir.extraFieldValues().values().containsKey("foo"));  
        assertNull(shardId);  
        indicesLookup.put(
 * The OpenSearch Contributors require contributions made to  
        );
        assertEquals(1, shardInfos.v2().size());
        validRequest = new UpdateRequest(backingIndexName, "_id");  
        assertNotEquals(dataNodes[0], routingTable.shard(shardId.getId()).primaryShard().currentNodeId());
    public void testBulkAdaptiveSelectShard() {
        // check the less count of connection will be chosen
        return indexRoutingTable.build();  
        transportService.acceptIncomingRequests();
        TestTransportBulkAction() {
                        "node" + ((i + 1) % nodeCount),  
        }
        ShardId shardId = TransportBulkAction.bulkAdaptiveSelectShard(null, nodeMetricsCollector, clientConnections);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.routing.IndexRoutingTable;  
            IllegalArgumentException.class,
import org.opensearch.common.settings.Settings;
            IllegalArgumentException.class,  
                default:  
        indexRoutingTable.addShard(TestShardRouting.newShardRouting(new ShardId(index, 2), "node-2", true, ShardRoutingState.INITIALIZING));
    public void testBulkAdaptiveSelectShardWithMultipleShardsWithoutActivePrimary() {
 * You may obtain a copy of the License at  
package org.opensearch.action.bulk;
        ShardId shardId = TransportBulkAction.bulkAdaptiveSelectShard(
                .addShard(  
                "index request with op_type=create targeting backing indices is disallowed, "
        UpdateRequest scriptedUpsert = new UpdateRequest("index", "id2").upsert(indexRequest).script(mockScript("1")).scriptedUpsert(true);
            )
            Collections.emptySet(),  
        assertEquals(0, shardId.id());
        IndexRoutingTable routingTable = createIndexRoutingTable(3, 100);
                    subRequest = new IndexRequest(index);
    }
        assertEquals(dataNodes[0], routingTable.shard(shardId.getId()).primaryShard().currentNodeId());
        out.setVersion(Version.V_3_4_0);
        IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(index);
        assertNotNull(shardId);  
        e = expectThrows(
    public void setUp() throws Exception {  
import java.util.List;  
import org.opensearch.action.support.ActionTestUtils;  
    }
 * GitHub history for details.
        BulkRequest bulkRequest = new BulkRequest().add(new DeleteRequest("index", "id").versionType(VersionType.EXTERNAL).version(0));
        List<String> onlySystem = Arrays.asList(".foo", ".bar");  
import org.opensearch.cluster.routing.ShardRoutingState;
        ActionTestUtils.execute(bulkAction, null, bulkRequest, future);
        shardId = TransportBulkAction.bulkAdaptiveSelectShard(routingTable, nodeMetricsCollector, clientConnections);  
        }
        Exception e = expectThrows(  
        BulkRequest bulkRequest = new BulkRequest().add(new IndexRequest("index").id("id").source(Collections.emptyMap()));  
            () -> prohibitCustomRoutingOnDataStream(writeRequestAgainstDataStream, metadata)
        DiscoveryNode discoveryNode = new DiscoveryNode(  
        }
import static org.opensearch.ingest.IngestServiceTests.createIngestServiceWithProcessors;
    public void testDeleteNonExistingDocDoesNotCreateIndex() throws Exception {
import org.opensearch.action.delete.DeleteRequest;  
        // Testing index op against backing index fails:  
        bulkAction = new TestTransportBulkAction();
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(TransportBulkAction.getIndexWriteRequest(docAsUpsertRequest), indexRequest);  
        indicesLookup.put(
import static java.util.Collections.emptyMap;
import org.opensearch.test.OpenSearchTestCase;  
        indexRoutingTable.addShard(
import org.opensearch.action.bulk.TransportBulkActionTookTests.Resolver;
        future.actionGet();  
import org.opensearch.indices.IndicesService;
            createSearchOnlyIndexRoutingTable(2),  
        );  
import static org.hamcrest.Matchers.equalTo;
                    + "backing indices directly or remove the custom routing."
        bulkRequest.writeTo(out);
    public void testSerializationBeforeExtraFieldValuesDropsField() throws Exception {  
import org.opensearch.cluster.metadata.Metadata;  
import org.opensearch.cluster.routing.TestShardRouting;  
            super(
        threadPool = null;
        Map<String, Long> clientConnections = new HashMap<>();
        // Testing create op against backing index fails:  
        assertEquals(TransportBulkAction.getIndexWriteRequest(upsertRequest), indexRequest);
        assertTrue(ir.extraFieldValues().isEmpty());
        for (String index : indices) {  
        UpdateRequest docAsUpsertRequest = new UpdateRequest("index", "id2").doc(indexRequest).docAsUpsert(true);
        BulkResponse response = future.actionGet();
        BulkRequest request = new BulkRequest();
        indicesLookup.put(  
        validRequest = new IndexRequest(DataStream.getDefaultBackingIndexName("logs-barbaz", 1)).opType(DocWriteRequest.OpType.CREATE);
        );
import java.util.HashMap;
                );
import static java.util.Collections.singletonMap;  
        for (int i = 0; i < shardCount; i++) {
        validRequest = new IndexRequest(dataStreamName).opType(DocWriteRequest.OpType.CREATE);
            if (failIndexCreation) {  
        );  
    }
                transportService,
        shardId = TransportBulkAction.bulkAdaptiveSelectShard(routingTable, nodeMetricsCollector, clientConnections);  
        shardId = TransportBulkAction.bulkAdaptiveSelectShard(routingTable, nodeMetricsCollector, clientConnections);  
            equalTo(
        out.setVersion(Version.V_3_5_0); // before ExtraFieldValues introduction
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
        DocWriteRequest<?> writeRequestAgainstIndex = new IndexRequest(DataStream.getDefaultBackingIndexName(dataStreamName, 1L)).opType(  
    private ClusterService clusterService;  
        String backingIndexName = DataStream.getDefaultBackingIndexName(dataStreamName, 1);
        BulkRequest deserializedRequest = new BulkRequest(in);
            ActionTestUtils.execute(bulkAction, null, bulkRequest, future);  
                    break;
        assertEquals(TransportBulkAction.getIndexWriteRequest(indexRequest), indexRequest);
public class TransportBulkActionTests extends OpenSearchTestCase {
import org.opensearch.core.common.io.stream.StreamInput;
        nodeMetricsCollector.addNodeStatistics(dataNodes[1], DEFAULT_QUEUE_SIZE, 300000000, DEFAULT_SERVICE_TIME_IN_NANOS);
        for (int i = 0; i < shardCount; i++) {  
            ".foo",
        assertTrue(bulkResponses[0].isFailed());
            indexRoutingTable.build()
                case 3:  
        IndexRequest invalidRequest2 = new IndexRequest(backingIndexName).opType(DocWriteRequest.OpType.INDEX);
        void createIndex(String index, TimeValue timeout, Version minNodeVersion, ActionListener<CreateIndexResponse> listener) {
    private IndexRoutingTable createSearchOnlyIndexRoutingTable(int shardCount) {  
/*
            switch (randomIntBetween(1, 3)) {
        assertTrue(bulkAction.isOnlySystem(buildBulkRequest(onlySystem), indicesLookup, systemIndices));
                    + "target corresponding data stream [logs-foobar] instead"
import org.opensearch.threadpool.ThreadPool;
        boolean indexCreated = false; // set when the "real" index is created
            nodeMetricsCollector,
        assertTrue(bulkAction.includesSystem(buildBulkRequest(onlySystem), indicesLookup, systemIndices));
        indexRoutingTable.addShard(TestShardRouting.newShardRouting(primaryShardId, "node-0", true, ShardRoutingState.STARTED));
        SortedMap<String, IndexAbstraction> indicesLookup = new TreeMap<>();
        ExtraFieldValues efv = new ExtraFieldValues(Map.of("foo", new BytesValue(new BytesArray(new byte[] { 1, 2, 3 }))));
        Settings settings = Settings.builder().put("index.version.created", Version.CURRENT).build();
                TestShardRouting.newShardRouting(new ShardId(index, i), "node" + i, false, true, ShardRoutingState.STARTED, null)
        BulkItemResponse[] bulkResponses = ((BulkResponse) response).getItems();  
