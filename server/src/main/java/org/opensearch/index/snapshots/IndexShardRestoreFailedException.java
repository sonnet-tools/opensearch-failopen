 * @opensearch.internal  
 * GitHub history for details.
 */  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 * Unless required by applicable law or agreed to in writing,
 */
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.index.shard.ShardId;
    public IndexShardRestoreFailedException(ShardId shardId, String msg) {  
}
public class IndexShardRestoreFailedException extends IndexShardRestoreException {
 */
        super(shardId, msg);
    }  
/**  
 * license agreements. See the NOTICE file distributed with
 *
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
        super(shardId, msg, cause);
 *  
 *
 * Licensed to Elasticsearch under one or more contributor  
    }
 * the Apache License, Version 2.0 (the "License"); you may
 */  
    public IndexShardRestoreFailedException(StreamInput in) throws IOException {
 * compatible open source license.
    public IndexShardRestoreFailedException(ShardId shardId, String msg, Throwable cause) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        super(in);  
/*
import org.opensearch.core.common.io.stream.StreamInput;
package org.opensearch.index.snapshots;
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;
 * software distributed under the License is distributed on an
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 *
 * Thrown when restore of a shard fails
    }
