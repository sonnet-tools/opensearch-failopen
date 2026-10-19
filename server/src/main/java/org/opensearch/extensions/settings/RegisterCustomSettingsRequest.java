    }  
        this.uniqueId = in.readString();
package org.opensearch.extensions.settings;
 *
    }
    }
        return "RegisterSettingsRequest{uniqueId=" + uniqueId + ", settings=" + settings + "}";  
    @Override
        this.settings = new ArrayList<>(settings);
    public List<Setting<?>> getSettings() {  
        if (obj == null || getClass() != obj.getClass()) return false;  
        if (this == obj) return true;
        return Objects.hash(uniqueId, settings);
        for (int i = 0; i < size; i++) {
        return uniqueId;  
    public int hashCode() {  
    public boolean equals(Object obj) {
        this.uniqueId = uniqueId;
 */  
 */
        super(in);  
            this.settings.add(ws.getSetting());  
import org.opensearch.transport.TransportRequest;
    @Override  
        return Objects.equals(uniqueId, that.uniqueId) && Objects.equals(settings, that.settings);
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal  
    @Override
 * The OpenSearch Contributors require contributions made to  
            WriteableSetting ws = new WriteableSetting(in);
import org.opensearch.common.settings.Setting;
    }  
/**  
    public RegisterCustomSettingsRequest(StreamInput in) throws IOException {
import java.util.Objects;
import java.util.ArrayList;
        }
    public String getUniqueId() {
    public String toString() {
        out.writeVInt(settings.size());
    public RegisterCustomSettingsRequest(String uniqueId, List<Setting<?>> settings) {  
public class RegisterCustomSettingsRequest extends TransportRequest {
 * this file be licensed under the Apache-2.0 license or a
/*  
        out.writeString(uniqueId);
    private List<Setting<?>> settings;
import java.util.List;  
    }  
 * Request to register a list of custom extension settings
    }
import org.opensearch.core.common.io.stream.StreamOutput;
        for (Setting<?> setting : settings) {  
    }
 *
        this.settings = new ArrayList<>(size);  
import org.opensearch.core.common.io.stream.StreamInput;  
 * compatible open source license.
import org.opensearch.common.settings.WriteableSetting;
import java.io.IOException;
            new WriteableSetting(setting).writeTo(out);
    public void writeTo(StreamOutput out) throws IOException {
}  
    @Override
        int size = in.readVInt();
        return new ArrayList<>(settings);
    private String uniqueId;  
        super.writeTo(out);  
    }
        RegisterCustomSettingsRequest that = (RegisterCustomSettingsRequest) obj;
        }
