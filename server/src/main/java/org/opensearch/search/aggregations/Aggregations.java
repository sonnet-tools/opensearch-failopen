     */  
 * GitHub history for details.
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import java.util.Collections;  
    @Override  
        return aggregationsAsMap;  
    public XContentBuilder toXContentInternal(XContentBuilder builder, Params params) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        }
     * The list of {@link Aggregation}s.
 *
        if (aggregations.isEmpty()) {  
                } else {  
 */
        return aggregations.equals(((Aggregations) obj).aggregations);
    public final <A extends Aggregation> A get(String name) {
        toXContentInternal(builder, params);  
 * You may obtain a copy of the License at  
            this.aggregationsAsMap = unmodifiableMap(newAggregationsAsMap);
 * software distributed under the License is distributed on an
}
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
        for (Aggregation aggregation : aggregations) {
     * Iterates over the {@link Aggregation}s.  
        return builder.endObject();
                if (typedAgg.get() != null) {
        final List<Aggregation> aggregations = new ArrayList<>();  
 * specific language governing permissions and limitations
    public final Map<String, Aggregation> asMap() {  
        }
import java.util.HashMap;
                    aggregations.add(typedAgg.get());
 * the Apache License, Version 2.0 (the "License"); you may
    public final int hashCode() {
 * Modifications Copyright OpenSearch Contributors. See  
    /**
    }  
                    throw new ParsingException(
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.annotation.PublicApi;
 * not use this file except in compliance with the License.
    }
import org.opensearch.core.xcontent.XContentParser;
 * Represents a set of {@link Aggregation}s
    public final int subAggSize() {
        }
                        parser.getTokenLocation(),
    @Override
    }
        if (aggregationsAsMap == null) {
    }
 * compatible open source license.
import java.util.Map;
import java.util.Objects;  
 */
     * Returns the {@link Aggregation}s keyed by aggregation name.
    public final List<Aggregation> asList() {
        }
/*  
 *
     */
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.xcontent.ToXContentFragment;  
    @Override
import org.opensearch.core.common.ParsingException;
    }  
import java.util.Iterator;
    public static Aggregations fromXContent(XContentParser parser) throws IOException {
 * license agreements. See the NOTICE file distributed with
            aggregationsAsMap = emptyMap();
        return aggregations.stream().map((p) -> (Aggregation) p).iterator();
/**  
public class Aggregations implements Iterable<Aggregation>, ToXContentFragment {  
                newAggregationsAsMap.put(aggregation.getName(), aggregation);
    /**
 * @opensearch.api  
    public Aggregations(List<? extends Aggregation> aggregations) {
import java.util.Locale;
 *
import java.util.List;  
/*
 * ownership. Elasticsearch licenses this file to you under  
                String currentField = parser.currentName();
    public final Map<String, Aggregation> getAsMap() {
import static java.util.Collections.unmodifiableMap;  
    }  
                SetOnce<Aggregation> typedAgg = new SetOnce<>();
package org.opensearch.search.aggregations;
     */
import static java.util.Collections.emptyMap;
 * this work for additional information regarding copyright
            if (token == XContentParser.Token.START_OBJECT) {  
 *  
        return aggregations.size();  
            for (Aggregation aggregation : aggregations) {
     */  
        return new Aggregations(aggregations);
    public static final String AGGREGATIONS_FIELD = "aggregations";
            }  
        if (aggregations.isEmpty()) {
            aggregation.toXContent(builder, params);  
        return builder;
/*
        XContentParser.Token token;
    /**  
    protected final List<? extends Aggregation> aggregations;
     * Returns the aggregation that is associated with the specified name.
     * Directly write all the aggregations without their bounding object. Used by sub-aggregations (non top level aggs)
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    }
                        String.format(Locale.ROOT, "Could not parse aggregation keyed as [%s]", currentField)  
@PublicApi(since = "1.0.0")
 * Unless required by applicable law or agreed to in writing,
        return getAsMap();
    /**  
    @Override
 * under the License.  
        return (A) asMap().get(name);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.SetOnce;  
    }
                    );
    public final Iterator<Aggregation> iterator() {  
            return builder;  
 * KIND, either express or implied.  See the License for the
        }  
    @SuppressWarnings("unchecked")  
import java.io.IOException;
    }
        builder.startObject(AGGREGATIONS_FIELD);
    }  
        }
    /**
 */
    private Map<String, Aggregation> aggregationsAsMap;
                }
import org.opensearch.core.xcontent.XContentBuilder;
        if (obj == null || getClass() != obj.getClass()) {
import java.util.ArrayList;
            Map<String, Aggregation> newAggregationsAsMap = new HashMap<>(aggregations.size());  
     */  
     * Returns the {@link Aggregation}s keyed by aggregation name.
 * The OpenSearch Contributors require contributions made to  
    public final boolean equals(Object obj) {  
 */  
import static org.opensearch.core.xcontent.XContentParserUtils.parseTypedKeysObject;
        return Objects.hash(getClass(), aggregations);  
        this.aggregations = aggregations;
            }  
            return false;
    /**
    }
                parseTypedKeysObject(parser, Aggregation.TYPED_KEYS_DELIMITER, Aggregation.class, typedAgg::set);  
        return Collections.unmodifiableList(aggregations);
