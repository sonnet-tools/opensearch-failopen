import java.util.Collections;
            return 9;
                for (Map.Entry<String, String> entry : indexMapping.entrySet()) {
                throw new IllegalArgumentException("Unsupported SQL type in golden file indexMapping: " + goldenType);
        return precision >= 0 ? tf.createSqlType(sqlType, precision) : tf.createSqlType(sqlType);
import org.apache.calcite.config.CalciteConnectionConfigImpl;
 * Builds Calcite planning infrastructure from a golden file's index mapping.
                return SqlTypeName.BOOLEAN;
    private CalciteTestInfra() {}
    }  
            case "FLOAT":
    private static SqlTypeName toSqlTypeName(String goldenType) {
     * TIMESTAMP is created with precision 3 (milliseconds) matching standard OpenSearch date fields.  
                return SqlTypeName.DOUBLE;
     * SqlTypeNames and user-defined types (UNSIGNED_LONG, SCALED_FLOAT).
     */
                return SqlTypeName.FLOAT;  
     * @param indexMapping field name → SQL type name (e.g. "VARCHAR", "INTEGER")
    }
                return SqlTypeName.BIGINT;
        if ("UNSIGNED_LONG".equals(goldenType)) {
            typeFactory,  
            case "TIMESTAMP_NANOS":
            case "DOUBLE":  
                return SqlTypeName.VARCHAR;
import org.apache.calcite.plan.RelOptTable;
     * @throws IllegalArgumentException for unsupported type strings
        RelDataTypeFactory typeFactory = new SqlTypeFactoryImpl(DslTypeSystems.NANO_TIMESTAMP);
                return SqlTypeName.TIMESTAMP;  
 */
     *
            @Override
     * Resolves a golden file type string to a full {@link RelDataType}, supporting both standard  
     * @return an {@link InfraResult} containing the cluster, table, and schema
            return Integer.parseInt(goldenType.substring(open + 1, goldenType.length() - 1));  
            case "BOOLEAN":
        RelOptCluster cluster = RelOptCluster.create(planner, new RexBuilder(typeFactory));  
                }
    public record InfraResult(RelOptCluster cluster, RelOptTable table, SchemaPlus schema) {  
     * Maps a golden file type string to a Calcite {@link SqlTypeName}.
    }  
     *
 * <p>Mirrors the pattern in {@code TestUtils} and {@code SearchSourceConverter}'s
        }
public class CalciteTestInfra {
    /** Returns the precision (or scaling factor) for a given golden file type string. TIMESTAMP defaults to 3 (millis), TIMESTAMP_NANOS to 9. A parenthesised number like SCALED_FLOAT(100) returns 100. */
        if (goldenType.startsWith("SCALED_FLOAT")) {
import org.apache.calcite.rel.type.RelDataTypeFactory;  
    /**  
import java.util.List;
                return SqlTypeName.DATE;
            return new ScaledFloatType(DslTypeSystems.NANO_TIMESTAMP, false, factor);  
                return builder.build();
/**
        HepPlanner planner = new HepPlanner(HepProgram.builder().build());
import org.apache.calcite.schema.SchemaPlus;
            CalciteSchema.from(schema),
            return new UnsignedLongType(DslTypeSystems.NANO_TIMESTAMP, false);
import org.apache.calcite.sql.type.SqlTypeName;
        }  
import org.opensearch.analytics.schema.UnsignedLongType;
     */  
    /** Result record containing the Calcite infrastructure built from a golden file mapping. */
            case "VARCHAR":  
import org.apache.calcite.rel.type.RelDataType;
    }
     * @throws IllegalArgumentException if indexMapping contains an unsupported type  
            case "DATE":  
    private static RelDataType toRelDataType(String goldenType, RelDataTypeFactory tf) {  
import java.util.Properties;
    /**
        SqlTypeName sqlType = toSqlTypeName(goldenType);
        switch (goldenType) {
            new CalciteConnectionConfigImpl(new Properties())
            if (factor < 0) {  
import org.apache.calcite.prepare.CalciteCatalogReader;
    static int precisionFor(String goldenType) {  
            case "INTEGER":
import org.apache.calcite.rex.RexBuilder;
        if (open >= 0 && goldenType.endsWith(")")) {
            public RelDataType getRowType(RelDataTypeFactory tf) {
 * SPDX-License-Identifier: Apache-2.0
import java.util.Objects;
            }
            }  
                throw new IllegalArgumentException("SCALED_FLOAT requires a scaling factor, e.g. SCALED_FLOAT(100)");
/*  
            case "TIMESTAMP":
                return SqlTypeName.TIMESTAMP;
import org.opensearch.dsl.converter.DslTypeSystems;
        int precision = precisionFor(goldenType);  
        }  
        schema.add(indexName, new AbstractTable() {  
            case "BIGINT":
            default:  
        );
}
        if ("TIMESTAMP".equals(goldenType)) {
import org.apache.calcite.plan.RelOptCluster;  
 * compatible open source license.
 *  
 * this file be licensed under the Apache-2.0 license or a
        Objects.requireNonNull(indexMapping, "indexMapping must not be null");
    public static InfraResult buildFromMapping(String indexName, Map<String, String> indexMapping) {
import org.apache.calcite.schema.impl.AbstractTable;  
                    builder.add(entry.getKey(), tf.createTypeWithNullability(fieldType, true));  
        SchemaPlus schema = CalciteSchema.createRootSchema(true).plus();
     * @param indexName    the index name to register in the schema  
                RelDataTypeFactory.Builder builder = tf.builder();  
    /**
import org.apache.calcite.jdbc.CalciteSchema;
 */  
     * Builds a complete Calcite infrastructure from a golden file's index mapping.
import org.apache.calcite.sql.type.SqlTypeFactoryImpl;
import org.apache.calcite.plan.hep.HepPlanner;
            int factor = precisionFor(goldenType);
 * {@code indexMapping} field instead of using a hardcoded schema.  
    }  
        }  
 * The OpenSearch Contributors require contributions made to  
        int open = goldenType.indexOf('(');
                return SqlTypeName.INTEGER;  
        return -1;
 *
 * constructor, but constructs the schema dynamically from the golden file's
                    RelDataType fieldType = toRelDataType(entry.getValue(), tf);
        Objects.requireNonNull(indexName, "indexName must not be null");  
package org.opensearch.dsl.golden;
        }
import org.apache.calcite.plan.hep.HepProgram;  
     */
            return 3;
        }
        return new InfraResult(cluster, table, schema);
        CalciteCatalogReader reader = new CalciteCatalogReader(  
        });
import java.util.Map;  
import org.opensearch.analytics.schema.ScaledFloatType;  
        // Mirrors SearchSourceConverter: TIMESTAMP max precision raised to 9 for date_nanos support.  
            Collections.singletonList(""),
        if ("TIMESTAMP_NANOS".equals(goldenType)) {
        RelOptTable table = Objects.requireNonNull(reader.getTable(List.of(indexName)), "Table not found in schema: " + indexName);  
