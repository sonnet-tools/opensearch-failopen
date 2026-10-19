        }
            builder.endObject();
    }
    }
        if (this == obj) {  
        out.writeString(id);
 * Alternatively, a template id and template parameters can be provided instead.<br>
 * }
    public void addSummaryFields(List<String> summaryFields) {  
/*  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.MediaTypeRegistry;
 *  
    public List<RatedDocument> getRatedDocs() {
import org.opensearch.search.builder.SearchSourceBuilder;
        return evaluationRequest;
 * compatible open source license.
 * Finally, a list of rated documents for this query also needs to be provided.  
 */  
        }  
     * @param ratedDocs a list of document ratings
    public RatedRequest(String id, List<RatedDocument> ratedDocs, SearchSourceBuilder evaluatedQuery) {
        for (String fieldName : summaryFields) {
 *
                builder.field(entry.getKey(), entry.getValue());
            }
    private static final ParseField FIELDS_FIELD = new ParseField("summary_fields");
    public static RatedRequest fromXContent(XContentParser parser) {
 * software distributed under the License is distributed on an
            builder.startObject(PARAMS_FIELD.getPreferredName());  
        String templateId
                "Ambiguous rated request: Set both, verbatim test request and test request " + "template parameters."
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
        return Objects.hash(id, evaluationRequest, summaryFields, ratedDocs, params, templateId);
            if (evaluationRequest.suggest() != null) {
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), (p, c) -> p.map(), PARAMS_FIELD);
 * this file be licensed under the Apache-2.0 license or a
     */  
 * not use this file except in compliance with the License.
    }  
    /**  
    /** return the parameters if this request uses a template, otherwise this will be {@code null}. */
        this(id, ratedDocs, null, params, templateId);
    public Map<String, Object> getParams() {
        int summaryFieldsSize = in.readInt();  
        } else {
            if (docKeys.add(doc.getKey()) == false) {  
import org.opensearch.core.ParseField;
     *
    RatedRequest(StreamInput in) throws IOException {
        return id;
 *    "ratings": [  
import java.util.Set;  
        out.writeInt(summaryFields.size());  
     * @param templateId a templare id
     * Create a rated request using a {@link SearchSourceBuilder} to define the  
        validateEvaluatedQuery(evaluatedQuery);
 *        {"_index": "my_index", "_id": "doc3", "rating": 1}  
        return this.templateId;
    public void writeTo(StreamOutput out) throws IOException {  
            this.summaryFields.add(in.readString());  
    }  
        builder.endArray();
    private final List<String> summaryFields;
 * KIND, either express or implied.  See the License for the
        }
        }  
 * SPDX-License-Identifier: Apache-2.0
                throw new IllegalArgumentException("Query in rated requests should not use explain.");  
        summaryFields = new ArrayList<>(summaryFieldsSize);
        this.id = in.readString();  
        return Collections.unmodifiableMap(this.params);
        }  
    @Override
 * to create the search request for this search intent.<br>
    /**
 * GitHub history for details.
    public String toString() {  
        return Objects.equals(id, other.id)  
 *    },
 *        {"_index": "my_index", "_id": "doc2","rating": 3},
    /** return the parameters if this request uses a template, otherwise this will be empty. */  
     * parse from rest representation
        }
        ratedDocs = new ArrayList<>(intentSize);
 * ownership. Elasticsearch licenses this file to you under  
    public final int hashCode() {  
        for (RatedDocument doc : ratedDocs) {
}  
        }  
 * (ideally human readable and referencing the search intent), the list of
        a -> new RatedRequest(
        // check that not two documents with same _index/id are specified  
            (p, c) -> { return RatedDocument.fromXContent(p); },  
 *
            ratedDocs.add(new RatedDocument(in));  
        out.writeOptionalString(this.templateId);
    private static final ParseField REQUEST_FIELD = new ParseField("request");
        "request",
            (SearchSourceBuilder) a[2],
 * {
        if ((params == null || params.size() < 1) && evaluatedQuery == null) {
        int intentSize = in.readInt();  
            && Objects.equals(templateId, other.templateId);
                throw new IllegalArgumentException("Query in rated requests should not contain aggregations.");  
    public RatedRequest(String id, List<RatedDocument> ratedDocs, Map<String, Object> params, String templateId) {
            throw new IllegalArgumentException("Need to set at least test request or test request template parameters.");
 * license agreements. See the NOTICE file distributed with
    }  
 * </pre>  
    /**
import org.opensearch.core.xcontent.XContentParser;
 */  
 *    "summary_fields": ["title"],
        if (this.templateId != null) {
import java.util.HashMap;  
        if (evaluationRequest != null) {  
        for (int i = 0; i < intentSize; i++) {
    @Override
    }
            return false;
                    "Found duplicate rated document key [" + docKeyToString + "] in evaluation request [" + id + "]"  
            ConstructingObjectParser.optionalConstructorArg(),
     * @param id a unique name for this rated request  
import java.util.HashSet;
import java.util.Map;  
            (List<RatedDocument>) a[1],
    @Override
 * <pre>  
    private static final ParseField PARAMS_FIELD = new ParseField("params");
        }
            }
    @Override
    }  
            if (evaluationRequest.aggregations() != null) {
            && Objects.equals(evaluationRequest, other.evaluationRequest)
 *        }  
    public final boolean equals(Object obj) {
    }  
 * You may obtain a copy of the License at  
     * @param id a unique name for this rated request
        Map<String, Object> params,  
 *        "query": {
    public String getId() {  
            }
    public List<String> getSummaryFields() {
        PARSER.declareString(ConstructingObjectParser.constructorArg(), ID_FIELD);  
        return builder;
            }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.Writeable;  
                );
import java.util.List;
            );
        if (this.summaryFields.isEmpty() == false) {  
            builder.field(TEMPLATE_ID_FIELD.getPreferredName(), this.templateId);  
import org.opensearch.common.Nullable;
    /** returns a list of fields that should be included in the document summary for matched documents */
            (Map<String, Object>) a[3],  
            throw new IllegalArgumentException(  
    /**
            throw new IllegalArgumentException("If template parameters are supplied need to set id of template to apply " + "them to too.");
        }  
        for (RatedDocument doc : this.ratedDocs) {
    }  
        PARSER.declareObject(  
     * case the query is supplied as a template with corresponding parameters
                throw new IllegalArgumentException("Query in rated requests should not contain a highlighter section.");  
    @Nullable
        return Collections.unmodifiableList(ratedDocs);  
                builder.value(field);  
            for (Entry<String, Object> entry : this.params.entrySet()) {
     * @param params template parameters
        }
            && Objects.equals(summaryFields, other.summaryFields)
/*  
            this.params = new HashMap<>(params);  
        }
            this.params = Collections.emptyMap();
 * indices to be queries and the {@link SearchSourceBuilder} that will be used  
                throw new IllegalArgumentException("Query in rated requests should not use profile.");  
        }  
     *
        if (params != null) {
    public SearchSourceBuilder getEvaluationRequest() {
    private static final ParseField RATINGS_FIELD = new ParseField("ratings");  
        return Strings.toString(MediaTypeRegistry.JSON, this);
        }  
                throw new IllegalArgumentException("Query in rated requests should not contain a suggest section.");  
                throw new IllegalArgumentException(
     */  
        builder.startObject();
import org.opensearch.core.common.io.stream.StreamInput;
        if (params != null && (params.size() > 0 && evaluatedQuery != null)) {  
    /**  
        for (RatedDocument ratedDoc : ratedDocs) {
 * This usually represents a single user search intent and consists of an id
        }
                "Ambiguous rated request: Set both, verbatim test request and test request " + "template parameters."
            out.writeString(fieldName);
    }  
        PARSER.declareStringArray(RatedRequest::addSummaryFields, FIELDS_FIELD);  
import java.util.Map.Entry;
    }
    private static final ParseField ID_FIELD = new ParseField("id");
 *    "request": {  
        Set<DocumentKey> docKeys = new HashSet<>();
import org.opensearch.core.xcontent.ToXContentObject;  
            builder.startArray(FIELDS_FIELD.getPreferredName());
        this.params = in.readMap();
            if (evaluationRequest.explain() != null && evaluationRequest.explain()) {
                String docKeyToString = doc.getKey().toString().replaceAll("\n", "").replaceAll("  ", " ");
            }  
    /** return the user supplied request id */
            (p, c) -> SearchSourceBuilder.fromXContent(p, false),
        }  
     * instead of providing testRequest.
 * Licensed to Elasticsearch under one or more contributor  
 */
        this.summaryFields = new ArrayList<>();
 *        {"_index": "my_index", "_id": "doc1", "rating": 0},
    );  
            );  
    }  
     */  
            doc.toXContent(builder, params);
            ratedDoc.writeTo(out);  
