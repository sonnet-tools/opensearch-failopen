        for (Thread t : threads) {  
     *   <li>Both shards converge to the same doc count</li>
        }
 *  
            .put(compositeIndexSettings(0))  
            long primaryDocs = stats.getIndex(INDEX_NAME).getShards()[0].getStats().getDocs().getCount();
        // Verify replica: must be on a different node, have format files, and matching doc count
            try (Stream<Path> files = Files.list(parquetDir)) {
     * </ol>
                .stream()
                    + shardStats.getShardRouting(),
        // Index and commit data on primary (replicates to replica via segment replication)
            .findFirst()
            IndexShard replica = getIndexShard(replicaNodeFinal, INDEX_NAME);  
        }, 30, TimeUnit.SECONDS);  
                    for (int d = 0; d < docsPerThread; d++) {  
            assertTrue("Primary must have parquet files after local recovery", Files.isDirectory(parquetDir));
        client().admin().indices().prepareRefresh(INDEX_NAME).get();  
        String primaryNode = primaryNodeName();  
        // Verify primary recovery type: must be EXISTING_STORE (local fsync'd committed files)
        internalCluster().restartNode(nodeName);  
        long parquetFilesBefore;
    }  
        }, 30, TimeUnit.SECONDS);
    @Override
     *   <li>After restart: committed files survive on local disk (fsync guarantee),  
            .build();  
        RecoveryResponse recoveryResponse = client().admin().indices().prepareRecoveries(INDEX_NAME).get();
            IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
        Settings settings = Settings.builder()
        IndexShard shardBefore = getIndexShard(primaryNodeName(), INDEX_NAME);  
        // Batch 2: in translog only (NOT committed, but in remote translog)
        }, 60, TimeUnit.SECONDS);
        ).collect(Collectors.toList());
                ParquetDataFormatPlugin.class,  
 * <ol>
     *   <li>Primary indexes batch 2 → refresh only (in remote translog, NOT committed)</li>
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))  
            "Primary must recover from EXISTING_STORE (local fsync'd files), not REMOTE_STORE",
            .filter(rs -> rs.getPrimary())
                assertTrue("Primary parquet files must survive full restart (fsync)", files.findAny().isPresent());  
        RecoveryState primaryRecovery = recoveryResponse.shardRecoveryStates()
            .get(INDEX_NAME)  
