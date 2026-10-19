            Settings.builder().put(NODE_NAME_SETTING.getKey(), "node0").build(),
import org.opensearch.core.transport.TransportResponse;
import org.opensearch.cluster.ClusterName;
            @Override
import java.util.HashMap;
        IndexMetadata indexMetadata = indexBuilder.build();
                future.complete(e);  
            Settings.builder().put(NODE_NAME_SETTING.getKey(), "node0").build(),
 * under the License.  
                    .put(IndexMetadata.SETTING_INDEX_UUID, "test-uuid")  
            this.transportService = transportService;
                new RemoteTransportException("caused by NotClusterManagerException", new NotClusterManagerException("test"))
        CapturedRequest capturedRequest1a = capturedRequests1a[0];
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
            threadPool  
        assertThat(capturingTransport.getCapturedRequestsAndClear().length, equalTo(0));
        // validation will pass due to cached cluster state
            assertNotNull(indexMetadata.context());  
    private static class TestClusterSetup {
        DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), version);
                    .indices(Map.of(indexName, indexMetadata))
    }  
            @Override  
        testCluster.deterministicTaskQueue.runAllTasks();  
        if (isCapturingTransport) {
            TransportService transportService,
        joinHelper.sendJoinRequest(node1, 0L, optionalJoin1);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        expectThrows(NullPointerException.class, future::actionGet);
            assertTrue(indexMetadata.getIngestionStatus().isPaused());  
        DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT);
        capturingTransport.handleRemoteError(capturedRequest1a.requestId, new CoordinationStateRejectedException("dummy"));  
import org.opensearch.cluster.metadata.IndexMetadata;
            );
        verifyValidateJoinActionSent(VALIDATE_COMPRESSED_JOIN_ACTION_NAME, Version.CURRENT);
            @Override
                x -> localNode,  
import org.opensearch.cluster.metadata.IngestionStatus;  
        // check that sending another join to node1 now works again
            ),
            public void onFailure(Exception e) {
            : Optional.of(new Join(localNode, node2, randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong()));
        );
        // complete all the joins and check that isJoinPending is updated  
        Map<String, Object> mappingSource = new HashMap<>();
            ClusterState localClusterState,
        DiscoveryNode localNode = new DiscoveryNode("node0", buildNewFakeTransportAddress(), version);
        Throwable t = future.get(10, TimeUnit.SECONDS);  
        // Add mapping
            .numberOfReplicas(1)
           // handler
            ? Optional.empty()
        assertThat(capturedRequests1a.length, equalTo(1));
            }  
        assertEquals(node1, capturedRequest1a.node);  
        assertFalse(joinHelper.isJoinPending());
        TestClusterSetup testCluster = getTestClusterSetup(null, false);
        CapturedRequest capturedRequest2 = capturedRequests2[0];
        // check that sending a join to node1 works
        }  
    }
            public void onResponse(TransportResponse.Empty empty) {  
        Optional<Join> optionalJoin2 = randomBoolean()
            CapturingTransport capturingTransport
            is(Level.DEBUG)
        assertEquals(node1, capturedRequest1.node);  
            )  
 * Licensed to Elasticsearch under one or more contributor  
            is(Level.DEBUG)  
        };
import org.opensearch.core.common.bytes.BytesReference;
        assertTrue(t instanceof NullPointerException);
            );
 * KIND, either express or implied.  See the License for the
        joinHelper.sendJoinRequest(node1, 0L, optionalJoin1);
    public void testValidateJoinSentWithCorrectActionForVersions() {
 *
        }  
        assertJoinValidationRejectsMismatchedClusterUUID(  
import org.opensearch.Version;
        transportService.start();
        return new TestClusterSetup(deterministicTaskQueue, localNode, transportService, localClusterState, joinHelper, capturingTransport);
        DiscoveryNode node2 = new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.CURRENT);
    }  
                    .put(IndexMetadata.INDEX_ROUTING_PARTITION_SIZE_SETTING.getKey(), 1)
    public void testJoinValidationRejectsMismatchedClusterUUID() throws IOException {
        // Add in-sync allocation IDs  
            }
            CoordinationStateRejectedException.class,  
            nodeCommissioned -> {},  
            .stateUUID("random2")
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            }
import static org.hamcrest.Matchers.containsString;  
        logger.info("Decompression test passed for 2.19 node");
            (s, p, r) -> {},
