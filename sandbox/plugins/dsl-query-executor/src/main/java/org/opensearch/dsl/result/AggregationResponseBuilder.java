     */
     * Canonical plan key: aggregation names in nesting order (outer bucket first), NUL-joined.
            eligibleDocCount = metadata.eligibleDocCountIsTotal() ? countTotals.totalDocs() : countTotals.eligibleDocCounts().get(aggName);
import java.util.ArrayList;
    // TODO: Support pipeline aggregations. They post-process the assembled aggregation tree;
            if (eligibleIdx == null) {
            return null;
        List<InternalAggregation> aggs = buildLevel(originalAggs, new ArrayList<>(), Map.of());
            // Fetch is only granted to granularities defined by a SizedBucketTranslator; a
    private InternalAggregation buildMetric(
 * Converts execution results into OpenSearch InternalAggregations format.
        Object value = (matchingRow != null) ? matchingRow[colIdx] : null;
            grouped.computeIfAbsent(key, k -> new ArrayList<>()).add(row);
     * Builds an empty bucket aggregation with no buckets.
    private Long resolveEligibleDocCount(ExecutionResult result, List<Object[]> filteredRows, Map<String, Integer> colIndex)
    }
        AggregationBuilder agg,
        }
    private static InternalAggregation buildEmptyMetric(MetricTranslator<AggregationBuilder> translator, AggregationBuilder agg) {
        this(registry, aggResults, null);
 * SPDX-License-Identifier: Apache-2.0
        List<String> accumulatedAggNames,
import org.opensearch.dsl.aggregation.bucket.BucketTranslator;
                : InternalAggregations.from(buildLevel(subAggs, newAggNames, childFilter));
    }
     * Filters rows to only those matching all filter criteria.
            ExecutionResult previous = resultsByAggPath.putIfAbsent(key, result);
    /**
    ) throws ConversionException {
            return buildEmptyMetric(translator, agg);
import org.opensearch.dsl.aggregation.AggregationMetadataBuilder;
     */
     * Builds InternalAggregations from the original aggregation builders.
     * tail arithmetic is exact. A bounded level with no reachable eligible count is a wiring
     * Metrics ride in their enclosing bucket aggregation's plan, so the lookup uses the
                throw new ConversionException("Group column '" + column + "' not found in aggregation result columns");
        List<String> currentGroupColumns = new ArrayList<>(grouping.getFieldNames());
import org.opensearch.dsl.aggregation.AggregationTranslator;
import org.opensearch.dsl.aggregation.AggregationMetadata;
    ) throws ConversionException {
            // truncated plan rendered through the base contract would tail-sum a tail that
        Integer countIdx = colIndex.get(AggregationMetadataBuilder.IMPLICIT_COUNT_NAME);
     */
            }
        this.countTotals = countTotals;
        }
        if (rows.isEmpty()) {
        }
                        + String.join(",", metadata.getAggNamePath())
     * Drains one granularity's rows into a re-readable list. The builder makes several passes over
        }
        List<Object[]> rows,
        for (Map.Entry<List<Object>, List<Object[]>> entry : grouped.entrySet()) {
import java.util.HashMap;
            throw new ConversionException("Missing " + AggregationMetadataBuilder.IMPLICIT_COUNT_NAME + " column in aggregation result");
     * Checks if a row matches all filter criteria.
     */
    }
    private static InternalAggregation buildEmptyBucket(BucketTranslator<AggregationBuilder> translator, AggregationBuilder agg) {
import java.util.stream.StreamSupport;
                    "No response translator for aggregation [" + agg.getName() + "] of type " + agg.getClass().getSimpleName()
        // a flat-LIMIT plan is root-level and single-field by eligibility
                return row;
    }
        Map<String, Integer> colIndex = buildColumnIndex(result);
     * loudly.
        }
        Object[] matchingRow = findMatchingRow(rows, colIndex, parentKeyFilter);
     * LIMIT) take the aggregation's eligible-document count from the COUNT plans
     * ({@code COUNT(*)} when a {@code missing} value makes every matching doc eligible).
                return 0L;
        return translator.toInternalAggregation(agg.getName(), null, AggregationTranslator.userMetadata(agg));
     * Insertion uses the walker's {@link AggregationMetadata#getAggNamePath()} and lookup uses
 */
     * per call.
            throw new ConversionException("Metric column '" + agg.getName() + "' not found in aggregation result columns");
    }
     * them (filter, group, per-bucket recursion), so the executor's iterable is materialized once
 * the response walk re-accumulates the same path while descending the request tree, so the key
            } else {
     * Uses type-coercion comparison to handle numeric type differences from execution engine.
            Object[] firstRowInGroup = entry.getValue().get(0);
        if (result == null) {
    // currently they are ignored.
        Map<String, Integer> colIndex = buildColumnIndex(result);
            Integer eligibleIdx = colIndex.get(PostAggregateConverter.PARENT_ELIGIBLE_NAME);
        if (rows.isEmpty()) {
        }
                return false;
            ? ((SizedBucketTranslator<AggregationBuilder>) translator).toBucketAggregation(agg, buckets, eligibleDocCount)
            InternalAggregations subAggregations = subAggs.isEmpty()
        List<String> accumulatedAggNames,
     * Groups rows by their grouping column values (the bucket keys). Group columns are
        List<String> newAggNames = new ArrayList<>(accumulatedAggNames);
    // Index each granularity's rows by parent bucket key once, then look buckets up directly.
import org.opensearch.dsl.aggregation.GroupingInfo;
    }
        }
