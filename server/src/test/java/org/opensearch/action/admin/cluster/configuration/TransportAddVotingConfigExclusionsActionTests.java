            localNode,
 * under the License.  
            existingCount = actualMaximum - 1;
    public void testExcludeAbsentNodesByNodeIds() throws InterruptedException {
                    currentState.getVotingConfigExclusions().forEach(t -> votingNodeIds.remove(t.getNodeId()));
import static org.hamcrest.Matchers.equalTo;
        clusterSettings = new ClusterSettings(nodeSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            newCount = 2;
            expectSuccess(r -> {
        transportService.sendRequest(
        );
        }  
            AddVotingConfigExclusionsAction.NAME,  
            clusterService.getClusterApplierService().state().getVotingConfigExclusions(),
            new AddVotingConfigExclusionsRequest(
    }  
        final ClusterState.Builder builder = builder(state);
        assertThat(rootCause, instanceOf(IllegalArgumentException.class));  
    }
        }
    private static ThreadPool threadPool;  
        assertThat(
            AddVotingConfigExclusionsAction.NAME,
        final CountDownLatch countDownLatch = new CountDownLatch(1);
                Metadata.builder(state.metadata())
            new AddVotingConfigExclusionsRequest("other1", "other2"),
        assertWarnings(AddVotingConfigExclusionsRequest.DEPRECATION_MESSAGE);
 * GitHub history for details.
import org.opensearch.cluster.node.DiscoveryNodeRole;
    public void testWithdrawsVotesFromMultipleNodes() throws InterruptedException {  
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))
        otherNode1Exclusion = new VotingConfigExclusion(otherNode1);
                assertNotNull(r);  
        );  
 * Licensed to Elasticsearch under one or more contributor  
                    .put(MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING.getKey(), actualMaximum)
            )  
        assertThat(
        builder.metadata(  
        otherNode2 = makeDiscoveryNode("other2");
            ),  
            localNode,  
        transportService.sendRequest(  
 * The OpenSearch Contributors require contributions made to  
        final Metadata.Builder metadataBuilder = Metadata.builder(clusterService.state().metadata());
            rootCause.getMessage(),  
        assertThat(clusterService.getClusterApplierService().state().getVotingConfigExclusions(), contains(otherNode1Exclusion));
        );  
                    .coordinationMetadata(  
        assertThat(clusterService.getClusterApplierService().state().getVotingConfigExclusions(), contains(otherNode1Exclusion));  
            new ActionFilters(emptySet()),  
            expectSuccess(e -> {  
            new AddVotingConfigExclusionsRequest("other1"),
            }
        transportService.sendRequest(
        transportService.sendRequest(  
                }
            Version.CURRENT  
            NoopTracer.INSTANCE
    public void setupForTest() {
import org.opensearch.threadpool.ThreadPool;
    public void testExcludeAbsentNodesByNodeNames() throws InterruptedException {
            AddVotingConfigExclusionsAction.NAME,
            Strings.EMPTY_ARRAY,
        final CountDownLatch countDownLatch = new CountDownLatch(1);  
                    Metadata.builder()
            }  
                    .add(otherNode1)
        final SetOnce<TransportException> exceptionHolder = new SetOnce<>();
                "add voting config exclusions request for [other*] would add ["
        assertThat(
        );  
            nodeSettingsBuilder.put(MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING.getKey(), staticMaximum);
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
            expectSuccess(r -> {
                new String[] { "absent_id" },
        final CountDownLatch countDownLatch = new CountDownLatch(2);  
        Consumer<TransportException> onException
    private int staticMaximum;
            expectSuccess(r -> {
            })
import org.opensearch.transport.TransportService;
            })  
        assertThat(
    }  
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
import org.opensearch.Version;
    public void testWithdrawsVotesFromAllClusterManagerEligibleNodes() throws InterruptedException {
                    + newCount  
import static org.opensearch.cluster.ClusterState.builder;  
        } else {  
            new AddVotingConfigExclusionsRequest("absent_node"),  
        // no observer to reconfigure
        );
        final CountDownLatch doneLatch;
                return new AddVotingConfigExclusionsResponse(in);
        final int existingCount, newCount;
        );  
        );  
                @Override
import static org.hamcrest.Matchers.containsInAnyOrder;
        );
            makeRequestWithNodeDescriptions("_all"),
    public void testWithdrawsVoteFromLocalNode() throws InterruptedException {
                exceptionHolder.set(e);
        assertThat(rootCause, instanceOf(IllegalArgumentException.class));
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
                    final VotingConfiguration votingConfiguration = new VotingConfiguration(votingNodeIds);
        );
            new AddVotingConfigExclusionsRequest("other1"),
                TimeValue.timeValueMillis(100)
                Strings.EMPTY_ARRAY,
                                .lastAcceptedConfiguration(allNodesConfig)
}
            throw new AssertionError("unexpected timeout");  
            nodeSettings,
        assertThat(clusterService.getClusterApplierService().state().getVotingConfigExclusions(), contains(otherNode1Exclusion));
    }
            })
            localNode,
        public void onTimeout(TimeValue timeout) {
                countDownLatch.countDown();
        } else {  
 * Modifications Copyright OpenSearch Contributors. See  
    }
            this.doneLatch = latch;
                Settings.builder()  
            singleton(new VotingConfigExclusion(VotingConfigExclusion.MISSING_VALUE_MARKER, "absent_node")),
        );
        transportService = transport.createTransportService(
        final SetOnce<TransportException> exceptionHolder = new SetOnce<>();
            new AddVotingConfigExclusionsRequest(  
    }
        );  
        );
