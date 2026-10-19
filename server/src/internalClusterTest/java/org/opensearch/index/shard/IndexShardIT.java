import java.util.concurrent.TimeUnit;
        IOUtils.rm(newIndexDataPath);
        StringBuilder sb = new StringBuilder();
import org.opensearch.index.seqno.RetentionLeaseSyncer;
import org.opensearch.index.seqno.SequenceNumbers;
    public void testFlushStats() throws Exception {
            .setSettings(
            settings = Settings.builder().put("index.translog.flush_threshold_size", "125b").build();
            assertThat(shard.flushStats().getPeriodic(), equalTo(1L));
            .setId("2")
        client().prepareIndex("test").setId(UUIDs.randomBase64UUID()).setSource("{}", MediaTypeRegistry.JSON).get();
 * this work for additional information regarding copyright
        assertBusy(() -> {
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            indexService.mapperService(),
            .setRefreshPolicy(randomBoolean() ? IMMEDIATE : NONE)
        for (int i = 0; i < threads.length; i++) {
                        assertPathHasBeenCleared(file);
            false,
import org.opensearch.core.index.shard.ShardId;
            ExceptionsHelper.rethrowAndSuppress(failures);
        ShardRouting shardRouting = newShardRouting(
                    "flush stats: total=[%d vs %d], periodic=[%d vs %d]",
import org.junit.Assert;
            .indices()
        logger.info("--> index closed, re-opening...");
        } else {
                        count++;
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        client().prepareIndex("test").setId("2").setSource("{}", MediaTypeRegistry.JSON).get();
                VersionType.INTERNAL,
            assertThat(task.getInterval(), equalTo(TimeValue.timeValueMinutes(1)));
    }
        AtomicReference<IndexShard> shardRef = new AtomicReference<>();
                shard.resetEngineToGlobalCheckpoint();
                client().admin().indices().prepareFlush(indexName).setWaitIfOngoing(true).get();
                return tlog.ensureSynced(new Translog.Location(lastWriteLocation.generation, lastWriteLocation.translogLocation, 0));
                .prepareCreate("test")
        IndexService test = indicesService.indexService(resolveIndex("test"));
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
 * this file be licensed under the Apache-2.0 license or a
                .build()
                        continue;
import org.opensearch.index.engine.EngineBackedIndexer;
            null,
                }
        ensureGreen();
        for (IndexShard indexShard : indexService) {
import org.opensearch.index.mapper.SourceToParse;
        assertAllIndicesRemovedAndDeletionCompleted(Collections.singleton(getInstanceFromNode(IndicesService.class)));
import org.opensearch.indices.DefaultRemoteStoreSettings;
        assertFalse(shard.shouldPeriodicallyFlush());
            "numDocs=" + numDocs + " moreDocs=" + moreDocs,
                    currentStats.getPeriodic(),
import java.util.function.Function;
            assertThat(translog.currentFileGeneration(), equalTo(generation + rolls));
        assertAcked(
            getInstanceFromNode(ClusterService.class),
        logger.info("--> updating data_path to [{}] for index [{}]", newIndexDataPath, index);
                client().prepareIndex("index").setId(randomFrom("1", "2")).setSource("{}", MediaTypeRegistry.JSON).get();
                assertFalse(shard.shouldPeriodicallyFlush());
                        .put(IndexMetadata.SETTING_DATA_PATH, newIndexDataPath.toAbsolutePath().toString())
        logger.info(
                assertThat(totalFiles, either(lessThanOrEqualTo((long) translogRetentionTotalFiles)).or(equalTo(1L)));
        try (
public class IndexShardIT extends OpenSearchSingleNodeTestCase {
    }
        final IndexShard shard,
        client().prepareDelete("index", "1").setRouting(routing).get();
            MergedSegmentPublisher.EMPTY,
                final FlushStats currentStats = shard.flushStats();
            assertSame(task, shard.getPeriodicFlushTask());
                SequenceNumbers.UNASSIGNED_SEQ_NO,
        final boolean flush = randomBoolean();
            try {
                    currentStats.getTotal(),
        assertAcked(
        Predicate<Translog> needsSync = (tlog) -> {
        assertAcked(
            null,
import org.opensearch.env.ShardLock;
            .put("index.number_of_shards", 1)
        // (worst case, meaning that the shard lock could be acquired and
        final IndexService test = indicesService.indexService(resolveIndex("test"));
        IndexShard shard = indexService.getShard(0);
            .get();
    }
    public void testStressMaybeFlushOrRollTranslogGeneration() throws Exception {
            client().admin()
import org.opensearch.common.UUIDs;
            final long generation = getTranslog(shard).currentFileGeneration();
            }
 * license agreements. See the NOTICE file distributed with
            shard.getIndexerFactory(),
import static org.opensearch.index.shard.IndexShardTestCase.recoverFromStore;
        // Should not be able to acquire the lock because it's already open
        client().admin().indices().prepareFlush("test").setForce(randomBoolean()).setWaitIfOngoing(true).get();
                .indices()
        // Now, try closing and changing the settings
        setDurability(shard, Translog.Durability.ASYNC);
            shard.shardPath(),
            final FlushStats initialStats = shard.flushStats();
                    either(equalTo(initialStats.getPeriodic() + 1)).or(equalTo(initialStats.getPeriodic() + 2))
        final long periodicBefore = shard.flushStats().getPeriodic();
import java.util.concurrent.atomic.AtomicReference;
    public void testMaybeRollTranslogGeneration() throws Exception {
            null,
                equalTo(numDocs + moreDocs)
        logger.info("--> idxPath: [{}]", idxPath);
                assertEquals(generation + 1, getTranslog(shard).currentFileGeneration());
import org.opensearch.common.CheckedFunction;
            .setSettings(
            .put(IndexSettings.INDEX_TRANSLOG_RETENTION_TOTAL_FILES_SETTING.getKey(), translogRetentionTotalFiles);
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            indexService,
        }
            stream.forEach(path -> {
        final IndexShard shard = indexService.getShard(0);
            try (Stream<Path> files = Files.list(getTranslog(shard).location()).sorted(Comparator.reverseOrder())) {
        Settings idxSettings = Settings.builder().put(IndexMetadata.SETTING_DATA_PATH, idxPath).build();
        shard.refresh("test");
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_REOPENED, "fake recovery"),
        }
/*
        assertFalse(shard.shouldPeriodicallyFlush());
            assertFalse(task.isScheduled());
    public void testNoOpEngineFactoryTakesPrecedence() {
import org.opensearch.core.common.unit.ByteSizeValue;
import org.opensearch.test.IndexSettingsModule;
            .put(SETTING_NUMBER_OF_REPLICAS, 0)
            // we can't use tlog.needsSync() here since it also takes the global checkpoint into account
                    // Skip files added by Lucene's ExtraFS
                .prepareUpdateSettings("test")
        assertThat("last commit [" + shard.commitStats().getUserData() + "]", translog.stats().getUncommittedOperations(), equalTo(0));
            client().prepareIndex("test").setId("1").setSource("{}", MediaTypeRegistry.JSON).get();
        int rolls = 0;
                commitStats.getUserData(),
    public void testDurableFlagHasEffect() throws Exception {
        }
        final Translog translog = getTranslog(shard);
            ReferencedSegmentsPublisher.EMPTY,
        );
            // size of the operation plus header and footer
            false
                .indices()
        final IndexShard.AsyncShardFlushTask task = shard.getPeriodicFlushTask();
            if (location.translogLocation + location.size > generationThreshold) {
            SegmentReplicationCheckpointPublisher.EMPTY,
            }
            client().prepareBulk()
        for (int i = 0; i < numberOfDocuments; i++) {
            }
        final ClusterService clusterService,
 * software distributed under the License is distributed on an
            .put("index.number_of_replicas", 0)
        final long moreDocs = between(10, 20);
        sb.append("[");
                .add(client().prepareDelete("test", "1"))
        assertThat(
        assertThat(shard.getLastSyncedGlobalCheckpoint(), equalTo(2L));
    public static final IndexShard recoverShard(IndexShard newShard) throws IOException {
            .indices()
                    }
    public void testLockTryingToDelete() throws Exception {
import org.opensearch.cluster.ClusterState;
 * the Apache License, Version 2.0 (the "License"); you may
                    }
        }
    public void testExpectedShardSizeIsPresent() throws InterruptedException {
import org.opensearch.index.IndexSettings;
            check = () -> {
            "--> current translog size: [{}] num_ops [{}] generation [{}]",
            }
        if (flush) {
                .setSettings(
        for (int i = 0; i < threads.length; i++) {
            existingShardRouting.primary(),
     */
            .setRefreshPolicy(randomBoolean() ? IMMEDIATE : NONE)
                long totalFiles = files.filter(f -> f.getFileName().toString().endsWith(Translog.TRANSLOG_FILE_SUFFIX)).count();
            .setSource("{}", MediaTypeRegistry.JSON)
        final CountDownLatch engineResetLatch = new CountDownLatch(1);
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                .put(IndexSettings.INDEX_MERGE_ON_FLUSH_ENABLED.getKey(), false)
 *
            () -> {},
            client().prepareIndex("test").setId(Long.toString(i + numDocs)).setSource("{}", MediaTypeRegistry.JSON).get();
    public void testUpdatePriority() {
        });
     * engine factories if the index is closed.
        final int generationThreshold = randomIntBetween(64, 512);
            assertThat(shard.flushStats().getTotal(), equalTo(1L));
        ensureGreen("test");
        // Disable: the task is closed and no further periodic flushes happen.
     * Asserts that there are no files in the specified path
import org.opensearch.index.translog.Translog;
                        Files.copy(path, newIndexDataPath.resolve(indexDataPath.relativize(path)));
        final IndexShard shard = indicesService.getShardOrNull(new ShardId(resolveIndex("test"), 0));
    public void testShardHasMemoryBufferOnTranslogRecover() throws Throwable {
            .put("index.number_of_shards", 1)
                    currentStats.getPeriodic()
import org.opensearch.index.IndexService;
import org.opensearch.ExceptionsHelper;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.cluster.ClusterInfoService;
        // Enable on a live index via the settings API: the task must start without an engine restart.
            assertBusy(() -> assertFalse(indicesService.iterator().hasNext()), 1, TimeUnit.MINUTES);
                    shard.afterWriteOperation();
                } catch (Exception e) {
    public void testPeriodicFlushIntervalDynamicUpdate() throws Exception {
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("{}", MediaTypeRegistry.JSON).get();
    public void testShardChangesWithDefaultDocType() throws Exception {
        Settings settings = Settings.builder().put("index.translog.flush_threshold_size", "" + between(200, 300) + "b").build();
        final Path indexDataPath = sharedDataPath.resolve("start-" + randomAsciiLettersOfLength(10));
    }
            List<Translog.Operation> opsFromTranslog = TestTranslog.drainSnapshot(translogSnapshot, true);
import org.opensearch.test.InternalSettingsPlugin;
            .setSettings(Settings.builder().put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), durability.name()).build())
                .get()
        final IndexService indexService = createIndex("test");
                    .put(
import org.opensearch.plugins.Plugin;
    private static ShardRouting getInitializingShardRouting(ShardRouting existingShardRouting) {
    private static void assertAllIndicesRemovedAndDeletionCompleted(Iterable<IndicesService> indicesServices) throws Exception {
        assertFalse(needsSync.test(translog));
                throw new UncheckedIOException(e);
                        sb.append(file.toAbsolutePath().toString());
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_PRIORITY, 400).build())
    private void assertPathHasBeenCleared(Path path) {
            clusterService.getClusterApplierService(),
                .setSettings(Settings.builder().put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), "-1"))
                );
        final String index = "test-custom-data-path";
 * Licensed to Elasticsearch under one or more contributor
                    if (Files.isDirectory(file)) {
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
            .put("index.soft_deletes.enabled", true)
        final IndexService indexService,
import org.opensearch.index.flush.FlushStats;
import org.opensearch.core.common.bytes.BytesArray;
        }
        createIndex("test");
    private void setDurability(IndexShard shard, Translog.Durability durability) {
                assertFalse(shard.shouldRollTranslogGeneration());
        createIndex(
        }
                .prepareUpdateSettings(index)
        IndexService test = indicesService.indexService(resolveIndex("test"));
        assertEquals(0, translog.stats().getUncommittedOperations());
            assertThat(((EngineBackedIndexer) (indexShard.getIndexer())).getEngine(), instanceOf(NoOpEngine.class));
        CheckedFunction<DirectoryReader, DirectoryReader, IOException> wrapper = directoryReader -> directoryReader;
import java.nio.file.Files;
            .build();
    }
 * The OpenSearch Contributors require contributions made to
            existingShardRouting.currentNodeId(),
        client().prepareIndex("test").setId("1").setSource("{\"foo\" : \"bar\"}", MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE).get();
        assertTrue(shard.shouldPeriodicallyFlush());
        assertThat(client().search(countRequest).actionGet().getHits().getTotalHits().value(), equalTo(numDocs));
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("{}", MediaTypeRegistry.JSON).get();
/*
                Versions.MATCH_ANY,
            .getShardSize(state.getRoutingTable().index("test").getShards().get(0).primaryShard());
        }
            Collections.emptyMap(),
            .get();
                assertBusy(() -> assertFalse(shard.shouldRollTranslogGeneration()));
import java.io.IOException;
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        final Thread[] threads = new Thread[numThreads];
        Long test = clusterInfoService.getClusterInfo()
        );
            if (randomBoolean()) {
 * You may obtain a copy of the License at
                    .orElseThrow(() -> new AssertionError("expected a delete operation"));
        Path[] shardPaths = env.availableShardPaths(new ShardId(index, 0));
        });
            .prepareUpdateSettings("test")
        assertAcked(
                String msg = String.format(
        SearchResponse response = client().prepareSearch("test").get();
            Settings.builder().put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST).build()
            Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0).put("index.refresh_interval", -1).build()
import static org.hamcrest.Matchers.either;
        return pluginList(InternalSettingsPlugin.class);
        }
import static java.util.Collections.emptySet;
        client().admin()
    }
        ensureGreen("test");
                    .build()
            Settings.builder()
import org.opensearch.core.common.unit.ByteSizeUnit;
        assertFalse(shard.shouldPeriodicallyFlush());
            threads[i].join();
            } else {
            DefaultRemoteStoreSettings.INSTANCE,
        final int numberOfDocuments = randomIntBetween(32, 128);
            .put("index.number_of_replicas", 0)
        assertAcked(client().admin().indices().prepareDelete(index));
            listener
                    assertTrue(shardRef.get().getIndexBufferRAMBytesUsed() > 0);
            fail("should not have been able to delete the directory");
            .put("index.translog.flush_threshold_size", "512mb") // do not flush
            equalTo(numDocs + moreDocs)
        final CircuitBreakerService cbs,
                }
    }
        assertEquals(durability, shard.getTranslogDurability());
            };
import org.opensearch.indices.recovery.RecoveryState;
import java.util.concurrent.BrokenBarrierException;
import org.opensearch.core.common.Strings;
import org.opensearch.env.Environment;
        createIndex(indexName, Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0).build());
import org.opensearch.indices.IndicesService;
                .setSettings(Settings.builder().put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), "100ms"))
        final ClusterService clusterService = getInstanceFromNode(ClusterService.class);
        IndexService indexService = getInstanceFromNode(IndicesService.class).indexService(resolveIndex("test"));
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        assertHitCount(response, 1L);
        assertHitCount(client().prepareSearch(index).setSize(0).get(), 1L);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
import org.opensearch.index.engine.MergedSegmentWarmerFactory;
            NodeEnvironment.acquireFSLockForPaths(IndexSettingsModule.newIndexSettings("test", Settings.EMPTY), shardPaths);
        IndexShard shard = test.getShardOrNull(0);
            client().admin().indices().prepareCreate("test").setSettings(Settings.builder().put(IndexMetadata.SETTING_PRIORITY, 200))
            newShard.close("just do it", randomBoolean(), false);
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.NONE;
        client().prepareDelete("test", "2").get();
        final Path newIndexDataPath = sharedDataPath.resolve("end-" + randomAlphaOfLength(10));
        settings = Settings.builder().put("index.translog.flush_threshold_size", (String) null).build();
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
        assertEquals(2, translog.stats().getUncommittedOperations());
        Path idxPath = env.sharedDataDir().resolve(randomAlphaOfLength(10));
    }
            final CommitStats commitStats = shard.commitStats();
                    either(equalTo(initialStats.getTotal() + 1)).or(equalTo(initialStats.getTotal() + 2))
            };
            OpenSearchTestCase::randomBoolean,
    }
        }
            indexService.getBigArrays(),
        // we're green to delete the shard's directory)
            }
                assertThat(
            wrapper,
import org.opensearch.action.support.ActiveShardCount;
        ClusterState state = getInstanceFromNode(ClusterService.class).state();
    }
import java.util.Locale;
                }
            List<Translog.Operation> opsFromTranslog = TestTranslog.drainSnapshot(translogSnapshot, true);
import org.opensearch.action.search.SearchResponse;
                    Locale.ROOT,
            }
            env.nodeId(),
        setDurability(shard, Translog.Durability.REQUEST);
            .put("index.soft_deletes.enabled", true)
            IndexShard.AsyncShardFlushTask task = shard.getPeriodicFlushTask();
        for (int i = 0; i < 50; i++) {
                    .findFirst()
            Versions.MATCH_ANY,
        Translog translog = getTranslog(shard);
import org.opensearch.test.OpenSearchTestCase;
        ensureGreen();
                shard.rollTranslogGeneration();
            client().admin()
        logger.info(
import org.opensearch.cluster.routing.UnassignedInfo;
            VersionType.INTERNAL,
        final IndexService indexService = indicesService.indexServiceSafe(indexMetadata.getIndex());
            .indices()
        assertNull(shard.getPeriodicFlushTask());
                .add(client().prepareDelete("test", "3"))
    /**
        ensureGreen();
        IndexService indexService = createIndexWithSimpleMappings("index", settings);
                    throw e;
        // Test without the regular shard lock to assume we can acquire it
            );
                assertThat(
                r.close();
            translog.stats().getUncommittedOperations(),
        shard.sync();
        assertAcked(client().admin().indices().prepareOpen(index));
                .add(client().prepareIndex("test").setId("3").setSource("{}", MediaTypeRegistry.JSON))
            assertTrue(task.isScheduled());
        }
            } catch (IOException e) {
        assertThat(flushStats.getTotal(), greaterThan(flushStats.getPeriodic()));
        int numOps = between(1, 10);
            threads[i].start();
        client().prepareIndex("test").setId("1").setSource("{}", MediaTypeRegistry.JSON).get();
            assertTrue(task.isClosed());
    }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        }
        IndexService indexService = indicesService.indexService(resolveIndex("test"));
            threads[i] = new Thread(() -> {
import java.nio.file.DirectoryStream;
                    .build()
            if (randomBoolean()) {
        final long generation = translog.currentFileGeneration();
        assertBusy(() -> assertThat(indexService.getShard(0).shouldPeriodicallyFlush(), equalTo(false)));
        }
        ensureGreen();
        IndexService test = indicesService.indexService(resolveIndex("test"));
        engineResetLatch.await();
        }
import org.opensearch.action.search.SearchRequest;
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
        });
    public void testMaybeFlush() throws Exception {
                } catch (Exception e) {
                    initialStats.getPeriodic(),
        client().admin().indices().prepareDelete("test").get();
import org.opensearch.common.lucene.uid.Versions;
    }
 * KIND, either express or implied.  See the License for the
        try (Stream<Path> stream = Files.walk(indexDataPath)) {
        } catch (LockObtainFailedException e) {
        final IndexShard newShard = newIndexShard(
import java.util.Collections;
        for (int i = 0; i < 100; i++) {
        try (
        }
        int translogRetentionTotalFiles = randomIntBetween(0, 50);
import java.io.UncheckedIOException;
            translog.stats().getUncommittedSizeInBytes(),
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
        NodeEnvironment env = getInstanceFromNode(NodeEnvironment.class);
            client().admin()
            settings = Settings.builder().put("index.translog.generation_threshold_size", "117b").build();
            @Override
        };
package org.opensearch.index.shard;
        );
            Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0).build()
                    logger.error("Failed to copy data path directory", e);
        final String nodeId,
            check = () -> {
            assertThat(
        assertAcked(client().admin().indices().prepareClose(index).setWaitForActiveShards(ActiveShardCount.DEFAULT));
        logger.info("--> creating index [{}] with data_path [{}]", index, indexDataPath);
        logger.info("--> paths: [{}]", (Object) shardPaths);
            .get();
        IndexingOperationListener listener = new IndexingOperationListener() {
        Settings.Builder settings = Settings.builder()
                // wait until the roll completes
                Settings.builder()
    }
}
import org.opensearch.index.engine.NoOpEngine;
        assert Files.exists(newIndexDataPath) == false : "new index data path directory should not exist!";
            .setSource("{}", MediaTypeRegistry.JSON)
import org.opensearch.index.engine.CommitStats;
        IndexShard shard = indexService.getShard(0);
import org.opensearch.action.index.IndexRequest;
            new SourceToParse("test", "1", new BytesArray("{}"), MediaTypeRegistry.JSON),
        assertBusy(check);
            }
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        ensureGreen();
            indexService.getThreadPool(),
            final Engine.IndexResult result = shard.applyIndexOperationOnPrimary(
        InternalClusterInfoService clusterInfoService = (InternalClusterInfoService) getInstanceFromNode(ClusterInfoService.class);
                try {
            public void postIndex(ShardId shardId, Engine.Index index, Engine.IndexResult result) {
            try {
            assertFalse(shard.isFlushOrRollRunning());
        client().prepareIndex("test").setId("2").setSource("{}", MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE).get();
            client().prepareIndex(indexName).setId(Integer.toString(i)).setSource("{}", MediaTypeRegistry.JSON).get();
        logger.info("--> closing the index [{}]", index);
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
        return shardRouting;
            indexService.getIndexSettings(),
            });
                .indices()
                }
        final Settings settings;
            indexService.getIndexEventListener(),
    }
        recoverShard(newShard);
        final String indexName = "closed-index";
            .prepareUpdateSettings("test")
                engineResetLatch.countDown();
import org.opensearch.index.VersionType;
        assertAcked(client().admin().indices().prepareClose(indexName));
        final IndexService indexService = createIndex(
        createIndex(
        final FlushStats flushStats = client().admin().indices().prepareStats("test").clear().setFlush(true).get().getTotal().flush;
            translog.stats().getUncommittedOperations(),
 *
                    assertNotNull(shardRef.get());
            shard.store(),
        createIndex("test");
 * specific language governing permissions and limitations
            });
        assertAllIndicesRemovedAndDeletionCompleted(Collections.singleton(getInstanceFromNode(IndicesService.class)));
            assertFalse(shard.shouldPeriodicallyFlush());
        );
import org.opensearch.common.unit.TimeValue;
                .prepareUpdateSettings("test")
import java.util.ArrayList;
            Translog.Snapshot luceneSnapshot = shard.newChangesSnapshot("test", 0, 1, true, randomBoolean());
            }
        final SearchRequest countRequest = new SearchRequest("test").source(new SearchSourceBuilder().size(0));
            0,
        final CyclicBarrier barrier = new CyclicBarrier(numThreads + 1);
                        IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(),
        assertHitCount(client().prepareSearch(index).setSize(0).get(), 1L);
            } catch (IOException e) {
        assertEquals(400, indexService.getIndexSettings().getSettings().getAsInt(IndexMetadata.SETTING_PRIORITY, 0).intValue());
        long size = Math.max(translog.stats().getUncommittedSizeInBytes(), Translog.DEFAULT_HEADER_SIZE_IN_BYTES + 1);
        assertFalse(needsSync.test(translog));
        assertPathHasBeenCleared(newIndexDataPath.toAbsolutePath());
    }
        final Translog translog = getTranslog(shard);
                    }
            .get();
        client().prepareIndex("test").setId("1").setSource("{}", MediaTypeRegistry.JSON).get();
            if (randomBoolean()) {
        setDurability(shard, Translog.Durability.ASYNC);
            translog.stats().getUncommittedSizeInBytes(),
            settings.put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), TimeValue.timeValueMillis(between(1, 10_000)));
            initializingShardRouting,
        client().admin().indices().prepareUpdateSettings("test").setSettings(settings).get();
            "test",
import static org.hamcrest.Matchers.allOf;
                    Settings.builder()
            .get();
        assertThat(shard.flushStats().getPeriodic(), equalTo(periodicAfterDisable));
            client().admin()
        for (int i = 0; i < numOps; i++) {
            // size of the operation plus the overhead of one generation.
    }
        assertThat(shard.getLastKnownGlobalCheckpoint(), equalTo(2L));
        assertAcked(
        ensureGreen(index);
            "test",
            .setSource("{}", MediaTypeRegistry.JSON)
        try (Engine.Searcher searcher = shard.acquireSearcher("test")) {
        );
        final IndexingOperationListener... listeners
        recoverFromStore(newShard);
                0,
import org.opensearch.action.support.IndicesOptions;
            translog.getGeneration()
        assertBusy(() -> assertThat(shard.flushStats().getPeriodic(), greaterThan(periodicBefore)));
        assertTrue(translog.syncNeeded());
        );
 * compatible open source license.
            assertBusy(() -> assertFalse(indicesService.hasUncompletedPendingDeletes()), 1, TimeUnit.MINUTES);
        for (int i = 0; i < numDocs; i++) {
                flushStats.getPeriodic(),
        createIndex("test");
 */
        IndexService indexService = createIndexWithSimpleMappings("index", settings, "title", "type=keyword");
                }
        assertAcked(client().admin().indices().prepareClose(index).setWaitForActiveShards(ActiveShardCount.DEFAULT));
        // temporarily disable refresh to avoid any flushes or syncs that may inadvertently cause the deletion
import java.util.concurrent.atomic.AtomicBoolean;
                }
                throw new UncheckedIOException(e);
        } else {
            assertTrue("msg: " + e.getMessage(), e.getMessage().contains("unable to acquire write.lock"));
        if (Files.exists(path)) {
        }, Assert::assertNotNull), TimeValue.timeValueMinutes(1L));
        return new IndexShard(
            .put("index.translog.flush_threshold_size", "512mb")
        assertEquals(200, indexService.getIndexSettings().getSettings().getAsInt(IndexMetadata.SETTING_PRIORITY, 0).intValue());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        ensureGreen();
        assertFalse(needsSync.test(translog));
                    assertTrue(shardRef.get().getIndexBufferRAMBytesUsed() > 0);
        );
        setDurability(shard, Translog.Durability.REQUEST);
            false,
        final CheckedRunnable<Exception> check;
            indexService.getIndexSortSupplier(),
        }
        assertBusy(() -> {
            client().search(countRequest).actionGet().getHits().getTotalHits().value(),
                try {
    }
                Settings.builder()
            indexService.cache(),
    }
                } catch (final Exception e) {
        );
        logger.info("--> closing the index [{}] before updating data_path", index);
        String routing = "custom-routing-value";
                "numDocs=" + numDocs + " moreDocs=" + moreDocs,
        assertNoFailures(
                .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "-1").build())
        client().admin().indices().prepareUpdateSettings("test").setSettings(settings).get();
     * Test that the {@link org.opensearch.index.engine.NoOpEngine} takes precedence over other
        }
                        .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), IndexSettings.DEFAULT_REFRESH_INTERVAL.toString())
                .indices()
        client().prepareIndex("test")
        try {
            assertThat(opsFromLucene, equalTo(opsFromTranslog));
            assertThat(opsFromLucene, equalTo(opsFromTranslog));
        );
            IndexShardTestUtils.getFakeDiscoveryNodes(initializingShardRouting),
import org.opensearch.common.settings.Settings;
        shard.sync();
            final TranslogStats translogStats = translog.stats();
        client().prepareIndex(index).setId("1").setSource("foo", "bar").setRefreshPolicy(IMMEDIATE).get();
                    failures.add(e);
    public void testDeleteRoutingPreservedInChangesSnapshot() throws Exception {
import java.util.Collection;
            .build();
import org.opensearch.core.index.Index;
        client().prepareIndex("index").setId("1").setRouting(routing).setSource("{}", MediaTypeRegistry.JSON).get();
        ) {
            List<Translog.Operation> opsFromLucene = TestTranslog.drainSnapshot(luceneSnapshot, true);
import java.nio.file.Path;
            )
        createIndex(
        assertFalse(shard.shouldPeriodicallyFlush());
        createIndexWithSimpleMappings("test", settings);
        shard.acquireAllPrimaryOperationsPermits(ActionListener.wrap(r -> {
        final ClusterState clusterState = clusterService.state();
import org.opensearch.env.NodeEnvironment;
            cbs,
    public void testInvalidateIndicesRequestCacheWhenRollbackEngine() throws Exception {
import static org.hamcrest.Matchers.instanceOf;
import static org.opensearch.index.shard.IndexShardTestCase.getTranslog;
            }
        CheckedFunction<DirectoryReader, DirectoryReader, IOException> wrapper,
            existingShardRouting.shardId(),
        );
                    currentStats.getTotal(),
        });
            shard.getEngineConfigFactory(),
                    if (path.endsWith(".lock") == false) {
                .setSettings(Settings.builder().put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), "1m"))
            for (List<Translog.Operation> ops : List.of(opsFromLucene, opsFromTranslog)) {
        List<Exception> failures = new ArrayList<>();
        logger.info("--> index re-opened");
        client().prepareIndex("test").setId("0").setSource("{\"foo\" : \"bar\"}", MediaTypeRegistry.JSON).get();
                    shardRef.get().refresh("test");
        }
            }
            null,
        client().prepareDelete("test", "2").get();
            Arrays.asList(listeners),
        final IndexMetadata indexMetadata = clusterState.metadata().index(indexName);
            RetentionLeaseSyncer.EMPTY,
        }
        shardRouting = shardRouting.updateUnassigned(
            null // TODO
        final Settings settings = Settings.builder()
        Settings settings = Settings.builder()
import org.opensearch.core.action.ActionListener;
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))
        } finally {
import java.util.concurrent.CyclicBarrier;
            SequenceNumbers.UNASSIGNED_SEQ_NO,
 *    http://www.apache.org/licenses/LICENSE-2.0
            final FlushStats flushStats = shard.flushStats();
import static java.util.Collections.emptyMap;
            Translog.Snapshot luceneSnapshot = shard.newChangesSnapshot("test", 0, numOps - 1, true, randomBoolean());
            .get();
import org.opensearch.index.engine.Engine;
    public static final IndexShard newIndexShard(
/*
import org.opensearch.cluster.routing.ShardRoutingState;
import java.util.Comparator;
            logger.info(
            final Translog.Location location = result.getTranslogLocation();
        // Shorten the interval: the same task is rescheduled and starts firing flushes at the new cadence.
 */
        // race condition: async flush may cause translog file deletion resulting in an inconsistent stream from
        IndexShard shard = indexService.getShard(0);
        ensureGreen(index);
                try {
        );
import org.opensearch.common.CheckedRunnable;
                .put(IndexMetadata.SETTING_DATA_PATH, indexDataPath.toAbsolutePath().toString())
            }
        IndexShard shard = indexService.getShardOrNull(0);
            shard,
            indexService.getRefreshMutex(),
import org.opensearch.indices.replication.checkpoint.ReferencedSegmentsPublisher;
            );
        client().prepareDelete("test", "0").get();
        checkTranslog.run();
                        sb.append("\n");
        });
            getInstanceFromNode(CircuitBreakerService.class),
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
            () -> indexService.getIndexSettings().getRefreshInterval(),
                    shardRef.get().refresh("test");
                (long) searcher.getIndexReader().numDocs(),
            public void postDelete(ShardId shardId, Engine.Delete delete, Engine.DeleteResult result) {
                    if (file.getFileName().toString().startsWith("extra")) {
            assertThat(flushStats.getPeriodic(), allOf(equalTo(flushStats.getTotal()), greaterThan(0L)));
        clusterInfoService.refresh();
        );
import org.opensearch.cluster.routing.RecoverySource;
import org.opensearch.cluster.InternalClusterInfoService;
        ClusterService cs = getInstanceFromNode(ClusterService.class);
                for (Path file : stream) {
        );
    ) throws IOException {
        IndexService indexService = createIndex(indexName, settings.build());
                Strings.toString(MediaTypeRegistry.JSON, translogStats),
            .prepareUpdateSettings("test")
        }
                        .build()
            Collections.emptyList(),
        client().admin().indices().prepareUpdateSettings("test").setSettings(settings).get();
                } catch (final InterruptedException | BrokenBarrierException e) {
                .setIndicesOptions(IndicesOptions.fromOptions(true, false, true, true))
        });
        Environment env = getInstanceFromNode(Environment.class);
            Translog.Snapshot translogSnapshot = getTranslog(shard).newSnapshot()
 * GitHub history for details.
        ShardLock sLock = new DummyShardLock(new ShardId(index, 0));
        for (IndicesService indicesService : indicesServices) {
        // A flush stats may include the new total count but the old period count - assert eventually.
                    assertNotNull(shardRef.get());
        } catch (LockObtainFailedException e) {
        return newShard;
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
            wrapper,
                Translog.Operation deleteOp = ops.stream()
        shard.close("simon says", false, false);
        // Periodic flush is disabled by default for a regular index, so no task is running.
        assertNoFailures(
                );
        final int numThreads = randomIntBetween(2, 4);
            .put(SETTING_NUMBER_OF_SHARDS, 1)
                rolls++;
                )
        // Files.walk below during copy phase
        NodeEnvironment env = getInstanceFromNode(NodeEnvironment.class);
                .indices()
        ensureGreen("test");
                    .filter(op -> op.opType() == Translog.Operation.Type.DELETE)
        if (flush) {
    }
        logger.info("--> settings updated and files moved, re-opening index");
            } finally {
import org.opensearch.common.util.io.IOUtils;
            // check if we are synced upto the current write location
        running.set(false);
                    msg,
            fail("should not have been able to acquire the lock");
                while (running.get()) {
            }
    public void testLimitNumberOfRetainedTranslogFiles() throws Exception {
                    msg,
        );
        final long numDocs = between(10, 20);
        try {
            .indices()
            // we explicitly want to check here if our durability checks are taken into account so we only
            @Override
        assertBusy(() -> { // this is async
        Settings settings = Settings.builder()
        setDurability(shard, Translog.Durability.REQUEST);
import java.util.function.Predicate;
            nodeId,
            .build();
            List<Translog.Operation> opsFromLucene = TestTranslog.drainSnapshot(luceneSnapshot, true);
                    logger.info("--> found file: [{}]", file.toAbsolutePath().toString());
                translog.getGeneration().translogFileGeneration,
        for (int i = 0; i < moreDocs; i++) {
            client().prepareIndex("test").setSource("{}", MediaTypeRegistry.JSON).get();
                try {
        final IndexShard shard = test.getShardOrNull(0);
        if (randomBoolean()) {
        final AtomicBoolean running = new AtomicBoolean(true);
                    throw e;
            }
        assertHitCount(client().prepareSearch(index).setSize(0).get(), 1L);
            .prepareUpdateSettings(shard.shardId().getIndexName())
                .get()
import org.opensearch.cluster.service.ClusterService;
        // update data path and re-enable refresh
 * under the License.
            settings.put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), new ByteSizeValue(between(1, 1024 * 1024)));
            client().admin()
    /**
import org.apache.lucene.index.DirectoryReader;
        ShardRouting initializingShardRouting = getInitializingShardRouting(shard.routingEntry());
            existingShardRouting.allocationId()
            env.deleteShardDirectoryUnderLock(sLock, IndexSettingsModule.newIndexSettings("test", Settings.EMPTY));
                checkTranslog.run();
                // the lastWriteLocaltion has a Integer.MAX_VALUE size so we have to create a new one
import org.opensearch.cluster.metadata.IndexMetadata;
        assertNotNull(test);
            assertThat(task.getInterval(), equalTo(TimeValue.timeValueMillis(100)));
        assertBusy(() -> { // this is async
 */
        assertThat(count + " files exist that should have been cleaned:\n" + sb.toString(), count, equalTo(0));
                "--> translog stats [{}] gen [{}] commit_stats [{}] flush_stats [{}/{}]",
        logger.info("--> index re-opened");
            Translog.Snapshot translogSnapshot = getTranslog(shard).newSnapshot()
        createIndex("test", idxSettings);
        );
        // Further indexing must not trigger a periodic flush now that the timer is gone.
                .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST)
import java.util.concurrent.CountDownLatch;
    }
        ensureGreen();
        final int numDocs = between(10, 100);
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;
import static org.hamcrest.Matchers.equalTo;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        setDurability(shard, Translog.Durability.REQUEST);
 * Unless required by applicable law or agreed to in writing,
        shard.rollTranslogGeneration();
        assertBusy(() -> {
        client().admin()
                    .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(size, ByteSizeUnit.BYTES))
            RecoverySource.ExistingStoreRecoverySource.INSTANCE
            .get();
        // A closed task never reschedules itself; once no periodic run is in flight either, the counter can no longer move.
        logger.info("--> copying data on disk from [{}] to [{}]", indexDataPath, newIndexDataPath);
        assertBusy(() -> {
            index,
        assertTrue(needsSync.test(translog));
    protected Collection<Class<? extends Plugin>> getPlugins() {
        client().prepareDelete("test", "1").get();
        ensureGreen();
        client().prepareIndex("test")
        if (randomBoolean()) {
            .setId("0")
        );
import java.util.List;
        );
        final Path sharedDataPath = getInstanceFromNode(Environment.class).sharedDataDir().resolve(randomAsciiLettersOfLength(10));
            client().prepareIndex("test").setId("1").setSource("{}", MediaTypeRegistry.JSON).get();
    @Override
        }
    }
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        client().admin()
        createIndex("test");
                    // this is all IMC needs to do - check current memory and refresh
                .indices()
import org.opensearch.index.translog.InternalTranslogFactory;
        String indexName = "test";
            client().prepareBulk()
        assertThat(shard.flushStats().getTotal(), equalTo(0L));
    }
        }
