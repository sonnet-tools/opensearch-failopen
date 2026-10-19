    /**
}
        );
    }  
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.NamedXContentRegistry;  
    public static Object load(String json) throws IOException {
 * You may obtain a copy of the License at  
            case VALUE_STRING:  
/*  
                return parser.booleanValue();
     * Write a JSON representable type as a string, optionally pretty print it by spanning multiple lines and indenting  
 * Licensed to Elasticsearch under one or more contributor  
            case VALUE_BOOLEAN:
            default:
                return parser.text();
 *    http://www.apache.org/licenses/LICENSE-2.0
                return parser.numberValue();  
 */
        }
    public static String dump(Object data, boolean pretty) throws IOException {
            return out.toString();
            case VALUE_NUMBER:
 *
     * Write a JSON representable type as a string
 * SPDX-License-Identifier: Apache-2.0
     */
import java.io.IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            case START_OBJECT:  
 */  
        }  
 *  
 */  
        return dump(data, false);
 * The OpenSearch Contributors require contributions made to  
                return null;  
 * specific language governing permissions and limitations
        builder.flush();
 * the Apache License, Version 2.0 (the "License"); you may
 *
            json  
                return parser.list();
import java.io.OutputStream;
 * KIND, either express or implied.  See the License for the
/*  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
     * Load a string as the Java version of a JSON type, either List (JSON array), Map (JSON object), Number, Boolean or String  
import org.opensearch.common.xcontent.json.JsonXContent;
package org.opensearch.painless.api;
                return parser.map();
 * Unless required by applicable law or agreed to in writing,
    }  
    /**
     */
 * GitHub history for details.
     */  
    /**
            case START_ARRAY:
            NamedXContentRegistry.EMPTY,
 * Modifications Copyright OpenSearch Contributors. See
    }
 * ownership. Elasticsearch licenses this file to you under  
        builder.value(data);
        switch (parser.nextToken()) {  
public class Json {
import org.opensearch.core.xcontent.DeprecationHandler;
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.XContentParser;
        if (pretty) {
import org.opensearch.core.xcontent.XContentBuilder;
            builder.prettyPrint();
        }
    public static String dump(Object data) throws IOException {
            DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
 * under the License.  
/*
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
        try (OutputStream out = builder.getOutputStream()) {  
        XContentBuilder builder = JsonXContent.contentBuilder();  
        XContentParser parser = JsonXContent.jsonXContent.createParser(  
