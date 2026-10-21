    public static final Version V_3_0_0 = new Version(3000099, org.apache.lucene.util.Version.LUCENE_10_1_0);
    public static final Version V_2_19_1 = new Version(2190199, org.apache.lucene.util.Version.LUCENE_9_12_1);
    public static final int V_EMPTY_ID = 0;
/**
        return fromStringSlow(version);
    }
        this.minIndexCompatVersion = null;
        }
    public static final Version V_2_2_0 = new Version(2020099, org.apache.lucene.util.Version.LUCENE_9_3_0);
                if (candidateVersion.major == major - 1 && candidateVersion.isRelease() && after(candidateVersion)) {
            }
    }
        return version1.id > version2.id ? version1 : version2;
        return build > 50 && build < 99;
     */
    /**
/*
    protected Version minCompatVersion = null;
import java.io.IOException;
    public static final Version V_2_0_0 = new Version(2000099, org.apache.lucene.util.Version.LUCENE_9_1_0);
    /*
                    + "] to match V_\\d+_\\d+_\\d+";
    }
import java.util.Map;
import java.lang.reflect.Field;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public static void main(String[] args) {
                            final int revision = Integer.valueOf(fields[3]) * REVISION_SHIFT;
                } else if (buildStr.startsWith("RC") || buildStr.startsWith("rc")) {
                        if (fields.length == 5) {
                }
        }
    public static final Version V_2_19_4 = new Version(2190499, org.apache.lucene.util.Version.LUCENE_9_12_3);
        if (known != null) {
    public static List<Version> getDeclaredVersions(final Class<?> versionClass) {
     * code that is used to read / write file formats like transaction logs, cluster state, and index metadata.
                    if (bwcVersion != null && candidateVersion.minor < bwcVersion.minor) {
            luceneVersion = versions.get(index).luceneVersion;
        return Integer.compare(this.id, other.id);
    // UNRELEASED
        }
                throw new IllegalArgumentException("Version parts must be <= 99");
        }
                                expectedId = (major + minor + revision + 99);
    }
        }
        return Version.min(this, fromId((bwcMajor * MAJOR_SHIFT + bwcMinor * MINOR_SHIFT + 99) ^ MASK));
 * SPDX-License-Identifier: Apache-2.0
    }
import java.util.HashMap;
    }
            int m = major == 1 ? 7 : major == 2 ? 8 : major;
            "Version: %s, Build: %s/%s/%s/%s, JVM: %s",
        assert CURRENT.luceneVersion.equals(org.apache.lucene.util.Version.LATEST) : "Version must be upgraded to ["
    public static final Version V_2_11_0 = new Version(2110099, org.apache.lucene.util.Version.LUCENE_9_7_0);
        return (major * MAJOR_SHIFT + minor * MINOR_SHIFT + revision * REVISION_SHIFT + build) ^ MASK;
    protected Version computeMinIndexCompatVersion() {
    }
            }
            assert false : "Version [" + tmp + "] is declared but absent from the switch statement in Version#fromId";
            this.id = id ^ MASK;
            + CURRENT.luceneVersion
    }
    public static final Version V_2_7_0 = new Version(2070099, org.apache.lucene.util.Version.LUCENE_9_5_0);
    public static final Version V_3_7_1 = new Version(3070199, org.apache.lucene.util.Version.LUCENE_10_4_0);
    /**
    public static final Version V_2_19_3 = new Version(2190399, org.apache.lucene.util.Version.LUCENE_9_12_2);
            sb.append(build);
 * OpenSearch Version Class
    public static final Version V_3_7_0 = new Version(3070099, org.apache.lucene.util.Version.LUCENE_10_4_0);
                versions.add(((Version) field.get(null)));
            int om = other.major == 1 ? 7 : other.major == 2 ? 8 : other.major;
            id &= 0xF7FFFFFF;
    }
    }
        }
    static {
     * The unreleased last major is the next major release, e.g. _3_.0.0
            final int betaOffset = 25; // 0 - 24 is taking by alpha builds
     * Extracts a sorted list of declared version constants from a class.
            // all major versions from 3 onwards are compatible with last minor series of the previous major
     *
        assert compatible == false || Math.max(a, b) - Math.min(a, b) <= 1;
    }
    public static final Version V_2_6_1 = new Version(2060199, org.apache.lucene.util.Version.LUCENE_9_5_0);
                    final Version maybePrevious = builder.put(version.id, version);
                }
    public static final Version V_2_10_0 = new Version(2100099, org.apache.lucene.util.Version.LUCENE_9_7_0);
    }
        return builder.value(toString());
    }
     */
    public static final Version V_2_19_6 = new Version(2190699, org.apache.lucene.util.Version.LUCENE_9_12_3);
            }
    public boolean equals(Object o) {
        } else {
        // OpenSearch version 2 is the functional equivalent of predecessor version 8
        return build == 99;
        }
     * is a beta or RC release then the version itself is returned.
        final Version cached = stringToVersion.get(version);
        System.out.println(versionOutput);
            // we reverse the version id calculation based on some assumption as we can't reliably reverse the modulo
    public static final Version V_2_4_2 = new Version(2040299, org.apache.lucene.util.Version.LUCENE_9_4_2);
 * KIND, either express or implied.  See the License for the
    protected static final Map<String, Version> stringToVersion;
    }
