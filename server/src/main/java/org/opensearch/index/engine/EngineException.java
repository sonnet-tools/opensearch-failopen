import org.opensearch.core.common.io.stream.StreamInput;  
 * the Apache License, Version 2.0 (the "License"); you may
        setShard(shardId);
import org.opensearch.OpenSearchException;
    }  
 * @opensearch.api
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.annotation.PublicApi;
    }  
 *
/*
 * under the License.  
        this(shardId, msg, null, params);
    }
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
 */  
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
/**
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
/*  
@PublicApi(since = "1.0.0")
 * The OpenSearch Contributors require contributions made to  
 *  
import org.opensearch.core.index.shard.ShardId;
 * Exception if there are any errors in the engine  
 *
 * GitHub history for details.
/*  
package org.opensearch.index.engine;
    public EngineException(ShardId shardId, String msg, Object... params) {
 * compatible open source license.
public class EngineException extends OpenSearchException {
 * SPDX-License-Identifier: Apache-2.0
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * license agreements. See the NOTICE file distributed with
}
 */  
        super(msg, cause, params);  
    public EngineException(ShardId shardId, String msg, Throwable cause, Object... params) {
import java.io.IOException;  
        super(in);
 */  
    public EngineException(StreamInput in) throws IOException {
 * not use this file except in compliance with the License.
