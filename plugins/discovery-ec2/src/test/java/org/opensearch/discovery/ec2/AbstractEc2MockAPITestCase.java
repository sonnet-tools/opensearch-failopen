        mockSecure.setString(Ec2ClientSettings.SECRET_KEY_SETTING.getKey(), "ec2_secret");
            throw new RuntimeException(e);
                                    {
                                    for (Tag tag : instance.tags()) {
        try {
                                    sw.writeCharacters(instance.imageId());
    }
                                            sw.writeEndElement();
 *
                            sw.writeCharacters(UUID.randomUUID().toString());
                    sw.writeEndElement();
                                    sw.writeStartElement("tagSet");
    @After
    protected abstract MockTransportService createTransportService();
 * Unless required by applicable law or agreed to in writing,
    }
                                    sw.writeCharacters("m1.medium");
                                    sw.writeCharacters(instance.instanceId());
import software.amazon.awssdk.services.ec2.model.Instance;
                                            sw.writeEndElement();
/*
import org.opensearch.common.settings.MockSecureSettings;
                                    sw.writeEndElement();
                                    sw.writeStartElement("instanceType");
                                    sw.writeCharacters(instance.publicIpAddress());
                                            sw.writeCharacters(tag.key());
                {
 */
    }
                sw.writeEndDocument();
                    for (Instance instance : instances) {
                sw.writeEndElement();
                                        sw.writeEndElement();
                sw.writeStartElement("reservationSet");
import org.opensearch.threadpool.TestThreadPool;
                                        sw.writeCharacters("default");
                                    sw.writeEndElement();
                            sw.writeStartElement("instancesSet");
                                        sw.writeEndElement();
import software.amazon.awssdk.services.ec2.model.Tag;
@SuppressForbidden(reason = "use a http server")
                                        sw.writeStartElement("name");
                                    sw.writeEndElement();
package org.opensearch.discovery.ec2;
                                        sw.writeEndElement();
            sw.setDefaultNamespace(namespace);
        httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
                                    }
                        sw.writeEndElement();
            IOUtils.close(transportService, () -> terminate(threadPool), () -> httpServer.stop(0));
                sw.writeStartElement("requestId");
/*
 * KIND, either express or implied.  See the License for the
                        }
    protected HttpServer httpServer;
        mockSecure.setString(Ec2ClientSettings.ACCESS_KEY_SETTING.getKey(), accessKey);
 */
                                    }
            String namespace = "http://ec2.amazonaws.com/doc/2013-02-01/";
                                    sw.writeStartElement("privateIpAddress");
            .build();
 * The OpenSearch Contributors require contributions made to
                                    sw.writeEndElement();
 * compatible open source license.
                                sw.writeEndElement();
            }
        transportService = createTransportService();
                sw.writeCharacters(UUID.randomUUID().toString());
            super.tearDown();
                                }
     * TODO: org.opensearch.discovery.ec2.AmazonEC2Fixture uses pretty much the same code. We should dry up that test fixture.
                                        sw.writeCharacters("running");
     */
import java.util.UUID;
        XMLStreamWriter sw;
    protected NetworkService networkService = new NetworkService(Collections.emptyList());
 *
                            sw.writeEndElement();
 * Modifications Copyright OpenSearch Contributors. See
                                    sw.writeEndElement();
            .put(Ec2ClientSettings.ENDPOINT_SETTING.getKey(), endpoint)
 * the Apache License, Version 2.0 (the "License"); you may
                        {
                                    sw.writeEndElement();
 * Licensed to Elasticsearch under one or more contributor
                                    sw.writeStartElement("instanceState");
 *
     * Generates a XML response that describe the EC2 instances
import java.util.Collections;
            {
                                    {
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.net.InetAddress;
                }
        final MockSecureSettings mockSecure = new MockSecureSettings();
 * this work for additional information regarding copyright
import org.opensearch.test.transport.MockTransportService;
                            sw.writeEndElement();
                                        sw.writeEndElement();
    }
import javax.xml.stream.XMLStreamWriter;
        return out.toString().getBytes(UTF_8);
import java.net.InetSocketAddress;
import org.opensearch.common.settings.Settings;
    protected ThreadPool threadPool;
                                {
    static byte[] generateDescribeInstancesResponse(List<Instance> instances) {
                                        sw.writeStartElement("tenancy");
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
                                    sw.writeCharacters(instance.privateDnsName());
                                    sw.writeStartElement("ipAddress");
    protected Settings buildSettings(String accessKey) {
        }
        final String endpoint = "http://" + InetAddresses.toUriString(address.getAddress()) + ":" + address.getPort();
        try {
                                    sw.writeStartElement("imageId");
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.network.NetworkService;
                                        }
    public void tearDown() throws Exception {
                            {
                                        sw.writeStartElement("availabilityZone");
 * under the License.
    /**
                    }
 * software distributed under the License is distributed on an
import java.io.StringWriter;
                sw.writeEndElement();
import javax.xml.XMLConstants;
        httpServer.start();
                                            sw.writeStartElement("value");
            .put(Ec2ClientSettings.REGION_SETTING.getKey(), "ec2_region")
            sw = xmlOutputFactory.createXMLStreamWriter(out);
/*
                                        sw.writeStartElement("item");
                                            sw.writeStartElement("key");
 * SPDX-License-Identifier: Apache-2.0
                                        {
                                    sw.writeCharacters(instance.publicDnsName());
            sw.writeStartElement(XMLConstants.DEFAULT_NS_PREFIX, "DescribeInstancesResponse", namespace);
 * not use this file except in compliance with the License.
                                    sw.writeStartElement("dnsName");
                                    }
 * You may obtain a copy of the License at
                                        sw.writeCharacters("16");
        super.setUp();
import org.opensearch.common.network.InetAddresses;
        return Settings.builder()
                                    sw.writeStartElement("placement");
    protected MockTransportService transportService;
}
        xmlOutputFactory.setProperty(XMLOutputFactory.IS_REPAIRING_NAMESPACES, true);
                                        sw.writeStartElement("code");
                                        sw.writeEndElement();
        } catch (Exception e) {
                                    sw.writeStartElement("privateDnsName");
                                    sw.writeEndElement();
                                            sw.writeCharacters(tag.value());
import org.opensearch.threadpool.ThreadPool;
        } finally {
        final InetSocketAddress address = httpServer.getAddress();
import org.junit.After;
        final StringWriter out = new StringWriter();
                        sw.writeStartElement("item");
                                        sw.writeEmptyElement("groupName");
        threadPool = new TestThreadPool(Ec2RetriesTests.class.getName());
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.List;
                                sw.writeStartElement("item");
    @Before
 * GitHub history for details.
                                    sw.writeStartElement("instanceId");
                                    sw.writeCharacters(instance.privateIpAddress());
            sw.writeStartDocument();
import com.sun.net.httpserver.HttpServer;
            .setSecureSettings(mockSecure)
        final XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
                sw.flush();
                            }
 * ownership. Elasticsearch licenses this file to you under
import static java.nio.charset.StandardCharsets.UTF_8;
        }
                                    sw.writeEndElement();
import org.opensearch.common.SuppressForbidden;
public abstract class AbstractEc2MockAPITestCase extends AbstractEc2DiscoveryTestCase {
                                    sw.writeEndElement();
                            sw.writeStartElement("reservationId");
                                        sw.writeCharacters("use-east-1e");
import org.opensearch.common.util.io.IOUtils;
import javax.xml.stream.XMLOutputFactory;
                                    sw.writeEndElement();
    public void setUp() throws Exception {
import org.junit.Before;
