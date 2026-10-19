            }  
                    try {
import java.net.URI;
import org.apache.thrift.protocol.TBinaryProtocol;
                .collect(Collectors.toList());  
                .map(fs -> new ColumnInfo(fs.getName(), fs.getType()))
                if (config.getAuthMode() == HiveSourceConfig.AuthMode.KERBEROS) {
            req.setDbName(database);  
                ugi = UserGroupInformation.loginUserFromKeytabAndReturnUGI(config.getKerberosPrincipal(), config.getKerberosKeytabPath());  
import javax.security.sasl.SaslException;
import org.opensearch.plugin.hive.metastore.ThriftHiveMetastore;
                null,
        return new PartitionInfo(p.getValues(), p.getSd().getLocation(), p.getCreateTime());  
            List<ColumnInfo> columns = t.getSd()
        }
                transport = t;
            try {
            throw new TTransportException("Failed to create SASL transport: " + e.getMessage(), e);  
            GetTableRequest req = new GetTableRequest();
            try {
 * Hive Metastore catalog implementation using Thrift RPC.
            throw new IOException("Failed to get partitions: " + e.getMessage(), e);
                // A SASL handshake failure leaves the underlying TCP socket connected, so  
                saslHost,  
        for (int attempt = 0; attempt <= config.getMaxRetries(); attempt++) {
            throw new IOException("Failed to connect to Metastore: " + e.getMessage(), e);
                }
    public List<PartitionInfo> getPartitionsByFilter(String database, String table, String filter) throws IOException {
        try {
    @Override
                .stream()
 * Supports framed/unframed transport and Kerberos (SASL/GSSAPI) authentication.
 */  
                    }
        if (transport != null) {  
                saslServiceName,
            throw new IOException("Failed to get table info: " + e.getMessage(), e);
            throw new IOException("Failed to get partitions by filter: " + e.getMessage(), e);  
        } catch (URISyntaxException e) {  
import org.apache.thrift.transport.TSaslClientTransport;  
            String saslHost = kerberosName.getHostName();  
                    final TTransport saslTransport = t;  
    }
                client = new ThriftHiveMetastore.Client(new TBinaryProtocol(t));
            );
        try {
import org.opensearch.plugin.hive.metastore.Partition;
        try {  
        } catch (IOException e) {
                throw new TTransportException("Interrupted during retry", e);
                    port,  
    @Override
    }  
                : Collections.emptyList();  
            Table t = result.getTable();  
                    } catch (Exception e) {  
            throw new TTransportException("Invalid metastore URI [" + metastoreUri + "]. Expected format: thrift://host:port");
                    t = createSaslTransport(t, host);
    }  
                    t.open();
                    t = new TFramedTransport(socket);
    static URI parseMetastoreUri(String metastoreUri) throws TTransportException {
        connect();
import java.security.PrivilegedExceptionAction;  
                }
        }  
import org.apache.hadoop.security.UserGroupInformation;  
                conf.set("hadoop.security.authentication", "kerberos");
package org.opensearch.plugin.hive;
            String saslServiceName = kerberosName.getServiceName();
import org.opensearch.plugin.hive.metastore.GetTableRequest;  
        URI parsed = parseMetastoreUri(config.getMetastoreUri());
                            return null;
            }
import org.apache.logging.log4j.Logger;  
            throw new TTransportException("Invalid metastore URI [" + metastoreUri + "]. Expected format: thrift://host:port");
import org.apache.hadoop.security.authentication.util.KerberosName;
    private PartitionInfo toPartitionInfo(Partition p) {
            transport = null;  
            return partitions.stream().map(this::toPartitionInfo).collect(Collectors.toList());
            connectInternal();
                servicePrincipal = SecurityUtil.getServerPrincipal(servicePrincipal, host);
            List<String> partitionKeys = t.getPartitionKeys() != null
            } catch (InterruptedException e) {
        try {
    }
                closeQuietly(t);  
            KerberosName kerberosName = new KerberosName(servicePrincipal);
                    logger.info("Retrying Metastore connection (attempt {}/{})", attempt, config.getMaxRetries());
    }
        } catch (Exception e) {  
                    t = socket;
            } else {
                logger.info("Kerberos login successful for principal {}", config.getKerberosPrincipal());
import org.apache.hadoop.conf.Configuration;
            return new TableInfo(t.getSd().getInputFormat(), partitionKeys, columns);
                // close whatever this attempt opened before retrying.
import org.apache.hadoop.security.SecurityUtil;
import org.opensearch.plugin.hive.metastore.FieldSchema;
                } else {  
    private void connectInternal() throws TTransportException {  
import org.opensearch.secure_sm.AccessController;
            } catch (Exception e) {  
    @Override
                    config.getAuthMode()
        } catch (TTransportException e) {  
                t.close();
import org.apache.thrift.TException;
                    host,
                }
    public void close() throws IOException {
            throw new TTransportException("Failed to resolve service principal: " + e.getMessage(), e);
        try {
    }  
                logger.info(  
            }
                ? t.getPartitionKeys().stream().map(FieldSchema::getName).collect(Collectors.toList())
}
        try {
                        });
                logger.debug("Error closing transport from failed connection attempt", e);
            });
                TSocket socket = new TSocket(host, port, config.getConnectTimeoutMillis());  
        }  
            }  
    }
