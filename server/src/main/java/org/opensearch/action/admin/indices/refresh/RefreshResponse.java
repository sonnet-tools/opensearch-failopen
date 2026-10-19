        BroadcastResponse response = (BroadcastResponse) arg[0];  
            response.getFailedShards(),
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
    RefreshResponse(StreamInput in) throws IOException {
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
 *
 *  
    static {  
    }
import org.opensearch.core.common.io.stream.StreamInput;
 */  
    }
import java.io.IOException;
    }
import java.util.List;
import org.opensearch.action.support.broadcast.BroadcastResponse;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.annotation.PublicApi;
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
/*  
 * compatible open source license.
    RefreshResponse(int totalShards, int successfulShards, int failedShards, List<DefaultShardOperationFailedException> shardFailures) {
 * software distributed under the License is distributed on an
public class RefreshResponse extends BroadcastResponse {  
 */
 * Licensed to Elasticsearch under one or more contributor  
    private static final ConstructingObjectParser<RefreshResponse, Void> PARSER = new ConstructingObjectParser<>("refresh", true, arg -> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @opensearch.api  
import org.opensearch.core.xcontent.ConstructingObjectParser;
 */  
 * specific language governing permissions and limitations
 * GitHub history for details.
}  
    });
 *
 * this file be licensed under the Apache-2.0 license or a
    }  
 */
 * not use this file except in compliance with the License.
            response.getTotalShards(),
            response.getSuccessfulShards(),  
        );  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
        declareBroadcastFields(PARSER);
 * KIND, either express or implied.  See the License for the
@PublicApi(since = "1.0.0")
            Arrays.asList(response.getShardFailures())
 * SPDX-License-Identifier: Apache-2.0
/**  
/*
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Arrays;  
 * under the License.  
    public static RefreshResponse fromXContent(XContentParser parser) {  
package org.opensearch.action.admin.indices.refresh;
        super(in);
import org.opensearch.core.xcontent.XContentParser;  
        return PARSER.apply(parser, null);
 * The OpenSearch Contributors require contributions made to  
 * The response of a refresh action.
        super(totalShards, successfulShards, failedShards, shardFailures);  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
        return new RefreshResponse(
