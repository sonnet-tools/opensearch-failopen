        builder.nodes(DiscoveryNodes.builder(clusterService.state().nodes()).remove(otherNode1).remove(otherNode2));
    private TransportResponseHandler<ClearVotingConfigExclusionsResponse> responseHandler(
            boundTransportAddress -> localNode,
 * specific language governing permissions and limitations
    ) {
 *
import org.opensearch.transport.TransportResponseHandler;
            startsWith("timed out waiting for removal of nodes; if nodes should not be removed, set waitForRemoval to false. [")
 */
import org.opensearch.cluster.ClusterState;
            new Builder().add(localNode)
                responseHolder.set(r);
 * compatible open source license.
}
    public void setupForTest() {
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
        transportService = transport.createTransportService(
            emptySet(),
        final ClearVotingConfigExclusionsRequest clearVotingConfigExclusionsRequest = new ClearVotingConfigExclusionsRequest();
public class TransportClearVotingConfigExclusionsActionTests extends OpenSearchTestCase {
    }
                .add(otherNode2)
        return new TransportResponseHandler<ClearVotingConfigExclusionsResponse>() {
 *
        otherNode2Exclusion = new VotingConfigExclusion(otherNode2);
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))
    }
package org.opensearch.action.admin.cluster.configuration;
        new TransportClearVotingConfigExclusionsAction(
import org.junit.BeforeClass;
import org.junit.AfterClass;
            Metadata.builder()
        final MockTransport transport = new MockTransport();
            })
    public void testClearsVotingConfigExclusions() throws InterruptedException {
 * license agreements. See the NOTICE file distributed with
            rootCause.getMessage(),
        assertThat(rootCause, instanceOf(OpenSearchTimeoutException.class));
    private TransportResponseHandler<ClearVotingConfigExclusionsResponse> expectSuccess(
import java.util.concurrent.CountDownLatch;
            }
            clusterService.getClusterApplierService().state().getVotingConfigExclusions(),
                        .addVotingConfigExclusion(otherNode1Exclusion)
        Consumer<ClearVotingConfigExclusionsResponse> onResponse,
            }
        transportService.start();
 *    http://www.apache.org/licenses/LICENSE-2.0
        builder.metadata(
import org.opensearch.cluster.metadata.Metadata;
        final SetOnce<ClearVotingConfigExclusionsResponse> responseHolder = new SetOnce<>();
 * Licensed to Elasticsearch under one or more contributor
            @Override
        transportService.sendRequest(
        return responseHandler(r -> { assert false : r; }, onException);
                onResponse.accept(response);
            @Override
        final CountDownLatch countDownLatch = new CountDownLatch(1);
            NoopTracer.INSTANCE
        return responseHandler(onResponse, e -> { throw new AssertionError("unexpected", e); });
import static org.opensearch.test.ClusterServiceUtils.setState;
                .clusterManagerNodeId(localNode.getId())
                return new ClearVotingConfigExclusionsResponse(in);
            ClearVotingConfigExclusionsAction.NAME,
import java.util.function.Consumer;
                countDownLatch.countDown();
            new ClearVotingConfigExclusionsRequest(),
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
            }
import java.util.concurrent.TimeUnit;
    }
        otherNode1Exclusion = new VotingConfigExclusion(otherNode1);
 * under the License.
    @Before
            public ClearVotingConfigExclusionsResponse read(StreamInput in) throws IOException {
import static org.hamcrest.Matchers.empty;
            public String executor() {
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.cluster.node.DiscoveryNodes.Builder;
            clusterService,
    public void testSucceedsIfNodesAreRemovedWhileWaiting() throws InterruptedException {
 * ownership. Elasticsearch licenses this file to you under
        );
        clusterService.stop();
    private TransportService transportService;
        setState(clusterService, builder);
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    public static void shutdownThreadPoolAndClusterService() {
import org.opensearch.common.util.concurrent.ThreadContext;
            null,
        otherNode1 = new DiscoveryNode("other1", "other1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        assertNotNull(responseHolder.get());
        );
import java.io.IOException;
    @AfterClass
import org.opensearch.Version;
import org.junit.Before;
            localNode,
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.test.transport.MockTransport;
        otherNode2 = new DiscoveryNode("other2", "other2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        clearVotingConfigExclusionsRequest.setWaitForRemoval(false);
    }
            localNode,
 * KIND, either express or implied.  See the License for the
                countDownLatch.countDown();
            clearVotingConfigExclusionsRequest,
import org.opensearch.transport.TransportService;
            transportService,
        Consumer<TransportException> onException
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.OpenSearchTimeoutException;
import org.opensearch.transport.TransportException;
                .coordinationMetadata(
            Settings.EMPTY,
/*
 *
        final SetOnce<ClearVotingConfigExclusionsResponse> responseHolder = new SetOnce<>();
                return Names.SAME;
 * You may obtain a copy of the License at
        Consumer<ClearVotingConfigExclusionsResponse> onResponse
            localNode,
    public static void createThreadPoolAndClusterService() {
            }
            threadPool,
        ); // registers action
            expectError(e -> {
import static org.hamcrest.Matchers.instanceOf;
        );
            ClearVotingConfigExclusionsAction.NAME,
import org.opensearch.cluster.service.ClusterService;
    public void testTimesOutIfWaitingForNodesThatAreNotRemoved() throws InterruptedException {
 * software distributed under the License is distributed on an
            ClearVotingConfigExclusionsAction.NAME,
/*
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
        assertThat(
import org.opensearch.cluster.ClusterName;
 * The OpenSearch Contributors require contributions made to
    @BeforeClass
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        threadPool = new TestThreadPool("test", Settings.EMPTY);
    }
        assertThat(clusterService.getClusterApplierService().state().getVotingConfigExclusions(), empty());
    private static DiscoveryNode localNode, otherNode1, otherNode2;
        localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
        assertThat(clusterService.getClusterApplierService().state().getVotingConfigExclusions(), empty());
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;
            threadPool,
import static java.util.Collections.emptySet;
        final SetOnce<TransportException> responseHolder = new SetOnce<>();
            expectSuccess(r -> {
import org.opensearch.common.SetOnce;
    }
import static org.hamcrest.Matchers.containsInAnyOrder;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
/*
                        .addVotingConfigExclusion(otherNode2Exclusion)
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.common.settings.Settings;
                responseHolder.set(r);
                .add(otherNode1)
        final CountDownLatch countDownLatch = new CountDownLatch(1);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            containsInAnyOrder(otherNode1Exclusion, otherNode2Exclusion)
        final ClusterState.Builder builder = builder(clusterService.state());
import org.opensearch.threadpool.TestThreadPool;
        final Throwable rootCause = responseHolder.get().getRootCause();
import org.opensearch.core.common.io.stream.StreamInput;
        );
    private static ThreadPool threadPool;
 */
            })
            new ActionFilters(emptySet()),
        );
        transportService.sendRequest(
        );
            @Override
                    CoordinationMetadata.builder()
        final ClusterState.Builder builder = builder(new ClusterName("cluster")).nodes(
            @Override
            })
