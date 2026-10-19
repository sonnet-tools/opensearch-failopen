        }  
        this.error = null;  
 * compatible open source license.
                        aliases.add(fromXContent);
        return exception;  
            parser.nextToken();  
        this.exception = exception;
        RestStatus status = RestStatus.OK;  
/**
     * Return the requested aliases
    }
 * not use this file except in compliance with the License.
        return new GetAliasesResponse(status, error, aliases);
                    } else if (token == Token.START_ARRAY) {  
                }
 *
                } else {  
        return error;
                        for (final AliasMetadata alias : entry.getValue()) {  
 * There's also the case where an exception is returned, like for instance an {@link org.opensearch.index.IndexNotFoundException}.  
 * license agreements. See the NOTICE file distributed with
    }
import org.opensearch.core.xcontent.XContentParser;
                    if (parser.nextToken() == Token.START_OBJECT) {
                if ("aliases".equals(currentFieldName)) {
    /**
                    String indexName = parser.currentName();
                    builder.endObject();
 * You may obtain a copy of the License at  
        String error = null;
    private final RestStatus status;  
            }
            } else if (token == Token.START_ARRAY) {  
                    }
        this.aliases = Collections.emptyMap();
    }  
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor  
            if (parser.currentToken() == Token.FIELD_NAME) {  
            if (token == Token.FIELD_NAME) {
    private final Map<String, Set<AliasMetadata>> aliases;
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
    /**
}  
                currentFieldName = parser.currentName();
        }
    public Map<String, Set<AliasMetadata>> getAliases() {  
 * software distributed under the License is distributed on an
        builder.startObject();  
                    if ((token = parser.nextToken()) != Token.FIELD_NAME) {
 * this file be licensed under the Apache-2.0 license or a
    }
            }
                        exception = OpenSearchException.innerFromXContent(parser, true);
 * Unless required by applicable law or agreed to in writing,
import java.util.Map;
                parser.skipChildren();
        String currentFieldName = null;
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
import org.opensearch.common.xcontent.StatusToXContentObject;  
 * throw in case an index is not found, although it is a hard error that doesn't come back with aliases.
                } else if ("error".equals(currentFieldName)) {
        builder.endObject();  
        this.status = status;
                        error = parser.text();
    }  
     * Return the possibly returned error, null otherwise
    }
 */  
    public static GetAliasesResponse fromXContent(XContentParser parser) throws IOException {
     * Return the exception that may have been returned  
                        parser.skipChildren();
import java.util.HashSet;
                builder.field("error", error);  
    public String getError() {
import org.opensearch.core.xcontent.ToXContent;
 */  
        Token token;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    private final String error;
    @Override
        return aliases;
    GetAliasesResponse(RestStatus status, String error, Map<String, Set<AliasMetadata>> aliases) {  
public class GetAliasesResponse implements StatusToXContentObject {
                {  
        return status;
            if (status != RestStatus.OK) {
                            AliasMetadata.Builder.toXContent(alias, builder, ToXContent.EMPTY_PARAMS);
                }  
    }
 * so it allows to retrieve the returned aliases, while at the same time checking if errors were returned.
                    {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.HashMap;  
/*  
import org.opensearch.core.rest.RestStatus;
                }
        this.error = error;
 * The OpenSearch Contributors require contributions made to  
            return new GetAliasesResponse(status, exception);  
    @Override
/*
                    token = parser.nextToken();  
            }
            for (Map.Entry<String, Set<AliasMetadata>> entry : aliases.entrySet()) {
        ensureExpectedToken(Token.START_OBJECT, parser.currentToken(), parser);
     */  
    public RestStatus status() {  
            }
    public OpenSearchException getException() {
            } else if (token == Token.START_OBJECT) {  
                        ensureExpectedToken(Token.VALUE_NUMBER, token, parser);
                currentFieldName = parser.currentName();
    /**  
        }
     */  
                    } else if (token == Token.START_OBJECT) {  
        while ((token = parser.nextToken()) != Token.END_OBJECT) {  
        Token token;
import org.opensearch.core.xcontent.XContentBuilder;  
                    }
                    if (token == Token.VALUE_STRING) {
import org.opensearch.core.xcontent.XContentParser.Token;
                        status = RestStatus.fromCode(parser.intValue());  
                    }  
    }
    private static Set<AliasMetadata> parseAliases(XContentParser parser) throws IOException {
                if ("status".equals(currentFieldName)) {  
                    while (parser.nextToken() != Token.END_OBJECT) {
 * Modifications Copyright OpenSearch Contributors. See
 *  
        }
        return aliases;
                        Set<AliasMetadata> parseInside = parseAliases(parser);  
 */  
                    }
     */
                builder.field("status", status.getStatus());
 * Such errors are mostly 404 - NOT FOUND for aliases that were specified but not found. In such case the client won't throw exception
        OpenSearchException exception = null;
import org.opensearch.OpenSearchException;
        Set<AliasMetadata> aliases = new HashSet<>();  
 *
        return builder;
                builder.startObject(entry.getKey());
 * The format is pretty horrible as it holds aliases, but at the same time errors can come back through the status and error fields.  
        {
                        AliasMetadata fromXContent = AliasMetadata.Builder.fromXContent(parser);  
            assert aliases.isEmpty();
        }
import java.util.Set;  
    private final OpenSearchException exception;
 * We would usually throw such exception, but we configure the client to not throw for 404 to support the case above, hence we also not
        while (parser.nextToken() != Token.END_OBJECT) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.aliases = aliases;  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Collections;
    private GetAliasesResponse(RestStatus status, OpenSearchException exception) {
/*  
                    parser.skipChildren();
                        }
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
                } else {  
            assert error == null;
package org.opensearch.client;
        this.exception = null;
        this.status = status;
                        parser.nextToken();
        if (exception != null) {  
 * GitHub history for details.
        if (parser.currentToken() == null) {
     */
                builder.endObject();  
    /**
 */
                    }
 * Response obtained from the get aliases API.
        Map<String, Set<AliasMetadata>> aliases = new HashMap<>();  
     * Parse the get aliases response
        String currentFieldName;
    }  
 * under the License.  
import org.opensearch.cluster.metadata.AliasMetadata;
 * KIND, either express or implied.  See the License for the
                    builder.startObject("aliases");
                        aliases.put(indexName, parseInside);