import org.opensearch.cluster.ClusterStateObserver;
        final ClusterState state = clusterService.state();
    public void testExcludeByNodeIdSucceedsEvenIfAllExclusionsAlreadyAdded() throws InterruptedException {
            })
            builder(state).metadata(
    }
    }
            })
            AddVotingConfigExclusionsAction.NAME,  
        return responseHandler(onResponse, e -> { throw new AssertionError("unexpected", e); });
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
        }
    private ClusterSettings clusterSettings;
        final CountDownLatch countDownLatch = new CountDownLatch(1);  
        final ClusterState state = clusterService.state();
            makeRequestWithNodeDescriptions("not-a-node"),  
            clusterService.getClusterApplierService().state().getVotingConfigExclusions(),  
    public void testOnlyMatchesClusterManagerEligibleNodes() throws InterruptedException {
                    doneLatch.countDown();  
                        )
                            .coordinationMetadata(
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            localNode,
            transportService,  
                countDownLatch.countDown();
        assertThat(
        builder.metadata(
        );  
            equalTo("add voting config exclusions request for [_all, cluster_manager:false] matched no cluster-manager-eligible nodes")  
    }  
            emptySet(),
    }  
                countDownLatch.countDown();
        final ClusterState.Builder builder = builder(state);  
        assertWarnings(AddVotingConfigExclusionsRequest.DEPRECATION_MESSAGE);
            }
                }
        clusterStateObserver.waitForNextChange(new AdjustConfigurationForExclusions(countDownLatch));
    @AfterClass
                                CoordinationMetadata.builder(currentState.coordinationMetadata())  
    }
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
            clusterService,  
        Consumer<AddVotingConfigExclusionsResponse> onResponse,
            makeRequestWithNodeDescriptions("_local"),  
                @Override
import static org.hamcrest.Matchers.instanceOf;  
        );  
                TimeValue.timeValueSeconds(30)
