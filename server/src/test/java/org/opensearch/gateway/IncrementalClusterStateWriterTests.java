            .put(notChangedIndex, false)
                Level.WARN,
                }
                "writing cluster state took [*] which is above the warn threshold of [*]; "
            };
        AllocationService strategy = createAllocationService(
            failRandomly = false;
                    .put("cluster.routing.allocation.cluster_concurrent_rebalance", 100)
                "writing cluster state took [*] which is above the warn threshold of [*]; "
        return equals;
        IndexMetadata indexMetadata = createIndexMetadata("test");
 * this work for additional information regarding copyright
        final AtomicLong writeDurationMillis = new AtomicLong(slowWriteLoggingThresholdMillis);
            .build();
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(classLogger)) {
        ClusterState clusterState,
                "should see warning at reduced threshold",
        return builder.build();
        assertExpectedLogs(
            .metadata(metadataNewClusterState)
                         * See also MetadataStateFormat#testFailRandomlyAndReadAnyState, that does not break.
            Metadata metadata = Metadata.EMPTY_METADATA;
        indices.put(notChangedIndex.getIndex(), 3L);
            .metadata(metadataNewClusterState)
        );
        }
        final long startTimeMillis = randomLongBetween(0L, Long.MAX_VALUE - slowWriteLoggingThresholdMillis * 10);
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                }
            clusterSettings,
        IndexMetadata removedIndex = createIndexMetadata("removed_index");
        );
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                    if (failRandomly) {
        void failRandomly() {
        Set<Index> indices = IncrementalClusterStateWriter.getRelevantIndices(
            .localNodeId("node1")
        final long slowWriteLoggingThresholdMillis;
            )
        }
import org.apache.logging.log4j.LogManager;
        Metadata metadataNewClusterState = Metadata.builder().put(oldClusterState.metadata().index("test"), false).build();
import org.opensearch.common.settings.Settings;
                public T fromXContent(XContentParser parser) throws IOException {
                    IncrementalClusterStateWriter.AtomicClusterStateWriter.class
        final IncrementalClusterStateWriter incrementalClusterStateWriter = new IncrementalClusterStateWriter(
/*
                @Override
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()))
        assertThat(currentTime.get(), lessThan(startTimeMillis + 10 * slowWriteLoggingThresholdMillis)); // ensure no overflow
                        possibleMetadata.add(metadata);
 * The OpenSearch Contributors require contributions made to
                "should see warning at threshold",
                        indexGenerations.put(indexMetadata.getIndex(), generation);
        );
                IncrementalClusterStateWriter.AtomicClusterStateWriter writer = new IncrementalClusterStateWriter.AtomicClusterStateWriter(
            Metadata loadedMetadata = manifestAndMetadata.v2();
/*
                    .build()
                Settings.builder()
        );
                    }
                    possibleMetadata.clear();
                         * successful write of metadata and Manifest. We prefer to break here, not to over complicate test logic.
        }
        final Settings settings;
            equals = equals && imd.equals(imd2);
        Metadata newMetadata = Metadata.builder().put(versionChangedIndex, true).put(notChangedIndex, false).put(newIndex, false).build();
    private ClusterState clusterStateWithReplicatedClosedIndex(
        assertTrue(wroteNewIndex);
    }
            if (action instanceof IncrementalClusterStateWriter.KeepPreviousGeneration) {
                assertThat(action.execute(writer), equalTo(3L));
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 100)
            super(nodeEnv, namedXContentRegistry);
                .put("cluster.routing.allocation.node_concurrent_recoveries", 100)
import static org.mockito.Mockito.times;
            MANIFEST_FORMAT = wrap(Manifest.FORMAT);
            possibleMetadata.add(metadata);
            .build();
 * the Apache License, Version 2.0 (the "License"); you may
            )
            .nodes(generateDiscoveryNodes(clusterManagerEligible))
                IncrementalClusterStateWriter.class.getCanonicalName(),
    }
    }
        assertThat(indices.size(), equalTo(0));
        indices.put(versionChangedIndex.getIndex(), 2L);
            clusterState,
        ClusterState oldClusterState = clusterStateWithUnassignedIndex(indexMetadata, clusterManagerEligible);
                         */
                assertThat(action.execute(writer), equalTo(0L));
    public void testAtomicityWithFailures() throws IOException {
                randomIntBetween(100, 1000),
import java.util.List;
                );
            .put(versionChangedIndex, false)
        }
                .settings(
        Set<Index> indices = IncrementalClusterStateWriter.getRelevantIndices(
 */
import org.opensearch.cluster.metadata.MetadataIndexStateService;
            settings = Settings.builder()
    }
    }
    private ClusterState clusterStateWithAssignedIndex(IndexMetadata indexMetadata, boolean clusterManagerEligible) {
        Metadata.Builder builder = Metadata.builder()
            }
            .version(oldClusterState.getVersion() + 1)
                    .numberOfReplicas(2)
                        mock.failOn(fail);
        IndexMetadata notChangedIndex = createIndexMetadata("not_changed_index");
            IndexMetadata imd2 = md2.index(imd.getIndex());
                    manifest
    private ClusterState clusterStateWithNonReplicatedClosedIndex(IndexMetadata indexMetadata, boolean clusterManagerEligible) {
import java.util.Set;
                    }
                .put(PersistedClusterStateService.SLOW_WRITE_LOGGING_THRESHOLD.getKey(), slowWriteLoggingThresholdMillis + "ms")
        Set<Index> indices = IncrementalClusterStateWriter.getRelevantIndices(clusterStateWithUnassignedIndex(indexMetadata, false));
import java.util.HashMap;
            failRandomly = false;
                    writer.writeManifestAndCleanup("manifest", newManifest);
        relevantIndices.add(versionChangedIndex.getIndex());
        Metadata oldMetadata = Metadata.builder()
            .build();
        assertTrue(keptPreviousGeneration);
        return DiscoveryNodes.builder()
 * GitHub history for details.
        IndexMetadata indexMetadata = createIndexMetadata("test");
        oldClusterState = ClusterState.builder(oldClusterState).routingTable(routingTable).metadata(metadataNewClusterState).build();
 * Licensed to Elasticsearch under one or more contributor
        clusterSettings.applySettings(
                IncrementalClusterStateWriter.AtomicClusterStateWriter writer = mock(
        );
                    long globalGeneration = writer.writeGlobalState("global", metadata);
                wroteNewIndex = true;
 *    http://www.apache.org/licenses/LICENSE-2.0
            .add(newNode("cluster_manager_node", CLUSTER_MANAGER_DATA_ROLES))
                "should not see warning below threshold",
                        long generation = writer.writeIndex("index", indexMetadata);
                IncrementalClusterStateWriter.class.getCanonicalName(),
                        MockDirectoryWrapper.Failure fail = new MockDirectoryWrapper.Failure() {
            incrementalClusterStateWriter,
        assertExpectedLogs(
                when(writer.writeIndex(anyString(), eq(newVersionChangedIndex))).thenReturn(3L);
                .build()
        writeDurationMillis.set(randomLongBetween(slowWriteLoggingThresholdMillis, slowWriteLoggingThresholdMillis * 2));
                } catch (WriteStateException e) {
            .put(removedIndex, false)
                    .put("cluster.routing.allocation.node_concurrent_recoveries", 100)
 * this file be licensed under the Apache-2.0 license or a
import static org.mockito.Mockito.when;
            incrementalClusterStateWriter,
        IncrementalClusterStateWriter incrementalClusterStateWriter,
        ClusterState oldClusterState = clusterStateWithAssignedIndex(indexMetadata, clusterManagerEligible);
                keptPreviousGeneration = true;
        boolean wroteChangedIndex = false;
                    format.toXContent(builder, state);
        IndexMetadata newVersionChangedIndex = newMetadata.index(versionChangedIndex.getIndex());
        }
        int settingNo = randomIntBetween(0, 10);
 * KIND, either express or implied.  See the License for the
    public void testGetRelevantIndicesForNonReplicatedClosedIndexOnDataOnlyNode() {
            IndexMetadata imd2 = md1.index(imd.getIndex());
                    .state(IndexMetadata.State.CLOSE)
        IndexMetadata indexMetadata = createIndexMetadata("test");
            failRandomly = true;
import static org.mockito.Mockito.verify;
                    Settings.builder()
        for (int i = 0; i < numOfIndices; i++) {
            .routingTable(routingTable)
import org.opensearch.cluster.routing.RoutingTable;
import java.util.HashSet;
            Tuple<Manifest, Metadata> manifestAndMetadata = metaStateService.loadFullState();
import org.mockito.ArgumentCaptor;
                IndexMetadata.builder("test")
                Map<Index, Long> indexGenerations = new HashMap<>();
            )
                assertThat(action.execute(writer), equalTo(3L));
                    .numberOfShards(5)
                wroteChangedIndex = true;
            METADATA_FORMAT = wrap(Metadata.FORMAT);
    private IndexMetadata createIndexMetadata(String name) {
        Metadata metadataNewClusterState = Metadata.builder()
        private <T> MetadataStateFormat<T> wrap(MetadataStateFormat<T> format) {
import org.opensearch.cluster.node.DiscoveryNodeRole;
                )
            newMetadata
            metaStateService.writeManifestAndCleanup("startup", Manifest.empty());
                .put(PersistedClusterStateService.SLOW_WRITE_LOGGING_THRESHOLD.getKey(), writeDurationMillis.get() + "ms")
        assertExpectedLogs(
            .routingTable(routingTable)
                    if (e.isDirty()) {
        Set<Index> indices = IncrementalClusterStateWriter.getRelevantIndices(
        RoutingTable routingTable = RoutingTable.builder().addAsRecovery(metadataNewClusterState.index("test")).build();
    }
        int numOfIndices = randomIntBetween(0, 3);
            int indexNo = randomIntBetween(0, 50);
                "writing cluster state took [*] which is above the warn threshold of [*]; "
                    possibleMetadata.add(metadata);
                when(writer.writeIndex("freshly created", newIndex)).thenReturn(0L);
            );
                verifyNoMoreInteractions(writer);
        return IndexMetadata.builder(name).settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(2).build();
                                    throw new MockDirectoryWrapper.FakeIOException();
import static org.hamcrest.Matchers.lessThan;
    }
    }
import java.io.IOException;
        boolean clusterManagerEligible,
                    + "wrote metadata for [0] indices and skipped [0] unchanged indices"
/*
                xContentRegistry()
    }
    public void testSlowLogging() throws WriteStateException, IllegalAccessException {
            clusterStateWithReplicatedClosedIndex(indexMetadata, false, false)
import org.opensearch.cluster.metadata.IndexMetadata;
            .routingTable(routingTable)
        Logger classLogger = LogManager.getLogger(IncrementalClusterStateWriter.class);
        final DiscoveryNode localNode = newNode("node");
            mockAppender.addExpectation(expectation);
        boolean keptPreviousGeneration = false;
        Set<Index> indices = IncrementalClusterStateWriter.getRelevantIndices(
            .clusterManagerNodeId(clusterManagerEligible ? "node1" : "cluster_manager_node");
import static org.mockito.Mockito.verifyNoMoreInteractions;
            }
import static org.mockito.Mockito.anyString;
        assertThat(indices.size(), equalTo(1));
 *
            }
        IndexMetadata indexMetadata = createIndexMetadata("test");
public class IncrementalClusterStateWriterTests extends OpenSearchAllocationTestCase {
        );
 * specific language governing permissions and limitations
package org.opensearch.gateway;
                    }
                verify(writer).writeIndex(reason.capture(), eq(newVersionChangedIndex));
                    IncrementalClusterStateWriter.AtomicClusterStateWriter.class
        }
            for (int i = 0; i < randomIntBetween(1, 5); i++) {
                metadata = randomMetadataForTx();
import org.apache.lucene.tests.store.MockDirectoryWrapper;
            .build();
                verify(writer, times(1)).incrementIndicesWritten();
        IndexMetadata newIndex = createIndexMetadata("new_index");
        assertThat(indices.size(), equalTo(1));
        relevantIndices.add(newIndex.getIndex());
            new MockLogAppender.SeenEventExpectation(
                ArgumentCaptor<String> reason = ArgumentCaptor.forClass(String.class);
        }
            metaStateService.failRandomly();
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.Version;
import java.util.Collections;
            .build();
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                        /*
            long clusterStateVersion = randomNonNegativeLong();
 * You may obtain a copy of the License at
        assertThat(indices.size(), equalTo(0));
                    return mock;
import org.opensearch.cluster.metadata.Metadata;
            .add(newNode("node1", clusterManagerEligible ? CLUSTER_MANAGER_DATA_ROLES : dataOnlyRoles))
        Metadata metadata = Metadata.builder().put(indexMetadata, false).build();
                public void toXContent(XContentBuilder builder, T state) throws IOException {
                    .numberOfReplicas(2)
                IncrementalClusterStateWriter.class.getCanonicalName(),
            .persistentSettings(Settings.builder().put("setting" + settingNo, randomAlphaOfLength(5)).build());
            .version(oldClusterState.getVersion() + 1)
            settings,
                    metaStateService,
    private static Metadata randomMetadataForTx() {
            mockAppender.assertAllExpectationsMatched();
            settings = Settings.EMPTY;
                );
                    return format.fromXContent(parser);
        for (IndexMetadata imd : md1) {
                         * If dirty WriteStateException occurred, it's only safe to proceed if there is subsequent
    }
        for (IndexMetadata imd : md2) {
            .metadata(metadataNewClusterState)
    ) {
            .version(oldClusterState.metadata().version() + 1)
                "should see warning above threshold",
                .build()
        MetaStateServiceWithFailures(int invertedFailRate, NodeEnvironment nodeEnv, NamedXContentRegistry namedXContentRegistry) {
        MockLogAppender.LoggingExpectation expectation
        }
            this.invertedFailRate = invertedFailRate;
        assertThat(actions, hasSize(3));
        boolean equals = Metadata.isGlobalStateEquals(md1, md2);
        for (IncrementalClusterStateWriter.IndexMetadataAction action : actions) {
            .version(oldClusterState.metadata().version() + 1)
import org.opensearch.cluster.ClusterName;
                    .numberOfShards(5)
        }
                    .settings(settings(Version.CURRENT))
import static org.hamcrest.Matchers.equalTo;
        boolean clusterManagerEligible = randomBoolean();
        IndexMetadata indexMetadata,
    }
            oldMetadata,
            .version(oldClusterState.getVersion() + 1)
                    for (IndexMetadata indexMetadata : metadata) {
                .build();
                        break;
                "*"
import org.apache.logging.log4j.Level;
                    MockDirectoryWrapper mock = newMockFSDirectory(dir);
import org.apache.logging.log4j.Logger;
        );
    ) throws IllegalAccessException, WriteStateException {
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            indices,
            .metadata(metadata)
                    Manifest newManifest = new Manifest(currentTerm, clusterStateVersion, globalGeneration, indexGenerations);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            clusterStateWithAssignedIndex(indexMetadata, clusterManagerEligible)
import org.opensearch.cluster.routing.allocation.AllocationService;
                            }
            AllocationService strategy = createAllocationService(
        IndexMetadata indexMetadata = createIndexMetadata("test");
            clusterState,
        boolean assigned
import java.util.Map;
        } else {
            .build();
                                }
        if (randomBoolean()) {
            new MockLogAppender.UnseenEventExpectation(
            clusterStateWithNonReplicatedClosedIndex(indexMetadata, false)
            slowWriteLoggingThresholdMillis = randomLongBetween(2, 100000);
        assertExpectedLogs(
        List<IncrementalClusterStateWriter.IndexMetadataAction> actions = IncrementalClusterStateWriter.resolveIndexMetadataActions(
                assertThat(action.getIndex(), equalTo(newIndex.getIndex()));
        Set<Index> indices = IncrementalClusterStateWriter.getRelevantIndices(clusterStateWithUnassignedIndex(indexMetadata, true));
            routingTable = strategy.reroute(oldClusterState, "reroute").routingTable();
 *
            .build();
        private boolean failRandomly;
 * SPDX-License-Identifier: Apache-2.0
                        .build()
                assertThat(action.getIndex(), equalTo(notChangedIndex.getIndex()));
    public void testGetRelevantIndicesWithUnassignedShardsOnClusterManagerEligibleNode() {
            mock(MetaStateService.class),
    private void assertExpectedLogs(
            clusterState,
import static org.mockito.Mockito.mock;
import java.nio.file.Path;
            Settings.builder()
        try (NodeEnvironment env = newNodeEnvironment()) {
    }
        private final int invertedFailRate;
    private static class MetaStateServiceWithFailures extends MetaStateService {
                assertThat(reason.getValue(), containsString(Long.toString(newVersionChangedIndex.getVersion())));
                    IncrementalClusterStateWriter.AtomicClusterStateWriter.class
 * not use this file except in compliance with the License.
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
    private DiscoveryNodes.Builder generateDiscoveryNodes(boolean clusterManagerEligible) {
            Set<Metadata> possibleMetadata = new HashSet<>();
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
            incrementalClusterStateWriter.updateClusterState(clusterState);
import org.opensearch.cluster.ClusterState;
import org.apache.lucene.store.Directory;
            // We only guarantee atomicity of writes, if there is initial Manifest file
            long currentTerm = randomNonNegativeLong();
        relevantIndices.add(notChangedIndex.getIndex());
    public void testGetRelevantIndicesWithAssignedShards() {
            clusterState,
        Map<Index, Long> indices = new HashMap<>();
        Set<Index> relevantIndices = new HashSet<>();
            }
            incrementalClusterStateWriter,
                }
        Metadata metadataNewClusterState = Metadata.builder()
                        };
                verify(writer, times(1)).incrementIndicesWritten();
import org.opensearch.cluster.node.DiscoveryNodes;
                verify(writer, times(1)).incrementIndicesSkipped();
                Level.WARN,
        if (assigned) {
            .put(
    public void testGetRelevantIndicesForReplicatedClosedButUnassignedIndexOnDataOnlyNode() {
            clusterState,
import org.opensearch.core.xcontent.NamedXContentRegistry;
            equals = equals && imd.equals(imd2);
            () -> currentTime.getAndAdd(writeDurationMillis.get())
                    manifest = newManifest;
 * compatible open source license.
            metaStateService.noFailures();
        assertThat(indices.size(), equalTo(0));
        }
            )
        );
            return new MetadataStateFormat<T>(format.getPrefix()) {
                        .put(IndexMetadata.SETTING_INDEX_UUID, "index" + indexNo)
                    .put("cluster.routing.allocation.node_initial_primaries_recoveries", 100)
                    + "wrote metadata for [0] indices and skipped [0] unchanged indices"
            relevantIndices,
            if (action instanceof IncrementalClusterStateWriter.WriteNewIndexMetadata) {
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", 100)
                assertThat(reason.getValue(), containsString(Long.toString(versionChangedIndex.getVersion())));
                    .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        boolean wroteNewIndex = false;
        writeDurationMillis.set(randomLongBetween(1, slowWriteLoggingThresholdMillis - 1));
import static org.mockito.Mockito.eq;
                    .state(IndexMetadata.State.CLOSE)
                    + "wrote metadata for [0] indices and skipped [0] unchanged indices"
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            clusterStateWithReplicatedClosedIndex(indexMetadata, false, true)
        return ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        }
            Settings.builder()
        indices.put(removedIndex.getIndex(), 1L);
    }
import org.opensearch.core.index.Index;
    }
                Level.WARN,
            )
                        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
 */
            MetaStateServiceWithFailures metaStateService = new MetaStateServiceWithFailures(
    public void testGetRelevantIndicesForReplicatedClosedAndAssignedIndexOnDataOnlyNode() {
                }
    private ClusterState clusterStateWithUnassignedIndex(IndexMetadata indexMetadata, boolean clusterManagerEligible) {
import org.opensearch.cluster.metadata.Manifest;
        );
                IncrementalClusterStateWriter.AtomicClusterStateWriter writer = mock(
 * ownership. Elasticsearch licenses this file to you under
    }
        return ClusterState.builder(oldClusterState)
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        final AtomicLong currentTime = new AtomicLong(startTimeMillis);
        void noFailures() {
import org.opensearch.env.NodeEnvironment;
 */
                Level.WARN,
import org.opensearch.common.collect.Tuple;
import org.opensearch.core.xcontent.XContentParser;
    public void testResolveStatesToBeWritten() throws WriteStateException {
                );
                    closeAfterSuite(mock);
                assertThat(action.getIndex(), equalTo(newVersionChangedIndex.getIndex()));
}
        return ClusterState.builder(oldClusterState)
        );
                protected Directory newDirectory(Path dir) {
            slowWriteLoggingThresholdMillis = PersistedClusterStateService.SLOW_WRITE_LOGGING_THRESHOLD.get(Settings.EMPTY).millis();
        return ClusterState.builder(oldClusterState)
        assertTrue(wroteChangedIndex);
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.MockLogAppender;
    }
 * under the License.
            );
            new MockLogAppender.SeenEventExpectation(
            .build();
            builder.put(indexMetadata, false);
        ClusterState oldClusterState = clusterStateWithAssignedIndex(indexMetadata, clusterManagerEligible);
            new Manifest(randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong(), Collections.emptyMap()),
            if (action instanceof IncrementalClusterStateWriter.WriteChangedIndexMetadata) {
 *
            .routingTable(routingTable)
            INDEX_METADATA_FORMAT = wrap(IndexMetadata.FORMAT);
                                if (r == 0) {
                    .settings(settings(Version.CURRENT).put(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey(), true))
        assertThat(indices.size(), equalTo(0));
            incrementalClusterStateWriter,
    }
            new MockLogAppender.SeenEventExpectation(
    }
                env,
                );
 * software distributed under the License is distributed on an
            IndexMetadata indexMetadata = IndexMetadata.builder("index" + indexNo)
                .build();
            .put(
        RoutingTable routingTable = RoutingTable.builder().addAsRecovery(metadataNewClusterState.index("test")).build();
    }
import static org.hamcrest.Matchers.hasSize;
                @Override
import org.opensearch.test.junit.annotations.TestLogging;
    @TestLogging(value = "org.opensearch.gateway:WARN", reason = "to ensure that we log gateway events on WARN level")
                @Override
                IncrementalClusterStateWriter.class.getCanonicalName(),
    private boolean metadataEquals(Metadata md1, Metadata md2) {
    public void testGetRelevantIndicesWithUnassignedShardsOnDataOnlyNode() {
            )
import org.opensearch.cluster.node.DiscoveryNode;
            assertTrue(possibleMetadata.stream().anyMatch(md -> metadataEquals(md, loadedMetadata)));
        IndexMetadata versionChangedIndex = createIndexMetadata("version_changed_index");
        );
import static org.hamcrest.Matchers.containsString;
        }
import org.opensearch.common.settings.ClusterSettings;
                            @Override
        Set<DiscoveryNodeRole> dataOnlyRoles = Collections.singleton(DiscoveryNodeRole.DATA_ROLE);
            Manifest manifest = Manifest.empty();
                IndexMetadata.builder("test")
                                int r = randomIntBetween(0, invertedFailRate);
                IncrementalClusterStateWriter.AtomicClusterStateWriter writer = mock(
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
        IndexMetadata indexMetadata = createIndexMetadata("test");
                try {
        );
        RoutingTable routingTable = strategy.reroute(oldClusterState, "reroute").routingTable();
import java.util.concurrent.atomic.AtomicLong;
                            public void eval(MockDirectoryWrapper dir) throws IOException {
