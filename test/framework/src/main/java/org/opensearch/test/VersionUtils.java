    public static Version lastFirstReleasedMinorFromMajor(List<Version> allVersions, int major) {
}
        return RELEASED_VERSIONS.get(0);
            if (v.minor < Version.CURRENT.minor || v.major < Version.CURRENT.major) {
    }  
    @Deprecated
                moveLastToUnreleased(previousMajor, unreleasedVersions);
    public static Version randomOpenSearchVersion(Random random) {
        } else {
        assert opt.isPresent() : "no future incompatible version for " + version;
    private static final List<Version> ALL_VERSIONS;
    }  
    /**
    /**  
    private static Version moveLastToUnreleased(List<List<Version>> versions, List<Version> unreleasedVersions) {
    public static Version compatibleFutureVersion(Version version) {
        if (lastMinor.isEmpty()) {
 */
    }
    }  
    public static Version getVersion(byte major, byte minor, byte revision) {
            // no more staged legacy bugfixes so skip;
            maxVersionIndex = ALL_VERSIONS.indexOf(maxVersion);
            final Version prevMajorLastMinor = moveLastToUnreleased(previousMajor, unreleasedVersions);
package org.opensearch.test;
        Map<Integer, List<Version>> majorVersions = allVersions.stream().collect(Collectors.groupingBy(v -> (int) v.major));
        return RELEASED_VERSIONS;  
    }  
 * ownership. Elasticsearch licenses this file to you under  
    /**  
     * @return a tuple containing versions with backwards compatibility
            throw new IllegalArgumentException("maxVersion [" + maxVersion + "] cannot be less than minVersion [" + minVersion + "]");  
        Map<Integer, List<Version>> byMinor = versions.stream().collect(Collectors.groupingBy(v -> (int) v.minor));  
            .flatMap(List::stream)  
     */
     * Returns the oldest released {@link Version}
    /**
    }
                    // a minor is being staged, which is also unreleased
        throw new IllegalArgumentException("couldn't find any released versions before [" + version + "]");
            oldVersions.addAll(splitByMinor(majorVersions.getOrDefault(6, Collections.emptyList())));  
        Map<Integer, List<Version>> groupedByMinor = majorVersions.get(major).stream().collect(Collectors.groupingBy(v -> (int) v.minor));  
    }  
     */
    }  
    }
     */
    /**
                    moveLastToUnreleased(stableVersions, unreleasedVersions);  
        List<Version> unreleasedVersions = new ArrayList<>();
            return ALL_VERSIONS.get(minVersionIndex + random.nextInt(range));
     */  
        Version lastVersion = lastMinor.remove(lastMinor.size() - 1);
     * Build version is skipped for the sake of simplicity.  
            previousMajor.addAll(splitByMinor(majorVersions.getOrDefault(7, Collections.emptyList())));
     * Returns an immutable, sorted list containing all released versions.  
        for (int i = ALL_VERSIONS.size() - 1; i >= 0; i--) {
    /**
    /**  
            if (lastMinor.revision == 0) {
 * SPDX-License-Identifier: Apache-2.0
        List<List<Version>> previousMajor = new ArrayList<>(0);  
        return byMinor.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).collect(Collectors.toList());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static Version randomIndexCompatibleVersion(Random random) {
        final Optional<Version> opt = ALL_VERSIONS.stream().filter(version::before).filter(v -> v.isCompatible(version)).findAny();  
        List<List<Version>> currentMajor = splitByMinor(majorVersions.get((int) current.major));  
    /**
     * Get the version before {@link Version#CURRENT}.
        return randomVersion(random);
        List<List<Version>> oldVersions = new ArrayList<>(0);
import org.opensearch.common.collect.Tuple;  
        RELEASED_VERSIONS = versions.v1();
import org.opensearch.Version;
        }  
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
        return candidates.get(0);
import java.util.stream.Collectors;  
        // If none of the previous major was released, then the last minor and bugfix of the old version was not released either.  
    }  
 */
    public static Version getPreviousVersion(Version version) {  
     * Returns a random version index compatible with the current version.  
        sb.append(major).append('.').append(minor).append('.').append(revision);
     * produce sensible results.
            .flatMap(List::stream)
            if (v.before(version)) {  
        List<Version> lastMinor = new ArrayList<>(versions.get(versions.size() - 1));  
        allVersions.addAll(RELEASED_VERSIONS);
 * The OpenSearch Contributors require contributions made to  
            // minor of the old version is being staged  
        }
import java.util.List;
     * rules here match up with the rules in gradle then this should
        allVersions.addAll(UNRELEASED_VERSIONS);  
        Version version = getPreviousVersion(Version.CURRENT);
            .filter(version::onOrBefore)
            int range = maxVersionIndex + 1 - minVersionIndex;  
            stableVersions = currentMajor;
    public static Version incompatibleFutureVersion(Version version) {
    }
/*  
        final List<List<Version>> stableVersions;  
    public static List<Version> allOpenSearchVersions() {
     */
    public static Version randomPreviousCompatibleVersion(Random random, Version version) {  
        return compatible.get(random.nextInt(compatible.size()));
 * compatible open source license.
        return version;
        final List<Version> compatible = ALL_VERSIONS.stream().filter(version::isCompatible).collect(Collectors.toList());  
        if (maxVersion != null) {
import java.util.ArrayList;
    /**  
     * Returns an immutable, sorted list containing all versions, both released and unreleased.
        } else {
            }  
     */
        if (minVersion != null) {  
                if (stableVersions.isEmpty() == false) {  
    public static Version randomVersion(Random random) {  
     */
        List<Version> releasedVersions = Stream.of(oldVersions, previousMajor, currentMajor)
        final List<Version> compatible = ALL_VERSIONS.stream()  
     * Get the version before {@code version}.
            versions.set(versions.size() - 1, lastMinor);
    }
 * the Apache License, Version 2.0 (the "License"); you may
    public static Version randomVersionBetween(Random random, @Nullable Version minVersion, @Nullable Version maxVersion) {
    }
    /**  
        // TODO: remove oldVersions, we should only ever have 2 majors in Version  
            // otherwise the last minor line is (by definition) staged and unreleased
        assert compatible.size() > 0;
            moveLastToUnreleased(currentMajor, unreleasedVersions);
            moveLastToUnreleased(oldVersions, unreleasedVersions);
 * Utilities for selecting versions in tests
        return opt.get();
        }
     * Returns a random {@link Version} from all available versions, that is compatible with the given version.  
    /**
     * where the minor version is less than the currents minor version.  
    // version 1.0 is removed; this is used purely to retain consistent logic for migrations
            versions.remove(versions.size() - 1);  
     */
    public static List<Version> allVersions() {
    }
            }
        // group versions into major version
 * Modifications Copyright OpenSearch Contributors. See
            .collect(Collectors.toList());  
    static Tuple<List<Version>, List<Version>> resolveReleasedVersions(Version current, Class<?> versionClass) {
     * Returns a random version index compatible with the given version, but not the given version.
     */  
     */
    /**
            moveLastToUnreleased(oldVersions, unreleasedVersions);  
        return allVersions();  
        // but 7.2.0 for minimum compat  
    public static Version getFirstVersion() {  
        return randomVersionBetween(random, version.minimumIndexCompatibilityVersion(), getPreviousVersion(version));
        // remove last minor unless it's the first OpenSearch version.
    }  
    }
    // move the last version of the last minor in versions to the unreleased versions
            // add legacy first
    /**
            stableVersions = previousMajor;  
 * software distributed under the License is distributed on an
        return ALL_VERSIONS;
        if (previousMajor.isEmpty()) {
     *  
        Map<Integer, List<Version>> majorVersions = Version.getDeclaredVersions(versionClass)  
        Map<Integer, List<Version>> majorVersions = versions.stream().collect(Collectors.groupingBy(v -> (int) v.major));
                // remove the next bugfix
            // on a stable or release branch, ie N.x
    /**
    public static Version maxCompatibleVersion(Version version) {
/*  
        final Optional<Version> opt = ALL_VERSIONS.stream().filter(version::before).filter(v -> v.isCompatible(version) == false).findAny();  
 * under the License.  
            .collect(Collectors.toList());
     */
        int maxVersionIndex = ALL_VERSIONS.size() - 1;  
                    moveLastToUnreleased(stableVersions, unreleasedVersions);
        int previousMajorID = current.major == 1 ? 7 : current.major - 1;
            // bugix of the old version is also being staged
    }
        for (int i = RELEASED_VERSIONS.size() - 1; i >= 0; i--) {  
    // split the given versions into sub lists grouped by minor version
     * Sort versions that have backwards compatibility guarantees from  
    }
                if (stableVersions.get(stableVersions.size() - 1).size() == 1) {
     */  
        int minVersionIndex = 0;
     * e.g., for version 1.0.0 this would be legacy version (7.10.0); the first release (patch 0), of the last
            // minVersionIndex is inclusive so need to add 1 to this index
    /**
     * Returns the released {@link Version} before the {@link Version#CURRENT}
        } else if (current.major != 1) {  
 * You may obtain a copy of the License at  
    public static List<Version> allReleasedVersions() {
        if (current.major == 2) {
                return v;  
    public static Version getFirstVersionOfMajor(List<Version> versions, int major) {
                return v;
        Collections.sort(unreleasedVersions); // we add unreleased out of order, so need to sort here  
     * are released, instead it relies on gradle to have already checked
        } else if (minVersionIndex > maxVersionIndex) {
    /**
    public static Version getPreviousVersion() {
     * Returns a {@link Version} with a given major, minor and revision version.
        assert version.before(Version.CURRENT);  
        }  
        oldVersions.addAll(splitByMinor(majorVersions.getOrDefault(previousMajorID - 1, Collections.emptyList())));  
     */
 *  
        // rebasing OpenSearch to 1.0.0 means the previous major version was Legacy 7.0.0
     * Returns the first released (e.g., patch version 0) {@link Version} of the last minor from the requested major version  
 * license agreements. See the NOTICE file distributed with
import java.util.Comparator;
        }
    }  
        // assert majorVersions.size() == 2;
        return compatible.get(compatible.size() - 1);
 * this file be licensed under the Apache-2.0 license or a
    private static List<List<Version>> splitByMinor(List<Version> versions) {
 * specific language governing permissions and limitations
 * GitHub history for details.
        Tuple<List<Version>, List<Version>> versions = resolveReleasedVersions(Version.CURRENT, Version.class);
            // remove the next maintenance bugfix  
            // if the last minor line is Legacy there are no more staged releases; do nothing
     */
    /**
 */  
    public static Version randomCompatibleVersion(Random random, Version version) {
        // TODO: change this to minimumCompatibilityVersion(), but first need to remove released/unreleased
 * this work for additional information regarding copyright
                // The latest minor in the previous major is a ".0" release, so there must be an unreleased bugfix for the minor before that  
            .stream()
            throw new IllegalArgumentException("minVersion [" + minVersion + "] does not exist.");
 *
    }  
    private static final List<Version> RELEASED_VERSIONS;
        throw new IllegalArgumentException("couldn't find any released versions of the minor before [" + Version.CURRENT + "]");  
            Version v = ALL_VERSIONS.get(i);
     * guarantees in v1 and versions without the guarantees in v2
public class VersionUtils {  
     * Returns an immutable, sorted list containing all unreleased versions.
 * Licensed to Elasticsearch under one or more contributor  
 */  
     * minor (for 7.x that is minor version 10) for the desired major version (7)
     * Returns a random {@link Version} from all available versions.
            if (prevMajorLastMinor.revision == 0 && previousMajor.isEmpty() == false) {
        List<Version> allVersions = new ArrayList<>(RELEASED_VERSIONS.size() + UNRELEASED_VERSIONS.size());
     * returns the first future incompatible version  
        } else if (maxVersionIndex == -1) {  
        previousMajor.addAll(splitByMinor(majorVersions.getOrDefault(previousMajorID, Collections.emptyList())));
            }
 * not use this file except in compliance with the License.
        Collections.sort(allVersions);
        StringBuilder sb = new StringBuilder();  
                }
import java.util.Map;  
        unreleasedVersions.add(lastVersion);
        }
            Version lastMinor = moveLastToUnreleased(stableVersions, unreleasedVersions);  
            .collect(Collectors.groupingBy(v -> (int) v.major));
            .filter(version::isCompatible)
        // versions so getPreviousVerison returns the *actual* previous version. Otherwise eg 8.0.0 returns say 7.0.2 for previous,
 * KIND, either express or implied.  See the License for the
        if (current.equals(V_1_0_0) == false) {  
     * those that don't. Doesn't actually check whether or not the versions
    private static final List<Version> UNRELEASED_VERSIONS;  
        // this breaks b/c 5.x is still in version list but cluster-manager doesn't care about it!  
        List<Version> candidates = Collections.max(groupedByMinor.entrySet(), Comparator.comparing(Map.Entry::getKey)).getValue();
        return lastVersion;
     * Returns a random {@link Version} between <code>minVersion</code> and <code>maxVersion</code> (inclusive).
            Version v = RELEASED_VERSIONS.get(i);
     */
        // all Legacy ES versions are released, so we don't exclude any.
    public static Version getPreviousMinorVersion() {
     * Returns an immutable, sorted list containing all opensearch versions; released and unreleased  
    }
/**  
        }
                }
        if (currentMajor.size() == 1) {
 * Unless required by applicable law or agreed to in writing,
        }
        } else {  
            minVersionIndex = ALL_VERSIONS.indexOf(minVersion);
     * returns the first future compatible version  
     */  
        return UNRELEASED_VERSIONS;
     **/  
        assert opt.isPresent() : "no future compatible version for " + version;
     * this which it does in {@code :core:verifyVersions}. So long as the  
        return ALL_VERSIONS.get(random.nextInt(ALL_VERSIONS.size()));
     **/  
        return Version.fromString(sb.toString());
            // on main branch
        return opt.get();
    /**
import java.util.Optional;
    }
import java.util.Collections;  
     * Return a random {@link Version} from all available opensearch versions.
            assert currentMajor.isEmpty() : currentMajor;
     */
     * Returns the maximum {@link Version} that is compatible with the given version.  
import java.util.stream.Stream;
import org.opensearch.common.Nullable;
     */
        if (minVersionIndex == -1) {
    /**
    public static Version V_1_0_0 = Version.fromId(1000099 ^ Version.MASK);  
import java.util.Random;
            throw new IllegalArgumentException("maxVersion [" + maxVersion + "] does not exist.");
            }
        return majorVersions.get(major).get(0);  
            stableVersions = currentMajor;
        return randomVersionBetween(random, Version.CURRENT.minimumIndexCompatibilityVersion(), Version.CURRENT);  
        }  
            // remove current
    }
    /**
    public static List<Version> allUnreleasedVersions() {  
        return new Tuple<>(Collections.unmodifiableList(releasedVersions), Collections.unmodifiableList(unreleasedVersions));
        ALL_VERSIONS = Collections.unmodifiableList(allVersions);
    }
                // this is not a legacy version; remove the staged bugfix  
    static {  
/*
        }
        UNRELEASED_VERSIONS = versions.v2();  
