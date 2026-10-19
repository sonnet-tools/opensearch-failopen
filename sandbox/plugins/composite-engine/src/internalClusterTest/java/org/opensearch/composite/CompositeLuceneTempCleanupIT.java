            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
import org.opensearch.be.datafusion.DataFusionPlugin;
    @Override
 * The OpenSearch Contributors require contributions made to  
 * are cleaned up after refresh incorporates their segments into the shared writer.
            RefreshResponse refreshResponse = client().admin().indices().prepareRefresh(INDEX_NAME).get();  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        IndexShard shard = indexService.getShard(0);
        return Settings.builder()
    protected Settings nodeSettings(int nodeOrdinal) {
        for (int batch = 0; batch < 3; batch++) {
    private IndexShard getPrimaryShard() {
            .put(super.nodeSettings(nodeOrdinal))  
                .getSegments()
        });
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            .preparePutMapping(INDEX_NAME)
        createIndex(forceMergeIndex, indexSettings);
import org.opensearch.plugins.Plugin;  
        String nodeName = getClusterState().nodes().get(nodeId).getName();
                .size();
            }  
                assertEquals(RestStatus.CREATED, response.status());
        String nodeName = getClusterState().nodes().get(nodeId).getName();
    }
    }  
            assertEquals("Expected 1 segment after force merge", 1L, segmentCount);  
    private static final String INDEX_NAME = "test-lucene-temp-cleanup";
                assertEquals("Lucene temp directories (lucene_gen_*) should be cleaned up after force merge", 0L, staleGenDirs);  
            for (int i = 0; i < 100; i++) {
    }
            for (int i = 0; i < 100; i++) {  
        ensureGreen(INDEX_NAME);
        Path indexDir = shard.shardPath().resolveIndex();
                assertEquals(RestStatus.CREATED, response.status());
    }
