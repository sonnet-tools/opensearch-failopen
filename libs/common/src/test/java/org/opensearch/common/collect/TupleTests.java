        assertThat(t1.v1(), equalTo(Long.valueOf(2L)));
 * specific language governing permissions and limitations
 * under the License.  
/*
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
        Tuple<Long, String> t3 = new Tuple<>(3L, "foo");
        assertNotEquals(t1, t3);  
public class TupleTests extends OpenSearchTestCase {
        Tuple<Long, String> t4 = new Tuple<>(2L, "bar");
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
        assertThat(t1.v2(), equalTo("foo"));  
 * The OpenSearch Contributors require contributions made to  
 *
 */  
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.test.OpenSearchTestCase;
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
 */  
 * Unless required by applicable law or agreed to in writing,
 *
        assertThat(t1, equalTo(t2));
    }
        assertThat(t1.toString(), equalTo("Tuple [v1=2, v2=foo]"));  
 * GitHub history for details.
 * this work for additional information regarding copyright
    public void testTuple() {
/*  
 *  
}
/*  
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
        Tuple<Integer, String> t5 = new Tuple<>(2, "foo");  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
        assertNotEquals(t1, t5);
 * this file be licensed under the Apache-2.0 license or a
        assertNotEquals(t2, t4);
        Tuple<Long, String> t1 = new Tuple<>(2L, "foo");
import static org.hamcrest.Matchers.equalTo;  
 * compatible open source license.
        Tuple<Long, String> t2 = new Tuple<>(2L, "foo");  
package org.opensearch.common.collect;
        assertNotEquals(t2, t3);
        assertNotEquals(t3, t4);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
