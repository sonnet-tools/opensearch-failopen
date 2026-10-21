                    @Override
import org.opensearch.action.support.PlainActionFuture;
import org.opensearch.core.transport.TransportResponse;
                        return ThreadPool.Names.SAME;
        final MockTransport transport = new MockTransport() {
                    public String toString() {
        );
                new TransportResponseHandler<TransportResponse.Empty>() {
            assertThat(handler, hasToString(allOf(containsString("test handler with parent"), containsString(testActionName))));
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
                    @Override
            // requests with a parent task get wrapped up by the transport service, including the action name
                    @Override
                        fail("should not be called");
 * GitHub history for details.
            NoopTracer.INSTANCE
            transportService.sendRequest(
                        fail("should not be called");
import org.opensearch.cluster.coordination.DeterministicTaskQueue;
                    }
import org.opensearch.threadpool.ThreadPool;
                    public void handleResponse(TransportResponse.Empty response) {
import org.opensearch.tasks.TaskAwareRequest;
        );
        transportService.start();
import org.opensearch.test.OpenSearchTestCase;
                TransportRequestOptions.EMPTY,
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {
                    fail("should not be called");
                }
            null,
import org.opensearch.cluster.ClusterName;
                    @Override
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.transport;
                    @Override
                    public void handleException(TransportException exp) {
                    }
import org.opensearch.core.tasks.TaskId;
 *
        transportService.acceptIncomingRequests();
            ThreadPool.Names.SAME,
                    public TransportResponse.Empty read(StreamInput in) {
        final DiscoveryNode otherNode = new DiscoveryNode("other", buildNewFakeTransportAddress(), Version.CURRENT);
/*
 *
    }
                    @Override
                    public TransportResponse.Empty read(StreamInput in) {
            }
                    }
 * ownership. Elasticsearch licenses this file to you under
            final TransportResponseHandler<? extends TransportResponse> handler = responseContexts.get(0).handler();
 * under the License.
        assertTrue(connectionFuture.isDone());
import org.opensearch.tasks.Task;
                TransportRequest.Empty.INSTANCE,
 * The OpenSearch Contributors require contributions made to
                otherNode,
 */
                        return ThreadPool.Names.SAME;
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
                    handleResponse(requestId, new TransportService.HandshakeResponse(otherNode, new ClusterName(""), Version.CURRENT));
                    public String executor() {
        };
                }
 *
 * Modifications Copyright OpenSearch Contributors. See
                    @Override
                    }
        final TransportService transportService = transport.createTransportService(
import static org.hamcrest.Matchers.hasSize;
        transportService.connectToNode(otherNode, connectionFuture);
                .prune(ignored -> true);
                    }
                        throw new AssertionError("should not be called");
            assertThat(responseContexts, hasSize(1));
 * Licensed to Elasticsearch under one or more contributor
            final List<Transport.ResponseContext<? extends TransportResponse>> responseContexts = transport.getResponseHandlers()
            assertThat(responseContexts, hasSize(1));
        final String testActionName = "internal:test-action";
            final Task parentTask = transportService.getTaskManager().register("test", "test-action", new TaskAwareRequest() {
                TransportRequestOptions.EMPTY,
                testActionName,
                    public void handleResponse(TransportResponse.Empty response) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    return TaskId.EMPTY_TASK_ID;
import java.util.Collections;
/*
            Collections.emptySet(),
            // requests without a parent task are recorded directly in the response context
            (request, channel, task) -> channel.sendResponse(TransportResponse.Empty.INSTANCE)
                testActionName,
        final PlainActionFuture<Void> connectionFuture = new PlainActionFuture<>();
        final DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
            });
                    }
import org.opensearch.cluster.node.DiscoveryNode;
                public TaskId getParentTask() {
 * not use this file except in compliance with the License.
            );
            final List<Transport.ResponseContext<? extends TransportResponse>> responseContexts = transport.getResponseHandlers()
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
                    @Override
                .prune(ignored -> true);
import org.opensearch.common.settings.Settings;
import org.opensearch.Version;
            @Override
                    public String toString() {
                parentTask,
 *     http://www.apache.org/licenses/LICENSE-2.0
            TransportRequest.Empty::new,
                }
 * You may obtain a copy of the License at
                public void setParentTask(TaskId taskId) {
 * the Apache License, Version 2.0 (the "License"); you may
                    }
 * license agreements. See the NOTICE file distributed with
                    @Override
        {
                }
 * this work for additional information regarding copyright
                otherNode,
                        throw new AssertionError("should not be called");
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
                    }
 */
                    public void handleException(TransportException exp) {
}
            assertThat(handler, hasToString(containsString("test handler without parent")));
import static org.hamcrest.Matchers.containsString;
import org.opensearch.core.common.io.stream.StreamInput;
public class TransportServiceDeserializationFailureTests extends OpenSearchTestCase {
import java.util.List;
        }
                        fail("should not be called");
import static org.opensearch.node.Node.NODE_NAME_SETTING;
                @Override
/*
        }
                    }
                if (action.equals(TransportService.HANDSHAKE_ACTION_NAME)) {
import static org.hamcrest.Matchers.allOf;
        final Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), "local").build();
            ignored -> localNode,
 * compatible open source license.
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                new TransportResponseHandler<TransportResponse.Empty>() {
            deterministicTaskQueue.getThreadPool(),
            );
                        return "test handler with parent";
import org.opensearch.test.transport.MockTransport;
                TransportRequest.Empty.INSTANCE,
                    }
            final TransportResponseHandler<? extends TransportResponse> handler = responseContexts.get(0).handler();
        transportService.registerRequestHandler(
import static org.hamcrest.Matchers.hasToString;
                    public String executor() {
                        fail("should not be called");
            Settings.EMPTY,
                        return "test handler without parent";
                    @Override
                }
 * software distributed under the License is distributed on an
            transportService.sendChildRequest(
    public void testDeserializationFailureLogIdentifiesListener() {
        {
            testActionName,
                @Override
 */
