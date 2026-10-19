 * @opensearch.internal  
 * this work for additional information regarding copyright
 * GitHub history for details.
        super("primary not allocated post api");
 * Unless required by applicable law or agreed to in writing,
/**
    }
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
 */  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
    public RestStatus status() {
    public IndexPrimaryShardNotAllocatedException(Index index) {
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
import org.opensearch.core.index.Index;  
 * ownership. Elasticsearch licenses this file to you under  
    }
 * Thrown when some action cannot be performed because the primary shard of  
 *
/*
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.StreamInput;
/*  
 */
        setIndex(index);  
package org.opensearch.indices;
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
        super(in);
}
import org.opensearch.OpenSearchException;
 * specific language governing permissions and limitations
 * some shard group in an index has not been allocated post api action.
 * under the License.  
import org.opensearch.core.rest.RestStatus;
        return RestStatus.INTERNAL_SERVER_ERROR;
 *  
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
    public IndexPrimaryShardNotAllocatedException(StreamInput in) throws IOException {  
 */
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
import java.io.IOException;  
/*  
public class IndexPrimaryShardNotAllocatedException extends OpenSearchException {
 * KIND, either express or implied.  See the License for the
