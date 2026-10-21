    /** Returns the aggregation registry used by this converter. */
            List.of(countField.getIndex()),
            false,
     *
        // main plans and must not share their cluster or nodes (see newCluster). The rebuilt
        this.projectConverter = new ProjectConverter();
import org.apache.calcite.schema.SchemaPlus;
            ? treeWalker.walk(searchSource.aggregations().getAggregatorFactories(), table.getRowType(), cluster.getTypeFactory())
    ) throws ConversionException {
    private final AggregationTreeWalker treeWalker;
        RelNode aggInput = preAggConverter.convert(buildBase(ctx), ctx);
            RelCollations.EMPTY,
    private final ProjectConverter projectConverter;
            List.of(),
            nullableBigint,
        return LogicalAggregate.create(base, ImmutableBitSet.of(), null, calls);
        Map<String, RelNode> builtPlansByPath = new LinkedHashMap<>();
import org.apache.calcite.rel.logical.LogicalTableScan;
     * substitution agree between the aggregation plan and its eligible count.
        Map<String, Integer> eligibleFieldByAggName,
        boolean totalServesAsEligibleCount = false;
        return searchSource.aggregations() != null
 *
                List<String> path = metadata.getAggNamePath();
     * concurrent metadata queries over a shared cache misread each other's in-progress markers
     * <pre>
     *        type and format resolution; evaluated lazily. Supplying null skips
    public SearchSourceConverter(SchemaPlus schema) {
import org.apache.calcite.rel.RelCollations;
            : List.of();
        return AggregationMetadata.pathKey(aggNamePath);
     * @param indexName target index
import org.apache.calcite.rel.type.RelDataType;
        this.treeWalker = new AggregationTreeWalker(aggRegistry);
                List.of(),
     * as cycles ({@code CyclicMetadataException}). Plans the engine may plan concurrently must
public class SearchSourceConverter {
        return RelOptCluster.create(new HepPlanner(HepProgram.builder().build()), new RexBuilder(typeFactory));
                    RelCollations.EMPTY,
    private final PreAggregateConverter preAggConverter;
        // Aggregation path: Scan → Filter → PreAggregate → Aggregate → [Having] → bound+order
     * </pre>
            RelNode aggInput = preAggConverter.convert(base, aggCtx);
import org.opensearch.dsl.aggregation.AggregationRegistryFactory;
        return filterConverter.convert(scan, ctx);
import org.apache.calcite.rel.logical.LogicalFilter;
import org.apache.calcite.sql.type.SqlTypeName;
        // eligible-doc total that sum_other_doc_count is subtracted from. Nested levels carry
        }
package org.opensearch.dsl.converter;
    /** Immutable after creation with stateless translators — shared across all requests. */
            hits = sortConverter.convert(hits, ctx);
            SqlStdOperatorTable.SUM,
            false,
        // Private workspace + rebuilt Scan → Filter: this plan executes concurrently with the
     */
     */
import org.apache.calcite.sql.type.SqlTypeFactoryImpl;
        RelNode base = buildBase(countCtx);
        );
import org.apache.calcite.util.ImmutableBitSet;
        // Request-scoped workspace for the hits/aggregation plans. The count and eligible-count
     * Built over an identically-constructed pre-aggregate input — its own workspace and nodes
        RelOptTable table = catalogReader.getTable(List.of(indexName));
            } else if (metadata.eligibleDocCountIsTotal()) {
     *   Filter(_count &gt;= min_doc_count)
                    -1,
     *
                    );
            String aggName = metadata.getAggNamePath().get(0); // fetch implies a root-level, single-field plan
    }
                builder.add(
        RexNode threshold = rexBuilder.makeCall(
                false,
import org.opensearch.dsl.aggregation.AggregationMetadataBuilder;
     *
                    bigint,
        SearchSourceBuilder searchSource,
        RelOptTable table,
}
        boolean trackTotalHitsDisabled = searchSource.trackTotalHitsUpTo() != null
     * @param mapperServiceSupplier supplies the target index's MapperService for response key
        QueryPlans.Builder builder = new QueryPlans.Builder();
            }
            rexBuilder.makeInputRef(countField.getType(), countField.getIndex()),
                }
     * aggregation: total documents in the groups that pass the threshold.
 * The OpenSearch Contributors require contributions made to
 * Converts {@link SearchSourceBuilder} DSL into Calcite {@link QueryPlans}.
        this.aggRegistry = AggregationRegistryFactory.create(mapperServiceSupplier);
     * @param schema Calcite schema with index tables from the analytics engine
            rootSchema,
    /** Builds a plan family's private base — Scan → Filter — inside the context's own workspace. */
        this.filterConverter = new FilterConverter(QUERY_REGISTRY);
                // the same substitution anyway.
