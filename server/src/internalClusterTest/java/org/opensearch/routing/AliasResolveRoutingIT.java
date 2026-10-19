        );
                    newSet("0", "1", "2", "tw ", " ltw ", " lw")  
        );
    }
        assertThat(indexNameExpressionResolver.resolveSearchRouting(state, "0,1", "alias"), equalTo(newMap("test1", newSet("0", "1"))));  
        }  
        return r;
        assertThat(indexNameExpressionResolver.resolveSearchRouting(state, null, "alias10"), equalTo(newMap("test1", newSet("0"))));
        indexRandom(
        r.put(key1, value1);  
            client().prepareIndex("test-0").setId("1").setSource("field1", "the quick brown fox jumps"),  
                .setQuery(queryStringQuery("quick"))  
        assertThat(indexNameExpressionResolver.resolveSearchRouting(state, null, "alias"), nullValue());
 * KIND, either express or implied.  See the License for the
        );
                )  
        assertThat(  
        assertThat(
public class AliasResolveRoutingIT extends OpenSearchIntegTestCase {
        );  
        r.put(key3, value3);
                    newSet("0", "1", "2", "tw ", " ltw ", " lw"),
 * Modifications Copyright OpenSearch Contributors. See
        try {
        Map<K, V> r = new HashMap<>();
        createIndex("test1");
            indexNameExpressionResolver.resolveSearchRouting(state, "tw , ltw , lw", "alias3tw"),
                .setIndices("alias-*")
        ensureGreen();
import static org.hamcrest.Matchers.nullValue;
        );
        assertThat(clusterService().state().metadata().resolveIndexRouting("0", "alias10"), equalTo("0"));
            equalTo(newMap("test1", newSet("tw ", " ltw ", " lw")))
 * Licensed to Elasticsearch under one or more contributor  
            equalTo(newMap("test1", newSet("0"), "test2", newSet("1")))
        );
/*  
        );
            indexNameExpressionResolver.resolveSearchRouting(state, "0,1", new String[] { "alias10", "alias20" }),  
            )
        );  
            equalTo(newMap("test3", newSet(" ltw ")))
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().execute().actionGet();  
                    newSet("0", "1", "2", "tw ", " ltw ", " lw"),
        );
        assertThat(
import java.util.Set;
        } catch (IllegalArgumentException e) {
    public void testSearchClosedWildcardIndex() throws ExecutionException, InterruptedException {
import java.util.concurrent.ExecutionException;
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
            client().prepareIndex("test-0").setId("3").setSource("field1", "quick")
    public void testResolveSearchRouting() {
 * specific language governing permissions and limitations
            .get();
                    "test2",  
    }  
            equalTo(newMap("test1", newSet("0"), "test2", newSet("0")))
        assertThat(indexNameExpressionResolver.resolveSearchRouting(state, "1", new String[] { "alias10", "alias20" }), nullValue());  
                    "test3",
        return newHashSet(elements);  
            equalTo(newMap("test1", newSet("0", "1", "2"), "test2", newSet("1")))  
        r.put(key1, value1);
        return r;  
        client().admin().indices().prepareClose("test-1").get();  
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
            .prepareAliases()
            equalTo(newMap("test1", newSet("0"), "test2", newSet("0")))  
        );  
        }
 * ownership. Elasticsearch licenses this file to you under  
                    newSet("0", "1", "2", "tw ", " ltw ", " lw"),  
            .addAliasAction(AliasActions.add().index("test2").alias("alias21").routing("1"))
        createIndex("test-0");
            .addAliasAction(AliasActions.add().index("test2").alias("alias0").routing("0"))  
            // Expected  
        ClusterState state = clusterService().state();  
        assertThat(
        createIndex("test1");
        assertThat(indexNameExpressionResolver.resolveSearchRouting(state, null, new String[] { "test1", "alias10" }), nullValue());
        assertThat(
        refresh("test-*");
package org.opensearch.routing;
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
            indexNameExpressionResolver.resolveSearchRouting(state, "0", new String[] { "alias10", "alias21" }),
                    newSet("0", "1", "2", "tw ", " ltw ", " lw")
 */  
 * You may obtain a copy of the License at  
                newMap(  
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().execute().actionGet();
        createIndex("test-1");  
            .addAliasAction(AliasActions.add().index("test1").alias("alias0").routing("0"))
            true,
 * The OpenSearch Contributors require contributions made to  
                    "test3",
        r.put(key2, value2);  
            .get();
        assertThat(
        assertThat(indexNameExpressionResolver.resolveSearchRouting(state, null, "alias10"), equalTo(newMap("test1", newSet("0"))));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
        );
            indexNameExpressionResolver.resolveSearchRouting(state, null, new String[] { "alias20", "alias21" }),
            .addAliasAction(AliasActions.add().index("test1").alias("alias12").routing("2"))
            indexNameExpressionResolver.resolveSearchRouting(state, "tw , ltw , lw", "alias3lw"),
            indexNameExpressionResolver.resolveSearchRouting(state, null, new String[] { "alias10", "alias20" }),
        );
    private <K, V> Map<K, V> newMap(K key, V value) {  
 *
                .setIndicesOptions(IndicesOptions.lenientExpandOpen())
            indexNameExpressionResolver.resolveSearchRouting(state, "tw , ltw , lw", "alias3ltw"),  
 *  
        client().admin()
 *
            .addAliasAction(AliasActions.add().index("test2").alias("alias20").routing("0"))  
        assertThat(  
        return r;  
            fail("should fail");
            .addAliasAction(AliasActions.add().index("test1").alias("alias"))
 * SPDX-License-Identifier: Apache-2.0
            equalTo(
        assertThat(clusterService().state().metadata().resolveIndexRouting("3", "test1"), equalTo("3"));
            equalTo(newMap("test2", newSet("0", "1")))
        assertThat(indexNameExpressionResolver.resolveSearchRouting(state, null, new String[] { "alias10", "test1" }), nullValue());
            .indices()
    private <T> Set<T> newSet(T... elements) {
import org.opensearch.common.Priority;
        Map<K, V> r = new HashMap<>();
/*  
        );  
    }
    }
        assertThat(  
            equalTo(newMap("test1", newSet("0", "tw ", " ltw ", " lw"), "test3", newSet(" ltw ")))  
                    newSet("0", "1", "2", "tw ", " ltw ", " lw"),
            clusterService().state().metadata().resolveIndexRouting("1", "alias10");
        assertThat(indexNameExpressionResolver.resolveSearchRouting(state, "0", "alias10"), equalTo(newMap("test1", newSet("0"))));  
        } catch (IllegalArgumentException ex) {
        assertThat(
            .addAliasAction(AliasActions.add().index("test1").alias("alias0").routing("0"))
/*
            client().prepareIndex("test-0").setId("2").setSource("field1", "quick brown"),
 * the Apache License, Version 2.0 (the "License"); you may
        );
            .addAliasAction(AliasActions.add().index("test3").alias("alias3ltw").routing(" ltw "))
        assertThat(clusterService().state().metadata().resolveIndexRouting(null, "alias21"), equalTo("1"));  
    // see https://github.com/elastic/elasticsearch/issues/13278  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(
        createIndex("test2");  
import org.opensearch.cluster.ClusterState;  
            .addAliasAction(AliasActions.add().index("test1").alias("alias10").routing("0"))
        );  
            indexNameExpressionResolver.resolveSearchRouting(state, "0,1,2", new String[] { "test1", "alias10", "alias21" }),
        assertThat(
                )
            indexNameExpressionResolver.resolveSearchRouting(state, null, "alias0"),  
        assertThat(
            .addAliasAction(AliasActions.add().index("test2").alias("alias0").routing("0"))  
import org.opensearch.action.support.IndicesOptions;
            .addAliasAction(AliasActions.add().index("test3").alias("alias3lw").routing(" lw"))  
            .indices()  
            client().prepareSearch()  
            .addAliasAction(AliasActions.add().index("test1").alias("alias"))
                newMap(
 * not use this file except in compliance with the License.
        client().admin().indices().prepareAliases().addAlias("test-0", "alias-0").addAlias("test-1", "alias-1").get();
 * software distributed under the License is distributed on an
    }
                    "test2",
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        assertThat(clusterService().state().metadata().resolveIndexRouting(null, "alias"), nullValue());
        assertThat(
        assertThat(clusterService().state().metadata().resolveIndexRouting(null, "test1"), nullValue());  
        try {
                .get(),
    private <K, V> Map<K, V> newMap(K key1, V value1, K key2, V value2) {  
            equalTo(newMap("test1", newSet("0")))  
            indexNameExpressionResolver.resolveSearchRouting(state, "0,tw , ltw , lw", "test1", "alias3ltw"),
            equalTo(newMap("test3", newSet(" lw")))
import java.util.Map;  
import java.util.HashMap;
            equalTo(
    private <K, V> Map<K, V> newMap(K key1, V value1, K key2, V value2, K key3, V value3) {
            indexNameExpressionResolver.resolveSearchRouting(state, "0,1,2", new String[] { "alias10", "alias21" }),
            .addAliasAction(AliasActions.add().index("test1").alias("alias10").routing("0"))  
            indexNameExpressionResolver.resolveSearchRouting(state, "0", new String[] { "alias10", "alias20" }),
            .addAliasAction(AliasActions.add().index("test2").alias("alias21").routing("1"))
        );  
            equalTo(newMap("test1", newSet("0"), "test2", newSet("0")))  
            .addAliasAction(AliasActions.add().index("test1").alias("alias110").searchRouting("1,0"))
}  
 * under the License.  
        assertThat(indexNameExpressionResolver.resolveSearchRouting(state, "1", "alias10"), nullValue());
            indexNameExpressionResolver.resolveSearchRoutingAllIndices(state.metadata(), "0,1,2,tw , ltw , lw"),  
            indexNameExpressionResolver.resolveSearchRouting(state, "tw , ltw , lw", "test1"),
            .prepareAliases()  
        r.put(key2, value2);
            equalTo(newMap("test3", newSet("tw ")))  
        );  
import org.opensearch.test.OpenSearchIntegTestCase;  
import static org.opensearch.common.util.set.Sets.newHashSet;
        r.put(key, value);
        );
            // all is well, we can't have two mappings, one provided, and one in the alias
 * license agreements. See the NOTICE file distributed with
        createIndex("test3");
    }
import static org.hamcrest.Matchers.equalTo;
            indexNameExpressionResolver.resolveSearchRouting(state, "0,1,2,tw , ltw , lw", (String[]) null),
 *    http://www.apache.org/licenses/LICENSE-2.0
            indexNameExpressionResolver.resolveSearchRouting(state, "1", new String[] { "alias10", "alias21" }),  
        assertThat(  
    public void testResolveIndexRouting() {  
        assertHitCount(
 */
        assertThat(clusterService().state().metadata().resolveIndexRouting(null, "test1"), nullValue());  
        createIndex("test2");
 * GitHub history for details.
        assertThat(
        assertThat(
            3L
        assertThat(  
        );
            equalTo(newMap("test1", newSet("0"), "test2", newSet("1")))
            equalTo(newMap("test1", newSet("0"), "test2", newSet("0")))
        Map<K, V> r = new HashMap<>();
            indexNameExpressionResolver.resolveSearchRouting(state, null, new String[] { "alias10", "alias21" }),  
            equalTo(newMap("test2", newSet("1")))
        client().admin()
    }
            .addAliasAction(AliasActions.add().index("test3").alias("alias3tw").routing("tw "))
 */  
                    "test1",  
            clusterService().state().metadata().resolveIndexRouting(null, "alias0");  
            fail("should fail");  
        assertThat(clusterService().state().metadata().resolveIndexRouting(null, "alias20"), equalTo("0"));
            )
            .addAliasAction(AliasActions.add().index("test2").alias("alias20").routing("0"))  
        IndexNameExpressionResolver indexNameExpressionResolver = internalCluster().getInstance(IndexNameExpressionResolver.class);
                    "test1",
        assertThat(clusterService().state().metadata().resolveIndexRouting(null, "alias10"), equalTo("0"));
