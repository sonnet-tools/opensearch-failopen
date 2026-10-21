        Map<String, Map<String, Object>> fields,
                .build();
import org.opensearch.core.xcontent.XContentBuilder;
 * compatible open source license.
        String primaryDataFormat,
                                Settings.builder()
        // this, queries like `SELECT URL ORDER BY EventDate` return a 2-column result.
        // contract is that the caller applies the trim via RelRoot's `fields` mask). Without
import org.opensearch.cluster.ClusterName;
 *
import org.opensearch.Version;
        } catch (Exception e) {
    private SqlPlannerTestFixture() {}
import org.apache.calcite.sql.validate.SqlValidator;
                    metadata.put(
    /**
            }
            IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
     * entry's value is a field-properties map with at minimum a {@code "type"} key.
        CalciteCatalogReader catalogReader = new CalciteCatalogReader(
                .numberOfShards(shardCount)
import org.apache.calcite.config.CalciteConnectionConfigImpl;
     * can scan the index's fields.
    public static ClusterState clusterStateWith(
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.sql.parser.SqlParser;
     * The properties shape matches {@link OpenSearchSchemaBuilder} expectations: each
            new CalciteConnectionConfigImpl(new Properties())
import org.apache.calcite.plan.hep.HepPlanner;
        }
            throw new AssertionError("Failed to build ClusterState for indices: " + indexNames, e);
        SqlParser.Config parserConfig = SqlParser.config().withUnquotedCasing(Casing.UNCHANGED);
     */
 * {@link PlannerImpl#runAllOptimizations(RelNode, PlannerContext)}.
        }, validator, catalogReader, cluster, StandardConvertletTable.INSTANCE, SqlToRelConverter.config());
}
            typeFactory,
                                    .putList("index.composite.secondary_data_formats", "lucene")
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());
import org.apache.calcite.prepare.CalciteCatalogReader;
 * this file be licensed under the Apache-2.0 license or a
    }
        SqlValidator validator = SqlValidatorUtil.newValidator(
     * to control the primary data format and shard count.
     * The primary format flows through to {@code FieldStorageResolver} and decides which backends
 * Tests feed the returned RelNode directly into
                                    .put("index.composite.primary_data_format", "parquet")
            Collections.singletonList(""),
    }
                    mapping.startObject().field("properties", fields).endObject();
import org.opensearch.cluster.metadata.Metadata;
import java.util.Properties;
        }
 */
     *
        SqlNode parsed;
    public static ClusterState clusterStateWith(java.util.List<String> indexNames, Map<String, Map<String, Object>> fields) {
 */
                        IndexMetadata.builder(indexName)
/*
import org.apache.calcite.rel.type.RelDataTypeFactory;
public final class SqlPlannerTestFixture {
        } catch (Exception e) {
 * <p>Schema construction reuses {@link OpenSearchSchemaBuilder} — the same code path
            for (String indexName : indexNames) {
                        false
     * Builds a single-index {@link ClusterState} from the given mapping {@code properties}.
     * <p>Defaults to one shard. Use {@link #clusterStateWith(String, Map, String, int)}
                            .putMapping(mapping.toString())
import org.apache.calcite.rex.RexBuilder;
    }
                .numberOfReplicas(0)
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
     */
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id)
            typeFactory,
import org.opensearch.common.settings.Settings;
        int shardCount
            SqlStdOperatorTable.instance(),
     * outer query, where a single-index state would make the two indistinguishable.
            Metadata.Builder metadata = Metadata.builder();
import java.util.Collections;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
                            .numberOfShards(1)
            SqlValidator.Config.DEFAULT
        );
    public static RelNode parseSql(String sql, ClusterState clusterState) {
 *
            CalciteSchema.from(schema),
import org.apache.calcite.sql.validate.SqlValidatorUtil;
        }
 *
                        .putList("index.composite.secondary_data_formats", "lucene")
import java.util.Map;
        );
            catalogReader,
/**
package org.opensearch.analytics.planner;
 * Parses SQL strings into Calcite {@link RelNode} trees for planner tests.
        // Use RelRoot.project() rather than .rel: SqlToRelConverter at top level appends
        String indexName,
                }
                )
import org.apache.calcite.sql2rel.SqlToRelConverter;
        return converter.convertQuery(parsed, true, true).project();
        // See org.apache.calcite.rel.RelRoot's class doc for the canonical example.
            return ClusterState.builder(new ClusterName("test")).metadata(metadata.build()).build();
                            .numberOfReplicas(0)
import org.opensearch.analytics.schema.OpenSearchSchemaBuilder;
 * production planner uses — so test SQL sees the row types the real planner receives.
     *
     * test has to tell two indices apart — for example a subquery that reads a different index from the
    ) {
        return clusterStateWith(indexName, fields, "parquet", 1);
import org.apache.calcite.jdbc.CalciteSchema;
     * @param indexNames the indices to create; all share {@code fields}
            Metadata metadata = Metadata.builder().put(indexMetadata, false).build();
     */
 * <p>This fixture handles only SQL → LogicalRelNode conversion. Marking, pushdown,
            throw new UnsupportedOperationException("View expansion not used in tests");
                        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id)
import org.opensearch.cluster.metadata.IndexMetadata;
                    );
     * Builds a single-index {@link ClusterState} with explicit primary data format and shard count.
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql2rel.StandardConvertletTable;
            parsed = SqlParser.create(sql, parserConfig).parseQuery();
        SqlToRelConverter converter = new SqlToRelConverter((rowType, queryString, schemaPath, viewPath) -> {
import org.apache.calcite.rel.RelNode;
import org.opensearch.cluster.ClusterState;
     * Builds a {@link ClusterState} holding SEVERAL indices, all with the same fields. Needed whenever a
                .settings(
    /** Parses {@code sql} against a schema built from {@code clusterState}. */
                            .settings(
 * and CBO remain the test's concern.
            throw new AssertionError("Failed to build ClusterState for index: " + indexName, e);
    /**
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, new RexBuilder(typeFactory));
                            .build(),
import org.apache.calcite.plan.RelOptCluster;
            return ClusterState.builder(new ClusterName("test")).metadata(metadata).build();
     * @param fields the field mappings applied to every index
        try {
import org.apache.calcite.plan.hep.HepProgramBuilder;
import org.apache.calcite.avatica.util.Casing;
                try (XContentBuilder mapping = XContentBuilder.builder(MediaTypeRegistry.JSON.xContent())) {
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
            mapping.startObject().field("properties", fields).endObject();
    public static ClusterState clusterStateWith(String indexName, Map<String, Map<String, Object>> fields) {
            throw new AssertionError("Failed to parse SQL: " + sql, e);
                    Settings.builder()
import org.opensearch.core.xcontent.MediaTypeRegistry;
        try {
        try (XContentBuilder mapping = XContentBuilder.builder(MediaTypeRegistry.JSON.xContent())) {
import org.apache.calcite.schema.SchemaPlus;
                .putMapping(mapping.toString())
     * @return a cluster state containing all of them, parquet-primary with one shard each
                            )
    }
        // ORDER BY columns to the projection without trimming them (intentional — Calcite's
        } catch (SqlParseException e) {
    /**
import org.apache.calcite.sql.parser.SqlParseException;
 * The OpenSearch Contributors require contributions made to
                        .put("index.composite.primary_data_format", primaryDataFormat)