public final class AggregationResponseBuilder {
        return eligibleDocCount;
            long docCount = ((Number) firstRowInGroup[countIdx]).longValue();
    private static List<Object[]> materialize(ExecutionResult result) {
        List<Object[]> rows = materialize(result);
        for (Object[] row : rows) {
        return translator.toBucketAggregation(agg, List.of());
                    "Nested bounded plan result is missing the "
        return rows.stream().filter(row -> matchesFilter(row, colIndex, filter)).collect(Collectors.toList());
        List<Object[]> filteredRows = filterRows(rows, colIndex, parentKeyFilter);
    private static Map<String, Integer> buildColumnIndex(ExecutionResult result) {
        if (eligibleDocCount != null && (translator instanceof SizedBucketTranslator) == false) {
import org.opensearch.search.aggregations.AggregationBuilder;
                );
            Map<String, Object> childFilter = new HashMap<>(parentKeyFilter);
 * compatible open source license.
            }
 * this file be licensed under the Apache-2.0 license or a
    }
    private static Map<List<Object>, List<Object[]>> groupRowsByKeys(
}
        List<Object[]> rows = StreamSupport.stream(result.getRows().spliterator(), false).collect(Collectors.toList());
    /**
                throw new IllegalArgumentException(
    /**
            } else if (type instanceof BucketTranslator) {
     */
            if (metadata == null) {
            : translator.toBucketAggregation(agg, buckets);
     * Builds a map from column names to their indices.
        }
            buckets.add(new BucketEntry(entry.getKey(), docCount, subAggregations));
 * The OpenSearch Contributors require contributions made to
        }
    /**
    public InternalAggregations build(List<AggregationBuilder> originalAggs) throws ConversionException {
import org.opensearch.dsl.converter.ConversionException;
                throw new IllegalStateException("Duplicate aggregation plan path [" + String.join(",", metadata.getAggNamePath()) + "]");
    /**
    private List<InternalAggregation> buildLevel(
     * plan's window {@code SUM(_count) OVER (PARTITION BY parent)} rides every surviving row,
 * the same field set in different nesting orders, all have distinct paths and distinct plans.
        Map<String, Object> parentKeyFilter
import org.opensearch.dsl.aggregation.AggregationRegistry;
        for (String column : groupColumns) {
        return index;
        if (result == null) {
    /**
                // Sibling aggregation names are unique by DSL contract, so a duplicate path
        List<String> fieldNames = result.getFieldNames();
    }
     * Enables efficient column lookup by name during row processing.
        for (ExecutionResult result : aggResults) {
                throw new ConversionException(
    public AggregationResponseBuilder(AggregationRegistry registry, List<ExecutionResult> aggResults) {
     */
            Object eligible = filteredRows.get(0)[eligibleIdx];
                key.add(row[idx]);
 *
            }
