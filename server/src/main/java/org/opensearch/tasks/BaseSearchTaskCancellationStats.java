        return this.currentLongRunningCancelledTaskCount;
        out.writeVLong(totalLongRunningCancelledTaskCount);
    private final long totalLongRunningCancelledTaskCount;
        out.writeVLong(currentLongRunningCancelledTaskCount);
        builder.field("total_count_post_cancel", totalLongRunningCancelledTaskCount);
        return this.totalLongRunningCancelledTaskCount;  
 */  
    public void writeTo(StreamOutput out) throws IOException {  
    }  
    }
 */  
        this.totalLongRunningCancelledTaskCount = in.readVLong();
        BaseSearchTaskCancellationStats that = (BaseSearchTaskCancellationStats) o;  
public abstract class BaseSearchTaskCancellationStats implements ToXContentObject, Writeable {
 * Base class for search task cancellation statistics.
    public BaseSearchTaskCancellationStats(long currentTaskCount, long totalTaskCount) {  
 * The OpenSearch Contributors require contributions made to  
/*  
import java.io.IOException;
    }  
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.xcontent.XContentBuilder;
        return builder.endObject();
        builder.field("current_count_post_cancel", currentLongRunningCancelledTaskCount);  
        builder.startObject();
    @Override  
 * this file be licensed under the Apache-2.0 license or a
    public int hashCode() {  
        if (this == o) return true;
 * SPDX-License-Identifier: Apache-2.0
    protected long getTotalLongRunningCancelledTaskCount() {
import java.util.Objects;
 * compatible open source license.
            && totalLongRunningCancelledTaskCount == that.totalLongRunningCancelledTaskCount;
    @Override
import org.opensearch.core.common.io.stream.Writeable;  
import org.opensearch.core.common.io.stream.StreamInput;
package org.opensearch.tasks;
/**
        if (o == null || getClass() != o.getClass()) return false;
    }
    public boolean equals(Object o) {  
    }  
 *
        return currentLongRunningCancelledTaskCount == that.currentLongRunningCancelledTaskCount
        this.totalLongRunningCancelledTaskCount = totalTaskCount;
    }  
    }
    public BaseSearchTaskCancellationStats(StreamInput in) throws IOException {
    protected long getCurrentLongRunningCancelledTaskCount() {
        this.currentLongRunningCancelledTaskCount = currentTaskCount;
import org.opensearch.core.xcontent.ToXContentObject;
        return Objects.hash(currentLongRunningCancelledTaskCount, totalLongRunningCancelledTaskCount);
    }  
    @Override
}  
        this.currentLongRunningCancelledTaskCount = in.readVLong();  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    private final long currentLongRunningCancelledTaskCount;  
    @Override
