 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
 *
 * @opensearch.internal  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * under the License.  
 *
 * You may obtain a copy of the License at  
 */  
    public RefreshFailedEngineException(ShardId shardId, Throwable t) {
    }
 * The OpenSearch Contributors require contributions made to  
}
 * compatible open source license.
    public RefreshFailedEngineException(StreamInput in) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.index.shard.ShardId;
 */
        super(in);  
 * license agreements. See the NOTICE file distributed with
/*  
 * SPDX-License-Identifier: Apache-2.0
 *
 *  
 */
 */  
 * not use this file except in compliance with the License.
import java.io.IOException;
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.StreamInput;
    }  
/**  
package org.opensearch.index.engine;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * Exception thrown if refresh fails
 * specific language governing permissions and limitations
 * GitHub history for details.
        super(shardId, "Refresh failed", t);
/*  
public class RefreshFailedEngineException extends EngineException {