import org.opensearch.transport.TransportResponseHandler;
    @Before
                        .coordinationMetadata(  
        );
            clusterSettings,
                    .put(clusterService.state().metadata().persistentSettings())
            clusterService.getClusterManagerService().submitStateUpdateTask("reconfiguration", new ClusterStateUpdateTask() {
        assertEquals(
    }  
        );
    private static VotingConfigExclusion localNodeExclusion, otherNode1Exclusion, otherNode2Exclusion;  
            })
 *
 * Unless required by applicable law or agreed to in writing,
        transportService.acceptIncomingRequests();
    public void testExcludeExistingNodesByNodeNames() throws InterruptedException {
        assertWarnings(AddVotingConfigExclusionsRequest.DEPRECATION_MESSAGE);
                        CoordinationMetadata.builder(state.coordinationMetadata())
            TimeValue.timeValueSeconds(30)  
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));  
        final ClusterState state = clusterService.state();
        clusterStateObserver = new ClusterStateObserver(clusterService, null, logger, threadPool.getThreadContext());  
        );
            AddVotingConfigExclusionsAction.NAME,
    public void testReturnsErrorIfMaximumExclusionCountExceeded() throws InterruptedException {  
        );
        clusterStateObserver.waitForNextChange(new AdjustConfigurationForExclusions(countDownLatch));
import java.util.function.Consumer;  
        assertThat(  
        if (randomBoolean()) {  
            AddVotingConfigExclusionsAction.NAME,  
            name,
                public void onFailure(String source, Exception e) {  
        final SetOnce<TransportException> exceptionHolder = new SetOnce<>();
                )
        );
                assertNotNull(r);  
        );  
 * not use this file except in compliance with the License.
    private TransportResponseHandler<AddVotingConfigExclusionsResponse> expectError(Consumer<TransportException> onException) {
                countDownLatch.countDown();
        clusterStateObserver.waitForNextChange(new AdjustConfigurationForExclusions(countDownLatch));
            localNode,  
 * You may obtain a copy of the License at  
import org.opensearch.common.settings.Settings;
        public void onNewClusterState(ClusterState state) {  
        @Override
        final CountDownLatch countDownLatch = new CountDownLatch(1);  
            Metadata.builder(state.metadata())
            actualMaximum = between(2, 15);
                countDownLatch.countDown();
            new AddVotingConfigExclusionsRequest("other1"),
            makeRequestWithNodeDescriptions("other*"),
        );
    private TransportService transportService;
    }
/*
            expectError(e -> {
        final VotingConfiguration allNodesConfig = VotingConfiguration.of(localNode, otherNode1, otherNode2);
        final Throwable rootCause = exceptionHolder.get().getRootCause();
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
                countDownLatch.countDown();  
                    final Set<String> votingNodeIds = new HashSet<>();
 * this file be licensed under the Apache-2.0 license or a
    private static class AdjustConfigurationForExclusions implements Listener {  
    }  
        ); // registers action
            ),
        transportService.sendRequest(  
import org.opensearch.common.unit.TimeValue;
        final Settings.Builder nodeSettingsBuilder = Settings.builder();
            });
            expectSuccess(r -> {
    }
                Strings.EMPTY_ARRAY,
        final CountDownLatch countDownLatch = new CountDownLatch(2);
                    )
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
            @Override
        transportService.sendRequest(
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            coordinationMetadataBuilder.addVotingConfigExclusion(otherNode1Exclusion);  
import org.opensearch.test.OpenSearchTestCase;
            boundTransportAddress -> localNode,
            public AddVotingConfigExclusionsResponse read(StreamInput in) throws IOException {  
import org.opensearch.cluster.ClusterStateObserver.Listener;  
import org.opensearch.threadpool.TestThreadPool;  
            localNode,
            emptyMap(),
import org.opensearch.common.settings.ClusterSettings;  
            AddVotingConfigExclusionsAction.NAME,  
            ),
import static java.util.Collections.emptyMap;
        CoordinationMetadata.Builder coordinationMetadataBuilder = CoordinationMetadata.builder(
    public void testExcludeByNodeNameSucceedsEvenIfAllExclusionsAlreadyAdded() throws InterruptedException {  
                            )
            expectError(e -> {
            })
            })  
        );
        final ClusterState state = clusterService.state();
                    CoordinationMetadata.builder(state.coordinationMetadata()).addVotingConfigExclusion(otherNode1Exclusion).build()
    ) {  
                countDownLatch.countDown();
            )  
        final Throwable rootCause = exceptionHolder.get().getRootCause();
            expectError(e -> {
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
        final CountDownLatch countDownLatch = new CountDownLatch(1);  
        final SetOnce<TransportException> exceptionHolder = new SetOnce<>();
        final CountDownLatch countDownLatch = new CountDownLatch(2);
            public void handleResponse(AddVotingConfigExclusionsResponse response) {  
                exceptionHolder.set(e);  
        ).addVotingConfigExclusion(localNodeExclusion);
            @Override
    public void testReturnsImmediatelyIfVoteAlreadyWithdrawn() throws InterruptedException {  
                Strings.EMPTY_ARRAY,  
import org.opensearch.cluster.coordination.CoordinationMetadata;
            new AddVotingConfigExclusionsRequest(  
        transportService.start();
import org.opensearch.cluster.node.DiscoveryNodes.Builder;  
 *  
            singleton(new VotingConfigExclusion("absent_id", VotingConfigExclusion.MISSING_VALUE_MARKER)),
        return responseHandler(r -> { assert false : r; }, onException);  
            expectSuccess(r -> {
    private TransportResponseHandler<AddVotingConfigExclusionsResponse> responseHandler(  
            new AddVotingConfigExclusionsRequest("other1"),  
 */  
