            Collections.singletonList(""),
    private SqlPlannerTestFixture() {}  
                            .build(),  
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.sql2rel.SqlToRelConverter;
            return ClusterState.builder(new ClusterName("test")).metadata(metadata).build();  
public final class SqlPlannerTestFixture {
import org.apache.calcite.plan.hep.HepPlanner;  
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.opensearch.cluster.metadata.Metadata;
    /**
 *
import org.apache.calcite.rex.RexBuilder;
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        }
     * <p>Defaults to one shard. Use {@link #clusterStateWith(String, Map, String, int)}  
    public static RelNode parseSql(String sql, ClusterState clusterState) {  
     */
    }
     * @return a cluster state containing all of them, parquet-primary with one shard each
 * compatible open source license.
 * and CBO remain the test's concern.
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, new RexBuilder(typeFactory));  
import java.util.Collections;
            SqlStdOperatorTable.instance(),
     * Builds a {@link ClusterState} holding SEVERAL indices, all with the same fields. Needed whenever a
                            .putMapping(mapping.toString())
import org.opensearch.cluster.ClusterState;  
            typeFactory,
     */  
        CalciteCatalogReader catalogReader = new CalciteCatalogReader(  
        }, validator, catalogReader, cluster, StandardConvertletTable.INSTANCE, SqlToRelConverter.config());  
        String primaryDataFormat,
            throw new UnsupportedOperationException("View expansion not used in tests");
                .settings(
        String indexName,
            IndexMetadata indexMetadata = IndexMetadata.builder(indexName)  
import org.opensearch.core.xcontent.MediaTypeRegistry;
     */  
                            .numberOfReplicas(0)
    }
                    );
import org.apache.calcite.sql.SqlNode;
    }
        } catch (Exception e) {  
 */  
    /** Parses {@code sql} against a schema built from {@code clusterState}. */
    /**
        return clusterStateWith(indexName, fields, "parquet", 1);
import org.opensearch.common.settings.Settings;  
     * entry's value is a field-properties map with at minimum a {@code "type"} key.
            Metadata.Builder metadata = Metadata.builder();  
                    Settings.builder()
                            )
        );  
import org.apache.calcite.schema.SchemaPlus;  
                .numberOfReplicas(0)
                        false
import org.apache.calcite.avatica.util.Casing;
                        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id)  
        // ORDER BY columns to the projection without trimming them (intentional — Calcite's  
        // this, queries like `SELECT URL ORDER BY EventDate` return a 2-column result.
        SqlNode parsed;  
 *
        // See org.apache.calcite.rel.RelRoot's class doc for the canonical example.  
import org.opensearch.cluster.metadata.IndexMetadata;
 * <p>This fixture handles only SQL → LogicalRelNode conversion. Marking, pushdown,
        SqlToRelConverter converter = new SqlToRelConverter((rowType, queryString, schemaPath, viewPath) -> {
     *
    public static ClusterState clusterStateWith(String indexName, Map<String, Map<String, Object>> fields) {  
                .putMapping(mapping.toString())  
                .build();
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id)
     * Builds a single-index {@link ClusterState} from the given mapping {@code properties}.
        // contract is that the caller applies the trim via RelRoot's `fields` mask). Without
     * The properties shape matches {@link OpenSearchSchemaBuilder} expectations: each  
            parsed = SqlParser.create(sql, parserConfig).parseQuery();
                .numberOfShards(shardCount)
                                    .put("index.composite.primary_data_format", "parquet")  
 * Parses SQL strings into Calcite {@link RelNode} trees for planner tests.  
        }  
        SqlValidator validator = SqlValidatorUtil.newValidator(
import org.apache.calcite.sql.validate.SqlValidatorUtil;  
            return ClusterState.builder(new ClusterName("test")).metadata(metadata.build()).build();
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());
        try (XContentBuilder mapping = XContentBuilder.builder(MediaTypeRegistry.JSON.xContent())) {
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
 * SPDX-License-Identifier: Apache-2.0
     * Builds a single-index {@link ClusterState} with explicit primary data format and shard count.  
 *  
            throw new AssertionError("Failed to parse SQL: " + sql, e);
            throw new AssertionError("Failed to build ClusterState for index: " + indexName, e);
        SqlParser.Config parserConfig = SqlParser.config().withUnquotedCasing(Casing.UNCHANGED);
import org.apache.calcite.sql.parser.SqlParseException;  
            for (String indexName : indexNames) {
}
        int shardCount
                        .put("index.composite.primary_data_format", primaryDataFormat)
import org.apache.calcite.sql.validate.SqlValidator;
                        IndexMetadata.builder(indexName)
     * test has to tell two indices apart — for example a subquery that reads a different index from the  
            SqlValidator.Config.DEFAULT
        }
        try {
                }  
        );
 * {@link PlannerImpl#runAllOptimizations(RelNode, PlannerContext)}.
import org.apache.calcite.sql.parser.SqlParser;
     * The primary format flows through to {@code FieldStorageResolver} and decides which backends
     * @param fields the field mappings applied to every index
 * Tests feed the returned RelNode directly into
                                    .putList("index.composite.secondary_data_formats", "lucene")
    }  
            catalogReader,  
            Metadata metadata = Metadata.builder().put(indexMetadata, false).build();
                try (XContentBuilder mapping = XContentBuilder.builder(MediaTypeRegistry.JSON.xContent())) {
 * this file be licensed under the Apache-2.0 license or a
/*  
package org.opensearch.analytics.planner;
import org.apache.calcite.jdbc.CalciteSchema;  
    /**
import org.apache.calcite.rel.RelNode;  
            throw new AssertionError("Failed to build ClusterState for indices: " + indexNames, e);
import org.opensearch.Version;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.ClusterName;
import org.apache.calcite.sql2rel.StandardConvertletTable;
 * production planner uses — so test SQL sees the row types the real planner receives.  
import org.opensearch.analytics.schema.OpenSearchSchemaBuilder;
import java.util.Properties;  
     * @param indexNames the indices to create; all share {@code fields}  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
import org.opensearch.core.xcontent.XContentBuilder;
            typeFactory,  
            CalciteSchema.from(schema),
     * outer query, where a single-index state would make the two indistinguishable.
        } catch (Exception e) {
 */  
                    metadata.put(
                    mapping.startObject().field("properties", fields).endObject();  
import org.apache.calcite.plan.hep.HepProgramBuilder;
                        .putList("index.composite.secondary_data_formats", "lucene")
     *
import java.util.Map;
/**
            }
            mapping.startObject().field("properties", fields).endObject();
        return converter.convertQuery(parsed, true, true).project();
        try {
 * <p>Schema construction reuses {@link OpenSearchSchemaBuilder} — the same code path
        } catch (SqlParseException e) {  
                            .settings(  
            new CalciteConnectionConfigImpl(new Properties())
import org.apache.calcite.config.CalciteConnectionConfigImpl;
        Map<String, Map<String, Object>> fields,  
import org.apache.calcite.prepare.CalciteCatalogReader;
        // Use RelRoot.project() rather than .rel: SqlToRelConverter at top level appends
     * to control the primary data format and shard count.
    public static ClusterState clusterStateWith(java.util.List<String> indexNames, Map<String, Map<String, Object>> fields) {
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
                )  
     * can scan the index's fields.
                                Settings.builder()
    ) {  
    public static ClusterState clusterStateWith(
                            .numberOfShards(1)  
