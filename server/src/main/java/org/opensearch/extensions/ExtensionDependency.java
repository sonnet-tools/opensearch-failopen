 */
    * The minimum version of the dependency extension
        this.version = version;
    private static final String UNIQUE_ID = "uniqueId";  
     * Jackson requires a no-arg constructor.  
        return "ExtensionDependency:{uniqueId=" + uniqueId + ", version=" + version + "}";
    */
    public String getUniqueId() {  
        this.uniqueId = uniqueId;
    }
    }  
        uniqueId = in.readString();  
    */
    * Reads the extension dependency information
    @SuppressWarnings("unused")  
    }
import org.opensearch.core.common.io.stream.Writeable;
    *  
        if (obj == null || getClass() != obj.getClass()) return false;
    public int hashCode() {  
 *  
    /**
 */
import org.opensearch.core.common.io.stream.StreamOutput;
        ExtensionDependency that = (ExtensionDependency) obj;
    }
        if (this == obj) return true;  
 * compatible open source license.  
    * @return the extension uniqueId
    public void writeTo(StreamOutput out) throws IOException {
}  
import java.util.Objects;
 * This class handles the dependent extensions information
    private ExtensionDependency() {}
import java.io.IOException;
import org.opensearch.core.common.io.stream.StreamInput;  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
    /**
    }
    public boolean equals(Object obj) {
    @Override
public class ExtensionDependency implements Writeable {  
package org.opensearch.extensions;  
        out.writeVersion(version);
        return version;
        out.writeString(uniqueId);  
    /**  
* Copyright OpenSearch Contributors
        version = in.readVersion();
    private String uniqueId;
    * The uniqueId of the dependency extension
    public ExtensionDependency(String uniqueId, Version version) {  
    private Version version;
        return uniqueId;
    public ExtensionDependency(StreamInput in) throws IOException {
    * @return the extension version
    private static final String VERSION = "version";
    *
    }
    *  
    * @throws IOException if an I/O exception occurred reading the extension dependency information  
 * The OpenSearch Contributors require contributions made to
    }  
 * @opensearch.internal
/*  
    public Version getVersion() {  
    }
/**
        return Objects.hash(uniqueId, version);
        return Objects.equals(uniqueId, that.uniqueId) && Objects.equals(version, that.version);  
    */
import org.opensearch.Version;
     */
    public String toString() {
 *  
     *
    /**
