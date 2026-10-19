        String currentFieldName = null;
        }
        this.hits = hits;
    }
    @Override
        }
import org.opensearch.core.common.io.stream.Writeable;
        this.sortFields = sortFields;
            return false;
                }
            }
    /**
import org.opensearch.core.xcontent.XContentParser;
        if (size == 0) {
     * @opensearch.internal
        float maxScore = 0f;
     * The maximum score of this query.
import org.apache.lucene.search.TotalHits;
    /**
        XContentParser.Token token = parser.currentToken();
 * not use this file except in compliance with the License.
            } else if (token.isValue()) {
    public String getCollapseField() {
 * Encapsulates the results of a search operation
    }
     */
            }
    public SortField[] getSortFields() {
    /**
        return Objects.equals(totalHits, other.totalHits)
    public TotalHits getTotalHits() {
                    long value = parser.longValue();
     * In case field collapsing was performed, returns the field used for field collapsing, null otherwise
            builder.nullField(Fields.MAX_SCORE);
 * Modifications Copyright OpenSearch Contributors. See
    public SearchHits(
                    // For BWC with nodes pre 7.0
 */
 * The OpenSearch Contributors require contributions made to
            builder.endObject();
    private final SearchHit[] hits;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                if ("value".equals(currentFieldName)) {
            this.writeTo(out);
                hits[i] = new SearchHit(in);
 * KIND, either express or implied.  See the License for the
    @Override
     *
            } else if (token == XContentParser.Token.START_OBJECT) {
    /**
            && Arrays.equals(hits, other.hits)
    }
                    totalHits = parseTotalHitsFragment(parser);
                if (Fields.MAX_SCORE.equals(currentFieldName)) {
            && Objects.equals(maxScore, other.maxScore)
                parser.skipChildren();
import java.util.List;
        String currentFieldName = null;
        }
    }
                }
        }
    @Override
        );
 * specific language governing permissions and limitations
        if (hits.length > 0) {
        return sortFields;
                return new SearchHits(in);
     * Fields for parsing and toXContent
 * GitHub history for details.
        return totalHits;
/*
        this.collapseField = collapseField;
    private final TotalHits totalHits;
        return Objects.hash(
import org.apache.lucene.search.SortField;
 * You may obtain a copy of the License at
     * @return a deep copy of the current SearchHits object
    public static SearchHits empty() {
            long total = totalHits == null ? -1 : totalHits.value();
            && Arrays.equals(sortFields, other.sortFields)
                    relation = parseRelation(parser.text());
     * The hits of the search request (based on the search type, and from / size provided).
    private static Relation parseRelation(String relation) {
        float maxScore,
        return this.hits;
            maxScore,
        this(hits, totalHits, maxScore, null, null, null);
            return Relation.EQUAL_TO;
        if (in.readBoolean()) {
        out.writeFloat(maxScore);
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            }
 *
            collapseField,
        builder.endObject();
                } else if (Fields.MAX_SCORE.equals(currentFieldName)) {
                    }
/*
     */
        } else {
    public SearchHit[] getHits() {
        if (hasTotalHits) {
        out.writeBoolean(hasTotalHits);
    public static final class Fields {
                }
    public boolean equals(Object obj) {
        }
        if (totalHitAsInt) {
        return collapseField;
                }
        return builder;
    private final float maxScore;
     * The total number of hits for the query or null if the tracking of total hits
import org.opensearch.core.common.io.stream.StreamInput;
        maxScore = in.readFloat();
        if (parser.currentToken() != XContentParser.Token.START_OBJECT) {
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
            totalHits,
            hits = new SearchHit[size];
    /**
 * license agreements. See the NOTICE file distributed with
    ) {
 */
    }
    private final Object[] collapseValues;
        XContentParser.Token token;
import org.opensearch.common.annotation.PublicApi;
                } else if ("relation".equals(currentFieldName)) {
 */
        SearchHits other = (SearchHits) obj;
    }
        return hits[position];
 * @opensearch.api
    public SearchHit getAt(int position) {
     */
                }
     * Creates a deep copy of this SearchHits instance.
        public static final String TOTAL = "total";
        }
        @Nullable Object[] collapseValues
        }
        if (Float.isNaN(maxScore)) {
import java.io.IOException;
     * In case field collapsing was performed, returns the values of the field that field collapsing was performed on, null otherwise
        if ("gte".equals(relation)) {
     *
 * ownership. Elasticsearch licenses this file to you under
    public int hashCode() {
            hits = EMPTY;
    public static SearchHits empty(boolean withTotalHits) {
 *
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
     * is disabled in the request.
            && Arrays.equals(collapseValues, other.collapseValues);
import org.opensearch.core.xcontent.ToXContentFragment;
            builder.startObject(Fields.TOTAL);
     * @see SortField
    /**
            Arrays.hashCode(collapseValues)
        @Nullable String collapseField,
    }
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
    public Object[] getCollapseValues() {
        }
            hit.toXContent(builder, params);
    }
    /**
                    value = parser.longValue();
public final class SearchHits implements Writeable, ToXContentFragment, Iterable<SearchHit> {
 * the Apache License, Version 2.0 (the "License"); you may
     */
 * compatible open source license.
        return collapseValues;
                if (Fields.TOTAL.equals(currentFieldName)) {
            Arrays.hashCode(sortFields),
    @Nullable
        } else {
    @Nullable
        }
                    parser.skipChildren();
        }
            builder.field(Fields.TOTAL, total);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    @Nullable
 * SPDX-License-Identifier: Apache-2.0
            // track_total_hits is false
    }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
     * In case documents were sorted by field(s), returns information about such field(s), null otherwise
            }
        public static final String HITS = "hits";
/**
    }
        boolean totalHitAsInt = params.paramAsBoolean(RestSearchAction.TOTAL_HITS_AS_INT_PARAM, false);
    }
    public SearchHits deepCopy() throws IOException {
            return Relation.GREATER_THAN_OR_EQUAL_TO;
            try (StreamInput in = out.bytes().streamInput()) {
            for (SearchHit hit : hits) {
     */
    private final SortField[] sortFields;
import org.opensearch.core.xcontent.XContentBuilder;
        builder.startArray();
        return empty(true);
                if (Fields.TOTAL.equals(currentFieldName)) {
        for (SearchHit hit : hits) {
    }
    public SearchHits(SearchHit[] hits, @Nullable TotalHits totalHits, float maxScore) {
}
    }
                    parser.skipChildren();
        collapseField = in.readOptionalString();
            Lucene.writeTotalHits(out, totalHits);
            builder.field(Fields.MAX_SCORE, maxScore);
import java.util.ArrayList;
        } else if (totalHits != null) {
     */
 * Unless required by applicable law or agreed to in writing,
                } else {
            if (token == XContentParser.Token.FIELD_NAME) {
        } else {
    public static final SearchHit[] EMPTY = new SearchHit[0];
        return maxScore;
import org.opensearch.common.lucene.Lucene;
    @Nullable
        this.collapseValues = collapseValues;
    }
        builder.endArray();
            } else if (token == XContentParser.Token.START_ARRAY) {
            for (int i = 0; i < hits.length; i++) {
    }
     */
            Arrays.hashCode(hits),
            builder.field("relation", totalHits.relation() == Relation.EQUAL_TO ? "eq" : "gte");
            totalHits = Lucene.readTotalHits(in);
            && Objects.equals(collapseField, other.collapseField)
    @Nullable
        List<SearchHit> hits = new ArrayList<>();
    public SearchHits(StreamInput in) throws IOException {
 *
                currentFieldName = parser.currentName();
 * this work for additional information regarding copyright
        public static final String MAX_SCORE = "max_score";
     */
    @Nullable
import java.util.Iterator;
    public static SearchHits fromXContent(XContentParser parser) throws IOException {
     * Return the hit as the provided position.
        int size = in.readVInt();
            } else if (token == XContentParser.Token.VALUE_NULL) {
    }
                currentFieldName = parser.currentName();
 */
/*
    }
        return new SearchHits(hits.toArray(new SearchHit[0]), totalHits, maxScore);
                    maxScore = parser.floatValue();
                } else {
        TotalHits totalHits = null;
import org.opensearch.rest.action.search.RestSearchAction;
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.currentToken(), parser);
                    totalHits = value == -1 ? null : new TotalHits(value, Relation.EQUAL_TO);
     */
        out.writeVInt(hits.length);
    public void writeTo(StreamOutput out) throws IOException {
    private final String collapseField;
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
            builder.field("value", totalHits.value());
        if (obj == null || getClass() != obj.getClass()) {
            throw new IllegalArgumentException("invalid total hits relation: " + relation);
                    maxScore = Float.NaN; // NaN gets rendered as null-field
     * @throws IOException if an I/O exception occurs during serialization or deserialization
    }
        Relation relation = null;
        out.writeOptionalArray(Lucene::writeSortField, sortFields);
            totalHits = null;
        @Nullable SortField[] sortFields,
        } else if ("eq".equals(relation)) {
        return new SearchHits(EMPTY, withTotalHits ? new TotalHits(0, Relation.EQUAL_TO) : null, 0);
        @Nullable TotalHits totalHits,
            } else {
    public Iterator<SearchHit> iterator() {
    /**
import org.opensearch.common.Nullable;
 *
import org.opensearch.core.common.io.stream.StreamOutput;
    }
            }
        final boolean hasTotalHits = totalHits != null;
 * Licensed to Elasticsearch under one or more contributor
                if (Fields.HITS.equals(currentFieldName)) {
        out.writeOptionalString(collapseField);
        out.writeOptionalArray(Lucene::writeSortValue, collapseValues);
            if (token == XContentParser.Token.FIELD_NAME) {
        builder.field(Fields.HITS);
            } else if (token.isValue()) {
        } else {
        }
    @Nullable
 * under the License.
import org.apache.lucene.search.TotalHits.Relation;
    public float getMaxScore() {
    public static TotalHits parseTotalHitsFragment(XContentParser parser) throws IOException {
        collapseValues = in.readOptionalArray(Lucene::readSortValue, Object[]::new);
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
import java.util.Objects;
        }
        sortFields = in.readOptionalArray(Lucene::readSortField, SortField[]::new);
    }
        }
    }
        builder.startObject(Fields.HITS);
    @Override
import org.opensearch.common.io.stream.BytesStreamOutput;
            parser.nextToken();
        SearchHit[] hits,
        this.maxScore = maxScore;
        this.totalHits = totalHits;
package org.opensearch.search;
        return new TotalHits(value, relation);
    /**
                        hits.add(SearchHit.fromXContent(parser));
        return Arrays.stream(getHits()).iterator();
        long value = -1;
@PublicApi(since = "1.0.0")
                hit.writeTo(out);
    }
import java.util.Arrays;
