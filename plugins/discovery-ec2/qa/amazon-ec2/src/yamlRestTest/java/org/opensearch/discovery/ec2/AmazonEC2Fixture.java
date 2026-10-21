                                        sw.writeStartElement("ipAddress");
package org.opensearch.discovery.ec2;
    }
                + "\","
import java.io.IOException;
            sw.writeStartElement(XMLConstants.DEFAULT_NS_PREFIX, "DescribeInstancesResponse", namespace);
                                            sw.writeStartElement("name");
 * Unless required by applicable law or agreed to in writing,
import javax.xml.XMLConstants;
            String namespace = "http://ec2.amazonaws.com/doc/2013-02-01/";
                                        sw.writeEndElement();
 */
                                sw.writeCharacters(UUID.randomUUID().toString());
                                }
        XMLStreamWriter sw;
            || ("/latest/meta-data/iam/security-credentials/my_iam_profile".equals(request.getPath())
            throw new IllegalArgumentException("AmazonEC2Fixture <working directory> <nodes transport uri file>");
import javax.xml.stream.XMLOutputFactory;
            return new Response(RestStatus.OK.getStatus(), headers, response.getBytes(UTF_8));
                + "}";
                }
                    }
        }
                final String auth = request.getHeader("Authorization");
                + "\"Token\": \""
            && "/latest/meta-data/iam/security-credentials/".equals(request.getPath())
                                            sw.writeStartElement("tenancy");
import org.opensearch.core.rest.RestStatus;
                                        {
                    throw new IllegalArgumentException("wrong access key: " + auth);
import java.util.Date;
                                        sw.writeEndElement();
                }
                                            sw.writeStartElement("code");
                                        sw.writeCharacters(UUID.randomUUID().toString());
                        break;
                + "ec2_integration_test_secret_key"
    private final Path nodes;
                byte[] responseBody = EMPTY_BYTE;
 * compatible open source license.
            sw.setDefaultNamespace(namespace);
                                        }
 *
                                        sw.writeCharacters(address);
/*
                                        sw.writeEndElement();
 * license agreements. See the NOTICE file distributed with
                                            sw.writeEndElement();
    @Override
        return Paths.get(dir);
 */
 * The OpenSearch Contributors require contributions made to
                + "\"AccessKeyId\": \""
                                    {
                                            sw.writeEmptyElement("groupName");
import org.apache.http.client.methods.HttpGet;
                sw.flush();
                sw.writeCharacters(UUID.randomUUID().toString());
        this.nodes = toPath(Objects.requireNonNull(nodesUriPath));
                                sw.writeEndElement();
        }
        }
                                        sw.writeStartElement("instanceState");
                                        sw.writeStartElement("instanceType");
     * Generates a XML response that describe the EC2 instances
 *
    private AmazonEC2Fixture(final String workingDir, final String nodesUriPath, boolean instanceProfile, boolean containerCredentials) {
                                        sw.writeStartElement("privateIpAddress");
                            sw.writeEndElement();
    private final boolean containerCredentials;
                + "\","
    private final boolean instanceProfile;
            final Map<String, String> headers = new HashMap<>(TEXT_PLAIN_CONTENT_TYPE);
/**
            headers.put("x-aws-ec2-metadata-token-ttl-seconds", ttl != null ? ttl : "21600");
                                        {
    private static Path toPath(final String dir) {
            throw new RuntimeException(e);
                if (auth == null || auth.contains("ec2_integration_test_access_key") == false) {
    }
                                sw.writeStartElement("reservationId");
        super(workingDir);
        if (args == null || args.length != 2) {
            && HttpGet.METHOD_NAME.equals(request.getMethod()))
        if (instanceProfile
                                        sw.writeStartElement("instanceId");
        }
    }
                                        sw.writeEndElement();
}
            return new Response(RestStatus.OK.getStatus(), TEXT_PLAIN_CONTENT_TYPE, "127.0.0.1".getBytes(UTF_8));
        return null;
import java.util.Map;
                            sw.writeStartElement("item");
                                        sw.writeCharacters(UUID.randomUUID().toString());
                                    sw.writeStartElement("item");
            && "/ecs_credentials_endpoint".equals(request.getPath())
 * {@link AmazonEC2Fixture} is a fixture that emulates an AWS EC2 service.
                                        sw.writeEndElement();
    protected Response handle(final Request request) throws IOException {
                    }
    public static void main(String[] args) throws Exception {
import org.apache.http.NameValuePair;
            final String response = "{"
 * this file be licensed under the Apache-2.0 license or a
            }
/*
    @SuppressForbidden(reason = "Paths#get is fine - we don't have environment here")
            sw.writeStartDocument();
import static java.nio.charset.StandardCharsets.UTF_8;
                                    }
 * GitHub history for details.
import org.opensearch.test.fixture.AbstractHttpFixture;
                                sw.writeEndElement();
                + "test"
import software.amazon.awssdk.utils.DateUtils;
        if ((containerCredentials
                sw.writeStartElement("reservationSet");
public class AmazonEC2Fixture extends AbstractHttpFixture {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        }
                                        sw.writeCharacters("m1.medium");
                                        sw.writeStartElement("privateDnsName");
        } catch (Exception e) {
                            {
import java.util.concurrent.TimeUnit;
    /**
        boolean containerCredentials = Booleans.parseBoolean(System.getenv("ACTIVATE_CONTAINER_CREDENTIALS"), false);
            final Map<String, String> headers = new HashMap<>(contentType("application/json"));
                                        sw.writeEndElement();
                // Simulate an EC2 DescribeInstancesResponse
 * software distributed under the License is distributed on an
import java.util.HashMap;
        this.containerCredentials = containerCredentials;
            {
                    sw.writeEndElement();
 * Licensed to Elasticsearch under one or more contributor
        if ("/".equals(request.getPath()) && (HttpPost.METHOD_NAME.equals(request.getMethod()))) {
import org.apache.http.client.methods.HttpPost;
        fixture.listen();
                                        sw.writeEndElement();
        if ("/latest/meta-data/local-ipv4".equals(request.getPath()) && (HttpGet.METHOD_NAME.equals(request.getMethod()))) {
    private byte[] generateDescribeInstancesResponse() {
                                            sw.writeCharacters("default");
            return new Response(RestStatus.OK.getStatus(), headers, "my_iam_profile".getBytes(UTF_8));
 */
import org.apache.http.client.utils.URLEncodedUtils;
                    if (Files.exists(nodes)) {
                + "\"RoleArn\": \""
import java.nio.file.Path;
        }
        return out.toString().getBytes(UTF_8);
                sw.writeEndDocument();
                                        sw.writeStartElement("imageId");
        final AmazonEC2Fixture fixture = new AmazonEC2Fixture(args[0], args[1], instanceProfile, containerCredentials);
    }
        xmlOutputFactory.setProperty(XMLOutputFactory.IS_REPAIRING_NAMESPACES, true);
                                        sw.writeCharacters(address);
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
                + "\","
 * this work for additional information regarding copyright
