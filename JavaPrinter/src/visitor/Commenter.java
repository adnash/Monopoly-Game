package visitor;

import java.util.Enumeration;

import syntaxtree.NodeToken;

public class Commenter extends TreeDumper {	private int curLine = 1;
	private int curColumn = 1;
	private boolean startAtNextToken = false;
	private boolean printSpecials = true;
	
	
	@Override
	public void visit(NodeToken n) {
		if ( n.beginLine == -1 || n.beginColumn == -1 ) {
			printToken(n.tokenImage);
			return;
		}

		if ( startAtNextToken ) {
			curLine = n.beginLine;
			curColumn = 1;
			startAtNextToken = false;

			if ( n.beginColumn < curColumn )
				out.println();
		}

		//
		// Check for invalid token position relative to current position.
		//
		if ( n.beginLine < curLine )
			throw new IllegalStateException("at token \"" + n.tokenImage +
					"\", n.beginLine = " + Integer.toString(n.beginLine) +
					", curLine = " + Integer.toString(curLine));
		else if ( n.beginLine == curLine && n.beginColumn < curColumn )
			throw new IllegalStateException("at token \"" + n.tokenImage +
					"\", n.beginColumn = " +
					Integer.toString(n.beginColumn) + ", curColumn = " +
					Integer.toString(curColumn));

		//
		// Handle special tokens
		//
		if ( printSpecials && n.numSpecials() > 0 )
			for ( Enumeration e = n.specialTokens.elements(); e.hasMoreElements(); )
				visit((NodeToken)e.nextElement());

		//
		// Move output "cursor" to proper location, then print the token
		//
		if ( curLine < n.beginLine ) {
			curColumn = 1;
			for ( ; curLine < n.beginLine; ++curLine )
				out.println();
		}

		for ( ; curColumn < n.beginColumn; ++curColumn )
			out.print(" ");
		
		

		System.out.println(">" + n.tokenImage + "<");
//		printToken(n.tokenImage);
	}

	private void printToken(String s) {
		for ( int i = 0; i < s.length(); ++i ) { 
			if ( s.charAt(i) == '\n' ) {
				++curLine;
				curColumn = 1;
			}
			else
				curColumn++;

			out.print(s.charAt(i));
		}

		out.flush();
	}
}
