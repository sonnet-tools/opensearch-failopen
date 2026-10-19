 * not use this file except in compliance with the License.
        super(message, cause, args);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
        super(message, args);  
        super(in);
/*
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
/*  
 *
        super(cause);
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
    }
public class OpenSearchTimeoutException extends OpenSearchException {
 * You may obtain a copy of the License at  
 */  
 *
 */
    public OpenSearchTimeoutException(StreamInput in) throws IOException {  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
    public OpenSearchTimeoutException(Throwable cause) {
package org.opensearch;
import org.opensearch.core.common.io.stream.StreamInput;
    }  
        return RestStatus.GATEWAY_TIMEOUT;  
    public RestStatus status() {
 *  
 * The same as {@link java.util.concurrent.TimeoutException} simply a runtime one.
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.rest.RestStatus;
 */  
 * KIND, either express or implied.  See the License for the
    public OpenSearchTimeoutException(String message, Throwable cause, Object... args) {  
    }
}
 */
 * software distributed under the License is distributed on an
 *
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
/**  
 * @opensearch.internal  
    }
/*  
    public OpenSearchTimeoutException(String message, Object... args) {
 * this file be licensed under the Apache-2.0 license or a
