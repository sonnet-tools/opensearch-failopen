 * license agreements. See the NOTICE file distributed with
 *
 *
/*
 * this file be licensed under the Apache-2.0 license or a
    }
/*  
 */  
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
 * GitHub history for details.
 * software distributed under the License is distributed on an
import java.io.IOException;
 */
    public HttpException(String message) {
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
        super(message);
package org.opensearch.http;
 */
 *  
 * SPDX-License-Identifier: Apache-2.0
    }
    }  
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
        super(message, cause);  
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
public class HttpException extends OpenSearchException {
    public HttpException(String message, Throwable cause) {
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
        super(in);
/**  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.StreamInput;
 * Exception thrown on HTTP requests
    public HttpException(StreamInput in) throws IOException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}  
import org.opensearch.OpenSearchException;
 * @opensearch.internal  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
