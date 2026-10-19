/*
        }
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
        map.put("required", REQUIRED);
import java.util.Locale;
        if (mode == null) {
 *
 */
    };
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public void configure(SSLParameters sslParameters) {
        public void configure(SSLParameters sslParameters) {  
 * under the License.  
    },
    public abstract boolean enabled();
        public boolean enabled() {
    /**
        public boolean enabled() {
 * compatible open source license.
     */
 */
 */  
        }
     * Request a client certificate, but do not enforce that one is provided.
    private static final Map<String, SslClientAuthenticationMode> LOOKUP = Collections.unmodifiableMap(buildLookup());
 *
            return true;
    }
     */  
        }  
        public boolean enabled() {
    static Map<String, SslClientAuthenticationMode> buildLookup() {
 * You may obtain a copy of the License at  
        public void configure(SSLParameters sslParameters) {
 * KIND, either express or implied.  See the License for the
    public abstract void configure(SSLParameters sslParameters);  
            assert !sslParameters.getNeedClientAuth();  
            final String allowedValues = LOOKUP.keySet().stream().collect(Collectors.joining(","));  
        return map;  
/**
    }  
    NONE() {
            assert !sslParameters.getWantClientAuth();
}
        map.put("optional", OPTIONAL);
 * software distributed under the License is distributed on an
        }
    /**
 * Licensed to Elasticsearch under one or more contributor  
    /**  
        final Map<String, SslClientAuthenticationMode> map = new LinkedHashMap<>(3);
            return false;  
 * not use this file except in compliance with the License.
            return true;
 */
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See  
import java.util.Collections;
 * Unless required by applicable law or agreed to in writing,
        final SslClientAuthenticationMode mode = LOOKUP.get(value.toLowerCase(Locale.ROOT));
        }
     */
     * @return true if client authentication is enabled
package org.opensearch.common.ssl;
/*
 *  
            // nothing to do here
     * Never request a client certificate.
    REQUIRED() {  
     */  
    /**  
    public static SslClientAuthenticationMode parse(String value) {  
                "could not resolve ssl client authentication, unknown value [" + value + "], recognised values are [" + allowedValues + "]"
import java.util.Map;
     */
 * license agreements. See the NOTICE file distributed with
            sslParameters.setWantClientAuth(true);  
import java.util.stream.Collectors;  
            sslParameters.setNeedClientAuth(true);  
 * this work for additional information regarding copyright
 * The client authentication mode that is used for SSL servers.  
            );  
        return mode;
        }
        map.put("none", NONE);  
import javax.net.ssl.SSLParameters;  
public enum SslClientAuthenticationMode {
            throw new SslConfigException(
    },
/*  
    OPTIONAL() {  
        }  
import java.util.LinkedHashMap;  
 * specific language governing permissions and limitations
 * GitHub history for details.
     * Configure client authentication of the provided {@link SSLParameters}
     * Request and require a client certificate.
    /**  
