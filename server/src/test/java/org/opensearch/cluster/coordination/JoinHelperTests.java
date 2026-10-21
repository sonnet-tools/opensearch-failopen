                new ActionListenerResponseHandler<>(future, in -> TransportResponse.Empty.INSTANCE)
    public void testSendCompressedValidateJoinFailOnSerializeFailure() throws ExecutionException, InterruptedException, TimeoutException {
        TestClusterSetup testCluster = getTestClusterSetup(Version.CURRENT, true); // Use capturing transport
        // Test on 3.1 node JoinHelper with same cluster UUID
            }
import java.util.Optional;
    }
        TransportService transportService = capturingTransport.createTransportService(
    public void testJoinFailureOnUnhealthyNodes() {
    }
            (s, p, r) -> {},
            }
        assertEquals(expectedActionName, validateRequests[0].action);
        ActionListener<TransportResponse.Empty> listener = new ActionListener<>() {
import org.opensearch.common.SetOnce;
 * The OpenSearch Contributors require contributions made to
        public final DeterministicTaskQueue deterministicTaskQueue;
        joinHelper.sendJoinRequest(node2, randomNonNegativeLong(), optionalJoin2);
        CapturedRequest capturedRequest2a = capturedRequests2a[0];
            assertNotNull(indexMetadata.context());
                throw new AssertionError();
import java.util.concurrent.ExecutionException;
            Settings.builder().put(NODE_NAME_SETTING.getKey(), "node0").build(),
        // complete the previous join to node1
        final PlainActionFuture<TransportResponse.Empty> future = new PlainActionFuture<>();
            },
                future2.completeExceptionally(new AssertionError("validation should fail now"));
 * specific language governing permissions and limitations
        final CompletableFuture<Throwable> future = new CompletableFuture<>();
            capturingTransport.handleResponse(capturedRequest1.requestId, TransportResponse.Empty.INSTANCE);
            : Optional.of(new Join(localNode, node2, randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong()));
            null,
        DiscoveryNode localNode = new DiscoveryNode("node0", buildNewFakeTransportAddress(), Version.CURRENT);
            Collections.emptyList(),
            assertTrue(indexMetadata.getIngestionStatus().isPaused());
            .numberOfReplicas(1)
        // Add in-sync allocation IDs
        testCluster.joinHelper.sendValidateJoinRequest(node1, testCluster.localClusterState, new ActionListener<>() {
        // check that sending another join to node1 now works again
            @Override
            request = new ValidateJoinRequest(otherClusterState);
            @Override
            Settings.builder().put(NODE_NAME_SETTING.getKey(), "node0").build(),
            threadPool
 * software distributed under the License is distributed on an
            request,
        );
            .build();
        verifyValidateJoinActionSent(VALIDATE_JOIN_ACTION_NAME, Version.V_2_1_0);
        indexBuilder.putRolloverInfo(new RolloverInfo("test-alias", Collections.emptyList(), 1000L));
        );
            }
        AtomicReference<StatusInfo> nodeHealthServiceStatus = new AtomicReference<>(new StatusInfo(UNHEALTHY, "unhealthy-info"));
 * Licensed to Elasticsearch under one or more contributor
                    .put(IndexMetadata.SETTING_REPLICATION_TYPE, "DOCUMENT")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            null,
            assertEquals("context", indexMetadata.context().name());
                    .generateClusterUuidIfNeeded()
        final ClusterState otherClusterState = ClusterState.builder(ClusterName.DEFAULT)
        final CompletableFuture<Throwable> future2 = new CompletableFuture<>();
        public final DiscoveryNode localNode;
                logger.error("validation failed for 3.1 node", e);
import org.opensearch.transport.TransportService;
        assertTrue(joinHelper.isJoinPending());
            }
                deterministicTaskQueue.getThreadPool(),
            startJoinRequest -> { throw new AssertionError(); },
