//
// Generated by JTB 1.3.1
//

package EDU.purdue.jtb.syntaxtree;

/**
 * Grammar production:
 * f0 -> [ PackageDeclaration() ]
 * f1 -> ( ImportDeclaration() )*
 * f2 -> ( TypeDeclaration() )*
 */
public class CompilationUnit implements Node {
   public NodeOptional f0;
   public NodeListOptional f1;
   public NodeListOptional f2;

   public CompilationUnit(NodeOptional n0, NodeListOptional n1, NodeListOptional n2) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
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

