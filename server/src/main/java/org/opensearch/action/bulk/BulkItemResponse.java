                    case 3 -> WRITE_PROCESSING;
        }
                    default -> throw new IllegalArgumentException("Unknown failure source: [" + sourceType + "]");
import org.opensearch.core.xcontent.XContentBuilder;
            bulkItemResponse = new BulkItemResponse(id, opType, builder.build());
import org.opensearch.core.common.Strings;
    }
        public Exception getCause() {
        OpenSearchException exception = null;
        opType = OpType.fromId(in.readByte());
            public byte getSourceType() {
            builder.field(STATUS, failure.getStatus().getStatus());
            OpenSearchException.generateThrowableXContent(builder, params, failure.getCause());
import org.opensearch.core.xcontent.MediaTypeRegistry;
            return term;
    private static final String _ID = "_id";
        out.writeByte(opType.getId());
                ExceptionsHelper.status(cause),
            response = new DeleteResponse(in);
     */
 * GitHub history for details.
        }
import java.io.IOException;
     * case of failure.
        }
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
            final IndexResponse.Builder indexResponseBuilder = new IndexResponse.Builder();
            return Strings.toString(MediaTypeRegistry.JSON, this);
import org.opensearch.action.index.IndexResponse;
            );
                }
         * The rest status.
    public OpType getOpType() {
     * The id of the action.
         * Read from a stream.
import org.opensearch.common.xcontent.StatusToXContentObject;
         */
        }
         * The index name of the action.
            this.source = source;
    public boolean isFailed() {
        /**
            this.status = status;
    }
        builder.startObject(opType.getLowercase());
                    exception = OpenSearchException.fromXContent(parser);
        public long getTerm() {
        if (failure == null) {
            }
         */
            out.writeBoolean(true);
            if (token == XContentParser.Token.FIELD_NAME) {
        return response.getVersion();
 * compatible open source license.
        } else if (type == 3) { // make 3 instead of 2, because 2 is already in use for 'no responses'
    }
        /**
            return builder;
        public Failure(String index, String id, Exception cause, FailureSource source) {
            FailureSource source
        public Failure(String index, String id, Exception cause, boolean aborted) {
        }
    public void writeTo(StreamOutput out) throws IOException {
        public String getIndex() {
                aborted,
                SequenceNumbers.UNASSIGNED_SEQ_NO,
                index,
            return source;
            out.writeBoolean(aborted);
        @Override
            this(
        opType = OpType.fromId(in.readByte());
    /**
        private final Exception cause;
        }
            }
            FailureSource(byte sourceType) {
            status = ExceptionsHelper.status(cause);
import org.opensearch.action.delete.DeleteResponse;
                // can't make an assertion about type names here because too many tests still set their own
            this.index = index;
    public int getItemId() {
    }
     */
        private final boolean aborted;
                    case 1 -> PIPELINE;
            );
        }
import org.opensearch.Version;
            );
