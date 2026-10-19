 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.collect.Tuple;
        String field = parser.text();  
        if (token == XContentParser.Token.START_OBJECT) {
        // we are in the beginning, haven't called nextToken yet
 * compatible open source license.
 * specific language governing permissions and limitations
        if (map.size() != 1) {  
        parser.nextToken();
        Map.Entry<String, Object> entry = map.entrySet().iterator().next();
        if (token != XContentParser.Token.FIELD_NAME) {
        }
    public static Tuple<String, Object> parseTuple(XContentParser parser) throws IOException {
        advanceToFieldName(parser);
    public static void advanceToFieldName(XContentParser parser) throws IOException {
            token = parser.nextToken();  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
    private ParserUtils() {
 * Licensed to Elasticsearch under one or more contributor  
        parser.nextToken();
 * You may obtain a copy of the License at  
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;
            );
 * Modifications Copyright OpenSearch Contributors. See
        if (token == null) {
 * under the License.  
/*  
import org.opensearch.core.xcontent.XContentParser;
            token = parser.nextToken();  
 * this work for additional information regarding copyright
 */
        parser.nextToken();  
 * this file be licensed under the Apache-2.0 license or a
 *  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
    }  
 *
package org.opensearch.test.rest.yaml.section;
        return field;
        }
        assert parser.currentToken() == XContentParser.Token.END_OBJECT;  
    public static String parseField(XContentParser parser) throws IOException {  
 */  
        if (token == XContentParser.Token.START_ARRAY) {
        XContentParser.Token token = parser.currentToken();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Map<String, Object> map = parser.map();
}
 * ownership. Elasticsearch licenses this file to you under  
        }  
 */  
    }  
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
        // Do not build.  
        }
        return Tuple.tuple(entry.getKey(), entry.getValue());
            throw new IllegalArgumentException("expected key value pair but found an object with " + map.size() + " fields");
        assert parser.currentToken().isValue();
    }
 *
/**
    }
 */  
/*
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.Map;
        parser.nextToken();
class ParserUtils {
            token = parser.nextToken();  
 * Utility methods used for parsing test sections.
        }
            throw new IllegalArgumentException(  
                "malformed test section: field name expected but found " + token + " at " + parser.getTokenLocation()