public class TransportAddVotingConfigExclusionsActionTests extends OpenSearchTestCase {
    private ClusterStateObserver clusterStateObserver;  
            localNode,
                    + "] which would exceed the maximum of ["  
            new AddVotingConfigExclusionsRequest("other1", "other2"),
                    CoordinationMetadata.builder(state.coordinationMetadata()).addVotingConfigExclusion(otherNode1Exclusion).build()
            clusterService.getClusterApplierService().state().getVotingConfigExclusions()
        );  
import org.opensearch.common.SetOnce;
                countDownLatch.countDown();
        transportService.sendRequest(  
            ),
import java.util.Set;  
    private AddVotingConfigExclusionsRequest makeRequestWithNodeDescriptions(String... nodeDescriptions) {
            Metadata.builder(state.metadata())
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        final Throwable rootCause = exceptionHolder.get().getRootCause();
        clusterStateObserver.waitForNextChange(new AdjustConfigurationForExclusions(countDownLatch));
        final CountDownLatch countDownLatch = new CountDownLatch(1);  
        );  
                    + existingCount
            AddVotingConfigExclusionsAction.NAME,  
            @Override  
            coordinationMetadataBuilder.addVotingConfigExclusion(
import static java.util.Collections.singleton;
import org.junit.AfterClass;  
        transportService.sendRequest(
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        );
                countDownLatch.countDown();
    }
            new AddVotingConfigExclusionsRequest(
                    .clusterManagerNodeId(localNode.getId())
            buildNewFakeTransportAddress(),  
        setState(clusterService, builder);
import static org.hamcrest.Matchers.contains;  
                exceptionHolder.set(e);
        clusterStateObserver.waitForNextChange(new AdjustConfigurationForExclusions(countDownLatch));  
/*  
        metadataBuilder.coordinationMetadata(coordinationMetadataBuilder.build());
import java.io.IOException;
            Metadata.builder(state.metadata())
        };  
        transportService.sendRequest(
    }
            expectError(e -> {  
        );
import org.opensearch.cluster.node.DiscoveryNode;
        );
        @Override
        final CountDownLatch countDownLatch = new CountDownLatch(2);  
        final CountDownLatch countDownLatch = new CountDownLatch(2);
            clusterService.getClusterApplierService().state().getVotingConfigExclusions()  
                onException.accept(exp);  
                assertNotNull(r);  
import static org.opensearch.action.admin.cluster.configuration.TransportAddVotingConfigExclusionsAction.MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING;
import org.opensearch.common.util.concurrent.ThreadContext;  
            })
        localNode = makeDiscoveryNode("local");
    public void testExcludeExistingNodesByNodeIds() throws InterruptedException {  
        }
import org.opensearch.test.transport.MockTransport;
            localNode,
        assertThat(clusterService.getClusterApplierService().state().getVotingConfigExclusions(), contains(otherNode1Exclusion));  
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));  
                exceptionHolder.set(e);
                                .build()
                TimeValue.timeValueSeconds(30)  
                    assertThat(currentState, sameInstance(state));
 * the Apache License, Version 2.0 (the "License"); you may
        final int actualMaximum;  
            builder(new ClusterName("cluster")).nodes(
            makeRequestWithNodeDescriptions("_all", "cluster_manager:false"),  
        clusterStateObserver.waitForNextChange(new AdjustConfigurationForExclusions(countDownLatch));  
        assertWarnings(AddVotingConfigExclusionsRequest.DEPRECATION_MESSAGE);
        clusterService.stop();  
            AddVotingConfigExclusionsAction.NAME,
                    + actualMaximum
    }
                countDownLatch.countDown();
                )
        assertThat(rootCause, instanceOf(OpenSearchTimeoutException.class));
                countDownLatch.countDown();
            clusterSettings.applySettings(
        );  
                )
        setState(clusterService, builder);
            Settings.EMPTY,
            threadPool,  
        assertWarnings(AddVotingConfigExclusionsRequest.DEPRECATION_MESSAGE);
                    .localNodeId(localNode.getId())
    }
                Strings.EMPTY_ARRAY,  
        clusterService = createClusterService(threadPool, localNode);
            clusterService,
                TimeValue.timeValueSeconds(30)
        final CountDownLatch countDownLatch = new CountDownLatch(1);  
    @BeforeClass
            AddVotingConfigExclusionsAction.NAME,
            })  
        otherNode2Exclusion = new VotingConfigExclusion(otherNode2);  
        assertEquals(  
            expectSuccess(r -> {
            localNode,
            name,
            rootCause.getMessage(),
import static org.hamcrest.Matchers.sameInstance;
            AddVotingConfigExclusionsAction.NAME,
        transportService.sendRequest(
        assertThat(
                assertNotNull(r);
            Strings.EMPTY_ARRAY,
                    return builder(currentState).metadata(  
            containsInAnyOrder(otherNode1Exclusion, otherNode2Exclusion)
        final Settings nodeSettings = nodeSettingsBuilder.build();  
    }
import org.opensearch.OpenSearchTimeoutException;  
/*
                Strings.EMPTY_ARRAY,
        setState(
            rootCause.getMessage(),
        assertThat(clusterService.getClusterApplierService().state().getVotingConfigExclusions(), contains(otherNode1Exclusion));  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            })
        threadPool = new TestThreadPool("test", Settings.EMPTY);  
                    ).build();
    }  
import org.opensearch.action.support.ActionFilters;
        threadPool.shutdown();
            containsInAnyOrder(otherNode1Exclusion, otherNode2Exclusion)  
            localNode,
                .coordinationMetadata(
            threadPool,
        assertThat(rootCause.getMessage(), startsWith("timed out waiting for voting config exclusions [{other1}"));  
        final Throwable rootCause = exceptionHolder.get().getRootCause();  
            throw new AssertionError("unexpected close");
        transportService.sendRequest(  
                assertNotNull(r);
import static java.util.Collections.emptySet;  
                    + "] set by [cluster.max_voting_config_exclusions]"
            AddVotingConfigExclusionsAction.NAME,  
            localNode,
        assertThat(clusterService.getClusterApplierService().state().getVotingConfigExclusions(), contains(localNodeExclusion));
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));  
        transportService.sendRequest(  
import org.junit.BeforeClass;
        if (randomBoolean()) {
            })  
            clusterService.getClusterApplierService().state().getVotingConfigExclusions(),
                            .lastCommittedConfiguration(VotingConfiguration.of(localNode, otherNode2))
            })  
            expectSuccess(r -> {  
 */
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
        transportService.sendRequest(
                Strings.EMPTY_ARRAY,
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;  
            AddVotingConfigExclusionsAction.NAME,
                new Builder().add(localNode)  
    }
        );
        transportService.sendRequest(
                }  
                countDownLatch.countDown();  
                return Names.SAME;
        final CountDownLatch countDownLatch = new CountDownLatch(2);  
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));  
                                    .build()  
        clusterStateObserver.waitForNextChange(new AdjustConfigurationForExclusions(countDownLatch));
                new String[] { "other1" },
    }  
        otherDataNode = new DiscoveryNode("data", "data", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
import java.util.concurrent.TimeUnit;
        );  
            localNode,
        assertThat(rootCause, instanceOf(IllegalArgumentException.class));  
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
    private static DiscoveryNode localNode, otherNode1, otherNode2, otherDataNode;
