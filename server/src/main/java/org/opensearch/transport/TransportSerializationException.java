 * Thrown if there is an error serializing data for transport  
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamInput;
 * @opensearch.internal
 * ownership. Elasticsearch licenses this file to you under  
        super(in);
 */  
 * license agreements. See the NOTICE file distributed with
}
/*  
/*  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
    public TransportSerializationException(StreamInput in) throws IOException {  
    public TransportSerializationException(String msg, Throwable cause) {
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
    }
 * this file be licensed under the Apache-2.0 license or a
 */  
 *  
 * this work for additional information regarding copyright
        super(msg, cause);
 *
 * KIND, either express or implied.  See the License for the
/*
package org.opensearch.transport;
 *
    }  
 * Licensed to Elasticsearch under one or more contributor  
public class TransportSerializationException extends TransportException {
 * Modifications Copyright OpenSearch Contributors. See
 */
/**
 * GitHub history for details.
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
