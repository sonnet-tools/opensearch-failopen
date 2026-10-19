            if (isKeyword[i] && preCheck) {
    private Object[] values;
    public void collectClickBenchDocument(Blackhole bh) {
                    values[i] = (long) i;
        // Same construction the parquet unit tests use for the engine-populated metadata fields.
        for (FieldValuePair pair : input.getFinalInput()) {
        }
    }
        input.setRowId(DocumentInput.ROW_ID_FIELD, rowId++);
                    values[i] = i;
        seqNoType = new NumberFieldMapper.NumberFieldType(SeqNoFieldMapper.NAME, NumberFieldMapper.NumberType.LONG);
import org.openjdk.jmh.annotations.Benchmark;
                    isKeyword[i] = true;
            switch (CLICKBENCH_COLUMN_SHAPE.charAt(i)) {
                default -> throw new IllegalStateException("unknown column shape " + CLICKBENCH_COLUMN_SHAPE.charAt(i));
            String name = "c" + i;
 * this file be licensed under the Apache-2.0 license or a
        int n = CLICKBENCH_COLUMN_SHAPE.length();
import org.opensearch.parquet.engine.ParquetDataFormat;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import java.util.Map;
                if (ft.isMultiValued() == false && ft.isMultiValueSupported() && input.getFieldCount(ft.name()) > 0) {
                    MappedFieldType keyword = new KeywordFieldMapper.KeywordFieldType(name);
@State(Scope.Benchmark)
@Warmup(iterations = 3, time = 3, timeUnit = TimeUnit.SECONDS)
    /** Whether to run the mapper's promotion pre-check ({@code getFieldCount}) before each keyword value. */
        input.addField(seqNoType, rowId);
 * {@code ParametrizedFieldMapper#addFieldForPluggableFormat} first asks
        for (int i = 0; i < fieldTypes.length; i++) {
}
                }
            .filter(ftc -> ftc.fieldType().equals(fieldType.typeName()))
                }
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Fork;
import org.opensearch.index.mapper.NumberFieldMapper;
                case 'K' -> {
                    values[i] = "keyword-value-" + i;
import org.openjdk.jmh.annotations.Warmup;
        "SSKKIDISIISSIISDDLISSSKSISSSKISSSSSSSSSSSSSDSKSSSIKKKKKKKSKLKKSLIIISSSIISSKISSSISSKKSKSLIKKKKKSSKLLSSIS";
                    fieldTypes[i] = new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.SHORT);
 * <p>Run with:
        }
import org.openjdk.jmh.annotations.BenchmarkMode;
 * scalar-to-LIST promotion) and only then calls {@link DocumentInput#addField}. The
 * </pre>
    /** Mirrors what {@code FieldCapabilityAssigner.assign} does at mapping build time. */
import org.opensearch.index.mapper.KeywordFieldMapper;
 *     --args='DocumentInputCollectBenchmark'
                    // convenience constructor leaves the flag unset, so mirror the builder path here.
    @Benchmark
 *
            .stream()
 *
                case 'D' -> {
        }
                }
            input.addField(ft, values[i]);
import org.opensearch.index.mapper.SeqNoFieldMapper;
 * The OpenSearch Contributors require contributions made to
import org.opensearch.parquet.writer.ParquetDocumentInput;
 * <p>For every keyword field in the default {@code multi_value: auto} state,
        rowId = 0;
import org.opensearch.index.engine.dataformat.DocumentInput;
        primaryTermType = new NumberFieldMapper.NumberFieldType(SeqNoFieldMapper.PRIMARY_TERM_NAME, NumberFieldMapper.NumberType.LONG);
/*
 *
import org.openjdk.jmh.annotations.Scope;
        assignCapabilities(idType);
    private static final String CLICKBENCH_COLUMN_SHAPE =
 * performs while parsing a ClickBench {@code hits} row (106 columns: 25 keyword, 49 short,
    /**
    private static final DataFormat PARQUET = new ParquetDataFormat();
            bh.consume(pair);
    /** ClickBench hits column types in mapping order: K=keyword S=short I=integer L=long D=date. */
