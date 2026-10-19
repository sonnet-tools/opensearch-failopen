        createDfaIndex(0);
        prepareCluster(1, 1, Settings.EMPTY);
                    "expected non-empty SegmentInfos bytes at cycle " + iteration,
            assertFalse("expected non-empty metadata map", metadataMap.isEmpty());
 * this file be licensed under the Apache-2.0 license or a
        ).collect(Collectors.toList());
    /** Indexes {@code count} docs with predictable fields. */
            // Upload map populated + includes parquet.
            .build();
        long previousVersion = -1L;
                previousFlushVersion = primary.getRemoteDirectory()
                    long version = metadata.getReplicationCheckpoint().getSegmentInfosVersion();
                DataFusionPlugin.class
        for (int i = 0; i < isFlush.length; i++) {
            client().admin().indices().prepareFlush(INDEX_NAME).get();
import org.opensearch.index.store.RemoteSegmentStoreDirectory.UploadedSegmentMetadata;
    /**
                ParquetDataFormatPlugin.class,
import java.util.Map;
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        createDfaIndex(0);
    public void testUploadVersionAdvancesAcrossFlushCycles() throws Exception {
    }
 * The OpenSearch Contributors require contributions made to
                assertFalse("FileMetadata.dataFormat() must be non-empty for " + fileKey, fm.dataFormat().isEmpty());
    /**
    protected static final String INDEX_NAME = "dfa-upload-test-idx";
                RemoteSegmentMetadata metadata = primary.getRemoteDirectory().readLatestMetadataFile();
        client().admin().indices().prepareFlush(INDEX_NAME).get();
                ArrowBasePlugin.class,
    /** Data node hosting the primary (replicaCount=0 so the only data node is it). */
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                }, 60, TimeUnit.SECONDS);
                client().admin().indices().prepareFlush(INDEX_NAME).get();
                    assertTrue(
            .put(remoteStoreIndexSettings(replicaCount, 1))
            .put(super.nodeSettings(nodeOrdinal))
    /** Extract the set of distinct data formats from an uploaded-segments map. */
                    DataFormatAwareITUtils.assertCatalogMatchesUploadedBlobs(primary, client(), getNodeSettings(), segmentRepoPath);
    }
        prepareCluster(1, 1, Settings.EMPTY);
        final IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
            assertFalse("refresh alone must populate the upload map", uploaded.isEmpty());
            assertNotNull("expected metadata file", metadata);
                final long capturedPrev = previousFlushVersion;
            Map<String, UploadedSegmentMetadata> metadataMap = metadata.getMetadata();
import java.util.Set;
                        "version must strictly advance at step " + iteration + ": previous=" + capturedPrev + ", current=" + version,
        ensureYellowAndNoInitializingShards(INDEX_NAME);
import java.util.stream.Collectors;
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
            assertNotNull("expected non-null ReplicationCheckpoint", metadata.getReplicationCheckpoint());
    public void testPrimaryUploadIsConsistentAfterFlush() throws Exception {
            final long capturedPrev = previousVersion;
import java.util.concurrent.TimeUnit;
            }, 60, TimeUnit.SECONDS);
        final IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
                assertNotNull("expected metadata at cycle " + iteration, metadata);
        }, 60, TimeUnit.SECONDS);
            .put("index.pluggable.dataformat.enabled", true)
        boolean[] isFlush = { false, false, true, false, true, true };
            assertTrue(
            Map<String, UploadedSegmentMetadata> uploaded = primary.getRemoteDirectory().getSegmentsUploadedToRemoteStore();
        return Settings.builder()
            }
    }
import org.opensearch.be.lucene.LucenePlugin;
/**
            .put("index.pluggable.dataformat", "composite")
    protected void createDfaIndex(int replicaCount) throws Exception {
        prepareCluster(1, 1, Settings.EMPTY);
import java.util.stream.Stream;
        }
                long version = metadata.getReplicationCheckpoint().getSegmentInfosVersion();
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(replicaCount)).get();
                    metadata.getSegmentInfosBytes() != null && metadata.getSegmentInfosBytes().length > 0
    protected String primaryNodeName() {
                CompositeDataFormatPlugin.class,
                    RemoteSegmentMetadata metadata = primary.getRemoteDirectory().readLatestMetadataFile();
        createDfaIndex(0);
import org.opensearch.be.datafusion.DataFusionPlugin;
            Map<String, UploadedSegmentMetadata> uploaded = primary.getRemoteDirectory().getSegmentsUploadedToRemoteStore();
    /**
    /**
            )
 * ITs for DataFormatAwareEngine remote upload. Single primary, no replica; {@code Scope.TEST}
    }
}
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
    public void testUploadAfterRefreshOnly() throws Exception {
    }
 * per test. Requires {@code -Dsandbox.enabled=true}.
                .get();
            indexDocs(5);
import org.opensearch.indices.replication.common.ReplicationType;
        indexDocs(randomIntBetween(10, 30));
import org.opensearch.common.settings.Settings;
import org.opensearch.parquet.ParquetDataFormatPlugin;
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadata;
        }, 60, TimeUnit.SECONDS);
                final int iteration = i;
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
                    "version should strictly advance at cycle " + iteration + ": previous=" + capturedPrev + ", current=" + version,
                assertBusy(() -> {
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
                DataFormatAwareITUtils.assertCatalogMatchesUploadedBlobs(primary, client(), getNodeSettings(), segmentRepoPath);
            super.nodePlugins().stream(),
            // Remote metadata file round-trip: non-null, non-empty SegmentInfos bytes, has ReplicationCheckpoint.
                FileMetadata fm = new FileMetadata(fileKey);
 * SPDX-License-Identifier: Apache-2.0
                );
     * Across multiple flush cycles the checkpoint's {@code segmentInfosVersion} strictly advances,
        final IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
        for (int i = 0; i < 5; i++) {
                client().admin().indices().prepareRefresh(INDEX_NAME).get();
     * Refresh without flush: the DFA engine publishes segments to the remote upload map without
import org.opensearch.common.util.FeatureFlags;
                assertNotNull("FileMetadata.dataFormat() must be non-null for " + fileKey, fm.dataFormat());
            // Every file key in the metadata map has a non-empty dataFormat.
        prepareCluster(1, 1, Settings.EMPTY);
        // Pattern: refresh, refresh, flush, refresh, flush, flush.
     */
    }
     * SegmentInfos bytes stay non-empty, and the catalog↔upload tier agreement holds each cycle.
    }
 * compatible open source license.
     */
     * requiring a flush. Validates the refresh-only path end-to-end.
                    .getReplicationCheckpoint()
