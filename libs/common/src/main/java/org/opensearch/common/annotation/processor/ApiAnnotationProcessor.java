                checkPublic(executable.getEnclosingElement(), element);
            if (parameterType instanceof ReferenceType refType) {
            if (!checkPackage(element)) {
            return false;
                        + " is not residing in "
        if (element.getAnnotation(PublicApi.class) == null
                        + element
import javax.lang.model.element.Modifier;
        // The element was reported already
     */
    }
     * @param enclosing enclosing element
     * @param element class or interface
        }
                }
        if (validated.contains(element)) {
 * <p>
                        + element
        // Check this element's annotations
        }
     * Check if element is not annotated with {@link InternalApi}
            return;
import javax.lang.model.element.TypeParameterElement;
                process(executable, refType);
            if (!validateVersion(deprecatedApi.since())) {
/*
                if (boundType instanceof ReferenceType refType) {
                    process(executable, refType);
            }
            if (typeVariable.getLowerBound() instanceof ReferenceType refType) {
            return false;
        // Check this element's annotations
            reportFailureAs = Kind.NOTE;
        // Process method thrown types
        if (type.getExtendsBound() instanceof ReferenceType refType) {
            // Skip all not-public elements
     */
     */
        }
     * @param element element to inspect
        final PackageElement pckg = processingEnv.getElementUtils().getPackageOf(element);
            processingEnv.getMessager()
    private final Set<Element> validated = new HashSet<>();
        }
 *
        }
                    .printMessage(
                    "The element "
        if (deprecatedApi != null) {
            if (!enclosed.getModifiers().contains(Modifier.PUBLIC)) {
            }
                );
    }
            if (!validateVersion(publicApi.since())) {
        }
                            + " has @DeprecatedApi annotation with unparseable OpenSearch version: "
    }
     * @param element element to inspect
        return executable.getKind() != ElementKind.CONSTRUCTOR && executable.getModifiers().contains(Modifier.PUBLIC);
                        + "and should not be annotated as OpenSearch APIs."
        // The element was reported already
        }
                } else if (type instanceof WildcardType wildcardType) {
            if (enclosed instanceof ExecutableElement executableElement) {
                        "The type "
 * The checks are built on top of the following rules:
     */
     */
import org.opensearch.common.annotation.InternalApi;
        }
                        + ((referencedBy != null) ? " (referenced by " + referencedBy + ") " : "")
                        "The type " + element + " has @PublicApi annotation with unparseable OpenSearch version: " + publicApi.since()
 * <ul>
            }
            // Skip all not-public elements
        }
     * @param executable element
 * The OpenSearch Contributors require contributions made to
            }
            }
        int minor = Integer.parseInt(parts[1]);
                    "The element "
        return pckg.getQualifiedName().toString().startsWith(OPENSEARCH_PACKAGE);
        for (final Element enclosed : element.getEnclosedElements()) {
        }
import javax.lang.model.element.ElementKind;
     * Check if a particular element belongs to OpenSeach managed packages
                process(executable, refType);
                process(executable, refType);
            validate(element);
     * declared in this class or interface.
                        + " is part of the public APIs but does not have public or protected visibility"
