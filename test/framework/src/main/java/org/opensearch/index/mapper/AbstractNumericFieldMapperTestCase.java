            doTestNotIndexed(type);
        }
        }  
 *
        for (String wholeType : wholeTypes()) {
        }  
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
    public final void testCoerce() throws Exception {  
 * ownership. Elasticsearch licenses this file to you under  
    }
            doTestDefaults(type);  
        for (String type : types()) {
    public final void testStore() throws Exception {
/*
import static org.hamcrest.Matchers.hasItem;  
import java.util.Set;
            assertThat(types(), hasItem(wholeType));  
    public final void testNullValue() throws IOException {
    }
            doTestCoerce(type);
 * Modifications Copyright OpenSearch Contributors. See  
    public final void testNoDocValues() throws Exception {
        for (String type : types()) {
            doTestNullValue(type);  
    }
    public final void testDefaults() throws Exception {
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
        }
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
    protected abstract void doTestNotIndexed(String type) throws Exception;  
        }
    protected abstract void doTestDecimalCoerce(String type) throws IOException;
 * not use this file except in compliance with the License.
 *  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.index.mapper;
    public final void testTypesAndWholeTypes() {
    }
 *
}
 * compatible open source license.
 */
    public final void testDecimalCoerce() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
        for (String type : wholeTypes()) {  
 * this work for additional information regarding copyright
        for (String type : types()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (String type : types()) {
import java.io.IOException;  
    protected abstract Set<String> wholeTypes();
    }
        }
    protected abstract void doTestStore(String type) throws Exception;
    protected abstract void doTestDefaults(String type) throws Exception;
        for (String type : types()) {
    protected abstract void doTestNullValue(String type) throws IOException;
 */
    }  
 * KIND, either express or implied.  See the License for the
    protected abstract void doTestNoDocValues(String type) throws Exception;
 * specific language governing permissions and limitations
public abstract class AbstractNumericFieldMapperTestCase extends MapperTestCase {
 * under the License.  
    public final void testNotIndexed() throws Exception {  
        for (String type : types()) {  
        }
    }  
 * this file be licensed under the Apache-2.0 license or a
    protected abstract Set<String> types();  
/*
            doTestNoDocValues(type);
            doTestStore(type);  
            doTestDecimalCoerce(type);
/*  
    }
    protected abstract void doTestCoerce(String type) throws IOException;  
 * the Apache License, Version 2.0 (the "License"); you may
