import org.opensearch.common.settings.Settings;
            .build();  
            {  
        public Version getMinimalSupportedVersion() {
                            randomNonNegativeLong(),
        public TestCustomOne(StreamInput in) throws IOException {  
                        Map.of()
        ClusterState stateAfterDiffs = serializedDiffs.apply(ClusterState.EMPTY_STATE);  
            this.intObject = in.readInt();  
        }  
        ClusterState serializedClusterState2 = updateUsingSerialisedDiff(serializedClusterState1, clusterState2.diff(clusterState1));
import org.opensearch.cluster.RestoreInProgress;
        inStream = new NamedWriteableAwareStreamInput(inStream, new NamedWriteableRegistry(entries));
        // serialize with current version
        // Current version - Both the customs are non null
import org.opensearch.cluster.AbstractNamedDiffable;
        ClusterState serializedClusterState = ClusterState.Builder.fromBytes(  
 * license agreements. See the NOTICE file distributed with
    }  
                        RestoreInProgress.State.STARTED,  
        public static NamedDiff<Custom> readDiffFrom(StreamInput in) throws IOException {
                        UUIDs.randomBase64UUID(),
            .putCustom(  
            clusterState1.metadata().index("test"),  
            outStream.bytes().streamInput(),  
 * ownership. Elasticsearch licenses this file to you under  
        public Version getMinimalSupportedVersion() {
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
        assertNotSame(
        BytesStreamOutput outStream = new BytesStreamOutput();
            serializedClusterState2.metadata().index("test")
    }
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        }
    }
            new NamedWriteableRegistry(ClusterModule.getNamedWriteables())  
import org.opensearch.cluster.routing.allocation.AllocationService;
            builder.endObject();  
        assertSame(  
        ClusterState.Builder builder = ClusterState.builder(ClusterState.EMPTY_STATE)
            new NamedWriteableRegistry(ClusterModule.getNamedWriteables())  
        entries.add(new NamedWriteableRegistry.Entry(NamedDiff.class, TestCustomOne.TYPE, TestCustomOne::readDiffFrom));
        }
        inStream.setVersion(version);
 * the Apache License, Version 2.0 (the "License"); you may
        public static NamedDiff<Custom> readDiffFrom(StreamInput in) throws IOException {  
        assertThat(serializedClusterState.getClusterName().value(), equalTo(clusterState.getClusterName().value()));  
        );  
        // Create a new, albeit equal, IndexMetadata object
        assertSame("blocks", serializedClusterState2.blocks(), serializedClusterState3.blocks());
        @Override
        stateAfterDiffs = serializedDiffs.apply(ClusterState.EMPTY_STATE);
            "Should have created a new, equivalent, IndexMetadata object in clusterState2",
        ClusterState clusterState1 = ClusterState.builder(new ClusterName("clusterName1"))
        inStream = outStream.bytes().streamInput();  
import org.opensearch.cluster.SnapshotDeletionsInProgress;
 */  
        ClusterState clusterState2 = ClusterState.builder(clusterState1)  
            .settings(settings(Version.CURRENT))
                    )  
        if (includeRestore) {
        clusterState = ClusterState.builder(clusterState).routingTable(strategy.reroute(clusterState, "reroute").routingTable()).build();
import org.opensearch.cluster.metadata.Metadata;
package org.opensearch.cluster.serialization;
    public void testClusterStateSerialization() throws Exception {  
import org.opensearch.common.UUIDs;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
            out.writeString(strObject);  
            return Version.CURRENT;  
            .build();  
        Diff<ClusterState> serializedDiffs = ClusterState.readDiffFrom(inStream, clusterState.nodes().getLocalNode());
        return diff.apply(original);  
import java.util.Map;
        inStream = outStream.bytes().streamInput();
        StreamInput inStream = outStream.bytes().streamInput();
        assertThat(stateAfterDiffs.custom(SnapshotDeletionsInProgress.TYPE), notNullValue());  
        }
    }  
 *
            .incrementVersion()
import static org.hamcrest.Matchers.equalTo;  
            );
 * under the License.  
    public void testRoutingTableSerialization() throws Exception {
            builder.startObject();
        }
        Metadata metadata = Metadata.builder()  
            .routingTable(routingTable)
 * this file be licensed under the Apache-2.0 license or a
        public TestCustomTwo(Integer intObject) {
                )  
        @Override
        outStream.setVersion(version);  
 *     http://www.apache.org/licenses/LICENSE-2.0
        );
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        @Override  
            .metadata(metadata)
