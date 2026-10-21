import org.apache.hadoop.minikdc.MiniKdc;
import org.opensearch.index.IndexNotFoundException;
                table.setParameters(new java.util.HashMap<>());
    }
              required binary event_type (UTF8);
            SearchResponse response = client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
                || t.getName().startsWith("MiniKdc")) {
            }
    public void testKerberosIngestion() throws Exception {
 * The OpenSearch Contributors require contributions made to
        warehouseDir = createTempDir().toFile();
        conf.set("hadoop.security.authentication", "kerberos");
                .put("ingestion_source.pointer.init.reset", "earliest")
import org.opensearch.plugin.hive.metastore.SerDeInfo;
        // Wait for poller thread to terminate
                .put("ingestion_source.param.kerberos_principal", "client1@" + kdc.getRealm())
        return Collections.singletonList(HiveIngestionPlugin.class);
            message event {
                .put("ingestion_source.param.kerberos_principal", "client2@" + kdc.getRealm())
        assertBusy(() -> {
    private MiniKdc kdc;
import java.util.List;
        startMiniKdc();
                try {
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
                serDeInfo.setSerializationLib("org.apache.hadoop.hive.ql.io.parquet.serde.ParquetHiveSerDe");
 * Uses MiniKdc (in-JVM KDC) and a Hive Metastore container configured for SASL/Kerberos.
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
/**
        waitForState(() -> {
    private File keytabFile;
    }
     * Test that two indices with different Kerberos principals can ingest simultaneously
        // Register table via SASL-authenticated connection
                    partition.setSd(partSd);
                .put("ingestion_source.param.table", TABLE_NAME)
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testMultiplePrincipalsCoexist() throws Exception {
        });
@SuppressForbidden(reason = "Parquet and Hadoop APIs require java.io.File")
                .put("index.replication.type", "SEGMENT")
    private static final String TABLE_NAME = "events";
            return response.getHits().getTotalHits().value() == 450;
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        String krb5Content = java.nio.file.Files.readString(krb5Conf.toPath());
import org.apache.parquet.example.data.Group;
    private static final String DATABASE = "test_db";
            Thread[] threads = new Thread[Thread.activeCount()];
                    partition.setValues(List.of(dt));
            SearchResponse r1 = client().prepareSearch(index1).setQuery(QueryBuilders.matchAllQuery()).get();
        // on every platform, so route the KDC traffic through it.
        try (ParquetWriter<Group> writer = ExampleParquetWriter.builder(outputFile).withType(schema).build()) {
              required int64 timestamp;
 */
        while (System.currentTimeMillis() - start < TimeUnit.SECONDS.toMillis(60)) {
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<configuration>\n"
            index2,
    private String indexName = "hive-kerberos-test-index";
                "hive",
        );
                writer.write(group);
        String metastoreUri = "thrift://" + kerberizedMetastore.getHost() + ":" + kerberizedMetastore.getMappedPort(9083);
                    partSd.setCols(cols);
 *
        java.nio.file.Files.writeString(containerKrb5Conf.toPath(), krb5Content);
                .build()
            index1,
                cols.add(new FieldSchema("event_type", "string", ""));
import java.util.concurrent.Callable;
        registerTableWithKerberos(metastoreUri);
        }
                null,
            try {
        // Create first index with client1 principal
        );
        }
            for (StackTraceElement e : t.getStackTrace()) {
        kerberizedMetastore.start();
        ensureGreen(indexName);
                + "</configuration>\n"
            .withFileSystemBind(keytabFile.getAbsolutePath(), "/opt/keytabs/test.keytab", BindMode.READ_ONLY)
import org.opensearch.plugin.hive.metastore.ThriftHiveMetastore;
        File coreSiteXml = new File(warehouseDir, "core-site.xml");
                .put("ingestion_source.param.authentication", "kerberos")
            Thread.enumerate(threads);
 * this file be licensed under the Apache-2.0 license or a
                return true;
package org.opensearch.plugin.hive;
        );
            SearchResponse r2 = client().prepareSearch(index2).setQuery(QueryBuilders.matchAllQuery()).get();
        krb5Content = krb5Content.replace("localhost", "host.testcontainers.internal");
            saslTransport.open();
                cols.add(new FieldSchema("user_id", "string", ""));
        // host port exposure forwards from inside containers to host loopback ports
        File containerKrb5Conf = new File(warehouseDir, "krb5.conf");
                "GSSAPI",
            File partDir = new File(warehouseDir, DATABASE + "/" + TABLE_NAME + "/" + partition);
        public boolean reject(Thread t) {
    @Before
        File hiveSiteXml = new File(warehouseDir, "hive-site.xml");
    }
                    return true;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    protected Collection<Class<? extends Plugin>> getPlugins() {
 * SPDX-License-Identifier: Apache-2.0
 * Integration test for Hive ingestion with Kerberos authentication.
                .put("ingestion_source.param.authentication", "kerberos")
                cols.add(new FieldSchema("timestamp", "bigint", ""));
            ThriftHiveMetastore.Client client = new ThriftHiveMetastore.Client(new TBinaryProtocol(saslTransport));
                .put("ingestion_source.param.kerberos_keytab", keytabFile.getAbsolutePath())
                sd.setCols(cols);
        createIndex(
                table.setTableType("EXTERNAL_TABLE");
            indexName,
                "localhost",
@ThreadLeakFilters(filters = IngestFromHiveKerberosIT.TestContainerThreadLeakFilter.class)
            // The host-port-forwarding SSH tunnel (Testcontainers.exposeHostPorts)
        logger.info("MiniKdc started on port {}, realm={}", kdc.getPort(), kdc.getRealm());
        if (kdc != null) kdc.stop();
            return null;
                .put("index.replication.type", "SEGMENT")
import org.junit.After;
                Database db = new Database();
            }""");
        });
            TSocket socket = new TSocket(host, port, 10000);
public class IngestFromHiveKerberosIT extends OpenSearchSingleNodeTestCase {
        // Copy krb5.conf generated by MiniKdc and rewrite KDC address for container access.
                socket
                Group group = factory.newGroup();
                sd.setOutputFormat("org.apache.hadoop.hive.ql.io.parquet.MapredParquetOutputFormat");
                .put("ingestion_source.param.database", DATABASE)
                .put("ingestion_source.param.database", DATABASE)
                client().admin().indices().prepareDelete(idx).get();
            } catch (IndexNotFoundException e) {
                try {
                } catch (Exception e) {
        }
    public static class TestContainerThreadLeakFilter implements ThreadFilter {
    }
                }
    /**
                group.append("event_type", i % 2 == 0 ? "click" : "view");
    public void setup() throws Exception {
            .withFileSystemBind(warehouseDir.getAbsolutePath(), warehouseDir.getAbsolutePath(), BindMode.READ_WRITE)
            // runs an unnamed receive-loop thread for the JVM lifetime; it can only
              required binary user_id (UTF8);
                }
     */
                .put("ingestion_source.param.monitor_interval", "2s")
import org.opensearch.common.SuppressForbidden;
                .put("ingestion_source.type", "HIVE")
        });
import java.util.Properties;
                .put("ingestion_source.param.database", DATABASE)
import org.apache.thrift.protocol.TBinaryProtocol;
        // MiniKdc binds to the host loopback, which containers cannot reach directly:
        generateTestData();
            }
        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
            .withFileSystemBind(containerKrb5Conf.getAbsolutePath(), "/etc/krb5.conf", BindMode.READ_ONLY)
                + "  <property><name>hadoop.security.authentication</name><value>kerberos</value></property>\n"
                StorageDescriptor sd = new StorageDescriptor();
                // index may not exist if test failed early
            TTransport saslTransport = new org.apache.thrift.transport.TSaslClientTransport(
    }
    private GenericContainer<?> kerberizedMetastore;
    private void writeParquetFile(File file, int startIdx) throws IOException {
                .put("ingestion_source.param.kerberos_keytab", keytabFile.getAbsolutePath())
                }
                .put("ingestion_source.param.kerberos_principal", "client1@" + kdc.getRealm())
                    client.create_table(table);
    @Override
    public void cleanup() throws Exception {
                .put("ingestion_source.param.table", TABLE_NAME)
 */
import org.apache.parquet.hadoop.example.ExampleParquetWriter;
    private void registerTableWithKerberos(String metastoreUri) throws Exception {
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.plugin.hive.metastore.StorageDescriptor;
import org.apache.thrift.transport.TTransport;
                + "  <property><name>metastore.kerberos.principal</name><value>hive/localhost@"
                table.setSd(sd);
        startKerberizedMetastore();
                .put("ingestion_source.type", "HIVE")
            coreSiteXml.toPath(),
import org.apache.parquet.example.data.simple.SimpleGroupFactory;
                + kdc.getRealm()
                .build()
        kerberizedMetastore = new GenericContainer<>("apache/hive:4.0.1").withExposedPorts(9083)
    }
                || t.getName().contains("StatisticsDataReferenceCleaner")
                cols.add(new FieldSchema("event_id", "string", ""));
                .put("ingestion_source.pointer.init.reset", "earliest")
        Properties conf = MiniKdc.createConf();
                .put("ingestion_source.pointer.init.reset", "earliest")
import java.util.Collections;
                cols.add(new FieldSchema("amount", "double", ""));
import org.apache.parquet.hadoop.ParquetWriter;
                    fail("Poller thread still alive: " + t.getName());
                table.setDbName(DATABASE);
                Table table = new Table();
    }
                sd.setInputFormat("org.apache.hadoop.hive.ql.io.parquet.MapredParquetInputFormat");
    @After
        org.apache.parquet.io.OutputFile outputFile = new org.apache.parquet.io.LocalOutputFile(file.toPath());
                if (t != null && t.getName().contains("stream-poller")) {
            Settings.builder()
import java.io.File;
            String host = kerberizedMetastore.getHost();
                .put("ingestion_source.param.kerberos_keytab", keytabFile.getAbsolutePath())
                table.setTableName(TABLE_NAME);
import org.apache.parquet.schema.MessageTypeParser;
import org.opensearch.plugin.hive.metastore.FieldSchema;
                .put("ingestion_source.param.monitor_interval", "2s")
        }
            .withEnv("SERVICE_NAME", "metastore")
                db.setName(DATABASE);
                    Partition partition = new Partition();
                    partition.setDbName(DATABASE);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import com.carrotsearch.randomizedtesting.ThreadFilter;
            for (int i = startIdx; i < startIdx + 75; i++) {
    private void startMiniKdc() throws Exception {
        org.testcontainers.Testcontainers.exposeHostPorts(kdc.getPort());
            if (t.getName().startsWith("testcontainers-")
        // Delete indices first to stop the pollers before shutting down KDC/Metastore
                new java.util.HashMap<>(),
    }
        ensureGreen(index1);
        );
                .put("index.replication.type", "SEGMENT")
        kdc.start();
            Settings.builder()
                .build()
            // be identified by its stack.
import org.testcontainers.containers.BindMode;
              required binary event_id (UTF8);
        registerTableWithKerberos(metastoreUri);
        java.nio.file.Files.writeString(
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            Thread.sleep(500);
                } catch (Exception e) {
}
                saslTransport.close();
import java.util.Collection;
                .put("ingestion_source.param.monitor_interval", "2s")
import org.testcontainers.containers.GenericContainer;
                .put("ingestion_source.param.metastore_service_principal", "hive/localhost@" + kdc.getRealm())
                    } catch (Exception e) {
        org.apache.hadoop.security.UserGroupInformation ugi = org.apache.hadoop.security.UserGroupInformation
                .put("ingestion_source.param.table", TABLE_NAME)
                + "  <property><name>metastore.sasl.enabled</name><value>true</value></property>\n"
import org.opensearch.plugin.hive.metastore.Table;
                + "</configuration>\n"
                group.append("event_id", "evt-" + i);
 * compatible open source license.
import org.testcontainers.containers.wait.strategy.Wait;
        kdc.createPrincipal(keytabFile, "client1", "client2", "hive/localhost");
                .put("ingestion_source.param.authentication", "kerberos")
        for (String idx : new String[] { "hive-kerberos-test-index", "hive-kerberos-test-index-2" }) {
import org.opensearch.plugins.Plugin;
                    partition.setTableName(TABLE_NAME);
        String index1 = indexName;
        createIndex(
        assertTrue("Provided state requirements not met", checkState.call());
        if (kerberizedMetastore != null) kerberizedMetastore.stop();
        String[] partitions = { "dt=2026-04-13", "dt=2026-04-14", "dt=2026-04-15" };
                db.setLocationUri(warehouseDir.getAbsolutePath() + "/" + DATABASE);
        // Both indices should ingest all 450 documents independently
            writeParquetFile(new File(partDir, "part-00000.parquet"), 0);
            if (checkState.call()) return;
            partDir.mkdirs();
                + "</value></property>\n"
import org.apache.parquet.schema.MessageType;
                    partSd.setInputFormat(sd.getInputFormat());
                .put("ingestion_source.param.metastore_service_principal", "hive/localhost@" + kdc.getRealm())
        // Generate hive-site.xml for Kerberos-enabled Metastore
            .withFileSystemBind(coreSiteXml.getAbsolutePath(), "/opt/hive/conf/core-site.xml", BindMode.READ_ONLY)
                group.append("amount", i * 1.5);
        // Generate core-site.xml
            .withFileSystemBind(hiveSiteXml.getAbsolutePath(), "/opt/hive/conf/hive-site.xml", BindMode.READ_ONLY)
            return false;
            .withEnv("DB_DRIVER", "derby")
                    partSd.setSerdeInfo(serDeInfo);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .waitingFor(Wait.forListeningPort())
import org.junit.Before;
        createIndex(
            int port = kerberizedMetastore.getMappedPort(9083);
            for (Thread t : threads) {
    protected void waitForState(Callable<Boolean> checkState) throws Exception {
        // Create principals and keytab
        long start = System.currentTimeMillis();
                null,
    }
import org.opensearch.plugin.hive.metastore.Partition;
            }
    private void startKerberizedMetastore() throws Exception {
        for (String partition : partitions) {
        });
                        if (!e.getClass().getSimpleName().contains("AlreadyExists")) throw e;
            hiveSiteXml.toPath(),
        java.nio.file.Files.writeString(
                || t.getName().startsWith("ducttape")
                + "  <property><name>hadoop.security.authentication</name><value>kerberos</value></property>\n"
            .withStartupTimeout(java.time.Duration.ofMinutes(3));
                List<FieldSchema> cols = new ArrayList<>();
                if (e.getClassName().startsWith("org.testcontainers.shaded.com.trilead.ssh2")) {
                    try {
    private File warehouseDir;
            writeParquetFile(new File(partDir, "part-00001.parquet"), 75);
            .withFileSystemBind(hiveSiteXml.getAbsolutePath(), "/opt/hive/conf/metastore-site.xml", BindMode.READ_ONLY)
        waitForState(() -> {
        ensureGreen(index2);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        String index2 = "hive-kerberos-test-index-2";
import org.opensearch.index.query.QueryBuilders;
                    StorageDescriptor partSd = new StorageDescriptor();
                }
                sd.setSerdeInfo(serDeInfo);
import java.io.IOException;
    }
    }
    }
                    if (!e.getClass().getSimpleName().contains("AlreadyExists")) throw e;
            );
     * without interfering with each other. Verifies instance-local UGI isolation.
                SerDeInfo serDeInfo = new SerDeInfo();
            Settings.builder()
                for (String dt : new String[] { "2026-04-13", "2026-04-14", "2026-04-15" }) {
        // Create second index with client2 principal
            }
            return r1.getHits().getTotalHits().value() == 450 && r2.getHits().getTotalHits().value() == 450;
                        client.add_partition(partition);
            } finally {
        keytabFile = new File(warehouseDir, "test.keytab");
                sd.setLocation(warehouseDir.getAbsolutePath() + "/" + DATABASE + "/" + TABLE_NAME);
              required double amount;
        ugi.doAs((java.security.PrivilegedExceptionAction<Void>) () -> {
                .put("ingestion_source.param.metastore_uri", metastoreUri)
                .put("ingestion_source.type", "HIVE")
        File kdcDir = createTempDir().toFile();
                group.append("user_id", "user-" + (i % 10));
        // host.docker.internal only routes to the loopback on Docker Desktop, and the
                    }
            }
                + "  <property><name>metastore.kerberos.keytab.file</name><value>/opt/keytabs/test.keytab</value></property>\n"
            try {
import org.opensearch.action.search.SearchResponse;
        @Override
        String metastoreUri = "thrift://" + kerberizedMetastore.getHost() + ":" + kerberizedMetastore.getMappedPort(9083);
import org.apache.thrift.transport.TSocket;
import org.opensearch.common.settings.Settings;
                .put("ingestion_source.param.metastore_service_principal", "hive/localhost@" + kdc.getRealm())
/*
        File krb5Conf = new File(System.getProperty("java.security.krb5.conf"));
        // Linux host-gateway alias points at the bridge IP instead. Testcontainers'
                    client.create_database(db);
        SimpleGroupFactory factory = new SimpleGroupFactory(schema);
                    partSd.setOutputFormat(sd.getOutputFormat());
            .loginUserFromKeytabAndReturnUGI("client1@" + kdc.getRealm(), keytabFile.getAbsolutePath());
        }
                }
        kdc = new MiniKdc(conf, kdcDir);
import org.opensearch.plugin.hive.metastore.Database;
                    if (!e.getClass().getSimpleName().contains("AlreadyExists")) throw e;
                table.setPartitionKeys(List.of(new FieldSchema("dt", "string", "")));
    private void generateTestData() throws IOException {
        org.apache.hadoop.security.UserGroupInformation.setConfiguration(conf);
        );
                group.append("timestamp", 1700000000L + i);
                .put("ingestion_source.param.metastore_uri", metastoreUri)
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<configuration>\n"
            }
                    partSd.setLocation(warehouseDir.getAbsolutePath() + "/" + DATABASE + "/" + TABLE_NAME + "/dt=" + dt);
        MessageType schema = MessageTypeParser.parseMessageType("""
                .put("ingestion_source.param.metastore_uri", metastoreUri)
