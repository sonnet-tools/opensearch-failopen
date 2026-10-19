            coordinationMetadataBuilder.addVotingConfigExclusion(otherNode1Exclusion);
                    + actualMaximum
    }
        final int actualMaximum;
            expectSuccess(r -> {
import java.io.IOException;
                    .put(clusterService.state().metadata().persistentSettings())
                            CoordinationMetadata.builder()
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
            })
                countDownLatch.countDown();
                countDownLatch.countDown();
        } else {
        );
                    .put(MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING.getKey(), actualMaximum)
        final ClusterState state = clusterService.state();
            @Override
                        CoordinationMetadata.builder(state.coordinationMetadata())
                countDownLatch.countDown();
        );
import org.opensearch.common.unit.TimeValue;
            makeRequestWithNodeDescriptions("other*"),
    }
            new AddVotingConfigExclusionsRequest("other1", "other2"),
    private ClusterSettings clusterSettings;
            new AddVotingConfigExclusionsRequest(
            actualMaximum = staticMaximum;
        assertWarnings(AddVotingConfigExclusionsRequest.DEPRECATION_MESSAGE);
    private static ThreadPool threadPool;
import org.opensearch.cluster.service.ClusterService;
        final CountDownLatch countDownLatch = new CountDownLatch(2);
            localNode,
        );
        clusterStateObserver.waitForNextChange(new AdjustConfigurationForExclusions(countDownLatch));
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
            singleton(new VotingConfigExclusion("absent_id", VotingConfigExclusion.MISSING_VALUE_MARKER)),
        );
        transportService.sendRequest(
                                .build()
 * the Apache License, Version 2.0 (the "License"); you may
    }
                countDownLatch.countDown();
            clusterService,
            new AddVotingConfigExclusionsRequest("other1", "other2"),
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
        assertThat(
            TimeValue.timeValueSeconds(30)
            AddVotingConfigExclusionsAction.NAME,
                countDownLatch.countDown();
            singleton(new VotingConfigExclusion(VotingConfigExclusion.MISSING_VALUE_MARKER, "absent_node")),
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
            nodeSettings,
    private static DiscoveryNode localNode, otherNode1, otherNode2, otherDataNode;
        final Throwable rootCause = exceptionHolder.get().getRootCause();
        setState(clusterService, builder);
        );
            AddVotingConfigExclusionsAction.NAME,
    private TransportService transportService;
                onException.accept(exp);
            new AddVotingConfigExclusionsRequest("other1"),
        return responseHandler(onResponse, e -> { throw new AssertionError("unexpected", e); });
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            builder(state).metadata(
                    + "] exclusions to the existing ["
            actualMaximum = between(2, 15);
        final CountDownLatch countDownLatch = new CountDownLatch(2);
import org.opensearch.cluster.ClusterStateObserver.Listener;
        public void onTimeout(TimeValue timeout) {
            new AddVotingConfigExclusionsRequest("other1"),
            AddVotingConfigExclusionsAction.NAME,
        );
                )
                @Override
        assertThat(
    private TransportResponseHandler<AddVotingConfigExclusionsResponse> expectSuccess(
                new String[] { "other1", "other2" },
        final CountDownLatch countDownLatch = new CountDownLatch(2);
import org.opensearch.cluster.node.DiscoveryNode;
                            .lastAcceptedConfiguration(VotingConfiguration.of(localNode, otherNode2))
                exceptionHolder.set(e);
    }
            clusterService.getClusterApplierService().state().getVotingConfigExclusions(),
        clusterSettings = new ClusterSettings(nodeSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                countDownLatch.countDown();
                public ClusterState execute(ClusterState currentState) {
                            )
            expectSuccess(e -> {
            })
        transportService.acceptIncomingRequests();
        final ClusterState.Builder builder = builder(state);
                countDownLatch.countDown();
    public void testReturnsErrorIfMaximumExclusionCountExceeded() throws InterruptedException {
            expectSuccess(r -> {
        );
            expectSuccess(e -> {
 *
            clusterService.getClusterApplierService().state().getVotingConfigExclusions()
                    final Set<String> votingNodeIds = new HashSet<>();
                new String[] { "other1" },
    private ClusterStateObserver clusterStateObserver;
 * Modifications Copyright OpenSearch Contributors. See
            makeRequestWithNodeDescriptions("not-a-node"),
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        builder.metadata(
                new VotingConfigExclusion(randomAlphaOfLength(10), randomAlphaOfLength(10))
 *
            })
        );
            rootCause.getMessage(),
import java.util.HashSet;
        clusterStateObserver.waitForNextChange(new AdjustConfigurationForExclusions(countDownLatch));
        assertEquals(
 * this file be licensed under the Apache-2.0 license or a
    }
            containsInAnyOrder(otherNode1Exclusion, otherNode2Exclusion)
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
                                .lastCommittedConfiguration(allNodesConfig)
import org.opensearch.common.settings.Settings;
import org.opensearch.core.common.Strings;
        clusterService = createClusterService(threadPool, localNode);
        transportService.sendRequest(
        @Override
                    .add(otherNode2)
                    assertThat(currentState, sameInstance(state));
            makeRequestWithNodeDescriptions("_all"),
                Strings.EMPTY_ARRAY,
        clusterStateObserver.waitForNextChange(new AdjustConfigurationForExclusions(countDownLatch));
import org.opensearch.cluster.node.DiscoveryNodes.Builder;
            })
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        CoordinationMetadata.Builder coordinationMetadataBuilder = CoordinationMetadata.builder(
 * The OpenSearch Contributors require contributions made to
            clusterService.getClusterApplierService().state().getVotingConfigExclusions(),
                Strings.EMPTY_ARRAY,
        );
                                    .build()
                    .add(otherDataNode)
            existingCount = actualMaximum - 1;
            @Override
            clusterSettings.applySettings(
            );
import org.junit.Before;
    }
                Metadata.builder(state.metadata())
            })
            localNode,
            AddVotingConfigExclusionsAction.NAME,
                    + newCount
                assertNotNull(r);
                TimeValue.timeValueSeconds(30)
        transportService.sendRequest(
            })
            });
            makeRequestWithNodeDescriptions("other*"),
        final SetOnce<TransportException> exceptionHolder = new SetOnce<>();
        };
        // no observer to reconfigure
        assertThat(clusterService.getClusterApplierService().state().getVotingConfigExclusions(), contains(otherNode1Exclusion));
