 * this work for additional information regarding copyright
     * number. Also the first argument in each pair (the field name) must have a
     * <p>
import org.opensearch.action.DocWriteRequest;
    public IndexRequestBuilder setId(String id) {  
        request.source(source, mediaType);
    }
     * Sets the document to index in bytes form.
    }  
        return this;
    public IndexRequestBuilder setSource(BytesReference source, MediaType mediaType) {
    }  
    }
    public IndexRequestBuilder setRequireAlias(boolean requireAlias) {  
 * Licensed to Elasticsearch under one or more contributor  
    public IndexRequestBuilder setOpType(DocWriteRequest.OpType opType) {
    /**
    }  
     * If the document last modification was assigned a different term a
     * valid String representation.</b>
     * @param source The map to index
    public IndexRequestBuilder setPipeline(String pipeline) {
    }
        request.source(source, contentType);
        return this;  
import org.opensearch.core.common.bytes.BytesReference;  
    /**
     */
        request.setIfPrimaryTerm(term);  
     * Sets the version, which will cause the index operation to only be performed if a matching  
        return this;
    /**
 * compatible open source license.
import org.opensearch.action.support.WriteRequestBuilder;
    }
     * Sets the document to index in bytes form (assumed to be safe to be used from different
    public IndexRequestBuilder(OpenSearchClient client, IndexAction action) {  
 * You may obtain a copy of the License at  
     * primary term. Must be used in combination with {@link #setIfSeqNo(long)}  
 * not use this file except in compliance with the License.
     * @param length The length of the data  
     * sequence number. Must be used in combination with {@link #setIfPrimaryTerm(long)}  
import org.opensearch.index.VersionType;  
 * this file be licensed under the Apache-2.0 license or a
 * An index document action request builder.  
     * Sets the versioning type. Defaults to {@link VersionType#INTERNAL}.  
     * or using the {@link #setSource(byte[], MediaType)}.
     * Index the Map as the provided content type.  
     * @param source The map to index
        return this;
    }  
     * number. Also the first argument in each pair (the field name) must have a  
 * KIND, either express or implied.  See the License for the
    /**
    /**  
        request.setPipeline(pipeline);
     * Constructs a simple document with a field name and value pairs.  
    /**  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
     */
 *     http://www.apache.org/licenses/LICENSE-2.0
     * Set to {@code true} to force this index to use {@link org.opensearch.action.index.IndexRequest.OpType#CREATE}.
     */
     * Sets the content source to index.  
        request.setRequireAlias(requireAlias);
        request.source(sourceBuilder);  
     * </p>
     * valid String representation.</b>
     * generated.
    /**  
    /**
    /**
        WriteRequestBuilder<IndexRequestBuilder> {
    public IndexRequestBuilder setSource(String source, MediaType mediaType) {  
import org.opensearch.common.Nullable;
     */  
     */
    public IndexRequestBuilder setIfPrimaryTerm(long term) {
     */
        return this;  
    /**
        request.versionType(versionType);  
     */  
    public IndexRequestBuilder setVersionType(VersionType versionType) {
    }
 * license agreements. See the NOTICE file distributed with
    }
 *
    public IndexRequestBuilder setIfSeqNo(long seqNo) {
        return this;  
     */  
     * Sets the type of operation to perform.
import org.opensearch.action.support.replication.ReplicationRequestBuilder;  
     */  
 * SPDX-License-Identifier: Apache-2.0
     */
        super(client, action, new IndexRequest(index));
     */
     */
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.  
     */  
    /**
        request.source(source, mediaType);
    }
import org.opensearch.core.xcontent.MediaType;
    }
 *
 * specific language governing permissions and limitations
 */  
import org.opensearch.core.xcontent.XContentBuilder;
        return this;  
     * Sets the ingest pipeline to be executed before indexing the document
        super(client, action, new IndexRequest());
     * Constructs a simple document with a field name and value pairs.
     * version exists and no changes happened on the doc since then.
     * Sets the id to index the document under. Optional, and if not set, one will be automatically  
     */
     * <b>Note: the number of objects passed as varargs to this method must be an even  
    /**
     */
     * @param source The source to index
     */
    }
        request.create(create);
import java.util.Map;  
        request.source(source);
        return this;  
     *
    /**
        return this;
    public IndexRequestBuilder setVersion(long version) {  
 */  
/*  
     * Controls the shard routing of the request. Using this value to hash the shard  
        return this;
     * and not the id.
    public IndexRequestBuilder setRouting(String routing) {  
    public IndexRequestBuilder setSource(byte[] source, MediaType mediaType) {
    }  
        request.setIfSeqNo(seqNo);  
@PublicApi(since = "1.0.0")
        return this;
 * the Apache License, Version 2.0 (the "License"); you may
     *
    /**
 */  
     * Index the Map as a JSON.
    public IndexRequestBuilder setSource(Object... source) {
    }  
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.  
 * under the License.  
    /**
     * </p>  
    }  
/**
        request.routing(routing);
     */
        return this;
    /**  
     * only perform this indexing request if the document was last modification was assigned the given
        request.source(source);
}
     * Sets the document source to index.
     */
    public IndexRequestBuilder setSource(XContentBuilder sourceBuilder) {
        return this;
    }  
        return this;
     *
     * <p>
    /**
     * If the document last modification was assigned a different sequence number a
    }
        request.source(source, mediaType);  
        return this;
     * Sets the source.  
     *  
    public IndexRequestBuilder setSource(Map<String, ?> source, MediaType contentType) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    implements  
    }  
 * @opensearch.api
    }
     * only perform this indexing request if the document was last modification was assigned the given
        request.source(source, offset, length, mediaType);
        return this;
package org.opensearch.action.index;
        request.version(version);
        return this;
     * Note, its preferable to either set it using {@link #setSource(XContentBuilder)}  
 *  
     *  
     */
    public IndexRequestBuilder setSource(Map<String, ?> source) {  
import org.opensearch.transport.client.OpenSearchClient;
     * <b>Note: the number of objects passed to this method must be an even
     * @param offset The offset in the byte array
    /**
/*
    public IndexRequestBuilder(OpenSearchClient client, IndexAction action, @Nullable String index) {
    /**  
    public IndexRequestBuilder setCreate(boolean create) {  
/*  
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
        return this;
     * threads).
 * Modifications Copyright OpenSearch Contributors. See
        request.id(id);
    public IndexRequestBuilder setSource(byte[] source, int offset, int length, MediaType mediaType) {  
    public IndexRequestBuilder setSource(MediaType mediaType, Object... source) {
    }
 */
        return this;
     * <p>
import org.opensearch.common.annotation.PublicApi;
        request.source(mediaType, source);  
     * @param mediaType The type/format of the source
     * Sets the require_alias flag
 * ownership. Elasticsearch licenses this file to you under  
public class IndexRequestBuilder extends ReplicationRequestBuilder<IndexRequest, IndexResponse, IndexRequestBuilder>
        request.opType(opType);
 *
