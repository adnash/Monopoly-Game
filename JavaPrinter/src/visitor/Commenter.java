// Conor Cox
// CS414
// A6

package visitor;

import syntaxtree.*;

public class Commenter extends TreeDumper {	
	private int stupidLine = 0;
	
	@Override
	public void visit(MethodDeclaration n) {
		System.out.println("/*************");
		System.out.println("New method " + n.f2.f0);
		System.out.println("*************/");
		this.startAtNextToken();
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);  
        n.f4.accept(this);
        System.out.println();
	}
	
	@Override
	public void visit(ClassDeclaration n) {
		System.out.println("/*************");
		System.out.println("New class " + n.f1.f1);
		System.out.println("*************/");
		this.startAtNextToken();
        n.f0.accept(this);
        n.f1.accept(this);

        System.out.println();
	}
	
	@Override
	public void visit(ConstructorDeclaration n) {
		System.out.println("/*************");
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
        System.out.println();
	}
	
	@Override
	public void visit(NestedClassDeclaration n) {
		System.out.println("/*************");
		System.out.println("New nested class " + n.f1.f1);
		System.out.println("*************/");
		this.startAtNextToken();
        n.f0.accept(this);
        n.f1.accept(this);
        System.out.println();
	}
	
	@Override
	public void visit(FieldDeclaration n) {
		// This is needed  for if the variable is the very first thing within a method
		// I realize that this is needed for every visit method... Will ask if spacing matters all the much in class
		
		if(stupidLine == 0){
			System.out.println();
			stupidLine++;
		}
		System.out.println("// Class variable definition begins");
		this.startAtNextToken();
		n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);  
        n.f4.accept(this);
        System.out.println("\n// Class variable definition ends");
	}
	
}
