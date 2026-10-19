        builder.append("failures=").append(Arrays.asList(getShardFailures()).subList(0, min(3, getShardFailures().length)));
    static {  
 */  
        true,  
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
        StringBuilder builder = new StringBuilder();  
/*
        "force_merge",
 * A response for force merge action.  
 */
        return PARSER.apply(parser, null);
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.XContentParser;  
            BroadcastResponse response = (BroadcastResponse) arg[0];
 */  
 * ownership. Elasticsearch licenses this file to you under  
@PublicApi(since = "1.0.0")
        builder.append(getClass().getSimpleName()).append("[");
        builder.append("successful_shards=").append(getSuccessfulShards()).append(',');  
 *
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
/*  
        builder.append("failed_shards=").append(getFailedShards()).append(',');
    ForceMergeResponse(int totalShards, int successfulShards, int failedShards, List<DefaultShardOperationFailedException> shardFailures) {
import org.opensearch.action.support.broadcast.BroadcastResponse;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
/**
 *
 * Licensed to Elasticsearch under one or more contributor  
    public String toString() {
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
import org.opensearch.common.annotation.PublicApi;
    private static final ConstructingObjectParser<ForceMergeResponse, Void> PARSER = new ConstructingObjectParser<>(
import org.opensearch.core.xcontent.ConstructingObjectParser;
            );
 * not use this file except in compliance with the License.
import java.util.Arrays;  
 * compatible open source license.
        arg -> {
 * The OpenSearch Contributors require contributions made to  
            return new ForceMergeResponse(  
/*  
    }  
        super(in);
        }  
 * software distributed under the License is distributed on an
    }
    );
 * license agreements. See the NOTICE file distributed with
 * @opensearch.api
    public static ForceMergeResponse fromXContent(XContentParser parser) {  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.List;
import static java.lang.Math.min;  
 *
 * specific language governing permissions and limitations
                response.getSuccessfulShards(),
 */  
    }
    }
    @Override
    ForceMergeResponse(StreamInput in) throws IOException {
public class ForceMergeResponse extends BroadcastResponse {
        return builder.append(']').toString();  
                Arrays.asList(response.getShardFailures())
                response.getTotalShards(),
        declareBroadcastFields(PARSER);
        super(totalShards, successfulShards, failedShards, shardFailures);  
package org.opensearch.action.admin.indices.forcemerge;
                response.getFailedShards(),  
 * GitHub history for details.
 *  
        builder.append("total_shards=").append(getTotalShards()).append(',');
 * Modifications Copyright OpenSearch Contributors. See
}
