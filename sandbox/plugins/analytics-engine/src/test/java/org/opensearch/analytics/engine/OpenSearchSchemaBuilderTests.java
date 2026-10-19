            + "}}";
        assertNotNull(table);
            + "\"price100\":{\"type\":\"scaled_float\",\"scaling_factor\":100}"  
        Exception ex = expectThrows(Exception.class, () -> parseValidateConvert(schema, "SELECT loc FROM kai_repro"));
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(metadata).build();  
        Metadata metadata = Metadata.builder().put(idx1, false).put(idx2, false).build();
        assertEquals(SqlTypeName.VARCHAR, OpenSearchSchemaBuilder.mapFieldType("text"));  
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
        );
        Table table = schema.getTable("time_only_idx");
        assertEquals(SqlTypeName.BIGINT, signedType.getSqlTypeName());  
    /** date with time-only format produces a TimeOnlyType marker. */
        assertNotNull("alias table present", schema.getTable("bank_all"));  
        );  
    public void testMultiFieldsSubtypeDoesNotAffectParent() throws Exception {
            .build();  
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());  
            fullMessage.toLowerCase(java.util.Locale.ROOT).contains("loc")
            .settings(settings(Version.CURRENT))
    // --- unsigned_long tests ---
    /**
     * A comma-separated multi-source ({@code bank,test}) resolves to one table unioning both
    }
        RelDataType ipType = rowType.getField("address", true, false).getType();  
        String mapping = "{\"properties\":{\"price\":{\"type\":\"scaled_float\",\"scaling_factor\":0}}}";  
     */  
     * nanos precision. This is the regression #22049 fixed for the plain-TIMESTAMP path; the
     */
    /**
        RelDataTypeField field = rowType.getField("price", true, false);
        assertNull("Field with zero scaling_factor must be excluded", rowType.getField("price", true, false));
     * returns first determines the type. Both are valid; the key invariant is that the field
     * sibling supported columns.
            + "\"locked\":{\"type\":\"keyword\",\"multi_value\":false}"  
        assertNotNull("Query via SQL path must succeed", rel);
        assertFieldType(rowType, "name", SqlTypeName.VARCHAR);  
    /**
        try {  
        assertFieldType(rowType, "alias_field", SqlTypeName.VARCHAR);  
        }
     * Test mapFieldType for all supported types.
        assertEquals(a, b);
        ClusterState clusterState = buildClusterState(java.util.Map.of("plain_date_idx", java.util.Map.of("d", "date")));
        assertEquals("Only the well-formed field should survive", 1, rowType.getFieldCount());
    // --- helpers ---
    public void testUnsignedLongFieldProducesUnsignedLongType() throws Exception {
     * UDT path must mirror it or multi-shard sort fails with
        ClusterState clusterState = buildClusterState(  
     * / planner caching works without requiring Calcite type-factory canonicalization (we don't
            + "}}";
     * {@code IndexNameExpressionResolver} (OpenSearch index names must be lowercase). This lets
            .numberOfShards(1)
     * existing object-recursion branch enters but finds nothing to add, so the field is
        assertNotEquals("factor-10 and factor-100 must be distinct type objects", type10, type100);
        assertFalse(field.getType() instanceof TimeOnlyType);
        assertFieldType(rowType, "name", SqlTypeName.VARCHAR);
        ClusterState clusterState = buildClusterStateRaw("sf_no_factor_idx", mapping);
    }  
            "long_range",
        assertEquals("date must carry millis precision", 3, field.getType().getPrecision());
    public void testLogicalTypeEqualityIsDigestBased() {
                return super.getMaxPrecision(typeName);
     * Type factory whose {@code getMaxPrecision(TIMESTAMP)} is 9 — so a precision request from
    public void testMapFieldTypeReturnsNullOnNullInput() {  
    }
        ClusterState clusterState = buildClusterState(Map.of("udt_index", Map.of("address", "ip", "blob", "binary")));
        String mapping = "{\"properties\":{\"t\":{\"type\":\"date\",\"format\":\"hour_minute_second\"}}}";
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
            "sparse_vector",
 * SPDX-License-Identifier: Apache-2.0
     * This is the load-bearing contract behind the schema-degradation fix.
    }
            }  
        assertFieldType(rowType, "locked", SqlTypeName.VARCHAR);  
    public void testDateFieldWithMixedFormatStaysTimestamp() throws Exception {
        ClusterState clusterState = buildClusterStateRaw("date_only_ns_idx", mapping);
            "Validator error must mention dropped column 'loc'; got: " + fullMessage,  
        Table table = schema.getTable("all_unsupported");  
 *
        ClusterState clusterState = buildClusterStateRaw("sf_digest_idx", mapping);
        assertFieldType(rowType, "name", SqlTypeName.VARCHAR);
import org.opensearch.analytics.schema.DateOnlyType;  
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
    public void testScaledFloatFieldWithFactorProducesScaledFloatType() throws Exception {
     * IP and binary fields are wrapped in dedicated {@link IpType} / {@link BinaryType} markers
        assertEquals(SqlTypeName.VARBINARY, OpenSearchSchemaBuilder.mapFieldType("ip"));
import org.opensearch.analytics.schema.ScaledFloatType;  
import org.opensearch.analytics.schema.IpType;
        assertEquals(SqlTypeName.DOUBLE, OpenSearchSchemaBuilder.mapFieldType("double"));
        assertEquals(SqlTypeName.ARRAY, tagsType.getSqlTypeName());  
        // 'age' exists — could be BIGINT or VARCHAR depending on resolver order
            "ip_range",
        RelDataTypeField field = rowType.getField("x", true, false);
        ClusterState clusterState = buildClusterStateRaw("malformed_idx", mapping);
        Table table = schema.getTable("sf_idx");
     * Type mapping: keyword->VARCHAR, long->BIGINT, double->DOUBLE
        assertTrue("Expected UnsignedLongType marker, got " + field.getType().getClass(), field.getType() instanceof UnsignedLongType);  
            Map.of("types_index", Map.of("count", "integer", "ratio", "float", "active", "boolean"))
     * error naming the column — not as IllegalArgumentException, NPE, or silent null.
    /** UnsignedLongType digest is UNSIGNED_LONG, distinct from plain BIGINT. */
            .defaultSchema(schema)
        return ClusterState.builder(new ClusterName("test")).metadata(metadata).build();
    /**
        ClusterState clusterState = buildClusterState(java.util.Map.of("plain_date_idx", java.util.Map.of("d", "date")));
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        assertNotNull("Calcite should produce a RelNode for projection-of-supported-only", rel);
 * this file be licensed under the Apache-2.0 license or a
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
     * {@code source=test*} resolves against the cluster's index expression.  
        assertNotNull("backing concrete index still present", schema.getTable("bank_a"));
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        }
     * Case-insensitive table resolution: Calcite uppercases unquoted identifiers. The schema
    }  
     * row type, and {@code OpenSearchTableScanRule} null-fills those columns at scan time.
        assertNotEquals(a, c);
     * {@code date} with date-only format produces a {@link DateOnlyType} that still carries
        ClusterState clusterState = buildClusterStateRaw("sf_str_idx", mapping);  
     * Multi-fields (`fields`) sub-mapping is currently NOT walked — only the top-level
        FrameworkConfig config = Frameworks.newConfigBuilder()  
            .build();
     */
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
     */
