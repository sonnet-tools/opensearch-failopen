                continue;
import io.substrait.proto.Plan;
import org.opensearch.Version;  
    }
import static org.mockito.Mockito.when;
            return DefaultExtensionCatalog.DEFAULT_COLLECTION  
import org.apache.calcite.schema.SchemaPlus;
        when(dfPlugin.name()).thenReturn("datafusion");
import java.util.List;
import org.apache.logging.log4j.LogManager;
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
 * compatible open source license.
        QueryDAG dag = buildAndConvertQtfDag(sql);
        );
        Stage scan = dag.rootStage().getChildStages().getFirst().getChildStages().getFirst().getChildStages().getFirst();
        Map<String, Map<String, Object>> fields = new LinkedHashMap<>();
        return dag;  
    }
/**
     */  
        );
 * Diagnostic dump: drives a QTF SQL query through the full planner stack
        return clusterService;
     * cuts or fragment conversion, Stage 1's reduce plan references {@code input-0.__row_id__}
/*  
        RelNode cbo = PlannerImpl.runAllOptimizations(parsed, context);  
        SimpleExtension.ExtensionCollection extensions = loadExtensions();
        DataFusionAnalyticsBackendPlugin dfBackend = new DataFusionAnalyticsBackendPlugin(dfPlugin);  
        LOGGER.info("[QTF-DUMP] sql:\n{}", sql);  
        SqlToRelConverter converter = new SqlToRelConverter(
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
import org.opensearch.common.util.concurrent.ThreadContext;  
        Map<String, Map<String, Object>> fields = new LinkedHashMap<>();
     * but the partition exposes only the physical cols and DataFusion fails registration with  
 * Run with {@code --info} to see the dumped plans.
import org.opensearch.cluster.routing.OperationRouting;
        SqlParser.Config parserConfig = SqlParser.config().withUnquotedCasing(Casing.UNCHANGED);  
                .putMapping(mapping.toString())  
            (rowType, queryString, schemaPath, viewPath) -> { throw new UnsupportedOperationException("View expansion not used"); },
        when(clusterService.state()).thenReturn(state);  
            Metadata metadata = Metadata.builder().put(indexMetadata, false).build();
        OperationRouting routing = mock(OperationRouting.class);
            throw new AssertionError("Failed to parse SQL: " + sql, e);
            baseSchemaNames.contains("__row_id__")
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, Set.of(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING));  
        try {  
        LOGGER.info("[QTF-DUMP] parsed RelNode:\n{}", RelOptUtil.toString(parsed));
import java.util.Collections;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.avatica.util.Casing;
import org.apache.calcite.sql.parser.SqlParser;
        // Walk every stage and dump its substrait Plan(s).
        // getFragmentConvertor() touch (no native runtime, no plugin lifecycle).
        CalciteCatalogReader catalogReader = new CalciteCatalogReader(  
            SimpleExtension.ExtensionCollection scalarExtensions = SimpleExtension.load(List.of("/opensearch_scalar_functions.yaml"));  
            mapping.startObject().field("properties", fields).endObject();
        // Real Substrait extensions, loaded via the DataFusionPlugin's exact path.
            if (bytes == null || bytes.length == 0) {  
import org.opensearch.analytics.schema.OpenSearchSchemaBuilder;  
        return switch (rel.getRelTypeCase()) {
        try (XContentBuilder mapping = XContentBuilder.builder(MediaTypeRegistry.JSON.xContent())) {
            clusterState,  
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * into proto for human-readable output).
        }  
        } catch (SqlParseException e) {
            validator,  
        when(dfPlugin.name()).thenReturn("datafusion");  
        PlannerContext context = new PlannerContext(
    }  
            stage.getPlanAlternatives().size()
        // Parse → CBO → DAG → forker → fragment conversion.
                .merge(scalarExtensions)
        PlanForker.forkAll(dag, context.getCapabilityRegistry());  
import org.apache.calcite.config.CalciteConnectionConfigImpl;
        };  
import org.opensearch.cluster.ClusterName;
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
        fields.put("UserID", Map.of("type", "long"));
            byte[] bytes = alt.convertedBytes();
            default -> throw new AssertionError("no ReadRel found, hit " + rel.getRelTypeCase());
            );  
import org.apache.logging.log4j.Logger;
import java.util.Properties;  
        fields.put("Title", Map.of("type", "keyword", "index", "false"));
        ClusterService clusterService = mock(ClusterService.class);  
            false
        List<String> baseSchemaNames = findRead(plan.getRelations(0).getRoot().getInput()).getBaseSchema().getNamesList();
                .merge(arrayExtensions)  
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());  
        RelNode parsed = parseSql(sql, clusterState);
        }
    private static ClusterState clusterStateWith(String indexName, Map<String, Map<String, Object>> fields, String primaryDataFormat, int shardCount) {  
        assertTrue(
import org.opensearch.analytics.planner.dag.Stage;
    }
 */  
        );
    private void dumpSubstraitPerStage(Stage stage) throws Exception {  
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
            "Stage 0 base_schema must include __row_id__; got " + baseSchemaNames,  
        fields.put("Title", Map.of("type", "keyword", "index", "false"));  
        SimpleExtension.ExtensionCollection extensions = loadExtensions();
            SqlStdOperatorTable.instance(),
            t.setContextClassLoader(QtfSubstraitDumpIT.class.getClassLoader());
            Collections.singletonList(""),
 *
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
    private static final IndexNameExpressionResolver TEST_RESOLVER = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
     * "No field named __row_id__".
        byte[] bytes = scan.getPlanAlternatives().getFirst().convertedBytes();  
        DataFusionPlugin dfPlugin = mock(DataFusionPlugin.class);  
        Thread t = Thread.currentThread();
        ClassLoader prev = t.getContextClassLoader();
import org.opensearch.analytics.planner.PlannerContext;
            stage.getExecutionType(),  
    }
    /**
        fields.put("CounterID", Map.of("type", "integer"));  
        } finally {
import org.opensearch.action.search.TransportSearchAction;
     * fragment conversion. Returns the fully-converted DAG ready for per-stage assertions.
package org.opensearch.be.datafusion;
import org.apache.calcite.rex.RexBuilder;  
        when(dfPlugin.getSupportedFormats()).thenReturn(List.of("parquet"));
import io.substrait.extension.DefaultExtensionCatalog;  
        // Stage 0 sits two levels below the LM stage (root post-LM reduce → LM → reduce → scan).
    /**  
        fields.put("UserID", Map.of("type", "long"));  
    /** Walks single-input Substrait rels (Fetch/Sort/Project/Filter/Aggregate) down to the ReadRel. */
                );  
     * adds the helper to the narrowed Scan rowType; if the override is dropped during DAG
