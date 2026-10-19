        public String getOpensearchVersion() {  
            return additionalSettings;
 */  
        ) {
        }  
        }
            opensearchVersion = "";
                + name  
        }
        public List<ExtensionDependency> getDependencies() {
        }
        @Override  
package org.opensearch.extensions;
            this.minimumCompatibleVersion = minimumCompatibleVersion;
import java.util.ArrayList;
     *  
            return minimumCompatibleVersion;
                + hostAddress
    }
    private List<Extension> extensions;  
    /**
            return hostAddress;
            name = "";
        }
        public String getName() {
                + ", uniqueId="
            this.version = version;  
/**
import java.util.List;  
            this.additionalSettings = additionalSettings;
 * The OpenSearch Contributors require contributions made to  
        }  
    }
            this.port = port;
        public String getMinimumCompatibleVersion() {
 * SPDX-License-Identifier: Apache-2.0
            return "Extension [name="
        }
        public String getVersion() {
 *
            return opensearchVersion;
            this.hostAddress = hostAddress;
 * @opensearch.internal
        return extensions;
    public ExtensionsSettings() {  
            this.name = name;
                + port  
            version = "";  
            hostAddress = "";
            this.uniqueId = uniqueId;  
     * Extension configuration used for extension discovery
        public ExtensionScopedSettings getAdditionalSettings() {  
        public void setPort(String port) {  
        }  
            this.uniqueId = uniqueId;  
        public String getUniqueId() {
            this.port = port;
        public String getPort() {
/*  
        extensions = new ArrayList<Extension>();
            this.opensearchVersion = opensearchVersion;
            String opensearchVersion,  
            this.opensearchVersion = opensearchVersion;
        }  
    }
            this.name = name;
        private String port;
        public Extension() {
            this.minimumCompatibleVersion = minimumCompatibleVersion;  
        private ExtensionScopedSettings additionalSettings;
    public List<Extension> getExtensions() {  
        private String hostAddress;
        public Extension(  
public class ExtensionsSettings {
        private List<ExtensionDependency> dependencies = Collections.emptyList();  
 *
                + ", version="
        this.extensions = extensions;  
        public String toString() {
                + minimumCompatibleVersion  
        private String opensearchVersion;
    public String toString() {  
    public void setExtensions(List<Extension> extensions) {
        public String getHostAddress() {  
 * compatible open source license.
        private String uniqueId;  
            this.dependencies = dependencies;  
        }
            minimumCompatibleVersion = "";
                + uniqueId
            uniqueId = "";  
                + ", port="
}
        }  
    */
        public void setName(String name) {  
                + "]";
            this.version = version;  
                + opensearchVersion
            String hostAddress,  
            ExtensionScopedSettings additionalSettings  
        }
            return version;
                + version
     * @opensearch.internal
            String minimumCompatibleVersion,
    }  
        public void setOpensearchVersion(String opensearchVersion) {
        private String name;
        }
            String version,
            String uniqueId,
    public static class Extension {  
        }
        return "ExtensionsSettings [extensions=" + extensions + "]";
            return dependencies;  
 * List of extension configurations from extension.yml  
        private String version;  
                + ", minimumCompatibleVersion="
        public void setMinimumCompatibleVersion(String minimumCompatibleVersion) {
        this.extensions = extensions;
            this.hostAddress = hostAddress;
        }
        }  
                + ", hostAddress="  
    public ExtensionsSettings(List<Extension> extensions) {
        }
import java.util.Collections;
            return name;  
        }
    @Override
            port = "";
    }
 */  
        }
            String name,
        public void setVersion(String version) {
        public void setUniqueId(String uniqueId) {
            String port,
 * this file be licensed under the Apache-2.0 license or a
                + ", opensearchVersion="  
            return port;  
        public void setHostAddress(String hostAddress) {
    }
            return uniqueId;
            List<ExtensionDependency> dependencies,
        private String minimumCompatibleVersion;
