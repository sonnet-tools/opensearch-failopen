 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
 * compatible open source license.
                "Trying to retrieve too many docvalue_fields. Must be less than or equal to: ["
 * The OpenSearch Contributors require contributions made to  
    public FetchDocValuesContext(List<FieldAndFormat> fields) {  
                    + "]. This limit can be set by changing the ["  
            throw new IllegalArgumentException(
package org.opensearch.search.fetch.subphase;
import org.opensearch.common.annotation.PublicApi;  
 *
 * SPDX-License-Identifier: Apache-2.0
 */
    public static FetchDocValuesContext create(  
    ) {
     * Returns the required docvalue fields
 * Modifications Copyright OpenSearch Contributors. See  
        List<FieldAndFormat> fields = new ArrayList<>();
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
                    + "] index level setting."
 */  
 * this work for additional information regarding copyright
 */
            for (String fieldName : fieldNames) {
 * not use this file except in compliance with the License.
        List<FieldAndFormat> fieldPatterns  
 * @opensearch.api  
        this.fields = fields;
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    + IndexSettings.MAX_DOCVALUE_FIELDS_SEARCH_SETTING.getKey()
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.IndexSettings;
    /**
        return this.fields;
 * specific language governing permissions and limitations
 *
public class FetchDocValuesContext {  
            Collection<String> fieldNames = simpleMatchToFullName.apply(field.field);
 * Unless required by applicable law or agreed to in writing,
        if (fields.size() > maxAllowedDocvalueFields) {  
        for (FieldAndFormat field : fieldPatterns) {  
/*
/*
                    + maxAllowedDocvalueFields  
            );  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * All the required context to pull a field from the doc values.
    private final List<FieldAndFormat> fields;
        }
 */
        int maxAllowedDocvalueFields,
 * software distributed under the License is distributed on an
    }  
                fields.add(new FieldAndFormat(fieldName, field.format));  
import java.util.function.Function;
/**  
     */  
import java.util.ArrayList;  
 *
@PublicApi(since = "1.0.0")
import java.util.Collection;
                    + fields.size()
    public List<FieldAndFormat> fields() {
                    + "] but was ["
/*  
    }
    }
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Set;  
        return new FetchDocValuesContext(fields);  
}
        }
        Function<String, Set<String>> simpleMatchToFullName,
import java.util.List;
