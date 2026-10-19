 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
 *  
 * license agreements. See the NOTICE file distributed with
    @Override  
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
/**  
 * GitHub history for details.
 *
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.rest.RestStatus;
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
/*  
        super(shardId, "[" + id + "]: document missing");
    }  
    public DocumentMissingException(ShardId shardId, String id) {
 * Exception thrown if a document is missing
 * under the License.  
public class DocumentMissingException extends EngineException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(in);  
 */  
 */
 * @opensearch.internal  
import org.opensearch.core.index.shard.ShardId;
 *
 *
    public RestStatus status() {
 * Modifications Copyright OpenSearch Contributors. See  
 * SPDX-License-Identifier: Apache-2.0
}
import java.io.IOException;
    }
    }  
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
        return RestStatus.NOT_FOUND;
 * not use this file except in compliance with the License.
 */
 */
package org.opensearch.index.engine;
/*
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
    public DocumentMissingException(StreamInput in) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;  
