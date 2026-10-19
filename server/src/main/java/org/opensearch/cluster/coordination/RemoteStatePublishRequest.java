 *
        return Objects.equals(manifest, that.manifest);
package org.opensearch.cluster.coordination;
        if (this == o) return true;
 */  
    }
 *
    public int hashCode() {  
 * @opensearch.internal  
    @Override
        super(acceptedState);  
    private final ClusterMetadataManifest manifest;  
        RemoteStatePublishRequest that = (RemoteStatePublishRequest) o;
        this.manifest = acceptedManifest;
import org.opensearch.gateway.remote.ClusterMetadataManifest;
    }
        return manifest;
/*  
import java.util.Objects;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        if (o == null || getClass() != o.getClass()) return false;
        return "RemoteStatePublishRequest{" + super.toString() + "manifest=" + manifest + "} ";  
    @Override
    }
}
    public boolean equals(Object o) {  
    @Override
    }  
import org.opensearch.cluster.ClusterState;
public class RemoteStatePublishRequest extends PublishRequest {
    public ClusterMetadataManifest getAcceptedManifest() {
        if (!super.equals(o)) return false;  
 * this file be licensed under the Apache-2.0 license or a
        return Objects.hash(super.hashCode(), manifest);
    }  
 * PublishRequest created by downloading the accepted {@link ClusterState} from Remote Store, using  the published {@link ClusterMetadataManifest}
 * compatible open source license.
/**  
    public String toString() {
 */
    public RemoteStatePublishRequest(ClusterState acceptedState, ClusterMetadataManifest acceptedManifest) {
