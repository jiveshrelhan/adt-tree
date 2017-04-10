/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors;

import de.topobyte.adt.tree.TreeNode;
import de.topobyte.adt.tree.Visitor;

public abstract class PrintVisitor<T> implements Visitor<TreeNode<T>>
{

	private boolean printIndex;

	public PrintVisitor(boolean printIndex)
	{
		this.printIndex = printIndex;
	}

	protected abstract void println(String line);

	@Override
	public void visit(TreeNode<T> node, int depth, int index, int numSiblings)
	{
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			buffer.append("  ");
		}

		if (printIndex) {
			buffer.append("[");
			buffer.append(index);
			buffer.append("/");
			buffer.append(numSiblings);
			buffer.append("] ");
		}

		T element = node.getElement();
		buffer.append(element == null ? "null" : element.toString());
		println(buffer.toString());
	}

}