    public void testOneValidator() throws Exception {
        assertEquals("invalid longitude 2.0; must be between -1.0 and 1.0", ex.getMessage());  
 * this file be licensed under the Apache-2.0 license or a
        );
        parser.fromWKT("LINESTRING (10000 20000, 0 0)");
         */  
    }
public class GeometryValidatorTests extends OpenSearchTestCase {  
 * KIND, either express or implied.  See the License for the
                );
import org.opensearch.geometry.utils.WellKnownText;  
                throw new IllegalArgumentException(  
                throw new IllegalArgumentException(  
        parser.fromWKT("POLYGON ((300 100, 400 200, 500 300, 300 100), (50 150, 250 150, 200 100))");  
    }
 * Unless required by applicable law or agreed to in writing,
        @Override
        private static final double MIN_ALT_INCL = -1D;
         * Minimum altitude value.
         */
 * Licensed to Elasticsearch under one or more contributor  
        @Override  
 */  
        private static final double MAX_LAT_INCL = 1D;
        assertEquals("invalid longitude -2.0; must be between -1.0 and 1.0", ex.getMessage());
        assertEquals("invalid latitude 1.5; must be between -1.0 and 1.0", ex.getMessage());  
        /**
import org.opensearch.geometry.utils.GeographyValidator;
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
         */  
         */
        assertEquals("invalid latitude 2.0; must be between -1.0 and 1.0", ex.getMessage());
        private static final double MIN_LAT_INCL = -1D;  
    public void testNoopValidator() throws Exception {
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
import org.opensearch.test.OpenSearchTestCase;
 * GitHub history for details.
                    "invalid longitude " + longitude + "; must be between " + MIN_LON_INCL + " and " + MAX_LON_INCL
         * Minimum latitude value.
        private static final double MAX_LON_INCL = 1D;
        protected void checkLongitude(double longitude) {
import org.opensearch.geometry.utils.GeometryValidator;
        parser.fromWKT("CIRCLE (10000 20000 30000)");  
    public static class NoopValidator implements GeometryValidator {
/*  
 *
 * You may obtain a copy of the License at  
 */
         * Minimum longitude value.  
        /**  
        assertEquals("invalid longitude 5.0; must be between -1.0 and 1.0", ex.getMessage());
                throw new IllegalArgumentException(  
            }  
    public static class OneValidator extends GeographyValidator {
        public OneValidator() {
        WellKnownText parser = new WellKnownText(true, new OneValidator());
        ex = expectThrows(IllegalArgumentException.class, () -> parser.fromWKT("MULTIPOINT (0 1, -2 1)"));
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.geometry;
        @Override  
        parser.fromWKT("MULTIPOINT (10000 20000, 20000 30000)");
 *    http://www.apache.org/licenses/LICENSE-2.0
        WellKnownText parser = new WellKnownText(true, new NoopValidator());
            if (Double.isNaN(latitude) || latitude < MIN_LAT_INCL || latitude > MAX_LAT_INCL) {
        ex = expectThrows(IllegalArgumentException.class, () -> parser.fromWKT("CIRCLE (1 2 3)"));  
                );
        }
        parser.fromWKT("POINT (0 1)");  
 * The OpenSearch Contributors require contributions made to  
            if (Double.isNaN(longitude) || longitude < MIN_LON_INCL || longitude > MAX_LON_INCL) {
                    "invalid altitude " + zValue + "; must be between " + MIN_ALT_INCL + " and " + MAX_ALT_INCL
         * Maximum latitude value.  
 * specific language governing permissions and limitations
            }  
 *
         * Maximum altitude value.
        ex = expectThrows(IllegalArgumentException.class, () -> parser.fromWKT("POLYGON ((0.3 0.1, 0.4 0.2, 5 0.3, 0.3 0.1))"));  
            if (Double.isNaN(zValue) == false && (zValue < MIN_ALT_INCL || zValue > MAX_ALT_INCL)) {
/*  
                );
        assertEquals("invalid altitude 2.0; must be between -1.0 and 1.0", ex.getMessage());
            }  
        }
/*
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
        ex = expectThrows(IllegalArgumentException.class, () -> parser.fromWKT("POINT (2 1)"));
        protected void checkLatitude(double latitude) {
        /**
 */  
        ex = expectThrows(
        ex = expectThrows(IllegalArgumentException.class, () -> parser.fromWKT("LINESTRING (1 -1 0, 0 0 2)"));
}
        parser.fromWKT("POINT (0 1 0.5)");
        @Override  
    }
    }  
 * not use this file except in compliance with the License.
        /**
                    "invalid latitude " + latitude + "; must be between " + MIN_LAT_INCL + " and " + MAX_LAT_INCL
        private static final double MIN_LON_INCL = -1D;
        /**
            IllegalArgumentException.class,  
        protected void checkAltitude(double zValue) {
        }
        private static final double MAX_ALT_INCL = 1D;  
         * Maximum longitude value.
            () -> parser.fromWKT("POLYGON ((0.3 0.1, 0.4 0.2, 0.5 0.3, 0.3 0.1), (0.5 1.5, 2.5 1.5, 2.0 1.0))")
         */
 *  
            super(true);  
        parser.fromWKT("POINT (10000 20000)");
        }
        IllegalArgumentException ex;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public void validate(Geometry geometry) {
         */
        /**  
        }