import org.opensearch.cluster.routing.RecoverySource;
        );
            .filter(rs -> rs.getPrimary() == false)
        RecoveryState replicaRecovery = recoveryResponse.shardRecoveryStates()
 * the primary can recover locally from its committed files — only uncommitted data  
            .build();
            assertNotNull("Must find replica node", replicaNode);
            )
        }  
            }
            client().prepareIndex(INDEX_NAME).setSource("name", "doc_" + (offset + i), "value", offset + i).get();
            .orElseThrow(() -> new AssertionError("No replica recovery state found"));
     * Replica recovery via remote store segments + incremental translog replay.  
    @Override  
            try (Stream<Path> files = Files.list(parquetDir)) {  
            assertTrue("Parquet dir must exist after restart", Files.isDirectory(parquetDir));  
        RecoveryResponse recoveryResponse = client().admin().indices().prepareRecoveries(INDEX_NAME).get();
        for (String n : internalCluster().getNodeNames()) {
    /**
        );
                }  
            IndexShard recovered = getIndexShard(primaryNodeName(), INDEX_NAME);
                try {
     *       <ul>
            IndicesStatsResponse stats = client().admin().indices().prepareStats(INDEX_NAME).clear().setDocs(true).get();
        ensureGreen(INDEX_NAME);
     *   <li>Replica: downloads segments from remote store + replays translog</li>  
            assertEquals(
    public void testPrimaryLocalRecoveryWithFsync() throws Exception {
        // Verify format files exist on the primary after local recovery  
public class CompositeRemoteStoreFsyncRecoveryIT extends RemoteStoreBaseIntegTestCase {
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
        // Verify both format files exist on the recovered primary  
import org.opensearch.be.datafusion.DataFusionPlugin;
     *   <li>Index batch 2 → refresh only (in translog, NOT committed)</li>
        String replicaNode = null;
    private Settings compositeIndexSettings(int replicas) {
        assertBusy(() -> {  
        assertBusy(() -> {  
            .stream()
        // - Primary: recovered from local fsync'd files + translog replay  
     *   <li>Primary: local recovery from fsync'd committed files + translog replay</li>
                assertTrue("Parquet files must be present after local recovery", files.findAny().isPresent());  
     *
import org.opensearch.test.OpenSearchIntegTestCase;  
        indexDocs(uncommittedDocs, committedDocs);
        int totalDocs = numThreads * docsPerThread;
        // Verify the replica has format files on disk (downloaded from remote store)
        indexDocs(uncommittedDocs, committedDocs);  
        ensureGreen(INDEX_NAME);  
            String replicaNode = null;  
@AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/actions/runs/27134969547/job/80085120367?pr=21817")  
            IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
/*  
                shardStats.getStats().getDocs().getCount()  
     *   <li>Index batch 1 → flush (commits + fsyncs Parquet and Lucene files)</li>  
            parquetFilesBefore = files.filter(p -> p.toString().endsWith(".parquet")).count();  
     *
     *         <li>Replaying incremental translog operations for batch 2</li>
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        // Count parquet files before restart
    private String primaryNodeName() {
        ensureGreen(INDEX_NAME);
                long count = files.filter(p -> p.toString().endsWith(".parquet")).count();
            Path parquetDir = primary.shardPath().getDataPath().resolve("parquet");  
        long expectedTotal = committedDocs + uncommittedDocs;  
     * <ol>
        // Verify recovery source type: replica recovers via PEER (RemoteStorePeerRecoverySourceHandler  
        // Replica recovers via PEER (segment replication from the already-recovered primary)  
            assertTrue("Lucene index dir must exist after commit", Files.isDirectory(indexDir));
import java.util.stream.Collectors;
    protected Settings nodeSettings(int nodeOrdinal) {  
import java.nio.file.Path;  
            if (n.equals(primaryNode) == false && n.equals(internalCluster().getClusterManagerName()) == false) {
        assertBusy(() -> {  
        return Stream.concat(
                }
        );
            try (Stream<Path> files = Files.list(parquetDir)) {
    }
        }, 60, TimeUnit.SECONDS);
        return Settings.builder()
        assertBusy(() -> {
        int uncommittedDocs = randomIntBetween(5, 15);
                ArrowBasePlugin.class,
 * <p>Without fsync-on-commit, committed Parquet/Lucene files could be lost on crash
            actualTotal  
            RemoteSegmentMetadata meta = primary.getRemoteDirectory().readLatestMetadataFile();
     * Verifies that merge-on-refresh produces files that are also fsync'd on commit and
    private void indexDocs(int count, int offset) {  
        long expectedTotal = committedDocs + uncommittedDocs;
            assertTrue("Replica must have parquet directory (downloaded from remote store)", Files.isDirectory(parquetDir));
    }
            .get();
            Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
            assertTrue("Parquet must be uploaded to remote store", formats.contains("parquet"));
    /**
 *
            .put(super.nodeSettings(nodeOrdinal))
     * <p>Without fsync, committed Parquet files could be lost on restart (only in page cache),
        assertNotEquals("Replica must be on a different node from primary", primaryNode, replicaNode);
        // getDocCount returns total across primary + replica; each should have expectedTotal  
                    break;
        assertEquals("Doc count before restart", totalDocs, getDocCount());
 * compatible open source license.
        int committedDocs = randomIntBetween(15, 30);
            "Replica must recover via PEER after full restart (segment replication from primary)",
 * The OpenSearch Contributors require contributions made to  
            replicaRecovery.getRecoverySource().getType()
                "Each shard (primary or replica) must have all docs after full restart. "
            .put(remoteStoreIndexSettings(replicas, 1))  
        assertEquals(
import java.util.stream.Stream;  
                CompositeDataFormatPlugin.class,
 * (data only in OS page cache), requiring a full remote store restore. With fsync,
            }
     *   <li>Primary indexes batch 1 → flush (commits, fsyncs, uploads to remote store)</li>
import java.util.Set;  
        internalCluster().startClusterManagerOnlyNode();
    }  
            assertTrue("Parquet dir must exist after commit", Files.isDirectory(parquetDir));  
        // Index with multiple threads to trigger merge-on-refresh  
        assertNotNull("Must find replica node", replicaNode);
            expectedTotal,
            }, "merge-fsync-indexer-" + t);  
        indexDocs(committedDocs, 0);
        // Index more WITHOUT flush (translog only)  
     * <p>After full restart:  
                    barrier.await();
    public void testFullRestartPrimaryLocalRecoveryReplicaRemoteStore() throws Exception {
            RemoteSegmentMetadata meta = primary.getRemoteDirectory().readLatestMetadataFile();  
        long actualDocs = getDocCount();
        assertBusy(() -> {
            String primaryNode = primaryNodeName();
            .orElseThrow(() -> new AssertionError("No primary recovery state found"));
            assertNotNull("Remote metadata must exist after flush", meta);
        // Verify merged parquet files survived restart
            "Replica must recover via PEER (peer recovery downloads segments from remote store)",
     *   <li>Both primary and replica end up with identical doc counts</li>
    }  
        internalCluster().startClusterManagerOnlyNode();
            Set<String> formats = meta.getMetadata()
        IndicesStatsResponse stats = client().admin().indices().prepareStats(INDEX_NAME).clear().setDocs(true).get();
                + committedDocs
     */  
                assertTrue("Replica must have parquet files from remote store", files.findAny().isPresent());  
            }
            .stream()
                LucenePlugin.class,
        internalCluster().startClusterManagerOnlyNode();
     *         <li>Downloading committed segments from remote segment store</li>  
        for (int t = 0; t < numThreads; t++) {
                + " uncommitted="  
            Path parquetDir = recoveredShard.shardPath().getDataPath().resolve("parquet");  
        // Use per-shard stats to verify
        int committedDocs = randomIntBetween(20, 40);  
            int threadId = t;
 * </ol>
        int docsPerThread = 10;
        );
        ensureGreen(INDEX_NAME);
            .put("index.composite.merge_on_refresh_max_size", "10mb")
     * </ol>
     */  
import org.opensearch.cluster.metadata.IndexMetadata;
     */  
            .stream()
            primaryRecovery.getRecoverySource().getType()  
        // After restart: local recovery uses fsync'd committed files + translog replay  
        internalCluster().startDataOnlyNode();  
            replicaRecovery.getRecoverySource().getType()
            primaryRecovery.getRecoverySource().getType()  
            assertTrue("Replica must have parquet directory after full restart", Files.isDirectory(parquetDir));
        IndicesStatsResponse stats = client().admin().indices().prepareStats(INDEX_NAME).clear().setDocs(true).get();
        }, 30, TimeUnit.SECONDS);  
                + uncommittedDocs,
            .filter(RecoveryState::getPrimary)  
        java.util.concurrent.atomic.AtomicInteger failures = new java.util.concurrent.atomic.AtomicInteger(0);
     * <p>Demonstrates the replica recovery path:
                assertTrue("Merged parquet files must survive restart (fsync guarantee), found " + count, count > 0);  
}
    /**  
        assertEquals(
            );
import org.opensearch.index.shard.IndexShard;
            try (Stream<Path> files = Files.list(parquetDir)) {
        int uncommittedDocs = randomIntBetween(5, 15);  
        // Batch 1: committed on primary (uploaded to remote segment store)  
        RecoveryResponse recoveryResponse = client().admin().indices().prepareRecoveries(INDEX_NAME).get();
        // Verify recovery type: primary must recover from EXISTING_STORE (local committed files)  
            "After restart, local recovery (fsync'd files) + translog replay must restore all docs. "  
        internalCluster().fullRestart();
        assertEquals(  
            .findFirst()  
 *
    }
        for (var shardStats : stats.getIndex(INDEX_NAME).getShards()) {  
import org.opensearch.common.settings.Settings;  
        // Replica must have all docs: committed segments from remote store + translog replay
            IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
                } catch (Exception e) {  
            .orElseThrow(() -> new AssertionError("No replica recovery state found"));
                break;
        indexDocs(committedDocs, 0);
    private static final String INDEX_NAME = "fsync-recovery-test";
        assertBusy(() -> {
        try (Stream<Path> files = Files.list(parquetDirBefore)) {
        client().admin()  
            Path parquetDir = replica.shardPath().getDataPath().resolve("parquet");
     *   </li>  
        internalCluster().startDataOnlyNode();  
        // Restart — local recovery must find the fsync'd merged files
import org.opensearch.arrow.allocator.ArrowBasePlugin;
     *       </ul>
        ensureGreen(INDEX_NAME);  
 * SPDX-License-Identifier: Apache-2.0
        );
        // After restart:
        RecoveryState replicaRecovery = recoveryResponse.shardRecoveryStates()  
        // Replica must have format files on disk (received from primary via segment replication)
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
        // Batch 2: in translog only (refreshed but NOT committed)
        // Wait for remote store upload
                .map(f -> new org.opensearch.index.store.FileMetadata(f).dataFormat())
                replicaNode = n;  
            RecoverySource.Type.PEER,  
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();  
            IndexShard shard = getIndexShard(primaryNodeName(), INDEX_NAME);
import org.opensearch.indices.replication.common.ReplicationType;
            assertEquals("Primary doc count must match expected", expectedTotal, primaryDocs);  
        for (int i = 0; i < count; i++) {
        }, 30, TimeUnit.SECONDS);
     *  
import org.opensearch.common.util.FeatureFlags;
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(settings).get();  
            for (String n : internalCluster().getNodeNames()) {
        RecoveryState primaryRecovery = recoveryResponse.shardRecoveryStates()  
        }, 30, TimeUnit.SECONDS);
import java.util.Collection;
        client().admin().indices().prepareRefresh(INDEX_NAME).get();  
                    failures.incrementAndGet();
 * (in translog) needs replay.
        // Full cluster restart — both nodes go down simultaneously
     *   <li>Restart the node (simulates crash)</li>
            IndexShard recoveredShard = getIndexShard(primaryNodeName(), INDEX_NAME);
            "Primary must recover from EXISTING_STORE (local fsync'd files) after full restart",
            RecoverySource.Type.EXISTING_STORE,
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;  
     * survive a node restart. The merged segment must be recoverable locally.
     * Primary local recovery after node restart.
        int numThreads = 3;
        assertEquals("Doc count must survive restart", totalDocs, getDocCount());  
    }
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();  
            }
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(compositeIndexSettings(1)).get();
    public void testReplicaRecoveryFromRemoteStoreWithIncrementalCheckpoints() throws Exception {
            RecoverySource.Type.PEER,  
        return Settings.builder()
            .put("index.pluggable.dataformat.enabled", true)
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(compositeIndexSettings(0)).get();  
        Path parquetDirBefore = shardBefore.shardPath().getDataPath().resolve("parquet");
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
     * Full cluster restart with primary + replica: demonstrates that primary recovers  
    private long getDocCount() {  
        }
        ensureGreen(INDEX_NAME);  
        long expectedTotal = committedDocs + uncommittedDocs;
            }
    }  
        java.util.concurrent.CyclicBarrier barrier = new java.util.concurrent.CyclicBarrier(numThreads);  
            threads[t].start();
import java.util.List;
        }
            .put("index.pluggable.dataformat", "composite")  
 * <p>Replica recovery combines:  
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(compositeIndexSettings(0)).get();
        }, 30, TimeUnit.SECONDS);
        assertEquals("Pre-restart doc count must be correct", expectedTotal, getDocCount());
        String nodeName = primaryNodeName();
            Path indexDir = shard.shardPath().resolveIndex();
        assertEquals(0, failures.get());  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            .prepareUpdateSettings(INDEX_NAME)
import org.opensearch.be.lucene.LucenePlugin;  
            t.join(30_000);
 * incremental translog replay.
            }  
            super.nodePlugins().stream(),  
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();  
        // Increase replica count and start a new data node — triggers replica recovery
            .findFirst()
    }
            }
        internalCluster().startDataOnlyNodes(2);  
     *   <li>Replica recovers by:
        // - Replica: recovered from remote store segments + translog replay
        assertEquals(
     * <ol>  
import org.opensearch.indices.recovery.RecoveryState;
            .orElseThrow(() -> new AssertionError("No primary recovery state found"));
import org.opensearch.plugins.Plugin;
            assertNotNull("Replica shard must exist", replica);
                DataFusionPlugin.class  
            threads[t] = new Thread(() -> {  
        final String replicaNodeFinal = replicaNode;
    public void testMergeOnRefreshFilesSurviveRestart() throws Exception {
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();
        // Wait for remote store upload to complete  
package org.opensearch.composite;
        // Flush commits + fsyncs all format files (including merged segments)
        return getClusterState().nodes().get(nodeId).getName();
            .stream()
            assertNotNull("Remote metadata must exist", meta);  
        }, 30, TimeUnit.SECONDS);
        // Create index with 0 replicas initially
     * locally (fsync'd files) while the replica re-syncs from remote store.
        return stats.getTotal().getDocs().getCount();
        ensureGreen(INDEX_NAME);  
     * <p>Demonstrates that fsync-on-commit makes committed data durable on local disk:
     *   <li>Start a new data node with replica allocation</li>  
 *   <li>Replaying incremental translog operations for unflushed data</li>  
        assertBusy(() -> {
import java.util.concurrent.TimeUnit;
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
        indexDocs(committedDocs, 0);
        }
            .build();
        String nodeName = primaryNodeName();
                assertTrue("Replica must have parquet files (received via segment replication from primary)", files.findAny().isPresent());
        Thread[] threads = new Thread[numThreads];
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();  
     * <ol>
        internalCluster().startDataOnlyNode();
            assertTrue("Parquet files must survive restart (fsync guarantee)", Files.isDirectory(parquetDir));
        }  
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        internalCluster().startClusterManagerOnlyNode();
                assertTrue("Committed parquet files must be on disk", files.findAny().isPresent());
            .get(INDEX_NAME)
        int uncommittedDocs = randomIntBetween(5, 10);
            Stream.of(
        assertEquals(  
            try (Stream<Path> files = Files.list(parquetDir)) {
 * for the primary shard on node restart, while replicas recover via remote store +
 */
                    }
        internalCluster().startDataOnlyNode();  
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
     *  
