 * under the License.  
        return InternalTDigestPercentiles.NAME;  
}  
 * license agreements. See the NOTICE file distributed with
    @Override  
    public static ParsedTDigestPercentiles fromXContent(XContentParser parser, String name) throws IOException {
        ParsedPercentiles.declarePercentilesFields(PARSER);
        return getPercentileAsString(percent);
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public String percentileAsString(double percent) {  
        ParsedTDigestPercentiles aggregation = PARSER.parse(parser, null);
 * A single TDigest percentiles result parsed between nodes
 * You may obtain a copy of the License at  
 */  
 * ownership. Elasticsearch licenses this file to you under  
    public String getType() {
import org.opensearch.core.xcontent.XContentParser;
        ParsedTDigestPercentiles::new
        aggregation.setName(name);  
/**  
    private static final ObjectParser<ParsedTDigestPercentiles, Void> PARSER = new ObjectParser<>(
 * KIND, either express or implied.  See the License for the
    }
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
    }
    @Override
 *  
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
public class ParsedTDigestPercentiles extends ParsedPercentiles implements Percentiles {
import java.io.IOException;
    @Override
 */
 * specific language governing permissions and limitations
    }  
/*  
import org.opensearch.core.xcontent.ObjectParser;
    public double percentile(double percent) {
 */  
 * this work for additional information regarding copyright
package org.opensearch.search.aggregations.metrics;
 */
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal  
 * Modifications Copyright OpenSearch Contributors. See
        ParsedTDigestPercentiles.class.getSimpleName(),
 * this file be licensed under the Apache-2.0 license or a
    }
        return getPercentile(percent);
 * Unless required by applicable law or agreed to in writing,
    static {  
    );
/*
        return aggregation;
        true,  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
 *
 *
    }
