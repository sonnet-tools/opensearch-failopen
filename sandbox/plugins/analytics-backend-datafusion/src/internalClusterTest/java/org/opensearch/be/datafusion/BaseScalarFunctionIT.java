    protected Object evalScalar(String expr) {
    }
 * @opensearch.internal
import org.opensearch.parquet.ParquetDataFormatPlugin;
            pluginClass.getName(),  
// supportsDedicatedMasters=false + numClientNodes=0 collapses the cluster to a single node
        PPLRequest request = new PPLRequest(
            )
        }  
        assertNotNull(expr + " result must not be null", cell);
 *
    }
            .field("type", "keyword")
        assertNotNull(expr + " result must not be null", cell);  
            )
                "balance",
            TestPPLPlugin.class,  
    }
            "classpath plugin",
package org.opensearch.be.datafusion;
            .get();  
     * Strict variant that asserts the cell is an {@link Integer}. Use for functions
/*  
            null,
 */  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 1, supportsDedicatedMasters = false, numClientNodes = 0)
 * SPDX-License-Identifier: Apache-2.0
        return List.of(
import org.opensearch.common.settings.Settings;
    protected void assertScalarString(String expr, String expected) {
        Settings indexSettings = Settings.builder()
 * {@code assertScalarXxx(expr, expected)} helpers. The query template is fixed:
            // UDF path), not just string literals (scalar fast-path).  
        Object cell = evalScalar(expr);
    /**
        assertEquals(expr, expected, ((Long) cell).longValue());  
import org.opensearch.ppl.TestPPLPlugin;
            ensureGreen(BANK_INDEX);
     * Runs the given expression against the single bank row with
 *
 * exercises the function's name lookup, type inference, and runtime, not
                "account_number",
            .field("type", "keyword")
import org.opensearch.be.lucene.LucenePlugin;  
        client().prepareIndex(BANK_INDEX)
        return Settings.builder()  
                "account_number",  
        return response.getRows().get(0)[0];  
    }
            .endObject()  
            // json_str holds serialized JSON arrays/objects/malformed strings so
        PPLResponse response = client().execute(UnifiedPPLExecuteAction.INSTANCE, request).actionGet();
 * literals so assertions don't depend on the bank fixture's data — the test  
     * whose on-wire INTEGER return type must be preserved through the pipeline —
            FlightStreamPlugin.class,
            .put("index.pluggable.dataformat.enabled", true)
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
            false  
        return List.of(
            .put(super.nodeSettings(nodeOrdinal))
                "Amber",
        assertEquals("head 1 → exactly 1 row", 1, response.getRows().size());
    @Override
    @Override  
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        assertNull(expr + " result must be null but was " + cell, cell);
                "Hattie",  
    protected void assertScalarNull(String expr) {
                1,
        assertNotNull(expr + " result must not be null", cell);
            .setSource(  
import org.opensearch.Version;
                "balance",
        assertTrue(expr + " result must be Long, got " + cell.getClass(), cell instanceof Long);
     * accepts either width and would miss this contract regression.  
            .setSource(
        assertTrue("bank index creation must be acknowledged", response.isAcknowledged());
        );
            classpathPlugin(ParquetDataFormatPlugin.class, Collections.emptyList()),  
     */
    }
                "[1,2,3]"
public abstract class BaseScalarFunctionIT extends OpenSearchIntegTestCase {
/**
                5686L,
            ArrowBasePlugin.class,
    protected void assertScalarIntStrict(String expr, int expected) {
        Object cell = evalScalar(expr);
            .get();
import org.opensearch.test.OpenSearchIntegTestCase;
}  
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        Object cell = evalScalar(expr);
                "{\"k\":1}"  
            .get();  
            .startObject("balance")
import org.opensearch.core.xcontent.XContentBuilder;  
                "json_str",  
            // scalar-JSON UDFs can be exercised on real column values (columnar
 * {@code source=bank | eval x = <expr> | fields x | head 1}. Inputs are
    protected Collection<PluginInfo> additionalNodePlugins() {  
                "created_at",  
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            "1.8",
     */  
        assertNotNull(expr + " result must not be null", cell);
    private void indexBankDocs() {
    }
                6,
            .put("index.pluggable.dataformat", "composite")
import org.opensearch.cluster.metadata.IndexMetadata;
    /**
 * this file be licensed under the Apache-2.0 license or a
        );
            Version.CURRENT,
            .indices()
    protected Settings nodeSettings(int nodeOrdinal) {
            .build();
 * arithmetic on rows.
    }  
import org.opensearch.arrow.allocator.ArrowBasePlugin;
import org.opensearch.composite.CompositeDataFormatPlugin;
            .endObject()  
            .startObject("json_str")
import org.opensearch.ppl.action.PPLResponse;  
import java.util.List;  
        // SUITE-scoped cluster is reused across test methods — only create/index once.  
     * implementations return {@code Int64} but get narrowed via an implicit CAST
        );
            .endObject()  
            .startObject("firstname")
            .setMapping(mapping)
import org.opensearch.analytics.AnalyticsPlugin;  
            "NA",  
    // ---- Assert helpers ----
     * which prevents Calcite's constant-folding from optimizing the function  
        // This lets scalar-JSON UDF tests assert both the happy path (row 1 → length 3)  
            .build();  
import org.opensearch.common.util.FeatureFlags;  
// surfaces as cascading NodeDisconnectedException when many test methods share a SUITE cluster.
     * Use for functions whose on-wire BIGINT return type must not silently regress.  
            .field("type", "date")
        assertEquals("schema columns", List.of("x"), response.getColumns());
        assertNotNull("PPLResponse must not be null", response);  
            .endObject()  
            refresh(BANK_INDEX);
                "firstname",
            .startObject("account_number")
    @Override  
                39225L,  
                "2024-01-20T14:45:30Z",
// TEST-scope cluster per method — slower but eliminates cluster-reuse degradation that  
        assertTrue(expr + " result must be Number, got " + cell.getClass(), cell instanceof Number);  
        CreateIndexResponse response = client().admin()
        assertTrue(expr + " result must be Number, got " + cell.getClass(), cell instanceof Number);  
     * lets tests reference {@code firstname} / {@code balance} as fields —
            .field("type", "long")
    }
                "json_str",
    }
    protected void assertScalarDouble(String expr, double expected, double delta) {  
            .endObject()  
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
        );
        assertEquals(expr, expected, ((Number) cell).longValue());
 * <p>Each subclass declares its functions as test methods using the  
import org.opensearch.common.xcontent.XContentFactory;
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
// coord-only node. The 5-node default (3 cluster-managers + 1 data + 1 coord) is a memory
 */
        Object cell = evalScalar(expr);  
        assertEquals(expr, expected, cell);
            .startObject()
    protected void assertScalarBoolean(String expr, boolean expected) {
import java.util.Collection;
            .field("type", "long")
    private void createBankIndex() throws Exception {  
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
        assertNotNull(expr + " result must not be null", cell);  
        // Row 1 carries a 3-element JSON array in json_str; row 6 carries a JSON object.
                "firstname",  
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
            .endObject()
    }
        return new PluginInfo(  
// single-shard execution, which doesn't need dedicated cluster-managers or a separate
            CompositeDataFormatPlugin.class,  
            .put("index.composite.primary_data_format", "parquet")  
        Object cell = evalScalar(expr);
     * on the enclosing Project. The non-strict {@link #assertScalarLong} silently
        assertEquals(expr, expected, ((Number) cell).doubleValue(), delta);
    protected void assertScalarLong(String expr, long expected) {  
     */
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
    }  
 *  
        assertEquals(expr, expected, ((Integer) cell).intValue());  
            "source=" + BANK_INDEX + " | where account_number = 1 | eval x = " + expr + " | fields x | head 1"  
            .setSettings(indexSettings)
     * {@code account_number=1} (firstname='Amber', balance=39225) and returns  
            .startObject("properties")  
        // and the non-array → NULL path (row 6) from real column values.
                "2024-06-15T10:30:00Z",
import org.opensearch.plugins.Plugin;
import java.util.Collections;
import org.opensearch.plugins.PluginInfo;  
 * The OpenSearch Contributors require contributions made to  
    @Override
     * e.g. PPL scalar UDFs declared as {@code INTEGER_FORCE_NULLABLE} whose Rust  
            indexBankDocs();  
 * Shared fixture + scalar-result assert helpers for end-to-end PPL → Calcite →  
     * Strict variant that asserts the cell is a {@link Long} (not just a {@link Number}).
        assertEquals(expr, expected, cell.toString());
// combining cluster-manager and data roles: scalar-function tests exercise query rewrite +  
            .prepareCreate(BANK_INDEX)  
        Object cell = evalScalar(expr);  
    protected static final String BANK_INDEX = "bank";
                "created_at",
    /**  
// pressure source that destabilises node discovery on resource-constrained runners.  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertTrue(expr + " result must be Integer, got " + cell.getClass(), cell instanceof Integer);
            extendedPlugins,
            .endObject();
 * Substrait → DataFusion scalar-function tests.
    protected void assertScalarLongStrict(String expr, long expected) {
            LucenePlugin.class
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertNotNull(expr + " result must not be null", cell);
     * away at plan time. Tests must therefore use field references to truly
        assertTrue(expr + " result must be Boolean, got " + cell.getClass(), cell instanceof Boolean);
        XContentBuilder mapping = XContentFactory.jsonBuilder()
    }  
        Object cell = evalScalar(expr);  
    }
 * compatible open source license.
    public void setUp() throws Exception {
        if (!indexExists(BANK_INDEX)) {
            pluginClass.getName(),
            .startObject("created_at")
        client().prepareIndex(BANK_INDEX)
     * exercise the Substrait + DataFusion runtime path.
    }  
        super.setUp();
import org.opensearch.ppl.action.PPLRequest;
            createBankIndex();
     * the resulting cell. Pinning the row makes assertions deterministic and
