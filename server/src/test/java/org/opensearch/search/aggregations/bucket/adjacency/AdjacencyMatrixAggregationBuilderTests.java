 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
        for (int i = 0; i < 2; i++) {
        assertThat(factory instanceof AdjacencyMatrixAggregatorFactory, is(true));
        Settings settings = Settings.builder()
import org.opensearch.test.OpenSearchTestCase;
/*
        }
/*  
        Map<String, QueryBuilder> filters = new HashMap<>(3);
 * GitHub history for details.
import org.opensearch.test.TestSearchContext;  
        SearchContext context = new TestSearchContext(queryShardContext, indexShard);  
            "[index.max_adjacency_matrix_filters] setting was deprecated in OpenSearch and will be "
/*  
import org.opensearch.index.query.QueryBuilder;
        AdjacencyMatrixAggregationBuilder builder = new AdjacencyMatrixAggregationBuilder("dummy", filters, true);
        assertThat(
        when(indexShard.indexSettings()).thenReturn(indexSettings);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)  
import org.opensearch.search.internal.SearchContext;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        AggregatorFactory factory = aggregationBuilder.doBuild(context.getQueryShardContext(), null, new AggregatorFactories.Builder());
import static org.mockito.Mockito.mock;
 * compatible open source license.
        for (int i = 0; i < 3; i++) {  
            when(queryBuilder.rewrite(queryShardContext)).thenReturn(queryBuilder);
public class AdjacencyMatrixAggregationBuilderTests extends OpenSearchTestCase {
        IndexMetadata indexMetadata = IndexMetadata.builder("index").settings(settings).build();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
 *  
        // filter size not greater than max size should return an instance of AdjacencyMatrixAggregatorFactory  
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);  
import org.opensearch.index.shard.IndexShard;
        }
import org.opensearch.search.aggregations.AggregatorFactory;  
            .put("index.max_adjacency_matrix_filters", 2)  
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
import java.util.Collections;
            IllegalArgumentException.class,
            QueryBuilder queryBuilder = mock(QueryBuilder.class);  
    }
 * under the License.  
            // return builder itself to skip rewrite
        );
 *
import static org.hamcrest.Matchers.is;
        IllegalArgumentException ex = expectThrows(
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.AggregatorFactories;
        IndexShard indexShard = mock(IndexShard.class);
import java.util.Map;
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
        assertFalse(builder.isShowOnlyIntersecting());  
            () -> builder.doBuild(context.getQueryShardContext(), null, new AggregatorFactories.Builder())  
import org.opensearch.index.query.QueryShardContext;  
            filters.put("filter" + i, queryBuilder);
import org.opensearch.common.settings.Settings;  
 * Licensed to Elasticsearch under one or more contributor  
        Map<String, QueryBuilder> filters = new HashMap<>(3);
import org.opensearch.index.IndexSettings;
    public void testFilterSizeLimitation() throws Exception {
        );
        AdjacencyMatrixAggregationBuilder builder = new AdjacencyMatrixAggregationBuilder("dummy", filters);  
import java.util.HashMap;  
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
            equalTo(
    public void testShowOnlyIntersecting() throws Exception {
    }
            // return builder itself to skip rewrite
import static org.mockito.Mockito.when;  
        assertWarnings(
            .build();
 */
            QueryBuilder queryBuilder = mock(QueryBuilder.class);
import org.opensearch.cluster.metadata.IndexMetadata;
            when(queryBuilder.rewrite(queryShardContext)).thenReturn(queryBuilder);  
 * the Apache License, Version 2.0 (the "License"); you may
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertTrue(builder.isShowOnlyIntersecting());  
        );
        builder = new AdjacencyMatrixAggregationBuilder("dummy", filters, false);
}
 * license agreements. See the NOTICE file distributed with
        QueryShardContext queryShardContext = mock(QueryShardContext.class);  
                + "removed in a future release! See the breaking changes documentation for the next major version."  
            filters.put("filter" + i, queryBuilder);  
 * specific language governing permissions and limitations
package org.opensearch.search.aggregations.bucket.adjacency;
 *
 */  
import static org.hamcrest.Matchers.equalTo;  
            ex.getMessage(),  
        // filter size grater than max size should throw an exception
import org.opensearch.Version;
        Map<String, QueryBuilder> emptyFilters = Collections.emptyMap();
                    + "] index level setting."
 * KIND, either express or implied.  See the License for the
        AdjacencyMatrixAggregationBuilder aggregationBuilder = new AdjacencyMatrixAggregationBuilder("dummy", emptyFilters);  
            )  
 * this work for additional information regarding copyright
                    + "This limit can be set by changing the ["  
        assertThat(factory.name(), equalTo("dummy"));  
 * this file be licensed under the Apache-2.0 license or a
                "Number of filters is too large, must be less than or equal to: [2] but was [3]."
 */  
        when(queryShardContext.getIndexSettings()).thenReturn(indexSettings);
                    + IndexSettings.MAX_ADJACENCY_MATRIX_FILTERS_SETTING.getKey()
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
