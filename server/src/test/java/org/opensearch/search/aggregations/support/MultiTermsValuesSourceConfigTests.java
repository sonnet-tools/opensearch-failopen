        assertThat(e.getMessage(), equalTo("[field] and [script] cannot both be null.  Please specify one or the other."));
 * this file be licensed under the Apache-2.0 license or a
            .build();  
import java.time.ZoneId;
import org.opensearch.test.AbstractSerializingTestCase;
import org.opensearch.core.xcontent.NamedXContentRegistry;
}
/*  
        Object missing = randomBoolean() ? randomAlphaOfLength(10) : null;
    @Override
 *
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new MultiTermsValuesSourceConfig.Builder().build());  
        return new MultiTermsValuesSourceConfig.Builder().setFieldName(field)
 */  
import org.opensearch.script.Script;  
import org.opensearch.search.SearchModule;
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collections;  
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
    @Override  
            .setScript(script)
 * The OpenSearch Contributors require contributions made to  
        String field = randomAlphaOfLength(10);
    protected MultiTermsValuesSourceConfig doParseInstance(XContentParser parser) throws IOException {
    }  
    protected MultiTermsValuesSourceConfig createTestInstance() {  
    @Override  
    }
        return new NamedXContentRegistry(new SearchModule(Settings.EMPTY, Collections.emptyList()).getNamedXContents());
    }  
        return MultiTermsValuesSourceConfig.PARSER.apply(true, true, true, true).apply(parser, null).build();
    protected NamedXContentRegistry xContentRegistry() {
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.common.settings.Settings;
        return MultiTermsValuesSourceConfig::new;
            .setTimeZone(timeZone)
        return new NamedWriteableRegistry(new SearchModule(Settings.EMPTY, Collections.emptyList()).getNamedWriteables());  
    public void testMissingFieldScript() {
    @Override
        Script script = randomBoolean() ? new Script(randomAlphaOfLength(10)) : null;
    }  
    protected Writeable.Reader<MultiTermsValuesSourceConfig> instanceReader() {
    }
import org.opensearch.core.common.io.stream.Writeable;  
 * compatible open source license.
package org.opensearch.search.aggregations.support;
public class MultiTermsValuesSourceConfigTests extends AbstractSerializingTestCase<MultiTermsValuesSourceConfig> {
    }
    @Override  
        ZoneId timeZone = randomBoolean() ? randomZone() : null;  
            .setMissing(missing)  
import java.io.IOException;
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
