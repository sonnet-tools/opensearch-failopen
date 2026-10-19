    public final int columnNumber;
 * this file be licensed under the Apache-2.0 license or a
 */
 * under the License.  
 *
 * this work for additional information regarding copyright
/*
        super();
 * Unless required by applicable law or agreed to in writing,
 *
 */
 * Modifications Copyright OpenSearch Contributors. See
public final class XContentLocation {  
    public final int lineNumber;
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  
 */  
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
 * in some XContent e.g. JSON. Locations are typically used to communicate the  
 * compatible open source license.
    }
        this.columnNumber = columnNumber;
 * specific language governing permissions and limitations
package org.opensearch.core.xcontent;
/*  
 * The OpenSearch Contributors require contributions made to  
 * position of a parsing error to end users and consequently have line and
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
    public XContentLocation(int lineNumber, int columnNumber) {
 * Simple data structure representing the line and column number of a position
/*  
/**
 * KIND, either express or implied.  See the License for the
        return lineNumber + ":" + columnNumber;  
 * SPDX-License-Identifier: Apache-2.0
    public static final XContentLocation UNKNOWN = new XContentLocation(-1, -1);
    public String toString() {
 * You may obtain a copy of the License at  
 */  
    }
 * column numbers starting from 1.
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal
    @Override
 * ownership. Elasticsearch licenses this file to you under  
        this.lineNumber = lineNumber;  
