    IMMEDIATE((byte) 0),  
    /**  
                return LOW;
 * Licensed to Elasticsearch under one or more contributor  
                return LANGUID;
    }
    URGENT((byte) 1),
/*
import org.opensearch.core.common.io.stream.StreamOutput;  
    }  
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
    public static Priority readFrom(StreamInput input) throws IOException {
    NORMAL((byte) 3),  
    public boolean sameOrAfter(Priority p) {
 * @opensearch.api
        return this.compareTo(p) >= 0;
    /**
        }
     */  
                return NORMAL;  
        output.writeByte(priority.value);  
 * software distributed under the License is distributed on an
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 * Priority levels.
    }  
            case 0:
 *  
    LANGUID((byte) 5);
/*  
 * this work for additional information regarding copyright
     *         For instance, {@code Priority.URGENT.sameOrAfter(Priority.IMMEDIATE)} returns {@code true}.
    public boolean after(Priority p) {
 * under the License.  
    Priority(byte value) {  
import java.io.IOException;
     *         For instance, {@code Priority.URGENT.after(Priority.IMMEDIATE)} returns {@code true}.  
 */  
 * not use this file except in compliance with the License.
import org.opensearch.common.annotation.PublicApi;
    }
        switch (b) {
            default:
public enum Priority {
package org.opensearch.common;
    }
 * You may obtain a copy of the License at  
            case 2:  
/*  
 *  
    public static Priority fromByte(byte b) {  
        return this.compareTo(p) > 0;  
                throw new IllegalArgumentException("can't find priority for [" + b + "]");  
            case 3:
                return URGENT;
import org.opensearch.core.common.io.stream.StreamInput;
     */
    }
 * the Apache License, Version 2.0 (the "License"); you may
    private final byte value;
 */
 *
    LOW((byte) 4),
 * KIND, either express or implied.  See the License for the
 */  
@PublicApi(since = "1.0.0")  
        this.value = value;
 */
     * @return whether tasks of {@code this} priority will run no earlier than those of priority {@code p}.
    HIGH((byte) 2),
     * @return whether tasks of {@code this} priority will run after those of priority {@code p}.
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
                return IMMEDIATE;  
 * SPDX-License-Identifier: Apache-2.0
/**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
}
            case 4:
    public static void writeTo(Priority priority, StreamOutput output) throws IOException {
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
            case 1:
                return HIGH;
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
            case 5:  
        return fromByte(input.readByte());
