import org.opensearch.analytics.spi.ProjectCapability;
    private static final Set<FilterCapability> FILTER_CAPS;
            new JoinCapability(
        ScalarFunction.OR,
import java.util.List;
        AggregateFunction.PERCENTILE_APPROX,
import org.opensearch.analytics.spi.WindowFunction;
    @Override
        ScalarFunction.DIVIDE,
                    WindowFunction.AVG,
        PROJECT_CAPS = caps;
                    WindowFunction.MIN,
        }
        AggregateFunction.SUM,
package org.opensearch.analytics.planner;
    protected Set<WindowCapability> windowCapabilities() {
import org.opensearch.analytics.spi.AggregateFunction;
                    JoinCapability.JoinKind.CROSS
    protected Set<EngineCapability> supportedEngineCapabilities() {
import java.util.Set;
    private static final Set<AggregateCapability> AGG_CAPS;
    @Override
    protected Set<FilterCapability> filterCapabilities() {
            @Override
        ScalarFunction.POWER,
            @Override
    protected Set<JoinCapability> joinCapabilities() {
    }
        FILTER_CAPS = caps;
        AGG_CAPS = caps;
    }
        return (context, backendContext) -> new ExchangeSink() {
/*
        AggregateFunction.MAX,
        ScalarFunction.IN,
        Set<FilterCapability> caps = new HashSet<>();
        for (ScalarFunction op : PROJECT_OPS) {
    private static final Set<String> DATAFUSION_FORMATS = Set.of(PARQUET_DATA_FORMAT);
    private static final Set<ScalarFunction> STANDARD_OPS = Set.of(
        // Type coercion / null handling
            public void close() {}
        ScalarFunction.SIN,
                Set.of(PARQUET_DATA_FORMAT)
    private static final Set<AggregateFunction> AGG_FUNCTIONS = Set.of(
            new WindowCapability(
        // partitions. Required so OpenSearchDistributionTraitDef / HashShuffleDispatch admit this
import org.opensearch.analytics.spi.ScanCapability;
    );
        return Set.of(
    @Override
    protected Set<ScanCapability> scanCapabilities() {
        AggregateFunction.TAKE
        ScalarFunction.IS_NOT_NULL,
            caps.add(new FilterCapability.Standard(op, SUPPORTED_TYPES, DATAFUSION_FORMATS));
                    JoinCapability.JoinKind.FULL,
        AggregateFunction.COUNT,
    protected Set<DataTransferCapability> dataTransferCapabilities() {
        return Set.of(
        };
    private static final Set<EngineCapability> OPERATOR_CAPS = Set.of(EngineCapability.SORT, EngineCapability.VALUES);
    // STATE_EXPANDING aggregates carrying a literal config arg — exercised by the literal-arg
    public EngineReaderManager<Object> createReaderManager(ReaderManagerConfig settings) {
        AggregateFunction.SUM0,
    );
            new DataTransferCapability(DataTransferCapability.Kind.PRODUCER, "arrow-ipc-partitioned"),
import org.opensearch.analytics.spi.ScalarFunction;
import org.opensearch.plugins.SearchBackEndPlugin;
                    JoinCapability.JoinKind.LEFT,
 * this file be licensed under the Apache-2.0 license or a
                    WindowFunction.SUM,
        // of dc/earliest/latest is advertised; the actual rewrite to FIRST_VALUE /
        Set<ProjectCapability> caps = new HashSet<>();
        for (ScalarFunction op : STANDARD_OPS) {
        ScalarFunction.CAST,
 *
import org.opensearch.analytics.spi.JoinCapability;
                    JoinCapability.JoinKind.INNER,
        }
    @Override
        ScalarFunction.NOT,
        return List.of(PARQUET_DATA_FORMAT);
        ScalarFunction.COALESCE,
    }
        return SCAN_CAPS;
                    JoinCapability.JoinKind.SEMI,
    private static final Set<ProjectCapability> PROJECT_CAPS;
            public void feed(VectorSchemaRoot batch) {}
        );
    protected Set<AggregateCapability> aggregateCapabilities() {
                    WindowFunction.DISTINCT_COUNT_APPROX,
 * The OpenSearch Contributors require contributions made to
        // LAST_VALUE / COUNT(DISTINCT) happens in BackendPlanAdapter before substrait
import org.opensearch.analytics.spi.AggregateCapability;
    public static final String NAME = "mock-parquet";
                ),
 *
import org.opensearch.analytics.spi.ExchangeSink;
    // ---- SearchBackEndPlugin (storage) ----
    public List<String> getSupportedFormats() {
    }
    @Override
        ScalarFunction.GREATER_THAN,
        return Set.of(
import org.apache.arrow.vector.VectorSchemaRoot;
 * Mock DataFusion backend for tests. Supports parquet format with columnar storage,
        ScalarFunction.UPPER,
                    WindowFunction.ARG_MAX,
        ScalarFunction.LESS_THAN,
import org.opensearch.analytics.spi.DataTransferCapability;
    @Override
    }
            caps.add(AggregateCapability.stateExpanding(func, SUPPORTED_TYPES, DATAFUSION_FORMATS));
        ScalarFunction.CONCAT,
    }
    public static final String PARQUET_DATA_FORMAT = "parquet";
        ScalarFunction.LESS_THAN_OR_EQUAL,
    }
                    WindowFunction.ARG_MIN,
    protected Set<ProjectCapability> projectCapabilities() {
        return AGG_CAPS;
        for (AggregateFunction func : STATE_EXPANDING_AGG_FUNCTIONS) {
        SUPPORTED_TYPES.addAll(FieldType.date());
    @Override
    @Override
 * SPDX-License-Identifier: Apache-2.0
    @Override
        );
        ScalarFunction.CASE,
/**
    public String name() {
        ScalarFunction.GREATER_THAN_OR_EQUAL,
            new DataTransferCapability(DataTransferCapability.Kind.CONSUMER, "arrow-ipc-partitioned")
                    WindowFunction.RANK,
        // Mirror the real DataFusion backend: it can both produce and consume hash-shuffle
        AggregateFunction.AVG
    static {
    }
        ScalarFunction.NOT_EQUALS,
 * standard filter operators on NUMERIC/KEYWORD/DATE/BOOLEAN, and common aggregates.
        // Mirrors DataFusionAnalyticsBackendPlugin.windowCapabilities — the *PPL form*
    private static final Set<AggregateFunction> STATE_EXPANDING_AGG_FUNCTIONS = Set.of(
        return PROJECT_CAPS;
        ScalarFunction.MINUS,
        return FILTER_CAPS;
                Set.of(PARQUET_DATA_FORMAT)
    private static final Set<ScalarFunction> PROJECT_OPS = Set.of(
                    WindowFunction.ROW_NUMBER,
        ScalarFunction.LESS_THAN,
        ScalarFunction.LESS_THAN_OR_EQUAL,
        SUPPORTED_TYPES.addAll(FieldType.numeric());
            )
    }
                ),
        ScalarFunction.LIKE
    static {
        ScalarFunction.AND,
import org.opensearch.analytics.spi.ExchangeSinkProvider;
    }
import org.opensearch.analytics.spi.EngineCapability;
 * No full-text support.
 * falls through to the defaults declared here.
                    WindowFunction.COUNT,
import org.opensearch.analytics.spi.FieldType;
        SUPPORTED_TYPES.add(FieldType.BOOLEAN);
        // Arithmetic / math (emitted by Calcite's AggregateReduceFunctionsRule)
        // backend as a shuffle producer (filterByShuffleProducerCapability).
        return OPERATOR_CAPS;
import org.opensearch.index.engine.exec.EngineReaderManager;
        ScalarFunction.EQUALS,
    // Project-split plan-shape tests. Registered via the stateExpanding factory (not simple()).
        return NAME;
 * compatible open source license.
 */
        ScalarFunction.EQUALS,
        ScalarFunction.IS_NULL,
        ScalarFunction.GREATER_THAN_OR_EQUAL,
        // emission.
import java.util.HashSet;
            caps.add(new ProjectCapability.Scalar(op, SUPPORTED_TYPES, DATAFUSION_FORMATS, false));
    public ExchangeSinkProvider getExchangeSinkProvider() {
import org.opensearch.analytics.spi.WindowCapability;
        ScalarFunction.PLUS,
        }
 */
            )
                Set.of(
        Set<AggregateCapability> caps = new HashSet<>();
    }
        SUPPORTED_TYPES.addAll(FieldType.keyword());
        ScalarFunction.IS_NULL,
}
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
        ScalarFunction.IS_NOT_NULL,
    }
        return null;
                Set.of(
                    JoinCapability.JoinKind.ANTI,
    }
    }
        ScalarFunction.TIMES,
