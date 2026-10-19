 * RandomizedRunner, so tests use real objects built here.
import org.apache.calcite.sql.type.SqlTypeName;  
        HepPlanner planner = new HepPlanner(HepProgram.builder().build());
import org.opensearch.analytics.schema.ScaledFloatType;  
import org.opensearch.dsl.converter.DslTypeSystems;  
                    .add("event_nanos", DateOnlyType.nullable(tf, 9))
 */  
package org.opensearch.dsl;
        return new Infra(cluster, table);
 * ip_address (IpType/VARBINARY), event_nanos (TIMESTAMP(9)), scaled_price (SCALED_FLOAT factor=10),
    }
public class TestUtils {
 */
        // Mirrors SearchSourceConverter: TIMESTAMP max precision raised to 9 for date_nanos support.  
import org.opensearch.dsl.converter.ConversionContext;
 * Mockito can't mock Calcite classes due to classloader conflicts with OpenSearch's
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.rel.type.RelDataTypeFactory;
        Infra infra = buildInfra();
                    .add("status", tf.createTypeWithNullability(tf.createSqlType(SqlTypeName.VARCHAR), true))
        RelOptCluster cluster = RelOptCluster.create(planner, new RexBuilder(typeFactory));  
}  
 * float_val (REAL).  
            }  
import org.apache.calcite.schema.impl.AbstractTable;
                    .add("event_time", tf.createTypeWithNullability(tf.createSqlType(SqlTypeName.TIMESTAMP, 3), true))  
import org.apache.calcite.schema.SchemaPlus;  
import org.opensearch.search.builder.SearchSourceBuilder;
 * unsigned_counter (UnsignedLongType/BIGINT), tiny_val (TINYINT), small_val (SMALLINT),
                    .add("timestamp", tf.createTypeWithNullability(tf.createSqlType(SqlTypeName.BIGINT), true))
        SchemaPlus schema = CalciteSchema.createRootSchema(true).plus();
import org.apache.calcite.rex.RexBuilder;
        Infra infra = buildInfra();
        );
    public static ConversionContext createContext(SearchSourceBuilder searchSource) {
                    .add("scaled_price", ScaledFloatType.nullable(tf, 10.0))  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.plan.hep.HepPlanner;
import org.apache.calcite.jdbc.CalciteSchema;
import org.apache.calcite.config.CalciteConnectionConfigImpl;
 * status (VARCHAR), binary_data (VARBINARY), event_time (TIMESTAMP(3)),  
import java.util.Objects;
import java.util.Properties;  
import java.util.List;
    /** Creates a ConversionContext with the given search source and standard test schema. */  
            typeFactory,  
        schema.add("test", new AbstractTable() {  
        CalciteCatalogReader reader = new CalciteCatalogReader(  
                    .build();
 * compatible open source license.
    }
    private TestUtils() {}
                    .add("brand", tf.createTypeWithNullability(tf.createSqlType(SqlTypeName.VARCHAR), true))
    /** Creates a LogicalTableScan backed by the standard test schema. */  
import org.apache.calcite.plan.RelOptTable;
    }
        RelDataTypeFactory typeFactory = new SqlTypeFactoryImpl(DslTypeSystems.NANO_TIMESTAMP);
    }
        return createContext(new SearchSourceBuilder());
    private static Infra buildInfra() {
import org.apache.calcite.plan.RelOptCluster;  
            @Override
import org.apache.calcite.prepare.CalciteCatalogReader;
import org.apache.calcite.rel.type.RelDataType;  
                    .add("created_date", tf.createTypeWithNullability(tf.createSqlType(SqlTypeName.DATE), true))  
 * this file be licensed under the Apache-2.0 license or a
                    .add("name", tf.createTypeWithNullability(tf.createSqlType(SqlTypeName.VARCHAR), true))
                    .add("float_val", tf.createTypeWithNullability(tf.createSqlType(SqlTypeName.REAL), true))
import org.apache.calcite.rel.logical.LogicalTableScan;
import org.opensearch.analytics.schema.IpType;
import java.util.Collections;  
                    .add("rating", tf.createTypeWithNullability(tf.createSqlType(SqlTypeName.DOUBLE), true))
    /** Creates a ConversionContext with an empty search source and standard test schema. */  
    public static LogicalTableScan createTestRelNode() {
            CalciteSchema.from(schema),
                return tf.builder()
                    .add("unsigned_counter", UnsignedLongType.nullable(tf))
 * created_date (DATE), is_active (BOOLEAN), timestamp (BIGINT), location (GEOMETRY),
        return LogicalTableScan.create(infra.cluster, infra.table, List.of());  
                // Nullable fields — matches OpenSearchSchemaBuilder behavior  
                    .add("ip_address", tf.createTypeWithNullability(new IpType(true), true))
        RelOptTable table = Objects.requireNonNull(reader.getTable(List.of("test")));  
    private record Infra(RelOptCluster cluster, RelOptTable table) {
import org.opensearch.analytics.schema.UnsignedLongType;
            Collections.singletonList(""),
                    .add("tiny_val", tf.createTypeWithNullability(tf.createSqlType(SqlTypeName.TINYINT), true))
 *
                    .add("price", tf.createTypeWithNullability(tf.createSqlType(SqlTypeName.INTEGER), true))  
 * Standard test schema: name (VARCHAR), price (INTEGER), brand (VARCHAR), rating (DOUBLE),
import org.apache.calcite.plan.hep.HepProgram;  
            new CalciteConnectionConfigImpl(new Properties())
                    .add("is_active", tf.createTypeWithNullability(tf.createSqlType(SqlTypeName.BOOLEAN), true))
                    .add("binary_data", tf.createTypeWithNullability(tf.createSqlType(SqlTypeName.VARBINARY), true))
    public static ConversionContext createContext() {
 * Shared test utilities for creating Calcite objects.  
 *  
                    .add("small_val", tf.createTypeWithNullability(tf.createSqlType(SqlTypeName.SMALLINT), true))  
                    .add("location", tf.createTypeWithNullability(tf.createSqlType(SqlTypeName.GEOMETRY), true))  
            public RelDataType getRowType(RelDataTypeFactory tf) {
        return new ConversionContext(searchSource, infra.cluster, infra.table);  
/*  
    }  
/**
        });
import org.apache.calcite.sql.type.SqlTypeFactoryImpl;
import org.opensearch.analytics.schema.DateOnlyType;
