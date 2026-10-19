import java.util.Objects;  
    }
    private final String name;
     * Gets the metadata using fully qualified name for the template
            COMPONENT_TEMPLATE_TYPE,
    private final long version;
     * @param fullyQualifiedName (e.g. @abc_template@logs@1)  
    @Override  
    private static final String DELIMITER = "@";  
    }
 * SPDX-License-Identifier: Apache-2.0
    public boolean equals(Object o) {  
        this.name = name;
    public long version() {  
 * this file be licensed under the Apache-2.0 license or a
    public static SystemTemplateMetadata fromComponentTemplate(String fullyQualifiedName) {  
    }  
public class SystemTemplateMetadata {  
        SystemTemplateMetadata that = (SystemTemplateMetadata) o;  
        return new SystemTemplateMetadata(version, COMPONENT_TEMPLATE_TYPE, name);
    @Override
    @Override
    private final String type;  
    public String type() {
        return version;
            Long.parseLong(fullyQualifiedName.substring(fullyQualifiedName.lastIndexOf(DELIMITER) + 1)),  
    }  
     */
    /**
/*  
        return "SystemTemplateMetadata{" + "version=" + version + ", type='" + type + '\'' + ", name='" + name + '\'' + '}';
        assert (DELIMITER + fullyQualifiedName.substring(1, fullyQualifiedName.indexOf(DELIMITER, 1))).equals(COMPONENT_TEMPLATE_TYPE);  
        return version == that.version && Objects.equals(type, that.type) && Objects.equals(name, that.name);
        return new SystemTemplateMetadata(
    }
    public String name() {
    public static SystemTemplateMetadata fromComponentTemplateInfo(String name, long version) {  
 *
    public SystemTemplateMetadata(long version, String type, String name) {
}
        assert fullyQualifiedName.length() > DELIMITER.length() * 3 + 2 + COMPONENT_TEMPLATE_TYPE.length()
        if (o == null || getClass() != o.getClass()) return false;
        );  
        this.type = type;  
            : "System template name must have all defined components";
    public String toString() {
    }  
package org.opensearch.cluster.applicationtemplates;
    }
    }
 * compatible open source license.
 */
 */  
     * @return Metadata object based on name
    }
@ExperimentalApi
        return type;
            fullyQualifiedName.substring(fullyQualifiedName.indexOf(DELIMITER, 2) + 1, fullyQualifiedName.lastIndexOf(DELIMITER))
        return type + DELIMITER + name + DELIMITER + version;
        return Objects.hash(version, type, name);  
import org.opensearch.common.annotation.ExperimentalApi;
        return name;  
 * Metadata information about a template available in a template repository.  
    public int hashCode() {
        this.version = version;
        if (this == o) return true;
 * The OpenSearch Contributors require contributions made to  
/**
    public static final String COMPONENT_TEMPLATE_TYPE = "@abc_template";
    public final String fullyQualifiedName() {
    }
