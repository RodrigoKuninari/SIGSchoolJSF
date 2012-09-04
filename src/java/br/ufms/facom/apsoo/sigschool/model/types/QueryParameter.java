/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.apsoo.sigschool.model.types;

/**
 *
 * @author Rodrigo Kuninari
 */
public class QueryParameter {

    private String name;
    private Object value;

    public QueryParameter(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
