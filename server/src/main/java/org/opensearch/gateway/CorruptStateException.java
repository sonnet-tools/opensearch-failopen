/*
    }
     * @param ex the exception cause
 * This exception is thrown when OpenSearch detects  
    /**
     *
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
    }  
 * GitHub history for details.
/**
 * ownership. Elasticsearch licenses this file to you under  
    /**  
 * under the License.  
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See  
/*
 * SPDX-License-Identifier: Apache-2.0
 */
 */  
 * You may obtain a copy of the License at  
        super(message);  
     * Creates a new {@link CorruptStateException} with the given exceptions stacktrace.
package org.opensearch.gateway;
 * Licensed to Elasticsearch under one or more contributor  
     * This constructor copies the stacktrace as well as the message from the given {@link Throwable}
     * @param message the exception message.  
 * compatible open source license.
}
 *
     * Creates a new {@link CorruptStateException}
import org.opensearch.OpenSearchCorruptionException;  
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 */
     */
 * @opensearch.internal  
public class CorruptStateException extends OpenSearchCorruptionException {
 *
/*  
 */
    public CorruptStateException(Throwable ex) {
 * software distributed under the License is distributed on an
     * into this exception.  
 * an inconsistency in one of it's persistent states.
 *
        super(ex);
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
 *  
    public CorruptStateException(String message) {
