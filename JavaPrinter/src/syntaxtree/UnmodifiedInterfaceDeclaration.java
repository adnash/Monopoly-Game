//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> "interface"
 * f1 -> <IDENTIFIER>
 * f2 -> [ "extends" NameList() ]
 * f3 -> "{"
 * f4 -> ( InterfaceMemberDeclaration() )*
 * f5 -> "}"
 */
public class UnmodifiedInterfaceDeclaration implements Node {
   public NodeToken f0;
   public NodeToken f1;
   public NodeOptional f2;
   public NodeToken f3;
   public NodeListOptional f4;
   public NodeToken f5;

   public UnmodifiedInterfaceDeclaration(NodeToken n0, NodeToken n1, NodeOptional n2, NodeToken n3, NodeListOptional n4, NodeToken n5) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
      f5 = n5;
   }

   public UnmodifiedInterfaceDeclaration(NodeToken n0, NodeOptional n1, NodeListOptional n2) {
      f0 = new NodeToken("interface");
      f1 = n0;
      f2 = n1;
      f3 = new NodeToken("{");
      f4 = n2;
      f5 = new NodeToken("}");
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

