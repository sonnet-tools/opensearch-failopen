}
        super(in);
 * You may obtain a copy of the License at  
 *
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.StreamInput;
import java.io.IOException;  
 * ownership. Elasticsearch licenses this file to you under  
 *
    public BindTransportException(StreamInput in) throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
    }
 */  
 * GitHub history for details.
        super(message);  
        super(message, cause);
 */  
/**
 *
/*  
    }
public class BindTransportException extends TransportException {
 * The OpenSearch Contributors require contributions made to  
    }  
 * A transport binding failure.  
 * under the License.  
    public BindTransportException(String message, Throwable cause) {
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
 */
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.internal
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
/*  
 * software distributed under the License is distributed on an
/*
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
package org.opensearch.transport;
    public BindTransportException(String message) {
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
 *  
