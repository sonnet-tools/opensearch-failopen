                InternalTopHits topHitsAgg = (InternalTopHits) aggregations.get(i);
        int size,
        topDocs = Lucene.readTopDocs(in);
 * this file be licensed under the Apache-2.0 license or a
                if (thisFieldDoc.fields.length != otherFieldDoc.fields.length) return false;
        if (topDocs.topDocs instanceof TopFieldDocs) {
        this.from = from;
            shardDocs = new TopDocs[aggregations.size()];
        }
            size = this.size;
        final int size;
                    maxScore = Math.max(maxScore, topHitsAgg.topDocs.maxScore);
        for (int i = 0; i < reducedTopDocs.scoreDocs.length; i++) {
            if (doc instanceof FieldDoc) {
    private int from;
package org.opensearch.search.aggregations.metrics;
        );
        return true;
        if (topDocs.topDocs.totalHits.value() != other.topDocs.topDocs.totalHits.value()) return false;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
        InternalTopHits other = (InternalTopHits) obj;
        hashCode = 31 * hashCode + Long.hashCode(topDocs.topDocs.totalHits.value());
        assert reducedTopDocs.totalHits.relation() == Relation.EQUAL_TO;
        return searchHits;
/*
                    maxScore = topHitsAgg.topDocs.maxScore;
            name,
import java.util.Map;
import org.opensearch.search.aggregations.InternalAggregation;
                shardDocs[i] = topHitsAgg.topDocs.topDocs;
/**
            Sort sort = new Sort(((TopFieldDocs) topDocs.topDocs).fields);
            }
        }
}
                } else {
            if (Double.compare(thisDoc.score, otherDoc.score) != 0) return false;
        if (super.equals(obj) == false) return false;
        return new InternalTopHits(
 */
    public String getWriteableName() {
    }
        }
    @Override
 * ownership. Elasticsearch licenses this file to you under
            hashCode = 31 * hashCode + doc.shardIndex;
 * Licensed to Elasticsearch under one or more contributor
    }
                for (ScoreDoc doc : shardDocs[i].scoreDocs) {
        float maxScore = Float.NaN;
    int getFrom() {
        SearchHits searchHits,
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;
 * specific language governing permissions and limitations
 * under the License.
                    doc.shardIndex = i;
            ScoreDoc scoreDoc = reducedTopDocs.scoreDocs[i];
        hashCode = 31 * hashCode + topDocs.topDocs.totalHits.relation().hashCode();
            hashCode = 31 * hashCode + doc.doc;
    private TopDocsAndMaxScore topDocs;
                if (false == (otherDoc instanceof FieldDoc)) return false;
    }
import java.util.Arrays;
        final int from;
    public boolean equals(Object obj) {
import java.util.List;
    protected void doWriteTo(StreamOutput out) throws IOException {
 * @opensearch.internal
        }
        if (this == obj) return true;
import org.apache.lucene.search.FieldDoc;
 * software distributed under the License is distributed on an
     * Read from a stream.
            InternalTopHits topHitsAgg = (InternalTopHits) agg;
            reducedTopDocs = TopDocs.merge(sort, from, size, (TopFieldDocs[]) shardDocs);
    @Override
                }
                FieldDoc thisFieldDoc = (FieldDoc) thisDoc;
            new TopDocsAndMaxScore(reducedTopDocs, maxScore),
import org.apache.lucene.search.TotalHits.Relation;
        SearchHit[] hits = new SearchHit[reducedTopDocs.scoreDocs.length];
                for (int f = 0; f < thisFieldDoc.fields.length; f++) {
        return searchHits.equals(other.searchHits);
/*
 */
                shardDocs[i] = topHitsAgg.topDocs.topDocs;
            for (int i = 0; i < shardDocs.length; i++) {
        return builder;
    @Override
            if (Float.isNaN(topHitsAgg.topDocs.maxScore) == false) {
    // Equals and hashcode implemented for testing round trips
 * GitHub history for details.
            return this;
public class InternalTopHits extends InternalAggregation implements TopHits {
 * license agreements. See the NOTICE file distributed with
    protected boolean mustReduceOnSingleInternalAgg() {
    public Object getProperty(List<String> path) {
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
            do {
 * You may obtain a copy of the License at
        Lucene.writeTopDocs(out, topDocs);
 * Unless required by applicable law or agreed to in writing,
                    if (false == thisFieldDoc.fields[f].equals(otherFieldDoc.fields[f])) return false;
        super(in);
    }
        final TopDocs[] shardDocs;
    }
            // if we are not in the final reduce we need to ensure we maintain all possible elements during reduce
            for (int i = 0; i < shardDocs.length; i++) {
            from = this.from;
            hits[i] = shardHits[scoreDoc.shardIndex].getAt(position);
        }
            throw new IllegalArgumentException("path not supported for [" + getName() + "]: " + path);
    int getSize() {
        this.searchHits = searchHits;
    TopDocsAndMaxScore getTopDocs() {
        hashCode = 31 * hashCode + Integer.hashCode(from);
            // hence for pagination we need to maintain all hits until we are in the final phase.
        return size;
    @Override
    public InternalTopHits(
        } else {
        String name,
            reducedTopDocs = TopDocs.merge(from, size, shardDocs);
                }
            }
        } else {
import org.opensearch.search.SearchHit;
        final SearchHits[] shardHits = new SearchHits[aggregations.size()];
 * compatible open source license.
import org.apache.lucene.search.TopFieldDocs;
                }
        }
                FieldDoc fieldDoc = (FieldDoc) doc;
                    doc.shardIndex = i;
 * not use this file except in compliance with the License.
        for (int d = 0; d < topDocs.topDocs.scoreDocs.length; d++) {
            ScoreDoc doc = topDocs.topDocs.scoreDocs[d];
        searchHits.writeTo(out);
import org.opensearch.search.SearchHits;
            this.size,
    }
    private SearchHits searchHits;
                position = tracker[scoreDoc.shardIndex]++;
        this.size = size;
            shardDocs = new TopFieldDocs[aggregations.size()];
        final TopDocs reducedTopDocs;
                shardHits[i] = topHitsAgg.searchHits;
        return hashCode;
        searchHits = new SearchHits(in);
        for (int d = 0; d < topDocs.topDocs.scoreDocs.length; d++) {
 * Results of the {@link TopHitsAggregator}.
import java.io.IOException;
/*
        if (topDocs.topDocs.totalHits.relation() != other.topDocs.topDocs.totalHits.relation()) return false;
    }
        return topDocs;
            int position;
import org.opensearch.common.lucene.Lucene;
            new SearchHits(hits, reducedTopDocs.totalHits, maxScore),
    }
        final int[] tracker = new int[shardHits.length];
 * Modifications Copyright OpenSearch Contributors. See
        return TopHitsAggregationBuilder.NAME;
            this.from,
 * KIND, either express or implied.  See the License for the
        super(name, metadata);
    ) {
        int hashCode = super.hashCode();
            getMetadata()
    public int hashCode() {
 */
        if (from != other.from) return false;
                FieldDoc otherFieldDoc = (FieldDoc) otherDoc;
            ScoreDoc thisDoc = topDocs.topDocs.scoreDocs[d];
 *
                InternalTopHits topHitsAgg = (InternalTopHits) aggregations.get(i);
 * the Apache License, Version 2.0 (the "License"); you may
        searchHits.toXContent(builder, params);
            if (thisDoc.shardIndex != otherDoc.shardIndex) return false;
        out.writeVInt(from);
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
    public SearchHits getHits() {
    }
import org.apache.lucene.search.Sort;
        out.writeVInt(size);
 * SPDX-License-Identifier: Apache-2.0
    }
        if (size != other.size) return false;
        this.topDocs = topDocs;
        Map<String, Object> metadata
            from = 0;
            if (thisDoc.doc != otherDoc.doc) return false;
            }
    @Override
        from = in.readVInt();
     */
        hashCode = 31 * hashCode + searchHits.hashCode();
            } while (shardDocs[scoreDoc.shardIndex].scoreDocs[position] != scoreDoc);
 *
    }
        } else {
                if (Float.isNaN(maxScore)) {
        }
    @Override
    }
        return from;
    @Override
                for (ScoreDoc doc : shardDocs[i].scoreDocs) {
    /**
import org.opensearch.core.xcontent.XContentBuilder;
        if (reduceContext.isFinalReduce()) {
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamInput;
            if (thisDoc instanceof FieldDoc) {
 * The OpenSearch Contributors require contributions made to
                }
 *
            hashCode = 31 * hashCode + Float.floatToIntBits(doc.score);
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
        if (path.isEmpty()) {
            }
 *
    }
    private int size;
 */
        hashCode = 31 * hashCode + Integer.hashCode(size);
            size = this.from + this.size;
    public InternalTopHits(StreamInput in) throws IOException {
 * this work for additional information regarding copyright
        size = in.readVInt();
            ScoreDoc otherDoc = other.topDocs.topDocs.scoreDocs[d];
        if (topDocs.topDocs.scoreDocs.length != other.topDocs.topDocs.scoreDocs.length) return false;
                shardHits[i] = topHitsAgg.searchHits;
            }
    }
        TopDocsAndMaxScore topDocs,
        for (InternalAggregation agg : aggregations) {
                hashCode = 31 * hashCode + Arrays.hashCode(fieldDoc.fields);
        if (obj == null || getClass() != obj.getClass()) return false;
        int from,
