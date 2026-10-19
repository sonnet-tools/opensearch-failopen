 * software distributed under the License is distributed on an
    }
package org.opensearch.indices;
/*  
 * SPDX-License-Identifier: Apache-2.0
 *
 * this file be licensed under the Apache-2.0 license or a
public class InvalidTypeNameException extends MapperException {  
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
    public RestStatus status() {
 */  
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
 *
/**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.rest.RestStatus;
 */
/*  
 * this work for additional information regarding copyright
import org.opensearch.index.mapper.MapperException;  
 * Licensed to Elasticsearch under one or more contributor  
        super(in);  
 * compatible open source license.
 * You may obtain a copy of the License at  
 * @opensearch.internal
}
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 */
    public InvalidTypeNameException(StreamInput in) throws IOException {
        super(message);
 * Unless required by applicable law or agreed to in writing,
    }
 * under the License.  
 * GitHub history for details.
 *  
        return RestStatus.BAD_REQUEST;  
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * license agreements. See the NOTICE file distributed with
 *  
/*
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
    public InvalidTypeNameException(String message) {  
import java.io.IOException;
 * Exception thrown if a type is invalid
