import org.opensearch.Version;
        // no more transport calls
            new GetMappingsRequest(),
            .blocks(builder)
    private DiscoveryNode[] allNodes;
    public void setUp() throws Exception {
            emptySet(),
    @Before
    public void testGetTransportWithoutMatchingTerm() {
    private final String indexName = "test_index";
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
 * The OpenSearch Contributors require contributions made to
        capturingTransport.handleResponse(capturedRequest.requestId, termResp);
 * Unless required by applicable law or agreed to in writing,
                clusterService.state().metadata().clusterUUID(),
 * not use this file except in compliance with the License.
            GetMappingsActionTests.this.clusterService,
import org.opensearch.common.util.concurrent.ThreadContext;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            Collections.emptyMap(),
import org.opensearch.threadpool.ThreadPool;
            mock(IndicesService.class)
        ClusterState metadataReadBlockedState = ClusterState.builder(ClusterStateCreationUtils.state(localNode, remoteNode, allNodes))
 *    http://www.apache.org/licenses/LICENSE-2.0
        CapturingTransport.CapturedRequest capturedRequest = capturingTransport.capturedRequests()[0];
import org.opensearch.cluster.ClusterState;
                clusterService.state().version()
        capturingTransport.handleResponse(capturedRequest.requestId, termResp);
            EnumSet.of(ClusterBlockLevel.METADATA_READ)
import java.util.Collections;
            1,
    }
            buildNewFakeTransportAddress(),
        setState(clusterService, metadataReadBlockedState);
    private ThreadPool threadPool;
            )
                clusterService.state().metadata().clusterUUID(),
        );
 */
 */
        transportService.acceptIncomingRequests();
                clusterService.state().term() - 1,
/*
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
                clusterService.state().term(),
import java.util.EnumSet;
import org.opensearch.indices.IndicesService;
            NoopTracer.INSTANCE
import static java.util.Collections.emptySet;
import org.opensearch.cluster.service.ClusterService;
import org.junit.Before;
import org.opensearch.common.settings.SettingsModule;
        );
import org.opensearch.action.support.ActionFilters;
            new ClusterStateTermVersion(
                clusterService.state().metadata().clusterUUID(),
import org.opensearch.common.settings.SettingsFilter;
    }
            new ActionFilters(emptySet()),
        );
    private TransportService transportService;
        capturingTransport.handleResponse(capturedRequest.requestId, termResp);
/*
    private TransportGetMappingsAction transportAction = null;
    @After
        GetTermVersionResponse termResp = new GetTermVersionResponse(
 *
            Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.transport.CapturingTransport;
 * KIND, either express or implied.  See the License for the
        settingsFilter = new SettingsModule(Settings.EMPTY, emptyList(), emptyList(), emptySet()).getSettingsFilter();
        assertThat(capturingTransport.capturedRequests().length, equalTo(2));
import org.opensearch.core.action.ActionListener;
        ClusterBlock readClusterBlock = new ClusterBlock(
        GetTermVersionResponse termResp = new GetTermVersionResponse(
import org.opensearch.cluster.block.ClusterBlocks;
            buildNewFakeTransportAddress(),
    CapturingTransport capturingTransport = new CapturingTransport();
 * this work for additional information regarding copyright
    public void testGetTransportClusterBlockWithMatchingTerm() {
import org.opensearch.action.support.clustermanager.term.GetTermVersionResponse;
import java.util.HashMap;
    private DiscoveryNode remoteNode;
        );
        allNodes = new DiscoveryNode[] { localNode, remoteNode };
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.test.ClusterServiceUtils.setState;
        assertThat(capturingTransport.capturedRequests().length, equalTo(1));
        transportAction.execute(null, new GetMappingsRequest(), ActionListener.wrap(Assert::assertNotNull, exception -> {
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        super.tearDown();
            GetMappingsActionTests.this.transportService,
 * SPDX-License-Identifier: Apache-2.0
        CapturingTransport.CapturedRequest capturedRequest = capturingTransport.capturedRequests()[0];
import org.opensearch.cluster.node.DiscoveryNode;
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
    }
        threadPool = new TestThreadPool("GetIndexActionTests");
}
public class GetMappingsActionTests extends OpenSearchTestCase {
            "local_node",
        }));
        clusterService.close();
            throw new AssertionError(exception);
                clusterService.state().getClusterName(),
 * You may obtain a copy of the License at
            new ClusterStateTermVersion(
                clusterService.state().version()
        );
    private ClusterService clusterService;
        assertThat(capturingTransport.capturedRequests().length, equalTo(1));
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
    private SettingsFilter settingsFilter;
        ClusterBlocks.Builder builder = ClusterBlocks.builder();
                clusterService.state().getClusterName(),
    private DiscoveryNode localNode;
        remoteNode = new DiscoveryNode(
import org.opensearch.cluster.node.DiscoveryNodeRole;
 *
        transportService.close();
            true,
            new ClusterStateTermVersion(
    public void tearDown() throws Exception {
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
        setState(clusterService, ClusterStateCreationUtils.state(localNode, remoteNode, allNodes));
    }
        assertThat(capturingTransport.capturedRequests().length, equalTo(1));
            boundAddress -> clusterService.localNode(),
        transportService = capturingTransport.createTransportService(
import org.opensearch.test.OpenSearchTestCase;
        );
        builder.addGlobalBlock(readClusterBlock);
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            ActionListener.wrap(response -> { throw new AssertionError(response); }, exception -> {
import org.junit.Assert;
            false,
            })
import org.opensearch.core.rest.RestStatus;
            "",
 * specific language governing permissions and limitations
            Version.CURRENT
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            threadPool,
    }
        );
        CapturingTransport.CapturedRequest capturedRequest = capturingTransport.capturedRequests()[0];
            Version.CURRENT
            RestStatus.OK,
            throw new AssertionError(exception);
            "uuid",
import org.opensearch.threadpool.TestThreadPool;
 * Licensed to Elasticsearch under one or more contributor
        CapturingTransport.CapturedRequest capturedRequest1 = capturingTransport.capturedRequests()[1];
            GetMappingsActionTests.this.threadPool,
 */
