import java.io.UncheckedIOException;
        return infosBytes;
        userData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(Math.min(maxSeqNo, lastRefreshedCheckpoint)));  
package org.opensearch.indices.replication.common;
        Map<String, String> userData = segmentInfosSnapshot.getUserData();
    @Override  
import org.apache.lucene.store.ByteBuffersDataOutput;
/**
 */  
        try (ByteBuffersIndexOutput indexOutput = new ByteBuffersIndexOutput(buffer, "", null)) {
        ByteBuffersDataOutput buffer = new ByteBuffersDataOutput();  
    public void close() throws IOException {
    /** Actual ReplicationCheckpoint returned by the shard */
    }  
 * holds incRef'd file level details for one point-in-time segment infos.  
        final Tuple<GatedCloseable<SegmentInfos>, ReplicationCheckpoint> latestSegmentInfosAndCheckpoint = shard  
import org.apache.lucene.store.ByteBuffersIndexOutput;  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 *
    }
import org.opensearch.common.concurrent.GatedCloseable;
import org.opensearch.index.shard.IndexShard;
    public Map<String, StoreFileMetadata> getMetadataMap() {  
import org.apache.lucene.index.SegmentInfos;
    public ReplicationCheckpoint getCheckpoint() {
            segmentInfosSnapshot.write(indexOutput);  
import java.io.IOException;  
        this.shard = shard;
        // resource description and name are not used, but resource description cannot be null
import java.io.Closeable;
import org.opensearch.common.collect.Tuple;
        segmentInfosSnapshot.setUserData(userData, false);
/*  
        } catch (IOException e) {
        }  
import org.opensearch.index.store.StoreFileMetadata;
    private final ReplicationCheckpoint replicationCheckpoint;
 *
        return replicationCheckpoint.getMetadataMap();
    public CopyState(IndexShard shard) throws IOException {  
}
    private final byte[] infosBytes;  
    }  
        return replicationCheckpoint;  
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
    }
    public IndexShard getShard() {
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;  
    }
        this.infosBytes = buffer.toArrayCopy();
            .getLatestSegmentInfosAndCheckpoint();
        return shard;  
 * The OpenSearch Contributors require contributions made to  
        SegmentInfos segmentInfosSnapshot = segmentInfos.clone();  
        // primary shard is less than or equal to the checkpoint of the Lucene commit.
        // In the scenario of primary promotion. We need to ensure that the SegmentInfos#version of the new primary shard  
    private final IndexShard shard;
            throw new UncheckedIOException(e);
        try {
 */  
        long lastRefreshedCheckpoint = shard.getLastRefreshedCheckpoint();
        long maxSeqNo = Long.parseLong(userData.getOrDefault(SequenceNumbers.MAX_SEQ_NO, "-1"));
 * An Opensearch-specific version of Lucene's CopyState class that
 * @opensearch.internal
        this.segmentInfosRef = latestSegmentInfosAndCheckpoint.v1();
import org.opensearch.index.seqno.SequenceNumbers;  
public class CopyState implements Closeable {
            segmentInfosRef.close();  
        this.replicationCheckpoint = latestSegmentInfosAndCheckpoint.v2();  
    private final GatedCloseable<SegmentInfos> segmentInfosRef;  
        SegmentInfos segmentInfos = this.segmentInfosRef.get();
    }
        // is greater than or equal to that of the replicas, and also need to ensure that the local_checkpoint of the new
        }
    public byte[] getInfosBytes() {
