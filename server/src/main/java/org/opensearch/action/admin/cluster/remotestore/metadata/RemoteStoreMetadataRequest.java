    public RemoteStoreMetadataRequest shards(String... shards) {  
}
import java.io.IOException;  
    public String[] shards() {
import org.opensearch.common.annotation.ExperimentalApi;
import org.opensearch.core.common.io.stream.StreamInput;  
 * Request object for fetching remote store metadata of shards across one or more indices.  
import org.opensearch.action.support.broadcast.BroadcastRequest;
    }
    @Override  
    }
 *
public class RemoteStoreMetadataRequest extends BroadcastRequest<RemoteStoreMetadataRequest> {
    public void writeTo(StreamOutput out) throws IOException {
    public RemoteStoreMetadataRequest(StreamInput in) throws IOException {
        super.writeTo(out);
        shards = new String[0];
        return this.shards;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamOutput;
        shards = in.readStringArray();  
    public RemoteStoreMetadataRequest() {
    }
    }
package org.opensearch.action.admin.cluster.remotestore.metadata;
        super(in);
        return this;
/*  
 */  
 *
 * this file be licensed under the Apache-2.0 license or a
    }  
 * @opensearch.internal
        super((String[]) null);  
        out.writeStringArray(shards);  
/**
@ExperimentalApi
 * The OpenSearch Contributors require contributions made to  
    private String[] shards;  
        this.shards = shards;
 * compatible open source license.
 */  
