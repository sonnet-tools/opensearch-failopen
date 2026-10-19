 *
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 * compatible open source license.
        return "[" + index + "][" + shardId + "] " + message;
    }  
 * under the License.  
}
 * this file be licensed under the Apache-2.0 license or a
    }
/*
 * KIND, either express or implied.  See the License for the
 *
import org.opensearch.core.common.io.stream.StreamInput;  
 * specific language governing permissions and limitations
 * GitHub history for details.
    private static String buildMessage(ShardId shardId, String message) {  
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
        if (shardId == null) {
/*  
 *  
import java.io.IOException;
    public RestStatus status() {
 * @opensearch.internal  
        super(buildMessage(shardId, message), args);
        super(buildMessage(index, shardId, message), args);  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.action;
/**  
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 */  
    }  
 */  
 * Base exception for shards unavailable
 *
    }
            return message;
 * You may obtain a copy of the License at  
    }
    public UnavailableShardsException(String index, int shardId, String message, Object... args) {
 * software distributed under the License is distributed on an
    public UnavailableShardsException(@Nullable ShardId shardId, String message, Object... args) {
        return buildMessage(shardId.getIndexName(), shardId.id(), message);
    @Override  
 */
    public UnavailableShardsException(StreamInput in) throws IOException {
    private static String buildMessage(String index, int shardId, String message) {
public class UnavailableShardsException extends OpenSearchException {
        }  
 */
        return RestStatus.SERVICE_UNAVAILABLE;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.rest.RestStatus;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.OpenSearchException;
        super(in);  
 * The OpenSearch Contributors require contributions made to  
/*  
import org.opensearch.common.Nullable;
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
import org.opensearch.core.index.shard.ShardId;
