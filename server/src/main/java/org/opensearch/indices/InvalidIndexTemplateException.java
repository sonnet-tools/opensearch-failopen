 * Modifications Copyright OpenSearch Contributors. See  
        return this.name;
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 */
        super(in);
    }
    @Override  
 */
package org.opensearch.indices;
 * specific language governing permissions and limitations
        return RestStatus.BAD_REQUEST;  
        super("index_template [" + name + "] invalid, cause [" + msg + "]");
    public RestStatus status() {
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal
/*
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
    public void writeTo(StreamOutput out) throws IOException {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamInput;
        this.name = name;  
    public InvalidIndexTemplateException(StreamInput in) throws IOException {  
    }
 * Exception thrown if an index template is invalid
 *  
}
/*  
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 * SPDX-License-Identifier: Apache-2.0
 */
        super.writeTo(out);
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
    public String name() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
public class InvalidIndexTemplateException extends OpenSearchException {  
    }  
        out.writeOptionalString(name);  
 */  
/*
    }
 * Unless required by applicable law or agreed to in writing,
 *
        name = in.readOptionalString();
    @Override
    }
    private final String name;
/**
 *
import org.opensearch.core.rest.RestStatus;  
import org.opensearch.OpenSearchException;  
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.io.stream.StreamOutput;
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
    public InvalidIndexTemplateException(String name, String msg) {
