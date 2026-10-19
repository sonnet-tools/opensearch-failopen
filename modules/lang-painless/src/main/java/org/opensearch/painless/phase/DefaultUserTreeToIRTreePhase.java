import org.opensearch.painless.symbol.Decorations.EncodingDecoration;
    public void visitFunction(SFunction userFunctionNode, ScriptScope scriptScope) {
            typedInterfaceReferenceNode.setReference(
            BinaryImplNode binaryImplNode = new BinaryImplNode(location);  
                // this is a compound assignment and requires and additional dup to re-access the prefix
            invokeCallNode.setBox(DefBootstrap.class);
                accessDepth,
                CastNode irCastNode = new CastNode(irLoadNode.getLocation());  
                    irLoadDotNode.setField(painlessField);
import java.util.List;
                .addAll(Arrays.asList(Lookup.class, String.class, MethodType.class, int.class, int.class, Object[].class));
            irForEachSubArrayNode.setVariableType(variable.getType());
        irBinaryImplNode.setLeftNode((ExpressionNode) visit(userCallNode.getPrefixNode(), scriptScope));
        scriptScope.putDecoration(userTryNode, new IRNodeDecoration(irTryNode));
            irBinaryImplNode.setLeftNode(irStaticNode);  
                    );
        ListInitializationNode irListInitializationNode = new ListInitializationNode(userListInitNode.getLocation());
        irConstantNode.setConstant(scriptScope.getDecoration(userDecimalNode, StandardConstant.class).getStandardConstant());
            }  
                    irStoreDotShortcutNode.setSetter(
            int augmentedOffset = method.javaMethod.getDeclaringClass() == method.targetClass ? 0 : 1;
    @Override  
import org.opensearch.painless.symbol.Decorations.ComparisonType;
import org.opensearch.painless.lookup.PainlessLookup;  
            if (prefixValueType != null) {
            staticNode.setExpressionType(DefBootstrap.class);  
            irExpressionNode = irStoreNode;
        irFunctionNode.setBlockNode((BlockNode) visit(userLambdaNode.getBlockNode(), scriptScope));
            irLoadVariableNode = new LoadVariableNode(internalLocation);  
                        scriptScope.getDecoration(userDotNode, GetterPainlessMethod.class).getGetterPainlessMethod()
            irLoadVariableNode.setExpressionType(int.class);
        irReferenceNode.setExpressionType(scriptScope.getDecoration(userLambdaNode, ValueType.class).getValueType());
            irBinaryMathNode.setShiftType(shiftType);  
        irMapInitializationNode.setConstructor(  
                        scriptScope.getDecoration(userDotNode, GetterPainlessMethod.class).getGetterPainlessMethod()  
                irConstantNode.setConstant(index);  
                    Pattern.class,
        scriptScope.putDecoration(userThrowNode, new IRNodeDecoration(irThrowNode));  
import org.opensearch.painless.node.ESymbol;
            irReferenceNode = defInterfaceReferenceNode;  
     * This handles both load and store for brace accesses as necessary. This uses buildLoadStore to  
        );
            Location location = userSymbolNode.getLocation();  
                irLoadListShortcutNode.setExpressionType(scriptScope.getDecoration(userBraceNode, ValueType.class).getValueType());  
        scriptScope.putDecoration(userWhileNode, new IRNodeDecoration(irWhileLoopNode));  
        irConstantNode.setExpressionType(scriptScope.getDecoration(userDecimalNode, ValueType.class).getValueType());
    public void visitNull(ENull userNullNode, ScriptScope scriptScope) {
import org.opensearch.painless.ir.LoadDotDefNode;
import org.opensearch.painless.DefBootstrap;
                    irLoadNode = irLoadDotShortcutNode;
            } else {  
            ExpressionNode irLoadNode = irStoreNode.getChildNode();  
            if (upcast != null) {
        irNewObjectNode.setConstructor(
import org.opensearch.painless.node.ECallLocal;
                irCastNode.setChildNode(irLoadNode);  
        irDoWhileLoopNode.setConditionNode(injectCast(userDoNode.getConditionNode(), scriptScope));  
                    irStoreListShortcutNode.setStoreType(valueType);
            Class<?> valueType = scriptScope.getDecoration(userSymbolNode, ValueType.class).getValueType();
    }
                }
    @Override  
import org.opensearch.painless.symbol.Decorations.AllEscape;
    public void visitBreak(SBreak userBreakNode, ScriptScope scriptScope) {
            }
                    StoreDotNode irStoreDotNode = new StoreDotNode(location);  
                );  
 * The OpenSearch Contributors require contributions made to  
                constantNode.setExpressionType(parameterType);
import org.opensearch.painless.symbol.Decorations.Explicit;
            irExpressionNode = stringConcatenationNode;  
                if (write == false || compound) {
 */
                    irExpressionNode = binaryImplNode;
            irStoreNode.setChildNode(irExpressionNode);  
            irLoadFieldMemberNode.setName("$COMPILERSETTINGS");
            ExpressionNode irCompoundNode;
    }
            String symbol = userSymbolNode.getSymbol();
                    irStoreMapShortcutNode.setStoreType(valueType);  
            ExpressionNode irLoadNode = null;
import org.opensearch.painless.ir.StoreListShortcutNode;  
            if (prefixValueType != null && prefixValueType.getValueType().isArray()) {
import org.opensearch.painless.symbol.Decorations.ListShortcut;
            irFlipArrayIndexNode.setChildNode(irIndexNode);
        irConditionalNode.setExpressionType(scriptScope.getDecoration(userConditionalNode, ValueType.class).getValueType());  
import org.opensearch.painless.ir.InvokeCallMemberNode;
import org.opensearch.painless.symbol.Decorations.StandardConstant;  
                irBinaryMathNode.setLeftNode(irLoadNode);
            invokeCallNode.addArgumentNode(irConstantNode);
        } else if (scriptScope.getCondition(userBraceNode, MapShortcut.class)) {
import org.opensearch.painless.node.ENumeric;
        irConstantNode.setConstant(scriptScope.getDecoration(userStringNode, StandardConstant.class).getStandardConstant());
                    );  
                    irExpressionNode = irConstantNode;
import org.opensearch.painless.symbol.SemanticScope.Variable;
        } catch (Exception exception) {
import org.opensearch.painless.node.SIf;
            }
            } else if (userFunctionNode.isAutoReturnEnabled()) {  
import org.opensearch.painless.symbol.Decorations.ReferenceDecoration;  
import org.opensearch.painless.node.SFor;
        irCatchNode.setExceptionType(variable.getType());  
                ((StoreNode) ((BinaryImplNode) irAssignmentNode).getRightNode()).setChildNode(irValueNode);
    }  
            );
            TypedInterfaceReferenceNode typedInterfaceReferenceNode = new TypedInterfaceReferenceNode(userFunctionRefNode.getLocation());  
            BinaryImplNode irBinaryImplNode = new BinaryImplNode(internalLocation);  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.painless.node.SEach;  
        BlockNode irBlockNode = (BlockNode) visit(userEachNode.getBlockNode(), scriptScope);  
        }
                );  
            irFieldNode.setName(bindingName);
        }
        FieldNode irFieldNode = new FieldNode(internalLocation);  
            );
        } else {
        if (prefixValueType.isArray()) {
                    irDupNode.setDepth(accessDepth);  
            irFunctionNode.setVarArgs(true);  
        );  
    }
                        || returnType == char.class
import org.opensearch.painless.lookup.PainlessClassBinding;  
        irFunctionNode.setSynthetic(true);  
        }
                scriptScope.getDecoration(userFunctionRefNode, ReferenceDecoration.class).getReference()
        ReferenceNode irReferenceNode;
            PainlessCast downcast = scriptScope.hasDecoration(userAssignmentNode, DowncastPainlessCast.class)
            throw userBraceNode.createError(new IllegalStateException("illegal tree structure"));
            if (irAssignmentNode instanceof BinaryImplNode) {
        } else if (scriptScope.hasDecoration(callLocalNode, StandardPainlessInstanceBinding.class)) {
            }
        for (AExpression userArgumentNode : callLocalNode.getArgumentNodes()) {
                    ),
                irLoadBraceDefNode.setIndexType(indexType);
                irBinaryMathNode.setFlags(DefBootstrap.OPERATOR_COMPOUND_ASSIGNMENT);  
        if (targetType == null) {
            }
                dupNode.setExpressionType(void.class);
        FunctionNode irFunctionNode = new FunctionNode(userNewArrayFunctionRefNode.getLocation());
            irLoadVariableNode.setName("flavor");
import org.opensearch.painless.node.SDeclaration;
        CastNode irCastNode = new CastNode(irExpressionNode.getLocation());
            if (write || compound) {  
        if (userCallNode.isNullSafe()) {
            FieldNode irFieldNode = new FieldNode(callLocalNode.getLocation());
                        scriptScope.getDecoration(userDotNode, SetterPainlessMethod.class).getSetterPainlessMethod()
        irFieldNode.setFieldType(Pattern.class);  
                    // the value is read from after the assignment (pre-increment/compound)
        }
                    null
            PainlessMethod method = scriptScope.getDecoration(userCallNode, StandardPainlessMethod.class).getStandardPainlessMethod();
 */  
    public void visitSymbol(ESymbol userSymbolNode, ScriptScope scriptScope) {  
import org.opensearch.painless.ir.InvokeCallNode;
import org.opensearch.painless.symbol.Decorations.IterablePainlessMethod;
        irComparisonNode.setComparisonType(scriptScope.getDecoration(userCompNode, ComparisonType.class).getComparisonType());
                irStoreNode = irStoreListShortcutNode;
    public void visitString(EString userStringNode, ScriptScope scriptScope) {
            ForEachSubArrayNode irForEachSubArrayNode = new ForEachSubArrayNode(userEachNode.getLocation());
        irElvisNode.setExpressionType(scriptScope.getDecoration(userElvisNode, ValueType.class).getValueType());
import org.opensearch.painless.ir.BinaryMathNode;
    }
            }
                scriptScope.getDecoration(userFunctionRefNode, EncodingDecoration.class).getEncoding()
import org.opensearch.painless.ir.StaticNode;
                irBinaryMathNode.setExpressionType(compoundType);
        irFunctionNode.addParameterName("size");  
    }
            invokeCallNode.setMethod(  
                irConstantNode.setExpressionType(String.class);
                        int.class,
            irIndexNode = irFlipArrayIndexNode;  
            );
                    LoadListShortcutNode irLoadListShortcutNode = new LoadListShortcutNode(location);
        irFieldNode = new FieldNode(internalLocation);
                throw userFunctionNode.createError(new IllegalStateException("illegal tree structure"));
        irWhileLoopNode.setConditionNode(injectCast(userWhileNode.getConditionNode(), scriptScope));
    public void visitBinary(EBinary userBinaryNode, ScriptScope scriptScope) {
            irForEachSubIterableNode.setVariableName(variable.getName());
        irBooleanNode.setRightNode(injectCast(userBooleanCompNode.getRightNode(), scriptScope));
    }
                DupNode dupNode = new DupNode(location);  
