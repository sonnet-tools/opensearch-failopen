        super("index_template [" + name + "] missing");
import java.io.IOException;
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * specific language governing permissions and limitations
    }
 * Modifications Copyright OpenSearch Contributors. See  
/*
        out.writeOptionalString(name);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 */
/*  
    }  
        super(in);
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
 */  
/**
 *    http://www.apache.org/licenses/LICENSE-2.0
        super.writeTo(out);
 * not use this file except in compliance with the License.
import org.opensearch.core.rest.RestStatus;  
        return RestStatus.NOT_FOUND;
import org.opensearch.OpenSearchException;  
    public void writeTo(StreamOutput out) throws IOException {
 *  
 * license agreements. See the NOTICE file distributed with
        return this.name;  
import org.opensearch.core.common.io.stream.StreamOutput;
    public IndexTemplateMissingException(String name) {
 */
        name = in.readOptionalString();
 *
    @Override  
    public String name() {
 * software distributed under the License is distributed on an
    }
    public IndexTemplateMissingException(StreamInput in) throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
        this.name = name;  
 * @opensearch.internal
    public RestStatus status() {
/*
 * Exception thrown if an index template is missing
}
 * this work for additional information regarding copyright
public class IndexTemplateMissingException extends OpenSearchException {  
 */
import org.opensearch.core.common.io.stream.StreamInput;
 *  
    @Override  
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
    }  
 * compatible open source license.
    private final String name;
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.indices;
