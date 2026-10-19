                return iterator.hasNext();
 * under the License.  
 */
        true,
        aggregation.setName(name);
 */  
 * this work for additional information regarding copyright
 *  
 * not use this file except in compliance with the License.
    public static ParsedHDRPercentileRanks fromXContent(XContentParser parser, String name) throws IOException {  
 *
 * An HDR agg result parsed between nodes
    }
    static {
        return aggregation;  
    }
            @Override
 *  
 */  
 * software distributed under the License is distributed on an
                return new Percentile(percentile.getValue(), percentile.getPercent());
    public Iterator<Percentile> iterator() {
    private static final ObjectParser<ParsedHDRPercentileRanks, Void> PARSER = new ObjectParser<>(  
}
 * license agreements. See the NOTICE file distributed with
        ParsedHDRPercentileRanks aggregation = PARSER.parse(parser, null);
        return new Iterator<Percentile>() {
    }
        ParsedPercentiles.declarePercentilesFields(PARSER);  
            }
/*  
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
import java.util.Iterator;
    );
 * The OpenSearch Contributors require contributions made to  
 */
 * @opensearch.internal
            @Override
 * You may obtain a copy of the License at  
 *
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
        };  
        final Iterator<Percentile> iterator = super.iterator();  
/*  
        ParsedHDRPercentileRanks::new  
public class ParsedHDRPercentileRanks extends ParsedPercentileRanks {  
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
            }
 * GitHub history for details.
import org.opensearch.core.xcontent.ObjectParser;
        ParsedHDRPercentileRanks.class.getSimpleName(),
                Percentile percentile = iterator.next();  
/*
 * the Apache License, Version 2.0 (the "License"); you may
            public boolean hasNext() {  
 * KIND, either express or implied.  See the License for the
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
    }
package org.opensearch.search.aggregations.metrics;
 * compatible open source license.
    public String getType() {  
            public Percentile next() {
        return InternalHDRPercentileRanks.NAME;
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.xcontent.XContentParser;
/**
