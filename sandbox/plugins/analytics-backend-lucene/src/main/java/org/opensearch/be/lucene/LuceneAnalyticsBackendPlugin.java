 * Analytics SPI extension for the Lucene backend. Declares filter capabilities
            ctx.getMapperService(),
    @Override
        if (luceneReader == null) {
import java.util.HashSet;  
    /** Package-private — also reused by {@link LuceneScanInstructionHandler} in driver mode. */
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;  
            queryShardContext,
            }  
    @Override
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    private static final Set<String> LUCENE_FORMATS = Set.of(LUCENE_FORMAT);
        return new LuceneFragmentConvertor(QuerySerializerRegistry.getSerializers());  
import org.opensearch.analytics.spi.EngineCapability;  
}  
    );
    // backend's serializer keyset at startup so this list can't drift again. The TODO in  
                return AGGREGATE_CAPS;
            null,  // similarityService
            return task instanceof CancellableTask ct && ct.isCancelled();
    }
    // TODO: derive this list from LuceneFieldFactoryRegistry instead of hardcoding.  
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
     * Lucene-driver StagePlan alternative for count-shaped fragments without bypassing  
import org.opensearch.analytics.spi.FragmentConvertor;
            null,  // namedWriteableRegistry
                        + (backendContext == null ? "null" : backendContext.getClass().getName())