import static java.util.Collections.emptyMap;
                onException.accept(exp);
                .localNodeId(localNode.getId())
        final ClearVotingConfigExclusionsRequest clearVotingConfigExclusionsRequest = new ClearVotingConfigExclusionsRequest();
import org.opensearch.action.support.ActionFilters;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
                countDownLatch.countDown();
 * Unless required by applicable law or agreed to in writing,
            public void handleException(TransportException exp) {
        transportService.acceptIncomingRequests();
import org.opensearch.cluster.node.DiscoveryNode;
    }
                        .build()
        clusterService = createClusterService(threadPool, localNode);
import org.opensearch.cluster.coordination.CoordinationMetadata;
            expectSuccess(r -> {
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
        );
 * not use this file except in compliance with the License.
                )
import org.opensearch.common.unit.TimeValue;
        );
 * this file be licensed under the Apache-2.0 license or a
            clearVotingConfigExclusionsRequest,
 * this work for additional information regarding copyright
            public void handleResponse(ClearVotingConfigExclusionsResponse response) {
    private static ClusterService clusterService;
        threadPool.shutdown();
    private static VotingConfigExclusion otherNode1Exclusion, otherNode2Exclusion;
    }
        };
import static org.opensearch.cluster.ClusterState.builder;
    private TransportResponseHandler<ClearVotingConfigExclusionsResponse> expectError(Consumer<TransportException> onException) {
                responseHolder.set(e);
        setState(clusterService, builder);
 */
 * SPDX-License-Identifier: Apache-2.0
    ) {
    }
        transportService.sendRequest(
        assertThat(
import org.opensearch.threadpool.ThreadPool.Names;
import static org.hamcrest.Matchers.startsWith;
        clearVotingConfigExclusionsRequest.setTimeout(TimeValue.timeValueMillis(100));
