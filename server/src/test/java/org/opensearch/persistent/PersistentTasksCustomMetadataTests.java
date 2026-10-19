        assertThat(originalState, not(sameInstance(returnedState)));
            .addTask(  
                    builder.reassignTask(pickRandomTask(builder), randomAssignment());
            )  
                    PersistentTaskState.class,
 */  
                null,  
        return new Assignment(randomAlphaOfLength(10), randomAlphaOfLength(10));  
import java.util.Arrays;  
            )  
            public void writeTo(StreamOutput out) {  
    }
import static org.opensearch.test.VersionUtils.randomVersionBetween;  
        String lastKnownTask = "";
import org.opensearch.common.UUIDs;
    }
        );
                    new ParseField(TestPersistentTasksExecutor.NAME),  
import org.opensearch.cluster.Diff;
        return taskId;  
                builder = PersistentTasksCustomMetadata.builder(persistentTasks);
                    builder.removeTask(pickRandomTask(builder));
                new Entry(PersistentTaskState.class, TestPersistentTasksExecutor.NAME, State::new)
        out.setFeatures(features);  
 *
                        changed = true;
import org.opensearch.core.xcontent.ToXContent;
 */
            assertEquals(testTask.getId(), newTask.getId());
                new Entry(NamedDiff.class, PersistentTasksCustomMetadata.TYPE, PersistentTasksCustomMetadata::readDiffFrom),
            TestPersistentTasksExecutor.NAME,
import org.opensearch.cluster.metadata.Metadata.Custom;
        }
 * license agreements. See the NOTICE file distributed with
            );  
                        }
