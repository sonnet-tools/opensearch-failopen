            .addAliasAction(AliasActions.add().index("test2").alias("alias21").routing("1"))
        client().admin().indices().prepareAliases().addAlias("test-0", "alias-0").addAlias("test-1", "alias-1").get();
                .setQuery(queryStringQuery("quick"))
        assertThat(indexNameExpressionResolver.resolveSearchRouting(state, "1", "alias10"), nullValue());
 * license agreements. See the NOTICE file distributed with
        assertThat(indexNameExpressionResolver.resolveSearchRouting(state, "1", new String[] { "alias10", "alias20" }), nullValue());
        try {
        ensureGreen();
import org.opensearch.cluster.ClusterState;
import org.opensearch.test.OpenSearchIntegTestCase;
import java.util.concurrent.ExecutionException;
        try {
 */
 *
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
        r.put(key2, value2);
        client().admin()
        Map<K, V> r = new HashMap<>();
    }
        assertThat(
            .addAliasAction(AliasActions.add().index("test1").alias("alias12").routing("2"))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            fail("should fail");
        assertThat(clusterService().state().metadata().resolveIndexRouting(null, "alias10"), equalTo("0"));
        );
        }
import java.util.Map;
 * specific language governing permissions and limitations
            equalTo(
    }
            equalTo(newMap("test1", newSet("0"), "test2", newSet("0")))
 * this work for additional information regarding copyright
            indexNameExpressionResolver.resolveSearchRouting(state, null, "alias0"),
        assertThat(
 * software distributed under the License is distributed on an
                    newSet("0", "1", "2", "tw ", " ltw ", " lw"),
        assertThat(clusterService().state().metadata().resolveIndexRouting(null, "alias21"), equalTo("1"));
            .addAliasAction(AliasActions.add().index("test1").alias("alias10").routing("0"))
        );
        createIndex("test3");
        );
        assertThat(
            // all is well, we can't have two mappings, one provided, and one in the alias
        assertThat(
 * You may obtain a copy of the License at
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        return r;
            clusterService().state().metadata().resolveIndexRouting("1", "alias10");
        }
                    "test1",
            equalTo(newMap("test3", newSet(" lw")))
        );
        assertThat(
        assertThat(indexNameExpressionResolver.resolveSearchRouting(state, "0", "alias10"), equalTo(newMap("test1", newSet("0"))));
        r.put(key, value);
            equalTo(newMap("test1", newSet("0"), "test2", newSet("0")))
            3L
            fail("should fail");
    public void testResolveIndexRouting() {
        assertThat(
        );
        assertThat(indexNameExpressionResolver.resolveSearchRouting(state, "0,1", "alias"), equalTo(newMap("test1", newSet("0", "1"))));
}
        assertThat(
            equalTo(newMap("test2", newSet("1")))
 * GitHub history for details.
        Map<K, V> r = new HashMap<>();
        } catch (IllegalArgumentException ex) {
            .addAliasAction(AliasActions.add().index("test1").alias("alias"))
 * The OpenSearch Contributors require contributions made to
            .prepareAliases()
 *
                )
package org.opensearch.routing;
    }
            .addAliasAction(AliasActions.add().index("test1").alias("alias0").routing("0"))
            .addAliasAction(AliasActions.add().index("test1").alias("alias10").routing("0"))
            indexNameExpressionResolver.resolveSearchRouting(state, "0,1,2,tw , ltw , lw", (String[]) null),
        assertThat(indexNameExpressionResolver.resolveSearchRouting(state, null, new String[] { "test1", "alias10" }), nullValue());
            equalTo(newMap("test1", newSet("tw ", " ltw ", " lw")))
                newMap(
                    newSet("0", "1", "2", "tw ", " ltw ", " lw")
                    "test3",
            indexNameExpressionResolver.resolveSearchRouting(state, "tw , ltw , lw", "alias3tw"),
        IndexNameExpressionResolver indexNameExpressionResolver = internalCluster().getInstance(IndexNameExpressionResolver.class);
        client().admin().indices().prepareClose("test-1").get();
            equalTo(newMap("test1", newSet("0"), "test2", newSet("0")))
 * ownership. Elasticsearch licenses this file to you under
        createIndex("test2");
            indexNameExpressionResolver.resolveSearchRouting(state, "0,1", new String[] { "alias10", "alias20" }),
        assertThat(clusterService().state().metadata().resolveIndexRouting(null, "alias"), nullValue());
 * the Apache License, Version 2.0 (the "License"); you may
            clusterService().state().metadata().resolveIndexRouting(null, "alias0");
            indexNameExpressionResolver.resolveSearchRouting(state, "0,1,2", new String[] { "alias10", "alias21" }),
                    "test3",
    }
            indexNameExpressionResolver.resolveSearchRoutingAllIndices(state.metadata(), "0,1,2,tw , ltw , lw"),
            .indices()
        return r;
        );
        assertThat(indexNameExpressionResolver.resolveSearchRouting(state, null, "alias10"), equalTo(newMap("test1", newSet("0"))));
 *
            client().prepareSearch()
    private <K, V> Map<K, V> newMap(K key, V value) {
 * under the License.
    public void testResolveSearchRouting() {
import java.util.HashMap;
                    newSet("0", "1", "2", "tw ", " ltw ", " lw"),
 * KIND, either express or implied.  See the License for the
            indexNameExpressionResolver.resolveSearchRouting(state, "0,1,2", new String[] { "test1", "alias10", "alias21" }),
            equalTo(newMap("test2", newSet("0", "1")))
        createIndex("test2");
            .addAliasAction(AliasActions.add().index("test2").alias("alias21").routing("1"))
 */
 * this file be licensed under the Apache-2.0 license or a
                )
            indexNameExpressionResolver.resolveSearchRouting(state, null, new String[] { "alias10", "alias20" }),
        );
            .addAliasAction(AliasActions.add().index("test2").alias("alias0").routing("0"))
 * Licensed to Elasticsearch under one or more contributor
        return newHashSet(elements);
            client().prepareIndex("test-0").setId("3").setSource("field1", "quick")
