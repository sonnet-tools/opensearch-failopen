            org.opensearch.client.tasks.TaskInfo taskInfo = cTasksMap.get(
 * Licensed to Elasticsearch under one or more contributor
            org.opensearch.client.tasks.TaskOperationFailure failure = cTasksFailuresMap.get(tof.getTaskId());
        // it knows the hardcoded address space.
                    cancellationStartTime
 *
import java.util.Map;
import org.opensearch.cluster.node.DiscoveryNode;
            List<? extends OpenSearchException> nodeFailures
        for (TaskInfo ti : sTasks) {
            builder.field("status", status);
                )
            InetAddress inetAddress = InetAddress.getByAddress(new byte[] { (byte) 192, (byte) 168, (byte) 0, (byte) 1 });
            List<TaskOperationFailure> taskFailures,
                    randomAlphaOfLength(10),
import org.opensearch.client.AbstractResponseTestCase;
import org.opensearch.common.xcontent.XContentType;
            tasks.add(
        List<OpenSearchException> serverNodeFailures = serverTestInstance.getNodeFailures();
        List<org.opensearch.client.tasks.TaskInfo> cTasks = clientInstance.getTasks();
import static java.util.Collections.emptyMap;
            assertEquals(ti.isCancellable(), taskInfo.isCancellable());
            assertEquals(status.code, taskInfo.getStatus().get("code"));
import org.opensearch.core.common.io.stream.StreamOutput;
            assertTrue(failure.getReason().getMsg().contains("runtime_exception"));
            DiscoveryNodes.Builder dnBuilder = new DiscoveryNodes.Builder();
        List<String> sExceptionsMessages = serverNodeFailures.stream()
            }
            super.toXContentGroupedByNode(builder, params, build);
            assertEquals(ti.getStartTime(), taskInfo.getStartTime());
            .collect(Collectors.toList());
        ) {
    org.opensearch.client.tasks.CancelTasksResponse> {
            );
            .collect(Collectors.toMap(org.opensearch.client.tasks.TaskOperationFailure::getTaskId, Function.identity()));
    }
            DiscoveryNodes build = dnBuilder.build();
            return builder;
        for (int i = 0; i < randomIntBetween(1, 4); i++) {
                    new FakeTaskStatus(randomAlphaOfLength(4), randomInt()),
            assertTrue(failure.getStatus().contains("" + tof.getStatus().name()));
    private static String NODE_ID = "node_id";
import java.net.InetAddress;
        @Override
import java.util.ArrayList;
import org.opensearch.tasks.TaskInfo;
        List<TaskOperationFailure> sTaskFailures = serverTestInstance.getTaskFailures();
                    cancelled,
                cancellationStartTime = randomNonNegativeLong();
        }
            .map(org.opensearch.client.tasks.OpenSearchException::getMsg)
            super(in);