import static org.opensearch.cluster.ClusterState.builder;
            localNode,
        final CountDownLatch countDownLatch = new CountDownLatch(2);
/*
        builder.metadata(
        assertWarnings(AddVotingConfigExclusionsRequest.DEPRECATION_MESSAGE);
        localNodeExclusion = new VotingConfigExclusion(localNode);
    }
        otherNode1 = makeDiscoveryNode("other1");
                countDownLatch.countDown();
import org.junit.BeforeClass;
 * KIND, either express or implied.  See the License for the
            Settings.EMPTY,
 * software distributed under the License is distributed on an
 * GitHub history for details.
        final ClusterState state = clusterService.state();
        setState(
            expectSuccess(r -> {
        final Settings nodeSettings = nodeSettingsBuilder.build();
    }
            staticMaximum = MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING.get(Settings.EMPTY);
                    + "] which would exceed the maximum of ["
}
            localNode,
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.cluster.ClusterName;
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))
            expectSuccess(r -> {
import org.opensearch.cluster.node.DiscoveryNodeRole;
        final Throwable rootCause = exceptionHolder.get().getRootCause();
                assertNotNull(r);
 */
                countDownLatch.countDown();
import static org.hamcrest.Matchers.containsInAnyOrder;
        if (randomBoolean()) {
            ),
        assertThat(
        threadPool.shutdown();
                Strings.EMPTY_ARRAY,
package org.opensearch.action.admin.cluster.configuration;
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
                                CoordinationMetadata.builder(currentState.coordinationMetadata())
        final VotingConfiguration allNodesConfig = VotingConfiguration.of(localNode, otherNode1, otherNode2);
                    Metadata.builder()
    }
        clusterStateObserver.waitForNextChange(new AdjustConfigurationForExclusions(countDownLatch));
    public void testExcludeByNodeNameSucceedsEvenIfAllExclusionsAlreadyAdded() throws InterruptedException {
                countDownLatch.countDown();
    ) {
            name,
        final CountDownLatch countDownLatch = new CountDownLatch(2);
            rootCause.getMessage(),
 *
            new AddVotingConfigExclusionsRequest("absent_node"),
                    + existingCount
                countDownLatch.countDown();
import static org.hamcrest.Matchers.startsWith;
            expectError(e -> {
        );
        assertThat(clusterService.getClusterApplierService().state().getVotingConfigExclusions(), contains(otherNode1Exclusion));
        assertThat(
    public void testOnlyMatchesClusterManagerEligibleNodes() throws InterruptedException {
            transportService,
            AddVotingConfigExclusionsAction.NAME,
                    throw new AssertionError("unexpected failure", e);
        return responseHandler(r -> { assert false : r; }, onException);
        assertWarnings(AddVotingConfigExclusionsRequest.DEPRECATION_MESSAGE);
            throw new AssertionError("unexpected timeout");
    public void testWithdrawsVotesFromMultipleNodes() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
import org.opensearch.action.support.ActionFilters;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        );
 * not use this file except in compliance with the License.
        public void onNewClusterState(ClusterState state) {
            localNode,
    public void testExcludeExistingNodesByNodeNames() throws InterruptedException {
            NoopTracer.INSTANCE
                exceptionHolder.set(e);
        clusterStateObserver.waitForNextChange(new AdjustConfigurationForExclusions(countDownLatch));
            clusterService.getClusterApplierService().state().getVotingConfigExclusions(),
                }
        transportService.sendRequest(
            clusterService.getClusterManagerService().submitStateUpdateTask("reconfiguration", new ClusterStateUpdateTask() {
                    return builder(currentState).metadata(
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
                return new AddVotingConfigExclusionsResponse(in);
            AddVotingConfigExclusionsAction.NAME,
    }
        );
                Strings.EMPTY_ARRAY,
        }
            );
            localNode,
        final SetOnce<TransportException> exceptionHolder = new SetOnce<>();
    public void testExcludeAbsentNodesByNodeIds() throws InterruptedException {
            AddVotingConfigExclusionsAction.NAME,
        assertThat(
            new ActionFilters(emptySet()),
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        );
        otherNode2 = makeDiscoveryNode("other2");
                Strings.EMPTY_ARRAY,
 * SPDX-License-Identifier: Apache-2.0
                assertNotNull(r);
                TimeValue.timeValueMillis(100)
        }
        assertThat(rootCause, instanceOf(IllegalArgumentException.class));
import static org.hamcrest.Matchers.equalTo;
                }
            boundTransportAddress -> localNode,
    }
                    .coordinationMetadata(
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
            Metadata.builder(state.metadata())
 * Unless required by applicable law or agreed to in writing,
            })
        );
        final ClusterState.Builder builder = builder(clusterService.state()).metadata(metadataBuilder);
            localNode,
                onResponse.accept(response);
                Settings.builder()
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
        );
            })
            emptySet(),
                            .coordinationMetadata(
            public String executor() {
                    ).build();
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
        assertWarnings(AddVotingConfigExclusionsRequest.DEPRECATION_MESSAGE);
                Strings.EMPTY_ARRAY,
    public void testReturnsImmediatelyIfVoteAlreadyWithdrawn() throws InterruptedException {
            localNode,
        clusterStateObserver.waitForNextChange(new AdjustConfigurationForExclusions(countDownLatch));
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
            @Override
                assertNotNull(r);
import static java.util.Collections.emptyMap;
        AdjustConfigurationForExclusions(CountDownLatch latch) {
            })
            threadPool,
    }
                    .clusterManagerNodeId(localNode.getId())
            public AddVotingConfigExclusionsResponse read(StreamInput in) throws IOException {
        final ClusterState state = clusterService.state();
        otherNode2Exclusion = new VotingConfigExclusion(otherNode2);
        );
    private static DiscoveryNode makeDiscoveryNode(String name) {
public class TransportAddVotingConfigExclusionsActionTests extends OpenSearchTestCase {
            ),
        );
