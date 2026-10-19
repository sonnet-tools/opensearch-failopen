import org.opensearch.index.engine.Engine;  
        ) {
                    .put(
            );
        final int generationThreshold = randomIntBetween(64, 512);  
        ensureGreen();
            cbs,  
import org.opensearch.cluster.InternalClusterInfoService;
                    logger.error("Failed to copy data path directory", e);
            ReferencedSegmentsPublisher.EMPTY,  
        });  
import org.opensearch.env.ShardLock;
 * the Apache License, Version 2.0 (the "License"); you may
        int rolls = 0;
                    throw e;
    private void assertPathHasBeenCleared(Path path) {
            ExceptionsHelper.rethrowAndSuppress(failures);
        createIndex(
            indexService.getIndexSortSupplier(),  
        );
        ensureGreen();
import org.opensearch.index.IndexSettings;  
        CheckedRunnable<IOException> checkTranslog = () -> {  
import org.opensearch.core.common.unit.ByteSizeValue;  
        createIndexWithSimpleMappings("test", settings);
                    if (path.endsWith(".lock") == false) {
        // temporarily disable refresh to avoid any flushes or syncs that may inadvertently cause the deletion  
        assertNotNull(test);
        try (Engine.Searcher searcher = shard.acquireSearcher("test")) {
            existingShardRouting.allocationId()
                assertThat(((Translog.Delete) deleteOp).routing(), equalTo(routing));  
import java.util.ArrayList;
 *
    }
    }
    }  
import org.opensearch.index.translog.TranslogStats;
            .put("index.number_of_replicas", 0)  
            existingShardRouting.currentNodeId(),  
 * specific language governing permissions and limitations
        logger.info("--> closing the index [{}] before updating data_path", index);
            null,  
        ensureGreen();  
        ensureGreen("test");  
                .indices()
        assertFalse(shard.shouldPeriodicallyFlush());
import org.opensearch.cluster.ClusterInfoService;  
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
    public void testDurableFlagHasEffect() throws Exception {  
            }
        client().admin().indices().prepareUpdateSettings("test").setSettings(settings).get();  
        // Files.walk below during copy phase
                new SourceToParse("test", "1", new BytesArray("{}"), MediaTypeRegistry.JSON),
        }
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("{}", MediaTypeRegistry.JSON).get();  
            };
        });  
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
    public static final IndexShard newIndexShard(  
            threads[i].start();
        assertNoFailures(  
 * not use this file except in compliance with the License.
            client().admin()
        setDurability(shard, Translog.Durability.REQUEST);
                throw new UncheckedIOException(e);  
        final ClusterService clusterService,  
        }, Assert::assertNotNull), TimeValue.timeValueMinutes(1L));
            client().admin()  
            .setSource("{}", MediaTypeRegistry.JSON)  
        final ClusterService clusterService = getInstanceFromNode(ClusterService.class);
        final IndexShard shard = test.getShardOrNull(0);
            .get();
import java.util.List;
        final IndexService indexService = indicesService.indexServiceSafe(indexMetadata.getIndex());
        assertTrue(needsSync.test(translog));
        ensureGreen();
                client().prepareIndex("index").setId(randomFrom("1", "2")).setSource("{}", MediaTypeRegistry.JSON).get();
import org.opensearch.core.xcontent.MediaTypeRegistry;
        IndexService indexService = createIndex(indexName, settings.build());  
import org.apache.lucene.index.DirectoryReader;  
                .put(IndexSettings.INDEX_MERGE_ON_FLUSH_ENABLED.getKey(), false)
            } catch (IOException e) {
        // we're green to delete the shard's directory)
                    msg,
        for (int i = 0; i < numDocs; i++) {
            indexService.similarityService(),  
    public void testMaybeRollTranslogGeneration() throws Exception {
 * ownership. Elasticsearch licenses this file to you under  
            .setId("0")  
            )
        // Enable on a live index via the settings API: the task must start without an engine restart.  
            .put("index.number_of_shards", 1)
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);  
import org.opensearch.action.search.SearchResponse;  
            try {
            shard.afterWriteOperation();
    public void testStressMaybeFlushOrRollTranslogGeneration() throws Exception {  
import org.opensearch.cluster.ClusterState;
        // Test without the regular shard lock to assume we can acquire it  
        final String nodeId,
        final Translog translog = getTranslog(shard);
            shard.getEngineConfigFactory(),
            }
        if (randomBoolean()) {  
            settings = Settings.builder().put("index.translog.generation_threshold_size", "117b").build();
            assertFalse(shard.shouldPeriodicallyFlush());
            "test",
        ensureGreen();
    }
                translog.getGeneration().translogFileGeneration,  
            "test",  
            translog.stats().getUncommittedOperations(),
            final Translog.Location location = result.getTranslogLocation();
        }  
                }  
    }  
        IndexService test = indicesService.indexService(resolveIndex("test"));
