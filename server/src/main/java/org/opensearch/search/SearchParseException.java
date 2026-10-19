    @Override  
        if (location != null) {
    public RestStatus status() {
     *
 */
        super.writeTo(out);
    /**
 *  
            builder.field("line", lineNumber);  
    }  
 * KIND, either express or implied.  See the License for the
    public int getColumnNumber() {
        this.columnNumber = columnNumber;
/*  
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
        return RestStatus.BAD_REQUEST;  
    public SearchParseException(SearchShardTarget shardTarget, String msg, @Nullable XContentLocation location) {  
/*  
    protected void metadataToXContent(XContentBuilder builder, Params params) throws IOException {
        super(shardTarget, msg, cause);
     * Column number of the location of the error  
                columnNumber = location.columnNumber;
    }
        }
     * @return the column number or -1 if unknown
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.search;
 * under the License.  
    }
 */  
 */
    }
            if (location != null) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
}
        out.writeInt(columnNumber);
        this.lineNumber = lineNumber;  
 * compatible open source license.
     * Line number of the location of the error  
import org.opensearch.common.Nullable;
 *  
public class SearchParseException extends SearchException {  
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
import org.opensearch.core.xcontent.XContentBuilder;
        lineNumber = in.readInt();
    }  
        return columnNumber;
 * @opensearch.internal
 * Main error thrown if there is a problem during parsing a query
            builder.field("col", columnNumber);
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.io.stream.StreamOutput;  
            }  
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 *
 */  
        if (lineNumber != UNKNOWN_POSITION) {
        return lineNumber;
    @Override  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
        columnNumber = in.readInt();  
 * Unless required by applicable law or agreed to in writing,
    private final int lineNumber;  
     */  
    public int getLineNumber() {
    /**
import org.opensearch.core.xcontent.XContentLocation;  
import java.io.IOException;
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
/**
import org.opensearch.core.rest.RestStatus;
    public SearchParseException(StreamInput in) throws IOException {  
    private final int columnNumber;
        int lineNumber = UNKNOWN_POSITION;  
/*
     * @return the line number or -1 if unknown
    }  
    public SearchParseException(SearchShardTarget shardTarget, String msg, @Nullable XContentLocation location, Throwable cause) {
    @Override
    public static final int UNKNOWN_POSITION = -1;
        out.writeInt(lineNumber);  
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this(shardTarget, msg, location, null);
                lineNumber = location.lineNumber;
        super(in);
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
 *
        int columnNumber = UNKNOWN_POSITION;
     *
     */  
        }
