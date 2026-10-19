    public void testVersionRangeUpperIncluded() {
        assertThrows(IllegalArgumentException.class, () -> DenyJvmVersionsParser.parse("[*, *: know to be flawed version"));  
        assertThrows(IllegalArgumentException.class, () -> DenyJvmVersionsParser.parse("[]: know to be flawed version"));
        assertThat(predicate.test(Version.parse("11.0.2")), is(true));
 *
        assertThat(predicate.test(Version.parse("11.0.13+1")), is(true));
        assertThat(predicate.test(Version.parse("11.0.15")), is(false));
        final VersionPredicate predicate = DenyJvmVersionsParser.parse("[11.0.2, 11.0.14): know to be flawed version");  
    public void testSingleVersion() {  
        assertThat(predicate.test(Version.parse("11.0.14")), is(true));
        assertThat(predicate.test(Version.parse("11.0.13+1")), is(true));  
        assertThat(predicate.test(Version.parse("11.0.2")), is(true));
import static org.hamcrest.CoreMatchers.is;
        assertThat(predicate.test(Version.parse("11.0.3")), is(false));
        assertThat(predicate.test(Version.parse("11.0.14.1")), is(true));
        final VersionPredicate predicate = DenyJvmVersionsParser.parse("[*, *]: know to be flawed version");  
    public void testVersionRangeLowerAndUpperIncluded() {  
    public void testDefaults() {
        assertThat(predicate.test(Version.parse("17.2.1")), is(true));
        assertThrows(IllegalArgumentException.class, () -> DenyJvmVersionsParser.parse("*, *: know to be flawed version"));
        assertThat(predicate.test(Version.parse("11.0.14")), is(true));
        assertThat(predicate.test(Version.parse("11.0.1")), is(true));
        assertThat(predicate.test(Version.parse("11.0.13+1")), is(true));  
import static org.hamcrest.collection.IsEmptyCollection.empty;
        assertThrows(IllegalArgumentException.class, () -> DenyJvmVersionsParser.parse("11.0.2"));  
        assertThat(predicate.getReason(), equalTo("know to be flawed version"));
import java.lang.Runtime.Version;
    public void testAllVersionsRangeIncluded() {
    }  
        assertThat(predicate.test(Version.parse("11.0.13+1")), is(true));  
        assertThat(predicate.test(Version.parse("11.0.14")), is(true));
        assertThat(predicate.test(Version.parse("11.0.13+1")), is(true));  
        assertThat(predicate.test(Version.parse("11.0.14")), is(true));
        assertThrows(IllegalArgumentException.class, () -> DenyJvmVersionsParser.parse("[,]"));
 */  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(predicate.test(Version.parse("11.0.14.1")), is(false));  
        assertThat(predicate.test(Version.parse("11.0.2")), is(true));
        assertThat(predicate.getReason(), equalTo("know to be flawed version"));
import org.opensearch.bootstrap.jvm.DenyJvmVersionsParser.VersionPredicate;
        assertThat(predicate.test(Version.parse("17.2.1")), is(true));
        assertThat(predicate.test(Version.parse("11.0.1")), is(false));  
        assertThat(predicate.test(Version.parse("11.0.14.1")), is(true));
 * SPDX-License-Identifier: Apache-2.0
        assertThat(predicate.test(Version.parse("11.0.1")), is(false));
        assertThrows(IllegalArgumentException.class, () -> DenyJvmVersionsParser.parse("*, *): know to be flawed version"));
        assertThat(predicate.test(Version.parse("11.0.2")), is(true));
        assertThat(predicate.test(Version.parse("11.0.15")), is(true));  
    }
        assertThat(predicate.test(Version.parse("11.0.1")), is(true));
 * The OpenSearch Contributors require contributions made to  
    public void testAllVersionsRange() {
        assertThat(predicate.test(Version.parse("11.0.2")), is(true));
        assertThat(predicate.getReason(), equalTo("know to be flawed version"));
        assertThat(predicate.test(Version.parse("11.0.14")), is(false));
        assertThat(predicate.getReason(), equalTo("know to be flawed version"));
    }
        assertThat(predicate.test(Version.parse("17.2.1")), is(true));
import static org.hamcrest.CoreMatchers.not;  
    }  
import org.opensearch.test.OpenSearchTestCase;
public class DenyJvmVersionsParserTests extends OpenSearchTestCase {  
        final VersionPredicate predicate = DenyJvmVersionsParser.parse("[11.0.2, 11.0.14]: know to be flawed version");
    }
/*  
    public void testVersionRangeLowerIncluded() {
    }  
        assertThat(predicate.getReason(), equalTo("know to be flawed version"));  
        final VersionPredicate predicate = DenyJvmVersionsParser.parse("(,): know to be flawed version");  
        assertThat(predicate.test(Version.parse("11.0.2")), is(true));
        assertThat(predicate.test(Version.parse("11.0.1")), is(false));  
 * compatible open source license.
        assertThat(predicate.test(Version.parse("11.0.1")), is(false));
        assertThat(predicate.getReason(), equalTo("know to be flawed version"));
        final VersionPredicate predicate = DenyJvmVersionsParser.parse("11.0.2: know to be flawed version");
    public void testIncorrectVersionRanges() {
}
        assertThrows(IllegalArgumentException.class, () -> DenyJvmVersionsParser.parse("(): know to be flawed version"));  
        assertThat(versions, not(empty()));  
    }  
import java.util.Collection;
import static org.hamcrest.CoreMatchers.equalTo;
package org.opensearch.bootstrap.jvm;
        assertThat(predicate.test(Version.parse("11.0.15")), is(true));  
        final Collection<VersionPredicate> versions = DenyJvmVersionsParser.getDeniedJvmVersions();
    }  
        final VersionPredicate predicate = DenyJvmVersionsParser.parse("[11.0.2,): know to be flawed version");  
