import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 定义 TAC 父类
public class TAC {
    public int address; // 地址
    public String name; // 名称
    public GlobalType type; // 符号类型
    public boolean swapFlag = false; // 用于指令翻译时的标记

    // 构造函数
    public TAC() {
        this.swapFlag = false;
    }

    // 转换为字符串的方法，子类可以重写
    public String toString() {
        return "";
    }

    // 生成唯一的ID
    public int generateID() {
        int ID = tacVector.size();
        tacVector.add(this);
        return ID;
    }

    // 静态成员，用于存储所有的TAC指令
    public static List<TAC> tacVector = new ArrayList<>();

    // 静态符号表
    public static Map<String, Integer> table = new HashMap<>();

    // 静态常量，表示基本类型的大小
    public static final int BASIC_SIZE = 4;

    // 将地址转换为字符串
    // 将地址转换为字符串的方法
    public static String addrToStr(int addr) {
        if (addr > 0) {
            // 正地址返回 tX 格式
            return String.format("t%d", addr);
        } else {
            // 负地址返回 #Y 格式
            return String.format("#%d", -addr);
        }
    }

    // 将操作符转换为字符串 (操作符定义需要根据具体实现添加)
    // 定义在 TAC 类中


    // 根据全局类型和字段名获取偏移量
    public static int getOffset(GlobalType globalType, String name) {
        // 假定根据字段名计算偏移量的逻辑，具体可以根据实际需求完善
        if (globalType.structFields != null && globalType.structFields.containsKey(name)) {
            return BASIC_SIZE * new ArrayList<>(globalType.structFields.keySet()).indexOf(name);
        }
        return -1; // 未找到对应字段时返回-1
    }
}

// LabelTAC 子类，继承自 TAC
 class LabelTAC extends TAC {

    // 构造函数，初始化 Label 的地址
    public LabelTAC(int address) {
        this.address = address;
    }

    // 重写 toString 方法，返回对应的 LABEL 指令字符串
    @Override
    public String toString() {
        return String.format("LABEL label%d :", this.address);
    }
}

class DecTAC extends TAC {

    List<Integer> sizes;  // 每个维度的大小
    List<Integer> suffix; // 后缀数组，用于计算内存偏移量

    // 构造函数
    public DecTAC(int address, GlobalType type, String name, List<Integer> sizes) {
        this.address = address;
        this.type = type;
        this.name = name;
        this.sizes = sizes;

        // 计算后缀数组
        this.suffix = new ArrayList<>();
        int offset = 1;
        for (int i = sizes.size() - 1; i >= 0; i--) {
            suffix.add(0, offset);
            offset *= sizes.get(i);
        }
    }

    // 重写 toString 方法，返回 DEC 指令的字符串表示
    @Override
    public String toString() {
        int size = 1;

        // 计算所有维度的总大小
        for (int dimensionSize : sizes) {
            size *= dimensionSize;
        }

        // 如果是结构体类型，则使用结构体的 size 信息
        if (type != null && type.category == Category.STRUCTURE) {
            if (type.structFields != null) {
                size = calculateStructSize(type.structFields);
            }
        }

        // 返回格式化字符串
        return String.format("DEC t%d %d", this.address, BASIC_SIZE * size);
    }

    // 辅助方法：计算结构体的大小
    private int calculateStructSize(Map<String, GlobalType> structFields) {
        int totalSize = 0;
        for (GlobalType fieldType : structFields.values()) {
            if (fieldType.category == Category.PRIMITIVE) {
                totalSize += BASIC_SIZE; // 假设所有基础类型大小为 BASIC_SIZE
            } else if (fieldType.category == Category.ARRAY) {
                totalSize += fieldType.arrayType.size * BASIC_SIZE;
            } else if (fieldType.category == Category.STRUCTURE) {
                totalSize += calculateStructSize(fieldType.structFields);
            }
        }
        return totalSize;
    }
}

class FunctionTAC extends TAC {

    // 构造函数
    public FunctionTAC(int address, String name) {
        this.address = address; // 设置地址
        this.name = name;       // 设置函数名称
    }

    // 重写 toString 方法，返回 FUNCTION 指令的字符串表示
    @Override
    public String toString() {
        return String.format("FUNCTION %s :", this.name);
    }
}

