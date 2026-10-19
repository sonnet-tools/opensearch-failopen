 * ownership. Elasticsearch licenses this file to you under  
 *
    private final String field;
     */
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.PublicApi;  
 *  
    public String field() {
public class FieldContext {
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.fielddata.IndexFieldData;
        this.indexFieldData = indexFieldData;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @return The index field datas in this context
 * Modifications Copyright OpenSearch Contributors. See  
     */
 *
        return fieldType;
 */  
    private final IndexFieldData<?> indexFieldData;
 * in. It holds both the field names and the index field datas that are associated with them.  
/**
        return field;  
     * @param field             The name of the field
 */  
 * this file be licensed under the Apache-2.0 license or a
 */
     * Constructs a field data context for the given field and its index field data  
        this.fieldType = fieldType;
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
    /**
    public IndexFieldData<?> indexFieldData() {  
    /**  
     * @param indexFieldData    The index field data of the field  
@PublicApi(since = "1.0.0")
 */
package org.opensearch.search.aggregations.support;
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
/*
    }  
 * Used by all field data based aggregators. This determine the context of the field data the aggregators are operating
/*
 *
 * @opensearch.api
 * KIND, either express or implied.  See the License for the
    }
 * this work for additional information regarding copyright
        return indexFieldData;
    public MappedFieldType fieldType() {
    }
    private final MappedFieldType fieldType;  
     *
        this.field = field;  
/*  
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
import org.opensearch.index.mapper.MappedFieldType;
}
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
    public FieldContext(String field, IndexFieldData<?> indexFieldData, MappedFieldType fieldType) {
    }  
