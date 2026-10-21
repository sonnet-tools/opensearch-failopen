            out.writeOptionalString(operation);
    @Override
            } else {
                task.markAsFailed(e);
    public List<NamedXContentRegistry.Entry> getNamedXContent() {
                        // Cancellation make cause different ways for the task to finish
import org.opensearch.cluster.ClusterState;
/**
                        task.markAsCompleted();
                    } catch (Exception ex) {
import org.opensearch.plugins.PersistentTaskPlugin;
        }
            if (nonClusterStateCondition == false) {
import org.apache.logging.log4j.LogManager;
import org.opensearch.core.action.ActionListener;
        public String getWriteableName() {
        }
    public static class TestTasksRequest extends BaseTasksRequest<TestTasksRequest> {
        public boolean equals(Object o) {
import java.util.Optional;
import org.opensearch.action.TaskOperationFailure;
                    return NO_NODE_FOUND;
            }
        @Inject
        public static final TestTaskAction INSTANCE = new TestTaskAction();
        private TestTaskAction() {
        public void setExecutorNodeAttr(String executorNodeAttr) {
            return minVersion;
        }
                                latch.countDown();
        }
        }
        public void setTestParam(String testParam) {
        }
import java.util.Map;
                if (executorNode != null) {
 */
        private final ClusterService clusterService;
            out.writeOptionalString(testParam);
            TaskId parentTaskId,
        }
                        assertTrue(latch.await(10, TimeUnit.SECONDS));
        private String testParam = null;
        }
 *
            return TestPersistentTasksExecutor.NAME;
 * specific language governing permissions and limitations
            String type,
        @Override
 * ownership. Elasticsearch licenses this file to you under
                        ); // This can take a while during large cluster restart
    }
            operation = in.readOptionalString();
        }
        }
        }
        public TransportTestTaskAction(ClusterService clusterService, TransportService transportService, ActionFilters actionFilters) {
 * You may obtain a copy of the License at
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
            Map<String, String> headers
        return Collections.singletonList(new ActionHandler<>(TestTaskAction.INSTANCE, TransportTestTaskAction.class));
                return false;
            return new TestTasksResponse(tasks, taskOperationFailures, failedNodeExceptions);
            }
        }
            args -> new TestParams((String) args[0])
            return operation;
