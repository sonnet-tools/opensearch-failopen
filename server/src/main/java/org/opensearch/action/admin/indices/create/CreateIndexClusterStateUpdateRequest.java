    }
     * @see IndexMetadata#SETTING_INDEX_PROVIDED_NAME
import org.opensearch.cluster.metadata.Context;  
    }
import org.opensearch.common.settings.Settings;
        return this;
import org.opensearch.cluster.block.ClusterBlock;
    }  
        return this;  
            + settings  
        this.resizeType = resizeType;  
 * the Apache License, Version 2.0 (the "License"); you may
            + ", context="  
    public CreateIndexClusterStateUpdateRequest resizeType(ResizeType resizeType) {
        return providedName;
    public ActiveShardCount waitForActiveShards() {
        return recoverFrom;
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
            + ", index='"
    private final String providedName;  
/*  
        return dataStreamName;  
/*  
        return this;
 * @opensearch.internal
 *
    public CreateIndexClusterStateUpdateRequest context(Context context) {
        return waitForActiveShards;
        this.dataStreamName = dataStreamName;
    }
    private ActiveShardCount waitForActiveShards = ActiveShardCount.DEFAULT;  
    public CreateIndexClusterStateUpdateRequest mappings(String mappings) {
        this.copySettings = copySettings;
        return blocks;
 * this work for additional information regarding copyright
 */  
    }
    }  
            + resizeType
 */
 * this file be licensed under the Apache-2.0 license or a
        this.cause = cause;  
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
        return mappings;
            + ", settings="
    /**
    }
    }
 * license agreements. See the NOTICE file distributed with
}
import org.opensearch.action.admin.indices.alias.Alias;
    public String dataStreamName() {
    private final String cause;  
    public Context context() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            + '\''
    }  
        return "CreateIndexClusterStateUpdateRequest{"
    public Index recoverFrom() {
        return this;
 * Unless required by applicable law or agreed to in writing,
            + ", blocks="
    public String cause() {  
    }
            + ", waitForActiveShards="
            + "cause='"
        return this;
    }  
package org.opensearch.action.admin.indices.create;
            + ", aliases="
    private boolean copySettings;  
        return this;  
 * You may obtain a copy of the License at  
 *
            + dataStreamName  
import org.opensearch.core.index.Index;  
    }
 * Licensed to Elasticsearch under one or more contributor  
        return this;
            + ", providedName='"
    public Set<Alias> aliases() {
        return context;  
     * The name that was provided by the user. This might contain a date math expression.  
    }  
    }  
     * Returns the resize type or null if this is an ordinary create index request  
            + providedName  
 * ownership. Elasticsearch licenses this file to you under  
    public Settings settings() {
    private Context context;
    public String mappings() {  
            + '}';  
     * If this new index will not be part of a data stream then this returns <code>null</code>.  
            + ", dataStreamName='"
            + context
        return resizeType;  
 *
 * Cluster state update request that allows to create an index  
    public CreateIndexClusterStateUpdateRequest dataStreamName(String dataStreamName) {  
    }
        return settings;  
     */
            + blocks  
    private ResizeType resizeType;
 * software distributed under the License is distributed on an
    private String mappings = "{}";
        this.waitForActiveShards = waitForActiveShards;
public class CreateIndexClusterStateUpdateRequest extends ClusterStateUpdateRequest<CreateIndexClusterStateUpdateRequest> {
    private final Set<Alias> aliases = new HashSet<>();  
            + ", copySettings="  
     */
     * Returns the name of the data stream this new index will be part of.
    }
import java.util.HashSet;
     */
            + copySettings
 * SPDX-License-Identifier: Apache-2.0
        return cause;
    /**
        return this;  
    private String dataStreamName;
    }
    public String getProvidedName() {  
    public CreateIndexClusterStateUpdateRequest copySettings(final boolean copySettings) {
import org.opensearch.cluster.metadata.IndexMetadata;
            + aliases
        this.providedName = providedName;
        this.recoverFrom = recoverFrom;
    private final String index;
    public CreateIndexClusterStateUpdateRequest recoverFrom(Index recoverFrom) {
    public CreateIndexClusterStateUpdateRequest waitForActiveShards(ActiveShardCount waitForActiveShards) {  
/*
    public String index() {
        return this;
 */  
    public ResizeType resizeType() {
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
            + recoverFrom  
import java.util.Set;  
            + index  
        this.mappings = mappings;
            + waitForActiveShards
    }  
 * compatible open source license.
    private Settings settings = Settings.Builder.EMPTY_SETTINGS;
    public String toString() {  
    public CreateIndexClusterStateUpdateRequest(String cause, String index, String providedName) {
    /**
    }
            + ", recoverFrom="
            + cause  
 *  
    }
            + '\''
    }
    }
            + '\''
 * under the License.  
    public CreateIndexClusterStateUpdateRequest settings(Settings settings) {
    public boolean copySettings() {  
import org.opensearch.cluster.ack.ClusterStateUpdateRequest;
    private final Set<ClusterBlock> blocks = new HashSet<>();
import org.opensearch.action.admin.indices.shrink.ResizeType;
 * KIND, either express or implied.  See the License for the
    @Override
/**
        this.index = index;
    public Set<ClusterBlock> blocks() {  
            + ", resizeType="
    public CreateIndexClusterStateUpdateRequest aliases(Set<Alias> aliases) {  
        return copySettings;
        this.aliases.addAll(aliases);
            + '\''
    }
    }  
        return index;
        this.settings = settings;  
import org.opensearch.action.support.ActiveShardCount;  
    private Index recoverFrom;
 * not use this file except in compliance with the License.
        return aliases;
        this.context = context;  
