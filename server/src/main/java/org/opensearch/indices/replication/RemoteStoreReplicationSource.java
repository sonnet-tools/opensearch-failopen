import org.opensearch.index.shard.IndexShard;
            } else {
            if (mdFile == null) {
 */
 * compatible open source license.
import java.util.function.BiConsumer;
        List<StoreFileMetadata> filesToFetch,
        FilterDirectory byteSizeCachingStoreDirectory = (FilterDirectory) remoteStoreDirectory.getDelegate();
                    () -> new ParameterizedMessage(
                            return new GetSegmentFilesResponse(filesToFetch);
        ActionListener<GetSegmentFilesResponse> listener
                            e.getValue().getLength(),
        this.indexShard = indexShard;
                    listener.onResponse(
import org.opensearch.index.store.DataFormatAwareStoreDirectory;
        ReplicationCheckpoint checkpoint,
    @Override
                            version,
}
        }
import org.apache.lucene.store.FilterDirectory;
            metadataMap = mdFile.getMetadata()
        final Directory storeDirectory = indexShard.store().directory();
                // have metadata as primary hasn't uploaded anything yet.
    }
        indexShard.getFileDownloader()
        return metadataExists.get();
                final Collection<String> directoryFiles = List.of(storeDirectory.listAll());
            }
    private RemoteSegmentMetadata getRemoteSegmentMetadata() throws IOException {
package org.opensearch.indices.replication;
 */
                indexShard.getFileDownloader()
     **/
        try (GatedCloseable<CatalogSnapshot> catalogSnapshotRef = indexShard.getCatalogSnapshot()) {
                final Directory storeDirectory = indexShard.store().directory();
                return;
            listener.onFailure(e);
        FilterDirectory remoteStoreDirectory = (FilterDirectory) indexShard.remoteStore().directory();
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
    /**
import java.util.stream.Collectors;
                                Map<String, String> fileToChecksum = new HashMap<>();
                    latch.countDown();
    public String getDescription() {
                })
    @Override
                }, e -> {
                            // Seed the precomputed checksum cache with downloaded files' checksums
        long replicationId,
                        toDownloadSegmentNames
                        new CheckpointInfoResponse(indexShard.getLatestReplicationCheckpoint(), Collections.emptyMap(), null)
        CountDownLatch latch = new CountDownLatch(1);
                cancellableThreads,
import org.opensearch.index.engine.exec.coord.LuceneVersionConverter;
                remoteDirectory,
 * @opensearch.internal
    public void getMergedSegmentFiles(
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadata;
                    assert directoryFiles.contains(file) == false : "Local store already contains the file " + file;
        cancellableThreads.executeIO(() -> mdFile.set(remoteDirectory.init()));
import org.opensearch.core.action.ActionListener;
                        new IllegalStateException("Remote metadata file can't be null if shard is active: " + indexShard.shardId())
    public void getCheckpointMetadata(
                listener.onResponse(new GetSegmentFilesResponse(Collections.emptyList()));
                        e -> new StoreFileMetadata(
        ActionListener<CheckpointInfoResponse> listener
        // TODO: Need to figure out a way to pass this information for segment metadata via remote store.
                TimeUnit.MILLISECONDS
        List<StoreFileMetadata> filesToFetch,
        }
                logger.warn(
            );
        this.cancellableThreads.cancel("Canceled by target");
        long replicationId,
            .downloadAsync(
import org.apache.lucene.util.Version;
 * The OpenSearch Contributors require contributions made to
                    notifyOnceListener.onFailure(e);
    private boolean remoteMetadataExists() throws IOException {
                            e.getValue().getOriginalFilename(),
                        cancellableThreads,
                                    if (toDownloadSegmentNames.contains(name)) {
    @Override
                    String file = fileMetadata.name();
                            Store.digestToString(Long.valueOf(e.getValue().getChecksum())),
import org.opensearch.index.shard.IndexShardState;
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
            listener.onFailure(e);
                final List<String> toDownloadSegmentNames = new ArrayList<>();
        }
        AtomicReference<RemoteSegmentMetadata> mdFile = new AtomicReference<>();
                                    }
                    listener.onResponse(new CheckpointInfoResponse(checkpoint, Collections.emptyMap(), null));
        BiConsumer<String, Long> fileProgressTracker,
    ) {
    }
                            // from remote metadata so subsequent lookups hit O(1).
import java.util.ArrayList;
        final AtomicBoolean metadataExists = new AtomicBoolean(false);
import java.util.concurrent.CountDownLatch;
        } catch (IOException | RuntimeException e) {
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
 * this file be licensed under the Apache-2.0 license or a
                    logger.debug("Search-only replica proceeding without remote metadata: {}", indexShard.shardId());
            notifyOnceListener.onFailure(e);
                    );
                            if (dfasd != null) {
        Map<String, StoreFileMetadata> metadataMap;
import org.apache.logging.log4j.Logger;
                            }
    private final IndexShard indexShard;
        IndexShard indexShard,
            }
                        toDownloadSegmentNames,
import java.util.Map;
import java.util.concurrent.TimeUnit;
                        e -> e.getKey(),
import org.opensearch.common.concurrent.GatedCloseable;
    private final CancellableThreads cancellableThreads = new CancellableThreads();
import java.util.HashMap;
        assert checkpoint instanceof RemoteStoreMergedSegmentCheckpoint;
import org.opensearch.index.store.StoreFileMetadata;
                }
import java.util.concurrent.TimeoutException;
                for (StoreFileMetadata fileMetadata : filesToFetch) {
    public void cancel() {
                                        fileToChecksum.put(name, meta.getChecksum());
                } else {
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));
                        "Merged segments download from remote store timed out. Segments: {}",
                                dfasd.registerDownloadedChecksums(fileToChecksum);
import org.opensearch.common.util.CancellableThreads;
        } catch (Exception e) {
                toDownloadSegmentNames,
 * Implementation of a {@link SegmentReplicationSource} where the source is remote store.
public class RemoteStoreReplicationSource implements SegmentReplicationSource {
    public RemoteStoreReplicationSource(IndexShard indexShard) {
        } catch (InterruptedException e) {
     * {@inheritDoc}
    private final RemoteSegmentStoreDirectory remoteDirectory;
                .collect(
            if (filesToFetch.isEmpty()) {
                }
                    latch.countDown();
/**
                    .downloadAsync(
                .entrySet()
                    // Non-started shard during recovery
                        })
                    Collectors.toMap(
            }
                } else if (indexShard.routingEntry().isSearchOnly()) {
                    )
            listener.onResponse(new CheckpointInfoResponse(mdFile.getReplicationCheckpoint(), metadataMap, mdFile.getSegmentInfosBytes()));
        ReplicationCheckpoint checkpoint,
import org.apache.logging.log4j.LogManager;
                    listener.onFailure(
/*
        IndexShard indexShard,
            logger.debug("Downloading segment files from remote store {}", filesToFetch);
                        )
        BiConsumer<String, Long> fileProgressTracker,
                                remoteDirectory.getSegmentsUploadedToRemoteStore().forEach((name, meta) -> {
 * SPDX-License-Identifier: Apache-2.0
            }
import org.opensearch.index.store.Store;
            if (latch.await(
        try {
                    // Allow search-only replicas to become active without metadata
                ActionListener.wrap(r -> {
                    return;
    }
                    toDownloadSegmentNames.add(file);
            if (remoteMetadataExists()) {
    ) {
                if (indexShard.state().equals(IndexShardState.STARTED) == false) {
                );
            final Version version = LuceneVersionConverter.toLuceneOrLatest(catalogSnapshotRef.get().getCommitDataFormatVersion());
                        new ReplicationStatsDirectoryWrapper(storeDirectory, fileProgressTracker),
            final RemoteSegmentMetadata mdFile = getRemoteSegmentMetadata();
            ) == false) {
            // Handle null metadata file case
        ActionListener<GetSegmentFilesResponse> listener
                    return;
            logger.warn(() -> new ParameterizedMessage("Exception thrown while trying to get merged segment files. Continuing. {}", e));
import java.util.concurrent.atomic.AtomicReference;
                .stream()
                indexShard.getRecoverySettings().getMergedSegmentReplicationTimeout().millis(),
    ) {
    }
import org.opensearch.indices.replication.checkpoint.RemoteStoreMergedSegmentCheckpoint;
    }
    }
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
                    )
                                });
import java.util.Collections;
 *
        return "RemoteStoreReplicationSource";
        ReplicationCheckpoint checkpoint,
                notifyOnceListener.onFailure(new TimeoutException("Timed out waiting for merged segments download from remote store"));
import org.apache.logging.log4j.message.ParameterizedMessage;
    }
                // During initial recovery flow, the remote store might not
                    // Regular replicas should not be active without metadata
                    );
        long replicationId,
                        ActionListener.map(listener, r -> {
    private static final Logger logger = LogManager.getLogger(RemoteStoreReplicationSource.class);
                    );
                );
                new ReplicationStatsDirectoryWrapper(storeDirectory, fileProgressTracker),
        try {
    }
        ActionListener<GetSegmentFilesResponse> notifyOnceListener = ActionListener.notifyOnce(listener);
                        remoteDirectory,
    public void getSegmentFiles(
        List<String> toDownloadSegmentNames = filesToFetch.stream().map(StoreFileMetadata::name).toList();
        return mdFile.get();
    @Override
                    return;
        cancellableThreads.executeIO(() -> metadataExists.set(remoteDirectory.readLatestMetadataFile() != null));
                    notifyOnceListener.onResponse(new GetSegmentFilesResponse(filesToFetch));
    @Override
        this.remoteDirectory = (RemoteSegmentStoreDirectory) byteSizeCachingStoreDirectory.getDelegate();
import java.io.IOException;
                            DataFormatAwareStoreDirectory dfasd = DataFormatAwareStoreDirectory.unwrap(storeDirectory);
import org.apache.lucene.store.Directory;
            // Process metadata when it exists
                            null
 *
import java.util.Collection;
