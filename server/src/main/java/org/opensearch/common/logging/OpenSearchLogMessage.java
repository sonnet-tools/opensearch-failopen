 * A base class for custom log4j logger messages. Carries additional fields which will populate JSON fields in logs.  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
}
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
@SuppressLoggerChecks(reason = "Safe as this is abstract class")
     * This is an abstract class, so this is safe. The check is done on DeprecationMessage.  
        return "[" + stream.map(OpenSearchLogMessage::inQuotes).collect(Collectors.joining(", ")) + "]";  
 *
/*  
        this.fields = fields;
        return "\"" + s + "\"";  
 * this work for additional information regarding copyright
import org.apache.logging.log4j.message.ParameterizedMessage;
 */
    public static String asJsonArray(Stream<String> stream) {
 *  
    public OpenSearchLogMessage(Map<String, Object> fields, String messagePattern, Object... args) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return super.getParameters();
    private final Map<String, Object> fields;  
    public String getValueFor(String key) {
    }  
 * SPDX-License-Identifier: Apache-2.0
        Object value = fields.get(key);  
 * @opensearch.internal
    }
 * The OpenSearch Contributors require contributions made to  
    public Object[] getArguments() {  
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.common.logging;
 * software distributed under the License is distributed on an
 * compatible open source license.
public abstract class OpenSearchLogMessage extends ParameterizedMessage {
        return inQuotes(s.toString());
    }  
    }
 */  
 * not use this file except in compliance with the License.
        return super.getFormat();
    public static String inQuotes(String s) {
        super(messagePattern, args);
     * Other subclasses are not allowing varargs
    /**
/*
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.SuppressLoggerChecks;
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
    public String getMessagePattern() {
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.Map;
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
import java.util.stream.Collectors;
import java.util.stream.Stream;  
 *
/*  
    }
     */
        if (s == null) return inQuotes("");
        return value != null ? value.toString() : null;
 */  
    public static String inQuotes(Object s) {  
    }
/**
        if (s == null) return inQuotes("");
 * this file be licensed under the Apache-2.0 license or a
    }  
 *
 * KIND, either express or implied.  See the License for the
