        ClusterState stateAfterDiffs = serializedDiffs.apply(ClusterState.EMPTY_STATE);
        public TestCustomOne(String strObject) {
                SnapshotDeletionsInProgress.TYPE,
            builder.endObject();
        entries.add(new NamedWriteableRegistry.Entry(NamedDiff.class, TestCustomOne.TYPE, TestCustomOne::readDiffFrom));
    public void testCustomSerialization() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
            }
                            randomNonNegativeLong(),
        private final Integer intObject;
/*
        outStream.setVersion(version);
 *
        ClusterState.Builder builder = ClusterState.builder(ClusterState.EMPTY_STATE)
            );
        assertSame(
        StreamInput inStream = outStream.bytes().streamInput();
        }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        BytesStreamOutput outStream = new BytesStreamOutput();
            "Unchanged routing table should not create new IndexRoutingTable objects",
        );
            "Should have created a new, equivalent, IndexMetadata object in clusterState2",
        Metadata metadata = Metadata.builder()
        }
            builder.endObject();
    }
        assertThat(stateAfterDiffs.custom(SnapshotDeletionsInProgress.TYPE), notNullValue());
                            SnapshotDeletionsInProgress.State.STARTED
        inStream.setVersion(version);
        StreamInput inStream = new NamedWriteableAwareStreamInput(
 * not use this file except in compliance with the License.
            serializedClusterState1.metadata().index("test"),
        assertThat(stateAfterDiffs.custom(TestCustomOne.TYPE), notNullValue());
            .metadata(Metadata.builder().put(IndexMetadata.builder(indexMetadata).numberOfReplicas(2).build(), true))
            this.intObject = in.readInt();
import org.opensearch.common.io.stream.BytesStreamOutput;
        public TestCustomTwo(Integer intObject) {
import static org.hamcrest.Matchers.nullValue;
            clusterState1.metadata().index("test"),
            .build();
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
/*
        }
            serializedClusterState2.metadata().templates().get("test-template"),
            .build();
        final List<NamedWriteableRegistry.Entry> entries = ClusterModule.getNamedWriteables();
        public TestCustomOne(StreamInput in) throws IOException {
        }
            .putCustom(TestCustomTwo.TYPE, new TestCustomTwo(10));
            {
            serializedClusterState2.metadata().index("test"),
        Diff<ClusterState> serializedDiffs = ClusterState.readDiffFrom(inStream, clusterState.nodes().getLocalNode());
            }
            .metadata(metadata)
 * specific language governing permissions and limitations
    public void testObjectReuseWhenApplyingClusterStateDiff() throws Exception {
        Diff<ClusterState> diffs = clusterState.diff(ClusterState.EMPTY_STATE);
            .incrementVersion()
        ClusterState stateAfterDiffs = serializedDiffs.apply(ClusterState.EMPTY_STATE);
import org.opensearch.cluster.ClusterState.Custom;
        assertThat(stateAfterDiffs.custom(TestCustomTwo.TYPE), notNullValue());
}
            return builder;
                    new RestoreInProgress.Entry(
 */
            newNode("node1"),
import org.opensearch.cluster.routing.RoutingTable;
        ClusterState clusterState1 = ClusterState.builder(new ClusterName("clusterName1"))
import java.util.Map;
        inStream = new NamedWriteableAwareStreamInput(inStream, new NamedWriteableRegistry(entries));
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        if (includeRestore) {
        }
import org.opensearch.cluster.ClusterModule;
                            randomNonNegativeLong(),
        @Override
        // serialize with current version
            return Version.CURRENT;
                builder.field("custom_string_object", strObject);
        Version version = Version.CURRENT;
            builder.startObject();
import org.opensearch.cluster.metadata.IndexMetadata;
            this.intObject = intObject;
