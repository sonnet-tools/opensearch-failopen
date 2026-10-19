            }
                values.put(entry.getKey(), numericValuesSource);  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
     * Numeric format
/**
 */
            return value.doubleValues(ctx);  
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See  
 * software distributed under the License is distributed on an
    public boolean needsScores() {
/*
                throw new IllegalArgumentException("Could not find field name [" + fieldName + "] in multiValuesSource");
package org.opensearch.search.aggregations.support;
                final ValuesSource valuesSource = entry.getValue().getValuesSource();  
 */
 *
 */  
            for (Map.Entry<String, ValuesSourceConfig> entry : valuesSourceConfigs.entrySet()) {
import org.opensearch.index.query.QueryShardContext;
 * compatible open source license.
        return values.values().stream().anyMatch(ValuesSource::needsScores);
                    );
    }  
 * specific language governing permissions and limitations
        public SortedNumericDoubleValues getField(String fieldName, LeafReaderContext ctx) throws IOException {
import java.util.Objects;
 * Class to encapsulate a set of ValuesSource objects labeled by field name
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
            ValuesSource.Numeric value = values.get(fieldName);
                }
                if (!(valuesSource instanceof ValuesSource.Numeric numericValuesSource)) {
 * this work for additional information regarding copyright
/*
     */
import java.io.IOException;
}
 * this file be licensed under the Apache-2.0 license or a
        public NumericMultiValuesSource(Map<String, ValuesSourceConfig> valuesSourceConfigs, QueryShardContext context) {  
            if (value == null) {  
     *
        }
                    throw new AggregationExecutionException(
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
    protected Map<String, VS> values;
 * You may obtain a copy of the License at  
/*  
 *  
import java.util.HashMap;  
import org.opensearch.search.aggregations.AggregationExecutionException;  
            }
 * not use this file except in compliance with the License.
 */
public abstract class MultiValuesSource<VS extends ValuesSource> {  
 * Licensed to Elasticsearch under one or more contributor  
    public static class NumericMultiValuesSource extends MultiValuesSource<ValuesSource.Numeric> {
    public boolean areValuesSourcesEmpty() {
 * Unless required by applicable law or agreed to in writing,
     * @opensearch.internal  
 *  
    }
            values = new HashMap<>(valuesSourceConfigs.size());
import java.util.Map;
                        "ValuesSource type " + valuesSource.toString() + "is not supported for multi-valued aggregation"  
    }
        return values.values().stream().allMatch(Objects::isNull);  
    /**  
 * under the License.  
        }
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.index.LeafReaderContext;  
