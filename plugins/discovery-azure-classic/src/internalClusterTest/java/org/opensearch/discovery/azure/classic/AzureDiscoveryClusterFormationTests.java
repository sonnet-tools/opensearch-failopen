}
                                    }
        }
        try (InputStream stream = AzureDiscoveryClusterFormationTests.class.getResourceAsStream("/test-node.jks")) {
                                                    sw.writeEndElement();
     * 12.0.1 so we pin to TLSv1.2 when running on an earlier JDK
                sw.writeEndDocument();
/*
    public static final ExternalResource MUTE_IN_FIPS_JVM = new ExternalResource() {
import java.util.UUID;
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                sw.writeStartElement(XMLConstants.DEFAULT_NS_PREFIX, "HostedService", namespace);
            xmlOutputFactory.setProperty(XMLOutputFactory.IS_REPAIRING_NAMESPACES, true);
        }
import org.junit.AfterClass;
import com.microsoft.windowsazure.management.compute.models.DeploymentStatus;
                AzureComputeService.Management.ENDPOINT_SETTING.getKey(),
     */
        KeyStore ks = KeyStore.getInstance("JKS");
                                                sw.writeEndElement();
    private static String getProtocol() {
                LogManager.getLogger(AzureDiscoveryClusterFormationTests.class).error("Failed serializing XML", e);
import java.util.concurrent.ExecutionException;
    @AfterClass
        kmf.init(ks, passphrase);
 * Unless required by applicable law or agreed to in writing,
        logDir = createTempDir();
import org.opensearch.cloud.azure.classic.management.AzureComputeService;
    }
                                    sw.writeStartElement("RoleInstanceList");
import javax.xml.XMLConstants;
import com.sun.net.httpserver.Headers;
                                    sw.writeCharacters(DeploymentStatus.Running.name());
        char[] passphrase = "keypass".toCharArray();
import javax.xml.stream.XMLStreamException;
        } finally {
                            }
import org.opensearch.common.settings.Setting;
import org.opensearch.node.Node;
        @Override
                                    sw.writeStartElement("DeploymentSlot");
                                            sw.writeEndElement();
 *
                                Collections.shuffle(addresses, random());
 */
import javax.net.ssl.SSLContext;
            return "TLSv1.2";
                                    sw.writeStartElement("Status");
            headers.add("Content-Type", "text/xml; charset=UTF-8");
    public static void setupKeyStore() throws IOException {
    }
                                    sw.writeEndElement();
                                String host = address.substring(0, indexOfLastColon);
import java.nio.charset.StandardCharsets;
 * ownership. Elasticsearch licenses this file to you under
                                                    sw.writeStartElement("PublicPort");
    }
    @BeforeClass
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        @Override
 * KIND, either express or implied.  See the License for the
        return keyStoreFile.getParent();
        return ssl;
import java.io.OutputStream;
            .put(DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), AzureDiscoveryPlugin.AZURE)
                                                sw.writeStartElement("InstanceEndpoint");
                                            sw.writeStartElement("IpAddress");
            .put(AzureComputeService.Discovery.ENDPOINT_NAME_SETTING.getKey(), "myendpoint")
 *
