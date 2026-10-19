import org.opensearch.index.mapper.KeywordFieldMapper;  
                return new BooleanFieldMapper.BooleanFieldType(name);  
 * Builds a stubbed {@link MapperService} from a golden file's {@code indexMapping}
    private static MappedFieldType toFieldType(String name, String sqlType) {
                return new DateFieldMapper.DateFieldType(name);
import java.util.HashMap;
}  
            case "BOOLEAN":
package org.opensearch.dsl.golden;
    public static Supplier<MapperService> fromSqlMapping(Map<String, String> indexMapping) {  
 */  
     * Creates a MapperService supplier whose {@code fieldType(name)} resolves each mapped  
        when(mapperService.fieldType(anyString())).thenAnswer(invocation -> fieldTypes.get(invocation.<String>getArgument(0)));  
        Map<String, MappedFieldType> fieldTypes = new HashMap<>();
import static org.mockito.Mockito.when;
import org.opensearch.index.mapper.MapperService;
/*  
 * this file be licensed under the Apache-2.0 license or a
     * @param indexMapping field name → SQL type name, as in golden files
                if (sqlType.startsWith("SCALED_FLOAT")) {  
     *  
    }
            case "DOUBLE":
     */
        for (Map.Entry<String, String> entry : indexMapping.entrySet()) {
     * resolve to null.
import java.util.function.Supplier;
import org.opensearch.index.mapper.BooleanFieldMapper;
        return () -> mapperService;
import static org.mockito.Mockito.mock;
import org.opensearch.index.mapper.DateFieldMapper;
 * compatible open source license.
            case "DATE":
                }
public final class TestMapperServices {
 */  
            case "TIMESTAMP":
import java.util.Map;  
                return new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.LONG);  
 * as production resolves them through the real index mapping.
            fieldTypes.put(entry.getKey(), toFieldType(entry.getKey(), entry.getValue()));  
                return new KeywordFieldMapper.KeywordFieldType(name);
        switch (sqlType) {
            default:
import static org.mockito.ArgumentMatchers.anyString;  
    private TestMapperServices() {}  
            case "UNSIGNED_LONG":
        }
        }
 * from the same map. Terms rendering resolves key types and formats through it exactly
import org.opensearch.index.mapper.MappedFieldType;
 *
 * The OpenSearch Contributors require contributions made to  
                return new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.FLOAT);
 * SPDX-License-Identifier: Apache-2.0
     * field to the {@link MappedFieldType} matching its golden SQL type; unmapped names
            case "BIGINT":
/**
            case "TIMESTAMP_NANOS":  
        MapperService mapperService = mock(MapperService.class);
            case "VARCHAR":  
                    return new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.DOUBLE);
            case "INTEGER":
                return new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.INTEGER);  
                return new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.DOUBLE);
            case "FLOAT":  
                return new KeywordFieldMapper.KeywordFieldType(name);  
import org.opensearch.index.mapper.NumberFieldMapper;  
    /**
    }
 * (field name → SQL type name), mirroring how {@link CalciteTestInfra} builds the schema  
