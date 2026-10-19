}
public class FlushFailedEngineException extends EngineException {
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
    public FlushFailedEngineException(ShardId shardId, Throwable t) {
/*
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.index.shard.ShardId;
 */
 * Exception thrown if there is an error on flush
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.io.stream.StreamInput;
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.index.engine;
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal  
 */  
 * this file be licensed under the Apache-2.0 license or a
 *
        super(shardId, "Flush failed", t);
/*  
import java.io.IOException;
 *
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
        super(in);  
/**  
/*  
 * software distributed under the License is distributed on an
 */  
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
    }
 */
 *
 * GitHub history for details.
    }  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
    public FlushFailedEngineException(StreamInput in) throws IOException {
 * compatible open source license.
