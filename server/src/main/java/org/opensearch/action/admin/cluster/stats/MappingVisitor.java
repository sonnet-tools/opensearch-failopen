 * this work for additional information regarding copyright
/*
 * Visitor pattern for obtaining index mappings
 * not use this file except in compliance with the License.
    }  
 * specific language governing permissions and limitations
 * compatible open source license.
                        @SuppressWarnings("unchecked")
                    fieldMappingConsumer.accept(fieldMapping);
/*  
    private MappingVisitor() {}
                        Map<String, ?> fields = (Map<String, ?>) fieldsO;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            for (Object v : propertiesAsMap.values()) {  
 * KIND, either express or implied.  See the License for the
                    visitMapping(fieldMapping, fieldMappingConsumer);  
/*  
                            if (v2 instanceof Map) {
                if (v != null && v instanceof Map) {
 * software distributed under the License is distributed on an
                    // Multi fields
 * GitHub history for details.
                        }
 * this file be licensed under the Apache-2.0 license or a
 *  
 */
                            }  
                }  
                                Map<String, ?> fieldMapping2 = (Map<String, ?>) v2;
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
                    }
            }
        if (properties != null && properties instanceof Map) {  
 * ownership. Elasticsearch licenses this file to you under  
        Object properties = mapping.get("properties");
 * SPDX-License-Identifier: Apache-2.0
                        for (Object v2 : fields.values()) {
 */  
import java.util.Map;
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.function.Consumer;
                                fieldMappingConsumer.accept(fieldMapping2);
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
                                @SuppressWarnings("unchecked")  
 *
                    Map<String, ?> fieldMapping = (Map<String, ?>) v;
final class MappingVisitor {  
        }
 * @opensearch.internal
                    Object fieldsO = fieldMapping.get("fields");  
    static void visitMapping(Map<String, ?> mapping, Consumer<Map<String, ?>> fieldMappingConsumer) {
                    if (fieldsO != null && fieldsO instanceof Map) {
 *
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
 */
                    @SuppressWarnings("unchecked")  
}
 */  
            Map<String, ?> propertiesAsMap = (Map<String, ?>) properties;
/**
 * The OpenSearch Contributors require contributions made to  
            @SuppressWarnings("unchecked")
package org.opensearch.action.admin.cluster.stats;
 *  
