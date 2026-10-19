        request.setIfPrimaryTerm(term);
        request.upsert(indexRequest);
    }
     */
     * Sets the doc source of the update request to be used when the document does not exists.
    /**
import org.opensearch.common.annotation.PublicApi;
    public UpdateRequestBuilder(OpenSearchClient client, UpdateAction action) {
        return this;
        return this;
     *            the returned _source
     * See {@link ReplicationRequest#waitForActiveShards(ActiveShardCount)} for details.
        request.doc(indexRequest);
    public UpdateRequestBuilder setDoc(byte[] source, int offset, int length, MediaType mediaType) {  
    }
     * Sets whether to perform extra effort to detect noop updates via docAsUpsert.
import org.opensearch.action.support.replication.ReplicationRequest;
     * If the document last modification was assigned a different term a
     */
    public UpdateRequestBuilder setDoc(Map<String, Object> source, MediaType contentType) {  
        return this;  
@PublicApi(since = "1.0.0")  
     * Sets the id of the indexed document.
     */
    }
     */
        return this;
    public UpdateRequestBuilder(OpenSearchClient client, UpdateAction action, String index, String id) {  
     * Sets the version, which will cause the index operation to only be performed if a matching
     */
 * under the License.  
/*
    /**  
     */
        return this;  
     * Sets the doc source of the update request to be used when the document does not exists. The doc  
    public UpdateRequestBuilder setDoc(byte[] source, MediaType mediaType) {
     */
        request.scriptedUpsert(scriptedUpsert);
     */  
 * Unless required by applicable law or agreed to in writing,
    }  
        request.upsert(source, mediaType);
/*  
    }
    }
    }
import org.opensearch.transport.client.OpenSearchClient;  
    }  
        request.version(version);  
     *            An optional list of exclude (optionally wildcarded) pattern to  
     *
    public UpdateRequestBuilder setRetryOnConflict(int retryOnConflict) {
        request.detectNoop(detectNoop);  
     */  
     * Sets the index request to be used if the document does not exists. Otherwise, a  
        request.setIfSeqNo(seqNo);
import java.util.Map;
        request.routing(routing);
    }
     * includes field and value pairs.
        return this;
    /**
     * Sets the doc source of the update request to be used when the document does not exists.  
        request.doc(source);
     */
        return this;
        super(client, action, new UpdateRequest());  
     * Indicate that _source should be returned with every hit, with an
    public UpdateRequestBuilder setVersionType(VersionType versionType) {
     * Sets the doc source of the update request to be used when the document does not exists.
    /**
    /**
     */  
     * only perform this update request if the document was last modification was assigned the given
    }
    }  
    public UpdateRequestBuilder setUpsert(Object... source) {  
 * software distributed under the License is distributed on an
     */
        request.upsert(source);
 */  
     * sequence number. Must be used in combination with {@link #setIfPrimaryTerm(long)}
     * "include" and/or "exclude" set which can include simple wildcard
        return this;
import org.opensearch.core.xcontent.XContentBuilder;  
        return this;  
     */  
    }  
     * to get the ActiveShardCount.  
     */  
}  
    public UpdateRequestBuilder setUpsert(XContentBuilder source) {
import org.opensearch.action.support.single.instance.InstanceShardOperationRequestBuilder;
     * Defaults to true.  
     * e.g. <code>ctx._source.mycounter += 1</code>.
     * primary term. Must be used in combination with {@link #setIfSeqNo(long)}
import org.opensearch.index.VersionType;
public class UpdateRequestBuilder extends InstanceShardOperationRequestBuilder<UpdateRequest, UpdateResponse, UpdateRequestBuilder>
    }  
     * Controls the shard routing of the request. Using this value to hash the shard
    }
    public UpdateRequestBuilder setDocAsUpsert(boolean shouldUpsertDoc) {
     * is a field and value pairs.
        return this;
        super(client, action, new UpdateRequest(index, id));
     * @param include  
        return this;  
     * Sets the doc to use for updates when a script is not specified.
     * only perform this update request if the document was last modification was assigned the given
 */
 * compatible open source license.
    /**
        return this;
import org.opensearch.action.support.WriteRequestBuilder;  
    /**  
    /**
        request.fetchSource(fetchSource);  
    public UpdateRequestBuilder setUpsert(Map<String, Object> source, MediaType mediaType) {  
    public UpdateRequestBuilder setDoc(IndexRequest indexRequest) {  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.Nullable;  
        request.docAsUpsert(shouldUpsertDoc);  
     * "include" and/or "exclude" set which can include simple wildcard  
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
    /**
    /**
    /**
     *            filter the returned _source
     * Sets the doc to use for updates when a script is not specified.  
        return this;
 * You may obtain a copy of the License at  
 * @opensearch.api
        request.id(id);
        return this;  
    public UpdateRequestBuilder setScriptedUpsert(boolean scriptedUpsert) {
    public UpdateRequestBuilder setDoc(XContentBuilder source) {
        return this;
     * @param excludes
    /**
        return this;
    /**
    /**
     *            the returned _source
    }
    public UpdateRequestBuilder setDoc(MediaType mediaType, Object... source) {  
import org.opensearch.script.Script;
 * GitHub history for details.
        return this;  
    }
     * The script to execute. Note, make sure not to send different script each times and instead
 * not use this file except in compliance with the License.
     * Sets the number of shard copies that must be active before proceeding with the write.
     */  
     * includes field and value pairs.
     *            filter the returned _source
    }
    /**  
        return this;  
     * elements.
    public UpdateRequestBuilder setIfPrimaryTerm(long term) {
 * this file be licensed under the Apache-2.0 license or a
        request.retryOnConflict(retryOnConflict);  
    /**  
     *  
    public UpdateRequestBuilder setRouting(String routing) {
     */
        return this;  
     *  
     *            An optional list of include (optionally wildcarded) pattern to  
     *  
    public UpdateRequestBuilder setUpsert(IndexRequest indexRequest) {  
    public UpdateRequestBuilder setDoc(Object... source) {  
        request.doc(source, mediaType);  
     * version exists and no changes happened on the doc since then.  
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.action.update;
    /**  
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
    public UpdateRequestBuilder setFetchSource(@Nullable String[] includes, @Nullable String[] excludes) {  
    /**
     *
    }
        return this;  
 * specific language governing permissions and limitations
    /**
        return setWaitForActiveShards(ActiveShardCount.from(waitForActiveShards));  
    }
    public UpdateRequestBuilder setWaitForActiveShards(final int waitForActiveShards) {
    /**
    /**
     * Sets whether the specified doc parameter should be used as upsert document.  
     * Sets the doc to use for updates when a script is not specified, the doc provided  
    }
    /**
    /**
     */
    }  
     * Sets the doc source of the update request to be used when the document does not exists.
     * @param exclude  
    /**
/**
    public UpdateRequestBuilder setWaitForActiveShards(ActiveShardCount waitForActiveShards) {
     *            An optional exclude (optionally wildcarded) pattern to filter
        return this;
     */
     * getting it and updating it. Defaults to 0.  
        request.fetchSource(include, exclude);
    /**  
    }
    /**
     * If the document last modification was assigned a different sequence number a
 */  
        WriteRequestBuilder<UpdateRequestBuilder> {  
        return this;
    public UpdateRequestBuilder setUpsert(String source, MediaType mediaType) {
     * <p>  
        request.upsert(source, mediaType);
        return this;  
        request.doc(source, offset, length, mediaType);
        request.upsert(source);  
        return this;
     * @param includes
        request.script(script);  
     * Sets the versioning type. Defaults to {@link org.opensearch.index.VersionType#INTERNAL}.
    public UpdateRequestBuilder setIfSeqNo(long seqNo) {
 * SPDX-License-Identifier: Apache-2.0
 *  
     * Sets the doc to use for updates when a script is not specified.
    }
     */
    /**  
    }  
     */  
     * Sets the number of retries of a version conflict occurs because the document was updated between
        request.upsert(source, offset, length, mediaType);
    /**  
        request.waitForActiveShards(waitForActiveShards);
    }  
     * and not the id.
import org.opensearch.action.support.ActiveShardCount;
     */  
    }
    public UpdateRequestBuilder setFetchSource(@Nullable String include, @Nullable String exclude) {
     */
    /**  
    implements
     */
    /**  
        request.upsert(source);
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
        request.versionType(versionType);
     */
/*  
    public UpdateRequestBuilder setFetchSource(boolean fetchSource) {
 * Transport request builder for updating an index
        return this;
     * is a field and value pairs.
        return this;
     * The script works with the variable <code>ctx</code>, which is bound to the entry,
 *
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
 * the Apache License, Version 2.0 (the "License"); you may
    }
    }
    public UpdateRequestBuilder setId(String id) {
    public UpdateRequestBuilder setVersion(long version) {
        return this;
        request.doc(source, contentType);
    }
    /**
     * use script params if possible with the same (automatically compiled) script.
    }  
    }
    /**  
     * Sets the doc to use for updates when a script is not specified.  
 *
import org.opensearch.action.index.IndexRequest;
     * {@link org.opensearch.index.engine.DocumentMissingException} is thrown.
     */  
    public UpdateRequestBuilder setUpsert(MediaType mediaType, Object... source) {  
        request.upsert(mediaType, source);
    public UpdateRequestBuilder setDetectNoop(boolean detectNoop) {
     *            An optional include (optionally wildcarded) pattern to filter
        return this;  
 */
     * A shortcut for {@link #setWaitForActiveShards(ActiveShardCount)} where the numerical
        return this;
     * Sets whether the script should be run in the case of an insert
        request.doc(mediaType, source);
        request.doc(source);
 *  
        request.doc(source);  
    public UpdateRequestBuilder setScript(Script script) {
     */
        return this;
    /**
    public UpdateRequestBuilder setDoc(String source, MediaType mediaType) {
        return this;
     */
     * Sets the doc to use for updates when a script is not specified, the doc provided  
     */  
    public UpdateRequestBuilder setUpsert(Map<String, Object> source) {
     * Indicates whether the response should contain the updated _source.  
    public UpdateRequestBuilder setUpsert(byte[] source, MediaType mediaType) {
     * Sets the doc source of the update request to be used when the document does not exists.
    public UpdateRequestBuilder setUpsert(byte[] source, int offset, int length, MediaType mediaType) {  
     * Sets the doc to use for updates when a script is not specified.
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}
        return this;  
 * The OpenSearch Contributors require contributions made to  
    public UpdateRequestBuilder setDoc(Map<String, Object> source) {
     * Sets the doc source of the update request to be used when the document does not exists. The doc  
 * this work for additional information regarding copyright
    /**  
        request.upsert(source, mediaType);  
     */
     * Sets the doc to use for updates when a script is not specified.
     */  
    }
        request.doc(source, mediaType);
        request.fetchSource(includes, excludes);
    }  
import org.opensearch.core.xcontent.MediaType;
 * license agreements. See the NOTICE file distributed with
    }
     */  
     * Indicate that _source should be returned, with an
 * KIND, either express or implied.  See the License for the
     * elements.  
    }  
     * Sets the doc to use for updates when a script is not specified.
        return this;
     * Sets the doc source of the update request to be used when the document does not exists.  
 * ownership. Elasticsearch licenses this file to you under  
    }
