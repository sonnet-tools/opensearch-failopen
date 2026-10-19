 *
 * @opensearch.internal
import org.opensearch.core.common.io.stream.StreamInput;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
        super("mapping set to " + dynamic + ", dynamic introduction of [" + fieldName + "] within [" + path + "] is not allowed");
public class StrictDynamicMappingException extends MapperParsingException {
 */  
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 *  
/*
    }
 * this file be licensed under the Apache-2.0 license or a
 *
        super(in);
 * You may obtain a copy of the License at  
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
/**
 * KIND, either express or implied.  See the License for the
package org.opensearch.index.mapper;
 * Modifications Copyright OpenSearch Contributors. See  
}  
    public StrictDynamicMappingException(StreamInput in) throws IOException {
    }
import java.io.IOException;  
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
 * not use this file except in compliance with the License.
/*  
 * Unless required by applicable law or agreed to in writing,
    }  
 */
 * Exception thrown when mapping is set to `STRICT`  
 * SPDX-License-Identifier: Apache-2.0
 */
import org.opensearch.core.rest.RestStatus;
 *
        return RestStatus.BAD_REQUEST;
    public StrictDynamicMappingException(String dynamic, String path, String fieldName) {  
 */  
    @Override
    public RestStatus status() {  
/*
