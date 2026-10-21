            List<IndexTemplateMetadata> templates = client().admin().indices().prepareGetTemplates("test_*").get().getIndexTemplates();
                        addedFound = true;
            assertTrue(changedFound);
        @Override
                .indices()
            Setting.Property.NodeScope,
        // Wait for the templates to be updated back to normal
import org.opensearch.transport.client.Client;
            );
                );
                clusterService,
                        break;
        static final Setting<Integer> UPDATE_TEMPLATE_DUMMY_SETTING = Setting.intSetting(
            assertTrue(dummyFound);
 */
            client().admin()
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.cluster.metadata;
            for (int i = 0; i < 3; i++) {
    private void assertTemplates() throws Exception {
 *    http://www.apache.org/licenses/LICENSE-2.0
                    .prepareUpdateSettings()
                .setOrder(0)
            }
    }
                .indices()
            return super.createComponents(
import org.opensearch.env.NodeEnvironment;
        // This setting is used to simulate cluster state updates
                .preparePutTemplate("test_removed_template")
 * Modifications Copyright OpenSearch Contributors. See
            assertTrue(addedFound);
                        assertFalse(dummyFound);
            });
                    IndexTemplateMetadata.builder("test_changed_template").order(10).patterns(Collections.singletonList("*")).build()
                        break;
        @Override
                );
 */
import org.apache.logging.log4j.LogManager;
            NamedWriteableRegistry namedWriteableRegistry,
                expressionResolver,
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            }
                        assertFalse(addedFound);
import java.util.Map;
            );
import java.util.function.Supplier;
                        assertThat(templateMetadata.getOrder(), equalTo(10));
                    )
            // so we need to simulate updates to make sure the template upgrade kicks in
        AtomicInteger updateCount = new AtomicInteger();
 * under the License.
            clusterService.getClusterSettings().addSettingsUpdateConsumer(UPDATE_TEMPLATE_DUMMY_SETTING, integer -> {
            assertThat(templates, hasSize(2));
 * specific language governing permissions and limitations
import org.opensearch.cluster.service.ClusterService;
            boolean changedFound = false;
 *
import org.opensearch.common.settings.Settings;
        }
import org.opensearch.core.xcontent.NamedXContentRegistry;
    }
        assertAcked(
                }
                        Settings.builder().put(TestPlugin.UPDATE_TEMPLATE_DUMMY_SETTING.getKey(), updateCount.incrementAndGet())
import org.opensearch.test.OpenSearchIntegTestCase;
    public static final class TestPlugin extends Plugin {
        private static final Logger logger = LogManager.getLogger(TestPlugin.class);
    }
            client().admin()
            );
        protected final Settings settings;
 * The OpenSearch Contributors require contributions made to
        assertTemplates();
