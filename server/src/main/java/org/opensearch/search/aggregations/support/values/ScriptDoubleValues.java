import java.util.Collection;
            }  
        } else {
 * this file be licensed under the Apache-2.0 license or a
    public void setScorer(Scorable scorer) {
 * {@link SortingNumericDoubleValues} implementation which is based on a script
        if (value == null) {
public class ScriptDoubleValues extends SortingNumericDoubleValues implements ScorerAware {
            values[0] = toDoubleValue(value);
            for (Object v : coll) {
/**  
    }  
            values[0] = ((ReadableInstant) value).getMillis();
 * Unless required by applicable law or agreed to in writing,
            values[0] = ((ZonedDateTime) value).toInstant().toEpochMilli();
 * ownership. Elasticsearch licenses this file to you under  
            // make sure of using true/false in the key_as_string field
            return ((ReadableInstant) o).getMillis();
        } else if (o instanceof ZonedDateTime) {
import org.opensearch.search.aggregations.AggregationExecutionException;
                return false;  
        } else if (value.getClass().isArray()) {  
            assert i == docValueCount();
 *
    public boolean advanceExact(int target) throws IOException {  
 * the Apache License, Version 2.0 (the "License"); you may
        script.setScorer(scorer);
 * this work for additional information regarding copyright
    @Override
}
            values[0] = ((Number) value).doubleValue();
 */
        } else if (o instanceof ReadableInstant) {
        final Object value = script.execute();
 * Licensed to Elasticsearch under one or more contributor  
            throw new AggregationExecutionException("Unsupported script value [" + o + "], expected a number, date, or boolean");
        if (o instanceof Number) {  
        this.script = script;
            // Dates are exposed in scripts as ReadableDateTimes but aggregations want them to be numeric  
        super();
    @Override  
            }
 * @opensearch.internal  
        return true;
 */  
            resize(length);
 * The OpenSearch Contributors require contributions made to  
        } else if (value instanceof Number) {  
            Collection<?> coll = (Collection<?>) value;
            // values in scripts need to be converted to a number, and the value formatter will
                values[i++] = toDoubleValue(v);
        }
import java.io.IOException;
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  
            for (int i = 0; i < length; ++i) {  
            int i = 0;  
                return false;  
    public ScriptDoubleValues(AggregationScript script) {  
            // We do expose boolean fields as boolean in scripts, however aggregations still expect
 * software distributed under the License is distributed on an
            // that scripts return the same internal representation as regular fields, so boolean  
        } else if (value instanceof ZonedDateTime) {  
            resize(1);  
    }
        }  
            }
    final AggregationScript script;
            }
import org.joda.time.ReadableInstant;
        } else if (value instanceof ReadableInstant) {  
import java.time.ZonedDateTime;  
import org.opensearch.script.AggregationScript;  
            if (coll.isEmpty()) {
                values[i] = toDoubleValue(Array.get(value, i));
            return ((ZonedDateTime) o).toInstant().toEpochMilli();  
import org.opensearch.index.fielddata.SortingNumericDoubleValues;
 * compatible open source license.
        } else if (value instanceof Collection) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        script.setDocument(target);
 * not use this file except in compliance with the License.
 * under the License.  
    }  
/*
            int length = Array.getLength(value);
            resize(1);
package org.opensearch.search.aggregations.support.values;
 *
            resize(1);
import java.lang.reflect.Array;
        sort();
 */
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
            if (length == 0) {
 * SPDX-License-Identifier: Apache-2.0
            return ((Number) o).doubleValue();
        } else if (o instanceof Boolean) {
import org.opensearch.common.lucene.ScorerAware;
 * GitHub history for details.
        } else {
            resize(1);
            return false;
/*
            return ((Boolean) o).booleanValue() ? 1.0 : 0.0;  
 * specific language governing permissions and limitations
import org.apache.lucene.search.Scorable;  
 */
    private static double toDoubleValue(Object o) {
 * Modifications Copyright OpenSearch Contributors. See  
    }  
            resize(coll.size());
 * You may obtain a copy of the License at  
