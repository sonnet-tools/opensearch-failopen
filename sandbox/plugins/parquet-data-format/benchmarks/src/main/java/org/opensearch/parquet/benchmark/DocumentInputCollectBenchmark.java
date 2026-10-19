    }  
import org.openjdk.jmh.annotations.Scope;
import org.opensearch.parquet.writer.FieldValuePair;
                    values[i] = 1_700_000_000_000L + i;
                }
        assignCapabilities(seqNoType);
        values = new Object[n];
}
        input.addField(versionType, 1L);  
@Warmup(iterations = 3, time = 3, timeUnit = TimeUnit.SECONDS)
import org.openjdk.jmh.annotations.Fork;  
    private MappedFieldType[] fieldTypes;
                }
 * </pre>
                    MappedFieldType keyword = new KeywordFieldMapper.KeywordFieldType(name);  
    private MappedFieldType seqNoType;  
        primaryTermType = new NumberFieldMapper.NumberFieldType(SeqNoFieldMapper.PRIMARY_TERM_NAME, NumberFieldMapper.NumberType.LONG);
                default -> throw new IllegalStateException("unknown column shape " + CLICKBENCH_COLUMN_SHAPE.charAt(i));
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.parquet.benchmark;
    }  
import org.openjdk.jmh.annotations.Setup;  
        input.addField(idType, "id-" + rowId);
        PARQUET.supportedFields()
@State(Scope.Benchmark)  
                    fieldTypes[i] = new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.INTEGER);
                    isKeyword[i] = true;
import org.openjdk.jmh.infra.Blackhole;  
 * Replays, per document, the exact {@link ParquetDocumentInput} call sequence the mapper layer  
 *  
 * <pre>
import org.opensearch.index.mapper.NumberFieldMapper;
        }
        assignCapabilities(idType);
    @Setup  
        versionType = new NumberFieldMapper.NumberFieldType(VersionFieldMapper.NAME, NumberFieldMapper.NumberType.LONG);  
    private boolean[] isKeyword;  
