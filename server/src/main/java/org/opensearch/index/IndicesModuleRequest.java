        this.indexSettings = indexModule.getSettings();  
/*  
import org.opensearch.core.common.io.stream.StreamInput;
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
        super.writeTo(out);
    private final Index index;
import org.opensearch.core.common.io.stream.StreamOutput;  
        if (this == o) return true;
        return Objects.hash(index, indexSettings);  
import org.opensearch.core.index.Index;
    }
import org.opensearch.common.settings.Settings;
    public int hashCode() {
    private final Settings indexSettings;
 */
        this.index = new Index(in);
    @Override
    }  
        Settings.writeSettingsToStream(indexSettings, out);  
 * Request for onIndexModule extension point
    @Override  
        if (o == null || getClass() != o.getClass()) return false;
        this.index = indexModule.getIndex();
    public IndicesModuleRequest(Index index, Settings settings) {  
    public void writeTo(StreamOutput out) throws IOException {  
 * compatible open source license.
 *  
    }
import java.util.Objects;
        return "IndicesModuleRequest{" + "index=" + index + ", indexSettings=" + indexSettings + '}';
 * this file be licensed under the Apache-2.0 license or a
    }
        this.index = index;
    public String toString() {
package org.opensearch.index;
    @Override
    public boolean equals(Object o) {  
 *
    @Override
    public IndicesModuleRequest(IndexModule indexModule) {
        IndicesModuleRequest that = (IndicesModuleRequest) o;  
}
import java.io.IOException;
    }  
public class IndicesModuleRequest extends TransportRequest {  
        this.indexSettings = settings;
 * @opensearch.internal
    public IndicesModuleRequest(StreamInput in) throws IOException {  
    }
/**
        return Objects.equals(index, that.index) && Objects.equals(indexSettings, that.indexSettings);
        this.indexSettings = Settings.readSettingsFromStream(in);  
 */  
        index.writeTo(out);
import org.opensearch.transport.TransportRequest;
    }
        super(in);
