import org.opensearch.core.common.io.stream.StreamInput;
    }
import org.opensearch.core.common.io.stream.StreamOutput;
        return searchContextIdForNode;
public class PitSearchContextIdForNode implements Writeable {  
import java.io.IOException;
    }
    private final SearchContextIdForNode searchContextIdForNode;  
 * compatible open source license.
    @Override  
    }
        return pitId;
 */
        this.pitId = in.readString();
 *  
    PitSearchContextIdForNode(StreamInput in) throws IOException {
    }
    public PitSearchContextIdForNode(String pitId, SearchContextIdForNode searchContextIdForNode) {
 * Pit ID along with Id for a search context per node.
    public SearchContextIdForNode getSearchContextIdForNode() {
        out.writeString(pitId);
/**
        searchContextIdForNode.writeTo(out);  
        this.searchContextIdForNode = searchContextIdForNode;
    public String getPitId() {  
 *
package org.opensearch.action.search;
 * SPDX-License-Identifier: Apache-2.0
}
        this.pitId = pitId;  
    }  
    private final String pitId;
/*  
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.Writeable;  
    public void writeTo(StreamOutput out) throws IOException {
        this.searchContextIdForNode = new SearchContextIdForNode(in);  
 */  
 * The OpenSearch Contributors require contributions made to  
