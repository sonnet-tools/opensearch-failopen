 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See  
 * license agreements. See the NOTICE file distributed with
    }
import java.io.IOException;  
/**
     * Creates a new {@link OpenSearchCorruptionException}
    /**
 * SPDX-License-Identifier: Apache-2.0
public class OpenSearchCorruptionException extends IOException {
     */
     * This constructor copies the stacktrace as well as the message from the given
    }  
 */
     * @param ex the exception cause
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
        super(ex);
 * this work for additional information regarding copyright
     * {@code Throwable} into this exception.  
/*  
 * this file be licensed under the Apache-2.0 license or a
 * an inconsistency in one of it's persistent files.
     *
 *
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
    public OpenSearchCorruptionException(Throwable ex) {
package org.opensearch;
 * ownership. Elasticsearch licenses this file to you under  
/*
 *
        super(message);  
 */  
 *  
}
     * @param message the exception message.  
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @opensearch.internal  
     */  
 * software distributed under the License is distributed on an
 * compatible open source license.
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
 */
 * not use this file except in compliance with the License.
 * under the License.  
    /**  
 *
 * the Apache License, Version 2.0 (the "License"); you may
     * Creates a new {@link OpenSearchCorruptionException} with the given exceptions stacktrace.
 * This exception is thrown when OpenSearch detects  
 */
    public OpenSearchCorruptionException(String message) {
