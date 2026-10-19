/*
}
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
    }
/**  
    }  
 * Licensed to Elasticsearch under one or more contributor  
    }
import org.opensearch.core.index.shard.ShardId;
 * not use this file except in compliance with the License.
 * @opensearch.internal  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
 */
 * You may obtain a copy of the License at  
        super(shardId, msg, cause);
    public IndexShardSnapshotFailedException(ShardId shardId, String msg, Throwable cause) {
    public IndexShardSnapshotFailedException(StreamInput in) throws IOException {
 * under the License.  
        super(shardId, msg);
 * this work for additional information regarding copyright
        super(in);  
 */  
 * license agreements. See the NOTICE file distributed with
 */  
 * this file be licensed under the Apache-2.0 license or a
 *
 *
 */
package org.opensearch.core.index.snapshots;
public class IndexShardSnapshotFailedException extends IndexShardSnapshotException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
 *  
/*  
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
    public IndexShardSnapshotFailedException(ShardId shardId, String msg) {  
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * Thrown when snapshot process is failed on a shard level
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.StreamInput;
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
import java.io.IOException;
