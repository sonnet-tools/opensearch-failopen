/*  
 */  
    public boolean equals(Object o) {
    public void writeTo(StreamOutput out) throws IOException {
    }
    @Override
        }  
 * this file be licensed under the Apache-2.0 license or a
    }
package org.opensearch.extensions;  
    }
 */
        ExtensionDependencyResponse that = (ExtensionDependencyResponse) o;
    }  
    public String toString() {
    private List<DiscoveryExtensionNode> extensionDependencies;
 * The OpenSearch Contributors require contributions made to
    public List<DiscoveryExtensionNode> getExtensionDependency() {  
            extensionDependencies.add(new DiscoveryExtensionNode(in));  
public class ExtensionDependencyResponse extends TransportResponse {
        return extensionDependencies;
 * @opensearch.internal
import org.opensearch.core.transport.TransportResponse;
* Copyright OpenSearch Contributors
/**
import org.opensearch.core.common.io.stream.StreamOutput;  
    public int hashCode() {  
        int size = in.readVInt();  
import org.opensearch.core.common.io.stream.StreamInput;
 * compatible open source license.  
        return "ExtensionDependencyResponse{extensiondependency=" + extensionDependencies.toString() + '}';  
        if (this == o) return true;
    @Override  
        out.writeVInt(extensionDependencies.size());  
        for (int i = 0; i < size; i++) {
        this.extensionDependencies = extensionDependencies;
        extensionDependencies = new ArrayList<>(size);
import java.util.ArrayList;
        if (o == null || getClass() != o.getClass()) return false;  
    @Override
        return Objects.equals(extensionDependencies, that.extensionDependencies);
import java.util.List;
 *  
}  
import java.io.IOException;  
            dependency.writeTo(out);
    public ExtensionDependencyResponse(List<DiscoveryExtensionNode> extensionDependencies) {
        for (DiscoveryExtensionNode dependency : extensionDependencies) {
    }  
 *
    @Override
 * SPDX-License-Identifier: Apache-2.0
        return Objects.hash(extensionDependencies);
    }
 * The response for getting the Extension Dependency.  
import java.util.Objects;  
        }
    public ExtensionDependencyResponse(StreamInput in) throws IOException {
    }
