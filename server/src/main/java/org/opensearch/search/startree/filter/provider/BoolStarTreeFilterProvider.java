        if (shouldClauses.isEmpty()) {
        List<QueryBuilder> mustClauses,
import java.io.IOException;
 *
            context.mapperService().fieldType(commonDimension),
import org.opensearch.search.internal.SearchContext;
        }
                List<DimensionFilter> newFilters = clauseFilter.getFiltersForDimension(dimension);
            // Merge filters for each dimension
import org.opensearch.index.query.TermQueryBuilder;
            StarTreeFilter clauseFilter;
        if (SUPPORTED_NON_BOOL_QUERIES.contains(query.getClass()) == false) {
import org.opensearch.search.startree.filter.StarTreeFilter;
        );
    }
        CompositeDataCubeFieldType compositeFieldType
            if (clauseFilter.getDimensions().size() != 1) {
    private StarTreeFilter processShouldClauses(
import org.opensearch.index.query.RangeQueryBuilder;
    private StarTreeFilter processNonBoolSupportedQueries(
        }
package org.opensearch.search.startree.filter.provider;
        Map<String, List<DimensionFilter>> dimensionToFilters = new HashMap<>();
    private StarTreeFilter processBoolQuery(
    }
            String dimension = clauseFilter.getDimensions().iterator().next();
import org.opensearch.search.startree.filter.DimensionFilter;
        }
        mustAndFilterClauses.addAll(boolQuery.filter());
                        for (DimensionFilter shouldFilter : newFilters) {
                        return null; // Unsupported field type
                                    intersectedFilters.add(intersected);
    }
                            mapper
                    }
            }
        CompositeDataCubeFieldType compositeFieldType
        SearchContext context,
            dimensionToFilters.computeIfAbsent(commonDimension, k -> new ArrayList<>())
            if (commonDimension == null) {
        DimensionFilterMapper mapper = DimensionFilterMapper.Factory.fromMappedFieldType(
        SearchContext context,
                                DimensionFilter intersected = DimensionFilterMergerUtils.intersect(existingFilter, shouldFilter, mapper);
        return provider.getFilter(context, query, compositeFieldType);
    public StarTreeFilter getFilter(SearchContext context, QueryBuilder rawFilter, CompositeDataCubeFieldType compositeFieldType)
import java.util.HashMap;
        SearchContext context,
    }
                            }
                            for (DimensionFilter existingFilter : existingFilters) {
                    // Get the appropriate mapper for this dimension
            StarTreeFilter clauseFilter;
            for (String dimension : clauseFilter.getDimensions()) {
                    // No existing filters for this dimension
        return processBoolQuery((BoolQueryBuilder) rawFilter, context, compositeFieldType);
        CompositeDataCubeFieldType compositeFieldType
                        );
        List<QueryBuilder> shouldClauses,
                    );
                        // For example: merging range with term, or range with range
        return new StarTreeFilter(dimensionToFilters);
                commonDimension = dimension;
        if (boolQuery.must().isEmpty() == false || boolQuery.filter().isEmpty() == false) {
    private static final Set<Class<? extends QueryBuilder>> SUPPORTED_NON_BOOL_QUERIES = Set.of(
import java.util.List;
import java.util.Set;
import org.opensearch.index.query.QueryBuilder;
        }
            }
                        }
                            return null; // No valid intersections
                        if (intersectedFilters.isEmpty()) {
        TermQueryBuilder.class,
                clauseFilter = processNonBoolSupportedQueries(clause, context, compositeFieldType);
                        // And a single dimension filter coming from should clause is as good as must clause
            }
                if (existingFilters == null) {
                return null; // All SHOULD clauses must operate on same dimension
        return null;
        // Only allow other supported QueryBuilders
        // First, validate all SHOULD clauses are for same dimension
                        }
