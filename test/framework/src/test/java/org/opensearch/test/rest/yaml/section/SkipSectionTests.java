/*
        SkipSection section = new SkipSection(
        parser = createParser(YamlXContent.yamlXContent, """
            """);
        Exception e = expectThrows(ParsingException.class, () -> SkipSection.parse(parser));
        assertThat(skipSection.getLowerVersion(), equalTo(VersionUtils.getFirstVersion()));
        assertThat(skipSection.getLowerVersion(), equalTo(VersionUtils.getFirstVersion()));
        Exception e = expectThrows(ParsingException.class, () -> SkipSection.parse(parser));
    }
        assertThat(skipSection.getReason(), nullValue());
        assertFalse(section.skip(Version.CURRENT));
    public void testParseSkipSectionNoReason() throws Exception {
    public void testParseSkipSectionAllVersions() throws Exception {
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
            randomBoolean() ? Collections.emptyList() : Collections.singletonList("warnings"),
    public void testMessage() {
        parser = createParser(YamlXContent.yamlXContent, "features:     regex");
        assertFalse(section.skip(Version.fromString("1.2.0")));
        parser = createParser(YamlXContent.yamlXContent, """
 *
        assertThat(skipSection.getFeatures().size(), equalTo(1));
            version:     " - %s"
        assertEquals(VersionUtils.getFirstVersion(), skipSection.getLowerVersion());
import org.opensearch.Version;
        assertThat(skipSection.getFeatures().size(), equalTo(0));
    }
        assertThat(skipSection.getFeatures().get(0), equalTo("regex"));
 * Licensed to Elasticsearch under one or more contributor
    public void testParseSkipSectionFeatureNoVersion() throws Exception {
        assertTrue(section.skip(Version.CURRENT));
import static org.hamcrest.Matchers.notNullValue;
            reason:      Delete ignores the parent param
        assertThat(skipSection.getUpperVersion(), equalTo(Version.CURRENT));
import org.opensearch.core.common.ParsingException;
package org.opensearch.test.rest.yaml.section;
import static org.hamcrest.Matchers.is;
import java.util.Locale;
            """);
        assertThat(skipSection.isVersionCheck(), equalTo(false));
            reason:      Delete ignores the parent param""");
        assertThat(e.getMessage(), is("reason is mandatory within skip version section"));
            features:     regex
/*
        SkipSection skipSection = SkipSection.parse(parser);
    }
        );
        assertThat(skipSection, notNullValue());
    }
    }
        assertTrue(section.skip(Version.fromString("1.1.0")));
    }
import static org.hamcrest.Matchers.nullValue;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertTrue(section.skip(Version.fromString("6.0.0")));
        assertEquals(Collections.singletonList("regex"), skipSection.getFeatures());
    public void testSkip() {
        assertThat(skipSection.getFeatures().size(), equalTo(3));
        assertThat(skipSection.getReason(), equalTo("Delete ignores the parent param"));
        section = new SkipSection(randomBoolean() ? null : "6.0.0 - 6.1.0", Collections.singletonList("boom"), "foobar");
    public void testParseSkipSectionBothFeatureAndVersion() throws Exception {
 */
        SkipSection skipSection = SkipSection.parse(parser);
        parser = createParser(YamlXContent.yamlXContent, String.format(Locale.ROOT, """
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
 * KIND, either express or implied.  See the License for the
        assertThat(skipSection.getFeatures().get(1), equalTo("regex2"));
 *
        assertFalse(section.skip(Version.fromString("2.0.0")));
        assertEquals("Delete ignores the parent param", skipSection.getReason());
            "6.0.0 - 6.1.0",
 * Modifications Copyright OpenSearch Contributors. See
        section = new SkipSection(null, Collections.singletonList("warnings"), "foobar");
        assertTrue(section.skip(Version.fromString("1.0.0")));
 * the Apache License, Version 2.0 (the "License"); you may
        SkipSection section = new SkipSection("6.0.0 - 6.1.0", Collections.singletonList("warnings"), "foobar");
    public void testSkipMultiRange() {
 * this work for additional information regarding copyright
    }
        assertThat(skipSection.getReason(), nullValue());
        parser = createParser(YamlXContent.yamlXContent, """
 * compatible open source license.
            version:     " - 0.90.2"
 * this file be licensed under the Apache-2.0 license or a
        SkipSection skipSection = SkipSection.parse(parser);
    }
 * You may obtain a copy of the License at
    }
        assertThat(e.getMessage(), is("version or features is mandatory within skip section"));
 * SPDX-License-Identifier: Apache-2.0
        SkipSection skipSection = SkipSection.parse(parser);
        assertTrue(section.skip(Version.fromString("2.0.0")));
        assertFalse(section.skip(Version.fromString("2.6.0")));
        assertThat(skipSection.getReason(), equalTo("Delete ignores the parent param"));
 */
        section = new SkipSection(null, Collections.singletonList("warnings"), null);
    public void testParseSkipSectionNoVersionNorFeature() throws Exception {
import org.opensearch.test.VersionUtils;
 *
            reason:      Delete ignores the parent param""");
 * under the License.
        assertThat(skipSection.isVersionCheck(), equalTo(false));
        assertEquals("[FOOBAR] skipped, reason: [foobar] unsupported features [warnings]", section.getSkipMessage("FOOBAR"));
 * specific language governing permissions and limitations
    public void testParseSkipSectionFeaturesNoVersion() throws Exception {
import static org.hamcrest.Matchers.equalTo;
        assertThat(skipSection.getFeatures().size(), equalTo(0));
        parser = createParser(YamlXContent.yamlXContent, """
}
        assertThat(skipSection.getFeatures().get(0), equalTo("regex1"));
        SkipSection skipSection = SkipSection.parse(parser);
        assertThat(skipSection, notNullValue());
 * The OpenSearch Contributors require contributions made to
        section = new SkipSection("-  2.1.0, 2.2.0 - 2.5.0", Collections.emptyList(), "foobar");
        assertTrue(section.skip(Version.fromString("2.1.0")));
            version:     " all "
        assertThat(skipSection, notNullValue());
        SkipSection section = new SkipSection("1.0.0 - 1.1.0, 2.1.0 - 2.5.0", Collections.emptyList(), "foobar");
        assertThat(skipSection.getUpperVersion(), equalTo(version));
 * ownership. Elasticsearch licenses this file to you under
        assertThat(skipSection.getFeatures().get(2), equalTo("regex3"));
    public void testParseSkipSectionVersionNoFeature() throws Exception {
        assertTrue(section.skip(Version.fromString("2.5.0")));
        assertTrue(section.skip(Version.fromString("2.3.0")));
        assertEquals("[FOOBAR] skipped, unsupported features [warnings]", section.getSkipMessage("FOOBAR"));
 * Unless required by applicable law or agreed to in writing,
        assertFalse(section.skip(Version.CURRENT));
            "foobar"
            version:     " - 0.90.2"
        assertEquals("[FOOBAR] skipped, reason: [foobar] unsupported features [warnings]", section.getSkipMessage("FOOBAR"));
 * software distributed under the License is distributed on an
 * GitHub history for details.
        parser = createParser(YamlXContent.yamlXContent, "features:     [regex1,regex2,regex3]");
            reason:      Delete ignores the parent param""", version));
public class SkipSectionTests extends AbstractClientYamlTestFragmentParserTestCase {
        Version version = VersionUtils.randomVersion(random());
import java.util.Collections;
        assertThat(skipSection, notNullValue());
import org.opensearch.common.xcontent.yaml.YamlXContent;
/*
 */
        assertEquals(Version.fromString("0.90.2"), skipSection.getUpperVersion());
