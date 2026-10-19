            return Optional.of(new Tuple<>(changes, deletes));
 * software distributed under the License is distributed on an
import org.opensearch.common.unit.TimeValue;
    public final Client client;
                if (value.equals(existingMap.get(key)) == false) {
    @Override
    private final UnaryOperator<Map<String, IndexTemplateMetadata>> indexTemplateMetadataUpgraders;
    }
 * The OpenSearch Contributors require contributions made to
            // we already checked these sets of templates - no reason to check it again
    void upgradeTemplates(Map<String, BytesReference> changes, Set<String> deletions) {
        }
import java.util.Optional;
        }
                // Check upgraders are satisfied after the update completed. If they still
                }
                    changes.get().v1().size(),
 *
 * SPDX-License-Identifier: Apache-2.0
            );
package org.opensearch.cluster.metadata;
            }, MediaTypeRegistry.JSON, PARAMS, false);
            return;
 * Modifications Copyright OpenSearch Contributors. See
        if (changes.isPresent()) {
            client.admin().indices().deleteTemplate(request, new ActionListener<AcknowledgedResponse>() {
            }
                        logger.warn(new ParameterizedMessage("Error deleting template [{}]", template), e);
 *
                    logger.warn("Templates are still reported as out of date after the upgrade. The template upgrade will be retried.");
import org.opensearch.common.collect.Tuple;
import org.opensearch.gateway.GatewayService;
 * Unless required by applicable law or agreed to in writing,
                final Map<String, IndexTemplateMetadata> upgradedTemplates = clusterService.state().getMetadata().getTemplates();
        if (state.blocks().hasGlobalBlock(GatewayService.STATE_NOT_RECOVERED_BLOCK)) {
                public void onResponse(AcknowledgedResponse response) {
            });
 * not use this file except in compliance with the License.
            // we can do identity check here because due to cluster state diffs the actual map will not change
            Map<String, IndexTemplateMetadata> upgradedTemplates = new HashMap<>(templates);
    private static final Logger logger = LogManager.getLogger(TemplateUpgradeService.class);
        try {
            existingMap.put(customCursor.getKey(), customCursor.getValue());
            request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1));
import java.util.Map;
import static java.util.Collections.singletonMap;
                upgradedTemplates = upgrader.apply(upgradedTemplates);
            });
        }
                final boolean changesRequired = calculateTemplateChanges(upgradedTemplates).isPresent();
                        logger.warn("Error deleting template [{}], request was not acknowledged", template);
        this.clusterService = clusterService;
        Map<String, IndexTemplateMetadata> existingMap = new HashMap<>();
            client.admin().indices().putTemplate(request, new ActionListener<AcknowledgedResponse>() {
            // if there were no changes
                public void onResponse(AcknowledgedResponse response) {
                    anyUpgradeFailed.set(true);
            DeleteIndexTemplateRequest request = new DeleteIndexTemplateRequest(template);
import org.opensearch.plugins.Plugin;
            upgradedMap.forEach((key, value) -> {
import org.opensearch.core.xcontent.ToXContent;
    public TemplateUpgradeService(
        this.indexTemplateMetadataUpgraders = templates -> {
                // else tinkering with the templates during the upgrade.
            if (upgradesInProgress.compareAndSet(0, changes.get().v1().size() + changes.get().v2().size() + 1)) {
                    "Starting template upgrade to version {}, {} templates will be updated and {} will be removed",
                }
            for (UnaryOperator<Map<String, IndexTemplateMetadata>> upgrader : indexTemplateMetadataUpgraders) {
            throw new IllegalStateException("template updates from the template upgrade service should always happen in a system context");
        Client client,
            // while they actually do exist
        }
    }
import org.opensearch.cluster.ClusterState;
            // wait until the gateway has recovered from disk, otherwise we think may not have the index templates,
        Map<String, IndexTemplateMetadata> upgradedMap = indexTemplateMetadataUpgraders.apply(existingMap);
 */
                public void onFailure(Exception e) {
                } else {
        }
    }
                    changes.get().v2().size()
                public void onFailure(Exception e) {
 * this file be licensed under the Apache-2.0 license or a
                    if (e instanceof IndexTemplateMissingException == false) {
            }
                    tryFinishUpgrade(anyUpgradeFailed);
import org.opensearch.cluster.service.ClusterService;
            return;
                IndexTemplateMetadata.Builder.toInnerXContentWithTypes(templateMetadata, builder, params);
                    changes.put(key, toBytesReference(value));
        }
        return Optional.empty();
                        // otherwise we need to warn
    private Map<String, IndexTemplateMetadata> lastTemplateMetadata;
            throw new IllegalStateException("Cannot serialize template [" + templateMetadata.getName() + "]", ex);
            });
 */
import java.util.HashSet;
        Collection<UnaryOperator<Map<String, IndexTemplateMetadata>>> indexTemplateMetadataUpgraders
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequest;
                        logger.warn("Error updating template [{}], request was not acknowledged", change.getKey());
/*
import org.opensearch.core.action.ActionListener;
    Optional<Tuple<Map<String, BytesReference>, Set<String>>> calculateTemplateChanges(final Map<String, IndexTemplateMetadata> templates) {
 *     http://www.apache.org/licenses/LICENSE-2.0
                    logger.info("Templates were upgraded successfully to version {}", Version.CURRENT);
        }
                if (changesRequired) {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.threadpool.ThreadPool;
 * KIND, either express or implied.  See the License for the
                        anyUpgradeFailed.set(true);
/*
 * ownership. Elasticsearch licenses this file to you under
import java.util.HashMap;
                // report that changes are required, this might indicate a bug or that something
 * Upgrades Templates on behalf of installed {@link Plugin}s when a node joins the cluster
            Map<String, BytesReference> changes = new HashMap<>();
            return upgradedTemplates;
                }
import org.opensearch.cluster.node.DiscoveryNode;
        }
 * @opensearch.internal
                    }
                }
 * this work for additional information regarding copyright
import org.opensearch.cluster.ClusterStateListener;
                    anyUpgradeFailed.set(true);
import java.util.concurrent.atomic.AtomicInteger;
 *
        for (Map.Entry<String, IndexTemplateMetadata> customCursor : templates.entrySet()) {
import org.opensearch.Version;
import java.util.concurrent.atomic.AtomicBoolean;
            // remove templates if needed
                    if (response.isAcknowledged() == false) {
        ThreadPool threadPool,
                    }
        // upgrade global custom meta data
            try {
 * Licensed to Elasticsearch under one or more contributor
        }
            });
import org.opensearch.indices.IndexTemplateMissingException;
                threadPool.generic().execute(() -> upgradeTemplates(changes.get().v1(), changes.get().v2()));
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * specific language governing permissions and limitations
                if (upgradedMap.containsKey(s) == false) {
                    if (response.isAcknowledged() == false) {
                    tryFinishUpgrade(anyUpgradeFailed);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.ClusterChangedEvent;
            } finally {
}
        for (String template : deletions) {
import org.opensearch.core.xcontent.XContentHelper;
                        // we might attempt to delete the same template from different nodes - so that's ok if template doesn't exist
        this.client = client;
                @Override
        ClusterState state = event.state();
        // collect current templates
                    tryFinishUpgrade(anyUpgradeFailed);
                final int noMoreUpgrades = upgradesInProgress.decrementAndGet();
                @Override
                @Override
public class TemplateUpgradeService implements ClusterStateListener {
    }
                }
import java.util.Set;
                MediaTypeRegistry.JSON
    private BytesReference toBytesReference(IndexTemplateMetadata templateMetadata) {
        if (threadPool.getThreadContext().isSystemContext() == false) {
        if (upgradesInProgress.decrementAndGet() == 1) {
        if (templates == lastTemplateMetadata) {
                    deletes.add(s);
    public void clusterChanged(ClusterChangedEvent event) {
                assert threadPool.getThreadContext().isSystemContext();
        }
    }
/*
        if (DiscoveryNode.isClusterManagerNode(clusterService.getSettings())) {
                change.getValue(),
                // this is the last upgrade, the templates should now be in the desired state
                    logger.info("Templates were partially upgraded to version {}", Version.CURRENT);
 * You may obtain a copy of the License at
        }
        if (upgradedMap.equals(existingMap) == false) {
        final Map<String, IndexTemplateMetadata> templates = state.getMetadata().getTemplates();
/**
                }
                }
                    }
                    Version.CURRENT,
        for (Map.Entry<String, BytesReference> change : changes.entrySet()) {
            return XContentHelper.toXContent((builder, params) -> {
    private static final ToXContent.Params PARAMS = new ToXContent.MapParams(singletonMap("reduce_mappings", "true"));
 */
        };
            }
    void tryFinishUpgrade(AtomicBoolean anyUpgradeFailed) {
            Set<String> deletes = new HashSet<>();
 * GitHub history for details.
        if (upgradesInProgress.get() > 0) {
                if (anyUpgradeFailed.get()) {
    ) {
        ClusterService clusterService,
        final AtomicBoolean anyUpgradeFailed = new AtomicBoolean(false);
    public final ThreadPool threadPool;
                logger.info(
        if (state.nodes().isLocalNodeElectedClusterManager() == false) {
            return;
            existingMap.keySet().forEach(s -> {
    final AtomicInteger upgradesInProgress = new AtomicInteger();
                        anyUpgradeFailed.set(true);
import org.apache.logging.log4j.message.ParameterizedMessage;
            // we are already running some upgrades - skip this cluster state update
            return;
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateRequest;
import java.io.IOException;
                    tryFinishUpgrade(anyUpgradeFailed);
        lastTemplateMetadata = templates;
import java.util.function.UnaryOperator;
            clusterService.addListener(this);
 */
                    logger.warn(new ParameterizedMessage("Error updating template [{}]", change.getKey()), e);
                return builder;
 * compatible open source license.
import org.apache.logging.log4j.Logger;
    }
            PutIndexTemplateRequest request = new PutIndexTemplateRequest(change.getKey()).source(
                @Override
                assert noMoreUpgrades == 0;
import org.opensearch.core.common.bytes.BytesReference;
                );
        }
import java.util.Collection;
import org.apache.logging.log4j.LogManager;
    public final ClusterService clusterService;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        Optional<Tuple<Map<String, BytesReference>, Set<String>>> changes = calculateTemplateChanges(templates);
        } catch (IOException ex) {
 * under the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assert upgradesInProgress.get() > 0;
            request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1));
 *
        this.threadPool = threadPool;
                }
import org.opensearch.transport.client.Client;
        }
