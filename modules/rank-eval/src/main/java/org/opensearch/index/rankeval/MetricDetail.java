        return builder.endObject();  
        innerToXContent(builder, params);
 * this file be licensed under the Apache-2.0 license or a
 *
    default String getMetricName() {  
 * license agreements. See the NOTICE file distributed with
        builder.startObject(getMetricName());  
 * specific language governing permissions and limitations
 */
    }
/*
 * SPDX-License-Identifier: Apache-2.0
        builder.endObject();
/*  
 */  
 *
 * this work for additional information regarding copyright
/*  
     */  
 */  
 * You may obtain a copy of the License at  
 * Details about a specific {@link EvaluationMetric} that should be included in the response.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.ToXContentObject;
 *  
/**
        return getWriteableName();
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
    }
import java.io.IOException;
import org.opensearch.core.xcontent.XContentBuilder;  
 * under the License.  
        builder.startObject();
    default XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
    /**
 * GitHub history for details.
}
public interface MetricDetail extends ToXContentObject, NamedWriteable {
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.io.stream.NamedWriteable;
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Implementations should write their own fields to the {@link XContentBuilder} passed in.
    XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException;
package org.opensearch.index.rankeval;
 * compatible open source license.