import java.util.concurrent.CompletableFuture;
            public void onFailure(Exception e) {
            null,
package org.opensearch.cluster.coordination;
                    new FailedToCommitClusterStateException("test")
            random()
            capturingTransport.handleRemoteError(capturedRequest1.requestId, new CoordinationStateRejectedException("dummy"));
import org.opensearch.test.transport.MockTransport;
        BytesTransportRequest request219 = (BytesTransportRequest) requests[0].request;
        assertThat(
            ),  
import java.util.concurrent.atomic.AtomicReference;
                new ActionListenerResponseHandler<>(future, in -> TransportResponse.Empty.INSTANCE)  
            namedWriteableRegistry
import org.opensearch.action.ActionListenerResponseHandler;
        ClusterState clusterState = testCluster.localClusterState;  
        assertThat(coordinationStateRejectedException.getMessage(), containsString(otherClusterState.metadata().clusterUUID()));
 */
            (joinRequest, joinCallback) -> {  
            nodeCommissioned -> {},
        // complete the previous join to node1  
            new ActionListenerResponseHandler<>(future, in -> TransportResponse.Empty.INSTANCE)
        );  
            .version(testCluster.localClusterState.version() + 1)
import org.opensearch.core.action.ActionListener;
            testCluster.localNode,
        TransportService transportService = capturingTransport.createTransportService(  
            @Override
        testCluster.joinHelper.sendValidateJoinRequest(testCluster.localNode, randomState, listener);
 * the Apache License, Version 2.0 (the "License"); you may
            .mappingVersion(1)
            .settingsVersion(1)  
/*  
import org.opensearch.cluster.NotClusterManagerException;
import java.util.concurrent.TimeUnit;  
 *  
import org.opensearch.cluster.service.ClusterService;
        DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(  
        indexBuilder.context(new Context("context"));
        );  
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
            mock(ClusterService.class),
        DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(  
                logger.error("validation failed for 3.1 node", e);
            );  
            namedWriteableRegistry
            IndexMetadata indexMetadata = incomingState.metadata().index("test-index");
            testCluster.transportService.sendRequest(
            JoinHelper joinHelper,  
        testCluster.deterministicTaskQueue.runAllTasks();
        // check that sending another join to node1 now works again
        final CompletableFuture<Throwable> future = new CompletableFuture<>();
    }
        );
            ? Optional.empty()
        assertEquals(node1, capturedRequest1a.node);
        assertEquals(1, validateRequests.length);
            .metadata(Metadata.builder().generateClusterUuidIfNeeded())
            public void onResponse(TransportResponse.Empty empty) {  
            request,
                    .put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-1")  
import org.opensearch.common.settings.Settings;  
        assertThat(capturedRequests2.length, equalTo(1));
 * compatible open source license.
            () -> new StatusInfo(HEALTHY, "info"),
                request,
    private void verifyValidateJoinActionSent(String expectedActionName, Version version) {
        DiscoveryNode node219 = new DiscoveryNode("node219", buildNewFakeTransportAddress(), Version.V_2_19_0);  
            }
        DiscoveryNode localNode = new DiscoveryNode("node0", buildNewFakeTransportAddress(), Version.CURRENT);
                future2.complete(e);  
 * SPDX-License-Identifier: Apache-2.0
        // now sending the validate join request will fail due to random cluster uuid because version is changed
                request,
        Optional<Join> optionalJoin1 = randomBoolean()
                throw new AssertionError();
        request = new BytesTransportRequest(null, testCluster.localNode.getVersion());  
                otherClusterState::writeTo
        indexBuilder.putInSyncAllocationIds(0, Set.of("alloc-1", "alloc-2"));
        // check that sending another join to node1 is a noop as the previous join is still in progress
                    .put(IndexMetadata.SETTING_CREATION_DATE, System.currentTimeMillis())
        indexBuilder.putMapping(new MappingMetadata("_doc", mappingSource));
            )
        joinHelper.sendJoinRequest(node2, randomNonNegativeLong(), optionalJoin2);  
            null,  
        TestClusterSetup testCluster = getTestClusterSetup(Version.CURRENT, false);
        } else {
        CapturedRequest[] requests = testCluster.capturingTransport.getCapturedRequestsAndClear();
        assertEquals(expectedActionName, validateRequests[0].action);
        ClusterState randomState = ClusterState.builder(new ClusterName("random"))  
            ClusterState incomingState = ClusterState.readFrom(input, node31);  
        joinHelper.sendJoinRequest(node1, 0L, optionalJoin1);  
 *     http://www.apache.org/licenses/LICENSE-2.0
            Settings.EMPTY,
        assertTrue(joinHelper.isJoinPending());
        verifyValidateJoinActionSent(VALIDATE_JOIN_ACTION_NAME, Version.V_2_8_0);
            }
import org.opensearch.test.transport.CapturingTransport.CapturedRequest;  
        CapturedRequest[] capturedRequests1a = capturingTransport.getCapturedRequestsAndClear();  
            JoinHelper.FailedJoinAttempt.getLogLevel(  
    public void testSendCompressedValidateJoinFailOnSerializeFailure() throws ExecutionException, InterruptedException, TimeoutException {
            .metadata(
        }  
 * ownership. Elasticsearch licenses this file to you under  
        CapturedRequest[] capturedRequests2a = capturingTransport.getCapturedRequestsAndClear();
        indexBuilder.putCustom("test-custom", Map.of("key1", "value1"));
        // Create JoinHelper for 2.19 node to test deserialization with same cluster UUID
    }
            .version(testCluster.localClusterState.version())
                TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            ),
 * The OpenSearch Contributors require contributions made to  
            @Override
        AtomicReference<StatusInfo> nodeHealthServiceStatus = new AtomicReference<>(new StatusInfo(UNHEALTHY, "unhealthy-info"));  
            null,  
import static org.hamcrest.core.Is.is;
            null,  
            () -> 0L,
        public final DeterministicTaskQueue deterministicTaskQueue;  
                Settings.EMPTY,
import static org.mockito.Mockito.mock;  
        assertFalse(joinHelper.isJoinPending());
import java.util.Map;
                deterministicTaskQueue.getThreadPool(),
import org.opensearch.cluster.node.DiscoveryNode;  
        JoinHelper joinHelper = new JoinHelper(
        Optional<Join> optionalJoin1 = randomBoolean()  
        // Test with 3.1 node
                    .put(IndexMetadata.SETTING_PRIORITY, 100)
        );
    public void testJoinDeduplication() {
    }  
                logger.info("validation successful for 2.19 node");
        public TransportService transportService;
                future2.completeExceptionally(new AssertionError("validation should fail now"));
            () -> 0L,  
            @Override
}
        assertFalse(joinHelper.isJoinPending());
import org.opensearch.node.remotestore.RemoteStoreNodeService;
            deterministicTaskQueue.getThreadPool(),
        assertThat(JoinHelper.FailedJoinAttempt.getLogLevel(new TransportException("generic transport exception")), is(Level.INFO));  
        assertTrue(t.getCause().getMessage().contains("different cluster uuid"));  
        indexBuilder.putAlias(AliasMetadata.builder("test-alias").build());
            this.localClusterState = localClusterState;  
        });
            .build();
        final PlainActionFuture<TransportResponse.Empty> future = new PlainActionFuture<>();
        });
                Collections.emptySet(),
            x -> localNode,
                    .put(IndexMetadata.SETTING_VERSION_CREATED, version)
        if (actionName.equals(VALIDATE_COMPRESSED_JOIN_ACTION_NAME)) {
 */  
        );  
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
            @Override  
            public void onResponse(TransportResponse.Empty empty) {  
            null,
                future.complete(e);
            @Override
            assertNotNull(indexMetadata.getIngestionStatus());
            VALIDATE_COMPRESSED_JOIN_ACTION_NAME,  
    }
        mappingSource.put("properties", Map.of("field1", Map.of("type", "text")));  
        indexBuilder.putRolloverInfo(new RolloverInfo("test-alias", Collections.emptyList(), 1000L));
        DiscoveryNode node2 = new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.CURRENT);  
