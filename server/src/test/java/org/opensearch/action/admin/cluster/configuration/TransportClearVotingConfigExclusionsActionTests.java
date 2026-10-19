 * GitHub history for details.
import org.junit.BeforeClass;
    @Before  
        final CountDownLatch countDownLatch = new CountDownLatch(1);
                onResponse.accept(response);  
                        .addVotingConfigExclusion(otherNode1Exclusion)
 */  
        otherNode1Exclusion = new VotingConfigExclusion(otherNode1);  
 * You may obtain a copy of the License at  
    }
/*
    }
            threadPool,
        assertThat(clusterService.getClusterApplierService().state().getVotingConfigExclusions(), empty());
                        .build()
            }
    private TransportResponseHandler<ClearVotingConfigExclusionsResponse> responseHandler(
    }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;
            expectError(e -> {
import org.opensearch.transport.TransportResponseHandler;
            Metadata.builder()
    private static DiscoveryNode localNode, otherNode1, otherNode2;
 * this file be licensed under the Apache-2.0 license or a
            null,
        threadPool.shutdown();  
import org.opensearch.threadpool.ThreadPool.Names;
        );
            localNode,
        final MockTransport transport = new MockTransport();
        threadPool = new TestThreadPool("test", Settings.EMPTY);  
                onException.accept(exp);
 *
            rootCause.getMessage(),
    private static VotingConfigExclusion otherNode1Exclusion, otherNode2Exclusion;  
 * under the License.  
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;  
import org.opensearch.cluster.ClusterName;  
            containsInAnyOrder(otherNode1Exclusion, otherNode2Exclusion)
            new ActionFilters(emptySet()),
    private TransportResponseHandler<ClearVotingConfigExclusionsResponse> expectSuccess(
    public void testClearsVotingConfigExclusions() throws InterruptedException {
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))  
import static org.hamcrest.Matchers.containsInAnyOrder;
        localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
        );  
import static org.opensearch.test.ClusterServiceUtils.setState;
        );  
    private static ThreadPool threadPool;  
    ) {
            @Override
import org.opensearch.transport.TransportService;
    public void testSucceedsIfNodesAreRemovedWhileWaiting() throws InterruptedException {  
 * Unless required by applicable law or agreed to in writing,
        Consumer<ClearVotingConfigExclusionsResponse> onResponse
            clusterService.getClusterApplierService().state().getVotingConfigExclusions(),
import org.opensearch.threadpool.TestThreadPool;  
    private static ClusterService clusterService;
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
        return responseHandler(r -> { assert false : r; }, onException);
 * not use this file except in compliance with the License.
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
import static java.util.Collections.emptySet;
    private TransportService transportService;
import java.util.concurrent.CountDownLatch;
                countDownLatch.countDown();
        );  
            }  
import static java.util.Collections.emptyMap;  
            clearVotingConfigExclusionsRequest,
}
            ClearVotingConfigExclusionsAction.NAME,  
        transportService.sendRequest(
    }
import org.junit.AfterClass;  
        transportService.acceptIncomingRequests();
                return Names.SAME;
 * the Apache License, Version 2.0 (the "License"); you may
    }  
import org.opensearch.cluster.metadata.Metadata;
        final ClusterState.Builder builder = builder(new ClusterName("cluster")).nodes(  
        };
    }
            public String executor() {  
import static org.hamcrest.Matchers.instanceOf;
            public void handleException(TransportException exp) {
/*  
import static org.opensearch.test.ClusterServiceUtils.createClusterService;  
        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));  
import org.opensearch.cluster.node.DiscoveryNodes;
import static org.hamcrest.Matchers.startsWith;
        return new TransportResponseHandler<ClearVotingConfigExclusionsResponse>() {  
        );  
 * ownership. Elasticsearch licenses this file to you under  
        clearVotingConfigExclusionsRequest.setWaitForRemoval(false);  
            })
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        transportService.sendRequest(
            }
                )
        clearVotingConfigExclusionsRequest.setTimeout(TimeValue.timeValueMillis(100));  
            })
        ); // registers action
 *  
        new TransportClearVotingConfigExclusionsAction(
 *    http://www.apache.org/licenses/LICENSE-2.0
                .clusterManagerNodeId(localNode.getId())
    public void setupForTest() {
import org.opensearch.OpenSearchTimeoutException;  
        assertThat(clusterService.getClusterApplierService().state().getVotingConfigExclusions(), empty());
    public void testTimesOutIfWaitingForNodesThatAreNotRemoved() throws InterruptedException {
import org.opensearch.Version;
            boundTransportAddress -> localNode,
                .localNodeId(localNode.getId())
                .coordinationMetadata(  
            @Override  
    ) {  
    @AfterClass  
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
        setState(clusterService, builder);
/*
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 * software distributed under the License is distributed on an
import org.opensearch.cluster.node.DiscoveryNode;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                .add(otherNode1)
            threadPool,
        otherNode2Exclusion = new VotingConfigExclusion(otherNode2);
    @BeforeClass
import org.opensearch.cluster.service.ClusterService;  
        final ClusterState.Builder builder = builder(clusterService.state());
        final ClearVotingConfigExclusionsRequest clearVotingConfigExclusionsRequest = new ClearVotingConfigExclusionsRequest();
        assertNotNull(responseHolder.get());  
                return new ClearVotingConfigExclusionsResponse(in);  
        clusterService.stop();
import org.junit.Before;
                .add(otherNode2)  
                responseHolder.set(e);  
        Consumer<TransportException> onException
import org.opensearch.test.transport.MockTransport;
import static org.opensearch.cluster.ClusterState.builder;
            localNode,
        transportService.start();  
                countDownLatch.countDown();
            public void handleResponse(ClearVotingConfigExclusionsResponse response) {
            new ClearVotingConfigExclusionsRequest(),
 * license agreements. See the NOTICE file distributed with
    }  
            clearVotingConfigExclusionsRequest,
import java.util.concurrent.TimeUnit;  
    public static void createThreadPoolAndClusterService() {
        transportService = transport.createTransportService(  
    public static void shutdownThreadPoolAndClusterService() {
        final Throwable rootCause = responseHolder.get().getRootCause();
            expectSuccess(r -> {
 * KIND, either express or implied.  See the License for the
            clusterService,  
import org.opensearch.threadpool.ThreadPool;
            expectSuccess(r -> {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
    }
        );  
                        .addVotingConfigExclusion(otherNode2Exclusion)  
import org.opensearch.common.util.concurrent.ThreadContext;
        final SetOnce<ClearVotingConfigExclusionsResponse> responseHolder = new SetOnce<>();  
import org.opensearch.cluster.coordination.CoordinationMetadata;
import org.opensearch.core.common.io.stream.StreamInput;
        clusterService = createClusterService(threadPool, localNode);  
        transportService.sendRequest(
import org.opensearch.common.SetOnce;
            ClearVotingConfigExclusionsAction.NAME,  
            startsWith("timed out waiting for removal of nodes; if nodes should not be removed, set waitForRemoval to false. [")
        otherNode2 = new DiscoveryNode("other2", "other2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
            })
            transportService,
        return responseHandler(onResponse, e -> { throw new AssertionError("unexpected", e); });
        );  
import static org.hamcrest.Matchers.empty;  
            emptySet(),  
        builder.metadata(
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See  
            public ClearVotingConfigExclusionsResponse read(StreamInput in) throws IOException {
 */
                    CoordinationMetadata.builder()
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
                countDownLatch.countDown();
        setState(clusterService, builder);
            Settings.EMPTY,
        final SetOnce<ClearVotingConfigExclusionsResponse> responseHolder = new SetOnce<>();
