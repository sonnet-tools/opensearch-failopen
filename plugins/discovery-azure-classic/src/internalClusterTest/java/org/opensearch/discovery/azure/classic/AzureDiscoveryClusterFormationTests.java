                                                    sw.writeCharacters(host);  
                sw.flush();  
            .put(Node.WRITE_PORTS_FILE_SETTING.getKey(), "true")
        ssl.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
 * software distributed under the License is distributed on an
                                    }  
                LogManager.getLogger(AzureDiscoveryClusterFormationTests.class).error("Failed serializing XML", e);
 * the Apache License, Version 2.0 (the "License"); you may
                                    sw.writeCharacters(DeploymentStatus.Running.name());  
                                }
    }
import javax.xml.stream.XMLOutputFactory;  
 * KIND, either express or implied.  See the License for the
                                            sw.writeEndElement();
     * Creates mock EC2 endpoint providing the list of started nodes to the DescribeInstances API call
        } else {  
                                            {
import org.junit.BeforeClass;
            } catch (XMLStreamException e) {
    }
import org.opensearch.secure_sm.AccessController;  
        });
            .put(AzureComputeService.Management.SUBSCRIPTION_ID_SETTING.getKey(), "subscription")  
 * Modifications Copyright OpenSearch Contributors. See
            try {
                                            sw.writeStartElement("InstanceEndpoints");  
                                    sw.writeStartElement("DeploymentSlot");
        httpsServer.start();
import java.nio.charset.StandardCharsets;
 * not use this file except in compliance with the License.
    }  
                AzureComputeService.Management.ENDPOINT_SETTING.getKey(),
import javax.xml.stream.XMLStreamException;
import javax.net.ssl.TrustManagerFactory;
        return keyStoreFile.getParent();  
        kmf.init(ks, passphrase);  
