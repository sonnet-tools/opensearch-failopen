        this.local = local;
/**
    }
    }
 *
 * The OpenSearch Contributors require contributions made to  
    public void local(boolean local) {
        this.shards = shards;
    }
 */  
    }
 * SPDX-License-Identifier: Apache-2.0
        return this.shards;
 * Encapsulates all remote store stats  
import org.opensearch.core.common.io.stream.StreamInput;  
    public RemoteStoreStatsRequest(StreamInput in) throws IOException {  
 */  
}
        super(in);
import java.io.IOException;  
        shards = in.readStringArray();
        shards = new String[0];  
package org.opensearch.action.admin.cluster.remotestore.stats;
public class RemoteStoreStatsRequest extends BroadcastRequest<RemoteStoreStatsRequest> {
        out.writeStringArray(shards);  
    public String[] shards() {  
        return local;  
        super.writeTo(out);
 * @opensearch.api
    public boolean local() {
import org.opensearch.core.common.io.stream.StreamOutput;
    private String[] shards;
/*  
        out.writeBoolean(local);
    public void writeTo(StreamOutput out) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.annotation.PublicApi;
    public RemoteStoreStatsRequest() {
 * compatible open source license.
        local = in.readBoolean();  
    private boolean local = false;
@PublicApi(since = "2.8.0")
    @Override  
        return this;  
 *
import org.opensearch.action.support.broadcast.BroadcastRequest;
        super((String[]) null);
    }  
    public RemoteStoreStatsRequest shards(String... shards) {
    }
    }
