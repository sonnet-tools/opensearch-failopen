            public Set<DelegationType> acceptedDelegations() {
        return new LuceneInstructionHandlerFactory(plugin);
    @Override
import org.opensearch.analytics.spi.CommonExecutionContext;
        FULL_TEXT_TYPES.addAll(FieldType.keyword());
        ScalarFunction.QUERY_STRING,
        return LuceneDataFormat.LUCENE_FORMAT_NAME;
        ScalarFunction.QUERY,
    }
            public BackendShardPreference shardPreference() {
        ScalarFunction.LIKE,
    // Field types Lucene's secondary data format actually indexes (see LuceneFieldFactoryRegistry).
            0,
    }
            return task instanceof CancellableTask ct && ct.isCancelled();
        FILTER_CAPS = caps;
    public FragmentConvertor getFragmentConvertor() {
        ScalarFunction.WILDCARD,
            engine.prepare(ctx);
        ScalarFunction.NOT_EQUALS,
            }
    }
            s -> true,  // indexNameMatcher
            return engine;
        return new LuceneSubtreeConvertor(QuerySerializerRegistry.getSerializers());
        );
        };
     * fields are listed here. It does NOT imply Lucene can deliver row values; consumers
        ScalarFunction.MULTI_MATCH,
    // registered in QuerySerializerRegistry — declaring a capability without a matching
        // Shared per-reader searcher (see LuceneReader#searcher) — a fresh one here crashes the node
    private static final String LUCENE_FORMAT = LuceneDataFormat.LUCENE_FORMAT_NAME;
    }
 * for full-text and standard predicates, and provides {@link DelegatedPredicateSerializer}
        for (ScalarFunction op : STANDARD_OPS) {
    );
        QueryShardContext queryShardContext = buildMinimalQueryShardContext(shardCtx, searcher);
    private static final Set<ScalarFunction> FULL_TEXT_OPS = Set.of(
     * Lucene drives count(*) and (in a follow-up) count(col) over fields it indexes.
        ScalarFunction.MATCH_BOOL_PREFIX,
                );
    public BackendCapabilityProvider getCapabilityProvider() {
    // Numeric/date/boolean fields are not indexed under composite-parquet primary, so listing them
        ScalarFunction.REGEXP,
            @Override
        STANDARD_TYPES.add(FieldType.KEYWORD);
 * @opensearch.internal
        ScalarFunction.SIMPLE_QUERY_STRING,
        }
    }
        ScalarFunction.MATCH_PHRASE,
