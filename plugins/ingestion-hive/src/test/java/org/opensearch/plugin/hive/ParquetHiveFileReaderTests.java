@SuppressForbidden(reason = "Parquet APIs require java.io.File")
            return t.getName().contains("StatisticsDataReferenceCleaner");
            assertTrue(row.containsKey("added_later"));
 * compatible open source license.
            "message table {\n  optional int32 id;\n  optional binary added_later (UTF8);\n}"
            return g;
            Map<String, Object> row = reader.readNext();
              optional float ratio;
            assertEquals(new BigDecimal("123.45"), row.get("amount"));
            assertEquals(7, row.get("id"));
            g.append("name", "bob");
            assertEquals(new BigDecimal("123.45"), row.get("amount"));
import org.apache.parquet.schema.MessageTypeParser;
            }""");
    }
        }
            assertEquals(new BigDecimal("123.45"), row.get("amount"));
import java.util.Map;
            assertEquals(9.99, (double) row.get("score"), 0.001);
    private Configuration hadoopConf;
        }
        try (ParquetHiveFileReader reader = new ParquetHiveFileReader(file.getAbsolutePath(), hadoopConf, schema)) {
        try (ParquetHiveFileReader reader = new ParquetHiveFileReader(file.getAbsolutePath(), hadoopConf, schema)) {
            assertNull(reader.readNext());
    }
              optional int32 count;
            g.append("flag", true);
    public static final class HadoopThreadLeakFilter implements ThreadFilter {
public class ParquetHiveFileReaderTests extends OpenSearchTestCase {
            return groups;
    }
            g.append("total", 1000L);
        Group[] create(SimpleGroupFactory factory);
        }
    }
package org.opensearch.plugin.hive;
 * this file be licensed under the Apache-2.0 license or a
        File file = writeParquet(schema, factory -> {
    }
        hadoopConf.set("fs.file.impl", "org.apache.hadoop.fs.LocalFileSystem");
            // Only set name, leave age null
            Group g = factory.newGroup();
            }
            g.append("tag", "b");
            for (int i = 0; i < 3; i++) {
    public void testReadBinaryNonString() throws IOException {
        try (ParquetHiveFileReader reader = new ParquetHiveFileReader(file.getAbsolutePath(), hadoopConf, schema)) {
            assertTrue(tags instanceof List);
            Object tags = row.get("tag");
import org.apache.parquet.hadoop.ParquetWriter;
        hadoopConf = new Configuration();
        MessageType schema = MessageTypeParser.parseMessageType("message test {\n  optional binary name (UTF8);\n  optional int32 age;\n}");
                Map<String, Object> row = reader.readNext();
            g.append("tag", "c");
@ThreadLeakFilters(filters = ParquetHiveFileReaderTests.HadoopThreadLeakFilter.class)
        File file = writeParquet(schema, factory -> {
        });
        File file = getTestParquetPath().toFile();
import org.apache.parquet.example.data.simple.SimpleGroupFactory;
                groups[i] = factory.newGroup().append("id", i);
 */
            Map<String, Object> row = reader.readNext();
            assertNotNull(row);
            Map<String, Object> row = reader.readNext();
 * The OpenSearch Contributors require contributions made to
import org.apache.parquet.hadoop.example.ExampleParquetWriter;
            Group g = factory.newGroup();
            for (Group g : groupFactory.create(factory)) {
            return g;
    interface MultiGroupFactory {
import com.carrotsearch.randomizedtesting.ThreadFilter;
    private File writeParquetMultiple(MessageType schema, MultiGroupFactory groupFactory) throws IOException {
    }
            byte[] decoded = java.util.Base64.getDecoder().decode(encoded);
    public void testProjectionMissingColumnReturnsNull() throws IOException {
            return g;
 * SPDX-License-Identifier: Apache-2.0
        File file = writeParquet(schema, factory -> {
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
    @Override
            assertEquals(new BigDecimal("123.45"), row.get("amount"));
        }
        File file = writeParquet(fileSchema, factory -> factory.newGroup().append("id", 7));
            g.append("amount", Binary.fromConstantByteArray(BigInteger.valueOf(12345).toByteArray()));
        org.apache.parquet.io.OutputFile outputFile = new org.apache.parquet.io.LocalOutputFile(file.toPath());
        MessageType schema = MessageTypeParser.parseMessageType("message test {\n  optional int32 id;\n}");
            // Unscaled value 12345 with scale 2 represents 123.45
            assertNotNull(row);
import java.math.BigInteger;
import java.math.BigDecimal;
import org.opensearch.common.SuppressForbidden;
            assertNull(row.get("age"));
    }
        }
            assertEquals("bob", row.get("name"));
              optional boolean flag;
        File file = writeParquet(schema, factory -> factory.newGroup().append("amount", 12345));
        File file = writeParquet(schema, factory -> {
            assertNotNull(row);
        File file = writeParquet(schema, factory -> {
              optional double score;
        );
            assertNotNull(row);
        // The reader must adopt the file's physical type instead of failing on the mismatch.
            Group g = factory.newGroup();
        MessageType schema = MessageTypeParser.parseMessageType("message test {\n  optional int32 amount (DECIMAL(9,2));\n}");
        Group create(SimpleGroupFactory factory);
    interface GroupFactory {
              optional binary name (UTF8);
    public void testReadPrimitiveTypes() throws IOException {
        return createTempDir().resolve("test.parquet");
            writer.write(groupFactory.create(factory));
            assertNotNull(row);
 *
        MessageType schema = MessageTypeParser.parseMessageType("message test {\n  optional int64 amount (DECIMAL(18,2));\n}");
    public void testProjectionUsesFileTypeWhenPhysicalTypeDiffers() throws IOException {
        org.apache.parquet.io.OutputFile outputFile = new org.apache.parquet.io.LocalOutputFile(file.toPath());
        public boolean reject(Thread t) {
        MessageType schema = MessageTypeParser.parseMessageType("message test {\n  optional binary data;\n}");
        try (ParquetHiveFileReader reader = new ParquetHiveFileReader(file.getAbsolutePath(), hadoopConf, requestedSchema)) {
            assertNotNull(row);
    public void testReadDecimalInt64Backed() throws IOException {
        });
        }
            assertEquals(3.14f, (float) row.get("ratio"), 0.001f);
import java.io.File;
            }
    public void testReadNullValues() throws IOException {
        MessageType schema = MessageTypeParser.parseMessageType("""
    public void testReadDecimalBinaryBacked() throws IOException {
            assertNotNull(row);
        }
    }
            Map<String, Object> row = reader.readNext();
            g.append("data", Binary.fromConstantByteArray(new byte[] { 0x01, 0x02, 0x03 }));
        MessageType schema = MessageTypeParser.parseMessageType("message test {\n  optional binary amount (DECIMAL(10,2));\n}");
        SimpleGroupFactory factory = new SimpleGroupFactory(schema);
        try (ParquetHiveFileReader reader = new ParquetHiveFileReader(file.getAbsolutePath(), hadoopConf, schema)) {
        SimpleGroupFactory factory = new SimpleGroupFactory(schema);
                assertEquals(i, row.get("id"));
            return g;
            assertNull(reader.readNext());
        return file;
    }
    }
        }
