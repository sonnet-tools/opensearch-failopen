            sb.append("-beta");
        // Our best guess is to use the same Lucene version as the previous
    @Override
     */  
        for (final Field declaredField : Version.class.getFields()) {
        for (final Field field : fields) {
    }
    public int compareMajor(Version other) {
        // todo refactor this logic after removing deprecated features
    }
            sb.append(build - 50);
     * We need the declared versions when computing the minimum compatibility version. As computing the declared versions uses reflection it
        return (major * MAJOR_SHIFT + minor * MINOR_SHIFT + revision * REVISION_SHIFT + build) ^ MASK;
    public final byte revision;  
            this.id = id ^ MASK;
     * this is used to ensure the version id for new versions of OpenSearch are always less than the predecessor versions  
            final int betaOffset = 25; // 0 - 24 is taking by alpha builds
                String buildStr = parts[3];  
                            assert version.id == expectedId : "expected version ["
        final org.apache.lucene.util.Version luceneVersion;
        );
                                + expectedId
    public static final Version V_2_8_1 = new Version(2080199, org.apache.lucene.util.Version.LUCENE_9_6_0);  
        String prefix;
     * Returns the minimum compatible version based on the current  
        int major = (versionId / MAJOR_SHIFT) % VERSION_SHIFT;
    public static final Version V_3_6_1 = new Version(3060199, org.apache.lucene.util.Version.LUCENE_10_4_0);
                            final int major = Integer.valueOf(fields[1]) * MAJOR_SHIFT;
                        final String[] fields = fieldName.split("_");
                        + "] and ["
                    build = Integer.parseInt(buildStr.substring(5));
 */  
            }
}
    public static final Version V_2_8_0 = new Version(2080099, org.apache.lucene.util.Version.LUCENE_9_6_0);
                                expectedId = (major + minor + revision + 99);  
        this.revision = (byte) ((id / REVISION_SHIFT) % VERSION_SHIFT);  
    public static final Version V_2_4_1 = new Version(2040199, org.apache.lucene.util.Version.LUCENE_9_4_2);
        }
                b += 6; // for legacy compatibility up to version 2.x (to compare minCompat)
        }  
     * Returns the version given its string representation, current version if the argument is null or empty
                        + maybePrevious
    public static final Version V_2_4_0 = new Version(2040099, org.apache.lucene.util.Version.LUCENE_9_4_1);  
            throw new IllegalArgumentException("illegal version format - snapshot labels are not supported");
    }
            Build.CURRENT.getQualifiedVersion(),
                    assert build < 25 : "expected a alpha build but " + build + " >= 25";  
                assert fieldName.matches("V_\\d+_\\d+_\\d+(_alpha[1,2]|_beta[1,2]|_rc[1,2])?") : "expected Version field ["
 * this work for additional information regarding copyright
     * The unreleased revision is the very release with a upped revision 2.4._1_  
     * as unreleased versions.
    protected static final Map<Integer, Version> idToVersion;
    }
     * Exception thrown when an unsupported version ID is encountered.  
        final Version known = idToVersion.get(id);
        Version res = minCompatVersion;
     * Returns the minimum created index version that this version supports. Indices created with lower versions
            // we reverse the version id calculation based on some assumption as we can't reliably reverse the modulo  
            this.versionString = legacyFriendlyIdToString(versionId);
 */
            return Version.CURRENT;  
        if (res == null) {
    }  
            minIndexCompatVersion = res;  
        this.minor = (byte) ((id / MINOR_SHIFT) % VERSION_SHIFT);
            index = -2 - index;  
    }
            }
                        } else {
    @Override
    public static final Version V_2_19_5 = new Version(2190599, org.apache.lucene.util.Version.LUCENE_9_12_3);
        // update the Lucene dependency for patch versions.
    protected Version minIndexCompatVersion = null;  
            throw new UnsupportedVersionException(id);
            int m = major == 1 ? 7 : major == 2 ? 8 : major;
                } else if (buildStr.startsWith("RC") || buildStr.startsWith("rc")) {
    public boolean isBeta() {  
 * license agreements. See the NOTICE file distributed with
                case "V_EMPTY":  
     */
        }  
/*  
    }
            id &= 0xF7FFFFFF;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static final Version V_2_11_1 = new Version(2110199, org.apache.lucene.util.Version.LUCENE_9_7_0);  
        // todo: remove the following when removing legacy support in 3.0.0
    public static final Version V_2_18_1 = new Version(2180199, org.apache.lucene.util.Version.LUCENE_9_12_1);
                "the version needs to contain major, minor, and revision, and optionally the build: " + version
            // assume it is the previous major to the oldest Lucene version
     */
            return Integer.compare(m, om);  
            }
    public static final Version V_3_6_0 = new Version(3060099, org.apache.lucene.util.Version.LUCENE_10_4_0);  
    public static final Version V_2_14_1 = new Version(2140199, org.apache.lucene.util.Version.LUCENE_9_10_0);
        }
        }  
    private static String legacyFriendlyIdToString(int versionId) {  
     *
    public static final Version V_2_11_0 = new Version(2110099, org.apache.lucene.util.Version.LUCENE_9_7_0);
        this.luceneVersion = Objects.requireNonNull(luceneVersion);
     */
     * The unreleased last minor is the current major with a upped minor: 2._5_.0
    // UNRELEASED
                try {
 *  
            minCompatVersion = res;
        this.minCompatVersion = null;  
        if (cached != null) {  
    public static final int MASK = 0x08000000;
        return build < 25;
 * Modifications Copyright OpenSearch Contributors. See
        this.major = (byte) ((id / MAJOR_SHIFT) % VERSION_SHIFT);
 * You may obtain a copy of the License at  
                                + fieldName  
        return builder.value(toString());  
    public static final Version V_3_5_0 = new Version(3050099, org.apache.lucene.util.Version.LUCENE_10_3_2);
                    assert build < 50 : "expected a beta build but " + build + " >= 50";  
        builder.put(V_EMPTY_ID, V_EMPTY);  
    private static final int MINOR_SHIFT = VERSION_SHIFT * VERSION_SHIFT;
    }
    public static Version max(Version version1, Version version2) {  
    public final int id;  
        }  
        sb.append(major).append('.').append(minor).append('.').append(revision);
    private static final int REVISION_SHIFT = VERSION_SHIFT;
                        }  
        } else {
    public static final Version CURRENT = V_3_10_0;  
        }
    private static Version fromStringSlow(String version) {  
/*  
     * The unreleased last major is the next major release, e.g. _3_.0.0
        int index = Collections.binarySearch(versions, tmp);
    public static final Version V_2_2_1 = new Version(2020199, org.apache.lucene.util.Version.LUCENE_9_3_0);
 *
        return id;  
    public static Version fromString(String version) {
            Build.CURRENT.date(),
                                + "] but was ["  
                if (fieldName.equals("CURRENT") || fieldName.equals("V_EMPTY")) {
        } else {
        idToVersion = Map.copyOf(builder);
            prefix = "";
        }  
import org.opensearch.core.xcontent.ToXContentFragment;
    }
    // instances
        this.build = (byte) (id % VERSION_SHIFT);
        final List<Version> versions = new ArrayList<>(fields.length);
     * to communicate with a node running the current version. The returned version
import org.opensearch.core.xcontent.XContentBuilder;  
                    build = Integer.parseInt(buildStr.substring(2)) + 50;
    public static final Version V_3_3_2 = new Version(3030299, org.apache.lucene.util.Version.LUCENE_10_3_1);
        if (a == 7 || b == 7 || a == 6 || b == 6) {
        } else if (build < 99) {  
    public Version minimumCompatibilityVersion() {  
import java.util.List;
            }  
    public static final Version V_2_17_2 = new Version(2170299, org.apache.lucene.util.Version.LUCENE_9_11_1);
    public boolean equals(Object o) {
                }  
                    + fieldName  
        if (known != null) {
                            } else {
                        + version  
            }  
            return false;
 * the Apache License, Version 2.0 (the "License"); you may
     */
    public static final Version V_3_0_0 = new Version(3000099, org.apache.lucene.util.Version.LUCENE_10_1_0);  
                }
