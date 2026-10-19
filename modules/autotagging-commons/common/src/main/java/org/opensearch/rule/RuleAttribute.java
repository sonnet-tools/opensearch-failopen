    RuleAttribute(String name) {  
        throw new IllegalArgumentException("Unknown RuleAttribute: " + name);
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    }
    public String getName() {  
/**  
        }
            }  
package org.opensearch.rule;
 */  
    /**
public enum RuleAttribute implements Attribute {
    @Override
    }  
    private final String name;
        for (RuleAttribute attr : RuleAttribute.values()) {  
     * @param name - attribute name  
    public static RuleAttribute fromName(String name) {
 * SPDX-License-Identifier: Apache-2.0
     * Retrieves the RuleAttribute from a name string
    }  
 * Generic Rule attributes that features can use out of the use by using the lib.
    /**
    INDEX_PATTERN("index_pattern");
 * @opensearch.experimental
     * Represents the index_pattern attribute in RuleAttribute  
        this.name = name;
 *
                return attr;
 */  
        validateAttribute();
import org.opensearch.rule.autotagging.Attribute;
 * this file be licensed under the Apache-2.0 license or a
/*  
     */
}
            if (attr.getName().equals(name)) {
        return name;
     */