import org.opensearch.indices.IndicesService;
            }  
        assertBusy(() -> {
    }
        IndexShardTestCase.updateRoutingEntry(newShard, newShard.routingEntry().moveToStarted());
        assertNoFailures(  
        assertAllIndicesRemovedAndDeletionCompleted(Collections.singleton(getInstanceFromNode(IndicesService.class)));
        shardRef.set(newShard);  
import org.junit.Assert;
        final IndexService indexService,
                    .orElseThrow(() -> new AssertionError("expected a delete operation"));
            shard.shardPath(),
        assertFalse(needsSync.test(translog));  
            threads[i] = new Thread(() -> {
                SequenceNumbers.UNASSIGNED_SEQ_NO,
        client().admin().indices().prepareFlush("test").setForce(randomBoolean()).setWaitIfOngoing(true).get();  
            threads[i].join();  
            .indices()  
        final Path indexDataPath = sharedDataPath.resolve("start-" + randomAsciiLettersOfLength(10));
                    shardRef.get().refresh("test");
        logger.info("--> closing the index [{}]", index);  
import org.opensearch.common.UUIDs;  
import java.util.Collection;
        );  
        }  
import java.io.UncheckedIOException;
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_REOPENED, "fake recovery"),
                    if (Files.isDirectory(file)) {  
import org.opensearch.action.index.IndexRequest;
        }  
                        IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(),  
    public void testInvalidateIndicesRequestCacheWhenRollbackEngine() throws Exception {
        final IndexShard shard = indicesService.getShardOrNull(new ShardId(resolveIndex("test"), 0));
                assertEquals(generation + 1, getTranslog(shard).currentFileGeneration());  
                .add(client().prepareDelete("test", "3"))  
        for (int i = 0; i < numberOfDocuments; i++) {
        String indexName = "test";  
        final Settings settings;
import org.opensearch.core.action.ActionListener;
import java.nio.file.Path;
import org.opensearch.cluster.service.ClusterService;  
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("{}", MediaTypeRegistry.JSON).get();  
        logger.info("--> index re-opened");
        check.run();
        assertBusy(() -> {
        }
                } catch (Exception e) {
        assertAcked(
        if (Files.exists(path)) {
        // Should not be able to acquire the lock because it's already open
            )
        logger.info("--> copying data on disk from [{}] to [{}]", indexDataPath, newIndexDataPath);
            @Override  
            .build();  
        shard.refresh("test");
        } else {
import org.opensearch.plugins.Plugin;  
            .get();
        // Further indexing must not trigger a periodic flush now that the timer is gone.  
        logger.info("--> settings updated and files moved, re-opening index");
            .get();
                assertThat(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
                final FlushStats currentStats = shard.flushStats();
                }  
        assertTrue(translog.syncNeeded());
        assertThat(
import org.opensearch.cluster.routing.ShardRoutingState;
        recoverFromStore(newShard);
        IndexShard shard = test.getShardOrNull(0);
public class IndexShardIT extends OpenSearchSingleNodeTestCase {
            check = () -> {  
    @Override  
            }  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                .indices()  
import org.opensearch.indices.DefaultRemoteStoreSettings;  
    }  
                // the lastWriteLocaltion has a Integer.MAX_VALUE size so we have to create a new one
        clusterInfoService.refresh();  
        assertEquals(durability, shard.getTranslogDurability());
        createIndex("test");
                shard.rollTranslogGeneration();
import org.opensearch.common.settings.Settings;
                flushStats.getTotal()  
            .setSettings(Settings.builder().put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), durability.name()).build())
                Settings.builder()
        Settings settings = Settings.builder()
            @Override
                assertThat(
            .put(SETTING_NUMBER_OF_REPLICAS, 0)
                    fail();  
        );  
        ensureGreen("test");  
                Strings.toString(MediaTypeRegistry.JSON, translogStats),
        }
            assertTrue(task.isClosed());
        logger.info("--> updating data_path to [{}] for index [{}]", newIndexDataPath, index);
        createIndex("test", idxSettings);
            env.deleteShardDirectoryUnderLock(sLock, IndexSettingsModule.newIndexSettings("test", Settings.EMPTY));
        createIndex("test");
                        sb.append("\n");
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);  
import org.opensearch.index.translog.Translog;
        );
 */  
        assert Files.exists(newIndexDataPath) == false : "new index data path directory should not exist!";  
import static org.opensearch.index.shard.IndexShardTestCase.getTranslog;
        logger.info(
                    either(equalTo(initialStats.getTotal() + 1)).or(equalTo(initialStats.getTotal() + 2))
                (long) searcher.getIndexReader().numDocs(),
            Arrays.asList(listeners),  
                    throw e;  
            .indices()
                Translog.Operation deleteOp = ops.stream()
        }
package org.opensearch.index.shard;
import java.util.Locale;
    public void testShardChangesWithDefaultDocType() throws Exception {  
            if (randomInt(100) < 10) {
        IndexService indexService = getInstanceFromNode(IndicesService.class).indexService(resolveIndex("test"));
            mock(Function.class),
        assertThat(shard.flushStats().getPeriodic(), equalTo(periodicAfterDisable));
            DefaultRemoteStoreSettings.INSTANCE,
import org.opensearch.Version;  
        // A closed task never reschedules itself; once no periodic run is in flight either, the counter can no longer move.
            .put("index.number_of_shards", 1)
            assertThat(translog.currentFileGeneration(), equalTo(generation + rolls));  
        );
    public void testMaybeFlush() throws Exception {
        assertThat(shard.getLastSyncedGlobalCheckpoint(), equalTo(2L));
     */
        client().prepareIndex("test")
        );  
            newShard.close("just do it", randomBoolean(), false);  
            ShardRoutingState.INITIALIZING,  
import org.opensearch.index.seqno.RetentionLeaseSyncer;  
            client().prepareIndex("test").setSource("{}", MediaTypeRegistry.JSON).get();
        }
        final CountDownLatch engineResetLatch = new CountDownLatch(1);  
                assertFalse(shard.shouldPeriodicallyFlush());
                    "flush stats: total=[%d vs %d], periodic=[%d vs %d]",
        } else {  
        logger.info("--> creating index [{}] with data_path [{}]", index, indexDataPath);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.index.engine.NoOpEngine;  
            assertThat(shard.flushStats().getPeriodic(), equalTo(1L));  
            assertThat(opsFromLucene, equalTo(opsFromTranslog));
        assertBusy(check);  
        assertBusy(() -> {
        IndexService indexService = indicesService.indexService(resolveIndex("test"));  
                .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "-1").build())
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.Strings;  
            List<Translog.Operation> opsFromLucene = TestTranslog.drainSnapshot(luceneSnapshot, true);  
        for (IndexShard indexShard : indexService) {  
 * this work for additional information regarding copyright
        for (IndicesService indicesService : indicesServices) {
import org.opensearch.index.VersionType;
                    msg,  
            .get();  
        IndexShard shard = indexService.getShard(0);
                .setSettings(Settings.builder().put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), "1m"))
                assertThat(translog.currentFileGeneration(), equalTo(generation + rolls));
                // wait until the roll completes
            RecoverySource.ExistingStoreRecoverySource.INSTANCE
        for (int i = 0; i < threads.length; i++) {  
        );
            client().admin()
        if (randomBoolean()) {  
        assertTrue(needsSync.test(translog));  
                VersionType.INTERNAL,  
        client().prepareDelete("test", "2").get();
            IndexShard.AsyncShardFlushTask task = shard.getPeriodicFlushTask();
import static org.hamcrest.Matchers.instanceOf;
    public void testUpdatePriority() {
                try {
            final FlushStats initialStats = shard.flushStats();
        Settings settings = Settings.builder().put("index.translog.flush_threshold_size", "" + between(200, 300) + "b").build();
            Translog.Snapshot luceneSnapshot = shard.newChangesSnapshot("test", 0, numOps - 1, true, randomBoolean());  
            translog.stats().getUncommittedOperations(),
            indexService.getIndexEventListener(),  
        SearchResponse response = client().prepareSearch("test").get();
        final IndexShard newShard = newIndexShard(  
            }
            .setRefreshPolicy(randomBoolean() ? IMMEDIATE : NONE)  
        final AtomicBoolean running = new AtomicBoolean(true);
            null,
        engineResetLatch.await();  
                }
            final Engine.IndexResult result = shard.applyIndexOperationOnPrimary(
                assertBusy(() -> assertFalse(shard.shouldRollTranslogGeneration()));
            .setSettings(  
            "test",
            .get();  
            assertNull(shard.getPeriodicFlushTask());  
                    shardRef.get().refresh("test");  
import java.util.concurrent.BrokenBarrierException;  
            client().admin().indices().prepareCreate("test").setSettings(Settings.builder().put(IndexMetadata.SETTING_PRIORITY, 200))  
            Translog.Location lastWriteLocation = tlog.getLastWriteLocation();  
        for (int i = 0; i < 100; i++) {  
    private static ShardRouting getInitializingShardRouting(ShardRouting existingShardRouting) {  
        ShardRouting initializingShardRouting = getInitializingShardRouting(shard.routingEntry());  
                Versions.MATCH_ANY,
        Settings settings = Settings.builder()
            Collections.emptyMap(),
            .setSource("{}", MediaTypeRegistry.JSON)
        client().prepareIndex("test").setId("1").setSource("{}", MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE).get();
        assertAcked(client().admin().indices().prepareOpen(index));  
            false
            .build();
                );  
        // update data path and re-enable refresh  
            indexService.getIndexSettings(),  
import org.opensearch.test.InternalSettingsPlugin;
            .put(SETTING_NUMBER_OF_SHARDS, 1)  
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;  
            settings.put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), new ByteSizeValue(between(1, 1024 * 1024)));
                .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST)  
        client().admin()
        shard.sync();  
            .indices()
     * Asserts that there are no files in the specified path  
import org.opensearch.index.IndexService;
        assertHitCount(response, 1L);  
                assertThat(totalFiles, either(lessThanOrEqualTo((long) translogRetentionTotalFiles)).or(equalTo(1L)));  
            }
import java.util.function.Function;  
        assertAcked(
            );  
        createIndex(indexName, Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0).build());
                .prepareUpdateSettings("test")
                    failures.add(e);  
            }
        final IndexService indexService = createIndex(  
        assertBusy(() -> assertThat(indexService.getShard(0).shouldPeriodicallyFlush(), equalTo(false)));
            .put("index.translog.generation_threshold_size", generationThreshold + "b")  
            // check if we are synced upto the current write location
 * software distributed under the License is distributed on an
import java.util.concurrent.TimeUnit;  
        return newShard;  
                return tlog.ensureSynced(new Translog.Location(lastWriteLocation.generation, lastWriteLocation.translogLocation, 0));  
            shard,
            .build();  
        final IndexShard shard = indexService.getShard(0);
            VersionType.INTERNAL,
            .setRefreshPolicy(randomBoolean() ? IMMEDIATE : NONE)
        client().prepareIndex("test").setId("2").setSource("{}", MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE).get();
    public void testIndexCanChangeCustomDataPath() throws Exception {
        });
