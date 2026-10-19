                    // move pointers  
                }
                }
                }
        BytesReference bytesReference,  
        if (MediaTypeRegistry.JSON == mediaType && bytesReference.get(nextMarker - 1) == (byte) '\r') {  
    private static final ParseField PIPELINE = new ParseField("pipeline");
                                    + token
                        if (token == XContentParser.Token.FIELD_NAME) {
                                xContent  
                                        + "] but found ["
                String action = parser.currentName();  
            if (nextMarker == -1) {  
                                sliceTrimmingCarriageReturn(data, from, nextMarker, mediaType),
                                }
                        if (fetchSourceContext != null) {
                                ifPrimaryTerm = parser.longValue();
                            );  
        final int offset = array.offset();  
                        }
        final int res = data.indexOf(marker, from);
    private static final ParseField IF_SEQ_NO = new ParseField("if_seq_no");
        if (from != data.length()) {
                            } else if (RETRY_ON_CONFLICT.match(currentFieldName, parser.getDeprecationHandler())) {
 */
    private static final ParseField RETRY_ON_CONFLICT = new ParseField("retry_on_conflict");
package org.opensearch.action.bulk;
        return res;
                                    .setPipeline(pipeline)
 * Unless required by applicable law or agreed to in writing,
import java.util.HashMap;
            return parseBytesArray(xContent, (BytesArray) data, 0, data.length());  
                                        + currentFieldName  
                VersionType versionType = VersionType.INTERNAL;
                        UpdateRequest updateRequest = new UpdateRequest().index(index)
 * under the License.  
                            + line  
                long ifSeqNo = SequenceNumbers.UNASSIGNED_SEQ_NO;  
 * license agreements. See the NOTICE file distributed with
                XContentParser.Token token = parser.nextToken();
                            } else if (SOURCE.match(currentFieldName, parser.getDeprecationHandler())) {  
                            } else if (VERSION_TYPE.match(currentFieldName, parser.getDeprecationHandler())) {
                    );  
 * the Apache License, Version 2.0 (the "License"); you may
                                    "Action/metadata line [" + line + "] contains an unknown parameter [" + currentFieldName + "]"  
                            new IndexRequest(index).id(id)
    private static final ParseField OP_TYPE = new ParseField("op_type");
import org.opensearch.common.lucene.uid.Versions;  
                        }
                        indexRequestConsumer.accept(
        } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static final ParseField SOURCE = new ParseField("_source");  
                        );  
                            + "]"
                                    .source(sliceTrimmingCarriageReturn(data, from, nextMarker, mediaType), mediaType)
