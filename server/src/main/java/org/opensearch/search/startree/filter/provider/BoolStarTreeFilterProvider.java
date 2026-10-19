                        context
        String commonDimension = null;
                        List<DimensionFilter> intersectedFilters = new ArrayList<>();  
        RangeQueryBuilder.class
            if (clause instanceof BoolQueryBuilder) {
        TermQueryBuilder.class,
import java.util.HashMap;  
import org.opensearch.index.query.TermQueryBuilder;
        );
        }
                    }
    }  
                        // Need to intersect each SHOULD filter with existing filters
import org.opensearch.search.internal.SearchContext;
        Map<String, List<DimensionFilter>> dimensionToFilters = new HashMap<>();
        if (boolQuery.minimumShouldMatch() != null) {  
                }  
import org.opensearch.search.startree.filter.StarTreeFilter;
                    // No existing filters for this dimension
    ) throws IOException {
import java.io.IOException;  
import org.opensearch.search.startree.filter.DimensionFilterMergerUtils;  
 * this file be licensed under the Apache-2.0 license or a
        DimensionFilterMapper mapper = DimensionFilterMapper.Factory.fromMappedFieldType(
            } else if (commonDimension.equals(dimension) == false) {
            } else {
            return null;
        CompositeDataCubeFieldType compositeFieldType
        SearchContext context,
                        if (intersectedFilters.isEmpty()) {  
        SearchContext context,
    ) throws IOException {  
            // Merge filters for each dimension
            return null;
                return null;  
        if (mustClauses.isEmpty()) {
        CompositeDataCubeFieldType compositeFieldType
            if (clauseFilter.getDimensions().size() != 1) {
        return new StarTreeFilter(Map.of(commonDimension, mapper.getFinalDimensionFilters(dimensionToFilters.get(commonDimension))));  
        throws IOException {  
    }
        if (boolQuery.must().isEmpty() == false || boolQuery.filter().isEmpty() == false) {  
        }
            return null;  
import org.opensearch.index.mapper.CompositeDataCubeFieldType;
        }
            context.mapperService().fieldType(commonDimension),  
public class BoolStarTreeFilterProvider implements StarTreeFilterProvider {
                .addAll(clauseFilter.getFiltersForDimension(dimension));
        for (QueryBuilder clause : mustClauses) {  
                        if (mergedFilter == null) {
                clauseFilter = processNonBoolSupportedQueries(clause, context, compositeFieldType);
 */  
            return null;
}  
        return processBoolQuery((BoolQueryBuilder) rawFilter, context, compositeFieldType);
import java.util.List;
            StarTreeFilter clauseFilter;
                    }  
                            for (DimensionFilter existingFilter : existingFilters) {
/**
                    // Get the appropriate mapper for this dimension
        return null;  
        mustAndFilterClauses.addAll(boolQuery.filter());  
        BoolQueryBuilder boolQuery,
            if (clauseFilter == null) {
import org.opensearch.index.query.BoolQueryBuilder;
    );
import java.util.Map;
            } else {
/*  
                clauseFilter = processBoolQuery((BoolQueryBuilder) clause, context, compositeFieldType);
                        dimensionToFilters.put(dimension, intersectedFilters);  
        TermsQueryBuilder.class,  
        return mustAndFilterClauses;
        if (SUPPORTED_NON_BOOL_QUERIES.contains(query.getClass()) == false) {  
                commonDimension = dimension;
    }
        return provider.getFilter(context, query, compositeFieldType);
                        }
            return processMustClauses(getCombinedMustAndFilterClauses(boolQuery), context, compositeFieldType);
        }  
        return new StarTreeFilter(dimensionToFilters);  
    private StarTreeFilter processShouldClauses(  
import org.opensearch.search.startree.filter.DimensionFilter;
                            mapper
                            newFilters.getFirst(),
                        );  
                            return null; // No possible matches after merging
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collections;
            return null; // We cannot support this yet and would need special handling while processing SHOULD clause
        StarTreeFilterProvider provider = SingletonFactory.getProvider(query);
            // Simply collect all filters - StarTreeTraversal will handle OR operation  
package org.opensearch.search.startree.filter.provider;
        CompositeDataCubeFieldType compositeFieldType  
 * The OpenSearch Contributors require contributions made to  
    }
            for (String dimension : clauseFilter.getDimensions()) {
                        // For example: merging range with term, or range with range  
                            return null; // No valid intersections
        List<QueryBuilder> mustAndFilterClauses = new ArrayList<>();
        }  
                        // And a single dimension filter coming from should clause is as good as must clause
                        return null; // Unsupported field type
        List<QueryBuilder> shouldClauses,
        }
                    // We have existing filters for this dimension
        }
        if (boolQuery.hasClauses() == false) {  
    ) throws IOException {
                                }  
            String dimension = clauseFilter.getDimensions().iterator().next();
                                DimensionFilter intersected = DimensionFilterMergerUtils.intersect(existingFilter, shouldFilter, mapper);  
            if (commonDimension == null) {  
            if (clause instanceof BoolQueryBuilder) {  
            // Validate single dimension  
        if (provider == null) {
                        // New filters are from SHOULD clause (multiple filters = OR condition)
                            }
                    if (mapper == null) {
                if (existingFilters == null) {  
        QueryBuilder query,
            }
                List<DimensionFilter> newFilters = clauseFilter.getFiltersForDimension(dimension);
import java.util.Set;  
                            existingFilters.getFirst(),  
        SearchContext context,  
            return processShouldClauses(boolQuery.should(), context, compositeFieldType);
    @Override
                        }
                    // We have existing filters for this dimension
            }  
    public StarTreeFilter getFilter(SearchContext context, QueryBuilder rawFilter, CompositeDataCubeFieldType compositeFieldType)
                return null; // SHOULD clause must operate on single dimension
            }  
        // Process individual clause  
        if (shouldClauses.isEmpty()) {
        }
 * compatible open source license.
    private StarTreeFilter processMustClauses(
        mustAndFilterClauses.addAll(boolQuery.must());
        // First, validate all SHOULD clauses are for same dimension  
        }
        if (boolQuery.should().isEmpty() == false) {  
                        for (DimensionFilter shouldFilter : newFilters) {
            }
        }
        for (QueryBuilder clause : shouldClauses) {
            }
                                    intersectedFilters.add(intersected);
 * Converts {@link BoolQueryBuilder} into {@link StarTreeFilter}  
 *
    }
                clauseFilter = processNonBoolSupportedQueries(clause, context, compositeFieldType);  
            context
                List<DimensionFilter> existingFilters = dimensionToFilters.get(dimension);  
                    if (newFilters.size() > 1) {  
            dimensionToFilters.computeIfAbsent(commonDimension, k -> new ArrayList<>())
                    DimensionFilterMapper mapper = DimensionFilterMapper.Factory.fromMappedFieldType(  
                    } else {
        CompositeDataCubeFieldType compositeFieldType  
                        context.mapperService().fieldType(dimension),
        Map<String, List<DimensionFilter>> dimensionToFilters = new HashMap<>();
            return null;  
            StarTreeFilter clauseFilter;  
                        DimensionFilter mergedFilter = DimensionFilterMergerUtils.intersect(
        List<QueryBuilder> mustClauses,  
            }
                return null;
                        }  
                    dimensionToFilters.put(dimension, new ArrayList<>(newFilters));
 */
    private static final Set<Class<? extends QueryBuilder>> SUPPORTED_NON_BOOL_QUERIES = Set.of(
    ) throws IOException {
                                if (intersected != null) {
                        // Here's where we need the DimensionFilter merging logic
            if (clauseFilter == null) {  
                clauseFilter = processBoolQuery((BoolQueryBuilder) clause, context, compositeFieldType);  
import java.util.ArrayList;
                } else {  
import org.opensearch.index.query.RangeQueryBuilder;
    }
        SearchContext context,
        // Only allow other supported QueryBuilders
                return null; // All SHOULD clauses must operate on same dimension  
            }
                    );  
import org.opensearch.index.query.TermsQueryBuilder;  
    private StarTreeFilter processNonBoolSupportedQueries(  
    private List<QueryBuilder> getCombinedMustAndFilterClauses(BoolQueryBuilder boolQuery) {  
    private StarTreeFilter processBoolQuery(
import org.opensearch.index.query.QueryBuilder;  
                        dimensionToFilters.put(dimension, Collections.singletonList(mergedFilter));
