            List.of(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.BOOLEAN, CoreValuesSourceType.DATE),
                    if (includeExclude != null) {
import org.opensearch.search.startree.StarTreeQueryHelper;
     * Fields inherent from Terms Aggregation Factory.
            maxOrds[i] = ((ValuesSource.Bytes.WithOrdinals) vs).globalMaxOrd(searchContext.searcher());
     */
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
import org.opensearch.search.internal.SearchContext;
    }
        return maxOrds;
        builder.registerUsage(MultiTermsAggregationBuilder.NAME);
        return new MultiTermsAggregator(
        SearchContext searchContext,
import org.opensearch.search.aggregations.CardinalityUpperBound;
     * ordinal path is eligible, or {@code null} to fall back to the default byte-key path. Falls back when a
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
                ValuesSource.Numeric valuesSource = ((ValuesSource.Numeric) valuesSourceConfig.getValuesSource());
        }
import org.opensearch.search.DocValueFormat;
    ) throws IOException {
            showTermDocCountError,
            metadata,
        CardinalityUpperBound cardinality
        long[] ordinalMaxOrds = resolveOrdinalMaxOrds(configs, searchContext, cardinality);
            // include/exclude is enforced by the byte-key InternalValuesSource collectors, which the
        Aggregator.SubAggCollectionMode collectMode,
import org.opensearch.search.aggregations.AggregatorFactories;
            REGISTRY_KEY,
}
    protected Aggregator createInternal(
            parent,
                        c.getFormat(),
            if (config.v2() != null) {
import java.util.stream.Collectors;
    private final BucketOrder order;
    private static long[] resolveOrdinalMaxOrds(
            ordinalMaxOrds
                ValuesSourceConfig valuesSourceConfig = config.v1();
        MultiTermsAggregator.InternalValuesSource build(Tuple<ValuesSourceConfig, IncludeExclude> config);
            // heuristic to avoid any wrong-ranking caused by distributed
                IncludeExclude.LongFilter longFilter = null;
package org.opensearch.search.aggregations.bucket.terms;
    }
        BucketOrder order,
import org.opensearch.search.aggregations.support.MultiTermsValuesSourceConfig;
                    ),
            true
                    return MultiTermsAggregator.InternalValuesSourceFactory.doubleValueSource(valuesSource, longFilter);
 * The OpenSearch Contributors require contributions made to
            .collect(Collectors.toList());
import org.opensearch.common.collect.Tuple;
        Map<String, Object> metadata,
    }
                IncludeExclude includeExclude = config.v2();
        // TODO: Optimize passing too many value source config derived objects to aggregator
                        queryShardContext,
        Aggregator parent,
                    c.getIncludeExclude()
            // The user has not made a shardSize selection. Use default
     * Supplier for internal values source
        if (StarTreeQueryHelper.getSupportedStarTree(searchContext.getQueryShardContext()) != null) {
                .collect(Collectors.toList()),
        if (InternalOrder.isKeyOrder(order) == false
    ) throws IOException {
            )
                return null;
        // Star-tree path writes directly to BytesKeyedBucketOrds; skip ordinal path to avoid split storage.
            cardinality,
        super(name, queryShardContext, parent, subFactoriesBuilder, metadata);
                    if (includeExclude != null) {
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        for (int i = 0; i < configs.size(); i++) {
    private final Aggregator.SubAggCollectionMode collectMode;
            factories,
            },
import java.util.Map;
    public interface InternalValuesSourceSupplier {
 *
            // ordinal path does not run; fall back so the filter is still honored.
    public MultiTermsAggregationFactory(
            bucketCountThresholds,
                } else {
        QueryShardContext queryShardContext,
import java.util.List;
    private final List<String> requestFields;
            Tuple<ValuesSourceConfig, IncludeExclude> config = configs.get(i);
        builder.register(REGISTRY_KEY, List.of(CoreValuesSourceType.BYTES, CoreValuesSourceType.IP), config -> {
/*
        TermsAggregator.BucketCountThresholds bucketCountThresholds = new TermsAggregator.BucketCountThresholds(this.bucketCountThresholds);
                    }
                    return MultiTermsAggregator.InternalValuesSourceFactory.longValuesSource(valuesSource, longFilter);
    private final TermsAggregator.BucketCountThresholds bucketCountThresholds;
            rawValuesSources,
        List<MultiTermsValuesSourceConfig> multiTermConfigs,
 * @opensearch.internal
                if (valuesSource.isFloatingPoint()) {
                        c.getMissing(),
        this.order = order;
 * SPDX-License-Identifier: Apache-2.0
        }, true);
        this.formats = this.configs.stream().map(c -> c.v1().format()).collect(Collectors.toList());
        String name,
            if ((vs instanceof ValuesSource.Bytes.WithOrdinals) == false) {
        AggregatorFactories.Builder subFactoriesBuilder,
                .map(config -> queryShardContext.getValuesSourceRegistry().getAggregator(REGISTRY_KEY, config.v1()).build(config))
     */
        TermsAggregator.BucketCountThresholds bucketCountThresholds,
        }
        SearchContext searchContext,
     * {@link PackedOrdinalBucketOrds} is built inside the {@link MultiTermsAggregator} constructor from these
        long[] maxOrds = new long[configs.size()];
        this.requestFields = multiTermConfigs.stream().map(MultiTermsValuesSourceConfig::getFieldName).toList();
            }
     * {@code InternalValuesSource} collectors, which the ordinal collection path bypasses). The actual
            configs.stream().map(c -> c.v1().format()).collect(Collectors.toList()),
    private final boolean showTermDocCountError;
import org.opensearch.search.aggregations.InternalOrder;
     *
                        c.getUserValueTypeHint(),
                c -> new Tuple<ValuesSourceConfig, IncludeExclude>(
            return MultiTermsAggregator.InternalValuesSourceFactory.bytesValuesSource(config.v1().getValuesSource(), filter);
        Map<String, Object> metadata
 * Factory of {@link MultiTermsAggregator}.
                    if (includeExclude != null) {
     * {@code include}/{@code exclude} filter (those filters are applied by the per-field
        AggregatorFactory parent,
        List<Tuple<ValuesSourceConfig, IncludeExclude>> configs,
        builder.register(
    /**
        return true;
    protected boolean supportsConcurrentSegmentSearch() {
                        c.getFieldName(),
                        longFilter = includeExclude.convertToDoubleFilter();
            final IncludeExclude.StringFilter filter = config.v2() == null ? null : config.v2().convertToStringFilter(config.v1().format());
     * @opensearch.internal
                    ValuesSourceConfig.resolveUnregistered(
     * counts, so a constructor that fails cannot leak the BigArrays-backed ords.
    ) throws IOException {
            // counting
            .map(
    /**
                        c.getScript(),
            this.getRequestFields(),
 */
                    }
                        longFilter = includeExclude.convertToDoubleFilter();
     */
        );
            return null;
            name,
                        longFilter = includeExclude.convertToLongFilter(valuesSourceConfig.format());
import org.opensearch.search.aggregations.AggregatorFactory;
import org.opensearch.search.aggregations.support.ValuesSource;
                    return MultiTermsAggregator.InternalValuesSourceFactory.unsignedLongValuesSource(valuesSource, longFilter);
 *
            config -> {
        bucketCountThresholds.ensureValidity();
    }
    private final List<Tuple<ValuesSourceConfig, IncludeExclude>> configs;
                } else if (valuesSource.isBigInteger()) {
                return null;
    public List<String> getRequestFields() {
        boolean showTermDocCountError
            configs.stream()
        this.showTermDocCountError = showTermDocCountError;
            }
                    }
                )
    }
            bucketCountThresholds.setShardSize(BucketUtils.suggestShardSideQueueSize(bucketCountThresholds.getRequiredSize()));
                }
import java.io.IOException;
        this.collectMode = collectMode;
    }
