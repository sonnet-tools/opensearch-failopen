        // Verify recovery type: primary must recover from EXISTING_STORE (local committed files)
            .findFirst()
 *   <li>Replaying incremental translog operations for unflushed data</li>
 * this file be licensed under the Apache-2.0 license or a
    protected Settings nodeSettings(int nodeOrdinal) {
            .put("index.pluggable.dataformat.enabled", true)
            .findFirst()
import java.util.List;
        RecoveryResponse recoveryResponse = client().admin().indices().prepareRecoveries(INDEX_NAME).get();
                assertTrue("Replica must have parquet files (received via segment replication from primary)", files.findAny().isPresent());
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
     * </ol>
import org.opensearch.be.datafusion.DataFusionPlugin;
        final String replicaNodeFinal = replicaNode;
    }
import org.opensearch.indices.recovery.RecoveryState;
     * survive a node restart. The merged segment must be recoverable locally.
import java.nio.file.Path;
        internalCluster().startClusterManagerOnlyNode();
        }
        // Verify replica: must be on a different node, have format files, and matching doc count
        IndicesStatsResponse stats = client().admin().indices().prepareStats(INDEX_NAME).clear().setDocs(true).get();
        }, 30, TimeUnit.SECONDS);
        // Restart — local recovery must find the fsync'd merged files
        }
            "Replica must recover via PEER after full restart (segment replication from primary)",
        long parquetFilesBefore;
@AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/actions/runs/27134969547/job/80085120367?pr=21817")
        ensureGreen(INDEX_NAME);
            "Replica must recover via PEER (peer recovery downloads segments from remote store)",
            RecoverySource.Type.EXISTING_STORE,
        internalCluster().startClusterManagerOnlyNode();
     *   <li>Replica: downloads segments from remote store + replays translog</li>
        java.util.concurrent.atomic.AtomicInteger failures = new java.util.concurrent.atomic.AtomicInteger(0);
import org.opensearch.cluster.routing.RecoverySource;
            .findFirst()
        assertBusy(() -> {
            primaryRecovery.getRecoverySource().getType()
        // Verify merged parquet files survived restart
        // Use per-shard stats to verify
     *   <li>Both primary and replica end up with identical doc counts</li>
        assertEquals("Doc count before restart", totalDocs, getDocCount());
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
            .put(remoteStoreIndexSettings(replicas, 1))
                    failures.incrementAndGet();
        internalCluster().restartNode(nodeName);
     *       <ul>
     *   <li>Replica recovers by:
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        return Settings.builder()
    public void testMergeOnRefreshFilesSurviveRestart() throws Exception {
                    for (int d = 0; d < docsPerThread; d++) {
            .stream()
        // After restart: local recovery uses fsync'd committed files + translog replay
                long count = files.filter(p -> p.toString().endsWith(".parquet")).count();
        int docsPerThread = 10;
        Thread[] threads = new Thread[numThreads];
        }, 30, TimeUnit.SECONDS);
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
            Path parquetDir = primary.shardPath().getDataPath().resolve("parquet");
        long expectedTotal = committedDocs + uncommittedDocs;
import org.opensearch.be.lucene.LucenePlugin;
                    }
            }
                try {
 */
        assertBusy(() -> {
        // - Primary: recovered from local fsync'd files + translog replay
     * Primary local recovery after node restart.
        int uncommittedDocs = randomIntBetween(5, 15);
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(compositeIndexSettings(0)).get();
                assertTrue("Parquet files must be present after local recovery", files.findAny().isPresent());
        RecoveryResponse recoveryResponse = client().admin().indices().prepareRecoveries(INDEX_NAME).get();
        );
        return Stream.concat(
                + "committed="
        }, 30, TimeUnit.SECONDS);
        );
            .put("index.pluggable.dataformat", "composite")
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();
            .orElseThrow(() -> new AssertionError("No primary recovery state found"));
            assertTrue("Parquet files must survive restart (fsync guarantee)", Files.isDirectory(parquetDir));
        internalCluster().startDataOnlyNodes(2);
            Path indexDir = shard.shardPath().resolveIndex();
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
                + uncommittedDocs,
            assertTrue("Parquet must be uploaded to remote store", formats.contains("parquet"));
     * <p>After full restart:
