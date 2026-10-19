 *
    public static void assertPerSegmentRowCountsMatch(DataFormatAwareEngine engine, String format1, String format2) throws IOException {
                if (raw instanceof LuceneReader == false) {
 * The OpenSearch Contributors require contributions made to  
            .get();
        String nodeId = state.routingTable().index(indexName).shard(0).primaryShard().currentNodeId();
    ) {
                    )
                assertNotNull("segment gen=" + seg.generation() + " missing " + format2, wfs2);
        }  
    // -- Flush --  
            .admin()  
                    throw new IllegalStateException(  
            .put("index.pluggable.dataformat.enabled", true)  
    // -- Indexing --
    // -- Engine access --  
                        "Expected LuceneReader for format [" + formatName + "] but got " + raw.getClass().getName()
    // -- Assertions --  
    }  
                if (raw == null) {
        Settings.Builder sb = Settings.builder()  
    public static IndexShard getPrimaryShard(ClusterService clusterService, InternalTestCluster cluster, String indexName) {
                        "field_keyword",
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
     * resolve {@link DataFormat} via {@link DataFormatRegistry}.
                WriterFileSet wfs2 = seg.dfGroupedSearchableFiles().get(format2);  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        OpenSearchIntegTestCase testCase,  
     * numRows IS the authoritative source for a Parquet file.  
/*  
                assertNotNull("segment gen=" + seg.generation() + " missing " + format1, wfs1);
        Settings.Builder sb = Settings.builder()  
                    .setSource(  
        OpenSearchIntegTestCase testCase,
        sb.putList("index.composite.secondary_data_formats", secondaryFormats);  
                }  
            .put("index.composite.primary_data_format", primaryFormat);
    }
    public static DataFormatAwareEngine getEngine(ClusterService clusterService, InternalTestCluster cluster, String indexName) {
        String nodeName = state.nodes().get(nodeId).getName();
        }
    }
    // -- Index creation --
        Settings extraSettings,  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.core.rest.RestStatus;
    private CompositeEngineHelper() {}
            return ref.get().getSearchableFiles(formatName).stream().mapToLong(WriterFileSet::numRows).sum();  
     *
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
     * <p>For Lucene we use {@link DirectoryReader#numDocs()} which excludes soft-deleted
                WriterFileSet wfs1 = seg.dfGroupedSearchableFiles().get(format1);
import org.opensearch.cluster.metadata.IndexMetadata;
    public static void createCompositeIndexWithMapping(
        testCase.ensureGreen(indexName);  
        return (DataFormatAwareEngine) IndexShardTestCase.getIndexer(getPrimaryShard(clusterService, cluster, indexName));  
     */
import org.opensearch.common.concurrent.GatedCloseable;  
import static org.junit.Assert.assertEquals;
                    return 0L;  
import org.opensearch.index.engine.exec.IndexReaderProvider;
            .indices()
        OpenSearchIntegTestCase.client()
package org.opensearch.composite;
import org.opensearch.test.InternalTestCluster;  
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
                RestStatus.CREATED,  
        String... secondaryFormats
            .put("index.composite.primary_data_format", primaryFormat)
import org.apache.lucene.index.DirectoryReader;
        testCase.createIndex(indexName, sb.build());
        return svc.getShard(0);
import org.opensearch.index.engine.dataformat.DataFormatRegistry;  
    }
import org.opensearch.index.shard.IndexShardTestCase;  
import org.opensearch.test.OpenSearchIntegTestCase;
    public static void flush(OpenSearchIntegTestCase testCase, String indexName) {
        }  
                        "field_number",  
            .put("index.pluggable.dataformat.enabled", true)  
        String... secondaryFormats
import org.opensearch.index.engine.exec.WriterFileSet;  
 * this file be licensed under the Apache-2.0 license or a
        ClusterState state = clusterService.state();  
        throws IOException {  
import org.opensearch.index.engine.dataformat.DataFormat;
     * Engine-only overload — used when the caller already has the engine and only needs the
        sb.putList("index.composite.secondary_data_formats", secondaryFormats);
            .setMapping("field_keyword", "type=keyword", "field_number", "type=integer")
                return ((LuceneReader) raw).directoryReader().numDocs();
 * Shared utility methods for composite engine integration tests.  
            .put(extraSettings);  
import org.opensearch.common.settings.Settings;
 */  
import org.opensearch.cluster.ClusterState;  
    public static long getRowCount(DataFormatAwareEngine engine, String formatName) throws IOException {
        }
            .prepareCreate(indexName)
    }
            DataFormat luceneFormat = new DataFormatRegistry(cluster.getInstance(PluginsService.class, nodeName)).format(formatName);
                Object raw = ref.get().reader(luceneFormat);
    }  
    public static void indexDocs(OpenSearchIntegTestCase testCase, String indexName, int count) {  
     * {@link WriterFileSet#numRows()} from the catalog snapshot, since the file footer's
                }
 */
            .put("index.pluggable.dataformat", "composite")
        DataFormatAwareEngine engine = getEngine(clusterService, cluster, indexName);
     */  
            String nodeName = clusterService.state().nodes().get(nodeId).getName();
            assertEquals(
 * compatible open source license.
import org.opensearch.indices.IndicesService;
            }
                    );
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
/**
            try (GatedCloseable<IndexReaderProvider.Reader> ref = engine.acquireReader()) {  
    public static long getRowCount(ClusterService clusterService, InternalTestCluster cluster, String indexName, String formatName)
import org.opensearch.index.shard.IndexShard;
    ) {
        String primaryFormat,
                    .status()
        for (int i = 0; i < count; i++) {
    /**
        String indexName,
                    .prepareIndex(indexName)
     * Parquet/file-metadata path. The Lucene branch routes through  
    /**
        String primaryFormat,  
import java.io.IOException;  
}
     * {@link #getRowCount(ClusterService, InternalTestCluster, String, String)} which can
import org.opensearch.index.engine.DataFormatAwareEngine;
    }  
            }
            .indexServiceSafe(state.metadata().index(indexName).getIndex());
import org.opensearch.be.lucene.LuceneReader;
import org.opensearch.plugins.PluginsService;
            .put("index.pluggable.dataformat", "composite")
import org.opensearch.cluster.service.ClusterService;
    // -- Row counts --  
        testCase.ensureGreen(indexName);
        // Parquet path: file-footer numRows is the source of truth (no deletes for parquet today).
 * Stateless — all methods take explicit parameters so any IT can use them.
    }
        OpenSearchIntegTestCase.client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();  
import org.opensearch.index.IndexService;  
     * docs (e.g., docs removed by {@code rollbackLastDoc}). For Parquet — which has no  
        String indexName,
                    .get()  
        }
                assertEquals("segment gen=" + seg.generation() + " row counts must match", wfs1.numRows(), wfs2.numRows());  
                        OpenSearchIntegTestCase.randomAlphaOfLength(10),
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {  
                OpenSearchIntegTestCase.client()
import org.opensearch.index.engine.exec.Segment;
    }
     * delete primitive in this codebase yet — we fall back to summing
            for (Segment seg : ref.get().getSegments()) {
            return ref.get().getSearchableFiles(formatName).stream().mapToLong(WriterFileSet::numRows).sum();  
    public static void createCompositeIndex(  
        IndexService svc = cluster.getInstance(IndicesService.class, nodeName)  
            .setSettings(sb)  
 * SPDX-License-Identifier: Apache-2.0
        if ("lucene".equals(formatName)) {
import static org.junit.Assert.assertNotNull;  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            String nodeId = clusterService.state().routingTable().index(indexName).shard(0).primaryShard().currentNodeId();  
                        OpenSearchIntegTestCase.randomIntBetween(0, 1000)
            );
public final class CompositeEngineHelper {  
     * Returns the total live-doc count for a format by querying its actual reader.  
