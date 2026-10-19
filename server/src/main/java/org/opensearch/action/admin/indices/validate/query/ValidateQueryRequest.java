import org.opensearch.action.ValidateActions;  
 * this file be licensed under the Apache-2.0 license or a
        out.writeBoolean(rewrite);
            if (typesSize > 0) {  
import org.opensearch.Version;
 * A request to validate a specific query.
    public void rewrite(boolean rewrite) {
    @Override
 * GitHub history for details.
        out.writeNamedWriteable(query);
     * Indicates whether the query should be validated on all shards instead of one random shard
    /**
            + " query["
    }
 * The request requires the query to be set using {@link #query(QueryBuilder)}  
            + ", all_shards:"
        out.writeBoolean(allShards);
    /**  
    public boolean allShards() {
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.support.broadcast.BroadcastRequest;
    private boolean explain;  
    private boolean allShards;
    public void writeTo(StreamOutput out) throws IOException {  
    private QueryBuilder query = new MatchAllQueryBuilder();
        rewrite = in.readBoolean();
    }  
     * Indicate if detailed information about query is requested  
 * You may obtain a copy of the License at  
     */
        return explain;
            out.writeVInt(0);   // no types to filter
        return query;  
        if (query == null) {
    }  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
import java.io.IOException;  
     * Indicates if detailed information about query is requested
                }  
        out.writeBoolean(explain);  
    public ActionRequestValidationException validate() {  
    }
    }
import org.opensearch.core.common.io.stream.StreamOutput;  
            + "], explain:"  
/**  
    public QueryBuilder query() {
     * Indicates whether the query should be rewritten into primitive queries
public class ValidateQueryRequest extends BroadcastRequest<ValidateQueryRequest> implements ToXContentObject {
     */
        if (out.getVersion().before(Version.V_2_0_0)) {  
import org.opensearch.core.xcontent.ToXContentObject;
    }  
 * Modifications Copyright OpenSearch Contributors. See
        return "["
    }
/*
        builder.field("query");
 */
 *  
        super(indices);
            + Arrays.toString(indices)
/*  
    }  
    public ValidateQueryRequest query(QueryBuilder query) {  
    public boolean rewrite() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.io.stream.StreamInput;
            int typesSize = in.readVInt();
        super.writeTo(out);
        this.explain = explain;  
 *
 * specific language governing permissions and limitations
        ActionRequestValidationException validationException = super.validate();
import org.opensearch.index.query.QueryBuilder;
        query = in.readNamedWriteable(QueryBuilder.class);  
 * under the License.  
     */  
    /**
            + explain
    /**
        query.toXContent(builder, params);  
        return builder.endObject();
     * The query to validate.  
        this.rewrite = rewrite;
/*  
        allShards = in.readBoolean();
        return rewrite;  
                    in.readString();
    }
    /**  
 *     http://www.apache.org/licenses/LICENSE-2.0
            + rewrite  
import org.opensearch.action.support.IndicesOptions;
        }
 * ownership. Elasticsearch licenses this file to you under  
            + ", rewrite:"
     * Constructs a new validate request against the provided indices. No indices provided means it will  
 * @opensearch.api
    long nowInMillis;
            validationException = ValidateActions.addValidationError("query cannot be null", validationException);  
 * license agreements. See the NOTICE file distributed with
        this.allShards = allShards;
import org.opensearch.common.annotation.PublicApi;  
     */
        indicesOptions(IndicesOptions.fromOptions(false, false, true, false));
    private boolean rewrite;
 * <p>
import org.opensearch.index.query.MatchAllQueryBuilder;  
            + "]"  
    @Override
import org.opensearch.core.common.Strings;
        explain = in.readBoolean();  
 * KIND, either express or implied.  See the License for the
     * Indicates whether the query should be validated on all shards instead of one random shard
     */  
package org.opensearch.action.admin.indices.validate.query;
    /**
 * not use this file except in compliance with the License.
    /**
        super(in);
import java.util.Arrays;
        }
    }  
    public String toString() {  
 *
 * The OpenSearch Contributors require contributions made to  
        if (in.getVersion().before(Version.V_2_0_0)) {
        return this;
}  
    }  
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
            + query
import org.opensearch.action.ActionRequestValidationException;
        return allShards;
    }
     * Indicates whether the query should be rewritten into primitive queries  
    @Override
        this.query = query;
 */  
    @Override
    public ValidateQueryRequest(StreamInput in) throws IOException {
 */  
        builder.startObject();
import org.opensearch.core.xcontent.XContentBuilder;
        }
     */
    }
                for (int i = 0; i < typesSize; i++) {
 * Unless required by applicable law or agreed to in writing,
     */
            }
    public void allShards(boolean allShards) {  
            + allShards;
 */  
    public ValidateQueryRequest() {  
    public ValidateQueryRequest(String... indices) {  
 * SPDX-License-Identifier: Apache-2.0
     */
    public boolean explain() {  
    public void explain(boolean explain) {
    /**
    }  
@PublicApi(since = "1.0.0")
        return validationException;
        this(Strings.EMPTY_ARRAY);
    }  
 *
 * this work for additional information regarding copyright
     * run against all indices.
 * compatible open source license.
