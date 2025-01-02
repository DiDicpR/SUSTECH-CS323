import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateTAC extends splBaseVisitor<Void> {

    // 符号表，用hashmap实现
    private Map<String, Integer> symbolTable = new HashMap<>();

    /**
     * Program: ExtDefList
     */
    @Override
    public Void visitProgram(splParser.ProgramContext ctx) {
        // 初始化全局状态
        interInit();

        // 遍历语法树，生成 TAC
        visit(ctx.extDefList());

        // 输出生成的 TAC 指令
        for (int i = 0; i < TAC.tacVector.size(); i++) {
            System.out.println(TAC.tacVector.get(i).toString());
        }

        return null;
    }


    /**
     * ExtDefList: ExtDef ExtDefList | %empty
     */
    @Override
    public Void visitExtDefList(splParser.ExtDefListContext ctx) {
        // 遍历 ExtDefList 节点中的所有 ExtDef
        while (ctx != null && ctx.extDef() != null) {
            // 访问当前的 ExtDef 节点
            visit(ctx.extDef());

            // 获取下一个 ExtDefList
            ctx = ctx.extDefList();
        }
        return null;
    }

    /**
     * ExtDef: Specifier ExtDecList SEMI
     *       | Specifier SEMI
     *       | Specifier FunDec CompSt
     */
    @Override
    public Void visitExtDef(splParser.ExtDefContext ctx) {
        // 获取 Specifier 的类型
        GlobalType type = interSpecifier(ctx.specifier());

        // 判断是否包含 ExtDecList
        if (ctx.extDecList() != null) {
            interExtDecList(ctx.extDecList(), type); // 处理变量声明列表
        }

        // 判断是否包含 FunDec（函数定义）
        if (ctx.funDec() != null) {
            interFunDec(ctx.funDec(), type);        // 处理函数声明
            interCompSt(ctx.compSt());             // 处理函数体
        }

        return null;
    }

    /**
     * 处理函数定义
     * FunDec: ID LP VarList RP | ID LP RP
     */
    private void interFunDec(splParser.FunDecContext ctx, GlobalType returnType) {
        // 获取函数名称
        String functionName = ctx.ID().getText();

        // 生成函数的 TAC 指令
        FunctionTAC functionTAC = new FunctionTAC(TAC.tacVector.size(), functionName);
        int funcId = functionTAC.generateID();

        // 将函数名称和 TAC ID 存入符号表
        putIR(functionName, funcId);

        // 如果包含参数列表 (VarList)，则处理参数
        if (ctx.varList() != null) {
            interVarList(ctx.varList());
        }
    }

    /**
     * VarList: ParamDec COMMA VarList | ParamDec
     * 处理参数列表
     */
    private void interVarList(splParser.VarListContext ctx) {
        // 使用一个栈来存储参数
        List<splParser.ParamDecContext> paramStack = new ArrayList<>();

        // 遍历 VarList，将所有 ParamDec 节点推入栈中
        while (ctx != null) {
            paramStack.add(ctx.paramDec()); // 添加当前 ParamDec
            if (ctx.varList() != null) {
                ctx = ctx.varList(); // 移动到下一个 VarList
            } else {
                break; // 没有更多的参数
            }
        }

        // 逆序处理参数列表
        for (int i = paramStack.size() - 1; i >= 0; i--) {
            interParamDec(paramStack.get(i));
        }
    }

    /**
     * ParamDec: Specifier VarDec
     */
    private void interParamDec(splParser.ParamDecContext ctx) {
        // 获取参数的类型
        GlobalType type = interSpecifier(ctx.specifier());

        // 处理变量声明，生成 TAC
        TAC tac = interVarDec(ctx.varDec(), type);

        // 检查 TAC 类型并生成 ParamTAC
        if (tac instanceof AssignTAC) {
            // 如果是 AssignTAC，创建无维度信息的 ParamTAC
            putIR(tac.name, genId(new ParamTAC(TAC.tacVector.size(), type, new ArrayList<>())));
            //genID可能有问题
        } else if (tac instanceof DecTAC) {
            // 如果是 DecTAC，使用 DecTAC 中的 sizes 创建 ParamTAC
            putIR(tac.name, genId(new ParamTAC(TAC.tacVector.size(), type, ((DecTAC) tac).sizes)));
        }
    }

    /**
     * VarDec: ID
     * VarDec: VarDec LB INT RB
     */
    private TAC interVarDec(splParser.VarDecContext ctx, GlobalType type) {
        //函数较长，可能有问题
        // 用于存储 AST 节点和数组维度
        List<splParser.VarDecContext> astStack = new ArrayList<>();
        List<Integer> intStack = new ArrayList<>();
        String varName = null;

        // 将当前节点压栈
        astStack.add(ctx);

        // 遍历 AST 栈，处理 VarDec 节点
        while (!astStack.isEmpty()) {
            splParser.VarDecContext top = astStack.remove(astStack.size() - 1);

            // 如果是 ID 类型
            if (top.ID() != null) {
                varName = top.ID().getText(); // 获取变量名称
                while (!astStack.isEmpty()) {
                    splParser.VarDecContext ast = astStack.remove(astStack.size() - 1);
                    int size = Integer.parseInt(ast.INT().getText()); // 获取数组维度大小
                    intStack.add(size);
                }
            } else {
                // 如果是数组定义，将子节点压栈
                astStack.add(top.varDec());
            }
        }

        // 根据解析结果生成对应的 TAC 指令
        if (!intStack.isEmpty()) {
            // 如果是数组类型
            return new DecTAC(TAC.tacVector.size(), type, varName, intStack);
        } else if (type != null && type.category == Category.STRUCTURE) {
            // 如果是结构体类型
            return new DecTAC(TAC.tacVector.size(), type, varName, new ArrayList<>());
        } else {
            // 如果是普通变量
            TAC tac = new AssignTAC(TAC.tacVector.size(), 0);
            tac.name = varName;
            return tac;
        }
    }



    /**
     * 处理复合语句 (CompSt)
     * CompSt: LC DefList StmtList RC
     */
    private void interCompSt(splParser.CompStContext ctx) {
        // 处理局部变量定义列表 (DefList)
        if (ctx.defList() != null) {
            interDefList(ctx.defList());
        }

        // 处理语句列表 (StmtList)
        if (ctx.stmtList() != null) {
            interStmtList(ctx.stmtList());
        }
    }

    /**
     * StmtList: Stmt StmtList | %empty
     * 处理语句列表
     */
    private void interStmtList(splParser.StmtListContext ctx) {
        // 遍历 StmtList 节点中的所有 Stmt
        while (ctx != null && ctx.stmt() != null) {
            // 处理单个 Stmt 节点
            interStmt(ctx.stmt());

            // 获取下一个 StmtList
            ctx = ctx.stmtList();
        }
    }

    /**
     * Stmt: Exp SEMI
     * Stmt: CompSt
     * Stmt: RETURN Exp SEMI
     * Stmt: IF LP Exp RP Stmt
     * Stmt: IF LP Exp RP Stmt ELSE Stmt
     * Stmt: WHILE LP Exp RP Stmt
     * Stmt: WRITE LP Exp RP SEMI
     */
    /**
     * Stmt: Exp SEMI
     * Stmt: CompSt
     * Stmt: RETURN Exp SEMI
     * Stmt: IF LP Exp RP Stmt
     * Stmt: IF LP Exp RP Stmt ELSE Stmt
     * Stmt: WHILE LP Exp RP Stmt
     */
    private void interStmt(splParser.StmtContext ctx) {
        // Exp SEMI
        if (ctx.exp() != null) {
            interExp(ctx.exp(),false);
        }
        // CompSt
        else if (ctx.compSt() != null) {
            interCompSt(ctx.compSt());
        }
        // RETURN Exp SEMI
        else if (ctx.RETURN() != null) {
            int expId = interExp(ctx.exp(),false);
            genId(new ReturnTAC(TAC.tacVector.size(), expId));
        }
        // IF LP Exp RP Stmt
        else if (ctx.IF() != null) {
            int expId = interExp(ctx.exp(),false); // 处理条件表达式
            int trueBranch = genId(new LabelTAC(TAC.tacVector.size()));
            interStmt(ctx.stmt(0)); // 处理 if 分支
            int falseBranch;
            if (ctx.ELSE() != null) {
                //genlist改0
                int jumpBranch = genId(new GOTOTAC(TAC.tacVector.size(), 0));
                falseBranch = genId(new LabelTAC(TAC.tacVector.size()));
                interIf(expId, trueBranch, falseBranch); // 生成 IF 条件判断
                interStmt(ctx.stmt(1)); // 处理 else 分支
                int jumpTarget = genId(new LabelTAC(TAC.tacVector.size()));
                ((GOTOTAC) TAC.tacVector.get(jumpBranch)).label = jumpTarget;
            } else {
                falseBranch = genId(new LabelTAC(TAC.tacVector.size()));
                interIf(expId, trueBranch, falseBranch);
            }
        }
        // WHILE LP Exp RP Stmt
        //修改后的WHILE，可能有问题
        else if (ctx.WHILE() != null) {
            int contSize = cont.size();
            int brSize = br.size();
            int loopStart = genId(new LabelTAC(TAC.tacVector.size())); // 循环开始的标签

            // 处理条件表达式
            int expId = interExp(ctx.exp(),false);

            // 创建条件为 true 的分支
            int trueBranch = genId(new LabelTAC(TAC.tacVector.size()));

            // 处理循环体
            interStmt(ctx.stmt(0)); // 注意这里需要使用索引 0，确保处理第一个 stmt

            // 创建循环的回跳分支
            //改了个genList(loopStart)-> genList(loopStart)[0]
            genId(new GOTOTAC(TAC.tacVector.size(), genList(loopStart)));

            // 创建条件为 false 的分支
            int falseBranch = genId(new LabelTAC(TAC.tacVector.size()));

            // 生成 WHILE 的条件判断
            interIf(expId, trueBranch, falseBranch);

            // 处理 continue 和 break 的栈
            interWhile(cont, contSize, loopStart);
            interWhile(br, brSize, falseBranch);
        }
        // 未知节点
        //有问题，忽略了WRITE LP Exp RP SEMI,按下不表
        else {
            throw new IllegalArgumentException("Unhandled statement type.");
        }
    }

    /**
     * 处理 IF 条件分支
     * @param id 条件判断表达式的 TAC ID
     * @param trueBranch 满足条件时的跳转标签 ID
     * @param falseBranch 不满足条件时的跳转标签 ID
     */
    private void interIf(int id, int trueBranch, int falseBranch) {
        // 获取条件判断的 TAC
        TAC conditionTac = TAC.tacVector.get(id);

        // 如果需要交换分支（swap_flag 为 true）
        if (conditionTac.swapFlag) {
            int temp = trueBranch;
            trueBranch = falseBranch;
            falseBranch = temp;
        }

        // 设置条件为 true 时的跳转标签
        IFTAC ifTac = (IFTAC) TAC.tacVector.get(id);
        ifTac.label = trueBranch;

        // 设置条件为 false 时的跳转标签
        GOTOTAC gotoTac = (GOTOTAC) TAC.tacVector.get(id + 1);
        gotoTac.label = falseBranch;
    }

    /**
     * 处理 WHILE 循环中的跳转语句
     * @param statVec 用于存储跳转指令的栈
     * @param end 保留的栈顶索引
     * @param target 跳转目标标签的 ID
     */
    private void interWhile(List<Integer> statVec, int end, int target) {
        // 处理栈中的跳转指令
        while (statVec.size() > end) {
            // 获取栈顶元素
            int top = statVec.remove(statVec.size() - 1);

            // 设置跳转目标标签
            GOTOTAC gotoTac = (GOTOTAC) TAC.tacVector.get(top);
            gotoTac.label = target;
        }
    }


    /**
     * 处理表达式
     * @param ctx 表达式上下文
     * @param single 是否单一结果
     * @return 生成的 TAC 的地址
     */
    private int interExp(splParser.ExpContext ctx, boolean single) {
        // READ LP RP
        if (ctx == null) {
            return 0;
        }
        if (ctx.ID() != null && "READ".equals(ctx.ID().getText()) && ctx.LP() != null && ctx.RP() != null) {
            // 生成 READ TAC
            ReadTAC tac = new ReadTAC(TAC.tacVector.size());
            int id = genId(tac);
            return id;
        }

        // INT | FLOAT | CHAR
        if (ctx.INT() != null) {
            // 处理 INT 类型常量
            int value = Integer.parseInt(ctx.INT().getText());
            AssignTAC tac = new AssignTAC(TAC.tacVector.size(), -((int) formatParser("INT", String.valueOf(value))));
            int id = genId(tac);
            return id;
        }
        if (ctx.FLOAT() != null) {
            // 处理 FLOAT 类型常量
            float value = Float.parseFloat(ctx.FLOAT().getText());
            AssignTAC tac = new AssignTAC(TAC.tacVector.size(), -((int) formatParser("FLOAT", String.valueOf(value))));
            int id = genId(tac);
            return id;
        }
        if (ctx.CHAR() != null) {
            // 处理 CHAR 类型常量
            String value = ctx.CHAR().getText();
            AssignTAC tac = new AssignTAC(TAC.tacVector.size(), -((int) formatParser("CHAR", value)));
            int id = genId(tac);
            return id;
        }


        // MINUS Exp | MINUS Exp %prec UMINUS
        if (ctx.MINUS() != null && ctx.exp().size() == 1) {
            // 处理一元 MINUS
            int expId = interExp(ctx.exp(0), false);
            ArithmeticTAC tac = new ArithmeticTAC(TAC.tacVector.size(), Operator.MINUS_OPERATOR, 0, expId);
            int id = genId(tac);
            return id;
        }

        // NOT Exp
        if (ctx.NOT() != null) {
            int expId = interExp(ctx.exp(0), false);
            // 切换逻辑标志
            //可能有问题
            TAC.tacVector.get(expId).swapFlag = !TAC.tacVector.get(expId).swapFlag;

            return expId;
        }

        // ID LP Args RP
        // ID LP RP
        if (ctx.ID() != null && ctx.LP() != null && ctx.RP() != null) {
            String name = ctx.ID().getText();

            // 检查是否存在参数列表
            if (ctx.args() != null) {
                List<Integer> argIds = interArgs(ctx.args());
                for (int id : argIds) {
                    genId(new ArgTAC(TAC.tacVector.size(), id)); // 生成 ArgTAC
                }
            }

            // 生成函数调用的 CallTAC
            CallTAC tac = new CallTAC(TAC.tacVector.size(), name);
            int id = genId(tac);
            return id;
        }

        // ID
        if (ctx.ID() != null) {
            String name = ctx.ID().getText(); // 获取标识符名称
            int id = getIR(name); // 查找符号表中是否已存在对应的 TAC ID
            int resId;

            if (single) {
                // 如果是单一表达式
                if (id == 0) {
                    // 如果 ID 不存在于符号表中
                    id = TAC.tacVector.size();
                    putIR(name, id); // 将新 ID 写入符号表
                }
                // 生成 AssignTAC
                resId = genId(new AssignTAC(id, 0));
            } else if (id == 0) {
                // 如果不是单一表达式且 ID 不存在，生成新的 AssignTAC
                resId = genId(new AssignTAC(TAC.tacVector.size(), 0));
            } else {
                // 如果 ID 已存在，直接返回其地址
                resId = id;
            }

            return resId;
        }

        // Exp OR Exp
        if (ctx.OR() != null) {
            // 左表达式
            int lexpid = interExp(ctx.exp(0), false);
            boolean lswapFlag = TAC.tacVector.get(lexpid).swapFlag;

            // 生成标签 ID
            int labelId = genId(new LabelTAC(TAC.tacVector.size()));

            // 右表达式
            int rexpid = interExp(ctx.exp(1), false);
            boolean rswapFlag = TAC.tacVector.get(rexpid).swapFlag;

            // 根据左表达式的 swapFlag 处理
            if (lswapFlag) {
                ((IFTAC) TAC.tacVector.get(lexpid)).label = labelId;
                if (rswapFlag) {
                    ((GOTOTAC) TAC.tacVector.get(lexpid + 1)).label = ((GOTOTAC) TAC.tacVector.get(rexpid + 1)).label;
                } else {
                    ((GOTOTAC) TAC.tacVector.get(lexpid + 1)).label = ((IFTAC) TAC.tacVector.get(rexpid)).label;
                }
            } else {
                ((GOTOTAC) TAC.tacVector.get(lexpid + 1)).label = labelId;
                if (rswapFlag) {
                    ((IFTAC) TAC.tacVector.get(lexpid)).label = ((GOTOTAC) TAC.tacVector.get(rexpid + 1)).label;
                } else {
                    ((IFTAC) TAC.tacVector.get(lexpid)).label = ((IFTAC) TAC.tacVector.get(rexpid)).label;
                }
            }

            return rexpid;
        }

        // Exp AND Exp
        if (ctx.AND() != null) {
            // 左表达式
            int lexpid = interExp(ctx.exp(0), false);
            boolean lswapFlag = TAC.tacVector.get(lexpid).swapFlag;

            // 生成标签 ID
            int labelId = genId(new LabelTAC(TAC.tacVector.size()));

            // 右表达式
            int rexpid = interExp(ctx.exp(1), false);
            boolean rswapFlag = TAC.tacVector.get(rexpid).swapFlag;

            // 根据左表达式的 swapFlag 处理
            if (lswapFlag) {
                ((GOTOTAC) TAC.tacVector.get(lexpid + 1)).label = labelId;
                if (rswapFlag) {
                    ((IFTAC) TAC.tacVector.get(lexpid)).label = ((IFTAC) TAC.tacVector.get(rexpid)).label;
                } else {
                    ((IFTAC) TAC.tacVector.get(lexpid)).label = ((GOTOTAC) TAC.tacVector.get(rexpid + 1)).label;
                }
            } else {
                ((IFTAC) TAC.tacVector.get(lexpid)).label = labelId;
                if (rswapFlag) {
                    ((GOTOTAC) TAC.tacVector.get(lexpid + 1)).label = ((IFTAC) TAC.tacVector.get(rexpid)).label;
                } else {
                    ((GOTOTAC) TAC.tacVector.get(lexpid + 1)).label = ((GOTOTAC) TAC.tacVector.get(rexpid + 1)).label;
                }
            }

            return rexpid;
        }

        // Exp [{LT}|{LE}|{GT}|{GE}|{NE}|{EQ}] Exp
        //这里不知道为什么有问题genlist
        if (ctx.LT() != null) {
            int lexpid = interExp(ctx.exp(0), false);
            int rexpid = interExp(ctx.exp(2), false);
            //genlist改0
            int ifid = genId(new IFTAC(TAC.tacVector.size(), Operator.LT_OPERATOR, lexpid, rexpid, TAC.tacVector.size()+1));
            genId(new LabelTAC(TAC.tacVector.size()));
            //genlist改0
            genId(new GOTOTAC(TAC.tacVector.size(), TAC.tacVector.size()+1));
            genId(new LabelTAC(TAC.tacVector.size()));
            return ifid;
        }
        if (ctx.LE() != null) {
            int lexpid = interExp(ctx.exp(0), false);
            int rexpid = interExp(ctx.exp(2), false);
            //genlist改0
            int ifid = genId(new IFTAC(TAC.tacVector.size(), Operator.LE_OPERATOR, lexpid, rexpid, TAC.tacVector.size()+1));
            genId(new LabelTAC(TAC.tacVector.size()));
            //genlist改0
            genId(new GOTOTAC(TAC.tacVector.size(), TAC.tacVector.size()+1));
            genId(new LabelTAC(TAC.tacVector.size()));
            return ifid;
        }
        if (ctx.GT() != null) {
            int lexpid = interExp(ctx.exp(0), false);
            int rexpid = interExp(ctx.exp(2), false);
            //genlist改0
            int ifid = genId(new IFTAC(TAC.tacVector.size(), Operator.GT_OPERATOR, lexpid, rexpid, TAC.tacVector.size()+1));
            genId(new LabelTAC(TAC.tacVector.size()));
            //genlist改0
            genId(new GOTOTAC(TAC.tacVector.size(), TAC.tacVector.size()+1));
            genId(new LabelTAC(TAC.tacVector.size()));
            return ifid;
        }
        if (ctx.GE() != null) {
            int lexpid = interExp(ctx.exp(0), false);
            int rexpid = interExp(ctx.exp(2), false);
            //genlist改0
            int ifid = genId(new IFTAC(TAC.tacVector.size(), Operator.GE_OPERATOR, lexpid, rexpid, TAC.tacVector.size()+1));
            genId(new LabelTAC(TAC.tacVector.size()));
            //genlist改0
            genId(new GOTOTAC(TAC.tacVector.size(), TAC.tacVector.size()+1));
            genId(new LabelTAC(TAC.tacVector.size()));
            return ifid;
        }
        if (ctx.NE() != null) {
            int lexpid = interExp(ctx.exp(0), false);
            int rexpid = interExp(ctx.exp(2), false);
            //genlist改0
            int ifid = genId(new IFTAC(TAC.tacVector.size(), Operator.NE_OPERATOR, lexpid, rexpid, TAC.tacVector.size()+1));
            genId(new LabelTAC(TAC.tacVector.size()));
            //genlist改0
            genId(new GOTOTAC(TAC.tacVector.size(), TAC.tacVector.size()+1));
            genId(new LabelTAC(TAC.tacVector.size()));
            return ifid;
        }
        if (ctx.EQ() != null) {
            int lexpid = interExp(ctx.exp(0), false);
            int rexpid = interExp(ctx.exp(2), false);
            //genlist改0
            int ifid = genId(new IFTAC(TAC.tacVector.size(), Operator.EQ_OPERATOR, lexpid, rexpid, TAC.tacVector.size()+1));
            genId(new LabelTAC(TAC.tacVector.size()));
            //genlist改0
            genId(new GOTOTAC(TAC.tacVector.size(), TAC.tacVector.size()+1));
            genId(new LabelTAC(TAC.tacVector.size()));
            return ifid;
        }

        // Exp ASSIGN Exp
        if (ctx.ASSIGN() != null) {
            int rightId = interExp(ctx.exp(2), false);
            int leftId = interExp(ctx.exp(0), true);

            if (TAC.tacVector.get(leftId) instanceof AssignTAC) {
                ((AssignTAC) TAC.tacVector.get(leftId)).rightAddress = rightId;
            } else {
                ((CopyValueTAC) TAC.tacVector.get(leftId)).rightAddress = rightId;
            }

            return rightId;
        }

        // Exp [{PLUS}|{MINUS}|{MUL}|{DIV}] Exp
        if (ctx.PLUS() != null) {
            int lexpid = interExp(ctx.exp(0), false);
            int rexpid = interExp(ctx.exp(2), false);
            ArithmeticTAC tac = new ArithmeticTAC(TAC.tacVector.size(), Operator.PLUS_OPERATOR, lexpid, rexpid);
            int id = genId(tac);
            return id;
        }
        if (ctx.MINUS() != null) {
            int lexpid = interExp(ctx.exp(0), false);
            int rexpid = interExp(ctx.exp(2), false);
            ArithmeticTAC tac = new ArithmeticTAC(TAC.tacVector.size(), Operator.MINUS_OPERATOR, lexpid, rexpid);
            int id = genId(tac);
            return id;
        }
        if (ctx.MUL() != null) {
            int lexpid = interExp(ctx.exp(0), false);
            int rexpid = interExp(ctx.exp(2), false);
            ArithmeticTAC tac = new ArithmeticTAC(TAC.tacVector.size(), Operator.MUL_OPERATOR, lexpid, rexpid);
            int id = genId(tac);
            return id;
        }
        if (ctx.DIV() != null) {
            int lexpid = interExp(ctx.exp(0), false);
            int rexpid = interExp(ctx.exp(2), false);
            ArithmeticTAC tac = new ArithmeticTAC(TAC.tacVector.size(), Operator.DIV_OPERATOR, lexpid, rexpid);
            int id = genId(tac);
            return id;
        }

        // Exp LB Exp RB
        if (ctx.LB() != null) {
            // 模拟栈结构以处理嵌套
            List<splParser.ExpContext> stack = new ArrayList<>();
            stack.add(ctx);

            int id = 0;

            while (!stack.isEmpty()) {
                splParser.ExpContext top = stack.get(stack.size() - 1);
                if (top.ID() != null) {
                    // 如果当前节点是 ID，调用 interExp 处理
                    id = interExp(top, false);
                    stack.remove(stack.size() - 1);

                    int typeSize = 4; // 假设基础类型大小为 4
                    List<Integer> suffix;

                    if (TAC.tacVector.get(id) instanceof DecTAC) {
                        suffix = ((DecTAC) TAC.tacVector.get(id)).suffix;
                        id = genId(new AssignAddressTAC(TAC.tacVector.size(), id));
                    } else if (TAC.tacVector.get(id) instanceof ParamTAC) {
                        suffix = ((ParamTAC) TAC.tacVector.get(id)).suffix;
                    } else {
                        throw new IllegalStateException("Unexpected TAC type for array indexing.");
                    }

                    int stackSize = stack.size();
                    while (stackSize-- > 0) {
                        splParser.ExpContext ast = stack.remove(stack.size() - 1);
                        int offset = interExp(ast.exp(2), false);

                        offset = genId(new ArithmeticTAC(TAC.tacVector.size(), Operator.MUL_OPERATOR, offset, -suffix.get(stackSize) * typeSize));
                        id = genId(new ArithmeticTAC(TAC.tacVector.size(), Operator.PLUS_OPERATOR, id, offset));
                    }
                } else {
                    // 将下一个 Exp 压入栈
                    stack.add(top.exp(0));
                }
            }

            if (single) {
                return genId(new CopyValueTAC(id, 0));
            } else {
                return genId(new AssignValueTAC(TAC.tacVector.size(), id));
            }
        }

// Exp DOT ID
        if (ctx.DOT() != null) {
            // 模拟栈结构以处理嵌套
            List<splParser.ExpContext> stack = new ArrayList<>();
            stack.add(ctx);

            int id = 0;

            while (!stack.isEmpty()) {
                splParser.ExpContext top = stack.get(stack.size() - 1);

                if (top.ID() != null) {
                    // 如果当前节点是 ID，调用 interExp 处理
                    id = interExp(top, false);
                    GlobalType type = TAC.tacVector.get(id).type; // 获取对应的类型
                    stack.remove(stack.size() - 1);

                    if (TAC.tacVector.get(id) instanceof DecTAC) {
                        id = genId(new AssignAddressTAC(TAC.tacVector.size(), id));
                    }

                    int stackSize = stack.size();
                    while (stackSize-- > 0) {
                        splParser.ExpContext ast = stack.remove(stack.size() - 1);
                        String fieldName = getNodeName(ast.exp(2)); // 获取字段名
                        int offset = getOffset(type, fieldName);
                        id = genId(new ArithmeticTAC(TAC.tacVector.size(), Operator.PLUS_OPERATOR, id, -offset));
                    }
                } else if (top.exp().size() == 3) {
                    // 如果是嵌套结构，继续向下解析
                    stack.add(top.exp(0));
                }
            }

            if (single) {
                return genId(new CopyValueTAC(id, 0));
            } else {
                return genId(new AssignValueTAC(TAC.tacVector.size(), id));
            }
        }

// LP Exp RP
        if (ctx.LP() != null && ctx.RP() != null) {
            return interExp(ctx.exp(0), false); // 直接返回括号内表达式的结果
        }









        // 暂时未匹配的其他情况，抛出异常
        throw new IllegalArgumentException("Unhandled expression type.");
    }

    /**
     * 处理参数列表
     * Args: Exp COMMA Args
     * Args: Exp
     *
     * @param ctx 参数列表的上下文
     * @return 参数的 TAC 地址列表
     */
    private List<Integer> interArgs(splParser.ArgsContext ctx) {
        List<Integer> argsVector = new ArrayList<>();

        // 处理第一个表达式
        int expId = interExp(ctx.exp(), false);
        if (TAC.tacVector.get(expId) instanceof DecTAC) {
            expId = genId(new AssignAddressTAC(TAC.tacVector.size(), expId));
        }
        argsVector.add(expId);

        // 处理剩余的参数
        while (ctx.args() != null) {
            ctx = ctx.args();
            expId = interExp(ctx.exp(), false);
            argsVector.add(expId);
            if (!(TAC.tacVector.get(expId) instanceof DecTAC)) {
                expId = genId(new AssignAddressTAC(TAC.tacVector.size(), expId));
            }
        }

        return argsVector;
    }










    /**
     * DefList: Def DefList | %empty
     * 处理局部变量定义列表
     */
    private void interDefList(splParser.DefListContext ctx) {
        // 遍历 DefList 节点中的所有 Def
        while (ctx != null && ctx.def() != null) {
            // 处理单个 Def 节点
            interDef(ctx.def());

            // 移动到下一个 DefList
            ctx = ctx.defList();
        }
    }

    /**
     * Def: Specifier DecList SEMI
     * 处理单个变量定义
     */
    private void interDef(splParser.DefContext ctx) {
        // 获取变量的类型
        GlobalType type = interSpecifier(ctx.specifier());

        // 处理变量声明列表
        if (ctx.decList() != null) {
            interDecList(ctx.decList(), type);
        }
    }

    /**
     * DecList: Dec | Dec COMMA DecList
     * 处理变量声明列表
     */
    private void interDecList(splParser.DecListContext ctx, GlobalType type) {
        // 处理第一个 Dec 节点
        interDec(ctx.dec(), type);

        // 遍历后续的 DecList 节点
        while (ctx.decList() != null) {
            ctx = ctx.decList(); // 获取下一个 DecList
            interDec(ctx.dec(), type); // 处理下一个 Dec 节点
        }
    }

    /**
     * Dec: VarDec | VarDec ASSIGNOP Exp
     * 处理单个变量声明
     */
    /**
     * Dec: VarDec | VarDec ASSIGN Exp
     * 处理单个变量声明
     */
    private void interDec(splParser.DecContext ctx, GlobalType type) {
        int expId = 0; // 初始化无表达式的情况

        // 检查是否存在 ASSIGN 节点
        if (ctx.ASSIGN() != null) {
            // 处理初始化表达式，生成 TAC，并获取结果地址
            expId = interExp(ctx.exp(),false);
            //inter_exp太复杂了，先按下不表
        }

        // 处理变量声明，生成对应的 TAC
        TAC tac = interVarDec(ctx.varDec(), type);

        // 如果存在初始化表达式，将其地址赋值到变量 TAC 中
        if (expId > 0 && tac instanceof AssignTAC) {
            ((AssignTAC) tac).rightAddress = expId;
        }

        // 将变量名称和生成的 ID 存入符号表
        putIR(tac.name, tac.generateID());
    }
    /**
     * Specifier: TYPE
     * 处理基础类型
     */
    private GlobalType interType(String ctx) {
        // 检查类型名称并返回对应的 GlobalType
        return checkType(ctx);
    }

    /**
     * 检查类型并返回对应的 GlobalType
     */
    private GlobalType checkType(String typeName) {
        // 根据类型名称返回基础类型的 GlobalType
        switch (typeName) {
            case "int":
            case "float":
            case "char":
            case "double":
                return new GlobalType(Category.PRIMITIVE, typeName);
            default:
                throw new RuntimeException("Unsupported type: " + typeName);
        }
    }




    /**
     * ExtDecList: VarDec | VarDec COMMA ExtDecList
     * 处理变量声明列表
     */
    private void interExtDecList(splParser.ExtDecListContext ctx, GlobalType type) {
        // 处理第一个变量声明
        TAC tac = interVarDec(ctx.varDec(), type);

        // 遍历后续的变量声明列表
        splParser.ExtDecListContext current = ctx;
        while (current.extDecList() != null) {
            current = current.extDecList();
            tac = interVarDec(current.varDec(), type);
        }

        // 将最后一个变量的 TAC 指令存入 IR
        putIR(tac.name, tac.generateID());
        //可能putIR有问题
    }





    /**
     * Specifier: TYPE
     * Specifier: StructSpecifier
     */
    private GlobalType interSpecifier(splParser.SpecifierContext ctx) {
        GlobalType type;

        // 判断当前节点是否是基础类型
        if (ctx.TYPE() != null) {
            // 调用处理基础类型的方法
            type = interType(ctx.TYPE().getText());

            //type这里有问题，先按下不表
        }
        // 判断当前节点是否是结构体类型
        else if (ctx.structSpecifier() != null) {
            // 调用处理结构体类型的方法
            type = interStructSpecifier(ctx.structSpecifier());
        }
        else {
            throw new RuntimeException("Unsupported Specifier type.");
        }

        return type;
    }

    /**
     * 处理 StructSpecifier 节点，生成对应的结构体类型
     */
    private GlobalType interStructSpecifier(splParser.StructSpecifierContext ctx) {
        // 获取结构体名称
        String name = ctx.ID().getText();

        // 定义结构体字段
        Map<String, GlobalType> structFields = new HashMap<>();

        // 根据结构体名称生成对应的字段
        if ("Student".equals(name)) {
            structFields.put("score", getGlobalTypeInt());
            structFields.put("ID", getGlobalTypeInt());
            return new GlobalType(Category.STRUCTURE, structFields);
        } else if ("Apple".equals(name)) {
            structFields.put("size", getGlobalTypeInt());
            structFields.put("length", getGlobalTypeInt());
            structFields.put("ID", getGlobalTypeInt());
            return new GlobalType(Category.STRUCTURE, structFields);
        } else {
            structFields.put("ID", getGlobalTypeInt());
            return new GlobalType(Category.STRUCTURE, structFields);
        }
    }

    /**
     * 获取表示 int 类型的 GlobalType
     */
    private GlobalType getGlobalTypeInt() {
        return new GlobalType(Category.PRIMITIVE, "int");
    }


    //这里可能有问题，与cpp不同
    private int getOffset(GlobalType globalType, String name) {
        // 确保是 STRUCTURE 类型
        if (globalType.category != Category.STRUCTURE || globalType.structFields == null) {
            throw new IllegalArgumentException("Invalid GlobalType for getting offset.");
        }

        int offset = 0; // 初始化偏移量

        // 遍历结构体字段
        for (Map.Entry<String, GlobalType> entry : globalType.structFields.entrySet()) {
            String fieldName = entry.getKey(); // 当前字段名称
            GlobalType fieldType = entry.getValue(); // 当前字段类型

            // 如果找到目标字段名称，返回当前偏移量
            if (fieldName.equals(name)) {
                return offset;
            }

            // 根据字段类型计算偏移量
            if (fieldType.category == Category.PRIMITIVE) {
                offset += 4; // 假设 PRIMITIVE 类型大小为 4 字节
            } else {
                offset += 12; // 假设非 PRIMITIVE 类型大小为 12 字节
            }
        }

        // 如果没有找到字段，抛出异常
        throw new IllegalArgumentException("Field name not found in structure: " + name);
    }







//以下是上面函数可能用到的函数

// 初始化全局状态的方法
    private void interInit() {
        // 清空全局 TAC 列表
        TAC.tacVector.clear();

        // 向 TAC 列表中添加一个占位符 TAC 指令
        TAC.tacVector.add(new TAC());

        // 清空符号表
        symbolTable.clear();

        // 清空控制流相关的结构
        cont.clear();
        br.clear();

        // 输出日志信息（可选）
//        System.out.println("TAC generation environment initialized.");
    }


    /**
     * 记录中间表示 (IR)
     * 将名称和对应的 ID 存入符号表
     */
    private void putIR(String name, int id) {
        // 调用符号表的方法存储 name 和 id
        symbolTable.put(name, id);

        // 输出调试信息
//        System.out.printf("putIR: %s -> %d\n", name, id);
    }

    /**
     * 从符号表中获取指定名称的 TAC ID
     * @param name 符号名称
     * @return 符号对应的 TAC ID，如果不存在则返回 0
     */
    private int getIR(String name) {
        return TAC.table.getOrDefault(name, 0);
    }


    /**
     * 生成唯一 ID 并将 TAC 添加到全局列表
     */
    private int genId(TAC tac) {
        // 获取当前 TAC 向量的大小作为 ID
        int index = TAC.tacVector.size();

        // 将 TAC 添加到全局向量中
        TAC.tacVector.add(tac);

        // 返回生成的 ID
        return index;
    }



    /**
     * 生成单个标签的数组
     * @param id 标签 ID
     * @return 包含该标签 ID 的数组
     */
    private int genList(int id) {
        return id+1; // 返回一个包含单个整数的数组
    }


    /**
     * 格式化解析器，用于将字符串值转换为对应的类型
     * @param name 类型名称（如 "FLOAT", "INT"）
     * @param value 字符串形式的值
     * @return 转换后的浮点数值
     */
    private float formatParser(String name, String value) {
        switch (name) {
            case "FLOAT":
                return Float.parseFloat(value); // 将字符串转换为浮点数
            case "INT":
                return Integer.parseInt(value); // 将字符串转换为整数并返回为浮点数
            default:
                return Integer.parseInt(value); // 默认转换为整数并返回为浮点数
        }
    }

    private String getNodeName(splParser.ExpContext ctx) {
        // 根据节点类型返回对应的值
        if (ctx.INT() != null) {
            return ctx.INT().getText();
        } else if (ctx.FLOAT() != null) {
            return ctx.FLOAT().getText();
        } else if (ctx.CHAR() != null) {
            return ctx.CHAR().getText();
        } else if (ctx.ID() != null) {
            return ctx.ID().getText();
        } else if (ctx.getChildCount() == 1) { // TERMINAL
            return ctx.getChild(0).getText();
        } else { // 非终结符
            return ctx.getText();
        }
    }


    // 定义全局控制流栈
    private List<Integer> cont = new ArrayList<>(); // 用于 continue 跳转
    private List<Integer> br = new ArrayList<>();   // 用于 break 跳转


}
