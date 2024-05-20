package com.lampi.deposit.model.usuario.login;

public enum UsuarioRole {
    ADM("adm"),
    USER("user");
    
    private String Login;

    UsuarioRole(String Login){this.Login = Login;}
    public String PegarUsuarioLogin(){return this.Login;}
}
/*
 * criei o enum com as credenciais pre definidas
 * criei a funcao usuariologion como parametro a string do mesmo 
 * depois chamei a funcao e a retornei 
 */