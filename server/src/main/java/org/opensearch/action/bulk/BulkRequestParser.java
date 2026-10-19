                                ifPrimaryTerm = parser.longValue();
            // now parse the action
                                );
                        } else if (token == XContentParser.Token.START_OBJECT
import org.opensearch.action.index.IndexRequest;
    private static final ParseField ID = new ParseField("_id");
                            } else if (ID.match(currentFieldName, parser.getDeprecationHandler())) {
                }
    private static int findNextMarker(byte marker, int from, BytesReference data) {
                    }
 *
            NamedXContentRegistry.EMPTY,
                }
        int line = 0;
                return xContent.createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, slice.streamInput());
                String opType = null;
        @Nullable Boolean defaultRequireAlias,
                                    + line
                            );
                                retryOnConflict = parser.intValue();
            if (slice instanceof BytesArray) {
                                    .setRequireAlias(requireAlias)
                                .routing(routing)
    }
                String action = parser.currentName();
                // Move to START_OBJECT
                                    .source(sliceTrimmingCarriageReturn(data, from, nextMarker, mediaType), mediaType)
    public void parse(
                                requireAlias = parser.booleanValue();
                if (token != XContentParser.Token.FIELD_NAME) {
                        if (version != Versions.MATCH_ANY || versionType != VersionType.INTERNAL) {
                VersionType versionType = VersionType.INTERNAL;
 * not use this file except in compliance with the License.
import java.util.function.Function;
                // Move to FIELD_NAME, that's the action
                            }
        }
        int from = 0;
    // Create an efficient parser of the given bytes, trying to directly parse a byte array if possible and falling back to stream wrapping
 */
            try (XContentParser parser = createParser(data, xContent, from, nextMarker)) {
    private static XContentParser parseBytesArray(XContent xContent, BytesArray array, int from, int nextMarker) throws IOException {
                return parseBytesArray(xContent, (BytesArray) slice, 0, length);
                    }
                // or START_OBJECT which will have another set of parameters
                        break;
 * specific language governing permissions and limitations
                            + action
                            + " but found ["
                            + token
            int nextMarker = findNextMarker(marker, from, data);
    private static final ParseField INDEX = new ParseField("_index");
import org.opensearch.core.xcontent.XContent;
 * under the License.
                                .setIfPrimaryTerm(ifPrimaryTerm)
                        ) {
                                    .setPipeline(pipeline)
                        }
                            + line
                                versionType = VersionType.fromString(parser.text());
                        }
            length = nextMarker - from;
        Consumer<IndexRequest> indexRequestConsumer,
                        "Malformed action/metadata line ["
        @Nullable String defaultPipeline,
