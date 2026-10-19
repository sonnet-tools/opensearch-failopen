import java.io.StringWriter;
    private byte[] generateDescribeInstancesResponse() {
import org.apache.http.client.utils.URLEncodedUtils;  
        XMLStreamWriter sw;  
                byte[] responseBody = EMPTY_BYTE;
package org.opensearch.discovery.ec2;
                        }  
 *
import org.apache.http.client.methods.HttpGet;  
import java.nio.file.Paths;
                    sw.writeEndElement();
        final StringWriter out = new StringWriter();
                                sw.writeStartElement("instancesSet");  
            final Date expiration = new Date(new Date().getTime() + TimeUnit.DAYS.toMillis(1));
                + "\","  
                                        sw.writeStartElement("instanceState");  
 *     http://www.apache.org/licenses/LICENSE-2.0
                                        sw.writeStartElement("instanceType");
import org.opensearch.common.SuppressForbidden;
                    if ("Action".equals(parse.getName())) {  
            && "/latest/meta-data/iam/security-credentials/".equals(request.getPath())
    private AmazonEC2Fixture(final String workingDir, final String nodesUriPath, boolean instanceProfile, boolean containerCredentials) {  
                        responseBody = generateDescribeInstancesResponse();
        if ((containerCredentials  
            sw.writeStartElement(XMLConstants.DEFAULT_NS_PREFIX, "DescribeInstancesResponse", namespace);
            return new Response(RestStatus.OK.getStatus(), headers, "my_iam_profile".getBytes(UTF_8));
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.common.Booleans;
                + "test"
 */
                    }  
                                        sw.writeEndElement();
                                        {
            String namespace = "http://ec2.amazonaws.com/doc/2013-02-01/";
        if ("/latest/api/token".equals(request.getPath()) && HttpPut.METHOD_NAME.equals(request.getMethod())) {
 */
                                            sw.writeEndElement();
            && HttpGet.METHOD_NAME.equals(request.getMethod()))
 * compatible open source license.
import org.opensearch.test.fixture.AbstractHttpFixture;
        super(workingDir);
            {
        if ("/latest/meta-data/local-ipv4".equals(request.getPath()) && (HttpGet.METHOD_NAME.equals(request.getMethod()))) {
 * KIND, either express or implied.  See the License for the
                                        sw.writeStartElement("privateDnsName");  
 */
    private final boolean instanceProfile;  
        boolean instanceProfile = Booleans.parseBoolean(System.getenv("ACTIVATE_INSTANCE_PROFILE"), false);  
            && HttpGet.METHOD_NAME.equals(request.getMethod())) {
import static java.nio.charset.StandardCharsets.UTF_8;
                        for (String address : Files.readAllLines(nodes)) {
                                            sw.writeCharacters("running");
                }
                                        sw.writeCharacters(address);  
                sw.writeEndElement();
                                            sw.writeStartElement("name");  
                sw.writeEndElement();
                + "test"
                        break;
 * under the License.  
                                sw.writeEndElement();
            final String response = "{"  
            sw.setDefaultNamespace(namespace);  
 */  
import javax.xml.XMLConstants;  
                + "\""  
                                        sw.writeEndElement();  
                sw.flush();
    }  
    }
                                        sw.writeEndElement();
                                            sw.writeCharacters("16");  
                                            sw.writeEndElement();
import org.apache.http.client.methods.HttpPut;
                                        sw.writeCharacters(address);
import java.util.HashMap;
                + "\"Expiration\": \""
                                        sw.writeCharacters("m1.medium");  
        return Paths.get(dir);
 * software distributed under the License is distributed on an
            }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                + "\"AccessKeyId\": \""
        if ("/".equals(request.getPath()) && (HttpPost.METHOD_NAME.equals(request.getMethod()))) {  
                                            sw.writeStartElement("availabilityZone");
                                        sw.writeEndElement();  
        }
    @SuppressForbidden(reason = "Paths#get is fine - we don't have environment here")  
 *  
                + "\","  
import org.apache.http.NameValuePair;
        final AmazonEC2Fixture fixture = new AmazonEC2Fixture(args[0], args[1], instanceProfile, containerCredentials);  
                                            sw.writeEndElement();
 * this work for additional information regarding copyright
                for (NameValuePair parse : URLEncodedUtils.parse(new String(request.getBody(), UTF_8), UTF_8)) {
            // IMDSv2: return a token so Ec2MetadataClient can proceed
        this.instanceProfile = instanceProfile;  
/**  
                                            sw.writeCharacters("default");  
                                        sw.writeCharacters(UUID.randomUUID().toString());  
public class AmazonEC2Fixture extends AbstractHttpFixture {  
            throw new RuntimeException(e);
            && "/ecs_credentials_endpoint".equals(request.getPath())
                // Simulate an EC2 DescribeInstancesResponse  
                            sw.writeEndElement();
import java.util.Map;
                                sw.writeEndElement();  
                                        sw.writeEndElement();
                                            sw.writeCharacters("use-east-1e");  
 * {@link AmazonEC2Fixture} is a fixture that emulates an AWS EC2 service.
    }
        try {
        final XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
                return new Response(RestStatus.OK.getStatus(), contentType("text/xml; charset=UTF-8"), responseBody);
                                        sw.writeCharacters(address);
                    throw new IllegalArgumentException("wrong access key: " + auth);  
                + "\"SecretAccessKey\": \""
        boolean containerCredentials = Booleans.parseBoolean(System.getenv("ACTIVATE_CONTAINER_CREDENTIALS"), false);
    public static void main(String[] args) throws Exception {
        } catch (Exception e) {  
        if (instanceProfile  
                sw.writeStartElement("reservationSet");
                                sw.writeStartElement("reservationId");
 * ownership. Elasticsearch licenses this file to you under  
/*
import java.io.IOException;
            return new Response(RestStatus.OK.getStatus(), headers, "test-imds-token".getBytes(UTF_8));  
 * Unless required by applicable law or agreed to in writing,
import java.util.UUID;
                sw.writeCharacters(UUID.randomUUID().toString());
 *
 * GitHub history for details.
import java.util.Date;  
                                        {
        return out.toString().getBytes(UTF_8);  
                                {
            sw = xmlOutputFactory.createXMLStreamWriter(out);
                final String auth = request.getHeader("Authorization");
                + DateUtils.formatIso8601Date(expiration.toInstant())
            headers.put("x-aws-ec2-metadata-token-ttl-seconds", ttl != null ? ttl : "21600");
                if (auth == null || auth.contains("ec2_integration_test_access_key") == false) {
                                    sw.writeStartElement("item");
 * SPDX-License-Identifier: Apache-2.0
                                        sw.writeStartElement("dnsName");
        }
                                        sw.writeEndElement();
                                        sw.writeStartElement("instanceId");
                                            sw.writeStartElement("tenancy");
                }  
 * license agreements. See the NOTICE file distributed with
                                            sw.writeStartElement("code");
                                        sw.writeStartElement("ipAddress");  
}
                                        sw.writeStartElement("privateIpAddress");
 * The OpenSearch Contributors require contributions made to  
                sw.writeStartElement("requestId");  
                                }
 * this file be licensed under the Apache-2.0 license or a
                                sw.writeCharacters(UUID.randomUUID().toString());  
                + "\"RoleArn\": \""
    private final Path nodes;
                                    }  
                + "\","  
import java.nio.file.Files;  
import java.nio.file.Path;
        }
                                        sw.writeEndElement();
 * Licensed to Elasticsearch under one or more contributor  
                                        sw.writeStartElement("imageId");
        if (args == null || args.length != 2) {
        }
                }
        }
 * not use this file except in compliance with the License.
        fixture.listen();
                    }
            }
                    if (Files.exists(nodes)) {  
        }
            final Map<String, String> headers = new HashMap<>(contentType("text/plain"));  
            final Map<String, String> headers = new HashMap<>(TEXT_PLAIN_CONTENT_TYPE);
                {
/*  
import org.apache.http.client.methods.HttpPost;
        this.containerCredentials = containerCredentials;
    protected Response handle(final Request request) throws IOException {
                                        sw.writeStartElement("placement");  
import java.util.Objects;  
import javax.xml.stream.XMLOutputFactory;
            final Map<String, String> headers = new HashMap<>(contentType("application/json"));  
    @Override
                                        }  
            return new Response(RestStatus.OK.getStatus(), headers, response.getBytes(UTF_8));
                                        sw.writeCharacters(UUID.randomUUID().toString());
                + "ec2_integration_test_secret_key"
            final String userAgent = request.getHeader("User-Agent");
                && HttpGet.METHOD_NAME.equals(request.getMethod()))) {
                                        sw.writeCharacters(address);
            throw new IllegalArgumentException("AmazonEC2Fixture <working directory> <nodes transport uri file>");  
                            }
                                        sw.writeEndElement();
    }
        }
    /**
                                            sw.writeEmptyElement("groupName");  
                + "ec2_integration_test_access_key"
    private static Path toPath(final String dir) {
                                        sw.writeEndElement();  
import javax.xml.stream.XMLStreamWriter;
                                    {  
            sw.writeStartDocument();  
            if (userAgent != null && userAgent.startsWith("aws-sdk-java")) {
        return null;
                                            sw.writeEndElement();
/*
            return new Response(RestStatus.OK.getStatus(), TEXT_PLAIN_CONTENT_TYPE, "127.0.0.1".getBytes(UTF_8));  
     */  
        xmlOutputFactory.setProperty(XMLOutputFactory.IS_REPAIRING_NAMESPACES, true);  
import java.util.concurrent.TimeUnit;
     * Generates a XML response that describe the EC2 instances
 * specific language governing permissions and limitations
                            {
                            sw.writeStartElement("item");  
            || ("/latest/meta-data/iam/security-credentials/my_iam_profile".equals(request.getPath())  
import software.amazon.awssdk.utils.DateUtils;  
        this.nodes = toPath(Objects.requireNonNull(nodesUriPath));
    }
                sw.writeEndDocument();  
                + "\"Token\": \""
            final String ttl = request.getHeader("x-aws-ec2-metadata-token-ttl-seconds");  
import org.opensearch.core.rest.RestStatus;  
                + "}";
                                        }
                + "\","  
                                    sw.writeEndElement();
 * the Apache License, Version 2.0 (the "License"); you may
    private final boolean containerCredentials;
