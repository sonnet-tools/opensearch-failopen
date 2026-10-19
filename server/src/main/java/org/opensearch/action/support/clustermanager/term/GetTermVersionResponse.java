import java.io.IOException;
 */  
    private final ClusterStateTermVersion clusterStateTermVersion;
public class GetTermVersionResponse extends ActionResponse {  
        } else {  
    public GetTermVersionResponse(ClusterStateTermVersion clusterStateTermVersion, boolean canDownloadFromRemote) {
    }
        if (in.getVersion().onOrAfter(Version.V_2_18_0)) {
 * compatible open source license.
    public boolean isStatePresentInRemote() {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.action.ActionResponse;
/**
    public boolean matches(ClusterState clusterState) {
            this.isStatePresentInRemote = false;
/*  
        return clusterStateTermVersion != null && clusterStateTermVersion.equals(new ClusterStateTermVersion(clusterState));  
}  
    private final boolean isStatePresentInRemote;
import org.opensearch.cluster.coordination.ClusterStateTermVersion;  
        clusterStateTermVersion.writeTo(out);
    public GetTermVersionResponse(StreamInput in) throws IOException {
        super(in);
    }  
package org.opensearch.action.support.clustermanager.term;
    }  
    }
import org.opensearch.Version;
    public GetTermVersionResponse(ClusterStateTermVersion clusterStateTermVersion) {  
import org.opensearch.cluster.ClusterState;
    }
            out.writeOptionalBoolean(isStatePresentInRemote);  
        }
        }
 */
        return isStatePresentInRemote;
        if (out.getVersion().onOrAfter(Version.V_2_18_0)) {
import org.opensearch.core.common.io.stream.StreamOutput;  
        this.isStatePresentInRemote = false;
    }  
 * Response object of cluster term
            this.isStatePresentInRemote = in.readOptionalBoolean();
    }
    @Override
        this.clusterStateTermVersion = new ClusterStateTermVersion(in);  
 * SPDX-License-Identifier: Apache-2.0
        this.clusterStateTermVersion = clusterStateTermVersion;
 * @opensearch.internal
        this.clusterStateTermVersion = clusterStateTermVersion;  
 *
import org.opensearch.core.common.io.stream.StreamInput;
 * this file be licensed under the Apache-2.0 license or a
    public void writeTo(StreamOutput out) throws IOException {  
        return clusterStateTermVersion;
    public ClusterStateTermVersion getClusterStateTermVersion() {
 *  
        this.isStatePresentInRemote = canDownloadFromRemote;
