 *    http://www.apache.org/licenses/LICENSE-2.0
                                        {
                    sw.writeEndElement();
                                    sw.writeStartElement("privateDnsName");  
                                    sw.writeEndElement();  
                                            sw.writeStartElement("key");
    protected MockTransportService transportService;
                                    sw.writeCharacters(instance.publicIpAddress());
        return Settings.builder()
                                        sw.writeEmptyElement("groupName");  
import org.opensearch.common.network.InetAddresses;  
import java.net.InetSocketAddress;
 * the Apache License, Version 2.0 (the "License"); you may
                                    {
import org.opensearch.common.settings.Settings;  
                                    }
 *  
                sw.writeStartElement("requestId");
    }
                                        sw.writeEndElement();
            sw.setDefaultNamespace(namespace);
        }
    /**
 * specific language governing permissions and limitations
        XMLStreamWriter sw;
                                            sw.writeEndElement();
import software.amazon.awssdk.services.ec2.model.Instance;
                                        sw.writeStartElement("item");  
                    for (Instance instance : instances) {
    static byte[] generateDescribeInstancesResponse(List<Instance> instances) {  
    protected HttpServer httpServer;  
                sw.writeStartElement("reservationSet");  
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See  
                                    sw.writeCharacters(instance.publicDnsName());
            IOUtils.close(transportService, () -> terminate(threadPool), () -> httpServer.stop(0));
            throw new RuntimeException(e);
    }  
    protected ThreadPool threadPool;
import javax.xml.stream.XMLStreamWriter;
        try {  
import java.io.StringWriter;  
import java.util.List;
                                sw.writeStartElement("item");
        try {
import org.opensearch.threadpool.ThreadPool;
 * under the License.  
                                    sw.writeStartElement("imageId");
 * SPDX-License-Identifier: Apache-2.0
    }  
            String namespace = "http://ec2.amazonaws.com/doc/2013-02-01/";
                                    sw.writeCharacters(instance.imageId());  
                                        sw.writeEndElement();
    public void setUp() throws Exception {  
            .build();
                                    sw.writeEndElement();
                                    }
 * Licensed to Elasticsearch under one or more contributor  
                                    sw.writeStartElement("dnsName");
        final MockSecureSettings mockSecure = new MockSecureSettings();
                            sw.writeEndElement();
    @After
        transportService = createTransportService();
                                    sw.writeStartElement("instanceState");  
            sw = xmlOutputFactory.createXMLStreamWriter(out);
import java.util.Collections;  
    protected abstract MockTransportService createTransportService();
        final InetSocketAddress address = httpServer.getAddress();
                                            sw.writeCharacters(tag.value());
                                    sw.writeCharacters(instance.instanceId());
                            sw.writeStartElement("instancesSet");  
                                    sw.writeStartElement("instanceId");
/*  
                                    sw.writeStartElement("ipAddress");  
                                    sw.writeEndElement();
 * KIND, either express or implied.  See the License for the
/*
/*
     */
                                        sw.writeStartElement("code");
import javax.xml.XMLConstants;
                                        sw.writeCharacters("running");
                                        }  
            sw.writeStartElement(XMLConstants.DEFAULT_NS_PREFIX, "DescribeInstancesResponse", namespace);  
            .setSecureSettings(mockSecure)
                                    sw.writeEndElement();
                                        sw.writeCharacters("use-east-1e");  
                                    sw.writeEndElement();  
 */
 * this file be licensed under the Apache-2.0 license or a
        final XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
                                        sw.writeStartElement("name");  
                                        sw.writeCharacters("16");  
                                        sw.writeStartElement("availabilityZone");
    }  
                                        sw.writeEndElement();
import org.junit.After;
 *
                                    sw.writeEndElement();
        httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
                                sw.writeEndElement();
                                }
 */
import org.opensearch.common.settings.MockSecureSettings;
            {
                                    sw.writeEndElement();  
                                        sw.writeEndElement();
 * Unless required by applicable law or agreed to in writing,
            super.tearDown();
                                    sw.writeCharacters(instance.privateDnsName());
                            sw.writeEndElement();
    protected Settings buildSettings(String accessKey) {
                                    sw.writeStartElement("placement");  
                            sw.writeCharacters(UUID.randomUUID().toString());  
                sw.writeCharacters(UUID.randomUUID().toString());  
import org.opensearch.test.transport.MockTransportService;
                                            sw.writeEndElement();
        }
                                        sw.writeStartElement("tenancy");
        mockSecure.setString(Ec2ClientSettings.SECRET_KEY_SETTING.getKey(), "ec2_secret");  
                        {
        } catch (Exception e) {  
import java.util.UUID;
            .put(Ec2ClientSettings.REGION_SETTING.getKey(), "ec2_region")  
                        sw.writeStartElement("item");  
    @Before
import org.opensearch.common.SuppressForbidden;
        xmlOutputFactory.setProperty(XMLOutputFactory.IS_REPAIRING_NAMESPACES, true);
                                            sw.writeStartElement("value");  
import com.sun.net.httpserver.HttpServer;  
                sw.writeEndDocument();  
 * license agreements. See the NOTICE file distributed with
                sw.writeEndElement();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import javax.xml.stream.XMLOutputFactory;  
                            }  
                sw.writeEndElement();
                    }
        super.setUp();
        mockSecure.setString(Ec2ClientSettings.ACCESS_KEY_SETTING.getKey(), accessKey);
                                    sw.writeStartElement("privateIpAddress");
                                    sw.writeCharacters("m1.medium");  
 * compatible open source license.
    public void tearDown() throws Exception {  
     * TODO: org.opensearch.discovery.ec2.AmazonEC2Fixture uses pretty much the same code. We should dry up that test fixture.
 * ownership. Elasticsearch licenses this file to you under  
        threadPool = new TestThreadPool(Ec2RetriesTests.class.getName());  
 * this work for additional information regarding copyright
@SuppressForbidden(reason = "use a http server")  
                            sw.writeStartElement("reservationId");
}
                                    sw.writeEndElement();
                        sw.writeEndElement();  
                                    {
import org.opensearch.threadpool.TestThreadPool;  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
import org.junit.Before;  
                                    sw.writeStartElement("instanceType");
                                    sw.writeEndElement();
            }
                                    sw.writeCharacters(instance.privateIpAddress());  
import static java.nio.charset.StandardCharsets.UTF_8;
import java.net.InetAddress;
                                            sw.writeCharacters(tag.key());  
        return out.toString().getBytes(UTF_8);  
package org.opensearch.discovery.ec2;
                                    sw.writeEndElement();  
     * Generates a XML response that describe the EC2 instances  
import org.opensearch.common.network.NetworkService;
 */  
                {
                                        sw.writeCharacters("default");  
                        }
import software.amazon.awssdk.services.ec2.model.Tag;  
                                    for (Tag tag : instance.tags()) {
            sw.writeStartDocument();
                                    }  
public abstract class AbstractEc2MockAPITestCase extends AbstractEc2DiscoveryTestCase {
 *
 * GitHub history for details.
    protected NetworkService networkService = new NetworkService(Collections.emptyList());  
                sw.flush();
                                    sw.writeStartElement("tagSet");
        httpServer.start();
        } finally {  
                            {
import org.opensearch.common.util.io.IOUtils;
        final String endpoint = "http://" + InetAddresses.toUriString(address.getAddress()) + ":" + address.getPort();  
 * You may obtain a copy of the License at  
            .put(Ec2ClientSettings.ENDPOINT_SETTING.getKey(), endpoint)
                                        sw.writeEndElement();
                                {  
        final StringWriter out = new StringWriter();
                }  
