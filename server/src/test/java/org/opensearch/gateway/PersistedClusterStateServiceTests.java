            try (Writer writer = persistedClusterStateService.createWriter()) {  
                                )
            try (Writer writer = persistedClusterStateService.createWriter()) {  
                nodeEnvironment,  
                                .version(globalVersion)  
        assertThat(  
                                                    .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
        }
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(combinedPaths)) {
                    0L,
                        )
                                .clusterUUID(clusterUUID)  
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(combinedPaths)) {
                        .metadata(
        assertTrue(settings.hasValue(Environment.PATH_DATA_SETTING.getKey()));
 * ownership. Elasticsearch licenses this file to you under  
                assertThat(expectThrows(IOError.class, () -> {
                        "*"
    public void testFailsIfFreshestStateIsInStaleTerm() throws IOException {  
        }
                );  
                );
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(createDataPaths())) {
        // if someone attempted surgery on the metadata index by hand, e.g. deleting broken segments, then maybe the global metadata
            : new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
        final HashSet<Path> unimportantPaths = Arrays.stream(dataPaths).collect(Collectors.toCollection(HashSet::new));
            final ClusterState clusterState = loadPersistedClusterState(persistedClusterStateService);
                    .incrementVersion()
                    )  
                    writer,
import org.opensearch.cluster.node.DiscoveryNodes;  
                    clusterState
    public void testClosesWriterOnFatalError() throws IOException {  
                                    .settings(
        }  
                clusterSettings.applySettings(
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(createDataPaths())) {  
                        writer,  
        assertTrue(
                    new MockLogAppender.SeenEventExpectation(
                );
                    containsString(brokenPath.toString()),
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(dataPaths2)) {
                );  
        }
                    writeState(
                final long newTerm = randomNonNegativeLong();  
                                )  
                                                .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)  
                            Metadata.builder(clusterState.metadata())
                writeState(  
        final Settings settings;
        }  
                        "writing cluster state took [*] which is above the warn threshold of [*]; " + "wrote full state with [0] indices"  
            final IndexMetadata indexMetadata = clusterState.metadata().index("test");  
            };
    public void testSlowLogging() throws IOException, IllegalAccessException {  
            IOUtils.rm(randomFrom(unimportantPaths));
                            Metadata.builder(clusterState.metadata())
            if (previousState == null) {  
import org.opensearch.env.Environment;
                        .metadata(Metadata.builder(clusterState.metadata()).clusterUUID(clusterUUID2).clusterUUIDCommitted(true).version(1))  
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
 * this file be licensed under the Apache-2.0 license or a
            final long term = randomLongBetween(1L, Long.MAX_VALUE);
        );
                writeDurationMillis.set(randomLongBetween(0, writeDurationMillis.get() - 1));
    }
                                                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 2)
                                .remove("deleted")
                        PersistedClusterStateService.class.getCanonicalName(),  
            final String clusterUUID = UUIDs.randomBase64UUID(random());
                }).getMessage(), containsString("simulated"));
                assertThat(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.get(indexMetadata.getSettings()), equalTo(0));
                        PersistedClusterStateService.class.getCanonicalName(),  
            final PersistedClusterStateService persistedClusterStateService = new PersistedClusterStateService(
                        .metadata(
    private static BigArrays getBigArrays() {
import java.util.concurrent.atomic.AtomicLong;  
            assertThat(indexMetadata.getIndexUUID(), equalTo(indexUUID));
                    writer,
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        }  
                () -> newPersistedClusterStateService(nodeEnvironment).loadBestOnDiskState()
        final long staleTerm = randomBoolean() ? freshTerm : randomLongBetween(1L, freshTerm);
                                                .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {  
                    .loadBestOnDiskState();  
                allOf(
        final long staleVersion = staleTerm == freshTerm ? randomLongBetween(1L, freshVersion - 1) : randomLongBetween(1L, Long.MAX_VALUE);  
                        writer.commit(newTerm, newState.version());  
 * Modifications Copyright OpenSearch Contributors. See  
            assertTrue(
                clusterState = loadPersistedClusterState(persistedClusterStateService);  
            PersistedClusterStateService persistedClusterStateService = new PersistedClusterStateService(  
                final IndexWriterConfig indexWriterConfig = new IndexWriterConfig();  
        final AtomicBoolean throwException = new AtomicBoolean();  
                    containsString(indexName),
                                                    .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)  
            assertThat(indexMetadata.getVersion(), equalTo(indexMetadataVersion + 1));
                IllegalStateException.class,  
            final Path dupPath = randomValueOtherThan(brokenPath, () -> randomFrom(nodeEnvironment.nodeDataPaths()));
                nodeEnvironment,
                @Override
            final String addedIndexUuid = UUIDs.randomBase64UUID(random());  
import org.opensearch.cluster.coordination.CoordinationMetadata;
                    .metadata(  
                                .version(clusterState.metadata().version() + 1)  
                        Metadata.builder(clusterState.metadata())
                            )
import static org.hamcrest.Matchers.nullValue;
                                                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
                Arrays.stream(dataPaths2).anyMatch(p -> message.contains(p.toString()))
        Logger classLogger = LogManager.getLogger(PersistedClusterStateService.class);  
                final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));
            assertThat(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.get(indexMetadata.getSettings()), equalTo(3));  
                                    IndexMetadata.builder("test")
    public void testFailsIfGlobalMetadataIsMissing() throws IOException {
            final long globalVersion = randomLongBetween(1L, Long.MAX_VALUE);  
                    ClusterState.builder(clusterState)
        final DiscoveryNode localNode = new DiscoveryNode("node", buildNewFakeTransportAddress(), Version.CURRENT);
        final AtomicLong currentTime = new AtomicLong(startTimeMillis);
 * GitHub history for details.
            final ClusterState clusterState = loadPersistedClusterState(persistedClusterStateService);  
            }
                                    .version(i + 2)
        final AtomicBoolean throwException = new AtomicBoolean();
                                                .put(IndexMetadata.SETTING_INDEX_UUID, addedIndexUuid)  
                                    CoordinationMetadata.builder(clusterState.coordinationMetadata()).term(staleTerm).build()  
            final Path dupPath = randomValueOtherThan(brokenPath, () -> randomFrom(nodeEnvironment.nodeDataPaths()));
                                            Settings.builder()  
                getBigArrays(),
                            }
        ClusterState previousState,
            .build();
 * under the License.  
            dataPaths[i] = createTempDir();  
            settings = Settings.EMPTY;
                                    true
                );
            final Path brokenPath = randomFrom(nodeEnvironment.nodeDataPaths());
 * the Apache License, Version 2.0 (the "License"); you may
                                    false
            assertThat(message, allOf(containsString("duplicate global metadata found"), containsString(brokenPath.toString())));
                        Level.WARN,
                );
                    null,
                    containsString(indexUUID)  
                final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));
 *  
                writeState(  
        final Path[] combinedPaths = Stream.concat(Arrays.stream(dataPaths1), Arrays.stream(dataPaths2)).toArray(Path[]::new);  
                        .build()
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {  
import java.util.Collection;
            }
            );
            final PersistedClusterStateService persistedClusterStateService = new PersistedClusterStateService(  
            ClusterState clusterState = loadPersistedClusterState(persistedClusterStateService);
        final Path[] dataPaths1 = createDataPaths();
            );
        assertTrue(
            };
            clusterState = loadPersistedClusterState(persistedClusterStateService);  
    }
                        "writing cluster state took [*] which is above the warn threshold of [*]; " + "wrote full state with [0] indices"
                    clusterState  
                        public IndexOutput createOutput(String name, IOContext context) throws IOException {
                    freshTerm,
                    indexWriter.addIndexes(dupDirectory);
        final long staleTerm = randomBoolean() ? freshTerm : randomLongBetween(1L, freshTerm);  
                assertThat(currentTime.get(), lessThan(startTimeMillis + 14 * slowWriteLoggingThresholdMillis)); // ensure no overflow  
import static org.hamcrest.Matchers.allOf;
        }
                allOf(containsString("mismatched cluster UUIDs in metadata"), containsString(clusterUUID1), containsString(clusterUUID2))
                        )  
                    containsString("simulated")  
            try (Writer writer = persistedClusterStateService.createWriter()) {
                final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));  
            assertThat(persistedClusterStateService.loadBestOnDiskState().currentTerm, equalTo(newTerm));  
            ) {
                        .version(staleVersion)
                                            Settings.builder()
        final Path[] combinedPaths = Stream.concat(Arrays.stream(dataPaths1), Arrays.stream(dataPaths2)).toArray(Path[]::new);  
                        "should see warning at reduced threshold",
            }
                        .build()  
        return clusterStateFromMetadata(onDiskState.lastAcceptedVersion, onDiskState.metadata);  
                                )
            assertThat(message, allOf(containsString("no global metadata found"), containsString(brokenPath.toString())));
                                                .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
                        "should see warning at threshold",
            allOf(containsString("unexpected node ID in metadata"), containsString(nodeIds[0]), containsString(nodeIds[1]))
                assertTrue(clusterState.metadata().clusterUUIDCommitted());
        MockLogAppender.LoggingExpectation expectation
                }
                                    false
 * Licensed to Elasticsearch under one or more contributor  
            slowWriteLoggingThresholdMillis = randomLongBetween(2, 100000);
                                        )  
            final PersistedClusterStateService persistedClusterStateService = newPersistedClusterStateService(nodeEnvironment);
                    )
                                                .put(IndexMetadata.SETTING_INDEX_UUID, deletedIndexUuid)  
        final Path[] dataPaths1 = createDataPaths();
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(createDataPaths())) {
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(dataPaths2)) {  
                                .version(1)
    }  
        final long freshVersion = randomLongBetween(2L, Long.MAX_VALUE);
    public void testFailsOnMismatchedNodeIds() throws IOException {  
                            .clusterUUIDCommitted(true)
public class PersistedClusterStateServiceTests extends OpenSearchTestCase {
        }  
            );
            final PersistedClusterStateService persistedClusterStateService = newPersistedClusterStateService(nodeEnvironment);  
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(createDataPaths())) {
                                        )
            try (Writer writer = persistedClusterStateService.createWriter()) {
                                                .put(IndexMetadata.SETTING_INDEX_UUID, indexUUID)  
                                    IndexMetadata.builder("added")
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(combinedPaths)) {
            try (Writer writer = persistedClusterStateService.createWriter()) {
                        .build()
            final long newTerm = randomLongBetween(oldTerm + 1, Long.MAX_VALUE);
    }
import java.util.List;
import org.opensearch.cluster.ClusterName;  
import org.apache.lucene.store.FilterDirectory;
                        .metadata(
                                )  
                        .incrementVersion()
                throwException.set(true);
                                        Settings.builder()  
            }
    }  
                writeDurationMillis.set(randomLongBetween(1, slowWriteLoggingThresholdMillis - 1));  
                                        .settings(
                );
        }
                    ClusterState.builder(clusterState)
                assertThat(
import org.apache.lucene.index.Term;
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {
                }
            final String indexUUID = UUIDs.randomBase64UUID(random());  
                            Metadata.builder(clusterState.metadata())
        final Path[] dataPaths1 = createDataPaths();
                final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));
                writer.writeFullStateAndCommit(
                clusterSettings,
        final Path[] dataPaths2 = createDataPaths();  
                    };  
 *    http://www.apache.org/licenses/LICENSE-2.0
                }  
                    .incrementVersion()
            try (  
 * KIND, either express or implied.  See the License for the
                                .version(1L)
                                                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 3)
                    containsString(Long.toString(freshCurrentTerm))  
    private NodeEnvironment newNodeEnvironment(Path[] dataPaths) throws IOException {
                                            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
                assertThat(clusterState.metadata().clusterUUID(), equalTo(clusterUUID));
                    writer,
            try (Writer ignored = persistedClusterStateService.createWriter()) {
                    writer,  
                xContentRegistry(),  
            }
            };
