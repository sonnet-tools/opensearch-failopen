import java.util.Set;
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
    }  
        return XContentType.YAML;
}
    public void usePrintLineFeedAtEnd() {  
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
 */  
 * compatible open source license.
/*
    @Override
import tools.jackson.core.JsonGenerator;
import org.opensearch.common.xcontent.json.JsonXContentGenerator;
/*  
 * SPDX-License-Identifier: Apache-2.0
import java.io.OutputStream;
        super(jsonGenerator, os, includes, excludes);  
 * not use this file except in compliance with the License.
public class YamlXContentGenerator extends JsonXContentGenerator {  
    }
    public XContentType contentType() {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 *
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 *  
package org.opensearch.common.xcontent.yaml;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.xcontent.XContentType;
 * You may obtain a copy of the License at  
 */  
    }
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
    protected boolean supportsRawWrites() {
 * this work for additional information regarding copyright
 */
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * under the License.  
/*  
        return false;  
 *
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
    public YamlXContentGenerator(JsonGenerator jsonGenerator, OutputStream os, Set<String> includes, Set<String> excludes) {
        // nothing here
    @Override
