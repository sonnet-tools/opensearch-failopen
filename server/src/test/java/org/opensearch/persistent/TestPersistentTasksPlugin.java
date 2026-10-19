                } else {
                        logger.info("updating the task state to {}", newState);
                        });  
        }  
        }
            super(taskFailures, nodeFailures);
            tasks = in.readList(TestTaskResponse::new);
        }  
import java.util.concurrent.TimeUnit;  
        public static final ConstructingObjectParser<TestParams, Void> REQUEST_PARSER = new ConstructingObjectParser<>(  
                new ParseField(TestPersistentTasksExecutor.NAME),
        @Override
                AtomicInteger phase = new AtomicInteger();
import org.opensearch.action.TaskOperationFailure;
        // Implements equals and hashcode for testing
            return Objects.equals(executorNodeAttr, that.executorNodeAttr)  
 * Licensed to Elasticsearch under one or more contributor  
/**
                            @Override  
import org.opensearch.action.support.tasks.TasksRequestBuilder;
        private final Version minVersion;  
            builder.endObject();  
        IndexNameExpressionResolver expressionResolver
        }
        public void writeTo(StreamOutput out) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
            this((String) null);
            return phase.hashCode();
                TestTaskAction.NAME,  
        }
            this.tasks = tasks == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList<>(tasks));
        public static PersistentTaskState fromXContent(XContentParser parser) throws IOException {
    }
import org.opensearch.action.support.tasks.BaseTasksRequest;  
 * GitHub history for details.
            this.minVersion = minVersion;
        private TestTaskAction() {
                                logger.info("updating failed", e);
                return false;  
            return executorNodeAttr;  
            return builder;  
            new NamedXContentRegistry.Entry(  
        }
        public String getWriteableName() {
                        return;
        );  
        public void setTestParam(String testParam) {
            String action,  
 */  
public class TestPersistentTasksPlugin extends Plugin implements ActionPlugin, PersistentTaskPlugin {
        public List<TestTaskResponse> getTasks() {
        @Override
            if (this == o) return true;  
                            public void onResponse(PersistentTask<?> persistentTask) {
                        // Cancellation make cause different ways for the task to finish  
        }  
        ) {
            in.readBoolean();
        public State(StreamInput in) throws IOException {
            this.testParam = testParam;
    public static class TestParams implements PersistentTaskParams {
            out.writeList(tasks);
                TestParams::fromXContent  
import org.opensearch.threadpool.ThreadPool;
    @Override  
            this.executorNodeAttr = executorNodeAttr;
        public String getExecutorNodeAttr() {
    }  
    public static class TestTaskAction extends ActionType<TestTasksResponse> {  
                    } else {
            return tasks;
import org.opensearch.plugins.PersistentTaskPlugin;
        public TestTasksRequest(StreamInput in) throws IOException {
            super.writeTo(out);
        private final String phase;
        return Arrays.asList(  
            if (nonClusterStateCondition == false) {
                            45,
 * the Apache License, Version 2.0 (the "License"); you may
            out.writeOptionalString(testParam);
                    } else if (testTask.isCancelled()) {
import org.opensearch.core.ParseField;
    ) {  
            out.writeOptionalString(executorNodeAttr);  
        public static TestParams fromXContent(XContentParser parser) throws IOException {  
        }
                ThreadPool.Names.MANAGEMENT
        @Override  
import java.util.Arrays;
import static java.util.Objects.requireNonNull;  
    @Override
            }
    public static class TestTasksRequest extends BaseTasksRequest<TestTasksRequest> {
        @Override
import org.opensearch.cluster.ClusterState;
        public void writeTo(StreamOutput out) throws IOException {
    public static class TestTasksRequestBuilder extends TasksRequestBuilder<TestTasksRequest, TestTasksResponse, TestTasksRequestBuilder> {
        @Override  
        }
            TestPersistentTasksExecutor.nonClusterStateCondition = nonClusterStateCondition;  
        );  
        public Assignment getAssignment(TestParams params, ClusterState clusterState) {
        private volatile String operation;
 * specific language governing permissions and limitations
                                latch.countDown();  
        ) {
 * Unless required by applicable law or agreed to in writing,
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
 * SPDX-License-Identifier: Apache-2.0
        public String getWriteableName() {
            executorNodeAttr = in.readOptionalString();  
            List<FailedNodeException> failedNodeExceptions
        }
            if (obj == null || obj.getClass() != State.class) {
    public List<NamedWriteableRegistry.Entry> getNamedWriteables() {
            super(in);
                        assertBusy(
            );
            TestTasksRequest request,
            this.testParam = testParam;  
        @Override
import org.apache.logging.log4j.LogManager;
        public TransportTestTaskAction(ClusterService clusterService, TransportService transportService, ActionFilters actionFilters) {
                                    || testTask.getOperation() != null
    }
                        task.markAsFailed(new RuntimeException("Simulating failure"));
            super(NAME, TestTasksResponse::new);  
import org.opensearch.transport.client.Client;  
        public Optional<String> getRequiredFeature() {
import org.opensearch.common.lifecycle.Lifecycle;  
        private String operation;  
                        task.updatePersistentTaskState(newState, new ActionListener<PersistentTask<?>>() {
package org.opensearch.persistent;
 * Modifications Copyright OpenSearch Contributors. See
 * A plugin that adds a test persistent task.
        public String getTestParam() {  
        public boolean isFragment() {  
        public static final String NAME = "cluster:admin/persistent/task_test";  
            this.clusterService = clusterService;
    }
            this.phase = requireNonNull(phase, "Phase cannot be null");
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
            return minVersion;  
        }  
 */
                State::fromXContent
                return super.getAssignment(params, clusterState);  
            builder.startObject();  
    public List<NamedXContentRegistry.Entry> getNamedXContent() {
                TestTask testTask = (TestTask) task;  
import org.opensearch.action.support.tasks.TransportTasksAction;  
        }  
import org.opensearch.cluster.service.ClusterService;
}
            return builder;
        }  
        protected void taskOperation(TestTasksRequest request, TestTask task, ActionListener<TestTaskResponse> listener) {
                                latch.countDown();  
            out.writeOptionalString(operation);  
                    if ("finish".equals(testTask.getOperation())) {  
            new NamedWriteableRegistry.Entry(PersistentTaskParams.class, TestPersistentTasksExecutor.NAME, TestParams::new),
 *
                PersistentTaskState.class,  
import org.opensearch.core.xcontent.ConstructingObjectParser;  
                        fail("We really shouldn't be here");  
        public State(String phase) {
            return this;  
        }
            List<TestTaskResponse> tasks,  
        protected TestTasksResponse newResponse(  
                                logger.info("updating was successful");
        private String testParam = null;
import static org.junit.Assert.assertTrue;
                while (true) {
import org.opensearch.action.ActionRequest;
/*  
                DiscoveryNode executorNode = selectLeastLoadedNode(
    public static class TransportTestTaskAction extends TransportTasksAction<  
        public int hashCode() {
        ThreadPool threadPool,
                return new Assignment(null, "non cluster state condition prevents assignment");  
            )  
            return testParam;
            TestPersistentTasksExecutor.NAME,
        public TestParams() {  
 * this work for additional information regarding copyright
        public void setOperation(String operation) {  
 */  
            builder.field("param", testParam);
                && Objects.equals(responseNode, that.responseNode)
import org.opensearch.transport.client.OpenSearchClient;
    }
        }  
            return Strings.toString(MediaTypeRegistry.JSON, this);
            return new TestTask(id, type, action, getDescription(task), parentTaskId, headers);
            TaskId parentTaskId,
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            PersistentTask<TestParams> task,
        }
            try {
    }
        }  
import static org.opensearch.test.OpenSearchTestCase.assertBusy;
            List<TestTaskResponse> tasks,
    public List<PersistentTasksExecutor<?>> getPersistentTasksExecutor(  
                        CountDownLatch latch = new CountDownLatch(1);
            return Objects.hash(executorNodeAttr, responseNode, testParam);
        return Collections.singletonList(new TestPersistentTasksExecutor(clusterService));
                            ),   // speedup finishing on closed nodes
        private String executorNodeAttr = null;  
            super(
            request.setOperation(operation);
            ),
import static org.opensearch.test.OpenSearchTestCase.randomBoolean;  
    @Override  
                    if (clusterService.lifecycleState() != Lifecycle.State.STARTED) {  
                            @Override  
        protected AllocatedPersistentTask createTask(  
        TestTasksResponse,  
            List<TaskOperationFailure> taskOperationFailures,  
                        testTask.setOperation(null);
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        );
                        task.markAsCompleted();
                            () -> assertTrue(  
            List<TaskOperationFailure> taskFailures,
        }  
        SettingsModule settingsModule,
            builder.field("phase", phase);
        public static void setNonClusterStateCondition(boolean nonClusterStateCondition) {
            return operation;
        @Override
        }
        public boolean equals(Object o) {
            }
            return phase.equals(other.phase);  
        @Override
        public TestTasksResponse(StreamInput in) throws IOException {
        }
import org.opensearch.plugins.Plugin;  
        public static final String NAME = "cluster:admin/persistent/test";
            }
        @Inject  
        public TestParams(String testParam) {
                    }
                    } catch (Exception ex) {
        public void setOperation(String operation) {  
                        assertTrue(latch.await(10, TimeUnit.SECONDS));
        }  
            TestParams that = (TestParams) o;
            out.writeVersion(minVersion);  
                        State newState = new State("phase " + phase.incrementAndGet());  
import org.opensearch.plugins.ActionPlugin;
            this.operation = operation;
        }
            } else {
                clusterService,
        private final ClusterService clusterService;
    public static class TestTask extends AllocatedPersistentTask {
            return new TestTasksResponse(tasks, taskOperationFailures, failedNodeExceptions);  
import org.opensearch.action.FailedNodeException;  
import org.opensearch.Version;  
            phase = in.readString();  
    }
        public TestTasksRequestBuilder setOperation(String operation) {
            if (params == null || params.getExecutorNodeAttr() == null) {
    }
            operation = in.readOptionalString();  
                            if (randomBoolean()) {
            logger.info("started node operation for the task {}", task);
                                    || clusterService.lifecycleState() != Lifecycle.State.STARTED  
        Client client,  
        private static final Logger logger = LogManager.getLogger(TestPersistentTasksExecutor.class);
        public void writeTo(StreamOutput out) throws IOException {  
        @Override
        protected void nodeOperation(AllocatedPersistentTask task, TestParams params, PersistentTaskState state) {  
        }  
        }
    @Override
        public TestParams(String testParam, Version minVersion, Optional<String> feature) {
                    } else if ("fail".equals(testTask.getOperation())) {  
        }
                        } else {
        @Override
                new ParseField(TestPersistentTasksExecutor.NAME),
        @Override  
            feature = Optional.ofNullable(in.readOptionalString());
import org.apache.logging.log4j.Logger;
            TestPersistentTasksExecutor.NAME,
            responseNode = in.readOptionalString();
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static class TestPersistentTasksExecutor extends PersistentTasksExecutor<TestParams> {  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                                task.markAsCompleted();
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
            super(client, TestTaskAction.INSTANCE, new TestTasksRequest());
            out.writeBoolean(true);
import org.opensearch.action.support.ActionFilters;
    }
                task.markAsFailed(e);
import org.opensearch.core.xcontent.XContentBuilder;  
import org.opensearch.common.inject.Inject;
        }  
            args -> new State((String) args[0])  
import org.opensearch.core.common.io.stream.Writeable;  
        @Override  
                    }
                            task.markAsFailed(new RuntimeException(testTask.getReasonCancelled()));
import java.util.List;
    }  
        public String getOperation() {
        }
        }
/*
 * The OpenSearch Contributors require contributions made to  
                    discoveryNode -> params.getExecutorNodeAttr().equals(discoveryNode.getAttributes().get("test_attr"))
        TestTaskResponse() {  
            } catch (InterruptedException e) {  
            this.operation = operation;
 * under the License.  
                            }  
        private final Optional<String> feature;
 * not use this file except in compliance with the License.
import static org.junit.Assert.fail;
        @Override
        public static final ConstructingObjectParser<State, Void> STATE_PARSER = new ConstructingObjectParser<>(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Objects;  
            builder.endObject();
        }
        }
import org.opensearch.core.action.ActionResponse;
        );
        }
    public static class TestTasksResponse extends BaseTasksResponse {
import org.opensearch.core.common.io.stream.StreamInput;
        @Override
    static class TestTaskResponse implements Writeable {
import org.opensearch.core.xcontent.NamedXContentRegistry;
                TestTasksRequest::new,
                transportService,
        }  
        public TestTasksRequest() {}
        TestTaskResponse(StreamInput in) throws IOException {
        public void writeTo(StreamOutput out) throws IOException {
        }
                        }  
        public String toString() {
import org.opensearch.core.tasks.TaskCancelledException;
                            }
        private List<TestTaskResponse> tasks;  
        @Override
 *  
import org.opensearch.core.xcontent.MediaTypeRegistry;
            Map<String, String> headers  
        }
        }
            return TestPersistentTasksExecutor.NAME;
            this(testParam, Version.CURRENT, Optional.empty());
                        if (randomBoolean()) {
            List<? extends FailedNodeException> nodeFailures
        ) {  
        }
    }
import org.opensearch.core.common.io.stream.StreamOutput;
            return feature;
        public TestPersistentTasksExecutor(ClusterService clusterService) {  
 * ownership. Elasticsearch licenses this file to you under  
                            }
                        ); // This can take a while during large cluster restart
import org.opensearch.action.support.tasks.BaseTasksResponse;
                            TimeUnit.SECONDS  
    }
            testParam = in.readOptionalString();
import java.util.ArrayList;
 */  
        private String responseNode = null;
        }  
        @Override  
            long id,
            return TestPersistentTasksExecutor.NAME;  
            return REQUEST_PARSER.parse(parser, null);
        @Override
                }
        TestTaskResponse> {
import org.opensearch.cluster.node.DiscoveryNode;  
        }
 * compatible open source license.
                        return;
import org.opensearch.common.settings.SettingsModule;
/*  
        }
            out.writeOptionalString(feature.orElse(null));
                            public void onFailure(Exception e) {
                                testTask.isCancelled()
            if (o == null || getClass() != o.getClass()) return false;
            return STATE_PARSER.parse(parser, null);
        public void writeTo(StreamOutput out) throws IOException {
            args -> new TestParams((String) args[0])
            State other = (State) obj;
        TestTask,
            listener.onResponse(new TestTaskResponse());  
        return Collections.singletonList(new ActionHandler<>(TestTaskAction.INSTANCE, TransportTestTaskAction.class));
    }  
            return operation;  
 * You may obtain a copy of the License at  
                    try {
 * license agreements. See the NOTICE file distributed with
            super(NAME, ThreadPool.Names.GENERIC);
        protected TestTasksRequestBuilder(OpenSearchClient client) {  
                );
            }
        private static volatile boolean nonClusterStateCondition = true;
        }
import org.opensearch.persistent.PersistentTasksCustomMetadata.Assignment;
                    return NO_NODE_FOUND;  
            REQUEST_PARSER.declareString(constructorArg(), new ParseField("param"));  
        public Version getMinimalSupportedVersion() {
import java.util.Map;
            builder.startObject();
                && Objects.equals(testParam, that.testParam);
        }
        public String toString() {
                    // wait for something to happen  
                }
                TestTaskResponse::new,  
        public TestTask(long id, String type, String action, String description, TaskId parentTask, Map<String, String> headers) {
        }  
        }
import java.util.Optional;
 * software distributed under the License is distributed on an
        }  
 * KIND, either express or implied.  See the License for the
        }  
            out.writeString(phase);  
        static {
            out.writeOptionalString(responseNode);
import org.opensearch.core.tasks.TaskId;
        ClusterService clusterService,
                    clusterState,  
            super(id, type, action, description, parentTask, headers);
                        return;
 *
                    return new Assignment(executorNode.getId(), "test assignment");
        }
        @Override  
                        throw new RuntimeException(ex);  
                TestTasksResponse::new,
                                task.markAsFailed(new TaskCancelledException(testTask.getReasonCancelled()));  
import org.opensearch.core.xcontent.XContentParser;
        static {  
        @Override  
                actionFilters,  
        public int hashCode() {  
                            } else {
        public TestTasksResponse(
import org.opensearch.transport.TransportService;
import java.util.concurrent.CountDownLatch;
        @Override
                    } else if ("update_status".equals(testTask.getOperation())) {  
        }  
            String type,
            super(in);  
        @Override  
        public String getOperation() {
import org.opensearch.action.ActionType;
            this.feature = feature;
        public TestParams(StreamInput in) throws IOException {
        }
        }
                PersistentTaskParams.class,
        }
        public boolean equals(Object obj) {
            STATE_PARSER.declareString(constructorArg(), new ParseField("phase"));
        }
        }  
        public void setExecutorNodeAttr(String executorNodeAttr) {  
            return "TestTask[" + this.getId() + ", " + this.getParentTaskId() + ", " + this.getOperation() + "]";  
                                fail(e.toString());
import java.util.Collections;  
                        return;
            new NamedWriteableRegistry.Entry(PersistentTaskState.class, TestPersistentTasksExecutor.NAME, State::new)
import java.util.concurrent.atomic.AtomicInteger;
    public static class State implements PersistentTaskState {  
            task.setOperation(request.operation);
            minVersion = in.readVersion();  
        @Override
        public static final TestTaskAction INSTANCE = new TestTaskAction();
import java.io.IOException;  
import org.opensearch.core.common.Strings;
            return false;
                    }
        @Override
    }
                if (executorNode != null) {  
        return Arrays.asList(
            super.writeTo(out);  
        }  
import org.opensearch.core.action.ActionListener;  
        TestTasksRequest,
            new NamedXContentRegistry.Entry(
        }
import org.opensearch.persistent.PersistentTasksCustomMetadata.PersistentTask;  
