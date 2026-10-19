        client().admin()
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        // Index docs without refresh — data sits in indexing buffer
            .put("index.refresh_interval", "-1")
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
            .setMapping("name", "type=keyword", "age", "type=integer")
public class CompositeForceMergeIT extends OpenSearchIntegTestCase {
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;  
        // Index one doc per refresh to create many small segments
        assertEquals(docsPerCycle * cycles, getTotalDocCount());  
 * via the composite engine.  
import java.util.Arrays;
            .get();
    public void testForceMergeReducesSegmentsToOne() throws Exception {  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.util.FeatureFlags;  
/**
        long segmentsBefore = getSegmentCount();
        for (int i = 0; i < totalDocs; i++) {
            client().prepareIndex(INDEX_NAME).setSource("name", randomAlphaOfLength(8), "age", randomIntBetween(1, 100)).get();
        DataFormatAwareEngine engine = CompositeEngineHelper.getEngine(internalCluster().clusterService(), internalCluster(), INDEX_NAME);
            .putList("index.composite.secondary_data_formats", "lucene")
            throw new RuntimeException(e);  
import org.opensearch.test.OpenSearchIntegTestCase;
 */
        assertEquals(0, response.getFailedShards());
        ForceMergeResponse response = client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(true).get();
            .put("index.number_of_shards", 1)
        return Settings.builder()
import org.opensearch.plugins.Plugin;
        int maxNumSegments = 5;  
        assertEquals("Expected exactly 1 segment after force merge to 1", 1, segmentsAfter);
            return snapshotRef.get().getSegments().size();
            .setMaxNumSegments(maxNumSegments)
            .get();
import org.opensearch.index.engine.DataFormatAwareEngine;
 * SPDX-License-Identifier: Apache-2.0
        ensureGreen(INDEX_NAME);
        } catch (Exception e) {
            .prepareForceMerge(INDEX_NAME)  
            .build();  
        assertTrue("Expected multiple segments before merge, got " + segmentsBefore, segmentsBefore > 1);
            .prepareCreate(INDEX_NAME)  
        try (GatedCloseable<CatalogSnapshot> snapshotRef = engine.acquireLastCommittedSnapshot(false)) {  
            .setMapping("name", "type=keyword", "age", "type=integer")
    private long getTotalDocCount() {
        int totalDocs = 20;  
    @Override
    }
            .indices()  
package org.opensearch.composite;
            }
        client().admin()
 *
    }
    }
            DataFusionPlugin.class  
            .setSettings(compositeIndexSettings())  
            .indices()
            CompositeDataFormatPlugin.class,
                client().prepareIndex(INDEX_NAME).setSource("name", randomAlphaOfLength(8), "age", randomIntBetween(1, 100)).get();
import org.opensearch.be.lucene.LucenePlugin;  
            .prepareCreate(INDEX_NAME)  
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/22307")  
    private Settings compositeIndexSettings() {  
        // Verify all docs are present via catalog snapshot
        assertEquals(0, response.getFailedShards());  
            .setSettings(compositeIndexSettings())
        } catch (Exception e) {
 */  
import org.opensearch.common.settings.Settings;
        ensureGreen(INDEX_NAME);
            .setMapping("name", "type=keyword", "age", "type=integer")
        ensureGreen(INDEX_NAME);  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)  
 * The OpenSearch Contributors require contributions made to  
            .build();  
        int cycles = 5;
            .indices()
            .setSettings(compositeIndexSettings())
        ensureGreen(INDEX_NAME);
    private long getSegmentCount() {
        int docsPerCycle = 10;  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
        );
            .put("index.pluggable.dataformat", "composite")  
/*  
            .get();  
    }
    }
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
        }
            client().prepareIndex(INDEX_NAME).setSource("name", randomAlphaOfLength(8), "age", randomIntBetween(1, 100)).get();  
            .get();  
        assertEquals(0, response.getFailedShards());
            return snapshotRef.get().getNumDocs();
    }
            .indices()
        for (int cycle = 0; cycle < cycles; cycle++) {
import org.opensearch.parquet.ParquetDataFormatPlugin;  
        client().admin()  
        }
        assertEquals(0, response.getFailedShards());
    public void testForceMergeWithMaxNumSegmentsGreaterThanOne() throws Exception {
        // Force merge with flush=true should flush unflushed data first  
        assertEquals(totalDocs, getTotalDocCount());  
            LucenePlugin.class,
 * Integration tests for force merge behavior in the DataFormatAwareEngine
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).get();
            .indices()
        long segmentsBefore = getSegmentCount();  
            .setSettings(compositeIndexSettings())
        ForceMergeResponse response = client().admin()
            .setFlush(true)
    public void testForceMergeFlushesBeforeMerging() throws Exception {  
            ParquetDataFormatPlugin.class,  
        }
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
            .get();  
import java.util.Collection;
        return Arrays.asList(
    public void testForceMergeOnEmptyIndex() throws Exception {
        assertTrue("Expected many segments, got " + segmentsBefore, segmentsBefore > 5);
import org.opensearch.common.concurrent.GatedCloseable;
        }  
    @Override
        long segmentsAfter = getSegmentCount();
    }
        ForceMergeResponse response = client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(true).get();
        return Settings.builder()  
        try (GatedCloseable<CatalogSnapshot> snapshotRef = engine.acquireLastCommittedSnapshot(false)) {  
        client().admin()
            client().admin().indices().prepareRefresh(INDEX_NAME).get();  
            .put(super.nodeSettings(nodeOrdinal))
            .put("index.number_of_replicas", 0)  
        ForceMergeResponse response = client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(true).get();
        assertTrue("Expected segments <= " + maxNumSegments + " after force merge, got " + segmentsAfter, segmentsAfter <= maxNumSegments);
    }
}  
        assertEquals(0, getTotalDocCount());
            .put("index.composite.primary_data_format", "parquet")
        assertEquals(totalDocs, getTotalDocCount());
        long segmentsAfter = getSegmentCount();  
        for (int i = 0; i < totalDocs; i++) {  
            .setMapping("name", "type=keyword", "age", "type=integer")  
        }
import org.opensearch.be.datafusion.DataFusionPlugin;
            .put("index.pluggable.dataformat.enabled", true)
            for (int i = 0; i < docsPerCycle; i++) {  
            .prepareCreate(INDEX_NAME)
        int totalDocs = 20;
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).get();
        assertTrue("Expected segments reduced, before=" + segmentsBefore + " after=" + segmentsAfter, segmentsAfter < segmentsBefore);
        DataFormatAwareEngine engine = CompositeEngineHelper.getEngine(internalCluster().clusterService(), internalCluster(), INDEX_NAME);
    protected Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.arrow.allocator.ArrowBasePlugin;
            throw new RuntimeException(e);  
    private static final String INDEX_NAME = "test-force-merge";  
            ArrowBasePlugin.class,
    }  
 * compatible open source license.
            .prepareCreate(INDEX_NAME)
