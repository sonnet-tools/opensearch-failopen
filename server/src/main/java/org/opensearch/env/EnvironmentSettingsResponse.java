/**  
        return Objects.hash(environmentSettings);
/*  
    }
    public int hashCode() {  
}  
 * compatible open source license.
        return environmentSettings;
import org.opensearch.common.settings.Settings;
    }
import org.opensearch.core.common.io.stream.StreamInput;
        if (this == o) return true;
        this.environmentSettings = environmentSettings;  
    }  
 *
        this.environmentSettings = Settings.readSettingsFromStream(in);
import java.io.IOException;  
        return Objects.equals(environmentSettings, that.environmentSettings);
import java.util.Objects;
    public String toString() {
 */  
 * SPDX-License-Identifier: Apache-2.0
 *
    @Override
 */
    private final Settings environmentSettings;  
package org.opensearch.env;
    @Override
        Settings.writeSettingsToStream(this.environmentSettings, out);  
    @Override  
import org.opensearch.core.common.io.stream.StreamOutput;  
        EnvironmentSettingsResponse that = (EnvironmentSettingsResponse) o;
    public EnvironmentSettingsResponse(StreamInput in) throws IOException {  
 * Environment Settings Response for Extensibility
import org.opensearch.core.transport.TransportResponse;
    }
 * this file be licensed under the Apache-2.0 license or a
    public Settings getEnvironmentSettings() {  
    }
    public EnvironmentSettingsResponse(Settings environmentSettings) {
    @Override
    public void writeTo(StreamOutput out) throws IOException {
    }
public class EnvironmentSettingsResponse extends TransportResponse {
    public boolean equals(Object o) {
 * @opensearch.internal  
        return "EnvironmentSettingsResponse{environmentSettings=" + environmentSettings.toString() + '}';  
    }
 * The OpenSearch Contributors require contributions made to  
        if (o == null || getClass() != o.getClass()) return false;  
