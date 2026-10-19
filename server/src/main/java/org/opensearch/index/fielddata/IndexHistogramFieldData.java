        return valuesSourceType;  
 * The OpenSearch Contributors require contributions made to  
 */  
 *  
 * specific language governing permissions and limitations
        return fieldName;
 */  
 * license agreements. See the NOTICE file distributed with
    public ValuesSourceType getValuesSourceType() {
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 *
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 * @opensearch.internal  
        this.valuesSourceType = valuesSourceType;
/*  
 * ownership. Elasticsearch licenses this file to you under  
    protected final String fieldName;  
/*
    protected final ValuesSourceType valuesSourceType;
 * this file be licensed under the Apache-2.0 license or a
        this.fieldName = fieldName;
}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
public abstract class IndexHistogramFieldData implements IndexFieldData<LeafHistogramFieldData> {
package org.opensearch.index.fielddata;
 * Specialization of {@link IndexFieldData} for histograms.
 * not use this file except in compliance with the License.
    public IndexHistogramFieldData(String fieldName, ValuesSourceType valuesSourceType) {  
 *
    }  
    }
/*  
 * SPDX-License-Identifier: Apache-2.0
    }
 * this work for additional information regarding copyright
 *
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.support.ValuesSourceType;
 */
    public final String getFieldName() {  
/**  
 * compatible open source license.
 * You may obtain a copy of the License at  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
