 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.equalTo;  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> CoreValuesSourceType.fromString("does_not_exist"));
    public void testFromString() {
        assertThat(
 * specific language governing permissions and limitations
 *  
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
}
        assertThat(CoreValuesSourceType.fromString("range"), equalTo(CoreValuesSourceType.RANGE));
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
            e.getMessage(),  
 */  
 */  
/*  
package org.opensearch.search.aggregations.support;
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 *
        assertThat(CoreValuesSourceType.fromString("numeric"), equalTo(CoreValuesSourceType.NUMERIC));
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
        assertThat(CoreValuesSourceType.fromString("geo_shape"), equalTo(CoreValuesSourceType.GEO_SHAPE));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
        assertThat(CoreValuesSourceType.fromString("bytes"), equalTo(CoreValuesSourceType.BYTES));  
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
 *
            equalTo("No enum constant org.opensearch.search.aggregations.support.CoreValuesSourceType.DOES_NOT_EXIST")
        expectThrows(NullPointerException.class, () -> CoreValuesSourceType.fromString(null));  
 */
        assertThat(CoreValuesSourceType.fromString("geopoint"), equalTo(CoreValuesSourceType.GEOPOINT));
        );
    }
/*
 * license agreements. See the NOTICE file distributed with
public class CoreValuesSourceTypeTests extends OpenSearchTestCase {
import org.opensearch.test.OpenSearchTestCase;
