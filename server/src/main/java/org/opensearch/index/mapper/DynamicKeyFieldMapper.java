    public abstract MappedFieldType keyedFieldType(String key);
 *   {@link DynamicKeyFieldMapper#fieldType()} as usual.
 * ownership. Elasticsearch licenses this file to you under  
 * then a user is able to search on the field in both of the following ways:
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.index.mapper;
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 *   to {@link DynamicKeyFieldMapper#keyedFieldType(String)}, with 'some_key' passed as the  
 * <p>  
}
 * - Using the field name 'my_field', which will delegate to the field type  
/*  
 * implementing this interface should explicitly disallow multi-fields. The constructor makes
 * Unless required by applicable law or agreed to in writing,
 *  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
public abstract class DynamicKeyFieldMapper extends FieldMapper {
 *
 * registered.
 * this work for additional information regarding copyright
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
/*
 *   argument. The field mapper is allowed to create a new field type dynamically in order
 * A field mapper that supports lookup of dynamic sub-keys. If the field mapper is named 'my_field',
 */  
 *   to handle the search.
/*  
 */
 * To prevent conflicts between these dynamic sub-keys and multi-fields, any field mappers
/**  
 */  
 * @opensearch.internal  
    public DynamicKeyFieldMapper(String simpleName, FieldType fieldType, MappedFieldType defaultFieldType, CopyTo copyTo) {
        super(simpleName, fieldType, defaultFieldType, MultiFields.empty(), copyTo);
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
 * - Using any sub-key, for example 'my_field.some_key'. In this case, the search is delegated
 *
 * sure to passes an empty multi-fields list to help prevent conflicting sub-keys from being  
 *
import org.apache.lucene.document.FieldType;