import org.opensearch.action.DocWriteRequest;
                if (token == null) {
                                fetchSourceContext = FetchSourceContext.fromXContent(parser);
                            + "], expected one of [create, delete, index, update] but found ["
 * this work for additional information regarding copyright
                                        + token
                            + "]"
                                pipeline = stringDeduplicator.computeIfAbsent(parser.text(), Function.identity());
import org.opensearch.core.xcontent.NamedXContentRegistry;
                            if (INDEX.match(currentFieldName, parser.getDeprecationHandler())) {
        if (data instanceof BytesArray) {
/*
                            indexRequestConsumer.accept(
                        if (opType == null) {
            }
/*
            final int length = nextMarker - from;
        @Nullable String defaultIndex,
                                    .setPipeline(pipeline)
                            + line
                            } else if (ROUTING.match(currentFieldName, parser.getDeprecationHandler())) {
 * SPDX-License-Identifier: Apache-2.0
                    throw new IllegalArgumentException(
     * {@code updateRequestConsumer} and delete requests to the {@code deleteRequestConsumer}.
                        } else if (token == XContentParser.Token.START_ARRAY) {
        return bytesReference.slice(from, length);
                            .routing(routing)
                            + XContentParser.Token.END_OBJECT
                                    + "]"
                    );
                    throw new IllegalArgumentException(
 */
                                .setIfSeqNo(ifSeqNo)
                            } else if (REQUIRE_ALIAS.match(currentFieldName, parser.getDeprecationHandler())) {
                        }
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
                    } else if ("update".equals(action)) {
                                        + "] but found ["
}
                            .setIfSeqNo(ifSeqNo)
        );
                        );
                                        + "], expected a simple value for field ["
                                        + currentFieldName
                            .version(version)
        @Nullable String defaultRouting,
                            .routing(routing);
    /**
        while (true) {
                                fetchSourceContext = FetchSourceContext.fromXContent(parser);
        Consumer<UpdateRequest> updateRequestConsumer,
    private static final ParseField VERSION_TYPE = new ParseField("version_type");
 *
import org.opensearch.common.xcontent.XContentType;
        } else {
                if (action == null || VALID_ACTIONS.contains(action) == false) {
                            + XContentParser.Token.START_OBJECT
                boolean requireAlias = defaultRequireAlias != null && defaultRequireAlias;
import org.opensearch.core.xcontent.MediaType;
                from = nextMarker + 1;
                                        + line
 * software distributed under the License is distributed on an
    private static final ParseField SOURCE = new ParseField("_source");
            } else {
        // reduces their lifetime to the lifetime of this parse call instead of the lifetime of the full bulk request.
                break;
    private static final ParseField IF_PRIMARY_TERM = new ParseField("if_primary_term");
import java.util.function.Consumer;
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        if (data instanceof BytesArray) {
                            + "], expected "
                } else if (token != XContentParser.Token.END_OBJECT) {
                int retryOnConflict = 0;
     */
                        IndexRequest upsertRequest = updateRequest.upsertRequest();
    private static final ParseField ROUTING = new ParseField("routing");
                            throw new IllegalArgumentException(
        }
                                    .create("create".equals(opType))
                            + " but found ["
            array.array(),
        if (res != -1) {
                                sliceTrimmingCarriageReturn(data, from, nextMarker, mediaType),
                                routing = stringDeduplicator.computeIfAbsent(parser.text(), Function.identity());
                            .setIfPrimaryTerm(ifPrimaryTerm)
                            .routing(routing)
        }
        } else {
                                id = parser.text();
                // EMPTY is safe here because we never call namedObject
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.core.xcontent.XContentParser;
                                    .source(sliceTrimmingCarriageReturn(data, from, nextMarker, mediaType), mediaType)
            }
                // move pointers
        int from,
        final Map<String, String> stringDeduplicator = new HashMap<>();
     * Returns the sliced {@link BytesReference}. If the {@link XContentType} is JSON, the byte preceding the marker is checked to see
                                    .setRequireAlias(requireAlias)
import java.util.Map;
 * Helper to parse bulk requests. This should be considered an internal class.
                                ifSeqNo = parser.longValue();
                                    .version(version)
            return xContent.createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, data.streamInput());
    // otherwise.
            final BytesReference slice = data.slice(from, length);
                        new DeleteRequest(index).id(id)
        XContent xContent = mediaType.xContent();
                if (token == XContentParser.Token.START_OBJECT) {
     * Parse the provided {@code data} assuming the provided default values. Index requests
    }
                    line++;
