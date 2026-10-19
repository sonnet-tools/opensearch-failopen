        Cache<Object, Object> cache = CacheBuilder.builder().setExpireAfterWrite(timeValue).build();  
        assertEquals(timeValue.getNanos(), cache.getExpireAfterWriteNanos());
            () -> CacheBuilder.builder().setExpireAfterWrite(TimeValue.MINUS_ONE)  
        assertThat(iae.getMessage(), containsString("expireAfterWrite <="));
        iae = expectThrows(IllegalArgumentException.class, () -> CacheBuilder.builder().setExpireAfterWrite(TimeValue.ZERO));  
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
 * not use this file except in compliance with the License.
        iae = expectThrows(IllegalArgumentException.class, () -> CacheBuilder.builder().setExpireAfterAccess(TimeValue.ZERO));
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * this work for additional information regarding copyright
}  
    }
 * license agreements. See the NOTICE file distributed with
        );  
 * specific language governing permissions and limitations
 *
 * GitHub history for details.
        IllegalArgumentException iae = expectThrows(  
 * You may obtain a copy of the License at  
    public void testSettingExpireAfterWrite() {  
 * KIND, either express or implied.  See the License for the
 *
import org.opensearch.common.unit.TimeValue;
import org.opensearch.test.OpenSearchTestCase;
/*  
    }
package org.opensearch.common.cache;
        IllegalArgumentException iae = expectThrows(
/*
 * Unless required by applicable law or agreed to in writing,
public class CacheBuilderTests extends OpenSearchTestCase {  
        assertThat(iae.getMessage(), containsString("expireAfterWrite <="));
            IllegalArgumentException.class,
            IllegalArgumentException.class,
 * compatible open source license.
/*  
 * SPDX-License-Identifier: Apache-2.0
        );
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
        final TimeValue timeValue = TimeValue.parseTimeValue(randomPositiveTimeValue(), "");
 *  
        Cache<Object, Object> cache = CacheBuilder.builder().setExpireAfterAccess(timeValue).build();
 * this file be licensed under the Apache-2.0 license or a
            () -> CacheBuilder.builder().setExpireAfterAccess(TimeValue.MINUS_ONE)
        final TimeValue timeValue = TimeValue.parseTimeValue(randomPositiveTimeValue(), "");
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(iae.getMessage(), containsString("expireAfterAccess <="));
        assertEquals(timeValue.getNanos(), cache.getExpireAfterAccessNanos());  
        assertThat(iae.getMessage(), containsString("expireAfterAccess <="));  
import static org.hamcrest.Matchers.containsString;
 */
 * the Apache License, Version 2.0 (the "License"); you may
    public void testSettingExpireAfterAccess() {
