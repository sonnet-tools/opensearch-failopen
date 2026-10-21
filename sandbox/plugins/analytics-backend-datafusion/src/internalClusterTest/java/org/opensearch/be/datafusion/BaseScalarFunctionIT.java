     * on the enclosing Project. The non-strict {@link #assertScalarLong} silently
    }
    }
            ArrowBasePlugin.class,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            indexBankDocs();
 * compatible open source license.
    // ---- Assert helpers ----
    }
import org.opensearch.plugins.PluginInfo;
import org.opensearch.parquet.ParquetDataFormatPlugin;
// combining cluster-manager and data roles: scalar-function tests exercise query rewrite +
            .put("index.pluggable.dataformat", "composite")
import org.opensearch.Version;
                39225L,
    @Override
        assertTrue(expr + " result must be Number, got " + cell.getClass(), cell instanceof Number);
            .put("index.pluggable.dataformat.enabled", true)
            pluginClass.getName(),
    }
 * exercises the function's name lookup, type inference, and runtime, not
    @Override
    }
 */
        Object cell = evalScalar(expr);
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
            .field("type", "long")
            .startObject("json_str")
                "account_number",
import java.util.List;
            .startObject("properties")
        XContentBuilder mapping = XContentFactory.jsonBuilder()
    protected void assertScalarLongStrict(String expr, long expected) {
        // and the non-array → NULL path (row 6) from real column values.
 * <p>Each subclass declares its functions as test methods using the
            .indices()
import org.opensearch.core.xcontent.XContentBuilder;
        Object cell = evalScalar(expr);
// supportsDedicatedMasters=false + numClientNodes=0 collapses the cluster to a single node
                "account_number",
// single-shard execution, which doesn't need dedicated cluster-managers or a separate
        assertTrue(expr + " result must be Boolean, got " + cell.getClass(), cell instanceof Boolean);
    protected Object evalScalar(String expr) {
                "created_at",
        assertTrue(expr + " result must be Number, got " + cell.getClass(), cell instanceof Number);
     * Strict variant that asserts the cell is an {@link Integer}. Use for functions
        assertNotNull("PPLResponse must not be null", response);
    }
        Object cell = evalScalar(expr);
                "balance",
            .field("type", "date")
// pressure source that destabilises node discovery on resource-constrained runners.
    }
    protected void assertScalarDouble(String expr, double expected, double delta) {
 * arithmetic on rows.
import org.opensearch.be.lucene.LucenePlugin;
            CompositeDataFormatPlugin.class,
import java.util.Collection;
 * {@code assertScalarXxx(expr, expected)} helpers. The query template is fixed:
                "balance",
                5686L,
            pluginClass.getName(),
                "[1,2,3]"
            .setSource(
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertNotNull(expr + " result must not be null", cell);
                "json_str",
                1,
            .startObject("firstname")
    }
            FlightStreamPlugin.class,
     */
        assertEquals(expr, expected, ((Number) cell).doubleValue(), delta);
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
            .endObject()
// surfaces as cascading NodeDisconnectedException when many test methods share a SUITE cluster.
                "Amber",
            null,
            extendedPlugins,
        assertNotNull(expr + " result must not be null", cell);
            classpathPlugin(ParquetDataFormatPlugin.class, Collections.emptyList()),
public abstract class BaseScalarFunctionIT extends OpenSearchIntegTestCase {
        assertNotNull(expr + " result must not be null", cell);
 */
        // Row 1 carries a 3-element JSON array in json_str; row 6 carries a JSON object.
import org.opensearch.ppl.action.PPLResponse;
        if (!indexExists(BANK_INDEX)) {
        assertNotNull(expr + " result must not be null", cell);
                6,
            ensureGreen(BANK_INDEX);
            .startObject("account_number")
 * this file be licensed under the Apache-2.0 license or a
    protected Settings nodeSettings(int nodeOrdinal) {
    protected void assertScalarLong(String expr, long expected) {
// coord-only node. The 5-node default (3 cluster-managers + 1 data + 1 coord) is a memory
 * Substrait → DataFusion scalar-function tests.
            .get();
            )
     * implementations return {@code Int64} but get narrowed via an implicit CAST
 * literals so assertions don't depend on the bank fixture's data — the test
    /**
        );
            .build();
            Version.CURRENT,
     */
                "json_str",
        Object cell = evalScalar(expr);
            .startObject("balance")
import org.opensearch.composite.CompositeDataFormatPlugin;
    protected static final String BANK_INDEX = "bank";
        Object cell = evalScalar(expr);
                "2024-06-15T10:30:00Z",
        assertNotNull(expr + " result must not be null", cell);
    @Override
            .endObject()
     * lets tests reference {@code firstname} / {@code balance} as fields —
            .startObject()
            .endObject()
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
     * {@code account_number=1} (firstname='Amber', balance=39225) and returns
 *
            "source=" + BANK_INDEX + " | where account_number = 1 | eval x = " + expr + " | fields x | head 1"
            .put("index.composite.primary_data_format", "parquet")
        client().prepareIndex(BANK_INDEX)
 * SPDX-License-Identifier: Apache-2.0
            .endObject()
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
 *
        }
    private void createBankIndex() throws Exception {
            // scalar-JSON UDFs can be exercised on real column values (columnar
import org.opensearch.analytics.AnalyticsPlugin;
            createBankIndex();
        // SUITE-scoped cluster is reused across test methods — only create/index once.
     * away at plan time. Tests must therefore use field references to truly
        Settings indexSettings = Settings.builder()
                "{\"k\":1}"
            false
        client().prepareIndex(BANK_INDEX)
        return response.getRows().get(0)[0];
        assertEquals(expr, expected, ((Long) cell).longValue());
            .setSource(
 * The OpenSearch Contributors require contributions made to
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    protected void assertScalarNull(String expr) {
import org.opensearch.test.OpenSearchIntegTestCase;
    }
        assertEquals(expr, expected, cell);
            "classpath plugin",
/**
                "Hattie",
            .startObject("created_at")
            "1.8",
import org.opensearch.common.settings.Settings;
        PPLRequest request = new PPLRequest(
            TestPPLPlugin.class,
                "firstname",
 *
        PPLResponse response = client().execute(UnifiedPPLExecuteAction.INSTANCE, request).actionGet();
            .build();
    protected void assertScalarBoolean(String expr, boolean expected) {
        );
            .setMapping(mapping)
        assertTrue("bank index creation must be acknowledged", response.isAcknowledged());
        CreateIndexResponse response = client().admin()
        return List.of(
     * Runs the given expression against the single bank row with
        );
    @Override
            .prepareCreate(BANK_INDEX)
package org.opensearch.be.datafusion;
import org.opensearch.plugins.Plugin;
    }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 1, supportsDedicatedMasters = false, numClientNodes = 0)
    }
            .field("type", "keyword")
import org.opensearch.arrow.allocator.ArrowBasePlugin;
     * accepts either width and would miss this contract regression.
    protected Collection<PluginInfo> additionalNodePlugins() {
        return Settings.builder()
        assertEquals(expr, expected, ((Integer) cell).intValue());
     * the resulting cell. Pinning the row makes assertions deterministic and
    }
 * @opensearch.internal
    protected void assertScalarIntStrict(String expr, int expected) {
                "2024-01-20T14:45:30Z",
import java.util.Collections;
        assertEquals("schema columns", List.of("x"), response.getColumns());
    }
/*
    public void setUp() throws Exception {
        assertEquals("head 1 → exactly 1 row", 1, response.getRows().size());
            .field("type", "long")
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
                "created_at",
import org.opensearch.ppl.TestPPLPlugin;
            LucenePlugin.class
        Object cell = evalScalar(expr);
     * e.g. PPL scalar UDFs declared as {@code INTEGER_FORCE_NULLABLE} whose Rust
    private void indexBankDocs() {
 * Shared fixture + scalar-result assert helpers for end-to-end PPL → Calcite →
     * Use for functions whose on-wire BIGINT return type must not silently regress.
                "firstname",
    }
import org.opensearch.ppl.action.PPLRequest;
import org.opensearch.cluster.metadata.IndexMetadata;
        assertTrue(expr + " result must be Long, got " + cell.getClass(), cell instanceof Long);
        assertEquals(expr, expected, ((Number) cell).longValue());
            .endObject()
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
    /**
        assertTrue(expr + " result must be Integer, got " + cell.getClass(), cell instanceof Integer);
        return List.of(
     */
        assertEquals(expr, expected, cell.toString());
        // This lets scalar-JSON UDF tests assert both the happy path (row 1 → length 3)
    protected void assertScalarString(String expr, String expected) {
     * exercise the Substrait + DataFusion runtime path.
            .get();
            .setSettings(indexSettings)
     * Strict variant that asserts the cell is a {@link Long} (not just a {@link Number}).
import org.opensearch.common.util.FeatureFlags;
        );
            .endObject()
            .endObject();
            refresh(BANK_INDEX);
            )
}
        assertNotNull(expr + " result must not be null", cell);
            .put(super.nodeSettings(nodeOrdinal))
            .field("type", "keyword")
            // json_str holds serialized JSON arrays/objects/malformed strings so
        Object cell = evalScalar(expr);
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
            .get();
 * {@code source=bank | eval x = <expr> | fields x | head 1}. Inputs are
     * which prevents Calcite's constant-folding from optimizing the function
            "NA",
     * whose on-wire INTEGER return type must be preserved through the pipeline —
        assertNull(expr + " result must be null but was " + cell, cell);
import org.opensearch.common.xcontent.XContentFactory;
        super.setUp();
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        return new PluginInfo(
// TEST-scope cluster per method — slower but eliminates cluster-reuse degradation that
    }
            // UDF path), not just string literals (scalar fast-path).
    /**
