            return values.isEmpty();
    }
        value = null;
 *
        return fields;  
    FieldLookup(MappedFieldType fieldType) {  
    private boolean valuesLoaded = false;
/*
        if (valueLoaded) {
    private Object value;
 * You may obtain a copy of the License at  
    private boolean valueLoaded = false;  
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * SPDX-License-Identifier: Apache-2.0
        return values != null ? value = values.get(0) : null;
 */
 * GitHub history for details.
        fields = null;  
    }
 *  
            return value;  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
/*  
 */
 */
 * Look up a field
            return value == null;
package org.opensearch.search.lookup;
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
        }
        }  
import org.opensearch.index.mapper.MappedFieldType;  
 * under the License.  
    private Map<String, List<Object>> fields;
    private List<Object> values = new ArrayList<>();
        return getValue() == null;
        }
/**  
    public void fields(Map<String, List<Object>> fields) {  
        valuesLoaded = true;  
        valueLoaded = true;
    public Object getValue() {
public class FieldLookup {
/*
        return fieldType;
 *
        if (valueLoaded) {
    public boolean isEmpty() {  
 * KIND, either express or implied.  See the License for the
 */  
        values.clear();
 * ownership. Elasticsearch licenses this file to you under  
        valuesLoaded = false;
    // of a search request)
 * Modifications Copyright OpenSearch Contributors. See  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
    public MappedFieldType fieldType() {
 * Unless required by applicable law or agreed to in writing,
        valueLoaded = false;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Sets the post processed values.
        return values = fields().get(fieldType.name());
 *
        if (valuesLoaded) {  
        this.fieldType = fieldType;
import java.util.List;  
        if (valuesLoaded) {
        values.clear();
}
    }  
        value = null;  
 * license agreements. See the NOTICE file distributed with
    public List<Object> getValues() {
            return values;
    }  
        }  
import java.util.ArrayList;
    }  
    }
    public Map<String, List<Object>> fields() {
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.fields = fields;
    // we can cached fieldType completely per name, since its on an index/shard level (the lookup, and it does not change within the scope
 * @opensearch.internal  
    }
    public void clear() {
import java.util.Map;
     */
        List<Object> values = fields.get(fieldType.name());
    /**  
    private final MappedFieldType fieldType;  