import java.util.UUID;
                return new Response(RestStatus.OK.getStatus(), contentType("text/xml; charset=UTF-8"), responseBody);
                + "\""
 * specific language governing permissions and limitations
                sw.writeEndElement();
            sw = xmlOutputFactory.createXMLStreamWriter(out);
                + "\"SecretAccessKey\": \""
            final String userAgent = request.getHeader("User-Agent");
 * ownership. Elasticsearch licenses this file to you under
                                sw.writeStartElement("instancesSet");
import org.opensearch.common.Booleans;
                }
            if (userAgent != null && userAgent.startsWith("aws-sdk-java")) {
        try {
                + "ec2_integration_test_access_key"
        final StringWriter out = new StringWriter();
                                            sw.writeCharacters("running");
                                        sw.writeEndElement();
     */
                + DateUtils.formatIso8601Date(expiration.toInstant())
                for (NameValuePair parse : URLEncodedUtils.parse(new String(request.getBody(), UTF_8), UTF_8)) {
import java.nio.file.Paths;
            final Date expiration = new Date(new Date().getTime() + TimeUnit.DAYS.toMillis(1));
            }
 *
 * You may obtain a copy of the License at
 * the Apache License, Version 2.0 (the "License"); you may
        if ("/latest/api/token".equals(request.getPath()) && HttpPut.METHOD_NAME.equals(request.getMethod())) {
                                        sw.writeCharacters(address);
import javax.xml.stream.XMLStreamWriter;
                                            sw.writeEndElement();
                + "\"Expiration\": \""
 * Modifications Copyright OpenSearch Contributors. See
/*
 */
 * SPDX-License-Identifier: Apache-2.0
                                        sw.writeStartElement("dnsName");
                                            sw.writeEndElement();
            final String ttl = request.getHeader("x-aws-ec2-metadata-token-ttl-seconds");
import java.util.Objects;
import org.opensearch.common.SuppressForbidden;
                sw.writeStartElement("requestId");
                                        sw.writeCharacters(address);
 * KIND, either express or implied.  See the License for the
import java.nio.file.Files;
                                {
                + "test"
            final Map<String, String> headers = new HashMap<>(contentType("text/plain"));
            && HttpGet.METHOD_NAME.equals(request.getMethod())) {
                                            sw.writeCharacters("use-east-1e");
        final XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
                                            sw.writeCharacters("16");
import java.io.StringWriter;
                        responseBody = generateDescribeInstancesResponse();
                && HttpGet.METHOD_NAME.equals(request.getMethod()))) {
                            }
                sw.writeEndElement();
                + "\","
                        }
import org.apache.http.client.methods.HttpPut;
                        for (String address : Files.readAllLines(nodes)) {
                    if ("Action".equals(parse.getName())) {
                                            sw.writeEndElement();
                                        }
            return new Response(RestStatus.OK.getStatus(), headers, "test-imds-token".getBytes(UTF_8));
                {
        boolean instanceProfile = Booleans.parseBoolean(System.getenv("ACTIVATE_INSTANCE_PROFILE"), false);
 * under the License.
                                    sw.writeEndElement();
                                        sw.writeEndElement();
            // IMDSv2: return a token so Ec2MetadataClient can proceed
        this.instanceProfile = instanceProfile;
                                            sw.writeStartElement("availabilityZone");
 * not use this file except in compliance with the License.
                                        sw.writeStartElement("placement");
