        );
                    break;
    private boolean runAsync;
import org.apache.arrow.vector.types.pojo.Schema;
                        doc.addField(ft, (long) i * 100);
        indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
            nativeAllocator = null;
    private String filePath;
    private ArrowBufferPool bufferPool;
import org.openjdk.jmh.annotations.Measurement;
 * </ul>
        schema = new Schema(arrowFields);
            )
        vsrManager = new VSRManager(filePath, indexSettings, schema, bufferPool, maxRowsPerVSR, threadPool, runAsync, 0L);
            }
                MappedFieldType ft = fieldTypes.get(f);
        Settings idxSettings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
import org.opensearch.common.settings.Settings;
                Runtime.getRuntime().availableProcessors(),
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.TearDown;
            MappedFieldType ft;
                        doc.addField(ft, i);
 * compatible open source license.
 */
 *
import org.opensearch.index.engine.dataformat.DataFormat;
package org.opensearch.parquet.benchmark;
    public void setup() throws IOException {
                        break;
    }
        }
@Measurement(iterations = 5, time = 10, timeUnit = TimeUnit.SECONDS)
        } catch (Exception ignored) {}
import java.util.Map;
import org.openjdk.jmh.annotations.Benchmark;
    private static final DataFormat PARQUET_FORMAT = new ParquetDataFormat();
import org.openjdk.jmh.annotations.Mode;
            PARQUET_FORMAT.supportedFields()
 * this file be licensed under the Apache-2.0 license or a
        threadPool = new ThreadPool(
import org.openjdk.jmh.annotations.Warmup;
    public void tearDownTrial() {
                    default:
            ParquetField pf = ArrowFieldRegistry.getParquetField(ft.typeName());
                case 0:
    private int totalDocuments;
                .findFirst()
/**
/*
                    case 1:
    private VSRManager vsrManager;
        for (int i = 0; i < fieldCount; i++) {
    private int fieldCount;
    private IndexSettings indexSettings;
        }
@BenchmarkMode(Mode.AverageTime)
        threadPool.shutdownNow();
            settings,
import org.opensearch.parquet.writer.ParquetDocumentInput;
    @TearDown(Level.Invocation)
        RustBridge.initLogger();
                    break;
import java.util.List;
    private Schema schema;
import org.opensearch.index.mapper.NumberFieldMapper;
            new FixedExecutorBuilder(
    @Benchmark
import org.opensearch.threadpool.FixedExecutorBuilder;
        for (int i = 0; i < totalDocuments; i++) {
    @TearDown(Level.Trial)
 */
                default:
            vsrManager.flush();
import org.openjdk.jmh.annotations.State;
import org.opensearch.index.mapper.MappedFieldType;
import org.opensearch.index.IndexSettings;
        filePath = Path.of(System.getProperty("java.io.tmpdir"), "benchmark_vsr_" + System.nanoTime() + ".parquet").toString();
                    case 0:
import org.openjdk.jmh.annotations.Scope;
                -1,
        bufferPool = new ArrowBufferPool(Settings.EMPTY, nativeAllocator);
}
 * The OpenSearch Contributors require contributions made to
import org.opensearch.parquet.ParquetDataFormatPlugin;
    public void benchmarkDocumentIngestion() throws IOException {
                        doc.addField(ft, "value_" + i);
            vsrManager.close();
@Warmup(iterations = 2, time = 10, timeUnit = TimeUnit.SECONDS)
            switch (i % 3) {
        try {
                    ft = new NumberFieldMapper.NumberFieldType("int_field_" + i, NumberFieldMapper.NumberType.INTEGER);
        Settings settings = Settings.builder().put("node.name", "benchmark-node").build();
 * <p>Measures end-to-end document ingestion throughput across multiple VSR rotations.
import org.opensearch.parquet.vsr.VSRManager;
    private int maxRowsPerVSR;
    @Param({ "10000000" })
import org.opensearch.arrow.spi.PoolGroup;
import org.opensearch.parquet.engine.ParquetDataFormat;
import org.opensearch.parquet.memory.ArrowBufferPool;
                ParquetDataFormatPlugin.PARQUET_THREAD_POOL_NAME,
@State(Scope.Benchmark)
 * <ul>
        nativeAllocator = new ArrowNativeAllocator();
    @Setup(Level.Invocation)
import org.openjdk.jmh.annotations.Param;
        } catch (Exception ignored) {}
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
import org.apache.arrow.vector.types.pojo.Field;
            vsrManager.addDocument(doc);
            nativeAllocator.close();
 *
                    ft = new NumberFieldMapper.NumberFieldType("long_field_" + i, NumberFieldMapper.NumberType.LONG);
            for (int f = 0; f < fieldTypes.size(); f++) {
 * The {@code runAsync} parameter toggles between:
                .ifPresent(ftc -> ft.setCapabilityMap(Map.of(PARQUET_FORMAT, ftc.capabilities())));
import org.opensearch.cluster.metadata.IndexMetadata;
    }
import java.io.IOException;
        List<Field> arrowFields = new ArrayList<>();
import org.opensearch.parquet.bridge.RustBridge;
    @Param({ "20" })
        bufferPool.close();
 *   <li>{@code true} — frozen VSR writes happen on a background thread (post-optimization)</li>
            Files.deleteIfExists(Path.of(filePath));
    public void setupTrial() {
    }
            arrowFields.add(new Field(ft.name(), pf.getFieldType(), null));
    @Setup(Level.Trial)
                switch (f % 3) {
                settings,
        try {
import org.opensearch.Version;
import org.opensearch.threadpool.ThreadPool;
                        break;
    private ThreadPool threadPool;
            }
import org.openjdk.jmh.annotations.Setup;
            ParquetDocumentInput doc = new ParquetDocumentInput();
import org.opensearch.parquet.fields.ArrowFieldRegistry;
        } catch (Exception ignored) {}
import org.openjdk.jmh.annotations.Fork;
    @Param({ "true", "false" })
        try {
                .filter(ftc -> ftc.fieldType().equals(ft.typeName()))
    private List<MappedFieldType> fieldTypes;
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
    public void tearDown() {
                .stream()
    }
            fieldTypes.add(ft);
@Fork(1)
import java.util.ArrayList;
                    ft = new KeywordFieldMapper.KeywordFieldType("keyword_field_" + i);
    @Param({ "100000" })
                "thread_pool." + ParquetDataFormatPlugin.PARQUET_THREAD_POOL_NAME
                case 1:
 * SPDX-License-Identifier: Apache-2.0
        fieldTypes = new ArrayList<>();
 *   <li>{@code false} — frozen VSR writes block the calling thread (pre-optimization baseline)</li>
                    break;
 * JMH benchmark comparing synchronous vs asynchronous VSR rotation.
@OutputTimeUnit(TimeUnit.MILLISECONDS)
        }
                        break;
import org.openjdk.jmh.annotations.BenchmarkMode;
    }
    private ArrowNativeAllocator nativeAllocator;
import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
                }
import org.opensearch.index.mapper.KeywordFieldMapper;
import org.opensearch.parquet.fields.ParquetField;
import java.nio.file.Path;
        if (nativeAllocator != null) {
public class VSRRotationBenchmark {
import org.openjdk.jmh.annotations.OutputTimeUnit;
        nativeAllocator.getOrCreatePool(NativeAllocatorPoolConfig.POOL_INGEST, 0L, Long.MAX_VALUE, PoolGroup.INDEXING);
        IndexMetadata indexMetadata = IndexMetadata.builder("benchmark-index").settings(idxSettings).build();
