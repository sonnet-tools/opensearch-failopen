                }
                    indexWriter.addIndexes(dupDirectory);
                                        .settings(
            ).getMessage();
import org.opensearch.common.settings.Settings;
                                .put(
                        "should see warning above threshold",
                                            .settings(
                assertThat(
                                .put(
                Arrays.stream(dataPaths1).anyMatch(p -> message.contains(p.toString()))
                    )
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(dataPaths2)) {
                writer.writeFullStateAndCommit(
 * SPDX-License-Identifier: Apache-2.0
                writeState(
                                                .put(IndexMetadata.SETTING_INDEX_UUID, addedIndexUuid)
                }
            }
                }
        final AtomicBoolean throwException = new AtomicBoolean();
    }
                    ClusterState.builder(clusterState).version(randomLongBetween(1L, Long.MAX_VALUE)).build()
                        )
                                            Settings.builder()
            }
            final String updatedIndexUuid = UUIDs.randomBase64UUID(random());
            final long version = randomLongBetween(1L, Long.MAX_VALUE);
                                                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
                    writer,
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                        .incrementVersion()
    }
        }
    }
                );
                        )
                    } else {
            };
        final Path[] dataPaths2 = createDataPaths();
            try (Writer writer = persistedClusterStateService.createWriter()) {
                    0L,
    }
                    ClusterState.builder(clusterState)
                final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));
                "[" + message + "] should match " + Arrays.toString(dataPaths2),
        }
 */
                            return super.createOutput(name, context);
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(createDataPaths())) {
 * Unless required by applicable law or agreed to in writing,
    }
                    indexWriter.commit();
                    clusterState
            IOUtils.rm(randomFrom(unimportantPaths));
