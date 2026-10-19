 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
 * Error thrown if no search context is available
/*
    @Override  
    }
public class SearchContextMissingException extends OpenSearchException {
 * specific language governing permissions and limitations
import org.opensearch.core.common.io.stream.StreamInput;
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
    private final ShardSearchContextId contextId;
import org.opensearch.core.rest.RestStatus;
import org.opensearch.search.internal.ShardSearchContextId;
/*  
import org.opensearch.OpenSearchException;
    public void writeTo(StreamOutput out) throws IOException {
 */
 *  
    @Override
 * @opensearch.internal  
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
    public RestStatus status() {
 */
 * not use this file except in compliance with the License.
        super.writeTo(out);  
        contextId.writeTo(out);
        this.contextId = contextId;
/*  
    }  
 *
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;
    public SearchContextMissingException(ShardSearchContextId contextId) {  
 * You may obtain a copy of the License at  
import org.opensearch.core.common.io.stream.StreamOutput;  
        contextId = new ShardSearchContextId(in);
 * software distributed under the License is distributed on an
        super("No search context found for id [" + contextId.getId() + "]");
 * The OpenSearch Contributors require contributions made to  
}  
    }
 * this work for additional information regarding copyright
 */  
        return RestStatus.NOT_FOUND;
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 *
 *
package org.opensearch.search;
 * compatible open source license.
    public ShardSearchContextId contextId() {
    }
        super(in);  
 * the Apache License, Version 2.0 (the "License"); you may
    public SearchContextMissingException(StreamInput in) throws IOException {
/**  
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
 */  
        return this.contextId;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