/*
            (joinRequest, joinCallback) -> {
import java.util.concurrent.CompletableFuture;
            DeterministicTaskQueue deterministicTaskQueue,
            IndexMetadata indexMetadata = incomingState.metadata().index("test-index");
            ),
        public final JoinHelper joinHelper;
        verifyValidateJoinActionSent(VALIDATE_JOIN_ACTION_NAME, Version.V_2_7_0);
import java.util.Set;
import org.opensearch.action.ActionListenerResponseHandler;
        if (isCapturingTransport) {
        CapturingTransport capturingTransport = new CapturingTransport();
            @Override
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
            assertNotNull(indexMetadata.context());
import org.opensearch.test.transport.CapturingTransport.CapturedRequest;
            buildRemoteStoreNodeService(transportService, deterministicTaskQueue.getThreadPool()),
        verifyValidateJoinActionSent(VALIDATE_COMPRESSED_JOIN_ACTION_NAME, Version.CURRENT);
    }
            );
                    .indices(Map.of(indexName, indexMetadata))
            Settings.EMPTY,
        });
            .settings(
 * You may obtain a copy of the License at
        });
            @Override
            buildRemoteStoreNodeService(transportService, deterministicTaskQueue.getThreadPool()),
            public void onResponse(TransportResponse.Empty empty) {
                logger.info("validation successful");
        version = version == null ? Version.CURRENT : version;
        assertFalse(joinHelper.isJoinPending());
        final CoordinationStateRejectedException coordinationStateRejectedException = expectThrows(
import static org.hamcrest.core.Is.is;
 */
        );
        // now sending the validate join request will fail due to random cluster uuid because version is changed
 * GitHub history for details.
            null,
