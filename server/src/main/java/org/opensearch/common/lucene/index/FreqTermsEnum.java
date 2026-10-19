    private static final int INITIAL_NUM_TERM_FREQS_CACHED = 512;
 * Modifications Copyright OpenSearch Contributors. See
/**  
import org.apache.lucene.util.BytesRef;
            termsTotalFreqs = bigArrays.grow(termsTotalFreqs, currentTermOrd + 1);
        if (currentTermOrd < 0) { // already seen, initialize instance data with the cached frequencies
 * GitHub history for details.
    private final BigArrays bigArrays;
        if (needDocFreq) {  
        @Nullable Query filter,
        final boolean found = super.seekExact(text);  
import org.opensearch.common.util.LongArray;
 * this file be licensed under the Apache-2.0 license or a
        return found;
        }
        this.needDocFreqs = needDocFreq;
        long currentTermOrd = cachedTermOrds.add(text);
public class FreqTermsEnum extends FilterableTermsEnum implements Releasable {
/*  
        BigArrays bigArrays  
        }  
                currentDocFreq = termDocFreqs.get(currentTermOrd);  
        } finally {  
 *  
import org.opensearch.common.lease.Releasables;
        IndexReader reader,
 * KIND, either express or implied.  See the License for the
        this.needTotalTermFreqs = needTotalTermFreq;
            current = found ? text : null;
import org.opensearch.common.util.BigArrays;
        boolean needDocFreq,  
/*
import org.apache.lucene.index.PostingsEnum;
            boolean found = true;
        this.bigArrays = bigArrays;  
 * license agreements. See the NOTICE file distributed with
 */
            currentTermOrd = -1 - currentTermOrd;  
import org.apache.lucene.search.Query;  
        super(reader, field, needTotalTermFreq ? PostingsEnum.FREQS : PostingsEnum.NONE, filter);
            cachedTermOrds = null;
    }
    private IntArray termDocFreqs;  
 * You may obtain a copy of the License at  
 *
    private final boolean needTotalTermFreqs;
 * Licensed to Elasticsearch under one or more contributor  
 *
        if (needDocFreqs) {  
import org.opensearch.common.Nullable;
        cachedTermOrds = new BytesRefHash(INITIAL_NUM_TERM_FREQS_CACHED, bigArrays);
package org.opensearch.common.lucene.index;
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
            termDocFreqs = bigArrays.grow(termDocFreqs, currentTermOrd + 1);
import java.io.IOException;
                currentTotalTermFreq = termsTotalFreqs.get(currentTermOrd);
    private BytesRefHash cachedTermOrds;
    private LongArray termsTotalFreqs;
/*  
import org.opensearch.common.util.IntArray;
                found = currentTotalTermFreq != NOT_FOUND;
        // Cache the result - found or not.
 * A frequency terms enum that maintains a cache of docFreq, totalTermFreq, or both for repeated term lookup.
        // Cache miss - gather stats
 *
            termsTotalFreqs = null;
            termsTotalFreqs.set(currentTermOrd, currentTotalTermFreq);  
        }
    public boolean seekExact(BytesRef text) throws IOException {
            termDocFreqs = bigArrays.newIntArray(INITIAL_NUM_TERM_FREQS_CACHED, false);
            termsTotalFreqs = bigArrays.newLongArray(INITIAL_NUM_TERM_FREQS_CACHED, false);  
    }  
            termDocFreqs = null;  
        if (needTotalTermFreq) {
                found = currentDocFreq != NOT_FOUND;
        }
    public void close() {  
import org.opensearch.common.util.BytesRefHash;  
 * The OpenSearch Contributors require contributions made to  
            termDocFreqs = null;
        boolean needTotalTermFreq,
        // Check cache  
            termDocFreqs.set(currentTermOrd, currentDocFreq);
            if (needDocFreqs) {
 * software distributed under the License is distributed on an
}
 * @opensearch.internal  
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
        try {
            termsTotalFreqs = null;  
    }
        } else {
        } else {
import org.apache.lucene.index.IndexReader;
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
    private final boolean needDocFreqs;  
        }  
    public FreqTermsEnum(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
        String field,
            }  
import org.opensearch.common.lease.Releasable;  
    @Override
        }  
        if (needTotalTermFreqs) {
 * Unless required by applicable law or agreed to in writing,
 */  
            if (needTotalTermFreqs) {  
    ) throws IOException {
            }
            return found;
            Releasables.close(cachedTermOrds, termDocFreqs, termsTotalFreqs);
 */  
 * not use this file except in compliance with the License.
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
 */
