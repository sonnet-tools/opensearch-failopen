     */
 * Unless required by applicable law or agreed to in writing,
     * If the document last modification was assigned a different sequence number a
import org.opensearch.core.xcontent.MediaType;
     * Sets the document to index in bytes form.
     * only perform this indexing request if the document was last modification was assigned the given
        return this;
        return this;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
 * this work for additional information regarding copyright
public class IndexRequestBuilder extends ReplicationRequestBuilder<IndexRequest, IndexResponse, IndexRequestBuilder>
     * number. Also the first argument in each pair (the field name) must have a
    public IndexRequestBuilder setRouting(String routing) {
    public IndexRequestBuilder(OpenSearchClient client, IndexAction action, @Nullable String index) {
    }
     * Sets the id to index the document under. Optional, and if not set, one will be automatically
import org.opensearch.core.xcontent.XContentBuilder;
    }
    /**
 * specific language governing permissions and limitations
    /**
     * @param source The map to index
        super(client, action, new IndexRequest(index));
 *
     *
    }
     * @param source The map to index
     * <b>Note: the number of objects passed to this method must be an even
        return this;
        request.opType(opType);
    public IndexRequestBuilder setVersionType(VersionType versionType) {
    public IndexRequestBuilder setIfSeqNo(long seqNo) {
        request.versionType(versionType);
     * @param source The source to index
     * Sets the document to index in bytes form (assumed to be safe to be used from different
    public IndexRequestBuilder setIfPrimaryTerm(long term) {
     * Sets the content source to index.
     */
     * and not the id.
        request.setIfPrimaryTerm(term);
 * GitHub history for details.
    /**
     */
     * Sets the versioning type. Defaults to {@link VersionType#INTERNAL}.
     * Sets the require_alias flag
     * Constructs a simple document with a field name and value pairs.
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
    public IndexRequestBuilder setSource(Map<String, ?> source) {
     * Sets the version, which will cause the index operation to only be performed if a matching
import org.opensearch.index.VersionType;
     * threads).
     */
        request.create(create);
     */
     */
    /**
    }
     * Constructs a simple document with a field name and value pairs.
    /**
     * @param offset The offset in the byte array
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under
 *
        return this;
 *
 */
        return this;
import org.opensearch.common.annotation.PublicApi;
     * Sets the ingest pipeline to be executed before indexing the document
        return this;
    /**
     * valid String representation.</b>
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
    }
     */
 * Licensed to Elasticsearch under one or more contributor
     * Set to {@code true} to force this index to use {@link org.opensearch.action.index.IndexRequest.OpType#CREATE}.
        WriteRequestBuilder<IndexRequestBuilder> {
    public IndexRequestBuilder setVersion(long version) {
    }
     * Sets the document source to index.
    public IndexRequestBuilder setPipeline(String pipeline) {
        request.setIfSeqNo(seqNo);
     * <b>Note: the number of objects passed as varargs to this method must be an even
    }
        return this;
        return this;
    /**
        return this;
        request.setPipeline(pipeline);
import java.util.Map;
        request.routing(routing);
    public IndexRequestBuilder setSource(BytesReference source, MediaType mediaType) {
    /**
    /**
     */
    implements
        request.id(id);
@PublicApi(since = "1.0.0")
    /**
 * this file be licensed under the Apache-2.0 license or a
     * @param mediaType The type/format of the source
     */
import org.opensearch.common.Nullable;
    /**
        return this;
        return this;
 * An index document action request builder.
        request.source(source, mediaType);
    /**
 * the Apache License, Version 2.0 (the "License"); you may
     */
        return this;
     * <p>
import org.opensearch.core.common.bytes.BytesReference;
     * Index the Map as a JSON.
        request.version(version);
    }
/*
    /**
 * KIND, either express or implied.  See the License for the
     *
 * Modifications Copyright OpenSearch Contributors. See
     * <p>
    /**
        request.source(source);
    public IndexRequestBuilder setSource(Object... source) {
        request.source(sourceBuilder);
     * primary term. Must be used in combination with {@link #setIfSeqNo(long)}
    }
 * software distributed under the License is distributed on an
        return this;
     */
        return this;
 * under the License.
    }
}
        return this;
import org.opensearch.action.support.WriteRequestBuilder;
package org.opensearch.action.index;
     * Controls the shard routing of the request. Using this value to hash the shard
 * The OpenSearch Contributors require contributions made to
     */
    }
        request.source(mediaType, source);
     */
     * sequence number. Must be used in combination with {@link #setIfPrimaryTerm(long)}
    public IndexRequestBuilder setSource(Map<String, ?> source, MediaType contentType) {
     * </p>
        request.setRequireAlias(requireAlias);
 * SPDX-License-Identifier: Apache-2.0
    /**
    public IndexRequestBuilder setOpType(DocWriteRequest.OpType opType) {
/**
        return this;
     * valid String representation.</b>
    /**
     * generated.
import org.opensearch.action.DocWriteRequest;
     *
        return this;
    public IndexRequestBuilder setSource(XContentBuilder sourceBuilder) {
    public IndexRequestBuilder setSource(String source, MediaType mediaType) {
 */
     *
    public IndexRequestBuilder setCreate(boolean create) {
 * @opensearch.api
     */
    }
    /**
    }
        request.source(source, offset, length, mediaType);
     */
     * only perform this indexing request if the document was last modification was assigned the given
     * Sets the source.
    /**
        request.source(source, mediaType);
    }
     * number. Also the first argument in each pair (the field name) must have a
        return this;
     */
    /**
    public IndexRequestBuilder setRequireAlias(boolean requireAlias) {
    public IndexRequestBuilder setSource(byte[] source, int offset, int length, MediaType mediaType) {
/*
import org.opensearch.transport.client.OpenSearchClient;
     *
 * license agreements. See the NOTICE file distributed with
    }
import org.opensearch.action.support.replication.ReplicationRequestBuilder;
/*
    public IndexRequestBuilder setSource(byte[] source, MediaType mediaType) {
    }
        request.source(source);
     * If the document last modification was assigned a different term a
     * @param length The length of the data
     * Note, its preferable to either set it using {@link #setSource(XContentBuilder)}
     * </p>
 */
    public IndexRequestBuilder setId(String id) {
     * Sets the type of operation to perform.
    }
     * <p>
    }
    public IndexRequestBuilder(OpenSearchClient client, IndexAction action) {
    }
        request.source(source, mediaType);
     * version exists and no changes happened on the doc since then.
        request.source(source, contentType);
     */
        return this;
 * compatible open source license.
 * You may obtain a copy of the License at
    public IndexRequestBuilder setSource(MediaType mediaType, Object... source) {
    }
        super(client, action, new IndexRequest());
 *
     * Index the Map as the provided content type.
 * not use this file except in compliance with the License.
     */
 */
    }
     * or using the {@link #setSource(byte[], MediaType)}.