import org.opensearch.common.settings.Settings;
            .get();  
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeName);  
package org.opensearch.composite;
            .put("index.pluggable.dataformat", "composite")  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                    .get();
 * SPDX-License-Identifier: Apache-2.0
        );  
            CompositeDataFormatPlugin.class,  
            .indices()
                long staleGenDirs = dirs.filter(p -> p.getFileName().toString().startsWith("lucene_gen_")).count();
        try (Stream<Path> files = Files.list(indexDir)) {
            assertTrue("Index directory should contain segment files", fileCount > 0);  
        // Get the shard's lucene base directory  
                IndexResponse response = client().prepareIndex()  
        client().admin()  
/**  
        client().admin()
import org.opensearch.common.util.FeatureFlags;  
            .put("index.pluggable.dataformat.enabled", true)
        assertTrue("Index directory should exist", Files.exists(indexDir));  
        if (Files.exists(luceneBaseDir)) {  
 * Integration test that verifies temporary Lucene writer directories (lucene_gen_*)
}  
            .build();
            ParquetDataFormatPlugin.class,
            .setSource("field_keyword", "type=keyword", "field_number", "type=integer")
        ForceMergeResponse forceMergeResponse = client().admin().indices().prepareForceMerge(forceMergeIndex).setMaxNumSegments(1).get();  
        return Arrays.asList(  
            ArrowBasePlugin.class,
            .putList("index.composite.secondary_data_formats", "lucene")
            .build();
import java.util.stream.Stream;
    public void testLuceneTempDirectoriesCleanedAfterRefresh() throws Exception {
            try (Stream<Path> dirs = Files.list(luceneBaseDir)) {
public class CompositeLuceneTempCleanupIT extends OpenSearchIntegTestCase {  
        if (Files.exists(luceneBaseDir)) {  
/*  
        ensureGreen(forceMergeIndex);
                IndexResponse response = client().prepareIndex()
 * compatible open source license.
import java.nio.file.Path;
            .get();
        // Force merge to 1 segment
                    .setSource("field_keyword", "value_" + batch + "_" + i, "field_number", i)
        createIndex(INDEX_NAME, indexSettings);
            }
                    .setIndex(forceMergeIndex)
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
        Settings indexSettings = Settings.builder()  
import org.opensearch.indices.IndicesService;
            .putList("index.composite.secondary_data_formats", "lucene")
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();  
import org.opensearch.arrow.allocator.ArrowBasePlugin;
                assertEquals("Lucene temp directories (lucene_gen_*) should be cleaned up after refresh", 0L, staleGenDirs);  
            DataFusionPlugin.class
    @Override  
        String forceMergeIndex = "test-lucene-temp-cleanup-forcemerge";
import org.opensearch.be.lucene.LucenePlugin;  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            try (Stream<Path> dirs = Files.list(luceneBaseDir)) {
            .put("index.refresh_interval", "-1")  
        }
            long segmentCount = segResponse.getIndices().get(forceMergeIndex).getShards().values().iterator().next().getShards()[0]  
import org.opensearch.index.IndexService;
            .preparePutMapping(forceMergeIndex)
            .put("index.pluggable.dataformat.enabled", true)
                    .get();  
        Path luceneBaseDir = shard.shardPath().getDataPath().resolve("lucene");  
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
            assertEquals(RestStatus.OK, refreshResponse.getStatus());
    public void testLuceneTempDirectoriesCleanedAfterForceMerge() throws Exception {
        // Ingest 5 batches with refreshes to create multiple segments
        assertEquals(RestStatus.OK, forceMergeResponse.getStatus());
            .indices()  
        // Get the shard's lucene base directory
    }  
 *
            }
import org.opensearch.action.index.IndexResponse;  
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex(forceMergeIndex));
            .put("index.refresh_interval", "-1")
import org.opensearch.index.shard.IndexShard;  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 1)
        Path luceneBaseDir = shard.shardPath().getDataPath().resolve("lucene");  
            .put("index.pluggable.dataformat", "composite")
        // Ingest 3 batches with a refresh after each to create multiple writer generations  
import java.util.Arrays;
 */  
        IndexShard shard = getPrimaryShard();
            .put("index.composite.primary_data_format", "parquet")
            .build();  
        String nodeId = getClusterState().routingTable().index(forceMergeIndex).shard(0).primaryShard().currentNodeId();
            assertEquals(RestStatus.OK, refreshResponse.getStatus());
        // Wait for async merge to complete — DataFormatAwareEngine's forceMerge is async  
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeName);
        // After force merge, the lucene_gen_* temp directories should NOT exist
            RefreshResponse refreshResponse = client().admin().indices().prepareRefresh(forceMergeIndex).get();
        }  
        Settings indexSettings = Settings.builder()
 * this file be licensed under the Apache-2.0 license or a
 */  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                    .setSource("field_keyword", "value_" + batch + "_" + i, "field_number", i)  
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
        // After refresh, the lucene_gen_* temp directories should NOT exist
                long staleGenDirs = dirs.filter(p -> p.getFileName().toString().startsWith("lucene_gen_")).count();
            }
        }
        return indexService.getShard(0);
        assertBusy(() -> {
import org.opensearch.test.OpenSearchIntegTestCase;
        for (int batch = 0; batch < 5; batch++) {
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex(INDEX_NAME));  
import java.nio.file.Files;  
        }
        // Verify data is intact in the index/ directory
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;  
import java.util.Collection;  
            .setSource("field_keyword", "type=keyword", "field_number", "type=integer")  
            long fileCount = files.count();
import org.opensearch.parquet.ParquetDataFormatPlugin;
            LucenePlugin.class,
            .put("index.composite.primary_data_format", "parquet")  
            IndicesSegmentResponse segResponse = client().admin().indices().prepareSegments(forceMergeIndex).get();
import org.opensearch.cluster.metadata.IndexMetadata;
                    .setIndex(INDEX_NAME)
import org.opensearch.core.rest.RestStatus;
        }
