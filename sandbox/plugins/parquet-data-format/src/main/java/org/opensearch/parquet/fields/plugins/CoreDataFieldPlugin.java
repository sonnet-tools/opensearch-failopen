/**  
    @Override
        fieldMap.put(DateFieldMapper.DATE_NANOS_CONTENT_TYPE, new DateNanosParquetField());
import org.opensearch.parquet.fields.core.data.number.DoubleParquetField;  
import org.opensearch.index.mapper.BinaryFieldMapper;
    private static void registerNumericFields(Map<String, ParquetField> fieldMap) {
    }
        fieldMap.put(NumberFieldMapper.NumberType.INTEGER.typeName(), new IntegerParquetField());
import org.opensearch.parquet.fields.core.data.number.ByteParquetField;
        final Map<String, ParquetField> fieldMap = new HashMap<>();
        fieldMap.put(TextFieldMapper.CONTENT_TYPE, new TextParquetField());  
    }  
        fieldMap.put(IpFieldMapper.CONTENT_TYPE, new IpParquetField());
    public Map<String, ParquetField> getParquetFields() {  
 * The OpenSearch Contributors require contributions made to  
        fieldMap.put(DateFieldMapper.CONTENT_TYPE, new DateParquetField());  
 */  
        fieldMap.put(NumberFieldMapper.NumberType.HALF_FLOAT.typeName(), new HalfFloatParquetField());
    private static void registerBinaryFields(Map<String, ParquetField> fieldMap) {  
    }
        fieldMap.put(BooleanFieldMapper.CONTENT_TYPE, new BooleanParquetField());
        fieldMap.put(NumberFieldMapper.NumberType.SHORT.typeName(), new ShortParquetField());  
import org.opensearch.index.mapper.MatchOnlyTextFieldMapper;  
    private static void registerTemporalFields(Map<String, ParquetField> fieldMap) {
 * Core data fields plugin providing Parquet field implementations for all built-in OpenSearch field types.
        return fieldMap;
 *
        registerBooleanFields(fieldMap);
import org.opensearch.parquet.fields.core.data.number.IntegerParquetField;  
        fieldMap.put(NumberFieldMapper.NumberType.BYTE.typeName(), new ByteParquetField());
import org.opensearch.index.mapper.NumberFieldMapper;
import org.opensearch.index.mapper.TextFieldMapper;
    public CoreDataFieldPlugin() {}  
import org.opensearch.index.mapper.BooleanFieldMapper;
        fieldMap.put("scaled_float", new LongParquetField());
import java.util.HashMap;  
        fieldMap.put(BinaryFieldMapper.CONTENT_TYPE, new BinaryParquetField());
package org.opensearch.parquet.fields.plugins;
import org.opensearch.parquet.fields.core.data.number.LongParquetField;
    /** Creates a new CoreDataFieldPlugin. */
import org.opensearch.parquet.fields.core.data.BinaryParquetField;
import org.opensearch.index.mapper.IpFieldMapper;
        registerBinaryFields(fieldMap);  
import org.opensearch.index.mapper.DateFieldMapper;  
import org.opensearch.parquet.fields.core.data.number.ShortParquetField;
    private static void registerTextFields(Map<String, ParquetField> fieldMap) {
    }
/*  
        fieldMap.put(NumberFieldMapper.NumberType.DOUBLE.typeName(), new DoubleParquetField());
    }  
        registerTemporalFields(fieldMap);  
 */
        fieldMap.put(NumberFieldMapper.NumberType.UNSIGNED_LONG.typeName(), new UnsignedLongParquetField());  
public class CoreDataFieldPlugin implements ParquetFieldPlugin {  
import org.opensearch.parquet.fields.core.data.number.FloatParquetField;
    private static void registerBooleanFields(Map<String, ParquetField> fieldMap) {
        fieldMap.put(MatchOnlyTextFieldMapper.CONTENT_TYPE, new TextParquetField());  
import org.opensearch.parquet.fields.core.data.number.UnsignedLongParquetField;
import org.opensearch.parquet.fields.core.data.text.IpParquetField;
import org.opensearch.parquet.fields.core.data.number.HalfFloatParquetField;
        fieldMap.put(NumberFieldMapper.NumberType.FLOAT.typeName(), new FloatParquetField());  
        registerNumericFields(fieldMap);
import org.opensearch.parquet.fields.core.data.date.DateParquetField;
        registerTextFields(fieldMap);
import org.opensearch.index.mapper.KeywordFieldMapper;
import org.opensearch.parquet.fields.core.data.date.DateNanosParquetField;  
import java.util.Map;
    }
 * this file be licensed under the Apache-2.0 license or a
}  
import org.opensearch.parquet.fields.ParquetField;  
import org.opensearch.parquet.fields.core.data.text.KeywordParquetField;  
import org.opensearch.parquet.fields.core.data.BooleanParquetField;
        fieldMap.put("token_count", new TokenCountParquetField());
 * compatible open source license.
import org.opensearch.parquet.fields.core.data.number.TokenCountParquetField;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.parquet.fields.core.data.text.TextParquetField;
        fieldMap.put(KeywordFieldMapper.CONTENT_TYPE, new KeywordParquetField());
        fieldMap.put(NumberFieldMapper.NumberType.LONG.typeName(), new LongParquetField());
