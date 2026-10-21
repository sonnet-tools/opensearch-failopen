        String otherNode = currentPrimary.equals(node1) ? node2 : node1;
        var indexService = indicesService.indexServiceSafe(resolveIndex(INDEX_NAME));
    }
            ShardRouting primary = state.routingTable().index(INDEX_NAME).shard(0).primaryShard();
                DataFusionPlugin.class
                .setMapping("name", "type=keyword", "value", "type=integer")
import java.util.concurrent.atomic.AtomicBoolean;
        );
        String node1 = internalCluster().startDataOnlyNode();
                        .put("index.pluggable.dataformat.enabled", true)
    protected Settings nodeSettings(int nodeOrdinal) {
            return ref.get()
            super.nodePlugins().stream(),
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        createCompositeIndex(0);
        AtomicInteger successCount = new AtomicInteger(0);
                .setSettings(
        // Relocate: current primary → the other node
        ensureGreen(INDEX_NAME);
        );
        ensureGreen(INDEX_NAME);
                    successCount.incrementAndGet();
    private long getMaxGeneration(String nodeName) throws Exception {
        int initialDocs = randomIntBetween(20, 40);
        stopIndexing.set(true);
            assertTrue("Should be started", primary.started());
                ParquetDataFormatPlugin.class,
 *
    // ═══════════════════════════════════════════════════════════════
    private static final String INDEX_NAME = "composite-relocation-failure";
        // Relocate back
            int id = 10000;
    private void relocateAndWait(String source, String target) throws Exception {
import org.opensearch.cluster.routing.ShardRouting;
import java.util.Collection;
import org.opensearch.cluster.ClusterState;
        }, 60, TimeUnit.SECONDS);
     * Concurrent indexing during relocation. All docs acknowledged before relocation
import org.opensearch.common.settings.Settings;
                    if (stopIndexing.get()) break;
    /**
                    // Rejections during relocation are expected
        return indexService.getShard(0);
import java.util.concurrent.CountDownLatch;
                .indices()
    // Helpers
                .map(seg -> seg.dfGroupedSearchableFiles().get("parquet"))
            .build();
        // Index more + flush
        ).collect(Collectors.toList());
    }
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
            started.countDown();
        }
    }
                .prepareCreate(INDEX_NAME)
        internalCluster().startClusterManagerOnlyNode();
        assertBusy(() -> {
        Thread indexer = new Thread(() -> {
        String node2 = internalCluster().startDataOnlyNode();
        indexer.setDaemon(true);
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
                } catch (Exception e) {
        long committedRows = getRowCount(sourceNode);
        return state.nodes().get(primary.currentNodeId()).getName();
 */
        // Stop indexing and wait for thread
                        .put(remoteStoreIndexSettings(replicas, 1))
import org.opensearch.common.util.FeatureFlags;
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand(INDEX_NAME, 0, sourceNode, targetNode)).get();
        for (int i = startId; i < startId + count; i++) {
        assertFalse("Indexer thread did not stop in time", indexer.isAlive());
    // ═══════════════════════════════════════════════════════════════
        otherNode = currentPrimary.equals(node1) ? node2 : node1;
        // Seed initial data (committed — must survive)
                    id++;
     * Generation must be monotonically increasing across all hops.
            assertEquals("Primary should be on target", target, state.nodes().get(primary.currentNodeId()).getName());
    private void createCompositeIndex(int replicas) {
                try {
}
        indexer.start();
 * Tests relocation failure scenarios and concurrent indexing with relocation
    }
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();
            ClusterState state = client().admin().cluster().prepareState().get().getState();
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
 * compatible open source license.
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        long genAfterSecond = getMaxGeneration(null);
import org.opensearch.parquet.ParquetDataFormatPlugin;
import org.opensearch.index.shard.IndexShard;
        long totalRows = getRowCount(null);
 * this file be licensed under the Apache-2.0 license or a
                        .putList("index.composite.secondary_data_formats", "lucene")
        internalCluster().startClusterManagerOnlyNode();
import org.opensearch.index.shard.IndexShardTestCase;
            "Generation must advance after first relocation + writes (" + genAfterFirst + " > " + maxGenBefore + ")",
    }
        return Stream.concat(
        }, 60, TimeUnit.SECONDS);
        long genAfterFirst = getMaxGeneration(null);
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        currentPrimary = primaryNodeName();
        // Small delay to let some concurrent docs through
        ClusterState state = client().admin().cluster().prepareState().get().getState();
    public void testMultipleSequentialRelocations() throws Exception {
    }
        relocateAndWait(currentPrimary, otherNode);
    }
            genAfterFirst > maxGenBefore
    private void indexDocs(int count, int startId) {
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
                .getSegments()
            ClusterState state = client().admin().cluster().prepareState().get().getState();
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
        Thread.sleep(200);
            assertTrue("Should be started", primary.started());
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand(INDEX_NAME, 0, source, target)).get();
import org.opensearch.test.OpenSearchIntegTestCase;
                .filter(java.util.Objects::nonNull)
        return Settings.builder()
            assertEquals(RestStatus.CREATED, client().prepareIndex(INDEX_NAME).setSource("name", "doc_" + i, "value", i).get().status());
            .put(super.nodeSettings(nodeOrdinal))
        AtomicBoolean stopIndexing = new AtomicBoolean(false);
