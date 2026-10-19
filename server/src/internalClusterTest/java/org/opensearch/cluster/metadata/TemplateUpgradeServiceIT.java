                    IndexTemplateMetadata.builder("test_changed_template").order(10).patterns(Collections.singletonList("*")).build()  
                    case "test_changed_template":
                switch (templateMetadata.getName()) {
                        break;
 * the Apache License, Version 2.0 (the "License"); you may
                .setOrder(0)
            0,  
                .setPatterns(Collections.singletonList("*"))
        private static final Logger logger = LogManager.getLogger(TestPlugin.class);
    public void testTemplateUpdate() throws Exception {  
                        Settings.builder().put(TestPlugin.UPDATE_TEMPLATE_DUMMY_SETTING.getKey(), updateCount.incrementAndGet())
            boolean changedFound = false;
import org.opensearch.env.Environment;
            );
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
 * this work for additional information regarding copyright
            boolean changedFound = false;
                        break;  
        assertTemplates();
            };  
                    .setTransientSettings(
                        changedFound = true;
            }  
                }
        assertBusy(() -> {
                        fail("unexpected template " + templateMetadata.getName());
 * software distributed under the License is distributed on an
                    default:
        ) {
                        assertFalse(addedFound);  
import org.apache.logging.log4j.Logger;
    @Override  
        assertAcked(client().admin().indices().prepareDeleteTemplate("test_*").get());  
import org.opensearch.threadpool.ThreadPool;
        AtomicInteger updateCount = new AtomicInteger();
                    )  
 */  
                .preparePutTemplate("test_changed_template")  
                .preparePutTemplate("test_dummy_template")
    }
            boolean dummyFound = false;
        assertAcked(
            clusterService.getClusterSettings().addSettingsUpdateConsumer(UPDATE_TEMPLATE_DUMMY_SETTING, integer -> {
 *
            // the updates only happen on cluster state updates, so we need to make sure that the cluster state updates are happening
        assertAcked(  
                xContentRegistry,
 * this file be licensed under the Apache-2.0 license or a
        assertTemplates();
        assertAcked(
import static org.hamcrest.Matchers.hasSize;
 *  
import java.util.Collections;
        protected final Settings settings;  
            assertTrue(changedFound);  
            client().admin()  
 * compatible open source license.
        @Override  
public class TemplateUpgradeServiceIT extends OpenSearchIntegTestCase {
 * The OpenSearch Contributors require contributions made to  
        return Collections.singletonList(TestPlugin.class);
                switch (templateMetadata.getName()) {
                );
                    case "test_changed_template":  
 *
                        assertThat(templateMetadata.getOrder(), equalTo(10));  
    private void assertTemplates() throws Exception {  
 * KIND, either express or implied.  See the License for the
                client().admin()
import java.util.concurrent.atomic.AtomicInteger;
            assertTrue(changedFound);
            assertTrue(dummyFound);
                clusterService,
 * Licensed to Elasticsearch under one or more contributor  
            List<IndexTemplateMetadata> templates = client().admin().indices().prepareGetTemplates("test_*").get().getIndexTemplates();
                client().admin()
                        assertFalse(addedFound);
            Setting.Property.Dynamic
            NamedXContentRegistry xContentRegistry,
            // so we need to simulate updates to make sure the template upgrade kicks in  
            NamedWriteableRegistry namedWriteableRegistry,
                .indices()
            assertThat(templates, hasSize(3));
                IndexTemplateMetadata templateMetadata = templates.get(i);
                        break;
                }
        }
 * Unless required by applicable law or agreed to in writing,
/*  
                        assertFalse(dummyFound);
            for (int i = 0; i < 3; i++) {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
/*  
                        break;
                    .cluster()  
                    case "test_added_template":
    }
        public TestPlugin(Settings settings) {
import java.util.function.UnaryOperator;  
                    IndexTemplateMetadata.builder("test_added_template").patterns(Collections.singletonList("*")).build()
            boolean addedFound = false;  
                        dummyFound = true;
            IndexNameExpressionResolver expressionResolver,
            assertTrue(addedFound);  
/*
                );
                templates.put(
        assertBusy(() -> {  
        AtomicInteger updateCount = new AtomicInteger();
            ResourceWatcherService resourceWatcherService,
        @Override
            Setting.Property.NodeScope,
            List<IndexTemplateMetadata> templates = client().admin().indices().prepareGetTemplates("test_*").get().getIndexTemplates();
import org.opensearch.common.settings.Setting;
                repositoriesServiceSupplier
        // Make sure all templates are recreated correctly
                .setOrder(1)  
import org.opensearch.core.xcontent.NamedXContentRegistry;
import static org.hamcrest.Matchers.equalTo;  
            this.settings = settings;  
 * ownership. Elasticsearch licenses this file to you under  
                        break;
            });
 * GitHub history for details.
import java.util.Collection;  
        public UnaryOperator<Map<String, IndexTemplateMetadata>> getIndexTemplateMetadataUpgrader() {  
        // Wipe out all templates
            boolean addedFound = false;  
                .setPatterns(Collections.singletonList("*"))  
                    .get()
import org.opensearch.common.settings.Settings;
                    .prepareUpdateSettings()
                        addedFound = true;
import org.opensearch.repositories.RepositoriesService;
    }
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        break;  
 * You may obtain a copy of the License at  
                client,  
        );
import org.opensearch.test.OpenSearchIntegTestCase;
                        Settings.builder().put(TestPlugin.UPDATE_TEMPLATE_DUMMY_SETTING.getKey(), updateCount.incrementAndGet())  
        public Collection<Object> createComponents(
                templates.put(
 * specific language governing permissions and limitations
    public static final class TestPlugin extends Plugin {
            }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                expressionResolver,  
                    .get()
                .indices()
                    .cluster()
                    )
 * Modifications Copyright OpenSearch Contributors. See
                    "test_changed_template",
 * SPDX-License-Identifier: Apache-2.0
                    default:
                threadPool,
        });  
                    "test_added_template",  
            client().admin()
                        addedFound = true;
 * under the License.  
import org.opensearch.watcher.ResourceWatcherService;
                        assertFalse(changedFound);
                .get()  
                scriptService,
            Supplier<RepositoriesService> repositoriesServiceSupplier  
import org.apache.logging.log4j.LogManager;
                .setPatterns(Collections.singletonList("*"))
            NodeEnvironment nodeEnvironment,  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.script.ScriptService;  
 */
                namedWriteableRegistry,
import java.util.List;
                logger.debug("the template dummy setting was updated to {}", integer);  
            ThreadPool threadPool,
 * license agreements. See the NOTICE file distributed with
        // Change some templates  
                        assertFalse(changedFound);
            return templates -> {
                        break;  
            assertTrue(addedFound);
            assertAcked(  
package org.opensearch.cluster.metadata;
            ClusterService clusterService,  
 */  
        );  
                        fail("unexpected template " + templateMetadata.getName());  
                .setOrder(0)
            // the updates only happen on cluster state updates, so we need to make sure that the cluster state updates are happening
        }
 * not use this file except in compliance with the License.
import org.opensearch.transport.client.Client;  
import java.util.function.Supplier;
                        changedFound = true;  
                .get()
import org.opensearch.cluster.service.ClusterService;  
                    case "test_added_template":  
        }  
            // so we need to simulate updates to make sure the template upgrade kicks in
            );
import org.opensearch.plugins.Plugin;
            ScriptService scriptService,  
            for (int i = 0; i < 2; i++) {
                nodeEnvironment,
                    .setTransientSettings(
import java.util.Map;  
            Client client,
import org.opensearch.env.NodeEnvironment;  
        static final Setting<Integer> UPDATE_TEMPLATE_DUMMY_SETTING = Setting.intSetting(
            return Collections.singletonList(UPDATE_TEMPLATE_DUMMY_SETTING);
                resourceWatcherService,  
        public List<Setting<?>> getSettings() {
                IndexTemplateMetadata templateMetadata = templates.get(i);  
                    case "test_dummy_template":  
            Environment environment,
            client().admin()
                .preparePutTemplate("test_removed_template")
        @Override  
}
        );
        // Wait for the templates to be updated back to normal  
                environment,  
            "tests.update_template_count",
            );  
                .get()
            assertThat(templates, hasSize(2));
                return templates;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)  
            assertAcked(
        );  
                .indices()  
            return super.createComponents(
        }  
                    .prepareUpdateSettings()  
                templates.remove("test_removed_template");  
                        assertThat(templateMetadata.getOrder(), equalTo(10));
        // This setting is used to simulate cluster state updates  
        });
