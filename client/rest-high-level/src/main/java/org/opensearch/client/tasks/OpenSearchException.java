        XContentParser.Token token = parser.currentToken();
                            } else if (token == XContentParser.Token.START_OBJECT) {
        return suppressed;
        OpenSearchException cause = null;
        e.suppressed.addAll(suppressed);
    }
            String currentFieldName = parser.currentName();
                    }
        Map<String, List<String>> headers = new HashMap<>();
 *
    }
        message.append(']');
        if (this == o) return true;
    }
                if (CAUSED_BY.equals(currentFieldName)) {
                    // Arrays of objects are not supported yet and just ignored and skipped.
        }
 */
                        if (token == XContentParser.Token.VALUE_STRING) {
        headers.put(key, value);
public class OpenSearchException {
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
        return Objects.hash(getMsg(), getCause(), getHeaders(), getSuppressed());
                                    }
                                        parser.skipChildren();
            + '}';
 * ownership. Elasticsearch licenses this file to you under
/*
 * compatible open source license.
            }
                }
                            headers.put(currentFieldName, values);
package org.opensearch.client.tasks;
import java.util.Map;
            + headers
        if (stack != null) {
                        }
                        suppressed.add(fromXContent(parser));
    }
                } else {
        return e;
    }
    OpenSearchException(String msg) {
            e.addHeader(header.getKey(), header.getValue());
        String type = null, reason = null, stack = null;
    static String buildMessage(String type, String reason, String stack) {
 * license agreements. See the NOTICE file distributed with
        OpenSearchException that = (OpenSearchException) o;
    private String msg;
        this.cause = cause;
            + ", cause="
    private static final String TYPE = "type";
                if (parseRootCauses && ROOT_CAUSE.equals(currentFieldName)) {
                        } else {
 * software distributed under the License is distributed on an
import java.util.ArrayList;
    @Override
/**
                                parser.skipChildren();
    }
                    }
            && Objects.equals(getHeaders(), that.getHeaders())
     * return the original exception type (ie NodeClosedException for example) but just wraps
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
            token = parser.nextToken();
    }
                            values.add(parser.text());
                    type = parser.text();
 *
            && Objects.equals(getSuppressed(), that.getSuppressed());
                } else if (REASON.equals(currentFieldName)) {
import java.util.List;
    }
                            parser.skipChildren();
    }
    private final List<OpenSearchException> suppressed = new ArrayList<>();
    }
                        } else {
            + '\''
    OpenSearchException(String msg, OpenSearchException cause) {
import java.util.HashMap;
        message.append(REASON).append('=').append(reason);
 * {@link org.opensearch.OpenSearchException}
    public List<OpenSearchException> getSuppressed() {
            message.append(", ").append(STACK_TRACE).append('=').append(stack);
 *
                }
    void addHeader(String key, List<String> value) {
                                values.add(parser.text());
        XContentParser.Token token = parser.nextToken();
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
    }
                } else if (HEADER.equals(currentFieldName)) {
 * this work for additional information regarding copyright
 */
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
 * not use this file except in compliance with the License.
}
    public Map<String, List<String>> getHeaders() {
        this.suppressed.addAll(suppressed);
    }
                                    if (token == XContentParser.Token.VALUE_STRING) {
        OpenSearchException e = new OpenSearchException(buildMessage(type, reason, stack), cause);
 * specific language governing permissions and limitations
        if (!(o instanceof OpenSearchException)) return false;
        return cause;
                    // Parse the array and add each item to the corresponding list of metadata.
                } else if (STACK_TRACE.equals(currentFieldName)) {
 * GitHub history for details.
                }
    /**
        }
        return message.toString();
/*
    private static OpenSearchException innerFromXContent(XContentParser parser, boolean parseRootCauses) throws IOException {
            + ", headers="
        List<OpenSearchException> suppressed = new ArrayList<>();
        StringBuilder message = new StringBuilder("OpenSearch exception [");
                        rootCauses.add(fromXContent(parser));
                    parser.skipChildren();
            + cause
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
            if (token.isValue()) {
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
        for (; token == XContentParser.Token.FIELD_NAME; token = parser.nextToken()) {
    void addSuppressed(List<OpenSearchException> suppressed) {
    public OpenSearchException getCause() {
                    cause = fromXContent(parser);
    private static final String STACK_TRACE = "stack_trace";
                            List<String> values = headers.getOrDefault(currentFieldName, new ArrayList<>());
                    // Any additional metadata object added by the metadataToXContent method is ignored
     * the type, the reason and the cause of the exception. It also recursively parses the
 * SPDX-License-Identifier: Apache-2.0
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            && Objects.equals(getCause(), that.getCause())
 * Licensed to Elasticsearch under one or more contributor
    @Override
import java.io.IOException;
    private static final String ROOT_CAUSE = "root_cause";
                                }
                    List<String> values = new ArrayList<>();
                    // and skipped, so that the parser does not fail on unknown fields. The parser only
    @Override
    private static final String CAUSED_BY = "caused_by";
                            }
                            currentFieldName = parser.currentName();
        e.suppressed.addAll(rootCauses);
                        }
        return Objects.equals(getMsg(), that.getMsg())
            + suppressed
 */
 * client side counterpart of server side
import org.opensearch.core.xcontent.XContentParser;
        this.msg = msg;
                    stack = parser.text();
            + ", suppressed="
        for (Map.Entry<String, List<String>> header : headers.entrySet()) {
        return headers;
        message.append(TYPE).append('=').append(type).append(", ");
 */
                    }
    static OpenSearchException fromXContent(XContentParser parser) throws IOException {
                                while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
/*
                                        values.add(parser.text());
        }
    private final Map<String, List<String>> headers = new HashMap<>();
     * Generate a {@link OpenSearchException} from a {@link XContentParser}. This does not
    public int hashCode() {
     */
 * The OpenSearch Contributors require contributions made to
    private OpenSearchException cause;
                } else {
    }
                if (TYPE.equals(currentFieldName)) {
                    }
 * You may obtain a copy of the License at
    private static final ParseField SUPPRESSED = new ParseField("suppressed");
        return innerFromXContent(parser, false);
            + msg
                } else if (SUPPRESSED.match(currentFieldName, parser.getDeprecationHandler())) {
    public String toString() {
                            } else if (token == XContentParser.Token.START_ARRAY) {
    }
 * the Apache License, Version 2.0 (the "License"); you may
        // after parsing and can be retrieved using getSuppressed() method.
 * under the License.
        List<OpenSearchException> rootCauses = new ArrayList<>();
        this.msg = msg;
        this.cause = null;
        return "OpenSearchException{"
import java.util.Objects;
 * It wraps the same content but it is not throwable.
     * tree structure of the cause, returning it as a tree structure of {@link OpenSearchException}
                    reason = parser.text();
    public boolean equals(Object o) {
                        if (token == XContentParser.Token.FIELD_NAME) {
            + "msg='"
                    // support metadata key-pairs and metadata arrays of values.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
import org.opensearch.core.ParseField;
            } else if (token == XContentParser.Token.START_OBJECT) {
        return msg;
     * instances.
                            if (token == XContentParser.Token.VALUE_STRING) {
    private static final String HEADER = "header";
                                    } else {
        // Adds root causes as suppressed exception. This way they are not lost
 * this file be licensed under the Apache-2.0 license or a
    private static final String REASON = "reason";
    public String getMsg() {
            } else if (token == XContentParser.Token.START_ARRAY) {
