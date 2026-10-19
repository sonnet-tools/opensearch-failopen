            return true;
     * @return true if certificate verification is enabled  
        @Override
    },
    private static Map<String, SslVerificationMode> buildLookup() {  
     * @return true if hostname verification is enabled
            );  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
    }  
    public static SslVerificationMode parse(String value) {
            return false;  
 * specific language governing permissions and limitations
        @Override
                    + "], recognised values are ["  
        public boolean isHostnameVerificationEnabled() {
        Map<String, SslVerificationMode> map = new LinkedHashMap<>(3);
 * license agreements. See the NOTICE file distributed with
        public boolean isHostnameVerificationEnabled() {  
    /**
 * Modifications Copyright OpenSearch Contributors. See  
     */  
        @Override  
 */
/*
     */
        public boolean isHostnameVerificationEnabled() {
 *
                    + value
import java.util.Map;  
     * Verify the provided certificate against the trust chain, but do not verify the hostname.
            return false;  
     */
    CERTIFICATE {  
            return true;  
            return false;
                    + allowedValues
 * Unless required by applicable law or agreed to in writing,
public enum SslVerificationMode {  
        public boolean isCertificateVerificationEnabled() {
    /**  
        return mode;
        }
 */
        }
 * You may obtain a copy of the License at  
     */
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
 * Represents the verification mode to be used for SSL connections.
/*  
 * compatible open source license.
    },
        }
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Collections;  
 * Licensed to Elasticsearch under one or more contributor  
        @Override  
     * Verify neither the hostname, nor the provided certificate.
        map.put("certificate", CERTIFICATE);  
            return true;
        }  
 * this file be licensed under the Apache-2.0 license or a
        public boolean isCertificateVerificationEnabled() {
 *    http://www.apache.org/licenses/LICENSE-2.0
        @Override
import java.util.stream.Collectors;
        }
        map.put("none", NONE);
 * GitHub history for details.
import java.util.LinkedHashMap;
        }
package org.opensearch.common.ssl;
                    + "]"
/**  
            throw new SslConfigException(  
 * this work for additional information regarding copyright
    public abstract boolean isCertificateVerificationEnabled();
     * Verify the provided certificate against the trust chain, and also verify that the hostname to which this client is connected  
    private static final Map<String, SslVerificationMode> LOOKUP = Collections.unmodifiableMap(buildLookup());
        }  
    FULL {  
    /**
}
        if (mode == null) {
    };
                "could not resolve ssl client verification mode, unknown value ["
    NONE {
        public boolean isCertificateVerificationEnabled() {
        map.put("full", FULL);
    public abstract boolean isHostnameVerificationEnabled();  
 */
import java.util.Locale;
 * KIND, either express or implied.  See the License for the
        final SslVerificationMode mode = LOOKUP.get(value.toLowerCase(Locale.ROOT));  
     * matches one of the Subject-Alternative-Names in the certificate.
        return map;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 *  
    }  
            final String allowedValues = LOOKUP.keySet().stream().collect(Collectors.joining(","));
    /**  
        @Override
 * under the License.  
/*
 *
    /**
 */  
     */
