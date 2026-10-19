 */  
public class IndexShardSnapshotException extends OpenSearchException {  
    }  
import org.opensearch.OpenSearchException;
    public IndexShardSnapshotException(ShardId shardId, String msg) {
    public IndexShardSnapshotException(ShardId shardId, String msg, Throwable cause) {
import org.opensearch.core.index.shard.ShardId;  
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 * software distributed under the License is distributed on an
 *
 * The OpenSearch Contributors require contributions made to  
 *  
 * under the License.  
 *  
    }  
    public IndexShardSnapshotException(StreamInput in) throws IOException {
 * compatible open source license.
        setShard(shardId);
        this(shardId, msg, null);
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under  
/*
/*  
 */
 * not use this file except in compliance with the License.
    }
package org.opensearch.core.index.snapshots;
}
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 */  
 * this work for additional information regarding copyright
/*  
import org.opensearch.core.common.io.stream.StreamInput;
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
 *
 * the Apache License, Version 2.0 (the "License"); you may
        super(msg, cause);  
/**
        super(in);
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
 * Generic shard snapshot exception