import org.opensearch.test.junit.annotations.TestLogging;
                final ClusterState clusterState = loadPersistedClusterState(persistedClusterStateService);
                                            Settings.builder()
                                        .version(randomLongBetween(0L, Long.MAX_VALUE - 1) - 1) // -1 because it's incremented in .put()  
                Arrays.stream(dataPaths2).anyMatch(p -> message.contains(p.toString()))  
        final long freshCurrentTerm = randomLongBetween(staleCurrentTerm + 1, Long.MAX_VALUE);  
    }
    }
                                IndexMetadata.builder("test")
            writer.writeIncrementalStateAndCommit(currentTerm, previousState, clusterState);  
                            throw new OutOfMemoryError("simulated");
                            Metadata.builder(clusterState.metadata())
                    ClusterState.builder(clusterState)  
                    writer,  
 */  
                    0L,
                        .build(),  
                                .coordinationMetadata(  
                writer.writeFullStateAndCommit(  
            ? BigArrays.NON_RECYCLING_INSTANCE  
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {  
                    indexWriter.addIndexes(dupDirectory);  
        final long staleVersion = staleTerm == freshTerm ? randomLongBetween(1L, freshVersion - 1) : randomLongBetween(1L, Long.MAX_VALUE);
            xContentRegistry(),  
                writeState(  
                final long newTerm = randomNonNegativeLong();  
                assertThat(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.get(indexMetadata.getSettings()), equalTo(0));
                                            Settings.builder()
                    0L,
                );  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
    public void testPersistsAndReloadsIndexMetadataIffVersionOrTermChanges() throws IOException {  
                writeState(
            final long newTerm = randomNonNegativeLong();
                    final Index index = new Index("test-" + i, UUIDs.randomBase64UUID(random()));
                    0L,
    }
            nodeEnvironment,
                        .version(freshVersion)  
                );
                    writer,
            final String indexName = randomAlphaOfLength(10);
        ).getMessage();
            }  
            getBigArrays(),
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()))  
                writeState(
            assertThat(
                    equalTo(1)
    @Override  
                assertFalse(clusterState.metadata().clusterUUIDCommitted());
                        .incrementVersion()
            try (Writer writer = persistedClusterStateService.createWriter()) {
            final String message = expectThrows(
                                )  
                    ClusterState.builder(clusterState)
                    null,
                "[" + message + "] should match " + Arrays.toString(dataPaths1),
                .put(PersistedClusterStateService.SLOW_WRITE_LOGGING_THRESHOLD.getKey(), slowWriteLoggingThresholdMillis + "ms")  
                                .coordinationMetadata(
import org.apache.logging.log4j.LogManager;
                        Metadata.builder(clusterState.metadata())  
                xContentRegistry(),
                final PersistedClusterStateService.OnDiskState onDiskState = newPersistedClusterStateService(nodeEnvironment)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final Path[] dataPaths2 = createDataPaths();
                .putList(Environment.PATH_DATA_SETTING.getKey(), Arrays.stream(dataPaths).map(Path::toString).collect(Collectors.toList()))
            try (Writer ignored = persistedClusterStateService.createWriter()) {
            final Path brokenPath = randomFrom(nodeEnvironment.nodeDataPaths());
                    .metadata(
import org.opensearch.common.util.io.IOUtils;
 * The OpenSearch Contributors require contributions made to  
                                .put(  
                                    CoordinationMetadata.builder(clusterState.coordinationMetadata()).term(staleTerm).build()
        }
                    clusterState  
                                        .build(),
                message,
            }
    public void testFailsIfIndexMetadataIsDuplicated() throws IOException {  
            ).getMessage();
/*
                    onDiskState.currentTerm,
                        .metadata(  
 * You may obtain a copy of the License at  
                            .build(),  
            }
                );
                // ensure that we do persist the same index metadata version by making an update with a higher version
                    0L,
                );
                    }
                    return new FilterDirectory(super.createDirectory(path)) {  
        final Path[] dataPaths1 = createDataPaths();
                    clusterState  
                final ClusterState clusterState = loadPersistedClusterState(persistedClusterStateService);
import org.opensearch.cluster.metadata.Metadata;
                    containsString(Long.toString(staleCurrentTerm)),
        final Path[] combinedPaths = Stream.concat(Arrays.stream(dataPaths1), Arrays.stream(dataPaths2)).toArray(Path[]::new);  
                );
                        0L,
                    clusterState  
                getBigArrays(),  
                @Override
            ).loadBestOnDiskState()
                Stream.of(combinedPaths).map(path -> NodeEnvironment.resolveNodePath(path, 0)).toArray(Path[]::new),
            final PersistedClusterStateService persistedClusterStateService = newPersistedClusterStateService(nodeEnvironment);  
                                .coordinationMetadata(  
                assertExpectedLogs(
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(dataPaths)) {
                    clusterState,
                            .version(randomLongBetween(1L, Long.MAX_VALUE))
                        .build(),
            final String indexUUID = UUIDs.randomBase64UUID(random());
                        Level.WARN,  
                assertThat(indexMetadata.getVersion(), equalTo(indexMetadataVersion));  
                    ClusterState.builder(clusterState)  
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {
                writer.writeFullStateAndCommit(newTerm, ClusterState.EMPTY_STATE);
import org.opensearch.cluster.metadata.IndexMetadata;  
                        .metadata(  
            }
            }  
                assertFalse(writer.isOpen());  
                        .build(),
            );  
                                                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
import org.opensearch.Version;
                clusterState = loadPersistedClusterState(persistedClusterStateService);  
                for (int i = 0; i < writes; i++) {
    private static ClusterState loadPersistedClusterState(PersistedClusterStateService persistedClusterStateService) throws IOException {
                                Metadata.builder(clusterState.metadata())
                    containsString("inconsistent terms found"),
                    )
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(combinedPaths)) {
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(createDataPaths())) {
                nodeEnvironment,
                        .metadata(
                    clusterState,
import static org.hamcrest.Matchers.equalTo;  
                try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
        }
            try (  
            final PersistedClusterStateService persistedClusterStateService = newPersistedClusterStateService(nodeEnvironment);  
    }  
                    0L,
                            .clusterUUIDCommitted(true)
                                        .build(),
                        Level.WARN,  
                                        )  
            }
    public void testReloadsMetadataAcrossMultipleSegments() throws IOException {
import org.apache.lucene.index.IndexWriterConfig;
                        )
import org.apache.lucene.store.Directory;  
                                .coordinationMetadata(CoordinationMetadata.builder(clusterState.coordinationMetadata()).term(1L).build())  
            assertThat(persistedClusterStateService.loadBestOnDiskState().currentTerm, equalTo(0L));  
                    ClusterState.builder(clusterState)
            );  
                final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));  
                                    IndexMetadata.builder(indexMetadata)
                        .build(),
                    ClusterState.builder(clusterState)  
                final ClusterState newClusterState = ClusterState.builder(clusterState)
                                .clusterUUIDCommitted(true)
                assertExpectedLogs(
                () -> newPersistedClusterStateService(nodeEnvironment).loadBestOnDiskState()  
                            Metadata.builder(clusterState.metadata())
                final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));
                xContentRegistry(),  
            }
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(classLogger)) {
                                .coordinationMetadata(  
                );
                );  
                                    IndexMetadata.builder("updated")  
                    );
 * compatible open source license.
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                    clusterState
                    0L,
                        "should not see warning below threshold",
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            try (Writer writer = persistedClusterStateService.createWriter()) {
                    ClusterState.builder(clusterState)  
        }  
                        .metadata(  
 * specific language governing permissions and limitations
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(new Path[] { freshPath })) {
        // isn't there any more  
                                        .version(randomLongBetween(0L, Long.MAX_VALUE - 1) - 1) // -1 because it's incremented in .put()  
                                .coordinationMetadata(
                        )
        ClusterState clusterState,
import org.opensearch.common.util.BigArrays;
                        @Override
                );
            }
                        .metadata(  
import org.apache.logging.log4j.Logger;
            assertTrue(  
                indexMetadata = clusterState.metadata().index("test");
                                )
                                .coordinationMetadata(  
                    1L,
                clusterState = loadPersistedClusterState(persistedClusterStateService);  
                () -> newPersistedClusterStateService(nodeEnvironment).loadBestOnDiskState()
            }
                        .metadata(
                                )  
                    1L,  
                )
                                            Settings.builder()  
        // is duplicated
    public static Path[] createDataPaths() {  
                    };
            try (Writer writer = persistedClusterStateService.createWriter()) {
                        PersistedClusterStateService.class.getCanonicalName(),
                    .incrementVersion()
                                            )
            final String deletedIndexUuid = UUIDs.randomBase64UUID(random());
                assertFalse(clusterState.metadata().clusterUUIDCommitted());  
                final ClusterState clusterState = clusterStateFromMetadata(onDiskState.lastAcceptedVersion, onDiskState.metadata);
            Settings.builder()
            }
        NodeMetadata.FORMAT.cleanupOldFiles(Long.MAX_VALUE, dataPaths2);
                        .metadata(
                Directory createDirectory(Path path) throws IOException {  
                )
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {
                                        .settings(
            }  
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(dataPaths2)) {
 *
            Arrays.stream(dataPaths2).anyMatch(p -> failure.contains(p.toString()))  
/*
    }
                    null,  
        final Path[] combinedPaths = Stream.concat(Arrays.stream(dataPaths1), Arrays.stream(dataPaths2)).toArray(Path[]::new);  
                        .build(),
            try (Directory directory = new NIOFSDirectory(brokenPath.resolve(PersistedClusterStateService.METADATA_DIRECTORY_NAME))) {
                    0L,
                                            Settings.builder()  
            assertThat(clusterState.metadata().version(), equalTo(version + 1));  
                writer.writeFullStateAndCommit(0L, clusterState);
                assertFalse(writer.isOpen());  
        assertThat(  
            }
                writeState(
        }
                    IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.get(clusterState.metadata().index("updated").getSettings()),
                        )  
                IllegalStateException.class,
                        .incrementVersion()
                                throw new IOException("simulated");  
                                        .settings(
                    clusterState
                    clusterState  
                IllegalStateException.class,
import org.apache.lucene.store.IOContext;
import org.opensearch.common.settings.ClusterSettings;
                        .build()
        final long startTimeMillis = randomLongBetween(0L, Long.MAX_VALUE - slowWriteLoggingThresholdMillis * 10);  
    }
                            .clusterUUIDCommitted(true)
                    0L,
                        Level.WARN,
                                    )  
    }
        );
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(createDataPaths())) {
                final ClusterState newState = ClusterState.builder(clusterState)
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {  
                                                .put(indexMetadata.getSettings())
                    1L,
                nodeEnvironment,
        return new PersistedClusterStateService(
                                    CoordinationMetadata.builder(clusterState.coordinationMetadata()).term(freshTerm).build()
                );
                        .version(staleVersion)
            assertTrue(
import org.apache.logging.log4j.Level;  
    public Settings buildEnvSettings(Settings settings) {
                throwException.set(true);
                                .put(
                        public void sync(Collection<String> names) {  
                    if (randomBoolean()) {  
                assertThat(persistedClusterStateService.loadBestOnDiskState().currentTerm, equalTo(newTerm));  
            ) {
        final long slowWriteLoggingThresholdMillis;
                        @Override  
                equalTo(2)
                                .coordinationMetadata(CoordinationMetadata.builder(clusterState.coordinationMetadata()).term(term).build())
                assertThat(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.get(indexMetadata.getSettings()), equalTo(2));
            }
            ) {  
        final long staleCurrentTerm = randomLongBetween(1L, Long.MAX_VALUE - 1);
            final ClusterState clusterState = loadPersistedClusterState(persistedClusterStateService);
                                                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)  
                    null,  
                                            Settings.builder()  
                    clusterState  
                    ClusterState.builder(clusterState)
                assertThat(indexMetadata.getIndexUUID(), equalTo(indexUUID));
/*  
                writer.writeFullStateAndCommit(
                    1L,  
                writeDurationMillis.set(randomLongBetween(slowWriteLoggingThresholdMillis, slowWriteLoggingThresholdMillis * 2));
            assertThat(clusterState.metadata().indices().size(), equalTo(2));  
            }  
    private void assertExpectedLogs(
        }  
                    clusterState,
        // if someone attempted surgery on the metadata index by hand, e.g. deleting broken segments, then maybe some index metadata
                    .build();
                        )  
            }  
        throws IOException {
 * license agreements. See the NOTICE file distributed with
                assertThat(indexMetadata.getIndexUUID(), equalTo(indexUUID));
                    };  
            final Path brokenPath = randomFrom(nodeEnvironment.nodeDataPaths());
                            Metadata.builder(clusterState.metadata())
                    )
                final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));
                                        .version(indexMetadataVersion - 1) // -1 because it's incremented in .put()  
import org.opensearch.common.util.MockBigArrays;
                                        .version(1L)  
        }
            assertTrue(clusterState.metadata().clusterUUIDCommitted());
        final String clusterUUID2 = UUIDs.randomBase64UUID(random());
    private static ClusterState clusterStateFromMetadata(long version, Metadata metadata) {  
                                        )  
            assertThat(clusterState.metadata().index("deleted"), nullValue());
        return usually()
 * not use this file except in compliance with the License.
                indexMetadata = clusterState.metadata().index("test");
                                    CoordinationMetadata.builder(clusterState.coordinationMetadata()).term(oldTerm).build()
                getBigArrays(),
                        .build(),  
                                    IndexMetadata.builder(indexMetadata)
                        )  
                                .version(clusterState.metadata().version() + 1)  
                try (IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig)) {
            final String message = expectThrows(
        }  
                        Metadata.builder(clusterState.metadata())
                // ensure we do not wastefully persist the same index metadata version by making a bad update with the same version
                );  
                                                .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
                    new MockLogAppender.SeenEventExpectation(  
                        Level.WARN,
        }  
            ).getMessage();
                    .build();  
import org.apache.lucene.store.NIOFSDirectory;
        final long freshTerm = randomLongBetween(1L, Long.MAX_VALUE);  
        // verify that loadBestOnDiskState has same check  
                        .build()  
                        .incrementVersion()
                    ClusterState.builder(clusterState)  
            try (Writer writer = persistedClusterStateService.createWriter()) {
                () -> newPersistedClusterStateService(nodeEnvironment).loadBestOnDiskState()
                                                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
            final ClusterState clusterState = clusterStateFromMetadata(onDiskState.lastAcceptedVersion, onDiskState.metadata);  
                    staleTerm,  
                assertThat(indexMetadata.getVersion(), equalTo(indexMetadataVersion));  
            final PersistedClusterStateService persistedClusterStateService = newPersistedClusterStateService(nodeEnvironment);
                                                .put(IndexMetadata.SETTING_INDEX_UUID, indexUUID)  
import java.util.ArrayList;  
                final ClusterState clusterState = loadPersistedClusterState(persistedClusterStateService);
import org.opensearch.common.settings.Settings;  
                        "should see warning at threshold",  
                                        )
                assertExpectedLogs(
            final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));
            assertThat(  
                indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
                                    .put(  
                            Metadata.builder(clusterState.metadata())
        PersistedClusterStateService.Writer writer,  
                            Metadata.builder(clusterState.metadata()).clusterUUID(clusterUUID).clusterUUIDCommitted(true).version(version)
                    writer,
            allOf(containsString("unexpected node ID in metadata"), containsString(nodeIds[0]), containsString(nodeIds[1]))
                );
                    newClusterState,
            assertThat(clusterState.metadata().index("added").getIndexUUID(), equalTo(addedIndexUuid));  
                    1L,  
        // first establish consistent node IDs and write initial metadata  
    public void testFailsIfGlobalMetadataIsDuplicated() throws IOException {  
                    ClusterState.builder(clusterState).version(randomLongBetween(1L, Long.MAX_VALUE)).build(),
                    )
        }  
                            .incrementVersion()
                assertFalse(clusterState.metadata().clusterUUIDCommitted());
                                                .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
                assertExpectedLogs(  
        );  
                    clusterState  
        }
                                            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
                Arrays.stream(dataPaths1).anyMatch(p -> message.contains(p.toString()))
            final long oldTerm = randomLongBetween(1L, Long.MAX_VALUE - 1);
                    new MockLogAppender.UnseenEventExpectation(
                    clusterState,
import org.opensearch.core.index.Index;
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(dataPaths1)) {  
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(createDataPaths())) {
                    clusterState  
    }  
                                                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)  
                        .metadata(
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {
        long currentTerm,  
    public void testCrashesWithIOErrorOnCommitFailure() throws IOException {
 * Unless required by applicable law or agreed to in writing,
                                )
                BigArrays.NON_RECYCLING_INSTANCE,
    public void testPersistsAndReloadsIndexMetadataForMultipleIndices() throws IOException {
        }
                    Settings.builder()  
                                                    .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
                    staleCurrentTerm,
                );  
    private static void writeState(Writer writer, long currentTerm, ClusterState clusterState, ClusterState previousState)
 */
        } else {  
        for (int i = 0; i < dataPaths.length; i++) {
                writeState(  
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(createDataPaths())) {  
    }
                    .build();  
        }
                    new MockLogAppender.SeenEventExpectation(
                                            .put(IndexMetadata.SETTING_INDEX_UUID, "test-uuid")
            ) {  
                IndexMetadata indexMetadata = clusterState.metadata().index("test");
                        )  
    public void testPersistsAndReloadsTerm() throws IOException {
            }
            IllegalStateException.class,
        return Settings.builder().put(settings).put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath()).build();  
                        .put(PersistedClusterStateService.SLOW_WRITE_LOGGING_THRESHOLD.getKey(), writeDurationMillis.get() + "ms")
                                                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 2)
            settings = Settings.builder()
                                        .settings(
                        "*"
                                            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)  
                                                .put(indexMetadata.getSettings())
            final List<Index> indices = new ArrayList<>(writes);
                writer.writeIncrementalStateAndCommit(currentTerm, previousState, clusterState);  
        final Path[] dataPaths2 = createDataPaths();
                @Override  
                        }
                assertThat(indexMetadata.getIndexUUID(), equalTo(index.getUUID()));  
                );
            } else {
                () -> 0L
                                        .settings(
                                        .settings(
                            .put(  
            "[" + failure + "] should match " + Arrays.toString(dataPaths2),
                );
                }  
                    ClusterState.builder(clusterState)  
                                .version(version + 1)
import org.opensearch.env.NodeMetadata;  
                                                    .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
    }
        final Path[] dataPaths2 = createDataPaths();
                        )
    public void testPersistsAndReloadsGlobalMetadata() throws IOException {
                assertThat(clusterState.metadata().version(), equalTo(version));  
    }
