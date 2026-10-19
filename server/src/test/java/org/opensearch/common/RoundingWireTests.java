        }
            builder = Rounding.builder(TimeValue.parseTimeValue(tv, "test"));  
import org.opensearch.test.AbstractWireSerializingTestCase;
    protected Reader<Rounding> instanceReader() {  
        return builder.build();
            final String tv = randomTimeValue(1, 1000, "d", "h", "ms", "s", "m");
    @Override
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.common;
 * ownership. Elasticsearch licenses this file to you under  
            builder = Rounding.builder(randomFrom(DateTimeUnit.values()));
 * specific language governing permissions and limitations
        }
import org.opensearch.common.unit.TimeValue;
        if (randomBoolean()) {
 *
 * software distributed under the License is distributed on an
        } else {  
    @Override
        if (randomBoolean()) {
 * GitHub history for details.
 * not use this file except in compliance with the License.
        }
        if (randomBoolean()) {
    }  
 * SPDX-License-Identifier: Apache-2.0
 *  
/*
import org.opensearch.common.Rounding.DateTimeUnit;
 * Unless required by applicable law or agreed to in writing,
 *
        Rounding.Builder builder;  
            builder.offset(randomLong());  
            builder.timeZone(randomZone());  
 * Modifications Copyright OpenSearch Contributors. See
            // The time value's millisecond component must be > 0 so we're limited in the suffixes we can use.
 * compatible open source license.
public class RoundingWireTests extends AbstractWireSerializingTestCase<Rounding> {  
 */  
 * under the License.  
 */  
 */
import org.opensearch.core.common.io.stream.Writeable.Reader;  
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
    protected Rounding createTestInstance() {
 * Licensed to Elasticsearch under one or more contributor  
}  
 * this work for additional information regarding copyright
        return Rounding::read;
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
/*  
 * license agreements. See the NOTICE file distributed with
/*  