import javax.lang.model.element.Element;
     * @param executable executable element
     * Check if a particular element should be inspected or not
     * Check if element is public and annotated with {@link PublicApi}, {@link DeprecatedApi} or {@link ExperimentalApi}
        for (var element : elements) {
            && element.getAnnotation(DeprecatedApi.class) == null) {
            final Element element = declaredType.asElement();
     * @param referencedBy the referrer for the element
            }
        if (parts.length < 3 || parts.length > 4) {
import javax.annotation.processing.AbstractProcessor;
            return false;
            }
        }
     */
     */
     * @param executable executable element to inspect
 * {@link InternalApi} and {@link PublicApi}.
            return;
    /**
            }
 * this file be licensed under the Apache-2.0 license or a
     * Check if a particular executable element should be inspected or not
                checkNotInternal(executable.getEnclosingElement(), element);
                }
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.type.ArrayType;
    private void process(ExecutableElement executable, Element enclosing) {
import javax.tools.Diagnostic.Kind;
    private final Set<Element> reported = new HashSet<>();
        return SourceVersion.latest();
import org.opensearch.common.Nullable;
     * @param element element to check
            Set.of(PublicApi.class, ExperimentalApi.class, DeprecatedApi.class)
        if (!belongsToOpenSearch) {
    public SourceVersion getSupportedSourceVersion() {
        for (final AnnotationMirror annotation : executable.getAnnotationMirrors()) {
    }
 * </ul>
        int major = Integer.parseInt(parts[0]);
            final TypeMirror parameterType = parameter.asType();
        if (!element.getModifiers().contains(Modifier.PUBLIC) && !element.getModifiers().contains(Modifier.PROTECTED)) {
            if (thrownType instanceof ReferenceType refType) {
                    process(executable, refType);
    private final Set<AnnotatedConstruct> processed = new HashSet<>();
            return;
    private boolean checkPackage(Element element) {
        if (processingEnv.getOptions().containsKey(OPTION_CONTINUE_ON_FAILING_CHECKS) == true) {
        if (!inspectable(executable)) {
 *  <li>recursively follow the type introspection chains to enforce the rules down the line</li>
            final TypeMirror componentType = arrayType.getComponentType();
                    );
                .printMessage(
        for (final TypeParameterElement typeParameter : executable.getTypeParameters()) {
            process(executable, refType);
        if (processed.add(ref) == false) {
            }
import javax.lang.model.type.WildcardType;
     * @param element element to check
            }
import javax.lang.model.type.TypeMirror;
        // The constructors for public APIs could use non-public APIs when those are supposed to be only
    }
import javax.lang.model.type.ReferenceType;
            process(executable, refType);
    }
            for (final TypeMirror boundType : typeParameter.getBounds()) {
     * @param referencedBy the referrer for the element
        for (final AnnotationMirror annotation : ref.getAnnotationMirrors()) {
            for (final TypeMirror type : declaredType.getTypeArguments()) {
 */
        return true;
 */
    }
                    );
            processingEnv.getMessager()
    private void process(ExecutableElement executable, ReferenceType ref) {
    /**
        }
        if (publicApi != null) {
                checkPublic(executable.getEnclosingElement(), element);
                    process(executable, wildcardType);
 * SPDX-License-Identifier: Apache-2.0
        checkNotInternal(enclosing, executable);
import javax.lang.model.SourceVersion;
        // Process method arguments
            return;
        return false;
                        + " is part of the public APIs but is marked as @InternalApi"
    public Set<String> getSupportedOptions() {
    }
        if (patch < 0) {
@InternalApi
public class ApiAnnotationProcessor extends AbstractProcessor {
        return belongsToOpenSearch;
    }
                    reportFailureAs,
     * Check the fields, methods, constructors, and member types that are directly
        } else if (ref instanceof TypeVariable typeVariable) {
        }
 *  filtering out package-private declarations</li>
 *  <li>make sure those leak only {@link PublicApi}, {@link DeprecatedApi} or {@link ExperimentalApi} types as well (exceptions,
    }
import javax.lang.model.AnnotatedConstruct;
    @Override
    }
import java.util.Set;
    private static final String OPENSEARCH_PACKAGE = "org.opensearch";
    private static final String OPTION_CONTINUE_ON_FAILING_CHECKS = "continueOnFailingChecks";
        return Set.of(OPTION_CONTINUE_ON_FAILING_CHECKS);
                .printMessage(
                        + ((referencedBy != null) ? " (referenced by " + referencedBy + ") " : "")
                checkPublic(executable.getEnclosingElement(), element);
     */
     * Check top level executable element
        if (reported.contains(element)) {
        final TypeMirror returnType = executable.getReturnType();
     * @param element element to check
     * @return {@code true} if a particular element belongs to OpenSeach managed packages, {@code false} otherwise
                    "The element "
import javax.lang.model.element.VariableElement;
 * The annotation processor for API related annotations: {@link DeprecatedApi}, {@link ExperimentalApi},
     * Check reference type bounds referred by an executable element
                processingEnv.getMessager()
                continue;
                .printMessage(
                continue;
            checkPublicVisibility(null, element);
                processingEnv.getMessager()
    }
        }
     */
}
    private void checkPublicVisibility(Element referencedBy, final Element element) {
     * Check wildcard type bounds referred by an element
            }
    private boolean validateVersion(String version) {
import javax.annotation.processing.SupportedAnnotationTypes;
                process(typeElement);
                            + deprecatedApi.since()
        validated.add(element);
     * @return {@code true} if a particular element should be inspected, {@code false} otherwise
package org.opensearch.common.annotation.processor;
        }
                .printMessage(
            }
     * @return {@code true} if a particular executable element should be inspected, {@code false} otherwise
            reported.add(element);
            processingEnv.getMessager()
            reported.add(element);
            }
        for (final VariableElement parameter : executable.getParameters()) {
        // The element was validated already
                    .printMessage(
            }
    /**
        );
        }
                );
        if (reported.contains(element)) {
        int patch = Integer.parseInt(parts[2]);
        }
            && element.getAnnotation(ExperimentalApi.class) == null
                        + ".* package "
            if (inspectable(element)) {
        final Set<? extends Element> elements = round.getElementsAnnotatedWithAny(
 *    method return values, method arguments, method generic type arguments, class generic type arguments,  annotations)</li>
 * compatible open source license.
        // Check the fields, methods, constructors, and member types that are directly
            if (element instanceof TypeElement typeElement) {
        final boolean belongsToOpenSearch = pckg.getQualifiedName().toString().startsWith(OPENSEARCH_PACKAGE);
    private Kind reportFailureAs = Kind.ERROR;
            if (inspectable(element)) {
import org.opensearch.common.annotation.DeprecatedApi;
import javax.lang.model.type.DeclaredType;
     * @param type wildcard type
        String[] parts = version.split("[.-]");
                            + element
@SupportedAnnotationTypes("org.opensearch.common.annotation.*")
    /**
    private void validate(Element element) {
        }
            }
        final PublicApi publicApi = element.getAnnotation(PublicApi.class);
                        + " is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi"
        // The element has been processed already
                    reportFailureAs,
        // declared in this class or interface.
            return false;
            }
     * Check if element has public visibility (following Java visibility rules)
        for (final TypeMirror thrownType : executable.getThrownTypes()) {
                process(executable, refType);
    private void checkNotInternal(@Nullable Element referencedBy, final Element element) {
        }
        if (type.getSuperBound() instanceof ReferenceType refType) {
        if (ref instanceof DeclaredType declaredType) {
                if (type instanceof ReferenceType refType) {
    }
     * @param ref reference type
                checkNotInternal(executable.getEnclosingElement(), element);
            return false;
            processingEnv.getMessager()
    private boolean inspectable(Element element) {
                    reportFailureAs,
    private void checkPublic(@Nullable Element referencedBy, final Element element) {
     * @param referencedBy the referrer for the element
    /**
import javax.lang.model.element.ExecutableElement;
    }
            if (typeVariable.getUpperBound() instanceof ReferenceType refType) {
        }
                        + element
            reported.add(element);
import javax.lang.model.type.TypeVariable;
        // consumed (not instantiated) by external consumers.
            final Element element = annotation.getAnnotationType().asElement();
            reported.add(element);
     * @param executable top level executable element
        processingEnv.getMessager().printMessage(Kind.NOTE, "Processing OpenSearch Api annotations");
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment round) {
            return;
            process(executable, refType);
    }
        }
                        + ((referencedBy != null) ? " (referenced by " + referencedBy + ") " : "")
                process(executableElement, element);
        // The executable element should not be internal (unless constructor for injectable core component)
    /**
            final Element element = annotation.getAnnotationType().asElement();
        }
            if (inspectable(element)) {
        }
    private void process(ExecutableElement executable, WildcardType type) {
    private void process(Element element) {
        final DeprecatedApi deprecatedApi = element.getAnnotation(DeprecatedApi.class);
    @Override
        }
                checkNotInternal(executable.getEnclosingElement(), element);
        if (returnType instanceof ReferenceType refType) {
/**
    /**
    /**
    private boolean inspectable(ExecutableElement executable) {
                    reportFailureAs,
        if (minor < 0) {
        }
 *  <li>introspect each type annotated with {@link PublicApi}, {@link DeprecatedApi} or {@link ExperimentalApi},
        if (major > 3 || major < 0) {
        }
                    "The type "
        // Process method type parameters
import org.opensearch.common.annotation.ExperimentalApi;
import javax.lang.model.element.AnnotationMirror;
        } else if (ref instanceof ArrayType arrayType) {
                process(executable, refType);
                        reportFailureAs,
    /**
import org.opensearch.common.annotation.PublicApi;
        if (reported.contains(element)) {
            if (componentType instanceof ReferenceType refType) {
import javax.lang.model.element.TypeElement;
                        + element
                );
    /**
        // Process method return types
     */
        }
                        + OPENSEARCH_PACKAGE
        checkPublicVisibility(referencedBy, element);
import java.util.HashSet;
    @Override
        final PackageElement pckg = processingEnv.getElementUtils().getPackageOf(element);
        }
import javax.lang.model.element.PackageElement;
                        reportFailureAs,
        // The element was reported already
                );
        if (element.getAnnotation(InternalApi.class) != null) {
