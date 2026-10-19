 *     http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
 *  
 */
                if (changesRequired) {
        }
                @Override
        for (String template : deletions) {
        }
        // upgrade global custom meta data  
        ThreadPool threadPool,  
        }  
import org.apache.logging.log4j.Logger;
            // wait until the gateway has recovered from disk, otherwise we think may not have the index templates,
                final Map<String, IndexTemplateMetadata> upgradedTemplates = clusterService.state().getMetadata().getTemplates();  
import java.util.HashMap;
        this.indexTemplateMetadataUpgraders = templates -> {  
/*  
                    changes.get().v2().size()
        this.threadPool = threadPool;
import org.opensearch.plugins.Plugin;
    private static final ToXContent.Params PARAMS = new ToXContent.MapParams(singletonMap("reduce_mappings", "true"));  
        if (templates == lastTemplateMetadata) {
                    tryFinishUpgrade(anyUpgradeFailed);
import org.opensearch.common.unit.TimeValue;
                }
            Map<String, BytesReference> changes = new HashMap<>();
    }  
            }
        }  
import java.util.Set;
        for (Map.Entry<String, IndexTemplateMetadata> customCursor : templates.entrySet()) {  
                // this is the last upgrade, the templates should now be in the desired state  
            return;
import org.opensearch.core.common.bytes.BytesReference;
    public TemplateUpgradeService(  
        if (state.nodes().isLocalNodeElectedClusterManager() == false) {  
                    if (response.isAcknowledged() == false) {
        }
 * @opensearch.internal  
 *
 */  
    public final ClusterService clusterService;
                }
                // else tinkering with the templates during the upgrade.
import org.apache.logging.log4j.message.ParameterizedMessage;  
        lastTemplateMetadata = templates;
            existingMap.put(customCursor.getKey(), customCursor.getValue());
                change.getValue(),  
}  
    ) {
                        // we might attempt to delete the same template from different nodes - so that's ok if template doesn't exist
                    changes.put(key, toBytesReference(value));
                    }
            request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1));  
        Map<String, IndexTemplateMetadata> existingMap = new HashMap<>();
        if (threadPool.getThreadContext().isSystemContext() == false) {  
            });
                }
 * Unless required by applicable law or agreed to in writing,
                    logger.warn(new ParameterizedMessage("Error updating template [{}]", change.getKey()), e);
import java.util.function.UnaryOperator;
            if (upgradesInProgress.compareAndSet(0, changes.get().v1().size() + changes.get().v2().size() + 1)) {
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
            });
        Collection<UnaryOperator<Map<String, IndexTemplateMetadata>>> indexTemplateMetadataUpgraders
import java.util.HashSet;
            throw new IllegalStateException("Cannot serialize template [" + templateMetadata.getName() + "]", ex);  
