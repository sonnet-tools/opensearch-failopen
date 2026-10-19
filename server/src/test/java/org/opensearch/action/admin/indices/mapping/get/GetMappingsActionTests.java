    private TransportGetMappingsAction transportAction = null;
import org.junit.Before;
    private ClusterService clusterService;  
import org.opensearch.cluster.ClusterState;
        assertThat(capturingTransport.capturedRequests().length, equalTo(1));
 * under the License.  
            1,
            true,  
        assertThat(capturingTransport.capturedRequests().length, equalTo(1));  
            NoopTracer.INSTANCE
            throw new AssertionError(exception);  
        clusterService.close();  
            GetMappingsActionTests.this.clusterService,  
        super.tearDown();
 */
    public void tearDown() throws Exception {
        capturingTransport.handleResponse(capturedRequest.requestId, termResp);
        transportService.start();  
        // no more transport calls
 *
            Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
            null,
            Version.CURRENT  
import org.opensearch.action.support.clustermanager.term.GetTermVersionResponse;
    }  
            new GetMappingsRequest(),
    }
import static org.mockito.Mockito.mock;
/*
        // no more transport calls
import org.opensearch.common.settings.Settings;
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
            true,
 * not use this file except in compliance with the License.
            Collections.emptyMap(),
import org.opensearch.threadpool.TestThreadPool;  
 * specific language governing permissions and limitations
            )
            threadPool,
        assertThat(capturingTransport.capturedRequests().length, equalTo(1));  
            .blocks(builder)
            emptySet(),  
            boundAddress -> clusterService.localNode(),
        transportAction.execute(  
import org.opensearch.cluster.block.ClusterBlockLevel;
public class GetMappingsActionTests extends OpenSearchTestCase {
 *  
                clusterService.state().metadata().clusterUUID(),
            GetMappingsActionTests.this.transportService,
        CapturingTransport.CapturedRequest capturedRequest1 = capturingTransport.capturedRequests()[1];
 * this file be licensed under the Apache-2.0 license or a
        transportAction = new TransportGetMappingsAction(
 * The OpenSearch Contributors require contributions made to  
                clusterService.state().version() - 1
import org.opensearch.cluster.block.ClusterBlockException;  
        CapturingTransport.CapturedRequest capturedRequest = capturingTransport.capturedRequests()[0];  
 *
        setState(clusterService, metadataReadBlockedState);
        super.setUp();  
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
            RestStatus.OK,
                clusterService.state().version()
        transportService = capturingTransport.createTransportService(  
        ClusterBlocks.Builder builder = ClusterBlocks.builder();
import java.util.EnumSet;
    private final String indexName = "test_index";  
import org.opensearch.cluster.block.ClusterBlock;
        builder.addGlobalBlock(readClusterBlock);  
        localNode = new DiscoveryNode(  
                Assert.assertTrue(exception instanceof ClusterBlockException);
        transportService.acceptIncomingRequests();
import org.junit.Assert;
 * Licensed to Elasticsearch under one or more contributor  
    private ThreadPool threadPool;
import java.util.HashMap;  
    }
import org.opensearch.cluster.service.ClusterService;
        GetTermVersionResponse termResp = new GetTermVersionResponse(  
import org.opensearch.cluster.node.DiscoveryNodeRole;  
        capturingTransport.handleResponse(capturedRequest1.requestId, new GetMappingsResponse(new HashMap<>()));
            new ClusterStateTermVersion(
        capturingTransport.handleResponse(capturedRequest.requestId, termResp);  
 * this work for additional information regarding copyright
            new ClusterStateTermVersion(
        );
        );
        transportAction.execute(null, new GetMappingsRequest(), ActionListener.wrap(Assert::assertNotNull, exception -> {
        assertThat(capturingTransport.capturedRequests().length, equalTo(1));
/*  
 * SPDX-License-Identifier: Apache-2.0
    CapturingTransport capturingTransport = new CapturingTransport();
import org.opensearch.indices.IndicesService;
            )  
 * KIND, either express or implied.  See the License for the
    public void testGetTransportClusterBlockWithMatchingTerm() {  
 */  
 * license agreements. See the NOTICE file distributed with
            "",
                clusterService.state().getClusterName(),
        ClusterBlock readClusterBlock = new ClusterBlock(
    private SettingsFilter settingsFilter;
            new ActionFilters(emptySet()),
        clusterService = createClusterService(threadPool);
import org.opensearch.cluster.coordination.ClusterStateTermVersion;  
        ClusterState metadataReadBlockedState = ClusterState.builder(ClusterStateCreationUtils.state(localNode, remoteNode, allNodes))
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw new AssertionError(exception);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static java.util.Collections.emptyList;  
/*
    @Before
    public void testGetTransportWithMatchingTerm() {
            .build();  
    public void testGetTransportWithoutMatchingTerm() {
import org.opensearch.common.util.concurrent.ThreadContext;
                clusterService.state().metadata().clusterUUID(),  
                clusterService.state().term(),
            "local_node",
import static org.opensearch.test.ClusterServiceUtils.setState;  
        );
import static java.util.Collections.emptySet;
        );
                clusterService.state().getClusterName(),  
import org.opensearch.test.transport.CapturingTransport;
    @After  
 * You may obtain a copy of the License at  
        );
            Version.CURRENT
        transportAction.execute(null, new GetMappingsRequest(), ActionListener.wrap(Assert::assertNotNull, exception -> {  
            null,
import org.opensearch.threadpool.ThreadPool;
        );  
 * Unless required by applicable law or agreed to in writing,
                clusterService.state().metadata().clusterUUID(),  
    }  
    public void setUp() throws Exception {
}
import org.opensearch.action.support.replication.ClusterStateCreationUtils;  
    private DiscoveryNode[] allNodes;
        // mismatch term and version
                clusterService.state().version()  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            EnumSet.of(ClusterBlockLevel.METADATA_READ)  
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        GetTermVersionResponse termResp = new GetTermVersionResponse(  
import org.opensearch.Version;  
 * Modifications Copyright OpenSearch Contributors. See  
            ActionListener.wrap(response -> { throw new AssertionError(response); }, exception -> {  
        CapturingTransport.CapturedRequest capturedRequest = capturingTransport.capturedRequests()[0];
import org.junit.After;  
            )  
import static org.hamcrest.Matchers.equalTo;
 * GitHub history for details.
        setState(clusterService, ClusterStateCreationUtils.state(localNode, remoteNode, allNodes));  
    private TransportService transportService;
        assertThat(capturingTransport.capturedRequests().length, equalTo(1));
            clusterService.getSettings(),
            "remote_node",
import org.opensearch.transport.TransportService;
        );
            })
import org.opensearch.cluster.node.DiscoveryNode;
            "uuid",  
import org.opensearch.common.settings.SettingsModule;
import org.opensearch.common.settings.SettingsFilter;  
            new ClusterStateTermVersion(
        GetTermVersionResponse termResp = new GetTermVersionResponse(
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),  
        allNodes = new DiscoveryNode[] { localNode, remoteNode };
                clusterService.state().term(),
            buildNewFakeTransportAddress(),
        assertThat(capturingTransport.capturedRequests().length, equalTo(2));
        settingsFilter = new SettingsModule(Settings.EMPTY, emptyList(), emptyList(), emptySet()).getSettingsFilter();
            mock(IndicesService.class)
 * ownership. Elasticsearch licenses this file to you under  
            Collections.emptyMap(),  
    private DiscoveryNode remoteNode;  
 * the Apache License, Version 2.0 (the "License"); you may
        );  
        CapturingTransport.CapturedRequest capturedRequest = capturingTransport.capturedRequests()[0];
                clusterService.state().getClusterName(),
                clusterService.state().term() - 1,
            false,
            buildNewFakeTransportAddress(),  
 * software distributed under the License is distributed on an
        capturingTransport.handleResponse(capturedRequest.requestId, termResp);
        remoteNode = new DiscoveryNode(
package org.opensearch.action.admin.indices.mapping.get;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
        transportService.close();
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
import org.opensearch.core.rest.RestStatus;
            GetMappingsActionTests.this.threadPool,
        }));
        threadPool = new TestThreadPool("GetIndexActionTests");  
 */
import org.opensearch.core.action.ActionListener;  
import org.opensearch.test.OpenSearchTestCase;
        );
    private DiscoveryNode localNode;
 * compatible open source license.
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
import org.opensearch.action.support.ActionFilters;
        }));
    }
import org.opensearch.cluster.block.ClusterBlocks;
