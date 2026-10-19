/**  
    }  
        this.bounds = in.readOptionalWriteable(ShardSortBounds::new);
    public AnalyticsCanMatchResponse(boolean canMatch, @Nullable ShardSortBounds bounds) {
 *
    public AnalyticsCanMatchResponse(StreamInput in) throws IOException {  
 *  
 *  
import org.opensearch.core.transport.TransportResponse;
     */
 * Response from a data node indicating whether the shard can possibly
    public AnalyticsCanMatchResponse(boolean canMatch) {  
/*  
        this(canMatch, null);
        out.writeOptionalWriteable(bounds);
import java.io.IOException;
    @Nullable  
 */
    }
    private final ShardSortBounds bounds;
        this.canMatch = canMatch;
 * <p>Also carries the sort column's min/max when the request asked for it. The two are
     * coordinator sorts those shards last.  
import org.opensearch.common.Nullable;
     * Shard-wide min/max of the requested sort column; {@code null} when none was requested or the
 * this file be licensed under the Apache-2.0 license or a
public class AnalyticsCanMatchResponse extends TransportResponse {  
}  
        return bounds;
    private final boolean canMatch;
import org.opensearch.core.common.io.stream.StreamInput;  
 * compatible open source license.
 * match the query's filter predicates.
        return canMatch;  
    }  
    @Nullable
    }
import org.opensearch.analytics.spi.ShardSortBounds;
        out.writeBoolean(canMatch);
    public boolean canMatch() {
    /**  
package org.opensearch.analytics.exec.canmatch;
 * The OpenSearch Contributors require contributions made to  
    }
 * independent: {@code canMatch} drives pruning, {@code bounds} drives shard ordering.
 * @opensearch.internal
    public ShardSortBounds bounds() {  
 * SPDX-License-Identifier: Apache-2.0
    public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.core.common.io.stream.StreamOutput;
    }
     * shard has no usable statistics for it. Null is a normal answer, not an error — the
 */  
        this.bounds = bounds;  
        this.canMatch = in.readBoolean();
    @Override