import org.opensearch.painless.ir.FunctionNode;
        irDeclarationNode.setExpressionNode(injectCast(userDeclarationNode.getValueNode(), scriptScope));  
                    null
        }
                }
                        irConstantNode.setConstant(false);  
                        Object[].class  
        } else if (scriptScope.getCondition(userBraceNode, ListShortcut.class)) {  
import org.opensearch.painless.ir.ConstantNode;
                    .getStandardPainlessField();  
                    irLoadNode = irLoadListShortcutNode;  
import org.opensearch.painless.MethodWriter;  
        InstanceofNode irInstanceofNode = new InstanceofNode(userInstanceofNode.getLocation());
    @Override
            if (write == false || compound) {
            BinaryImplNode irBinaryImplNode = new BinaryImplNode(userRegexNode.getLocation());
import org.opensearch.painless.symbol.Decorations.Read;
        DeclarationBlockNode irDeclarationBlockNode = new DeclarationBlockNode(userDeclBlockNode.getLocation());
        irReturnNode.setExpressionNode(injectCast(userReturnNode.getValueNode(), scriptScope));
                irBinaryMathNode.setFlags(DefBootstrap.OPERATOR_EXPLICIT_CAST);
            irConstantNode.setConstant(userRegexNode.getPattern());  
            }
        scriptScope.putDecoration(userClassNode, new IRNodeDecoration(irClassNode));  
                    ((DupNode) ((BinaryImplNode) irLoadNode).getLeftNode()).setDepth(1);
                    irStoreListShortcutNode.setSetter(  
            } else if (prefixValueType != null && prefixValueType.getValueType() == def.class) {
        Class<?> prefixValueType = scriptScope.getDecoration(userBraceNode.getPrefixNode(), ValueType.class).getValueType();
import org.opensearch.painless.symbol.Decorations.TypeParameters;  
import org.opensearch.painless.node.STry;
        irLoadVariableNode.setName("size");
            }  
                irStoreBraceNode.setStoreType(valueType);
                binaryImplNode.setRightNode(irNullSafeSubNode);  
        StoreNode irStoreNode = null;
        irLoadFieldMemberNode.setName(memberFieldName);  
import org.opensearch.painless.symbol.Decorations.ParameterNames;
            irForEachSubArrayNode.setConditionNode(irIterableNode);  
        Location location,
                accessDepth = 1;
        BinaryImplNode irBinaryImplNode = new BinaryImplNode(irExpressionNode.getLocation());  
        scriptScope.putDecoration(userBraceNode, new AccessDepth(2));
            typedInterfaceReferenceNode.setReference(  
import org.opensearch.painless.node.EString;
    }
        } else if (prefixValueType == def.class) {
            }
                        PainlessLookup.class,
    protected void injectBootstrapMethod(ScriptScope scriptScope) {
            irReferenceNode = defInterfaceReferenceNode;
import org.opensearch.painless.ir.FieldNode;
        irBlockNode.addStatementNode(irReturnNode);
 *  
import org.opensearch.painless.ir.LoadMapShortcutNode;  
        ExpressionNode irExpressionNode;
import org.opensearch.painless.symbol.ScriptScope;
            targetType = PainlessLookupUtility.typeToBoxedType(painlessCast.boxTargetType);  
    public void visitCallLocal(ECallLocal callLocalNode, ScriptScope scriptScope) {
                }
import org.opensearch.painless.symbol.Decorations.UnaryType;
            irExpressionNode = irBinaryMathNode;  
            if (write == false || compound) {
        ReturnNode irReturnNode = new ReturnNode(userNewArrayFunctionRefNode.getLocation());  
                    binaryImplNode.setRightNode(irExpressionNode);  
                    LoadMapShortcutNode irLoadMapShortcutNode = new LoadMapShortcutNode(location);
import org.opensearch.painless.ir.TypedCaptureReferenceNode;
     * This injects additional ir nodes required for resolving the def type at runtime.
                BinaryMathNode irBinaryMathNode = (BinaryMathNode) irCompoundNode;  
    public void visitConditional(EConditional userConditionalNode, ScriptScope scriptScope) {
import org.opensearch.painless.lookup.def;  
        ConstantNode irConstantNode = new ConstantNode(userStringNode.getLocation());  
        irIfElseNode.setElseBlockNode((BlockNode) visit(userIfElseNode.getElseBlockNode(), scriptScope));  
import org.opensearch.painless.lookup.PainlessField;
            // no need to downcast so the binary math node is the value for the store node
            // the value is read from after the assignment
            if (write || compound) {
                StandardPainlessInstanceBinding.class
        if (scriptScope.hasDecoration(userDotNode, StaticType.class)) {  
        boolean methodEscape = scriptScope.getCondition(userFunctionNode, MethodEscape.class);  
import org.opensearch.painless.ir.StoreDotNode;  
    @Override  
            } else if (scriptScope.getCondition(userDotNode, ListShortcut.class)) {
        int functionArity = userFunctionNode.getCanonicalTypeNameParameters().size();  
    @Override
        irFunctionNode.setMaxLoopCounter(0);
        injectBootstrapMethod(scriptScope);
            DefInterfaceReferenceNode defInterfaceReferenceNode = new DefInterfaceReferenceNode(userFunctionRefNode.getLocation());
            StaticNode staticNode = new StaticNode(userSymbolNode.getLocation());
                irStoreNode = irStoreVariableNode;  
                throw userDotNode.createError(new IllegalStateException("illegal tree structure"));
        irLoadFieldMemberNode.setStatic(true);
        if (scriptScope.getCondition(userUnaryNode.getChildNode(), Negate.class)) {
                }
        );
                injectCast(userMapInitNode.getValueNodes().get(i), scriptScope)
    public void visitContinue(SContinue userContinueNode, ScriptScope scriptScope) {
    @Override  
        ConstantNode irConstantNode = new ConstantNode(userDecimalNode.getLocation());  
            if (write == false || compound) {  
        scriptScope.putDecoration(userCatchNode, new IRNodeDecoration(irCatchNode));
            irLoadFieldMemberNode.setExpressionType(FunctionTable.class);
        BlockNode irBlockNode = new BlockNode(userNewArrayFunctionRefNode.getLocation());  
    public void visitIfElse(SIfElse userIfElseNode, ScriptScope scriptScope) {
                irBinaryMathNode.setOperation(userAssignmentNode.getOperation());
        irInvokeCallMemberNode.setExpressionType(scriptScope.getDecoration(callLocalNode, ValueType.class).getValueType());
    @Override
                irStoreMapShortcutNode.setSetter(
                    scriptScope.getDecoration(userBraceNode, GetterPainlessMethod.class).getGetterPainlessMethod()
                .getPainlessClassBinding();
                if (userAssignmentNode.postIfRead()) {  
 * KIND, either express or implied.  See the License for the
        CapturesDecoration capturesDecoration = scriptScope.getDecoration(userFunctionRefNode, CapturesDecoration.class);
        scriptScope.putDecoration(userIfElseNode, new IRNodeDecoration(irIfElseNode));
        InvokeCallMemberNode irInvokeCallMemberNode = new InvokeCallMemberNode(callLocalNode.getLocation());
                BinaryMathNode irBinaryMathNode = new BinaryMathNode(irStoreNode.getLocation());  
                    binaryImplNode.setLeftNode(irPrefixNode);
                }
import org.opensearch.painless.symbol.Decorations.StandardPainlessClassBinding;
import org.opensearch.painless.ir.ComparisonNode;
                irStoreListShortcutNode.setStoreType(valueType);  
        );
                ConstantNode irConstantNode = new ConstantNode(location);
            StatementExpressionNode irStatementExpressionNode = new StatementExpressionNode(userExpressionNode.getLocation());
                if (irLoadNode instanceof BinaryImplNode && WriterConstants.INDY_STRING_CONCAT_BOOTSTRAP_HANDLE == null) {
                    irLoadNode = irLoadMapShortcutNode;
    protected IRNode visit(ANode userNode, ScriptScope scriptScope) {
    @Override
            irForEachSubIterableNode.setBlockNode(irBlockNode);  
    }
            irConstantNode = new ConstantNode(userRegexNode.getLocation());
        if (irPrefixNode != null) {  
     * This helper generates a set of ir nodes that are required for an assignment
                dupNode.setChildNode(irPrefixNode);
            );
            }
        if (scriptScope.hasDecoration(callLocalNode, StandardLocalFunction.class)) {
        StoreNode irStoreNode  
        FieldNode irFieldNode = new FieldNode(userRegexNode.getLocation());
            if (isNullSafe) {  
        irBinaryImplNode.setRightNode(irExpressionNode);
            irAssignmentNode = irStoreNode;
            TypedInterfaceReferenceNode typedInterfaceReferenceNode = new TypedInterfaceReferenceNode(  
        irListInitializationNode.setExpressionType(scriptScope.getDecoration(userListInitNode, ValueType.class).getValueType());
        scriptScope.putDecoration(userDecimalNode, new IRNodeDecoration(irConstantNode));
import org.opensearch.painless.node.EBooleanConstant;
            irConditionNode = irForEachSubArrayNode;
            irClassNode.addFunctionNode(irFunctionNode);
        ComparisonNode irComparisonNode = new ComparisonNode(userCompNode.getLocation());
            irExpressionNode = buildLoadStore(0, location, false, null, null, irLoadNode, irStoreNode);
            StaticNode staticNode = new StaticNode(userDotNode.getLocation());
    public void visitDeclBlock(SDeclBlock userDeclBlockNode, ScriptScope scriptScope) {  
                }  
        irInstanceofNode.setExpressionType(scriptScope.getDecoration(userInstanceofNode, ValueType.class).getValueType());
                irBinaryMathNode.setRightNode(irValueNode);
                    null,
                    irLoadNode = irDupNode;  
import org.opensearch.painless.ir.StoreBraceDefNode;  
     * This handles both load and store for dot accesses as necessary. This uses buildLoadStore to
            : null;  
        if (irExpressionNode == null) {
                        FunctionTable.class,
            irFunctionNode.setName("$bootstrapDef");  
            ? scriptScope.getDecoration(userEachNode, ExpressionPainlessCast.class).getExpressionPainlessCast()
import org.opensearch.painless.ir.StoreVariableNode;  
        irFieldNode.setFieldType(PainlessLookup.class);
            userBraceNode,
            } else {
            ;
    @Override
        // adds static fields required for def bootstrapping
                irDupNode.setDepth(accessDepth);
                stringConcatenationNode.setExpressionType(String.class);  
            irReturnNode.setExpressionNode(irExpressionNode);
            irFieldNode.setModifiers(Modifier.PRIVATE);  
            InvokeCallDefNode irCallSubDefNode = new InvokeCallDefNode(userCallNode.getLocation());
        irNewArrayNode.setExpressionType(returnType);
            Class<?> staticType = scriptScope.getDecoration(userDotNode, StaticType.class).getStaticType();
                        Map.class,  
                    irStoreDotDefNode.setValue(index);
    @Override  
    }
                    irDupNode.setSize(MethodWriter.getType(irLoadNode.getExpressionType()).getSize());  
            irInvokeCallMemberNode.setImportedMethod(  
    @Override
            InvokeCallNode invokeCallNode = new InvokeCallNode(userRegexNode.getLocation());
        }  
    public void visitNumeric(ENumeric userNumericNode, ScriptScope scriptScope) {
            stringConcatenationNode.addArgumentNode((ExpressionNode) visit(userBinaryNode.getLeftNode(), scriptScope));
    @Override
            irForEachSubArrayNode.setBlockNode(irBlockNode);
            irForEachSubIterableNode.setConditionNode(irIterableNode);
        ContinueNode irContinueNode = new ContinueNode(userContinueNode.getLocation());
        } else {  
    public void visitDecimal(EDecimal userDecimalNode, ScriptScope scriptScope) {
            if (concatenate) {
        scriptScope.putDecoration(userElvisNode, new IRNodeDecoration(irElvisNode));  
 * Licensed to Elasticsearch under one or more contributor  
        StatementNode irStatementNode;
            irForEachSubIterableNode.setIteratorType(Iterator.class);
    @Override  
        if (scriptScope.hasDecoration(userSymbolNode, StaticType.class)) {  
        scriptScope.putDecoration(userContinueNode, new IRNodeDecoration(irContinueNode));
import org.opensearch.painless.symbol.Decorations.BinaryType;  
    public void visitDot(EDot userDotNode, ScriptScope scriptScope) {  
            irLoadFieldMemberNode.setStatic(true);  
import org.opensearch.painless.ir.ReferenceNode;
        }
        irForLoopNode.setConditionNode(injectCast(userForNode.getConditionNode(), scriptScope));
        ExpressionNode irPrefixNode,  
            if (returnType == void.class) {
        for (SFunction userFunctionNode : userClassNode.getFunctionNodes()) {
        irConstantNode.setExpressionType(scriptScope.getDecoration(userBooleanConstantNode, ValueType.class).getValueType());
import org.opensearch.painless.ir.DoWhileLoopNode;
    @Override  
     * stub out the appropriate load and store ir nodes.
 * not use this file except in compliance with the License.
            irFieldNode.setModifiers(Modifier.PUBLIC | Modifier.STATIC);  
                irLoadNode = irLoadDotArrayLengthNode;
                    irStoreDotShortcutNode.setStoreType(valueType);
            }
 *
            irTryNode.addCatchNode((CatchNode) visit(userCatchNode, scriptScope));
        irWhileLoopNode.setBlockNode((BlockNode) visit(userWhileNode.getBlockNode(), scriptScope));  
import org.opensearch.painless.node.EBooleanComp;  
            );
            userNode.visit(this, scriptScope);
import org.opensearch.painless.symbol.Decorations.Write;
        }
            irForEachSubArrayNode.setArrayName("#array" + userEachNode.getLocation().getOffset());  
            scriptScope.putDecoration(userDotNode, new AccessDepth(accessDepth));
        List<Variable> captures = scriptScope.getDecoration(userLambdaNode, CapturesDecoration.class).getCaptures();  
        // adds the bootstrap method required for dynamic binding for def type resolution  
            scriptScope.setCondition(userAssignmentNode.getLeftNode(), Compound.class);
     * @param irPrefixNode The prefix node for this store/load. The 'a.b' of 'a.b.c', etc.
        irClassNode.addFieldNode(irFieldNode);  
            if (write || compound) {  
import org.opensearch.painless.ir.NullNode;
                irStoreNode.setChildNode(irCompoundNode);
            return null;  
        irFieldNode.setName(memberFieldName);
        if (expressionPainlessCast == null) {
            }
    public void visitRegex(ERegex userRegexNode, ScriptScope scriptScope) {
                    LoadDotShortcutNode irLoadDotShortcutNode = new LoadDotShortcutNode(location);  
            ExpressionNode irPrefixNode = (ExpressionNode) visit(userDotNode.getPrefixNode(), scriptScope);
                        String.class,  
        } catch (Exception exception) {  
    @Override
        ExpressionNode irExpressionNode;
                        FunctionTable.class,  
            irBinaryMathNode.setBinaryType(scriptScope.getDecoration(userBinaryNode, BinaryType.class).getBinaryType());
 * GitHub history for details.
                NullSafeSubNode irNullSafeSubNode = new NullSafeSubNode(location);
        scriptScope.putDecoration(userForNode, new IRNodeDecoration(irForLoopNode));
import org.opensearch.painless.ir.ForEachSubArrayNode;
    }  
        irExpressionNode.setExpressionType(valueType);  
            }
            String bindingName = scriptScope.getNextSyntheticName("class_binding");  
import org.opensearch.painless.ir.IRNode;
                irStoreBraceNode.setExpressionType(read ? valueType : void.class);
import org.opensearch.painless.symbol.Decorations.AccessDepth;
import org.opensearch.painless.node.SExpression;
                }
        BooleanNode irBooleanNode = new BooleanNode(userBooleanCompNode.getLocation());  
        LoadVariableNode irLoadVariableNode = new LoadVariableNode(userNewArrayFunctionRefNode.getLocation());
        irFunctionNode.setMaxLoopCounter(scriptScope.getCompilerSettings().getMaxLoopCounter());
                    irLoadDotNode.setExpressionType(valueType);  
        irNewObjectNode.setRead(scriptScope.getCondition(userNewObjectNode, Read.class));  
                irStoreBraceNode.setIndexType(indexType);
        irIfNode.setConditionNode(injectCast(userIfNode.getConditionNode(), scriptScope));
            irNewArrayNode.addArgumentNode(injectCast(userArgumentNode, scriptScope));
        scriptScope.putDecoration(userListInitNode, new IRNodeDecoration(irListInitializationNode));
            // build the structure to combine the prefix and the load/store
        } else {  
                CastNode irCastNode = new CastNode(irCompoundNode.getLocation());
                userDotNode.isNullSafe(),  
                irCastNode.setExpressionType(downcast.targetType);  
import org.opensearch.painless.node.SDo;
        scriptScope.putDecoration(userExpressionNode, new IRNodeDecoration(irStatementNode));  
            irForEachSubArrayNode.setIndexName("#index" + userEachNode.getLocation().getOffset());
            StoreNode irStoreNode = null;
            irLoadFieldMemberNode.setName("$DEFINITION");
        scriptScope.putDecoration(userRegexNode, new IRNodeDecoration(irLoadFieldMemberNode));  
    protected ClassNode irClassNode;
 * compatible open source license.
 * this work for additional information regarding copyright
            ReturnNode irReturnNode = new ReturnNode(userExpressionNode.getLocation());  
            irNode = visit(userUnaryNode.getChildNode(), scriptScope);
            stringConcatenationNode.addArgumentNode((ExpressionNode) visit(userBinaryNode.getRightNode(), scriptScope));
            return irExpressionNode;
import org.opensearch.painless.node.AStatement;  
            } else {
                iterableValueType == def.class
import org.opensearch.painless.ir.ListInitializationNode;  
                irDupNode.setExpressionType(irValueNode.getExpressionType());  
        irFieldNode.setFieldType(FunctionTable.class);  
    public void visitUnary(EUnary userUnaryNode, ScriptScope scriptScope) {  
                location,
        irFieldNode.setModifiers(Modifier.FINAL | Modifier.STATIC | Modifier.PRIVATE);
        }
        PainlessCast painlessCast = scriptScope.hasDecoration(userEachNode, ExpressionPainlessCast.class)
                irLoadNode = irCastNode;
import org.opensearch.painless.symbol.Decorations.Shortcut;
import org.opensearch.painless.symbol.Decorations.ReturnType;
    @Override
    @Override
                dupNode.setSize(accessDepth);
        irFieldNode.setModifiers(modifiers);
        scriptScope.putDecoration(userAssignmentNode, new IRNodeDecoration(irAssignmentNode));
        }  
            irIndexNode = irFlipCollectionIndexNode;
            }
                    if (returnType == boolean.class) {
        irCastNode.setChildNode(irExpressionNode);
                        || returnType == short.class  
        scriptScope.putDecoration(userDotNode, new IRNodeDecoration(irExpressionNode));
                    irLoadListShortcutNode.setExpressionType(valueType);
            irConditionNode = irForEachSubIterableNode;  
            irBinaryMathNode.setRightNode(injectCast(userBinaryNode.getRightNode(), scriptScope));
import org.opensearch.painless.lookup.PainlessCast;
        irDeclarationNode.setDeclarationType(variable.getType());
        scriptScope.putDecoration(  
            PainlessInstanceBinding painlessInstanceBinding = scriptScope.getDecoration(
                    Pattern.class,  
            TypedCaptureReferenceNode typedCaptureReferenceNode = new TypedCaptureReferenceNode(userFunctionRefNode.getLocation());
        }  
            throw userSymbolNode.createError(new IllegalStateException("illegal tree structure"));
                DupNode irDupNode = new DupNode(irValueNode.getLocation());
                irLoadNode,  
            irLoadVariableNode.setName("type");
                ((StoreNode) irAssignmentNode).setChildNode(irValueNode);
import org.opensearch.painless.ir.CatchNode;  
            irForEachSubIterableNode.setContinuous(false);
            irStoreFieldMemberNode.setName(memberFieldName);
            irForEachSubArrayNode.setIndexedType(iterableValueType.getComponentType());  
                    irLoadDotShortcutNode.setGetter(
                irLoadNode = irLoadMapShortcutNode;
        Location internalLocation = new Location("$internal$injectStaticFields", 0);  
                irIndexNode = irConstantNode;  
    }
        Location location = userBraceNode.getLocation();
            irNode = irUnaryMathNode;
            boolean read = scriptScope.getCondition(userDotNode, Read.class);  
                irNullSafeSubNode.setChildNode(irExpressionNode);
        scriptScope.putDecoration(userBinaryNode, new IRNodeDecoration(irExpressionNode));
            defInterfaceReferenceNode.setDefReferenceEncoding(  
            );
                callLocalNode,  
        for (SCatch userCatchNode : userTryNode.getCatchNodes()) {
import org.opensearch.painless.ir.TryNode;  
        irFunctionNode.setReturnType(scriptScope.getDecoration(userLambdaNode, ReturnType.class).getReturnType());
            irFunctionNode.getTypeParameters()
            irExpressionNode = staticNode;
            DefInterfaceReferenceNode defInterfaceReferenceNode = new DefInterfaceReferenceNode(userLambdaNode.getLocation());  
                // handles when the operation is mathematical
    @Override
                irLoadVariableNode.setName(symbol);  
                } else {
import org.opensearch.painless.ir.StoreDotShortcutNode;
                new PainlessMethod(  
                constantNode.setConstant(injection);
        scriptScope.putDecoration(userFunctionNode, new IRNodeDecoration(irFunctionNode));  
            );  
            irBinaryImplNode.setExpressionType(Pattern.class);
    public void visitIf(SIf userIfNode, ScriptScope scriptScope) {
     * @param location The location for errors.  
            irStatementNode = irReturnNode;
            irListInitializationNode.addArgumentNode(injectCast(userValueNode, scriptScope));
                    irExpressionNode = new NullNode(userFunctionNode.getLocation());  
    }
        }
        scriptScope.putDecoration(userIfNode, new IRNodeDecoration(irIfNode));
        NullNode irNullNode = new NullNode(userNullNode.getLocation());  
            irBlockNode.addStatementNode(irReturnNode);
            irForEachSubArrayNode.setVariableName(variable.getName());  
            );
    protected ExpressionNode buildLoadStore(
                    scriptScope.getDecoration(userBraceNode, GetterPainlessMethod.class).getGetterPainlessMethod()
     */
import org.opensearch.painless.ir.FlipDefIndexNode;
            for (AExpression userArgumentNode : userCallNode.getArgumentNodes()) {  
        irFunctionNode.setBlockNode(irBlockNode);
                // build the structure for a standard load/store
        irConstantNode.setExpressionType(scriptScope.getDecoration(userNumericNode, ValueType.class).getValueType());
import org.opensearch.painless.lookup.PainlessInstanceBinding;
        } else {  
                irStoreVariableNode.setStoreType(valueType);
            irNullSafeSubNode.setChildNode(irExpressionNode);
            irReferenceNode = typedInterfaceReferenceNode;
        irBooleanNode.setLeftNode(injectCast(userBooleanCompNode.getLeftNode(), scriptScope));  
            );
            } else if (scriptScope.getCondition(userDotNode, MapShortcut.class)) {  
    }
        } else {
        TargetType targetType = scriptScope.getDecoration(userFunctionRefNode, TargetType.class);
                    CallSite.class,  
        if (scriptScope.hasDecoration(userLambdaNode, TargetType.class)) {
        }
            irLoadFieldMemberNode = new LoadFieldMemberNode(internalLocation);
            }
 * under the License.  
                LoadVariableNode irLoadVariableNode = new LoadVariableNode(location);
                    // the null-safe structure is slightly different from the standard structure since
    public void visitDeclaration(SDeclaration userDeclarationNode, ScriptScope scriptScope) {
                    } else if (returnType == byte.class
            invokeCallNode.setExpressionType(Pattern.class);  
        irNewArrayNode.addArgumentNode(irLoadVariableNode);
        irClassNode.addFunctionNode(irFunctionNode);
    public void visitExplicit(EExplicit userExplicitNode, ScriptScope scriptScope) {
        irClassNode.addFieldNode(irFieldNode);
        irNewObjectNode.setExpressionType(scriptScope.getDecoration(userNewObjectNode, ValueType.class).getValueType());
        } else if (painlessCast.unboxTargetType != null) {
     * @param irStoreNode The store node if this is a write.
    public void visitInstanceof(EInstanceof userInstanceofNode, ScriptScope scriptScope) {  
            invokeCallNode.addArgumentNode(irLoadVariableNode);
            irLoadFieldMemberNode.setExpressionType(PainlessLookup.class);
        );
                if (write || compound) {  
            irLoadVariableNode.setExpressionType(String.class);
            if (write == false || compound) {  
        for (SDeclaration userDeclarationNode : userDeclBlockNode.getDeclarationNodes()) {  
    public void visitFor(SFor userForNode, ScriptScope scriptScope) {
        } else {
     * @param irIndexNode The index node if this is a brace access.  
                    irDupNode = new DupNode(irStoreNode.getLocation());  
            }
import org.opensearch.painless.symbol.Decorations.IRNodeDecoration;
        FunctionNode irFunctionNode = new FunctionNode(userFunctionNode.getLocation());
import org.opensearch.painless.symbol.Decorations.UpcastPainlessCast;
        } else if (iterableValueType == def.class || Iterable.class.isAssignableFrom(iterableValueType)) {  
                irStoreVariableNode.setName(symbol);
        irFunctionNode.getParameterNames().addAll(scriptScope.getDecoration(userLambdaNode, ParameterNames.class).getParameterNames());  
        for (AStatement userStatementNode : userBlockNode.getStatementNodes()) {
    @Override  
import org.opensearch.painless.ir.BreakNode;
        irListInitializationNode.setMethod(
                StoreBraceNode irStoreBraceNode = new StoreBraceNode(location);  
import org.opensearch.painless.symbol.Decorations.ContinuousLoop;
            ReturnNode irReturnNode = new ReturnNode(userFunctionNode.getLocation());
import org.opensearch.painless.symbol.Decorations.StandardLocalFunction;
import org.opensearch.painless.ir.StoreFieldMemberNode;
                        } else {  
            irMapInitializationNode.addArgumentNode(
            irReferenceNode = typedCaptureReferenceNode;
            targetType = painlessCast.unboxTargetType;
                    irStoreListShortcutNode.setExpressionType(read ? valueType : void.class);
                irCastNode.setCast(downcast);
    }
 * this file be licensed under the Apache-2.0 license or a
        irConditionalNode.setConditionNode(injectCast(userConditionalNode.getConditionNode(), scriptScope));
            }  
import org.opensearch.painless.ir.LoadDotNode;
        irConstantNode.setExpressionType(scriptScope.getDecoration(userStringNode, ValueType.class).getValueType());
import org.opensearch.painless.ir.WhileLoopNode;
        MapInitializationNode irMapInitializationNode = new MapInitializationNode(userMapInitNode.getLocation());  
        // build out the load structure for load/compound assignment or the store structure for just store  
            } else {
                    );  
                    scriptScope.getDecoration(userBraceNode, SetterPainlessMethod.class).getSetterPainlessMethod()
                    irExpressionNode.setExpressionType(returnType);
            irBinaryImplNode.setRightNode(invokeCallNode);
    }
            }
            }
                    scriptScope.getDecoration(userBraceNode, SetterPainlessMethod.class).getSetterPainlessMethod()
                irLoadBraceDefNode.setExpressionType(valueType);
            if (operation == Operation.MATCH || operation == Operation.FIND) {
            irLoadVariableNode.setName("initialDepth");
            ConstantNode irConstantNode = new ConstantNode(userRegexNode.getLocation());
        irClassNode = new ClassNode(userClassNode.getLocation());  
            irStoreFieldMemberNode.setExpressionType(void.class);  
import org.opensearch.painless.symbol.Decorations.CompoundType;
                }
            irLoadVariableNode.setExpressionType(Lookup.class);
                irLoadBraceNode.setExpressionType(valueType);
            return scriptScope.getDecoration(userNode, IRNodeDecoration.class).getIRNode();  
 *
            irUnaryMathNode.setOperation(userUnaryNode.getOperation());
        }
        irElvisNode.setLeftNode(injectCast(userElvisNode.getLeftNode(), scriptScope));  
        irFunctionNode.getTypeParameters().addAll(localFunction.getTypeParameters());
            );
                if (isNullSafe) {
import org.opensearch.painless.ir.ConditionNode;  
            irFlipDefIndexNode.setChildNode(irIndexNode);  
            irInvokeCallNode.setBox(boxType);
            irFunctionNode.getParameterNames()  
            irStoreFieldMemberNode.setChildNode(irBinaryImplNode);
    }
import org.opensearch.painless.node.EMapInit;  
                irStoreNode = irStoreMapShortcutNode;
                : null;
                injectCast(userMapInitNode.getKeyNodes().get(i), scriptScope),  
            throw userRegexNode.createError(new IllegalStateException("illegal tree structure"));
    }
        scriptScope.putDecoration(userUnaryNode, new IRNodeDecoration(irNode));
                    irLoadListShortcutNode.setGetter(  
import org.opensearch.painless.ir.ForEachLoopNode;  
                StoreBraceDefNode irStoreBraceNode = new StoreBraceDefNode(location);
        irComparisonNode.setExpressionType(scriptScope.getDecoration(userCompNode, ValueType.class).getValueType());  
    public void visitBooleanConstant(EBooleanConstant userBooleanConstantNode, ScriptScope scriptScope) {
        } else if (capturesDecoration != null && capturesDecoration.getCaptures().get(0).getType() == def.class) {
    }
    public void visitCatch(SCatch userCatchNode, ScriptScope scriptScope) {
            irReturnNode.setExpressionNode(irExpressionNode);
                        Object[].class
            invokeCallNode.addArgumentNode(irLoadVariableNode);
            ExpressionNode irIndexNode = null;  
            // handles a standard assignment  
            invokeCallNode.setExpressionType(CallSite.class);
            irInvokeCallMemberNode.setInstanceBinding(painlessInstanceBinding);
            TypedInterfaceReferenceNode typedInterfaceReferenceNode = new TypedInterfaceReferenceNode(userLambdaNode.getLocation());
            ).getPainlessInstanceBinding();
        irIfElseNode.setConditionNode(injectCast(userIfElseNode.getConditionNode(), scriptScope));
    }  
        }
import org.opensearch.painless.Operation;
        scriptScope.putDecoration(userBooleanCompNode, new IRNodeDecoration(irBooleanNode));  
    protected ExpressionNode injectCast(AExpression userExpressionNode, ScriptScope scriptScope) {
            irStoreFieldMemberNode.setStoreType(Pattern.class);
                    );
            ? scriptScope.getDecoration(userUnaryNode, UnaryType.class).getUnaryType()
            typedCaptureReferenceNode.setMethodName(userFunctionRefNode.getMethodName());  
                accessDepth = 1;
            Object[] injections = PainlessLookupUtility.buildInjections(method, scriptScope.getCompilerSettings().asMap());  
            LoadFieldMemberNode irLoadFieldMemberNode = new LoadFieldMemberNode(internalLocation);  
import org.opensearch.painless.ir.ForLoopNode;  
                irStringConcatenationNode.addArgumentNode(irLoadNode);  
        }
        ExpressionPainlessCast expressionPainlessCast = scriptScope.getDecoration(userExpressionNode, ExpressionPainlessCast.class);
            Class<?>[] parameterTypes = method.javaMethod.getParameterTypes();
        } else {  
                irConstantNode.setExpressionType(int.class);
                    null,  
            irLoadVariableNode = new LoadVariableNode(internalLocation);  
                irPrefixNode = dupNode;
        scriptScope.putDecoration(userNewArrayFunctionRefNode, new IRNodeDecoration(irReferenceNode));
            irUnaryMathNode.setUnaryType(unaryType);  
                    irStoreNode = irStoreListShortcutNode;  
                    irStoreDotNode.setExpressionType(read ? valueType : void.class);
        }  
                    // both the index and expression are not written to the stack if the prefix is null  
        irClassNode.addFieldNode(irFieldNode);  
    @Override
            irFunctionNode.setReturnType(CallSite.class);
                        MethodType.class,
                binaryImplNode.setLeftNode(irPrefixNode);  
        scriptScope.putDecoration(userNumericNode, new IRNodeDecoration(irConstantNode));
            irInvokeCallMemberNode.addArgumentNode(injectCast(userArgumentNode, scriptScope));
    }
                    irStoreDotNode.setStoreType(valueType);
            irFunctionNode.setBlockNode(blockNode);  
import org.opensearch.painless.node.SReturn;  
                    irDupNode.setExpressionType(irStoreNode.getStoreType());
        irDeclarationNode.setName(variable.getName());
        irMapInitializationNode.setMethod(  
                        scriptScope.getDecoration(userDotNode, SetterPainlessMethod.class).getSetterPainlessMethod()  
            invokeCallNode.addArgumentNode(irLoadFieldMemberNode);
        scriptScope.putDecoration(userSymbolNode, new IRNodeDecoration(irExpressionNode));
        irComparisonNode.setRightNode(injectCast(userCompNode.getRightNode(), scriptScope));
        irFieldNode.setModifiers(modifiers);
            }  
            scriptScope.getDecoration(userListInitNode, StandardPainlessMethod.class).getStandardPainlessMethod()  
            if (downcast == null) {  
                }  
import org.opensearch.painless.ir.NewArrayNode;  
        }  
    public void visitClass(SClass userClassNode, ScriptScope scriptScope) {
        if (methodEscape == false) {
                if (write == false || compound) {
            irForEachSubArrayNode.setContinuous(false);
            } else {
            InvokeCallNode invokeCallNode = new InvokeCallNode(internalLocation);
import org.opensearch.painless.node.EExplicit;
                // build the structure for a null safe load
        irCastNode.setCast(painlessCast);
                if (returnType.isPrimitive()) {
    }
        } else {
import org.opensearch.painless.node.ENewObj;  
            invokeCallNode.setBox(Pattern.class);
                Class<?> parameterType = parameterTypes[i + augmentedOffset];  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.painless.symbol.Decorations.SetterPainlessMethod;  
                ? scriptScope.getDecoration(userBinaryNode, ShiftType.class).getShiftType()  
        irFieldNode.setName("$COMPILERSETTINGS");
import org.opensearch.painless.lookup.PainlessMethod;
 * Unless required by applicable law or agreed to in writing,
                // add a compound assignment flag to the binary math node
    @Override  
import org.opensearch.painless.node.SBreak;
            irForEachSubArrayNode.setIndexType(int.class);
        scriptScope.putDecoration(userNewObjectNode, new IRNodeDecoration(irNewObjectNode));  
        irFunctionNode.setMaxLoopCounter(scriptScope.getCompilerSettings().getMaxLoopCounter());
     * This handles both load and store for symbol accesses as necessary. This uses buildLoadStore to
import org.opensearch.painless.ir.StatementExpressionNode;  
            );  
        irFunctionNode.setBlockNode(irBlockNode);
        int accessDepth,  
                scriptScope.getDecoration(callLocalNode, StandardPainlessMethod.class).getStandardPainlessMethod()
            irReferenceNode.addCapture(capture.getName());  
import org.opensearch.painless.ir.StatementNode;
import org.opensearch.painless.node.SClass;
                if (write == false || compound) {
            irStatementExpressionNode.setExpressionNode(irExpressionNode);
import org.opensearch.painless.node.SCatch;  
            irCallSubDefNode.setExpressionType(scriptScope.getDecoration(userCallNode, ValueType.class).getValueType());
                ? scriptScope.getDecoration(userAssignmentNode, UpcastPainlessCast.class).getUpcastPainlessCast()
    /**
            scriptScope.getDecoration(userListInitNode, StandardPainlessConstructor.class).getStandardPainlessConstructor()  
                irStoreNode.setChildNode(irCastNode);  
            irUnaryMathNode.setOriginallyExplicit(scriptScope.getCondition(userUnaryNode, Explicit.class));
                LoadBraceDefNode irLoadBraceDefNode = new LoadBraceDefNode(location);  
                    : scriptScope.getDecoration(userEachNode, IterablePainlessMethod.class).getIterablePainlessMethod()  
                    irDupNode.setChildNode(irStoreNode.getChildNode());
        for (Variable capture : captures) {
            Class<?> boxType;
                    irStoreNode = irStoreDotNode;
import org.opensearch.painless.ir.LoadDotArrayLengthNode;  
                } else {
        irFieldNode.setModifiers(modifiers);  
            blockNode.setAllEscape(true);
                irLoadNode = irLoadBraceNode;  
        ExpressionNode irIndexNode = injectCast(userBraceNode.getIndexNode(), scriptScope);
        irNewArrayNode.setInitialize(userNewArrayNode.isInitializer());
            irConstantNode.setConstant(scriptScope.getDecoration(userRegexNode, StandardConstant.class).getStandardConstant());  
                irCastNode.setCast(upcast);
    }
import org.opensearch.painless.ir.StringConcatenationNode;
        if (irLoadNode != null && irStoreNode != null) {
        internalLocation = new Location("$internal$injectDefBootstrapMethod", 0);
                irLoadNode = irLoadBraceDefNode;  
            }
        );  
                        scriptScope.getDecoration(userDotNode, SetterPainlessMethod.class).getSetterPainlessMethod()
    @Override
 * You may obtain a copy of the License at  
            irBinaryMathNode.setLeftNode(injectCast(userBinaryNode.getLeftNode(), scriptScope));
            invokeCallNode.addArgumentNode(irLoadFieldMemberNode);  
            DefInterfaceReferenceNode defInterfaceReferenceNode = new DefInterfaceReferenceNode(userNewArrayFunctionRefNode.getLocation());
            }
            ReturnNode returnNode = new ReturnNode(internalLocation);
                accessDepth = 1;
            irFlipArrayIndexNode.setExpressionType(int.class);
            irNewObjectNode.addArgumentNode(injectCast(userArgumentNode, scriptScope));  
                accessDepth = 2;  
            if (write == false || compound) {
        NewObjectNode irNewObjectNode = new NewObjectNode(userNewObjectNode.getLocation());  
    }
            invokeCallNode.setMethod(
     * {@link DefBootstrap#bootstrap(PainlessLookup, FunctionTable, Map, Lookup, String, MethodType, int, int, Object...)}
        }
        irBooleanNode.setOperation(userBooleanCompNode.getOperation());
            throw userEachNode.createError(new IllegalStateException("illegal tree structure"));
    public void visitExpression(SExpression userExpressionNode, ScriptScope scriptScope) {
                        int.class,
    @Override
import org.opensearch.painless.node.AExpression;
        ExpressionNode irPrefixNode = (ExpressionNode) visit(userBraceNode.getPrefixNode(), scriptScope);  
                irIndexNode,
    public void visitReturn(SReturn userReturnNode, ScriptScope scriptScope) {
        NewArrayNode irNewArrayNode = new NewArrayNode(userNewArrayNode.getLocation());
        ExpressionNode irAssignmentNode;  
import org.opensearch.painless.ir.LoadVariableNode;
     * @param irLoadNode The load node if this a read.
        if (userNode == null) {
import org.opensearch.painless.symbol.Decorations.MethodEscape;
import org.opensearch.painless.node.EComp;
                        PainlessLookup.class,
        scriptScope.putDecoration(userCallNode, new IRNodeDecoration(irBinaryImplNode));
                            irConstantNode.setConstant(0f);  
            defInterfaceReferenceNode.setDefReferenceEncoding(
    /**
        boolean read = scriptScope.getCondition(userBraceNode, Read.class);
            Location location = userDotNode.getLocation();  
        irFunctionNode.getTypeParameters().addAll(scriptScope.getDecoration(userLambdaNode, TypeParameters.class).getTypeParameters());
                        Lookup.class,
        ReferenceNode irReferenceNode;  
        irFunctionNode.setVarArgs(false);
        } else {
        return irCastNode;
        for (AExpression userArgumentNode : userNewArrayNode.getValueNodes()) {  
    public void visitComp(EComp userCompNode, ScriptScope scriptScope) {
        scriptScope.putDecoration(userNullNode, new IRNodeDecoration(irNullNode));  
                    Arrays.asList(
            irLoadVariableNode.setExpressionType(int.class);
                }
        Class<?> returnType = localFunction.getReturnType();
import org.opensearch.painless.symbol.Decorations.Negate;  
                    irStoreDotDefNode.setStoreType(valueType);  
            // this load/store is a dot or brace load/store
                            irConstantNode.setConstant(0d);
}
            if (irLoadNode != null && irStoreNode != null) {
                    irConstantNode.setExpressionType(returnType);  
                }  
            NullSafeSubNode irNullSafeSubNode = new NullSafeSubNode(irExpressionNode.getLocation());  
            String index = userDotNode.getIndex();
import org.opensearch.painless.node.SBlock;
                StoreListShortcutNode irStoreListShortcutNode = new StoreListShortcutNode(location);
import org.opensearch.painless.symbol.FunctionTable.LocalFunction;  
import org.opensearch.painless.symbol.Decorations.CapturesDecoration;
                    irLoadMapShortcutNode.setExpressionType(valueType);  
 * specific language governing permissions and limitations
        irComparisonNode.setOperation(userCompNode.getOperation());
            returnNode.setExpressionNode(irBinaryImplNode);  
    public void visitNewArrayFunctionRef(ENewArrayFunctionRef userNewArrayFunctionRefNode, ScriptScope scriptScope) {
            } else {
import org.opensearch.painless.symbol.Decorations.StaticType;
            scriptScope.getDecoration(userMapInitNode, StandardPainlessMethod.class).getStandardPainlessMethod()
                    irLoadMapShortcutNode.setGetter(
        ExpressionNode irExpressionNode;  
        try {  
    }
    }
        ConstantNode irConstantNode = new ConstantNode(userNumericNode.getLocation());  
                    irLoadDotShortcutNode.setExpressionType(valueType);
            FunctionNode irFunctionNode = new FunctionNode(internalLocation);
            binaryImplNode.setExpressionType(irExpressionNode.getExpressionType());
        irNullNode.setExpressionType(scriptScope.getDecoration(userNullNode, ValueType.class).getValueType());
            irLoadFieldMemberNode.setStatic(true);
        irNewArrayNode.setInitialize(false);
        ReturnNode irReturnNode = new ReturnNode(userReturnNode.getLocation());  
    public void visitThrow(SThrow userThrowNode, ScriptScope scriptScope) {
            int accessDepth;  
                            irConstantNode.setConstant(0L);
import org.opensearch.painless.symbol.Decorations.StandardPainlessInstanceBinding;
        scriptScope.putDecoration(userCompNode, new IRNodeDecoration(irComparisonNode));  
import java.lang.invoke.CallSite;
import org.opensearch.painless.ir.BooleanNode;  
                irStoreNode = irStoreBraceNode;
        BreakNode irBreakNode = new BreakNode(userBreakNode.getLocation());  
/*
                binaryImplNode.setLeftNode(irPrefixNode);
            irBinaryMathNode.setOperation(operation);
import org.opensearch.painless.ir.BlockNode;
                    irStoreMapShortcutNode.setSetter(
import org.opensearch.painless.ir.FlipArrayIndexNode;  
            // handles when the operation is a string concatenation  
            irInvokeCallMemberNode.setClassBindingOffset(  
        irDoWhileLoopNode.setBlockNode((BlockNode) visit(userDoNode.getBlockNode(), scriptScope));
        ConstantNode irConstantNode = new ConstantNode(userBooleanConstantNode.getLocation());  
    /**
                    Arrays.asList(String.class, int.class),
                if (write == false || compound) {
                irStoreMapShortcutNode.setExpressionType(read ? valueType : void.class);
            }
        irThrowNode.setExpressionNode(injectCast(userThrowNode.getExpressionNode(), scriptScope));
        IfNode irIfNode = new IfNode(userIfNode.getLocation());  
import org.opensearch.painless.ir.IfNode;
        NewArrayNode irNewArrayNode = new NewArrayNode(userNewArrayFunctionRefNode.getLocation());  
                StoreVariableNode irStoreVariableNode = new StoreVariableNode(location);
                    irDupNode.setChildNode(irLoadNode);
        scriptScope.putDecoration(userDeclarationNode, new IRNodeDecoration(irDeclarationNode));
        irReferenceNode.setExpressionType(scriptScope.getDecoration(userFunctionRefNode, ValueType.class).getValueType());
        ExpressionNode irIndexNode,
import org.opensearch.painless.node.ANode;
import org.opensearch.painless.ir.StoreBraceNode;
                    null,
        DoWhileLoopNode irDoWhileLoopNode = new DoWhileLoopNode(userDoNode.getLocation());
                        Map.class,
            // upcast the stored value if necessary
        // handles a compound assignment using the stub generated from buildLoadStore
import org.opensearch.painless.ir.TypedInterfaceReferenceNode;
    @Override
        irFunctionNode.setVarArgs(false);
import org.opensearch.painless.ir.BinaryImplNode;  
    @Override
import org.opensearch.painless.ir.StoreMapShortcutNode;
                    irStoreDotShortcutNode.setExpressionType(read ? valueType : void.class);  
        } else {
            irInvokeCallMemberNode.setLocalFunction(
            irFunctionNode.setStatic(true);
                scriptScope.getDecoration(userLambdaNode, EncodingDecoration.class).getEncoding()
                // this load/store requires an index
        irFunctionNode.setStatic(true);
            irReferenceNode = defInterfaceReferenceNode;  
            irFlipCollectionIndexNode.setChildNode(irIndexNode);  
        scriptScope.putDecoration(userMapInitNode, new IRNodeDecoration(irMapInitializationNode));
        Class<?> returnType = scriptScope.getDecoration(userNewArrayFunctionRefNode, ReturnType.class).getReturnType();  
                if (write || compound) {
        irLoadFieldMemberNode.setExpressionType(Pattern.class);
        IfElseNode irIfElseNode = new IfElseNode(userIfElseNode.getLocation());  
    }
    @Override
import org.opensearch.painless.node.SWhile;  
                        } else if (returnType == float.class) {
    public void visitEach(SEach userEachNode, ScriptScope scriptScope) {
            ? scriptScope.getDecoration(userAssignmentNode, CompoundType.class).getCompoundType()  
    }
        if (operation == Operation.ADD && valueType == String.class) {
                    irDupNode.setSize(MethodWriter.getType(irStoreNode.getExpressionType()).getSize());
    public void visitFunctionRef(EFunctionRef userFunctionRefNode, ScriptScope scriptScope) {
        irIfElseNode.setBlockNode((BlockNode) visit(userIfElseNode.getIfBlockNode(), scriptScope));
        ValueType prefixValueType = scriptScope.getDecoration(userCallNode.getPrefixNode(), ValueType.class);
                irInvokeCallNode.addArgumentNode(constantNode);  
        String memberFieldName = scriptScope.getNextSyntheticName("regex");
        Class<?> targetType = painlessCast.targetType;  
        scriptScope.putDecoration(userDoNode, new IRNodeDecoration(irDoWhileLoopNode));
                        }
import org.opensearch.painless.node.ELambda;
                irStoreNode = irStoreBraceNode;  
        ExpressionNode irIterableNode = (ExpressionNode) visit(userEachNode.getIterableNode(), scriptScope);
            irConstantNode.setExpressionType(String.class);
        PainlessCast painlessCast = expressionPainlessCast.getExpressionPainlessCast();
    @Override
    }  
        irClassNode.addFieldNode(irFieldNode);
            defInterfaceReferenceNode.setDefReferenceEncoding(  
    public void visitBrace(EBrace userBraceNode, ScriptScope scriptScope) {
        Variable variable = scriptScope.getDecoration(userCatchNode, SemanticVariable.class).getSemanticVariable();  
        scriptScope.putDecoration(userInstanceofNode, new IRNodeDecoration(irInstanceofNode));  
import org.opensearch.painless.ir.ContinueNode;  
        irFunctionNode.setName(scriptScope.getDecoration(userNewArrayFunctionRefNode, MethodNameDecoration.class).getMethodName());  
    }
        DeclarationNode irDeclarationNode = new DeclarationNode(userDeclarationNode.getLocation());
        if (compoundType != null) {
        }
                StringConcatenationNode stringConcatenationNode = new StringConcatenationNode(irStoreNode.getLocation());
        }
    }
    }  
import org.opensearch.painless.symbol.Decorations.StandardPainlessField;
                irCompoundNode.setExpressionType(irStoreNode.getStoreType());
                // add a cast node to do a downcast as the value for the store node  
                    null,  
            if (read) {
        boolean read = scriptScope.getCondition(userAssignmentNode, Read.class);
 *     http://www.apache.org/licenses/LICENSE-2.0
                irValueNode = irDupNode;
import org.opensearch.painless.symbol.Decorations.StandardPainlessConstructor;  
        scriptScope.putDecoration(userConditionalNode, new IRNodeDecoration(irConditionalNode));
    public void visitNewObj(ENewObj userNewObjectNode, ScriptScope scriptScope) {
import org.opensearch.painless.ir.CastNode;
                    LoadDotNode irLoadDotNode = new LoadDotNode(location);
import org.opensearch.painless.symbol.Decorations.ValueType;  
import org.opensearch.painless.symbol.Decorations.Compound;  
        LocalFunction localFunction = scriptScope.getFunctionTable().getFunction(functionName, functionArity);
import org.opensearch.painless.node.ENewArrayFunctionRef;
 */  
            boolean read = scriptScope.getCondition(userSymbolNode, Read.class);  
        for (int i = 0; i < userMapInitNode.getKeyNodes().size(); ++i) {
                accessDepth = 2;
            irExpressionNode = buildLoadStore(  
import org.opensearch.painless.ir.MapInitializationNode;
            irBinaryImplNode.setExpressionType(CallSite.class);
                }  
            blockNode.addStatementNode(irStatementExpressionNode);  
        } else {
        irConditionalNode.setLeftNode(injectCast(userConditionalNode.getTrueNode(), scriptScope));
        } else {  
import org.opensearch.painless.node.SThrow;
                irInvokeCallNode.addArgumentNode(injectCast(userCallArgumentNode, scriptScope));
            irFieldNode.setName(bindingName);
            irStatementNode = irStatementExpressionNode;  
        scriptScope.putDecoration(userNewArrayNode, new IRNodeDecoration(irNewArrayNode));
            invokeCallNode.addArgumentNode(irLoadVariableNode);
    @Override  
        ForLoopNode irForLoopNode = new ForLoopNode(userForNode.getLocation());  
                } else {
            irBinaryImplNode.setLeftNode(staticNode);
            invokeCallNode.addArgumentNode(irLoadVariableNode);
            PainlessClassBinding painlessClassBinding = scriptScope.getDecoration(callLocalNode, StandardPainlessClassBinding.class)
    @Override  
        int modifiers = Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC;
            }
                        int.class,  
            irExpressionNode = irInvokeCallNode;
            irFieldNode.setFieldType(painlessInstanceBinding.targetInstance.getClass());
     */  
            LoadVariableNode irLoadVariableNode = new LoadVariableNode(internalLocation);  
                int accessDepth = scriptScope.getDecoration(userAssignmentNode.getLeftNode(), AccessDepth.class).getAccessDepth();  
     * stub out the appropriate load and store ir nodes.  
                irStoreBraceNode.setExpressionType(read ? valueType : void.class);
            irInvokeCallNode.setExpressionType(scriptScope.getDecoration(userCallNode, ValueType.class).getValueType());
            irClassNode.addFunctionNode((FunctionNode) visit(userFunctionNode, scriptScope));  
                    irLoadNode = irLoadDotDefNode;  
import org.opensearch.painless.symbol.Decorations.InstanceType;  
            irBinaryImplNode.setRightNode(invokeCallNode);
                    irDupNode.setDepth(accessDepth);
    @Override
import org.opensearch.painless.node.ENewArray;
                boxType = prefixValueType.getValueType();
    }
        Variable variable = scriptScope.getDecoration(userEachNode, SemanticVariable.class).getSemanticVariable();  
            irLoadVariableNode.setExpressionType(MethodType.class);
            boolean write = scriptScope.getCondition(userDotNode, Write.class);
import org.opensearch.painless.ir.NewObjectNode;
        boolean isNullSafe,
            irInvokeCallNode.setMethod(scriptScope.getDecoration(userCallNode, StandardPainlessMethod.class).getStandardPainlessMethod());  
                )
            BinaryMathNode irBinaryMathNode = new BinaryMathNode(userBinaryNode.getLocation());  
public class DefaultUserTreeToIRTreePhase implements UserTreeVisitor<ScriptScope> {  
        for (AExpression userArgumentNode : userNewObjectNode.getArgumentNodes()) {
    }
    ) {
        }
        Class<?> valueType = scriptScope.getDecoration(userBinaryNode, ValueType.class).getValueType();  
        irCatchNode.setSymbol(variable.getName());
            irFieldNode.setFieldType(painlessClassBinding.javaConstructor.getDeclaringClass());
            irLoadVariableNode = new LoadVariableNode(internalLocation);  
                irBinaryMathNode.setBinaryType(compoundType);  
        scriptScope.putDecoration(userLambdaNode, new IRNodeDecoration(irReferenceNode));  
                scriptScope.getDecoration(userNewArrayFunctionRefNode, ReferenceDecoration.class).getReference()
                LoadListShortcutNode irLoadListShortcutNode = new LoadListShortcutNode(location);
            for (int i = 0; i < injections.length; i++) {
                        } else if (returnType == long.class) {  
        irClassNode.setScriptScope(scriptScope);  
    public void visitListInit(EListInit userListInitNode, ScriptScope scriptScope) {
            irReferenceNode.addCapture(capturesDecoration.getCaptures().get(0).getName());
                LoadBraceNode irLoadBraceNode = new LoadBraceNode(location);
                irConstantNode.setConstant(scriptScope.getDecoration(userDotNode, StandardConstant.class).getStandardConstant());
        scriptScope.putDecoration(userFunctionRefNode, new IRNodeDecoration(irReferenceNode));
        irFunctionNode.setVarArgs(false);
        irFunctionNode.setName(scriptScope.getDecoration(userLambdaNode, MethodNameDecoration.class).getMethodName());  
        irInstanceofNode.setChildNode((ExpressionNode) visit(userInstanceofNode.getExpressionNode(), scriptScope));
                        } else if (returnType == double.class) {
     */
    @Override
            : null;  
                scriptScope.getDecoration(callLocalNode, StandardLocalFunction.class).getLocalFunction()  
        irMapInitializationNode.setExpressionType(scriptScope.getDecoration(userMapInitNode, ValueType.class).getValueType());
    }
        irFunctionNode.setSynthetic(userFunctionNode.isSynthetic());  
    @Override
                irCastNode.setChildNode(irCompoundNode);
 * license agreements. See the NOTICE file distributed with
                LoadMapShortcutNode irLoadMapShortcutNode = new LoadMapShortcutNode(location);
        Class<?> unaryType = scriptScope.hasDecoration(userUnaryNode, UnaryType.class)
        irConstantNode.setConstant(scriptScope.getDecoration(userBooleanConstantNode, StandardConstant.class).getStandardConstant());
                    irPrefixNode = binaryImplNode;  
                    irStoreMapShortcutNode.setExpressionType(read ? valueType : void.class);
import org.opensearch.painless.node.ENull;
        BlockNode irBlockNode = (BlockNode) visit(userFunctionNode.getBlockNode(), scriptScope);
/*  
        }  
            staticNode.setExpressionType(staticType);  
            irForEachSubIterableNode.setVariableType(variable.getType());
        scriptScope.putDecoration(userEachNode, new IRNodeDecoration(irForEachLoopNode));
import org.opensearch.painless.ir.IfElseNode;  
            irForEachSubIterableNode.setMethod(  
                        int.class,
                irCastNode.setExpressionType(upcast.targetType);
        irFunctionNode.setReturnType(returnType);
                irDupNode.setSize(MethodWriter.getType(irValueNode.getExpressionType()).getSize());
        Variable variable = scriptScope.getDecoration(userDeclarationNode, SemanticVariable.class).getSemanticVariable();  
                StringConcatenationNode irStringConcatenationNode = (StringConcatenationNode) irCompoundNode;
            irForEachSubArrayNode.setCast(painlessCast);
        scriptScope.putDecoration(userReturnNode, new IRNodeDecoration(irReturnNode));  
import org.opensearch.painless.node.EAssignment;
        irForLoopNode.setBlockNode((BlockNode) visit(userForNode.getBlockNode(), scriptScope));
            irNullSafeSubNode.setExpressionType(irExpressionNode.getExpressionType());
                irStoreMapShortcutNode.setStoreType(valueType);  
import org.opensearch.painless.symbol.Decorations.MapShortcut;  
            irConstantNode.setExpressionType(int.class);
        LoadFieldMemberNode irLoadFieldMemberNode = new LoadFieldMemberNode(userRegexNode.getLocation());
            UnaryMathNode irUnaryMathNode = new UnaryMathNode(userUnaryNode.getLocation());
     * @param accessDepth The number of arguments to dup for an additional read.
            invokeCallNode.addArgumentNode(irLoadVariableNode);
            irFlipCollectionIndexNode.setExpressionType(int.class);
                ConstantNode constantNode = new ConstantNode(userCallNode.getLocation());  
import org.opensearch.painless.ir.UnaryMathNode;  
            irClassNode.addFieldNode(irFieldNode);  
                    irStoreDotDefNode.setExpressionType(read ? valueType : void.class);
import org.opensearch.painless.ir.ThrowNode;
 * SPDX-License-Identifier: Apache-2.0
                accessDepth = 1;  
        boolean write = scriptScope.getCondition(userBraceNode, Write.class);  
    }
        irDoWhileLoopNode.setContinuous(scriptScope.getCondition(userDoNode, ContinuousLoop.class));
            FlipCollectionIndexNode irFlipCollectionIndexNode = new FlipCollectionIndexNode(userBraceNode.getIndexNode().getLocation());
                : null;
            BlockNode blockNode = irClassNode.getClinitBlockNode();
            irAssignmentNode = (ExpressionNode) visit(userAssignmentNode.getLeftNode(), scriptScope);
        }  
                    irLoadDotDefNode.setExpressionType(valueType);
                    binaryImplNode.setRightNode(irIndexNode);
        CatchNode irCatchNode = new CatchNode(userCatchNode.getLocation());
    public void visitWhile(SWhile userWhileNode, ScriptScope scriptScope) {  
import org.opensearch.painless.ir.ElvisNode;  
            irLoadFieldMemberNode.setStatic(true);
            if (concatenate) {
        irWhileLoopNode.setContinuous(scriptScope.getCondition(userWhileNode, ContinuousLoop.class));
        ExpressionNode irLoadNode = null;  
                irDupNode.setChildNode(irValueNode);  
                dupNode.setDepth(0);  
import org.opensearch.painless.node.ERegex;  
import org.opensearch.painless.ir.StoreNode;
                    irStoreNode.setChildNode(irDupNode);
            throw callLocalNode.createError(new IllegalStateException("illegal tree structure"));
            irLoadFieldMemberNode.setName("$FUNCTIONS");  
        ThrowNode irThrowNode = new ThrowNode(userThrowNode.getLocation());  
            irInvokeCallMemberNode.setClassBinding(painlessClassBinding);
import org.opensearch.painless.symbol.Decorations.ExpressionPainlessCast;  
                    binaryImplNode.setExpressionType(void.class);  
                irNullSafeSubNode.setExpressionType(irExpressionNode.getExpressionType());  
import org.opensearch.painless.ir.LoadBraceNode;
            irLoadVariableNode.setName("name");
import org.opensearch.painless.node.SFunction;  
    @Override  
        scriptScope.putDecoration(callLocalNode, new IRNodeDecoration(irInvokeCallMemberNode));
        ExpressionNode irExpressionNode = (ExpressionNode) visit(userExpressionNode, scriptScope);
                );  
                StoreMapShortcutNode irStoreMapShortcutNode = new StoreMapShortcutNode(location);
            boolean compound = scriptScope.getCondition(userSymbolNode, Compound.class);
            ExpressionNode irExpressionNode;
        Class<?> valueType = scriptScope.getDecoration(userBraceNode, ValueType.class).getValueType();  
                DupNode irDupNode;  
                irBinaryMathNode.setRegexLimit(scriptScope.getCompilerSettings().getRegexLimitFactor());  
                    DefBootstrap.class.getMethod(
            irLoadFieldMemberNode.setExpressionType(Map.class);  
            FlipDefIndexNode irFlipDefIndexNode = new FlipDefIndexNode(userBraceNode.getIndexNode().getLocation());
import org.opensearch.painless.ir.NullSafeSubNode;  
import org.opensearch.painless.ir.ClassNode;
        if (prefixValueType != null && prefixValueType.getValueType() == def.class) {  
            irForEachSubIterableNode.setCast(painlessCast);  
            } else if (scriptScope.hasDecoration(userDotNode, StandardPainlessField.class)) {
        irFunctionNode.setName(userFunctionNode.getFunctionName());  
import org.opensearch.painless.node.EDecimal;
     */
import org.opensearch.painless.ir.DefInterfaceReferenceNode;  
    @Override  
        irIfNode.setBlockNode((BlockNode) visit(userIfNode.getIfBlockNode(), scriptScope));
    @Override  
import org.opensearch.painless.ir.ReturnNode;
        }  
            // the value is also read from this assignment  
    @Override
        if (scriptScope.hasDecoration(userNewArrayFunctionRefNode, TargetType.class)) {
            irUnaryMathNode.setExpressionType(scriptScope.getDecoration(userUnaryNode, ValueType.class).getValueType());
        if (iterableValueType.isArray()) {
import org.opensearch.painless.node.SContinue;
        irCastNode.setExpressionType(targetType);  
        Operation operation = userBinaryNode.getOperation();
            irLoadVariableNode = new LoadVariableNode(internalLocation);  
        irBinaryImplNode.setExpressionType(irExpressionNode.getExpressionType());  
            );
                irStringConcatenationNode.addArgumentNode(irValueNode);
            StoreNode irStoreNode = null;
        irBlockNode.setAllEscape(scriptScope.getCondition(userBlockNode, AllEscape.class));
                : null;  
import org.opensearch.painless.ir.StoreDotDefNode;
        scriptScope.putDecoration(userBlockNode, new IRNodeDecoration(irBlockNode));
                irBinaryMathNode.setLeftNode(irLoadNode);
        irComparisonNode.setLeftNode(injectCast(userCompNode.getLeftNode(), scriptScope));  
import org.opensearch.painless.symbol.Decorations.DowncastPainlessCast;  
import java.util.Arrays;  
    }  
                irLoadMapShortcutNode.setGetter(
            return null;
        ReferenceNode irReferenceNode;
                if (write || compound) {  
            irFlipDefIndexNode.setExpressionType(indexType);
                if (write || compound) {
import org.opensearch.painless.node.EConditional;  
import org.opensearch.painless.symbol.Decorations.MethodNameDecoration;
        irForEachLoopNode.setConditionNode(irConditionNode);  
            irCallSubDefNode.setName(userCallNode.getMethodName());
    }  
                    irLoadDotDefNode.setValue(index);
import org.opensearch.painless.ir.ForEachSubIterableNode;
        scriptScope.putDecoration(userExplicitNode, new IRNodeDecoration(injectCast(userExplicitNode.getChildNode(), scriptScope)));
                scriptScope.getDecoration(userNewArrayFunctionRefNode, EncodingDecoration.class).getEncoding()
                // must handle the StringBuilder case for java version <= 8  
            irInvokeCallMemberNode.setBindingName(bindingName);  
                irExpressionNode = null;
            irInvokeCallMemberNode.setBindingName(bindingName);  
    @Override
    /**
import org.opensearch.painless.ir.LoadDotShortcutNode;  
import org.opensearch.painless.symbol.Decorations.ShiftType;
     * @param isNullSafe Whether or not the null safe operator is used.
    public void visitNewArray(ENewArray userNewArrayNode, ScriptScope scriptScope) {  
            boolean write = scriptScope.getCondition(userSymbolNode, Write.class);
        if (scriptScope.getCondition(userExpressionNode, MethodEscape.class)) {
                irStoreBraceNode.setStoreType(valueType);  
        String functionName = userFunctionNode.getFunctionName();
            } else if (scriptScope.getCondition(userDotNode, Shortcut.class)) {  
    public void visitBooleanComp(EBooleanComp userBooleanCompNode, ScriptScope scriptScope) {
import org.opensearch.painless.WriterConstants;
     * handling both regular assignment and compound assignment. It only stubs out  
                int accessDepth = scriptScope.getDecoration(userAssignmentNode.getLeftNode(), AccessDepth.class).getAccessDepth();
                irLoadMapShortcutNode.setExpressionType(scriptScope.getDecoration(userBraceNode, ValueType.class).getValueType());  
    @Override  
                    DefBootstrap.class,
            if (write || compound) {  
            FlipArrayIndexNode irFlipArrayIndexNode = new FlipArrayIndexNode(userBraceNode.getIndexNode().getLocation());  
 * software distributed under the License is distributed on an
            typedInterfaceReferenceNode.setReference(scriptScope.getDecoration(userLambdaNode, ReferenceDecoration.class).getReference());  
        WhileLoopNode irWhileLoopNode = new WhileLoopNode(userWhileNode.getLocation());
        // add a cast node if necessary for the value node for the assignment
import java.util.regex.Pattern;
        try {
    public void visitLambda(ELambda userLambdaNode, ScriptScope scriptScope) {
                    irDupNode = new DupNode(irLoadNode.getLocation());
        TryNode irTryNode = new TryNode(userTryNode.getLocation());
            }
            ForEachSubIterableNode irForEachSubIterableNode = new ForEachSubIterableNode(userEachNode.getLocation());
        irCatchNode.setBlockNode((BlockNode) visit(userCatchNode.getBlockNode(), scriptScope));
            } else {  
        scriptScope.putDecoration(userBreakNode, new IRNodeDecoration(irBreakNode));
                Object injection = injections[i];
                    irStoreNode = irStoreMapShortcutNode;
    public void visitBlock(SBlock userBlockNode, ScriptScope scriptScope) {
            Class<?> indexType = scriptScope.getDecoration(userBraceNode.getIndexNode(), ValueType.class).getValueType();  
            }
            irStoreFieldMemberNode.setStatic(true);  
import org.opensearch.painless.ir.InstanceofNode;
    }  
        ExpressionNode irLoadNode,
        irListInitializationNode.setConstructor(
        ExpressionNode irExpressionNode;
     * @return The root node for this assignment.  
            irReferenceNode = typedInterfaceReferenceNode;
            StoreFieldMemberNode irStoreFieldMemberNode = new StoreFieldMemberNode(userRegexNode.getLocation());
            irReferenceNode = typedInterfaceReferenceNode;  
import org.opensearch.painless.symbol.Decorations.TargetType;
                irStoreVariableNode.setExpressionType(read ? valueType : void.class);  
            irLoadFieldMemberNode = new LoadFieldMemberNode(internalLocation);
        irFunctionNode.setStatic(userFunctionNode.isStatic());
                    );
            staticNode.setExpressionType(staticType);  
            irFunctionNode.setSynthetic(true);
    }
                PainlessField painlessField = scriptScope.getDecoration(userDotNode, StandardPainlessField.class)
        ConditionNode irConditionNode;
    @Override  
        }
                irLoadVariableNode.setExpressionType(valueType);
    }
        irConditionalNode.setRightNode(injectCast(userConditionalNode.getFalseNode(), scriptScope));  
            irLoadVariableNode.setName("args");
        } else {
                irLoadNode = irLoadListShortcutNode;
                    );
                    irLoadNode = irLoadDotNode;
            Class<?> staticType = scriptScope.getDecoration(userSymbolNode, StaticType.class).getStaticType();
                        || returnType == int.class) {
            PainlessCast upcast = scriptScope.hasDecoration(userAssignmentNode, UpcastPainlessCast.class)  
            );  
        irFunctionNode.getParameterNames().addAll(userFunctionNode.getParameterNames());  
import org.opensearch.painless.ir.ExpressionNode;
                    Pattern.class.getMethod("compile", String.class, int.class),
            Class<?> valueType = scriptScope.getDecoration(userDotNode, ValueType.class).getValueType();
    }
    }
        ElvisNode irElvisNode = new ElvisNode(userElvisNode.getLocation());
    }
import org.opensearch.painless.node.EUnary;  
        irNewArrayNode.setExpressionType(scriptScope.getDecoration(userNewArrayNode, ValueType.class).getValueType());  
import org.opensearch.painless.node.SIfElse;
                )  
        irClassNode.addFunctionNode(irFunctionNode);  
    public void visitTry(STry userTryNode, ScriptScope scriptScope) {
            irForEachSubIterableNode.setIteratorName("#itr" + userEachNode.getLocation().getOffset());
                ConstantNode irConstantNode = new ConstantNode(location);  
import org.opensearch.painless.ir.DupNode;
                userNewArrayFunctionRefNode.getLocation()
        irFieldNode.setName("$DEFINITION");  
                    LoadDotDefNode irLoadDotDefNode = new LoadDotDefNode(location);  
            irExpressionNode = staticNode;
            );
                }  
            StatementExpressionNode irStatementExpressionNode = new StatementExpressionNode(userRegexNode.getLocation());  
     */
        ExpressionNode irValueNode = injectCast(userAssignmentNode.getRightNode(), scriptScope);
                    ConstantNode irConstantNode = new ConstantNode(userFunctionNode.getLocation());
                            irConstantNode.setConstant(0);
    @Override
import org.opensearch.painless.node.EListInit;
            irFunctionNode.setMaxLoopCounter(0);
    }
        if (painlessCast.boxTargetType != null) {
    @Override
            irBlockNode.addStatementNode((StatementNode) visit(userStatementNode, scriptScope));
                    ? null
    @Override
        scriptScope.putDecoration(userDeclBlockNode, new IRNodeDecoration(irDeclarationBlockNode));
    @Override
        }
import org.opensearch.painless.node.EBrace;
            scriptScope.getDecoration(userNewObjectNode, StandardPainlessConstructor.class).getStandardPainlessConstructor()
            irLoadVariableNode.setName("methodHandlesLookup");
            irClassNode.addFieldNode(irFieldNode);  
                irCompoundNode = irBinaryMathNode;
                    irStoreNode = irStoreDotShortcutNode;
                irCallSubDefNode.addArgumentNode((ExpressionNode) visit(userArgumentNode, scriptScope));
            StoreNode irStoreNode = (StoreNode) visit(userAssignmentNode.getLeftNode(), scriptScope);
            StaticNode staticNode = new StaticNode(internalLocation);
import org.opensearch.painless.symbol.Decorations.SemanticVariable;
            } else {  
import org.opensearch.painless.lookup.PainlessLookupUtility;
                ? scriptScope.getDecoration(userAssignmentNode, DowncastPainlessCast.class).getDowncastPainlessCast()
            FieldNode irFieldNode = new FieldNode(callLocalNode.getLocation());
                    StoreListShortcutNode irStoreListShortcutNode = new StoreListShortcutNode(location);  
import org.opensearch.painless.node.SDeclBlock;  
        boolean compound = scriptScope.getCondition(userBraceNode, Compound.class);
import org.opensearch.painless.ir.LoadFieldMemberNode;
            throw new IllegalStateException(exception);  
import org.opensearch.painless.node.EBinary;
            if (irIndexNode != null) {  
            BlockNode blockNode = new BlockNode(internalLocation);  
        irBlockNode.setAllEscape(true);
                if (write == false || compound) {  
            invokeCallNode.addArgumentNode(irLoadFieldMemberNode);
import org.opensearch.painless.node.EDot;
                boxType = scriptScope.getDecoration(userCallNode.getPrefixNode(), StaticType.class).getStaticType();
            invokeCallNode.addArgumentNode(irLoadVariableNode);
        } else if (scriptScope.hasDecoration(userSymbolNode, ValueType.class)) {
            invokeCallNode.addArgumentNode(irConstantNode);
        }
        ExpressionNode irExpressionNode = injectCast(userExpressionNode.getStatementNode(), scriptScope);  
import java.util.Iterator;
import org.opensearch.painless.Location;
package org.opensearch.painless.phase;
        irReturnNode.setExpressionNode(irNewArrayNode);
import org.opensearch.painless.ir.DeclarationNode;
import java.lang.invoke.MethodType;
        irReferenceNode.setExpressionType(scriptScope.getDecoration(userNewArrayFunctionRefNode, ValueType.class).getValueType());
        scriptScope.putDecoration(userBooleanConstantNode, new IRNodeDecoration(irConstantNode));
                irPrefixNode,
            new IRNodeDecoration(buildLoadStore(2, location, false, irPrefixNode, irIndexNode, irLoadNode, irStoreNode))
        irElvisNode.setRightNode(injectCast(userElvisNode.getRightNode(), scriptScope));
        } else if (scriptScope.hasDecoration(callLocalNode, StandardPainlessClassBinding.class)) {  
    @Override
import org.opensearch.painless.node.EInstanceof;  
        irFieldNode = new FieldNode(internalLocation);
            ExpressionNode irLoadNode = null;
            if (scriptScope.getCondition(userBinaryNode, Explicit.class)) {  
                (int) scriptScope.getDecoration(callLocalNode, StandardConstant.class).getStandardConstant()
    }  
            boolean compound = scriptScope.getCondition(userDotNode, Compound.class);
        for (AExpression userValueNode : userListInitNode.getValueNodes()) {  
        irForLoopNode.setInitialzerNode(visit(userForNode.getInitializerNode(), scriptScope));
                    StoreDotShortcutNode irStoreDotShortcutNode = new StoreDotShortcutNode(location);
                // the value is read from prior to assignment (post-increment)
                }  
        irFieldNode.setName("$FUNCTIONS");
                irLoadListShortcutNode.setGetter(
    }
import org.opensearch.painless.ir.LoadBraceDefNode;
                if (write || compound) {
        irLoadVariableNode.setExpressionType(int.class);  
        irFunctionNode.setStatic(true);
        irInstanceofNode.setInstanceType(scriptScope.getDecoration(userInstanceofNode, InstanceType.class).getInstanceType());  
import org.opensearch.painless.ir.DeclarationBlockNode;
        BlockNode irBlockNode = new BlockNode(userBlockNode.getLocation());
            }
            // this is a compound assignment and the store is the root
                .addAll(Arrays.asList("methodHandlesLookup", "name", "type", "initialDepth", "flavor", "args"));
            boolean concatenate = userAssignmentNode.getOperation() == Operation.ADD && compoundType == String.class;  
                irStoreListShortcutNode.setExpressionType(read ? valueType : void.class);
                    binaryImplNode.setLeftNode(irIndexNode);
            irIndexNode = irFlipDefIndexNode;
        scriptScope.putDecoration(userStringNode, new IRNodeDecoration(irConstantNode));
        }
                if (parameterType != PainlessLookupUtility.typeToUnboxedType(injection.getClass())) {
     * to do the runtime resolution, and several supporting static fields.
import org.opensearch.painless.symbol.Decorations.GetterPainlessMethod;
                        "bootstrap",  
    }
import java.util.Map;  
        irFunctionNode.setSynthetic(true);  
            irForEachSubArrayNode.setArrayType(iterableValueType);
                irStoreNode
            if (write || compound) {
                    StoreMapShortcutNode irStoreMapShortcutNode = new StoreMapShortcutNode(location);
                }
            irStatementExpressionNode.setExpressionNode(irStoreFieldMemberNode);
        }  
            irExpressionNode = binaryImplNode;
        } else {
                    binaryImplNode.setExpressionType(irExpressionNode.getExpressionType());
                    throw new IllegalStateException("illegal tree structure");  
     * This includes injection of ir nodes to add a function to call  
    public void visitDo(SDo userDoNode, ScriptScope scriptScope) {
import org.opensearch.painless.symbol.Decorations.StandardPainlessMethod;  
        ConditionalNode irConditionalNode = new ConditionalNode(userConditionalNode.getLocation());
    public void visitMapInit(EMapInit userMapInitNode, ScriptScope scriptScope) {
import java.lang.invoke.MethodHandles.Lookup;  
        irForLoopNode.setAfterthoughtNode((ExpressionNode) visit(userForNode.getAfterthoughtNode(), scriptScope));  
            }
        } else if (scriptScope.hasDecoration(callLocalNode, StandardPainlessMethod.class)) {
                        scriptScope.getDecoration(userDotNode, GetterPainlessMethod.class).getGetterPainlessMethod()
import org.opensearch.painless.ir.ConditionalNode;
                    irDupNode.setExpressionType(irLoadNode.getExpressionType());
            irDeclarationBlockNode.addDeclarationNode((DeclarationNode) visit(userDeclarationNode, scriptScope));
                            throw userFunctionNode.createError(new IllegalStateException("illegal tree structure"));
            InvokeCallNode irInvokeCallNode = new InvokeCallNode(userCallNode.getLocation());
        irFieldNode.setFieldType(Map.class);
            irLoadVariableNode.setExpressionType(Object[].class);
                irLoadNode = irLoadVariableNode;
        if (capturesDecoration != null) {  
            if (read) {
                    StoreDotDefNode irStoreDotDefNode = new StoreDotDefNode(location);
        irConstantNode.setConstant(scriptScope.getDecoration(userNumericNode, StandardConstant.class).getStandardConstant());
            String bindingName = scriptScope.getNextSyntheticName("instance_binding");  
                irIndexNode = irConstantNode;
            StringConcatenationNode stringConcatenationNode = new StringConcatenationNode(userBinaryNode.getLocation());  
                LoadDotArrayLengthNode irLoadDotArrayLengthNode = new LoadDotArrayLengthNode(location);  
/*  
            ValueType prefixValueType = scriptScope.getDecoration(userDotNode.getPrefixNode(), ValueType.class);  
    public void visitAssignment(EAssignment userAssignmentNode, ScriptScope scriptScope) {  
 * ownership. Elasticsearch licenses this file to you under  
import java.lang.reflect.Modifier;
        irForLoopNode.setContinuous(scriptScope.getCondition(userForNode, ContinuousLoop.class));
        }
            scriptScope.putDecoration(userSymbolNode, new AccessDepth(0));
import org.opensearch.painless.node.EElvis;  
                    ),
    @Override
        irFunctionNode.addTypeParameter(int.class);
            StaticNode irStaticNode = new StaticNode(userRegexNode.getLocation());  
    public void visitElvis(EElvis userElvisNode, ScriptScope scriptScope) {  
            irStaticNode.setExpressionType(Pattern.class);
                irCompoundNode = stringConcatenationNode;
                BinaryImplNode binaryImplNode = new BinaryImplNode(location);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            irLoadVariableNode = new LoadVariableNode(internalLocation);  
import org.opensearch.painless.ir.InvokeCallDefNode;  
import org.opensearch.painless.ir.LoadListShortcutNode;
                        MethodType.class,  
        irFunctionNode.setReturnType(returnType);
                    irStoreDotNode.setField(painlessField);  
    }
                binaryImplNode.setRightNode(irExpressionNode);
        irBooleanNode.setExpressionType(scriptScope.getDecoration(userBooleanCompNode, ValueType.class).getValueType());
            scriptScope.addStaticConstant(bindingName, painlessInstanceBinding.targetInstance);
        Class<?> iterableValueType = scriptScope.getDecoration(userEachNode.getIterableNode(), ValueType.class).getValueType();
                        Lookup.class,
            scriptScope.getDecoration(userMapInitNode, StandardPainlessConstructor.class).getStandardPainlessConstructor()
            : null;
        }  
import org.objectweb.asm.Opcodes;  
                irStoreListShortcutNode.setSetter(
import org.opensearch.painless.node.EFunctionRef;
                );  
    public void visitCall(ECall userCallNode, ScriptScope scriptScope) {
                irLoadDotArrayLengthNode.setExpressionType(int.class);
                new PainlessMethod(
            blockNode.addStatementNode(returnNode);
        IRNode irNode;
import org.opensearch.painless.ir.FlipCollectionIndexNode;
            Class<?> shiftType = scriptScope.hasDecoration(userBinaryNode, ShiftType.class)
        irTryNode.setBlockNode((BlockNode) visit(userTryNode.getBlockNode(), scriptScope));
        }
    /**
        ExpressionNode irExpressionNode = irLoadNode != null ? irLoadNode : irStoreNode;
            irExpressionNode = irNullSafeSubNode;  
     * the compound assignment.
import org.opensearch.painless.symbol.FunctionTable;
        return irExpressionNode;
            irExpressionNode = irCallSubDefNode;  
                    irStoreNode = irStoreDotDefNode;
     * stub out the appropriate load and store ir nodes.  
            irUnaryMathNode.setChildNode(injectCast(userUnaryNode.getChildNode(), scriptScope));  
import org.opensearch.painless.node.ECall;  
        ForEachLoopNode irForEachLoopNode = new ForEachLoopNode(userEachNode.getLocation());
        }  
        Class<?> compoundType = scriptScope.hasDecoration(userAssignmentNode, CompoundType.class)
                        String.class,
        FunctionNode irFunctionNode = new FunctionNode(userLambdaNode.getLocation());
            for (AExpression userCallArgumentNode : userCallNode.getArgumentNodes()) {  