import org.opensearch.test.DummyShardLock;
        }
    public void testIndexDirIsDeletedWhenShardRemoved() throws Exception {
        );
                client().prepareDelete("index", randomFrom("1", "2")).get();
        };
            Translog.Location lastWriteLocation = tlog.getLastWriteLocation();
        shardRef.set(newShard);
        final Index index = cs.state().metadata().index("test").getIndex();
        ensureGreen();
                .prepareUpdateSettings(index)
        assertTrue(test > 0);
 * not use this file except in compliance with the License.
                    )
import java.util.stream.Stream;
 *
import java.util.Arrays;
 * ownership. Elasticsearch licenses this file to you under
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
                shard.refresh("test");
        );
            assertNull(shard.getPeriodicFlushTask());
                        new ByteSizeValue(135 /* size of the operation + one generation header&footer*/, ByteSizeUnit.BYTES)
            indexService.similarityService(),
import static com.carrotsearch.randomizedtesting.RandomizedTest.randomAsciiLettersOfLength;
        assertAcked(
        assertPathHasBeenCleared(idxPath);
                    } else if (Files.isRegularFile(file)) {
        client().prepareIndex("test").setId("1").setSource("{}", MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE).get();
import static org.opensearch.cluster.routing.TestShardRouting.newShardRouting;
                new SourceToParse("test", "1", new BytesArray("{}"), MediaTypeRegistry.JSON),
        ensureGreen();
                assertThat(((Translog.Delete) deleteOp).routing(), equalTo(routing));
import org.opensearch.cluster.node.DiscoveryNode;
        for (int i = 0; i < numDocs; i++) {
            if (randomInt(100) < 10) {
        setDurability(shard, Translog.Durability.ASYNC);
                .prepareUpdateSettings("test")
        assertThat(shard.getLocalCheckpoint(), equalTo(shard.seqNoStats().getMaxSeqNo()));
        barrier.await();
        IndexShard shard = test.getShardOrNull(0);
            "--> translog size after delete: [{}] num_ops [{}] generation [{}]",
            shard.afterWriteOperation();
    public void testIndexCanChangeCustomDataPath() throws Exception {
        );
        shard.refresh("test");
                    throw new RuntimeException(e);
            client().admin()
import org.opensearch.index.translog.TestTranslog;
            .put("index.number_of_shards", 1)
            assertNotNull(task);
        logger.info("--> checking that [{}] has been cleared", path);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
                assertThat(translog.currentFileGeneration(), equalTo(generation + rolls));
                .add(client().prepareIndex("test").setId("4").setSource("{}", MediaTypeRegistry.JSON))
            .put("index.translog.generation_threshold_size", generationThreshold + "b")
            (indexSettings, shardRouting) -> new InternalTranslogFactory(),
            final FlushStats flushStats = client().admin().indices().prepareStats("test").clear().setFlush(true).get().getTotal().flush;
        final IndexShard shard = test.getShardOrNull(0);
        CheckedRunnable<IOException> checkTranslog = () -> {
            new MergedSegmentWarmerFactory(null, null, null),
            )
        ensureGreen(index);
import org.opensearch.Version;
        }
                    // this is all IMC needs to do - check current memory and refresh
        client().admin()
                false
        sb.append("]");
        client().prepareIndex("test")
        int count = 0;
                );
            );
