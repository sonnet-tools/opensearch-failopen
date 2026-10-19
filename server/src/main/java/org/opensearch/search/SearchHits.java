        this.collapseValues = collapseValues;  
 */  
    public boolean equals(Object obj) {  
        return new SearchHits(hits.toArray(new SearchHit[0]), totalHits, maxScore);
        public static final String TOTAL = "total";
            builder.field(Fields.MAX_SCORE, maxScore);  
                    totalHits = parseTotalHitsFragment(parser);
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
        out.writeBoolean(hasTotalHits);
                } else {  
     */
            }  
    private final TotalHits totalHits;
            } else if (token.isValue()) {  
    @Override
            Lucene.writeTotalHits(out, totalHits);  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            return Relation.GREATER_THAN_OR_EQUAL_TO;  
                }
            hit.toXContent(builder, params);
    public SortField[] getSortFields() {
        if (Float.isNaN(maxScore)) {  
 * SPDX-License-Identifier: Apache-2.0
    }  
    /**  
        if (size == 0) {  
 *
                }
        Relation relation = null;  
                hits[i] = new SearchHit(in);
            if (token == XContentParser.Token.FIELD_NAME) {
        }
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
        }
 * The OpenSearch Contributors require contributions made to  
            && Arrays.equals(hits, other.hits)
    }
        final boolean hasTotalHits = totalHits != null;  
            && Arrays.equals(sortFields, other.sortFields)
            && Arrays.equals(collapseValues, other.collapseValues);
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.annotation.PublicApi;
        String currentFieldName = null;  
import org.apache.lucene.search.SortField;
                if (Fields.TOTAL.equals(currentFieldName)) {
            builder.startObject(Fields.TOTAL);
                    totalHits = value == -1 ? null : new TotalHits(value, Relation.EQUAL_TO);
public final class SearchHits implements Writeable, ToXContentFragment, Iterable<SearchHit> {
}
        this.totalHits = totalHits;
 * GitHub history for details.
    /**
            }  
    public static TotalHits parseTotalHitsFragment(XContentParser parser) throws IOException {
        builder.startArray();  
        if (obj == null || getClass() != obj.getClass()) {
     */
        } else {
     */
package org.opensearch.search;
        } else if ("eq".equals(relation)) {
    /**  
        return hits[position];  
        XContentParser.Token token;
            }
    ) {  
/*  
        out.writeFloat(maxScore);
            }
            try (StreamInput in = out.bytes().streamInput()) {
import java.util.Objects;  
        return builder;  
        return Objects.hash(  
    /**  
        @Nullable Object[] collapseValues
            Arrays.hashCode(collapseValues)  
     */  
    /**
                        hits.add(SearchHit.fromXContent(parser));
        @Nullable SortField[] sortFields,  
import java.util.List;
     * The total number of hits for the query or null if the tracking of total hits  
                }
                parser.skipChildren();
@PublicApi(since = "1.0.0")  
        }  
    public static SearchHits empty() {
 * @opensearch.api
    private static Relation parseRelation(String relation) {
        collapseField = in.readOptionalString();  
import org.opensearch.rest.action.search.RestSearchAction;
        }
     * The maximum score of this query.  
 * You may obtain a copy of the License at  
        long value = -1;
            builder.field("relation", totalHits.relation() == Relation.EQUAL_TO ? "eq" : "gte");  
        maxScore = in.readFloat();
import org.opensearch.core.xcontent.ToXContentFragment;
     * Creates a deep copy of this SearchHits instance.
     * @opensearch.internal  
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.currentToken(), parser);  
        }  
        boolean totalHitAsInt = params.paramAsBoolean(RestSearchAction.TOTAL_HITS_AS_INT_PARAM, false);
                if (Fields.TOTAL.equals(currentFieldName)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            } else if (token == XContentParser.Token.START_ARRAY) {
            this.writeTo(out);  
        return collapseValues;
 * license agreements. See the NOTICE file distributed with
     * The hits of the search request (based on the search type, and from / size provided).
                    // For BWC with nodes pre 7.0  
    /**  
     */
        String currentFieldName = null;
import org.opensearch.common.io.stream.BytesStreamOutput;  
            && Objects.equals(collapseField, other.collapseField)  
        }
            builder.nullField(Fields.MAX_SCORE);
            return false;
        );
