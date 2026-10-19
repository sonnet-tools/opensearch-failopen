    private IndicesOptions indicesOptions = IndicesOptions.strictExpandOpen();
/*  
     * @param indicesOptions the desired behaviour regarding indices to ignore and wildcard indices expressions
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
     * Defaults to {@link ActiveShardCount#DEFAULT}, which will wait for one shard copy
    public CloseIndexRequest waitForActiveShards(ActiveShardCount waitForActiveShards) {
 */  
/*
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
     *  
     * Returns the indices to close
    public ActiveShardCount waitForActiveShards() {
    public Optional<ValidationException> validate() {
     * (the primary) to become active. Set this value to {@link ActiveShardCount#ALL} to  
            return Optional.of(validationException);  
     * Sets the number of shard copies that should be active for indices opening to return.
 * A request to close an index.
     */
    private ActiveShardCount waitForActiveShards = ActiveShardCount.DEFAULT;
 * not use this file except in compliance with the License.
 */  
    /**
     *
    public String[] indices() {
     * @param indices the indices to close
/**
    public CloseIndexRequest indicesOptions(IndicesOptions indicesOptions) {  
     */
 * KIND, either express or implied.  See the License for the
     */
public class CloseIndexRequest extends TimedRequest implements Validatable {
    /**
     * @param waitForActiveShards number of active shard copies to wait on  
 * specific language governing permissions and limitations
        }  
        } else {
            ValidationException validationException = new ValidationException();
     * Creates a new close index request
    }
     * Otherwise, use {@link ActiveShardCount#from(int)} to set this value to any
            validationException.addValidationError("index is missing");
     */
 *
 *  
 * Modifications Copyright OpenSearch Contributors. See
    }
import org.opensearch.action.support.ActiveShardCount;
        this.indices = indices;
        if (indices == null || indices.length == 0) {  
 * license agreements. See the NOTICE file distributed with
            return Optional.empty();
    /**
    }
/*  
import java.util.Optional;
     * @return the current behaviour when it comes to index names and wildcard indices expressions  
        return this;
import org.opensearch.client.TimedRequest;
 * this work for additional information regarding copyright
     *  
        this.indicesOptions = indicesOptions;
    public IndicesOptions indicesOptions() {
     * For example indices that don't exist.
        this.waitForActiveShards = waitForActiveShards;  
import org.opensearch.client.ValidationException;  
 * SPDX-License-Identifier: Apache-2.0
    /**  
    @Override
     * Specifies what type of requested indices to ignore and how to deal with wildcard expressions.  
    }
import org.opensearch.action.admin.indices.open.OpenIndexResponse;
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * wait for all shards (primary and all replicas) to be active before returning.
     * to be active before returning.  Check {@link OpenIndexResponse#isShardsAcknowledged()} to  
     */  
    }  
     * Specifies what type of requested indices to ignore and how to deal with wildcard expressions.
        return this;
 * You may obtain a copy of the License at  
        return indicesOptions;  
 * the Apache License, Version 2.0 (the "License"); you may
    }  
}
 *
package org.opensearch.client.indices;
    private String[] indices;  
 * Unless required by applicable law or agreed to in writing,
        return waitForActiveShards;  
     */
    /**  
 */
 * compatible open source license.
import org.opensearch.client.Validatable;
     * non-negative integer, up to the number of copies per shard (number of replicas + 1),  
     *
 */  
import org.opensearch.action.support.IndicesOptions;  
    /**
        return indices;
     * Indices opening will only wait up until the timeout value for the number of shard copies
     * Returns the wait for active shard count or null if the default should be used  
     * For example indices that don't exist.
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
     * determine if the requisite shard copies were all started before returning or timing out.
     * to wait for the desired amount of shard copies to become active before returning.
    public CloseIndexRequest(String... indices) {  
 * under the License.  
 * software distributed under the License is distributed on an