import org.opensearch.index.seqno.SequenceNumbers;  
                            .version(version)
                                );
            length = nextMarker - from;  
                // Move to START_OBJECT
                                id = parser.text();
                String index = defaultIndex;
    private static final ParseField VERSION = new ParseField("version");
 * software distributed under the License is distributed on an
        Consumer<DeleteRequest> deleteRequestConsumer  
                            + "]"  
 *
                            + "]"
            if (slice instanceof BytesArray) {
                                    + currentFieldName
                        "Malformed action/metadata line ["  
    private static BytesReference sliceTrimmingCarriageReturn(
        @Nullable Boolean defaultRequireAlias,
            nextMarker - from
                            + XContentParser.Token.START_OBJECT  
        }
                                    .versionType(versionType)  
                    String currentFieldName = null;
        }  
                                    .setPipeline(pipeline)
                                        + "]"  
                return parseBytesArray(xContent, (BytesArray) slice, 0, length);  
                            } else if (PIPELINE.match(currentFieldName, parser.getDeprecationHandler())) {
                            if (INDEX.match(currentFieldName, parser.getDeprecationHandler())) {
 * this work for additional information regarding copyright
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
import org.opensearch.core.common.bytes.BytesReference;
                            } else if (token != XContentParser.Token.VALUE_NULL) {
                                requireAlias = parser.booleanValue();  
                from = nextMarker + 1;
                break;
        int from,
        if (data instanceof BytesArray) {  
        BytesReference data,
                                throw new IllegalArgumentException(
    private static XContentParser parseBytesArray(XContent xContent, BytesArray array, int from, int nextMarker) throws IOException {
/*  
 *
        Consumer<UpdateRequest> updateRequestConsumer,
                            + " but found ["  
     * {@code updateRequestConsumer} and delete requests to the {@code deleteRequestConsumer}.
                                    .setIfPrimaryTerm(ifPrimaryTerm)
                if (token != XContentParser.Token.FIELD_NAME) {
                // or START_OBJECT which will have another set of parameters
                                .create(true)  
    // Create an efficient parser of the given bytes, trying to directly parse a byte array if possible and falling back to stream wrapping  
                            .setRequireAlias(requireAlias)
                        } else if (token == XContentParser.Token.START_ARRAY) {  
    ) {
                                    .setIfSeqNo(ifSeqNo)
                            .setIfPrimaryTerm(ifPrimaryTerm)  
                            + token
            return parseBytesArray(xContent, (BytesArray) data, from, nextMarker);
    ) throws IOException {
    }  
        @Nullable String defaultIndex,  
                            + XContentParser.Token.END_OBJECT
                    throw new IllegalArgumentException(
        boolean allowExplicitIndex,
        int from = 0;
                        ) {
            try (XContentParser parser = createParser(data, xContent, from, nextMarker)) {  
                            + token
                                    .setIfSeqNo(ifSeqNo)  
                            } else if (OP_TYPE.match(currentFieldName, parser.getDeprecationHandler())) {
                                fetchSourceContext = FetchSourceContext.fromXContent(parser);  
import org.opensearch.core.xcontent.NamedXContentRegistry;
                                        + line
     */
import org.opensearch.core.xcontent.XContent;  
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
    /**
    private static final ParseField IF_PRIMARY_TERM = new ParseField("if_primary_term");
                            throw new IllegalArgumentException(  
                            );  
                            + "], expected one of [create, delete, index, update] but found ["
                        if (upsertRequest != null) {  
    private static final ParseField ID = new ParseField("_id");
                            indexRequestConsumer.accept(
                        if (version != Versions.MATCH_ANY || versionType != VersionType.INTERNAL) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.VersionType;
                                routing = stringDeduplicator.computeIfAbsent(parser.text(), Function.identity());  
            }
                    // of index request.
                            + "]"
                    line++;
        final int length;
                                opType = parser.text();
                                fetchSourceContext = FetchSourceContext.fromXContent(parser);
                            .id(id)
 * specific language governing permissions and limitations
 */
                    from = nextMarker + 1;
                String routing = defaultRouting;
    public void parse(
                    throw new IllegalArgumentException(
                            + line
        if (res != -1) {  
                                .setIfPrimaryTerm(ifPrimaryTerm)  
 * KIND, either express or implied.  See the License for the
        }  
     */  
        int line = 0;  
    private static final ParseField INDEX = new ParseField("_index");
                            } else if (ID.match(currentFieldName, parser.getDeprecationHandler())) {  
                    }
 */  
                            currentFieldName = parser.currentName();
                        updateRequestConsumer.accept(updateRequest);
                                .setIfSeqNo(ifSeqNo)
 *
            // now parse the action
                            + " but found ["  
                            } else {
        return bytesReference.slice(from, length);
                            } else if (VERSION.match(currentFieldName, parser.getDeprecationHandler())) {  
                            .setIfSeqNo(ifSeqNo)
                                        + "], expected a simple value for field ["
                            upsertRequest.setPipeline(pipeline);
                            .setIfPrimaryTerm(ifPrimaryTerm)
                            } else if (ROUTING.match(currentFieldName, parser.getDeprecationHandler())) {
                            + action  
                        new DeleteRequest(index).id(id)
import org.opensearch.core.xcontent.MediaTypeRegistry;
                        try (  
        // deduplicate duplicate strings parsed for these parameters. While it does not prevent instantiating the duplicate strings, it
                            + "], expected "
                                    throw new IllegalArgumentException("explicit index in bulk is not allowed");  
                    } else if ("create".equals(action)) {  
                }
                            + "], expected "
                                );
                token = parser.nextToken();
    }
                            .versionType(versionType)
        byte marker = xContent.streamSeparator();
                            throw new IllegalArgumentException(
            NamedXContentRegistry.EMPTY,  
            }
                            + XContentParser.Token.START_OBJECT
                            .routing(routing)  
    }
                // Move to FIELD_NAME, that's the action
                        } else if (token.isValue()) {  
                                .version(version)
            LoggingDeprecationHandler.INSTANCE,
                        "Malformed action/metadata line ["  
        MediaType mediaType,  
        int nextMarker,
                    } else if ("update".equals(action)) {
    private static final ParseField VERSION_TYPE = new ParseField("version_type");  
 * ownership. Elasticsearch licenses this file to you under  
                            .routing(routing)  
                            indexRequestConsumer.accept(
                                if (allowExplicitIndex == false) {
 * GitHub history for details.
        XContent xContent = mediaType.xContent();
                            && SOURCE.match(currentFieldName, parser.getDeprecationHandler())) {
        @Nullable String defaultPipeline,  
     * Returns the sliced {@link BytesReference}. If the {@link XContentType} is JSON, the byte preceding the marker is checked to see
                if (token != XContentParser.Token.START_OBJECT) {  
                    if ("index".equals(action)) {  
        } else {
            }  
/*
        }  
    /**
        MediaType mediaType  
            return xContent.createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, data.streamInput());
            } else {
                if (token == XContentParser.Token.START_OBJECT) {
        while (true) {
                                    + "], expected a simple value for field ["
                String id = null;  
import org.opensearch.core.ParseField;  
                                retryOnConflict = parser.intValue();  
}
                                    + "] but found ["  
/*  
import org.opensearch.core.common.bytes.BytesArray;
 * compatible open source license.
                    // we use internalAdd so we don't fork here, this allows us not to copy over the big byte array to small chunks
                            } else if (IF_SEQ_NO.match(currentFieldName, parser.getDeprecationHandler())) {
import java.util.Map;
                        }
        final Map<String, String> stringDeduplicator = new HashMap<>();  
                                    + "]"
                                    "Malformed action/metadata line ["  
                                new IndexRequest(index).id(id)  
                            + XContentParser.Token.FIELD_NAME  
        // reduces their lifetime to the lifetime of this parse call instead of the lifetime of the full bulk request.
                            } else if (REQUIRE_ALIAS.match(currentFieldName, parser.getDeprecationHandler())) {
        Consumer<IndexRequest> indexRequestConsumer,
                                .setPipeline(pipeline)
        return xContent.createParser(
 *     http://www.apache.org/licenses/LICENSE-2.0
                            + token
     * will be passed to the {@code indexRequestConsumer}, update requests to the
                            + " but found ["
    // otherwise.
                boolean requireAlias = defaultRequireAlias != null && defaultRequireAlias;
            line++;  
        );
                                    .routing(routing)
                    nextMarker = findNextMarker(marker, from, data);
    }  
                            + " or "
import org.opensearch.action.DocWriteRequest;
    }
     * Parse the provided {@code data} assuming the provided default values. Index requests  
                        "Malformed action/metadata line ["  
import org.opensearch.action.update.UpdateRequest;
                            XContentParser sliceParser = createParser(
                            );
 */  
                if (token == null) {  
            int nextMarker = findNextMarker(marker, from, data);
                    );
                    throw new IllegalArgumentException(
                    );
            return res;
    private static final ParseField REQUIRE_ALIAS = new ParseField(DocWriteRequest.REQUIRE_ALIAS);  
                                versionType = VersionType.fromString(parser.text());  
        } else {
                        break;  
import java.util.Set;  
                                ifSeqNo = parser.longValue();
                                    .version(version)
                                    .create("create".equals(opType))
                        IndexRequest upsertRequest = updateRequest.upsertRequest();
    private static final Set<String> VALID_ACTIONS = Set.of("create", "delete", "index", "update");
            offset + from,  
                                    .version(version)
                                        + token
                                "Update requests do not support versioning. " + "Please use `if_seq_no` and `if_primary_term` instead"
                }
     * if it is a carriage return and if so, the BytesReference is sliced so that the carriage return is ignored  
                                .setRequireAlias(requireAlias)
                    throw new IllegalArgumentException(
import org.opensearch.action.index.IndexRequest;  
                                    .setIfPrimaryTerm(ifPrimaryTerm)  
                long ifPrimaryTerm = UNASSIGNED_PRIMARY_TERM;
                            + line
            assert res >= 0;
        if (data instanceof BytesArray) {
    private static XContentParser createParser(BytesReference data, XContent xContent) throws IOException {
                            .setIfSeqNo(ifSeqNo)  
                int retryOnConflict = 0;
                        } else {
                            .retryOnConflict(retryOnConflict)
                // at this stage, next token can either be END_OBJECT (and use default index with auto generated id)  
                    );  
                                    .routing(routing)
        // EMPTY is safe here because we never call namedObject
                                .versionType(versionType)
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
                        } else if (token == XContentParser.Token.START_OBJECT
                                    .source(sliceTrimmingCarriageReturn(data, from, nextMarker, mediaType), mediaType)
                if (action == null || VALID_ACTIONS.contains(action) == false) {
import java.util.function.Consumer;
import org.opensearch.search.fetch.subphase.FetchSourceContext;
                            }
                            + "], expected "
                            updateRequest.fetchSource(fetchSourceContext);  
 * @opensearch.internal  
                            );
                    continue;
        // Bulk requests can contain a lot of repeated strings for the index, pipeline and routing parameters. This map is used to  
                            updateRequest.fromXContent(sliceParser);  
/**  
            array.array(),
                    deleteRequestConsumer.accept(
                                    + line  
                                    .setRequireAlias(requireAlias)
                        }  
            final BytesReference slice = data.slice(from, length);
 * Helper to parse bulk requests. This should be considered an internal class.
                // move pointers
                // EMPTY is safe here because we never call namedObject
                                "Malformed action/metadata line ["
    }  
                            + line
 * Modifications Copyright OpenSearch Contributors. See
                            )
                    }  
 * The OpenSearch Contributors require contributions made to  
                } else {  
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.action.delete.DeleteRequest;
                } else if (token != XContentParser.Token.END_OBJECT) {
            length = nextMarker - from - 1;
public final class BulkRequestParser {
                    if (nextMarker == -1) {
        @Nullable String defaultRouting,
            final int length = nextMarker - from;  
                return xContent.createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, slice.streamInput());  
import java.io.IOException;  
                            } else if (IF_PRIMARY_TERM.match(currentFieldName, parser.getDeprecationHandler())) {  
                        if (opType == null) {
 * not use this file except in compliance with the License.
                token = parser.nextToken();  
    private static final ParseField ROUTING = new ParseField("routing");  
                            .routing(routing);
                long version = Versions.MATCH_ANY;
import java.util.function.Function;
                }  
                                new IndexRequest(index).id(id)  
        }
                                throw new IllegalArgumentException(
                                .source(sliceTrimmingCarriageReturn(data, from, nextMarker, mediaType), mediaType)
                String opType = null;  
                                    .versionType(versionType)  
import org.opensearch.common.Nullable;
    private static XContentParser createParser(BytesReference data, XContent xContent, int from, int nextMarker) throws IOException {
                    );
import org.opensearch.common.xcontent.XContentType;
                        }
 * Licensed to Elasticsearch under one or more contributor  
                        "Malformed action/metadata line ["
                String pipeline = defaultPipeline;  
            throw new IllegalArgumentException("The bulk request must be terminated by a newline [\\n]");
        @Nullable FetchSourceContext defaultFetchSourceContext,
                                pipeline = stringDeduplicator.computeIfAbsent(parser.text(), Function.identity());
                                    .setRequireAlias(requireAlias)  
        }
    private static int findNextMarker(byte marker, int from, BytesReference data) {
import org.opensearch.core.xcontent.MediaType;  
 * You may obtain a copy of the License at  
                                index = stringDeduplicator.computeIfAbsent(parser.text(), Function.identity());
                    }
 *  
 * this file be licensed under the Apache-2.0 license or a
                FetchSourceContext fetchSourceContext = defaultFetchSourceContext;
                            }
                                .routing(routing)  
                if ("delete".equals(action)) {  
                                version = parser.longValue();
