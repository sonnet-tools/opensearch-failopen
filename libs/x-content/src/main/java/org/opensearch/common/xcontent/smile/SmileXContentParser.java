 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.common.xcontent.smile;
/*  
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 *
    @Override
 * Modifications Copyright OpenSearch Contributors. See
}  
import org.opensearch.core.xcontent.DeprecationHandler;  
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.xcontent.XContentType;
    public SmileXContentParser(NamedXContentRegistry xContentRegistry, DeprecationHandler deprecationHandler, JsonParser parser) {
import org.opensearch.common.xcontent.json.JsonXContentParser;
    }  
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * compatible open source license.
 */  
 *  
 * GitHub history for details.
        super(xContentRegistry, deprecationHandler, parser);
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
 *
 * not use this file except in compliance with the License.
import tools.jackson.core.JsonParser;  
    public XContentType contentType() {  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
        return XContentType.SMILE;
    }
/*
 */  
 * specific language governing permissions and limitations
public class SmileXContentParser extends JsonXContentParser {
 */
