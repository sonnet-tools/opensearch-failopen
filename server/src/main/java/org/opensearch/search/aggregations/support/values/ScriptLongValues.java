import org.opensearch.search.aggregations.AggregationExecutionException;
        this.script = script;
        } else if (o instanceof ReadableInstant) {
                return false;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Iterator;  
        final Object value = script.execute();
 */  
                values[i] = toLongValue(it.next());
 * {@link LongValues} implementation which is based on a script  
 */  
import java.util.Collection;
            }
import org.apache.lucene.search.Scorable;  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
            values[0] = toLongValue(value);  
        sort();  
            // We do expose boolean fields as boolean in scripts, however aggregations still expect
            return ((ZonedDateTime) o).toInstant().toEpochMilli();
                values[i] = toLongValue(Array.get(value, i));
    public boolean advanceExact(int target) throws IOException {
 * this work for additional information regarding copyright
            return false;
/*
/*  
            if (coll.isEmpty()) {
            resize(1);
        else if (value instanceof Collection) {  
 * software distributed under the License is distributed on an
    }
            return ((Boolean) o).booleanValue() ? 1L : 0L;
            // that scripts return the same internal representation as regular fields, so boolean
 * Modifications Copyright OpenSearch Contributors. See  
            throw new AggregationExecutionException("Unsupported script value [" + o + "], expected a number, date, or boolean");
        script.setDocument(target);  
        }
        if (o instanceof Number) {
}  
 * @opensearch.internal
import java.io.IOException;
        }
 *
 * this file be licensed under the Apache-2.0 license or a
            }
 * KIND, either express or implied.  See the License for the
        } else if (o instanceof Boolean) {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.fielddata.AbstractSortingNumericDocValues;  
            }  
            // Dates are exposed in scripts as ReadableDateTimes but aggregations want them to be numeric
        super();  
            resize(coll.size());
 * You may obtain a copy of the License at  
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
            for (int i = 0; i < length; ++i) {
            for (Iterator<?> it = coll.iterator(); it.hasNext(); ++i) {
        return true;
 * under the License.  
    private static long toLongValue(Object o) {
 * specific language governing permissions and limitations
        else {
            int i = 0;  
            }  
    }  
        } else {  
    @Override
            return ((ReadableInstant) o).getMillis();  
 * Licensed to Elasticsearch under one or more contributor  
        } else if (o instanceof ZonedDateTime) {
    public void setScorer(Scorable scorer) {  
            // values in scripts need to be converted to a number, and the value formatter will  
import org.apache.lucene.util.LongValues;
 *
        script.setScorer(scorer);
    }
package org.opensearch.search.aggregations.support.values;
        else if (value.getClass().isArray()) {
        }
 */
 * not use this file except in compliance with the License.
        if (value == null) {  
                return false;  
            assert i == docValueCount();
            if (length == 0) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
/**
import java.lang.reflect.Array;  
    @Override
 * GitHub history for details.
 */
    public ScriptLongValues(AggregationScript script) {
    }
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
    final AggregationScript script;  
        }
import org.joda.time.ReadableInstant;  
            int length = Array.getLength(value);
 *
            return ((Number) o).longValue();  
 * Unless required by applicable law or agreed to in writing,
            resize(length);  
import java.time.ZonedDateTime;
            Collection<?> coll = (Collection<?>) value;
import org.opensearch.common.lucene.ScorerAware;
/*
            // make sure of using true/false in the key_as_string field
import org.opensearch.script.AggregationScript;
        }
public class ScriptLongValues extends AbstractSortingNumericDocValues implements ScorerAware {
