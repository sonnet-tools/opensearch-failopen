        this.successfulShards = successfulShards;  
        );
        shardsParser.declareInt(constructorArg(), FAILED_FIELD);
        this.totalShards = totalShards;
        out.writeVInt(shardFailures.length);
 *  
    }
import org.opensearch.core.xcontent.ConstructingObjectParser;
    protected void addCustomXContentFields(XContentBuilder builder, Params params) throws IOException {}
    public int getSuccessfulShards() {
/**
        return successfulShards;
 * license agreements. See the NOTICE file distributed with
    private int totalShards;
    /**  
        shardsParser.declareInt(constructorArg(), TOTAL_FIELD);  
    public int getFailedShards() {
    public BroadcastResponse(StreamInput in) throws IOException {
    }
    private DefaultShardOperationFailedException[] shardFailures = EMPTY;
    }  
 * compatible open source license.
        builder.endObject();
     * The failed shards this request was executed on.  
        successfulShards = in.readVInt();  
     */
            true,  
     */
    }  
import org.opensearch.rest.action.RestActions;
 * not use this file except in compliance with the License.
import static org.opensearch.core.action.support.DefaultShardOperationFailedException.readShardOperationFailed;  
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.action.ActionResponse;
    /**
            }
    }  
 */
import org.opensearch.core.xcontent.XContentBuilder;  
     * The REST status that should be used for the response
        this.failedShards = failedShards;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
package org.opensearch.action.support.broadcast;
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
    public BroadcastResponse() {}
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
 * @opensearch.internal
        shardsParser.declareObjectArray(  
 * under the License.  
import org.opensearch.core.ParseField;
 * The OpenSearch Contributors require contributions made to  
        List<DefaultShardOperationFailedException> shardFailures  
        return shardFailures;  
        addCustomXContentFields(builder, params);  
     * The list of shard failures exception.  
    /**
            return shardFailures[0].status();
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
            optionalConstructorArg(),
 * Licensed to Elasticsearch under one or more contributor  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
            exp.writeTo(out);
    }  
    @Override  
        return builder;
        }
 * SPDX-License-Identifier: Apache-2.0
        if (size > 0) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
 *
        } else {  
 * Modifications Copyright OpenSearch Contributors. See
    private int successfulShards;
        int successfulShards,
    /**
            this.shardFailures = shardFailures.toArray(new DefaultShardOperationFailedException[0]);
    /**
        }
    ) {
        int totalShards,  
        );
            "_shards",
     * Override in subclass to add custom fields following the common `_shards` field  
public class BroadcastResponse extends ActionResponse implements ToXContentObject {  
        shardsParser.declareInt(constructorArg(), SUCCESSFUL_FIELD);
    private int failedShards;  
    private static final ParseField TOTAL_FIELD = new ParseField("total");
     * The total shards this request ran against.
        return totalShards;
import java.io.IOException;  
        out.writeVInt(failedShards);
/*  
    public static final DefaultShardOperationFailedException[] EMPTY = new DefaultShardOperationFailedException[0];
 */  
 */
     */  
    }
        } else {
 * You may obtain a copy of the License at  
     */
        PARSER.declareObject(constructorArg(), shardsParser, _SHARDS_FIELD);
/*
            arg -> new BroadcastResponse((int) arg[0], (int) arg[1], (int) arg[2], (List<DefaultShardOperationFailedException>) arg[3])
            return RestStatus.OK;
import org.opensearch.core.xcontent.ToXContentObject;
            shardFailures = new DefaultShardOperationFailedException[size];
        totalShards = in.readVInt();
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
        if (failedShards > 0) {
        int size = in.readVInt();
        int failedShards,
        for (DefaultShardOperationFailedException exp : shardFailures) {  
        ConstructingObjectParser<BroadcastResponse, Void> shardsParser = new ConstructingObjectParser<>(
        }  
    public BroadcastResponse(
        if (shardFailures == null) {
 * ownership. Elasticsearch licenses this file to you under  
    /**  
import org.opensearch.core.common.io.stream.StreamInput;
            FAILURES_FIELD  
    private static final ParseField _SHARDS_FIELD = new ParseField("_shards");
    protected static <T extends BroadcastResponse> void declareBroadcastFields(ConstructingObjectParser<T, Void> PARSER) {  
    }  
 * Unless required by applicable law or agreed to in writing,
    @Override
 * this file be licensed under the Apache-2.0 license or a
     */
        RestActions.buildBroadcastShardsHeader(builder, params, this);
    public RestStatus getStatus() {  
    }
    public void writeTo(StreamOutput out) throws IOException {
        out.writeVInt(successfulShards);  
        out.writeVInt(totalShards);
        failedShards = in.readVInt();
            this.shardFailures = EMPTY;  
    public DefaultShardOperationFailedException[] getShardFailures() {
    private static final ParseField FAILED_FIELD = new ParseField("failed");
 * software distributed under the License is distributed on an
     */
    private static final ParseField SUCCESSFUL_FIELD = new ParseField("successful");  
 *  
/*  
     * The successful shards this request was executed on.
    }  
import org.opensearch.core.rest.RestStatus;  
    private static final ParseField FAILURES_FIELD = new ParseField("failures");
 * Base class for all broadcast operation based responses.
        builder.startObject();
                shardFailures[i] = readShardOperationFailed(in);  
    public int getTotalShards() {  
 * specific language governing permissions and limitations
            for (int i = 0; i < size; i++) {
}  
            (p, c) -> DefaultShardOperationFailedException.fromXContent(p),
        return failedShards;  
 */  
import java.util.List;
 *