import java.util.List;
        });
            assertNull(row.get("added_later"));
    }
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
    private File writeParquet(MessageType schema, GroupFactory groupFactory) throws IOException {
    }
        }
        }
            // Non-string BINARY should be Base64 encoded
    public void testReadRepeatedPrimitive() throws IOException {
            Group g = factory.newGroup();
        MessageType fileSchema = MessageTypeParser.parseMessageType("message test {\n  optional int64 amount (DECIMAL(18,2));\n}");
            Map<String, Object> row = reader.readNext();
        File file = writeParquet(fileSchema, factory -> factory.newGroup().append("amount", 12345L));
        MessageType fileSchema = MessageTypeParser.parseMessageType("message test {\n  optional int32 id;\n}");
            assertNotNull(row);
}
    }
        super.setUp();
        MessageType schema = MessageTypeParser.parseMessageType("message test {\n  repeated binary tag (UTF8);\n}");
import org.opensearch.test.OpenSearchTestCase;
            assertEquals("alice", row.get("name"));
        });
import org.apache.parquet.example.data.Group;
    public void testReadMultipleRows() throws IOException {
        try (ParquetHiveFileReader reader = new ParquetHiveFileReader(file.getAbsolutePath(), hadoopConf, schema)) {
                writer.write(g);
    @FunctionalInterface
            assertEquals(List.of("a", "b", "c"), tags);
            Map<String, Object> row = reader.readNext();
        try (ParquetWriter<Group> writer = ExampleParquetWriter.builder(outputFile).withType(schema).build()) {
        // File stores the decimal as int64; the Metastore-derived projection requests binary.
                assertNotNull(row);
        try (ParquetHiveFileReader reader = new ParquetHiveFileReader(file.getAbsolutePath(), hadoopConf, schema)) {
            assertNotNull(row);
            return g;
            Group[] groups = new Group[3];
            g.append("name", "alice");
            Map<String, Object> row = reader.readNext();
        });
        MessageType requestedSchema = MessageTypeParser.parseMessageType("message table {\n  optional binary amount (DECIMAL(18,2));\n}");
    public void setUp() throws Exception {
        try (ParquetHiveFileReader reader = new ParquetHiveFileReader(file.getAbsolutePath(), hadoopConf, requestedSchema)) {
            assertEquals(true, row.get("flag"));
        }
import org.apache.parquet.io.api.Binary;
    @FunctionalInterface
        return file;
            message test {
        @Override
    }
        });
        // Schema evolution: the Metastore schema has a column the file does not.
        try (ParquetHiveFileReader reader = new ParquetHiveFileReader(file.getAbsolutePath(), hadoopConf, schema)) {
            g.append("ratio", 3.14f);
        File file = getTestParquetPath().toFile();
              optional int64 total;
    }
        File file = writeParquet(schema, factory -> factory.newGroup().append("amount", 12345L));
            Group g = factory.newGroup();
/*
        try (ParquetWriter<Group> writer = ExampleParquetWriter.builder(outputFile).withType(schema).build()) {
        try (ParquetHiveFileReader reader = new ParquetHiveFileReader(file.getAbsolutePath(), hadoopConf, schema)) {
    }
            assertArrayEquals(new byte[] { 0x01, 0x02, 0x03 }, decoded);
        MessageType requestedSchema = MessageTypeParser.parseMessageType(
            }
        File file = writeParquetMultiple(schema, factory -> {
            Map<String, Object> row = reader.readNext();
        }
    }
            String encoded = (String) row.get("data");
    private java.nio.file.Path getTestParquetPath() throws IOException {
            assertEquals(1000L, row.get("total"));
            assertEquals(42, row.get("count"));
import org.apache.parquet.schema.MessageType;
            Map<String, Object> row = reader.readNext();
    public void testReadDecimalInt32Backed() throws IOException {
            g.append("count", 42);
        }
            for (int i = 0; i < 3; i++) {
            g.append("score", 9.99);
            g.append("tag", "a");
