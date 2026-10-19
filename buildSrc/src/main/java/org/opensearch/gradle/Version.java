    private static int parseSuffixNumber(String substring) {
        Version version = (Version) o;
    }
 * You may obtain a copy of the License at  
    }  
/*
        if (matcher.matches() == false) {  
         */
 * The OpenSearch Contributors require contributions made to  
    }
        int id = major * 10000000 + minor * 100000 + revision * 1000;
    public static Version fromString(final String s) {
        this.revision = revision;
 * under the License.  
    public static final int MASK = 0x08000000;
        this.minor = minor;
        return Objects.hash(major, minor, revision, id);
    public static Version fromString(final String s, final Mode mode) {  
        return major == version.major && minor == version.minor && revision == version.revision;
 * ownership. Elasticsearch licenses this file to you under  
 */
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
    }
 * KIND, either express or implied.  See the License for the
    }
 * this work for additional information regarding copyright
        return id > compareTo.getId();
/*  
import java.util.Objects;  
    }  
    }
    }
    /**  
        return Integer.parseInt(substring);
        return id <= compareTo.getId();  
        if (o == null || getClass() != o.getClass()) {
 * Modifications Copyright OpenSearch Contributors. See  
import java.util.regex.Matcher;
 */
 * the Apache License, Version 2.0 (the "License"); you may
        // currently snapshot is not taken into account
    private final int revision;
        }  
    }  
 *  
    }  
package org.opensearch.gradle;
            return true;
/**
 *
        return major;
    @Override
public final class Version implements Comparable<Version> {
    public boolean onOrBefore(String compareTo) {  
    private static final Pattern pattern = Pattern.compile("(\\d+)\\.(\\d+)\\.(\\d+)(-alpha\\d+|-beta\\d+|-rc\\d+)?(-SNAPSHOT)?");
    }
    protected int getId() {
        return Integer.compare(getId(), other.getId());
        }
         * Strict parsing only allows known suffixes after the patch number: "-alpha", "-beta" or "-rc". The
    }
    }
        return fromString(s, Mode.STRICT);  
 * not use this file except in compliance with the License.
    public boolean after(Version compareTo) {  
 * Licensed to Elasticsearch under one or more contributor  
        RELAXED
         * suffix "-SNAPSHOT" is also allowed, either after the patch number, or after the other suffices.  
    }  
    public int getMajor() {
    // used to identify rebase to OpenSearch 1.0.0  
import java.util.regex.Pattern;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public enum Mode {  
 *
    }  
        /**
        return new Version(Integer.parseInt(matcher.group(1)), parseSuffixNumber(matcher.group(2)), parseSuffixNumber(matcher.group(3)));
                : "major.minor.revision[-extra]";  
    public boolean onOrBefore(Version compareTo) {
 */  
 * specific language governing permissions and limitations
    }
                ? "major.minor.revision[-(alpha|beta|rc)Number][-SNAPSHOT]"
        return onOrAfter(fromString(compareTo));  
    @Override
        Objects.requireNonNull(s);
    public boolean equals(Object o) {  
        return onOrBefore(fromString(compareTo));
     */
    private final int id;
    private final int minor;  
            return false;
    public boolean before(Version compareTo) {  
    public int getRevision() {  
    public int getMinor() {
        if (substring.isEmpty()) {
    }
        Objects.requireNonNull(major, "major version can't be null");  
    }
         * Relaxed parsing allows any alphanumeric suffix after the patch number.
    public boolean onOrAfter(Version compareTo) {
        this.major = major;  
        return id >= compareTo.getId();
        }
        STRICT,
        Matcher matcher = mode == Mode.STRICT ? pattern.matcher(s) : relaxedPattern.matcher(s);
        return id < compareTo.getId();
 * GitHub history for details.
     * Specifies how a version string should be parsed.
 * this file be licensed under the Apache-2.0 license or a
        this.id = major == 1 || major == 2 || major == 3 ? id ^ MASK : id;
    public boolean before(String compareTo) {
        /**
    public int compareTo(Version other) {  
}
        return before(fromString(compareTo));
    public String toString() {
    }  
        return String.valueOf(getMajor()) + "." + String.valueOf(getMinor()) + "." + String.valueOf(getRevision());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static final Pattern relaxedPattern = Pattern.compile("(\\d+)\\.(\\d+)\\.(\\d+)(-[a-zA-Z0-9_]+|\\+[a-zA-Z0-9_]+)*?");  
    private final int major;
    public Version(int major, int minor, int revision) {
        Objects.requireNonNull(minor, "minor version can't be null");
    public boolean onOrAfter(String compareTo) {
            throw new IllegalArgumentException("Invalid suffix, must contain a number e.x. alpha2");  
    @Override
 * compatible open source license.
    }
        return minor;  
        }  
            String expected = mode == Mode.STRICT
    @Override
        // identify if new OpenSearch version 1  
/*
 * software distributed under the License is distributed on an
    }
         */  
        return id;
        return revision;
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalArgumentException("Invalid version format: '" + s + "'. Should be " + expected);
        if (this == o) {
 */  
    public int hashCode() {  
        Objects.requireNonNull(revision, "revision version can't be null");
    public boolean after(String compareTo) {
        return after(fromString(compareTo));
 * Encapsulates comparison and printing logic for an x.y.z version.