import java.nio.file.Path;
                final IndexMetadata indexMetadata = clusterState.metadata().index(index.getName());
                                    IndexMetadata.builder(indexMetadata)
    @TestLogging(value = "org.opensearch.gateway:WARN", reason = "to ensure that we log gateway events on WARN level")
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(dataPaths1)) {
                Directory createDirectory(Path path) throws IOException {
        final Path[] dataPaths2 = createDataPaths();
                                        .settings(
            // check if we can open writer again  
 */
        final String failure = expectThrows(IllegalStateException.class, () -> newNodeEnvironment(combinedPaths)).getMessage();
                    return new FilterDirectory(super.createDirectory(path)) {
                    clusterState,
        final long freshVersion = randomLongBetween(2L, Long.MAX_VALUE);
                        )  
                IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.get(clusterState.metadata().index("updated").getSettings()),  
                                        .version(randomLongBetween(0L, Long.MAX_VALUE - 1) - 1) // -1 because it's incremented in .put()
                assertThat(clusterState.metadata().index("deleted").getIndexUUID(), equalTo(deletedIndexUuid));
                                    CoordinationMetadata.builder(clusterState.coordinationMetadata()).term(freshTerm).build()
                        )
                writer.writeFullStateAndCommit(  
                final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));
            assertThat(  
                    indexWriter.commit();  
                                                .put(clusterState.metadata().index("updated").getSettings())  
            message,
        } else {
import org.opensearch.gateway.PersistedClusterStateService.Writer;
            }
                    writer,  
                                    IndexMetadata.builder("deleted")
            assertThat(clusterState.version(), equalTo(freshVersion));
                                .put(
                    0L,
 *
                assertThat(expectThrows(OutOfMemoryError.class, () -> {
                    )
            mockAppender.addExpectation(expectation);
                            if (throwException.get() && dest.startsWith("segments")) {
                                        .settings(
        final Path freshPath = randomFrom(dataPaths);  
        }
                    writer,
        if (randomBoolean() && unimportantPaths.isEmpty() == false) {
                                                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
 * SPDX-License-Identifier: Apache-2.0
            assertThat(clusterState.term(), equalTo(freshTerm));
            }
                            .version(randomLongBetween(1L, Long.MAX_VALUE))  
                try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    final ClusterState clusterState = loadPersistedClusterState(persistedClusterStateService);
                }
                            Metadata.builder(clusterState.metadata())
                    writer,  
                                )
                                )
    }
                    writer,  
                    } else {
 * this work for additional information regarding copyright
            );  