import org.opensearch.dsl.util.ComparisonUtils;
 * (outer bucket first) — the walker records it on each plan's {@link AggregationMetadata}, and
     * Resolves the eligible-document total for a level whose plan is bounded. Root-level plans (a flat
        return metric;
     */
    private static Object[] findMatchingRow(List<Object[]> rows, Map<String, Integer> colIndex, Map<String, Object> filter) {
                        + " column for aggregation ["
        BucketTranslator<AggregationBuilder> translator,
    private static List<Object[]> filterRows(List<Object[]> rows, Map<String, Integer> colIndex, Map<String, Object> filter) {
    /**
            if (type instanceof MetricTranslator) {
import org.opensearch.search.aggregations.InternalAggregation;
    }
    }
     * Recursively builds aggregations at a specific nesting level.
            }
                // means the walker invariant broke upstream. Fail loudly instead of silently
            @SuppressWarnings("unchecked")
     */
        Map<String, Object> parentKeyFilter
            if (idx == null) {
 * <p>Plans are per bucket aggregation, so results are keyed by the <b>aggregation-name path</b>
        Integer colIdx = colIndex.get(agg.getName());
        }
            keyIndices.add(idx);
import org.opensearch.search.aggregations.InternalAggregations;
        List<AggregationBuilder> subAggs = new ArrayList<>(translator.getSubAggregations(agg));
            String key = pathKey(metadata.getAggNamePath());
            AggregationTranslator<AggregationBuilder> type = (AggregationTranslator<AggregationBuilder>) registry.get(agg.getClass());
                "Plan for aggregation [" + agg.getName() + "] carried a fetch but its translator is not a SizedBucketTranslator"
    ) throws ConversionException {
        this.registry = registry;
        List<AggregationBuilder> aggs,
            return buildEmptyBucket(translator, agg);
    }
                // overwriting one plan's results with another's.
    /**
        return InternalAggregations.from(aggs);
    /**
     * the response walk's accumulated names — both are built in nesting order, so the key
    /**
            return buildEmptyBucket(translator, agg);
        Map<String, Object> parentKeyFilter
    private final Map<String, ExecutionResult> resultsByAggPath;
     * Used to locate the specific row for nested metric aggregations.
        GroupingInfo grouping = translator.getGrouping(agg);
        List<String> accumulatedAggNames,
        List<Object[]> rows = materialize(result);
    /**
 * matches by construction. Aggregation names are unique among siblings by DSL contract, which
     * Routes to buildMetric or buildBucket based on aggregation type.
        Map<List<Object>, List<Object[]>> grouped = groupRowsByKeys(filteredRows, currentGroupColumns, colIndex);
        throws ConversionException {
            );
    private static String pathKey(List<String> aggNames) {
import org.opensearch.dsl.converter.PostAggregateConverter;
        Long eligibleDocCount = null;
            throw new ConversionException("COUNT plan result is missing the eligible-doc count for bounded aggregation [" + aggName + "]");
        for (Map.Entry<String, Object> entry : filter.entrySet()) {
        List<BucketEntry> buckets = new ArrayList<>();
                result.add(buildBucket((BucketTranslator<AggregationBuilder>) type, agg, accumulatedAggNames, parentKeyFilter));
    }
            if (filteredRows.isEmpty()) {
            index.put(fieldNames.get(i), i);
     * Nested levels (a per-parent bound) read the parent's eligible total off the rows — the
     */
        InternalAggregation bucketAgg = eligibleDocCount != null
        return rows;
            List<Object> key = new ArrayList<>(keyIndices.size());
        return grouped;
     */
            }
     * resolved by name — they are not guaranteed to be the leading row positions.
     * Ensures nested aggregations only process rows belonging to their parent bucket.
        }
        if (colIdx == null) {
                );
     * Groups rows by bucket keys and recursively processes nested aggregations for each bucket.
     */
        Map<String, Integer> colIndex
                result.add(buildMetric((MetricTranslator<AggregationBuilder>) type, agg, accumulatedAggNames, parentKeyFilter));
        List<String> groupColumns,
