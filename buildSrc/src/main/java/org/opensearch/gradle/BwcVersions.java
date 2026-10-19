    }  
        // the logic from there  
            throw new IllegalArgumentException("Could not parse any versions");
                    return version.getMajor() + ".x";  
            if (groupByMinor.getOrDefault(greatestMinor - 1, emptyList()).size() == 1) {
                if (greatestMinor >= 2) {
 *
                    )
        List<Version> currentMajorVersions = groupByMajor.get(currentMajor);  
 * <li>the unreleased <b>minor</b>,  M.N.0 on the `M.x` (x is literal) branch</li>
        if (majors.size() != numSupportedMajors && currentVersion.getMinor() != 0 && currentVersion.getRevision() != 0) {  
        "\\W+public static final (LegacyES)?Version V_(\\d+)_(\\d+)_(\\d+)(_alpha\\d+|_beta\\d+|_rc\\d+)? .*"
                return version.getMajor() + "." + version.getMinor();
 *     <dd>last released major</dd>  
            case ":distribution:bwc:bugfix":  
            .stream()
        }
                    + "Parsed latest version is "  
    public void compareToAuthoritative(List<Version> authoritativeReleasedVersions) {
            unreleased.add(latestOfPreviousMajor);
        int lastMajor = currentMajor - 1;  
    /**
        wireCompat.addAll(groupByMajor.get(currentMajor));
        return currentMajor - 1;
package org.opensearch.gradle;
            .stream()
        collect.forEach(consumer);  
    }
                // we found that the previous minor is staged but not yet released  
            );
            throw new IllegalStateException("Expected exactly 2 majors in parsed versions but found: " + majors);
        if (notReallyReleased.isEmpty() == false) {
                        Integer.parseInt(match.group(4))  
        final Map<Integer, List<Version>> groupByMinor = getReleasedMajorGroupedByMinor();
import java.util.ArrayList;  
public class BwcVersions {
                if (previousMinor != null) {
        List<UnreleasedVersionInfo> collect = getUnreleased().stream()
 *     <dt>M, M &gt; 0</dt>
    }  
 * We are then able to map the unreleased version to branches in git and Gradle projects that are capable of checking
    private void assertCurrentVersionMatchesParsed(Version currentVersionProperty) {
}
        List<Version> unreleased = getUnreleased();
                }
        }
        assertCurrentVersionMatchesParsed(currentVersionProperty);
        }  
            .max(Version::compareTo)  
 * This convention is enforced by checking the versions we consider to be unreleased against an
        int currentMajor = currentVersion.getMajor();
                    return ":distribution:bwc:staged";  
    );
        if (currentVersionProperty.equals(currentVersion) == false) {  
                // unless there is more recent (higher) minor.  
        if (allVersions.isEmpty()) {
import java.util.TreeSet;  
                    return ":distribution:bwc:minor";
    private Map<Integer, List<Version>> getReleasedMajorGroupedByMinor() {
                "out-of-date released versions"  
                final Version latestInMajor = getLatestVersionByKey(groupByMajor, version.getMajor());
    }
        this.unreleased = Collections.unmodifiableMap(unreleased);  
import java.util.HashMap;  
            } else {
/**
        switch (getGradleProjectPathFor(version)) {
        return unmodifiableList(unreleasedIndexCompatible);
            case ":distribution:bwc:maintenance":
    private final Map<Version, UnreleasedVersionInfo> unreleased;  
        groupByMajor = allVersions.stream()
    }
 */
 * E.x when M.N.c is released M.N.c+1 is added to the Version class mentioned above in all the following branches:  
 * ownership. Elasticsearch licenses this file to you under  
 *
        return unreleased.get(version);  
                )
        authoritativeReleasedVersions.forEach(notReallyReleased::remove);  
            wireCompat.add(lastMajorList.get(i));
        int currentMajor = currentVersion.getMajor();
                return ":distribution:bwc:bugfix";
        unreleasedIndexCompatible.retainAll(getUnreleased());  
        // We have Gradle projects set up to check out and build unreleased versions based on the our branching
        return groupByMinor;
            this.version = version;
    }
    public List<Version> getWireCompatible() {  
        }
                    + "\nThe next versions probably needs to be added to Version.java (CURRENT doesn't count)."
                return ":distribution:bwc:maintenance";  
    }  
 * Parse the Java source file containing the versions declarations and use the known rules to figure out which are all
        // based on the rules described in this classes javadoc, figure out the branch on which an unreleased version  
        assertNoOlderThanTwoMajors();  
 * The OpenSearch Contributors require contributions made to  
        }
        for (Version unreleasedVersion : getUnreleased()) {  
 *     <dd>last released minor</dd>
        int greatestMinor = groupByMinor.keySet().stream().max(Integer::compareTo).orElse(0);  
            final Version latestOfPreviousMajor = getLatestVersionByKey(this.groupByMajor, currentVersion.getMajor() - 1);  
import java.util.Collections;
    private String getBranchFor(Version version) {
            versionLines.stream()
        this(versionLines, Version.fromString(VersionProperties.getOpenSearch()));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    + incorrectlyConsideredUnreleased
            }
                        Integer.parseInt(match.group(2)),
                } else {
 * <li>the unreleased <b>staged</b>, M.N-2.0 (N &gt; 2) on the `M.(N-2)` branch</li>
 * version number to server in all branches when a version is released.
            }
 * </ul>  
            throw new IllegalStateException("Expected to find a list of versions for version: " + lastMajor);  
        final Map<Integer, List<Version>> groupByMinor;  
        if (incorrectlyConsideredUnreleased.isEmpty() == false) {
 * In addition to these, there will be a fifth one when a minor reaches feature freeze, we call this the <i>staged</i>
                    + " but the build has "
            // We only care about the last 2 majors when it comes to BWC.  
            .filter(each -> unreleased.contains(each) == false)  
 * KIND, either express or implied.  See the License for the
            default:
import java.util.function.Consumer;
                .collect(Collectors.toCollection(TreeSet::new)),  
            case ":distribution":
                "Parsed versions latest version does not match the one configured in build properties. "
        // conventions described in this classes javadoc
 * You may obtain a copy of the License at  
            unreleased.put(
        if (currentVersion.getMajor() != 1) {
 * Note that in this context, currentVersion is the unreleased version this build operates on.
 * <p>
    }  
            .filter(version -> version.equals(currentVersion) == false)
        public final String branch;
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * authoritative source (maven central).  
        return unreleased.stream().sorted().distinct().collect(Collectors.toUnmodifiableList());
                        Integer.parseInt(match.group(3)),
        for (int i = lastMajorList.size() - 1; i > 0 && lastMajorList.get(i).getMinor() == minor; --i) {  
 * <dl>
        );
 * </dl>  
 * <p>
 * this file be licensed under the Apache-2.0 license or a
        this(
                }
            .filter(version -> version.equals(currentVersion) == false)
        public final String gradleProjectPath;
 *
        Set<Version> notReallyReleased = new HashSet<>(getReleased());
import java.util.Map;  
import java.util.Set;
 * At any point in time there will surely be four such unreleased versions being worked on,  
        }
 * <p>  
    private final Map<Integer, List<Version>> groupByMajor;
 *  `M.N`, `M.x` and `master` so we can reliably assume that the leafs of the version tree are unreleased.
        if (currentMajorVersions.size() == 1) {
        public final Version version;  
 * Each branch has a current version, and expected compatible versions are parsed from the server code's Version` class.  
                    + "but they are released according to an authoritative source: "  
 * not use this file except in compliance with the License.
import java.util.HashSet;
    }
            if (unreleasedStagedOrMinor.size() > 2) {
        Set<Version> incorrectlyConsideredUnreleased = new HashSet<>(authoritativeReleasedVersions);  
                // in this case, the minor before that has a bugfix, should there be such a minor
    }  
        } else {
            .collect(Collectors.groupingBy(Version::getMajor, Collectors.toList()));
        return groupByMajor.get(major).stream().filter(v -> v.getMinor() == minor).max(Version::compareTo).orElse(null);  
        Set<Integer> majors = groupByMajor.keySet();
    private final Version currentVersion;
 * A container for opensearch supported version information used in BWC testing.
        int prevMajor = getPreviousMajor(currentMajor);  
/*
 * thus currentVersion will be one of these.
        // The current version is being worked, is always unreleased
                new UnreleasedVersionInfo(unreleasedVersion, getBranchFor(unreleasedVersion), getGradleProjectPathFor(unreleasedVersion))  
 *  
    public List<Version> getUnreleasedIndexCompatible() {
        unreleased.add(getLatestVersionByKey(groupByMinor, greatestMinor));  
                // The .x branch will always point to the latest minor (for that major), so a "minor" project will be on the .x branch
    }
            );
 * the Apache License, Version 2.0 (the "License"); you may
        List<Version> unreleasedWireCompatible = new ArrayList<>(getWireCompatible());
            case ":distribution:bwc:staged":
                }  
        unreleased.add(currentVersion);
                    + "\nBuild considers versions unreleased, "
                unreleasedVersion,
    public List<Version> getIndexCompatible() {
import java.util.regex.Matcher;
 * under the License.  
import static java.util.Collections.emptyList;
import java.util.stream.Collectors;
    }
 * Considering:  
                .map(
import java.util.SortedSet;
import java.util.List;
        int currentMajor = currentVersion.getMajor();
            this.branch = branch;  
        }
 * compatible open source license.
            }
 * SPDX-License-Identifier: Apache-2.0
    public UnreleasedVersionInfo unreleasedInfo(Version version) {
 * version.
import java.util.regex.Pattern;  
        currentVersion = allVersions.last();  
    }
    public BwcVersions(SortedSet<Version> allVersions, Version currentVersionProperty) {  
        }
/*
        List<Version> previousMajorVersions = groupByMajor.get(getPreviousMajor(currentMajor));
    public List<Version> getUnreleasedWireCompatible() {
        }  
    protected BwcVersions(List<String> versionLines, Version currentVersionProperty) {  
                } else {
    public BwcVersions(List<String> versionLines) {
            if (releasedMajorGroupedByMinor.getOrDefault(version.getMinor(), emptyList()).contains(version)) {  
 * for backwards compatibility. We never look forward, and don't add forward facing version number to branches of previous  
        return Stream.concat(groupByMajor.get(prevMajor).stream(), groupByMajor.get(currentMajor).stream())
    }
    public List<Version> getUnreleased() {
        }  
                .map(LINE_PATTERN::matcher)  
                    return version.getMajor() + "." + version.getMinor();
    private int getPreviousMajor(int currentMajor) {
 */  
 * <li>the unreleased <b>maintenance</b>, M-1.d.e ( d &gt; 0, e &gt; 0) on the `(M-1).d` branch</li>  
            .flatMap(Collection::stream)
        }
    }
        } else {
      * Returns info about the unreleased version, or {@code null} if the version is released.  
 * license agreements. See the NOTICE file distributed with
        return unmodifiableList(unreleasedWireCompatible);
import java.util.stream.Stream;
            throw new IllegalStateException(
 * version:  
            throw new IllegalStateException(  
            groupByMinor = previousMajorVersions.stream().collect(Collectors.groupingBy(Version::getMinor, Collectors.toList()));  
                    unreleased.add(previousMinor);  
 * On top of this, figure out which of these are unreleased and provide the branch they can be built from.  
 * software distributed under the License is distributed on an
        Map<Integer, List<Version>> releasedMajorGroupedByMinor = getReleasedMajorGroupedByMinor();
 * this work for additional information regarding copyright
            .collect(Collectors.toList());
        int minor = lastMajorList.get(lastMajorList.size() - 1).getMinor();
        List<Version> lastMajorList = groupByMajor.get(lastMajor);
 * Licensed to Elasticsearch under one or more contributor  
        wireCompat.sort(Version::compareTo);  
                if (unreleasedStagedOrMinor.get(unreleasedStagedOrMinor.size() - 2).equals(version)) {  
            );  
            .collect(Collectors.toList());
        }
                "out-of-date released versions"
            if (latestOfPreviousMajor.getRevision() == 0) {
    }
 * <p>
        }
                    + currentVersion
        return groupByMajor.values()  
        int numSupportedMajors = 2;
        // the tip of the previous major is unreleased for sure, be it a minor or a bugfix
            );  
        }  
        incorrectlyConsideredUnreleased.retainAll(getUnreleased());
            return ":distribution";
                    + notReallyReleased
            } else {
      */
import static java.util.Collections.unmodifiableList;
            currentVersionProperty
            // Current is an unreleased major: x.0.0 so we have to look for other unreleased versions in the previous major
 *     <dt>N, N &gt; 0</dt>
        List<Version> unreleased = new ArrayList<>();
    private String getGradleProjectPathFor(Version version) {  
 * Unless required by applicable law or agreed to in writing,
                .filter(Matcher::matches)
    private List<Version> getReleased() {
 * out and building them, so we can include these in the testing plan as well.
        if (lastMajorList == null) {
 * <ul>
    public static class UnreleasedVersionInfo {
        unreleasedWireCompatible.retainAll(getUnreleased());  
                }
    private Version getLatestInMinor(int major, int minor) {
                final Version previousMinor = getLatestInMinor(latestOfPreviousMajor.getMajor(), latestOfPreviousMajor.getMinor() - 1);
        List<Version> unreleasedIndexCompatible = new ArrayList<>(getIndexCompatible());
        return unmodifiableList(wireCompat);
        List<Version> wireCompat = new ArrayList<>();
                return ":distribution:bwc:minor";  
import java.util.Collection;
        if (groupByMinor.get(greatestMinor).size() == 1) {
                    + "\nFollowing versions are not really released, but the build thinks they are: "
 * <li>the unreleased <b>bugfix</b>, M.N.c (c &gt; 0) on the `M.N` branch</li>
            this.gradleProjectPath = gradleProjectPath;
            throw new IllegalStateException(
        return groupByMajor.getOrDefault(key, emptyList())
 * <li>the unreleased <b>major</b>, M+1.0.0 on the `master` branch</li>  
        if (version.getRevision() == 0) {  
                    unreleased.add(getLatestVersionByKey(groupByMinor, greatestMinor - 2));  
            .map(version -> new UnreleasedVersionInfo(version, getBranchFor(version), getGradleProjectPathFor(version)))  
    public void forPreviousUnreleased(Consumer<UnreleasedVersionInfo> consumer) {  
/*  
                return "master";  
            List<Version> unreleasedStagedOrMinor = getUnreleased().stream().filter(v -> v.getRevision() == 0).collect(Collectors.toList());
        // lives.
        // hack: this is horribly volatile like this entire logic; fix
                throw new IllegalStateException("Unexpected Gradle project name");  
        // We do this based on the Gradle project path because there's a direct correlation, so we dont have to duplicate
    private Version getLatestVersionByKey(Map<Integer, List<Version>> groupByMajor, int key) {  
    }
 */  
 * the version the current one is wire and index compatible with.
    }  
 * Modifications Copyright OpenSearch Contributors. See  
    }
            // we found an unreleased minor  
 * We can reliably figure out which the unreleased versions are due to the convention of always adding the next unreleased
                    match -> new Version(  
    // for testkit tests, until BwcVersions is extracted into an extension
    }  
        UnreleasedVersionInfo(Version version, String branch, String gradleProjectPath) {
        Map<Version, UnreleasedVersionInfo> unreleased = new HashMap<>();
            .orElseThrow(() -> new IllegalStateException("Unexpected number of versions in collection"));
        wireCompat.remove(currentVersion);
 * GitHub history for details.
    private static final Pattern LINE_PATTERN = Pattern.compile(  
                    + currentVersionProperty  
            .filter(version -> version.getMajor() > currentVersion.getMajor() - 2)
            unreleased.add(getLatestVersionByKey(groupByMinor, greatestMinor - 1));
            .collect(Collectors.toUnmodifiableList());  
 * <ul>
        }
        if (version.equals(currentVersion)) {  
                // if the previous major is a x.y.0 release, then the tip of the minor before that (y-1) is also unreleased  
 * specific language governing permissions and limitations
 * </ul>
            groupByMinor = currentMajorVersions.stream().collect(Collectors.groupingBy(Version::getMinor, Collectors.toList()));
 * Each build is only concerned with versions before it, as those are the ones that need to be tested
            }
    private void assertNoOlderThanTwoMajors() {  
                if (latestInMajor.getMinor() == version.getMinor()) {
            case ":distribution:bwc:minor":
    }
 */
        // the last bugfix for this minor series is always unreleased
