        super(in);
import org.opensearch.action.support.replication.ReplicationResponse;
        this.result = Objects.requireNonNull(result);
        Result(int op) {
     */
    }
                    return DELETED;
    }
                case 1:
        final StringBuilder location = new StringBuilder(bufferSize);
            // encode the path components separately otherwise the path separators will be encoded
        public static Result readFrom(StreamInput in) throws IOException {
 * GitHub history for details.
 */
            } else if (_ID.equals(currentFieldName)) {
    protected DocWriteResponse(StreamInput in) throws IOException {
    private final long version;
 */
                    }
        public String getId() {
import java.io.IOException;
        if (in.getVersion().before(Version.V_2_0_0)) {
     * @param routing custom routing or {@code null} if custom routing is not used
    /**
     * {@link DocWriteResponse} objects. It always parses the current token, updates the given parsing context accordingly
        protected long seqNo = UNASSIGNED_SEQ_NO;
            }
    private static final String _SHARDS = "_shards";
        } else if (token == XContentParser.Token.START_ARRAY) {
                context.setPrimaryTerm(parser.longValue());
import org.opensearch.common.Nullable;
    }
        } else if (token == XContentParser.Token.START_OBJECT) {
        builder.startObject();
     * operation that occurred.
     * <p>
 * compatible open source license.
                context.setId(parser.text());
        public ShardId getShardId() {
import org.opensearch.core.index.Index;
            this.op = (byte) op;
    public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
        }
        UPDATED(1),
     * Needed for deserialization of single item requests in {@link org.opensearch.action.index.IndexAction} and BwC
    }
import org.opensearch.action.support.WriteResponse;
    private final long primaryTerm;
import org.opensearch.core.index.shard.ShardId;
     * only return true here if they run out of refresh listener slots (see {@link IndexSettings#MAX_REFRESH_LISTENERS_PER_SHARD}).
        }
                parser.skipChildren(); // skip potential inner objects for forward compatibility
        final String encodedRouting;
        result.writeTo(out);
 * specific language governing permissions and limitations
    public long getPrimaryTerm() {
        version = in.readZLong();
        protected String id = null;
import java.util.Locale;
    /**
        }
            this.shardInfo = shardInfo;
 * The OpenSearch Contributors require contributions made to
                case 2:
 * under the License.
    /**
        String currentFieldName = parser.currentName();
                context.setShardInfo(ShardInfo.fromXContent(parser));
    }
     * The exact shard the document was changed in.
        public String getLowercase() {
        return this.shardId.getIndexName();
            this.result = result;
     * An enum that represents the results of CRUD operations, primarily used to communicate the type of
     */
    @PublicApi(since = "1.0.0")
        shardId = new ShardId(in);
        final int bufferSizeExcludingRouting = 3 + encodedIndex.length() + encodedType.length() + encodedId.length();
            Byte opcode = in.readByte();
        return seqNo;
    protected DocWriteResponse(ShardId shardId, StreamInput in) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
        return result;
        private final byte op;
        }
            this.lowercase = this.name().toLowerCase(Locale.ROOT);
     * Return the relative URI for the location of the document suitable for use in the {@code Location} header. The use of relative URIs is
        return this.id;
    public long getVersion() {
    }
        }
        }
            this.seqNo = seqNo;
import java.io.UnsupportedEncodingException;
        }
/*
    // needed for deserialization
        out.writeVLong(primaryTerm);
        }
        final String encodedType;
    }
     * Base class of all {@link DocWriteResponse} builders. These {@link DocWriteResponse.Builder} are used during
        if (forcedRefresh) {
    public DocWriteResponse(ShardId shardId, String id, long seqNo, long primaryTerm, long version, Result result) {
    }
        public byte getOp() {
                context.setShardId(new ShardId(new Index(parser.text(), IndexMetadata.INDEX_UUID_NA_VALUE), -1));
    public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            String type = in.readString();
     */
        }
     * deserialization path
        out.writeZLong(seqNo);
 *
        public void setShardId(ShardId shardId) {
 * not use this file except in compliance with the License.
            this.id = id;
        }
                        break;
