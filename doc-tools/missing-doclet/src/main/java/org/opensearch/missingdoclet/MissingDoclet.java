import com.sun.source.util.DocTrees;
                fullMessage.append(element.getSimpleName());
            result = Stream.concat(result, Stream.of(superClass));
                .toString() /* ClassSymbol.toString() returns class name */
    }
    }
            // record each @param that we see
                switch (arguments.get(0)) {
            Set<String> seenParameters = new HashSet<>();
                break;
        this.docTrees = docEnv.getDocTrees();
            if (hasInheritedJavadocs(element)) {
                    if (tag instanceof ParamTree) {
import jdk.javadoc.doclet.Reporter;
            Iterable<Element> superTypes =
            public String getParameters() {
    }
 * compatible open source license.
    Elements elementUtils;
            @Override
    Set<String> methodPackages = Collections.emptySet();
     */
                    case "method":
            Element superClass = ((DeclaredType) clazz.getSuperclass()).asElement();
                return 1;
    private Stream<Element> superTypeForInheritDoc(Element type) {
 *
                        return false;
        switch(element.getKind()) {
                return true;
        // Check for methods up the types tree.
    /* Find types from which methods in type may inherit javadoc, in the proper order.*/
                return Option.Kind.STANDARD;
            @Override
import com.sun.source.doctree.ParamTree;
        // ignoring a package isn't recursive (on purpose), we still check all the classes, etc. inside it.
            default:
            if (elm.isEmpty()) {
    private boolean isSyntheticEnumMethod(Element element) {
            @Override
                        // don't recurse into enclosed types, otherwise we'll double-check since they are already in the included docTree
        switch (element.getKind()) {
    private int level(Element element) {
                            subElement.getKind() == ElementKind.CONSTRUCTOR ||
            .stream()
                for (var tag : tree.getBlockTags()) {
        }
                    checkComment(element);
import javax.lang.model.util.ElementFilter;
                break;
 * this file be licensed under the Apache-2.0 license or a
            case FIELD:
                    TypeElement clazz = (TypeElement) thisMethod.getEnclosingElement();
    // checks that classes, interfaces, enums, and annotation types have documentation
                    case "package":
                    case "parameter":
                }
    private void check(Element element) {
                return Option.Kind.STANDARD;
    // checks that methods, constructors, fields, and enumerated constants have documentation
            ExecutableElement thisMethod = (ExecutableElement) element;
                        level = METHOD;
                .equalsIgnoreCase("javax.annotation.Generated"));
// which is under the Apache Software Foundation under Apache 2.0 license
        if (enclosing != null && isGenerated(enclosing)) {
                return "comma separated list of packages to check at 'method' level";
            case METHOD:
            public List<String> getNames() {
import javax.lang.model.element.Element;
            @Override
                    }
    Reporter reporter;
            }
                    checkComment(element);
        for (var element : docEnv.getIncludedElements()) {
import javax.lang.model.type.TypeKind;
    public void init(Locale locale, Reporter reporter) {
            public boolean process(String option, List<String> arguments) {
        });
    // checks that modules and packages have documentation
     * Check an individual element.
    @Override
        if (clazz.getSuperclass().getKind() == TypeKind.DECLARED) {
        if (!docEnv.isIncluded(element)) {
            }
            @Override
import java.util.Set;
    int level = PARAMETER;
        }
                        reporter.print(Diagnostic.Kind.NOTE, element, "javadoc empty but method overrides another, skipping.");
                }
        fullMessage.append(" (");
            result = Stream.concat(result, superTypeForInheritDoc(superClass));
            case MODULE:
            case FIELD:
            @Override
    }
     * This checks packages and types from the doctrees.
        if (tree == null || tree.getFirstSentence().isEmpty()) {
}
                            check(subElement);
                checkComment(element);
        }
            .anyMatch(m -> m
import java.util.stream.Stream;
package org.opensearch.missingdoclet;
                        level = PACKAGE;
            }
 */
            return METHOD;
                for (ExecutableElement supMethod : ElementFilter.methodsIn(sup.getEnclosedElements())) {
    /**
                        level = PARAMETER;
    private static final int PARAMETER = 3;
        }
import javax.lang.model.element.ExecutableElement;
            default:
        options.addAll(super.getSupportedOptions());
            for (Element sup : superTypes) {
                    error(element, "missing javadoc @param for parameter '" + name + "'");
                if (level(element) >= METHOD && !isSyntheticEnumMethod(element)) {
        var tree = docTrees.getDocCommentTree(element);
        if (element.getKind() == ElementKind.PACKAGE) {
                        // We could check supMethod for non-empty javadoc here. Don't know if this makes
            .anyMatch(ann -> ann.getAnnotationType().toString().equals(Override.class.getName()));
        final boolean isGenerated = element
    public Set<Doclet.Option> getSupportedOptions() {
                return "comma separated list of element names to ignore (e.g. as a workaround for split packages)";
                .replace('\u00A0', ' ')
                var name = param.getSimpleName().toString();
    private void checkComment(Element element) {
    @Override
                fullMessage.append(".");
                ignored = new HashSet<>(Arrays.asList(arguments.get(0).split(",")));
import jdk.javadoc.doclet.DocletEnvironment;
            @Override
            case ENUM_CONSTANT:
        if (hasOverrides) {
        // check that this element isn't on our ignore list. This is only used as a workaround for "split packages".
            // now compare the method's formal parameter list against it
// Original version of this class is ported from MissingDoclet code in Lucene,
    @Override
        } else {
            case ENUM_CONSTANT:
            }
            public List<String> getNames() {
                return "ignoredNames";
                .getAnnotationType()
        options.add(new Doclet.Option() {
            .collect(Collectors.toList());
            // have inherited javadocs somewhere.
            return;
 * Has option --missing-method to apply "method" level to selected packages (fix one at a time).
        }
            }
        Element enclosing = element.getEnclosingElement();
            case PACKAGE:
     */
 * <p>
     */
            if (tree != null) {
        this.elementUtils = docEnv.getElementUtils();
        var fullMessage = new StringBuilder();
                return Option.Kind.STANDARD;
            .stream()
// See - https://github.com/apache/lucene-solr/tree/master/dev-tools/missing-doclet
        if (element instanceof ExecutableElement) {
            }
            }
                fullMessage.append(element.toString());
                        var name = ((ParamTree)tag).getName().getName().toString();
        }
public class MissingDoclet extends StandardDoclet {
    DocletEnvironment docEnv;
     * Returns effective check level for this element
            public boolean process(String option, List<String> arguments) {
            @Override
            // class-like elements, check them, then recursively check their children (fields and methods)
    Set<String> ignored = Collections.emptySet();
            }
        }
 *   It isn't recursive, just ignores exactly the elements you tell it.
            }
            }
    }
        fullMessage.append(element.getKind().toString().toLowerCase(Locale.ROOT));
            check(element);
                return 1;
            @Override
    /**
            return isGenerated(element.getEnclosingElement());
                }
                error(element, "blank javadoc comment");
            }
     * In addition to truly "missing", check that comments aren't solely whitespace (generated by some IDEs)
                    default:
            @Override
            case CONSTRUCTOR:
    }
            reporter.print(Diagnostic.Kind.NOTE, element, "javadoc empty but @Override declared, skipping.");
                    for (var subElement : element.getEnclosedElements()) {
            case ENUM:
    // Ignore classes annotated with @Generated and all enclosed elements in them.
            if (normalized.isEmpty()) {
                // don't check the unnamed module, it won't have javadocs
                    checkComment(element);
    /** logs a new error for the particular element */
            public boolean process(String option, List<String> arguments) {
            case MODULE:
import jdk.javadoc.doclet.Doclet;
    private static final int METHOD = 2;
     * Checks that an element doesn't have missing javadocs.
import com.sun.source.doctree.DocCommentTree;
                            subElement.getKind() == ElementKind.FIELD ||
            for (var param : ((ExecutableElement)element).getParameters()) {
        // we just need to cope with the fact package-info.java isn't there because it is split across multiple jars.
            case CONSTRUCTOR:
                        if (subElement.getKind() == ElementKind.METHOD ||
                        return true;
                error(element, "javadocs are missing");
            @Override
            public String getParameters() {
        options.add(new Doclet.Option() {
     * According to the doctree documentation, the "included" set never includes synthetic elements.
            }
            }
                return;
            }
            @Override
            }
            @Override
                return "packages";
        fullMessage.append(message);
            // If an element has explicit @Overrides annotation, assume it does
                return true;
 *   Matches package names exactly: so you'll need to list subpackages separately.
        }
                if (!seenParameters.contains(name)) {
            public List<String> getNames() {
    }
                }
                        level = CLASS;
import java.util.Arrays;
                    if (elementUtils.overrides(thisMethod, supMethod, clazz)) {
                }
            Optional<?> elm = enclosedElements.stream().findFirst().filter(e -> ((e.getKind() != ElementKind.CLASS) || !isGenerated(e)));
import javax.lang.model.type.DeclaredType;
                return Collections.singletonList("--missing-level");
        });
    DocTrees docTrees;
 * SPDX-License-Identifier: Apache-2.0
            }
                break;
            return;
                        // sense though as all methods will be verified in the end so it'd fail on the
                fullMessage.append(element.getSimpleName());
            return;
        if (level >= PARAMETER) {
            return;
import java.util.stream.Collectors;
        // If a package contains only generated classes, ignore the package as well.
                    }
        List<Element> interfaces = clazz.getInterfaces()
        return true;
            @Override
import javax.lang.model.element.ElementKind;
        }
            case CLASS:
        }
    private void error(Element element, String message) {
    private static final int CLASS = 1;
    }
        fullMessage.append("): ");
     * UweSays: It should not happen but it happens!
            public String getParameters() {
        }
            checkParameters(element, tree);
            }
                () -> superTypeForInheritDoc(thisMethod.getEnclosingElement()).iterator();
        TypeElement clazz = (TypeElement) type;
            case METHOD:
                .toLowerCase(Locale.ROOT);
            public String getDescription() {
            return level;
            @Override
        return isGenerated;
    private static final int PACKAGE = 0;
    private void checkParameters(Element element, DocCommentTree tree) {
            // Check for methods that override other stuff and perhaps inherit their Javadocs.
import javax.lang.model.util.Elements;
                        return true;
            public Kind getKind() {
            @Override
                return Collections.singletonList("--missing-ignore");
import java.util.Optional;
                .trim()
    public boolean run(DocletEnvironment docEnv) {
                return;
        boolean hasOverrides = element.getAnnotationMirrors().stream()
        if (simpleName.equals("values") || simpleName.equals("valueOf")) {
        }
        }
import java.util.List;
        result = Stream.concat(result, interfaces.stream().flatMap(this::superTypeForInheritDoc));
        this.docEnv = docEnv;
            return true;
        options.add(new Doclet.Option() {
                    }
    /**
        }
 * Has option --missing-level (package, class, method, parameter) so that we can improve over time.
            }
import java.util.Collections;
            case RECORD:
                        // top of the hierarchy (if empty) anyway.
 * The OpenSearch Contributors require contributions made to
            case INTERFACE:
            // Avoid JDK 11 bug:
            } else {
            }
            public Kind getKind() {
            case PACKAGE:
        if (methodPackages.contains(pkg)) {
                break;
            public int getArgumentCount() {
            public int getArgumentCount() {
    private boolean hasInheritedJavadocs(Element element) {
                fullMessage.append(element.getEnclosingElement().getSimpleName());
            public String getDescription() {
import javax.lang.model.element.ModuleElement;
                return Collections.singletonList("--missing-method");
    // checks that @param tags are present for any method/constructor parameters
                break;
            public Kind getKind() {
import java.util.Locale;
import jdk.javadoc.doclet.StandardDoclet;
        if (element instanceof ExecutableElement) {
            .map(tm -> ((DeclaredType) tm).asElement())
    }
            reporter.print(Diagnostic.Kind.ERROR, element, fullMessage.toString());
                        return true;
            public String getDescription() {
 * Note: This by default ignores javadoc validation on overridden methods.
    }
                }
        }
            var normalized = tree.getFirstSentence().get(0).toString()
/**
            // check if enclosing element is generated
        super.init(locale, reporter);
            }
import javax.lang.model.element.TypeElement;
                        return true;
                        seenParameters.add(name);
            reporter.print(Diagnostic.Kind.ERROR, fullMessage.toString());
    /**
        if (ignored.contains(element.toString())) {
            }
            if (element.getEnclosingElement().getKind() == ElementKind.ENUM) {
        this.reporter = reporter;
                        return true;
                return true;
        // Ignore classes annotated with @Generated and all enclosed elements in them.
                // for anything else, use a simple name
/*
    }
            }
            .filter(tm -> tm.getKind() == TypeKind.DECLARED)
        if (isGenerated(element)) {
        // sanity check that the element is really "included", because we do some recursion into types
                break;
                // for method-like elements, include the enclosing type to make it easier
        return options;
 * Has option --missing-ignore to ignore individual elements (such as split packages).
                }
        } else {
    private boolean isGenerated(Element element) {
        return result;
import javax.tools.Diagnostic;
        Set<Doclet.Option> options = new HashSet<>();
            // method-like elements, check them if we are configured to do so
        return false;
            @Override
        }
            // https://bugs.openjdk.java.net/browse/JDK-8224082
                break;
            .getAnnotationMirrors()
        String pkg = elementUtils.getPackageOf(element).getQualifiedName().toString();
            }
        String simpleName = element.getSimpleName().toString();
        Stream<Element> result = interfaces.stream();
    }
                return "level";
 * Checks for missing javadocs, where missing also means "only whitespace" or "license header".
                return 1;
                    case "class":
                methodPackages = new HashSet<>(Arrays.asList(arguments.get(0).split(",")));
 */
        }
     */
        });
                return "level to enforce for missing javadocs: [package, class, method, parameter]";
            case ANNOTATION_TYPE:
import java.util.HashSet;
                error(element, "I don't know how to analyze " + element.getKind() + " yet.");
                if (level(element) >= CLASS) {
            @Override
     * Return true if the method is synthetic enum method (values/valueOf).
        if (!isGenerated && element.getEnclosingElement() != null) {
        } else {
            }
    /** Checks there is a corresponding "param" tag for each method parameter */
            public int getArgumentCount() {
     * It will recursively check methods/fields from encountered types when the level is "method"
            List<? extends Element> enclosedElements = element.getEnclosedElements();
                        }
                            subElement.getKind() == ElementKind.ENUM_CONSTANT) {
        }
            }
                if (!((ModuleElement)element).isUnnamed()) {
        return false;
        if (Runtime.version().feature() == 11 && element.getKind() == ElementKind.PACKAGE) {
                // for modules/packages, we don't have filename + line number, fully qualify
