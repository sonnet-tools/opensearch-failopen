public class ResourceNotFoundException extends OpenSearchException {
    }
    @Override  
import java.io.IOException;  
 * software distributed under the License is distributed on an
    public ResourceNotFoundException(StreamInput in) throws IOException {
 * Generic ResourceNotFoundException corresponding to the {@link RestStatus#NOT_FOUND} status code  
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal
import org.opensearch.core.common.io.stream.StreamInput;  
 * Modifications Copyright OpenSearch Contributors. See  
        super(in);  
 */  
/*
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
    public ResourceNotFoundException(String msg, Throwable cause, Object... args) {
        return RestStatus.NOT_FOUND;
 * The OpenSearch Contributors require contributions made to  
 *
 * this work for additional information regarding copyright
    }  
 * Licensed to Elasticsearch under one or more contributor  
 *
 * not use this file except in compliance with the License.
 *
    }
        super(msg, args);
 * GitHub history for details.
 * compatible open source license.
 * You may obtain a copy of the License at  
    }  
    public ResourceNotFoundException(String msg, Object... args) {  
        super(msg, cause, args);
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.rest.RestStatus;
/**
 *  
 */
}
    public final RestStatus status() {
 * license agreements. See the NOTICE file distributed with
/*
 * KIND, either express or implied.  See the License for the
 * under the License.  
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
 */
 * Unless required by applicable law or agreed to in writing,
 */  
package org.opensearch;
