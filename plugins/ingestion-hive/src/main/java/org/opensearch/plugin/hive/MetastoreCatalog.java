    /**  
            this.columns = columns;
import java.util.List;  
     * Reconnects to the catalog after a connection failure.
     * @param filter the partition filter expression  
        private final int createTime;  
     * @param table the table name
 * compatible open source license.
        public String getType() {
 *
     *  
     *
        private final List<String> values;
        }  
     */
            return partitionKeys;
            this.values = values;  
    void connect() throws IOException;
    }
     * Returns all partitions for a table.
            return location;
     * Returns partitions matching a filter expression.
        }
/*  
        }  
        }  
    /**  
        }
     * @throws IOException if the partitions cannot be retrieved  
     * @throws IOException if the reconnection fails
        }
        private final String type;
            return values;  
     * @throws IOException if the partitions cannot be retrieved
 * The OpenSearch Contributors require contributions made to  
    }
     */
     */  
     *
/**
import java.io.IOException;
     * @return the table metadata
}
    class TableInfo {  
    /**
    List<PartitionInfo> getAllPartitions(String database, String table) throws IOException;
    }
    /**  
            this.location = location;
 * SPDX-License-Identifier: Apache-2.0
    /**
        }
    /**
            return createTime;
     * @param database the database name  
     */
 * support AWS Glue Data Catalog or other Hive-compatible catalogs.
     * @throws IOException if the connection cannot be established  
    class ColumnInfo {  
 */  
        public String getName() {  
        public String getInputFormat() {
        }  
     */
        public List<ColumnInfo> getColumns() {
     * @param table the table name
     * Returns table metadata including schema, input format, and partition keys.  
     */
     * Table metadata returned by the catalog.
        public String getLocation() {  
            this.inputFormat = inputFormat;  
    class PartitionInfo {  
        private final String name;
            this.name = name;
     */  
        private final List<String> partitionKeys;
        private final List<ColumnInfo> columns;  
            return columns;
        public int getCreateTime() {
        private final String location;
        }
     * Column metadata.
     * @return list of matching partitions
 * Currently implemented for Hive Metastore via Thrift. Future implementations could
     *
    /**  
            this.type = type;  
    List<PartitionInfo> getPartitionsByFilter(String database, String table, String filter) throws IOException;
        }  
        private final String inputFormat;
     * @param database the database name
 */  
     *  
            return type;
 * Abstraction for accessing table metadata and partition information from a catalog.  
            return inputFormat;  
import java.io.Closeable;
     * Connects to the catalog. Must be called before any other method.
            this.createTime = createTime;
     * @throws IOException if the metadata cannot be retrieved
     * Partition metadata returned by the catalog.
     */
        public List<String> getValues() {
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.plugin.hive;
            this.partitionKeys = partitionKeys;
     * @param table the table name  
    TableInfo getTableInfo(String database, String table) throws IOException;
     * @param database the database name
    /**  
     * @return list of partitions
        public List<String> getPartitionKeys() {  
public interface MetastoreCatalog extends Closeable {
        public PartitionInfo(List<String> values, String location, int createTime) {
        public TableInfo(String inputFormat, List<String> partitionKeys, List<ColumnInfo> columns) {
        public ColumnInfo(String name, String type) {
    void reconnect() throws IOException;  
        }
            return name;
