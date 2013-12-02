package com.zxy.web.module.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

/**
 * 树
 *
 * @author James
 */
public class Tree implements Serializable {

    // 这两个字段的含义就是为了以后如果转移到其他的TREE的时候可以方便的使用。
    // 因为我们这里是使用的BOOTSTRAP-TREE他的JSON格式必须是这种样子的
    @JsonIgnore
    private String treeId;
    @JsonIgnore
    private String treeName;

    private List<TreeNode> nodes;

    public List<TreeNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<TreeNode> nodes) {
        this.nodes = nodes;
    }

    public String getTreeId() {
        return treeId;
    }

    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }
}