import static org.hamcrest.Matchers.equalTo;
                        if (builder.hasTask(lastKnownTask)) {
                break;
        return PersistentTasksCustomMetadata::new;  
                randomBoolean() ? Optional.empty() : Optional.of("test")
            case 3:  
        PersistentTasksCustomMetadata originalTasks = PersistentTasksCustomMetadata.getPersistentTasksCustomMetadata(originalState);
    public void testSerializationContext() throws Exception {
            if (randomBoolean()) {  
                        } else {
                    addRandomTask(builder);  
        PersistentTasksCustomMetadata returnedTasks = PersistentTasksCustomMetadata.getPersistentTasksCustomMetadata(returnedState);  
import org.opensearch.persistent.TestPersistentTasksPlugin.TestParams;
                tasks.updateTaskState(taskId, new State(randomAlphaOfLength(10)));
                            builder.removeTask(lastKnownTask);
 *    http://www.apache.org/licenses/LICENSE-2.0
                            builder.reassignTask(lastKnownTask, randomAssignment());
            .localNodeId("node1")  
                if (builder.getCurrentTaskIds().isEmpty()) {  
import org.opensearch.persistent.PersistentTasksCustomMetadata.PersistentTask;  
            .metadata(Metadata.builder().putCustom(PersistentTasksCustomMetadata.TYPE, tasksBuilder.build()))  
                new Entry(Metadata.Custom.class, PersistentTasksCustomMetadata.TYPE, PersistentTasksCustomMetadata::new),
            tasks.addTask(taskId, TestPersistentTasksExecutor.NAME, new TestParams(randomAlphaOfLength(10)), randomAssignment());
        PersistentTasksCustomMetadata.Builder tasksBuilder = PersistentTasksCustomMetadata.builder()
    public void testBuilder() {
                new NamedXContentRegistry.Entry(
import java.util.NoSuchElementException;  
                } else {  
import org.opensearch.core.ParseField;
import org.opensearch.persistent.PersistentTasksCustomMetadata.Builder;
                    new ParseField(TestPersistentTasksExecutor.NAME),
                        break;  
    }
            public Version getMinimalSupportedVersion() {
                    addRandomTask(builder);
    }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
import org.opensearch.ResourceNotFoundException;  
        }
            }  
                randomVersionBetween(random(), compatibleFutureVersion(streamVersion), Version.CURRENT),
            assertEquals(0, newTask.getAllocationId());  
 * software distributed under the License is distributed on an
            .nodes(nodes)
    private Assignment randomAssignment() {
import static org.opensearch.cluster.metadata.Metadata.CONTEXT_MODE_SNAPSHOT;
    private String pickRandomTask(PersistentTasksCustomMetadata.Builder testInstance) {  
import org.opensearch.core.common.io.stream.Writeable;
        );
        }
import java.util.Collections;
        assertThat(read.taskMap().keySet(), equalTo(Collections.singleton("test_compatible_version")));  
    private String addRandomTask(Builder builder) {  
        PersistentTasksCustomMetadata persistentTasks = null;  
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry.Entry;
            new NamedWriteableAwareStreamInput(input, getNamedWriteableRegistry())  
            persistentTasks = builder.build();
            );
                            changed = true;  
                            expectThrows(ResourceNotFoundException.class, () -> builder.removeTask(fLastKnownTask));
                            String fLastKnownTask = lastKnownTask;  
                if (builder.getCurrentTaskIds().isEmpty()) {
 *  
                return taskName;  
        ClusterState returnedState = PersistentTasksCustomMetadata.disassociateDeadNodes(originalState);
/*
import org.opensearch.common.xcontent.XContentType;  
                "assigned-task",
import java.io.IOException;
                            String fLastKnownTask = lastKnownTask;  
import java.util.Optional;
    public void testMinVersionSerialization() throws IOException {
        PersistentTasksCustomMetadata testInstance = createTestInstance();  
                ),  
                null,
            assertNotNull(newTask);  
            .clusterManagerNodeId("node1")
    }
import static org.hamcrest.Matchers.sameInstance;  
    }
                    addRandomTask(builder);
                    builder.updateTaskState(pickRandomTask(builder), randomBoolean() ? new State(randomAlphaOfLength(10)) : null);  
                emptyTaskParams(taskName),  
import org.opensearch.cluster.NamedDiff;
                        break;  
 * SPDX-License-Identifier: Apache-2.0
        DiscoveryNodes nodes = DiscoveryNodes.builder()
import org.opensearch.persistent.TestPersistentTasksPlugin.TestPersistentTasksExecutor;  
                } else {
        return randomFrom(new ArrayList<>(testInstance.getCurrentTaskIds()));
        Version minVersion = allReleasedVersions().stream().filter(Version::isRelease).findFirst().orElseThrow(NoSuchElementException::new);
 */
        ClusterState returnedState = PersistentTasksCustomMetadata.disassociateDeadNodes(originalState);
        }
import org.opensearch.cluster.metadata.Metadata;  
            )
    protected PersistentTasksCustomMetadata createTestInstance() {
            case 2:
    @Override
        ClusterState returnedState = PersistentTasksCustomMetadata.disassociateDeadNodes(originalState);  
        ClusterState originalState = ClusterState.builder(new ClusterName("persistent-tasks-tests"))
            @Override
                }
import org.opensearch.cluster.ClusterState;  
    }  
            testInstance = (PersistentTasksCustomMetadata) makeTestChanges(testInstance);
            String taskId = UUIDs.base64UUID();  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        String taskName = "test/task";
            new TestParams(
        );  
        tasks.build().writeTo(out);
                            changed = true;  
        try (XContentParser parser = createParser(xContentType.xContent(), shuffled)) {
        assertThat(originalState, sameInstance(returnedState));  
            } else {
            features.add("test");
        assertEquals(originalTasks, returnedTasks);
            "test_compatible_version",
            .addTask(
import org.opensearch.cluster.node.DiscoveryNodes;  
 * this work for additional information regarding copyright
            .add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT))
        DiscoveryNodes nodes = DiscoveryNodes.builder()
import org.opensearch.core.common.io.stream.StreamInput;  
        return PersistentTasksCustomMetadata::readDiffFrom;
        return tasks.build();
                )
                new Entry(PersistentTaskParams.class, TestPersistentTasksExecutor.NAME, TestParams::new),  
                    PersistentTaskParams.class,  
        for (int i = 0; i < numberOfTasks; i++) {
        assertEquals(originalTasks.getTask("assigned-task"), returnedTasks.getTask("assigned-task"));
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder();
    public void testDisassociateDeadNodes_givenNoPersistentTasks() {  
        return PersistentTasksCustomMetadata.fromXContent(parser);  
        ClusterState originalState = ClusterState.builder(new ClusterName("persistent-tasks-tests"))
            .clusterManagerNodeId("node1")
            @Override  
            .build();  
                    TestParams::fromXContent
        input.setVersion(streamVersion);
public class PersistentTasksCustomMetadataTests extends AbstractDiffableSerializationTestCase<Custom> {
            .add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT))  
import org.opensearch.core.xcontent.XContentBuilder;
    private PersistentTaskParams emptyTaskParams(String taskName) {  
        final StreamInput input = out.bytes().streamInput();  
import java.util.ArrayList;
            TestPersistentTasksExecutor.NAME,  
 * Modifications Copyright OpenSearch Contributors. See  
            @Override
import static org.opensearch.test.VersionUtils.compatibleFutureVersion;
            .metadata(Metadata.builder().putCustom(PersistentTasksCustomMetadata.TYPE, tasksBuilder.build()))
            public XContentBuilder toXContent(XContentBuilder builder, Params params) {
        PersistentTasksCustomMetadata read = new PersistentTasksCustomMetadata(
 * The OpenSearch Contributors require contributions made to  
    }
        final BytesStreamOutput out = new BytesStreamOutput();  
 * Unless required by applicable law or agreed to in writing,
                return new Assignment(null, randomAlphaOfLength(10));  
import java.util.HashSet;
        if (randomBoolean()) {  
import static org.hamcrest.Matchers.not;
    }
                            expectThrows(ResourceNotFoundException.class, () -> builder.updateTaskState(fLastKnownTask, null));
        PersistentTasksCustomMetadata originalTasks = PersistentTasksCustomMetadata.getPersistentTasksCustomMetadata(originalState);  
                break;  
            }
        }  
        builder.addTask(taskId, TestPersistentTasksExecutor.NAME, new TestParams(randomAlphaOfLength(10)), randomAssignment());
    @Override
        }
                        break;  
    protected Custom makeTestChanges(Custom testInstance) {
import org.opensearch.Version;
                new PersistentTasksCustomMetadata.Assignment("node1", "test assignment")
                            expectThrows(ResourceNotFoundException.class, () -> builder.reassignTask(fLastKnownTask, randomAssignment()));
}
        int numberOfTasks = randomInt(10);  
                // From time to time update status  
        }  
