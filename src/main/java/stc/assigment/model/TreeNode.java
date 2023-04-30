package stc.assigment.model;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	private List<TreeNode> children = new ArrayList<TreeNode>();
    private TreeNode parent = null;
    private Item data = null;

    public TreeNode(Item data) {
        this.data = data;
    }

    public TreeNode(Item data, TreeNode parent) {
        this.data = data;
        this.parent = parent;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setParent(TreeNode parent) {
        parent.addChild(this);
        this.parent = parent;
    }

    public void addChild(Item data) {
    	TreeNode child = new TreeNode(data);
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(TreeNode child) {
        child.setParent(this);
        this.children.add(child);
    }

    public Item getData() {
        return this.data;
    }

    public void setData(Item data) {
        this.data = data;
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        return this.children.size() == 0;
    }

    public void removeParent() {
        this.parent = null;
    }

}
