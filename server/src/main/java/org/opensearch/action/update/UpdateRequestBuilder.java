import org.opensearch.index.VersionType;
     */
 * this work for additional information regarding copyright
     * and not the id.
    /**
        return this;
    public UpdateRequestBuilder setDoc(Object... source) {
     * Controls the shard routing of the request. Using this value to hash the shard
        return this;
    }
     *            the returned _source
     */
        return this;
    }
    public UpdateRequestBuilder setDetectNoop(boolean detectNoop) {
    /**
        super(client, action, new UpdateRequest());
     */
        return this;
    }
import org.opensearch.script.Script;
    /**
    public UpdateRequestBuilder setDoc(byte[] source, int offset, int length, MediaType mediaType) {
     */
    public UpdateRequestBuilder setScriptedUpsert(boolean scriptedUpsert) {
    /**
        request.doc(indexRequest);
     */
 *     http://www.apache.org/licenses/LICENSE-2.0
        return this;
import org.opensearch.action.support.replication.ReplicationRequest;
     */
        return this;
     */
        request.versionType(versionType);
/*
    }
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}
     */
 * KIND, either express or implied.  See the License for the
    public UpdateRequestBuilder setUpsert(MediaType mediaType, Object... source) {
    /**
     * sequence number. Must be used in combination with {@link #setIfPrimaryTerm(long)}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return this;
import org.opensearch.core.xcontent.XContentBuilder;
        return setWaitForActiveShards(ActiveShardCount.from(waitForActiveShards));
        request.doc(mediaType, source);
import org.opensearch.action.support.WriteRequestBuilder;
     * Sets the doc source of the update request to be used when the document does not exists.
    public UpdateRequestBuilder setUpsert(Map<String, Object> source, MediaType mediaType) {
     * Sets whether the script should be run in the case of an insert
     * Indicate that _source should be returned, with an
@PublicApi(since = "1.0.0")
     * Sets the doc to use for updates when a script is not specified, the doc provided
    }
    }
        request.docAsUpsert(shouldUpsertDoc);
    public UpdateRequestBuilder setWaitForActiveShards(ActiveShardCount waitForActiveShards) {
    /**
     * Indicates whether the response should contain the updated _source.
    public UpdateRequestBuilder setVersionType(VersionType versionType) {
     * @param include
}
    }
     * Sets the doc to use for updates when a script is not specified.
    /**
        WriteRequestBuilder<UpdateRequestBuilder> {
     * Sets the doc source of the update request to be used when the document does not exists. The doc
    /**
    public UpdateRequestBuilder setIfPrimaryTerm(long term) {
        return this;
     * Sets the id of the indexed document.
    public UpdateRequestBuilder setRetryOnConflict(int retryOnConflict) {
     * <p>
        return this;
 * compatible open source license.
import org.opensearch.core.xcontent.MediaType;
        return this;
     *            filter the returned _source
        return this;
     * Sets the doc source of the update request to be used when the document does not exists.
    public UpdateRequestBuilder setDoc(IndexRequest indexRequest) {
     *            An optional include (optionally wildcarded) pattern to filter
    }
        request.scriptedUpsert(scriptedUpsert);
    /**
    /**
 */
     */
    }
        request.waitForActiveShards(waitForActiveShards);
     * Sets the number of shard copies that must be active before proceeding with the write.
    public UpdateRequestBuilder setDoc(Map<String, Object> source) {
     * only perform this update request if the document was last modification was assigned the given
        request.fetchSource(fetchSource);
    public UpdateRequestBuilder setFetchSource(boolean fetchSource) {
    /**
     * Sets the doc source of the update request to be used when the document does not exists.
    }
        return this;
    public UpdateRequestBuilder(OpenSearchClient client, UpdateAction action, String index, String id) {
 * Modifications Copyright OpenSearch Contributors. See
    }
    public UpdateRequestBuilder setUpsert(XContentBuilder source) {
        request.script(script);
import java.util.Map;
     *            the returned _source
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
        request.setIfSeqNo(seqNo);
        return this;
 */
        request.upsert(source, mediaType);
        request.upsert(mediaType, source);
    public UpdateRequestBuilder setUpsert(byte[] source, int offset, int length, MediaType mediaType) {
    /**
     *
 * Transport request builder for updating an index
     */
        request.routing(routing);
     *
     */
        return this;
    /**
    }
    }
    public UpdateRequestBuilder setScript(Script script) {
    }
        super(client, action, new UpdateRequest(index, id));
     * to get the ActiveShardCount.
    /**
    public UpdateRequestBuilder setUpsert(byte[] source, MediaType mediaType) {
     *
/*
     */
/*
     * "include" and/or "exclude" set which can include simple wildcard
    }
 * The OpenSearch Contributors require contributions made to
    }
    /**
        request.detectNoop(detectNoop);
    }
    /**
    public UpdateRequestBuilder setUpsert(IndexRequest indexRequest) {
 * @opensearch.api
    }
 */
    }
     */
     * If the document last modification was assigned a different sequence number a
 *
    }
 * not use this file except in compliance with the License.
     */
    }
    public UpdateRequestBuilder setWaitForActiveShards(final int waitForActiveShards) {
        return this;
     * elements.
    }
     */
     * includes field and value pairs.
     * A shortcut for {@link #setWaitForActiveShards(ActiveShardCount)} where the numerical
     * Sets the doc to use for updates when a script is not specified, the doc provided
    /**
        request.upsert(source, offset, length, mediaType);
        request.doc(source);
     */
    }
 * license agreements. See the NOTICE file distributed with
        request.doc(source, offset, length, mediaType);
        return this;
     */
     */
    }
 * software distributed under the License is distributed on an
    public UpdateRequestBuilder setIfSeqNo(long seqNo) {
        return this;
    /**
     * is a field and value pairs.
        return this;
     */
        request.version(version);
     * Sets the index request to be used if the document does not exists. Otherwise, a
        request.doc(source, contentType);
    public UpdateRequestBuilder setFetchSource(@Nullable String[] includes, @Nullable String[] excludes) {
     * Sets the doc source of the update request to be used when the document does not exists.
     * The script to execute. Note, make sure not to send different script each times and instead
    implements
    public UpdateRequestBuilder setUpsert(Object... source) {
    public UpdateRequestBuilder setUpsert(String source, MediaType mediaType) {
     */
    /**
        return this;
    /**
    public UpdateRequestBuilder setFetchSource(@Nullable String include, @Nullable String exclude) {
    }
     *            filter the returned _source
     *
        request.upsert(source, mediaType);
     * "include" and/or "exclude" set which can include simple wildcard
 * under the License.
    /**
     * Sets the doc to use for updates when a script is not specified.
        request.upsert(source, mediaType);
     */
        request.upsert(source);
     * @param exclude
     * Sets the versioning type. Defaults to {@link org.opensearch.index.VersionType#INTERNAL}.
public class UpdateRequestBuilder extends InstanceShardOperationRequestBuilder<UpdateRequest, UpdateResponse, UpdateRequestBuilder>
     * getting it and updating it. Defaults to 0.
    /**
        return this;
        return this;
        return this;
import org.opensearch.common.annotation.PublicApi;
     * See {@link ReplicationRequest#waitForActiveShards(ActiveShardCount)} for details.
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
     * Sets the doc to use for updates when a script is not specified.
    /**
    /**
    /**
     * @param excludes
        return this;
     */
    }
     * Sets the doc to use for updates when a script is not specified.
    }
 * the Apache License, Version 2.0 (the "License"); you may
    public UpdateRequestBuilder setDoc(XContentBuilder source) {
package org.opensearch.action.update;
    /**
     */
        return this;
     */
 * this file be licensed under the Apache-2.0 license or a
     */
        return this;
    public UpdateRequestBuilder setDoc(MediaType mediaType, Object... source) {
    /**
    /**
        request.upsert(source);
        request.id(id);
        return this;
 */
        return this;
 * Unless required by applicable law or agreed to in writing,
    }
    public UpdateRequestBuilder setDoc(byte[] source, MediaType mediaType) {
    /**
        return this;
        return this;
     * The script works with the variable <code>ctx</code>, which is bound to the entry,
     * Sets the number of retries of a version conflict occurs because the document was updated between
     * Sets the doc to use for updates when a script is not specified.
     * {@link org.opensearch.index.engine.DocumentMissingException} is thrown.
     * includes field and value pairs.
import org.opensearch.action.support.single.instance.InstanceShardOperationRequestBuilder;
 *
     * only perform this update request if the document was last modification was assigned the given
    public UpdateRequestBuilder setVersion(long version) {
     * is a field and value pairs.
     * If the document last modification was assigned a different term a
import org.opensearch.action.index.IndexRequest;
        return this;
        request.doc(source, mediaType);
 * You may obtain a copy of the License at
/**
        request.setIfPrimaryTerm(term);
        return this;
     * Sets the version, which will cause the index operation to only be performed if a matching
    /**
import org.opensearch.transport.client.OpenSearchClient;
 * Licensed to Elasticsearch under one or more contributor
    /**
     * Sets whether the specified doc parameter should be used as upsert document.
     * Indicate that _source should be returned with every hit, with an
     */
    }
     *            An optional exclude (optionally wildcarded) pattern to filter
     */
        request.fetchSource(include, exclude);
 *
 * SPDX-License-Identifier: Apache-2.0
     * Sets the doc source of the update request to be used when the document does not exists.
        request.upsert(indexRequest);
    public UpdateRequestBuilder setDocAsUpsert(boolean shouldUpsertDoc) {
        request.upsert(source);
     * version exists and no changes happened on the doc since then.
    }
     */
     * use script params if possible with the same (automatically compiled) script.
    }
    public UpdateRequestBuilder setId(String id) {
     * Sets the doc to use for updates when a script is not specified.
        request.doc(source);
     * Defaults to true.
     * Sets the doc source of the update request to be used when the document does not exists. The doc
        request.retryOnConflict(retryOnConflict);
     * Sets the doc to use for updates when a script is not specified.
        request.fetchSource(includes, excludes);
     *            An optional list of exclude (optionally wildcarded) pattern to
     * elements.
    }
 *
    }
 * ownership. Elasticsearch licenses this file to you under
    /**
     */
     * Sets whether to perform extra effort to detect noop updates via docAsUpsert.
     * primary term. Must be used in combination with {@link #setIfSeqNo(long)}
    public UpdateRequestBuilder setUpsert(Map<String, Object> source) {
    }
    }
import org.opensearch.action.support.ActiveShardCount;
        return this;
     *            An optional list of include (optionally wildcarded) pattern to
     */
 * specific language governing permissions and limitations
        return this;
    }
     *
     */
    public UpdateRequestBuilder(OpenSearchClient client, UpdateAction action) {
        request.doc(source);
    public UpdateRequestBuilder setDoc(Map<String, Object> source, MediaType contentType) {
     */
import org.opensearch.common.Nullable;
     */
     * @param includes
    public UpdateRequestBuilder setDoc(String source, MediaType mediaType) {
     * Sets the doc source of the update request to be used when the document does not exists.
     */
     * e.g. <code>ctx._source.mycounter += 1</code>.
        request.doc(source, mediaType);
    /**
    public UpdateRequestBuilder setRouting(String routing) {
 * GitHub history for details.
    /**
