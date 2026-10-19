package org.opensearch.dsl.aggregation;
     * Creates a field grouping with no {@code missing} substitutions.
}  
     *
    }
public class FieldGrouping implements GroupingInfo {
     *
 * Field-based grouping: GROUP BY field1, field2, ...
    }
     */  
 * The OpenSearch Contributors require contributions made to  
    public FieldGrouping(List<String> fieldNames, Map<String, Object> missingByField) {
 * this file be licensed under the Apache-2.0 license or a
     * @param fieldNames the field names to group by  
    }
/*  
     */
    @Override  
     * @param missingByField the {@code missing} null-substitution value per field; fields
/**
        return missingByField;
    public Map<String, Object> getMissingByField() {  
    private final List<String> fieldNames;  
    @Override
    /**  
    /**  
import java.util.Map;
import java.util.List;
        this(fieldNames, Map.of());  
     * Creates a field grouping.
 */  
 */  
     * @param fieldNames the field names to group by  
    }  
 *
        this.missingByField = Map.copyOf(missingByField);  
    public FieldGrouping(List<String> fieldNames) {
 * SPDX-License-Identifier: Apache-2.0
        return fieldNames;
        this.fieldNames = List.copyOf(fieldNames);
    private final Map<String, Object> missingByField;
 * compatible open source license.
    public List<String> getFieldNames() {
     *        absent from the map exclude null-valued documents from grouping