import org.openjdk.jmh.annotations.State;
 * Replays, per document, the exact {@link ParquetDocumentInput} call sequence the mapper layer
    public boolean preCheck;
        assignCapabilities(seqNoType);
/**
                case 'I' -> {
 * compatible open source license.
    private long rowId;
        fieldTypes = new MappedFieldType[n];
        assignCapabilities(primaryTermType);
 * SPDX-License-Identifier: Apache-2.0
                // ParametrizedFieldMapper#addFieldForPluggableFormat, AUTO state, scalar so far.
import org.openjdk.jmh.infra.Blackhole;
                case 'L' -> {
        ParquetDocumentInput input = new ParquetDocumentInput();
            .findFirst()
            }
                    keyword.setMultiValueSupported(true);
    @Param({ "true", "false" })
public class DocumentInputCollectBenchmark {
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Measurement;
        values = new Object[n];
            }
                    fieldTypes[i] = new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.INTEGER);
        isKeyword = new boolean[n];
                    values[i] = 1_700_000_000_000L + i;
    }
    private MappedFieldType[] fieldTypes;
        assignCapabilities(versionType);
     * 106 source fields, 4 metadata fields, then finalization.
        input.addField(versionType, 1L);
@OutputTimeUnit(TimeUnit.NANOSECONDS)
                    fieldTypes[i] = keyword;
                    // Mapping-built keyword types are multi_value-capable and default to AUTO; the
 * ./gradlew -Dsandbox.enabled=true :sandbox:plugins:parquet-data-format:benchmarks:run \
    private MappedFieldType versionType;
    }
 */
 * {@link DocumentInput#getFieldCount(String)} whether the field was already seen (to decide on
            .ifPresent(ftc -> fieldType.setCapabilityMap(Map.of(PARQUET, ftc.capabilities())));
        versionType = new NumberFieldMapper.NumberFieldType(VersionFieldMapper.NAME, NumberFieldMapper.NumberType.LONG);
                }
package org.opensearch.parquet.benchmark;
                    fieldTypes[i] = new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.LONG);
            MappedFieldType ft = fieldTypes[i];
import org.opensearch.index.mapper.DateFieldMapper;
 * 19 integer, 6 long, 4 date, in the real column order), plus the four metadata fields.
     * One full document: a fresh input (the engine calls {@code newDocumentInput()} per document),
@Fork(1)
    private static void assignCapabilities(MappedFieldType fieldType) {
    private MappedFieldType idType;
import org.opensearch.index.mapper.VersionFieldMapper;
        input.addField(idType, "id-" + rowId);
import org.opensearch.parquet.writer.FieldValuePair;
                    values[i] = (short) i;
import org.opensearch.index.mapper.MappedFieldType;
            assignCapabilities(fieldTypes[i]);
        input.addField(primaryTermType, 1L);
    private MappedFieldType primaryTermType;
                }
                case 'S' -> {
        for (int i = 0; i < n; i++) {
        PARQUET.supportedFields()
    public void setup() {
     */
 * {@code preCheck} param toggles that call so its cost can be isolated from the plain collect path.
        idType = new KeywordFieldMapper.KeywordFieldType(IdFieldMapper.NAME);
                }
    private boolean[] isKeyword;
import org.opensearch.index.mapper.IdFieldMapper;
    @Setup
    private MappedFieldType seqNoType;
                    fieldTypes[i] = new DateFieldMapper.DateFieldType(name);
import java.util.concurrent.TimeUnit;
@BenchmarkMode(Mode.AverageTime)
import org.opensearch.index.engine.dataformat.DataFormat;
 * <pre>
 */
                    throw new IllegalStateException("unexpected duplicate on scalar workload");
@Measurement(iterations = 5, time = 5, timeUnit = TimeUnit.SECONDS)