import org.opensearch.tasks.CancellableTask;  
import org.opensearch.analytics.spi.ScanCapability;
    }  
     */  
        // on self-union delegated scans.
    }
    private static final Set<ScalarFunction> FULL_TEXT_OPS = Set.of(  
        ScalarFunction.MATCH,
    }
    static {  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
    public FragmentConvertor getFragmentConvertor() {
        this.plugin = plugin;
    }
 * implementations for serializing delegated queries into {@link QueryBuilder} bytes.  
    public FragmentInstructionHandlerFactory getInstructionHandlerFactory() {
/*  
import org.opensearch.index.query.QueryBuilder;
            expressions,
import java.util.List;
    private static final Set<ScalarFunction> STANDARD_OPS = Set.of(
            null,  // scriptService  
        ScalarFunction.REGEXP,
        ScalarFunction.MATCHALL  
            public Set<EngineCapability> supportedEngineCapabilities() {
    public String name() {
    public BackendCapabilityProvider getCapabilityProvider() {
    // ---- Serializers ----
    // an IllegalStateException ("No Lucene serializer for [..]"). Today only EQUALS has
        // Shared per-reader searcher (see LuceneReader#searcher) — a fresh one here crashes the node
            ctx.getIndexSettings(),  
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
     * types it accepts filters on — keyword / text / match_only_text. The Index  
                return QuerySerializerRegistry.getSerializers();  
        ScalarFunction.IS_NULL,
     */
import org.opensearch.analytics.spi.FilterDelegationHandle;  
    public SearchExecEngineProvider getSearchExecEngineProvider() {  
    private static final Set<FilterCapability> FILTER_CAPS;
import java.util.Set;  
        ScalarFunction.QUERY,
        }
    // Lucene's STANDARD filter capabilities must stay in lockstep with the serializers
import org.opensearch.index.engine.exec.IndexReaderProvider;  
        ScalarFunction.GREATER_THAN_OR_EQUAL,  
    public FilterDelegationHandle getFilterDelegationHandle(List<DelegatedExpression> expressions, CommonExecutionContext ctx) {  
    public boolean hasDeletedDocs(ShardScanExecutionContext ctx) {
            null,  // indexFieldDataLookup  
            null,  // bigArrays
    private static final Set<AggregateCapability> AGGREGATE_CAPS = Set.of(  
        ScalarFunction.QUERY_STRING,  
    }  
        LuceneReader luceneReader = reader.getReader(plugin.getDataFormat(), LuceneReader.class);  
                return SCAN_CAPS;  
        LuceneReader luceneReader = reader.getReader(plugin.getDataFormat(), LuceneReader.class);
    // Field types Lucene's secondary data format actually indexes (see LuceneFieldFactoryRegistry).  
        ScalarFunction.EQUALS,  
        }
    }
            }
            } else {
        };
            for (FieldType type : FULL_TEXT_TYPES) {  
    }  
        ScalarFunction.LESS_THAN_OR_EQUAL,
     * operations (count today, group-by-count and top-K terms in future) over scans whose
            public Set<AggregateCapability> aggregateCapabilities() {
    // TODO: have CapabilityRegistry intersect declared FilterCapability against the
    // operators it can't actually translate, and the failure surfaces at convert time as
            if (!(backendContext instanceof LuceneSearcherState state)) {
 *
            @Override
            () -> true,  // allowExpensiveQueries
            public Set<DelegationType> acceptedDelegations() {  
        IndexSearcher searcher = luceneReader.searcher(shardCtx.getQueryCache(), shardCtx.getQueryCachingPolicy());  
        IndexReaderProvider.Reader reader = shardCtx.getReader();
            shardCtx.getNamedWriteableRegistry(),
        ScalarFunction.MATCH_BOOL_PREFIX,  
 */
    static {
        ScalarFunction.SARG_PREDICATE  
import org.opensearch.analytics.spi.BackendShardPreference;  
     * fields are listed here. It does NOT imply Lucene can deliver row values; consumers  
            }
    private static final Set<ScanCapability> SCAN_CAPS = Set.of(new ScanCapability.Index(LUCENE_FORMATS, STANDARD_TYPES));
                caps.add(new FilterCapability.Standard(op, KEYWORD_ONLY, LUCENE_FORMATS));  
                return FILTER_CAPS;
import java.util.function.BooleanSupplier;
            null,  // bitsetFilterCache
        for (ScalarFunction op : STANDARD_OPS) {
    // would cause peer consultation to return null scorers and zero-out candidate sets.
package org.opensearch.be.lucene;
        ScalarFunction.WILDCARD_QUERY,
        ScalarFunction.IS_NOT_NULL,  
    // Numeric/date/boolean fields are not indexed under composite-parquet primary, so listing them
import org.opensearch.analytics.spi.FilterCapability;
 */  
            if (op == ScalarFunction.LIKE) {
import org.opensearch.analytics.spi.SearchExecEngineProvider;
        ScalarFunction.MULTI_MATCH,
        return luceneReader.directoryReader().hasDeletions();
            null,  // client  
        FULL_TEXT_TYPES.addAll(FieldType.keyword());
/**  
            }  
 *
     * the existing engine path.
            luceneReader,  
        AggregateCapability.simple(AggregateFunction.COUNT, STANDARD_TYPES, LUCENE_FORMATS)
            @Override  
    @Override  
        return QuerySerializerRegistry.getSerializers();
            reader.catalogSnapshot(),
        ShardScanExecutionContext shardCtx = (ShardScanExecutionContext) ctx;
import org.opensearch.analytics.spi.ScalarFunction;  
                caps.add(new FilterCapability.FullText(op, type, LUCENE_FORMATS, Set.of()));
            isCancelled  
            null   // valuesSourceRegistry  
import org.apache.lucene.search.IndexSearcher;  
        return new BackendCapabilityProvider() {
        }  
            }
    @Override
        Set<FilterCapability> caps = new HashSet<>();  
    public DelegatedSubtreeConvertor getDelegatedSubtreeConvertor() {  
            null,  // clusterAlias  
    // DelegatedPredicateSerializer makes the marking layer pick Lucene as viable for  
     * Lucene-secondary indexes the term dictionary (inverted index) for the same field
            @Override
            }
            searcher,
    @Override
import org.apache.logging.log4j.LogManager;
    // registered in QuerySerializerRegistry — declaring a capability without a matching
    public LuceneAnalyticsBackendPlugin(LucenePlugin plugin) {  
        ScalarFunction.LESS_THAN,
    }  
    }  
        );
     * Coupled with the Index scan capability above, this lets PlanForker emit a
        };
            null,  // xContentRegistry
import org.opensearch.analytics.spi.CommonExecutionContext;
    private static final String LUCENE_FORMAT = LuceneDataFormat.LUCENE_FORMAT_NAME;
        BooleanSupplier isCancelled = () -> {
    /**  
                return Set.of(DelegationType.FILTER);
    );
import org.opensearch.analytics.spi.FragmentInstructionHandlerFactory;
            public BackendShardPreference shardPreference() {
        FULL_TEXT_TYPES.addAll(FieldType.text());
     * scan capability lets the planner mark Lucene viable as a driver for metadata-only
    // OpenSearchFilterRule.resolveViableBackends references the same constraint.
            Task task = shardCtx.getTask();  
    static {
        return (ctx, backendContext) -> {
        IndexReaderProvider.Reader reader = ctx.getReader();  
import org.apache.logging.log4j.Logger;
        );
        STANDARD_TYPES.add(FieldType.KEYWORD);  
        return new LuceneSubtreeConvertor(QuerySerializerRegistry.getSerializers());
 * The OpenSearch Contributors require contributions made to  
 * which uses the field name encoded within it to look up the appropriate  
 * {@link org.opensearch.index.mapper.MappedFieldType} and create the Lucene query.
        STANDARD_TYPES.add(FieldType.MATCH_ONLY_TEXT);
        };
     * Lucene drives count(*) and (in a follow-up) count(col) over fields it indexes.
    private static final Set<FieldType> STANDARD_TYPES = new HashSet<>();
            }  
            @Override
        ScalarFunction.LIKE,
            return engine;
import org.opensearch.analytics.spi.BackendCapabilityProvider;
import org.opensearch.analytics.spi.AggregateCapability;
    @Override
    }
import org.opensearch.tasks.Task;
        FILTER_CAPS = caps;
import org.opensearch.analytics.backend.ShardScanExecutionContext;
    public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
 * <p>At the data node, the serialized bytes are deserialized back into a {@link QueryBuilder},
            return false;  
                caps.add(new FilterCapability.Standard(op, STANDARD_TYPES, LUCENE_FORMATS));
                throw new IllegalStateException(  
        ScalarFunction.PREFIX_QUERY,  
            engine.prepare(ctx);  
        ScalarFunction.FUZZY,
            LuceneSearchExecEngine engine = new LuceneSearchExecEngine(state);
        ScalarFunction.SIMPLE_QUERY_STRING,
        ScalarFunction.NOT_EQUALS,
        return new LuceneFilterDelegationHandle(  
            s -> true,  // indexNameMatcher
    @Override
            }
        QueryShardContext queryShardContext = buildMinimalQueryShardContext(shardCtx, searcher);
            public Set<ScanCapability> scanCapabilities() {
    // ── Lucene-as-driver execution path (count fast path) ──
    private final LucenePlugin plugin;
            public Set<FilterCapability> filterCapabilities() {  
    }
    }
                return Set.of();
    );
        return new QueryShardContext(
            System::currentTimeMillis,
    private static final BackendShardPreference SHARD_PREFERENCE = new LuceneShardPreference();
        ScalarFunction.MATCH_PHRASE_PREFIX,
import org.opensearch.analytics.spi.DelegatedSubtreeConvertor;
    @Override  
import org.opensearch.index.query.QueryShardContext;
import org.opensearch.analytics.spi.FieldType;
                );  
    @Override  
    }  
 * @opensearch.internal  
                    "Lucene SearchExecEngineProvider expected LuceneSearcherState but got "
            }
import org.opensearch.analytics.spi.DelegatedExpression;
        ScalarFunction.WILDCARD_QUERY_DSL,
 *
    static QueryShardContext buildMinimalQueryShardContext(ShardScanExecutionContext ctx, IndexSearcher searcher) {  
            @Override  
        return new LuceneInstructionHandlerFactory(plugin);
        ScalarFunction.MATCH_PHRASE,
        for (ScalarFunction op : FULL_TEXT_OPS) {
                return SHARD_PREFERENCE;
     * needing values (Project, Sort) consult value-producing scan capabilities separately
            @Override
        ScalarFunction.WILDCARD,  
            0,
    // a serializer; range ops, NOT_EQUALS, IS_NULL, IS_NOT_NULL, IN, LIKE are deferred  
    // until their serializers land.
        return LuceneDataFormat.LUCENE_FORMAT_NAME;  
            }  
 * for full-text and standard predicates, and provides {@link DelegatedPredicateSerializer}
public class LuceneAnalyticsBackendPlugin implements AnalyticsSearchBackendPlugin {
import org.opensearch.analytics.spi.AggregateFunction;  
        STANDARD_TYPES.add(FieldType.TEXT);
    private static final Set<FieldType> KEYWORD_ONLY = Set.of(FieldType.KEYWORD);
    private static final Set<FieldType> FULL_TEXT_TYPES = new HashSet<>();
        ScalarFunction.GREATER_THAN,
    private static final Logger LOGGER = LogManager.getLogger(LuceneAnalyticsBackendPlugin.class);  
    /**
import org.opensearch.analytics.spi.DelegationType;
            @Override  
     * and self-restrict, which the chain-agreement filter at PlanForker enforces.