import org.opensearch.analytics.spi.FieldType;
                return Set.of(DelegationType.FILTER);
    public SearchExecEngineProvider getSearchExecEngineProvider() {
        ScalarFunction.PREFIX_QUERY,
            @Override
    // backend's serializer keyset at startup so this list can't drift again. The TODO in
import java.util.Set;
    @Override
import org.opensearch.tasks.Task;
        };
                    "Lucene SearchExecEngineProvider expected LuceneSearcherState but got "
            return false;
    static QueryShardContext buildMinimalQueryShardContext(ShardScanExecutionContext ctx, IndexSearcher searcher) {
        ScalarFunction.FUZZY,
import org.opensearch.index.query.QueryBuilder;
        );
    private static final Set<FieldType> KEYWORD_ONLY = Set.of(FieldType.KEYWORD);
    private static final Set<ScanCapability> SCAN_CAPS = Set.of(new ScanCapability.Index(LUCENE_FORMATS, STANDARD_TYPES));
 * Analytics SPI extension for the Lucene backend. Declares filter capabilities
    /** Package-private — also reused by {@link LuceneScanInstructionHandler} in driver mode. */
     * types it accepts filters on — keyword / text / match_only_text. The Index
    public FragmentInstructionHandlerFactory getInstructionHandlerFactory() {
 * {@link org.opensearch.index.mapper.MappedFieldType} and create the Lucene query.
    static {
            LuceneSearchExecEngine engine = new LuceneSearchExecEngine(state);
        for (ScalarFunction op : FULL_TEXT_OPS) {
    private static final Set<AggregateCapability> AGGREGATE_CAPS = Set.of(
    @Override
        if (luceneReader == null) {
import org.opensearch.analytics.spi.SearchExecEngineProvider;
        FULL_TEXT_TYPES.addAll(FieldType.text());
        Set<FilterCapability> caps = new HashSet<>();
import org.opensearch.tasks.CancellableTask;
package org.opensearch.be.lucene;
 * The OpenSearch Contributors require contributions made to
            luceneReader,
     * Lucene-secondary indexes the term dictionary (inverted index) for the same field
     * the existing engine path.
    }
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
    }
            null,  // client
    // ── Lucene-as-driver execution path (count fast path) ──
            }
    // TODO: derive this list from LuceneFieldFactoryRegistry instead of hardcoding.
    }
            }
        ScalarFunction.MATCH,
        ScalarFunction.LESS_THAN_OR_EQUAL,
        return QuerySerializerRegistry.getSerializers();
 * <p>At the data node, the serialized bytes are deserialized back into a {@link QueryBuilder},
    // a serializer; range ops, NOT_EQUALS, IS_NULL, IS_NOT_NULL, IN, LIKE are deferred
            reader.catalogSnapshot(),
    public LuceneAnalyticsBackendPlugin(LucenePlugin plugin) {
import org.opensearch.index.query.QueryShardContext;
            }
        ScalarFunction.MATCHALL
                caps.add(new FilterCapability.Standard(op, STANDARD_TYPES, LUCENE_FORMATS));
 *
        return new BackendCapabilityProvider() {
                return AGGREGATE_CAPS;
    @Override
        return new LuceneFilterDelegationHandle(
import org.opensearch.analytics.spi.DelegatedExpression;
        ScalarFunction.SARG_PREDICATE
        // on self-union delegated scans.
import org.opensearch.analytics.spi.BackendCapabilityProvider;
            Task task = shardCtx.getTask();
        AggregateCapability.simple(AggregateFunction.COUNT, STANDARD_TYPES, LUCENE_FORMATS)
    // an IllegalStateException ("No Lucene serializer for [..]"). Today only EQUALS has
            null,  // indexFieldDataLookup
 * which uses the field name encoded within it to look up the appropriate
    // OpenSearchFilterRule.resolveViableBackends references the same constraint.
        ScalarFunction.IS_NOT_NULL,
        STANDARD_TYPES.add(FieldType.MATCH_ONLY_TEXT);
            () -> true,  // allowExpensiveQueries
            }
            }
            }
                throw new IllegalStateException(
    // operators it can't actually translate, and the failure surfaces at convert time as
    }