/**
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    }
                }
                    client().prepareIndex(INDEX_NAME).setSource("name", "concurrent_" + id, "value", id).get();
import org.opensearch.core.rest.RestStatus;
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
        long maxGenBefore = getMaxGeneration(null);
                .mapToLong(WriterFileSet::numRows)
        indexDocs(initialDocs, 0);
     */
package org.opensearch.composite;
        // Trigger relocation
                    Thread.sleep(10); // Pace writes to avoid overwhelming during relocation
            while (!stopIndexing.get()) {
            Stream.of(
            nodeName = primaryNodeName();
        );
            return ref.get().getSegments().stream().mapToLong(Segment::generation).max().orElse(0L);
        if (nodeName == null) {
    }
import java.util.stream.Stream;
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();
        // Verify: at minimum, all pre-relocation committed data survives
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.plugins.Plugin;
                .sum();
        indexer.join(15000);
        });
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        assertAcked(
            genAfterSecond > genAfterFirst
    @Override
        // Determine actual allocation
    /**
/*
    public void testConcurrentIndexingDuringRelocation() throws Exception {
        indexDocs(10, 2000);
        assertTrue("Must have at least committed rows (" + committedRows + "), got " + totalRows, totalRows >= committedRows);
        assertTrue(
import org.opensearch.be.datafusion.DataFusionPlugin;
    private String primaryNodeName() {
import org.opensearch.be.lucene.LucenePlugin;
    private IndexShard getShard(String nodeName) {
        String currentPrimary = primaryNodeName();
            assertFalse("Should not be relocating", primary.relocating());
        CountDownLatch started = new CountDownLatch(1);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
 * for the composite engine (Parquet + Lucene) with remote store.
                        .put("index.pluggable.dataformat", "composite")
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
        // Flush everything
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
    @Override
        indexDocs(10, 1000);
import java.util.stream.Collectors;
        // All data present
        IndexShard shard = getShard(nodeName);
    }
        int numDocs = randomIntBetween(20, 40);
                LucenePlugin.class,
            )
        // Start concurrent indexing in background
        IndexShard shard = getShard(nodeName);
                        .put("index.composite.primary_data_format", "parquet")
        }
 * The OpenSearch Contributors require contributions made to
        }
 */
                CompositeDataFormatPlugin.class,
                .stream()
            "Generation must advance after second relocation + writes (" + genAfterSecond + " > " + genAfterFirst + ")",
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        assertTrue("Indexer must start", started.await(10, TimeUnit.SECONDS));
import org.opensearch.index.engine.DataFormatAwareEngine;
import org.opensearch.indices.IndicesService;
import java.util.concurrent.atomic.AtomicInteger;
                    Settings.builder()
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();
        relocateAndWait(currentPrimary, otherNode);
        assertEquals("All docs must survive two relocations", numDocs + 20, totalRows);
public class CompositeRelocationFailureIT extends RemoteStoreBaseIntegTestCase {
            client().admin()
        long totalRows = getRowCount(null);
import org.opensearch.index.engine.exec.WriterFileSet;
import java.util.concurrent.TimeUnit;
    private long getRowCount(String nodeName) throws Exception {
        assertTrue(
     */
            }
import org.opensearch.index.engine.exec.Segment;
                )
        assertBusy(() -> {
        String targetNode = sourceNode.equals(node1) ? node2 : node1;
import org.opensearch.common.concurrent.GatedCloseable;
        String node2 = internalCluster().startDataOnlyNode();
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeName);
        indexDocs(numDocs, 0);
        }
        String sourceNode = primaryNodeName();
        ShardRouting primary = state.routingTable().index(INDEX_NAME).shard(0).primaryShard();
        DataFormatAwareEngine engine = (DataFormatAwareEngine) IndexShardTestCase.getIndexer(shard);
        // Wait for relocation to finish
     * starts must survive. Docs during relocation are best-effort.
            assertFalse("Should not be relocating", primary.relocating());
            ShardRouting primary = state.routingTable().index(INDEX_NAME).shard(0).primaryShard();
        String node1 = internalCluster().startDataOnlyNode();
        createCompositeIndex(0);
        // Index more + flush
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();
                ArrowBasePlugin.class,
     * Multiple sequential relocations — shard moves node1 → node2 → node1.
    }
        DataFormatAwareEngine engine = (DataFormatAwareEngine) IndexShardTestCase.getIndexer(shard);
