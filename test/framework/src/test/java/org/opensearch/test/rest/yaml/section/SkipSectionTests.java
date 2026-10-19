    }  
        SkipSection skipSection = SkipSection.parse(parser);
        SkipSection skipSection = SkipSection.parse(parser);  
        assertEquals("[FOOBAR] skipped, reason: [foobar] unsupported features [warnings]", section.getSkipMessage("FOOBAR"));
 * under the License.  
    }  
 */  
import static org.hamcrest.Matchers.equalTo;  
            version:     " - 0.90.2"
            "foobar"
        parser = createParser(YamlXContent.yamlXContent, """
            reason:      Delete ignores the parent param""", version));
        assertThat(skipSection.getFeatures().get(0), equalTo("regex1"));
/*  
        assertEquals(Version.fromString("0.90.2"), skipSection.getUpperVersion());  
            """);
        SkipSection skipSection = SkipSection.parse(parser);
        assertTrue(section.skip(Version.fromString("1.0.0")));  
import java.util.Collections;  
/*  
        assertThat(skipSection.getFeatures().get(0), equalTo("regex"));
}
    public void testParseSkipSectionBothFeatureAndVersion() throws Exception {
        assertThat(skipSection.getReason(), nullValue());
        SkipSection skipSection = SkipSection.parse(parser);
 *     http://www.apache.org/licenses/LICENSE-2.0
        parser = createParser(YamlXContent.yamlXContent, """  
 * Licensed to Elasticsearch under one or more contributor  
        parser = createParser(YamlXContent.yamlXContent, """  
import org.opensearch.core.common.ParsingException;  
        assertFalse(section.skip(Version.fromString("2.6.0")));
        SkipSection section = new SkipSection("1.0.0 - 1.1.0, 2.1.0 - 2.5.0", Collections.emptyList(), "foobar");
 * KIND, either express or implied.  See the License for the
    public void testParseSkipSectionFeaturesNoVersion() throws Exception {  
 * GitHub history for details.
            features:     regex
        assertThat(skipSection.isVersionCheck(), equalTo(false));  
            reason:      Delete ignores the parent param""");  
    public void testParseSkipSectionAllVersions() throws Exception {  
import static org.hamcrest.Matchers.notNullValue;
    public void testParseSkipSectionNoReason() throws Exception {
import java.util.Locale;
            "6.0.0 - 6.1.0",  
        assertFalse(section.skip(Version.fromString("2.0.0")));  
 *
        assertThat(skipSection.getLowerVersion(), equalTo(VersionUtils.getFirstVersion()));
 * SPDX-License-Identifier: Apache-2.0
        section = new SkipSection(null, Collections.singletonList("warnings"), "foobar");
package org.opensearch.test.rest.yaml.section;
        assertTrue(section.skip(Version.CURRENT));
            reason:      Delete ignores the parent param""");
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(skipSection, notNullValue());
        parser = createParser(YamlXContent.yamlXContent, String.format(Locale.ROOT, """  
        assertThat(skipSection.getLowerVersion(), equalTo(VersionUtils.getFirstVersion()));  
        assertFalse(section.skip(Version.CURRENT));
        assertEquals("[FOOBAR] skipped, reason: [foobar] unsupported features [warnings]", section.getSkipMessage("FOOBAR"));  
        assertThat(skipSection.getFeatures().size(), equalTo(1));
            version:     " all "
 * specific language governing permissions and limitations
        Version version = VersionUtils.randomVersion(random());
    }
 */
        assertThat(skipSection.getFeatures().size(), equalTo(3));  
        assertEquals(Collections.singletonList("regex"), skipSection.getFeatures());
        assertFalse(section.skip(Version.CURRENT));
        assertThat(e.getMessage(), is("version or features is mandatory within skip section"));
        Exception e = expectThrows(ParsingException.class, () -> SkipSection.parse(parser));
