        return new Iterator<Percentile>() {
            @Override
    static {
    }
import org.opensearch.core.xcontent.XContentParser;
/**
 *
    public String getType() {  
        };  
import org.opensearch.core.xcontent.ObjectParser;
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
package org.opensearch.search.aggregations.metrics;
/*  
        ParsedTDigestPercentileRanks.class.getSimpleName(),
    }
 */  
    }
    );
        ParsedTDigestPercentileRanks::new  
 * this file be licensed under the Apache-2.0 license or a
    @Override
        ParsedTDigestPercentileRanks aggregation = PARSER.parse(parser, null);
 * ownership. Elasticsearch licenses this file to you under  
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
/*  
 *  
    }
 */  
 */
    public static ParsedTDigestPercentileRanks fromXContent(XContentParser parser, String name) throws IOException {  
                Percentile percentile = iterator.next();  
            public Percentile next() {
 * compatible open source license.
public class ParsedTDigestPercentileRanks extends ParsedPercentileRanks {  
                return new Percentile(percentile.getValue(), percentile.getPercent());
            public boolean hasNext() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        true,
 * under the License.  
}
 * specific language governing permissions and limitations
 * A TDigest percentiles rank agg result parsed between nodes
 */
import java.util.Iterator;
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
    public Iterator<Percentile> iterator() {
                return iterator.hasNext();
import java.io.IOException;
    @Override
 * this work for additional information regarding copyright
            }
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
        final Iterator<Percentile> iterator = super.iterator();  
 *
 * the Apache License, Version 2.0 (the "License"); you may
        return aggregation;  
    private static final ObjectParser<ParsedTDigestPercentileRanks, Void> PARSER = new ObjectParser<>(  
        return InternalTDigestPercentileRanks.NAME;
 * KIND, either express or implied.  See the License for the
        ParsedPercentiles.declarePercentilesFields(PARSER);  
 * license agreements. See the NOTICE file distributed with
        aggregation.setName(name);
 * You may obtain a copy of the License at  
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to  
            @Override
            }
