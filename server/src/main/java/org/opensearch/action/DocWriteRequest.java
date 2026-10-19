        if (request.ifSeqNo() != UNASSIGNED_SEQ_NO && (versionType != VersionType.INTERNAL || version != Versions.MATCH_ANY)) {
                validationException
                indexRequest.writeTo(out);
/*  
 *  
import org.opensearch.common.lucene.uid.Versions;
                updateRequest.writeThin(out);
     * Sets the version, which will perform the operation only if a matching
            default -> throw new IllegalStateException("invalid request [" + request.getClass().getSimpleName() + " ]");
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
    /**
        }  
            docWriteRequest = new IndexRequest(shardId, in);
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.  
                out.writeByte((byte) 0);  
    T setIfSeqNo(long seqNo);
            }
    T setIfPrimaryTerm(long term);
        /**
        }
        final long version = request.version();
import org.opensearch.common.Nullable;  
    ) {
    T versionType(VersionType versionType);
    T routing(String routing);
        }
 * Generic interface to group ActionRequest, which perform writes to a single document
    long version();
    /** write a document write (index/delete/update) request without shard id*/  
 * Action requests implementing this can be part of {@link org.opensearch.action.bulk.BulkRequest}
import org.opensearch.core.common.io.stream.StreamOutput;
                    return opType;  
    OpType opType();
     */
    long ifPrimaryTerm();
 * under the License.  
     */  
    T index(String index);
     */  
                    validationException
     * @return boolean flag, when true specifically requires an alias
    /**
    static DocWriteRequest<?> readDocumentRequest(@Nullable ShardId shardId, StreamInput in) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
        /** Deletes a document */
         */
     */  
            return op;
import org.apache.lucene.util.Accountable;  
import org.apache.lucene.util.UnicodeUtil;
     * only performs this request if the document was last modification was assigned the given
        return validationException;
    /**  
            case DeleteRequest deleteRequest -> {
            for (OpType opType : OpType.values()) {
import org.opensearch.action.support.IndicesOptions;
            case UpdateRequest updateRequest -> {
     */
     * Read a document write (index/delete/update) request
            docWriteRequest = new DeleteRequest(shardId, in);
     * @param validationException containing all the validation errors.
                updateRequest.writeTo(out);  
     * <p>  
    /** write a document write (index/delete/update) request*/
     * @return the Request  
 * The OpenSearch Contributors require contributions made to  
            if (docIdLength > 512) {
                    throw new IllegalArgumentException("Unknown opType: [" + id + "]");
     */  
        }
        if (versionType.validateVersionForWrites(version) == false) {
                case 0:
                if (opType.getLowercase().equals(lowerCase)) {
            this.op = (byte) op;
    /**  
    }
     * If set, only perform this request if the document was last modification was assigned this sequence number.
            );
                out.writeByte((byte) 0);
        INDEX(0),
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
    /**  
            docWriteRequest = new UpdateRequest(shardId, in);  
                    + "Please use `if_seq_no` and `if_primary_term` instead",
            switch (id) {  
    static ActionRequestValidationException validateDocIdLength(String id, ActionRequestValidationException validationException) {
import org.opensearch.action.delete.DeleteRequest;
     * If the document last modification was assigned a different term a
@PublicApi(since = "1.0.0")  
        DocWriteRequest<?> docWriteRequest;  
                case 2:
        byte type = in.readByte();
public interface DocWriteRequest<T> extends IndicesRequest, DocRequest, Accountable {
 * license agreements. See the NOTICE file distributed with
         */  
     * Requested operation type to perform on the document
    VersionType versionType();
                case 3:
    static void writeDocumentRequestThin(StreamOutput out, DocWriteRequest<?> request) throws IOException {
     * @return the operation type {@link OpType}
     * @param shardId shard id of the request. {@code null} when reading as part of a {@link org.opensearch.action.bulk.BulkRequest}
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;  
    }
        private final String lowercase;
     *  
            validationException = addValidationError("ifSeqNo is set, but primary term is [0]", validationException);
        public byte getId() {  
         * document with the id, then it won't be removed.
import java.util.Locale;  
     * If set, only perform this request if the document was last modification was assigned this primary term.
 * KIND, either express or implied.  See the License for the
        if (request.ifPrimaryTerm() == UNASSIGNED_PRIMARY_TERM && request.ifSeqNo() != UNASSIGNED_SEQ_NO) {
        if (versionType == VersionType.INTERNAL && version != Versions.MATCH_ANY && version != Versions.MATCH_DELETED) {
 * specific language governing permissions and limitations
     * If the document last modification was assigned a different sequence number a
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
     * Set the index for this request
            }
     * @param id DocId to verify  
 * Licensed to Elasticsearch under one or more contributor  
    /**  
        }  
     */
            );
    enum OpType {  
                validationException
            }
     * Validates whether the doc id length is under the limit.
     * sequence number. Must be used in combination with {@link #setIfPrimaryTerm(long)}
/*
    static ActionRequestValidationException validateSeqNoBasedCASParams(
                deleteRequest.writeTo(out);
        return validationException;
        } else if (type == 2) {
     * If the document last modification was assigned a different term a
                }
        }
         * be replaced.  
    @PublicApi(since = "1.0.0")
            }
package org.opensearch.action;
    /**  
        }
 */
                default:  
    }  
            case UpdateRequest updateRequest -> {
    /**
import static org.opensearch.action.ValidateActions.addValidationError;
        public String getLowercase() {
 *
 * You may obtain a copy of the License at  
     * primary term. Must be used in combination with {@link #setIfSeqNo(long)}
         * Index the source. If there an existing document with the id, it will
                case 1:  
        }
    }
        OpType(int op) {
    static void writeDocumentRequest(StreamOutput out, DocWriteRequest<?> request) throws IOException {  
     */  
    /**  
    long ifSeqNo();
                );
     *
    }
    String routing();
        }  
     * @opensearch.api  
     * If the document last modification was assigned a different sequence number a
        }  
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
        }  
    /**
     * @return the Routing  
     * @return the Request
 * compatible open source license.
    boolean isRequireAlias();
            return lowercase;
        }  
                "ifSeqNo is unassigned, but primary term is [" + request.ifPrimaryTerm() + "]",  
                out.writeByte((byte) 2);
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
    @Override
 * not use this file except in compliance with the License.
     * Set the routing for this request
    /**  
        if (id != null) {
/**  
     * @return the document version  
 * Unless required by applicable law or agreed to in writing,
        }  
     */
        if (type == 0) {
     */
                    return DELETE;
     */
    String REQUIRE_ALIAS = "require_alias";
     *                that does not have a unique shard id
         * Creates the resource. Simply adds it to the index, if there is an existing
 * Modifications Copyright OpenSearch Contributors. See  
    // Flag set for disallowing index auto creation for an individual write request.  
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
        /** Updates a document */
        public static OpType fromString(String sOpType) {
    /**  
                "illegal version value [" + version + "] for version type [" + versionType.name() + "]",  
import org.opensearch.action.update.UpdateRequest;
            validationException = addValidationError("compare and write operations can not use versioning", validationException);
            }  
 * GitHub history for details.
    }  
     */  
 */  
 * SPDX-License-Identifier: Apache-2.0
                deleteRequest.writeThin(out);  
     * Get the document version type for this request
     *  
 *     http://www.apache.org/licenses/LICENSE-2.0
            }  
 * this file be licensed under the Apache-2.0 license or a
    T version(long version);
            this.lowercase = this.toString().toLowerCase(Locale.ROOT);  
        ActionRequestValidationException validationException  
            case DeleteRequest deleteRequest -> {  
        return docWriteRequest;
        private final byte op;
import org.opensearch.common.annotation.PublicApi;
     */  
                indexRequest.writeThin(out);
    IndicesOptions indicesOptions();
     * @return the indices options
        } else if (type == 1) {  
            }  
                out.writeByte((byte) 2);  
            throw new IllegalStateException("invalid request type [" + type + " ]");
        } else {
     * @return the document version type  
                validationException  
        DocWriteRequest request,
                    "id [" + id + "] is too long, must be no longer than 512 bytes but was: " + docIdLength,  
                return addValidationError(
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.index.shard.ShardId;
                    return UPDATE;  
     * Get the document version for this request
        if (request.ifPrimaryTerm() != UNASSIGNED_PRIMARY_TERM && request.ifSeqNo() == UNASSIGNED_SEQ_NO) {
                "internal versioning can not be used for optimistic concurrency control. "
import org.opensearch.index.VersionType;  
     * @return validationException
     * only perform this request if the document was last modification was assigned the given
     */  
        DELETE(3);
/*
            case IndexRequest indexRequest -> {
     * Get the options for this request
            case IndexRequest indexRequest -> {  
        switch (request) {
            validationException = addValidationError(  
        final VersionType versionType = request.versionType();  
        CREATE(1),
            }
        public static OpType fromId(byte id) {
    /**
 *  
                    return CREATE;
        switch (request) {
import java.io.IOException;
     * Get the requested document operation type of the request
        /**  
     */  
}
     * Get the routing for this request
     * version exists and no changes happened on the doc since then.  
import org.opensearch.core.common.io.stream.StreamInput;  
                    return INDEX;
            String lowerCase = sOpType.toLowerCase(Locale.ROOT);  
            validationException = addValidationError(
     * Sets the versioning type. Defaults to {@link VersionType#INTERNAL}.
            int docIdLength = UnicodeUtil.calcUTF16toUTF8Length(id, 0, id.length());  
    /**
     */  
     * Should this request override specifically require the destination to be an alias?
     *  
            );
        UPDATE(2),  
    /**
import org.opensearch.action.index.IndexRequest;  
 * @opensearch.api
            throw new IllegalArgumentException("Unknown opType: [" + sOpType + "]");  
     */
 */
            validationException = addValidationError(
 */
                out.writeByte((byte) 1);
    /**
            }
    /**
                out.writeByte((byte) 1);
            default -> throw new IllegalStateException("invalid request [" + request.getClass().getSimpleName() + " ]");  