// AssignTAC 子类，继承自 TAC
class AssignTAC extends TAC {

    int rightAddress; // 右操作数的地址

    // 构造函数
    public AssignTAC(int address, int rightAddress) {
        this.address = address;       // 设置左操作数的地址
        this.rightAddress = rightAddress; // 设置右操作数的地址
    }

    // 重写 toString 方法，返回赋值指令的字符串表示
    @Override
    public String toString() {
        return String.format("t%d := %s", this.address, addrToStr(this.rightAddress));
    }
}

// AssignAddressTAC 子类，继承自 TAC
class AssignAddressTAC extends TAC {

    private int rightAddress; // 右操作数的地址

    // 构造函数
    public AssignAddressTAC(int address, int rightAddress) {
        this.address = address;       // 设置左操作数的地址
        this.rightAddress = rightAddress; // 设置右操作数的地址
    }

    // 重写 toString 方法，返回地址赋值指令的字符串表示
    @Override
    public String toString() {
        return String.format("t%d := &t%d", this.address, this.rightAddress);
    }
}

// AssignValueTAC 子类，继承自 TAC
class AssignValueTAC extends TAC {

    private int rightAddress; // 右操作数的地址

    // 构造函数
    public AssignValueTAC(int address, int rightAddress) {
        this.address = address;       // 设置左操作数的地址
        this.rightAddress = rightAddress; // 设置右操作数的地址
    }

    // 重写 toString 方法，返回值赋值指令的字符串表示
    @Override
    public String toString() {
        return String.format("t%d := *t%d", this.address, this.rightAddress);
    }
}

// CopyValueTAC 子类，继承自 TAC
class CopyValueTAC extends TAC {

    int rightAddress; // 右操作数的地址

    // 构造函数
    public CopyValueTAC(int address, int rightAddress) {
        this.address = address;       // 设置左操作数的地址
        this.rightAddress = rightAddress; // 设置右操作数的地址
    }

    // 重写 toString 方法，返回值复制指令的字符串表示
    @Override
    public String toString() {
        return String.format("*t%d := t%d", this.address, this.rightAddress);
    }
}

// ArithmeticTAC 子类，继承自 TAC
class ArithmeticTAC extends TAC {

    private Operator op;           // 算术操作符
    private int leftAddress;       // 左操作数的地址
    private int rightAddress;      // 右操作数的地址

    // 构造函数
    public ArithmeticTAC(int address, Operator op, int leftAddress, int rightAddress) {
        this.address = address;           // 结果存储的目标地址
        this.op = op;                     // 算术操作符
        this.leftAddress = leftAddress;   // 左操作数地址
        this.rightAddress = rightAddress; // 右操作数地址
    }

    // 重写 toString 方法，返回算术指令的字符串表示
    @Override
    public String toString() {
        return String.format(
                "t%d := %s %s %s",
                this.address,
                addrToStr(this.leftAddress),
                Operator.operatorToStr(this.op),
                addrToStr(this.rightAddress)
        );
    }
}

// GOTOTAC 子类，继承自 TAC
class GOTOTAC extends TAC {

    int label; // 跳转目标的标签地址

    // 构造函数
    public GOTOTAC(int address, int label) {
        this.address = address; // 设置指令的地址
        this.label = label;     // 设置目标标签
    }

    // 重写 toString 方法，返回 GOTO 指令的字符串表示
    @Override
    public String toString() {
        return String.format("GOTO label%d", this.label);
    }
}

// IFTAC 子类，继承自 TAC
class IFTAC extends TAC {

    private Operator op;          // 条件操作符
    private int leftAddress;      // 左操作数地址
    private int rightAddress;     // 右操作数地址
    int label;            // 跳转目标的标签地址

    // 构造函数
    public IFTAC(int address, Operator op, int leftAddress, int rightAddress, int label) {
        this.address = address;        // 设置指令地址
        this.op = op;                  // 设置条件操作符
        this.leftAddress = leftAddress; // 设置左操作数地址
        this.rightAddress = rightAddress; // 设置右操作数地址
        this.label = label;            // 设置目标标签
    }

    // 重写 toString 方法，返回条件跳转指令的字符串表示
    @Override
    public String toString() {
        return String.format(
                "IF t%d %s t%d GOTO label%d",
                this.leftAddress,
                Operator.operatorToStr(this.op),
                this.rightAddress,
                this.label
        );
    }
}