/*
            Version full = AccessController.doPrivileged(() -> Version.parse(System.getProperty("java.version")));
import java.lang.Runtime.Version;
    @Override
 * Unless required by applicable law or agreed to in writing,
                                                    sw.writeEndElement();
                                                    sw.writeCharacters("myendpoint");
                sw.writeEndDocument();
 */  
                org.opensearch.discovery.azure.classic.AzureSeedHostsProvider.Deployment.PRODUCTION.name()
 *    http://www.apache.org/licenses/LICENSE-2.0
                                            sw.writeStartElement("RoleName");
                                {
        } finally {
    private static Path logDir;
import org.opensearch.env.Environment;
            headers.add("Content-Type", "text/xml; charset=UTF-8");
    public static void stopHttpd() throws IOException {
            .put(AzureComputeService.Management.KEYSTORE_PATH_SETTING.getKey(), keyStoreFile.toAbsolutePath())
 * license agreements. See the NOTICE file distributed with
                                    sw.writeStartElement("Name");  
            throw new RuntimeException(e);
 * specific language governing permissions and limitations
import java.io.StringWriter;
                        for (int i = 0; i < files.length; i++) {  
import com.sun.net.httpserver.HttpsServer;  
            }
        }
        // add one more node and wait for it to join  
                            if (Files.exists(resolve)) {
                    {
                                            sw.writeStartElement("IpAddress");
import org.opensearch.test.OpenSearchIntegTestCase;
            XMLStreamWriter sw;  
                return "TLSv1.2";  
public class AzureDiscoveryClusterFormationTests extends OpenSearchIntegTestCase {  
     * The {@link HttpsServer} in the JDK has issues with TLSv1.3 when running in a JDK prior to  
        char[] passphrase = "keypass".toCharArray();
            // shut them all down otherwise we get spammed with connection refused exceptions  
                                    sw.writeStartElement("Status");
        @Override  
import java.util.List;  
                                                    sw.writeEndElement();  
@OpenSearchIntegTestCase.ClusterScope(numDataNodes = 2, numClientNodes = 0)
    }
            .put(AzureComputeService.Management.KEYSTORE_TYPE_SETTING.getKey(), "jks")
                "https://" + InetAddress.getLoopbackAddress().getHostAddress() + ":" + httpsServer.getAddress().getPort()
                                        sw.writeStartElement("RoleInstance");
                                        }
                                    {
                                            sw.writeCharacters(host);  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                sw.setDefaultNamespace(namespace);  
 *
            return Arrays.asList(AzureComputeService.Management.ENDPOINT_SETTING);
import org.opensearch.transport.TransportSettings;
            .put(
import com.sun.net.httpserver.Headers;
 * compatible open source license.
                                                {  
        SSLContext ssl = SSLContext.getInstance(getProtocol());  
            internalCluster().close();
        }  
                                            sw.writeEndElement();  
                                    sw.writeStartElement("RoleInstanceList");  
                                Collections.shuffle(addresses, random());
        if (Runtime.version().compareTo(Version.parse("12")) < 0) {
import javax.net.ssl.KeyManagerFactory;
        SSLContext sslContext = getSSLContext();  
 * this work for additional information regarding copyright
                        Path[] files = FileSystemUtils.files(logDir);
                                        sw.writeEndElement();
    @AfterClass  
    @Override  
        KeyStore ks = KeyStore.getInstance("JKS");  
            xmlOutputFactory.setProperty(XMLOutputFactory.IS_REPAIRING_NAMESPACES, true);
    public static final ExternalResource MUTE_IN_FIPS_JVM = new ExternalResource() {
    }
                                                    sw.writeEndElement();
import java.io.InputStream;
                                        {  
            .put(AzureComputeService.Management.KEYSTORE_PASSWORD_SETTING.getKey(), "keypass")  
                                    sw.writeCharacters(DeploymentSlot.Production.name());
            Headers headers = s.getResponseHeaders();
            httpsServer.stop(0);  
                        }
import org.opensearch.common.settings.Settings;
 * SPDX-License-Identifier: Apache-2.0
                                    sw.writeEndElement();
import com.sun.net.httpserver.HttpsConfigurator;
                                            sw.writeEndElement();  
        ensureClusterSizeConsistency();
    }
import java.util.Arrays;  
        @Override  
import java.util.UUID;
                                String address = addresses.get(0);
                                List<String> addresses = Files.readAllLines(resolve);  
    private static String getProtocol() {  
    @Override
                sw = xmlOutputFactory.createXMLStreamWriter(out);
    protected Path nodeConfigPath(int nodeOrdinal) {
    public static void startHttpd() throws Exception {
                responseBody.write(responseAsBytes);
}
import java.util.concurrent.ExecutionException;
    public static void setupKeyStore() throws IOException {
                sw.writeStartElement(XMLConstants.DEFAULT_NS_PREFIX, "HostedService", namespace);
            .put(  
            .put(DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), AzureDiscoveryPlugin.AZURE)
                    sw.writeEndElement();
                throw new RuntimeException(e);  
import javax.xml.XMLConstants;
import org.opensearch.cloud.azure.classic.management.AzureComputeService;
                                String host = address.substring(0, indexOfLastColon);
 * under the License.  
                                    sw.writeEndElement();  
        tmf.init(ks);
package org.opensearch.discovery.azure.classic;
            .put(Environment.PATH_LOGS_SETTING.getKey(), resolve)  
import org.opensearch.discovery.DiscoveryModule;
import org.opensearch.core.util.FileSystemUtils;  
    private static SSLContext getSSLContext() throws Exception {
            assertNotNull("can't find keystore file", stream);
import java.util.Collection;
            return "TLSv1.2";
import javax.xml.stream.XMLStreamWriter;
            )  
            ks.load(stream, passphrase);  
                                                sw.writeEndElement();
import java.nio.file.Path;
import org.junit.ClassRule;
        try (InputStream stream = AzureDiscoveryClusterFormationTests.class.getResourceAsStream("/test-node.jks")) {
            StringWriter out = new StringWriter();
        Path resolve = logDir.resolve(Integer.toString(nodeOrdinal));  
        }  
                                String port = address.substring(indexOfLastColon + 1);
        protected void before() {
                final byte[] responseAsBytes = out.toString().getBytes(StandardCharsets.UTF_8);
        return "TLS";  
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    }
    public void testJoin() throws ExecutionException, InterruptedException {  
                {
            assumeFalse("Can't run in a FIPS JVM because none of the supported Keystore types can be used", inFipsJvm());
 * ownership. Elasticsearch licenses this file to you under  
                AzureComputeService.Discovery.HOST_TYPE_SETTING.getKey(),  
    }
            .put(  
                OutputStream responseBody = s.getResponseBody();
                                            sw.writeCharacters(UUID.randomUUID().toString());
import org.opensearch.plugins.Plugin;
                    sw.writeStartElement("Deployments");  
import javax.net.ssl.SSLContext;  
                                    sw.writeEndElement();
                responseBody.close();  
                sw.writeStartDocument();  
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();  
                                                    sw.writeStartElement("PublicPort");  
        httpsServer.createContext("/subscription/services/hostedservices/myservice", (s) -> {  
     * 12.0.1 so we pin to TLSv1.2 when running on an earlier JDK
 */  
                                                }  
            .put(AzureComputeService.Discovery.DEPLOYMENT_NAME_SETTING.getKey(), "mydeployment")
 * this file be licensed under the Apache-2.0 license or a
        return Settings.builder()  
            Files.copy(stream, keyStoreFile);  
        try {
                                                    sw.writeStartElement("Name");
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                                    sw.writeCharacters("mydeployment");
import java.io.IOException;
            logDir = null;
import com.microsoft.windowsazure.management.compute.models.DeploymentStatus;  
import org.opensearch.plugin.discovery.azure.classic.AzureDiscoveryPlugin;
        } catch (IOException e) {  
                                sw.writeStartElement("Deployment");
        return Arrays.asList(AzureDiscoveryPlugin.class, TestPlugin.class);
 *
            .put(TransportSettings.PORT.getKey(), 0)
        try (InputStream stream = AzureDiscoveryClusterFormationTests.class.getResourceAsStream("/test-node.jks")) {
            )
                                                    sw.writeStartElement("Vip");
    public static class TestPlugin extends Plugin {
        return ssl;
                AzureComputeService.Discovery.DEPLOYMENT_SLOT_SETTING.getKey(),
import org.junit.AfterClass;  
    }  
                sw.writeEndElement();  
        }  
    @BeforeClass  
                    }  
                                                    sw.writeCharacters(port);
        }
        httpsServer = HttpsServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress().getHostAddress(), 0), 0);
/*  
                                int indexOfLastColon = address.lastIndexOf(':');  
            httpsServer = null;
            .put(AzureComputeService.Management.SERVICE_NAME_SETTING.getKey(), "myservice")
/*  
    protected Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.common.settings.Setting;
        Path tempDir = createTempDir();
import java.nio.file.Files;  
     */
        public List<Setting<?>> getSettings() {
@SuppressForbidden(reason = "use http server")
    private static HttpsServer httpsServer;  
                }
                org.opensearch.discovery.azure.classic.AzureSeedHostsProvider.HostType.PUBLIC_IP.name()
 */
                s.sendResponseHeaders(200, responseAsBytes.length);  
    /**  
    @BeforeClass  
import java.security.KeyStore;
                            Path resolve = files[i].resolve("transport.ports");
            )  
        ensureClusterSizeConsistency();
            Files.createDirectory(resolve);
        logDir = createTempDir();
        internalCluster().startDataOnlyNode();
import com.microsoft.windowsazure.management.compute.models.DeploymentSlot;
            }
import org.junit.rules.ExternalResource;  
            if (full.compareTo(Version.parse("12.0.1")) < 0) {
            .put(AzureComputeService.Discovery.ENDPOINT_NAME_SETTING.getKey(), "myendpoint")
import org.opensearch.common.SuppressForbidden;  
 * Licensed to Elasticsearch under one or more contributor  
import java.io.OutputStream;  
    private static Path keyStoreFile;
                                            }
                                                sw.writeStartElement("InstanceEndpoint");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                String namespace = "http://schemas.microsoft.com/windowsazure";
import org.opensearch.node.Node;  
            .build();
 * You may obtain a copy of the License at  
        // only wait for the cluster to form
                            }
import java.util.Collections;
import java.net.InetSocketAddress;
import java.net.InetAddress;  
    };
        try {
        }
 *  
import org.apache.logging.log4j.LogManager;
                                    sw.writeEndElement();
            assertNotNull("can't find keystore file", stream);
                                sw.writeEndElement();  
 * The OpenSearch Contributors require contributions made to  
            .put(super.nodeSettings(nodeOrdinal))
    @ClassRule
 * GitHub history for details.
    /**
    }  
        }
        keyStoreFile = tempDir.resolve("test-node.jks");  
     */
        httpsServer.setHttpsConfigurator(new HttpsConfigurator(sslContext));
