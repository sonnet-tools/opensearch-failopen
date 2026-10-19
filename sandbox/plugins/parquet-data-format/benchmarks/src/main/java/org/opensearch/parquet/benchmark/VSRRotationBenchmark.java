import java.nio.file.Path;
            switch (i % 3) {
import org.opensearch.common.settings.Settings;
import java.util.concurrent.TimeUnit;
            vsrManager.flush();
import org.opensearch.parquet.bridge.RustBridge;  
        threadPool = new ThreadPool(
            PARQUET_FORMAT.supportedFields()  
                    ft = new KeywordFieldMapper.KeywordFieldType("keyword_field_" + i);  
        }
import org.openjdk.jmh.annotations.Setup;  
        vsrManager = new VSRManager(filePath, indexSettings, schema, bufferPool, maxRowsPerVSR, threadPool, runAsync, 0L);  
                    case 1:
            new FixedExecutorBuilder(  
import org.opensearch.threadpool.FixedExecutorBuilder;
        fieldTypes = new ArrayList<>();  
@BenchmarkMode(Mode.AverageTime)
    @TearDown(Level.Invocation)
 *
import java.util.Map;
            fieldTypes.add(ft);
        bufferPool.close();  
        try {  
@State(Scope.Benchmark)
    public void setupTrial() {  
 *   <li>{@code true} — frozen VSR writes happen on a background thread (post-optimization)</li>
                    ft = new NumberFieldMapper.NumberFieldType("int_field_" + i, NumberFieldMapper.NumberType.INTEGER);  
        IndexMetadata indexMetadata = IndexMetadata.builder("benchmark-index").settings(idxSettings).build();
/**
import org.opensearch.Version;  
                .ifPresent(ftc -> ft.setCapabilityMap(Map.of(PARQUET_FORMAT, ftc.capabilities())));
        RustBridge.initLogger();
                        doc.addField(ft, "value_" + i);
    private ThreadPool threadPool;
        nativeAllocator.getOrCreatePool(NativeAllocatorPoolConfig.POOL_INGEST, 0L, Long.MAX_VALUE, PoolGroup.INDEXING);  
 *   <li>{@code false} — frozen VSR writes block the calling thread (pre-optimization baseline)</li>
                        doc.addField(ft, (long) i * 100);
                        break;  
                case 0:
/*  
import org.apache.arrow.vector.types.pojo.Schema;
        } catch (Exception ignored) {}
                MappedFieldType ft = fieldTypes.get(f);
            MappedFieldType ft;  
import org.openjdk.jmh.annotations.Param;
    private Schema schema;
            ParquetField pf = ArrowFieldRegistry.getParquetField(ft.typeName());  
        List<Field> arrowFields = new ArrayList<>();
import org.opensearch.index.IndexSettings;  
    }
            arrowFields.add(new Field(ft.name(), pf.getFieldType(), null));
import org.openjdk.jmh.annotations.OutputTimeUnit;  
import org.openjdk.jmh.annotations.State;
}
                        break;  
                    break;
        schema = new Schema(arrowFields);  
    private int totalDocuments;
    private List<MappedFieldType> fieldTypes;  
 * The {@code runAsync} parameter toggles between:
import org.opensearch.threadpool.ThreadPool;
import org.apache.arrow.vector.types.pojo.Field;
 * The OpenSearch Contributors require contributions made to  
                default:
            ParquetDocumentInput doc = new ParquetDocumentInput();  
 * </ul>  
        if (nativeAllocator != null) {
    }
        } catch (Exception ignored) {}
                    break;
                        break;  
import org.openjdk.jmh.annotations.BenchmarkMode;
            vsrManager.close();
        threadPool.shutdownNow();  
                ParquetDataFormatPlugin.PARQUET_THREAD_POOL_NAME,
    private int fieldCount;
        nativeAllocator = new ArrowNativeAllocator();
@Fork(1)
            Files.deleteIfExists(Path.of(filePath));
import org.openjdk.jmh.annotations.Benchmark;  
                    break;
    @Benchmark  
import java.io.IOException;
        filePath = Path.of(System.getProperty("java.io.tmpdir"), "benchmark_vsr_" + System.nanoTime() + ".parquet").toString();
        indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
        }
        for (int i = 0; i < totalDocuments; i++) {
    }
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
        Settings settings = Settings.builder().put("node.name", "benchmark-node").build();  
    @Setup(Level.Trial)
import java.util.ArrayList;
            )  
                case 1:
    @Setup(Level.Invocation)  
    public void setup() throws IOException {
        }
        for (int i = 0; i < fieldCount; i++) {
        } catch (Exception ignored) {}
public class VSRRotationBenchmark {
        try {  
import org.opensearch.parquet.ParquetDataFormatPlugin;
                        doc.addField(ft, i);
import org.opensearch.index.mapper.KeywordFieldMapper;
    @Param({ "100000" })
            }
    private boolean runAsync;
 * SPDX-License-Identifier: Apache-2.0
                    default:
import org.opensearch.cluster.metadata.IndexMetadata;
 * JMH benchmark comparing synchronous vs asynchronous VSR rotation.
 * <ul>  
    private ArrowBufferPool bufferPool;  
import org.opensearch.parquet.fields.ArrowFieldRegistry;
            settings,
    private VSRManager vsrManager;
    private static final DataFormat PARQUET_FORMAT = new ParquetDataFormat();
    @Param({ "true", "false" })
                switch (f % 3) {  
@Measurement(iterations = 5, time = 10, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)  
 * compatible open source license.
    public void tearDown() {
 * this file be licensed under the Apache-2.0 license or a
    private String filePath;
package org.opensearch.parquet.benchmark;
    @Param({ "20" })
 */
                .filter(ftc -> ftc.fieldType().equals(ft.typeName()))
                -1,
    private IndexSettings indexSettings;  
import org.openjdk.jmh.annotations.Warmup;  
                    ft = new NumberFieldMapper.NumberFieldType("long_field_" + i, NumberFieldMapper.NumberType.LONG);  
    }
            for (int f = 0; f < fieldTypes.size(); f++) {
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
        bufferPool = new ArrowBufferPool(Settings.EMPTY, nativeAllocator);
import org.opensearch.index.mapper.MappedFieldType;  
                "thread_pool." + ParquetDataFormatPlugin.PARQUET_THREAD_POOL_NAME
 *  
import org.opensearch.index.engine.dataformat.DataFormat;
            }
import java.util.List;  
            nativeAllocator = null;  
import org.opensearch.parquet.writer.ParquetDocumentInput;  
 */  
    }
        try {  
    @TearDown(Level.Trial)
import org.opensearch.parquet.fields.ParquetField;  
import org.opensearch.parquet.engine.ParquetDataFormat;
                }
    public void tearDownTrial() {
import org.opensearch.arrow.spi.PoolGroup;  
                .stream()
import org.opensearch.index.mapper.NumberFieldMapper;
import org.openjdk.jmh.annotations.Mode;
import java.nio.file.Files;  
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
    @Param({ "10000000" })
import org.openjdk.jmh.annotations.Scope;
    private ArrowNativeAllocator nativeAllocator;
            vsrManager.addDocument(doc);  
    public void benchmarkDocumentIngestion() throws IOException {
            nativeAllocator.close();
import org.openjdk.jmh.annotations.Level;  
        );
import org.opensearch.parquet.memory.ArrowBufferPool;
    private int maxRowsPerVSR;
@Warmup(iterations = 2, time = 10, timeUnit = TimeUnit.SECONDS)  
                Runtime.getRuntime().availableProcessors(),  
import org.opensearch.parquet.vsr.VSRManager;
 * <p>Measures end-to-end document ingestion throughput across multiple VSR rotations.
                .findFirst()  
                    case 0:
        Settings idxSettings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();  
                settings,
