                hdfsConfiguration.set("dfs.data.transfer.protection", "authentication");
        public int transitionToStandby(String namenodeID) throws Exception {
import java.util.List;
import org.apache.hadoop.ha.protocolPB.HAServiceProtocolClientSideTranslatorPB;
                    throw new IllegalStateException("Could not locate keytab at " + kerberosKeytabLocation);
        String ports = System.getProperty("test.hdfs-fixture.ports");
import org.apache.hadoop.ha.HAServiceTarget;
                "{"
 * this work for additional information regarding copyright
                    + "\","
            return delegate.getZKFCProxy(conf, timeoutMs);
import org.opensearch.secure_sm.AccessController;
 * The OpenSearch Contributors require contributions made to
        public boolean isAutoFailoverEnabled() {
        hdfsConfiguration.set("dfs.ha.namenodes.ha-hdfs", "nn1,nn2");
            return delegate.getFencer();
            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Integration test that runs against an HA-Enabled HDFS instance
            final List<String> lines = AccessController.doPrivilegedChecked(() -> Files.readAllLines(path));
        }
    private void failoverHDFS(String from, String to, Configuration configuration) throws IOException {
        {
        @Override
 * GitHub history for details.
                SecurityUtil.setAuthenticationMethod(UserGroupInformation.AuthenticationMethod.SIMPLE, hdfsConfiguration);
     */
            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
        if (securityEnabled) {
                UserGroupInformation.getCurrentUser();
                    haAdmin.transitionToStandby(from);
            try {
        {
            return delegate.getZKFCAddress();
        @Override
    public void testHAFailoverWithRepository() throws Exception {
            this.delegate = delegate;
        }
            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
        }
     * to close them at the end of the test lifecycle.
                    + "\"path\": \"/user/opensearch/existing/readonly-repository\","
        });
            return run(new String[] { "-transitionToStandby", namenodeID });
        }
        public int run(String[] argv) throws Exception {
                    + "}"
    /**
            HAServiceProtocol proxy = delegate.getProxy(conf, timeoutMs);
            return delegate.getHealthMonitorAddress();
                }
        String nn1Port = "10001";
                Path kt = PathUtils.get(kerberosKeytabLocation);
            CloseableHAAdmin haAdmin = new CloseableHAAdmin();
        }
        public InetSocketAddress getZKFCAddress() {
        private final List<CloseableHAServiceTarget> serviceTargets = new ArrayList<>();
        String nn2Port = "10002";
            return "\"security.principal\": \"" + kerberosPrincipal + "\"," + "\"conf.dfs.data.transfer.protection\": \"authentication\",";
                if (protocol instanceof HAServiceProtocolClientSideTranslatorPB) {
                    throw new RuntimeException("Unable to perform namenode failover", e);
        hdfsConfiguration.set("dfs.namenode.rpc-address.ha-hdfs.nn1", "localhost:" + nn1Port);
        hdfsConfiguration.set("dfs.namenode.rpc-address.ha-hdfs.nn2", "localhost:" + nn2Port);
     * @throws IOException In the event of a raised exception during namenode failover.
        // Failover the namenode to the second.
            nn2Port = lines.get(1);
                }
     */
                UserGroupInformation.loginUserFromKeytab(hdfsKerberosPrincipal, kerberosKeytabLocation);
                logger.info("Keytab Length: " + Files.readAllBytes(kt).length);
        AccessController.doPrivilegedChecked(() -> {
        });
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
            delegate.checkFencingConfigured();
                if (Files.isReadable(kt) != true) {
                if (Files.exists(kt) == false) {
            request.setJsonEntity(
            "org.apache.hadoop.hdfs.server.namenode.ha.ConfiguredFailoverProxyProvider"
                } catch (Exception e) {
        }
 * ownership. Elasticsearch licenses this file to you under
        boolean securityEnabled = hdfsKerberosPrincipal != null;
            return null;
    private static class CloseableHAServiceTarget extends HAServiceTarget {
 * You may obtain a copy of the License at
        failoverHDFS("nn1", "nn2", hdfsConfiguration);
        String kerberosKeytabLocation = System.getProperty("test.krb5.keytab.hdfs");
        logger.info("Swapping active namenodes: [{}] to standby and [{}] to active", from, to);
/**
            serviceTargets.add(target);
import org.apache.hadoop.ha.ZKFCProtocol;
import org.opensearch.client.Response;
import org.opensearch.common.io.PathUtils;
            return target;
 * compatible open source license.
        private final List<HAServiceProtocol> protocolsToClose = new ArrayList<>();
        hdfsConfiguration.set(
import java.util.ArrayList;
            for (HAServiceProtocol protocol : protocolsToClose) {
            return null;
            return delegate.isAutoFailoverEnabled();
        @Override
        public void checkFencingConfigured() throws BadFencingConfigurationException {
 * Licensed to Elasticsearch under one or more contributor
            "dfs.client.failover.proxy.provider.ha-hdfs",
                    + "\"settings\":{"
        @Override
            return delegate.getHealthMonitorProxy(conf, timeoutMs);
    private String securityCredentials(boolean securityEnabled, String kerberosPrincipal) {
                    + "\"conf.dfs.ha.namenodes.ha-hdfs\": \"nn1,nn2\","
        }
                try {
        private void close() {
import org.apache.hadoop.security.UserGroupInformation;
        }
        } else {
            }
        @Override
     */
                    + "\"conf.dfs.client.failover.proxy.provider.ha-hdfs\": "
            } else {
        }
 */
/*
                    + nn1Port
 */
import org.apache.hadoop.ha.NodeFencer;
                }
     * resources when it concludes. This subclass overrides the tool to allow for exception throwing, and to
    }
        AccessController.doPrivileged(() -> {
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
        // Get repository
        // Get repository again
        @Override
                    ((HAServiceProtocolClientSideTranslatorPB) protocol).close();
import org.apache.hadoop.security.SecurityUtil;
        public ZKFCProtocol getZKFCProxy(Configuration conf, int timeoutMs) throws IOException {
            final Path path = PathUtils.get(ports);
 *
        }
import java.nio.file.Path;
        public void close() {
                    + "\"readonly\": \"true\","
            }
            return delegate.getAddress();
        {
                    + "\"conf.dfs.namenode.rpc-address.ha-hdfs.nn2\": \"localhost:"
                    throw new IllegalStateException("Could not read keytab at " + kerberosKeytabLocation);
 * under the License.
        if (ports.length() > 0) {
        String esKerberosPrincipal = System.getProperty("test.krb5.principal.es");
    }
                haAdmin.close();
/*
        @Override
        }
 * KIND, either express or implied.  See the License for the
import org.apache.hadoop.ha.BadFencingConfigurationException;
            Response response = client.performRequest(request);
                    + "\"conf.dfs.namenode.rpc-address.ha-hdfs.nn1\": \"localhost:"
        }
                    + "\"type\":\"hdfs\","
                }
        public InetSocketAddress getHealthMonitorAddress() {
/*
            } finally {
 * SPDX-License-Identifier: Apache-2.0
                UserGroupInformation.setConfiguration(hdfsConfiguration);
        }
        }
import java.nio.file.Files;
        hdfsConfiguration.set("dfs.nameservices", "ha-hdfs");
        @Override
     * The default HAAdmin tool does not throw exceptions on failures, and does not close any client connection
        }
        }
    }
import org.junit.Assert;
public class HaHdfsFailoverTestSuiteIT extends OpenSearchRestTestCase {
 * license agreements. See the NOTICE file distributed with
            Response response = client.performRequest(new Request("GET", "/_snapshot/hdfs_ha_repo_read/_all"));
                // set principal names
        }
     * @param from Namenode ID to transition to standby
                    + "\"uri\": \"hdfs://ha-hdfs/\",\n"
            protocolsToClose.add(proxy);
            CloseableHAServiceTarget target = new CloseableHAServiceTarget(super.resolveTarget(nnId));
     * @param to Namenode ID to transition to active
            );
        public InetSocketAddress getAddress() {
import org.opensearch.client.Request;
        CloseableHAServiceTarget(HAServiceTarget delegate) {
 * not use this file except in compliance with the License.
 */
     * keep track of and clean up connection resources.
        @Override
            return runCmd(argv);
        public int transitionToActive(String namenodeID) throws Exception {
        public NodeFencer getFencer() {
 * this file be licensed under the Apache-2.0 license or a
}
                hdfsConfiguration.set("dfs.datanode.kerberos.principal", hdfsKerberosPrincipal);
                    + securityCredentials(securityEnabled, esKerberosPrincipal)
        }
 */
import org.apache.hadoop.conf.Configuration;
import java.net.InetSocketAddress;
     * @param configuration Client configuration for HAAdmin tool
        RestClient client = client();
 * specific language governing permissions and limitations
                SecurityUtil.setAuthenticationMethod(UserGroupInformation.AuthenticationMethod.KERBEROS, hdfsConfiguration);
                    + "\","
                    haAdmin.transitionToActive(to);
            return proxy;
        public HAServiceProtocol getProxy(Configuration conf, int timeoutMs) throws IOException {
package org.opensearch.repositories.hdfs;
        @Override
        Configuration hdfsConfiguration = new Configuration();
                // ensure that keytab exists
     * Performs a two-phase leading namenode transition.
            Response response = client.performRequest(new Request("GET", "/_snapshot/hdfs_ha_repo_read/_all"));
    private static class CloseableHAAdmin extends DFSHAAdmin {
                hdfsConfiguration.set("dfs.namenode.kerberos.principal", hdfsKerberosPrincipal);
 * the Apache License, Version 2.0 (the "License"); you may
            }
import java.io.IOException;
import org.opensearch.test.rest.OpenSearchRestTestCase;
    }
            Request request = new Request("PUT", "/_snapshot/hdfs_ha_repo_read");
        }
        private final HAServiceTarget delegate;
    /**
        public HAServiceProtocol getHealthMonitorProxy(Configuration conf, int timeoutMs) throws IOException {
 * software distributed under the License is distributed on an
            }
                serviceTarget.close();
     * Wraps an HAServiceTarget, keeping track of any HAServiceProtocol proxies it generates in order
            for (CloseableHAServiceTarget serviceTarget : serviceTargets) {
import org.apache.hadoop.ha.HAServiceProtocol;
        String hdfsKerberosPrincipal = System.getProperty("test.krb5.principal.hdfs");
    /**
                    + "}"
            if (securityEnabled) {
        }
        @Override
        // Create repository
                UserGroupInformation.setConfiguration(hdfsConfiguration);
 *
import org.opensearch.client.RestClient;
            return "";
 *
                    + nn2Port
            nn1Port = lines.get(0);
    }
            return run(new String[] { "-transitionToActive", namenodeID });
        }
                    + "\"org.apache.hadoop.hdfs.server.namenode.ha.ConfiguredFailoverProxyProvider\""
import org.apache.hadoop.hdfs.tools.DFSHAAdmin;
        protected HAServiceTarget resolveTarget(String nnId) {
            haAdmin.setConf(configuration);
                    + "\"conf.dfs.nameservices\": \"ha-hdfs\","
