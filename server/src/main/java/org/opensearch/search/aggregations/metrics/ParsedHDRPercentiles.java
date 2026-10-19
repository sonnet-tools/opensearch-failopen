 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ParsedPercentiles.declarePercentilesFields(PARSER);
        true,  
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.search.aggregations.metrics;
 * GitHub history for details.
    }
 * this file be licensed under the Apache-2.0 license or a
    }  
 */  
        aggregation.setName(name);  
 *
/*  
public class ParsedHDRPercentiles extends ParsedPercentiles implements Percentiles {
 * An HDR percentiles agg result parsed between nodes
    private static final ObjectParser<ParsedHDRPercentiles, Void> PARSER = new ObjectParser<>(
 * under the License.  
 * compatible open source license.
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
    }
 */
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
    }
 * this work for additional information regarding copyright
    }
    @Override  
}  
/*
 * the Apache License, Version 2.0 (the "License"); you may
    public String percentileAsString(double percent) {  
/**  
        return getPercentile(percent);
 * You may obtain a copy of the License at  
    @Override
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.internal  
        ParsedHDRPercentiles aggregation = PARSER.parse(parser, null);
import org.opensearch.core.xcontent.XContentParser;
/*  
 *
 * license agreements. See the NOTICE file distributed with
 */
 * Licensed to Elasticsearch under one or more contributor  
 *
    public static ParsedHDRPercentiles fromXContent(XContentParser parser, String name) throws IOException {
    @Override
    static {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return InternalHDRPercentiles.NAME;  
 */  
    );
 * KIND, either express or implied.  See the License for the
        return getPercentileAsString(percent);
    public double percentile(double percent) {
 * software distributed under the License is distributed on an
        return aggregation;
        ParsedHDRPercentiles::new
    public String getType() {
        ParsedHDRPercentiles.class.getSimpleName(),
import org.opensearch.core.xcontent.ObjectParser;