import org.opensearch.cluster.ClusterState;
            // check if we can open writer again  
                    .incrementVersion()
        final Path[] dataPaths = createDataPaths();
                        "writing cluster state took [*] which is above the warn threshold of [*]; " + "wrote full state with [0] indices"
import org.opensearch.test.MockLogAppender;
                nodeIds[0],
                        .metadata(  
            }
                                )
import java.io.IOException;
            final String message = expectThrows(
                        .incrementVersion()
    }
                            .version(clusterState.version())
                ClusterState clusterState = loadPersistedClusterState(persistedClusterStateService);
            mockAppender.assertAllExpectationsMatched();
                    )
            final String updatedIndexUuid = UUIDs.randomBase64UUID(random());
                        .incrementVersion()
                    writer,
                        clusterState
            }  
            assertThat(clusterState.metadata().index("updated").getIndexUUID(), equalTo(updatedIndexUuid));
                final ClusterState newState = ClusterState.builder(clusterState)  
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(dataPaths)) {  
                    indices.add(index);  
                .loadBestOnDiskState();
                    ClusterState.builder(clusterState)
                    new MockLogAppender.UnseenEventExpectation(  
                assertThat(clusterState.metadata().indices().size(), equalTo(2));
                                                .put(IndexMetadata.SETTING_INDEX_UUID, updatedIndexUuid)
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            ).getMessage();
                    0L,
                writeState(writer, freshCurrentTerm, clusterState, clusterState);
                IllegalStateException.class,  
                () -> 0L  
                            Metadata.builder(clusterState.metadata())
                                )  
                );  
        final Path[] combinedPaths = Stream.concat(Arrays.stream(dataPaths1), Arrays.stream(dataPaths2)).toArray(Path[]::new);
                writeState(
    public void testLoadsFreshestState() throws IOException {
                                        .build(),
                        writer.commit(newTerm, newState.version());  
                                        .settings(
                    ClusterState.builder(clusterState).version(randomLongBetween(1L, Long.MAX_VALUE)).build()
import java.util.stream.Collectors;
                writer.writeFullStateAndCommit(  
                Arrays.stream(dataPaths1).anyMatch(p -> message.contains(p.toString()))  
    }
                final ClusterState clusterState = loadPersistedClusterState(persistedClusterStateService);
            }  
package org.opensearch.gateway;
                                .put(
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(dataPaths1)) {  
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {
                        PersistedClusterStateService.class.getCanonicalName(),
        }  
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {  
            () -> 0L  
                                )
    }
                () -> 0L
                    )  
                                        )
        }
                            Metadata.builder(clusterState.metadata())
                    writer,
                assertExpectedLogs(
                    indexWriter.deleteDocuments(new Term("type", "global")); // do not duplicate global metadata
import java.util.stream.Stream;
                    } else {
    public void testFailsOnMismatchedCommittedClusterUUIDs() throws IOException {
            }
        final String[] nodeIds = new String[2];
                                            Settings.builder()
        final long freshTerm = randomLongBetween(1L, Long.MAX_VALUE);
                final long newTerm = randomNonNegativeLong();
                    clusterState,
                        @Override
                    writer,  
    public void testFailsGracefullyOnExceptionDuringFlush() throws IOException {
                () -> newPersistedClusterStateService(nodeEnvironment).loadBestOnDiskState()  
        );  
                        }
                final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));
                                )
            "[" + message + "] should match " + Arrays.toString(dataPaths2),
                assertThat(clusterState.metadata().index("updated").getIndexUUID(), equalTo(updatedIndexUuid));
