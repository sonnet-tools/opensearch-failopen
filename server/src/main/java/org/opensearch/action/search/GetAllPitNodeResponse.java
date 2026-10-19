    public void writeTo(StreamOutput out) throws IOException {  
        this.pitInfos = Collections.unmodifiableList(in.readList(ListPitInfo::new));
            throw new IllegalArgumentException("Pits info cannot be null");  
    }  
import org.opensearch.action.support.nodes.BaseNodeResponse;
        builder.field("node", this.getNode().getName());
        out.writeList(pitInfos);
import org.opensearch.core.xcontent.ToXContentFragment;
        for (ListPitInfo pit : pitInfos) {
            pit.toXContent(builder, params);
    public GetAllPitNodeResponse(DiscoveryNode node, List<ListPitInfo> pitInfos) {  
    @Override
}  
        }  
/*
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;  
 */
    @Override
        }
import org.opensearch.core.xcontent.XContentBuilder;
        return builder;
        builder.startArray("pitInfos");  
 * The OpenSearch Contributors require contributions made to
        builder.startObject();
     * List of active PITs in the associated node
     */  
 *  
        if (pitInfos == null) {
import java.util.Collections;
        builder.endArray();
 * @opensearch.api
public class GetAllPitNodeResponse extends BaseNodeResponse implements ToXContentFragment {
    /**
    public GetAllPitNodeResponse(StreamInput in) throws IOException {
@PublicApi(since = "2.3.0")
    }  
 * Inner node get all pits response  
    }  
        super(in);  
        return pitInfos;
        builder.endObject();  
    }
    private final List<ListPitInfo> pitInfos;
    public List<ListPitInfo> getPitInfos() {
 * compatible open source license.  
import org.opensearch.cluster.node.DiscoveryNode;  
 * this file be licensed under the Apache-2.0 license or a
 */  
import org.opensearch.common.annotation.PublicApi;
package org.opensearch.action.search;  
/**
        super(node);
 *
import java.io.IOException;
        super.writeTo(out);
    }
import org.opensearch.core.common.io.stream.StreamInput;
        this.pitInfos = Collections.unmodifiableList(pitInfos);
import org.opensearch.core.common.io.stream.StreamOutput;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
