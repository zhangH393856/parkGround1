package com.park.pojo;

public class LineTable {
    private Integer id;

    private String lineParkname;

    private String lineUsername;

    private String lineState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLineParkname() {
        return lineParkname;
    }

    public void setLineParkname(String lineParkname) {
        this.lineParkname = lineParkname == null ? null : lineParkname.trim();
    }

    public String getLineUsername() {
        return lineUsername;
    }

    public void setLineUsername(String lineUsername) {
        this.lineUsername = lineUsername == null ? null : lineUsername.trim();
    }

    public String getLineState() {
        return lineState;
    }

    public void setLineState(String lineState) {
        this.lineState = lineState == null ? null : lineState.trim();
    }
}