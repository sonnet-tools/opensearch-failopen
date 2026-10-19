import java.io.IOException;
 */  
/*
 * license agreements. See the NOTICE file distributed with
/*  
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 */  
        super(in);  
        return RestStatus.BAD_REQUEST;
 * Licensed to Elasticsearch under one or more contributor  
 * Unchecked exception that is translated into a {@code 400 BAD REQUEST} error when it bubbles out over HTTP.
import org.opensearch.core.common.io.stream.StreamInput;
 *
 * KIND, either express or implied.  See the License for the
    public RestStatus status() {
 *
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
    public OpenSearchParseException(String msg, Throwable cause, Object... args) {
        super(msg, cause, args);
    public OpenSearchParseException(String msg, Object... args) {  
    }  
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class OpenSearchParseException extends OpenSearchException {
 * specific language governing permissions and limitations
        super(msg, args);
 * not use this file except in compliance with the License.
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.annotation.PublicApi;
 * You may obtain a copy of the License at  
 *  
    }
}
 * this work for additional information regarding copyright
 */
    @Override  
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
    }  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.rest.RestStatus;  
 */
    public OpenSearchParseException(StreamInput in) throws IOException {
 * @opensearch.api
 *  
@PublicApi(since = "1.0.0")  
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
/*  
/**
package org.opensearch;
