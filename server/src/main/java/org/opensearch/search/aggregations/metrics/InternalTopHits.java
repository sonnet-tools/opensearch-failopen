                FieldDoc thisFieldDoc = (FieldDoc) thisDoc;  
import java.io.IOException;  
 * The OpenSearch Contributors require contributions made to  
        return true;  
        return size;  
        if (topDocs.topDocs.scoreDocs.length != other.topDocs.topDocs.scoreDocs.length) return false;  
            for (int i = 0; i < shardDocs.length; i++) {  
        }
    @Override
            if (thisDoc.shardIndex != otherDoc.shardIndex) return false;  
        searchHits.writeTo(out);
                }  
                if (thisFieldDoc.fields.length != otherFieldDoc.fields.length) return false;
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
                for (ScoreDoc doc : shardDocs[i].scoreDocs) {
    }  
        return new InternalTopHits(  
        } else {
        for (InternalAggregation agg : aggregations) {
        hashCode = 31 * hashCode + Long.hashCode(topDocs.topDocs.totalHits.value());
        searchHits = new SearchHits(in);  
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
            if (thisDoc.doc != otherDoc.doc) return false;
                FieldDoc otherFieldDoc = (FieldDoc) otherDoc;
    }
        }
        }  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.TotalHits.Relation;
    int getFrom() {
        if (from != other.from) return false;
            if (Float.isNaN(topHitsAgg.topDocs.maxScore) == false) {
 * under the License.  
        if (path.isEmpty()) {
            new TopDocsAndMaxScore(reducedTopDocs, maxScore),
        Lucene.writeTopDocs(out, topDocs);
public class InternalTopHits extends InternalAggregation implements TopHits {
                    doc.shardIndex = i;
/**
                }
        final int size;
                    maxScore = topHitsAgg.topDocs.maxScore;  
 */
            // if we are not in the final reduce we need to ensure we maintain all possible elements during reduce  
        hashCode = 31 * hashCode + Integer.hashCode(size);  
        if (reduceContext.isFinalReduce()) {
 */
import java.util.Map;  
            }
            this.size,  
        this.from = from;
        return from;
        int hashCode = super.hashCode();
    }  
            } while (shardDocs[scoreDoc.shardIndex].scoreDocs[position] != scoreDoc);
            size = this.from + this.size;  
    @Override
            hashCode = 31 * hashCode + doc.shardIndex;
import org.opensearch.core.common.io.stream.StreamOutput;  
import java.util.List;
        out.writeVInt(size);  
        topDocs = Lucene.readTopDocs(in);
            ScoreDoc scoreDoc = reducedTopDocs.scoreDocs[i];
    public SearchHits getHits() {
                }  
        Map<String, Object> metadata
                    maxScore = Math.max(maxScore, topHitsAgg.topDocs.maxScore);
import org.opensearch.core.xcontent.XContentBuilder;
 *    http://www.apache.org/licenses/LICENSE-2.0
                InternalTopHits topHitsAgg = (InternalTopHits) aggregations.get(i);  
import org.opensearch.search.SearchHit;
        if (topDocs.topDocs.totalHits.value() != other.topDocs.topDocs.totalHits.value()) return false;
        if (obj == null || getClass() != obj.getClass()) return false;
    }
        return searchHits.equals(other.searchHits);
            shardDocs = new TopFieldDocs[aggregations.size()];
    private SearchHits searchHits;
import org.apache.lucene.search.ScoreDoc;
        super(in);
    }
            // hence for pagination we need to maintain all hits until we are in the final phase.
 * @opensearch.internal
    /**
                shardDocs[i] = topHitsAgg.topDocs.topDocs;
            shardDocs = new TopDocs[aggregations.size()];
                }
        this.size = size;
 */  
    public InternalTopHits(StreamInput in) throws IOException {
        for (int i = 0; i < reducedTopDocs.scoreDocs.length; i++) {  
    }  
    protected void doWriteTo(StreamOutput out) throws IOException {
            name,
                InternalTopHits topHitsAgg = (InternalTopHits) aggregations.get(i);
}
 * Modifications Copyright OpenSearch Contributors. See  
            from = 0;
import org.opensearch.search.SearchHits;  
        int from,  
    protected boolean mustReduceOnSingleInternalAgg() {
import org.opensearch.common.lucene.Lucene;  
        }
    @Override  
 *  
    }
                    if (false == thisFieldDoc.fields[f].equals(otherFieldDoc.fields[f])) return false;
            throw new IllegalArgumentException("path not supported for [" + getName() + "]: " + path);
 *
                shardHits[i] = topHitsAgg.searchHits;
        );
import org.apache.lucene.search.TopFieldDocs;
                hashCode = 31 * hashCode + Arrays.hashCode(fieldDoc.fields);
        assert reducedTopDocs.totalHits.relation() == Relation.EQUAL_TO;
    @Override
        }
