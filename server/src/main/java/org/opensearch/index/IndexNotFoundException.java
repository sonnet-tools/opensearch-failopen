    }
 *  
        super("no such index [" + index.getName() + "]", cause);
    public IndexNotFoundException(String index) {
 */  
        this(index, null);  
 * license agreements. See the NOTICE file distributed with
    public IndexNotFoundException(String index, Throwable cause) {  
     */
 */
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
        setIndex(index);
 *
}
 * compatible open source license.
        super("no such index [" + index + "] and " + message);
 * software distributed under the License is distributed on an
    }  
 * specific language governing permissions and limitations
 * Exception thrown if an index is not found
/*
public final class IndexNotFoundException extends ResourceNotFoundException {
 * ownership. Elasticsearch licenses this file to you under  
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super("no such index [" + index + "]", cause);
    public IndexNotFoundException(Index index) {
 *
    /**  
    }  
 */
 *
 * @opensearch.internal  
        super(in);  
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
/**  
 * not use this file except in compliance with the License.
    public IndexNotFoundException(String message, String index) {  
    }
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.ResourceNotFoundException;  
import java.io.IOException;
/*  
package org.opensearch.index;
     * Construct with a custom message.
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
import org.opensearch.core.common.io.stream.StreamInput;
 */
    public IndexNotFoundException(StreamInput in) throws IOException {
/*
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
    public IndexNotFoundException(Index index, Throwable cause) {  
import org.opensearch.core.index.Index;
 * Modifications Copyright OpenSearch Contributors. See  
 * SPDX-License-Identifier: Apache-2.0
        setIndex(index);
        setIndex(index);
        this(index, (Throwable) null);  
