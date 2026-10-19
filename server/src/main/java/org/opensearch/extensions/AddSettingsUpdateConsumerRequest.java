            componentSetting.writeTo(out);
        // Write component setting list to stream output
    }  
    }
    }
    }  
    @Override
        return new ArrayList<>(this.componentSettings);
    public boolean equals(Object obj) {
import java.util.Objects;
 *
    private final DiscoveryExtensionNode extensionNode;  
            this.componentSettings.add(new WriteableSetting(in));  
import org.opensearch.core.common.io.stream.StreamOutput;
        // Write extension node to stream output
 */  
        super.writeTo(out);  
import java.util.ArrayList;
        }
 */
        // Read in component setting list
        }
        return this.extensionNode;
        if (obj == null || getClass() != obj.getClass()) return false;
import org.opensearch.common.settings.Setting;
 * Add Settings Update Consumer Request for Extensibility
 *
/*  
        int componentSettingsCount = in.readVInt();  
    }
import java.util.List;  
    public int hashCode() {
/**  
        AddSettingsUpdateConsumerRequest that = (AddSettingsUpdateConsumerRequest) obj;
        }  
        return Objects.equals(extensionNode, that.extensionNode) && Objects.equals(componentSettings, that.componentSettings);  
    public DiscoveryExtensionNode getExtensionNode() {
    }
    @Override
import java.io.IOException;
        for (Setting<?> setting : componentSettings) {  
            this.componentSettings.add(new WriteableSetting(setting));
    public AddSettingsUpdateConsumerRequest(StreamInput in) throws IOException {
    }  
        this.extensionNode.writeTo(out);  
    @Override  
        this.extensionNode = extensionNode;
        super(in);  
    @Override
import org.opensearch.core.common.io.stream.StreamInput;  
package org.opensearch.extensions;
        this.componentSettings = new ArrayList<>(componentSettingsCount);
import org.opensearch.common.settings.WriteableSetting;
    }
 * compatible open source license.
import org.opensearch.transport.TransportRequest;
        for (WriteableSetting componentSetting : this.componentSettings) {
 * @opensearch.internal  
public class AddSettingsUpdateConsumerRequest extends TransportRequest {
    public String toString() {  
        return Objects.hash(extensionNode, componentSettings);
        this.componentSettings = new ArrayList<>(componentSettings.size());
    public List<WriteableSetting> getComponentSettings() {  
 * SPDX-License-Identifier: Apache-2.0
        for (int i = 0; i < componentSettingsCount; i++) {
    public AddSettingsUpdateConsumerRequest(DiscoveryExtensionNode extensionNode, List<Setting<?>> componentSettings) {  
 * this file be licensed under the Apache-2.0 license or a
}
        out.writeVInt(this.componentSettings.size());  
        if (this == obj) return true;  
        this.extensionNode = new DiscoveryExtensionNode(in);  
        return "AddSettingsUpdateConsumerRequest{extensionNode=" + this.extensionNode.toString() + "}";
 * The OpenSearch Contributors require contributions made to  
    public void writeTo(StreamOutput out) throws IOException {
        // Set extension node to send update settings request to
    private final List<WriteableSetting> componentSettings;