import org.opensearch.common.annotation.PublicApi;
 */
        return version1.id < version2.id ? version1 : version2;
     * this is used to ensure the version id for new versions of OpenSearch are always less than the predecessor versions
    public static final Version V_3_1_0 = new Version(3010099, org.apache.lucene.util.Version.LUCENE_10_2_1);
     */
    /**
        String prefix;
        if (id != 0 && (id & MASK) == 0) {
    public static final Version V_2_13_1 = new Version(2130199, org.apache.lucene.util.Version.LUCENE_9_10_0);
            // that we know about
    public static final Version V_2_9_0 = new Version(2090099, org.apache.lucene.util.Version.LUCENE_9_7_0);
                    if (Assertions.ENABLED) {
        this.build = (byte) (id % VERSION_SHIFT);
 * Unless required by applicable law or agreed to in writing,
            }
     */
    public static final Version V_2_8_0 = new Version(2080099, org.apache.lucene.util.Version.LUCENE_9_6_0);
        if (major >= 3) {
 * Licensed to Elasticsearch under one or more contributor
        // OpenSearch version 1 is the functional equivalent of predecessor version 7
        } else {
                    assert maybePrevious == null : "expected ["
        }
    public static final Version V_2_11_1 = new Version(2110199, org.apache.lucene.util.Version.LUCENE_9_7_0);
        int index = Collections.binarySearch(versions, tmp);
                            final int expectedId;
    public static final Version V_3_4_0 = new Version(3040099, org.apache.lucene.util.Version.LUCENE_10_3_2);
    public static final Version V_3_3_1 = new Version(3030199, org.apache.lucene.util.Version.LUCENE_10_3_1);
        }
                } else if (buildStr.startsWith("Beta") || buildStr.startsWith("beta")) {
            if (major <= 2) {
    public boolean before(Version version) {
 *
    public final byte major;
    }
        return fromIdSlow(id);
                    builderByString.put(version.toString(), version);
    public static final Version V_2_17_2 = new Version(2170299, org.apache.lucene.util.Version.LUCENE_9_11_1);
    public static final Version V_3_5_1 = new Version(3050199, org.apache.lucene.util.Version.LUCENE_10_3_2);
        }
        final int bwcMinor = 0;
        // we start from version 1 for opensearch, so ignore the 0 (empty) version
    // lazy initialized because we don't yet have the declared versions ready when instantiating the cached Version
    }
            return false;
    protected Version minIndexCompatVersion = null;
    public static final Version V_3_9_0 = new Version(3090099, org.apache.lucene.util.Version.LUCENE_10_5_1);
     * Returns the version given its string representation, current version if the argument is null or empty
        final String versionOutput = String.format(
        builder.put(V_EMPTY_ID, V_EMPTY);
    public static final Version V_2_3_0 = new Version(2030099, org.apache.lucene.util.Version.LUCENE_9_3_0);
            Build.CURRENT.type().displayName(),
package org.opensearch;
 * specific language governing permissions and limitations
     */
 */
import java.util.Collections;
        return versions;
                            if (major > 0 && major < 6000000) {
 * not use this file except in compliance with the License.
     * to communicate with a node running the current version. The returned version
    /**
                    }
                                + " should not have a build qualifier";
     */
    public static final Version V_2_13_0 = new Version(2130099, org.apache.lucene.util.Version.LUCENE_9_10_0);
            return Integer.compare(m, om);
            this.versionString = legacyFriendlyIdToString(versionId);
    public static final Version V_2_2_1 = new Version(2020199, org.apache.lucene.util.Version.LUCENE_9_3_0);
        return Integer.compare(major, other.major);
            }
    public static final Version V_2_17_0 = new Version(2170099, org.apache.lucene.util.Version.LUCENE_9_11_1);
    public static Version max(Version version1, Version version2) {
    public static class UnsupportedVersionException extends RuntimeException {
     * indicating a release the (internal) format of the id is there so we can easily do after/before checks on the id
        return version.id > id;
    public boolean isCompatible(Version version) {
                            final int minor = Integer.valueOf(fields[2]) * MINOR_SHIFT;
            return Version.CURRENT;
        }
                    build = Integer.parseInt(buildStr.substring(2)) + 50;
        public String getVersionString() {
            final int rawMajor = Integer.parseInt(parts[0]);
        for (final Field field : fields) {
    public static final Version V_2_14_1 = new Version(2140199, org.apache.lucene.util.Version.LUCENE_9_10_0);
            + org.apache.lucene.util.Version.LATEST
        // Our best guess is to use the same Lucene version as the previous
        Collections.sort(versions);
 * compatible open source license.
            prefix = "";
/*
            if (false == Modifier.isStatic(mod) && Modifier.isFinal(mod) && Modifier.isPublic(mod)) {
            sb.append("-rc");
    public static final int MASK = 0x08000000;
                if (buildStr.startsWith("alpha")) {
                    assert build < 25 : "expected a alpha build but " + build + " >= 25";
            final int revision = Integer.parseInt(parts[2]) * REVISION_SHIFT;
            sb.append(build - 25);
        builderByString.put(V_EMPTY.toString(), V_EMPTY);
    public int hashCode() {
            // this version is older than any supported version, so we
    private static Version fromStringSlow(String version) {
        }
     * All listed versions MUST be released versions, except the last major, the last minor and the last revision. ONLY those are required
                } else {
    public static final Version V_2_15_0 = new Version(2150099, org.apache.lucene.util.Version.LUCENE_9_10_0);
        Version tmp = new Version(id ^ MASK, org.apache.lucene.util.Version.LATEST);
            Version bwcVersion = null;
        this.luceneVersion = Objects.requireNonNull(luceneVersion);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * The unreleased last minor is the current major with a upped minor: 2._5_.0
     * The unreleased revision is the very release with a upped revision 2.4._1_
    private static String legacyFriendlyIdToString(int versionId) {
                        + version
            throw new IllegalArgumentException("illegal version format - snapshot labels are not supported");
import java.util.List;
    public static final Version V_3_5_0 = new Version(3050099, org.apache.lucene.util.Version.LUCENE_10_3_2);
    }
    public final byte minor;
    /**
    public static final Version CURRENT = V_3_10_0;
                } catch (final RuntimeException e) {
    @SuppressForbidden(reason = "System.out.*")
    static class DeclaredVersionsHolder {
    /**
    public static final Version V_2_6_0 = new Version(2060099, org.apache.lucene.util.Version.LUCENE_9_5_0);
    public static final Version V_2_19_0 = new Version(2190099, org.apache.lucene.util.Version.LUCENE_9_12_1);
        try {
                final String fieldName = declaredField.getName();
        }
        // comparing Legacy 7x for bwc
    public static final Version V_2_9_1 = new Version(2090199, org.apache.lucene.util.Version.LUCENE_9_7_0);
        final int bwcMajor = major - 1;
    public static final Version V_3_2_0 = new Version(3020099, org.apache.lucene.util.Version.LUCENE_10_2_2);
                    build = Integer.parseInt(buildStr.substring(5));
        if (index == -1) {
            super(String.format(Locale.ROOT, "Unsupported version [%s]", legacyFriendlyIdToString(versionId)));
        if (version.endsWith("-SNAPSHOT")) {
    }
        sb.append(major).append('.').append(minor).append('.').append(revision);
        } else {
                    bwcVersion = candidateVersion;
    }
                final Version candidateVersion = DeclaredVersionsHolder.DECLARED_VERSIONS.get(i);
     * have an alpha version.
        private final String versionString;
        // flip the 28th bit of the ID; identify as an opensearch vs legacy system:
    protected static final Map<Integer, Version> idToVersion;
 */
        }
            }
 * @opensearch.api
    }
     * Exception thrown when an unsupported version ID is encountered.
            );
                                + "] but was ["
     * is not cheap. Since computing the minimum compatibility version can occur often, we use this holder to compute the declared versions
        return Version.min(this, fromId(maskId(1000099)));
    public static int computeID(int major, int minor, int revision, int build) {
        if ((versionId & MASK) != 0) {
        return compatible;
        }
    public final byte revision;
        List<Version> versions = DeclaredVersionsHolder.DECLARED_VERSIONS;
                throw new RuntimeException(e);
        }
    public Version minimumCompatibilityVersion() {
     * as unreleased versions.
    public boolean isRC() {
        int major = (versionId / MAJOR_SHIFT) % VERSION_SHIFT;
                            } else {
            switch (field.getName()) {
    public static final Version V_2_4_0 = new Version(2040099, org.apache.lucene.util.Version.LUCENE_9_4_1);
        // todo: remove the following when removing legacy support in 3.0.0
     */
    public boolean onOrAfter(Version version) {
 * Modifications Copyright OpenSearch Contributors. See
                        final String[] fields = fieldName.split("_");
            res = computeMinIndexCompatVersion();
    public static final Version V_3_3_2 = new Version(3030299, org.apache.lucene.util.Version.LUCENE_10_3_1);
        if (isAlpha()) {
}
        } catch (NumberFormatException e) {
        if (parts.length < 3 || parts.length > 4) {
     * version. Ie a node needs to have at least the return version in order
        StringBuilder sb = new StringBuilder();
     * Returns the minimum compatible version based on the current
                            final int major = Integer.valueOf(fields[1]) * MAJOR_SHIFT;
    }
     * We need the declared versions when computing the minimum compatibility version. As computing the declared versions uses reflection it
    public int compareTo(Version other) {
                case "V_EMPTY":
    public static final Version V_2_15_1 = new Version(2150199, org.apache.lucene.util.Version.LUCENE_9_10_0);
            prefix = "ES ";
            minIndexCompatVersion = res;
 * this work for additional information regarding copyright
                        + maybePrevious
     * Note: This has been introduced in version 5 of the OpenSearch predecessor. Previous versions will never
        this.minor = (byte) ((id / MINOR_SHIFT) % VERSION_SHIFT);
 *
    @Override
        if (cached != null) {
                b += 6; // for legacy compatibility up to version 2.x (to compare minCompat)
            throw new UnsupportedVersionException(id);
        return version.id >= id;
    public static final Version V_2_7_1 = new Version(2070199, org.apache.lucene.util.Version.LUCENE_9_5_0);
        }
    public static final Version V_3_8_1 = new Version(3080199, org.apache.lucene.util.Version.LUCENE_10_5_0);
    public static final Version V_2_1_0 = new Version(2010099, org.apache.lucene.util.Version.LUCENE_9_2_0);
        if (major == 7 || other.major == 7 || major == 6 || other.major == 6) {
        if (id != 0) {
        if (a == 7 || b == 7 || a == 6 || b == 6) {
                continue;
     */
                    build = betaOffset + Integer.parseInt(buildStr.substring(4));
                        }
    @Override
                if (fieldName.equals("CURRENT") || fieldName.equals("V_EMPTY")) {
    public static final Version V_2_18_0 = new Version(2180099, org.apache.lucene.util.Version.LUCENE_9_12_0);
            }
     * can't be used with this version. This should also be used for file based serialization backwards compatibility ie. on serialization
            return bwcVersion == null ? this : bwcVersion;
    /**
                    }
 */
     */
            if (version.major <= 2) {
    private static final int REVISION_SHIFT = VERSION_SHIFT;
    public boolean onOrBefore(Version version) {
        int a = major;
    Version(int id, org.apache.lucene.util.Version luceneVersion) {
     * The logic for ID is: XXYYZZAA, where XX is major version, YY is minor version, ZZ is revision, and AA is alpha/beta/rc indicator AA
            throw new IllegalArgumentException(
        int minor = (versionId / MINOR_SHIFT) % VERSION_SHIFT;
import org.opensearch.core.common.Strings;
            if (field.getType() != Version.class) {
            }
    public static final Version V_2_12_0 = new Version(2120099, org.apache.lucene.util.Version.LUCENE_9_9_2);
            assert field.getName().matches("V(_\\d+)+(_(alpha|beta|rc)\\d+)?") : field.getName();
            Locale.ROOT,
                            assert version.id == expectedId : "expected version ["
        }
    public static final Version V_2_12_1 = new Version(2120199, org.apache.lucene.util.Version.LUCENE_9_9_2);
    public static Version fromString(String version) {
    public static final Version V_2_0_1 = new Version(2000199, org.apache.lucene.util.Version.LUCENE_9_1_0);
 *     http://www.apache.org/licenses/LICENSE-2.0
        final List<Version> versions = new ArrayList<>(fields.length);
    public static Version min(Version version1, Version version2) {
import java.lang.reflect.Modifier;
    public static final Version V_2_8_1 = new Version(2080199, org.apache.lucene.util.Version.LUCENE_9_6_0);
                                + fieldName
    public final int id;
        return build < 25;
import org.opensearch.core.Assertions;
    /**
            try {
    public static final Version V_2_4_1 = new Version(2040199, org.apache.lucene.util.Version.LUCENE_9_4_2);
    // RELEASED
                assert fieldName.matches("V_\\d+_\\d+_\\d+(_alpha[1,2]|_beta[1,2]|_rc[1,2])?") : "expected Version field ["
        for (final Field declaredField : Version.class.getFields()) {
            sb.append(build - 50);
        Version version = (Version) o;
 * software distributed under the License is distributed on an
            res = computeMinCompatVersion();
        if (o == null || getClass() != o.getClass()) {
        }
     */
                                + "] to have id ["
    private static final int MAJOR_SHIFT = VERSION_SHIFT * VERSION_SHIFT * VERSION_SHIFT;
                }
    }
                    continue;
        return sb.toString();
        if (id != version.id) {
 *
    public boolean isBeta() {
        return prefix + major + "." + minor + "." + revision;
     * Returns true iff this version is an alpha version
            int build = 99;
    public static final Version V_2_19_2 = new Version(2190299, org.apache.lucene.util.Version.LUCENE_9_12_1);
        return res;
                    + fieldName
    public int compareMajor(Version other) {
 * The OpenSearch Contributors require contributions made to
    public final org.apache.lucene.util.Version luceneVersion;
 *
    /**
    public static final Version V_2_17_1 = new Version(2170199, org.apache.lucene.util.Version.LUCENE_9_11_1);
    public static final Version V_3_6_1 = new Version(3060199, org.apache.lucene.util.Version.LUCENE_10_4_0);
        }
            final int minor = Integer.parseInt(parts[1]) * MINOR_SHIFT;
    public static final Version V_2_11_2 = new Version(2110299, org.apache.lucene.util.Version.LUCENE_9_7_0);
            // assume it is the previous major to the oldest Lucene version
    }
        }
     * Returns <code>true</code> iff both version are compatible. Otherwise <code>false</code>
import java.util.Locale;
            System.getProperty("java.version")  // TODO switch back to JvmInfo.jvmInfo().version() after refactoring to core lib
                "the version needs to contain major, minor, and revision, and optionally the build: " + version
                        + "] to be uniquely mapped but saw ["
    }
    }
    public boolean isRelease() {
            this.id = id;
        Version res = minIndexCompatVersion;
    public boolean isAlpha() {
import org.opensearch.common.SuppressForbidden;
            return false;
     */
            sb.append("-alpha");
    public static final Version V_3_9_1 = new Version(3090199, org.apache.lucene.util.Version.LUCENE_10_5_1);
        final Map<String, Version> builderByString = new HashMap<>();
    public static final Version V_2_16_1 = new Version(2160199, org.apache.lucene.util.Version.LUCENE_9_11_1);
            return cached;
    protected int maskId(final int id) {
            for (int i = DeclaredVersionsHolder.DECLARED_VERSIONS.size() - 1; i >= 0; i--) {
    public String toString() {
    private static final int MINOR_SHIFT = VERSION_SHIFT * VERSION_SHIFT;
                        + "] and ["
        final Field[] fields = versionClass.getFields();
            + "] is still set to ["
    public boolean after(Version version) {
    private static final int VERSION_SHIFT = 100; // Two digits per version part
    // instances
        } else if (build < 99) {
        return version.id <= id;
public class Version implements Comparable<Version>, ToXContentFragment {
    public static final Version V_2_18_1 = new Version(2180199, org.apache.lucene.util.Version.LUCENE_9_12_1);
                } catch (final IllegalAccessException e) {
 * this file be licensed under the Apache-2.0 license or a
     *>>
    }
            final int major = rawMajor * MAJOR_SHIFT;
import org.opensearch.core.xcontent.XContentBuilder;
        final Version known = idToVersion.get(id);
    // instances
    public static final Version V_3_8_0 = new Version(3080099, org.apache.lucene.util.Version.LUCENE_10_5_0);
 * license agreements. See the NOTICE file distributed with
        return version.id < id;
@PublicApi(since = "1.0.0")
        }
                                + expectedId
 * GitHub history for details.
        if (Strings.hasLength(version) == false) {
    public final byte build;
    }
    // lazy initialized because we don't yet have the declared versions ready when instantiating the cached Version
            Build.CURRENT.hash(),
    }
    }
                                + version.id
        idToVersion = Map.copyOf(builder);
            }
 * You may obtain a copy of the License at
                                expectedId = 0x08000000 ^ (major + minor + revision + 99);
                        + "]";
                                + fieldName
            } catch (final IllegalAccessException e) {
        return true;
                String buildStr = parts[3];
     */
        int b = version.major;
        stringToVersion = Map.copyOf(builderByString);
 * under the License.
    public static final Version V_3_6_0 = new Version(3060099, org.apache.lucene.util.Version.LUCENE_10_4_0);
    @Override
                                + "]";
            return known;
            return true;
    public static Version fromId(int id) {
        // least correct for patch versions of known minors since we never
     * testing with other classes-containing-version-constants.
    public static final Version V_EMPTY = new Version(V_EMPTY_ID, org.apache.lucene.util.Version.LATEST);
import org.opensearch.core.xcontent.ToXContentFragment;
                a += 6; // for legacy compatibility up to version 2.x (to compare minCompat)
import java.util.Objects;
    public static final Version V_2_5_0 = new Version(2050099, org.apache.lucene.util.Version.LUCENE_9_4_2);
    public static final Version V_2_16_0 = new Version(2160099, org.apache.lucene.util.Version.LUCENE_9_11_1);
    public static final Version V_2_5_1 = new Version(2050199, org.apache.lucene.util.Version.LUCENE_9_4_2);
    public static final Version V_2_19_5 = new Version(2190599, org.apache.lucene.util.Version.LUCENE_9_12_3);
        if (this == o) {
            luceneVersion = org.apache.lucene.util.Version.fromBits(versions.get(0).luceneVersion.major - 1, 0, 0);
import java.util.ArrayList;
            if (declaredField.getType().equals(Version.class)) {
    }
                    assert false : "Version field [" + fieldName + "] should be public";
        final Map<Integer, Version> builder = new HashMap<>();
     * Example: assume the last release is 2.4.0
                try {
                }
 * the Apache License, Version 2.0 (the "License"); you may
            + "]";
        // update the Lucene dependency for patch versions.
        if (index < 0) {
                    assert build < 50 : "expected a beta build but " + build + " >= 50";
    protected Version computeMinCompatVersion() {
        this.minCompatVersion = null;
    @Override
                        + version.id
     * Returns the maximum version between the 2
    public static final Version V_3_10_0 = new Version(3100099, org.apache.lucene.util.Version.LUCENE_10_5_2);
        return new Version(id ^ MASK, luceneVersion);
            return fromId((major + minor + revision + build) ^ MASK);
                    continue;
                            assert (fields[1].equals("1") || fields[1].equals("6")) && fields[2].equals("0") : "field "
            // opensearch v1.x and v2.x need major translation to compare w/ legacy versions
            if (major > 99000000 || minor > 990000 || revision > 9900) {
     * Returns the minimum created index version that this version supports. Indices created with lower versions
                            }
        }
            Build.CURRENT.getQualifiedVersion(),
        protected static final List<Version> DECLARED_VERSIONS = Collections.unmodifiableList(getDeclaredVersions(Version.class));
            versionId = versionId ^ MASK;
            throw new IllegalArgumentException("unable to parse version " + version, e);
    public static final Version V_2_14_0 = new Version(2140099, org.apache.lucene.util.Version.LUCENE_9_10_0);
            sb.append("-beta");
    /*
        boolean compatible = onOrAfter(version.minimumCompatibilityVersion()) && version.onOrAfter(minimumCompatibilityVersion());
    }
        this.revision = (byte) ((id / REVISION_SHIFT) % VERSION_SHIFT);
                    throw new IllegalArgumentException("unable to parse version " + version);
    private static Version fromIdSlow(int id) {
        int revision = (versionId / REVISION_SHIFT) % VERSION_SHIFT;
        return MASK ^ id;
     * Returns the minimum version between the 2.
        // todo refactor this logic after removing deprecated features
        Version res = minCompatVersion;
    public static final Version V_2_10_1 = new Version(2100199, org.apache.lucene.util.Version.LUCENE_9_7_0);
        // We need at least the major of the Lucene version to be correct.
        if (res == null) {
     *
            final int mod = field.getModifiers();
                        break;
     * values below 25 are for alpha builder (since 5.0), and above 25 and below 50 are beta builds, and below 99 are RC builds, with 99
        return id;
    }
            Build.CURRENT.date(),
     * IMPORTANT: Unreleased vs. Released Versions
        } else {
            }
        this.major = (byte) ((id / MAJOR_SHIFT) % VERSION_SHIFT);
    public static final Version V_3_3_0 = new Version(3030099, org.apache.lucene.util.Version.LUCENE_10_3_1);
        if (res == null) {
    public Version minimumIndexCompatibilityVersion() {
    /**
/*
        return build >= 25 && build < 50;
                        } else {
        private UnsupportedVersionException(int versionId) {
        // version in the list, assuming that it didn't change. This is at
                    final Version version = (Version) declaredField.get(null);
     * The argument would normally be Version.class but is exposed for
     * lazily once.
        }
     * is in most of the cases the smallest major version release unless the current version
        final org.apache.lucene.util.Version luceneVersion;
    }
    @Override
            if (parts.length == 4) {
                case "CURRENT":
        String[] parts = version.split("[.-]");
            index = -2 - index;
                continue;
        return res;
            minCompatVersion = res;
        );
 * ownership. Elasticsearch licenses this file to you under
                    assert false : "Version field [" + fieldName + "] threw [" + e + "] during initialization";
        } else if (isBeta()) {
    }
            return versionString;
