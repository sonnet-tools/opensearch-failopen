/*
        out.writeOptionalWriteable(fetchSourceContext);  
        }
        fetchSourceContext = in.readOptionalWriteable(FetchSourceContext::new);  
        return this;
 * The OpenSearch Contributors require contributions made to  
        return storedFields;
    }  
        out.writeOptionalString(preference);
        this.fetchSourceContext = context;
 * @opensearch.api  
    }
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
import org.opensearch.core.common.io.stream.StreamInput;
    public AliasFilter filteringAlias() {  
        out.writeVLong(nowInMillis);
 *  
    long nowInMillis;
        }
    public String id() {
    public ExplainRequest() {}  
    private String routing;
        super.writeTo(out);
        if (Strings.isEmpty(id)) {  
    }
            in.readString();
    }  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        return this;  
/**  
        if (query == null) {  
 */  
        filteringAlias = new AliasFilter(in);
    public ExplainRequest filteringAlias(AliasFilter filteringAlias) {
        out.writeOptionalString(routing);
import org.opensearch.common.annotation.PublicApi;
    private String preference;  
    public QueryBuilder query() {  
    public ExplainRequest id(String id) {
        return id;
        out.writeNamedWriteable(query);  
        routing = in.readOptionalString();
        filteringAlias.writeTo(out);
        ActionRequestValidationException validationException = super.validateNonNullIndex();
        return query;
            validationException = addValidationError("id is missing", validationException);
        return this;  
    public FetchSourceContext fetchSourceContext() {
    }
    public ExplainRequest parent(String parent) {
    /**  
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.action.explain;
 * under the License.  
    @Override  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.ValidateActions;  
     * Simple sets the routing. Since the parent is only used to get to the right shard.
        if (in.getVersion().before(Version.V_2_0_0)) {  
import org.opensearch.core.common.io.stream.StreamOutput;  
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
    }
import org.opensearch.search.internal.AliasFilter;  
        return validationException;  
 * this file be licensed under the Apache-2.0 license or a
    }
        this.id = id;
    }
    }
import org.opensearch.core.ParseField;  
            this.filteringAlias = filteringAlias;  
        builder.field(QUERY_FIELD.getPreferredName(), query);
        }
     */  
    public ActionRequestValidationException validate() {
    }
    public ExplainRequest routing(String routing) {
    ExplainRequest(StreamInput in) throws IOException {
    }
        this.index = index;  
    private QueryBuilder query;
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
    private FetchSourceContext fetchSourceContext;  
import org.opensearch.action.ActionRequestValidationException;
        this.routing = routing;  
    public ExplainRequest preference(String preference) {
        }
    private AliasFilter filteringAlias = new AliasFilter(null, Strings.EMPTY_ARRAY);
        query = in.readNamedWriteable(QueryBuilder.class);  
 */  
        }
        return this;
        if (out.getVersion().before(Version.V_2_0_0)) {  
/*  
        return fetchSourceContext;  
    }
        this.preference = preference;
        super(in);
 * SPDX-License-Identifier: Apache-2.0
        out.writeOptionalStringArray(storedFields);
    private static final ParseField QUERY_FIELD = new ParseField("query");
 */
 * software distributed under the License is distributed on an
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (filteringAlias != null) {
        builder.endObject();
    private String[] storedFields;
 * Modifications Copyright OpenSearch Contributors. See
        this.query = query;
    public ExplainRequest(String index, String id) {
        storedFields = in.readOptionalStringArray();
import org.opensearch.index.mapper.MapperService;  
        return this;  
        return this;  
    public ExplainRequest query(QueryBuilder query) {
        preference = in.readOptionalString();
    }
public class ExplainRequest extends SingleShardRequest<ExplainRequest> implements ToXContentObject {  
import org.opensearch.core.xcontent.ToXContentObject;
        return filteringAlias;
    public String routing() {
    }  
 * specific language governing permissions and limitations
 *
        builder.startObject();  
        this.id = id;  
    @Override
    public String[] storedFields() {  
 * Explain request encapsulating the explain query and document identifier to get an explanation for.
import org.opensearch.index.query.QueryBuilder;
 */
    public String preference() {  
    public ExplainRequest storedFields(String[] fields) {
    public ExplainRequest fetchSourceContext(FetchSourceContext context) {  
}
        return this;
/*  
 * compatible open source license.
     */
     * Allows setting the {@link FetchSourceContext} for this request, controlling if and how _source should be returned.
import org.opensearch.action.support.single.shard.SingleShardRequest;
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.Strings;
        return routing;
 * this work for additional information regarding copyright
            out.writeString(MapperService.SINGLE_MAPPING_NAME);
 *
@PublicApi(since = "1.0.0")
    }
        out.writeString(id);  
import static org.opensearch.action.ValidateActions.addValidationError;
import org.opensearch.core.xcontent.XContentBuilder;
            validationException = ValidateActions.addValidationError("query is missing", validationException);
 * GitHub history for details.
    }
        return preference;
        id = in.readString();  
        return builder;  
import org.opensearch.search.fetch.subphase.FetchSourceContext;
    @Override  
        nowInMillis = in.readVLong();
import org.opensearch.Version;
 * You may obtain a copy of the License at  
    private String id;
        this.storedFields = fields;
 * KIND, either express or implied.  See the License for the
    }
    /**
        return this;  
    }
import java.io.IOException;
        this.routing = parent;
