    }  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.ExperimentalApi;
    private final String index;  
    public String getIndex() {  
        return cause;  
        this.shardId = shardId;
    private final int shardId;
    }
 * @opensearch.experimental
        this.index = index;  
 */
 */  
 * SPDX-License-Identifier: Apache-2.0
    private final String cause;  
    private final int splitInto;
    }
/*  
 * compatible open source license.
    }
        return index;
        return splitInto;
    public int getShardId() {  
public class InPlaceSplitShardClusterStateUpdateRequest extends ClusterStateUpdateRequest<InPlaceSplitShardClusterStateUpdateRequest> {
 * this file be licensed under the Apache-2.0 license or a
        this.splitInto = splitInto;
import org.opensearch.cluster.ack.ClusterStateUpdateRequest;
 *
/**
    public InPlaceSplitShardClusterStateUpdateRequest(String cause, String index, int shardId, int splitInto) {
package org.opensearch.action.admin.indices.split;
        this.cause = cause;  
        return shardId;
}  
 *  
 * Cluster state update request for in-place shard split.
    public int getSplitInto() {
@ExperimentalApi  
    public String cause() {
    }
