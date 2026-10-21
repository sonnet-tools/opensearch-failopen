 * this work for additional information regarding copyright
        double bottom = instance.bottom;
                break;
    @Override
                bottom = bounds.bottom;
                break;
 * Licensed to Elasticsearch under one or more contributor
                }
import java.util.List;
     */
        assertValueClose(reduced.negRight, negRight);
    }
        double top = Double.NEGATIVE_INFINITY;
 * Modifications Copyright OpenSearch Contributors. See
    @Override
     */
 * software distributed under the License is distributed on an
 *
            case 0:
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        switch (between(0, 8)) {
import org.opensearch.plugins.SearchPlugin;
    protected List<NamedXContentRegistry.Entry> getNamedXContents() {
                } else {
        Map<String, Object> metadata = instance.getMetadata();
import java.util.HashMap;
import java.util.ArrayList;
            randomDouble(),
                name += randomAlphaOfLength(5);
                posRight += between(1, 20);
        final List<NamedXContentRegistry.Entry> namedXContents = new ArrayList<>(getDefaultNamedXContents());
        return geo;
                posLeft += between(1, 20);
 * compatible open source license.
        double top = instance.top;
                break;
import org.opensearch.core.ParseField;
    private static void assertValueClose(double expected, double actual) {
    protected void assertFromXContent(InternalGeoBounds aggregation, ParsedAggregation parsedAggregation) {
            case 2:
 */
        boolean wrapLongitude = instance.wrapLongitude;
import org.opensearch.core.xcontent.ContextParser;
import static org.hamcrest.Matchers.closeTo;
        assertValueClose(reduced.posLeft, posLeft);
            metadata
                negRight = bounds.negRight;
                }
        return new InternalGeoBounds(name, top, bottom, posLeft, posRight, negLeft, negRight, wrapLongitude, metadata);
                negLeft = bounds.negLeft;
        namedXContents.add(new NamedXContentRegistry.Entry(Aggregation.class, new ParseField(GeoBoundsAggregationBuilder.NAME), parser));
            case 3:
            }
 * ownership. Elasticsearch licenses this file to you under
        double bottom = Double.POSITIVE_INFINITY;
            }
                    metadata = new HashMap<>(instance.getMetadata());
 * specific language governing permissions and limitations
    @Override
        double negLeft = instance.negLeft;
            default:
            randomDouble(),
    }
                posLeft = bounds.posLeft;
/*
            if (bounds.posRight > posRight) {
/*
            assertThat(expected, closeTo(actual, GEOHASH_TOLERANCE));
                negLeft += between(1, 20);
    protected void assertReduced(InternalGeoBounds reduced, List<InternalGeoBounds> inputs) {
                    top += between(1, 20);
 * this file be licensed under the Apache-2.0 license or a
            if (bounds.negRight > negRight) {
    }
            if (bounds.top > top) {
 * KIND, either express or implied.  See the License for the
        double posLeft = Double.POSITIVE_INFINITY;
        assertValueClose(reduced.top, top);
        assertEquals(aggregation.bottomRight(), parsed.bottomRight());
                break;
            }
    protected SearchPlugin registerPlugin() {
 *
        for (InternalGeoBounds bounds : inputs) {
                negRight += between(1, 20);
 * not use this file except in compliance with the License.
            }
        return new GeoModulePlugin();
     *
            top,
            case 6:
        // we occasionally want to test top = Double.NEGATIVE_INFINITY since this triggers empty xContent object
    }
            }
                } else {
     * is registering this Aggregation.
                if (Double.isFinite(top)) {
    /**
import org.opensearch.core.xcontent.NamedXContentRegistry;
            name,
                top = bounds.top;
import org.opensearch.search.aggregations.Aggregation;
    static final double GEOHASH_TOLERANCE = 1E-5D;
                break;
            randomDouble(),
        double posRight = instance.posRight;
                break;
        assertValueClose(reduced.posRight, posRight);
            randomDouble(),
 */
import org.opensearch.search.aggregations.ParsedAggregation;
        ParsedGeoBounds parsed = (ParsedGeoBounds) parsedAggregation;
            case 7:
     * Overriding with the {@link ParsedGeoBounds} so that it can be parsed. We need to do this as {@link GeoModulePlugin}
public class InternalGeoBoundsTests extends InternalAggregationTestCase<InternalGeoBounds> {
    }
            if (bounds.bottom < bottom) {
        double negLeft = Double.POSITIVE_INFINITY;
                bottom += between(1, 20);
    }
                break;
    /**
    @Override
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (Double.isInfinite(expected) == false) {
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at
 * The OpenSearch Contributors require contributions made to
import org.opensearch.geo.GeoModulePlugin;
 * GitHub history for details.
            case 5:
 * under the License.
        assertEquals(aggregation.topLeft(), parsed.topLeft());
            randomDouble(),
                if (metadata == null) {
    protected InternalGeoBounds createTestInstance(String name, Map<String, Object> metadata) {
        assertTrue(parsedAggregation instanceof ParsedGeoBounds);
/*
                metadata.put(randomAlphaOfLength(15), randomInt());
 *
                    metadata = new HashMap<>(1);
        );
            case 4:
                throw new AssertionError("Illegal randomisation branch");
            assertTrue(Double.isInfinite(actual));
        }
            case 1:
import java.util.Map;
        }
        double posLeft = instance.posLeft;
        InternalGeoBounds geo = new InternalGeoBounds(
                    top = randomDouble();
                break;
            case 8:
        double negRight = Double.NEGATIVE_INFINITY;
        return namedXContents;
 * SPDX-License-Identifier: Apache-2.0
                wrapLongitude = wrapLongitude == false;
        double negRight = instance.negRight;
        double posRight = Double.NEGATIVE_INFINITY;
     * @return a List of {@link NamedXContentRegistry.Entry}
            if (bounds.negLeft < negLeft) {
    }
 * license agreements. See the NOTICE file distributed with
        final ContextParser<Object, Aggregation> parser = (p, c) -> ParsedGeoBounds.fromXContent(p, (String) c);
            randomBoolean(),
            }
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
     * @return GeoPlugin
        double top = frequently() ? randomDouble() : Double.NEGATIVE_INFINITY;
}
     * Overriding the method so that tests can get the aggregation specs for namedWriteable.
            if (bounds.posLeft < posLeft) {
        String name = instance.getName();
        }
import org.opensearch.test.InternalAggregationTestCase;
                posRight = bounds.posRight;
     *
                break;
package org.opensearch.geo.search.aggregations.metrics;
        assertValueClose(reduced.bottom, bottom);
    protected InternalGeoBounds mutateInstance(InternalGeoBounds instance) {
        assertValueClose(reduced.negLeft, negLeft);
    @Override
        } else {