/*
        assertEquals("Delete ignores the parent param", skipSection.getReason());
        assertThat(skipSection, notNullValue());
    public void testSkipMultiRange() {
        assertTrue(section.skip(Version.fromString("2.0.0")));  
        parser = createParser(YamlXContent.yamlXContent, "features:     regex");
        );  
        SkipSection section = new SkipSection("6.0.0 - 6.1.0", Collections.singletonList("warnings"), "foobar");
    }  
import org.opensearch.test.VersionUtils;
 * ownership. Elasticsearch licenses this file to you under  
        assertTrue(section.skip(Version.fromString("2.3.0")));
public class SkipSectionTests extends AbstractClientYamlTestFragmentParserTestCase {
    }
        Exception e = expectThrows(ParsingException.class, () -> SkipSection.parse(parser));
        section = new SkipSection("-  2.1.0, 2.2.0 - 2.5.0", Collections.emptyList(), "foobar");
import static org.hamcrest.Matchers.is;
 * The OpenSearch Contributors require contributions made to  
    public void testParseSkipSectionFeatureNoVersion() throws Exception {
import static org.hamcrest.Matchers.nullValue;  
        assertThat(skipSection.isVersionCheck(), equalTo(false));
        assertThat(skipSection.getReason(), nullValue());  
 */  
 * license agreements. See the NOTICE file distributed with
    }
 * not use this file except in compliance with the License.
        parser = createParser(YamlXContent.yamlXContent, """
        SkipSection section = new SkipSection(
 * software distributed under the License is distributed on an
import org.opensearch.Version;
        assertFalse(section.skip(Version.fromString("1.2.0")));
        assertThat(skipSection, notNullValue());
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(VersionUtils.getFirstVersion(), skipSection.getLowerVersion());
        assertThat(skipSection, notNullValue());  
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            randomBoolean() ? Collections.emptyList() : Collections.singletonList("warnings"),
        assertThat(skipSection.getUpperVersion(), equalTo(version));
        assertTrue(section.skip(Version.fromString("2.5.0")));  
        SkipSection skipSection = SkipSection.parse(parser);
 *  
        assertEquals("[FOOBAR] skipped, unsupported features [warnings]", section.getSkipMessage("FOOBAR"));
    public void testParseSkipSectionNoVersionNorFeature() throws Exception {
        assertThat(skipSection.getFeatures().size(), equalTo(0));
    }
        assertThat(skipSection.getFeatures().size(), equalTo(0));  
        parser = createParser(YamlXContent.yamlXContent, "features:     [regex1,regex2,regex3]");
    public void testParseSkipSectionVersionNoFeature() throws Exception {
 *
        assertThat(e.getMessage(), is("reason is mandatory within skip version section"));
    }
        assertThat(skipSection.getReason(), equalTo("Delete ignores the parent param"));
        section = new SkipSection(null, Collections.singletonList("warnings"), null);  
    }
 * compatible open source license.
            """);
import org.opensearch.common.xcontent.yaml.YamlXContent;
        section = new SkipSection(randomBoolean() ? null : "6.0.0 - 6.1.0", Collections.singletonList("boom"), "foobar");  
            version:     " - %s"
 * this file be licensed under the Apache-2.0 license or a
    }
            reason:      Delete ignores the parent param
    public void testMessage() {
        assertTrue(section.skip(Version.fromString("1.1.0")));
        assertThat(skipSection.getReason(), equalTo("Delete ignores the parent param"));  
 * Unless required by applicable law or agreed to in writing,
    public void testSkip() {
        assertThat(skipSection.getFeatures().get(2), equalTo("regex3"));  
        assertTrue(section.skip(Version.fromString("6.0.0")));
            version:     " - 0.90.2"  
        assertThat(skipSection.getFeatures().get(1), equalTo("regex2"));
        assertThat(skipSection.getUpperVersion(), equalTo(Version.CURRENT));
        assertTrue(section.skip(Version.fromString("2.1.0")));
 * You may obtain a copy of the License at  
