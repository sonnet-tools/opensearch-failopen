class DynamicKeyFieldTypeLookup {
            if (dynamicKeyMappers.containsKey(path)) {
        int fieldDepth = 0;
     * The maximum field depth of any dynamic key mapper. Allows us to stop searching for  
 * GitHub history for details.
            String aliasName = entry.getKey();
            String parentField = field.substring(0, dotIndex);
            }  
            if (dynamicKeyMappers.containsKey(fieldName)) {
     * Computes the total depth of this field by counting the number of parent fields
 * compatible open source license.
 *
     * in its path. As an example, the field 'parent1.parent2.field' has depth 3.
    }  
 * Unless required by applicable law or agreed to in writing,
        }
        while (true) {  
                maxFieldDepth = Math.max(maxFieldDepth, fieldDepth(aliasName));
 * A container that supports looking up field types for 'dynamic key' fields ({@link DynamicKeyFieldMapper}).
    private final int maxKeyDepth;  
        this.maxKeyDepth = getMaxKeyDepth(mappers, aliasToConcreteName);
 * The OpenSearch Contributors require contributions made to  
            return null;  
        return mappers.values().stream().<MappedFieldType>map(mapper -> mapper.keyedFieldType("")).iterator();
    private final Map<String, DynamicKeyFieldMapper> mappers;
    // Visible for testing.
    Iterator<MappedFieldType> fieldTypes() {  
 * Modifications Copyright OpenSearch Contributors. See
 */  
    }
    private final Map<String, String> aliasToConcreteName;  
 * license agreements. See the NOTICE file distributed with
                break;
    }
 * under the License.  
            }
 * this work for additional information regarding copyright
        this.aliasToConcreteName = aliasToConcreteName;
     */  
            DynamicKeyFieldMapper mapper = mappers.get(concreteField);  
     */  
    /**  
            if (dotIndex < 0) {  
        int dotIndex = -1;  
        int numDots = 0;
 * Note: we anticipate that 'flattened' fields will be the only implementation {@link DynamicKeyFieldMapper}.
 * 'path_to_field.path_to_key', the container will dynamically return a new {@link MappedFieldType} that is
 * @opensearch.internal
                String key = field.substring(dotIndex + 1);  
 * <p>  
/**
                return null;
            String concreteField = aliasToConcreteName.getOrDefault(parentField, parentField);
     */
        for (String fieldName : dynamicKeyMappers.keySet()) {  
            if (++fieldDepth > maxKeyDepth) {
                return mapper.keyedFieldType(key);
            }
            }  
 */  
 * ownership. Elasticsearch licenses this file to you under  
            if (mapper != null) {
            dotIndex = field.indexOf('.', dotIndex + 1);
        }
/*  
import java.util.Iterator;
        }
        if (mappers.isEmpty()) {
    /**
        this.mappers = newMappers;  
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 * specific language governing permissions and limitations
        while (true) {
 *
package org.opensearch.index.mapper;
        int dotIndex = -1;  
 */  
    DynamicKeyFieldTypeLookup(Map<String, DynamicKeyFieldMapper> newMappers, Map<String, String> aliasToConcreteName) {
    }
            String path = entry.getValue();  
 * <p>
 * You may obtain a copy of the License at  
                return null;
    static int getMaxKeyDepth(Map<String, DynamicKeyFieldMapper> dynamicKeyMappers, Map<String, String> aliasToConcreteName) {
        return maxFieldDepth;  
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Map;
 * suitable for performing searches on the sub-key.  
/*  
     * form 'path_to_field.path_to_key'. If so, returns a field type that
            }  
            dotIndex = field.indexOf('.', dotIndex + 1);
     * Check if the given field corresponds to a dynamic key mapper of the  
                maxFieldDepth = Math.max(maxFieldDepth, fieldDepth(fieldName));
 * software distributed under the License is distributed on an
        return numDots + 1;
 * Licensed to Elasticsearch under one or more contributor  
/*
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static int fieldDepth(String field) {
    MappedFieldType get(String field) {
 *
 * Flattened object fields live in the 'mapper-flattened' module.  
            }
    }  
 * not use this file except in compliance with the License.
 */
}
            numDots++;  
        for (Map.Entry<String, String> entry : aliasToConcreteName.entrySet()) {
            if (dotIndex < 0) {  
 * KIND, either express or implied.  See the License for the
 * Compared to standard fields, 'dynamic key' fields require special handling. Given a field name of the form
     * a dynamic key mapper as soon as we've passed the maximum possible field depth.
 * SPDX-License-Identifier: Apache-2.0
     * can be used to perform searches on this field. Otherwise returns null.
    /**
        int maxFieldDepth = 0;  
        }
