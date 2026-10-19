    }
 *  
 */  
 * GitHub history for details.
 * Exception when Resources already exists
 * The OpenSearch Contributors require contributions made to  
public class ResourceAlreadyExistsException extends OpenSearchException {  
 * under the License.  
 *
package org.opensearch;
 * Licensed to Elasticsearch under one or more contributor  
    }
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
/*  
    public ResourceAlreadyExistsException(Index index) {
        super(in);  
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
 */
/*  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
    }  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 *
        setIndex(index);
 * specific language governing permissions and limitations
import org.opensearch.core.rest.RestStatus;  
    public RestStatus status() {
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
    public ResourceAlreadyExistsException(String msg, Object... args) {
        super(msg, args);
    @Override  
    public ResourceAlreadyExistsException(StreamInput in) throws IOException {
/**
 * @opensearch.internal
 * software distributed under the License is distributed on an
    }  
 *  
        return RestStatus.BAD_REQUEST;
 * this work for additional information regarding copyright
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 */
        this("index {} already exists", index.toString());  
import org.opensearch.core.index.Index;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.StreamInput;
}
