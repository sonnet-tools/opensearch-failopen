 * The OpenSearch Contributors require contributions made to
    private static final String INDEX_NAME = "test-lucene-temp-cleanup";
 * SPDX-License-Identifier: Apache-2.0
}
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // After refresh, the lucene_gen_* temp directories should NOT exist
        for (int batch = 0; batch < 3; batch++) {
        }
        Path luceneBaseDir = shard.shardPath().getDataPath().resolve("lucene");
            }
package org.opensearch.composite;
            try (Stream<Path> dirs = Files.list(luceneBaseDir)) {
    protected Settings nodeSettings(int nodeOrdinal) {
    }
        String nodeName = getClusterState().nodes().get(nodeId).getName();
 *
import java.nio.file.Files;
        String nodeId = getClusterState().routingTable().index(forceMergeIndex).shard(0).primaryShard().currentNodeId();
        // Get the shard's lucene base directory
import org.opensearch.plugins.Plugin;
import org.opensearch.be.lucene.LucenePlugin;
        try (Stream<Path> files = Files.list(indexDir)) {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .build();
            .get();
            .get();
                    .setSource("field_keyword", "value_" + batch + "_" + i, "field_number", i)
                long staleGenDirs = dirs.filter(p -> p.getFileName().toString().startsWith("lucene_gen_")).count();
            CompositeDataFormatPlugin.class,
            long fileCount = files.count();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        // Ingest 5 batches with refreshes to create multiple segments
public class CompositeLuceneTempCleanupIT extends OpenSearchIntegTestCase {
 */
import java.nio.file.Path;
 * are cleaned up after refresh incorporates their segments into the shared writer.
import java.util.stream.Stream;
            RefreshResponse refreshResponse = client().admin().indices().prepareRefresh(INDEX_NAME).get();
            .put("index.pluggable.dataformat.enabled", true)
            .putList("index.composite.secondary_data_formats", "lucene")
        Path indexDir = shard.shardPath().resolveIndex();
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex(forceMergeIndex));
import org.opensearch.indices.IndicesService;
                assertEquals(RestStatus.CREATED, response.status());
import org.opensearch.index.IndexService;
            long segmentCount = segResponse.getIndices().get(forceMergeIndex).getShards().values().iterator().next().getShards()[0]
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .getSegments()
    @Override
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchIntegTestCase;
        Path luceneBaseDir = shard.shardPath().getDataPath().resolve("lucene");
    public void testLuceneTempDirectoriesCleanedAfterRefresh() throws Exception {
            }
        // Force merge to 1 segment
        }
        // Wait for async merge to complete — DataFormatAwareEngine's forceMerge is async
import org.opensearch.arrow.allocator.ArrowBasePlugin;
            for (int i = 0; i < 100; i++) {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        IndexShard shard = getPrimaryShard();
        return Arrays.asList(
        });
 * Integration test that verifies temporary Lucene writer directories (lucene_gen_*)
        }
            .put("index.composite.primary_data_format", "parquet")
            .put("index.pluggable.dataformat.enabled", true)
 * compatible open source license.
            assertEquals(RestStatus.OK, refreshResponse.getStatus());
                assertEquals("Lucene temp directories (lucene_gen_*) should be cleaned up after force merge", 0L, staleGenDirs);
        createIndex(INDEX_NAME, indexSettings);
                    .get();
    }
        // Verify data is intact in the index/ directory
import java.util.Arrays;
        if (Files.exists(luceneBaseDir)) {
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeName);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 1)
import org.opensearch.core.rest.RestStatus;
        createIndex(forceMergeIndex, indexSettings);
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
import org.opensearch.index.shard.IndexShard;
        String forceMergeIndex = "test-lucene-temp-cleanup-forcemerge";
            .put("index.refresh_interval", "-1")
        for (int batch = 0; batch < 5; batch++) {
            .setSource("field_keyword", "type=keyword", "field_number", "type=integer")
        client().admin()
            assertEquals("Expected 1 segment after force merge", 1L, segmentCount);
        IndexShard shard = indexService.getShard(0);
        Settings indexSettings = Settings.builder()
    public void testLuceneTempDirectoriesCleanedAfterForceMerge() throws Exception {
        );
        return Settings.builder()
import org.opensearch.be.datafusion.DataFusionPlugin;
    }
            }
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
            .put(super.nodeSettings(nodeOrdinal))
            try (Stream<Path> dirs = Files.list(luceneBaseDir)) {
                IndexResponse response = client().prepareIndex()
import java.util.Collection;
        String nodeName = getClusterState().nodes().get(nodeId).getName();
            DataFusionPlugin.class
            assertEquals(RestStatus.OK, refreshResponse.getStatus());
                IndexResponse response = client().prepareIndex()
            IndicesSegmentResponse segResponse = client().admin().indices().prepareSegments(forceMergeIndex).get();
            .preparePutMapping(forceMergeIndex)
                    .setIndex(forceMergeIndex)
        Settings indexSettings = Settings.builder()
            assertTrue("Index directory should contain segment files", fileCount > 0);
        }
                    .setSource("field_keyword", "value_" + batch + "_" + i, "field_number", i)
    private IndexShard getPrimaryShard() {
                    .setIndex(INDEX_NAME)
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
            ArrowBasePlugin.class,
/*
 */
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
        ensureGreen(INDEX_NAME);
    }
            .preparePutMapping(INDEX_NAME)
                assertEquals("Lucene temp directories (lucene_gen_*) should be cleaned up after refresh", 0L, staleGenDirs);
import org.opensearch.common.settings.Settings;
            .put("index.pluggable.dataformat", "composite")
            }
            .indices()
            .build();
        assertBusy(() -> {
                .size();
                long staleGenDirs = dirs.filter(p -> p.getFileName().toString().startsWith("lucene_gen_")).count();
        ForceMergeResponse forceMergeResponse = client().admin().indices().prepareForceMerge(forceMergeIndex).setMaxNumSegments(1).get();
            .put("index.refresh_interval", "-1")
/**
        assertEquals(RestStatus.OK, forceMergeResponse.getStatus());
import org.opensearch.parquet.ParquetDataFormatPlugin;
            .build();
        ensureGreen(forceMergeIndex);
import org.opensearch.action.index.IndexResponse;
    }
        return indexService.getShard(0);
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex(INDEX_NAME));
            for (int i = 0; i < 100; i++) {
    @Override
                assertEquals(RestStatus.CREATED, response.status());
            .indices()
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        // Ingest 3 batches with a refresh after each to create multiple writer generations
import org.opensearch.common.util.FeatureFlags;
        // Get the shard's lucene base directory
import org.opensearch.cluster.metadata.IndexMetadata;
            .setSource("field_keyword", "type=keyword", "field_number", "type=integer")
        if (Files.exists(luceneBaseDir)) {
            .put("index.composite.primary_data_format", "parquet")
            RefreshResponse refreshResponse = client().admin().indices().prepareRefresh(forceMergeIndex).get();
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeName);
        client().admin()
            ParquetDataFormatPlugin.class,
        }
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
            .put("index.pluggable.dataformat", "composite")
                    .get();
        assertTrue("Index directory should exist", Files.exists(indexDir));
        // After force merge, the lucene_gen_* temp directories should NOT exist
            LucenePlugin.class,
            .putList("index.composite.secondary_data_formats", "lucene")
