package com.vente.voiture.util;

import java.util.ArrayList;

public class SqlParams {
    StringBuilder sqlWhere;
    ArrayList<Object> params;
    
    public StringBuilder getSqlWhere() {
        return sqlWhere;
    }
    public void setSqlWhere(StringBuilder sqlWhere) {
        this.sqlWhere = sqlWhere;
    }
    public ArrayList<Object> getParams() {
        return params;
    }
    public void setParams(ArrayList<Object> params) {
        this.params = params;
    }
    public SqlParams() {
        this.setSqlWhere(new StringBuilder());
        this.setParams(new ArrayList<Object>());
    }

    
}