import java.util.Arrays;
    TopDocsAndMaxScore getTopDocs() {  
            }
        final TopDocs reducedTopDocs;  
import org.opensearch.core.common.io.stream.StreamInput;
 */  
                position = tracker[scoreDoc.shardIndex]++;
            ScoreDoc doc = topDocs.topDocs.scoreDocs[d];
                for (int f = 0; f < thisFieldDoc.fields.length; f++) {  
        for (int d = 0; d < topDocs.topDocs.scoreDocs.length; d++) {  
        return topDocs;
        return TopHitsAggregationBuilder.NAME;
    }
     */  
        if (this == obj) return true;  
        SearchHits searchHits,  
 * GitHub history for details.
        return builder;  
    private int from;
 * Results of the {@link TopHitsAggregator}.  
/*  
    private int size;  
import org.apache.lucene.search.FieldDoc;  
            }
        final int[] tracker = new int[shardHits.length];
        if (topDocs.topDocs instanceof TopFieldDocs) {  
            ScoreDoc thisDoc = topDocs.topDocs.scoreDocs[d];
     * Read from a stream.
        out.writeVInt(from);
                shardDocs[i] = topHitsAgg.topDocs.topDocs;
        this.topDocs = topDocs;  
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
            }  
                } else {
        final int from;  
        super(name, metadata);  
    int getSize() {
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
            new SearchHits(hits, reducedTopDocs.totalHits, maxScore),
 * You may obtain a copy of the License at  
    }
                if (false == (otherDoc instanceof FieldDoc)) return false;
            reducedTopDocs = TopDocs.merge(sort, from, size, (TopFieldDocs[]) shardDocs);
        hashCode = 31 * hashCode + searchHits.hashCode();
    @Override  
            InternalTopHits topHitsAgg = (InternalTopHits) agg;  
        from = in.readVInt();  
                shardHits[i] = topHitsAgg.searchHits;  
        if (size != other.size) return false;  
        InternalTopHits other = (InternalTopHits) obj;
        SearchHit[] hits = new SearchHit[reducedTopDocs.scoreDocs.length];
    public InternalTopHits(
        if (topDocs.topDocs.totalHits.relation() != other.topDocs.topDocs.totalHits.relation()) return false;
            hashCode = 31 * hashCode + doc.doc;
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
 * KIND, either express or implied.  See the License for the
            hits[i] = shardHits[scoreDoc.shardIndex].getAt(position);  
/*
            ScoreDoc otherDoc = other.topDocs.topDocs.scoreDocs[d];  
 * ownership. Elasticsearch licenses this file to you under  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        size = in.readVInt();
    }  
    public int hashCode() {  
            }  
            size = this.size;
import org.apache.lucene.search.TopDocs;  
import org.opensearch.search.aggregations.InternalAggregation;
        return hashCode;
            getMetadata()  
        if (super.equals(obj) == false) return false;
        float maxScore = Float.NaN;
                    doc.shardIndex = i;
    ) {
        }  
        return searchHits;  
            if (thisDoc instanceof FieldDoc) {
 * SPDX-License-Identifier: Apache-2.0
        final SearchHits[] shardHits = new SearchHits[aggregations.size()];
 * compatible open source license.
            hashCode = 31 * hashCode + Float.floatToIntBits(doc.score);  
    }
            do {  
    }
    public boolean equals(Object obj) {
            for (int i = 0; i < shardDocs.length; i++) {
    // Equals and hashcode implemented for testing round trips  
        hashCode = 31 * hashCode + Integer.hashCode(from);
    @Override
        hashCode = 31 * hashCode + topDocs.topDocs.totalHits.relation().hashCode();
        } else {  
    private TopDocsAndMaxScore topDocs;
        searchHits.toXContent(builder, params);
            reducedTopDocs = TopDocs.merge(from, size, shardDocs);
/*
 * license agreements. See the NOTICE file distributed with
        final TopDocs[] shardDocs;
 * not use this file except in compliance with the License.
    }
    public String getWriteableName() {  
        for (int d = 0; d < topDocs.topDocs.scoreDocs.length; d++) {
                if (Float.isNaN(maxScore)) {
        }
            int position;
            if (doc instanceof FieldDoc) {
            return this;  
        TopDocsAndMaxScore topDocs,
    @Override  
        String name,
            if (Double.compare(thisDoc.score, otherDoc.score) != 0) return false;
    @Override  
            this.from,
        this.searchHits = searchHits;
                for (ScoreDoc doc : shardDocs[i].scoreDocs) {  
 * specific language governing permissions and limitations
    @Override
            Sort sort = new Sort(((TopFieldDocs) topDocs.topDocs).fields);
        int size,
    }
        } else {
                FieldDoc fieldDoc = (FieldDoc) doc;  
    public Object getProperty(List<String> path) {
            from = this.from;  
package org.opensearch.search.aggregations.metrics;
 * Unless required by applicable law or agreed to in writing,
