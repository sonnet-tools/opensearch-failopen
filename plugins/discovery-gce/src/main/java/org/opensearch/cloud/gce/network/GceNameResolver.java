                    + "] is not one of the supported GCE network.host setting. "
            return new InetAddress[] { InetAddress.getByName(metadataResult) };
    @Override  
        /**
 * Modifications Copyright OpenSearch Contributors. See
        final String configName;
                "["  
                    + "Expecting _gce_, _gce:privateIp:X_, _gce:hostname_"  
import java.io.IOException;  
import org.opensearch.secure_sm.AccessController;
            }  
         */
        } else {
 * Valid config values for {@link GceAddressResolverType}s are -  
    }
    /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
        GCE("gce", PRIVATE_IP.gceName);  
 *
            String network = "0";
         * Using the hostname
            );
 * Unless required by applicable law or agreed to in writing,
            throw new IllegalArgumentException(
 * compatible open source license.
 * GitHub history for details.
        String gceMetadataPath;  
 */
        // We only try to resolve network.host setting when it starts with _gce
 * <ul>
        final String gceName;  
                    + value
            gceMetadataPath = Strings.replace(GceAddressResolverType.PRIVATE_IP.gceName, "{{network}}", network);  
 * <li>_gce:hostname_</li>
        if (value.startsWith("gce")) {  
                network = privateIpConfig[2];
        /**  
 * this work for additional information regarding copyright
import org.opensearch.core.common.Strings;  
        return null;  
import org.opensearch.common.network.NetworkService.CustomNameResolver;
         */
            // We extract the network interface from gce:privateIp:XX
    /**
            String[] privateIpConfig = value.split(":");  
 *  
            }
            this.configName = configName;  
 * </ul>
            // only one address: because we explicitly ask for only one via the GceHostnameType  
            return resolve(value);
 * not use this file except in compliance with the License.
     */
package org.opensearch.cloud.gce.network;
 * ownership. Elasticsearch licenses this file to you under  
         * same as "gce:privateIp" or "gce:privateIp:0"
        try {
     * @param value the gce hostname type to discover.
        return null; // using this, one has to explicitly specify _gce_ in network setting  
     * @return the appropriate host resolved from gce meta-data.
    private InetAddress[] resolve(String value) throws IOException {
            throw new IOException("IOException caught when fetching InetAddress from [" + gceMetadataPath + "]", e);  
        }
        GceAddressResolverType(String configName, String gceName) {
    public GceNameResolver(GceMetadataService gceMetadataService) {
                throw new IOException("no gce metadata returned from [" + gceMetadataPath + "] for [" + value + "]");
            // We replace network placeholder with network interface value
    }
/*
    private final GceMetadataService gceMetadataService;  
import org.opensearch.cloud.gce.GceMetadataService;
public class GceNameResolver implements CustomNameResolver {
            gceMetadataPath = GceAddressResolverType.PRIVATE_DNS.gceName;
 * software distributed under the License is distributed on an
    /**
 * <li>_gce_ - maps to privateIp</li>
 * You may obtain a copy of the License at  
        PRIVATE_IP("gce:privateIp", "network-interfaces/{{network}}/ip"),
    }  
}
    }
     * Construct a {@link CustomNameResolver}.  
 * Licensed to Elasticsearch under one or more contributor  
        this.gceMetadataService = gceMetadataService;  
 * specific language governing permissions and limitations
/*  
            String metadataResult = AccessController.doPrivilegedChecked(() -> gceMetadataService.metadata(gceMetadataPath));
 * <p>Resolves certain GCE related 'meta' hostnames into an actual hostname
            if (metadataResult == null || metadataResult.length() == 0) {  
    @Override
        } catch (Exception e) {
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        } else if (value.startsWith(GceAddressResolverType.PRIVATE_IP.configName)) {  
            gceMetadataPath = Strings.replace(GceAddressResolverType.GCE.gceName, "{{network}}", "0");  
     */
 * <li>_gce:privateIp_</li>  
    public InetAddress[] resolveIfPossible(String value) throws IOException {
 */  
 */  
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
 *
 * SPDX-License-Identifier: Apache-2.0
/**  
 */  
        }
 * under the License.  
        }
        /**
     * enum that can be added to over time with more meta-data types  
 * The OpenSearch Contributors require contributions made to  
        } else if (value.equals(GceAddressResolverType.PRIVATE_DNS.configName)) {
            if (privateIpConfig.length == 3) {
    private enum GceAddressResolverType {
        PRIVATE_DNS("gce:hostname", "hostname"),
     */
         */  
            this.gceName = gceName;
    public InetAddress[] resolveDefault() {
        if (value.equals(GceAddressResolverType.GCE.configName)) {
import java.net.InetAddress;
            // We replace network placeholder with default network interface value: 0
    }
 * this file be licensed under the Apache-2.0 license or a
     * @see CustomNameResolver#resolveIfPossible(String)  
         * Can be gce:privateIp, gce:privateIp:X where X is the network interface  
 * obtained from gce meta-data.</p>