/**
            System.getProperty("java.version")  // TODO switch back to JvmInfo.jvmInfo().version() after refactoring to core lib  
    public int hashCode() {
        private final String versionString;  
            Build.CURRENT.type().displayName(),  
    Version(int id, org.apache.lucene.util.Version luceneVersion) {
                            final int expectedId;
    }
     * values below 25 are for alpha builder (since 5.0), and above 25 and below 50 are beta builds, and below 99 are RC builds, with 99
        // comparing Legacy 7x for bwc  
    protected Version computeMinCompatVersion() {  
     * Returns true iff this version is an alpha version
            throw new IllegalArgumentException(  
    }
    public static final Version V_3_8_1 = new Version(3080199, org.apache.lucene.util.Version.LUCENE_10_5_0);
    public static final Version V_3_2_0 = new Version(3020099, org.apache.lucene.util.Version.LUCENE_10_2_2);
        // We need at least the major of the Lucene version to be correct.  
            if (field.getType() != Version.class) {
        return true;
        if (index < 0) {
    }
        return version.id < id;
    public final org.apache.lucene.util.Version luceneVersion;
        if (major >= 3) {
        protected static final List<Version> DECLARED_VERSIONS = Collections.unmodifiableList(getDeclaredVersions(Version.class));  
     * Extracts a sorted list of declared version constants from a class.
            return known;  
                        break;  
     * indicating a release the (internal) format of the id is there so we can easily do after/before checks on the id
    @SuppressForbidden(reason = "System.out.*")  
    public static final Version V_2_18_0 = new Version(2180099, org.apache.lucene.util.Version.LUCENE_9_12_0);  
    public static final Version V_3_3_1 = new Version(3030199, org.apache.lucene.util.Version.LUCENE_10_3_1);
    }  
        final Version cached = stringToVersion.get(version);
        }
        }
    protected Version computeMinIndexCompatVersion() {
        int a = major;
    public static final Version V_2_12_0 = new Version(2120099, org.apache.lucene.util.Version.LUCENE_9_9_2);
    /**
        }  
    // RELEASED
                    bwcVersion = candidateVersion;
import java.util.Locale;  
        if (version.endsWith("-SNAPSHOT")) {
     */
                            final int minor = Integer.valueOf(fields[2]) * MINOR_SHIFT;  
                }
    public static final Version V_3_4_0 = new Version(3040099, org.apache.lucene.util.Version.LUCENE_10_3_2);  
        return res;
            return false;
                throw new RuntimeException(e);
                final Version candidateVersion = DeclaredVersionsHolder.DECLARED_VERSIONS.get(i);  
    /**
    }
            versionId = versionId ^ MASK;  
    // instances
        }  
        if (isAlpha()) {  
    static {
    public static final Version V_2_6_1 = new Version(2060199, org.apache.lucene.util.Version.LUCENE_9_5_0);
        boolean compatible = onOrAfter(version.minimumCompatibilityVersion()) && version.onOrAfter(minimumCompatibilityVersion());  
        private UnsupportedVersionException(int versionId) {
 */
    @Override
        return build >= 25 && build < 50;
    /**  
                    final Version maybePrevious = builder.put(version.id, version);
        }
            // that we know about
        if (res == null) {
                versions.add(((Version) field.get(null)));
    public static final Version V_2_15_0 = new Version(2150099, org.apache.lucene.util.Version.LUCENE_9_10_0);
 * compatible open source license.
        } else {
     * Note: This has been introduced in version 5 of the OpenSearch predecessor. Previous versions will never  
            luceneVersion = versions.get(index).luceneVersion;
    public static final Version V_2_7_0 = new Version(2070099, org.apache.lucene.util.Version.LUCENE_9_5_0);  
    /**
    public static class UnsupportedVersionException extends RuntimeException {
        String[] parts = version.split("[.-]");
                }  
        return version1.id < version2.id ? version1 : version2;  
                        + "] to be uniquely mapped but saw ["  
    public static final Version V_2_5_1 = new Version(2050199, org.apache.lucene.util.Version.LUCENE_9_4_2);  
    public static final Version V_2_19_6 = new Version(2190699, org.apache.lucene.util.Version.LUCENE_9_12_3);
            // opensearch v1.x and v2.x need major translation to compare w/ legacy versions  
            sb.append("-alpha");
                } catch (final RuntimeException e) {
        final Field[] fields = versionClass.getFields();  
            for (int i = DeclaredVersionsHolder.DECLARED_VERSIONS.size() - 1; i >= 0; i--) {
    public static final Version V_2_0_1 = new Version(2000199, org.apache.lucene.util.Version.LUCENE_9_1_0);
import java.io.IOException;
     * is not cheap. Since computing the minimum compatibility version can occur often, we use this holder to compute the declared versions
    public static void main(String[] args) {
     * lazily once.  
     */
    public static final Version V_2_0_0 = new Version(2000099, org.apache.lucene.util.Version.LUCENE_9_1_0);  
                    + "] to match V_\\d+_\\d+_\\d+";
            return true;
        return Version.min(this, fromId(maskId(1000099)));
    public static final Version V_2_10_1 = new Version(2100199, org.apache.lucene.util.Version.LUCENE_9_7_0);
            Locale.ROOT,  
            if (declaredField.getType().equals(Version.class)) {  
    }
 *
    public static final Version V_2_16_1 = new Version(2160199, org.apache.lucene.util.Version.LUCENE_9_11_1);
                    continue;
                    build = betaOffset + Integer.parseInt(buildStr.substring(4));
