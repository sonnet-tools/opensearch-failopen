import org.opensearch.search.internal.SearchContext;
    /**
        UnsupportedSearchParameters.reject(searchSource);
     */  
     *
        int size = searchSource.size() != -1 ? searchSource.size() : SearchService.DEFAULT_SIZE;
                QueryPlans.COUNT_TOTAL_COLUMN
import org.apache.calcite.rel.RelNode;  
    private final SortConverter sortConverter;  
                )
        RelNode base = buildBase(countCtx);  
        this.typeFactory = new SqlTypeFactoryImpl(DslTypeSystems.NANO_TIMESTAMP);
     * Creates a fresh workspace (cluster) for one plan family. Calcite's per-cluster metadata  
     * substitution agree between the aggregation plan and its eligible count.  
        this.sortConverter = new SortConverter();
     * @param schema Calcite schema with index tables from the analytics engine
        // eligible-doc total that sum_other_doc_count is subtracted from. Nested levels carry
            RelNode hits = projectConverter.convert(base, ctx);  
import org.opensearch.search.builder.SearchSourceBuilder;
import org.apache.calcite.sql.type.SqlTypeFactoryImpl;  
        );
            RelCollations.EMPTY,
                false,  
                    false,
                totalServesAsEligibleCount = true;  
            } else {
        this.preAggConverter = new PreAggregateConverter();  
        return aggRegistry;  
        // Aggregation path: Scan → Filter → PreAggregate → Aggregate → [Having] → bound+order
     * </pre>
        if (flatCountPlan != null) {
        return builder.build();  
        RelOptCluster cluster = newCluster();  
            builder.add(new QueryPlans.QueryPlan(QueryPlans.Type.AGGREGATION, aggs, metadata));  
            builder.add(new QueryPlans.QueryPlan(QueryPlans.Type.HITS, hits));
    /**
            false,  
                RelDataTypeField field = base.getRowType().getField(fieldName, false, false);  
                if (field == null) {
            new CalciteConnectionConfigImpl(new Properties())
        RexBuilder rexBuilder = ctx.getRexBuilder();  
    private static final QueryRegistry QUERY_REGISTRY = QueryRegistryFactory.create();  
        RelNode scan = LogicalTableScan.create(ctx.getCluster(), ctx.getTable(), List.of());
import org.apache.calcite.rex.RexBuilder;
        RelOptTable table,  
    private final AggregateConverter aggConverter;
            hits = sortConverter.convert(hits, ctx);
     * @return one or more query plans
     * eligible-count columns, and no {@code missing}-substituted aggregation riding on
        this.aggConverter = new AggregateConverter();
        AggregationMetadata metadata,
                // the same substitution anyway.  
     *   Filter(_count &gt;= min_doc_count)
            Collections.singletonList(""),  
import java.util.Collections;
            rexBuilder.makeLiteral(metadata.getHavingMinDocCount(), bigint, false)
        return AggregationMetadata.pathKey(aggNamePath);
                );  
     * eligible-doc count (the total {@code sum_other_doc_count} is subtracted from).
        ConversionContext ctx = new ConversionContext(searchSource, newCluster(), table).withAggregationMetadata(metadata);
    private RelNode buildFlatCountPlan(
            && searchSource.aggregations().getAggregatorFactories() != null
    }  
                    throw new ConversionException(
            SqlStdOperatorTable.GREATER_THAN_OR_EQUAL,
import java.util.ArrayList;
        ConversionContext countCtx = new ConversionContext(searchSource, newCluster(), table);
        return searchSource.aggregations() != null  
                    -1,
    private final PostAggregateConverter postAggConverter;  
    /** Builds a plan family's private base — Scan → Filter — inside the context's own workspace. */
            } else if (metadata.eligibleDocCountIsTotal()) {
     *
    private final PreAggregateConverter preAggConverter;
     *  
        // Accounting: a bounded root plan discards its tail engine-side, so each needs the  
     * Initializes planning infrastructure from the given schema.  
                    throw new ConversionException("Group-by field '" + fieldName + "' not found in schema");
        }  
        // Hits path: Scan → Filter → Project → Sort  
            AggregateCall.create(
    private final AggregationRegistry aggRegistry;
     *        mapping-dependent validation and fails terms rendering.
        );
    }  
