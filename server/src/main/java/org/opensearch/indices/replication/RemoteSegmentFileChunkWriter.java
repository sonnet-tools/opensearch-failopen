                throttleTimeInNanos = 0;
    @Override
        if (rl != null) {
            .withTimeout(recoverySettings.internalActionTimeout())
    public void cancel() {
    private final TransportRequestOptions fileChunkRequestOptions;
        final Writeable.Reader<TransportResponse.Empty> reader = in -> TransportResponse.Empty.INSTANCE;  
        this.shardId = shardId;
            action,
    private final Consumer<Long> onSourceThrottle;  
        ShardId shardId,
            lastChunk,
 */  
            }  
                bytesSinceLastPause.addAndGet(-bytes);  
        Consumer<Long> onSourceThrottle,
    public void writeFileChunk(
            requestSeqNo,  
            } else {
        retryableTransportClient.cancel();  
                    throttleTimeInNanos = rl.pause(bytes);
        Supplier<RateLimiter> rateLimiterSupplier  
        final long requestSeqNo = requestSeqNoGenerator.getAndIncrement();
                // Time to pause
        ActionListener<Void> listener
    @Override
         * would be in to restart file copy again (new deltas) if we have too many translog ops are piling up.
    ) {
        AtomicLong requestSeqNoGenerator,
        );
/*  
        /* we send estimateTotalOperations with every request since we collect stats on the target and that way we can  
            ActionListener.map(listener, r -> null),
        this.onSourceThrottle = onSourceThrottle;  
 */  
            throttleTimeInNanos = 0;
        this.fileChunkRequestOptions = TransportRequestOptions.builder()
        long position,
 * SPDX-License-Identifier: Apache-2.0
    private final String action;
import org.opensearch.OpenSearchException;
        // always fetch the ratelimiter - it might be updated in real-time on the recovery settings  
import org.opensearch.indices.recovery.FileChunkRequest;  
import java.io.IOException;  
import java.util.function.Supplier;  
            if (bytes > rl.getMinPauseCheckBytes()) {
        StoreFileMetadata fileMetadata,  
        this.replicationId = replicationId;
            totalTranslogOps,  
            request,  
        RecoverySettings recoverySettings,  
 *
            long bytes = bytesSinceLastPause.addAndGet(content.length());  
import org.opensearch.transport.TransportRequestOptions;
                }  
        retryableTransportClient.executeRetryableAction(
        BytesReference content,
        String action,  
/**
 * this file be licensed under the Apache-2.0 license or a
    public RemoteSegmentFileChunkWriter(
        );
            fileMetadata,
}
            replicationId,
    private final AtomicLong bytesSinceLastPause = new AtomicLong();
import org.opensearch.indices.recovery.FileChunkWriter;
         */  
    ) {  
        this.action = action;
                    throw new OpenSearchException("failed to pause recovery", e);
        }  
                    onSourceThrottle.accept(throttleTimeInNanos);  
        long replicationId,
        int totalTranslogOps,
        RetryableTransportClient retryableTransportClient,
            .build();
        this.rateLimiterSupplier = rateLimiterSupplier;
        } else {
            reader  
    private final RetryableTransportClient retryableTransportClient;
    }
import java.util.concurrent.atomic.AtomicLong;
 * compatible open source license.
            content,
import org.opensearch.core.transport.TransportResponse;
 * @opensearch.internal
         * see how many translog ops we accumulate while copying files across the network. A future optimization
                try {
 *
            .withType(TransportRequestOptions.Type.RECOVERY)  
import org.opensearch.index.store.StoreFileMetadata;
        final long throttleTimeInNanos;
            fileChunkRequestOptions,
    private final AtomicLong requestSeqNoGenerator;  
 * This class handles sending file chunks over the transport layer to a target shard.  
import org.opensearch.core.common.io.stream.Writeable;
                } catch (IOException e) {
        final RateLimiter rl = rateLimiterSupplier.get();
import org.opensearch.core.action.ActionListener;  
public final class RemoteSegmentFileChunkWriter implements FileChunkWriter {
        // Pause using the rate limiter, if desired, to throttle the recovery
import org.apache.lucene.store.RateLimiter;
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.indices.recovery.RecoverySettings;
    private final Supplier<RateLimiter> rateLimiterSupplier;
import org.opensearch.indices.recovery.RetryableTransportClient;  
package org.opensearch.indices.replication;
import org.opensearch.core.index.shard.ShardId;  
        final FileChunkRequest request = new FileChunkRequest(
            position,  
        this.requestSeqNoGenerator = requestSeqNoGenerator;
        this.retryableTransportClient = retryableTransportClient;  
            throttleTimeInNanos
import java.util.function.Consumer;
            shardId,
    }
    }
        boolean lastChunk,  
    private final ShardId shardId;
 * The OpenSearch Contributors require contributions made to  
    private final long replicationId;  
