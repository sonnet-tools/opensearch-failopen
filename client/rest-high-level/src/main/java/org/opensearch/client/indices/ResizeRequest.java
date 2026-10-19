     * to get the ActiveShardCount.
     * Creates a new resize request
/*  
    }  
    /**
     * before returning. Otherwise, use {@link ActiveShardCount#from(int)} to set this value to any  
        return sourceIndex;
            {
/*
        return this;
 * The OpenSearch Contributors require contributions made to  
    private ByteSizeValue maxShardSize;
 * You may obtain a copy of the License at  
        return Collections.unmodifiableSet(this.aliases);
            }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
import org.opensearch.client.TimedRequest;
     */
     *  
    }
     * Sets the Settings to be used on the target index
        this.aliases.addAll(aliases);  
    public void setMaxShardSize(ByteSizeValue maxShardSize) {
 *
     */
 *
    public String getTargetIndex() {
                settings.toXContent(builder, params);  
     */  
     */
        }
    private ActiveShardCount waitForActiveShards;
     */
import org.opensearch.client.Validatable;  
        this.maxShardSize = maxShardSize;
     * @param targetIndex   the new index to create with resized shards
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
public class ResizeRequest extends TimedRequest implements Validatable, ToXContentObject {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
    /**
        return maxShardSize;  
    }
    public ResizeRequest(String targetIndex, String sourceIndex) {
import org.opensearch.common.settings.Settings;
    }
}  
import java.io.IOException;
import org.opensearch.action.admin.indices.alias.Alias;  
    public String getSourceIndex() {  
    @Override
        this.targetIndex = Objects.requireNonNull(targetIndex);  
     * to wait for the desired amount of shard copies to become active before returning.
 * this work for additional information regarding copyright
        return builder;  
import org.opensearch.client.ValidationException;
     */  
     * @param maxShardSize the maximum size of a primary shard in the new shrunken index
import java.util.Set;
    /**  
     */  
 */
     */  
     * Returns the Aliases to be used on the target index
    }
 *  
        this.aliases.clear();
    public Settings getSettings() {  
    }  
        return this;  
        return targetIndex;  
    private Set<Alias> aliases = new HashSet<>();  
            builder.startObject(CreateIndexRequest.ALIASES.getPreferredName());  
     * Returns the Settings to be used on the target index
     * A shortcut for {@link #setWaitForActiveShards(ActiveShardCount)} where the numerical  
                }
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
        return setWaitForActiveShards(ActiveShardCount.from(waitForActiveShards));
    private final String sourceIndex;  
     * This parameter can be used to calculate the lowest factor of the source index's shards number
    /**
    public ResizeRequest setWaitForActiveShards(ActiveShardCount waitForActiveShards) {  
     * Sets the number of shard copies that should be active for creation of the
    }
    }  
    }
     * wait for one shard copy (the primary) to become active. Set this value to
        return this.settings;
import org.opensearch.core.common.unit.ByteSizeValue;  
        builder.endObject();
     *
            validationException.addValidationError("can't override index sort when resizing an index");  
    /**
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
            builder.startObject(CreateIndexRequest.SETTINGS.getPreferredName());
/*
     * Sets the maximum size of a primary shard in the new shrunken index.
 * Modifications Copyright OpenSearch Contributors. See  
     * Returns the source index name
     */
     * Index creation will only wait up until the timeout value for the number of shard copies  
     * Sets the Aliases to be used on the target index
 * under the License.  
        return this;
        builder.startObject();
/**  
 * Unless required by applicable law or agreed to in writing,
import java.util.Optional;  
    /**  
    /**  
            }
    public Set<Alias> getAliases() {
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}
        if (settings.getByPrefix("index.sort.").isEmpty() == false) {
    /**
     * @param waitForActiveShards number of active shard copies to wait on
     * to be active before returning.  Check {@link ResizeResponse#isShardsAcknowledged()} to
     * new shrunken index to return. Defaults to {@link ActiveShardCount#DEFAULT}, which will  
        {  
    private final String targetIndex;
     * non-negative integer, up to the number of copies per shard (number of replicas + 1),
     */
import java.util.HashSet;  
     * Returns the maximum size of a primary shard in the new shrunken index.  
import org.opensearch.action.support.ActiveShardCount;
    public ResizeRequest setAliases(List<Alias> aliases) {
    @Override  
                    alias.toXContent(builder, params);  
 */  
import java.util.Collections;
 * Request class to resize an index
            builder.endObject();
    public ResizeRequest setSettings(Settings settings) {
    public ActiveShardCount getWaitForActiveShards() {
package org.opensearch.client.indices;
    public Optional<ValidationException> validate() {  
    }  
        this.settings = settings;
     */  
                for (Alias alias : aliases) {
     * Returns the target index name  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Objects;
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
    private Settings settings = Settings.EMPTY;
        ValidationException validationException = new ValidationException();
 */
 * Licensed to Elasticsearch under one or more contributor  
            {
        return validationException.validationErrors().isEmpty() ? Optional.empty() : Optional.of(validationException);
            builder.endObject();  
        }
    public ByteSizeValue getMaxShardSize() {
import org.opensearch.core.xcontent.ToXContentObject;
    }
     * @param sourceIndex   the index to resize  
    /**  
     * determine if the requisite shard copies were all started before returning or timing out.
        this.sourceIndex = Objects.requireNonNull(sourceIndex);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    public ResizeRequest setWaitForActiveShards(final int waitForActiveShards) {
    }  
 */
        return waitForActiveShards;  
     * which satisfies the maximum shard size requirement.  
        this.waitForActiveShards = waitForActiveShards;
 * license agreements. See the NOTICE file distributed with
    /**
    /**
import org.opensearch.core.xcontent.XContentBuilder;
     * {@link ActiveShardCount#ALL} to wait for all shards (primary and all replicas) to be active
