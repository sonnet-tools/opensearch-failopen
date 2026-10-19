    }  
    }
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
/*  
import static org.hamcrest.Matchers.equalTo;
public class MultiValuesSourceFieldConfigTests extends AbstractSerializingTestCase<MultiValuesSourceFieldConfig> {  
 *
import org.opensearch.index.query.QueryBuilders;
 * GitHub history for details.
        return new MultiValuesSourceFieldConfig.Builder().setFieldName(field)
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.query.QueryBuilder;  
        ZoneId timeZone = randomBoolean() ? randomZone() : null;
            .setMissing(missing)
import org.opensearch.test.AbstractSerializingTestCase;
/*  
            .setTimeZone(timeZone)
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
    protected MultiValuesSourceFieldConfig doParseInstance(XContentParser parser) throws IOException {  
 * not use this file except in compliance with the License.
        return MultiValuesSourceFieldConfig.PARSER.apply(true, true, true).apply(parser, null).build();
package org.opensearch.search.aggregations.support;
 * the Apache License, Version 2.0 (the "License"); you may
        return new NamedWriteableRegistry(new SearchModule(Settings.EMPTY, Collections.emptyList()).getNamedWriteables());
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(e.getMessage(), equalTo("[field] and [script] cannot both be configured.  Please specify one or the other."));  
import org.opensearch.core.xcontent.NamedXContentRegistry;
    @Override
 * software distributed under the License is distributed on an
        return new NamedXContentRegistry(new SearchModule(Settings.EMPTY, Collections.emptyList()).getNamedXContents());
 */  
 * The OpenSearch Contributors require contributions made to  
import java.util.Collections;
            IllegalArgumentException.class,  
    @Override
import java.time.ZoneId;
        QueryBuilder filter = randomBoolean() ? QueryBuilders.termQuery(randomAlphaOfLength(10), randomAlphaOfLength(10)) : null;  
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.script.Script;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
        assertThat(e.getMessage(), equalTo("[field] and [script] cannot both be null.  Please specify one or the other."));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new MultiValuesSourceFieldConfig.Builder().build());  
    public void testMissingFieldScript() {
 *
import org.opensearch.search.SearchModule;  
            .setScript(null)  
import org.opensearch.common.settings.Settings;
 */
    }
    protected NamedXContentRegistry xContentRegistry() {  
            .setFilter(filter)
 * under the License.  
 */  
    public void testBothFieldScript() {
import org.opensearch.core.common.io.stream.Writeable;  
    }
 * SPDX-License-Identifier: Apache-2.0
        );
    protected Writeable.Reader<MultiValuesSourceFieldConfig> instanceReader() {
        Object missing = randomBoolean() ? randomAlphaOfLength(10) : null;
        String field = randomAlphaOfLength(10);  
    @Override
    @Override  
 * You may obtain a copy of the License at  
import java.io.IOException;  
 * Modifications Copyright OpenSearch Contributors. See
}  
    }  
    }
        IllegalArgumentException e = expectThrows(
            .build();  
 * Licensed to Elasticsearch under one or more contributor  
/*
        return MultiValuesSourceFieldConfig::new;
    protected MultiValuesSourceFieldConfig createTestInstance() {
    }
 * this work for additional information regarding copyright
 *  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
            () -> new MultiValuesSourceFieldConfig.Builder().setFieldName("foo").setScript(new Script("foo")).build()