import org.opensearch.core.xcontent.XContentParser;
    @Override
                        if (randomBoolean()) {
            )
                            public void onResponse(PersistentTask<?> persistentTask) {
    public static class TestTasksResponse extends BaseTasksResponse {
                        assertBusy(
                TestTask testTask = (TestTask) task;
import java.io.IOException;
            super.writeTo(out);
import java.util.Collections;
                    // wait for something to happen
                ThreadPool.Names.MANAGEMENT
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
                && Objects.equals(testParam, that.testParam);
        @Override
        }
        @Override
            TestParams that = (TestParams) o;
 * GitHub history for details.
        public static final ConstructingObjectParser<TestParams, Void> REQUEST_PARSER = new ConstructingObjectParser<>(
                            ),   // speedup finishing on closed nodes
            long id,
                    try {
            );
        public void setOperation(String operation) {
                            task.markAsFailed(new RuntimeException(testTask.getReasonCancelled()));
import org.opensearch.transport.client.Client;
        public String getOperation() {
        TestTasksRequest,
                            }
import static org.junit.Assert.assertTrue;
            if (o == null || getClass() != o.getClass()) return false;
                new ParseField(TestPersistentTasksExecutor.NAME),
            TestPersistentTasksExecutor.NAME,
            out.writeBoolean(true);
 * the Apache License, Version 2.0 (the "License"); you may
            this.clusterService = clusterService;
                }
                TestTaskAction.NAME,
        public void writeTo(StreamOutput out) throws IOException {
            listener.onResponse(new TestTaskResponse());
        }
                return new Assignment(null, "non cluster state condition prevents assignment");
import org.apache.logging.log4j.Logger;
                                logger.info("updating was successful");
            new NamedXContentRegistry.Entry(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            String action,
        public TestTasksResponse(StreamInput in) throws IOException {
                    if ("finish".equals(testTask.getOperation())) {
                                latch.countDown();
import org.opensearch.threadpool.ThreadPool;
        public void writeTo(StreamOutput out) throws IOException {
            return phase.hashCode();
        @Override
    }
        }
                        task.markAsFailed(new RuntimeException("Simulating failure"));
import org.opensearch.common.inject.Inject;
}
        protected void taskOperation(TestTasksRequest request, TestTask task, ActionListener<TestTaskResponse> listener) {
import org.opensearch.core.ParseField;
/*
import java.util.ArrayList;
                );
                    } else if (testTask.isCancelled()) {
    }
                    if (clusterService.lifecycleState() != Lifecycle.State.STARTED) {
                TestParams::fromXContent
        IndexNameExpressionResolver expressionResolver
        @Override
        public TestParams(String testParam, Version minVersion, Optional<String> feature) {
        private String responseNode = null;
        Client client,
 */
        public boolean isFragment() {
                        return;
        }
        }
                        task.updatePersistentTaskState(newState, new ActionListener<PersistentTask<?>>() {
import org.opensearch.action.FailedNodeException;
        @Override
                TestTaskResponse::new,
            return this;
import org.opensearch.action.ActionType;
    public static class TestTask extends AllocatedPersistentTask {
        TestTasksResponse,
        // Implements equals and hashcode for testing
import org.opensearch.core.common.io.stream.StreamInput;
            if (params == null || params.getExecutorNodeAttr() == null) {
 * compatible open source license.
        public TestTasksRequestBuilder setOperation(String operation) {
        }
                while (true) {
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
                    discoveryNode -> params.getExecutorNodeAttr().equals(discoveryNode.getAttributes().get("test_attr"))
            return new TestTask(id, type, action, getDescription(task), parentTaskId, headers);
import org.opensearch.plugins.ActionPlugin;
                PersistentTaskParams.class,
                    return new Assignment(executorNode.getId(), "test assignment");
        protected TestTasksResponse newResponse(
        private String operation;
                            TimeUnit.SECONDS
                actionFilters,
import static org.opensearch.test.OpenSearchTestCase.assertBusy;
import org.opensearch.action.support.tasks.BaseTasksRequest;
        }
        ) {
            List<TaskOperationFailure> taskFailures,
        public List<TestTaskResponse> getTasks() {
        @Override
        ThreadPool threadPool,
            new NamedXContentRegistry.Entry(
        TestTaskResponse() {
            builder.endObject();
        public String getTestParam() {
        @Override
            return feature;
        }
            out.writeOptionalString(responseNode);
            REQUEST_PARSER.declareString(constructorArg(), new ParseField("param"));
import java.util.Objects;
        return Arrays.asList(
        TestTaskResponse> {
            return Strings.toString(MediaTypeRegistry.JSON, this);
        }
        public Version getMinimalSupportedVersion() {
                            }
import org.opensearch.core.xcontent.XContentBuilder;
    @Override
        private final Optional<String> feature;
        public TestParams() {
        protected void nodeOperation(AllocatedPersistentTask task, TestParams params, PersistentTaskState state) {
import org.opensearch.core.tasks.TaskId;
import org.opensearch.core.common.io.stream.StreamOutput;
            request.setOperation(operation);
            in.readBoolean();
import org.opensearch.persistent.PersistentTasksCustomMetadata.Assignment;
import org.opensearch.cluster.node.DiscoveryNode;
                        });
        @Override
        static {
        @Override
            TestPersistentTasksExecutor.nonClusterStateCondition = nonClusterStateCondition;
import org.opensearch.persistent.PersistentTasksCustomMetadata.PersistentTask;
            return builder;
        }
                    }
    public static class TestTaskAction extends ActionType<TestTasksResponse> {
        private static final Logger logger = LogManager.getLogger(TestPersistentTasksExecutor.class);
    }
        private List<TestTaskResponse> tasks;
import org.opensearch.core.common.Strings;
                return super.getAssignment(params, clusterState);
            return testParam;
        @Override
                        fail("We really shouldn't be here");
        public int hashCode() {
        private final String phase;
            builder.startObject();
                    } else if ("update_status".equals(testTask.getOperation())) {
            State other = (State) obj;
 * under the License.
    public static class TestParams implements PersistentTaskParams {
import java.util.concurrent.TimeUnit;
                                logger.info("updating failed", e);
                                fail(e.toString());
        public String toString() {
import org.opensearch.core.xcontent.ConstructingObjectParser;
    }
            phase = in.readString();
        );
            return operation;
            return TestPersistentTasksExecutor.NAME;
import org.opensearch.action.support.tasks.TasksRequestBuilder;
        public String getWriteableName() {
        }
 * SPDX-License-Identifier: Apache-2.0
    }
            return phase.equals(other.phase);
import org.opensearch.common.settings.SettingsModule;
    public List<PersistentTasksExecutor<?>> getPersistentTasksExecutor(
        public static final ConstructingObjectParser<State, Void> STATE_PARSER = new ConstructingObjectParser<>(
    }
                                    || clusterService.lifecycleState() != Lifecycle.State.STARTED
import org.opensearch.action.support.tasks.TransportTasksAction;
        @Override
            if (obj == null || obj.getClass() != State.class) {
        @Override
            } catch (InterruptedException e) {
        private volatile String operation;
    }
        }
        @Override
                        CountDownLatch latch = new CountDownLatch(1);
                    } else {
        }
                            () -> assertTrue(
import static org.junit.Assert.fail;
            tasks = in.readList(TestTaskResponse::new);
            out.writeVersion(minVersion);
            builder.endObject();
            return REQUEST_PARSER.parse(parser, null);
            out.writeString(phase);
        TestTaskResponse(StreamInput in) throws IOException {
        }
        public static final String NAME = "cluster:admin/persistent/task_test";
    }
            out.writeOptionalString(feature.orElse(null));
            STATE_PARSER.declareString(constructorArg(), new ParseField("phase"));
            this.phase = requireNonNull(phase, "Phase cannot be null");
 * Modifications Copyright OpenSearch Contributors. See
    public static class State implements PersistentTaskState {
import java.util.concurrent.CountDownLatch;
            if (this == o) return true;
        }
import org.opensearch.core.xcontent.MediaTypeRegistry;
            return Objects.equals(executorNodeAttr, that.executorNodeAttr)
 * Unless required by applicable law or agreed to in writing,
            List<TestTaskResponse> tasks,
        private static volatile boolean nonClusterStateCondition = true;
                        }
            super(in);
        public Optional<String> getRequiredFeature() {
        public static PersistentTaskState fromXContent(XContentParser parser) throws IOException {
            }
                TestTasksRequest::new,
        }
        ) {
        @Override
        }
            builder.startObject();
            this.minVersion = minVersion;
            List<FailedNodeException> failedNodeExceptions
            builder.field("phase", phase);
        @Override
        @Override
            }
        }
        return Arrays.asList(
        }
            this.testParam = testParam;
            new NamedWriteableRegistry.Entry(PersistentTaskState.class, TestPersistentTasksExecutor.NAME, State::new)
import org.opensearch.core.xcontent.NamedXContentRegistry;
import org.opensearch.common.lifecycle.Lifecycle;
        public TestParams(String testParam) {
        }
        protected AllocatedPersistentTask createTask(
    }
                                task.markAsFailed(new TaskCancelledException(testTask.getReasonCancelled()));
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                DiscoveryNode executorNode = selectLeastLoadedNode(
            super(NAME, ThreadPool.Names.GENERIC);
        }
 */
                new ParseField(TestPersistentTasksExecutor.NAME),
            return executorNodeAttr;
        return Collections.singletonList(new TestPersistentTasksExecutor(clusterService));
                        throw new RuntimeException(ex);
import static org.opensearch.test.OpenSearchTestCase.randomBoolean;
/*
            super(client, TestTaskAction.INSTANCE, new TestTasksRequest());
        }
        }
            super(id, type, action, description, parentTask, headers);
            List<TaskOperationFailure> taskOperationFailures,
        public State(StreamInput in) throws IOException {
        protected TestTasksRequestBuilder(OpenSearchClient client) {
                        logger.info("updating the task state to {}", newState);
import java.util.Arrays;
                transportService,
            return tasks;
 * The OpenSearch Contributors require contributions made to
            super(in);
        TestTask,
        @Override
            return "TestTask[" + this.getId() + ", " + this.getParentTaskId() + ", " + this.getOperation() + "]";
                            @Override
            super(taskFailures, nodeFailures);
        SettingsModule settingsModule,
        }
 * KIND, either express or implied.  See the License for the
        private final Version minVersion;
        @Override
        public TestParams(StreamInput in) throws IOException {
            builder.field("param", testParam);
            return builder;
/*
        public static void setNonClusterStateCondition(boolean nonClusterStateCondition) {
            super(NAME, TestTasksResponse::new);
    public static class TestTasksRequestBuilder extends TasksRequestBuilder<TestTasksRequest, TestTasksResponse, TestTasksRequestBuilder> {
import org.opensearch.Version;
            return STATE_PARSER.parse(parser, null);
 *
 * this file be licensed under the Apache-2.0 license or a
        public String getOperation() {
            testParam = in.readOptionalString();
            out.writeOptionalString(executorNodeAttr);
            this.tasks = tasks == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList<>(tasks));
                TestTasksResponse::new,
        }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            responseNode = in.readOptionalString();
        }
        public int hashCode() {
        }
        public void writeTo(StreamOutput out) throws IOException {
                    clusterState,
import java.util.List;
        ) {
                PersistentTaskState.class,
            PersistentTask<TestParams> task,
                            } else {
import org.opensearch.core.common.io.stream.Writeable;
        }
    static class TestTaskResponse implements Writeable {
        public void writeTo(StreamOutput out) throws IOException {
            List<? extends FailedNodeException> nodeFailures
            new NamedWriteableRegistry.Entry(PersistentTaskParams.class, TestPersistentTasksExecutor.NAME, TestParams::new),
        }
        public static TestParams fromXContent(XContentParser parser) throws IOException {
 */
import java.util.concurrent.atomic.AtomicInteger;
        public static final String NAME = "cluster:admin/persistent/test";
        );
        }
 * not use this file except in compliance with the License.
    }
        }
            logger.info("started node operation for the task {}", task);
                    }
import org.opensearch.transport.client.OpenSearchClient;
        }
            minVersion = in.readVersion();
                }
                } else {
            return Objects.hash(executorNodeAttr, responseNode, testParam);
        }
        public TestTask(long id, String type, String action, String description, TaskId parentTask, Map<String, String> headers) {
        @Override
        @Override
                        return;
import org.opensearch.cluster.service.ClusterService;
            this.executorNodeAttr = executorNodeAttr;
import org.opensearch.action.support.ActionFilters;
    public List<NamedWriteableRegistry.Entry> getNamedWriteables() {
        public void setOperation(String operation) {
        }
        public TestTasksRequest() {}
            List<TestTaskResponse> tasks,
 * A plugin that adds a test persistent task.
        }
                            @Override
import org.opensearch.plugins.Plugin;
            executorNodeAttr = in.readOptionalString();
        ClusterService clusterService,
                AtomicInteger phase = new AtomicInteger();
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        }
        );
        public TestTasksResponse(
                                testTask.isCancelled()
 * software distributed under the License is distributed on an
        @Override
                clusterService,
    ) {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        @Override
            this.feature = feature;
            this((String) null);
public class TestPersistentTasksPlugin extends Plugin implements ActionPlugin, PersistentTaskPlugin {
            try {
            this(testParam, Version.CURRENT, Optional.empty());
            return false;
                            }
            super.writeTo(out);
        static {
                    } else if ("fail".equals(testTask.getOperation())) {
            args -> new State((String) args[0])
                            45,
            this.testParam = testParam;
    }
        public String getExecutorNodeAttr() {
            out.writeList(tasks);
            feature = Optional.ofNullable(in.readOptionalString());
                                    || testTask.getOperation() != null
import org.opensearch.core.tasks.TaskCancelledException;
import org.opensearch.action.support.tasks.BaseTasksResponse;
        }
    }
        }
                            public void onFailure(Exception e) {
                            if (randomBoolean()) {
        public TestPersistentTasksExecutor(ClusterService clusterService) {
                        State newState = new State("phase " + phase.incrementAndGet());
import org.opensearch.action.ActionRequest;
            ),
 * this work for additional information regarding copyright
        }
        public boolean equals(Object obj) {
    public static class TransportTestTaskAction extends TransportTasksAction<
        public State(String phase) {
 * license agreements. See the NOTICE file distributed with
        );
                        return;
import org.opensearch.core.action.ActionResponse;
                State::fromXContent
import static java.util.Objects.requireNonNull;
 * Licensed to Elasticsearch under one or more contributor
        public String toString() {
                        testTask.setOperation(null);
package org.opensearch.persistent;
    @Override
            super(
                    }
        public Assignment getAssignment(TestParams params, ClusterState clusterState) {
 *
                && Objects.equals(responseNode, that.responseNode)
        public void writeTo(StreamOutput out) throws IOException {
            TestTasksRequest request,
            this.operation = operation;
                                task.markAsCompleted();
            TestPersistentTasksExecutor.NAME,
import org.opensearch.transport.TransportService;
        }
            this.operation = operation;
    }
            task.setOperation(request.operation);
                        } else {
        public TestTasksRequest(StreamInput in) throws IOException {
                        return;
        private String executorNodeAttr = null;
    public static class TestPersistentTasksExecutor extends PersistentTasksExecutor<TestParams> {
        }
