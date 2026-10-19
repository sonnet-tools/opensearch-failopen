 * SPDX-License-Identifier: Apache-2.0
        return new GetSourceResponse(parser.map());  
package org.opensearch.client.core;
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 */  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Map;
        return source.toString();  
        this.source = source;
 */
 * Unless required by applicable law or agreed to in writing,
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;  
    }
 */  
 *
        return this.source;
 *  
    public Map<String, Object> getSource() {  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
public final class GetSourceResponse {  
    private final Map<String, Object> source;
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
}
import org.opensearch.core.xcontent.XContentParser;
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
    }
 * not use this file except in compliance with the License.
    public static GetSourceResponse fromXContent(XContentParser parser) throws IOException {
    @Override
    public String toString() {
    }
    public GetSourceResponse(Map<String, Object> source) {
/*
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