/*
        MetricTranslator<AggregationBuilder> translator,
        if (filter.isEmpty()) {
     * Builds a metric aggregation by extracting the computed value from execution results.
            // never left the engine.
    private final CountTotals countTotals;
        return bucketAgg;
    private final AggregationRegistry registry;
            }
                childFilter.put(currentGroupColumns.get(i), entry.getKey().get(i));
        List<InternalAggregation> result = new ArrayList<>();
            return rows;
    // TODO: Avoid re-scanning the full row list on every recursion (here and in findMatchingRow).
        Map<List<Object>, List<Object[]>> grouped = new LinkedHashMap<>();
            Integer idx = colIndex.get(column);
            if (idx == null || !ComparisonUtils.valuesEqual(row[idx], entry.getValue())) {
import java.util.Map;
import org.opensearch.dsl.aggregation.metric.MetricTranslator;
            AggregationMetadata metadata = result.getPlan().aggregationMetadata();
        Map<String, Integer> index = new HashMap<>();
        List<Integer> keyIndices = new ArrayList<>(groupColumns.size());
            }
        InternalAggregation metric = translator.toInternalAggregation(agg.getName(), value, AggregationTranslator.userMetadata(agg));
        return null;
        return true;
import org.opensearch.dsl.aggregation.bucket.SizedBucketTranslator;
     * constant within the parent. Returns null for unbounded plans, where the translator's own
        if (metadata.getFetch() == null) {
 *
        if (countIdx == null) {
                        + PostAggregateConverter.PARENT_ELIGIBLE_NAME
        for (int i = 0; i < fieldNames.size(); i++) {
        return result;
        ExecutionResult result = resultsByAggPath.get(pathKey(accumulatedAggNames));
        }
    }
        return AggregationMetadata.pathKey(aggNames);
     */
     * enclosing aggregation-name path; parent filters locate the specific row.
import java.util.List;
        AggregationBuilder agg,
 * makes the key unambiguous: sibling aggregations over the same field, or sibling trees over
            for (int idx : keyIndices) {
     */
        }
                ? InternalAggregations.EMPTY
                        + "]"
                );
     */
        for (AggregationBuilder agg : aggs) {
import java.util.stream.Collectors;
            }
                        + "response builder must be created by SearchSourceConverter"
            Integer idx = colIndex.get(entry.getKey());
                    "AGGREGATION plan is missing its AggregationMetadata — plans consumed by the "
        if (countTotals != null) {
 */
    }
        if (metadata.getPerParentFetch() != null) {
        }
    private static boolean matchesFilter(Object[] row, Map<String, Integer> colIndex, Map<String, Object> filter) {
     * matches by construction.
            return buildEmptyMetric(translator, agg);
            throw new ConversionException(
    /**
        ExecutionResult result = resultsByAggPath.get(pathKey(newAggNames));
        newAggNames.add(agg.getName());
                throw new ConversionException(
        }
        for (Object[] row : rows) {
    public AggregationResponseBuilder(AggregationRegistry registry, List<ExecutionResult> aggResults, CountTotals countTotals) {
    ) throws ConversionException {
        if (eligibleDocCount == null) {
            }
        }
        this.resultsByAggPath = new HashMap<>();
            if (matchesFilter(row, colIndex, filter)) {
            return eligible instanceof Number count ? count.longValue() : 0L;
/**
        }
    }
     * Finds the first row matching all filter criteria.
     * Builds a bucket aggregation by grouping rows and recursively building sub-aggregations.
        AggregationMetadata metadata = result.getPlan().aggregationMetadata();
        }
     * Builds an empty metric aggregation with no computed value.
        }
    /**
    /**
     * bug — rendering would silently understate {@code sum_other_doc_count}, so it fails
    private InternalAggregation buildBucket(
package org.opensearch.dsl.result;
            if (previous != null) {
        }
    }
            }
        String aggName = metadata.getAggNamePath().get(metadata.getAggNamePath().size() - 1);
            for (int i = 0; i < currentGroupColumns.size(); i++) {
        Long eligibleDocCount = resolveEligibleDocCount(result, filteredRows, colIndex);
import java.util.LinkedHashMap;
