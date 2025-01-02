
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class main {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("D:\\sf\\team-project-24spring-29\\antrlee\\gen\\test\\test_correct_2.spl"); // or System.in;
        ANTLRInputStream input = new ANTLRInputStream(is);
        splLexer lexer = new splLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        splParser parser = new splParser(tokens);
        ParseTree tree = parser.program(); // calc is the starting rule
        System.out.println("语义检查");
        EvalVisitor eval = new EvalVisitor();
        // 开始遍历语法分析树
        eval.visit(tree);

        System.out.println("LISP:");
        System.out.println(tree.toStringTree(parser));
        System.out.println();
    }
}
