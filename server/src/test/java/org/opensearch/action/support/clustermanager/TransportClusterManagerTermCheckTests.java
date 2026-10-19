import org.opensearch.core.common.io.stream.StreamInput;  
        GetTermVersionResponse response = new GetTermVersionResponse(
        );  
import java.util.concurrent.TimeUnit;
                clusterService.state().version()  
        assertTrue(listener.isDone());
        @Override
            listener.onResponse(new Response()); // default implementation, overridden in specific tests
import org.opensearch.test.transport.CapturingTransport;
            new ClusterStateTermVersion(
import org.opensearch.core.action.ActionListener;
    private DiscoveryNode[] allNodes;  
        assertThat(capturedRequest.request, equalTo(request));
        private long identity = randomLong();  
        transportService = transport.createTransportService(
/*  
        TransportClusterManagerTermCheckTests.Response response = new TransportClusterManagerTermCheckTests.Response();
        CapturingTransport.CapturedRequest capturedRequest = transport.capturedRequests()[0];  
import org.opensearch.cluster.ClusterState;
            super(in);
 * Modifications Copyright OpenSearch Contributors. See  
            return null;
import org.opensearch.test.OpenSearchTestCase;
            return Objects.hash(identity);
 * specific language governing permissions and limitations
            Collections.emptyMap(),
import java.util.Objects;
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),  
        assertThat(capturedRequest.action, equalTo("internal:testAction"));  
        assertTrue(capturedRequest.node.isClusterManagerNode());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))
        @Override
            listener
            NoopTracer.INSTANCE
import org.opensearch.action.support.clustermanager.term.GetTermVersionResponse;
 * ownership. Elasticsearch licenses this file to you under  
import org.junit.After;  
        }  
        protected Response read(StreamInput in) throws IOException {
        Request(StreamInput in) throws IOException {
 * You may obtain a copy of the License at  
            if (this == o) return true;
            request,
 */  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.node.DiscoveryNodeRole;  
            buildNewFakeTransportAddress(),  
        setUpCluster(Version.CURRENT);  
                clusterService,  
            )
        }  
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
        }
import org.opensearch.threadpool.ThreadPool;
        setUpCluster(Version.V_2_12_0);
            Collections.emptySet(),
            return true;
        @Override
        PlainActionFuture<TransportClusterManagerTermCheckTests.Response> listener = new PlainActionFuture<>();
import org.junit.Before;
        }
 *  
            return null; // default implementation, overridden in specific tests
 * Licensed to Elasticsearch under one or more contributor  
            buildNewFakeTransportAddress(),
 * compatible open source license.
            request,
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
import org.opensearch.common.settings.Settings;
        }
        transport.handleResponse(termCheckRequest.requestId, noMatchResponse);
            // very lightweight operation in memory, no need to fork to a thread
    @Before
        }
 * not use this file except in compliance with the License.
        assertThat(listener.get(), equalTo(response));
 * GitHub history for details.
        setUpCluster(Version.CURRENT);
        assertTrue(termCheckRequest.node.isClusterManagerNode());
}
 * KIND, either express or implied.  See the License for the
            if (o == null || getClass() != o.getClass()) return false;  
