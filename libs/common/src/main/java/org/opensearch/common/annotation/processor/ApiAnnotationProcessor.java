                } else if (type instanceof WildcardType wildcardType) {
     */
        // The element was reported already  
    /**
    private final Set<AnnotatedConstruct> processed = new HashSet<>();
        if (reported.contains(element)) {
     * declared in this class or interface.  
        // Check this element's annotations
            return;
            }  
            && element.getAnnotation(DeprecatedApi.class) == null) {  
                    reportFailureAs,
                    );  
                process(executableElement, element);
        final Set<? extends Element> elements = round.getElementsAnnotatedWithAny(
                        + " is part of the public APIs but is marked as @InternalApi"
                );
        }
            return;  
        for (final Element enclosed : element.getEnclosedElements()) {  
            // Skip all not-public elements
                );
            reported.add(element);
            process(executable, refType);
            processingEnv.getMessager()  
            if (!validateVersion(deprecatedApi.since())) {  
                    process(executable, refType);  
            checkPublicVisibility(null, element);
        // Check the fields, methods, constructors, and member types that are directly
            final TypeMirror parameterType = parameter.asType();
    }  
     * @param executable element
                            + element
            }
     * @param ref reference type  
        final boolean belongsToOpenSearch = pckg.getQualifiedName().toString().startsWith(OPENSEARCH_PACKAGE);
     */
        // The executable element should not be internal (unless constructor for injectable core component)
        return true;
        // Process method thrown types
     * @param referencedBy the referrer for the element  
     * @param element element to inspect
        // The constructors for public APIs could use non-public APIs when those are supposed to be only
                    reportFailureAs,  
        return Set.of(OPTION_CONTINUE_ON_FAILING_CHECKS);  
import org.opensearch.common.annotation.InternalApi;
    }
        // The element was validated already
     * @param executable executable element to inspect
 * SPDX-License-Identifier: Apache-2.0
                        + " is not residing in "  
            for (final TypeMirror type : declaredType.getTypeArguments()) {
                .printMessage(
            if (inspectable(element)) {
 *
        for (final VariableElement parameter : executable.getParameters()) {
import javax.lang.model.element.AnnotationMirror;  
    private void process(ExecutableElement executable, Element enclosing) {  
            // Skip all not-public elements
                process(executable, refType);  
                if (type instanceof ReferenceType refType) {
            if (typeVariable.getLowerBound() instanceof ReferenceType refType) {
import javax.lang.model.element.ExecutableElement;  
 *  <li>recursively follow the type introspection chains to enforce the rules down the line</li>  
        for (var element : elements) {  
 *  <li>make sure those leak only {@link PublicApi}, {@link DeprecatedApi} or {@link ExperimentalApi} types as well (exceptions,
        }  
            if (parameterType instanceof ReferenceType refType) {  
            if (!enclosed.getModifiers().contains(Modifier.PUBLIC)) {
    }  
        return false;  
import org.opensearch.common.annotation.DeprecatedApi;
                process(executable, refType);  
                        + element
    private static final String OPENSEARCH_PACKAGE = "org.opensearch";
     * @return {@code true} if a particular element should be inspected, {@code false} otherwise
import org.opensearch.common.annotation.ExperimentalApi;  
     * @param element element to inspect  
        }
            if (componentType instanceof ReferenceType refType) {
        checkNotInternal(enclosing, executable);  
        }  
            return false;
            }
            if (inspectable(element)) {
public class ApiAnnotationProcessor extends AbstractProcessor {
import javax.lang.model.element.VariableElement;
     * @param element class or interface
                .printMessage(
        );
                    "The element "  
            processingEnv.getMessager()
        }  
        return pckg.getQualifiedName().toString().startsWith(OPENSEARCH_PACKAGE);
        if (minor < 0) {
                        + " is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi"
        // consumed (not instantiated) by external consumers.  
    }
                );
     * Check if a particular element belongs to OpenSeach managed packages  
            }
        // Check this element's annotations
import javax.lang.model.element.Element;
        if (validated.contains(element)) {
    private void checkNotInternal(@Nullable Element referencedBy, final Element element) {  
    }
                        reportFailureAs,
            }
    private void process(ExecutableElement executable, ReferenceType ref) {
        if (!element.getModifiers().contains(Modifier.PUBLIC) && !element.getModifiers().contains(Modifier.PROTECTED)) {
     * Check if a particular executable element should be inspected or not  
                );  
                    process(executable, wildcardType);
            process(executable, refType);
            reported.add(element);
 * The OpenSearch Contributors require contributions made to  
                        + element  
                    "The element "
            return;  
        }
    /**
        return executable.getKind() != ElementKind.CONSTRUCTOR && executable.getModifiers().contains(Modifier.PUBLIC);
            }  
     * Check reference type bounds referred by an executable element
     * Check wildcard type bounds referred by an element
            return false;
                    );
            }
            }  
     */  
        }
        processingEnv.getMessager().printMessage(Kind.NOTE, "Processing OpenSearch Api annotations");
                continue;  
/**
        }
        }  
    private static final String OPTION_CONTINUE_ON_FAILING_CHECKS = "continueOnFailingChecks";  
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment round) {
                checkPublic(executable.getEnclosingElement(), element);
import javax.lang.model.type.TypeMirror;  
            validate(element);
            for (final TypeMirror boundType : typeParameter.getBounds()) {
        for (final AnnotationMirror annotation : executable.getAnnotationMirrors()) {  
        // declared in this class or interface.
        int major = Integer.parseInt(parts[0]);
 *  <li>introspect each type annotated with {@link PublicApi}, {@link DeprecatedApi} or {@link ExperimentalApi},
import javax.lang.model.element.TypeElement;  
        if (processed.add(ref) == false) {
                continue;
        checkPublicVisibility(referencedBy, element);
     * @param enclosing enclosing element
        if (type.getExtendsBound() instanceof ReferenceType refType) {  
        // The element was reported already
            }
            }  
    private void checkPublicVisibility(Element referencedBy, final Element element) {
        }
        }  
     * Check if a particular element should be inspected or not
     * @param type wildcard type  
            final Element element = annotation.getAnnotationType().asElement();
        if (!belongsToOpenSearch) {
    /**  
    public SourceVersion getSupportedSourceVersion() {  
 * </ul>
    /**
        }  
 * <ul>
import javax.lang.model.type.ReferenceType;
            }
                    "The element "  
 * this file be licensed under the Apache-2.0 license or a
    private boolean inspectable(ExecutableElement executable) {
        final TypeMirror returnType = executable.getReturnType();  
        for (final AnnotationMirror annotation : ref.getAnnotationMirrors()) {
                checkNotInternal(executable.getEnclosingElement(), element);  
        } else if (ref instanceof TypeVariable typeVariable) {
            }  
     * @return {@code true} if a particular executable element should be inspected, {@code false} otherwise
        if (element.getAnnotation(PublicApi.class) == null
        }
                        + ((referencedBy != null) ? " (referenced by " + referencedBy + ") " : "")  
        String[] parts = version.split("[.-]");
            process(executable, refType);
                        + element
 * compatible open source license.
            return;
        }
    /**
        if (processingEnv.getOptions().containsKey(OPTION_CONTINUE_ON_FAILING_CHECKS) == true) {
        }
    }
     * @param element element to check
     * Check the fields, methods, constructors, and member types that are directly
 * The checks are built on top of the following rules:  
        final PublicApi publicApi = element.getAnnotation(PublicApi.class);
        if (ref instanceof DeclaredType declaredType) {
    /**
import javax.lang.model.element.TypeParameterElement;
        if (parts.length < 3 || parts.length > 4) {  
                        reportFailureAs,  
                    process(executable, refType);
    private void process(Element element) {  
    private boolean validateVersion(String version) {
            final TypeMirror componentType = arrayType.getComponentType();  
                        + ((referencedBy != null) ? " (referenced by " + referencedBy + ") " : "")
     * Check if element is public and annotated with {@link PublicApi}, {@link DeprecatedApi} or {@link ExperimentalApi}
                            + " has @DeprecatedApi annotation with unparseable OpenSearch version: "  
     */
    @Override
        for (final TypeMirror thrownType : executable.getThrownTypes()) {  
        if (patch < 0) {  
                process(executable, refType);
    /**  
                checkNotInternal(executable.getEnclosingElement(), element);
     */  
            return false;
        if (!inspectable(executable)) {
    private void process(ExecutableElement executable, WildcardType type) {
     * @return {@code true} if a particular element belongs to OpenSeach managed packages, {@code false} otherwise
                process(typeElement);
        for (final TypeParameterElement typeParameter : executable.getTypeParameters()) {
import javax.lang.model.type.DeclaredType;
                .printMessage(  
    @Override  
        }
    private boolean checkPackage(Element element) {
        }
     */
     * Check if element has public visibility (following Java visibility rules)  
import org.opensearch.common.annotation.PublicApi;
        if (deprecatedApi != null) {
     * @param referencedBy the referrer for the element
                        + ((referencedBy != null) ? " (referenced by " + referencedBy + ") " : "")  
     */
                processingEnv.getMessager()
            if (!checkPackage(element)) {  
        final DeprecatedApi deprecatedApi = element.getAnnotation(DeprecatedApi.class);
                    "The type "
            Set.of(PublicApi.class, ExperimentalApi.class, DeprecatedApi.class)  
 */  
        }  
    /**
                checkNotInternal(executable.getEnclosingElement(), element);  
    }
            }
                processingEnv.getMessager()
    public Set<String> getSupportedOptions() {
            reportFailureAs = Kind.NOTE;
                }
        validated.add(element);  
            final Element element = declaredType.asElement();
 * <p>
    }
                checkPublic(executable.getEnclosingElement(), element);
import javax.lang.model.element.ElementKind;
        }
import org.opensearch.common.Nullable;
 */
    }  
                process(executable, refType);
import javax.annotation.processing.SupportedAnnotationTypes;  
        // Process method type parameters  
        // Process method return types
import javax.lang.model.element.PackageElement;
        if (reported.contains(element)) {
                process(executable, refType);
     * @param element element to check  
        // The element was reported already
     */
                        "The type "
    }
            processingEnv.getMessager()  
            if (element instanceof TypeElement typeElement) {
                if (boundType instanceof ReferenceType refType) {  
     * @param element element to check
        if (publicApi != null) {  
        return SourceVersion.latest();
@InternalApi  
    private final Set<Element> reported = new HashSet<>();  
import javax.lang.model.AnnotatedConstruct;
            }
import javax.annotation.processing.AbstractProcessor;
        }  
        }  
            if (inspectable(element)) {
            }
    }
import java.util.Set;  
import javax.lang.model.type.TypeVariable;
 *    method return values, method arguments, method generic type arguments, class generic type arguments,  annotations)</li>
        } else if (ref instanceof ArrayType arrayType) {
        final PackageElement pckg = processingEnv.getElementUtils().getPackageOf(element);
            reported.add(element);  
 * {@link InternalApi} and {@link PublicApi}.
        int patch = Integer.parseInt(parts[2]);
import javax.lang.model.type.ArrayType;  
        return belongsToOpenSearch;
                        "The type " + element + " has @PublicApi annotation with unparseable OpenSearch version: " + publicApi.since()
    }  
                    reportFailureAs,
    private void checkPublic(@Nullable Element referencedBy, final Element element) {
@SupportedAnnotationTypes("org.opensearch.common.annotation.*")
            if (!validateVersion(publicApi.since())) {
     */  
            return false;
        if (reported.contains(element)) {  
        int minor = Integer.parseInt(parts[1]);  
    /**
                        + ".* package "
     */
     * Check if element is not annotated with {@link InternalApi}
/*  
        }
     * @param referencedBy the referrer for the element
     * Check top level executable element
    }
            return;
    @Override
import javax.annotation.processing.RoundEnvironment;
package org.opensearch.common.annotation.processor;
import javax.lang.model.element.Modifier;
            if (enclosed instanceof ExecutableElement executableElement) {  
        }
import javax.tools.Diagnostic.Kind;  
            return false;  
            if (typeVariable.getUpperBound() instanceof ReferenceType refType) {
 *  filtering out package-private declarations</li>  
                        + " is part of the public APIs but does not have public or protected visibility"
            if (thrownType instanceof ReferenceType refType) {
     * @param executable executable element
            processingEnv.getMessager()
                    .printMessage(  
                    .printMessage(
                    reportFailureAs,
            reported.add(element);
        if (returnType instanceof ReferenceType refType) {
                        + OPENSEARCH_PACKAGE
}
        if (major > 3 || major < 0) {
    private Kind reportFailureAs = Kind.ERROR;  
            }
                        + element
    private void validate(Element element) {  
        if (element.getAnnotation(InternalApi.class) != null) {  
                        + "and should not be annotated as OpenSearch APIs."  
                .printMessage(
                }  
    }
        final PackageElement pckg = processingEnv.getElementUtils().getPackageOf(element);
    /**  
    }
 * The annotation processor for API related annotations: {@link DeprecatedApi}, {@link ExperimentalApi},  
        }
        // The element has been processed already  
        // Process method arguments  
                            + deprecatedApi.since()
        }  
     * @param executable top level executable element  
        }
import javax.lang.model.type.WildcardType;
import java.util.HashSet;
        }
            && element.getAnnotation(ExperimentalApi.class) == null
import javax.lang.model.SourceVersion;
        }
    private boolean inspectable(Element element) {  
                checkPublic(executable.getEnclosingElement(), element);  
            final Element element = annotation.getAnnotationType().asElement();  
    private final Set<Element> validated = new HashSet<>();
        if (type.getSuperBound() instanceof ReferenceType refType) {
