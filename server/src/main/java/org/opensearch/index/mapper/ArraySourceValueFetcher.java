        this.sourcePaths = context.sourcePath(fieldName);  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
    }
    public ArraySourceValueFetcher(String fieldName, QueryShardContext context) {
 * SPDX-License-Identifier: Apache-2.0
            if (sourceValue == null) {  
 */  
 * specific language governing permissions and limitations
 */  
    }
    protected abstract Object parseSourceValue(Object value);
            values.addAll((List<?>) parseSourceValue(sourceValue));  
        this(fieldName, context, null);  
 * @opensearch.internal
import java.util.Set;
        }
 * GitHub history for details.
import org.opensearch.common.Nullable;
    /**  
 *
     */  
import org.opensearch.search.lookup.SourceLookup;  
 *
     */
        return values;
        this.nullValue = nullValue;
        List<Object> values = new ArrayList<>();  
 * <p>  
 */
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.query.QueryShardContext;
 */  
 *
    public List<Object> fetchValues(SourceLookup lookup) {
 * software distributed under the License is distributed on an
}
/**  
 * array values in parsing. Field types should use this class if their corresponding
import java.util.ArrayList;
    }  
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 * from the document source.
            }
/*  
 * An implementation of {@link ValueFetcher} that knows how to extract values
    private final @Nullable Object nullValue;  
     * @param nullValue A optional substitute value if the _source value is 'null'.  
     * format. This parsing logic should closely mirror the value parsing in
 * compatible open source license.
import java.util.List;  
 * This class differs from {@link SourceValueFetcher} in that it directly handles
    /**
/*
    public ArraySourceValueFetcher(String fieldName, QueryShardContext context, Object nullValue) {
                return List.of();
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.index.mapper;
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
    @Override
            Object sourceValue = lookup.extractValue(path, nullValue);
 * under the License.  
    private final Set<String> sourcePaths;
public abstract class ArraySourceValueFetcher implements ValueFetcher {
 *  
     * @param context A query shard context.
     * Given a value that has been extracted from a document's source, parse it into a standard  
     * @param fieldName The name of the field.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
        for (String path : sourcePaths) {
 * KIND, either express or implied.  See the License for the
/*  
     * {@link FieldMapper#parseCreateField} or {@link FieldMapper#parse}.
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
 * mapper returns true for {@link FieldMapper#parsesArrayValue()}.  