import org.apache.thrift.transport.TTransport;
            List<Partition> partitions = client.get_partitions_by_filter(database, table, filter, (short) -1);  
    /**  
                baseTransport  
    private static final Logger logger = LogManager.getLogger(ThriftMetastoreCatalog.class);  
 * SPDX-License-Identifier: Apache-2.0
        }
                UserGroupInformation.setConfiguration(conf);
    private TTransport transport;
                );  
import java.util.stream.Collectors;
                if (config.getTransportMode() == HiveSourceConfig.TransportMode.FRAMED) {
    }
                null,
        TTransportException lastException = null;  
    public ThriftMetastoreCatalog(HiveSourceConfig config) {
                    Thread.sleep(config.getRetryIntervalMillis());  
 * The OpenSearch Contributors require contributions made to  
     * URI.getHost() is null for malformed authorities (empty host, non-numeric
    private final HiveSourceConfig config;
     */
        if ("thrift".equalsIgnoreCase(parsed.getScheme()) == false || parsed.getHost() == null || parsed.getPort() == -1) {  
    }  
    public void connect() throws IOException {  
            loginWithKerberos();  
import org.apache.thrift.transport.TSocket;
 */  
/*  
        }
                logger.warn("Failed to connect to Metastore (attempt {}): {}", attempt + 1, e.getMessage());
        }
import org.apache.thrift.transport.TTransportException;  
    @Override
            throw new TTransportException("Kerberos login failed: " + e.getMessage(), e);
            parsed = new URI(metastoreUri);
        } catch (TException e) {
        throw new TTransportException("Failed to connect to Metastore after " + config.getMaxRetries() + " retries", lastException);
import java.io.IOException;  
    @Override  
import java.util.Map;  
/**  
            req.setTblName(table);
            } catch (TTransportException e) {
            return new TSaslClientTransport(
                lastException = e;  
     * Parses and validates a metastore URI of the form thrift://host:port.
    }  
        }
            } catch (Exception e) {  
     * port, unbracketed IPv6), so those are rejected as well.  
            String servicePrincipal = config.getMetastoreServicePrincipal();
        return parsed;  
import org.opensearch.plugin.hive.metastore.Table;  
        if (t != null) {  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugin.hive.metastore.GetTableResult;
    private void closeQuietly(TTransport t) {
        try {
    public TableInfo getTableInfo(String database, String table) throws IOException {  
                "GSSAPI",  
                return;
            TTransport t = null;
                .getCols()  
                        ugi.doAs((PrivilegedExceptionAction<Void>) () -> {
    }  
            return partitions.stream().map(this::toPartitionInfo).collect(Collectors.toList());  
    private ThriftHiveMetastore.Client client;  
 *
                            saslTransport.open();  
                } else {  
    private void loginWithKerberos() throws TTransportException {  
        } catch (TException e) {
                Configuration conf = new Configuration();  
public class ThriftMetastoreCatalog implements MetastoreCatalog {
    public List<PartitionInfo> getAllPartitions(String database, String table) throws IOException {  
            List<Partition> partitions = client.get_partitions(database, table, (short) -1);
            GetTableResult result = client.get_table_req(req);
import java.util.Collections;
                if (attempt > 0) {
                Thread.currentThread().interrupt();
        }
import java.net.URISyntaxException;
    }
            if (servicePrincipal == null) {
        }  
        }
        }
                logger.debug("Error closing metastore transport", e);
    public void reconnect() throws IOException {  
        String host = parsed.getHost();
        URI parsed;  
                    config.getTransportMode(),
 * compatible open source license.
import org.apache.thrift.transport.layered.TFramedTransport;
                closeQuietly(t);
        if (config.getAuthMode() == HiveSourceConfig.AuthMode.KERBEROS) {
                    "Connected to Hive Metastore at {}:{} (transport={}, auth={})",
                Map.of("javax.security.sasl.qop", "auth", "javax.security.sasl.server.authentication", "true"),
        } catch (SaslException e) {
import java.util.List;
            try {  
        this.config = config;
    @Override
        close();
                servicePrincipal = "hive/" + host;  
                        throw new TTransportException("SASL open failed: " + e.getMessage(), e);
import org.apache.logging.log4j.LogManager;
                transport.close();
        } catch (TException e) {  
        int port = parsed.getPort();  
    private TTransport createSaslTransport(TTransport baseTransport, String host) throws TTransportException {
    }  
    private UserGroupInformation ugi;
        }
            client = null;
            AccessController.doPrivilegedChecked(() -> {
