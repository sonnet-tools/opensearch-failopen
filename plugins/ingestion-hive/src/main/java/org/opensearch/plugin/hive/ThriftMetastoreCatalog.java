            connectInternal();
                .collect(Collectors.toList());
            List<ColumnInfo> columns = t.getSd()
 * Supports framed/unframed transport and Kerberos (SASL/GSSAPI) authentication.
            return new TableInfo(t.getSd().getInputFormat(), partitionKeys, columns);
    }
        try {
        }
        }
    public void reconnect() throws IOException {
        }
        }
    @Override
                ? t.getPartitionKeys().stream().map(FieldSchema::getName).collect(Collectors.toList())
                );
                // close whatever this attempt opened before retrying.
            }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugin.hive.metastore.Partition;
            } catch (InterruptedException e) {
import java.io.IOException;
        TTransportException lastException = null;
        }
        try {
import java.net.URI;
                    "Connected to Hive Metastore at {}:{} (transport={}, auth={})",
                if (config.getAuthMode() == HiveSourceConfig.AuthMode.KERBEROS) {
    public ThriftMetastoreCatalog(HiveSourceConfig config) {
            throw new TTransportException("Invalid metastore URI [" + metastoreUri + "]. Expected format: thrift://host:port");
        try {
        if (config.getAuthMode() == HiveSourceConfig.AuthMode.KERBEROS) {
        this.config = config;
import org.apache.thrift.TException;
     */
            String saslHost = kerberosName.getHostName();
import org.opensearch.plugin.hive.metastore.GetTableResult;
import org.apache.thrift.transport.TSocket;
        for (int attempt = 0; attempt <= config.getMaxRetries(); attempt++) {
        } catch (TException e) {
     * port, unbracketed IPv6), so those are rejected as well.
                    }
        return parsed;
     * URI.getHost() is null for malformed authorities (empty host, non-numeric
            parsed = new URI(metastoreUri);
                if (config.getTransportMode() == HiveSourceConfig.TransportMode.FRAMED) {
        int port = parsed.getPort();
            }
                } else {
                }
            return partitions.stream().map(this::toPartitionInfo).collect(Collectors.toList());
                    final TTransport saslTransport = t;
            } catch (Exception e) {
 *
        try {
    public void connect() throws IOException {
    @Override
                transport = t;
import org.apache.hadoop.security.UserGroupInformation;
    }
                closeQuietly(t);
    @Override
import org.opensearch.plugin.hive.metastore.ThriftHiveMetastore;
    private void connectInternal() throws TTransportException {
    private TTransport transport;
                        throw new TTransportException("SASL open failed: " + e.getMessage(), e);
        }
        try {
                    t = createSaslTransport(t, host);
        return new PartitionInfo(p.getValues(), p.getSd().getLocation(), p.getCreateTime());
                client = new ThriftHiveMetastore.Client(new TBinaryProtocol(t));
    }
 * SPDX-License-Identifier: Apache-2.0
                            return null;
            throw new IOException("Failed to connect to Metastore: " + e.getMessage(), e);
import java.util.Collections;
                servicePrincipal = "hive/" + host;
                null,
    }
                }
                    t = socket;
        } catch (TException e) {
 */
import org.apache.thrift.transport.TTransport;
}
            try {
    }
            );
import org.opensearch.plugin.hive.metastore.FieldSchema;
    static URI parseMetastoreUri(String metastoreUri) throws TTransportException {
import org.opensearch.plugin.hive.metastore.GetTableRequest;
            return new TSaslClientTransport(
                transport.close();
    }
    private void loginWithKerberos() throws TTransportException {
import java.net.URISyntaxException;
                .map(fs -> new ColumnInfo(fs.getName(), fs.getType()))
                baseTransport
    @Override
                logger.info("Kerberos login successful for principal {}", config.getKerberosPrincipal());
        if (transport != null) {
            throw new TTransportException("Failed to create SASL transport: " + e.getMessage(), e);
import org.opensearch.secure_sm.AccessController;
        try {
            } else {
                saslServiceName,
    private PartitionInfo toPartitionInfo(Partition p) {
            }
                ugi = UserGroupInformation.loginUserFromKeytabAndReturnUGI(config.getKerberosPrincipal(), config.getKerberosKeytabPath());
            KerberosName kerberosName = new KerberosName(servicePrincipal);
                logger.debug("Error closing transport from failed connection attempt", e);
        if ("thrift".equalsIgnoreCase(parsed.getScheme()) == false || parsed.getHost() == null || parsed.getPort() == -1) {
                logger.info(
                t.close();
                    t.open();
 * The OpenSearch Contributors require contributions made to
        } catch (URISyntaxException e) {
                throw new TTransportException("Interrupted during retry", e);
    }
import org.apache.hadoop.security.SecurityUtil;
        URI parsed = parseMetastoreUri(config.getMetastoreUri());
import org.apache.thrift.transport.layered.TFramedTransport;
     * Parses and validates a metastore URI of the form thrift://host:port.
                logger.warn("Failed to connect to Metastore (attempt {}): {}", attempt + 1, e.getMessage());
            req.setTblName(table);
            throw new TTransportException("Kerberos login failed: " + e.getMessage(), e);
                TSocket socket = new TSocket(host, port, config.getConnectTimeoutMillis());
import java.security.PrivilegedExceptionAction;
package org.opensearch.plugin.hive;
        if (t != null) {
import org.apache.hadoop.security.authentication.util.KerberosName;
    public void close() throws IOException {
        }
    private final HiveSourceConfig config;
            GetTableResult result = client.get_table_req(req);
                return;
import org.opensearch.plugin.hive.metastore.Table;
                Thread.currentThread().interrupt();
        } catch (TException e) {
                "GSSAPI",
    private ThriftHiveMetastore.Client client;
    private void closeQuietly(TTransport t) {
        } catch (IOException e) {
                closeQuietly(t);
            loginWithKerberos();
            });
                }
    }
    @Override
                .getCols()
import org.apache.logging.log4j.LogManager;
    public List<PartitionInfo> getAllPartitions(String database, String table) throws IOException {
            try {
                    config.getTransportMode(),
        }
                    t = new TFramedTransport(socket);
            throw new IOException("Failed to get table info: " + e.getMessage(), e);
        } catch (Exception e) {
                Configuration conf = new Configuration();
                conf.set("hadoop.security.authentication", "kerberos");
            TTransport t = null;
/*
import org.apache.thrift.transport.TSaslClientTransport;
        String host = parsed.getHost();
            GetTableRequest req = new GetTableRequest();
    }
/**
    }
                UserGroupInformation.setConfiguration(conf);
            req.setDbName(database);
                    } catch (Exception e) {
import org.apache.hadoop.conf.Configuration;
        URI parsed;
                        });
                    logger.info("Retrying Metastore connection (attempt {}/{})", attempt, config.getMaxRetries());
import java.util.Map;
                    config.getAuthMode()
        }
            List<Partition> partitions = client.get_partitions(database, table, (short) -1);
        throw new TTransportException("Failed to connect to Metastore after " + config.getMaxRetries() + " retries", lastException);
            }
            throw new IOException("Failed to get partitions: " + e.getMessage(), e);
                servicePrincipal = SecurityUtil.getServerPrincipal(servicePrincipal, host);
    private TTransport createSaslTransport(TTransport baseTransport, String host) throws TTransportException {
            if (servicePrincipal == null) {
                            saslTransport.open();
    public List<PartitionInfo> getPartitionsByFilter(String database, String table, String filter) throws IOException {
                if (attempt > 0) {
                .stream()
    @Override
            } catch (TTransportException e) {
    }
import java.util.stream.Collectors;
            transport = null;
        close();
import org.apache.thrift.transport.TTransportException;
    public TableInfo getTableInfo(String database, String table) throws IOException {
            AccessController.doPrivilegedChecked(() -> {
            } catch (Exception e) {
                Map.of("javax.security.sasl.qop", "auth", "javax.security.sasl.server.authentication", "true"),
                } else {
import java.util.List;
 */
                // A SASL handshake failure leaves the underlying TCP socket connected, so
 * Hive Metastore catalog implementation using Thrift RPC.
            String servicePrincipal = config.getMetastoreServicePrincipal();
                    try {
                    Thread.sleep(config.getRetryIntervalMillis());
    /**
    }
                    host,
        }
import org.apache.thrift.protocol.TBinaryProtocol;
        }
import javax.security.sasl.SaslException;
            try {
                lastException = e;
            List<Partition> partitions = client.get_partitions_by_filter(database, table, filter, (short) -1);
                saslHost,
            client = null;
        try {
                null,
                    port,
            throw new TTransportException("Failed to resolve service principal: " + e.getMessage(), e);
                        ugi.doAs((PrivilegedExceptionAction<Void>) () -> {
        connect();
public class ThriftMetastoreCatalog implements MetastoreCatalog {
            List<String> partitionKeys = t.getPartitionKeys() != null
 * compatible open source license.
    }
    private UserGroupInformation ugi;
            throw new IOException("Failed to get partitions by filter: " + e.getMessage(), e);
        }
    private static final Logger logger = LogManager.getLogger(ThriftMetastoreCatalog.class);
                : Collections.emptyList();
        } catch (TTransportException e) {
        } catch (SaslException e) {
            Table t = result.getTable();
                logger.debug("Error closing metastore transport", e);
            throw new TTransportException("Invalid metastore URI [" + metastoreUri + "]. Expected format: thrift://host:port");
            return partitions.stream().map(this::toPartitionInfo).collect(Collectors.toList());
import org.apache.logging.log4j.Logger;
            String saslServiceName = kerberosName.getServiceName();
