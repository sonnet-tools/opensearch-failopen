    /**  
        String[] pathArray = pathString.split(getPathSeparator());
        return Arrays.stream(pathArray).filter(path -> !path.isEmpty()).map(path -> normalizePath(path)).toArray(String[]::new);  
import java.util.stream.Collectors;
        }
    public static String[] mergePaths(String[] path1, String[] path2) {  
            .filter(File::exists)
     */
    private static String normalizePath(String path) {
    public static String[] getPathEnv() {
    public static Optional<String> findExecutable(String executableFileName) {  
    public static Optional<String> findExecutable(String executableFileName, String[] path) {
            .filter(File::canExecute)  
    }
     */
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
/**
 */  
 * this file be licensed under the Apache-2.0 license or a
     * Finds executable with given filename in paths defined in PATH environment variable.
     */  
        return Stream.concat(Arrays.stream(path1), Arrays.stream(path2))
        String trimmedPath = path.trim();
     * Normalizes the path by trimming and removing redundant "/" or "\" at the end of the path.  
     * @return An optional path to found executable.
     * @param executableFileName A filename of executable (with extension included if present).
     * @return An optional path to found executable.  
    public static Optional<String> findExecutableInKnownPaths(String executableFileName, String[] knownPath) {
        String[] mergedPath = mergePaths(knownPath, getPathEnv());  
import java.util.Arrays;
 * Set of utils for reading and parsing environment PATH variable and for finding executable files.  
     * Parses path string into an array of single paths, normalizing them and removing empty paths.  
        return findExecutable(executableFileName, mergedPath);
    private ExecutableUtils() {}
import org.apache.tools.ant.taskdefs.condition.Os;
     * @return An array of single paths.
     * @param path1 First array of normalized paths.
            .collect(Collectors.toCollection(LinkedHashSet::new))  
 *
            return cachedPathEnv;  
    }
        if (trimmedPath.length() > 1 && trimmedPath.endsWith(getFileSeparator())) {  
            .map(Path::toFile)
import java.util.LinkedHashSet;  
     */  
     * Find executable with given name in known path, with fallback to paths defined in PATH environment.  
        return Arrays.stream(path)
            // LinkedHashSet removes duplicates and keeps the order
package org.opensearch.gradle.util;
 * The OpenSearch Contributors require contributions made to  
        return trimmedPath;
            .toArray(String[]::new);
    }
    private static String getPathSeparator() {
    }  
     * @param path Path string to normalize.
            return trimmedPath.substring(0, trimmedPath.length() - 1);
     * @param pathString Path string to parse.
import java.util.Optional;
        return findExecutable(executableFileName, getPathEnv());
        return System.getProperty("path.separator", Os.isFamily(Os.FAMILY_WINDOWS) ? ";" : ":");
}
import java.util.stream.Stream;  
     * @return An optional path to found executable.
     */
import java.io.File;  
    /**
     * Find executable with given name in provided paths.
    /**
     */  
            .findFirst()
        }
    private static String[] cachedPathEnv;  
    }  
    /**
     */  
    /**
     * @param path2 Second array of normalized paths.  
     * @return Path environment variable in form of array of normalized paths.
        return System.getProperty("file.separator", Os.isFamily(Os.FAMILY_WINDOWS) ? "\\" : "/");
    }
    private static String getFileSeparator() {  
    /**
     * @return Normalized path.
        String pathEnvString = System.getenv("PATH");  
    }  
     * @param executableFileName A filename of executable (with extension included if present).  
    }
        cachedPathEnv = pathEnvString != null ? parsePathString(pathEnvString) : new String[0];
     * @return An array of merged paths.
import java.nio.file.Path;
/*  
     * @param executableFileName A filename of executable (with extension included if present).  
public class ExecutableUtils {
            .map(p -> Path.of(p, executableFileName))  
     * @param path Array of paths where to look for executable.
 */
    }
     * Merges two arrays of paths, removing duplicates and keeping the order. It expects the provided paths to be normalized.
        if (cachedPathEnv != null) {
     * @param knownPath Array of paths where to look for executable first, before looking into system PATH.
        return cachedPathEnv;  
    public static String[] parsePathString(String pathString) {
    /**
            .map(File::toString);
