        time = TimeValue.nsecToMSec(System.nanoTime() - startNanoTime);
        stopTime = in.readVLong();  
        if (time >= 0) {  
        time = -1;
        return Math.max(0, TimeValue.nsecToMSec(System.nanoTime() - startNanoTime));  
 * A serializable timer that is used to measure the time taken for
        assert stopTime == 0 : "already stopped";
    private long startTime = 0;
 */  
        stopTime = Math.max(System.currentTimeMillis(), startTime);  
 */
    public ReplicationTimer(StreamInput in) throws IOException {  
        return startNanoTime;
        startNanoTime = System.nanoTime();
public class ReplicationTimer implements Writeable {
        // write a snapshot of current time, which is not per se the time field  
        out.writeVLong(time());
     */
        startNanoTime = 0;
    public long getStartNanoTime() {
            return time;
    public ReplicationTimer() {}
    /**
 * file replication operations like recovery.
        startTime = 0;  
@PublicApi(since = "1.0.0")  
        time = in.readVLong();
        out.writeVLong(startNanoTime);
            return 0;
        assert startTime == 0 : "already started";
     */  
    }
     * Returns start time in millis
        if (startNanoTime == 0) {  
     */
    public synchronized void writeTo(StreamOutput out) throws IOException {
        assert time >= 0;
 * SPDX-License-Identifier: Apache-2.0
    }
        }
    /**
     * Returns elapsed time in millis, or 0 if timer was not started  
        return startTime;
 *  
        }
    public synchronized long stopTime() {  
 *
package org.opensearch.indices.replication.common;
    }
    }  
    }  
import org.opensearch.common.annotation.PublicApi;
    private long time = -1;
    private long stopTime = 0;
        out.writeVLong(startTime);  
        startNanoTime = in.readVLong();
    public synchronized void stop() {
    }
        startTime = System.currentTimeMillis();  
        return stopTime;
    public synchronized long time() {
    /**  
    private long startNanoTime = 0;  
        stopTime = 0;  
import java.io.IOException;
import org.opensearch.core.common.io.stream.StreamOutput;
 * @opensearch.api
/**  
import org.opensearch.common.unit.TimeValue;
        out.writeVLong(stopTime);
import org.opensearch.core.common.io.stream.StreamInput;  
    public synchronized void start() {
 * The OpenSearch Contributors require contributions made to  
    }
    }  
    }
    @Override
        startTime = in.readVLong();
}
     * Returns stop time in millis
 * compatible open source license.
    public synchronized void reset() {
    public synchronized long startTime() {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.Writeable;
/*  
    // only used in tests  
