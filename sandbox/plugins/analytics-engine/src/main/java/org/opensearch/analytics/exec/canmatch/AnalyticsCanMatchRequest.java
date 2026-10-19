 */
        out.writeByteArray(filterBytes);
    @Nullable
        this(shardId, filterBytes, backendId, null);  
    @Override  
import org.opensearch.core.index.shard.ShardId;  
}
import java.io.IOException;
        shardId.writeTo(out);  
    /** Column to fold shard-wide min/max for, or {@code null} when the query has no usable sort. */
 *
        return sortColumn;
 * onto the response, for coordinator-side shard ordering. Independent of the filters — a
    public AnalyticsCanMatchRequest(ShardId shardId, byte[] filterBytes, String backendId, @Nullable String sortColumn) {  
import org.opensearch.core.common.io.stream.StreamOutput;
        super(in);
    @Override  
/*  
    private final byte[] filterBytes;  
    }  
    @Nullable  
        this.filterBytes = filterBytes;
import org.opensearch.action.ActionRequest;
        return null;
 *  
import org.opensearch.common.Nullable;  
    private final ShardId shardId;
        return backendId;
 * @opensearch.internal
 * <p>An optional {@code sortColumn} asks the data node to also fold that column's min/max  
package org.opensearch.analytics.exec.canmatch;
 */  
    private final String sortColumn;  
 * SPDX-License-Identifier: Apache-2.0
        this.backendId = in.readString();
        this.sortColumn = in.readOptionalString();  
import org.opensearch.core.common.io.stream.StreamInput;
 * deserializes and evaluates against parquet row-group statistics.
        this.shardId = shardId;
 * produced by {@link CanMatchFilterSerializer}. The data node  
    }  
        super.writeTo(out);
/**
 * this file be licensed under the Apache-2.0 license or a
    }
    private final String backendId;
        return filterBytes;
    public ActionRequestValidationException validate() {
        this.filterBytes = in.readByteArray();
 * query may have either, both, or neither.
    }
    public byte[] getFilterBytes() {  
    public ShardId getShardId() {
    public AnalyticsCanMatchRequest(StreamInput in) throws IOException {
import org.opensearch.action.ActionRequestValidationException;
    public void writeTo(StreamOutput out) throws IOException {
        out.writeOptionalString(sortColumn);  
    }
 *
public class AnalyticsCanMatchRequest extends ActionRequest {  
        return shardId;  
    }
    public String getSortColumn() {
        this.backendId = backendId;  
        this.sortColumn = sortColumn;
 * Per-shard can-match request. Carries the serialized filter list
    }
    }  
    }
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    public AnalyticsCanMatchRequest(ShardId shardId, byte[] filterBytes, String backendId) {
    public String getBackendId() {
        out.writeString(backendId);
        this.shardId = new ShardId(in);  
