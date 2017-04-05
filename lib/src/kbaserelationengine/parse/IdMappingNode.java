package kbaserelationengine.parse;

import java.util.LinkedHashMap;
import java.util.Map;

public class IdMappingNode {
    private boolean primary = false;
    private String foreignType = null;

    private Map<String, IdMappingNode> children = null;
    
    public IdMappingNode() {
    }
    
    public Map<String, IdMappingNode> getChildren() {
        return children;
    }
    
    public void addChild(String key, IdMappingNode child) {
        if (children == null) 
            children = new LinkedHashMap<String, IdMappingNode>();
        children.put(key, child);
    }

    public boolean hasChildren() {
        return children != null && children.size() > 0;
    }
    
    public boolean isPrimary() {
        return primary;
    }
    
    public void setPrimary(boolean primary) {
        this.primary = primary;
    }
    
    public String getForeignType() {
        return foreignType;
    }
    
    public void setForeignType(String foreignType) {
        this.foreignType = foreignType;
    }

    public IdMappingNode addPath(ObjectJsonPath jsonPath, boolean primary,
            String foreignType) {
        String[] path = jsonPath.getPathItems();
        if (path.length == 0 || path[0].isEmpty()) {
            this.primary = primary;
            this.foreignType = foreignType;
            return this;
        } else {
            return addPath(path, 0, primary, foreignType);
        }
    }
    
    private IdMappingNode addPath(String[] path, int pos, boolean primary,
            String foreignType) {
        if (pos >= path.length) {
            this.primary = primary;
            this.foreignType = foreignType;
            return this;
        } else {
            String key = path[pos];
            IdMappingNode child = null;
            if (getChildren() == null || !getChildren().containsKey(key)) {
                child = new IdMappingNode();
                addChild(key, child);
            } else {
                child = getChildren().get(key);
            }
            return child.addPath(path, pos + 1, primary, foreignType);
        }
    }
}