import org.apache.calcite.prepare.CalciteCatalogReader;
            calls.add(  
/**  
import org.apache.calcite.rel.logical.LogicalFilter;  
            false,
                bigint,
    private static String aggPathKey(List<String> aggNamePath) {
    ) throws ConversionException {
            AggregationMetadataBuilder.IMPLICIT_COUNT_NAME
     * @param schema Calcite schema with index tables from the analytics engine
import org.opensearch.dsl.aggregation.AggregationRegistryFactory;  
    private final RelDataTypeFactory typeFactory;
        RelDataType bigint = countCtx.getCluster().getTypeFactory().createSqlType(SqlTypeName.BIGINT);
                }
        this.aggRegistry = AggregationRegistryFactory.create(mapperServiceSupplier);  
                    QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + entry.getKey()
            String aggName = metadata.getAggNamePath().get(0); // fetch implies a root-level, single-field plan  
        RelNode base = buildBase(ctx);
                }  
        RelOptTable table,
            SqlStdOperatorTable.COUNT,
import org.opensearch.dsl.aggregation.AggregationTreeWalker;
        if (trackTotalHitsDisabled && eligibleFieldByAggName.isEmpty() && !totalServesAsEligibleCount) {
     * Built over an identically-constructed pre-aggregate input — its own workspace and nodes
        calls.add(
            -1,
import org.apache.calcite.plan.hep.HepProgram;  
     * @throws ConversionException if DSL conversion fails  
                SqlStdOperatorTable.COUNT,  
        // main plans and must not share their cluster or nodes (see newCluster). The rebuilt  
    /** Returns the aggregation registry used by this converter. */
     * as cycles ({@code CyclicMetadataException}). Plans the engine may plan concurrently must  
            && !searchSource.aggregations().getAggregatorFactories().isEmpty();
    /** Immutable after creation with stateless translators — shared across all requests. */
    private RelOptCluster newCluster() {
     * the cluster it was created in, and metadata lookups follow {@code node.getCluster()}.
                // missing substitution makes every matching doc eligible — COUNT(*) serves
        for (AggregationMetadata metadata : metadataList) {
import org.apache.calcite.plan.hep.HepPlanner;
import org.opensearch.dsl.query.QueryRegistry;  
        this.projectConverter = new ProjectConverter();  
     * {@code COUNT(*)}.  
        this(schema, () -> null);
     * cache is not thread-safe, and its cycle detection assumes a single planning thread —
            }
        return filterConverter.convert(scan, ctx);
        CalciteSchema rootSchema = CalciteSchema.from(schema);  
            RelNode aggs = aggConverter.convert(aggInput, metadata);  
            throw new IllegalArgumentException("Index not found in schema: " + indexName);  
    public QueryPlans convert(SearchSourceBuilder searchSource, String indexName) throws ConversionException {
            aggs = postAggConverter.convert(aggs, aggCtx);
        // concurrently with these plans and must not share a metadata cache (see newCluster).
            ConversionContext aggCtx = ctx.withAggregationMetadata(metadata);  
/*  
        boolean hasAggs = hasAggregations(searchSource);
    private final CalciteCatalogReader catalogReader;  
        boolean totalServesAsEligibleCount = false;
                    new QueryPlans.QueryPlan(QueryPlans.Type.COUNT, buildHavingEligibleCountPlan(searchSource, table, metadata, aggName))
    }
        return LogicalAggregate.create(base, ImmutableBitSet.of(), null, calls);
    private final AggregationTreeWalker treeWalker;
            typeFactory,
                // the threshold trumps substitution, and the plan's pre-aggregate input applies
                builder.add(
        // theirs inline as the _parent_eligible window column; unbounded plans discard nothing.
}
     *
            rexBuilder.makeInputRef(countField.getType(), countField.getIndex()),  
import org.apache.calcite.config.CalciteConnectionConfigImpl;
import org.apache.calcite.rel.type.RelDataTypeField;
                // count can see — it needs its own HAVING-filtered plan. Checked before missing:
import java.util.Properties;  
        // size=0 skips hits — total doc count comes from analytics plugin metadata
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
public class SearchSourceConverter {  
        );
            SqlStdOperatorTable.SUM,
     * Builds the single-row flat COUNT plan: {@code COUNT(*)} for {@code hits.total}, plus one  
                eligibleFieldByAggName.put(aggName, field.getIndex());
 */  
        // nested levels additionally semi-join their parent level's plan for the per-parent bound)
                aggCtx = aggCtx.withParentPlan(parentPlan);  
        }
     * Builds the eligible-count plan for a {@code min_doc_count} > 1  
    private final FilterConverter filterConverter;
            : List.of();
        // The walker emits parents before their children, so a child's parent plan is
        SearchSourceBuilder searchSource,
                // (classic reduce drops them without counting them as "other"), which no flat  
            if (metadata.getPerParentFetch() != null) {
import java.util.Map;
        // (one plan per bucket aggregation — size, min_doc_count, and order are baked in;  
        RelOptTable table = catalogReader.getTable(List.of(indexName));
import org.opensearch.dsl.executor.QueryPlans;
     * <pre>  
     * <p>Returns null when nothing needs counting: {@code track_total_hits: false}, no
     */
                    false,  
import org.apache.calcite.jdbc.CalciteSchema;
        // always already built when the child needs it as its semi-join input.  
        // base has the same row type, so the eligible-count field indices stay valid.
        RelNode grouped = LogicalAggregate.create(aggInput, metadata.getGroupByBitSet(), null, List.of(groupCount));  
package org.opensearch.dsl.converter;
            builtPlansByPath.put(aggPathKey(metadata.getAggNamePath()), aggs);
 * <p>Builds its own Calcite planning infrastructure from the {@link SchemaPlus} provided  
    /**
    }  
        AggregateCall groupCount = AggregateCall.create(
     * therefore not share a cluster, nor any {@code RelNode}: a node is permanently bound to
            false,  
            List.of(),  
import org.apache.calcite.util.ImmutableBitSet;
import org.apache.calcite.rel.core.AggregateCall;
import org.apache.calcite.sql.type.SqlTypeName;
                    List.of(entry.getValue()),  
        RexNode threshold = rexBuilder.makeCall(
import org.opensearch.dsl.aggregation.AggregationMetadata;  
        }  
        boolean trackTotalHitsDisabled = searchSource.trackTotalHitsUpTo() != null
        List<AggregationMetadata> metadataList = hasAggs
 * by the analytics engine.
     */
        this.catalogReader = new CalciteCatalogReader(
            );  
        RelDataType bigint = ctx.getCluster().getTypeFactory().createSqlType(SqlTypeName.BIGINT);
        }
        this.filterConverter = new FilterConverter(QUERY_REGISTRY);
    private final ProjectConverter projectConverter;
 * The OpenSearch Contributors require contributions made to  
            -1,  
    private RelNode buildHavingEligibleCountPlan(
        AggregateCall sum = AggregateCall.create(  
        Map<String, Integer> eligibleFieldByAggName = new LinkedHashMap<>();  
     * aggregation: total documents in the groups that pass the threshold.
     */  
import org.opensearch.index.mapper.MapperService;
        RelDataTypeField countField = grouped.getRowType().getField(AggregationMetadataBuilder.IMPLICIT_COUNT_NAME, false, false);
            )  
            false,
        // no need to reconstruct typeFactory, CatalogReader, and planning infrastructure here.  
            return null;
            bigint,  
    }  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
            List.of(countField.getIndex()),
     *       &lt;pre-aggregate input, rebuilt in this plan's own workspace&gt;
                List.of(),
     * concurrent metadata queries over a shared cache misread each other's in-progress markers
     *  
    private static boolean hasAggregations(SearchSourceBuilder searchSource) {
import org.apache.calcite.rel.logical.LogicalAggregate;
    /**  
                AggregateCall.create(
            false,
            && searchSource.trackTotalHitsUpTo() == SearchContext.TRACK_TOTAL_HITS_DISABLED;  
 */
import org.apache.calcite.rel.type.RelDataType;
     * @param searchSource the DSL query  
        List<AggregateCall> calls = new ArrayList<>();  
     * (see {@link #newCluster}), same converters — so null exclusion and {@code missing}
                    SqlStdOperatorTable.COUNT,
            RelNode aggInput = preAggConverter.convert(base, aggCtx);
     * Aggregate(SUM(_count) AS _eligible$&lt;aggName&gt;)
 * this file be licensed under the Apache-2.0 license or a
    }  
    public AggregationRegistry getAggregationRegistry() {
    }
import org.opensearch.search.SearchService;  
            RelCollations.EMPTY,
     */
        }
                    false,
                false,
    }
            rootSchema,
            false,
                false,
                        "Parent plan not built before nested plan [" + String.join(",", path) + "] — walker order broken"  
import org.apache.calcite.plan.RelOptTable;
    ) throws ConversionException {
                RelCollations.EMPTY,  
 * Converts {@link SearchSourceBuilder} DSL into Calcite {@link QueryPlans}.
     * terms rendering fails without a MapperService. Intended for tests.  
                -1,
        // Private workspace + rebuilt Scan → Filter: this plan executes concurrently with the
     * Initializes planning infrastructure without mapping resolution — conversion-only use;
     * @param mapperServiceSupplier supplies the target index's MapperService for response key  
 *
                if (parentPlan == null) {
        }  
                    bigint,  
import org.apache.calcite.rel.RelCollations;
                    );
        SearchSourceBuilder searchSource,  
    /** Canonical plan key — see {@link AggregationMetadata#pathKey}. */  
        for (Map.Entry<String, Integer> entry : eligibleFieldByAggName.entrySet()) {
            }
        String aggName  
            if (metadata.getFetch() == null) {  
 * compatible open source license.
     * Converts DSL for the given index into query plans.
import org.apache.calcite.rel.logical.LogicalTableScan;
    private RelNode buildBase(ConversionContext ctx) throws ConversionException {  
        Map<String, Integer> eligibleFieldByAggName,
                RelNode parentPlan = builtPlansByPath.get(aggPathKey(path.subList(0, path.size() - 1)));  
        if (table == null) {
     *     Aggregate(GROUP BY field, COUNT(*) AS _count)  
import org.apache.calcite.plan.RelOptCluster;  
        Map<String, RelNode> builtPlansByPath = new LinkedHashMap<>();
            if (metadata.getHavingMinDocCount() != null) {
        if (size > 0) {
 *
 * SPDX-License-Identifier: Apache-2.0
        this.postAggConverter = new PostAggregateConverter();
     * null-skipping {@code COUNT(field)} per bounded root aggregation as its
import org.opensearch.dsl.query.QueryRegistryFactory;
import java.util.List;
                    RelCollations.EMPTY,
        // plans below build in their own workspaces: they are submitted to the engine
        RelNode filtered = LogicalFilter.create(grouped, threshold);  
import org.opensearch.dsl.aggregation.AggregationRegistry;
        return LogicalAggregate.create(filtered, ImmutableBitSet.of(), null, List.of(sum));
        // Request-scoped workspace for the hits/aggregation plans. The count and eligible-count  
            }
     * @param indexName target index
        RelDataType nullableBigint = ctx.getCluster().getTypeFactory().createTypeWithNullability(bigint, true);
            nullableBigint,
            builder.add(new QueryPlans.QueryPlan(QueryPlans.Type.COUNT, flatCountPlan));  
        // ignoring them and returning wrong results with 200.
                // min_doc_count > 1: the eligible count must exclude below-threshold groups
        QueryPlans.Builder builder = new QueryPlans.Builder();
    /**
     *        type and format resolution; evaluated lazily. Supplying null skips
import java.util.LinkedHashMap;  
        }
    /**
        // Fail loudly (400) on features this path does not implement, instead of silently  
            QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + aggName  
import org.apache.calcite.rex.RexNode;  
                continue;
     *
import org.apache.calcite.schema.SchemaPlus;
        );  
    public SearchSourceConverter(SchemaPlus schema) {
            ? treeWalker.walk(searchSource.aggregations().getAggregatorFactories(), table.getRowType(), cluster.getTypeFactory())  
    public SearchSourceConverter(SchemaPlus schema, Supplier<MapperService> mapperServiceSupplier) {
                List<String> path = metadata.getAggNamePath();
        ConversionContext ctx = new ConversionContext(searchSource, cluster, table);
        return RelOptCluster.create(new HepPlanner(HepProgram.builder().build()), new RexBuilder(typeFactory));
    }  
        for (AggregationMetadata metadata : metadataList) {
        RelNode aggInput = preAggConverter.convert(buildBase(ctx), ctx);  
        boolean totalServesAsEligibleCount  
        this.treeWalker = new AggregationTreeWalker(aggRegistry);
    }  
                String fieldName = metadata.getGroupByFieldNames().get(0);
     */  
        // TODO: Once Analytics plugin starts providing the RelOptTable, use it directly —
import java.util.function.Supplier;
import org.opensearch.dsl.aggregation.AggregationMetadataBuilder;
        );
        RelNode flatCountPlan = buildFlatCountPlan(table, eligibleFieldByAggName, searchSource, totalServesAsEligibleCount);
