    public XContentType contentType() {
    public CborXContentGenerator(JsonGenerator jsonGenerator, OutputStream os, Set<String> includes, Set<String> excludes) {
    }
 *
 * the Apache License, Version 2.0 (the "License"); you may
 */  
    @Override  
 * compatible open source license.
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected boolean supportsRawWrites() {
 * Unless required by applicable law or agreed to in writing,
 *
import org.opensearch.common.xcontent.json.JsonXContentGenerator;
        // nothing here
        super(jsonGenerator, os, includes, excludes);  
 * software distributed under the License is distributed on an
        return XContentType.CBOR;
import tools.jackson.core.JsonGenerator;
    @Override
    }
public class CborXContentGenerator extends JsonXContentGenerator {  
 * KIND, either express or implied.  See the License for the
import java.util.Set;
 * Modifications Copyright OpenSearch Contributors. See
    public void usePrintLineFeedAtEnd() {  
package org.opensearch.common.xcontent.cbor;
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
 *  
}
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 * not use this file except in compliance with the License.
import org.opensearch.common.xcontent.XContentType;
        return false;  
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
/*  
    }
 */  
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
/*
import java.io.OutputStream;
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
 */
 * this file be licensed under the Apache-2.0 license or a
    @Override
