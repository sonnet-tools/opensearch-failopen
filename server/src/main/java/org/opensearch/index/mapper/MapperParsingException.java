/*  
 * ownership. Elasticsearch licenses this file to you under  
 */
    public RestStatus status() {
 * software distributed under the License is distributed on an
    public MapperParsingException(String message, Throwable cause) {
/**
    @Override
/*
        return RestStatus.BAD_REQUEST;  
 *
        super(message);
 * GitHub history for details.
 * You may obtain a copy of the License at  
@PublicApi(since = "1.0.0")  
import java.io.IOException;
import org.opensearch.common.annotation.PublicApi;
public class MapperParsingException extends MapperException {
    }
package org.opensearch.index.mapper;
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 *
 */  
        super(message, cause, args);
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
    public MapperParsingException(StreamInput in) throws IOException {  
    }
 */
 *  
 */  
    public MapperParsingException(String message, Throwable cause, Object... args) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
}
 *  
    }
    }  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.rest.RestStatus;  
/*  
 * @opensearch.api
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.StreamInput;
 * license agreements. See the NOTICE file distributed with
        super(in);
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
    public MapperParsingException(String message) {
    }
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
 * Exception thrown if there are any errors parsing mappings
        super(message, cause);  
