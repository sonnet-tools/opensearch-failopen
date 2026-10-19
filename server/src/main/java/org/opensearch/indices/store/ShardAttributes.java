    public void writeTo(StreamOutput out) throws IOException {  
    }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.Nullable;
        out.writeString(customDataPath);
        customDataPath = in.readString();
     * Returns null if custom data path information is not available (due to BWC).
    }
    public String getCustomDataPath() {
package org.opensearch.indices.store;
 */
public class ShardAttributes implements Writeable {
import org.opensearch.core.common.io.stream.Writeable;
 * compatible open source license.
 * This class contains Attributes related to Shards that are necessary for making the  
    }  
}
    public String toString() {
 *
import org.opensearch.core.common.io.stream.StreamOutput;  
import java.io.IOException;  
 *
    /**
 * SPDX-License-Identifier: Apache-2.0
    public ShardAttributes(String customDataPath) {  
/*  
import org.opensearch.core.common.io.stream.StreamInput;
 * this file be licensed under the Apache-2.0 license or a
    @Nullable  
        return customDataPath;  
 */  
/**
    public ShardAttributes(StreamInput in) throws IOException {
     * Returns an empty string if no custom data path is used for this index.
    }
    private final String customDataPath;
        this.customDataPath = customDataPath;
 * {@link org.opensearch.gateway.TransportNodesListGatewayStartedShards} transport requests
    @Override
    }
 * @opensearch.internal  
     */  
        return "ShardAttributes{" + ", customDataPath='" + customDataPath + '\'' + '}';  
    @Nullable
     * Returns the custom data path that is used to look up information for this shard.  