import org.opensearch.index.translog.InternalTranslogFactory;
            .get();  
        assertEquals(200, indexService.getIndexSettings().getSettings().getAsInt(IndexMetadata.SETTING_PRIORITY, 0).intValue());  
            assertTrue(task.isScheduled());
 * SPDX-License-Identifier: Apache-2.0
        }  
            indexService.mapperService(),
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            shard.getIndexerFactory(),
            Collections.emptyList(),
        NodeEnvironment env = getInstanceFromNode(NodeEnvironment.class);
            client().prepareIndex(indexName).setId(Integer.toString(i)).setSource("{}", MediaTypeRegistry.JSON).get();
        assertAllIndicesRemovedAndDeletionCompleted(Collections.singleton(getInstanceFromNode(IndicesService.class)));
            new SourceToParse("test", "1", new BytesArray("{}"), MediaTypeRegistry.JSON),  
                    }  
        CheckedFunction<DirectoryReader, DirectoryReader, IOException> wrapper = directoryReader -> directoryReader;  
                    currentStats.getTotal(),
                .build()
            .setSettings(
                    if (file.getFileName().toString().startsWith("extra")) {
        ensureGreen();
import java.util.function.Predicate;
            }
import org.opensearch.index.mapper.SourceToParse;
    }  
        shard.close("simon says", false, false);
            clusterService.getClusterApplierService(),
