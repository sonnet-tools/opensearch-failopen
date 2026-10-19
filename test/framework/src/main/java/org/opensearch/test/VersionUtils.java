        } else {
        if (maxVersion != null) {
     * Returns a random {@link Version} from all available versions.
        return Version.fromString(sb.toString());
            // minVersionIndex is inclusive so need to add 1 to this index
     */
            Version v = RELEASED_VERSIONS.get(i);
        final Optional<Version> opt = ALL_VERSIONS.stream().filter(version::before).filter(v -> v.isCompatible(version)).findAny();
        final List<List<Version>> stableVersions;
        throw new IllegalArgumentException("couldn't find any released versions before [" + version + "]");
    /**
     * e.g., for version 1.0.0 this would be legacy version (7.10.0); the first release (patch 0), of the last
    }
        assert opt.isPresent() : "no future incompatible version for " + version;
 * specific language governing permissions and limitations
        return RELEASED_VERSIONS;
import java.util.stream.Stream;
import org.opensearch.Version;
    public static Version V_1_0_0 = Version.fromId(1000099 ^ Version.MASK);
        oldVersions.addAll(splitByMinor(majorVersions.getOrDefault(previousMajorID - 1, Collections.emptyList())));
            .stream()
    private static final List<Version> ALL_VERSIONS;
        return version;
        return candidates.get(0);
            if (v.before(version)) {
     * produce sensible results.
     */
     */
     * Build version is skipped for the sake of simplicity.
    /**
    }
    /**
        assert opt.isPresent() : "no future compatible version for " + version;
        return ALL_VERSIONS;
     */
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.collect.Tuple;
    static Tuple<List<Version>, List<Version>> resolveReleasedVersions(Version current, Class<?> versionClass) {
    public static Version randomCompatibleVersion(Random random, Version version) {
 * The OpenSearch Contributors require contributions made to
public class VersionUtils {
                moveLastToUnreleased(previousMajor, unreleasedVersions);
        if (lastMinor.isEmpty()) {
    }
                // The latest minor in the previous major is a ".0" release, so there must be an unreleased bugfix for the minor before that
     * Returns the released {@link Version} before the {@link Version#CURRENT}
     * minor (for 7.x that is minor version 10) for the desired major version (7)
            // on main branch
    }
        Map<Integer, List<Version>> majorVersions = allVersions.stream().collect(Collectors.groupingBy(v -> (int) v.major));
    public static Version randomOpenSearchVersion(Random random) {
     */
        UNRELEASED_VERSIONS = versions.v2();
        }
    /**
        return lastVersion;
     * Returns an immutable, sorted list containing all opensearch versions; released and unreleased
import org.opensearch.common.Nullable;
    /**
            if (lastMinor.revision == 0) {
    public static Version getVersion(byte major, byte minor, byte revision) {
import java.util.List;
     */
        }
    }
     * Return a random {@link Version} from all available opensearch versions.
        assert compatible.size() > 0;
        return byMinor.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).collect(Collectors.toList());
            stableVersions = currentMajor;
            moveLastToUnreleased(currentMajor, unreleasedVersions);
    /**
     * Returns a random version index compatible with the current version.
        final List<Version> compatible = ALL_VERSIONS.stream()
            moveLastToUnreleased(oldVersions, unreleasedVersions);
 */
    /**
     */
                if (stableVersions.get(stableVersions.size() - 1).size() == 1) {
        List<Version> releasedVersions = Stream.of(oldVersions, previousMajor, currentMajor)
            if (prevMajorLastMinor.revision == 0 && previousMajor.isEmpty() == false) {
    }
                }
     */
            }
    static {
    }
    /**
import java.util.Optional;
        // TODO: change this to minimumCompatibilityVersion(), but first need to remove released/unreleased
        } else if (maxVersionIndex == -1) {
    }
            versions.remove(versions.size() - 1);
package org.opensearch.test;
            if (v.minor < Version.CURRENT.minor || v.major < Version.CURRENT.major) {
 * the Apache License, Version 2.0 (the "License"); you may
    // split the given versions into sub lists grouped by minor version
        int maxVersionIndex = ALL_VERSIONS.size() - 1;
    public static Version getFirstVersionOfMajor(List<Version> versions, int major) {
        Map<Integer, List<Version>> majorVersions = versions.stream().collect(Collectors.groupingBy(v -> (int) v.major));
 * compatible open source license.
    /**
        // but 7.2.0 for minimum compat
                if (stableVersions.isEmpty() == false) {
 *
    public static Version randomVersionBetween(Random random, @Nullable Version minVersion, @Nullable Version maxVersion) {
    }
import java.util.stream.Collectors;
    }
 */
     * Returns an immutable, sorted list containing all versions, both released and unreleased.
        }
            // remove the next maintenance bugfix