import org.opensearch.cluster.ClusterState;
        Table table = schema.getTable("mixed_long_idx");
     * naturally because the rowType has zero columns.
import org.apache.calcite.tools.Frameworks;
        assertFieldType(rowType, "score", SqlTypeName.DOUBLE);
        assertNotNull(table);
     * at plan time rather than an empty-row-type table.  
        assertFalse("mixed format must NOT produce a Date/Time UDT", field.getType() instanceof DateOnlyType);  
        assertNull(OpenSearchSchemaBuilder.mapFieldType(null));
    }
    public void testDateNanosFieldWithDateOnlyFormatHasNanosPrecision() throws Exception {
        Table table = schema.getTable("multifield_idx");  
        assertEquals(SqlTypeName.REAL, OpenSearchSchemaBuilder.mapFieldType("half_float"));
        boolean first = true;  
        Table table = schema.getTable("bank,test");  
    }
        Map<String, String> ordered = new LinkedHashMap<>(fieldTypes);
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
     * The schema's lazy {@code get()} lower-cases incoming lookup names before consulting  
            .numberOfReplicas(0)
    /**  
    }
        assertFalse("plain long must NOT be UnsignedLongType", signedType instanceof UnsignedLongType);  
            Map.of("nested_index", Map.of("name", "keyword", "address", "object", "tags", "nested"))
            + "}}"
        RelDataType rowType = schema.getTable("bank_all").getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
        assertEquals(SqlTypeName.BIGINT, field.getType().getSqlTypeName());
        assertNotNull("Table types_index should exist in schema", table);
            + "\"loc\":{\"type\":\"geo_point\"}"  
        ClusterState clusterState = buildClusterState(Map.of("kai_repro", Map.of("name", "keyword", "loc", "geo_point")));
    }
    /**
    public void testNestedObjectWithUnsupportedLeafDropsOnlyThatLeaf() throws Exception {  
        assertFieldType(rowType, "normal", SqlTypeName.VARCHAR);  
    public void testIndexWithUnsupportedFieldsDropsThoseColumns() throws Exception {
     */  
     * bug reproducer pattern — geo_point in mapping but not in projection.  
        }  
     */
        // (Lex.ORACLE), which would force a case-insensitive validator + getTableNames()
            "alias",
     * contract added by #22049 so the date-only / time-only UDT paths can mirror it.
    }
        StringBuilder sb = new StringBuilder();
        assertEquals(SqlTypeName.TIMESTAMP, OpenSearchSchemaBuilder.mapFieldType("date"));  
     * millis precision. Without this, the parquet-read path's Timestamp(Millisecond) clashes
    public void testMultiValueKeywordBuildsNullableArrayType() throws Exception {  
    /** Plain {@code date_nanos} with no format → {@code TIMESTAMP(9)} (nanos). */
        ClusterState clusterState = buildClusterStateRaw("sf_neg_idx", mapping);
    public void testWildcardPatternResolvesToUnionedTable() throws Exception {
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
     * can resolve {@code SELECT * FROM alias}. The exposed row type is the field-union of every
            + "\"normal\":{\"type\":\"keyword\"},"
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        assertEquals(SqlTypeName.SMALLINT, OpenSearchSchemaBuilder.mapFieldType("short"));  
        // Calcite uppercases unquoted identifiers by default; compare case-insensitively.  
        RelDataTypeField ageField = rowType.getField("age", true, false);
     */
        RelDataType binType = rowType.getField("blob", true, false).getType();
    private ClusterState buildClusterStateRaw(String indexName, String mappingJson) throws Exception {  
 * compatible open source license.
    }  
     * must still resolve them. Verifying a SELECT against an uppercased table works.  
        // Exact-case lookup must work — this is the storage truth.  
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
            .putMapping("{\"properties\":{\"age\":{\"type\":\"long\"}}}")  
        assertEquals(SqlTypeName.BIGINT, unsignedType.getSqlTypeName());
                    return 9;
        );
        RelDataType a = IpType.nullable();  
    /** Negative scaling_factor excludes the field from schema. */
        // resolved). PPL hits the schema via RelBuilder.scan with the user-typed case directly;
    /** scaled_float with valid factor produces a ScaledFloatType marker (BIGINT-backed). */  
        String mapping = "{\"properties\":{\"t\":{\"type\":\"date_nanos\",\"format\":\"hour_minute_second\"}}}";
        assertFieldType(rowType, "name", SqlTypeName.VARCHAR);
    /** date without an explicit format keeps default TIMESTAMP behavior. */
     * Test that multiple indices produce multiple tables.
        }
        RelDataType b = IpType.nullable();
        ClusterState clusterState = buildClusterState(Map.of("kai_repro", Map.of("name", "keyword", "loc", "geo_point", "age", "long")));  
        assertNotNull("Mixed-case schema lookup must work", schema.getTable("My_Table"));
        Planner planner = Frameworks.getPlanner(config);
     */
    public void testMapFieldTypeForAllSupportedTypes() {
            + "}}"  
    }  
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
    }
        RelDataTypeField field = rowType.getField("counter", true, false);
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        ClusterState clusterState = buildClusterState(  
            "version",  
        assertNotNull(table);
import org.apache.calcite.tools.FrameworkConfig;
     * silently skipped — must not throw.  
    }
        assertNotNull("Table must exist even when every field is unsupported", table);
        Table table = schema.getTable("nested_geo");
            .numberOfShards(1)  
