     */  
 *  
 * Licensed to Elasticsearch under one or more contributor  
     */
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
     * Sets the version, which will cause the delete operation to only be performed if a matching
@PublicApi(since = "1.0.0")
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
    implements  
 * A delete document action request builder.  
        return this;  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
import org.opensearch.index.VersionType;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        request.versionType(versionType);
    }
     * Sets the type of versioning to use. Defaults to {@link VersionType#INTERNAL}.
        super(client, action, new DeleteRequest(index));
    /**
 * GitHub history for details.
 * software distributed under the License is distributed on an
 */  
        return this;  
     * Sets the id of the document to delete.  
}  
     * If the document last modification was assigned a different sequence number a
 * license agreements. See the NOTICE file distributed with
     * version exists and no changes happened on the doc since then.  
import org.opensearch.action.support.replication.ReplicationRequestBuilder;
    public DeleteRequestBuilder setId(String id) {
 */  
        return this;
    }
        super(client, action, new DeleteRequest());
        return this;  
        request.setIfSeqNo(seqNo);
     *  
    /**
 *
 *
    public DeleteRequestBuilder setIfPrimaryTerm(long term) {
 */
/*  
 * ownership. Elasticsearch licenses this file to you under  
     */
     * Controls the shard routing of the delete request. Using this value to hash the shard
     * and not the id.  
 * Modifications Copyright OpenSearch Contributors. See
/*
        WriteRequestBuilder<DeleteRequestBuilder> {
    }  
import org.opensearch.transport.client.OpenSearchClient;  
 * KIND, either express or implied.  See the License for the
     */  
        request.setIfPrimaryTerm(term);
public class DeleteRequestBuilder extends ReplicationRequestBuilder<DeleteRequest, DeleteResponse, DeleteRequestBuilder>
     *  
    }
    public DeleteRequestBuilder setVersionType(VersionType versionType) {
     * sequence number. Must be used in combination with {@link #setIfPrimaryTerm(long)}
    public DeleteRequestBuilder(OpenSearchClient client, DeleteAction action) {  
 * this work for additional information regarding copyright
    /**
    }
import org.opensearch.action.support.WriteRequestBuilder;
     * If the document last modification was assigned a different term a
        request.id(id);  
        return this;
import org.opensearch.common.Nullable;  
 * @opensearch.api
     * only perform this delete request if the document was last modification was assigned the given
package org.opensearch.action.delete;
    public DeleteRequestBuilder setIfSeqNo(long seqNo) {
    public DeleteRequestBuilder setRouting(String routing) {
 * the Apache License, Version 2.0 (the "License"); you may
     * only perform this delete request if the document was last modification was assigned the given
        return this;
    }
    public DeleteRequestBuilder(OpenSearchClient client, DeleteAction action, @Nullable String index) {
    /**
import org.opensearch.common.annotation.PublicApi;
 */  
        request.routing(routing);  
        request.version(version);  
 * You may obtain a copy of the License at  
    }
     * primary term. Must be used in combination with {@link #setIfSeqNo(long)}
    public DeleteRequestBuilder setVersion(long version) {
 * Unless required by applicable law or agreed to in writing,
    /**  
 * specific language governing permissions and limitations
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
     */
 * not use this file except in compliance with the License.
     */  
/*  
    }
/**
    /**  
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
