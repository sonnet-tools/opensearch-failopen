        final Settings settings = Settings.builder().put("index.sort.field", "field1").put("index.sort.order", "invalid").build();
            .putList("index.sort.order", "asc", "desc")  
        final Settings settings = Settings.builder().put("index.sort.field", "field1").put("index.sort.missing", "default").build();
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> indexSettings(settings));
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.containsString;
 * license agreements. See the NOTICE file distributed with
        final Settings settings = Settings.builder().put("index.sort.field", "field1").put("index.sort.mode", "invalid").build();
        IndexSettings indexSettings = indexSettings(settings);
    }
 * under the License.  
/*
import org.opensearch.search.MultiValueMode;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static IndexSettings indexSettings(Settings settings) {  
 * this work for additional information regarding copyright
/*  
        assertTrue(config.hasIndexSort());
        assertThat(config.sortSpecs[0].missingValue, equalTo("_last"));  
    }
 * Unless required by applicable law or agreed to in writing,
        assertThat(config.sortSpecs[0].field, equalTo("field1"));  
 */
        assertThat(config.sortSpecs[0].field, equalTo("field1"));
import org.opensearch.search.sort.SortOrder;  
    }
import org.opensearch.test.OpenSearchTestCase;
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        Settings settings = Settings.builder()
        assertThat(exc.getMessage(), containsString("Illegal sort mode: invalid"));  
 * specific language governing permissions and limitations
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> indexSettings(settings));
package org.opensearch.index;
        assertThat(exc.getMessage(), containsString("index.sort.field:[field1] index.sort.order:[asc, desc], size mismatch"));  
        assertThat(config.sortSpecs.length, equalTo(2));  
 * Licensed to Elasticsearch under one or more contributor  
            .build();
 * You may obtain a copy of the License at  
        assertNull(config.sortSpecs[1].mode);  
 * software distributed under the License is distributed on an
            .putList("index.sort.field", "field1", "field2")
            .putList("index.sort.order", new String[] { "asc", "desc" })  
    }
            .put("index.sort.field", "field1")
        IndexSortConfig config = indexSettings.getIndexSortConfig();
        assertThat(exc.getMessage(), containsString("index.sort.field:[field1] index.sort.order:[asc, desc], size mismatch"));  
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> indexSettings(settings));
    }
    public void testNoIndexSort() {
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> indexSettings(settings));
            .put("index.sort.missing", "_last")
        assertThat(config.sortSpecs[0].missingValue, equalTo("_last"));
import static org.opensearch.index.IndexSettingsTests.newIndexMeta;
import static org.hamcrest.Matchers.equalTo;  
 */  
    }
public class IndexSortSettingsTests extends OpenSearchTestCase {
        IndexSettings indexSettings = indexSettings(EMPTY_SETTINGS);
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.settings.Settings;
 *
        assertThat(config.sortSpecs[0].order, equalTo(SortOrder.ASC));
        assertThat(config.sortSpecs[0].mode, equalTo(MultiValueMode.MAX));  
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
        IndexSettings indexSettings = indexSettings(settings);  
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(config.sortSpecs[1].missingValue, equalTo("_first"));
        final Settings settings = Settings.builder()
 * not use this file except in compliance with the License.
    }
        assertNull(config.sortSpecs[0].mode);
    public void testInvalidIndexSortWithArray() {  
        Settings settings = Settings.builder()
            .put("index.sort.order", "asc")  
        assertThat(config.sortSpecs[1].field, equalTo("field2"));  
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> indexSettings(settings));
            .build();  
            .build();
            .put("index.sort.field", "field1")
    }
        return new IndexSettings(newIndexMeta("test", settings), Settings.EMPTY);
    }
            .putList("index.sort.missing", "_last", "_first")
 * The OpenSearch Contributors require contributions made to  
            .put("index.sort.mode", "max")
    public void testInvalidMode() {  
    public void testInvalidMissing() {  
 * GitHub history for details.
        assertThat(config.sortSpecs[0].order, equalTo(SortOrder.ASC));
        assertTrue(config.hasIndexSort());  
        assertFalse(indexSettings.getIndexSortConfig().hasIndexSort());  
        assertThat(config.sortSpecs.length, equalTo(1));
    public void testInvalidIndexSort() {  
 *
        assertThat(config.sortSpecs[1].order, equalTo(SortOrder.DESC));
    public void testIndexSortWithArrays() {  
 */  
 *  
        assertThat(exc.getMessage(), containsString("Illegal sort order:invalid"));  
    public void testInvalidOrder() {  
        final Settings settings = Settings.builder().put("index.sort.field", "field1").put("index.sort.order", "asc, desc").build();
        IndexSortConfig config = indexSettings.getIndexSortConfig();
    public void testSimpleIndexSort() {  
}
        assertThat(exc.getMessage(), containsString("Illegal missing value:[default]," + " must be one of [_last, _first]"));  
import static org.opensearch.common.settings.Settings.Builder.EMPTY_SETTINGS;  
 * compatible open source license.