import org.apache.calcite.sql.parser.SqlParser;
        assertEquals(SqlTypeName.TIMESTAMP, field.getType().getSqlTypeName());  
        assertFieldType(rowType, "active", SqlTypeName.BOOLEAN);  
            .build();
        return new org.apache.calcite.jdbc.JavaTypeFactoryImpl(new org.apache.calcite.rel.type.RelDataTypeSystemImpl() {
        Table table = schema.getTable("types_index");  
            "token_count",
    public void testDateFieldWithoutFormatStaysTimestamp() throws Exception {  
    public void testMalformedFieldWithoutTypeOrPropertiesIsSkipped() throws Exception {
import org.apache.calcite.rel.type.RelDataType;
        assertEquals("TimeOnlyType over date_nanos must carry nanos precision", 9, field.getType().getPrecision());  
        String mapping = "{\"properties\":{\"d\":{\"type\":\"date\",\"format\":\"basic_date\"}}}";  
        ClusterState clusterState = buildClusterStateRaw("multifield_idx", mapping);  
            SqlNode parsed = planner.parse(sql);
        assertFieldType(rowType, "name", SqlTypeName.VARCHAR);  
            "Must NOT surface as IllegalArgumentException 'Unsupported OpenSearch field type'; got: " + fullMessage,
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
        assertEquals(SqlTypeName.TIMESTAMP, field.getType().getSqlTypeName());
    public void testBuildSchemaWithDateIpTextShortByte() throws Exception {  
            .metadata(Metadata.builder().put(a, false).put(b, false).build())
            planner.close();
            "completion",
            .numberOfShards(1)
            + "}}";
     * field 'age' appears as long in bank and keyword in test — whichever index the resolver
        assertEquals("Should only have 'name' field, skipping object/nested", 1, rowType.getFieldCount());
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);  
     * go through {@code typeFactory.canonize}).  
import org.opensearch.analytics.schema.UnsignedLongType;
    /**
    /** date with mixed format defaults to plain TIMESTAMP. */  
        // (bypasses the SQL parser, which would case-fold first). Pins the regression Calcite
     * Calcite's default of 3. The production type factory mirrors this; the default  
    /**  
        String mapping = "{\"properties\":{"
        Table table = schema.getTable("test_index");  
        Metadata metadata = Metadata.builder().put(indexMetadata, false).build();
        RelDataType signedType = rowType.getField("signed_val", true, false).getType();  
    }
    /**  
            if (!first) mappingJson.append(",");
        assertFieldType(rowType, "content", SqlTypeName.VARCHAR);
        assertEquals("name", rel.getRowType().getFieldList().get(0).getName().toLowerCase(java.util.Locale.ROOT));
    private static RelNode parseValidateConvert(SchemaPlus schema, String sql) throws Exception {
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());  
        // Preserve the original case of unquoted identifiers so both table names and column names  
    public void testCaseInsensitiveTableResolution() throws Exception {
        assertFieldType(rowType, "small_num", SqlTypeName.SMALLINT);
        assertEquals("IpType must still report VARBINARY for operator dispatch", SqlTypeName.VARBINARY, ipType.getSqlTypeName());
    /**  
        assertEquals(SqlTypeName.INTEGER, OpenSearchSchemaBuilder.mapFieldType("integer"));
            .operatorTable(SqlStdOperatorTable.instance())  
     */
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());  
     * {@code date_nanos} with time-only format produces a {@link TimeOnlyType} that carries  
        IndexMetadata b = IndexMetadata.builder("bank_b")
    /**
        ClusterState clusterState = buildClusterState(Map.of("ul_idx", Map.of("counter", "unsigned_long")));
     */
     * Calcite end-to-end: projecting a DROPPED unsupported column must surface as a validator  
        assertNotNull(table);
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);  
        RelDataType c = BinaryType.nullable();
        Table table = schema.getTable("test*");  
     * {@code Timestamp(ms) got Timestamp(ns)} in the coordinator RowConverter.  
    /**  
        assertNotNull("Comma list 'bank,test' should resolve to a table", table);
    }
        assertNotNull(field);
        String fullMessage = collectMessages(ex);
     * "type" matters. An unsupported multi-field subtype thus has zero effect on the parent
     * indices' fields — the shape {@code source=a, b} produces after Relation comma-joins names.
     * column. Pinning current behavior so a future change to walk `fields` is intentional.  
import org.opensearch.cluster.metadata.Metadata;
    public void testCalciteValidatesQuerySkippingUnsupportedField() throws Exception {
    }  
        assertTrue(
    }
            .numberOfShards(1)  
        assertEquals("age", rel.getRowType().getFieldList().get(1).getName().toLowerCase(java.util.Locale.ROOT));
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
            first = false;
        assertNotNull("Conflicting field 'age' must still appear in union", ageField);  
     */
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
    public void testCalciteRejectsQueryReferencingDroppedColumn() throws Exception {
     * Field with no "type" property and no "properties" sub-map (malformed mapping). The
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
            mappingJson.append("\"").append(field.getKey()).append("\":{\"type\":\"").append(field.getValue()).append("\"}");  
        ClusterState clusterState = buildClusterState(  
     * Index whose every field is unsupported still emits a Calcite Table — with an empty rowType.
            + "\"id\":{\"type\":\"keyword\"},"  
     * Calcite end-to-end: parsing and validating a query that projects a SUPPORTED column on an
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
            "integer_range",
import java.util.LinkedHashMap;
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
     * The build itself must not throw; downstream validation rejects any column reference  
    public void testCommaSeparatedSourcesFieldConflictPicksOne() throws Exception {
            + "}}";
        assertNotNull(field);
     * Aliases over indices show up in the schema as their own table so the Calcite validator
        // reach the validator as-typed. Default Calcite parsing uppercases unquoted identifiers
            return planner.rel(validated).project();  
     */
            Map.of("more_types", Map.of("created", "date", "address", "ip", "content", "text", "small_num", "short", "tiny_num", "byte"))
import org.apache.calcite.sql.type.SqlTypeName;  
        RelDataTypeField field = rowType.getField("price", true, false);
        IndexMetadata idx2 = buildIndexMetadata("index_b", Map.of("col2", "long"));
     */
        Metadata.Builder metadataBuilder = Metadata.builder();
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());  
        RelDataType rowType = OpenSearchSchemaBuilder.buildSchema(clusterState)
    /**  
            "point",  
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);  
    public void testUnsupportedFieldTypesReturnNull() {
import org.opensearch.Version;
        assertEquals(SqlTypeName.BOOLEAN, OpenSearchSchemaBuilder.mapFieldType("boolean"));
        RelNode rel = parseValidateConvert(schema, "SELECT name FROM my_table");
     */
        assertFieldType(rowType, "tiny_num", SqlTypeName.TINYINT);  
        assertNotNull(table);  
        ClusterState clusterState = buildClusterStateRaw("date_only_idx", mapping);
        assertFieldType(rowType, "score", SqlTypeName.DOUBLE);
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
        assertFieldType(rowType, "balance", SqlTypeName.BIGINT);
        Table table = schema.getTable("plain_date_idx");  
        assertEquals(SqlTypeName.VARCHAR, tagsType.getComponentType().getSqlTypeName());
    /**  
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());  
        for (Map.Entry<String, String> field : ordered.entrySet()) {
        assertNotNull("Table more_types should exist in schema", table);
}
        assertEquals("Only 2 supported nested leaves should remain", 2, rowType.getFieldCount());  
    /** Concatenate the message of the throwable and every cause for substring assertions. */  
        assertFieldType(rowType, "age", SqlTypeName.BIGINT);
        Table table = schema.getTable("ul_idx");
            .putMapping(mappingJson.toString())  
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());  
        String mapping = "{\"properties\":{"
        // Both report BIGINT
     * Comma-separated sources with field-name conflict: first-resolved-wins semantics. The  
     */  
import org.opensearch.test.OpenSearchTestCase;
     */
        RelDataTypeField field = rowType.getField("d", true, false);
        String mapping = "{\"properties\":{\"price\":{\"type\":\"scaled_float\",\"scaling_factor\":-5}}}";
        assertFieldType(rowType, "customer.age", SqlTypeName.INTEGER);
        assertEquals("Result must have exactly the 2 projected columns", 2, rel.getRowType().getFieldCount());
            + "}}";  
    }  
        assertNotNull("Table index_a should exist", schema.getTable("index_a"));
        } finally {
     * Indices that mix supported and unsupported fields produce a schema containing only the
        assertTrue("multi-value field must remain nullable", tagsType.isNullable());
    private IndexMetadata buildIndexMetadata(String indexName, Map<String, String> fieldTypes) throws Exception {
            .settings(settings(Version.CURRENT))  
    }
    }
     * Unsupported / unknown field types degrade to a null SqlTypeName. The schema builder drops
        RelDataType type10 = rowType.getField("price10", true, false).getType();  
    /** unsigned_long field produces an UnsignedLongType marker (BIGINT-backed). */  
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        IndexMetadata idx2 = buildIndexMetadata("test", Map.of("age", "keyword", "score", "double"));
        assertFieldType(rowType, "name", SqlTypeName.VARCHAR);
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());  
    public void testScaledFloatMissingFactorExcludesField() throws Exception {  
    public void testScaledFloatDigestDistinctness() throws Exception {  
            + "\"raw\":{\"type\":\"keyword\"},"
    }  
    /**  
        String mapping = "{\"properties\":{"
        assertNull("nested geo_point leaf must be dropped", rowType.getField("customer.home", true, false));  
        Table table = schema.getTable("bank,test");  
    // --- scaled_float tests ---
        assertEquals("All-unsupported index produces 0-column rowType", 0, rowType.getFieldCount());
            "dense_vector",
        assertNotNull("Comma-separated expression must resolve", table);
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(metadata).build();  
     * supported ones — the unsupported columns are dropped silently rather than aborting the
        // this config mirrors that for SQL-based unit tests.
     * "column not found", not at planning time with an IllegalArgumentException.  
     * index whose mapping contains an unsupported field must succeed. This is the scan_viability
        assertEquals(a.hashCode(), b.hashCode());  
import org.apache.calcite.rel.RelNode;
     * exists and unique-per-index fields from both indices appear in the union.  
    public void testUnsignedLongDigestDistinctFromPlainBigint() throws Exception {
        RelDataTypeField field = schema.getTable("time_only_ns_idx").getRowType(nanosTypeFactory()).getField("t", true, false);
            "date_range",  
    /**  
            fullMessage.contains("Unsupported OpenSearch field type")
    /** Factor-10 and factor-100 ScaledFloatType instances are digest-distinct (canonicalization trap). */
     */
            Map.of("mixed_long_idx", Map.of("signed_val", "long", "unsigned_val", "unsigned_long"))
     * {@code date_nanos} with date-only format produces a {@link DateOnlyType} that carries  
            "flat_object",  
     * with the schema's precision-0 default at coordinator reduce.  
            }
        // But they are distinguishable via instanceof
    /**  
        RelDataTypeField field = rowType.getField("t", true, false);  
        assertNull("Non-matching pattern 'nonexistent*' should resolve to no table", schema.getTable("nonexistent*"));
        assertNotNull("Upper-case schema lookup must work", schema.getTable("MY_TABLE"));  
     * Defensive: mapFieldType called with null must return null (treated as "unknown") rather  
        ClusterState clusterState = buildClusterState(Map.of("test", Map.of("age", "long")));  
    }  
    /** String-valued scaling_factor (e.g. "10") is accepted and parsed. */  
     */
        assertTrue("Schema should have no tables", schema.getTableNames().isEmpty());
    /**  
    }
        assertNotNull(field);
            "made_up_plugin_type" }) {
        ClusterState clusterState = buildClusterState(Map.of("my_table", Map.of("name", "keyword", "age", "long")));  
    /**  
        assertEquals("Only the 2 supported fields should be present", 2, rowType.getFieldCount());  
        assertFieldType(rowType, "address", SqlTypeName.VARBINARY);  
        Table table = schema.getTable("mixed_index");
        );  
        assertEquals(SqlTypeName.VARCHAR, OpenSearchSchemaBuilder.mapFieldType("keyword"));
     * such columns so a downstream query referencing one fails at validation time with
        assertNotNull(schema);  
        assertTrue("binary column must be BinaryType, got " + binType.getClass(), binType instanceof BinaryType);
/*  
        assertEquals("Parent field is preserved; multi-fields subtree is ignored", 1, rowType.getFieldCount());
        Table table = schema.getTable("sf_digest_idx");
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
import org.opensearch.cluster.metadata.AliasMetadata;
     * Nested object containing geo_point + supported leaves. Confirms the recursive path in
     * so the SQL plugin can disambiguate them at the response boundary. Operator dispatch is
            "wildcard",
            .numberOfReplicas(0)
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);  
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        assertNotNull(field);  
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());  
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
     * Plain {@code date} with no format → {@code TIMESTAMP(3)} (millis). Pins the precision  
        RelDataTypeField field = schema.getTable("nanos_idx").getRowType(nanosTypeFactory()).getField("d", true, false);
        String mapping = "{\"properties\":{"  
        String mapping = "{\"properties\":{\"price\":{\"type\":\"scaled_float\"}}}";
     */
    }  
            SqlNode validated = planner.validate(parsed);
                }  
        assertEquals(SqlTypeName.BIGINT, field.getType().getSqlTypeName());
        Table table = schema.getTable("nested_index");  
    /**
            "shape",
        ClusterState clusterState = buildClusterStateRaw("time_only_ns_idx", mapping);
        ClusterState clusterState = buildClusterStateRaw("multi_value_index", mapping);
        assertEquals("date_nanos must carry nanos precision", 9, field.getType().getPrecision());  
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
            .putAlias(AliasMetadata.builder("bank_all").build())
    /** Parse + validate + convert SQL against the given Calcite schema; throws on validator error. */
        assertFieldType(rowType, "created", SqlTypeName.TIMESTAMP);
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        assertFieldType(rowType, "age", SqlTypeName.BIGINT);
     * Two separately constructed {@link IpType} instances must be digest-equal so plan equality
        RelDataType tagsType = rowType.getField("tags", true, false).getType();
     */
        assertEquals(SqlTypeName.TIMESTAMP, OpenSearchSchemaBuilder.mapFieldType("date_nanos"));
        assertTrue("Expected ScaledFloatType marker, got " + field.getType().getClass(), field.getType() instanceof ScaledFloatType);  
    }
    public void testDateFieldWithDateOnlyFormatHasMillisPrecision() throws Exception {
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder().build()).build();  
            + "\"tags\":{\"type\":\"keyword\",\"multi_value\":true},"
    }
            Map.of("all_unsupported", Map.of("loc", "geo_point", "shape", "geo_shape", "feat", "completion"))
     */  
            "geo_shape",
            + "\"home\":{\"type\":\"geo_point\"},"
    }  