import org.junit.Before;
            makeRequestWithNodeDescriptions("other*"),
                new String[] { "other1", "other2" },  
            clusterService.getClusterApplierService().state().getVotingConfigExclusions(),
        setState(  
import static org.opensearch.test.ClusterServiceUtils.setState;
        }  
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
                            .lastAcceptedConfiguration(VotingConfiguration.of(localNode, otherNode2))  
        }  
                assertNotNull(r);
        final ClusterState.Builder builder = builder(state);  
    public void testSucceedsEvenIfAllExclusionsAlreadyAdded() throws InterruptedException {
                )  
        final CountDownLatch countDownLatch = new CountDownLatch(2);
                .coordinationMetadata(  
    private TransportResponseHandler<AddVotingConfigExclusionsResponse> expectSuccess(
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
                Strings.EMPTY_ARRAY,  
        if (randomBoolean()) {
import static org.hamcrest.Matchers.startsWith;
 * compatible open source license.
                    throw new AssertionError("unexpected failure", e);
    public void testWithdrawsVotesFromNodesMatchingWildcard() throws InterruptedException {  
            expectSuccess(r -> {  
            })
                .metadata(
 * ownership. Elasticsearch licenses this file to you under  
            null,  
            localNode,  
                            .build()
    private static DiscoveryNode makeDiscoveryNode(String name) {
                countDownLatch.countDown();  
        final CountDownLatch countDownLatch = new CountDownLatch(1);
                .coordinationMetadata(  
import org.opensearch.core.common.Strings;
            nodeDescriptions,  
        transportService.sendRequest(
        }
                public ClusterState execute(ClusterState currentState) {  
import java.util.concurrent.CountDownLatch;
            AddVotingConfigExclusionsAction.NAME,
        Consumer<AddVotingConfigExclusionsResponse> onResponse  
            public void handleException(TransportException exp) {
            AddVotingConfigExclusionsAction.NAME,
            expectSuccess(r -> {  
        AdjustConfigurationForExclusions(CountDownLatch latch) {
import org.opensearch.transport.TransportException;  
        return new DiscoveryNode(  
            )  
 */
                @Override
            @Override
        );
        clusterStateObserver.waitForNextChange(new AdjustConfigurationForExclusions(countDownLatch));  
                countDownLatch.countDown();
            actualMaximum = staticMaximum;
    public void testReturnsErrorIfNoMatchingNodeDescriptions() throws InterruptedException {
                            CoordinationMetadata.builder()
                assertNotNull(r);  
import org.opensearch.cluster.ClusterStateUpdateTask;
            );
        assertWarnings(AddVotingConfigExclusionsRequest.DEPRECATION_MESSAGE);  
import org.opensearch.cluster.metadata.Metadata;  
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
                    CoordinationMetadata.builder(state.coordinationMetadata()).addVotingConfigExclusion(otherNode1Exclusion).build()  
            expectSuccess(r -> {
                new String[] { "other1" },
        final ClusterState.Builder builder = builder(clusterService.state()).metadata(metadataBuilder);
            );
        transportService.sendRequest(
            AddVotingConfigExclusionsAction.NAME,
                        Metadata.builder(currentState.metadata())
        );
 * specific language governing permissions and limitations
    public static void createThreadPoolAndClusterService() {
        assertWarnings(AddVotingConfigExclusionsRequest.DEPRECATION_MESSAGE);
        otherNode1 = makeDiscoveryNode("other1");  
                new VotingConfigExclusion(randomAlphaOfLength(10), randomAlphaOfLength(10))  
        final MockTransport transport = new MockTransport();  
        setState(clusterService, builder);  
            staticMaximum = MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING.get(Settings.EMPTY);
    public void testTimesOut() throws InterruptedException {
            localNode,
            public String executor() {
            clusterService.state().coordinationMetadata()  
                assertNotNull(r);
        builder.metadata(
        );
 * KIND, either express or implied.  See the License for the
                onResponse.accept(response);
package org.opensearch.action.admin.cluster.configuration;
                                .lastCommittedConfiguration(allNodesConfig)  
        transportService.sendRequest(  
import java.util.HashSet;
            }
        for (int i = 2; i < actualMaximum; i++) {
                    .add(otherDataNode)  
            })
    private static ClusterService clusterService;
                                    .lastCommittedConfiguration(votingConfiguration)
import org.opensearch.threadpool.ThreadPool.Names;
            localNode,  
                countDownLatch.countDown();
 *
            equalTo(
import org.opensearch.core.common.io.stream.StreamInput;
                assertNotNull(r);
        clusterStateObserver.waitForNextChange(new AdjustConfigurationForExclusions(countDownLatch));  
    }
                countDownLatch.countDown();  
            existingCount = actualMaximum;
        } else {  
import org.opensearch.cluster.service.ClusterService;
        assertThat(  
                assertNotNull(r);  
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
            })
        public void onClusterServiceClose() {  
    public static void shutdownThreadPoolAndClusterService() {
                Strings.EMPTY_ARRAY,
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));  
            clusterService.getClusterApplierService().state().getVotingConfigExclusions(),
            containsInAnyOrder(otherNode1Exclusion, otherNode2Exclusion)
            containsInAnyOrder(otherNode1Exclusion, otherNode2Exclusion)
        );
                    currentState.nodes().forEach(n -> votingNodeIds.add(n.getId()));  
 * software distributed under the License is distributed on an
            localNode,
            newCount = 1;
 * SPDX-License-Identifier: Apache-2.0
        new TransportAddVotingConfigExclusionsAction(  
        return new AddVotingConfigExclusionsRequest(
        setState(clusterService, builder);
            })
        @Override
                assertNotNull(r);
                countDownLatch.countDown();  
            staticMaximum = between(5, 15);
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
            clusterService,
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
            localNode,
            expectSuccess(e -> {
            containsInAnyOrder(localNodeExclusion, otherNode1Exclusion, otherNode2Exclusion)  
    }
                                    .lastAcceptedConfiguration(votingConfiguration)
import org.opensearch.cluster.ClusterName;  
    public void testWithdrawsVoteFromANode() throws InterruptedException {  
            equalTo("add voting config exclusions request for [not-a-node] matched no cluster-manager-eligible nodes")  
                    + "] exclusions to the existing ["
        );
        localNodeExclusion = new VotingConfigExclusion(localNode);
        }
    ) {
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
                    .build()  
            expectSuccess(r -> {
import org.opensearch.cluster.ClusterState;
        return new TransportResponseHandler<AddVotingConfigExclusionsResponse>() {
            AddVotingConfigExclusionsAction.NAME,
                    .add(otherNode2)
