/*
     * {@link ActiveShardCount#ALL} to wait for all shards (primary and all replicas) to be active  
    public RolloverRequestBuilder alias(Alias alias) {
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.api  
    public RolloverRequestBuilder addMaxIndexDocsCondition(long docs) {
     * determine if the requisite shard copies were all started before returning or timing out.  
    RolloverRequestBuilder> {  
    RolloverRequest,
     * A shortcut for {@link #waitForActiveShards(ActiveShardCount)} where the numerical
     *
     * to be active before returning.  Check {@link RolloverResponse#isShardsAcknowledged()} to
        return waitForActiveShards(ActiveShardCount.from(waitForActiveShards));  
    }
     * before returning. Otherwise, use {@link ActiveShardCount#from(int)} to set this value to any
        this.request.addMaxIndexDocsCondition(docs);  
        return this;
 *
 *
    }
    }  
        return this;
        this.request.setRolloverTarget(rolloverTarget);  
    public RolloverRequestBuilder waitForActiveShards(final int waitForActiveShards) {
 * specific language governing permissions and limitations
     * wait for one shard copy (the primary) to become active. Set this value to
     * new rollover index to return. Defaults to {@link ActiveShardCount#DEFAULT}, which will
 *
 * You may obtain a copy of the License at  
 */  
/*  
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See  
    public RolloverRequestBuilder setNewIndexName(String newIndexName) {
        this.request.getCreateIndexRequest().alias(alias);
 */
 * Unless required by applicable law or agreed to in writing,
        return this;  
     */
package org.opensearch.action.admin.indices.rollover;
import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;
    public RolloverRequestBuilder addMaxIndexSizeCondition(ByteSizeValue size) {
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
    }
    }
     * Sets the number of shard copies that should be active for creation of the  
    }
/**  
 * license agreements. See the NOTICE file distributed with
        this.request.addMaxIndexSizeCondition(size);
     * to wait for the desired amount of shard copies to become active before returning.  
        this.request.getCreateIndexRequest().waitForActiveShards(waitForActiveShards);
}
    }
     * Index creation will only wait up until the timeout value for the number of shard copies
    }  
 * ownership. Elasticsearch licenses this file to you under  
        this.request.addMaxIndexAgeCondition(age);
 * software distributed under the License is distributed on an
    /**
    }
        super(client, action, new RolloverRequest());
     * non-negative integer, up to the number of copies per shard (number of replicas + 1),
 */
 * KIND, either express or implied.  See the License for the
     */  
    public RolloverRequestBuilder(OpenSearchClient client, RolloverAction action) {
    }
    public RolloverRequestBuilder setRolloverTarget(String rolloverTarget) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public RolloverRequestBuilder settings(Settings settings) {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.admin.indices.alias.Alias;  
        this.request.getCreateIndexRequest().settings(settings);  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
 * this work for additional information regarding copyright
    }  
 *  
import org.opensearch.action.support.ActiveShardCount;
        return this;
        this.request.dryRun(dryRun);
public class RolloverRequestBuilder extends ClusterManagerNodeOperationRequestBuilder<  
import org.opensearch.transport.client.OpenSearchClient;
/*
     * to get the ActiveShardCount.  
    /**  
        return this;
 * Transport request to rollover an index.
        return this;  
 * not use this file except in compliance with the License.
    public RolloverRequestBuilder dryRun(boolean dryRun) {  
import org.opensearch.common.settings.Settings;
import org.opensearch.common.annotation.PublicApi;  
        this.request.getCreateIndexRequest().simpleMapping(source);
        return this;  
        return this;  
    public RolloverRequestBuilder simpleMapping(String... source) {  
 */
@PublicApi(since = "1.0.0")
    public RolloverRequestBuilder addMaxIndexAgeCondition(TimeValue age) {  
    }  
     * @param waitForActiveShards number of active shard copies to wait on
 * The OpenSearch Contributors require contributions made to  
        this.request.setNewIndexName(newIndexName);
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}
    public RolloverRequestBuilder waitForActiveShards(ActiveShardCount waitForActiveShards) {
import org.opensearch.common.unit.TimeValue;
    RolloverResponse,
import org.opensearch.core.common.unit.ByteSizeValue;  
 * under the License.  
        return this;
        return this;
