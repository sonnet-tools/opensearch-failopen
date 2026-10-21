                        tokens = line.substring(parameterEndIndex + 1, annotationIndex).trim().split("\\s+");
                        allowlistClassOrigin = "[" + filepath + "]:[" + number + "]";
                        if (line.endsWith("{") == false) {
    public static Allowlist loadFromResourceFiles(Class<?> resource, String... filepaths) {
     *     comma-delimited list of Painless type names corresponding to the type/class names
                    throw new IllegalArgumentException("invalid annotation: parser not found for [" + name + "] [" + line + "]");
                List<AllowlistConstructor> allowlistConstructors = null;
                if (javaClassName != null) {
                        // Parse the method parameters.
                            }
 * software distributed under the License is distributed on an
                        // Expects the following format: '}' '\n'
        return annotations;
     *     <li> A constructor may be specified starting with an opening parenthesis, followed by a
                            List<Object> annotations;
     * {@link String}s with a single {@link Class} to be be used to load the resources where each {@link String}
                    } else if ("class".equals(parseType)) {
     */
                                canonicalTypeNameParameters = new String[0];
 *    http://www.apache.org/licenses/LICENSE-2.0
     * See {@link #loadFromResourceFiles(Class, Map, String...)} for information on how to structure an allowlist
 * GitHub history for details.
                        }
                throw new RuntimeException("error in [" + filepath + "] at line [" + number + "]", exception);
                annotations.add(parser.parse(arguments));
                                line.substring(parameterStartIndex + 1, parameterEndIndex)
                int index = annotationString.indexOf('[');
                            );
     *   <li> Complex types may be specified starting with 'class' and followed by the fully-qualified Java
     *   int value0
                            // Parse the method parameters.
    public static Allowlist loadFromResourceFiles(Class<?> resource, Map<String, AllowlistAnnotationParser> parsers, String... filepaths) {
     *
 * The OpenSearch Contributors require contributions made to
                LineNumberReader reader = new LineNumberReader(
                        // Ensure the final token of the line is '{'.
                        if (argumentKeyValue.length != 2) {
                        int annotationIndex = line.indexOf('@');
                        String argumentValue = argumentKeyValue[1];
     * <ul>
        ClassLoader loader = AccessController.doPrivileged(resource::getClassLoader);
     */
                        // Expects the following format: ID ID '(' ( ID ( ',' ID )* )? ')' ( 'from_class' | 'bound_to' ) ID annotations?
                        } else {
/*
                                    + "]"
     * Loads and creates a {@link Allowlist} from one to many text files. The file paths are passed in as an array of
                                )
                            allowlistFields = null;
                        // Reset all the constructors, methods, and fields to support a new class.
                            annotations = annotationIndex == -1
                            classAnnotations = Collections.emptyList();
                                new AllowlistMethod(
 * not use this file except in compliance with the License.
                    arguments = Collections.emptyMap();
                        if (tokens.length == 2) {
     *
     * The following can be parsed from each allowlist text file:
                        } else {
                                "illegal static import definition: end of method parameters not found [" + line + "]"
                        }
                String allowlistClassOrigin = null;
     *   # fields
                        allowlistMethods = new ArrayList<>();
     * <pre>
                        if ("".equals(canonicalTypeNameParameters[0])) {
/*
                            allowlistConstructors.add(
                    throw new IllegalArgumentException("invalid definition: expected closing bracket");
     * be appropriately parsed and handled. Painless complex types must be specified with the
                )
 * license agreements. See the NOTICE file distributed with
                            );
                    name = annotationString.substring(0, index);
                    arguments = new HashMap<>();
                            annotationIndex = line.length() - 1;
                            }
                            annotations = annotationIndex == -1
                                throw new IllegalArgumentException(
                            List<Object> annotations;
                AllowlistAnnotationParser parser = parsers.get(name);
     *   a parameter name, an equals, an opening quote, an argument value, a closing quote, (possibly repeated
                    }
 * under the License.
     *     parenthesis, and a newline. </li>
                        // Expects the following format: '(' ( ID ( ',' ID )* )? ')' annotations? '\n'
                        // Mark the origin of this parsable object.
                            annotations = parseAllowlistAnnotations(parsers, line.substring(annotationIndex));
                                    Arrays.asList(canonicalTypeNameParameters),
                if (index == -1) {
            try (
                        // Handle class definition types.
     *   an opening bracket, a newline, a closing bracket, and a final newline. </li>
                            allowlistMethods.add(
     * }
                        throw new IllegalArgumentException("invalid definition: unable to parse line [" + line + "]");
                        String[] tokens = line.substring(0, parameterStartIndex).trim().split("\\s+");
                            String javaAugmentedClassName;
                                    returnCanonicalTypeName,
                                javaAugmentedClassName = null;
                            if ("".equals(canonicalTypeNameParameters[0])) {
                            );
     *
                            } else if (tokens.length == 3) {
                                annotations = parseAllowlistAnnotations(parsers, line.substring(annotationIndex));
                            methodName = tokens[1];
                            allowlistClassOrigin = null;
                            String[] tokens = line.substring(0, parameterStartIndex).trim().split("\\s+");
                        String[] canonicalTypeNameParameters = WHITESPACE.matcher(
                        ).replaceAll("").split(",");
                            // Handle the case for a method or augmented method definition.
                            );
     *     (which will also be the Painless name for the method), an opening parenthesis, a
                    if (line.length() == 0 || line.charAt(0) == '#') {
     *   ()
                                canonicalTypeNameParameters = new String[0];
                            if ("".equals(canonicalTypeNameParameters[0])) {
                            );
                        // Mark the origin of this parsable object.
import java.util.Collections;
                }
                        if ("class".equals(parseType)) {
                            throw new IllegalArgumentException(
     *     type, followed by the fully qualified Java name of the class the augmented method is
                            allowlistStatics.add(
 */
                List<AllowlistMethod> allowlistMethods = null;
     *     short type Java name may be excluded by using the 'no_import' attribute during Painless class parsing
                throw new IllegalArgumentException("invalid annotation: expected name [" + line + "]");
                        // Handle the end of a definition and reset all previously gathered values.
                    String[] argumentsStrings = annotationString.substring(index + 1, annotationString.length() - 1).split(",");
                                    origin,
                            // Handle the case for a method with no parameters.
package org.opensearch.painless.spi;
                                new AllowlistConstructor(origin, Arrays.asList(canonicalTypeNameParameters), annotations)
import java.io.LineNumberReader;
                                    allowlistMethods,
                        }
     *   int add(Example, Example)
                        int parameterEndIndex = line.indexOf(')');
                        }
     *     the equivalent Java parameter types (these must be allowlisted as well), a closing
                    if (line.startsWith("class ")) {
                                    methodName,
    }
                            throw new IllegalArgumentException("invalid method definition: unexpected format [" + line + "]");
                            int annotationIndex = line.indexOf('@');
                        parseType = null;
                                    Arrays.asList(canonicalTypeNameParameters),
                Map<String, String> arguments;
     *   def value2
                        // Parse the static import type and class.
                            // Parse the annotations if they exist.
                                    annotations
                            String methodName;
                                new AllowlistClassBinding(
     *   <ul>
                            // Handle the case for a constructor with no parameters.
            ) {
                            targetJavaClassName = tokens[1];
     *   void example2()
                        if (line.endsWith("{") == false) {
                        } else {
                            || argumentValue.charAt(0) != '"'
                                    annotations
                            );
                        // Handle the case for a method with no parameters.
                String javaClassName = null;
    private static final Pattern WHITESPACE = Pattern.compile("\\s+");
                            String returnCanonicalTypeName = tokens[0];
     * specified constructors, methods, and fields will be merged into a single Painless type. The
                            throw new IllegalArgumentException("invalid definition: extraneous closing bracket");
     *     method), an opening parenthesis, a comma-delimited list of Painless type names
                        if (parameterEndIndex == -1) {
                            annotationIndex = line.length();
import java.util.HashMap;
     *   <li> Blank lines will be ignored by the parser. </li>
import java.io.InputStreamReader;
 * compatible open source license.
 */
                        arguments.put(argumentKey, argumentValue);
     *
                            canonicalTypeNameParameters = new String[0];
                        parseType = "class";
     * A single pass is made through each file to collect all the information about each class, constructor, method,
import java.lang.reflect.Method;
    }
                            allowlistMethods = null;
import java.util.List;
                            String[] tokens = line.substring(0, annotationIndex).split("\\s+");
 *
                        }
                            }
     *   <li> Comments may be created starting with a pound '#' symbol and end with a newline. These will
                                    origin,
                        } else {
                            annotations = Collections.emptyList();
     *   the opening bracket), after a method, or after field. </li>
                            throw new IllegalArgumentException(
        }
                            // Handle the case for a field definition.
                        argumentValue = argumentValue.substring(1, argumentValue.length() - 1);
                            List<Object> annotations;
 * KIND, either express or implied.  See the License for the
     *   # method
                            }
     * specified as part of the allowlist in the text file.
                                methodName = tokens[1];
 * ownership. Elasticsearch licenses this file to you under
        List<Object> annotations;
                                : parseAllowlistAnnotations(parsers, line.substring(annotationIndex));
                String name;
     * # complex types
 *
                        if (parseType != null) {
                            if (annotationIndex == -1) {
     *     (these must be allowlisted as well), a closing parenthesis, and a newline. </li>
                        }
                if (parser == null) {
            }
                            allowlistFields.add(new AllowlistField(origin, tokens[1], tokens[0], annotations));
        // Execute a single pass through the allowlist text files. This will gather all the
                        }
 * the Apache License, Version 2.0 (the "License"); you may
                        javaClassName = line.substring(5, annotationIndex).trim();
     * text file.
                String parseType = null;
                                "invalid static import definition: "
     *   <li> Primitive types may be specified starting with 'class' and followed by the Java type name,
                            allowlistClasses.add(
            annotations = Collections.emptyList();
                            throw new IllegalArgumentException("invalid annotation: expected key=\"value\" [" + line + "]");
                                : parseAllowlistAnnotations(parsers, line.substring(annotationIndex));
                    line = line.trim();
 * this file be licensed under the Apache-2.0 license or a
     *
    /**
     * is the path of a single text file. The {@link Class}'s {@link ClassLoader} will be used to lookup the Java
                            } else {
     *     <li> short Java type name - The text after the final dot symbol of any specified Java class. A
                            throw new IllegalArgumentException(
                    } else {
     *     <li> fully-qualified Java type name - Any allowlisted Java class will have the equivalent name as
                            throw new IllegalArgumentException("invalid definition: cannot embed class definition [" + line + "]");
        // constructors, methods, augmented methods, and fields for each allowlisted class.
     *   int value1
                    number = reader.getLineNumber();
                                    javaClassName,
     *     of the field, followed by the Java name of the field (which all be the Painless name
     *   (Example, def)
                    // Handle a new class by resetting all the variables necessary to construct a new AllowlistClass for the allowlist.
                                    targetJavaClassName,
                annotationString = annotationString.trim();
     * <ul>
                                    + staticImportType
                        String methodName;
                            if (parameterEndIndex == -1) {
        } else {
     *
                }
                        }
                            // Parse the annotations if they exist.
                                );
                                    methodName,
                } else {
                                throw new IllegalArgumentException("invalid method definition: unexpected format [" + line + "]");
     * class int -&gt; int {
                                annotationIndex = line.length();
                                );
                            throw new IllegalArgumentException("invalid static import definition: unexpected format [" + line + "]");
                        }
                            );
                        }
                        // Based on the number of tokens, look up the Java method name.
                                    Arrays.asList(canonicalTypeNameParameters),
                            String[] canonicalTypeNameParameters = WHITESPACE.matcher(line.substring(1, parameterEndIndex))
                        // Parse the Java class name and annotations if they exist.
                            allowlistClassBindings.add(
                }
                            String[] canonicalTypeNameParameters = WHITESPACE.matcher(
                            // Parse the field tokens.
     * <p>
                    } else if (line.equals("}")) {
                    }
     * class my.package.Example @no_import {
                        if (annotationIndex == -1) {
                        String[] argumentKeyValue = argumentString.split("=");
                        } else if (line.contains("(")) {
                                    returnCanonicalTypeName,
                        throw new IllegalArgumentException("invalid annotation: expected closing brace [" + line + "]");
                            // Ensure the correct number of tokens.
                        }
 */
                    new InputStreamReader(resource.getResourceAsStream(filepath), StandardCharsets.UTF_8)
                            line.substring(parameterStartIndex + 1, parameterEndIndex)
                            ).replaceAll("").split(",");
 * this work for additional information regarding copyright
     *   </ul>
                        if ("from_class".equals(staticImportType)) {
                            } else {
                            throw new IllegalArgumentException("invalid annotation: expected key=\"value\" [" + line + "]");
     *   (def, def)
                                throw new IllegalArgumentException("invalid field definition: unexpected format [" + line + "]");
     * # primitive types
     * reflection objects for each individual {@link Class}, {@link Constructor}, {@link Method}, and {@link Field}
                        } else if ("bound_to".equals(staticImportType)) {
                        String argumentKey = argumentKeyValue[0].trim();
public final class AllowlistLoader {
                                javaAugmentedClassName = tokens[1];
     *     be replaced with dot symbols. </li>
                        }
                        String origin = "[" + filepath + "]:[" + number + "]";
                                    javaAugmentedClassName,
/** Loads and creates a {@link Allowlist} from one to many text files. */
                                    origin,
        for (String filepath : filepaths) {
                                )
                List<AllowlistField> allowlistFields = null;
                // Ensure all classes end with a '}' token before the end of the file.
     *     part of (this class does not need to be allowlisted), the Java name of the method
     * </pre>
            }
        }
                        }
     * <p>
            String line;
     * Note there must be a one-to-one correspondence of Painless type names to Java type/class names.
     *   (int)