/**
            IndexShard replica = getIndexShard(replicaNode, INDEX_NAME);  
        assertTrue("Must have parquet files after merge-on-refresh + commit", parquetFilesBefore > 0);
            }
        int committedDocs = randomIntBetween(15, 30);  
     * </ol>
     */  
        // downloads segments from remote store on behalf of the replica)
        // Restart the primary node — simulates a crash
        ensureGreen(INDEX_NAME);
     * requiring a full remote store download instead of fast local recovery.
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadata;  
            .get(INDEX_NAME)  
        // Verify committed files exist on local disk (both parquet + lucene)
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
 *   <li>Downloading committed segments from remote segment store</li>
 * this file be licensed under the Apache-2.0 license or a
            .put("index.composite.primary_data_format", "parquet")
     *       translog replays batch 2 → total doc count = batch1 + batch2</li>
 * Integration tests demonstrating that fsync-on-commit enables reliable local recovery  
            .filter(rs -> rs.getPrimary() == false)  
        assertBusy(() -> {
            try (Stream<Path> files = Files.list(parquetDir)) {
                if (n.equals(primaryNode) == false && n.equals(internalCluster().getClusterManagerName()) == false) {  
            .get(INDEX_NAME)
                        client().prepareIndex(INDEX_NAME).setSource("name", "t" + threadId + "_d" + d, "value", threadId * 100 + d).get();
        // Batch 1: committed (fsync'd to local disk + uploaded to remote store)
    }  
 */  
    /**
            .indices()
        internalCluster().restartNode(nodeName);  
                .collect(Collectors.toSet());  
                    + "Shard routing: "  
                expectedTotal,
                + "committed="
import org.opensearch.parquet.ParquetDataFormatPlugin;  
            Path parquetDir = replica.shardPath().getDataPath().resolve("parquet");  
import java.nio.file.Files;
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
            .findFirst()  
                .keySet()  
        long actualTotal = getDocCount();
            RecoverySource.Type.EXISTING_STORE,
            Path parquetDir = recovered.shardPath().getDataPath().resolve("parquet");
        assertBusy(() -> {  
        indexDocs(uncommittedDocs, committedDocs);
                    replicaNode = n;
