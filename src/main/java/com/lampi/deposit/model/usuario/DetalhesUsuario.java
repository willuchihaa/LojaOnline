

package com.lampi.deposit.model.usuario;


import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.lampi.deposit.model.usuario.login.UsuarioRole;



public class DetalhesUsuario implements UserDetails{
    private final Usuario usuario; // colocar no autorization token

    public DetalhesUsuario(Usuario all) {
        this.usuario = all;
    } // security filter

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (Usuario.UsuarioLogin == UsuarioRole.ADM){
            return List.of(
                new SimpleGrantedAuthority("SENHAADM"),
                new SimpleGrantedAuthority("SENHAUSUARIO")); /* dei override do granted autority e fiz condicionais pra senha do usuario ou admin*/
        }else{
            return List.of(new SimpleGrantedAuthority("NOVA SENHUSUARIO"));
    }
}
    @Override
    public String getPassword(){return usuario.getSenha();} // botei pra retornar ela mesma

    @Override
    public String getUsername() {return usuario.getUsername();}// botei pra retornar o emal

    @Override
    public boolean isAccountNonExpired() {return true;} //confirmei como true

    @Override
    public boolean isAccountNonLocked() {return true;}

    @Override
    public boolean isCredentialsNonExpired() {return true;}

    @Override
    public boolean isEnabled() {return true;}

    public void setCreatedAt(Date date) {
        throw new UnsupportedOperationException("Unimplemented method 'setCreatedAt'");
    } // authorization
}