import org.opensearch.index.mapper.SeqNoFieldMapper;
            .findFirst()
    private MappedFieldType primaryTermType;
                }  
 * performs while parsing a ClickBench {@code hits} row (106 columns: 25 keyword, 49 short,
    private MappedFieldType versionType;
            assignCapabilities(fieldTypes[i]);  
        "SSKKIDISIISSIISDDLISSSKSISSSKISSSSSSSSSSSSSDSKSSSIKKKKKKKSKLKKSLIIISSSIISSKISSSISSKKSKSLIKKKKKSSKLLSSIS";
                    fieldTypes[i] = new DateFieldMapper.DateFieldType(name);
 *
    }  
        assignCapabilities(primaryTermType);  
        for (FieldValuePair pair : input.getFinalInput()) {  
        input.addField(primaryTermType, 1L);
                    values[i] = i;  
 * scalar-to-LIST promotion) and only then calls {@link DocumentInput#addField}. The
                case 'S' -> {  
        idType = new KeywordFieldMapper.KeywordFieldType(IdFieldMapper.NAME);  
                case 'I' -> {
/*  
    public boolean preCheck;  
import org.openjdk.jmh.annotations.Benchmark;
        }  
    /** ClickBench hits column types in mapping order: K=keyword S=short I=integer L=long D=date. */  
 * compatible open source license.
            bh.consume(pair);
import java.util.concurrent.TimeUnit;  
                case 'K' -> {  
 *     --args='DocumentInputCollectBenchmark'
import java.util.Map;
                }  
 * <p>For every keyword field in the default {@code multi_value: auto} state,
    private static final DataFormat PARQUET = new ParquetDataFormat();
     * 106 source fields, 4 metadata fields, then finalization.
@BenchmarkMode(Mode.AverageTime)
                    values[i] = (long) i;
    public void collectClickBenchDocument(Blackhole bh) {
        rowId = 0;
        isKeyword = new boolean[n];
@Fork(1)
                    values[i] = "keyword-value-" + i;  
            }
                    // Mapping-built keyword types are multi_value-capable and default to AUTO; the
        seqNoType = new NumberFieldMapper.NumberFieldType(SeqNoFieldMapper.NAME, NumberFieldMapper.NumberType.LONG);
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Measurement;
 */  
/**
                case 'L' -> {
    /** Mirrors what {@code FieldCapabilityAssigner.assign} does at mapping build time. */
import org.openjdk.jmh.annotations.Mode;
import org.opensearch.index.engine.dataformat.DataFormat;
    private MappedFieldType idType;
            .filter(ftc -> ftc.fieldType().equals(fieldType.typeName()))  
                if (ft.isMultiValued() == false && ft.isMultiValueSupported() && input.getFieldCount(ft.name()) > 0) {
        assignCapabilities(versionType);
import org.openjdk.jmh.annotations.State;
                    fieldTypes[i] = new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.LONG);  
                // ParametrizedFieldMapper#addFieldForPluggableFormat, AUTO state, scalar so far.  
        for (int i = 0; i < fieldTypes.length; i++) {  
public class DocumentInputCollectBenchmark {
            if (isKeyword[i] && preCheck) {
        input.setRowId(DocumentInput.ROW_ID_FIELD, rowId++);
     * One full document: a fresh input (the engine calls {@code newDocumentInput()} per document),  
        // Same construction the parquet unit tests use for the engine-populated metadata fields.
import org.openjdk.jmh.annotations.Warmup;
 * 19 integer, 6 long, 4 date, in the real column order), plus the four metadata fields.
            .stream()
            switch (CLICKBENCH_COLUMN_SHAPE.charAt(i)) {
    public void setup() {
import org.opensearch.parquet.writer.ParquetDocumentInput;  
        ParquetDocumentInput input = new ParquetDocumentInput();
    private static void assignCapabilities(MappedFieldType fieldType) {  
    /**
import org.opensearch.index.mapper.MappedFieldType;  
                    fieldTypes[i] = new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.SHORT);
import org.opensearch.index.mapper.IdFieldMapper;
 * <p>Run with:
                    // convenience constructor leaves the flag unset, so mirror the builder path here.
 * SPDX-License-Identifier: Apache-2.0
        }
@OutputTimeUnit(TimeUnit.NANOSECONDS)
import org.openjdk.jmh.annotations.OutputTimeUnit;  
                }
import org.opensearch.index.engine.dataformat.DocumentInput;
import org.opensearch.index.mapper.DateFieldMapper;  
    @Benchmark  
                    values[i] = (short) i;
        for (int i = 0; i < n; i++) {  
    /** Whether to run the mapper's promotion pre-check ({@code getFieldCount}) before each keyword value. */
 */  
 * {@link DocumentInput#getFieldCount(String)} whether the field was already seen (to decide on  
 *  
            .ifPresent(ftc -> fieldType.setCapabilityMap(Map.of(PARQUET, ftc.capabilities())));
            String name = "c" + i;
        int n = CLICKBENCH_COLUMN_SHAPE.length();
 * {@code preCheck} param toggles that call so its cost can be isolated from the plain collect path.
                }  
    private long rowId;
import org.opensearch.index.mapper.KeywordFieldMapper;
                    fieldTypes[i] = keyword;
@Measurement(iterations = 5, time = 5, timeUnit = TimeUnit.SECONDS)  
 * {@code ParametrizedFieldMapper#addFieldForPluggableFormat} first asks
import org.openjdk.jmh.annotations.BenchmarkMode;
    @Param({ "true", "false" })
    private Object[] values;
 * ./gradlew -Dsandbox.enabled=true :sandbox:plugins:parquet-data-format:benchmarks:run \  
                    throw new IllegalStateException("unexpected duplicate on scalar workload");
    private static final String CLICKBENCH_COLUMN_SHAPE =
            MappedFieldType ft = fieldTypes[i];
     */
                case 'D' -> {  
                    keyword.setMultiValueSupported(true);
            }
 * this file be licensed under the Apache-2.0 license or a
        input.addField(seqNoType, rowId);
import org.opensearch.parquet.engine.ParquetDataFormat;
import org.opensearch.index.mapper.VersionFieldMapper;  
            input.addField(ft, values[i]);
        fieldTypes = new MappedFieldType[n];  