import org.opensearch.search.SearchService;
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.rel.type.RelDataTypeField;
     * terms rendering fails without a MapperService. Intended for tests.
     */
        RelNode base = buildBase(ctx);
                    SqlStdOperatorTable.COUNT,
import org.opensearch.dsl.query.QueryRegistryFactory;
        // (one plan per bucket aggregation — size, min_doc_count, and order are baked in;
                String fieldName = metadata.getGroupByFieldNames().get(0);
                RelNode parentPlan = builtPlansByPath.get(aggPathKey(path.subList(0, path.size() - 1)));
     * (see {@link #newCluster}), same converters — so null exclusion and {@code missing}
            RelNode hits = projectConverter.convert(base, ctx);
        RelNode flatCountPlan = buildFlatCountPlan(table, eligibleFieldByAggName, searchSource, totalServesAsEligibleCount);
 */
        String aggName
                SqlStdOperatorTable.COUNT,
import org.opensearch.dsl.aggregation.AggregationRegistry;
import java.util.Map;
    /**
import org.apache.calcite.plan.hep.HepPlanner;
import org.apache.calcite.plan.RelOptCluster;
        ConversionContext ctx = new ConversionContext(searchSource, newCluster(), table).withAggregationMetadata(metadata);
     * Converts DSL for the given index into query plans.
            }
        // ignoring them and returning wrong results with 200.
        for (AggregationMetadata metadata : metadataList) {
            SqlStdOperatorTable.COUNT,
import org.opensearch.dsl.aggregation.AggregationTreeWalker;
            rexBuilder.makeLiteral(metadata.getHavingMinDocCount(), bigint, false)
                // (classic reduce drops them without counting them as "other"), which no flat
import org.apache.calcite.rel.core.AggregateCall;
    private final AggregationRegistry aggRegistry;
        if (size > 0) {
                if (parentPlan == null) {
        List<AggregateCall> calls = new ArrayList<>();
     *       &lt;pre-aggregate input, rebuilt in this plan's own workspace&gt;
    private RelNode buildBase(ConversionContext ctx) throws ConversionException {
        AggregationMetadata metadata,
    /**
        AggregateCall sum = AggregateCall.create(
            builder.add(new QueryPlans.QueryPlan(QueryPlans.Type.COUNT, flatCountPlan));
     * @return one or more query plans
            QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + aggName
        SearchSourceBuilder searchSource,
import java.util.Properties;
     * Builds the eligible-count plan for a {@code min_doc_count} > 1
        // nested levels additionally semi-join their parent level's plan for the per-parent bound)
        boolean totalServesAsEligibleCount
        }
            RelNode aggs = aggConverter.convert(aggInput, metadata);
import org.apache.calcite.config.CalciteConnectionConfigImpl;
        CalciteSchema rootSchema = CalciteSchema.from(schema);
     *
                    throw new ConversionException(
import org.opensearch.dsl.query.QueryRegistry;
    /**
        }
        // concurrently with these plans and must not share a metadata cache (see newCluster).
    /**
        RelDataType nullableBigint = ctx.getCluster().getTypeFactory().createTypeWithNullability(bigint, true);
        }
            false,
        );
        // theirs inline as the _parent_eligible window column; unbounded plans discard nothing.
            && searchSource.trackTotalHitsUpTo() == SearchContext.TRACK_TOTAL_HITS_DISABLED;
     * <p>Returns null when nothing needs counting: {@code track_total_hits: false}, no
            Collections.singletonList(""),
                // count can see — it needs its own HAVING-filtered plan. Checked before missing:
            && searchSource.aggregations().getAggregatorFactories() != null
            SqlStdOperatorTable.GREATER_THAN_OR_EQUAL,
                QueryPlans.COUNT_TOTAL_COLUMN
                continue;
    public SearchSourceConverter(SchemaPlus schema, Supplier<MapperService> mapperServiceSupplier) {
     * Aggregate(SUM(_count) AS _eligible$&lt;aggName&gt;)
        if (flatCountPlan != null) {
import org.apache.calcite.rel.type.RelDataTypeFactory;
            false,
    }
            typeFactory,
        List<AggregationMetadata> metadataList = hasAggs
        return LogicalAggregate.create(filtered, ImmutableBitSet.of(), null, List.of(sum));
     *        mapping-dependent validation and fails terms rendering.
     * {@code COUNT(*)}.
        this.catalogReader = new CalciteCatalogReader(
     * Builds the single-row flat COUNT plan: {@code COUNT(*)} for {@code hits.total}, plus one
    private final FilterConverter filterConverter;
 */
    private static final QueryRegistry QUERY_REGISTRY = QueryRegistryFactory.create();
            ConversionContext aggCtx = ctx.withAggregationMetadata(metadata);
            if (metadata.getFetch() == null) {
                    new QueryPlans.QueryPlan(QueryPlans.Type.COUNT, buildHavingEligibleCountPlan(searchSource, table, metadata, aggName))
        RelDataType bigint = countCtx.getCluster().getTypeFactory().createSqlType(SqlTypeName.BIGINT);
        RelNode filtered = LogicalFilter.create(grouped, threshold);
    private RelOptCluster newCluster() {
                bigint,
                -1,
import java.util.function.Supplier;
                )
                    false,
    }
 * this file be licensed under the Apache-2.0 license or a
        // TODO: Once Analytics plugin starts providing the RelOptTable, use it directly —
        UnsupportedSearchParameters.reject(searchSource);
            AggregationMetadataBuilder.IMPLICIT_COUNT_NAME
        return builder.build();
        ConversionContext countCtx = new ConversionContext(searchSource, newCluster(), table);
/**
                // missing substitution makes every matching doc eligible — COUNT(*) serves
            && !searchSource.aggregations().getAggregatorFactories().isEmpty();
import org.apache.calcite.rel.RelNode;
                    false,
                RelCollations.EMPTY,
        );
        // Accounting: a bounded root plan discards its tail engine-side, so each needs the
     * @throws ConversionException if DSL conversion fails
import org.opensearch.search.builder.SearchSourceBuilder;
            builder.add(new QueryPlans.QueryPlan(QueryPlans.Type.HITS, hits));
        return aggRegistry;
            throw new IllegalArgumentException("Index not found in schema: " + indexName);
    }
            if (metadata.getPerParentFetch() != null) {
                        "Parent plan not built before nested plan [" + String.join(",", path) + "] — walker order broken"
                    List.of(entry.getValue()),
            aggs = postAggConverter.convert(aggs, aggCtx);
        this.preAggConverter = new PreAggregateConverter();
            bigint,
    private final AggregateConverter aggConverter;
     */
import org.apache.calcite.plan.hep.HepProgram;
        if (trackTotalHitsDisabled && eligibleFieldByAggName.isEmpty() && !totalServesAsEligibleCount) {
            } else {
import java.util.Collections;
import org.apache.calcite.prepare.CalciteCatalogReader;
        );
import org.apache.calcite.jdbc.CalciteSchema;
                );
    private RelNode buildFlatCountPlan(
    /**
        RelNode scan = LogicalTableScan.create(ctx.getCluster(), ctx.getTable(), List.of());
                RelDataTypeField field = base.getRowType().getField(fieldName, false, false);
import org.apache.calcite.plan.RelOptTable;
    }
import java.util.LinkedHashMap;
        this(schema, () -> null);
        // The walker emits parents before their children, so a child's parent plan is
            )
        for (Map.Entry<String, Integer> entry : eligibleFieldByAggName.entrySet()) {
 * compatible open source license.
        this.sortConverter = new SortConverter();
     *
    private final RelDataTypeFactory typeFactory;
    private final SortConverter sortConverter;
import org.apache.calcite.rel.logical.LogicalAggregate;
     * Creates a fresh workspace (cluster) for one plan family. Calcite's per-cluster metadata
import java.util.ArrayList;
        if (table == null) {
 * <p>Builds its own Calcite planning infrastructure from the {@link SchemaPlus} provided
                    false,
    }
     */
            -1,
        RelDataTypeField countField = grouped.getRowType().getField(AggregationMetadataBuilder.IMPLICIT_COUNT_NAME, false, false);
                // min_doc_count > 1: the eligible count must exclude below-threshold groups
                AggregateCall.create(
                false,
    /**
            }
import org.apache.calcite.rex.RexBuilder;
        AggregateCall groupCount = AggregateCall.create(
        }
    public QueryPlans convert(SearchSourceBuilder searchSource, String indexName) throws ConversionException {
            calls.add(
     *
                totalServesAsEligibleCount = true;
            return null;
     * Initializes planning infrastructure from the given schema.
     * the cluster it was created in, and metadata lookups follow {@code node.getCluster()}.
        RelOptCluster cluster = newCluster();
            builder.add(new QueryPlans.QueryPlan(QueryPlans.Type.AGGREGATION, aggs, metadata));
        );
            if (metadata.getHavingMinDocCount() != null) {
 * SPDX-License-Identifier: Apache-2.0
                false,
                    throw new ConversionException("Group-by field '" + fieldName + "' not found in schema");
     * null-skipping {@code COUNT(field)} per bounded root aggregation as its
    public AggregationRegistry getAggregationRegistry() {
    private static String aggPathKey(List<String> aggNamePath) {
    private final CalciteCatalogReader catalogReader;
            false,
        calls.add(
    }
     * eligible-count columns, and no {@code missing}-substituted aggregation riding on
            new CalciteConnectionConfigImpl(new Properties())
import org.opensearch.dsl.aggregation.AggregationMetadata;
        this.typeFactory = new SqlTypeFactoryImpl(DslTypeSystems.NANO_TIMESTAMP);
        this.postAggConverter = new PostAggregateConverter();
    private RelNode buildHavingEligibleCountPlan(
        }
     */
    }
     * cache is not thread-safe, and its cycle detection assumes a single planning thread —
     *     Aggregate(GROUP BY field, COUNT(*) AS _count)
import org.opensearch.dsl.executor.QueryPlans;
     * @param searchSource the DSL query
        RelDataType bigint = ctx.getCluster().getTypeFactory().createSqlType(SqlTypeName.BIGINT);
        // size=0 skips hits — total doc count comes from analytics plugin metadata
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        // Hits path: Scan → Filter → Project → Sort
        // base has the same row type, so the eligible-count field indices stay valid.
        RelOptTable table,
     * therefore not share a cluster, nor any {@code RelNode}: a node is permanently bound to
     * @param schema Calcite schema with index tables from the analytics engine
    private static boolean hasAggregations(SearchSourceBuilder searchSource) {
     * eligible-doc count (the total {@code sum_other_doc_count} is subtracted from).
            false,
            builtPlansByPath.put(aggPathKey(metadata.getAggNamePath()), aggs);
        ConversionContext ctx = new ConversionContext(searchSource, cluster, table);
    }
        RexBuilder rexBuilder = ctx.getRexBuilder();
    ) throws ConversionException {
                eligibleFieldByAggName.put(aggName, field.getIndex());
        for (AggregationMetadata metadata : metadataList) {
            -1,
                if (field == null) {
                // the threshold trumps substitution, and the plan's pre-aggregate input applies
            RelCollations.EMPTY,
import java.util.List;
                }
        Map<String, Integer> eligibleFieldByAggName = new LinkedHashMap<>();
import org.opensearch.search.internal.SearchContext;
        int size = searchSource.size() != -1 ? searchSource.size() : SearchService.DEFAULT_SIZE;
        }
        // always already built when the child needs it as its semi-join input.
/*
 * by the analytics engine.
                aggCtx = aggCtx.withParentPlan(parentPlan);
    private final PostAggregateConverter postAggConverter;
    /** Canonical plan key — see {@link AggregationMetadata#pathKey}. */
    }
     * Initializes planning infrastructure without mapping resolution — conversion-only use;
        // no need to reconstruct typeFactory, CatalogReader, and planning infrastructure here.
 *
        boolean hasAggs = hasAggregations(searchSource);
import org.opensearch.index.mapper.MapperService;
        // plans below build in their own workspaces: they are submitted to the engine
            );
        // Fail loudly (400) on features this path does not implement, instead of silently
        RelNode grouped = LogicalAggregate.create(aggInput, metadata.getGroupByBitSet(), null, List.of(groupCount));
        this.aggConverter = new AggregateConverter();
                    QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + entry.getKey()
            AggregateCall.create(
