        return Settings.builder()
            if (isFlush[i]) {
            client().admin().indices().prepareFlush(INDEX_NAME).get();  
    @Override
import java.util.Map;
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
            .put(remoteStoreIndexSettings(replicaCount, 1))
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(replicaCount)).get();
            Stream.of(
                );
            .build();
        createDfaIndex(0);  
     */
    /** Indexes {@code count} docs with predictable fields. */  
        final IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);  
            assertNotNull("expected metadata file", metadata);
                LucenePlugin.class,  
                client().admin().indices().prepareFlush(INDEX_NAME).get();
        createDfaIndex(0);
                .setSource("field_text", randomAlphaOfLength(10), "field_keyword", randomAlphaOfLength(10), "field_number", (long) i)
                final long capturedPrev = previousFlushVersion;  
                final int iteration = i;
 * this file be licensed under the Apache-2.0 license or a
 */
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
            // Catalog↔upload-map↔blob-store tier agreement.  
import org.opensearch.common.util.FeatureFlags;  
import org.opensearch.parquet.ParquetDataFormatPlugin;  
        createDfaIndex(0);  
    }
            RemoteSegmentMetadata metadata = primary.getRemoteDirectory().readLatestMetadataFile();
     * non-empty upload map, parquet present, non-empty SegmentInfos bytes, a ReplicationCheckpoint,  
            final int iteration = i;
}
            }
    protected Settings nodeSettings(int nodeOrdinal) {
    }  
            assertTrue("expected parquet in uploaded formats, got " + formatsOf(uploaded), formatsOf(uploaded).contains("parquet"));
import org.opensearch.plugins.Plugin;
                    .getSegmentInfosVersion();  
    }  
                    .readLatestMetadataFile()
    protected void indexDocs(int count) {
    /** Index settings for a 1-shard composite(parquet) index with remote store + segment replication. */
            client().prepareIndex(INDEX_NAME)  
            .put("index.pluggable.dataformat", "composite")
        final IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
     * agreement holds. Consolidates what were individual single-invariant tests.
                    metadata.getSegmentInfosBytes() != null && metadata.getSegmentInfosBytes().length > 0
     * Across multiple flush cycles the checkpoint's {@code segmentInfosVersion} strictly advances,  
                client().admin().indices().prepareRefresh(INDEX_NAME).get();  
package org.opensearch.composite;
import org.opensearch.common.settings.Settings;
     * interleaved with refresh-only rounds.  
    }  
    }
            .put("index.composite.primary_data_format", "parquet")  
        prepareCluster(1, 1, Settings.EMPTY);  
    public void testPrimaryUploadIsConsistentAfterFlush() throws Exception {
    }
        ).collect(Collectors.toList());  
                assertTrue(
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
/**
        prepareCluster(1, 1, Settings.EMPTY);
                "expected non-empty SegmentInfos bytes",
            for (String fileKey : metadataMap.keySet()) {  
     * Mixed refresh + flush sequence. Every flush publishes a metadata file whose
public class DataFormatAwareUploadIT extends RemoteStoreBaseIntegTestCase {  
                        version > capturedPrev
    }
import java.util.concurrent.TimeUnit;  
     */  
     * {@code segmentInfosVersion} strictly advances over the previous flush, even when
                CompositeDataFormatPlugin.class,
    public void testUploadAfterRefreshOnly() throws Exception {
        }  
        }, 60, TimeUnit.SECONDS);  