import org.opensearch.test.OpenSearchTestCase;
                                    )
                        }
                    )
    public void testPersistsAndReloadsIndexMetadataIffVersionOrTermChanges() throws IOException {
import org.apache.lucene.index.Term;
        }
                    ClusterState.builder(clusterState)
                                        )
        final long freshVersion = randomLongBetween(2L, Long.MAX_VALUE);
                        "writing cluster state took [*] which is above the warn threshold of [*]; " + "wrote full state with [0] indices"
                    writer,
                    1L,
                xContentRegistry(),
                                                .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(classLogger)) {
                writer.writeFullStateAndCommit(
                                        .settings(
                writer.writeFullStateAndCommit(
            final IndexMetadata indexMetadata = clusterState.metadata().index("test");
                                                .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
            try (Writer writer = persistedClusterStateService.createWriter()) {
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
                            .version(randomLongBetween(1L, Long.MAX_VALUE))
                                .version(clusterState.metadata().version() + 1)
                            Metadata.builder(clusterState.metadata())
                );
            };
                "[" + message + "] should match " + Arrays.toString(dataPaths2),
                        Level.WARN,
import org.opensearch.test.MockLogAppender;
                Arrays.stream(dataPaths2).anyMatch(p -> message.contains(p.toString()))
                IllegalStateException.class,
                    )
                    1L,
                    0L,
                            Metadata.builder(clusterState.metadata())
        );
    public void testFailsIfGlobalMetadataIsMissing() throws IOException {
        final long freshTerm = randomLongBetween(1L, Long.MAX_VALUE);
            ).getMessage();
                assertExpectedLogs(
                final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));
                allOf(containsString("mismatched cluster UUIDs in metadata"), containsString(clusterUUID1), containsString(clusterUUID2))
            }
                "[" + message + "] should match " + Arrays.toString(dataPaths1),
                writeState(
                                .coordinationMetadata(
package org.opensearch.gateway;
                        .metadata(
                ClusterState clusterState = loadPersistedClusterState(persistedClusterStateService);
import java.util.stream.Stream;
    public void testFailsOnMismatchedNodeIds() throws IOException {
 * compatible open source license.
            }
                assertThat(indexMetadata.getVersion(), equalTo(indexMetadataVersion));
                            }
                    if (randomBoolean()) {
            assertThat(clusterState.metadata().index("updated").getIndexUUID(), equalTo(updatedIndexUuid));
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(dataPaths1)) {
                assertThat(indexMetadata.getIndexUUID(), equalTo(indexUUID));
            );
        if (randomBoolean()) {
                writeState(
                            Metadata.builder(clusterState.metadata())
                                        .settings(
            }
                        .incrementVersion()
public class PersistedClusterStateServiceTests extends OpenSearchTestCase {
            assertTrue(
            final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));
                );
            assertThat(indexMetadata.getIndexUUID(), equalTo(indexUUID));
            // check if we can open writer again
                                    )
                        Level.WARN,
                writer.writeFullStateAndCommit(
        final Path[] combinedPaths = Stream.concat(Arrays.stream(dataPaths1), Arrays.stream(dataPaths2)).toArray(Path[]::new);
import static org.hamcrest.Matchers.allOf;
            try (Writer writer = persistedClusterStateService.createWriter()) {
                        "should not see warning below threshold",
                        )
                () -> currentTime.getAndAdd(writeDurationMillis.get())
                IllegalStateException.class,
                        .metadata(
                    )
                        .metadata(
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {
                        .build(),
                writer.writeFullStateAndCommit(
                        )
            final String message = expectThrows(
            for (Index index : indices) {
                    containsString(brokenPath.toString()),
                    Settings.builder()
                    .loadBestOnDiskState();
    }
                .build()
        );
                );
            }
                    containsString("simulated")
                                        .settings(
                final ClusterState clusterState = loadPersistedClusterState(persistedClusterStateService);
        final Path[] dataPaths1 = createDataPaths();
        final DiscoveryNode localNode = new DiscoveryNode("node", buildNewFakeTransportAddress(), Version.CURRENT);
            try (Writer writer = persistedClusterStateService.createWriter()) {
    }
        final Path[] dataPaths2 = createDataPaths();
                    ClusterState.builder(clusterState)
            try (Writer writer = persistedClusterStateService.createWriter()) {
                final long newTerm = randomNonNegativeLong();
            final ClusterState clusterState = clusterStateFromMetadata(onDiskState.lastAcceptedVersion, onDiskState.metadata);
                Directory createDirectory(Path path) throws IOException {
                        .build()
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
/*
                    clusterState
                            Metadata.builder(clusterState.metadata()).clusterUUID(clusterUUID).clusterUUIDCommitted(true).version(version)
                for (int i = 0; i < writes; i++) {
import org.apache.logging.log4j.Logger;
        }
            xContentRegistry(),
                    .incrementVersion()
import org.opensearch.cluster.ClusterState;
 */
                                        )
    public void testReloadsMetadataAcrossMultipleSegments() throws IOException {
                nodeEnvironment,
                        .incrementVersion()
                        .metadata(
                                                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
        long currentTerm,
                assertThat(indexMetadata.getVersion(), equalTo(indexMetadataVersion));
                        Metadata.builder(clusterState.metadata())
import org.opensearch.env.NodeMetadata;
                                        .version(randomLongBetween(0L, Long.MAX_VALUE - 1) - 1) // -1 because it's incremented in .put()
                );
                                        )
            assertThat(
                                        IndexMetadata.builder(index.getName())
                            .build(),
    public void testClosesWriterOnFatalError() throws IOException {
                                    CoordinationMetadata.builder(clusterState.coordinationMetadata()).term(freshTerm).build()
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {
                assertExpectedLogs(
                try (IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig)) {
    public void testSlowLogging() throws IOException, IllegalAccessException {
            try (
                                                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
        for (int i = 0; i < dataPaths.length; i++) {
                    1L,
            ClusterState clusterState = loadPersistedClusterState(persistedClusterStateService);
        }
            final PersistedClusterStateService persistedClusterStateService = new PersistedClusterStateService(
            .build();
                try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                            )
            IllegalStateException.class,
                xContentRegistry(),
            final PersistedClusterStateService persistedClusterStateService = newPersistedClusterStateService(nodeEnvironment);
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {
        return new PersistedClusterStateService(
            settings = Settings.builder()
                    new MockLogAppender.SeenEventExpectation(
                    freshTerm,
        );
                    staleTerm,
 * Licensed to Elasticsearch under one or more contributor
                                .put(
                    clusterState
                        writer,
                writeDurationMillis.set(randomLongBetween(slowWriteLoggingThresholdMillis, slowWriteLoggingThresholdMillis * 2));
            final String indexName = randomAlphaOfLength(10);
                        Level.WARN,
                IndexMetadata indexMetadata = clusterState.metadata().index("test");
                    1L,
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {
            try (Directory directory = new NIOFSDirectory(brokenPath.resolve(PersistedClusterStateService.METADATA_DIRECTORY_NAME))) {
                Directory dupDirectory = new NIOFSDirectory(dupPath.resolve(PersistedClusterStateService.METADATA_DIRECTORY_NAME))
            : new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
            nodeIds[0] = nodeEnvironment.nodeId();
                assertThat(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.get(indexMetadata.getSettings()), equalTo(0));
                assertFalse(clusterState.metadata().clusterUUIDCommitted());
                        .metadata(
                        .version(freshVersion)
                            .clusterUUID(UUIDs.randomBase64UUID(random()))
                xContentRegistry(),
                try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
            assertThat(clusterState.metadata().clusterUUID(), equalTo(clusterUUID));
 * Modifications Copyright OpenSearch Contributors. See
                                .put(
                    .build();
        final AtomicLong writeDurationMillis = new AtomicLong(slowWriteLoggingThresholdMillis);
import java.util.concurrent.atomic.AtomicBoolean;
    private static ClusterState clusterStateFromMetadata(long version, Metadata metadata) {
                    writer,
                            Metadata.builder(clusterState.metadata())
                    writer,
                        @Override
        }
                        PersistedClusterStateService.class.getCanonicalName(),
            message,
                        .incrementVersion()
 * this file be licensed under the Apache-2.0 license or a
                        public void sync(Collection<String> names) {
            }
                        0L,
            () -> 0L
            try (Writer writer = persistedClusterStateService.createWriter()) {
                    ClusterState.builder(clusterState)
                        "writing cluster state took [*] which is above the warn threshold of [*]; "
                            Metadata.builder(clusterState.metadata())
            }
            );
                    );
                        .build()
                final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));
    private static void writeState(Writer writer, long currentTerm, ClusterState clusterState, ClusterState previousState)
            }
                    )
            }
                writeState(
                writeState(
        final Path[] dataPaths1 = createDataPaths();
                    newClusterState,
        assertThat(
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(dataPaths2)) {
            "[" + failure + "] should match " + Arrays.toString(dataPaths2),
                                .put(
                        writer.commit(newTerm, newState.version());
                allOf(
                indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
            final PersistedClusterStateService persistedClusterStateService = newPersistedClusterStateService(nodeEnvironment);
                        .build(),
            // check if we can open writer again
                );
                    }
        }
                                .clusterUUIDCommitted(true)
                                    .version(i + 2)
            final String message = expectThrows(
                                                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 2)
                                        .build(),
                        "should see warning at reduced threshold",
                                .put(
                                    IndexMetadata.builder("test")
            settings = Settings.EMPTY;
        final String message = expectThrows(
    public void testFailsIfGlobalMetadataIsDuplicated() throws IOException {
import org.apache.lucene.store.NIOFSDirectory;
                                                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
                        .metadata(
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(dataPaths1)) {
                    .metadata(
                    .incrementVersion()
                        )
                    ClusterState.builder(clusterState)
        final AtomicLong currentTime = new AtomicLong(startTimeMillis);
                () -> newPersistedClusterStateService(nodeEnvironment).loadBestOnDiskState()
                );
                    };
        }
                                    IndexMetadata.builder(indexMetadata)
        final long startTimeMillis = randomLongBetween(0L, Long.MAX_VALUE - slowWriteLoggingThresholdMillis * 10);
        if (randomBoolean() || clusterState.term() != previousState.term() || writer.fullStateWritten == false) {
                () -> 0L
                assertThat(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.get(indexMetadata.getSettings()), equalTo(2));
import static org.hamcrest.Matchers.containsString;
        }
                    } else {
/*
                assertThat(currentTime.get(), lessThan(startTimeMillis + 14 * slowWriteLoggingThresholdMillis)); // ensure no overflow
 * ownership. Elasticsearch licenses this file to you under
                    ClusterState.builder(clusterState)
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(combinedPaths)) {
            try (Writer writer = persistedClusterStateService.createWriter()) {
                assertFalse(writer.isOpen());
                IllegalStateException.class,
import org.opensearch.common.UUIDs;
                        .build(),
                                                .put(IndexMetadata.SETTING_INDEX_UUID, deletedIndexUuid)
                        writeState(writer, newTerm, newState, clusterState);
    public void testFailsIfFreshestStateIsInStaleTerm() throws IOException {
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(createDataPaths())) {
                    clusterState,
                    writer,
                    null,
                                throw new IOException("simulated");
    }
                );
        final String clusterUUID1 = UUIDs.randomBase64UUID(random());
                                .put(
                            .clusterUUIDCommitted(true)
                clusterState = loadPersistedClusterState(persistedClusterStateService);
            }
        Logger classLogger = LogManager.getLogger(PersistedClusterStateService.class);
            getBigArrays(),
            assertThat(clusterState.term(), equalTo(freshTerm));
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(createDataPaths())) {
                                                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
                    )
                Stream.of(combinedPaths).map(path -> NodeEnvironment.resolveNodePath(path, 0)).toArray(Path[]::new),
                assertThat(clusterState.metadata().indices().size(), equalTo(2));
                    .build();
                                    false
                    ClusterState.builder(clusterState)
        // isn't there any more
        assertTrue(
                                )
            }
import org.apache.lucene.store.IndexOutput;
                getBigArrays(),
                nodeEnvironment,
        PersistedClusterStateService.Writer writer,
                    writer,
                                                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 2)
                                                .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
                        .incrementVersion()
            assertTrue(clusterState.metadata().clusterUUIDCommitted());
                            Metadata.builder(clusterState.metadata())
                }).getMessage(), containsString("simulated"));
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {
            final long newTerm = randomLongBetween(oldTerm + 1, Long.MAX_VALUE);
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(combinedPaths)) {
            final PersistedClusterStateService.OnDiskState onDiskState = newPersistedClusterStateService(nodeEnvironment)
                assertTrue(clusterState.metadata().clusterUUIDCommitted());
        } else {
                    writer,
    public void testFailsIfIndexMetadataIsDuplicated() throws IOException {
            try (Writer ignored = persistedClusterStateService.createWriter()) {
            final Path brokenPath = randomFrom(nodeEnvironment.nodeDataPaths());
    public void testPersistsAndReloadsGlobalMetadata() throws IOException {
                );
        final AtomicBoolean throwException = new AtomicBoolean();
            try (Writer writer = persistedClusterStateService.createWriter()) {
                            .clusterUUID(UUIDs.randomBase64UUID(random()))
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(combinedPaths)) {
                        @Override
                        )
                                )
            assertThat(clusterState.metadata().index("deleted"), nullValue());
                getBigArrays(),
 * specific language governing permissions and limitations
                    indexWriter.commit();
                );
        }
    public void testPersistsAndReloadsIndexMetadataForMultipleIndices() throws IOException {
                    ClusterState.builder(clusterState)
            );
                );
            mockAppender.addExpectation(expectation);
import org.opensearch.cluster.ClusterName;
                    ClusterState.builder(clusterState)
    public void testFailsGracefullyOnExceptionDuringFlush() throws IOException {
                        )
            final Path dupPath = randomValueOtherThan(brokenPath, () -> randomFrom(nodeEnvironment.nodeDataPaths()));
                                )
                );
import org.apache.lucene.index.IndexWriterConfig;
                    clusterState,
                                        )
                indexMetadata = clusterState.metadata().index("test");
                );
                    final Index index = new Index("test-" + i, UUIDs.randomBase64UUID(random()));
                                        .version(randomLongBetween(0L, Long.MAX_VALUE - 1) - 1) // -1 because it's incremented in .put()
                    clusterState
                        .build(),
            final PersistedClusterStateService persistedClusterStateService = newPersistedClusterStateService(nodeEnvironment);
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                    0L,
                assertThat(clusterState.metadata().clusterUUID(), equalTo(clusterUUID));
        final PersistedClusterStateService.OnDiskState onDiskState = persistedClusterStateService.loadBestOnDiskState();
            final Path brokenPath = randomFrom(nodeEnvironment.nodeDataPaths());
            final PersistedClusterStateService persistedClusterStateService = newPersistedClusterStateService(nodeEnvironment);
        final Path[] combinedPaths = Stream.concat(Arrays.stream(dataPaths1), Arrays.stream(dataPaths2)).toArray(Path[]::new);
                                            Settings.builder()
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {
 *
                                )
                            .version(randomLongBetween(1L, Long.MAX_VALUE))
 *
            slowWriteLoggingThresholdMillis = PersistedClusterStateService.SLOW_WRITE_LOGGING_THRESHOLD.get(Settings.EMPTY).millis();
                        .metadata(Metadata.builder(clusterState.metadata()).clusterUUID(clusterUUID2).clusterUUIDCommitted(true).version(1))
                                .version(2)
                                )
                assertThat(expectThrows(OutOfMemoryError.class, () -> {
            failure,
                        }
 * You may obtain a copy of the License at
 * this work for additional information regarding copyright
                            Metadata.builder(clusterState.metadata())
                                        .build(),
                )
                        PersistedClusterStateService.class.getCanonicalName(),
                            }
            writer.writeFullStateAndCommit(currentTerm, clusterState);
import org.apache.lucene.store.Directory;
    }
                assertThat(persistedClusterStateService.loadBestOnDiskState().currentTerm, equalTo(newTerm));
                        .metadata(
                                .coordinationMetadata(
            final ClusterState clusterState = loadPersistedClusterState(persistedClusterStateService);
            ).loadBestOnDiskState()
            final Path brokenPath = randomFrom(nodeEnvironment.nodeDataPaths());
                    clusterState,
                                                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
                                )
                        .put(PersistedClusterStateService.SLOW_WRITE_LOGGING_THRESHOLD.getKey(), writeDurationMillis.get() + "ms")
                    new MockLogAppender.UnseenEventExpectation(
                    ClusterState.builder(clusterState)
        // if someone attempted surgery on the metadata index by hand, e.g. deleting broken segments, then maybe the global metadata
                indexMetadata = clusterState.metadata().index("test");
                assertThat(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.get(indexMetadata.getSettings()), equalTo(0));
                final long newTerm = randomNonNegativeLong();
            assertThat(
                                                .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
    }
            }
                                        .settings(
                                )
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(new Path[] { freshPath })) {
            assertThat(indexMetadata.getVersion(), equalTo(indexMetadataVersion + 1));
                            if (throwException.get()) {
                    clusterState
        ClusterState previousState,
import static org.hamcrest.Matchers.lessThan;
            ).getMessage();
import org.opensearch.cluster.metadata.IndexMetadata;
            final PersistedClusterStateService persistedClusterStateService = newPersistedClusterStateService(nodeEnvironment);
                    null,
                        )
                );
                    writer,
        final Path[] dataPaths = createDataPaths();
                );
                                                .put(IndexMetadata.SETTING_INDEX_UUID, indexUUID)
                    clusterState,
                    )
                                            Settings.builder()
            }
                                    IndexMetadata.builder(indexMetadata)
                    indexWriter.deleteDocuments(new Term("type", "global")); // do not duplicate global metadata
                            Metadata.builder(clusterState.metadata())
            clusterState = loadPersistedClusterState(persistedClusterStateService);
                        .build(),
        final AtomicBoolean throwException = new AtomicBoolean();
                BigArrays.NON_RECYCLING_INSTANCE,
                );
                        .incrementVersion()
            final ClusterState clusterState = loadPersistedClusterState(persistedClusterStateService);
                message,
                writeState(
                    .build();
 * under the License.
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {
import org.opensearch.common.util.BigArrays;
                );
                                .coordinationMetadata(
                        .version(staleVersion)
        }
                writer.writeIncrementalStateAndCommit(currentTerm, previousState, clusterState);
                clusterState = loadPersistedClusterState(persistedClusterStateService);
                    )
    }
            final PersistedClusterStateService persistedClusterStateService = new PersistedClusterStateService(
                            if (throwException.get() && dest.startsWith("segments")) {
            final String message = expectThrows(
import java.util.Collection;
                    .metadata(
                                .version(clusterState.metadata().version() + 1)
                        .incrementVersion()
                        )
                        "writing cluster state took [*] which is above the warn threshold of [*]; " + "wrote full state with [0] indices"
    private NodeEnvironment newNodeEnvironment(Path[] dataPaths) throws IOException {
                );
            ).getMessage();
                @Override
                                            Settings.builder()
                writeDurationMillis.set(randomLongBetween(0, writeDurationMillis.get() - 1));
        return dataPaths;
            }
        final Path[] dataPaths1 = createDataPaths();
 *
                equalTo(2)
                                        .settings(
                writeState(
                    .metadata(
            assertThat(
                writeDurationMillis.set(randomLongBetween(1, slowWriteLoggingThresholdMillis - 1));
                    clusterState
        }
        final long slowWriteLoggingThresholdMillis;
        final String clusterUUID2 = UUIDs.randomBase64UUID(random());
    }
        assertThat(
                    null,
            ) {
                        .metadata(
        throws IOException {
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(dataPaths)) {
                    final ClusterState clusterState = loadPersistedClusterState(persistedClusterStateService);
                        )
            ) {
            }
                    ClusterState.builder(clusterState)
                                        .settings(
                                )
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(combinedPaths)) {
    private void assertExpectedLogs(
        return Settings.builder().put(settings).put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath()).build();
            assertTrue(
import org.opensearch.cluster.node.DiscoveryNodes;
                    clusterState
            }
                final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));
                                                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
            );
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(createDataPaths())) {
                            Metadata.builder(clusterState.metadata())
        final Path[] combinedPaths = Stream.concat(Arrays.stream(dataPaths1), Arrays.stream(dataPaths2)).toArray(Path[]::new);
                                            Settings.builder()
                assertThat(clusterState.metadata().version(), equalTo(version));
                        .build(),
            ) {
                                .version(1L)
                () -> 0L
                    IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.get(clusterState.metadata().index("updated").getSettings()),
                final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));
                        "writing cluster state took [*] which is above the warn threshold of [*]; " + "wrote full state with [0] indices"
                    indexWriter.addIndexes(dupDirectory);
                                    CoordinationMetadata.builder(clusterState.coordinationMetadata()).term(newTerm).build()
                    };
                                                    .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
                );
                assertFalse(writer.isOpen());
        final long freshVersion = randomLongBetween(2L, Long.MAX_VALUE);
                        .metadata(
                        "*"
                final ClusterState clusterState = loadPersistedClusterState(persistedClusterStateService);
                IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.get(clusterState.metadata().index("updated").getSettings()),
import org.apache.lucene.store.FilterDirectory;
import org.opensearch.common.util.MockBigArrays;
        }
    public Settings buildEnvSettings(Settings settings) {
                assertExpectedLogs(
                @Override
                final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));
                        .build(),
                                .version(1)
                writer.writeIncrementalStateAndCommit(
                                        .version(indexMetadataVersion - 1) // -1 because it's incremented in .put()
            Arrays.stream(dataPaths2).anyMatch(p -> failure.contains(p.toString()))
        final long staleVersion = staleTerm == freshTerm ? randomLongBetween(1L, freshVersion - 1) : randomLongBetween(1L, Long.MAX_VALUE);
                Directory directory = new NIOFSDirectory(brokenPath.resolve(PersistedClusterStateService.METADATA_DIRECTORY_NAME));
                () -> 0L
            allOf(containsString("unexpected node ID in metadata"), containsString(nodeIds[0]), containsString(nodeIds[1]))
                    writeState(
    }
                                )
            }
                writer.writeFullStateAndCommit(currentTerm, clusterState);
    public void testLoadsFreshestState() throws IOException {
import org.opensearch.Version;
                                .clusterUUID(clusterUUID)
                    clusterState
                        .incrementVersion()
                final long newTerm = randomNonNegativeLong();
            }
            }
                        ClusterState.builder(clusterState)
                Arrays.stream(dataPaths1).anyMatch(p -> message.contains(p.toString()))
                clusterSettings.applySettings(
                                    CoordinationMetadata.builder(clusterState.coordinationMetadata()).term(oldTerm).build()
            );
                assertFalse(clusterState.metadata().clusterUUIDCommitted());
                    writer,
                }).getMessage(), containsString("simulated"));
                throwException.set(true);
                                        .settings(
        }
                final ClusterState clusterState = loadPersistedClusterState(persistedClusterStateService);
                        "should not see warning below threshold",
            ).getMessage();
        final Path[] dataPaths2 = createDataPaths();
                    0L,
        return clusterStateFromMetadata(onDiskState.lastAcceptedVersion, onDiskState.metadata);
            final long indexMetadataVersion = randomLongBetween(1L, Long.MAX_VALUE);
                        )
        }
        }
                        .version(staleVersion)
        ClusterState clusterState,
                                        )
            }
        assertTrue(settings.hasValue(Environment.PATH_DATA_SETTING.getKey()));
            assertThat(message, allOf(containsString("duplicate global metadata found"), containsString(brokenPath.toString())));
        );
            assertThat(clusterState.metadata().version(), equalTo(version + 1));
                        .metadata(
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(createDataPaths())) {
            final String clusterUUID = UUIDs.randomBase64UUID(random());
            final int writes = between(5, 20);
                    ClusterState.builder(clusterState)
        }
                    return new FilterDirectory(super.createDirectory(path)) {
                clusterState = loadPersistedClusterState(persistedClusterStateService);
                    containsString(indexName),
        final Path[] dataPaths1 = createDataPaths();
                }
    public void testPersistsAndReloadsTerm() throws IOException {
 */
                writeState(
import java.util.List;
                final IndexWriterConfig indexWriterConfig = new IndexWriterConfig();
                // ensure we do not wastefully persist the same index metadata version by making a bad update with the same version
                );
import org.opensearch.core.index.Index;
                getBigArrays(),
import org.apache.lucene.index.IndexWriter;
                        }
                final ClusterState newState = ClusterState.builder(clusterState)
                                                .put(indexMetadata.getSettings())
            }
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));
                writeState(
                                                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
                            .put(
            final String indexUUID = UUIDs.randomBase64UUID(random());
                xContentRegistry(),
                            .clusterUUIDCommitted(true)
                        clusterState
                    };
                        "should see warning at threshold",
        final long staleTerm = randomBoolean() ? freshTerm : randomLongBetween(1L, freshTerm);
                        .metadata(
                                            Settings.builder()
                                        .settings(
            () -> new PersistedClusterStateService(
import org.opensearch.test.junit.annotations.TestLogging;
        MockLogAppender.LoggingExpectation expectation
                            .version(clusterState.version())
                // ensure that we also persist the index metadata when the term changes
                                    IndexMetadata.builder("updated")
        }
                        .build(),
                                    IndexMetadata.builder("deleted")
                        .metadata(
                () -> newPersistedClusterStateService(nodeEnvironment).loadBestOnDiskState()
        final HashSet<Path> unimportantPaths = Arrays.stream(dataPaths).collect(Collectors.toCollection(HashSet::new));
                        Level.WARN,
            ? BigArrays.NON_RECYCLING_INSTANCE
                        )
                assertThat(clusterState.metadata().index("deleted").getIndexUUID(), equalTo(deletedIndexUuid));
                                )
                                .coordinationMetadata(
                        .build()
        final long staleCurrentTerm = randomLongBetween(1L, Long.MAX_VALUE - 1);
                    newClusterState,
            );
                    0L,
                    0L,
                nodeIds[0],
            final long newTerm = randomNonNegativeLong();
                () -> newPersistedClusterStateService(nodeEnvironment).loadBestOnDiskState()
                                    IndexMetadata.builder("added")
        }
            assertTrue(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                                                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
                                )
            assertThat(message, allOf(containsString("no global metadata found"), containsString(brokenPath.toString())));
                                                .put(IndexMetadata.SETTING_INDEX_UUID, indexUUID)
            try (Writer writer = persistedClusterStateService.createWriter()) {
            final PersistedClusterStateService persistedClusterStateService = new PersistedClusterStateService(
import org.apache.lucene.store.IOContext;
                    new MockLogAppender.SeenEventExpectation(
        // first establish consistent node IDs and write initial metadata
    }
        final long freshTerm = randomLongBetween(1L, Long.MAX_VALUE);
                Directory createDirectory(Path path) throws IOException {
            final long oldTerm = randomLongBetween(1L, Long.MAX_VALUE - 1);
        final Path[] combinedPaths = Stream.concat(Arrays.stream(dataPaths1), Arrays.stream(dataPaths2)).toArray(Path[]::new);
            final long globalVersion = randomLongBetween(1L, Long.MAX_VALUE);
                            .version(randomLongBetween(1L, Long.MAX_VALUE))
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
    }
                assertThat(expectThrows(IOError.class, () -> {
            assertThat(persistedClusterStateService.loadBestOnDiskState().currentTerm, equalTo(newTerm));
            final ClusterState clusterState = loadPersistedClusterState(persistedClusterStateService);
                    containsString(indexUUID)
                                    IndexMetadata.builder(indexMetadata)
            }
                        Level.WARN,
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(dataPaths2)) {
            "[" + message + "] should match " + Arrays.toString(dataPaths2),
            final String deletedIndexUuid = UUIDs.randomBase64UUID(random());
        final Path[] dataPaths2 = createDataPaths();
                            .clusterUUID(UUIDs.randomBase64UUID(random()))
                            + "wrote global metadata [false] and metadata for [1] indices and skipped [0] unchanged indices"
                        public IndexOutput createOutput(String name, IOContext context) throws IOException {
import static org.hamcrest.Matchers.nullValue;
                                        .version(randomLongBetween(0L, Long.MAX_VALUE - 1) - 1) // -1 because it's incremented in .put()
            assertTrue(
            assertThat(clusterState.metadata().indices().size(), equalTo(2));
                );
                    writer,
        final String failure = expectThrows(IllegalStateException.class, () -> newNodeEnvironment(combinedPaths)).getMessage();
                writeState(
            try (Writer writer = persistedClusterStateService.createWriter()) {
                writer.writeFullStateAndCommit(newTerm, ClusterState.EMPTY_STATE);
                message,
            unimportantPaths.remove(freshPath);
            assertThat(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.get(indexMetadata.getSettings()), equalTo(3));
                                                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 3)
                assertExpectedLogs(
                    writer,
                                            Settings.builder()
                                                    .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
        final Settings settings;
            assertThat(persistedClusterStateService.loadBestOnDiskState().currentTerm, equalTo(0L));
    }
                    ClusterState.builder(clusterState).version(randomLongBetween(1L, Long.MAX_VALUE)).build(),
                    0L,
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        );
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(createDataPaths())) {
        final Path[] dataPaths2 = createDataPaths();
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {
        }
                    null,
 * software distributed under the License is distributed on an
                final ClusterState newClusterState = ClusterState.builder(clusterState)
        );
                assertFalse(clusterState.metadata().clusterUUIDCommitted());
                final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));
                        .build(),
            final long term = randomLongBetween(1L, Long.MAX_VALUE);
        }
                );
                final ClusterState newState = ClusterState.builder(clusterState)
                                            )
            }
                final IndexMetadata indexMetadata = clusterState.metadata().index(index.getName());
                    clusterState,
                            Metadata.builder(clusterState.metadata())
                .putList(Environment.PATH_DATA_SETTING.getKey(), Arrays.stream(dataPaths).map(Path::toString).collect(Collectors.toList()))
                                            Settings.builder()
        } else {
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(createDataPaths())) {
                    if (randomBoolean()) {
                    containsString("duplicate metadata found"),
            }
                    0L,
        // if someone attempted surgery on the metadata index by hand, e.g. deleting broken segments, then maybe the global metadata
                    clusterState
import java.util.stream.Collectors;
    }
                                                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
        assertTrue(
                )
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(createDataPaths())) {
                    0L,
 * not use this file except in compliance with the License.
                        Metadata.builder(clusterState.metadata())
                                Metadata.builder(clusterState.metadata())
                Directory dupDirectory = new NIOFSDirectory(dupPath.resolve(PersistedClusterStateService.METADATA_DIRECTORY_NAME))
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                        .incrementVersion()
            slowWriteLoggingThresholdMillis = randomLongBetween(2, 100000);
            assertThat(clusterState.version(), equalTo(freshVersion));
                                )
                                .version(version + 1)
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {
        }
import org.opensearch.common.util.MockPageCacheRecycler;
        // verify that the freshest state is chosen
                );
import org.opensearch.gateway.PersistedClusterStateService.Writer;
    public void testFailsOnMismatchedCommittedClusterUUIDs() throws IOException {
import org.opensearch.cluster.node.DiscoveryNode;
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(createDataPaths())) {
            nodeIds[1] = nodeEnvironment.nodeId();
                final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {
    public static Path[] createDataPaths() {
                        .build()
                                            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
                        @Override
                        .incrementVersion()
                                .put(
            nodeEnvironment,
                final ClusterState clusterState = clusterStateFromMetadata(onDiskState.lastAcceptedVersion, onDiskState.metadata);
                        PersistedClusterStateService.class.getCanonicalName(),
                                    .put(
                        .build(),
                                        .version(1L)
                );
                    writer,
    }
import org.opensearch.env.Environment;
                }
                    0L,
                    0L,
 *    http://www.apache.org/licenses/LICENSE-2.0
                    .incrementVersion()
                Directory directory = new NIOFSDirectory(brokenPath.resolve(PersistedClusterStateService.METADATA_DIRECTORY_NAME));
                        public void rename(String source, String dest) throws IOException {
                                    false
                writer.writeFullStateAndCommit(
import java.util.HashSet;
                () -> newPersistedClusterStateService(nodeEnvironment).loadBestOnDiskState()
                                                .put(indexMetadata.getSettings())
        }
        final Path[] combinedPaths = Stream.concat(Arrays.stream(dataPaths1), Arrays.stream(dataPaths2)).toArray(Path[]::new);
    @Override
            try (
                    1L,
                        writeState(writer, newTerm, newState, clusterState);
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()))
            mockAppender.assertAllExpectationsMatched();
        final Path[] dataPaths = new Path[randomIntBetween(1, 4)];
                        .version(freshVersion)
                    containsString(Long.toString(freshCurrentTerm))
                                        )
                throwException.set(true);
                        .build()
import org.opensearch.common.util.io.IOUtils;
                final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));
                        Metadata.builder(clusterState.metadata())
                            Metadata.builder(clusterState.metadata())
                    indexWriter.commit();
                assertThat(indexMetadata.getVersion(), equalTo(indexMetadataVersion + 1));
        }
                Arrays.stream(dataPaths2).anyMatch(p -> message.contains(p.toString()))
                    new MockLogAppender.SeenEventExpectation(
                                                    .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
                Directory createDirectory(Path path) throws IOException {
        }
            final String indexUUID = UUIDs.randomBase64UUID(random());
                    .incrementVersion()
                    clusterState
        }
                            .incrementVersion()
                final ClusterState clusterState = loadPersistedClusterState(persistedClusterStateService);
                                                .put(clusterState.metadata().index("updated").getSettings())
import java.io.IOException;
                final PersistedClusterStateService.OnDiskState onDiskState = newPersistedClusterStateService(nodeEnvironment)
    }
                                                Settings.builder()
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(createDataPaths())) {
                message,
        // if someone attempted surgery on the metadata index by hand, e.g. deleting broken segments, then maybe some index metadata
            }
                    0L,
                nodeEnvironment,
            }
    }
                allOf(
            Settings.builder()
                    .metadata(
                assertThat(clusterState.metadata().index("updated").getIndexUUID(), equalTo(updatedIndexUuid));
        final long staleTerm = randomBoolean() ? freshTerm : randomLongBetween(1L, freshTerm);
                                    IndexMetadata.builder(indexName)
                                .remove("deleted")
            } else {
            PersistedClusterStateService persistedClusterStateService = new PersistedClusterStateService(
            final Path dupPath = randomValueOtherThan(brokenPath, () -> randomFrom(nodeEnvironment.nodeDataPaths()));
                assertExpectedLogs(
import org.apache.logging.log4j.LogManager;
                getBigArrays(),
                        Level.WARN,
                    ClusterState.builder(clusterState).version(randomLongBetween(1L, Long.MAX_VALUE)).build(),
 * the Apache License, Version 2.0 (the "License"); you may
                        "should see warning at threshold",
                    clusterState,
import java.util.Arrays;
                writer.writeFullStateAndCommit(0L, clusterState);
                writeState(writer, freshCurrentTerm, clusterState, clusterState);
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(combinedPaths)) {
        if (randomBoolean() && unimportantPaths.isEmpty() == false) {
            writer.writeIncrementalStateAndCommit(currentTerm, previousState, clusterState);
                                    CoordinationMetadata.builder(clusterState.coordinationMetadata()).term(staleTerm).build()
                writeState(
                assertThat(indexMetadata.getIndexUUID(), equalTo(index.getUUID()));
            assertThat(clusterState.metadata().index("added").getIndexUUID(), equalTo(addedIndexUuid));
            };
                                            .put(IndexMetadata.SETTING_INDEX_UUID, "test-uuid")
        }
import static org.hamcrest.Matchers.equalTo;
        final long freshCurrentTerm = randomLongBetween(staleCurrentTerm + 1, Long.MAX_VALUE);
            }
                    containsString("inconsistent terms found"),
                    new MockLogAppender.UnseenEventExpectation(
    }
            final String message = expectThrows(
        return ClusterState.builder(ClusterName.DEFAULT).version(version).metadata(metadata).build();
        NodeMetadata.FORMAT.cleanupOldFiles(Long.MAX_VALUE, dataPaths2);
                    ClusterState.builder(clusterState).version(randomLongBetween(1L, Long.MAX_VALUE)).build()
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(dataPaths)) {
 * GitHub history for details.
                    writer,
        }
            final List<Index> indices = new ArrayList<>(writes);
                    ClusterState.builder(clusterState)
                    0L,
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(combinedPaths)) {
                            Metadata.builder(clusterState.metadata())
                    clusterState
                assertThat(
                                                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
                        writer.commit(newTerm, newState.version());
                        PersistedClusterStateService.class.getCanonicalName(),
                IllegalStateException.class,
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(dataPaths1)) {
                assertExpectedLogs(
            );
            dataPaths[i] = createTempDir();
 * The OpenSearch Contributors require contributions made to
            ) {
                        .metadata(
        // verify that loadBestOnDiskState has same check
import org.opensearch.common.settings.ClusterSettings;
    }
                    )
                    clusterState,
                );
                        Metadata.builder(clusterState.metadata())
                assertFalse(clusterState.metadata().clusterUUIDCommitted());
    }
                    }
            );
}
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {
                                                .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
                .put(PersistedClusterStateService.SLOW_WRITE_LOGGING_THRESHOLD.getKey(), slowWriteLoggingThresholdMillis + "ms")
                                        )
    private PersistedClusterStateService newPersistedClusterStateService(NodeEnvironment nodeEnvironment) {
            ) {
                clusterSettings,
                    writer,
            assertThat(
                                )
                );
                            .metadata(
                    writer,
            }
                IllegalStateException.class,