import org.opensearch.cluster.ClusterName;  
import org.opensearch.analytics.schema.OpenSearchSchemaBuilder;
        assertTrue("unsigned_long must be UnsignedLongType", unsignedType instanceof UnsignedLongType);
        assertTrue("Expected DateOnlyType marker, got " + field.getType().getClass(), field.getType() instanceof DateOnlyType);
     */
import org.opensearch.analytics.schema.TimeOnlyType;
        ClusterState clusterState = buildClusterStateRaw("sf_zero_idx", mapping);
        for (Map.Entry<String, Map<String, String>> entry : indices.entrySet()) {  
        ClusterState clusterState = buildClusterStateRaw("mixed_idx", mapping);  
            if (cur.getMessage() != null) {
            + "\"weird\":{\"index\":\"not_analyzed\"}"  // no "type", no "properties"
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);  
        assertTrue("Expected DateOnlyType marker", field.getType() instanceof DateOnlyType);
     * Test date, ip, text, short, byte type mappings.
        Table table = schema.getTable("sf_neg_idx");
    }
    private static String collectMessages(Throwable t) {
        Metadata metadata = Metadata.builder().put(idx1, false).put(idx2, false).build();
    public void testNonMatchingPatternYieldsNoTable() throws Exception {
     * A single wildcard source ({@code test*}) resolves to one table whose row type is the union
     * A pattern matching no index yields no table, so Calcite surfaces a clean "table not found"
            "constant_keyword",  
        assertFieldType(rowType, "age", SqlTypeName.BIGINT);
     * than NPE. Mirrors the analytics-framework FieldType.fromMappingType convention.
    }
        assertTrue("ip column must be IpType, got " + ipType.getClass(), ipType instanceof IpType);
import org.opensearch.cluster.metadata.IndexMetadata;  
        String mapping = "{\"properties\":{\"d\":{\"type\":\"date_nanos\",\"format\":\"basic_date\"}}}";  
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
    }
