        this.columnNumber = col;
    public ParsingException(int line, int col, String msg, Throwable cause) {
package org.opensearch.core.common;
 *     http://www.apache.org/licenses/LICENSE-2.0
    public ParsingException(XContentLocation contentLocation, String msg, Object... args) {  
 * GitHub history for details.
    public RestStatus status() {  
        super(msg, cause);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
        out.writeInt(columnNumber);
    public void writeTo(StreamOutput out) throws IOException {
     *
    /**
        if (contentLocation != null) {
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
        if (lineNumber != UNKNOWN_POSITION) {  
 * The OpenSearch Contributors require contributions made to  
     * This constructor is provided for use in unit tests where a
    }  
     * Column number of the location of the error  
 *  
import org.opensearch.core.common.io.stream.StreamOutput;  
        this.columnNumber = columnNumber;  
 * Exception that can be used when parsing queries with a given {@link  
    private final int columnNumber;
 */
    @Override  
        return columnNumber;
import org.opensearch.core.common.io.stream.StreamInput;
        this.lineNumber = lineNumber;
    }
import org.opensearch.OpenSearchException;
     * {@link XContentParser} may not be available  
        this(contentLocation, msg, null, args);
        this.lineNumber = line;
 * specific language governing permissions and limitations
        out.writeInt(lineNumber);  
     */  
            lineNumber = contentLocation.lineNumber;  
     * Line number of the location of the error  
 */  
     * @return the column number or -1 if unknown
    }  
    @Override
 * Can contain information about location of the error.
    public int getLineNumber() {
            builder.field("line", lineNumber);
import org.opensearch.core.rest.RestStatus;
        columnNumber = in.readInt();
/**
    }
import org.opensearch.core.xcontent.XContentLocation;  
 * XContentParser}.
import org.opensearch.core.xcontent.XContentBuilder;
 * Modifications Copyright OpenSearch Contributors. See
        super(in);  
        int lineNumber = UNKNOWN_POSITION;  
        super(msg, cause, args);
    public int getColumnNumber() {
        return lineNumber;
    /**
    }
        }  
            columnNumber = contentLocation.columnNumber;
/*  
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
/*  
import java.io.IOException;  
import org.opensearch.core.xcontent.XContentParser;
}  
     * @return the line number or -1 if unknown
 * ownership. Elasticsearch licenses this file to you under  
    private final int lineNumber;  
public class ParsingException extends OpenSearchException {  
 * license agreements. See the NOTICE file distributed with
        int columnNumber = UNKNOWN_POSITION;
        lineNumber = in.readInt();
 * @opensearch.internal
     */  
/*
    public static final int UNKNOWN_POSITION = -1;
 */  
    public ParsingException(StreamInput in) throws IOException {
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
    }  
 * Licensed to Elasticsearch under one or more contributor  
    /**
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
     */
    protected void metadataToXContent(XContentBuilder builder, Params params) throws IOException {
     *
        return RestStatus.BAD_REQUEST;
            builder.field("col", columnNumber);
 * this work for additional information regarding copyright
        super.writeTo(out);
    }  
    }
    @Override
    }
    public ParsingException(XContentLocation contentLocation, String msg, Throwable cause, Object... args) {
 *
 * under the License.  
 *  
 *
        }
