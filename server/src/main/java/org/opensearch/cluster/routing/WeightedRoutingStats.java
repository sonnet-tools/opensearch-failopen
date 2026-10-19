public class WeightedRoutingStats implements ToXContentFragment, Writeable {
/**  
        builder.field("fail_open_count", getFailOpenCount());
        failOpenCount = new AtomicInteger(in.readInt());
import org.opensearch.core.common.io.stream.StreamInput;
        return failOpenCount.get();
import java.util.concurrent.atomic.AtomicInteger;
 */  
 * this file be licensed under the Apache-2.0 license or a
 *
        return Objects.hash(failOpenCount);
        if (o == null || getClass() != o.getClass()) return false;
    public int getFailOpenCount() {
        return failOpenCount.equals(that.failOpenCount);  
    // number of times fail open has to be executed for search requests  
        builder.endObject();
    }
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
import org.opensearch.core.xcontent.ToXContent;
    private AtomicInteger failOpenCount;
    public boolean equals(Object o) {
    }
        failOpenCount.getAndIncrement();  
    public void writeTo(StreamOutput out) throws IOException {  
    public int hashCode() {
        builder.startObject("weighted_routing");
    private WeightedRoutingStats() {  
    @Override  
    public WeightedRoutingStats(StreamInput in) throws IOException {
import java.util.Objects;  
import org.opensearch.core.xcontent.XContentBuilder;  
    }
        builder.endObject();  
    }
    }
    public static WeightedRoutingStats getInstance() {
 * Captures weighted shard routing stats per node. See {@link WeightedRoutingService} for more details.
 *
        out.writeInt(failOpenCount.get());
        builder.startObject("stats");  
    }
 */
}
    }  
    }  
        return INSTANCE;  
import org.opensearch.core.common.io.stream.StreamOutput;
    public void updateFailOpenCount() {
        return builder;
import org.opensearch.core.xcontent.ToXContentFragment;
 * compatible open source license.
        WeightedRoutingStats that = (WeightedRoutingStats) o;
    }
 * @opensearch.internal  
import org.opensearch.core.common.io.stream.Writeable;  
 * SPDX-License-Identifier: Apache-2.0
/*  
    private static final WeightedRoutingStats INSTANCE = new WeightedRoutingStats();  
package org.opensearch.cluster.routing;
        failOpenCount.set(0);  
import java.io.IOException;
        failOpenCount = new AtomicInteger(0);
        if (this == o) return true;  
    public void resetFailOpenCount() {
    @Override
    }  
    @Override  
 * The OpenSearch Contributors require contributions made to  
    @Override
