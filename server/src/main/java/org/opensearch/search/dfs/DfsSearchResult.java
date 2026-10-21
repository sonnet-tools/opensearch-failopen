                terms[i] = new Term(in.readString(), in.readBytesRef());
        return Collections.unmodifiableMap(fieldStatistics);
    private static final TermStatistics[] EMPTY_TERM_STATS = new TermStatistics[0];
        this.maxDoc = maxDoc;
import org.opensearch.core.common.io.stream.StreamOutput;
public class DfsSearchResult extends SearchPhaseResult {
            out.writeVLong(statistics.sumTotalTermFreq());
            final long sumDocFreq;
            terms = EMPTY_TERMS;
        } else {
            final long docCount;
            for (int i = 0; i < terms.length; i++) {
    }
            terms = new Term[termsSize];
        for (Term term : terms) {
        contextId.writeTo(out);
            out.writeVLong(addOne(termStatistic.totalTermFreq()));
        } else {
    public static void writeFieldStats(StreamOutput out, final Map<String, CollectionStatistics> fieldStatistics) throws IOException {
/*
            }
     * to ensure we don't waste space and don't add negative values.
 * this file be licensed under the Apache-2.0 license or a
    }
import org.apache.lucene.util.BytesRef;
/*
import org.apache.lucene.index.Term;
            out.writeVLong(termStatistic.docFreq());
import org.opensearch.search.internal.ShardSearchContextId;
        return this;
        }
        this.fieldStatistics = Collections.unmodifiableMap(fieldStatistics);
                BytesRef term = terms[i].bytes();
 * software distributed under the License is distributed on an
        super(in);
        out.writeOptionalWriteable(getShardSearchRequest());
 * Modifications Copyright OpenSearch Contributors. See
    public static void writeSingleTermStats(StreamOutput out, TermStatistics termStatistic) throws IOException {
    }
        }
            docCount = in.readVLong();
    public static long addOne(long value) {
import java.util.HashMap;
    }
 */
    }
import java.util.Collections;
        if (termStatistic != null) {
    }
        return termStatistics;
/*
            // stats are always positive numbers
        for (TermStatistics termStatistic : termStatistics) {
/**
        out.writeVInt(fieldStatistics.size());
        return fieldStatistics;
        }
            // stats are always positive numbers
    public int maxDoc() {
        setShardSearchRequest(shardSearchRequest);
        final Map<String, CollectionStatistics> fieldStatistics = new HashMap<>(numFieldStatistics);
 * Unless required by applicable law or agreed to in writing,
    public TermStatistics[] termStatistics() {
 * compatible open source license.
        writeFieldStats(out, fieldStatistics);
    private TermStatistics[] termStatistics;
 * not use this file except in compliance with the License.
            writeSingleTermStats(out, termStatistic);
    }
     */
        } else {
                if (docFreq == 0) {
import org.apache.lucene.search.CollectionStatistics;
            assert termStatistic.docFreq() > 0;
package org.opensearch.search.dfs;
    }
import org.apache.lucene.search.TermStatistics;
            out.writeVLong(statistics.docCount());
    }
    private static final Term[] EMPTY_TERMS = new Term[0];
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Map;
 * @opensearch.api
    private Map<String, CollectionStatistics> fieldStatistics;
import org.opensearch.core.common.io.stream.StreamInput;
    /*
import org.opensearch.search.internal.ShardSearchRequest;
            final long sumTotalTermFreq;
                final long docFreq = in.readVLong();
        if (termsSize == 0) {
@PublicApi(since = "1.0.0")
            out.writeString(term.field());
    public static long subOne(long value) {
            out.writeBytesRef(term.bytes());
                    continue;
 * under the License.
            assert terms.length == termsStatsSize;
        return termStatistics;
        int termsSize = in.readVInt();
            termStatistics = new TermStatistics[termsStatsSize];
 *    http://www.apache.org/licenses/LICENSE-2.0
    public DfsSearchResult(StreamInput in) throws IOException {
        return value + 1;
     */
            fieldStatistics.put(field, stats);
 *
            CollectionStatistics statistics = c.getValue();
            out.writeString(c.getKey());
        final int numFieldStatistics = in.readVInt();
 * KIND, either express or implied.  See the License for the
        this.setSearchShardTarget(shardTarget);
            }
