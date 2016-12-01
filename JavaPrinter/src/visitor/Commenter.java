// Conor Cox
// CS414
// A6
// Commenter.java

package visitor;

import syntaxtree.*;

public class Commenter extends TreeDumper {	
	private int stupidLine = 0;
	
	@Override
	public void visit(MethodDeclaration n) {
		System.out.println("\n/*************");
		System.out.println("New method " + n.f2.f0);
		System.out.println("*************/");
		this.startAtNextToken();
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);  
        n.f4.accept(this);
	}
	
	@Override
	public void visit(ClassDeclaration n) {
		System.out.println("/*************");
		System.out.println("New class " + n.f1.f1);
		System.out.println("*************/");
		this.startAtNextToken();
        n.f0.accept(this);
        n.f1.accept(this);

	}
	
	@Override
	public void visit(ConstructorDeclaration n) {
		System.out.println("\n/*************");
		System.out.println("New constructor " + n.f1);
		System.out.println("*************/");
		this.startAtNextToken();
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);  
        n.f4.accept(this);
        n.f5.accept(this);
        n.f6.accept(this);  
        n.f7.accept(this);
	}
	
	@Override
	public void visit(NestedClassDeclaration n) {
		System.out.println("\n/*************");
		System.out.println("New nested class " + n.f1.f1);
		System.out.println("*************/");
		this.startAtNextToken();
        n.f0.accept(this);
        n.f1.accept(this);
	}
	
	@Override
	public void visit(FieldDeclaration n) {
		System.out.println("\n// Class variable definition begins");
		this.startAtNextToken();
		n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);  
        n.f4.accept(this);
        System.out.print("\n// Class variable definition ends");
	}
	
}