import org.opensearch.index.mapper.CompositeDataCubeFieldType;
 * this file be licensed under the Apache-2.0 license or a
            } else {
import java.util.ArrayList;
            if (clauseFilter == null) {
    ) throws IOException {
                        // New filters are from SHOULD clause (multiple filters = OR condition)
                        context
/*
            return null;
        mustAndFilterClauses.addAll(boolQuery.must());
        return new StarTreeFilter(Map.of(commonDimension, mapper.getFinalDimensionFilters(dimensionToFilters.get(commonDimension))));
import java.util.Map;
    );
        List<QueryBuilder> mustAndFilterClauses = new ArrayList<>();
        StarTreeFilterProvider provider = SingletonFactory.getProvider(query);
                        context.mapperService().fieldType(dimension),
                clauseFilter = processNonBoolSupportedQueries(clause, context, compositeFieldType);
                clauseFilter = processBoolQuery((BoolQueryBuilder) clause, context, compositeFieldType);
                                }
                        // Need to intersect each SHOULD filter with existing filters
        if (boolQuery.should().isEmpty() == false) {
                        dimensionToFilters.put(dimension, intersectedFilters);
            return null;
        return mustAndFilterClauses;
                    dimensionToFilters.put(dimension, new ArrayList<>(newFilters));
    @Override
    private StarTreeFilter processMustClauses(
 * compatible open source license.
        }
                    } else {
                                if (intersected != null) {
        if (boolQuery.hasClauses() == false) {
            return processShouldClauses(boolQuery.should(), context, compositeFieldType);
            }
        if (mustClauses.isEmpty()) {
    }
/**
                            return null; // No possible matches after merging
import org.opensearch.index.query.TermsQueryBuilder;
                    }
            } else if (commonDimension.equals(dimension) == false) {
                List<DimensionFilter> existingFilters = dimensionToFilters.get(dimension);
                    // We have existing filters for this dimension
        RangeQueryBuilder.class
            if (clauseFilter == null) {
            }
        }
                        List<DimensionFilter> intersectedFilters = new ArrayList<>();
        }
            return null; // We cannot support this yet and would need special handling while processing SHOULD clause
            } else {
 * The OpenSearch Contributors require contributions made to
        }
        }
                return null;
    ) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
        for (QueryBuilder clause : mustClauses) {
            if (clause instanceof BoolQueryBuilder) {
        for (QueryBuilder clause : shouldClauses) {
 * Converts {@link BoolQueryBuilder} into {@link StarTreeFilter}
}
                        }
import java.util.Collections;
                    DimensionFilterMapper mapper = DimensionFilterMapper.Factory.fromMappedFieldType(
            if (clause instanceof BoolQueryBuilder) {
        // Process individual clause
        throws IOException {
            // Simply collect all filters - StarTreeTraversal will handle OR operation
        BoolQueryBuilder boolQuery,
                return null; // SHOULD clause must operate on single dimension
 */
                        DimensionFilter mergedFilter = DimensionFilterMergerUtils.intersect(
            return null;
                        dimensionToFilters.put(dimension, Collections.singletonList(mergedFilter));
    }
                        // Here's where we need the DimensionFilter merging logic
            return null;
        String commonDimension = null;
import org.opensearch.search.startree.filter.DimensionFilterMergerUtils;
public class BoolStarTreeFilterProvider implements StarTreeFilterProvider {
        SearchContext context,
        Map<String, List<DimensionFilter>> dimensionToFilters = new HashMap<>();
                        if (mergedFilter == null) {
    ) throws IOException {
        TermsQueryBuilder.class,
                            existingFilters.getFirst(),
                return null;
    private List<QueryBuilder> getCombinedMustAndFilterClauses(BoolQueryBuilder boolQuery) {
            return processMustClauses(getCombinedMustAndFilterClauses(boolQuery), context, compositeFieldType);
import org.opensearch.index.query.BoolQueryBuilder;
            context
            // Validate single dimension
        if (boolQuery.minimumShouldMatch() != null) {
        if (provider == null) {
            return null;
        QueryBuilder query,
            }
                clauseFilter = processBoolQuery((BoolQueryBuilder) clause, context, compositeFieldType);
                .addAll(clauseFilter.getFiltersForDimension(dimension));
            }
 */
                            newFilters.getFirst(),
                    if (mapper == null) {
                    if (newFilters.size() > 1) {
                } else {
        }
        CompositeDataCubeFieldType compositeFieldType
    ) throws IOException {
                }
                    // We have existing filters for this dimension
