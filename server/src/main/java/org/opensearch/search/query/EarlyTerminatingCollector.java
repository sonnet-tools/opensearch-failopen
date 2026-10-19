import org.apache.lucene.search.Collector;  
 */
                throw new CollectionTerminatedException();
    private final int maxCountHits;
        };  
    @Override
 *  
    private boolean earlyTerminated;
 * GitHub history for details.
import org.apache.lucene.search.FilterCollector;
 */
            public void collect(int doc) throws IOException {
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
 * A {@link Collector} that early terminates collection after <code>maxCountHits</code> docs have been collected.
 * SPDX-License-Identifier: Apache-2.0
        return new FilterLeafCollector(super.getLeafCollector(context)) {
     */  
     * @param forceTermination Whether the collection should be terminated with an exception ({@link EarlyTerminationException})
package org.opensearch.search.query;
 * KIND, either express or implied.  See the License for the
     *                         that is not caught by other {@link Collector} or with a {@link CollectionTerminatedException} otherwise.
            if (forceTermination) {
 *
            }  
    public boolean hasEarlyTerminated() {
 *
import org.apache.lucene.index.LeafReaderContext;
                        throw new CollectionTerminatedException();
 * ownership. Elasticsearch licenses this file to you under  
                    if (forceTermination) {
 * Modifications Copyright OpenSearch Contributors. See
     * Returns true if this collector has early terminated.
    /**
    private boolean forceTermination;  
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
    }
 */  
/*  
 * under the License.  
        }
public class EarlyTerminatingCollector extends FilterCollector {  
        this.maxCountHits = maxCountHits;  
    }
 * this file be licensed under the Apache-2.0 license or a
 */  
                    }
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    } else {  
        return in;
     */  
}
        if (numCollected >= maxCountHits) {  
                super.collect(doc);
            @Override  
/**
import org.apache.lucene.search.LeafCollector;  
    }
    Collector getCollector() {  
 * this work for additional information regarding copyright
        }
    }  
            } else {
                    earlyTerminated = true;  
 * software distributed under the License is distributed on an
                if (++numCollected > maxCountHits) {
            }
    }
                throw new EarlyTerminationException("early termination [CountBased]");  
 * the Apache License, Version 2.0 (the "License"); you may
    static final class EarlyTerminationException extends RuntimeException {
 * @opensearch.internal
     * @param delegate The delegated collector.
    /**  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
        return earlyTerminated;
 * specific language governing permissions and limitations
            super(msg);  
        EarlyTerminationException(String msg) {
 * compatible open source license.
     * @param maxCountHits The number of documents to collect before termination.  
import org.apache.lucene.search.FilterLeafCollector;
                }  
            earlyTerminated = true;
    public LeafCollector getLeafCollector(LeafReaderContext context) throws IOException {
        super(delegate);
        this.forceTermination = forceTermination;
import org.apache.lucene.search.CollectionTerminatedException;
    EarlyTerminatingCollector(final Collector delegate, int maxCountHits, boolean forceTermination) {
                        throw new EarlyTerminationException("early termination [CountBased]");
     * Ctr
/*  
 *  
    private int numCollected;