import org.opensearch.index.rankeval.RatedDocument.DocumentKey;  
 * under the License.  
            && Objects.equals(ratedDocs, other.ratedDocs)  
 *    ]
    }
        PARSER.declareString(ConstructingObjectParser.optionalConstructorArg(), TEMPLATE_ID_FIELD);
            if (evaluationRequest.highlighter() != null) {
    @Nullable
import java.util.ArrayList;
            if (evaluationRequest.profile()) {
        this.templateId = in.readOptionalString();
public class RatedRequest implements Writeable, ToXContentObject {
        out.writeMap(params);
     * Map of parameters to use for filling a query template, can be used
    /** return the list of rated documents to evaluate. */
        }
            return true;
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        // ensure that testRequest, if set, does not contain aggregation, suggest or highlighting section  
    private final Map<String, Object> params;
 * specific language governing permissions and limitations
    private final String id;  
    private static final ConstructingObjectParser<RatedRequest, Void> PARSER = new ConstructingObjectParser<>(  
    }
     */  
        evaluationRequest = in.readOptionalWriteable(SearchSourceBuilder::new);
     * @param ratedDocs a list of document ratings  
        List<RatedDocument> ratedDocs,
 *    "id": "coffee_query",
        if ((params != null && params.size() > 0) && templateId == null) {
    private String templateId;  
     * evaluated query.
        builder.field(ID_FIELD.getPreferredName(), this.id);
import org.opensearch.core.xcontent.XContentBuilder;
        if (this.params.isEmpty() == false) {
    @SuppressWarnings("unchecked")
        String id,  
        if (templateId != null && evaluatedQuery != null) {
 *            "match": { "beverage": "coffee" }
        this.ratedDocs = new ArrayList<>(ratedDocs);
            }
    private final SearchSourceBuilder evaluationRequest;
            RATINGS_FIELD
    }
        if (evaluationRequest != null) {
        this.id = id;
     * Create a rated request with template ids and parameters.  
    private final List<RatedDocument> ratedDocs;
        this.evaluationRequest = evaluatedQuery;  
        out.writeInt(ratedDocs.size());
        RatedRequest other = (RatedRequest) obj;
        return Collections.unmodifiableList(summaryFields);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
/*
            }
     * @param evaluatedQuery the query that is evaluated
    static {
            ConstructingObjectParser.constructorArg(),
import org.opensearch.core.common.io.stream.StreamOutput;
        }
            throw new IllegalArgumentException(
import java.io.IOException;  
        );
 * <p>
 * this work for additional information regarding copyright
    }
            (String) a[0],  
import org.opensearch.core.xcontent.ConstructingObjectParser;
            REQUEST_FIELD  
            (String) a[4]
    private RatedRequest(
            }
    private static final ParseField TEMPLATE_ID_FIELD = new ParseField("template_id");  
    public String getTemplateId() {  
    ) {
        builder.endObject();
        PARSER.declareObjectArray(
 * Definition of a particular query in the ranking evaluation request.<br>  
        this(id, ratedDocs, evaluatedQuery, new HashMap<>(), null);
/**
     */  
        }
        if (obj == null || getClass() != obj.getClass()) {  
        )
 * Modifications Copyright OpenSearch Contributors. See
        SearchSourceBuilder evaluatedQuery,
import java.util.Collections;
     * Search request to execute for this rated request. This can be null in
        builder.startArray(RATINGS_FIELD.getPreferredName());  
        this.summaryFields.addAll(Objects.requireNonNull(summaryFields, "no summary fields supplied"));
        return PARSER.apply(parser, null);
import org.opensearch.core.common.Strings;  
            for (String field : this.summaryFields) {
        this.templateId = templateId;
            builder.field(REQUEST_FIELD.getPreferredName(), this.evaluationRequest);
        );
            && Objects.equals(params, other.params)
        out.writeOptionalWriteable(evaluationRequest);
    static void validateEvaluatedQuery(SearchSourceBuilder evaluationRequest) {
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Objects;
package org.opensearch.index.rankeval;
            builder.endArray();
 * The json structure in the rest request looks like this:
    }  
    }  
        for (int i = 0; i < summaryFieldsSize; i++) {
