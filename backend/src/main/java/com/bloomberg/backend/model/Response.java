package com.bloomberg.backend.model;

import com.google.common.base.MoreObjects;

public class Response {
    private Number result;

    public Response() {
    }

    public Response(Number result) {
        this.result = result;
    }

    public Number getResult() {
        return result;
    }

    public void setResult(Number result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("result", result).toString();
    }
}