import org.opensearch.core.xcontent.ToXContentFragment;
 */
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            // Pipeline execution failure
 * not use this file except in compliance with the License.
 *
            response = new IndexResponse(in);
                SequenceNumbers.UNASSIGNED_SEQ_NO,
        }
    private DocWriteResponse response;
                    case 2 -> VALIDATION;
                ExceptionsHelper.status(cause),
            PARSER.declareString(constructorArg(), new ParseField(INDEX_FIELD));
            builder.field(STATUS_FIELD, status.getStatus());
                builder.field(ID_FIELD, id);
                cause,
        out.writeVInt(id);
    private void writeResponseType(StreamOutput out) throws IOException {
    public String getFailureMessage() {
                cause,
/*
            public static FailureSource fromSourceType(byte sourceType) {
                }
            builder = indexResponseBuilder;
        return bulkItemResponse;
            builder.endObject();
        }
    /**
                itemParser.accept(parser);
public class BulkItemResponse implements Writeable, StatusToXContentObject {
         */
            case IndexResponse ignored -> out.writeByte((byte) 0);
            out.writeBoolean(false);
                false,
        public Failure(String index, String id, Exception cause, RestStatus status) {
            response = new UpdateResponse(in);
 * this work for additional information regarding copyright
         * indicates primary term was not assigned by primary
                FailureSource.UNKNOWN
        ensureExpectedToken(XContentParser.Token.END_OBJECT, token, parser);
        }
            aborted = in.readBoolean();
         * The operation sequence number generated by primary
        if (type == 0) {
    }
        }
            Exception cause,
         */
            if (ERROR.equals(currentFieldName)) {
        public static final ConstructingObjectParser<Failure, Void> PARSER = new ConstructingObjectParser<>(
            VALIDATION((byte) 2),
        public String getId() {
            );
     * The actual failure object if there was a failure.
     */
            if (in.getVersion().onOrAfter(Version.V_3_0_0)) {
        } else if (type == 3) { // make 3 instead of 2, because 2 is already in use for 'no responses'
    public RestStatus status() {
            this(
                SequenceNumbers.UNASSIGNED_SEQ_NO,
         * use @{link {@link #Failure(String, String, Exception, long, long)}}
        }
        public String toString() {
        out.writeByte(opType.getId());
        builder.startObject();
                status,
        }
    /**
            response = new IndexResponse(shardId, in);
            response.innerToXContent(builder, params);
         */
                id,
                source = FailureSource.UNKNOWN;
                if (token == XContentParser.Token.VALUE_NUMBER) {
        public static final String ID_FIELD = "id";
     * @param id the id to assign to the parsed {@link BulkItemResponse}. It is usually the index of
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
            builder = updateResponseBuilder;
            }
            PARSER.declareString(optionalConstructorArg(), new ParseField(ID_FIELD));
            throwUnknownField(currentFieldName, parser.getTokenLocation());
            out.writeZLong(seqNo);
 * the Apache License, Version 2.0 (the "License"); you may
    /**
            out.writeVLong(term);
                id,
         */
import org.opensearch.ExceptionsHelper;
            return PARSER.apply(parser, null);
            failure = new Failure(in);
 * under the License.
        @Override
        }
     * @opensearch.api
                id,
        return (T) response;
        BulkItemResponse bulkItemResponse;
     */
    /**
        return id;
     * Represents a failure.
 *     http://www.apache.org/licenses/LICENSE-2.0
         * <p>
 */
            failure = new Failure(in);
                };
            builder.startObject(CAUSE_FIELD);
        } else if (type == 1) {
     */
     * The version of the action.
            } else {
            final DeleteResponse.Builder deleteResponseBuilder = new DeleteResponse.Builder();
        this.id = id;
        }
                index,
     */
            index = in.readString();
            out.writeOptionalString(id);
import org.opensearch.action.update.UpdateResponse;
        }
 * Licensed to Elasticsearch under one or more contributor
                SequenceNumbers.UNASSIGNED_PRIMARY_TERM,
 * Modifications Copyright OpenSearch Contributors. See
            RestStatus status,
        }
    public BulkItemResponse(int id, OpType opType, Failure failure) {
     */
        if (exception != null) {
    private static final String STATUS = "status";
import org.opensearch.core.index.shard.ShardId;
        /**
            case UpdateResponse ignored -> out.writeByte((byte) 3); // make 3 instead of 2, because 2 is already in use for 'no responses'
            }
     * @param parser the {@link XContentParser}
            PARSER.declareInt(constructorArg(), new ParseField(STATUS_FIELD));
import org.opensearch.core.xcontent.XContentParser;
     * The actual response ({@link IndexResponse} or {@link DeleteResponse}). {@code null} in
        }
    /**
        public FailureSource getSource() {
            this.seqNo = seqNo;
         */
            UNKNOWN((byte) 0),
    public long getVersion() {
            return this.cause.toString();
        }
         * The failure message.
                    case 0 -> UNKNOWN;
            this.cause = cause;
    public static BulkItemResponse fromXContent(XContentParser parser, int id) throws IOException {
            return failure.getId();
import org.opensearch.core.ParseField;
        /**
    }
            long term,
 * ownership. Elasticsearch licenses this file to you under
            return -1;
        private Failure(
        public Failure(String index, String id, Exception cause, long seqNo, long term) {
import org.opensearch.core.xcontent.ConstructingObjectParser;
                SequenceNumbers.UNASSIGNED_PRIMARY_TERM,
            builder.field(INDEX_FIELD, index);
         * If {@code true}, the request to which this failure relates should never be retried, regardless of the {@link #getCause() cause}.
         * indicates sequence number was not generated by primary
    public <T extends DocWriteResponse> T getResponse() {
    }
 * license agreements. See the NOTICE file distributed with
        return null;
        } else if (opType == OpType.DELETE) {
        private final String index;
         */
            this(
            cause = in.readException();
                // types bypassing various checks
            out.writeByte((byte) 2);
 * this file be licensed under the Apache-2.0 license or a
        }
            String id,
import org.opensearch.core.common.io.stream.StreamInput;
     */
    @Override
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
        if (in.readBoolean()) {
        this.id = id;
import org.opensearch.OpenSearchException;
            out.writeBoolean(true);
/*
        public Failure(StreamInput in) throws IOException {
        }
        this.opType = opType;
    }
            if (out.getVersion().before(Version.V_2_0_0)) {
        CheckedConsumer<XContentParser, IOException> itemParser = null;
    @Override
            return failure.getIndex();
 *
        } else {
    }
            }
 * You may obtain a copy of the License at
        this.opType = opType;
                ExceptionsHelper.status(cause),
    public String getIndex() {
        public RestStatus getStatus() {
            "bulk_failures",
    public Failure getFailure() {
            case DeleteResponse ignored -> out.writeByte((byte) 1);
        return this.failure;
 *
            response.writeThin(out);
    public void writeThin(StreamOutput out) throws IOException {
        );
            id = in.readOptionalString();
        public enum FailureSource {
         */
        }
}
        } else {
     * Reads a {@link BulkItemResponse} from a {@link XContentParser}.
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.currentToken(), parser);
    }
        public static final String CAUSE_FIELD = "cause";
        }
        /**
            Failure failure = new Failure(builder.getShardId().getIndexName(), builder.getId(), exception, status);
                cause,
            OpenSearchException.generateThrowableXContent(builder, params, cause);
     * Is this a failed execution of an operation.
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
            response.writeTo(out);
            return failure.getMessage();
            true,
import org.opensearch.core.common.io.stream.StreamOutput;
    BulkItemResponse(ShardId shardId, StreamInput in) throws IOException {
        if (failure != null) {
    @PublicApi(since = "1.0.0")
    BulkItemResponse() {}
                FailureSource.UNKNOWN
        public String getMessage() {
    private int id;
        }
 * SPDX-License-Identifier: Apache-2.0
            }
        ) {
 */
    private static final String _INDEX = "_index";
        if (response == null) {
                    status = RestStatus.fromCode(parser.intValue());
        final OpType opType = OpType.fromString(currentFieldName);
        } else if (type != 2) {
            builder.field(STATUS, response.status().getStatus());
        }
                return sourceType;
    public BulkItemResponse(int id, OpType opType, DocWriteResponse response) {
     */
        return response.getId();
        @PublicApi(since = "3.0.0")
        RestStatus status = null;
    }
    }
         * NOTE: {@link SequenceNumbers#UNASSIGNED_PRIMARY_TERM}
        this.failure = failure;
            throw new IllegalArgumentException("Unexpected type [" + type + "]");
            return id;
        if (in.readBoolean()) {
        return builder;
        return response.getIndex();
            bulkItemResponse = new BulkItemResponse(id, opType, failure);
        if (response == null) {
    }
            if (out.getVersion().onOrAfter(Version.V_3_0_0)) {
         */
        /** For write failures after operation was assigned a sequence number. */
     * The operation type ("index", "create" or "delete").
         */
            itemParser = (indexParser) -> IndexResponse.parseXContentFields(indexParser, indexResponseBuilder);
     */
        }
    }
 * @opensearch.api
    private Failure failure;
    BulkItemResponse(StreamInput in) throws IOException {
        /**
        byte type = in.readByte();
            this.id = id;
            String index,
        @Override
        }
        } else {
        if (type == 0) {
        }
 * Represents a single item response for an action executed as part of the bulk API. Holds the index/type/id
     * The numeric order of the item matching the same request order in the bulk request.
        }
        if (failure == null) {
        public static final String INDEX_FIELD = "index";
        } else {
        private final long seqNo;
import org.opensearch.index.seqno.SequenceNumbers;
        this.response = response;
        switch (response) {
 *
import org.opensearch.core.common.io.stream.Writeable;
         * The actual cause of the failure.
        }
 * specific language governing permissions and limitations
        }
package org.opensearch.action.bulk;
        } else if (opType == OpType.UPDATE) {
            out.writeException(cause);
        }
import org.opensearch.common.annotation.PublicApi;
/**
     *
        }
    private static final String ERROR = "error";
    /**
        token = parser.nextToken();
            out.writeBoolean(false);
            this.aborted = aborted;
            } else if (STATUS.equals(currentFieldName)) {
            return this.index;
 * The OpenSearch Contributors require contributions made to
import org.opensearch.action.DocWriteRequest.OpType;
            builder.field(_ID, failure.getId());
            }
import static org.opensearch.core.xcontent.XContentParserUtils.throwUnknownField;
    /**
            long seqNo,
                source = FailureSource.fromSourceType(in.readByte());
                SequenceNumbers.UNASSIGNED_PRIMARY_TERM,
            if (in.getVersion().before(Version.V_2_0_0)) {
         * The id of the action.
        id = in.readVInt();
        }
import org.opensearch.common.CheckedConsumer;
                SequenceNumbers.UNASSIGNED_SEQ_NO,
                out.writeString(MapperService.SINGLE_MAPPING_NAME);
            if (id != null) {
        if (failure != null) {
     * The failure message, {@code null} if it did not fail.
            this.term = term;
            failure.writeTo(out);
            throw new IllegalArgumentException("Unexpected type [" + type + "]");
         * The operation primary term of the primary
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        out.writeVInt(id);
            response = new UpdateResponse(shardId, in);
        if (failure != null) {
    }
import org.opensearch.index.mapper.MapperService;
        return failure != null;
        String currentFieldName = parser.currentName();
     *
                in.readString();
            itemParser = (updateParser) -> UpdateResponse.parseXContentFields(updateParser, updateResponseBuilder);
        /**
/*
    public static class Failure implements Writeable, ToXContentFragment {
        return failure == null ? response.status() : failure.getStatus();
            }
            term = in.readVLong();
            return cause;
     *           the item in the {@link BulkResponse#getItems} array.
    private OpType opType;
                this.sourceType = sourceType;
            }
        ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
    }
         * to record operation sequence no with failure
    }
            a -> new Failure((String) a[0], (String) a[1], (Exception) a[2], RestStatus.fromCode((int) a[3]))
    /**
            final UpdateResponse.Builder updateResponseBuilder = new UpdateResponse.Builder();
            itemParser = (deleteParser) -> DeleteResponse.parseXContentFields(deleteParser, deleteResponseBuilder);
         * Whether this failure is the result of an <em>abort</em>.
            builder = deleteResponseBuilder;
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.DocWriteResponse;
        }
        /**
        DocWriteResponse.Builder builder = null;
            out.writeByte((byte) 2);
            seqNo = in.readZLong();
         * The source of the failure, denotes which step has failure during the bulk processing.
    }
import org.opensearch.core.rest.RestStatus;
 * of the relevant action, and if it has failed or not (with the failure message in case it failed).
        builder.endObject();
        } else {
                return switch (sourceType) {
            out.writeString(index);
        if (failure == null) {
        } else {
        private final RestStatus status;
        } else if (type == 1) {
            boolean aborted,
        /**
            failure.writeTo(out);
    }
    @Override
                SequenceNumbers.UNASSIGNED_PRIMARY_TERM,
         * For write failures before operation was assigned a sequence number.
        } else if (type != 2) {
 */
            builder.startObject(ERROR);
            PIPELINE((byte) 1),
            writeResponseType(out);
                index,
            PARSER.declareObject(constructorArg(), (p, c) -> OpenSearchException.fromXContent(p), new ParseField(CAUSE_FIELD));
        builder.endObject();
        byte type = in.readByte();
        return this.opType;
    /**
        private final String id;
            } else {
        }
            writeResponseType(out);
        private final FailureSource source;
            default -> throw new IllegalStateException("Unexpected response type found [" + response.getClass() + "]");
        token = parser.nextToken();
        public static Failure fromXContent(XContentParser parser) {
        if (opType == OpType.INDEX || opType == OpType.CREATE) {
    public String getId() {
        public void writeTo(StreamOutput out) throws IOException {
 * software distributed under the License is distributed on an
        public long getSeqNo() {
            return this.status;
            WRITE_PROCESSING((byte) 3);
        /**
            return aborted;
    /**
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        private final long term;
                currentFieldName = parser.currentName();
                false,
        } else {
                FailureSource.UNKNOWN
        XContentParser.Token token = parser.nextToken();
     * The index name of the action.
        }
        ensureExpectedToken(XContentParser.Token.END_OBJECT, token, parser);
            }
                cause,
                if (token == XContentParser.Token.START_OBJECT) {
        if (failure != null) {
                index,
    }
            this(index, id, cause, ExceptionsHelper.status(cause), seqNo, term, false, FailureSource.UNKNOWN);
        }
         * NOTE: {@link SequenceNumbers#UNASSIGNED_SEQ_NO}
@PublicApi(since = "1.0.0")
                false,
        public boolean isAborted() {
            private final byte sourceType;
        id = in.readVInt();
     */
        /**
            return seqNo;
        }
        public static final String STATUS_FIELD = "status";
            response = new DeleteResponse(shardId, in);
                source
 * Unless required by applicable law or agreed to in writing,
        public Failure(String index, String id, Exception cause) {
        static {
            this(
                out.writeByte(source.getSourceType());
                id,
            builder.endObject();
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            builder.field(_INDEX, failure.getIndex());
