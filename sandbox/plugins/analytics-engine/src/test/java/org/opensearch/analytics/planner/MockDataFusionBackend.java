        for (AggregateFunction func : AGG_FUNCTIONS) {
        ScalarFunction.UPPER,
    private static final Set<ScalarFunction> PROJECT_OPS = Set.of(  
import java.util.List;  
    }  
    @Override
        ScalarFunction.CASE,
        ScalarFunction.LESS_THAN_OR_EQUAL,  
                ),
}
    protected Set<ProjectCapability> projectCapabilities() {
        return Set.of(
                    WindowFunction.AVG,  
/**  
        ScalarFunction.IS_NULL,
 * standard filter operators on NUMERIC/KEYWORD/DATE/BOOLEAN, and common aggregates.
    }
        ScalarFunction.AND,  
 */
        return NAME;  
        ScalarFunction.DIVIDE,
import org.opensearch.analytics.spi.ScanCapability;
    private static final Set<AggregateCapability> AGG_CAPS;
    }
    @Override
        AggregateFunction.TAKE
    protected Set<JoinCapability> joinCapabilities() {  
            )
                    JoinCapability.JoinKind.LEFT,
        AggregateFunction.MAX,
    }
        // Stub — real implementation provided by DataFusion backend
        }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.analytics.spi.ExchangeSink;  
    // STATE_EXPANDING aggregates carrying a literal config arg — exercised by the literal-arg
    public String name() {
 * <p>Tests override only the capability methods they need — everything else
 * No full-text support.  
                    WindowFunction.ARG_MAX,
        // Mirrors DataFusionAnalyticsBackendPlugin.windowCapabilities — the *PPL form*
 * SPDX-License-Identifier: Apache-2.0
        SUPPORTED_TYPES.add(FieldType.BOOLEAN);  
    }  
 *
        ScalarFunction.CAST,
    @Override
        }
        FILTER_CAPS = caps;
 * compatible open source license.
    @Override  
    private static final Set<ScalarFunction> STANDARD_OPS = Set.of(  
        for (ScalarFunction op : STANDARD_OPS) {
            caps.add(new FilterCapability.Standard(op, SUPPORTED_TYPES, DATAFUSION_FORMATS));  
                    JoinCapability.JoinKind.RIGHT,  
                    WindowFunction.RANK,
    protected Set<ScanCapability> scanCapabilities() {
        ScalarFunction.CONCAT,
    protected Set<FilterCapability> filterCapabilities() {
        // Logical connectives (projection-side composition: `case(a and b, …)`)
import org.opensearch.analytics.spi.ExchangeSinkProvider;
        // of dc/earliest/latest is advertised; the actual rewrite to FIRST_VALUE /
        ScalarFunction.GREATER_THAN_OR_EQUAL,
    }  
                    JoinCapability.JoinKind.ANTI,  
        Set<ProjectCapability> caps = new HashSet<>();  
    }  
        ScalarFunction.LESS_THAN_OR_EQUAL,
    public static final String PARQUET_DATA_FORMAT = "parquet";
    protected Set<DataTransferCapability> dataTransferCapabilities() {
                Set.of(  
import org.opensearch.analytics.spi.AggregateCapability;
    public ExchangeSinkProvider getExchangeSinkProvider() {
                    JoinCapability.JoinKind.FULL,
import java.util.HashSet;
    );
        return Set.of(  
        Set<AggregateCapability> caps = new HashSet<>();
import org.opensearch.analytics.spi.WindowFunction;  
    private static final Set<ScanCapability> SCAN_CAPS = Set.of(new ScanCapability.DocValues(DATAFUSION_FORMATS, SUPPORTED_TYPES));
    @Override
    private static final Set<FieldType> SUPPORTED_TYPES = new HashSet<>();
import org.opensearch.analytics.spi.JoinCapability;
        };  
        ScalarFunction.IS_NULL,
        Set<FilterCapability> caps = new HashSet<>();
    protected Set<WindowCapability> windowCapabilities() {  
            public void close() {}
        // Arithmetic / math (emitted by Calcite's AggregateReduceFunctionsRule)
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
import org.opensearch.analytics.spi.EngineCapability;
        ScalarFunction.ABS
        return PROJECT_CAPS;
    }
        ScalarFunction.LESS_THAN,
            @Override
            )  
        for (AggregateFunction func : STATE_EXPANDING_AGG_FUNCTIONS) {
            public void feed(VectorSchemaRoot batch) {}
        // Mirror the real DataFusion backend: it can both produce and consume hash-shuffle  
 *
                    WindowFunction.MIN,
    );  
                Set.of(PARQUET_DATA_FORMAT)
        ScalarFunction.MINUS,  
import java.util.Set;
                    WindowFunction.DISTINCT_COUNT_APPROX,  
    protected Set<EngineCapability> supportedEngineCapabilities() {
/*  
        ScalarFunction.GREATER_THAN_OR_EQUAL,
    }
                    WindowFunction.SUM,
        ScalarFunction.PLUS,
        ScalarFunction.NOT_EQUALS,
    }
    @Override
        ScalarFunction.NOT_EQUALS,  
                    JoinCapability.JoinKind.SEMI,
                    WindowFunction.MAX,  
    private static final Set<FilterCapability> FILTER_CAPS;
        }
        return SCAN_CAPS;  
        AGG_CAPS = caps;
        return (context, backendContext) -> new ExchangeSink() {  
    }
    );
        );  
        ScalarFunction.IS_NOT_NULL,
        ScalarFunction.EQUALS,
        // LAST_VALUE / COUNT(DISTINCT) happens in BackendPlanAdapter before substrait  
        for (ScalarFunction op : PROJECT_OPS) {
    private static final Set<EngineCapability> OPERATOR_CAPS = Set.of(EngineCapability.SORT, EngineCapability.VALUES);
        return OPERATOR_CAPS;
        // Type coercion / null handling
public class MockDataFusionBackend extends MockBackend implements SearchBackEndPlugin<Object> {
import org.apache.arrow.vector.VectorSchemaRoot;
        ScalarFunction.TIMES,
 * falls through to the defaults declared here.  
            new WindowCapability(  
    static {  
        ScalarFunction.SIN,  
        // String — used by QTF plan-shape tests covering composite expressions / dedup.  
    public List<String> getSupportedFormats() {  
        AggregateFunction.AVG
                    WindowFunction.COUNT,
    protected Set<AggregateCapability> aggregateCapabilities() {  
    static {  
package org.opensearch.analytics.planner;
        SUPPORTED_TYPES.addAll(FieldType.keyword());
 */  
        );
        ScalarFunction.IN,  
        ScalarFunction.COALESCE,  
                    WindowFunction.ROW_NUMBER,
        return Set.of(
        SUPPORTED_TYPES.addAll(FieldType.date());
    @Override  
    @Override
    @Override
import org.opensearch.analytics.spi.ScalarFunction;  
        AggregateFunction.SUM,
    private static final Set<AggregateFunction> STATE_EXPANDING_AGG_FUNCTIONS = Set.of(  
    // ---- SearchBackEndPlugin (storage) ----  
        return List.of(PARQUET_DATA_FORMAT);
        PROJECT_CAPS = caps;
            caps.add(AggregateCapability.stateExpanding(func, SUPPORTED_TYPES, DATAFUSION_FORMATS));  
import org.opensearch.index.engine.exec.EngineReaderManager;
            new JoinCapability(
        ScalarFunction.GREATER_THAN,  
    public EngineReaderManager<Object> createReaderManager(ReaderManagerConfig settings) {
    );
import org.opensearch.analytics.spi.FilterCapability;  
        ScalarFunction.GREATER_THAN,
        AggregateFunction.COUNT,  
                ),
                Set.of(
import org.opensearch.analytics.spi.ProjectCapability;
            caps.add(new ProjectCapability.Scalar(op, SUPPORTED_TYPES, DATAFUSION_FORMATS, false));
                    WindowFunction.DENSE_RANK  
                    JoinCapability.JoinKind.CROSS
        // backend as a shuffle producer (filterByShuffleProducerCapability).
import org.opensearch.analytics.spi.AggregateFunction;  
        AggregateFunction.PERCENTILE_APPROX,
            new DataTransferCapability(DataTransferCapability.Kind.CONSUMER, "arrow-ipc-partitioned")
import org.opensearch.analytics.spi.FieldType;
        return FILTER_CAPS;  
    @Override
        return null;  
import org.opensearch.analytics.spi.DataTransferCapability;
        return AGG_CAPS;
    private static final Set<ProjectCapability> PROJECT_CAPS;
    private static final Set<AggregateFunction> AGG_FUNCTIONS = Set.of(
    @Override  
import org.opensearch.analytics.spi.WindowCapability;
    static {
    public static final String NAME = "mock-parquet";
        ScalarFunction.NOT,
import org.opensearch.plugins.SearchBackEndPlugin;  
    static {
        AggregateFunction.MIN,
    }
    @Override
        }  
        ScalarFunction.EQUALS,
        // partitions. Required so OpenSearchDistributionTraitDef / HashShuffleDispatch admit this
 * Mock DataFusion backend for tests. Supports parquet format with columnar storage,
        ScalarFunction.IS_NOT_NULL,
    }
    }
            @Override
    }  
        ScalarFunction.POWER,  
        SUPPORTED_TYPES.addAll(FieldType.numeric());  
        ScalarFunction.LESS_THAN,  
        ScalarFunction.OR,
                Set.of(PARQUET_DATA_FORMAT)  
                    WindowFunction.ARG_MIN,
        ScalarFunction.LIKE
        AggregateFunction.SUM0,  
        // emission.
            new DataTransferCapability(DataTransferCapability.Kind.PRODUCER, "arrow-ipc-partitioned"),
            caps.add(AggregateCapability.simple(func, SUPPORTED_TYPES, DATAFUSION_FORMATS));  
    }
        // Conditional / comparisons (STDDEV_SAMP / VAR_SAMP emit CASE WHEN count > 1 …)  
        );
                    JoinCapability.JoinKind.INNER,
    // Project-split plan-shape tests. Registered via the stateExpanding factory (not simple()).
    private static final Set<String> DATAFUSION_FORMATS = Set.of(PARQUET_DATA_FORMAT);  
