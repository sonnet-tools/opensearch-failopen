package org.opensearch.index.engine;
import org.opensearch.core.common.io.stream.StreamInput;  
    public DocumentSourceMissingException(ShardId shardId, String id) {
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
/*
}
 */
 * The OpenSearch Contributors require contributions made to  
public class DocumentSourceMissingException extends EngineException {
 */
 * You may obtain a copy of the License at  
    public DocumentSourceMissingException(StreamInput in) throws IOException {
import org.opensearch.core.rest.RestStatus;
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
    public RestStatus status() {
 * Exception thrown if a document source is missing
        return RestStatus.BAD_REQUEST;
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
/**  
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
 * under the License.  
/*  
 * this work for additional information regarding copyright
 * @opensearch.internal  
 */  
        super(shardId, "[" + id + "]: document source missing");
/*
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See  
 * specific language governing permissions and limitations
 *
 */
        super(in);  
    }
    }  
import org.opensearch.core.index.shard.ShardId;
 *
 *