import org.opensearch.core.xcontent.XContentParser;  
        String taskId = UUIDs.base64UUID();
    protected PersistentTasksCustomMetadata doParseInstance(XContentParser parser) {
                        }
                        if (builder.hasTask(lastKnownTask)) {
                        } else {
 * GitHub history for details.
                emptyTaskParams(taskName),
                randomVersionBetween(random(), minVersion, streamVersion),  
import org.opensearch.persistent.PersistentTasksCustomMetadata.Assignment;
    protected Writeable.Reader<Diff<Custom>> diffReader() {  
 * compatible open source license.
                    case 0:  
            if (randomBoolean()) {
            .build();
                            String fLastKnownTask = lastKnownTask;  
        for (int i = 0; i < randomIntBetween(10, 100); i++) {
    public void testDisassociateDeadNodes_givenAssignedPersistentTask() {  
        return builder.build();
        for (int i = 0; i < randomInt(10); i++) {
        assertEquals(testInstance.tasks().size(), newInstance.tasks().size());  
            }
import static org.opensearch.cluster.metadata.Metadata.CONTEXT_MODE_GATEWAY;
                            changed = true;  
            new TestParams(
                    case 2:
/*
                    case 3:
        PersistentTasksCustomMetadata returnedTasks = PersistentTasksCustomMetadata.getPersistentTasksCustomMetadata(returnedState);
            ),
    @Override
 * this file be licensed under the Apache-2.0 license or a
    @Override  
            boolean changed = false;  
 * not use this file except in compliance with the License.
import static org.opensearch.test.VersionUtils.allReleasedVersions;
                "task-id",
        );
        );
package org.opensearch.persistent;
            } else {  
                return builder;
            .build();
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder();  
 * Licensed to Elasticsearch under one or more contributor  
                        lastKnownTask = addRandomTask(builder);
import org.opensearch.cluster.ClusterName;
            .addTask(
            ),  
            Arrays.asList(
            assertNull(newTask.getExecutorNode());
        return new NamedWriteableRegistry(
        ClusterState originalState = ClusterState.builder(new ClusterName("persistent-tasks-tests")).build();
        tasks.addTask(
                return Version.CURRENT;
                break;  
 * specific language governing permissions and limitations
    }
            }  
            final Builder builder;  
                new PersistentTasksCustomMetadata.Assignment("node1", "test assignment")
        BytesReference shuffled = toShuffledXContent(testInstance, xContentType, params, false);
import org.opensearch.core.common.io.stream.StreamOutput;
                builder = PersistentTasksCustomMetadata.builder();
            if (randomBoolean()) {
        Builder builder = PersistentTasksCustomMetadata.builder((PersistentTasksCustomMetadata) testInstance);
                switch (randomInt(3)) {
 * ownership. Elasticsearch licenses this file to you under  
                        if (builder.hasTask(lastKnownTask)) {
        return new NamedXContentRegistry(  
        tasks.addTask(
            randomAssignment()
import org.opensearch.persistent.TestPersistentTasksPlugin.State;
        assertNotEquals(originalTasks, returnedTasks);
        };
                return NO_NODE_FOUND;
            Collections.singletonMap(Metadata.CONTEXT_MODE_PARAM, randomFrom(CONTEXT_MODE_SNAPSHOT, CONTEXT_MODE_GATEWAY))  
    }
    protected Writeable.Reader<Custom> instanceReader() {
        PersistentTasksCustomMetadata newInstance;  
                        break;  
 *
            assertEquals(testTask.getParams(), newTask.getParams());  
 * under the License.  
        String taskName = "test/task";
            assertEquals(testTask.getState(), newTask.getState());
            randomAssignment()  
import org.opensearch.common.io.stream.BytesStreamOutput;
            "test_incompatible_version",  
    @Override
                }
                }
                randomBoolean() ? Optional.empty() : Optional.of("test")
                } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final Version streamVersion = randomVersionBetween(random(), minVersion, VersionUtils.getPreviousVersion(Version.CURRENT));  
            }
                "task-on-deceased-node",
        );
                    case 1:
        assertThat(originalState, sameInstance(returnedState));  
    }  
        for (PersistentTask<?> testTask : testInstance.tasks()) {
            }
        out.setVersion(streamVersion);
        PersistentTasksCustomMetadata.Builder tasksBuilder = PersistentTasksCustomMetadata.builder()  
    }
        switch (randomInt(3)) {  
            // Things that shouldn't be serialized
            for (int j = 0; j < randomIntBetween(1, 10); j++) {
                taskName,
            .build();
            assertEquals(testTask.getTaskName(), newTask.getTaskName());  
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;  
                new NamedXContentRegistry.Entry(
        XContentType xContentType = randomFrom(XContentType.values());  
    @SuppressWarnings("unchecked")
                        }
            }
            // Things that should be serialized
 * You may obtain a copy of the License at  
                    State::fromXContent
            Arrays.asList(  
            .nodes(nodes)  
        Set<String> features = new HashSet<>();
                break;
                taskName,  
import java.util.Set;
        }  
                if (builder.getCurrentTaskIds().isEmpty()) {
            }
    @Override
        assertEquals(PersistentTasksCustomMetadata.LOST_NODE_ASSIGNMENT, returnedTasks.getTask("task-on-deceased-node").getAssignment());  
            assertEquals(changed, builder.isChanged());  
                            builder.updateTaskState(lastKnownTask, randomBoolean() ? new State(randomAlphaOfLength(10)) : null);
                        } else {
import static org.opensearch.persistent.PersistentTasksExecutor.NO_NODE_FOUND;  
    protected NamedXContentRegistry xContentRegistry() {
        assertNotEquals(originalTasks.getTask("task-on-deceased-node"), returnedTasks.getTask("task-on-deceased-node"));
        assertNotSame(newInstance, testInstance);
            PersistentTask<TestParams> newTask = (PersistentTask<TestParams>) newInstance.getTask(testTask.getId());
            public String getWriteableName() {
    }  
        if (randomBoolean()) {
import org.opensearch.test.AbstractDiffableSerializationTestCase;
/*  
            @Override  
            .localNodeId("node1")
            newInstance = doParseInstance(parser);
import org.opensearch.cluster.node.DiscoveryNode;
        return new PersistentTaskParams() {
                addRandomTask(builder);
    }
    public void testDisassociateDeadNodes() {
    @Override  
import org.opensearch.test.VersionUtils;
                emptyTaskParams(taskName),
    }
            case 0:
            case 1:
                taskName,  
                }  
        ToXContent.MapParams params = new ToXContent.MapParams(
                new PersistentTasksCustomMetadata.Assignment("left-the-cluster", "test assignment")
    }