import org.opensearch.index.query.QueryShardContext;
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.search.aggregations.bucket.terms.MultiTermsAggregationBuilder.REGISTRY_KEY;
        return requestFields;
        this.configs = multiTermConfigs.stream()
            collectMode,
     * star-tree index is active, when any field is not backed by global ordinals, or when any field carries an
    /**
public class MultiTermsAggregationFactory extends AggregatorFactory {
    private final List<DocValueFormat> formats;
        }
import org.opensearch.search.aggregations.BucketOrder;
 * compatible open source license.
        CardinalityUpperBound cardinality,
            && bucketCountThresholds.getShardSize() == TermsAggregationBuilder.DEFAULT_BUCKET_COUNT_THRESHOLDS.getShardSize()) {
            ValuesSource vs = config.v1().getValuesSource();
            searchContext,
    @Override
            order,
        );
        this.bucketCountThresholds = bucketCountThresholds;
import org.opensearch.search.aggregations.bucket.BucketUtils;
     * Returns the per-field global-ordinal counts ({@code maxOrds}) to pack for the given configs when the
    }
                        CoreValuesSourceType.BYTES
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
    @Override
/**
        List<ValuesSource> rawValuesSources = configs.stream().map(config -> config.v1().getValuesSource()).toList();
import org.opensearch.search.aggregations.Aggregator;
                        c.getTimeZone(),
 */
