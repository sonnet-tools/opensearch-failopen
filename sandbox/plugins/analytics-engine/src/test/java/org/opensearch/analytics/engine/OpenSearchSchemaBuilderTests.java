            .putMapping(mappingJson.toString())
    }
     * The build itself must not throw; downstream validation rejects any column reference
        IndexMetadata a = IndexMetadata.builder("bank_a")
    /**
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
    public void testScaledFloatStringFactorAccepted() throws Exception {
            Map.of("more_types", Map.of("created", "date", "address", "ip", "content", "text", "small_num", "short", "tiny_num", "byte"))
     */
        }
        Table table = schema.getTable("sf_idx");
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        assertEquals(SqlTypeName.BIGINT, OpenSearchSchemaBuilder.mapFieldType("long"));
            "dense_vector",
    /**
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        assertNotNull("Mixed-case schema lookup must work", schema.getTable("My_Table"));
    }
    public void testCalciteRejectsQueryReferencingDroppedColumn() throws Exception {
    }
    /** date with date-only format produces a DateOnlyType marker (TIMESTAMP-backed). */
    }
        ClusterState clusterState = buildClusterStateRaw("mixed_idx", mapping);
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RelDataTypeField field = rowType.getField("t", true, false);
        ClusterState clusterState = buildClusterStateRaw("malformed_idx", mapping);
        );
        assertEquals("IpType must still report VARBINARY for operator dispatch", SqlTypeName.VARBINARY, ipType.getSqlTypeName());
