 *
     * Supported composite field types
            for (CompositeFieldType metric : CompositeFieldType.values()) {  
 * @opensearch.experimental
    public enum CompositeFieldType {  
    public CompositeMappedFieldType(
 * SPDX-License-Identifier: Apache-2.0
     * @opensearch.experimental  
 */
        STAR_TREE("star_tree"),
        List<String> fields,  
        CompositeFieldType(String name) {  
 *  
        this(name, false, false, false, TextSearchInfo.NONE, Collections.emptyMap(), fields, type);  
    }  
public abstract class CompositeMappedFieldType extends MappedFieldType {
        return fields;
        }  
    }
    }
 * this file be licensed under the Apache-2.0 license or a
    ) {
 * The OpenSearch Contributors require contributions made to  
/*  
        CONTEXT_AWARE_GROUPING("context_aware_grouping");
        }  
     *
    public List<String> fields() {
        return type;
        boolean hasDocValues,  
                if (metric.getName().equalsIgnoreCase(name)) {
        this.fields = fields;
        }
        boolean isIndexed,
        Map<String, String> meta,
    }
                    return metric;
        this.type = type;
        CompositeFieldType type
import java.util.Map;
    /**  
            }
        String name,  
        public String getName() {
import java.util.Collections;  
 */  
        super(name, isIndexed, isStored, hasDocValues, textSearchInfo, meta);  
        private final String name;
            throw new IllegalArgumentException("Invalid metric stat: " + name);
    @ExperimentalApi
import org.opensearch.common.annotation.ExperimentalApi;
    private final List<String> fields;
                }  
    private final CompositeFieldType type;  
            return name;
@ExperimentalApi  
        TextSearchInfo textSearchInfo,
    }  
        public static CompositeFieldType fromName(String name) {
     */
import java.util.List;
}
 * Base class for composite field types
            this.name = name;
    public CompositeMappedFieldType(String name, List<String> fields, CompositeFieldType type) {
 * compatible open source license.
/**
package org.opensearch.index.mapper;
        boolean isStored,
    public CompositeFieldType getCompositeIndexType() {  
