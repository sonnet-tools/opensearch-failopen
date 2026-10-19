 *  
    public IndexShardRestoreException(StreamInput in) throws IOException {
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
        super(msg, cause);  
 * ownership. Elasticsearch licenses this file to you under  
/*
/*  
 */  
 * license agreements. See the NOTICE file distributed with
}
package org.opensearch.index.snapshots;
public class IndexShardRestoreException extends OpenSearchException {  
 * Generic shard restore exception
 * the Apache License, Version 2.0 (the "License"); you may
    }  
import org.opensearch.core.index.shard.ShardId;  
 * under the License.  
        super(in);
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
/**
        this(shardId, msg, null);
 */
        setShard(shardId);
 *  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
import org.opensearch.core.common.io.stream.StreamInput;
 * The OpenSearch Contributors require contributions made to  
 *
 * @opensearch.internal
 * KIND, either express or implied.  See the License for the
 */
    public IndexShardRestoreException(ShardId shardId, String msg) {
 * this work for additional information regarding copyright
/*  
    public IndexShardRestoreException(ShardId shardId, String msg, Throwable cause) {
 * Modifications Copyright OpenSearch Contributors. See
    }  
 * GitHub history for details.
import java.io.IOException;
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
import org.opensearch.OpenSearchException;
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
