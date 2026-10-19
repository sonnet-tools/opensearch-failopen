    private final CompositeMappedFieldType.CompositeFieldType compositeFieldType;
     *
    /**
    }  
     */  
import org.opensearch.index.mapper.CompositeMappedFieldType;
     *
 * this file be licensed under the Apache-2.0 license or a
    /**  
package org.opensearch.index.compositeindex;
 * SPDX-License-Identifier: Apache-2.0
    public CompositeIndexMetadata(String compositeFieldName, CompositeMappedFieldType.CompositeFieldType compositeFieldType) {  
public class CompositeIndexMetadata {
     */  
/**  
 *
    }  
 */  
    }  
     * @return the composite field name
     *
     * @param compositeFieldType the type of the composite field
 *
    /**
}
 */  
     * @return the composite field type
     * Returns the type of the composite field.  
 * the composite field name, type, and the specific metadata for the type of composite field
     * Constructs a CompositeIndexMetadata object with the provided composite field name and type.
        this.compositeFieldName = compositeFieldName;
 * This class represents the metadata of a Composite Index, which includes information about
 * compatible open source license.
        return compositeFieldType;
/*  
     */
 * The OpenSearch Contributors require contributions made to  
 * (e.g., Star Tree metadata).  
     * Returns the name of the composite field.  
    private final String compositeFieldName;  
        this.compositeFieldType = compositeFieldType;
    public CompositeMappedFieldType.CompositeFieldType getCompositeFieldType() {
     * @param compositeFieldName the name of the composite field  
    public String getCompositeFieldName() {
 * @opensearch.experimental
        return compositeFieldName;
