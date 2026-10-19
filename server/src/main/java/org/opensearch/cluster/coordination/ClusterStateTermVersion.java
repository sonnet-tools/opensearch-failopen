import org.opensearch.cluster.ClusterName;
    }
    }
        this.version = state.version();
    private final long version;
    public void writeTo(StreamOutput out) throws IOException {
        this.clusterUUID = state.metadata().clusterUUID();
            + clusterName
            + ", term="  
        if (!clusterName.equals(that.clusterName)) return false;
 * SPDX-License-Identifier: Apache-2.0
    public long getTerm() {
        return clusterName;
        return clusterUUID;
        return result;
import java.io.IOException;
        return "ClusterStateTermVersion{"  
}
    }  
            + term
    public ClusterStateTermVersion(ClusterState state) {  
    public ClusterStateTermVersion(StreamInput in) throws IOException {
        if (this == o) return true;  
    }  
    public int hashCode() {  
        this.clusterUUID = in.readString();
            + version  
        ClusterStateTermVersion that = (ClusterStateTermVersion) o;  
package org.opensearch.cluster.coordination;
    }  
        out.writeLong(term);
            + "clusterName="
    }
    @Override
    }
    public String toString() {
    private final long term;
        this.version = in.readLong();  
 * compatible open source license.
            + ", version="
/**  
 *
        this.term = in.readLong();
import org.opensearch.core.common.io.stream.StreamOutput;
    public ClusterName getClusterName() {  
        this.term = state.term();  
            + '\''
        return term;  
    public boolean equals(Object o) {
    private final String clusterUUID;  
        result = 31 * result + (int) (version ^ (version >>> 32));
    public long getVersion() {  
 * Identifies a specific version of ClusterState at a node.
        this.clusterUUID = clusterUUID;  
        result = 31 * result + clusterUUID.hashCode();
            + '}';
 * The OpenSearch Contributors require contributions made to  
        return clusterUUID.equals(that.clusterUUID);
        this.clusterName = new ClusterName(in);  
        if (o == null || getClass() != o.getClass()) return false;
        if (term != that.term) return false;
    }
        if (version != that.version) return false;  
    @Override
            + clusterUUID
public class ClusterStateTermVersion implements Writeable {  
            + ", clusterUUID='"  
        this.term = term;
        int result = clusterName.hashCode();
    @Override
        this.clusterName = state.getClusterName();
import org.opensearch.core.common.io.stream.StreamInput;  
    public ClusterStateTermVersion(ClusterName clusterName, String clusterUUID, long term, long version) {
        return version;
/*  
    }
 */  
 * this file be licensed under the Apache-2.0 license or a
        this.clusterName = clusterName;
        out.writeLong(version);  
        clusterName.writeTo(out);  
    @Override
        this.version = version;
 */
    public String getClusterUUID() {
        out.writeString(clusterUUID);
    private final ClusterName clusterName;
import org.opensearch.cluster.ClusterState;
    }  
import org.opensearch.core.common.io.stream.Writeable;
        result = 31 * result + (int) (term ^ (term >>> 32));  
    }
