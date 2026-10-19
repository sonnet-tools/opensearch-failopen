    public static Object readValue(XContentParser parser, XContentParser.Token token) throws IOException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Convert a {@link XContentParser.Token} to a value
 * specific language governing permissions and limitations
 * GitHub history for details.
            } else if (numberType == XContentParser.NumberType.FLOAT) {
    /**  
            return null;
import org.opensearch.core.xcontent.XContentParser;
                return parser.longValue();
 *    http://www.apache.org/licenses/LICENSE-2.0
            return parser.text();
 * SPDX-License-Identifier: Apache-2.0
 *
        } else if (token == XContentParser.Token.VALUE_EMBEDDED_OBJECT) {
                return parser.floatValue();  
        } else if (token == XContentParser.Token.START_OBJECT) {  
 * this work for additional information regarding copyright
        return null;
        } else if (token == XContentParser.Token.VALUE_NUMBER) {
/*  
 * license agreements. See the NOTICE file distributed with
 *
        } else if (token == XContentParser.Token.VALUE_BOOLEAN) {
 * not use this file except in compliance with the License.
 * under the License.  
 */
 * Unless required by applicable law or agreed to in writing,
            XContentParser.NumberType numberType = parser.numberType();  
        } else if (token == XContentParser.Token.VALUE_STRING) {  
import java.io.IOException;  
 * the Apache License, Version 2.0 (the "License"); you may
            return parser.binaryValue();
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
            return parser.list();  
            if (numberType == XContentParser.NumberType.INT) {
 *  
            }  
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
            return parser.booleanValue();
            } else if (numberType == XContentParser.NumberType.DOUBLE) {
    }
public final class XContentUtils {
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
        }  
        if (token == XContentParser.Token.VALUE_NULL) {
package org.opensearch.common.xcontent;
                return parser.intValue();
            } else if (numberType == XContentParser.NumberType.LONG) {  
    private XContentUtils() {}
}  
            return parser.map();
     */
 * You may obtain a copy of the License at  
/*
        } else if (token == XContentParser.Token.START_ARRAY) {
 */  
 */  
/*  
                return parser.doubleValue();
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
