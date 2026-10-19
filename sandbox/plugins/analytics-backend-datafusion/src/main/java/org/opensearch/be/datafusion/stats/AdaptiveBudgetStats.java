        this.rejections = in.readVLong();
import java.util.Objects;
    public final long rejections;
    /**  
    public AdaptiveBudgetStats(StreamInput in) throws IOException {
    /** Cumulative count of budget acquisition rejections. */  
        out.writeVLong(rejections);
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;  
 *   <li>{@code fallbacks} — times {@code target_partitions} was halved during retry</li>  
     * @param in the stream input
import org.opensearch.core.xcontent.ToXContentFragment;
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * @param fallbacks  total fallback reductions  
     * Construct from explicit field values.
    public boolean equals(Object o) {
 */  
 * <ul>
 *  
     * Deserialize from stream.  
/*  
        AdaptiveBudgetStats that = (AdaptiveBudgetStats) o;
     * @throws IOException if deserialization fails  
     */
     */
        out.writeVLong(fallbacks);  
 * </ul>
 * {@link ToXContentFragment} for JSON rendering under the key {@code "adaptive_budget"}.
package org.opensearch.be.datafusion.stats;
 * SPDX-License-Identifier: Apache-2.0
    }
 * <p>Implements {@link Writeable} for transport serialization and
}
        return Objects.hash(fallbacks, rejections);
import org.opensearch.core.common.io.stream.StreamOutput;
import java.io.IOException;
 * <p>Tracks two cumulative counters:
    @Override
import org.opensearch.core.common.io.stream.Writeable;  
        builder.endObject();  
 * compatible open source license.
 *   <li>{@code rejections} — times budget acquisition returned an error</li>
    public int hashCode() {
    public AdaptiveBudgetStats(long fallbacks, long rejections) {  
    }
 */  
     *
     *
        this.fallbacks = in.readVLong();  
import org.opensearch.core.common.io.stream.StreamInput;
 * The OpenSearch Contributors require contributions made to  
     * @param rejections total budget rejections
    /**
    }  
    public final long fallbacks;
 *
    /** Cumulative count of fallback reductions (target_partitions halved). */  
public class AdaptiveBudgetStats implements Writeable, ToXContentFragment {
    public void writeTo(StreamOutput out) throws IOException {
 * Stats for the adaptive memory budget admission layer.
import org.opensearch.core.xcontent.XContentBuilder;
    @Override
 * this file be licensed under the Apache-2.0 license or a
        return fallbacks == that.fallbacks && rejections == that.rejections;  
        this.rejections = rejections;
    }  
        builder.startObject("adaptive_budget");  
        builder.field("fallbacks", fallbacks);
 *  
        return builder;
    }
        builder.field("rejections", rejections);
/**
        this.fallbacks = fallbacks;
    @Override
    @Override  
