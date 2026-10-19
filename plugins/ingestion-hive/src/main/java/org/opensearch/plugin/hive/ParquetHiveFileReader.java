        rowsRemainingInGroup--;
     * @param hadoopConf Hadoop configuration for filesystem access
import java.util.LinkedHashMap;
     */  
import java.math.BigDecimal;  
     *
    @Override  
        GroupType schema = record.getType();
                } else {
        }
import java.io.IOException;
import java.util.ArrayList;
        return groupToMap(record);  
     * Converts a Parquet Group (one row) to a Map of column name -> value.  
    private static MessageType resolveProjection(MessageType requested, MessageType fileSchema) {
            // This handles schema evolution: missing columns become null, extra columns are ignored.
        }  
     *   - repetitionCount > 1: repeated field (Hive ARRAY) -> List of values
        return switch (schema.getType(fieldIndex).asPrimitiveType().getPrimitiveTypeName()) {
    /**  
import org.apache.parquet.hadoop.ParquetFileReader;  
        // Parquet files are divided into row groups. When the current row group is exhausted,  
            case INT32 -> {  
        }
import org.apache.parquet.schema.GroupType;
    @Override
            if (schema.getType(i).isPrimitive()) {
                    List<Object> values = new ArrayList<>();
        for (int i = 0; i < schema.getFieldCount(); i++) {  
            } else {
    }  
        } finally {
                    yield record.getString(fieldIndex, valueIndex);
                row.put(fieldName, null);
                continue;
    private final ParquetFileReader reader;
                if (annotation instanceof LogicalTypeAnnotation.DecimalLogicalTypeAnnotation decimal) {
    private long rowsRemainingInGroup;
     * requested (Metastore-derived) schema, but for columns present in the file the file's own
            } else {  
    public ParquetHiveFileReader(String filePath, Configuration hadoopConf, MessageType requestedSchema) throws IOException {
    /**
import org.apache.parquet.hadoop.util.HadoopInputFile;
import org.apache.parquet.io.ColumnIOFactory;
        return builder.named(requested.getName());
            case INT96 -> record.getValueToString(fieldIndex, valueIndex);  
            }
    }
                    yield BigDecimal.valueOf(record.getInteger(fieldIndex, valueIndex), decimal.getScale());
package org.opensearch.plugin.hive;
                builder.addField(fileSchema.getType(field.getName()));
                        values.add(readPrimitiveValueAt(record, schema, i, r));
            this.reader = ParquetFileReader.open(HadoopInputFile.fromPath(new Path(filePath), hadoopConf));  
     * Builds the effective projection schema for this file. Column selection comes from the  
 * this file be licensed under the Apache-2.0 license or a
        return group.toString();
                if (repetitionCount == 1) {
                }
        Map<String, Object> row = new LinkedHashMap<>();
import org.apache.parquet.io.MessageColumnIO;  
public class ParquetHiveFileReader implements HiveFileReader {
                yield Base64.getEncoder().encodeToString(record.getBinary(fieldIndex, valueIndex).getBytes());
        this.rowsRemainingInGroup = 0;
        // Read one row from the current row group and convert to a Map  
import org.apache.parquet.example.data.Group;
        this.projectionSchema = resolveProjection(requestedSchema, reader.getFooter().getFileMetaData().getSchema());
/**
    }
                if (repetitionCount == 1) {
import org.apache.parquet.column.page.PageReadStore;  
 * The OpenSearch Contributors require contributions made to  
                yield record.getInteger(fieldIndex, valueIndex);
     *   - repetitionCount == 0: field is absent in this row -> null
     * @param requestedSchema the schema to project (from Metastore table definition)
        return readPrimitiveValueAt(record, schema, fieldIndex, 0);
        // advance to the next one. If no more row groups exist, the file is fully read.
        ClassLoader original = Thread.currentThread().getContextClassLoader();  
            recordReader = columnIO.getRecordReader(rowGroup, new GroupRecordConverter(projectionSchema));
    }  
}  
            if (rowGroup == null) {
import java.util.Base64;  
                if (annotation instanceof LogicalTypeAnnotation.StringLogicalTypeAnnotation) {  
            }  
                }  
            case BINARY, FIXED_LEN_BYTE_ARRAY -> {
 * Reads rows from a Parquet file, returning each row as a map of column names to values.  
            }
     * Opens a Parquet file for reading.
            case BOOLEAN -> record.getBoolean(fieldIndex, valueIndex);
import org.apache.parquet.io.RecordReader;
    private RecordReader<Group> recordReader;  
        try {
        Group record = recordReader.read();
import java.util.Map;  
import java.util.List;
                }  
     */
     * keep the requested type and read as null.
                    }
 * SPDX-License-Identifier: Apache-2.0