import static java.util.Collections.emptyList;
                clusterService.state().version() - 1
import org.opensearch.transport.TransportService;
        clusterService = createClusterService(threadPool);
 * compatible open source license.
/*
import org.opensearch.cluster.block.ClusterBlockException;
package org.opensearch.action.admin.indices.mapping.get;
        }));
            null,
 * under the License.
import org.opensearch.common.settings.Settings;
            )
        transportService.start();
            )
            "remote_node",
                Assert.assertTrue(exception instanceof ClusterBlockException);
import java.util.concurrent.TimeUnit;
import org.opensearch.cluster.coordination.ClusterStateTermVersion;
 * software distributed under the License is distributed on an
        capturingTransport.handleResponse(capturedRequest1.requestId, new GetMappingsResponse(new HashMap<>()));
import static org.hamcrest.Matchers.equalTo;
 *
        );
        localNode = new DiscoveryNode(
        assertThat(capturingTransport.capturedRequests().length, equalTo(1));
 * license agreements. See the NOTICE file distributed with
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
        assertThat(capturingTransport.capturedRequests().length, equalTo(1));
        transportAction = new TransportGetMappingsAction(
            clusterService.getSettings(),
import org.opensearch.cluster.block.ClusterBlock;
            .build();
import org.junit.After;
import org.opensearch.cluster.block.ClusterBlockLevel;
            null,
import static org.mockito.Mockito.mock;
        transportAction.execute(
                clusterService.state().term(),
        transportAction.execute(null, new GetMappingsRequest(), ActionListener.wrap(Assert::assertNotNull, exception -> {
        // no more transport calls
        // mismatch term and version
    public void testGetTransportWithMatchingTerm() {
            true,
            Collections.emptyMap(),
        GetTermVersionResponse termResp = new GetTermVersionResponse(
 * ownership. Elasticsearch licenses this file to you under
        super.setUp();
                clusterService.state().getClusterName(),
