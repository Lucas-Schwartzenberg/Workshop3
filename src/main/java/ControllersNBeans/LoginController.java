/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllersNBeans;

import Entity.Account;
import SessionBean.AccountFacade;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author lucas
 */
@Named(value = "loginController")
@Dependent
public class LoginController {
    
    Account login;
    
    @Inject
    AccountFacade accountFacade;
    
    public LoginController(){
        login = new Account();
    }
        
}
