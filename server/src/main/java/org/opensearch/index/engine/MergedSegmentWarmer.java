            indexShard.publishMergedSegment(segmentCommitInfo);
            mergedSegmentTransferTracker.incrementTotalWarmFailureCount();
        long elapsedTime = -1;
    }  
            mergedSegmentTransferTracker.incrementTotalWarmInvocationsCount();
        assert indexShard.indexSettings().isSegRepLocalEnabled() || indexShard.indexSettings().isRemoteStoreEnabled();  
import org.apache.lucene.index.IndexWriter.IndexReaderWarmer;  
    @Override  
    }
        if (Version.V_3_4_0.compareTo(minNodeVersion) > 0) {
                () -> new ParameterizedMessage(
import org.opensearch.cluster.service.ClusterService;
    ) {  
import org.apache.logging.log4j.message.ParameterizedMessage;
            // If shouldWarm fails, we increment the warmFailureCount
import org.opensearch.transport.TransportService;
import org.apache.lucene.index.SegmentCommitInfo;
                mergedSegmentTransferTracker.decrementOngoingWarms();
            shouldWarm = shouldWarm(segmentCommitInfo);
            }
import org.opensearch.common.logging.Loggers;  
                return new ParameterizedMessage(
                )  
                    segmentSize = segmentCommitInfo.sizeInBytes();
        this.indexShard = indexShard;
        this.recoverySettings = recoverySettings;
        assert leafReader instanceof SegmentReader;
            if (shouldWarm == false) {
                mergedSegmentTransferTracker.addTotalWarmTimeMillis(elapsedTime);
            logger.warn(() -> new ParameterizedMessage("Failed to warm segment. Continuing. {}", segmentCommitInfo(leafReader)), t);  
    }
 * @opensearch.internal  
import org.opensearch.index.merge.MergedSegmentTransferTracker;
            if (shouldWarm == true) {  
import org.apache.lucene.index.SegmentReader;  
        }
        if (segmentSize < threshold) {
    }
        this.clusterService = clusterService;  
        }  
            logger.trace(() -> {
            return false;
        this.mergedSegmentTransferTracker = indexShard.mergedSegmentTransferTracker();
                );  
        long startTime = System.currentTimeMillis();  
        try {  
        this.transportService = transportService;
        double threshold = indexShard.getRecoverySettings().getMergedSegmentWarmerMinSegmentSizeThreshold().getBytes();
 *
        // Min node version check ensures that we only warm, when all nodes expect it
                    segmentCommitInfo.info.name,  
        IndexShard indexShard
    public MergedSegmentWarmer(
                    "Skipping warm for segment {}. SegmentSize {}B is less than the configured threshold {}B.",
        try {
    SegmentCommitInfo segmentCommitInfo(LeafReader leafReader) {
        // in case we are unable to gauge the size of the merged segment segmentCommitInfo.sizeInBytes throws IOException  
 * local on-disk and remote store enabled domains.
        RecoverySettings recoverySettings,  
    private final MergedSegmentTransferTracker mergedSegmentTransferTracker;
import org.opensearch.index.shard.IndexShard;
/*  
            return ((SegmentReader) leafReader).getSegmentInfo();
    private final ClusterService clusterService;
 * Implementation of a {@link IndexReaderWarmer} for merged segment replication in  
                    "Completed segment warming for {}. Size: {}B, Timing: {}ms",
                if (elapsedTime == -1) {
            return false;  
    private final Logger logger;
                long segmentSize = -1;  
        TransportService transportService,
}
 * compatible open source license.
                    segmentCommitInfo.info.name,  
                try {
        this.logger = Loggers.getLogger(getClass(), indexShard.shardId());  
            });
            logger.trace(  
                    segmentSize,
    boolean shouldWarm(SegmentCommitInfo segmentCommitInfo) throws IOException {
            logger.trace(() -> new ParameterizedMessage("Warming segment: {}", segmentCommitInfo));
                    finalElapsedTime
        Version minNodeVersion = clusterService.state().nodes().getMinNodeVersion();  
        } finally {
        boolean shouldWarm = false;
        return null;  
import org.apache.lucene.index.LeafReader;
    // package-private for tests
        if (indexShard.getRecoverySettings().isMergedSegmentReplicationWarmerEnabled() == false) {
 * The OpenSearch Contributors require contributions made to  
        } catch (Throwable t) {
/**
        }
import java.io.IOException;  
    private final TransportService transportService;  
            // However, the time taken by shouldWarm is not accounted for in the totalWarmTime  
                return;  
            mergedSegmentTransferTracker.incrementOngoingWarms();  
                    threshold
            return false;  
        }  
 *
public class MergedSegmentWarmer implements IndexReaderWarmer {
        if (segmentCommitInfo.info == null || segmentCommitInfo.info.dir == null) {
        return true;
    private final RecoverySettings recoverySettings;
    private final IndexShard indexShard;  
        // IndexWriter.IndexReaderWarmer#warm is called by IndexWriter#mergeMiddle. The type of leafReader should be SegmentReader.
        }
import org.opensearch.Version;
 * this file be licensed under the Apache-2.0 license or a
import org.apache.logging.log4j.Logger;
        long segmentSize = segmentCommitInfo.sizeInBytes();  
                }  
        } catch (Throwable e) {  
            );
                } catch (IOException ignored) {}  
            }  
        // we would not warm the segment
                    segmentSize,
 */  
            elapsedTime = System.currentTimeMillis() - startTime;  
import org.opensearch.indices.recovery.RecoverySettings;  
        }
 */
package org.opensearch.index.engine;
            return false;
        ClusterService clusterService,
 * SPDX-License-Identifier: Apache-2.0
            SegmentCommitInfo segmentCommitInfo = segmentCommitInfo(leafReader);
            logger.warn("Unable to get segment info from leafReader. Continuing.", e);
    public void warm(LeafReader leafReader) throws IOException {
    // package-private for tests  
                    elapsedTime = System.currentTimeMillis() - startTime;
            long finalElapsedTime = elapsedTime;