import org.opensearch.analytics.spi.FilterCapability;
        // Stub — real implementation provided by DataFusion backend
    private static final Set<FieldType> SUPPORTED_TYPES = new HashSet<>();
    static {
        AggregateFunction.MIN,
        // Logical connectives (projection-side composition: `case(a and b, …)`)
 * <p>Tests override only the capability methods they need — everything else
        );
        ScalarFunction.NOT_EQUALS,
    private static final Set<ScanCapability> SCAN_CAPS = Set.of(new ScanCapability.DocValues(DATAFUSION_FORMATS, SUPPORTED_TYPES));
                    WindowFunction.MAX,
        ScalarFunction.ABS
        for (AggregateFunction func : AGG_FUNCTIONS) {
        ScalarFunction.GREATER_THAN,
public class MockDataFusionBackend extends MockBackend implements SearchBackEndPlugin<Object> {
    );
    static {
        // Conditional / comparisons (STDDEV_SAMP / VAR_SAMP emit CASE WHEN count > 1 …)
    }
        }
    }
    @Override
                    WindowFunction.DENSE_RANK
            caps.add(AggregateCapability.simple(func, SUPPORTED_TYPES, DATAFUSION_FORMATS));
                    JoinCapability.JoinKind.RIGHT,
    );
    @Override
    @Override
        // String — used by QTF plan-shape tests covering composite expressions / dedup.