import org.opensearch.analytics.schema.BinaryType;
    // --- helpers ---
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
     */
        assertNotNull("Table types_index should exist in schema", table);
        return ClusterState.builder(new ClusterName("test")).metadata(metadataBuilder.build()).build();
        StringBuilder mappingJson = new StringBuilder("{\"properties\":{");
            + "\"price100\":{\"type\":\"scaled_float\",\"scaling_factor\":100}"
    public void testCalciteValidatesQuerySkippingUnsupportedField() throws Exception {
        Map<String, String> ordered = new LinkedHashMap<>(fieldTypes);
    }
    /**
        RelDataTypeField field = rowType.getField(fieldName, true, false);
    }
    public void testBuildSchemaWithIntegerFloatBoolean() throws Exception {
     * indices' fields — the shape {@code source=a, b} produces after Relation comma-joins names.
        assertNotNull(field);
            .numberOfReplicas(0)
    }
     * {@code IndexNameExpressionResolver} (OpenSearch index names must be lowercase). This lets
        String mapping = "{\"properties\":{"
        // Calcite uppercases unquoted identifiers by default; compare case-insensitively.
     */
            metadataBuilder.put(buildIndexMetadata(entry.getKey(), entry.getValue()), false);
        RelDataTypeField field = schema.getTable("nanos_idx").getRowType(nanosTypeFactory()).getField("d", true, false);
     * IP and binary fields are wrapped in dedicated {@link IpType} / {@link BinaryType} markers
     * enumeration of the cluster's index list at schema construction.
    /**
        assertEquals(SqlTypeName.REAL, OpenSearchSchemaBuilder.mapFieldType("float"));
        assertEquals(SqlTypeName.VARCHAR, OpenSearchSchemaBuilder.mapFieldType("text"));
        Table table = schema.getTable("time_only_idx");
     * of the matching concrete indices' supported fields. Mirrors the sql-plugin behavior where
     * Calcite's default of 3. The production type factory mirrors this; the default
        Table table = schema.getTable("date_only_idx");
        ClusterState clusterState = buildClusterState(
     * Calcite's uppercased identifier resolution find a lower-cased index without needing eager
    /** Negative scaling_factor excludes the field from schema. */
        for (Map.Entry<String, Map<String, String>> entry : indices.entrySet()) {
        assertNotNull("Table more_types should exist in schema", table);
    public void testDateFieldWithDateOnlyFormatHasMillisPrecision() throws Exception {
    }
        assertNotNull("Table mixed_index should exist despite unsupported fields", table);
    public void testAllUnsupportedFieldsProduceEmptyRowType() throws Exception {
    /**
        assertTrue("Expected DateOnlyType marker", field.getType() instanceof DateOnlyType);
    public void testCommaSeparatedSourcesResolveToUnionedTable() throws Exception {
    }
            "percolator",
        assertNull("geo_shape column must be dropped", rowType.getField("shape_field", true, false));
    /** Plain {@code date_nanos} with no format → {@code TIMESTAMP(9)} (nanos). */
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
    /**
        String mapping = "{\"properties\":{\"t\":{\"type\":\"date\",\"format\":\"hour_minute_second\"}}}";
        assertEquals(SqlTypeName.VARCHAR, OpenSearchSchemaBuilder.mapFieldType("keyword"));
        assertEquals("Parent field is preserved; multi-fields subtree is ignored", 1, rowType.getFieldCount());
    /** scaled_float with valid factor produces a ScaledFloatType marker (BIGINT-backed). */
            "age must be one of the two types",
        RelDataTypeField ageField = rowType.getField("age", true, false);
        boolean first = true;
        // resolved). PPL hits the schema via RelBuilder.scan with the user-typed case directly;
        });
        Table table = schema.getTable("multifield_idx");
     */
        assertNotNull(schema);
    public void testMultiFieldsSubtypeDoesNotAffectParent() throws Exception {
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
    public void testDateFieldWithTimeOnlyFormatProducesTimeUDT() throws Exception {
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        ClusterState clusterState = buildClusterStateRaw("date_only_idx", mapping);
        // unique fields from each index must appear
     */
        IndexMetadata idx1 = buildIndexMetadata("index_a", Map.of("col1", "keyword"));
     */
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
        Table table = schema.getTable("sf_neg_idx");
        IndexMetadata b = IndexMetadata.builder("bank_b")
        assertNotNull(table);
        assertTrue("Schema should have no tables", schema.getTableNames().isEmpty());
            .build();
     * nanos precision — same parquet-read constraint as {@link DateOnlyType}.
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
    public void testDateFieldWithDateOnlyFormatProducesDateUDT() throws Exception {
        assertNotNull(table);
        assertNotNull("Table index_b should exist", schema.getTable("index_b"));
        Table table = schema.getTable("test*");
     * exists and unique-per-index fields from both indices appear in the union.
     * Defensive: mapFieldType called with null must return null (treated as "unknown") rather
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
import org.apache.calcite.tools.Planner;
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
    }
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
        ClusterState clusterState = buildClusterStateRaw("nested_geo", mapping);
        IndexMetadata idx1 = buildIndexMetadata("bank", Map.of("age", "long", "name", "keyword"));
            .numberOfShards(1)
    }
        assertEquals("Field '" + fieldName + "' should have type " + expectedType, expectedType, field.getType().getSqlTypeName());
     */
        assertNotEquals("factor-10 and factor-100 must be distinct type objects", type10, type100);
    }
        // reach the validator as-typed. Default Calcite parsing uppercases unquoted identifiers
        ClusterState clusterState = buildClusterStateRaw("date_only_ms_idx", mapping);
            .build();
        Table table = schema.getTable("bank,test");
     */
        // (Lex.ORACLE), which would force a case-insensitive validator + getTableNames()
        ClusterState clusterState = buildClusterStateRaw("sf_no_factor_idx", mapping);
     * sibling supported columns.
    }
            + "}}";
        ClusterState clusterState = buildClusterState(Map.of("test", Map.of("age", "long")));
        assertFieldType(rowType, "name", SqlTypeName.VARCHAR);
        Metadata metadata = Metadata.builder().put(idx1, false).put(idx2, false).build();
    public void testScaledFloatDigestDistinctness() throws Exception {
        assertEquals("date_nanos must carry nanos precision", 9, field.getType().getPrecision());
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
            if (cur.getMessage() != null) {
        assertFieldType(rowType, "small_num", SqlTypeName.SMALLINT);
        assertEquals(SqlTypeName.BIGINT, field.getType().getSqlTypeName());
            .build();
        ClusterState clusterState = buildClusterState(Map.of("test_index", Map.of("name", "keyword", "age", "long", "score", "double")));
        );
            .putAlias(AliasMetadata.builder("bank_all").build())
import org.apache.calcite.tools.Frameworks;
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
                if (typeName == SqlTypeName.TIMESTAMP || typeName == SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE) {
        Table table = schema.getTable("bank,test");
     * Test that nested/object fields are skipped.
        RelDataTypeField field = rowType.getField("price", true, false);
        assertEquals("date must carry millis precision", 3, field.getType().getPrecision());
     * Comma-separated sources with field-name conflict: first-resolved-wins semantics. The
        assertFalse("plain long must NOT be UnsignedLongType", signedType instanceof UnsignedLongType);
     * go through {@code typeFactory.canonize}).
import org.apache.calcite.schema.Table;
        Table table = schema.getTable("nested_index");
        assertEquals("Should only have 'name' field, skipping object/nested", 1, rowType.getFieldCount());
            .numberOfReplicas(0)
    public void testNonMatchingPatternYieldsNoTable() throws Exception {
        String mapping = "{\"properties\":{\"price\":{\"type\":\"scaled_float\",\"scaling_factor\":10}}}";
        ClusterState clusterState = buildClusterState(
     * Type mapping: keyword->VARCHAR, long->BIGINT, double->DOUBLE
        // LinkedHashMap preserves declaration order so the assertions on field positions are stable.
import org.opensearch.cluster.metadata.IndexMetadata;
    /**
     */
import org.opensearch.analytics.schema.OpenSearchSchemaBuilder;
     * unaffected because both extend {@link org.apache.calcite.sql.type.AbstractSqlType} with
        assertFieldType(rowType, "customer.age", SqlTypeName.INTEGER);
    public void testScaledFloatNegativeFactorExcludesField() throws Exception {
    /**
import org.apache.calcite.rel.type.RelDataType;
     * existing object-recursion branch enters but finds nothing to add, so the field is
     * returns first determines the type. Both are valid; the key invariant is that the field
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
    // --- unsigned_long tests ---
            .numberOfReplicas(0)
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
            planner.close();
    }
        ClusterState clusterState = buildClusterState(
        assertFieldType(rowType, "alias_field", SqlTypeName.VARCHAR);
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(state);
    public void testDateNanosFieldWithDateOnlyFormatHasNanosPrecision() throws Exception {
    /** Factor-10 and factor-100 ScaledFloatType instances are digest-distinct (canonicalization trap). */
     * Unsupported / unknown field types degrade to a null SqlTypeName. The schema builder drops
        for (Map.Entry<String, String> field : ordered.entrySet()) {
        assertNull("Field without scaling_factor must be excluded", rowType.getField("price", true, false));
     * nanos precision. This is the regression #22049 fixed for the plain-TIMESTAMP path; the
     */
            }
        assertNotNull(field);
public class OpenSearchSchemaBuilderTests extends OpenSearchTestCase {
     * Test date, ip, text, short, byte type mappings.
    }
        assertFalse("mixed format must NOT produce a Date/Time UDT", field.getType() instanceof TimeOnlyType);
        assertFieldType(rowType, "name", SqlTypeName.VARCHAR);
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
        for (Throwable cur = t; cur != null; cur = cur.getCause()) {
     */
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
    }
        assertEquals(SqlTypeName.VARCHAR, tagsType.getComponentType().getSqlTypeName());
        }
        assertNotNull("Field '" + fieldName + "' should exist", field);
        RelDataType rowType = schema.getTable("bank_all").getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
        Table table = schema.getTable("types_index");
            "sparse_vector",
    }
import org.opensearch.analytics.schema.UnsignedLongType;
    /** Zero scaling_factor excludes the field from schema. */
        }
        assertFieldType(rowType, "customer.id", SqlTypeName.VARCHAR);
            + "\"normal\":{\"type\":\"keyword\"},"
        assertNotNull("Comma list 'bank,test' should resolve to a table", table);
        RelDataTypeField field = schema.getTable("plain_date_idx").getRowType(nanosTypeFactory()).getField("d", true, false);
    public void testDateFieldWithoutFormatHasMillisPrecision() throws Exception {
    public void testDateNanosFieldWithoutFormatHasNanosPrecision() throws Exception {
        assertFieldType(rowType, "active", SqlTypeName.BOOLEAN);
            public int getMaxPrecision(SqlTypeName typeName) {
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        assertEquals("Only the 2 supported fields should be present", 2, rowType.getFieldCount());
        // would trigger if the schema regressed to case-sensitive resolver invocation.
    /** String-valued scaling_factor (e.g. "10") is accepted and parsed. */
     * Multi-fields (`fields`) sub-mapping is currently NOT walked — only the top-level
        );
    public void testLogicalTypeEqualityIsDigestBased() {
     * millis precision. Without this, the parquet-read path's Timestamp(Millisecond) clashes
     * can resolve {@code SELECT * FROM alias}. The exposed row type is the field-union of every
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        Metadata metadata = Metadata.builder().put(idx1, false).put(idx2, false).build();
        ClusterState clusterState = buildClusterState(Map.of("kai_repro", Map.of("name", "keyword", "loc", "geo_point")));
        FrameworkConfig config = Frameworks.newConfigBuilder()
        );
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
     * This is the load-bearing contract behind the schema-degradation fix.
    public void testBuildSchemaExposesAliasAsTable() throws Exception {
     * contract added by #22049 so the date-only / time-only UDT paths can mirror it.
        RelDataTypeField field = schema.getTable("date_only_ms_idx").getRowType(nanosTypeFactory()).getField("d", true, false);
import java.util.Map;
import org.opensearch.cluster.ClusterName;
     */
        RelDataType ipType = rowType.getField("address", true, false).getType();
 * SPDX-License-Identifier: Apache-2.0
            Map.of("all_unsupported", Map.of("loc", "geo_point", "shape", "geo_shape", "feat", "completion"))
        // End-to-end via the SQL path: validate+convert succeeds against the lower-cased index.
            Map.of("types_index", Map.of("count", "integer", "ratio", "float", "active", "boolean"))
        ClusterState clusterState = buildClusterStateRaw("sf_str_idx", mapping);
    /**
        assertNotNull("Upper-case schema lookup must work", schema.getTable("MY_TABLE"));
     * {@code buildLeafType} for {@code date_nanos} is observable rather than silently clamped to
        assertNotNull("String factor '10' must be accepted", field);
    public void testMalformedFieldWithoutTypeOrPropertiesIsSkipped() throws Exception {
     * Plain {@code date} with no format → {@code TIMESTAMP(3)} (millis). Pins the precision
            SqlNode parsed = planner.parse(sql);
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        assertFieldType(rowType, "balance", SqlTypeName.BIGINT);
            return planner.rel(validated).project();
            .numberOfShards(1)
     * {@code date} with date-only format produces a {@link DateOnlyType} that still carries
        Table table = schema.getTable("sf_zero_idx");
import org.apache.calcite.rel.type.RelDataTypeField;
        Table table = schema.getTable("udt_index");
            fullMessage.contains("Unsupported OpenSearch field type")
        } finally {
     */
            "alias",
        assertEquals("Only 2 supported nested leaves should remain", 2, rowType.getFieldCount());
        assertFieldType(rowType, "score", SqlTypeName.DOUBLE);
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(metadata).build();
    }
            Map.of("mixed_long_idx", Map.of("signed_val", "long", "unsigned_val", "unsigned_long"))
        assertTrue("unsigned_long must be UnsignedLongType", unsignedType instanceof UnsignedLongType);
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        ClusterState state = ClusterState.builder(new ClusterName("test"))
}
        String mapping = "{\"properties\":{"
    }
        String mapping = "{\"properties\":{\"price\":{\"type\":\"scaled_float\",\"scaling_factor\":-5}}}";
        ClusterState clusterState = buildClusterState(Map.of("udt_index", Map.of("address", "ip", "blob", "binary")));
            + "\"locked\":{\"type\":\"keyword\",\"multi_value\":false}"
    }
    public void testDateFieldWithoutFormatStaysTimestamp() throws Exception {
     */
        assertTrue("ip column must be IpType, got " + ipType.getClass(), ipType instanceof IpType);
        assertEquals(SqlTypeName.VARCHAR, OpenSearchSchemaBuilder.mapFieldType("match_only_text"));
        assertNotNull(table);
     * Test that buildSchema produces a table for each index with correct column types.
     */
    public void testScaledFloatFieldWithFactorProducesScaledFloatType() throws Exception {
    public void testMultiValueKeywordBuildsNullableArrayType() throws Exception {
        String mapping = "{\"properties\":{\"t\":{\"type\":\"date_nanos\",\"format\":\"hour_minute_second\"}}}";
import org.opensearch.test.OpenSearchTestCase;
            .operatorTable(SqlStdOperatorTable.instance())
     */
        ClusterState clusterState = buildClusterState(Map.of("my_table", Map.of("name", "keyword", "age", "long")));
        assertTrue("Expected DateOnlyType marker, got " + field.getType().getClass(), field.getType() instanceof DateOnlyType);
        );
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
            "date_range",
        String mapping = "{\"properties\":{"
    public void testMapFieldTypeForAllSupportedTypes() {
            + "\"age\":{\"type\":\"integer\"}"
        assertFieldType(rowType, "name", SqlTypeName.VARCHAR);
     * index whose mapping contains an unsupported field must succeed. This is the scan_viability
        return ClusterState.builder(new ClusterName("test")).metadata(metadata).build();
        // enumeration — incompatible with the lazy schema (table names aren't enumerable until
        ClusterState clusterState = buildClusterState(java.util.Map.of("plain_date_idx", java.util.Map.of("d", "date")));
        assertEquals("age", rel.getRowType().getFieldList().get(1).getName().toLowerCase(java.util.Locale.ROOT));
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        RelDataTypeField field = schema.getTable("date_only_ns_idx").getRowType(nanosTypeFactory()).getField("d", true, false);
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
    public void testMapFieldTypeReturnsNullOnNullInput() {
    }
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
     * {@code date_nanos} with date-only format produces a {@link DateOnlyType} that carries
import org.apache.calcite.schema.SchemaPlus;
            + "\"name\":{\"type\":\"keyword\",\"fields\":{"
            .numberOfShards(1)
 *
import org.opensearch.cluster.metadata.AliasMetadata;
        assertTrue(field.getType() instanceof ScaledFloatType);
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
            first = false;
    /**
        assertEquals(10.0, ((ScaledFloatType) field.getType()).getScalingFactor(), 0.0);
        assertFalse(field.getType() instanceof TimeOnlyType);
     * Test that multiple indices produce multiple tables.
        assertNotNull("Wildcard 'test*' should resolve to a table", table);
    }
        ClusterState clusterState = buildClusterState(Map.of("kai_repro", Map.of("name", "keyword", "loc", "geo_point", "age", "long")));
     * so the SQL plugin can disambiguate them at the response boundary. Operator dispatch is
import org.opensearch.cluster.ClusterState;
            .getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
            .build();
    /**
        ClusterState clusterState = buildClusterStateRaw("sf_digest_idx", mapping);
        RelDataType binType = rowType.getField("blob", true, false).getType();
            Map.of("nested_index", Map.of("name", "keyword", "address", "object", "tags", "nested"))
        ClusterState clusterState = buildClusterStateRaw("multi_value_index", mapping);
        assertNotNull("Table index_a should exist", schema.getTable("index_a"));
            "point",
    public void testUnsupportedFieldTypesReturnNull() {
     * "column not found", not at planning time with an IllegalArgumentException.
        return sb.toString();
            "token_count",
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        assertEquals(SqlTypeName.VARBINARY, OpenSearchSchemaBuilder.mapFieldType("binary"));
        StringBuilder sb = new StringBuilder();
            + "\"weird\":{\"index\":\"not_analyzed\"}"  // no "type", no "properties"
        assertFalse(field.getType() instanceof DateOnlyType);
     */
    /**
            }
    /** date with mixed format defaults to plain TIMESTAMP. */
        String fullMessage = collectMessages(ex);
    }
            "integer_range",
        // this config mirrors that for SQL-based unit tests.
        assertFieldType(rowType, "name", SqlTypeName.VARCHAR);
    public void testEmptyClusterStateProducesEmptySchema() {
        assertFieldType(rowType, "address", SqlTypeName.VARBINARY);
     * addLeafFields drops the unsupported leaf without aborting the recursion or losing
    public void testDateNanosFieldWithTimeOnlyFormatHasNanosPrecision() throws Exception {
        RelDataType b = IpType.nullable();
        assertEquals("Result must have exactly the 2 projected columns", 2, rel.getRowType().getFieldCount());
        ClusterState clusterState = buildClusterStateRaw("sf_idx", mapping);
     * {@code JavaTypeFactoryImpl} doesn't.
        assertEquals("DateOnlyType over date must carry millis precision", 3, field.getType().getPrecision());
    public void testCommaSeparatedSourcesFieldConflictPicksOne() throws Exception {
        assertTrue("Expected DateOnlyType marker", field.getType() instanceof DateOnlyType);
        assertEquals(3, rowType.getFieldCount());
        String mapping = "{\"properties\":{\"x\":{\"type\":\"date\",\"format\":\"yyyy-MM-dd HH:mm:ss\"}}}";
        RelDataType a = IpType.nullable();
        String mapping = "{\"properties\":{\"d\":{\"type\":\"date\",\"format\":\"basic_date\"}}}";
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        assertNotNull(field);
    public void testCaseInsensitiveTableResolution() throws Exception {
     * Calcite end-to-end: projecting a DROPPED unsupported column must surface as a validator
        RelDataTypeField field = rowType.getField("price", true, false);
        assertFieldType(rowType, "locked", SqlTypeName.VARCHAR);
     * A single wildcard source ({@code test*}) resolves to one table whose row type is the union
    }
        assertNull("geo_point column must be dropped", rowType.getField("location", true, false));
     */
    }
        RelDataTypeField field = rowType.getField("d", true, false);
        Table table = schema.getTable("sf_no_factor_idx");
     * supported ones — the unsupported columns are dropped silently rather than aborting the
     * {@code source=test*} resolves against the cluster's index expression.
        Planner planner = Frameworks.getPlanner(config);
        assertEquals(SqlTypeName.TIMESTAMP, field.getType().getSqlTypeName());
        assertEquals("DateOnlyType over date_nanos must carry nanos precision", 9, field.getType().getPrecision());
        assertEquals(10.0, ((ScaledFloatType) field.getType()).getScalingFactor(), 0.0);
     */
    public void testBuildSchemaWithDateIpTextShortByte() throws Exception {
        assertEquals(SqlTypeName.TIMESTAMP, OpenSearchSchemaBuilder.mapFieldType("date_nanos"));
            "constant_keyword",
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
import org.opensearch.analytics.schema.IpType;
     */
     * Field with no "type" property and no "properties" sub-map (malformed mapping). The
     */
    /**
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        );
    public void testBuildSchemaWithKeywordLongDouble() throws Exception {
        assertNotNull("Exact-case schema lookup must work", schema.getTable("my_table"));
        assertEquals("Only the well-formed field should survive", 1, rowType.getFieldCount());
        try {
    /** Missing scaling_factor excludes the field from schema (does not throw). */
            @Override
        IndexMetadata idx2 = buildIndexMetadata("test", Map.of("age", "keyword", "score", "double"));
            + "}}";
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        Table table = schema.getTable("test_index");
            .settings(settings(Version.CURRENT))
     * backing index — fields absent from some indices appear as nullable columns in the alias
        // Both report BIGINT
        assertEquals(SqlTypeName.SMALLINT, OpenSearchSchemaBuilder.mapFieldType("short"));
        assertEquals(SqlTypeName.BIGINT, signedType.getSqlTypeName());
    private static String collectMessages(Throwable t) {
    /**
    }
            + "\"home\":{\"type\":\"geo_point\"},"
            .metadata(Metadata.builder().put(a, false).put(b, false).build())
    private void assertFieldType(RelDataType rowType, String fieldName, SqlTypeName expectedType) {
        assertNotNull(field);
        }
        String mapping = "{\"properties\":{\"d\":{\"type\":\"date_nanos\",\"format\":\"basic_date\"}}}";
    /** unsigned_long field produces an UnsignedLongType marker (BIGINT-backed). */
        ClusterState clusterState = buildClusterState(
        assertFieldType(rowType, "age", SqlTypeName.BIGINT);
    }
     * Test mapFieldType for all supported types.
     * than NPE. Mirrors the analytics-framework FieldType.fromMappingType convention.
    }
            Map.of("mixed_index", Map.of("name", "keyword", "location", "geo_point", "shape_field", "geo_shape", "age", "long"))
            + "\"tags\":{\"type\":\"keyword\",\"multi_value\":true},"
    }
                }
        Table table = schema.getTable("mixed_index");
            .putMapping(mappingJson)
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
        String mapping = "{\"properties\":{"
        assertEquals("All-unsupported index produces 0-column rowType", 0, rowType.getFieldCount());
import org.apache.calcite.sql.SqlNode;
            .defaultSchema(schema)
        return IndexMetadata.builder(indexName)
    /** Parse + validate + convert SQL against the given Calcite schema; throws on validator error. */
            "completion",
        assertFieldType(rowType, "count", SqlTypeName.INTEGER);
        Metadata metadata = Metadata.builder().put(indexMetadata, false).build();
        assertEquals(SqlTypeName.BIGINT, unsignedType.getSqlTypeName());
        assertEquals(SqlTypeName.VARBINARY, OpenSearchSchemaBuilder.mapFieldType("ip"));
     */
                    return 9;
     */
        IndexMetadata idx2 = buildIndexMetadata("index_b", Map.of("col2", "long"));
            "geo_point",
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        assertNotNull("Calcite should produce a RelNode for projection-of-supported-only", rel);
     * / planner caching works without requiring Calcite type-factory canonicalization (we don't
 * The OpenSearch Contributors require contributions made to
    public void testWildcardPatternResolvesToUnionedTable() throws Exception {
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
            + "\"loc\":{\"type\":\"geo_point\"}"
            .settings(settings(Version.CURRENT))
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        // Exact-case lookup must work — this is the storage truth.
        RelDataType rowType = OpenSearchSchemaBuilder.buildSchema(clusterState)
        assertNotNull("Conflicting field 'age' must still appear in union", ageField);
        Table table = schema.getTable("all_unsupported");
        assertTrue("multi-value field must remain nullable", tagsType.isNullable());
     * Test that an empty ClusterState produces an empty schema.
    /**
    public void testUnsignedLongFieldProducesUnsignedLongType() throws Exception {
     */
     * such columns so a downstream query referencing one fails at validation time with
        assertNotNull("Query via SQL path must succeed", rel);
    /**
        RelDataTypeField field = rowType.getField("x", true, false);
            fullMessage.toLowerCase(java.util.Locale.ROOT).contains("loc")
            + "\"id\":{\"type\":\"keyword\"},"
        RelDataTypeField field = rowType.getField("counter", true, false);
        String mapping = "{\"properties\":{\"price\":{\"type\":\"scaled_float\",\"scaling_factor\":\"10\"}}}";
        assertFieldType(rowType, "age", SqlTypeName.BIGINT);
 * this file be licensed under the Apache-2.0 license or a
     * "type" matters. An unsupported multi-field subtype thus has zero effect on the parent
        );
        String mapping = "{\"properties\":{\"price\":{\"type\":\"scaled_float\"}}}";
     */
     * at plan time rather than an empty-row-type table.
    }
        assertNotNull(table);
     * Case-insensitive table resolution: Calcite uppercases unquoted identifiers. The schema
        assertFieldType(rowType, "score", SqlTypeName.DOUBLE);
     * Type factory whose {@code getMaxPrecision(TIMESTAMP)} is 9 — so a precision request from
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(metadata).build();
        ClusterState clusterState = buildClusterState(Map.of("ul_idx", Map.of("counter", "unsigned_long")));
     */
    }
    public void testUnsignedLongDigestDistinctFromPlainBigint() throws Exception {
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
    private ClusterState buildClusterState(Map<String, Map<String, String>> indices) throws Exception {
        Table table = schema.getTable("sf_digest_idx");
                sb.append(cur.getMessage()).append(" | ");
        Table table = schema.getTable("nested_geo");
        RelDataTypeField field = schema.getTable("time_only_ns_idx").getRowType(nanosTypeFactory()).getField("t", true, false);
        assertEquals(SqlTypeName.TIMESTAMP, OpenSearchSchemaBuilder.mapFieldType("date"));
            "ip_range",
        assertNotNull("Comma-separated expression must resolve", table);
    /**
    /**
        assertEquals(a, b);
        assertEquals(SqlTypeName.ARRAY, tagsType.getSqlTypeName());
    }
        assertNotSame(a, c);
                return super.getMaxPrecision(typeName);
            + "\"raw\":{\"type\":\"keyword\"},"
        String mapping = "{\"properties\":{"
        assertNotNull("Table test_index should exist in schema", table);
            if (!first) mappingJson.append(",");
    /**
        ClusterState clusterState = buildClusterStateRaw("sf_neg_idx", mapping);
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
     * Nested object containing geo_point + supported leaves. Confirms the recursive path in
    }
            ageField.getType().getSqlTypeName() == SqlTypeName.BIGINT || ageField.getType().getSqlTypeName() == SqlTypeName.VARCHAR
import org.opensearch.analytics.schema.TimeOnlyType;
        Table table = schema.getTable("more_types");
        }
            + "}}"
import java.util.LinkedHashMap;
        assertEquals(SqlTypeName.BIGINT, OpenSearchSchemaBuilder.mapFieldType("unsigned_long"));
     * The schema's lazy {@code get()} lower-cases incoming lookup names before consulting
    public void testDateFieldWithMixedFormatStaysTimestamp() throws Exception {
            mappingJson.append("\"").append(field.getKey()).append("\":{\"type\":\"").append(field.getValue()).append("\"}");
        assertNotNull("Table must exist even when every field is unsupported", table);
    public void testNestedAndObjectFieldsSkipped() throws Exception {
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
     * field 'age' appears as long in bank and keyword in test — whichever index the resolver
        Table table = schema.getTable("ul_idx");
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
     * with the schema's precision-0 default at coordinator reduce.
    }
import org.opensearch.analytics.schema.ScaledFloatType;
import org.apache.calcite.sql.type.SqlTypeName;
    public void testMultipleIndicesProduceMultipleTables() throws Exception {
        assertFieldType(rowType, "content", SqlTypeName.VARCHAR);
    }
        ClusterState clusterState = buildClusterStateRaw("time_only_idx", mapping);
    // --- scaled_float tests ---
        // Calcite wraps validator errors; walk the cause chain for the column name.
        );
        assertNull("Non-matching pattern 'nonexistent*' should resolve to no table", schema.getTable("nonexistent*"));
        assertNull("Multi-field 'raw' is not currently surfaced as a column", rowType.getField("name.raw", true, false));
    /**
            + "}}";
     * UDT path must mirror it or multi-shard sort fails with
     * A comma-separated multi-source ({@code bank,test}) resolves to one table unioning both
            "geo_shape",
        ClusterState clusterState = buildClusterStateRaw("time_only_ns_idx", mapping);
        RelDataTypeField field = rowType.getField("d", true, false);
        assertTrue("Expected ScaledFloatType marker, got " + field.getType().getClass(), field.getType() instanceof ScaledFloatType);
            .putMapping("{\"properties\":{\"age\":{\"type\":\"long\"}}}")
 */
    }
    public void testScaledFloatMissingFactorExcludesField() throws Exception {
     * A pattern matching no index yields no table, so Calcite surfaces a clean "table not found"
        ClusterState clusterState = buildClusterState(java.util.Map.of("plain_date_idx", java.util.Map.of("d", "date")));
        RelDataType tagsType = rowType.getField("tags", true, false).getType();
            + "\"customer\":{\"properties\":{"
     * error naming the column — not as IllegalArgumentException, NPE, or silent null.
        Table table = schema.getTable("malformed_idx");
        assertFieldType(rowType, "tiny_num", SqlTypeName.TINYINT);
            .build();
        ClusterState clusterState = buildClusterState(java.util.Map.of("nanos_idx", java.util.Map.of("d", "date_nanos")));
    }
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
    private ClusterState buildClusterStateRaw(String indexName, String mappingJson) throws Exception {
     */
    /**
        assertNotEquals(a, c);
        assertEquals(SqlTypeName.TIMESTAMP, field.getType().getSqlTypeName());
    public void testNestedObjectWithUnsupportedLeafDropsOnlyThatLeaf() throws Exception {
        assertNull("Multi-field 'loc' is not currently surfaced as a column", rowType.getField("name.loc", true, false));
     * naturally because the rowType has zero columns.
        assertFieldType(rowType, "normal", SqlTypeName.VARCHAR);
    }
    /**
            Map.of("test", Map.of("name", "keyword", "age", "long"), "test1", Map.of("name", "keyword", "alias_field", "keyword"))
        assertFalse("mixed format must NOT produce a Date/Time UDT", field.getType() instanceof DateOnlyType);
        assertTrue("Expected TimeOnlyType marker", field.getType() instanceof TimeOnlyType);
     * entire schema build for the index.
        assertTrue("binary column must be BinaryType, got " + binType.getClass(), binType instanceof BinaryType);
        );
        assertTrue(
    public void testScaledFloatZeroFactorExcludesField() throws Exception {
            + "\"price10\":{\"type\":\"scaled_float\",\"scaling_factor\":10},"
        assertNotNull("backing concrete index still present", schema.getTable("bank_a"));
    /**
        assertNotNull(table);
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
        Table table = schema.getTable("sf_str_idx");
        ClusterState clusterState = buildClusterState(
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
    /** date with time-only format produces a TimeOnlyType marker. */
     */
            .numberOfShards(1)
        assertTrue(
        assertNull("Field with negative scaling_factor must be excluded", rowType.getField("price", true, false));
    /**
     * Index whose every field is unsupported still emits a Calcite Table — with an empty rowType.
import org.opensearch.Version;
        assertEquals("name", rel.getRowType().getFieldList().get(0).getName().toLowerCase(java.util.Locale.ROOT));
        ClusterState clusterState = buildClusterStateRaw("sf_zero_idx", mapping);
        );
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
import org.apache.calcite.sql.parser.SqlParser;
    /** date without an explicit format keeps default TIMESTAMP behavior. */
        // Preserve the original case of unquoted identifiers so both table names and column names
     * {@code date_nanos} with time-only format produces a {@link TimeOnlyType} that carries
            + "}}"
     * column. Pinning current behavior so a future change to walk `fields` is intentional.
        assertNull("Field with zero scaling_factor must be excluded", rowType.getField("price", true, false));
    /**
        return new org.apache.calcite.jdbc.JavaTypeFactoryImpl(new org.apache.calcite.rel.type.RelDataTypeSystemImpl() {
            .parserConfig(SqlParser.config().withUnquotedCasing(org.apache.calcite.avatica.util.Casing.UNCHANGED))
        assertTrue("Expected UnsignedLongType marker, got " + field.getType().getClass(), field.getType() instanceof UnsignedLongType);
        assertFieldType(rowType, "created", SqlTypeName.TIMESTAMP);
package org.opensearch.analytics.engine;
            .settings(settings(Version.CURRENT))
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
            "flat_object",
            + "}}";
            "wildcard",
        Table table = schema.getTable("mixed_idx");
            "Must NOT surface as IllegalArgumentException 'Unsupported OpenSearch field type'; got: " + fullMessage,
    public void testIndexWithUnsupportedFieldsDropsThoseColumns() throws Exception {
            assertNull("Expected null for unsupported type [" + unsupported + "]", OpenSearchSchemaBuilder.mapFieldType(unsupported));
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        RelDataType type10 = rowType.getField("price10", true, false).getType();
        assertNotNull(table);
        assertEquals(SqlTypeName.DOUBLE, OpenSearchSchemaBuilder.mapFieldType("double"));
        assertEquals(SqlTypeName.TIMESTAMP, field.getType().getSqlTypeName());
        assertFieldType(rowType, "age", SqlTypeName.BIGINT);
     * Calcite end-to-end: parsing and validating a query that projects a SUPPORTED column on an
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
            .getTable("multi_value_index")
        assertFieldType(rowType, "ratio", SqlTypeName.REAL);
        assertEquals(SqlTypeName.BOOLEAN, OpenSearchSchemaBuilder.mapFieldType("boolean"));
        ClusterState clusterState = buildClusterState(
        assertNull(OpenSearchSchemaBuilder.mapFieldType(null));
    }
        RelNode rel = parseValidateConvert(schema, "SELECT name FROM my_table");
        RelNode rel = parseValidateConvert(schema, "SELECT name, age FROM kai_repro");
        // Upper-cased lookup must work — exercises the lowercase-on-lookup behavior directly
        // 'age' exists — could be BIGINT or VARCHAR depending on resolver order
     * bug reproducer pattern — geo_point in mapping but not in projection.
        ClusterState clusterState = buildClusterStateRaw("multifield_idx", mapping);
        ClusterState clusterState = buildClusterStateRaw("date_only_ns_idx", mapping);
        assertTrue("Expected TimeOnlyType marker, got " + field.getType().getClass(), field.getType() instanceof TimeOnlyType);
        String mapping = "{\"properties\":{\"d\":{\"type\":\"date\",\"format\":\"basic_date\"}}}";
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
        assertEquals(SqlTypeName.REAL, OpenSearchSchemaBuilder.mapFieldType("half_float"));
    public void testIpAndBinaryFieldsCarryLogicalTypeUdt() throws Exception {
     * Aliases over indices show up in the schema as their own table so the Calcite validator
     * Indices that mix supported and unsupported fields produce a schema containing only the
    /**
        String mapping = "{\"properties\":{\"price\":{\"type\":\"scaled_float\",\"scaling_factor\":0}}}";
    /**
import org.opensearch.analytics.schema.DateOnlyType;
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
     * Test integer, float, boolean type mappings.
            "made_up_plugin_type" }) {
        RelDataType c = BinaryType.nullable();
        assertEquals(SqlTypeName.INTEGER, OpenSearchSchemaBuilder.mapFieldType("integer"));
     */
        assertEquals(SqlTypeName.TINYINT, OpenSearchSchemaBuilder.mapFieldType("byte"));
        assertNull("nested geo_point leaf must be dropped", rowType.getField("customer.home", true, false));
        assertFieldType(rowType, "name", SqlTypeName.VARCHAR);
        ClusterState clusterState = buildClusterState(
        assertEquals(SqlTypeName.VARBINARY, binType.getSqlTypeName());
import org.apache.calcite.rel.RelNode;
    }
    }
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
    /**
        RelDataType signedType = rowType.getField("signed_val", true, false).getType();
        assertFalse(
        Metadata.Builder metadataBuilder = Metadata.builder();
            .numberOfReplicas(0)
        assertEquals(SqlTypeName.BIGINT, field.getType().getSqlTypeName());
            "version",
     * {@link SqlTypeName#VARBINARY} underneath.
    }
    /** UnsignedLongType digest is UNSIGNED_LONG, distinct from plain BIGINT. */
        assertFieldType(rowType, "age", SqlTypeName.BIGINT);
        assertEquals(a.hashCode(), b.hashCode());
    }
        assertNotNull(field);
    private IndexMetadata buildIndexMetadata(String indexName, Map<String, String> fieldTypes) throws Exception {
        mappingJson.append("}}");
            .build();
        Table table = schema.getTable("mixed_long_idx");
import org.apache.calcite.tools.FrameworkConfig;
    }
    }
        assertFieldType(rowType, "name", SqlTypeName.VARCHAR);
        // (bypasses the SQL parser, which would case-fold first). Pins the regression Calcite
            "shape",
    }
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
     * {@code Timestamp(ms) got Timestamp(ns)} in the coordinator RowConverter.
        Exception ex = expectThrows(Exception.class, () -> parseValidateConvert(schema, "SELECT loc FROM kai_repro"));
        assertEquals(SqlTypeName.BIGINT, OpenSearchSchemaBuilder.mapFieldType("scaled_float"));
     */
            + "}}";
            "Validator error must mention dropped column 'loc'; got: " + fullMessage,
    private static org.apache.calcite.jdbc.JavaTypeFactoryImpl nanosTypeFactory() {
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
    /**
        assertNotNull("alias table present", schema.getTable("bank_all"));
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
    }
        assertFieldType(rowType, "age", SqlTypeName.BIGINT);
            .putAlias(AliasMetadata.builder("bank_all").build())
        RelDataType type100 = rowType.getField("price100", true, false).getType();
/*
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder().build()).build();
 * compatible open source license.
     * Two separately constructed {@link IpType} instances must be digest-equal so plan equality
        assertNotNull(table);
        RelDataType unsignedType = rowType.getField("unsigned_val", true, false).getType();
    }
    }
        Table table = schema.getTable("plain_date_idx");
            "long_range",
        ClusterState clusterState = buildClusterState(Map.of("bank", Map.of("balance", "long"), "test", Map.of("age", "long")));
            .settings(settings(Version.CURRENT))
        assertEquals("TimeOnlyType over date_nanos must carry nanos precision", 9, field.getType().getPrecision());
            SqlNode validated = planner.validate(parsed);
        // But they are distinguishable via instanceof
        assertEquals(SqlTypeName.TIMESTAMP, field.getType().getSqlTypeName());
    /**
import org.opensearch.cluster.metadata.Metadata;
        for (String unsupported : new String[] {
     * must still resolve them. Verifying a SELECT against an uppercased table works.
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
    private static RelNode parseValidateConvert(SchemaPlus schema, String sql) throws Exception {
            .putMapping("{\"properties\":{\"age\":{\"type\":\"long\"}}}")
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
     * row type, and {@code OpenSearchTableScanRule} null-fills those columns at scan time.
    /** Concatenate the message of the throwable and every cause for substring assertions. */
     * silently skipped — must not throw.