import java.util.List;
        assertBusy(() -> {
        });
            return Collections.singletonList(UPDATE_TEMPLATE_DUMMY_SETTING);
        ) {
                        changedFound = true;
    public void testTemplateUpdate() throws Exception {
        );
        public UnaryOperator<Map<String, IndexTemplateMetadata>> getIndexTemplateMetadataUpgrader() {
            assertThat(templates, hasSize(3));
                }
                        fail("unexpected template " + templateMetadata.getName());
                client,
                switch (templateMetadata.getName()) {
            assertTrue(addedFound);
                    "test_changed_template",
import static org.hamcrest.Matchers.equalTo;
            boolean addedFound = false;
            Setting.Property.Dynamic
 * compatible open source license.
 * this work for additional information regarding copyright
 *
 * not use this file except in compliance with the License.
                    case "test_changed_template":
            boolean dummyFound = false;
                    case "test_added_template":
                        addedFound = true;
                        break;
                client().admin()
                        break;
        return Collections.singletonList(TestPlugin.class);
                .preparePutTemplate("test_dummy_template")
            // the updates only happen on cluster state updates, so we need to make sure that the cluster state updates are happening
                    default:
                    .prepareUpdateSettings()
                        Settings.builder().put(TestPlugin.UPDATE_TEMPLATE_DUMMY_SETTING.getKey(), updateCount.incrementAndGet())
                    case "test_added_template":
            this.settings = settings;
                    )
                        assertFalse(changedFound);
                client().admin()
                .get()
                scriptService,
            0,
                templates.put(
        // Make sure all templates are recreated correctly
}
 * Unless required by applicable law or agreed to in writing,
/*
 * SPDX-License-Identifier: Apache-2.0
                namedWriteableRegistry,
            // the updates only happen on cluster state updates, so we need to make sure that the cluster state updates are happening
    @Override
 * KIND, either express or implied.  See the License for the
                .get()
 * license agreements. See the NOTICE file distributed with
                    .get()
                xContentRegistry,
import static org.hamcrest.Matchers.hasSize;
                    default:
            NodeEnvironment nodeEnvironment,
                        changedFound = true;
                        dummyFound = true;
                environment,
                switch (templateMetadata.getName()) {
                    .cluster()
        // Change some templates
/*
    }
                return templates;
            // so we need to simulate updates to make sure the template upgrade kicks in
/*
        public TestPlugin(Settings settings) {
import org.apache.logging.log4j.Logger;
import org.opensearch.repositories.RepositoriesService;
            ResourceWatcherService resourceWatcherService,
import org.opensearch.script.ScriptService;
            for (int i = 0; i < 2; i++) {
                        assertFalse(changedFound);
                    .cluster()
                templates.put(
import org.opensearch.common.settings.Setting;
        public Collection<Object> createComponents(
                IndexTemplateMetadata templateMetadata = templates.get(i);
        );
                repositoriesServiceSupplier
public class TemplateUpgradeServiceIT extends OpenSearchIntegTestCase {
        assertAcked(
 *
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                .preparePutTemplate("test_changed_template")
            assertAcked(
        assertTemplates();
            ScriptService scriptService,
                        break;
            return templates -> {
 * You may obtain a copy of the License at
        }
                    case "test_dummy_template":
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import java.util.Collection;
                threadPool,
import java.util.Collections;
        // Wipe out all templates
                templates.remove("test_removed_template");
        AtomicInteger updateCount = new AtomicInteger();
                        fail("unexpected template " + templateMetadata.getName());
                        break;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
        }
 * Licensed to Elasticsearch under one or more contributor
                nodeEnvironment,
                .get()
            boolean changedFound = false;
            Client client,
import java.util.function.UnaryOperator;
        assertAcked(client().admin().indices().prepareDeleteTemplate("test_*").get());
                .indices()
            assertTrue(changedFound);
                    .setTransientSettings(
import org.opensearch.plugins.Plugin;
        }
        @Override
                logger.debug("the template dummy setting was updated to {}", integer);
            "tests.update_template_count",
            };
        });
                    case "test_changed_template":
                .setPatterns(Collections.singletonList("*"))
        assertAcked(
            Supplier<RepositoriesService> repositoriesServiceSupplier
                        assertFalse(addedFound);
            ClusterService clusterService,
                    "test_added_template",
import org.opensearch.threadpool.ThreadPool;
            ThreadPool threadPool,
 * ownership. Elasticsearch licenses this file to you under
        public List<Setting<?>> getSettings() {
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.watcher.ResourceWatcherService;
                .setOrder(0)
            assertAcked(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                .setPatterns(Collections.singletonList("*"))
 * GitHub history for details.
            Environment environment,
import org.opensearch.env.Environment;
                        break;
            boolean addedFound = false;
                    IndexTemplateMetadata.builder("test_added_template").patterns(Collections.singletonList("*")).build()
                .setPatterns(Collections.singletonList("*"))
        );
            client().admin()
                resourceWatcherService,
                    .setTransientSettings(
 * software distributed under the License is distributed on an
                        assertThat(templateMetadata.getOrder(), equalTo(10));
            IndexNameExpressionResolver expressionResolver,
                IndexTemplateMetadata templateMetadata = templates.get(i);
            List<IndexTemplateMetadata> templates = client().admin().indices().prepareGetTemplates("test_*").get().getIndexTemplates();
                .setOrder(1)
 */
        assertBusy(() -> {
                    .get()
 * the Apache License, Version 2.0 (the "License"); you may
            NamedXContentRegistry xContentRegistry,
