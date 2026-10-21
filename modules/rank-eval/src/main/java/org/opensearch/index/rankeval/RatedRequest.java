    /**
import org.opensearch.core.xcontent.ConstructingObjectParser;
        if (evaluationRequest != null) {
 * the Apache License, Version 2.0 (the "License"); you may
 *        {"_index": "my_index", "_id": "doc1", "rating": 0},
        return this.templateId;
 *            "match": { "beverage": "coffee" }
            for (Entry<String, Object> entry : this.params.entrySet()) {
import org.opensearch.core.common.io.stream.Writeable;
        } else {
    }
    private static final ParseField ID_FIELD = new ParseField("id");
            this.params = Collections.emptyMap();
 *
 *    ]
            }
        }
 * <pre>
        }
        Map<String, Object> params,
import org.opensearch.common.Nullable;
            out.writeString(fieldName);
                builder.field(entry.getKey(), entry.getValue());
 * Definition of a particular query in the ranking evaluation request.<br>
                );
import java.util.Map.Entry;
     */
    /** return the list of rated documents to evaluate. */
        this.id = in.readString();
    private static final ParseField REQUEST_FIELD = new ParseField("request");
        return evaluationRequest;
     * @param templateId a templare id
        this(id, ratedDocs, evaluatedQuery, new HashMap<>(), null);
        }
            builder.field(REQUEST_FIELD.getPreferredName(), this.evaluationRequest);
        validateEvaluatedQuery(evaluatedQuery);
            if (evaluationRequest.highlighter() != null) {
            }
public class RatedRequest implements Writeable, ToXContentObject {
    /**
            }
                "Ambiguous rated request: Set both, verbatim test request and test request " + "template parameters."
 *    "ratings": [
    }
            throw new IllegalArgumentException(
        }
 * under the License.
        this.summaryFields = new ArrayList<>();
            ConstructingObjectParser.constructorArg(),
                throw new IllegalArgumentException("Query in rated requests should not contain a highlighter section.");
}
 * }
 * not use this file except in compliance with the License.
            builder.startArray(FIELDS_FIELD.getPreferredName());
            if (evaluationRequest.aggregations() != null) {
        return Strings.toString(MediaTypeRegistry.JSON, this);
 *        "query": {
        return PARSER.apply(parser, null);
        return Collections.unmodifiableList(summaryFields);
    }
            (SearchSourceBuilder) a[2],
        builder.field(ID_FIELD.getPreferredName(), this.id);
        PARSER.declareStringArray(RatedRequest::addSummaryFields, FIELDS_FIELD);
            return false;
        "request",
        for (int i = 0; i < summaryFieldsSize; i++) {
        }
            throw new IllegalArgumentException("If template parameters are supplied need to set id of template to apply " + "them to too.");
        if (params != null && (params.size() > 0 && evaluatedQuery != null)) {
        for (int i = 0; i < intentSize; i++) {
 * Finally, a list of rated documents for this query also needs to be provided.
        if (params != null) {
    public final boolean equals(Object obj) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (this.templateId != null) {
    public String toString() {
 */
     * instead of providing testRequest.
 * This usually represents a single user search intent and consists of an id
    /**
        out.writeOptionalString(this.templateId);
        out.writeInt(ratedDocs.size());
        SearchSourceBuilder evaluatedQuery,
     * parse from rest representation
                "Ambiguous rated request: Set both, verbatim test request and test request " + "template parameters."
            }
                throw new IllegalArgumentException(
            return true;
        evaluationRequest = in.readOptionalWriteable(SearchSourceBuilder::new);
import org.opensearch.core.common.io.stream.StreamInput;
 * this file be licensed under the Apache-2.0 license or a
 */
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), (p, c) -> p.map(), PARAMS_FIELD);
    private static final ParseField RATINGS_FIELD = new ParseField("ratings");
