 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.test.rest.OpenSearchRestTestCase;
                    + "\"conf.dfs.namenode.rpc-address.ha-hdfs.nn1\": \"localhost:"  
        public InetSocketAddress getZKFCAddress() {  
            final List<String> lines = AccessController.doPrivilegedChecked(() -> Files.readAllLines(path));  
        AccessController.doPrivilegedChecked(() -> {
/*  
            nn1Port = lines.get(0);
            return delegate.isAutoFailoverEnabled();  
        }
            final Path path = PathUtils.get(ports);
                    ((HAServiceProtocolClientSideTranslatorPB) protocol).close();  
import org.apache.hadoop.ha.BadFencingConfigurationException;
                if (protocol instanceof HAServiceProtocolClientSideTranslatorPB) {
            this.delegate = delegate;
        }  
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
            return null;  
                if (Files.isReadable(kt) != true) {
        @Override
                logger.info("Keytab Length: " + Files.readAllBytes(kt).length);
            return runCmd(argv);
                SecurityUtil.setAuthenticationMethod(UserGroupInformation.AuthenticationMethod.KERBEROS, hdfsConfiguration);  
        public void checkFencingConfigured() throws BadFencingConfigurationException {
        }
 * You may obtain a copy of the License at  
    /**
 * specific language governing permissions and limitations
                UserGroupInformation.getCurrentUser();  
        public int transitionToStandby(String namenodeID) throws Exception {
                "{"  
                try {  
        @Override
        // Create repository
     * The default HAAdmin tool does not throw exceptions on failures, and does not close any client connection
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.hadoop.conf.Configuration;
    /**  
        AccessController.doPrivileged(() -> {
        public HAServiceProtocol getProxy(Configuration conf, int timeoutMs) throws IOException {  
            return delegate.getAddress();  
/*
                UserGroupInformation.setConfiguration(hdfsConfiguration);
 */  
        private final HAServiceTarget delegate;  
     * Performs a two-phase leading namenode transition.  
import org.apache.hadoop.ha.NodeFencer;
    public void testHAFailoverWithRepository() throws Exception {
                serviceTarget.close();  
    private static class CloseableHAServiceTarget extends HAServiceTarget {
        if (ports.length() > 0) {
        }
                    + "\"readonly\": \"true\","
            request.setJsonEntity(
        }
import org.opensearch.secure_sm.AccessController;  
 * Licensed to Elasticsearch under one or more contributor  
        hdfsConfiguration.set("dfs.ha.namenodes.ha-hdfs", "nn1,nn2");
        public int transitionToActive(String namenodeID) throws Exception {  
                hdfsConfiguration.set("dfs.data.transfer.protection", "authentication");
        }
import org.junit.Assert;
import org.apache.hadoop.ha.ZKFCProtocol;  
            if (securityEnabled) {
        }
    /**
                    throw new RuntimeException("Unable to perform namenode failover", e);
        public InetSocketAddress getAddress() {
            return delegate.getFencer();  
    }  
                }
        String nn1Port = "10001";
        }
            return run(new String[] { "-transitionToStandby", namenodeID });  
import org.apache.hadoop.security.SecurityUtil;  
 * GitHub history for details.
            return delegate.getHealthMonitorProxy(conf, timeoutMs);
                    throw new IllegalStateException("Could not read keytab at " + kerberosKeytabLocation);  
            }
import org.apache.hadoop.ha.HAServiceTarget;
            return run(new String[] { "-transitionToActive", namenodeID });
            }
        }  
     * @param from Namenode ID to transition to standby
        );
import java.util.ArrayList;
        if (securityEnabled) {  
        }
import org.apache.hadoop.ha.HAServiceProtocol;  
        }  
                    + "\"conf.dfs.client.failover.proxy.provider.ha-hdfs\": "  
                    + "}"
        String ports = System.getProperty("test.hdfs-fixture.ports");
                    + "\","
        }
 * ownership. Elasticsearch licenses this file to you under  
        String kerberosKeytabLocation = System.getProperty("test.krb5.keytab.hdfs");  
        @Override
 * KIND, either express or implied.  See the License for the
public class HaHdfsFailoverTestSuiteIT extends OpenSearchRestTestCase {
 *  
                UserGroupInformation.loginUserFromKeytab(hdfsKerberosPrincipal, kerberosKeytabLocation);
                    + "\"uri\": \"hdfs://ha-hdfs/\",\n"  
import org.apache.hadoop.hdfs.tools.DFSHAAdmin;
        CloseableHAServiceTarget(HAServiceTarget delegate) {  
     * to close them at the end of the test lifecycle.  
    }  
                Path kt = PathUtils.get(kerberosKeytabLocation);
     */
                    + "\"conf.dfs.ha.namenodes.ha-hdfs\": \"nn1,nn2\","
            serviceTargets.add(target);
        hdfsConfiguration.set("dfs.namenode.rpc-address.ha-hdfs.nn2", "localhost:" + nn2Port);
        private void close() {  
        String esKerberosPrincipal = System.getProperty("test.krb5.principal.es");
                    haAdmin.transitionToStandby(from);
 * license agreements. See the NOTICE file distributed with
     */
            } else {  
        // Failover the namenode to the second.
import org.opensearch.common.io.PathUtils;
        }
 * Integration test that runs against an HA-Enabled HDFS instance  
            );
                UserGroupInformation.setConfiguration(hdfsConfiguration);
            for (HAServiceProtocol protocol : protocolsToClose) {
        }  
        }
        } else {
                    + nn1Port
     * @param to Namenode ID to transition to active
                    + "\"conf.dfs.nameservices\": \"ha-hdfs\","
import java.nio.file.Path;
        // Get repository
        });
            "org.apache.hadoop.hdfs.server.namenode.ha.ConfiguredFailoverProxyProvider"
 *
            } finally {  
        hdfsConfiguration.set(
     * @param configuration Client configuration for HAAdmin tool  
        {  
            try {
                    + "\","
        public InetSocketAddress getHealthMonitorAddress() {
        @Override
import org.apache.hadoop.ha.protocolPB.HAServiceProtocolClientSideTranslatorPB;
import java.util.List;  
        private final List<HAServiceProtocol> protocolsToClose = new ArrayList<>();
            return target;  
import java.net.InetSocketAddress;
        String hdfsKerberosPrincipal = System.getProperty("test.krb5.principal.hdfs");
        public void close() {
                hdfsConfiguration.set("dfs.datanode.kerberos.principal", hdfsKerberosPrincipal);  
     * resources when it concludes. This subclass overrides the tool to allow for exception throwing, and to
            return proxy;  
                    + securityCredentials(securityEnabled, esKerberosPrincipal)  
                    haAdmin.transitionToActive(to);
            CloseableHAAdmin haAdmin = new CloseableHAAdmin();  
        }  
/*  
     * Wraps an HAServiceTarget, keeping track of any HAServiceProtocol proxies it generates in order
import java.nio.file.Files;  
 * Unless required by applicable law or agreed to in writing,
            delegate.checkFencingConfigured();
                    + "\"conf.dfs.namenode.rpc-address.ha-hdfs.nn2\": \"localhost:"  
                    + "\"org.apache.hadoop.hdfs.server.namenode.ha.ConfiguredFailoverProxyProvider\""
package org.opensearch.repositories.hdfs;
            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
    private static class CloseableHAAdmin extends DFSHAAdmin {
        @Override
                }
        logger.info("Swapping active namenodes: [{}] to standby and [{}] to active", from, to);
        protected HAServiceTarget resolveTarget(String nnId) {  
            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
        boolean securityEnabled = hdfsKerberosPrincipal != null;
        }
                    + "\"path\": \"/user/opensearch/existing/readonly-repository\","
import org.apache.hadoop.security.UserGroupInformation;
        }
            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
/**
            CloseableHAServiceTarget target = new CloseableHAServiceTarget(super.resolveTarget(nnId));
            "dfs.client.failover.proxy.provider.ha-hdfs",  
        @Override
 */
        Configuration hdfsConfiguration = new Configuration();  
        failoverHDFS("nn1", "nn2", hdfsConfiguration);
import org.opensearch.client.Request;
     */
                    + "}"  
                }
 * this work for additional information regarding copyright
                    + "\"settings\":{"
            Request request = new Request("PUT", "/_snapshot/hdfs_ha_repo_read");
 */
    private void failoverHDFS(String from, String to, Configuration configuration) throws IOException {  
                }
                SecurityUtil.setAuthenticationMethod(UserGroupInformation.AuthenticationMethod.SIMPLE, hdfsConfiguration);
}  
     * keep track of and clean up connection resources.  
 * this file be licensed under the Apache-2.0 license or a
        hdfsConfiguration.set("dfs.nameservices", "ha-hdfs");
        hdfsConfiguration.set("dfs.namenode.rpc-address.ha-hdfs.nn1", "localhost:" + nn1Port);  
        }  
                // set principal names
 * Modifications Copyright OpenSearch Contributors. See
            protocolsToClose.add(proxy);
            }
        @Override  
    }
 * The OpenSearch Contributors require contributions made to  
        String nn2Port = "10002";  
        public int run(String[] argv) throws Exception {
        @Override  
            return delegate.getZKFCProxy(conf, timeoutMs);
        public boolean isAutoFailoverEnabled() {
            return "\"security.principal\": \"" + kerberosPrincipal + "\"," + "\"conf.dfs.data.transfer.protection\": \"authentication\",";
import java.io.IOException;
            nn2Port = lines.get(1);
            for (CloseableHAServiceTarget serviceTarget : serviceTargets) {
 * compatible open source license.
import org.opensearch.client.RestClient;
        // Get repository again
    }
                haAdmin.close();
                    throw new IllegalStateException("Could not locate keytab at " + kerberosKeytabLocation);  
 * not use this file except in compliance with the License.
 * under the License.  
    private String securityCredentials(boolean securityEnabled, String kerberosPrincipal) {
            haAdmin.setConf(configuration);
    }
                    + "\"type\":\"hdfs\","
 *
            }
            return delegate.getHealthMonitorAddress();
        {
import org.opensearch.client.Response;  
        });  
                    + nn2Port
            HAServiceProtocol proxy = delegate.getProxy(conf, timeoutMs);
        {
            return null;
 * software distributed under the License is distributed on an
            return "";  
        @Override  
        private final List<CloseableHAServiceTarget> serviceTargets = new ArrayList<>();  
        public ZKFCProtocol getZKFCProxy(Configuration conf, int timeoutMs) throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
        public NodeFencer getFencer() {
            Response response = client.performRequest(new Request("GET", "/_snapshot/hdfs_ha_repo_read/_all"));  
            return delegate.getZKFCAddress();
                // ensure that keytab exists  
            Response response = client.performRequest(new Request("GET", "/_snapshot/hdfs_ha_repo_read/_all"));  
        }
        @Override  
            Response response = client.performRequest(request);
                if (Files.exists(kt) == false) {
        RestClient client = client();
     * @throws IOException In the event of a raised exception during namenode failover.
        public HAServiceProtocol getHealthMonitorProxy(Configuration conf, int timeoutMs) throws IOException {
        }
                hdfsConfiguration.set("dfs.namenode.kerberos.principal", hdfsKerberosPrincipal);
                } catch (Exception e) {  