import java.io.IOError;
import java.util.ArrayList;
    }
                                        Settings.builder()
                                .put(
import org.apache.logging.log4j.Level;
import java.util.concurrent.atomic.AtomicLong;
                clusterState = loadPersistedClusterState(persistedClusterStateService);
                    writer,
                assertThat(indexMetadata.getIndexUUID(), equalTo(indexUUID));
                );
                    staleCurrentTerm,
                }
                                    CoordinationMetadata.builder(clusterState.coordinationMetadata()).term(freshTerm).build()
                nodeEnvironment,
                    1L,
                    return new FilterDirectory(super.createDirectory(path)) {
                    clusterState
            );
                    0L,
        final String[] nodeIds = new String[2];
    ) throws IllegalAccessException, IOException {
                throwException.set(true);
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {
                final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));
                xContentRegistry(),
                                                    .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
    }
            }
            try (Writer ignored = persistedClusterStateService.createWriter()) {
        }
                .loadBestOnDiskState();
                                                .put(indexMetadata.getSettings())
                .build();
                                        )
            }
                                    true
                }
        final Path freshPath = randomFrom(dataPaths);
        return newNodeEnvironment(
                () -> newPersistedClusterStateService(nodeEnvironment).loadBestOnDiskState()
                            )
                                            Settings.builder()
            final String addedIndexUuid = UUIDs.randomBase64UUID(random());
                                IndexMetadata.builder("test")
                                .coordinationMetadata(CoordinationMetadata.builder(clusterState.coordinationMetadata()).term(1L).build())
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {
                    indices.add(index);
                                .coordinationMetadata(CoordinationMetadata.builder(clusterState.coordinationMetadata()).term(term).build())
                                        )
    @TestLogging(value = "org.opensearch.gateway:WARN", reason = "to ensure that we log gateway events on WARN level")
                    return new FilterDirectory(super.createDirectory(path)) {
            allOf(containsString("unexpected node ID in metadata"), containsString(nodeIds[0]), containsString(nodeIds[1]))
                    writer,
                    containsString(Long.toString(staleCurrentTerm)),
    public void testCrashesWithIOErrorOnCommitFailure() throws IOException {
                    ClusterState.builder(clusterState)
                                    IndexMetadata.builder("updated")
        final Path[] dataPaths1 = createDataPaths();
                        .metadata(Metadata.builder(clusterState.metadata()).clusterUUID(clusterUUID1).clusterUUIDCommitted(true).version(1))
import org.opensearch.cluster.metadata.Metadata;
                        PersistedClusterStateService.class.getCanonicalName(),
        }
        final long staleVersion = staleTerm == freshTerm ? randomLongBetween(1L, freshVersion - 1) : randomLongBetween(1L, Long.MAX_VALUE);
    private static BigArrays getBigArrays() {
                        PersistedClusterStateService.class.getCanonicalName(),
                        .build()
                );
                    )
                writeState(
                    writer,
                                        .build(),
                                )
                "[" + message + "] should match " + Arrays.toString(dataPaths1),
                final ClusterState clusterState = loadPersistedClusterState(persistedClusterStateService);
        // is duplicated
                    new MockLogAppender.SeenEventExpectation(
                    .build();
        ).getMessage();
                    equalTo(1)
                                            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
                                            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
                            throw new OutOfMemoryError("simulated");
                        "*"
                () -> 0L
        return usually()
                        )
 * license agreements. See the NOTICE file distributed with
                    expectThrows(IOException.class, () -> writeState(writer, newTerm, newState, clusterState)).getMessage(),
            try (Writer writer = persistedClusterStateService.createWriter()) {
                            .clusterUUIDCommitted(true)
            final String message = expectThrows(
 * KIND, either express or implied.  See the License for the
                                .coordinationMetadata(
                @Override
                                throw new IOException("simulated");
                                                .put(IndexMetadata.SETTING_INDEX_UUID, updatedIndexUuid)
            if (previousState == null) {
                    ClusterState.builder(clusterState)
import org.opensearch.env.NodeEnvironment;
                                    .settings(
                                .coordinationMetadata(
                                .version(globalVersion)
import java.nio.file.Path;
    private static ClusterState loadPersistedClusterState(PersistedClusterStateService persistedClusterStateService) throws IOException {
/*
                    onDiskState.currentTerm,
                    0L,
import org.opensearch.cluster.coordination.CoordinationMetadata;
                final ClusterState newState = ClusterState.builder(clusterState)
                                    CoordinationMetadata.builder(clusterState.coordinationMetadata()).term(staleTerm).build()
        // is duplicated
                        .incrementVersion()
            Arrays.stream(dataPaths2).anyMatch(p -> message.contains(p.toString()))
                                )
                // ensure that we do persist the same index metadata version by making an update with a higher version
