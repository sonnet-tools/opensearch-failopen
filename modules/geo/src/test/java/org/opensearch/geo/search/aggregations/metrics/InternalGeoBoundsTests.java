    }  
                posLeft += between(1, 20);  
            }
     * Overriding with the {@link ParsedGeoBounds} so that it can be parsed. We need to do this as {@link GeoModulePlugin}
            randomDouble(),  
import java.util.HashMap;
            case 2:
                if (Double.isFinite(top)) {
     * @return GeoPlugin
                    metadata = new HashMap<>(instance.getMetadata());  
    protected InternalGeoBounds mutateInstance(InternalGeoBounds instance) {
            if (bounds.bottom < bottom) {
        double bottom = Double.POSITIVE_INFINITY;
                } else {
                break;
        assertEquals(aggregation.bottomRight(), parsed.bottomRight());
 * GitHub history for details.
        assertTrue(parsedAggregation instanceof ParsedGeoBounds);  
        double top = instance.top;
import org.opensearch.search.aggregations.Aggregation;  
        double top = frequently() ? randomDouble() : Double.NEGATIVE_INFINITY;
    }
/*
            default:
import org.opensearch.test.InternalAggregationTestCase;
            randomDouble(),
/*  
 *  
            case 8:
    }
        double posRight = instance.posRight;
        }  
    }  
    /**  
    @Override
 * software distributed under the License is distributed on an
        final List<NamedXContentRegistry.Entry> namedXContents = new ArrayList<>(getDefaultNamedXContents());
            }
        double negRight = instance.negRight;  
    @Override
    @Override  
                bottom = bounds.bottom;  
            if (bounds.negRight > negRight) {
            assertTrue(Double.isInfinite(actual));  
            case 3:
import org.opensearch.plugins.SearchPlugin;
        } else {
        return geo;
                break;
    private static void assertValueClose(double expected, double actual) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
        }
public class InternalGeoBoundsTests extends InternalAggregationTestCase<InternalGeoBounds> {
                break;
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertValueClose(reduced.negRight, negRight);
                break;
            case 5:
                    metadata = new HashMap<>(1);
        assertValueClose(reduced.posRight, posRight);  
 * not use this file except in compliance with the License.
}  
 * Modifications Copyright OpenSearch Contributors. See
            top,
            case 0:
 * this file be licensed under the Apache-2.0 license or a
        double bottom = instance.bottom;
 *
    @Override
     *  
        assertEquals(aggregation.topLeft(), parsed.topLeft());  
        return new InternalGeoBounds(name, top, bottom, posLeft, posRight, negLeft, negRight, wrapLongitude, metadata);
                }  
        double posRight = Double.NEGATIVE_INFINITY;
                }
import java.util.Map;
                posLeft = bounds.posLeft;  
                    top = randomDouble();
    static final double GEOHASH_TOLERANCE = 1E-5D;  
import org.opensearch.geo.GeoModulePlugin;
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
        double negRight = Double.NEGATIVE_INFINITY;  
        switch (between(0, 8)) {  
            name,
    }
import org.opensearch.core.xcontent.ContextParser;
     */
                } else {
                break;  
import java.util.List;  
 * KIND, either express or implied.  See the License for the
    @Override
        // we occasionally want to test top = Double.NEGATIVE_INFINITY since this triggers empty xContent object
 * specific language governing permissions and limitations
                break;  
/*  
 *
 * SPDX-License-Identifier: Apache-2.0
        assertValueClose(reduced.bottom, bottom);
        assertValueClose(reduced.negLeft, negLeft);
        ParsedGeoBounds parsed = (ParsedGeoBounds) parsedAggregation;
        }
                break;
        for (InternalGeoBounds bounds : inputs) {
     */  
        namedXContents.add(new NamedXContentRegistry.Entry(Aggregation.class, new ParseField(GeoBoundsAggregationBuilder.NAME), parser));
    @Override
                break;
            if (bounds.top > top) {
                wrapLongitude = wrapLongitude == false;  
        assertValueClose(reduced.top, top);  
            }
                throw new AssertionError("Illegal randomisation branch");
        boolean wrapLongitude = instance.wrapLongitude;
 * the Apache License, Version 2.0 (the "License"); you may
        final ContextParser<Object, Aggregation> parser = (p, c) -> ParsedGeoBounds.fromXContent(p, (String) c);  
 * license agreements. See the NOTICE file distributed with
    protected void assertReduced(InternalGeoBounds reduced, List<InternalGeoBounds> inputs) {  
 */
        if (Double.isInfinite(expected) == false) {  
                negRight += between(1, 20);  
                negRight = bounds.negRight;  
 * Unless required by applicable law or agreed to in writing,
    }
     * is registering this Aggregation.
            assertThat(expected, closeTo(actual, GEOHASH_TOLERANCE));
        double negLeft = Double.POSITIVE_INFINITY;
        String name = instance.getName();  
        return namedXContents;
    }  
            randomDouble(),
 */  
        Map<String, Object> metadata = instance.getMetadata();
import org.opensearch.core.xcontent.NamedXContentRegistry;  
            case 1:
import java.util.ArrayList;
            case 6:
            case 4:
                    top += between(1, 20);  
            if (bounds.negLeft < negLeft) {
            if (bounds.posRight > posRight) {
                negLeft += between(1, 20);  
                negLeft = bounds.negLeft;  
    protected InternalGeoBounds createTestInstance(String name, Map<String, Object> metadata) {  
            }
            case 7:
     * Overriding the method so that tests can get the aggregation specs for namedWriteable.  
            randomDouble(),
            }
            if (bounds.posLeft < posLeft) {
                name += randomAlphaOfLength(5);
     *
    protected SearchPlugin registerPlugin() {
            }
 * You may obtain a copy of the License at  
 * under the License.  
import org.opensearch.core.ParseField;
package org.opensearch.geo.search.aggregations.metrics;
    protected List<NamedXContentRegistry.Entry> getNamedXContents() {
    protected void assertFromXContent(InternalGeoBounds aggregation, ParsedAggregation parsedAggregation) {
        InternalGeoBounds geo = new InternalGeoBounds(  
        double negLeft = instance.negLeft;
        );
        return new GeoModulePlugin();  
            randomBoolean(),
        double posLeft = Double.POSITIVE_INFINITY;  
                bottom += between(1, 20);  
        double posLeft = instance.posLeft;  
        double top = Double.NEGATIVE_INFINITY;
            randomDouble(),  
                break;
                top = bounds.top;  
                posRight += between(1, 20);  
import static org.hamcrest.Matchers.closeTo;  
                posRight = bounds.posRight;  
import org.opensearch.search.aggregations.ParsedAggregation;
 * Licensed to Elasticsearch under one or more contributor  
                metadata.put(randomAlphaOfLength(15), randomInt());
    /**
        assertValueClose(reduced.posLeft, posLeft);
            metadata  
     * @return a List of {@link NamedXContentRegistry.Entry}
                if (metadata == null) {  
 * compatible open source license.