import org.opensearch.core.common.io.stream.StreamInput;
        public void writeTo(StreamOutput out) throws IOException {
        protected ShardInfo shardInfo = null;
        private final String lowercase;
 */
    }
            encodedId = URLEncoder.encode(getId(), "UTF-8");
    /**
    private final String id;
            return lowercase;
    public String getId() {
            } else if (FORCED_REFRESH.equals(currentFieldName)) {
     *
        writeWithoutShardId(out);
    }
import org.opensearch.core.rest.RestStatus;
/*
            return op;
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
        }
        super(in);
        return this.shardId;
import org.opensearch.Version;
    protected final Result result;
import org.opensearch.core.xcontent.XContentBuilder;
    /**
     * @return the relative URI for the location of the document
    @Override
    public RestStatus status() {
        if (getSeqNo() >= 0) {
     * xcontent parsing to temporarily store the parsed values, then the {@link Builder#build()} method is called to
 * Licensed to Elasticsearch under one or more contributor
 * Unless required by applicable law or agreed to in writing,
        this.shardId = shardId;
    }
        primaryTerm = in.readVLong();
     */
        if (token.isValue()) {
     *
    public ShardId getShardId() {
            } else if (_PRIMARY_TERM.equals(currentFieldName)) {
        ReplicationResponse.ShardInfo shardInfo = getShardInfo();
        return this.version;
        final String routingStart = "?routing=";
        }
                    return NOT_FOUND;
     * Parse the output of the {@link #innerToXContent(XContentBuilder, Params)} method.
        } catch (final UnsupportedEncodingException e) {
 *
     * The index the document was changed in.
            encodedIndex = URLEncoder.encode(getIndex(), "UTF-8");
                for (Result r : Result.values()) {
     */
import org.opensearch.core.common.io.stream.Writeable;
     *
        if (encodedRouting != null) {
 */
            encodedRouting = routing == null ? null : URLEncoder.encode(routing, "UTF-8");
        protected Long version = null;
            String type = in.readString();
            parser.skipChildren(); // skip potential inner arrays for forward compatibility
            assert MapperService.SINGLE_MAPPING_NAME.equals(type) : "Expected [_doc] but received [" + type + "]";
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
            } else if (_SEQ_NO.equals(currentFieldName)) {
        seqNo = in.readZLong();
     */
            } else {
                String result = parser.text();
     * Returns the sequence number assigned for this change. Returns {@link SequenceNumbers#UNASSIGNED_SEQ_NO} if the operation
    private static final String _PRIMARY_TERM = "_primary_term";
    private static final String _SEQ_NO = "_seq_no";
        shardId.writeTo(out);
     * instantiate the appropriate {@link DocWriteResponse} with the parsed values.
                context.setSeqNo(parser.longValue());
     * Did this request force a refresh? Requests that set {@link WriteRequest#setRefreshPolicy(RefreshPolicy)} to
        result = Result.readFrom(in);
/**
    /**
     * The change that occurred to the document.
            encodedType = URLEncoder.encode(MapperService.SINGLE_MAPPING_NAME, "UTF-8");
            bufferSize = bufferSizeExcludingRouting + routingStart.length() + encodedRouting.length();
import org.opensearch.core.xcontent.XContentParser;
    protected static void parseInnerToXContent(XContentParser parser, Builder context) throws IOException {
    }
        final String encodedId;
 * SPDX-License-Identifier: Apache-2.0
    public void setForcedRefresh(boolean forcedRefresh) {
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
    /**
            bufferSize = bufferSizeExcludingRouting;
public abstract class DocWriteResponse extends ReplicationResponse implements WriteResponse, StatusToXContentObject {
@PublicApi(since = "1.0.0")
 * You may obtain a copy of the License at
        id = in.readString();
        if (encodedRouting == null) {
            out.writeString(MapperService.SINGLE_MAPPING_NAME);
    /** returns the rest status for this response (based on {@link ShardInfo#status()} */
            } else if (RESULT.equals(currentFieldName)) {
 * this work for additional information regarding copyright
import org.opensearch.cluster.metadata.IndexMetadata;
        public void setId(String id) {
/*
        protected ShardId shardId = null;
    /**
        } else {
        location.append('/').append(encodedType);
        return builder;
     * {@link RefreshPolicy#IMMEDIATE} will always return true for this. Requests that set it to {@link RefreshPolicy#WAIT_UNTIL} will
        DELETED(2),
        seqNo = in.readZLong();
        return getShardInfo().status();
    }
        }
            }
        }
                // index uuid and shard id are unknown and can't be parsed back for now.
import org.opensearch.index.seqno.SequenceNumbers;
        final int bufferSize;
        }
    @Override
        }
    /**
    }
                    throw new IllegalArgumentException("Unknown result code: " + opcode);
        public void setVersion(Long version) {
        @Override
    }
     */
     * wasn't performed (i.e., an update operation that resulted in a NOOP).
            return shardId;
            out.writeByte(op);
     * This method is intended to be called by subclasses and must be called multiple times to parse all the information concerning
        forcedRefresh = in.readBoolean();
        token = parser.nextToken();
     * @return the primary term
    public boolean forcedRefresh() {
    /**
            return id;
import org.opensearch.core.common.io.stream.StreamOutput;
        }
        location.append('/').append(encodedId);
        return primaryTerm;
                case 3:
        out.writeZLong(version);
    private static final String FORCED_REFRESH = "forced_refresh";
        public void setResult(Result result) {
    public enum Result implements Writeable {
    }
    private boolean forcedRefresh;
            throw new AssertionError(e);
            if (_INDEX.equals(currentFieldName)) {
            switch (opcode) {
        CREATED(0),
import java.net.URLEncoder;
        builder.endObject();
    }
            builder.field(_SEQ_NO, getSeqNo());
        }
        location.append('/').append(encodedIndex);
    }
                    return CREATED;
        }
        NOOP(4);
        version = in.readZLong();
            this.forcedRefresh = forcedRefresh;
                    return NOOP;
    private static final String _ID = "_id";
import org.opensearch.common.annotation.PublicApi;
                context.setVersion(parser.longValue());
        forcedRefresh = in.readBoolean();
        final String encodedIndex;
     */
        protected Result result = null;
    public void writeTo(StreamOutput out) throws IOException {
     * if needed and then immediately returns.
        out.writeString(id);
     * The primary term for this change.
        }
        out.writeBoolean(forcedRefresh);
    public void writeThin(StreamOutput out) throws IOException {
                }
 * ownership. Elasticsearch licenses this file to you under
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        try {
import org.opensearch.common.xcontent.StatusToXContentObject;
    /**
    public Result getResult() {
        }
            }
        public void setSeqNo(long seqNo) {
            assert MapperService.SINGLE_MAPPING_NAME.equals(type) : "Expected [_doc] but received [" + type + "]";
        public void setForcedRefresh(boolean forcedRefresh) {
            } else if (_VERSION.equals(currentFieldName)) {
                context.setForcedRefresh(parser.booleanValue());
import org.opensearch.index.IndexSettings;
     * @opensearch.api
        return forcedRefresh;
import org.opensearch.action.support.WriteRequest;
                case 4:
        return location.toString();
     */
    public String getLocation(@Nullable String routing) {
                    return UPDATED;
        super.writeTo(out);
     */
        this.version = version;
    }
     * The id of the document changed.
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
        id = in.readString();
        this.id = Objects.requireNonNull(id);
    }
        this.primaryTerm = primaryTerm;
        builder.field(_SHARDS, shardInfo);
        super.writeTo(out);
     */
        this.seqNo = seqNo;
    private final long seqNo;
        result = Result.readFrom(in);
            location.append(routingStart).append(encodedRouting);
    /**
 * A base class for the response of a write operation that involves a single doc
        builder.field(_INDEX, shardId.getIndexName());
            this.primaryTerm = primaryTerm;
     * permitted as of HTTP/1.1 (cf. https://tools.ietf.org/html/rfc7231#section-7.1.2).
        innerToXContent(builder, params);
    @Override
 * @opensearch.api
        }
 *
        if (in.getVersion().before(Version.V_2_0_0)) {
package org.opensearch.action;
import java.util.Objects;
        public abstract DocWriteResponse build();
        }
    @Override
            if (_SHARDS.equals(currentFieldName)) {
        if (out.getVersion().before(Version.V_2_0_0)) {
            this.version = version;
     */
import org.opensearch.index.mapper.MapperService;
     */
                case 0:
 * KIND, either express or implied.  See the License for the
    private static final String RESULT = "result";
            this.shardId = shardId;
    }
                    if (r.getLowercase().equals(result)) {
    public long getSeqNo() {
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
    private static final String _VERSION = "_version";
        this.shardId = Objects.requireNonNull(shardId);
 *
        }
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
    private final ShardId shardId;
        protected long primaryTerm = UNASSIGNED_PRIMARY_TERM;
}
            builder.field(_PRIMARY_TERM, getPrimaryTerm());
        builder.field(_ID, id).field(_VERSION, version).field(RESULT, getResult().getLowercase());
            builder.field(FORCED_REFRESH, true);
        writeWithoutShardId(out);
        this.forcedRefresh = forcedRefresh;
     * @opensearch.internal
        XContentParser.Token token = parser.currentToken();
        NOT_FOUND(3),
        protected boolean forcedRefresh;
                default:
        return builder;
        public void setPrimaryTerm(long primaryTerm) {
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
    }
    /**
        public void setShardInfo(ShardInfo shardInfo) {
     *
    public String getIndex() {
     * Returns the current version of the doc.
    public abstract static class Builder {
        primaryTerm = in.readVLong();
    private void writeWithoutShardId(StreamOutput out) throws IOException {
                        context.setResult(r);
    private static final String _INDEX = "_index";
 * license agreements. See the NOTICE file distributed with
