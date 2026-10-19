            .put(  
import static org.hamcrest.Matchers.hasSize;
                IncrementalClusterStateWriter.AtomicClusterStateWriter writer = mock(  
import java.util.concurrent.atomic.AtomicLong;
        ClusterState oldClusterState = clusterStateWithUnassignedIndex(indexMetadata, clusterManagerEligible);  
        writeDurationMillis.set(randomLongBetween(slowWriteLoggingThresholdMillis, slowWriteLoggingThresholdMillis * 2));
 * ownership. Elasticsearch licenses this file to you under  
        Set<Index> indices = IncrementalClusterStateWriter.getRelevantIndices(  
        final AtomicLong currentTime = new AtomicLong(startTimeMillis);  
            Manifest manifest = Manifest.empty();
            .metadata(metadataNewClusterState)
                verify(writer).writeIndex(reason.capture(), eq(newVersionChangedIndex));
            .put(versionChangedIndex, false)
    }  
import java.util.Collections;
    private void assertExpectedLogs(
        MockLogAppender.LoggingExpectation expectation
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;  
    private boolean metadataEquals(Metadata md1, Metadata md2) {  
                    .numberOfShards(5)
            }
        IndexMetadata indexMetadata = createIndexMetadata("test");
                         * successful write of metadata and Manifest. We prefer to break here, not to over complicate test logic.
        RoutingTable routingTable = RoutingTable.builder().addAsRecovery(metadataNewClusterState.index("test")).build();
        boolean assigned
                    metaStateService,
            .clusterManagerNodeId(clusterManagerEligible ? "node1" : "cluster_manager_node");
        assertThat(currentTime.get(), lessThan(startTimeMillis + 10 * slowWriteLoggingThresholdMillis)); // ensure no overflow
        }
                }
        final Settings settings;
        if (assigned) {  
                "writing cluster state took [*] which is above the warn threshold of [*]; "
        Set<Index> relevantIndices = new HashSet<>();
            .put(notChangedIndex, false)  
                metadata = randomMetadataForTx();
                IncrementalClusterStateWriter.class.getCanonicalName(),
                                }
    }
        AllocationService strategy = createAllocationService(  
        assertThat(indices.size(), equalTo(0));  
            failRandomly = false;
                )
            oldMetadata,
            Metadata metadata = Metadata.EMPTY_METADATA;  
        return ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        );
 * this work for additional information regarding copyright
            possibleMetadata.add(metadata);
import org.opensearch.cluster.routing.RoutingTable;
                IndexMetadata.builder("test")
                    return format.fromXContent(parser);  
        boolean wroteNewIndex = false;
    public void testResolveStatesToBeWritten() throws WriteStateException {  
            settings = Settings.builder()
                assertThat(action.execute(writer), equalTo(3L));
            slowWriteLoggingThresholdMillis = randomLongBetween(2, 100000);  
            new MockLogAppender.SeenEventExpectation(
import org.opensearch.cluster.metadata.Manifest;
        RoutingTable routingTable = RoutingTable.builder().addAsRecovery(metadataNewClusterState.index("test")).build();  
                verify(writer, times(1)).incrementIndicesWritten();
import org.opensearch.cluster.OpenSearchAllocationTestCase;
 * not use this file except in compliance with the License.
    }  
        final DiscoveryNode localNode = newNode("node");  
        boolean clusterManagerEligible = randomBoolean();
                                if (r == 0) {
    }
                        };  
            equals = equals && imd.equals(imd2);
    }  
