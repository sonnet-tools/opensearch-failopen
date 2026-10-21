        protected boolean localExecuteSupportedByAction() {
    public void tearDown() throws Exception {
        transport = new CapturingTransport();
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.common.io.stream.StreamInput;
                new ActionFilters(new HashSet<>()),
 * not use this file except in compliance with the License.
        PlainActionFuture<TransportClusterManagerTermCheckTests.Response> listener = new PlainActionFuture<>();
 * the Apache License, Version 2.0 (the "License"); you may
            )
            new ClusterStateTermVersion(
        }
                clusterService.state().metadata().clusterUUID(),
        setState(clusterService, ClusterStateCreationUtils.state(localNode, remoteNode, allNodes));
import org.opensearch.transport.TransportService;
    public static void beforeClass() {
        @Override
            listener
        }
        setUpCluster(Version.CURRENT);
        );
import org.opensearch.cluster.coordination.ClusterStateTermVersion;
        GetTermVersionResponse response = new GetTermVersionResponse(
        assertThat(capturedRequest.request, equalTo(request));
        );
            request,
            "local_node",
        assertTrue(listener.isDone());
            clusterService.getSettings(),
 *
        assertTrue(termCheckRequest.node.isClusterManagerNode());
        }
        );
/*
        public int hashCode() {
        );
        }
        transportService.close();
    private static ThreadPool threadPool;
            super(in);
                clusterService.state().getClusterName(),
        );
import java.util.concurrent.ExecutionException;
 * Modifications Copyright OpenSearch Contributors. See
        protected void clusterManagerOperation(Request request, ClusterState state, ActionListener<Response> listener) throws Exception {
                clusterService.state().version()
    private DiscoveryNode[] allNodes;
import org.junit.AfterClass;
        );
 * The OpenSearch Contributors require contributions made to
import org.opensearch.threadpool.TestThreadPool;
        assertThat(transport.capturedRequests().length, equalTo(1));
    private DiscoveryNode remoteNode;
    }
        @Override
        private long identity = randomLong();
                actionName,
    public void testTermCheckMatchWithClusterManager() throws ExecutionException, InterruptedException {
import org.opensearch.cluster.node.DiscoveryNodeRole;
    private DiscoveryNode localNode;
        allNodes = new DiscoveryNode[] { localNode, remoteNode };
 * this work for additional information regarding copyright
            x -> clusterService.localNode(),
import org.opensearch.test.transport.CapturingTransport;
            out.writeLong(identity);
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
import org.opensearch.action.support.clustermanager.term.GetTermVersionResponse;
 * this file be licensed under the Apache-2.0 license or a
            // remove unneeded threading by wrapping listener with SAME to prevent super.doExecute from wrapping it with LISTENER
        assertFalse(listener.isDone());
        assertThat(transport.capturedRequests().length, equalTo(2));
        }
        Request() {}
        CapturingTransport.CapturedRequest capturedRequest = transport.capturedRequests()[0];
 *
        assertThat(capturedRequest.action, equalTo("internal:testAction"));
import org.opensearch.common.util.concurrent.ThreadContext;
        setUpCluster(Version.CURRENT);
    }
    }
        assertThat(listener.get(), equalTo(response));
            Collections.emptyMap(),
    @Override
        public boolean equals(Object o) {
import org.opensearch.cluster.ClusterState;
            return ThreadPool.Names.SAME;
        transportService.acceptIncomingRequests();
        CapturingTransport.CapturedRequest termCheckRequest = transport.capturedRequests()[0];
            Version.CURRENT
 * specific language governing permissions and limitations
import org.opensearch.cluster.node.DiscoveryNode;
        transport.handleResponse(capturedRequest.requestId, response);
        }
import org.junit.Before;
 */
 * under the License.
            request,
    public void testTermCheckNoMatchWithClusterManager() throws ExecutionException, InterruptedException {
            buildNewFakeTransportAddress(),
    public static void afterClass() {
        transport.handleResponse(capturedRequest.requestId, response);
    }
 * software distributed under the License is distributed on an
        TransportClusterManagerTermCheckTests.Request request = new TransportClusterManagerTermCheckTests.Request();
        assertThat(capturedRequest.action, equalTo("internal:monitor/term"));
        protected void doExecute(Task task, final Request request, ActionListener<Response> listener) {
        Response(StreamInput in) throws IOException {
        super.setUp();
        @Override
        localNode = new DiscoveryNode(
        assertTrue(listener.isDone());
            listener.onResponse(new Response()); // default implementation, overridden in specific tests
 * license agreements. See the NOTICE file distributed with
import java.util.Collections;
        threadPool = null;
            super(in);
        transportService.start();
import org.opensearch.test.OpenSearchTestCase;
            );
import org.opensearch.threadpool.ThreadPool;
    @After
            Response response = (Response) o;
 *
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
import org.opensearch.core.action.ActionListener;
        assertTrue(capturedRequest.node.isClusterManagerNode());
            return null; // default implementation, overridden in specific tests
        TransportClusterManagerTermCheckTests.Response response = new TransportClusterManagerTermCheckTests.Response();
 * SPDX-License-Identifier: Apache-2.0
        transportService = transport.createTransportService(
    }
            super(
        @Override
            listener
        assertTrue(listener.isDone());
 * Unless required by applicable law or agreed to in writing,
        assertThat(termCheckRequest.action, equalTo("internal:monitor/term"));
        @Override
            return null;
        assertThat(capturedRequest.action, equalTo("internal:testAction"));
                transportService,
        PlainActionFuture<TransportClusterManagerTermCheckTests.Response> listener = new PlainActionFuture<>();
        TransportClusterManagerTermCheckTests.Request request = new TransportClusterManagerTermCheckTests.Request();
        public ActionRequestValidationException validate() {
import org.opensearch.cluster.block.ClusterBlockException;
            null,
import org.opensearch.common.settings.Settings;
import org.opensearch.Version;
        transport.handleResponse(termCheckRequest.requestId, noMatchResponse);
 * You may obtain a copy of the License at
        clusterService = createClusterService(threadPool);
import org.opensearch.action.ActionRequestValidationException;
                clusterService.state().version() - 1
            clusterManagerVersion
        setUpCluster(Version.V_2_12_0);
            listener
        new TransportClusterManagerTermCheckTests.Action("internal:testAction", transportService, clusterService, threadPool).execute(
        assertTrue(capturedRequest.node.isClusterManagerNode());
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            Collections.emptySet(),
    public void testTermCheckOnOldVersionClusterManager() throws ExecutionException, InterruptedException {
    }
import org.opensearch.action.support.PlainActionFuture;
            return Objects.hash(identity);
            Collections.emptyMap(),
        assertThat(listener.get(), equalTo(response));
        }
    private void setUpCluster(Version clusterManagerVersion) {
import java.io.IOException;
import static org.hamcrest.Matchers.equalTo;
    @AfterClass
            super.doExecute(task, request, new ThreadedActionListener<>(logger, threadPool, ThreadPool.Names.SAME, listener, false));
        Action(String actionName, TransportService transportService, ClusterService clusterService, ThreadPool threadPool) {
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
}
        Response() {}
        protected ClusterBlockException checkBlock(Request request, ClusterState state) {
        TransportClusterManagerTermCheckTests.Request request = new TransportClusterManagerTermCheckTests.Request();
                clusterService.state().term(),
package org.opensearch.action.support.clustermanager;
    private ClusterService clusterService;
        }
        Request(StreamInput in) throws IOException {
 * ownership. Elasticsearch licenses this file to you under
        }
            NoopTracer.INSTANCE
    public void setUp() throws Exception {
        }
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        assertTrue(capturedRequest.node.isClusterManagerNode());
            if (o == null || getClass() != o.getClass()) return false;
import org.opensearch.action.support.ActionFilters;
        assertThat(transport.capturedRequests().length, equalTo(1));
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static class Request extends ClusterManagerNodeRequest<Request> {
        PlainActionFuture<TransportClusterManagerTermCheckTests.Response> listener = new PlainActionFuture<>();
            )
        new TransportClusterManagerTermCheckTests.Action("internal:testAction", transportService, clusterService, threadPool).execute(
                clusterService.state().metadata().clusterUUID(),
 */
            // very lightweight operation in memory, no need to fork to a thread
            return new Response(in);
            return identity == response.identity;
        remoteNode = new DiscoveryNode(
import org.opensearch.action.support.ThreadedActionListener;
    @BeforeClass
            identity = in.readLong();
 * GitHub history for details.
            if (this == o) return true;
 * compatible open source license.
        threadPool = new TestThreadPool("TransportMasterNodeActionTests");
        protected Response read(StreamInput in) throws IOException {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        transport.handleResponse(capturedRequest.requestId, response);
import org.opensearch.core.action.ActionResponse;
                new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))
            buildNewFakeTransportAddress(),
                clusterService.state().getClusterName(),
        }
    }
        new TransportClusterManagerTermCheckTests.Action("internal:testAction", transportService, clusterService, threadPool).execute(
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        clusterService.close();
public class TransportClusterManagerTermCheckTests extends OpenSearchTestCase {
        assertThat(capturedRequest.request, equalTo(request));
            Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
    }
        @Override
    private CapturingTransport transport;
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
 */
        @Override
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
        GetTermVersionResponse noMatchResponse = new GetTermVersionResponse(
/*
            return true;
        );
import org.junit.BeforeClass;
import java.util.Objects;
            new ClusterStateTermVersion(
        @Override
        }
        @Override
import org.junit.After;
import static org.opensearch.test.ClusterServiceUtils.setState;
        CapturingTransport.CapturedRequest capturedRequest = transport.capturedRequests()[0];
        assertThat(transport.capturedRequests().length, equalTo(1));
            threadPool,
        super.tearDown();
/*
        protected String executor() {
                Request::new,
import org.opensearch.cluster.service.ClusterService;
        TransportClusterManagerTermCheckTests.Response response = new TransportClusterManagerTermCheckTests.Response();
            request,
    }
                clusterService.state().term(),
        public void writeTo(StreamOutput out) throws IOException {
                threadPool,
    }
 * KIND, either express or implied.  See the License for the
        CapturingTransport.CapturedRequest capturedRequest = transport.capturedRequests()[1];
        );
        @Override
    private TransportService transportService;
            "remote_node",
 * Licensed to Elasticsearch under one or more contributor
    class Action extends TransportClusterManagerNodeAction<Request, Response> {
    class Response extends ActionResponse {
    @Before
                clusterService,
    }
import org.opensearch.tasks.Task;
