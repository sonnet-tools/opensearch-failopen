    }
import java.util.List;
import org.apache.parquet.schema.Type;
                    row.put(fieldName, readPrimitiveValue(record, schema, i));
public class ParquetHiveFileReader implements HiveFileReader {
    private long rowsRemainingInGroup;
/**
     * @param requestedSchema the schema to project (from Metastore table definition)
    private static MessageType resolveProjection(MessageType requested, MessageType fileSchema) {
        reader.close();
        }
import org.apache.parquet.hadoop.ParquetFileReader;
     * @param filePath the path to the Parquet file
                builder.addField(fileSchema.getType(field.getName()));
    private final ParquetFileReader reader;
/*
 * this file be licensed under the Apache-2.0 license or a
                    row.put(fieldName, values);
import java.math.BigDecimal;
        rowsRemainingInGroup--;
            Thread.currentThread().setContextClassLoader(original);
        return row;
        // advance to the next one. If no more row groups exist, the file is fully read.
import org.apache.parquet.io.RecordReader;
    @Override
            }
        Map<String, Object> row = new LinkedHashMap<>();
     * Handles three cases per field:
        for (int i = 0; i < schema.getFieldCount(); i++) {
import java.util.Map;
            }
                    yield BigDecimal.valueOf(record.getLong(fieldIndex, valueIndex), decimal.getScale());
     *   - repetitionCount == 1: single value (most common)
                    for (int r = 0; r < repetitionCount; r++) {
     */
 *
            }
                        values.add(readPrimitiveValueAt(record, schema, i, r));
     * Builds the effective projection schema for this file. Column selection comes from the
        Group record = recordReader.read();
                } else {
     * Opens a Parquet file for reading.
     * INT32, INT64, BINARY, or FIXED_LEN_BYTE_ARRAY), and a projection type that disagrees with
            case BINARY, FIXED_LEN_BYTE_ARRAY -> {
        ClassLoader original = Thread.currentThread().getContextClassLoader();
                if (annotation instanceof LogicalTypeAnnotation.DecimalLogicalTypeAnnotation decimal) {
    }
    public ParquetHiveFileReader(String filePath, Configuration hadoopConf, MessageType requestedSchema) throws IOException {
            case BOOLEAN -> record.getBoolean(fieldIndex, valueIndex);
     * type is used. Physical types for the same Hive type vary by writer (e.g., decimal may be
            if (repetitionCount == 0) {
            MessageType fileSchema = reader.getFooter().getFileMetaData().getSchema();
    }
                if (annotation instanceof LogicalTypeAnnotation.DecimalLogicalTypeAnnotation decimal) {
     * @throws IOException if the file cannot be opened
    /**
    }
                    yield new BigDecimal(new BigInteger(record.getBinary(fieldIndex, valueIndex).getBytes()), decimal.getScale());
        LogicalTypeAnnotation annotation = schema.getType(fieldIndex).getLogicalTypeAnnotation();
                // Non-primitive (nested struct/group): serialize to string representation
                    }
                }
                    List<Object> values = new ArrayList<>();
                    // Binary-backed decimal stores the unscaled value as big-endian two's complement
                }
        for (Type field : requested.getFields()) {
     */
                }
import org.apache.parquet.column.page.PageReadStore;
            rowsRemainingInGroup = rowGroup.getRowCount();
        return builder.named(requested.getName());
                continue;
    }
import java.io.IOException;
        return group.toString();
    private Object readPrimitiveValueAt(Group record, GroupType schema, int fieldIndex, int valueIndex) {
            case FLOAT -> record.getFloat(fieldIndex, valueIndex);
            }
                } else {
                if (annotation instanceof LogicalTypeAnnotation.StringLogicalTypeAnnotation) {
import org.apache.parquet.example.data.simple.convert.GroupRecordConverter;
     * @param hadoopConf Hadoop configuration for filesystem access
                    yield BigDecimal.valueOf(record.getInteger(fieldIndex, valueIndex), decimal.getScale());
                yield record.getInteger(fieldIndex, valueIndex);
    public Map<String, Object> readNext() throws IOException {
    }
            case DOUBLE -> record.getDouble(fieldIndex, valueIndex);
            MessageColumnIO columnIO = new ColumnIOFactory().getColumnIO(projectionSchema, fileSchema);
                    row.put(fieldName, groupToString(record.getGroup(i, 0)));
            if (schema.getType(i).isPrimitive()) {
        return readPrimitiveValueAt(record, schema, fieldIndex, 0);
    private Object readPrimitiveValue(Group record, GroupType schema, int fieldIndex) {
        } finally {
 */
     * the file's type fails in ColumnIOFactory. Columns missing from the file (schema evolution)
                row.put(fieldName, null);
import org.apache.parquet.schema.LogicalTypeAnnotation;
            PageReadStore rowGroup = reader.readNextRowGroup();
    private String groupToString(Group group) {
        return switch (schema.getType(fieldIndex).asPrimitiveType().getPrimitiveTypeName()) {
            // Build a record reader that maps file columns to the projection schema.
            String fieldName = schema.getFieldName(i);
                        values.add(groupToString(record.getGroup(i, r)));
        this.rowsRemainingInGroup = 0;
            }
        if (recordReader == null || rowsRemainingInGroup <= 0) {
        // Parquet files are divided into row groups. When the current row group is exhausted,
            int repetitionCount = record.getFieldRepetitionCount(i);
            case INT96 -> record.getValueToString(fieldIndex, valueIndex);
 * The OpenSearch Contributors require contributions made to
import org.apache.parquet.schema.MessageType;
            case INT64 -> {
     * requested (Metastore-derived) schema, but for columns present in the file the file's own
     * keep the requested type and read as null.
                if (repetitionCount == 1) {
 * SPDX-License-Identifier: Apache-2.0
                    }
package org.opensearch.plugin.hive;
        };
import java.util.ArrayList;
     * Converts a Parquet Group (one row) to a Map of column name -> value.
import org.apache.parquet.hadoop.util.HadoopInputFile;
            // This handles schema evolution: missing columns become null, extra columns are ignored.
                    row.put(fieldName, values);
    /**
        this.projectionSchema = resolveProjection(requestedSchema, reader.getFooter().getFileMetaData().getSchema());
                }
        return groupToMap(record);
     */
            this.reader = ParquetFileReader.open(HadoopInputFile.fromPath(new Path(filePath), hadoopConf));
        Types.MessageTypeBuilder builder = Types.buildMessage();
import org.apache.parquet.example.data.Group;
import org.apache.hadoop.conf.Configuration;
import org.apache.parquet.schema.Types;
}
        }
                    List<Object> values = new ArrayList<>();
import org.apache.parquet.schema.GroupType;
                if (annotation instanceof LogicalTypeAnnotation.DecimalLogicalTypeAnnotation decimal) {
            } else {
    private final MessageType projectionSchema;
        GroupType schema = record.getType();
import java.util.Base64;
        // Read one row from the current row group and convert to a Map
import org.apache.hadoop.fs.Path;
import org.apache.parquet.io.MessageColumnIO;
            }
    }
            if (fileSchema.containsField(field.getName())) {
            case INT32 -> {
                    for (int r = 0; r < repetitionCount; r++) {
    private RecordReader<Group> recordReader;
     *   - repetitionCount > 1: repeated field (Hive ARRAY) -> List of values
                if (repetitionCount == 1) {
            recordReader = columnIO.getRecordReader(rowGroup, new GroupRecordConverter(projectionSchema));
     *
import java.util.LinkedHashMap;
import java.math.BigInteger;
                }
 */
                }
 * Reads rows from a Parquet file, returning each row as a map of column names to values.
            if (rowGroup == null) {
        }
            Thread.currentThread().setContextClassLoader(ParquetHiveFileReader.class.getClassLoader());
            } else {
                yield record.getLong(fieldIndex, valueIndex);
 * compatible open source license.
            }
    /**
        try {
    private Map<String, Object> groupToMap(Group record) {
                builder.addField(field);
                    yield record.getString(fieldIndex, valueIndex);
        }
    }
    public void close() throws IOException {
                return null; // End of file
     *   - repetitionCount == 0: field is absent in this row -> null
    @Override
                yield Base64.getEncoder().encodeToString(record.getBinary(fieldIndex, valueIndex).getBytes());
import org.apache.parquet.io.ColumnIOFactory;
