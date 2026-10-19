import java.util.Collection;  
        request.addAliasAction(IndicesAliasesRequest.AliasActions.add().index("index").alias("alias"));
            .putList(IndicesAliasesPlugin.ALLOWED_ORIGINS_SETTING.getKey(), Collections.singletonList("allowed"))
                return Optional.empty();  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        static final Setting<List<String>> ALLOWED_ORIGINS_SETTING = Setting.listSetting(
    public void testSomeAllowed() {  
            return Collections.singletonList(ALLOWED_ORIGINS_SETTING);  
import org.opensearch.common.settings.Setting;
            Collections.emptyList(),
                }
import org.opensearch.plugins.Plugin;  
        final Settings settings = Settings.builder()  
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
        assertThat(e, hasToString(containsString("origin [" + origin + "] not allowed for index [index]")));  
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}  
        createIndex("foo", fooIndexSettings);
 * license agreements. See the NOTICE file distributed with
        createIndex("bar", barIndexSettings);
import org.opensearch.plugins.ActionPlugin;
import static org.hamcrest.Matchers.equalTo;  
/*
 * under the License.  
import java.util.Collections;
        final Settings settings = Settings.builder()
        assertTrue(client().admin().indices().getAliases(new GetAliasesRequest("alias")).actionGet().getAliases().isEmpty());
        request.addAliasAction(IndicesAliasesRequest.AliasActions.add().index("bar").alias("alias"));  
        );
        }
            .putList(IndicesAliasesPlugin.ALLOWED_ORIGINS_SETTING.getKey(), Collections.singletonList("allowed"))
            .build();  
 * KIND, either express or implied.  See the License for the
import java.util.Optional;
import static org.hamcrest.Matchers.containsString;
 *
    @Override  
            .putList(IndicesAliasesPlugin.ALLOWED_ORIGINS_SETTING.getKey(), Collections.singletonList("foo_allowed"))
 * You may obtain a copy of the License at  
        final GetAliasesResponse response = client().admin().indices().getAliases(new GetAliasesRequest("alias")).actionGet();
                    if (allowedOrigins.contains(request.origin()) == false) {
import static org.hamcrest.Matchers.hasSize;
        final Settings barIndexSettings = Settings.builder()
import org.opensearch.common.settings.Settings;  
            .build();
    public static class IndicesAliasesPlugin extends Plugin implements ActionPlugin {  
public class ValidateIndicesAliasesRequestIT extends OpenSearchSingleNodeTestCase {
            return Collections.singletonList((request, state, indices) -> {
 * this file be licensed under the Apache-2.0 license or a
                        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        final IndicesAliasesRequest request = new IndicesAliasesRequest().origin(origin);  
            Setting.Property.IndexScope,  
                            index.getName()
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
        final String index = "foo_allowed".equals(origin) ? "bar" : "foo";
    protected Collection<Class<? extends Plugin>> getPlugins() {
        final Settings fooIndexSettings = Settings.builder()
package org.opensearch.action.admin.indices.alias;
        assertThat(response.getAliases().keySet().iterator().next(), equalTo("index"));  
        final IndicesAliasesRequest request = new IndicesAliasesRequest().origin(origin);
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * compatible open source license.
 */
import org.opensearch.action.admin.indices.alias.get.GetAliasesResponse;  
        public List<Setting<?>> getSettings() {
 * GitHub history for details.
            "index.aliases.allowed_origins",  
 */  
            Setting.Property.Dynamic
/*  
        request.addAliasAction(IndicesAliasesRequest.AliasActions.add().index("foo").alias("alias"));
                            Locale.ROOT,
 *  
import java.util.List;
import org.opensearch.core.index.Index;
            Function.identity(),
        final Exception e = expectThrows(IllegalStateException.class, () -> client().admin().indices().aliases(request).actionGet());
import org.opensearch.cluster.metadata.AliasMetadata;
    public void testAllowed() {
    }
 *
            });
                for (final Index index : indices) {  
    }
        final List<AliasMetadata> aliasMetadata = response.getAliases().get("index");
        @Override
        }
                            request.origin(),  
    }
                        return Optional.of(new IllegalStateException(message));  
        final Exception e = expectThrows(IllegalStateException.class, () -> client().admin().indices().aliases(request).actionGet());
        final String origin = randomFrom("foo_allowed", "bar_allowed");  
import java.util.function.Function;
            .build();
        final IndicesAliasesRequest request = new IndicesAliasesRequest().origin("allowed");
        final String origin = randomFrom("", "not-allowed");
        assertAcked(client().admin().indices().aliases(request).actionGet());  
        createIndex("index", settings);  
        assertThat(response.getAliases().keySet().size(), equalTo(1));
            .putList(IndicesAliasesPlugin.ALLOWED_ORIGINS_SETTING.getKey(), Collections.singletonList("bar_allowed"))  
import org.opensearch.action.RequestValidators;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequest;
        createIndex("index", settings);
                        final String message = String.format(  
                            "origin [%s] not allowed for index [%s]",
        request.addAliasAction(IndicesAliasesRequest.AliasActions.add().index("index").alias("alias"));
    public void testNotAllowed() {  
            .build();  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
import static org.hamcrest.Matchers.hasToString;
    }  
 */  
                    final List<String> allowedOrigins = ALLOWED_ORIGINS_SETTING.get(state.metadata().index(index).getSettings());
        assertThat(e, hasToString(containsString("origin [" + origin + "] not allowed for index [" + index + "]")));  
        assertThat(aliasMetadata.get(0).alias(), equalTo("alias"));  
import java.util.Locale;  
                    }
        assertThat(aliasMetadata, hasSize(1));
        return Collections.singletonList(IndicesAliasesPlugin.class);
        public Collection<RequestValidators.RequestValidator<IndicesAliasesRequest>> indicesAliasesRequestValidators() {
        @Override  
    }
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
