import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;
        return fieldType;
        if (entries.isEmpty() == false) {
import org.opensearch.search.aggregations.BucketOrder;
}
            );
     *
                    + agg.getName()
            throw new ConversionException(
package org.opensearch.dsl.aggregation.bucket;
import java.util.Map;
    static TermsAggregator.BucketCountThresholds thresholds(TermsAggregationBuilder agg) {
import org.opensearch.search.aggregations.InternalAggregation;
                || DateFieldMapper.DATE_NANOS_CONTENT_TYPE.equals(fieldType.typeName()))) {
                "[min_doc_count: 0] on terms aggregation ["
     * eligible counts come from a separately executed COUNT plan, and a refresh landing between
    }
    /**
        MapperService mapperService = mapperServiceSupplier.get();
                    + agg.field()
        MapperService mapperService = mapperServiceSupplier.get();
     * bucket set here means the sized dispatch was bypassed, and the method throws.
        TermsResponseStrategy strategy = TermsResponseStrategy.forType(fieldType.typeName());
     * total {@code sum_other_doc_count} is subtracted from (see {@link #sumOtherDocCount}).
        List<BucketEntry> entries = new ArrayList<>();
import org.opensearch.dsl.aggregation.GroupingInfo;
 * resolved at render time fails the request.
    public Collection<AggregationBuilder> getSubAggregations(TermsAggregationBuilder agg) {
                    + "] on date field ["
        return agg.size();
     * {@link #toBucketAggregation(TermsAggregationBuilder, Iterable, long)}. A non-empty
    /**
public class TermsBucketTranslator implements SizedBucketTranslator<TermsAggregationBuilder> {
        if (agg.script() != null) {
 * {@code {"aggs": {"by_brand": {"terms": {"field": "brand"}}}}} becomes {@code GROUP BY brand}.
        List<BucketEntry> entries = toList(buckets);
            throw new ConversionException(
        return Math.max(0, eligibleDocCount - receivedDocCount);
import org.opensearch.index.mapper.MapperService;
    @Override
    @Override
import java.util.function.Supplier;
                    + "] is not supported by the DSL execution path — zero-count buckets require enumerating the index term "
    @Override
    /** Bundles the request's bucket-count knobs for the result constructors. */
                    + agg.field()
     * list — as {@code eligibleDocCount − Σ(received doc counts)}, clamped at zero: root
                "[script] on terms aggregation [" + agg.getName() + "] is not supported by the DSL execution path"
     */
     * Creates a terms bucket translator.
        }
    private MappedFieldType requireFieldType(TermsAggregationBuilder agg) {
        long otherDocCount = sumOtherDocCount(kept, eligibleDocCount);
     * date-mapped fields: the translation implements none of them, and each would change the
                    + agg.getName()
import java.util.List;
    }
        }
            );
    private static long sumOtherDocCount(List<BucketEntry> entries, long eligibleDocCount) {
            );
    @Override
     */
     * and the {@link DocValueFormat} for key rendering. {@code eligibleDocCount} supplies the
    @Override
        MappedFieldType fieldType = mapperService.fieldType(agg.field());
    /** Resolves the group field's mapping, or null when the MapperService or field mapping is unavailable. */
 * compatible open source license.
 */
        if (agg.minDocCount() == 0) {
    /**
     * bucket set or key rendering relative to classic search if ignored.
        buckets.forEach(entries::add);
    private final Supplier<MapperService> mapperServiceSupplier;
    public InternalAggregation toBucketAggregation(TermsAggregationBuilder agg, Iterable<BucketEntry> buckets, long eligibleDocCount) {
        return render(agg, toList(buckets), eligibleDocCount);
                    + "]"
        for (BucketEntry entry : entries) {
    }
                    + "] — cannot resolve the key type for field ["
     *        rendering
            );
            );
        return render(agg, entries, 0L);
    /**
        }
        }
        this.mapperServiceSupplier = mapperServiceSupplier;
        return strategy.build(agg, kept, otherDocCount, fieldType.docValueFormat(null, null));
    public GroupingInfo getGrouping(TermsAggregationBuilder agg) {
            throw new IllegalStateException(
     * @param mapperServiceSupplier supplies the target index's MapperService for key type and
     */
import org.opensearch.dsl.aggregation.FieldGrouping;
    public int size(TermsAggregationBuilder agg) {
 * The OpenSearch Contributors require contributions made to
     * Rejects {@code include}/{@code exclude}, {@code script}, {@code min_doc_count: 0}, and
        return agg.minDocCount();
                "index mapping unavailable for terms aggregation ["
    @Override
 * this file be licensed under the Apache-2.0 license or a
    private InternalAggregation render(TermsAggregationBuilder agg, List<BucketEntry> kept, long eligibleDocCount) {
import org.opensearch.search.aggregations.AggregationBuilder;
    private MappedFieldType resolveFieldType(String field) {
        if (fieldType == null) {
        return mapperService == null ? null : mapperService.fieldType(field);
import org.opensearch.index.mapper.MappedFieldType;
    public InternalAggregation toBucketAggregation(TermsAggregationBuilder agg, Iterable<BucketEntry> buckets) {
import java.util.ArrayList;
     */
    }
    }
    }
    /** Resolves the group field's mapping for rendering, failing loudly when it cannot be resolved. */
        return agg.order();
     * Renders the empty aggregation for levels with no result rows — the only case that
     * eligible counts ride the plan's own rows and cannot skew.)
            : new FieldGrouping(List.of(agg.field()), Map.of(agg.field(), agg.missing()));
                    + "] is not supported by the DSL execution path — date bucket keys cannot yet be rendered with mapping formats"
    /**
        }
     * {@code min_doc_count}, ordered, and truncated to the top {@code size}.
        return agg.missing() == null
        MappedFieldType fieldType = resolveFieldType(agg.field());
        return TermsAggregationBuilder.class;
    public void validate(TermsAggregationBuilder agg) throws ConversionException {
            );
import org.opensearch.dsl.result.BucketEntry;
        if (fieldType != null
                    + "dictionary, which a GROUP BY over matching documents cannot produce"
        if (agg.includeExclude() != null) {
            && (DateFieldMapper.CONTENT_TYPE.equals(fieldType.typeName())
            throw new ConversionException(
                    + agg.getName()
 * Translates a {@link TermsAggregationBuilder} — single-field GROUP BY.
                "terms aggregation ["
    @Override
            );
    }
     * Renders the plan's bucket set as received: the plan already excluded null keys, applied
        return entries;
import org.opensearch.dsl.converter.ConversionException;
    }
            throw new ConversionException(
    }
                "terms aggregation ["
            throw new IllegalStateException(
            receivedDocCount += entry.docCount();
    }
import org.opensearch.search.DocValueFormat;
        }
 *
            throw new IllegalStateException(
 *
    }
 * the mapping's {@link DocValueFormat} renders the keys. A field whose mapping cannot be
     */
                    + agg.getName()
    }
        }
    public long minDocCount(TermsAggregationBuilder agg) {
    /**
    @Override
 */
                    + "] received buckets on the unsized render path: every terms plan is bounded, so rendering must go through the sized path"
    public TermsBucketTranslator(Supplier<MapperService> mapperServiceSupplier) {
    }
    @Override
    }
        }
        MappedFieldType fieldType = requireFieldType(agg);
 * <p>Response typing is mapping-resolved: the field's {@code MappedFieldType.typeName()} selects
 * the {@link TermsResponseStrategy} that builds the correct {@code InternalTerms} subclass, and
    }
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
/**
    public BucketOrder getBucketOrder(TermsAggregationBuilder agg) {
     *        format resolution; supplying null skips {@link #validate} mapping checks and fails
     * Builds the terms response: the field's mapping selects the {@link TermsResponseStrategy}
/*
     * Computes {@code sum_other_doc_count} — docs belonging to groups not in the bucket
     * {@code sum_other_doc_count} is {@code eligibleDocCount − Σ(received doc counts)}.
        long receivedDocCount = 0;
     * levels by the per-parent ROW_NUMBER window), so non-empty levels render through
            ? new FieldGrouping(List.of(agg.field()))
     * reaches this method: every terms plan is bounded (root levels by a flat LIMIT, nested
     * the two queries can leave the eligible count smaller than the received sum. (Nested
        return agg.getSubAggregations();
    private static List<BucketEntry> toList(Iterable<BucketEntry> buckets) {
        return new TermsAggregator.BucketCountThresholds(agg.minDocCount(), agg.shardMinDocCount(), agg.size(), agg.shardSize());
import org.opensearch.index.mapper.DateFieldMapper;
                "[include]/[exclude] on terms aggregation [" + agg.getName() + "] is not supported by the DSL execution path"
     */
 * SPDX-License-Identifier: Apache-2.0
                "field [" + agg.field() + "] of terms aggregation [" + agg.getName() + "] is not present in the index mapping"
    public Class<TermsAggregationBuilder> getAggregationType() {
        if (mapperService == null) {
    }
import java.util.Collection;
