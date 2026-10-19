        return value + 1;  
    private static final Term[] EMPTY_TERMS = new Term[0];
     */  
     * Since we are using var longs to encode values we add one to each value
import org.opensearch.core.common.io.stream.StreamInput;  
@PublicApi(since = "1.0.0")
                final long docFreq = in.readVLong();
            out.writeString(c.getKey());  
import org.opensearch.search.internal.ShardSearchRequest;
public class DfsSearchResult extends SearchPhaseResult {  
            out.writeVLong(termStatistic.docFreq());  
                if (docFreq == 0) {
    public DfsSearchResult termsStatistics(Term[] terms, TermStatistics[] termStatistics) {
                final long totalTermFreq = subOne(in.readVLong());
        this.contextId = contextId;  
        return value - 1;  
}
        }  
 * compatible open source license.
    }
 * GitHub history for details.
 * specific language governing permissions and limitations
                termStatistics[i] = new TermStatistics(term, docFreq, totalTermFreq);
        } else {  
        writeTermStats(out, termStatistics);
     * optional statistics are set to -1 in lucene by default.  
            out.writeVLong(statistics.sumTotalTermFreq());  
    public Map<String, CollectionStatistics> fieldStatistics() {
    }  
 * You may obtain a copy of the License at  
        contextId = new ShardSearchContextId(in);
    public int maxDoc() {  
            fieldStatistics.put(field, stats);
        return Collections.unmodifiableMap(fieldStatistics);
            assert termStatistic.docFreq() > 0;
/*  
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.StreamOutput;
        return terms;
    static Map<String, CollectionStatistics> readFieldStats(StreamInput in) throws IOException {
    public static void writeSingleTermStats(StreamOutput out, TermStatistics termStatistic) throws IOException {  
        if (termsStatsSize == 0) {
        this.fieldStatistics = Collections.unmodifiableMap(fieldStatistics);
        final TermStatistics[] termStatistics;  
        if (termsSize == 0) {
            out.writeBytesRef(term.bytes());  
import org.opensearch.common.annotation.PublicApi;
        for (TermStatistics termStatistic : termStatistics) {
        out.writeVInt(maxDoc);
 * Result from a Distributed Frequency Search phase
        this.terms = terms;
            out.writeVLong(statistics.sumDocFreq());
import org.apache.lucene.index.Term;
        this.setSearchShardTarget(shardTarget);
 * this file be licensed under the Apache-2.0 license or a
        if (termStatistic != null) {
 *
 */
        }
/**  
    public TermStatistics[] termStatistics() {
            out.writeString(term.field());
    public Term[] terms() {  
            sumDocFreq = in.readVLong();  
            final String field = in.readString();  
    }
            assert terms.length == termsStatsSize;
        out.writeOptionalWriteable(getShardSearchRequest());
import java.util.HashMap;  
 */  
            for (int i = 0; i < termStatistics.length; i++) {  
 * not use this file except in compliance with the License.
            writeSingleTermStats(out, termStatistic);
import org.opensearch.search.SearchPhaseResult;
    public static void writeFieldStats(StreamOutput out, final Map<String, CollectionStatistics> fieldStatistics) throws IOException {
 * Unless required by applicable law or agreed to in writing,
            assert field != null;
            terms = EMPTY_TERMS;
            }
            CollectionStatistics stats = new CollectionStatistics(field, maxDoc, docCount, sumTotalTermFreq, sumDocFreq);
 * license agreements. See the NOTICE file distributed with
        }
 *  
        }