import org.opensearch.action.support.IndicesOptions;
            equalTo(newMap("test1", newSet("0"), "test2", newSet("1")))
        client().admin()
            .addAliasAction(AliasActions.add().index("test3").alias("alias3ltw").routing(" ltw "))
                    newSet("0", "1", "2", "tw ", " ltw ", " lw")
        assertThat(
        assertThat(
 * SPDX-License-Identifier: Apache-2.0
                newMap(
        indexRandom(
            indexNameExpressionResolver.resolveSearchRouting(state, "0", new String[] { "alias10", "alias21" }),
    // see https://github.com/elastic/elasticsearch/issues/13278
        assertThat(
import static org.hamcrest.Matchers.nullValue;
            )
            .get();
            equalTo(
        } catch (IllegalArgumentException e) {
    private <T> Set<T> newSet(T... elements) {
            .addAliasAction(AliasActions.add().index("test3").alias("alias3lw").routing(" lw"))
        assertThat(indexNameExpressionResolver.resolveSearchRouting(state, null, "alias"), nullValue());
/*
        assertThat(
public class AliasResolveRoutingIT extends OpenSearchIntegTestCase {
        assertThat(
    private <K, V> Map<K, V> newMap(K key1, V value1, K key2, V value2, K key3, V value3) {
        );
        assertThat(indexNameExpressionResolver.resolveSearchRouting(state, null, "alias10"), equalTo(newMap("test1", newSet("0"))));
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().execute().actionGet();
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
        assertThat(clusterService().state().metadata().resolveIndexRouting("3", "test1"), equalTo("3"));
                    "test2",
            true,
 * compatible open source license.
            .addAliasAction(AliasActions.add().index("test1").alias("alias"))
            indexNameExpressionResolver.resolveSearchRouting(state, "tw , ltw , lw", "alias3ltw"),
        createIndex("test-0");
 * not use this file except in compliance with the License.
        );
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        assertThat(
            indexNameExpressionResolver.resolveSearchRouting(state, "1", new String[] { "alias10", "alias21" }),
        assertHitCount(
            indexNameExpressionResolver.resolveSearchRouting(state, null, new String[] { "alias10", "alias21" }),
            .get();
    }
        assertThat(
        createIndex("test1");
/*
import static org.hamcrest.Matchers.equalTo;
            .addAliasAction(AliasActions.add().index("test2").alias("alias20").routing("0"))
                .setIndices("alias-*")
import java.util.Set;
        assertThat(
        );
 */
        assertThat(clusterService().state().metadata().resolveIndexRouting("0", "alias10"), equalTo("0"));
        Map<K, V> r = new HashMap<>();
            client().prepareIndex("test-0").setId("1").setSource("field1", "the quick brown fox jumps"),
            .addAliasAction(AliasActions.add().index("test1").alias("alias110").searchRouting("1,0"))
        );
            // Expected
            equalTo(newMap("test3", newSet("tw ")))
        );
    private <K, V> Map<K, V> newMap(K key1, V value1, K key2, V value2) {
        assertThat(clusterService().state().metadata().resolveIndexRouting(null, "test1"), nullValue());
            .addAliasAction(AliasActions.add().index("test3").alias("alias3tw").routing("tw "))
            .addAliasAction(AliasActions.add().index("test2").alias("alias0").routing("0"))
        );
        r.put(key1, value1);
            equalTo(newMap("test3", newSet(" ltw ")))
        assertThat(
            .addAliasAction(AliasActions.add().index("test1").alias("alias0").routing("0"))
        createIndex("test1");
            )
            indexNameExpressionResolver.resolveSearchRouting(state, "tw , ltw , lw", "test1"),
            .addAliasAction(AliasActions.add().index("test2").alias("alias20").routing("0"))
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().execute().actionGet();
            equalTo(newMap("test1", newSet("0"), "test2", newSet("0")))
            equalTo(newMap("test1", newSet("0"), "test2", newSet("1")))
        assertThat(clusterService().state().metadata().resolveIndexRouting(null, "alias20"), equalTo("0"));
        assertThat(clusterService().state().metadata().resolveIndexRouting(null, "test1"), nullValue());
            equalTo(newMap("test1", newSet("0", "1", "2"), "test2", newSet("1")))
    }
        refresh("test-*");
        );
/*
                    newSet("0", "1", "2", "tw ", " ltw ", " lw"),
            indexNameExpressionResolver.resolveSearchRouting(state, null, new String[] { "alias20", "alias21" }),
                .setIndicesOptions(IndicesOptions.lenientExpandOpen())
            indexNameExpressionResolver.resolveSearchRouting(state, "0,tw , ltw , lw", "test1", "alias3ltw"),
        );
                .get(),
            equalTo(newMap("test1", newSet("0")))
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
        );
    }
        r.put(key2, value2);
            .prepareAliases()
        );
                    "test2",
            client().prepareIndex("test-0").setId("2").setSource("field1", "quick brown"),
import org.opensearch.common.Priority;
            equalTo(newMap("test1", newSet("0", "tw ", " ltw ", " lw"), "test3", newSet(" ltw ")))
        assertThat(indexNameExpressionResolver.resolveSearchRouting(state, null, new String[] { "alias10", "test1" }), nullValue());
        );
                    newSet("0", "1", "2", "tw ", " ltw ", " lw"),
            indexNameExpressionResolver.resolveSearchRouting(state, "0", new String[] { "alias10", "alias20" }),
 * Modifications Copyright OpenSearch Contributors. See
        createIndex("test-1");
 * Unless required by applicable law or agreed to in writing,
            .indices()
        ClusterState state = clusterService().state();
        r.put(key3, value3);
    public void testSearchClosedWildcardIndex() throws ExecutionException, InterruptedException {
        return r;
        r.put(key1, value1);
            indexNameExpressionResolver.resolveSearchRouting(state, "tw , ltw , lw", "alias3lw"),
        assertThat(
                    "test1",
import static org.opensearch.common.util.set.Sets.newHashSet;
