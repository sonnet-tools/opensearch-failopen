 * @opensearch.internal
package org.opensearch;
    public OpenSearchSecurityException(String msg, Object... args) {
    }
import org.opensearch.core.rest.RestStatus;
    /**
     * Build the exception with a specific status and cause.  
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
     */  
    }
 * this file be licensed under the Apache-2.0 license or a
    public OpenSearchSecurityException(String msg, RestStatus status, Object... args) {
     */
    /**
}  
 */  
import org.opensearch.core.common.io.stream.StreamInput;  
 * ownership. Elasticsearch licenses this file to you under  
     */
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
     * Read from a stream.
 * Licensed to Elasticsearch under one or more contributor  
    public OpenSearchSecurityException(String msg, Exception cause, Object... args) {  
        super(in);
 *
     * Build the exception with a status of {@link RestStatus#INTERNAL_SERVER_ERROR} without a cause.
 *  
 * Generic security exception  
/*  
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
        super(msg, status, cause, args);  
 * this work for additional information regarding copyright
 */
 * The OpenSearch Contributors require contributions made to  
     * Build the exception with the status derived from the cause.
        this(msg, RestStatus.INTERNAL_SERVER_ERROR, args);
    /**  
    /**  
     * Build the exception without a cause.  
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**
    public OpenSearchSecurityException(StreamInput in) throws IOException {  
 * GitHub history for details.
     */
 * Modifications Copyright OpenSearch Contributors. See  
 * the Apache License, Version 2.0 (the "License"); you may
        this(msg, ExceptionsHelper.status(cause), cause, args);
    }
     */
 * compatible open source license.
public class OpenSearchSecurityException extends OpenSearchStatusException {
    /**
 *
    }  
import java.io.IOException;  
    public OpenSearchSecurityException(String msg, RestStatus status, Throwable cause, Object... args) {
/*
 */  
    }
 *
        super(msg, status, args);  
/*
 * license agreements. See the NOTICE file distributed with
 * under the License.  
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