import org.apache.logging.log4j.LogManager;
                    .put("cluster.routing.allocation.node_concurrent_recoveries", 100)  
                    IncrementalClusterStateWriter.AtomicClusterStateWriter.class
        final IncrementalClusterStateWriter incrementalClusterStateWriter = new IncrementalClusterStateWriter(
                } catch (WriteStateException e) {  
import org.opensearch.cluster.metadata.MetadataIndexStateService;  
        Set<Index> indices = IncrementalClusterStateWriter.getRelevantIndices(
        relevantIndices.add(versionChangedIndex.getIndex());  
            long currentTerm = randomNonNegativeLong();
        IndexMetadata indexMetadata = createIndexMetadata("test");
            .persistentSettings(Settings.builder().put("setting" + settingNo, randomAlphaOfLength(5)).build());  
        }
            .build();
        assertExpectedLogs(
            .build();  
import static org.mockito.Mockito.anyString;
        Metadata metadataNewClusterState = Metadata.builder().put(oldClusterState.metadata().index("test"), false).build();  
            .build();
        }
/*
            .build();
        IndexMetadata indexMetadata = createIndexMetadata("test");
                "writing cluster state took [*] which is above the warn threshold of [*]; "  
        assertThat(indices.size(), equalTo(1));  
                );  
                @Override
            metaStateService.failRandomly();
    private ClusterState clusterStateWithAssignedIndex(IndexMetadata indexMetadata, boolean clusterManagerEligible) {
import org.apache.logging.log4j.Logger;
            .add(newNode("cluster_manager_node", CLUSTER_MANAGER_DATA_ROLES))  
        }  
                        MockDirectoryWrapper.Failure fail = new MockDirectoryWrapper.Failure() {
                .settings(  
        assertThat(actions, hasSize(3));
                wroteNewIndex = true;  
        Set<Index> indices = IncrementalClusterStateWriter.getRelevantIndices(
 * KIND, either express or implied.  See the License for the
        }  
        indices.put(versionChangedIndex.getIndex(), 2L);
import java.util.HashSet;
    private static Metadata randomMetadataForTx() {  
    }
            int indexNo = randomIntBetween(0, 50);
            IndexMetadata imd2 = md1.index(imd.getIndex());  
                assertThat(reason.getValue(), containsString(Long.toString(versionChangedIndex.getVersion())));  
                }
                assertThat(action.getIndex(), equalTo(notChangedIndex.getIndex()));
            failRandomly = true;
            .nodes(generateDiscoveryNodes(clusterManagerEligible))
 * this file be licensed under the Apache-2.0 license or a
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(classLogger)) {
        writeDurationMillis.set(randomLongBetween(1, slowWriteLoggingThresholdMillis - 1));
                    format.toXContent(builder, state);
package org.opensearch.gateway;
import org.opensearch.cluster.routing.allocation.AllocationService;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.times;
                        .put(IndexMetadata.SETTING_INDEX_UUID, "index" + indexNo)
        indices.put(removedIndex.getIndex(), 1L);
            )
            equals = equals && imd.equals(imd2);
                        break;
                    .put("cluster.routing.allocation.node_initial_primaries_recoveries", 100)  
import static org.mockito.Mockito.verifyNoMoreInteractions;  
    public void testSlowLogging() throws WriteStateException, IllegalAccessException {
            MANIFEST_FORMAT = wrap(Manifest.FORMAT);
        IndexMetadata indexMetadata = createIndexMetadata("test");  
    }
import static org.mockito.Mockito.mock;  
        Metadata newMetadata = Metadata.builder().put(versionChangedIndex, true).put(notChangedIndex, false).put(newIndex, false).build();  
        Logger classLogger = LogManager.getLogger(IncrementalClusterStateWriter.class);  
        return builder.build();
        for (IncrementalClusterStateWriter.IndexMetadataAction action : actions) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Settings.builder()
            clusterStateWithReplicatedClosedIndex(indexMetadata, false, true)
public class IncrementalClusterStateWriterTests extends OpenSearchAllocationTestCase {  
                    .numberOfReplicas(2)  
                .build()  
    private ClusterState clusterStateWithReplicatedClosedIndex(
 * the Apache License, Version 2.0 (the "License"); you may
        oldClusterState = ClusterState.builder(oldClusterState).routingTable(routingTable).metadata(metadataNewClusterState).build();
            slowWriteLoggingThresholdMillis = PersistedClusterStateService.SLOW_WRITE_LOGGING_THRESHOLD.get(Settings.EMPTY).millis();  
        ClusterState clusterState,
        );  
            this.invertedFailRate = invertedFailRate;  
 *
            long clusterStateVersion = randomNonNegativeLong();  
    }  
                "should see warning at threshold",
 *
                @Override  
        );
        Set<Index> indices = IncrementalClusterStateWriter.getRelevantIndices(clusterStateWithUnassignedIndex(indexMetadata, false));
        } else {
            .version(oldClusterState.metadata().version() + 1)
import org.apache.lucene.tests.store.MockDirectoryWrapper;
        for (int i = 0; i < numOfIndices; i++) {  
            incrementalClusterStateWriter,  
    }
                assertThat(action.getIndex(), equalTo(newVersionChangedIndex.getIndex()));  
                IncrementalClusterStateWriter.class.getCanonicalName(),  
            Tuple<Manifest, Metadata> manifestAndMetadata = metaStateService.loadFullState();  
        return ClusterState.builder(oldClusterState)
    public void testGetRelevantIndicesForReplicatedClosedAndAssignedIndexOnDataOnlyNode() {
                "should see warning at reduced threshold",
 * specific language governing permissions and limitations
            incrementalClusterStateWriter.updateClusterState(clusterState);  
    public void testGetRelevantIndicesForNonReplicatedClosedIndexOnDataOnlyNode() {  
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                    long globalGeneration = writer.writeGlobalState("global", metadata);  
        );
            )  
}
                randomIntBetween(100, 1000),
        assertThat(indices.size(), equalTo(0));  
 * Modifications Copyright OpenSearch Contributors. See  
                }
                }
                    .state(IndexMetadata.State.CLOSE)
    }
            mock(MetaStateService.class),
            clusterStateWithNonReplicatedClosedIndex(indexMetadata, false)  
                    IncrementalClusterStateWriter.AtomicClusterStateWriter.class
        void noFailures() {
            .metadata(metadataNewClusterState)  
        assertExpectedLogs(
        Metadata metadata = Metadata.builder().put(indexMetadata, false).build();  
        }
        List<IncrementalClusterStateWriter.IndexMetadataAction> actions = IncrementalClusterStateWriter.resolveIndexMetadataActions(
            Set<Metadata> possibleMetadata = new HashSet<>();  
            () -> currentTime.getAndAdd(writeDurationMillis.get())
    }
            .version(oldClusterState.getVersion() + 1)
            Settings.builder()  
    private IndexMetadata createIndexMetadata(String name) {
        Set<DiscoveryNodeRole> dataOnlyRoles = Collections.singleton(DiscoveryNodeRole.DATA_ROLE);  
        Map<Index, Long> indices = new HashMap<>();
                );
        }
        IndexMetadata newIndex = createIndexMetadata("new_index");  
import org.opensearch.env.NodeEnvironment;
        IndexMetadata versionChangedIndex = createIndexMetadata("version_changed_index");
                "should not see warning below threshold",
import org.opensearch.cluster.node.DiscoveryNodeRole;
            clusterState,
import java.util.List;
                    manifest = newManifest;
                IncrementalClusterStateWriter.class.getCanonicalName(),  
                    .build()
        );
                Level.WARN,
            .build();  
        boolean keptPreviousGeneration = false;
                public T fromXContent(XContentParser parser) throws IOException {
        assertTrue(wroteChangedIndex);
        int settingNo = randomIntBetween(0, 10);
        private <T> MetadataStateFormat<T> wrap(MetadataStateFormat<T> format) {  
                        mock.failOn(fail);
        for (IndexMetadata imd : md2) {
            )
        Metadata metadataNewClusterState = Metadata.builder()
                    Manifest newManifest = new Manifest(currentTerm, clusterStateVersion, globalGeneration, indexGenerations);
                        long generation = writer.writeIndex("index", indexMetadata);  
                         * See also MetadataStateFormat#testFailRandomlyAndReadAnyState, that does not break.  
                IncrementalClusterStateWriter.AtomicClusterStateWriter writer = mock(
            incrementalClusterStateWriter,
                assertThat(action.execute(writer), equalTo(3L));
                Map<Index, Long> indexGenerations = new HashMap<>();  
import org.opensearch.core.xcontent.XContentBuilder;  
        IncrementalClusterStateWriter incrementalClusterStateWriter,  
import static org.mockito.Mockito.when;
    }
    private static class MetaStateServiceWithFailures extends MetaStateService {
import org.apache.logging.log4j.Level;  
                .put(PersistedClusterStateService.SLOW_WRITE_LOGGING_THRESHOLD.getKey(), writeDurationMillis.get() + "ms")
        final long startTimeMillis = randomLongBetween(0L, Long.MAX_VALUE - slowWriteLoggingThresholdMillis * 10);
        }
    private ClusterState clusterStateWithUnassignedIndex(IndexMetadata indexMetadata, boolean clusterManagerEligible) {
import org.apache.lucene.store.Directory;  
                protected Directory newDirectory(Path dir) {
        IndexMetadata indexMetadata,
                        possibleMetadata.add(metadata);
            clusterState,
                    possibleMetadata.clear();  
import org.mockito.ArgumentCaptor;
                public void toXContent(XContentBuilder builder, T state) throws IOException {  
            AllocationService strategy = createAllocationService(
            // We only guarantee atomicity of writes, if there is initial Manifest file
 */  
            mockAppender.assertAllExpectationsMatched();
                    closeAfterSuite(mock);  
            INDEX_METADATA_FORMAT = wrap(IndexMetadata.FORMAT);  
            IndexMetadata imd2 = md2.index(imd.getIndex());
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        return equals;  
import java.util.HashMap;  
        MetaStateServiceWithFailures(int invertedFailRate, NodeEnvironment nodeEnv, NamedXContentRegistry namedXContentRegistry) {  
        return ClusterState.builder(oldClusterState)
            newMetadata
        );  
                assertThat(action.getIndex(), equalTo(newIndex.getIndex()));
        Metadata.Builder builder = Metadata.builder()
            }
