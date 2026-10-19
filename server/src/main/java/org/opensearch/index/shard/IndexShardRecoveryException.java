import org.opensearch.core.index.shard.ShardId;  
 * SPDX-License-Identifier: Apache-2.0
public class IndexShardRecoveryException extends OpenSearchException {  
 * under the License.  
/*  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
}  
 * You may obtain a copy of the License at  
 *
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 */
 * Exception thrown when there is an error on recovery of Index Shard
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
package org.opensearch.index.shard;
/*  
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;
    public IndexShardRecoveryException(ShardId shardId, String msg, Throwable cause) {
    }
 * @opensearch.internal
 * GitHub history for details.
 * not use this file except in compliance with the License.
/**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        setShard(shardId);  
 * ownership. Elasticsearch licenses this file to you under  
 *
 *  
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
 */  
 */
 * software distributed under the License is distributed on an
        super(in);
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.OpenSearchException;
 * this work for additional information regarding copyright
    }
        super(msg, cause);
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamInput;
    public IndexShardRecoveryException(StreamInput in) throws IOException {  
