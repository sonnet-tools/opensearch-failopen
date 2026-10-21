import org.opensearch.core.xcontent.MediaTypeRegistry;
                )
import org.apache.calcite.prepare.CalciteCatalogReader;
    }
import org.apache.calcite.schema.SchemaPlus;
            SimpleExtension.ExtensionCollection delegationExtensions = SimpleExtension.load(List.of("/delegation_functions.yaml"));
        when(clusterService.state()).thenReturn(state);
import io.substrait.proto.ReadRel;
        fields.put("CounterID", Map.of("type", "integer"));
import org.apache.calcite.plan.RelOptCluster;
        fields.put("EventDate", Map.of("type", "date"));
            validator,
        RelNode cbo = PlannerImpl.runAllOptimizations(parsed, context);
        when(dfPlugin.getSupportedFormats()).thenReturn(List.of("parquet"));
        String sql = "SELECT URL, EventDate FROM hits WHERE CounterID = 5 ORDER BY EventDate LIMIT 10";
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.sql.validate.SqlValidatorUtil;
            parsedNode = SqlParser.create(sql, parserConfig).parseQuery();
        LOGGER.info("[QTF-DUMP] post-CBO+QTF RelNode:\n{}", RelOptUtil.toString(cbo));
            clusterState,
        Map<String, Map<String, Object>> fields = new LinkedHashMap<>();
            );
        PlannerContext context = new PlannerContext(
import org.opensearch.common.util.concurrent.ThreadContext;
import org.opensearch.cluster.ClusterName;
    private static ClusterState clusterStateWith(String indexName, Map<String, Map<String, Object>> fields, String primaryDataFormat, int shardCount) {
import org.apache.calcite.config.CalciteConnectionConfigImpl;
        DataFusionAnalyticsBackendPlugin dfBackend = new DataFusionAnalyticsBackendPlugin(dfPlugin);
 * The OpenSearch Contributors require contributions made to
import org.apache.calcite.plan.hep.HepProgramBuilder;
import org.opensearch.analytics.planner.dag.StagePlan;
    // ── parse helpers (inlined from analytics-engine's SqlPlannerTestFixture) ─────
 * <p>Not a regression test — it has no asserts beyond "things didn't crash."
                .merge(arrayExtensions)
    private static ReadRel findRead(Rel rel) {
package org.opensearch.be.datafusion;
            throw new AssertionError("Failed to parse SQL: " + sql, e);
            CalciteSchema.from(schema),
        assertTrue(
        }
    private void dumpSubstraitPerStage(Stage stage) throws Exception {
            SimpleExtension.ExtensionCollection aggregateExtensions = SimpleExtension.load(List.of("/opensearch_aggregate_functions.yaml"));
            SqlValidator.Config.DEFAULT
import org.opensearch.analytics.planner.dag.Stage;
import org.opensearch.analytics.planner.dag.PlanForker;
            default -> throw new AssertionError("no ReadRel found, hit " + rel.getRelTypeCase());
        );
        Map<String, Map<String, Object>> fields = new LinkedHashMap<>();
 *
import org.opensearch.common.settings.Settings;
            SqlStdOperatorTable.instance(),
 * into proto for human-readable output).
        );
        Stage scan = dag.rootStage().getChildStages().getFirst().getChildStages().getFirst().getChildStages().getFirst();
        fields.put("CounterID", Map.of("type", "integer"));
        } catch (SqlParseException e) {
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            typeFactory,
                LOGGER.info("[QTF-DUMP] stage {} alt[{}] backend={} — no Substrait bytes (stage type doesn't convert)",
                        .putList("index.composite.secondary_data_formats")
/*
            mapping.startObject().field("properties", fields).endObject();
        // Parse → CBO → DAG → forker → fragment conversion.
            catalogReader,
        LOGGER.info("[QTF-DUMP] QueryDAG (post-conversion, with backend-resolved fragments):\n{}", dag);
        QueryDAG dag = DAGBuilder.build(cbo, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
            case FETCH -> findRead(rel.getFetch().getInput());
import java.util.Map;
        );
        LOGGER.info("[QTF-DUMP] === Stage {} ({}) — alternatives: {} ===",
            new CalciteConnectionConfigImpl(new Properties())
import org.apache.calcite.sql.SqlNode;
import org.opensearch.common.settings.ClusterSettings;
    private static RelNode parseSql(String sql, ClusterState clusterState) {
        // Walk every stage and dump its substrait Plan(s).
        LOGGER.info("[QTF-DUMP] parsed RelNode:\n{}", RelOptUtil.toString(parsed));
            Plan plan = Plan.parseFrom(bytes);
            return DefaultExtensionCatalog.DEFAULT_COLLECTION
 * <p>Lives in the QA module because the analytics-engine plugin's test classpath
    private static final String INDEX = "hits";
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
import org.apache.calcite.avatica.util.Casing;
import org.opensearch.action.search.TransportSearchAction;
import org.apache.calcite.rex.RexBuilder;
        fields.put("URL", Map.of("type", "keyword", "index", "false"));
import org.apache.calcite.plan.RelOptUtil;
        LOGGER.info("[QTF-DUMP] sql:\n{}", sql);
import org.opensearch.analytics.schema.OpenSearchSchemaBuilder;
            SimpleExtension.ExtensionCollection arrayExtensions = SimpleExtension.load(List.of("/opensearch_array_functions.yaml"));
            byte[] bytes = alt.convertedBytes();
        ClusterState clusterState = clusterStateWith(INDEX, fields, "parquet", 2);
            clusterState,
                        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id)
    private static final Logger LOGGER = LogManager.getLogger(QtfSubstraitDumpIT.class);
 * compatible open source license.
        when(dfPlugin.getSubstraitExtensions()).thenReturn(extensions);
}
 * Diagnostic dump: drives a QTF SQL query through the full planner stack
/**
    }
import org.apache.calcite.sql.parser.SqlParseException;
import org.opensearch.cluster.routing.ShardIterator;
    /**
        fields.put("UserID", Map.of("type", "long"));
        try {
        return clusterService;
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());
            Metadata metadata = Metadata.builder().put(indexMetadata, false).build();
        String sql = "SELECT URL, EventDate FROM hits ORDER BY EventDate LIMIT 10";
import java.util.List;
        ClusterState state = mock(ClusterState.class);
            stage.getExecutionType(),
    }
        for (Stage child : stage.getChildStages()) {
        LOGGER.info("[QTF-DUMP] QueryDAG (pre-conversion):\n{}", dag);
        when(dfPlugin.getSubstraitExtensions()).thenReturn(extensions);
import org.apache.calcite.sql.validate.SqlValidator;
        }
import org.apache.calcite.sql.parser.SqlParser;
import org.opensearch.analytics.planner.dag.DAGBuilder;
     * cuts or fragment conversion, Stage 1's reduce plan references {@code input-0.__row_id__}
import org.opensearch.analytics.planner.dag.QueryDAG;
    @SuppressWarnings("unchecked")
 * SPDX-License-Identifier: Apache-2.0
     */
        RelNode parsed = parseSql(sql, clusterState);
        try {
import io.substrait.proto.Plan;
    private static ClusterService mockClusterService() {
        return switch (rel.getRelTypeCase()) {
            new CapabilityRegistry(List.of(dfBackend), FieldStorageResolver::new),
import static org.mockito.Mockito.mock;
        RelNode parsed = parseSql(sql, clusterState);
        SimpleExtension.ExtensionCollection extensions = loadExtensions();
 *
        CalciteCatalogReader catalogReader = new CalciteCatalogReader(
import org.apache.calcite.plan.hep.HepPlanner;
        Thread t = Thread.currentThread();
import org.apache.calcite.sql2rel.StandardConvertletTable;
        SimpleExtension.ExtensionCollection extensions = loadExtensions();
        fields.put("Title", Map.of("type", "keyword", "index", "false"));
        }
        PlannerContext context = new PlannerContext(
            case READ -> rel.getRead();
                .merge(scalarExtensions)
        RelNode cbo = PlannerImpl.runAllOptimizations(parsed, context);
    /** Walks single-input Substrait rels (Fetch/Sort/Project/Filter/Aggregate) down to the ReadRel. */
    }
public class QtfSubstraitDumpIT extends OpenSearchTestCase {
 * @opensearch.internal
import java.util.Properties;
            case SORT -> findRead(rel.getSort().getInput());
        fields.put("UserID", Map.of("type", "long"));
            Collections.singletonList(""),
            case PROJECT -> findRead(rel.getProject().getInput());
 */
            stage.getPlanAlternatives().size()
     */
     * Stage 0's converted Substrait base_schema must include {@code __row_id__}. The rewriter
        OperationRouting routing = mock(OperationRouting.class);
import org.opensearch.analytics.planner.dag.FragmentConversionDriver;
import org.apache.logging.log4j.Logger;
        when(dfPlugin.getSupportedFormats()).thenReturn(List.of("parquet"));
                        .put("index.composite.primary_data_format", primaryDataFormat)
 *
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.cluster.metadata.Metadata;
     * Reusable harness: parses SQL, runs the planner, builds the DAG, forks plans, and runs
        fields.put("Title", Map.of("type", "keyword", "index", "false"));
            typeFactory,
            t.setContextClassLoader(prev);
            throw new AssertionError("Failed to build ClusterState", e);
        // Stub DataFusionPlugin: only the bits getCapabilityProvider() and
import io.substrait.proto.Rel;
        );
            StandardConvertletTable.INSTANCE,
    public void testStage0ScanCarriesRowIdInConvertedSubstrait() throws Exception {
        } finally {
            (rowType, queryString, schemaPath, viewPath) -> { throw new UnsupportedOperationException("View expansion not used"); },
        );
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        when(dfPlugin.name()).thenReturn("datafusion");
 * Run with {@code --info} to see the dumped plans.
     * but the partition exposes only the physical cols and DataFusion fails registration with
        ClassLoader prev = t.getContextClassLoader();
import org.opensearch.cluster.ClusterState;
    }
            IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
import org.apache.calcite.jdbc.CalciteSchema;
import java.util.Collections;
        fields.put("EventDate", Map.of("type", "date"));
        // getFragmentConvertor() touch (no native runtime, no plugin lifecycle).
 * (parse → CBO → QTF rewrite → DAG cut → fragment conversion) and prints both
        DataFusionAnalyticsBackendPlugin dfBackend = new DataFusionAnalyticsBackendPlugin(dfPlugin);
                stage.getStageId(), i, alt.backendId(), bytes.length, plan
import static org.mockito.ArgumentMatchers.any;
            cluster,
 * doesn't have substrait, but this module does.
        for (int i = 0; i < stage.getPlanAlternatives().size(); i++) {
        when(clusterService.operationRouting()).thenReturn(routing);
        );
                .numberOfShards(shardCount)
            SqlToRelConverter.config()
import org.opensearch.test.OpenSearchTestCase;
     * fragment conversion. Returns the fully-converted DAG ready for per-stage assertions.
            stage.getStageId(),
import org.opensearch.analytics.planner.CapabilityRegistry;
                .build();
        byte[] bytes = scan.getPlanAlternatives().getFirst().convertedBytes();
            LOGGER.info("[QTF-DUMP] stage {} alt[{}] backend={} — Substrait Plan ({} bytes):\n{}",
import org.opensearch.analytics.planner.FieldStorageResolver;
    private static final IndexNameExpressionResolver TEST_RESOLVER = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
        return dag;
                    stage.getStageId(), i, alt.backendId()
import org.opensearch.cluster.metadata.IndexMetadata;
                .merge(delegationExtensions)
        ClusterState clusterState = clusterStateWith(INDEX, fields, "parquet", 2);
    public void testDumpQtfPipeline() throws Exception {
        List<String> baseSchemaNames = findRead(plan.getRelations(0).getRoot().getInput()).getBaseSchema().getNamesList();
        dumpSubstraitPerStage(dag.rootStage());
            baseSchemaNames.contains("__row_id__")
import io.substrait.extension.SimpleExtension;
        SqlToRelConverter converter = new SqlToRelConverter(
import org.opensearch.Version;
            case FILTER -> findRead(rel.getFilter().getInput());
        SqlValidator validator = SqlValidatorUtil.newValidator(
    }
        }
    }
import org.apache.calcite.rel.type.RelDataTypeFactory;
            case AGGREGATE -> findRead(rel.getAggregate().getInput());
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, new RexBuilder(typeFactory));
import java.util.LinkedHashMap;
            dumpSubstraitPerStage(child);
    }
                continue;
 * this file be licensed under the Apache-2.0 license or a
                    Settings.builder()
            if (bytes == null || bytes.length == 0) {
    /**
    private QueryDAG buildAndConvertQtfDag(String sql) {
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
            false
     * adds the helper to the narrowed Scan rowType; if the override is dropped during DAG
        QueryDAG dag = buildAndConvertQtfDag(sql);
import org.opensearch.cluster.service.ClusterService;
        // Stage 0 sits two levels below the LM stage (root post-LM reduce → LM → reduce → scan).
 */
        }
            "Stage 0 base_schema must include __row_id__; got " + baseSchemaNames,
        QueryDAG dag = DAGBuilder.build(cbo, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
        // Real Substrait extensions, loaded via the DataFusionPlugin's exact path.
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, Set.of(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING));
        DataFusionPlugin dfPlugin = mock(DataFusionPlugin.class);
        Plan plan = Plan.parseFrom(bytes);
        fields.put("URL", Map.of("type", "keyword", "index", "false"));
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
import org.opensearch.cluster.routing.OperationRouting;
        when(dfPlugin.name()).thenReturn("datafusion");
    }
    private static SimpleExtension.ExtensionCollection loadExtensions() {
        return converter.convertQuery(parsedNode, true, true).project();
                .numberOfReplicas(0)
import org.apache.calcite.sql2rel.SqlToRelConverter;
                );
        };
 * the per-stage RelNode trees and the per-stage Substrait Plan bytes (parsed back
import java.util.Set;
import static org.mockito.Mockito.when;
import org.opensearch.core.xcontent.XContentBuilder;
            return ClusterState.builder(new ClusterName("test")).metadata(metadata).build();
        );
            false
                .merge(aggregateExtensions);
                .settings(
import org.opensearch.analytics.planner.PlannerImpl;
import org.apache.logging.log4j.LogManager;
        SqlParser.Config parserConfig = SqlParser.config().withUnquotedCasing(Casing.UNCHANGED);
import org.opensearch.cluster.routing.GroupShardsIterator;
            SimpleExtension.ExtensionCollection scalarExtensions = SimpleExtension.load(List.of("/opensearch_scalar_functions.yaml"));
        try (XContentBuilder mapping = XContentBuilder.builder(MediaTypeRegistry.JSON.xContent())) {
        SqlNode parsedNode;
            t.setContextClassLoader(QtfSubstraitDumpIT.class.getClassLoader());
        DataFusionPlugin dfPlugin = mock(DataFusionPlugin.class);
            StagePlan alt = stage.getPlanAlternatives().get(i);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
     * "No field named __row_id__".
        ClusterService clusterService = mock(ClusterService.class);
            new CapabilityRegistry(List.of(dfBackend), FieldStorageResolver::new),
import org.opensearch.analytics.planner.PlannerContext;
import io.substrait.extension.DefaultExtensionCatalog;
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
        // The Read may be wrapped by the per-shard Sort/Fetch that sort pushdown inserts; find it.
        } catch (Exception e) {
            }
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
        when(routing.searchShards(any(), any(), any(), any())).thenReturn(new GroupShardsIterator<ShardIterator>(List.of()));
                .putMapping(mapping.toString())
            catalogReader,
 *
