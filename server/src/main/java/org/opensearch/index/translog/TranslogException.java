/**
    public TranslogException(StreamInput in) throws IOException {
@PublicApi(since = "1.0.0")
/*  
import java.io.IOException;  
 *
 *
 * under the License.  
 * this work for additional information regarding copyright
 *  
 * You may obtain a copy of the License at  
        this(shardId, msg, null);
 * this file be licensed under the Apache-2.0 license or a
 */  
    public TranslogException(ShardId shardId, String msg) {
    }  
 * GitHub history for details.
public class TranslogException extends OpenSearchException {
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
    public TranslogException(ShardId shardId, String msg, Throwable cause) {
 *
        setShard(shardId);
    }  
 * not use this file except in compliance with the License.
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.io.stream.StreamInput;  
 * KIND, either express or implied.  See the License for the
 */
 * compatible open source license.
/*  
 * SPDX-License-Identifier: Apache-2.0
        super(in);
}
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.index.translog;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.OpenSearchException;
 */  
 * specific language governing permissions and limitations
import org.opensearch.common.annotation.PublicApi;
 * license agreements. See the NOTICE file distributed with
 * Exception thrown if there are any failures in the translog  
import org.opensearch.core.index.shard.ShardId;
/*
 * @opensearch.api
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
        super(msg, cause);  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * Unless required by applicable law or agreed to in writing,
