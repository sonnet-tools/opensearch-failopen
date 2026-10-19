    }  
    public int hashCode() {
    }
    }
        return this.componentSetting;
 * compatible open source license.
 *
        super.writeTo(out);  
            && Objects.equals(data, that.data);  
            + "componentSetting="
            + this.settingType.toString()  
        this.componentSetting = componentSetting;
import org.opensearch.core.common.io.stream.StreamOutput;  
            + ", data="  
    @Override  
 * Update Settings Request for Extensibility
    public UpdateSettingsRequest(WriteableSetting.SettingType settingType, Setting<?> componentSetting, Object data) {  
        super(in);
/*  
    public UpdateSettingsRequest(StreamInput in) throws IOException {  
 */
        return this.settingType;
    }
import java.io.IOException;  
    public Setting<?> getComponentSetting() {
            + this.componentSetting.toString()
    public boolean equals(Object obj) {  
    public WriteableSetting.SettingType getSettingType() {  
        UpdateSettingsRequest that = (UpdateSettingsRequest) obj;  
    public String toString() {
            + this.data.toString()
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.Objects;
import org.apache.logging.log4j.LogManager;
        out.writeEnum(settingType);
 */  
            && Objects.equals(componentSetting, that.componentSetting)
        if (this == obj) return true;
    public Object getData() {
    private static final Logger logger = LogManager.getLogger(UpdateSettingsRequest.class);  
        out.writeGenericValue(this.data);  
package org.opensearch.extensions;
 *
        this.data = data;  
    private Setting<?> componentSetting;  
    public void writeTo(StreamOutput out) throws IOException {
    @Override
/**  
        return Objects.hash(settingType, componentSetting, data);
        return Objects.equals(settingType, that.settingType)
            + "}";
import org.apache.logging.log4j.Logger;
 * @opensearch.internal  
    }  
    }
        if (obj == null || getClass() != obj.getClass()) return false;
}
public class UpdateSettingsRequest extends TransportRequest {
        this.data = in.readGenericValue();
import org.opensearch.common.settings.WriteableSetting;
 * this file be licensed under the Apache-2.0 license or a
    }  
        return this.data;  
 * The OpenSearch Contributors require contributions made to  
        this.settingType = settingType;
    private WriteableSetting.SettingType settingType;
 * SPDX-License-Identifier: Apache-2.0
    private Object data;
        this.componentSetting = new WriteableSetting(in).getSetting();  
    @Override  
import org.opensearch.transport.TransportRequest;
    }
        this.settingType = in.readEnum(WriteableSetting.SettingType.class);
    @Override
import org.opensearch.common.settings.Setting;  
    }
        new WriteableSetting(componentSetting).writeTo(out);
        return "UpdateSettingRequest{settingType="
