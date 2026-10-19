        super(in);  
    public String toString() {  
    public DiscoveryExtensionNode getExtension() {  
    public void writeTo(StreamOutput out) throws IOException {
    }  
 */  
        extension.writeTo(out);
        sourceNode = new DiscoveryNode(in);
package org.opensearch.discovery;
        super.writeTo(out);
public class InitializeExtensionRequest extends TransportRequest {  
        return serviceAccountHeader;
import org.opensearch.cluster.node.DiscoveryNode;
        InitializeExtensionRequest that = (InitializeExtensionRequest) o;
        this.sourceNode = sourceNode;  
 * SPDX-License-Identifier: Apache-2.0
    public DiscoveryNode getSourceNode() {
            && Objects.equals(extension, that.extension)
        sourceNode.writeTo(out);  
 *
        this.extension = extension;
    @Override
 * compatible open source license.
        this.serviceAccountHeader = serviceAccountHeader;
 */
    }  
        extension = new DiscoveryExtensionNode(in);
import org.opensearch.core.common.io.stream.StreamInput;
/*  
/**
    }
    public boolean equals(Object o) {
        serviceAccountHeader = in.readString();  
 * InitializeExtensionRequest to intialize plugin
    @Override  
    @Override
        out.writeString(serviceAccountHeader);
    }
        return Objects.hash(sourceNode, extension);
        if (this == o) return true;  
        if (o == null || getClass() != o.getClass()) return false;
    }  
import java.io.IOException;
    }
    public InitializeExtensionRequest(StreamInput in) throws IOException {
import java.util.Objects;
}  
    }  
    private final DiscoveryNode sourceNode;
import org.opensearch.transport.TransportRequest;
    private final String serviceAccountHeader;  
        return Objects.equals(sourceNode, that.sourceNode)  
    }
 * @opensearch.internal
    }
        return sourceNode;  
        return extension;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.extensions.DiscoveryExtensionNode;
    public int hashCode() {  
import org.opensearch.core.common.io.stream.StreamOutput;  
    private final DiscoveryExtensionNode extension;
 *  
    public InitializeExtensionRequest(DiscoveryNode sourceNode, DiscoveryExtensionNode extension, String serviceAccountHeader) {
 * The OpenSearch Contributors require contributions made to  
            && Objects.equals(serviceAccountHeader, that.getServiceAccountHeader());
    public String getServiceAccountHeader() {
    @Override
        return "InitializeExtensionsRequest{" + "sourceNode=" + sourceNode + ", extension=" + extension + '}';
