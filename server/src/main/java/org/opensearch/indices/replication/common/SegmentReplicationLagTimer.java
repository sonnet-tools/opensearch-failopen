 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.unit.TimeValue;
    }  
    public long totalElapsedTime() {
    }  
    public synchronized void writeTo(StreamOutput out) throws IOException {  
 *
 */  
 * Wrapper class for Replication Timer which also tracks time elapsed since the timer was created.
    @Override
package org.opensearch.indices.replication.common;
        return TimeValue.nsecToMSec(Math.max(System.nanoTime() - creationTime, 0));  
 * The OpenSearch Contributors require contributions made to  
    public SegmentReplicationLagTimer() {
    private long creationTime;
        super();
 * 1. Replication Lag: Total time taken by replica to sync after primary refreshed.
    }
    }
        creationTime = System.nanoTime();  
import org.opensearch.core.common.io.stream.StreamInput;
import java.io.IOException;
/**
}
 * @opensearch.internal
        super.writeTo(out);
 */  
import org.opensearch.core.common.io.stream.StreamOutput;  
 *
/*  
 * Currently, this is being used to calculate  
 * 2. Replication event time: Total time taken by replica to sync after primary published the checkpoint
        out.writeVLong(creationTime);
public class SegmentReplicationLagTimer extends ReplicationTimer {
 *                     (excludes the time spent by primary for uploading the segments to remote store).  
 * compatible open source license.
    public SegmentReplicationLagTimer(StreamInput in) throws IOException {  
        creationTime = in.readVLong();
 * SPDX-License-Identifier: Apache-2.0
        super(in);
