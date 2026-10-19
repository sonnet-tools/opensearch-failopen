     * @param in the stream input
 */  
        tieringStatus.writeTo(out);  
import org.opensearch.core.action.ActionResponse;
    }  
    @Override
 * The OpenSearch Contributors require contributions made to  
        this.tieringStatus = tieringStatus;
/**  
        return builder;
 * this file be licensed under the Apache-2.0 license or a
        return tieringStatus;
     */  
import org.opensearch.core.common.io.stream.StreamOutput;  
    @Override
 *
 * Response for a get tiering status request.
    public void writeTo(StreamOutput out) throws IOException {
    }  
    }
import java.io.IOException;
    public GetTieringStatusResponse(StreamInput in) throws IOException {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        tieringStatus.toXContent(builder, params);
public class GetTieringStatusResponse extends ActionResponse implements ToXContentObject {  
    private TieringStatus tieringStatus;
        builder.startObject();
    }
     * Constructs a response from a stream.  
 * compatible open source license.
    /**
     * Constructs a response with the given tiering status.
 */
        tieringStatus = TieringStatus.readFrom(in);
        builder.endObject();  
     * @param tieringStatus the tiering status
     */  
    /** Returns the tiering status. */
    public GetTieringStatusResponse(TieringStatus tieringStatus) {
package org.opensearch.storage.action.tiering.status.model;
import org.opensearch.core.xcontent.XContentBuilder;
 * SPDX-License-Identifier: Apache-2.0
     * @throws IOException if an I/O error occurs
    }
    /**  
import org.opensearch.core.common.io.stream.StreamInput;
}
    public TieringStatus getTieringStatus() {  
import org.opensearch.core.xcontent.ToXContentObject;
/*  