import org.opensearch.cluster.routing.ShardIterator;
import org.opensearch.test.OpenSearchTestCase;  
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
import org.apache.calcite.sql.SqlNode;
            CalciteSchema.from(schema),
            throw new AssertionError("Failed to build ClusterState", e);
            case AGGREGATE -> findRead(rel.getAggregate().getInput());
import org.apache.calcite.sql.validate.SqlValidator;  
            SimpleExtension.ExtensionCollection aggregateExtensions = SimpleExtension.load(List.of("/opensearch_aggregate_functions.yaml"));
        QueryDAG dag = DAGBuilder.build(cbo, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);  
            parsedNode = SqlParser.create(sql, parserConfig).parseQuery();  
import org.opensearch.common.settings.ClusterSettings;
            catalogReader,
            Plan plan = Plan.parseFrom(bytes);  
import org.apache.calcite.sql2rel.SqlToRelConverter;
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.jdbc.CalciteSchema;  
        PlannerContext context = new PlannerContext(
            stage.getStageId(),
        );
        String sql = "SELECT URL, EventDate FROM hits ORDER BY EventDate LIMIT 10";
        }
    private static ReadRel findRead(Rel rel) {  
            IndexMetadata indexMetadata = IndexMetadata.builder(indexName)  
            case FILTER -> findRead(rel.getFilter().getInput());  
            case PROJECT -> findRead(rel.getProject().getInput());
        ClusterState clusterState = clusterStateWith(INDEX, fields, "parquet", 2);
                .settings(
            clusterState,  
        try {
import java.util.LinkedHashMap;  
            t.setContextClassLoader(prev);  
        // The Read may be wrapped by the per-shard Sort/Fetch that sort pushdown inserts; find it.  
            typeFactory,  
            typeFactory,  
        for (int i = 0; i < stage.getPlanAlternatives().size(); i++) {  
 */
        SqlNode parsedNode;
import org.opensearch.cluster.ClusterState;
 * @opensearch.internal
        return converter.convertQuery(parsedNode, true, true).project();  
 * <p>Lives in the QA module because the analytics-engine plugin's test classpath
        ClusterState state = mock(ClusterState.class);
        LOGGER.info("[QTF-DUMP] QueryDAG (post-conversion, with backend-resolved fragments):\n{}", dag);
                    Settings.builder()
        ClusterState clusterState = clusterStateWith(INDEX, fields, "parquet", 2);
        }
            case SORT -> findRead(rel.getSort().getInput());
        fields.put("EventDate", Map.of("type", "date"));  
            case FETCH -> findRead(rel.getFetch().getInput());  
 * the per-stage RelNode trees and the per-stage Substrait Plan bytes (parsed back
        );
            SqlValidator.Config.DEFAULT
        DataFusionPlugin dfPlugin = mock(DataFusionPlugin.class);
import static org.mockito.ArgumentMatchers.any;  
import java.util.Map;
            case READ -> rel.getRead();
import org.opensearch.cluster.routing.GroupShardsIterator;
import org.opensearch.analytics.planner.PlannerImpl;
            return ClusterState.builder(new ClusterName("test")).metadata(metadata).build();  
import org.apache.calcite.rel.type.RelDataTypeFactory;
    private static ClusterService mockClusterService() {
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
    private static SimpleExtension.ExtensionCollection loadExtensions() {  
        when(dfPlugin.getSubstraitExtensions()).thenReturn(extensions);
        when(dfPlugin.getSubstraitExtensions()).thenReturn(extensions);  
            SimpleExtension.ExtensionCollection arrayExtensions = SimpleExtension.load(List.of("/opensearch_array_functions.yaml"));
 * SPDX-License-Identifier: Apache-2.0
    }  
import org.opensearch.analytics.planner.dag.DAGBuilder;  
import static org.mockito.Mockito.mock;
    private static final String INDEX = "hits";
    private static RelNode parseSql(String sql, ClusterState clusterState) {  
    public void testStage0ScanCarriesRowIdInConvertedSubstrait() throws Exception {  
            SimpleExtension.ExtensionCollection delegationExtensions = SimpleExtension.load(List.of("/delegation_functions.yaml"));
import org.apache.calcite.sql.parser.SqlParseException;
        LOGGER.info("[QTF-DUMP] === Stage {} ({}) — alternatives: {} ===",
    }
import org.apache.calcite.plan.hep.HepProgramBuilder;
import org.opensearch.cluster.metadata.Metadata;
        fields.put("EventDate", Map.of("type", "date"));
import org.opensearch.analytics.planner.dag.PlanForker;
     * Reusable harness: parses SQL, runs the planner, builds the DAG, forks plans, and runs
                )  
}
 *  
 *  
import org.opensearch.analytics.planner.dag.FragmentConversionDriver;
import org.apache.calcite.sql.validate.SqlValidatorUtil;
            dumpSubstraitPerStage(child);  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
            false
        } catch (Exception e) {
                .merge(delegationExtensions)
        LOGGER.info("[QTF-DUMP] post-CBO+QTF RelNode:\n{}", RelOptUtil.toString(cbo));
                .merge(aggregateExtensions);
            StandardConvertletTable.INSTANCE,  
import io.substrait.extension.SimpleExtension;
import org.opensearch.cluster.metadata.IndexMetadata;  
import org.apache.calcite.plan.hep.HepPlanner;
                .build();
import org.opensearch.analytics.planner.dag.QueryDAG;  
            SqlToRelConverter.config()
import io.substrait.proto.ReadRel;  
    private static final Logger LOGGER = LogManager.getLogger(QtfSubstraitDumpIT.class);
import org.apache.calcite.plan.RelOptUtil;  
        LOGGER.info("[QTF-DUMP] QueryDAG (pre-conversion):\n{}", dag);
 * <p>Not a regression test — it has no asserts beyond "things didn't crash."
                        .put("index.composite.primary_data_format", primaryDataFormat)
            new CapabilityRegistry(List.of(dfBackend), FieldStorageResolver::new),
import org.opensearch.common.settings.Settings;
                .numberOfReplicas(0)
    public void testDumpQtfPipeline() throws Exception {
        );
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, new RexBuilder(typeFactory));
import org.apache.calcite.plan.RelOptCluster;
        dumpSubstraitPerStage(dag.rootStage());
        fields.put("URL", Map.of("type", "keyword", "index", "false"));
import org.opensearch.analytics.planner.CapabilityRegistry;
                    stage.getStageId(), i, alt.backendId()
                        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id)  
    }
        fields.put("CounterID", Map.of("type", "integer"));
        when(clusterService.operationRouting()).thenReturn(routing);
            catalogReader,
import org.opensearch.analytics.planner.dag.StagePlan;
 * this file be licensed under the Apache-2.0 license or a
import io.substrait.proto.Rel;
        when(dfPlugin.getSupportedFormats()).thenReturn(List.of("parquet"));
    private QueryDAG buildAndConvertQtfDag(String sql) {
import org.opensearch.core.xcontent.XContentBuilder;
                stage.getStageId(), i, alt.backendId(), bytes.length, plan
        QueryDAG dag = DAGBuilder.build(cbo, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);  
import org.opensearch.cluster.service.ClusterService;  
import org.apache.calcite.sql2rel.StandardConvertletTable;  
import org.opensearch.analytics.planner.FieldStorageResolver;  
     * Stage 0's converted Substrait base_schema must include {@code __row_id__}. The rewriter  
                        .putList("index.composite.secondary_data_formats")
            new CalciteConnectionConfigImpl(new Properties())
    // ── parse helpers (inlined from analytics-engine's SqlPlannerTestFixture) ─────
public class QtfSubstraitDumpIT extends OpenSearchTestCase {  
     */
        DataFusionAnalyticsBackendPlugin dfBackend = new DataFusionAnalyticsBackendPlugin(dfPlugin);
 * doesn't have substrait, but this module does.
            StagePlan alt = stage.getPlanAlternatives().get(i);
        SqlValidator validator = SqlValidatorUtil.newValidator(  
        }  
            LOGGER.info("[QTF-DUMP] stage {} alt[{}] backend={} — Substrait Plan ({} bytes):\n{}",
        for (Stage child : stage.getChildStages()) {
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
            cluster,
            new CapabilityRegistry(List.of(dfBackend), FieldStorageResolver::new),
                .numberOfShards(shardCount)
        // Stub DataFusionPlugin: only the bits getCapabilityProvider() and
 * (parse → CBO → QTF rewrite → DAG cut → fragment conversion) and prints both  
        when(routing.searchShards(any(), any(), any(), any())).thenReturn(new GroupShardsIterator<ShardIterator>(List.of()));
        RelNode cbo = PlannerImpl.runAllOptimizations(parsed, context);
        String sql = "SELECT URL, EventDate FROM hits WHERE CounterID = 5 ORDER BY EventDate LIMIT 10";
    @SuppressWarnings("unchecked")
import org.apache.calcite.prepare.CalciteCatalogReader;  
        fields.put("URL", Map.of("type", "keyword", "index", "false"));
        RelNode parsed = parseSql(sql, clusterState);
        Plan plan = Plan.parseFrom(bytes);
    }  
            }
 *  
                LOGGER.info("[QTF-DUMP] stage {} alt[{}] backend={} — no Substrait bytes (stage type doesn't convert)",
        );
import java.util.Set;