import org.opensearch.core.common.Strings;
import org.opensearch.core.Assertions;  
        }
        // OpenSearch version 2 is the functional equivalent of predecessor version 8  
 * @opensearch.api
        // OpenSearch version 1 is the functional equivalent of predecessor version 7
 * KIND, either express or implied.  See the License for the
                } catch (final IllegalAccessException e) {
/*
    public static Version min(Version version1, Version version2) {
        return Integer.compare(major, other.major);
    public static final Version V_2_2_0 = new Version(2020099, org.apache.lucene.util.Version.LUCENE_9_3_0);  
 * not use this file except in compliance with the License.
                if (buildStr.startsWith("alpha")) {
        Collections.sort(versions);
            + CURRENT.luceneVersion  
                    final Version version = (Version) declaredField.get(null);  
            if (false == Modifier.isStatic(mod) && Modifier.isFinal(mod) && Modifier.isPublic(mod)) {
    /**  
                    }
     * The logic for ID is: XXYYZZAA, where XX is major version, YY is minor version, ZZ is revision, and AA is alpha/beta/rc indicator AA  
    public static final Version V_3_9_0 = new Version(3090099, org.apache.lucene.util.Version.LUCENE_10_5_1);  
     */
                                + " should not have a build qualifier";  
            final int mod = field.getModifiers();  
            assert false : "Version [" + tmp + "] is declared but absent from the switch statement in Version#fromId";
            if (major <= 2) {  
        builderByString.put(V_EMPTY.toString(), V_EMPTY);
    public static final Version V_3_5_1 = new Version(3050199, org.apache.lucene.util.Version.LUCENE_10_3_2);
            switch (field.getName()) {
            + "] is still set to ["
        return versions;
    private static final int MAJOR_SHIFT = VERSION_SHIFT * VERSION_SHIFT * VERSION_SHIFT;  
            final int rawMajor = Integer.parseInt(parts[0]);  
            super(String.format(Locale.ROOT, "Unsupported version [%s]", legacyFriendlyIdToString(versionId)));  
    /*  
            final int major = rawMajor * MAJOR_SHIFT;
        final Map<String, Version> builderByString = new HashMap<>();  
    // lazy initialized because we don't yet have the declared versions ready when instantiating the cached Version  
        return new Version(id ^ MASK, luceneVersion);
    /*
        int b = version.major;  
    }  
    public final byte major;
    }  
    protected static final Map<String, Version> stringToVersion;  
            }
public class Version implements Comparable<Version>, ToXContentFragment {
    public static final Version V_2_17_1 = new Version(2170199, org.apache.lucene.util.Version.LUCENE_9_11_1);
 */  
        }
    // lazy initialized because we don't yet have the declared versions ready when instantiating the cached Version
    public static final Version V_2_3_0 = new Version(2030099, org.apache.lucene.util.Version.LUCENE_9_3_0);
        return fromStringSlow(version);  
            }
    protected Version minCompatVersion = null;
            final int minor = Integer.parseInt(parts[1]) * MINOR_SHIFT;
        return version1.id > version2.id ? version1 : version2;
    public static final Version V_2_4_2 = new Version(2040299, org.apache.lucene.util.Version.LUCENE_9_4_2);  
            // all major versions from 3 onwards are compatible with last minor series of the previous major
        } catch (NumberFormatException e) {  
     *
    public boolean isRelease() {
 *  
 * specific language governing permissions and limitations
     *>>  
    public static final Version V_3_1_0 = new Version(3010099, org.apache.lucene.util.Version.LUCENE_10_2_1);
import java.lang.reflect.Field;  
        if (Strings.hasLength(version) == false) {
     * Returns the minimum version between the 2.  
    @Override
        return MASK ^ id;  
     */
        final int bwcMajor = major - 1;  
        // we start from version 1 for opensearch, so ignore the 0 (empty) version  
 * SPDX-License-Identifier: Apache-2.0
    public static final Version V_2_9_1 = new Version(2090199, org.apache.lucene.util.Version.LUCENE_9_7_0);
     * All listed versions MUST be released versions, except the last major, the last minor and the last revision. ONLY those are required  
        // flip the 28th bit of the ID; identify as an opensearch vs legacy system:
        if (id != version.id) {  
            );
                                + "]";
                            }
        if (id != 0 && (id & MASK) == 0) {
    }
            int build = 99;
        StringBuilder sb = new StringBuilder();
        if (parts.length < 3 || parts.length > 4) {
        return Integer.compare(this.id, other.id);
    public static final Version V_2_12_1 = new Version(2120199, org.apache.lucene.util.Version.LUCENE_9_9_2);  
            Build.CURRENT.hash(),
package org.opensearch;
     * is a beta or RC release then the version itself is returned.
                        if (fields.length == 5) {  
        } else {
                    assert false : "Version field [" + fieldName + "] threw [" + e + "] during initialization";
     * have an alpha version.
@PublicApi(since = "1.0.0")  
            if (version.major <= 2) {  
        if (id != 0) {
    /**  
    /**
        }
                                + version.id
            return fromId((major + minor + revision + build) ^ MASK);
    }  
        public String getVersionString() {
    public static Version fromId(int id) {  
    }
    public static final Version V_3_10_0 = new Version(3100099, org.apache.lucene.util.Version.LUCENE_10_5_2);
        Version tmp = new Version(id ^ MASK, org.apache.lucene.util.Version.LATEST);  
        final String versionOutput = String.format(
        return build > 50 && build < 99;
    public static final Version V_2_10_0 = new Version(2100099, org.apache.lucene.util.Version.LUCENE_9_7_0);  
 * The OpenSearch Contributors require contributions made to  
    public static final Version V_3_7_1 = new Version(3070199, org.apache.lucene.util.Version.LUCENE_10_4_0);  
        }  
import org.opensearch.common.SuppressForbidden;
        }
                                expectedId = 0x08000000 ^ (major + minor + revision + 99);
            + org.apache.lucene.util.Version.LATEST
        Version res = minIndexCompatVersion;  
            } catch (final IllegalAccessException e) {  
    public static final Version V_2_13_1 = new Version(2130199, org.apache.lucene.util.Version.LUCENE_9_10_0);
    public final byte build;
        }
        int revision = (versionId / REVISION_SHIFT) % VERSION_SHIFT;
    public static final int V_EMPTY_ID = 0;
    public static final Version V_2_1_0 = new Version(2010099, org.apache.lucene.util.Version.LUCENE_9_2_0);
            res = computeMinCompatVersion();  
 * Licensed to Elasticsearch under one or more contributor  
    }
                final String fieldName = declaredField.getName();
 *     http://www.apache.org/licenses/LICENSE-2.0
                        + "]";
        if ((versionId & MASK) != 0) {
     * The argument would normally be Version.class but is exposed for
    public boolean isCompatible(Version version) {
        return version.id >= id;
        System.out.println(versionOutput);
                    assert maybePrevious == null : "expected ["
    public static final Version V_2_19_2 = new Version(2190299, org.apache.lucene.util.Version.LUCENE_9_12_1);
                throw new IllegalArgumentException("Version parts must be <= 99");
        // least correct for patch versions of known minors since we never  
    public boolean after(Version version) {
        // version in the list, assuming that it didn't change. This is at
    public static final Version V_2_19_4 = new Version(2190499, org.apache.lucene.util.Version.LUCENE_9_12_3);  
    }  
    public static final Version V_3_9_1 = new Version(3090199, org.apache.lucene.util.Version.LUCENE_10_5_1);
    public static final Version V_2_19_1 = new Version(2190199, org.apache.lucene.util.Version.LUCENE_9_12_1);  
    public final byte minor;
    public int compareTo(Version other) {  
            sb.append("-rc");
    public static final Version V_2_9_0 = new Version(2090099, org.apache.lucene.util.Version.LUCENE_9_7_0);
        return prefix + major + "." + minor + "." + revision;  
        return Version.min(this, fromId((bwcMajor * MAJOR_SHIFT + bwcMinor * MINOR_SHIFT + 99) ^ MASK));
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            final int revision = Integer.parseInt(parts[2]) * REVISION_SHIFT;  
    public boolean before(Version version) {  
        Version version = (Version) o;
    /**
    }  
    public boolean onOrBefore(Version version) {
     * testing with other classes-containing-version-constants.  
        } else if (isBeta()) {  
        return version.id <= id;  
    public boolean isRC() {
            }  
    public static final Version V_3_7_0 = new Version(3070099, org.apache.lucene.util.Version.LUCENE_10_4_0);
            // this version is older than any supported version, so we  
 * Unless required by applicable law or agreed to in writing,
    }  
    public boolean isAlpha() {  
    private static final int VERSION_SHIFT = 100; // Two digits per version part  
    public static List<Version> getDeclaredVersions(final Class<?> versionClass) {
            + "]";
import org.opensearch.common.annotation.PublicApi;
    public String toString() {  
    }
                continue;
    public static final Version V_2_7_1 = new Version(2070199, org.apache.lucene.util.Version.LUCENE_9_5_0);
            "Version: %s, Build: %s/%s/%s/%s, JVM: %s",
            assert field.getName().matches("V(_\\d+)+(_(alpha|beta|rc)\\d+)?") : field.getName();  
    }
    }
     * IMPORTANT: Unreleased vs. Released Versions
    /**
        if (major == 7 || other.major == 7 || major == 6 || other.major == 6) {
            return bwcVersion == null ? this : bwcVersion;
     */
    public static final Version V_2_15_1 = new Version(2150199, org.apache.lucene.util.Version.LUCENE_9_10_0);  
            this.id = id;
        int minor = (versionId / MINOR_SHIFT) % VERSION_SHIFT;  
    /**
            try {
        if (index == -1) {
        return compatible;  
    }
    public static final Version V_2_14_0 = new Version(2140099, org.apache.lucene.util.Version.LUCENE_9_10_0);  
        try {
 * ownership. Elasticsearch licenses this file to you under  
     * Returns the maximum version between the 2
    public static final Version V_2_13_0 = new Version(2130099, org.apache.lucene.util.Version.LUCENE_9_10_0);
import java.util.ArrayList;
        assert compatible == false || Math.max(a, b) - Math.min(a, b) <= 1;
    }  
            return cached;
    public static final Version V_2_6_0 = new Version(2060099, org.apache.lucene.util.Version.LUCENE_9_5_0);
    public static final Version V_2_19_0 = new Version(2190099, org.apache.lucene.util.Version.LUCENE_9_12_1);
            }
                case "CURRENT":
    public static final Version V_2_19_3 = new Version(2190399, org.apache.lucene.util.Version.LUCENE_9_12_2);
    public static final Version V_2_11_2 = new Version(2110299, org.apache.lucene.util.Version.LUCENE_9_7_0);
    public static final Version V_EMPTY = new Version(V_EMPTY_ID, org.apache.lucene.util.Version.LATEST);  
    protected int maskId(final int id) {
    }
                    throw new IllegalArgumentException("unable to parse version " + version);
    }  
import java.util.HashMap;
        return sb.toString();
            if (major > 99000000 || minor > 990000 || revision > 9900) {
            res = computeMinIndexCompatVersion();
        }  
            throw new IllegalArgumentException("unable to parse version " + version, e);
import java.util.Collections;  
                    builderByString.put(version.toString(), version);  
    public static final Version V_3_8_0 = new Version(3080099, org.apache.lucene.util.Version.LUCENE_10_5_0);
                    assert false : "Version field [" + fieldName + "] should be public";  
                    if (bwcVersion != null && candidateVersion.minor < bwcVersion.minor) {
                } else if (buildStr.startsWith("Beta") || buildStr.startsWith("beta")) {
                                + "] to have id ["
import java.lang.reflect.Modifier;
    public static final Version V_2_5_0 = new Version(2050099, org.apache.lucene.util.Version.LUCENE_9_4_2);
     * version. Ie a node needs to have at least the return version in order
        assert CURRENT.luceneVersion.equals(org.apache.lucene.util.Version.LATEST) : "Version must be upgraded to ["  
     * Returns <code>true</code> iff both version are compatible. Otherwise <code>false</code>  
     * code that is used to read / write file formats like transaction logs, cluster state, and index metadata.  
            Version bwcVersion = null;  
 * OpenSearch Version Class
                        + version.id
        return fromIdSlow(id);
     * Example: assume the last release is 2.4.0  
        }
    public static final Version V_2_17_0 = new Version(2170099, org.apache.lucene.util.Version.LUCENE_9_11_1);  
        stringToVersion = Map.copyOf(builderByString);  
    private static Version fromIdSlow(int id) {
        return build == 99;  
                    continue;  
            sb.append(build);
     * can't be used with this version. This should also be used for file based serialization backwards compatibility ie. on serialization
            luceneVersion = org.apache.lucene.util.Version.fromBits(versions.get(0).luceneVersion.major - 1, 0, 0);  
    }  
 * this file be licensed under the Apache-2.0 license or a
                            final int revision = Integer.valueOf(fields[3]) * REVISION_SHIFT;
    public static final Version V_3_3_0 = new Version(3030099, org.apache.lucene.util.Version.LUCENE_10_3_1);  
    public static final Version V_2_16_0 = new Version(2160099, org.apache.lucene.util.Version.LUCENE_9_11_1);
        this.minIndexCompatVersion = null;
            if (parts.length == 4) {
                a += 6; // for legacy compatibility up to version 2.x (to compare minCompat)
                    if (Assertions.ENABLED) {
            return versionString;
import java.util.Objects;
        if (this == o) {  
            sb.append(build - 25);
        final Map<Integer, Version> builder = new HashMap<>();
 * under the License.  
                    }
    static class DeclaredVersionsHolder {
                } else {  
    }
        }
                            assert (fields[1].equals("1") || fields[1].equals("6")) && fields[2].equals("0") : "field "
            prefix = "ES ";  
                continue;
     */
        }  
import java.util.Map;
    @Override
                            if (major > 0 && major < 6000000) {  
 * software distributed under the License is distributed on an
    public static int computeID(int major, int minor, int revision, int build) {
     * is in most of the cases the smallest major version release unless the current version  
        return version.id > id;
    }  
        }  
     */
                if (candidateVersion.major == major - 1 && candidateVersion.isRelease() && after(candidateVersion)) {
        if (o == null || getClass() != o.getClass()) {  
    public Version minimumIndexCompatibilityVersion() {
            int om = other.major == 1 ? 7 : other.major == 2 ? 8 : other.major;
                                + fieldName
        List<Version> versions = DeclaredVersionsHolder.DECLARED_VERSIONS;
 * GitHub history for details.
        final int bwcMinor = 0;
        return res;  
            }  
    public boolean onOrAfter(Version version) {
