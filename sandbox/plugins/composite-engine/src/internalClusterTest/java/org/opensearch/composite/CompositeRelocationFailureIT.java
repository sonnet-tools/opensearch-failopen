                .getSegments()  
        DataFormatAwareEngine engine = (DataFormatAwareEngine) IndexShardTestCase.getIndexer(shard);
        return state.nodes().get(primary.currentNodeId()).getName();  
        }
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand(INDEX_NAME, 0, sourceNode, targetNode)).get();
        // All data present  
/**
     * Multiple sequential relocations — shard moves node1 → node2 → node1.
    }
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();  
                    Thread.sleep(10); // Pace writes to avoid overwhelming during relocation
import java.util.stream.Collectors;  
    public void testConcurrentIndexingDuringRelocation() throws Exception {
        // Index more + flush
            }  
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();  
                try {  
                        .put("index.pluggable.dataformat.enabled", true)  
import org.opensearch.be.datafusion.DataFusionPlugin;
import java.util.concurrent.atomic.AtomicInteger;
                } catch (Exception e) {
        ensureGreen(INDEX_NAME);
    private String primaryNodeName() {  
import java.util.concurrent.CountDownLatch;
 * Tests relocation failure scenarios and concurrent indexing with relocation  
                        .putList("index.composite.secondary_data_formats", "lucene")  
    /**
        relocateAndWait(currentPrimary, otherNode);
import org.opensearch.cluster.ClusterState;  
        createCompositeIndex(0);
    @Override  
        // Relocate: current primary → the other node
        long maxGenBefore = getMaxGeneration(null);
import org.opensearch.index.engine.DataFormatAwareEngine;
            assertFalse("Should not be relocating", primary.relocating());
            while (!stopIndexing.get()) {
    private void indexDocs(int count, int startId) {
        indexDocs(10, 1000);
        assertTrue("Must have at least committed rows (" + committedRows + "), got " + totalRows, totalRows >= committedRows);
     * Generation must be monotonically increasing across all hops.  
/*  
            genAfterFirst > maxGenBefore
    }
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)  
            ClusterState state = client().admin().cluster().prepareState().get().getState();
            assertTrue("Should be started", primary.started());
package org.opensearch.composite;
            )
 * compatible open source license.
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
                .stream()
            return ref.get().getSegments().stream().mapToLong(Segment::generation).max().orElse(0L);
        internalCluster().startClusterManagerOnlyNode();  
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeName);  
        int numDocs = randomIntBetween(20, 40);  
                .setSettings(  
import org.opensearch.common.settings.Settings;
        internalCluster().startClusterManagerOnlyNode();  
        String currentPrimary = primaryNodeName();
        });
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();  
            nodeName = primaryNodeName();
    /**
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand(INDEX_NAME, 0, source, target)).get();
        indexer.start();  
                LucenePlugin.class,
        String node2 = internalCluster().startDataOnlyNode();
        return indexService.getShard(0);
            assertFalse("Should not be relocating", primary.relocating());  
        long genAfterFirst = getMaxGeneration(null);
 *
                        .put("index.pluggable.dataformat", "composite")
import java.util.stream.Stream;
            ShardRouting primary = state.routingTable().index(INDEX_NAME).shard(0).primaryShard();
        ClusterState state = client().admin().cluster().prepareState().get().getState();
import org.opensearch.common.util.FeatureFlags;
 */
