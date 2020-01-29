package com.example.kaisen.model;

public enum EnemyField {
    ship("W"),
    attacked("・"),
    breaked("×"),
    empty("　"),
    enemyShip("　"),
    none("E");

    final private String label;

    EnemyField(final String label) {
        this.label=label;
    }

    public String getLabel() {
        return label;
    }
}
