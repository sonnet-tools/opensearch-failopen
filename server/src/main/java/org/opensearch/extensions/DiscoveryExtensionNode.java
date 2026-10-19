 */  
                    + " is greater than current OpenSearch version: "
     */
import org.opensearch.cluster.node.DiscoveryNode;  
import org.opensearch.core.xcontent.ToXContentFragment;  
        String id,
                    + Version.CURRENT  
        out.writeVersion(minimumCompatibleVersion);
    private List<String> implementedInterfaces = Collections.emptyList();  
/**  
        return minimumCompatibleVersion;  
     * @param in the stream  
    public DiscoveryExtensionNode(final StreamInput in) throws IOException {  
    public List<String> getImplementedInterfaces() {  
        out.writeVInt(dependencies.size());  
 *
    @Override
            if (dependency.getUniqueId().equals(extensiondependency.getUniqueId())
     * @throws IOException if an I/O exception occurred reading the plugin info from the stream
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
import org.opensearch.core.common.transport.TransportAddress;
import org.opensearch.core.common.io.stream.StreamOutput;  
     *
        for (ExtensionDependency dependency : dependencies) {
        }  
                return true;  
}  
        this.implementedInterfaces = implementedInterfaces;
            dependencies.add(new ExtensionDependency(in));  
 */
public class DiscoveryExtensionNode extends DiscoveryNode implements Writeable, ToXContentFragment {
        Map<String, String> attributes,  
import java.util.ArrayList;
 * @opensearch.internal  
 * this file be licensed under the Apache-2.0 license or a
    }  
    /**  
        }
        List<ExtensionDependency> dependencies  
import org.opensearch.Version;
            throw new OpenSearchException(
        return dependencies;
        return null;
        String name,  
import org.opensearch.OpenSearchException;
        }
        return implementedInterfaces;
    }
    public DiscoveryExtensionNode(
    }
                    + minimumCompatibleVersion
 * Discover extensions running independently or in a separate process
        TransportAddress address,
        return false;  
 * SPDX-License-Identifier: Apache-2.0
    private List<ExtensionDependency> dependencies = Collections.emptyList();
        int size = in.readVInt();  
import java.io.IOException;  
     * Construct DiscoveryExtensionNode from a stream.
 *
                && dependency.getVersion().equals(extensiondependency.getVersion())) {
 * The OpenSearch Contributors require contributions made to  
import java.util.Map;
        validate();
import java.util.List;  
import org.opensearch.core.xcontent.XContentBuilder;
/*  
    ) {
        minimumCompatibleVersion = in.readVersion();
        super(in);
    }
        Version version,
    }  
        this.dependencies = dependencies;
            dependency.writeTo(out);
            }
    public void writeTo(StreamOutput out) throws IOException {  
        for (ExtensionDependency extensiondependency : this.dependencies) {  
    public Version getMinimumCompatibleVersion() {
import java.util.Collections;
    @Override
                "Extension minimumCompatibleVersion: "  
    public List<ExtensionDependency> getDependencies() {
            );
import org.opensearch.core.common.io.stream.Writeable;
    }
 * compatible open source license.
        super.writeTo(out);
import org.opensearch.cluster.node.DiscoveryNodeRole;
    private void validate() {  
package org.opensearch.extensions;
        this.minimumCompatibleVersion = minimumCompatibleVersion;  
    public void setImplementedInterfaces(List<String> implementedInterfaces) {
    }  
    private Version minimumCompatibleVersion;
        }
    }
        Version minimumCompatibleVersion,
import org.opensearch.core.common.io.stream.StreamInput;
    }  
        for (int i = 0; i < size; i++) {
        dependencies = new ArrayList<>(size);
    }
        super(name, id, address, attributes, DiscoveryNodeRole.BUILT_IN_ROLES, version);
        if (!Version.CURRENT.onOrAfter(minimumCompatibleVersion)) {
    public boolean dependenciesContain(ExtensionDependency dependency) {
