 * The response of a clear cache action.
 * license agreements. See the NOTICE file distributed with
                response.getTotalShards(),
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
    }  
    private static final ConstructingObjectParser<ClearIndicesCacheResponse, Void> PARSER = new ConstructingObjectParser<>(
        return PARSER.apply(parser, null);
            return new ClearIndicesCacheResponse(
package org.opensearch.action.admin.indices.cache.clear;
import org.opensearch.common.annotation.PublicApi;
            );  
 *
        "clear_cache",  
import org.opensearch.action.support.broadcast.BroadcastResponse;
        int totalShards,
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * under the License.  
                response.getSuccessfulShards(),  
    ) {
    ClearIndicesCacheResponse(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
    static {
                response.getFailedShards(),
 * GitHub history for details.
 *
        super(in);  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
@PublicApi(since = "1.0.0")
import org.opensearch.core.xcontent.XContentParser;  
public class ClearIndicesCacheResponse extends BroadcastResponse {  
    ClearIndicesCacheResponse(StreamInput in) throws IOException {
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
 * @opensearch.api  
 * The OpenSearch Contributors require contributions made to  
 */  
import org.opensearch.core.xcontent.ConstructingObjectParser;
 *  
        super(totalShards, successfulShards, failedShards, shardFailures);  
 *
import org.opensearch.core.common.io.stream.StreamInput;
    );
        arg -> {
 * ownership. Elasticsearch licenses this file to you under  
        }
import java.io.IOException;
        int successfulShards,
import java.util.List;
}  
        true,
/*
 */
        List<DefaultShardOperationFailedException> shardFailures
                Arrays.asList(response.getShardFailures())
 */
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
        int failedShards,  
    }
    }
    public static ClearIndicesCacheResponse fromXContent(XContentParser parser) {  
/**  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
import java.util.Arrays;  
        declareBroadcastFields(PARSER);
            BroadcastResponse response = (BroadcastResponse) arg[0];  
 * compatible open source license.
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 */  
 * Modifications Copyright OpenSearch Contributors. See
