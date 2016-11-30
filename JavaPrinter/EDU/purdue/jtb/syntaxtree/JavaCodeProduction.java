//
// Generated by JTB 1.3.1
//

package EDU.purdue.jtb.syntaxtree;

/**
 * Grammar production:
 * f0 -> <JAVACODE_TK>
 * f1 -> ResultType()
 * f2 -> <IDENTIFIER>
 * f3 -> FormalParameters()
 * f4 -> Block()
 */
public class JavaCodeProduction implements Node {
   public NodeToken f0;
   public ResultType f1;
   public NodeToken f2;
   public FormalParameters f3;
   public Block f4;

   public JavaCodeProduction(NodeToken n0, ResultType n1, NodeToken n2, FormalParameters n3, Block n4) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
   }

   public JavaCodeProduction(ResultType n0, NodeToken n1, FormalParameters n2, Block n3) {
      f0 = new NodeToken("JAVACODE");
      f1 = n0;
      f2 = n1;
      f3 = n2;
      f4 = n3;
   }

   public void accept(EDU.purdue.jtb.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(EDU.purdue.jtb.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(EDU.purdue.jtb.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(EDU.purdue.jtb.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