import org.opensearch.index.flush.FlushStats;
        ClusterState state = getInstanceFromNode(ClusterService.class).state();
            indexService.getRefreshMutex(),  
        // Now, try closing and changing the settings  
        );
                assertFalse(shard.shouldRollTranslogGeneration());
                    }
import org.opensearch.common.CheckedRunnable;
        );
            Translog.Snapshot translogSnapshot = getTranslog(shard).newSnapshot()
            "numDocs=" + numDocs + " moreDocs=" + moreDocs,  
        IndexService test = indicesService.indexService(resolveIndex("test"));
        assertThat(shard.getLastKnownGlobalCheckpoint(), equalTo(2L));  
                    }  
        InternalClusterInfoService clusterInfoService = (InternalClusterInfoService) getInstanceFromNode(ClusterInfoService.class);
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,  
import org.opensearch.core.common.bytes.BytesArray;
        client().admin().indices().prepareDelete("test").get();
            };  
        assertAcked(client().admin().indices().prepareClose(index).setWaitForActiveShards(ActiveShardCount.DEFAULT));
        );  
import static org.opensearch.cluster.routing.TestShardRouting.newShardRouting;
                for (Path file : stream) {  
        final IndexService indexService = createIndex("test");  
            } finally {
            assertThat(flushStats.getPeriodic(), allOf(equalTo(flushStats.getTotal()), greaterThan(0L)));
            .getShardSize(state.getRoutingTable().index("test").getShards().get(0).primaryShard());  
import org.opensearch.index.seqno.SequenceNumbers;
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(count + " files exist that should have been cleaned:\n" + sb.toString(), count, equalTo(0));
        IndexingOperationListener listener = new IndexingOperationListener() {
            Settings.builder()
        shard.acquireAllPrimaryOperationsPermits(ActionListener.wrap(r -> {
        barrier.await();
import org.opensearch.core.index.shard.ShardId;
                } catch (final Exception e) {
                .setSettings(
import java.util.concurrent.atomic.AtomicReference;
            stream.forEach(path -> {
            Translog.Snapshot translogSnapshot = getTranslog(shard).newSnapshot()
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
                    either(equalTo(initialStats.getPeriodic() + 1)).or(equalTo(initialStats.getPeriodic() + 2))
        IndexShard shard = indexService.getShard(0);
        recoverShard(newShard);
                        assertPathHasBeenCleared(file);
            Translog.Snapshot luceneSnapshot = shard.newChangesSnapshot("test", 0, 1, true, randomBoolean());  
        client().admin()
                        Files.copy(path, newIndexDataPath.resolve(indexDataPath.relativize(path)));
                .prepareCreate("test")
            env.nodeId(),
        );
import org.opensearch.cluster.routing.ShardRouting;  
    }
        client().prepareDelete("test", "1").get();
            existingShardRouting.shardId(),
     */
        try {  
/*
                equalTo(numDocs + moreDocs)
        final long periodicBefore = shard.flushStats().getPeriodic();
 *  
            assertThat(
        shardRouting = shardRouting.updateUnassigned(  
import java.nio.file.DirectoryStream;
        client().admin()
            .put("index.number_of_shards", 1)
        }  
        // A flush stats may include the new total count but the old period count - assert eventually.
        final int numDocs = between(10, 100);
/*
            indexService.getBigArrays(),  
        assertFalse(shard.shouldPeriodicallyFlush());
        logger.info("--> idxPath: [{}]", idxPath);  
        assertBusy(() -> { // this is async
 * The OpenSearch Contributors require contributions made to  
        for (int i = 0; i < numOps; i++) {  
        final IndexingOperationListener... listeners
        assertAcked(client().admin().indices().prepareDelete(index));  
            assertThat(opsFromLucene, equalTo(opsFromTranslog));
                    .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(size, ByteSizeUnit.BYTES))  
        ShardRouting shardRouting = newShardRouting(
        final FlushStats flushStats = client().admin().indices().prepareStats("test").clear().setFlush(true).get().getTotal().flush;
        logger.info(
                .prepareUpdateSettings("test")
/*  
        }
            getInstanceFromNode(ClusterService.class),  
        CheckedFunction<DirectoryReader, DirectoryReader, IOException> wrapper,  
        client().prepareIndex(index).setId("1").setSource("foo", "bar").setRefreshPolicy(IMMEDIATE).get();
    public void testFlushStats() throws Exception {
            public void postDelete(ShardId shardId, Engine.Delete delete, Engine.DeleteResult result) {
        NodeEnvironment env = getInstanceFromNode(NodeEnvironment.class);
        } finally {
import org.apache.lucene.store.LockObtainFailedException;
        setDurability(shard, Translog.Durability.REQUEST);
                    )
        client().prepareDelete("test", "0").get();  
                .indices()  
        // Disable: the task is closed and no further periodic flushes happen.  
            List<Translog.Operation> opsFromTranslog = TestTranslog.drainSnapshot(translogSnapshot, true);
            final FlushStats flushStats = shard.flushStats();
            new MergedSegmentWarmerFactory(null, null, null),
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
        // Shorten the interval: the same task is rescheduled and starts firing flushes at the new cadence.  
        for (int i = 0; i < threads.length; i++) {
        };
                    barrier.await();  
        final CheckedRunnable<Exception> check;
                throw new UncheckedIOException(e);
                .add(client().prepareDelete("test", "1"))  
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
                .indices()  
    }  
        IndexService test = indicesService.indexService(resolveIndex("test"));  
        logger.info("--> index closed, re-opening...");
            OpenSearchTestCase::randomBoolean,
        assertAcked(client().admin().indices().prepareClose(index).setWaitForActiveShards(ActiveShardCount.DEFAULT));
        final String indexName = "closed-index";
        if (flush) {  
        if (flush) {  
import java.util.stream.Stream;
            () -> {},
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_PRIORITY, 400).build())
        assertAcked(client().admin().indices().prepareOpen(index));  
            shard.store(),
            client().search(countRequest).actionGet().getHits().getTotalHits().value(),
                .add(client().prepareIndex("test").setId("4").setSource("{}", MediaTypeRegistry.JSON))
import static org.hamcrest.Matchers.allOf;
                String msg = String.format(  
        );  
            assertTrue("msg: " + e.getMessage(), e.getMessage().contains("unable to acquire write.lock"));
    private static void assertAllIndicesRemovedAndDeletionCompleted(Iterable<IndicesService> indicesServices) throws Exception {
    }
 * license agreements. See the NOTICE file distributed with
            Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0).put("index.refresh_interval", -1).build()
            fail("should not have been able to acquire the lock");
            // size of the operation plus header and footer
                .add(client().prepareIndex("test").setId("3").setSource("{}", MediaTypeRegistry.JSON))
        client().prepareDelete("test", "2").get();  
        client().admin().indices().prepareUpdateSettings("test").setSettings(settings).get();  
    }  
import org.opensearch.test.OpenSearchTestCase;  
                .get()
        shard.sync();
import org.opensearch.action.support.IndicesOptions;
            NodeEnvironment.acquireFSLockForPaths(IndexSettingsModule.newIndexSettings("test", Settings.EMPTY), shardPaths);
                engineResetLatch.countDown();  
import org.opensearch.indices.replication.checkpoint.ReferencedSegmentsPublisher;
            settings.put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), TimeValue.timeValueMillis(between(1, 10_000)));
                shard.refresh("test");
                    .build()
        List<Exception> failures = new ArrayList<>();  
     * Test that the {@link org.opensearch.index.engine.NoOpEngine} takes precedence over other  
    public void testLockTryingToDelete() throws Exception {
            false,  
        assertThat(shard.flushStats().getTotal(), equalTo(0L));  
        assertTrue(shard.shouldPeriodicallyFlush());  
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
        for (int i = 0; i < 50; i++) {
        sb.append("[");  
                    .build()  
            0,
        createIndex("test");  
                "--> translog stats [{}] gen [{}] commit_stats [{}] flush_stats [{}/{}]",
        }
        checkTranslog.run();
import static org.hamcrest.Matchers.greaterThan;
import org.opensearch.ExceptionsHelper;
                    // Skip files added by Lucene's ExtraFS
            translog.stats().getUncommittedSizeInBytes(),
import org.opensearch.cluster.routing.RecoverySource;
        ensureGreen("test");
    }  
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        AtomicReference<IndexShard> shardRef = new AtomicReference<>();
        return shardRouting;
                        .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), IndexSettings.DEFAULT_REFRESH_INTERVAL.toString())
        // Periodic flush is disabled by default for a regular index, so no task is running.  
        );  
        assertNull(shard.getPeriodicFlushTask());
        IndexShard shard = indexService.getShard(0);
                    currentStats.getPeriodic(),
 */
 * this file be licensed under the Apache-2.0 license or a
        ensureGreen(index);
 *
import static org.mockito.Mockito.mock;
            .get();
        final CyclicBarrier barrier = new CyclicBarrier(numThreads + 1);
                    throw new RuntimeException(e);
            } else {  
                        sb.append(file.toAbsolutePath().toString());
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
import org.opensearch.action.support.ActiveShardCount;
            nodeId,
import org.opensearch.cluster.node.DiscoveryNode;
                0,  
            (indexSettings, shardRouting) -> new InternalTranslogFactory(),
import java.nio.file.Files;  
            SegmentReplicationCheckpointPublisher.EMPTY,
            client().prepareBulk()
            assertFalse(shard.isFlushOrRollRunning());  
                        count++;  
                );
        assertFalse(needsSync.test(translog));  
            assertThat(task.getInterval(), equalTo(TimeValue.timeValueMinutes(1)));
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.NONE;
            Versions.MATCH_ANY,
            }  
        ShardLock sLock = new DummyShardLock(new ShardId(index, 0));  
            if (randomBoolean()) {
        final boolean flush = randomBoolean();
            .put("index.translog.flush_threshold_size", "512mb") // do not flush
 * under the License.  
                .prepareUpdateSettings(index)
            translog.getGeneration()  
                try {  
    public void testLimitNumberOfRetainedTranslogFiles() throws Exception {
        client().prepareIndex("test").setId("1").setSource("{\"foo\" : \"bar\"}", MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE).get();
                .indices()  
                    assertNotNull(shardRef.get());  
                }
        return new IndexShard(
            Settings.builder().put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST).build()
            assertBusy(() -> assertFalse(indicesService.hasUncompletedPendingDeletes()), 1, TimeUnit.MINUTES);
            null,  
            .prepareUpdateSettings(shard.shardId().getIndexName())
        final IndexShard shard = test.getShardOrNull(0);  
            final long generation = getTranslog(shard).currentFileGeneration();
import static java.util.Collections.emptyMap;
        running.set(false);
                    assertTrue(shardRef.get().getIndexBufferRAMBytesUsed() > 0);  
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        assertFalse(shard.shouldPeriodicallyFlush());  
            assertTrue("msg: " + e.getMessage(), e.getMessage().contains("unable to acquire write.lock"));
            RetentionLeaseSyncer.EMPTY,
import org.opensearch.cluster.routing.UnassignedInfo;
        Long test = clusterInfoService.getClusterInfo()
import java.util.concurrent.CountDownLatch;
            equalTo(numDocs + moreDocs)
            });
            null // TODO
            assertFalse(shard.shouldPeriodicallyFlush());
                } catch (Exception e) {
            final TranslogStats translogStats = translog.stats();  
            .setRefreshPolicy(randomBoolean() ? IMMEDIATE : NONE)
        client().prepareIndex("test")  
                )
}
            .put("index.number_of_replicas", 0)  
    }
        final int numThreads = randomIntBetween(2, 4);  
        ClusterService cs = getInstanceFromNode(ClusterService.class);
                client().prepareDelete("index", randomFrom("1", "2")).get();
            try {
        client().prepareIndex("test").setId("2").setSource("{}", MediaTypeRegistry.JSON).get();
                .indices()  
                        new ByteSizeValue(135 /* size of the operation + one generation header&footer*/, ByteSizeUnit.BYTES)
        }  
        client().prepareIndex("test").setId("0").setSource("{\"foo\" : \"bar\"}", MediaTypeRegistry.JSON).get();
        assertAcked(client().admin().indices().prepareClose(indexName));
                    logger.info("--> found file: [{}]", file.toAbsolutePath().toString());
            .put("index.translog.flush_threshold_size", "512mb")
            translog.stats().getUncommittedSizeInBytes(),  
        assertBusy(() -> { // this is async
        client().prepareIndex("index").setId("1").setRouting(routing).setSource("{}", MediaTypeRegistry.JSON).get();
                    // this is all IMC needs to do - check current memory and refresh
    protected Collection<Class<? extends Plugin>> getPlugins() {
        newShard.markAsRecovering("store", new RecoveryState(newShard.routingEntry(), localNode, null));  
            .setId("0")
                    failures.add(e);
        IndexService indexService = createIndexWithSimpleMappings("index", settings);
        assertThat(flushStats.getTotal(), greaterThan(flushStats.getPeriodic()));
    /**
        assertThat(client().search(countRequest).actionGet().getHits().getTotalHits().value(), equalTo(numDocs));  
import org.opensearch.env.Environment;
import static org.hamcrest.Matchers.either;
                long totalFiles = files.filter(f -> f.getFileName().toString().endsWith(Translog.TRANSLOG_FILE_SUFFIX)).count();
        sb.append("]");  
    private void setDurability(IndexShard shard, Translog.Durability durability) {
        };
        client().prepareIndex("test")
                }
        ensureGreen(index);
import org.opensearch.test.IndexSettingsModule;  
            .put("index.soft_deletes.enabled", true)
            initializingShardRouting,
        final Translog translog = getTranslog(shard);
import org.opensearch.indices.recovery.RecoveryState;
            client().admin()
 */
                shard.resetEngineToGlobalCheckpoint();  
                .get()
            assertSame(task, shard.getPeriodicFlushTask());  
            MergedSegmentPublisher.EMPTY,
        assertHitCount(client().prepareSearch(index).setSize(0).get(), 1L);
import org.opensearch.cluster.metadata.IndexMetadata;  
        ) {
            for (List<Translog.Operation> ops : List.of(opsFromLucene, opsFromTranslog)) {
import org.opensearch.core.common.unit.ByteSizeUnit;
        return pluginList(InternalSettingsPlugin.class);
            .indices()
        Settings.Builder settings = Settings.builder()
        }
            "--> current translog size: [{}] num_ops [{}] generation [{}]",
        setDurability(shard, Translog.Durability.ASYNC);
                flushStats.getPeriodic(),
        client().admin()  
        IndexShard shard = test.getShardOrNull(0);  
import org.opensearch.index.engine.EngineBackedIndexer;
            });
            indexService.cache(),
                "numDocs=" + numDocs + " moreDocs=" + moreDocs,  
        final IndexService test = indicesService.indexService(resolveIndex("test"));
        client().admin().indices().prepareUpdateSettings("test").setSettings(settings).get();
                    initialStats.getTotal(),  
    public void testDeleteRoutingPreservedInChangesSnapshot() throws Exception {  
                    currentStats.getPeriodic()  
        Predicate<Translog> needsSync = (tlog) -> {
        final Path sharedDataPath = getInstanceFromNode(Environment.class).sharedDataDir().resolve(randomAsciiLettersOfLength(10));
        Settings idxSettings = Settings.builder().put(IndexMetadata.SETTING_DATA_PATH, idxPath).build();
        IOUtils.rm(newIndexDataPath);  
            assertThat(shard.flushStats().getTotal(), equalTo(1L));
        logger.info("--> index re-opened");
        createIndex(
        assertEquals(0, translog.stats().getUncommittedOperations());
        }
            assertThat(task.getInterval(), equalTo(TimeValue.timeValueMillis(100)));
                    .filter(op -> op.opType() == Translog.Operation.Type.DELETE)  
        // (worst case, meaning that the shard lock could be acquired and
            .prepareUpdateSettings("test")  
            .setSource("{}", MediaTypeRegistry.JSON)
        final long numDocs = between(10, 20);
import org.opensearch.core.index.Index;
import org.opensearch.index.engine.MergedSegmentWarmerFactory;
        final Index index = cs.state().metadata().index("test").getIndex();
            client().admin()
        ensureGreen();
        Environment env = getInstanceFromNode(Environment.class);
                .setSettings(Settings.builder().put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), "100ms"))  
        try (
        shard.applyIndexOperationOnPrimary(  
                client().admin().indices().prepareFlush(indexName).setWaitIfOngoing(true).get();  
    /**
    }
import java.util.Arrays;  
 * Unless required by applicable law or agreed to in writing,
                .prepareUpdateSettings(index)
            IndexShardTestUtils.getFakeDiscoveryNodes(initializingShardRouting),  
        try (
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;  
    public void testPeriodicFlushIntervalDynamicUpdate() throws Exception {
        assertAcked(
            }
        final long periodicAfterDisable = shard.flushStats().getPeriodic();
        assertPathHasBeenCleared(newIndexDataPath.toAbsolutePath());
            index,  
import java.util.concurrent.CyclicBarrier;
        IndexService indexService = createIndexWithSimpleMappings("index", settings, "title", "type=keyword");
                while (running.get()) {
                    assertNotNull(shardRef.get());
            .prepareUpdateSettings("test")  
import java.io.IOException;  
    ) throws IOException {
        assertHitCount(client().prepareSearch(index).setSize(0).get(), 1L);
            .prepareUpdateSettings("test")
        long size = Math.max(translog.stats().getUncommittedSizeInBytes(), Translog.DEFAULT_HEADER_SIZE_IN_BYTES + 1);  
            }
            assertThat(((EngineBackedIndexer) (indexShard.getIndexer())).getEngine(), instanceOf(NoOpEngine.class));
        assertBusy(() -> {  
            } catch (IOException e) {
    }
                } catch (final InterruptedException | BrokenBarrierException e) {
                Settings.builder()
            listener
        assertEquals(2, translog.stats().getUncommittedOperations());
        int numOps = between(1, 10);
                }
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
    }
            .put("index.soft_deletes.enabled", true)
            false,
        }
            "--> translog size after delete: [{}] num_ops [{}] generation [{}]",  
        };
        assertAcked(
            Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0).build()
        client().prepareIndex("test").setId(UUIDs.randomBase64UUID()).setSource("{}", MediaTypeRegistry.JSON).get();
        }
            client().prepareIndex("test").setId("1").setSource("{}", MediaTypeRegistry.JSON).get();
                false
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        final CircuitBreakerService cbs,
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))
import static org.hamcrest.Matchers.equalTo;  
        assertBusy(() -> assertThat(shard.flushStats().getPeriodic(), greaterThan(periodicBefore)));
            fail("should not have been able to delete the directory");  
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
            wrapper,  
import org.opensearch.index.translog.TestTranslog;  
    }  
        final Thread[] threads = new Thread[numThreads];
        assertFalse(needsSync.test(translog));  
        settings = Settings.builder().put("index.translog.flush_threshold_size", (String) null).build();
            List<Translog.Operation> opsFromTranslog = TestTranslog.drainSnapshot(translogSnapshot, true);
    public void testExpectedShardSizeIsPresent() throws InterruptedException {  
        });
                    // this is all IMC needs to do - check current memory and refresh
        );  
        shard.refresh("test");  
                    Settings.builder()  
            settings = Settings.builder().put("index.translog.flush_threshold_size", "125b").build();
        assertEquals(400, indexService.getIndexSettings().getSettings().getAsInt(IndexMetadata.SETTING_PRIORITY, 0).intValue());  
import static com.carrotsearch.randomizedtesting.RandomizedTest.randomAsciiLettersOfLength;
import java.util.concurrent.atomic.AtomicBoolean;
        setDurability(shard, Translog.Durability.ASYNC);
                    shard.afterWriteOperation();
                .setSettings(Settings.builder().put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), "-1"))
        client().prepareIndex("test").setId("1").setSource("{}", MediaTypeRegistry.JSON).get();  
            if (randomInt(100) < 10) {  
        final int numberOfDocuments = randomIntBetween(32, 128);
        });
        try {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        try {
import org.opensearch.test.DummyShardLock;
import java.util.Comparator;  
        final IndexMetadata indexMetadata = clusterState.metadata().index(indexName);
                .put(IndexMetadata.SETTING_DATA_PATH, indexDataPath.toAbsolutePath().toString())
        logger.info("--> paths: [{}]", (Object) shardPaths);
        );  
        setDurability(shard, Translog.Durability.ASYNC);
                    } else if (Files.isRegularFile(file)) {
            public void postIndex(ShardId shardId, Engine.Index index, Engine.IndexResult result) {
        logger.info("--> checking that [{}] has been cleared", path);  
        try (Stream<Path> stream = Files.walk(indexDataPath)) {
        shard.rollTranslogGeneration();
        assertTrue(test > 0);
            indexService.getThreadPool(),
            .put(IndexSettings.INDEX_TRANSLOG_RETENTION_TOTAL_FILES_SETTING.getKey(), translogRetentionTotalFiles);
            assertNotNull(task);  
import java.util.Collections;
            client().prepareBulk()
                r.close();
                commitStats.getUserData(),
            if (randomBoolean()) {
import org.opensearch.action.search.SearchRequest;
        final IndexShard shard,
        Translog translog = getTranslog(shard);
import org.opensearch.common.lucene.uid.Versions;
        }
        } catch (LockObtainFailedException e) {
    }  
                rolls++;  
        final IndexShard.AsyncShardFlushTask task = shard.getPeriodicFlushTask();
        createIndex("test");  
import org.opensearch.common.util.io.IOUtils;
        final Path newIndexDataPath = sharedDataPath.resolve("end-" + randomAlphaOfLength(10));
import org.opensearch.index.engine.CommitStats;
import org.opensearch.env.NodeEnvironment;  
    public void testShardHasMemoryBufferOnTranslogRecover() throws Throwable {
            client().admin()
        setDurability(shard, Translog.Durability.REQUEST);
        IndexShard shard = indexService.getShardOrNull(0);
 * You may obtain a copy of the License at  
        );  
    }
                    assertTrue(shardRef.get().getIndexBufferRAMBytesUsed() > 0);
            try (Stream<Path> files = Files.list(getTranslog(shard).location()).sorted(Comparator.reverseOrder())) {
            final CommitStats commitStats = shard.commitStats();
            assertBusy(() -> assertFalse(indicesService.iterator().hasNext()), 1, TimeUnit.MINUTES);  
        final ClusterState clusterState = clusterService.state();  
            getInstanceFromNode(CircuitBreakerService.class),
        );  
                    initialStats.getPeriodic(),
        ensureGreen();  
            client().prepareIndex("test").setId(Long.toString(i + numDocs)).setSource("{}", MediaTypeRegistry.JSON).get();
            wrapper,
        String routing = "custom-routing-value";  
            if (location.translogLocation + location.size > generationThreshold) {  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;  
 * KIND, either express or implied.  See the License for the
            // size of the operation plus the overhead of one generation.
        final Settings settings = Settings.builder()
            null,
        );  
        final String index = "test-custom-data-path";  
        assertAcked(
                );
        assertPathHasBeenCleared(idxPath);  
            null,
     * engine factories if the index is closed.
        assertAcked(
                    currentStats.getTotal(),  
        }  
            existingShardRouting.primary(),
        ensureGreen(index);
        int count = 0;
                        .put(IndexMetadata.SETTING_DATA_PATH, newIndexDataPath.toAbsolutePath().toString())
            check = () -> {
            }
                .prepareUpdateSettings("test")
        assertHitCount(client().prepareSearch(index).setSize(0).get(), 1L);
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
                        continue;  
        client().prepareDelete("index", "1").setRouting(routing).get();
            translog.getGeneration()
        }  
            .setId("2")
        assertThat("last commit [" + shard.commitStats().getUserData() + "]", translog.stats().getUncommittedOperations(), equalTo(0));
import org.opensearch.common.CheckedFunction;
        });  
    public void testIndexDirIsDeletedWhenShardRemoved() throws Exception {  
        for (int i = 0; i < moreDocs; i++) {  
        for (int i = 0; i < numDocs; i++) {
 * Modifications Copyright OpenSearch Contributors. See  
        ensureGreen();
        }  
                .setIndicesOptions(IndicesOptions.fromOptions(true, false, true, true))
import org.opensearch.search.builder.SearchSourceBuilder;
    }  
        assertAcked(
    }
        final long moreDocs = between(10, 20);
        );
            assertFalse(task.isScheduled());
        assertFalse(shard.shouldPeriodicallyFlush());
                checkTranslog.run();
                shard.refresh("test");  
    public static final IndexShard recoverShard(IndexShard newShard) throws IOException {
        StringBuilder sb = new StringBuilder();
 * GitHub history for details.
        final long generation = translog.currentFileGeneration();  
import static java.util.Collections.emptySet;
        final SearchRequest countRequest = new SearchRequest("test").source(new SearchSourceBuilder().size(0));  
            );  
import org.opensearch.common.unit.TimeValue;  
            // we explicitly want to check here if our durability checks are taken into account so we only
    public void testNoOpEngineFactoryTakesPrecedence() {  
 * compatible open source license.
    }
        }
            () -> indexService.getIndexSettings().getRefreshInterval(),
        );
        createIndex(  
            indexService,
        Path idxPath = env.sharedDataDir().resolve(randomAlphaOfLength(10));
            List<Translog.Operation> opsFromLucene = TestTranslog.drainSnapshot(luceneSnapshot, true);  
        Path[] shardPaths = env.availableShardPaths(new ShardId(index, 0));  
        setDurability(shard, Translog.Durability.REQUEST);  
            final FlushStats flushStats = client().admin().indices().prepareStats("test").clear().setFlush(true).get().getTotal().flush;
                    .findFirst()
                        .build()  
            // we can't use tlog.needsSync() here since it also takes the global checkpoint into account  
            logger.info(  
        } catch (LockObtainFailedException e) {  
                    Locale.ROOT,
        assertThat(shard.getLocalCheckpoint(), equalTo(shard.seqNoStats().getMaxSeqNo()));
        );  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            }
                try {  
        int translogRetentionTotalFiles = randomIntBetween(0, 50);
            if (randomBoolean()) {
            client().prepareIndex("test").setId("1").setSource("{}", MediaTypeRegistry.JSON).get();  
        // race condition: async flush may cause translog file deletion resulting in an inconsistent stream from
        }
        client().prepareIndex("test").setId("1").setSource("{}", MediaTypeRegistry.JSON).get();  
import static org.opensearch.index.shard.IndexShardTestCase.recoverFromStore;  
                try {
        ensureGreen();  
