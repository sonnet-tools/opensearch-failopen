import org.opensearch.index.query.RangeQueryBuilder;
/*  
                return null; // Indicates Aggregators to fallback to default implementation.  
            DimensionFilterMapper dimensionFilterMapper = mappedFieldType == null
        private static final Map<String, StarTreeFilterProvider> QUERY_BUILDERS_TO_STF_PROVIDER = Map.of(
            BoolQueryBuilder.NAME,
            throws IOException {
 *
            if (matchedDimension == null || mappedFieldType == null || dimensionFilterMapper == null) {
            if (dimensionFilter == null) {
 * for the fields provided in the user query.
                ? DimensionFilterMapper.Factory.fromMappedFieldType(mappedFieldType, context)
 * Converts a {@link QueryBuilder} into a {@link StarTreeFilter} by generating the appropriate @{@link DimensionFilter}
            return (dimensionFilter == null) ? null : new StarTreeFilter(Map.of(field, List.of(dimensionFilter)));
        @Override
            StarTreeRangeQuery rangeQuery = new StarTreeRangeQuery(rawFilter);  
            }  
import org.opensearch.index.query.MatchAllQueryBuilder;  
            DimensionFilterMapper dimensionFilterMapper = mappedFieldType != null
            RangeQueryBuilder.NAME,
     * @param rawFilter:
            MappedFieldType mappedFieldType = context.mapperService().fieldType(field);  
        @Override  
     * @param context:  
            if (matchedDimension == null || mappedFieldType == null || dimensionFilterMapper == null) {
            }
    }
import org.opensearch.search.internal.SearchContext;
            return MATCH_ALL_PROVIDER;  
import java.io.IOException;
            TermQueryBuilder termQueryBuilder = (TermQueryBuilder) rawFilter;  
 */  
import java.util.Collections;
     * Converts @{@link TermsQueryBuilder} into @{@link org.opensearch.search.startree.filter.ExactMatchDimFilter}
     * Returns the {@link StarTreeFilter} generated from the {@link QueryBuilder}
                ? null
            if (matchedDimension == null || mappedFieldType == null || dimensionFilterMapper == null) {
import org.opensearch.search.startree.filter.DimensionFilter;
    class SingletonFactory {
     */
    /**
        public static StarTreeFilterProvider getProvider(QueryBuilder query) {
    class TermsStarTreeFilterProvider implements StarTreeFilterProvider {  
            DimensionFilterMapper dimensionFilterMapper = mappedFieldType != null  
            TermsQueryBuilder termsQueryBuilder = (TermsQueryBuilder) rawFilter;
    /**
import org.opensearch.index.query.TermQueryBuilder;  
            new BoolStarTreeFilterProvider()
        @Override  
import org.opensearch.search.startree.filter.StarTreeFilter;
import java.util.List;  
}
import org.opensearch.index.query.BoolQueryBuilder;
            return new StarTreeFilter(Map.of(field, List.of(dimensionFilter)));
    class RangeStarTreeFilterProvider implements StarTreeFilterProvider {
            Dimension matchedDimension = StarTreeQueryHelper.getMatchingDimensionOrNull(field, compositeFieldType.getDimensions());  
import org.opensearch.index.query.QueryBuilder;
        public StarTreeFilter getFilter(SearchContext context, QueryBuilder rawFilter, CompositeDataCubeFieldType compositeFieldType)
import org.opensearch.index.query.TermsQueryBuilder;
public interface StarTreeFilterProvider {
            DimensionFilter dimensionFilter = dimensionFilterMapper.getExactMatchFilter(mappedFieldType, List.of(termQueryBuilder.value()));
        }
            }
    }
import org.opensearch.index.mapper.CompositeDataCubeFieldType;  
     * @throws IOException :
            MatchAllQueryBuilder.NAME,
            DimensionFilter dimensionFilter = dimensionFilterMapper.getRangeMatchFilter(mappedFieldType, rangeQuery);
 * The OpenSearch Contributors require contributions made to  
    }  
                return null;  
            return (dimensionFilter == null) ? null : new StarTreeFilter(Map.of(field, List.of(dimensionFilter)));  
     * @return : {@link StarTreeFilter} if the query shape is supported, else null.  
            MATCH_ALL_PROVIDER,  
package org.opensearch.search.startree.filter.provider;
            }
                : null;
     */
            }  
        );  
            new TermsStarTreeFilterProvider(),
import org.opensearch.index.mapper.MappedFieldType;
import org.opensearch.index.compositeindex.datacube.Dimension;
     * Converts @{@link RangeQueryBuilder} into @{@link org.opensearch.search.startree.filter.RangeMatchDimFilter}
     */
            String field = termsQueryBuilder.fieldName();
        }  
        public StarTreeFilter getFilter(SearchContext context, QueryBuilder rawFilter, CompositeDataCubeFieldType compositeFieldType)
        }
            throws IOException {  
    /**
            String field = termQueryBuilder.fieldName();
                : null;
    StarTreeFilter getFilter(SearchContext context, QueryBuilder rawFilter, CompositeDataCubeFieldType compositeFieldType)  
            if (query != null) {  
            Dimension matchedDimension = StarTreeQueryHelper.getMatchingDimensionOrNull(field, compositeFieldType.getDimensions());
                return null; // Indicates Aggregators to fallback to default implementation.
     * @param compositeFieldType:
     * Singleton instances for most {@link StarTreeFilterProvider}  
            TermsQueryBuilder.NAME,  
import org.opensearch.common.annotation.ExperimentalApi;
import org.opensearch.search.startree.StarTreeQueryHelper;  
    StarTreeFilterProvider MATCH_ALL_PROVIDER = (context, rawFilter, compositeFieldType) -> new StarTreeFilter(Collections.emptyMap());  
                return QUERY_BUILDERS_TO_STF_PROVIDER.get(query.getName());
 * SPDX-License-Identifier: Apache-2.0
            MappedFieldType mappedFieldType = context.mapperService().fieldType(field);
import java.util.Map;
     * Converts @{@link TermQueryBuilder} into @{@link org.opensearch.search.startree.filter.ExactMatchDimFilter}  
 * this file be licensed under the Apache-2.0 license or a
    class TermStarTreeFilterProvider implements StarTreeFilterProvider {
     */
/**  
                return null;
     */  
            new TermStarTreeFilterProvider(),
        }  
    /**  
            TermQueryBuilder.NAME,
            DimensionFilter dimensionFilter = dimensionFilterMapper.getExactMatchFilter(mappedFieldType, termsQueryBuilder.values());
 * compatible open source license.
                ? DimensionFilterMapper.Factory.fromMappedFieldType(mappedFieldType, context)  
            MappedFieldType mappedFieldType = context.mapperService().fieldType(field);
            new RangeStarTreeFilterProvider(),  
        public StarTreeFilter getFilter(SearchContext context, QueryBuilder rawFilter, CompositeDataCubeFieldType compositeFieldType)
                : DimensionFilterMapper.Factory.fromMappedFieldType(mappedFieldType, context);  
            Dimension matchedDimension = StarTreeQueryHelper.getMatchingDimensionOrNull(field, compositeFieldType.getDimensions());  
            throws IOException {
            String field = rangeQuery.fieldName();
@ExperimentalApi
    }
        throws IOException;
    /**
 */  