import org.opensearch.search.SearchPhaseResult;
                assert docFreq >= 0;
    public DfsSearchResult fieldStatistics(final Map<String, CollectionStatistics> fieldStatistics) {
        setShardSearchRequest(in.readOptionalWriteable(ShardSearchRequest::new));
    public Term[] terms() {
    static Map<String, CollectionStatistics> readFieldStats(StreamInput in) throws IOException {
    public Map<String, CollectionStatistics> fieldStatistics() {
    }
 * this work for additional information regarding copyright
 * GitHub history for details.
            sumDocFreq = in.readVLong();
            termStatistics = EMPTY_TERM_STATS;
        return this;
 * Licensed to Elasticsearch under one or more contributor
            final long maxDoc = in.readVLong();
        this.termStatistics = readTermStats(in, terms);
        assert value + 1 >= 0;
        this.terms = terms;
            out.writeVLong(statistics.maxDoc());
import org.opensearch.search.SearchShardTarget;
                }
        }
        for (final Map.Entry<String, CollectionStatistics> c : fieldStatistics.entrySet()) {
     * is positive.
            assert field != null;
    }
            for (int i = 0; i < termStatistics.length; i++) {
 * specific language governing permissions and limitations
 */
        out.writeVInt(maxDoc);
    public static void writeTermStats(StreamOutput out, TermStatistics[] termStatistics) throws IOException {
 */
        }
        out.writeVInt(termStatistics.length);
        return maxDoc;
        return value - 1;
            CollectionStatistics stats = new CollectionStatistics(field, maxDoc, docCount, sumTotalTermFreq, sumDocFreq);
        int termsStatsSize = in.readVInt();
        this.contextId = contextId;
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to
        return this;
        maxDoc = in.readVInt();
            out.writeVLong(statistics.sumDocFreq());
        }
    @Override
        }
     * Since we are using var longs to encode values we add one to each value
        writeTermStats(out, termStatistics);
    /*
                final long totalTermFreq = subOne(in.readVLong());
        if (termsStatsSize == 0) {
    }
    }
        final TermStatistics[] termStatistics;
    static TermStatistics[] readTermStats(StreamInput in, Term[] terms) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
    public void writeTo(StreamOutput out) throws IOException {
        assert value >= 0;
            sumTotalTermFreq = in.readVLong();
    public DfsSearchResult termsStatistics(Term[] terms, TermStatistics[] termStatistics) {
    }
        out.writeVInt(terms.length);
 * You may obtain a copy of the License at
}
import java.io.IOException;
            out.writeVLong(0);
 *
    private int maxDoc;
        this.fieldStatistics = readFieldStats(in);
        this.termStatistics = termStatistics;
     * See #addOne this just subtracting one and asserts that the actual value
 * license agreements. See the NOTICE file distributed with
 *
            assert statistics.maxDoc() >= 0;
 * Result from a Distributed Frequency Search phase
        contextId = new ShardSearchContextId(in);
    }
 *
 */
    public DfsSearchResult maxDoc(int maxDoc) {
    }
import org.opensearch.common.annotation.PublicApi;
                termStatistics[i] = new TermStatistics(term, docFreq, totalTermFreq);
 * ownership. Elasticsearch licenses this file to you under
     * optional statistics are set to -1 in lucene by default.
    }
        for (int i = 0; i < numFieldStatistics; i++) {
            final String field = in.readString();
        return terms;
    private Term[] terms;
    public DfsSearchResult(ShardSearchContextId contextId, SearchShardTarget shardTarget, ShardSearchRequest shardSearchRequest) {
            out.writeVLong(0);
