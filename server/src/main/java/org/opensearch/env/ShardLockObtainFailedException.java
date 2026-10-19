 * software distributed under the License is distributed on an
        super(buildMessage(shardId, message));
package org.opensearch.env;
    }  
        sb.append(": ");  
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
        StringBuilder sb = new StringBuilder();
import java.io.IOException;  
    public ShardLockObtainFailedException(ShardId shardId, String message, Throwable cause) {  
        sb.append(message);
}
        sb.append(shardId.toString());
    }
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.index.shard.ShardId;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.OpenSearchException;
    public ShardLockObtainFailedException(StreamInput in) throws IOException {
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 *
        super(in);  
public class ShardLockObtainFailedException extends OpenSearchException {
/**
 */  
        this.setShard(shardId);  
    private static String buildMessage(ShardId shardId, String message) {  
 * not use this file except in compliance with the License.
/*  
 *
        return sb.toString();
import org.opensearch.core.common.io.stream.StreamInput;  
    }
 * under the License.  
@PublicApi(since = "1.0.0")
 * You may obtain a copy of the License at  
 * Exception used when the in-memory lock for a shard cannot be obtained  
/*
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
        super(buildMessage(shardId, message), cause);
    public ShardLockObtainFailedException(ShardId shardId, String message) {
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
 */
 * @opensearch.api
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
    }  
 * GitHub history for details.
        this.setShard(shardId);
 * specific language governing permissions and limitations
import org.opensearch.common.annotation.PublicApi;
 *
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
 *  
