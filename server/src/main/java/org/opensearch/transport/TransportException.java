 *
@PublicApi(since = "1.0.0")  
}
 * software distributed under the License is distributed on an
 */
    public TransportException(String msg, Throwable cause) {
    public TransportException(Throwable cause) {
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 * @opensearch.api
        super(in);
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
public class TransportException extends OpenSearchException {
        super(msg, cause);  
/*
 * not use this file except in compliance with the License.
 * GitHub history for details.
import org.opensearch.common.annotation.PublicApi;
 */
        super(msg);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.OpenSearchException;
import org.opensearch.core.common.io.stream.StreamInput;  
 *  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
/**
        super(cause);  
 * this file be licensed under the Apache-2.0 license or a
 */  
 *
package org.opensearch.transport;
    }  
    public TransportException(String msg) {
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
/*  
/*  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
    }
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
 */  
 * Unless required by applicable law or agreed to in writing,
 * Thrown for any transport errors
    public TransportException(StreamInput in) throws IOException {  
    }
