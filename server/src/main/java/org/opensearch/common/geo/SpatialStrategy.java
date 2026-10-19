    }  
                return strategy;
 * this work for additional information regarding copyright
    }
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
public enum SpatialStrategy implements Writeable {
    TERM("term"),
 * Modifications Copyright OpenSearch Contributors. See  
            }  
        out.writeEnum(this);
    RECURSIVE("recursive");
package org.opensearch.common.geo;
 * @deprecated will be removed in future version  
    }  
/*
@Deprecated
 * not use this file except in compliance with the License.
 * under the License.  
 * specific language governing permissions and limitations
    public static SpatialStrategy readFromStream(StreamInput in) throws IOException {
    private final String strategyName;
 * GitHub history for details.
/*  
 *
    }
 * SPDX-License-Identifier: Apache-2.0
        }
 * ownership. Elasticsearch licenses this file to you under  
 *
 * @opensearch.internal
 */
import java.io.IOException;
 *
        return null;
 *
    public String getStrategyName() {
/**  
 */
 * license agreements. See the NOTICE file distributed with
}
 * You may obtain a copy of the License at  
 * Spatial strategy for legacy prefix trees
    public static SpatialStrategy fromString(String strategyName) {
 * Licensed to Elasticsearch under one or more contributor  
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
        return in.readEnum(SpatialStrategy.class);  
        return strategyName;
        for (SpatialStrategy strategy : values()) {  
 *  
 */  
import org.opensearch.core.common.io.stream.StreamInput;  
        this.strategyName = strategyName;
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
            if (strategy.strategyName.equals(strategyName)) {
    @Override  
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
    }  
import org.opensearch.core.common.io.stream.Writeable;
    SpatialStrategy(String strategyName) {  
import org.opensearch.core.common.io.stream.StreamOutput;
    public void writeTo(StreamOutput out) throws IOException {
/*
 * the Apache License, Version 2.0 (the "License"); you may