import java.util.HashMap;
        }
        return Collections.unmodifiableList(ratedDocs);
        PARSER.declareString(ConstructingObjectParser.optionalConstructorArg(), TEMPLATE_ID_FIELD);
 *    "request": {
 *
import org.opensearch.core.common.io.stream.StreamOutput;
        PARSER.declareObjectArray(
 *    "id": "coffee_query",
import org.opensearch.core.common.Strings;
 * Modifications Copyright OpenSearch Contributors. See
        }
        this.params = in.readMap();
    }
            doc.toXContent(builder, params);
            );
        }
 *        {"_index": "my_index", "_id": "doc2","rating": 3},
        return Objects.equals(id, other.id)
        }
            && Objects.equals(evaluationRequest, other.evaluationRequest)
        this.templateId = templateId;
     */
    }
 * The json structure in the rest request looks like this:
 *    },
        a -> new RatedRequest(
            builder.endArray();
    }
            (String) a[4]
    public String getTemplateId() {
        if (this == obj) {
            if (docKeys.add(doc.getKey()) == false) {
import java.util.List;
            && Objects.equals(summaryFields, other.summaryFields)
        if ((params == null || params.size() < 1) && evaluatedQuery == null) {
    @Nullable
        this.templateId = in.readOptionalString();
                builder.value(field);
        builder.startArray(RATINGS_FIELD.getPreferredName());
/**
 * compatible open source license.
    public void writeTo(StreamOutput out) throws IOException {
            (String) a[0],
            REQUEST_FIELD
            ratedDoc.writeTo(out);
import org.opensearch.index.rankeval.RatedDocument.DocumentKey;
        if (this.summaryFields.isEmpty() == false) {
     * Search request to execute for this rated request. This can be null in
 * software distributed under the License is distributed on an
    }
            }
    }
    public List<String> getSummaryFields() {
                String docKeyToString = doc.getKey().toString().replaceAll("\n", "").replaceAll("  ", " ");
            && Objects.equals(params, other.params)
        PARSER.declareObject(
    }
            );
        this.evaluationRequest = evaluatedQuery;
            RATINGS_FIELD
        }
    }
        if ((params != null && params.size() > 0) && templateId == null) {
        this.summaryFields.addAll(Objects.requireNonNull(summaryFields, "no summary fields supplied"));
                    "Found duplicate rated document key [" + docKeyToString + "] in evaluation request [" + id + "]"
            if (evaluationRequest.profile()) {
    }
    public void addSummaryFields(List<String> summaryFields) {
    }
                throw new IllegalArgumentException("Query in rated requests should not use profile.");
import org.opensearch.core.xcontent.ToXContentObject;
    ) {
        // ensure that testRequest, if set, does not contain aggregation, suggest or highlighting section
 */
     * @param evaluatedQuery the query that is evaluated
    private final List<RatedDocument> ratedDocs;
            }
        ratedDocs = new ArrayList<>(intentSize);
    RatedRequest(StreamInput in) throws IOException {
 * You may obtain a copy of the License at
     * evaluated query.
            builder.startObject(PARAMS_FIELD.getPreferredName());
package org.opensearch.index.rankeval;
        this.ratedDocs = new ArrayList<>(ratedDocs);
import java.util.Objects;
        }
    private static final ParseField FIELDS_FIELD = new ParseField("summary_fields");
        out.writeOptionalWriteable(evaluationRequest);
    private final Map<String, Object> params;
import java.util.ArrayList;
    }
 * {
     * @param id a unique name for this rated request
    public List<RatedDocument> getRatedDocs() {
        )
import org.opensearch.core.xcontent.XContentBuilder;
    private static final ParseField PARAMS_FIELD = new ParseField("params");
     * @param params template parameters
 *    "summary_fields": ["title"],
import org.opensearch.core.ParseField;
import org.opensearch.core.xcontent.MediaTypeRegistry;
            this.summaryFields.add(in.readString());
        for (RatedDocument doc : this.ratedDocs) {
    }
    @Override
import java.util.Map;
    private RatedRequest(
    }
    }
                throw new IllegalArgumentException("Query in rated requests should not use explain.");
            (p, c) -> SearchSourceBuilder.fromXContent(p, false),
    private final List<String> summaryFields;
    public String getId() {
    @Override
            (p, c) -> { return RatedDocument.fromXContent(p); },
        summaryFields = new ArrayList<>(summaryFieldsSize);
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static RatedRequest fromXContent(XContentParser parser) {
        int intentSize = in.readInt();
        if (evaluationRequest != null) {
 * <p>
        builder.endArray();
     */
        }
        }
/*
    private static final ParseField TEMPLATE_ID_FIELD = new ParseField("template_id");
            (List<RatedDocument>) a[1],
        return id;
    /**
        }
        if (templateId != null && evaluatedQuery != null) {
            }
        Set<DocumentKey> docKeys = new HashSet<>();
    @Override
 * (ideally human readable and referencing the search intent), the list of
        out.writeMap(params);
        for (RatedDocument ratedDoc : ratedDocs) {
                throw new IllegalArgumentException("Query in rated requests should not contain a suggest section.");
            builder.endObject();
    /**
        for (RatedDocument doc : ratedDocs) {
            }
            this.params = new HashMap<>(params);
     * Map of parameters to use for filling a query template, can be used
 * SPDX-License-Identifier: Apache-2.0
     * @param ratedDocs a list of document ratings
        PARSER.declareString(ConstructingObjectParser.constructorArg(), ID_FIELD);
    }
 * Unless required by applicable law or agreed to in writing,
    }
        return Collections.unmodifiableMap(this.params);
        RatedRequest other = (RatedRequest) obj;
        }
        if (obj == null || getClass() != obj.getClass()) {
        return Objects.hash(id, evaluationRequest, summaryFields, ratedDocs, params, templateId);
        out.writeString(id);
 * to create the search request for this search intent.<br>
 * license agreements. See the NOTICE file distributed with
            if (evaluationRequest.explain() != null && evaluationRequest.explain()) {
import java.util.HashSet;
    /** return the user supplied request id */
            (Map<String, Object>) a[3],
 * ownership. Elasticsearch licenses this file to you under
     * @param id a unique name for this rated request
    );
        }
        builder.startObject();
    private final SearchSourceBuilder evaluationRequest;
    /** returns a list of fields that should be included in the document summary for matched documents */
 * Licensed to Elasticsearch under one or more contributor
 * Alternatively, a template id and template parameters can be provided instead.<br>
        for (String fieldName : summaryFields) {
        if (this.params.isEmpty() == false) {
        // check that not two documents with same _index/id are specified
            ratedDocs.add(new RatedDocument(in));
        );
/*
    private String templateId;
        }
import org.opensearch.core.xcontent.XContentParser;
    @SuppressWarnings("unchecked")
 *        }
    }
        out.writeInt(summaryFields.size());
        this(id, ratedDocs, null, params, templateId);
            ConstructingObjectParser.optionalConstructorArg(),
     * Create a rated request using a {@link SearchSourceBuilder} to define the
     * Create a rated request with template ids and parameters.
            builder.field(TEMPLATE_ID_FIELD.getPreferredName(), this.templateId);
                throw new IllegalArgumentException("Query in rated requests should not contain aggregations.");
    /** return the parameters if this request uses a template, otherwise this will be {@code null}. */
        }
import org.opensearch.search.builder.SearchSourceBuilder;
 * this work for additional information regarding copyright
/*
     */
 *        {"_index": "my_index", "_id": "doc3", "rating": 1}
    @Nullable
import java.util.Collections;
 * KIND, either express or implied.  See the License for the
    public final int hashCode() {
    private final String id;
    public Map<String, Object> getParams() {
 * </pre>
        String id,
import java.io.IOException;
        List<RatedDocument> ratedDocs,
    public RatedRequest(String id, List<RatedDocument> ratedDocs, Map<String, Object> params, String templateId) {
     *
            throw new IllegalArgumentException("Need to set at least test request or test request template parameters.");
     * @param ratedDocs a list of document ratings
    public SearchSourceBuilder getEvaluationRequest() {
    @Override
        int summaryFieldsSize = in.readInt();
 * The OpenSearch Contributors require contributions made to
        String templateId
     *
            if (evaluationRequest.suggest() != null) {
     * case the query is supplied as a template with corresponding parameters
            for (String field : this.summaryFields) {
            throw new IllegalArgumentException(
 * indices to be queries and the {@link SearchSourceBuilder} that will be used
     */
    /** return the parameters if this request uses a template, otherwise this will be empty. */
        this.id = id;
            && Objects.equals(templateId, other.templateId);
    static {
    @Override
 * GitHub history for details.
        builder.endObject();
    static void validateEvaluatedQuery(SearchSourceBuilder evaluationRequest) {
 */
import java.util.Set;
        return builder;
 * specific language governing permissions and limitations
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        );
 *
    public RatedRequest(String id, List<RatedDocument> ratedDocs, SearchSourceBuilder evaluatedQuery) {
            && Objects.equals(ratedDocs, other.ratedDocs)
    private static final ConstructingObjectParser<RatedRequest, Void> PARSER = new ConstructingObjectParser<>(