// ReturnTAC 子类，继承自 TAC
class ReturnTAC extends TAC {

    private int rightAddress; // 返回值的地址

    // 构造函数
    public ReturnTAC(int address, int rightAddress) {
        this.address = address;       // 设置指令地址
        this.rightAddress = rightAddress; // 设置返回值的地址
    }

    // 重写 toString 方法，返回 RETURN 指令的字符串表示
    @Override
    public String toString() {
        return String.format("RETURN %s", addrToStr(this.rightAddress));
    }
}

class ParamTAC extends TAC {

    List<Integer> suffix; // 用于多维数组的后缀数组
    private List<Integer> sizes;  // 数组的各维度大小

    // 构造函数
    public ParamTAC(int address, GlobalType type, List<Integer> sizes) {
        this.address = address;    // 设置参数地址
        this.type = type;          // 设置参数类型
        this.sizes = new ArrayList<>(sizes); // 初始化维度大小

        // 计算后缀数组
        this.suffix = new ArrayList<>();
        int total = 1;
        for (int i = sizes.size() - 1; i >= 0; --i) {
            suffix.add(0, total);
            total *= sizes.get(i);
        }
    }

    // 重写 toString 方法，返回 PARAM 指令的字符串表示
    @Override
    public String toString() {
        return String.format("PARAM t%d", this.address);
    }
}

// ArgTAC 子类，继承自 TAC
class ArgTAC extends TAC {

    private int rightAddress; // 参数值的地址

    // 构造函数
    public ArgTAC(int address, int rightAddress) {
        this.address = address;       // 设置指令地址
        this.rightAddress = rightAddress; // 设置参数值的地址
    }

    // 重写 toString 方法，返回 ARG 指令的字符串表示
    @Override
    public String toString() {
        return String.format("ARG t%d", this.rightAddress);
    }
}

// CallTAC 子类，继承自 TAC
class CallTAC extends TAC {

    private String label; // 被调用函数的标签名

    // 构造函数
    public CallTAC(int address, String label) {
        this.address = address; // 设置结果存储的目标地址
        this.label = label;     // 设置被调用函数的标签名
    }

    // 重写 toString 方法，返回 CALL 指令的字符串表示
    @Override
    public String toString() {
        return String.format("t%d := CALL %s", this.address, this.label);
    }
}

class ReadTAC extends TAC {

    // 构造函数
    public ReadTAC(int address) {
        this.address = address; // 设置读取的目标地址
    }

    // 重写 toString 方法，返回 READ 指令的字符串表示
    @Override
    public String toString() {
        return String.format("READ t%d", this.address);
    }
}

class WriteTAC extends TAC {

    private int rightAddress; // 要输出值的地址

    // 构造函数
    public WriteTAC(int address, int rightAddress) {
        this.address = address;       // 设置指令地址
        this.rightAddress = rightAddress; // 设置要输出的值地址
    }

    // 重写 toString 方法，返回 WRITE 指令的字符串表示
    @Override
    public String toString() {
        return String.format("WRITE t%d", this.rightAddress);
    }
}

// 枚举类定义操作符
enum Operator {
    PLUS_OPERATOR,   // 加法
    MINUS_OPERATOR,  // 减法
    MUL_OPERATOR,    // 乘法
    DIV_OPERATOR,    // 除法
    LE_OPERATOR,     // 小于等于
    LT_OPERATOR,     // 小于
    GE_OPERATOR,     // 大于等于
    GT_OPERATOR,     // 大于
    NE_OPERATOR,     // 不等于
    EQ_OPERATOR;     // 等于

    // 将 Operator 枚举转换为字符串
    public static String operatorToStr(Operator op) {
        return switch (op) {
            case PLUS_OPERATOR -> "+";
            case MINUS_OPERATOR -> "-";
            case MUL_OPERATOR -> "*";
            case DIV_OPERATOR -> "/";
            case LE_OPERATOR -> "<=";
            case LT_OPERATOR -> "<";
            case GE_OPERATOR -> ">=";
            case GT_OPERATOR -> ">";
            case NE_OPERATOR -> "!=";
            case EQ_OPERATOR -> "==";
            default -> "";
        };
    }
}

// 三地址码指令类
