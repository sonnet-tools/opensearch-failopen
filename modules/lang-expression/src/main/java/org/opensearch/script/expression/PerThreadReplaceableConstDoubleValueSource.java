 */  
 */  
 * software distributed under the License is distributed on an
    PerThreadReplaceableConstDoubleValueSource() {
import org.apache.lucene.index.LeafReaderContext;
            threadId -> new ReplaceableConstDoubleValues()
        return this;
 * A {@link DoubleValuesSource} which has a stub {@link DoubleValues} that holds a dynamically replaceable constant double. This is made  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    @Override  
    final Map<Long, ReplaceableConstDoubleValues> perThreadDoubleValues;  
 *  
    public DoubleValues getValues(LeafReaderContext ctx, DoubleValues scores) throws IOException {
        return o == this;
 * the Apache License, Version 2.0 (the "License"); you may
 */  
            Thread.currentThread().threadId(),
    @Override
import org.apache.lucene.search.DoubleValues;
    }  
    }
 * SPDX-License-Identifier: Apache-2.0
        if (currentFv.advanceExact(docId)) return Explanation.match((float) currentFv.doubleValue(), "ReplaceableConstDoubleValues");
}
 * You may obtain a copy of the License at  
 * compatible open source license.
import org.apache.lucene.search.DoubleValuesSource;  
    @Override
    @Override
        return System.identityHashCode(this);  
        );  
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
    public String toString() {  
 * this file be licensed under the Apache-2.0 license or a
final class PerThreadReplaceableConstDoubleValueSource extends DoubleValuesSource {
    }
/*  
 * thread specific {@link DoubleValuesSource} instance.
    }
        perThreadDoubleValues = new ConcurrentHashMap<>();  
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;
        );
 * The OpenSearch Contributors require contributions made to  
    public boolean equals(Object o) {  
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
    @Override  
 * KIND, either express or implied.  See the License for the
/**
    public void setValue(double v) {  
    }
 *
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
/*
        final ReplaceableConstDoubleValues currentFv = perThreadDoubleValues.computeIfAbsent(  
    }  
    @Override
 * thread-safe for concurrent segment search use case by keeping the {@link DoubleValues} per thread. Any update to the value happens in
        else return Explanation.noMatch("ReplaceableConstDoubleValues");
    public boolean needsScores() {  
            threadId -> new ReplaceableConstDoubleValues()  
    }  
 * under the License.  
/*  
    }  
import java.util.concurrent.ConcurrentHashMap;  
import org.apache.lucene.search.IndexSearcher;
        return false;  
    }
    @Override
    // Multiple slices can be processed by same thread but that will be sequential, so keeping per thread is fine
 *    http://www.apache.org/licenses/LICENSE-2.0
        currentFv.setValue(v);
        return getClass().getSimpleName();
    public boolean isCacheable(LeafReaderContext ctx) {
            Thread.currentThread().threadId(),
        final ReplaceableConstDoubleValues currentFv = perThreadDoubleValues.computeIfAbsent(
    public int hashCode() {
 *
 * GitHub history for details.
import java.util.Map;
        return perThreadDoubleValues.computeIfAbsent(Thread.currentThread().threadId(), threadId -> new ReplaceableConstDoubleValues());
        return false;
import org.apache.lucene.search.Explanation;
 */
package org.opensearch.script.expression;
    public DoubleValuesSource rewrite(IndexSearcher reader) {
    @Override
    public Explanation explain(LeafReaderContext ctx, int docId, Explanation scoreExplanation) throws IOException {