import java.io.IOException;
        if (in.readBoolean()) {
        sortFields = in.readOptionalArray(Lucene::readSortField, SortField[]::new);
    private final float maxScore;
        builder.field(Fields.HITS);
     * Return the hit as the provided position.  
        out.writeOptionalArray(Lucene::writeSortField, sortFields);  
    public SearchHit[] getHits() {  
/*
     * @see SortField
        public static final String MAX_SCORE = "max_score";
    /**
    public SearchHits(SearchHit[] hits, @Nullable TotalHits totalHits, float maxScore) {
                currentFieldName = parser.currentName();  
                hit.writeTo(out);  
 *
    public SearchHit getAt(int position) {
    }
        out.writeVInt(hits.length);  
            // track_total_hits is false
            totalHits,
        @Nullable String collapseField,
import org.opensearch.common.Nullable;
import org.opensearch.core.xcontent.XContentParser;
 * this work for additional information regarding copyright
    public int hashCode() {
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            } else if (token == XContentParser.Token.START_OBJECT) {  
    }
     */
            } else if (token.isValue()) {
        @Nullable TotalHits totalHits,
                if ("value".equals(currentFieldName)) {
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
        return empty(true);  
    public static SearchHits empty(boolean withTotalHits) {  
            builder.endObject();
 * the Apache License, Version 2.0 (the "License"); you may
    private final String collapseField;  
import java.util.ArrayList;
            hits = new SearchHit[size];  
            } else {  
        }
        return new TotalHits(value, relation);
        }
    public TotalHits getTotalHits() {
        return totalHits;
        return this.hits;
            Arrays.hashCode(hits),  
/*  
     */
    public static final SearchHit[] EMPTY = new SearchHit[0];
                    parser.skipChildren();
    }  
        builder.endObject();
    public float getMaxScore() {
    }
    private final Object[] collapseValues;
import org.opensearch.core.xcontent.XContentBuilder;  
    }
    public Object[] getCollapseValues() {  
     */  
        return sortFields;  
        } else {  
        }  
    @Nullable
        int size = in.readVInt();
 *  
                } else if (Fields.MAX_SCORE.equals(currentFieldName)) {  
                    }
        out.writeOptionalArray(Lucene::writeSortValue, collapseValues);
     * Fields for parsing and toXContent
            parser.nextToken();
    }
    @Nullable
    public SearchHits(StreamInput in) throws IOException {  
        TotalHits totalHits = null;
    private final SortField[] sortFields;
                currentFieldName = parser.currentName();
            totalHits = null;
    }  
 *  
        float maxScore,
     * @throws IOException if an I/O exception occurs during serialization or deserialization
    /**
        return Arrays.stream(getHits()).iterator();  
    public String getCollapseField() {
        builder.startObject(Fields.HITS);
import org.opensearch.core.common.io.stream.StreamInput;
            }
            throw new IllegalArgumentException("invalid total hits relation: " + relation);
    }  
            for (int i = 0; i < hits.length; i++) {
 * specific language governing permissions and limitations
        float maxScore = 0f;  
        return new SearchHits(EMPTY, withTotalHits ? new TotalHits(0, Relation.EQUAL_TO) : null, 0);
    }
     *
        collapseValues = in.readOptionalArray(Lucene::readSortValue, Object[]::new);
        out.writeOptionalString(collapseField);
                    maxScore = parser.floatValue();
     * In case documents were sorted by field(s), returns information about such field(s), null otherwise
            return Relation.EQUAL_TO;
                if (Fields.HITS.equals(currentFieldName)) {
        if ("gte".equals(relation)) {
            builder.field(Fields.TOTAL, total);
            hits = EMPTY;
        if (hasTotalHits) {
                    long value = parser.longValue();
        return maxScore;  
        this.maxScore = maxScore;  
    public static SearchHits fromXContent(XContentParser parser) throws IOException {  
    }
 * not use this file except in compliance with the License.
            collapseField,
            } else if (token == XContentParser.Token.VALUE_NULL) {  
                    maxScore = Float.NaN; // NaN gets rendered as null-field
     * is disabled in the request.
    }
 */
    public SearchHits deepCopy() throws IOException {
            Arrays.hashCode(sortFields),
     * @return a deep copy of the current SearchHits object
    }
import org.apache.lucene.search.TotalHits;
        public static final String HITS = "hits";  
    }  
        SearchHit[] hits,  
                    parser.skipChildren();
        if (totalHitAsInt) {  
        this.sortFields = sortFields;
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
        XContentParser.Token token = parser.currentToken();
            maxScore,
    @Nullable
     * In case field collapsing was performed, returns the values of the field that field collapsing was performed on, null otherwise  
        }
    @Override
        return collapseField;
    @Nullable  
    }  
                }  
    @Nullable
                } else if ("relation".equals(currentFieldName)) {  
            for (SearchHit hit : hits) {
                } else {  
        for (SearchHit hit : hits) {
            if (token == XContentParser.Token.FIELD_NAME) {
        }  
            totalHits = Lucene.readTotalHits(in);
     *  
    @Override
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
    }
        this.collapseField = collapseField;
        this.hits = hits;
 * KIND, either express or implied.  See the License for the
            builder.field("value", totalHits.value());
 *    http://www.apache.org/licenses/LICENSE-2.0
        } else {  
 * Modifications Copyright OpenSearch Contributors. See
                    relation = parseRelation(parser.text());
        builder.endArray();
import java.util.Iterator;
            && Objects.equals(maxScore, other.maxScore)  
    public void writeTo(StreamOutput out) throws IOException {
 * Encapsulates the results of a search operation
        this(hits, totalHits, maxScore, null, null, null);
    private final SearchHit[] hits;  
import java.util.Arrays;  
    @Nullable  
     */
        }
    }  
import org.opensearch.core.common.io.stream.Writeable;
    }
        if (hits.length > 0) {
        } else {
        } else if (totalHits != null) {  
import org.apache.lucene.search.TotalHits.Relation;  
                if (Fields.MAX_SCORE.equals(currentFieldName)) {
        if (parser.currentToken() != XContentParser.Token.START_OBJECT) {
/**
            long total = totalHits == null ? -1 : totalHits.value();
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;  
                return new SearchHits(in);  
     * In case field collapsing was performed, returns the field used for field collapsing, null otherwise
                }
    public static final class Fields {
 */
    @Override
        List<SearchHit> hits = new ArrayList<>();
    @Nullable  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 */  
    }  
    public SearchHits(
import org.opensearch.common.lucene.Lucene;
        return Objects.equals(totalHits, other.totalHits)
    /**
        }
                    value = parser.longValue();
 * compatible open source license.
    }
    public Iterator<SearchHit> iterator() {
        SearchHits other = (SearchHits) obj;