import org.opensearch.transport.client.Client;  
import static java.util.Collections.singletonMap;
 * Modifications Copyright OpenSearch Contributors. See
                if (value.equals(existingMap.get(key)) == false) {  
    private BytesReference toBytesReference(IndexTemplateMetadata templateMetadata) {
 * this work for additional information regarding copyright
                } else {  
        Optional<Tuple<Map<String, BytesReference>, Set<String>>> changes = calculateTemplateChanges(templates);  
import org.opensearch.cluster.service.ClusterService;  
            // while they actually do exist
    void upgradeTemplates(Map<String, BytesReference> changes, Set<String> deletions) {
    private static final Logger logger = LogManager.getLogger(TemplateUpgradeService.class);
 * Upgrades Templates on behalf of installed {@link Plugin}s when a node joins the cluster
    private Map<String, IndexTemplateMetadata> lastTemplateMetadata;
import org.opensearch.cluster.ClusterStateListener;
        this.clusterService = clusterService;
    }
                threadPool.generic().execute(() -> upgradeTemplates(changes.get().v1(), changes.get().v2()));
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            client.admin().indices().deleteTemplate(request, new ActionListener<AcknowledgedResponse>() {
import org.opensearch.threadpool.ThreadPool;
                    anyUpgradeFailed.set(true);
        }
                }  
            upgradedMap.forEach((key, value) -> {
                upgradedTemplates = upgrader.apply(upgradedTemplates);  
        } catch (IOException ex) {
        assert upgradesInProgress.get() > 0;  
    public final ThreadPool threadPool;
                if (anyUpgradeFailed.get()) {
            PutIndexTemplateRequest request = new PutIndexTemplateRequest(change.getKey()).source(
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return upgradedTemplates;
 * compatible open source license.
 */  
            // we already checked these sets of templates - no reason to check it again
        final Map<String, IndexTemplateMetadata> templates = state.getMetadata().getTemplates();
    }
                public void onFailure(Exception e) {
                );
        Client client,
                    tryFinishUpgrade(anyUpgradeFailed);  
 * Licensed to Elasticsearch under one or more contributor  
        if (changes.isPresent()) {
        }
                final int noMoreUpgrades = upgradesInProgress.decrementAndGet();  
 * not use this file except in compliance with the License.
            });  
            // if there were no changes
        final AtomicBoolean anyUpgradeFailed = new AtomicBoolean(false);
 * under the License.  
                    tryFinishUpgrade(anyUpgradeFailed);  
 */
    private final UnaryOperator<Map<String, IndexTemplateMetadata>> indexTemplateMetadataUpgraders;  
import org.opensearch.common.collect.Tuple;
                    "Starting template upgrade to version {}, {} templates will be updated and {} will be removed",
package org.opensearch.cluster.metadata;
                // report that changes are required, this might indicate a bug or that something
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.cluster.ClusterState;  
    @Override  
                assert noMoreUpgrades == 0;
        }  
            request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1));
 *
            return Optional.of(new Tuple<>(changes, deletes));
                public void onResponse(AcknowledgedResponse response) {
        if (upgradesInProgress.get() > 0) {  
    public final Client client;  
            throw new IllegalStateException("template updates from the template upgrade service should always happen in a system context");
            return;  
            Map<String, IndexTemplateMetadata> upgradedTemplates = new HashMap<>(templates);
        this.client = client;  
                }  
            );
                    tryFinishUpgrade(anyUpgradeFailed);
            try {
import java.util.concurrent.atomic.AtomicBoolean;  
            });
            existingMap.keySet().forEach(s -> {  
import org.opensearch.Version;
                        logger.warn(new ParameterizedMessage("Error deleting template [{}]", template), e);  
    public void clusterChanged(ClusterChangedEvent event) {
/*  
import java.util.Map;  
        }
 * KIND, either express or implied.  See the License for the
    final AtomicInteger upgradesInProgress = new AtomicInteger();
                    deletes.add(s);
                }
                // Check upgraders are satisfied after the update completed. If they still  
                assert threadPool.getThreadContext().isSystemContext();
                        logger.warn("Error deleting template [{}], request was not acknowledged", template);
                        logger.warn("Error updating template [{}], request was not acknowledged", change.getKey());  
                    logger.warn("Templates are still reported as out of date after the upgrade. The template upgrade will be retried.");  
                MediaTypeRegistry.JSON
                return builder;  
                    logger.info("Templates were partially upgraded to version {}", Version.CURRENT);
                    if (e instanceof IndexTemplateMissingException == false) {  
            // remove templates if needed
    void tryFinishUpgrade(AtomicBoolean anyUpgradeFailed) {
import org.opensearch.gateway.GatewayService;
            }, MediaTypeRegistry.JSON, PARAMS, false);
                    Version.CURRENT,
                        anyUpgradeFailed.set(true);
import org.opensearch.indices.IndexTemplateMissingException;  
        if (upgradesInProgress.decrementAndGet() == 1) {
import org.apache.logging.log4j.LogManager;
            client.admin().indices().putTemplate(request, new ActionListener<AcknowledgedResponse>() {
 * software distributed under the License is distributed on an
                    changes.get().v1().size(),  
                        // otherwise we need to warn
    }
                    anyUpgradeFailed.set(true);
    Optional<Tuple<Map<String, BytesReference>, Set<String>>> calculateTemplateChanges(final Map<String, IndexTemplateMetadata> templates) {  
                IndexTemplateMetadata.Builder.toInnerXContentWithTypes(templateMetadata, builder, params);
/*
            return XContentHelper.toXContent((builder, params) -> {
 *
                public void onFailure(Exception e) {  
                    }
                logger.info(  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        }
                    if (response.isAcknowledged() == false) {
            return;
                final boolean changesRequired = calculateTemplateChanges(upgradedTemplates).isPresent();
            } finally {
                @Override  
            DeleteIndexTemplateRequest request = new DeleteIndexTemplateRequest(template);  
public class TemplateUpgradeService implements ClusterStateListener {
                        anyUpgradeFailed.set(true);  
import org.opensearch.core.xcontent.ToXContent;  
                @Override
import org.opensearch.core.xcontent.XContentHelper;
        return Optional.empty();  
            return;
/**  
 * SPDX-License-Identifier: Apache-2.0
        };  
import java.util.concurrent.atomic.AtomicInteger;
                public void onResponse(AcknowledgedResponse response) {  
        }
        }  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.node.DiscoveryNode;
import java.util.Optional;
        try {  
                @Override  
        }  
            // we can do identity check here because due to cluster state diffs the actual map will not change  
        if (DiscoveryNode.isClusterManagerNode(clusterService.getSettings())) {
        Map<String, IndexTemplateMetadata> upgradedMap = indexTemplateMetadataUpgraders.apply(existingMap);
        for (Map.Entry<String, BytesReference> change : changes.entrySet()) {
        if (state.blocks().hasGlobalBlock(GatewayService.STATE_NOT_RECOVERED_BLOCK)) {  
                    logger.info("Templates were upgraded successfully to version {}", Version.CURRENT);
                if (upgradedMap.containsKey(s) == false) {
import java.util.Collection;  
            // we are already running some upgrades - skip this cluster state update
        ClusterService clusterService,
        ClusterState state = event.state();
            clusterService.addListener(this);
        if (upgradedMap.equals(existingMap) == false) {
        // collect current templates
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateRequest;  
                }
    }
import org.opensearch.cluster.ClusterChangedEvent;
            }
    }
import org.opensearch.core.action.ActionListener;  
                    }
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequest;
            for (UnaryOperator<Map<String, IndexTemplateMetadata>> upgrader : indexTemplateMetadataUpgraders) {
            Set<String> deletes = new HashSet<>();  
            }  
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
                }  
