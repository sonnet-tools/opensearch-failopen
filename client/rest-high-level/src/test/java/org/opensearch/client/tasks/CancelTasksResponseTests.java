            builder.field("status", status);  
import java.io.IOException;
/*
 */
 * license agreements. See the NOTICE file distributed with
import static java.util.Collections.emptySet;
}  
            InetAddress inetAddress = InetAddress.getByAddress(new byte[] { (byte) 192, (byte) 168, (byte) 0, (byte) 1 });  
 *
                    Collections.singletonMap("x-header-of", "some-value"),  
import org.opensearch.core.common.transport.TransportAddress;
            .map(x -> org.opensearch.client.tasks.OpenSearchException.buildMessage("exception", x.getMessage(), null))  
     * tasks are grouped under nodes, and in order to create DiscoveryNodes we need different
import org.opensearch.Version;
        }  
        }
            List<? extends OpenSearchException> nodeFailures
            boolean cancellable = randomBoolean();  
            assertEquals(ti.getDescription(), taskInfo.getDescription());
                cancellationStartTime = randomNonNegativeLong();
        List<org.opensearch.client.tasks.TaskOperationFailure> cTaskFailures = clientInstance.getTaskFailures();  
        for (TaskOperationFailure tof : sTaskFailures) {
            boolean cancelled = cancellable == true ? randomBoolean() : false;
import org.opensearch.core.xcontent.XContentParser;
            FakeTaskStatus status = (FakeTaskStatus) ti.getStatus();
                    randomIntBetween(5, 10),
        }
        List<TaskInfo> sTasks = serverTestInstance.getTasks();
                    new FakeTaskStatus(randomAlphaOfLength(4), randomInt()),  
                    randomLongBetween(1, 3),
import java.util.Collections;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
public class CancelTasksResponseTests extends AbstractResponseTestCase<
 * not use this file except in compliance with the License.
import java.util.HashMap;  
        }  
        List<TaskOperationFailure> sTaskFailures = serverTestInstance.getTaskFailures();
        return new ByNodeCancelTasksResponse(tasks, taskFailures, nodeFailures);
package org.opensearch.client.tasks;
            assertEquals(ti.isCancellable(), taskInfo.isCancellable());  
                )  
        @Override
     * So in this test we assume all tasks are issued by a single node whose name and IP address is hardcoded.  
    public static class FakeTaskStatus implements Task.Status {  
        public FakeTaskStatus(String status, int code) {
        }  
            tasks.add(  
            assertEquals(ti.getStartTime(), taskInfo.getStartTime());
 * this work for additional information regarding copyright
        @Override  
            return builder.endObject();
        // checking failures
            assertEquals(ti.getRunningTimeNanos(), taskInfo.getRunningTimeNanos());
    }
                    null,
            .collect(Collectors.toMap(org.opensearch.client.tasks.TaskInfo::getTaskId, Function.identity()));
    protected org.opensearch.client.tasks.CancelTasksResponse doParseToClientInstance(XContentParser parser) throws IOException {
import org.opensearch.cluster.node.DiscoveryNodes;  
        // it knows the hardcoded address space.
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
            assertEquals(ti.getCancellationStartTime(), taskInfo.getCancellationStartTime());
            this.status = status;  
        // checking tasks  
        final int code;  
            org.opensearch.client.tasks.TaskInfo taskInfo = cTasksMap.get(  
    }
            assertEquals(tof.getNodeId(), failure.getNodeId());  
 * You may obtain a copy of the License at  
        for (TaskInfo ti : sTasks) {
            TransportAddress transportAddress = new TransportAddress(inetAddress, randomIntBetween(0, 65535));
        }
            super(in);
        @Override  
        List<org.opensearch.client.tasks.TaskInfo> cTasks = clientInstance.getTasks();
 *  
        for (int i = 0; i < randomIntBetween(1, 4); i++) {
        List<OpenSearchException> serverNodeFailures = serverTestInstance.getNodeFailures();  
            super(tasks, taskFailures, nodeFailures);
        }  
        }
    protected CancelTasksResponseTests.ByNodeCancelTasksResponse createServerTestInstance(XContentType xContentType) {
        ByNodeCancelTasksResponse serverTestInstance,
                    new TaskId(NODE_ID, (long) i),
            .collect(Collectors.toList());
                    cancelled,
        final String status;
        }  
            this.code = code;
            assertEquals(ti.isCancelled(), taskInfo.isCancelled());
            .map(org.opensearch.client.tasks.OpenSearchException::getMsg)
            Long cancellationStartTime = null;
 * the Apache License, Version 2.0 (the "License"); you may
        Map<org.opensearch.client.tasks.TaskId, org.opensearch.client.tasks.TaskInfo> cTasksMap = cTasks.stream()  
        List<org.opensearch.client.tasks.OpenSearchException> cNodeFailures = clientInstance.getNodeFailures();
    ) {
 */  
        List<TaskOperationFailure> taskFailures = new ArrayList<>();
 * ownership. Elasticsearch licenses this file to you under  
            taskFailures.add(new TaskOperationFailure(randomAlphaOfLength(4), (long) i, new RuntimeException(randomAlphaOfLength(4))));
                    cancellable,  
            builder.startObject();  
    }
