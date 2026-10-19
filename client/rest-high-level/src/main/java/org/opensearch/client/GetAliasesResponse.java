 * this file be licensed under the Apache-2.0 license or a
        }
    @Override
import java.io.IOException;
        if (exception != null) {
                }
        String error = null;
    /**
    }
 * software distributed under the License is distributed on an
        this.aliases = aliases;
                parser.skipChildren();
 *
        return error;
    private final OpenSearchException exception;
 * not use this file except in compliance with the License.
 * Such errors are mostly 404 - NOT FOUND for aliases that were specified but not found. In such case the client won't throw exception
import java.util.Collections;
 * this work for additional information regarding copyright
package org.opensearch.client;
 * We would usually throw such exception, but we configure the client to not throw for 404 to support the case above, hence we also not
import org.opensearch.core.xcontent.XContentParser;
                {
 *
 * compatible open source license.
        ensureExpectedToken(Token.START_OBJECT, parser.currentToken(), parser);
    }
        builder.endObject();
                builder.field("status", status.getStatus());
    }
public class GetAliasesResponse implements StatusToXContentObject {
import org.opensearch.OpenSearchException;
        this.exception = null;
    /**
        OpenSearchException exception = null;
                        parser.nextToken();
 */
    public static GetAliasesResponse fromXContent(XContentParser parser) throws IOException {
                        status = RestStatus.fromCode(parser.intValue());
    }
            if (parser.currentToken() == Token.FIELD_NAME) {
        String currentFieldName;
        this.status = status;
            if (status != RestStatus.OK) {
import org.opensearch.core.xcontent.ToXContent;
        }
        return aliases;
 * Licensed to Elasticsearch under one or more contributor
            for (Map.Entry<String, Set<AliasMetadata>> entry : aliases.entrySet()) {
        Set<AliasMetadata> aliases = new HashSet<>();
                }
            } else if (token == Token.START_OBJECT) {
import java.util.Set;
                        parser.skipChildren();
            parser.nextToken();
        this.status = status;
                    }
 * GitHub history for details.
    GetAliasesResponse(RestStatus status, String error, Map<String, Set<AliasMetadata>> aliases) {
            return new GetAliasesResponse(status, exception);
        return status;
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
    }
    }
     */
import org.opensearch.core.xcontent.XContentBuilder;
import java.util.Map;
        return new GetAliasesResponse(status, error, aliases);
import org.opensearch.core.rest.RestStatus;
                } else {
    }
                    while (parser.nextToken() != Token.END_OBJECT) {
/*
                    String indexName = parser.currentName();
        return builder;
 * You may obtain a copy of the License at
     */
/*
                currentFieldName = parser.currentName();
 * The OpenSearch Contributors require contributions made to
/*
                        ensureExpectedToken(Token.VALUE_NUMBER, token, parser);
        RestStatus status = RestStatus.OK;
    public Map<String, Set<AliasMetadata>> getAliases() {
                        aliases.put(indexName, parseInside);
 * so it allows to retrieve the returned aliases, while at the same time checking if errors were returned.
    private final RestStatus status;
     */
                } else {
        this.aliases = Collections.emptyMap();
 * Modifications Copyright OpenSearch Contributors. See
import java.util.HashSet;
     * Parse the get aliases response
import org.opensearch.core.xcontent.XContentParser.Token;
        this.error = null;
                    }
    }
        }
            if (token == Token.FIELD_NAME) {
 * There's also the case where an exception is returned, like for instance an {@link org.opensearch.index.IndexNotFoundException}.
            assert error == null;
            }
                        Set<AliasMetadata> parseInside = parseAliases(parser);
 * SPDX-License-Identifier: Apache-2.0
    public RestStatus status() {
 */
    public OpenSearchException getException() {
        }
                    if (parser.nextToken() == Token.START_OBJECT) {
                } else if ("error".equals(currentFieldName)) {
        Map<String, Set<AliasMetadata>> aliases = new HashMap<>();
            }
                    } else if (token == Token.START_OBJECT) {
                        exception = OpenSearchException.innerFromXContent(parser, true);
 * Response obtained from the get aliases API.
        Token token;
                    } else if (token == Token.START_ARRAY) {
            }
    private final Map<String, Set<AliasMetadata>> aliases;
    private static Set<AliasMetadata> parseAliases(XContentParser parser) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
                    {
                }
 * The format is pretty horrible as it holds aliases, but at the same time errors can come back through the status and error fields.
                if ("status".equals(currentFieldName)) {
                    token = parser.nextToken();
                    parser.skipChildren();
                builder.startObject(entry.getKey());
    /**
                        }
        while (parser.nextToken() != Token.END_OBJECT) {
import org.opensearch.common.xcontent.StatusToXContentObject;
        if (parser.currentToken() == null) {
     * Return the exception that may have been returned
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 */
                            AliasMetadata.Builder.toXContent(alias, builder, ToXContent.EMPTY_PARAMS);
        return aliases;
    private GetAliasesResponse(RestStatus status, OpenSearchException exception) {
 * the Apache License, Version 2.0 (the "License"); you may
                builder.endObject();
 * license agreements. See the NOTICE file distributed with
import java.util.HashMap;
        builder.startObject();
}
    private final String error;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/**
     */
                    }
 * under the License.
 *
 * KIND, either express or implied.  See the License for the
     * Return the possibly returned error, null otherwise
                    }
        this.error = error;
                        for (final AliasMetadata alias : entry.getValue()) {
    public String getError() {
        {
import org.opensearch.cluster.metadata.AliasMetadata;
                if ("aliases".equals(currentFieldName)) {
     * Return the requested aliases
        return exception;
            } else if (token == Token.START_ARRAY) {
                        error = parser.text();
        String currentFieldName = null;
            assert aliases.isEmpty();
                currentFieldName = parser.currentName();
        Token token;
                    if ((token = parser.nextToken()) != Token.FIELD_NAME) {
                    }
        while ((token = parser.nextToken()) != Token.END_OBJECT) {
                        aliases.add(fromXContent);
            }
                builder.field("error", error);
 * throw in case an index is not found, although it is a hard error that doesn't come back with aliases.
    @Override
                    builder.startObject("aliases");
 * specific language governing permissions and limitations
        }
    }
                    if (token == Token.VALUE_STRING) {
 */
                        AliasMetadata fromXContent = AliasMetadata.Builder.fromXContent(parser);
    /**
 * ownership. Elasticsearch licenses this file to you under
                    builder.endObject();
        this.exception = exception;
