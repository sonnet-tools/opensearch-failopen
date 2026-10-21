import java.util.Optional;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.NamedDiff;
                        if (builder.hasTask(lastKnownTask)) {
                        break;
            .build();
                )
        assertEquals(originalTasks, returnedTasks);
        );
            assertNull(newTask.getExecutorNode());
                            builder.updateTaskState(lastKnownTask, randomBoolean() ? new State(randomAlphaOfLength(10)) : null);
            newInstance = doParseInstance(parser);
            if (randomBoolean()) {
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
                // From time to time update status
import org.opensearch.common.UUIDs;
                    case 3:
            }
            // Things that should be serialized
                        lastKnownTask = addRandomTask(builder);
            randomAssignment()
                return taskName;
        PersistentTasksCustomMetadata testInstance = createTestInstance();
        }
import static org.opensearch.persistent.PersistentTasksExecutor.NO_NODE_FOUND;
    }
    protected PersistentTasksCustomMetadata createTestInstance() {
        String taskName = "test/task";
/*
                        }
                new Entry(PersistentTaskState.class, TestPersistentTasksExecutor.NAME, State::new)
import org.opensearch.core.common.io.stream.NamedWriteableRegistry.Entry;
import org.opensearch.core.xcontent.NamedXContentRegistry;
        }
            Collections.singletonMap(Metadata.CONTEXT_MODE_PARAM, randomFrom(CONTEXT_MODE_SNAPSHOT, CONTEXT_MODE_GATEWAY))
            .localNodeId("node1")
import static org.opensearch.test.VersionUtils.compatibleFutureVersion;
    private String addRandomTask(Builder builder) {
            .addTask(
 *    http://www.apache.org/licenses/LICENSE-2.0
public class PersistentTasksCustomMetadataTests extends AbstractDiffableSerializationTestCase<Custom> {
        builder.addTask(taskId, TestPersistentTasksExecutor.NAME, new TestParams(randomAlphaOfLength(10)), randomAssignment());
import java.util.Arrays;
    @SuppressWarnings("unchecked")
        ToXContent.MapParams params = new ToXContent.MapParams(
        for (int i = 0; i < numberOfTasks; i++) {
    private String pickRandomTask(PersistentTasksCustomMetadata.Builder testInstance) {
import org.opensearch.test.VersionUtils;
            .localNodeId("node1")
        }
        }
        for (PersistentTask<?> testTask : testInstance.tasks()) {
            assertEquals(0, newTask.getAllocationId());
                new PersistentTasksCustomMetadata.Assignment("node1", "test assignment")
        );
    }
import java.util.ArrayList;
                            expectThrows(ResourceNotFoundException.class, () -> builder.removeTask(fLastKnownTask));
            } else {
/*
        out.setFeatures(features);
import org.opensearch.persistent.PersistentTasksCustomMetadata.PersistentTask;
    @Override
        return PersistentTasksCustomMetadata::readDiffFrom;
        return new Assignment(randomAlphaOfLength(10), randomAlphaOfLength(10));
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.core.common.io.stream.Writeable;
            .clusterManagerNodeId("node1")
            if (randomBoolean()) {
import org.opensearch.persistent.TestPersistentTasksPlugin.TestParams;
        PersistentTasksCustomMetadata.Builder tasksBuilder = PersistentTasksCustomMetadata.builder()
            );
import org.opensearch.core.common.bytes.BytesReference;
        PersistentTasksCustomMetadata.Builder tasksBuilder = PersistentTasksCustomMetadata.builder()
                        }
                "assigned-task",
            final Builder builder;
    protected NamedXContentRegistry xContentRegistry() {
                    addRandomTask(builder);
                    builder.updateTaskState(pickRandomTask(builder), randomBoolean() ? new State(randomAlphaOfLength(10)) : null);
    }
    public void testDisassociateDeadNodes_givenNoPersistentTasks() {
                            String fLastKnownTask = lastKnownTask;
            "test_incompatible_version",
        try (XContentParser parser = createParser(xContentType.xContent(), shuffled)) {
                            builder.reassignTask(lastKnownTask, randomAssignment());
                break;
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(originalTasks.getTask("assigned-task"), returnedTasks.getTask("assigned-task"));
        assertNotEquals(originalTasks, returnedTasks);
                ),
        );
import static org.opensearch.test.VersionUtils.randomVersionBetween;
        assertThat(originalState, sameInstance(returnedState));
            tasks.addTask(taskId, TestPersistentTasksExecutor.NAME, new TestParams(randomAlphaOfLength(10)), randomAssignment());
        out.setVersion(streamVersion);
    }
        DiscoveryNodes nodes = DiscoveryNodes.builder()
            @Override
                null,
        if (randomBoolean()) {
        PersistentTasksCustomMetadata persistentTasks = null;
 * GitHub history for details.
        ClusterState originalState = ClusterState.builder(new ClusterName("persistent-tasks-tests")).build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            Arrays.asList(
            case 2:
        tasks.build().writeTo(out);
import org.opensearch.persistent.TestPersistentTasksPlugin.State;
        }
                return Version.CURRENT;
            public Version getMinimalSupportedVersion() {
    public void testBuilder() {
            features.add("test");
import org.opensearch.core.xcontent.XContentParser;
 * Modifications Copyright OpenSearch Contributors. See
    private Assignment randomAssignment() {
        input.setVersion(streamVersion);
                if (builder.getCurrentTaskIds().isEmpty()) {
            assertEquals(testTask.getParams(), newTask.getParams());
                new Entry(Metadata.Custom.class, PersistentTasksCustomMetadata.TYPE, PersistentTasksCustomMetadata::new),
            // Things that shouldn't be serialized
            .build();
        return builder.build();
                builder = PersistentTasksCustomMetadata.builder();
        return tasks.build();
                randomBoolean() ? Optional.empty() : Optional.of("test")
            .addTask(
import java.util.NoSuchElementException;
            .build();
 * under the License.
        assertEquals(testInstance.tasks().size(), newInstance.tasks().size());
        assertThat(originalState, sameInstance(returnedState));
 * the Apache License, Version 2.0 (the "License"); you may
        PersistentTasksCustomMetadata originalTasks = PersistentTasksCustomMetadata.getPersistentTasksCustomMetadata(originalState);
            String taskId = UUIDs.base64UUID();
                        } else {
        }
import static org.hamcrest.Matchers.not;
                }
    }
            assertNotNull(newTask);
        return PersistentTasksCustomMetadata.fromXContent(parser);
                            changed = true;
        return randomFrom(new ArrayList<>(testInstance.getCurrentTaskIds()));
                        break;
    @Override
                            builder.removeTask(lastKnownTask);
            persistentTasks = builder.build();
            boolean changed = false;
            .clusterManagerNodeId("node1")
            testInstance = (PersistentTasksCustomMetadata) makeTestChanges(testInstance);
                if (builder.getCurrentTaskIds().isEmpty()) {
            new NamedWriteableAwareStreamInput(input, getNamedWriteableRegistry())
                taskName,
                emptyTaskParams(taskName),
            .add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT))
    }
    protected PersistentTasksCustomMetadata doParseInstance(XContentParser parser) {
                randomVersionBetween(random(), minVersion, streamVersion),
                    addRandomTask(builder);
import org.opensearch.cluster.metadata.Metadata;
                    new ParseField(TestPersistentTasksExecutor.NAME),
        return PersistentTasksCustomMetadata::new;
            @Override
        return new PersistentTaskParams() {
                    PersistentTaskState.class,
                    case 0:
import org.opensearch.persistent.PersistentTasksCustomMetadata.Assignment;
            }
                addRandomTask(builder);
package org.opensearch.persistent;
                emptyTaskParams(taskName),
            case 0:
import static org.opensearch.cluster.metadata.Metadata.CONTEXT_MODE_GATEWAY;
            } else {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            TestPersistentTasksExecutor.NAME,
import org.opensearch.core.xcontent.XContentBuilder;
    }
                        if (builder.hasTask(lastKnownTask)) {
import java.util.Collections;
        String taskId = UUIDs.base64UUID();
    public void testMinVersionSerialization() throws IOException {
                return builder;
                        } else {
    }
                            changed = true;
            .build();
                            changed = true;
        for (int i = 0; i < randomIntBetween(10, 100); i++) {
import org.opensearch.cluster.ClusterState;
            );
            @Override
    }
import static org.opensearch.cluster.metadata.Metadata.CONTEXT_MODE_SNAPSHOT;
 * ownership. Elasticsearch licenses this file to you under
                break;
            }
            .add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT))
import org.opensearch.ResourceNotFoundException;
                    case 2:
            case 1:
        );
                break;
 */
    protected Writeable.Reader<Custom> instanceReader() {
                } else {
                "task-on-deceased-node",
 * You may obtain a copy of the License at
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder();
            Arrays.asList(
        PersistentTasksCustomMetadata read = new PersistentTasksCustomMetadata(
 *
                new PersistentTasksCustomMetadata.Assignment("left-the-cluster", "test assignment")
 * compatible open source license.
                return NO_NODE_FOUND;
        assertNotEquals(originalTasks.getTask("task-on-deceased-node"), returnedTasks.getTask("task-on-deceased-node"));
            }
                }
import static org.opensearch.test.VersionUtils.allReleasedVersions;
 * license agreements. See the NOTICE file distributed with
                builder = PersistentTasksCustomMetadata.builder(persistentTasks);
import org.opensearch.Version;
                        break;
 * not use this file except in compliance with the License.
import java.util.Set;
 * The OpenSearch Contributors require contributions made to
            assertEquals(testTask.getId(), newTask.getId());
    @Override
 *
        return new NamedXContentRegistry(
                randomVersionBetween(random(), compatibleFutureVersion(streamVersion), Version.CURRENT),
        XContentType xContentType = randomFrom(XContentType.values());
            public String getWriteableName() {
                taskName,
    @Override
import org.opensearch.test.AbstractDiffableSerializationTestCase;
        for (int i = 0; i < randomInt(10); i++) {
                        if (builder.hasTask(lastKnownTask)) {
            assertEquals(testTask.getTaskName(), newTask.getTaskName());
        }
}
            assertEquals(testTask.getState(), newTask.getState());
                null,
        ClusterState returnedState = PersistentTasksCustomMetadata.disassociateDeadNodes(originalState);
                if (builder.getCurrentTaskIds().isEmpty()) {
                        break;
                    TestParams::fromXContent
import org.opensearch.persistent.TestPersistentTasksPlugin.TestPersistentTasksExecutor;
    public void testDisassociateDeadNodes() {
import org.opensearch.core.xcontent.ToXContent;
    }
        assertEquals(PersistentTasksCustomMetadata.LOST_NODE_ASSIGNMENT, returnedTasks.getTask("task-on-deceased-node").getAssignment());
        PersistentTasksCustomMetadata originalTasks = PersistentTasksCustomMetadata.getPersistentTasksCustomMetadata(originalState);
                return new Assignment(null, randomAlphaOfLength(10));
                    new ParseField(TestPersistentTasksExecutor.NAME),
    }
        assertThat(originalState, not(sameInstance(returnedState)));
import static org.hamcrest.Matchers.equalTo;
            if (randomBoolean()) {
        ClusterState originalState = ClusterState.builder(new ClusterName("persistent-tasks-tests"))
        );
        int numberOfTasks = randomInt(10);
                    builder.removeTask(pickRandomTask(builder));
    protected Writeable.Reader<Diff<Custom>> diffReader() {
        ClusterState returnedState = PersistentTasksCustomMetadata.disassociateDeadNodes(originalState);
        return new NamedWriteableRegistry(
                break;
        if (randomBoolean()) {
    @Override
        Builder builder = PersistentTasksCustomMetadata.builder((PersistentTasksCustomMetadata) testInstance);
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
import org.opensearch.core.common.io.stream.StreamOutput;
                "task-id",
            .metadata(Metadata.builder().putCustom(PersistentTasksCustomMetadata.TYPE, tasksBuilder.build()))
            public void writeTo(StreamOutput out) {
    }
 * Licensed to Elasticsearch under one or more contributor
                            expectThrows(ResourceNotFoundException.class, () -> builder.updateTaskState(fLastKnownTask, null));
                    State::fromXContent
            }
            }
        tasks.addTask(
import org.opensearch.cluster.node.DiscoveryNode;
                emptyTaskParams(taskName),
            PersistentTask<TestParams> newTask = (PersistentTask<TestParams>) newInstance.getTask(testTask.getId());
        tasks.addTask(
        ClusterState returnedState = PersistentTasksCustomMetadata.disassociateDeadNodes(originalState);
            ),
        assertThat(read.taskMap().keySet(), equalTo(Collections.singleton("test_compatible_version")));
        DiscoveryNodes nodes = DiscoveryNodes.builder()
        String taskName = "test/task";
        final BytesStreamOutput out = new BytesStreamOutput();
import org.opensearch.persistent.PersistentTasksCustomMetadata.Builder;
                taskName,
            )
import org.opensearch.cluster.Diff;
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
    }
            "test_compatible_version",
import org.opensearch.core.ParseField;
import org.opensearch.cluster.node.DiscoveryNodes;
 */
    }
                new Entry(NamedDiff.class, PersistentTasksCustomMetadata.TYPE, PersistentTasksCustomMetadata::readDiffFrom),
    public void testSerializationContext() throws Exception {
        ClusterState originalState = ClusterState.builder(new ClusterName("persistent-tasks-tests"))
                    builder.reassignTask(pickRandomTask(builder), randomAssignment());
import java.util.HashSet;
                        } else {
            )
 *
                            expectThrows(ResourceNotFoundException.class, () -> builder.reassignTask(fLastKnownTask, randomAssignment()));
        Version minVersion = allReleasedVersions().stream().filter(Version::isRelease).findFirst().orElseThrow(NoSuchElementException::new);
/*
                new Entry(PersistentTaskParams.class, TestPersistentTasksExecutor.NAME, TestParams::new),
    public void testDisassociateDeadNodes_givenAssignedPersistentTask() {
    }
 * specific language governing permissions and limitations
                tasks.updateTaskState(taskId, new State(randomAlphaOfLength(10)));
    protected Custom makeTestChanges(Custom testInstance) {
                    PersistentTaskParams.class,
                    addRandomTask(builder);
        final Version streamVersion = randomVersionBetween(random(), minVersion, VersionUtils.getPreviousVersion(Version.CURRENT));
                randomBoolean() ? Optional.empty() : Optional.of("test")
        );
        };
            new TestParams(
            public XContentBuilder toXContent(XContentBuilder builder, Params params) {
        PersistentTasksCustomMetadata newInstance;
                            String fLastKnownTask = lastKnownTask;
        }
            .nodes(nodes)
        PersistentTasksCustomMetadata returnedTasks = PersistentTasksCustomMetadata.getPersistentTasksCustomMetadata(returnedState);
                        }
            .addTask(
    }
        Set<String> features = new HashSet<>();
            randomAssignment()
import org.opensearch.common.xcontent.XContentType;
                        changed = true;
            assertEquals(changed, builder.isChanged());
    @Override
 * KIND, either express or implied.  See the License for the
                new PersistentTasksCustomMetadata.Assignment("node1", "test assignment")
        String lastKnownTask = "";
            }
 * Unless required by applicable law or agreed to in writing,
            new TestParams(
                }
import org.opensearch.cluster.metadata.Metadata.Custom;
        BytesReference shuffled = toShuffledXContent(testInstance, xContentType, params, false);
                new NamedXContentRegistry.Entry(
                new NamedXContentRegistry.Entry(
            }
        switch (randomInt(3)) {
        assertNotSame(newInstance, testInstance);
            @Override
import org.opensearch.core.common.io.stream.StreamInput;
        PersistentTasksCustomMetadata returnedTasks = PersistentTasksCustomMetadata.getPersistentTasksCustomMetadata(returnedState);
            ),
    private PersistentTaskParams emptyTaskParams(String taskName) {
            .nodes(nodes)
                switch (randomInt(3)) {
    @Override
        return taskId;
                    case 1:
        final StreamInput input = out.bytes().streamInput();
                } else {
            )
    }
 */
            for (int j = 0; j < randomIntBetween(1, 10); j++) {
import java.io.IOException;
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder();
import static org.hamcrest.Matchers.sameInstance;
            case 3:
import org.opensearch.cluster.ClusterName;
                }
            .metadata(Metadata.builder().putCustom(PersistentTasksCustomMetadata.TYPE, tasksBuilder.build()))
            TestPersistentTasksExecutor.NAME,
                } else {
                            String fLastKnownTask = lastKnownTask;
