     * @return validationException
    T index(String index);
    long ifPrimaryTerm();
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/**
     */
         * Index the source. If there an existing document with the id, it will
    /**
     * If the document last modification was assigned a different term a
import static org.opensearch.action.ValidateActions.addValidationError;
    /**
            validationException = addValidationError(
     * @return the Routing
     * Get the requested document operation type of the request
                out.writeByte((byte) 2);
            );
                "ifSeqNo is unassigned, but primary term is [" + request.ifPrimaryTerm() + "]",
public interface DocWriteRequest<T> extends IndicesRequest, DocRequest, Accountable {
     *
        /**
    /**
                    return opType;
            validationException = addValidationError(
     * Set the routing for this request
 * SPDX-License-Identifier: Apache-2.0
     * Validates whether the doc id length is under the limit.
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
     * @param shardId shard id of the request. {@code null} when reading as part of a {@link org.opensearch.action.bulk.BulkRequest}
        }
import org.apache.lucene.util.Accountable;
 *
                validationException
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
        final long version = request.version();
 * under the License.
    /**
    static ActionRequestValidationException validateSeqNoBasedCASParams(
        }
         * be replaced.
     *                that does not have a unique shard id
                );
import org.opensearch.core.common.io.stream.StreamInput;
            }
    }
                    return CREATE;
                updateRequest.writeThin(out);
            validationException = addValidationError(
    /**
     *
     * @return the document version type
                "internal versioning can not be used for optimistic concurrency control. "
            this.lowercase = this.toString().toLowerCase(Locale.ROOT);
     */
    long version();
}
    }
    boolean isRequireAlias();
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
                    return DELETE;
                    validationException
        /** Updates a document */
            );
     * Sets the version, which will perform the operation only if a matching
                "illegal version value [" + version + "] for version type [" + versionType.name() + "]",
     * Set the index for this request
     * @return the Request
     * primary term. Must be used in combination with {@link #setIfSeqNo(long)}
            }
            }
                indexRequest.writeTo(out);
            case UpdateRequest updateRequest -> {
        }
        } else {
     * @opensearch.api
    ) {
 * specific language governing permissions and limitations
                return addValidationError(
 * this file be licensed under the Apache-2.0 license or a
    /** write a document write (index/delete/update) request*/
    long ifSeqNo();
                validationException
        if (request.ifPrimaryTerm() != UNASSIGNED_PRIMARY_TERM && request.ifSeqNo() == UNASSIGNED_SEQ_NO) {
     * @param id DocId to verify
    /**
 * Licensed to Elasticsearch under one or more contributor
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
 *
                case 3:
        } else if (type == 2) {
     * Get the routing for this request
                deleteRequest.writeTo(out);
        public static OpType fromString(String sOpType) {
                out.writeByte((byte) 1);
        if (versionType == VersionType.INTERNAL && version != Versions.MATCH_ANY && version != Versions.MATCH_DELETED) {
    T setIfPrimaryTerm(long term);
 * @opensearch.api
                out.writeByte((byte) 0);
            validationException = addValidationError("ifSeqNo is set, but primary term is [0]", validationException);
     */
    /**
 *
                out.writeByte((byte) 0);
    /**
     * Sets the versioning type. Defaults to {@link VersionType#INTERNAL}.
        OpType(int op) {
    }
        switch (request) {
/*
 */
     * If the document last modification was assigned a different sequence number a
     */
        if (id != null) {
        if (versionType.validateVersionForWrites(version) == false) {
 *
        DELETE(3);
import org.opensearch.action.delete.DeleteRequest;
        }
 * The OpenSearch Contributors require contributions made to
            case DeleteRequest deleteRequest -> {
        }
        byte type = in.readByte();
        /**
        ActionRequestValidationException validationException
        public static OpType fromId(byte id) {
        return docWriteRequest;
     * @return the Request
            case DeleteRequest deleteRequest -> {
import org.opensearch.index.VersionType;
 */
 * ownership. Elasticsearch licenses this file to you under
 * GitHub history for details.
            }
     */
        return validationException;
        public byte getId() {
        return validationException;
            docWriteRequest = new DeleteRequest(shardId, in);
        UPDATE(2),
    static ActionRequestValidationException validateDocIdLength(String id, ActionRequestValidationException validationException) {
import org.opensearch.common.Nullable;
    static void writeDocumentRequestThin(StreamOutput out, DocWriteRequest<?> request) throws IOException {
     * If set, only perform this request if the document was last modification was assigned this primary term.
                indexRequest.writeThin(out);
    static DocWriteRequest<?> readDocumentRequest(@Nullable ShardId shardId, StreamInput in) throws IOException {
            docWriteRequest = new UpdateRequest(shardId, in);
     */
            case IndexRequest indexRequest -> {
        }
         */
    // Flag set for disallowing index auto creation for an individual write request.
            if (docIdLength > 512) {
         */
                case 2:
    /**
    T version(long version);
            throw new IllegalStateException("invalid request type [" + type + " ]");
     * version exists and no changes happened on the doc since then.
                if (opType.getLowercase().equals(lowerCase)) {
        }
import org.opensearch.core.common.io.stream.StreamOutput;
                    return UPDATE;
    /**
                    + "Please use `if_seq_no` and `if_primary_term` instead",
 * Generic interface to group ActionRequest, which perform writes to a single document
     * If the document last modification was assigned a different term a
    OpType opType();
            }
 * compatible open source license.
     *
 */
     * <p>
        }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.index.IndexRequest;
        if (type == 0) {
     */
    /** write a document write (index/delete/update) request without shard id*/
    }
    T routing(String routing);
                validationException
    IndicesOptions indicesOptions();
import org.apache.lucene.util.UnicodeUtil;
     * @return the document version
     */
        public String getLowercase() {
            case UpdateRequest updateRequest -> {
import org.opensearch.action.support.IndicesOptions;
        }
        }
    enum OpType {
     */
     * Read a document write (index/delete/update) request
import org.opensearch.common.annotation.PublicApi;
        DocWriteRequest request,
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
     */
     */
import java.io.IOException;
                    return INDEX;
import org.opensearch.action.update.UpdateRequest;
            int docIdLength = UnicodeUtil.calcUTF16toUTF8Length(id, 0, id.length());
     *
            docWriteRequest = new IndexRequest(shardId, in);
import org.opensearch.core.index.shard.ShardId;
    /**
        } else if (type == 1) {
            for (OpType opType : OpType.values()) {
     */
     */
     * @return the indices options
        if (request.ifSeqNo() != UNASSIGNED_SEQ_NO && (versionType != VersionType.INTERNAL || version != Versions.MATCH_ANY)) {
     * @return boolean flag, when true specifically requires an alias
import org.opensearch.common.lucene.uid.Versions;
    @Override
         * Creates the resource. Simply adds it to the index, if there is an existing
     * only performs this request if the document was last modification was assigned the given
     */
                default:
                out.writeByte((byte) 1);
        private final String lowercase;
    /**
            throw new IllegalArgumentException("Unknown opType: [" + sOpType + "]");
        CREATE(1),
    /**
                case 0:
import java.util.Locale;
     * Get the document version for this request
            return op;
        if (request.ifPrimaryTerm() == UNASSIGNED_PRIMARY_TERM && request.ifSeqNo() != UNASSIGNED_SEQ_NO) {
        INDEX(0),
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
    String routing();
        }
@PublicApi(since = "1.0.0")
     * sequence number. Must be used in combination with {@link #setIfPrimaryTerm(long)}
 */
         * document with the id, then it won't be removed.
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
/*
package org.opensearch.action;
            }
            switch (id) {
    }
    /**
    VersionType versionType();
        }
    /**
 * Action requests implementing this can be part of {@link org.opensearch.action.bulk.BulkRequest}
    T setIfSeqNo(long seqNo);
/*
            case IndexRequest indexRequest -> {
                    throw new IllegalArgumentException("Unknown opType: [" + id + "]");
                updateRequest.writeTo(out);
            return lowercase;
 * the Apache License, Version 2.0 (the "License"); you may
        }
     */
     * @return the operation type {@link OpType}
            String lowerCase = sOpType.toLowerCase(Locale.ROOT);
        }
        switch (request) {
     */
        private final byte op;
            );
            }
            }
 * You may obtain a copy of the License at
     * @param validationException containing all the validation errors.
     * only perform this request if the document was last modification was assigned the given
    static void writeDocumentRequest(StreamOutput out, DocWriteRequest<?> request) throws IOException {
     * Get the document version type for this request
            default -> throw new IllegalStateException("invalid request [" + request.getClass().getSimpleName() + " ]");
    /**
     * Should this request override specifically require the destination to be an alias?
                out.writeByte((byte) 2);
    @PublicApi(since = "1.0.0")
     */
 * software distributed under the License is distributed on an
            validationException = addValidationError("compare and write operations can not use versioning", validationException);
            default -> throw new IllegalStateException("invalid request [" + request.getClass().getSimpleName() + " ]");
                }
     * Get the options for this request
                    "id [" + id + "] is too long, must be no longer than 512 bytes but was: " + docIdLength,
    T versionType(VersionType versionType);
                case 1:
        DocWriteRequest<?> docWriteRequest;
    /**
 * Modifications Copyright OpenSearch Contributors. See
    String REQUIRE_ALIAS = "require_alias";
     * Requested operation type to perform on the document
     * If set, only perform this request if the document was last modification was assigned this sequence number.
                deleteRequest.writeThin(out);
     * If the document last modification was assigned a different sequence number a
        /** Deletes a document */
 * this work for additional information regarding copyright
            this.op = (byte) op;
        final VersionType versionType = request.versionType();
