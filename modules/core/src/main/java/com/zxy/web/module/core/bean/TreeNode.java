package com.zxy.web.module.core.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 树结点
 *
 * 并且作为在数据库有树结构的表数据的父类
 *
 * @author James
 */
public class TreeNode implements Serializable {
    /** 树结点的ID */
    private String id;
    /** 结点的名称 */
    @JsonProperty("text")
    private String nodeName;
    /** 结点的内容 */
    @JsonProperty("value")
    private String content;
    /** 树结点的父类 */
    @JsonBackReference
    private TreeNode parent;
    private Boolean expanded;
    private Boolean leaf;
    private String href;

    /** 此结点下面的所有的子结点 */
    @JsonProperty("children")
    @JsonManagedReference
    private List<TreeNode> childTreeNodeList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public List<TreeNode> getChildTreeNodeList() {
        return childTreeNodeList;
    }

    public void setChildTreeNodeList(List<TreeNode> childTreeNodeList) {
        this.childTreeNodeList = childTreeNodeList;
    }

    public Boolean getExpanded() {
        return expanded;
    }

    public void setExpanded(Boolean expanded) {
        this.expanded = expanded;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
