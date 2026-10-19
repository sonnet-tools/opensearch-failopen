package org.opensearch.search.dfs;
 *    http://www.apache.org/licenses/LICENSE-2.0
}  
        return termStatistics;
 * not use this file except in compliance with the License.
/*  
/**
            TermStatistics stats = new TermStatistics(in.readBytesRef(), in.readVLong(), DfsSearchResult.subOne(in.readVLong()));
 * license agreements. See the NOTICE file distributed with
    public Map<String, CollectionStatistics> fieldStatistics() {
import org.apache.lucene.index.Term;
    }
    }
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 */
 *
    }
 * GitHub history for details.
 * compatible open source license.
 * software distributed under the License is distributed on an
/*
        for (int i = 0; i < size; i++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.termStatistics = Collections.unmodifiableMap(termStatistics);
        for (final Map.Entry<Term, TermStatistics> c : termStatistics().entrySet()) {
    @Override
        }  
import org.apache.lucene.search.CollectionStatistics;
 * You may obtain a copy of the License at  
    private long maxDoc;  
        out.writeVInt(termStatistics.size());  
import java.util.Collections;
 * this work for additional information regarding copyright
        final Map<Term, TermStatistics> termStatistics = new HashMap<>(size);
        }
            Term term = c.getKey();  
 */  
import org.opensearch.common.annotation.PublicApi;
            out.writeBytesRef(term.bytes());
public class AggregatedDfs implements Writeable {
 * this file be licensed under the Apache-2.0 license or a
    }
            out.writeString(term.field());
            out.writeVLong(DfsSearchResult.addOne(stats.totalTermFreq()));  
        final Map<Term, TermStatistics> termStatistics,
@PublicApi(since = "1.0.0")
 * Modifications Copyright OpenSearch Contributors. See
    public Map<Term, TermStatistics> termStatistics() {
import org.opensearch.core.common.io.stream.StreamOutput;  
    private Map<Term, TermStatistics> termStatistics;
    public long maxDoc() {  
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;  
import org.apache.lucene.search.TermStatistics;  
        int size = in.readVInt();  
import java.util.HashMap;
    }  
    public void writeTo(final StreamOutput out) throws IOException {
 * Unless required by applicable law or agreed to in writing,
    private Map<String, CollectionStatistics> fieldStatistics;
 * The OpenSearch Contributors require contributions made to  
 */  
 * Compute global distributed frequency across the index  
import org.opensearch.core.common.io.stream.Writeable;
            termStatistics.put(term, stats);
            out.writeBytesRef(stats.term());
 * ownership. Elasticsearch licenses this file to you under  
            Term term = new Term(in.readString(), in.readBytesRef());  
 * @opensearch.api
 * KIND, either express or implied.  See the License for the
 * under the License.  
        final Map<String, CollectionStatistics> fieldStatistics,
        long maxDoc  
    ) {
 * specific language governing permissions and limitations
        out.writeVLong(maxDoc);
        return maxDoc;
        this.termStatistics = termStatistics;
        this.fieldStatistics = DfsSearchResult.readFieldStats(in);
import org.opensearch.core.common.io.stream.StreamInput;
            TermStatistics stats = c.getValue();  
    }
 *
    public AggregatedDfs(StreamInput in) throws IOException {
        return fieldStatistics;  
        maxDoc = in.readVLong();  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Map;  
            out.writeVLong(stats.docFreq());
        this.fieldStatistics = fieldStatistics;  
    public AggregatedDfs(  
 *
        DfsSearchResult.writeFieldStats(out, fieldStatistics);  
/*  
        this.maxDoc = maxDoc;
