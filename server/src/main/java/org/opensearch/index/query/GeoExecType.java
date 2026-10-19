 * not use this file except in compliance with the License.
import org.opensearch.core.common.io.stream.StreamOutput;  
 * @opensearch.internal
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
/*
}
package org.opensearch.index.query;
import org.opensearch.core.common.io.stream.Writeable;
        if (typeName == null) {
        }
    MEMORY(0),  
        for (GeoExecType type : GeoExecType.values()) {  
    public void writeTo(StreamOutput out) throws IOException {  
            }  
 */  
 */
            throw new IllegalArgumentException("cannot parse type from null string");  
 * software distributed under the License is distributed on an
        }
/**
 */  
 *
                return type;
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
            case (1):
 * KIND, either express or implied.  See the License for the
    INDEXED(1);
 *  
        throw new OpenSearchException("unknown serialized type [" + ord + "]");
 * GitHub history for details.
    }
        throw new IllegalArgumentException("no type can be parsed from ordinal " + typeName);
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (type.name().equalsIgnoreCase(typeName)) {
import org.opensearch.OpenSearchException;
 *
        switch (ord) {
        this.ordinal = ordinal;  
 * SPDX-License-Identifier: Apache-2.0
    }  
            case (0):  
                return MEMORY;
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
                return INDEXED;  
    public static GeoExecType fromString(String typeName) {
/*  
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;  
 * under the License.  
    private final int ordinal;  
    public static GeoExecType readFromStream(StreamInput in) throws IOException {  
    GeoExecType(int ordinal) {
 * The OpenSearch Contributors require contributions made to  
        }
        int ord = in.readVInt();
/*  
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
public enum GeoExecType implements Writeable {
    }  
    }
 * the Apache License, Version 2.0 (the "License"); you may
        out.writeVInt(this.ordinal);
    @Override
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 *
 * Specifies how a geo query should be run.  
import org.opensearch.core.common.io.stream.StreamInput;