import org.opensearch.test.transport.CapturingTransport;
        // Add alias  
           // request
                actionName,  
            Collections.emptyList(),
        testCluster.transportService.sendRequest(
            assertEquals("context", indexMetadata.context().name());
        logger.info("Decompression test passed for 3.1 node");
        testCluster.joinHelper.sendValidateJoinRequest(testCluster.localNode, testCluster.localClusterState, listener);
                TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
 * GitHub history for details.
            startJoinRequest -> { throw new AssertionError(); },
        );
        Throwable t = future2.get(10, TimeUnit.SECONDS);  
            @Override
            Collections.emptyList(),
        verifyValidateJoinActionSent(VALIDATE_JOIN_ACTION_NAME, Version.V_2_7_0);  
        final CompletableFuture<Throwable> future = new CompletableFuture<>();  
            .stateUUID("random2")
            VALIDATE_JOIN_ACTION_NAME,
        // and cache will be invalidated
            }
        version = version == null ? Version.CURRENT : version;  
        CapturedRequest[] capturedRequests2 = capturingTransport.getCapturedRequestsAndClear();
        transportService.start();  
            namedWriteableRegistry
            is(Level.DEBUG)
    }  
        try (StreamInput input = CompressedStreamUtils.decompressBytes(request31, namedWriteableRegistry)) {
 * specific language governing permissions and limitations
        assertThat(
import java.util.Optional;
            assertEquals("context", indexMetadata.context().name());  
        assertEquals(node2, capturedRequest2a.node);
    private final NamedWriteableRegistry namedWriteableRegistry = DEFAULT_NAMED_WRITABLE_REGISTRY;  
import static org.opensearch.cluster.coordination.JoinHelper.VALIDATE_JOIN_ACTION_NAME;
            .numberOfShards(1)
import org.opensearch.cluster.metadata.MappingMetadata;
import java.io.IOException;  
            nodeCommissioned -> {},
            null,
                future.completeExceptionally(new AssertionError("validate join should not fail here"));
            transportService,
        assertThat(capturedRequests2a.length, equalTo(1));
        // Verify both requests were sent with VALIDATE_COMPRESSED_JOIN_ACTION_NAME  
            .build();
            Collections.emptyMap(),
                    .clusterUUIDCommitted(true)
            buildRemoteStoreNodeService(transportService, deterministicTaskQueue.getThreadPool()),
        public final CapturingTransport capturingTransport;
        );
            (s, p, r) -> {},
        CapturedRequest[] capturedRequests2 = capturingTransport.getCapturedRequestsAndClear();  
import org.opensearch.action.admin.indices.rollover.RolloverInfo;  
            assertNotNull(indexMetadata.context().params());
        TestClusterSetup testCluster = getTestClusterSetup(Version.CURRENT, false);  
                NoopTracer.INSTANCE
        TestClusterSetup testCluster = getTestClusterSetup(Version.CURRENT, false);  
            (joinRequest, joinCallback) -> {  
        capturingTransport.handleRemoteError(capturedRequest2a.requestId, new CoordinationStateRejectedException("dummy"));
            public void onResponse(TransportResponse.Empty empty) {
 * You may obtain a copy of the License at  
        assertThat(
                Metadata.builder()
            future::actionGet
import org.opensearch.transport.TransportService;
            transportService = capturingTransport.createTransportService(
                    .build()
            random()  
        assertTrue(t instanceof RemoteTransportException);
            Settings.EMPTY,
            Settings.EMPTY,
/*
import static org.hamcrest.Matchers.equalTo;
        assertThat(coordinationStateRejectedException.getMessage(), containsString(testCluster.localClusterState.metadata().clusterUUID()));
    public void testJoinFailureOnUnhealthyNodes() {
                    .generateClusterUuidIfNeeded()  
        ClusterState randomState2 = ClusterState.builder(new ClusterName("random"))  
        joinHelper.sendJoinRequest(node1, 0L, optionalJoin1);  
                    .templates(Map.of(indexName, IndexTemplateMetadata.builder(indexName).patterns(List.of("pattern")).build()))  
 * software distributed under the License is distributed on an
    }
 *
        } else if (actionName.equals(VALIDATE_JOIN_ACTION_NAME)) {
            NoopTracer.INSTANCE
import java.util.List;  
        Optional<Join> optionalJoin2 = randomBoolean()
import static org.opensearch.node.Node.NODE_NAME_SETTING;
import org.opensearch.transport.TransportException;
import static org.opensearch.monitor.StatusInfo.Status.HEALTHY;  
        };  
        }
            assertNotNull(indexMetadata.context());
            .state(IndexMetadata.State.OPEN);
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
        CapturedRequest capturedRequest1 = capturedRequests1[0];
            ClusterState incomingState = ClusterState.readFrom(input, node219);
        testCluster.joinHelper.sendValidateJoinRequest(testCluster.localNode, null, new ActionListener<>() {
                throw new AssertionError("capturing transport shouldn't run");  
            startJoinRequest -> { throw new AssertionError(); },  
        );
        CapturedRequest capturedRequest1a = capturedRequests1a[0];  
                deterministicTaskQueue.getThreadPool(),
 */
                x -> localNode,
            () -> null,
    private TestClusterSetup getTestClusterSetup(Version version, boolean isCapturingTransport) {
            }  
                NoopTracer.INSTANCE  
        // check that sending a join to node2 works
 * not use this file except in compliance with the License.
    }  
            .settings(  
                    .put(IndexMetadata.SETTING_REPLICATION_TYPE, "DOCUMENT")
        );
import org.opensearch.common.SetOnce;
        // Test on 3.1 node JoinHelper with same cluster UUID  
        transportService.acceptIncomingRequests();
        // check that sending a join to node1 doesn't work
            assertFalse(indexMetadata.getIngestionStatus().isPaused());
        assertTrue(joinHelper.isJoinPending());
        TransportService transportService;  
        assertThat(capturedRequests2.length, equalTo(0));  
            JoinHelper.FailedJoinAttempt.getLogLevel(
        // Create IndexMetadata with all fields set  
            JoinHelper.FailedJoinAttempt.getLogLevel(
        joinHelper.sendJoinRequest(node1, randomNonNegativeLong(), optionalJoin1);  
        // Add custom data  
        TransportRequest request;  
            request = new BytesTransportRequest(bytes, testCluster.localNode.getVersion());
        CapturingTransport capturingTransport = new CapturingTransport();  
                throw new AssertionError();  
        final ClusterState localClusterState = ClusterState.builder(ClusterName.DEFAULT)  
                new ActionListenerResponseHandler<>(future, in -> TransportResponse.Empty.INSTANCE)
            }  
            @Override
        ActionListener<TransportResponse.Empty> listener2 = new ActionListener<>() {
        // check that sending another join to node2 works if the optionalJoin is different
            },
        public final JoinHelper joinHelper;
import org.opensearch.cluster.ClusterState;  
        JoinHelper joinHelper = new JoinHelper(  
        final CompletableFuture<Throwable> future = new CompletableFuture<>();
import java.util.Set;  
        final PlainActionFuture<TransportResponse.Empty> future = new PlainActionFuture<>();
            testCluster.transportService.sendRequest(
        CapturedRequest[] capturedRequests1a = capturingTransport.getCapturedRequestsAndClear();
            .aliasesVersion(1)
            ? Optional.empty()  
            );
            Collections.emptyList(),  
import org.opensearch.cluster.metadata.Context;  
        nodeHealthServiceStatus.getAndSet(new StatusInfo(HEALTHY, "healthy-info"));
        indexBuilder.ingestionStatus(new IngestionStatus(true));  
                Settings.EMPTY,  
                Settings.builder()
        IndexMetadata.Builder indexBuilder = IndexMetadata.builder(indexName)
import java.util.concurrent.ExecutionException;
            Settings.EMPTY,
        assertThat(capturedRequests1a.length, equalTo(1));
            ),
            ? Optional.empty()
    private void assertJoinValidationRejectsMismatchedClusterUUID(String actionName, String expectedMessage) throws IOException {  
        final CoordinationStateRejectedException coordinationStateRejectedException = expectThrows(
    }  
        TransportRequest request;
                logger.info("validation successful");
        CapturingTransport capturingTransport = new CapturingTransport();
        }
            },
        // Add rollover info  
            },
            () -> null,
                null,
    public void testJoinHelperCachingOnClusterState() throws ExecutionException, InterruptedException, TimeoutException {
            BytesReference bytes = CompressedStreamUtils.createCompressedStream(  
        joinHelper.sendJoinRequest(node2, 0L, optionalJoin2a);  
                new RemoteTransportException(  
            (joinRequest, joinCallback) -> {
        joinHelper.sendJoinRequest(node2, 0L, optionalJoin2);
        );
            public void onResponse(TransportResponse.Empty empty) {
            }
        assertThat(  
        // Test with 2.19 node
        }
            VALIDATE_COMPRESSED_JOIN_ACTION_NAME,  
            this.localNode = localNode;
            IndexMetadata indexMetadata = incomingState.metadata().index("test-index");
            public void onFailure(Exception e) {  
            public void onFailure(Exception e) {
            );  
            () -> 0L,
                )  
        );
            (s, p, r) -> {},
        );  
                    "caused by FailedToCommitClusterStateException",
import org.apache.logging.log4j.Level;  
            Collections.emptySet(),  
        CapturedRequest[] validateRequests = testCluster.capturingTransport.getCapturedRequestsAndClear();  
            transportService,
        ActionListener<TransportResponse.Empty> listener = new ActionListener<>() {
import java.util.concurrent.TimeoutException;
            assertNotNull(indexMetadata.context().params());
            ? Optional.empty()  
        testCluster.deterministicTaskQueue.runAllTasks();
        DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT);  
/*
        DiscoveryNode localNode = new DiscoveryNode("node0", buildNewFakeTransportAddress(), Version.CURRENT);
            buildRemoteStoreNodeService(transportService, deterministicTaskQueue.getThreadPool()),  
            deterministicTaskQueue.getThreadPool(),
        BytesTransportRequest request31 = (BytesTransportRequest) requests[1].request;
        assertTrue(t.getCause() instanceof CoordinationStateRejectedException);
        CapturingTransport capturingTransport = new CapturingTransport();
            "join validation on cluster state with a different cluster uuid"
        DiscoveryNode node31 = new DiscoveryNode("node31", buildNewFakeTransportAddress(), Version.V_3_1_0);
    public void testCompressedValidateJoinRequestForDifferentNodeVersions() throws Exception {  
import static org.opensearch.cluster.coordination.JoinHelper.VALIDATE_COMPRESSED_JOIN_ACTION_NAME;
                testCluster.localNode.getVersion(),
        assertFalse(joinHelper.isJoinPending());  
            public void onResponse(TransportResponse.Empty empty) {
            .build();  
        assertJoinValidationRejectsMismatchedClusterUUID(
        assertEquals(node2, capturedRequest2.node);  
            null,
            .creationDate(System.currentTimeMillis())  
            : Optional.of(new Join(localNode, node1, randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong()));
        return new RemoteStoreNodeService(new SetOnce<>(repositoriesService)::get, threadPool);
            }
            // Ingestion Status is set to default value by the IndexMetadata builder  
        TransportService transportService = capturingTransport.createTransportService(  
 * license agreements. See the NOTICE file distributed with
            .build();  
        CapturedRequest[] capturedRequests1 = capturingTransport.getCapturedRequestsAndClear();
            buildRemoteStoreNodeService(transportService, deterministicTaskQueue.getThreadPool()),  
        assertThat(capturedRequests1.length, equalTo(1));
        RepositoriesService repositoriesService = new RepositoriesService(  
                actionName,
            random()
            this.capturingTransport = capturingTransport;
            capturingTransport.handleResponse(capturedRequest1.requestId, TransportResponse.Empty.INSTANCE);
                Collections.emptySet(),  
            "join validation on cluster state with a different cluster uuid"
            .version(1)
            NoopTracer.INSTANCE
                future.completeExceptionally(new AssertionError("validate join should have failed"));
            JoinHelper.FailedJoinAttempt.getLogLevel(  
        final ClusterState otherClusterState = ClusterState.builder(ClusterName.DEFAULT)  
        testCluster.joinHelper.sendValidateJoinRequest(node219, clusterState, new ActionListener<>() {
            startJoinRequest -> { throw new AssertionError(); },  
            request = new ValidateJoinRequest(otherClusterState);  
        TestClusterSetup testCluster = getTestClusterSetup(version, true);  
        // check that sending a join to node2 doesn't work  
            this.deterministicTaskQueue = deterministicTaskQueue;  
    public void testFailedJoinAttemptLogLevel() {
            assertNotNull(indexMetadata.getIngestionStatus());
    }
                throw new AssertionError();
        CapturedRequest capturedRequest2a = capturedRequests2a[0];  
            @Override
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.repositories.RepositoriesService;
import org.opensearch.test.OpenSearchTestCase;
            Settings.builder().put(NODE_NAME_SETTING.getKey(), "node0").build(),
        TestClusterSetup testCluster = getTestClusterSetup(Version.CURRENT, true); // Use capturing transport
                testCluster.localNode,  
        transportService.start();  
            Settings.EMPTY,
            transportService,
import java.util.Collections;
        });
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.transport.BytesTransportRequest;  
        public final ClusterState localClusterState;  
        assertEquals(2, requests.length);
            public void onFailure(Exception e) {
        CapturedRequest[] capturedRequests1 = capturingTransport.getCapturedRequestsAndClear();  
            this.joinHelper = joinHelper;
        verifyValidateJoinActionSent(VALIDATE_JOIN_ACTION_NAME, Version.V_2_1_0);
        Optional<Join> optionalJoin2a = optionalJoin2.isPresent() && randomBoolean()  
        transportService.start();
            () -> nodeHealthServiceStatus.get(),  
        JoinHelper joinHelper = new JoinHelper(
                logger.info("validation successful for 3.1 node");  
            : Optional.of(new Join(localNode, node1, randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong()));
            Collections.emptySet(),  
        );  
        testCluster.joinHelper.sendValidateJoinRequest(node1, testCluster.localClusterState, new ActionListener<>() {  
                new RemoteTransportException("remote transport exception with generic cause", new Exception())
        } else {  
import org.opensearch.core.common.io.stream.StreamInput;
        final CompletableFuture<Throwable> future2 = new CompletableFuture<>();  
                null,
            public void onFailure(Exception e) {
            }
        if (randomBoolean()) {
                testCluster.localNode,
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
                new RemoteTransportException("caused by CoordinationStateRejectedException", new CoordinationStateRejectedException("test"))
        assertThat(capturedRequests1.length, equalTo(0));
        testCluster.joinHelper.sendValidateJoinRequest(testCluster.localNode, randomState2, listener2);  
            Collections.emptyMap(),
            }
        );
        capturingTransport.handleRemoteError(capturedRequest2.requestId, new CoordinationStateRejectedException("dummy"));
import org.opensearch.transport.RemoteTransportException;
import org.opensearch.monitor.StatusInfo;  
            Settings.EMPTY,
    public void testJoinValidationFailsOnDecompressionFailure() {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
        assertThat(coordinationStateRejectedException.getMessage(), containsString(expectedMessage));  
            DeterministicTaskQueue deterministicTaskQueue,
        MockTransport mockTransport = new MockTransport();
            () -> localClusterState,
                logger.error("validation failed for 2.19 node", e);  
            transportService = mockTransport.createTransportService(  
        );  
        ) {
public class JoinHelperTests extends OpenSearchTestCase {
        public TestClusterSetup(
    private RemoteStoreNodeService buildRemoteStoreNodeService(TransportService transportService, ThreadPool threadPool) {
            x -> localNode,
 * this file be licensed under the Apache-2.0 license or a
            DiscoveryNode localNode,  
        try (StreamInput input = CompressedStreamUtils.decompressBytes(request219, namedWriteableRegistry)) {  
        String indexName = "test-index";
        });
            transportService,  
            null,
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
        assertFalse(joinHelper.isJoinPending());
    }  
        testCluster.joinHelper.sendValidateJoinRequest(node31, clusterState, new ActionListener<>() {  
            : Optional.of(new Join(localNode, node2, randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong()));  
            null,  
            @Override  
import org.opensearch.action.support.PlainActionFuture;
 * Modifications Copyright OpenSearch Contributors. See  
        DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(
import org.opensearch.transport.TransportRequest;  
            is(Level.INFO)  
            : Optional.of(new Join(localNode, node2, randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong()));
        public final DiscoveryNode localNode;
import org.opensearch.cluster.metadata.AliasMetadata;
        ); // registers  
    }  