import org.opensearch.OpenSearchTimeoutException;
                    .build()
        assertThat(rootCause, instanceOf(IllegalArgumentException.class));
            existingCount = actualMaximum;
import static org.hamcrest.Matchers.sameInstance;
                @Override
            clusterService.getClusterApplierService().state().getVotingConfigExclusions(),
                    CoordinationMetadata.builder(state.coordinationMetadata()).addVotingConfigExclusion(otherNode1Exclusion).build()
        );
            makeRequestWithNodeDescriptions("_all", "cluster_manager:false"),
    }
            new AddVotingConfigExclusionsRequest(
            Metadata.builder(state.metadata())
            )
                    )
        assertThat(
import org.opensearch.threadpool.TestThreadPool;
                @Override
    }
        setState(
    }
    public void testSucceedsEvenIfAllExclusionsAlreadyAdded() throws InterruptedException {
            })
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.util.concurrent.ThreadContext;
            newCount = 2;
    }
    ) {
    private AddVotingConfigExclusionsRequest makeRequestWithNodeDescriptions(String... nodeDescriptions) {
                exceptionHolder.set(e);
            }
            AddVotingConfigExclusionsAction.NAME,
import static java.util.Collections.emptySet;
        assertThat(clusterService.getClusterApplierService().state().getVotingConfigExclusions(), contains(otherNode1Exclusion));
    private TransportResponseHandler<AddVotingConfigExclusionsResponse> responseHandler(
        } else {
 * under the License.
        );
import java.util.concurrent.CountDownLatch;
        assertWarnings(AddVotingConfigExclusionsRequest.DEPRECATION_MESSAGE);
                            .lastCommittedConfiguration(VotingConfiguration.of(localNode, otherNode2))
import org.opensearch.test.transport.MockTransport;
    private static ClusterService clusterService;
    public static void shutdownThreadPoolAndClusterService() {
            new AddVotingConfigExclusionsRequest(
        assertThat(
        transportService.sendRequest(
            })
        );
            expectSuccess(r -> {
        Consumer<TransportException> onException
        transportService.sendRequest(
    public void testExcludeAbsentNodesByNodeNames() throws InterruptedException {
                            .build()
        clusterStateObserver.waitForNextChange(new AdjustConfigurationForExclusions(countDownLatch));
                    CoordinationMetadata.builder(state.coordinationMetadata()).addVotingConfigExclusion(otherNode1Exclusion).build()
            localNode,
        );
    private TransportResponseHandler<AddVotingConfigExclusionsResponse> expectError(Consumer<TransportException> onException) {
                    .localNodeId(localNode.getId())
        final SetOnce<TransportException> exceptionHolder = new SetOnce<>();
        }
                new String[] { "absent_id" },
        clusterStateObserver.waitForNextChange(new AdjustConfigurationForExclusions(countDownLatch));
        );
        if (randomBoolean()) {
        final SetOnce<TransportException> exceptionHolder = new SetOnce<>();
        builder.metadata(
    public void testExcludeExistingNodesByNodeIds() throws InterruptedException {
        transportService.sendRequest(
 */
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        transportService.sendRequest(
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
        assertEquals(
            localNode,
        assertWarnings(AddVotingConfigExclusionsRequest.DEPRECATION_MESSAGE);
                assertNotNull(r);
        );
            })
        Consumer<AddVotingConfigExclusionsResponse> onResponse
                TimeValue.timeValueSeconds(30)
    }
        for (int i = 2; i < actualMaximum; i++) {
            })
import org.opensearch.cluster.metadata.Metadata;
            )
        }
                }
            expectSuccess(r -> {
        @Override
import java.util.Set;
            coordinationMetadataBuilder.addVotingConfigExclusion(
            })
    }
        metadataBuilder.coordinationMetadata(coordinationMetadataBuilder.build());
        );
            public void handleException(TransportException exp) {
        transportService.sendRequest(
                assertNotNull(r);
                Strings.EMPTY_ARRAY,
            containsInAnyOrder(otherNode1Exclusion, otherNode2Exclusion)
    private int staticMaximum;
 * You may obtain a copy of the License at
        clusterService.stop();
    public void testExcludeByNodeIdSucceedsEvenIfAllExclusionsAlreadyAdded() throws InterruptedException {
        transportService.sendRequest(
import org.opensearch.transport.TransportException;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
            buildNewFakeTransportAddress(),
import org.opensearch.cluster.coordination.CoordinationMetadata;
            localNode,
        transportService.sendRequest(
                .coordinationMetadata(
            clusterService.getClusterApplierService().state().getVotingConfigExclusions(),
            newCount = 1;
                        Metadata.builder(currentState.metadata())
                                    .lastCommittedConfiguration(votingConfiguration)
            AddVotingConfigExclusionsAction.NAME,
                                .lastAcceptedConfiguration(allNodesConfig)
        assertThat(
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
        );
        clusterStateObserver.waitForNextChange(new AdjustConfigurationForExclusions(countDownLatch));
        assertThat(rootCause, instanceOf(IllegalArgumentException.class));
            expectSuccess(r -> {
                return Names.SAME;
        Consumer<AddVotingConfigExclusionsResponse> onResponse,
            expectSuccess(r -> {
            new AddVotingConfigExclusionsRequest("other1"),
 * ownership. Elasticsearch licenses this file to you under
        transportService.sendRequest(
        final CountDownLatch countDownLatch = new CountDownLatch(1);
            builder(new ClusterName("cluster")).nodes(
        return new TransportResponseHandler<AddVotingConfigExclusionsResponse>() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
                assertNotNull(r);
        );
    public void testReturnsErrorIfNoMatchingNodeDescriptions() throws InterruptedException {
import org.opensearch.common.SetOnce;
import org.opensearch.cluster.ClusterStateUpdateTask;
import static org.hamcrest.Matchers.contains;
        final CountDownLatch countDownLatch = new CountDownLatch(2);
 * compatible open source license.
    }
            AddVotingConfigExclusionsAction.NAME,
                    .add(otherNode1)
                "add voting config exclusions request for [other*] would add ["
        assertThat(clusterService.getClusterApplierService().state().getVotingConfigExclusions(), contains(otherNode1Exclusion));
    public void testWithdrawsVotesFromNodesMatchingWildcard() throws InterruptedException {
                public void onFailure(String source, Exception e) {
        );
        }
        transportService.sendRequest(
 * specific language governing permissions and limitations
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
            nodeSettingsBuilder.put(MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING.getKey(), staticMaximum);
                countDownLatch.countDown();
                .coordinationMetadata(
            clusterService.state().coordinationMetadata()
            throw new AssertionError("unexpected close");
            Metadata.builder(state.metadata())
            equalTo(
            AddVotingConfigExclusionsAction.NAME,
                countDownLatch.countDown();
            public void handleResponse(AddVotingConfigExclusionsResponse response) {
    }
            AddVotingConfigExclusionsAction.NAME,
                new String[] { "other1" },
    public void testWithdrawsVotesFromAllClusterManagerEligibleNodes() throws InterruptedException {
import org.opensearch.transport.TransportService;
        final Throwable rootCause = exceptionHolder.get().getRootCause();
                countDownLatch.countDown();
            }
        threadPool = new TestThreadPool("test", Settings.EMPTY);
            Strings.EMPTY_ARRAY,
            staticMaximum = between(5, 15);
    public void testTimesOut() throws InterruptedException {
            AddVotingConfigExclusionsAction.NAME,
        transportService.sendRequest(
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                        )
            new AddVotingConfigExclusionsRequest(
            localNode,
            threadPool,
        transportService = transport.createTransportService(
    public void setupForTest() {
import static org.opensearch.test.ClusterServiceUtils.setState;
import static org.opensearch.action.admin.cluster.configuration.TransportAddVotingConfigExclusionsAction.MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING;
            @Override
 * this work for additional information regarding copyright
 */
        );
        clusterStateObserver = new ClusterStateObserver(clusterService, null, logger, threadPool.getThreadContext());
            }
            expectError(e -> {
    @Before
            equalTo("add voting config exclusions request for [_all, cluster_manager:false] matched no cluster-manager-eligible nodes")
        final Metadata.Builder metadataBuilder = Metadata.builder(clusterService.state().metadata());
import org.opensearch.cluster.ClusterStateObserver;
            AddVotingConfigExclusionsAction.NAME,
                .metadata(
            ),
            clusterService,
                )
                exceptionHolder.set(e);
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;
        setState(clusterService, builder);
/*
import org.junit.AfterClass;
            expectSuccess(r -> {
                countDownLatch.countDown();
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
            })
/*
            equalTo("add voting config exclusions request for [not-a-node] matched no cluster-manager-eligible nodes")
        } else {
    }
        );
        final Settings.Builder nodeSettingsBuilder = Settings.builder();
        final ClusterState.Builder builder = builder(state);
        );
            clusterService.getClusterApplierService().state().getVotingConfigExclusions()
                countDownLatch.countDown();
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
                    + "] set by [cluster.max_voting_config_exclusions]"
        final CountDownLatch countDownLatch = new CountDownLatch(2);
            localNode,
        final Throwable rootCause = exceptionHolder.get().getRootCause();
    }
    private static class AdjustConfigurationForExclusions implements Listener {
import static java.util.Collections.singleton;
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
            localNode,
 * Licensed to Elasticsearch under one or more contributor
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
                assertNotNull(r);
        );
        ).addVotingConfigExclusion(localNodeExclusion);
        );
    }
        return new DiscoveryNode(
            )
            })
        localNode = makeDiscoveryNode("local");
    public void testWithdrawsVoteFromANode() throws InterruptedException {
        return new AddVotingConfigExclusionsRequest(
                Strings.EMPTY_ARRAY,
    @BeforeClass
            })
            Version.CURRENT
            containsInAnyOrder(otherNode1Exclusion, otherNode2Exclusion)
            containsInAnyOrder(otherNode1Exclusion, otherNode2Exclusion)
        final CountDownLatch countDownLatch = new CountDownLatch(1);
                new Builder().add(localNode)
                assertNotNull(r);
            localNode,
        }
import java.util.function.Consumer;
import org.opensearch.transport.TransportResponseHandler;
        final ClusterState state = clusterService.state();
        assertThat(clusterService.getClusterApplierService().state().getVotingConfigExclusions(), contains(localNodeExclusion));
        otherNode1Exclusion = new VotingConfigExclusion(otherNode1);
        setState(clusterService, builder);
            localNode,
            AddVotingConfigExclusionsAction.NAME,
        @Override
        final int existingCount, newCount;
        otherDataNode = new DiscoveryNode("data", "data", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
                assertNotNull(r);
            clusterService,
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
            name,
    }
            containsInAnyOrder(localNodeExclusion, otherNode1Exclusion, otherNode2Exclusion)
        ); // registers action
        public void onClusterServiceClose() {
            clusterSettings,
        final ClusterState.Builder builder = builder(state);
        }
            localNode,
            expectError(e -> {
            Strings.EMPTY_ARRAY,
    public static void createThreadPoolAndClusterService() {
            emptyMap(),
            rootCause.getMessage(),
import org.opensearch.Version;
        assertWarnings(AddVotingConfigExclusionsRequest.DEPRECATION_MESSAGE);
                    doneLatch.countDown();
    }
            AddVotingConfigExclusionsAction.NAME,
        );
        setState(clusterService, builder);
import org.opensearch.common.settings.ClusterSettings;
        transportService.start();
                    currentState.nodes().forEach(n -> votingNodeIds.add(n.getId()));
                                    .lastAcceptedConfiguration(votingConfiguration)
            new AddVotingConfigExclusionsRequest("other1"),
        assertThat(clusterService.getClusterApplierService().state().getVotingConfigExclusions(), contains(otherNode1Exclusion));
        transportService.sendRequest(
                assertNotNull(r);
        );
        final MockTransport transport = new MockTransport();
    private static VotingConfigExclusion localNodeExclusion, otherNode1Exclusion, otherNode2Exclusion;
        assertThat(rootCause, instanceOf(OpenSearchTimeoutException.class));
            AddVotingConfigExclusionsAction.NAME,
                )
        new TransportAddVotingConfigExclusionsAction(
 * license agreements. See the NOTICE file distributed with
            ),
import org.opensearch.core.common.io.stream.StreamInput;
    }
    @AfterClass
        final CountDownLatch doneLatch;
                        .coordinationMetadata(
                countDownLatch.countDown();
                )
            makeRequestWithNodeDescriptions("_local"),
            expectSuccess(r -> {
import static org.hamcrest.Matchers.instanceOf;
import java.util.concurrent.TimeUnit;
            nodeDescriptions,
import org.opensearch.cluster.ClusterState;
            expectSuccess(r -> {
            expectError(e -> {
import org.opensearch.threadpool.ThreadPool.Names;
            this.doneLatch = latch;
                    final VotingConfiguration votingConfiguration = new VotingConfiguration(votingNodeIds);
            null,
import org.opensearch.threadpool.ThreadPool;
    public void testWithdrawsVoteFromLocalNode() throws InterruptedException {
        assertThat(rootCause.getMessage(), startsWith("timed out waiting for voting config exclusions [{other1}"));
                .coordinationMetadata(
                TimeValue.timeValueSeconds(30)
                    currentState.getVotingConfigExclusions().forEach(t -> votingNodeIds.remove(t.getNodeId()));
        if (randomBoolean()) {
        );
        final CountDownLatch countDownLatch = new CountDownLatch(1);
            }
                    CoordinationMetadata.builder(state.coordinationMetadata()).addVotingConfigExclusion(otherNode1Exclusion).build()
        transportService.sendRequest(
        transportService.sendRequest(