import org.opensearch.core.common.bytes.BytesReference;
                                .version(version)
                            } else {
        final int offset = array.offset();
                if ("delete".equals(action)) {
 */
            offset + from,
            length = nextMarker - from - 1;
        Consumer<DeleteRequest> deleteRequestConsumer
                            currentFieldName = parser.currentName();
                FetchSourceContext fetchSourceContext = defaultFetchSourceContext;
    }
                XContentParser.Token token = parser.nextToken();
                                    "Malformed action/metadata line ["
                            } else if (IF_SEQ_NO.match(currentFieldName, parser.getDeprecationHandler())) {
                    );
        byte marker = xContent.streamSeparator();
                                if (allowExplicitIndex == false) {
    }
        // EMPTY is safe here because we never call namedObject
                            .retryOnConflict(retryOnConflict)
        final int res = data.indexOf(marker, from);
                                "Update requests do not support versioning. " + "Please use `if_seq_no` and `if_primary_term` instead"
                            .setIfSeqNo(ifSeqNo)
 *
                    );
                }
    private static final ParseField OP_TYPE = new ParseField("op_type");
            assert res >= 0;
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * this file be licensed under the Apache-2.0 license or a
            }
                            } else if (token != XContentParser.Token.VALUE_NULL) {
                            );
        } else {
                            .id(id)
        return res;
    ) {
                    if (nextMarker == -1) {
                                .create(true)
        MediaType mediaType,
    ) throws IOException {
                            + line
                                    .versionType(versionType)
                                    .setIfPrimaryTerm(ifPrimaryTerm)
 * license agreements. See the NOTICE file distributed with
            return parseBytesArray(xContent, (BytesArray) data, 0, data.length());
                            );
        @Nullable FetchSourceContext defaultFetchSourceContext,
    private static final ParseField RETRY_ON_CONFLICT = new ParseField("retry_on_conflict");
                if (token != XContentParser.Token.START_OBJECT) {
        BytesReference bytesReference,
                }
        if (MediaTypeRegistry.JSON == mediaType && bytesReference.get(nextMarker - 1) == (byte) '\r') {
        }
import java.util.HashMap;
                String pipeline = defaultPipeline;
    }
        return xContent.createParser(
import org.opensearch.common.lucene.uid.Versions;
 */
                            updateRequest.fromXContent(sliceParser);
                            .versionType(versionType)
                                xContent
import org.opensearch.index.VersionType;
                                opType = parser.text();
                        "Malformed action/metadata line ["
            LoggingDeprecationHandler.INSTANCE,
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
        MediaType mediaType
    /**
                } else {
            nextMarker - from
import org.opensearch.common.Nullable;
public final class BulkRequestParser {
                                }
                            } else if (RETRY_ON_CONFLICT.match(currentFieldName, parser.getDeprecationHandler())) {
                            upsertRequest.setPipeline(pipeline);
                                .versionType(versionType)
                            } else if (VERSION.match(currentFieldName, parser.getDeprecationHandler())) {
        final int length;
 * @opensearch.internal
                            } else if (SOURCE.match(currentFieldName, parser.getDeprecationHandler())) {
                String routing = defaultRouting;
 *
                        if (fetchSourceContext != null) {
                            } else if (OP_TYPE.match(currentFieldName, parser.getDeprecationHandler())) {
                                new IndexRequest(index).id(id)
                        } else {
    private static XContentParser createParser(BytesReference data, XContent xContent) throws IOException {
                            + "], expected "
    private static final Set<String> VALID_ACTIONS = Set.of("create", "delete", "index", "update");
                            + XContentParser.Token.START_OBJECT
                            } else if (IF_PRIMARY_TERM.match(currentFieldName, parser.getDeprecationHandler())) {
                    );
                            }
        // deduplicate duplicate strings parsed for these parameters. While it does not prevent instantiating the duplicate strings, it
                                );
        }
                                    .routing(routing)
                            + " or "
                                    .versionType(versionType)
 *     http://www.apache.org/licenses/LICENSE-2.0
        int nextMarker,
                            + "]"
                    deleteRequestConsumer.accept(
                }
                        UpdateRequest updateRequest = new UpdateRequest().index(index)
                            );
                                index = stringDeduplicator.computeIfAbsent(parser.text(), Function.identity());
import org.opensearch.search.fetch.subphase.FetchSourceContext;
                                    "Action/metadata line [" + line + "] contains an unknown parameter [" + currentFieldName + "]"
                token = parser.nextToken();
                    // of index request.
                    }
                // at this stage, next token can either be END_OBJECT (and use default index with auto generated id)
        if (from != data.length()) {
                        indexRequestConsumer.accept(
                                    + currentFieldName
        boolean allowExplicitIndex,
    private static final ParseField REQUIRE_ALIAS = new ParseField(DocWriteRequest.REQUIRE_ALIAS);
                            new IndexRequest(index).id(id)
                            )
                        "Malformed action/metadata line ["
                        if (upsertRequest != null) {
                        }
                                "Malformed action/metadata line ["
                            && SOURCE.match(currentFieldName, parser.getDeprecationHandler())) {
                                version = parser.longValue();
                String index = defaultIndex;
                token = parser.nextToken();
                    if ("index".equals(action)) {
    private static final ParseField VERSION = new ParseField("version");
                }
                                throw new IllegalArgumentException(
                        try (
package org.opensearch.action.bulk;
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
                        updateRequestConsumer.accept(updateRequest);
                            XContentParser sliceParser = createParser(
                long version = Versions.MATCH_ANY;
    private static final ParseField IF_SEQ_NO = new ParseField("if_seq_no");
                                throw new IllegalArgumentException(
                            + token
                        "Malformed action/metadata line ["
                            .setIfPrimaryTerm(ifPrimaryTerm)
        }
                    throw new IllegalArgumentException(
 * GitHub history for details.
                        }
                        if (token == XContentParser.Token.FIELD_NAME) {
            throw new IllegalArgumentException("The bulk request must be terminated by a newline [\\n]");
 * Licensed to Elasticsearch under one or more contributor
                    from = nextMarker + 1;
    private static BytesReference sliceTrimmingCarriageReturn(
            return parseBytesArray(xContent, (BytesArray) data, from, nextMarker);
                            + token
    private static final ParseField PIPELINE = new ParseField("pipeline");
                                    throw new IllegalArgumentException("explicit index in bulk is not allowed");
                long ifPrimaryTerm = UNASSIGNED_PRIMARY_TERM;
                                    + "] but found ["
    }
 * You may obtain a copy of the License at
                            + "]"
                                .source(sliceTrimmingCarriageReturn(data, from, nextMarker, mediaType), mediaType)
    private static XContentParser createParser(BytesReference data, XContent xContent, int from, int nextMarker) throws IOException {
import org.opensearch.action.update.UpdateRequest;
                                new IndexRequest(index).id(id)
                            throw new IllegalArgumentException(
                long ifSeqNo = SequenceNumbers.UNASSIGNED_SEQ_NO;
                    continue;
                String id = null;
import org.opensearch.core.common.bytes.BytesArray;
        BytesReference data,
                    // we use internalAdd so we don't fork here, this allows us not to copy over the big byte array to small chunks
                                    .setIfPrimaryTerm(ifPrimaryTerm)
                                .setPipeline(pipeline)
import org.opensearch.index.seqno.SequenceNumbers;
                    nextMarker = findNextMarker(marker, from, data);
                            + " but found ["
 * The OpenSearch Contributors require contributions made to
            return res;
                            + line
                    String currentFieldName = null;
 * Unless required by applicable law or agreed to in writing,
                    // move pointers
                                    .setIfSeqNo(ifSeqNo)
                                    + token
                                .setRequireAlias(requireAlias)
                            indexRequestConsumer.accept(
import java.io.IOException;
/**
                    );
                            + "], expected "
        // Bulk requests can contain a lot of repeated strings for the index, pipeline and routing parameters. This map is used to
import org.opensearch.core.ParseField;
                            + XContentParser.Token.FIELD_NAME
                                        + "]"
                            .setRequireAlias(requireAlias)
                            updateRequest.fetchSource(fetchSourceContext);
            if (nextMarker == -1) {
     * if it is a carriage return and if so, the BytesReference is sliced so that the carriage return is ignored
                                    + "], expected a simple value for field ["
                            } else if (VERSION_TYPE.match(currentFieldName, parser.getDeprecationHandler())) {
                    throw new IllegalArgumentException(
 * ownership. Elasticsearch licenses this file to you under
     */
import java.util.Set;
                        } else if (token.isValue()) {
                            } else if (PIPELINE.match(currentFieldName, parser.getDeprecationHandler())) {
                    } else if ("create".equals(action)) {
     * will be passed to the {@code indexRequestConsumer}, update requests to the
                                    .routing(routing)
                                    .setIfSeqNo(ifSeqNo)
                                    .version(version)
 * Modifications Copyright OpenSearch Contributors. See
                            + "]"
/*
import org.opensearch.action.delete.DeleteRequest;
            line++;
 * compatible open source license.
