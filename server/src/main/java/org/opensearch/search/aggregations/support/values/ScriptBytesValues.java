 * this file be licensed under the Apache-2.0 license or a
    public ScriptBytesValues(AggregationScript script) {  
    }
 *
 * KIND, either express or implied.  See the License for the
    private final AggregationScript script;
 * The OpenSearch Contributors require contributions made to  
            if (count == 0) {
    public void setScorer(Scorable scorer) {
import java.io.IOException;
 */
            return false;
    public boolean advanceExact(int doc) throws IOException {
                set(i, Array.get(value, i));
            if (o instanceof BytesRef) {
            grow();
/*
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
            grow();  
 */  
                return false;
 * compatible open source license.
import java.lang.reflect.Array;  
            values[i].clear();
        script.setDocument(doc);
        return true;
import org.opensearch.script.AggregationScript;  
public class ScriptBytesValues extends SortingBinaryDocValues implements ScorerAware {
            count = coll.size();
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See  
 *
            } else {  
}
package org.opensearch.search.aggregations.support.values;
            count = Array.getLength(value);
        } else if (value.getClass().isArray()) {  
import org.apache.lucene.search.Scorable;  
 *  
 * You may obtain a copy of the License at  
            }
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            for (int i = 0; i < count; ++i) {  
    }  
                return false;  
    @Override  
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
    }
        if (value == null) {
 * SPDX-License-Identifier: Apache-2.0
        }  
            if (count == 0) {  
import org.opensearch.common.lucene.ScorerAware;
/**  
 * {@link SortedBinaryDocValues} implementation that reads values from a script.
 */
    @Override
            int i = 0;
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
            }
            count = 1;  
 * Licensed to Elasticsearch under one or more contributor  
/*  
        super();
import org.opensearch.core.common.util.CollectionUtils;  
                values[i].copyChars(o.toString());
            final Collection<?> coll = (Collection<?>) value;
            CollectionUtils.ensureNoSelfReferences(o, "ScriptBytesValues value");  
                values[i].copyBytes((BytesRef) o);
            }
        if (o == null) {  
        final Object value = script.execute();  
import java.util.Collection;
 * not use this file except in compliance with the License.
        }
        this.script = script;
        } else if (value instanceof Collection) {  
 */
                set(i++, v);  
        } else {
            }
import org.opensearch.index.fielddata.SortingBinaryDocValues;
 * license agreements. See the NOTICE file distributed with
        script.setScorer(scorer);  
        } else {
 * @opensearch.internal  
import org.opensearch.index.fielddata.SortedBinaryDocValues;
            for (Object v : coll) {
    }
    private void set(int i, Object o) {
 * specific language governing permissions and limitations
        sort();  
            set(0, value);
 * Unless required by applicable law or agreed to in writing,
 *
import org.apache.lucene.util.BytesRef;
 * GitHub history for details.