import org.apache.calcite.tools.Planner;  
            ageField.getType().getSqlTypeName() == SqlTypeName.BIGINT || ageField.getType().getSqlTypeName() == SqlTypeName.VARCHAR  
        assertEquals("Field '" + fieldName + "' should have type " + expectedType, expectedType, field.getType().getSqlTypeName());  
    }
    /**
        // Upper-cased lookup must work — exercises the lowercase-on-lookup behavior directly  
        Table table = schema.getTable("sf_str_idx");
    public void testAllUnsupportedFieldsProduceEmptyRowType() throws Exception {  
    }
    public void testDateFieldWithTimeOnlyFormatProducesTimeUDT() throws Exception {  
    /**
    }  
    }
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());  
     * {@code buildLeafType} for {@code date_nanos} is observable rather than silently clamped to
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
    public void testDateNanosFieldWithoutFormatHasNanosPrecision() throws Exception {
        ClusterState state = ClusterState.builder(new ClusterName("test"))  
    }
import org.apache.calcite.schema.SchemaPlus;
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());  
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());  
            .putMapping("{\"properties\":{\"age\":{\"type\":\"long\"}}}")
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());  
     * Calcite's uppercased identifier resolution find a lower-cased index without needing eager
     * backing index — fields absent from some indices appear as nullable columns in the alias  
        assertEquals(SqlTypeName.TINYINT, OpenSearchSchemaBuilder.mapFieldType("byte"));
            .build();
        RelDataType type100 = rowType.getField("price100", true, false).getType();
    }
    /** Zero scaling_factor excludes the field from schema. */
        // unique fields from each index must appear
        assertNotNull(field);
     */
        Table table = schema.getTable("udt_index");
        RelDataTypeField field = schema.getTable("plain_date_idx").getRowType(nanosTypeFactory()).getField("d", true, false);  
    }
            "geo_point",
        Table table = schema.getTable("malformed_idx");
