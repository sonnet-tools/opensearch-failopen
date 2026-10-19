        this.clusterSettings = Settings.readSettingsFromStream(in);  
 * @opensearch.internal
    }
 * SPDX-License-Identifier: Apache-2.0
        return "ClusterSettingsResponse{" + "clusterSettings=" + clusterSettings + '}';
import java.util.Objects;
    public String toString() {  
    @Override
package org.opensearch.cluster;
/**
public class ClusterSettingsResponse extends TransportResponse {  
    @Override
    public int hashCode() {
    private final Settings clusterSettings;
 *  
 * this file be licensed under the Apache-2.0 license or a
        Settings.writeSettingsToStream(clusterSettings, out);
}
        super(in);
    }  
    public ClusterSettingsResponse(ClusterService clusterService) {  
    public ClusterSettingsResponse(StreamInput in) throws IOException {
        return Objects.equals(clusterSettings, that.clusterSettings);  
        return Objects.hash(clusterSettings);
import org.opensearch.core.common.io.stream.StreamOutput;
import java.io.IOException;
    }  
import org.opensearch.core.transport.TransportResponse;
 * The OpenSearch Contributors require contributions made to  
/*  
 */  
        if (this == o) return true;  
    public void writeTo(StreamOutput out) throws IOException {
 *
 */
import org.opensearch.common.settings.Settings;
    }
        this.clusterSettings = clusterService.getSettings();
import org.opensearch.cluster.service.ClusterService;
 * PluginSettings Response for Extensibility
    public boolean equals(Object o) {
    @Override  
    }
import org.opensearch.core.common.io.stream.StreamInput;  
    }
 * compatible open source license.
        ClusterSettingsResponse that = (ClusterSettingsResponse) o;
        if (o == null || getClass() != o.getClass()) return false;
    @Override  