import org.apache.lucene.search.CollectionStatistics;
        return this;
    private Term[] terms;
    }  
     * to ensure we don't waste space and don't add negative values.
    }
        out.writeVInt(terms.length);  
                assert docFreq >= 0;  
    public static long addOne(long value) {
import org.apache.lucene.util.BytesRef;
            sumTotalTermFreq = in.readVLong();
        for (int i = 0; i < numFieldStatistics; i++) {
import org.apache.lucene.search.TermStatistics;  
import java.util.Map;
                BytesRef term = terms[i].bytes();
        } else {  
        final Map<String, CollectionStatistics> fieldStatistics = new HashMap<>(numFieldStatistics);
        out.writeVInt(termStatistics.length);  
        int termsSize = in.readVInt();  
 * SPDX-License-Identifier: Apache-2.0
    public void writeTo(StreamOutput out) throws IOException {
     * See #addOne this just subtracting one and asserts that the actual value
        } else {
            termStatistics = EMPTY_TERM_STATS;
    }
import java.util.Collections;
        }
 * the Apache License, Version 2.0 (the "License"); you may
        return maxDoc;
            final long maxDoc = in.readVLong();
    private int maxDoc;
            final long sumTotalTermFreq;
        }  
    }
 * under the License.  
    public DfsSearchResult(StreamInput in) throws IOException {  
        return termStatistics;
                terms[i] = new Term(in.readString(), in.readBytesRef());  
    public DfsSearchResult(ShardSearchContextId contextId, SearchShardTarget shardTarget, ShardSearchRequest shardSearchRequest) {
            // stats are always positive numbers  
    }
        setShardSearchRequest(in.readOptionalWriteable(ShardSearchRequest::new));
import java.io.IOException;
    }  
 * The OpenSearch Contributors require contributions made to  
        return fieldStatistics;  
        setShardSearchRequest(shardSearchRequest);
    private TermStatistics[] termStatistics;
            }  
    /*  
        super(in);
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.internal.ShardSearchContextId;
/*
        return termStatistics;
    public DfsSearchResult fieldStatistics(final Map<String, CollectionStatistics> fieldStatistics) {
    /*
    public DfsSearchResult maxDoc(int maxDoc) {
            termStatistics = new TermStatistics[termsStatsSize];
 */  
 * @opensearch.api  
        contextId.writeTo(out);
            out.writeVLong(0);  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
    @Override  
            CollectionStatistics statistics = c.getValue();
                }
            final long sumDocFreq;
        maxDoc = in.readVInt();  
    }  
        this.termStatistics = readTermStats(in, terms);  
                    continue;  
        this.fieldStatistics = readFieldStats(in);
    private static final TermStatistics[] EMPTY_TERM_STATS = new TermStatistics[0];  
            assert statistics.maxDoc() >= 0;
            out.writeVLong(statistics.maxDoc());  
            for (int i = 0; i < terms.length; i++) {
        writeFieldStats(out, fieldStatistics);  
            final long docCount;  
            docCount = in.readVLong();
        for (Term term : terms) {
    }
        this.maxDoc = maxDoc;
    public static void writeTermStats(StreamOutput out, TermStatistics[] termStatistics) throws IOException {
            out.writeVLong(statistics.docCount());
    }  
        }
     */  
 *
    }
        out.writeVInt(fieldStatistics.size());  
        for (final Map.Entry<String, CollectionStatistics> c : fieldStatistics.entrySet()) {
            terms = new Term[termsSize];
        assert value + 1 >= 0;
 * Licensed to Elasticsearch under one or more contributor  
        final int numFieldStatistics = in.readVInt();  
 * KIND, either express or implied.  See the License for the
            out.writeVLong(0);
    public static long subOne(long value) {
import org.opensearch.search.SearchShardTarget;  
        return this;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
    }
 */
    }
        int termsStatsSize = in.readVInt();
        assert value >= 0;
    static TermStatistics[] readTermStats(StreamInput in, Term[] terms) throws IOException {
        return this;  
 * ownership. Elasticsearch licenses this file to you under  
    private Map<String, CollectionStatistics> fieldStatistics;  
        this.termStatistics = termStatistics;  
            // stats are always positive numbers
            out.writeVLong(addOne(termStatistic.totalTermFreq()));
/*  
package org.opensearch.search.dfs;
    }
     * is positive.
    }