import org.opensearch.index.shard.IndexShard;
            super.nodePlugins().stream(),  
        assertFalse("Indexer thread did not stop in time", indexer.isAlive());
    // Helpers  
        // Start concurrent indexing in background  
                    Settings.builder()
    }  
                }
}
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {  
        long totalRows = getRowCount(null);  
        assertTrue("Indexer must start", started.await(10, TimeUnit.SECONDS));
            ClusterState state = client().admin().cluster().prepareState().get().getState();
        IndexShard shard = getShard(nodeName);
    }
    }
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
            .put(super.nodeSettings(nodeOrdinal))
        // Determine actual allocation  
                        .put("index.composite.primary_data_format", "parquet")
     */
        currentPrimary = primaryNodeName();  
            .build();
        createCompositeIndex(0);
        assertEquals("All docs must survive two relocations", numDocs + 20, totalRows);
        assertAcked(
        Thread indexer = new Thread(() -> {
import java.util.concurrent.TimeUnit;  
                .prepareCreate(INDEX_NAME)
        String node1 = internalCluster().startDataOnlyNode();
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
    private IndexShard getShard(String nodeName) {
import java.util.concurrent.atomic.AtomicBoolean;
            client().admin()  
        Thread.sleep(200);
                .indices()
import org.opensearch.cluster.routing.ShardRouting;
        AtomicBoolean stopIndexing = new AtomicBoolean(false);
import org.opensearch.index.engine.exec.WriterFileSet;  
        String sourceNode = primaryNodeName();
        // Stop indexing and wait for thread
        // Trigger relocation  
import org.opensearch.parquet.ParquetDataFormatPlugin;
        long totalRows = getRowCount(null);
            assertEquals(RestStatus.CREATED, client().prepareIndex(INDEX_NAME).setSource("name", "doc_" + i, "value", i).get().status());  
                ParquetDataFormatPlugin.class,  
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
    private long getRowCount(String nodeName) throws Exception {
        // Seed initial data (committed — must survive)  
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();
            "Generation must advance after first relocation + writes (" + genAfterFirst + " > " + maxGenBefore + ")",
        // Wait for relocation to finish  
        indexDocs(numDocs, 0);
        indexer.setDaemon(true);
import org.opensearch.plugins.Plugin;  
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                .sum();
        CountDownLatch started = new CountDownLatch(1);  
    public void testMultipleSequentialRelocations() throws Exception {
import org.opensearch.test.OpenSearchIntegTestCase;
 * for the composite engine (Parquet + Lucene) with remote store.
    }
            ShardRouting primary = state.routingTable().index(INDEX_NAME).shard(0).primaryShard();  
        );
        // Small delay to let some concurrent docs through  
    // ═══════════════════════════════════════════════════════════════
            assertEquals("Primary should be on target", target, state.nodes().get(primary.currentNodeId()).getName());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        otherNode = currentPrimary.equals(node1) ? node2 : node1;
    private long getMaxGeneration(String nodeName) throws Exception {  
 * The OpenSearch Contributors require contributions made to  
        indexDocs(initialDocs, 0);
public class CompositeRelocationFailureIT extends RemoteStoreBaseIntegTestCase {
            int id = 10000;
        return Stream.concat(
import org.opensearch.common.concurrent.GatedCloseable;  
        assertTrue(  
        DataFormatAwareEngine engine = (DataFormatAwareEngine) IndexShardTestCase.getIndexer(shard);  
        indexDocs(10, 2000);
        return Settings.builder()
    }
                    id++;  
    @Override
        }
    private void createCompositeIndex(int replicas) {
     * starts must survive. Docs during relocation are best-effort.  
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();
        AtomicInteger successCount = new AtomicInteger(0);
        // Index more + flush  
                DataFusionPlugin.class  
        int initialDocs = randomIntBetween(20, 40);
            assertTrue("Should be started", primary.started());
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
            genAfterSecond > genAfterFirst  
import java.util.Collection;
    }  
        ShardRouting primary = state.routingTable().index(INDEX_NAME).shard(0).primaryShard();
                        .put(remoteStoreIndexSettings(replicas, 1))
                .setMapping("name", "type=keyword", "value", "type=integer")
        var indexService = indicesService.indexServiceSafe(resolveIndex(INDEX_NAME));
        assertBusy(() -> {  
    // ═══════════════════════════════════════════════════════════════
                    // Rejections during relocation are expected  
    }  
        stopIndexing.set(true);  
        long committedRows = getRowCount(sourceNode);
    private void relocateAndWait(String source, String target) throws Exception {  
                )
                    if (stopIndexing.get()) break;
        }, 60, TimeUnit.SECONDS);  
     * Concurrent indexing during relocation. All docs acknowledged before relocation
 * SPDX-License-Identifier: Apache-2.0
        String targetNode = sourceNode.equals(node1) ? node2 : node1;
        String node1 = internalCluster().startDataOnlyNode();
                    client().prepareIndex(INDEX_NAME).setSource("name", "concurrent_" + id, "value", id).get();
        client().admin().indices().prepareRefresh(INDEX_NAME).get();  
            started.countDown();  
        // Verify: at minimum, all pre-relocation committed data survives
        if (nodeName == null) {  
        }
import org.opensearch.indices.IndicesService;
        for (int i = startId; i < startId + count; i++) {
                CompositeDataFormatPlugin.class,
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
            "Generation must advance after second relocation + writes (" + genAfterSecond + " > " + genAfterFirst + ")",
        ensureGreen(INDEX_NAME);
import org.opensearch.be.lucene.LucenePlugin;
        relocateAndWait(currentPrimary, otherNode);
        // Flush everything
        indexer.join(15000);
        }  
        assertTrue(
                .filter(java.util.Objects::nonNull)  
 */  
        // Relocate back
        IndexShard shard = getShard(nodeName);
        assertBusy(() -> {
 * this file be licensed under the Apache-2.0 license or a
    }  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                ArrowBasePlugin.class,
        ).collect(Collectors.toList());
import org.opensearch.core.rest.RestStatus;  
        String otherNode = currentPrimary.equals(node1) ? node2 : node1;  
        );  
        }, 60, TimeUnit.SECONDS);  
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
    }
                .map(seg -> seg.dfGroupedSearchableFiles().get("parquet"))
                .mapToLong(WriterFileSet::numRows)
    private static final String INDEX_NAME = "composite-relocation-failure";
            Stream.of(
        long genAfterSecond = getMaxGeneration(null);  
        client().admin().indices().prepareRefresh(INDEX_NAME).get();  
import org.opensearch.index.shard.IndexShardTestCase;  
        );  
    protected Settings nodeSettings(int nodeOrdinal) {  
                    successCount.incrementAndGet();
     */
        String node2 = internalCluster().startDataOnlyNode();
import org.opensearch.index.engine.exec.Segment;
            return ref.get()
