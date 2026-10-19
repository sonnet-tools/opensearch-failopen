            }
            }
            ExecutionResult previous = resultsByAggPath.putIfAbsent(key, result);  
            // truncated plan rendered through the base contract would tail-sum a tail that  
            if (metadata == null) {
        BucketTranslator<AggregationBuilder> translator,
            : translator.toBucketAggregation(agg, buckets);  
            return buildEmptyMetric(translator, agg);
     * Enables efficient column lookup by name during row processing.  
            String key = pathKey(metadata.getAggNamePath());
        Integer colIdx = colIndex.get(agg.getName());
     * Insertion uses the walker's {@link AggregationMetadata#getAggNamePath()} and lookup uses
            }
        List<String> fieldNames = result.getFieldNames();
        }
                return 0L;
        }
 *
     * tail arithmetic is exact. A bounded level with no reachable eligible count is a wiring
                // overwriting one plan's results with another's.
package org.opensearch.dsl.result;
 * makes the key unambiguous: sibling aggregations over the same field, or sibling trees over
import org.opensearch.dsl.aggregation.AggregationRegistry;  
        Map<String, Integer> colIndex = buildColumnIndex(result);
        MetricTranslator<AggregationBuilder> translator,
    ) throws ConversionException {
        for (String column : groupColumns) {
    /**
        }
            long docCount = ((Number) firstRowInGroup[countIdx]).longValue();  
        }
    }
    }
            eligibleDocCount = metadata.eligibleDocCountIsTotal() ? countTotals.totalDocs() : countTotals.eligibleDocCounts().get(aggName);
        AggregationMetadata metadata = result.getPlan().aggregationMetadata();
     * Routes to buildMetric or buildBucket based on aggregation type.
        }  
import org.opensearch.dsl.converter.ConversionException;  
        ExecutionResult result = resultsByAggPath.get(pathKey(accumulatedAggNames));
        return bucketAgg;
import org.opensearch.search.aggregations.InternalAggregation;
        if (result == null) {
    /**
import org.opensearch.search.aggregations.InternalAggregations;
            buckets.add(new BucketEntry(entry.getKey(), docCount, subAggregations));  
                result.add(buildMetric((MetricTranslator<AggregationBuilder>) type, agg, accumulatedAggNames, parentKeyFilter));
     * Builds a bucket aggregation by grouping rows and recursively building sub-aggregations.  
    public InternalAggregations build(List<AggregationBuilder> originalAggs) throws ConversionException {  
        if (countTotals != null) {
    }
    private static Map<String, Integer> buildColumnIndex(ExecutionResult result) {
                    "AGGREGATION plan is missing its AggregationMetadata — plans consumed by the "
     * Canonical plan key: aggregation names in nesting order (outer bucket first), NUL-joined.  
        return AggregationMetadata.pathKey(aggNames);  
                throw new IllegalArgumentException(  
     */
     * loudly.
            throw new ConversionException("Missing " + AggregationMetadataBuilder.IMPLICIT_COUNT_NAME + " column in aggregation result");
                result.add(buildBucket((BucketTranslator<AggregationBuilder>) type, agg, accumulatedAggNames, parentKeyFilter));  
import org.opensearch.dsl.aggregation.AggregationTranslator;
        List<BucketEntry> buckets = new ArrayList<>();
                );
            for (int i = 0; i < currentGroupColumns.size(); i++) {
     */
    public AggregationResponseBuilder(AggregationRegistry registry, List<ExecutionResult> aggResults, CountTotals countTotals) {
 * this file be licensed under the Apache-2.0 license or a
    /**
                // means the walker invariant broke upstream. Fail loudly instead of silently  
import java.util.LinkedHashMap;  
            throw new ConversionException(
            for (int idx : keyIndices) {  
import org.opensearch.search.aggregations.AggregationBuilder;  
            Integer eligibleIdx = colIndex.get(PostAggregateConverter.PARENT_ELIGIBLE_NAME);
            ? ((SizedBucketTranslator<AggregationBuilder>) translator).toBucketAggregation(agg, buckets, eligibleDocCount)
            }
        }  
    private static String pathKey(List<String> aggNames) {
        Map<List<Object>, List<Object[]>> grouped = groupRowsByKeys(filteredRows, currentGroupColumns, colIndex);
    private static List<Object[]> filterRows(List<Object[]> rows, Map<String, Integer> colIndex, Map<String, Object> filter) {  
        Long eligibleDocCount = resolveEligibleDocCount(result, filteredRows, colIndex);  
    // TODO: Support pipeline aggregations. They post-process the assembled aggregation tree;
                : InternalAggregations.from(buildLevel(subAggs, newAggNames, childFilter));
        List<Object[]> rows,
            return rows;
                return false;  
        return rows.stream().filter(row -> matchesFilter(row, colIndex, filter)).collect(Collectors.toList());
            if (filteredRows.isEmpty()) {  
        return rows;  
        throws ConversionException {
                    "Nested bounded plan result is missing the "
            }
import org.opensearch.dsl.util.ComparisonUtils;
    private static Map<List<Object>, List<Object[]>> groupRowsByKeys(
                throw new ConversionException("Group column '" + column + "' not found in aggregation result columns");
        InternalAggregation metric = translator.toInternalAggregation(agg.getName(), value, AggregationTranslator.userMetadata(agg));
        AggregationBuilder agg,
 */  
    /**
        for (Object[] row : rows) {
     * Builds an empty bucket aggregation with no buckets.
    }
        this.registry = registry;  
                    "No response translator for aggregation [" + agg.getName() + "] of type " + agg.getClass().getSimpleName()  
 */  
        Map<String, Integer> index = new HashMap<>();  
        for (Object[] row : rows) {
    private static InternalAggregation buildEmptyBucket(BucketTranslator<AggregationBuilder> translator, AggregationBuilder agg) {
     * Filters rows to only those matching all filter criteria.  
    /**
     */  
    /**
    }
                childFilter.put(currentGroupColumns.get(i), entry.getKey().get(i));
 * the response walk re-accumulates the same path while descending the request tree, so the key
            Object eligible = filteredRows.get(0)[eligibleIdx];  
    }  
            // Fetch is only granted to granularities defined by a SizedBucketTranslator; a
                throw new ConversionException(
                key.add(row[idx]);
            } else if (type instanceof BucketTranslator) {
    // TODO: Avoid re-scanning the full row list on every recursion (here and in findMatchingRow).  
            );
            }
    }
        List<Object[]> rows = materialize(result);
        ExecutionResult result = resultsByAggPath.get(pathKey(newAggNames));
 * Converts execution results into OpenSearch InternalAggregations format.
        return null;  
     * them (filter, group, per-bucket recursion), so the executor's iterable is materialized once
        Object[] matchingRow = findMatchingRow(rows, colIndex, parentKeyFilter);
            AggregationTranslator<AggregationBuilder> type = (AggregationTranslator<AggregationBuilder>) registry.get(agg.getClass());
import java.util.stream.Collectors;  
     * enclosing aggregation-name path; parent filters locate the specific row.
        if (rows.isEmpty()) {
        for (ExecutionResult result : aggResults) {  
        List<Integer> keyIndices = new ArrayList<>(groupColumns.size());  
     * Groups rows by bucket keys and recursively processes nested aggregations for each bucket.
    /**
 * matches by construction. Aggregation names are unique among siblings by DSL contract, which  
     * Finds the first row matching all filter criteria.  
import org.opensearch.dsl.aggregation.AggregationMetadata;
        }  
        }
     */
        }
        for (Map.Entry<List<Object>, List<Object[]>> entry : grouped.entrySet()) {
                        + String.join(",", metadata.getAggNamePath())
            }  
        if (eligibleDocCount == null) {
                );  
     */
        return index;
                "Plan for aggregation [" + agg.getName() + "] carried a fetch but its translator is not a SizedBucketTranslator"  
     */
 * compatible open source license.
     * Builds InternalAggregations from the original aggregation builders.
    private static List<Object[]> materialize(ExecutionResult result) {
            return eligible instanceof Number count ? count.longValue() : 0L;
        Long eligibleDocCount = null;  
                ? InternalAggregations.EMPTY  
        Integer countIdx = colIndex.get(AggregationMetadataBuilder.IMPLICIT_COUNT_NAME);  
        this.resultsByAggPath = new HashMap<>();
        }  
        return eligibleDocCount;
    }  
        List<AggregationBuilder> subAggs = new ArrayList<>(translator.getSubAggregations(agg));  
        }  
        List<InternalAggregation> aggs = buildLevel(originalAggs, new ArrayList<>(), Map.of());
    public AggregationResponseBuilder(AggregationRegistry registry, List<ExecutionResult> aggResults) {
    private final Map<String, ExecutionResult> resultsByAggPath;
        }
     * Builds a metric aggregation by extracting the computed value from execution results.
        Map<List<Object>, List<Object[]>> grouped = new LinkedHashMap<>();  
        if (result == null) {  
        }  
                        + "]"  
    private static InternalAggregation buildEmptyMetric(MetricTranslator<AggregationBuilder> translator, AggregationBuilder agg) {  
        return translator.toInternalAggregation(agg.getName(), null, AggregationTranslator.userMetadata(agg));
        Object value = (matchingRow != null) ? matchingRow[colIdx] : null;  
                // Sibling aggregation names are unique by DSL contract, so a duplicate path
        String aggName = metadata.getAggNamePath().get(metadata.getAggNamePath().size() - 1);
    }  
    // currently they are ignored.
     * plan's window {@code SUM(_count) OVER (PARTITION BY parent)} rides every surviving row,  
        List<String> currentGroupColumns = new ArrayList<>(grouping.getFieldNames());
        for (int i = 0; i < fieldNames.size(); i++) {
     * Recursively builds aggregations at a specific nesting level.  
        if (metadata.getFetch() == null) {
        if (filter.isEmpty()) {
            if (matchesFilter(row, colIndex, filter)) {
public final class AggregationResponseBuilder {
     * Metrics ride in their enclosing bucket aggregation's plan, so the lookup uses the  
    private final CountTotals countTotals;
 * <p>Plans are per bucket aggregation, so results are keyed by the <b>aggregation-name path</b>  
        GroupingInfo grouping = translator.getGrouping(agg);
            index.put(fieldNames.get(i), i);  
            if (idx == null) {  
import org.opensearch.dsl.aggregation.AggregationMetadataBuilder;
                throw new ConversionException(
        List<Object[]> rows = StreamSupport.stream(result.getRows().spliterator(), false).collect(Collectors.toList());
        List<String> newAggNames = new ArrayList<>(accumulatedAggNames);
        }
     * Resolves the eligible-document total for a level whose plan is bounded. Root-level plans (a flat
    }  
        InternalAggregation bucketAgg = eligibleDocCount != null
        newAggNames.add(agg.getName());  
        if (countIdx == null) {
 * The OpenSearch Contributors require contributions made to  
        return result;
     * Groups rows by their grouping column values (the bucket keys). Group columns are
     * the response walk's accumulated names — both are built in nesting order, so the key
/**  
 * SPDX-License-Identifier: Apache-2.0
    /**
        return metric;
                        + " column for aggregation ["
        List<String> accumulatedAggNames,  
        }
        Map<String, Integer> colIndex
    /**
     * resolved by name — they are not guaranteed to be the leading row positions.
                throw new IllegalStateException("Duplicate aggregation plan path [" + String.join(",", metadata.getAggNamePath()) + "]");
     * Ensures nested aggregations only process rows belonging to their parent bucket.
            if (type instanceof MetricTranslator) {  
            AggregationMetadata metadata = result.getPlan().aggregationMetadata();
            }  
    ) throws ConversionException {
import org.opensearch.dsl.aggregation.bucket.BucketTranslator;  
        this(registry, aggResults, null);
                        + "response builder must be created by SearchSourceConverter"
     */
     * Builds an empty metric aggregation with no computed value.
    }
        List<String> groupColumns,  
        return translator.toBucketAggregation(agg, List.of());
        }  
import java.util.List;
        return grouped;
        List<InternalAggregation> result = new ArrayList<>();  
            if (eligibleIdx == null) {  
    private static Object[] findMatchingRow(List<Object[]> rows, Map<String, Integer> colIndex, Map<String, Object> filter) {  
        Map<String, Object> parentKeyFilter  
        List<Object[]> filteredRows = filterRows(rows, colIndex, parentKeyFilter);  
    }  
            if (idx == null || !ComparisonUtils.valuesEqual(row[idx], entry.getValue())) {
            throw new ConversionException("COUNT plan result is missing the eligible-doc count for bounded aggregation [" + aggName + "]");
     * Drains one granularity's rows into a re-readable list. The builder makes several passes over  
     */  
     * Builds a map from column names to their indices.
    /**  
    }
import java.util.ArrayList;
            // never left the engine.
     * matches by construction.  
    }
}
import org.opensearch.dsl.converter.PostAggregateConverter;
     * ({@code COUNT(*)} when a {@code missing} value makes every matching doc eligible).
    ) throws ConversionException {
    private InternalAggregation buildMetric(  
    }
        Map<String, Object> parentKeyFilter
                );
        // a flat-LIMIT plan is root-level and single-field by eligibility
            Integer idx = colIndex.get(entry.getKey());
        for (Map.Entry<String, Object> entry : filter.entrySet()) {  
     * Nested levels (a per-parent bound) read the parent's eligible total off the rows — the
            }
                        + PostAggregateConverter.PARENT_ELIGIBLE_NAME  
            @SuppressWarnings("unchecked")  
        this.countTotals = countTotals;
        }
            }
    }  
     */
     * bug — rendering would silently understate {@code sum_other_doc_count}, so it fails  
/*  
            } else {
    /**  
        Map<String, Integer> colIndex = buildColumnIndex(result);
            return buildEmptyMetric(translator, agg);
        List<String> accumulatedAggNames,  
 *
 * the same field set in different nesting orders, all have distinct paths and distinct plans.
import org.opensearch.dsl.aggregation.bucket.SizedBucketTranslator;
     */
import org.opensearch.dsl.aggregation.GroupingInfo;
    private final AggregationRegistry registry;  
    private List<InternalAggregation> buildLevel(  
        if (rows.isEmpty()) {  
    private static boolean matchesFilter(Object[] row, Map<String, Integer> colIndex, Map<String, Object> filter) {
     * per call.
     * LIMIT) take the aggregation's eligible-document count from the COUNT plans  
        List<String> accumulatedAggNames,
        return InternalAggregations.from(aggs);
        if (eligibleDocCount != null && (translator instanceof SizedBucketTranslator) == false) {
            List<Object> key = new ArrayList<>(keyIndices.size());
     * Uses type-coercion comparison to handle numeric type differences from execution engine.  
     */  
            InternalAggregations subAggregations = subAggs.isEmpty()
            return buildEmptyBucket(translator, agg);
import java.util.Map;
    /**
        }  
            Integer idx = colIndex.get(column);
            Object[] firstRowInGroup = entry.getValue().get(0);
        if (metadata.getPerParentFetch() != null) {
    /**  
    /**
     * constant within the parent. Returns null for unbounded plans, where the translator's own
        Map<String, Object> parentKeyFilter
        }
     */
        if (colIdx == null) {
            throw new ConversionException("Metric column '" + agg.getName() + "' not found in aggregation result columns");
 * (outer bucket first) — the walker records it on each plan's {@link AggregationMetadata}, and
    ) throws ConversionException {
import java.util.HashMap;
    private InternalAggregation buildBucket(  
     */
    private Long resolveEligibleDocCount(ExecutionResult result, List<Object[]> filteredRows, Map<String, Integer> colIndex)  
                return row;  
        List<AggregationBuilder> aggs,
     */
        for (AggregationBuilder agg : aggs) {
        List<Object[]> rows = materialize(result);
     * Checks if a row matches all filter criteria.
            grouped.computeIfAbsent(key, k -> new ArrayList<>()).add(row);  
import java.util.stream.StreamSupport;
        return true;  
import org.opensearch.dsl.aggregation.metric.MetricTranslator;
    // Index each granularity's rows by parent bucket key once, then look buckets up directly.
            if (previous != null) {
        }  
     * Used to locate the specific row for nested metric aggregations.
            return null;
            keyIndices.add(idx);  
            Map<String, Object> childFilter = new HashMap<>(parentKeyFilter);  
        AggregationBuilder agg,
            return buildEmptyBucket(translator, agg);
