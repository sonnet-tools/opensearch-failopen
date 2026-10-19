 */
    public int getLineNumber() {
 *
        this(null, message);
public class XContentParseException extends IllegalArgumentException {
/*  
import java.util.Optional;  
 * software distributed under the License is distributed on an
    private final Optional<XContentLocation> location;
 * license agreements. See the NOTICE file distributed with
}
package org.opensearch.core.xcontent;
    }  
        super(message, cause);
 * under the License.  
        return location.orElse(null);  
    @Nullable
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 *
    @Override  
/*  
 * specific language governing permissions and limitations
    public XContentLocation getLocation() {
        this.location = Optional.ofNullable(location);  
 * Licensed to Elasticsearch under one or more contributor  
        return location.map(l -> "[" + l.toString() + "] ").orElse("") + super.getMessage();
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
 */  
 * GitHub history for details.
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
        this.location = Optional.ofNullable(location);
    public XContentParseException(String message) {  
    }  
        super(message);
 * Unless required by applicable law or agreed to in writing,
        return location.map(l -> l.columnNumber).orElse(-1);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 */
/**
    public String getMessage() {
    }
 * not use this file except in compliance with the License.
        return location.map(l -> l.lineNumber).orElse(-1);  
 * this file be licensed under the Apache-2.0 license or a
/*
    }
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public int getColumnNumber() {  
    public XContentParseException(XContentLocation location, String message, Exception cause) {  
    }
    public XContentParseException(XContentLocation location, String message) {
 * Thrown when one of the XContent parsers cannot parse something.  
    }
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.Nullable;
