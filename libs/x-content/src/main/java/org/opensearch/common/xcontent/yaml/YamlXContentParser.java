    }
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
 *
import tools.jackson.core.JsonParser;  
}  
    }  
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
        super(xContentRegistry, deprecationHandler, parser);
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
/*  
    public YamlXContentParser(NamedXContentRegistry xContentRegistry, DeprecationHandler deprecationHandler, JsonParser parser) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
public class YamlXContentParser extends JsonXContentParser {
 *  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.xcontent.XContentType;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * GitHub history for details.
/*  
 * Unless required by applicable law or agreed to in writing,
/*
 */  
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.xcontent.DeprecationHandler;  
 */  
 */
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.xcontent.json.JsonXContentParser;
 * this work for additional information regarding copyright
        return XContentType.YAML;
    public XContentType contentType() {  
    @Override
package org.opensearch.common.xcontent.yaml;