import java.util.List;
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
     * non-empty upload map, parquet present, non-empty SegmentInfos bytes, a ReplicationCheckpoint,
            Stream.of(
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                    .getSegmentInfosVersion();
import org.opensearch.index.shard.IndexShard;
import java.util.Collection;
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
     * Mixed refresh + flush sequence. Every flush publishes a metadata file whose
        }
     * {@code segmentInfosVersion} strictly advances over the previous flush, even when
    }
     * agreement holds. Consolidates what were individual single-invariant tests.
        ensureGreen(INDEX_NAME);
package org.opensearch.composite;
     * interleaved with refresh-only rounds.
            // Catalog↔upload-map↔blob-store tier agreement.
import org.opensearch.test.OpenSearchIntegTestCase;
                );
public class DataFormatAwareUploadIT extends RemoteStoreBaseIntegTestCase {
    protected Settings dfaIndexSettings(int replicaCount) {
import org.opensearch.index.store.FileMetadata;
 */
     */
            assertTrue("expected parquet in uploaded formats, got " + formatsOf(uploaded), formatsOf(uploaded).contains("parquet"));
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
                    assertNotNull("expected metadata after flush at step " + iteration, metadata);
 *
        for (int i = 0; i < count; i++) {
                assertTrue(
 */
                        version > capturedPrev
            .put("index.composite.primary_data_format", "parquet")
            if (isFlush[i]) {
    @Override
            .build();
        long previousFlushVersion = -1L;
            }
     * After a single flush, the primary's remote upload is consistent on every observable front:
            }
        return Stream.concat(
        assertBusy(() -> {
     */
     * every upload-map key has a non-empty {@code dataFormat}, and the catalog↔upload-map↔blob-store
        return internalCluster().getDataNodeNames().iterator().next();
            assertTrue("expected parquet in uploaded formats, got " + formatsOf(uploaded), formatsOf(uploaded).contains("parquet"));
                assertTrue(
            assertBusy(() -> {
        indexDocs(randomIntBetween(10, 30));
            DataFormatAwareITUtils.assertCatalogMatchesUploadedBlobs(primary, client(), getNodeSettings(), segmentRepoPath);
    /** Creates {@link #INDEX_NAME} with the DFA settings and waits for green. */
                LucenePlugin.class,
                client().admin().indices().prepareRefresh(INDEX_NAME).get();
    }
                    version > capturedPrev
import org.opensearch.cluster.metadata.IndexMetadata;
            );
        return segments.keySet().stream().map(file -> new FileMetadata(file).dataFormat()).collect(Collectors.toSet());
/*
            for (String fileKey : metadataMap.keySet()) {
        }
    protected void indexDocs(int count) {
                    );
                    .readLatestMetadataFile()
            indexDocs(5);
        assertBusy(() -> {
    /** Index settings for a 1-shard composite(parquet) index with remote store + segment replication. */
            if (isFlush[i]) {
    }
            RemoteSegmentMetadata metadata = primary.getRemoteDirectory().readLatestMetadataFile();
    }
            final int iteration = i;
            } else {
                "expected non-empty SegmentInfos bytes",
    public void testMixedRefreshAndFlushCycles() throws Exception {
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        final IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
import org.opensearch.plugins.Plugin;
            previousVersion = primary.getRemoteDirectory().readLatestMetadataFile().getReplicationCheckpoint().getSegmentInfosVersion();
    protected Settings nodeSettings(int nodeOrdinal) {
    @Override
                .setSource("field_text", randomAlphaOfLength(10), "field_keyword", randomAlphaOfLength(10), "field_number", (long) i)
            client().prepareIndex(INDEX_NAME)
            assertFalse("expected uploaded segments, got empty map", uploaded.isEmpty());
        createDfaIndex(0);
    protected static Set<String> formatsOf(Map<String, UploadedSegmentMetadata> segments) {
        return Settings.builder()
                metadata.getSegmentInfosBytes() != null && metadata.getSegmentInfosBytes().length > 0
