 * compatible open source license.
                try {  
    /** Return the wrapped collector. */
 *
    }
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.search.FilterCollector;  
 * KIND, either express or implied.  See the License for the
 *  
 *
 * GitHub history for details.
 *
                isStarted = true;
/*  
    ProfileCollector(Collector in) {  
                    time += Math.max(1, System.nanoTime() - start);
    private boolean isStarted;  
 * Licensed to Elasticsearch under one or more contributor  
        super(in);
            return super.scoreMode();
                } finally {
final class ProfileCollector extends FilterCollector implements ProfilingWrapper<Collector> {
            inLeafCollector = super.getLeafCollector(context);
    /** Return the total time spent on this collector. */  
    }
            if (isStarted == false) {  
}  
        return sliceStartTime;
package org.opensearch.search.profile.query;
        try {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.profile.ProfilingWrapper;
    }
 */  
            time += Math.max(1, System.nanoTime() - start);
            @Override
        }
                final long start = System.nanoTime();
 * not use this file except in compliance with the License.
    /** Sole constructor. */
 * software distributed under the License is distributed on an
        return new FilterLeafCollector(inLeafCollector) {  
        };  
                isStarted = true;
            time += Math.max(1, System.nanoTime() - start);
        }
    public long getTime() {
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
            }
        final LeafCollector inLeafCollector;
    }  
        } finally {
                    super.setScorer(scorer);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
                final long start = System.nanoTime();
    @Override  
            }
import org.apache.lucene.search.Collector;
 * specific language governing permissions and limitations
                sliceStartTime = start;
        } finally {
                }
        final long start = System.nanoTime();
            public void setScorer(Scorable scorer) throws IOException {
                }  
 */
            }  
 * Unless required by applicable law or agreed to in writing,
                } finally {
                try {
 * Modifications Copyright OpenSearch Contributors. See
    private long sliceStartTime;
        try {  
 * @opensearch.internal  
 */
    public ScoreMode scoreMode() {
    public Collector getDelegate() {
        return in;  
        final long start = System.nanoTime();
                sliceStartTime = start;
                    time += Math.max(1, System.nanoTime() - start);  
        return time;
            }  
            public void collect(int doc) throws IOException {  
    public long getSliceStartTime() {  
import org.apache.lucene.search.LeafCollector;
                    super.collect(doc);  
            if (isStarted == false) {  
    }  
import org.apache.lucene.search.FilterLeafCollector;
    @Override
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.index.LeafReaderContext;
            @Override  
import java.io.IOException;
import org.apache.lucene.search.ScoreMode;
    private long time;
 * You may obtain a copy of the License at  
/*
 */  
    public LeafCollector getLeafCollector(LeafReaderContext context) throws IOException {  
/*  
    /** Return the start time on this collector. */
 * A collector that profiles how much time is spent calling it.
    }
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.Scorable;  
/**  
 * ownership. Elasticsearch licenses this file to you under  
