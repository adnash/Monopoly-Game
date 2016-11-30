//
// Generated by JTB 1.3.1
//

package EDU.purdue.jtb.syntaxtree;

/**
 * Grammar production:
 * f0 -> ( <IDENTIFIER> | <LOOKAHEAD_TK> | <IGNORE_CASE_TK> | <STATIC> )
 * f1 -> <ASSIGN>
 * f2 -> ( <INTEGER_LITERAL> | BooleanLiteral() | <STRING_LITERAL> )
 * f3 -> <SEMICOLON>
 */
public class OptionBinding implements Node {
   public NodeChoice f0;
   public NodeToken f1;
   public NodeChoice f2;
   public NodeToken f3;

   public OptionBinding(NodeChoice n0, NodeToken n1, NodeChoice n2, NodeToken n3) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
   }

   public OptionBinding(NodeChoice n0, NodeChoice n1) {
      f0 = n0;
      f1 = new NodeToken("=");
      f2 = n1;
      f3 = new NodeToken(";");
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

