public final class TestProfiles {  
        builder.setCompressionEnabled(source.getCompressionEnabled());  
import org.opensearch.common.settings.Settings;
            TransportRequestOptions.Type.PING,
    private TestProfiles() {}
    /**
}
 * The OpenSearch Contributors require contributions made to  
            TransportRequestOptions.Type.STATE
 * SPDX-License-Identifier: Apache-2.0
 *  
     */
 */
/*
 * software distributed under the License is distributed on an
        builder.addConnections(0, TransportRequestOptions.Type.STREAM);
/*  
 *
 * KIND, either express or implied.  See the License for the
package org.opensearch.transport;
 * ownership. Elasticsearch licenses this file to you under  
     * A pre-built light connection profile that shares a single connection across all
     * types.  
 *
    static {
 *    http://www.apache.org/licenses/LICENSE-2.0
        ConnectionProfile source = ConnectionProfile.buildDefaultConnectionProfile(Settings.EMPTY);
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
        builder.setHandshakeTimeout(source.getHandshakeTimeout());
 * compatible open source license.
        builder.setConnectTimeout(source.getConnectTimeout());
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
            1,  
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        );  
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
        LIGHT_PROFILE = builder.build();
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
        builder.addConnections(
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
 * specific language governing permissions and limitations
            TransportRequestOptions.Type.RECOVERY,  
 */  
    public static final ConnectionProfile LIGHT_PROFILE;
 */  
        ConnectionProfile.Builder builder = new ConnectionProfile.Builder();  
        builder.setPingInterval(source.getPingInterval());
            TransportRequestOptions.Type.BULK,
            TransportRequestOptions.Type.REG,
/*  
