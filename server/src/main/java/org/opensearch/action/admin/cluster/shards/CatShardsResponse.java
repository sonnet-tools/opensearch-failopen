            if (pageToken != null) {
    public List<ShardRouting> getResponseShards() {
 *
            out.writeBoolean(pageToken != null);
import org.opensearch.cluster.node.DiscoveryNodes;
 *
        return this.responseShards;
import org.opensearch.cluster.routing.ShardRouting;
    private IndicesStatsResponse indicesStatsResponse;  
            responseShards = in.readList(ShardRouting::new);  
    }
        }
package org.opensearch.action.admin.cluster.shards;
    public PageToken getPageToken() {  
                pageToken = new PageToken(in);
/**
 * The OpenSearch Contributors require contributions made to  
public class CatShardsResponse extends ActionResponse {
 * compatible open source license.
    }  
    }
    public void setPageToken(PageToken pageToken) {
        indicesStatsResponse = new IndicesStatsResponse(in);  
import java.io.IOException;
        super(in);
    }
    public void setIndicesStatsResponse(IndicesStatsResponse indicesStatsResponse) {
import org.opensearch.Version;
    }
    public CatShardsResponse(StreamInput in) throws IOException {
    }
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.ArrayList;
            }
    private DiscoveryNodes nodes = DiscoveryNodes.EMPTY_NODES;
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
/*  
        if (in.getVersion().onOrAfter(Version.V_2_18_0)) {
            }  
    private List<ShardRouting> responseShards = new ArrayList<>();
            nodes = DiscoveryNodes.readFrom(in, null);
    public CatShardsResponse() {}
            if (in.readBoolean()) {
        this.indicesStatsResponse = indicesStatsResponse;
        if (out.getVersion().onOrAfter(Version.V_2_18_0)) {
import org.opensearch.core.action.ActionResponse;  
 * A response of a cat shards request.  
 */  
    public IndicesStatsResponse getIndicesStatsResponse() {
                pageToken.writeTo(out);  
        this.pageToken = pageToken;  
        return this.pageToken;
import org.opensearch.core.common.io.stream.StreamOutput;
 */  
            nodes.writeToWithAttribute(out);
        }
 * this file be licensed under the Apache-2.0 license or a
    public void setResponseShards(List<ShardRouting> responseShards) {  
 * SPDX-License-Identifier: Apache-2.0
    }
            out.writeList(responseShards);  
    private PageToken pageToken;  
    public void setNodes(DiscoveryNodes nodes) {
        return this.indicesStatsResponse;  
    }  
    public DiscoveryNodes getNodes() {  
}  
    }  
 * @opensearch.api
        this.responseShards = responseShards;
        indicesStatsResponse.writeTo(out);  
    }
import java.util.List;  
        this.nodes = nodes;  
import org.opensearch.action.pagination.PageToken;  
        return this.nodes;
    public void writeTo(StreamOutput out) throws IOException {
