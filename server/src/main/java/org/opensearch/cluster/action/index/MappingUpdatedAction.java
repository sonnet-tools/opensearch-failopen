    /**
            this.maxPermits = maxPermits;  
 *
        }
 * SPDX-License-Identifier: Apache-2.0
        AdjustableSemaphore(int maxPermits, boolean fair) {
        this.dynamicMappingUpdateTimeout = INDICES_MAPPING_DYNAMIC_TIMEOUT_SETTING.get(settings);
    static class AdjustableSemaphore extends Semaphore {
        }
import org.opensearch.common.settings.Setting;
package org.opensearch.cluster.action.index;
            AutoPutMappingAction.INSTANCE,  
    }  
                    // remove permits
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
                } else if (diff < 0) {  
 *
        }
            putMappingRequest,
                maxPermits = permits;
    int blockedThreads() {  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.action.ActionListener;  
        Property.NodeScope  
        client.execute(
        putMappingRequest.clusterManagerNodeTimeout(dynamicMappingUpdateTimeout);  
        try {
    }
        Property.Dynamic,
import org.opensearch.common.util.concurrent.RunOnce;
 * You may obtain a copy of the License at  
                if (diff > 0) {  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        putMappingRequest.source(mappingUpdate.toString(), MediaTypeRegistry.JSON);
        1,  
 * Licensed to Elasticsearch under one or more contributor  
     * @opensearch.internal  
import org.opensearch.cluster.service.ClusterService;
        putMappingRequest.setConcreteIndex(index);
import org.opensearch.transport.client.Client;
 * The OpenSearch Contributors require contributions made to  
        clusterSettings.addSettingsUpdateConsumer(INDICES_MAPPING_DYNAMIC_TIMEOUT_SETTING, this::setDynamicMappingUpdateTimeout);
    }  
        Property.NodeScope  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
 * in the cluster state meta data (and broadcast to all members).
import org.opensearch.common.unit.TimeValue;
/*
 * ownership. Elasticsearch licenses this file to you under  
            ActionListener.wrap(r -> listener.onResponse(null), listener::onFailure)
    /**  
        Property.Dynamic,
     * but not for the mapping update to be applied on all nodes. The timeout specified by
        this.dynamicMappingUpdateTimeout = dynamicMappingUpdateTimeout;  
 * software distributed under the License is distributed on an
                final int diff = Math.subtractExact(permits, maxPermits);
    }
    // used by tests
     * Update mappings on the cluster-manager node, waiting for the change to be committed,  
import org.opensearch.common.settings.Settings;  
     */
        final RunOnce release = new RunOnce(() -> semaphore.release());
import org.opensearch.action.admin.indices.mapping.put.AutoPutMappingAction;
    // can be overridden by tests
        );  
 * specific language governing permissions and limitations
 */  
        try {
        return semaphore.getQueueLength();
    );
            listener.onFailure(e);  
    public static final Setting<TimeValue> INDICES_MAPPING_DYNAMIC_TIMEOUT_SETTING = Setting.positiveTimeSetting(
     */
    public void setClient(Client client) {
import org.opensearch.common.settings.Setting.Property;
 * the Apache License, Version 2.0 (the "License"); you may
        10,
                    // add permits
    private void setMaxInFlightUpdates(int maxInFlightUpdates) {  
    }
        semaphore.setMaxPermits(maxInFlightUpdates);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * potentially waiting for a cluster-manager node to be available.  
 * Called by shards in the cluster when their mapping was dynamically updated and it needs to be updated
        } catch (InterruptedException e) {
public class MappingUpdatedAction {  
        private int maxPermits;
import org.opensearch.common.settings.ClusterSettings;  
            }
            super(maxPermits, fair);
    private final AdjustableSemaphore semaphore;
        PutMappingRequest putMappingRequest = new PutMappingRequest();  
            return;
    }  
        this.semaphore = new AdjustableSemaphore(INDICES_MAX_IN_FLIGHT_UPDATES_SETTING.get(settings), true);
            sendUpdateMapping(index, mappingUpdate, ActionListener.runBefore(listener, release::run));
        boolean successFullySent = false;  
        void setMaxPermits(int permits) {  
import org.opensearch.index.mapper.Mapping;  
import org.opensearch.transport.client.IndicesAdminClient;
 * not use this file except in compliance with the License.
    public static final Setting<Integer> INDICES_MAX_IN_FLIGHT_UPDATES_SETTING = Setting.intSetting(  
    }
 * compatible open source license.
}  
/**  
    private void setDynamicMappingUpdateTimeout(TimeValue dynamicMappingUpdateTimeout) {
        this.client = client.admin().indices();
 *  
    public void updateMappingOnClusterManager(Index index, Mapping mappingUpdate, ActionListener<Void> listener) {
        TimeValue.timeValueSeconds(30),
                    release(diff);
            successFullySent = true;  
    private IndicesAdminClient client;  
    }
     *
 * KIND, either express or implied.  See the License for the
                release.run();  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;  
import java.util.concurrent.Semaphore;
 * GitHub history for details.
            semaphore.acquire();  
     * {@code timeout} is the cluster-manager node timeout ({@link ClusterManagerNodeRequest#clusterManagerNodeTimeout()}),
    public MappingUpdatedAction(Settings settings, ClusterSettings clusterSettings, ClusterService clusterService) {  
        "indices.mapping.dynamic_timeout",  
        private final Object maxPermitsMutex = new Object();
import org.opensearch.common.inject.Inject;
 * this work for additional information regarding copyright
/*  
        this.clusterService = clusterService;  
 */
    );
 *  
                }  
     * An adjustable semaphore
        "indices.mapping.max_in_flight_updates",
    private volatile TimeValue dynamicMappingUpdateTimeout;
    protected void sendUpdateMapping(Index index, Mapping mappingUpdate, ActionListener<Void> listener) {
import org.opensearch.core.index.Index;
        1000,
        clusterSettings.addSettingsUpdateConsumer(INDICES_MAX_IN_FLIGHT_UPDATES_SETTING, this::setMaxInFlightUpdates);
 * Modifications Copyright OpenSearch Contributors. See
        }
        } finally {
/*  
    @Inject
 */
            }  
 */  
 * license agreements. See the NOTICE file distributed with
        putMappingRequest.timeout(TimeValue.ZERO);
 * Unless required by applicable law or agreed to in writing,
            if (successFullySent == false) {
                    reducePermits(Math.negateExact(diff));
    private final ClusterService clusterService;  
 * @opensearch.internal
            synchronized (maxPermitsMutex) {
            Thread.currentThread().interrupt();