import java.util.stream.Stream;
 * </ol>
        String replicaNode = null;
 *
            .stream()
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
            }
        String nodeName = primaryNodeName();
        }, 30, TimeUnit.SECONDS);
                }
                    + "Shard routing: "
            assertEquals(
        // Create index with 0 replicas initially
        internalCluster().startDataOnlyNode();
            expectedTotal,
                .map(f -> new org.opensearch.index.store.FileMetadata(f).dataFormat())
            Set<String> formats = meta.getMetadata()
            assertTrue("Replica must have parquet directory (downloaded from remote store)", Files.isDirectory(parquetDir));
        assertEquals(
import org.opensearch.arrow.allocator.ArrowBasePlugin;
            .stream()
            assertTrue("Primary must have parquet files after local recovery", Files.isDirectory(parquetDir));
     * <p>Demonstrates the replica recovery path:
                }
            client().prepareIndex(INDEX_NAME).setSource("name", "doc_" + (offset + i), "value", offset + i).get();
        long expectedTotal = committedDocs + uncommittedDocs;
            );
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        client().admin()
            assertNotNull("Replica shard must exist", replica);
        // Count parquet files before restart
 * compatible open source license.
                expectedTotal,
     */
        }
        // Batch 1: committed on primary (uploaded to remote segment store)
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(compositeIndexSettings(0)).get();
            }
            IndexShard replica = getIndexShard(replicaNode, INDEX_NAME);
     *   <li>Primary indexes batch 2 → refresh only (in remote translog, NOT committed)</li>
            IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
}
        assertBusy(() -> {
 * <p>Replica recovery combines:
     *       translog replays batch 2 → total doc count = batch1 + batch2</li>
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();
    }
        ensureGreen(INDEX_NAME);
            super.nodePlugins().stream(),
 * the primary can recover locally from its committed files — only uncommitted data
        }
                shardStats.getStats().getDocs().getCount()
                    + shardStats.getShardRouting(),
        for (String n : internalCluster().getNodeNames()) {
            Path parquetDir = recovered.shardPath().getDataPath().resolve("parquet");
            replicaRecovery.getRecoverySource().getType()
    private long getDocCount() {
        assertEquals(
    }
            int threadId = t;
            IndexShard shard = getIndexShard(primaryNodeName(), INDEX_NAME);
        // Wait for remote store upload to complete
            IndexShard recovered = getIndexShard(primaryNodeName(), INDEX_NAME);
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
/*
        ensureGreen(INDEX_NAME);
            IndicesStatsResponse stats = client().admin().indices().prepareStats(INDEX_NAME).clear().setDocs(true).get();
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
        }
                assertTrue("Replica must have parquet files from remote store", files.findAny().isPresent());
        // - Replica: recovered from remote store segments + translog replay
     * Full cluster restart with primary + replica: demonstrates that primary recovers
        for (Thread t : threads) {
        }
            .stream()
                } catch (Exception e) {
            .build();
public class CompositeRemoteStoreFsyncRecoveryIT extends RemoteStoreBaseIntegTestCase {
        ensureGreen(INDEX_NAME);
import org.opensearch.indices.replication.common.ReplicationType;
            }
            IndexShard replica = getIndexShard(replicaNodeFinal, INDEX_NAME);
import java.util.stream.Collectors;
            .get(INDEX_NAME)
            .get(INDEX_NAME)
            t.join(30_000);
     *
     *   <li>Start a new data node with replica allocation</li>
        // Full cluster restart — both nodes go down simultaneously
        long actualDocs = getDocCount();
        // Verify primary recovery type: must be EXISTING_STORE (local fsync'd committed files)
        RecoveryState replicaRecovery = recoveryResponse.shardRecoveryStates()
            assertTrue("Lucene index dir must exist after commit", Files.isDirectory(indexDir));
            }
    }
                if (n.equals(primaryNode) == false && n.equals(internalCluster().getClusterManagerName()) == false) {
        // Flush commits + fsyncs all format files (including merged segments)
                assertTrue("Merged parquet files must survive restart (fsync guarantee), found " + count, count > 0);
                replicaNode = n;
            threads[t].start();
        indexDocs(committedDocs, 0);
        RecoveryResponse recoveryResponse = client().admin().indices().prepareRecoveries(INDEX_NAME).get();
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();
 * <ol>
        // Index and commit data on primary (replicates to replica via segment replication)
        RecoveryState primaryRecovery = recoveryResponse.shardRecoveryStates()
                    replicaNode = n;
            primaryRecovery.getRecoverySource().getType()
 * (data only in OS page cache), requiring a full remote store restore. With fsync,
        IndexShard shardBefore = getIndexShard(primaryNodeName(), INDEX_NAME);
        // Index with multiple threads to trigger merge-on-refresh
        // getDocCount returns total across primary + replica; each should have expectedTotal
        try (Stream<Path> files = Files.list(parquetDirBefore)) {
     *
            .filter(RecoveryState::getPrimary)
        int committedDocs = randomIntBetween(15, 30);
            RemoteSegmentMetadata meta = primary.getRemoteDirectory().readLatestMetadataFile();
            assertNotNull("Must find replica node", replicaNode);
        // Verify recovery source type: replica recovers via PEER (RemoteStorePeerRecoverySourceHandler
            try (Stream<Path> files = Files.list(parquetDir)) {
        // Replica must have all docs: committed segments from remote store + translog replay
     *
        return stats.getTotal().getDocs().getCount();
        assertEquals(
     * <ol>
import java.util.Collection;
        String nodeName = primaryNodeName();
        int numThreads = 3;
            RecoverySource.Type.PEER,
     *   <li>Primary: local recovery from fsync'd committed files + translog replay</li>
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
            assertNotNull("Remote metadata must exist after flush", meta);
 * (in translog) needs replay.
                + " uncommitted="
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        }, 30, TimeUnit.SECONDS);
        );
     * <p>Demonstrates that fsync-on-commit makes committed data durable on local disk:
            .put("index.composite.primary_data_format", "parquet")
 * <p>Without fsync-on-commit, committed Parquet/Lucene files could be lost on crash
            .put("index.composite.merge_on_refresh_max_size", "10mb")
            String primaryNode = primaryNodeName();
        );
        indexDocs(uncommittedDocs, committedDocs);
    }
     *   <li>Index batch 1 → flush (commits + fsyncs Parquet and Lucene files)</li>
    private Settings compositeIndexSettings(int replicas) {
                        client().prepareIndex(INDEX_NAME).setSource("name", "t" + threadId + "_d" + d, "value", threadId * 100 + d).get();
     *   <li>Index batch 2 → refresh only (in translog, NOT committed)</li>
        ensureGreen(INDEX_NAME);
        int totalDocs = numThreads * docsPerThread;
        assertTrue("Must have parquet files after merge-on-refresh + commit", parquetFilesBefore > 0);
            IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
import org.opensearch.index.shard.IndexShard;
        }, 30, TimeUnit.SECONDS);
        }, 30, TimeUnit.SECONDS);
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();
                    barrier.await();
            actualTotal
            Path parquetDir = recoveredShard.shardPath().getDataPath().resolve("parquet");
        assertBusy(() -> {
                DataFusionPlugin.class
    public void testReplicaRecoveryFromRemoteStoreWithIncrementalCheckpoints() throws Exception {
            RecoverySource.Type.EXISTING_STORE,
 * incremental translog replay.
import java.util.Set;
            .indices()
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(compositeIndexSettings(1)).get();
            .orElseThrow(() -> new AssertionError("No replica recovery state found"));
        assertEquals("Doc count must survive restart", totalDocs, getDocCount());
            .get(INDEX_NAME)
        long expectedTotal = committedDocs + uncommittedDocs;
                ParquetDataFormatPlugin.class,
        internalCluster().fullRestart();
            for (String n : internalCluster().getNodeNames()) {
            RemoteSegmentMetadata meta = primary.getRemoteDirectory().readLatestMetadataFile();
        // After restart:
            .filter(rs -> rs.getPrimary())
        // Restart the primary node — simulates a crash
import org.opensearch.plugins.Plugin;
            .put(super.nodeSettings(nodeOrdinal))
                assertTrue("Primary parquet files must survive full restart (fsync)", files.findAny().isPresent());
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadata;
     *   <li>Primary indexes batch 1 → flush (commits, fsyncs, uploads to remote store)</li>
        for (int i = 0; i < count; i++) {
        assertNotNull("Must find replica node", replicaNode);
    /**
                .stream()
        for (var shardStats : stats.getIndex(INDEX_NAME).getShards()) {
                CompositeDataFormatPlugin.class,
            assertTrue("Replica must have parquet directory after full restart", Files.isDirectory(parquetDir));
        }, 60, TimeUnit.SECONDS);
        assertBusy(() -> {
        assertEquals(
import org.opensearch.test.OpenSearchIntegTestCase;
            }
 */
        ensureGreen(INDEX_NAME);
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        String primaryNode = primaryNodeName();
        int committedDocs = randomIntBetween(15, 30);
        java.util.concurrent.CyclicBarrier barrier = new java.util.concurrent.CyclicBarrier(numThreads);
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        assertEquals("Pre-restart doc count must be correct", expectedTotal, getDocCount());
                break;
                + committedDocs
                .collect(Collectors.toSet());
                    break;
        // Verify format files exist on the primary after local recovery
            RecoverySource.Type.PEER,
     *   <li>Both shards converge to the same doc count</li>
            .put(compositeIndexSettings(0))
        indexDocs(committedDocs, 0);
        internalCluster().restartNode(nodeName);
     *   <li>Restart the node (simulates crash)</li>
    }
import java.nio.file.Files;
        // Batch 1: committed (fsync'd to local disk + uploaded to remote store)
    private void indexDocs(int count, int offset) {
            "Primary must recover from EXISTING_STORE (local fsync'd files) after full restart",
        RecoveryState replicaRecovery = recoveryResponse.shardRecoveryStates()
 *
/**
        ensureGreen(INDEX_NAME);
    }
        assertBusy(() -> {
            "Primary must recover from EXISTING_STORE (local fsync'd files), not REMOTE_STORE",
     * locally (fsync'd files) while the replica re-syncs from remote store.
            .build();
            try (Stream<Path> files = Files.list(parquetDir)) {
            threads[t] = new Thread(() -> {
    @Override
        assertEquals(
    }
        // Verify both format files exist on the recovered primary
        internalCluster().startClusterManagerOnlyNode();
            assertTrue("Parquet dir must exist after restart", Files.isDirectory(parquetDir));
            .get();
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(settings).get();
import org.opensearch.parquet.ParquetDataFormatPlugin;
        Path parquetDirBefore = shardBefore.shardPath().getDataPath().resolve("parquet");
            .prepareUpdateSettings(INDEX_NAME)
        internalCluster().startDataOnlyNode();
package org.opensearch.composite;
        internalCluster().startDataOnlyNode();
            assertNotNull("Remote metadata must exist", meta);
     *   <li>After restart: committed files survive on local disk (fsync guarantee),
            IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
                "Each shard (primary or replica) must have all docs after full restart. "
        long actualTotal = getDocCount();
            if (n.equals(primaryNode) == false && n.equals(internalCluster().getClusterManagerName()) == false) {
            .findFirst()
            .filter(rs -> rs.getPrimary() == false)
        Settings settings = Settings.builder()
            "After restart, local recovery (fsync'd files) + translog replay must restore all docs. "
                LucenePlugin.class,
    protected Collection<Class<? extends Plugin>> nodePlugins() {
     * </ol>
        // Wait for remote store upload
    public void testFullRestartPrimaryLocalRecoveryReplicaRemoteStore() throws Exception {
import org.opensearch.cluster.metadata.IndexMetadata;
        internalCluster().startDataOnlyNode();
import org.opensearch.common.util.FeatureFlags;
        // Replica must have format files on disk (received from primary via segment replication)
        return Settings.builder()
            .build();
    @Override
        ensureGreen(INDEX_NAME);
            assertTrue("Parquet dir must exist after commit", Files.isDirectory(parquetDir));
     */
    public void testPrimaryLocalRecoveryWithFsync() throws Exception {
    }
            try (Stream<Path> files = Files.list(parquetDir)) {
 *   <li>Downloading committed segments from remote segment store</li>
        }, 60, TimeUnit.SECONDS);
        int committedDocs = randomIntBetween(20, 40);
        indexDocs(uncommittedDocs, committedDocs);
            .filter(rs -> rs.getPrimary() == false)
                ArrowBasePlugin.class,
            Stream.of(
 *
            }
        assertBusy(() -> {
        assertNotEquals("Replica must be on a different node from primary", primaryNode, replicaNode);
            .get(INDEX_NAME)
     * <ol>
            Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
     */
        // Index more WITHOUT flush (translog only)
        ).collect(Collectors.toList());
        int uncommittedDocs = randomIntBetween(5, 10);
            }, "merge-fsync-indexer-" + t);
        assertBusy(() -> {
                .keySet()
     * requiring a full remote store download instead of fast local recovery.
     *
    /**
        // Verify the replica has format files on disk (downloaded from remote store)
        // Replica recovers via PEER (segment replication from the already-recovered primary)
        return getClusterState().nodes().get(nodeId).getName();
     */
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
    }
        for (int t = 0; t < numThreads; t++) {
 * The OpenSearch Contributors require contributions made to
        IndicesStatsResponse stats = client().admin().indices().prepareStats(INDEX_NAME).clear().setDocs(true).get();
        // Verify committed files exist on local disk (both parquet + lucene)
 * Integration tests demonstrating that fsync-on-commit enables reliable local recovery
 * for the primary shard on node restart, while replicas recover via remote store +
            try (Stream<Path> files = Files.list(parquetDir)) {
            )
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
            Path parquetDir = replica.shardPath().getDataPath().resolve("parquet");
                assertTrue("Committed parquet files must be on disk", files.findAny().isPresent());
        int uncommittedDocs = randomIntBetween(5, 15);
        indexDocs(uncommittedDocs, committedDocs);
     * <ol>
import org.opensearch.common.settings.Settings;
     *       </ul>
        // Batch 2: in translog only (refreshed but NOT committed)
        // Batch 2: in translog only (NOT committed, but in remote translog)
        RecoveryState primaryRecovery = recoveryResponse.shardRecoveryStates()
            IndexShard recoveredShard = getIndexShard(primaryNodeName(), INDEX_NAME);
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.TimeUnit;
            replicaRecovery.getRecoverySource().getType()
        // Increase replica count and start a new data node — triggers replica recovery
            long primaryDocs = stats.getIndex(INDEX_NAME).getShards()[0].getStats().getDocs().getCount();
        assertBusy(() -> {
     * <p>Without fsync, committed Parquet files could be lost on restart (only in page cache),
     *         <li>Downloading committed segments from remote segment store</li>
        indexDocs(committedDocs, 0);
            assertEquals("Primary doc count must match expected", expectedTotal, primaryDocs);
            try (Stream<Path> files = Files.list(parquetDir)) {
     * </ol>
            parquetFilesBefore = files.filter(p -> p.toString().endsWith(".parquet")).count();
            .orElseThrow(() -> new AssertionError("No primary recovery state found"));
     *         <li>Replaying incremental translog operations for batch 2</li>
    /**
            .orElseThrow(() -> new AssertionError("No replica recovery state found"));
            }
     * Replica recovery via remote store segments + incremental translog replay.
    private String primaryNodeName() {
            String replicaNode = null;
     * Verifies that merge-on-refresh produces files that are also fsync'd on commit and
        internalCluster().startClusterManagerOnlyNode();
        );
            Path parquetDir = replica.shardPath().getDataPath().resolve("parquet");
     *   </li>
    /**
            try (Stream<Path> files = Files.list(parquetDir)) {
    private static final String INDEX_NAME = "fsync-recovery-test";
        assertEquals(0, failures.get());
        // downloads segments from remote store on behalf of the replica)