import org.apache.logging.log4j.LogManager;
    );
            ctx.getIndexSettings(),
    /**
    private static final Set<FieldType> FULL_TEXT_TYPES = new HashSet<>();
    private static final Set<FilterCapability> FILTER_CAPS;
    // ---- Serializers ----
     * Coupled with the Index scan capability above, this lets PlanForker emit a
import java.util.function.BooleanSupplier;
        return new LuceneFragmentConvertor(QuerySerializerRegistry.getSerializers());
            shardCtx.getNamedWriteableRegistry(),
        STANDARD_TYPES.add(FieldType.TEXT);
            null   // valuesSourceRegistry
import org.apache.logging.log4j.Logger;
}
    private static final Set<ScalarFunction> STANDARD_OPS = Set.of(
            }
        LuceneReader luceneReader = reader.getReader(plugin.getDataFormat(), LuceneReader.class);
    @Override
    public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
import org.opensearch.analytics.spi.DelegationType;
            @Override
/*
        return luceneReader.directoryReader().hasDeletions();
            } else {
    }
            System::currentTimeMillis,
import org.opensearch.analytics.spi.AggregateFunction;
                return SHARD_PREFERENCE;
    // DelegatedPredicateSerializer makes the marking layer pick Lucene as viable for
import org.opensearch.analytics.spi.ScalarFunction;
     * and self-restrict, which the chain-agreement filter at PlanForker enforces.
import org.opensearch.analytics.spi.DelegatedSubtreeConvertor;
        ScalarFunction.GREATER_THAN,
public class LuceneAnalyticsBackendPlugin implements AnalyticsSearchBackendPlugin {
import java.util.Map;
        };
     * scan capability lets the planner mark Lucene viable as a driver for metadata-only
    public DelegatedSubtreeConvertor getDelegatedSubtreeConvertor() {
    }
     * operations (count today, group-by-count and top-K terms in future) over scans whose
import org.opensearch.analytics.spi.FragmentInstructionHandlerFactory;
    );
                return Set.of();
    }
import org.opensearch.analytics.spi.EngineCapability;
        ScalarFunction.MATCH_PHRASE_PREFIX,
import org.opensearch.analytics.spi.AggregateCapability;
            }
/**
import java.util.HashSet;
            if (!(backendContext instanceof LuceneSearcherState state)) {
                return QuerySerializerRegistry.getSerializers();
            @Override
            null,  // xContentRegistry
            null,  // clusterAlias
        ScalarFunction.EQUALS,
    @Override
            null,  // bigArrays
                        + (backendContext == null ? "null" : backendContext.getClass().getName())
        }
            @Override
    private static final BackendShardPreference SHARD_PREFERENCE = new LuceneShardPreference();
        ScalarFunction.LESS_THAN,
    // TODO: have CapabilityRegistry intersect declared FilterCapability against the
                caps.add(new FilterCapability.FullText(op, type, LUCENE_FORMATS, Set.of()));
    public String name() {
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
    public FilterDelegationHandle getFilterDelegationHandle(List<DelegatedExpression> expressions, CommonExecutionContext ctx) {
    }
            null,  // scriptService
    static {
    static {
 * SPDX-License-Identifier: Apache-2.0
     * needing values (Project, Sort) consult value-producing scan capabilities separately
            isCancelled
 * implementations for serializing delegated queries into {@link QueryBuilder} bytes.
    // Lucene's STANDARD filter capabilities must stay in lockstep with the serializers
            null,  // similarityService
 * compatible open source license.
        ScalarFunction.WILDCARD_QUERY,
     */
     */
            null,  // bitsetFilterCache
            queryShardContext,
 *
            for (FieldType type : FULL_TEXT_TYPES) {
    // would cause peer consultation to return null scorers and zero-out candidate sets.
        ShardScanExecutionContext shardCtx = (ShardScanExecutionContext) ctx;
            }
        ScalarFunction.GREATER_THAN_OR_EQUAL,
    private final LucenePlugin plugin;
        this.plugin = plugin;
                return FILTER_CAPS;
            null,  // namedWriteableRegistry
        BooleanSupplier isCancelled = () -> {
    public boolean hasDeletedDocs(ShardScanExecutionContext ctx) {
            searcher,
            public Set<FilterCapability> filterCapabilities() {
            @Override
        return new QueryShardContext(
    private static final Set<FieldType> STANDARD_TYPES = new HashSet<>();
    @Override
        IndexReaderProvider.Reader reader = ctx.getReader();
import org.apache.lucene.search.IndexSearcher;
            public Set<ScanCapability> scanCapabilities() {
 * this file be licensed under the Apache-2.0 license or a
 */
import org.opensearch.index.engine.exec.IndexReaderProvider;
        ScalarFunction.WILDCARD_QUERY_DSL,
        IndexReaderProvider.Reader reader = shardCtx.getReader();
            public Set<AggregateCapability> aggregateCapabilities() {
    /**
        }
    }
    @Override
        IndexSearcher searcher = luceneReader.searcher(shardCtx.getQueryCache(), shardCtx.getQueryCachingPolicy());
        LuceneReader luceneReader = reader.getReader(plugin.getDataFormat(), LuceneReader.class);
            ctx.getMapperService(),
 *
import org.opensearch.analytics.backend.ShardScanExecutionContext;
    // until their serializers land.
            if (op == ScalarFunction.LIKE) {
        return (ctx, backendContext) -> {
                caps.add(new FilterCapability.Standard(op, KEYWORD_ONLY, LUCENE_FORMATS));
import org.opensearch.analytics.spi.FragmentConvertor;
     * Lucene-driver StagePlan alternative for count-shaped fragments without bypassing
 */
            @Override
import org.opensearch.analytics.spi.ScanCapability;
import org.opensearch.analytics.spi.FilterCapability;
            public Set<EngineCapability> supportedEngineCapabilities() {
import org.opensearch.analytics.spi.FilterDelegationHandle;
import java.util.List;
    private static final Set<String> LUCENE_FORMATS = Set.of(LUCENE_FORMAT);
    @Override
            expressions,
        ScalarFunction.IS_NULL,
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
                return SCAN_CAPS;
import org.opensearch.analytics.spi.BackendShardPreference;
    private static final Logger LOGGER = LogManager.getLogger(LuceneAnalyticsBackendPlugin.class);
