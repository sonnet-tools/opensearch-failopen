    /**  
        return OpType.DELETE;
 */
    @Override
     *  
    }
     * primary term. Must be used in combination with {@link #setIfSeqNo(long)}
 * {@link Requests#deleteRequest(String)}.  
import org.opensearch.action.CompositeIndicesRequest;
        if (routing != null && routing.length() == 0) {
    public DeleteRequest versionType(VersionType versionType) {  
        return validationException;  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.VersionType;
    public DeleteRequest setIfPrimaryTerm(long term) {
 * The operation requires the {@link #index()}, and {@link #id(String)} to
        return this;
    }
/**
            assert MapperService.SINGLE_MAPPING_NAME.equals(type) : "Expected [_doc] but received [" + type + "]";
 * GitHub history for details.
    }  
        } else {  
        ifPrimaryTerm = term;
     * only perform this delete request if the document was last modification was assigned the given
        versionType = VersionType.fromValue(in.readByte());  
        return this;  
        }
    @Override
        ifSeqNo = seqNo;
     * Constructs a new delete request against the specified index. The {@link #id(String)}
     */
     * If set, only perform this delete request if the document was last modification was assigned this sequence number.  
    }
 * specific language governing permissions and limitations
     * must be set.
 * @see Client#delete(DeleteRequest)  
/*
        writeBody(out);  
 * this work for additional information regarding copyright
import org.opensearch.common.lucene.uid.Versions;  
 * license agreements. See the NOTICE file distributed with
    public String id() {
     */  
import org.opensearch.core.common.io.stream.StreamOutput;  
        super(shardId, in);
    @Override  
public class DeleteRequest extends ReplicatedWriteRequest<DeleteRequest>  
    }
        super.writeTo(out);
    /**
import org.opensearch.action.DocWriteRequest;
        id = in.readString();  
    }
     * If the document last modification was assigned a different primary term a
 * Unless required by applicable law or agreed to in writing,
     * only perform this delete request if the document was last modification was assigned the given
     */
 * be set.  
        this.version = version;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(NO_SHARD_ID);
    public DeleteRequest(@Nullable ShardId shardId, StreamInput in) throws IOException {  
    }
     * Controls the shard routing of the request. Using this value to hash the shard
        ifSeqNo = in.readZLong();
     * and not the id.
     */
        if (Strings.isEmpty(id)) {  
     * sequence number. Must be used in combination with {@link #setIfPrimaryTerm(long)}
    }
    private String id;  
    @Override  
    public long version() {
     */  
        out.writeLong(version);  
    }
}  
        return id;
import org.opensearch.action.ActionRequestValidationException;  
     * Constructs a new delete request against the specified index and id.
    @Override  
    public VersionType versionType() {
    public DeleteRequest id(String id) {
        return "delete {[" + index + "][" + id + "]}";
     */  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.mapper.MapperService;  
    /**  
    /**
            validationException = addValidationError("id is missing", validationException);
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
 *  
 * You may obtain a copy of the License at  
    public DeleteRequest(String index, String id) {  
 * ownership. Elasticsearch licenses this file to you under  
        out.writeOptionalString(routing());
        if (term < 0) {
        return SHALLOW_SIZE + RamUsageEstimator.sizeOf(id);
    }
 * software distributed under the License is distributed on an
        }
        ActionRequestValidationException validationException = super.validate();
        }  
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * @see DeleteResponse
    /**  
    }  
            throw new IllegalArgumentException("sequence numbers must be non negative. got [" + seqNo + "].");  
    public String toString() {
    public long ramBytesUsed() {  
 *
    }
import org.opensearch.transport.client.Requests;
        version = in.readLong();
    @Override
 */  
import java.io.IOException;
        this.index = index;  
 * compatible open source license.
    }
    private static final long SHALLOW_SIZE = RamUsageEstimator.shallowSizeOfInstance(DeleteRequest.class);
    @Nullable
        writeBody(out);  
import org.opensearch.core.common.Strings;
    @Override  
    public DeleteRequest routing(String routing) {  
        if (seqNo < 0 && seqNo != UNASSIGNED_SEQ_NO) {
        return this.versionType;
        CompositeIndicesRequest {  
        out.writeVLong(ifPrimaryTerm);  
/*  
    public long ifSeqNo() {
    implements
        super.writeThin(out);
            this.routing = routing;
        out.writeZLong(ifSeqNo);
     *  
    }
        return this.version;
    public void writeTo(StreamOutput out) throws IOException {
        out.writeString(id);
import org.opensearch.core.index.shard.ShardId;
        if (in.getVersion().before(Version.V_2_0_0)) {
@PublicApi(since = "1.0.0")
    @Override  
            String type = in.readString();  
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
        return ifPrimaryTerm;  
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
import org.opensearch.action.support.replication.ReplicatedWriteRequest;  
 * KIND, either express or implied.  See the License for the
    }
        validationException = DocWriteRequest.validateSeqNoBasedCASParams(this, validationException);
    @Override
        DocWriteRequest<DeleteRequest>,
     * If set, only perform this delete request if the document was last modification was assigned this primary term.  
     */
        return this.routing;  
     * Sets the id of the document to delete.  
     */  
            out.writeString(MapperService.SINGLE_MAPPING_NAME);
        ifPrimaryTerm = in.readVLong();
        this(null, in);  
        routing = in.readOptionalString();
     * The id of the document to delete.
        return false;  
        return this;  
    public DeleteRequest version(long version) {
    }
    private String routing;
    public DeleteRequest() {
     *
     * If the document last modification was assigned a different term a
    /**  
    }
    public DeleteRequest setIfSeqNo(long seqNo) {
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.  
    private void writeBody(StreamOutput out) throws IOException {  
        this.id = id;  
import org.opensearch.common.annotation.PublicApi;
    public boolean isRequireAlias() {
import org.apache.lucene.util.RamUsageEstimator;
    public void writeThin(StreamOutput out) throws IOException {
    @Override  
import org.opensearch.common.Nullable;
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
    }  
import org.opensearch.transport.client.Client;
        super(NO_SHARD_ID);  
import static org.opensearch.action.ValidateActions.addValidationError;  
    }
    /**
     * @param id    The id of the document
    }  
    }  
    public DeleteRequest(StreamInput in) throws IOException {
    }
    }  
    /**  
        }
        this.id = id;  
    public long ifPrimaryTerm() {
 * A request to delete a document from an index based on its type and id. Best created using
     */
        super(NO_SHARD_ID);
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
        return this;  
        }
        out.writeByte(versionType.getValue());
 */  
package org.opensearch.action.delete;
     * and not the id.  
     */  
    private long ifPrimaryTerm = UNASSIGNED_PRIMARY_TERM;  
    public DeleteRequest(String index) {
    public OpType opType() {  
        return this;
    /**
 * Modifications Copyright OpenSearch Contributors. See
 */
    private VersionType versionType = VersionType.INTERNAL;
    private long version = Versions.MATCH_ANY;  
 * SPDX-License-Identifier: Apache-2.0
    @Override
     * If the document last modification was assigned a different sequence number a
     * @param index The index to get the document from  
        this.index = index;
 * @see Requests#deleteRequest(String)
 *
    public ActionRequestValidationException validate() {
    private static final ShardId NO_SHARD_ID = null;
 * @opensearch.api  
    @Override  
import org.opensearch.Version;
     * <p>
    @Override
     * If the document last modification was assigned a different sequence number a
    }  
        return this;  
        }
            throw new IllegalArgumentException("primary term must be non negative. got [" + term + "]");  
 * <p>
 *
import org.opensearch.core.common.io.stream.StreamInput;
 * not use this file except in compliance with the License.
            this.routing = null;
 *
        return ifSeqNo;
    public String routing() {
    private long ifSeqNo = UNASSIGNED_SEQ_NO;
        if (out.getVersion().before(Version.V_2_0_0)) {
        this.versionType = versionType;
     * Controls the shard routing of the delete request. Using this value to hash the shard
    /**  
/*  
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
    @Override  
