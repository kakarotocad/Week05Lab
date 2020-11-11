/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 794980
 */
public class AccountService {
    
    private Map<String, String> userMap = new HashMap<String, String>()
        {{this.put("adam", "password");
        this.put("betty", "password");}};
   
    public AccountService() {
    }

    public User login(String userName, String password){
        String storedPassword = userMap.get(userName);
        if(!userMap.containsKey(userName)){
            return null;
        } else if (password.equals(storedPassword)) {
            return new User(userName, null);
        }
        return null;
    }
    
}