import java.util.Map;
        throw new IllegalArgumentException("couldn't find any released versions of the minor before [" + Version.CURRENT + "]");
     */
            Version lastMinor = moveLastToUnreleased(stableVersions, unreleasedVersions);
    public static Version maxCompatibleVersion(Version version) {
            .filter(version::isCompatible)
        return compatible.get(compatible.size() - 1);
     * are released, instead it relies on gradle to have already checked
        // TODO: remove oldVersions, we should only ever have 2 majors in Version
 *     http://www.apache.org/licenses/LICENSE-2.0
        Map<Integer, List<Version>> byMinor = versions.stream().collect(Collectors.groupingBy(v -> (int) v.minor));
 *
     **/
        // this breaks b/c 5.x is still in version list but cluster-manager doesn't care about it!
        assert version.before(Version.CURRENT);
            stableVersions = currentMajor;
            throw new IllegalArgumentException("maxVersion [" + maxVersion + "] cannot be less than minVersion [" + minVersion + "]");
        }
        previousMajor.addAll(splitByMinor(majorVersions.getOrDefault(previousMajorID, Collections.emptyList())));
        }
     **/
 * Modifications Copyright OpenSearch Contributors. See
    }
    public static Version compatibleFutureVersion(Version version) {
        return allVersions();
    public static Version getFirstVersion() {
    /**
    public static List<Version> allOpenSearchVersions() {
        for (int i = ALL_VERSIONS.size() - 1; i >= 0; i--) {
    /**
 */
    }
     * Returns a random {@link Version} from all available versions, that is compatible with the given version.
                return v;
            }
 * SPDX-License-Identifier: Apache-2.0
        }
    private static final List<Version> RELEASED_VERSIONS;
            Version v = ALL_VERSIONS.get(i);
     * guarantees in v1 and versions without the guarantees in v2
        Version lastVersion = lastMinor.remove(lastMinor.size() - 1);
    /**
            }
            // minor of the old version is being staged
    /**
            versions.set(versions.size() - 1, lastMinor);
    }
 * Licensed to Elasticsearch under one or more contributor
        // assert majorVersions.size() == 2;
        List<Version> lastMinor = new ArrayList<>(versions.get(versions.size() - 1));
    /**
            // bugix of the old version is also being staged
            .filter(version::onOrBefore)
        }
import java.util.ArrayList;
     * Get the version before {@link Version#CURRENT}.
        return compatible.get(random.nextInt(compatible.size()));
        // rebasing OpenSearch to 1.0.0 means the previous major version was Legacy 7.0.0
    public static Version randomVersion(Random random) {
        List<List<Version>> oldVersions = new ArrayList<>(0);
            .flatMap(List::stream)
    /**
            .collect(Collectors.toList());
     * Returns a random version index compatible with the given version, but not the given version.
 * Unless required by applicable law or agreed to in writing,
            // otherwise the last minor line is (by definition) staged and unreleased
    public static Version getPreviousVersion(Version version) {
            // on a stable or release branch, ie N.x
            .collect(Collectors.groupingBy(v -> (int) v.major));
    }
 * software distributed under the License is distributed on an
            maxVersionIndex = ALL_VERSIONS.indexOf(maxVersion);
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            return ALL_VERSIONS.get(minVersionIndex + random.nextInt(range));
     * Sort versions that have backwards compatibility guarantees from
 * under the License.
        return randomVersion(random);
                return v;
        } else if (current.major != 1) {
     */
            oldVersions.addAll(splitByMinor(majorVersions.getOrDefault(6, Collections.emptyList())));
                // remove the next bugfix
    }
        for (int i = RELEASED_VERSIONS.size() - 1; i >= 0; i--) {
        } else if (minVersionIndex > maxVersionIndex) {
        // remove last minor unless it's the first OpenSearch version.
    public static Version lastFirstReleasedMinorFromMajor(List<Version> allVersions, int major) {
        Collections.sort(unreleasedVersions); // we add unreleased out of order, so need to sort here
        return UNRELEASED_VERSIONS;
            throw new IllegalArgumentException("maxVersion [" + maxVersion + "] does not exist.");
        List<List<Version>> previousMajor = new ArrayList<>(0);
    }
/*
import java.util.Random;
     */
 * You may obtain a copy of the License at
        Version version = getPreviousVersion(Version.CURRENT);
    }
            assert currentMajor.isEmpty() : currentMajor;
        ALL_VERSIONS = Collections.unmodifiableList(allVersions);
            // add legacy first
    }
                    // a minor is being staged, which is also unreleased
            }
     * Returns the first released (e.g., patch version 0) {@link Version} of the last minor from the requested major version
