        version = in.readZLong();  
            } else if (_ID.equals(currentFieldName)) {
        protected ShardId shardId = null;
     */  
        public static Result readFrom(StreamInput in) throws IOException {  
    }
        }  
    @Override
            out.writeString(MapperService.SINGLE_MAPPING_NAME);
                    return DELETED;
 * compatible open source license.
        out.writeZLong(version);
        final String encodedType;
        } else if (token == XContentParser.Token.START_OBJECT) {
                default:
                    return UPDATED;  
    }
        }
    }  
        version = in.readZLong();
        builder.field(_ID, id).field(_VERSION, version).field(RESULT, getResult().getLowercase());
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;  
    /**
                context.setId(parser.text());
        public void setForcedRefresh(boolean forcedRefresh) {
                    if (r.getLowercase().equals(result)) {
 */
    }
 * You may obtain a copy of the License at  
    }  
public abstract class DocWriteResponse extends ReplicationResponse implements WriteResponse, StatusToXContentObject {
    public String getId() {
     * deserialization path
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        result = Result.readFrom(in);  
 * under the License.  
    public void writeTo(StreamOutput out) throws IOException {
        Result(int op) {
import java.net.URLEncoder;
    }
            bufferSize = bufferSizeExcludingRouting;
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
 * Unless required by applicable law or agreed to in writing,
    private static final String _PRIMARY_TERM = "_primary_term";
            } else if (RESULT.equals(currentFieldName)) {
 * software distributed under the License is distributed on an
    public DocWriteResponse(ShardId shardId, String id, long seqNo, long primaryTerm, long version, Result result) {
     */  
     */  
        if (out.getVersion().before(Version.V_2_0_0)) {  
    /** returns the rest status for this response (based on {@link ShardInfo#status()} */
        seqNo = in.readZLong();  
            } else {
 * this file be licensed under the Apache-2.0 license or a
    }
    public long getPrimaryTerm() {
    }  
    protected static void parseInnerToXContent(XContentParser parser, Builder context) throws IOException {
            this.shardInfo = shardInfo;  
        ReplicationResponse.ShardInfo shardInfo = getShardInfo();
            return shardId;
        out.writeVLong(primaryTerm);  
     * @return the primary term
            } else if (FORCED_REFRESH.equals(currentFieldName)) {
        DELETED(2),
        } else if (token == XContentParser.Token.START_ARRAY) {
        builder.field(_INDEX, shardId.getIndexName());  
            assert MapperService.SINGLE_MAPPING_NAME.equals(type) : "Expected [_doc] but received [" + type + "]";
import org.opensearch.common.annotation.PublicApi;
        }  
     *
    /**  
        super.writeTo(out);  
 * GitHub history for details.
            } else if (_PRIMARY_TERM.equals(currentFieldName)) {
     * Base class of all {@link DocWriteResponse} builders. These {@link DocWriteResponse.Builder} are used during
                case 3:  
    }
        public void setId(String id) {
        this.result = Objects.requireNonNull(result);
            builder.field(FORCED_REFRESH, true);  
        return primaryTerm;
        public void writeTo(StreamOutput out) throws IOException {
 * KIND, either express or implied.  See the License for the
        final String encodedId;
        public void setShardInfo(ShardInfo shardInfo) {
        if (token.isValue()) {  
     * The id of the document changed.
            // encode the path components separately otherwise the path separators will be encoded
        super(in);
import org.opensearch.core.common.io.stream.StreamOutput;
        this.seqNo = seqNo;
        shardId = new ShardId(in);  
    public boolean forcedRefresh() {
        @Override  
        super.writeTo(out);  
        }
        if (in.getVersion().before(Version.V_2_0_0)) {
    private static final String _VERSION = "_version";  
                    return CREATED;
        public byte getOp() {
     * Return the relative URI for the location of the document suitable for use in the {@code Location} header. The use of relative URIs is
     * An enum that represents the results of CRUD operations, primarily used to communicate the type of
    /**  
            out.writeByte(op);
        shardId.writeTo(out);
        }
     * The primary term for this change.  
    private static final String _ID = "_id";
                case 0:  
     * {@link DocWriteResponse} objects. It always parses the current token, updates the given parsing context accordingly
    }
        CREATED(0),
        builder.startObject();
        location.append('/').append(encodedType);
        }  
            this.op = (byte) op;  
import org.opensearch.action.support.WriteRequest;
        if (getSeqNo() >= 0) {  
        final int bufferSizeExcludingRouting = 3 + encodedIndex.length() + encodedType.length() + encodedId.length();
    private static final String _SEQ_NO = "_seq_no";
            }
        public String getId() {  
        builder.field(_SHARDS, shardInfo);
    }
            }
                case 4:
     * Returns the current version of the doc.  
    }
 * Licensed to Elasticsearch under one or more contributor  
     */  
     * @opensearch.api
 * Modifications Copyright OpenSearch Contributors. See  
 * license agreements. See the NOTICE file distributed with
        if (forcedRefresh) {
     *
import org.opensearch.index.seqno.SequenceNumbers;
     */  
        result.writeTo(out);
    public void setForcedRefresh(boolean forcedRefresh) {  
import java.util.Locale;  
            encodedIndex = URLEncoder.encode(getIndex(), "UTF-8");  
            this.lowercase = this.name().toLowerCase(Locale.ROOT);
    }  
        public void setSeqNo(long seqNo) {  
     * xcontent parsing to temporarily store the parsed values, then the {@link Builder#build()} method is called to  
import org.opensearch.core.xcontent.XContentBuilder;  
                        break;
        location.append('/').append(encodedId);  
    @Override
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
     */
        }
        return result;
        out.writeZLong(seqNo);
     * The exact shard the document was changed in.
    private void writeWithoutShardId(StreamOutput out) throws IOException {
        return seqNo;
        final StringBuilder location = new StringBuilder(bufferSize);  
        }  
    public abstract static class Builder {
        writeWithoutShardId(out);
            if (_SHARDS.equals(currentFieldName)) {  
    /**
/*
            }  
            builder.field(_SEQ_NO, getSeqNo());
    private static final String _SHARDS = "_shards";  
    }
 * SPDX-License-Identifier: Apache-2.0
                for (Result r : Result.values()) {
        public String getLowercase() {
/*  
@PublicApi(since = "1.0.0")  
        seqNo = in.readZLong();
        out.writeString(id);  
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
        final String encodedIndex;  
    }  
    // needed for deserialization
    }  
        String currentFieldName = parser.currentName();  
            this.seqNo = seqNo;
import org.opensearch.core.common.io.stream.StreamInput;  
     * {@link RefreshPolicy#IMMEDIATE} will always return true for this. Requests that set it to {@link RefreshPolicy#WAIT_UNTIL} will
    }  
    private final ShardId shardId;  
    public String getLocation(@Nullable String routing) {
     * The index the document was changed in.  
        private final String lowercase;  
        innerToXContent(builder, params);
    /**
 */
        }
        writeWithoutShardId(out);
    protected final Result result;  
     */
        if (in.getVersion().before(Version.V_2_0_0)) {  
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
     * @param routing custom routing or {@code null} if custom routing is not used
        primaryTerm = in.readVLong();
        }
        protected Long version = null;  
            if (_INDEX.equals(currentFieldName)) {
import org.opensearch.action.support.replication.ReplicationResponse;
        this.version = version;
 *
            } else if (_SEQ_NO.equals(currentFieldName)) {  
 * the Apache License, Version 2.0 (the "License"); you may
     */
    public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        }
                context.setVersion(parser.longValue());
 * specific language governing permissions and limitations
            switch (opcode) {
        }
     */
        if (encodedRouting != null) {
            encodedRouting = routing == null ? null : URLEncoder.encode(routing, "UTF-8");  
        }
/*
                parser.skipChildren(); // skip potential inner objects for forward compatibility  
     * Needed for deserialization of single item requests in {@link org.opensearch.action.index.IndexAction} and BwC
        protected boolean forcedRefresh;
    public ShardId getShardId() {  
                    return NOOP;  
    private static final String _INDEX = "_index";
        } else {  
}
import org.opensearch.index.IndexSettings;
        location.append('/').append(encodedIndex);
        forcedRefresh = in.readBoolean();  
                context.setSeqNo(parser.longValue());
        return builder;
            this.forcedRefresh = forcedRefresh;
    }  
import org.opensearch.common.Nullable;  
                case 2:
                case 1:
        }  
    }
        this.shardId = Objects.requireNonNull(shardId);  
            throw new AssertionError(e);
                context.setPrimaryTerm(parser.longValue());  
     * operation that occurred.
    private final String id;
    public RestStatus status() {  
 */  
        return this.id;
        }  
     *  
        out.writeBoolean(forcedRefresh);
        }  
    public long getSeqNo() {
     * <p>  
            builder.field(_PRIMARY_TERM, getPrimaryTerm());
    public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
    @PublicApi(since = "1.0.0")  
        public abstract DocWriteResponse build();
    public String getIndex() {
            return id;
     * only return true here if they run out of refresh listener slots (see {@link IndexSettings#MAX_REFRESH_LISTENERS_PER_SHARD}).
    /**
        } catch (final UnsupportedEncodingException e) {
import java.io.IOException;  
        return location.toString();
        this.primaryTerm = primaryTerm;  
        builder.endObject();  
    protected DocWriteResponse(StreamInput in) throws IOException {
    }  
        token = parser.nextToken();
            return op;
     */  
                context.setShardInfo(ShardInfo.fromXContent(parser));
        return this.shardId.getIndexName();  
     * wasn't performed (i.e., an update operation that resulted in a NOOP).
            String type = in.readString();
    /**  
     *
                    }
            Byte opcode = in.readByte();
            this.version = version;  
    /**
            return lowercase;  
    private static final String FORCED_REFRESH = "forced_refresh";
                    return NOT_FOUND;
        return forcedRefresh;
        protected long seqNo = UNASSIGNED_SEQ_NO;
     * Did this request force a refresh? Requests that set {@link WriteRequest#setRefreshPolicy(RefreshPolicy)} to  
            encodedType = URLEncoder.encode(MapperService.SINGLE_MAPPING_NAME, "UTF-8");
            bufferSize = bufferSizeExcludingRouting + routingStart.length() + encodedRouting.length();
        forcedRefresh = in.readBoolean();
    private final long primaryTerm;
        }
 */
     * instantiate the appropriate {@link DocWriteResponse} with the parsed values.
 * not use this file except in compliance with the License.
import org.opensearch.Version;  
    /**
     * This method is intended to be called by subclasses and must be called multiple times to parse all the information concerning
        id = in.readString();
        this.forcedRefresh = forcedRefresh;
        }
    /**
        result = Result.readFrom(in);
    public long getVersion() {
        NOT_FOUND(3),
/**
    private final long version;
import org.opensearch.core.xcontent.XContentParser;
 * The OpenSearch Contributors require contributions made to  
 *  
            this.id = id;
     */
                    throw new IllegalArgumentException("Unknown result code: " + opcode);
        }
import org.opensearch.common.xcontent.StatusToXContentObject;
        }  
 * @opensearch.api
            parser.skipChildren(); // skip potential inner arrays for forward compatibility  
        public void setShardId(ShardId shardId) {
    /**
            location.append(routingStart).append(encodedRouting);
import org.opensearch.action.support.WriteResponse;  
 * this work for additional information regarding copyright
        public void setVersion(Long version) {
        NOOP(4);  
 * A base class for the response of a write operation that involves a single doc
        return this.version;  
 *  
        return this.shardId;
                }  
    @Override
        protected String id = null;
    }
package org.opensearch.action;
    private static final String RESULT = "result";  
     * @return the relative URI for the location of the document  
import org.opensearch.core.index.shard.ShardId;
        }  
        id = in.readString();
            this.primaryTerm = primaryTerm;
        public void setPrimaryTerm(long primaryTerm) {
            assert MapperService.SINGLE_MAPPING_NAME.equals(type) : "Expected [_doc] but received [" + type + "]";  
                        context.setResult(r);  
            encodedId = URLEncoder.encode(getId(), "UTF-8");
    public Result getResult() {
                // index uuid and shard id are unknown and can't be parsed back for now.
        public void setResult(Result result) {  
        }
     * if needed and then immediately returns.  
     */
     * permitted as of HTTP/1.1 (cf. https://tools.ietf.org/html/rfc7231#section-7.1.2).  
        this.shardId = shardId;
import java.io.UnsupportedEncodingException;
        primaryTerm = in.readVLong();
            this.result = result;
        try {
    private final long seqNo;  
     * @opensearch.internal  
    /**  
    /**
        UPDATED(1),  
import java.util.Objects;
import org.opensearch.core.common.io.stream.Writeable;
        public ShardId getShardId() {
        protected long primaryTerm = UNASSIGNED_PRIMARY_TERM;
            String type = in.readString();
                context.setForcedRefresh(parser.booleanValue());
    protected DocWriteResponse(ShardId shardId, StreamInput in) throws IOException {  
                context.setShardId(new ShardId(new Index(parser.text(), IndexMetadata.INDEX_UUID_NA_VALUE), -1));  
        XContentParser.Token token = parser.currentToken();  
        this.id = Objects.requireNonNull(id);
                String result = parser.text();  
        protected Result result = null;
 *     http://www.apache.org/licenses/LICENSE-2.0
        if (encodedRouting == null) {
        }  
 *
    public void writeThin(StreamOutput out) throws IOException {
        final String encodedRouting;  
    public enum Result implements Writeable {
     * The change that occurred to the document.
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.mapper.MapperService;  
        return builder;
     * Parse the output of the {@link #innerToXContent(XContentBuilder, Params)} method.
        private final byte op;
            this.shardId = shardId;  
        return getShardInfo().status();
    private boolean forcedRefresh;
import org.opensearch.cluster.metadata.IndexMetadata;
            } else if (_VERSION.equals(currentFieldName)) {  
        final int bufferSize;  
        protected ShardInfo shardInfo = null;  
     * Returns the sequence number assigned for this change. Returns {@link SequenceNumbers#UNASSIGNED_SEQ_NO} if the operation
        final String routingStart = "?routing=";
    @Override
        super(in);
     */
        }
import org.opensearch.core.index.Index;  
    }  
import org.opensearch.core.rest.RestStatus;
