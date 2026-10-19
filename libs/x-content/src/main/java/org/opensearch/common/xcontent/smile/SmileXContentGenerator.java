    public XContentType contentType() {
 * the Apache License, Version 2.0 (the "License"); you may
    }
}
    @Override
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(jsonGenerator, os, includes, excludes);  
public class SmileXContentGenerator extends JsonXContentGenerator {  
/*
package org.opensearch.common.xcontent.smile;
 * Modifications Copyright OpenSearch Contributors. See
        return XContentType.SMILE;
 *
 */  
 * this work for additional information regarding copyright
 */  
 * license agreements. See the NOTICE file distributed with
        return false;  
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * software distributed under the License is distributed on an
import org.opensearch.common.xcontent.json.JsonXContentGenerator;
import java.util.Set;
    public void usePrintLineFeedAtEnd() {  
 * not use this file except in compliance with the License.
    }
/*  
 *
import tools.jackson.core.JsonGenerator;
    @Override  
 * GitHub history for details.
import org.opensearch.common.xcontent.XContentType;
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
    }
 * Unless required by applicable law or agreed to in writing,
        // nothing here
 */
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
    protected boolean supportsRawWrites() {
    @Override
import java.io.OutputStream;
    }  
    public SmileXContentGenerator(JsonGenerator jsonGenerator, OutputStream os, Set<String> includes, Set<String> excludes) {
/*  
 * under the License.  
 * KIND, either express or implied.  See the License for the