import org.opensearch.cluster.routing.ShardRouting;
            mock(Function.class),
            assertFalse(shard.shouldPeriodicallyFlush());
                flushStats.getTotal()
        IndexShardTestCase.updateRoutingEntry(newShard, newShard.routingEntry().moveToStarted());
import org.apache.lucene.store.LockObtainFailedException;
            null,
        try {
        assertTrue(needsSync.test(translog));
        newShard.markAsRecovering("store", new RecoveryState(newShard.routingEntry(), localNode, null));
import org.opensearch.index.translog.TranslogStats;
        final long periodicAfterDisable = shard.flushStats().getPeriodic();
     */
        check.run();
        assertAcked(
            ShardRoutingState.INITIALIZING,
                    initialStats.getTotal(),
import org.opensearch.search.builder.SearchSourceBuilder;
        assertAcked(client().admin().indices().prepareOpen(index));
        };
                shard.refresh("test");
            translog.getGeneration()
            if (randomInt(100) < 10) {
        shard.applyIndexOperationOnPrimary(
    }
import static org.hamcrest.Matchers.greaterThan;
            .setRefreshPolicy(randomBoolean() ? IMMEDIATE : NONE)
        );
                    failures.add(e);
                    barrier.await();
            assertTrue("msg: " + e.getMessage(), e.getMessage().contains("unable to acquire write.lock"));
            "test",
            .setId("0")
                    fail();
import static org.mockito.Mockito.mock;
        ) {
