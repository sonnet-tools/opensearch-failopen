    }  
                })
    }
        this.cancellableThreads.cancel("Canceled by target");  
    @Override
                listener.onResponse(new GetSegmentFilesResponse(Collections.emptyList()));
import org.opensearch.common.concurrent.GatedCloseable;
                    listener.onFailure(  
        } catch (IOException | RuntimeException e) {  
import java.util.Map;
                    .downloadAsync(  
            ) == false) {
import java.util.Collection;  
import org.apache.logging.log4j.Logger;
                }, e -> {
import java.util.concurrent.TimeUnit;  
    public RemoteStoreReplicationSource(IndexShard indexShard) {
                            e.getValue().getLength(),
    private RemoteSegmentMetadata getRemoteSegmentMetadata() throws IOException {
        FilterDirectory byteSizeCachingStoreDirectory = (FilterDirectory) remoteStoreDirectory.getDelegate();
                    );
import org.opensearch.index.store.Store;
        try {
    ) {
    }  
import org.apache.lucene.store.FilterDirectory;
        // TODO: Need to figure out a way to pass this information for segment metadata via remote store.
                } else {
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadata;  
                        new IllegalStateException("Remote metadata file can't be null if shard is active: " + indexShard.shardId())
                            e.getValue().getOriginalFilename(),  
        final AtomicBoolean metadataExists = new AtomicBoolean(false);  
package org.opensearch.indices.replication;
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));
 *
                if (indexShard.state().equals(IndexShardState.STARTED) == false) {
        IndexShard indexShard,
                    latch.countDown();
import java.util.function.BiConsumer;
                            // from remote metadata so subsequent lookups hit O(1).
                indexShard.getRecoverySettings().getMergedSegmentReplicationTimeout().millis(),
 * The OpenSearch Contributors require contributions made to  
        long replicationId,
                    )
    private final IndexShard indexShard;
        return mdFile.get();
        } catch (Exception e) {  
 * this file be licensed under the Apache-2.0 license or a
        IndexShard indexShard,
                toDownloadSegmentNames,  
    private static final Logger logger = LogManager.getLogger(RemoteStoreReplicationSource.class);
                .collect(
        ReplicationCheckpoint checkpoint,
import org.apache.logging.log4j.message.ParameterizedMessage;  
                                dfasd.registerDownloadedChecksums(fileToChecksum);
                            return new GetSegmentFilesResponse(filesToFetch);  
        ReplicationCheckpoint checkpoint,
        cancellableThreads.executeIO(() -> mdFile.set(remoteDirectory.init()));
                        ActionListener.map(listener, r -> {
                TimeUnit.MILLISECONDS  
                        toDownloadSegmentNames,
        this.remoteDirectory = (RemoteSegmentStoreDirectory) byteSizeCachingStoreDirectory.getDelegate();  
    public void getMergedSegmentFiles(  
                                    if (toDownloadSegmentNames.contains(name)) {  
import org.opensearch.indices.replication.checkpoint.RemoteStoreMergedSegmentCheckpoint;
    /**
    }
import org.opensearch.index.shard.IndexShard;  
        CountDownLatch latch = new CountDownLatch(1);  
                cancellableThreads,  
    public void cancel() {
        return metadataExists.get();
import java.util.List;  
            }  
        ReplicationCheckpoint checkpoint,  
                final Collection<String> directoryFiles = List.of(storeDirectory.listAll());
                    // Regular replicas should not be active without metadata
                            Store.digestToString(Long.valueOf(e.getValue().getChecksum())),
    ) {
        try {  
            .downloadAsync(
        List<StoreFileMetadata> filesToFetch,  
                        })
                    listener.onResponse(new CheckpointInfoResponse(checkpoint, Collections.emptyMap(), null));
                final Directory storeDirectory = indexShard.store().directory();  
                                    }
    private final RemoteSegmentStoreDirectory remoteDirectory;
        BiConsumer<String, Long> fileProgressTracker,
        }
        ActionListener<CheckpointInfoResponse> listener
                    // Non-started shard during recovery  
                // During initial recovery flow, the remote store might not  
                            }
import java.util.stream.Collectors;
                    () -> new ParameterizedMessage(
            );
     * {@inheritDoc}  
                        new ReplicationStatsDirectoryWrapper(storeDirectory, fileProgressTracker),  
import org.opensearch.index.shard.IndexShardState;
            final Version version = LuceneVersionConverter.toLuceneOrLatest(catalogSnapshotRef.get().getCommitDataFormatVersion());
    public void getSegmentFiles(  
    }  
        BiConsumer<String, Long> fileProgressTracker,
                } else if (indexShard.routingEntry().isSearchOnly()) {  
import org.apache.lucene.util.Version;  
import java.util.Collections;
    }  
import org.opensearch.common.util.CancellableThreads;
                    )  
import org.opensearch.core.action.ActionListener;  
                        toDownloadSegmentNames  
        long replicationId,
            logger.debug("Downloading segment files from remote store {}", filesToFetch);
                notifyOnceListener.onFailure(new TimeoutException("Timed out waiting for merged segments download from remote store"));
                    notifyOnceListener.onResponse(new GetSegmentFilesResponse(filesToFetch));  
                    String file = fileMetadata.name();
                .entrySet()  
    }
import java.util.concurrent.TimeoutException;
}
            if (mdFile == null) {
                    return;
            // Handle null metadata file case
            }  
                    // Allow search-only replicas to become active without metadata
        ActionListener<GetSegmentFilesResponse> listener  
        assert checkpoint instanceof RemoteStoreMergedSegmentCheckpoint;
        final Directory storeDirectory = indexShard.store().directory();
                }
    }  
            final RemoteSegmentMetadata mdFile = getRemoteSegmentMetadata();
                // have metadata as primary hasn't uploaded anything yet.
        AtomicReference<RemoteSegmentMetadata> mdFile = new AtomicReference<>();  
                    assert directoryFiles.contains(file) == false : "Local store already contains the file " + file;
        Map<String, StoreFileMetadata> metadataMap;  
    public String getDescription() {
                            // Seed the precomputed checksum cache with downloaded files' checksums  
import java.io.IOException;
import org.opensearch.index.engine.exec.coord.LuceneVersionConverter;
 * @opensearch.internal
import org.apache.lucene.store.Directory;
            if (latch.await(
 *  
            if (remoteMetadataExists()) {
            listener.onFailure(e);
        cancellableThreads.executeIO(() -> metadataExists.set(remoteDirectory.readLatestMetadataFile() != null));
                                        fileToChecksum.put(name, meta.getChecksum());
                        "Merged segments download from remote store timed out. Segments: {}",
                );
                    Collectors.toMap(  
import java.util.concurrent.atomic.AtomicReference;  
import java.util.ArrayList;
                    return;  
 * SPDX-License-Identifier: Apache-2.0
        try (GatedCloseable<CatalogSnapshot> catalogSnapshotRef = indexShard.getCatalogSnapshot()) {
                        e -> new StoreFileMetadata(
import org.opensearch.index.store.DataFormatAwareStoreDirectory;
import org.opensearch.index.store.StoreFileMetadata;
 * compatible open source license.
        }
/*  
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
                    );
                    toDownloadSegmentNames.add(file);  
                remoteDirectory,
                    listener.onResponse(  
                new ReplicationStatsDirectoryWrapper(storeDirectory, fileProgressTracker),
    @Override
                        )
import java.util.concurrent.CountDownLatch;
    private boolean remoteMetadataExists() throws IOException {
        return "RemoteStoreReplicationSource";
                    );
                    notifyOnceListener.onFailure(e);  
                            if (dfasd != null) {  
 */  
            } else {  
                ActionListener.wrap(r -> {
                );
            }
                }
                        remoteDirectory,
     **/
                .stream()
/**
        List<String> toDownloadSegmentNames = filesToFetch.stream().map(StoreFileMetadata::name).toList();
            // Process metadata when it exists
    @Override  
        FilterDirectory remoteStoreDirectory = (FilterDirectory) indexShard.remoteStore().directory();
                                remoteDirectory.getSegmentsUploadedToRemoteStore().forEach((name, meta) -> {
        }
 * Implementation of a {@link SegmentReplicationSource} where the source is remote store.
            notifyOnceListener.onFailure(e);
                        e -> e.getKey(),
            metadataMap = mdFile.getMetadata()
        long replicationId,
    public void getCheckpointMetadata(
import java.util.concurrent.atomic.AtomicBoolean;
        } catch (InterruptedException e) {
import java.util.HashMap;
    @Override
        List<StoreFileMetadata> filesToFetch,  
                for (StoreFileMetadata fileMetadata : filesToFetch) {  
    private final CancellableThreads cancellableThreads = new CancellableThreads();  
    ) {
                        cancellableThreads,
import org.opensearch.index.store.RemoteSegmentStoreDirectory;  
            }
                    return;  
            logger.warn(() -> new ParameterizedMessage("Exception thrown while trying to get merged segment files. Continuing. {}", e));  
 */
    @Override  
import org.apache.logging.log4j.LogManager;
                                });  
                            null
        indexShard.getFileDownloader()
        this.indexShard = indexShard;  
            listener.onFailure(e);
                            version,  
        ActionListener<GetSegmentFilesResponse> notifyOnceListener = ActionListener.notifyOnce(listener);
                final List<String> toDownloadSegmentNames = new ArrayList<>();
                                Map<String, String> fileToChecksum = new HashMap<>();
                return;
                    latch.countDown();
                indexShard.getFileDownloader()
            if (filesToFetch.isEmpty()) {  
        ActionListener<GetSegmentFilesResponse> listener  
                logger.warn(  
public class RemoteStoreReplicationSource implements SegmentReplicationSource {  
            listener.onResponse(new CheckpointInfoResponse(mdFile.getReplicationCheckpoint(), metadataMap, mdFile.getSegmentInfosBytes()));
                        new CheckpointInfoResponse(indexShard.getLatestReplicationCheckpoint(), Collections.emptyMap(), null)
                    logger.debug("Search-only replica proceeding without remote metadata: {}", indexShard.shardId());
                            DataFormatAwareStoreDirectory dfasd = DataFormatAwareStoreDirectory.unwrap(storeDirectory);
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