import org.opensearch.cluster.metadata.AliasMetadata;
                )
            null,
            ),
        );
        });
            this.localClusterState = localClusterState;
        transportService.start();
 * not use this file except in compliance with the License.
            public void onResponse(TransportResponse.Empty empty) {
        assertThat(coordinationStateRejectedException.getMessage(), containsString(expectedMessage));
            Settings.EMPTY,
        CapturedRequest[] capturedRequests1a = capturingTransport.getCapturedRequestsAndClear();
        Throwable t = future2.get(10, TimeUnit.SECONDS);
package org.opensearch.cluster.coordination;
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.cluster.metadata.Context;
            .stateUUID("random2")
           // handler
        CapturedRequest[] capturedRequests1 = capturingTransport.getCapturedRequestsAndClear();
        final CompletableFuture<Throwable> future = new CompletableFuture<>();
                    .put(IndexMetadata.SETTING_PRIORITY, 100)
            public void onResponse(TransportResponse.Empty empty) {
        // and cache will be invalidated
        capturingTransport.handleRemoteError(capturedRequest2.requestId, new CoordinationStateRejectedException("dummy"));
        mappingSource.put("properties", Map.of("field1", Map.of("type", "text")));
        ClusterState clusterState = testCluster.localClusterState;
import static org.hamcrest.Matchers.equalTo;
            Settings.EMPTY,
        Map<String, Object> mappingSource = new HashMap<>();
        CapturedRequest[] capturedRequests2a = capturingTransport.getCapturedRequestsAndClear();
 */
import static org.opensearch.cluster.coordination.JoinHelper.VALIDATE_JOIN_ACTION_NAME;
            .version(1)
                    new FailedToCommitClusterStateException("test")
        );
            : Optional.of(new Join(localNode, node1, randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong()));
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    public void testJoinHelperCachingOnClusterState() throws ExecutionException, InterruptedException, TimeoutException {
        } else {
            CoordinationStateRejectedException.class,
        transportService.start();
                Metadata.builder()
import static org.hamcrest.Matchers.containsString;
        if (actionName.equals(VALIDATE_COMPRESSED_JOIN_ACTION_NAME)) {
            namedWriteableRegistry
            testCluster.transportService.sendRequest(
            : Optional.of(new Join(localNode, node2, randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong()));
        assertTrue(t.getCause().getMessage().contains("different cluster uuid"));
        // Verify both requests were sent with VALIDATE_COMPRESSED_JOIN_ACTION_NAME
        assertFalse(joinHelper.isJoinPending());
 * license agreements. See the NOTICE file distributed with
        // check that sending another join to node1 now works again
        );
            request = new BytesTransportRequest(bytes, testCluster.localNode.getVersion());
            }
        );
        IndexMetadata.Builder indexBuilder = IndexMetadata.builder(indexName)
        Optional<Join> optionalJoin1 = randomBoolean()
                x -> localNode,
            )
            }
        BytesTransportRequest request219 = (BytesTransportRequest) requests[0].request;
        Throwable t = future.get(10, TimeUnit.SECONDS);
            Collections.emptySet(),
        } else if (actionName.equals(VALIDATE_JOIN_ACTION_NAME)) {
        CapturedRequest[] capturedRequests1a = capturingTransport.getCapturedRequestsAndClear();
           // request
        JoinHelper joinHelper = new JoinHelper(
        CapturingTransport capturingTransport = new CapturingTransport();
import org.opensearch.cluster.metadata.IngestionStatus;
                null,
        try (StreamInput input = CompressedStreamUtils.decompressBytes(request219, namedWriteableRegistry)) {
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        CapturedRequest capturedRequest1a = capturedRequests1a[0];
            mock(ClusterService.class),
import org.opensearch.Version;
                    .put(IndexMetadata.INDEX_ROUTING_PARTITION_SIZE_SETTING.getKey(), 1)
import org.opensearch.monitor.StatusInfo;
                testCluster.localNode.getVersion(),
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(node1, capturedRequest1a.node);
        // Create JoinHelper for 2.19 node to test deserialization with same cluster UUID
        assertThat(coordinationStateRejectedException.getMessage(), containsString(otherClusterState.metadata().clusterUUID()));
 * this file be licensed under the Apache-2.0 license or a
        assertThat(
            TransportService transportService,
            public void onFailure(Exception e) {
            () -> 0L,
                deterministicTaskQueue.getThreadPool(),
import org.opensearch.cluster.node.DiscoveryNode;
        }
        }
                    .build()
            VALIDATE_JOIN_ACTION_NAME,
        );
            .numberOfShards(1)
        public final CapturingTransport capturingTransport;
        assertThat(
        CapturedRequest[] validateRequests = testCluster.capturingTransport.getCapturedRequestsAndClear();
        }
        indexBuilder.putMapping(new MappingMetadata("_doc", mappingSource));
        assertTrue(t instanceof RemoteTransportException);
            Collections.emptyMap(),
        TestClusterSetup testCluster = getTestClusterSetup(version, true);
                Collections.emptySet(),
    private void assertJoinValidationRejectsMismatchedClusterUUID(String actionName, String expectedMessage) throws IOException {
            future::actionGet
            },
        // check that sending another join to node1 is a noop as the previous join is still in progress
        assertTrue(t.getCause() instanceof CoordinationStateRejectedException);
        joinHelper.sendJoinRequest(node1, 0L, optionalJoin1);
            DiscoveryNode localNode,
        );
        DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(
    }
        request = new BytesTransportRequest(null, testCluster.localNode.getVersion());
                    .templates(Map.of(indexName, IndexTemplateMetadata.builder(indexName).patterns(List.of("pattern")).build()))
        };
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            () -> null,
            public void onResponse(TransportResponse.Empty empty) {
            .stateUUID("random2")
    private void verifyValidateJoinActionSent(String expectedActionName, Version version) {
            ? Optional.empty()
        DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(
        BytesTransportRequest request31 = (BytesTransportRequest) requests[1].request;
        // check that sending another join to node2 works if the optionalJoin is different
        assertEquals(2, requests.length);
                testCluster.localNode,
                future.complete(e);
            transportService,
        // check that sending a join to node2 doesn't work
            assertNotNull(indexMetadata.context().params());
import org.opensearch.cluster.ClusterState;
            .version(testCluster.localClusterState.version() + 1)
            public void onFailure(Exception e) {
        testCluster.deterministicTaskQueue.runAllTasks();
 *
            is(Level.DEBUG)
            "join validation on cluster state with a different cluster uuid"
            (s, p, r) -> {},
        ClusterState randomState = ClusterState.builder(new ClusterName("random"))
            random()
            .settingsVersion(1)
                throw new AssertionError();
                logger.info("validation successful for 3.1 node");
        // Add mapping
            ClusterState incomingState = ClusterState.readFrom(input, node31);
 * KIND, either express or implied.  See the License for the
            BytesReference bytes = CompressedStreamUtils.createCompressedStream(
import org.opensearch.core.action.ActionListener;
                future2.complete(e);
    }
            Collections.emptyList(),
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.cluster.ClusterName;
            }
public class JoinHelperTests extends OpenSearchTestCase {
        logger.info("Decompression test passed for 2.19 node");
            JoinHelper.FailedJoinAttempt.getLogLevel(
            x -> localNode,
        assertThat(capturedRequests2.length, equalTo(0));
            null,
            random()
        assertEquals(node2, capturedRequest2a.node);
    }
            this.capturingTransport = capturingTransport;
import org.opensearch.transport.TransportException;
            public void onFailure(Exception e) {
                new RemoteTransportException("caused by NotClusterManagerException", new NotClusterManagerException("test"))
        return new TestClusterSetup(deterministicTaskQueue, localNode, transportService, localClusterState, joinHelper, capturingTransport);
        CapturedRequest capturedRequest1a = capturedRequests1a[0];
        DiscoveryNode node2 = new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.CURRENT);
        );
        JoinHelper joinHelper = new JoinHelper(
            public void onFailure(Exception e) {
                new RemoteTransportException(
                logger.error("validation failed for 2.19 node", e);
        assertEquals(1, validateRequests.length);
/*
    }
            () -> 0L,
        if (randomBoolean()) {
import org.opensearch.core.transport.TransportResponse;
        CapturedRequest capturedRequest1 = capturedRequests1[0];
    }
        IndexMetadata indexMetadata = indexBuilder.build();
            () -> new StatusInfo(HEALTHY, "info"),
        DiscoveryNode localNode = new DiscoveryNode("node0", buildNewFakeTransportAddress(), version);
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        JoinHelper joinHelper = new JoinHelper(
        CapturedRequest[] capturedRequests2 = capturingTransport.getCapturedRequestsAndClear();
                actionName,
        final ClusterState localClusterState = ClusterState.builder(ClusterName.DEFAULT)
        assertFalse(joinHelper.isJoinPending());
        joinHelper.sendJoinRequest(node1, randomNonNegativeLong(), optionalJoin1);
 * this work for additional information regarding copyright
        indexBuilder.putAlias(AliasMetadata.builder("test-alias").build());
            }
        // Add alias
            Collections.emptySet(),
            );
            capturingTransport.handleRemoteError(capturedRequest1.requestId, new CoordinationStateRejectedException("dummy"));
            : Optional.of(new Join(localNode, node1, randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong()));
        assertThat(capturedRequests2.length, equalTo(1));
        return new RemoteStoreNodeService(new SetOnce<>(repositoriesService)::get, threadPool);
        );
        assertFalse(joinHelper.isJoinPending());
        // Add custom data
                    .put(IndexMetadata.SETTING_CREATION_DATE, System.currentTimeMillis())
            .metadata(
    }
                request,
import java.util.concurrent.TimeUnit;
import org.opensearch.threadpool.ThreadPool;
                null,
            Collections.emptyList(),
            () -> localClusterState,
import org.opensearch.action.support.PlainActionFuture;
            transportService,
            this.deterministicTaskQueue = deterministicTaskQueue;
            }
        assertThat(capturedRequests1a.length, equalTo(1));
            public void onResponse(TransportResponse.Empty empty) {
            JoinHelper.FailedJoinAttempt.getLogLevel(
        testCluster.transportService.sendRequest(
            (s, p, r) -> {},
            startJoinRequest -> { throw new AssertionError(); },
                future.complete(e);
        testCluster.joinHelper.sendValidateJoinRequest(testCluster.localNode, testCluster.localClusterState, listener);
                    .put(IndexMetadata.SETTING_VERSION_CREATED, version)
 *
import org.opensearch.test.transport.MockTransport;
                Settings.builder()
        DiscoveryNode node219 = new DiscoveryNode("node219", buildNewFakeTransportAddress(), Version.V_2_19_0);
                Settings.EMPTY,
        // check that sending a join to node1 doesn't work
import org.opensearch.test.OpenSearchTestCase;
            Settings.EMPTY,
        DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT);
        ActionListener<TransportResponse.Empty> listener2 = new ActionListener<>() {
import org.opensearch.repositories.RepositoriesService;
        joinHelper.sendJoinRequest(node1, 0L, optionalJoin1);
        public final ClusterState localClusterState;
            }
            .metadata(Metadata.builder().generateClusterUuidIfNeeded())
            Settings.EMPTY,
        expectThrows(NullPointerException.class, future::actionGet);
        Optional<Join> optionalJoin2 = randomBoolean()
            namedWriteableRegistry
        Optional<Join> optionalJoin2 = randomBoolean()
            .build();
        }
            null,
import org.opensearch.test.transport.CapturingTransport;
            ? Optional.empty()
        assertEquals(node2, capturedRequest2.node);
        assertFalse(joinHelper.isJoinPending());
        String indexName = "test-index";
        CapturedRequest[] requests = testCluster.capturingTransport.getCapturedRequestsAndClear();
            JoinHelper.FailedJoinAttempt.getLogLevel(
                future.completeExceptionally(new AssertionError("validate join should not fail here"));
            }
import static org.opensearch.cluster.coordination.JoinHelper.VALIDATE_COMPRESSED_JOIN_ACTION_NAME;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.NotClusterManagerException;
import static org.mockito.Mockito.mock;
    private RemoteStoreNodeService buildRemoteStoreNodeService(TransportService transportService, ThreadPool threadPool) {
            transportService,
import java.util.List;
 *     http://www.apache.org/licenses/LICENSE-2.0
            IndexMetadata indexMetadata = incomingState.metadata().index("test-index");
            is(Level.INFO)
    }
        public TransportService transportService;
                NoopTracer.INSTANCE
            .build();
        // validation will pass due to cached cluster state
        Optional<Join> optionalJoin2a = optionalJoin2.isPresent() && randomBoolean()
        DiscoveryNode node31 = new DiscoveryNode("node31", buildNewFakeTransportAddress(), Version.V_3_1_0);
            null,
            testCluster.transportService.sendRequest(
            ),
        assertThat(capturedRequests2a.length, equalTo(1));
            assertNotNull(indexMetadata.getIngestionStatus());
/*
            @Override
            transportService,
        final PlainActionFuture<TransportResponse.Empty> future = new PlainActionFuture<>();
            ClusterState localClusterState,
        assertThat(JoinHelper.FailedJoinAttempt.getLogLevel(new TransportException("generic transport exception")), is(Level.INFO));
                throw new AssertionError();
                new RemoteTransportException("caused by CoordinationStateRejectedException", new CoordinationStateRejectedException("test"))
            transportService = capturingTransport.createTransportService(
            Settings.builder().put(NODE_NAME_SETTING.getKey(), "node0").build(),
import java.io.IOException;
        DiscoveryNode localNode = new DiscoveryNode("node0", buildNewFakeTransportAddress(), Version.CURRENT);
            @Override
import java.util.Map;
            "join validation on cluster state with a different cluster uuid"
        testCluster.joinHelper.sendValidateJoinRequest(node219, clusterState, new ActionListener<>() {
        DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), version);
        joinHelper.sendJoinRequest(node2, 0L, optionalJoin2a);
                    .put(IndexMetadata.SETTING_INDEX_UUID, "test-uuid")
        Optional<Join> optionalJoin1 = randomBoolean()
        transportService.start();
                NoopTracer.INSTANCE
        public TestClusterSetup(
        indexBuilder.putCustom("test-custom", Map.of("key1", "value1"));
        nodeHealthServiceStatus.getAndSet(new StatusInfo(HEALTHY, "healthy-info"));
            assertFalse(indexMetadata.getIngestionStatus().isPaused());
import org.opensearch.transport.BytesTransportRequest;
            x -> localNode,
        joinHelper.sendJoinRequest(node2, 0L, optionalJoin2);
            @Override
                otherClusterState::writeTo
            .state(IndexMetadata.State.OPEN);
                testCluster.localNode,
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.node.remotestore.RemoteStoreNodeService;
                x -> localNode,
            () -> null,
        TransportService transportService = capturingTransport.createTransportService(
        );
            ),
        // check that sending a join to node1 works
            assertNotNull(indexMetadata.context().params());
import java.util.concurrent.TimeoutException;
        assertThat(capturingTransport.getCapturedRequestsAndClear().length, equalTo(0));
        assertThat(capturedRequests1.length, equalTo(0));
            // Ingestion Status is set to default value by the IndexMetadata builder
    private TestClusterSetup getTestClusterSetup(Version version, boolean isCapturingTransport) {
 * under the License.
import org.opensearch.cluster.metadata.MappingMetadata;
    }
            public void onResponse(TransportResponse.Empty empty) {
import org.opensearch.transport.TransportRequest;
        indexBuilder.putInSyncAllocationIds(0, Set.of("alloc-1", "alloc-2"));
        // Test with 3.1 node
            .creationDate(System.currentTimeMillis())
        capturingTransport.handleRemoteError(capturedRequest1a.requestId, new CoordinationStateRejectedException("dummy"));
            ? Optional.empty()
        );
            startJoinRequest -> { throw new AssertionError(); },
        capturingTransport.handleRemoteError(capturedRequest2a.requestId, new CoordinationStateRejectedException("dummy"));
            this.joinHelper = joinHelper;
            assertEquals("context", indexMetadata.context().name());
        transportService.start();
        testCluster.joinHelper.sendValidateJoinRequest(testCluster.localNode, randomState2, listener2);
            this.localNode = localNode;
        verifyValidateJoinActionSent(VALIDATE_JOIN_ACTION_NAME, Version.V_2_8_0);
            )
        joinHelper.sendJoinRequest(node1, 0L, optionalJoin1);
        indexBuilder.context(new Context("context"));
            .build();
import org.opensearch.transport.RemoteTransportException;
 *
            NoopTracer.INSTANCE
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.atomic.AtomicReference;
            );
 */
 * compatible open source license.
        assertThat(capturedRequests1a.length, equalTo(1));
            this.transportService = transportService;
        }
        RepositoriesService repositoriesService = new RepositoriesService(
            testCluster.localNode,
    public void testValidateJoinSentWithCorrectActionForVersions() {
        // check that sending a join to node2 works
        try (StreamInput input = CompressedStreamUtils.decompressBytes(request31, namedWriteableRegistry)) {
            @Override
import org.opensearch.cluster.metadata.Metadata;
        TestClusterSetup testCluster = getTestClusterSetup(null, false);
        // Test with 2.19 node
        TransportService transportService;
                Settings.EMPTY,
        joinHelper.sendJoinRequest(node1, 0L, optionalJoin1);
            );
                    .put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-1")
            Settings.EMPTY,
        testCluster.deterministicTaskQueue.runAllTasks();
            .aliasesVersion(1)
            );
        transportService.acceptIncomingRequests();
                logger.info("validation successful for 2.19 node");
        DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT);
        CapturedRequest capturedRequest2 = capturedRequests2[0];
    public void testCompressedValidateJoinRequestForDifferentNodeVersions() throws Exception {
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            @Override
            Collections.emptyMap(),
            () -> nodeHealthServiceStatus.get(),
            public void onFailure(Exception e) {
            null,
                    "caused by FailedToCommitClusterStateException",
        TestClusterSetup testCluster = getTestClusterSetup(Version.CURRENT, false);
                    .clusterUUIDCommitted(true)
            ? Optional.empty()
        assertEquals(node1, capturedRequest1a.node);
import java.util.Collections;
        assertJoinValidationRejectsMismatchedClusterUUID(
            @Override
            }
        }
        assertTrue(joinHelper.isJoinPending());
                new RemoteTransportException("remote transport exception with generic cause", new Exception())
        assertThat(
            nodeCommissioned -> {},
        assertEquals(node1, capturedRequest1.node);
            },
import org.apache.logging.log4j.Level;
        } else {
    private static class TestClusterSetup {
        ) {
            : Optional.of(new Join(localNode, node2, randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong()));
        TestClusterSetup testCluster = getTestClusterSetup(Version.CURRENT, false);
        final CompletableFuture<Throwable> future = new CompletableFuture<>();
        testCluster.joinHelper.sendValidateJoinRequest(testCluster.localNode, null, new ActionListener<>() {
    public void testJoinDeduplication() {
            .mappingVersion(1)
            nodeCommissioned -> {},
                future.completeExceptionally(new AssertionError("validate join should have failed"));
import java.util.HashMap;
        assertJoinValidationRejectsMismatchedClusterUUID(
        });
            assertNotNull(indexMetadata.getIngestionStatus());
        assertThat(coordinationStateRejectedException.getMessage(), containsString(testCluster.localClusterState.metadata().clusterUUID()));
    public void testJoinValidationRejectsMismatchedClusterUUID() throws IOException {
            public void onFailure(Exception e) {
            transportService = mockTransport.createTransportService(
    }
import static org.opensearch.node.Node.NODE_NAME_SETTING;
            deterministicTaskQueue.getThreadPool(),
import org.opensearch.core.common.io.stream.StreamInput;
    public void testJoinValidationFailsOnDecompressionFailure() {
            JoinHelper.FailedJoinAttempt.getLogLevel(
        );
    private final NamedWriteableRegistry namedWriteableRegistry = DEFAULT_NAMED_WRITABLE_REGISTRY;
        assertThat(capturedRequests1.length, equalTo(1));
import static org.opensearch.monitor.StatusInfo.Status.HEALTHY;
        testCluster.deterministicTaskQueue.runAllTasks();
            (joinRequest, joinCallback) -> {
        assertTrue(t instanceof NullPointerException);
            nodeCommissioned -> {},
            @Override
    public void testFailedJoinAttemptLogLevel() {
                Collections.emptySet(),
        ); // registers
            VALIDATE_COMPRESSED_JOIN_ACTION_NAME,
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
    }
        CapturedRequest[] capturedRequests2 = capturingTransport.getCapturedRequestsAndClear();
            is(Level.DEBUG)
                TransportService.NOOP_TRANSPORT_INTERCEPTOR,
import org.opensearch.action.admin.indices.rollover.RolloverInfo;
            ClusterState incomingState = ClusterState.readFrom(input, node219);
            JoinHelper joinHelper,
    }
            ? Optional.empty()
            @Override
        ClusterState randomState2 = ClusterState.builder(new ClusterName("random"))
        testCluster.joinHelper.sendValidateJoinRequest(node31, clusterState, new ActionListener<>() {
                actionName,
            (joinRequest, joinCallback) -> {
                request,
                TransportService.NOOP_TRANSPORT_INTERCEPTOR,
                new ActionListenerResponseHandler<>(future, in -> TransportResponse.Empty.INSTANCE)
        );
            namedWriteableRegistry
        TransportRequest request;
        MockTransport mockTransport = new MockTransport();
        CapturedRequest[] capturedRequests1 = capturingTransport.getCapturedRequestsAndClear();
            VALIDATE_COMPRESSED_JOIN_ACTION_NAME,
}
        testCluster.joinHelper.sendValidateJoinRequest(testCluster.localNode, randomState, listener);
        DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(
            CapturingTransport capturingTransport
 * Modifications Copyright OpenSearch Contributors. See
        TestClusterSetup testCluster = getTestClusterSetup(Version.CURRENT, false);
            NoopTracer.INSTANCE
            is(Level.DEBUG)
            deterministicTaskQueue.getThreadPool(),
            () -> 0L,
            buildRemoteStoreNodeService(transportService, deterministicTaskQueue.getThreadPool()),
                throw new AssertionError("capturing transport shouldn't run");
import org.opensearch.common.settings.Settings;
        // Create IndexMetadata with all fields set
        indexBuilder.ingestionStatus(new IngestionStatus(true));
            null,
        DiscoveryNode node2 = new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.CURRENT);
            random()
        // complete all the joins and check that isJoinPending is updated
        assertThat(
        logger.info("Decompression test passed for 3.1 node");
        // Add rollover info
        TransportRequest request;
        );
            new ActionListenerResponseHandler<>(future, in -> TransportResponse.Empty.INSTANCE)
        CapturingTransport capturingTransport = new CapturingTransport();
        };
            .version(testCluster.localClusterState.version())
