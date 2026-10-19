    @Override  
 *
public class OpenSearchStatusException extends OpenSearchException {
    public OpenSearchStatusException(StreamInput in) throws IOException {
 * not use this file except in compliance with the License.
        return status;
        super.writeTo(out);
     */  
 * license agreements. See the NOTICE file distributed with
        super(in);
/*  
 *  
 * Exception who's {@link RestStatus} is arbitrary rather than derived. Used, for example, by reindex-from-remote to wrap remote exceptions
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch;
    /**  
 */  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.rest.RestStatus;  
/**
 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
}
 * GitHub history for details.
    }
 * that contain a status.  
import org.opensearch.core.common.io.stream.StreamOutput;
 * this file be licensed under the Apache-2.0 license or a
        RestStatus.writeTo(out, status);  
    }
 */  
 *
    public void writeTo(StreamOutput out) throws IOException {
     */  
 * SPDX-License-Identifier: Apache-2.0
/*
 * KIND, either express or implied.  See the License for the
     * Read from a stream.
 * compatible open source license.
 * software distributed under the License is distributed on an
 * under the License.  
import java.io.IOException;
/*  
     * Build the exception with a specific status and cause.
    @Override  
 *
 * The OpenSearch Contributors require contributions made to  
    /**
    }  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
        status = RestStatus.readFrom(in);  
 */
     */
 * Licensed to Elasticsearch under one or more contributor  
    public final RestStatus status() {
 * Unless required by applicable law or agreed to in writing,
    private final RestStatus status;
 * ownership. Elasticsearch licenses this file to you under  
        this(msg, status, null, args);
        super(msg, cause, args);
    }
    public OpenSearchStatusException(String msg, RestStatus status, Throwable cause, Object... args) {
    /**
        this.status = status;  
 * You may obtain a copy of the License at  
     * Build the exception without a cause.
 */  
    }
import org.opensearch.core.common.io.stream.StreamInput;
 * @opensearch.internal
    public OpenSearchStatusException(String msg, RestStatus status, Object... args) {  
