    private long getSegmentCount() {
        int maxNumSegments = 5;
        return Settings.builder()
        long segmentsBefore = getSegmentCount();
            .prepareCreate(INDEX_NAME)
/**
        }
        }
    }
        assertEquals(totalDocs, getTotalDocCount());
            .setMaxNumSegments(maxNumSegments)
            .put("index.composite.primary_data_format", "parquet")
/*
        int totalDocs = 20;
 * The OpenSearch Contributors require contributions made to
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
        assertEquals("Expected exactly 1 segment after force merge to 1", 1, segmentsAfter);
 * this file be licensed under the Apache-2.0 license or a
        ensureGreen(INDEX_NAME);
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).get();
    private Settings compositeIndexSettings() {
        // Verify all docs are present via catalog snapshot
import org.opensearch.common.settings.Settings;
import org.opensearch.common.concurrent.GatedCloseable;
            LucenePlugin.class,
    @Override
        assertEquals(docsPerCycle * cycles, getTotalDocCount());
import java.util.Collection;
            throw new RuntimeException(e);
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/22307")
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
            .indices()
        assertEquals(totalDocs, getTotalDocCount());
import org.opensearch.plugins.Plugin;
            .setMapping("name", "type=keyword", "age", "type=integer")
            .get();
import org.opensearch.index.engine.DataFormatAwareEngine;
        long segmentsAfter = getSegmentCount();
    }
}
package org.opensearch.composite;
import org.opensearch.test.OpenSearchIntegTestCase;
        // Index docs without refresh — data sits in indexing buffer
    }
import org.opensearch.parquet.ParquetDataFormatPlugin;
            throw new RuntimeException(e);
            .put("index.number_of_shards", 1)
            ParquetDataFormatPlugin.class,
        ForceMergeResponse response = client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(true).get();
        int cycles = 5;
import org.opensearch.be.lucene.LucenePlugin;
    private static final String INDEX_NAME = "test-force-merge";
        ForceMergeResponse response = client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(true).get();
        }
    @Override
            .indices()
        try (GatedCloseable<CatalogSnapshot> snapshotRef = engine.acquireLastCommittedSnapshot(false)) {
            .get();
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
public class CompositeForceMergeIT extends OpenSearchIntegTestCase {
        } catch (Exception e) {
            .build();
import org.opensearch.be.datafusion.DataFusionPlugin;
            .put(super.nodeSettings(nodeOrdinal))
 *
            .get();
            .setMapping("name", "type=keyword", "age", "type=integer")
        ensureGreen(INDEX_NAME);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
            .put("index.pluggable.dataformat.enabled", true)
        for (int cycle = 0; cycle < cycles; cycle++) {
import java.util.Arrays;
            .setMapping("name", "type=keyword", "age", "type=integer")
        assertEquals(0, response.getFailedShards());
 */
        assertTrue("Expected multiple segments before merge, got " + segmentsBefore, segmentsBefore > 1);
 */
        DataFormatAwareEngine engine = CompositeEngineHelper.getEngine(internalCluster().clusterService(), internalCluster(), INDEX_NAME);
        assertEquals(0, response.getFailedShards());
        ensureGreen(INDEX_NAME);
            .setSettings(compositeIndexSettings())
    }
            CompositeDataFormatPlugin.class,
        assertEquals(0, getTotalDocCount());
            .prepareCreate(INDEX_NAME)
        int totalDocs = 20;
        // Force merge with flush=true should flush unflushed data first
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).get();
            return snapshotRef.get().getNumDocs();
        assertTrue("Expected segments <= " + maxNumSegments + " after force merge, got " + segmentsAfter, segmentsAfter <= maxNumSegments);
    public void testForceMergeReducesSegmentsToOne() throws Exception {
 * via the composite engine.
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
            .build();
 * SPDX-License-Identifier: Apache-2.0
        int docsPerCycle = 10;
import org.opensearch.arrow.allocator.ArrowBasePlugin;
            .get();
        // Index one doc per refresh to create many small segments
            .indices()
        } catch (Exception e) {
            .putList("index.composite.secondary_data_formats", "lucene")
            .put("index.refresh_interval", "-1")
            .indices()
    public void testForceMergeOnEmptyIndex() throws Exception {
            client().prepareIndex(INDEX_NAME).setSource("name", randomAlphaOfLength(8), "age", randomIntBetween(1, 100)).get();
 * compatible open source license.
                client().prepareIndex(INDEX_NAME).setSource("name", randomAlphaOfLength(8), "age", randomIntBetween(1, 100)).get();
            client().prepareIndex(INDEX_NAME).setSource("name", randomAlphaOfLength(8), "age", randomIntBetween(1, 100)).get();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .put("index.number_of_replicas", 0)
        long segmentsAfter = getSegmentCount();
        client().admin()
        );
    }
    public void testForceMergeWithMaxNumSegmentsGreaterThanOne() throws Exception {
        client().admin()
 * Integration tests for force merge behavior in the DataFormatAwareEngine
        return Settings.builder()
            .setSettings(compositeIndexSettings())
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
    }
            .prepareCreate(INDEX_NAME)
        ForceMergeResponse response = client().admin()
        long segmentsBefore = getSegmentCount();
        return Arrays.asList(
        DataFormatAwareEngine engine = CompositeEngineHelper.getEngine(internalCluster().clusterService(), internalCluster(), INDEX_NAME);
        ForceMergeResponse response = client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(true).get();
            .indices()
        assertEquals(0, response.getFailedShards());
            .get();
        try (GatedCloseable<CatalogSnapshot> snapshotRef = engine.acquireLastCommittedSnapshot(false)) {
            ArrowBasePlugin.class,
        assertEquals(0, response.getFailedShards());
    public void testForceMergeFlushesBeforeMerging() throws Exception {
import org.opensearch.common.util.FeatureFlags;
            .setFlush(true)
    }
    }
        client().admin()
        }
            .prepareCreate(INDEX_NAME)
            DataFusionPlugin.class
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
            }
        for (int i = 0; i < totalDocs; i++) {
    }
            .put("index.pluggable.dataformat", "composite")
            return snapshotRef.get().getSegments().size();
            .setMapping("name", "type=keyword", "age", "type=integer")
            .prepareForceMerge(INDEX_NAME)
        client().admin()
    protected Settings nodeSettings(int nodeOrdinal) {
    private long getTotalDocCount() {
            .setSettings(compositeIndexSettings())
            for (int i = 0; i < docsPerCycle; i++) {
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        for (int i = 0; i < totalDocs; i++) {
        ensureGreen(INDEX_NAME);
        assertTrue("Expected segments reduced, before=" + segmentsBefore + " after=" + segmentsAfter, segmentsAfter < segmentsBefore);
        }
            .setSettings(compositeIndexSettings())
        assertTrue("Expected many segments, got " + segmentsBefore, segmentsBefore > 5);
