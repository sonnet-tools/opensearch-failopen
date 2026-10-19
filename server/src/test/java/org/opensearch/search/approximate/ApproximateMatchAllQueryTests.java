        MappedFieldType myFieldType = new NumberFieldMapper.NumberFieldType(sortfield, NumberFieldMapper.NumberType.LONG);
/*  
            0,
            null,  
        String sortfield = "myfield";
        MapperService mockMapper = mock(MapperService.class);
 * The OpenSearch Contributors require contributions made to  
    }
            null,  
            null,
        assertTrue(approximateMatchAllQuery.canApproximate(searchContext));
        SearchSourceBuilder source = new SearchSourceBuilder();  
        searchContext.aggregations(null);
            null,
import org.opensearch.search.sort.SortOrder;
        assertFalse(approximateMatchAllQuery.canApproximate(searchContext));
            mockMapper,
        QueryShardContext queryShardContext = new QueryShardContext(  
import org.opensearch.index.IndexSettings;
        when(mockMapper.fieldType(sortfield)).thenReturn(myFieldType);
        );
            null,
        Settings settings = Settings.builder()
            null,
            null,
        assertTrue(approximateMatchAllQuery.canApproximate(searchContext));
        searchContext.aggregations(new SearchContextAggregations(new AggregatorFactories.Builder().build(null, null), null));  
import org.opensearch.test.OpenSearchTestCase;
            null,
        searchContext.trackTotalHitsUpTo(SearchContext.TRACK_TOTAL_HITS_ACCURATE);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
 */  
        IndexMetadata indexMetadata = new IndexMetadata.Builder("index").settings(settings).build();  
            null,
        ShardSearchRequest[] shardSearchRequest = new ShardSearchRequest[1];  
        MappedFieldType myFieldType = new NumberFieldMapper.NumberFieldType(sortfield, NumberFieldMapper.NumberType.LONG);  
 *
import org.opensearch.test.TestSearchContext;  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            mockMapper,  
    public void testCanApproximate() throws IOException {  
        // Fail on missing ShardSearchRequest
            null  
            null,
            null,  
        };  
 * this file be licensed under the Apache-2.0 license or a
        assertFalse(approximateMatchAllQuery.canApproximate(null));  
        QueryShardContext queryShardContext = new QueryShardContext(
import org.opensearch.cluster.metadata.IndexMetadata;
        assertFalse("Should not approximate when track_total_hits is accurate", approximateMatchAllQuery.canApproximate(searchContext));
        String sortfield = "myfield";  
        TestSearchContext searchContext = new TestSearchContext(queryShardContext) {
        shardSearchRequest[0].source(source);
        shardSearchRequest[0] = new ShardSearchRequest(null, System.currentTimeMillis(), null);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
                return shardSearchRequest[0];
        shardSearchRequest[0].source(source);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // Fail if source does not have a sort.
        // But not if the sort field makes a decision about missing data
import org.opensearch.search.builder.SearchSourceBuilder;  
import org.opensearch.search.aggregations.AggregatorFactories;
            .build();
        source.sorts().clear();  
        // Fail if aggregations are present
            .build();
        };
        MapperService mockMapper = mock(MapperService.class);
            null,
        source.sort(new FieldSortBuilder(sortfield).missing("foo"));
        ApproximateMatchAllQuery approximateMatchAllQuery = new ApproximateMatchAllQuery();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.index.mapper.NumberFieldMapper;
            null,  
            0,
        // Fail on null searchContext
            null,
            null
                return shardSearchRequest[0];
    }  
            BigArrays.NON_RECYCLING_INSTANCE,  
import static org.mockito.Mockito.when;
            null,  
            new IndexSettings(indexMetadata, settings),
            null,
import org.opensearch.search.internal.SearchContext;
            null,  
import org.opensearch.index.mapper.MappedFieldType;  
import org.opensearch.search.aggregations.SearchContextAggregations;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
import java.io.IOException;
        // Fail if source is null or empty
    public void testCannotApproximateWithTrackTotalHits() {  
            public ShardSearchRequest request() {
import org.opensearch.Version;
}
        searchContext.trackTotalHitsUpTo(SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO);
        assertTrue("Should approximate when track_total_hits is not accurate", approximateMatchAllQuery.canApproximate(searchContext));
            null,
public class ApproximateMatchAllQueryTests extends OpenSearchTestCase {
        source.sort(sortfield, SortOrder.ASC);  
            public ShardSearchRequest request() {  
        when(mockMapper.fieldType(sortfield)).thenReturn(myFieldType);
            null,
            }  
            null,
            null,
        assertFalse(approximateMatchAllQuery.canApproximate(searchContext));  
import static org.mockito.Mockito.mock;
        shardSearchRequest[0] = new ShardSearchRequest(null, System.currentTimeMillis(), null);
            null,
        Settings settings = Settings.builder()  
        IndexMetadata indexMetadata = new IndexMetadata.Builder("index").settings(settings).build();
            @Override
        assertFalse(approximateMatchAllQuery.canApproximate(searchContext));
import org.opensearch.index.query.QueryShardContext;  
        source.sort(sortfield, SortOrder.ASC);
            BigArrays.NON_RECYCLING_INSTANCE,
import org.opensearch.common.settings.Settings;  
        );  
            new IndexSettings(indexMetadata, settings),  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.sort.FieldSortBuilder;  
        assertFalse(approximateMatchAllQuery.canApproximate(searchContext));
        assertTrue(approximateMatchAllQuery.rewrite(null) instanceof ApproximatePointRangeQuery);  
package org.opensearch.search.approximate;
import org.opensearch.index.mapper.MapperService;
        SearchSourceBuilder source = new SearchSourceBuilder();  
import org.opensearch.search.internal.ShardSearchRequest;
            null,  
        TestSearchContext searchContext = new TestSearchContext(queryShardContext) {
            }
        assertFalse(approximateMatchAllQuery.canApproximate(searchContext));
 * compatible open source license.
        ShardSearchRequest[] shardSearchRequest = new ShardSearchRequest[1];
            null,
        assertThrows(IllegalStateException.class, () -> approximateMatchAllQuery.rewrite(null));  
import org.opensearch.common.util.BigArrays;
        ApproximateMatchAllQuery approximateMatchAllQuery = new ApproximateMatchAllQuery();
            @Override  
