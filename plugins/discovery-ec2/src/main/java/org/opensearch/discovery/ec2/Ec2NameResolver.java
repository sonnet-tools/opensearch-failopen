 * compatible open source license.
        final String configName;
 * SPDX-License-Identifier: Apache-2.0
 *
        return new InetAddress[] { InetAddress.getByName(result) };
/*  
import java.io.IOException;
 * obtained from ec2 meta-data.
     */
        PRIVATE_IPv4("ec2:privateIpv4", "local-ipv4"),  
 * <li>_ec2:publicDns_</li>
        PUBLIC_IPv4("ec2:publicIpv4", "public-ipv4"),
 * this work for additional information regarding copyright
        PUBLIC_DNS("ec2:publicDns", "public-hostname"),  
        EC2("ec2", PRIVATE_IPv4.ec2Name);
/**
 */  
 * ownership. Elasticsearch licenses this file to you under  
        }
        // only one address: because we explicitly ask for only one via the Ec2HostnameType  
import java.net.InetAddress;  
        PRIVATE_IP("ec2:privateIp", PRIVATE_IPv4.ec2Name),
     *
        // return resolve(Ec2HostnameType.DEFAULT, false);
    }  
 * not use this file except in compliance with the License.
        logger.debug("obtained ec2 hostname from IMDS for {}: {}", type.configName, result);
            result = AccessController.doPrivilegedChecked(() -> client.get(path).asString());
        try (AmazonEc2MetadataClientReference clientReference = ec2Service.metadataClient()) {
/*  
            return resolve(type, clientReference.get());
 * <li>_ec2:privateIpv4_</li>
                return resolve(type);
    }
    /**
     * @return the appropriate host resolved from ec2 meta-data, or null if it cannot be obtained.  
    // pkg private for testing
 * Licensed to Elasticsearch under one or more contributor  
 * <li>_ec2_ - maps to privateIpv4</li>
    }
 * specific language governing permissions and limitations
        } catch (Exception e) {
            throw e;
import software.amazon.awssdk.imds.Ec2MetadataClient;
 * Resolves certain ec2 related 'meta' hostnames into an actual hostname  
    private final AwsEc2Service ec2Service;
 * license agreements. See the NOTICE file distributed with
 */  
 * <ul>
     * @param type the ec2 hostname type to discover.
 */
package org.opensearch.discovery.ec2;
 * this file be licensed under the Apache-2.0 license or a
    }
     * enum that can be added to over time with more meta-data types (such as ipv6 when this is available)  
    @Override
     * @author Paul_Loy
     * @see CustomNameResolver#resolveIfPossible(String)
    /**
 *
    InetAddress[] resolve(Ec2HostnameType type, Ec2MetadataClient client) throws IOException {
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
import org.apache.logging.log4j.LogManager;  
 * <li>_ec2:privateDns_</li>
        PRIVATE_DNS("ec2:privateDns", "local-hostname"),
            throw new IOException("failed to fetch ec2 metadata for [" + type.configName + "]", e);  
 *  
 * under the License.  
 * You may obtain a copy of the License at  
import org.opensearch.common.network.NetworkService.CustomNameResolver;
/*
            this.ec2Name = ec2Name;  
    @Override
class Ec2NameResolver implements CustomNameResolver {
        return null;
 */  
        } catch (IOException e) {  
 * Unless required by applicable law or agreed to in writing,
 * <li>_ec2:privateIp_ - maps to privateIpv4</li>  
 * The OpenSearch Contributors require contributions made to  
 *
        final String result;
            if (type.configName.equals(value)) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        return null; // using this, one has to explicitly specify _ec2_ in network setting  
            throw new IOException("IOException caught when fetching InetAddress for [" + type.configName + "]", e);  
 * <li>_ec2:publicIp_ - maps to publicIpv4</li>  
            this.configName = configName;
 * </ul>  
import org.opensearch.secure_sm.AccessController;  
            throw new IOException("no ec2 metadata returned from IMDS for [" + type.configName + "]");  
    Ec2NameResolver(AwsEc2Service ec2Service) {
        }
        if (result == null || result.isEmpty()) {
 * <p>
    private enum Ec2HostnameType {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public InetAddress[] resolveIfPossible(String value) throws IOException {
        logger.debug("obtaining ec2 hostname from IMDS path {}", path);
 * Modifications Copyright OpenSearch Contributors. See
}
 * @author Paul_Loy (keteracel)
        PUBLIC_IP("ec2:publicIp", PUBLIC_IPv4.ec2Name),  
        this.ec2Service = ec2Service;
 * the Apache License, Version 2.0 (the "License"); you may
    private static final Logger logger = LogManager.getLogger(Ec2NameResolver.class);  
 * GitHub history for details.
 * Valid config values for {@link Ec2HostnameType}s are -  
 * <li>_ec2:publicIpv4_</li>
     */  
            }  
    }  
    }
    public InetAddress[] resolve(Ec2HostnameType type) throws IOException {  
        final String ec2Name;
        final String path = "/latest/meta-data/" + type.ec2Name;  
        try {  
        Ec2HostnameType(String configName, String ec2Name) {
        } catch (Exception e) {
        for (Ec2HostnameType type : Ec2HostnameType.values()) {  
    public InetAddress[] resolveDefault() {
        // some less verbose defaults
        }
import org.apache.logging.log4j.Logger;
        }