import org.apache.calcite.rel.type.RelDataTypeField;  
            .numberOfReplicas(0)
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
     * {@code JavaTypeFactoryImpl} doesn't.
        ClusterState clusterState = buildClusterStateRaw("nested_geo", mapping);
        assertNotNull("Field '" + fieldName + "' should exist", field);
    public void testScaledFloatStringFactorAccepted() throws Exception {
        // Calcite wraps validator errors; walk the cause chain for the column name.  
        // End-to-end via the SQL path: validate+convert succeeds against the lower-cased index.  
     * nanos precision — same parquet-read constraint as {@link DateOnlyType}.
        String mapping = "{\"properties\":{\"price\":{\"type\":\"scaled_float\",\"scaling_factor\":10}}}";
        assertFalse(field.getType() instanceof DateOnlyType);  
        ClusterState clusterState = buildClusterState(
    /**  
     * Test that nested/object fields are skipped.  
        mappingJson.append("}}");  
            + "\"age\":{\"type\":\"integer\"}"
        assertNotNull("Table test_index should exist in schema", table);
        assertNull("geo_point column must be dropped", rowType.getField("location", true, false));  
        // enumeration — incompatible with the lazy schema (table names aren't enumerable until  
            public int getMaxPrecision(SqlTypeName typeName) {  
     * Test that buildSchema produces a table for each index with correct column types.
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());  
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
            + "\"name\":{\"type\":\"keyword\",\"fields\":{"
    public void testDateFieldWithDateOnlyFormatProducesDateUDT() throws Exception {
        assertNotSame(a, c);  
    /**
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);  
        assertNull("Multi-field 'loc' is not currently surfaced as a column", rowType.getField("name.loc", true, false));
        assertNull("Multi-field 'raw' is not currently surfaced as a column", rowType.getField("name.raw", true, false));  
            .build();
    }
            .putAlias(AliasMetadata.builder("bank_all").build())  
        assertEquals(3, rowType.getFieldCount());
    /**  
     */
     */
        RelDataTypeField field = schema.getTable("date_only_ns_idx").getRowType(nanosTypeFactory()).getField("d", true, false);  
                sb.append(cur.getMessage()).append(" | ");
        assertEquals(SqlTypeName.BIGINT, OpenSearchSchemaBuilder.mapFieldType("unsigned_long"));  
    public void testNestedAndObjectFieldsSkipped() throws Exception {
        StringBuilder mappingJson = new StringBuilder("{\"properties\":{");
     */
        ClusterState clusterState = buildClusterStateRaw("time_only_idx", mapping);
     */
        );
    private ClusterState buildClusterState(Map<String, Map<String, String>> indices) throws Exception {
        assertFalse(  
        RelDataTypeField field = rowType.getField(fieldName, true, false);
        );
            .settings(settings(Version.CURRENT))  
import org.apache.calcite.schema.Table;
        RelDataTypeField field = schema.getTable("date_only_ms_idx").getRowType(nanosTypeFactory()).getField("d", true, false);  
    public void testBuildSchemaWithIntegerFloatBoolean() throws Exception {
     * enumeration of the cluster's index list at schema construction.  
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);  
        ClusterState clusterState = buildClusterState(  
        return IndexMetadata.builder(indexName)
    }  
        for (String unsupported : new String[] {  
            Map.of("mixed_index", Map.of("name", "keyword", "location", "geo_point", "shape_field", "geo_shape", "age", "long"))
        assertEquals("DateOnlyType over date must carry millis precision", 3, field.getType().getPrecision());
        ClusterState clusterState = buildClusterStateRaw("sf_idx", mapping);  
        assertTrue(
        assertNotNull(table);
        assertEquals("DateOnlyType over date_nanos must carry nanos precision", 9, field.getType().getPrecision());
    /** date with date-only format produces a DateOnlyType marker (TIMESTAMP-backed). */
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(state);
        }  
     * entire schema build for the index.  
    /**
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
        assertFieldType(rowType, "ratio", SqlTypeName.REAL);
        IndexMetadata a = IndexMetadata.builder("bank_a")
    private static org.apache.calcite.jdbc.JavaTypeFactoryImpl nanosTypeFactory() {  
        ClusterState clusterState = buildClusterStateRaw("date_only_ms_idx", mapping);
        for (Throwable cur = t; cur != null; cur = cur.getCause()) {  
            @Override
            Map.of("test", Map.of("name", "keyword", "age", "long"), "test1", Map.of("name", "keyword", "alias_field", "keyword"))
            .parserConfig(SqlParser.config().withUnquotedCasing(org.apache.calcite.avatica.util.Casing.UNCHANGED))
    /**
     * Test that an empty ClusterState produces an empty schema.  
        IndexMetadata idx1 = buildIndexMetadata("bank", Map.of("age", "long", "name", "keyword"));  
    public void testBuildSchemaExposesAliasAsTable() throws Exception {  
    }
            .getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());  
    }
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);  
    }
import org.opensearch.analytics.schema.BinaryType;
        assertTrue("Expected TimeOnlyType marker", field.getType() instanceof TimeOnlyType);
    public void testMultipleIndicesProduceMultipleTables() throws Exception {  
        Table table = schema.getTable("date_only_idx");  
     */
        assertEquals(SqlTypeName.REAL, OpenSearchSchemaBuilder.mapFieldType("float"));  
public class OpenSearchSchemaBuilderTests extends OpenSearchTestCase {
        assertFieldType(rowType, "count", SqlTypeName.INTEGER);
     * Test integer, float, boolean type mappings.  
    }
    public void testCommaSeparatedSourcesResolveToUnionedTable() throws Exception {
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);  
    public void testScaledFloatZeroFactorExcludesField() throws Exception {
            .build();
        });  
        assertEquals(SqlTypeName.VARBINARY, binType.getSqlTypeName());  
        Table table = schema.getTable("sf_no_factor_idx");
    public void testDateFieldWithoutFormatHasMillisPrecision() throws Exception {  
package org.opensearch.analytics.engine;
                if (typeName == SqlTypeName.TIMESTAMP || typeName == SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE) {
     * of the matching concrete indices' supported fields. Mirrors the sql-plugin behavior where
    /**
    public void testDateNanosFieldWithTimeOnlyFormatHasNanosPrecision() throws Exception {  
     * unaffected because both extend {@link org.apache.calcite.sql.type.AbstractSqlType} with  
     * {@link SqlTypeName#VARBINARY} underneath.
            + "\"customer\":{\"properties\":{"
        // would trigger if the schema regressed to case-sensitive resolver invocation.
        return ClusterState.builder(new ClusterName("test")).metadata(metadataBuilder.build()).build();  
    public void testIpAndBinaryFieldsCarryLogicalTypeUdt() throws Exception {  
 * The OpenSearch Contributors require contributions made to  
    }  
            .numberOfReplicas(0)
        assertNotNull(table);
        assertFieldType(rowType, "customer.id", SqlTypeName.VARCHAR);
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);  
        );
        ClusterState clusterState = buildClusterState(Map.of("test_index", Map.of("name", "keyword", "age", "long", "score", "double")));
        assertNull("Field with negative scaling_factor must be excluded", rowType.getField("price", true, false));  
        ClusterState clusterState = buildClusterState(java.util.Map.of("nanos_idx", java.util.Map.of("d", "date_nanos")));  
    /** Missing scaling_factor excludes the field from schema (does not throw). */
        assertNull("Field without scaling_factor must be excluded", rowType.getField("price", true, false));
            .settings(settings(Version.CURRENT))
            + "\"price10\":{\"type\":\"scaled_float\",\"scaling_factor\":10},"
    }  
     * addLeafFields drops the unsupported leaf without aborting the recursion or losing  
    }  
        return sb.toString();
        IndexMetadata idx1 = buildIndexMetadata("index_a", Map.of("col1", "keyword"));
        assertEquals(SqlTypeName.VARCHAR, OpenSearchSchemaBuilder.mapFieldType("match_only_text"));
        Table table = schema.getTable("more_types");
     */
    private void assertFieldType(RelDataType rowType, String fieldName, SqlTypeName expectedType) {  
        assertNotNull("String factor '10' must be accepted", field);
    }  
        );  
        String mapping = "{\"properties\":{"  
            .putMapping(mappingJson)
    public void testEmptyClusterStateProducesEmptySchema() {
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        ClusterState clusterState = buildClusterState(Map.of("bank", Map.of("balance", "long"), "test", Map.of("age", "long")));
        String mapping = "{\"properties\":{\"x\":{\"type\":\"date\",\"format\":\"yyyy-MM-dd HH:mm:ss\"}}}";
        RelDataType rowType = table.getRowType(new org.apache.calcite.jdbc.JavaTypeFactoryImpl());
        RelDataType unsignedType = rowType.getField("unsigned_val", true, false).getType();
        String mapping = "{\"properties\":{\"price\":{\"type\":\"scaled_float\",\"scaling_factor\":\"10\"}}}";
        assertEquals(SqlTypeName.TIMESTAMP, field.getType().getSqlTypeName());
            metadataBuilder.put(buildIndexMetadata(entry.getKey(), entry.getValue()), false);
        );
        assertEquals(SqlTypeName.VARBINARY, OpenSearchSchemaBuilder.mapFieldType("binary"));  
        assertEquals(10.0, ((ScaledFloatType) field.getType()).getScalingFactor(), 0.0);
        );
        assertEquals(SqlTypeName.TIMESTAMP, field.getType().getSqlTypeName());
            "percolator",  
    /**
        Table table = schema.getTable("mixed_idx");
        RelDataTypeField field = rowType.getField("d", true, false);
        assertFalse("mixed format must NOT produce a Date/Time UDT", field.getType() instanceof TimeOnlyType);
     */
        assertNotNull("Table index_b should exist", schema.getTable("index_b"));
import org.apache.calcite.sql.SqlNode;  
        ClusterState clusterState = buildClusterState(
        RelNode rel = parseValidateConvert(schema, "SELECT name, age FROM kai_repro");  
    public void testBuildSchemaWithKeywordLongDouble() throws Exception {
            assertNull("Expected null for unsupported type [" + unsupported + "]", OpenSearchSchemaBuilder.mapFieldType(unsupported));
        assertTrue(field.getType() instanceof ScaledFloatType);  
    public void testScaledFloatNegativeFactorExcludesField() throws Exception {  
        assertEquals(SqlTypeName.BIGINT, OpenSearchSchemaBuilder.mapFieldType("long"));
        assertFieldType(rowType, "age", SqlTypeName.BIGINT);
            "age must be one of the two types",
        assertNotNull("Wildcard 'test*' should resolve to a table", table);
        SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState);
        assertEquals(SqlTypeName.BIGINT, OpenSearchSchemaBuilder.mapFieldType("scaled_float"));
        assertFieldType(rowType, "age", SqlTypeName.BIGINT);  
        assertNotNull("Exact-case schema lookup must work", schema.getTable("my_table"));
        // LinkedHashMap preserves declaration order so the assertions on field positions are stable.  
 */  
        assertTrue("Expected TimeOnlyType marker, got " + field.getType().getClass(), field.getType() instanceof TimeOnlyType);
        String mapping = "{\"properties\":{\"d\":{\"type\":\"date\",\"format\":\"basic_date\"}}}";  
        ClusterState clusterState = buildClusterState(  
    }
        assertNotNull("Table mixed_index should exist despite unsupported fields", table);  
        assertEquals(10.0, ((ScaledFloatType) field.getType()).getScalingFactor(), 0.0);
            .getTable("multi_value_index")
        Table table = schema.getTable("sf_zero_idx");  
import java.util.Map;
        assertTrue("Expected DateOnlyType marker", field.getType() instanceof DateOnlyType);
        assertNull("geo_shape column must be dropped", rowType.getField("shape_field", true, false));
    /**  