import org.opensearch.tasks.Task;
        );  
            return identity == response.identity;
    @After  
        TransportClusterManagerTermCheckTests.Request request = new TransportClusterManagerTermCheckTests.Request();
            null,  
        CapturingTransport.CapturedRequest capturedRequest = transport.capturedRequests()[1];  
            new ClusterStateTermVersion(
            x -> clusterService.localNode(),
        clusterService.close();  
        assertTrue(listener.isDone());
        assertThat(transport.capturedRequests().length, equalTo(1));
        CapturingTransport.CapturedRequest termCheckRequest = transport.capturedRequests()[0];  
        super.tearDown();
                clusterService.state().getClusterName(),
        protected void doExecute(Task task, final Request request, ActionListener<Response> listener) {  
import org.opensearch.cluster.block.ClusterBlockException;
        transport = new CapturingTransport();
    public void setUp() throws Exception {  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(transport.capturedRequests().length, equalTo(1));
    public void testTermCheckMatchWithClusterManager() throws ExecutionException, InterruptedException {
                threadPool,
        protected ClusterBlockException checkBlock(Request request, ClusterState state) {  
                new ActionFilters(new HashSet<>()),
        assertThat(transport.capturedRequests().length, equalTo(2));
            super.doExecute(task, request, new ThreadedActionListener<>(logger, threadPool, ThreadPool.Names.SAME, listener, false));
    }  
    }
import org.opensearch.action.support.ThreadedActionListener;
 * this work for additional information regarding copyright
    @Override
 *
    private DiscoveryNode remoteNode;
    }
            clusterService.getSettings(),
        }  
package org.opensearch.action.support.clustermanager;
import static org.hamcrest.Matchers.equalTo;
        transport.handleResponse(capturedRequest.requestId, response);  
    public void testTermCheckOnOldVersionClusterManager() throws ExecutionException, InterruptedException {  
            return new Response(in);  
    }
 * license agreements. See the NOTICE file distributed with
        @Override  
                clusterService.state().metadata().clusterUUID(),  
            Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
        protected boolean localExecuteSupportedByAction() {  
        Response(StreamInput in) throws IOException {
        new TransportClusterManagerTermCheckTests.Action("internal:testAction", transportService, clusterService, threadPool).execute(  
        assertThat(capturedRequest.action, equalTo("internal:monitor/term"));  
/*
import org.opensearch.cluster.service.ClusterService;
        transport.handleResponse(capturedRequest.requestId, response);  
import java.util.Collections;  
/*
                transportService,
                Request::new,  
                clusterService.state().getClusterName(),  
        assertTrue(capturedRequest.node.isClusterManagerNode());
        @Override
        assertThat(transport.capturedRequests().length, equalTo(1));  
 */
 * under the License.  
        public int hashCode() {  
            super(in);
import org.opensearch.action.ActionRequestValidationException;
        );
        new TransportClusterManagerTermCheckTests.Action("internal:testAction", transportService, clusterService, threadPool).execute(
            Collections.emptyMap(),
import static org.opensearch.test.ClusterServiceUtils.createClusterService;  
    public static void afterClass() {
        TransportClusterManagerTermCheckTests.Request request = new TransportClusterManagerTermCheckTests.Request();  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                clusterService.state().term(),
        }
        );
 */
import org.opensearch.core.common.io.stream.StreamOutput;
import java.util.HashSet;
        assertTrue(capturedRequest.node.isClusterManagerNode());
        }
        TransportClusterManagerTermCheckTests.Response response = new TransportClusterManagerTermCheckTests.Response();
        @Override
        );  
 * software distributed under the License is distributed on an
    private TransportService transportService;
    private static ThreadPool threadPool;
        @Override  
            listener
    private ClusterService clusterService;
import org.opensearch.Version;  
        }  
    public void tearDown() throws Exception {
        setState(clusterService, ClusterStateCreationUtils.state(localNode, remoteNode, allNodes));
 * the Apache License, Version 2.0 (the "License"); you may
        }  
            listener  
import java.util.concurrent.ExecutionException;  
        @Override
        threadPool = null;
import org.opensearch.cluster.coordination.ClusterStateTermVersion;  
        remoteNode = new DiscoveryNode(
        transportService.acceptIncomingRequests();
import org.opensearch.transport.TransportService;
 * SPDX-License-Identifier: Apache-2.0
        assertThat(listener.get(), equalTo(response));
            Response response = (Response) o;
        public boolean equals(Object o) {
    }
        transportService.start();
        GetTermVersionResponse noMatchResponse = new GetTermVersionResponse(  
import org.junit.BeforeClass;  
            threadPool,  
            out.writeLong(identity);  
    public static void beforeClass() {  
import org.opensearch.threadpool.TestThreadPool;  
    }
        Action(String actionName, TransportService transportService, ClusterService clusterService, ThreadPool threadPool) {
        assertThat(capturedRequest.request, equalTo(request));
    @AfterClass
            "remote_node",  
        );
            );
import org.opensearch.common.util.concurrent.ThreadContext;  
        clusterService = createClusterService(threadPool);  
        );
import org.opensearch.action.support.ActionFilters;
        PlainActionFuture<TransportClusterManagerTermCheckTests.Response> listener = new PlainActionFuture<>();
    private DiscoveryNode localNode;
            clusterManagerVersion
    }
            super(  
    }  
        transportService.close();
public class TransportClusterManagerTermCheckTests extends OpenSearchTestCase {
        );
        @Override
        PlainActionFuture<TransportClusterManagerTermCheckTests.Response> listener = new PlainActionFuture<>();  
            "local_node",
        Request() {}
        transport.handleResponse(capturedRequest.requestId, response);  
        assertFalse(listener.isDone());  
import org.opensearch.action.support.replication.ClusterStateCreationUtils;  
import org.opensearch.action.support.PlainActionFuture;  
import org.junit.AfterClass;
            // remove unneeded threading by wrapping listener with SAME to prevent super.doExecute from wrapping it with LISTENER
 *
    }
        public ActionRequestValidationException validate() {  
    private void setUpCluster(Version clusterManagerVersion) {  
    @BeforeClass
        TransportClusterManagerTermCheckTests.Request request = new TransportClusterManagerTermCheckTests.Request();  
import java.io.IOException;
    public static class Request extends ClusterManagerNodeRequest<Request> {
        Response() {}
                clusterService.state().metadata().clusterUUID(),
            )  
        @Override
 * Unless required by applicable law or agreed to in writing,
    class Response extends ActionResponse {
            Version.CURRENT  
    }
        protected void clusterManagerOperation(Request request, ClusterState state, ActionListener<Response> listener) throws Exception {
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        public void writeTo(StreamOutput out) throws IOException {
        super.setUp();
        threadPool = new TestThreadPool("TransportMasterNodeActionTests");
    }  
        protected String executor() {  
    public void testTermCheckNoMatchWithClusterManager() throws ExecutionException, InterruptedException {
import org.opensearch.cluster.node.DiscoveryNode;
        allNodes = new DiscoveryNode[] { localNode, remoteNode };  
        assertTrue(listener.isDone());
                clusterService.state().version() - 1
import org.opensearch.core.action.ActionResponse;
            identity = in.readLong();  
    private CapturingTransport transport;  
        assertThat(capturedRequest.action, equalTo("internal:testAction"));  
    class Action extends TransportClusterManagerNodeAction<Request, Response> {
import static org.opensearch.test.ClusterServiceUtils.setState;
            request,
        }  
        new TransportClusterManagerTermCheckTests.Action("internal:testAction", transportService, clusterService, threadPool).execute(  
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);  
                actionName,
        localNode = new DiscoveryNode(
        assertThat(termCheckRequest.action, equalTo("internal:monitor/term"));
                clusterService.state().term(),
        CapturingTransport.CapturedRequest capturedRequest = transport.capturedRequests()[0];
            return ThreadPool.Names.SAME;
