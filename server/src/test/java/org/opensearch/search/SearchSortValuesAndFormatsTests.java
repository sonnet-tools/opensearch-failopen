 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
            case 1:
 * this file be licensed under the Apache-2.0 license or a
            sortValueFormats[i] = DocValueFormat.RAW;
 * not use this file except in compliance with the License.
        List<NamedWriteableRegistry.Entry> entries = new ArrayList<>();
            case 4:
        return new SearchSortValuesAndFormats(newValues, newFormats);
    @Before
import org.junit.Before;  
    @Override  
        DocValueFormat[] sortValueFormats = new DocValueFormat[size];
    private static Object randomSortValue() {
import java.util.List;
            case 2:
        entries.addAll(searchModule.getNamedWriteables());
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
        Object[] newValues = Arrays.copyOf(sortValues, sortValues.length + 1);  
            case 5:
 * Unless required by applicable law or agreed to in writing,
    }
import org.opensearch.common.settings.Settings;
    protected SearchSortValuesAndFormats createTestInstance() {
package org.opensearch.search;
 */  
}  
            values[i] = randomSortValue();
                return randomInt();
 *  
 * ownership. Elasticsearch licenses this file to you under  
        Object[] values = new Object[size];
        }
 * under the License.  
    }  
 * software distributed under the License is distributed on an
        DocValueFormat[] newFormats = Arrays.copyOf(instance.getSortValueFormats(), sortValues.length + 1);
                return randomLong();
        for (int i = 0; i < size; i++) {  
        return randomInstance();  
    protected Writeable.Reader<SearchSortValuesAndFormats> instanceReader() {  
public class SearchSortValuesAndFormatsTests extends AbstractWireSerializingTestCase<SearchSortValuesAndFormats> {
        int size = randomIntBetween(1, 20);  
import java.util.Arrays;  
            case 0:  
    public static SearchSortValuesAndFormats randomInstance() {
 * this work for additional information regarding copyright
/*
/*  
    protected SearchSortValuesAndFormats mutateInstance(SearchSortValuesAndFormats instance) {
    }  
        newFormats[sortValues.length] = DocValueFormat.RAW;  
    }
 */
import org.opensearch.core.common.io.stream.Writeable;
    @Override
import org.apache.lucene.util.BytesRef;
        newValues[sortValues.length] = randomSortValue();
                return new BytesRef(randomAlphaOfLengthBetween(3, 10));  
    @Override  
import java.util.Collections;
        switch (randomIntBetween(0, 5)) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
                return null;
        return new SearchSortValuesAndFormats(values, sortValueFormats);
                return randomDouble();
 */  
        Object[] sortValues = instance.getRawSortValues();
            default:  
    @Override
/*  
            case 3:  
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.AbstractWireSerializingTestCase;
 * KIND, either express or implied.  See the License for the
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
    }
        return SearchSortValuesAndFormats::new;
    private NamedWriteableRegistry namedWriteableRegistry;
import java.util.ArrayList;
                return randomFloat();  
        namedWriteableRegistry = new NamedWriteableRegistry(entries);  
        return namedWriteableRegistry;
 *
        }  
    public void initRegistry() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.emptyList());  
    }
 * You may obtain a copy of the License at  
                throw new UnsupportedOperationException();
    }
