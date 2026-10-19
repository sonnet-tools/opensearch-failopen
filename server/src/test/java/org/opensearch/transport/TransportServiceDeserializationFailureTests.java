            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {
            final TransportResponseHandler<? extends TransportResponse> handler = responseContexts.get(0).handler();  
            final List<Transport.ResponseContext<? extends TransportResponse>> responseContexts = transport.getResponseHandlers()
                    public void handleException(TransportException exp) {  
            // requests without a parent task are recorded directly in the response context
 *
            ignored -> localNode,
}
import static org.hamcrest.Matchers.hasSize;
import org.opensearch.cluster.node.DiscoveryNode;
                parentTask,  
                @Override  
import org.opensearch.action.support.PlainActionFuture;
            TransportRequest.Empty::new,
import org.opensearch.cluster.coordination.DeterministicTaskQueue;
            Collections.emptySet(),
                    }  
            });  
                    public void handleException(TransportException exp) {
 * Unless required by applicable law or agreed to in writing,
 */  
 * compatible open source license.
                new TransportResponseHandler<TransportResponse.Empty>() {
 * Modifications Copyright OpenSearch Contributors. See
            Settings.EMPTY,
                    public String toString() {  
import org.opensearch.core.common.io.stream.StreamInput;
 * Licensed to Elasticsearch under one or more contributor  
            assertThat(handler, hasToString(allOf(containsString("test handler with parent"), containsString(testActionName))));
                    @Override
                    @Override
            }
                    public String executor() {  
                }
                    }
        transportService.start();  
                    return TaskId.EMPTY_TASK_ID;
            );
import org.opensearch.core.tasks.TaskId;
        final PlainActionFuture<Void> connectionFuture = new PlainActionFuture<>();  
            transportService.sendChildRequest(
        final DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
    public void testDeserializationFailureLogIdentifiesListener() {
                        fail("should not be called");
                        fail("should not be called");  
 * not use this file except in compliance with the License.
        transportService.acceptIncomingRequests();
            final TransportResponseHandler<? extends TransportResponse> handler = responseContexts.get(0).handler();
        transportService.registerRequestHandler(
                otherNode,
                    public String executor() {
            assertThat(handler, hasToString(containsString("test handler without parent")));
                .prune(ignored -> true);
                    @Override  
                otherNode,  
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
            NoopTracer.INSTANCE
 * KIND, either express or implied.  See the License for the
                    }
            deterministicTaskQueue.getThreadPool(),  
            // requests with a parent task get wrapped up by the transport service, including the action name  
 * license agreements. See the NOTICE file distributed with
/*  
                    public TransportResponse.Empty read(StreamInput in) {
import org.opensearch.core.transport.TransportResponse;  
        {
                        return ThreadPool.Names.SAME;
                @Override
                    handleResponse(requestId, new TransportService.HandshakeResponse(otherNode, new ClusterName(""), Version.CURRENT));  
 * SPDX-License-Identifier: Apache-2.0
                }  
                TransportRequestOptions.EMPTY,
                    }  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
                }
 * this file be licensed under the Apache-2.0 license or a
                    public TransportResponse.Empty read(StreamInput in) {
            final Task parentTask = transportService.getTaskManager().register("test", "test-action", new TaskAwareRequest() {
import org.opensearch.common.settings.Settings;  
import org.opensearch.threadpool.ThreadPool;  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final MockTransport transport = new MockTransport() {
                    @Override
            testActionName,  
package org.opensearch.transport;
                if (action.equals(TransportService.HANDSHAKE_ACTION_NAME)) {
 * ownership. Elasticsearch licenses this file to you under  
                    }
import org.opensearch.Version;
import org.opensearch.test.transport.MockTransport;
                        throw new AssertionError("should not be called");  
                new TransportResponseHandler<TransportResponse.Empty>() {  
import static org.hamcrest.Matchers.hasToString;  
            );
            transportService.sendRequest(
                        return "test handler without parent";
import static org.hamcrest.Matchers.containsString;
                    @Override
                    @Override  
 * under the License.  
import org.opensearch.tasks.Task;
                    fail("should not be called");
                    }  
        {
        assertTrue(connectionFuture.isDone());
                        return ThreadPool.Names.SAME;  
            @Override  
 * specific language governing permissions and limitations
public class TransportServiceDeserializationFailureTests extends OpenSearchTestCase {
                    }
                TransportRequestOptions.EMPTY,
import static org.hamcrest.Matchers.allOf;  
 * GitHub history for details.
        final TransportService transportService = transport.createTransportService(
            assertThat(responseContexts, hasSize(1));
 * You may obtain a copy of the License at  
import org.opensearch.cluster.ClusterName;  
 */
            final List<Transport.ResponseContext<? extends TransportResponse>> responseContexts = transport.getResponseHandlers()  
                    public void handleResponse(TransportResponse.Empty response) {
                .prune(ignored -> true);
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
            null,  
/*
import java.util.Collections;
        );
 *
        }
                    public void handleResponse(TransportResponse.Empty response) {
                        throw new AssertionError("should not be called");
                    }
        final Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), "local").build();
                public void setParentTask(TaskId taskId) {
                TransportRequest.Empty.INSTANCE,
                    }
 * The OpenSearch Contributors require contributions made to  
                testActionName,  
            (request, channel, task) -> channel.sendResponse(TransportResponse.Empty.INSTANCE)  
        transportService.connectToNode(otherNode, connectionFuture);
        final DiscoveryNode otherNode = new DiscoveryNode("other", buildNewFakeTransportAddress(), Version.CURRENT);  
                }
                    public String toString() {
import org.opensearch.tasks.TaskAwareRequest;
                    @Override
        final String testActionName = "internal:test-action";  
                testActionName,
                        return "test handler with parent";
                    @Override  
 * software distributed under the License is distributed on an
import org.opensearch.test.OpenSearchTestCase;
            assertThat(responseContexts, hasSize(1));  
                        fail("should not be called");
                        fail("should not be called");
                TransportRequest.Empty.INSTANCE,
                    @Override
 */  
 * the Apache License, Version 2.0 (the "License"); you may
                }  
        }  
                    @Override  
import static org.opensearch.node.Node.NODE_NAME_SETTING;
            ThreadPool.Names.SAME,
                public TaskId getParentTask() {  
/*  
        };  
import java.util.List;  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
                    }  
        );  
 *  