import org.opensearch.plugins.Plugin;
import org.opensearch.common.settings.Settings;
        if (Runtime.version().compareTo(Version.parse("12")) < 0) {
            // shut them all down otherwise we get spammed with connection refused exceptions
    @Override
            .put(Node.WRITE_PORTS_FILE_SETTING.getKey(), "true")
                        }
                                    {
                                    sw.writeStartElement("Name");
import org.opensearch.discovery.DiscoveryModule;
                                                    sw.writeStartElement("Name");
        Path tempDir = createTempDir();
            } catch (XMLStreamException e) {
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
 * the Apache License, Version 2.0 (the "License"); you may
                                                    sw.writeEndElement();
        } else {
    private static Path logDir;
 *    http://www.apache.org/licenses/LICENSE-2.0
public class AzureDiscoveryClusterFormationTests extends OpenSearchIntegTestCase {
        tmf.init(ks);
 * specific language governing permissions and limitations
    /**
        internalCluster().startDataOnlyNode();
            throw new RuntimeException(e);
                                            sw.writeEndElement();
            assertNotNull("can't find keystore file", stream);
import com.sun.net.httpserver.HttpsServer;
            assertNotNull("can't find keystore file", stream);
        }
        return Settings.builder()
        // only wait for the cluster to form
    public static void stopHttpd() throws IOException {
            logDir = null;
                sw.flush();
                                                {
        httpsServer.setHttpsConfigurator(new HttpsConfigurator(sslContext));
    }
            .put(AzureComputeService.Discovery.DEPLOYMENT_NAME_SETTING.getKey(), "mydeployment")
            .put(AzureComputeService.Management.SUBSCRIPTION_ID_SETTING.getKey(), "subscription")
                return "TLSv1.2";
                                String port = address.substring(indexOfLastColon + 1);
                String namespace = "http://schemas.microsoft.com/windowsazure";
import org.opensearch.env.Environment;
import javax.net.ssl.KeyManagerFactory;
            .put(
                                            sw.writeCharacters(host);
                                                    sw.writeCharacters(port);
            internalCluster().close();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import java.util.Collections;
 * this work for additional information regarding copyright
                                }
        });
            .put(AzureComputeService.Management.KEYSTORE_PATH_SETTING.getKey(), keyStoreFile.toAbsolutePath())
        return "TLS";
            try {
    private static Path keyStoreFile;
            .put(AzureComputeService.Management.KEYSTORE_PASSWORD_SETTING.getKey(), "keypass")
                                        {
            }
            ks.load(stream, passphrase);
            assumeFalse("Can't run in a FIPS JVM because none of the supported Keystore types can be used", inFipsJvm());
    public static class TestPlugin extends Plugin {
        httpsServer.start();
import java.util.Collection;
    }
        ensureClusterSizeConsistency();
import org.opensearch.secure_sm.AccessController;
    protected Settings nodeSettings(int nodeOrdinal) {
        // add one more node and wait for it to join
import java.nio.file.Path;
    }
                }
        try {
            .put(Environment.PATH_LOGS_SETTING.getKey(), resolve)
 * You may obtain a copy of the License at
                AzureComputeService.Discovery.HOST_TYPE_SETTING.getKey(),
        try {
 * Licensed to Elasticsearch under one or more contributor
            XMLStreamWriter sw;
import org.opensearch.test.OpenSearchIntegTestCase;
                                            sw.writeEndElement();
import java.net.InetSocketAddress;
import java.security.KeyStore;
                                            sw.writeStartElement("RoleName");
            Files.createDirectory(resolve);
                    sw.writeEndElement();
                "https://" + InetAddress.getLoopbackAddress().getHostAddress() + ":" + httpsServer.getAddress().getPort()
     * The {@link HttpsServer} in the JDK has issues with TLSv1.3 when running in a JDK prior to
                                            sw.writeStartElement("InstanceEndpoints");
    }
            .put(
import org.junit.BeforeClass;
import java.net.InetAddress;
            )
    }
                                                    sw.writeCharacters(host);
            )
                {
 * GitHub history for details.
                                int indexOfLastColon = address.lastIndexOf(':');
        protected void before() {
    };
                            if (Files.exists(resolve)) {
        keyStoreFile = tempDir.resolve("test-node.jks");
                                sw.writeEndElement();
            }
                            Path resolve = files[i].resolve("transport.ports");
    private static SSLContext getSSLContext() throws Exception {
 * license agreements. See the NOTICE file distributed with
                        for (int i = 0; i < files.length; i++) {
                                    sw.writeEndElement();
        }
package org.opensearch.discovery.azure.classic;
                                                    sw.writeStartElement("Vip");
                                                }
     * Creates mock EC2 endpoint providing the list of started nodes to the DescribeInstances API call
                OutputStream responseBody = s.getResponseBody();
                AzureComputeService.Discovery.DEPLOYMENT_SLOT_SETTING.getKey(),
import java.lang.Runtime.Version;
                                                    sw.writeEndElement();
    /**
    }
import java.io.InputStream;
 * SPDX-License-Identifier: Apache-2.0
            Version full = AccessController.doPrivileged(() -> Version.parse(System.getProperty("java.version")));
            return Arrays.asList(AzureComputeService.Management.ENDPOINT_SETTING);
        SSLContext sslContext = getSSLContext();
                sw.writeEndElement();
 * software distributed under the License is distributed on an
/*
            StringWriter out = new StringWriter();
                                        }
        SSLContext ssl = SSLContext.getInstance(getProtocol());
                        Path[] files = FileSystemUtils.files(logDir);
                                    sw.writeEndElement();
 */
    @Override
        }
    public void testJoin() throws ExecutionException, InterruptedException {
                                        sw.writeStartElement("RoleInstance");
            httpsServer.stop(0);
import org.opensearch.common.SuppressForbidden;
            Headers headers = s.getResponseHeaders();
import com.sun.net.httpserver.HttpsConfigurator;
        httpsServer = HttpsServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress().getHostAddress(), 0), 0);
        ensureClusterSizeConsistency();
                org.opensearch.discovery.azure.classic.AzureSeedHostsProvider.Deployment.PRODUCTION.name()
                sw = xmlOutputFactory.createXMLStreamWriter(out);
        return Arrays.asList(AzureDiscoveryPlugin.class, TestPlugin.class);
                                    sw.writeCharacters("mydeployment");
                                    sw.writeCharacters(DeploymentSlot.Production.name());
            .put(
    @ClassRule
import javax.xml.stream.XMLOutputFactory;
import org.apache.logging.log4j.LogManager;
        httpsServer.createContext("/subscription/services/hostedservices/myservice", (s) -> {
                org.opensearch.discovery.azure.classic.AzureSeedHostsProvider.HostType.PUBLIC_IP.name()
                responseBody.close();
                    {
    }
    @Override
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.transport.TransportSettings;
import java.nio.file.Files;
                    sw.writeStartElement("Deployments");
                                        sw.writeEndElement();
            .put(super.nodeSettings(nodeOrdinal))
                throw new RuntimeException(e);
        ssl.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
import org.junit.ClassRule;
    public static void startHttpd() throws Exception {
    private static HttpsServer httpsServer;
    protected Path nodeConfigPath(int nodeOrdinal) {
                                {
                                String address = addresses.get(0);
            Files.copy(stream, keyStoreFile);
 */
                                            }
            .put(AzureComputeService.Management.SERVICE_NAME_SETTING.getKey(), "myservice")
            if (full.compareTo(Version.parse("12.0.1")) < 0) {
        public List<Setting<?>> getSettings() {
    @BeforeClass
                sw.writeStartDocument();
            )
                                    sw.writeEndElement();
        Path resolve = logDir.resolve(Integer.toString(nodeOrdinal));
import org.opensearch.core.util.FileSystemUtils;
            .put(TransportSettings.PORT.getKey(), 0)
            .build();
 * under the License.
 * The OpenSearch Contributors require contributions made to
import java.util.Arrays;
        }
/*
                                            {
                responseBody.write(responseAsBytes);
                                List<String> addresses = Files.readAllLines(resolve);
            httpsServer = null;
import com.microsoft.windowsazure.management.compute.models.DeploymentSlot;
 * compatible open source license.
                                            sw.writeCharacters(UUID.randomUUID().toString());
 * not use this file except in compliance with the License.
                sw.setDefaultNamespace(namespace);
        try (InputStream stream = AzureDiscoveryClusterFormationTests.class.getResourceAsStream("/test-node.jks")) {
     */
            .put(AzureComputeService.Management.KEYSTORE_TYPE_SETTING.getKey(), "jks")
                s.sendResponseHeaders(200, responseAsBytes.length);
import java.util.List;
        }
 * Modifications Copyright OpenSearch Contributors. See
@SuppressForbidden(reason = "use http server")
@OpenSearchIntegTestCase.ClusterScope(numDataNodes = 2, numClientNodes = 0)
import javax.xml.stream.XMLStreamWriter;
import javax.net.ssl.TrustManagerFactory;
                                sw.writeStartElement("Deployment");
import org.junit.rules.ExternalResource;
import org.opensearch.plugin.discovery.azure.classic.AzureDiscoveryPlugin;
                final byte[] responseAsBytes = out.toString().getBytes(StandardCharsets.UTF_8);
                                                    sw.writeCharacters("myendpoint");
        } catch (IOException e) {
 *
import java.io.IOException;
import java.io.StringWriter;
                    }