import org.opensearch.test.OpenSearchTestCase;
 */
            localNode,
package org.opensearch.action.admin.cluster.configuration;
        otherNode1 = new DiscoveryNode("other1", "other1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
        Consumer<ClearVotingConfigExclusionsResponse> onResponse,  
 * this work for additional information regarding copyright
    private TransportResponseHandler<ClearVotingConfigExclusionsResponse> expectError(Consumer<TransportException> onException) {
                responseHolder.set(r);  
            new Builder().add(localNode)
        assertThat(  
import org.opensearch.cluster.ClusterState;
                responseHolder.set(r);  
        final SetOnce<TransportException> responseHolder = new SetOnce<>();  
        );  
        assertThat(  
import org.opensearch.common.unit.TimeValue;  
 * compatible open source license.
            @Override
 * Licensed to Elasticsearch under one or more contributor  
public class TransportClearVotingConfigExclusionsActionTests extends OpenSearchTestCase {
            ClearVotingConfigExclusionsAction.NAME,  
        builder.nodes(DiscoveryNodes.builder(clusterService.state().nodes()).remove(otherNode1).remove(otherNode2));  
            NoopTracer.INSTANCE
            @Override
import org.opensearch.transport.TransportException;  
    }
import org.opensearch.cluster.node.DiscoveryNodes.Builder;
        assertThat(rootCause, instanceOf(OpenSearchTimeoutException.class));
        final ClearVotingConfigExclusionsRequest clearVotingConfigExclusionsRequest = new ClearVotingConfigExclusionsRequest();
import org.opensearch.action.support.ActionFilters;
            }
import java.util.function.Consumer;
 *