import org.opensearch.core.common.io.stream.StreamInput;
            return builder;
            .metadata(metadata)
            .routingTable(routingTable)  
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertThat(stateAfterDiffs.custom(TestCustomOne.TYPE), notNullValue());  
        }
        Diff<ClusterState> serializedDiffs = ClusterState.readDiffFrom(inStream, clusterState.nodes().getLocalNode());
            .build();
        ClusterState.Builder builder = ClusterState.builder(ClusterState.EMPTY_STATE)
            serializedClusterState2.metadata().templates().get("test-template"),
    public void testObjectReuseWhenApplyingClusterStateDiff() throws Exception {  
            "Unchanged routing table should not create new IndexRoutingTable objects",
        public String getWriteableName() {
 * not use this file except in compliance with the License.
        public TestCustomTwo(StreamInput in) throws IOException {
        assertThat(stateAfterDiffs.custom(SnapshotDeletionsInProgress.TYPE), notNullValue());
            builder.putCustom(  
        BytesStreamOutput outStream = new BytesStreamOutput();
import org.opensearch.cluster.Diff;
            "template",  
        assertThat(stateAfterDiffs.custom(TestCustomOne.TYPE), nullValue());
            .build();
            .localNodeId("node1")
import org.opensearch.cluster.routing.RoutingTable;
        entries.add(new NamedWriteableRegistry.Entry(ClusterState.Custom.class, TestCustomTwo.TYPE, TestCustomTwo::new));
            return TYPE;  
        @Override  
            serializedClusterState2.metadata().index("test"),  
            .add(newNode("node1"))
        }
        diffs.writeTo(outStream);
 * specific language governing permissions and limitations
        stateAfterDiffs = serializedDiffs.apply(stateAfterDiffs);
        assertThat(stateAfterDiffs.custom(TestCustomTwo.TYPE), notNullValue());
import org.opensearch.snapshots.Snapshot;
        private final String strObject;  
import org.opensearch.core.common.io.stream.StreamOutput;  
        inStream.setVersion(version);
        IndexMetadata indexMetadata = IndexMetadata.builder("test")
                builder.field("custom_string_object", strObject);
        );
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
            return TYPE;
        serializedDiffs = ClusterState.readDiffFrom(inStream, clusterState.nodes().getLocalNode());  
        entries.add(new NamedWriteableRegistry.Entry(NamedDiff.class, TestCustomTwo.TYPE, TestCustomTwo::readDiffFrom));  
            .build();  
            .build();
        DiscoveryNodes nodes = DiscoveryNodes.builder()
import static org.hamcrest.Matchers.nullValue;
            return Version.CURRENT.minimumCompatibilityVersion();
 * You may obtain a copy of the License at  
import org.opensearch.cluster.ClusterModule;  
            .incrementVersion()  
        AllocationService strategy = createAllocationService();
 * compatible open source license.
            serializedClusterState1.routingTable().index("test"),  
            serializedClusterState3.metadata().templates().get("test-template")
            .putCustom(TestCustomOne.TYPE, new TestCustomOne("test_custom_one"))  
            .build();
import org.opensearch.cluster.NamedDiff;
            .build();
                    Collections.singletonList(  
            this.intObject = intObject;
                new RestoreInProgress.Builder().add(
    public void testSnapshotDeletionsInProgressSerialization() throws Exception {
        RoutingTable source = strategy.reroute(clusterState, "reroute").routingTable();  
        @Override  
        ClusterState clusterState = builder.incrementVersion().build();  
        );
        @Override
        // remove the custom and try serializing again
    private ClusterState updateUsingSerialisedDiff(ClusterState original, Diff<ClusterState> diff) throws IOException {  
            return readDiffFrom(Custom.class, TYPE, in);  
        ClusterState stateAfterDiffs = serializedDiffs.apply(ClusterState.EMPTY_STATE);  
                RestoreInProgress.TYPE,
        Version version = Version.CURRENT;
        inStream.setVersion(version);
            clusterState2.metadata().index("test")
                            randomNonNegativeLong(),
            serializedClusterState3.metadata().index("test")
        RoutingTable target = RoutingTable.readFrom(inStream);
 * The OpenSearch Contributors require contributions made to  
            return readDiffFrom(Custom.class, TYPE, in);
    public void testCustomSerialization() throws Exception {
        // serialize with current version  
/*
            new NamedWriteableRegistry(ClusterModule.getNamedWriteables())
    }  
        public String getWriteableName() {
        ClusterState clusterState = ClusterState.builder(new ClusterName("clusterName1"))  
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
            .patterns(Arrays.asList(generateRandomStringArray(10, 100, false, false)))
        outStream = new BytesStreamOutput();
        source.writeTo(outStream);  
            .nodes(nodes)
        BytesStreamOutput outStream = new BytesStreamOutput();
            builder.startObject();
 *  
                builder.field("custom_integer_object", intObject);  
            this.strObject = in.readString();
            return builder;  
        }  
        Diff<ClusterState> diffs = clusterState.diff(ClusterState.EMPTY_STATE);
        inStream = new NamedWriteableAwareStreamInput(inStream, new NamedWriteableRegistry(entries));  
        assertThat(serializedClusterState.routingTable().toString(), equalTo(clusterState.routingTable().toString()));
        IndexTemplateMetadata indexTemplateMetadata = IndexTemplateMetadata.builder("test-template")  
 *
        }
        StreamInput inStream = new NamedWriteableAwareStreamInput(
import org.opensearch.cluster.ClusterState.Custom;  
            newNode("node1"),
        private final Integer intObject;
        diff = ClusterState.readDiffFrom(inStream, newNode("node-name"));
        diffs.writeTo(outStream);  
 */
            ClusterState.Builder.toBytes(clusterState),
        public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    }
import java.util.List;  
        outStream = new BytesStreamOutput();  
/*  
        ClusterState serializedClusterState3 = updateUsingSerialisedDiff(serializedClusterState2, clusterState3.diff(clusterState2));  
import java.util.Arrays;
        Diff<ClusterState> diffs = clusterState.diff(ClusterState.EMPTY_STATE);
        }  
        // Create a new and different IndexMetadata object
        assertNotEquals(
            {
        public static final String TYPE = "test_custom_two";
        }
        }
                ).build()
            );
        }  
        @Override  
        Metadata metadata = Metadata.builder()
        assertSame("nodes", serializedClusterState2.nodes(), serializedClusterState3.nodes());  
import org.opensearch.cluster.metadata.IndexMetadata;  
        outStream.setVersion(version);  
        );
            .numberOfReplicas(1)
            .numberOfShards(10)  
        StreamInput inStream = outStream.bytes().streamInput();
            .metadata(metadata)
        public TestCustomOne(String strObject) {
        assertSame(
import org.opensearch.cluster.node.DiscoveryNodes;  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(10).numberOfReplicas(1))
            "Unchanged metadata should not create new IndexMetadata objects",  
        // serialize with minimum compatibile version  
            outStream.bytes().streamInput(),
        outStream.setVersion(Version.CURRENT);
            .add(newNode("node2"))  
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")).build();  
                        Collections.singletonList("index_name"),
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        inStream = new NamedWriteableAwareStreamInput(inStream, new NamedWriteableRegistry(ClusterModule.getNamedWriteables()));  
 * Modifications Copyright OpenSearch Contributors. See
}
            .clusterManagerNodeId("node2")  
        ClusterState serializedClusterState1 = ClusterState.readFrom(inStream, newNode("node4"));  
        outStream.setVersion(version);
            .nodes(nodes)  
        entries.add(new NamedWriteableRegistry.Entry(ClusterState.Custom.class, TestCustomOne.TYPE, TestCustomOne::new));  
import org.opensearch.cluster.ClusterState;
public class ClusterSerializationTests extends OpenSearchAllocationTestCase {
        public static final String TYPE = "test_custom_one";
            serializedClusterState2.routingTable().index("test"),
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            builder.endObject();
        assertThat(stateAfterDiffs.custom(TestCustomTwo.TYPE), notNullValue());
        @Override
                            SnapshotDeletionsInProgress.State.STARTED  
        BytesStreamOutput outStream = new BytesStreamOutput();
        outStream.setVersion(version);
        serializedDiffs = ClusterState.readDiffFrom(inStream, clusterState.nodes().getLocalNode());  
        clusterState1.writeTo(outStream);
        public void writeTo(StreamOutput out) throws IOException {
        // Add the new customs to named writeables
        ClusterState clusterState3 = ClusterState.builder(clusterState1)
                        new SnapshotDeletionsInProgress.Entry(
        }
            serializedClusterState2.routingTable().index("test")
                            "repo1",  
        inStream.setVersion(version);
 */  
 * KIND, either express or implied.  See the License for the
    public static class TestCustomOne extends AbstractNamedDiffable<Custom> implements Custom {  
            .routingTable(routingTable)  
        diffs.writeTo(outStream);
        clusterState = ClusterState.builder(clusterState).removeCustom(SnapshotDeletionsInProgress.TYPE).incrementVersion().build();
        );
        final List<NamedWriteableRegistry.Entry> entries = ClusterModule.getNamedWriteables();
            .metadata(Metadata.builder().put(IndexMetadata.builder(indexMetadata).numberOfReplicas(1).build(), true))
        assertSame(
        StreamInput inStream = new NamedWriteableAwareStreamInput(
        assertThat(target.toString(), equalTo(source.toString()));
 * Licensed to Elasticsearch under one or more contributor  
        inStream = new NamedWriteableAwareStreamInput(inStream, new NamedWriteableRegistry(ClusterModule.getNamedWriteables()));
        ClusterState clusterState = builder.incrementVersion().build();
            .metadata(Metadata.builder().put(IndexMetadata.builder(indexMetadata).numberOfReplicas(2).build(), true))
import static org.hamcrest.Matchers.notNullValue;
        assertSame(
            this.strObject = strObject;  
        assertThat(stateAfterDiffs.custom(RestoreInProgress.TYPE), includeRestore ? notNullValue() : nullValue());
        boolean includeRestore = randomBoolean();  
            out.writeInt(intObject);
        outStream.setVersion(Version.CURRENT);  
import org.opensearch.Version;
            serializedClusterState1.metadata().index("test"),
import java.util.Collections;
                        )
import java.io.IOException;  
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.snapshots.SnapshotId;  
        StreamInput inStream = outStream.bytes().streamInput();
    }
        );
import org.opensearch.core.xcontent.XContentBuilder;
            .build();
    }
        diff.writeTo(outStream);  
            serializedClusterState3.routingTable().index("test")  
            "Should have a new IndexMetadata object",
        // Old version - TestCustomOne is null and TestCustomTwo is not null  
import org.opensearch.test.VersionUtils;
            "Unchanged routing table should not create new IndexRoutingTable objects",
/*  
        );  
                    new RestoreInProgress.Entry(  
                SnapshotDeletionsInProgress.TYPE,
 * software distributed under the License is distributed on an
        );
                SnapshotDeletionsInProgress.of(
            .build();
            .add(newNode("node3"))
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;  
            }
        version = Version.CURRENT.minimumCompatibilityVersion();
 * SPDX-License-Identifier: Apache-2.0
        BytesStreamOutput outStream = new BytesStreamOutput();  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(10).numberOfReplicas(1))
        Version version = VersionUtils.randomVersionBetween(random(), Version.CURRENT.minimumCompatibilityVersion(), Version.CURRENT);
            .putCustom(TestCustomTwo.TYPE, new TestCustomTwo(10));
            }
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                    )
        diffs.writeTo(outStream);
                            Collections.singletonList(new SnapshotId("snap1", UUIDs.randomBase64UUID())),
import org.opensearch.cluster.ClusterName;
                        new Snapshot("repo2", new SnapshotId("snap2", UUIDs.randomBase64UUID())),
        }  
        Metadata metadata = Metadata.builder().put(indexMetadata, true).put(indexTemplateMetadata).build();  
        assertThat(stateAfterDiffs.custom(RestoreInProgress.TYPE), includeRestore ? notNullValue() : nullValue());
        AllocationService strategy = createAllocationService();  
    public static class TestCustomTwo extends AbstractNamedDiffable<Custom> implements Custom {
