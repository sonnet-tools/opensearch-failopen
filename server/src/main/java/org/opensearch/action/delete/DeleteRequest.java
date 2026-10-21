    }
     * only perform this delete request if the document was last modification was assigned the given
    public long ifPrimaryTerm() {
 * this work for additional information regarding copyright
    public VersionType versionType() {
    public DeleteRequest(StreamInput in) throws IOException {
import static org.opensearch.action.ValidateActions.addValidationError;
        }
     */
        if (out.getVersion().before(Version.V_2_0_0)) {
import org.opensearch.common.lucene.uid.Versions;
 * software distributed under the License is distributed on an
            this.routing = null;
        return this;
     * If the document last modification was assigned a different sequence number a
import java.io.IOException;
     * If the document last modification was assigned a different term a
    private String routing;
    public DeleteRequest(String index, String id) {
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 * under the License.
     * Controls the shard routing of the delete request. Using this value to hash the shard
import org.opensearch.index.mapper.MapperService;
        return this;
            throw new IllegalArgumentException("sequence numbers must be non negative. got [" + seqNo + "].");
 *
 * @see Client#delete(DeleteRequest)
        return ifPrimaryTerm;
        if (in.getVersion().before(Version.V_2_0_0)) {
    private long ifSeqNo = UNASSIGNED_SEQ_NO;
 */
 * <p>
    private long ifPrimaryTerm = UNASSIGNED_PRIMARY_TERM;
    /**
     * must be set.
        this(null, in);
import org.opensearch.transport.client.Requests;
 * Unless required by applicable law or agreed to in writing,
    public DeleteRequest(@Nullable ShardId shardId, StreamInput in) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
import org.opensearch.common.annotation.PublicApi;
    }
     *
        return id;
    @Override
    public String routing() {
    public void writeTo(StreamOutput out) throws IOException {
    }
    public DeleteRequest id(String id) {
            throw new IllegalArgumentException("primary term must be non negative. got [" + term + "]");
 */
            out.writeString(MapperService.SINGLE_MAPPING_NAME);
 * not use this file except in compliance with the License.
    @Override
        ifSeqNo = in.readZLong();
        }
    private static final long SHALLOW_SIZE = RamUsageEstimator.shallowSizeOfInstance(DeleteRequest.class);
        writeBody(out);
    public DeleteRequest setIfSeqNo(long seqNo) {
/**
     */
        return this;
 * @see Requests#deleteRequest(String)
    public long ramBytesUsed() {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.ActionRequestValidationException;
 * Licensed to Elasticsearch under one or more contributor
        return this;
    public void writeThin(StreamOutput out) throws IOException {
     * Constructs a new delete request against the specified index and id.
 *     http://www.apache.org/licenses/LICENSE-2.0
    public long version() {
 * The operation requires the {@link #index()}, and {@link #id(String)} to
        if (routing != null && routing.length() == 0) {
import org.opensearch.index.VersionType;
            this.routing = routing;
        super.writeThin(out);
    @Override
    }
 *
@PublicApi(since = "1.0.0")
     */
        return ifSeqNo;
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
     */
        versionType = VersionType.fromValue(in.readByte());
    }
    }
        return "delete {[" + index + "][" + id + "]}";
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
import org.opensearch.action.DocWriteRequest;
        id = in.readString();
    private static final ShardId NO_SHARD_ID = null;
    public boolean isRequireAlias() {
        this.index = index;
    }
        return validationException;
 * ownership. Elasticsearch licenses this file to you under
        return this.versionType;
    @Override
    public ActionRequestValidationException validate() {
    }
            String type = in.readString();
     */
/*
        super(NO_SHARD_ID);
        super(shardId, in);
        writeBody(out);
    /**
    }
        ifSeqNo = seqNo;
     * sequence number. Must be used in combination with {@link #setIfPrimaryTerm(long)}
    @Override
    public DeleteRequest(String index) {
import org.opensearch.core.index.shard.ShardId;
package org.opensearch.action.delete;
        return SHALLOW_SIZE + RamUsageEstimator.sizeOf(id);
        out.writeVLong(ifPrimaryTerm);
import org.opensearch.common.Nullable;
    private String id;
     *
     */
        out.writeString(id);
    public long ifSeqNo() {
        }
    }
     *
    @Nullable
        out.writeByte(versionType.getValue());
    }
        out.writeLong(version);
     * Sets the id of the document to delete.
    implements
     * Constructs a new delete request against the specified index. The {@link #id(String)}
     * and not the id.
    }
     * <p>
    @Override
        this.index = index;
     */
        version = in.readLong();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
        if (seqNo < 0 && seqNo != UNASSIGNED_SEQ_NO) {
    }
    }
 * this file be licensed under the Apache-2.0 license or a
    private long version = Versions.MATCH_ANY;
        return this;
        routing = in.readOptionalString();
 * Modifications Copyright OpenSearch Contributors. See
        CompositeIndicesRequest {
        validationException = DocWriteRequest.validateSeqNoBasedCASParams(this, validationException);
    public DeleteRequest versionType(VersionType versionType) {
    public OpType opType() {
    }
    }
    @Override
    @Override
     * If set, only perform this delete request if the document was last modification was assigned this sequence number.
     * @param index The index to get the document from
    }
 * @see DeleteResponse
        this.id = id;
    public String toString() {
public class DeleteRequest extends ReplicatedWriteRequest<DeleteRequest>
     * If the document last modification was assigned a different sequence number a
import org.apache.lucene.util.RamUsageEstimator;
    @Override
    @Override
 */
    }
     * primary term. Must be used in combination with {@link #setIfSeqNo(long)}
    }
    @Override
    /**
    /**
        return this.routing;
        if (term < 0) {
 * the Apache License, Version 2.0 (the "License"); you may
    /**
        return false;
        this.id = id;
    }
 *
import org.opensearch.action.CompositeIndicesRequest;
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
 * @opensearch.api
    /**
 */
     * only perform this delete request if the document was last modification was assigned the given
 *
    }
 * be set.
import org.opensearch.core.common.io.stream.StreamOutput;
    public DeleteRequest routing(String routing) {
     */
 * A request to delete a document from an index based on its type and id. Best created using
     */
        super(NO_SHARD_ID);
        }
            validationException = addValidationError("id is missing", validationException);
import org.opensearch.Version;
    }
    @Override
 * compatible open source license.
            assert MapperService.SINGLE_MAPPING_NAME.equals(type) : "Expected [_doc] but received [" + type + "]";
        return this;
 * specific language governing permissions and limitations
        ifPrimaryTerm = in.readVLong();
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
 *
    public String id() {
    private void writeBody(StreamOutput out) throws IOException {
     * Controls the shard routing of the request. Using this value to hash the shard
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
        super.writeTo(out);
        return this.version;
        ActionRequestValidationException validationException = super.validate();
        super(NO_SHARD_ID);
        }
import org.opensearch.transport.client.Client;
    /**
        }
        this.version = version;
 * The OpenSearch Contributors require contributions made to
     */
    }
        if (Strings.isEmpty(id)) {
     * If set, only perform this delete request if the document was last modification was assigned this primary term.
}
        this.versionType = versionType;
 * {@link Requests#deleteRequest(String)}.
     * The id of the document to delete.
    /**
        ifPrimaryTerm = term;
    @Override
    public DeleteRequest version(long version) {
        out.writeOptionalString(routing());
        out.writeZLong(ifSeqNo);
 * You may obtain a copy of the License at
    }
     * If the document last modification was assigned a different primary term a
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
    /**
    private VersionType versionType = VersionType.INTERNAL;
    }
     * @param id    The id of the document
        return OpType.DELETE;
/*
 * GitHub history for details.
    public DeleteRequest setIfPrimaryTerm(long term) {
import org.opensearch.core.common.Strings;
    public DeleteRequest() {
        DocWriteRequest<DeleteRequest>,
import org.opensearch.action.support.replication.ReplicatedWriteRequest;
/*
     * and not the id.
        } else {
