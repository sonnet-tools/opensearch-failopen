    /**  
     *  
     *  
     *
     * Constructs a request for segment replication stats information for all shards for the given indices
     * True if detailed flag is set, false otherwise. This value if false by default.
    }
import org.opensearch.core.common.Strings;
        super.writeTo(out);  
    public boolean activeOnly() {
     * on-going segment replication event information.
        this.shards = shards;
        activeOnly = in.readBoolean();
     */
 * compatible open source license.
     * Set value of the detailed flag. Detailed requests will contain extra
    }
        return shards;  
 */
/*  
import org.opensearch.common.annotation.PublicApi;  
 * Request for Segment Replication stats information
    }  
     * Constructs a request for segment replication stats information for all shards
    @Override
     */
     * @param activeOnly    Whether or not to set the activeOnly flag.  
     * @param detailed  Whether or not to set the detailed flag
import java.io.IOException;
        return activeOnly;
        super(in);
    private boolean activeOnly = false;     // Only reports on active segment replication events  
    public SegmentReplicationStatsRequest() {  
     */  
     * Set value of the activeOnly flag. If true, this request will only respond with  
    public String[] shards() {
    /**
    private boolean detailed = false;       // Provides extra details in the response
    /**
    public void detailed(boolean detailed) {
import org.opensearch.action.support.IndicesOptions;
 *
        this.detailed = detailed;
    /**
 *  
     * @return  True if detailed flag is set, false otherwise
package org.opensearch.action.admin.indices.replication;
    }
    }  
     *
 * SPDX-License-Identifier: Apache-2.0
    public void shards(String[] shards) {  
        detailed = in.readBoolean();  
    public SegmentReplicationStatsRequest(String... indices) {  
     */
    public void writeTo(StreamOutput out) throws IOException {
     * @return  array of shard id's if shards are passed, empty otherwise  
 * @opensearch.api
     * Contains list of shard id's if shards are passed, empty otherwise. Array is empty by default.
     */
    /**  
    }
     *
    private String[] shards = new String[0];
        out.writeBoolean(activeOnly);
    /**
 */  
        out.writeBoolean(detailed);
        this.activeOnly = activeOnly;  
import org.opensearch.core.common.io.stream.StreamOutput;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamInput;
     * Set value of the shards. If shard id's are passed, this request will only respond with
    /**  
     * given specific shard's segment replication event information, instead of all shards.
    /**
    }
     * True if activeOnly flag is set, false otherwise. This value is false by default.  
    }  
    public void activeOnly(boolean activeOnly) {
/**
@PublicApi(since = "1.0.0")  
        this(Strings.EMPTY_ARRAY);
 * this file be licensed under the Apache-2.0 license or a
     *
     * @return  True if activeOnly flag is set, false otherwise
    public boolean detailed() {  
     * information like timing metric of each stage of segment replication event.  
        super(indices, IndicesOptions.STRICT_EXPAND_OPEN_CLOSED);
     */
     * @param indices   Comma-separated list of indices about which to gather segment replication information
     * @param shards    contains list of shard id's.
     *  
    }
        return detailed;
     */  
import org.opensearch.action.support.broadcast.BroadcastRequest;
}
     */
    }
    public SegmentReplicationStatsRequest(StreamInput in) throws IOException {
public class SegmentReplicationStatsRequest extends BroadcastRequest<SegmentReplicationStatsRequest> {
