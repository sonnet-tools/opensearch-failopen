        String... secondaryFormats
import java.io.IOException;
            for (Segment seg : ref.get().getSegments()) {
    // -- Row counts --
            }
        // Parquet path: file-footer numRows is the source of truth (no deletes for parquet today).
        OpenSearchIntegTestCase testCase,
    /**
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
 * The OpenSearch Contributors require contributions made to
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        String nodeId = state.routingTable().index(indexName).shard(0).primaryShard().currentNodeId();
    // -- Engine access --
     * Engine-only overload — used when the caller already has the engine and only needs the
            .setMapping("field_keyword", "type=keyword", "field_number", "type=integer")
        testCase.ensureGreen(indexName);
        testCase.createIndex(indexName, sb.build());
        if ("lucene".equals(formatName)) {
     * docs (e.g., docs removed by {@code rollbackLastDoc}). For Parquet — which has no
                    )
import org.opensearch.test.InternalTestCluster;
    /**
    ) {
}
                        OpenSearchIntegTestCase.randomAlphaOfLength(10),
        }
import static org.junit.Assert.assertNotNull;
        throws IOException {
        IndexService svc = cluster.getInstance(IndicesService.class, nodeName)
        String nodeName = state.nodes().get(nodeId).getName();
    public static void indexDocs(OpenSearchIntegTestCase testCase, String indexName, int count) {
        DataFormatAwareEngine engine = getEngine(clusterService, cluster, indexName);
            assertEquals(
        }
                }
    }
                    .status()
import org.opensearch.index.engine.exec.IndexReaderProvider;
import org.opensearch.cluster.service.ClusterService;
    public static void flush(OpenSearchIntegTestCase testCase, String indexName) {
import org.opensearch.common.concurrent.GatedCloseable;
                assertNotNull("segment gen=" + seg.generation() + " missing " + format1, wfs1);
            String nodeId = clusterService.state().routingTable().index(indexName).shard(0).primaryShard().currentNodeId();
 * this file be licensed under the Apache-2.0 license or a
        }
import org.opensearch.core.rest.RestStatus;
import org.opensearch.indices.IndicesService;
    // -- Indexing --
                    .get()
            .put(extraSettings);
import org.opensearch.cluster.metadata.IndexMetadata;
        OpenSearchIntegTestCase testCase,
                        OpenSearchIntegTestCase.randomIntBetween(0, 1000)
            .put("index.pluggable.dataformat.enabled", true)
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
        String primaryFormat,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                    return 0L;
    }
        String indexName,
                OpenSearchIntegTestCase.client()
import org.opensearch.index.engine.exec.WriterFileSet;
    public static DataFormatAwareEngine getEngine(ClusterService clusterService, InternalTestCluster cluster, String indexName) {
            );
    }
import org.opensearch.index.shard.IndexShardTestCase;
     * {@link WriterFileSet#numRows()} from the catalog snapshot, since the file footer's
     */
            .get();
 * Shared utility methods for composite engine integration tests.
import org.opensearch.index.shard.IndexShard;
import static org.junit.Assert.assertEquals;
     * resolve {@link DataFormat} via {@link DataFormatRegistry}.
     * delete primitive in this codebase yet — we fall back to summing
        Settings.Builder sb = Settings.builder()
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    }
                    .setSource(
                assertEquals("segment gen=" + seg.generation() + " row counts must match", wfs1.numRows(), wfs2.numRows());
import org.opensearch.test.OpenSearchIntegTestCase;
public final class CompositeEngineHelper {
        for (int i = 0; i < count; i++) {
                Object raw = ref.get().reader(luceneFormat);
     */
import org.opensearch.cluster.ClusterState;
        OpenSearchIntegTestCase.client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
                    );
    // -- Flush --
        ClusterState state = clusterService.state();
import org.opensearch.be.lucene.LuceneReader;
                return ((LuceneReader) raw).directoryReader().numDocs();
            .put("index.pluggable.dataformat.enabled", true)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
/**
        Settings.Builder sb = Settings.builder()
            try (GatedCloseable<IndexReaderProvider.Reader> ref = engine.acquireReader()) {
     *
        return (DataFormatAwareEngine) IndexShardTestCase.getIndexer(getPrimaryShard(clusterService, cluster, indexName));
    // -- Assertions --
 */
 */
            String nodeName = clusterService.state().nodes().get(nodeId).getName();
import org.opensearch.common.settings.Settings;
        }
     * numRows IS the authoritative source for a Parquet file.
        String primaryFormat,
            .prepareCreate(indexName)
import org.opensearch.index.engine.dataformat.DataFormat;
        OpenSearchIntegTestCase.client()
 * SPDX-License-Identifier: Apache-2.0
        Settings extraSettings,
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
            .indices()
                WriterFileSet wfs2 = seg.dfGroupedSearchableFiles().get(format2);
import org.opensearch.index.IndexService;
        sb.putList("index.composite.secondary_data_formats", secondaryFormats);
    public static void createCompositeIndex(
    }
    }
     * Parquet/file-metadata path. The Lucene branch routes through
            DataFormat luceneFormat = new DataFormatRegistry(cluster.getInstance(PluginsService.class, nodeName)).format(formatName);
 *
    ) {
import org.opensearch.index.engine.exec.Segment;
        testCase.ensureGreen(indexName);
        sb.putList("index.composite.secondary_data_formats", secondaryFormats);
import org.apache.lucene.index.DirectoryReader;
                    .prepareIndex(indexName)
            .admin()
                if (raw instanceof LuceneReader == false) {
     * {@link #getRowCount(ClusterService, InternalTestCluster, String, String)} which can
        return svc.getShard(0);
 * compatible open source license.
                }
        String indexName,
                        "field_number",
            .put("index.pluggable.dataformat", "composite")
    public static void assertPerSegmentRowCountsMatch(DataFormatAwareEngine engine, String format1, String format2) throws IOException {
            return ref.get().getSearchableFiles(formatName).stream().mapToLong(WriterFileSet::numRows).sum();
                    throw new IllegalStateException(
    }
        }
     * <p>For Lucene we use {@link DirectoryReader#numDocs()} which excludes soft-deleted
import org.opensearch.index.engine.DataFormatAwareEngine;
    public static long getRowCount(DataFormatAwareEngine engine, String formatName) throws IOException {
     * Returns the total live-doc count for a format by querying its actual reader.
                        "Expected LuceneReader for format [" + formatName + "] but got " + raw.getClass().getName()
            .put("index.composite.primary_data_format", primaryFormat);
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
package org.opensearch.composite;
            return ref.get().getSearchableFiles(formatName).stream().mapToLong(WriterFileSet::numRows).sum();
    public static void createCompositeIndexWithMapping(
/*
            .put("index.pluggable.dataformat", "composite")
    // -- Index creation --
        String... secondaryFormats
                WriterFileSet wfs1 = seg.dfGroupedSearchableFiles().get(format1);
 * Stateless — all methods take explicit parameters so any IT can use them.
    private CompositeEngineHelper() {}
    }
                        "field_keyword",
            .setSettings(sb)
            }
            .put("index.composite.primary_data_format", primaryFormat)
import org.opensearch.plugins.PluginsService;
                if (raw == null) {
                assertNotNull("segment gen=" + seg.generation() + " missing " + format2, wfs2);
    }
            .indexServiceSafe(state.metadata().index(indexName).getIndex());
                RestStatus.CREATED,
    public static long getRowCount(ClusterService clusterService, InternalTestCluster cluster, String indexName, String formatName)
    public static IndexShard getPrimaryShard(ClusterService clusterService, InternalTestCluster cluster, String indexName) {