import java.util.stream.Collectors;
 *
        for (int i = 0; i < 4; i++) {
        Map<Long, org.opensearch.client.tasks.TaskOperationFailure> cTasksFailuresMap = cTaskFailures.stream()
            return builder.endObject();
 * compatible open source license.
import java.util.function.Function;
        public void writeTo(StreamOutput out) throws IOException {
        }
            if (cancelled) {
public class CancelTasksResponseTests extends AbstractResponseTestCase<
        @Override
        }
 * ownership. Elasticsearch licenses this file to you under
        for (TaskOperationFailure tof : sTaskFailures) {
        for (int i = 0; i < randomIntBetween(1, 4); i++) {
    static class ByNodeCancelTasksResponse extends CancelTasksResponse {
        }
            TransportAddress transportAddress = new TransportAddress(inetAddress, randomIntBetween(0, 65535));
            dnBuilder.add(new DiscoveryNode(NODE_ID, NODE_ID, transportAddress, emptyMap(), emptySet(), Version.CURRENT));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        ByNodeCancelTasksResponse(StreamInput in) throws IOException {
            assertEquals(status.status, taskInfo.getStatus().get("status"));
import java.util.HashSet;
import static java.util.Collections.emptySet;
     * So in this test we assume all tasks are issued by a single node whose name and IP address is hardcoded.
        ByNodeCancelTasksResponse(
            nodeFailures.add(new OpenSearchException(new RuntimeException(randomAlphaOfLength(10))));
 */
 * GitHub history for details.
 * software distributed under the License is distributed on an
     * IP addresses.
import org.opensearch.core.tasks.TaskId;
    }
 *
            assertEquals(ti.getRunningTimeNanos(), taskInfo.getRunningTimeNanos());
            builder.startObject();
        }
import org.opensearch.Version;
            assertEquals(ti.getDescription(), taskInfo.getDescription());
            assertEquals(ti.getAction(), taskInfo.getAction());
}
                new org.opensearch.client.tasks.TaskId(ti.getTaskId().getNodeId(), ti.getTaskId().getId())
import org.opensearch.core.xcontent.XContentBuilder;
            this.code = code;
            boolean cancelled = cancellable == true ? randomBoolean() : false;
        List<TaskOperationFailure> taskFailures = new ArrayList<>();
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
            );
    /**
        List<org.opensearch.client.tasks.OpenSearchException> cNodeFailures = clientInstance.getNodeFailures();
    protected org.opensearch.client.tasks.CancelTasksResponse doParseToClientInstance(XContentParser parser) throws IOException {
        final int code;
            super(tasks, taskFailures, nodeFailures);
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
import java.util.Collections;
    @Override
            .collect(Collectors.toMap(org.opensearch.client.tasks.TaskInfo::getTaskId, Function.identity()));
    }
        }
        return org.opensearch.client.tasks.CancelTasksResponse.fromXContent(parser);
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * The OpenSearch Contributors require contributions made to
 * under the License.
            .map(x -> org.opensearch.client.tasks.OpenSearchException.buildMessage("exception", x.getMessage(), null))
     * tasks are grouped under nodes, and in order to create DiscoveryNodes we need different
import java.util.HashMap;
            FakeTaskStatus status = (FakeTaskStatus) ti.getStatus();
        }
        @Override
    ) {
        List<OpenSearchException> nodeFailures = new ArrayList<>();
            out.writeString(status);
        ByNodeCancelTasksResponse serverTestInstance,
/*
    @Override
import org.opensearch.core.common.transport.TransportAddress;
                    null,
        public FakeTaskStatus(String status, int code) {
        List<org.opensearch.tasks.TaskInfo> tasks = new ArrayList<>();
                    randomLongBetween(1, 3),
            assertEquals(ti.getType(), taskInfo.getType());
 * this file be licensed under the Apache-2.0 license or a
    protected CancelTasksResponseTests.ByNodeCancelTasksResponse createServerTestInstance(XContentType xContentType) {
    public static class FakeTaskStatus implements Task.Status {
import org.opensearch.core.xcontent.XContentParser;
        final String status;
 * this work for additional information regarding copyright
            List<TaskInfo> tasks,
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
        }
        List<TaskInfo> sTasks = serverTestInstance.getTasks();
    }
 * Unless required by applicable law or agreed to in writing,
            this.status = status;
        }
            boolean cancellable = randomBoolean();
        org.opensearch.client.tasks.CancelTasksResponse clientInstance
    }
        public String getWriteableName() {
                    randomAlphaOfLength(4),
import org.opensearch.cluster.node.DiscoveryNodes;
        }
                new org.opensearch.tasks.TaskInfo(
        }
import org.opensearch.OpenSearchException;
import java.util.List;
                    Collections.singletonMap("x-header-of", "some-value"),
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamInput;
                    cancellable,
 * Modifications Copyright OpenSearch Contributors. See
/*
            return "faker";
                    new TaskId("node1", randomLong()),
        assertEquals(new HashSet<>(sExceptionsMessages), new HashSet<>(cExceptionsMessages));
import org.opensearch.tasks.Task;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
            .collect(Collectors.toList());
            assertEquals(ti.getCancellationStartTime(), taskInfo.getCancellationStartTime());
            assertEquals(tof.getNodeId(), failure.getNodeId());
        List<String> cExceptionsMessages = cNodeFailures.stream()
            assertEquals(ti.getParentTaskId().getNodeId(), taskInfo.getParentTaskId().getNodeId());
/*
 */
                    new TaskId(NODE_ID, (long) i),
        // checking tasks
                    randomAlphaOfLength(4),
 * You may obtain a copy of the License at
            assertEquals(ti.isCancelled(), taskInfo.isCancelled());
package org.opensearch.client.tasks;
     */
            Long cancellationStartTime = null;
            taskFailures.add(new TaskOperationFailure(randomAlphaOfLength(4), (long) i, new RuntimeException(randomAlphaOfLength(4))));
            assertEquals(ti.getParentTaskId().getId(), taskInfo.getParentTaskId().getId());
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.TaskOperationFailure;
            out.writeInt(code);
        // checking failures
import java.io.IOException;
            assertEquals(new HashMap<>(ti.getHeaders()), new HashMap<>(taskInfo.getHeaders()));
        @Override
 */
        Map<org.opensearch.client.tasks.TaskId, org.opensearch.client.tasks.TaskInfo> cTasksMap = cTasks.stream()
        return new ByNodeCancelTasksResponse(tasks, taskFailures, nodeFailures);
        List<org.opensearch.client.tasks.TaskOperationFailure> cTaskFailures = clientInstance.getTaskFailures();
                    randomIntBetween(5, 10),
            builder.endObject();
    @Override
    protected void assertInstances(
            builder.startObject();
            builder.field("code", code);
        }
    CancelTasksResponseTests.ByNodeCancelTasksResponse,