/*
        Collections.sort(allVersions);
     */
            stableVersions = previousMajor;
     * Returns the maximum {@link Version} that is compatible with the given version.
        }
        return majorVersions.get(major).get(0);
        if (current.equals(V_1_0_0) == false) {
        int minVersionIndex = 0;
    }
    /**
        return opt.get();
        return randomVersionBetween(random, version.minimumIndexCompatibilityVersion(), getPreviousVersion(version));
/**
     * where the minor version is less than the currents minor version.
    @Deprecated
        // versions so getPreviousVerison returns the *actual* previous version. Otherwise eg 8.0.0 returns say 7.0.2 for previous,
        if (minVersionIndex == -1) {
     */
            moveLastToUnreleased(oldVersions, unreleasedVersions);
 * this file be licensed under the Apache-2.0 license or a
        Map<Integer, List<Version>> majorVersions = Version.getDeclaredVersions(versionClass)
    /**
        allVersions.addAll(UNRELEASED_VERSIONS);
        }
    }
        if (minVersion != null) {
        Map<Integer, List<Version>> groupedByMinor = majorVersions.get(major).stream().collect(Collectors.groupingBy(v -> (int) v.minor));
        allVersions.addAll(RELEASED_VERSIONS);
    public static List<Version> allVersions() {
    /**
 * not use this file except in compliance with the License.
     * those that don't. Doesn't actually check whether or not the versions
        List<List<Version>> currentMajor = splitByMinor(majorVersions.get((int) current.major));
        List<Version> candidates = Collections.max(groupedByMinor.entrySet(), Comparator.comparing(Map.Entry::getKey)).getValue();
     * @return a tuple containing versions with backwards compatibility
        // all Legacy ES versions are released, so we don't exclude any.
                    moveLastToUnreleased(stableVersions, unreleasedVersions);
     * returns the first future compatible version
        return opt.get();
            // remove current
 * Utilities for selecting versions in tests
     * returns the first future incompatible version
    /**
        Tuple<List<Version>, List<Version>> versions = resolveReleasedVersions(Version.CURRENT, Version.class);
            minVersionIndex = ALL_VERSIONS.indexOf(minVersion);
                    moveLastToUnreleased(stableVersions, unreleasedVersions);
 * ownership. Elasticsearch licenses this file to you under
        } else {
     */
                }
            // no more staged legacy bugfixes so skip;
 * this work for additional information regarding copyright
 */
        if (current.major == 2) {
    private static final List<Version> UNRELEASED_VERSIONS;
    }
        final List<Version> compatible = ALL_VERSIONS.stream().filter(version::isCompatible).collect(Collectors.toList());
    /**
            .flatMap(List::stream)
        sb.append(major).append('.').append(minor).append('.').append(revision);
            previousMajor.addAll(splitByMinor(majorVersions.getOrDefault(7, Collections.emptyList())));
     * Returns an immutable, sorted list containing all unreleased versions.
import java.util.Comparator;
        if (currentMajor.size() == 1) {
    }
     */
        int previousMajorID = current.major == 1 ? 7 : current.major - 1;
            // if the last minor line is Legacy there are no more staged releases; do nothing
        RELEASED_VERSIONS = versions.v1();
    public static Version getPreviousMinorVersion() {
        // group versions into major version
    public static Version getPreviousVersion() {
        unreleasedVersions.add(lastVersion);
    public static List<Version> allReleasedVersions() {
        List<Version> allVersions = new ArrayList<>(RELEASED_VERSIONS.size() + UNRELEASED_VERSIONS.size());
     * Returns a random {@link Version} between <code>minVersion</code> and <code>maxVersion</code> (inclusive).
     */
import java.util.Collections;
        return RELEASED_VERSIONS.get(0);
    // version 1.0 is removed; this is used purely to retain consistent logic for migrations
        return new Tuple<>(Collections.unmodifiableList(releasedVersions), Collections.unmodifiableList(unreleasedVersions));
     * rules here match up with the rules in gradle then this should
        } else {
        }
        return randomVersionBetween(random, Version.CURRENT.minimumIndexCompatibilityVersion(), Version.CURRENT);
     */
     * Get the version before {@code version}.
     * Returns a {@link Version} with a given major, minor and revision version.
     * this which it does in {@code :core:verifyVersions}. So long as the
        return ALL_VERSIONS.get(random.nextInt(ALL_VERSIONS.size()));
            throw new IllegalArgumentException("minVersion [" + minVersion + "] does not exist.");
 *
     *
        // If none of the previous major was released, then the last minor and bugfix of the old version was not released either.
            .collect(Collectors.toList());
/*
        if (previousMajor.isEmpty()) {
    public static Version randomPreviousCompatibleVersion(Random random, Version version) {
            int range = maxVersionIndex + 1 - minVersionIndex;
        StringBuilder sb = new StringBuilder();
    private static Version moveLastToUnreleased(List<List<Version>> versions, List<Version> unreleasedVersions) {
     * Returns an immutable, sorted list containing all released versions.
    public static List<Version> allUnreleasedVersions() {
                // this is not a legacy version; remove the staged bugfix
    public static Version incompatibleFutureVersion(Version version) {
 * license agreements. See the NOTICE file distributed with
    // move the last version of the last minor in versions to the unreleased versions
    public static Version randomIndexCompatibleVersion(Random random) {
            final Version prevMajorLastMinor = moveLastToUnreleased(previousMajor, unreleasedVersions);
    }
    private static List<List<Version>> splitByMinor(List<Version> versions) {
     * Returns the oldest released {@link Version}
        List<Version> unreleasedVersions = new ArrayList<>();
 * GitHub history for details.
     */
}
        final Optional<Version> opt = ALL_VERSIONS.stream().filter(version::before).filter(v -> v.isCompatible(version) == false).findAny();