import java.util.Map;  
                wroteChangedIndex = true;
                    MockDirectoryWrapper mock = newMockFSDirectory(dir);
    @TestLogging(value = "org.opensearch.gateway:WARN", reason = "to ensure that we log gateway events on WARN level")
        if (randomBoolean()) {
                .build();
            incrementalClusterStateWriter,
import org.opensearch.cluster.metadata.Metadata;
        ClusterState oldClusterState = clusterStateWithAssignedIndex(indexMetadata, clusterManagerEligible);
            .routingTable(routingTable)  
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        );  
import org.opensearch.common.settings.ClusterSettings;
                IncrementalClusterStateWriter.AtomicClusterStateWriter writer = mock(
                    for (IndexMetadata indexMetadata : metadata) {
        void failRandomly() {  
        clusterSettings.applySettings(
        );
            };  
                    + "wrote metadata for [0] indices and skipped [0] unchanged indices"  
                "should see warning above threshold",  
        return DiscoveryNodes.builder()
                "*"
                Level.WARN,  
                                int r = randomIntBetween(0, invertedFailRate);
                            public void eval(MockDirectoryWrapper dir) throws IOException {  
        boolean equals = Metadata.isGlobalStateEquals(md1, md2);
                    manifest  
import org.opensearch.test.MockLogAppender;  
                    if (failRandomly) {  
        indices.put(notChangedIndex.getIndex(), 3L);  
                verify(writer, times(1)).incrementIndicesSkipped();  
                    + "wrote metadata for [0] indices and skipped [0] unchanged indices"
        assertThat(indices.size(), equalTo(0));
    }  
        assertTrue(wroteNewIndex);
import org.opensearch.cluster.ClusterState;
        }
            clusterStateWithAssignedIndex(indexMetadata, clusterManagerEligible)
import static org.hamcrest.Matchers.lessThan;  
        }
            .add(newNode("node1", clusterManagerEligible ? CLUSTER_MANAGER_DATA_ROLES : dataOnlyRoles))
            settings,
            .build();
        boolean clusterManagerEligible,  
    public void testAtomicityWithFailures() throws IOException {
                            @Override
            .build();  
import org.opensearch.common.collect.Tuple;
                        indexGenerations.put(indexMetadata.getIndex(), generation);
            clusterState,  
                xContentRegistry()
        IndexMetadata removedIndex = createIndexMetadata("removed_index");
import org.opensearch.cluster.node.DiscoveryNode;
/*
            new MockLogAppender.SeenEventExpectation(
            .routingTable(routingTable)  
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")  
            clusterState,  
        RoutingTable routingTable = strategy.reroute(oldClusterState, "reroute").routingTable();
            .version(oldClusterState.getVersion() + 1)
        IndexMetadata notChangedIndex = createIndexMetadata("not_changed_index");
                    .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        IndexMetadata indexMetadata = createIndexMetadata("test");
        private boolean failRandomly;
    }
import static org.hamcrest.Matchers.containsString;  
            }  
                            }
                    }
    private DiscoveryNodes.Builder generateDiscoveryNodes(boolean clusterManagerEligible) {
        int numOfIndices = randomIntBetween(0, 3);
            .version(oldClusterState.metadata().version() + 1)
            clusterState,
            MetaStateServiceWithFailures metaStateService = new MetaStateServiceWithFailures(
                assertThat(action.execute(writer), equalTo(0L));
        return IndexMetadata.builder(name).settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(2).build();  
                    if (e.isDirty()) {
                    Settings.builder()
        Metadata oldMetadata = Metadata.builder()  
            mockAppender.addExpectation(expectation);
                                    throw new MockDirectoryWrapper.FakeIOException();  
            );
 */
                    .settings(settings(Version.CURRENT).put(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey(), true))
    ) {
                .build();  
 * GitHub history for details.
                );
            super(nodeEnv, namedXContentRegistry);
            for (int i = 0; i < randomIntBetween(1, 5); i++) {  
            .metadata(metadataNewClusterState)
    ) throws IllegalAccessException, WriteStateException {
            if (action instanceof IncrementalClusterStateWriter.WriteNewIndexMetadata) {
            .routingTable(routingTable)
                    possibleMetadata.add(metadata);
import org.opensearch.cluster.node.DiscoveryNodes;  
 * under the License.  
        relevantIndices.add(notChangedIndex.getIndex());
                Settings.builder()
        final AtomicLong writeDurationMillis = new AtomicLong(slowWriteLoggingThresholdMillis);
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
                    .settings(settings(Version.CURRENT))  
 *  
        IndexMetadata indexMetadata = createIndexMetadata("test");
                    }
        );  
import org.opensearch.common.settings.Settings;  
import org.opensearch.test.junit.annotations.TestLogging;
                assertThat(reason.getValue(), containsString(Long.toString(newVersionChangedIndex.getVersion())));
 * The OpenSearch Contributors require contributions made to  
                IndexMetadata.builder("test")
                    return mock;
    }
                verifyNoMoreInteractions(writer);
                .put("cluster.routing.allocation.node_concurrent_recoveries", 100)
        );
            .build();
        Set<Index> indices = IncrementalClusterStateWriter.getRelevantIndices(  
        return ClusterState.builder(oldClusterState)  
import java.nio.file.Path;
    private ClusterState clusterStateWithNonReplicatedClosedIndex(IndexMetadata indexMetadata, boolean clusterManagerEligible) {  
            if (action instanceof IncrementalClusterStateWriter.WriteChangedIndexMetadata) {
                    .numberOfShards(5)
            .metadata(metadata)
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * Unless required by applicable law or agreed to in writing,
        assertTrue(keptPreviousGeneration);  
        ClusterState oldClusterState = clusterStateWithAssignedIndex(indexMetadata, clusterManagerEligible);  
            .put(removedIndex, false)
                IncrementalClusterStateWriter.AtomicClusterStateWriter writer = new IncrementalClusterStateWriter.AtomicClusterStateWriter(
                Level.WARN,
    }  
 * software distributed under the License is distributed on an
                         */
            .routingTable(routingTable)
            clusterStateWithReplicatedClosedIndex(indexMetadata, false, false)
import org.opensearch.cluster.metadata.IndexMetadata;  
            new Manifest(randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong(), Collections.emptyMap()),
            .version(oldClusterState.getVersion() + 1)  
            }  
 * Licensed to Elasticsearch under one or more contributor  
                    writer.writeManifestAndCleanup("manifest", newManifest);
            )
        try (NodeEnvironment env = newNodeEnvironment()) {  
        );  
            );
                    .state(IndexMetadata.State.CLOSE)  
