/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.usuario;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


/**
 *
 * @author rhuansouza
 */

@Entity
public class Usuario implements Serializable{
    
    
    
    @Id
    @GeneratedValue
    private Integer codigo;
    private String nome;
    private String email;
    @org.hibernate.annotations.NaturalId
    private String login;
    private String senha;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date nascimento;
    private String celular;
    private String idioma;
    private boolean ativo;
   
    
    @ElementCollection(targetClass = String.class)
    @JoinTable(
            name="usuario_permissao",
            uniqueConstraints={@UniqueConstraint(columnNames={"usuario","permissao"})},
            joinColumns=@JoinColumn(name="usuario"))
    @Column(name="permissao",length=50)
    private Set<String> permissao = new HashSet<String>();
    
    
    private static final long serialVersionUID = -2276215792742363279L;

    public Set<String> getPermissao() {
        return permissao;
    }

    public void setPermissao(Set<String> permissao) {
        this.permissao = permissao;
    }
       
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        hash = 71 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 71 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 71 * hash + (this.login != null ? this.login.hashCode() : 0);
        hash = 71 * hash + (this.senha != null ? this.senha.hashCode() : 0);
        hash = 71 * hash + (this.nascimento != null ? this.nascimento.hashCode() : 0);
        hash = 71 * hash + (this.celular != null ? this.celular.hashCode() : 0);
        hash = 71 * hash + (this.idioma != null ? this.idioma.hashCode() : 0);
        hash = 71 * hash + (this.ativo ? 1 : 0);
        hash = 71 * hash + (this.permissao != null ? this.permissao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.codigo != other.codigo && (this.codigo == null || !this.codigo.equals(other.codigo))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if ((this.login == null) ? (other.login != null) : !this.login.equals(other.login)) {
            return false;
        }
        if ((this.senha == null) ? (other.senha != null) : !this.senha.equals(other.senha)) {
            return false;
        }
        if (this.nascimento != other.nascimento && (this.nascimento == null || !this.nascimento.equals(other.nascimento))) {
            return false;
        }
        if ((this.celular == null) ? (other.celular != null) : !this.celular.equals(other.celular)) {
            return false;
        }
        if ((this.idioma == null) ? (other.idioma != null) : !this.idioma.equals(other.idioma)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        if (this.permissao != other.permissao && (this.permissao == null || !this.permissao.equals(other.permissao))) {
            return false;
        }
        return true;
    }

   
    
    
    
   
    
    

    
}
