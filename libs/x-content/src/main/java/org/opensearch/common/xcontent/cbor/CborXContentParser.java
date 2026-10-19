        return XContentType.CBOR;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * this file be licensed under the Apache-2.0 license or a
 *
 */
}  
    public CborXContentParser(NamedXContentRegistry xContentRegistry, DeprecationHandler deprecationHandler, JsonParser parser) {
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
package org.opensearch.common.xcontent.cbor;
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
    public XContentType contentType() {  
 * under the License.  
import tools.jackson.core.JsonParser;  
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.DeprecationHandler;  
import org.opensearch.common.xcontent.json.JsonXContentParser;
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class CborXContentParser extends JsonXContentParser {
 * license agreements. See the NOTICE file distributed with
    }  
 * Licensed to Elasticsearch under one or more contributor  
    }
import org.opensearch.common.xcontent.XContentType;
 * KIND, either express or implied.  See the License for the
    @Override
/*
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 */  
 *  
        super(xContentRegistry, deprecationHandler, parser);
 * specific language governing permissions and limitations
 * compatible open source license.
/*  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