import org.opensearch.cluster.node.DiscoveryNode;
                    if (randomBoolean()) {  
                assertThat(indexMetadata.getVersion(), equalTo(indexMetadataVersion + 1));  
            try (Writer writer = persistedClusterStateService.createWriter()) {
                .build();
            final String message = expectThrows(  
                            Metadata.builder(clusterState.metadata())
                                    IndexMetadata.builder("updated")  
            try (Writer writer = persistedClusterStateService.createWriter()) {  
                    ClusterState.builder(clusterState)  
                        Metadata.builder(clusterState.metadata())  
        final PersistedClusterStateService.OnDiskState onDiskState = persistedClusterStateService.loadBestOnDiskState();
                Directory directory = new NIOFSDirectory(brokenPath.resolve(PersistedClusterStateService.METADATA_DIRECTORY_NAME));
                writer.writeFullStateAndCommit(currentTerm, clusterState);
                    new MockLogAppender.SeenEventExpectation(
                        .build(),
    }  
                .build()  
        return newNodeEnvironment(  
                    return new FilterDirectory(super.createDirectory(path)) {
                                    )
                        .version(freshVersion)
        );
                    0L,
                                    CoordinationMetadata.builder(clusterState.coordinationMetadata()).term(newTerm).build()
    private PersistedClusterStateService newPersistedClusterStateService(NodeEnvironment nodeEnvironment) {  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
import java.util.HashSet;  
        final Path[] dataPaths = new Path[randomIntBetween(1, 4)];
        final Path[] dataPaths1 = createDataPaths();
                final ClusterState newState = ClusterState.builder(clusterState)
                        )  
                    .metadata(
                );
            unimportantPaths.remove(freshPath);
                            if (throwException.get()) {  
                            .clusterUUID(UUIDs.randomBase64UUID(random()))  
                );
                    )
                assertThat(  
            }
                        .incrementVersion()
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(createDataPaths())) {
import java.util.Arrays;
                                .put(
                writeState(
                Directory dupDirectory = new NIOFSDirectory(dupPath.resolve(PersistedClusterStateService.METADATA_DIRECTORY_NAME))
                                                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
                                .put(
                        "should not see warning below threshold",
            final PersistedClusterStateService.OnDiskState onDiskState = newPersistedClusterStateService(nodeEnvironment)
            );
            final long version = randomLongBetween(1L, Long.MAX_VALUE);
            failure,
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(combinedPaths)) {
import org.opensearch.common.util.MockPageCacheRecycler;  
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {  
                );
                    writer,  
            Arrays.stream(dataPaths2).anyMatch(p -> message.contains(p.toString()))  
                writeState(
    ) throws IllegalAccessException, IOException {
                        PersistedClusterStateService.class.getCanonicalName(),  
        }
    }
                            Metadata.builder(clusterState.metadata())
                );
            ).getMessage();  
            }
                () -> currentTime.getAndAdd(writeDurationMillis.get())
    }
                        PersistedClusterStateService.class.getCanonicalName(),
                "[" + message + "] should match " + Arrays.toString(dataPaths1),
                message,
                                )  
                Directory dupDirectory = new NIOFSDirectory(dupPath.resolve(PersistedClusterStateService.METADATA_DIRECTORY_NAME))
            assertThat(clusterState.metadata().clusterUUID(), equalTo(clusterUUID));
                final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));
                    writer,  
                            + "wrote global metadata [false] and metadata for [1] indices and skipped [0] unchanged indices"  
