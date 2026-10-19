            }
            && Objects.equals(getCause(), that.getCause())
            } else if (token == XContentParser.Token.START_ARRAY) {
                    }  
        List<OpenSearchException> suppressed = new ArrayList<>();
    }
        this.msg = msg;
    public Map<String, List<String>> getHeaders() {
                            } else if (token == XContentParser.Token.START_ARRAY) {
            if (token.isValue()) {
    private static final String STACK_TRACE = "stack_trace";
    void addSuppressed(List<OpenSearchException> suppressed) {  
        message.append(TYPE).append('=').append(type).append(", ");
            e.addHeader(header.getKey(), header.getValue());  
            String currentFieldName = parser.currentName();
            } else if (token == XContentParser.Token.START_OBJECT) {  
 * license agreements. See the NOTICE file distributed with
                                    if (token == XContentParser.Token.VALUE_STRING) {
        // Adds root causes as suppressed exception. This way they are not lost  
        headers.put(key, value);  
    }  
                                while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        OpenSearchException that = (OpenSearchException) o;
            + "msg='"
public class OpenSearchException {
        Map<String, List<String>> headers = new HashMap<>();
 * SPDX-License-Identifier: Apache-2.0
    private static final ParseField SUPPRESSED = new ParseField("suppressed");
 * this work for additional information regarding copyright
                            parser.skipChildren();  
     */
    private static final String TYPE = "type";
    /**
 * software distributed under the License is distributed on an
     * Generate a {@link OpenSearchException} from a {@link XContentParser}. This does not
                    reason = parser.text();
            + headers
        }
        return "OpenSearchException{"
import org.opensearch.core.xcontent.XContentParser;
 * client side counterpart of server side
 * GitHub history for details.
                } else {
            + '\''
    }
            token = parser.nextToken();
/*  
        for (Map.Entry<String, List<String>> header : headers.entrySet()) {
    }  
        this.cause = null;
                    type = parser.text();  
        return innerFromXContent(parser, false);
        for (; token == XContentParser.Token.FIELD_NAME; token = parser.nextToken()) {  
            && Objects.equals(getHeaders(), that.getHeaders())
 * specific language governing permissions and limitations
    public int hashCode() {
 * Modifications Copyright OpenSearch Contributors. See  
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
        this.cause = cause;  
 *
    OpenSearchException(String msg, OpenSearchException cause) {
                    }
                        suppressed.add(fromXContent(parser));
                                }  
 * ownership. Elasticsearch licenses this file to you under  
                } else if (REASON.equals(currentFieldName)) {
        this.msg = msg;  
                            headers.put(currentFieldName, values);
    private static final String HEADER = "header";  
    }  
    public String getMsg() {  
                }  
import java.util.List;  
            && Objects.equals(getSuppressed(), that.getSuppressed());  
     * tree structure of the cause, returning it as a tree structure of {@link OpenSearchException}
            + msg  
                            }  
import java.io.IOException;  
                    }  
import java.util.Objects;
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                        rootCauses.add(fromXContent(parser));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    // support metadata key-pairs and metadata arrays of values.
            + ", suppressed="  
 * It wraps the same content but it is not throwable.  
    private static OpenSearchException innerFromXContent(XContentParser parser, boolean parseRootCauses) throws IOException {
                        }
    void addHeader(String key, List<String> value) {
                } else if (SUPPRESSED.match(currentFieldName, parser.getDeprecationHandler())) {  
                }  
        List<OpenSearchException> rootCauses = new ArrayList<>();  
        return e;
                                        parser.skipChildren();
                }
    }
    private static final String CAUSED_BY = "caused_by";  
    }
    }  
/*
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
            + ", headers="
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
                    stack = parser.text();
                                parser.skipChildren();
    }
 * under the License.  
     * instances.  
        }
    public OpenSearchException getCause() {
 * Unless required by applicable law or agreed to in writing,
        message.append(']');  
                            if (token == XContentParser.Token.VALUE_STRING) {  
     * the type, the reason and the cause of the exception. It also recursively parses the
 * the Apache License, Version 2.0 (the "License"); you may
    }  
                } else if (HEADER.equals(currentFieldName)) {  
    public List<OpenSearchException> getSuppressed() {
        OpenSearchException cause = null;
    }
    public String toString() {  
                } else if (STACK_TRACE.equals(currentFieldName)) {  
        if (this == o) return true;  
     * return the original exception type (ie NodeClosedException for example) but just wraps  
        return cause;
}
        return headers;
            + '}';
 * The OpenSearch Contributors require contributions made to  
            + cause  
        return suppressed;  
        return Objects.hash(getMsg(), getCause(), getHeaders(), getSuppressed());
        return message.toString();
    @Override  
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
 */
                        if (token == XContentParser.Token.VALUE_STRING) {  
            + ", cause="
                                        values.add(parser.text());
        StringBuilder message = new StringBuilder("OpenSearch exception [");  
            message.append(", ").append(STACK_TRACE).append('=').append(stack);
    private static final String ROOT_CAUSE = "root_cause";
 * this file be licensed under the Apache-2.0 license or a
        String type = null, reason = null, stack = null;  
                            List<String> values = headers.getOrDefault(currentFieldName, new ArrayList<>());
                            values.add(parser.text());
        this.suppressed.addAll(suppressed);
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
        OpenSearchException e = new OpenSearchException(buildMessage(type, reason, stack), cause);
 * not use this file except in compliance with the License.
    public boolean equals(Object o) {
    private static final String REASON = "reason";
        // after parsing and can be retrieved using getSuppressed() method.
import java.util.HashMap;
                    // Parse the array and add each item to the corresponding list of metadata.
        if (stack != null) {  
    private String msg;  
 * Licensed to Elasticsearch under one or more contributor  
                    // Arrays of objects are not supported yet and just ignored and skipped.  
    OpenSearchException(String msg) {
    static String buildMessage(String type, String reason, String stack) {
        }
                            currentFieldName = parser.currentName();  
        return msg;
                        } else {
 *
 */
 * {@link org.opensearch.OpenSearchException}
    private OpenSearchException cause;
                    }
            + suppressed
                    // and skipped, so that the parser does not fail on unknown fields. The parser only  
    @Override
                    cause = fromXContent(parser);
    }
                        if (token == XContentParser.Token.FIELD_NAME) {
                    // Any additional metadata object added by the metadataToXContent method is ignored
                if (parseRootCauses && ROOT_CAUSE.equals(currentFieldName)) {
                            } else if (token == XContentParser.Token.START_OBJECT) {
        XContentParser.Token token = parser.currentToken();  
 * compatible open source license.
    }  
import org.opensearch.core.ParseField;  
    private final List<OpenSearchException> suppressed = new ArrayList<>();  
                if (TYPE.equals(currentFieldName)) {
package org.opensearch.client.tasks;
        e.suppressed.addAll(rootCauses);
        if (!(o instanceof OpenSearchException)) return false;
                if (CAUSED_BY.equals(currentFieldName)) {
 */
                } else {
                    List<String> values = new ArrayList<>();
import java.util.ArrayList;
    private final Map<String, List<String>> headers = new HashMap<>();
/**  
 *  
                                    }
    static OpenSearchException fromXContent(XContentParser parser) throws IOException {
        e.suppressed.addAll(suppressed);  
 * KIND, either express or implied.  See the License for the
        return Objects.equals(getMsg(), that.getMsg())  
    }
                                    } else {  
    @Override
        message.append(REASON).append('=').append(reason);
                    parser.skipChildren();
/*
import java.util.Map;
        XContentParser.Token token = parser.nextToken();  
                        } else {
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
 * You may obtain a copy of the License at  
 */  
                                values.add(parser.text());
                        }
