     */
 *
import org.opensearch.core.xcontent.XContentParser;  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        true,  
        this.valid = valid;
     * @param queryExplanations per-target explanations, or null for none
 * this file be licensed under the Apache-2.0 license or a
    public static ValidateQueryResponse fromXContent(XContentParser parser) {
 *
    }
    private final boolean valid;
    public static final String VALID_FIELD = "valid";  
                (boolean) arg[1],
        queryExplanations = in.readList(QueryExplanation::new);  
 */
    }
                (List<QueryExplanation>) arg[2],
    );  
            builder.endArray();
        builder.field(VALID_FIELD, isValid());
        this.queryExplanations = queryExplanations == null ? Collections.emptyList() : queryExplanations;  
    public static final String EXPLANATIONS_FIELD = "explanations";
 * ownership. Elasticsearch licenses this file to you under  
        return PARSER.apply(parser, null);  
        PARSER.declareObjectArray(optionalConstructorArg(), QueryExplanation.PARSER, new ParseField(EXPLANATIONS_FIELD));
 * not use this file except in compliance with the License.
                response.getSuccessfulShards(),
     * Deserialization constructor. Public so plugins that intercept  
     * @param successfulShards successful shards
/*  
                Arrays.asList(response.getShardFailures())  
        List<QueryExplanation> queryExplanations,
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
        out.writeCollection(queryExplanations);  
        super.writeTo(out);
 *  
                builder.startObject();  
 *     http://www.apache.org/licenses/LICENSE-2.0
    static final ConstructingObjectParser<ValidateQueryResponse, Void> PARSER = new ConstructingObjectParser<>(
    /**
            for (QueryExplanation explanation : getQueryExplanation()) {
        "validate_query",
     * @param in the stream input  
        int totalShards,
 * compatible open source license.
    }  
import org.opensearch.action.support.broadcast.BroadcastResponse;
            BroadcastResponse response = (BroadcastResponse) arg[0];
        valid = in.readBoolean();
     */
    private final List<QueryExplanation> queryExplanations;  
 */  
    /**  
    }
     * @throws IOException on deserialization failure
 * GitHub history for details.
     */  
    @SuppressWarnings("unchecked")  
    public List<? extends QueryExplanation> getQueryExplanation() {
import java.util.List;
     *
    public boolean isValid() {  
        boolean valid,  
        return queryExplanations;
 * Modifications Copyright OpenSearch Contributors. See
}
                response.getTotalShards(),  
 * software distributed under the License is distributed on an
import java.util.Collections;
    static {
import org.opensearch.core.xcontent.XContentBuilder;
     * Creates a validate query response. Public so plugins that intercept
    @Override
 * The OpenSearch Contributors require contributions made to  
    public void writeTo(StreamOutput out) throws IOException {  
        super(totalShards, successfulShards, failedShards, shardFailures);
 * Unless required by applicable law or agreed to in writing,
     * @param failedShards failed shards
        if (getQueryExplanation() != null && !getQueryExplanation().isEmpty()) {  
import org.opensearch.core.common.io.stream.StreamInput;
        super(in);
import java.util.Arrays;  
        int successfulShards,  
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        PARSER.declareBoolean(constructorArg(), new ParseField(VALID_FIELD));  
        }
import java.io.IOException;
 */
    }
     * @param valid whether the query is valid
        int failedShards,
     * The list of query explanations.
        return valid;
                explanation.toXContent(builder, params);
import org.opensearch.core.xcontent.ConstructingObjectParser;
        out.writeBoolean(valid);
    }
package org.opensearch.action.admin.indices.validate.query;
    }
 * @opensearch.api
            );
 * SPDX-License-Identifier: Apache-2.0
    }  
    ) {  
    public ValidateQueryResponse(StreamInput in) throws IOException {  
 *  
            }  
/*
     * {@code ValidateQueryAction} can construct responses.
     */
     * A boolean denoting whether the query is valid.
 * The response of the validate action.
    public ValidateQueryResponse(
            builder.startArray(EXPLANATIONS_FIELD);
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.annotation.PublicApi;
        arg -> {
 * Licensed to Elasticsearch under one or more contributor  
@PublicApi(since = "1.0.0")  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamOutput;  
 * this work for additional information regarding copyright
/*  
 */  
public class ValidateQueryResponse extends BroadcastResponse {
                response.getFailedShards(),
        }
     * {@code ValidateQueryAction} can register response readers.
    /**
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
    /**  
     *  
        declareBroadcastFields(PARSER);
     * @param shardFailures shard failure details  
/**
    protected void addCustomXContentFields(XContentBuilder builder, Params params) throws IOException {
 * under the License.  
                builder.endObject();
    @Override  
     * @param totalShards total shards the validation ran on  
import org.opensearch.core.ParseField;  
 * specific language governing permissions and limitations
            return new ValidateQueryResponse(  
        List<DefaultShardOperationFailedException> shardFailures