import java.util.concurrent.atomic.AtomicBoolean;
                final ClusterState clusterState = loadPersistedClusterState(newPersistedClusterStateService(nodeEnvironment));  
                    clusterState
                );
                "[" + message + "] should match " + Arrays.toString(dataPaths2),
                assertFalse(clusterState.metadata().clusterUUIDCommitted());
        }
                "[" + message + "] should match " + Arrays.toString(dataPaths2),  
                    indexWriter.commit();  
}
        // verify that the freshest state is chosen
                                .put(
                final ClusterState clusterState = loadPersistedClusterState(persistedClusterStateService);
    }
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
                writeState(  
                        .incrementVersion()
        }  
import java.io.IOError;  
        // is duplicated
        }  
                writer.writeFullStateAndCommit(
                allOf(  
                        }
                                                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
                            }
                            )  
                    .metadata(
import org.apache.lucene.store.IndexOutput;  
import org.opensearch.env.NodeEnvironment;
                        .incrementVersion()
                                .version(2)
                                                Settings.builder()  
                                .put(  
                        .metadata(
                writer.writeIncrementalStateAndCommit(  
                        Level.WARN,
                                                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)  
                // ensure that we also persist the index metadata when the term changes
        final AtomicBoolean throwException = new AtomicBoolean();
                }
                    ClusterState.builder(clusterState).version(randomLongBetween(1L, Long.MAX_VALUE)).build()  
                    expectThrows(IOException.class, () -> writeState(writer, newTerm, newState, clusterState)).getMessage(),
                        "writing cluster state took [*] which is above the warn threshold of [*]; "
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {
                Directory createDirectory(Path path) throws IOException {
            }
        }
                        .incrementVersion()  
                    writer,  
            for (Index index : indices) {
                    .build();  
                () -> 0L  
                }
                        .build(),  
                        .build(),
 * software distributed under the License is distributed on an
        return ClusterState.builder(ClusterName.DEFAULT).version(version).metadata(metadata).build();
                        .build()
            () -> new PersistedClusterStateService(  
                                                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)  
import static org.hamcrest.Matchers.containsString;
                                        )
            final int writes = between(5, 20);  
                    0L,
                    writer,
            try (Writer writer = newPersistedClusterStateService(nodeEnvironment).createWriter()) {  
import org.apache.lucene.index.IndexWriter;  
                        writeState(writer, newTerm, newState, clusterState);
                Directory directory = new NIOFSDirectory(brokenPath.resolve(PersistedClusterStateService.METADATA_DIRECTORY_NAME));
    }
            ).getMessage();
                                    IndexMetadata.builder(indexName)
                        "should see warning above threshold",
                        writeState(writer, newTerm, newState, clusterState);
                            .metadata(  
                    0L,
                            .clusterUUID(UUIDs.randomBase64UUID(random()))
import org.opensearch.common.UUIDs;
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(combinedPaths)) {
                                throw new IOException("simulated");
                        .build(),
            final long indexMetadataVersion = randomLongBetween(1L, Long.MAX_VALUE);
import static org.hamcrest.Matchers.lessThan;
                                                .put(indexMetadata.getSettings())
                clusterState = loadPersistedClusterState(persistedClusterStateService);
                                                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
                            .clusterUUID(UUIDs.randomBase64UUID(random()))
        if (randomBoolean() || clusterState.term() != previousState.term() || writer.fullStateWritten == false) {  
            ) {  
            );
                        .incrementVersion()
                IllegalStateException.class,
        );
                    }
            );
        final String message = expectThrows(
                                            .settings(
                    0L,
        return dataPaths;
                    ClusterState.builder(clusterState)
                getBigArrays(),  
            nodeIds[0] = nodeEnvironment.nodeId();
            nodeIds[1] = nodeEnvironment.nodeId();  
                xContentRegistry(),
                );  
                throwException.set(true);  
        final AtomicLong writeDurationMillis = new AtomicLong(slowWriteLoggingThresholdMillis);
                    1L,
                writeState(
            slowWriteLoggingThresholdMillis = PersistedClusterStateService.SLOW_WRITE_LOGGING_THRESHOLD.get(Settings.EMPTY).millis();
            writer.writeFullStateAndCommit(currentTerm, clusterState);
                                        )
        if (randomBoolean()) {  
                        .metadata(Metadata.builder(clusterState.metadata()).clusterUUID(clusterUUID1).clusterUUIDCommitted(true).version(1))
            final String message = expectThrows(
                    clusterState,  
                        )  
        try (NodeEnvironment nodeEnvironment = newNodeEnvironment(createDataPaths())) {
            }
                                            Settings.builder()
                    )  
                            .version(randomLongBetween(1L, Long.MAX_VALUE))  
                }).getMessage(), containsString("simulated"));
                    containsString("duplicate metadata found"),  
                    ClusterState.builder(clusterState).version(randomLongBetween(1L, Long.MAX_VALUE)).build(),
                        public void rename(String source, String dest) throws IOException {
import org.opensearch.test.OpenSearchTestCase;  
            assertThat(
                    ClusterState.builder(clusterState)  
                    newClusterState,
        // if someone attempted surgery on the metadata index by hand, e.g. deleting broken segments, then maybe the global metadata
                                .put(  
        }
                    indexWriter.commit();
                xContentRegistry(),
                                        )
        final String clusterUUID1 = UUIDs.randomBase64UUID(random());  
                assertExpectedLogs(
                                        IndexMetadata.builder(index.getName())
                        ClusterState.builder(clusterState)
            assertTrue(
            final PersistedClusterStateService persistedClusterStateService = new PersistedClusterStateService(
                message,
                            return super.createOutput(name, context);  