import org.apache.parquet.schema.LogicalTypeAnnotation;  
import org.apache.hadoop.conf.Configuration;
                    }
     * INT32, INT64, BINARY, or FIXED_LEN_BYTE_ARRAY), and a projection type that disagrees with  
        LogicalTypeAnnotation annotation = schema.getType(fieldIndex).getLogicalTypeAnnotation();  
                builder.addField(field);
     */
                        values.add(groupToString(record.getGroup(i, r)));  
        Types.MessageTypeBuilder builder = Types.buildMessage();
import org.apache.parquet.schema.Type;
                }  
import org.apache.parquet.schema.MessageType;
            String fieldName = schema.getFieldName(i);
                    yield new BigDecimal(new BigInteger(record.getBinary(fieldIndex, valueIndex).getBytes()), decimal.getScale());
        };
            MessageColumnIO columnIO = new ColumnIOFactory().getColumnIO(projectionSchema, fileSchema);
    private Object readPrimitiveValue(Group record, GroupType schema, int fieldIndex) {
    }  
        }  
            case FLOAT -> record.getFloat(fieldIndex, valueIndex);  
            }
            rowsRemainingInGroup = rowGroup.getRowCount();  
                } else {  
     * @throws IOException if the file cannot be opened  
                if (annotation instanceof LogicalTypeAnnotation.DecimalLogicalTypeAnnotation decimal) {
    private Object readPrimitiveValueAt(Group record, GroupType schema, int fieldIndex, int valueIndex) {
        for (Type field : requested.getFields()) {  
                return null; // End of file
import org.apache.parquet.example.data.simple.convert.GroupRecordConverter;
                    List<Object> values = new ArrayList<>();
                // Non-primitive (nested struct/group): serialize to string representation  
     * type is used. Physical types for the same Hive type vary by writer (e.g., decimal may be
            if (fileSchema.containsField(field.getName())) {
                    yield BigDecimal.valueOf(record.getLong(fieldIndex, valueIndex), decimal.getScale());
                    row.put(fieldName, groupToString(record.getGroup(i, 0)));
            int repetitionCount = record.getFieldRepetitionCount(i);
                yield record.getLong(fieldIndex, valueIndex);
    }
                    row.put(fieldName, values);  
                }  
                    // Binary-backed decimal stores the unscaled value as big-endian two's complement
     * the file's type fails in ColumnIOFactory. Columns missing from the file (schema evolution)
                    row.put(fieldName, values);
    /**
                }
    private Map<String, Object> groupToMap(Group record) {  
import org.apache.parquet.schema.Types;  
 * compatible open source license.
                    row.put(fieldName, readPrimitiveValue(record, schema, i));  
            Thread.currentThread().setContextClassLoader(ParquetHiveFileReader.class.getClassLoader());
    public void close() throws IOException {
    private String groupToString(Group group) {  
 */
/*  
            }
    private final MessageType projectionSchema;
 *
        return row;  
     * @param filePath the path to the Parquet file  
        if (recordReader == null || rowsRemainingInGroup <= 0) {
                    for (int r = 0; r < repetitionCount; r++) {
 */  
     *   - repetitionCount == 1: single value (most common)  
            case DOUBLE -> record.getDouble(fieldIndex, valueIndex);
            }
import java.math.BigInteger;
        reader.close();
            }  
    }
            MessageType fileSchema = reader.getFooter().getFileMetaData().getSchema();  
                if (annotation instanceof LogicalTypeAnnotation.DecimalLogicalTypeAnnotation decimal) {  
            Thread.currentThread().setContextClassLoader(original);
import org.apache.hadoop.fs.Path;
            PageReadStore rowGroup = reader.readNextRowGroup();  
            if (repetitionCount == 0) {  
    }
            // Build a record reader that maps file columns to the projection schema.
     * Handles three cases per field:
    public Map<String, Object> readNext() throws IOException {
            case INT64 -> {  
                    for (int r = 0; r < repetitionCount; r++) {  
