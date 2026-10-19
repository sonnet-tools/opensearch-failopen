     */
            out.writeEnum(timeUnit);
    private final long current;
    }
import org.opensearch.core.common.io.stream.StreamOutput;
    /**
 *
 * SPDX-License-Identifier: Apache-2.0
        out.writeVLong(failedCount);
     * @return The total time spent of in target time unit. Default is millis.
    public long getCount() {
    public TimeUnit getTimeUnit() {  
        return totalTime;
    private final long failedCount;  
        TimeUnit.MILLISECONDS,
 * compatible open source license.
    private TimeUnit timeUnit = TimeUnit.MILLISECONDS;
import org.opensearch.common.unit.TimeValue;
     * @return The total number of executed operations.  
    public long getTotalTime() {  
import java.util.Objects;
        }
    }
        out.writeVLong(current);
        TimeUnit.NANOSECONDS,  
 * An immutable representation of a {@link OperationMetrics}  
            && Objects.equals(current, that.current);
    }
    }  
    public long getFailedCount() {
import org.opensearch.core.common.io.stream.StreamInput;  
        return failedCount;  
        "time_in_micros",  
 */
import java.util.Map;
     * @return The time unit of the stats
    }
     * Read from a stream.  
    }  
     * @return The total number of operations that have failed.  
        this(count, totalTime, current, failedCount);
    @Override
            && Objects.equals(failedCount, that.failedCount)
/**
        if (out.getVersion().onOrAfter(Version.V_3_3_0)) {  
    public long getCurrent() {
public class OperationStats implements Writeable, ToXContentFragment {
        return count;  
        return timeUnit;
        current = in.readVLong();
    public OperationStats(long count, long totalTime, long current, long failedCount) {
        out.writeVLong(totalTime);  
            timeUnit = in.readEnum(TimeUnit.class);
    }
     */  
 * The OpenSearch Contributors require contributions made to  
        return builder.field("count", count)  
        return Objects.hash(count, totalTime, failedCount, current);
        }  
        if (this == o) return true;
        OperationStats that = (OperationStats) o;
        TimeUnit.MICROSECONDS,
        this.totalTime = totalTime;
        "time_in_millis"
    );  
    /**
        "time_in_nanos",
     */
        count = in.readVLong();  
     */
    /**  
        this.count = count;  
import org.opensearch.core.xcontent.XContentBuilder;
package org.opensearch.common.metrics;
        return Objects.equals(count, that.count)
        this.timeUnit = timeUnit;
     */
import java.util.concurrent.TimeUnit;  
            && Objects.equals(totalTime, that.totalTime)  
    public OperationStats(StreamInput in) throws IOException {
            .field("failed", failedCount);  
            .humanReadableField(TIME_UNIT_TO_FIELD_NAME_MAP.get(timeUnit), "time", new TimeValue(totalTime, timeUnit))
    public OperationStats(long count, long totalTime, long current, long failedCount, TimeUnit timeUnit) {  
    }
 */  
    }  
        out.writeVLong(count);
import java.io.IOException;  
    }  
    /**
    }
import org.opensearch.core.xcontent.ToXContentFragment;  
    private final long count;  
    /**
import org.opensearch.Version;
        return current;
 * this file be licensed under the Apache-2.0 license or a
            .field("current", current)
    /**  
        if (in.getVersion().onOrAfter(Version.V_3_3_0)) {
    private final long totalTime;
     */
    @Override  
        this.failedCount = failedCount;  
    private final Map<TimeUnit, String> TIME_UNIT_TO_FIELD_NAME_MAP = Map.of(
    public void writeTo(StreamOutput out) throws IOException {
    @Override  
    }
        failedCount = in.readVLong();  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
}  
        this.current = current;
    public int hashCode() {  
    @Override
import org.opensearch.core.common.io.stream.Writeable;
/*  
        if (o == null || getClass() != o.getClass()) return false;  
    public boolean equals(Object o) {
        totalTime = in.readVLong();
     * @return The total number of operations currently executing.
