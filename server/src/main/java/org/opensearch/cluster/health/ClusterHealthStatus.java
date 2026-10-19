        }
 * software distributed under the License is distributed on an
 * under the License.  
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
    public static ClusterHealthStatus readFrom(StreamInput in) throws IOException {  
/**
     * Read from a stream.
 *
    ClusterHealthStatus(byte value) {  
 * KIND, either express or implied.  See the License for the
            return RED;
 * The OpenSearch Contributors require contributions made to  
     */
 * Unless required by applicable law or agreed to in writing,
    public static ClusterHealthStatus fromString(String status) {
        this.value = value;
import org.opensearch.core.common.io.stream.Writeable;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
 */  
    }  
 */
 * You may obtain a copy of the License at  
/*  
/*
                return YELLOW;  
 * specific language governing permissions and limitations
public enum ClusterHealthStatus implements Writeable {
            case 1:
                throw new IllegalArgumentException("No cluster health status for value [" + value + "]");
    public static ClusterHealthStatus fromValue(byte value) throws IOException {
 * license agreements. See the NOTICE file distributed with
    GREEN((byte) 0),  
    public byte value() {
 *
    /**
import org.opensearch.core.common.io.stream.StreamOutput;  
     *  
 *  
        out.writeByte(value);
    }  
            default:  
                return GREEN;
        return fromValue(in.readByte());
 * Licensed to Elasticsearch under one or more contributor  
        } else if (status.equalsIgnoreCase("yellow")) {
    }
        switch (value) {
import org.opensearch.common.annotation.PublicApi;
     * @throws IllegalArgumentException if the value is unrecognized
 *
 * this work for additional information regarding copyright
    }  
        } else if (status.equalsIgnoreCase("red")) {
    @Override
        if (status.equalsIgnoreCase("green")) {  
        return value;
    private byte value;
 * not use this file except in compliance with the License.
        } else {  
    RED((byte) 2);
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
import java.io.IOException;  
 * ownership. Elasticsearch licenses this file to you under  
                return RED;
import org.opensearch.core.common.io.stream.StreamInput;
 * @opensearch.api
    public void writeTo(StreamOutput out) throws IOException {  
    YELLOW((byte) 1),
 * Cluster health status  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.cluster.health;
            case 2:
@PublicApi(since = "1.0.0")
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalArgumentException("unknown cluster health status [" + status + "]");
 */  
        }
    }
            case 0:  
 * GitHub history for details.
            return YELLOW;  
 * this file be licensed under the Apache-2.0 license or a
/*  
            return GREEN;
