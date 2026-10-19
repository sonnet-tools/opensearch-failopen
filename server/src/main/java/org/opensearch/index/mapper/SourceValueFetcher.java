                return List.of();
            protected Object parseSourceValue(Object value) {  
 */
                }
            }
        this.nullValue = nullValue;
        if (format != null) {
 */  
import org.opensearch.search.lookup.SourceLookup;  
            queue.add(sourceValue);
     */
     * format. This parsing logic should closely mirror the value parsing in
}
        this.sourcePaths = sourcePaths;  
 * Unless required by applicable law or agreed to in writing,
public abstract class SourceValueFetcher implements ValueFetcher {
 * this work for additional information regarding copyright
    }  
 * An implementation of {@link ValueFetcher} that knows how to extract values  
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
 * under the License.  
        for (String path : sourcePaths) {
/*
            throw new IllegalArgumentException("Field [" + fieldName + "] doesn't support formats.");
 * The OpenSearch Contributors require contributions made to  
    }
        this.nullValue = nullValue;
                    if (parsedValue != null) {
    public SourceValueFetcher(String fieldName, QueryShardContext context, Object nullValue) {  
    @Override
    /**  
     * Creates a {@link SourceValueFetcher} that passes through source values unmodified.
    /**
            }
 *
        }  
     * @param nullValue A optional substitute value if the _source value is 'null'.
 * KIND, either express or implied.  See the License for the
     * @param context A query shard context.  
 * Licensed to Elasticsearch under one or more contributor  
                        values.add(parsedValue);  
            @Override
            @Override
     */  
 */
    }
 *
     */
        if (format != null) {
 * to implement value fetching.
            protected Object parseSourceValue(Object value) {  
    }
    public static SourceValueFetcher identity(String fieldName, QueryShardContext context, String format) {  
        return values;
        }
            Queue<Object> queue = new ArrayDeque<>();  
 * ownership. Elasticsearch licenses this file to you under  
                } else {  
 * from the document source. Most standard field mappers will use this class
import org.opensearch.index.query.QueryShardContext;
    /**
        List<Object> values = new ArrayList<>();  
/*  
    private final @Nullable Object nullValue;
     * Creates a {@link SourceValueFetcher} that converts source values to strings.
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
/*  
            throw new IllegalArgumentException("Field [" + fieldName + "] doesn't support formats.");
 * @opensearch.internal  
package org.opensearch.index.mapper;
    public static SourceValueFetcher toString(String fieldName, QueryShardContext context, String format) {  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected SourceValueFetcher(Set<String> sourcePaths, Object nullValue) {
import java.util.Set;  
    public SourceValueFetcher(String fieldName, QueryShardContext context) {  
            while (queue.isEmpty() == false) {
        };  
    }  
        };  
        this(fieldName, context, null);
    private final Set<String> sourcePaths;  
import java.util.Queue;
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
                return value.toString();
            Object sourceValue = lookup.extractValue(path, nullValue);
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
                    Object parsedValue = parseSourceValue(value);
        return new SourceValueFetcher(fieldName, context) {
 * this file be licensed under the Apache-2.0 license or a
import java.util.ArrayList;  
import java.util.ArrayDeque;
import java.util.List;
     */
 */  
            // We allow source values to contain multiple levels of arrays, such as `"field": [[1, 2]]`.
    protected abstract Object parseSourceValue(Object value);
        this.sourcePaths = context.sourcePath(fieldName);
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
import org.opensearch.common.Nullable;
                    }
            // So we need to unwrap these arrays before passing them on to be parsed.
    /**  
                    queue.addAll((List<?>) value);
 *
        return new SourceValueFetcher(fieldName, context) {
                Object value = queue.poll();  
            if (sourceValue == null) {  
            }  
                return value;
     * {@link FieldMapper#parseCreateField} or {@link FieldMapper#parse}.
 * GitHub history for details.
        }  
 * Field types that handle arrays directly should instead use {@link ArraySourceValueFetcher}.
     * @param fieldName The name of the field.
     * Given a value that has been extracted from a document's source, parse it into a standard  
    public List<Object> fetchValues(SourceLookup lookup) {
                if (value instanceof List) {
 * <p>  
 * software distributed under the License is distributed on an
 *  
/**
