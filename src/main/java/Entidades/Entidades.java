/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author heidi
 */
public class Entidades {
    public Integer id;
    public String codigo;
    public String empresa;
    public String contacto;
    public String cargo_contacto;
    public String direccion;
    public String ciudad;
    public String region;
    public Integer cp;
    public String pais;
    public Integer telefono;
    public Integer fax;

    public Entidades(Integer id, String codigo, String empresa, String contacto, String cargo_contacto, String direccion, String ciudad, String region, Integer cp, String pais, Integer telefono, Integer fax) {
        this.id = id;
        this.codigo = codigo;
        this.empresa = empresa;
        this.contacto = contacto;
        this.cargo_contacto = cargo_contacto;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.region = region;
        this.cp = cp;
        this.pais = pais;
        this.telefono = telefono;
        this.fax = fax;
    }

    public Entidades() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getCargo_contacto() {
        return cargo_contacto;
    }

    public void setCargo_contacto(String cargo_contacto) {
        this.cargo_contacto = cargo_contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getFax() {
        return fax;
    }

    public void setFax(Integer fax) {
        this.fax = fax;
    }

    @Override
    public String toString() {
        return "id=" + id + ", codigo=" + codigo + ", empresa=" + empresa + ", contacto=" + contacto + ", cargo_contacto=" + cargo_contacto + ", direccion=" + direccion + ", ciudad=" + ciudad + ", region=" + region + ", cp=" + cp + ", pais=" + pais + ", telefono=" + telefono + ", fax=" + fax + '}';
    }
    
    
    
    
}
