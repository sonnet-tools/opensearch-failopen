    }
}  
 * Modifications Copyright OpenSearch Contributors. See
    public RoutingMissingException(String index, String type, String id) {
 *
        return RestStatus.BAD_REQUEST;  
import org.opensearch.OpenSearchException;
        setIndex(index);  
 * SPDX-License-Identifier: Apache-2.0
 *  
        this.id = id;
 */
        super("routing is required for [" + index + "]/[" + id + "]");
 * ownership. Elasticsearch licenses this file to you under  
        this(index, MapperService.SINGLE_MAPPING_NAME, id);
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
        return type;  
 * under the License.  
/*  
        super(in);
 * compatible open source license.
        Objects.requireNonNull(type, "type must not be null");
/*
 */  
 * license agreements. See the NOTICE file distributed with
 */  
import java.util.Objects;
 * Base exception for a missing routing
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
        Objects.requireNonNull(id, "id must not be null");
 * not use this file except in compliance with the License.
import java.io.IOException;
 * GitHub history for details.
    public String getType() {
        type = in.readString();
import org.opensearch.core.common.io.stream.StreamOutput;  
 * KIND, either express or implied.  See the License for the
    private final String id;
    }  
        return id;
    }
    @Override
public class RoutingMissingException extends OpenSearchException {  
        this.type = type;
 * Unless required by applicable law or agreed to in writing,
        id = in.readString();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
/**
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
        Objects.requireNonNull(index, "index must not be null");  
    public RoutingMissingException(StreamInput in) throws IOException {  
    }
 *  
 * specific language governing permissions and limitations
    public RestStatus status() {
    }
import org.opensearch.core.rest.RestStatus;
 * @opensearch.internal
    public RoutingMissingException(String index, String id) {  
    @Override  
    private final String type;
    }
 */
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.mapper.MapperService;
        out.writeString(id);
        out.writeString(type);  
 * this file be licensed under the Apache-2.0 license or a
    }
 *
/*  
    public String getId() {  
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.action;
        super.writeTo(out);
