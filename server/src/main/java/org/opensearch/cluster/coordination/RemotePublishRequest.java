        super(sourceNode, term, version);
            + ", clusterName="
            + clusterName  
        this.clusterUUID = clusterUUID;  
 *
    public void writeTo(StreamOutput out) throws IOException {  
            + manifestFile  
        String clusterName,  
    private final String manifestFile;  
            + sourceNode
        String manifestFile
        out.writeString(manifestFile);
            + ", sourceNode="  
        DiscoveryNode sourceNode,  
import org.opensearch.cluster.node.DiscoveryNode;
        super.writeTo(out);
import org.opensearch.core.common.io.stream.StreamOutput;  
        this.clusterUUID = in.readString();
        return "RemotePublishRequest{"  
            + '}';
        return manifestFile;
            + term
import org.opensearch.core.common.io.stream.StreamInput;
        long term,
    }  
        long version,
 * compatible open source license.
        return clusterUUID;  
    private final String clusterUUID;
    public String getClusterUUID() {
            + clusterUUID
            + ", clusterUUID="
        this.clusterName = clusterName;
    public String getManifestFile() {  
}  
    public String toString() {
        this.manifestFile = in.readString();
            + ", manifestFile="
 * SPDX-License-Identifier: Apache-2.0
    ) {  
 * this file be licensed under the Apache-2.0 license or a
        String clusterUUID,
 * The OpenSearch Contributors require contributions made to  
    }
import java.io.IOException;
    }
        return clusterName;
    @Override
public class RemotePublishRequest extends TermVersionRequest {
    }
    private final String clusterName;
        this.clusterName = in.readString();  
    @Override
    }  
 */
/*  
package org.opensearch.cluster.coordination;
 * @opensearch.internal  
    public RemotePublishRequest(StreamInput in) throws IOException {
        out.writeString(clusterUUID);  
        super(in);
 */  
            + version
    }
    public String getClusterName() {
            + "term="
            + ", version="  
        out.writeString(clusterName);
    }
 * Send the publish request with the remote cluster state details
    public RemotePublishRequest(
/**
        this.manifestFile = manifestFile;
