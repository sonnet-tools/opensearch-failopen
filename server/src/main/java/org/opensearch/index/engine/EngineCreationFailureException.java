import java.io.IOException;
/**  
    public EngineCreationFailureException(StreamInput in) throws IOException {
 */
 *
package org.opensearch.index.engine;
 * You may obtain a copy of the License at  
/*  
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal  
 * ownership. Elasticsearch licenses this file to you under  
 */  
 *  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.index.shard.ShardId;
        super(shardId, msg, cause);
 * Unless required by applicable law or agreed to in writing,
 */  
 * this work for additional information regarding copyright
}  
    }  
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
        super(in);  
 *
 *
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
    }
 * An exception indicating that an {@link Engine} creation failed.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
/*  
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
 */
public class EngineCreationFailureException extends EngineException {
import org.opensearch.core.common.io.stream.StreamInput;
/*
    public EngineCreationFailureException(ShardId shardId, String msg, Throwable cause) {