import org.opensearch.cluster.ClusterName;  
                    }  
                Level.WARN,
        for (IndexMetadata imd : md1) {  
        assertExpectedLogs(  
                    .put("cluster.routing.allocation.cluster_concurrent_rebalance", 100)
            incrementalClusterStateWriter,  
                        .build()  
                    IncrementalClusterStateWriter.AtomicClusterStateWriter.class  
    public void testGetRelevantIndicesWithUnassignedShardsOnClusterManagerEligibleNode() {  
                         * If dirty WriteStateException occurred, it's only safe to proceed if there is subsequent
 */
                .build()
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
                when(writer.writeIndex(anyString(), eq(newVersionChangedIndex))).thenReturn(3L);
        private final int invertedFailRate;  
        boolean wroteChangedIndex = false;  
                "writing cluster state took [*] which is above the warn threshold of [*]; "
import java.util.Set;
import static org.hamcrest.Matchers.equalTo;
            if (action instanceof IncrementalClusterStateWriter.KeepPreviousGeneration) {  
        IndexMetadata newVersionChangedIndex = newMetadata.index(versionChangedIndex.getIndex());
        Set<Index> indices = IncrementalClusterStateWriter.getRelevantIndices(clusterStateWithUnassignedIndex(indexMetadata, true));
            indices,
                try {
                keptPreviousGeneration = true;
            new MockLogAppender.SeenEventExpectation(
                IncrementalClusterStateWriter.class.getCanonicalName(),
        assertExpectedLogs(
    public void testGetRelevantIndicesWithAssignedShards() {  
import org.opensearch.core.index.Index;
                when(writer.writeIndex("freshly created", newIndex)).thenReturn(0L);  
    public void testGetRelevantIndicesWithUnassignedShardsOnDataOnlyNode() {  
        assertThat(indices.size(), equalTo(1));  
        Metadata metadataNewClusterState = Metadata.builder()  
import java.io.IOException;  
import org.opensearch.core.xcontent.XContentParser;
        relevantIndices.add(newIndex.getIndex());
 * SPDX-License-Identifier: Apache-2.0
                verify(writer, times(1)).incrementIndicesWritten();
            builder.put(indexMetadata, false);  
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()))
    }  
            relevantIndices,  
            settings = Settings.EMPTY;
            failRandomly = false;
            clusterSettings,  
        );
                @Override
            new MockLogAppender.UnseenEventExpectation(  
import org.opensearch.Version;
                .put(PersistedClusterStateService.SLOW_WRITE_LOGGING_THRESHOLD.getKey(), slowWriteLoggingThresholdMillis + "ms")
            Metadata loadedMetadata = manifestAndMetadata.v2();
        assertThat(indices.size(), equalTo(0));
 * You may obtain a copy of the License at  
                        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            assertTrue(possibleMetadata.stream().anyMatch(md -> metadataEquals(md, loadedMetadata)));  
            .put(
            )
    public void testGetRelevantIndicesForReplicatedClosedButUnassignedIndexOnDataOnlyNode() {
            IndexMetadata indexMetadata = IndexMetadata.builder("index" + indexNo)
                ArgumentCaptor<String> reason = ArgumentCaptor.forClass(String.class);  
            )
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 100)
            return new MetadataStateFormat<T>(format.getPrefix()) {
            metaStateService.writeManifestAndCleanup("startup", Manifest.empty());
                    + "wrote metadata for [0] indices and skipped [0] unchanged indices"  
    }
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", 100)
            METADATA_FORMAT = wrap(Metadata.FORMAT);
                );
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        final long slowWriteLoggingThresholdMillis;  
/*  
        }
            metaStateService.noFailures();
    }
                    .numberOfReplicas(2)
                env,  
            .localNodeId("node1")
            routingTable = strategy.reroute(oldClusterState, "reroute").routingTable();
import static org.mockito.Mockito.verify;
        }
                        /*  