import org.opensearch.arrow.allocator.ArrowBasePlugin;
import org.opensearch.be.datafusion.DataFusionPlugin;
        prepareCluster(1, 1, Settings.EMPTY);
    /** Extract the set of distinct data formats from an uploaded-segments map. */
    public void testUploadVersionAdvancesAcrossFlushCycles() throws Exception {  
            // Remote metadata file round-trip: non-null, non-empty SegmentInfos bytes, has ReplicationCheckpoint.  
        }
 * per test. Requires {@code -Dsandbox.enabled=true}.  
                    assertNotNull("expected metadata after flush at step " + iteration, metadata);
    /** Data node hosting the primary (replicaCount=0 so the only data node is it). */  
        indexDocs(randomIntBetween(10, 30));
            Map<String, UploadedSegmentMetadata> uploaded = primary.getRemoteDirectory().getSegmentsUploadedToRemoteStore();  
        return segments.keySet().stream().map(file -> new FileMetadata(file).dataFormat()).collect(Collectors.toSet());
                previousFlushVersion = primary.getRemoteDirectory()  
    protected void createDfaIndex(int replicaCount) throws Exception {  
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
        for (int i = 0; i < 5; i++) {  
                    .getReplicationCheckpoint()
    /**
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            assertTrue(  
import org.opensearch.be.lucene.LucenePlugin;  
import java.util.stream.Stream;
                    "version should strictly advance at cycle " + iteration + ": previous=" + capturedPrev + ", current=" + version,
    protected Settings dfaIndexSettings(int replicaCount) {  
            );  
            indexDocs(5);
                .get();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
            DataFormatAwareITUtils.assertCatalogMatchesUploadedBlobs(primary, client(), getNodeSettings(), segmentRepoPath);
 *
        long previousVersion = -1L;
            Map<String, UploadedSegmentMetadata> metadataMap = metadata.getMetadata();
import org.opensearch.index.store.RemoteSegmentStoreDirectory.UploadedSegmentMetadata;  
import org.opensearch.index.store.FileMetadata;
            assertTrue("expected parquet in uploaded formats, got " + formatsOf(uploaded), formatsOf(uploaded).contains("parquet"));
                client().admin().indices().prepareRefresh(INDEX_NAME).get();
        createDfaIndex(0);
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
    /** Creates {@link #INDEX_NAME} with the DFA settings and waits for green. */
import java.util.List;  
        }  
        boolean[] isFlush = { false, false, true, false, true, true };
/*  
    }
     * After a single flush, the primary's remote upload is consistent on every observable front:
                RemoteSegmentMetadata metadata = primary.getRemoteDirectory().readLatestMetadataFile();  
                    );  
     */  
        final IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
import java.util.Set;
 * ITs for DataFormatAwareEngine remote upload. Single primary, no replica; {@code Scope.TEST}
                metadata.getSegmentInfosBytes() != null && metadata.getSegmentInfosBytes().length > 0
                assertFalse("FileMetadata.dataFormat() must be non-empty for " + fileKey, fm.dataFormat().isEmpty());  
                    version > capturedPrev  
        for (int i = 0; i < count; i++) {
 */  
     * Refresh without flush: the DFA engine publishes segments to the remote upload map without
        // Pattern: refresh, refresh, flush, refresh, flush, flush.  
                    RemoteSegmentMetadata metadata = primary.getRemoteDirectory().readLatestMetadataFile();  
                assertTrue(
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadata;
import org.opensearch.test.OpenSearchIntegTestCase;  
            )
                assertNotNull("expected metadata at cycle " + iteration, metadata);
        for (int i = 0; i < isFlush.length; i++) {
        assertBusy(() -> {
        client().admin().indices().prepareRefresh(INDEX_NAME).get();  
                ParquetDataFormatPlugin.class,
    /**  
        prepareCluster(1, 1, Settings.EMPTY);
            }, 60, TimeUnit.SECONDS);  
                    assertTrue(  
            .put(super.nodeSettings(nodeOrdinal))  
 * SPDX-License-Identifier: Apache-2.0
                ArrowBasePlugin.class,  
        ensureGreen(INDEX_NAME);  
            indexDocs(5);  
            // Every file key in the metadata map has a non-empty dataFormat.  
import org.opensearch.indices.replication.common.ReplicationType;
            .put("index.pluggable.dataformat.enabled", true)
            previousVersion = primary.getRemoteDirectory().readLatestMetadataFile().getReplicationCheckpoint().getSegmentInfosVersion();
 * The OpenSearch Contributors require contributions made to  
            }
                DataFusionPlugin.class
            assertNotNull("expected non-null ReplicationCheckpoint", metadata.getReplicationCheckpoint());
        long previousFlushVersion = -1L;
            // Upload map populated + includes parquet.
    /**
    }  
                FileMetadata fm = new FileMetadata(fileKey);
     * SegmentInfos bytes stay non-empty, and the catalog↔upload tier agreement holds each cycle.
                long version = metadata.getReplicationCheckpoint().getSegmentInfosVersion();  
    }  
            Map<String, UploadedSegmentMetadata> uploaded = primary.getRemoteDirectory().getSegmentsUploadedToRemoteStore();
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
                assertNotNull("FileMetadata.dataFormat() must be non-null for " + fileKey, fm.dataFormat());
                    long version = metadata.getReplicationCheckpoint().getSegmentInfosVersion();
    /**  
    protected String primaryNodeName() {
                    "expected non-empty SegmentInfos bytes at cycle " + iteration,  
    @Override  
                }, 60, TimeUnit.SECONDS);
                DataFormatAwareITUtils.assertCatalogMatchesUploadedBlobs(primary, client(), getNodeSettings(), segmentRepoPath);
            super.nodePlugins().stream(),
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import java.util.stream.Collectors;
import java.util.Collection;
            if (isFlush[i]) {
        assertBusy(() -> {  
                );
            final long capturedPrev = previousVersion;  
        return Stream.concat(  
    protected static final String INDEX_NAME = "dfa-upload-test-idx";
import org.opensearch.cluster.metadata.IndexMetadata;
     */
    protected static Set<String> formatsOf(Map<String, UploadedSegmentMetadata> segments) {  
     * every upload-map key has a non-empty {@code dataFormat}, and the catalog↔upload-map↔blob-store
            assertFalse("expected non-empty metadata map", metadataMap.isEmpty());
        indexDocs(randomIntBetween(10, 30));
            }  
                        "version must strictly advance at step " + iteration + ": previous=" + capturedPrev + ", current=" + version,
            assertFalse("refresh alone must populate the upload map", uploaded.isEmpty());
            assertFalse("expected uploaded segments, got empty map", uploaded.isEmpty());  
    }
                    DataFormatAwareITUtils.assertCatalogMatchesUploadedBlobs(primary, client(), getNodeSettings(), segmentRepoPath);
            .build();
    public void testMixedRefreshAndFlushCycles() throws Exception {
        client().admin().indices().prepareFlush(INDEX_NAME).get();
        return internalCluster().getDataNodeNames().iterator().next();
            assertBusy(() -> {
        final IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
     * requiring a flush. Validates the refresh-only path end-to-end.
            } else {
                assertBusy(() -> {
        return Settings.builder()
import org.opensearch.index.shard.IndexShard;
        }, 60, TimeUnit.SECONDS);
 * compatible open source license.