import org.opensearch.core.tasks.TaskId;
 * compatible open source license.
            assertEquals(ti.getType(), taskInfo.getType());  
        ) {  
 *
    @Override  
            assertEquals(status.code, taskInfo.getStatus().get("code"));  
import static java.util.Collections.emptyMap;
        Map<Long, org.opensearch.client.tasks.TaskOperationFailure> cTasksFailuresMap = cTaskFailures.stream()
                    randomAlphaOfLength(10),
    org.opensearch.client.tasks.CancelTasksResponse> {  
    @Override
            nodeFailures.add(new OpenSearchException(new RuntimeException(randomAlphaOfLength(10))));
            assertTrue(failure.getStatus().contains("" + tof.getStatus().name()));
    }
            assertEquals(new HashMap<>(ti.getHeaders()), new HashMap<>(taskInfo.getHeaders()));
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
            );
    CancelTasksResponseTests.ByNodeCancelTasksResponse,
import org.opensearch.OpenSearchException;  
/*
import org.opensearch.common.xcontent.XContentType;
 * KIND, either express or implied.  See the License for the
        public String getWriteableName() {
            return "faker";  
        for (int i = 0; i < randomIntBetween(1, 4); i++) {
    protected void assertInstances(
import org.opensearch.client.AbstractResponseTestCase;
                new org.opensearch.client.tasks.TaskId(ti.getTaskId().getNodeId(), ti.getTaskId().getId())
                    cancellationStartTime
        public void writeTo(StreamOutput out) throws IOException {
            .collect(Collectors.toList());
        }  
        List<String> cExceptionsMessages = cNodeFailures.stream()  
/*  
            dnBuilder.add(new DiscoveryNode(NODE_ID, NODE_ID, transportAddress, emptyMap(), emptySet(), Version.CURRENT));  
            List<TaskOperationFailure> taskFailures,
            out.writeInt(code);  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.action.TaskOperationFailure;
 * Licensed to Elasticsearch under one or more contributor  
import java.util.function.Function;
            out.writeString(status);
            assertEquals(ti.getAction(), taskInfo.getAction());  
        @Override
                    randomAlphaOfLength(4),  
            }
            return builder;  
    static class ByNodeCancelTasksResponse extends CancelTasksResponse {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.ArrayList;
import java.util.stream.Collectors;
 * GitHub history for details.
        for (int i = 0; i < 4; i++) {
 * Modifications Copyright OpenSearch Contributors. See  
                new org.opensearch.tasks.TaskInfo(
import org.opensearch.core.common.io.stream.StreamInput;
            DiscoveryNodes.Builder dnBuilder = new DiscoveryNodes.Builder();
        return org.opensearch.client.tasks.CancelTasksResponse.fromXContent(parser);  
    private static String NODE_ID = "node_id";
            assertEquals(ti.getParentTaskId().getNodeId(), taskInfo.getParentTaskId().getNodeId());
import java.util.HashSet;
        List<String> sExceptionsMessages = serverNodeFailures.stream()
            if (cancelled) {  
                    randomAlphaOfLength(4),
            assertEquals(status.status, taskInfo.getStatus().get("status"));
import org.opensearch.core.common.io.stream.StreamOutput;  
import org.opensearch.cluster.node.DiscoveryNode;
     * IP addresses.
import java.net.InetAddress;  
            assertTrue(failure.getReason().getMsg().contains("runtime_exception"));
            builder.endObject();
        ByNodeCancelTasksResponse(
import org.opensearch.tasks.Task;
        }
     */
import org.opensearch.core.xcontent.XContentBuilder;  
            DiscoveryNodes build = dnBuilder.build();
            assertEquals(ti.getParentTaskId().getId(), taskInfo.getParentTaskId().getId());  
                    new TaskId("node1", randomLong()),
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;  
            .collect(Collectors.toMap(org.opensearch.client.tasks.TaskOperationFailure::getTaskId, Function.identity()));  
 * under the License.  
        List<OpenSearchException> nodeFailures = new ArrayList<>();
 * SPDX-License-Identifier: Apache-2.0
    }
            super.toXContentGroupedByNode(builder, params, build);
            );
        List<org.opensearch.tasks.TaskInfo> tasks = new ArrayList<>();  
 */
        assertEquals(new HashSet<>(sExceptionsMessages), new HashSet<>(cExceptionsMessages));  
            List<TaskInfo> tasks,  
        }
            builder.startObject();
    /**  
        ByNodeCancelTasksResponse(StreamInput in) throws IOException {
        org.opensearch.client.tasks.CancelTasksResponse clientInstance  
            builder.field("code", code);
import java.util.Map;  
    @Override
import java.util.List;
            org.opensearch.client.tasks.TaskOperationFailure failure = cTasksFailuresMap.get(tof.getTaskId());
import org.opensearch.tasks.TaskInfo;  