import org.opensearch.snapshots.SnapshotId;
            .routingTable(routingTable)
 *
        stateAfterDiffs = serializedDiffs.apply(ClusterState.EMPTY_STATE);
        }
 * Licensed to Elasticsearch under one or more contributor
        // Current version - Both the customs are non null
            "Should have a new IndexMetadata object",
            ClusterState.Builder.toBytes(clusterState),
            {
        diffs.writeTo(outStream);
        clusterState1.writeTo(outStream);
        StreamInput inStream = new NamedWriteableAwareStreamInput(
            );
    private ClusterState updateUsingSerialisedDiff(ClusterState original, Diff<ClusterState> diff) throws IOException {
    public static class TestCustomTwo extends AbstractNamedDiffable<Custom> implements Custom {
        public Version getMinimalSupportedVersion() {
        }
            .add(newNode("node2"))
        // serialize with minimum compatibile version
        outStream = new BytesStreamOutput();
                        new SnapshotDeletionsInProgress.Entry(
                SnapshotDeletionsInProgress.of(
        assertNotEquals(
        IndexTemplateMetadata indexTemplateMetadata = IndexTemplateMetadata.builder("test-template")
        // remove the custom and try serializing again
            .putCustom(
        RoutingTable target = RoutingTable.readFrom(inStream);
        ClusterState serializedClusterState1 = ClusterState.readFrom(inStream, newNode("node4"));
        outStream.setVersion(version);
        diff = ClusterState.readDiffFrom(inStream, newNode("node-name"));
/*
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        ClusterState serializedClusterState = ClusterState.Builder.fromBytes(
        assertThat(serializedClusterState.getClusterName().value(), equalTo(clusterState.getClusterName().value()));
        public String getWriteableName() {
            .routingTable(routingTable)
                        Map.of()
        // Create a new and different IndexMetadata object
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    )
import java.util.List;
            .build();
            .settings(settings(Version.CURRENT))
            new NamedWriteableRegistry(ClusterModule.getNamedWriteables())
import org.opensearch.cluster.routing.allocation.AllocationService;
        boolean includeRestore = randomBoolean();
            out.writeInt(intObject);
            clusterState2.metadata().index("test")
                        RestoreInProgress.State.STARTED,
    public void testClusterStateSerialization() throws Exception {
            .incrementVersion()
        assertThat(target.toString(), equalTo(source.toString()));
        private final String strObject;
        );
        RoutingTable source = strategy.reroute(clusterState, "reroute").routingTable();
        @Override
        return diff.apply(original);
        // Create a new, albeit equal, IndexMetadata object
                    Collections.singletonList(
        IndexMetadata indexMetadata = IndexMetadata.builder("test")
        }
 * Unless required by applicable law or agreed to in writing,
            outStream.bytes().streamInput(),
            .build();
                            Collections.singletonList(new SnapshotId("snap1", UUIDs.randomBase64UUID())),
        public String getWriteableName() {
            return readDiffFrom(Custom.class, TYPE, in);
            .nodes(nodes)
        // Add the new customs to named writeables
            outStream.bytes().streamInput(),
                        UUIDs.randomBase64UUID(),
import org.opensearch.cluster.ClusterName;
            "Unchanged metadata should not create new IndexMetadata objects",
        assertSame("blocks", serializedClusterState2.blocks(), serializedClusterState3.blocks());
            .build();
import org.opensearch.Version;
            .metadata(metadata)
import java.io.IOException;
 * You may obtain a copy of the License at
            this.strObject = strObject;
        public static final String TYPE = "test_custom_two";
        );
    public void testSnapshotDeletionsInProgressSerialization() throws Exception {
import org.opensearch.test.VersionUtils;
            .numberOfShards(10)
import java.util.Collections;
            serializedClusterState2.routingTable().index("test")
        entries.add(new NamedWriteableRegistry.Entry(ClusterState.Custom.class, TestCustomOne.TYPE, TestCustomOne::new));
        assertSame(
 * license agreements. See the NOTICE file distributed with
        Version version = VersionUtils.randomVersionBetween(random(), Version.CURRENT.minimumCompatibilityVersion(), Version.CURRENT);
        outStream.setVersion(version);
 * The OpenSearch Contributors require contributions made to
        inStream = outStream.bytes().streamInput();
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
                ).build()
        @Override
import org.opensearch.core.common.io.stream.StreamInput;
        assertThat(stateAfterDiffs.custom(TestCustomOne.TYPE), nullValue());
        DiscoveryNodes nodes = DiscoveryNodes.builder()
            out.writeString(strObject);
            serializedClusterState1.routingTable().index("test"),
 * ownership. Elasticsearch licenses this file to you under
 */
        @Override
 * compatible open source license.
        );
                new RestoreInProgress.Builder().add(
    }
            .nodes(nodes)
            serializedClusterState2.routingTable().index("test"),
        ClusterState serializedClusterState2 = updateUsingSerialisedDiff(serializedClusterState1, clusterState2.diff(clusterState1));
        inStream = new NamedWriteableAwareStreamInput(inStream, new NamedWriteableRegistry(entries));
        ClusterState clusterState = ClusterState.builder(new ClusterName("clusterName1"))
        BytesStreamOutput outStream = new BytesStreamOutput();
        inStream.setVersion(version);
        inStream.setVersion(version);
package org.opensearch.cluster.serialization;
            .putCustom(TestCustomOne.TYPE, new TestCustomOne("test_custom_one"))
        assertSame(
        @Override
            return TYPE;
    }
        Metadata metadata = Metadata.builder().put(indexMetadata, true).put(indexTemplateMetadata).build();
import org.opensearch.cluster.node.DiscoveryNodes;
            this.strObject = in.readString();
        assertSame(
        BytesStreamOutput outStream = new BytesStreamOutput();
        entries.add(new NamedWriteableRegistry.Entry(ClusterState.Custom.class, TestCustomTwo.TYPE, TestCustomTwo::new));
        public static final String TYPE = "test_custom_one";
    }
            .build();
            serializedClusterState3.routingTable().index("test")
        diffs.writeTo(outStream);
 * GitHub history for details.
                builder.field("custom_integer_object", intObject);
            builder.startObject();
 * Modifications Copyright OpenSearch Contributors. See
            .patterns(Arrays.asList(generateRandomStringArray(10, 100, false, false)))
                            "repo1",
        );
        inStream = new NamedWriteableAwareStreamInput(inStream, new NamedWriteableRegistry(ClusterModule.getNamedWriteables()));
 * the Apache License, Version 2.0 (the "License"); you may
            builder.putCustom(
            serializedClusterState3.metadata().index("test")
        );
            .build();
        outStream.setVersion(Version.CURRENT);
import org.opensearch.cluster.SnapshotDeletionsInProgress;
                        Collections.singletonList("index_name"),
        ClusterState clusterState2 = ClusterState.builder(clusterState1)
        public static NamedDiff<Custom> readDiffFrom(StreamInput in) throws IOException {
        assertThat(stateAfterDiffs.custom(RestoreInProgress.TYPE), includeRestore ? notNullValue() : nullValue());
 * this file be licensed under the Apache-2.0 license or a
        diffs.writeTo(outStream);
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
public class ClusterSerializationTests extends OpenSearchAllocationTestCase {
        source.writeTo(outStream);
    public static class TestCustomOne extends AbstractNamedDiffable<Custom> implements Custom {
                        new Snapshot("repo2", new SnapshotId("snap2", UUIDs.randomBase64UUID())),
        version = Version.CURRENT.minimumCompatibilityVersion();
        outStream.setVersion(version);
        // Old version - TestCustomOne is null and TestCustomTwo is not null
        public static NamedDiff<Custom> readDiffFrom(StreamInput in) throws IOException {
        }
        }
        diff.writeTo(outStream);
            .localNodeId("node1")
import org.opensearch.core.common.io.stream.StreamOutput;
        assertThat(stateAfterDiffs.custom(RestoreInProgress.TYPE), includeRestore ? notNullValue() : nullValue());
        StreamInput inStream = outStream.bytes().streamInput();
        }
        serializedDiffs = ClusterState.readDiffFrom(inStream, clusterState.nodes().getLocalNode());
        ClusterState clusterState3 = ClusterState.builder(clusterState1)
        AllocationService strategy = createAllocationService();
        public void writeTo(StreamOutput out) throws IOException {
        }
import org.opensearch.cluster.RestoreInProgress;
        diffs.writeTo(outStream);
        Diff<ClusterState> serializedDiffs = ClusterState.readDiffFrom(inStream, clusterState.nodes().getLocalNode());
        outStream.setVersion(Version.CURRENT);
    }
            .build();
        AllocationService strategy = createAllocationService();
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        BytesStreamOutput outStream = new BytesStreamOutput();
            .numberOfReplicas(1)
            .add(newNode("node1"))
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        ClusterState serializedClusterState3 = updateUsingSerialisedDiff(serializedClusterState2, clusterState3.diff(clusterState2));
    }
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")).build();
                    )
            .build();
        );
            "Unchanged routing table should not create new IndexRoutingTable objects",
        assertThat(stateAfterDiffs.custom(SnapshotDeletionsInProgress.TYPE), notNullValue());
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(10).numberOfReplicas(1))
        stateAfterDiffs = serializedDiffs.apply(stateAfterDiffs);
        entries.add(new NamedWriteableRegistry.Entry(NamedDiff.class, TestCustomTwo.TYPE, TestCustomTwo::readDiffFrom));
import org.opensearch.cluster.NamedDiff;
        inStream = new NamedWriteableAwareStreamInput(inStream, new NamedWriteableRegistry(ClusterModule.getNamedWriteables()));
import static org.hamcrest.Matchers.equalTo;
        assertNotSame(
        assertThat(serializedClusterState.routingTable().toString(), equalTo(clusterState.routingTable().toString()));
            .metadata(metadata)
        // serialize with current version
        }
            return builder;
        outStream = new BytesStreamOutput();
        inStream.setVersion(version);
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .metadata(Metadata.builder().put(IndexMetadata.builder(indexMetadata).numberOfReplicas(1).build(), true))
 * KIND, either express or implied.  See the License for the
        clusterState = ClusterState.builder(clusterState).routingTable(strategy.reroute(clusterState, "reroute").routingTable()).build();
            .clusterManagerNodeId("node2")
 * software distributed under the License is distributed on an
    public void testRoutingTableSerialization() throws Exception {
        clusterState = ClusterState.builder(clusterState).removeCustom(SnapshotDeletionsInProgress.TYPE).incrementVersion().build();
        ClusterState clusterState = builder.incrementVersion().build();
            serializedClusterState3.metadata().templates().get("test-template")
                RestoreInProgress.TYPE,
                )
        serializedDiffs = ClusterState.readDiffFrom(inStream, clusterState.nodes().getLocalNode());
        Diff<ClusterState> diffs = clusterState.diff(ClusterState.EMPTY_STATE);
        @Override
        Metadata metadata = Metadata.builder()
        assertSame("nodes", serializedClusterState2.nodes(), serializedClusterState3.nodes());
import org.opensearch.snapshots.Snapshot;
            new NamedWriteableRegistry(ClusterModule.getNamedWriteables())
 * under the License.
import org.opensearch.common.settings.Settings;
        }
            "template",
        public TestCustomTwo(StreamInput in) throws IOException {
 * this work for additional information regarding copyright
 */
        public void writeTo(StreamOutput out) throws IOException {
        ClusterState clusterState = builder.incrementVersion().build();
            return readDiffFrom(Custom.class, TYPE, in);
                        )
        StreamInput inStream = outStream.bytes().streamInput();
        inStream = outStream.bytes().streamInput();
            return Version.CURRENT.minimumCompatibilityVersion();
        public Version getMinimalSupportedVersion() {
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.cluster.ClusterState;
            .add(newNode("node3"))
            return TYPE;
        @Override
import org.opensearch.common.UUIDs;
        ClusterState.Builder builder = ClusterState.builder(ClusterState.EMPTY_STATE)
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(10).numberOfReplicas(1))
            new NamedWriteableRegistry(ClusterModule.getNamedWriteables())
import org.opensearch.cluster.Diff;
        );
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            .routingTable(routingTable)
    }
        assertThat(stateAfterDiffs.custom(TestCustomTwo.TYPE), notNullValue());
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
import static org.hamcrest.Matchers.notNullValue;
import java.util.Arrays;
            .build();
            serializedClusterState2.metadata().index("test")
import org.opensearch.cluster.AbstractNamedDiffable;
import org.opensearch.core.xcontent.XContentBuilder;
        BytesStreamOutput outStream = new BytesStreamOutput();
    }
        @Override
        }