import java.nio.charset.StandardCharsets;
     * must be specified with Painless type names (def, fully-qualified, or short) as described earlier.
                                .replaceAll("")
     *   Example some.other.Class sub(Example, int, def)
 * SPDX-License-Identifier: Apache-2.0
            }
import java.util.Arrays;
                        } else {
     *     as described later. </li>
            int number = -1;
                            // Based on the number of tokens, look up the Java method name and if provided the Java augmented class.
                                .split(",");
 *
     *
                                    targetJavaClassName,
     *   # constructors
                                    returnCanonicalTypeName,
                    } else if (line.startsWith("static_import ")) {
/*
     * <p>
                            }
                            staticImportType = tokens[0];
                            }
 * specific language governing permissions and limitations
     *   class name, optionally followed by a 'no_import' attribute, an opening bracket, a newline,
                            throw new IllegalArgumentException("invalid definition: cannot embed static import definition [" + line + "]");
                                )
                                    + "unexpected static import type ["
     *   void example() @deprecated[use example 2 instead]
                                ? Collections.emptyList()
            } catch (Exception exception) {
}
                        int annotationIndex = line.indexOf('@');
                        // augmented methods, and fields, and add it to the list of allowlisted classes.
                        // Create a new AllowlistClass with all the previously gathered constructors, methods,
                        if (argumentKey.isEmpty()) {
                                    allowlistClassOrigin,
                                new AllowlistClass(
            String[] annotationStrings = line.substring(1).split("@");
                        }
     *   type the following may be parsed:
                    // Expects the following format: 'class' ID annotations? '{' '\n'
                        if (annotationIndex == -1) {
        return loadFromResourceFiles(resource, AllowlistAnnotationParser.BASE_ANNOTATION_PARSERS, filepaths);
                                methodName = tokens[2];
                            }
                        continue;
                            // Parse the tokens prior to the method parameters.
                        parseType = "static_import";
                        allowlistConstructors = new ArrayList<>();
                            if (tokens.length == 2) {
                    }
import org.opensearch.painless.spi.annotation.AllowlistAnnotationParser;
                                "invalid static import definition: failed to parse static import opening bracket [" + line + "]"
     *     for the field), and a newline. </li>
     *   be ignored by the parser. </li>
                                    "illegal static import definition: end of method parameters not found [" + line + "]"
            annotations = new ArrayList<>(annotationStrings.length);
                while ((line = reader.readLine()) != null) {
 * Modifications Copyright OpenSearch Contributors. See
                            int annotationIndex = line.indexOf('@');
                        int parameterStartIndex = line.indexOf('(');
 * Licensed to Elasticsearch under one or more contributor
     * Painless dynamic type, 'def', used as part of constructor, method, and field definitions will
                        String origin = "[" + filepath + "]:[" + number + "]";
                        if (parameterStartIndex == -1) {
     * }
                            int parameterStartIndex = line.indexOf('(');
     *   # augmented
                                )
            for (String annotationString : annotationStrings) {
                                    methodName,
            line = line.trim();
                                    allowlistFields,
                                    "illegal constructor definition: end of constructor parameters not found [" + line + "]"
                                annotations = Collections.emptyList();
     *   for multiple arguments,) and a closing brace. Multiple annotations may be added after a class (before
     *     allowlisted. </li>
                                    + line
                    if (annotationString.charAt(annotationString.length() - 1) != ']') {
     * A painless type name is one of the following:
                        // '\n'
     *     <li> An augmented method may be specified starting with a Painless type name for the return
        List<AllowlistClassBinding> allowlistClassBindings = new ArrayList<>();
                            // Parse the constructor parameters.
                            if (tokens.length != 2) {
     *     <li>A field may be specified starting with a Painless type name for the equivalent Java type
                        }
    }
                }
                            int parameterEndIndex = line.indexOf(')');
                            // Expects the following format: ID ID? ID '(' ( ID ( ',' ID )* )? ')' annotations? '\n'
                        if (line.startsWith("(")) {
     *     parenthesis, and a newline. </li>
    private AllowlistLoader() {}
            }
     * The following example is used to create a single allowlist text file:
                    // Skip any lines that are either blank or comments.
     *     a Painless type name with the exception that any dollar symbols used as part of inner classes will
                            classAnnotations = null;
                            int parameterEndIndex = line.indexOf(')');
                        String returnCanonicalTypeName = tokens[0];
                                    allowlistConstructors,
                        // Add a static import method or binding depending on the static import type.
                            // Parse the annotations if they exist.
     *   <li> Annotations may be added starting with an at, followed by a name, optionally an opening brace,
     * If the same Painless type is defined across multiple files and the Java class is the same, all
     *   constructor/method/field specifications, a closing bracket, and a final newline. Within a complex
        List<AllowlistClass> allowlistClasses = new ArrayList<>();
                            );
                            javaClassName = null;
    private static List<Object> parseAllowlistAnnotations(Map<String, AllowlistAnnotationParser> parsers, String line) {
import java.lang.reflect.Field;
                                ? Collections.emptyList()
     *     <li> def - The Painless dynamic type which is automatically included without a need to be
     * </ul>
     * fully-qualified Java class name. Method argument types, method return types, and field types
                            );
     * and field. Most validation will be done at a later point after all allowlists have been gathered and their
     * </ul>
                    name = annotationString;
                            // Expects the following format: ID ID annotations? '\n'
     *
                        // Handle the case for a constructor definition.
     *     followed by the Java name of the method (which will also be the Painless name for the
     *     <li> A method may be specified starting with a Painless type name for the return type,
                    }
import java.util.Map;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
                                "invalid class definition: failed to parse class opening bracket [" + line + "]"
     * Loads and creates a {@link Allowlist} from one to many text files using only the base annotation parsers.
                            allowlistConstructors = null;
                        allowlistFields = new ArrayList<>();
                        if (tokens.length == 2) {
                throw new IllegalArgumentException("invalid annotation: expected at symbol [" + line + "]");
                        String staticImportType;
                            );
                                    classAnnotations
     *     comma-delimited list of Painless type names corresponding to the type/class names for
                        List<Object> annotations;
                        // Ensure the final token of the line is '{'.
                List<Object> classAnnotations = null;
                        if (parseType != null) {
import java.util.regex.Pattern;
                        if (parseType == null) {
                        if (argumentValue.length() < 3
                    } else if ("static_import".equals(parseType)) {
     *
                        }
                    for (String argumentString : argumentsStrings) {
                        // Reset the parseType.
                                "illegal static import definition: start of method parameters not found [" + line + "]"
                            || argumentValue.charAt(argumentValue.length() - 1) != '"') {
                                    annotations
                        // Handle static import definition types.
                            if (parameterEndIndex == -1) {
                        }
 * You may obtain a copy of the License at
                            classAnnotations = parseAllowlistAnnotations(parsers, line.substring(annotationIndex, line.length() - 1));
                        } else {
import java.util.ArrayList;
                                throw new IllegalArgumentException(
     *   Example add(int, def)
                            throw new IllegalArgumentException(
                        String targetJavaClassName;
                            throw new IllegalArgumentException(
                        // Based on the number of tokens, look up the type and class.
                        // Parse the annotations if they exist.
                            throw new IllegalArgumentException("invalid annotation: expected key=\"value\" [" + line + "]");
                                    + "] ["
                        }
     *     for the equivalent Java parameter types (these must be allowlisted as well), a closing
                                new AllowlistMethod(
     *     corresponding to the type/class names for the equivalent Java parameter types
        List<AllowlistMethod> allowlistStatics = new ArrayList<>();
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.secure_sm.AccessController;
        return new Allowlist(loader, allowlistClasses, allowlistStatics, allowlistClassBindings, Collections.emptyList());
import java.lang.reflect.Constructor;
        if (line.isBlank()) {
                            int annotationIndex = line.indexOf('@');
            if (line.charAt(0) != '@') {
            if (line.length() < 2) {
     * merging takes place.
                        // Parse the tokens prior to the method parameters.
