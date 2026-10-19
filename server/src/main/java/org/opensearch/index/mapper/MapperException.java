import org.opensearch.core.common.io.stream.StreamInput;
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
        super(message);
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
    }
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
public class MapperException extends OpenSearchException {
        super(message, cause, args);
 * KIND, either express or implied.  See the License for the
 * Exception thrown for any mapping errors
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
    }
}  
 * under the License.  
 */
 * specific language governing permissions and limitations
 *
    }  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.index.mapper;
 * software distributed under the License is distributed on an
import java.io.IOException;
 *
    public MapperException(String message) {
 */
 * @opensearch.internal  
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
    public MapperException(String message, Throwable cause) {
    public MapperException(String message, Throwable cause, Object... args) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
        super(in);
 *
/**  
 */  
/*
        super(message, cause);  
    public MapperException(StreamInput in) throws IOException {  
 * compatible open source license.
import org.opensearch.OpenSearchException;
 */  
