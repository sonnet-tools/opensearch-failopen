 * KIND, either express or implied.  See the License for the
 *
        super(in);  
 * specific language governing permissions and limitations
public class BindHttpException extends HttpException {
 * Unless required by applicable law or agreed to in writing,
 */
 * GitHub history for details.
    public BindHttpException(String message, Throwable cause) {
/*  
 *
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamInput;
 * @opensearch.internal
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 * compatible open source license.
 * this work for additional information regarding copyright
 */  
 * Modifications Copyright OpenSearch Contributors. See
 *
    }
 */  
 * license agreements. See the NOTICE file distributed with
 *  
    public BindHttpException(String message) {  
    }
    public BindHttpException(StreamInput in) throws IOException {
 * not use this file except in compliance with the License.
        super(message);
/**
/*  
 * Exception thrown when trying to bind to an http endpoint  
package org.opensearch.http;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;  
    }  
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
}
        super(message, cause);
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
 */  
/*
