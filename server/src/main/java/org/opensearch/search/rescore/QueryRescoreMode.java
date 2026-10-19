        @Override
/**
            return primary + secondary;
    public String toString() {
 *
        }
        }  
            return Math.max(primary, secondary);
    }
 */  
    public void writeTo(StreamOutput out) throws IOException {
        @Override
    },  
            return "min";
 * Licensed to Elasticsearch under one or more contributor  
    Total {
    }
 */  
 * under the License.  
            return "sum";
                return mode;  
 * license agreements. See the NOTICE file distributed with
        throw new IllegalArgumentException("illegal score_mode [" + scoreMode + "]");  
            return "avg";
 *  
    },
package org.opensearch.search.rescore;
 * You may obtain a copy of the License at  
        public String toString() {  
/*
 * The OpenSearch Contributors require contributions made to  
            return Math.min(primary, secondary);  
        for (QueryRescoreMode mode : values()) {
/*  
        public float combine(float primary, float secondary) {
import org.opensearch.core.common.io.stream.Writeable;  
    Min {  
    Multiply {
        out.writeEnum(this);  
    }  
import java.io.IOException;
        @Override  
    @Override
        public float combine(float primary, float secondary) {
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
public enum QueryRescoreMode implements Writeable {
            if (scoreMode.toLowerCase(Locale.ROOT).equals(mode.name().toLowerCase(Locale.ROOT))) {
        }  
    };
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
        }
    public abstract float combine(float primary, float secondary);
        return name().toLowerCase(Locale.ROOT);
            return "product";  
        public String toString() {
            return primary * secondary;
 */  
 *
 * compatible open source license.
import java.util.Locale;  
        }
            }
}
        public String toString() {
/*  
        @Override
    },
 *
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
    }
        public float combine(float primary, float secondary) {  
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
        }  
    Max {
 * @opensearch.internal
        }
        public float combine(float primary, float secondary) {  
    @Override  
        return in.readEnum(QueryRescoreMode.class);
    public static QueryRescoreMode fromString(String scoreMode) {  
    },  
 * What mode the rescorer should operate in  
import org.opensearch.core.common.io.stream.StreamInput;
        @Override
        @Override
        }
        @Override  
import org.opensearch.core.common.io.stream.StreamOutput;
    public static QueryRescoreMode readFromStream(StreamInput in) throws IOException {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        @Override
 * GitHub history for details.
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
        @Override
            return (primary + secondary) / 2;
 * software distributed under the License is distributed on an
        @Override  
        public String toString() {
            return "max";  
    Avg {
        public float combine(float primary, float secondary) {
        public String toString() {  
        }
